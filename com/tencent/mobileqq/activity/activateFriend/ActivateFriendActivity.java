package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsMsg;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.heytap.msp.push.HeytapPushManager;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.api.IQQGameCommApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.activateFriends.MessageForActivateFriends;
import com.tencent.mobileqq.app.activateFriends.MessageForReminder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.reminder.api.IQQReminderAlarmService;
import com.tencent.mobileqq.reminder.api.IQQReminderDataService;
import com.tencent.mobileqq.reminder.api.IQQReminderRecordFacadeApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.db;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.utils.ca;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.chats.api.IChatsUnreadAPI;
import com.tencent.qqnt.chats.api.IChatsUtil;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.qzone.mobilereport.MobileReportManager;
import cooperation.qzone.mobilereport.ReportParamsConst;
import cooperation.qzone.report.lp.LpReportInfo_dc00518;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.functions.Function1;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.s2c.msgtype0x210.submsgtype0x13a.submsgtype0x13a$MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76$MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76$OneMemorialDayInfo;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ActivateFriendActivity extends IphoneTitleBarActivity implements View.OnClickListener, ViewPager.OnPageChangeListener, Observer, com.tencent.qqnt.kernel.invorker.d {
    static IPatchRedirector $redirector_;

    /* renamed from: w0 */
    private static final int f177782w0;

    /* renamed from: a0 */
    private int f177783a0;

    /* renamed from: b0 */
    private ImageView f177784b0;

    /* renamed from: c0 */
    private TextView f177785c0;

    /* renamed from: d0 */
    private ReminderViewPager f177786d0;

    /* renamed from: e0 */
    private m f177787e0;

    /* renamed from: f0 */
    private LinearLayout f177788f0;

    /* renamed from: g0 */
    private int f177789g0;

    /* renamed from: h0 */
    private int f177790h0;

    /* renamed from: i0 */
    private ActivateFriendsManager f177791i0;

    /* renamed from: j0 */
    private IQQReminderDataService f177792j0;

    /* renamed from: k0 */
    private boolean f177793k0;

    /* renamed from: l0 */
    private long f177794l0;

    /* renamed from: m0 */
    private boolean f177795m0;

    /* renamed from: n0 */
    private boolean f177796n0;

    /* renamed from: o0 */
    private long f177797o0;

    /* renamed from: p0 */
    private int f177798p0;

    /* renamed from: q0 */
    private BirthdayActivatePageArkView f177799q0;

    /* renamed from: r0 */
    private MemorialActivatePageArk f177800r0;

    /* renamed from: s0 */
    Handler f177801s0;

    /* renamed from: t0 */
    MemorialActivatePage f177802t0;

    /* renamed from: u0 */
    private CardObserver f177803u0;

    /* renamed from: v0 */
    private com.tencent.mobileqq.app.activateFriends.b f177804v0;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements bm2.c {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActivateFriendActivity.this);
            }
        }

        @Override // bm2.c
        public void a(AcsMsg acsMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) acsMsg);
                return;
            }
            Message obtainMessage = ActivateFriendActivity.this.f177801s0.obtainMessage();
            obtainMessage.what = 3;
            Bundle bundle = new Bundle();
            bundle.putSerializable("acsMsg", acsMsg);
            obtainMessage.obj = bundle;
            ActivateFriendActivity.this.f177801s0.sendMessage(obtainMessage);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b extends ClickableSpan {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActivateFriendActivity.this);
            }
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                ActivateFriendActivity.this.showActionSheet();
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) textPaint);
            } else {
                textPaint.setColor(Color.rgb(0, 165, 224));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements Comparator<com.tencent.mobileqq.reminder.db.b> {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActivateFriendActivity.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(com.tencent.mobileqq.reminder.db.b bVar, com.tencent.mobileqq.reminder.db.b bVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar, (Object) bVar2)).intValue();
            }
            long time = bVar.getTime() - bVar2.getTime();
            if (time == 0) {
                time = bVar.getId() - bVar2.getId();
            }
            if (time > 0) {
                return -1;
            }
            if (time < 0) {
                return 1;
            }
            return 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements bm2.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a */
        final /* synthetic */ ArrayList f177808a;

        /* renamed from: b */
        final /* synthetic */ int f177809b;

        d(ArrayList arrayList, int i3) {
            this.f177808a = arrayList;
            this.f177809b = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ActivateFriendActivity.this, arrayList, Integer.valueOf(i3));
            }
        }

        @Override // bm2.a
        public void a(List<AcsMsg> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
                return;
            }
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(list);
            Bundle bundle = new Bundle();
            bundle.putSerializable("list", copyOnWriteArrayList);
            bundle.putSerializable(IQQGameCommApi.K_ABTEST_MODELS, this.f177808a);
            bundle.putInt("count", this.f177809b);
            Message obtainMessage = ActivateFriendActivity.this.f177801s0.obtainMessage();
            obtainMessage.obj = bundle;
            obtainMessage.what = 2;
            ActivateFriendActivity.this.f177801s0.sendMessage(obtainMessage);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class e implements Comparator<com.tencent.mobileqq.activity.activateFriend.biz.b> {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActivateFriendActivity.this);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(com.tencent.mobileqq.activity.activateFriend.biz.b bVar, com.tencent.mobileqq.activity.activateFriend.biz.b bVar2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar, (Object) bVar2)).intValue();
            }
            long j3 = bVar2.f177964c - bVar.f177964c;
            if (j3 > 0) {
                return 1;
            }
            if (j3 < 0) {
                return -1;
            }
            return 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class f implements Handler.Callback {
        static IPatchRedirector $redirector_;

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActivateFriendActivity.this);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
            }
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        ActivateFriendActivity.this.i3((AcsMsg) ((Bundle) message.obj).getSerializable("acsMsg"));
                        return false;
                    }
                    return false;
                }
                Bundle bundle = (Bundle) message.obj;
                ActivateFriendActivity.this.p3((ArrayList) bundle.getSerializable(IQQGameCommApi.K_ABTEST_MODELS), (List) bundle.getSerializable("list"), bundle.getInt("count"));
                return false;
            }
            if (ActivateFriendActivity.this.f177799q0 != null) {
                ActivateFriendActivity.this.f177799q0.g();
            }
            if (ActivateFriendActivity.this.f177800r0 != null) {
                ActivateFriendActivity.this.f177800r0.g(true);
                return false;
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class g implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d */
        final /* synthetic */ ActionSheet f177813d;

        g(ActionSheet actionSheet) {
            this.f177813d = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActivateFriendActivity.this, (Object) actionSheet);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            ActivateFriendActivity activateFriendActivity;
            int i16;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (i3 == 0) {
                if (ActivateFriendActivity.this.f177791i0 == null) {
                    ActivateFriendActivity activateFriendActivity2 = ActivateFriendActivity.this;
                    activateFriendActivity2.f177791i0 = (ActivateFriendsManager) activateFriendActivity2.app.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS);
                }
                if (NetworkUtil.isNetSupport(ActivateFriendActivity.this)) {
                    ActivateFriendActivity.this.f177791i0.L(!ActivateFriendActivity.this.f177793k0, true);
                    if (ActivateFriendActivity.this.f177793k0) {
                        i16 = 2;
                    } else {
                        i16 = 1;
                    }
                    LpReportInfo_dc00518.report(100, i16, i16);
                    if (ActivateFriendActivity.this.f177793k0) {
                        str = "QQnotice.aio.detail.seton";
                    } else {
                        str = "QQnotice.aio.detail.setoff";
                    }
                    String str2 = str;
                    if (QLog.isColorLevel()) {
                        QLog.d("ActivateFriends.MainActivity", 2, "do report: " + str2);
                    }
                    ReportController.o(ActivateFriendActivity.this.app, "P_CliOper", "QQnotice", "", "", str2, 0, 0, "", "", "", "");
                    y.b(ActivateFriendActivity.this.app, "remindpage_click", null, null, String.valueOf(1), String.valueOf(i16));
                } else if (!ActivateFriendActivity.this.isFinishing() && (activateFriendActivity = ActivateFriendActivity.this) != null) {
                    QQToast.makeText(activateFriendActivity, 1, activateFriendActivity.getResources().getString(R.string.f171139ci4), 0).show(ActivateFriendActivity.this.getTitleBarHeight());
                }
            }
            this.f177813d.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class h implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d */
        final /* synthetic */ ActionSheet f177815d;

        h(ActionSheet actionSheet) {
            this.f177815d = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActivateFriendActivity.this, (Object) actionSheet);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 2;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                QQAppInterface qQAppInterface = ActivateFriendActivity.this.app;
                String valueOf = String.valueOf(2);
                if (!ActivateFriendActivity.this.f177793k0) {
                    i3 = 1;
                }
                y.b(qQAppInterface, "remindpage_click", null, null, valueOf, String.valueOf(i3));
                this.f177815d.dismiss();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class i extends CardObserver {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActivateFriendActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onGetAllowActivateFriend(boolean z16, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            if (ActivateFriendActivity.this.f177793k0 != z17 && z17) {
                com.tencent.mobileqq.app.activateFriends.a.h(ActivateFriendActivity.this.app, false, true, false, true);
                ActivateFriendActivity.this.U3();
            }
            ActivateFriendActivity.this.f177793k0 = z17;
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onSetAllowActivateFriend(boolean z16, boolean z17) {
            ActivateFriendActivity activateFriendActivity;
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
                return;
            }
            if (ActivateFriendActivity.this.f177793k0 != z17 && z17) {
                com.tencent.mobileqq.app.activateFriends.a.h(ActivateFriendActivity.this.app, false, true, false, true);
                ActivateFriendActivity.this.U3();
            }
            if (!ActivateFriendActivity.this.isFinishing()) {
                if (z16) {
                    ActivateFriendActivity.this.f177793k0 = z17;
                    if (ActivateFriendActivity.this.f177793k0) {
                        activateFriendActivity = ActivateFriendActivity.this;
                        i3 = R.string.f170006cp;
                    } else {
                        activateFriendActivity = ActivateFriendActivity.this;
                        i3 = R.string.f170007cq;
                    }
                    QQToast.makeText(ActivateFriendActivity.this, 2, ActivateFriendActivity.this.getString(R.string.f170009cs, activateFriendActivity.getString(i3)), 0).show(ActivateFriendActivity.this.getTitleBarHeight());
                    if (ActivateFriendActivity.this.f177787e0 != null) {
                        ActivateFriendActivity.this.f177787e0.f();
                        ActivateFriendActivity.this.t3();
                        return;
                    }
                    return;
                }
                ActivateFriendActivity activateFriendActivity2 = ActivateFriendActivity.this;
                QQToast.makeText(activateFriendActivity2, 1, activateFriendActivity2.getResources().getString(R.string.hhc), 0).show(ActivateFriendActivity.this.getTitleBarHeight());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class j extends com.tencent.mobileqq.app.activateFriends.b {
        static IPatchRedirector $redirector_;

        j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ActivateFriendActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.app.activateFriends.b
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ActivateFriends.MainActivity", 2, "onReceiveBirthDayPushUpdate");
            }
            ActivateFriendActivity.this.t3();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67639);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 20)) {
            redirector.redirect((short) 20);
        } else {
            f177782w0 = ViewUtils.dpToPx(16.0f);
        }
    }

    public ActivateFriendActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f177783a0 = 0;
        this.f177788f0 = null;
        this.f177793k0 = false;
        this.f177795m0 = false;
        this.f177796n0 = false;
        this.f177797o0 = -1L;
        this.f177801s0 = new Handler(Looper.getMainLooper(), new f());
        this.f177803u0 = new i();
        this.f177804v0 = new j();
    }

    public static /* synthetic */ Boolean A3(com.tencent.mobileqq.reminder.db.b bVar, Object obj) {
        return Boolean.valueOf(bVar instanceof MessageForReminder);
    }

    public static /* synthetic */ Boolean B3(com.tencent.mobileqq.reminder.db.b bVar, Object obj) {
        return Boolean.valueOf(bVar instanceof MessageForActivateFriends);
    }

    public static /* synthetic */ Boolean C3(com.tencent.mobileqq.reminder.db.b bVar, Object obj) {
        return Boolean.valueOf(bVar instanceof MessageForText);
    }

    public static /* synthetic */ Boolean D3(com.tencent.mobileqq.reminder.db.b bVar, Object obj) {
        return Boolean.valueOf(bVar instanceof MessageForReminder);
    }

    public static /* synthetic */ Boolean E3(com.tencent.mobileqq.reminder.db.b bVar, Object obj) {
        return Boolean.valueOf(bVar instanceof MessageForActivateFriends);
    }

    public static /* synthetic */ Boolean F3(Object obj) {
        return Boolean.valueOf(obj instanceof MessageForActivateFriends);
    }

    public static /* synthetic */ Boolean G3(Object obj) {
        return Boolean.valueOf(obj instanceof MessageForActivateFriends);
    }

    public static /* synthetic */ Boolean H3(com.tencent.mobileqq.reminder.db.b bVar, Object obj) {
        return Boolean.valueOf(bVar instanceof MessageForActivateFriends);
    }

    public static /* synthetic */ Boolean I3(com.tencent.mobileqq.reminder.db.b bVar, Object obj) {
        return Boolean.valueOf(bVar instanceof MessageForReminder);
    }

    public /* synthetic */ void J3(String str) {
        TextView textView = this.f177785c0;
        if (textView != null) {
            textView.setText(str);
        }
    }

    private void K3(SparseBooleanArray sparseBooleanArray, boolean z16, SubMsgType0x76$MsgBody subMsgType0x76$MsgBody, long j3) {
        SubMsgType0x76$OneMemorialDayInfo subMsgType0x76$OneMemorialDayInfo = subMsgType0x76$MsgBody.msg_memorialday_notify.rpt_anniversary_info.get(0);
        long j16 = subMsgType0x76$OneMemorialDayInfo.uint64_uin.get();
        int i3 = (int) subMsgType0x76$OneMemorialDayInfo.uint32_type.get();
        int i16 = subMsgType0x76$OneMemorialDayInfo.uint32_memorial_time.get();
        String stringUtf8 = subMsgType0x76$OneMemorialDayInfo.bytes_main_wording_nick.get().toStringUtf8();
        String stringUtf82 = subMsgType0x76$OneMemorialDayInfo.bytes_main_wording_event.get().toStringUtf8();
        String stringUtf83 = subMsgType0x76$OneMemorialDayInfo.bytes_sub_wording.get().toStringUtf8();
        String stringUtf84 = subMsgType0x76$OneMemorialDayInfo.bytes_greetings.get().toStringUtf8();
        int i17 = subMsgType0x76$OneMemorialDayInfo.uint32_friend_gender.get();
        if (QLog.isColorLevel()) {
            QLog.d("ActivateFriends.MainActivity", 2, "memorial_type:" + i3 + " pushTime:" + j3 + " uin:" + j16 + " timeStamp:" + i16 + " titleNick:" + stringUtf8 + " titleEvent:" + stringUtf82 + " subTitle:" + stringUtf83 + " greetings:" + stringUtf84 + " gender:" + i17);
        }
        h3(i3, j3, j16, i16, stringUtf8, stringUtf82, stringUtf83, stringUtf84, i17);
        sparseBooleanArray.put(3, true);
        if (z16) {
            LpReportInfo_pf00064.allReport(220, 2, 2);
        }
    }

    private void L3(SparseBooleanArray sparseBooleanArray, boolean z16, com.tencent.mobileqq.reminder.db.b bVar) {
        SubMsgType0x76$MsgBody subMsgType0x76$MsgBody = (SubMsgType0x76$MsgBody) ((com.tencent.mobileqq.reminder.db.c) bVar).getMsgBody();
        long time = bVar.getTime() * 1000;
        int i3 = subMsgType0x76$MsgBody.uint32_msg_type.get();
        if (i3 == 1 && !sparseBooleanArray.get(1, false)) {
            QLog.w("ActivateFriends.MainActivity", 1, "MSG_TYPE_GEO is no longer support!");
            return;
        }
        if (i3 == 2 && !sparseBooleanArray.get(2, false)) {
            f3(this.app, time, n.b(subMsgType0x76$MsgBody.msg_birthday_notify, this.app, v3()));
            sparseBooleanArray.put(2, true);
            if (z16) {
                LpReportInfo_pf00064.allReport(220, 2, 1);
                return;
            }
            return;
        }
        if (i3 == 3 && !sparseBooleanArray.get(3, false)) {
            K3(sparseBooleanArray, z16, subMsgType0x76$MsgBody, time);
        }
    }

    private void M3(ArrayList<com.tencent.mobileqq.activity.activateFriend.biz.b> arrayList, List<AcsMsg> list) {
        if (QLog.isColorLevel() && list != null && !list.isEmpty()) {
            QLog.i("ActivateFriends.MainActivity", 2, "get today's list size: " + list.size());
            Iterator<AcsMsg> it = list.iterator();
            while (it.hasNext()) {
                QLog.i("ActivateFriends.MainActivity", 2, "acsMsg notice time: " + p.a(it.next().notice_time * 1000, "yyyy-MM-dd HH:mm:ss"));
            }
        }
        if (list != null && !list.isEmpty()) {
            for (AcsMsg acsMsg : list) {
                com.tencent.mobileqq.activity.activateFriend.biz.b bVar = new com.tencent.mobileqq.activity.activateFriend.biz.b();
                bVar.f177964c = acsMsg.notice_time;
                bVar.f177962a = null;
                bVar.f177963b = acsMsg;
                arrayList.add(bVar);
            }
        }
    }

    private void P3(ArrayList<com.tencent.mobileqq.activity.activateFriend.biz.b> arrayList) {
        int i3;
        AcsMsg acsMsg;
        int i16 = 1;
        if (!this.f177796n0) {
            if (x3()) {
                if (QLog.isColorLevel()) {
                    QLog.d("ActivateFriends.MainActivity", 2, "do report: QQnotice.aio.detail.visit");
                }
                ReportController.o(this.app, "P_CliOper", "QQnotice", "", "", "QQnotice.aio.detail.visit", 0, 0, "", "", "", "");
                if (this.f177787e0 != null) {
                    MobileReportManager.getInstance().reportActionOfNotice(ReportParamsConst.APP_ID_QQNOTICE, "3", "1", 100, ((ReminderCardItemPage) this.f177787e0.g().get(0)).P.msg_id, "15", 1);
                }
                if (getIntent() != null) {
                    int intExtra = getIntent().getIntExtra("af_key_from", 0);
                    if (QLog.isColorLevel()) {
                        QLog.d("ActivateFriends.MainActivity", 2, "from : " + intExtra);
                    }
                    if (intExtra == 4) {
                        com.tencent.imcore.message.Message v16 = this.app.getMessageFacade().v1();
                        if (v16 != null) {
                            long j3 = v16.uniseq;
                            Iterator<String> it = this.f177792j0.getCacheKeyList().iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                String next = it.next();
                                if (j3 == next.hashCode()) {
                                    com.tencent.mobileqq.reminder.biz.entity.a entityByKey = this.f177792j0.getEntityByKey(next);
                                    if (entityByKey != null) {
                                        acsMsg = entityByKey.getAcsMsg();
                                    }
                                }
                            }
                            acsMsg = null;
                            if (acsMsg != null) {
                                y.b(this.app, HeytapPushManager.EVENT_ID_PUSH_CLICK, acsMsg.busi_id, acsMsg.msg_id, null, null);
                            } else {
                                y.b(this.app, HeytapPushManager.EVENT_ID_PUSH_CLICK, null, null, null, null);
                            }
                        }
                    } else if (intExtra == 1) {
                        if (QLog.isColorLevel()) {
                            QLog.d("ActivateFriends.MainActivity", 2, "do report: QQnotice.list.click");
                        }
                        y.b(this.app, "newslisting_click", null, null, null, null);
                        ReportController.o(this.app, "P_CliOper", "QQnotice", "", "", "QQnotice.list.click", 0, 0, "", "", "", "");
                    }
                    if (arrayList != null && !arrayList.isEmpty()) {
                        ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).reportNoticeToDc87(intExtra, arrayList.get(0).f177963b);
                    }
                }
            } else if (w3() && getIntent() != null) {
                int intExtra2 = getIntent().getIntExtra("af_key_from", 0);
                if (QLog.isColorLevel()) {
                    QLog.d("ActivateFriends.MainActivity", 2, "from : " + intExtra2);
                }
                com.tencent.mobileqq.reminder.db.c cVar = (com.tencent.mobileqq.reminder.db.c) arrayList.get(0).f177962a;
                if (cVar != null) {
                    submsgtype0x13a$MsgBody submsgtype0x13a_msgbody = (submsgtype0x13a$MsgBody) cVar.getMsgBody();
                    if (submsgtype0x13a_msgbody != null) {
                        i3 = y.d(submsgtype0x13a_msgbody.toByteArray());
                    } else {
                        i3 = 0;
                    }
                    if (intExtra2 == 4) {
                        y.b(this.app, HeytapPushManager.EVENT_ID_PUSH_CLICK, null, null, null, "" + i3);
                    } else if (intExtra2 == 1) {
                        y.b(this.app, "newslisting_click", null, null, null, "" + i3);
                    }
                }
            }
            this.f177796n0 = true;
        }
        m mVar = this.f177787e0;
        if (mVar != null) {
            ActivateBasePage activateBasePage = mVar.g().get(0);
            if (activateBasePage instanceof ReminderCardItemPage) {
                ReminderCardItemPage reminderCardItemPage = (ReminderCardItemPage) activateBasePage;
                if (!reminderCardItemPage.l()) {
                    AcsMsg acsMsg2 = reminderCardItemPage.P;
                    if (acsMsg2.type != 0) {
                        i16 = 2;
                    }
                    y.c(this.app, "remindcontentpage_exp", acsMsg2.busi_id, acsMsg2.msg_id, String.valueOf(i16), acsMsg2.mn_reserved, ai.a(acsMsg2));
                    af.a(acsMsg2);
                }
            }
        }
    }

    private void Q3() {
        int i3;
        m mVar = this.f177787e0;
        if (mVar != null) {
            i3 = mVar.getF373114d();
        } else {
            i3 = 0;
        }
        this.f177790h0 = i3;
        if (i3 > 1) {
            this.f177788f0.removeAllViews();
            this.f177788f0.setVisibility(0);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewUtils.dpToPx(7.0f), ViewUtils.dpToPx(7.0f));
            for (int i16 = 0; i16 < this.f177790h0; i16++) {
                ImageView imageView = new ImageView(this);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.aio_face_indicator));
                if (i16 != 0) {
                    layoutParams.leftMargin = BaseAIOUtils.f(5.0f, getResources());
                }
                imageView.setLayoutParams(layoutParams);
                this.f177788f0.addView(imageView);
            }
            this.f177789g0 = 0;
            R3(0);
            return;
        }
        LinearLayout linearLayout = this.f177788f0;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        m mVar2 = this.f177787e0;
        if (mVar2 != null) {
            mVar2.h(0);
        }
    }

    private void S3() {
        super.setContentView(R.layout.aqj);
        super.setTitle(R.string.f170010ct);
        ImageView imageView = (ImageView) super.findViewById(R.id.ivTitleBtnRightImage);
        this.f177784b0 = imageView;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.f177784b0.setImageResource(R.drawable.qui_more_icon_navigation_01_selector);
            this.f177784b0.setOnClickListener(this);
            if (AppSetting.f99565y) {
                this.f177784b0.setContentDescription(getString(R.string.hhb));
            }
        }
        TextView textView = (TextView) findViewById(R.id.ivTitleBtnLeft);
        this.f177785c0 = textView;
        if (textView != null) {
            textView.setMaxWidth(Integer.MAX_VALUE);
        }
        if (this.f177785c0 == null || this.f177784b0 == null) {
            QLog.e("ActivateFriends.MainActivity", 1, "Failed to get left back txt or right btn, there must be sth wrong!");
        }
        this.f177788f0 = (LinearLayout) super.findViewById(R.id.gag);
        ReminderViewPager reminderViewPager = (ReminderViewPager) findViewById(R.id.f163954di);
        this.f177786d0 = reminderViewPager;
        if (reminderViewPager != null && this.f177788f0 != null) {
            m mVar = new m(reminderViewPager);
            this.f177787e0 = mVar;
            this.f177786d0.setAdapter(mVar);
            this.f177786d0.setOnPageChangeListener(this);
            this.f177786d0.setPageMargin(f177782w0);
            this.f177783a0 = getIntent().getIntExtra("af_key_from", 1);
            ActivateFriendsManager activateFriendsManager = (ActivateFriendsManager) this.app.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS);
            this.f177791i0 = activateFriendsManager;
            this.f177793k0 = activateFriendsManager.t(true);
            l3();
            return;
        }
        QLog.e("ActivateFriends.MainActivity", 1, "Failed to get main content view! Finish it!");
        finish();
    }

    public void V3() {
        Object valueOf;
        int unreadCountByListType = ((IChatsUtil) QRoute.api(IChatsUtil.class)).getUnreadCountByListType(1);
        final String string = this.app.getApp().getString(R.string.hvn);
        if (unreadCountByListType > 0) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(string);
            sb5.append("(");
            if (unreadCountByListType > 99) {
                valueOf = "99+";
            } else {
                valueOf = Integer.valueOf(unreadCountByListType);
            }
            sb5.append(valueOf);
            sb5.append(")");
            string = sb5.toString();
        }
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.activateFriend.l
            @Override // java.lang.Runnable
            public final void run() {
                ActivateFriendActivity.this.J3(string);
            }
        });
    }

    private void e3() {
        if (this.f177793k0) {
            f3(this.app, System.currentTimeMillis(), n.b(null, this.app, v3()));
            this.f177791i0.I();
            U3();
            return;
        }
        f3(this.app, System.currentTimeMillis(), null);
        BirthdayActivatePageArkView birthdayActivatePageArkView = this.f177799q0;
        if (birthdayActivatePageArkView == null) {
            return;
        }
        birthdayActivatePageArkView.h(false);
        TextView textView = (TextView) this.f177799q0.f177779e.findViewById(R.id.bwp);
        SpannableString spannableString = new SpannableString(HardCodeUtil.qqStr(R.string.j1t));
        spannableString.setSpan(new b(), 0, 2, 33);
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void f3(QQAppInterface qQAppInterface, long j3, String str) {
        try {
            BirthdayActivatePageArkView birthdayActivatePageArkView = this.f177799q0;
            if (birthdayActivatePageArkView == null) {
                BirthdayActivatePageArkView birthdayActivatePageArkView2 = new BirthdayActivatePageArkView(this);
                this.f177799q0 = birthdayActivatePageArkView2;
                birthdayActivatePageArkView2.i(j3, str, this.f177798p0);
                this.f177787e0.d(this.f177799q0);
            } else {
                birthdayActivatePageArkView.i(j3, str, this.f177798p0);
                this.f177787e0.d(this.f177799q0);
            }
        } catch (Exception e16) {
            QLog.e("ActivateFriends.MainActivity", 1, "erro " + e16.toString());
        }
    }

    private void g3(long j3, JSONObject jSONObject) {
        try {
            MemorialActivatePageArk memorialActivatePageArk = this.f177800r0;
            if (memorialActivatePageArk == null) {
                MemorialActivatePageArk memorialActivatePageArk2 = new MemorialActivatePageArk(this);
                this.f177800r0 = memorialActivatePageArk2;
                if (memorialActivatePageArk2.h(j3, jSONObject, this.f177798p0)) {
                    this.f177787e0.d(this.f177800r0);
                }
            } else if (memorialActivatePageArk.h(j3, jSONObject, this.f177798p0)) {
                this.f177787e0.d(this.f177800r0);
            }
        } catch (Exception e16) {
            QLog.e("ActivateFriends.MainActivity", 1, "erro " + e16.toString());
        }
    }

    private void h3(int i3, long j3, long j16, int i16, String str, String str2, String str3, String str4, int i17) {
        if (this.f177802t0 == null) {
            this.f177802t0 = new MemorialActivatePage(this, this.app, i3, String.valueOf(j16), i16, str, str2, str3, str4, i17);
        }
        this.f177802t0.f(j3);
        m mVar = this.f177787e0;
        if (mVar != null) {
            mVar.d(this.f177802t0);
        }
    }

    private boolean isMiniAppUrl(String str) {
        if (!StringUtil.isEmpty(str) && ((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppUrl(str)) {
            return true;
        }
        return false;
    }

    private void j3(AcsMsg acsMsg) {
        if (acsMsg != null) {
            if (QLog.isColorLevel()) {
                QLog.d("ActivateFriends.MainActivity", 2, "do report: QQnotice.aio.detail.show");
            }
            ReportController.o(this.app, "P_CliOper", "QQnotice", "", "", "QQnotice.aio.detail.show", 0, 0, "", "", acsMsg.busi_id, acsMsg.msg_id);
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("ActivateFriends.MainActivity", 2, "do report: QQnotice.aio.detail.none");
            }
            ReportController.o(this.app, "P_CliOper", "QQnotice", "", "", "QQnotice.aio.detail.none", 0, 0, "", "", "", "");
        }
        ReminderCardItemPage b16 = ai.b(this, this.app, acsMsg);
        b16.k(acsMsg);
        m mVar = this.f177787e0;
        if (mVar != null) {
            mVar.d(b16);
        }
    }

    private void l3() {
        RelativeLayout.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        int i3 = UIUtils.i(this);
        if (QLog.isColorLevel()) {
            QLog.d("ActivateFriends.MainActivity", 2, "screen height: " + i3);
        }
        ReminderViewPager reminderViewPager = this.f177786d0;
        if (reminderViewPager != null && (layoutParams2 = (RelativeLayout.LayoutParams) reminderViewPager.getLayoutParams()) != null) {
            QLog.d("ActivateFriends.MainActivity", 2, "mViewPager height: " + layoutParams2.height);
            int i16 = (int) (((double) i3) * 0.785d);
            this.f177798p0 = i16;
            layoutParams2.height = i16;
            this.f177786d0.setLayoutParams(layoutParams2);
        }
        LinearLayout linearLayout = this.f177788f0;
        if (linearLayout != null && (layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams()) != null) {
            QLog.d("ActivateFriends.MainActivity", 2, "mPageIndicator topMargin: " + layoutParams.topMargin);
            layoutParams.topMargin = (int) (((double) i3) * 0.805d);
            this.f177788f0.setLayoutParams(layoutParams);
        }
    }

    private void n3() {
        View findViewById = findViewById(R.id.f72803ru);
        if (findViewById != null) {
            findViewById.setBackgroundColor(-15921907);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ad, code lost:
    
        if (r17.f177794l0 <= r13) goto L104;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void p3(ArrayList<com.tencent.mobileqq.activity.activateFriend.biz.b> arrayList, List<AcsMsg> list, int i3) {
        BirthdayActivatePageArkView birthdayActivatePageArkView;
        String str;
        m mVar = this.f177787e0;
        if (mVar != null) {
            mVar.f();
        }
        if (this.f177793k0) {
            M3(arrayList, list);
        }
        int i16 = 2;
        String str2 = "ActivateFriends.MainActivity";
        if (QLog.isColorLevel()) {
            QLog.d("ActivateFriends.MainActivity", 2, "after order list : " + arrayList);
        }
        Collections.sort(arrayList, new e());
        IQQReminderRecordFacadeApi a16 = com.tencent.mobileqq.reminder.db.d.a(this.app);
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray(4);
        boolean z16 = false;
        if (!arrayList.isEmpty()) {
            Iterator<com.tencent.mobileqq.activity.activateFriend.biz.b> it = arrayList.iterator();
            boolean z17 = false;
            boolean z18 = true;
            while (it.hasNext()) {
                com.tencent.mobileqq.activity.activateFriend.biz.b next = it.next();
                final com.tencent.mobileqq.reminder.db.b bVar = next.f177962a;
                if (bVar != null) {
                    if (a16.checkIsForActivateFriends(bVar, new Function1() { // from class: com.tencent.mobileqq.activity.activateFriend.b
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Boolean z36;
                            z36 = ActivateFriendActivity.z3(com.tencent.mobileqq.reminder.db.b.this, obj);
                            return z36;
                        }
                    })) {
                        L3(sparseBooleanArray, z18, bVar);
                    } else if (a16.checkIsForReminder(bVar, new Function1() { // from class: com.tencent.mobileqq.activity.activateFriend.c
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Boolean A3;
                            A3 = ActivateFriendActivity.A3(com.tencent.mobileqq.reminder.db.b.this, obj);
                            return A3;
                        }
                    }) && MemorialActivatePageArk.j()) {
                        if (QLog.isColorLevel()) {
                            QLog.d(str2, i16, "MemorialActivatePageArk showReminderPage");
                        }
                        T3(bVar, sparseBooleanArray);
                    }
                    str = str2;
                    z18 = false;
                } else {
                    AcsMsg acsMsg = next.f177963b;
                    if (acsMsg != null) {
                        long j3 = acsMsg.notice_time * 1000;
                        if (acsMsg.type == 0 && p.c(j3)) {
                            str = str2;
                        } else {
                            str = str2;
                        }
                        if (acsMsg.type == 1) {
                            if (this.f177794l0 - j3 >= 86400000) {
                            }
                            j3(next.f177963b);
                            z17 = true;
                        }
                    } else {
                        str = str2;
                    }
                }
                str2 = str;
                i16 = 2;
            }
            z16 = z17;
        }
        if (i3 == 0) {
            e3();
        }
        if (!z16) {
            j3(null);
        }
        if (i3 > 0 && (birthdayActivatePageArkView = this.f177799q0) != null) {
            birthdayActivatePageArkView.g();
        }
        Q3();
        P3(arrayList);
    }

    private TopGestureLayout r3() {
        ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
        View childAt = viewGroup.getChildAt(0);
        if (childAt != null && (childAt instanceof DragFrameLayout)) {
            viewGroup = (ViewGroup) childAt;
        }
        View childAt2 = viewGroup.getChildAt(0);
        if (childAt2 instanceof TopGestureLayout) {
            return (TopGestureLayout) childAt2;
        }
        return null;
    }

    private void s3(String str, int i3) {
        if (StringUtil.isEmpty(str)) {
            str = "https://act.qzone.qq.com/vip/meteor/blockly/p/4403xdf3cc";
        }
        Uri parse = Uri.parse(str);
        if (parse != null) {
            String scheme = parse.getScheme();
            if (!StringUtil.isEmpty(scheme)) {
                if (scheme.startsWith("http") || scheme.startsWith("https")) {
                    if (i3 == 0) {
                        db.a(this, str, true, true);
                    } else {
                        db.c(this, str, true, i3);
                    }
                }
                if (scheme.startsWith(SchemaUtils.SCHEMA_MQQAPI)) {
                    db.b(this, str);
                }
            }
        }
    }

    public boolean t3() {
        String str;
        boolean z16;
        boolean z17;
        int i3;
        int i16;
        if (this.f177793k0) {
            this.f177792j0.checkTodayReminder();
        } else {
            ((IQQReminderAlarmService) this.app.getRuntimeService(IQQReminderAlarmService.class, "")).clearAllAlarm();
        }
        if (getIntent().getExtras() != null) {
            str = getIntent().getExtras().getString(AppConstants.LeftViewText.LEFTVIEWTEXT);
        } else {
            str = null;
        }
        if (str != null && str.contains(getString(R.string.hvn))) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ((IChatsUnreadAPI) QRoute.api(IChatsUnreadAPI.class)).addExpandRecentContactListener(this);
        }
        IQQReminderRecordFacadeApi a16 = com.tencent.mobileqq.reminder.db.d.a(this.app);
        List<com.tencent.mobileqq.reminder.db.b> msgList = a16.getMsgList(AppConstants.ACTIVATE_FRIENDS_UIN, 9002);
        if (msgList == null) {
            QLog.w("ActivateFriends.MainActivity", 1, "current message = null");
            return false;
        }
        int i17 = 2;
        if (QLog.isColorLevel()) {
            QLog.d("ActivateFriends.MainActivity", 2, "current message count = " + msgList.size());
        }
        if (!msgList.isEmpty()) {
            Iterator<com.tencent.mobileqq.reminder.db.b> it = msgList.iterator();
            z17 = false;
            i3 = 0;
            while (it.hasNext()) {
                final com.tencent.mobileqq.reminder.db.b next = it.next();
                if (a16.checkIsForActivateFriends(next, new Function1() { // from class: com.tencent.mobileqq.activity.activateFriend.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Boolean B3;
                        B3 = ActivateFriendActivity.B3(com.tencent.mobileqq.reminder.db.b.this, obj);
                        return B3;
                    }
                }) && this.f177793k0) {
                    i3++;
                } else if (a16.checkIsMessageForText(next, new Function1() { // from class: com.tencent.mobileqq.activity.activateFriend.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Boolean C3;
                        C3 = ActivateFriendActivity.C3(com.tencent.mobileqq.reminder.db.b.this, obj);
                        return C3;
                    }
                })) {
                    it.remove();
                } else if (a16.checkIsForReminder(next, new Function1() { // from class: com.tencent.mobileqq.activity.activateFriend.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Boolean D3;
                        D3 = ActivateFriendActivity.D3(com.tencent.mobileqq.reminder.db.b.this, obj);
                        return D3;
                    }
                })) {
                    z17 = true;
                }
            }
        } else {
            z17 = false;
            i3 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ActivateFriends.MainActivity", 2, "initData | message count = " + i3, " has memorial Msg: ", Boolean.valueOf(z17));
        }
        ArrayList arrayList = new ArrayList(msgList.size());
        for (final com.tencent.mobileqq.reminder.db.b bVar : msgList) {
            if (a16.checkIsForActivateFriends(bVar, new Function1() { // from class: com.tencent.mobileqq.activity.activateFriend.g
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Boolean E3;
                    E3 = ActivateFriendActivity.E3(com.tencent.mobileqq.reminder.db.b.this, obj);
                    return E3;
                }
            }) && !bVar.getIsread() && (bVar.getExtLong() & 1) == 1 && !TextUtils.isEmpty(bVar.getExtStr())) {
                arrayList.add(bVar.getExtStr());
            }
        }
        if (arrayList.size() > 0) {
            com.tencent.mobileqq.app.activateFriends.a.i(this.app, arrayList);
        }
        a16.setReaded(AppConstants.ACTIVATE_FRIENDS_UIN, 9002);
        m mVar = this.f177787e0;
        if (mVar != null) {
            mVar.f();
        }
        Collections.sort(msgList, new c());
        if (QLog.isColorLevel()) {
            QLog.d("ActivateFriends.MainActivity", 2, "entrance type : " + getIntent().getIntExtra("af_key_from", 0));
        }
        if (i3 > 0 && msgList.size() > 0 && a16.checkIsForActivateFriends(msgList.get(0), new Function1() { // from class: com.tencent.mobileqq.activity.activateFriend.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Boolean F3;
                F3 = ActivateFriendActivity.F3(obj);
                return F3;
            }
        })) {
            Iterator<com.tencent.mobileqq.reminder.db.b> it5 = msgList.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                if (a16.checkIsForActivateFriends(it5.next(), new Function1() { // from class: com.tencent.mobileqq.activity.activateFriend.i
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Boolean G3;
                        G3 = ActivateFriendActivity.G3(obj);
                        return G3;
                    }
                })) {
                    com.tencent.mobileqq.reminder.db.c cVar = (com.tencent.mobileqq.reminder.db.c) msgList.get(0);
                    if (((SubMsgType0x76$MsgBody) cVar.getMsgBody()).uint32_msg_type.get() != 1) {
                        if (((SubMsgType0x76$MsgBody) cVar.getMsgBody()).uint32_msg_type.get() == 2) {
                            i16 = 1;
                            ReportController.o(this.app, "CliOper", "", "", "0X8004E05", "0X8004E05", i16, 0, getIntent().getIntExtra("af_key_from", 1) + "", "", "", "");
                        } else if (((SubMsgType0x76$MsgBody) cVar.getMsgBody()).uint32_msg_type.get() == 3) {
                            i17 = 2 + ((int) ((SubMsgType0x76$MsgBody) cVar.getMsgBody()).msg_memorialday_notify.rpt_anniversary_info.get(0).uint32_type.get());
                        } else {
                            i17 = -1;
                        }
                    }
                    i16 = i17;
                    ReportController.o(this.app, "CliOper", "", "", "0X8004E05", "0X8004E05", i16, 0, getIntent().getIntExtra("af_key_from", 1) + "", "", "", "");
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        if (i3 > 0 || z17) {
            for (final com.tencent.mobileqq.reminder.db.b bVar2 : msgList) {
                if ((a16.checkIsForActivateFriends(bVar2, new Function1() { // from class: com.tencent.mobileqq.activity.activateFriend.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Boolean H3;
                        H3 = ActivateFriendActivity.H3(com.tencent.mobileqq.reminder.db.b.this, obj);
                        return H3;
                    }
                }) && this.f177793k0) || a16.checkIsForReminder(bVar2, new Function1() { // from class: com.tencent.mobileqq.activity.activateFriend.k
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Boolean I3;
                        I3 = ActivateFriendActivity.I3(com.tencent.mobileqq.reminder.db.b.this, obj);
                        return I3;
                    }
                })) {
                    com.tencent.mobileqq.activity.activateFriend.biz.b bVar3 = new com.tencent.mobileqq.activity.activateFriend.biz.b();
                    bVar3.f177964c = bVar2.getTime();
                    bVar3.f177962a = bVar2;
                    bVar3.f177963b = null;
                    arrayList2.add(bVar3);
                }
            }
        }
        if (i3 == 0) {
            e3();
        }
        this.f177792j0.getTodayReminderMsgAsync(new d(arrayList2, i3), false);
        return true;
    }

    private boolean u3() {
        Intent intent = getIntent();
        if (intent == null) {
            return false;
        }
        int intExtra = intent.getIntExtra("af_key_from", 0);
        if (intExtra != 4 && intExtra != 3) {
            return false;
        }
        long longExtra = intent.getLongExtra("msg_hash", -1L);
        if (longExtra == this.f177797o0) {
            return false;
        }
        for (String str : this.f177792j0.getCacheKeyList()) {
            if (longExtra == str.hashCode()) {
                com.tencent.mobileqq.reminder.biz.entity.a entityByKey = this.f177792j0.getEntityByKey(str);
                this.f177797o0 = longExtra;
                AcsMsg acsMsg = entityByKey.getAcsMsg();
                if (af.d(acsMsg)) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ActivateFriends.MainActivity", 2, "ActivateFriends inter isAms");
                    }
                    return false;
                }
                y3(acsMsg);
                return true;
            }
        }
        return false;
    }

    private boolean v3() {
        ExpEntityInfo expEntity = ABTestController.getInstance().getExpEntity("exp_qq_container_box");
        if (!expEntity.isExperiment("exp_qq_container_box_B") && !expEntity.isExperiment("exp_qq_container_box_D") && !expEntity.isExperiment("exp_qq_container_box_E")) {
            return false;
        }
        return true;
    }

    private boolean w3() {
        ArrayList<ActivateBasePage> g16;
        m mVar = this.f177787e0;
        if (mVar == null || (g16 = mVar.g()) == null || g16.isEmpty()) {
            return false;
        }
        return g16.get(0) instanceof MemorialActivatePageArk;
    }

    private boolean x3() {
        ArrayList<ActivateBasePage> g16;
        m mVar = this.f177787e0;
        if (mVar == null || (g16 = mVar.g()) == null || g16.isEmpty()) {
            return false;
        }
        ActivateBasePage activateBasePage = g16.get(0);
        if (!(activateBasePage instanceof ReminderCardItemPage) || ((ReminderCardItemPage) activateBasePage).P == null) {
            return false;
        }
        return true;
    }

    private void y3(AcsMsg acsMsg) {
        if (isMiniAppUrl(acsMsg.applet_jump_url)) {
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(this, acsMsg.applet_jump_url, 2102, null);
        } else {
            s3(acsMsg.jump_url, 0);
        }
    }

    public static /* synthetic */ Boolean z3(com.tencent.mobileqq.reminder.db.b bVar, Object obj) {
        return Boolean.valueOf(bVar instanceof MessageForActivateFriends);
    }

    @Override // com.tencent.qqnt.kernel.invorker.d
    public void O0(int i3, int i16, @Nullable List<RecentContactInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), list);
        } else {
            if (i3 != 1) {
                return;
            }
            if (Looper.getMainLooper() == Looper.myLooper()) {
                ThreadManagerV2.excute(new com.tencent.mobileqq.activity.activateFriend.a(this), 32, null, true);
            } else {
                V3();
            }
        }
    }

    void R3(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("ActivateFriends.MainActivity", 2, "setIndicatorSelected-->index = " + i3);
        }
        int i16 = 0;
        if (this.f177790h0 <= 1) {
            while (i16 < this.f177788f0.getChildCount()) {
                this.f177788f0.getChildAt(i16).setVisibility(8);
                i16++;
            }
            return;
        }
        for (int i17 = 0; i17 < this.f177790h0; i17++) {
            this.f177788f0.getChildAt(i17).setVisibility(0);
        }
        while (i16 < this.f177788f0.getChildCount()) {
            if (i16 == i3) {
                ((ImageView) this.f177788f0.getChildAt(i16)).setImageResource(R.drawable.aio_face_indicator_current);
            } else {
                ((ImageView) this.f177788f0.getChildAt(i16)).setImageResource(R.drawable.aio_face_indicator);
            }
            i16++;
        }
        m mVar = this.f177787e0;
        if (mVar != null) {
            mVar.h(i3);
        }
    }

    void T3(com.tencent.mobileqq.reminder.db.b bVar, SparseBooleanArray sparseBooleanArray) {
        String jSONObject;
        submsgtype0x13a$MsgBody submsgtype0x13a_msgbody = (submsgtype0x13a$MsgBody) ((com.tencent.mobileqq.reminder.db.c) bVar).getMsgBody();
        long time = bVar.getTime() * 1000;
        if (submsgtype0x13a_msgbody == null) {
            return;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(submsgtype0x13a_msgbody.bytes_push_data.get().toStringUtf8());
            if (y.g(jSONObject2.optString("msg_id", "")) && !sparseBooleanArray.get(4, false)) {
                JSONObject optJSONObject = jSONObject2.optJSONObject("ark_data");
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("showReminderPage arkData:");
                    if (optJSONObject == null) {
                        jSONObject = "null";
                    } else {
                        jSONObject = optJSONObject.toString();
                    }
                    sb5.append(jSONObject);
                    QLog.d("ActivateFriends.MainActivity", 2, sb5.toString());
                }
                g3(time, optJSONObject);
                sparseBooleanArray.put(4, true);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public void U3() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        BirthdayActivatePageArkView birthdayActivatePageArkView = this.f177799q0;
        if (birthdayActivatePageArkView != null) {
            birthdayActivatePageArkView.m();
        }
        MemorialActivatePageArk memorialActivatePageArk = this.f177800r0;
        if (memorialActivatePageArk != null) {
            memorialActivatePageArk.m();
        }
        this.f177801s0.sendEmptyMessageDelayed(1, 5000L);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fe  */
    @Override // mqq.app.AppActivity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        ArrayList<ActivateBasePage> g16;
        ReminderCardItemPage reminderCardItemPage;
        AcsMsg acsMsg;
        String str;
        int length;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        StringBuilder sb5 = new StringBuilder("doOnActiResult");
        sb5.append(" | rs code = ");
        sb5.append(i16);
        int i17 = -1;
        if (i3 == 1000 && i16 == -1) {
            if (intent != null) {
                long[] longArrayExtra = intent.getLongArrayExtra("key_friend_list");
                int intExtra = intent.getIntExtra("key_msg_type", -1);
                long[] longArrayExtra2 = intent.getLongArrayExtra("key_time_list");
                String stringExtra = intent.getStringExtra("key_msg_content");
                int intExtra2 = intent.getIntExtra("key_gift_id", -1);
                if (longArrayExtra != null && longArrayExtra.length > 0 && intExtra != -1) {
                    this.f177791i0.D(longArrayExtra, intExtra);
                    if (intExtra == 2 && longArrayExtra2 != null && longArrayExtra2.length > 0 && stringExtra != null && stringExtra.length() != 0 && intExtra2 != -1) {
                        str = stringExtra;
                        this.f177791i0.K(intExtra, longArrayExtra, longArrayExtra2, stringExtra, intExtra2);
                        ReportController.o(this.app, "dc00898", "", "", "0X8007AD1", "0X8007AD1", longArrayExtra.length, 0, "", "", "", "");
                        if (QLog.isColorLevel()) {
                            sb5.append("uinArray_stampList:");
                            for (int i18 = 0; i18 < longArrayExtra.length; i18++) {
                                sb5.append(longArrayExtra[i18] + "_" + longArrayExtra2[i18] + "|");
                            }
                        }
                        sb5.append(" | uinArray len = ");
                        if (longArrayExtra != null) {
                            length = -1;
                        } else {
                            length = longArrayExtra.length;
                        }
                        sb5.append(length);
                        sb5.append(" | type = ");
                        sb5.append(intExtra);
                        sb5.append(" | stampList len = ");
                        if (longArrayExtra2 != null) {
                            i17 = longArrayExtra2.length;
                        }
                        sb5.append(i17);
                        sb5.append(" | message = ");
                        sb5.append(str);
                        sb5.append(" | giftId id = ");
                        sb5.append(intExtra2);
                    }
                }
                str = stringExtra;
                sb5.append(" | uinArray len = ");
                if (longArrayExtra != null) {
                }
                sb5.append(length);
                sb5.append(" | type = ");
                sb5.append(intExtra);
                sb5.append(" | stampList len = ");
                if (longArrayExtra2 != null) {
                }
                sb5.append(i17);
                sb5.append(" | message = ");
                sb5.append(str);
                sb5.append(" | giftId id = ");
                sb5.append(intExtra2);
            }
            super.finish();
        } else if (i3 == 2000 && i16 == -1) {
            String stringExtra2 = intent.getStringExtra("msg_id");
            if (QLog.isColorLevel()) {
                QLog.d("ActivateFriends.MainActivity", 2, "\u4ece\u5168\u90e8\u5217\u8868\u4e2d\u8fd4\u56de-----" + stringExtra2);
            }
            if (this.f177787e0 != null && !StringUtil.isEmpty(stringExtra2) && (g16 = this.f177787e0.g()) != null && !g16.isEmpty()) {
                Iterator<ActivateBasePage> it = g16.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivateBasePage next = it.next();
                    if ((next instanceof ReminderCardItemPage) && (acsMsg = (reminderCardItemPage = (ReminderCardItemPage) next).P) != null && stringExtra2.equals(acsMsg.msg_id) && this.f177794l0 >= reminderCardItemPage.P.notice_time * 1000) {
                        if (QLog.isColorLevel()) {
                            QLog.d("ActivateFriends.MainActivity", 2, "----------\u5237\u65b0\u9875\u9762------");
                        }
                        this.f177787e0.f();
                        t3();
                    }
                }
            }
        } else if (i3 == 2001 && this.f177787e0 != null) {
            if (QLog.isColorLevel()) {
                QLog.d("ActivateFriends.MainActivity", 2, "----------\u5237\u65b0\u9875\u9762------ qqbrowser");
            }
            ArrayList<ActivateBasePage> g17 = this.f177787e0.g();
            if (g17 != null && !g17.isEmpty()) {
                Iterator<ActivateBasePage> it5 = g17.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    }
                    ActivateBasePage next2 = it5.next();
                    if ((next2 instanceof ReminderCardItemPage) && ((ReminderCardItemPage) next2).P != null) {
                        if (QLog.isColorLevel()) {
                            QLog.d("ActivateFriends.MainActivity", 2, "----------\u5237\u65b0\u9875\u9762------");
                        }
                        this.f177787e0.f();
                        t3();
                    }
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("ActivateFriends.MainActivity", 2, sb5.toString());
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnConfigurationChanged(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) configuration);
        } else {
            super.doOnConfigurationChanged(configuration);
            l3();
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
        ca.a(this);
        this.f177794l0 = NetConnInfoCenter.getServerTimeMillis();
        this.f177792j0 = (IQQReminderDataService) this.app.getRuntimeService(IQQReminderDataService.class, "");
        S3();
        addObserver(this.f177803u0);
        this.app.registObserver(this.f177804v0);
        this.f177796n0 = false;
        if (QQTheme.isNowThemeIsNight()) {
            n3();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        removeObserver(this.f177803u0);
        this.app.unRegistObserver(this.f177804v0);
        ((IChatsUnreadAPI) QRoute.api(IChatsUnreadAPI.class)).removeExpandRecentContactListener(this);
        m mVar = this.f177787e0;
        if (mVar != null) {
            mVar.destroy();
        }
        View currentFocus = getCurrentFocus();
        if (currentFocus != null) {
            currentFocus.clearFocus();
        }
        this.f177796n0 = false;
        super.doOnDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
            return;
        }
        setIntent(intent);
        super.doOnNewIntent(intent);
        m mVar = this.f177787e0;
        if (mVar != null) {
            mVar.f();
            t3();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        super.doOnResume();
        u3();
        if (!this.f177795m0) {
            this.f177795m0 = true;
            t3();
        }
        m mVar = this.f177787e0;
        if (mVar != null) {
            mVar.refresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            super.doOnStart();
            this.f177792j0.setQQNotifyListener(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            super.doOnStop();
            this.f177792j0.setQQNotifyListener(null);
        }
    }

    public synchronized void i3(AcsMsg acsMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) acsMsg);
            return;
        }
        if (this.f177787e0 == null) {
            return;
        }
        ReminderCardItemPage b16 = ai.b(this, this.app, acsMsg);
        b16.k(acsMsg);
        Iterator<ActivateBasePage> it = this.f177787e0.g().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ActivateBasePage next = it.next();
            if ((next instanceof ReminderCardItemPage) && ((ReminderCardItemPage) next).l()) {
                it.remove();
                break;
            }
        }
        this.f177787e0.e(b16, 0);
        Q3();
        com.tencent.mobileqq.reminder.db.d.a(this.app).setReaded(AppConstants.ACTIVATE_FRIENDS_UIN, 0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else if (view.getId() == R.id.ivTitleBtnRightImage) {
            if (QLog.isColorLevel()) {
                QLog.d("ActivateFriends.MainActivity", 2, "do report: QQnotice.aio.detail.set");
            }
            ReportController.o(this.app, "P_CliOper", "QQnotice", "", "", "QQnotice.aio.detail.set", 0, 0, "", "", "", "");
            showActionSheet();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i3, float f16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Float.valueOf(f16), Integer.valueOf(i16));
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i3) {
        ArrayList<ActivateBasePage> g16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
            return;
        }
        this.f177789g0 = i3;
        ReportController.o(this.app, "dc00898", "", "", "0X8007AEB", "0X8007AEB", 0, 0, "", "", "", "");
        LpReportInfo_pf00064.allReport(220, 3);
        R3(i3);
        TopGestureLayout r36 = r3();
        int i16 = 1;
        if (r36 != null) {
            if (this.f177789g0 == 0) {
                r36.setInterceptTouchFlag(true);
            } else {
                r36.setInterceptTouchFlag(false);
            }
        }
        m mVar = this.f177787e0;
        if (mVar != null && (g16 = mVar.g()) != null && !g16.isEmpty()) {
            ActivateBasePage activateBasePage = g16.get(i3);
            if (activateBasePage instanceof ReminderCardItemPage) {
                if (QLog.isColorLevel()) {
                    QLog.d("ActivateFriends.MainActivity", 2, "do report: QQnotice.aio.detail.visit");
                }
                ReportController.o(this.app, "P_CliOper", "QQnotice", "", "", "QQnotice.aio.detail.visit", 0, 0, "", "", "", "");
                ReminderCardItemPage reminderCardItemPage = (ReminderCardItemPage) activateBasePage;
                MobileReportManager.getInstance().reportActionOfNotice(ReportParamsConst.APP_ID_QQNOTICE, "3", "1", 100, reminderCardItemPage.P.msg_id, "15", 1);
                if (!reminderCardItemPage.l()) {
                    AcsMsg acsMsg = reminderCardItemPage.P;
                    if (acsMsg.type != 0) {
                        i16 = 2;
                    }
                    y.c(this.app, "remindcontentpage_exp", acsMsg.busi_id, acsMsg.msg_id, String.valueOf(i16), acsMsg.mn_reserved, ai.a(acsMsg));
                    af.a(acsMsg);
                }
            }
        }
    }

    void showActionSheet() {
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this, null);
        actionSheet.addRadioButton(getString(R.string.f170008cr), this.f177793k0);
        actionSheet.setOnButtonClickListener(new g(actionSheet));
        actionSheet.addCancelButton(R.string.cancel);
        actionSheet.setOnBottomCancelListener(new h(actionSheet));
        actionSheet.show();
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) observable, obj);
            return;
        }
        if (obj instanceof MessageRecord) {
            if ((obj instanceof ChatMessage) && ((MessageRecord) obj).isSendFromLocal()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    ThreadManagerV2.excute(new com.tencent.mobileqq.activity.activateFriend.a(this), 32, null, true);
                } else {
                    V3();
                }
            }
        }
    }
}
