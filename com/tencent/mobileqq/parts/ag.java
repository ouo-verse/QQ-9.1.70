package com.tencent.mobileqq.parts;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.qqsettingme.api.IQQSettingMeApi;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ex;
import com.tencent.mobileqq.vip.api.IVipDataUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\r\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/parts/ag;", "Lcom/tencent/mobileqq/part/a;", "", "D9", "G9", "F9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPostThemeChanged", "onAccountChanged", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "f", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "avatarView", "Lcom/tencent/mobileqq/av;", tl.h.F, "Lcom/tencent/mobileqq/av;", "vipDataChangedCallback", "<init>", "()V", "i", "a", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ClickableViewAccessibility"})
/* loaded from: classes16.dex */
public final class ag extends com.tencent.mobileqq.part.a {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QQProAvatarView avatarView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.av vipDataChangedCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/parts/ag$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.parts.ag$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27990);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void D9() {
        final QQProAvatarView qQProAvatarView;
        View partRootView = getPartRootView();
        if (partRootView != null) {
            qQProAvatarView = (QQProAvatarView) partRootView.findViewById(R.id.unk);
        } else {
            qQProAvatarView = null;
        }
        this.avatarView = qQProAvatarView;
        if (qQProAvatarView != null) {
            MobileQQ.sMobileQQ.peekAppRuntime();
            qQProAvatarView.setEnableFrame(ex.d(Double.valueOf(0.5d)), qQProAvatarView.getContext().getColor(R.color.qui_common_border_light));
            qQProAvatarView.post(new Runnable() { // from class: com.tencent.mobileqq.parts.af
                @Override // java.lang.Runnable
                public final void run() {
                    ag.E9(QQProAvatarView.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(QQProAvatarView this_apply) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        ((IQQSettingMeApi) QRoute.api(IQQSettingMeApi.class)).setAvatarDrawableV3(this_apply);
    }

    private final void F9() {
        VideoReport.setElementId(this.avatarView, "em_bas_my_qq_data_card");
        VideoReport.setElementClickPolicy(this.avatarView, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(this.avatarView, ExposurePolicy.REPORT_NONE);
    }

    private final void G9() {
        if (this.avatarView != null && com.tencent.mobileqq.vas.ar.INSTANCE.b("shouyouye", "", "vas_qq_setting_me_v9_vip_data").isEnable(true)) {
            com.tencent.mobileqq.av avVar = new com.tencent.mobileqq.av(this.avatarView);
            String currentAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
            Intrinsics.checkNotNullExpressionValue(currentAccountUin, "app.currentAccountUin");
            ((IVipDataUtils) QRoute.api(IVipDataUtils.class)).registerVipDataChangedCallback(currentAccountUin, avVar);
            this.vipDataChangedCallback = avVar;
        }
    }

    @Override // com.tencent.mobileqq.part.a
    public void onAccountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.onAccountChanged();
        com.tencent.mobileqq.av avVar = this.vipDataChangedCallback;
        if (avVar != null) {
            String currentAccountUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
            Intrinsics.checkNotNullExpressionValue(currentAccountUin, "app.currentAccountUin");
            ((IVipDataUtils) QRoute.api(IVipDataUtils.class)).unRegisterVipDataChangedCallback(currentAccountUin, avVar);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        D9();
        F9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) savedInstanceState);
        } else {
            super.onPartCreate(activity, savedInstanceState);
            G9();
        }
    }

    @Override // com.tencent.mobileqq.part.a
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onPostThemeChanged();
        QQProAvatarView qQProAvatarView = this.avatarView;
        if (qQProAvatarView != null) {
            qQProAvatarView.setEnableFrame(ex.d(Double.valueOf(0.5d)), getContext().getColor(R.color.qui_common_border_light));
        }
    }
}
