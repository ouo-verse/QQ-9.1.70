package com.tencent.mobileqq.guild.window;

import android.graphics.Bitmap;
import android.os.Build;
import android.view.PixelCopy;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a@\u0010\t\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006H\u0002\u001aD\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0007\u001a\b\u0010\u0011\u001a\u00020\u0010H\u0002\u00a8\u0006\u0012"}, d2 = {"Landroid/view/View;", "customView", "Lkotlin/Function0;", "showLiveFloat", "", "finishActivity", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "block", "d", "surfaceWrapper", "fragView", "", "windowWidth", "windowHeight", "c", "", "f", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class GuildFloatWindowAnimKt {
    @RequiresApi(26)
    public static final void c(@NotNull View surfaceWrapper, @NotNull Function0<? extends View> showLiveFloat, @NotNull Function0<Unit> finishActivity, @NotNull View fragView, float f16, float f17) {
        Intrinsics.checkNotNullParameter(surfaceWrapper, "surfaceWrapper");
        Intrinsics.checkNotNullParameter(showLiveFloat, "showLiveFloat");
        Intrinsics.checkNotNullParameter(finishActivity, "finishActivity");
        Intrinsics.checkNotNullParameter(fragView, "fragView");
        d(surfaceWrapper, showLiveFloat, finishActivity, new GuildFloatWindowAnimKt$animToFloatWindow$1(surfaceWrapper, fragView, f16, f17, showLiveFloat, finishActivity));
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, android.graphics.Bitmap] */
    private static final void d(View view, final Function0<? extends View> function0, final Function0<Unit> function02, final Function1<? super Bitmap, Unit> function1) {
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.view.ViewGroup");
        View childAt = ((ViewGroup) view).getChildAt(0);
        if (childAt instanceof SurfaceView) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            SurfaceView surfaceView = (SurfaceView) childAt;
            ?? createBitmap = Bitmap.createBitmap(surfaceView.getWidth(), surfaceView.getHeight(), Bitmap.Config.ARGB_8888);
            objectRef.element = createBitmap;
            if (Build.VERSION.SDK_INT >= 24) {
                PixelCopy.request(surfaceView, (Bitmap) createBitmap, new PixelCopy.OnPixelCopyFinishedListener() { // from class: com.tencent.mobileqq.guild.window.f
                    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
                    public final void onPixelCopyFinished(int i3) {
                        GuildFloatWindowAnimKt.e(Function1.this, objectRef, function0, function02, i3);
                    }
                }, ThreadManagerV2.getUIHandlerV2());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(Function1 block, Ref.ObjectRef bitmap, Function0 showLiveFloat, Function0 finishActivity, int i3) {
        Intrinsics.checkNotNullParameter(block, "$block");
        Intrinsics.checkNotNullParameter(bitmap, "$bitmap");
        Intrinsics.checkNotNullParameter(showLiveFloat, "$showLiveFloat");
        Intrinsics.checkNotNullParameter(finishActivity, "$finishActivity");
        if (i3 == 0) {
            T bitmap2 = bitmap.element;
            Intrinsics.checkNotNullExpressionValue(bitmap2, "bitmap");
            block.invoke(bitmap2);
        } else {
            showLiveFloat.invoke();
            finishActivity.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f() {
        Integer value = GLiveChannelCore.f226698a.t().l().getValue();
        if (value != null && value.intValue() == 1) {
            return true;
        }
        return false;
    }
}
