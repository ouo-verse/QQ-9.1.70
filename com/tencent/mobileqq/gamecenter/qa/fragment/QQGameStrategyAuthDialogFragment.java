package com.tencent.mobileqq.gamecenter.qa.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gamecenter.qa.api.IQQGameStrategyApi;
import com.tencent.mobileqq.gamecenter.qa.data.GameStrategyAuthRequire;
import com.tencent.mobileqq.gamecenter.qa.data.GameStrategyChannelEntry;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQGameStrategyAuthDialogFragment extends ReportAndroidXDialogFragment {
    private View C;
    private ImageView D;
    private LinearLayout E;
    private TextView F;
    private TextView G;
    private LinearLayout H;
    private TextView I;
    private Button J;
    private LinearLayout K;
    private Button L;
    private AuthStatus M;
    private com.tencent.mobileqq.gamecenter.qa.model.h N;
    private fe1.c P;
    private boolean Q = true;
    private fe1.d R = new fe1.a() { // from class: com.tencent.mobileqq.gamecenter.qa.fragment.QQGameStrategyAuthDialogFragment.4
        @Override // fe1.a, fe1.d
        public void onGetAuthJoin(final long j3, int i3, final boolean z16) {
            QLog.d("QQGameStrategyAnswerFragment", 1, "onGetAuthJoin errorCode:", Long.valueOf(j3), ",isJoin:", Boolean.valueOf(z16));
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.qa.fragment.QQGameStrategyAuthDialogFragment.4.1
                @Override // java.lang.Runnable
                public void run() {
                    if (j3 != 0) {
                        QQGameStrategyAuthDialogFragment.this.xh(AuthStatus.FAIL);
                    } else if (z16) {
                        QQGameStrategyAuthDialogFragment.this.xh(AuthStatus.SUCCESS);
                    } else {
                        QQGameStrategyAuthDialogFragment.this.xh(AuthStatus.FAIL);
                    }
                }
            });
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public enum AuthStatus {
        INIT,
        LOADING,
        FAIL,
        SUCCESS
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QQGameStrategyAuthDialogFragment.this.sh();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QQGameStrategyAuthDialogFragment.this.dismiss();
            EventCollector.getInstance().onViewClicked(view);
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
            QQGameStrategyAuthDialogFragment.this.vh();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f212498a;

        static {
            int[] iArr = new int[AuthStatus.values().length];
            f212498a = iArr;
            try {
                iArr[AuthStatus.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f212498a[AuthStatus.LOADING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f212498a[AuthStatus.FAIL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f212498a[AuthStatus.SUCCESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private void initViews(View view) {
        this.D = (ImageView) view.findViewById(R.id.f88644xm);
        this.E = (LinearLayout) view.findViewById(R.id.f88664xo);
        this.F = (TextView) view.findViewById(R.id.f88744xw);
        this.G = (TextView) view.findViewById(R.id.f88724xu);
        this.H = (LinearLayout) view.findViewById(R.id.f88714xt);
        this.I = (TextView) view.findViewById(R.id.f88734xv);
        this.J = (Button) view.findViewById(R.id.f88674xp);
        this.K = (LinearLayout) view.findViewById(R.id.f88694xr);
        xh(AuthStatus.INIT);
        this.J.setOnClickListener(new a());
        view.findViewById(R.id.f88684xq).setOnClickListener(new b());
        Button button = (Button) view.findViewById(R.id.f88704xs);
        this.L = button;
        button.setOnClickListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sh() {
        if (this.M == AuthStatus.INIT) {
            xh(AuthStatus.LOADING);
            this.P.L0(this.N.f212650a);
        }
    }

    public static Bundle th(int i3, long j3, String str, GameStrategyChannelEntry gameStrategyChannelEntry, GameStrategyAuthRequire gameStrategyAuthRequire) {
        Bundle bundle = new Bundle();
        bundle.putInt("appId", i3);
        bundle.putLong("questionId", j3);
        bundle.putString("questionContent", str);
        bundle.putSerializable("channelEntry", gameStrategyChannelEntry);
        bundle.putSerializable("authRequire", gameStrategyAuthRequire);
        bundle.putBoolean("authTowardsAnswer", true);
        return bundle;
    }

    public static Bundle uh(int i3, GameStrategyAuthRequire gameStrategyAuthRequire) {
        Bundle bundle = new Bundle();
        bundle.putInt("appId", i3);
        bundle.putSerializable("authRequire", gameStrategyAuthRequire);
        bundle.putBoolean("authTowardsAnswer", false);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vh() {
        AuthStatus authStatus = this.M;
        if (authStatus == AuthStatus.FAIL) {
            String format = String.format("https://speed.gamecenter.qq.com/pushgame/v1/detail-v2?_wv=2164260896&_wwv=448&appid=%s", String.valueOf(this.N.f212650a));
            Intent intent = new Intent(getActivity(), (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", format);
            getActivity().startActivity(intent);
            dismiss();
            return;
        }
        if (authStatus == AuthStatus.SUCCESS) {
            if (this.Q) {
                IQQGameStrategyApi iQQGameStrategyApi = (IQQGameStrategyApi) QRoute.api(IQQGameStrategyApi.class);
                QBaseActivity qBaseActivity = (QBaseActivity) getActivity();
                com.tencent.mobileqq.gamecenter.qa.model.h hVar = this.N;
                iQQGameStrategyApi.openGameStrategyAnswerDialog(qBaseActivity, hVar.f212650a, hVar.f212651b, hVar.f212652c, hVar.f212654e);
            }
            dismiss();
        }
    }

    private void wh() {
        GameStrategyAuthRequire gameStrategyAuthRequire = this.N.f212655f;
        if (gameStrategyAuthRequire != null) {
            this.G.setText(gameStrategyAuthRequire.reqDoc);
        }
        fe1.c cVar = new fe1.c();
        this.P = cVar;
        cVar.Z0(this.R);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xh(AuthStatus authStatus) {
        String string;
        this.M = authStatus;
        int i3 = d.f212498a[authStatus.ordinal()];
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 == 4) {
                    this.H.setVisibility(8);
                    this.G.setVisibility(8);
                    this.F.setText(getResources().getString(R.string.f1370105p));
                    this.I.setVisibility(0);
                    GameStrategyAuthRequire gameStrategyAuthRequire = this.N.f212655f;
                    if (gameStrategyAuthRequire != null) {
                        string = gameStrategyAuthRequire.successAuthDoc;
                    } else {
                        string = getResources().getString(R.string.f1370005o);
                    }
                    this.I.setText(string);
                    this.J.setVisibility(8);
                    this.K.setVisibility(0);
                    this.L.setText(getResources().getString(R.string.f1370205q));
                    this.D.setVisibility(4);
                    this.E.setVisibility(0);
                    return;
                }
                return;
            }
            this.H.setVisibility(8);
            this.I.setVisibility(0);
            this.I.setText(getResources().getString(R.string.f1369405i));
            this.J.setEnabled(true);
            this.J.setVisibility(8);
            this.K.setVisibility(0);
            this.L.setText(getResources().getString(R.string.f1369505j));
            return;
        }
        this.H.setVisibility(0);
        this.J.setEnabled(false);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.a0i);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        this.N = new com.tencent.mobileqq.gamecenter.qa.model.h();
        if (arguments != null) {
            this.Q = arguments.getBoolean("authTowardsAnswer", true);
            this.N.f212650a = arguments.getInt("appId");
            this.N.f212655f = (GameStrategyAuthRequire) arguments.getSerializable("authRequire");
            if (this.Q) {
                this.N.f212651b = arguments.getLong("questionId");
                this.N.f212652c = arguments.getString("questionContent");
                this.N.f212654e = (GameStrategyChannelEntry) arguments.getSerializable("channelEntry");
            }
            QLog.i("QQGameStrategyAnswerFragment", 1, String.format("onCreateView isNeedGoAnswer:%b", Boolean.valueOf(this.Q)));
        }
        View inflate = layoutInflater.inflate(R.layout.ec5, viewGroup, false);
        this.C = inflate;
        initViews(inflate);
        wh();
        View view = this.C;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.P.N0();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        ((View) this.C.getParent()).setBackgroundColor(0);
    }
}
