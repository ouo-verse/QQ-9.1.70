package com.tencent.qqmini.sdk.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.auth.AuthState;
import com.tencent.qqmini.sdk.auth.AuthStateItem;
import com.tencent.qqmini.sdk.auth.PermissionManager;
import com.tencent.qqmini.sdk.auth.parser.LocalPermissionParser;
import com.tencent.qqmini.sdk.auth.parser.RemotePermissionParser;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.auth.UserAuthInfo;
import com.tencent.qqmini.sdk.launcher.core.auth.UserSettingInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.ui.MiniBaseFragment;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import com.tencent.qqmini.sdk.widget.MiniCustomDialog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@MiniKeep
/* loaded from: classes23.dex */
public class PermissionSettingFragment extends MiniBaseFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private static final String TAG = "com.tencent.qqmini.sdk.ui.PermissionSettingFragment";
    public static boolean hasCancel = false;
    private PermissionListAdapter adapter;
    String appId;
    AuthState authState;
    TextView leftBtnView;
    private ListView mPermissionListView;
    private TextView mPermissionNoneTextView;
    private ProgressDialog mProgress;
    private TextView miniAppNameDesc;
    private RelativeLayout subMsgPermissionItem;
    TextView titleView;

    private void initPermissionParser(Context context) {
        PermissionManager.g().startParse(new LocalPermissionParser(context), new RemotePermissionParser(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSettingUI(String str) {
        List<AuthStateItem> list;
        AuthState authState = this.authState;
        AuthStateItem authStateItem = null;
        if (authState != null) {
            list = authState.getAuthStateList(6);
        } else {
            list = null;
        }
        this.adapter = new PermissionListAdapter(getActivity(), this);
        if (list != null) {
            Iterator<AuthStateItem> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                AuthStateItem next = it.next();
                if (AuthorizeCenter.SCOPE_GET_PHONE_NUMBER.equals(next.scopeName)) {
                    authStateItem = next;
                    break;
                }
            }
            if (authStateItem != null) {
                list.remove(authStateItem);
            }
            ArrayList arrayList = new ArrayList(list);
            if (arrayList.size() > 0) {
                this.mPermissionListView.setVisibility(0);
                if (!TextUtils.isEmpty(str)) {
                    this.miniAppNameDesc.setVisibility(0);
                    this.miniAppNameDesc.setText("\u5141\u8bb8\"" + str + "\"\u4f7f\u7528\u6211\u7684");
                }
                this.adapter.setScopeList(arrayList);
            } else {
                this.mPermissionNoneTextView.setText(str + "\u672a\u4f7f\u7528\u4f60\u4efb\u4f55\u4fe1\u606f");
                this.mPermissionNoneTextView.setVisibility(0);
            }
            this.mPermissionListView.setAdapter((ListAdapter) this.adapter);
            if (!this.authState.isOnceSubMaintain() && !this.authState.isSystemSubscribeMaintain()) {
                this.subMsgPermissionItem.setVisibility(8);
            } else {
                this.subMsgPermissionItem.setVisibility(0);
                this.subMsgPermissionItem.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqmini.sdk.ui.PermissionSettingFragment.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        EventCollector.getInstance().onViewClickedBefore(view);
                        SubscribePermissionSettingFragment.launch(PermissionSettingFragment.this.getActivity(), PermissionSettingFragment.this.appId);
                        EventCollector.getInstance().onViewClicked(view);
                    }
                });
            }
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(final CompoundButton compoundButton, final boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        final String str = (String) compoundButton.getTag();
        if (!TextUtils.isEmpty(str)) {
            if (!z16 && !hasCancel) {
                hasCancel = true;
                MiniCustomDialog miniCustomDialog = new MiniCustomDialog(getActivity(), R.style.mini_sdk_MiniAppInputDialog);
                miniCustomDialog.setContentView(R.layout.mini_sdk_custom_dialog_temp);
                miniCustomDialog.setTitle("\u6743\u9650\u8bbe\u7f6e").setMessage("\u5173\u95ed\u6388\u6743\u540e\u53ef\u80fd\u4f1a\u5f71\u54cd\u4f7f\u7528\u5c0f\u7a0b\u5e8f\u7684\u90e8\u5206\u529f\u80fd\uff0c\u8bf7\u786e\u8ba4").setPositiveButton("\u5173\u95ed\u6388\u6743", Color.parseColor("#5B6B92"), new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.sdk.ui.PermissionSettingFragment.4
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        PermissionSettingFragment.this.adapter.changeChecked(str, z16);
                        PermissionSettingFragment.this.authState.setAuthState(str, z16);
                    }
                }).setNegativeButton("\u53d6\u6d88", Color.parseColor("#000000"), new DialogInterface.OnClickListener() { // from class: com.tencent.qqmini.sdk.ui.PermissionSettingFragment.3
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        compoundButton.setChecked(true);
                    }
                });
                miniCustomDialog.show();
            } else {
                this.adapter.changeChecked(str, z16);
                this.authState.setAuthState(str, z16);
            }
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
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
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        initPermissionParser(getActivity());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.mini_sdk_permission_setting_layout, (ViewGroup) null);
        if (DisplayUtil.isImmersiveSupported()) {
            inflate.setFitsSystemWindows(true);
        }
        inflate.setBackgroundColor(Color.parseColor("#EFEFF4"));
        getActivity().getWindow().clearFlags(67108864);
        getActivity().getWindow().addFlags(Integer.MIN_VALUE);
        getActivity().getWindow().setStatusBarColor(Color.parseColor("#EFEFF4"));
        ImmersiveUtils.setStatusTextColor(true, getActivity().getWindow());
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.appId = getActivity().getIntent().getStringExtra("key_appid");
        final String stringExtra = getActivity().getIntent().getStringExtra("key_name");
        if (TextUtils.isEmpty(this.appId)) {
            getActivity().finish();
            return;
        }
        this.leftBtnView = (TextView) view.findViewById(R.id.ivTitleBtnLeft);
        this.titleView = (TextView) view.findViewById(R.id.ivTitleName);
        this.leftBtnView.setText("\u8fd4\u56de");
        this.titleView.setText("\u8bbe\u7f6e");
        this.leftBtnView.setOnClickListener(this);
        this.mPermissionListView = (ListView) view.findViewById(R.id.permission_list);
        this.mPermissionNoneTextView = (TextView) view.findViewById(R.id.permission_none);
        this.miniAppNameDesc = (TextView) view.findViewById(R.id.miniapp_name_text);
        this.subMsgPermissionItem = (RelativeLayout) view.findViewById(R.id.sub_msg_permission_item);
        AuthState authState = new AuthState(getContext(), this.appId, LoginManager.getInstance().getAccount());
        this.authState = authState;
        if (authState.isSynchronized()) {
            initSettingUI(stringExtra);
            return;
        }
        if (this.mProgress == null) {
            this.mProgress = new ReportProgressDialog(getActivity());
        }
        this.mProgress.setMessage("\u6b63\u5728\u83b7\u53d6\u6743\u9650\u4fe1\u606f\uff0c\u8bf7\u7a0d\u5019...");
        this.mProgress.show();
        ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).getAuthList(this.appId, new ChannelProxy.AuthListResult() { // from class: com.tencent.qqmini.sdk.ui.PermissionSettingFragment.1
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy.AuthListResult
            public void onReceiveResult(boolean z16, List<UserAuthInfo> list, List<UserSettingInfo> list2) {
                if (z16) {
                    PermissionSettingFragment.this.authState.updateAuthStateList(null, list2);
                    PermissionSettingFragment.this.authState.setSynchronized();
                    PermissionSettingFragment.this.getActivity().runOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.ui.PermissionSettingFragment.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            PermissionSettingFragment.this.initSettingUI(stringExtra);
                            PermissionSettingFragment.this.mProgress.dismiss();
                        }
                    });
                } else {
                    QMLog.e(PermissionSettingFragment.TAG, "getSetting-getAuthStateList failed");
                    PermissionSettingFragment.this.getActivity().runOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.ui.PermissionSettingFragment.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            PermissionSettingFragment.this.initSettingUI(stringExtra);
                            PermissionSettingFragment.this.mProgress.dismiss();
                        }
                    });
                }
            }
        });
    }
}
