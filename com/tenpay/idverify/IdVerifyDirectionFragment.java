package com.tenpay.idverify;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.base.FragmentAnimation;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.Switch;
import com.tenpay.api.QFuncProxy;
import com.tenpay.marketservice.MarketServiceUtils;
import com.tenpay.realname.RealNameSource;
import com.tenpay.realname.RealNameSourceReporter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qk2.PrivacyTipConfig;
import sk2.WalletConstantsConfig;
import x05.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 42\u00020\u00012\u00020\u0002:\u00014B\u0005\u00a2\u0006\u0002\u0010\u0003J\u001a\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\b\u0010 \u001a\u00020\u001dH\u0002J\u0010\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u0010H\u0002J\b\u0010#\u001a\u00020\u001dH\u0002J\u0010\u0010$\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u0010H\u0002J\u0010\u0010%\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u0010H\u0002J\b\u0010&\u001a\u00020\rH\u0014J\b\u0010'\u001a\u00020\u001dH\u0002J\u0012\u0010(\u001a\u00020\u001d2\b\u0010)\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010*\u001a\u00020\u001d2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J&\u0010-\u001a\u0004\u0018\u00010\u00102\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u001a\u00102\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u00102\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u00103\u001a\u00020\u001dH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00065"}, d2 = {"Lcom/tenpay/idverify/IdVerifyDirectionFragment;", "Lcom/tencent/mobileqq/base/QWalletBaseFragment;", "Landroid/view/View$OnClickListener;", "()V", "agreeBtn", "Landroid/widget/Button;", "agreementContent", "Landroid/widget/TextView;", "agreementTitle", "directionPageVC", "Lcom/tenpay/idverify/IdVerifyCommonHintVC;", "disagreeBtn", "isShowDirectionLayout", "", "marketServiceContent", "marketServiceRoot", "Landroid/view/View;", "marketServiceSwitch", "Lcom/tencent/widget/Switch;", "marketServiceSwitchTitle", "marketServiceTitle", "doOnKeyDown", "keyCode", "", "event", "Landroid/view/KeyEvent;", "getFragmentAnimation", "Lcom/tencent/mobileqq/base/FragmentAnimation;", "gotoH5", "", "url", "", "initAgreementText", "initDirectionVC", "view", "initMarketService", "initOnClick", "initView", "isStatusBarImmersive", "onBackPress", NodeProps.ON_CLICK, "v", "onCreate", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "setMarketServiceSwitch", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class IdVerifyDirectionFragment extends QWalletBaseFragment implements View.OnClickListener {

    @NotNull
    public static final String KEY_SHOW_DIRECTION_LAYOUT = "show_direction_layout";

    @NotNull
    private static final String TAG = "IdVerifyDirectionFragment";
    private Button agreeBtn;
    private TextView agreementContent;
    private TextView agreementTitle;

    @Nullable
    private IdVerifyCommonHintVC directionPageVC;
    private Button disagreeBtn;
    private boolean isShowDirectionLayout = true;
    private TextView marketServiceContent;
    private View marketServiceRoot;
    private Switch marketServiceSwitch;
    private TextView marketServiceSwitchTitle;
    private TextView marketServiceTitle;

    private final void gotoH5(String url) {
        boolean z16;
        QLog.i(TAG, 2, "goto h5 url is " + url);
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        QFuncProxy.gotoH5(getOutActivity(), url, true, false);
    }

    private final void initAgreementText() {
        String replace$default;
        boolean z16;
        boolean z17;
        boolean z18;
        PrivacyTipConfig.AlertContent alertContent = ((PrivacyTipConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig(IQWalletUnitedConfigApi.QWALLET_PRIVACY_TIP_CONFIG, new PrivacyTipConfig(null, null, null, null, 15, null))).getAlertContent();
        String retMsg = alertContent.getRetMsg();
        String title = alertContent.getTitle();
        String rButton = alertContent.getRButton();
        String lButton = alertContent.getLButton();
        replace$default = StringsKt__StringsJVMKt.replace$default(retMsg, RedTouch.NEWLINE_CHAR, "\n", false, 4, (Object) null);
        CharSequence e16 = x05.c.e(replace$default, new c.InterfaceC11524c() { // from class: com.tenpay.idverify.d
            @Override // x05.c.InterfaceC11524c
            public final void onClickUrl(String str) {
                IdVerifyDirectionFragment.initAgreementText$lambda$3(IdVerifyDirectionFragment.this, str);
            }
        });
        QLog.i(TAG, 2, "agreement content is " + ((Object) e16));
        boolean z19 = false;
        if (title != null && title.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        Button button = null;
        if (!z16) {
            TextView textView = this.agreementTitle;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("agreementTitle");
                textView = null;
            }
            textView.setText(title);
        }
        if (e16 != null && e16.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (!z17) {
            TextView textView2 = this.agreementContent;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("agreementContent");
                textView2 = null;
            }
            textView2.setMovementMethod(LinkMovementMethod.getInstance());
            TextView textView3 = this.agreementContent;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("agreementContent");
                textView3 = null;
            }
            textView3.setText(e16);
        }
        if (lButton != null && lButton.length() != 0) {
            z18 = false;
        } else {
            z18 = true;
        }
        if (!z18) {
            Button button2 = this.disagreeBtn;
            if (button2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("disagreeBtn");
                button2 = null;
            }
            button2.setText(lButton);
        }
        if (rButton == null || rButton.length() == 0) {
            z19 = true;
        }
        if (!z19) {
            Button button3 = this.agreeBtn;
            if (button3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("agreeBtn");
            } else {
                button = button3;
            }
            button.setText(rButton);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAgreementText$lambda$3(IdVerifyDirectionFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.gotoH5(str);
    }

    private final void initDirectionVC(View view) {
        final RealNameSource realNameSource;
        String str;
        String str2;
        boolean z16;
        WalletConstantsConfig.NormalQuestion normalQuestion = ((WalletConstantsConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig(IQWalletUnitedConfigApi.QWALLET_COMMON_CONSTANT, new WalletConstantsConfig(null, 1, null))).getContent().getNormalQuestion();
        String title = normalQuestion.getTitle();
        final String url = normalQuestion.getUrl();
        Intent intent = getIntent();
        if (intent != null) {
            realNameSource = (RealNameSource) intent.getParcelableExtra(RealNameSource.EXTRA_KEY_SOURCE);
        } else {
            realNameSource = null;
        }
        Map<String, PrivacyTipConfig.SourceContent> d16 = ((PrivacyTipConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig(IQWalletUnitedConfigApi.QWALLET_PRIVACY_TIP_CONFIG, new PrivacyTipConfig(null, null, null, null, 15, null))).d();
        if (realNameSource != null) {
            str = realNameSource.getSourceId();
        } else {
            str = null;
        }
        PrivacyTipConfig.SourceContent sourceContent = d16.get(str);
        if (sourceContent != null) {
            String statementTip = sourceContent.getStatementTip();
            z16 = sourceContent.getHideSupportCertificate();
            str2 = statementTip;
        } else {
            String string = view.getResources().getString(R.string.f2185063w);
            Intrinsics.checkNotNullExpressionValue(string, "view.resources.getString\u2026real_name_direction_desc)");
            str2 = string;
            z16 = false;
        }
        final IdVerifyCommonHintVC idVerifyCommonHintVC = new IdVerifyCommonHintVC(getOutActivity(), view);
        idVerifyCommonHintVC.setData(ResourcesCompat.getDrawable(view.getResources(), R.drawable.olb, null), view.getResources().getString(R.string.f2185363z), str2, view.getResources().getString(R.string.f21854640), new View.OnClickListener() { // from class: com.tenpay.idverify.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                IdVerifyDirectionFragment.initDirectionVC$lambda$2$lambda$1(IdVerifyDirectionFragment.this, realNameSource, view2);
            }
        }, title, new View.OnClickListener() { // from class: com.tenpay.idverify.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                IdVerifyDirectionFragment.initDirectionVC$lambda$2$lambda$0(IdVerifyCommonHintVC.this, url, view2);
            }
        });
        idVerifyCommonHintVC.setDescSize(14.0f);
        idVerifyCommonHintVC.setDescGravity(8388611);
        if (!z16) {
            idVerifyCommonHintVC.setExtraContent(LayoutInflater.from(view.getContext()).inflate(R.layout.fyl, (ViewGroup) null, false));
        }
        if (this.isShowDirectionLayout) {
            idVerifyCommonHintVC.setVisibility(0);
        } else {
            idVerifyCommonHintVC.setVisibility(8);
        }
        this.directionPageVC = idVerifyCommonHintVC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initDirectionVC$lambda$2$lambda$0(IdVerifyCommonHintVC this_apply, String textLinkUrl, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(textLinkUrl, "$textLinkUrl");
        QFuncProxy.gotoH5(this_apply.getActivity(), textLinkUrl, true, false);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initDirectionVC$lambda$2$lambda$1(IdVerifyDirectionFragment this$0, RealNameSource realNameSource, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IdVerifyCommonHintVC idVerifyCommonHintVC = this$0.directionPageVC;
        if (idVerifyCommonHintVC != null) {
            idVerifyCommonHintVC.setVisibility(8);
        }
        RealNameSourceReporter.INSTANCE.reportIdVerifyClick(realNameSource);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void initMarketService() {
        Switch r26 = null;
        PrivacyTipConfig.ServiceContent serviceContent = ((PrivacyTipConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig(IQWalletUnitedConfigApi.QWALLET_PRIVACY_TIP_CONFIG, new PrivacyTipConfig(null, null, null, null, 15, null))).getServiceContent();
        TextView textView = this.marketServiceTitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("marketServiceTitle");
            textView = null;
        }
        textView.setText(serviceContent.getTitle());
        TextView textView2 = this.marketServiceContent;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("marketServiceContent");
            textView2 = null;
        }
        textView2.setText(serviceContent.getRetMsg());
        TextView textView3 = this.marketServiceSwitchTitle;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("marketServiceSwitchTitle");
            textView3 = null;
        }
        textView3.setText(serviceContent.getSwitchTitle());
        Switch r16 = this.marketServiceSwitch;
        if (r16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("marketServiceSwitch");
            r16 = null;
        }
        r16.setTrackResource(R.drawable.kci);
        Switch r17 = this.marketServiceSwitch;
        if (r17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("marketServiceSwitch");
        } else {
            r26 = r17;
        }
        boolean z16 = true;
        if (serviceContent.getDefaultSwitch() != 1) {
            z16 = false;
        }
        r26.setChecked(z16);
    }

    private final void initOnClick(View view) {
        Button button = this.agreeBtn;
        Button button2 = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("agreeBtn");
            button = null;
        }
        button.setOnClickListener(this);
        Button button3 = this.disagreeBtn;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("disagreeBtn");
        } else {
            button2 = button3;
        }
        button2.setOnClickListener(this);
        ((TextView) view.findViewById(R.id.ivTitleBtnLeft)).setOnClickListener(this);
    }

    private final void initView(View view) {
        View findViewById = view.findViewById(R.id.sfd);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.agreement_title)");
        this.agreementTitle = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.sfb);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.agreement_content)");
        this.agreementContent = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.f164077jd);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.agree_btn)");
        this.agreeBtn = (Button) findViewById3;
        View findViewById4 = view.findViewById(R.id.uii);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.disagree_btn)");
        this.disagreeBtn = (Button) findViewById4;
        ((TextView) view.findViewById(R.id.ivTitleName)).setText(R.string.f2189064z);
        View findViewById5 = view.findViewById(R.id.yx9);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.market_service_root)");
        this.marketServiceRoot = findViewById5;
        View findViewById6 = view.findViewById(R.id.yxb);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.market_service_title)");
        this.marketServiceTitle = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.yx8);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.market_service_content)");
        this.marketServiceContent = (TextView) findViewById7;
        View findViewById8 = view.findViewById(R.id.yxa);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.m\u2026ket_service_switch_title)");
        this.marketServiceSwitchTitle = (TextView) findViewById8;
        View findViewById9 = view.findViewById(R.id.yx_);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "view.findViewById(R.id.market_service_switch)");
        this.marketServiceSwitch = (Switch) findViewById9;
    }

    private final void onBackPress() {
        boolean z16;
        if (this.isShowDirectionLayout) {
            IdVerifyCommonHintVC idVerifyCommonHintVC = this.directionPageVC;
            if (idVerifyCommonHintVC != null && idVerifyCommonHintVC.getVisibility() == 8) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                IdVerifyCommonHintVC idVerifyCommonHintVC2 = this.directionPageVC;
                if (idVerifyCommonHintVC2 != null) {
                    idVerifyCommonHintVC2.setVisibility(0);
                    return;
                }
                return;
            }
        }
        finish();
    }

    private final void setMarketServiceSwitch() {
        Switch r06 = this.marketServiceSwitch;
        Switch r16 = null;
        if (r06 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("marketServiceSwitch");
            r06 = null;
        }
        if (r06.getVisibility() == 0) {
            Switch r07 = this.marketServiceSwitch;
            if (r07 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("marketServiceSwitch");
            } else {
                r16 = r07;
            }
            MarketServiceUtils.INSTANCE.setMarketServiceSwitch(r16.isChecked());
            return;
        }
        QLog.w(TAG, 1, "ignored setMarketServiceSwitch, marketServiceSwitch is not visible");
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int keyCode, @Nullable KeyEvent event) {
        if (keyCode == 4) {
            onBackPress();
            return true;
        }
        return super.doOnKeyDown(keyCode, event);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    @NotNull
    public FragmentAnimation getFragmentAnimation() {
        return FragmentAnimation.NONE;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    protected boolean isStatusBarImmersive() {
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            num = Integer.valueOf(v3.getId());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == R.id.f164077jd) {
            setMarketServiceSwitch();
            setResult(-1);
            finish();
        } else if (num != null && num.intValue() == R.id.ivTitleBtnLeft) {
            onBackPress();
        } else if (num != null && num.intValue() == R.id.uii) {
            finish();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        boolean z16 = false;
        if (intent != null && !intent.getBooleanExtra(KEY_SHOW_DIRECTION_LAYOUT, true)) {
            z16 = true;
        }
        this.isShowDirectionLayout = !z16;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fyk, container, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initOnClick(view);
        initAgreementText();
        initMarketService();
        initDirectionVC(view);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
