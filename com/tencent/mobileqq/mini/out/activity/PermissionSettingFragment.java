package com.tencent.mobileqq.mini.out.activity;

import NS_MINI_INTERFACE.INTERFACE$StGetAuthListRsp;
import NS_MINI_INTERFACE.INTERFACE$StUserSettingInfo;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.biz.richframework.compat.f;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForMini;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.activity.SubscribePermissionSettingFragment;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.manager.MiniGameUserAgreementManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class PermissionSettingFragment extends IphoneTitleBarFragment implements CompoundButton.OnCheckedChangeListener {
    public static final String KEY_APPID = "key_appid";
    private static final int KEY_IGNORE_CHECK_CHANGE = -1;
    public static final String KEY_IS_MINI_GAME = "key_is_mini_game";
    public static final String KEY_NAME = "key_name";
    private static final String TAG = "com.tencent.mobileqq.mini.out.activity.PermissionSettingFragment";
    public static boolean hasCancel = false;
    private PermissionListAdapter adapter;
    String appId;
    AuthorizeCenter authorizeCenter;
    private boolean isMiniGame;
    private ListView mPermissionListView;
    private TextView mPermissionNoneTextView;
    private QQProgressDialog mProgress;
    MiniAppInterface miniAppInterface;
    private TextView miniAppNameDesc;

    private void handleCheckChanged(final CompoundButton compoundButton, final boolean z16, final String str) {
        final MiniAppCmdInterface miniAppCmdInterface = new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.out.activity.PermissionSettingFragment.3
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public void onCmdListener(boolean z17, JSONObject jSONObject) {
                QLog.e(PermissionSettingFragment.TAG, 1, "onCheckedChanged, setAuthorize:" + z17 + ",ret" + jSONObject);
                final long optLong = jSONObject != null ? jSONObject.optLong("retCode") : -1L;
                if (!z17 || optLong == -101510007) {
                    PermissionSettingFragment.this.getBaseActivity().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.mini.out.activity.PermissionSettingFragment.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (optLong == -101510007) {
                                QQToast.makeText(PermissionSettingFragment.this.getBaseActivity(), PermissionSettingFragment.this.getString(R.string.iuj), 0).show();
                            } else {
                                QQToast.makeText(PermissionSettingFragment.this.getBaseActivity(), PermissionSettingFragment.this.getString(R.string.iuo), 0).show();
                            }
                        }
                    });
                    PermissionSettingFragment.this.resetStatus(str, z16, compoundButton);
                }
            }
        };
        if (!z16 && !hasCancel) {
            hasCancel = true;
            QQCustomDialog qQCustomDialog = new QQCustomDialog(getBaseActivity(), R.style.qZoneInputDialog);
            qQCustomDialog.setContentView(R.layout.f167856jn);
            qQCustomDialog.setTitle(HardCodeUtil.qqStr(R.string.p0v)).setMessage(HardCodeUtil.qqStr(R.string.p0o)).setPositiveButton(HardCodeUtil.qqStr(R.string.p0t), Color.parseColor("#5B6B92"), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.mini.out.activity.PermissionSettingFragment.5
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    PermissionSettingFragment.this.adapter.changeChecked(str, z16);
                    PermissionSettingFragment.this.authorizeCenter.setAuthorize(str, z16, miniAppCmdInterface);
                }
            }).setNegativeButton(HardCodeUtil.qqStr(R.string.j6l), Color.parseColor("#000000"), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.mini.out.activity.PermissionSettingFragment.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    compoundButton.setTag(-1, Boolean.TRUE);
                    compoundButton.setChecked(true);
                }
            });
            qQCustomDialog.show();
        } else {
            this.adapter.changeChecked(str, z16);
            this.authorizeCenter.setAuthorize(str, z16, miniAppCmdInterface);
        }
        reportCheckedChanged(str, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSettingUI(String str) {
        AuthorizeCenter authorizeCenter = this.authorizeCenter;
        List<AuthorizeCenter.AuthorizeInfo> authorizeList = authorizeCenter != null ? authorizeCenter.getAuthorizeList(6) : null;
        final BaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            QLog.e(TAG, 1, "getBaseActivity() is null!");
            return;
        }
        this.adapter = new PermissionListAdapter(baseActivity, this, new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.out.activity.PermissionSettingFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SubscribePermissionSettingFragment.launch(baseActivity, PermissionSettingFragment.this.appId);
            }
        });
        if (authorizeList != null) {
            List<AuthorizeCenter.AuthorizeInfo> arrayList = new ArrayList<>(authorizeList);
            if (needShowSubMsgPermissionItem(arrayList)) {
                int i3 = 0;
                while (true) {
                    if (i3 >= arrayList.size()) {
                        break;
                    }
                    AuthorizeCenter.AuthorizeInfo authorizeInfo = arrayList.get(i3);
                    if ("setting.appMsgSubscribed".equals(authorizeInfo.scopeName)) {
                        arrayList.remove(authorizeInfo);
                        break;
                    }
                    i3++;
                }
                arrayList.add(new AuthorizeCenter.AuthorizeInfo("setting.appMsgSubscribed", 1));
            }
            if (arrayList.size() > 0) {
                this.mPermissionListView.setVisibility(0);
                if (!TextUtils.isEmpty(str)) {
                    this.miniAppNameDesc.setVisibility(0);
                    this.miniAppNameDesc.setText(String.format(HardCodeUtil.qqStr(R.string.iuk), str));
                }
                this.adapter.setScopeList(arrayList);
            } else {
                this.mPermissionNoneTextView.setText(str + HardCodeUtil.qqStr(R.string.p0x));
                this.mPermissionNoneTextView.setVisibility(0);
            }
            this.mPermissionListView.setAdapter((ListAdapter) this.adapter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onCheckedChanged$1(CompoundButton compoundButton, String str, Boolean bool) {
        QLog.d(TAG, 1, "onCheckedChanged showUserAgreement result=" + bool);
        if (bool.booleanValue()) {
            handleCheckChanged(compoundButton, true, str);
            return null;
        }
        resetStatus(str, true, compoundButton);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$0() {
        MiniGameUserAgreementManager.f348129b.f(this.appId);
    }

    public static void launch(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtra("key_appid", str);
        PublicFragmentActivity.b.a(context, intent, PublicFragmentActivityForMini.class, PermissionSettingFragment.class);
    }

    public static void launchForResult(Activity activity, String str, String str2, boolean z16, int i3) {
        Intent intent = new Intent();
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtra("key_appid", str);
        intent.putExtra("key_name", str2);
        intent.putExtra(KEY_IS_MINI_GAME, z16);
        PublicFragmentActivity.b.d(activity, intent, PublicFragmentActivityForMini.class, PermissionSettingFragment.class, i3);
        reportWithAppId(str, "user_click", "more_button", "setting");
    }

    private void reportCheckedChanged(String str, boolean z16) {
        String str2;
        String str3;
        String str4;
        String str5;
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1506768692:
                if (str.equals("setting.sysMsgSubscribed")) {
                    c16 = 0;
                    break;
                }
                break;
            case -1019094005:
                if (str.equals(AuthorizeCenter.SCOPE_RECENT_COLORSIGN)) {
                    c16 = 1;
                    break;
                }
                break;
            case -73476616:
                if (str.equals("setting.appMsgSubscribed")) {
                    c16 = 2;
                    break;
                }
                break;
            case 583039347:
                if (str.equals(AuthorizeCenter.SCOPE_USER_INFO)) {
                    c16 = 3;
                    break;
                }
                break;
            case 812894620:
                if (str.equals("setting.onceMsgSubscribed")) {
                    c16 = 4;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                if (z16) {
                    str2 = MiniProgramLpReportDC04239.MORE_SET_RESERVERS_SYS_MSG_SUBSCRIBED_ON;
                } else {
                    str2 = MiniProgramLpReportDC04239.MORE_SET_RESERVERS_SYS_MSG_SUBSCRIBED_OFF;
                }
                str3 = MiniProgramLpReportDC04239.MINI_GAME_SUB_ACTION_SYS_MSG_SUBSCRIBED;
                String str6 = str3;
                str4 = str2;
                str5 = str6;
                break;
            case 1:
                if (z16) {
                    str2 = MiniProgramLpReportDC04239.MORE_SET_RESERVERS_RECENT_COLOR_SIGN_ON;
                } else {
                    str2 = MiniProgramLpReportDC04239.MORE_SET_RESERVERS_RECENT_COLOR_SIGN_OFF;
                }
                str3 = MiniProgramLpReportDC04239.MINI_GAME_SUB_ACTION_RECENT_COLOR_SIGN;
                String str62 = str3;
                str4 = str2;
                str5 = str62;
                break;
            case 2:
                if (z16) {
                    str2 = MiniProgramLpReportDC04239.MORE_SET_RESERVERS_APP_MSG_SUBSCRIBED_ON;
                } else {
                    str2 = MiniProgramLpReportDC04239.MORE_SET_RESERVERS_APP_MSG_SUBSCRIBED_OFF;
                }
                str3 = MiniProgramLpReportDC04239.MINI_GAME_SUB_ACTION_APP_MSG_SUBSCRIBED;
                String str622 = str3;
                str4 = str2;
                str5 = str622;
                break;
            case 3:
                if (z16) {
                    str2 = MiniProgramLpReportDC04239.MORE_SET_RESERVERS_PROFILE_ON;
                } else {
                    str2 = MiniProgramLpReportDC04239.MORE_SET_RESERVERS_PROFILE_OFF;
                }
                str3 = "profile";
                String str6222 = str3;
                str4 = str2;
                str5 = str6222;
                break;
            case 4:
                if (z16) {
                    str2 = MiniProgramLpReportDC04239.MORE_SET_RESERVERS_ONCE_MSG_SUBSCRIBED_ON;
                } else {
                    str2 = MiniProgramLpReportDC04239.MORE_SET_RESERVERS_ONCE_MSG_SUBSCRIBED_OFF;
                }
                str3 = MiniProgramLpReportDC04239.MINI_GAME_SUB_ACTION_ONCE_MSG_SUBSCRIBED;
                String str62222 = str3;
                str4 = str2;
                str5 = str62222;
                break;
            default:
                str5 = null;
                str4 = null;
                break;
        }
        reportWithAppId(this.appId, "set", str5, str4);
    }

    private static void reportWithAppId(String str, String str2, String str3, String str4) {
        MiniAppInfo miniAppInfo = new MiniAppInfo();
        miniAppInfo.appId = str;
        MiniProgramLpReportDC04239.reportAsync(new MiniAppConfig(miniAppInfo), str2, str3, str4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetStatus(String str, boolean z16, CompoundButton compoundButton) {
        this.adapter.changeChecked(str, !z16);
        compoundButton.setTag(-1, Boolean.TRUE);
        compoundButton.setChecked(!z16);
        this.authorizeCenter.setAuthorize(str, !z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f168278s3;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return true;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(final CompoundButton compoundButton, boolean z16) {
        final String str = (String) compoundButton.getTag();
        String str2 = TAG;
        QLog.d(str2, 1, "onCheckedChanged scopeName:" + str + ", isChecked=" + z16);
        Object tag = compoundButton.getTag(-1);
        if ((tag instanceof Boolean) && ((Boolean) tag).booleanValue()) {
            QLog.d(str2, 1, "onCheckedChanged ignoreCheckChange");
            compoundButton.setTag(-1, Boolean.FALSE);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        FragmentActivity activity = getActivity();
        if (z16 && activity != null && this.isMiniGame) {
            MiniGameUserAgreementManager miniGameUserAgreementManager = MiniGameUserAgreementManager.f348129b;
            if (miniGameUserAgreementManager.j(this.appId)) {
                com.tencent.qqmini.sdk.launcher.model.MiniAppInfo miniAppInfo = new com.tencent.qqmini.sdk.launcher.model.MiniAppInfo();
                miniAppInfo.appId = this.appId;
                miniGameUserAgreementManager.k(activity, miniAppInfo, new Function1() { // from class: com.tencent.mobileqq.mini.out.activity.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit lambda$onCheckedChanged$1;
                        lambda$onCheckedChanged$1 = PermissionSettingFragment.this.lambda$onCheckedChanged$1(compoundButton, str, (Boolean) obj);
                        return lambda$onCheckedChanged$1;
                    }
                });
                return;
            }
        }
        handleCheckChanged(compoundButton, z16, str);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        AppInterface appInterface = getBaseActivity().getAppInterface();
        if (appInterface instanceof MiniAppInterface) {
            this.miniAppInterface = (MiniAppInterface) appInterface;
        }
        this.appId = getBaseActivity().getIntent().getStringExtra("key_appid");
        final String stringExtra = getBaseActivity().getIntent().getStringExtra("key_name");
        if (!TextUtils.isEmpty(this.appId) && this.miniAppInterface != null) {
            boolean booleanExtra = getBaseActivity().getIntent().getBooleanExtra(KEY_IS_MINI_GAME, false);
            this.isMiniGame = booleanExtra;
            if (booleanExtra) {
                ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.out.activity.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        PermissionSettingFragment.this.lambda$onViewCreated$0();
                    }
                });
            }
            QUISecNavBar qUISecNavBar = this.quiSecNavBar;
            if (qUISecNavBar != null) {
                qUISecNavBar.setCenterText(HardCodeUtil.qqStr(R.string.f172277p10));
            }
            this.mPermissionListView = (ListView) view.findViewById(R.id.fle);
            this.mPermissionNoneTextView = (TextView) view.findViewById(R.id.flf);
            this.miniAppNameDesc = (TextView) view.findViewById(R.id.exs);
            AuthorizeCenter authorizeCenter = this.miniAppInterface.getAuthorizeCenter(this.appId);
            this.authorizeCenter = authorizeCenter;
            if (authorizeCenter == null) {
                QLog.e(TAG, 1, "getAuthorizeCenter(appId), authorizeCenter is null?!");
                return;
            }
            if (this.mProgress == null) {
                this.mProgress = new QQProgressDialog(getBaseActivity());
            }
            this.mProgress.setMessage(super.getResources().getString(R.string.cow));
            this.mProgress.show();
            MiniAppCmdUtil.getInstance().getAuthList(null, this.appId, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.out.activity.PermissionSettingFragment.1
                @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                public void onCmdListener(boolean z16, JSONObject jSONObject) {
                    if (z16 && jSONObject != null) {
                        QLog.d(PermissionSettingFragment.TAG, 1, "getSetting-getAuthList suc, ret:" + jSONObject.toString());
                        Object opt = jSONObject.opt("authList");
                        if (opt instanceof byte[]) {
                            INTERFACE$StGetAuthListRsp iNTERFACE$StGetAuthListRsp = new INTERFACE$StGetAuthListRsp();
                            try {
                                iNTERFACE$StGetAuthListRsp.mergeFrom((byte[]) opt);
                                List<INTERFACE$StUserSettingInfo> list = iNTERFACE$StGetAuthListRsp.settings.get();
                                PermissionSettingFragment.this.authorizeCenter.updateAuthList(null, list);
                                PermissionSettingFragment.this.authorizeCenter.updateAuthSettingItem(list);
                                PermissionSettingFragment.this.authorizeCenter.setAuthorizeSynchronized();
                                PermissionSettingFragment.this.getBaseActivity().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.mini.out.activity.PermissionSettingFragment.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (PermissionSettingFragment.this.getBaseActivity() != null) {
                                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                            PermissionSettingFragment.this.initSettingUI(stringExtra);
                                            PermissionSettingFragment.this.mProgress.dismiss();
                                            return;
                                        }
                                        QLog.e(PermissionSettingFragment.TAG, 1, "getBaseActivity() is null!");
                                    }
                                });
                                return;
                            } catch (InvalidProtocolBufferMicroException e16) {
                                QLog.e(PermissionSettingFragment.TAG, 1, "getSetting, InvalidProtocolBufferMicroException:" + e16);
                                e16.printStackTrace();
                            }
                        }
                    } else {
                        QLog.e(PermissionSettingFragment.TAG, 1, "getSetting-getAuthList failed");
                    }
                    PermissionSettingFragment.this.getBaseActivity().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.mini.out.activity.PermissionSettingFragment.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PermissionSettingFragment.this.getBaseActivity() != null) {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                PermissionSettingFragment.this.initSettingUI(stringExtra);
                                PermissionSettingFragment.this.mProgress.dismiss();
                                return;
                            }
                            QLog.e(PermissionSettingFragment.TAG, 1, "getBaseActivity() is null!");
                        }
                    });
                }
            });
            return;
        }
        getBaseActivity().finish();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public boolean useQUISecNavBar() {
        return true;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return ne0.a.c(this, str, cls);
    }

    private boolean needShowSubMsgPermissionItem(List<AuthorizeCenter.AuthorizeInfo> list) {
        boolean z16;
        if (list != null) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                if ("setting.appMsgSubscribed".equals(list.get(i3).scopeName)) {
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        return this.authorizeCenter.isOnceSubMaintain() || z16 || this.authorizeCenter.isSystemSubscribeMaintain();
    }

    public static void launchForResult(Activity activity, String str, String str2, int i3) {
        launchForResult(activity, str, str2, false, i3);
    }
}
