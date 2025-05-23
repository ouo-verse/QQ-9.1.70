package com.tencent.mobileqq.guild.channel.manage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.cb;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.guild.widget.CharacterCountEditText;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import vh2.bg;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQGuildChannelCreateCategoryFragment extends QQGuildTitleBarFragment implements CharacterCountEditText.c {
    private CharacterCountEditText T;
    private TextView U;
    private ImageView V;
    private String W;
    private boolean X;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements bg {
        a() {
        }

        @Override // vh2.bg
        public void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
            QLog.i("Guild.mnr.QQGuildChannelCreateCategoryFragment", 1, "onGetChannelCategory result:" + i3 + ", errMsg:" + str);
            if (i3 == 0 && ch.p(iGProSecurityResult)) {
                QQToast.makeText(BaseApplication.getContext(), 2, HardCodeUtil.qqStr(R.string.f141280g9), 5000).show();
                if (QQGuildChannelCreateCategoryFragment.this.getActivity() != null) {
                    QQGuildChannelCreateCategoryFragment.this.getActivity().finish();
                    return;
                }
                return;
            }
            SecurityTipHelperKt.J(iGProSecurityResult, QQGuildChannelCreateCategoryFragment.this.getContext(), i3, BaseApplication.getContext().getString(R.string.f141910hy));
            QQGuildChannelCreateCategoryFragment.this.X = false;
        }
    }

    private boolean Ih(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(str.trim())) {
            ch.f1(BaseApplication.getContext().getString(R.string.f143510m_));
            return false;
        }
        if (!NetworkUtil.isNetworkAvailable()) {
            ch.f1(BaseApplication.getContext().getString(R.string.f141910hy));
            return false;
        }
        return true;
    }

    public static Intent Jh(String str) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("extra_guild_id", str);
        intent.putExtras(bundle);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Kh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!QQGuildUIUtil.v() && !this.X) {
            this.X = true;
            InputMethodUtil.hide(this.T);
            Nh(this.T.getText().toString());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Lh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.T.getText() != null && this.T.getText().length() > 0) {
            this.T.setText("");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Mh() {
        InputMethodUtil.show(this.T);
    }

    private void Nh(String str) {
        if (!Ih(str)) {
            this.X = false;
        } else {
            InputMethodUtil.hide(this.T);
            ((IGPSService) getAppInterface().getRuntimeService(IGPSService.class, "")).createChannelCategory(this.W, str, new a());
        }
    }

    private void Oh() {
        this.T.setFocusable(true);
        this.T.setFocusableInTouchMode(true);
        this.T.requestFocus();
        this.T.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.channel.manage.g
            @Override // java.lang.Runnable
            public final void run() {
                QQGuildChannelCreateCategoryFragment.this.Mh();
            }
        }, 800L);
    }

    private void initIntentData() {
        this.W = getActivity().getIntent().getStringExtra("extra_guild_id");
    }

    private void initView() {
        this.T = (CharacterCountEditText) this.P.findViewById(R.id.f165580ws0);
        this.U = (TextView) this.P.findViewById(R.id.wrz);
        this.V = (ImageView) this.P.findViewById(R.id.x26);
        setLeftButton(R.string.f140850f3, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.channel.manage.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQGuildChannelCreateCategoryFragment.this.lambda$initView$0(view);
            }
        });
        setTitle(getString(R.string.f141480gs));
        setRightButton(R.string.f143340lt, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.channel.manage.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQGuildChannelCreateCategoryFragment.this.Kh(view);
            }
        });
        this.V.setContentDescription(getResources().getString(R.string.f143030kz));
        this.V.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.channel.manage.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQGuildChannelCreateCategoryFragment.this.Lh(view);
            }
        });
        this.T.setLimitCount(10);
        this.T.setCountChangeListener(this);
        this.T.setText("");
        Oh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        onBackEvent();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        initIntentData();
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.eie;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        activity.overridePendingTransition(R.anim.f154630p2, R.anim.f154442w);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        super.onFinish();
        getQBaseActivity().overridePendingTransition(R.anim.f154442w, R.anim.f154636p8);
    }

    @Override // com.tencent.mobileqq.guild.widget.CharacterCountEditText.c
    public void s7(cb.b bVar) {
        int a16 = bVar.a();
        boolean z16 = false;
        this.U.setText(String.format("%s/%s", Integer.valueOf(10 - a16), 10));
        if (a16 >= 1) {
            z16 = true;
        }
        setRightButtonEnable(z16);
    }

    @Override // com.tencent.mobileqq.guild.widget.CharacterCountEditText.c
    public void Bf(cb.b bVar) {
    }
}
