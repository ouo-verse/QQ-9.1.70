package com.tenpay.sdk.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.DialerKeyListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tenpay.QwLog;
import com.tenpay.api.MyKeyboardWindow;
import com.tenpay.api.QWalletUtils;
import com.tenpay.proxy.QUIProxy;
import com.tenpay.proxy.dlg.ScrollSelectDlg;
import com.tenpay.sdk.util.UIUtils;
import com.tenpay.sdk.view.ClearableEditText;
import com.tenpay.util.Utils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes27.dex */
public class ParentInfoCollectActivity extends NetBaseActivity {
    public static final String GUARDIAN_CRE_TYPE = "guardian_cre_type";
    public static final String GUARDIAN_IDENTIFY_CARD = "guardian_identify_card";
    public static final String GUARDIAN_RELATIONSHIP = "guardian_relationship";
    public static final String GUARDIAN_TRUE_NAME = "guardian_true_name";
    public static final String SAVE_GUARDIAN_INFO = "save_guardian_info";
    private List<String> choice = new ArrayList(Arrays.asList("\u7236\u4eb2", "\u6bcd\u4eb2", "\u5176\u5b83"));
    private String cre_id;
    private Button mBtnConfirm;
    private MyKeyboardWindow mMyKeyBoard;
    private ClearableEditText mNnumber;
    private TextView mType;
    private ClearableEditText mUserName;

    private void bindViewId(View view) {
        this.mUserName = (ClearableEditText) view.findViewById(R.id.dba);
        this.mNnumber = (ClearableEditText) view.findViewById(R.id.db9);
        this.mBtnConfirm = (Button) view.findViewById(R.id.db6);
        this.mType = (TextView) view.findViewById(R.id.f225203y);
        this.mMyKeyBoard = (MyKeyboardWindow) view.findViewById(R.id.f4i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void freshComfirmBntStatus() {
        String obj = this.mNnumber.getText().toString();
        int i3 = -16777216;
        if (!Utils.invalidateID(obj)) {
            ClearableEditText clearableEditText = this.mNnumber;
            if (obj.length() == 15 || 18 == obj.length()) {
                i3 = SupportMenu.CATEGORY_MASK;
            }
            clearableEditText.setTextColor(i3);
            this.mBtnConfirm.setEnabled(false);
            return;
        }
        this.mNnumber.setTextColor(-16777216);
        if (this.mUserName.getText().toString().length() >= 2 && this.choice.contains(this.mType.getText().toString())) {
            this.mBtnConfirm.setEnabled(true);
        } else {
            this.mBtnConfirm.setEnabled(false);
        }
    }

    private void initView(View view) {
        CharSequence charSequence;
        TextView textView = (TextView) view.findViewById(R.id.ivTitleName);
        ((TextView) view.findViewById(R.id.ivTitleBtnLeft)).setVisibility(8);
        TextView textView2 = (TextView) view.findViewById(R.id.ivTitleBtnRightText);
        textView.setText(R.string.f23190734);
        textView2.setVisibility(0);
        textView2.setText(R.string.cancel);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.ParentInfoCollectActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                ParentInfoCollectActivity.this.finish();
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        this.mMyKeyBoard.setVisibility(8);
        QWalletUtils.hideSysKeyBorad(this.mNnumber);
        ClearableEditText.OnTextChangedListener onTextChangedListener = new ClearableEditText.OnTextChangedListener() { // from class: com.tenpay.sdk.activity.ParentInfoCollectActivity.2
            @Override // com.tenpay.sdk.view.ClearableEditText.OnTextChangedListener
            public void onTextChanged() {
                ParentInfoCollectActivity.this.freshComfirmBntStatus();
            }
        };
        this.mUserName.setOnTextChangedListener(onTextChangedListener);
        this.mNnumber.setOnTextChangedListener(onTextChangedListener);
        this.mNnumber.setKeyListener(new DialerKeyListener() { // from class: com.tenpay.sdk.activity.ParentInfoCollectActivity.3
            @Override // android.text.method.DialerKeyListener, android.text.method.NumberKeyListener
            protected char[] getAcceptedChars() {
                return new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'x', 'X'};
            }

            @Override // android.text.method.DialerKeyListener, android.text.method.KeyListener
            public int getInputType() {
                return 1;
            }
        });
        this.mNnumber.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tenpay.sdk.activity.ParentInfoCollectActivity.4
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view2, boolean z16) {
                UIUtils.handleFocusChange(ParentInfoCollectActivity.this.mMyKeyBoard, view2, z16, 1);
            }
        });
        this.mBtnConfirm.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.ParentInfoCollectActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                String obj = ParentInfoCollectActivity.this.mNnumber.getText().toString();
                if (obj.equals(ParentInfoCollectActivity.this.cre_id)) {
                    QUIProxy.showConfirm(ParentInfoCollectActivity.this.getContext(), ParentInfoCollectActivity.this.getString(R.string.f173272sp), null);
                } else if (Utils.getAgeByIDNumber(obj) < 18) {
                    QUIProxy.showConfirm(ParentInfoCollectActivity.this.getContext(), ParentInfoCollectActivity.this.getString(R.string.f173252sn), null);
                } else {
                    QUIProxy.createCustomDialog(ParentInfoCollectActivity.this.getContext(), 230, null, ParentInfoCollectActivity.this.getString(R.string.f173262so), ParentInfoCollectActivity.this.getString(R.string.f171324e35), ParentInfoCollectActivity.this.getString(R.string.e4i), new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.ParentInfoCollectActivity.5.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            Intent intent = new Intent();
                            HashMap hashMap = new HashMap();
                            hashMap.put(ParentInfoCollectActivity.SAVE_GUARDIAN_INFO, "1");
                            hashMap.put(ParentInfoCollectActivity.GUARDIAN_CRE_TYPE, "1");
                            hashMap.put(ParentInfoCollectActivity.GUARDIAN_TRUE_NAME, ParentInfoCollectActivity.this.mUserName.getText().toString());
                            hashMap.put(ParentInfoCollectActivity.GUARDIAN_IDENTIFY_CARD, ParentInfoCollectActivity.this.mNnumber.getText().toString());
                            hashMap.put(ParentInfoCollectActivity.GUARDIAN_RELATIONSHIP, String.valueOf(ParentInfoCollectActivity.this.choice.indexOf(ParentInfoCollectActivity.this.mType.getText().toString()) + 1));
                            intent.putExtra("params", hashMap);
                            ParentInfoCollectActivity.this.setResult(-1, intent);
                            ParentInfoCollectActivity.this.finish();
                        }
                    }, new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.activity.ParentInfoCollectActivity.5.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                        }
                    });
                }
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        this.mType.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.sdk.activity.ParentInfoCollectActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                EventCollector.getInstance().onViewClickedBefore(view2);
                if (ParentInfoCollectActivity.this.mNnumber.hasFocus()) {
                    ParentInfoCollectActivity.this.mNnumber.clearFocus();
                }
                ScrollSelectDlg.with(ParentInfoCollectActivity.this.getContext()).appendColumn(ParentInfoCollectActivity.this.choice).setPickerListener(new ScrollSelectDlg.IPickerListener() { // from class: com.tenpay.sdk.activity.ParentInfoCollectActivity.6.1
                    @Override // com.tenpay.proxy.dlg.ScrollSelectDlg.IPickerListener
                    public void onChoice(String str) {
                        QwLog.i("choice: " + str);
                        ParentInfoCollectActivity.this.mType.setText(str);
                        ParentInfoCollectActivity.this.freshComfirmBntStatus();
                    }
                }).show();
                EventCollector.getInstance().onViewClicked(view2);
            }
        });
        Serializable serializableExtra = getIntent().getSerializableExtra("params");
        if (serializableExtra instanceof Map) {
            Map map = (Map) serializableExtra;
            ClearableEditText clearableEditText = this.mUserName;
            CharSequence charSequence2 = "";
            if (!map.containsKey(GUARDIAN_TRUE_NAME)) {
                charSequence = "";
            } else {
                charSequence = (CharSequence) map.get(GUARDIAN_TRUE_NAME);
            }
            clearableEditText.setText(charSequence);
            ClearableEditText clearableEditText2 = this.mNnumber;
            if (map.containsKey(GUARDIAN_IDENTIFY_CARD)) {
                charSequence2 = (CharSequence) map.get(GUARDIAN_IDENTIFY_CARD);
            }
            clearableEditText2.setText(charSequence2);
            if (map.containsKey(GUARDIAN_RELATIONSHIP)) {
                this.mType.setText(this.choice.get(x05.c.j(map.get(GUARDIAN_RELATIONSHIP), 1) - 1));
            }
            freshComfirmBntStatus();
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fyr, viewGroup, false);
        bindViewId(inflate);
        this.cre_id = getIntent().getStringExtra("cre_id");
        initView(inflate);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
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
