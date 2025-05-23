package com.tencent.mobileqq.guild.setting.guildmanage;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.guild.api.IGuildEmotionCodecApi;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.setting.guildmanage.QQGuildDescriptionEditFragment;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.cd;
import com.tencent.mobileqq.qqguildsdk.data.genc.ce;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.InputMethodLinearLayout;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.inputview.QUIMultiLineInputView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.NumberUtil;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes14.dex */
public class QQGuildDescriptionEditFragment extends QQGuildTitleBarFragment {
    protected QUIMultiLineInputView T;
    private String U;
    private String V = "";
    private TextView W;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            CharSequence d16 = QQGuildDescriptionEditFragment.this.T.d();
            int e16 = QQGuildDescriptionEditFragment.this.T.e();
            if (e16 > 600) {
                QQGuildUIUtil.Q(QQGuildDescriptionEditFragment.this.getContext(), R.string.f1507915y);
                QLog.w("Guild.mnr.QQGuildDescriptionEditFragment", 1, "guild done button click: exceed char count limit");
            } else if (e16 <= 0) {
                QQGuildDescriptionEditFragment.this.Lh("");
            } else {
                QQGuildDescriptionEditFragment.this.Lh(d16);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QQGuildDescriptionEditFragment.this.onBackEvent();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hh() {
        if (this.T.e() > 600) {
            String valueOf = String.valueOf(this.T.e());
            SpannableString spannableString = new SpannableString(valueOf + "/600");
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.qui_common_feedback_error)), 0, valueOf.length(), 0);
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.qui_common_text_secondary)), valueOf.length(), spannableString.length(), 0);
            zh(getResources().getString(R.string.f156101ja), spannableString.toString());
            this.W.setText(spannableString);
            return;
        }
        this.W.setTextColor(AppCompatResources.getColorStateList(getContext(), R.color.qui_common_text_secondary));
        zh(getResources().getString(R.string.f156101ja), this.T.e() + "/600");
    }

    private void Ih(int i3, String str, IGProSecurityResult iGProSecurityResult) {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            if (QLog.isColorLevel()) {
                QLog.d("Guild.mnr.QQGuildDescriptionEditFragment", 2, "activity == null");
            }
        } else {
            if (i3 == 0 && ch.p(iGProSecurityResult)) {
                Intent intent = new Intent();
                intent.putExtra("guild_introduction", this.V);
                activity.setResult(-1, intent);
                QQToast.makeText(BaseApplication.getContext(), 2, "\u5df2\u63d0\u4ea4\u5ba1\u6838\uff0c\u901a\u8fc7\u540e\u751f\u6548", 0).show();
                onBackEvent();
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("Guild.mnr.QQGuildDescriptionEditFragment", 2, String.format("set guildIntroduction failed: %s", str));
            }
            SecurityTipHelperKt.B(getContext(), i3, str, iGProSecurityResult, getResources().getString(R.string.f141910hy));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Jh(int i3, String str, IGProSecurityResult iGProSecurityResult, int i16) {
        if (getActivity() != null && !getActivity().isFinishing()) {
            Ih(i3, str, iGProSecurityResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Kh(boolean z16) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.T.getLayoutParams();
        if (z16) {
            layoutParams.bottomMargin = ViewUtils.dpToPx(44.0f);
        } else {
            layoutParams.bottomMargin = 0;
        }
        this.T.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lh(CharSequence charSequence) {
        if (charSequence instanceof QQTextBuilder) {
            this.V = ((IGuildEmotionCodecApi) QRoute.api(IGuildEmotionCodecApi.class)).fromQQTextBuilder((QQTextBuilder) charSequence);
        } else {
            this.V = charSequence.toString();
        }
        cd cdVar = new cd();
        cdVar.m(4);
        cdVar.k(this.V);
        ArrayList<cd> arrayList = new ArrayList<>();
        arrayList.add(cdVar);
        ce ceVar = new ce();
        ceVar.g(NumberUtil.stringToLong(this.U));
        ceVar.e(arrayList);
        ((IGPSService) getAppInterface().getRuntimeService(IGPSService.class, "")).setGuildAuditInfo(ceVar, new wh2.d() { // from class: cz1.b
            @Override // wh2.d
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult, int i16) {
                QQGuildDescriptionEditFragment.this.Jh(i3, str, iGProSecurityResult, i16);
            }
        });
    }

    private void Mh() {
        View view = this.P;
        if (view instanceof InputMethodLinearLayout) {
            ((InputMethodLinearLayout) view).setOnSizeChangedListenner(new InputMethodLinearLayout.a() { // from class: cz1.c
                @Override // com.tencent.mobileqq.widget.InputMethodLinearLayout.a
                public final void onSizeChange(boolean z16) {
                    QQGuildDescriptionEditFragment.this.Kh(z16);
                }
            });
        }
    }

    public static void Nh(Context context, String str, String str2, int i3) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("guild_id", str);
        bundle.putString("guild_introduction", str2);
        intent.putExtras(bundle);
        QPublicFragmentActivity.b.f(context, intent, QPublicFragmentActivity.class, QQGuildDescriptionEditFragment.class, i3);
    }

    private void initDtReport() {
        VideoReport.addToDetectionWhitelist(getQBaseActivity());
        VideoReport.setPageId(this.P, "pg_sgrp_channel_introduction_set");
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_channel_id", this.U);
        hashMap.put("sgrp_duration_flag", 1);
        VideoReport.setPageParams(this.P, new PageParams(hashMap));
    }

    private void initIntentData() {
        Bundle extras = getActivity().getIntent().getExtras();
        if (extras == null) {
            QLog.e("Guild.mnr.QQGuildDescriptionEditFragment", 1, "initIntentData failed: bundle is null");
            getActivity().finish();
            return;
        }
        this.U = extras.getString("guild_id");
        this.V = extras.getString("guild_introduction");
        if (QLog.isColorLevel()) {
            QLog.d("Guild.mnr.QQGuildDescriptionEditFragment", 2, String.format("initIntentData guildId: %s, remark: %s", this.U, this.V));
        }
    }

    private void initTitleBar() {
        setRightButton(R.string.f143340lt, new a());
        if (this.J.d() != null) {
            this.W = this.J.d();
        } else {
            this.W = (TextView) getTitleBarView().findViewById(R.id.joi);
        }
        Hh();
        setLeftButton(R.string.f140850f3, new b());
        this.T.setInputViewWatcher(new c());
    }

    private void initView() {
        int i3;
        int i16;
        FragmentActivity requireActivity = requireActivity();
        requireActivity.getWindow().setSoftInputMode(16);
        Window window = requireActivity.getWindow();
        if (QQTheme.isNowThemeIsNight()) {
            i3 = -16777216;
        } else {
            i3 = -1;
        }
        window.setBackgroundDrawable(new ColorDrawable(i3));
        QUIMultiLineInputView qUIMultiLineInputView = (QUIMultiLineInputView) this.P.findViewById(R.id.wjn);
        this.T = qUIMultiLineInputView;
        qUIMultiLineInputView.setShowWordCount(false);
        this.T.setContentText(((IGuildEmotionCodecApi) QRoute.api(IGuildEmotionCodecApi.class)).toQQText(this.V, 20));
        QUIMultiLineInputView qUIMultiLineInputView2 = this.T;
        qUIMultiLineInputView2.setTextSelection(qUIMultiLineInputView2.d().length());
        initTitleBar();
        Mh();
        Oh(true);
        QUIMultiLineInputView qUIMultiLineInputView3 = this.T;
        if (QQTheme.isNowThemeIsNight()) {
            i16 = 1002;
        } else {
            i16 = 1001;
        }
        qUIMultiLineInputView3.setThemeId(i16);
    }

    public void Oh(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.mnr.QQGuildDescriptionEditFragment", 2, "toggleKeyboard: ", Boolean.valueOf(z16));
        }
        if (z16) {
            this.T.q();
            this.T.z();
        } else {
            this.T.p();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        initIntentData();
        initView();
        initDtReport();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.ev6;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void init(Bundle bundle) {
        super.init(bundle);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Oh(false);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Oh(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class c implements h53.n {
        c() {
        }

        @Override // h53.k
        public void afterTextChanged(Editable editable) {
            QQGuildDescriptionEditFragment.this.Hh();
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
