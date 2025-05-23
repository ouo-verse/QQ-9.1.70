package com.tencent.mobileqq.gamecenter.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.gamecenter.api.IGameCenterAuthApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameDataAuthorizeSvr$LoginGuide;
import com.tencent.mobileqq.gamecenter.trpcprotocol.GameDataAuthorizeSvr$Reminder;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyRouter;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;
import com.tencent.open.agent.auth.api.IOpenAuthGameCenterPageReporter;
import com.tencent.open.agent.auth.api.IOpenAuthPageOperation;
import com.tencent.open.api.IOpenSdkApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GameCenterAuthFragment extends QPublicBaseFragment implements View.OnClickListener, com.tencent.mobileqq.gamecenter.data.k, com.tencent.mobileqq.gamecenter.data.l {
    private View C;
    private View D;
    private RelativeLayout E;
    private RelativeLayout F;
    private RelativeLayout G;
    private TextView H;
    private TextView I;
    private TextView J;
    private TextView K;
    private TextView L;
    private TextView M;
    private TextView N;
    private View P;
    private TextView Q;
    private ImageView R;
    private TextView S;
    private com.tencent.mobileqq.gamecenter.logic.a T;
    private boolean U = false;
    private String V;
    private String W;
    private String X;
    private List<com.tencent.mobileqq.gamecenter.data.b> Y;
    private z Z;

    /* renamed from: a0, reason: collision with root package name */
    private LinearLayout f213237a0;

    /* renamed from: b0, reason: collision with root package name */
    private TextView f213238b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f213239c0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            GameCenterAuthFragment.this.T.g();
            ((IOpenAuthGameCenterPageReporter) QRoute.api(IOpenAuthGameCenterPageReporter.class)).recordGameAuthItemList(GameCenterAuthFragment.this.getActivity(), GameCenterAuthFragment.this.T.h());
            ((IOpenAuthGameCenterPageReporter) QRoute.api(IOpenAuthGameCenterPageReporter.class)).reportBackDialogConfirmClick();
            if (dq3.f.f394643a.t() && GameCenterAuthFragment.this.getQBaseActivity() != null) {
                ((IOpenSdkApi) QRoute.api(IOpenSdkApi.class)).openRecommendFragment(GameCenterAuthFragment.this.getQBaseActivity());
            } else {
                ((IOpenAuthPageOperation) QRoute.api(IOpenAuthPageOperation.class)).onClickAuthBtn(GameCenterAuthFragment.this.getQBaseActivity());
            }
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(GameCenterAuthFragment.this.V, "5", "971", "9045", "904501", "209741", "", "", "20", "");
            GameCenterAuthFragment gameCenterAuthFragment = GameCenterAuthFragment.this;
            gameCenterAuthFragment.Nh(2, gameCenterAuthFragment.Y);
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
            ((IOpenAuthGameCenterPageReporter) QRoute.api(IOpenAuthGameCenterPageReporter.class)).reportBackDialogCancelClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d extends ClickableSpan {
        d() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            String str;
            z.S(GameCenterAuthFragment.this.getActivity(), GameCenterAuthFragment.this.X, GameCenterAuthFragment.this.V);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("ext2", "1");
            hashMap.put("ext3", "1");
            hashMap.put("ext4", "20");
            hashMap.put("ext15", String.valueOf(ah.K()));
            hashMap.put("ext10", ah.F());
            if (!TextUtils.isEmpty(GameCenterAuthFragment.this.f213239c0)) {
                str = GameCenterAuthFragment.this.f213239c0;
            } else {
                str = "-1";
            }
            hashMap.put("ext29", str);
            hashMap.put("adtag", "hulian_login");
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(GameCenterAuthFragment.this.V, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9388", "938801", "914136", "", hashMap);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            if (textPaint != null) {
                textPaint.setUnderlineText(false);
            }
        }
    }

    private void Jh(View view) {
        View findViewById = view.findViewById(R.id.bix);
        if (findViewById.getLayoutParams() != null) {
            findViewById.getLayoutParams().height = 1;
            findViewById.setLayoutParams(findViewById.getLayoutParams());
        }
        View findViewById2 = view.findViewById(R.id.biy);
        if (findViewById2.getLayoutParams() != null) {
            findViewById2.getLayoutParams().height = 1;
            findViewById2.setLayoutParams(findViewById2.getLayoutParams());
        }
        View findViewById3 = view.findViewById(R.id.biz);
        if (findViewById3.getLayoutParams() != null) {
            findViewById3.getLayoutParams().height = 1;
            findViewById3.setLayoutParams(findViewById3.getLayoutParams());
        }
    }

    private void Kh() {
        QLog.i("GameCenterAuthFragment", 1, "[clearPkgRecord]");
        QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").encodeString("qq_login_game_pkg_name", "pkg_name_null");
        QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").encodeString("qq_login_game_app_id", "pkg_name_null");
    }

    private void Lh() {
        if (this.N == null) {
            return;
        }
        this.N.setText(String.format(getContext().getResources().getString(R.string.f1365704i), this.W));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Mh(int i3, JSONObject jSONObject, String str, String str2, JSONObject jSONObject2) throws JSONException {
        FragmentActivity activity = getActivity();
        if (!TextUtils.isEmpty(this.V) && !TextUtils.isEmpty(this.X) && activity != null) {
            KuiklyLaunchParams kuiklyLaunchParams = new KuiklyLaunchParams();
            kuiklyLaunchParams.setPageName("QQGameOfficialInstallPage");
            kuiklyLaunchParams.setResId("gamecenter_official_install");
            kuiklyLaunchParams.setDynamicMode(true);
            kuiklyLaunchParams.setModal(true);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("appid", this.V);
            jSONObject3.put("packageName", this.X);
            jSONObject3.put("channelId", this.f213239c0);
            jSONObject3.put("guideTip", str2);
            jSONObject3.put("uiStyle", i3);
            jSONObject3.put("picUrl", str);
            jSONObject3.put(NotificationCompat.CATEGORY_REMINDER, jSONObject);
            jSONObject3.put("policy", jSONObject2);
            jSONObject3.put("osVersion", String.valueOf(ah.K()));
            kuiklyLaunchParams.getExtMap().put("gameExtraInfo", jSONObject3.toString());
            ((IQQKuiklyRouter) QRoute.api(IQQKuiklyRouter.class)).launchKuiklyPage(activity, kuiklyLaunchParams);
            return true;
        }
        QLog.i("GameCenterAuthFragment", 1, "openInstallDialog  params invalid,mAppId:" + this.V + ",mPkgName:" + this.X);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Nh(int i3, List<com.tencent.mobileqq.gamecenter.data.b> list) {
        if (list != null && !list.isEmpty()) {
            this.T.q(i3, list);
            HashMap<String, String> hashMap = new HashMap<>();
            if (i3 == 1) {
                hashMap.put("ext3", "1");
            } else {
                hashMap.put("ext3", "2");
            }
            for (com.tencent.mobileqq.gamecenter.data.b bVar : list) {
                int i16 = bVar.f211987a;
                if (i16 == 1) {
                    hashMap.put("ext29", String.valueOf(bVar.f211988b));
                } else if (i16 == 2) {
                    hashMap.put("ext6", String.valueOf(bVar.f211988b));
                }
            }
            hashMap.put("ext4", "20");
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(this.V, "5", "971", "9045", "904501", "209740", "", hashMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oh(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            this.f213237a0.setVisibility(8);
            return;
        }
        int indexOf = str.indexOf("\u5378\u8f7d\u540e\u5b89\u88c5QQ\u5b98\u65b9\u5b89\u88c5\u5305");
        if (indexOf < 0) {
            QLog.i("GameCenterAuthFragment", 1, "fail to find special wording");
            this.f213237a0.setVisibility(8);
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) str);
        int i3 = indexOf + 12;
        spannableStringBuilder.setSpan(new d(), indexOf, i3, 33);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#2d77e5")), indexOf, i3, 33);
        this.f213238b0.setMovementMethod(LinkMovementMethod.getInstance());
        this.f213238b0.setText(spannableStringBuilder);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("ext2", "1");
        hashMap.put("ext4", "8");
        hashMap.put("ext10", ah.F());
        hashMap.put("ext15", String.valueOf(ah.K()));
        if (TextUtils.isEmpty(this.f213239c0)) {
            str2 = "-1";
        } else {
            str2 = this.f213239c0;
        }
        hashMap.put("ext29", str2);
        hashMap.put("adtag", "hulian_login");
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(this.V, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9388", "938801", "914135", "", hashMap);
    }

    private void Ph() {
        DialogUtil.createCustomDialog(getActivity(), 230, (String) null, getString(R.string.f1366104m), getString(R.string.cancel), getString(R.string.f171151ok), new a(), new b()).show();
        ((IOpenAuthGameCenterPageReporter) QRoute.api(IOpenAuthGameCenterPageReporter.class)).reportBackDialogShow();
    }

    private void Qh() {
        DialogUtil.createCustomDialog(getActivity(), 230, (String) null, getString(R.string.f1366704s), (String) null, getString(R.string.f171151ok), new c(), (DialogInterface.OnClickListener) null).show();
    }

    private void initData() {
        Intent intent = getActivity().getIntent();
        this.V = String.valueOf(intent.getLongExtra("appId", 0L));
        this.W = intent.getStringExtra("appName");
        com.tencent.mobileqq.gamecenter.logic.a aVar = new com.tencent.mobileqq.gamecenter.logic.a(getActivity(), this.V, this);
        this.T = aVar;
        aVar.r(this);
        String stringExtra = getActivity().getIntent().getStringExtra("pkg_name");
        this.X = stringExtra;
        this.T.t(stringExtra);
        this.f213239c0 = com.tencent.mobileqq.gamecenter.protocols.d.g(this.X);
    }

    private void initUI(View view) {
        this.C = view.findViewById(R.id.a47);
        this.D = view.findViewById(R.id.b7p);
        this.E = (RelativeLayout) view.findViewById(R.id.vil);
        this.F = (RelativeLayout) view.findViewById(R.id.vik);
        this.G = (RelativeLayout) view.findViewById(R.id.vim);
        this.H = (TextView) view.findViewById(R.id.vhu);
        this.I = (TextView) view.findViewById(R.id.vht);
        this.J = (TextView) view.findViewById(R.id.vhs);
        this.K = (TextView) view.findViewById(R.id.vhz);
        this.L = (TextView) view.findViewById(R.id.vhy);
        this.M = (TextView) view.findViewById(R.id.vhx);
        this.N = (TextView) view.findViewById(R.id.f165315vi2);
        this.P = view.findViewById(R.id.f165313vi0);
        this.Q = (TextView) view.findViewById(R.id.vhw);
        this.R = (ImageView) view.findViewById(R.id.f165316vi3);
        this.S = (TextView) view.findViewById(R.id.f165314vi1);
        this.f213237a0 = (LinearLayout) view.findViewById(R.id.ynk);
        this.f213238b0 = (TextView) view.findViewById(R.id.f108786e2);
        Lh();
        this.C.setOnClickListener(this);
        this.D.setOnClickListener(this);
        this.F.setOnClickListener(this);
        this.E.setOnClickListener(this);
        this.G.setOnClickListener(this);
        this.P.setOnClickListener(this);
        this.Q.setOnClickListener(this);
        this.R.setOnClickListener(this);
        Jh(view);
    }

    @Override // com.tencent.mobileqq.gamecenter.data.l
    public void g7(final GameDataAuthorizeSvr$LoginGuide gameDataAuthorizeSvr$LoginGuide) {
        QLog.i("GameCenterAuthFragment", 1, "[onCheckApkValidCallback]");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.ui.GameCenterAuthFragment.6
            @Override // java.lang.Runnable
            public void run() {
                String str;
                String str2;
                JSONObject jSONObject;
                try {
                    GameDataAuthorizeSvr$LoginGuide gameDataAuthorizeSvr$LoginGuide2 = gameDataAuthorizeSvr$LoginGuide;
                    if (gameDataAuthorizeSvr$LoginGuide2 == null) {
                        return;
                    }
                    boolean z16 = gameDataAuthorizeSvr$LoginGuide2.show_guide.get();
                    HashMap<String, String> hashMap = new HashMap<>();
                    if (z16) {
                        str = "1";
                    } else {
                        str = "2";
                    }
                    hashMap.put("ext2", str);
                    hashMap.put("ext4", "7");
                    hashMap.put("ext10", ah.F());
                    hashMap.put("ext15", String.valueOf(ah.K()));
                    if (!TextUtils.isEmpty(GameCenterAuthFragment.this.f213239c0)) {
                        str2 = GameCenterAuthFragment.this.f213239c0;
                    } else {
                        str2 = "-1";
                    }
                    hashMap.put("ext29", str2);
                    hashMap.put("adtag", "hulian_login");
                    ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(GameCenterAuthFragment.this.V, "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9388", "938801", "914134", "", hashMap);
                    QLog.i("GameCenterAuthFragment", 1, "isShow:" + z16);
                    if (!z16) {
                        return;
                    }
                    int i3 = gameDataAuthorizeSvr$LoginGuide.style.get();
                    QLog.i("GameCenterAuthFragment", 1, "style:" + i3);
                    if (i3 == 1) {
                        if (TextUtils.isEmpty(gameDataAuthorizeSvr$LoginGuide.title.get())) {
                            return;
                        }
                        GameCenterAuthFragment.this.f213237a0.setVisibility(0);
                        GameCenterAuthFragment.this.Oh(gameDataAuthorizeSvr$LoginGuide.title.get());
                    } else if (i3 == 2 || i3 == 3) {
                        if (((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).getConfigJsonObj(IGameCenterUnitedConfigApi.GAME_INSTALL_CHANNEL_CONFIG).optInt("hulianKuiklySwitch", 1) == 0) {
                            GameCenterAuthFragment.this.f213237a0.setVisibility(8);
                            GameCenterAuthFragment.this.Z = new z(GameCenterAuthFragment.this.getActivity());
                            GameCenterAuthFragment.this.Z.W(GameCenterAuthFragment.this.V);
                            GameCenterAuthFragment.this.Z.Z(GameCenterAuthFragment.this.X);
                            GameCenterAuthFragment.this.Z.X(GameCenterAuthFragment.this.f213239c0);
                            GameCenterAuthFragment.this.Z.Y(gameDataAuthorizeSvr$LoginGuide);
                            GameCenterAuthFragment.this.Z.show();
                        } else {
                            List<GameDataAuthorizeSvr$Reminder> list = gameDataAuthorizeSvr$LoginGuide.reminders.get();
                            if (list.size() > 0) {
                                GameDataAuthorizeSvr$Reminder gameDataAuthorizeSvr$Reminder = list.get(0);
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("icon", gameDataAuthorizeSvr$Reminder.icon.get());
                                jSONObject2.put("title", gameDataAuthorizeSvr$Reminder.title.get());
                                jSONObject2.put("sub_titile", gameDataAuthorizeSvr$Reminder.sub_titile.get());
                                jSONObject = jSONObject2;
                            } else {
                                jSONObject = null;
                            }
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("downloadUrl", gameDataAuthorizeSvr$LoginGuide.download_url.get());
                            jSONObject3.put("appName", gameDataAuthorizeSvr$LoginGuide.app_name.get());
                            jSONObject3.put(IProfileProtocolConst.KEY_COMPANY, gameDataAuthorizeSvr$LoginGuide.operator_commpany.get());
                            jSONObject3.put("versionName", gameDataAuthorizeSvr$LoginGuide.version_name.get());
                            jSONObject3.put("privacyUrl", gameDataAuthorizeSvr$LoginGuide.privacy_guide.get());
                            if (!GameCenterAuthFragment.this.Mh(i3, jSONObject, gameDataAuthorizeSvr$LoginGuide.ads_pic.get(), gameDataAuthorizeSvr$LoginGuide.title.get(), jSONObject3)) {
                                return;
                            }
                        }
                    }
                    long j3 = gameDataAuthorizeSvr$LoginGuide.listening_time.get();
                    QLog.i("GameCenterAuthFragment", 1, "valid_opt_ts:" + j3);
                    QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations").encodeLong("qq_login_valid_time_in_sec", j3);
                } catch (Throwable th5) {
                    QLog.e("GameCenterAuthFragment", 1, "[onCheckApkValidCallback], error:" + th5);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, @Nullable Intent intent) {
        if (104 == i3 && i16 == -1) {
            ((IOpenAuthPageOperation) QRoute.api(IOpenAuthPageOperation.class)).onClickAuthBtn(getQBaseActivity());
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.data.k
    public void onAuthRangeChanged(final List<com.tencent.mobileqq.gamecenter.data.b> list) {
        if (!this.U && list != null) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.ui.GameCenterAuthFragment.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        GameCenterAuthFragment.this.Y = list;
                        if (GameCenterAuthFragment.this.I != null && GameCenterAuthFragment.this.L != null && GameCenterAuthFragment.this.J != null && GameCenterAuthFragment.this.M != null) {
                            for (com.tencent.mobileqq.gamecenter.data.b bVar : list) {
                                if (bVar != null) {
                                    String rangeString = ((IGameCenterAuthApi) QRoute.api(IGameCenterAuthApi.class)).getRangeString(MobileQQ.sMobileQQ, bVar.f211988b);
                                    if (!TextUtils.isEmpty(rangeString)) {
                                        if (QLog.isColorLevel()) {
                                            QLog.d("GameCenterAuthFragment", 2, "[onAuthRangeChanged], title:" + bVar.f211989c + ", range:" + rangeString + ", text:" + bVar.f211990d);
                                        }
                                        int i3 = bVar.f211987a;
                                        if (i3 == 1) {
                                            GameCenterAuthFragment.this.I.setText(rangeString);
                                            if (!TextUtils.isEmpty(bVar.f211989c)) {
                                                GameCenterAuthFragment.this.H.setText(bVar.f211989c);
                                            }
                                            if (!TextUtils.isEmpty(bVar.f211990d)) {
                                                GameCenterAuthFragment.this.J.setText(bVar.f211990d);
                                            }
                                        } else if (i3 == 2) {
                                            GameCenterAuthFragment.this.L.setText(rangeString);
                                            if (!TextUtils.isEmpty(bVar.f211989c)) {
                                                GameCenterAuthFragment.this.K.setText(bVar.f211989c);
                                            }
                                            if (!TextUtils.isEmpty(bVar.f211990d)) {
                                                GameCenterAuthFragment.this.M.setText(bVar.f211990d);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Exception e16) {
                        QLog.e("GameCenterAuthFragment", 1, "[onAuthRangeChanged], e:" + e16.getMessage());
                    }
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.C) {
            ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(this.V, "5", "971", "9045", "904501", "209742", "", "", "20", "");
            ((IOpenAuthGameCenterPageReporter) QRoute.api(IOpenAuthGameCenterPageReporter.class)).reportBackClick();
            if (getQBaseActivity() != null) {
                getQBaseActivity().finish();
            }
            Kh();
        } else if (view == this.D) {
            if (dq3.f.f394643a.t() && getQBaseActivity() != null) {
                ((IOpenSdkApi) QRoute.api(IOpenSdkApi.class)).openRecommendFragment(getQBaseActivity());
            } else {
                ((IOpenAuthPageOperation) QRoute.api(IOpenAuthPageOperation.class)).onClickAuthBtn(getQBaseActivity());
            }
            ((IOpenAuthGameCenterPageReporter) QRoute.api(IOpenAuthGameCenterPageReporter.class)).recordGameAuthItemList(getActivity(), this.T.k());
            ((IOpenAuthGameCenterPageReporter) QRoute.api(IOpenAuthGameCenterPageReporter.class)).reportConfirmClick();
            Kh();
            Nh(1, this.Y);
        } else if (view == this.F) {
            this.T.c(1);
        } else if (view == this.G) {
            this.T.c(2);
        } else if (view == this.P) {
            Ph();
            ((IOpenAuthGameCenterPageReporter) QRoute.api(IOpenAuthGameCenterPageReporter.class)).reportRefuseClick();
            Kh();
        } else if (view == this.Q) {
            this.T.p();
        } else if (view == this.R) {
            Qh();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        initData();
        View inflate = layoutInflater.inflate(R.layout.eae, viewGroup, false);
        FontSettingManager.resetViewSize2Normal(getContext(), inflate);
        initUI(inflate);
        this.T.getAuthFromServer();
        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(this.V, "5", "971", "9045", "904501", "209739", "", "", "7", "");
        ((IOpenAuthGameCenterPageReporter) QRoute.api(IOpenAuthGameCenterPageReporter.class)).reportPageShow(getActivity());
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.U = true;
        this.T.onDestroy();
    }

    @Override // com.tencent.mobileqq.gamecenter.data.k
    public void onGetRangeUrl(final String str, final String str2) {
        if (this.U) {
            return;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.ui.GameCenterAuthFragment.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (TextUtils.isEmpty(str)) {
                        GameCenterAuthFragment.this.Q.setVisibility(8);
                    } else {
                        GameCenterAuthFragment.this.Q.setVisibility(0);
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        GameCenterAuthFragment.this.S.setText(str2);
                    }
                } catch (Throwable th5) {
                    QLog.e("GameCenterAuthFragment", 1, "e:" + th5.getMessage());
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.tencent.open.agent.util.g.Y(getQBaseActivity());
    }
}
