package com.tencent.mobileqq.profile.vote;

import android.text.TextUtils;
import android.text.format.DateUtils;
import android.widget.ImageView;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.nearby.api.INearbyLikeLimitManagerUtil;
import com.tencent.mobileqq.nearby.c;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.dc;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.y;
import com.tencent.qqnt.msg.f;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes16.dex */
public class VoteHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: o, reason: collision with root package name */
    public static final Object f260553o;

    /* renamed from: p, reason: collision with root package name */
    public static final Object f260554p;

    /* renamed from: q, reason: collision with root package name */
    public static String f260555q;

    /* renamed from: r, reason: collision with root package name */
    public static String f260556r;

    /* renamed from: s, reason: collision with root package name */
    public static long f260557s;

    /* renamed from: a, reason: collision with root package name */
    VisitorsActivity f260558a;

    /* renamed from: b, reason: collision with root package name */
    MqqWeakReferenceHandler f260559b;

    /* renamed from: c, reason: collision with root package name */
    QQAppInterface f260560c;

    /* renamed from: d, reason: collision with root package name */
    int f260561d;

    /* renamed from: e, reason: collision with root package name */
    int f260562e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f260563f;

    /* renamed from: g, reason: collision with root package name */
    long f260564g;

    /* renamed from: h, reason: collision with root package name */
    String f260565h;

    /* renamed from: i, reason: collision with root package name */
    String f260566i;

    /* renamed from: j, reason: collision with root package name */
    String f260567j;

    /* renamed from: k, reason: collision with root package name */
    ArrayList<Long> f260568k;

    /* renamed from: l, reason: collision with root package name */
    ArrayList<Long> f260569l;

    /* renamed from: m, reason: collision with root package name */
    public Map<Long, Pair<CardProfile, AtomicInteger>> f260570m;

    /* renamed from: n, reason: collision with root package name */
    public Map<Long, Pair<CardProfile, Pair<AtomicInteger, AtomicInteger>>> f260571n;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements c.d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CardProfile f260580a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ImageView f260581b;

        a(CardProfile cardProfile, ImageView imageView) {
            this.f260580a = cardProfile;
            this.f260581b = imageView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, VoteHelper.this, cardProfile, imageView);
            }
        }

        @Override // com.tencent.mobileqq.nearby.c.d
        public void a(String str, boolean z16) {
            String str2;
            String str3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Boolean.valueOf(z16));
                return;
            }
            VoteHelper.this.c(this.f260580a, this.f260581b, z16);
            INearbyLikeLimitManagerUtil iNearbyLikeLimitManagerUtil = (INearbyLikeLimitManagerUtil) QRoute.api(INearbyLikeLimitManagerUtil.class);
            QQAppInterface qQAppInterface = VoteHelper.this.f260560c;
            if (this.f260580a.type == 3) {
                str2 = "1";
            } else {
                str2 = "2";
            }
            if (!z16) {
                str3 = "1";
            } else {
                str3 = "2";
            }
            iNearbyLikeLimitManagerUtil.report(qQAppInterface, "detail_like", str, str2, "", "", str3);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73914);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
            return;
        }
        f260553o = new Object();
        f260554p = new Object();
        f260555q = "sp_key_vote_max_friend";
        f260556r = "sp_key_vote_max_stranger";
        f260557s = -1L;
    }

    public VoteHelper(VisitorsActivity visitorsActivity, MqqWeakReferenceHandler mqqWeakReferenceHandler, QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, visitorsActivity, mqqWeakReferenceHandler, qQAppInterface);
            return;
        }
        this.f260563f = false;
        this.f260568k = new ArrayList<>();
        this.f260569l = new ArrayList<>();
        this.f260570m = new HashMap();
        this.f260571n = new HashMap();
        this.f260558a = visitorsActivity;
        this.f260559b = mqqWeakReferenceHandler;
        this.f260560c = qQAppInterface;
        f260557s = -1L;
    }

    private Map<Long, Boolean> a() {
        Set<Long> set;
        Long l3;
        Map<Long, Pair<CardProfile, AtomicInteger>> map = this.f260570m;
        if (map != null) {
            set = map.keySet();
        } else {
            set = null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        HashMap hashMap = new HashMap();
        IRelationNTUinAndUidApi iRelationNTUinAndUidApi = (IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class);
        if (set != null) {
            Iterator<Long> it = set.iterator();
            while (it.hasNext()) {
                long longValue = it.next().longValue();
                String uidFromUin = iRelationNTUinAndUidApi.getUidFromUin(String.valueOf(longValue));
                if (!TextUtils.isEmpty(uidFromUin)) {
                    arrayList.add(uidFromUin);
                    hashMap.put(uidFromUin, Long.valueOf(longValue));
                }
            }
        }
        Map<String, Boolean> isFriends = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriends("VisitorsActivity.VoteHelper", arrayList);
        HashMap hashMap2 = new HashMap();
        for (Map.Entry<String, Boolean> entry : isFriends.entrySet()) {
            String key = entry.getKey();
            Boolean value = entry.getValue();
            if (!TextUtils.isEmpty(key) && value != null && (l3 = (Long) hashMap.get(key)) != null) {
                hashMap2.put(l3, value);
            }
        }
        return hashMap2;
    }

    private void d(ArrayList<Long> arrayList) {
        boolean z16;
        this.f260569l.clear();
        this.f260568k.clear();
        HashMap hashMap = new HashMap();
        y f16 = f.f();
        if (f16 != null) {
            try {
                hashMap.putAll(f16.getUidByUin("VisitorsActivity.VoteHelper", arrayList));
            } catch (Exception e16) {
                QLog.i("VisitorsActivity.VoteHelper", 1, "checkProfileIsFriend fail " + e16);
            }
        }
        Map<String, Boolean> isFriends = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriends("VisitorsActivity.VoteHelper", new ArrayList<>(hashMap.values()));
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if (arrayList.get(i3) != null) {
                String str = (String) hashMap.get(Long.valueOf(arrayList.get(i3).longValue()));
                if (!TextUtils.isEmpty(str) && isFriends.containsKey(str)) {
                    z16 = Boolean.TRUE.equals(isFriends.get(str));
                } else {
                    z16 = false;
                }
                if (z16) {
                    this.f260568k.add(arrayList.get(i3));
                } else {
                    this.f260569l.add(arrayList.get(i3));
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("VisitorsActivity.VoteHelper", 2, "fillTodayVoteArray " + arrayList.size() + " friend:" + this.f260568k.size() + " stranger:" + this.f260569l.size());
        }
    }

    public static boolean n(QQAppInterface qQAppInterface) {
        if (f260557s < 0) {
            f260557s = qQAppInterface.getPreferences().getLong("keyShowDoubleZanPopTime", 0L);
        }
        if (DateUtils.isToday(f260557s)) {
            return false;
        }
        f260557s = System.currentTimeMillis();
        qQAppInterface.getPreferences().edit().putLong("keyShowDoubleZanPopTime", f260557s).commit();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01f0  */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r7v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int b(CardProfile cardProfile) {
        StringBuilder sb5;
        ArrayList<Long> arrayList;
        int i3;
        ?? r75;
        int i16;
        int i17;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i18 = 6;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) cardProfile)).intValue();
        }
        if (QLog.isColorLevel()) {
            sb5 = new StringBuilder("checkVote log ");
        } else {
            sb5 = null;
        }
        boolean isFriend = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(Long.toString(cardProfile.lEctID)), "VisitorsActivity.VoteHelper");
        if (isFriend) {
            arrayList = this.f260568k;
        } else {
            arrayList = this.f260569l;
        }
        if (isFriend) {
            i3 = this.f260561d;
        } else {
            i3 = this.f260562e;
        }
        if (cardProfile.type == 2) {
            if (isFriend) {
                i18 = 5;
            }
        } else if (isFriend) {
            i18 = 7;
        } else {
            i18 = 8;
        }
        int i19 = i18;
        if (QLog.isDebugVersion() && sb5 != null) {
            sb5.append(",");
            sb5.append("limit");
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(i3);
            sb5.append(",");
            sb5.append("isFrd");
            sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb5.append(isFriend);
            sb5.append(",");
            sb5.append(cardProfile.getSimpleZanInfo());
            QLog.i("VisitorsActivity.VoteHelper", 2, sb5.toString());
        }
        synchronized (f260554p) {
            r75 = 0;
            if (arrayList.size() < i3) {
                i16 = 1;
            } else {
                for (int i26 = 0; i26 < arrayList.size(); i26++) {
                    if (arrayList.get(i26).longValue() == cardProfile.lEctID) {
                        i17 = 2;
                        i16 = 1;
                        break;
                    }
                }
                i16 = 0;
            }
            i17 = i16;
        }
        if (i16 == 0 && i17 == 0) {
            if (isFriend) {
                str = this.f260565h;
            } else {
                str = this.f260566i;
            }
            o(String.format(str, Integer.valueOf(i3)));
            ReportController.n(this.f260560c, "CliOper", "", "0X8006579", "0X8006579", "", i19, 1, 0, "", "", "", "");
        } else if (i16 != 0 && cardProfile.bAvailableCnt <= 0) {
            if (isFriend) {
                if (VasUtil.getSignedService(this.f260560c).getVipStatus().isSVip()) {
                    VasWebviewUtil.reportCommercialDrainage(this.f260560c.getCurrentAccountUin(), "thumbup", "limit_20", "", 1, 0, 0, "", Integer.toString(cardProfile.type), "");
                    o("\u5df2\u70b9\u6ee1SVIP\u4e13\u4eab20\u4e2a\u8d5e\u5566~");
                } else {
                    if (n(this.f260560c)) {
                        return 2;
                    }
                    VasWebviewUtil.reportCommercialDrainage(this.f260560c.getCurrentAccountUin(), "thumbup", "limit_10", "", 1, 0, 0, "", Integer.toString(cardProfile.type), "");
                    o("\u975eSVIP\u7528\u6237\u6bcf\u5929\u53ea\u80fd\u70b910\u4e2a\u8d5e\u54e6\uff5e");
                }
            }
            String format = String.format(this.f260567j, Long.valueOf(cardProfile.bTodayVotedCnt));
            if (cardProfile.bSex == 1) {
                format = format.replace(HardCodeUtil.qqStr(R.string.vja), HardCodeUtil.qqStr(R.string.vj9));
            }
            o(format);
            ReportController.n(this.f260560c, "CliOper", "", "0X8006578", "0X8006578", "", i19, 1, 0, "", "", "", "");
            i17 = 4;
            if (QLog.isDebugVersion()) {
                QLog.i("VisitorsActivity.VoteHelper", 2, "checkVote " + cardProfile.lEctID + " logLevel:" + i17 + " can:" + ((boolean) r75));
            }
            return r75;
        }
        r75 = i16;
        if (QLog.isDebugVersion()) {
        }
        return r75;
    }

    public void c(CardProfile cardProfile, ImageView imageView, boolean z16) {
        boolean z17;
        AtomicInteger atomicInteger;
        CardProfile cardProfile2;
        AtomicInteger atomicInteger2;
        AtomicInteger atomicInteger3;
        short s16;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, cardProfile, imageView, Boolean.valueOf(z16));
            return;
        }
        synchronized (f260553o) {
            cardProfile.bAvailableCnt--;
            long j3 = cardProfile.bTodayVotedCnt + 1;
            cardProfile.bTodayVotedCnt = j3;
            if (cardProfile.type == 3) {
                cardProfile.bVoteCnt = (short) j3;
                cardProfile.dwLikeCustomId = PraiseManager.f(this.f260560c);
                if (z16) {
                    s16 = 0;
                } else {
                    s16 = 1;
                }
                cardProfile.bIsLastVoteCharged = s16;
                cardProfile.updateTime(System.currentTimeMillis() / 1000);
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z16 && !z17) {
                cardProfile.payVoteCount = (short) (cardProfile.payVoteCount + 1);
            }
            boolean isFriend = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(Long.toString(cardProfile.lEctID)), "VisitorsActivity.VoteHelper");
            if (QLog.isDebugVersion()) {
                QLog.d("VisitorsActivity.VoteHelper", 2, "doVote, uin=" + cardProfile.lEctID + ", isFriend=" + isFriend);
            }
            if (!isFriend && ((INearbyLikeLimitManagerUtil) QRoute.api(INearbyLikeLimitManagerUtil.class)).isNeedNewLimitCheck(cardProfile.uSource)) {
                if (!this.f260571n.containsKey(Long.valueOf(cardProfile.lEctID))) {
                    atomicInteger3 = new AtomicInteger(0);
                    atomicInteger2 = new AtomicInteger(0);
                    this.f260571n.put(Long.valueOf(cardProfile.lEctID), new Pair<>(cardProfile, new Pair(atomicInteger3, atomicInteger2)));
                } else {
                    Pair<AtomicInteger, AtomicInteger> pair = this.f260571n.get(Long.valueOf(cardProfile.lEctID)).second;
                    AtomicInteger atomicInteger4 = pair.first;
                    atomicInteger2 = pair.second;
                    atomicInteger3 = atomicInteger4;
                }
                if (z16) {
                    atomicInteger3.incrementAndGet();
                } else {
                    atomicInteger2.incrementAndGet();
                }
            } else {
                if (!this.f260570m.containsKey(Long.valueOf(cardProfile.lEctID))) {
                    atomicInteger = new AtomicInteger(0);
                    this.f260570m.put(Long.valueOf(cardProfile.lEctID), new Pair<>(cardProfile, atomicInteger));
                } else {
                    atomicInteger = this.f260570m.get(Long.valueOf(cardProfile.lEctID)).second;
                }
                atomicInteger.incrementAndGet();
            }
            if (z17) {
                int i16 = 0;
                while (true) {
                    if (i16 < this.f260558a.f177538m0.size()) {
                        cardProfile2 = this.f260558a.f177538m0.get(i16);
                        if (cardProfile2 != null && cardProfile2.lEctID == cardProfile.lEctID) {
                            long j16 = cardProfile2.bTodayVotedCnt + 1;
                            cardProfile2.bTodayVotedCnt = j16;
                            cardProfile2.bAvailableCnt--;
                            cardProfile2.bVoteCnt = (short) j16;
                            if (!z16) {
                                cardProfile2.payVoteCount = (short) (cardProfile2.payVoteCount + 1);
                            }
                        } else {
                            i16++;
                        }
                    } else {
                        cardProfile2 = null;
                        break;
                    }
                }
                if (cardProfile2 == null) {
                    cardProfile2 = cardProfile.m167clone();
                    cardProfile2.type = 3;
                    cardProfile2.bVoteCnt = (short) cardProfile2.bTodayVotedCnt;
                    cardProfile2.bAvailableCnt = cardProfile.bAvailableCnt;
                    this.f260558a.f177538m0.add(0, cardProfile2);
                    this.f260558a.v3();
                    if (QLog.isDebugVersion()) {
                        QLog.i("VisitorsActivity.VoteHelper", 2, "onVoteClick add to FavList. uin:" + cardProfile2.lEctID);
                    }
                }
                cardProfile2.updateTime(System.currentTimeMillis() / 1000);
            } else {
                while (true) {
                    if (i3 >= this.f260558a.f177520d0.size()) {
                        break;
                    }
                    if (this.f260558a.f177520d0.get(i3).lEctID == cardProfile.lEctID) {
                        CardProfile cardProfile3 = this.f260558a.f177520d0.get(i3);
                        cardProfile3.bTodayVotedCnt++;
                        cardProfile3.bAvailableCnt--;
                        break;
                    }
                    i3++;
                }
            }
        }
        this.f260558a.x3(cardProfile.lEctID);
        this.f260558a.R2(imageView, z16);
        if (!this.f260559b.hasMessages(6)) {
            this.f260559b.sendEmptyMessageDelayed(6, 2000L);
        }
        ThreadManagerV2.post(new Runnable(cardProfile.lEctID, cardProfile.type, z16, cardProfile.uSource) { // from class: com.tencent.mobileqq.profile.vote.VoteHelper.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f260572d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f260573e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ boolean f260574f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ long f260575h;

            {
                this.f260572d = r6;
                this.f260573e = r8;
                this.f260574f = z16;
                this.f260575h = r10;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, VoteHelper.this, Long.valueOf(r6), Integer.valueOf(r8), Boolean.valueOf(z16), Long.valueOf(r10));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                int i17;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                int i18 = 2;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                boolean isFriend2 = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).isFriend(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(Long.toString(this.f260572d)), "VisitorsActivity.VoteHelper");
                if (this.f260573e == 2) {
                    if (isFriend2) {
                        i17 = 5;
                    } else {
                        i17 = 6;
                    }
                } else if (isFriend2) {
                    i17 = 7;
                } else {
                    i17 = 8;
                }
                int i19 = i17;
                if (PraiseManager.f(VoteHelper.this.f260560c) > 0) {
                    if (!this.f260574f) {
                        i18 = 3;
                    }
                } else if (this.f260574f) {
                    i18 = 0;
                } else {
                    i18 = 1;
                }
                ReportController.n(VoteHelper.this.f260560c, "CliOper", "", "", "P_prof", "Prof_good", i19, 1, i18, Long.toString(this.f260575h), "1", VoteHelper.this.f260560c.getCurrentAccountUin(), Long.toString(this.f260572d));
            }
        }, 2, null, true);
    }

    public int e(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str, i3)).intValue();
        }
        int i16 = this.f260560c.getPreferences().getInt(str, i3);
        if (QLog.isColorLevel()) {
            QLog.i("VisitorsActivity.VoteHelper", 2, "getSp key:" + str + " value:" + i16);
        }
        return i16;
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.f260561d = e(f260555q, 0);
        this.f260562e = e(f260555q, 0);
        ArrayList<Long> arrayList = new ArrayList<>();
        this.f260558a.f177531i1.n3(arrayList);
        synchronized (f260554p) {
            d(arrayList);
        }
        this.f260565h = this.f260558a.getResources().getString(R.string.f171510fq1);
        this.f260566i = this.f260558a.getResources().getString(R.string.f171512fq3);
        this.f260567j = this.f260558a.getResources().getString(R.string.f171511fq2);
    }

    public void g(ArrayList<Long> arrayList, int i3, int i16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, arrayList, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3));
            return;
        }
        this.f260561d = i3;
        this.f260562e = i16;
        if (j3 == 0) {
            synchronized (f260554p) {
                d(arrayList);
            }
        }
        m(f260555q, this.f260561d);
        m(f260556r, this.f260562e);
    }

    public boolean h(CardProfile cardProfile, ImageView imageView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) cardProfile, (Object) imageView)).booleanValue();
        }
        if (!NetworkUtil.isNetSupport(this.f260558a)) {
            o(HardCodeUtil.qqStr(R.string.vj_));
            return false;
        }
        int b16 = b(cardProfile);
        if (b16 == 0) {
            return false;
        }
        if (b16 == 2) {
            return true;
        }
        boolean b17 = RecentUtil.b(this.f260560c, Long.toString(cardProfile.lEctID));
        if (QLog.isColorLevel()) {
            QLog.d("NearbyLikeLimitManager", 2, "VisitorActivity->onClickVote, uin=" + cardProfile.lEctID + ", isFriend=" + b17);
        }
        if (!b17 && ((INearbyLikeLimitManagerUtil) QRoute.api(INearbyLikeLimitManagerUtil.class)).isNeedNewLimitCheck(cardProfile.uSource)) {
            ((c) this.f260560c.getManager(QQManagerFactory.NEARBY_LIKE_LIMIT_MANAGER)).e(this.f260558a, this.f260560c, Long.toString(cardProfile.lEctID), new a(cardProfile, imageView), "511");
        } else {
            c(cardProfile, imageView, true);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x009a, code lost:
    
        r2 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void i(String str, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        long longValue = Long.valueOf(str).longValue();
        if (QLog.isColorLevel()) {
            QLog.i("VisitorsActivity.VoteHelper", 2, "onVoteError, uin:" + str + " voteNum:" + i3);
        }
        synchronized (f260553o) {
            int i17 = 0;
            while (true) {
                if (i17 >= this.f260558a.f177538m0.size()) {
                    break;
                }
                CardProfile cardProfile = this.f260558a.f177538m0.get(i17);
                if (cardProfile != null && cardProfile.lEctID == longValue) {
                    long j3 = i3;
                    long j16 = cardProfile.bTodayVotedCnt - j3;
                    cardProfile.bTodayVotedCnt = j16;
                    cardProfile.bAvailableCnt += j3;
                    short s16 = (short) (cardProfile.bVoteCnt - i3);
                    cardProfile.bVoteCnt = s16;
                    if (j16 <= 0 || s16 <= 0) {
                        this.f260558a.f177538m0.remove(i17);
                    }
                } else {
                    i17++;
                }
            }
            while (true) {
                if (i16 >= this.f260558a.f177520d0.size()) {
                    break;
                }
                if (this.f260558a.f177520d0.get(i16).lEctID == longValue) {
                    CardProfile cardProfile2 = this.f260558a.f177520d0.get(i16);
                    long j17 = i3;
                    cardProfile2.bTodayVotedCnt -= j17;
                    cardProfile2.bAvailableCnt += j17;
                    break;
                }
                i16++;
            }
        }
        this.f260558a.x3(longValue);
        if (z17) {
            this.f260558a.v3();
        }
    }

    public void j(String str, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else {
            ThreadManagerV2.postImmediately(new Runnable(str, i3, z16) { // from class: com.tencent.mobileqq.profile.vote.VoteHelper.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f260576d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f260577e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ boolean f260578f;

                {
                    this.f260576d = str;
                    this.f260577e = i3;
                    this.f260578f = z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, VoteHelper.this, str, Integer.valueOf(i3), Boolean.valueOf(z16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    boolean z17;
                    CardProfile cardProfile;
                    CardProfile cardProfile2;
                    ArrayList<Long> arrayList;
                    boolean z18;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    long longValue = Long.valueOf(this.f260576d).longValue();
                    EntityManager createEntityManager = VoteHelper.this.f260560c.getEntityManagerFactory().createEntityManager();
                    CardProfile cardProfile3 = (CardProfile) DBMethodProxy.find(createEntityManager, CardProfile.class, "lEctID=? and type=?", new String[]{Long.toString(longValue), Integer.toString(3)});
                    if (cardProfile3 != null) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("VisitorsActivity.VoteHelper", 2, "onVoteOk, uin:" + this.f260576d + " voteNum:" + this.f260577e + "dbHas:" + z17);
                    }
                    Pair<CardProfile, AtomicInteger> pair = VoteHelper.this.f260570m.get(Long.valueOf(longValue));
                    synchronized (VoteHelper.f260553o) {
                        int i16 = 0;
                        while (true) {
                            cardProfile = null;
                            if (i16 < VoteHelper.this.f260558a.f177538m0.size()) {
                                cardProfile2 = VoteHelper.this.f260558a.f177538m0.get(i16);
                                if (cardProfile2 != null && cardProfile2.lEctID == longValue) {
                                    break;
                                } else {
                                    i16++;
                                }
                            } else {
                                cardProfile2 = null;
                                break;
                            }
                        }
                        if (cardProfile2 != null) {
                            cardProfile = cardProfile2.m167clone();
                            if (pair != null) {
                                cardProfile.bAvailableCnt += pair.second.get();
                                cardProfile.bTodayVotedCnt -= pair.second.get();
                            }
                            cardProfile.bVoteCnt = (short) cardProfile.bTodayVotedCnt;
                        }
                    }
                    if (cardProfile != null && (!z17 || cardProfile3.bTodayVotedCnt != cardProfile.bTodayVotedCnt || cardProfile3.bAvailableCnt != cardProfile.bAvailableCnt || cardProfile3.bVoteCnt != cardProfile.bVoteCnt)) {
                        if (cardProfile.getStatus() == 1000) {
                            createEntityManager.persistOrReplace(cardProfile);
                        } else {
                            createEntityManager.update(cardProfile);
                        }
                    }
                    if (this.f260578f) {
                        arrayList = VoteHelper.this.f260568k;
                    } else {
                        arrayList = VoteHelper.this.f260569l;
                    }
                    synchronized (VoteHelper.f260554p) {
                        int i17 = 0;
                        while (true) {
                            if (i17 < arrayList.size()) {
                                if (arrayList.get(i17).longValue() == longValue) {
                                    z18 = false;
                                    break;
                                }
                                i17++;
                            } else {
                                z18 = true;
                                break;
                            }
                        }
                        if (z18) {
                            arrayList.add(Long.valueOf(longValue));
                        }
                    }
                    if (z18) {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.addAll(VoteHelper.this.f260568k);
                        arrayList2.addAll(VoteHelper.this.f260569l);
                        VoteHelper.this.f260558a.f177531i1.S4(arrayList2);
                    }
                }
            }, null, false);
        }
    }

    public void k(long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Long.valueOf(j3), Integer.valueOf(i3));
        } else {
            this.f260558a.f177531i1.P4(this.f260560c.getCurrentAccountUin(), j3, i3);
        }
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("VisitorsActivity.VoteHelper", 2, "reqestVote");
        }
        long longAccountUin = this.f260560c.getLongAccountUin();
        Map<Long, Boolean> a16 = a();
        for (Map.Entry<Long, Pair<CardProfile, AtomicInteger>> entry : this.f260570m.entrySet()) {
            long longValue = entry.getKey().longValue();
            Pair<CardProfile, AtomicInteger> value = entry.getValue();
            boolean equals = Boolean.TRUE.equals(a16.get(Long.valueOf(longValue)));
            synchronized (f260553o) {
                if (value.second.get() > 0) {
                    if (equals) {
                        this.f260558a.f177531i1.Q4(longAccountUin, longValue, null, 66, value.second.get(), 1);
                    } else {
                        this.f260558a.f177535k1.A2(longAccountUin, longValue, null, 66, value.second.get(), 1);
                    }
                    value.second.set(0);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Long, Pair<CardProfile, Pair<AtomicInteger, AtomicInteger>>> entry2 : this.f260571n.entrySet()) {
            long longValue2 = entry2.getKey().longValue();
            Pair<CardProfile, Pair<AtomicInteger, AtomicInteger>> value2 = entry2.getValue();
            synchronized (f260553o) {
                if (value2.second.first.get() > 0 || value2.second.second.get() > 0) {
                    c.a aVar = new c.a();
                    aVar.f252554b = value2.second.first.get();
                    aVar.f252555c = value2.second.second.get();
                    aVar.f252553a = longValue2;
                    aVar.f252557e = (int) value2.first.uSource;
                    arrayList.add(aVar);
                    value2.second.first.set(0);
                    value2.second.second.set(0);
                }
            }
        }
    }

    public void m(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("VisitorsActivity.VoteHelper", 2, "saveSp key:" + str + " value:" + i3);
        }
        this.f260560c.getPreferences().edit().putInt(str, i3).commit();
    }

    public void o(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f260564g > 2000) {
            this.f260558a.showToast(0, str);
            this.f260564g = currentTimeMillis;
        }
    }

    public void p(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, j3);
        } else {
            ThreadManagerV2.postImmediately(new Runnable(j3) { // from class: com.tencent.mobileqq.profile.vote.VoteHelper.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ long f260579d;

                {
                    this.f260579d = j3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, VoteHelper.this, Long.valueOf(j3));
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
                        QLog.i("VisitorsActivity.VoteHelper", 2, "updateCardProfileFromDb uin:" + this.f260579d);
                    }
                    CardProfile a16 = dc.a(VoteHelper.this.f260560c, this.f260579d, 2);
                    if (a16 == null) {
                        a16 = dc.a(VoteHelper.this.f260560c, this.f260579d, 3);
                    }
                    if (a16 != null) {
                        a16.updateTime(System.currentTimeMillis() / 1000);
                        VoteHelper.this.f260559b.obtainMessage(9, a16).sendToTarget();
                    }
                }
            }, null, true);
        }
    }

    public void q(CardProfile cardProfile) {
        int i3;
        CardProfile cardProfile2;
        CardProfile cardProfile3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) cardProfile);
            return;
        }
        synchronized (f260553o) {
            Pair<CardProfile, AtomicInteger> pair = this.f260570m.get(Long.valueOf(cardProfile.lEctID));
            if (pair == null) {
                i3 = 0;
            } else {
                i3 = pair.second.get();
            }
            int i16 = 0;
            while (true) {
                cardProfile2 = null;
                if (i16 < this.f260558a.f177520d0.size()) {
                    if (this.f260558a.f177520d0.get(i16).lEctID == cardProfile.lEctID) {
                        cardProfile3 = this.f260558a.f177520d0.get(i16);
                        break;
                    }
                    i16++;
                } else {
                    cardProfile3 = null;
                    break;
                }
            }
            if (cardProfile3 != null) {
                long j3 = i3;
                cardProfile3.bTodayVotedCnt = cardProfile.bTodayVotedCnt + j3;
                cardProfile3.bAvailableCnt = cardProfile.bAvailableCnt - j3;
            }
            int i17 = 0;
            while (true) {
                if (i17 < this.f260558a.f177538m0.size()) {
                    CardProfile cardProfile4 = this.f260558a.f177538m0.get(i17);
                    if (cardProfile4 != null && cardProfile4.lEctID == cardProfile.lEctID) {
                        cardProfile2 = this.f260558a.f177538m0.remove(i17);
                        cardProfile2.updateTime(cardProfile.lTime);
                        long j16 = i3;
                        long j17 = cardProfile.bTodayVotedCnt + j16;
                        cardProfile2.bTodayVotedCnt = j17;
                        cardProfile2.bAvailableCnt = cardProfile.bAvailableCnt - j16;
                        cardProfile2.bVoteCnt = (short) j17;
                        break;
                    }
                    i17++;
                } else {
                    break;
                }
            }
            if (cardProfile2 == null) {
                cardProfile2 = cardProfile.m167clone();
                cardProfile2.type = 3;
                long j18 = i3;
                long j19 = cardProfile.bTodayVotedCnt + j18;
                cardProfile2.bTodayVotedCnt = j19;
                cardProfile2.bAvailableCnt = cardProfile.bAvailableCnt - j18;
                cardProfile2.bVoteCnt = (short) j19;
            }
            if (cardProfile2.bTodayVotedCnt > 0 && cardProfile2.bVoteCnt > 0) {
                this.f260558a.f177538m0.add(0, cardProfile2);
            }
        }
        this.f260558a.x3(cardProfile.lEctID);
        this.f260558a.v3();
        if (QLog.isColorLevel()) {
            QLog.i("VisitorsActivity.VoteHelper", 2, "updateCardProfileToList. uin:" + cardProfile.lEctID + " todayCount:" + cardProfile.bTodayVotedCnt);
        }
    }
}
