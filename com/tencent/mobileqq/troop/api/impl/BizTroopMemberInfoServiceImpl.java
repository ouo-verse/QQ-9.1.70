package com.tencent.mobileqq.troop.api.impl;

import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCard;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.data.HWTroopMemberCard;
import com.tencent.mobileqq.troop.util.api.ITroopDBUtilsApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troopmemberlist.ITroopMemberExtDBApi;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x6ef.oidb_cmd0x6ef$ReqBody;

/* compiled from: P */
/* loaded from: classes19.dex */
public class BizTroopMemberInfoServiceImpl implements IBizTroopMemberInfoService {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "BizTroopMemberInfoServiceImpl";

    /* renamed from: em, reason: collision with root package name */
    protected EntityManager f294211em;
    protected AppRuntime mApp;
    protected LruCache<String, HWTroopMemberCard> mHWTroopMemberCardCache;
    protected LruCache<a, Drawable> mMemberLevelColorCache;
    protected LruCache<String, TroopMemberCard> mTroopMemberCardCache;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f294218a;

        /* renamed from: b, reason: collision with root package name */
        public String f294219b;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) BizTroopMemberInfoServiceImpl.this);
            }
        }

        public boolean equals(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj)).booleanValue();
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (aVar.f294218a == this.f294218a && aVar.f294219b.equals(this.f294219b)) {
                    return true;
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.f294218a + this.f294219b.hashCode();
        }
    }

    public BizTroopMemberInfoServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mMemberLevelColorCache = new LruCache<>(10);
        this.mTroopMemberCardCache = new LruCache<>(50);
        this.mHWTroopMemberCardCache = new LruCache<>(50);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$saveHomeworkTroopMemberIdentity$0(String str, String str2, int i3, String str3, TroopMemberInfo troopMemberInfo) {
        if (troopMemberInfo == null) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "saveHomeworkTroopMemberIdentity , info is null ... ");
                return;
            }
            return;
        }
        com.tencent.mobileqq.troop.change.troopmemberinfo.b bVar = new com.tencent.mobileqq.troop.change.troopmemberinfo.b();
        bVar.b(troopMemberInfo);
        TroopMemberCardInfo troopMemberCardInfo = ((ITroopDBUtilsApi) QRoute.api(ITroopDBUtilsApi.class)).getTroopMemberCardInfo(this.mApp, str, str2);
        boolean z16 = true;
        boolean z17 = false;
        if (i3 != -100) {
            if (i3 != troopMemberInfo.getHWIdentity()) {
                z17 = true;
            }
            if (i3 != troopMemberInfo.titleId) {
                troopMemberInfo.titleId = i3;
                z17 = true;
            }
        }
        if (str3 != null && !str3.equals(troopMemberInfo.troopnick)) {
            if (troopMemberCardInfo != null && !TextUtils.equals(str3, troopMemberCardInfo.name)) {
                troopMemberCardInfo.name = str3;
            }
        } else {
            z16 = z17;
        }
        if (z16) {
            ((ITroopMemberExtDBApi) QRoute.api(ITroopMemberExtDBApi.class)).updateHwIdentity(str, str2, i3, TAG);
        }
        bVar.a(troopMemberInfo);
        bVar.c();
    }

    @Override // com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService
    public void asynSaveHomeworkTroopMemberIdentity(String str, String str2, String str3, int i3, String str4, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, str2, str3, Integer.valueOf(i3), str4, str5);
        } else {
            ThreadManagerV2.post(new Runnable(str, str2, str3, i3, str4, str5) { // from class: com.tencent.mobileqq.troop.api.impl.BizTroopMemberInfoServiceImpl.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f294212d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f294213e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ String f294214f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ int f294215h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ String f294216i;

                /* renamed from: m, reason: collision with root package name */
                final /* synthetic */ String f294217m;

                {
                    this.f294212d = str;
                    this.f294213e = str2;
                    this.f294214f = str3;
                    this.f294215h = i3;
                    this.f294216i = str4;
                    this.f294217m = str5;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, BizTroopMemberInfoServiceImpl.this, str, str2, str3, Integer.valueOf(i3), str4, str5);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        BizTroopMemberInfoServiceImpl.this.saveHomeworkTroopMemberIdentity(this.f294212d, this.f294213e, this.f294214f, this.f294215h, this.f294216i, this.f294217m);
                    }
                }
            }, 8, null, false);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService
    public boolean getCalendarNoticeTroopMember(String str, String str2, long j3, ProtoUtils.TroopProtocolObserver troopProtocolObserver) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, str, str2, Long.valueOf(j3), troopProtocolObserver)).booleanValue();
        }
        oidb_cmd0x6ef$ReqBody oidb_cmd0x6ef_reqbody = new oidb_cmd0x6ef$ReqBody();
        oidb_cmd0x6ef_reqbody.f435975gc.set(Long.parseLong(str));
        oidb_cmd0x6ef_reqbody.event_id.set(str2);
        oidb_cmd0x6ef_reqbody.seq.set(j3);
        ProtoUtils.j(this.mApp, troopProtocolObserver, oidb_cmd0x6ef_reqbody.toByteArray(), "OidbSvc.0x6ef_0", 1775, 0);
        return false;
    }

    @Override // com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService
    public HWTroopMemberCard getHWTroopMemberCard(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (HWTroopMemberCard) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str, (Object) str2);
        }
        return this.mHWTroopMemberCardCache.get(str + "_" + str2);
    }

    @Override // com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService
    public MessageRecord getRobotLastSpeakMessage(String str, String str2) {
        String str3;
        int length;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2);
        }
        int[] iArr = com.tencent.mobileqq.troop.api.e.f294201a;
        if (iArr != null && (length = iArr.length) > 0) {
            StringBuilder sb5 = new StringBuilder();
            for (int i3 = 0; i3 < length; i3++) {
                sb5.append(com.tencent.mobileqq.troop.api.e.f294201a[i3]);
                if (i3 < length - 1) {
                    sb5.append(" , ");
                }
            }
            str3 = sb5.toString();
        } else {
            str3 = null;
        }
        EntityManager createEntityManager = this.mApp.getEntityManagerFactory().createEntityManager();
        List<? extends Entity> query = createEntityManager.query(MessageRecord.class, MessageRecord.getTableName(str, 1), false, String.format("shmsgseq < %d and senderuin = ? and extLong & 3 <> 3 and msgtype in (%s)", Long.MAX_VALUE, str3), new String[]{str2}, (String) null, (String) null, "shmsgseq DESC", String.valueOf(1));
        createEntityManager.close();
        if (query == null || query.isEmpty()) {
            return null;
        }
        return (MessageRecord) query.get(0);
    }

    @Override // com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService
    public TroopMemberCard getTroopMemberCard(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (TroopMemberCard) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, (Object) str2);
        }
        return this.mTroopMemberCardCache.get(str + "_" + str2);
    }

    @Override // com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService
    public Drawable getTroopMemberLevelDrawable(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Drawable) iPatchRedirector.redirect((short) 9, (Object) this, i3, (Object) str);
        }
        a aVar = new a();
        aVar.f294218a = i3;
        aVar.f294219b = str;
        return this.mMemberLevelColorCache.get(aVar);
    }

    @Override // com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService
    public String getTroopMemberNickNoEmpty(String str, String str2) {
        String str3;
        TroopInfo findTroopInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, (Object) str2);
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            TroopMemberInfo troopMemberInfoSync = ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberInfoSync(str, str2, null, "BizTroopMemberInfoServiceImpl-getTroopMemberNickNoEmpty");
            if (troopMemberInfoSync == null) {
                str3 = "";
            } else if (!TextUtils.isEmpty(troopMemberInfoSync.troopnick)) {
                str3 = troopMemberInfoSync.troopnick;
            } else if (!TextUtils.isEmpty(troopMemberInfoSync.friendnick)) {
                str3 = troopMemberInfoSync.friendnick;
            } else {
                str3 = str2;
            }
            if (str3 != null && str3.equals(str2) && (findTroopInfo = ((ITroopInfoService) this.mApp.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(str)) != null && findTroopInfo.isQidianPrivateTroop()) {
                return TroopInfo.QIDIAN_TROOP_MEMBER_DEF_NICK;
            }
            return str3;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getTroopMemberNick uin is null");
        }
        return "";
    }

    @Override // com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService
    public void handleAgreeJion(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, str, str2, str3);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            this.mApp = appRuntime;
            this.f294211em = appRuntime.getEntityManagerFactory().createEntityManager();
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService
    public void saveHWTroopMemberCard(String str, String str2, HWTroopMemberCard hWTroopMemberCard) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, str, str2, hWTroopMemberCard);
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && hWTroopMemberCard != null) {
            this.mHWTroopMemberCardCache.put(str + "_" + str2, hWTroopMemberCard);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService
    public void saveHomeworkTroopMemberIdentity(final String str, final String str2, final String str3, final int i3, String str4, String str5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, str2, str3, Integer.valueOf(i3), str4, str5);
        } else {
            ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberInfoWithExtInfo(str, str2, false, null, "BizTroopMemberInfoServiceImpl-saveHWIdentity", new com.tencent.qqnt.troopmemberlist.g() { // from class: com.tencent.mobileqq.troop.api.impl.b
                @Override // com.tencent.qqnt.troopmemberlist.g
                public final void a(TroopMemberInfo troopMemberInfo) {
                    BizTroopMemberInfoServiceImpl.this.lambda$saveHomeworkTroopMemberIdentity$0(str, str2, i3, str3, troopMemberInfo);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService
    public void saveTroopMemberLevelDrawable(int i3, String str, Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), str, drawable);
            return;
        }
        a aVar = new a();
        aVar.f294218a = i3;
        aVar.f294219b = str;
        this.mMemberLevelColorCache.put(aVar, drawable);
    }

    @Override // com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService
    public boolean saveTroopMemberSpearkFlag(String str, String str2, byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, str, str2, Byte.valueOf(b16))).booleanValue();
        }
        return false;
    }
}
