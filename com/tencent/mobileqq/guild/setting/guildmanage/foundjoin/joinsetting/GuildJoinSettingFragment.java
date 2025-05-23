package com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.base.QQGuildTokenTitleBarFragment;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.GWGProJoinGuildChoiceQuestion;
import com.tencent.mobileqq.qqguildsdk.data.genc.GWGProJoinGuildWordQuestion;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.inputview.QUISingleLineInputView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import java.util.HashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildJoinSettingFragment extends QQGuildTokenTitleBarFragment implements View.OnClickListener {
    private ImageView T;
    private CheckBox U;
    private CheckBox V;
    private ImageView W;
    private CheckBox X;
    private CheckBox Y;
    private ImageView Z;

    /* renamed from: a0, reason: collision with root package name */
    private LinearLayout f233855a0;

    /* renamed from: b0, reason: collision with root package name */
    private QUISingleLineInputView f233856b0;

    /* renamed from: c0, reason: collision with root package name */
    private LinearLayout f233857c0;

    /* renamed from: d0, reason: collision with root package name */
    private TextView f233858d0;

    /* renamed from: e0, reason: collision with root package name */
    private TextView f233859e0;

    /* renamed from: f0, reason: collision with root package name */
    private t f233860f0;

    private void Lh(int i3) {
        if (i3 != 5) {
            return;
        }
        this.f233856b0.setEditTextRequestFocused();
    }

    private View.OnClickListener Mh() {
        return new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildJoinSettingFragment.this.Vh(view);
            }
        };
    }

    public static Intent Nh(String str) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("extra_guild_id", str);
        intent.putExtras(bundle);
        return intent;
    }

    private void Oh() {
        InputMethodUtil.hide(getActivity());
    }

    private void Ph() {
        RelativeLayout relativeLayout = (RelativeLayout) this.P.findViewById(R.id.f165600ww0);
        relativeLayout.setOnClickListener(this);
        relativeLayout.setTag(1);
        RelativeLayout relativeLayout2 = (RelativeLayout) this.P.findViewById(R.id.ww9);
        relativeLayout2.setOnClickListener(this);
        relativeLayout2.setTag(2);
        RelativeLayout relativeLayout3 = (RelativeLayout) this.P.findViewById(R.id.ww6);
        relativeLayout3.setOnClickListener(this);
        relativeLayout3.setTag(3);
        RelativeLayout relativeLayout4 = (RelativeLayout) this.P.findViewById(R.id.sq8);
        relativeLayout4.setOnClickListener(this);
        relativeLayout4.setTag(5);
        RelativeLayout relativeLayout5 = (RelativeLayout) this.P.findViewById(R.id.sq5);
        relativeLayout5.setOnClickListener(this);
        relativeLayout5.setTag(6);
        RelativeLayout relativeLayout6 = (RelativeLayout) this.P.findViewById(R.id.f7585403);
        relativeLayout6.setOnClickListener(this);
        relativeLayout6.setTag(7);
        ((RelativeLayout) this.P.findViewById(R.id.f165604ww4)).setOnClickListener(this);
        this.N.setOnClickListener(this);
        this.P.findViewById(R.id.f99885r0).setOnClickListener(this);
    }

    @SuppressLint({"NewApi"})
    private void Qh() {
        Ph();
        this.f233855a0 = (LinearLayout) this.P.findViewById(R.id.sq7);
        this.T = (ImageView) this.P.findViewById(R.id.xzz);
        this.U = (CheckBox) this.P.findViewById(R.id.y_k);
        this.V = (CheckBox) this.P.findViewById(R.id.f165900y00);
        this.W = (ImageView) this.P.findViewById(R.id.y69);
        this.X = (CheckBox) this.P.findViewById(R.id.y6q);
        this.Y = (CheckBox) this.P.findViewById(R.id.f165901y01);
        this.Z = (ImageView) this.P.findViewById(R.id.y6d);
        this.f233858d0 = (TextView) this.P.findViewById(R.id.f110366ib);
        this.f233859e0 = (TextView) this.P.findViewById(R.id.f109876h0);
        QUISingleLineInputView qUISingleLineInputView = (QUISingleLineInputView) this.P.findViewById(R.id.sq6);
        this.f233856b0 = qUISingleLineInputView;
        qUISingleLineInputView.setInputViewWatcher(new a());
        this.f233857c0 = (LinearLayout) this.P.findViewById(R.id.ww5);
    }

    private void Rh() {
        this.E.setText(getString(R.string.f1490611_));
        this.C.setOnClickListener(Mh());
        this.F.setText(R.string.f143340lt);
        this.F.setTextColor(getResources().getColorStateList(R.color.bth));
        this.F.setVisibility(0);
        this.F.setOnClickListener(this);
        this.F.setEnabled(false);
    }

    private void Sh() {
        this.f233860f0.N1().observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildJoinSettingFragment.this.Wh((Boolean) obj);
            }
        });
        this.f233860f0.O1().observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildJoinSettingFragment.this.Xh((GuildJoinEditData) obj);
            }
        });
        this.f233860f0.Q1().observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildJoinSettingFragment.this.Yh((cf1.a) obj);
            }
        });
        this.f233860f0.P1().observe(this, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildJoinSettingFragment.this.Zh((Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Th(DialogInterface dialogInterface, int i3) {
        onBackEvent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Vh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.f233860f0.S1()) {
            com.tencent.mobileqq.guild.util.qqui.c.b(getContext(), 230, null, "\u786e\u5b9a\u653e\u5f03\u5bf9\u6210\u5458\u52a0\u5165\u65b9\u5f0f\u7684\u4fee\u6539\u5417?", QQGuildUIUtil.r(R.string.f146970vm), QQGuildUIUtil.r(R.string.f147040vt), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.o
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    GuildJoinSettingFragment.this.Th(dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.p
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    dialogInterface.dismiss();
                }
            }).show();
        } else {
            onBackEvent();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Wh(Boolean bool) {
        if (bool != null && bool.booleanValue() && getActivity() != null) {
            Oh();
            getActivity().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Xh(GuildJoinEditData guildJoinEditData) {
        if (guildJoinEditData == null) {
            return;
        }
        ci(guildJoinEditData.getMOptionType());
        if (TextUtils.isEmpty(guildJoinEditData.getMQuestionWithAdminReview())) {
            this.f233856b0.setContentText("");
        } else {
            this.f233856b0.setContentText(guildJoinEditData.getMQuestionWithAdminReview());
        }
        GWGProJoinGuildWordQuestion mWordQuestion = guildJoinEditData.getMWordQuestion();
        if (mWordQuestion != null && mWordQuestion.getItems().size() > 0) {
            this.f233858d0.setText(mWordQuestion.getItems().size() + "\u9898");
        } else {
            this.f233858d0.setText("");
        }
        GWGProJoinGuildChoiceQuestion mChoiceQuestion = guildJoinEditData.getMChoiceQuestion();
        if (mChoiceQuestion != null && mChoiceQuestion.getNeedAnswerNum() != 0) {
            if (mChoiceQuestion.getNeedAnswerNum() == mChoiceQuestion.getPassCorrectNum()) {
                this.f233859e0.setText(mChoiceQuestion.getNeedAnswerNum() + "\u9898\u5168\u90e8\u7b54\u5bf9");
                return;
            }
            this.f233859e0.setText(mChoiceQuestion.getNeedAnswerNum() + "\u9898\u7b54\u5bf9" + mChoiceQuestion.getPassCorrectNum() + "\u9898");
            return;
        }
        this.f233859e0.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Yh(cf1.a aVar) {
        String str;
        if (aVar != null && aVar.f30772b == 0 && ch.p(aVar.f30773c)) {
            ch.u1(getContext(), aVar.f30771a);
        } else if (aVar != null) {
            if (TextUtils.isEmpty(aVar.f30771a)) {
                str = getContext().getResources().getString(R.string.f147080vx);
            } else {
                str = aVar.f30771a;
            }
            SecurityTipHelperKt.J(aVar.f30773c, getContext(), aVar.f30772b, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Zh(Boolean bool) {
        if (bool != null && bool.booleanValue()) {
            this.F.setEnabled(true);
        } else {
            this.F.setEnabled(false);
        }
    }

    private void ai() {
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(this.C, "em_sgrp_auditset_back", null);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(this.F, "em_sgrp_auditset_done", null);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(this.P.findViewById(R.id.f165600ww0), "em_sgrp_auditset_everyone", null);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(this.P.findViewById(R.id.ww9), "em_sgrp_auditset_sendmessageandaudit", null);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(this.P.findViewById(R.id.sq8), "em_sgrp_auditset_answerquestionandaudit", null);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(this.P.findViewById(R.id.sq5), "em_sgrp_auditset_correctanswerandpass", null);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementExposureAndClickParams(this.P.findViewById(R.id.ww6), "em_sgrp_auditset_refuse", null);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementClickParams(this.P.findViewById(R.id.f165604ww4), "em_sgrp_need_authentication", null);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementClickParams(this.P.findViewById(R.id.ww9), "em_sgrp_need_authentication_item", new HashMap<String, Object>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.GuildJoinSettingFragment.2
            {
                put("sgrp_option_type", 1);
            }
        });
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementClickParams(this.P.findViewById(R.id.sq8), "em_sgrp_need_authentication_item", new HashMap<String, Object>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.GuildJoinSettingFragment.3
            {
                put("sgrp_option_type", 2);
            }
        });
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementClickParams(this.P.findViewById(R.id.sq5), "em_sgrp_need_authentication_item", new HashMap<String, Object>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.GuildJoinSettingFragment.4
            {
                put("sgrp_option_type", 3);
            }
        });
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setElementClickParams(this.P.findViewById(R.id.f7585403), "em_sgrp_need_authentication_item", new HashMap<String, Object>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.foundjoin.joinsetting.GuildJoinSettingFragment.5
            {
                put("sgrp_option_type", 4);
            }
        });
    }

    private void bi() {
        String stringExtra = getActivity().getIntent().getStringExtra("extra_guild_id");
        ((IGPSService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IGPSService.class, "")).getGuildInfo(stringExtra);
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(this.P.getRootView(), "pg_sgrp_auditset");
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(this.P.getRootView(), stringExtra, null);
    }

    private void ci(int i3) {
        int i16;
        boolean z16;
        boolean z17;
        int i17;
        boolean z18;
        int i18;
        ImageView imageView = this.T;
        int i19 = 8;
        boolean z19 = true;
        if (i3 == 1) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        imageView.setVisibility(i16);
        CheckBox checkBox = this.U;
        if (i3 == 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        checkBox.setChecked(z16);
        CheckBox checkBox2 = this.V;
        if (i3 == 5) {
            z17 = true;
        } else {
            z17 = false;
        }
        checkBox2.setChecked(z17);
        ImageView imageView2 = this.W;
        if (i3 != 2 && i3 != 7 && i3 != 6 && i3 != 5) {
            i17 = 8;
        } else {
            i17 = 0;
        }
        imageView2.setVisibility(i17);
        this.f233857c0.setVisibility(this.W.getVisibility());
        CheckBox checkBox3 = this.X;
        if (i3 == 7) {
            z18 = true;
        } else {
            z18 = false;
        }
        checkBox3.setChecked(z18);
        CheckBox checkBox4 = this.Y;
        if (i3 != 6) {
            z19 = false;
        }
        checkBox4.setChecked(z19);
        ImageView imageView3 = this.Z;
        if (i3 == 3) {
            i18 = 0;
        } else {
            i18 = 8;
        }
        imageView3.setVisibility(i18);
        LinearLayout linearLayout = this.f233855a0;
        if (i3 == 5) {
            i19 = 0;
        }
        linearLayout.setVisibility(i19);
        if (i3 != 5) {
            Oh();
        }
    }

    private void initViewModel() {
        String stringExtra = getActivity().getIntent().getStringExtra("extra_guild_id");
        if (QLog.isColorLevel()) {
            QLog.d("QQGuildCustomTitleBarFragment", 1, "initViewModel get guildId is " + stringExtra);
        }
        t tVar = (t) com.tencent.mobileqq.mvvm.h.b(this, t.H).get(t.class);
        this.f233860f0 = tVar;
        tVar.T1(getAppInterface(), getActivity().getIntent().getStringExtra("extra_guild_id"));
        Sh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        Rh();
        Qh();
        initViewModel();
        bi();
        ai();
        rh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.evh;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        super.initWindowStyleAndAnimation(activity);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, @Nullable Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i3 == 10098) {
            if (intent != null) {
                this.f233860f0.c2((GWGProJoinGuildWordQuestion) intent.getExtras().getSerializable("question_result"));
                return;
            }
            return;
        }
        if (i3 == 10099 && intent != null) {
            this.f233860f0.b2((GWGProJoinGuildChoiceQuestion) intent.getExtras().getSerializable("choice_result"));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        GWGProJoinGuildChoiceQuestion mChoiceQuestion;
        GWGProJoinGuildWordQuestion mWordQuestion;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.F) {
            this.f233860f0.a2();
        } else if (view.getId() == R.id.f165604ww4) {
            this.f233860f0.Z1();
        }
        if (view.getId() == R.id.sq5) {
            if (this.f233860f0.O1().getValue() != null) {
                GuildJoinEditData value = this.f233860f0.O1().getValue();
                IQQGuildRouterApi iQQGuildRouterApi = (IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class);
                Context context = getContext();
                String stringExtra = getActivity().getIntent().getStringExtra("extra_guild_id");
                if (value.getMWordQuestion() == null) {
                    mWordQuestion = new GWGProJoinGuildWordQuestion();
                } else {
                    mWordQuestion = value.getMWordQuestion();
                }
                iQQGuildRouterApi.openGuildJoinQuestionAnswer(context, stringExtra, mWordQuestion, 10098);
            }
        } else if (view.getId() == R.id.f7585403 && this.f233860f0.O1().getValue() != null) {
            GuildJoinEditData value2 = this.f233860f0.O1().getValue();
            IQQGuildRouterApi iQQGuildRouterApi2 = (IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class);
            Context context2 = getContext();
            String stringExtra2 = getActivity().getIntent().getStringExtra("extra_guild_id");
            if (value2.getMChoiceQuestion() == null) {
                mChoiceQuestion = new GWGProJoinGuildChoiceQuestion();
            } else {
                mChoiceQuestion = value2.getMChoiceQuestion();
            }
            iQQGuildRouterApi2.openGuildJoinTest(context2, stringExtra2, mChoiceQuestion, 10099);
        }
        if (view.getId() == this.N.getId() || view.getId() == this.P.getId() || view.getId() == R.id.f99885r0) {
            Oh();
        }
        if (view.getTag() != null) {
            this.f233860f0.R1(((Integer) view.getTag()).intValue(), this.f233856b0.d().toString());
            Lh(((Integer) view.getTag()).intValue());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        super.onFinish();
        Oh();
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void rh() {
        this.J.a();
        this.J.setBackgroundResource(R.drawable.lvj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements h53.q {
        a() {
        }

        @Override // h53.k
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            GuildJoinSettingFragment.this.f233860f0.X1(charSequence.toString());
        }

        @Override // h53.q
        public void A4(String str) {
        }

        @Override // h53.k
        public void afterTextChanged(Editable editable) {
        }

        @Override // h53.k
        public void f8(boolean z16) {
        }

        @Override // h53.k
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        }
    }
}
