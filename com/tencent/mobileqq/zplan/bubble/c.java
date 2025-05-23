package com.tencent.mobileqq.zplan.bubble;

import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import kotlin.Metadata;
import yi3.e;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003J\u000f\u0010\u0004\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H&J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\r\u001a\u00020\u000bH&J\b\u0010\u000e\u001a\u00020\u000bH&J\b\u0010\u000f\u001a\u00020\u000bH&J\b\u0010\u0010\u001a\u00020\u000bH&J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H&R\u0014\u0010\u0017\u001a\u00020\u00148&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/zplan/bubble/c;", "Lyi3/e;", "T", "", "c", "()Lyi3/e;", "newBubbleInfo", "", "b", "Landroid/view/View$OnClickListener;", "listener", "", "setOnClickListener", "onCreate", "onShow", "onHide", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/widget/FrameLayout;", "newParent", "a", "Landroid/graphics/Rect;", "d", "()Landroid/graphics/Rect;", "globalVisibleRect", "isClickable", "()Z", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public interface c<T extends yi3.e> {
    void a(FrameLayout newParent);

    boolean b(yi3.e newBubbleInfo);

    T c();

    Rect d();

    boolean isClickable();

    void onCreate();

    void onDestroy();

    void onHide();

    void onShow();

    void setOnClickListener(View.OnClickListener listener);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public static final class a {
        public static <T extends yi3.e> void a(c<T> cVar, View.OnClickListener onClickListener) {
        }
    }
}
