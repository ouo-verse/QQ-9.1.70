package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsDelMsgRsp;
import Wallet.AcsMsg;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.reminder.api.IQQReminderCalendarService;
import com.tencent.mobileqq.reminder.api.IQQReminderService;
import com.tencent.mobileqq.reminder.biz.entity.CalendarEntity;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.db;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.en;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.mobilereport.MobileReportManager;
import cooperation.qzone.mobilereport.ReportParamsConst;
import java.lang.ref.WeakReference;
import mqq.observer.BusinessObserver;

/* loaded from: classes9.dex */
public class ReminderCardItemPage extends ActivateBasePage implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private static int Q;
    private QQAppInterface C;
    private ImageView D;
    private TextView E;
    private TextView F;
    private TextView G;
    private RelativeLayout H;
    private RelativeLayout I;
    private RoundImageView J;
    private TextView K;
    private TextView L;
    private TextView M;
    private Button N;
    public AcsMsg P;

    /* renamed from: m, reason: collision with root package name */
    private ActivateFriendActivity f177885m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a implements URLDrawable.URLDrawableListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f177891d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ImageView f177892e;

        a(boolean z16, ImageView imageView) {
            this.f177891d = z16;
            this.f177892e = imageView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ReminderCardItemPage.this, Boolean.valueOf(z16), imageView);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) uRLDrawable);
            } else {
                QLog.d("ReminderCardItemPage", 1, "setImageFromUrl onLoadCanceled");
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) uRLDrawable, (Object) th5);
            } else {
                QLog.d("ReminderCardItemPage", 1, "setImageFromUrl onLoadFialed");
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) uRLDrawable, i3);
            } else {
                QLog.d("ReminderCardItemPage", 1, "setImageFromUrl onLoadProgressed");
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) uRLDrawable);
                return;
            }
            QLog.d("ReminderCardItemPage", 1, "setImageFromUrl onLoadSuccess");
            try {
                Drawable currDrawable = uRLDrawable.getCurrDrawable();
                if (this.f177891d) {
                    int i3 = ReminderCardItemPage.Q;
                    if (i3 == 0) {
                        i3 = this.f177892e.getWidth();
                    }
                    this.f177892e.setScaleType(ImageView.ScaleType.MATRIX);
                    Matrix matrix = new Matrix();
                    float intrinsicWidth = (i3 * 1.0f) / currDrawable.getIntrinsicWidth();
                    matrix.setScale(intrinsicWidth, intrinsicWidth);
                    this.f177892e.setImageMatrix(matrix);
                }
            } catch (Throwable th5) {
                QLog.e("ReminderCardItemPage", 1, "setImageFromUrl: with a error: ", th5);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67695);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            Q = 0;
        }
    }

    public ReminderCardItemPage(Context context, QQAppInterface qQAppInterface) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) qQAppInterface);
        } else {
            this.f177885m = (ActivateFriendActivity) context;
            this.C = qQAppInterface;
        }
    }

    private void i(View view) {
        String str = (String) view.getTag(R.id.aqc);
        if (af.d(this.P)) {
            if (QLog.isColorLevel()) {
                QLog.d("ReminderCardItemPage", 1, "is AMS reminder: ", Boolean.TRUE);
            }
            af.b(new WeakReference(this.f177885m), this.P, "https://act.qzone.qq.com/vip/meteor/blockly/p/4403xdf3cc");
        } else if (m(str)) {
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(this.f177885m, str, 2102, null);
        } else {
            j((String) view.getTag(), 0);
        }
    }

    private void j(String str, int i3) {
        if (StringUtil.isEmpty(str)) {
            str = "https://act.qzone.qq.com/vip/meteor/blockly/p/4403xdf3cc";
        }
        Uri parse = Uri.parse(str);
        if (parse != null) {
            String scheme = parse.getScheme();
            if (!StringUtil.isEmpty(scheme)) {
                if (scheme.startsWith("http") || scheme.startsWith("https")) {
                    if (i3 == 0) {
                        db.a(getContext(), str, true, true);
                    } else {
                        db.c(this.f177885m, str, true, i3);
                    }
                }
                if (scheme.startsWith(SchemaUtils.SCHEMA_MQQAPI)) {
                    db.b(getContext(), str);
                }
            }
        }
    }

    private boolean m(String str) {
        if (!StringUtil.isEmpty(str) && ((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppUrl(str)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n() {
        r(this.f177779e.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        int i29 = i18 - i16;
        if (i28 - i26 != i29) {
            r(i29);
        }
    }

    private void q(ImageView imageView, String str, boolean z16) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestHeight = imageView.getHeight();
        obtain.mRequestWidth = imageView.getWidth();
        obtain.mUseMemoryCache = false;
        URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
        if (drawable == null) {
            return;
        }
        drawable.setURLDrawableListener(new a(z16, imageView));
        imageView.setImageDrawable(drawable);
    }

    private void r(int i3) {
        ViewGroup.LayoutParams layoutParams = this.J.getLayoutParams();
        layoutParams.height = Math.min((ScreenUtil.getInstantScreenHeight(getContext()) * 452) / 1334, (int) (i3 * 0.44f));
        this.J.setLayoutParams(layoutParams);
    }

    @Override // com.tencent.mobileqq.activity.activateFriend.ActivateBasePage
    protected void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        View findViewById = this.f177779e.findViewById(R.id.tnz);
        if (findViewById != null) {
            findViewById.setBackgroundResource(R.drawable.kv_);
        }
        TextView textView = (TextView) this.f177779e.findViewById(R.id.f164739to1);
        if (textView != null) {
            textView.setTextColor(-2130706433);
        }
        this.K.setTextColor(-1);
        this.L.setTextColor(-1);
        this.F.setTextColor(-1);
        TextView textView2 = (TextView) this.f177779e.findViewById(R.id.aqb);
        if (textView2 != null) {
            textView2.setTextColor(-1);
        }
    }

    @Override // com.tencent.mobileqq.activity.activateFriend.ActivateBasePage
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        try {
            if (Q == 0) {
                Q = ViewUtils.getScreenWidth() - ViewUtils.dpToPx(84.0f);
            }
        } catch (Throwable th5) {
            QLog.e("ReminderCardItemPage", 1, "initUI getWidth with a error: ", th5);
        }
        View inflate = this.f177778d.inflate(R.layout.aqo, (ViewGroup) this, false);
        this.f177779e = inflate;
        this.D = (ImageView) inflate.findViewById(R.id.aqi);
        this.E = (TextView) this.f177779e.findViewById(R.id.aql);
        this.H = (RelativeLayout) this.f177779e.findViewById(R.id.aqh);
        this.I = (RelativeLayout) this.f177779e.findViewById(R.id.aqe);
        RoundImageView roundImageView = (RoundImageView) this.f177779e.findViewById(R.id.aqf);
        this.J = roundImageView;
        roundImageView.setmRadius(UIUtils.b(getContext(), 4.0f), true);
        this.K = (TextView) this.f177779e.findViewById(R.id.aqm);
        this.L = (TextView) this.f177779e.findViewById(R.id.aqd);
        ((TextView) this.f177779e.findViewById(R.id.aqb)).setOnClickListener(this);
        Button button = (Button) this.f177779e.findViewById(R.id.aqc);
        this.N = button;
        button.setOnClickListener(this);
        this.M = (TextView) this.f177779e.findViewById(R.id.lc9);
        TextView textView = (TextView) this.f177779e.findViewById(R.id.f164738to0);
        this.F = textView;
        textView.setOnClickListener(this);
        this.G = (TextView) this.f177779e.findViewById(R.id.tol);
        this.f177779e.post(new Runnable() { // from class: com.tencent.mobileqq.activity.activateFriend.ag
            @Override // java.lang.Runnable
            public final void run() {
                ReminderCardItemPage.this.n();
            }
        });
        this.f177779e.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.activity.activateFriend.ah
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                ReminderCardItemPage.this.o(view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        });
        addView(this.f177779e);
    }

    public void k(AcsMsg acsMsg) {
        boolean z16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) acsMsg);
            return;
        }
        try {
            this.P = acsMsg;
            if (acsMsg == null) {
                this.E.setVisibility(4);
                this.H.setVisibility(0);
                this.I.setVisibility(8);
                this.N.setVisibility(8);
                q(this.D, "https://i.gtimg.cn/channel/imglib/201905/upload_d06258d2e506e8f9f37614f2826e8234.png", false);
                return;
            }
            this.E.setVisibility(0);
            this.H.setVisibility(8);
            this.I.setVisibility(0);
            this.N.setVisibility(0);
            this.E.setText(en.d(getContext(), 3, acsMsg.notice_time * 1000));
            if (acsMsg.banner_type == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            RoundImageView roundImageView = this.J;
            if (TextUtils.isEmpty(acsMsg.banner_url)) {
                str = "https://sola.gtimg.cn/aoi/sola/20200520104458_ifeJLiwYMW.png";
            } else {
                str = acsMsg.banner_url;
            }
            q(roundImageView, str, z16);
            this.K.setText(acsMsg.title);
            this.L.setText(acsMsg.content);
            this.N.setText(acsMsg.btn_text);
            this.N.setTag(acsMsg.jump_url);
            this.N.setTag(R.id.aqc, acsMsg.applet_jump_url);
            if (acsMsg.type == 1) {
                this.G.setVisibility(0);
                this.F.setVisibility(0);
            }
        } catch (Throwable th5) {
            QLog.e("ReminderCardItemPage", 1, "initData throw an exception: " + th5);
        }
    }

    public boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (this.H.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            int i3 = 2;
            if (id5 == R.id.aqb) {
                if (this.P != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ReminderCardItemPage", 2, "do report: QQnotice.aio.detail.all");
                    }
                    QQAppInterface qQAppInterface = this.C;
                    AcsMsg acsMsg = this.P;
                    ReportController.o(qQAppInterface, "P_CliOper", "QQnotice", "", "", "QQnotice.aio.detail.all", 0, 0, "", "", acsMsg.busi_id, acsMsg.msg_id);
                    QQAppInterface qQAppInterface2 = this.C;
                    AcsMsg acsMsg2 = this.P;
                    y.c(qQAppInterface2, "remindcontentpage_allclick", acsMsg2.busi_id, acsMsg2.msg_id, null, String.valueOf(acsMsg2.mn_reserved), ai.a(this.P));
                }
                j("https://ti.qq.com/remind/index", 2001);
            } else if (id5 == R.id.aqc) {
                if (this.P != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ReminderCardItemPage", 2, "do report: QQnotice.aio.detail.click");
                    }
                    AcsMsg acsMsg3 = this.P;
                    if (acsMsg3.type == 0) {
                        i3 = 1;
                    }
                    ReportController.o(this.C, "P_CliOper", "QQnotice", "", "", "QQnotice.aio.detail.click", 0, 0, "", "", acsMsg3.busi_id, acsMsg3.msg_id);
                    MobileReportManager.getInstance().reportActionOfNotice(ReportParamsConst.APP_ID_QQNOTICE, "3", "2", 102, this.P.msg_id, "15", 1);
                    QQAppInterface qQAppInterface3 = this.C;
                    AcsMsg acsMsg4 = this.P;
                    y.c(qQAppInterface3, "remindcontentpage_contentclick", acsMsg4.busi_id, acsMsg4.msg_id, String.valueOf(i3), String.valueOf(this.P.mn_reserved), ai.a(this.P));
                    IQQGameHelper iQQGameHelper = (IQQGameHelper) QRoute.api(IQQGameHelper.class);
                    AcsMsg acsMsg5 = this.P;
                    iQQGameHelper.reportNoticeToDc87("914027", "20", "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9377", "937701", acsMsg5.msg_id, acsMsg5.busi_id);
                }
                i(view);
            } else if (id5 == R.id.f164738to0) {
                QQAppInterface qQAppInterface4 = this.C;
                AcsMsg acsMsg6 = this.P;
                y.c(qQAppInterface4, "remindcontentpage_rejectclick", acsMsg6.busi_id, acsMsg6.msg_id, null, acsMsg6.mn_reserved, ai.a(acsMsg6));
                p();
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        IQQReminderService iQQReminderService = (IQQReminderService) this.C.getRuntimeService(IQQReminderService.class, "");
        if (iQQReminderService != null) {
            iQQReminderService.sendDelReminderListById(this.P.msg_id, r0.mn_appid, 1, new BusinessObserver() { // from class: com.tencent.mobileqq.activity.activateFriend.ReminderCardItemPage.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ReminderCardItemPage.this);
                    }
                }

                @Override // mqq.observer.BusinessObserver
                public void onReceive(int i3, boolean z16, Bundle bundle) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                        return;
                    }
                    Runnable runnable = new Runnable(i3, z16, bundle) { // from class: com.tencent.mobileqq.activity.activateFriend.ReminderCardItemPage.2.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ int f177887d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ boolean f177888e;

                        /* renamed from: f, reason: collision with root package name */
                        final /* synthetic */ Bundle f177889f;

                        {
                            this.f177887d = i3;
                            this.f177888e = z16;
                            this.f177889f = bundle;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, this, AnonymousClass2.this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            int i16;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            ReminderCardItemPage reminderCardItemPage = ReminderCardItemPage.this;
                            if (reminderCardItemPage.P.mn_appid == 0) {
                                i16 = 0;
                            } else {
                                i16 = 1;
                            }
                            if (this.f177887d == 2001) {
                                if (this.f177888e) {
                                    AcsDelMsgRsp acsDelMsgRsp = (AcsDelMsgRsp) this.f177889f.getSerializable("rsp");
                                    if (acsDelMsgRsp == null) {
                                        y.j(ReminderCardItemPage.this.f177885m, -1, i16);
                                        return;
                                    } else {
                                        y.j(ReminderCardItemPage.this.f177885m, acsDelMsgRsp.ret_code, i16);
                                        return;
                                    }
                                }
                                y.j(reminderCardItemPage.f177885m, -1, i16);
                            }
                        }
                    };
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        runnable.run();
                    } else {
                        ReminderCardItemPage.this.C.runOnUiThread(runnable);
                    }
                }
            });
        }
        IQQReminderCalendarService iQQReminderCalendarService = (IQQReminderCalendarService) this.C.getRuntimeService(IQQReminderCalendarService.class, "");
        CalendarEntity calendarEntity = new CalendarEntity();
        calendarEntity.msg_id = this.P.msg_id;
        iQQReminderCalendarService.deleteCalendarAlarm(this.f177885m, calendarEntity);
    }

    public ReminderCardItemPage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }
}
