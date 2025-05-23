package com.tencent.mobileqq.gamecenter.ui;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.protocols.GameAuthPubAccHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.List;

/* loaded from: classes12.dex */
public class GameCenterAuthPubAccGuideFragment extends QPublicBaseFragment implements View.OnClickListener {
    private View C;
    private String D;
    private String E;
    private CheckBox F;
    private ImageView G;
    private TextView H;
    private TextView I;
    private int J;
    private String K;
    private QUIButton L;
    private QUIButton M;
    private int N;

    private void initData() {
        Intent intent = getActivity().getIntent();
        this.E = String.valueOf(intent.getLongExtra("appId", 0L));
        this.D = intent.getStringExtra("appName");
        this.K = intent.getStringExtra("intent_key_pub_acc_wording");
        this.J = intent.getIntExtra("intent_key_pub_acc_type", 0);
    }

    private void initUI(View view) {
        View findViewById = view.findViewById(R.id.a47);
        this.C = findViewById;
        findViewById.setOnClickListener(this);
        this.G = (ImageView) view.findViewById(R.id.f164385vs);
        this.H = (TextView) view.findViewById(R.id.f164387vu);
        this.H.setText(getString(R.string.f1366204n, this.D));
        this.F = (CheckBox) view.findViewById(R.id.tpg);
        TextView textView = (TextView) view.findViewById(R.id.f110176ht);
        this.I = textView;
        textView.setText(this.K);
        this.L = (QUIButton) view.findViewById(R.id.tcr);
        QUIButton qUIButton = (QUIButton) view.findViewById(R.id.f164660te3);
        this.M = qUIButton;
        qUIButton.setOnClickListener(this);
        this.L.setOnClickListener(this);
        this.F.setOnClickListener(this);
        th();
    }

    private void ph() {
        if (!this.F.isChecked()) {
            QLog.i("GameCenterAuthPubAccGuideFragment", 1, "[followPubAcc], not checked, return!");
            return;
        }
        try {
            new GameAuthPubAccHandler().f(Integer.valueOf(this.E).intValue(), this.J, "game_login_auth_895");
        } catch (Throwable th5) {
            QLog.e("GameCenterAuthPubAccGuideFragment", 1, "[followPubAcc], error:" + th5);
        }
    }

    private String rh() {
        int i3 = this.J;
        if (i3 == 0) {
            return "2";
        }
        if (i3 == 1) {
            return "1";
        }
        return "0";
    }

    private void sh() {
        Intent intent = getActivity().getIntent();
        if (intent == null) {
            QLog.e("GameCenterAuthPubAccGuideFragment", 1, "fail to go to NextPage, intent is null.");
            return;
        }
        this.N = intent.getIntExtra("intent_key_request_code", 0);
        intent.putExtra("public_fragment_class", GameCenterAuthFragment.class.getName());
        getQBaseActivity().startActivityForResult(intent, this.N);
    }

    private void th() {
        List<hp3.d> d16;
        hp3.a c16 = hp3.b.e().c(this.E);
        if (c16 != null && (d16 = c16.d()) != null && d16.size() != 0) {
            int qh5 = qh(d16);
            if (qh5 < 0 || qh5 >= d16.size()) {
                qh5 = 0;
            }
            String str = d16.get(qh5).f405817a.get();
            ApngOptions apngOptions = new ApngOptions();
            apngOptions.setLoadingDrawable(new ColorDrawable(0));
            int n3 = Utils.n(24.0f, this.G.getResources());
            apngOptions.setRequestWidth(n3);
            apngOptions.setRequestHeight(n3);
            this.G.setImageDrawable(((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable(GameCenterAuthPubAccGuideFragment.class.getName(), str, apngOptions));
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, @Nullable Intent intent) {
        getQBaseActivity().setResult(i16, intent);
        if (this.N == i16) {
            getActivity().finish();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        String str2;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.L) {
            ph();
            sh();
            IGameMsgHelperApi iGameMsgHelperApi = (IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class);
            String str3 = this.E;
            String rh5 = rh();
            if (this.F.isChecked()) {
                str2 = "1";
            } else {
                str2 = "2";
            }
            iGameMsgHelperApi.reportForGameMsg(str3, "5", "971", "9225", "922501", "912713", "1", rh5, "20", str2);
        } else if (view == this.M) {
            sh();
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(this.E, "5", "971", "9225", "922501", "912713", "2", rh(), "20", "2");
        } else if (view == this.C) {
            if (getQBaseActivity() != null) {
                getQBaseActivity().finish();
            }
        } else {
            CheckBox checkBox = this.F;
            if (view == checkBox) {
                if (!checkBox.isChecked()) {
                    str = "1";
                } else {
                    str = "2";
                }
                ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(this.E, "5", "971", "9225", "922501", "912712", str, rh(), "20", "");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        initData();
        View inflate = layoutInflater.inflate(R.layout.ead, viewGroup, false);
        initUI(inflate);
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(this.E, "5", "971", "9225", "922501", "912711", "", rh(), "7", "");
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    protected int qh(List<hp3.d> list) {
        int size = list.size();
        int i3 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < size; i17++) {
            int a16 = com.tencent.open.agent.util.o.a(list.get(i17).f405818b.get());
            if (a16 < 100) {
                if (a16 > i3) {
                    i16 = i17;
                    i3 = a16;
                }
            } else {
                return i17;
            }
        }
        return i16;
    }
}
