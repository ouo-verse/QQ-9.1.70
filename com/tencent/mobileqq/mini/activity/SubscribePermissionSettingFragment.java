package com.tencent.mobileqq.mini.activity;

import NS_MINI_INTERFACE.INTERFACE$StGetAuthListRsp;
import NS_MINI_INTERFACE.INTERFACE$StSubscribeMessage;
import NS_MINI_INTERFACE.INTERFACE$StUserSettingInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForMini;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.mini.MiniAppInterface;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.model.SubscribeItemModel;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.ui.SubscribePermissionAdapter;
import com.tencent.mobileqq.mini.widget.AuthDetailDialog;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class SubscribePermissionSettingFragment extends PublicBaseFragment {
    public static final String EXTRA_APP_ID = "EXTRA_APP_ID";
    public static final String TAG = "SubscribePermissionSettingFragment";
    private SubscribePermissionAdapter adapter;
    private String appId;
    private AuthorizeCenter authorizeCenter;
    private RecyclerView.LayoutManager layoutManager;
    private MiniAppInterface miniAppInterface;
    private QQProgressDialog qqProgressDialog;
    private RecyclerView subscribeRecyclerView;
    private final View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.activity.SubscribePermissionSettingFragment.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.ivTitleBtnLeft) {
                SubscribePermissionSettingFragment.this.getBaseActivity().finish();
            }
        }
    };
    private List<SubscribeItemModel> subscribeItemList = null;
    private final SubscribePermissionAdapter.InteractiveListener interactiveListener = new SubscribePermissionAdapter.InteractiveListener() { // from class: com.tencent.mobileqq.mini.activity.SubscribePermissionSettingFragment.2
        @Override // com.tencent.mobileqq.mini.ui.SubscribePermissionAdapter.InteractiveListener
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

        @Override // com.tencent.mobileqq.mini.ui.SubscribePermissionAdapter.InteractiveListener
        public void onClickDetail(int i3) {
            new AuthDetailDialog(SubscribePermissionSettingFragment.this.getBaseActivity(), ((SubscribeItemModel) SubscribePermissionSettingFragment.this.subscribeItemList.get(i3)).getStSubscribeMessage(), -1, -1, 2).show();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissProgressDialog() {
        getBaseActivity().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.mini.activity.SubscribePermissionSettingFragment.4
            @Override // java.lang.Runnable
            public void run() {
                if (SubscribePermissionSettingFragment.this.qqProgressDialog != null) {
                    SubscribePermissionSettingFragment.this.qqProgressDialog.dismiss();
                }
            }
        });
    }

    private SubscribeItemModel getLongTermSubscribe(INTERFACE$StUserSettingInfo iNTERFACE$StUserSettingInfo) {
        if (iNTERFACE$StUserSettingInfo.authState.get() != 0) {
            return new SubscribeItemModel.Builder().setViewType(SubscribeItemModel.SubscribeViewType.LONG_TERM_SUBSCRIBE).setContent(iNTERFACE$StUserSettingInfo.desc.get()).setIsChecked(iNTERFACE$StUserSettingInfo.authState.get() == 1).build();
        }
        return null;
    }

    private List<SubscribeItemModel> getOneTimeSubscribeList(INTERFACE$StUserSettingInfo iNTERFACE$StUserSettingInfo, SubscribeItemModel.SubscribeViewType subscribeViewType) {
        ArrayList arrayList = new ArrayList();
        List<INTERFACE$StSubscribeMessage> list = iNTERFACE$StUserSettingInfo.subItems.get();
        for (int i3 = 0; i3 < list.size(); i3++) {
            INTERFACE$StSubscribeMessage iNTERFACE$StSubscribeMessage = list.get(i3);
            if (iNTERFACE$StSubscribeMessage.authState.get() != 0) {
                arrayList.add(new SubscribeItemModel.Builder().setViewType(subscribeViewType).setContent(iNTERFACE$StSubscribeMessage.example.title.get()).setIsChecked(iNTERFACE$StSubscribeMessage.authState.get() == 1).setStSubscribeMessage(iNTERFACE$StSubscribeMessage).build());
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
            QLog.i("SubscribePermissionSettingFragment", 1, "getSetting-getAuthList suc, ret:" + jSONObject.toString());
            Object opt = jSONObject.opt("authList");
            if (!(opt instanceof byte[])) {
                QLog.e("SubscribePermissionSettingFragment", 1, "getSetting-getAuthList failed, obj type error");
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
                    arrayList.add(getTitleSubscribeItemModel(HardCodeUtil.qqStr(R.string.f167362cq)));
                    arrayList.addAll(arrayList2);
                }
                if (arrayList3.size() > 0) {
                    arrayList.add(getTitleSubscribeItemModel(HardCodeUtil.qqStr(R.string.f167352cp)));
                    arrayList.addAll(arrayList3);
                }
                if (arrayList4.size() > 0) {
                    arrayList.add(getTitleSubscribeItemModel("\u5141\u8bb8\u591a\u6b21\u53d1\u9001\u4ee5\u4e0b\u6d88\u606f"));
                    arrayList.addAll(arrayList4);
                }
                this.authorizeCenter.updateAuthList(null, list);
                this.authorizeCenter.setAuthorizeSynchronized();
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("SubscribePermissionSettingFragment", 1, "getSetting, InvalidProtocolBufferMicroException:", e16);
            }
            return arrayList;
        }
        QLog.e("SubscribePermissionSettingFragment", 1, "getSetting-getAuthList failed");
        return arrayList;
    }

    public static void launch(Context context, String str) {
        Intent intent = new Intent();
        intent.putExtra("public_fragment_window_feature", 1);
        intent.putExtra("EXTRA_APP_ID", str);
        PublicFragmentActivity.b.a(context, intent, PublicFragmentActivityForMini.class, SubscribePermissionSettingFragment.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onLongTermSubscribeChecked(final int i3, final boolean z16, final SubscribeItemModel subscribeItemModel) {
        this.authorizeCenter.setAuthorize("setting.appMsgSubscribed", z16, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.activity.SubscribePermissionSettingFragment.8
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public void onCmdListener(boolean z17, JSONObject jSONObject) {
                final long j3;
                if (jSONObject != null) {
                    QLog.e("SubscribePermissionSettingFragment", 1, "onCheckedChanged, setting.appMsgSubscribed_setAuthorize:" + z17 + ",ret" + jSONObject.toString());
                    j3 = jSONObject.optLong("retCode");
                } else {
                    j3 = -1;
                }
                if (!z17 || j3 == -101510007) {
                    SubscribePermissionSettingFragment.this.getBaseActivity().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.mini.activity.SubscribePermissionSettingFragment.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (j3 == -101510007) {
                                QQToast.makeText(SubscribePermissionSettingFragment.this.getBaseActivity(), SubscribePermissionSettingFragment.this.getString(R.string.iuj), 0).show();
                            } else {
                                QQToast.makeText(SubscribePermissionSettingFragment.this.getBaseActivity(), SubscribePermissionSettingFragment.this.getString(R.string.iuo), 0).show();
                            }
                            AnonymousClass8 anonymousClass8 = AnonymousClass8.this;
                            SubscribePermissionSettingFragment.this.setChecked(i3, !z16, subscribeItemModel);
                        }
                    });
                    SubscribePermissionSettingFragment.this.authorizeCenter.setAuthorize("setting.appMsgSubscribed", !z16);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onOneTimeSubscribeChecked(final int i3, final boolean z16, final SubscribeItemModel subscribeItemModel, String str) {
        ArrayList arrayList = new ArrayList();
        INTERFACE$StSubscribeMessage stSubscribeMessage = subscribeItemModel.getStSubscribeMessage();
        stSubscribeMessage.authState.set(z16 ? 1 : 2);
        arrayList.add(stSubscribeMessage);
        this.authorizeCenter.updateOnceSubMsgSetting(str, z16, arrayList, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.activity.SubscribePermissionSettingFragment.7
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public void onCmdListener(boolean z17, JSONObject jSONObject) {
                if (z17) {
                    return;
                }
                SubscribePermissionSettingFragment.this.getBaseActivity().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.mini.activity.SubscribePermissionSettingFragment.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QQToast.makeText(SubscribePermissionSettingFragment.this.getBaseActivity(), SubscribePermissionSettingFragment.this.getString(R.string.iuo), 0).show();
                        AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                        SubscribePermissionSettingFragment.this.setChecked(i3, !z16, subscribeItemModel);
                    }
                });
            }
        });
    }

    private void requestAuthList() {
        showProgressDialog();
        MiniAppCmdUtil.getInstance().getAuthList(null, this.appId, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.activity.SubscribePermissionSettingFragment.3
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public void onCmdListener(boolean z16, JSONObject jSONObject) {
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
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.mini.activity.SubscribePermissionSettingFragment.9
            @Override // java.lang.Runnable
            public void run() {
                INTERFACE$StSubscribeMessage stSubscribeMessage = subscribeItemModel.getStSubscribeMessage();
                if (stSubscribeMessage != null) {
                    stSubscribeMessage.authState.set(z16 ? 1 : 2);
                }
                SubscribePermissionSettingFragment.this.subscribeItemList.set(i3, new SubscribeItemModel.Builder(subscribeItemModel).setIsChecked(z16).setStSubscribeMessage(stSubscribeMessage).build());
                SubscribePermissionSettingFragment.this.adapter.setData(SubscribePermissionSettingFragment.this.subscribeItemList);
            }
        });
    }

    private void showProgressDialog() {
        getBaseActivity().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.mini.activity.SubscribePermissionSettingFragment.5
            @Override // java.lang.Runnable
            public void run() {
                if (SubscribePermissionSettingFragment.this.qqProgressDialog == null) {
                    SubscribePermissionSettingFragment.this.qqProgressDialog = new QQProgressDialog(SubscribePermissionSettingFragment.this.getBaseActivity());
                }
                if (SubscribePermissionSettingFragment.this.qqProgressDialog.isShowing()) {
                    return;
                }
                SubscribePermissionSettingFragment.this.qqProgressDialog.setMessage(SubscribePermissionSettingFragment.this.getBaseActivity().getResources().getString(R.string.cow));
                SubscribePermissionSettingFragment.this.qqProgressDialog.show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSubscribeList(final List<SubscribeItemModel> list) {
        getBaseActivity().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.mini.activity.SubscribePermissionSettingFragment.6
            @Override // java.lang.Runnable
            public void run() {
                SubscribePermissionSettingFragment subscribePermissionSettingFragment = SubscribePermissionSettingFragment.this;
                subscribePermissionSettingFragment.adapter = new SubscribePermissionAdapter(list, subscribePermissionSettingFragment.interactiveListener);
                if (SubscribePermissionSettingFragment.this.layoutManager == null) {
                    SubscribePermissionSettingFragment subscribePermissionSettingFragment2 = SubscribePermissionSettingFragment.this;
                    subscribePermissionSettingFragment2.layoutManager = new LinearLayoutManager(subscribePermissionSettingFragment2.getBaseActivity());
                    SubscribePermissionSettingFragment.this.subscribeRecyclerView.setLayoutManager(SubscribePermissionSettingFragment.this.layoutManager);
                }
                SubscribePermissionSettingFragment.this.subscribeRecyclerView.setAdapter(SubscribePermissionSettingFragment.this.adapter);
            }
        });
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = LayoutInflater.from(getBaseActivity()).inflate(R.layout.fhv, (ViewGroup) null);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            inflate.setFitsSystemWindows(true);
            inflate.setPadding(0, ImmersiveUtils.getStatusBarHeight(getBaseActivity()), 0, 0);
        }
        return inflate;
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
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        AppInterface appInterface = getBaseActivity().getAppInterface();
        if (appInterface instanceof MiniAppInterface) {
            this.miniAppInterface = (MiniAppInterface) appInterface;
        }
        Intent intent = getBaseActivity().getIntent();
        if (intent == null) {
            QLog.e("SubscribePermissionSettingFragment", 1, "onViewCreated error! intent == null");
            getBaseActivity().finish();
            return;
        }
        String stringExtra = intent.getStringExtra("EXTRA_APP_ID");
        this.appId = stringExtra;
        if (!TextUtils.isEmpty(stringExtra) && this.miniAppInterface != null) {
            TextView textView = (TextView) view.findViewById(R.id.ivTitleBtnLeft);
            TextView textView2 = (TextView) view.findViewById(R.id.ivTitleName);
            textView.setText(HardCodeUtil.qqStr(R.string.f171898lr0));
            textView2.setText(HardCodeUtil.qqStr(R.string.f172277p10));
            textView.setOnClickListener(this.onClickListener);
            this.subscribeRecyclerView = (RecyclerView) view.findViewById(R.id.f904952m);
            AuthorizeCenter authorizeCenter = this.miniAppInterface.getAuthorizeCenter(this.appId);
            this.authorizeCenter = authorizeCenter;
            if (authorizeCenter == null) {
                QLog.e("SubscribePermissionSettingFragment", 1, "getAuthorizeCenter(appId), authorizeCenter is null?!");
                return;
            } else {
                requestAuthList();
                return;
            }
        }
        QLog.e("SubscribePermissionSettingFragment", 1, "onViewCreated error! appId: " + this.appId + " miniAppInterface: " + this.miniAppInterface);
        getBaseActivity().finish();
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
