package com.tencent.mobileqq.leba.business.redtouch;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.confess.ConfessConfig;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.leba.business.redtouch.LebaSpecificRedTouchBiz;
import com.tencent.mobileqq.leba.entity.g;
import com.tencent.mobileqq.matchchat.MatchChatMsgUtil;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi;
import com.tencent.mobileqq.nearby.redtouch.INearbyRedInfo;
import com.tencent.mobileqq.nearbypro.entry.api.INearbyProEntryService;
import com.tencent.mobileqq.nearbypro.entry.api.INearbyProEntryUnreadService;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleRedPointAppidContants;
import com.tencent.mobileqq.qcircle.api.helper.QCircleObserver;
import com.tencent.mobileqq.qcircle.api.utils.QCircleHostUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqexpand.manager.e;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneApiProxy;
import com.tencent.richframework.thread.RFWThreadManager;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import qqcircle.QQCircleCounter$RedPointInfo;
import tencent.im.oidb.cmd0x791.oidb_0x791$RedDotInfo;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LebaSpecificRedTouchBiz extends com.tencent.mobileqq.leba.business.d {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static int f240280e;

    /* renamed from: b, reason: collision with root package name */
    protected boolean f240281b;

    /* renamed from: c, reason: collision with root package name */
    private a f240282c;

    /* renamed from: d, reason: collision with root package name */
    private int f240283d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.leba.business.redtouch.LebaSpecificRedTouchBiz$1, reason: invalid class name */
    /* loaded from: classes15.dex */
    public class AnonymousClass1 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RedTouch f240284d;

        AnonymousClass1(RedTouch redTouch) {
            this.f240284d = redTouch;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LebaSpecificRedTouchBiz.this, (Object) redTouch);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void b(boolean z16, RedTouch redTouch) {
            if (z16) {
                BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
                redTypeInfo.red_type.set(0);
                redTypeInfo.red_content.set("");
                redTypeInfo.red_desc.set("");
                redTouch.parseRedTouch(redTypeInfo);
                return;
            }
            redTouch.clearRedTouch();
        }

        @Override // java.lang.Runnable
        public void run() {
            final boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QQCircleCounter$RedPointInfo outerEntranceRedPointInfoByAppid = com.tencent.mobileqq.activity.qcircle.utils.c.f().getOuterEntranceRedPointInfoByAppid(QCircleRedPointAppidContants.QCIRCLE_ENTRANCE);
            if (outerEntranceRedPointInfoByAppid != null && (outerEntranceRedPointInfoByAppid.redTotalNum.get() > 0 || QCircleHostUtil.checkOperateMaskEnabled(outerEntranceRedPointInfoByAppid.outLayerInfo.combineRedTypes.get(), 3))) {
                z16 = true;
            } else {
                z16 = false;
            }
            Handler uIHandler = RFWThreadManager.getUIHandler();
            final RedTouch redTouch = this.f240284d;
            uIHandler.post(new Runnable() { // from class: com.tencent.mobileqq.leba.business.redtouch.d
                @Override // java.lang.Runnable
                public final void run() {
                    LebaSpecificRedTouchBiz.AnonymousClass1.b(z16, redTouch);
                }
            });
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.leba.business.redtouch.LebaSpecificRedTouchBiz$2, reason: invalid class name */
    /* loaded from: classes15.dex */
    class AnonymousClass2 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f240285d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Handler f240286e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ RedTouch f240287f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ long f240288h;
        final /* synthetic */ LebaSpecificRedTouchBiz this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            TroopRedTouchManager troopRedTouchManager = (TroopRedTouchManager) this.f240285d.getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
            INearbyRedInfo l3 = troopRedTouchManager.l(troopRedTouchManager.x(), false);
            if (QLog.isColorLevel()) {
                QLog.d("LebaSpecificRedTouchBiz", 2, "updateNearbyRedPointAsync, getNearbyRedPoint costTime=" + (System.currentTimeMillis() - currentTimeMillis));
            }
            this.f240286e.post(new Runnable(l3) { // from class: com.tencent.mobileqq.leba.business.redtouch.LebaSpecificRedTouchBiz.2.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ INearbyRedInfo f240289d;

                {
                    this.f240289d = l3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this, (Object) l3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    AnonymousClass2.this.f240287f.clearRedTouchInLebaTable();
                    AnonymousClass2.this.f240287f.setUseNewStyle(true);
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    anonymousClass2.this$0.v(anonymousClass2.f240285d, this.f240289d, anonymousClass2.f240287f);
                    AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                    anonymousClass22.this$0.c(anonymousClass22.f240288h, anonymousClass22.f240287f);
                    AnonymousClass2.this.f240287f.checkAndShowLebaWaterMark();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a extends QCircleObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<LebaSpecificRedTouchBiz> f240304d;

        /* renamed from: e, reason: collision with root package name */
        private WeakReference<RedTouch> f240305e;

        public a(LebaSpecificRedTouchBiz lebaSpecificRedTouchBiz, RedTouch redTouch) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) lebaSpecificRedTouchBiz, (Object) redTouch);
            } else {
                this.f240304d = new WeakReference<>(lebaSpecificRedTouchBiz);
                this.f240305e = new WeakReference<>(redTouch);
            }
        }

        @Override // com.tencent.mobileqq.qcircle.api.helper.QCircleObserver
        protected void onUpdateRedPoint(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3);
                return;
            }
            LebaSpecificRedTouchBiz lebaSpecificRedTouchBiz = this.f240304d.get();
            RedTouch redTouch = this.f240305e.get();
            if (lebaSpecificRedTouchBiz != null && redTouch != null) {
                lebaSpecificRedTouchBiz.w(redTouch);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72749);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            f240280e = -1;
        }
    }

    public LebaSpecificRedTouchBiz() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f240283d = 0;
        }
    }

    private void k(@NonNull QQAppInterface qQAppInterface, RedTouch redTouch) {
        if (redTouch != null && this.f240282c == null) {
            a aVar = new a(this, redTouch);
            this.f240282c = aVar;
            qQAppInterface.addObserver(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l(int i3, RedTouch redTouch) {
        if (i3 <= 0) {
            redTouch.clearRedTouch();
            return;
        }
        BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
        redTypeInfo.red_type.set(0);
        redTypeInfo.red_content.set("");
        redTypeInfo.red_desc.set("");
        redTouch.parseRedTouch(redTypeInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(boolean z16, boolean z17, boolean z18, RedTouch redTouch, long j3, QQAppInterface qQAppInterface, String str) {
        if (z16 && z17) {
            if (z18) {
                BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
                redTypeInfo.red_type.set(0);
                redTypeInfo.red_content.set("");
                redTypeInfo.red_desc.set("");
                redTouch.parseRedTouch(redTypeInfo);
                c(j3, redTouch);
            } else {
                redTouch.clearRedTouch();
                p(qQAppInterface, redTouch, str, j3);
            }
            redTouch.checkAndShowLebaWaterMark();
            return;
        }
        redTouch.clearRedTouch();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(final QQAppInterface qQAppInterface, final RedTouch redTouch, final long j3, final String str) {
        final boolean isShowNearbyProEntry = ((INearbyProEntryService) qQAppInterface.getRuntimeService(INearbyProEntryService.class, "")).isShowNearbyProEntry();
        INearbyProEntryUnreadService iNearbyProEntryUnreadService = (INearbyProEntryUnreadService) qQAppInterface.getRuntimeService(INearbyProEntryUnreadService.class, "");
        final boolean isShowRedDot = iNearbyProEntryUnreadService.isShowRedDot();
        final boolean hasUnreadMsgCntDot = iNearbyProEntryUnreadService.hasUnreadMsgCntDot();
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.leba.business.redtouch.c
            @Override // java.lang.Runnable
            public final void run() {
                LebaSpecificRedTouchBiz.this.m(isShowNearbyProEntry, isShowRedDot, hasUnreadMsgCntDot, redTouch, j3, qQAppInterface, str);
            }
        });
    }

    private void o(final RedTouch redTouch) {
        if (redTouch == null) {
            return;
        }
        final int qZoneUnReadCount = ((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).getQZoneUnReadCount(19);
        QLog.i("LebaSpecificRedTouchBiz", 1, "updateAlbumRedTouch unReadCount= " + qZoneUnReadCount);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.leba.business.redtouch.a
            @Override // java.lang.Runnable
            public final void run() {
                LebaSpecificRedTouchBiz.l(qZoneUnReadCount, redTouch);
            }
        });
    }

    private void t(QQAppInterface qQAppInterface, RedTouch redTouch, String str, long j3) {
        ThreadManagerV2.excute(new Runnable(redTouch, qQAppInterface, str, j3) { // from class: com.tencent.mobileqq.leba.business.redtouch.LebaSpecificRedTouchBiz.4
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ RedTouch f240298d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ QQAppInterface f240299e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f240300f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ long f240301h;

            {
                this.f240298d = redTouch;
                this.f240299e = qQAppInterface;
                this.f240300f = str;
                this.f240301h = j3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, LebaSpecificRedTouchBiz.this, redTouch, qQAppInterface, str, Long.valueOf(j3));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                int unreadNum = ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).getUnreadNum();
                if (QLog.isColorLevel()) {
                    QLog.d("LebaSpecificRedTouchBiz", 2, "updateLebaNewKuolieRedTouch() : " + unreadNum);
                }
                if (this.f240298d != null) {
                    ThreadManager.getUIHandler().post(new Runnable(unreadNum) { // from class: com.tencent.mobileqq.leba.business.redtouch.LebaSpecificRedTouchBiz.4.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ int f240302d;

                        {
                            this.f240302d = unreadNum;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this, unreadNum);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            if (this.f240302d <= 0) {
                                AnonymousClass4.this.f240298d.clearRedTouch();
                                AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                LebaSpecificRedTouchBiz.this.p(anonymousClass4.f240299e, anonymousClass4.f240298d, anonymousClass4.f240300f, anonymousClass4.f240301h);
                            } else {
                                AnonymousClass4.this.f240298d.clearRedTouchInLebaTable();
                                BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
                                AnonymousClass4.this.f240298d.setMaxNum(99);
                                AnonymousClass4.this.f240298d.setUseNewStyle(true);
                                redTypeInfo.red_content.set(String.valueOf(this.f240302d));
                                redTypeInfo.red_desc.set("{'cn':'#FF0000'}");
                                redTypeInfo.red_type.set(5);
                                AnonymousClass4.this.f240298d.parseRedTouch(redTypeInfo);
                                AnonymousClass4 anonymousClass42 = AnonymousClass4.this;
                                LebaSpecificRedTouchBiz.this.c(anonymousClass42.f240301h, anonymousClass42.f240298d);
                            }
                            AnonymousClass4.this.f240298d.checkAndShowLebaWaterMark();
                        }
                    });
                }
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(RedTouch redTouch) {
        if (redTouch == null) {
            return;
        }
        RFWThreadManager.getInstance().execOnSubThread(new AnonymousClass1(redTouch));
    }

    @Override // com.tencent.mobileqq.leba.business.d
    public boolean b(AppRuntime appRuntime, Context context, long j3, RedTouch redTouch, String str, Map<Long, g> map, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, appRuntime, context, Long.valueOf(j3), redTouch, str, map, Integer.valueOf(i3), Boolean.valueOf(z16))).booleanValue();
        }
        this.f240102a = map;
        this.f240281b = z16;
        String valueOf = String.valueOf(j3);
        if (!(appRuntime instanceof QQAppInterface)) {
            return false;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
        if (String.valueOf(6282).equals(valueOf)) {
            x(qQAppInterface, redTouch);
            c(j3, redTouch);
        } else if (7759 == j3) {
            redTouch.clearRedTouchInLebaTable();
            q(qQAppInterface, context, redTouch);
            c(j3, redTouch);
        } else if (4050 == j3) {
            u(qQAppInterface, redTouch, valueOf, j3, i3);
        } else if (7720 == j3) {
            r(qQAppInterface, redTouch, valueOf, str, j3, i3);
        } else if (785 == j3) {
            o(redTouch);
        } else if (4038 == j3) {
            t(qQAppInterface, redTouch, valueOf, j3);
        } else {
            if (4045 != j3) {
                return false;
            }
            k(qQAppInterface, redTouch);
            w(redTouch);
        }
        return true;
    }

    protected void p(QQAppInterface qQAppInterface, RedTouch redTouch, String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, qQAppInterface, redTouch, str, Long.valueOf(j3));
            return;
        }
        IRedTouchManager iRedTouchManager = (IRedTouchManager) qQAppInterface.getRuntimeService(IRedTouchManager.class, "");
        if (iRedTouchManager != null) {
            BusinessInfoCheckUpdate.AppInfo appInfo = iRedTouchManager.getAppInfo(0, str);
            if (this.f240281b) {
                redTouch.parseRedTouchInLebaTable(appInfo);
            } else {
                redTouch.parseRedTouch(appInfo);
            }
            c(j3, redTouch);
        }
    }

    protected void q(QQAppInterface qQAppInterface, Context context, RedTouch redTouch) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, qQAppInterface, context, redTouch);
            return;
        }
        if (qQAppInterface != null) {
            if (ConfessConfig.h(qQAppInterface, "redpoint_leba_show")) {
                ConfessConfig g16 = ((ConfessManager) qQAppInterface.getManager(QQManagerFactory.CONFESS_MANAGER)).g();
                if (g16 == null) {
                    str = "";
                } else {
                    str = g16.e(qQAppInterface);
                }
                if (!TextUtils.isEmpty(str) && !this.f240281b) {
                    BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
                    BusinessInfoCheckUpdate.AppInfo appInfo = new BusinessInfoCheckUpdate.AppInfo();
                    redTypeInfo.red_content.set(str);
                    redTypeInfo.red_type.set(4);
                    redTypeInfo.red_desc.set("{'cn':'#00000000','cr':'#888888'}");
                    appInfo.red_display_info.red_type_info.add(redTypeInfo);
                    BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo2 = new BusinessInfoCheckUpdate.RedTypeInfo();
                    redTypeInfo2.red_type.set(0);
                    redTypeInfo2.red_desc.set("");
                    redTypeInfo2.red_content.set("");
                    appInfo.red_display_info.red_type_info.add(redTypeInfo2);
                    appInfo.iNewFlag.set(1);
                    redTouch.parseRedTouch(appInfo);
                    try {
                        TextView textView = (TextView) redTouch.findViewById(30);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
                        textView.setMaxWidth(ViewUtils.dip2px(200.0f));
                        layoutParams.weight = 1.0f;
                        layoutParams.width = 0;
                        layoutParams.rightMargin = ViewUtils.dip2px(4.0f);
                        textView.setEllipsize(TextUtils.TruncateAt.END);
                        textView.setLayoutParams(layoutParams);
                        return;
                    } catch (Exception e16) {
                        QLog.i("LebaSpecificRedTouchBiz", 1, "updateConfessRedTouch", e16);
                        return;
                    }
                }
                BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo3 = new BusinessInfoCheckUpdate.RedTypeInfo();
                BusinessInfoCheckUpdate.AppInfo appInfo2 = new BusinessInfoCheckUpdate.AppInfo();
                redTypeInfo3.red_type.set(0);
                redTypeInfo3.red_desc.set("");
                redTypeInfo3.red_content.set("");
                appInfo2.red_display_info.red_type_info.add(redTypeInfo3);
                appInfo2.iNewFlag.set(1);
                redTouch.parseRedTouch(appInfo2);
                return;
            }
            redTouch.clearRedTouch();
        }
    }

    protected void r(QQAppInterface qQAppInterface, RedTouch redTouch, String str, String str2, long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, qQAppInterface, redTouch, str, str2, Long.valueOf(j3), Integer.valueOf(i3));
        } else {
            ThreadManager.getSubThreadHandler().post(new Runnable(qQAppInterface, redTouch, str, str2, j3) { // from class: com.tencent.mobileqq.leba.business.redtouch.LebaSpecificRedTouchBiz.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ QQAppInterface f240291d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ RedTouch f240292e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ String f240293f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ String f240294h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ long f240295i;

                {
                    this.f240291d = qQAppInterface;
                    this.f240292e = redTouch;
                    this.f240293f = str;
                    this.f240294h = str2;
                    this.f240295i = j3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, LebaSpecificRedTouchBiz.this, qQAppInterface, redTouch, str, str2, Long.valueOf(j3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    int d16 = MatchChatMsgUtil.d(this.f240291d);
                    if (QLog.isColorLevel()) {
                        QLog.d("LebaSpecificRedTouchBiz", 2, "updateExtendFriendRedTouch() : " + d16);
                    }
                    if (this.f240292e != null) {
                        ThreadManager.getUIHandler().post(new Runnable(d16) { // from class: com.tencent.mobileqq.leba.business.redtouch.LebaSpecificRedTouchBiz.3.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ int f240296d;

                            {
                                this.f240296d = d16;
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this, d16);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                    return;
                                }
                                if (this.f240296d <= 0) {
                                    AnonymousClass3.this.f240292e.clearRedTouch();
                                    AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                    LebaSpecificRedTouchBiz.this.s(anonymousClass3.f240291d, anonymousClass3.f240292e, anonymousClass3.f240293f, anonymousClass3.f240294h, anonymousClass3.f240295i);
                                } else {
                                    AnonymousClass3.this.f240292e.clearRedTouchInLebaTable();
                                    BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
                                    AnonymousClass3.this.f240292e.setMaxNum(99);
                                    AnonymousClass3.this.f240292e.setUseNewStyle(true);
                                    redTypeInfo.red_content.set(String.valueOf(this.f240296d));
                                    redTypeInfo.red_desc.set("{'cn':'#FF0000'}");
                                    redTypeInfo.red_type.set(5);
                                    AnonymousClass3.this.f240292e.parseRedTouch(redTypeInfo);
                                    AnonymousClass3 anonymousClass32 = AnonymousClass3.this;
                                    LebaSpecificRedTouchBiz.this.c(anonymousClass32.f240295i, anonymousClass32.f240292e);
                                }
                                AnonymousClass3.this.f240292e.checkAndShowLebaWaterMark();
                            }
                        });
                    }
                }
            });
        }
    }

    protected void s(QQAppInterface qQAppInterface, RedTouch redTouch, String str, String str2, long j3) {
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, qQAppInterface, redTouch, str, str2, Long.valueOf(j3));
            return;
        }
        IRedTouchManager iRedTouchManager = (IRedTouchManager) qQAppInterface.getRuntimeService(IRedTouchManager.class, "");
        e eVar = (e) qQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
        if (iRedTouchManager != null) {
            BusinessInfoCheckUpdate.AppInfo appInfoByPath = iRedTouchManager.getAppInfoByPath(str);
            if (eVar != null) {
                eVar.S(appInfoByPath);
            }
            if (appInfoByPath != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("LebaSpecificRedTouchBiz", 2, "updateKuolieRedTouch() kuolie appInfo.buffer: " + appInfoByPath.buffer.get());
                }
                List<BusinessInfoCheckUpdate.RedTypeInfo> list = appInfoByPath.red_display_info.red_type_info.get();
                if (list.size() > 0) {
                    JSONObject bufferExtParamAppInfo = iRedTouchManager.getBufferExtParamAppInfo(appInfoByPath);
                    if (QLog.isColorLevel()) {
                        QLog.d("LebaSpecificRedTouchBiz", 2, "updateKuolieRedTouch() kuolie appInfo bufferExtParam: " + bufferExtParamAppInfo);
                    }
                    if (bufferExtParamAppInfo != null) {
                        str3 = bufferExtParamAppInfo.optString("_red_ext_uin");
                    } else {
                        str3 = null;
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        for (BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo : list) {
                            if (redTypeInfo.red_type.get() == 3) {
                                try {
                                    JSONObject jSONObject = new JSONObject(redTypeInfo.red_desc.get());
                                    jSONObject.put("uin", str3);
                                    redTypeInfo.red_desc.set(jSONObject.toString());
                                } catch (Throwable th5) {
                                    QLog.e("LebaSpecificRedTouchBiz", 1, "updateKuolieRedTouch()  modify image reddot red_desc JSONException ", th5);
                                }
                            }
                        }
                    }
                }
            }
            if (this.f240281b) {
                redTouch.parseRedTouchInLebaTable(appInfoByPath);
            } else {
                redTouch.parseRedTouch(appInfoByPath);
            }
            c(j3, redTouch);
        }
    }

    protected void u(final QQAppInterface qQAppInterface, final RedTouch redTouch, final String str, final long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, qQAppInterface, redTouch, str, Long.valueOf(j3), Integer.valueOf(i3));
        } else if (qQAppInterface != null && redTouch != null) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.leba.business.redtouch.b
                @Override // java.lang.Runnable
                public final void run() {
                    LebaSpecificRedTouchBiz.this.n(qQAppInterface, redTouch, j3, str);
                }
            }, 16, null, true);
        }
    }

    protected void v(QQAppInterface qQAppInterface, INearbyRedInfo iNearbyRedInfo, RedTouch redTouch) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, qQAppInterface, iNearbyRedInfo, redTouch);
            return;
        }
        if (redTouch == null) {
            return;
        }
        f240280e = iNearbyRedInfo.getRedAppIdType();
        this.f240283d = iNearbyRedInfo.getRedPointReportType();
        int redType = iNearbyRedInfo.getRedType();
        if (redType != 0) {
            if (redType != 3) {
                if (redType != 5) {
                    if (redType != 11) {
                        redTouch.parseRedTouch((BusinessInfoCheckUpdate.RedTypeInfo) null);
                        return;
                    }
                    if (!this.f240281b) {
                        BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
                        redTypeInfo.red_type.set(0);
                        redTypeInfo.red_content.set("");
                        redTypeInfo.red_desc.set("");
                        redTouch.parseRedTouch(redTypeInfo);
                        return;
                    }
                    BusinessInfoCheckUpdate.AppInfo appInfo = new BusinessInfoCheckUpdate.AppInfo();
                    boolean z17 = true;
                    appInfo.iNewFlag.set(1);
                    appInfo.exposure_max.set(1);
                    BusinessInfoCheckUpdate.RedDisplayInfo redDisplayInfo = new BusinessInfoCheckUpdate.RedDisplayInfo();
                    if (!TextUtils.isEmpty(iNearbyRedInfo.getCornerInfo()) || !TextUtils.isEmpty(iNearbyRedInfo.getTipTextInfo())) {
                        BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo2 = new BusinessInfoCheckUpdate.RedTypeInfo();
                        if (!TextUtils.isEmpty(iNearbyRedInfo.getCornerInfo())) {
                            redTypeInfo2.red_type.set(11);
                            redTypeInfo2.red_content.set(iNearbyRedInfo.getCornerInfo());
                            redDisplayInfo.red_type_info.add(redTypeInfo2);
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (!TextUtils.isEmpty(iNearbyRedInfo.getTipTextInfo())) {
                            BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo3 = new BusinessInfoCheckUpdate.RedTypeInfo();
                            redTypeInfo3.red_type.set(-100);
                            redTypeInfo3.red_content.set(iNearbyRedInfo.getTipTextInfo());
                            redDisplayInfo.red_type_info.add(redTypeInfo3);
                        } else {
                            z17 = false;
                        }
                        if (!z16 && z17) {
                            BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo4 = new BusinessInfoCheckUpdate.RedTypeInfo();
                            redTypeInfo4.red_type.set(0);
                            redDisplayInfo.red_type_info.add(redTypeInfo4);
                        }
                        appInfo.red_display_info.set(redDisplayInfo);
                        redTouch.parseRedTouchInLebaTable(appInfo);
                        return;
                    }
                    return;
                }
                BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo5 = new BusinessInfoCheckUpdate.RedTypeInfo();
                redTypeInfo5.red_type.set(5);
                String str = iNearbyRedInfo.getRedNum() + "";
                if (iNearbyRedInfo.getRedNum() > 99) {
                    str = "99+";
                }
                redTypeInfo5.red_content.set(str);
                redTypeInfo5.red_desc.set("{'cn':'#FF0000'}");
                redTouch.parseRedTouch(redTypeInfo5);
                return;
            }
            if (this.f240281b) {
                BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo6 = new BusinessInfoCheckUpdate.RedTypeInfo();
                redTypeInfo6.red_type.set(0);
                redTypeInfo6.red_content.set("");
                redTypeInfo6.red_desc.set("");
                redTouch.parseRedTouch(redTypeInfo6);
                return;
            }
            String str2 = iNearbyRedInfo.getRedUrl().get(0);
            BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo7 = new BusinessInfoCheckUpdate.RedTypeInfo();
            redTypeInfo7.red_type.set(3);
            redTypeInfo7.red_content.set(str2);
            redTypeInfo7.red_desc.set("{'av':1, 'dot':1}");
            redTouch.parseRedTouch(redTypeInfo7);
            return;
        }
        BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo8 = new BusinessInfoCheckUpdate.RedTypeInfo();
        redTypeInfo8.red_type.set(0);
        redTypeInfo8.red_content.set("");
        redTypeInfo8.red_desc.set("");
        redTouch.parseRedTouch(redTypeInfo8);
    }

    protected void x(QQAppInterface qQAppInterface, RedTouch redTouch) {
        int i3;
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQAppInterface, (Object) redTouch);
            return;
        }
        if (redTouch == null) {
            return;
        }
        TroopRedTouchManager troopRedTouchManager = (TroopRedTouchManager) qQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX);
        oidb_0x791$RedDotInfo p16 = troopRedTouchManager.p();
        if (p16 == null) {
            redTouch.clearRedTouch();
            return;
        }
        id0.a.n(TabPreloadItem.TAB_NAME_DYNAMIC, "exp_story", 0, troopRedTouchManager.q(), new String[0]);
        BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
        BusinessInfoCheckUpdate.AppInfo appInfo = new BusinessInfoCheckUpdate.AppInfo();
        int i16 = p16.uint32_appid.get();
        if (i16 != 8) {
            if (i16 != 11) {
                if (i16 != 35) {
                    if (i16 != 37) {
                        if (i16 == 52) {
                            PBStringField pBStringField = redTypeInfo.red_content;
                            if (p16.uint32_number.get() > 99) {
                                str2 = "99+";
                            } else {
                                str2 = p16.uint32_number.get() + "";
                            }
                            pBStringField.set(str2);
                            redTypeInfo.red_desc.set("{'cn':'#FF0000'}");
                        }
                    } else {
                        try {
                            str = new JSONObject(p16.str_custom_buffer.get().toStringUtf8()).getString("red_word");
                        } catch (Exception e16) {
                            hd0.c.v("LebaSpecificRedTouchBiz", "tag red dot json parse error , %s", e16.getMessage());
                            str = "New";
                        }
                        redTypeInfo.red_content.set(str);
                        redTypeInfo.red_desc.set("{'cn':'#00000000' ,'cr':'#777777'}");
                    }
                } else {
                    String stringUtf8 = p16.str_custom_buffer.get().toStringUtf8();
                    if (!TextUtils.isEmpty(stringUtf8)) {
                        try {
                            long optLong = new JSONObject(stringUtf8).optLong("image_red_display_780", 1L);
                            hd0.c.i("LebaSpecificRedTouchBiz", "updateStoryRedTouch() APPID_STORY_IMG: red display=%d", Long.valueOf(optLong));
                            if (optLong == 0) {
                                redTouch.clearRedTouch();
                            }
                        } catch (JSONException e17) {
                            hd0.c.h("LebaSpecificRedTouchBiz", "updateStoryRedTouch() APPID_STORY_IMG: Error parse json: ", e17);
                        }
                    } else {
                        hd0.c.a("LebaSpecificRedTouchBiz", "updateStoryRedTouch() APPID_STORY_IMG: str_custom_buffer is null");
                    }
                    int i17 = p16.uint32_cmd_uin_type.get();
                    String str3 = "{'av':1, 'dot':1}";
                    if (i17 == 0) {
                        String stringUtf82 = p16.str_face_url.get().toStringUtf8();
                        String format = String.format("{'uin':'%s','dot':1, 'av':1}", p16.uint64_cmd_uin.get() + "");
                        if (!TextUtils.isEmpty(stringUtf82)) {
                            redTypeInfo.red_content.set(stringUtf82);
                        } else {
                            str3 = format;
                        }
                        redTypeInfo.red_desc.set(str3);
                    } else if (i17 == 1) {
                        redTypeInfo.red_content.set(ITroopAvatarUtilApi.REGEXP_URL_STRING + p16.uint64_cmd_uin.get() + "/" + p16.uint64_cmd_uin.get() + "/100?t=" + TroopRedTouchManager.F);
                        redTypeInfo.red_desc.set("{'av':1, 'dot':1}");
                    }
                    i3 = 3;
                }
                i3 = -1;
            } else {
                redTypeInfo.red_content.set(p16.str_custom_buffer.get().toStringUtf8() + "");
                redTypeInfo.red_desc.set("{'cn':'#FF0000'}");
            }
            i3 = 4;
        } else {
            i3 = 0;
        }
        if (i3 == -1) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("storyRedDotDebug", 2, "\u66f4\u65b0\u52a8\u6001\u7ea2\u70b9:" + TroopRedTouchManager.y(p16));
        }
        redTypeInfo.red_type.set(i3);
        appInfo.red_display_info.red_type_info.add(redTypeInfo);
        appInfo.iNewFlag.set(1);
        redTouch.parseRedTouch(redTypeInfo);
    }
}
