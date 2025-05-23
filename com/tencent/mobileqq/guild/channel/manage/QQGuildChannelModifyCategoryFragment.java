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
import com.tencent.mobileqq.guild.util.cb;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.guild.widget.CharacterCountEditText;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import vh2.bg;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQGuildChannelModifyCategoryFragment extends QQGuildTitleBarFragment implements CharacterCountEditText.c {
    private CharacterCountEditText V;
    private TextView W;
    private ImageView X;
    private String Y;
    private String Z;

    /* renamed from: a0, reason: collision with root package name */
    private long f215065a0;
    private int T = 1;
    private int U = 10;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f215066b0 = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements bg {
        a() {
        }

        @Override // vh2.bg
        public void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
            if (i3 != 0 || !ch.p(iGProSecurityResult)) {
                QQGuildChannelModifyCategoryFragment.this.f215066b0 = false;
                if (i3 == -7) {
                    ch.t1(BaseApplication.getContext(), i3, BaseApplication.getContext().getString(R.string.f140940fb), iGProSecurityResult);
                    return;
                } else {
                    SecurityTipHelperKt.J(iGProSecurityResult, QQGuildChannelModifyCategoryFragment.this.getContext(), i3, BaseApplication.getContext().getString(R.string.f141910hy));
                    return;
                }
            }
            QQToast.makeText(BaseApplication.getContext(), 2, HardCodeUtil.qqStr(R.string.f141470gr), 5000).show();
            if (QQGuildChannelModifyCategoryFragment.this.getActivity() != null) {
                QQGuildChannelModifyCategoryFragment.this.getActivity().finish();
            }
        }
    }

    public static Intent Ih(String str, String str2, long j3) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("extra_guild_id", str);
        bundle.putString("extra_channel_category", str2);
        bundle.putLong("extra_channel_category_id", j3);
        intent.putExtras(bundle);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Jh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        onBackEvent();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Kh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        InputMethodUtil.hide(this.V);
        Mh(this.V.getText().toString());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Lh() {
        InputMethodUtil.show(this.V);
    }

    private void Mh(String str) {
        if (this.f215066b0 || TextUtils.isEmpty(str)) {
            return;
        }
        if (str.equals(this.Z)) {
            if (getActivity() != null) {
                getActivity().finish();
            }
        } else if (TextUtils.isEmpty(str.trim())) {
            ch.f1(BaseApplication.getContext().getString(R.string.f141690hc));
        } else {
            if (!NetworkUtil.isNetworkAvailable()) {
                ch.f1(BaseApplication.getContext().getString(R.string.f141910hy));
                return;
            }
            InputMethodUtil.hide(this.V);
            this.f215066b0 = true;
            ((IGPSService) getAppInterface().getRuntimeService(IGPSService.class, "")).changeChannelCategoryName(this.Y, this.f215065a0, str, new a());
        }
    }

    private void Nh() {
        this.V.setFocusable(true);
        this.V.setFocusableInTouchMode(true);
        this.V.requestFocus();
        this.V.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.channel.manage.k
            @Override // java.lang.Runnable
            public final void run() {
                QQGuildChannelModifyCategoryFragment.this.Lh();
            }
        }, 800L);
    }

    private void initIntentData() {
        Intent intent = getActivity().getIntent();
        this.Y = intent.getStringExtra("extra_guild_id");
        this.Z = intent.getStringExtra("extra_channel_category");
        this.f215065a0 = intent.getLongExtra("extra_channel_category_id", 0L);
        if (this.Z == null) {
            this.Z = "";
        }
    }

    private void initView() {
        this.V = (CharacterCountEditText) this.P.findViewById(R.id.f165580ws0);
        this.W = (TextView) this.P.findViewById(R.id.wrz);
        this.X = (ImageView) this.P.findViewById(R.id.x26);
        this.V.setLimitCount(this.U);
        this.V.setCountChangeListener(this);
        this.V.setText(this.Z);
        this.V.setSelection(this.Z.length());
        Nh();
        this.X.setContentDescription(getResources().getString(R.string.f143030kz));
        this.X.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.channel.manage.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQGuildChannelModifyCategoryFragment.this.lambda$initView$0(view);
            }
        });
        setLeftButton(R.string.f140850f3, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.channel.manage.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQGuildChannelModifyCategoryFragment.this.Jh(view);
            }
        });
        setTitle(getString(R.string.f141490gt));
        setRightButton(R.string.f143340lt, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.channel.manage.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QQGuildChannelModifyCategoryFragment.this.Kh(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initView$0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.V.getText() != null && this.V.getText().length() > 0) {
            this.V.setText("");
        }
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
        if (this.T > 0) {
            int a16 = bVar.a();
            boolean z16 = false;
            this.W.setText(String.format("%s/%s", Integer.valueOf(this.U - a16), Integer.valueOf(this.U)));
            if (a16 >= this.T) {
                z16 = true;
            }
            setRightButtonEnable(z16);
        }
    }

    @Override // com.tencent.mobileqq.guild.widget.CharacterCountEditText.c
    public void Bf(cb.b bVar) {
    }
}
