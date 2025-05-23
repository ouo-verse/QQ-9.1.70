package com.tencent.open.agent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.gamecenter.api.IGameCenterAuthApi;
import com.tencent.mobileqq.minispecial.api.impl.ThirdPartyMiniApiImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes22.dex */
public class GameCenterAuthFrament4QQSetting extends IphoneTitleBarFragment implements View.OnClickListener, com.tencent.mobileqq.gamecenter.data.k {
    private View C;
    private RelativeLayout D;
    private RelativeLayout E;
    private RelativeLayout F;
    private TextView G;
    private TextView H;
    private TextView I;
    private TextView J;
    private TextView K;
    private TextView L;
    private TextView M;
    private boolean N = false;
    private String P;
    private String Q;
    private TextView R;
    private com.tencent.mobileqq.gamecenter.api.b S;

    private void initData() {
        int intExtra = getActivity().getIntent().getIntExtra(ThirdPartyMiniApiImpl.KEY_GAME_APP_ID, -1);
        if (QLog.isColorLevel()) {
            QLog.d("GameCenterAuthFrament4QQSetting", 2, "appId:" + intExtra);
        }
        this.P = String.valueOf(intExtra);
        com.tencent.mobileqq.gamecenter.api.b gameAuthHelper = ((IGameCenterAuthApi) QRoute.api(IGameCenterAuthApi.class)).getGameAuthHelper(getActivity(), this.P, this);
        this.S = gameAuthHelper;
        gameAuthHelper.getAuthFromServer();
    }

    private void initUI() {
        this.D = (RelativeLayout) this.C.findViewById(R.id.vil);
        this.E = (RelativeLayout) this.C.findViewById(R.id.vik);
        this.F = (RelativeLayout) this.C.findViewById(R.id.vim);
        this.G = (TextView) this.C.findViewById(R.id.vhu);
        this.H = (TextView) this.C.findViewById(R.id.vht);
        this.I = (TextView) this.C.findViewById(R.id.vhs);
        this.J = (TextView) this.C.findViewById(R.id.vhz);
        this.K = (TextView) this.C.findViewById(R.id.vhy);
        this.L = (TextView) this.C.findViewById(R.id.vhx);
        this.M = (TextView) this.C.findViewById(R.id.vhw);
        this.R = (TextView) this.C.findViewById(R.id.f165314vi1);
        this.E.setOnClickListener(this);
        this.D.setOnClickListener(this);
        this.F.setOnClickListener(this);
        this.M.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void th(List list) {
        try {
            if (this.H != null && this.K != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    com.tencent.mobileqq.gamecenter.data.b bVar = (com.tencent.mobileqq.gamecenter.data.b) it.next();
                    if (bVar != null) {
                        String rangeString = ((IGameCenterAuthApi) QRoute.api(IGameCenterAuthApi.class)).getRangeString(MobileQQ.sMobileQQ, bVar.f211988b);
                        if (!TextUtils.isEmpty(rangeString)) {
                            if (QLog.isColorLevel()) {
                                QLog.d("GameCenterAuthFrament4QQSetting", 2, "[onAuthRangeChanged], title:" + bVar.f211989c + ", range:" + rangeString + ", text:" + bVar.f211990d);
                            }
                            int i3 = bVar.f211987a;
                            if (i3 == 1) {
                                this.H.setText(rangeString);
                                if (!TextUtils.isEmpty(bVar.f211989c)) {
                                    this.G.setText(bVar.f211989c);
                                }
                                if (!TextUtils.isEmpty(bVar.f211990d)) {
                                    this.I.setText(bVar.f211990d);
                                }
                            } else if (i3 == 2) {
                                this.K.setText(rangeString);
                                if (!TextUtils.isEmpty(bVar.f211989c)) {
                                    this.J.setText(bVar.f211989c);
                                }
                                if (!TextUtils.isEmpty(bVar.f211990d)) {
                                    this.L.setText(bVar.f211990d);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e16) {
            QLog.e("GameCenterAuthFrament4QQSetting", 1, "[onAuthRangeChanged], e:" + e16.getMessage());
        }
    }

    private void vh(Context context, Intent intent, String str) {
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, str);
        activityURIRequest.extra().putAll(intent.getExtras());
        activityURIRequest.setFlags(intent.getFlags());
        QRoute.startUri(activityURIRequest, (com.tencent.mobileqq.qroute.route.o) null);
    }

    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        this.C = ((IphoneTitleBarFragment) this).mContentView;
        initData();
        initUI();
        setTitle(getBaseActivity().getString(R.string.f1366404p));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.IphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.eaf;
    }

    @Override // com.tencent.mobileqq.gamecenter.data.k
    public void onAuthRangeChanged(final List<com.tencent.mobileqq.gamecenter.data.b> list) {
        if (!this.N && list != null) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.open.agent.d
                @Override // java.lang.Runnable
                public final void run() {
                    GameCenterAuthFrament4QQSetting.this.th(list);
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.E) {
            this.S.c(1);
        } else if (view == this.F) {
            this.S.c(2);
        } else if (view == this.M) {
            uh();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.N = true;
        this.S.onDestroy();
    }

    @Override // com.tencent.mobileqq.gamecenter.data.k
    public void onGetRangeUrl(final String str, final String str2) {
        if (this.N) {
            return;
        }
        this.Q = str;
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.open.agent.GameCenterAuthFrament4QQSetting.1
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(str)) {
                    GameCenterAuthFrament4QQSetting.this.M.setVisibility(8);
                } else {
                    GameCenterAuthFrament4QQSetting.this.M.setVisibility(0);
                }
                if (!TextUtils.isEmpty(str2)) {
                    GameCenterAuthFrament4QQSetting.this.R.setText(str2);
                }
            }
        });
    }

    public void uh() {
        if (TextUtils.isEmpty(this.Q)) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("url", this.Q);
        vh(getActivity(), intent, RouterConstants.UI_ROUTE_BROWSER);
    }
}
