package com.tencent.qqmini.sdk.ui;

import NS_MINI_INTERFACE.INTERFACE$StGetUserSettingRsp;
import NS_MINI_INTERFACE.INTERFACE$StSubscribeMessage;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.auth.AuthState;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.AuthJsProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.ui.MiniBaseFragment;
import com.tencent.qqmini.sdk.launcher.ui.MiniFragmentLauncher;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import com.tencent.qqmini.sdk.widget.FormSwitchItem;
import com.tencent.qqmini.sdk.widget.MiniProgressDialog;
import com.tencent.qqmini.sdk.widget.MiniToast;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@MiniKeep
/* loaded from: classes23.dex */
public class SubMsgPermissionSettingFragment extends MiniBaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    public static final long NOT_LOGIN_ERR_CODE = -101510007;
    public static final String SETTING_APP_MSG_SUBSCRIBED = "setting.appMsgSubscribed";
    public static final String SETTING_APP_ONCE_MSG_SUBSCRIBED = "setting.onceMsgSubscribed";
    private static final String TAG = "com.tencent.qqmini.sdk.ui.SubMsgPermissionSettingFragment";
    public static boolean hasCancel = false;
    private SubMsgPermissionListAdapter adapter;
    String appId;
    AuthState authState;
    TextView leftBtnView;
    private MiniProgressDialog mProgress;
    private ListView onceSubMsgList;
    TextView onceSubMsgTips;
    FormSwitchItem subMsgSwitcher;
    TextView subMsgTips;
    TextView titleView;
    private boolean autoReSet = false;
    private CompoundButton.OnCheckedChangeListener subMsgCheckListener = new AnonymousClass1();
    private CompoundButton.OnCheckedChangeListener onceSubMsgCheckListener = new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.qqmini.sdk.ui.SubMsgPermissionSettingFragment.2
        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(final CompoundButton compoundButton, final boolean z16) {
            int i3;
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            if (SubMsgPermissionSettingFragment.this.autoReSet) {
                SubMsgPermissionSettingFragment.this.autoReSet = false;
            } else if (compoundButton.getTag() instanceof INTERFACE$StSubscribeMessage) {
                final INTERFACE$StSubscribeMessage iNTERFACE$StSubscribeMessage = (INTERFACE$StSubscribeMessage) compoundButton.getTag();
                PBInt32Field pBInt32Field = iNTERFACE$StSubscribeMessage.authState;
                if (z16) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                pBInt32Field.set(i3);
                ArrayList arrayList = new ArrayList();
                arrayList.add(iNTERFACE$StSubscribeMessage);
                SubMsgPermissionSettingFragment.this.authState.updateOnceSubMsgSetting(null, z16, arrayList, new AsyncResult() { // from class: com.tencent.qqmini.sdk.ui.SubMsgPermissionSettingFragment.2.1
                    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                    public void onReceiveResult(boolean z17, JSONObject jSONObject) {
                        if (z17) {
                            SubMsgPermissionSettingFragment.this.adapter.updateSubMsgItem(iNTERFACE$StSubscribeMessage, z16);
                            return;
                        }
                        MiniToast.makeText(SubMsgPermissionSettingFragment.this.getActivity(), "\u8bf7\u6c42\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", 0).show();
                        SubMsgPermissionSettingFragment.this.autoReSet = true;
                        compoundButton.setChecked(true ^ z16);
                    }
                });
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    };

    /* renamed from: com.tencent.qqmini.sdk.ui.SubMsgPermissionSettingFragment$1, reason: invalid class name */
    /* loaded from: classes23.dex */
    class AnonymousClass1 implements CompoundButton.OnCheckedChangeListener {
        AnonymousClass1() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(final CompoundButton compoundButton, final boolean z16) {
            EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
            if (SubMsgPermissionSettingFragment.this.autoReSet) {
                SubMsgPermissionSettingFragment.this.autoReSet = false;
            } else {
                final String str = (String) compoundButton.getTag();
                SubMsgPermissionSettingFragment.this.authState.setAuthState(str, z16, new AsyncResult() { // from class: com.tencent.qqmini.sdk.ui.SubMsgPermissionSettingFragment.1.1
                    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                    public void onReceiveResult(boolean z17, JSONObject jSONObject) {
                        final long j3;
                        if (jSONObject != null) {
                            QMLog.e(SubMsgPermissionSettingFragment.TAG, "onCheckedChanged, " + str + "_setAuthorize:" + z17 + ",ret" + jSONObject.toString());
                            j3 = jSONObject.optLong("retCode");
                        } else {
                            j3 = -1;
                        }
                        if (!z17 || j3 == -101510007) {
                            SubMsgPermissionSettingFragment.this.getActivity().runOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.ui.SubMsgPermissionSettingFragment.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (j3 == -101510007) {
                                        MiniToast.makeText(SubMsgPermissionSettingFragment.this.getActivity(), "\u8bf7\u6c42\u5931\u8d25\uff0c\u5c0f\u7a0b\u5e8f\u672a\u767b\u5f55", 0).show();
                                    } else {
                                        MiniToast.makeText(SubMsgPermissionSettingFragment.this.getActivity(), "\u8bf7\u6c42\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", 0).show();
                                    }
                                }
                            });
                            SubMsgPermissionSettingFragment.this.autoReSet = true;
                            compoundButton.setChecked(!z16);
                            SubMsgPermissionSettingFragment.this.authState.setAuthState(str, true ^ z16);
                        }
                    }
                });
            }
            EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnceSubscribeResponse(boolean z16, JSONObject jSONObject) {
        if (z16) {
            try {
                if (!"setting.onceMsgSubscribed".equals(jSONObject.optString("settingItem"))) {
                    QMLog.e(TAG, "handleOnceSubscribeResponse settingItem is no 'setting.onceMsgSubscribed'!");
                    return;
                }
                Object opt = jSONObject.opt("originalData");
                INTERFACE$StGetUserSettingRsp iNTERFACE$StGetUserSettingRsp = new INTERFACE$StGetUserSettingRsp();
                if (opt instanceof byte[]) {
                    iNTERFACE$StGetUserSettingRsp.mergeFrom((byte[]) opt);
                    List<INTERFACE$StSubscribeMessage> list = iNTERFACE$StGetUserSettingRsp.setting.subItems.get();
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        INTERFACE$StSubscribeMessage iNTERFACE$StSubscribeMessage = list.get(i3);
                        if (iNTERFACE$StSubscribeMessage.authState.get() != 0) {
                            arrayList.add(iNTERFACE$StSubscribeMessage);
                        }
                    }
                    if (arrayList.size() > 0) {
                        SubMsgPermissionListAdapter subMsgPermissionListAdapter = new SubMsgPermissionListAdapter(getActivity(), this);
                        this.adapter = subMsgPermissionListAdapter;
                        subMsgPermissionListAdapter.setSubMsgMaintainAuth(arrayList);
                        this.adapter.setInnerOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqmini.sdk.ui.SubMsgPermissionSettingFragment.4
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                EventCollector.getInstance().onViewClickedBefore(view);
                                if (view.getTag() instanceof INTERFACE$StSubscribeMessage) {
                                    INTERFACE$StSubscribeMessage iNTERFACE$StSubscribeMessage2 = (INTERFACE$StSubscribeMessage) view.getTag();
                                    AuthJsProxy.AuthDetailDialogResConfig authDetailDialogResConfig = new AuthJsProxy.AuthDetailDialogResConfig();
                                    authDetailDialogResConfig.dialogType = 2;
                                    authDetailDialogResConfig.curSubMsg = iNTERFACE$StSubscribeMessage2;
                                    authDetailDialogResConfig.requestHeight = -1;
                                    authDetailDialogResConfig.requestWidth = -1;
                                    authDetailDialogResConfig.canceledOnTouchOutside = true;
                                    ((AuthJsProxy) ProxyManager.get(AuthJsProxy.class)).showAuthListViewHintDialog(SubMsgPermissionSettingFragment.this.getActivity(), authDetailDialogResConfig);
                                }
                                EventCollector.getInstance().onViewClicked(view);
                            }
                        });
                        this.adapter.setInnerCheckedChangeListener(this.onceSubMsgCheckListener);
                        getActivity().runOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.ui.SubMsgPermissionSettingFragment.5
                            @Override // java.lang.Runnable
                            public void run() {
                                SubMsgPermissionSettingFragment.this.onceSubMsgTips.setVisibility(0);
                                SubMsgPermissionSettingFragment.this.onceSubMsgTips.setText("\u5141\u8bb8\u53d1\u9001\u4e00\u6b21\u4ee5\u4e0b\u6d88\u606f");
                                SubMsgPermissionSettingFragment.this.onceSubMsgList.setVisibility(0);
                                SubMsgPermissionSettingFragment.this.onceSubMsgList.setAdapter((ListAdapter) SubMsgPermissionSettingFragment.this.adapter);
                            }
                        });
                    }
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                QMLog.e(TAG, "handleOnceSubscribeResponse InvalidProtocolBufferMicroException:" + e16);
            }
        }
    }

    private void initSettingUI() {
        int authFlag = this.authState.getAuthFlag("setting.appMsgSubscribed");
        boolean z16 = true;
        if (1 != authFlag) {
            this.subMsgTips.setText("\u5141\u8bb8\u53d1\u9001\u5185\u5bb9\u66f4\u65b0\u3001\u6d3b\u52a8\u66f4\u65b0\u7b49\u6d88\u606f");
            this.subMsgSwitcher.setOnCheckedChangeListener(this.subMsgCheckListener);
            this.subMsgSwitcher.getSwitch().setTag("setting.appMsgSubscribed");
            this.subMsgSwitcher.setText("\u63a5\u53d7\u8ba2\u9605\u6d88\u606f");
            FormSwitchItem formSwitchItem = this.subMsgSwitcher;
            if (authFlag != 2) {
                z16 = false;
            }
            formSwitchItem.setChecked(z16);
            this.subMsgTips.setVisibility(0);
            this.subMsgSwitcher.setVisibility(0);
        } else {
            this.subMsgTips.setVisibility(8);
            this.subMsgSwitcher.setVisibility(8);
        }
        if (this.mProgress == null) {
            this.mProgress = new MiniProgressDialog(getActivity());
        }
        this.mProgress.setMessage("\u6b63\u5728\u83b7\u53d6\u6743\u9650\u4fe1\u606f\uff0c\u8bf7\u7a0d\u5019...");
        this.mProgress.show();
        ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).getUserSetting(this.appId, "", "setting.onceMsgSubscribed", null, new AsyncResult() { // from class: com.tencent.qqmini.sdk.ui.SubMsgPermissionSettingFragment.3
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z17, JSONObject jSONObject) {
                SubMsgPermissionSettingFragment.this.handleOnceSubscribeResponse(z17, jSONObject);
                if (SubMsgPermissionSettingFragment.this.getActivity() != null) {
                    SubMsgPermissionSettingFragment.this.getActivity().runOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.ui.SubMsgPermissionSettingFragment.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SubMsgPermissionSettingFragment.this.mProgress.dismiss();
                        }
                    });
                }
            }
        });
    }

    public static void launch(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtra("key_appid", str);
        MiniFragmentLauncher.start(context, intent, MiniFragmentLauncher.FragmentType.FRAGMENT_SUB_MSG_PERMISSION_SETTING);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.ivTitleBtnLeft) {
            getActivity().finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.mini_sdk_submsg_permission_setting_layout, (ViewGroup) null);
        if (DisplayUtil.isImmersiveSupported()) {
            inflate.setFitsSystemWindows(true);
            inflate.setPadding(0, ImmersiveUtils.getStatusBarHeight(getActivity()), 0, 0);
        }
        inflate.setBackgroundColor(Color.parseColor("#EFEFF4"));
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        String stringExtra = getActivity().getIntent().getStringExtra("key_appid");
        this.appId = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            getActivity().finish();
            return;
        }
        this.leftBtnView = (TextView) view.findViewById(R.id.ivTitleBtnLeft);
        this.titleView = (TextView) view.findViewById(R.id.ivTitleName);
        this.leftBtnView.setText("\u8fd4\u56de");
        this.titleView.setText("\u8bbe\u7f6e");
        this.leftBtnView.setOnClickListener(this);
        this.subMsgTips = (TextView) view.findViewById(R.id.sub_msg_tips);
        this.subMsgSwitcher = (FormSwitchItem) view.findViewById(R.id.sub_msg_switch);
        this.onceSubMsgTips = (TextView) view.findViewById(R.id.once_sub_msg_tips);
        this.onceSubMsgList = (ListView) view.findViewById(R.id.once_sub_msg_list);
        this.authState = new AuthState(getContext(), this.appId, LoginManager.getInstance().getAccount());
        initSettingUI();
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
    }
}
