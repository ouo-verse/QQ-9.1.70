package com.tencent.mobileqq.mini.activity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.utils.MiniGameMMKVUtils;
import com.tencent.mobileqq.minigame.va.util.MiniGameVAUtil;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqmini.sdk.MiniSDK;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.smtt.sdk.QbSdk;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppGameDebugSettingFragment extends IphoneTitleBarFragment {
    private static final String PREF_KEY_USE_OLD_DESKTOP = "pref_key_use_old_desktop";
    private static final String PREF_KEY_USE_PART_HOST = "pref_key_use_part_host";
    private static final String PREF_KEY_USE_SYSTEM_WEBVIEW = "pref_key_use_system_webview";
    Activity activity;
    private MMKVOptionEntity entity = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
    private SharedPreferences sharedPreferences;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.mini.activity.MiniAppGameDebugSettingFragment$3, reason: invalid class name */
    /* loaded from: classes33.dex */
    class AnonymousClass3 implements CompoundButton.OnCheckedChangeListener {
        AnonymousClass3() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
            MiniAppGameDebugSettingFragment.this.sharedPreferences.edit().putBoolean(MiniAppGameDebugSettingFragment.PREF_KEY_USE_SYSTEM_WEBVIEW, z16).apply();
            if (z16) {
                MiniAppGameDebugSettingFragment.this.startTitleProgress();
                ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.mini.activity.MiniAppGameDebugSettingFragment.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QbSdk.reset(MiniAppGameDebugSettingFragment.this.getBaseActivity());
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.mini.activity.MiniAppGameDebugSettingFragment.3.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                MiniAppGameDebugSettingFragment.this.stopTitleProgress();
                            }
                        });
                    }
                });
            }
        }
    }

    public static boolean disableUseSystemWebView(Context context) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onViewCreated$0(CompoundButton compoundButton, boolean z16) {
        MiniGameMMKVUtils.INSTANCE.saveBool("enable_triton_debug_so", z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onViewCreated$1(CompoundButton compoundButton, boolean z16) {
        MiniGameMMKVUtils.INSTANCE.saveBool("enable_minigame_jsLib_debug", z16);
    }

    public static boolean shouldAlwaysUseNullListForLoadingAdSelect() {
        return false;
    }

    public static boolean shouldUseSystemWebView(Context context) {
        return false;
    }

    public static boolean shouleUseOldDeskTop() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.bmv;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
        this.sharedPreferences = getBaseActivity().app.getApp().getSharedPreferences(MiniConst.EnvSwitchActivityConst.KEY_ENV_SWITCH, 4);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(final View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        view.findViewById(R.id.zbf).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.activity.MiniAppGameDebugSettingFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                QPublicFragmentActivity.start(view.getContext(), MiniWxAppDebugSettingFragment.class);
            }
        });
        FormSwitchItem formSwitchItem = (FormSwitchItem) view.findViewById(R.id.zbd);
        formSwitchItem.setChecked(this.entity.decodeBool(PREF_KEY_USE_PART_HOST, true));
        formSwitchItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.mini.activity.MiniAppGameDebugSettingFragment.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                MiniAppGameDebugSettingFragment.this.entity.encodeBool(MiniAppGameDebugSettingFragment.PREF_KEY_USE_PART_HOST, z16);
            }
        });
        FormSwitchItem formSwitchItem2 = (FormSwitchItem) view.findViewById(R.id.exm);
        formSwitchItem2.setChecked(this.sharedPreferences.getBoolean(PREF_KEY_USE_SYSTEM_WEBVIEW, false));
        formSwitchItem2.setOnCheckedChangeListener(new AnonymousClass3());
        FormSwitchItem formSwitchItem3 = (FormSwitchItem) view.findViewById(R.id.lvn);
        formSwitchItem3.setChecked(this.sharedPreferences.getBoolean(PREF_KEY_USE_OLD_DESKTOP, false));
        formSwitchItem3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.mini.activity.MiniAppGameDebugSettingFragment.4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                MiniAppGameDebugSettingFragment.this.sharedPreferences.edit().putBoolean(MiniAppGameDebugSettingFragment.PREF_KEY_USE_OLD_DESKTOP, z16).apply();
            }
        });
        FormSwitchItem formSwitchItem4 = (FormSwitchItem) view.findViewById(R.id.zbe);
        final SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount() + "_user_sdk_minigame_", 4);
        formSwitchItem4.setChecked(sharedPreferences.getBoolean("_minigame_start_with_sdk", false));
        formSwitchItem4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.mini.activity.MiniAppGameDebugSettingFragment.5
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                sharedPreferences.edit().putBoolean("_minigame_start_with_sdk", z16).commit();
            }
        });
        FormSwitchItem formSwitchItem5 = (FormSwitchItem) view.findViewById(R.id.f166288zb3);
        formSwitchItem5.setChecked(BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount() + "_user_sdk_miniapp_", 4).getBoolean("_miniapp_start_with_sdk", true));
        formSwitchItem5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.mini.activity.MiniAppGameDebugSettingFragment.6
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount() + "_user_sdk_miniapp_", 4).edit().putBoolean("_miniapp_start_with_sdk", z16).commit();
            }
        });
        FormSwitchItem formSwitchItem6 = (FormSwitchItem) view.findViewById(R.id.f166287zb2);
        formSwitchItem6.setChecked(sharedPreferences.getBoolean("_minigame_enable_jank_canary_brief", false));
        formSwitchItem6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.mini.activity.MiniAppGameDebugSettingFragment.7
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                sharedPreferences.edit().putBoolean("_minigame_enable_jank_canary_brief", z16).apply();
            }
        });
        FormSwitchItem formSwitchItem7 = (FormSwitchItem) view.findViewById(R.id.zb8);
        formSwitchItem7.setChecked(BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount() + "_user_ipv6only_miniapp_", 4).getBoolean("_user_ipv6only_miniapp_", false));
        formSwitchItem7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.mini.activity.MiniAppGameDebugSettingFragment.8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount() + "_user_ipv6only_miniapp_", 4).edit().putBoolean("_user_ipv6only_miniapp_", z16).commit();
            }
        });
        FormSwitchItem formSwitchItem8 = (FormSwitchItem) view.findViewById(R.id.zb7);
        formSwitchItem8.setChecked(BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount() + "_user_embedded_video_", 4).getBoolean("_user_embedded_video_", true));
        formSwitchItem8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.mini.activity.MiniAppGameDebugSettingFragment.9
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount() + "_user_embedded_video_", 4).edit().putBoolean("_user_embedded_video_", z16).commit();
            }
        });
        FormSwitchItem formSwitchItem9 = (FormSwitchItem) view.findViewById(R.id.zb6);
        formSwitchItem9.setChecked(BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount() + "_user_embedded_live_", 4).getBoolean("_user_embedded_live_", true));
        formSwitchItem9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.mini.activity.MiniAppGameDebugSettingFragment.10
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount() + "_user_embedded_live_", 4).edit().putBoolean("_user_embedded_live_", z16).commit();
            }
        });
        FormSwitchItem formSwitchItem10 = (FormSwitchItem) view.findViewById(R.id.zb9);
        formSwitchItem10.setChecked(BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount() + "_loadingad_select_use_nulllist_", 4).getBoolean("_loadingad_select_use_nulllist_", false));
        formSwitchItem10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.mini.activity.MiniAppGameDebugSettingFragment.11
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                BaseApplicationImpl.getApplication().getSharedPreferences(BaseApplicationImpl.getApplication().getRuntime().getAccount() + "_loadingad_select_use_nulllist_", 4).edit().putBoolean("_loadingad_select_use_nulllist_", z16).commit();
            }
        });
        FormSwitchItem formSwitchItem11 = (FormSwitchItem) view.findViewById(R.id.z7v);
        final MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        formSwitchItem11.setChecked(from.decodeBool(BaseApplicationImpl.getApplication().getRuntime().getAccount() + "_miniapp_container_debug_switch_containerDebugSwitch", false));
        formSwitchItem11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.mini.activity.MiniAppGameDebugSettingFragment.12
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                from.encodeBool(BaseApplicationImpl.getApplication().getRuntime().getAccount() + "_miniapp_container_debug_switch_containerDebugSwitch", z16);
                from.commitSync();
            }
        });
        MiniSDK.init(getContext());
        FormSwitchItem formSwitchItem12 = (FormSwitchItem) view.findViewById(R.id.z9p);
        formSwitchItem12.setChecked(MiniGameVAUtil.getUseWifiAndXGSwitch());
        formSwitchItem12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.mini.activity.MiniAppGameDebugSettingFragment.13
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                ((VirtualAppProxy) ProxyManager.get(VirtualAppProxy.class)).updateDualChannelDownloadSwitch(z16);
            }
        });
        FormSwitchItem formSwitchItem13 = (FormSwitchItem) view.findViewById(R.id.z9t);
        MiniGameMMKVUtils miniGameMMKVUtils = MiniGameMMKVUtils.INSTANCE;
        formSwitchItem13.setChecked(miniGameMMKVUtils.getBool("enable_triton_debug_so"));
        formSwitchItem13.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.mini.activity.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                MiniAppGameDebugSettingFragment.lambda$onViewCreated$0(compoundButton, z16);
            }
        });
        FormSwitchItem formSwitchItem14 = (FormSwitchItem) view.findViewById(R.id.z9q);
        formSwitchItem14.setChecked(miniGameMMKVUtils.getBool("enable_minigame_jsLib_debug"));
        formSwitchItem14.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.mini.activity.b
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                MiniAppGameDebugSettingFragment.lambda$onViewCreated$1(compoundButton, z16);
            }
        });
        view.findViewById(R.id.zb5).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.activity.MiniAppGameDebugSettingFragment.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String obj = ((EditText) view.findViewById(R.id.f166286zb1)).getText().toString();
                if (TextUtils.isEmpty(obj)) {
                    QQToast.makeText(MiniAppGameDebugSettingFragment.this.getActivity(), "\u8bf7\u8f93\u5165appid", 0).show();
                } else {
                    MiniSDK.startMiniApp(MiniAppGameDebugSettingFragment.this.getActivity(), obj, 1001);
                }
            }
        });
        view.findViewById(R.id.f166289zb4).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.activity.MiniAppGameDebugSettingFragment.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String obj = ((EditText) view.findViewById(R.id.zb_)).getText().toString();
                if (TextUtils.isEmpty(obj)) {
                    QQToast.makeText(MiniAppGameDebugSettingFragment.this.activity, "\u8bf7\u8f93\u5165 scheme", 0).show();
                    return;
                }
                ax c16 = bi.c((BaseQQAppInterface) MiniAppUtils.getAppInterface(), MiniAppGameDebugSettingFragment.this.activity, obj);
                if (c16 != null) {
                    c16.b();
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
