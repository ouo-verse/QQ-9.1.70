package c00;

import android.widget.Toast;
import com.tencent.biz.pubaccount.weishi.event.WSHomePagerChangeEvent;
import com.tencent.biz.pubaccount.weishi.home.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import wz.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J,\u0010\n\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J8\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lc00/a;", "", "Lkotlin/Function0;", "", "backRecommendListener", "", "b", "isIntercept", "exitTipsShowListener", "backWSListener", "a", "Landroid/widget/Toast;", "d", "quitWSListener", "c", "Landroid/widget/Toast;", "mExitTipsToast", "", "J", "mBackClickTime", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Toast mExitTipsToast;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private long mBackClickTime;

    private final boolean a(boolean isIntercept, Function0<Unit> exitTipsShowListener, Function0<Unit> backWSListener) {
        if (System.currentTimeMillis() - this.mBackClickTime > 2000) {
            this.mBackClickTime = System.currentTimeMillis();
            this.mExitTipsToast = d();
            exitTipsShowListener.invoke();
            return true;
        }
        Toast toast = this.mExitTipsToast;
        if (toast != null) {
            toast.cancel();
        }
        backWSListener.invoke();
        return isIntercept;
    }

    private final boolean b(Function0<Unit> backRecommendListener) {
        b.b().a(new WSHomePagerChangeEvent("waterfall_tab"));
        backRecommendListener.invoke();
        return true;
    }

    private final Toast d() {
        Toast show = QQToast.makeText(BaseApplication.getContext(), R.string.x8b, 0).show();
        Intrinsics.checkNotNullExpressionValue(show, "makeText(\n            Ba\u2026TH_SHORT\n        ).show()");
        return show;
    }

    public final boolean c(boolean isIntercept, Function0<Unit> exitTipsShowListener, Function0<Unit> quitWSListener, Function0<Unit> backRecommendListener) {
        Intrinsics.checkNotNullParameter(exitTipsShowListener, "exitTipsShowListener");
        Intrinsics.checkNotNullParameter(quitWSListener, "quitWSListener");
        Intrinsics.checkNotNullParameter(backRecommendListener, "backRecommendListener");
        int c16 = c.f80807a.c();
        if (c16 != 1) {
            return c16 != 2 ? isIntercept : b(backRecommendListener);
        }
        return a(isIntercept, exitTipsShowListener, quitWSListener);
    }
}
