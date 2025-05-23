package com.tenpay.idverify.hint;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.base.FragmentAnimation;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.browser.BrowserPlugin;
import com.tenpay.idverify.EnumIdResultScene;
import com.tenpay.idverify.IdVerifyCommonHintVC;
import com.tenpay.idverify.hint.IdVerifyStateProcessor;
import com.tenpay.idverify.model.IdVerifyStateBean;
import com.tenpay.sdk.activity.NetBaseActivity;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 %2\u00020\u0001:\u0004%&'(B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\rH\u0014J\b\u0010\u000e\u001a\u00020\rH\u0016J\u001c\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001c\u0010\u001e\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J!\u0010!\u001a\u00020\u00102\b\u0010\"\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010#\u001a\u00020\rH\u0000\u00a2\u0006\u0002\b$R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/tenpay/idverify/hint/IdVerifyHintFragment;", "Lcom/tenpay/sdk/activity/NetBaseActivity;", "()V", "processor", "Lcom/tenpay/idverify/hint/IdVerifyHintFragment$IdVerifyHintProcessor;", "resultScene", "Lcom/tenpay/idverify/EnumIdResultScene;", "resultVC", "Lcom/tenpay/idverify/IdVerifyCommonHintVC;", "getFragmentAnimation", "Lcom/tencent/mobileqq/base/FragmentAnimation;", "getSceneFactoryByStateBean1", "isStatusBarImmersive", "", "onBackEvent", "onBlError", "", BrowserPlugin.KEY_REQUEST_URL, "", "data", "Lorg/json/JSONObject;", "onCreate", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", "onSuccess", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "view", "setTitleBar", VasWebviewConstants.KEY_PAGE_TITLE, "showBackBtn", "setTitleBar$qwallet_impl_release", "Companion", "ICgiAbility", "IFragmentAbility", "IdVerifyHintProcessor", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class IdVerifyHintFragment extends NetBaseActivity {

    @NotNull
    public static final String KEY_RESULT_SCENE = "KEY_RESULT_SCENE";

    @Nullable
    private IdVerifyHintProcessor processor;

    @NotNull
    private EnumIdResultScene resultScene = EnumIdResultScene.UNKNOWN;
    private IdVerifyCommonHintVC resultVC;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\t"}, d2 = {"Lcom/tenpay/idverify/hint/IdVerifyHintFragment$ICgiAbility;", "", "onBlError", "", BrowserPlugin.KEY_REQUEST_URL, "", "data", "Lorg/json/JSONObject;", "onSuccess", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public interface ICgiAbility {
        void onBlError(@Nullable String requestUrl, @Nullable JSONObject data);

        void onSuccess(@Nullable String requestUrl, @Nullable JSONObject data);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tenpay/idverify/hint/IdVerifyHintFragment$IFragmentAbility;", "", "onBackEvent", "", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public interface IFragmentAbility {
        boolean onBackEvent();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tenpay/idverify/hint/IdVerifyHintFragment$IdVerifyHintProcessor;", "", "setVCData", "", "vc", "Lcom/tenpay/idverify/IdVerifyCommonHintVC;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public interface IdVerifyHintProcessor {
        void setVCData(@NotNull IdVerifyCommonHintVC vc5);
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EnumIdResultScene.values().length];
            try {
                iArr[EnumIdResultScene.SCENE_STATE_INFO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumIdResultScene.SCENE_VERIFY_FINISH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumIdResultScene.SCENE_VERIFY_HAS_SUCCEED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumIdResultScene.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final IdVerifyHintProcessor getSceneFactoryByStateBean1() {
        int i3 = WhenMappings.$EnumSwitchMapping$0[this.resultScene.ordinal()];
        if (i3 != 1) {
            int i16 = 2;
            if (i3 != 2) {
                IdVerifyStateBean idVerifyStateBean = null;
                byte b16 = 0;
                if (i3 != 3) {
                    if (i3 == 4) {
                        return new IdVerifyUnknownProcessor(this, null, 2, null);
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return new IdVerifyHasSucceedProcessor(this, idVerifyStateBean, i16, b16 == true ? 1 : 0);
            }
            return new IdVerifyFinishProcessor(this);
        }
        return IdVerifyStateProcessor.Factory.INSTANCE.build(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTitleBar$lambda$2(IdVerifyHintFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.doOnBackPressed();
        EventCollector.getInstance().onViewClicked(view);
    }

    public static /* synthetic */ void setTitleBar$qwallet_impl_release$default(IdVerifyHintFragment idVerifyHintFragment, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        idVerifyHintFragment.setTitleBar$qwallet_impl_release(str, z16);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment
    @NotNull
    public FragmentAnimation getFragmentAnimation() {
        return FragmentAnimation.NONE;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment
    protected boolean isStatusBarImmersive() {
        return true;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        IFragmentAbility iFragmentAbility;
        IdVerifyHintProcessor idVerifyHintProcessor = this.processor;
        if (idVerifyHintProcessor instanceof IFragmentAbility) {
            iFragmentAbility = (IFragmentAbility) idVerifyHintProcessor;
        } else {
            iFragmentAbility = null;
        }
        if (iFragmentAbility == null) {
            return super.onBackEvent();
        }
        if (iFragmentAbility.onBackEvent()) {
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onBlError(@Nullable String requestUrl, @Nullable JSONObject data) {
        ICgiAbility iCgiAbility;
        super.onBlError(requestUrl, data);
        IdVerifyHintProcessor idVerifyHintProcessor = this.processor;
        if (idVerifyHintProcessor instanceof ICgiAbility) {
            iCgiAbility = (ICgiAbility) idVerifyHintProcessor;
        } else {
            iCgiAbility = null;
        }
        if (iCgiAbility != null) {
            iCgiAbility.onBlError(requestUrl, data);
        }
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Serializable serializable;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        EnumIdResultScene enumIdResultScene = null;
        if (arguments != null) {
            serializable = arguments.getSerializable(KEY_RESULT_SCENE);
        } else {
            serializable = null;
        }
        if (serializable instanceof EnumIdResultScene) {
            enumIdResultScene = (EnumIdResultScene) serializable;
        }
        if (enumIdResultScene == null) {
            enumIdResultScene = EnumIdResultScene.UNKNOWN;
        }
        this.resultScene = enumIdResultScene;
        QLog.i(((NetBaseActivity) this).TAG, 1, "arguments=" + getArguments());
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View it = inflater.inflate(R.layout.fyn, container, false);
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this.resultVC = new IdVerifyCommonHintVC(activity, it);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, it);
        return it;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(@Nullable String requestUrl, @Nullable JSONObject data) {
        ICgiAbility iCgiAbility;
        super.onSuccess(requestUrl, data);
        IdVerifyHintProcessor idVerifyHintProcessor = this.processor;
        if (idVerifyHintProcessor instanceof ICgiAbility) {
            iCgiAbility = (ICgiAbility) idVerifyHintProcessor;
        } else {
            iCgiAbility = null;
        }
        if (iCgiAbility != null) {
            iCgiAbility.onSuccess(requestUrl, data);
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        IdVerifyHintProcessor sceneFactoryByStateBean1 = getSceneFactoryByStateBean1();
        IdVerifyCommonHintVC idVerifyCommonHintVC = this.resultVC;
        if (idVerifyCommonHintVC == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resultVC");
            idVerifyCommonHintVC = null;
        }
        sceneFactoryByStateBean1.setVCData(idVerifyCommonHintVC);
        this.processor = sceneFactoryByStateBean1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0013, code lost:
    
        if (r3 == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setTitleBar$qwallet_impl_release(@Nullable String pageTitle, boolean showBackBtn) {
        boolean z16;
        IdVerifyCommonHintVC idVerifyCommonHintVC = null;
        if (!showBackBtn) {
            if (pageTitle != null && pageTitle.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
        }
        IdVerifyCommonHintVC idVerifyCommonHintVC2 = this.resultVC;
        if (idVerifyCommonHintVC2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resultVC");
            idVerifyCommonHintVC2 = null;
        }
        idVerifyCommonHintVC2.getRootView().findViewById(R.id.jo9).setVisibility(0);
        if (showBackBtn) {
            IdVerifyCommonHintVC idVerifyCommonHintVC3 = this.resultVC;
            if (idVerifyCommonHintVC3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resultVC");
                idVerifyCommonHintVC3 = null;
            }
            ((TextView) idVerifyCommonHintVC3.getRootView().findViewById(R.id.ivTitleBtnLeft)).setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.idverify.hint.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    IdVerifyHintFragment.setTitleBar$lambda$2(IdVerifyHintFragment.this, view);
                }
            });
        }
        IdVerifyCommonHintVC idVerifyCommonHintVC4 = this.resultVC;
        if (idVerifyCommonHintVC4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("resultVC");
        } else {
            idVerifyCommonHintVC = idVerifyCommonHintVC4;
        }
        ((TextView) idVerifyCommonHintVC.getRootView().findViewById(R.id.ivTitleName)).setText(pageTitle);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
