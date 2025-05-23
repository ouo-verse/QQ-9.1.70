package b20;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import androidx.core.widget.PopupWindowCompat;
import b20.c;
import com.tencent.biz.pubaccount.weishi.event.WSVerticalFloatWindowEvent;
import com.tencent.biz.pubaccount.weishi.util.ah;
import com.tencent.biz.pubaccount.weishi.util.ai;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u000fB\u0011\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0004R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lb20/c;", "", "Landroid/view/View;", "anchorView", "", DomainData.DOMAIN_NAME, "", "k", "measureSpec", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "g", "l", "i", "Landroid/content/Context;", "a", "Landroid/content/Context;", "j", "()Landroid/content/Context;", "context", "Landroid/widget/PopupWindow;", "b", "Landroid/widget/PopupWindow;", "popWindow", "Landroid/os/Handler;", "c", "Landroid/os/Handler;", "guideHandler", "<init>", "(Landroid/content/Context;)V", "d", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private PopupWindow popWindow;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Handler guideHandler = new Handler(Looper.getMainLooper());

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"b20/c$b", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f27757d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ c f27758e;

        b(View view, c cVar) {
            this.f27757d = view;
            this.f27758e = cVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(View contentView, c this$0) {
            PopupWindow popupWindow;
            Intrinsics.checkNotNullParameter(contentView, "$contentView");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!contentView.isAttachedToWindow() || (popupWindow = this$0.popWindow) == null) {
                return;
            }
            popupWindow.dismiss();
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            this.f27757d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            final View inflate = LayoutInflater.from(this.f27758e.getContext()).inflate(R.layout.d1b, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(context)\n          \u2026float_window_guide, null)");
            View findViewById = inflate.findViewById(R.id.p4e);
            Intrinsics.checkNotNullExpressionValue(findViewById, "contentView.findViewById\u2026float_window_guide_arrow)");
            c cVar = this.f27758e;
            PopupWindow popupWindow = new PopupWindow(inflate, ah.b(130.0f), -2, false);
            c cVar2 = this.f27758e;
            View view = this.f27757d;
            popupWindow.setOutsideTouchable(true);
            inflate.measure(cVar2.m(popupWindow.getWidth()), cVar2.m(popupWindow.getHeight()));
            ViewGroup.LayoutParams layoutParams = ((ImageView) findViewById).getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            if (cVar2.k(view) > ba.f81743r) {
                PopupWindowCompat.showAsDropDown(popupWindow, view, -(Math.abs(popupWindow.getContentView().getMeasuredWidth() - view.getWidth()) / 2), 0, 8388611);
                layoutParams2.addRule(14);
            } else {
                PopupWindowCompat.showAsDropDown(popupWindow, view, view.getWidth() - popupWindow.getContentView().getMeasuredWidth(), 0, 8388611);
                layoutParams2.addRule(11);
                layoutParams2.rightMargin = view.getWidth() / 4;
            }
            cVar.popWindow = popupWindow;
            Handler handler = this.f27758e.guideHandler;
            final c cVar3 = this.f27758e;
            handler.postDelayed(new Runnable() { // from class: b20.d
                @Override // java.lang.Runnable
                public final void run() {
                    c.b.b(inflate, cVar3);
                }
            }, 10000L);
        }
    }

    public c(Context context) {
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(c this$0, View anchorView) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(anchorView, "$anchorView");
        this$0.n(anchorView);
        wz.b.b().a(new WSVerticalFloatWindowEvent(2));
    }

    private final void n(View anchorView) {
        anchorView.getViewTreeObserver().addOnGlobalLayoutListener(new b(anchorView, this));
    }

    public final boolean g(final View anchorView) {
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        int d16 = ai.d("floating_window_guide_times", 0);
        xz.b bVar = xz.b.f449122a;
        if (!bVar.c() || bVar.d() || d16 >= bVar.b()) {
            return false;
        }
        bVar.e(true);
        ai.m("floating_window_guide_times", d16 + 1);
        this.guideHandler.postDelayed(new Runnable() { // from class: b20.b
            @Override // java.lang.Runnable
            public final void run() {
                c.h(c.this, anchorView);
            }
        }, 350L);
        return true;
    }

    public final void i() {
        this.guideHandler.removeCallbacksAndMessages(null);
    }

    /* renamed from: j, reason: from getter */
    public final Context getContext() {
        return this.context;
    }

    public final void l() {
        PopupWindow popupWindow = this.popWindow;
        if (popupWindow == null || !popupWindow.isShowing()) {
            return;
        }
        popupWindow.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int k(View anchorView) {
        int[] iArr = new int[2];
        anchorView.getLocationOnScreen(iArr);
        return ba.o() - iArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int m(int measureSpec) {
        return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(measureSpec), measureSpec == -2 ? 0 : 1073741824);
    }
}
