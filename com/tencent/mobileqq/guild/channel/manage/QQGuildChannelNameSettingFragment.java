package com.tencent.mobileqq.guild.channel.manage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.handler.api.impl.QQGuildHandler;
import com.tencent.mobileqq.guild.util.GuildDebugUtils;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.qqui.a;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.inputview.QUISingleLineInputView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import h53.q;
import vh2.ct;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQGuildChannelNameSettingFragment extends QQGuildTitleBarFragment {
    public IGProChannelInfo V;
    private QQProgressDialog W;
    private QUISingleLineInputView Y;
    private int T = 0;
    private int U = 20;
    boolean X = false;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements a.d {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.util.qqui.a.d
        public void k() {
            QQGuildChannelNameSettingFragment.this.Y.setMaxWordCount(QQGuildChannelNameSettingFragment.this.U);
            QQGuildChannelNameSettingFragment.this.Y.setContentText(QQGuildChannelNameSettingFragment.this.Y.d().toString());
            QQGuildChannelNameSettingFragment qQGuildChannelNameSettingFragment = QQGuildChannelNameSettingFragment.this;
            qQGuildChannelNameSettingFragment.Lh(qQGuildChannelNameSettingFragment.Y.d().toString());
        }

        @Override // com.tencent.mobileqq.guild.util.qqui.a.d
        public void onCancelClick() {
            QQGuildChannelNameSettingFragment.super.onBackEvent();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (QQGuildChannelNameSettingFragment.this.Y != null) {
                QQGuildChannelNameSettingFragment.this.Y.p();
                QQGuildChannelNameSettingFragment.this.Nh(QQGuildChannelNameSettingFragment.this.Y.d().toString());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d implements ct {
        d() {
        }

        @Override // vh2.ct
        public void a(int i3, IGProChannelInfo iGProChannelInfo, String str, IGProSecurityResult iGProSecurityResult) {
            QQGuildChannelNameSettingFragment.this.Mh(i3, str, iGProSecurityResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Kh() {
        this.Y.z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lh(String str) {
        if (TextUtils.isEmpty(str)) {
            QQToast.makeText(getContext(), 1, getResources().getString(R.string.f143510m_), 1).show();
            return;
        }
        if (TextUtils.isEmpty(str.trim())) {
            QQToast.makeText(getContext(), 1, getResources().getString(R.string.f143510m_), 1).show();
            return;
        }
        if (this.X && this.Y.e() > this.U) {
            QQToast.makeText(getContext(), 1, getResources().getString(R.string.f141190g0), 1).show();
            return;
        }
        if (TextUtils.isEmpty(str) || str.length() < this.T) {
            str = getContext().getString(R.string.f141940i1);
        }
        if (!NetworkUtil.isNetworkAvailable(getQBaseActivity())) {
            QQToast.makeText(getContext(), 1, getResources().getString(R.string.f141910hy), 1).show();
            return;
        }
        if (this.W == null) {
            this.W = new QQProgressDialog(getContext());
        }
        if (!this.W.isShowing()) {
            this.W.show();
        }
        ((QQGuildHandler) getAppInterface().getBusinessHandler(QQGuildHandler.class.getName())).b3(this.V, str, new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mh(int i3, String str, IGProSecurityResult iGProSecurityResult) {
        QLog.i("QQGuildCustomTitleBarFragment", 1, "onChannelUpdateResult errCode:" + i3 + ", errMsg:" + str);
        QQProgressDialog qQProgressDialog = this.W;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.W.dismiss();
        }
        if (i3 == 0 && ch.p(iGProSecurityResult)) {
            if (getActivity() != null) {
                getActivity().finish();
            }
        } else if (getActivity() != null && !getActivity().isFinishing()) {
            SecurityTipHelperKt.B(getContext(), i3, str, iGProSecurityResult, getResources().getString(R.string.f141910hy));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nh(String str) {
        Lh(str);
    }

    public static void Oh(Context context, IGProChannelInfo iGProChannelInfo) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("extra_guild_channel_info", iGProChannelInfo);
        intent.putExtras(bundle);
        QPublicFragmentActivity.b.b(context, intent, QPublicFragmentActivity.class, QQGuildChannelNameSettingFragment.class);
    }

    private void Ph() {
        this.Y.setTextFocusable(true);
        this.Y.setTextFocusableInTouchMode(true);
        this.Y.q();
        this.Y.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.channel.manage.l
            @Override // java.lang.Runnable
            public final void run() {
                QQGuildChannelNameSettingFragment.this.Kh();
            }
        }, 800L);
    }

    private void initIntentData() {
        Bundle extras = getActivity().getIntent().getExtras();
        if (extras != null) {
            this.V = (IGProChannelInfo) extras.getSerializable("extra_guild_channel_info");
        }
    }

    private void initView() {
        int i3;
        QUISingleLineInputView qUISingleLineInputView = (QUISingleLineInputView) this.P.findViewById(R.id.wjt);
        this.Y = qUISingleLineInputView;
        if (QQTheme.isNowThemeIsNight()) {
            i3 = 1002;
        } else {
            i3 = 1001;
        }
        qUISingleLineInputView.setThemeId(i3);
        this.Y.setContentText(this.V.getChannelName());
        if (this.V.getType() == 7 && GuildDebugUtils.f(this.V.getGuildId())) {
            setTitle(getString(R.string.f141170fy));
            this.U = 5;
            this.X = true;
            int e16 = this.Y.e();
            int i16 = this.U;
            if (e16 > i16) {
                this.Y.setAllowMaxWord(i16);
                setRightButtonEnable(false);
            } else {
                this.Y.setMaxWordCount(i16);
            }
        } else {
            setTitle(getString(R.string.f141740hh));
            this.Y.setMaxWordCount(this.U);
        }
        if (this.V.getType() == 5) {
            setTitle(getString(R.string.f141540gy));
        }
        if (this.V.getType() == 2) {
            setTitle(getString(R.string.f142140ik));
        }
        if (this.V.getType() == 1) {
            setTitle(getString(R.string.f1488710r));
        }
        if (this.Y.d() != null) {
            QUISingleLineInputView qUISingleLineInputView2 = this.Y;
            qUISingleLineInputView2.setTextSelection(qUISingleLineInputView2.d().length());
        }
        Ph();
        if (TextUtils.isEmpty(this.V.getChannelName()) || TextUtils.isEmpty(this.V.getChannelName().trim())) {
            this.F.setEnabled(false);
        }
        this.Y.setInputViewWatcher(new b());
        setRightButton(R.string.f143340lt, new c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        initIntentData();
        if (this.V == null) {
            QLog.e("QQGuildCustomTitleBarFragment", 1, "error channel info");
            QQToast.makeText(getContext(), 1, getResources().getString(R.string.f143560me), 1).show();
        } else {
            initView();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.eif;
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        this.Y.p();
        if (this.X && this.Y.e() > this.U) {
            a.c cVar = new a.c();
            cVar.f235600a = getResources().getString(R.string.f141180fz);
            com.tencent.mobileqq.guild.util.qqui.a.a(getContext(), cVar, new a());
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QQProgressDialog qQProgressDialog = this.W;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.W.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements q {
        b() {
        }

        @Override // h53.k
        public void afterTextChanged(Editable editable) {
            String obj = editable.toString();
            if (!TextUtils.isEmpty(obj) && !TextUtils.isEmpty(obj.trim())) {
                QQGuildChannelNameSettingFragment.this.setRightButtonEnable(true);
            } else {
                QQGuildChannelNameSettingFragment.this.setRightButtonEnable(false);
            }
            QQGuildChannelNameSettingFragment qQGuildChannelNameSettingFragment = QQGuildChannelNameSettingFragment.this;
            if (qQGuildChannelNameSettingFragment.X) {
                qQGuildChannelNameSettingFragment.Y.setAllowMaxWord(QQGuildChannelNameSettingFragment.this.U);
            }
        }

        @Override // h53.q
        public void A4(String str) {
        }

        @Override // h53.k
        public void f8(boolean z16) {
        }

        @Override // h53.k
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }

        @Override // h53.k
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
