package com.tencent.mobileqq.facetoface;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.MoveToGroupActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.NearFieldTroopHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.app.bh;
import com.tencent.mobileqq.app.bs;
import com.tencent.mobileqq.app.bx;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.facetoface.Face2FaceDetailBaseView;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
import tencent.im.nearfield_group.nearfield_group$BusiRespHead;
import tencent.mobileim.structmsg.structmsg$StructMsg;
import tencent.mobileim.structmsg.structmsg$SystemMsgAction;
import tencent.mobileim.structmsg.structmsg$SystemMsgActionInfo;

/* compiled from: P */
/* loaded from: classes12.dex */
public class Face2FaceAddFriendActivity extends IphoneTitleBarActivity implements View.OnClickListener, View.OnTouchListener, INetInfoHandler {
    static IPatchRedirector $redirector_;
    public static String E1;
    public static String F1;
    public static String G1;
    public static int H1;
    public static int I1;
    public static int J1;
    public static long K1;
    public static int L1;
    private static Calendar M1;
    public boolean A0;
    private bx A1;
    public int B0;
    protected long B1;
    public int C0;
    protected QQProgressDialog C1;
    public INewFriendService D0;
    protected Face2FaceDetailBaseView.c D1;
    public Face2FaceTroopDetailView E0;
    public View F0;
    public XListView G0;
    public TextView H0;
    public com.tencent.mobileqq.facetoface.d I0;
    public String J0;
    public Face2FaceFriendDetailView K0;
    public EditText L0;
    public TextView M0;
    public LinearLayout N0;
    public LinearLayout O0;
    String P0;
    public int Q0;
    public HashMap<String, String> R0;
    public HashMap<String, Integer> S0;
    public HashMap<String, Integer> T0;
    com.tencent.mobileqq.facetoface.a U0;
    boolean V0;
    boolean W0;
    protected View X0;
    protected View Y0;
    protected TextView Z0;

    /* renamed from: a0, reason: collision with root package name */
    public int f205583a0;

    /* renamed from: a1, reason: collision with root package name */
    protected TextView f205584a1;

    /* renamed from: b0, reason: collision with root package name */
    public String f205585b0;

    /* renamed from: b1, reason: collision with root package name */
    public boolean f205586b1;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f205587c0;

    /* renamed from: c1, reason: collision with root package name */
    LBSHandler f205588c1;

    /* renamed from: d0, reason: collision with root package name */
    FrameLayout f205589d0;

    /* renamed from: d1, reason: collision with root package name */
    protected long f205590d1;

    /* renamed from: e0, reason: collision with root package name */
    private boolean f205591e0;

    /* renamed from: e1, reason: collision with root package name */
    protected TextView f205592e1;

    /* renamed from: f0, reason: collision with root package name */
    public SnowView f205593f0;

    /* renamed from: f1, reason: collision with root package name */
    protected View f205594f1;

    /* renamed from: g0, reason: collision with root package name */
    public Point f205595g0;

    /* renamed from: g1, reason: collision with root package name */
    protected TextView f205596g1;

    /* renamed from: h0, reason: collision with root package name */
    private v f205597h0;

    /* renamed from: h1, reason: collision with root package name */
    protected boolean f205598h1;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f205599i0;

    /* renamed from: i1, reason: collision with root package name */
    protected boolean f205600i1;

    /* renamed from: j0, reason: collision with root package name */
    int f205601j0;

    /* renamed from: j1, reason: collision with root package name */
    protected String f205602j1;

    /* renamed from: k0, reason: collision with root package name */
    int f205603k0;

    /* renamed from: k1, reason: collision with root package name */
    ImageView f205604k1;

    /* renamed from: l0, reason: collision with root package name */
    public List<com.tencent.mobileqq.facetoface.e> f205605l0;

    /* renamed from: l1, reason: collision with root package name */
    ImageView f205606l1;

    /* renamed from: m0, reason: collision with root package name */
    public List<com.tencent.mobileqq.facetoface.e> f205607m0;

    /* renamed from: m1, reason: collision with root package name */
    AlphaAnimation f205608m1;

    /* renamed from: n0, reason: collision with root package name */
    public List<com.tencent.mobileqq.facetoface.e> f205609n0;

    /* renamed from: n1, reason: collision with root package name */
    long f205610n1;

    /* renamed from: o0, reason: collision with root package name */
    public List<com.tencent.mobileqq.facetoface.e> f205611o0;

    /* renamed from: o1, reason: collision with root package name */
    long f205612o1;

    /* renamed from: p0, reason: collision with root package name */
    public CopyOnWriteArrayList<com.tencent.mobileqq.facetoface.e> f205613p0;

    /* renamed from: p1, reason: collision with root package name */
    boolean f205614p1;

    /* renamed from: q0, reason: collision with root package name */
    public boolean f205615q0;

    /* renamed from: q1, reason: collision with root package name */
    int f205616q1;

    /* renamed from: r0, reason: collision with root package name */
    public boolean f205617r0;

    /* renamed from: r1, reason: collision with root package name */
    int f205618r1;

    /* renamed from: s0, reason: collision with root package name */
    public int f205619s0;

    /* renamed from: s1, reason: collision with root package name */
    protected View f205620s1;

    /* renamed from: t0, reason: collision with root package name */
    public int f205621t0;

    /* renamed from: t1, reason: collision with root package name */
    int f205622t1;

    /* renamed from: u0, reason: collision with root package name */
    public boolean f205623u0;

    /* renamed from: u1, reason: collision with root package name */
    ArrayList<com.tencent.mobileqq.facetoface.f> f205624u1;

    /* renamed from: v0, reason: collision with root package name */
    long f205625v0;

    /* renamed from: v1, reason: collision with root package name */
    bh f205626v1;

    /* renamed from: w0, reason: collision with root package name */
    public List<String> f205627w0;

    /* renamed from: w1, reason: collision with root package name */
    bs f205628w1;

    /* renamed from: x0, reason: collision with root package name */
    public boolean f205629x0;

    /* renamed from: x1, reason: collision with root package name */
    com.tencent.mobileqq.friend.observer.a f205630x1;

    /* renamed from: y0, reason: collision with root package name */
    public boolean f205631y0;

    /* renamed from: y1, reason: collision with root package name */
    ar f205632y1;

    /* renamed from: z0, reason: collision with root package name */
    public boolean f205633z0;

    /* renamed from: z1, reason: collision with root package name */
    com.tencent.mobileqq.avatar.observer.a f205634z1;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a extends ar {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Face2FaceAddFriendActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onAddFriend(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            super.onAddFriend(str);
            if (QLog.isColorLevel()) {
                QLog.d(Face2FaceAddFriendActivity.E1, 2, "onAddFriend \u8fdb\u5165\u597d\u53cb\u5217\u8868" + str);
            }
            Message obtainMessage = Face2FaceAddFriendActivity.this.f205597h0.obtainMessage();
            obtainMessage.what = 2;
            obtainMessage.arg1 = 2;
            obtainMessage.obj = str;
            Face2FaceAddFriendActivity.this.f205597h0.sendMessage(obtainMessage);
            Face2FaceAddFriendActivity.this.b4(2, str);
            Face2FaceFriendBubbleView z36 = Face2FaceAddFriendActivity.this.z3(str, 1);
            if (z36 == null) {
                return;
            }
            com.tencent.mobileqq.facetoface.e g16 = z36.g();
            if (g16 != null && Face2FaceAddFriendActivity.this.R0.containsKey(str)) {
                String str2 = Face2FaceAddFriendActivity.this.R0.get(str);
                if (!TextUtils.isEmpty(str2) && g16.f205753a == 1) {
                    ((com.tencent.mobileqq.facetoface.g) g16).f205761d = str2;
                    z36.p(str2);
                }
            }
            if (Face2FaceAddFriendActivity.this.f205613p0.contains(g16)) {
                Face2FaceAddFriendActivity.this.U0.a(str);
                Message obtainMessage2 = Face2FaceAddFriendActivity.this.f205597h0.obtainMessage();
                obtainMessage2.what = 11;
                obtainMessage2.arg1 = 1;
                Face2FaceAddFriendActivity.this.f205597h0.sendMessageDelayed(obtainMessage2, Face2FaceAddFriendActivity.this.x3());
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.ar
        public void onUpdateDelFriend(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), obj);
                return;
            }
            super.onUpdateDelFriend(z16, obj);
            if (QLog.isColorLevel()) {
                QLog.d(Face2FaceAddFriendActivity.E1, 2, "onUpdateDelFriend \u5220\u9664\u597d\u53cb");
            }
            if (Face2FaceAddFriendActivity.this.f205627w0.contains(String.valueOf(obj))) {
                Face2FaceAddFriendActivity.this.f205627w0.remove(String.valueOf(obj));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class b extends com.tencent.mobileqq.avatar.observer.a {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Face2FaceAddFriendActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.avatar.observer.a
        public void onUpdateCustomHead(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 2;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(Face2FaceAddFriendActivity.E1, 2, "\u597d\u53cbonUpdateCustomHead success = " + z16);
            }
            Face2FaceAddFriendActivity face2FaceAddFriendActivity = Face2FaceAddFriendActivity.this;
            if (!face2FaceAddFriendActivity.f205598h1) {
                if (face2FaceAddFriendActivity.f205583a0 != 1) {
                    i3 = 1;
                }
                Face2FaceFriendBubbleView z36 = face2FaceAddFriendActivity.z3(str, i3);
                if (z36 != null) {
                    z36.m(Face2FaceAddFriendActivity.this.app, str, 1);
                }
            }
        }

        @Override // com.tencent.mobileqq.avatar.observer.a
        protected void onUpdateTroopHead(boolean z16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(Face2FaceAddFriendActivity.E1, 2, "\u7fa4onUpdateTroopHead success = " + z16);
            }
            Face2FaceFriendBubbleView z36 = Face2FaceAddFriendActivity.this.z3(str, 2);
            if (z36 != null) {
                z36.m(Face2FaceAddFriendActivity.this.app, str, 2);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class c extends bx {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                    return;
                }
                Face2FaceAddFriendActivity face2FaceAddFriendActivity = Face2FaceAddFriendActivity.this;
                face2FaceAddFriendActivity.f205587c0 = false;
                face2FaceAddFriendActivity.doOnBackPressed();
            }
        }

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class b implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                    return;
                }
                Face2FaceAddFriendActivity face2FaceAddFriendActivity = Face2FaceAddFriendActivity.this;
                face2FaceAddFriendActivity.f205587c0 = false;
                face2FaceAddFriendActivity.doOnBackPressed();
            }
        }

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Face2FaceAddFriendActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.bx
        public void a(nearfield_group$BusiRespHead nearfield_group_busiresphead) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) nearfield_group_busiresphead);
                return;
            }
            if (QLog.isColorLevel()) {
                String str = Face2FaceAddFriendActivity.F1;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onCloseFace2faceTroop, respHead isNull=");
                if (nearfield_group_busiresphead == null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                QLog.d(str, 2, sb5.toString());
            }
            if (nearfield_group_busiresphead == null) {
                return;
            }
            int i3 = nearfield_group_busiresphead.int32_reply_code.get();
            int i16 = nearfield_group_busiresphead.int32_seq.get();
            int i17 = nearfield_group_busiresphead.int32_version.get();
            String str2 = nearfield_group_busiresphead.str_result.get();
            if (QLog.isColorLevel()) {
                QLog.d(Face2FaceAddFriendActivity.E1, 2, "onCloseFace2faceTroop, ret=" + i3 + ",seqNo=" + i16 + ",ver=" + i17 + ",errInfo=" + str2 + ",from_type=" + Face2FaceAddFriendActivity.this.f205583a0 + ",fromTroopUin=" + Face2FaceAddFriendActivity.this.f205585b0);
            }
        }

        @Override // com.tencent.mobileqq.app.bx
        public void b(nearfield_group$BusiRespHead nearfield_group_busiresphead, String str) {
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) nearfield_group_busiresphead, (Object) str);
                return;
            }
            QQProgressDialog qQProgressDialog = Face2FaceAddFriendActivity.this.C1;
            if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
                Face2FaceAddFriendActivity.this.C1.dismiss();
                Face2FaceAddFriendActivity.this.C1 = null;
            }
            if (nearfield_group_busiresphead == null) {
                Face2FaceAddFriendActivity face2FaceAddFriendActivity = Face2FaceAddFriendActivity.this;
                face2FaceAddFriendActivity.E0.l(-1, "", str, face2FaceAddFriendActivity.isFinishing());
                if (QLog.isColorLevel()) {
                    QLog.d(Face2FaceAddFriendActivity.F1, 2, "onJoinTroop, respHead isNull=true, troopCode=" + str);
                    return;
                }
                return;
            }
            int i3 = nearfield_group_busiresphead.int32_reply_code.get();
            int i16 = nearfield_group_busiresphead.int32_seq.get();
            int i17 = nearfield_group_busiresphead.int32_version.get();
            String str3 = nearfield_group_busiresphead.str_result.get();
            if (QLog.isColorLevel()) {
                QLog.d(Face2FaceAddFriendActivity.F1, 2, "onJoinTroop, ret=" + i3 + ", seqNo=" + i16 + ",ver=" + i17 + ",errInfo=" + str3 + ",troopCode=" + str + ",from_type=" + Face2FaceAddFriendActivity.this.f205583a0 + ",fromTroopUin=" + Face2FaceAddFriendActivity.this.f205585b0);
            }
            Face2FaceAddFriendActivity face2FaceAddFriendActivity2 = Face2FaceAddFriendActivity.this;
            if (face2FaceAddFriendActivity2.f205583a0 == 0) {
                if (i3 == 0) {
                    for (Face2FaceFriendBubbleView face2FaceFriendBubbleView : face2FaceAddFriendActivity2.U0.f205716k) {
                        if (face2FaceFriendBubbleView != null && face2FaceFriendBubbleView.l() == 2 && str.equals(face2FaceFriendBubbleView.k())) {
                            face2FaceFriendBubbleView.setStatusWithAnimation(2);
                            com.tencent.mobileqq.facetoface.e g16 = face2FaceFriendBubbleView.g();
                            if (g16 instanceof com.tencent.mobileqq.facetoface.c) {
                                str2 = g16.f205754b + "_" + ((com.tencent.mobileqq.facetoface.c) g16).f205749d;
                            } else {
                                str2 = str;
                            }
                            Face2FaceAddFriendActivity.this.U0.a(str2);
                            Message obtainMessage = Face2FaceAddFriendActivity.this.f205597h0.obtainMessage();
                            obtainMessage.what = 11;
                            obtainMessage.arg1 = 2;
                            Face2FaceAddFriendActivity.this.f205597h0.sendMessageDelayed(obtainMessage, Face2FaceAddFriendActivity.this.x3());
                        }
                    }
                    ReportController.o(null, "P_CliOper", "Grp_set", "", "Radar_grp_guest", "suc_join", 0, 0, str, AppSetting.f99551k, "", Face2FaceAddFriendActivity.this.app.getCurrentAccountUin());
                }
                Face2FaceAddFriendActivity face2FaceAddFriendActivity3 = Face2FaceAddFriendActivity.this;
                face2FaceAddFriendActivity3.E0.l(i3, str3, str, face2FaceAddFriendActivity3.isFinishing());
            }
        }

        @Override // com.tencent.mobileqq.app.bx
        public void c(nearfield_group$BusiRespHead nearfield_group_busiresphead, List<com.tencent.mobileqq.facetoface.c> list) {
            int size;
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) nearfield_group_busiresphead, (Object) list);
                return;
            }
            boolean z17 = false;
            if (list == null) {
                size = 0;
            } else {
                size = list.size();
            }
            if (QLog.isColorLevel()) {
                String str = Face2FaceAddFriendActivity.F1;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onOpenFace2faceTroop, respHead isNull=");
                if (nearfield_group_busiresphead == null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                sb5.append(", troopList isNull=");
                if (list == null) {
                    z17 = true;
                }
                sb5.append(z17);
                sb5.append(", troopList.size=");
                sb5.append(size);
                QLog.d(str, 2, sb5.toString());
            }
            if (nearfield_group_busiresphead == null) {
                Face2FaceAddFriendActivity face2FaceAddFriendActivity = Face2FaceAddFriendActivity.this;
                face2FaceAddFriendActivity.f205621t0 = 2;
                face2FaceAddFriendActivity.L3();
                Face2FaceAddFriendActivity face2FaceAddFriendActivity2 = Face2FaceAddFriendActivity.this;
                if (face2FaceAddFriendActivity2.f205583a0 == 1) {
                    DialogUtil.createCustomDialog(face2FaceAddFriendActivity2, 230, face2FaceAddFriendActivity2.getString(R.string.f173206i10), HardCodeUtil.qqStr(R.string.mce), R.string.cancel, R.string.f170901b10, new a(), (DialogInterface.OnClickListener) null).show();
                    return;
                }
                return;
            }
            int i3 = nearfield_group_busiresphead.int32_reply_code.get();
            int i16 = nearfield_group_busiresphead.int32_seq.get();
            int i17 = nearfield_group_busiresphead.int32_version.get();
            String str2 = nearfield_group_busiresphead.str_result.get();
            if (QLog.isColorLevel()) {
                QLog.d(Face2FaceAddFriendActivity.F1, 2, "onOpenFace2faceTroop, ret=" + i3 + ",seqNo=" + i16 + ",ver=" + i17 + ",errInfo=" + str2 + ",from_type=" + Face2FaceAddFriendActivity.this.f205583a0 + ",fromTroopUin=" + Face2FaceAddFriendActivity.this.f205585b0);
            }
            if (i3 == 0) {
                Face2FaceAddFriendActivity face2FaceAddFriendActivity3 = Face2FaceAddFriendActivity.this;
                face2FaceAddFriendActivity3.f205621t0 = 1;
                if (face2FaceAddFriendActivity3.f205583a0 == 0) {
                    if (list != null && list.size() > 0) {
                        for (com.tencent.mobileqq.facetoface.c cVar : list) {
                            if (Face2FaceAddFriendActivity.this.f205607m0.contains(cVar)) {
                                break;
                            } else {
                                Face2FaceAddFriendActivity.this.f205607m0.add(cVar);
                            }
                        }
                    }
                    Face2FaceAddFriendActivity face2FaceAddFriendActivity4 = Face2FaceAddFriendActivity.this;
                    face2FaceAddFriendActivity4.f205617r0 = true;
                    face2FaceAddFriendActivity4.L3();
                    return;
                }
                return;
            }
            Face2FaceAddFriendActivity face2FaceAddFriendActivity5 = Face2FaceAddFriendActivity.this;
            face2FaceAddFriendActivity5.f205621t0 = 2;
            face2FaceAddFriendActivity5.L3();
            Face2FaceAddFriendActivity face2FaceAddFriendActivity6 = Face2FaceAddFriendActivity.this;
            if (face2FaceAddFriendActivity6.f205583a0 == 1) {
                DialogUtil.createCustomDialog(face2FaceAddFriendActivity6, 230, face2FaceAddFriendActivity6.getString(R.string.f173206i10), HardCodeUtil.qqStr(R.string.mc8), R.string.cancel, R.string.f170901b10, new b(), (DialogInterface.OnClickListener) null).show();
            }
        }

        @Override // com.tencent.mobileqq.app.bx
        public void d(com.tencent.mobileqq.facetoface.f fVar) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) fVar);
                return;
            }
            if (QLog.isColorLevel()) {
                String str = Face2FaceAddFriendActivity.F1;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onRecvMemberPush, from_type=");
                sb5.append(Face2FaceAddFriendActivity.this.f205583a0);
                sb5.append(",fromTroopUin=");
                sb5.append(Face2FaceAddFriendActivity.this.f205585b0);
                sb5.append(",userProfile isNull=");
                if (fVar == null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                sb5.append("total:");
                sb5.append(Face2FaceAddFriendActivity.this.f205605l0.size() + 1);
                QLog.d(str, 2, sb5.toString());
            }
            if (fVar == null) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            Face2FaceAddFriendActivity face2FaceAddFriendActivity = Face2FaceAddFriendActivity.this;
            long j3 = face2FaceAddFriendActivity.B1;
            long j16 = currentTimeMillis - j3;
            if (j3 != 0 && j16 < 1000 && fVar.f205759g == 0) {
                Message obtain = Message.obtain();
                obtain.what = 16;
                obtain.obj = fVar;
                long j17 = 1000 - j16;
                Face2FaceAddFriendActivity.this.f205597h0.sendMessageDelayed(obtain, j17);
                fVar.f205759g = currentTimeMillis;
                Face2FaceAddFriendActivity.this.B1 = currentTimeMillis + j17;
                if (QLog.isColorLevel()) {
                    QLog.d(Face2FaceAddFriendActivity.F1, 2, "onRecvMemberPush, delay=" + j16 + ", delayed=" + j17 + ",mLastToopMemberPushStamp=" + Face2FaceAddFriendActivity.this.B1);
                    return;
                }
                return;
            }
            if (fVar.f205759g == 0) {
                face2FaceAddFriendActivity.B1 = currentTimeMillis;
            }
            if (face2FaceAddFriendActivity.f205583a0 == 1 && !face2FaceAddFriendActivity.f205605l0.contains(fVar)) {
                Face2FaceAddFriendActivity.this.f205605l0.add(fVar);
                Face2FaceAddFriendActivity face2FaceAddFriendActivity2 = Face2FaceAddFriendActivity.this;
                if (!face2FaceAddFriendActivity2.f205598h1 || face2FaceAddFriendActivity2.I0 == null) {
                    face2FaceAddFriendActivity2.X3(fVar);
                    Face2FaceAddFriendActivity.this.a4();
                } else {
                    face2FaceAddFriendActivity2.H0.setText(String.valueOf(face2FaceAddFriendActivity2.f205605l0.size()));
                    Face2FaceAddFriendActivity.this.I0.h(fVar);
                }
            }
        }

        @Override // com.tencent.mobileqq.app.bx
        public void e(com.tencent.mobileqq.facetoface.c cVar) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) cVar);
                return;
            }
            if (QLog.isColorLevel()) {
                String str = Face2FaceAddFriendActivity.F1;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onRecvTroopPush, from_type=");
                sb5.append(Face2FaceAddFriendActivity.this.f205583a0);
                sb5.append(",groupProfile isNull=");
                if (cVar == null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                sb5.append(",show_type=");
                QLog.d(str, 2, sb5.toString());
            }
            Face2FaceAddFriendActivity face2FaceAddFriendActivity = Face2FaceAddFriendActivity.this;
            if (face2FaceAddFriendActivity.f205583a0 == 0 && cVar != null && !face2FaceAddFriendActivity.f205607m0.contains(cVar)) {
                Face2FaceAddFriendActivity.this.f205607m0.add(cVar);
                if (Face2FaceAddFriendActivity.this.f205613p0.size() == Face2FaceAddFriendActivity.this.f205611o0.size()) {
                    Face2FaceAddFriendActivity.this.X3(cVar);
                } else {
                    Message obtainMessage = Face2FaceAddFriendActivity.this.f205597h0.obtainMessage();
                    obtainMessage.what = 10;
                    obtainMessage.obj = cVar;
                    Face2FaceAddFriendActivity.this.f205597h0.sendEmptyMessageDelayed(10, 5000L);
                }
                Face2FaceAddFriendActivity.this.C0++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class d implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Face2FaceAddFriendActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            Face2FaceAddFriendActivity face2FaceAddFriendActivity = Face2FaceAddFriendActivity.this;
            face2FaceAddFriendActivity.f205587c0 = false;
            face2FaceAddFriendActivity.doOnBackPressed();
            ReportController.o(null, "P_CliOper", "Grp_set", "", "Radar_grp_admin", "Clk_quit", 0, 0, Face2FaceAddFriendActivity.this.f205585b0, "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class e implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Face2FaceAddFriendActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class f implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.facetoface.e f205646d;

        f(com.tencent.mobileqq.facetoface.e eVar) {
            this.f205646d = eVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Face2FaceAddFriendActivity.this, (Object) eVar);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                Face2FaceAddFriendActivity face2FaceAddFriendActivity = Face2FaceAddFriendActivity.this;
                ProfileCardUtil.D0(face2FaceAddFriendActivity, face2FaceAddFriendActivity.K0.g(), this.f205646d.f205754b, 1);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class g implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Face2FaceAddFriendActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                Intent putExtra = new Intent(Face2FaceAddFriendActivity.this, (Class<?>) MoveToGroupActivity.class).putExtra("friendUin", Face2FaceAddFriendActivity.this.P0).putExtra("mgid", (byte) Face2FaceAddFriendActivity.this.Q0);
                putExtra.putExtra("PARAM_EXECUTE_IMMEDIATELY", false);
                Face2FaceAddFriendActivity.this.startActivityForResult(putExtra, 100);
                ReportController.o(null, "CliOper", "", "", "0X80050F1", "0X80050F1", 0, 0, "", "", "", "");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class h implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f205649d;

        h(String str) {
            this.f205649d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Face2FaceAddFriendActivity.this, (Object) str);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (NetworkUtil.isNetSupport(Face2FaceAddFriendActivity.this)) {
                long currentTimeMillis = System.currentTimeMillis();
                Face2FaceAddFriendActivity face2FaceAddFriendActivity = Face2FaceAddFriendActivity.this;
                long j3 = face2FaceAddFriendActivity.f205625v0;
                if (currentTimeMillis - j3 < Face2FaceAddFriendActivity.K1 && currentTimeMillis > j3) {
                    if (QLog.isColorLevel()) {
                        QLog.e(Face2FaceAddFriendActivity.E1, 2, "click too offen,please try again later ");
                    }
                } else {
                    face2FaceAddFriendActivity.f205625v0 = currentTimeMillis;
                    face2FaceAddFriendActivity.b3(this.f205649d);
                    Face2FaceAddFriendActivity.this.K0.l();
                    ReportController.o(null, "CliOper", "", "", "0X80050EF", "0X80050EF", 1, 0, "", "", "", "");
                }
            } else {
                QQToast.makeText(Face2FaceAddFriendActivity.this, 0, Face2FaceAddFriendActivity.this.getResources().getString(R.string.b2u), 0).show(Face2FaceAddFriendActivity.this.getTitleBarHeight());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class i implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f205651d;

        i(String str) {
            this.f205651d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Face2FaceAddFriendActivity.this, (Object) str);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (NetworkUtil.isNetSupport(Face2FaceAddFriendActivity.this)) {
                long currentTimeMillis = System.currentTimeMillis();
                Face2FaceAddFriendActivity face2FaceAddFriendActivity = Face2FaceAddFriendActivity.this;
                long j3 = face2FaceAddFriendActivity.f205625v0;
                if (currentTimeMillis - j3 < Face2FaceAddFriendActivity.K1 && currentTimeMillis > j3) {
                    if (QLog.isColorLevel()) {
                        QLog.e(Face2FaceAddFriendActivity.E1, 2, "click too offen,please try again later ");
                    }
                } else {
                    face2FaceAddFriendActivity.f205625v0 = currentTimeMillis;
                    face2FaceAddFriendActivity.g3(this.f205651d);
                    Face2FaceAddFriendActivity.this.K0.l();
                    Message obtainMessage = Face2FaceAddFriendActivity.this.f205597h0.obtainMessage();
                    obtainMessage.what = 2;
                    obtainMessage.arg1 = 2;
                    obtainMessage.obj = this.f205651d;
                    Face2FaceAddFriendActivity.this.f205597h0.sendMessage(obtainMessage);
                    ReportController.o(null, "CliOper", "", "", "0X80050EF", "0X80050EF", 2, 0, "", "", "", "");
                }
            } else {
                QQToast.makeText(Face2FaceAddFriendActivity.this, 0, Face2FaceAddFriendActivity.this.getResources().getString(R.string.b2u), 0).show(Face2FaceAddFriendActivity.this.getTitleBarHeight());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class j implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f205653d;

        j(String str) {
            this.f205653d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Face2FaceAddFriendActivity.this, (Object) str);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                Face2FaceAddFriendActivity face2FaceAddFriendActivity = Face2FaceAddFriendActivity.this;
                ProfileCardUtil.D0(face2FaceAddFriendActivity, face2FaceAddFriendActivity.K0.g(), this.f205653d, 0);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class k implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f205655d;

        k(String str) {
            this.f205655d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Face2FaceAddFriendActivity.this, (Object) str);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (NetworkUtil.isNetSupport(Face2FaceAddFriendActivity.this)) {
                Face2FaceAddFriendActivity.this.g3(this.f205655d);
                Face2FaceAddFriendActivity.this.K0.l();
                Message obtainMessage = Face2FaceAddFriendActivity.this.f205597h0.obtainMessage();
                obtainMessage.what = 2;
                obtainMessage.arg1 = 2;
                obtainMessage.obj = this.f205655d;
                Face2FaceAddFriendActivity.this.f205597h0.sendMessage(obtainMessage);
                ReportController.o(null, "CliOper", "", "", "0X80050EF", "0X80050EF", 2, 0, "", "", "", "");
            } else {
                QQToast.makeText(Face2FaceAddFriendActivity.this, 0, Face2FaceAddFriendActivity.this.getResources().getString(R.string.b2u), 0).show(Face2FaceAddFriendActivity.this.getTitleBarHeight());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class l implements Face2FaceDetailBaseView.c {
        static IPatchRedirector $redirector_;

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Face2FaceAddFriendActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.facetoface.Face2FaceDetailBaseView.c
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.facetoface.Face2FaceDetailBaseView.c
        public boolean b(com.tencent.mobileqq.facetoface.c cVar, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar, i3)).booleanValue();
            }
            if (!NetworkUtil.isNetSupport(Face2FaceAddFriendActivity.this)) {
                if (QLog.isColorLevel()) {
                    QLog.d(Face2FaceAddFriendActivity.F1, 2, "joinTroop, NetworkUtil.isNetSupport==false");
                }
                QQToast.makeText(Face2FaceAddFriendActivity.this.app.getApplication(), R.string.f171139ci4, 0).show(Face2FaceAddFriendActivity.this.getTitleBarHeight());
                return false;
            }
            NearFieldTroopHandler nearFieldTroopHandler = (NearFieldTroopHandler) Face2FaceAddFriendActivity.this.app.getBusinessHandler(BusinessHandlerFactory.NEARFIELD_TROOP_HANDLER);
            if (nearFieldTroopHandler != null) {
                Face2FaceAddFriendActivity.this.C1 = new QQProgressDialog(Face2FaceAddFriendActivity.this);
                Face2FaceAddFriendActivity.this.C1.setMessage(HardCodeUtil.qqStr(R.string.mcb));
                Face2FaceAddFriendActivity.this.C1.setCancelable(false);
                Face2FaceAddFriendActivity.this.C1.show();
                try {
                    long longValue = Long.valueOf(cVar.f205754b).longValue();
                    long longValue2 = Long.valueOf(cVar.f205749d).longValue();
                    if (QLog.isColorLevel()) {
                        QLog.d(Face2FaceAddFriendActivity.F1, 2, "joinTroop, troopCode=" + longValue + ", ownerUin=" + longValue2 + ", distance=" + cVar.f205751f);
                    }
                    nearFieldTroopHandler.H2(longValue, longValue2, cVar.f205751f, i3);
                    return true;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d(Face2FaceAddFriendActivity.F1, 2, "joinTroop:" + e16.toString());
                    }
                }
            }
            return false;
        }

        @Override // com.tencent.mobileqq.facetoface.Face2FaceDetailBaseView.c
        public void c(com.tencent.mobileqq.facetoface.c cVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) cVar);
            } else if (Face2FaceAddFriendActivity.this.f205613p0.size() == Face2FaceAddFriendActivity.this.f205611o0.size()) {
                Face2FaceAddFriendActivity.this.n3(cVar);
            } else {
                Face2FaceAddFriendActivity.this.f205597h0.obtainMessage().obj = cVar;
                Face2FaceAddFriendActivity.this.f205597h0.sendEmptyMessageDelayed(12, 5000L);
            }
        }

        @Override // com.tencent.mobileqq.facetoface.Face2FaceDetailBaseView.c
        public void d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            } else {
                Face2FaceAddFriendActivity.this.m4();
            }
        }

        @Override // com.tencent.mobileqq.facetoface.Face2FaceDetailBaseView.c
        public void e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this);
                return;
            }
            Face2FaceAddFriendActivity.this.l4();
            if (QLog.isColorLevel()) {
                QLog.d(Face2FaceAddFriendActivity.E1, 2, "afterDetailViewHide \u8be6\u60c5\u9875\u8fd4\u56de");
            }
            Face2FaceAddFriendActivity face2FaceAddFriendActivity = Face2FaceAddFriendActivity.this;
            face2FaceAddFriendActivity.f205602j1 = "";
            face2FaceAddFriendActivity.f205597h0.sendEmptyMessageDelayed(13, Face2FaceAddFriendActivity.this.x3());
        }

        @Override // com.tencent.mobileqq.facetoface.Face2FaceDetailBaseView.c
        public void f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
                return;
            }
            Face2FaceAddFriendActivity face2FaceAddFriendActivity = Face2FaceAddFriendActivity.this;
            if (face2FaceAddFriendActivity.f205583a0 == 1) {
                face2FaceAddFriendActivity.V3(face2FaceAddFriendActivity.E0.L);
            }
        }

        @Override // com.tencent.mobileqq.facetoface.Face2FaceDetailBaseView.c
        public QQAppInterface getApp() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (QQAppInterface) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return Face2FaceAddFriendActivity.this.app;
        }

        @Override // com.tencent.mobileqq.facetoface.Face2FaceDetailBaseView.c
        public boolean isTroopMember(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str)).booleanValue();
            }
            return Face2FaceAddFriendActivity.this.isTroopMember(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class m implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Face2FaceAddFriendActivity.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
            } else {
                Face2FaceAddFriendActivity.this.f205604k1.setVisibility(4);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class n implements TextWatcher {
        static IPatchRedirector $redirector_;

        n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Face2FaceAddFriendActivity.this);
            }
        }

        private int a(String str) {
            byte[] bArr = new byte[0];
            try {
                bArr = str.getBytes("utf-8");
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
            }
            if (bArr.length % 3 == 0) {
                return bArr.length / 3;
            }
            return (bArr.length / 3) + 1;
        }

        private String b(String str) {
            while (a(str) > 32) {
                int length = str.length();
                if (length >= 2) {
                    int i3 = length - 2;
                    if (Character.isHighSurrogate(str.charAt(i3))) {
                        str = str.substring(0, i3);
                    }
                }
                str = str.substring(0, length - 1);
            }
            return str;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) editable);
                return;
            }
            String obj = Face2FaceAddFriendActivity.this.L0.getText().toString();
            if (a(obj) > 32) {
                int selectionStart = Face2FaceAddFriendActivity.this.L0.getSelectionStart();
                String b16 = b(obj);
                Face2FaceAddFriendActivity.this.L0.setText(b16);
                if (selectionStart >= b16.length()) {
                    Face2FaceAddFriendActivity.this.L0.setSelection(b16.length());
                }
            }
            if (Face2FaceAddFriendActivity.this.A0) {
                ReportController.o(null, "CliOper", "", "", "0X80050F0", "0X80050F0", 0, 0, "", "", "", "");
                Face2FaceAddFriendActivity.this.A0 = false;
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class o implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Face2FaceAddFriendActivity.this);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
                return;
            }
            Face2FaceAddFriendActivity face2FaceAddFriendActivity = Face2FaceAddFriendActivity.this;
            face2FaceAddFriendActivity.f205598h1 = false;
            face2FaceAddFriendActivity.F0.setVisibility(8);
            Face2FaceAddFriendActivity.this.a4();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class p implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f205661d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f205662e;

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a implements Animation.AnimationListener {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) p.this);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
                    return;
                }
                p pVar = p.this;
                Face2FaceAddFriendActivity.this.f205589d0.removeView(pVar.f205662e);
                Face2FaceAddFriendActivity.this.getWindow().setBackgroundDrawable(null);
                Face2FaceAddFriendActivity.this.G3();
                Face2FaceAddFriendActivity face2FaceAddFriendActivity = Face2FaceAddFriendActivity.this;
                face2FaceAddFriendActivity.f205614p1 = true;
                if (com.tencent.mobileqq.facetoface.b.f205745a >= com.tencent.mobileqq.facetoface.b.f205746b) {
                    face2FaceAddFriendActivity.k4(com.tencent.mobileqq.facetoface.b.f205745a, com.tencent.mobileqq.facetoface.b.f205746b);
                } else {
                    face2FaceAddFriendActivity.k4(com.tencent.mobileqq.facetoface.b.f205745a, 0L);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                }
            }
        }

        p(String str, View view) {
            this.f205661d = str;
            this.f205662e = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Face2FaceAddFriendActivity.this, str, view);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                Face2FaceAddFriendActivity.this.app.getPreferences().edit().putBoolean(this.f205661d, true).commit();
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(500L);
                alphaAnimation.setAnimationListener(new a());
                this.f205662e.startAnimation(alphaAnimation);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class q implements Animation.AnimationListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f205665d;

        q(View view) {
            this.f205665d = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Face2FaceAddFriendActivity.this, (Object) view);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
                return;
            }
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.2f, 0.0f);
            alphaAnimation.setDuration(500L);
            alphaAnimation.setFillAfter(true);
            this.f205665d.startAnimation(alphaAnimation);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class r implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        r() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Face2FaceAddFriendActivity.this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            Face2FaceAddFriendActivity face2FaceAddFriendActivity = Face2FaceAddFriendActivity.this;
            face2FaceAddFriendActivity.f205587c0 = false;
            face2FaceAddFriendActivity.f205598h1 = false;
            face2FaceAddFriendActivity.doOnBackPressed();
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class s extends bh {
        static IPatchRedirector $redirector_;

        s() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Face2FaceAddFriendActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.bh
        public void onGetFaceToFaceNearbyUserList(boolean z16, List<com.tencent.mobileqq.facetoface.g> list, int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), list, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            super.onGetFaceToFaceNearbyUserList(z16, list, i3, i16);
            if (z16) {
                Face2FaceAddFriendActivity.this.f205619s0 = 1;
            } else {
                Face2FaceAddFriendActivity.this.f205619s0 = 2;
            }
            if (QLog.isColorLevel()) {
                QLog.d(Face2FaceAddFriendActivity.E1, 2, "onGetFaceToFaceNearbyUserList heartBeatTime=" + i16 + "from_type=" + Face2FaceAddFriendActivity.this.f205583a0 + "reqInterval=" + i3 + "\u597d\u53cb\u5217\u8868\u8fd4\u56deisSuccess=" + z16);
            }
            if (list != null) {
                if (QLog.isColorLevel()) {
                    QLog.d(Face2FaceAddFriendActivity.E1, 2, "onGetFaceToFaceNearbyUserList size=" + list.size());
                }
            } else if (QLog.isColorLevel()) {
                QLog.d(Face2FaceAddFriendActivity.E1, 2, "onGetFaceToFaceNearbyUserList is null");
            }
            if (i3 < 0) {
                i3 = 2;
            }
            long currentTimeMillis = System.currentTimeMillis() - com.tencent.mobileqq.facetoface.b.f205747c;
            if (QLog.isColorLevel()) {
                QLog.d(Face2FaceAddFriendActivity.E1, 2, "onGetFaceToFaceNearbyUserList interval=" + currentTimeMillis + "leaveFaceTofaceTime=" + com.tencent.mobileqq.facetoface.b.f205747c);
            }
            long j3 = i3 * 1000;
            if (currentTimeMillis <= j3 && com.tencent.mobileqq.facetoface.b.f205747c != 0) {
                Face2FaceAddFriendActivity.this.e4(j3 - currentTimeMillis);
                return;
            }
            if (i16 > 0) {
                Face2FaceAddFriendActivity.J1 = i16 * 1000;
            }
            Face2FaceAddFriendActivity face2FaceAddFriendActivity = Face2FaceAddFriendActivity.this;
            if (!face2FaceAddFriendActivity.f205615q0) {
                face2FaceAddFriendActivity.f4();
            }
            Face2FaceAddFriendActivity face2FaceAddFriendActivity2 = Face2FaceAddFriendActivity.this;
            face2FaceAddFriendActivity2.f205615q0 = true;
            if (face2FaceAddFriendActivity2.f205583a0 == 0 && list != null && list.size() > 0) {
                for (com.tencent.mobileqq.facetoface.g gVar : list) {
                    if (Face2FaceAddFriendActivity.this.f205605l0.contains(gVar)) {
                        break;
                    } else {
                        Face2FaceAddFriendActivity.this.f205605l0.add(gVar);
                    }
                }
            }
            Face2FaceAddFriendActivity.this.L3();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.bh
        public void onGetFaceToFaceNearbyUserPush(com.tencent.mobileqq.facetoface.g gVar, boolean z16, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, gVar, Boolean.valueOf(z16), Integer.valueOf(i3));
                return;
            }
            super.onGetFaceToFaceNearbyUserPush(gVar, z16, i3);
            if (QLog.isColorLevel()) {
                QLog.d(Face2FaceAddFriendActivity.E1, 2, "onGetFaceToFaceNearbyUserPush, pushTime=" + i3 + "from_type=" + Face2FaceAddFriendActivity.this.f205583a0);
            }
            if (gVar == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(Face2FaceAddFriendActivity.E1, 2, "onGetFaceToFaceNearbyUserPush, nearbyUser=null!!");
                }
            } else if (QLog.isColorLevel()) {
                QLog.d(Face2FaceAddFriendActivity.E1, 2, "onGetFaceToFaceNearbyUserPush, nearbyUser=" + gVar.f205754b);
            }
            Face2FaceAddFriendActivity face2FaceAddFriendActivity = Face2FaceAddFriendActivity.this;
            if (face2FaceAddFriendActivity.f205583a0 == 0 && gVar != null && !face2FaceAddFriendActivity.E3(gVar, face2FaceAddFriendActivity.f205605l0)) {
                Face2FaceAddFriendActivity.this.f205605l0.add(gVar);
                if (QLog.isColorLevel()) {
                    QLog.d(Face2FaceAddFriendActivity.E1, 2, "onGetFaceToFaceNearbyUserPush, mhasShowList=" + Face2FaceAddFriendActivity.this.f205613p0.size() + "mNeedShowList.size()" + Face2FaceAddFriendActivity.this.f205611o0.size());
                }
                if (Face2FaceAddFriendActivity.this.f205613p0.size() == Face2FaceAddFriendActivity.this.f205611o0.size()) {
                    Face2FaceAddFriendActivity.this.X3(gVar);
                } else {
                    Message obtainMessage = Face2FaceAddFriendActivity.this.f205597h0.obtainMessage();
                    obtainMessage.what = 10;
                    obtainMessage.obj = gVar;
                    Face2FaceAddFriendActivity.this.f205597h0.sendEmptyMessageDelayed(10, Face2FaceAddFriendActivity.this.x3());
                }
                Face2FaceAddFriendActivity.this.B0++;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class t extends bs {
        static IPatchRedirector $redirector_;

        t() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Face2FaceAddFriendActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.bs
        public void onGetSystemMsgFin(boolean z16, boolean z17, List<MessageRecord> list) {
            boolean z18;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Boolean.valueOf(z17), list);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i(Face2FaceAddFriendActivity.E1, 2, "onGetSystemMsgFin.bengin");
            }
            if (z16) {
                if (QLog.isColorLevel()) {
                    QLog.i(Face2FaceAddFriendActivity.E1, 2, "onGetSystemMsgFin.success");
                }
                try {
                    new ArrayList();
                    List<MessageRecord> Q = Face2FaceAddFriendActivity.this.app.getMessageFacade().Q(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0);
                    if (QLog.isColorLevel()) {
                        QLog.d(Face2FaceAddFriendActivity.E1, 2, "onGetSystemMsgFin mDataList size=" + Q.size());
                    }
                    for (int size = Q.size() - 1; size >= 0; size--) {
                        MessageForSystemMsg messageForSystemMsg = (MessageForSystemMsg) Q.get(size);
                        if (messageForSystemMsg == null) {
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d(Face2FaceAddFriendActivity.E1, 2, "msg_type=" + messageForSystemMsg.structMsg.msg_type.get() + "source id" + messageForSystemMsg.structMsg.f436065msg.src_id.get() + "senderuin" + messageForSystemMsg.senderuin);
                            String str = Face2FaceAddFriendActivity.E1;
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("onGetSystemMsgFin");
                            sb5.append(messageForSystemMsg.senderuin);
                            sb5.append("\u8bf7\u6c42\u52a0\u597d\u53cb");
                            QLog.d(str, 2, sb5.toString());
                        }
                        if (messageForSystemMsg.structMsg.f436065msg.src_id.get() != 3021 && messageForSystemMsg.structMsg.f436065msg.src_id.get() != 2021) {
                            if (QLog.isColorLevel()) {
                                QLog.d(Face2FaceAddFriendActivity.E1, 2, "\u6b64\u8bf7\u6c42\u52a0\u597d\u53cb\u6765\u6e90\u4e0d\u662f\u9762\u5bf9\u9762\u4e0d\u4e88\u5904\u7406");
                                return;
                            }
                            return;
                        }
                        if (messageForSystemMsg.structMsg.msg_type.get() == 1) {
                            if (Face2FaceAddFriendActivity.this.z3(messageForSystemMsg.senderuin, 1) == null) {
                                Face2FaceAddFriendActivity.this.T0.put(messageForSystemMsg.senderuin, 3);
                                if (QLog.isColorLevel()) {
                                    QLog.d(Face2FaceAddFriendActivity.E1, 2, "onGetSystemMsgFin getViewFromUin=null");
                                    return;
                                }
                                return;
                            }
                            Iterator<String> it = Face2FaceAddFriendActivity.this.f205627w0.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (messageForSystemMsg.senderuin.equals(it.next())) {
                                        z18 = true;
                                        break;
                                    }
                                } else {
                                    z18 = false;
                                    break;
                                }
                            }
                            if (z18 && Face2FaceAddFriendActivity.this.J3(messageForSystemMsg.senderuin)) {
                                if (QLog.isColorLevel()) {
                                    QLog.d(Face2FaceAddFriendActivity.E1, 2, "onGetSystemMsgFin isAddFriend=true" + z18);
                                    return;
                                }
                                return;
                            }
                            int i3 = messageForSystemMsg.structMsg.f436065msg.sub_type.get();
                            if (QLog.isColorLevel()) {
                                QLog.d(Face2FaceAddFriendActivity.E1, 2, "onGetSystemMsgFin subType=" + i3);
                            }
                            if (i3 != 1) {
                                if (i3 != 6) {
                                    if (i3 != 9 && i3 != 10) {
                                    }
                                } else {
                                    return;
                                }
                            }
                            Message obtainMessage = Face2FaceAddFriendActivity.this.f205597h0.obtainMessage();
                            obtainMessage.what = 2;
                            obtainMessage.arg1 = 3;
                            obtainMessage.obj = messageForSystemMsg.senderuin;
                            Face2FaceAddFriendActivity.this.f205597h0.sendMessage(obtainMessage);
                            Face2FaceAddFriendActivity.this.b4(3, messageForSystemMsg.senderuin);
                            return;
                        }
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            } else if (z17) {
                QQToast.makeText(Face2FaceAddFriendActivity.this, 1, Face2FaceAddFriendActivity.this.getResources().getString(R.string.huq), 0).show(Face2FaceAddFriendActivity.this.getTitleBarHeight());
            }
            super.onGetSystemMsgFin(z16, z17, list);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.bs
        public void onSendResult(boolean z16, String str, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), str, Long.valueOf(j3));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i(Face2FaceAddFriendActivity.E1, 2, "onSendSystemMsgActionError.benginisSuccess=" + z16 + "uin" + str);
            }
            super.onSendResult(z16, str, j3);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.bs
        public void onSendSystemMsgActionError(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i(Face2FaceAddFriendActivity.E1, 2, "onSendSystemMsgActionError.bengin \u540c\u610f\u6dfb\u52a0\u597d\u53cb\u5931\u8d25" + str);
            }
            long currStructMsgKey = ((INewFriendApi) QRoute.api(INewFriendApi.class)).getCurrStructMsgKey();
            if (!TextUtils.isEmpty(str)) {
                try {
                    currStructMsgKey = Long.parseLong(str);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
            structmsg$StructMsg structMsgFromMap = ((INewFriendApi) QRoute.api(INewFriendApi.class)).getStructMsgFromMap(Long.valueOf(currStructMsgKey));
            if (structMsgFromMap != null) {
                String valueOf = String.valueOf(structMsgFromMap.req_uin.get());
                Message obtainMessage = Face2FaceAddFriendActivity.this.f205597h0.obtainMessage();
                obtainMessage.what = 2;
                obtainMessage.arg1 = 3;
                obtainMessage.obj = valueOf;
                Face2FaceAddFriendActivity.this.f205597h0.sendMessage(obtainMessage);
                Face2FaceAddFriendActivity.this.b4(3, valueOf);
                Face2FaceAddFriendActivity.this.U0.g(valueOf);
            } else if (QLog.isColorLevel()) {
                QLog.i(Face2FaceAddFriendActivity.E1, 2, "onSendSystemMsgActionError structMsg = null");
            }
            QQToast.makeText(Face2FaceAddFriendActivity.this, 0, Face2FaceAddFriendActivity.this.getResources().getString(R.string.b2s), 0).show(Face2FaceAddFriendActivity.this.getTitleBarHeight());
            super.onSendSystemMsgActionError(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.bs
        public void onSendSystemMsgActionFin(boolean z16, String str, int i3, String str2, int i16, int i17, String str3, String str4, int i18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), str2, Integer.valueOf(i16), Integer.valueOf(i17), str3, str4, Integer.valueOf(i18));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i(Face2FaceAddFriendActivity.E1, 2, "onSendSystemMsgActionFin \u540c\u610f\u52a0\u5bf9\u65b9\u597d\u53cb\u56de\u8c03 issuc" + z16 + "logStr=" + str + ";actionType=" + i3 + ";msgDetail=" + str2 + ";resultCode=" + i16 + ";respType=" + i17 + ";msgFail=" + str3 + ";msgInvalidDecided=" + str4 + ";remarkRet=" + i18);
            }
            long currStructMsgKey = ((INewFriendApi) QRoute.api(INewFriendApi.class)).getCurrStructMsgKey();
            if (!z16 && i16 == 32) {
                QQToast.makeText(Face2FaceAddFriendActivity.this, 0, str3, 0).show(Face2FaceAddFriendActivity.this.getTitleBarHeight());
                structmsg$StructMsg structMsgFromMap = ((INewFriendApi) QRoute.api(INewFriendApi.class)).getStructMsgFromMap(Long.valueOf(currStructMsgKey));
                if (structMsgFromMap != null) {
                    String valueOf = String.valueOf(structMsgFromMap.req_uin.get());
                    Message obtainMessage = Face2FaceAddFriendActivity.this.f205597h0.obtainMessage();
                    obtainMessage.what = 2;
                    obtainMessage.arg1 = 3;
                    obtainMessage.obj = valueOf;
                    Face2FaceAddFriendActivity.this.f205597h0.sendMessage(obtainMessage);
                    Face2FaceAddFriendActivity.this.b4(3, valueOf);
                }
                super.onSendSystemMsgActionFin(z16, str, i3, str2, i16, i17, str3, str4, i18);
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    currStructMsgKey = Long.parseLong(str);
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
            structmsg$StructMsg structMsgFromMap2 = ((INewFriendApi) QRoute.api(INewFriendApi.class)).getStructMsgFromMap(Long.valueOf(currStructMsgKey));
            if (structMsgFromMap2 != null) {
                String valueOf2 = String.valueOf(structMsgFromMap2.req_uin.get());
                if (QLog.isColorLevel() && !TextUtils.isEmpty(valueOf2)) {
                    QLog.i(Face2FaceAddFriendActivity.E1, 2, "onSendSystemMsgActionFin \u540c\u610f\u52a0\u5bf9\u65b9\u597d\u53cb\u56de\u8c03 =" + valueOf2.substring(0, 4));
                }
                Face2FaceAddFriendActivity.this.f205627w0.add(valueOf2);
            } else if (QLog.isColorLevel()) {
                QLog.i(Face2FaceAddFriendActivity.E1, 2, "onSendSystemMsgActionFin structMsg = null");
            }
            super.onSendSystemMsgActionFin(z16, str, i3, str2, i16, i17, str3, str4, i18);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class u extends com.tencent.mobileqq.friend.observer.a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private QQCustomDialog f205670d;

        /* renamed from: e, reason: collision with root package name */
        private int f205671e;

        /* renamed from: f, reason: collision with root package name */
        DialogInterface.OnClickListener f205672f;

        /* renamed from: h, reason: collision with root package name */
        DialogInterface.OnClickListener f205673h;

        /* renamed from: i, reason: collision with root package name */
        DialogInterface.OnDismissListener f205674i;

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class a implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) u.this);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    Face2FaceAddFriendActivity.this.r3();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class b implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) u.this);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                } else {
                    u.this.f205670d.dismiss();
                }
            }
        }

        /* compiled from: P */
        /* loaded from: classes12.dex */
        class c implements DialogInterface.OnDismissListener {
            static IPatchRedirector $redirector_;

            c() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) u.this);
                }
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                } else {
                    u.this.f205670d.dismiss();
                }
            }
        }

        u() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Face2FaceAddFriendActivity.this);
                return;
            }
            this.f205672f = new a();
            this.f205673h = new b();
            this.f205674i = new c();
        }

        private void b() {
            String str;
            String str2;
            String str3;
            String str4;
            int i3;
            if (this.f205670d != null && this.f205671e != 0) {
                Bundle bundle = (Bundle) AntiFraudConfigFileUtil.n().p("SecWarningCfg", "AlertTitle", 147, this.f205671e);
                if (bundle != null) {
                    str = bundle.getString("AlertTitle");
                } else {
                    str = null;
                }
                Bundle bundle2 = (Bundle) AntiFraudConfigFileUtil.n().p("SecWarningCfg", "AlertText", 147, this.f205671e);
                if (bundle2 != null) {
                    str2 = bundle2.getString("AlertText");
                } else {
                    str2 = null;
                }
                Bundle bundle3 = (Bundle) AntiFraudConfigFileUtil.n().p("SecWarningCfg", "AlertLeftBtnText", 147, this.f205671e);
                if (bundle3 != null) {
                    str3 = bundle3.getString("AlertLeftBtnText");
                } else {
                    str3 = null;
                }
                Bundle bundle4 = (Bundle) AntiFraudConfigFileUtil.n().p("SecWarningCfg", "AlertRightBtnText", 147, this.f205671e);
                if (bundle4 != null) {
                    str4 = bundle4.getString("AlertRightBtnText");
                } else {
                    str4 = null;
                }
                if (str == null) {
                    Face2FaceAddFriendActivity face2FaceAddFriendActivity = Face2FaceAddFriendActivity.this;
                    if (this.f205671e == 1) {
                        i3 = R.string.ham;
                    } else {
                        i3 = R.string.haq;
                    }
                    str = face2FaceAddFriendActivity.getString(i3);
                }
                if (str2 == null) {
                    int i16 = this.f205671e;
                    if (i16 == 1) {
                        str2 = Face2FaceAddFriendActivity.this.getString(R.string.han);
                    } else if (i16 == 2) {
                        str2 = Face2FaceAddFriendActivity.this.getString(R.string.hal);
                    } else if (i16 == 3) {
                        str2 = Face2FaceAddFriendActivity.this.getString(R.string.hap);
                    } else if (i16 == 4) {
                        str2 = Face2FaceAddFriendActivity.this.getString(R.string.hao);
                    }
                }
                if (str3 == null) {
                    if (this.f205671e == 1) {
                        this.f205672f = null;
                    } else {
                        str3 = Face2FaceAddFriendActivity.this.getString(R.string.hai);
                    }
                } else if (TextUtils.isEmpty(str3.trim())) {
                    this.f205672f = null;
                }
                if (str4 == null) {
                    if (this.f205671e == 1) {
                        str4 = Face2FaceAddFriendActivity.this.getString(R.string.hah);
                    } else {
                        str4 = Face2FaceAddFriendActivity.this.getString(R.string.hag);
                    }
                } else if (TextUtils.isEmpty(str4.trim())) {
                    this.f205673h = null;
                }
                this.f205670d.setTitle(str);
                this.f205670d.setMessage(str2);
                this.f205670d.setNegativeButton(str3, this.f205672f);
                this.f205670d.setPositiveButton(str4, this.f205673h);
                if (this.f205672f == null || this.f205673h == null) {
                    this.f205670d.findViewById(R.id.aet).setVisibility(8);
                }
            }
        }

        @Override // com.tencent.mobileqq.friend.observer.a
        protected void onGetAutoInfo(boolean z16, String str, String str2, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), str, str2, Integer.valueOf(i3));
                return;
            }
            if (!TextUtils.equals(Face2FaceAddFriendActivity.this.P0, str)) {
                return;
            }
            if (z16) {
                if (!Face2FaceAddFriendActivity.this.R0.containsKey(str)) {
                    Face2FaceAddFriendActivity.this.L0.setText(str2);
                    try {
                        EditText editText = Face2FaceAddFriendActivity.this.L0;
                        editText.setSelection(editText.getText().length());
                    } catch (IndexOutOfBoundsException unused) {
                        if (QLog.isColorLevel()) {
                            QLog.d(Face2FaceAddFriendActivity.E1, 2, "onGetAutoInfo | IndexOutOfBoundsException");
                        }
                    }
                }
                if (!Face2FaceAddFriendActivity.this.S0.containsKey(str)) {
                    Face2FaceAddFriendActivity face2FaceAddFriendActivity = Face2FaceAddFriendActivity.this;
                    face2FaceAddFriendActivity.Q0 = i3;
                    face2FaceAddFriendActivity.p4();
                    Face2FaceAddFriendActivity face2FaceAddFriendActivity2 = Face2FaceAddFriendActivity.this;
                    face2FaceAddFriendActivity2.S0.put(str, Integer.valueOf(face2FaceAddFriendActivity2.Q0));
                    return;
                }
                return;
            }
            if (!Face2FaceAddFriendActivity.this.S0.containsKey(str)) {
                Face2FaceAddFriendActivity face2FaceAddFriendActivity3 = Face2FaceAddFriendActivity.this;
                face2FaceAddFriendActivity3.Q0 = 0;
                face2FaceAddFriendActivity3.p4();
                Face2FaceAddFriendActivity face2FaceAddFriendActivity4 = Face2FaceAddFriendActivity.this;
                face2FaceAddFriendActivity4.S0.put(str, Integer.valueOf(face2FaceAddFriendActivity4.Q0));
            }
        }

        @Override // com.tencent.mobileqq.friend.observer.a
        protected void onQueryUinSafetyFlag(boolean z16, long j3, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Long.valueOf(j3), Integer.valueOf(i3));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(Face2FaceAddFriendActivity.E1, 2, "onQueryUinSafetyFlag isSuccess=" + z16 + "status=" + i3);
            }
            if (!z16 || i3 == 0) {
                Face2FaceAddFriendActivity.this.r3();
                return;
            }
            this.f205671e = i3;
            AntiFraudConfigFileUtil.n().f(Face2FaceAddFriendActivity.this.app, "SecWarningCfg");
            try {
                this.f205670d = DialogUtil.createCustomDialog(Face2FaceAddFriendActivity.this, 230, "", "", this.f205672f, this.f205673h);
                b();
                this.f205670d.setOnDismissListener(this.f205674i);
                this.f205670d.show();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.friend.observer.a
        public void onUpdateAddFriend(boolean z16, boolean z17, boolean z18, String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), str, bundle);
                return;
            }
            super.onUpdateAddFriend(z16, z17, z18, str, bundle);
            int i3 = bundle.getInt("friend_setting");
            if (QLog.isColorLevel()) {
                QLog.d(Face2FaceAddFriendActivity.E1, 2, "onUpdateAddFriend\u8bf7\u6c42\u52a0\u597d\u53cb\u56de\u8c03 isSuccess= " + z16 + "addSuccess=" + z17 + "reqestUin=" + str + "friendSetting" + i3);
            }
            if (z17) {
                Face2FaceAddFriendActivity.this.R0.put(bundle.getString("uin"), bundle.getString("remark"));
                if (i3 == 0) {
                    Message obtainMessage = Face2FaceAddFriendActivity.this.f205597h0.obtainMessage();
                    obtainMessage.what = 2;
                    obtainMessage.arg1 = 2;
                    Face2FaceAddFriendActivity face2FaceAddFriendActivity = Face2FaceAddFriendActivity.this;
                    obtainMessage.obj = face2FaceAddFriendActivity.P0;
                    face2FaceAddFriendActivity.f205597h0.sendMessage(obtainMessage);
                    Face2FaceAddFriendActivity face2FaceAddFriendActivity2 = Face2FaceAddFriendActivity.this;
                    face2FaceAddFriendActivity2.b4(2, face2FaceAddFriendActivity2.P0);
                    return;
                }
                Message obtainMessage2 = Face2FaceAddFriendActivity.this.f205597h0.obtainMessage();
                obtainMessage2.what = 2;
                obtainMessage2.arg1 = 4;
                Face2FaceAddFriendActivity face2FaceAddFriendActivity3 = Face2FaceAddFriendActivity.this;
                obtainMessage2.obj = face2FaceAddFriendActivity3.P0;
                face2FaceAddFriendActivity3.f205597h0.sendMessage(obtainMessage2);
                Face2FaceAddFriendActivity face2FaceAddFriendActivity4 = Face2FaceAddFriendActivity.this;
                face2FaceAddFriendActivity4.b4(4, face2FaceAddFriendActivity4.P0);
                return;
            }
            String string = bundle.getString("ErrorString");
            if (QLog.isColorLevel()) {
                QLog.d(Face2FaceAddFriendActivity.E1, 2, "add friend response error and ErroString = " + string);
            }
            if (TextUtils.isEmpty(string)) {
                string = Face2FaceAddFriendActivity.this.getString(R.string.b2s);
            }
            QQToast.makeText(Face2FaceAddFriendActivity.this, 0, string, 0).show(Face2FaceAddFriendActivity.this.getTitleBarHeight());
        }

        @Override // com.tencent.mobileqq.friend.observer.a
        protected void onUpdateAddFriendSetting(boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), bundle);
                return;
            }
            String string = bundle.getString("uin");
            int i3 = bundle.getInt("friend_setting");
            if (QLog.isColorLevel()) {
                QLog.d(Face2FaceAddFriendActivity.E1, 2, "onUpdateAddFriendSetting\u8bf7\u6c42\u52a0\u597d\u53cb\u8bbe\u7f6e isSuccess= " + z16 + "friendSetting=" + i3);
            }
            String obj = Face2FaceAddFriendActivity.this.L0.getText().toString();
            Face2FaceAddFriendActivity face2FaceAddFriendActivity = Face2FaceAddFriendActivity.this;
            byte b16 = (byte) face2FaceAddFriendActivity.Q0;
            if (TextUtils.isEmpty(face2FaceAddFriendActivity.P0)) {
                return;
            }
            ((IFriendHandlerService) Face2FaceAddFriendActivity.this.app.getRuntimeService(IFriendHandlerService.class)).requestAddFriend(Face2FaceAddFriendActivity.this.P0, null, i3, b16, "", 3021, 0, true, null, true, obj, "");
            if (QLog.isColorLevel()) {
                QLog.d(Face2FaceAddFriendActivity.E1, 2, "\u8bf7\u6c42\u52a0\u597d\u53cb" + Face2FaceAddFriendActivity.this.P0);
            }
            if (Face2FaceAddFriendActivity.this.P0.equals(string) && z16) {
                bundle.getStringArrayList("user_question");
                bundle.getBoolean("contact_bothway");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class v extends Handler {
        static IPatchRedirector $redirector_;

        v() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) Face2FaceAddFriendActivity.this);
            }
        }

        public void a(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, j3);
            } else {
                removeMessages(0);
                sendMessageDelayed(obtainMessage(0), j3);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:117:0x0299, code lost:
        
            if (r0.isTroopMember(r15.f205754b) != false) goto L91;
         */
        /* JADX WARN: Code restructure failed: missing block: B:132:0x02b2, code lost:
        
            if (r0.getTroopMemberInfoSync(r4.f205585b0, r15.f205754b, r4, com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity.E1) != null) goto L91;
         */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleMessage(Message message) {
            boolean z16;
            int i3;
            boolean z17;
            IPatchRedirector iPatchRedirector = $redirector_;
            int i16 = 2;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i17 = message.what;
            if (i17 != 0) {
                boolean z18 = false;
                switch (i17) {
                    case 2:
                        Face2FaceAddFriendActivity.this.o4((String) message.obj, message.arg1);
                        return;
                    case 3:
                        Face2FaceAddFriendActivity.this.U0.i(1, false);
                        return;
                    case 4:
                        int i18 = message.arg1;
                        int i19 = message.arg2;
                        Bundle data = message.getData();
                        Boolean valueOf = Boolean.valueOf(data.getBoolean("key_data _ispush"));
                        boolean z19 = data.getBoolean("key_data _hasfriend");
                        int size = Face2FaceAddFriendActivity.this.f205611o0.size();
                        if (size >= 10) {
                            size = 10;
                        }
                        if (Face2FaceAddFriendActivity.this.f205613p0.contains(message.obj)) {
                            if (QLog.isColorLevel()) {
                                QLog.d(Face2FaceAddFriendActivity.E1, 2, "push\u7684\u6570\u636e\u662f\u663e\u793a\u5217\u8868\u4e2d\u5df2\u6709\u6570\u636e");
                                return;
                            }
                            return;
                        }
                        if (i18 < size) {
                            if (i19 == 1) {
                                com.tencent.mobileqq.facetoface.g gVar = (com.tencent.mobileqq.facetoface.g) message.obj;
                                if (gVar.f205760c) {
                                    i3 = 2;
                                } else {
                                    i3 = 1;
                                }
                                if (Face2FaceAddFriendActivity.this.f205601j0 == size - 1) {
                                    z18 = true;
                                }
                                if (valueOf.booleanValue()) {
                                    Face2FaceAddFriendActivity.this.U0.m();
                                    z17 = true;
                                } else {
                                    z17 = z18;
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.d(Face2FaceAddFriendActivity.E1, 2, "show next isPush=" + valueOf + "isNeedShake=" + z17 + "currentFriendIndex=" + Face2FaceAddFriendActivity.this.f205601j0 + "count=" + size);
                                }
                                Face2FaceAddFriendActivity.this.U0.l(gVar, valueOf.booleanValue(), i3, z19, z17);
                                if (Face2FaceAddFriendActivity.this.T0.containsKey(gVar.f205754b)) {
                                    Face2FaceAddFriendActivity.this.T0.remove(gVar.f205754b);
                                    Face2FaceAddFriendActivity.this.T0.put(gVar.f205754b, Integer.valueOf(i3));
                                } else {
                                    Face2FaceAddFriendActivity.this.T0.put(gVar.f205754b, Integer.valueOf(i3));
                                }
                            } else if (i19 == 2) {
                                com.tencent.mobileqq.facetoface.e eVar = (com.tencent.mobileqq.facetoface.e) message.obj;
                                Face2FaceAddFriendActivity face2FaceAddFriendActivity = Face2FaceAddFriendActivity.this;
                                int i26 = face2FaceAddFriendActivity.f205583a0;
                                if (i26 == 0) {
                                    break;
                                } else {
                                    if (i26 == 1) {
                                        ITroopMemberListRepoApi iTroopMemberListRepoApi = (ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class);
                                        Face2FaceAddFriendActivity face2FaceAddFriendActivity2 = Face2FaceAddFriendActivity.this;
                                        break;
                                    }
                                    i16 = 1;
                                    if (Face2FaceAddFriendActivity.this.f205601j0 == size - 1) {
                                        z18 = true;
                                    }
                                    if (valueOf.booleanValue()) {
                                        Face2FaceAddFriendActivity.this.U0.m();
                                        z16 = true;
                                    } else {
                                        z16 = z18;
                                    }
                                    Face2FaceAddFriendActivity.this.U0.l(eVar, valueOf.booleanValue(), i16, z19, z16);
                                    if (Face2FaceAddFriendActivity.this.T0.containsKey(eVar.f205754b)) {
                                        Face2FaceAddFriendActivity.this.T0.remove(eVar.f205754b);
                                        Face2FaceAddFriendActivity.this.T0.put(eVar.f205754b, Integer.valueOf(i16));
                                    } else {
                                        Face2FaceAddFriendActivity.this.T0.put(eVar.f205754b, Integer.valueOf(i16));
                                    }
                                }
                            }
                            Face2FaceAddFriendActivity.this.i4();
                            return;
                        }
                        return;
                    case 5:
                        Face2FaceAddFriendActivity face2FaceAddFriendActivity3 = Face2FaceAddFriendActivity.this;
                        LBSHandler lBSHandler = face2FaceAddFriendActivity3.f205588c1;
                        if (lBSHandler != null) {
                            lBSHandler.O2(face2FaceAddFriendActivity3.app.getCurrentAccountUin(), true);
                            sendMessageDelayed(obtainMessage(5), Face2FaceAddFriendActivity.J1);
                            if (QLog.isColorLevel()) {
                                QLog.d(Face2FaceAddFriendActivity.E1, 2, "FTF_MSG_SEND_HEARTBEAT=" + Face2FaceAddFriendActivity.this.app.getCurrentAccountUin());
                                return;
                            }
                            return;
                        }
                        return;
                    case 6:
                        if (!Face2FaceAddFriendActivity.this.f205599i0) {
                            QQToast.makeText(Face2FaceAddFriendActivity.this, 0, Face2FaceAddFriendActivity.this.getResources().getString(R.string.b2t), 0).show(Face2FaceAddFriendActivity.this.getTitleBarHeight());
                            return;
                        }
                        return;
                    case 7:
                        Face2FaceAddFriendActivity.this.U3();
                        return;
                    case 8:
                        Face2FaceAddFriendActivity.this.U0.j();
                        return;
                    case 9:
                        Face2FaceAddFriendActivity.this.h3();
                        return;
                    case 10:
                        Face2FaceAddFriendActivity.this.X3((com.tencent.mobileqq.facetoface.e) message.obj);
                        return;
                    case 11:
                        Face2FaceAddFriendActivity.this.M3(message.arg1);
                        return;
                    case 12:
                        Face2FaceAddFriendActivity.this.n3((com.tencent.mobileqq.facetoface.c) message.obj);
                        return;
                    case 13:
                        Iterator<com.tencent.mobileqq.facetoface.e> it = Face2FaceAddFriendActivity.this.f205613p0.iterator();
                        while (it.hasNext()) {
                            com.tencent.mobileqq.facetoface.e next = it.next();
                            if (next.f205753a == 1 && Face2FaceAddFriendActivity.this.J3(next.f205754b)) {
                                Face2FaceAddFriendActivity.this.M3(next.f205753a);
                            } else if (next.f205753a == 2 && Face2FaceAddFriendActivity.this.isTroopMember(next.f205754b)) {
                                Face2FaceAddFriendActivity.this.M3(next.f205753a);
                            }
                        }
                        return;
                    case 14:
                        Object obj = message.obj;
                        if (obj instanceof com.tencent.mobileqq.facetoface.f) {
                            Face2FaceAddFriendActivity.this.e3((com.tencent.mobileqq.facetoface.f) obj);
                            return;
                        }
                        return;
                    case 15:
                        Object obj2 = message.obj;
                        if (obj2 instanceof com.tencent.mobileqq.facetoface.f) {
                            Face2FaceAddFriendActivity.this.f205624u1.add((com.tencent.mobileqq.facetoface.f) obj2);
                            return;
                        }
                        return;
                    case 16:
                        if (message.obj instanceof com.tencent.mobileqq.facetoface.f) {
                            Face2FaceAddFriendActivity.this.A1.d((com.tencent.mobileqq.facetoface.f) message.obj);
                            return;
                        }
                        return;
                    case 17:
                        com.tencent.mobileqq.facetoface.f fVar = new com.tencent.mobileqq.facetoface.f((Face2FaceAddFriendActivity.this.f205622t1 + 2396794490L) + "", "Member " + Face2FaceAddFriendActivity.this.f205622t1, 1, 1, "");
                        Face2FaceAddFriendActivity face2FaceAddFriendActivity4 = Face2FaceAddFriendActivity.this;
                        face2FaceAddFriendActivity4.f205622t1 = face2FaceAddFriendActivity4.f205622t1 + 1;
                        face2FaceAddFriendActivity4.A1.d(fVar);
                        Face2FaceAddFriendActivity.this.f205597h0.sendEmptyMessageDelayed(17, 300L);
                        return;
                    case 18:
                        QQToast.makeText(Face2FaceAddFriendActivity.this.app.getApplication(), R.string.f171139ci4, 0).show(Face2FaceAddFriendActivity.this.getTitleBarHeight());
                        return;
                    default:
                        return;
                }
            }
            Face2FaceAddFriendActivity.this.f205593f0.invalidate();
            a(20L);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71820);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 45)) {
            redirector.redirect((short) 45);
            return;
        }
        E1 = "Face2FaceAddFriendActivity";
        F1 = "Face2FaceAddFriendActivity.troop";
        G1 = "Face2FaceAddFriendActivity.time";
        H1 = 3021;
        I1 = 500;
        J1 = 300000;
        K1 = 1000L;
        L1 = 2000;
    }

    public Face2FaceAddFriendActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f205583a0 = 0;
        this.f205585b0 = null;
        this.f205587c0 = false;
        this.f205591e0 = false;
        this.f205597h0 = new v();
        this.f205599i0 = false;
        this.f205601j0 = 0;
        this.f205603k0 = 0;
        this.f205605l0 = new ArrayList();
        this.f205607m0 = new ArrayList();
        this.f205609n0 = new ArrayList();
        this.f205611o0 = new ArrayList();
        this.f205613p0 = new CopyOnWriteArrayList<>();
        this.f205615q0 = false;
        this.f205617r0 = false;
        this.f205619s0 = 0;
        this.f205621t0 = 0;
        this.f205623u0 = false;
        this.f205625v0 = 0L;
        this.f205627w0 = new ArrayList();
        this.f205629x0 = true;
        this.f205631y0 = false;
        this.f205633z0 = false;
        this.A0 = false;
        this.B0 = 0;
        this.C0 = 0;
        this.F0 = null;
        this.G0 = null;
        this.H0 = null;
        this.I0 = null;
        this.J0 = null;
        this.L0 = null;
        this.M0 = null;
        this.N0 = null;
        this.O0 = null;
        this.Q0 = 0;
        this.R0 = new HashMap<>();
        this.S0 = new HashMap<>();
        this.T0 = new HashMap<>();
        this.V0 = false;
        this.W0 = true;
        this.X0 = null;
        this.Y0 = null;
        this.f205586b1 = true;
        this.f205590d1 = 0L;
        this.f205598h1 = false;
        this.f205600i1 = false;
        this.f205602j1 = "";
        this.f205610n1 = 0L;
        this.f205612o1 = 0L;
        this.f205614p1 = false;
        this.f205616q1 = 0;
        this.f205618r1 = 0;
        this.f205620s1 = null;
        this.f205622t1 = 0;
        this.f205624u1 = new ArrayList<>();
        this.f205626v1 = new s();
        this.f205628w1 = new t();
        this.f205630x1 = new u();
        this.f205632y1 = new a();
        this.f205634z1 = new b();
        this.A1 = new c();
        this.B1 = 0L;
        this.C1 = null;
        this.D1 = new l();
    }

    private com.tencent.mobileqq.facetoface.e A3() {
        for (com.tencent.mobileqq.facetoface.e eVar : this.f205605l0) {
            if (eVar != null && J3(eVar.f205754b) && !this.f205613p0.contains(eVar)) {
                return eVar;
            }
        }
        return null;
    }

    private com.tencent.mobileqq.facetoface.e B3() {
        for (com.tencent.mobileqq.facetoface.e eVar : this.f205607m0) {
            if (eVar != null && !isTroopMember(eVar.f205754b) && !this.f205613p0.contains(eVar)) {
                return eVar;
            }
        }
        return null;
    }

    private com.tencent.mobileqq.facetoface.e C3() {
        for (com.tencent.mobileqq.facetoface.e eVar : this.f205605l0) {
            if (eVar != null && !J3(eVar.f205754b) && !this.f205613p0.contains(eVar)) {
                return eVar;
            }
        }
        return null;
    }

    private com.tencent.mobileqq.facetoface.e D3() {
        for (com.tencent.mobileqq.facetoface.e eVar : this.f205607m0) {
            if (eVar != null && isTroopMember(eVar.f205754b) && !this.f205613p0.contains(eVar)) {
                return eVar;
            }
        }
        return null;
    }

    private void F3() {
        View inflate = LayoutInflater.from(getApplicationContext()).inflate(R.layout.f167800hz, (ViewGroup) null);
        com.tencent.mobileqq.facetoface.a aVar = new com.tencent.mobileqq.facetoface.a(this.app, this);
        this.U0 = aVar;
        aVar.e(this.app, inflate, this.f205583a0, this.f205585b0);
        this.f205589d0.addView(inflate);
        this.f205620s1 = inflate;
        if (this.f205583a0 == 1) {
            this.f205587c0 = false;
            this.f205594f1 = inflate.findViewById(R.id.b6q);
            this.f205596g1 = (TextView) inflate.findViewById(R.id.b6m);
            TextView textView = (TextView) inflate.findViewById(R.id.b6p);
            this.f205592e1 = textView;
            textView.setText(R.string.f170920b33);
            this.f205592e1.setVisibility(0);
            inflate.findViewById(R.id.b6n).setOnClickListener(this);
            this.f205594f1.setOnClickListener(this);
            this.f205592e1.setOnClickListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G3() {
        this.f205614p1 = true;
        l4();
        this.f205597h0.sendEmptyMessageDelayed(3, 0L);
        U3();
    }

    private boolean H3(com.tencent.mobileqq.facetoface.e eVar) {
        if (eVar == null) {
            return false;
        }
        if ((eVar.f205753a != 1 || !J3(eVar.f205754b)) && (eVar.f205753a != 2 || !isTroopMember(eVar.f205754b))) {
            return false;
        }
        return true;
    }

    private boolean I3() {
        String str;
        if (this.f205583a0 == 1) {
            str = "sp_facetoface_showguide_for_troop";
        } else {
            str = "sp_facetoface_showguide";
        }
        SharedPreferences sharedPreferences = this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0);
        if (sharedPreferences == null) {
            return false;
        }
        boolean z16 = sharedPreferences.getBoolean(str, false);
        this.f205591e0 = z16;
        if (z16) {
            return false;
        }
        View inflate = LayoutInflater.from(getApplicationContext()).inflate(R.layout.f167801i0, (ViewGroup) null);
        Button button = (Button) inflate.findViewById(R.id.c0r);
        inflate.setBackgroundResource(R.drawable.clw);
        inflate.setOnClickListener(this);
        if (this.f205583a0 == 1) {
            ((TextView) inflate.findViewById(R.id.c0q)).setText(R.string.b2x);
        }
        this.f205589d0.addView(inflate, new LinearLayout.LayoutParams(-1, -1));
        button.setOnClickListener(new p(str, inflate));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean J3(String str) {
        return ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), E1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L3() {
        int i3;
        if (QLog.isColorLevel()) {
            QLog.d(E1, 2, "mergeShowList isFriendDataBack=" + this.f205615q0 + "isTroopDataBack=" + this.f205617r0);
            QLog.d(E1, 2, "mergeShowList isFriendBackSuccess=" + this.f205619s0 + "isTroopBackSuccess=" + this.f205621t0);
        }
        int i16 = this.f205619s0;
        if (i16 != 0 && (i3 = this.f205621t0) != 0) {
            if (i16 == 1 && i3 == 1 && (!this.f205615q0 || !this.f205617r0)) {
                if (QLog.isColorLevel()) {
                    QLog.d(E1, 2, "mergeShowList return");
                    return;
                }
                return;
            }
            if (this.f205623u0) {
                if (QLog.isColorLevel()) {
                    QLog.d(E1, 2, "mergeShowList return has merged");
                    return;
                }
                return;
            }
            int size = this.f205605l0.size();
            int size2 = this.f205607m0.size();
            this.f205623u0 = true;
            this.B0 += size;
            this.C0 += size2;
            if (QLog.isColorLevel()) {
                QLog.d(E1, 2, "mergeShowList mFriendSize=" + size + "mTroopSize=" + size2);
            }
            int i17 = size + size2;
            if (i17 == 0) {
                return;
            }
            if (i17 > 10) {
                if (size >= 5 && size2 >= 5) {
                    ArrayList arrayList = new ArrayList(v3(this.f205605l0, 5));
                    ArrayList arrayList2 = new ArrayList(w3(this.f205607m0, 5));
                    K3(this.f205611o0, arrayList);
                    K3(this.f205611o0, arrayList2);
                } else if (size < 5) {
                    this.f205611o0.addAll(this.f205605l0);
                    K3(this.f205611o0, new ArrayList(w3(this.f205607m0, 10 - this.f205605l0.size())));
                } else if (size2 < 5) {
                    K3(this.f205611o0, new ArrayList(v3(this.f205605l0, 10 - this.f205607m0.size())));
                }
                Iterator<com.tencent.mobileqq.facetoface.e> it = this.f205611o0.iterator();
                int i18 = 0;
                while (it.hasNext()) {
                    if (H3(it.next())) {
                        i18++;
                    }
                }
                for (int i19 = 0; i19 < i18 && d4(); i19++) {
                }
            } else {
                K3(this.f205611o0, this.f205605l0);
                K3(this.f205611o0, this.f205607m0);
            }
            if (QLog.isColorLevel()) {
                QLog.d(E1, 2, "mergeShowList size=" + this.f205611o0.size());
            }
            this.V0 = true;
            int i26 = this.f205601j0;
            if (i26 > 0) {
                l3(false, i26, false);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(E1, 2, "mergeShowList return wait successStatus");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0033, code lost:
    
        if (r0 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x002c, code lost:
    
        if (r2 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0036, code lost:
    
        r0 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void M3(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(E1, 2, "notifyNeedReplace ask replace type" + i3);
        }
        com.tencent.mobileqq.facetoface.e C3 = C3();
        com.tencent.mobileqq.facetoface.e B3 = B3();
        if (i3 == 1) {
            if (C3 == null) {
            }
        } else {
            if (B3 == null) {
            }
            C3 = B3;
        }
        if (C3 != null) {
            W3(C3);
            if (QLog.isColorLevel()) {
                QLog.d(E1, 2, "notifyNeedReplace replaceData type" + C3.f205753a);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(E1, 2, "notifyNeedReplace no data can replace");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0128  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void W3(com.tencent.mobileqq.facetoface.e eVar) {
        if (this.U0 == null) {
            return;
        }
        Iterator<com.tencent.mobileqq.facetoface.e> it = this.f205613p0.iterator();
        boolean z16 = false;
        int i3 = 0;
        int i16 = 0;
        while (it.hasNext()) {
            if (it.next().f205753a == 1) {
                i3++;
            } else {
                i16++;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(E1, 2, "pushDataToReplace \u663e\u793a\u5217\u8868 mfriendCount=" + i3 + "mtroopCount=" + i16);
        }
        com.tencent.mobileqq.facetoface.e s36 = s3();
        com.tencent.mobileqq.facetoface.e t36 = t3();
        if (eVar.f205753a == 1) {
            if (s36 == null) {
                if (t36 == null) {
                    if (i3 < 5 && i16 > 5 && this.f205583a0 == 0) {
                        s36 = null;
                        for (int i17 = 0; i17 < this.f205613p0.size(); i17++) {
                            com.tencent.mobileqq.facetoface.e eVar2 = this.f205613p0.get(i17);
                            if (eVar2 != null && eVar2.f205753a == 2 && !isTroopMember(eVar2.f205754b)) {
                                s36 = eVar2;
                            }
                        }
                    }
                    s36 = null;
                }
                s36 = t36;
            }
            if (s36 != null) {
                String str = s36.f205754b;
                if (s36 instanceof com.tencent.mobileqq.facetoface.c) {
                    str = s36.f205754b + "_" + ((com.tencent.mobileqq.facetoface.c) s36).f205749d;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(E1, 2, "pushDataToReplace rRplaceData!=null && replace type=" + s36.f205753a);
                }
                this.U0.a(str);
                if (this.f205583a0 != 1) {
                    z16 = true;
                }
                this.U0.k(s36, z16);
                int u36 = u3(s36);
                if (u36 != -1 && u36 < this.f205611o0.size()) {
                    this.f205611o0.set(u36, eVar);
                    l3(true, u36, true);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(E1, 2, "pushDataToReplace rRplaceData=null \u6ca1\u6709\u53ef\u4ee5\u66ff\u6362\u7684\u6570\u636e");
                return;
            }
            return;
        }
        if (t36 == null) {
            if (s36 == null) {
                if (i3 > 5 && i16 < 5) {
                    s36 = null;
                    for (int i18 = 0; i18 < this.f205613p0.size(); i18++) {
                        com.tencent.mobileqq.facetoface.e eVar3 = this.f205613p0.get(i18);
                        if (eVar3 != null && eVar3.f205753a == 1 && !J3(eVar3.f205754b)) {
                            s36 = eVar3;
                        }
                    }
                }
                s36 = null;
            }
            if (s36 != null) {
            }
        }
        s36 = t36;
        if (s36 != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X3(com.tencent.mobileqq.facetoface.e eVar) {
        if (this.f205611o0 != null && eVar != null) {
            if (QLog.isColorLevel()) {
                QLog.d(E1, 2, "pushDataToUI mShowdataList=" + this.f205611o0.size() + "currentFriendIndex=" + this.f205601j0 + "showtype=pushData.type=" + eVar.f205753a + "mFriendDataList.size()" + this.f205605l0.size() + "troop size" + this.f205607m0.size());
            }
            if (this.f205611o0.contains(eVar)) {
                return;
            }
            if (this.U0 == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(E1, 2, "pushDataToUI face2FaceAddFriendAnim has null");
                    return;
                }
                return;
            }
            if (this.f205605l0.size() + this.f205607m0.size() > 10) {
                if (H3(eVar)) {
                    return;
                }
                if (this.f205583a0 == 0) {
                    W3(eVar);
                    this.f205633z0 = true;
                    return;
                } else {
                    W3(eVar);
                    return;
                }
            }
            if (this.f205611o0.size() == 0 && !this.V0) {
                this.f205611o0.add(eVar);
                if (QLog.isColorLevel()) {
                    QLog.d(E1, 2, "pushDataToUI mShowdataList=" + this.f205611o0.size() + "currentFriendIndex=" + this.f205601j0 + "hasData" + this.V0);
                }
                this.V0 = true;
                return;
            }
            this.f205611o0.add(eVar);
            if (QLog.isColorLevel()) {
                QLog.d(E1, 2, "pushDataToUI mShowdataList=" + this.f205611o0.size() + "currentFriendIndex=" + this.f205601j0);
            }
            int size = this.f205611o0.size();
            int i3 = this.f205601j0;
            if (size == i3 + 1) {
                l3(true, i3, false);
                return;
            }
            return;
        }
        QLog.d(E1, 2, "pushDataToUI mNeedShowList= nuull  pushData = null!");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b3(String str) {
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d(E1, 2, "addFriend uin is null");
            }
            return false;
        }
        this.P0 = str;
        if (!i3(1, str)) {
            return false;
        }
        if (QLog.isColorLevel() && !TextUtils.isEmpty(str)) {
            QLog.d(E1, 2, "addFriend uin" + str.substring(0, 4));
        }
        ((IFriendHandlerService) this.app.getRuntimeService(IFriendHandlerService.class)).requestUinSafetyFlag(Long.parseLong(str));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b4(int i3, String str) {
        if (!str.equals(this.J0)) {
            return;
        }
        TextView textView = (TextView) this.K0.findViewById(R.id.f164029hi);
        LinearLayout linearLayout = (LinearLayout) this.K0.findViewById(R.id.f164027hf);
        Button button = (Button) this.K0.findViewById(R.id.h_);
        if (i3 == 3) {
            this.f205631y0 = true;
            g4(textView, HardCodeUtil.qqStr(R.string.mc6));
            g4(button, HardCodeUtil.qqStr(R.string.mca));
            button.setOnClickListener(new k(str));
            return;
        }
        if (i3 == 2) {
            if (this.R0.containsKey(str)) {
                String str2 = this.R0.get(str);
                if (!TextUtils.isEmpty(str2)) {
                    ((TextView) this.K0.findViewById(R.id.co8)).setText(str2);
                }
            }
            g4(textView, HardCodeUtil.qqStr(R.string.mcg));
            linearLayout.setVisibility(8);
            return;
        }
        if (i3 == 4) {
            g4(textView, HardCodeUtil.qqStr(R.string.mcf));
            g4(button, HardCodeUtil.qqStr(R.string.mcc));
        }
    }

    private void c3() {
        if (this.f205583a0 == 0) {
            addObserver(this.f205628w1);
            addObserver(this.f205626v1);
        }
        addObserver(this.f205632y1);
        addObserver(this.f205630x1);
        addObserver(this.f205634z1);
        addObserver(this.A1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e4(long j3) {
        Message obtainMessage = this.f205597h0.obtainMessage(7);
        if (QLog.isColorLevel()) {
            QLog.d(E1, 2, "sendDelayAskRequest delaytime=" + j3);
        }
        this.f205597h0.sendMessageDelayed(obtainMessage, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f4() {
        if (QLog.isColorLevel()) {
            QLog.d(E1, 2, "sendHeartRequest");
        }
        this.f205597h0.sendMessageDelayed(this.f205597h0.obtainMessage(5), J1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g3(String str) {
        new ArrayList();
        List<MessageRecord> Q = this.app.getMessageFacade().Q(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0);
        if (Q == null) {
            if (QLog.isColorLevel()) {
                QLog.d(E1, 2, "systemMsgList is null");
                return;
            }
            return;
        }
        if (Q.size() > 0 && !(Q.get(0) instanceof MessageForSystemMsg)) {
            if (QLog.isColorLevel()) {
                QLog.d(E1, 2, "systemMsgList error");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(E1, 2, "answerAddFriend systemMsgList size" + Q.size());
        }
        structmsg$StructMsg structmsg_structmsg = null;
        for (int size = Q.size() - 1; size >= 0; size--) {
            structmsg_structmsg = ((MessageForSystemMsg) Q.get(size)).getSystemMsg();
            if (structmsg_structmsg != null) {
                if (QLog.isColorLevel()) {
                    QLog.d(E1, 2, "answerAddFriend structMsg.req_uin =" + String.valueOf(structmsg_structmsg.req_uin.get()) + "friendUin=" + str);
                }
                if (str.equals(String.valueOf(structmsg_structmsg.req_uin.get()))) {
                    break;
                }
            }
        }
        if (structmsg_structmsg != null && str.equals(String.valueOf(structmsg_structmsg.req_uin.get()))) {
            int i3 = structmsg_structmsg.msg_type.get();
            long j3 = structmsg_structmsg.msg_seq.get();
            long j16 = structmsg_structmsg.req_uin.get();
            int i16 = structmsg_structmsg.f436065msg.sub_type.get();
            int i17 = structmsg_structmsg.f436065msg.src_id.get();
            int i18 = structmsg_structmsg.f436065msg.sub_src_id.get();
            int i19 = structmsg_structmsg.f436065msg.group_msg_type.get();
            List<structmsg$SystemMsgAction> list = structmsg_structmsg.f436065msg.actions.get();
            if (list != null && list.size() > 0) {
                int i26 = this.Q0;
                String obj = this.L0.getText().toString();
                if (obj == null) {
                    obj = "";
                }
                structmsg$SystemMsgActionInfo structmsg_systemmsgactioninfo = list.get(0).action_info.get();
                structmsg_systemmsgactioninfo.remark.set(obj);
                structmsg_systemmsgactioninfo.group_id.set(i26);
                this.app.getMsgHandler().m3().r0(i3, j3, j16, i16, i17, i18, i19, structmsg_systemmsgactioninfo, 0, structmsg_structmsg, false);
                setStructMsgToMap(structmsg_structmsg, structmsg_structmsg.msg_seq.get());
                if (QLog.isColorLevel()) {
                    QLog.d(E1, 2, "answerAddFriend  structMsg.req_uin:  " + String.valueOf(structmsg_structmsg.req_uin.get()));
                    return;
                }
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(E1, 2, "answerAddFriend  structMsg == null | , friendUin == structMsg.req_uin | ");
        }
    }

    private void g4(TextView textView, String str) {
        textView.setText(str);
        textView.setContentDescription(str);
    }

    private void h4(int i3, String str, Face2FaceFriendBubbleView face2FaceFriendBubbleView, String str2, Bitmap bitmap) {
        String str3;
        this.J0 = str;
        LinearLayout linearLayout = (LinearLayout) this.K0.findViewById(R.id.f164027hf);
        g4((TextView) this.K0.findViewById(R.id.co8), str2);
        ((ImageView) this.K0.findViewById(R.id.cnm)).setImageBitmap(bitmap);
        TextView textView = (TextView) this.K0.findViewById(R.id.f164029hi);
        Button button = (Button) this.K0.findViewById(R.id.h_);
        if (!this.R0.containsKey(str)) {
            str3 = "";
        } else {
            str3 = this.R0.get(str);
        }
        this.L0.setText(str3);
        if (!TextUtils.isEmpty(str3)) {
            this.L0.setSelection(str3.length());
        }
        this.A0 = true;
        if (this.S0.containsKey(str)) {
            this.Q0 = this.S0.get(str).intValue();
        }
        p4();
        this.P0 = str;
        ((IFriendHandlerService) this.app.getRuntimeService(IFriendHandlerService.class)).requestAutoInfo(this.P0, 3021, 0);
        this.N0.setOnClickListener(new g());
        button.setOnClickListener(new h(str));
        if (i3 == 2) {
            g4(textView, HardCodeUtil.qqStr(R.string.mcd));
            linearLayout.setVisibility(8);
        } else if (i3 != 4 && i3 != 1) {
            if (i3 == 3) {
                this.f205631y0 = true;
                g4(textView, HardCodeUtil.qqStr(R.string.mc9));
                linearLayout.setVisibility(0);
                g4(button, HardCodeUtil.qqStr(R.string.f171961mc2));
                button.setOnClickListener(new i(str));
            }
        } else {
            if (i3 == 4) {
                g4(textView, HardCodeUtil.qqStr(R.string.f171963mc4));
            } else {
                g4(textView, "");
            }
            g4(button, HardCodeUtil.qqStr(R.string.mc_));
            linearLayout.setVisibility(0);
        }
        this.K0.m(this, this.f205589d0, face2FaceFriendBubbleView, str, this.R0, new j(str));
    }

    private boolean i3(int i3, String str) {
        if (i3 != 1) {
            return false;
        }
        if (str.equals(this.app.getCurrentAccountUin())) {
            QQToast.makeText(this, R.string.f170677y8, 0).show(getTitleBarHeight());
            return false;
        }
        try {
            Long.parseLong(str);
            if (((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), E1)) {
                QQToast.makeText(this.app.getApplication(), R.string.f170332ml, 0).show(getTitleBarHeight());
                return false;
            }
            if (NetworkUtil.isNetSupport(this)) {
                return true;
            }
            QQToast.makeText(this.app.getApplication(), R.string.f171139ci4, 0).show(getTitleBarHeight());
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i4() {
        if (!this.app.isVideoChatting() && !this.app.isRingerVibrate() && !this.app.isRingEqualsZero() && this.app.isCallIdle() && this.f205600i1) {
            AudioUtil.n(R.raw.f169428z, false);
        }
    }

    private void initUI() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.f205604k1 = (ImageView) findViewById(R.id.fxy);
        this.f205606l1 = (ImageView) findViewById(R.id.bcs);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        this.f205608m1 = alphaAnimation;
        alphaAnimation.setDuration(1500L);
        this.f205608m1.setFillAfter(true);
        F3();
        this.f205595g0 = new Point(displayMetrics.widthPixels, displayMetrics.heightPixels);
        SnowView snowView = new SnowView(this);
        this.f205593f0 = snowView;
        snowView.setSnowView(this.f205595g0);
        this.f205589d0.addView(this.f205593f0);
        LayoutInflater layoutInflater = getLayoutInflater();
        this.f205589d0.addView(layoutInflater.inflate(R.layout.f167950nt, (ViewGroup) null));
        this.f205589d0.addView(layoutInflater.inflate(R.layout.f167951nu, (ViewGroup) null));
        this.E0 = (Face2FaceTroopDetailView) this.f205589d0.findViewById(R.id.jxr);
        Face2FaceFriendDetailView face2FaceFriendDetailView = (Face2FaceFriendDetailView) this.f205589d0.findViewById(R.id.cnh);
        this.K0 = face2FaceFriendDetailView;
        this.L0 = (EditText) face2FaceFriendDetailView.findViewById(R.id.cnl);
        this.M0 = (TextView) this.K0.findViewById(R.id.cor);
        this.N0 = (LinearLayout) this.K0.findViewById(R.id.cog);
        this.O0 = (LinearLayout) this.K0.findViewById(R.id.coh);
        this.L0.addTextChangedListener(new n());
        this.E0.setInfc(this.D1);
        this.K0.setInfc(this.D1);
        this.X0 = findViewById(R.id.iyn);
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            this.X0.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
        }
        this.Z0 = (TextView) findViewById(R.id.iyl);
        this.f205584a1 = (TextView) findViewById(R.id.iym);
        this.Z0.setOnClickListener(this);
        this.Z0.setOnTouchListener(this);
        if (this.f205583a0 == 1) {
            this.f205584a1.setVisibility(0);
            this.f205584a1.setOnClickListener(this);
            this.f205584a1.setOnTouchListener(this);
            this.Z0.setText(R.string.f170901b10);
            return;
        }
        this.f205584a1.setVisibility(8);
    }

    private void l3(boolean z16, int i3, boolean z17) {
        if (QLog.isColorLevel()) {
            QLog.d(E1, 2, "delayPushToUI mShowdataList.size()=" + this.f205611o0.size() + "ispush=" + z16 + "changeIndex" + i3 + "isReplash=" + z17);
        }
        int i16 = this.f205601j0;
        if (!z16) {
            i3 = i16;
        }
        if (i3 < this.f205611o0.size()) {
            Message obtainMessage = this.f205597h0.obtainMessage();
            obtainMessage.what = 4;
            Bundle bundle = new Bundle();
            bundle.putBoolean("key_data _ispush", z16);
            bundle.putBoolean("key_data _hasfriend", z17);
            obtainMessage.setData(bundle);
            obtainMessage.arg1 = i3;
            com.tencent.mobileqq.facetoface.e eVar = this.f205611o0.get(i3);
            obtainMessage.arg2 = eVar.f205753a;
            obtainMessage.obj = eVar;
            if (this.f205597h0.hasMessages(4)) {
                this.f205597h0.removeMessages(4);
            }
            this.f205597h0.sendMessageDelayed(obtainMessage, I1);
        }
    }

    private void n4() {
        if (this.f205629x0 && this.f205631y0) {
            if (QLog.isColorLevel()) {
                QLog.d(E1, 2, "clearSystemMsgData");
            }
            this.D0.markSystemMsgReaded();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o4(String str, int i3) {
        Face2FaceFriendBubbleView z36 = z3(str, 1);
        if (z36 != null) {
            z36.setStatusWithAnimation(i3);
            if (this.T0.containsKey(str)) {
                this.T0.remove(str);
                this.T0.put(str, Integer.valueOf(i3));
            } else {
                this.T0.put(str, Integer.valueOf(i3));
            }
        }
    }

    private void p3() {
        if (QLog.isColorLevel()) {
            QLog.d(E1, 2, "findReplaceData ");
        }
        com.tencent.mobileqq.facetoface.e C3 = C3();
        com.tencent.mobileqq.facetoface.e B3 = B3();
        com.tencent.mobileqq.facetoface.e A3 = A3();
        com.tencent.mobileqq.facetoface.e D3 = D3();
        if (this.f205605l0.size() + this.f205607m0.size() < 10) {
            if (QLog.isColorLevel()) {
                QLog.d(E1, 2, "findReplaceData friend count=" + this.f205605l0.size() + "troop count" + this.f205607m0.size());
                return;
            }
            return;
        }
        if (B3 != null) {
            C3 = B3;
        } else if (C3 == null) {
            if (D3 != null || A3 != null) {
                C3 = A3;
            } else {
                C3 = null;
            }
        }
        if (C3 != null) {
            this.f205611o0.add(C3);
            int size = this.f205611o0.size();
            int i3 = this.f205601j0;
            if (size == i3 + 1) {
                l3(true, i3, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p4() {
        ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getCategoryInfoWithCategoryId(this.Q0, E1, new hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b>() { // from class: com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity.10
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) Face2FaceAddFriendActivity.this);
                }
            }

            @Override // hx3.b
            public void onQueryResult(@Nullable com.tencent.qqnt.ntrelation.friendsinfo.bean.e<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> eVar) {
                String str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
                    return;
                }
                if (eVar.a() == 0 && eVar.b() != null && eVar.b().size() > 0) {
                    str = eVar.b().get(0).f();
                } else {
                    str = "";
                }
                ThreadManagerV2.getUIHandlerV2().post(new Runnable(str) { // from class: com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity.10.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ String f205637d;

                    {
                        this.f205637d = str;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass10.this, (Object) str);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        TextView textView = Face2FaceAddFriendActivity.this.M0;
                        if (textView != null) {
                            textView.setText(this.f205637d);
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r3() {
        ((IFriendHandlerService) this.app.getRuntimeService(IFriendHandlerService.class)).requestUserAddFriendSetting(this.P0, 3021, 0, "");
    }

    private void removeObserver() {
        if (this.f205583a0 == 0) {
            removeObserver(this.f205628w1);
            removeObserver(this.f205626v1);
        }
        removeObserver(this.f205632y1);
        removeObserver(this.f205630x1);
        removeObserver(this.f205634z1);
        removeObserver(this.A1);
    }

    private com.tencent.mobileqq.facetoface.e s3() {
        com.tencent.mobileqq.facetoface.e eVar;
        if (QLog.isColorLevel() && !TextUtils.isEmpty(this.f205602j1)) {
            QLog.d(E1, 2, "getHasShowFriendData\u6b63\u5728\u67e5\u770b\u8be6\u60c5Uin" + this.f205602j1.substring(0, 4));
        }
        Iterator<com.tencent.mobileqq.facetoface.e> it = this.f205613p0.iterator();
        while (true) {
            if (it.hasNext()) {
                eVar = it.next();
                if (!TextUtils.isEmpty(this.f205602j1) && eVar.f205754b.equals(this.f205602j1)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(E1, 2, "getHasShowFriendData\u9700\u8981\u66ff\u6362\u4f46\u662f\u6b63\u5728\u67e5\u770b\u8be6\u60c5");
                    }
                } else if (eVar.f205753a == 1 && J3(eVar.f205754b)) {
                    if (QLog.isColorLevel() && !TextUtils.isEmpty(eVar.f205754b)) {
                        QLog.d(E1, 2, "getHasShowFriendData\u53ef\u66ff\u6362\u597d\u53cb" + eVar.f205754b.substring(0, 4));
                    }
                }
            } else {
                eVar = null;
                break;
            }
        }
        if (eVar == null && QLog.isColorLevel()) {
            QLog.d(E1, 2, "getHasShowFriendData \u6ca1\u6709\u53ef\u66ff\u6362\u597d\u53cb");
        }
        return eVar;
    }

    private void setStructMsgToMap(structmsg$StructMsg structmsg_structmsg, long j3) {
        if (structmsg_structmsg != null) {
            long j16 = structmsg_structmsg.get().msg_seq.get() + structmsg_structmsg.get().msg_type.get();
            ((INewFriendApi) QRoute.api(INewFriendApi.class)).putStructMsgToMap(Long.valueOf(j16), structmsg_structmsg.get());
            ((INewFriendApi) QRoute.api(INewFriendApi.class)).setCurrStructMsgKey(j16);
            ((INewFriendApi) QRoute.api(INewFriendApi.class)).setCurrentUniseq(j3);
        }
    }

    private com.tencent.mobileqq.facetoface.e t3() {
        Iterator<com.tencent.mobileqq.facetoface.e> it = this.f205613p0.iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.facetoface.e next = it.next();
            if (!this.E0.isShowing() || !this.E0.L.equals(next)) {
                if (this.f205583a0 == 1 && this.f205624u1.contains(next)) {
                    return next;
                }
                if (next.f205753a == 2 && isTroopMember(next.f205754b)) {
                    return next;
                }
            }
        }
        return null;
    }

    private int u3(com.tencent.mobileqq.facetoface.e eVar) {
        return this.f205611o0.indexOf(eVar);
    }

    private List<com.tencent.mobileqq.facetoface.e> v3(List<com.tencent.mobileqq.facetoface.e> list, int i3) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty() && i3 >= 1) {
            for (com.tencent.mobileqq.facetoface.e eVar : list) {
                if (!J3(eVar.f205754b)) {
                    arrayList.add(eVar);
                    if (arrayList.size() == i3) {
                        break;
                    }
                }
            }
            if (arrayList.size() < i3) {
                for (com.tencent.mobileqq.facetoface.e eVar2 : list) {
                    if (J3(eVar2.f205754b)) {
                        arrayList.add(eVar2);
                        if (arrayList.size() == i3) {
                            break;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    private List<com.tencent.mobileqq.facetoface.e> w3(List<com.tencent.mobileqq.facetoface.e> list, int i3) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty() && i3 >= 1) {
            for (com.tencent.mobileqq.facetoface.e eVar : list) {
                if (!isTroopMember(eVar.f205754b)) {
                    arrayList.add(eVar);
                    if (arrayList.size() == i3) {
                        break;
                    }
                }
            }
            if (arrayList.size() < i3) {
                for (com.tencent.mobileqq.facetoface.e eVar2 : list) {
                    if (isTroopMember(eVar2.f205754b)) {
                        arrayList.add(eVar2);
                        if (arrayList.size() == i3) {
                            break;
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Face2FaceFriendBubbleView z3(String str, int i3) {
        if (str == null) {
            return null;
        }
        for (Face2FaceFriendBubbleView face2FaceFriendBubbleView : this.U0.f205716k) {
            if (str.equals(face2FaceFriendBubbleView.k()) && face2FaceFriendBubbleView.l() == i3) {
                return face2FaceFriendBubbleView;
            }
        }
        return null;
    }

    public boolean E3(com.tencent.mobileqq.facetoface.e eVar, List<com.tencent.mobileqq.facetoface.e> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) eVar, (Object) list)).booleanValue();
        }
        if (!list.contains(eVar)) {
            return false;
        }
        if (QLog.isColorLevel() && !TextUtils.isEmpty(eVar.f205754b)) {
            QLog.d(E1, 2, "datalist has contains data" + eVar.f205754b.substring(0, 4));
            return true;
        }
        return true;
    }

    public void K3(List<com.tencent.mobileqq.facetoface.e> list, List<com.tencent.mobileqq.facetoface.e> list2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) list, (Object) list2);
            return;
        }
        for (com.tencent.mobileqq.facetoface.e eVar : list2) {
            if (!list.contains(eVar)) {
                list.add(eVar);
            }
        }
    }

    public void P3(com.tencent.mobileqq.facetoface.e eVar, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, eVar, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(E1, 2, "onADDShowData isPush" + z16 + "currentFriendIndex=" + this.f205601j0 + "isFilterShow=hasFriend=" + z17);
        }
        this.f205613p0.add(eVar);
    }

    public void Q3(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (this.V0) {
            if (this.W0) {
                this.W0 = false;
            }
            this.V0 = false;
            l3(false, this.f205601j0, false);
            return;
        }
        if (i3 == 1 && this.W0) {
            this.f205597h0.sendEmptyMessageDelayed(3, 0L);
        } else if (z16) {
            this.f205597h0.sendEmptyMessageDelayed(8, 0L);
        }
    }

    public void R3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
        } else {
            this.f205597h0.sendEmptyMessageDelayed(8, 0L);
        }
    }

    public void S3(com.tencent.mobileqq.facetoface.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) eVar);
        } else if (this.f205613p0.contains(eVar)) {
            this.f205613p0.remove(eVar);
        }
    }

    public void T3(com.tencent.mobileqq.facetoface.e eVar, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, eVar, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (!z17) {
            this.f205601j0++;
        }
        if (QLog.isColorLevel()) {
            QLog.d(E1, 2, "onInAnimEnd isPush" + z16 + "currentFriendIndex=" + this.f205601j0 + "isFilterShow=hasFriend=" + z17);
        }
        l3(z16, this.f205601j0, false);
        if (this.f205583a0 == 1) {
            V3(eVar);
        }
    }

    public void U3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(F1, 2, "openFace2FaceTroop, from_type=" + this.f205583a0 + ", fromTroopUin=" + this.f205585b0);
        }
        NearFieldTroopHandler nearFieldTroopHandler = (NearFieldTroopHandler) this.app.getBusinessHandler(BusinessHandlerFactory.NEARFIELD_TROOP_HANDLER);
        if (nearFieldTroopHandler != null && this.f205588c1 != null) {
            if (!NetworkUtil.isNetSupport(this)) {
                if (QLog.isColorLevel()) {
                    QLog.d(F1, 2, "openFace2FaceTroop, NetworkUtil.isNetSupport==false");
                }
                QQToast.makeText(this.app.getApplication(), R.string.f171139ci4, 0).show(getTitleBarHeight());
                return;
            }
            ThreadManagerV2.post(new Runnable(nearFieldTroopHandler) { // from class: com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ NearFieldTroopHandler f205635d;

                {
                    this.f205635d = nearFieldTroopHandler;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) Face2FaceAddFriendActivity.this, (Object) nearFieldTroopHandler);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    Face2FaceAddFriendActivity face2FaceAddFriendActivity = Face2FaceAddFriendActivity.this;
                    if (face2FaceAddFriendActivity.f205583a0 == 1) {
                        if (TextUtils.isEmpty(face2FaceAddFriendActivity.f205585b0)) {
                            return;
                        }
                        try {
                            if (!this.f205635d.I2(Long.valueOf(Face2FaceAddFriendActivity.this.f205585b0).longValue(), 1)) {
                                Face2FaceAddFriendActivity.this.f205597h0.sendEmptyMessageDelayed(6, 0L);
                                Face2FaceAddFriendActivity.this.f205621t0 = 2;
                                return;
                            }
                            return;
                        } catch (Exception unused) {
                            return;
                        }
                    }
                    if (!this.f205635d.I2(0L, 1)) {
                        Face2FaceAddFriendActivity.this.f205597h0.sendEmptyMessageDelayed(6, 0L);
                        Face2FaceAddFriendActivity.this.f205621t0 = 2;
                        return;
                    }
                    Face2FaceAddFriendActivity face2FaceAddFriendActivity2 = Face2FaceAddFriendActivity.this;
                    if (!face2FaceAddFriendActivity2.f205588c1.O2(face2FaceAddFriendActivity2.app.getCurrentAccountUin(), false)) {
                        Face2FaceAddFriendActivity face2FaceAddFriendActivity3 = Face2FaceAddFriendActivity.this;
                        face2FaceAddFriendActivity3.f205619s0 = 2;
                        face2FaceAddFriendActivity3.f205597h0.sendEmptyMessageDelayed(6, 0L);
                    }
                }
            }, 8, null, false);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(F1, 2, "openFace2FaceTroop, getBusinessHandler==null");
        }
    }

    public void V3(com.tencent.mobileqq.facetoface.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) eVar);
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 14;
        obtain.obj = eVar;
        this.f205597h0.sendMessageDelayed(obtain, 2000L);
    }

    public void a4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        int size = this.f205605l0.size();
        if (size > 0) {
            TextView textView = this.f205592e1;
            if (textView != null && textView.getVisibility() == 0) {
                this.f205592e1.setVisibility(8);
            }
            View view = this.f205594f1;
            if (view != null && view.getVisibility() != 0) {
                this.f205594f1.setVisibility(0);
            }
            this.f205596g1.setText(String.valueOf(size));
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public void addObserver(BusinessObserver businessObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) businessObserver);
            return;
        }
        QQAppInterface qQAppInterface = this.app;
        if (qQAppInterface != null) {
            qQAppInterface.addObserver(businessObserver);
        }
    }

    public void c4(com.tencent.mobileqq.facetoface.e eVar) {
        v vVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) eVar);
            return;
        }
        if (this.U0 != null && eVar != null && (vVar = this.f205597h0) != null) {
            vVar.removeMessages(14, eVar);
            Face2FaceFriendBubbleView c16 = this.U0.c(eVar.f205754b);
            if (c16 != null) {
                c16.setAnimation(new AlphaAnimation(1.0f, 1.0f));
            }
        }
    }

    public void d3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.f154423k);
        loadAnimation.setAnimationListener(new o());
        this.F0.startAnimation(loadAnimation);
        a4();
    }

    public boolean d4() {
        int indexOf;
        int indexOf2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        for (com.tencent.mobileqq.facetoface.e eVar : this.f205611o0) {
            if (eVar.f205753a == 1 && J3(eVar.f205754b)) {
                for (com.tencent.mobileqq.facetoface.e eVar2 : this.f205607m0) {
                    if (!this.f205611o0.contains(eVar2) && !isTroopMember(eVar2.f205754b) && (indexOf2 = this.f205611o0.indexOf(eVar)) != -1) {
                        this.f205611o0.set(indexOf2, eVar2);
                        return true;
                    }
                }
            } else if (eVar.f205753a == 2 && isTroopMember(eVar.f205754b)) {
                for (com.tencent.mobileqq.facetoface.e eVar3 : this.f205605l0) {
                    if (!this.f205611o0.contains(eVar3) && !J3(eVar3.f205754b) && (indexOf = this.f205611o0.indexOf(eVar)) != -1) {
                        this.f205611o0.set(indexOf, eVar3);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        } else if (i16 == -1 && i3 == 100) {
            this.Q0 = intent.getByteExtra("result", (byte) 0);
            p4();
            this.S0.put(this.J0, Integer.valueOf(this.Q0));
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        View view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        Face2FaceTroopDetailView face2FaceTroopDetailView = this.E0;
        if (face2FaceTroopDetailView != null && face2FaceTroopDetailView.isShowing()) {
            this.E0.j();
            return;
        }
        Face2FaceFriendDetailView face2FaceFriendDetailView = this.K0;
        if (face2FaceFriendDetailView != null && face2FaceFriendDetailView.isShowing()) {
            this.K0.j();
            return;
        }
        if (this.f205598h1 && (view = this.F0) != null && view.getVisibility() == 0) {
            d3();
        } else if (this.f205583a0 == 1 && this.f205587c0) {
            DialogUtil.createCustomDialog(this, 230, getString(R.string.f173206i10), getString(R.string.b2v), R.string.cancel, R.string.f170901b10, new d(), new e()).show();
        } else {
            super.doOnBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        setContentViewNoTitle(R.layout.f167799hy);
        this.f205590d1 = SystemClock.elapsedRealtime();
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("options");
        if (!TextUtils.isEmpty(stringExtra)) {
            try {
                JSONObject jSONObject = new JSONObject(stringExtra);
                this.f205583a0 = jSONObject.optInt("activity_from_type");
                this.f205585b0 = jSONObject.optString("activity_troop_uin");
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        } else {
            this.f205583a0 = intent.getIntExtra("activity_from_type", 0);
            this.f205585b0 = intent.getStringExtra("activity_troop_uin");
        }
        if (QLog.isColorLevel()) {
            QLog.d(E1, 2, "doOnCreate, from_type=" + this.f205583a0 + ", fromTroopUin=" + this.f205585b0);
        }
        this.f205589d0 = (FrameLayout) findViewById(R.id.root);
        this.f205588c1 = (LBSHandler) this.app.getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER);
        M1 = Calendar.getInstance();
        initUI();
        c3();
        this.D0 = (INewFriendService) this.app.getRuntimeService(INewFriendService.class);
        AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this);
        if (AppNetConnInfo.getConnInfo() == -1) {
            QQToast.makeText(this.app.getApplication(), R.string.f171139ci4, 0).show(getTitleBarHeight());
        }
        if (this.D0.getUnreadSystemMessageCount() == 0) {
            this.f205629x0 = true;
        } else {
            this.f205629x0 = false;
        }
        if (I3()) {
            this.f205614p1 = false;
            return true;
        }
        G3();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        super.doOnDestroy();
        removeObserver();
        n4();
        if (QLog.isColorLevel()) {
            QLog.d(E1, 2, "Face2FaceAddFriendActivity doOnDestroy");
        }
        this.f205599i0 = true;
        com.tencent.mobileqq.facetoface.b.f205747c = System.currentTimeMillis();
        j3();
        this.f205597h0.removeCallbacksAndMessages(null);
        this.f205597h0.removeMessages(5);
        this.f205597h0.removeMessages(7);
        this.f205597h0.removeMessages(9);
        this.f205597h0.removeMessages(4);
        this.f205597h0.removeMessages(11);
        LBSHandler lBSHandler = this.f205588c1;
        if (lBSHandler != null) {
            lBSHandler.P2(this.app.getCurrentAccountUin());
        } else if (QLog.isColorLevel()) {
            QLog.d(E1, 2, "doOnDestroy mLbsHandler is null");
        }
        AppNetConnInfo.unregisterNetInfoHandler(this);
        this.U0.b();
        if (this.f205633z0) {
            ReportController.o(null, "CliOper", "", "", "0X80050F2", "0X80050F2", 0, 0, "", "", "", "");
        }
        com.tencent.mobileqq.facetoface.d dVar = this.I0;
        if (dVar != null) {
            dVar.destroy();
        }
        ReportController.o(null, "CliOper", "", "", "0X80050EC", "0X80050EC", 0, 0, String.valueOf(this.B0), String.valueOf(this.C0), "", "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        super.doOnPause();
        if (QLog.isColorLevel()) {
            QLog.i(E1, 2, "doOnPause!");
        }
        this.f205600i1 = false;
        QQAudioUtils.i(this, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(E1, 2, "doOnResume!");
        }
        super.doOnResume();
        SystemBarCompact systemBarComp = SystemBarActivityModule.getSystemBarComp(this);
        if (systemBarComp != null) {
            systemBarComp.setStatusColor(-16777216);
            systemBarComp.setStatusBarColor(-16777216);
        }
        this.f205600i1 = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.doOnStart();
        QQAudioUtils.i(this, true);
        l4();
        h3();
        com.tencent.mobileqq.facetoface.b.f205745a = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d(G1, 2, "face2face doOnStart inface2faceTime=" + y3(com.tencent.mobileqq.facetoface.b.f205745a) + "showBkAnim=" + this.f205614p1);
        }
        if (this.f205614p1) {
            if (com.tencent.mobileqq.facetoface.b.f205745a >= com.tencent.mobileqq.facetoface.b.f205746b) {
                k4(com.tencent.mobileqq.facetoface.b.f205745a, com.tencent.mobileqq.facetoface.b.f205746b);
            } else {
                k4(com.tencent.mobileqq.facetoface.b.f205745a, 0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        super.doOnStop();
        if (QLog.isColorLevel()) {
            QLog.i(E1, 2, "doOnStop!");
        }
        m4();
        this.f205597h0.removeMessages(4);
        com.tencent.mobileqq.facetoface.b.f205746b = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d(G1, 2, "face2face doOnStop outface2faceTime=" + y3(com.tencent.mobileqq.facetoface.b.f205746b));
        }
    }

    public void e3(com.tencent.mobileqq.facetoface.f fVar) {
        Face2FaceFriendBubbleView c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) fVar);
            return;
        }
        com.tencent.mobileqq.facetoface.a aVar = this.U0;
        if (aVar == null || fVar == null || (c16 = aVar.c(fVar.f205754b)) == null) {
            return;
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, ((displayMetrics.widthPixels / 2) - c16.getLeft()) - (c16.getWidth() / 2), 0.0f, ((displayMetrics.heightPixels / 2) - c16.getTop()) - (c16.getHeight() / 2));
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.4f, 1.0f, 0.4f, 1, 0.5f, 1, 0.5f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.2f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.setDuration(1000L);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setFillAfter(true);
        animationSet.setAnimationListener(new q(c16));
        c16.setClickable(false);
        c16.startAnimation(animationSet);
        Message obtain = Message.obtain();
        obtain.what = 15;
        obtain.obj = fVar;
        this.f205597h0.sendMessageDelayed(obtain, 1500L);
    }

    public void f3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.f205598h1 = true;
        if (this.G0 == null) {
            LayoutInflater from = LayoutInflater.from(getApplicationContext());
            View inflate = from.inflate(R.layout.f167954nx, (ViewGroup) null);
            this.F0 = inflate;
            View findViewById = inflate.findViewById(R.id.jnu);
            if (ImmersiveUtils.isSupporImmersive() == 1) {
                findViewById.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
            }
            this.f205589d0.addView(this.F0);
            this.G0 = (XListView) this.F0.findViewById(R.id.jwf);
            this.G0.setEmptyView(this.F0.findViewById(R.id.c0p));
            View inflate2 = from.inflate(R.layout.f167952nv, (ViewGroup) this.G0, false);
            this.H0 = (TextView) inflate2.findViewById(R.id.jwd);
            this.G0.addHeaderView(inflate2);
            TextView textView = (TextView) this.F0.findViewById(R.id.dsg);
            textView.setOnClickListener(this);
            textView.setOnTouchListener(this);
            textView.setPadding(textView.getPaddingLeft(), 0, textView.getPaddingRight(), 0);
            this.I0 = new com.tencent.mobileqq.facetoface.d(this, this.G0);
        } else {
            this.F0.setVisibility(0);
        }
        this.I0.j(this.f205605l0);
        this.H0.setText(String.valueOf(this.I0.getCount()));
        this.F0.startAnimation(AnimationUtils.loadAnimation(this, R.anim.f154424l));
    }

    public void h3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (this.f205583a0 != 1) {
            return;
        }
        this.f205597h0.removeMessages(9);
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f205590d1;
        if (QLog.isColorLevel()) {
            QLog.d("time_tick", 2, "checkTroopShareValidity, durition=" + elapsedRealtime + ", mInitTroopShareTimeStamp=" + this.f205590d1);
        }
        if (elapsedRealtime >= ShortVideoConstants.VIDEO_MAX_DURATION) {
            DialogUtil.createCustomDialog(this, 230, getString(R.string.f173206i10), "\u6b64\u6b21\u5206\u4eab\u5df2\u6ee120\u5206\u949f", R.string.cancel, R.string.f170901b10, new r(), (DialogInterface.OnClickListener) null).show();
        } else {
            this.f205597h0.sendEmptyMessageDelayed(9, 10000L);
        }
    }

    public boolean isTroopMember(String str) {
        TroopInfo troopInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) str)).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        TroopManager troopManager = (TroopManager) this.app.getManager(QQManagerFactory.TROOP_MANAGER);
        if (troopManager != null) {
            troopInfo = troopManager.k(str + "");
        } else {
            troopInfo = null;
        }
        if (troopInfo == null) {
            return false;
        }
        return true;
    }

    public void j3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(F1, 2, "closeFace2faceTroop, from_type=" + this.f205583a0 + ", fromTroopUin=" + this.f205585b0);
        }
        NearFieldTroopHandler nearFieldTroopHandler = (NearFieldTroopHandler) this.app.getBusinessHandler(BusinessHandlerFactory.NEARFIELD_TROOP_HANDLER);
        if (nearFieldTroopHandler == null) {
            if (QLog.isColorLevel()) {
                QLog.d(F1, 2, "closeFace2faceTroop, getBusinessHandler==null");
            }
        } else {
            if (this.f205583a0 == 1) {
                if (TextUtils.isEmpty(this.f205585b0)) {
                    return;
                }
                try {
                    nearFieldTroopHandler.D2(Long.valueOf(this.f205585b0).longValue(), 1);
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
            nearFieldTroopHandler.D2(0L, 1);
        }
    }

    public void k4(long j3, long j16) {
        char c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        int y36 = y3(j3);
        int i3 = (int) (((j3 - j16) / 1000) / 60);
        if (y36 >= 5 && y36 < 11) {
            c16 = 4;
        } else if (y36 >= 11 && y36 < 17) {
            c16 = 1;
        } else if (y36 >= 17 && y36 < 23) {
            c16 = 2;
        } else {
            c16 = 3;
        }
        if (i3 >= 6) {
            this.f205604k1.setVisibility(0);
            if (c16 != 1) {
                if (c16 != 2) {
                    if (c16 != 3) {
                        if (c16 == 4) {
                            this.f205604k1.setBackgroundResource(R.drawable.clu);
                            this.f205606l1.setBackgroundResource(R.drawable.clw);
                        }
                    } else {
                        this.f205604k1.setBackgroundResource(R.drawable.clx);
                        this.f205606l1.setBackgroundResource(R.drawable.clu);
                    }
                } else {
                    this.f205604k1.setBackgroundResource(R.drawable.clv);
                    this.f205606l1.setBackgroundResource(R.drawable.clx);
                }
            } else {
                this.f205604k1.setBackgroundResource(R.drawable.clw);
                this.f205606l1.setBackgroundResource(R.drawable.clv);
            }
            this.f205606l1.startAnimation(this.f205608m1);
            this.f205608m1.setAnimationListener(new m());
        } else {
            this.f205604k1.setVisibility(4);
            if (c16 != 1) {
                if (c16 != 2) {
                    if (c16 != 3) {
                        if (c16 == 4) {
                            this.f205606l1.setBackgroundResource(R.drawable.clw);
                        }
                    } else {
                        this.f205606l1.setBackgroundResource(R.drawable.clu);
                    }
                } else {
                    this.f205606l1.setBackgroundResource(R.drawable.clx);
                }
            } else {
                this.f205606l1.setBackgroundResource(R.drawable.clv);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(G1, 2, "startBkAnim \u672c\u6b21\u8fdb\u5165\u65f6\u95f4\u70b9\uff1a" + y36 + "\u548c\u4e0a\u4e00\u6b21\u65f6\u95f4\u5dee" + i3 + "\u5c0f\u65f6");
        }
    }

    public void l4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            this.f205597h0.a(100L);
        }
    }

    public void m4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("snow", 2, "stopSnow");
        }
        this.f205597h0.removeMessages(0);
    }

    public void n3(com.tencent.mobileqq.facetoface.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) cVar);
            return;
        }
        if (cVar == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(E1, 2, "deleteGroupData mhasShowList = " + this.f205613p0.size());
        }
        if (this.f205613p0.contains(cVar)) {
            this.U0.k(cVar, true);
            this.U0.a(cVar.f205754b + "_" + cVar.f205749d);
            this.f205611o0.remove(cVar);
            this.f205607m0.remove(cVar);
            int i3 = this.f205601j0;
            if (i3 > 0) {
                this.f205601j0 = i3 - 1;
            }
            p3();
            return;
        }
        this.f205607m0.remove(cVar);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (!this.K0.isShowing() && id5 != R.id.f165130c25) {
                if (id5 == R.id.iyl) {
                    doOnBackPressed();
                } else if (id5 != R.id.iym && id5 != R.id.b6n && id5 != R.id.b6q && id5 != R.id.b6p) {
                    if (id5 == R.id.dsg) {
                        if (this.f205583a0 == 1) {
                            d3();
                        }
                    } else {
                        Face2FaceFriendBubbleView face2FaceFriendBubbleView = (Face2FaceFriendBubbleView) view;
                        if (face2FaceFriendBubbleView.l() == 1) {
                            String k3 = face2FaceFriendBubbleView.k();
                            if (TextUtils.isEmpty(k3)) {
                                if (QLog.isColorLevel()) {
                                    QLog.d(E1, 2, "getBubbleview uin is null");
                                }
                            } else {
                                this.f205602j1 = k3;
                                if (QLog.isColorLevel() && !TextUtils.isEmpty(this.f205602j1)) {
                                    QLog.d(E1, 2, "showdetail \u8fdb\u5165\u8be6\u60c5\u9875mShowDetailUin=" + this.f205602j1.substring(0, 4));
                                }
                                Bitmap faceBitmap = this.app.getFaceBitmap(k3, (byte) 3, true);
                                if (faceBitmap == null) {
                                    faceBitmap = BaseImageUtil.getDefaultFaceBitmap();
                                }
                                Bitmap bitmap = faceBitmap;
                                com.tencent.mobileqq.facetoface.g gVar = (com.tencent.mobileqq.facetoface.g) face2FaceFriendBubbleView.g();
                                if (gVar == null) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d(E1, 2, "getBubbleview nearbyUser is null");
                                    }
                                } else {
                                    if (gVar.f205761d.equals("")) {
                                        str = gVar.f205762e;
                                    } else {
                                        str = gVar.f205761d;
                                    }
                                    h4(face2FaceFriendBubbleView.j(), k3, face2FaceFriendBubbleView, str, bitmap);
                                    ReportController.o(null, "CliOper", "", "", "0X80050ED", "0X80050ED", 0, 0, "", "", "", "");
                                    if (this.f205583a0 == 1) {
                                        ReportController.o(null, "P_CliOper", "Grp_set", "", "Radar_grp_admin", "Clk_detail", 0, 0, this.f205585b0, "", "", "");
                                    }
                                }
                            }
                        } else if (face2FaceFriendBubbleView.l() == 2) {
                            com.tencent.mobileqq.facetoface.e g16 = face2FaceFriendBubbleView.g();
                            if (g16 != null) {
                                String str2 = g16.f205754b;
                                this.P0 = str2;
                                this.f205602j1 = str2;
                                this.E0.setBindData(g16, new f(g16));
                                this.E0.k(this.f205589d0, face2FaceFriendBubbleView);
                                if (this.f205583a0 == 1) {
                                    c4(g16);
                                }
                            }
                            ReportController.o(null, "CliOper", "", "", "0X80050EE", "0X80050EE", 0, 0, "", "", "", "");
                        }
                    }
                } else if (this.f205583a0 == 1) {
                    f3();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2None() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this);
        } else {
            this.f205597h0.sendEmptyMessage(18);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetMobile2Wifi(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Mobile(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, (Object) str);
        } else {
            U3();
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetNone2Wifi(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, (Object) str);
        } else {
            U3();
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2Mobile(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
    public void onNetWifi2None() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(E1, 2, "onNetWifi2None");
        }
        this.f205597h0.sendEmptyMessage(18);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
        int id5 = view.getId();
        if (id5 == R.id.iym || id5 == R.id.iyl) {
            TextView textView = (TextView) view;
            if (motionEvent.getAction() == 0) {
                textView.setTextColor(getResources().getColor(R.color.acw));
                return false;
            }
            if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                textView.setTextColor(getResources().getColor(R.color.f158017al3));
                return false;
            }
            return false;
        }
        return false;
    }

    protected int x3() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Integer) iPatchRedirector.redirect((short) 35, (Object) this)).intValue();
        }
        if (this.f205613p0.size() < this.f205611o0.size()) {
            i3 = ((this.f205611o0.size() - this.f205613p0.size()) * 500) + 2500;
        } else {
            i3 = 2000;
        }
        if (QLog.isColorLevel()) {
            QLog.d(E1, 2, "getReplaceDelay=" + i3);
        }
        return i3;
    }

    public int y3(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Integer) iPatchRedirector.redirect((short) 37, (Object) this, j3)).intValue();
        }
        M1.setTimeInMillis(j3);
        return M1.get(11);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity
    public void removeObserver(BusinessObserver businessObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) businessObserver);
            return;
        }
        QQAppInterface qQAppInterface = this.app;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(businessObserver);
        }
    }
}
