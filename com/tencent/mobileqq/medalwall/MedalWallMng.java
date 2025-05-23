package com.tencent.mobileqq.medalwall;

import SummaryCard.TMedalWallInfo;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.MedalInfo;
import com.tencent.mobileqq.nearby.k;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.profilecard.more.ProfileCardMoreConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.ea;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MedalWallMng implements Manager, Handler.Callback {
    static IPatchRedirector $redirector_;
    protected static final String I;
    public static int J;
    public static int K;
    public static int L;
    public static int M;
    public static int N;
    public static int P;
    public static int Q;
    protected final WeakReferenceHandler C;
    private String D;
    private String E;
    private String F;
    private boolean G;
    private int H;

    /* renamed from: d, reason: collision with root package name */
    protected final SparseArray<MedalInfo> f245723d;

    /* renamed from: e, reason: collision with root package name */
    protected final ArrayList<a> f245724e;

    /* renamed from: f, reason: collision with root package name */
    protected int f245725f;

    /* renamed from: h, reason: collision with root package name */
    protected int f245726h;

    /* renamed from: i, reason: collision with root package name */
    protected QQAppInterface f245727i;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f245728m;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class DownloadResTask implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final a f245729d;

        public DownloadResTask(a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MedalWallMng.this, (Object) aVar);
            } else {
                this.f245729d = aVar;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j3 = 0;
            if (TextUtils.isEmpty(this.f245729d.f245731b)) {
                a aVar = this.f245729d;
                aVar.f245735f = 2;
                aVar.f245736g = 1000;
            } else {
                try {
                    File file = new File(this.f245729d.f245732c);
                    a aVar2 = this.f245729d;
                    aVar2.f245736g = HttpDownloadUtil.downloadData(MedalWallMng.this.f245727i, aVar2.f245731b, file, 2);
                    j3 = SystemClock.elapsedRealtime() - elapsedRealtime;
                    a aVar3 = this.f245729d;
                    if (aVar3.f245736g == 0) {
                        aVar3.f245735f = 1;
                    } else {
                        aVar3.f245735f = 2;
                    }
                } catch (Throwable th5) {
                    a aVar4 = this.f245729d;
                    aVar4.f245735f = 2;
                    aVar4.f245736g = 2000;
                    th5.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.i("MedalWallMng", 2, "DownloadResTask", th5);
                    }
                }
            }
            Message obtain = Message.obtain();
            obtain.what = 2;
            obtain.arg1 = (int) j3;
            obtain.obj = this.f245729d;
            MedalWallMng.this.C.sendMessage(obtain);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public MedalInfo f245730a;

        /* renamed from: b, reason: collision with root package name */
        public String f245731b;

        /* renamed from: c, reason: collision with root package name */
        public String f245732c;

        /* renamed from: d, reason: collision with root package name */
        public String f245733d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f245734e;

        /* renamed from: f, reason: collision with root package name */
        public int f245735f;

        /* renamed from: g, reason: collision with root package name */
        public int f245736g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f245737h;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f245731b = null;
            this.f245732c = null;
            this.f245733d = null;
            this.f245734e = false;
            this.f245735f = 0;
            this.f245736g = 0;
            this.f245737h = false;
        }

        public boolean a() {
            JSONObject jSONObject;
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            if (TextUtils.isEmpty(this.f245731b)) {
                try {
                    JSONArray jSONArray = new JSONArray(this.f245730a.strResJson);
                    int length = jSONArray.length();
                    MedalInfo medalInfo = this.f245730a;
                    if (medalInfo.iLevelCount > 1 && length > (i3 = medalInfo.iLevel)) {
                        jSONObject = jSONArray.getJSONObject(i3);
                    } else if (length > 1) {
                        jSONObject = jSONArray.getJSONObject(1);
                    } else {
                        jSONObject = null;
                    }
                    if (jSONObject != null && jSONObject.has("owned3d")) {
                        this.f245731b = MedalWallMng.y(jSONObject.getString("owned3d"));
                    }
                    if (jSONObject != null && jSONObject.has("share")) {
                        this.f245733d = MedalWallMng.y(jSONObject.getString("share"));
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.i("MedalWallMng", 2, "parse res json fail", e16);
                    }
                }
            }
            if (!TextUtils.isEmpty(this.f245731b) && TextUtils.isEmpty(this.f245732c)) {
                this.f245732c = MedalWallMng.I + MD5Utils.toMD5(this.f245731b);
            }
            int i16 = this.f245735f;
            if (i16 == 2) {
                this.f245734e = true;
            } else if (i16 == 1) {
                this.f245734e = true;
            } else if (FileUtils.fileExistsAndNotEmpty(this.f245732c)) {
                this.f245734e = true;
            }
            return this.f245734e;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73030);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
            return;
        }
        I = l();
        J = 1;
        K = 2;
        L = 3;
        M = 4;
        N = 5;
        P = 6;
        Q = 7;
    }

    public MedalWallMng(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f245728m = false;
        this.G = false;
        this.H = Integer.MIN_VALUE;
        this.f245727i = qQAppInterface;
        this.f245723d = new SparseArray<>(3);
        this.f245724e = new ArrayList<>();
        this.C = new WeakReferenceHandler(ThreadManagerV2.getSubThreadLooper(), this);
        this.f245725f = 0;
    }

    public static void a(MedalInfo medalInfo, StringBuilder sb5) {
        if (sb5 == null) {
            return;
        }
        sb5.append("MedalInfo[");
        sb5.append("iId: ");
        sb5.append(medalInfo.iId);
        sb5.append(",");
        sb5.append("iType: ");
        sb5.append(medalInfo.iType);
        sb5.append(",");
        sb5.append("iLevel: ");
        sb5.append(medalInfo.iLevel);
        sb5.append(",");
        sb5.append("iLevelCount: ");
        sb5.append(medalInfo.iLevelCount);
        sb5.append(",");
        sb5.append("lEndTime: ");
        sb5.append(medalInfo.lEndTime);
        sb5.append(",");
        sb5.append("iUnreadLevel1: ");
        sb5.append(medalInfo.iUnreadLevel1);
        sb5.append(",");
        sb5.append("iUnreadLevel2: ");
        sb5.append(medalInfo.iUnreadLevel2);
        sb5.append(",");
        sb5.append("iUnreadLevel3: ");
        sb5.append(medalInfo.iUnreadLevel3);
        sb5.append(",");
        sb5.append("iNoProgress: ");
        sb5.append(medalInfo.iNoProgress);
        sb5.append(",");
        sb5.append("] ");
    }

    public static void b(MedalID medalID, StringBuilder sb5) {
        if (sb5 == null) {
            return;
        }
        sb5.append("MedalID[");
        sb5.append("id: ");
        sb5.append(medalID.f245721d);
        sb5.append(",");
        sb5.append("level: ");
        sb5.append(medalID.f245722e);
        sb5.append("] ");
    }

    private void f() {
        int i3;
        if (QLog.isDevelopLevel()) {
            QLog.i("MedalWallMng", 4, "doCheckForLogin");
        }
        this.C.removeMessages(3);
        LocalRedTouchManager localRedTouchManager = (LocalRedTouchManager) this.f245727i.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
        RedTouchItem j3 = localRedTouchManager.j(10015);
        boolean c16 = localRedTouchManager.c(j3);
        if (QLog.isColorLevel()) {
            QLog.d("MedalWallMng", 2, String.format("doCheckForLogin item=%s hasMedalRedPoint=%s", j3, Boolean.valueOf(c16)));
        }
        if (c16) {
            i3 = BaseApplicationImpl.getApplication().getSharedPreferences(String.format(Locale.getDefault(), "%s%s", "medal_wall_", this.f245727i.getAccount()), 4).getInt("MEDAL_CHECK_RES_STATE", 0);
            if (i3 == 2) {
                s();
            } else {
                d();
            }
        } else {
            x(0);
            i3 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MedalWallMng", 2, String.format("doCheckForLogin hasMedalRedPoint=%s, flag=%s", Boolean.valueOf(c16), Integer.valueOf(i3)));
        }
    }

    private void g() {
        int i3;
        a aVar;
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "doCheckMedalRes checkedCount: %d", Integer.valueOf(this.f245725f)));
        }
        synchronized (this.f245724e) {
            int i16 = this.f245725f;
            if (i16 > 0) {
                i3 = i16 - 1;
            } else {
                i3 = 0;
            }
            aVar = null;
            while (true) {
                if (i3 < this.f245724e.size()) {
                    aVar = this.f245724e.get(i3);
                    if (aVar != null && !aVar.f245734e) {
                        if (aVar.a()) {
                            this.f245725f = i3 + 1;
                            v(aVar);
                            i3++;
                        } else {
                            z16 = true;
                            break;
                        }
                    }
                    this.f245725f = i3 + 1;
                    i3++;
                } else {
                    z16 = false;
                    break;
                }
            }
        }
        if (z16) {
            ThreadManagerV2.post(new DownloadResTask(aVar), 5, null, false);
        } else if (this.f245726h > 0) {
            x(2);
        } else {
            x(1);
        }
    }

    private synchronized void k() {
        StringBuilder sb5;
        if (this.f245728m) {
            return;
        }
        if (QLog.isColorLevel()) {
            sb5 = new StringBuilder(200);
        } else {
            sb5 = null;
        }
        List<? extends Entity> query = this.f245727i.getEntityManagerFactory().createEntityManager().query(MedalInfo.class);
        if (query != null && query.size() > 0) {
            synchronized (this.f245723d) {
                this.f245723d.clear();
                Iterator<? extends Entity> it = query.iterator();
                while (it.hasNext()) {
                    MedalInfo medalInfo = (MedalInfo) it.next();
                    if (medalInfo != null) {
                        this.f245723d.put(medalInfo.iId, medalInfo);
                        if (QLog.isColorLevel() && sb5 != null) {
                            a(medalInfo, sb5);
                            sb5.append("\r\n");
                        }
                    }
                }
            }
        }
        this.f245728m = true;
        if (QLog.isColorLevel() && sb5 != null) {
            QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "init size: %d \r\n{%s}", Integer.valueOf(this.f245723d.size()), sb5.toString()));
        }
    }

    private static String l() {
        if (cu.e()) {
            return new File(BaseApplicationImpl.getApplication().getExternalCacheDir(), "medal_wall").getAbsolutePath();
        }
        return new File(BaseApplicationImpl.getApplication().getFilesDir(), "medal_wall").getAbsolutePath();
    }

    private void m() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
        this.D = defaultSharedPreferences.getString("hostUrl", "");
        this.E = defaultSharedPreferences.getString("guestUrl", "");
        this.F = defaultSharedPreferences.getString("shareUrl", "");
        if (QLog.isColorLevel()) {
            QLog.i("MedalWallMng", 4, String.format("onGetConfig,local hostUrl:%s,guestUrl:%s,shareUrl:%s", this.D, this.E, this.F));
        }
        if (TextUtils.isEmpty(this.D)) {
            this.D = ProfileCardMoreConstants.MODEL_WELL;
        }
        if (TextUtils.isEmpty(this.E)) {
            this.E = ProfileCardMoreConstants.MODEL_WELL;
        }
        if (TextUtils.isEmpty(this.F)) {
            this.F = "https://ti.qq.com/qqmedal2/share.html?_wv=16777217&_wwv=4&_bid=2450";
        }
    }

    private boolean n() {
        boolean z16;
        if (ea.x0(this.f245727i.getApplication(), this.f245727i.getCurrentAccountUin()) != 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.G = z16;
        if (z16) {
            return true;
        }
        Card q16 = ((FriendsManager) this.f245727i.getManager(QQManagerFactory.FRIENDS_MANAGER)).q(this.f245727i.getCurrentAccountUin());
        if (q16 == null) {
            QLog.e("MedalWallMng", 1, "isMedalOff is error! selfCard is null!");
            return false;
        }
        if (!q16.medalSwitchDisable && !Utils.G(this.f245727i.getCurrentAccountUin())) {
            return false;
        }
        return true;
    }

    private void v(a aVar) {
        if (aVar == null || aVar.f245730a == null || !FileUtils.fileExistsAndNotEmpty(aVar.f245732c)) {
            return;
        }
        try {
            Resources resources = BaseApplicationImpl.getApplication().getResources();
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ago);
            obtain.mRequestWidth = dimensionPixelSize;
            obtain.mRequestHeight = dimensionPixelSize;
            URLDrawable.getDrawable(new File(aVar.f245732c), obtain).startDownload(true);
        } catch (Exception e16) {
            QLog.e("MedalWallMng", 1, "tryPreloadImg fail.", e16);
        }
    }

    private void x(int i3) {
        if (QLog.isColorLevel()) {
            QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "updateCheckResFlag value: %d", Integer.valueOf(i3)));
        }
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences(String.format(Locale.getDefault(), "%s%s", "medal_wall_", this.f245727i.getAccount()), 4);
        if (sharedPreferences.getInt("MEDAL_CHECK_RES_STATE", 0) != i3) {
            sharedPreferences.edit().putInt("MEDAL_CHECK_RES_STATE", i3).apply();
        }
    }

    public static String y(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("MedalWallMng", 2, String.format("validateUrl>>> url=%s", str));
        }
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.startsWith("https://")) {
            return str;
        }
        String str2 = "https://" + str;
        if (QLog.isColorLevel()) {
            QLog.d("MedalWallMng", 2, String.format("validateUrl<<< url=%s", str2));
        }
        return str2;
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (o()) {
            if (QLog.isColorLevel()) {
                QLog.i("MedalWallMng", 2, "checkForLogin medal strong reminder is off!");
            }
        } else if (n()) {
            if (QLog.isDevelopLevel()) {
                QLog.i("MedalWallMng", 4, "checkForLogin medal is off!");
            }
        } else {
            this.C.removeMessages(3);
            this.C.sendEmptyMessageDelayed(3, 1000L);
        }
    }

    protected void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (o()) {
            if (QLog.isColorLevel()) {
                QLog.i("MedalWallMng", 2, "checkMedalWall medal strong reminder is off!");
                return;
            }
            return;
        }
        if (n()) {
            if (QLog.isDevelopLevel()) {
                QLog.i("MedalWallMng", 4, "checkMedalWall medal is off!");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "checkMedalWall mIsInit: %s", Boolean.valueOf(this.f245728m)));
        }
        this.C.removeMessages(3);
        this.C.removeMessages(1);
        this.f245725f = 0;
        this.f245726h = 0;
        k();
        ArrayList arrayList = new ArrayList();
        synchronized (this.f245723d) {
            for (int i3 = 0; i3 < this.f245723d.size(); i3++) {
                MedalInfo valueAt = this.f245723d.valueAt(i3);
                if (valueAt != null && valueAt.isUnread()) {
                    a aVar = new a();
                    aVar.f245730a = valueAt;
                    arrayList.add(aVar);
                }
            }
        }
        synchronized (this.f245724e) {
            this.f245724e.clear();
            this.f245724e.addAll(arrayList);
        }
        if (this.f245725f < this.f245724e.size()) {
            this.C.sendEmptyMessage(1);
        }
    }

    public boolean e(QBaseActivity qBaseActivity, View view, int i3, Object obj) {
        MedalInfo medalInfo;
        int i16;
        int i17;
        MedalInfo medalInfo2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, qBaseActivity, view, Integer.valueOf(i3), obj)).booleanValue();
        }
        if (o()) {
            if (QLog.isColorLevel()) {
                QLog.i("MedalWallMng", 2, "checkShowMedalGuide medal strong reminder is off!");
            }
            return false;
        }
        if (this.G) {
            if (QLog.isColorLevel()) {
                QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "checkShowMedalGuide isMedalConfigOff: %s", Boolean.valueOf(this.G)));
            }
            return false;
        }
        LocalRedTouchManager localRedTouchManager = (LocalRedTouchManager) this.f245727i.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
        RedTouchItem j3 = localRedTouchManager.j(10015);
        boolean c16 = localRedTouchManager.c(j3);
        if (QLog.isColorLevel()) {
            QLog.d("MedalWallMng", 2, String.format("checkShowMedalGuide item=%s hasMedalRedPoint=%s", j3, Boolean.valueOf(c16)));
        }
        if (!c16) {
            if (QLog.isDevelopLevel()) {
                QLog.i("MedalWallMng", 4, "checkShowMedalGuide no red point");
            }
            return false;
        }
        a aVar = null;
        try {
            Iterator<a> it = this.f245724e.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null && !next.f245737h && next.f245734e && !TextUtils.isEmpty(next.f245731b) && !TextUtils.isEmpty(next.f245732c) && next.f245735f != 2 && (medalInfo2 = next.f245730a) != null && (aVar == null || medalInfo2.isNewer(aVar.f245730a))) {
                    aVar = next;
                }
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        if (aVar != null && (medalInfo = aVar.f245730a) != null) {
            aVar.f245737h = true;
            if (obj instanceof Card) {
                Card card = (Card) obj;
                int i18 = medalInfo.iLevel;
                if (i18 == 255) {
                    if (medalInfo.iUnreadLevel1 == 1) {
                        i17 = 0;
                        i16 = 1;
                        card.iNewCount -= i16;
                        card.iUpgradeCount -= i17;
                    }
                    i16 = 0;
                    i17 = 0;
                    card.iNewCount -= i16;
                    card.iUpgradeCount -= i17;
                } else {
                    if (medalInfo.iLevelCount > 1) {
                        if (i18 >= 1 && medalInfo.iUnreadLevel1 == 1) {
                            i16 = 1;
                        } else {
                            i16 = 0;
                        }
                        if (i18 >= 2 && medalInfo.iUnreadLevel2 == 1) {
                            i17 = 1;
                        } else {
                            i17 = 0;
                        }
                        if (i18 >= 3 && medalInfo.iUnreadLevel3 == 1) {
                            i17++;
                        }
                        card.iNewCount -= i16;
                        card.iUpgradeCount -= i17;
                    }
                    i16 = 0;
                    i17 = 0;
                    card.iNewCount -= i16;
                    card.iUpgradeCount -= i17;
                }
            }
            Message obtain = Message.obtain();
            obtain.what = 4;
            obtain.obj = aVar;
            this.C.sendMessage(obtain);
            MedalGuideView.h(aVar, qBaseActivity, view, i3);
            if (QLog.isDevelopLevel()) {
                QLog.i("MedalWallMng", 4, String.format(Locale.getDefault(), "checkShowMedalGuide [%d, %d,  %s]", Integer.valueOf(medalInfo.iId), Integer.valueOf(medalInfo.iLevel), medalInfo.strName));
            }
            return true;
        }
        if (!QLog.isDevelopLevel()) {
            return false;
        }
        QLog.i("MedalWallMng", 4, "checkShowMedalGuide no medal to show");
        return false;
    }

    public MedalInfo h(int i3) {
        MedalInfo medalInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (MedalInfo) iPatchRedirector.redirect((short) 10, (Object) this, i3);
        }
        k();
        synchronized (this.f245723d) {
            medalInfo = this.f245723d.get(i3);
        }
        if (medalInfo == null) {
            MedalInfo medalInfo2 = new MedalInfo();
            medalInfo2.iId = i3;
            medalInfo2.iLevel = 0;
            medalInfo2.iUnreadLevel1 = 0;
            medalInfo2.iUnreadLevel2 = 0;
            medalInfo2.iUnreadLevel3 = 0;
            return medalInfo2;
        }
        return medalInfo;
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
                if (i3 != 3) {
                    if (i3 == 4) {
                        Object obj = message.obj;
                        if (obj instanceof a) {
                            u(0, (a) obj);
                        }
                    }
                } else {
                    f();
                }
            } else {
                a aVar = (a) message.obj;
                if (aVar != null) {
                    if (aVar.f245735f == 2) {
                        this.f245726h++;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "MSG_DOWNLOAD_RES_RESULT failCount: %d, cost: %d, failCode: %d, url: %s", Integer.valueOf(this.f245726h), Integer.valueOf(message.arg1), Integer.valueOf(aVar.f245736g), aVar.f245731b));
                    }
                }
                if (this.f245725f < this.f245724e.size()) {
                    this.C.sendEmptyMessage(1);
                }
            }
        } else {
            g();
        }
        return true;
    }

    public String i(boolean z16, String str, int i3) {
        StringBuilder sb5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, this, Boolean.valueOf(z16), str, Integer.valueOf(i3));
        }
        if (this.D == null || this.E == null || this.F == null) {
            m();
        }
        if (!z16) {
            sb5 = new StringBuilder(this.E);
            sb5.append("&tuin=");
            sb5.append(k.b(str));
        } else {
            sb5 = new StringBuilder(this.D);
        }
        sb5.append("&from=");
        sb5.append(i3);
        if (QLog.isDevelopLevel()) {
            QLog.i("MedalWallMng", 4, String.format(Locale.getDefault(), "getMedalWallUrl url: %s", sb5));
        }
        return sb5.toString();
    }

    public String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        if (this.D == null || this.E == null || this.F == null) {
            m();
        }
        return this.F;
    }

    public boolean o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.H == Integer.MIN_VALUE) {
            this.H = ea.z0(this.f245727i.getApp(), this.f245727i.getCurrentAccountUin(), 3);
            if (QLog.isColorLevel()) {
                QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "isMedalStrongReminderOff value: %s", Integer.valueOf(this.H)));
            }
        }
        if (this.H != 1) {
            return false;
        }
        return true;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        synchronized (this.f245723d) {
            this.f245723d.clear();
        }
        synchronized (this.f245724e) {
            this.f245724e.clear();
        }
        this.f245728m = false;
    }

    public void p(int i3, String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), str, str2, str3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("MedalWallMng", 4, String.format("onGetConfig,hostUrl:%s,guestUrl:%s,shareUrl:%s", str, str2, str3));
        }
        if (this.D == null || this.E == null || this.F == null) {
            m();
        }
        if (Utils.p(str, this.D) && Utils.p(str2, this.E) && Utils.p(str3, this.F)) {
            if (QLog.isColorLevel()) {
                QLog.i("MedalWallMng", 4, "onGetConfig, no change return.");
                return;
            }
            return;
        }
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
        edit.putString("hostUrl", str);
        edit.putString("guestUrl", str2);
        edit.putString("shareUrl", str3);
        edit.commit();
        this.D = str;
        this.E = str2;
        this.F = str3;
        if (i3 != 1) {
            z16 = true;
        }
        this.G = z16;
    }

    public void q(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        this.H = i3;
        if (QLog.isColorLevel()) {
            QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "onGetMedalStrongReminderConfig value: %s", Integer.valueOf(i3)));
        }
    }

    public void r(boolean z16, TMedalWallInfo tMedalWallInfo, SparseArray<MedalInfo> sparseArray) {
        MedalInfo medalInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), tMedalWallInfo, sparseArray);
            return;
        }
        k();
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder(200);
            sb5.append("onGetSelfNewObtainedMedaInfo isSuc:");
            sb5.append(z16);
            if (tMedalWallInfo != null) {
                sb5.append(", iMedalCount:");
                sb5.append(tMedalWallInfo.iMedalCount);
                sb5.append(", iNewCount:");
                sb5.append(tMedalWallInfo.iNewCount);
                sb5.append(", iUpgradeCount:");
                sb5.append(tMedalWallInfo.iUpgradeCount);
            }
            if (sparseArray != null) {
                sb5.append(", medalInfoArrayList: ");
                sb5.append(sparseArray.size());
                for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                    MedalInfo valueAt = sparseArray.valueAt(i3);
                    if (valueAt != null) {
                        sb5.append("\r\n info [id: ");
                        sb5.append(valueAt.iId);
                        sb5.append(", iLevel: ");
                        sb5.append(valueAt.iLevel);
                        sb5.append(", name: ");
                        sb5.append(valueAt.strName);
                        sb5.append(", res: ");
                        sb5.append(valueAt.strResJson);
                        sb5.append("]");
                    }
                }
            }
            QLog.i("MedalWallMng", 2, sb5.toString());
        }
        if (!z16) {
            x(2);
        } else {
            EntityManager createEntityManager = this.f245727i.getEntityManagerFactory().createEntityManager();
            synchronized (this.f245723d) {
                for (int i16 = 0; i16 < this.f245723d.size(); i16++) {
                    MedalInfo valueAt2 = this.f245723d.valueAt(i16);
                    if (valueAt2 != null) {
                        if (sparseArray != null) {
                            medalInfo = sparseArray.get(valueAt2.iId);
                        } else {
                            medalInfo = null;
                        }
                        if (medalInfo == null && valueAt2.isUnread()) {
                            valueAt2.setRead();
                            if (valueAt2.getStatus() == 1000) {
                                createEntityManager.persistOrReplace(valueAt2);
                            } else if (valueAt2.getStatus() == 1001 || valueAt2.getStatus() == 1002) {
                                createEntityManager.update(valueAt2);
                            }
                            if (QLog.isColorLevel()) {
                                QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "onGetSelfNewObtainedMedaInfo just local is unread [id: %d, level: %d, name: %s]", Integer.valueOf(valueAt2.iId), Integer.valueOf(valueAt2.iLevel), valueAt2.strName));
                            }
                        }
                    }
                }
            }
            for (int i17 = 0; sparseArray != null && i17 < sparseArray.size(); i17++) {
                MedalInfo valueAt3 = sparseArray.valueAt(i17);
                if (valueAt3 != null) {
                    if (valueAt3.getStatus() == 1000) {
                        createEntityManager.persistOrReplace(valueAt3);
                    } else if (valueAt3.getStatus() == 1001 || valueAt3.getStatus() == 1002) {
                        createEntityManager.update(valueAt3);
                    }
                    synchronized (this.f245723d) {
                        this.f245723d.put(valueAt3.iId, valueAt3);
                    }
                }
            }
            w(tMedalWallInfo, true);
            x(0);
        }
        d();
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        boolean o16 = o();
        boolean n3 = n();
        if (QLog.isColorLevel()) {
            QLog.d("MedalWallMng", 2, String.format("onGetSelfObtainNewMedalNotice isMedalStrongReminderOff=%s isMedalOff=%s", Boolean.valueOf(o16), Boolean.valueOf(n3)));
        }
        if (!o16 && !n3) {
            this.C.removeMessages(3);
            ((CardHandler) this.f245727i.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a3(this.f245727i.getCurrentUin());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0093, code lost:
    
        if (r5.iUnreadLevel1 != 2) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<MedalID> t(String str) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (ArrayList) iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
        }
        ArrayList<MedalID> arrayList = new ArrayList<>();
        try {
            String[] split = str.replaceAll("new_medals=", "").replaceAll("update_medals=", "").replaceAll(ContainerUtils.FIELD_DELIMITER, ",").split(",");
            for (int i3 = 0; i3 < split.length; i3++) {
                String str2 = split[i3];
                if (str2 != null && !str2.isEmpty()) {
                    String[] split2 = split[i3].split("_");
                    if (split2.length == 3) {
                        arrayList.add(new MedalID(Integer.parseInt(split2[0]), Integer.parseInt(split2[1])));
                    }
                }
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                MedalID medalID = arrayList.get(size);
                MedalInfo h16 = h(medalID.f245721d);
                int i16 = medalID.f245722e;
                if (i16 != 1) {
                    if (i16 != 2) {
                        if (i16 != 3) {
                            if (i16 == 255) {
                            }
                            z16 = false;
                        } else {
                            if (h16.iUnreadLevel3 == 2) {
                                z16 = true;
                            }
                            z16 = false;
                        }
                    } else {
                        if (h16.iUnreadLevel2 == 2) {
                            z16 = true;
                        }
                        z16 = false;
                    }
                } else {
                    if (h16.iUnreadLevel1 == 2) {
                        z16 = true;
                    }
                    z16 = false;
                }
                if (z16) {
                    arrayList.remove(size);
                    if (QLog.isColorLevel()) {
                        QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "parsePromptParams local read [id: %d , level: %d]", Integer.valueOf(medalID.f245721d), Integer.valueOf(medalID.f245722e)));
                    }
                }
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i("MedalWallMng", 2, "summarycard", e16);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void u(int i3, Object obj) {
        int i16;
        Card card;
        LocalRedTouchManager localRedTouchManager;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3, obj);
            return;
        }
        EntityManager createEntityManager = this.f245727i.getEntityManagerFactory().createEntityManager();
        ArrayList<MedalID> arrayList = new ArrayList<>(5);
        int i18 = 0;
        if (i3 == 2) {
            try {
                synchronized (this.f245723d) {
                    for (int i19 = 0; i19 < this.f245723d.size(); i19++) {
                        MedalInfo valueAt = this.f245723d.valueAt(i19);
                        valueAt.putReportInfo(arrayList);
                        valueAt.setRead();
                        if (valueAt.getStatus() == 1000) {
                            createEntityManager.persistOrReplace(valueAt);
                        } else if (valueAt.getStatus() == 1001 || valueAt.getStatus() == 1002) {
                            createEntityManager.update(valueAt);
                        }
                    }
                }
                synchronized (this.f245724e) {
                    this.f245724e.clear();
                }
            } catch (Throwable th5) {
                th = th5;
                i16 = 0;
                th.printStackTrace();
                if (i3 == 0) {
                }
                localRedTouchManager = (LocalRedTouchManager) this.f245727i.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
                if (i3 == 1) {
                }
                localRedTouchManager.u(10015);
                localRedTouchManager.u(10016);
                if (!arrayList.isEmpty()) {
                }
                if (card != null) {
                }
                x(0);
                if (QLog.isColorLevel()) {
                }
            }
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            MedalInfo medalInfo = aVar.f245730a;
            i16 = medalInfo.iId;
            try {
                medalInfo.putReportInfo(arrayList);
                medalInfo.setRead();
                if (medalInfo.getStatus() == 1000) {
                    createEntityManager.persistOrReplace(medalInfo);
                } else if (medalInfo.getStatus() == 1001 || medalInfo.getStatus() == 1002) {
                    createEntityManager.update(medalInfo);
                }
                synchronized (this.f245724e) {
                    this.f245724e.remove(aVar);
                }
            } catch (Throwable th6) {
                th = th6;
                th.printStackTrace();
                if (i3 == 0) {
                }
                localRedTouchManager = (LocalRedTouchManager) this.f245727i.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
                if (i3 == 1) {
                }
                localRedTouchManager.u(10015);
                localRedTouchManager.u(10016);
                if (!arrayList.isEmpty()) {
                }
                if (card != null) {
                }
                x(0);
                if (QLog.isColorLevel()) {
                }
            }
        } else {
            i16 = 0;
        }
        if (i3 == 0) {
            card = w(null, true);
        } else {
            FriendsManager friendsManager = (FriendsManager) this.f245727i.getManager(QQManagerFactory.FRIENDS_MANAGER);
            Card q16 = friendsManager.q(this.f245727i.getCurrentAccountUin());
            if (q16 != null) {
                q16.iUpgradeCount = 0;
                q16.iNewCount = 0;
                friendsManager.p0(q16);
            }
            card = q16;
        }
        localRedTouchManager = (LocalRedTouchManager) this.f245727i.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
        if (i3 == 1 && i3 != 2) {
            if (card == null || (card.iNewCount == 0 && card.iUpgradeCount == 0)) {
                localRedTouchManager.u(10015);
            }
        } else {
            localRedTouchManager.u(10015);
            localRedTouchManager.u(10016);
        }
        if (!arrayList.isEmpty()) {
            ((CardHandler) this.f245727i.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).O4(arrayList);
        }
        if (card != null || (card.iNewCount == 0 && card.iUpgradeCount == 0)) {
            x(0);
        }
        if (QLog.isColorLevel()) {
            Locale locale = Locale.getDefault();
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(i3);
            objArr[1] = Integer.valueOf(i16);
            if (card == null) {
                i17 = 0;
            } else {
                i17 = card.iNewCount;
            }
            objArr[2] = Integer.valueOf(i17);
            if (card != null) {
                i18 = card.iUpgradeCount;
            }
            objArr[3] = Integer.valueOf(i18);
            QLog.i("MedalWallMng", 2, String.format(locale, "reportReadSelfNewObtainedMedal [nActionType: %d, id: %d, iNewCount: %d, iUpgradeCount: %d]", objArr));
        }
    }

    public Card w(TMedalWallInfo tMedalWallInfo, boolean z16) {
        int i3;
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Card) iPatchRedirector.redirect((short) 11, this, tMedalWallInfo, Boolean.valueOf(z16));
        }
        synchronized (this.f245723d) {
            i3 = 0;
            i16 = 0;
            for (int i18 = 0; i18 < this.f245723d.size(); i18++) {
                MedalInfo valueAt = this.f245723d.valueAt(i18);
                if (valueAt != null) {
                    int i19 = valueAt.iLevel;
                    if (i19 == 255) {
                        if (valueAt.iUnreadLevel1 == 1) {
                            i3++;
                        }
                    } else if (valueAt.iLevelCount > 1) {
                        if (i19 >= 1 && valueAt.iUnreadLevel1 == 1) {
                            i3++;
                        }
                        if (i19 >= 2 && valueAt.iUnreadLevel2 == 1) {
                            i16++;
                        }
                        if (i19 >= 3 && valueAt.iUnreadLevel3 == 1) {
                            i16++;
                        }
                    }
                }
            }
        }
        FriendsManager friendsManager = (FriendsManager) this.f245727i.getManager(QQManagerFactory.FRIENDS_MANAGER);
        Card q16 = friendsManager.q(this.f245727i.getCurrentAccountUin());
        if (tMedalWallInfo != null) {
            q16.iMedalCount = tMedalWallInfo.iMedalCount;
            if (QLog.isColorLevel()) {
                QLog.d("MedalWallMng", 2, String.format(Locale.getDefault(), "updateCardMedalInfo needCheck: %s, compute[iNewCount: %d, iUpgradeCount: %d] server[iNewCount: %d, iUpgradeCount: %d] card[iNewCount: %d, iUpgradeCount: %d]", Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(tMedalWallInfo.iNewCount), Integer.valueOf(tMedalWallInfo.iUpgradeCount), Integer.valueOf(q16.iNewCount), Integer.valueOf(q16.iUpgradeCount)));
            }
            if (z16 && ((i17 = tMedalWallInfo.iNewCount) > i3 || tMedalWallInfo.iUpgradeCount > i16)) {
                tMedalWallInfo.iNewCount = Math.min(i17, i3);
                tMedalWallInfo.iUpgradeCount = Math.min(tMedalWallInfo.iUpgradeCount, i16);
            }
            q16.iNewCount = tMedalWallInfo.iNewCount;
            q16.iUpgradeCount = tMedalWallInfo.iUpgradeCount;
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("MedalWallMng", 2, String.format(Locale.getDefault(), "updateCardMedalInfo compute[iNewCount: %d, iUpgradeCount: %d] card[iNewCount: %d, iUpgradeCount: %d]", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(q16.iNewCount), Integer.valueOf(q16.iUpgradeCount)));
            }
            q16.iNewCount = Math.min(q16.iNewCount, i3);
            q16.iUpgradeCount = Math.min(q16.iUpgradeCount, i16);
        }
        friendsManager.p0(q16);
        return q16;
    }
}
