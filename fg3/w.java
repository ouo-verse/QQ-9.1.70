package fg3;

import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.cc.util.AIFacePolicyHelper;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.state.report.SquareReportConst;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 !2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\tR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR*\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u000f\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lfg3/w;", "", "Landroid/view/View;", "inflate", "", "d", "Landroidx/fragment/app/Fragment;", "fragment", "c", "", "i", "a", "Landroid/view/View;", "inflateView", "Lkotlin/Function0;", "b", "Lkotlin/jvm/functions/Function0;", "getOnAcceptFistScan", "()Lkotlin/jvm/functions/Function0;", tl.h.F, "(Lkotlin/jvm/functions/Function0;)V", "onAcceptFistScan", "Landroidx/fragment/app/Fragment;", "()Landroidx/fragment/app/Fragment;", "g", "(Landroidx/fragment/app/Fragment;)V", "Z", "isCheck", "()Z", "f", "(Z)V", "<init>", "()V", "e", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private View inflateView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Function0<Unit> onAcceptFistScan;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public Fragment fragment;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isCheck;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(CheckBox checkBox, w this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(SquareReportConst.Key.KEY_IS_TICK, Integer.valueOf(checkBox.isChecked() ? 1 : 0));
        Unit unit = Unit.INSTANCE;
        VideoReport.reportEvent("dt_clck", view, linkedHashMap);
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setBoolean("not_ask_again_key", checkBox.isChecked());
        Function0<Unit> function0 = this$0.onAcceptFistScan;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final Fragment b() {
        Fragment fragment = this.fragment;
        if (fragment != null) {
            return fragment;
        }
        Intrinsics.throwUninitializedPropertyAccessException("fragment");
        return null;
    }

    public final View c(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        g(fragment);
        View view = this.inflateView;
        if (view != null) {
            return view;
        }
        View inflate = LayoutInflater.from(fragment.getContext()).inflate(R.layout.dc6, (ViewGroup) null, false);
        this.inflateView = inflate;
        if (inflate != null) {
            d(inflate);
        }
        return this.inflateView;
    }

    public final void f(boolean z16) {
        this.isCheck = z16;
    }

    public final void g(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<set-?>");
        this.fragment = fragment;
    }

    public final void h(Function0<Unit> function0) {
        this.onAcceptFistScan = function0;
    }

    public final boolean i() {
        return !((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getBoolean("not_ask_again_key", false);
    }

    private final void d(View inflate) {
        TextView textView = (TextView) inflate.findViewById(R.id.pu_);
        if (textView != null) {
            textView.setText(AIFacePolicyHelper.f332552a.c(b()));
        }
        if (textView != null) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        if (textView != null) {
            textView.setHighlightColor(0);
        }
        final CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.q2h);
        if (checkBox != null) {
            checkBox.setChecked(this.isCheck);
        }
        TextView textView2 = (TextView) inflate.findViewById(R.id.plq);
        if (textView2 != null) {
            com.tencent.mobileqq.zplan.report.c cVar = com.tencent.mobileqq.zplan.report.c.f335070a;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(SquareReportConst.Key.KEY_IS_TICK, Integer.valueOf(checkBox.isChecked() ? 1 : 0));
            Unit unit = Unit.INSTANCE;
            cVar.b(textView2, "em_zplan_confirm_scan", linkedHashMap);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: fg3.v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    w.e(checkBox, this, view);
                }
            });
        }
    }
}
