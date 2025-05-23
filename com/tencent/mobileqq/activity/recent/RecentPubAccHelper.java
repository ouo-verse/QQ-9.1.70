package com.tencent.mobileqq.activity.recent;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.cc;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;

/* loaded from: classes10.dex */
public class RecentPubAccHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private static int f185164f;

    /* renamed from: g, reason: collision with root package name */
    public static CopyOnWriteArrayList<a> f185165g;

    /* renamed from: a, reason: collision with root package name */
    private Activity f185166a;

    /* renamed from: b, reason: collision with root package name */
    private MqqHandler f185167b;

    /* renamed from: c, reason: collision with root package name */
    private QQProgressDialog f185168c;

    /* renamed from: d, reason: collision with root package name */
    private Runnable f185169d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f185170e;

    /* renamed from: com.tencent.mobileqq.activity.recent.RecentPubAccHelper$4, reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass4 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f185171d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ RecentBaseData f185172e;
        final /* synthetic */ RecentPubAccHelper this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("RecentPubAccHelper", 2, "updateUnfollowInfo");
            }
            ((IPublicAccountManager) QRoute.api(IPublicAccountManager.class)).removeMsgID(this.f185171d, this.f185172e.getRecentUserUin());
            IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) this.f185171d.getRuntimeService(IPublicAccountDataManager.class, "all");
            if (iPublicAccountDataManager != null) {
                iPublicAccountDataManager.delPublicAccountInfoCache(this.f185172e.getRecentUserUin());
                iPublicAccountDataManager.delPublicAccountInfo(this.f185172e.getRecentUserUin());
                IPublicAccountDetail findAccountDetailInfo = iPublicAccountDataManager.findAccountDetailInfo(this.f185172e.getRecentUserUin());
                if (findAccountDetailInfo != null) {
                    this.this$0.b(findAccountDetailInfo, this.f185171d);
                }
            }
            this.f185171d.getMessageFacade().q(this.f185172e.getRecentUserUin(), 1008);
            RecentUtil.I0(this.f185171d, this.f185172e.getRecentUserUin(), 1008);
            cc.a(" pubAcc_follow_cancel", null, this.f185172e.getRecentUserUin());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        long f185173a;

        /* renamed from: b, reason: collision with root package name */
        String f185174b;

        /* renamed from: c, reason: collision with root package name */
        String f185175c;

        public a(String str, String str2, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, Long.valueOf(j3));
                return;
            }
            this.f185174b = str;
            this.f185175c = str2;
            this.f185173a = j3;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69170);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f185164f = -1;
            f185165g = new CopyOnWriteArrayList<>();
        }
    }

    public RecentPubAccHelper(MqqHandler mqqHandler, Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mqqHandler, (Object) activity);
            return;
        }
        this.f185169d = new Runnable() { // from class: com.tencent.mobileqq.activity.recent.RecentPubAccHelper.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RecentPubAccHelper.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    RecentPubAccHelper.this.n(false);
                }
            }
        };
        this.f185170e = false;
        this.f185167b = mqqHandler;
        this.f185166a = activity;
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(IPublicAccountDetail iPublicAccountDetail, QQAppInterface qQAppInterface) {
        if (iPublicAccountDetail == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("RecentPubAccHelper", 2, "deleteAccount");
        }
        EntityManager createEntityManager = qQAppInterface.getEntityManagerFactory().createEntityManager();
        createEntityManager.remove(iPublicAccountDetail.getEntity());
        createEntityManager.close();
    }

    private int c() {
        return this.f185166a.getResources().getDimensionPixelSize(R.dimen.title_bar_height);
    }

    public static boolean e(String str) {
        QQAppInterface qQAppInterface;
        IPublicAccountDataManager iPublicAccountDataManager;
        if (TextUtils.isEmpty(str) || (qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()) == null || (iPublicAccountDataManager = (IPublicAccountDataManager) qQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all")) == null) {
            return false;
        }
        IPublicAccountDetail findAccountDetailInfoCache = iPublicAccountDataManager.findAccountDetailInfoCache(str);
        if (findAccountDetailInfoCache != null && !findAccountDetailInfoCache.isShowFollowButton()) {
            return false;
        }
        if (findAccountDetailInfoCache == null && "1770946116".equals(str)) {
            return false;
        }
        if (findAccountDetailInfoCache != null && AppConstants.PUBLIC_ACCOUNT_READINJOY_FOLLOW_UIN.equals(str)) {
            return false;
        }
        if (((PublicAccountInfo) iPublicAccountDataManager.findPublicAccountInfoCache(str)) != null) {
            return true;
        }
        if (findAccountDetailInfoCache == null || findAccountDetailInfoCache.getFollowType() != 1) {
            return false;
        }
        return true;
    }

    public static boolean f() {
        int i3 = f185164f;
        if (i3 >= 0) {
            if (i3 > 0) {
                return true;
            }
            return false;
        }
        boolean isFeatureSwitchEnable = ((IFeatureRuntimeService) BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("public_account_enable_top_and_hide");
        f185164f = isFeatureSwitchEnable ? 1 : 0;
        QLog.i("RecentPubAccHelper", 1, "isShowNewMenuItem toggle switch=" + isFeatureSwitchEnable);
        return isFeatureSwitchEnable;
    }

    public static void i(QQAppInterface qQAppInterface, String str, int i3, int i16, int i17, String str2) {
        int i18 = 4;
        if (i16 > 0 && i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3 && i3 != 4) {
                        i18 = 3;
                    }
                } else {
                    i18 = 2;
                }
            }
            i18 = 1;
        }
        if (QLog.isColorLevel()) {
            QLog.d("RecentPubAccHelper", 2, "reportUserClickPubAccEnterAIO --pUin: " + str + ", pName: " + str2 + ", unReadNum: " + i16, ", unReadFlag: " + i18 + ", from: " + i17);
        }
        ReportController.o(qQAppInterface, "dc00898", "", str, "0X8009A31", "0X8009A31", 0, 0, String.valueOf(i18), String.valueOf(i17), str2, "");
    }

    public static void j(QQAppInterface qQAppInterface, String str, int i3, int i16, int i17, String str2, boolean z16) {
        String str3;
        int i18 = 4;
        if (i16 > 0 && i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3 && i3 != 4) {
                        i18 = 3;
                    }
                } else {
                    i18 = 2;
                }
            }
            i18 = 1;
        }
        if (QLog.isColorLevel()) {
            QLog.d("RecentPubAccHelper", 2, "reportUserDelPublicAcc --pUin: " + str + ", pName: " + str2 + ", unReadNum: " + i16 + ", unReadFlag: " + i18 + ", from: " + i17);
        }
        if (z16) {
            str3 = "0X8009A33";
        } else {
            str3 = "0X800BDDA";
        }
        String str4 = str3;
        ReportController.o(qQAppInterface, "dc00898", "", str, str4, str4, 0, 0, String.valueOf(i18), String.valueOf(i17), str2, "");
    }

    public static void k(QQAppInterface qQAppInterface) {
        if (QLog.isColorLevel()) {
            QLog.d("RecentPubAccHelper", 2, "reportUserStayPublicAccAIOTime --mPubAccEnterList.size: " + f185165g.size());
        }
        if (f185165g.size() > 0) {
            Iterator<a> it = f185165g.iterator();
            while (it.hasNext()) {
                a next = it.next();
                long currentTimeMillis = System.currentTimeMillis() - next.f185173a;
                if (currentTimeMillis <= 3600000) {
                    l(qQAppInterface, next.f185174b, currentTimeMillis, next.f185175c);
                }
            }
        }
        f185165g.clear();
    }

    public static void l(QQAppInterface qQAppInterface, String str, long j3, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("RecentPubAccHelper", 2, "reportUserStayPublicAccAIOTime --pUin: " + str + ", pName: " + str2 + ", time: " + j3);
        }
        ReportController.o(qQAppInterface, "dc00898", "", str, "0X8009A32", "0X8009A32", 0, 0, String.valueOf(j3), "", str2, "");
    }

    public static void m(QQAppInterface qQAppInterface, String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("RecentPubAccHelper", 2, "reportUserUnfollowPublicAcc --pUin: " + str + ", pName: " + str2);
        }
        ReportController.o(qQAppInterface, "dc00898", "", str, "0X8009A34", "0X8009A34", 0, 0, "", "", str2, "");
    }

    public void g(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQAppInterface);
        } else {
            f185165g.clear();
        }
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QQProgressDialog qQProgressDialog = this.f185168c;
        if (qQProgressDialog != null) {
            qQProgressDialog.dismiss();
        }
        this.f185168c = null;
        MqqHandler mqqHandler = this.f185167b;
        if (mqqHandler != null) {
            mqqHandler.removeCallbacks(this.f185169d);
        }
        f185165g.clear();
    }

    public void n(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
            return;
        }
        if (this.f185168c == null) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(this.f185166a, c());
            this.f185168c = qQProgressDialog;
            qQProgressDialog.setMessage(R.string.d7l);
            this.f185168c.setCanceledOnTouchOutside(true);
        }
        QQProgressDialog qQProgressDialog2 = this.f185168c;
        if (qQProgressDialog2 != null) {
            if (z16 && !qQProgressDialog2.isShowing()) {
                this.f185168c.show();
                this.f185167b.postDelayed(this.f185169d, 1000L);
            } else if (!z16 && this.f185168c.isShowing()) {
                this.f185168c.dismiss();
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("RecentPubAccHelper", 2, "showProgressBar->show:" + z16);
        }
    }

    private void d() {
    }
}
