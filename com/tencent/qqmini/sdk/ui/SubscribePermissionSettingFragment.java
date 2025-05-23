package com.tencent.qqmini.sdk.ui;

import NS_MINI_INTERFACE.INTERFACE$StGetAuthListRsp;
import NS_MINI_INTERFACE.INTERFACE$StSubscribeMessage;
import NS_MINI_INTERFACE.INTERFACE$StUserSettingInfo;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
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
import com.tencent.qqmini.sdk.model.SubscribeItemModel;
import com.tencent.qqmini.sdk.server.R;
import com.tencent.qqmini.sdk.ui.SubscribePermissionAdapter;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import com.tencent.qqmini.sdk.widget.MiniProgressDialog;
import com.tencent.qqmini.sdk.widget.MiniToast;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@MiniKeep
/* loaded from: classes23.dex */
public class SubscribePermissionSettingFragment extends MiniBaseFragment {
    public static final String EXTRA_APP_ID = "EXTRA_APP_ID";
    public static final long NOT_LOGIN_ERR_CODE = -101510007;
    public static final String TAG = "SubscribePermissionSettingFragment";
    private SubscribePermissionAdapter adapter;
    private String appId;
    AuthState authState;
    private RecyclerView.LayoutManager layoutManager;
    private MiniProgressDialog mProgress;
    private RecyclerView subscribeRecyclerView;
    private final View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.tencent.qqmini.sdk.ui.SubscribePermissionSettingFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view.getId() == R.id.ivTitleBtnLeft) {
                SubscribePermissionSettingFragment.this.getActivity().finish();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    };
    private List<SubscribeItemModel> subscribeItemList = null;
    private final SubscribePermissionAdapter.InteractiveListener interactiveListener = new SubscribePermissionAdapter.InteractiveListener() { // from class: com.tencent.qqmini.sdk.ui.SubscribePermissionSettingFragment.2
        @Override // com.tencent.qqmini.sdk.ui.SubscribePermissionAdapter.InteractiveListener
        public void onCheckedChange(int i3, boolean z16) {
            SubscribeItemModel subscribeItemModel = (SubscribeItemModel) SubscribePermissionSettingFragment.this.subscribeItemList.get(i3);
            SubscribePermissionSettingFragment.this.setChecked(i3, z16, subscribeItemModel);
            if (subscribeItemModel.getViewType() == SubscribeItemModel.SubscribeViewType.LONG_TERM_SUBSCRIBE) {
                SubscribePermissionSettingFragment.this.onLongTermSubscribeChecked(i3, z16, subscribeItemModel);
            }
            if (subscribeItemModel.getViewType() == SubscribeItemModel.SubscribeViewType.ONE_TIME_SUBSCRIBE) {
                SubscribePermissionSettingFragment.this.onOneTimeSubscribeChecked(i3, z16, subscribeItemModel, "setting.onceMsgSubscribed");
            }
            if (subscribeItemModel.getViewType() == SubscribeItemModel.SubscribeViewType.INTERACTIVE_SUBSCRIBE) {
                SubscribePermissionSettingFragment.this.onOneTimeSubscribeChecked(i3, z16, subscribeItemModel, "setting.sysMsgSubscribed");
            }
        }

        @Override // com.tencent.qqmini.sdk.ui.SubscribePermissionAdapter.InteractiveListener
        public void onClickDetail(int i3) {
            SubscribeItemModel subscribeItemModel = (SubscribeItemModel) SubscribePermissionSettingFragment.this.subscribeItemList.get(i3);
            AuthJsProxy.AuthDetailDialogResConfig authDetailDialogResConfig = new AuthJsProxy.AuthDetailDialogResConfig();
            authDetailDialogResConfig.dialogType = 2;
            authDetailDialogResConfig.curSubMsg = subscribeItemModel.getStSubscribeMessage();
            authDetailDialogResConfig.requestHeight = -1;
            authDetailDialogResConfig.requestWidth = -1;
            authDetailDialogResConfig.canceledOnTouchOutside = true;
            ((AuthJsProxy) ProxyManager.get(AuthJsProxy.class)).showAuthListViewHintDialog(SubscribePermissionSettingFragment.this.getActivity(), authDetailDialogResConfig);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissProgressDialog() {
        getActivity().runOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.ui.SubscribePermissionSettingFragment.4
            @Override // java.lang.Runnable
            public void run() {
                if (SubscribePermissionSettingFragment.this.mProgress != null) {
                    SubscribePermissionSettingFragment.this.mProgress.dismiss();
                }
            }
        });
    }

    private SubscribeItemModel getLongTermSubscribe(INTERFACE$StUserSettingInfo iNTERFACE$StUserSettingInfo) {
        if (iNTERFACE$StUserSettingInfo.authState.get() != 0) {
            SubscribeItemModel.Builder content = new SubscribeItemModel.Builder().setViewType(SubscribeItemModel.SubscribeViewType.LONG_TERM_SUBSCRIBE).setContent(iNTERFACE$StUserSettingInfo.desc.get());
            boolean z16 = true;
            if (iNTERFACE$StUserSettingInfo.authState.get() != 1) {
                z16 = false;
            }
            return content.setIsChecked(z16).build();
        }
        return null;
    }

    private List<SubscribeItemModel> getOneTimeSubscribeList(INTERFACE$StUserSettingInfo iNTERFACE$StUserSettingInfo, SubscribeItemModel.SubscribeViewType subscribeViewType) {
        ArrayList arrayList = new ArrayList();
        List<INTERFACE$StSubscribeMessage> list = iNTERFACE$StUserSettingInfo.subItems.get();
        for (int i3 = 0; i3 < list.size(); i3++) {
            INTERFACE$StSubscribeMessage iNTERFACE$StSubscribeMessage = list.get(i3);
            if (iNTERFACE$StSubscribeMessage.authState.get() != 0) {
                SubscribeItemModel.Builder content = new SubscribeItemModel.Builder().setViewType(subscribeViewType).setContent(iNTERFACE$StSubscribeMessage.example.title.get());
                boolean z16 = true;
                if (iNTERFACE$StSubscribeMessage.authState.get() != 1) {
                    z16 = false;
                }
                arrayList.add(content.setIsChecked(z16).setStSubscribeMessage(iNTERFACE$StSubscribeMessage).build());
            }
        }
        return arrayList;
    }

    private SubscribeItemModel getTitleSubscribeItemModel(String str) {
        return new SubscribeItemModel.Builder().setViewType(SubscribeItemModel.SubscribeViewType.TITLE).setContent(str).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<SubscribeItemModel> handleAuthList(boolean z16, JSONObject jSONObject) {
        SubscribeItemModel longTermSubscribe;
        ArrayList arrayList = new ArrayList();
        if (z16 && jSONObject != null) {
            QMLog.i("SubscribePermissionSettingFragment", "getSetting-getAuthList suc, ret:" + jSONObject.toString());
            Object opt = jSONObject.opt("authList");
            if (!(opt instanceof byte[])) {
                QMLog.e("SubscribePermissionSettingFragment", "getSetting-getAuthList failed, obj type error");
                return arrayList;
            }
            INTERFACE$StGetAuthListRsp iNTERFACE$StGetAuthListRsp = new INTERFACE$StGetAuthListRsp();
            try {
                iNTERFACE$StGetAuthListRsp.mergeFrom((byte[]) opt);
                List<INTERFACE$StUserSettingInfo> list = iNTERFACE$StGetAuthListRsp.settings.get();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                for (INTERFACE$StUserSettingInfo iNTERFACE$StUserSettingInfo : list) {
                    if ("setting.appMsgSubscribed".equals(iNTERFACE$StUserSettingInfo.settingItem.get()) && (longTermSubscribe = getLongTermSubscribe(iNTERFACE$StUserSettingInfo)) != null) {
                        arrayList2.add(longTermSubscribe);
                    }
                    if ("setting.onceMsgSubscribed".equals(iNTERFACE$StUserSettingInfo.settingItem.get())) {
                        arrayList3.addAll(getOneTimeSubscribeList(iNTERFACE$StUserSettingInfo, SubscribeItemModel.SubscribeViewType.ONE_TIME_SUBSCRIBE));
                    }
                    if ("setting.sysMsgSubscribed".equals(iNTERFACE$StUserSettingInfo.settingItem.get())) {
                        arrayList4.addAll(getOneTimeSubscribeList(iNTERFACE$StUserSettingInfo, SubscribeItemModel.SubscribeViewType.INTERACTIVE_SUBSCRIBE));
                    }
                }
                if (arrayList2.size() > 0) {
                    arrayList.add(getTitleSubscribeItemModel("\u5141\u8bb8\u53d1\u9001\u5185\u5bb9\u66f4\u65b0\u3001\u6d3b\u52a8\u66f4\u65b0\u7b49\u6d88\u606f"));
                    arrayList.addAll(arrayList2);
                }
                if (arrayList3.size() > 0) {
                    arrayList.add(getTitleSubscribeItemModel("\u5141\u8bb8\u53d1\u9001\u4e00\u6b21\u4ee5\u4e0b\u6d88\u606f"));
                    arrayList.addAll(arrayList3);
                }
                if (arrayList4.size() > 0) {
                    arrayList.add(getTitleSubscribeItemModel("\u5141\u8bb8\u591a\u6b21\u53d1\u9001\u4ee5\u4e0b\u6d88\u606f"));
                    arrayList.addAll(arrayList4);
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                QMLog.e("SubscribePermissionSettingFragment", "getSetting, InvalidProtocolBufferMicroException:", e16);
            }
            return arrayList;
        }
        QMLog.e("SubscribePermissionSettingFragment", "getSetting-getAuthList failed");
        return arrayList;
    }

    public static void launch(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtra("key_appid", str);
        MiniFragmentLauncher.start(context, intent, MiniFragmentLauncher.FragmentType.FRAGMENT_SUB_MSG_PERMISSION_SETTING);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLongTermSubscribeChecked(final int i3, final boolean z16, final SubscribeItemModel subscribeItemModel) {
        this.authState.setAuthState("setting.appMsgSubscribed", z16, new AsyncResult() { // from class: com.tencent.qqmini.sdk.ui.SubscribePermissionSettingFragment.8
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z17, JSONObject jSONObject) {
                final long j3;
                if (jSONObject != null) {
                    QMLog.e("SubscribePermissionSettingFragment", "onCheckedChanged, setting.appMsgSubscribed_setAuthorize:" + z17 + ",ret" + jSONObject.toString());
                    j3 = jSONObject.optLong("retCode");
                } else {
                    j3 = -1;
                }
                if (!z17 || j3 == -101510007) {
                    SubscribePermissionSettingFragment.this.getActivity().runOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.ui.SubscribePermissionSettingFragment.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (j3 == -101510007) {
                                MiniToast.makeText(SubscribePermissionSettingFragment.this.getActivity(), "\u8bf7\u6c42\u5931\u8d25\uff0c\u5c0f\u7a0b\u5e8f\u672a\u767b\u5f55", 0).show();
                            } else {
                                MiniToast.makeText(SubscribePermissionSettingFragment.this.getActivity(), "\u8bf7\u6c42\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", 0).show();
                            }
                            AnonymousClass8 anonymousClass8 = AnonymousClass8.this;
                            SubscribePermissionSettingFragment.this.setChecked(i3, !z16, subscribeItemModel);
                        }
                    });
                    SubscribePermissionSettingFragment.this.authState.setAuthState("setting.appMsgSubscribed", !z16);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onOneTimeSubscribeChecked(final int i3, final boolean z16, final SubscribeItemModel subscribeItemModel, String str) {
        int i16;
        ArrayList arrayList = new ArrayList();
        INTERFACE$StSubscribeMessage stSubscribeMessage = subscribeItemModel.getStSubscribeMessage();
        PBInt32Field pBInt32Field = stSubscribeMessage.authState;
        if (z16) {
            i16 = 1;
        } else {
            i16 = 2;
        }
        pBInt32Field.set(i16);
        arrayList.add(stSubscribeMessage);
        this.authState.updateOnceSubMsgSetting(str, z16, arrayList, new AsyncResult() { // from class: com.tencent.qqmini.sdk.ui.SubscribePermissionSettingFragment.7
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z17, JSONObject jSONObject) {
                if (!z17) {
                    SubscribePermissionSettingFragment.this.getActivity().runOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.ui.SubscribePermissionSettingFragment.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MiniToast.makeText(SubscribePermissionSettingFragment.this.getActivity(), "\u8bf7\u6c42\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", 0).show();
                            AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                            SubscribePermissionSettingFragment.this.setChecked(i3, !z16, subscribeItemModel);
                        }
                    });
                }
            }
        });
    }

    private void requestAuthList() {
        showProgressDialog();
        ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).getAuthListForSubscribe(this.appId, new AsyncResult() { // from class: com.tencent.qqmini.sdk.ui.SubscribePermissionSettingFragment.3
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                SubscribePermissionSettingFragment subscribePermissionSettingFragment = SubscribePermissionSettingFragment.this;
                subscribePermissionSettingFragment.subscribeItemList = subscribePermissionSettingFragment.handleAuthList(z16, jSONObject);
                SubscribePermissionSettingFragment.this.dismissProgressDialog();
                SubscribePermissionSettingFragment subscribePermissionSettingFragment2 = SubscribePermissionSettingFragment.this;
                subscribePermissionSettingFragment2.showSubscribeList(subscribePermissionSettingFragment2.subscribeItemList);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setChecked(final int i3, final boolean z16, final SubscribeItemModel subscribeItemModel) {
        getActivity().runOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.ui.SubscribePermissionSettingFragment.9
            @Override // java.lang.Runnable
            public void run() {
                int i16;
                INTERFACE$StSubscribeMessage stSubscribeMessage = subscribeItemModel.getStSubscribeMessage();
                if (stSubscribeMessage != null) {
                    PBInt32Field pBInt32Field = stSubscribeMessage.authState;
                    if (z16) {
                        i16 = 1;
                    } else {
                        i16 = 2;
                    }
                    pBInt32Field.set(i16);
                }
                SubscribePermissionSettingFragment.this.subscribeItemList.set(i3, new SubscribeItemModel.Builder(subscribeItemModel).setIsChecked(z16).setStSubscribeMessage(stSubscribeMessage).build());
                SubscribePermissionSettingFragment.this.adapter.setData(SubscribePermissionSettingFragment.this.subscribeItemList);
            }
        });
    }

    private void showProgressDialog() {
        getActivity().runOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.ui.SubscribePermissionSettingFragment.5
            @Override // java.lang.Runnable
            public void run() {
                if (SubscribePermissionSettingFragment.this.mProgress == null) {
                    SubscribePermissionSettingFragment.this.mProgress = new MiniProgressDialog(SubscribePermissionSettingFragment.this.getActivity());
                }
                if (!SubscribePermissionSettingFragment.this.mProgress.isShowing()) {
                    SubscribePermissionSettingFragment.this.mProgress.setMessage("\u6b63\u5728\u83b7\u53d6\u6743\u9650\u4fe1\u606f\uff0c\u8bf7\u7a0d\u5019...");
                    SubscribePermissionSettingFragment.this.mProgress.show();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSubscribeList(final List<SubscribeItemModel> list) {
        getActivity().runOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.ui.SubscribePermissionSettingFragment.6
            @Override // java.lang.Runnable
            public void run() {
                SubscribePermissionSettingFragment subscribePermissionSettingFragment = SubscribePermissionSettingFragment.this;
                subscribePermissionSettingFragment.adapter = new SubscribePermissionAdapter(list, subscribePermissionSettingFragment.interactiveListener);
                if (SubscribePermissionSettingFragment.this.layoutManager == null) {
                    SubscribePermissionSettingFragment subscribePermissionSettingFragment2 = SubscribePermissionSettingFragment.this;
                    subscribePermissionSettingFragment2.layoutManager = new LinearLayoutManager(subscribePermissionSettingFragment2.getActivity());
                    SubscribePermissionSettingFragment.this.subscribeRecyclerView.setLayoutManager(SubscribePermissionSettingFragment.this.layoutManager);
                }
                SubscribePermissionSettingFragment.this.subscribeRecyclerView.setAdapter(SubscribePermissionSettingFragment.this.adapter);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.mini_sdk_subscribe_permission_setting_layout, (ViewGroup) null);
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
        TextView textView = (TextView) view.findViewById(R.id.ivTitleBtnLeft);
        TextView textView2 = (TextView) view.findViewById(R.id.ivTitleName);
        textView.setText("\u8fd4\u56de");
        textView2.setText("\u8bbe\u7f6e");
        textView.setOnClickListener(this.onClickListener);
        this.subscribeRecyclerView = (RecyclerView) view.findViewById(R.id.subscribe_recycler_view);
        this.authState = new AuthState(getContext(), this.appId, LoginManager.getInstance().getAccount());
        requestAuthList();
    }
}
