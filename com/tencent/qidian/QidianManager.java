package com.tencent.qidian;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.biz.bmqq.app.BmqqBusinessHandler;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.BmqqUserSimpleInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.i;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qidian.data.QidianCorpInfo;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qidian.data.QidianInternalInfo;
import com.tencent.qidian.data.QidianPAForWpa;
import com.tencent.qidian.data.QidianProfileUiInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.d;
import com.tencent.util.UiThreadUtil;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QidianManager implements Manager {
    static IPatchRedirector $redirector_;
    public static final AtomicBoolean H;
    public Map<String, QidianPAForWpa> C;
    public Map<String, String> D;
    public AppInterface E;
    public Map<String, List<MessageRecord>> F;
    private List<Object> G;

    /* renamed from: d, reason: collision with root package name */
    public Map<String, Integer> f342666d;

    /* renamed from: e, reason: collision with root package name */
    public Map<String, QidianExternalInfo> f342667e;

    /* renamed from: f, reason: collision with root package name */
    public Map<String, QidianInternalInfo> f342668f;

    /* renamed from: h, reason: collision with root package name */
    public Map<String, QidianCorpInfo> f342669h;

    /* renamed from: i, reason: collision with root package name */
    public Map<String, QidianProfileUiInfo> f342670i;

    /* renamed from: m, reason: collision with root package name */
    public Map<String, BmqqUserSimpleInfo> f342671m;

    /* compiled from: P */
    /* renamed from: com.tencent.qidian.QidianManager$6, reason: invalid class name */
    /* loaded from: classes22.dex */
    class AnonymousClass6 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QidianPAForWpa f342681d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f342682e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f342683f;
        final /* synthetic */ QidianManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.this$0.v0(this.f342681d, this.f342682e, this.f342683f);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a extends SosoInterfaceOnLocationListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f342690a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f342691b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f342692c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f342693d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f342694e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f342695f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f342696g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i3, boolean z16, boolean z17, long j3, boolean z18, boolean z19, String str, String str2, int i16, String str3, int i17, String str4, String str5, String str6) {
            super(i3, z16, z17, j3, z18, z19, str);
            this.f342690a = str2;
            this.f342691b = i16;
            this.f342692c = str3;
            this.f342693d = i17;
            this.f342694e = str4;
            this.f342695f = str5;
            this.f342696g = str6;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, this, QidianManager.this, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), Long.valueOf(j3), Boolean.valueOf(z18), Boolean.valueOf(z19), str, str2, Integer.valueOf(i16), str3, Integer.valueOf(i17), str4, str5, str6);
        }

        @Override // com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener
        public void onLocationFinish(int i3, SosoLbsInfo sosoLbsInfo) {
            double d16;
            double d17;
            SosoLocation sosoLocation;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) sosoLbsInfo);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("QidianManager", 2, "onLocationFinish(): BEGIN errCode=" + i3);
            }
            if (i3 == 0 && sosoLbsInfo != null && (sosoLocation = sosoLbsInfo.mLocation) != null) {
                String str = sosoLocation.address;
                if (str == null) {
                    str = "";
                }
                if (QLog.isColorLevel()) {
                    QLog.d("QidianManager", 2, "onLocationFinish() latitude=" + sosoLbsInfo.mLocation.mLat02 + ", longitude=" + sosoLbsInfo.mLocation.mLon02 + ", address=" + str);
                }
                SosoLocation sosoLocation2 = sosoLbsInfo.mLocation;
                d16 = sosoLocation2.mLat02;
                d17 = sosoLocation2.mLon02;
            } else {
                d16 = 0.0d;
                d17 = 0.0d;
            }
            QidianManager.this.j(this.f342690a, this.f342691b, true, d16, d17, this.f342692c, this.f342693d, this.f342694e, this.f342695f, this.f342696g);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77484);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 42)) {
            redirector.redirect((short) 42);
        } else {
            H = new AtomicBoolean(false);
        }
    }

    public QidianManager(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
            return;
        }
        this.f342666d = null;
        this.f342667e = null;
        this.f342668f = null;
        this.f342669h = null;
        this.f342670i = null;
        this.f342671m = null;
        this.C = null;
        this.D = null;
        this.F = null;
        this.E = appInterface;
        this.f342666d = new HashMap();
        this.f342667e = new HashMap();
        this.f342668f = new HashMap();
        this.f342671m = new HashMap();
        this.f342669h = new HashMap();
        this.f342670i = new HashMap();
        this.C = new HashMap();
        this.F = new HashMap();
        this.D = new HashMap();
        if (UiThreadUtil.isOnUiThread()) {
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.qidian.QidianManager.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QidianManager.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        QidianManager.this.C();
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        } else {
            C();
        }
        this.G = new CopyOnWriteArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        if (QLog.isColorLevel()) {
            QLog.d("QidianManager", 4, "initial ...");
        }
        EntityManager createEntityManager = this.E.getEntityManagerFactory().createEntityManager();
        try {
            try {
                b0(createEntityManager);
                c0(createEntityManager);
                a0(createEntityManager);
                e0(createEntityManager);
                Y(createEntityManager);
                d0(createEntityManager);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("QidianManager", 2, "QidianManager get data from db error: " + e16.getMessage());
                }
            }
            createEntityManager.close();
            H.set(true);
        } catch (Throwable th5) {
            createEntityManager.close();
            throw th5;
        }
    }

    public static boolean E(int i3) {
        if ((i3 & 1) != 0) {
            return true;
        }
        return false;
    }

    public static boolean F(QQAppInterface qQAppInterface, String str) {
        return ((QidianManager) qQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER)).G(str);
    }

    public static boolean H(QQAppInterface qQAppInterface, MessageRecord messageRecord) {
        if (messageRecord == null) {
            return false;
        }
        if ((!((QidianManager) qQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER)).L(messageRecord.frienduin) && messageRecord.istroop != 1024) || TextUtils.isEmpty(messageRecord.getExtInfoFromExtStr("is_eman_sc_message"))) {
            return false;
        }
        return true;
    }

    public static boolean I(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            str = str2;
        }
        if (!TextUtils.isEmpty(str)) {
            str3 = str;
        }
        if (!TextUtils.isEmpty(str3) && str3.contains("isNeedReply=") && str3.contains("QidianKfUin=")) {
            return true;
        }
        return false;
    }

    public static boolean J(QQAppInterface qQAppInterface, String str) {
        QidianManager qidianManager = (QidianManager) qQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER);
        if (!qidianManager.L(str) && !qidianManager.R(str)) {
            return false;
        }
        return true;
    }

    public static boolean K(int i3) {
        if ((i3 & 4) != 0) {
            return true;
        }
        return false;
    }

    public static boolean O(int i3) {
        if ((i3 & 16) != 0) {
            return true;
        }
        return false;
    }

    public static boolean P(BaseQQAppInterface baseQQAppInterface, String str) {
        return Q(baseQQAppInterface, str, true);
    }

    public static boolean Q(BaseQQAppInterface baseQQAppInterface, String str, boolean z16) {
        return ((QidianManager) baseQQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER)).S(str, z16);
    }

    private boolean W(String str, int i3) {
        d friendsSimpleInfoWithUid;
        byte byteValue;
        String uidFromUin = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getUidFromUin(str);
        if (TextUtils.isEmpty(uidFromUin) || (friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(uidFromUin, "QidianManager")) == null) {
            return false;
        }
        if (friendsSimpleInfoWithUid.e() == null) {
            byteValue = 0;
        } else {
            byteValue = friendsSimpleInfoWithUid.e().byteValue();
        }
        if (byteValue < 0) {
            QLog.i("QidianManager", 1, "isSpecialAccountInFriend meet error!!");
            return false;
        }
        if ((byteValue & i3) == 0) {
            return false;
        }
        QLog.i("QidianManager", 1, MsfSdkUtils.getShortUin(str) + " isSpecialAccountInFriend isSpecialAccount is true, friendInfo.cSpecialFlag: " + ((int) byteValue) + " | flag: " + i3);
        return true;
    }

    private void Y(EntityManager entityManager) {
        List<? extends Entity> query = entityManager.query(BmqqUserSimpleInfo.class);
        if (query != null) {
            Iterator<? extends Entity> it = query.iterator();
            while (it.hasNext()) {
                BmqqUserSimpleInfo bmqqUserSimpleInfo = (BmqqUserSimpleInfo) it.next();
                if (QLog.isColorLevel()) {
                    QLog.d("QidianManager", 4, "loadBmqqExtInfo query from db: " + bmqqUserSimpleInfo);
                }
                this.f342671m.put(bmqqUserSimpleInfo.mBmqqUin, bmqqUserSimpleInfo);
            }
        }
    }

    private void a0(EntityManager entityManager) {
        List<? extends Entity> query = entityManager.query(QidianCorpInfo.class);
        if (query != null) {
            Iterator<? extends Entity> it = query.iterator();
            while (it.hasNext()) {
                QidianCorpInfo qidianCorpInfo = (QidianCorpInfo) it.next();
                if (QLog.isColorLevel()) {
                    QLog.d("QidianManager", 4, "loadCorpInfo query from db: " + qidianCorpInfo);
                }
                this.f342669h.put(qidianCorpInfo.corpUin, qidianCorpInfo);
            }
        }
    }

    private void b0(EntityManager entityManager) {
        List<? extends Entity> query = entityManager.query(QidianExternalInfo.class);
        if (query != null) {
            Iterator<? extends Entity> it = query.iterator();
            while (it.hasNext()) {
                QidianExternalInfo qidianExternalInfo = (QidianExternalInfo) it.next();
                if (QLog.isColorLevel()) {
                    QLog.d("QidianManager", 4, "loadExternalInfo query from db: " + qidianExternalInfo);
                }
                this.f342667e.put(qidianExternalInfo.uin, qidianExternalInfo);
            }
        }
    }

    private void c0(EntityManager entityManager) {
        List<? extends Entity> query = entityManager.query(QidianInternalInfo.class);
        if (query != null) {
            Iterator<? extends Entity> it = query.iterator();
            while (it.hasNext()) {
                QidianInternalInfo qidianInternalInfo = (QidianInternalInfo) it.next();
                if (QLog.isColorLevel()) {
                    QLog.d("QidianManager", 4, "loadInternalInfo query from db: " + qidianInternalInfo);
                }
                this.f342668f.put(qidianInternalInfo.uin, qidianInternalInfo);
            }
        }
    }

    private void d0(EntityManager entityManager) {
        List<? extends Entity> query = entityManager.query(QidianPAForWpa.class);
        if (query != null) {
            Iterator<? extends Entity> it = query.iterator();
            while (it.hasNext()) {
                QidianPAForWpa qidianPAForWpa = (QidianPAForWpa) it.next();
                this.C.put(qidianPAForWpa.puin, qidianPAForWpa);
            }
        }
    }

    private void e0(EntityManager entityManager) {
        List<? extends Entity> query = entityManager.query(QidianProfileUiInfo.class);
        if (query != null) {
            Iterator<? extends Entity> it = query.iterator();
            while (it.hasNext()) {
                QidianProfileUiInfo qidianProfileUiInfo = (QidianProfileUiInfo) it.next();
                if (QLog.isColorLevel()) {
                    QLog.d("QidianManager", 4, "loadQidianProfileUiInfo query from db: " + qidianProfileUiInfo);
                }
                this.f342670i.put(qidianProfileUiInfo.uin, qidianProfileUiInfo);
            }
        }
    }

    public static void g(Context context, ArrayList<ShareActionSheetBuilder.ActionSheetItem> arrayList) {
        if (new Intent().setPackage("com.tencent.qidian").setData(Uri.parse("qdapi://")).resolveActivity(context.getPackageManager()) != null) {
            arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(19));
        }
    }

    public static void h(QQAppInterface qQAppInterface, String str, String str2) {
        try {
            Long.parseLong(str);
            if (!nx.a.f(str)) {
                return;
            }
            ((QidianManager) qQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER)).D.put(str, str2);
        } catch (Exception unused) {
        }
    }

    private void h0(String str, int i3, int i16, String str2) {
        if (!TextUtils.isEmpty(str) && str.contains("isNeedReply=") && str.contains("QidianKfUin=")) {
            Matcher matcher = Pattern.compile("((?:isNeedReply|isNeedLbs|QidianKfUin|isExt|FromStaff|cqq))=([^\\?&=]+)").matcher(str);
            int i17 = i16;
            String str3 = "";
            String str4 = str3;
            String str5 = str4;
            boolean z16 = false;
            boolean z17 = false;
            while (matcher.find()) {
                if ("isNeedReply".equals(matcher.group(1))) {
                    z17 = "true".equals(matcher.group(2));
                } else if ("isNeedLbs".equals(matcher.group(1))) {
                    z16 = "true".equals(matcher.group(2));
                } else if ("QidianKfUin".equals(matcher.group(1))) {
                    str3 = matcher.group(2);
                } else if ("isExt".equals(matcher.group(1))) {
                    if (i17 == 2) {
                        try {
                            i17 = !Boolean.parseBoolean(matcher.group(2)) ? 1 : 0;
                        } catch (Exception unused) {
                            i17 = 0;
                        }
                    }
                } else if ("FromStaff".equals(matcher.group(1))) {
                    str4 = matcher.group(2);
                } else if ("cqq".equals(matcher.group(1))) {
                    str5 = matcher.group(2);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("QidianManager", 2, "isNeedLbs: " + z16 + " | isNeedReply: " + z17 + " | masterUin: " + str3 + " | srcType: " + i17);
            }
            if (z17) {
                if (z16) {
                    ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).startLocation(new a(1, true, true, 0L, true, false, "QidianManager", str, i3, str3, i17, str4, str5, str2));
                    return;
                } else {
                    j(str, i3, z16, 0.0d, 0.0d, str3, i17, str4, str5, str2);
                    return;
                }
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QidianManager", 2, "key is null or don't contain isNeedReply : " + str);
        }
    }

    private boolean i(String str, QQAppInterface qQAppInterface) {
        if (TextUtils.isEmpty(qQAppInterface.getAccount())) {
            if (QLog.isColorLevel()) {
                QLog.i("QidianManager", 2, "app.getAccount() is null");
            }
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("QidianManager", 2, "initParm uin = " + str);
        }
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.i("QidianManager", 2, "mAllinone is null");
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void i0(Activity activity, int i3, String str, String str2, String str3, String str4, String str5, int i16, boolean z16) {
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11 = null;
        if (str4 == null) {
            str8 = null;
        } else {
            try {
                str8 = Base64.encodeToString(str4.getBytes("UTF-8"), 2);
            } catch (UnsupportedEncodingException e16) {
                e = e16;
                str6 = null;
                str7 = null;
                str8 = null;
                e.printStackTrace();
                StringBuilder sb5 = new StringBuilder();
                if (i3 == 6) {
                }
                sb5.append(str9);
                sb5.append("share/to_fri?src_type=app&version=1&file_type=news&share_id=-1");
                sb5.append("&image_url=");
                sb5.append(str8);
                sb5.append("&title=");
                sb5.append(str6);
                sb5.append("&description=");
                sb5.append(str7);
                sb5.append("&url=");
                sb5.append(str11);
                sb5.append("&is_profile=");
                if (z16) {
                }
                sb5.append(str10);
                sb5.append("&account_type=");
                sb5.append(i16);
                sb5.append("&uin=");
                sb5.append(str5);
                Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(sb5.toString()));
                intent.putExtra("pkg_name", "com.tencent.mobileqq");
                activity.startActivity(intent);
            }
        }
        if (str == null) {
            str6 = "";
        } else {
            try {
                str6 = Base64.encodeToString(str.getBytes("UTF-8"), 2);
            } catch (UnsupportedEncodingException e17) {
                e = e17;
                str6 = null;
                str7 = null;
                e.printStackTrace();
                StringBuilder sb52 = new StringBuilder();
                if (i3 == 6) {
                }
                sb52.append(str9);
                sb52.append("share/to_fri?src_type=app&version=1&file_type=news&share_id=-1");
                sb52.append("&image_url=");
                sb52.append(str8);
                sb52.append("&title=");
                sb52.append(str6);
                sb52.append("&description=");
                sb52.append(str7);
                sb52.append("&url=");
                sb52.append(str11);
                sb52.append("&is_profile=");
                if (z16) {
                }
                sb52.append(str10);
                sb52.append("&account_type=");
                sb52.append(i16);
                sb52.append("&uin=");
                sb52.append(str5);
                Intent intent2 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(sb52.toString()));
                intent2.putExtra("pkg_name", "com.tencent.mobileqq");
                activity.startActivity(intent2);
            }
        }
        if (str2 == null) {
            str7 = "";
        } else {
            try {
                str7 = Base64.encodeToString(str2.getBytes("UTF-8"), 2);
            } catch (UnsupportedEncodingException e18) {
                e = e18;
                str7 = null;
                e.printStackTrace();
                StringBuilder sb522 = new StringBuilder();
                if (i3 == 6) {
                }
                sb522.append(str9);
                sb522.append("share/to_fri?src_type=app&version=1&file_type=news&share_id=-1");
                sb522.append("&image_url=");
                sb522.append(str8);
                sb522.append("&title=");
                sb522.append(str6);
                sb522.append("&description=");
                sb522.append(str7);
                sb522.append("&url=");
                sb522.append(str11);
                sb522.append("&is_profile=");
                if (z16) {
                }
                sb522.append(str10);
                sb522.append("&account_type=");
                sb522.append(i16);
                sb522.append("&uin=");
                sb522.append(str5);
                Intent intent22 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(sb522.toString()));
                intent22.putExtra("pkg_name", "com.tencent.mobileqq");
                activity.startActivity(intent22);
            }
        }
        if (str3 == null) {
            str11 = "";
        } else {
            try {
                str11 = Base64.encodeToString(str3.getBytes("UTF-8"), 2);
            } catch (UnsupportedEncodingException e19) {
                e = e19;
                e.printStackTrace();
                StringBuilder sb5222 = new StringBuilder();
                if (i3 == 6) {
                }
                sb5222.append(str9);
                sb5222.append("share/to_fri?src_type=app&version=1&file_type=news&share_id=-1");
                sb5222.append("&image_url=");
                sb5222.append(str8);
                sb5222.append("&title=");
                sb5222.append(str6);
                sb5222.append("&description=");
                sb5222.append(str7);
                sb5222.append("&url=");
                sb5222.append(str11);
                sb5222.append("&is_profile=");
                if (z16) {
                }
                sb5222.append(str10);
                sb5222.append("&account_type=");
                sb5222.append(i16);
                sb5222.append("&uin=");
                sb5222.append(str5);
                Intent intent222 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(sb5222.toString()));
                intent222.putExtra("pkg_name", "com.tencent.mobileqq");
                activity.startActivity(intent222);
            }
        }
        StringBuilder sb52222 = new StringBuilder();
        if (i3 == 6) {
            str9 = "qdapi://";
        } else {
            str9 = "eimapi://";
        }
        sb52222.append(str9);
        sb52222.append("share/to_fri?src_type=app&version=1&file_type=news&share_id=-1");
        sb52222.append("&image_url=");
        sb52222.append(str8);
        sb52222.append("&title=");
        sb52222.append(str6);
        sb52222.append("&description=");
        sb52222.append(str7);
        sb52222.append("&url=");
        sb52222.append(str11);
        sb52222.append("&is_profile=");
        if (z16) {
            str10 = "true";
        } else {
            str10 = "false";
        }
        sb52222.append(str10);
        sb52222.append("&account_type=");
        sb52222.append(i16);
        sb52222.append("&uin=");
        sb52222.append(str5);
        Intent intent2222 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(sb52222.toString()));
        intent2222.putExtra("pkg_name", "com.tencent.mobileqq");
        activity.startActivity(intent2222);
    }

    public static boolean l(AppInterface appInterface, Friends friends, int i3) {
        if (friends == null || !O(friends.cSpecialFlag) || i3 == 1 || i3 == 2 || i3 == 13 || i3 == 10001 || i3 == 7) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(BmqqUserSimpleInfo bmqqUserSimpleInfo) {
        if (QLog.isColorLevel()) {
            QLog.d("QidianManager", 2, "updateBmqqExtInfo");
        }
        EntityManager createEntityManager = this.E.getEntityManagerFactory().createEntityManager();
        if (createEntityManager != null) {
            try {
                try {
                    if (bmqqUserSimpleInfo != null) {
                        createEntityManager.persistOrReplace(bmqqUserSimpleInfo);
                    } else if (QLog.isColorLevel()) {
                        QLog.d("QidianManager", 2, "updateBmqqExtInfo uiInfo is null");
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("QidianManager", 2, "updateBmqqExtInfo success");
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                return;
            } finally {
                createEntityManager.close();
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("QidianManager", 2, "updateBmqqExtInfo em is null");
        }
    }

    public static boolean m(d dVar, int i3) {
        if (dVar == null || !O(dVar.e().byteValue()) || i3 == 1 || i3 == 2 || i3 == 13 || i3 == 10001 || i3 == 7) {
            return true;
        }
        return false;
    }

    public static void m0(QQAppInterface qQAppInterface, int i3, String str) {
        BmqqAccountType bmqqAccountType;
        try {
            Long.parseLong(str);
            if (!nx.a.f(str)) {
                return;
            }
            QidianManager qidianManager = (QidianManager) qQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER);
            boolean O = O(i3);
            boolean K = K(i3);
            boolean E = E(i3);
            if (!O && !K && !E) {
                if (QLog.isColorLevel()) {
                    QLog.d("QidianManager", 2, "updateQidianAccountType ignore uin: " + str + " | cSpecialFlag: " + i3);
                    return;
                }
                return;
            }
            if (qidianManager.U(str)) {
                if (QLog.isColorLevel()) {
                    QLog.d("QidianManager", 2, "updateQidianAccountType requested uin: " + str + " | cSpecialFlag: " + i3);
                    return;
                }
                return;
            }
            if (O) {
                bmqqAccountType = new BmqqAccountType(str, 6);
            } else if (K) {
                bmqqAccountType = new BmqqAccountType(str, 1);
            } else if (E) {
                bmqqAccountType = new BmqqAccountType(str, 3);
            } else {
                bmqqAccountType = null;
            }
            qidianManager.j0(bmqqAccountType);
            if (O) {
                QidianExternalInfo q16 = qidianManager.q(str);
                QidianProfileUiInfo u16 = qidianManager.u(str);
                if (q16 == null || u16 == null) {
                    if (UiThreadUtil.isOnUiThread()) {
                        ThreadManagerV2.post(new Runnable(qQAppInterface, bmqqAccountType) { // from class: com.tencent.qidian.QidianManager.10
                            static IPatchRedirector $redirector_;

                            /* renamed from: e, reason: collision with root package name */
                            final /* synthetic */ QQAppInterface f342673e;

                            /* renamed from: f, reason: collision with root package name */
                            final /* synthetic */ BmqqAccountType f342674f;

                            {
                                this.f342673e = qQAppInterface;
                                this.f342674f = bmqqAccountType;
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                    iPatchRedirector.redirect((short) 1, this, QidianManager.this, qQAppInterface, bmqqAccountType);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                    iPatchRedirector.redirect((short) 2, (Object) this);
                                } else {
                                    QidianManager.this.z(this.f342673e.getApp().getBaseContext(), this.f342674f);
                                }
                            }
                        }, 5, null, true);
                    } else {
                        qidianManager.z(qQAppInterface.getApp().getBaseContext(), bmqqAccountType);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void n0(QQAppInterface qQAppInterface, Friends friends) {
        if (friends == null) {
            if (QLog.isColorLevel()) {
                QLog.d("QidianManager", 2, "updateQidianAccountType friend is null");
                return;
            }
            return;
        }
        m0(qQAppInterface, friends.cSpecialFlag, friends.uin);
    }

    private String p(String str) {
        if (L(str)) {
            QidianExternalInfo qidianExternalInfo = this.f342667e.get(str);
            if (qidianExternalInfo != null && !TextUtils.isEmpty(qidianExternalInfo.masterUin)) {
                QidianCorpInfo qidianCorpInfo = this.f342669h.get(qidianExternalInfo.masterUin);
                if (qidianCorpInfo == null) {
                    return "";
                }
                return qidianCorpInfo.corpName;
            }
            if (!QLog.isColorLevel()) {
                return "";
            }
            QLog.d("QidianManager", 4, "QidianExternalInfo is null or masterUin is empty for uin: " + str);
            return "";
        }
        if (!QLog.isColorLevel()) {
            return "";
        }
        QLog.d("QidianManager", 4, "uin is no qidian account");
        return "";
    }

    public static void p0(QQAppInterface qQAppInterface, Friends[] friendsArr) {
        if (friendsArr != null) {
            QidianManager qidianManager = (QidianManager) qQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER);
            if (UiThreadUtil.isOnUiThread()) {
                ThreadManagerV2.postImmediately(new Runnable(qQAppInterface, friendsArr) { // from class: com.tencent.qidian.QidianManager.9
                    static IPatchRedirector $redirector_;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ QQAppInterface f342688e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ Friends[] f342689f;

                    {
                        this.f342688e = qQAppInterface;
                        this.f342689f = friendsArr;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, QidianManager.this, qQAppInterface, friendsArr);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                            QidianManager.this.q0(this.f342688e, this.f342689f);
                        } else {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        }
                    }
                }, null, false);
            } else {
                qidianManager.q0(qQAppInterface, friendsArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(QQAppInterface qQAppInterface, Friends[] friendsArr) {
        BmqqAccountType bmqqAccountType;
        try {
            for (Friends friends : friendsArr) {
                String str = friends.uin;
                byte b16 = friends.cSpecialFlag;
                try {
                    Long.parseLong(str);
                    if (!nx.a.f(str)) {
                        return;
                    }
                    boolean O = O(b16);
                    boolean K = K(b16);
                    boolean E = E(b16);
                    if (O || K || E) {
                        if (O) {
                            bmqqAccountType = new BmqqAccountType(str, 6);
                        } else if (K) {
                            bmqqAccountType = new BmqqAccountType(str, 1);
                        } else if (E) {
                            bmqqAccountType = new BmqqAccountType(str, 3);
                        } else {
                            bmqqAccountType = null;
                        }
                        if (bmqqAccountType != null && y(str) != bmqqAccountType.getAccountType()) {
                            this.f342666d.put(str, Integer.valueOf(bmqqAccountType.getAccountType()));
                            if (O) {
                                QidianExternalInfo q16 = q(str);
                                QidianProfileUiInfo u16 = u(str);
                                if (q16 == null || u16 == null) {
                                    z(qQAppInterface.getApp().getBaseContext(), bmqqAccountType);
                                }
                            }
                        }
                    }
                } catch (Exception unused) {
                    return;
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0(QidianExternalInfo qidianExternalInfo, QidianInternalInfo qidianInternalInfo, QidianCorpInfo qidianCorpInfo, QidianProfileUiInfo qidianProfileUiInfo) {
        if (QLog.isColorLevel()) {
            QLog.d("QidianManager", 2, "saveQidianExtInfoInSubThread");
        }
        EntityManager createEntityManager = this.E.getEntityManagerFactory().createEntityManager();
        if (createEntityManager != null) {
            try {
                try {
                    if (qidianExternalInfo != null) {
                        createEntityManager.persistOrReplace(qidianExternalInfo);
                    } else if (QLog.isColorLevel()) {
                        QLog.d("QidianManager", 2, "saveQidianExtInfoInSubThread externalInfo is null");
                    }
                    if (qidianInternalInfo != null) {
                        createEntityManager.persistOrReplace(qidianInternalInfo);
                    } else if (QLog.isColorLevel()) {
                        QLog.d("QidianManager", 2, "saveQidianIntInfoInSubThread internalInfo is null");
                    }
                    if (qidianCorpInfo != null) {
                        createEntityManager.persistOrReplace(qidianCorpInfo);
                    } else if (QLog.isColorLevel()) {
                        QLog.d("QidianManager", 2, "saveQidianExtInfoInSubThread corpInfo is null");
                    }
                    if (qidianProfileUiInfo != null) {
                        createEntityManager.persistOrReplace(qidianProfileUiInfo);
                    } else if (QLog.isColorLevel()) {
                        QLog.d("QidianManager", 2, "saveQidianExtInfoInSubThread uiInfo is null");
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("QidianManager", 2, "saveQidianExtInfoInSubThread success");
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                return;
            } finally {
                createEntityManager.close();
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("QidianManager", 2, "saveQidianExtInfoInSubThread em is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(QidianExternalInfo qidianExternalInfo, QidianProfileUiInfo qidianProfileUiInfo) {
        if (QLog.isColorLevel()) {
            QLog.d("QidianManager", 2, "saveQidianMasterInfoInSubThread");
        }
        EntityManager createEntityManager = this.E.getEntityManagerFactory().createEntityManager();
        if (createEntityManager != null) {
            try {
                try {
                    if (qidianExternalInfo != null) {
                        qidianExternalInfo.setStatus(1000);
                        createEntityManager.persistOrReplace(qidianExternalInfo);
                    } else if (QLog.isColorLevel()) {
                        QLog.d("QidianManager", 2, "saveQidianMasterInfoInSubThread externalInfo is null");
                    }
                    if (qidianProfileUiInfo != null) {
                        createEntityManager.persistOrReplace(qidianProfileUiInfo);
                    } else if (QLog.isColorLevel()) {
                        QLog.d("QidianManager", 2, "saveQidianMasterInfoInSubThread uiInfo is null");
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("QidianManager", 2, "saveQidianMasterInfoInSubThread success");
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                return;
            } finally {
                createEntityManager.close();
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("QidianManager", 2, "saveQidianMasterInfoInSubThread em is null");
        }
    }

    public static String v(QQAppInterface qQAppInterface, String str) {
        QidianExternalInfo q16;
        String H2 = ac.H(qQAppInterface, str);
        if ((TextUtils.isEmpty(H2) || H2.equals(str)) && (q16 = ((QidianManager) qQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER)).q(String.valueOf(str))) != null) {
            return q16.nickname;
        }
        return H2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(QidianPAForWpa qidianPAForWpa, String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("QidianManager", 2, "updateQidianPAForWpa");
        }
        EntityManager createEntityManager = this.E.getEntityManagerFactory().createEntityManager();
        if (createEntityManager != null) {
            try {
                try {
                    if (qidianPAForWpa != null) {
                        createEntityManager.persistOrReplace(qidianPAForWpa);
                    } else if (QLog.isColorLevel()) {
                        QLog.d("QidianManager", 2, "updateQidianPAForWpa uiInfo is null");
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("QidianManager", 2, "updateQidianPAForWpa success");
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                return;
            } finally {
                createEntityManager.close();
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("QidianManager", 2, "updateQidianPAForWpa em is null");
        }
    }

    public static String w(QQAppInterface qQAppInterface, String str) {
        QidianManager qidianManager = (QidianManager) qQAppInterface.getManager(QQManagerFactory.QIDIAN_MANAGER);
        if (qidianManager.R(str)) {
            if (qidianManager.f342667e.containsKey(str)) {
                QidianExternalInfo qidianExternalInfo = qidianManager.f342667e.get(str);
                if (qidianExternalInfo != null) {
                    return qidianExternalInfo.masterUin;
                }
                return "";
            }
            if (qidianManager.D.containsKey(str)) {
                return qidianManager.D.get(str);
            }
            return "";
        }
        return "";
    }

    public void A(QQAppInterface qQAppInterface, long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, this, qQAppInterface, Long.valueOf(j3), str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String valueOf = String.valueOf(j3);
        AbsStructMsg g16 = i.g(str.getBytes(), 0);
        if (g16 == null) {
            return;
        }
        BaseActivity baseActivity = BaseActivity.sTopActivity;
        if ((!(baseActivity instanceof SplashActivity) && !(baseActivity instanceof ChatActivity)) || baseActivity.getChatFragment() == null || !baseActivity.getChatFragment().C.f25589n.f179557e.equals(valueOf)) {
            return;
        }
        MessageForStructing messageForStructing = (MessageForStructing) q.d(MessageRecord.MSG_TYPE_STRUCT_MSG);
        messageForStructing.msgtype = MessageRecord.MSG_TYPE_STRUCT_MSG;
        messageForStructing.istroop = baseActivity.getChatFragment().C.f25589n.f179555d;
        messageForStructing.issend = 0;
        messageForStructing.isread = true;
        messageForStructing.selfuin = qQAppInterface.getCurrentAccountUin();
        messageForStructing.mIsParsed = true;
        messageForStructing.frienduin = valueOf;
        messageForStructing.senderuin = valueOf;
        messageForStructing.structingMsg = g16;
        messageForStructing.msgData = g16.getBytes();
        messageForStructing.saveExtInfoToExtStr("is_eman_sc_message", "1");
        if (this.F.get(valueOf) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(messageForStructing);
            this.F.put(valueOf, arrayList);
        } else {
            this.F.get(valueOf).add(messageForStructing);
        }
        ArrayList arrayList2 = new ArrayList();
        if (!MessageHandlerUtils.msgFilter(qQAppInterface, messageForStructing, false)) {
            arrayList2.add(messageForStructing);
            qQAppInterface.getMessageFacade().j(arrayList2, String.valueOf(qQAppInterface.getCurrentAccountUin()));
        }
    }

    public boolean B(String str) {
        QidianExternalInfo qidianExternalInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this, (Object) str)).booleanValue();
        }
        if (!this.f342667e.containsKey(str) || (qidianExternalInfo = this.f342667e.get(str)) == null || qidianExternalInfo.isShowVideoCall != 1) {
            return false;
        }
        return true;
    }

    public boolean D(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, this, str, Boolean.valueOf(z16))).booleanValue();
        }
        try {
            Long.parseLong(str);
            if (!nx.a.f(str)) {
                return false;
            }
            if (nx.a.f421514k.get() && !nx.a.b(null, str)) {
                return false;
            }
            if (this.f342671m.containsKey(str) || W(str, 1)) {
                return true;
            }
            if (z16) {
                return false;
            }
            N(str, false);
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean G(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this, (Object) str)).booleanValue();
        }
        try {
            Long.parseLong(str);
            if (!this.f342666d.containsKey(str) || this.f342666d.get(str).intValue() != 3) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean L(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) str)).booleanValue();
        }
        return M(str, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0055, code lost:
    
        if (r5.f342666d.get(r6).intValue() == 1) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean M(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, this, str, Boolean.valueOf(z16))).booleanValue();
        }
        try {
            Long.parseLong(str);
        } catch (Exception unused) {
        }
        if (!nx.a.f(str)) {
            return false;
        }
        if (nx.a.f421514k.get() && !nx.a.b(null, str)) {
            return false;
        }
        if (!this.f342666d.containsKey(str)) {
            if (!W(str, 4)) {
                if (!z16) {
                    N(str, false);
                }
            }
            z17 = true;
        }
        if (z17 && this.f342667e.get(str) == null && !z16) {
            if (UiThreadUtil.isOnUiThread()) {
                ThreadManagerV2.post(new Runnable(str) { // from class: com.tencent.qidian.QidianManager.4
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ String f342680d;

                    {
                        this.f342680d = str;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QidianManager.this, (Object) str);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            QidianManager qidianManager = QidianManager.this;
                            qidianManager.z(qidianManager.E.getApp().getBaseContext(), new BmqqAccountType(this.f342680d, 1));
                        }
                    }
                }, 5, null, true);
            } else {
                z(this.E.getApp().getBaseContext(), new BmqqAccountType(str, 1));
            }
        }
        return z17;
    }

    public void N(String str, boolean z16) {
        TempGetProfileDetailProcessor tempGetProfileDetailProcessor;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, str, Boolean.valueOf(z16));
        } else if ((!nx.a.f421514k.get() || nx.a.b(null, str)) && (tempGetProfileDetailProcessor = (TempGetProfileDetailProcessor) ProfileServiceUtils.getBusinessProcessor(this.E, TempGetProfileDetailProcessor.class)) != null) {
            tempGetProfileDetailProcessor.getQidianExt(str, z16);
        }
    }

    public boolean R(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this, (Object) str)).booleanValue();
        }
        return S(str, true);
    }

    public boolean S(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, this, str, Boolean.valueOf(z16))).booleanValue();
        }
        try {
            Long.parseLong(str);
            if (!nx.a.f(str)) {
                if (QLog.isColorLevel()) {
                    QLog.d("QidianManager", 2, "isQidianMaster uin is not in bmqqsegment");
                }
                return false;
            }
            if (nx.a.f421514k.get() && nx.a.b(null, str)) {
                if (QLog.isColorLevel()) {
                    QLog.d("QidianManager", 2, "isQidianMaster is bmqquin");
                }
                return false;
            }
            boolean W = W(str, 16);
            if (!W) {
                if (this.f342666d.containsKey(str)) {
                    if (this.f342666d.get(str).intValue() == 6) {
                        QLog.i("QidianManager", 1, MsfSdkUtils.getShortUin(str) + " isQidianMaster is qidianmain");
                        W = true;
                    }
                    if (!z16) {
                        if (QLog.isColorLevel()) {
                            QLog.d("QidianManager", 2, "isQidianMaster not only in cache 0");
                        }
                        T(str);
                    }
                } else if (!z16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QidianManager", 2, "isQidianMaster not only in cache 1");
                    }
                    T(str);
                }
            } else if (!this.f342666d.containsKey(str)) {
                j0(new BmqqAccountType(str, 6));
                if (QLog.isColorLevel()) {
                    QLog.d("QidianManager", 2, "isQidianMaster update account type");
                }
            }
            if (W && !z16) {
                QidianExternalInfo q16 = q(String.valueOf(str));
                QidianProfileUiInfo u16 = u(String.valueOf(str));
                if (q16 == null || u16 == null) {
                    if (UiThreadUtil.isOnUiThread()) {
                        ThreadManagerV2.post(new Runnable(str) { // from class: com.tencent.qidian.QidianManager.7
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ String f342684d;

                            {
                                this.f342684d = str;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QidianManager.this, (Object) str);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                    return;
                                }
                                QidianManager qidianManager = QidianManager.this;
                                qidianManager.z(qidianManager.E.getApp().getBaseContext(), new BmqqAccountType(this.f342684d, 6));
                                if (QLog.isColorLevel()) {
                                    QLog.d("QidianManager", 2, "isQidianMaster get user detail in main thread");
                                }
                            }
                        }, 5, null, true);
                    } else {
                        z(this.E.getApp().getBaseContext(), new BmqqAccountType(str, 6));
                        if (QLog.isColorLevel()) {
                            QLog.d("QidianManager", 2, "isQidianMaster get user detail");
                        }
                    }
                }
            }
            if (W) {
                QLog.i("QidianManager", 1, MsfSdkUtils.getShortUin(str) + " isQidianMaster is true finally");
            }
            return W;
        } catch (Exception unused) {
            return false;
        }
    }

    public void T(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) str);
            return;
        }
        TempGetProfileDetailProcessor tempGetProfileDetailProcessor = (TempGetProfileDetailProcessor) ProfileServiceUtils.getBusinessProcessor(this.E, TempGetProfileDetailProcessor.class);
        if (tempGetProfileDetailProcessor != null) {
            tempGetProfileDetailProcessor.getQidianMaster(str);
        }
    }

    public boolean U(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Boolean) iPatchRedirector.redirect((short) 38, (Object) this, (Object) str)).booleanValue();
        }
        return this.f342666d.containsKey(str);
    }

    public boolean V(String str) {
        QidianExternalInfo qidianExternalInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, (Object) str)).booleanValue();
        }
        if (!this.f342667e.containsKey(str) || (qidianExternalInfo = this.f342667e.get(str)) == null || qidianExternalInfo.isShowCall != 1) {
            return false;
        }
        return true;
    }

    public boolean X(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, (Object) str)).booleanValue();
        }
        if (!TextUtils.isEmpty(s(str)) && V(str)) {
            return true;
        }
        return false;
    }

    public void f0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String[] split = str.split("\\?");
        if (split.length != 2) {
            return;
        }
        String[] split2 = split[1].split(ContainerUtils.FIELD_DELIMITER);
        HashMap hashMap = new HashMap();
        for (String str2 : split2) {
            String[] split3 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
            if (split3.length == 2) {
                hashMap.put(split3[0], split3[1]);
            }
        }
        String str3 = (String) hashMap.get("aioType");
        String str4 = (String) hashMap.get("uin");
        if (TextUtils.isEmpty(str3) && TextUtils.isEmpty(str4)) {
            return;
        }
        k(str, str3, str4);
    }

    public void g0(String str, String str2, String str3, String str4, int i3, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, str, str2, str3, str4, Integer.valueOf(i3), str5);
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = str3;
        }
        if (!TextUtils.isEmpty(str2)) {
            str4 = str2;
        }
        h0(str4, 1, i3, str5);
    }

    public void j(String str, int i3, boolean z16, double d16, double d17, String str2, int i16, String str3, String str4, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, str, Integer.valueOf(i3), Boolean.valueOf(z16), Double.valueOf(d16), Double.valueOf(d17), str2, Integer.valueOf(i16), str3, str4, str5);
        } else {
            ((QidianHandler) this.E.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).F2(str, i3, z16, 0.0d, 0.0d, str2, i16, str3, str4, str5);
        }
    }

    public void j0(BmqqAccountType bmqqAccountType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) bmqqAccountType);
        } else if (bmqqAccountType != null) {
            this.f342666d.put(bmqqAccountType.getUin(), Integer.valueOf(bmqqAccountType.getAccountType()));
        }
    }

    public void k(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, str, str2, str3);
            return;
        }
        String str4 = "";
        if (str2.equals("1")) {
            str4 = str3;
            str3 = "";
        } else if (!str2.equals("2")) {
            str3 = "";
        }
        ((QidianHandler) this.E.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).I2(str, str3, str4);
    }

    public void k0(BmqqUserSimpleInfo bmqqUserSimpleInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) bmqqUserSimpleInfo);
            return;
        }
        if (bmqqUserSimpleInfo != null) {
            this.f342671m.put(bmqqUserSimpleInfo.mBmqqUin, bmqqUserSimpleInfo);
        }
        if (UiThreadUtil.isOnUiThread()) {
            ThreadManagerV2.post(new Runnable(bmqqUserSimpleInfo) { // from class: com.tencent.qidian.QidianManager.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ BmqqUserSimpleInfo f342675d;

                {
                    this.f342675d = bmqqUserSimpleInfo;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QidianManager.this, (Object) bmqqUserSimpleInfo);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        QidianManager.this.l0(this.f342675d);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            }, 5, null, true);
        } else {
            l0(bmqqUserSimpleInfo);
        }
    }

    public int n(String str, QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str, (Object) qQAppInterface)).intValue();
        }
        if (!i(str, qQAppInterface)) {
            return 5;
        }
        if (R(str)) {
            return 6;
        }
        if (CrmUtils.v(qQAppInterface, str, 0)) {
            return 3;
        }
        if (L(str)) {
            return 1;
        }
        if (D(str, true)) {
            return 0;
        }
        return 4;
    }

    public QidianCorpInfo o(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (QidianCorpInfo) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        }
        if (this.f342669h.containsKey(str)) {
            return this.f342669h.get(str);
        }
        return null;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QidianManager", 4, "onDestroyd ...");
        }
        Map<String, Integer> map = this.f342666d;
        if (map != null) {
            map.clear();
        }
        Map<String, QidianExternalInfo> map2 = this.f342667e;
        if (map2 != null) {
            map2.clear();
        }
        Map<String, QidianInternalInfo> map3 = this.f342668f;
        if (map3 != null) {
            map3.clear();
        }
        Map<String, QidianCorpInfo> map4 = this.f342669h;
        if (map4 != null) {
            map4.clear();
        }
        Map<String, QidianProfileUiInfo> map5 = this.f342670i;
        if (map5 != null) {
            map5.clear();
        }
        Map<String, BmqqUserSimpleInfo> map6 = this.f342671m;
        if (map6 != null) {
            map6.clear();
        }
        Map<String, QidianPAForWpa> map7 = this.C;
        if (map7 != null) {
            map7.clear();
        }
        Map<String, String> map8 = this.D;
        if (map8 != null) {
            map8.clear();
        }
        Map<String, List<MessageRecord>> map9 = this.F;
        if (map9 != null) {
            map9.clear();
        }
        List<Object> list = this.G;
        if (list != null) {
            list.clear();
        }
        H.set(false);
    }

    public QidianExternalInfo q(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (QidianExternalInfo) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        if (this.f342667e.containsKey(str)) {
            return this.f342667e.get(str);
        }
        return null;
    }

    public QidianInternalInfo r(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (QidianInternalInfo) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
        if (this.f342668f.containsKey(str)) {
            return this.f342668f.get(str);
        }
        return null;
    }

    public void r0(QidianExternalInfo qidianExternalInfo, QidianInternalInfo qidianInternalInfo, QidianCorpInfo qidianCorpInfo, QidianProfileUiInfo qidianProfileUiInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, qidianExternalInfo, qidianInternalInfo, qidianCorpInfo, qidianProfileUiInfo);
            return;
        }
        if (qidianExternalInfo != null) {
            this.f342667e.put(qidianExternalInfo.uin, qidianExternalInfo);
        }
        if (qidianCorpInfo != null) {
            this.f342669h.put(qidianCorpInfo.corpUin, qidianCorpInfo);
        }
        if (qidianProfileUiInfo != null) {
            this.f342670i.put(qidianProfileUiInfo.uin, qidianProfileUiInfo);
        }
        if (qidianInternalInfo != null) {
            this.f342668f.put(qidianInternalInfo.uin, qidianInternalInfo);
        }
        if (UiThreadUtil.isOnUiThread()) {
            ThreadManagerV2.post(new Runnable(qidianExternalInfo, qidianInternalInfo, qidianCorpInfo, qidianProfileUiInfo) { // from class: com.tencent.qidian.QidianManager.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ QidianExternalInfo f342676d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ QidianInternalInfo f342677e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ QidianCorpInfo f342678f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ QidianProfileUiInfo f342679h;

                {
                    this.f342676d = qidianExternalInfo;
                    this.f342677e = qidianInternalInfo;
                    this.f342678f = qidianCorpInfo;
                    this.f342679h = qidianProfileUiInfo;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, QidianManager.this, qidianExternalInfo, qidianInternalInfo, qidianCorpInfo, qidianProfileUiInfo);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        QidianManager.this.s0(this.f342676d, this.f342677e, this.f342678f, this.f342679h);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            }, 5, null, true);
        } else {
            s0(qidianExternalInfo, qidianInternalInfo, qidianCorpInfo, qidianProfileUiInfo);
        }
    }

    public String s(String str) {
        QidianExternalInfo qidianExternalInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this, (Object) str);
        }
        if (this.f342667e.containsKey(str) && (qidianExternalInfo = this.f342667e.get(str)) != null) {
            return qidianExternalInfo.masterUin;
        }
        return "";
    }

    public String t(Context context, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context, (Object) str);
        }
        String p16 = p(str);
        if (!TextUtils.isEmpty(p16)) {
            return String.format(context.getString(R.string.f9k), p16);
        }
        return context.getString(R.string.f9j);
    }

    public void t0(QidianExternalInfo qidianExternalInfo, QidianProfileUiInfo qidianProfileUiInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) qidianExternalInfo, (Object) qidianProfileUiInfo);
            return;
        }
        if (qidianExternalInfo != null) {
            this.f342667e.put(qidianExternalInfo.uin, qidianExternalInfo);
        }
        if (qidianProfileUiInfo != null) {
            this.f342670i.put(qidianProfileUiInfo.uin, qidianProfileUiInfo);
        }
        if (UiThreadUtil.isOnUiThread()) {
            ThreadManagerV2.post(new Runnable(qidianExternalInfo, qidianProfileUiInfo) { // from class: com.tencent.qidian.QidianManager.8
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ QidianExternalInfo f342685d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ QidianProfileUiInfo f342686e;

                {
                    this.f342685d = qidianExternalInfo;
                    this.f342686e = qidianProfileUiInfo;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, QidianManager.this, qidianExternalInfo, qidianProfileUiInfo);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        QidianManager.this.u0(this.f342685d, this.f342686e);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            }, 5, null, true);
        } else {
            u0(qidianExternalInfo, qidianProfileUiInfo);
        }
    }

    public QidianProfileUiInfo u(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (QidianProfileUiInfo) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        }
        if (this.f342670i.containsKey(str)) {
            return this.f342670i.get(str);
        }
        return null;
    }

    public boolean x(Context context, BmqqAccountType bmqqAccountType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, (Object) context, (Object) bmqqAccountType)).booleanValue();
        }
        if (bmqqAccountType == null) {
            return false;
        }
        String uin = bmqqAccountType.getUin();
        try {
            long parseLong = Long.parseLong(uin);
            if (!nx.a.f(uin)) {
                return false;
            }
            int accountType = bmqqAccountType.getAccountType();
            if (accountType != 1) {
                if (accountType != 6) {
                    return false;
                }
                ((QidianHandler) this.E.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).O2(parseLong);
            } else {
                ((QidianHandler) this.E.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).P2(parseLong);
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public int y(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Integer) iPatchRedirector.redirect((short) 39, (Object) this, (Object) str)).intValue();
        }
        return this.f342666d.get(str).intValue();
    }

    public boolean z(Context context, BmqqAccountType bmqqAccountType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, (Object) context, (Object) bmqqAccountType)).booleanValue();
        }
        if (bmqqAccountType == null) {
            return false;
        }
        String uin = bmqqAccountType.getUin();
        try {
            long parseLong = Long.parseLong(uin);
            if (!nx.a.f(uin)) {
                return false;
            }
            int accountType = bmqqAccountType.getAccountType();
            if (accountType != 0) {
                if (accountType != 1) {
                    if (accountType != 2) {
                        if (accountType != 6) {
                            return false;
                        }
                        ((QidianHandler) this.E.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).N2(parseLong);
                    }
                } else {
                    ((QidianHandler) this.E.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).Q2(parseLong);
                }
                return true;
            }
            ((BmqqBusinessHandler) this.E.getBusinessHandler(BusinessHandlerFactory.BMQQ_BUSINESS_HANDLER)).E2(uin);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
