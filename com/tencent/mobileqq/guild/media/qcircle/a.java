package com.tencent.mobileqq.guild.media.qcircle;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ6\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/media/qcircle/a;", "", "Landroid/content/Context;", "context", "Landroid/graphics/Bitmap;", "inputBitmap", "", "radius", "", "scale", Element.ELEMENT_NAME_TIMES, "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f229172a = new a();

    a() {
    }

    @Nullable
    public final Bitmap a(@NotNull Context context, @NotNull Bitmap inputBitmap, float radius, int scale, int times) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(inputBitmap, "inputBitmap");
        try {
            QLog.d("CoverFeedBlurUtil", 1, "blur, start times: " + times);
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(inputBitmap, inputBitmap.getWidth() / scale, inputBitmap.getHeight() / scale, false);
            Bitmap.Config config = createScaledBitmap.getConfig();
            Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
            if (config != config2) {
                createScaledBitmap = createScaledBitmap.copy(config2, true);
            }
            RenderScript create = RenderScript.create(context);
            for (int i3 = 0; i3 < times; i3++) {
                Allocation createFromBitmap = Allocation.createFromBitmap(create, createScaledBitmap);
                Allocation createTyped = Allocation.createTyped(create, createFromBitmap.getType());
                ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, android.renderscript.Element.U8_4(create));
                create2.setRadius(radius);
                create2.setInput(createFromBitmap);
                create2.forEach(createTyped);
                createTyped.copyTo(createScaledBitmap);
                createFromBitmap.destroy();
                createTyped.destroy();
                create2.destroy();
            }
            create.destroy();
            QLog.d("CoverFeedBlurUtil", 1, "blur, end ");
            return Bitmap.createScaledBitmap(createScaledBitmap, createScaledBitmap.getWidth() * scale, createScaledBitmap.getHeight() * scale, true);
        } catch (Throwable th5) {
            QLog.w("CoverFeedBlurUtil", 1, "blur, error", th5);
            return inputBitmap;
        }
    }
}
