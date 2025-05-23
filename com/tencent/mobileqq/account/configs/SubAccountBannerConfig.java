package com.tencent.mobileqq.account.configs;

import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qui.noticebar.QUINoticeBarManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.listitem.ab;
import com.tencent.mobileqq.widget.listitem.w;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\u0012\b\u0010\"\u001a\u0004\u0018\u00010!\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0014J&\u0010\u0012\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00032\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0014R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001b\u0010 \u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/account/configs/SubAccountBannerConfig;", "Lcom/tencent/mobileqq/widget/listitem/w;", "Landroid/view/View;", "", "action", "", "P", "", "reportId", "N", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "H", "view", "position", "", "", "payloads", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/app/QBaseActivity;", "k", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/View$OnClickListener;", "l", "Landroid/view/View$OnClickListener;", "onClickListener", "Lcom/tencent/biz/qui/noticebar/d;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "O", "()Lcom/tencent/biz/qui/noticebar/d;", "noticeBar", "Lcom/tencent/mobileqq/account/viewmodel/c;", "vm", "<init>", "(Lcom/tencent/mobileqq/account/viewmodel/c;Lcom/tencent/mobileqq/app/QBaseActivity;Landroid/view/View$OnClickListener;)V", "qqaccount-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class SubAccountBannerConfig extends w<View> {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QBaseActivity activity;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View.OnClickListener onClickListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy noticeBar;

    public SubAccountBannerConfig(@Nullable com.tencent.mobileqq.account.viewmodel.c cVar, @NotNull QBaseActivity activity, @NotNull View.OnClickListener onClickListener) {
        Lazy lazy;
        MutableLiveData<Integer> O1;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, cVar, activity, onClickListener);
            return;
        }
        this.activity = activity;
        this.onClickListener = onClickListener;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.biz.qui.noticebar.d>() { // from class: com.tencent.mobileqq.account.configs.SubAccountBannerConfig$noticeBar$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SubAccountBannerConfig.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.biz.qui.noticebar.d invoke() {
                QBaseActivity qBaseActivity;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (com.tencent.biz.qui.noticebar.d) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                QUINoticeBarManager a16 = QUINoticeBarManager.INSTANCE.a();
                qBaseActivity = SubAccountBannerConfig.this.activity;
                return a16.h(qBaseActivity);
            }
        });
        this.noticeBar = lazy;
        if (cVar != null && (O1 = cVar.O1()) != null) {
            final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.account.configs.SubAccountBannerConfig.1
                static IPatchRedirector $redirector_;

                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SubAccountBannerConfig.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke2(num);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Integer it) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    SubAccountBannerConfig subAccountBannerConfig = SubAccountBannerConfig.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    subAccountBannerConfig.P(it.intValue());
                }
            };
            O1.observe(activity, new Observer() { // from class: com.tencent.mobileqq.account.configs.h
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    SubAccountBannerConfig.K(Function1.this, obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void N(String reportId) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        ReportController.o(peekAppRuntime, "CliOper", "", "", reportId, reportId, 0, 0, "", "", "", "");
        ReportController.y(peekAppRuntime, "0X800BDF1");
    }

    private final com.tencent.biz.qui.noticebar.d O() {
        return (com.tencent.biz.qui.noticebar.d) this.noticeBar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P(int action) {
        if (action != 1) {
            if (action == 2) {
                N("0X8004456");
                return;
            }
            return;
        }
        N("0X8004001");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.w
    public void F(@NotNull View view, int position, @NotNull List<? extends Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, view, Integer.valueOf(position), payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.F(view, position, payloads);
        ab.e(view, 0);
    }

    @Override // com.tencent.mobileqq.widget.listitem.w
    @NotNull
    protected View H(@NotNull ViewGroup parent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parent);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        return O().setIcon(R.drawable.jth).setMsg(this.activity.getString(R.string.hrf)).c(this.onClickListener).getView();
    }
}
