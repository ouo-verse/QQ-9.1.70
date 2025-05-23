package com.tencent.mobileqq.activity;

import SecurityAccountServer.RespondQueryQQBindingStat;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.StatFs;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.ecommerce.base.runtime.api.IECScreenReceiver;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.BreathAnimationLayout;
import com.tencent.mobileqq.activity.aio.o;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.activity.recent.data.RecentItemNoticeData;
import com.tencent.mobileqq.activity.recent.data.RecentItemPullActivePush;
import com.tencent.mobileqq.activity.recent.data.RecentItemVoteData;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxABTestApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gesturelock.BaseGesturePWDUtil;
import com.tencent.mobileqq.guild.message.api.IGuildMsgProxyUtilsApi;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.managers.PushNoticeManager;
import com.tencent.mobileqq.matchchat.MatchChatMsgUtil;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.ptt.LSRecordPanel;
import com.tencent.mobileqq.ptt.TouchProxyRelativeLayout;
import com.tencent.mobileqq.ptt.api.IPttInfoCollector;
import com.tencent.mobileqq.ptt.temp.api.IQQRecorderTempApi;
import com.tencent.mobileqq.pttlogic.api.IPTTPreDownloader;
import com.tencent.mobileqq.qcall.QCallCardInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.quibadge.QUIBadgeDragLayout;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.k;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.utils.dd;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.GroupMsgMask;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.util.VersionUtils;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.AdapterView;
import com.tencent.widget.MaxHeightRelativelayout;
import com.tencent.widget.XBaseAdapter;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XListView;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.CopyOnWriteArraySet;
import mqq.app.AppActivity;
import mqq.app.Constants;
import mqq.app.Foreground;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes9.dex */
public class QQLSActivity extends AppActivity implements View.OnClickListener, Observer, dd.c, DragFrameLayout.b, LSRecordPanel.f, TextWatcher, MediaPlayerManager.b, MediaPlayerManager.c, com.tencent.mobileqq.activity.aio.r, Handler.Callback {
    static IPatchRedirector $redirector_;
    private static final boolean I1;
    public static boolean J1;
    private static CopyOnWriteArraySet<String> K1;
    private long A0;
    public Comparator A1;
    private long B0;
    private com.tencent.mobileqq.widget.bq B1;
    private long C0;
    private com.tencent.mobileqq.app.bs C1;
    private boolean D0;
    private nb2.a D1;
    private Animation E0;
    protected com.tencent.mobileqq.app.bs E1;
    private final int F0;
    View.OnTouchListener F1;
    private final int G0;
    private Handler G1;
    private final int H0;
    private int H1;
    private final int I0;
    private final int J0;
    private final int K0;
    private final int L0;
    private final int M0;
    private final int N0;
    private final int O0;
    private final int P0;
    private final int Q0;
    private final int R0;
    private final int S0;
    private final int T0;
    private final int U0;
    private final int V0;
    private final int W0;
    private final int X0;
    public final int Y0;
    public final int Z0;

    /* renamed from: a0, reason: collision with root package name */
    private TouchProxyRelativeLayout f176750a0;

    /* renamed from: a1, reason: collision with root package name */
    public final int f176751a1;

    /* renamed from: b0, reason: collision with root package name */
    private RelativeLayout f176752b0;

    /* renamed from: b1, reason: collision with root package name */
    public final int f176753b1;

    /* renamed from: c0, reason: collision with root package name */
    private Button f176754c0;

    /* renamed from: c1, reason: collision with root package name */
    public final int f176755c1;

    /* renamed from: d0, reason: collision with root package name */
    private LSRecordPanel f176756d0;

    /* renamed from: d1, reason: collision with root package name */
    public final int f176757d1;

    /* renamed from: e0, reason: collision with root package name */
    private View f176758e0;

    /* renamed from: e1, reason: collision with root package name */
    public final int f176759e1;

    /* renamed from: f0, reason: collision with root package name */
    private TextView f176760f0;

    /* renamed from: f1, reason: collision with root package name */
    com.tencent.mobileqq.utils.dd f176761f1;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f176762g0;

    /* renamed from: g1, reason: collision with root package name */
    private boolean f176763g1;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f176764h0;

    /* renamed from: h1, reason: collision with root package name */
    PowerManager.WakeLock f176765h1;

    /* renamed from: i0, reason: collision with root package name */
    private TextView f176766i0;

    /* renamed from: i1, reason: collision with root package name */
    private boolean f176767i1;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f176768j0;

    /* renamed from: j1, reason: collision with root package name */
    private boolean f176769j1;

    /* renamed from: k0, reason: collision with root package name */
    private int f176770k0;

    /* renamed from: k1, reason: collision with root package name */
    INewFriendService f176771k1;

    /* renamed from: l0, reason: collision with root package name */
    private XEditTextEx f176772l0;

    /* renamed from: l1, reason: collision with root package name */
    public ISubAccountService f176773l1;

    /* renamed from: m0, reason: collision with root package name */
    private MaxHeightRelativelayout f176774m0;

    /* renamed from: m1, reason: collision with root package name */
    com.tencent.mobileqq.managers.i f176775m1;

    /* renamed from: n0, reason: collision with root package name */
    private XListView f176776n0;

    /* renamed from: n1, reason: collision with root package name */
    DragFrameLayout f176777n1;

    /* renamed from: o0, reason: collision with root package name */
    private k f176778o0;

    /* renamed from: o1, reason: collision with root package name */
    private boolean f176779o1;

    /* renamed from: p0, reason: collision with root package name */
    private RelativeLayout f176780p0;

    /* renamed from: p1, reason: collision with root package name */
    com.tencent.mobileqq.qcall.f f176781p1;

    /* renamed from: q0, reason: collision with root package name */
    private n f176782q0;

    /* renamed from: q1, reason: collision with root package name */
    ArrayList<MessageRecord> f176783q1;

    /* renamed from: r0, reason: collision with root package name */
    private XListView f176784r0;

    /* renamed from: r1, reason: collision with root package name */
    float f176785r1;

    /* renamed from: s0, reason: collision with root package name */
    private RecentBaseData f176786s0;

    /* renamed from: s1, reason: collision with root package name */
    m f176787s1;

    /* renamed from: t0, reason: collision with root package name */
    private TextView f176788t0;

    /* renamed from: t1, reason: collision with root package name */
    KeyguardManager f176789t1;

    /* renamed from: u0, reason: collision with root package name */
    private TextView f176790u0;

    /* renamed from: u1, reason: collision with root package name */
    public boolean f176791u1;

    /* renamed from: v0, reason: collision with root package name */
    private QQAppInterface f176792v0;

    /* renamed from: v1, reason: collision with root package name */
    protected final MqqHandler f176793v1;

    /* renamed from: w0, reason: collision with root package name */
    IPhoneContactService f176794w0;

    /* renamed from: w1, reason: collision with root package name */
    private long f176795w1;

    /* renamed from: x0, reason: collision with root package name */
    private final int f176796x0;

    /* renamed from: x1, reason: collision with root package name */
    private boolean f176797x1;

    /* renamed from: y0, reason: collision with root package name */
    private MotionEvent f176798y0;

    /* renamed from: y1, reason: collision with root package name */
    public WeakReferenceHandler f176799y1;

    /* renamed from: z0, reason: collision with root package name */
    private MotionEvent f176800z0;

    /* renamed from: z1, reason: collision with root package name */
    public Comparator f176801z1;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class SyncTroopSummaryTask implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        WeakReference<AppInterface> f176806d;

        /* renamed from: e, reason: collision with root package name */
        WeakReferenceHandler f176807e;

        /* renamed from: f, reason: collision with root package name */
        String f176808f;

        /* renamed from: h, reason: collision with root package name */
        String f176809h;

        public SyncTroopSummaryTask(AppInterface appInterface, WeakReferenceHandler weakReferenceHandler, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, appInterface, weakReferenceHandler, str, str2);
                return;
            }
            this.f176806d = new WeakReference<>(appInterface);
            this.f176807e = weakReferenceHandler;
            this.f176808f = str;
            this.f176809h = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            AppInterface appInterface = this.f176806d.get();
            String concat = this.f176809h.concat(this.f176808f);
            if (appInterface != null && this.f176807e != null && !QQLSActivity.K1.contains(concat)) {
                QQLSActivity.K1.add(concat);
                this.f176807e.sendEmptyMessage(17);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a extends com.tencent.mobileqq.app.bs {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLSActivity.this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.app.bs
        public void onPushReadedNotify(boolean z16, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), obj);
                return;
            }
            super.onPushReadedNotify(z16, obj);
            if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, "PC has read onPushReadedNotify finish" + Thread.currentThread().getId());
            }
            QQLSActivity.this.F3();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class b implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLSActivity.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            if (motionEvent.getAction() == 0) {
                if (QQLSActivity.this.f176800z0 != null && QQLSActivity.this.f176798y0 != null) {
                    QQLSActivity qQLSActivity = QQLSActivity.this;
                    if (qQLSActivity.b4(qQLSActivity.f176798y0, QQLSActivity.this.f176800z0, motionEvent)) {
                        if (QLog.isColorLevel()) {
                            QLog.d("QQLSActivity", 2, "singlelist  click doble");
                        }
                        if (QQLSActivity.this.f176786s0 != null) {
                            QQLSActivity qQLSActivity2 = QQLSActivity.this;
                            qQLSActivity2.P3(qQLSActivity2.f176786s0);
                            QQLSActivity.this.D0 = true;
                        }
                        QQLSActivity.this.f176798y0 = MotionEvent.obtain(motionEvent);
                        return false;
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.e("QQLSActivity", 2, "singlelist  click once");
                }
                if (QQLSActivity.this.c4()) {
                    QQLSActivity.this.f176790u0.setText(R.string.fld);
                } else {
                    QQLSActivity.this.f176790u0.setText(R.string.flc);
                }
                QQLSActivity.this.G1.sendMessageDelayed(QQLSActivity.this.G1.obtainMessage(5), 500L);
                QQLSActivity.this.f176798y0 = MotionEvent.obtain(motionEvent);
                return false;
            }
            if (motionEvent.getAction() == 1) {
                QQLSActivity.this.f176800z0 = MotionEvent.obtain(motionEvent);
                return false;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class c extends Handler {
        static IPatchRedirector $redirector_;

        c(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLSActivity.this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i3 = message.what;
            if (i3 != 200) {
                switch (i3) {
                    case 1:
                        QQLSActivity.this.send();
                        if (QLog.isColorLevel()) {
                            QLog.d("QQLSActivity", 2, "message send finish");
                        }
                        QQLSActivity.this.F3();
                        return;
                    case 2:
                        if (QLog.isColorLevel()) {
                            QLog.d("QQLSActivity", 2, "message finish activity finish");
                        }
                        QQLSActivity.this.finish();
                        return;
                    case 3:
                        QQLSActivity.this.f176790u0.setVisibility(4);
                        return;
                    case 4:
                        QQLSActivity.this.f176788t0.setVisibility(4);
                        return;
                    case 5:
                        if (!QQLSActivity.this.D0) {
                            if (hasMessages(5)) {
                                removeMessages(5);
                            }
                            QQLSActivity.this.I3();
                            if (QQLSActivity.this.f176772l0 != null) {
                                ((InputMethodManager) QQLSActivity.this.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(QQLSActivity.this.f176772l0.getWindowToken(), 0);
                            }
                            QQLSActivity.this.f176790u0.setVisibility(0);
                            Message obtainMessage = obtainMessage(3);
                            if (hasMessages(3)) {
                                removeMessages(3);
                            }
                            sendMessageDelayed(obtainMessage, 1200L);
                            return;
                        }
                        return;
                    case 6:
                        if (!QQLSActivity.this.D0) {
                            if (hasMessages(6)) {
                                removeMessages(6);
                            }
                            QQLSActivity.this.I3();
                            if (QQLSActivity.this.f176772l0 != null) {
                                ((InputMethodManager) QQLSActivity.this.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(QQLSActivity.this.f176772l0.getWindowToken(), 0);
                            }
                            QQLSActivity.this.f176788t0.setVisibility(0);
                            Message obtainMessage2 = obtainMessage(4);
                            if (hasMessages(4)) {
                                removeMessages(4);
                            }
                            sendMessageDelayed(obtainMessage2, 1200L);
                            return;
                        }
                        return;
                    case 7:
                        if (!QQLSActivity.this.f176769j1 && QQLSActivity.this.k4()) {
                            if (QLog.isColorLevel()) {
                                QLog.d("QQLSActivity", 2, "sensor don't callback 1000ms later");
                            }
                            QQLSActivity.this.G3();
                            return;
                        }
                        return;
                    case 8:
                        QQLSActivity.this.u4();
                        return;
                    case 9:
                        if (!QQLSActivity.this.c4()) {
                            ReportController.o(QQLSActivity.this.f176792v0, "CliOper", "", "", "0X800444B", "0X800444B", 0, 0, "", "", "", "");
                            QQLSActivity.this.startActivity(new Intent(QQLSActivity.this, (Class<?>) QQLSUnlockActivity.class));
                            return;
                        }
                        return;
                    case 10:
                        Intent intent = new Intent(QQLSActivity.this, (Class<?>) QQLSActivity.class);
                        intent.addFlags(131072);
                        QQLSActivity.this.startActivity(intent);
                        return;
                    case 11:
                        boolean isKeyguardLock = QQLSActivity.this.isKeyguardLock();
                        if (QLog.isColorLevel()) {
                            QLog.d("QQLSActivity", 2, "LS MSG_CHECKISLOCK" + isKeyguardLock);
                        }
                        if (!isKeyguardLock) {
                            QQLSActivity.this.finish();
                            return;
                        }
                        return;
                    case 12:
                        if (QLog.isColorLevel()) {
                            QLog.d("QQLSActivity", 2, "check sensor HasCallBack ====" + QQLSActivity.this.f176769j1);
                        }
                        if (QQLSActivity.this.f176769j1) {
                            QQLSActivity.this.y4();
                            return;
                        } else {
                            if (QQLSActivity.this.k4()) {
                                QQLSActivity.this.G3();
                                return;
                            }
                            return;
                        }
                    case 13:
                        QQLSActivity.this.x4();
                        return;
                    case 14:
                        QQLSActivity.this.J3(false);
                        return;
                    case 15:
                        QQLSActivity.this.K3();
                        return;
                    case 16:
                        if (QLog.isColorLevel()) {
                            QLog.d("QQLSActivity", 2, "message finish activity finish, enter aio");
                        }
                        QQLSActivity.this.finish();
                        return;
                    default:
                        return;
                }
            }
            QQLSActivity qQLSActivity = QQLSActivity.this;
            qQLSActivity.f176775m1.i(qQLSActivity.f176792v0, (String) message.obj, 1008, false, -1, false);
            QQLSActivity.this.updateUI();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements AdapterView.OnItemClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLSActivity.this);
            }
        }

        /* JADX WARN: Type inference failed for: r8v1, types: [android.widget.Adapter] */
        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
                return;
            }
            RecentBaseData recentBaseData = (RecentBaseData) QQLSActivity.this.f176778o0.getItem(i3);
            long itemId = adapterView.getAdapter().getItemId(i3);
            if (itemId == QQLSActivity.this.A0 && Math.abs(QQLSActivity.this.B0 - System.currentTimeMillis()) < 300) {
                if (QLog.isColorLevel()) {
                    QLog.e("QQLSActivity", 2, "mRecentList is double click");
                }
                QQLSActivity.this.A0 = -1L;
                QQLSActivity.this.B0 = 0L;
                QQLSActivity.this.P3(recentBaseData);
                QQLSActivity.this.D0 = true;
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e("QQLSActivity", 2, "mRecentList  click once");
            }
            QQLSActivity.this.A0 = itemId;
            QQLSActivity.this.B0 = System.currentTimeMillis();
            if (QQLSActivity.this.c4()) {
                QQLSActivity.this.f176788t0.setText(R.string.fld);
            } else {
                QQLSActivity.this.f176788t0.setText(R.string.flc);
            }
            QQLSActivity.this.G1.sendMessageDelayed(QQLSActivity.this.G1.obtainMessage(6), 500L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class e implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLSActivity.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            QQLSActivity.this.f176772l0.setCursorVisible(true);
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class f implements Comparator<ChatMessage> {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLSActivity.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ChatMessage chatMessage, ChatMessage chatMessage2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) chatMessage, (Object) chatMessage2)).intValue();
            }
            long j3 = chatMessage.shmsgseq;
            long j16 = chatMessage2.shmsgseq;
            if (j3 == j16) {
                return 0;
            }
            if (j3 > j16) {
                return 1;
            }
            return -1;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class g implements Comparator<ChatMessage> {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLSActivity.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ChatMessage chatMessage, ChatMessage chatMessage2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) chatMessage, (Object) chatMessage2)).intValue();
            }
            long j3 = chatMessage.time;
            long j16 = chatMessage2.time;
            if (j3 == j16) {
                return 0;
            }
            if (j3 > j16) {
                return 1;
            }
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class h implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MessageForPtt f176817d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ActionSheet f176818e;

        h(MessageForPtt messageForPtt, ActionSheet actionSheet) {
            this.f176817d = messageForPtt;
            this.f176818e = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, QQLSActivity.this, messageForPtt, actionSheet);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            ChatActivityFacade.L(QQLSActivity.this.f176792v0, this.f176817d);
            MessageRecord H = ChatActivityFacade.H(QQLSActivity.this.f176792v0, new SessionInfo(), this.f176817d);
            if (H != null) {
                try {
                    ((MessageForPtt) H).c2cViaOffline = true;
                    Bundle bundle = new Bundle();
                    bundle.putInt("DiyTextId", H.vipBubbleDiyTextId);
                    QQAppInterface qQAppInterface = QQLSActivity.this.f176792v0;
                    MessageForPtt messageForPtt = this.f176817d;
                    int i16 = messageForPtt.istroop;
                    String str = messageForPtt.frienduin;
                    String localFilePath = messageForPtt.getLocalFilePath();
                    long j3 = H.uniseq;
                    MessageForPtt messageForPtt2 = this.f176817d;
                    ChatActivityFacade.b1(qQAppInterface, i16, str, localFilePath, j3, true, messageForPtt2.voiceLength * 1000, messageForPtt2.voiceType, true, messageForPtt2.voiceChangeFlag, 0, true, H.vipSubBubbleId, bundle);
                } catch (RuntimeException e16) {
                    e16.printStackTrace();
                    QQToast.makeText(QQLSActivity.this, e16.getMessage(), 0).show();
                }
            }
            QQLSActivity.this.notifyDataSetChanged();
            this.f176818e.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class i extends com.tencent.mobileqq.app.bs {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLSActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.bs
        public void onMsgRevokeNotice(boolean z16, List<MessageRecord> list, boolean z17) {
            MessageForPtt messageForPtt;
            ChatMessage s16;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), list, Boolean.valueOf(z17));
                return;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("MsgRevoke", 4, "onMsgRevokeNotice isSuccess=" + z16);
            }
            QQLSActivity.this.f176793v1.removeMessages(267387140);
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() > 0) {
                Iterator<MessageRecord> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add((ChatMessage) it.next());
                }
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("MsgRevoke", 4, "onMsgRevokeNotice chatlist=" + arrayList.size());
            }
            if (z16 && !arrayList.isEmpty() && (((ChatMessage) arrayList.get(0)) instanceof MessageForPtt) && ((s16 = MediaPlayerManager.q(QQLSActivity.this.f176792v0).s()) == (messageForPtt = (MessageForPtt) arrayList.get(0)) || ((s16 instanceof MessageForPtt) && (str = s16.frienduin) != null && str.equals(messageForPtt.frienduin) && s16.uniseq == messageForPtt.uniseq))) {
                MediaPlayerManager.q(QQLSActivity.this.f176792v0).D(true);
            }
            super.onMsgRevokeNotice(z16, list, z17);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class j implements nb2.a {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLSActivity.this);
            }
        }

        @Override // nb2.a
        public void onContactCountChanged() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // nb2.a
        public void onMayKnowStatesChanged() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            }
        }

        @Override // nb2.a
        public void onUnreadChanged(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
            } else if (i3 == 0) {
                QQLSActivity.this.f176775m1.d().size();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class k extends XBaseAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private ArrayList<RecentBaseData> f176822d;

        /* renamed from: e, reason: collision with root package name */
        CharSequence f176823e;

        public k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLSActivity.this);
            } else {
                this.f176822d = new ArrayList<>();
                this.f176823e = "";
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private View b(int i3, View view, ViewGroup viewGroup) {
            q qVar;
            if (view != null) {
                Object tag = view.getTag();
                if (tag instanceof q) {
                    qVar = (q) tag;
                    RecentBaseData recentBaseData = this.f176822d.get(i3);
                    if (qVar == null) {
                        view = QQLSActivity.this.getLayoutInflater().inflate(R.layout.awf, (ViewGroup) null);
                        qVar = new q();
                        qVar.f176841a = (TextView) view.findViewById(R.id.grh);
                        DragTextView dragTextView = (DragTextView) view.findViewById(R.id.grn);
                        qVar.f176842b = dragTextView;
                        dragTextView.setOnModeChangeListener(QQLSActivity.this.f176777n1);
                        qVar.f176842b.setDragViewType(0);
                        view.setTag(qVar);
                    }
                    qVar.f176842b.setTag(Integer.valueOf(i3));
                    qVar.f176841a.setText(recentBaseData.mTitleName);
                    qVar.f176842b.setVisibility(0);
                    com.tencent.widget.d.b(qVar.f176842b, 3, 1, 0);
                    return view;
                }
            }
            qVar = null;
            RecentBaseData recentBaseData2 = this.f176822d.get(i3);
            if (qVar == null) {
            }
            qVar.f176842b.setTag(Integer.valueOf(i3));
            qVar.f176841a.setText(recentBaseData2.mTitleName);
            qVar.f176842b.setVisibility(0);
            com.tencent.widget.d.b(qVar.f176842b, 3, 1, 0);
            return view;
        }

        public View c(int i3, View view, ViewGroup viewGroup) {
            View inflate;
            int R;
            int X3;
            int i16;
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (View) iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), view, viewGroup);
            }
            RecentBaseData recentBaseData = this.f176822d.get(i3);
            com.tencent.imcore.message.Message lastMessage = QQLSActivity.this.f176792v0.getMessageFacade().getLastMessage(recentBaseData.getRecentUserUin(), recentBaseData.getRecentUserType());
            MessageRecord P = QQLSActivity.this.f176792v0.getMessageFacade().P(recentBaseData.getRecentUserUin(), recentBaseData.getRecentUserType(), lastMessage.uniseq);
            if (recentBaseData.getRecentUserType() == 1032) {
                P = ConfessMsgUtil.n(QQLSActivity.this.f176792v0, lastMessage);
            }
            if (view == null || !(view.getTag() instanceof l)) {
                inflate = QQLSActivity.this.getLayoutInflater().inflate(R.layout.awg, (ViewGroup) null);
                l lVar = new l();
                lVar.f176825j = (TextView) inflate.findViewById(R.id.grh);
                lVar.f176826k = (TextView) inflate.findViewById(R.id.grm);
                lVar.f176827l = (DragTextView) inflate.findViewById(R.id.grn);
                inflate.setTag(lVar);
                lVar.f176827l.setOnModeChangeListener(QQLSActivity.this.f176777n1);
                lVar.f176827l.setDragViewType(0);
                lVar.f176834h = (TextView) inflate.findViewById(R.id.qq_aio_ptt_time_tv);
                lVar.f176833g = (ImageView) inflate.findViewById(R.id.goj);
                lVar.f176835i = (BreathAnimationLayout) inflate.findViewById(R.id.gok);
            } else {
                inflate = view;
            }
            l lVar2 = (l) inflate.getTag();
            lVar2.f176827l.setTag(Integer.valueOf(i3));
            String recentUserUin = recentBaseData.getRecentUserUin();
            String str = AppConstants.LOCK_SCREEN_LBS_HELLO_UIN;
            if (recentUserUin.equals(str) || recentBaseData.getRecentUserUin().equals(AppConstants.LOCK_SCREEN_DATE_UIN)) {
                X3 = 0;
                R = 0;
            } else {
                R = QQLSActivity.this.f176792v0.getConversationFacade().R(recentBaseData.getRecentUserUin(), recentBaseData.getRecentUserType());
                X3 = QQLSActivity.this.X3(recentBaseData.getRecentUserUin(), recentBaseData.getRecentUserType());
            }
            CharSequence charSequence = "";
            if (recentBaseData.getRecentUserType() == 0 || recentBaseData.getRecentUserType() == 3000 || recentBaseData.getRecentUserType() == 8) {
                if (X3 > 0) {
                    List<MessageRecord> R3 = QQLSActivity.this.R3(recentBaseData.getRecentUserUin(), recentBaseData.getRecentUserType());
                    if (R3 != null && R3.size() > 0) {
                        if (QLog.isColorLevel()) {
                            QLog.d("QQLSActivity", 2, "recentList misscallMsg size " + R3.size());
                        }
                        com.tencent.imcore.message.Message lastMessage2 = QQLSActivity.this.f176792v0.getMessageFacade().getLastMessage(recentBaseData.getRecentUserUin(), recentBaseData.getRecentUserType());
                        if (Long.valueOf(recentBaseData.getLastMsgTime()).longValue() >= Long.valueOf(R3.get(R3.size() - 1).time).longValue() && (i16 = lastMessage2.msgtype) != -2016 && i16 != -2009 && i16 != -2026) {
                            this.f176823e = recentBaseData.mLastMsg;
                        } else {
                            this.f176823e = R3.get(R3.size() - 1).f203106msg;
                        }
                    } else {
                        this.f176823e = recentBaseData.mLastMsg;
                        if (QLog.isColorLevel()) {
                            QLog.d("QQLSActivity", 2, "recentList misscallMsg size = 0");
                        }
                    }
                } else {
                    this.f176823e = recentBaseData.mLastMsg;
                }
            } else if (recentBaseData.getRecentUserType() != 1001 && recentBaseData.getRecentUserType() != 1010 && recentBaseData.getRecentUserType() != 10002) {
                this.f176823e = recentBaseData.mLastMsg;
            } else if (recentBaseData.getRecentUserUin().equals(AppConstants.LOCK_SCREEN_DATE_UIN)) {
                recentBaseData.mTitleName = BaseApplicationImpl.getApplication().getString(R.string.air);
                this.f176823e = BaseApplicationImpl.getApplication().getString(R.string.aiq);
                String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.OneyWayDateMsgNotifyCfg.name());
                if (featureValue.length() > 0) {
                    String[] split = featureValue.split("\\|");
                    if (split.length >= 6) {
                        recentBaseData.mTitleName = split[4];
                        this.f176823e = split[5];
                    }
                }
            } else if (!recentBaseData.getRecentUserUin().equals(str)) {
                com.tencent.imcore.message.Message lastMessage3 = QQLSActivity.this.f176792v0.getMessageFacade().getLastMessage(recentBaseData.getRecentUserUin(), recentBaseData.getRecentUserType());
                String j3 = com.tencent.mobileqq.utils.ac.j(QQLSActivity.this.f176792v0, lastMessage3.senderuin);
                if (j3 == null) {
                    j3 = "";
                }
                this.f176823e = j3 + MsgSummary.STR_COLON + QQLSActivity.this.f176792v0.getMessageFacade().T(QQLSActivity.this, lastMessage3, false);
            } else {
                recentBaseData.mTitleName = BaseApplicationImpl.getApplication().getString(R.string.c0s);
                this.f176823e = BaseApplicationImpl.getApplication().getString(R.string.c0r);
                String featureValue2 = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.OneyWayLBSFriendMsgNotifyCfg.name());
                if (featureValue2.length() > 0) {
                    String[] split2 = featureValue2.split("\\|");
                    if (split2.length >= 6) {
                        recentBaseData.mTitleName = split2[4];
                        this.f176823e = split2[5];
                    }
                }
            }
            lVar2.f176825j.setText(recentBaseData.mTitleName);
            lVar2.f176826k.setText(recentBaseData.mShowTime);
            if (recentBaseData.getRecentUserType() == 4000) {
                R = QQLSActivity.this.f176771k1.getAllUnreadMessageCount();
            }
            int i17 = R + X3;
            if (i17 == 0) {
                lVar2.f176827l.setVisibility(4);
            } else {
                lVar2.f176827l.setVisibility(0);
                com.tencent.widget.d.b(lVar2.f176827l, 3, i17, 0);
            }
            if (recentBaseData.getRecentUserUin().equals(AppConstants.LOCK_SCREEN_DATE_UIN) || recentBaseData.getRecentUserUin().equals(str)) {
                lVar2.f176827l.setVisibility(8);
            }
            BaseChatItemLayout baseChatItemLayout = new BaseChatItemLayout(QQLSActivity.this);
            baseChatItemLayout.setId(R.id.a6b);
            baseChatItemLayout.setFocusableInTouchMode(true);
            baseChatItemLayout.setPadding(BaseChatItemLayout.f178049g0, BaseChatItemLayout.f178051i0, BaseChatItemLayout.f178050h0, 0);
            lVar2.f179548b = baseChatItemLayout;
            if (P instanceof MessageForPtt) {
                MessageForPtt messageForPtt = (MessageForPtt) P;
                String S3 = QQLSActivity.this.S3(P);
                ((TextView) inflate.findViewById(R.id.gol)).setText(S3);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) lVar2.f176835i.getLayoutParams();
                if (!S3.equals("")) {
                    z16 = false;
                    marginLayoutParams.setMargins(BaseAIOUtils.f(5.0f, QQLSActivity.this.getResources()), BaseAIOUtils.f(7.0f, QQLSActivity.this.getResources()), 0, 0);
                } else {
                    z16 = false;
                    marginLayoutParams.setMargins(0, BaseAIOUtils.f(7.0f, QQLSActivity.this.getResources()), 0, 0);
                }
                int f16 = com.tencent.mobileqq.activity.aio.item.n.f(QQLSActivity.this.f176792v0, messageForPtt);
                if (f16 == -1) {
                    QQLSActivity.this.M3(lVar2, messageForPtt, z16, true);
                    f16 = 2001;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("PTTItem->getBubbleView", 2, "fileStatus = " + f16 + " url " + messageForPtt.url + " uniseq " + messageForPtt.uniseq);
                }
                QQLSActivity qQLSActivity = QQLSActivity.this;
                qQLSActivity.t4(lVar2, messageForPtt, f16, qQLSActivity.e4(messageForPtt));
                PttInfoCollector.reportPttItemBuilderType(QQLSActivity.this.f176792v0, f16, P);
                com.tencent.mobileqq.activity.aio.y.d(QQLSActivity.this.f176792v0).a(inflate, QQLSActivity.this);
                if (QQLSActivity.I1 && lVar2.f176832f == null) {
                    lVar2.f176832f = new StringBuilder();
                }
                lVar2.f179549c = i3;
                lVar2.f179550d = i3;
                if (QQLSActivity.I1) {
                    lVar2.f179548b.setContentDescription(null);
                    if (!TextUtils.isEmpty(lVar2.f176832f)) {
                        StringBuilder sb5 = lVar2.f176832f;
                        sb5.replace(0, sb5.length(), "");
                    }
                    if (((ChatMessage) P).mNeedTimeStamp) {
                        long j16 = P.time;
                        if (j16 > 0) {
                            try {
                                charSequence = com.tencent.mobileqq.utils.en.d(QQLSActivity.this, 3, j16 * 1000);
                            } catch (Exception unused) {
                            }
                            StringBuilder sb6 = lVar2.f176832f;
                            sb6.append(charSequence);
                            sb6.append(" ");
                        }
                    }
                }
                lVar2.f180131a = (ChatMessage) P;
                ((IPTTPreDownloader) QQLSActivity.this.f176792v0.getRuntimeService(IPTTPreDownloader.class)).onViewPTT(messageForPtt);
            }
            return inflate;
        }

        public void d(ArrayList<RecentBaseData> arrayList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) arrayList);
            } else if (arrayList != null) {
                this.f176822d.clear();
                this.f176822d.addAll((List) arrayList.clone());
                notifyDataSetChanged();
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.f176822d.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
            return this.f176822d.get(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Long) iPatchRedirector.redirect((short) 5, (Object) this, i3)).longValue();
            }
            return i3;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i3) {
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, i3)).intValue();
            }
            if (i3 >= 0 && i3 < this.f176822d.size()) {
                RecentBaseData recentBaseData = this.f176822d.get(i3);
                com.tencent.imcore.message.Message lastMessage = QQLSActivity.this.f176792v0.getMessageFacade().getLastMessage(recentBaseData.getRecentUserUin(), recentBaseData.getRecentUserType());
                if (recentBaseData.getRecentUserType() != 1012 && recentBaseData.getRecentUserType() != 7432 && recentBaseData.getRecentUserType() != 1030 && recentBaseData.getRecentUserType() != 1035) {
                    if (lastMessage != null && ((i16 = lastMessage.msgtype) == -2002 || i16 == -1031)) {
                        return 2;
                    }
                    if (lastMessage != null && lastMessage.msgtype == -2025) {
                        return 3;
                    }
                    if (recentBaseData.getRecentUserType() == 9653) {
                        return 4;
                    }
                } else {
                    return 1;
                }
            }
            return 0;
        }

        /* JADX WARN: Removed duplicated region for block: B:57:0x0201  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x049c  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x04a6  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x04d3  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x04dd  */
        /* JADX WARN: Removed duplicated region for block: B:76:0x04ab  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x04a3  */
        /* JADX WARN: Removed duplicated region for block: B:82:0x051c  */
        /* JADX WARN: Removed duplicated region for block: B:90:0x0564  */
        /* JADX WARN: Removed duplicated region for block: B:97:0x056b  */
        @Override // android.widget.Adapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View b16;
            View inflate;
            int R;
            int X3;
            int i16;
            int i17;
            int i18;
            int i19;
            int i26;
            View view2;
            PhoneContact queryContactByCodeNumber;
            String str;
            com.tencent.imcore.message.Message lastMessage;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                System.currentTimeMillis();
                int itemViewType = getItemViewType(i3);
                if (itemViewType == 1 || itemViewType == 4) {
                    b16 = b(i3, view, viewGroup);
                    view2 = view;
                    EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
                    return b16;
                }
                if (itemViewType == 2) {
                    b16 = c(i3, view, viewGroup);
                } else {
                    if (view == null || !(view.getTag() instanceof p)) {
                        inflate = QQLSActivity.this.getLayoutInflater().inflate(R.layout.awe, (ViewGroup) null);
                        p pVar = new p();
                        pVar.f176836a = (TextView) inflate.findViewById(R.id.grh);
                        pVar.f176837b = (TextView) inflate.findViewById(R.id.grl);
                        pVar.f176838c = (TextView) inflate.findViewById(R.id.grm);
                        pVar.f176839d = (DragTextView) inflate.findViewById(R.id.grn);
                        pVar.f176840e = (ImageView) inflate.findViewById(R.id.gro);
                        inflate.setTag(pVar);
                        pVar.f176839d.setOnModeChangeListener(QQLSActivity.this.f176777n1);
                        pVar.f176839d.setDragViewType(0);
                    } else {
                        inflate = view;
                    }
                    RecentBaseData recentBaseData = this.f176822d.get(i3);
                    p pVar2 = (p) inflate.getTag();
                    pVar2.f176839d.setTag(Integer.valueOf(i3));
                    String recentUserUin = recentBaseData.getRecentUserUin();
                    String str2 = AppConstants.LOCK_SCREEN_LBS_HELLO_UIN;
                    if (recentUserUin.equals(str2) || recentBaseData.getRecentUserUin().equals(AppConstants.LOCK_SCREEN_DATE_UIN)) {
                        X3 = 0;
                        R = 0;
                    } else {
                        R = QQLSActivity.this.f176792v0.getConversationFacade().R(recentBaseData.getRecentUserUin(), recentBaseData.getRecentUserType());
                        X3 = QQLSActivity.this.X3(recentBaseData.getRecentUserUin(), recentBaseData.getRecentUserType());
                    }
                    if (itemViewType == 3 && (lastMessage = QQLSActivity.this.f176792v0.getMessageFacade().getLastMessage(recentBaseData.getRecentUserUin(), recentBaseData.getRecentUserType())) != null) {
                        recentBaseData.mLastMsg = QQLSActivity.this.f176792v0.getMessageFacade().T(QQLSActivity.this, lastMessage, false);
                    }
                    String str3 = recentBaseData.mTitleName;
                    if (recentBaseData.getRecentUserType() == 0 || recentBaseData.getRecentUserType() == 3000 || recentBaseData.getRecentUserType() == 8) {
                        i16 = R;
                        if (X3 > 0) {
                            pVar2.f176840e.setVisibility(0);
                            List<MessageRecord> R3 = QQLSActivity.this.R3(recentBaseData.getRecentUserUin(), recentBaseData.getRecentUserType());
                            if (R3 != null && R3.size() > 0) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("QQLSActivity", 2, "recentList misscallMsg size " + R3.size());
                                }
                                com.tencent.imcore.message.Message lastMessage2 = QQLSActivity.this.f176792v0.getMessageFacade().getLastMessage(recentBaseData.getRecentUserUin(), recentBaseData.getRecentUserType());
                                if (Long.valueOf(recentBaseData.getLastMsgTime()).longValue() >= Long.valueOf(R3.get(R3.size() - 1).time).longValue() && (i18 = lastMessage2.msgtype) != -2016 && i18 != -2009 && i18 != -2026 && recentBaseData.getRecentUserType() != 8) {
                                    this.f176823e = recentBaseData.mLastMsg;
                                    pVar2.f176837b.setTextColor(-4210755);
                                    i17 = 1;
                                } else {
                                    i17 = 1;
                                    this.f176823e = R3.get(R3.size() - 1).f203106msg;
                                    pVar2.f176837b.setTextColor(-570319);
                                }
                            } else {
                                i17 = 1;
                                this.f176823e = recentBaseData.mLastMsg;
                                pVar2.f176837b.setTextColor(-4210755);
                                if (QLog.isColorLevel()) {
                                    QLog.d("QQLSActivity", 2, "recentList misscallMsg size = 0");
                                }
                            }
                            pVar2.f176838c.setText(recentBaseData.mShowTime);
                        } else {
                            i17 = 1;
                            pVar2.f176840e.setVisibility(8);
                            this.f176823e = ((String) recentBaseData.mMsgExtroInfo) + ((Object) recentBaseData.mLastMsg);
                            pVar2.f176837b.setTextColor(-4210755);
                        }
                    } else {
                        if (recentBaseData.getRecentUserType() != 1001 && recentBaseData.getRecentUserType() != 1010 && recentBaseData.getRecentUserType() != 10002) {
                            if (recentBaseData.getRecentUserType() != 1041 && recentBaseData.getRecentUserType() != 1042) {
                                if (recentBaseData.getRecentUserType() == 1) {
                                    com.tencent.imcore.message.Message lastMessage3 = QQLSActivity.this.f176792v0.getMessageFacade().getLastMessage(recentBaseData.getRecentUserUin(), recentBaseData.getRecentUserType());
                                    i16 = R;
                                    MessageRecord w06 = QQLSActivity.this.f176792v0.getMessageFacade().w0(lastMessage3.frienduin, lastMessage3.istroop, lastMessage3.uniseq);
                                    if ((w06 instanceof MessageForPubAccount) && !((MessageForPubAccount) w06).isTextMsg()) {
                                        str = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(QQLSActivity.this.f176792v0, BaseApplication.getContext()) + ":";
                                        this.f176823e = str + ((Object) recentBaseData.mLastMsg);
                                        if (10007 == recentBaseData.getRecentUserType()) {
                                            this.f176823e = ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).getMsgDescp(QQLSActivity.this.f176792v0, recentBaseData, recentBaseData.mLastMsg);
                                        }
                                        pVar2.f176837b.setTextColor(-4210755);
                                        pVar2.f176840e.setVisibility(8);
                                    }
                                } else {
                                    i16 = R;
                                }
                                str = "";
                                this.f176823e = str + ((Object) recentBaseData.mLastMsg);
                                if (10007 == recentBaseData.getRecentUserType()) {
                                }
                                pVar2.f176837b.setTextColor(-4210755);
                                pVar2.f176840e.setVisibility(8);
                            } else {
                                this.f176823e = ((RecentItemNoticeData) recentBaseData).wording;
                                str3 = QQLSActivity.this.getResources().getString(R.string.cil);
                                i17 = 1;
                                i19 = 1;
                                if (recentBaseData.getRecentUserType() == 8 && recentBaseData.mExtraType == 25) {
                                    IPhoneContactService iPhoneContactService = (IPhoneContactService) QQLSActivity.this.f176792v0.getRuntimeService(IPhoneContactService.class, "");
                                    queryContactByCodeNumber = iPhoneContactService == null ? iPhoneContactService.queryContactByCodeNumber(recentBaseData.mPhoneNumber) : null;
                                    if (queryContactByCodeNumber == null) {
                                        recentBaseData.mTitleName = queryContactByCodeNumber.name;
                                    } else {
                                        QCallCardInfo c16 = ((com.tencent.mobileqq.qcall.c) QQLSActivity.this.f176792v0.getManager(QQManagerFactory.QCALLCARD_MANAGER)).c(recentBaseData.getRecentUserUin());
                                        if (c16 != null) {
                                            recentBaseData.mTitleName = c16.nickname;
                                        }
                                    }
                                    if (recentBaseData.mTitleName.equals(recentBaseData.getRecentUserUin())) {
                                        recentBaseData.mTitleName = recentBaseData.mPhoneNumber;
                                    }
                                    if (QLog.isDevelopLevel()) {
                                        QLog.d("QQLSActivity", 4, "getView mTitleName = " + recentBaseData.mTitleName);
                                    }
                                }
                                pVar2.f176836a.setText(str3);
                                pVar2.f176837b.setText(new QQText(this.f176823e, 5, 16, recentBaseData.getRecentUserType()));
                                pVar2.f176838c.setText(recentBaseData.mShowTime);
                                if (recentBaseData.getRecentUserType() == 4000) {
                                    i19 = QQLSActivity.this.f176771k1.getAllUnreadMessageCount();
                                }
                                i26 = (((TextUtils.equals(recentBaseData.getRecentUserUin(), AppConstants.KANDIAN_MERGE_UIN) || recentBaseData.getRecentUserType() != 7220) && !((TextUtils.equals(recentBaseData.getRecentUserUin(), AppConstants.KANDIAN_DAILY_UIN) && recentBaseData.getRecentUserType() == 1008) || (TextUtils.equals(recentBaseData.getRecentUserUin(), AppConstants.NEW_KANDIAN_UIN) && recentBaseData.getRecentUserType() == 1008))) ? i19 : i17) + X3;
                                if (i26 != 0) {
                                    pVar2.f176839d.setVisibility(4);
                                } else {
                                    pVar2.f176839d.setVisibility(0);
                                    com.tencent.widget.d.b(pVar2.f176839d, 3, i26, 0);
                                }
                                if (!recentBaseData.getRecentUserUin().equals(AppConstants.LOCK_SCREEN_DATE_UIN) || recentBaseData.getRecentUserUin().equals(str2)) {
                                    pVar2.f176839d.setVisibility(8);
                                }
                                b16 = inflate;
                                view2 = b16;
                                EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
                                return b16;
                            }
                        } else {
                            i16 = R;
                            if (recentBaseData.getRecentUserUin().equals(AppConstants.LOCK_SCREEN_DATE_UIN)) {
                                recentBaseData.mTitleName = BaseApplicationImpl.getApplication().getString(R.string.air);
                                this.f176823e = BaseApplicationImpl.getApplication().getString(R.string.aiq);
                                String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.OneyWayDateMsgNotifyCfg.name());
                                if (featureValue.length() > 0) {
                                    String[] split = featureValue.split("\\|");
                                    if (split.length >= 6) {
                                        recentBaseData.mTitleName = split[4];
                                        this.f176823e = split[5];
                                    }
                                }
                            } else if (!recentBaseData.getRecentUserUin().equals(str2)) {
                                com.tencent.imcore.message.Message lastMessage4 = QQLSActivity.this.f176792v0.getMessageFacade().getLastMessage(recentBaseData.getRecentUserUin(), recentBaseData.getRecentUserType());
                                if (lastMessage4.msgtype != -2053) {
                                    String j3 = com.tencent.mobileqq.utils.ac.j(QQLSActivity.this.f176792v0, lastMessage4.senderuin);
                                    if (j3 == null) {
                                        j3 = "";
                                    }
                                    this.f176823e = j3 + MsgSummary.STR_COLON + QQLSActivity.this.f176792v0.getMessageFacade().T(QQLSActivity.this, lastMessage4, false);
                                } else {
                                    MessageForNearbyLiveTip messageForNearbyLiveTip = (MessageForNearbyLiveTip) com.tencent.mobileqq.service.message.q.d(MessageRecord.MSG_TYPE_NEARBY_LIVE_TIP);
                                    messageForNearbyLiveTip.msgData = lastMessage4.msgData;
                                    messageForNearbyLiveTip.parse();
                                    this.f176823e = QQLSActivity.this.getString(R.string.fnb) + messageForNearbyLiveTip.nickName + messageForNearbyLiveTip.f203106msg;
                                }
                            } else {
                                recentBaseData.mTitleName = BaseApplicationImpl.getApplication().getString(R.string.c0s);
                                this.f176823e = BaseApplicationImpl.getApplication().getString(R.string.c0r);
                                String featureValue2 = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.OneyWayLBSFriendMsgNotifyCfg.name());
                                if (featureValue2.length() > 0) {
                                    String[] split2 = featureValue2.split("\\|");
                                    if (split2.length >= 6) {
                                        recentBaseData.mTitleName = split2[4];
                                        this.f176823e = split2[5];
                                    }
                                }
                            }
                            pVar2.f176837b.setTextColor(-4210755);
                            pVar2.f176840e.setVisibility(8);
                        }
                        i17 = 1;
                    }
                    i19 = i16;
                    if (recentBaseData.getRecentUserType() == 8) {
                        IPhoneContactService iPhoneContactService2 = (IPhoneContactService) QQLSActivity.this.f176792v0.getRuntimeService(IPhoneContactService.class, "");
                        if (iPhoneContactService2 == null) {
                        }
                        if (queryContactByCodeNumber == null) {
                        }
                        if (recentBaseData.mTitleName.equals(recentBaseData.getRecentUserUin())) {
                        }
                        if (QLog.isDevelopLevel()) {
                        }
                    }
                    pVar2.f176836a.setText(str3);
                    pVar2.f176837b.setText(new QQText(this.f176823e, 5, 16, recentBaseData.getRecentUserType()));
                    pVar2.f176838c.setText(recentBaseData.mShowTime);
                    if (recentBaseData.getRecentUserType() == 4000) {
                    }
                    i26 = (((TextUtils.equals(recentBaseData.getRecentUserUin(), AppConstants.KANDIAN_MERGE_UIN) || recentBaseData.getRecentUserType() != 7220) && !((TextUtils.equals(recentBaseData.getRecentUserUin(), AppConstants.KANDIAN_DAILY_UIN) && recentBaseData.getRecentUserType() == 1008) || (TextUtils.equals(recentBaseData.getRecentUserUin(), AppConstants.NEW_KANDIAN_UIN) && recentBaseData.getRecentUserType() == 1008))) ? i19 : i17) + X3;
                    if (i26 != 0) {
                    }
                    if (!recentBaseData.getRecentUserUin().equals(AppConstants.LOCK_SCREEN_DATE_UIN)) {
                    }
                    pVar2.f176839d.setVisibility(8);
                    b16 = inflate;
                    view2 = b16;
                    EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
                    return b16;
                }
            } else {
                b16 = (View) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), view, viewGroup);
            }
            view2 = view;
            EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
            return b16;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return 5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class l extends o {
        static IPatchRedirector $redirector_;

        /* renamed from: j, reason: collision with root package name */
        TextView f176825j;

        /* renamed from: k, reason: collision with root package name */
        TextView f176826k;

        /* renamed from: l, reason: collision with root package name */
        DragTextView f176827l;

        l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    private class m extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private String f176828a;

        m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLSActivity.this);
            } else {
                this.f176828a = null;
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            if (QQLSActivity.this.f176797x1) {
                return;
            }
            if (intent != null) {
                try {
                    this.f176828a = intent.getAction();
                } catch (Exception e16) {
                    QLog.e("QQLSActivity", 1, e16, new Object[0]);
                    return;
                }
            }
            if (IECScreenReceiver.ACTION_SCREEN_ON.equals(this.f176828a)) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQLSActivity", 2, "ScreenBroadcastReceiver ACTION_SCREEN_ON");
                    return;
                }
                return;
            }
            if (IECScreenReceiver.ACTION_SCREEN_OFF.equals(this.f176828a)) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQLSActivity", 2, "ScreenBroadcastReceiver ACTION_SCREEN_OFF");
                }
            } else if ("android.intent.action.USER_PRESENT".equals(this.f176828a)) {
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("ScreenBroadcastReceiver ACTION_USER_PRESENTmanager.isEnterAio");
                    com.tencent.mobileqq.managers.i iVar = QQLSActivity.this.f176775m1;
                    sb5.append(com.tencent.mobileqq.managers.i.J);
                    QLog.d("QQLSActivity", 2, sb5.toString());
                }
                QQLSActivity qQLSActivity = QQLSActivity.this;
                com.tencent.mobileqq.managers.i iVar2 = qQLSActivity.f176775m1;
                if (!com.tencent.mobileqq.managers.i.J) {
                    qQLSActivity.i4();
                }
                QQLSActivity.this.finish();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class n extends XBaseAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public List<MessageRecord> f176830d;

        public n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLSActivity.this);
            } else {
                this.f176830d = new ArrayList();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x006f A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0070  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0011  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private View a(int i3, View view, ViewGroup viewGroup) {
            s sVar;
            ImageView imageView;
            if (view != null) {
                Object tag = view.getTag();
                if (tag instanceof s) {
                    sVar = (s) tag;
                    if (sVar == null) {
                        view = QQLSActivity.this.getLayoutInflater().inflate(R.layout.awi, (ViewGroup) null);
                        sVar = new s();
                        TextView textView = (TextView) view.findViewById(R.id.grl);
                        sVar.f176845a = textView;
                        textView.setEllipsize(TextUtils.TruncateAt.END);
                        sVar.f176845a.setMaxLines(10);
                        sVar.f176845a.setTextColor(-4210755);
                        view.setTag(sVar);
                    }
                    imageView = (ImageView) view.findViewById(R.id.grf);
                    if (imageView != null) {
                        if (QQLSActivity.this.f176786s0.getRecentUserType() == 7432) {
                            imageView.setVisibility(4);
                        } else {
                            imageView.setVisibility(0);
                        }
                    }
                    if (i3 < this.f176830d.size()) {
                        return view;
                    }
                    sVar.f176845a.setText(QQLSActivity.this.f176786s0.mTitleName);
                    return view;
                }
            }
            sVar = null;
            if (sVar == null) {
            }
            imageView = (ImageView) view.findViewById(R.id.grf);
            if (imageView != null) {
            }
            if (i3 < this.f176830d.size()) {
            }
        }

        public View b(int i3, View view, ViewGroup viewGroup) {
            o oVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (View) iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), view, viewGroup);
            }
            MessageRecord messageRecord = this.f176830d.get(i3);
            BaseChatItemLayout baseChatItemLayout = new BaseChatItemLayout(QQLSActivity.this);
            baseChatItemLayout.setId(R.id.a6b);
            baseChatItemLayout.setFocusableInTouchMode(true);
            baseChatItemLayout.setPadding(BaseChatItemLayout.f178049g0, BaseChatItemLayout.f178051i0, BaseChatItemLayout.f178050h0, 0);
            if (view != null && (view.getTag() instanceof o)) {
                oVar = (o) view.getTag();
            } else {
                oVar = new o();
                view = QQLSActivity.this.getLayoutInflater().inflate(R.layout.awd, (ViewGroup) null);
                oVar.f176834h = (TextView) view.findViewById(R.id.qq_aio_ptt_time_tv);
                oVar.f176833g = (ImageView) view.findViewById(R.id.goj);
                oVar.f176835i = (BreathAnimationLayout) view.findViewById(R.id.gok);
                view.setTag(oVar);
            }
            oVar.f179548b = baseChatItemLayout;
            if (messageRecord instanceof MessageForPtt) {
                MessageForPtt messageForPtt = (MessageForPtt) messageRecord;
                String S3 = QQLSActivity.this.S3(messageRecord);
                ((TextView) view.findViewById(R.id.gol)).setText(new com.tencent.mobileqq.text.c(S3, 16).j());
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) oVar.f176835i.getLayoutParams();
                CharSequence charSequence = "";
                if (!S3.equals("")) {
                    marginLayoutParams.setMargins(BaseAIOUtils.f(5.0f, QQLSActivity.this.getResources()), BaseAIOUtils.f(7.0f, QQLSActivity.this.getResources()), 0, 0);
                } else {
                    marginLayoutParams.setMargins(0, BaseAIOUtils.f(7.0f, QQLSActivity.this.getResources()), 0, 0);
                }
                int f16 = com.tencent.mobileqq.activity.aio.item.n.f(QQLSActivity.this.f176792v0, messageForPtt);
                if (f16 == -1) {
                    QQLSActivity.this.M3(oVar, messageForPtt, false, true);
                    f16 = 2001;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("PTTItem->getBubbleView", 2, "fileStatus = " + f16 + " url " + messageForPtt.url + " uniseq " + messageForPtt.uniseq);
                }
                QQLSActivity qQLSActivity = QQLSActivity.this;
                qQLSActivity.t4(oVar, messageForPtt, f16, qQLSActivity.e4(messageForPtt));
                PttInfoCollector.reportPttItemBuilderType(QQLSActivity.this.f176792v0, f16, messageRecord);
                com.tencent.mobileqq.activity.aio.y.d(QQLSActivity.this.f176792v0).a(view, QQLSActivity.this);
                if (QQLSActivity.I1 && oVar.f176832f == null) {
                    oVar.f176832f = new StringBuilder();
                }
                oVar.f179549c = i3;
                oVar.f179550d = i3;
                if (QQLSActivity.I1) {
                    oVar.f179548b.setContentDescription(null);
                    if (!TextUtils.isEmpty(oVar.f176832f)) {
                        StringBuilder sb5 = oVar.f176832f;
                        sb5.replace(0, sb5.length(), "");
                    }
                    if (((ChatMessage) messageRecord).mNeedTimeStamp) {
                        long j3 = messageRecord.time;
                        if (j3 > 0) {
                            try {
                                charSequence = com.tencent.mobileqq.utils.en.d(QQLSActivity.this, 3, j3 * 1000);
                            } catch (Exception unused) {
                            }
                            StringBuilder sb6 = oVar.f176832f;
                            sb6.append(charSequence);
                            sb6.append(" ");
                        }
                    }
                }
                oVar.f180131a = (ChatMessage) messageRecord;
                ((IPTTPreDownloader) QQLSActivity.this.f176792v0.getRuntimeService(IPTTPreDownloader.class)).onViewPTT(messageForPtt);
            }
            return view;
        }

        public void c(List<MessageRecord> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
            } else if (list != null) {
                this.f176830d.clear();
                this.f176830d.addAll((List) ((ArrayList) list).clone());
                notifyDataSetChanged();
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.f176830d.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
            return this.f176830d.get(i3);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Long) iPatchRedirector.redirect((short) 5, (Object) this, i3)).longValue();
            }
            return i3;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i3) {
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, i3)).intValue();
            }
            if (i3 >= 0 && i3 < this.f176830d.size()) {
                MessageRecord messageRecord = this.f176830d.get(i3);
                if (QQLSActivity.this.f176786s0.getRecentUserType() != 1012 && QQLSActivity.this.f176786s0.getRecentUserType() != 7432 && QQLSActivity.this.f176786s0.getRecentUserType() != 1030 && QQLSActivity.this.f176786s0.getRecentUserType() != 1035) {
                    if (messageRecord != null && ((i16 = messageRecord.msgtype) == -2002 || i16 == -1031)) {
                        return 2;
                    }
                    if (QQLSActivity.this.f176786s0.getRecentUserType() == 9653) {
                        return 4;
                    }
                } else {
                    return 1;
                }
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View a16;
            View inflate;
            View view2;
            String str;
            String str2;
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                int itemViewType = getItemViewType(i3);
                if (itemViewType == 1 || itemViewType == 4) {
                    a16 = a(i3, view, viewGroup);
                } else if (itemViewType == 2) {
                    a16 = b(i3, view, viewGroup);
                } else {
                    if (view == null || !(view.getTag() instanceof r)) {
                        inflate = QQLSActivity.this.getLayoutInflater().inflate(R.layout.awh, (ViewGroup) null);
                        r rVar = new r();
                        TextView textView = (TextView) inflate.findViewById(R.id.grl);
                        ImageView imageView = (ImageView) inflate.findViewById(R.id.gro);
                        textView.setEllipsize(TextUtils.TruncateAt.END);
                        textView.setMaxLines(10);
                        rVar.f176843a = textView;
                        rVar.f176844b = imageView;
                        inflate.setTag(rVar);
                    } else {
                        inflate = view;
                    }
                    if (i3 < this.f176830d.size()) {
                        MessageRecord messageRecord = this.f176830d.get(i3);
                        r rVar2 = (r) inflate.getTag();
                        int i17 = messageRecord.istroop;
                        if (i17 == 7000) {
                            ISubAccountService iSubAccountService = QQLSActivity.this.f176773l1;
                            String latestUinNick = iSubAccountService != null ? iSubAccountService.getLatestUinNick(messageRecord.frienduin) : null;
                            if (latestUinNick == null) {
                                latestUinNick = messageRecord.frienduin;
                            }
                            str = latestUinNick + MsgSummary.STR_COLON + QQLSActivity.this.f176792v0.getMessageFacade().T(QQLSActivity.this, messageRecord, false);
                        } else if (i17 != 1001 && i17 != 1010 && i17 != 10002) {
                            if (com.tencent.biz.anonymous.a.m(messageRecord)) {
                                str = QQLSActivity.this.getResources().getString(R.string.eid) + QQLSActivity.this.f176792v0.getMessageFacade().T(QQLSActivity.this, messageRecord, false);
                            } else {
                                int i18 = messageRecord.istroop;
                                if (i18 == 1 && (messageRecord instanceof MessageForPubAccount)) {
                                    if (((MessageForPubAccount) messageRecord).isTextMsg()) {
                                        str2 = "";
                                    } else {
                                        str2 = ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(QQLSActivity.this.f176792v0, BaseApplication.getContext()) + ":";
                                    }
                                    str = str2 + QQLSActivity.this.f176792v0.getMessageFacade().T(QQLSActivity.this, messageRecord, false);
                                } else if (com.tencent.imcore.message.ao.c(i18) == 1032) {
                                    str = QQLSActivity.this.f176792v0.getMessageFacade().W(QQLSActivity.this, messageRecord, false);
                                } else {
                                    int i19 = messageRecord.istroop;
                                    if (i19 == 1041 || i19 == 1042) {
                                        ((TextView) QQLSActivity.this.f176780p0.findViewById(R.id.grh)).setText(QQLSActivity.this.getResources().getString(R.string.cil));
                                        str = messageRecord.f203106msg;
                                    } else {
                                        str = QQLSActivity.this.f176792v0.getMessageFacade().V(QQLSActivity.this, messageRecord, false);
                                    }
                                }
                            }
                        } else if (messageRecord.msgtype != -2053) {
                            String j3 = com.tencent.mobileqq.utils.ac.j(QQLSActivity.this.f176792v0, messageRecord.senderuin);
                            if (j3 == null) {
                                j3 = "";
                            }
                            if (messageRecord.frienduin.equals(AppConstants.LOCK_SCREEN_DATE_UIN)) {
                                ((TextView) QQLSActivity.this.f176780p0.findViewById(R.id.grh)).setText(BaseApplicationImpl.getApplication().getString(R.string.air));
                                str = BaseApplicationImpl.getApplication().getString(R.string.aiq);
                                ((DragTextView) QQLSActivity.this.f176780p0.findViewById(R.id.grn)).setVisibility(8);
                                String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.OneyWayDateMsgNotifyCfg.name());
                                if (featureValue.length() > 0) {
                                    String[] split = featureValue.split("\\|");
                                    if (split.length >= 6) {
                                        ((TextView) QQLSActivity.this.f176780p0.findViewById(R.id.grh)).setText(split[4]);
                                        str = split[5];
                                    }
                                }
                            } else if (messageRecord.frienduin.equals(AppConstants.LOCK_SCREEN_LBS_HELLO_UIN)) {
                                ((TextView) QQLSActivity.this.f176780p0.findViewById(R.id.grh)).setText(BaseApplicationImpl.getApplication().getString(R.string.c0s));
                                str = BaseApplicationImpl.getApplication().getString(R.string.c0r);
                                ((DragTextView) QQLSActivity.this.f176780p0.findViewById(R.id.grn)).setVisibility(8);
                                String featureValue2 = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.OneyWayLBSFriendMsgNotifyCfg.name());
                                if (featureValue2.length() > 0) {
                                    String[] split2 = featureValue2.split("\\|");
                                    if (split2.length >= 6) {
                                        ((TextView) QQLSActivity.this.f176780p0.findViewById(R.id.grh)).setText(split2[4]);
                                        str = split2[5];
                                    }
                                }
                            } else {
                                str = j3 + MsgSummary.STR_COLON + QQLSActivity.this.f176792v0.getMessageFacade().T(QQLSActivity.this, messageRecord, false);
                            }
                        } else {
                            MessageForNearbyLiveTip messageForNearbyLiveTip = (MessageForNearbyLiveTip) com.tencent.mobileqq.service.message.q.d(MessageRecord.MSG_TYPE_NEARBY_LIVE_TIP);
                            messageForNearbyLiveTip.msgData = messageRecord.msgData;
                            messageForNearbyLiveTip.parse();
                            str = QQLSActivity.this.getString(R.string.fnb) + messageForNearbyLiveTip.nickName + messageForNearbyLiveTip.f203106msg;
                        }
                        if (TextUtils.isEmpty(str)) {
                            str = "";
                        }
                        if (10007 == messageRecord.istroop) {
                            str = ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).getMsgDescp(QQLSActivity.this.f176792v0, messageRecord, str);
                        }
                        if (QQLSActivity.this.f176783q1.size() > 0 && str.equals("") && ((i16 = messageRecord.msgtype) == -2016 || i16 == -2009 || i16 == -2026)) {
                            str = messageRecord.f203106msg;
                            rVar2.f176843a.setTextColor(-570319);
                            rVar2.f176844b.setVisibility(0);
                        } else {
                            rVar2.f176843a.setTextColor(-4210755);
                            rVar2.f176844b.setVisibility(8);
                        }
                        if (messageRecord.istroop != 1 || (messageRecord instanceof MessageForPubAccount)) {
                            rVar2.f176843a.setText(new QQText(str, 5, 16, QQLSActivity.this.f176786s0.getRecentUserType()));
                        } else {
                            CharSequence w3 = com.tencent.mobileqq.vas.f.w(messageRecord, QQLSActivity.this.f176792v0.getMessageFacade().U(QQLSActivity.this, messageRecord, false));
                            if (w3 == null) {
                                rVar2.f176843a.setText(new QQText(str, 5, 16, QQLSActivity.this.f176786s0.getRecentUserType()));
                            } else {
                                rVar2.f176843a.setText(w3);
                            }
                        }
                    }
                    view2 = inflate;
                    EventCollector.getInstance().onListGetView(i3, inflate, viewGroup, getItemId(i3));
                    return view2;
                }
            } else {
                a16 = (View) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), view, viewGroup);
            }
            inflate = view;
            view2 = a16;
            EventCollector.getInstance().onListGetView(i3, inflate, viewGroup, getItemId(i3));
            return view2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return 5;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class o extends o.a {
        static IPatchRedirector $redirector_;

        /* renamed from: f, reason: collision with root package name */
        public StringBuilder f176832f;

        /* renamed from: g, reason: collision with root package name */
        public ImageView f176833g;

        /* renamed from: h, reason: collision with root package name */
        public TextView f176834h;

        /* renamed from: i, reason: collision with root package name */
        public BreathAnimationLayout f176835i;

        public o() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    static class p {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        TextView f176836a;

        /* renamed from: b, reason: collision with root package name */
        TextView f176837b;

        /* renamed from: c, reason: collision with root package name */
        TextView f176838c;

        /* renamed from: d, reason: collision with root package name */
        DragTextView f176839d;

        /* renamed from: e, reason: collision with root package name */
        ImageView f176840e;

        p() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class q {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        TextView f176841a;

        /* renamed from: b, reason: collision with root package name */
        DragTextView f176842b;

        q() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    static class r {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        TextView f176843a;

        /* renamed from: b, reason: collision with root package name */
        ImageView f176844b;

        r() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class s {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        TextView f176845a;

        s() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67363);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 56)) {
            redirector.redirect((short) 56);
            return;
        }
        I1 = AppSetting.f99565y;
        J1 = false;
        K1 = new CopyOnWriteArraySet<>();
    }

    public QQLSActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f176796x0 = 300;
        this.A0 = -1L;
        this.B0 = 0L;
        this.C0 = 0L;
        this.D0 = false;
        this.F0 = 1000;
        this.G0 = 1;
        this.H0 = 2;
        this.I0 = 3;
        this.J0 = 4;
        this.K0 = 5;
        this.L0 = 6;
        this.M0 = 7;
        this.N0 = 8;
        this.O0 = 9;
        this.P0 = 10;
        this.Q0 = 11;
        this.R0 = 12;
        this.S0 = 13;
        this.T0 = 14;
        this.U0 = 15;
        this.V0 = 16;
        this.W0 = 1500;
        this.X0 = 1000;
        this.Y0 = 0;
        this.Z0 = 1;
        this.f176751a1 = 2;
        this.f176753b1 = 3;
        this.f176755c1 = 4;
        this.f176757d1 = 5;
        this.f176759e1 = 99;
        this.f176763g1 = false;
        this.f176765h1 = null;
        this.f176767i1 = true;
        this.f176769j1 = false;
        this.f176779o1 = true;
        this.f176783q1 = new ArrayList<>();
        this.f176791u1 = true;
        this.f176793v1 = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
        this.f176795w1 = -1L;
        this.f176799y1 = new WeakReferenceHandler(Looper.getMainLooper(), this);
        this.f176801z1 = new f();
        this.A1 = new g();
        this.C1 = new i();
        this.D1 = new j();
        this.E1 = new a();
        this.F1 = new b();
        this.G1 = new c(Looper.getMainLooper());
        this.H1 = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F3() {
        if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "SmoothFinish");
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(450L);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.mobileqq.activity.QQLSActivity.20
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLSActivity.this);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) animation);
                    return;
                }
                QQLSActivity.this.f176793v1.removeMessages(99);
                if (VersionUtils.isJellyBean()) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QQLSActivity", 2, "do SmoothFinish");
                    }
                    QQLSActivity.this.i4();
                    QQLSActivity.this.finish();
                    return;
                }
                QQLSActivity.this.f176793v1.postAtFrontOfQueue(new Runnable() { // from class: com.tencent.mobileqq.activity.QQLSActivity.20.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass20.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("QQLSActivity", 2, "do SmoothFinish at run");
                        }
                        QQLSActivity.this.i4();
                        QQLSActivity.this.finish();
                    }
                });
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this, (Object) animation);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                }
            }
        });
        this.f176793v1.sendEmptyMessageDelayed(99, 500L);
        this.f176750a0.startAnimation(alphaAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G3() {
        if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "new brightWakeLock  screen bright!!!");
        }
        if (com.tencent.mobileqq.managers.i.f243728m) {
            com.tencent.mobileqq.managers.i.f243726h = System.currentTimeMillis();
            com.tencent.mobileqq.managers.i.f243727i++;
        }
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.QQLSActivity.14
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLSActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    QQLSActivity.this.f176765h1 = ((PowerManager) QQLSActivity.this.getSystemService("power")).newWakeLock(268435462, "QQLSActivity");
                    QQLSActivity.this.f176765h1.acquire(10000L);
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("QQLSActivity", 2, "acquireBrightWakeLock:" + e16.toString());
                    }
                }
            }
        });
    }

    private void H3() {
        if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "new wakeLock");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I3() {
        if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "clearRemindTime");
        }
        com.tencent.mobileqq.managers.i.f243725f = 0L;
        com.tencent.mobileqq.managers.i.f243726h = 0L;
        com.tencent.mobileqq.managers.i.f243727i = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J3(boolean z16) {
        this.G1.removeMessages(14);
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.activity.QQLSActivity.19
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLSActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (QQLSActivity.this.f176760f0 != null) {
                    QQLSActivity.this.f176750a0.removeView(QQLSActivity.this.f176760f0);
                }
                QQLSActivity.this.f176760f0 = null;
            }
        };
        if (z16) {
            this.G1.post(runnable);
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K3() {
        this.G1.removeMessages(15);
        this.f176766i0.setVisibility(4);
    }

    private void L3(com.tencent.mobileqq.newfriend.msg.c cVar) {
        MessageForSystemMsg messageForSystemMsg = cVar.f254022d;
        if (messageForSystemMsg != null && AppConstants.FRIEND_SYSTEM_MSG_UIN.equals(messageForSystemMsg.frienduin)) {
            int a16 = com.tencent.mobileqq.activity.contact.newfriend.b.a(cVar.f254022d);
            ((INewFriendApi) QRoute.api(INewFriendApi.class)).setFromSysSubMsgType(a16);
            if (a16 == 6) {
                ((INewFriendApi) QRoute.api(INewFriendApi.class)).report(this.f176792v0, "0X800A181");
            } else if (a16 == 9 || a16 == 10 || a16 == 1) {
                ((INewFriendApi) QRoute.api(INewFriendApi.class)).report(this.f176792v0, "0X8009CBA");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P3(RecentBaseData recentBaseData) {
        Intent intent;
        Intent intent2;
        Intent intent3;
        Intent intent4;
        if (Math.abs(this.C0 - System.currentTimeMillis()) < 1000) {
            if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, "enter too offen,please try again later");
                return;
            }
            return;
        }
        this.C0 = System.currentTimeMillis();
        com.tencent.mobileqq.managers.i.K = System.currentTimeMillis();
        I3();
        if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "enterAIO");
        }
        if (!isKeyguardLock()) {
            if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, "=======enterAIO  NOT LOCK!!!!!!!!!");
            }
            finish();
            return;
        }
        if (this.G1.hasMessages(13)) {
            this.G1.removeMessages(13);
        }
        RecentUser d16 = recentBaseData instanceof RecentUserBaseData ? ((RecentUserBaseData) recentBaseData).d() : null;
        if (recentBaseData != null) {
            recentBaseData.clearUnReadNum();
        }
        if (recentBaseData != null) {
            com.tencent.mobileqq.managers.d.d(this.f176775m1.c(recentBaseData.getRecentUserUin() + recentBaseData.getRecentUserType()), recentBaseData.getRecentUserUin(), recentBaseData.getRecentUserType());
        }
        ReportController.o(this.f176792v0, "CliOper", "", "", "0X80040DD", "0X80040DD", 0, 0, "", "", "", "");
        boolean z16 = true;
        com.tencent.mobileqq.managers.i.J = true;
        if (c4()) {
            I3();
            Animation animation = this.E0;
            if (animation != null) {
                this.f176750a0.startAnimation(animation);
            }
            if (d16 != null && d16.getType() == 1012) {
                AllInOne allInOne = new AllInOne(this.f176792v0.getCurrentAccountUin(), 0);
                Intent intent5 = new Intent();
                intent5.putExtra("param_mode", 2);
                intent5.putExtra(IProfileCardConst.KEY_ALL_IN_ONE, allInOne);
                intent5.putExtra("abp_flag", true);
                intent5.putExtra("frome_where", -1);
                intent5.addFlags(67108864);
                RouteUtils.startActivity(BaseApplication.getContext(), intent5, "/nearby/people/profile");
            } else if (d16 != null && (d16.getType() == 1030 || d16.getType() == 1030 || d16.getType() == 1041 || d16.getType() == 1042)) {
                if ((recentBaseData instanceof RecentItemNoticeData) && (intent4 = ((RecentItemNoticeData) recentBaseData).intent) != null) {
                    startActivity(intent4);
                }
            } else if (d16 != null && d16.getType() == 9653) {
                com.tencent.mobileqq.managers.h hVar = (com.tencent.mobileqq.managers.h) this.f176792v0.getManager(QQManagerFactory.PULL_ACTIVE_MANAGER);
                if ((recentBaseData instanceof RecentItemPullActivePush) && (intent3 = hVar.f243724h) != null) {
                    startActivity(intent3);
                }
                hVar.c();
                QQNotificationManager.getInstance().cancel("QQLSActivity_PullActive", 269);
            } else if (d16 != null && d16.getType() == 1001) {
                startActivity(this.f176792v0.getIntentByMessage(this, this.f176792v0.getMessageFacade().getLastMessage(d16.uin, d16.getType()), false));
            } else if (recentBaseData != null && com.tencent.imcore.message.ao.c(recentBaseData.getRecentUserType()) == 1044) {
                Intent b16 = MatchChatMsgUtil.b(this);
                b16.putExtra("key_matchchat_from_notification", true);
                b16.putExtra("key_matchchat_from_notification_uin", recentBaseData.getRecentUserUin());
                b16.putExtra("key_matchchat_from_notification_type", recentBaseData.getRecentUserType());
                startActivity(b16);
            } else if (recentBaseData != null && recentBaseData.getRecentUserType() == 10007) {
                if (((IGameMsgBoxABTestApi) QRoute.api(IGameMsgBoxABTestApi.class)).isGameMsgAddTab()) {
                    MessageRecord lastGameMsg = ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).getLastGameMsg(this.f176792v0, recentBaseData.getRecentUserUin());
                    if (lastGameMsg != null) {
                        ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).enterGameMsgChatPie(this, recentBaseData.getRecentUserUin(), com.tencent.mobileqq.gamecenter.util.c.c(lastGameMsg), com.tencent.mobileqq.gamecenter.util.c.d(lastGameMsg), 2);
                    }
                } else {
                    ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).enterGameMsgChatPie(this.f176792v0, this, recentBaseData.getRecentUserUin());
                }
            } else {
                Intent aliasIntent = SplashActivity.getAliasIntent(this);
                aliasIntent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
                aliasIntent.setFlags(67108864);
                startActivity(aliasIntent);
            }
            this.G1.sendMessageDelayed(this.G1.obtainMessage(16), 1500L);
            return;
        }
        if (d16 != null && d16.getType() == 7432) {
            Intent aliasIntent2 = SplashActivity.getAliasIntent(this);
            aliasIntent2.setFlags(67108864);
            aliasIntent2.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
            aliasIntent2.putExtra(SplashActivity.FRAGMENT_ID, 1);
            startActivity(aliasIntent2);
        } else {
            if (d16 != null && d16.getType() == 9653) {
                com.tencent.mobileqq.managers.h hVar2 = (com.tencent.mobileqq.managers.h) this.f176792v0.getManager(QQManagerFactory.PULL_ACTIVE_MANAGER);
                if ((recentBaseData instanceof RecentItemPullActivePush) && (intent2 = hVar2.f243724h) != null) {
                    intent2.setFlags(67108864);
                    startActivity(intent2);
                }
                hVar2.c();
                QQNotificationManager.getInstance().cancel("QQLSActivity_PullActive", 269);
                com.tencent.util.j.c(this.f176792v0, d16);
                this.G1.sendMessageDelayed(this.G1.obtainMessage(9), (!BaseGesturePWDUtil.getJumpLock(this, this.f176792v0.getCurrentAccountUin()) || z16) ? 500L : 0L);
                this.G1.sendMessageDelayed(this.G1.obtainMessage(16), 1500L);
                if (d16 == null && d16.getType() == 1008) {
                    ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, d16.uin, "0X800756F", "0X800756F", 0, 0, "", "", "", "");
                    return;
                }
            }
            if (d16 != null && (d16.getType() == 1030 || f4(d16.getType()))) {
                if ((recentBaseData instanceof RecentItemNoticeData) && (intent = ((RecentItemNoticeData) recentBaseData).intent) != null) {
                    if (f4(d16.getType()) && !c4()) {
                        intent.putExtra("push_notice_unlock", true);
                    }
                    startActivity(intent);
                }
            } else if (d16 != null && d16.getType() == 1001) {
                startActivity(this.f176792v0.getIntentByMessage(this, this.f176792v0.getMessageFacade().getLastMessage(d16.uin, d16.getType()), false));
            } else if (recentBaseData != null && com.tencent.imcore.message.ao.c(recentBaseData.getRecentUserType()) == 1044) {
                Intent b17 = MatchChatMsgUtil.b(this);
                b17.putExtra("key_matchchat_from_notification", true);
                b17.putExtra("key_matchchat_from_notification_uin", recentBaseData.getRecentUserUin());
                b17.putExtra("key_matchchat_from_notification_type", recentBaseData.getRecentUserType());
                startActivity(b17);
            } else if (recentBaseData != null && recentBaseData.getRecentUserType() == 10007) {
                ((IGameMsgHelperApi) QRoute.api(IGameMsgHelperApi.class)).enterGameMsgChatPie(this.f176792v0, this, recentBaseData.getRecentUserUin());
            } else if (recentBaseData != null && recentBaseData.getRecentUserType() == 0) {
                V3(recentBaseData, d16);
            } else if (recentBaseData != null && recentBaseData.getRecentUserType() == 1) {
                W3(recentBaseData, d16);
            } else if (recentBaseData != null) {
                RecentUtil.x0(this, this.f176792v0, d16, recentBaseData.mTitleName, true, 1, null);
            }
        }
        z16 = false;
        com.tencent.util.j.c(this.f176792v0, d16);
        this.G1.sendMessageDelayed(this.G1.obtainMessage(9), (!BaseGesturePWDUtil.getJumpLock(this, this.f176792v0.getCurrentAccountUin()) || z16) ? 500L : 0L);
        this.G1.sendMessageDelayed(this.G1.obtainMessage(16), 1500L);
        if (d16 == null) {
        }
    }

    private void Q3() {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.QQLSActivity.22
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLSActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                ComponentName componentName;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) QQLSActivity.this.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getRunningTasks(1);
                    String b16 = com.tencent.mobileqq.utils.m.b();
                    if (runningTasks != null && runningTasks.size() > 0) {
                        componentName = runningTasks.get(0).topActivity;
                        String className = componentName.getClassName();
                        boolean isKeyguardLock = QQLSActivity.this.isKeyguardLock();
                        if (QLog.isColorLevel()) {
                            QLog.d("QQLSActivity", 2, "qqlsActivity onpause by :" + className);
                        }
                        if (className.equals("com.tencent.mobileqq.activity.GesturePWDUnlockActivity") && isKeyguardLock) {
                            if (QLog.isColorLevel()) {
                                QLog.d("QQLSActivity", 2, "qqlsActivity onpause by locking activity need to front");
                            }
                            if (QQLSActivity.this.G1.hasMessages(10)) {
                                QQLSActivity.this.G1.removeMessages(10);
                            }
                            Message obtainMessage = QQLSActivity.this.G1.obtainMessage(10);
                            if (b16.equalsIgnoreCase("Xiaomi-2013022")) {
                                QQLSActivity.this.G1.sendMessageDelayed(obtainMessage, 600L);
                            } else {
                                QQLSActivity.this.G1.sendMessage(obtainMessage);
                            }
                        }
                    }
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QQLSActivity", 2, "qqlsActivity MSG_SETTO_FRONT by locking activity not to front e=" + e16);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String S3(MessageRecord messageRecord) {
        String j3;
        String str;
        int i3 = messageRecord.istroop;
        if (i3 == 7000) {
            ISubAccountService iSubAccountService = this.f176773l1;
            if (iSubAccountService != null) {
                j3 = iSubAccountService.getLatestUinNick(messageRecord.frienduin);
            } else {
                j3 = null;
            }
            if (j3 == null) {
                j3 = messageRecord.frienduin;
            }
        } else if (i3 != 1001 && i3 != 1010 && i3 != 10002) {
            if (com.tencent.imcore.message.ao.c(i3) == 1032) {
                ConfessInfo confessInfo = new ConfessInfo();
                confessInfo.parseFromJsonStr(messageRecord.getExtInfoFromExtStr("ext_key_confess_info"));
                if (messageRecord.istroop == 1032) {
                    str = messageRecord.senderuin;
                } else {
                    str = messageRecord.frienduin;
                }
                j3 = ConfessMsgUtil.p(this.f176792v0, confessInfo, str);
            } else if (com.tencent.biz.anonymous.a.m(messageRecord)) {
                j3 = getResources().getString(R.string.eid);
            } else {
                j3 = this.f176792v0.getMessageFacade().R(this, messageRecord, false);
            }
        } else {
            j3 = com.tencent.mobileqq.utils.ac.j(this.f176792v0, messageRecord.senderuin);
            if (j3 == null) {
                j3 = "";
            }
        }
        if (TextUtils.isEmpty(j3) || j3.equals("")) {
            return "";
        }
        return j3 + ":";
    }

    private SessionInfo T3(RecentBaseData recentBaseData) {
        String str;
        int recentUserType = recentBaseData.getRecentUserType();
        String recentUserUin = recentBaseData.getRecentUserUin();
        SessionInfo sessionInfo = new SessionInfo();
        if (recentUserType == 1) {
            TroopManager troopManager = (TroopManager) this.f176792v0.getManager(QQManagerFactory.TROOP_MANAGER);
            if (troopManager != null) {
                TroopInfo k3 = troopManager.k(recentUserUin + "");
                if (k3 != null && (str = k3.troopcode) != null) {
                    sessionInfo.f179559f = str;
                }
            }
        } else if (recentUserType == 1006) {
            RespondQueryQQBindingStat selfBindInfo = ((IPhoneContactService) this.f176792v0.getRuntimeService(IPhoneContactService.class, "")).getSelfBindInfo();
            sessionInfo.f179564m = selfBindInfo.nationCode + selfBindInfo.mobileNo;
            String m06 = com.tencent.mobileqq.utils.ac.m0(this.f176792v0, recentUserUin);
            sessionInfo.C = m06;
            if (m06 == null && QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, "contactUin == null");
            }
        } else if ((recentUserType == 1004 || recentUserType == 1000) && (recentBaseData instanceof RecentUserBaseData)) {
            sessionInfo.f179559f = ((RecentUserBaseData) recentBaseData).e();
        }
        sessionInfo.f179557e = recentUserUin;
        sessionInfo.f179555d = recentUserType;
        sessionInfo.f179563i = recentBaseData.mTitleName;
        return sessionInfo;
    }

    private List<MessageRecord> U3(String str, int i3) {
        com.tencent.mobileqq.newfriend.msg.i iVar;
        MessageRecord c16;
        MessageRecord a16;
        long j3;
        if (TextUtils.isEmpty(str)) {
            return new ArrayList();
        }
        if (!str.equals(AppConstants.LOCK_SCREEN_DATE_UIN) && !str.equals(AppConstants.LOCK_SCREEN_LBS_HELLO_UIN)) {
            List<MessageRecord> Q = this.f176792v0.getMessageFacade().Q(str, i3);
            List<MessageRecord> arrayList = new ArrayList<>();
            if (com.tencent.imcore.message.ao.r(i3)) {
                Pair<Long, Long> m06 = this.f176792v0.getMsgCache().m0(str);
                if (m06 != null) {
                    j3 = ((Long) m06.first).longValue();
                } else {
                    j3 = 0;
                }
                List<MessageRecord> n16 = com.tencent.imcore.message.y.n1(Q, j3);
                if (n16 != null && n16.size() > 0) {
                    arrayList.addAll(n16);
                }
            } else if (i3 != 3000 && i3 != 1) {
                if (i3 == 7000) {
                    MessageRecord messageRecord = new MessageRecord();
                    ISubAccountService iSubAccountService = this.f176773l1;
                    if (iSubAccountService != null && iSubAccountService.getLatestMsg(str) != null) {
                        messageRecord.f203106msg = this.f176773l1.getLatestMsg(str).toString();
                        messageRecord.istroop = i3;
                        messageRecord.frienduin = str;
                        arrayList.add(messageRecord);
                    }
                } else if (i3 == 4000) {
                    MessageRecord messageRecord2 = new MessageRecord();
                    INewFriendService iNewFriendService = this.f176771k1;
                    if (iNewFriendService != null) {
                        iVar = iNewFriendService.getLastUnreadNewFriendMessage();
                    } else {
                        iVar = null;
                    }
                    if (iVar != null) {
                        messageRecord2.f203106msg = iVar.a(this.f176792v0);
                        messageRecord2.istroop = i3;
                        messageRecord2.frienduin = str;
                        if (iVar instanceof com.tencent.mobileqq.newfriend.msg.c) {
                            L3((com.tencent.mobileqq.newfriend.msg.c) iVar);
                        }
                        arrayList.add(messageRecord2);
                    }
                } else if (i3 == 9002) {
                    com.tencent.mobileqq.reminder.db.entity.b lastMessage = com.tencent.mobileqq.reminder.db.d.a(this.f176792v0).getLastMessage(AppConstants.ACTIVATE_FRIENDS_UIN, 9002);
                    MessageRecord messageRecord3 = new MessageRecord();
                    er.a(this, messageRecord3, lastMessage);
                    arrayList.add(messageRecord3);
                } else if (i3 == 8) {
                    MessageRecord d16 = com.tencent.mobileqq.service.message.q.d(MessageRecord.MSG_TYPE_LIGHTALK_MSG);
                    d16.istroop = i3;
                    d16.frienduin = str;
                    d16.f203106msg = "";
                    d16.isread = true;
                    arrayList.add(d16);
                } else if (i3 == 9501 && Q != null) {
                    Iterator<MessageRecord> it = Q.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next());
                    }
                }
            } else {
                arrayList = com.tencent.imcore.message.ad.h(Q, false);
            }
            if (i3 != 1001 && i3 != 1010 && i3 != 10002) {
                if (i3 == 1032) {
                    if (arrayList != null && arrayList.size() != 0) {
                        MessageRecord n3 = ConfessMsgUtil.n(this.f176792v0, arrayList.get(arrayList.size() - 1));
                        arrayList.clear();
                        if (n3 != null) {
                            arrayList.add(n3);
                        }
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.d("QQLSActivity", 2, "getSingleUnreadMsg UIN_TYPE_LBS_FRIEND is null");
                        }
                        finish();
                        return new ArrayList();
                    }
                }
                if (str.equals(AppConstants.VOTE_UIN)) {
                    com.tencent.mobileqq.dating.d dVar = (com.tencent.mobileqq.dating.d) this.f176792v0.getManager(QQManagerFactory.DATING_PROXY_MANAGER);
                    if (dVar != null) {
                        arrayList.add(dVar.b().b(this.f176786s0));
                    }
                    return arrayList;
                }
                if (i3 == 1030 && AppConstants.CAMPUS_NOTICE_UIN.equals(str)) {
                    QQAppInterface qQAppInterface = this.f176792v0;
                    int i16 = QQManagerFactory.CAMPUS_NOTICE_MANAGER;
                    if (qQAppInterface.isCreateManager(i16) && (a16 = ((com.tencent.mobileqq.campuscircle.d) this.f176792v0.getManager(i16)).a()) != null) {
                        arrayList.add(a16);
                    }
                    return arrayList;
                }
                if (f4(i3)) {
                    QQAppInterface qQAppInterface2 = this.f176792v0;
                    int i17 = QQManagerFactory.PUSH_NOTICE_MANAGER;
                    if (qQAppInterface2.isCreateManager(i17) && (c16 = ((PushNoticeManager) this.f176792v0.getManager(i17)).c()) != null) {
                        arrayList.add(c16);
                    }
                    return arrayList;
                }
                if (str.equals(AppConstants.PULL_ACTIVE_PUSH_UIN)) {
                    com.tencent.mobileqq.managers.h hVar = (com.tencent.mobileqq.managers.h) this.f176792v0.getManager(QQManagerFactory.PULL_ACTIVE_MANAGER);
                    if (hVar != null) {
                        arrayList.add(hVar.a());
                    }
                    return arrayList;
                }
                if (QLog.isColorLevel() && arrayList != null) {
                    QLog.d("QQLSActivity", 2, "single item continued msg list size: " + arrayList.size());
                }
                if (i3 == 10014) {
                    ((IGuildMsgProxyUtilsApi) QRoute.api(IGuildMsgProxyUtilsApi.class)).pretreatmentAIOMsg(i3, arrayList, this.f176792v0);
                } else {
                    com.tencent.imcore.message.ext.getaiolist.a.a(i3, arrayList, this.f176792v0);
                }
                com.tencent.imcore.message.ad.P(str, i3, arrayList, this.f176792v0.getMsgCache());
                ArrayList arrayList2 = new ArrayList();
                if (arrayList != null && arrayList.size() != 0) {
                    boolean z16 = false;
                    for (MessageRecord messageRecord4 : arrayList) {
                        if (!z16 || messageRecord4.isSend() || !com.tencent.mobileqq.graytip.f.e(messageRecord4)) {
                            if (d4(messageRecord4, str, i3) && !messageRecord4.isSend()) {
                                z16 = true;
                            } else {
                                arrayList2.add(messageRecord4);
                            }
                        }
                    }
                    arrayList.removeAll(arrayList2);
                    QLog.d("QQLSActivity", 1, "[getSingleUnreadMsg][LSUnread] remove[", Integer.valueOf(arrayList2.size()), "] read msg. retain [", Integer.valueOf(arrayList.size()), "] unreads");
                    if (QLog.isColorLevel()) {
                        QLog.d("QQLSActivity", 2, "mergeSortList miscalllist size: " + this.f176783q1.size() + ", uinType" + i3);
                    }
                    List<MessageRecord> R3 = R3(str, i3);
                    if (R3.size() > 0) {
                        h4(arrayList, R3, i3);
                    }
                    if (arrayList.size() > 15) {
                        return new ArrayList(arrayList.subList(arrayList.size() - 15, arrayList.size()));
                    }
                    return arrayList;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("QQLSActivity", 2, "single item continued msg list size= 0" + Thread.currentThread().getId());
                }
                F3();
                return new ArrayList();
            }
            if (arrayList != null && arrayList.size() != 0) {
                return new ArrayList(arrayList.subList(arrayList.size() - 1, arrayList.size()));
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, "getSingleUnreadMsg UIN_TYPE_LBS_FRIEND is null");
            }
            finish();
            return new ArrayList();
        }
        MessageRecord messageRecord5 = new MessageRecord();
        messageRecord5.frienduin = str;
        messageRecord5.senderuin = str;
        messageRecord5.istroop = i3;
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(messageRecord5);
        return arrayList3;
    }

    private void V3(RecentBaseData recentBaseData, RecentUser recentUser) {
        if (recentUser == null) {
            QLog.e("QQLSActivity", 1, "handleEnterAIOTroop r is null");
            return;
        }
        Bundle bundle = new Bundle();
        com.tencent.imcore.message.Message lastMessage = this.f176792v0.getMessageFacade().getLastMessage(recentUser.uin, recentUser.getType());
        if (lastMessage != null && lastMessage.msgtype == -5008) {
            bundle.putBoolean("key_from_listen_together_notify_msg", com.tencent.mobileqq.listentogether.g.a(this.f176792v0, lastMessage));
        }
        RecentUtil.y0(this, this.f176792v0, recentUser, recentBaseData.mTitleName, true, 1, null, bundle, null);
    }

    private void W3(RecentBaseData recentBaseData, RecentUser recentUser) {
        if (recentUser == null) {
            QLog.e("QQLSActivity", 1, "handleEnterAIOTroop r is null");
            return;
        }
        Bundle bundle = new Bundle();
        com.tencent.imcore.message.Message lastMessage = this.f176792v0.getMessageFacade().getLastMessage(recentUser.uin, recentUser.getType());
        if (lastMessage != null && lastMessage.msgtype == -5008) {
            bundle.putBoolean("key_from_listen_together_notify_msg", com.tencent.mobileqq.listentogether.g.a(this.f176792v0, lastMessage));
        }
        RecentUtil.y0(this, this.f176792v0, recentUser, recentBaseData.mTitleName, true, 1, null, bundle, null);
    }

    private void a4() {
        if (com.tencent.mobileqq.managers.i.f243725f == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            com.tencent.mobileqq.managers.i.f243725f = currentTimeMillis;
            com.tencent.mobileqq.managers.i.f243726h = currentTimeMillis;
            com.tencent.mobileqq.managers.i.f243727i = 0;
            return;
        }
        long j3 = com.tencent.mobileqq.managers.i.f243726h;
        long j16 = com.tencent.mobileqq.managers.i.f243725f;
        if (j3 < j16) {
            com.tencent.mobileqq.managers.i.f243726h = j16;
            com.tencent.mobileqq.managers.i.f243727i = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b4(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
        if (motionEvent3.getEventTime() - motionEvent.getEventTime() > 300) {
            if (QLog.isColorLevel()) {
                QLog.e("QQLSActivity", 2, "isConsideredDoubleTap true");
                return false;
            }
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(16)
    public boolean c4() {
        boolean equals = "1".equals(((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.lock_screen_enterAIO.name(), "1"));
        if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "=======5.0enterAIO=======" + equals);
        }
        if (!equals) {
            return true;
        }
        try {
            if (this.f176789t1 == null) {
                this.f176789t1 = (KeyguardManager) getSystemService("keyguard");
            }
            if (QLog.isColorLevel()) {
                QLog.e("QQLSActivity", 2, "kgm.isKeyguardLocked()=" + this.f176789t1.isKeyguardLocked() + ". kgm.isKeyguardSecure()=" + this.f176789t1.isKeyguardSecure());
            }
            KeyguardManager keyguardManager = this.f176789t1;
            if (keyguardManager != null && keyguardManager.isKeyguardLocked()) {
                if (this.f176789t1.isKeyguardSecure()) {
                    return true;
                }
            }
            return false;
        } catch (SecurityException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("QQLSActivity", 2, "kgm.isKeyguardLocked()=" + e16);
            }
            return true;
        }
    }

    private boolean d4(MessageRecord messageRecord, String str, int i3) {
        ConversationInfo y16 = this.f176792v0.getConversationFacade().y(str, i3);
        if (y16 == null || messageRecord == null) {
            return false;
        }
        if (com.tencent.imcore.message.ao.r(i3)) {
            if (messageRecord.time <= y16.lastread) {
                return false;
            }
        } else if (messageRecord.shmsgseq <= y16.lastread) {
            return false;
        }
        return true;
    }

    private static boolean f4(int i3) {
        if (i3 != 1035 && i3 != 1041 && i3 != 1042) {
            return false;
        }
        return true;
    }

    private void g4(Intent intent) {
        if (intent != null) {
            int intExtra = intent.getIntExtra("uitype", -1);
            int intExtra2 = intent.getIntExtra("notifyId", -1);
            String stringExtra = intent.getStringExtra("frienduin");
            if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, "lsReportCore uitype: " + intExtra + ", notifyId : " + intExtra2 + ", frienduin : " + stringExtra);
            }
            com.tencent.mobileqq.managers.d.c(intExtra2, stringExtra, intExtra);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i4() {
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.QQLSActivity.21
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLSActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("moveTaskToBack", 2, "moveTaskToBackInSubThread");
                }
                try {
                    QQLSActivity.this.moveTaskToBack(true);
                } catch (Throwable th5) {
                    if (QLog.isColorLevel()) {
                        QLog.d("moveTaskToBack", 2, "moveTaskToBack e=" + th5.toString());
                    }
                }
            }
        });
    }

    @TargetApi(9)
    private void initUI() {
        TouchProxyRelativeLayout touchProxyRelativeLayout = (TouchProxyRelativeLayout) findViewById(R.id.gty);
        this.f176750a0 = touchProxyRelativeLayout;
        if (touchProxyRelativeLayout == null) {
            QLog.e("QQLSActivity", 1, "UI is null finish");
            finish();
            return;
        }
        touchProxyRelativeLayout.setVisibility(0);
        this.f176780p0 = (RelativeLayout) findViewById(R.id.iwt);
        MaxHeightRelativelayout maxHeightRelativelayout = (MaxHeightRelativelayout) findViewById(R.id.f166759i15);
        this.f176774m0 = maxHeightRelativelayout;
        maxHeightRelativelayout.setMaxHeight((int) ((getResources().getDisplayMetrics().density * 356.0f) + 0.5d));
        XListView xListView = (XListView) findViewById(R.id.f166757i12);
        this.f176776n0 = xListView;
        xListView.setDivider(getResources().getDrawable(R.drawable.exg));
        XListView xListView2 = (XListView) findViewById(R.id.iwu);
        this.f176784r0 = xListView2;
        xListView2.setEdgeEffectEnabled(false);
        this.f176784r0.setOverScrollMode(2);
        this.f176784r0.setTranscriptMode(2);
        this.f176784r0.setDivider(null);
        this.f176772l0 = (XEditTextEx) findViewById(R.id.dn7);
        this.f176754c0 = (Button) findViewById(R.id.ajg);
        this.f176756d0 = (LSRecordPanel) findViewById(R.id.f166480fi2);
        this.f176752b0 = (RelativeLayout) findViewById(R.id.aga);
        this.f176788t0 = (TextView) findViewById(R.id.i1b);
        this.f176790u0 = (TextView) findViewById(R.id.iwx);
        this.f176772l0.addTextChangedListener(this);
        this.f176754c0.setOnClickListener(this);
        this.f176756d0.v(this.f176792v0, this.f176750a0, this);
        this.f176752b0.setContentDescription(getString(R.string.close));
        this.f176766i0 = (TextView) findViewById(R.id.czy);
        this.f176752b0.setOnClickListener(this);
        this.f176776n0.setEdgeEffectEnabled(false);
        this.f176776n0.setOverScrollMode(2);
        this.f176776n0.setOnItemClickListener(new d());
        k kVar = new k();
        this.f176778o0 = kVar;
        this.f176776n0.setAdapter((ListAdapter) kVar);
        this.f176772l0.setCursorVisible(false);
        this.f176772l0.setOnTouchListener(new e());
        com.tencent.devicelib.a.a(this, this.f176772l0);
        n nVar = new n();
        this.f176782q0 = nVar;
        this.f176784r0.setAdapter((ListAdapter) nVar);
        this.f176784r0.setOnTouchListener(this.F1);
        if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "initUI updateUI");
        }
        updateUI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(16)
    public boolean isKeyguardLock() {
        try {
            if (this.f176789t1 == null) {
                this.f176789t1 = (KeyguardManager) getSystemService("keyguard");
            }
            boolean isKeyguardLocked = this.f176789t1.isKeyguardLocked();
            if (QLog.isColorLevel()) {
                QLog.e("QQLSActivity", 2, "isKeyguardLock=" + isKeyguardLocked);
            }
            return isKeyguardLocked;
        } catch (SecurityException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("QQLSActivity", 2, "kgm.isKeyguardLocked()=" + e16);
                return true;
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k4() {
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "judge need to wake up, now =" + currentTimeMillis + ", firstMsgTime =" + com.tencent.mobileqq.managers.i.f243725f + ", lastWakeUpTime = " + com.tencent.mobileqq.managers.i.f243726h + ", wakeUpTimeAfter30Minute =" + com.tencent.mobileqq.managers.i.f243727i);
        }
        if (com.tencent.mobileqq.managers.i.G) {
            if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, "troop message don't need bright");
            }
            return false;
        }
        if (com.tencent.mobileqq.managers.i.f243725f == 0) {
            com.tencent.mobileqq.managers.i.f243725f = System.currentTimeMillis();
        }
        if (currentTimeMillis < com.tencent.mobileqq.managers.i.f243725f + 1800000) {
            if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, "less than 30min ,need bright");
            }
            com.tencent.mobileqq.managers.i.f243726h = currentTimeMillis;
            com.tencent.mobileqq.managers.i.f243728m = false;
            return true;
        }
        long min = Math.min(6, com.tencent.mobileqq.managers.i.f243727i + 1) * 10 * 60 * 1000;
        if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "has wakeup" + com.tencent.mobileqq.managers.i.f243727i + Element.ELEMENT_NAME_TIMES);
        }
        if (currentTimeMillis > com.tencent.mobileqq.managers.i.f243726h + min) {
            if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, "over wakeuptime ,need bright");
            }
            com.tencent.mobileqq.managers.i.f243728m = true;
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "not bright screen");
        }
        return false;
    }

    private void o4() {
        if (com.tencent.mobileqq.managers.i.H) {
            return;
        }
        com.tencent.mobileqq.utils.ah.p0();
        String b16 = com.tencent.mobileqq.utils.m.b();
        if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "setPhoneNeedBright devicesInfo=== " + b16);
        }
        if (!b16.equalsIgnoreCase("oppo-x907") && !b16.equalsIgnoreCase("samsung-sch-i779") && !b16.equalsIgnoreCase("xiaomi-hm 1sc") && !b16.endsWith("lenovo-lenovo a390t") && !b16.endsWith("xiaomi-2013022") && !b16.endsWith("bbk-vivo x3t") && !b16.endsWith("bbk-vivo y3t") && !b16.endsWith("oppo-r813t") && !b16.endsWith("huawei-huawei t8833") && !b16.equalsIgnoreCase("unknown-K-Touch W619") && !b16.equalsIgnoreCase("COOLPAD-Coolpad 8079") && !b16.endsWith("K-Touch-K-Touch T780") && !b16.endsWith("HTC-HTC T328w") && !b16.endsWith("HUAWEI-HUAWEI U9508")) {
            if (com.tencent.mobileqq.managers.i.b()) {
                return;
            }
            com.tencent.mobileqq.managers.i.H = false;
            return;
        }
        com.tencent.mobileqq.managers.i.H = true;
    }

    private void p4(MessageForPtt messageForPtt) {
        messageForPtt.isReadPtt = true;
        messageForPtt.serial();
        this.f176792v0.getMessageFacade().Y0(messageForPtt.frienduin, messageForPtt.istroop, messageForPtt.uniseq, messageForPtt.msgData);
    }

    private void r4(String str, int i3) {
        this.G1.removeMessages(14);
        if (this.f176760f0 == null) {
            TextView textView = new TextView(this.f176780p0.getContext());
            this.f176760f0 = textView;
            textView.setBackgroundColor(getResources().getColor(R.color.ajr));
            this.f176760f0.setVisibility(0);
            this.f176760f0.setGravity(17);
            float f16 = getResources().getDisplayMetrics().density;
            int i16 = (int) (16.0f * f16);
            int i17 = (int) (32.0f * f16);
            int i18 = (int) (f16 * 240.0f);
            this.f176760f0.setTextSize(0, i16);
            this.f176760f0.setTextColor(-1711276033);
            Rect rect = new Rect();
            this.f176750a0.getGlobalVisibleRect(rect);
            Rect rect2 = new Rect();
            this.f176756d0.getGlobalVisibleRect(rect2);
            int i19 = ((rect2.top - rect.top) - i17) / 2;
            int i26 = ((rect2.right - rect.left) - i18) / 2;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i18, i17);
            layoutParams.addRule(9, -1);
            layoutParams.addRule(10, -1);
            layoutParams.leftMargin = i26;
            layoutParams.topMargin = i19;
            this.f176750a0.addView(this.f176760f0, layoutParams);
        }
        this.f176760f0.setText(str);
        this.f176760f0.setVisibility(0);
        if (i3 > 0) {
            this.G1.sendEmptyMessageDelayed(14, i3);
        }
    }

    private void s4(int i3) {
        this.f176766i0.setVisibility(0);
        if (i3 > 0) {
            this.G1.sendEmptyMessageDelayed(15, i3);
        }
    }

    private void w4() {
        boolean z16;
        String str;
        int i3;
        String str2;
        PhoneContact phoneContact;
        RelativeLayout relativeLayout = this.f176780p0;
        if (relativeLayout != null && this.f176786s0 != null) {
            RelativeLayout relativeLayout2 = (RelativeLayout) relativeLayout.findViewById(R.id.grj);
            TextView textView = (TextView) this.f176780p0.findViewById(R.id.grh);
            TextView textView2 = (TextView) this.f176780p0.findViewById(R.id.grm);
            DragTextView dragTextView = (DragTextView) this.f176780p0.findViewById(R.id.grn);
            dragTextView.setOnModeChangeListener(this.f176777n1);
            dragTextView.setDragViewType(0);
            dragTextView.setTag(1000);
            this.f176780p0.setFocusable(true);
            relativeLayout2.setOnTouchListener(this.F1);
            relativeLayout2.requestLayout();
            RecentBaseData recentBaseData = this.f176786s0;
            if (recentBaseData != null && recentBaseData.getRecentUserType() == 8 && recentBaseData.mExtraType == 25) {
                IPhoneContactService iPhoneContactService = (IPhoneContactService) this.f176792v0.getRuntimeService(IPhoneContactService.class, "");
                if (iPhoneContactService != null) {
                    phoneContact = iPhoneContactService.queryContactByCodeNumber(recentBaseData.mPhoneNumber);
                } else {
                    phoneContact = null;
                }
                if (phoneContact != null) {
                    recentBaseData.mTitleName = phoneContact.name;
                } else {
                    QCallCardInfo c16 = ((com.tencent.mobileqq.qcall.c) this.f176792v0.getManager(QQManagerFactory.QCALLCARD_MANAGER)).c(recentBaseData.getRecentUserUin());
                    if (c16 != null) {
                        recentBaseData.mTitleName = c16.nickname;
                    }
                }
                if (recentBaseData.mTitleName.equals(recentBaseData.getRecentUserUin())) {
                    recentBaseData.mTitleName = recentBaseData.mPhoneNumber;
                }
                if (QLog.isDevelopLevel()) {
                    QLog.d("QQLSActivity", 4, "updateSingleUI mTitleName = " + recentBaseData.mTitleName);
                }
            }
            textView.setText(recentBaseData.mTitleName);
            textView2.setText(recentBaseData.mShowTime);
            if (recentBaseData.getRecentUserType() != 7000 && recentBaseData.getRecentUserType() != 4000 && recentBaseData.getRecentUserType() != 1001 && recentBaseData.getRecentUserType() != 10002 && recentBaseData.getRecentUserType() != 1010 && recentBaseData.getRecentUserType() != 1012 && recentBaseData.getRecentUserType() != 1030 && recentBaseData.getRecentUserType() != 9002 && recentBaseData.getRecentUserType() != 9501 && recentBaseData.getRecentUserType() != 7432 && recentBaseData.getRecentUserType() != 9653 && recentBaseData.getRecentUserType() != 7220 && ((recentBaseData.getRecentUserType() != 1008 || !AppConstants.KANDIAN_DAILY_UIN.equals(recentBaseData.getRecentUserUin())) && ((recentBaseData.getRecentUserType() != 1008 || !AppConstants.NEW_KANDIAN_UIN.equals(recentBaseData.getRecentUserUin())) && recentBaseData.getRecentUserType() != 1032 && recentBaseData.getRecentUserType() != 1035 && recentBaseData.getRecentUserType() != 1041 && recentBaseData.getRecentUserType() != 1042 && recentBaseData.getRecentUserType() != 10007))) {
                this.f176780p0.findViewById(R.id.dmk).setVisibility(0);
                z16 = true;
            } else {
                this.f176780p0.findViewById(R.id.dmk).setVisibility(8);
                z16 = false;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, "updateSingleUI type=" + recentBaseData.getRecentUserType());
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) dragTextView.getLayoutParams();
            if (recentBaseData.getRecentUserType() != 1012 && recentBaseData.getRecentUserType() != 1030 && recentBaseData.getRecentUserType() != 7432 && recentBaseData.getRecentUserType() != 9653 && recentBaseData.getRecentUserType() != 1035) {
                layoutParams.topMargin = 0;
                this.f176780p0.findViewById(R.id.grj).setVisibility(0);
            } else {
                this.f176780p0.findViewById(R.id.grj).setVisibility(8);
                layoutParams.topMargin = (int) (this.f176785r1 * 18.0f);
            }
            String recentUserUin = this.f176786s0.getRecentUserUin();
            RecentBaseData recentBaseData2 = this.f176786s0;
            if (recentBaseData2 instanceof RecentUserBaseData) {
                str = ((RecentUserBaseData) recentBaseData2).e();
            } else {
                str = recentUserUin;
            }
            int recentUserType = this.f176786s0.getRecentUserType();
            if (recentUserType == 1030 && (this.f176786s0 instanceof RecentItemNoticeData)) {
                k.a aVar = new k.a();
                aVar.f290023e = "0X800923E";
                aVar.f290022d = "Android\u9501\u5c4f\u5f39\u7a97";
                com.tencent.mobileqq.statistics.k.b(((RecentItemNoticeData) this.f176786s0).url, aVar);
                com.tencent.mobileqq.statistics.k.d(this.f176792v0, aVar);
            } else if (f4(recentUserType)) {
                RecentBaseData recentBaseData3 = this.f176786s0;
                if (recentBaseData3 instanceof RecentItemNoticeData) {
                    Intent intent = ((RecentItemNoticeData) recentBaseData3).intent;
                    PushNoticeManager.h(this.f176792v0, intent.getStringExtra("push_notice_service_id"), intent.getStringExtra("push_notice_content_id"), ((RecentItemNoticeData) this.f176786s0).url, "0X800923E", "Android\u9501\u5c4f\u5f39\u7a97");
                }
            }
            List<MessageRecord> U3 = U3(recentUserUin, recentUserType);
            if (U3 != null && U3.size() != 0) {
                String str3 = recentBaseData.mShowTime;
                boolean z17 = z16;
                long j3 = recentBaseData.mDisplayTime;
                int i16 = 0;
                while (i16 < U3.size()) {
                    if (U3.get(i16).msgtype == -2009 && U3.get(i16).time > j3) {
                        j3 = U3.get(i16).time;
                        str2 = str;
                        str3 = com.tencent.mobileqq.activity.recent.o.c().d(U3.get(i16).frienduin, U3.get(i16).time);
                    } else {
                        str2 = str;
                    }
                    i16++;
                    str = str2;
                }
                recentBaseData.mDisplayTime = j3;
                textView2.setText(str3);
                this.f176782q0.c(U3);
                this.f176756d0.M(recentUserUin, recentUserType, str);
                this.f176784r0.setSelection(this.f176782q0.getCount() - 1);
                int gesturePWDState = BaseGesturePWDUtil.getGesturePWDState(this, this.f176792v0.getCurrentAccountUin());
                if (QLog.isColorLevel()) {
                    i3 = 2;
                    QLog.d("QQLSActivity", 2, "set mGesturePasswordState=" + gesturePWDState);
                } else {
                    i3 = 2;
                }
                if (gesturePWDState == i3) {
                    this.f176780p0.findViewById(R.id.dmk).setVisibility(8);
                    z17 = false;
                }
                if (z17) {
                    this.f176750a0.f261224d = this.f176756d0;
                    if (com.tencent.mobileqq.ptt.i.c(this.f176792v0)) {
                        s4(-1);
                        this.f176768j0 = true;
                        com.tencent.mobileqq.ptt.i.a(this.f176792v0);
                    } else if (this.f176768j0) {
                        K3();
                    }
                } else {
                    this.f176750a0.f261224d = null;
                }
                if (recentBaseData.getRecentUserType() == 4000) {
                    com.tencent.widget.d.b(dragTextView, 3, recentBaseData.mUnreadNum, 0);
                    return;
                }
                if (recentBaseData.getRecentUserType() != 1001 && recentBaseData.getRecentUserType() != 1010 && recentBaseData.getRecentUserType() != 10002) {
                    if (recentBaseData.getRecentUserType() == 7000) {
                        com.tencent.widget.d.b(dragTextView, 3, this.f176792v0.getConversationFacade().R(recentBaseData.getRecentUserUin(), recentBaseData.getRecentUserType()), 0);
                        return;
                    }
                    if (recentBaseData.getRecentUserType() == 1032) {
                        com.tencent.widget.d.b(dragTextView, 3, this.f176792v0.getConversationFacade().R(recentBaseData.getRecentUserUin(), recentBaseData.getRecentUserType()), 0);
                        return;
                    }
                    int size = U3.size();
                    Iterator<MessageRecord> it = U3.iterator();
                    while (it.hasNext()) {
                        if (com.tencent.mobileqq.graytip.f.e(it.next())) {
                            size--;
                        }
                    }
                    com.tencent.widget.d.b(dragTextView, 3, size, 0);
                    return;
                }
                com.tencent.widget.d.b(dragTextView, 3, this.f176792v0.getConversationFacade().R(this.f176792v0.getMessageFacade().getLastMessage(recentBaseData.getRecentUserUin(), recentBaseData.getRecentUserType()).senderuin, recentBaseData.getRecentUserType()), 0);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e("QQLSActivity", 2, "LSActivity mSingleAdapter size =0 finish" + Thread.currentThread().getId());
            }
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x4() {
        if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "updateUI thread" + Thread.currentThread().getId());
        }
        if (!this.f176779o1) {
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        boolean z16 = true;
        if (this.f176780p0.getVisibility() == 8) {
            try {
                inputMethodManager.hideSoftInputFromWindow(this.f176772l0.getWindowToken(), 0);
            } catch (Throwable th5) {
                QLog.d("QQLSActivity", 1, "updateUI error: " + th5.getMessage());
            }
        }
        ArrayList<RecentBaseData> arrayList = new ArrayList<>(this.f176775m1.d());
        if (arrayList.size() == 0) {
            if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, "recentBaseData size = 0,  finish" + Thread.currentThread().getId());
            }
            finish();
            if ((getIntent().getFlags() & 1048576) != 0) {
                Intent intent = new Intent();
                intent.setComponent(SplashActivity.getAliasComponent(this));
                intent.setFlags(67108864);
                intent.putExtra("tab_index", com.tencent.mobileqq.activity.home.impl.a.f183038a);
                intent.putExtra(SplashActivity.FRAGMENT_ID, 1);
                startActivity(intent);
            }
        }
        if (arrayList.size() == 1) {
            this.f176750a0.f261224d = this.f176756d0;
            this.f176776n0.setVisibility(8);
            if (this.f176780p0.getVisibility() == 8) {
                MediaPlayerManager.q(this.f176792v0).D(false);
                MediaPlayerManager.q(this.f176792v0).G(this.f176776n0);
                MediaPlayerManager.q(this.f176792v0).m(this.f176784r0, this.f176782q0, this, this, true, false);
            }
            this.f176780p0.setVisibility(0);
            this.f176786s0 = arrayList.get(0);
            w4();
        } else {
            this.f176750a0.f261224d = null;
            inputMethodManager.hideSoftInputFromWindow(this.f176772l0.getWindowToken(), 0);
            if (this.f176780p0.getVisibility() == 0) {
                MediaPlayerManager.q(this.f176792v0).D(false);
                MediaPlayerManager.q(this.f176792v0).G(this.f176784r0);
                MediaPlayerManager.q(this.f176792v0).m(this.f176776n0, this.f176778o0, this, this, false, false);
            }
            ChatMessage s16 = MediaPlayerManager.q(this.f176792v0).s();
            if (s16 != null) {
                Iterator<RecentBaseData> it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    RecentBaseData next = it.next();
                    com.tencent.imcore.message.Message lastMessage = this.f176792v0.getMessageFacade().getLastMessage(next.getRecentUserUin(), next.getRecentUserType());
                    if (lastMessage.uniseq == s16.uniseq && lastMessage.istroop == s16.istroop) {
                        z16 = false;
                        break;
                    }
                }
                if (z16) {
                    MediaPlayerManager.q(this.f176792v0).D(false);
                }
            }
            this.f176780p0.setVisibility(8);
            this.f176776n0.setVisibility(0);
            this.f176778o0.d(arrayList);
        }
        this.f176795w1 = SystemClock.uptimeMillis();
        this.G1.sendMessageDelayed(this.G1.obtainMessage(12), 350L);
        this.D0 = false;
        ReportController.o(this.f176792v0, "CliOper", "", "", "0X80040DA", "0X80040DA", 0, 0, "" + arrayList.size(), "", "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y4() {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "go to wakeUpScreen==========================");
        }
        if (k4()) {
            com.tencent.mobileqq.utils.dd ddVar = this.f176761f1;
            if (ddVar == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQLSActivity", 2, "wakeUpScreen proximitySensor=null");
                }
                G3();
                return;
            }
            if (ddVar != null && ddVar.f307622f) {
                if (com.tencent.mobileqq.managers.i.H) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QQLSActivity", 2, "some phone need to bright early");
                    }
                    G3();
                    return;
                }
                if (this.f176767i1) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QQLSActivity", 2, "wakeUpScreen sensorIsClose  firstTimeToWakeScreen acquireWakeLock");
                    }
                    H3();
                    ReportController.o(this.f176792v0, "CliOper", "", "", "0X8004779", "0X8004779", 0, 0, "", "", "", "");
                    return;
                }
                if (this.f176763g1) {
                    H3();
                    if (QLog.isColorLevel()) {
                        QLog.d("QQLSActivity", 2, "wakeUpScreen sensorIsClose acquireWakeLock");
                    }
                    ReportController.o(this.f176792v0, "CliOper", "", "", "0X8004779", "0X8004779", 0, 0, "", "", "", "");
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("QQLSActivity", 2, "wakeUpScreen acquireBrightWakeLock");
                }
                G3();
                return;
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("wakeUpScreen hasSensor=");
                com.tencent.mobileqq.utils.dd ddVar2 = this.f176761f1;
                if (ddVar2 != null) {
                    z16 = ddVar2.f307622f;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                QLog.d("QQLSActivity", 2, sb5.toString());
            }
            ReportController.o(this.f176792v0, "CliOper", "", "", "0X800477A", "0X800477A", 0, 0, "", "", "", "");
            G3();
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.MediaPlayerManager.b
    public boolean A2(XListView xListView, int i3, View view, ChatMessage chatMessage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, this, xListView, Integer.valueOf(i3), view, chatMessage)).booleanValue();
        }
        MessageForPtt messageForPtt = (MessageForPtt) chatMessage;
        if (!messageForPtt.isSend() && !messageForPtt.isReadPtt && messageForPtt.isReady()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.aio.MediaPlayerManager.b
    public boolean L1(XListView xListView, int i3, View view, ChatMessage chatMessage, AudioPlayerBase audioPlayerBase, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 4;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, this, xListView, Integer.valueOf(i3), view, chatMessage, audioPlayerBase, Integer.valueOf(i16))).booleanValue();
        }
        if (audioPlayerBase == null) {
            return false;
        }
        MessageForPtt messageForPtt = (MessageForPtt) chatMessage;
        ((IPTTPreDownloader) this.f176792v0.getRuntimeService(IPTTPreDownloader.class)).onPlayPTT(messageForPtt);
        if (messageForPtt.isReady()) {
            Object A = com.tencent.mobileqq.activity.aio.l.A(view);
            if (A == null || !(A instanceof o)) {
                return false;
            }
            o oVar = (o) A;
            audioPlayerBase.C(6);
            if (audioPlayerBase.u(messageForPtt.getLocalFilePath())) {
                p4(messageForPtt);
                if (oVar != null) {
                    t4(oVar, messageForPtt, com.tencent.mobileqq.activity.aio.item.n.f(this.f176792v0, messageForPtt), true);
                }
                PttInfoCollector.reportPttPlay(this.f176792v0, messageForPtt.istroop, messageForPtt.issend);
                if (!messageForPtt.isSendFromLocal()) {
                    int i18 = messageForPtt.istroop;
                    if (i18 == 0) {
                        i17 = 1;
                    } else if (i18 == 1) {
                        i17 = 3;
                    } else if (i18 == 3000) {
                        i17 = 2;
                    }
                    IPttInfoCollector iPttInfoCollector = (IPttInfoCollector) QRoute.api(IPttInfoCollector.class);
                    QQAppInterface qQAppInterface = this.f176792v0;
                    if (chatMessage.getPttStreamFlag() == 10001) {
                        z16 = true;
                    }
                    iPttInfoCollector.reportPTTPV(qQAppInterface, i17, z16, 1);
                }
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, "play failed player return false " + messageForPtt.getLocalFilePath());
            }
        } else if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "play failed not ready " + messageForPtt.getLocalFilePath());
        }
        return false;
    }

    protected void M3(o.a aVar, MessageForPtt messageForPtt, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, aVar, messageForPtt, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (!z16) {
            i3 = 7;
        }
        ChatActivityFacade.O(this.f176792v0, messageForPtt.frienduin, messageForPtt, false, i3, 0, z17);
    }

    public List<MessageRecord> R3(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (List) iPatchRedirector.redirect((short) 16, (Object) this, (Object) str, i3);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<MessageRecord> arrayList2 = this.f176783q1;
        if (arrayList2 != null && arrayList2.size() != 0) {
            Iterator<MessageRecord> it = this.f176783q1.iterator();
            while (it.hasNext()) {
                MessageRecord next = it.next();
                if (next.frienduin.equals(str) && next.istroop == i3) {
                    arrayList.add(next);
                }
            }
            Collections.sort(arrayList, this.A1);
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.ptt.LSRecordPanel.f
    public void T1(boolean z16, boolean z17, LSRecordPanel lSRecordPanel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, this, Boolean.valueOf(z16), Boolean.valueOf(z17), lSRecordPanel);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("QQLSActivity", 4, "handleRecording been called !!!!");
        }
        this.f176779o1 = false;
        if (this.f176780p0.getVisibility() == 0) {
            if (z16) {
                r4(HardCodeUtil.qqStr(R.string.qud), -1);
                return;
            } else {
                if (z17) {
                    r4(HardCodeUtil.qqStr(R.string.que), -1);
                    return;
                }
                return;
            }
        }
        J3(false);
    }

    public int X3(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Integer) iPatchRedirector.redirect((short) 40, (Object) this, (Object) str, i3)).intValue();
        }
        return this.f176781p1.t(str, i3);
    }

    @Override // com.tencent.mobileqq.activity.aio.MediaPlayerManager.b
    public boolean Y(ChatMessage chatMessage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, (Object) chatMessage)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.activity.aio.MediaPlayerManager.c
    public void Z5(int i3) {
        com.tencent.mobileqq.widget.bq bqVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, i3);
            return;
        }
        if (isFinishing()) {
            return;
        }
        if (i3 == 0) {
            ReportController.o(this.f176792v0, "CliOper", "", "", "0X800484E", "0X800484E", 0, 0, "", "", "", "");
            this.f176793v1.removeMessages(25);
            com.tencent.mobileqq.widget.bq bqVar2 = this.B1;
            if (bqVar2 == null || !bqVar2.isShowing()) {
                com.tencent.mobileqq.widget.bq bqVar3 = new com.tencent.mobileqq.widget.bq(this);
                this.B1 = bqVar3;
                bqVar3.N(getString(R.string.f7t));
                this.B1.show();
                return;
            }
            return;
        }
        if (i3 == 1 && (bqVar = this.B1) != null && bqVar.isShowing() && this.B1.getWindow() != null) {
            this.B1.dismiss();
        }
    }

    @Override // com.tencent.mobileqq.ptt.LSRecordPanel.f
    public void a1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this);
            return;
        }
        if (this.f176758e0 == null) {
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.6f, 0.0f);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.mobileqq.activity.QQLSActivity.17
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLSActivity.this);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this, (Object) animation);
                } else if (QQLSActivity.this.f176758e0 != null) {
                    QQLSActivity.this.G1.post(new Runnable() { // from class: com.tencent.mobileqq.activity.QQLSActivity.17.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass17.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            } else {
                                QQLSActivity.this.f176750a0.removeView(QQLSActivity.this.f176758e0);
                                QQLSActivity.this.f176758e0 = null;
                            }
                        }
                    });
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) animation);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) animation);
                }
            }
        });
        this.f176758e0.startAnimation(alphaAnimation);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this, (Object) editable);
        } else if (editable.length() > 0) {
            this.f176756d0.setVisibility(4);
            this.f176754c0.setVisibility(0);
        } else {
            this.f176756d0.setVisibility(0);
            this.f176754c0.setVisibility(4);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // com.tencent.mobileqq.ptt.LSRecordPanel.f
    public void d0(boolean z16, int i3, String str, boolean z17, boolean z18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z19 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, this, Boolean.valueOf(z16), Integer.valueOf(i3), str, Boolean.valueOf(z17), Boolean.valueOf(z18));
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("QQLSActivity", 4, "exitRecord been called !!!!");
        }
        if (z16) {
            F3();
            this.f176779o1 = true;
        } else {
            if (z17) {
                int i16 = this.f176770k0 + 1;
                this.f176770k0 = i16;
                if (i16 >= 3 && com.tencent.mobileqq.ptt.i.d(this.f176792v0)) {
                    s4(2000);
                    com.tencent.mobileqq.ptt.i.b(this.f176792v0);
                    this.f176770k0 = 0;
                }
            } else if (str != null) {
                r4(str, 2000);
                z19 = true;
            }
            this.f176779o1 = true;
            if (!this.f176762g0) {
                updateUI();
            } else {
                this.f176764h0 = true;
            }
        }
        if (!z19) {
            J3(z18);
        }
    }

    @Override // com.tencent.mobileqq.ptt.LSRecordPanel.f
    public void d2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this);
            return;
        }
        if (this.f176758e0 != null) {
            return;
        }
        if (MediaPlayerManager.q(this.f176792v0).t()) {
            MediaPlayerManager.q(this.f176792v0).D(true);
        }
        View view = new View(this.f176750a0.getContext());
        view.setBackgroundColor(-16777216);
        view.setVisibility(0);
        Rect rect = new Rect();
        this.f176750a0.getGlobalVisibleRect(rect);
        Rect rect2 = new Rect();
        this.f176756d0.getGlobalVisibleRect(rect2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(rect2.right - rect.left, rect2.top - rect.top);
        layoutParams.addRule(9, -1);
        layoutParams.addRule(10, -1);
        this.f176750a0.addView(view, layoutParams);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.6f);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setDuration(300L);
        view.startAnimation(alphaAnimation);
        this.f176758e0 = view;
    }

    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            z16 = ((Boolean) iPatchRedirector.redirect((short) 47, (Object) this, (Object) motionEvent)).booleanValue();
        } else {
            if (this.f176766i0 != null && this.f176768j0) {
                this.f176768j0 = false;
                K3();
            }
            try {
                z16 = super.dispatchTouchEvent(motionEvent);
            } catch (IllegalArgumentException e16) {
                QLog.e("QQLSActivity", 1, e16, new Object[0]);
                z16 = false;
                EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, z16, false);
                return z16;
            } catch (IndexOutOfBoundsException e17) {
                QLog.e("QQLSActivity", 1, e17, new Object[0]);
                z16 = false;
                EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, z16, false);
                return z16;
            }
        }
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, z16, false);
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "onBackPressed=== ");
        }
        I3();
        F3();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        super.doOnCreate(bundle);
        com.tencent.mobileqq.managers.i.F = true;
        this.f176795w1 = -1L;
        com.tencent.qqperf.monitor.crash.tools.b.f(this);
        if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "qqls dooncreate");
        }
        super.setContentView(R.layout.awc);
        getWindow().addFlags(524288);
        this.f176785r1 = getResources().getDisplayMetrics().scaledDensity;
        if (!com.tencent.mobileqq.managers.i.G) {
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.QQLSActivity.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLSActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    QQLSActivity qQLSActivity = QQLSActivity.this;
                    qQLSActivity.f176761f1 = new com.tencent.mobileqq.utils.dd(qQLSActivity.getApplicationContext(), QQLSActivity.this);
                    QQLSActivity.this.f176761f1.f();
                }
            });
        }
        this.G1.sendMessageDelayed(this.G1.obtainMessage(7), 1000L);
        QQAppInterface qQAppInterface = (QQAppInterface) getAppRuntime();
        this.f176792v0 = qQAppInterface;
        this.f176781p1 = (com.tencent.mobileqq.qcall.f) qQAppInterface.getManager(QQManagerFactory.RECENT_CALL_FACADE);
        this.f176794w0 = (IPhoneContactService) this.f176792v0.getRuntimeService(IPhoneContactService.class);
        this.f176773l1 = (ISubAccountService) this.f176792v0.getRuntimeService(ISubAccountService.class, "");
        if (l4()) {
            if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, "doOncreate noNeedStart return");
            }
            return true;
        }
        this.f176783q1 = this.f176781p1.s();
        this.f176775m1 = (com.tencent.mobileqq.managers.i) this.f176792v0.getManager(QQManagerFactory.QQLS_DATA_MANAGER);
        com.tencent.mobileqq.managers.i.J = false;
        initUI();
        this.f176792v0.addObserver(this.E1);
        this.f176792v0.addObserver(this.C1);
        INewFriendService iNewFriendService = (INewFriendService) this.f176792v0.getRuntimeService(INewFriendService.class);
        this.f176771k1 = iNewFriendService;
        if (iNewFriendService != null) {
            iNewFriendService.addListener(this.D1);
            this.f176771k1.addObserver(this);
        }
        DragFrameLayout e16 = DragFrameLayout.e(this);
        this.f176777n1 = e16;
        e16.addOnDragModeChangeListener(this, false);
        this.f176787s1 = new m();
        n4();
        this.f176792v0.getMessageFacade().addObserver(this);
        a4();
        this.f176767i1 = true;
        o4();
        y4();
        ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).setLSAccountDetailRequestHandler(this.G1);
        g4(getIntent());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        QQAppInterface qQAppInterface = this.f176792v0;
        if (qQAppInterface != null) {
            MediaPlayerManager.q(qQAppInterface).G(this.f176784r0);
            MediaPlayerManager.q(this.f176792v0).G(this.f176776n0);
            K1.clear();
            this.f176797x1 = true;
            ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).setLSAccountDetailRequestHandler(null);
            if (this.f176792v0.getMessageFacade() != null) {
                this.f176792v0.getMessageFacade().deleteObserver(this);
            }
            this.f176792v0.removeObserver(this.E1);
            this.f176792v0.removeObserver(this.C1);
        }
        com.tencent.mobileqq.managers.i.I = false;
        com.tencent.mobileqq.managers.i.F = false;
        com.tencent.mobileqq.managers.i.J = false;
        com.tencent.mobileqq.managers.i.M = false;
        INewFriendService iNewFriendService = this.f176771k1;
        if (iNewFriendService != null) {
            iNewFriendService.removeListener(this.D1);
            this.f176771k1.deleteObserver(this);
        }
        Handler handler = this.G1;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        u4();
        if (this.f176787s1 != null) {
            v4();
        }
        this.f176776n0.setOnItemClickListener(null);
        super.doOnDestroy();
        J3(false);
        com.tencent.qqperf.monitor.crash.tools.b.g(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) intent);
            return;
        }
        super.doOnNewIntent(intent);
        if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "doOnNewIntent intent is not null");
        }
        com.tencent.mobileqq.managers.i.M = false;
        com.tencent.mobileqq.managers.i.F = true;
        this.f176795w1 = -1L;
        ArrayList<MessageRecord> arrayList = this.f176783q1;
        if (arrayList != null) {
            arrayList.clear();
        }
        com.tencent.mobileqq.qcall.f fVar = this.f176781p1;
        if (fVar != null) {
            this.f176783q1 = fVar.s();
        }
        if (!l4()) {
            a4();
            if (this.G1.hasMessages(13)) {
                this.G1.removeMessages(13);
            }
            updateUI();
        }
        g4(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.doOnPause();
        com.tencent.qqperf.monitor.crash.tools.b.h(this);
        this.mRuntime.isBackgroundPause = true;
        com.tencent.mobileqq.managers.i.I = false;
        if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "onPause,isbackground_pause : true");
        }
        this.f176756d0.onPause();
        this.f176762g0 = true;
        if (this.G1.hasMessages(8)) {
            this.G1.removeMessages(8);
        }
        this.G1.sendMessageDelayed(this.G1.obtainMessage(8), 1500L);
        Q3();
        MediaPlayerManager.q(this.f176792v0).D(true);
        if (this.f176780p0.getVisibility() == 0) {
            MediaPlayerManager.q(this.f176792v0).G(this.f176784r0);
        } else {
            MediaPlayerManager.q(this.f176792v0).G(this.f176776n0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.doOnResume();
        if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "doOnResume taskId" + getTaskId());
        }
        com.tencent.mobileqq.managers.i.M = false;
        com.tencent.qqperf.monitor.crash.tools.b.i(this);
        com.tencent.mobileqq.managers.i.I = true;
        this.mRuntime.isBackgroundPause = true;
        if (this.f176772l0 != null) {
            ((InputMethodManager) getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(this.f176772l0.getWindowToken(), 0);
        }
        this.G1.sendMessageDelayed(this.G1.obtainMessage(11), 500L);
        this.f176762g0 = false;
        if (this.f176764h0) {
            this.f176764h0 = false;
            updateUI();
        }
        if (this.f176780p0.getVisibility() == 0) {
            MediaPlayerManager.q(this.f176792v0).m(this.f176784r0, this.f176782q0, this, this, true, false);
        } else {
            MediaPlayerManager.q(this.f176792v0).m(this.f176776n0, this.f176778o0, this, this, false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.doOnStop();
        com.tencent.mobileqq.managers.i.F = false;
        com.tencent.mobileqq.managers.i.I = false;
        if (this.f176772l0 != null) {
            ((InputMethodManager) getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(this.f176772l0.getWindowToken(), 0);
        }
        if (this.G1.hasMessages(8)) {
            this.G1.removeMessages(8);
        }
        u4();
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.CommonAudioPlayer.a
    public void e(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        if (isResume()) {
            com.tencent.mobileqq.activity.aio.audiopanel.b.a(this.f176792v0.getApp(), z17, false, false);
        }
        this.f176791u1 = z17;
    }

    protected boolean e4(ChatMessage chatMessage) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, (Object) chatMessage)).booleanValue();
        }
        ChatMessage s16 = MediaPlayerManager.q(this.f176792v0).s();
        if (s16 != chatMessage && (!(s16 instanceof MessageForPtt) || (str = s16.frienduin) == null || !str.equals(chatMessage.frienduin) || s16.uniseq != chatMessage.uniseq)) {
            return false;
        }
        return true;
    }

    @Override // android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        TouchProxyRelativeLayout touchProxyRelativeLayout = this.f176750a0;
        if (touchProxyRelativeLayout != null) {
            try {
                touchProxyRelativeLayout.setVisibility(4);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("QQLSActivity", 2, e16, new Object[0]);
                }
            }
        }
        com.tencent.mobileqq.managers.i iVar = this.f176775m1;
        if (iVar != null) {
            com.tencent.mobileqq.managers.i.I = false;
        }
        if (iVar != null) {
            iVar.a();
        }
        if (QLog.isColorLevel()) {
            QLog.e("QQLSActivity", 2, "LSActivity finish");
        }
        try {
            super.finish();
        } catch (Exception e17) {
            QLog.e("QQLSActivity", 2, e17, new Object[0]);
        }
    }

    public void h4(List<MessageRecord> list, List<MessageRecord> list2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, list, list2, Integer.valueOf(i3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "mergeSortList miscalllist size: " + list2.size());
        }
        list.addAll(list2);
        Collections.sort(list, this.A1);
    }

    @Override // com.tencent.mobileqq.activity.aio.r
    public void handleMessage(View view, FileMsg fileMsg, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, this, view, fileMsg, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (fileMsg.fileType != 2 || i3 == 2002 || i3 == 1002 || i3 == 2001) {
            return;
        }
        o oVar = (o) view.getTag();
        MessageForPtt messageForPtt = (MessageForPtt) oVar.f180131a;
        if (messageForPtt == null || messageForPtt.uniseq != fileMsg.uniseq) {
            return;
        }
        if (i3 != 1003 && i3 != 2003) {
            int i17 = fileMsg.status;
            if (i17 != 1005 && i17 != 1004) {
                long j3 = messageForPtt.fileSize;
                if (j3 == -2) {
                    i3 = 999;
                } else if (j3 == -3) {
                    i3 = 1001;
                } else if (j3 == -1) {
                    i3 = 1005;
                } else if (i3 == 2005) {
                    messageForPtt.fileSize = -4L;
                }
            } else {
                notifyDataSetChanged();
            }
        } else if (!fileMsg.isStreamMode && i3 == 2003) {
            notifyDataSetChanged();
        }
        if (QLog.isColorLevel()) {
            QLog.d("PTTItem->handleMessage", 2, "fileStatus:" + i3 + "|url " + messageForPtt.url + "|uniseq " + messageForPtt.uniseq);
        }
        t4(oVar, messageForPtt, i3, e4(messageForPtt));
    }

    @Override // com.tencent.mobileqq.activity.aio.MediaPlayerManager.c, com.tencent.mobileqq.qqaudio.audioplayer.CommonAudioPlayer.a
    public void k(boolean z16, boolean z17, boolean z18, boolean z19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, Boolean.valueOf(z16), Boolean.valueOf(z17), Boolean.valueOf(z18), Boolean.valueOf(z19));
            return;
        }
        if (isResume()) {
            com.tencent.mobileqq.activity.aio.audiopanel.b.a(this.f176792v0.getApp(), z18, z16, z17);
        }
        this.f176791u1 = z18;
    }

    @Override // com.tencent.mobileqq.activity.aio.MediaPlayerManager.b
    public void l(XListView xListView, int i3, View view, ChatMessage chatMessage, long j3, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, xListView, Integer.valueOf(i3), view, chatMessage, Long.valueOf(j3), Float.valueOf(f16));
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.MediaPlayerManager.c
    public void l1(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, i3);
        } else {
            setVolumeControlStream(3);
        }
    }

    public boolean l4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (this.f176792v0 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, "app null,  finish");
            }
            finish();
            return true;
        }
        if (this.f176781p1 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, "rcf null,  finish");
            }
            finish();
            return true;
        }
        if (this.f176794w0.shouldBlockMessageTips()) {
            if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, "pcm should block app");
            }
            finish();
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.aio.MediaPlayerManager.b
    public void m(XListView xListView, int i3, View view, ChatMessage chatMessage, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, xListView, Integer.valueOf(i3), view, chatMessage, Boolean.valueOf(z16));
            return;
        }
        if (view != null) {
            Object A = com.tencent.mobileqq.activity.aio.l.A(view);
            if (A instanceof o) {
                MessageForPtt messageForPtt = (MessageForPtt) chatMessage;
                t4((o) A, messageForPtt, com.tencent.mobileqq.activity.aio.item.n.f(this.f176792v0, messageForPtt), false);
            }
        }
    }

    protected void m4(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) view);
            return;
        }
        MessageForPtt messageForPtt = (MessageForPtt) com.tencent.mobileqq.activity.aio.l.C(view);
        o oVar = (o) com.tencent.mobileqq.activity.aio.l.A(view);
        if (messageForPtt.isSendFromLocal()) {
            ActionSheet create = ActionSheet.create(this);
            create.setMainTitle(R.string.l_);
            create.addButton(R.string.f170283l9);
            create.addCancelButton(R.string.cancel);
            create.setOnButtonClickListener(new h(messageForPtt, create));
            create.show();
            return;
        }
        if (Environment.getExternalStorageState().equals("mounted") && new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() >= 1) {
            M3(oVar, messageForPtt, true, false);
            if (QLog.isColorLevel()) {
                QLog.d("PTTItem->onErrorIconClick", 2, "fileStatus:2001|url " + messageForPtt.url + "|uniseq " + messageForPtt.uniseq);
            }
            t4(oVar, messageForPtt, 2001, false);
            return;
        }
        if (!Environment.getExternalStorageState().equals("mounted")) {
            QQToast.makeText(BaseApplication.getContext(), R.string.ck6, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        } else {
            QQToast.makeText(BaseApplication.getContext(), R.string.h9z, 0).show(BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        }
    }

    public void n4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this);
        } else {
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.activity.QQLSActivity.15
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLSActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_ON);
                        intentFilter.addAction(IECScreenReceiver.ACTION_SCREEN_OFF);
                        intentFilter.addAction("android.intent.action.USER_PRESENT");
                        if (QQLSActivity.this.H1 == 0) {
                            BaseApplication.getContext().registerReceiver(QQLSActivity.this.f176787s1, intentFilter);
                            if (QLog.isColorLevel()) {
                                QLog.d("QQLSActivity", 2, "registerScreenListener real mScreenReceiver:" + QQLSActivity.this.f176787s1.hashCode() + "context :" + BaseApplication.getContext().hashCode());
                            }
                            QQLSActivity.this.H1 = 1;
                        }
                        QQLSActivity qQLSActivity = QQLSActivity.this;
                        qQLSActivity.E0 = AnimationUtils.loadAnimation(qQLSActivity, R.anim.f154938fa);
                        QQLSActivity.this.E0.setFillAfter(true);
                        if (QLog.isColorLevel()) {
                            QLog.d("QQLSActivity", 2, "registerScreenListener");
                        }
                    } catch (Exception e16) {
                        e16.printStackTrace();
                        if (QLog.isColorLevel()) {
                            QLog.e("QQLSActivity", 2, "registerScreenListener:" + e16.toString());
                        }
                    }
                }
            }, true);
        }
    }

    public void notifyDataSetChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this);
            return;
        }
        n nVar = this.f176782q0;
        if (nVar != null) {
            nVar.notifyDataSetChanged();
        }
        k kVar = this.f176778o0;
        if (kVar != null) {
            kVar.notifyDataSetChanged();
        }
    }

    @Override // com.tencent.mobileqq.quibadge.QUIBadgeDragLayout.OnDragModeChangedListener
    public void onChange(boolean z16, int i3, QUIBadgeDragLayout qUIBadgeDragLayout) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, this, Boolean.valueOf(z16), Integer.valueOf(i3), qUIBadgeDragLayout);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "onChange isDone " + z16);
            QLog.d("QQLSActivity", 2, "onChange mDragHost.getMode() " + this.f176777n1.getMode());
        }
        if (z16) {
            View dragView = qUIBadgeDragLayout.getDragView();
            if (dragView != null && dragView.getTag() != null) {
                int intValue = ((Integer) dragView.getTag()).intValue();
                if (QLog.isColorLevel()) {
                    QLog.d("QQLSActivity", 2, "delete onChange position=" + intValue);
                }
                if (intValue != 1000) {
                    if (this.f176778o0.f176822d.size() <= intValue) {
                        return;
                    }
                    int recentUserType = ((RecentBaseData) this.f176778o0.f176822d.get(intValue)).getRecentUserType();
                    String recentUserUin = ((RecentBaseData) this.f176778o0.f176822d.get(intValue)).getRecentUserUin();
                    RecentUtil.I0(this.f176792v0, recentUserUin, recentUserType);
                    if (recentUserType == 1001 || recentUserType == 1010 || recentUserType == 10002) {
                        ((MessageHandler) this.f176792v0.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).Y4(recentUserUin, recentUserType, false);
                        this.f176792v0.getMessageFacade().f116353m.removeNotificationMsgByUinType(recentUserType);
                    } else if (recentUserType == 4000) {
                        this.f176771k1.markAllDataReaded();
                        this.f176792v0.getMessageFacade().f116353m.removeNotification(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0);
                        this.f176792v0.getMessageFacade().f116353m.removeNotification(AppConstants.RECOMMEND_CONTACT_UIN, 4000);
                    } else if (recentUserType == 7000) {
                        ((MessageHandler) this.f176792v0.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).l3().Y0(recentUserUin, null);
                        ISubAccountService iSubAccountService = (ISubAccountService) this.f176792v0.getRuntimeService(ISubAccountService.class, "");
                        if (iSubAccountService != null) {
                            iSubAccountService.setAllMessageReaded(recentUserUin);
                        }
                    } else if (recentUserType == 1012) {
                        com.tencent.mobileqq.dating.d dVar = (com.tencent.mobileqq.dating.d) this.f176792v0.getManager(QQManagerFactory.DATING_PROXY_MANAGER);
                        if (dVar != null) {
                            dVar.b().h();
                        }
                    } else if (recentUserType == 1030) {
                        QQAppInterface qQAppInterface = this.f176792v0;
                        int i17 = QQManagerFactory.CAMPUS_NOTICE_MANAGER;
                        if (qQAppInterface.isCreateManager(i17)) {
                            ((com.tencent.mobileqq.campuscircle.d) this.f176792v0.getManager(i17)).f(null);
                            if (QLog.isColorLevel()) {
                                QLog.d("notification", 2, "remove campus notice from LSA");
                            }
                        }
                    } else if (recentUserType == 9653) {
                        ((com.tencent.mobileqq.managers.h) this.f176792v0.getManager(QQManagerFactory.PULL_ACTIVE_MANAGER)).c();
                    } else if (com.tencent.imcore.message.ao.c(recentUserType) == 1032) {
                        this.f176792v0.getConversationFacade().t();
                        this.f176792v0.getMessageFacade().J0(AppConstants.CONFESS_UIN, 1032);
                    } else if (f4(recentUserType)) {
                        QQAppInterface qQAppInterface2 = this.f176792v0;
                        int i18 = QQManagerFactory.PUSH_NOTICE_MANAGER;
                        if (qQAppInterface2.isCreateManager(i18)) {
                            ((PushNoticeManager) this.f176792v0.getManager(i18)).i(null, recentUserType);
                            if (QLog.isColorLevel()) {
                                QLog.d("notification", 2, "remove push notice from LSA");
                            }
                        }
                    } else {
                        this.f176792v0.getMessageFacade().O0(recentUserUin, recentUserType);
                        this.f176781p1.R(recentUserUin, recentUserType);
                        this.f176783q1.clear();
                        this.f176783q1 = this.f176781p1.s();
                    }
                    this.f176792v0.getMessageFacade().f116353m.removeNotification(recentUserUin, recentUserType);
                    this.f176778o0.f176822d.remove(intValue);
                    this.f176778o0.notifyDataSetChanged();
                    if (recentUserType == 3000) {
                        ReportController.o(this.f176792v0, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "1", "", "", "");
                    } else if (recentUserType == 1) {
                        ReportController.o(this.f176792v0, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "2", "", "", "");
                    } else if (recentUserType == 0) {
                        ReportController.o(this.f176792v0, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "0", "", "", "");
                    } else if (recentUserType == 1001 || recentUserType == 1010 || recentUserType == 10002) {
                        ReportController.o(this.f176792v0, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "3", "", "", "");
                    }
                    this.f176775m1.h(recentUserUin, recentUserType);
                } else {
                    int i19 = this.f176782q0.f176830d.get(0).istroop;
                    String str = this.f176782q0.f176830d.get(0).frienduin;
                    if (i19 == 1001 || i19 == 1010 || i19 == 10002) {
                        ((MessageHandler) this.f176792v0.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).Y4(str, i19, false);
                    } else if (i19 == 4000) {
                        this.f176771k1.markAllDataReaded();
                    } else if (i19 == 7000) {
                        ((MessageHandler) this.f176792v0.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).l3().Y0(str, null);
                        ISubAccountService iSubAccountService2 = (ISubAccountService) this.f176792v0.getRuntimeService(ISubAccountService.class, "");
                        if (iSubAccountService2 != null) {
                            iSubAccountService2.setAllMessageReaded(str);
                        }
                    } else if (i19 == 1012) {
                        com.tencent.mobileqq.dating.d dVar2 = (com.tencent.mobileqq.dating.d) this.f176792v0.getManager(QQManagerFactory.DATING_PROXY_MANAGER);
                        if (dVar2 != null) {
                            dVar2.b().h();
                        }
                    } else if (i19 == 1030) {
                        QQAppInterface qQAppInterface3 = this.f176792v0;
                        int i26 = QQManagerFactory.CAMPUS_NOTICE_MANAGER;
                        if (qQAppInterface3.isCreateManager(i26)) {
                            ((com.tencent.mobileqq.campuscircle.d) this.f176792v0.getManager(i26)).f(null);
                            if (QLog.isColorLevel()) {
                                QLog.d("notification", 2, "remove campus notice from LSA");
                            }
                        }
                    } else if (i19 == 9653) {
                        ((com.tencent.mobileqq.managers.h) this.f176792v0.getManager(QQManagerFactory.PULL_ACTIVE_MANAGER)).c();
                    } else if (com.tencent.imcore.message.ao.c(i19) == 1032) {
                        this.f176792v0.getConversationFacade().t();
                        this.f176792v0.getMessageFacade().J0(AppConstants.CONFESS_UIN, 1032);
                    } else if (f4(i19)) {
                        QQAppInterface qQAppInterface4 = this.f176792v0;
                        int i27 = QQManagerFactory.PUSH_NOTICE_MANAGER;
                        if (qQAppInterface4.isCreateManager(i27)) {
                            ((PushNoticeManager) this.f176792v0.getManager(i27)).i(null, i19);
                            if (QLog.isColorLevel()) {
                                QLog.d("notification", 2, "remove push notice from LSA");
                            }
                        }
                    }
                    RecentUtil.I0(this.f176792v0, str, i19);
                    this.f176792v0.getMessageFacade().O0(str, i19);
                    this.f176781p1.R(str, i19);
                    this.f176783q1.clear();
                    this.f176783q1 = this.f176781p1.s();
                    if (QLog.isColorLevel()) {
                        i16 = 2;
                        QLog.d("notification", 2, "QQLSActivity onChange removeNotification");
                    } else {
                        i16 = 2;
                    }
                    this.f176792v0.removeNotification();
                    if (QLog.isColorLevel()) {
                        QLog.d("QQLSActivity", i16, "single data remove finish");
                    }
                    F3();
                    if (i19 == 3000) {
                        ReportController.o(this.f176792v0, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "1", "", "", "");
                        return;
                    }
                    if (i19 == 1) {
                        ReportController.o(this.f176792v0, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "2", "", "", "");
                        return;
                    }
                    if (i19 == 0) {
                        ReportController.o(this.f176792v0, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "0", "", "", "");
                        return;
                    } else {
                        if (i19 == 1001 || i19 == 1010 || i19 == 10002) {
                            ReportController.o(this.f176792v0, "CliOper", "", "", "0X8004AB0", "0X8004AB0", 0, 0, "3", "", "", "");
                            return;
                        }
                        return;
                    }
                }
            } else if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, "dragView = null");
                return;
            }
        }
        if (this.f176777n1.getMode() == -1) {
            if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, "onChange updateUI" + Thread.currentThread().getId());
            }
            this.f176779o1 = true;
            runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.QQLSActivity.18
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLSActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        QQLSActivity.this.updateUI();
                    }
                }
            });
            return;
        }
        this.f176779o1 = false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean x16;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) view);
        } else if (I1 && view.getId() == R.id.a6b) {
            view.findViewById(R.id.gok).performClick();
        } else {
            int id5 = view.getId();
            if (id5 == R.id.ajg) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQLSActivity", 2, "onClick btn_reply");
                }
                I3();
                XEditTextEx xEditTextEx = this.f176772l0;
                if (xEditTextEx == null || xEditTextEx.getText().length() != 0) {
                    if (this.f176786s0 == null) {
                        if (QLog.isColorLevel()) {
                            QLog.d("QQLSActivity", 2, "onClick mSingleRecentBaseData=null return");
                        }
                    } else {
                        if (this.f176772l0 != null) {
                            ((InputMethodManager) getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(this.f176772l0.getWindowToken(), 0);
                        }
                        QQToast.makeText(getApplicationContext(), getString(R.string.fle), 0).show();
                        if (this.f176786s0.getRecentUserType() == 3000) {
                            ReportController.o(this.f176792v0, "CliOper", "", "", "0X80040DC", "0X80040DC", 0, 0, "1", "", "", "");
                        } else if (this.f176786s0.getRecentUserType() == 1) {
                            ReportController.o(this.f176792v0, "CliOper", "", "", "0X80040DC", "0X80040DC", 0, 0, "2", "", "", "");
                        } else {
                            ReportController.o(this.f176792v0, "CliOper", "", "", "0X80040DC", "0X80040DC", 0, 0, "0", "", "", "");
                        }
                        this.G1.sendMessageDelayed(this.G1.obtainMessage(1), 100L);
                    }
                }
            } else if (id5 == R.id.aga) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQLSActivity", 2, "onClick btn_close");
                }
                com.tencent.mobileqq.managers.i.K = System.currentTimeMillis();
                I3();
                ReportController.o(this.f176792v0, "CliOper", "", "", "0X80040DE", "0X80040DE", 0, 0, "", "", "", "");
                F3();
            } else if (id5 == R.id.gok) {
                o oVar = (o) com.tencent.mobileqq.activity.aio.l.A(view);
                MessageForPtt messageForPtt = (MessageForPtt) oVar.f180131a;
                if (e4(messageForPtt)) {
                    MediaPlayerManager.q(this.f176792v0).D(false);
                } else if (messageForPtt != MediaPlayerManager.q(this.f176792v0).s() && messageForPtt.isReady()) {
                    if (this.f176792v0.isVideoChatting()) {
                        QQToast.makeText(this, 1, R.string.f171206d52, 0).show(getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                    } else {
                        if (oVar instanceof l) {
                            x16 = MediaPlayerManager.q(this.f176792v0).x(com.tencent.mobileqq.activity.aio.l.C(view));
                        } else {
                            x16 = MediaPlayerManager.q(this.f176792v0).x(com.tencent.mobileqq.activity.aio.l.C(view));
                        }
                        if (!x16) {
                            QQToast.makeText(this, 1, R.string.f171205d51, 0).show(getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                        }
                    }
                }
                if (messageForPtt.istroop == 1008) {
                    ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.f176792v0, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "0X8005857", "0X8005857", 0, 0, "", "", messageForPtt.timeStr, "", false);
                }
            } else if (id5 == R.id.chat_item_fail_icon) {
                m4(view);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void onLogout(Constants.LogoutReason logoutReason) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, (Object) logoutReason);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "logout finish");
        }
        F3();
        super.onLogout(logoutReason);
    }

    @Override // com.tencent.mobileqq.activity.aio.MediaPlayerManager.c
    public void onPlayStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
        } else {
            getWindow().addFlags(128);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.MediaPlayerManager.c
    public void onPlayStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
            return;
        }
        setVolumeControlStream(3);
        getWindow().clearFlags(128);
        this.f176793v1.sendEmptyMessageDelayed(25, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    @Deprecated
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        Foreground.sCountActivity.getAndDecrement();
        super.onStart();
        if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "onStart taskId" + getTaskId());
        }
        if (getTaskId() == -1) {
            if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, "getTadk = -1 finish LS ,or onresume will get badToken!");
            }
            finish();
            try {
                Field declaredField = Activity.class.getDeclaredField("mFinished");
                declaredField.setAccessible(true);
                declaredField.get(this);
                declaredField.set(this, Boolean.TRUE);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            super.onStop();
            Foreground.sCountActivity.incrementAndGet();
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, android.app.Activity
    public void onUserLeaveHint() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "onUserLeaveHint");
        }
        com.tencent.mobileqq.managers.i.M = false;
        I3();
        super.onUserLeaveHint();
    }

    @Override // com.tencent.mobileqq.utils.dd.c
    public void s2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, z16);
            return;
        }
        this.f176763g1 = z16;
        if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "sensor has callback sensorIsClose===" + this.f176763g1);
        }
        if (this.f176763g1) {
            this.f176767i1 = false;
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, "callback firstTimeToWakeScreen=" + this.f176767i1);
            }
            if (this.f176767i1) {
                if (k4()) {
                    G3();
                } else {
                    H3();
                }
                this.f176767i1 = false;
            }
        }
        this.f176769j1 = true;
    }

    public void send() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        new SessionInfo();
        if (this.f176786s0 == null) {
            return;
        }
        this.f176792v0.getMessageFacade().O0(this.f176786s0.getRecentUserUin(), this.f176786s0.getRecentUserType());
        if (QLog.isColorLevel()) {
            QLog.d("notification", 2, "QQLSActivity send removeNotification");
        }
        this.f176792v0.removeNotification();
        SessionInfo T3 = T3(this.f176786s0);
        if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, " send start currenttime:" + System.currentTimeMillis());
        }
        if (this.f176772l0.getText().length() > 0) {
            String obj = this.f176772l0.getText().toString();
            if (obj != null && obj.length() > 3478) {
                ChatActivityUtils.m0(this, R.string.her, 1);
                return;
            }
            if (this.f176786s0.getRecentUserType() == 1) {
                ArrayList arrayList = new ArrayList();
                ChatActivityFacade.L0(this.f176792v0, this, T3, com.tencent.mobileqq.troop.text.a.c(this.f176772l0.getEditableText(), arrayList), arrayList);
            } else {
                ChatActivityFacade.L0(this.f176792v0, this, T3, obj, null);
            }
            this.f176772l0.getEditableText().clear();
            this.f176772l0.setText("");
            if (QLog.isColorLevel()) {
                QLog.d("SendMsgBtn", 2, " msgReport start currenttime:" + System.currentTimeMillis());
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:14:0x0081. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void t4(o oVar, MessageForPtt messageForPtt, int i3, boolean z16) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        char c16 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, oVar, messageForPtt, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "fileStatus is:" + i3 + ",url is:" + messageForPtt.url + ",uniseq is:" + messageForPtt.uniseq + ",stt is:" + messageForPtt.sttAbility + ",long is:" + messageForPtt.longPttVipFlag);
        }
        Resources resources = getResources();
        String str = "";
        if (i3 != -1) {
            switch (i3) {
                case 999:
                case 1000:
                    break;
                case 1001:
                case 1002:
                case 1003:
                case 1004:
                case 1005:
                    if (QLog.isColorLevel()) {
                        QLog.d("QQLSActivity", 2, "voiceLength showPttItem builder" + messageForPtt.voiceLength);
                    }
                    if (messageForPtt.voiceLength <= 1) {
                        messageForPtt.voiceLength = ((IQQRecorderTempApi) QRoute.api(IQQRecorderTempApi.class)).getFilePlayTime(messageForPtt);
                    }
                    if (messageForPtt.voiceLength <= 0) {
                        if (QLog.isColorLevel()) {
                            QLog.d("QQLSActivity", 2, "get a amr file length = 0 return now");
                        }
                        oVar.f176833g.setImageDrawable(null);
                        oVar.f176833g.setPadding(0, 0, 0, 0);
                        oVar.f176834h.setText("");
                        oVar.f176834h.setPadding(BaseAIOUtils.f(10.0f, resources), BaseChatItemLayout.W, BaseAIOUtils.f(10.0f, resources), BaseChatItemLayout.f178043a0);
                        return;
                    }
                    com.tencent.mobileqq.activity.aio.item.n.c(this.f176792v0, "Normal_MaxPtt");
                    if (messageForPtt.voiceLength > com.tencent.mobileqq.activity.aio.item.n.c(this.f176792v0, "ConvertText_MaxPtt")) {
                        messageForPtt.sttAbility = 0;
                    }
                    if (TextUtils.isEmpty(messageForPtt.timeStr) || TextUtils.equals(messageForPtt.timeStr, "0\"")) {
                        messageForPtt.timeStr = com.tencent.mobileqq.activity.aio.item.n.a(messageForPtt.voiceLength);
                    }
                    str = messageForPtt.timeStr;
                    oVar.f176834h.setText(str);
                    oVar.f176835i.setAnimating(false);
                    oVar.f176835i.setOnClickListener(this);
                    if (z16) {
                        AnimationDrawable animationDrawable = (AnimationDrawable) resources.getDrawable(R.anim.f154797cp);
                        oVar.f176833g.setImageDrawable(animationDrawable);
                        animationDrawable.start();
                        oVar.f176835i.setBackgroundResource(R.drawable.f161208d60);
                        oVar.f176834h.setTextColor(getResources().getColor(R.color.black));
                    } else {
                        oVar.f176834h.setTextColor(getResources().getColor(R.color.f158017al3));
                        if (messageForPtt.isReadPtt) {
                            oVar.f176833g.setImageResource(R.drawable.d5y);
                        } else {
                            oVar.f176833g.setImageResource(R.drawable.exf);
                        }
                        oVar.f176835i.setBackgroundResource(R.drawable.d5z);
                    }
                    if (i3 != 2003 && i3 != 1003) {
                        c16 = (i3 == 1005 || i3 == 1004) ? (char) 1 : (char) 0;
                    }
                    int f16 = BaseAIOUtils.f(9.0f, resources);
                    int i17 = messageForPtt.voiceLength;
                    if (i17 >= 15) {
                        i17 = 15;
                    }
                    int b16 = com.tencent.mobileqq.activity.aio.item.n.b(this, i17, null, null, 0);
                    oVar.f176833g.setPadding(f16, 0, 0, 0);
                    oVar.f176834h.setPadding(BaseChatItemLayout.f178048f0, 0, b16, 0);
                    if (c16 != 0) {
                        if (c16 != 1) {
                            ImageView imageView = oVar.f179548b.I;
                            if (imageView != null) {
                                imageView.setBackgroundDrawable(null);
                            }
                        } else {
                            oVar.f179548b.I.setBackgroundDrawable(null);
                            if (I1) {
                                ImageView imageView2 = oVar.f179548b.I;
                                if (messageForPtt.isSendFromLocal()) {
                                    i16 = R.string.qu8;
                                } else {
                                    i16 = R.string.qua;
                                }
                                imageView2.setContentDescription(HardCodeUtil.qqStr(i16));
                            }
                        }
                    } else {
                        oVar.f179548b.I.setBackgroundDrawable(null);
                        ((Animatable) oVar.f179548b.I.getDrawable()).start();
                    }
                    if (I1) {
                        String str2 = this.f176786s0.getTitleName() + HardCodeUtil.qqStr(R.string.qu5);
                        oVar.f176835i.setContentDescription(str2 + str + HardCodeUtil.qqStr(R.string.quc));
                        StringBuilder sb5 = oVar.f176832f;
                        if (sb5 != null) {
                            sb5.append("\u53d1\u9001\u4e86\u8bed\u97f3.");
                            sb5.append(str);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    switch (i3) {
                        case 2004:
                        case 2005:
                            oVar.f176834h.setText("");
                            oVar.f176834h.setPadding(BaseAIOUtils.f(10.0f, resources), BaseChatItemLayout.W, BaseAIOUtils.f(10.0f, resources), BaseChatItemLayout.f178043a0);
                            oVar.f176835i.setAnimating(false);
                            oVar.f176833g.setImageResource(R.drawable.exc);
                            c16 = 1;
                            break;
                    }
                    if (c16 != 0) {
                    }
                    if (I1) {
                    }
                    break;
            }
        }
        oVar.f176833g.setImageDrawable(null);
        oVar.f176833g.setPadding(0, 0, 0, 0);
        oVar.f176834h.setText("");
        oVar.f176834h.setPadding(BaseAIOUtils.f(40.0f, resources), BaseChatItemLayout.W, BaseAIOUtils.f(40.0f, resources), BaseChatItemLayout.f178043a0);
        oVar.f176835i.setAnimating(true);
        if (c16 != 0) {
        }
        if (I1) {
        }
    }

    public void u4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.QQLSActivity.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLSActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("QQLSSensor", 2, "====shutSensor===" + Thread.currentThread().getId());
                    }
                    com.tencent.mobileqq.utils.dd ddVar = QQLSActivity.this.f176761f1;
                    if (ddVar != null) {
                        ddVar.g();
                        QQLSActivity.this.f176761f1 = null;
                    }
                }
            });
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        int i3;
        TroopInfo troopInfoFromCache;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, (Object) observable, obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "update" + Thread.currentThread().getId());
        }
        boolean isKeyguardLock = isKeyguardLock();
        if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "LS update isScreenLocked" + isKeyguardLock);
        }
        if (!isKeyguardLock) {
            if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, "LS update screen is unLock finish!!!");
            }
            this.G1.sendMessage(this.G1.obtainMessage(2));
            return;
        }
        if (isFinishing()) {
            if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, "LS update screen is finishing not update");
                return;
            }
            return;
        }
        XEditTextEx xEditTextEx = this.f176772l0;
        if (xEditTextEx != null && xEditTextEx.getVisibility() == 0 && !TextUtils.isEmpty(this.f176772l0.getText())) {
            if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, "LS update user is sendMsg not update");
                return;
            }
            return;
        }
        boolean z16 = false;
        this.f176769j1 = false;
        if (obj != null && (obj instanceof com.tencent.mobileqq.newfriend.msg.i)) {
            if (QLog.isColorLevel()) {
                QLog.d("QQLSActivity", 2, "data is NewFriendMessage" + Thread.currentThread().getId());
            }
            if (this.f176771k1.getAllUnreadMessageCount() == 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQLSActivity", 2, "data is NewFriendMessage unread=0 update return");
                    return;
                }
                return;
            } else {
                if (obj instanceof com.tencent.mobileqq.newfriend.msg.c) {
                    L3((com.tencent.mobileqq.newfriend.msg.c) obj);
                }
                this.f176775m1.i(this.f176792v0, AppConstants.RECOMMEND_CONTACT_UIN, 4000, false, -1, false);
                updateUI();
                return;
            }
        }
        if (obj != null && (obj instanceof RecentItemVoteData)) {
            RecentUser d16 = ((RecentItemVoteData) obj).d();
            this.f176775m1.i(this.f176792v0, d16.uin, d16.msgType, false, -1, false);
            com.tencent.mobileqq.managers.i.G = false;
            updateUI();
        } else if (obj != null && (obj instanceof RecentItemPullActivePush)) {
            RecentUser d17 = ((RecentItemPullActivePush) obj).d();
            this.f176775m1.i(this.f176792v0, d17.uin, d17.getType(), false, -1, false);
            com.tencent.mobileqq.managers.i.G = false;
            updateUI();
        }
        if (obj != null && (obj instanceof ChatMessage)) {
            ChatMessage chatMessage = (ChatMessage) obj;
            if (chatMessage.isSend() || (i3 = chatMessage.istroop) == 6000 || i3 == 1009 || i3 == 1036 || com.tencent.mobileqq.app.nthiddenchat.b.h(chatMessage.frienduin, i3, this.f176792v0)) {
                return;
            }
            if (chatMessage.istroop == 1) {
                z16 = true;
            }
            com.tencent.mobileqq.managers.i.G = z16;
            if (!z16 && this.f176761f1 == null) {
                ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.activity.QQLSActivity.11
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLSActivity.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (QQLSActivity.this.f176761f1 == null) {
                            if (QLog.isColorLevel()) {
                                QLog.d("QQLSSensor", 2, "====openSensor===" + Thread.currentThread().getId());
                            }
                            QQLSActivity qQLSActivity = QQLSActivity.this;
                            qQLSActivity.f176761f1 = new com.tencent.mobileqq.utils.dd(qQLSActivity.getApplicationContext(), QQLSActivity.this);
                            QQLSActivity.this.f176761f1.f();
                            if (QQLSActivity.this.G1.hasMessages(8)) {
                                QQLSActivity.this.G1.removeMessages(8);
                            }
                            QQLSActivity.this.G1.sendMessageDelayed(QQLSActivity.this.G1.obtainMessage(8), 1500L);
                        }
                    }
                });
            }
            if (com.tencent.imcore.message.ao.B(chatMessage) && !com.tencent.imcore.message.ad.F(this.f176792v0, chatMessage)) {
                int i16 = chatMessage.istroop;
                if (1001 != i16 && 10002 != i16) {
                    if (1010 == i16) {
                        this.f176775m1.i(this.f176792v0, AppConstants.LOCK_SCREEN_DATE_UIN, i16, false, -1, false);
                        updateUI();
                        return;
                    }
                    return;
                }
                this.f176775m1.i(this.f176792v0, AppConstants.LOCK_SCREEN_LBS_HELLO_UIN, i16, false, -1, false);
                updateUI();
                return;
            }
            if ((chatMessage.istroop == 1 && ((troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(chatMessage.frienduin)) == null || troopInfoFromCache.troopmask != GroupMsgMask.NOTIFY)) || com.tencent.mobileqq.app.n.x(this.f176792v0, chatMessage.frienduin, chatMessage.istroop)) {
                return;
            }
            if (chatMessage.istroop == 1008) {
                String str = chatMessage.extStr;
                if (str != null) {
                    if (((chatMessage.extLong & 1) != 0 || str.contains("lockDisplay")) && chatMessage.extStr != null) {
                        if ((chatMessage.extLong & 1) == 1 && !chatMessage.getExtInfoFromExtStr("lockDisplay").equals("true")) {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (chatMessage.istroop == 7220 && TextUtils.equals(chatMessage.senderuin, AppConstants.NEW_KANDIAN_UIN)) {
                return;
            }
            this.f176775m1.i(this.f176792v0, chatMessage.frienduin, chatMessage.istroop, false, -1, false);
            updateUI();
            return;
        }
        if (QLog.isColorLevel() && obj != null) {
            QLog.d("QQLSActivity", 2, "update data is not chatMessage return" + obj.getClass());
        }
    }

    public void updateUI() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        if (!this.G1.hasMessages(13)) {
            long uptimeMillis = SystemClock.uptimeMillis();
            Message obtainMessage = this.G1.obtainMessage(13);
            long j3 = this.f176795w1;
            if (uptimeMillis - j3 <= 1000 && j3 != -1) {
                this.G1.sendMessageDelayed(obtainMessage, 1000 - (uptimeMillis - j3));
            } else {
                this.G1.sendMessage(obtainMessage);
            }
        }
    }

    public void v4() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this);
        } else {
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.activity.QQLSActivity.16
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLSActivity.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        if (QQLSActivity.this.H1 == 1) {
                            BaseApplication.getContext().unregisterReceiver(QQLSActivity.this.f176787s1);
                            if (QLog.isColorLevel()) {
                                QLog.d("QQLSActivity", 2, "unRegisterScreenListener real mScreenReceiver:" + QQLSActivity.this.f176787s1.hashCode() + "context :" + BaseApplication.getContext().hashCode());
                            }
                            QQLSActivity.this.H1 = 0;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("QQLSActivity", 2, "unRegisterScreenListener");
                        }
                    } catch (Exception e16) {
                        e16.printStackTrace();
                        if (QLog.isColorLevel()) {
                            QLog.e("QQLSActivity", 2, "unRegisterScreenListener:" + e16.toString());
                        }
                    }
                }
            }, true);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.MediaPlayerManager.c
    public void vc(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, i3);
        } else {
            setVolumeControlStream(i3);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Boolean) iPatchRedirector.redirect((short) 37, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 == 17) {
            this.f176782q0.notifyDataSetChanged();
            return false;
        }
        if (i3 != 25) {
            if (i3 != 99) {
                return false;
            }
            i4();
            finish();
            return false;
        }
        com.tencent.mobileqq.widget.bq bqVar = this.B1;
        if (bqVar == null || !bqVar.isShowing() || this.B1.getWindow() == null || isFinishing()) {
            return false;
        }
        this.B1.dismiss();
        this.B1 = null;
        return false;
    }
}
