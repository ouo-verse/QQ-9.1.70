package com.tencent.mobileqq.qqlive.widget.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J8\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qqlive/widget/util/a;", "", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "b", "Landroid/content/Context;", "context", "inputBitmap", "", "radius", "", "scale", Element.ELEMENT_NAME_TIMES, "a", "<init>", "()V", "qq-live-widget-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f274061a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38161);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f274061a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void b(Bitmap bitmap) {
        if (bitmap.getConfig() != Bitmap.Config.ARGB_8888) {
            QLog.e("CoverFeedBlurUtil", 1, new RuntimeException("blur: trying to use a not ARGB_8888 bitmap " + bitmap), new Object[0]);
        }
    }

    @Nullable
    public final Bitmap a(@NotNull Context context, @Nullable Bitmap inputBitmap, float radius, int scale, int times) {
        Allocation allocation;
        ScriptIntrinsicBlur scriptIntrinsicBlur;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, this, context, inputBitmap, Float.valueOf(radius), Integer.valueOf(scale), Integer.valueOf(times));
        }
        Intrinsics.checkNotNullParameter(context, "context");
        RenderScript renderScript = null;
        Allocation allocation2 = null;
        if (inputBitmap == null) {
            return null;
        }
        try {
            QLog.d("CoverFeedBlurUtil", 1, "blur, start times: " + times);
            b(inputBitmap);
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(inputBitmap, inputBitmap.getWidth() / scale, inputBitmap.getHeight() / scale, false);
            try {
                RenderScript create = RenderScript.create(context);
                for (int i3 = 0; i3 < times; i3++) {
                    try {
                        Allocation createFromBitmap = Allocation.createFromBitmap(create, createScaledBitmap);
                        try {
                            allocation = Allocation.createTyped(create, createFromBitmap.getType());
                            try {
                                scriptIntrinsicBlur = ScriptIntrinsicBlur.create(create, android.renderscript.Element.U8_4(create));
                            } catch (Throwable th5) {
                                th = th5;
                                scriptIntrinsicBlur = null;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            allocation = null;
                            scriptIntrinsicBlur = null;
                        }
                        try {
                            scriptIntrinsicBlur.setRadius(radius);
                            scriptIntrinsicBlur.setInput(createFromBitmap);
                            scriptIntrinsicBlur.forEach(allocation);
                            allocation.copyTo(createScaledBitmap);
                            try {
                                createFromBitmap.destroy();
                                allocation.destroy();
                                scriptIntrinsicBlur.destroy();
                            } catch (Throwable th7) {
                                th = th7;
                                renderScript = create;
                                if (renderScript != null) {
                                    renderScript.destroy();
                                }
                                throw th;
                            }
                        } catch (Throwable th8) {
                            th = th8;
                            allocation2 = createFromBitmap;
                            if (allocation2 != null) {
                                allocation2.destroy();
                            }
                            if (allocation != null) {
                                allocation.destroy();
                            }
                            if (scriptIntrinsicBlur != null) {
                                scriptIntrinsicBlur.destroy();
                            }
                            throw th;
                        }
                    } catch (Throwable th9) {
                        th = th9;
                        allocation = null;
                        scriptIntrinsicBlur = null;
                    }
                }
                if (create != null) {
                    create.destroy();
                }
                QLog.d("CoverFeedBlurUtil", 1, "blur, end ");
                return Bitmap.createScaledBitmap(createScaledBitmap, createScaledBitmap.getWidth() * scale, createScaledBitmap.getHeight() * scale, true);
            } catch (Throwable th10) {
                th = th10;
            }
        } catch (Throwable th11) {
            QLog.e("CoverFeedBlurUtil", 1, "blur, error, ", th11);
            return inputBitmap;
        }
    }
}
