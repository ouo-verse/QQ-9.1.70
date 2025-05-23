package com.qzone.homepage.ui.activity;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.QZoneTitleBarFragmentV2;
import com.qzone.common.friend.business.model.Friend;
import com.qzone.util.ToastUtil;
import com.qzone.widget.AvatarImageView;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.RDMEtraMsgCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class ApplyAccessActivity extends QZoneTitleBarFragmentV2 implements View.OnClickListener {

    /* renamed from: h0, reason: collision with root package name */
    private SharedPreferences f47672h0;

    /* renamed from: i0, reason: collision with root package name */
    private Long f47673i0;

    /* renamed from: j0, reason: collision with root package name */
    private String f47674j0;

    /* renamed from: k0, reason: collision with root package name */
    private String f47675k0;

    /* renamed from: l0, reason: collision with root package name */
    private String f47676l0;

    /* renamed from: m0, reason: collision with root package name */
    private EditText f47677m0;

    /* renamed from: n0, reason: collision with root package name */
    private InputMethodManager f47678n0;

    /* renamed from: o0, reason: collision with root package name */
    private AvatarImageView f47679o0;

    /* renamed from: p0, reason: collision with root package name */
    private List<Friend> f47680p0 = new ArrayList();

    /* renamed from: q0, reason: collision with root package name */
    private View.OnClickListener f47681q0 = new a();

    /* renamed from: r0, reason: collision with root package name */
    private View.OnClickListener f47682r0 = new b();

    /* renamed from: s0, reason: collision with root package name */
    private TextWatcher f47683s0 = new c();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            RDMEtraMsgCollector.getInstance().addNoramlClickAction(ApplyAccessActivity.this.simpleClassname, view);
            if (NetworkState.isNetSupport()) {
                ApplyAccessActivity applyAccessActivity = ApplyAccessActivity.this;
                applyAccessActivity.f47674j0 = applyAccessActivity.f47677m0.getText().toString();
                ApplyAccessActivity.this.f47678n0.hideSoftInputFromWindow(view.getWindowToken(), 0);
                Bundle bundle = new Bundle();
                bundle.putLong("access_apply_uin", ApplyAccessActivity.this.f47673i0.longValue());
                bundle.putString("apply_content", ApplyAccessActivity.this.f47674j0);
                ApplyAccessActivity applyAccessActivity2 = ApplyAccessActivity.this;
                applyAccessActivity2.setResult(-1, applyAccessActivity2.getIntent().putExtras(bundle));
                ApplyAccessActivity.this.mi();
                ApplyAccessActivity.this.finish();
            } else {
                QQToast.makeText(ApplyAccessActivity.this.getActivity(), 1, ApplyAccessActivity.this.getString(R.string.f171139ci4), 0).show(ApplyAccessActivity.this.getTitleBarHeight());
            }
            LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064();
            lpReportInfo_pf00064.actionType = 215;
            lpReportInfo_pf00064.subactionType = 2;
            lpReportInfo_pf00064.toUin = ApplyAccessActivity.this.f47673i0.longValue();
            LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false, false);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            RDMEtraMsgCollector.getInstance().addNoramlClickAction(ApplyAccessActivity.this.simpleClassname, view);
            ApplyAccessActivity.this.f47678n0.hideSoftInputFromWindow(view.getWindowToken(), 0);
            ApplyAccessActivity.this.pi();
            ApplyAccessActivity.this.finish();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    private void initData() {
        this.f47673i0 = Long.valueOf(getIntent().getExtras().getLong("access_apply_uin"));
        this.f47675k0 = getIntent().getExtras().getString("access_apply_nick_name");
        this.f47676l0 = getIntent().getExtras().getString(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mi() {
        if (this.f47672h0 == null) {
            this.f47672h0 = getSharedPreferences("access_apply_preferences", 0);
        }
        this.f47672h0.edit().remove("key_apply_preferences_" + LoginData.getInstance().getUin() + "_" + this.f47673i0).commit();
    }

    private String ni() {
        if (this.f47672h0 == null) {
            this.f47672h0 = getSharedPreferences("access_apply_preferences", 0);
        }
        return this.f47672h0.getString("key_apply_preferences_" + LoginData.getInstance().getUin() + "_" + this.f47673i0, "");
    }

    private void oi() {
        EditText editText = this.f47677m0;
        if (editText == null) {
            return;
        }
        editText.setClickable(true);
        this.f47677m0.setFocusable(true);
        this.f47677m0.setFocusableInTouchMode(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pi() {
        EditText editText = this.f47677m0;
        if (editText == null || editText.getText() == null) {
            return;
        }
        String obj = this.f47677m0.getText().toString();
        if (!TextUtils.isEmpty(obj)) {
            if (obj.equals(ni())) {
                return;
            }
            qi(obj);
        } else {
            if (TextUtils.isEmpty(ni())) {
                return;
            }
            mi();
        }
    }

    private void qi(String str) {
        if (this.f47672h0 == null) {
            this.f47672h0 = getSharedPreferences("access_apply_preferences", 0);
        }
        this.f47672h0.edit().putString("key_apply_preferences_" + LoginData.getInstance().getUin() + "_" + this.f47673i0, str).commit();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.common.activities.base.BaseFragment
    public boolean onBackPress() {
        pi();
        return super.onBackPress();
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarFragmentV2, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064();
        lpReportInfo_pf00064.actionType = 215;
        lpReportInfo_pf00064.subactionType = 1;
        lpReportInfo_pf00064.toUin = this.f47673i0.longValue();
        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false, false);
    }

    @Override // com.qzone.common.activities.base.QZoneTitleBarFragmentV2, com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initData();
        initUI();
        this.f47678n0 = (InputMethodManager) getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
    }

    private void initUI() {
        EditText editText = (EditText) findViewById(R.id.f166785i82);
        this.f47677m0 = editText;
        editText.setVisibility(0);
        this.f47677m0.addTextChangedListener(this.f47683s0);
        String ni5 = ni();
        if (!TextUtils.isEmpty(ni5)) {
            this.f47677m0.setText(ni5);
            try {
                EditText editText2 = this.f47677m0;
                editText2.setSelection(editText2.length());
            } catch (Exception e16) {
                QLog.e("ApplyAccessActivity", 1, "setSelection error", e16);
            }
        }
        ((TextView) findViewById(R.id.f167075kh1)).setVisibility(8);
        ((TextView) findViewById(R.id.nickname)).setText(this.f47675k0);
        this.f47679o0 = (AvatarImageView) findViewById(R.id.fxg);
        getIntent().getExtras().getString("access_apply_avatar_image_url");
        this.f47679o0.j(this.f47673i0.longValue());
        String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TitleApplyAccessActivity", "\u7533\u8bf7\u8bbf\u95ee");
        this.E.setText(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TitleRightApplyAccessActivity", "\u63d0\u4ea4"));
        this.E.setVisibility(0);
        setTitle(config);
        this.C.setOnClickListener(this.f47682r0);
        this.E.setOnClickListener(this.f47681q0);
        if (Build.VERSION.SDK_INT >= 31) {
            oi();
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return Rh(layoutInflater, R.layout.bgc, viewGroup);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c implements TextWatcher {

        /* renamed from: d, reason: collision with root package name */
        boolean f47686d = false;

        c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            int length = editable.length();
            if (length > 16) {
                String obj = editable.toString();
                while (length > 16) {
                    int length2 = obj.length();
                    if (length2 >= 2) {
                        int i3 = length2 - 2;
                        if (Character.isHighSurrogate(obj.charAt(i3))) {
                            obj = obj.substring(0, i3);
                            length = obj.length();
                            ToastUtil.o(R.string.f173054gr0, 4);
                        }
                    }
                    obj = obj.substring(0, length2 - 1);
                    length = obj.length();
                    ToastUtil.o(R.string.f173054gr0, 4);
                }
                ApplyAccessActivity.this.f47677m0.setText(obj);
                ApplyAccessActivity.this.f47677m0.setSelection(obj.length());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
