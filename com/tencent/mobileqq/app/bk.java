package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.data.LikeRankingInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.redtouch.IUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes11.dex */
public class bk implements Manager {
    static IPatchRedirector $redirector_;
    long C;
    boolean D;
    boolean E;

    /* renamed from: d, reason: collision with root package name */
    QQAppInterface f195404d;

    /* renamed from: e, reason: collision with root package name */
    String f195405e;

    /* renamed from: f, reason: collision with root package name */
    LikeRankingInfo f195406f;

    /* renamed from: h, reason: collision with root package name */
    List<LikeRankingInfo> f195407h;

    /* renamed from: i, reason: collision with root package name */
    int f195408i;

    /* renamed from: m, reason: collision with root package name */
    boolean f195409m;

    public bk(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.C = -1L;
        this.D = true;
        this.E = true;
        this.f195404d = qQAppInterface;
        this.f195406f = new LikeRankingInfo();
        String currentAccountUin = this.f195404d.getCurrentAccountUin();
        this.f195405e = currentAccountUin;
        if (!TextUtils.isEmpty(currentAccountUin)) {
            this.f195406f.uin = Long.valueOf(this.f195405e).longValue();
        }
        SharedPreferences preferences = this.f195404d.getPreferences();
        this.D = preferences.getBoolean("notify_on_like_ranking_list", true);
        this.f195406f.totalLikeCount = preferences.getInt("like_ranking_list_total_like_count", -1);
        this.f195406f.likeCountOfToday = preferences.getInt("like_ranking_list_today_like_count", -1);
        this.f195406f.rankingNum = preferences.getInt("like_ranking_list_ranking_num", 0);
        this.E = preferences.getBoolean("partake__like_ranking_list", true);
    }

    public LikeRankingInfo a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (LikeRankingInfo) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f195406f;
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.D;
    }

    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        this.E = PreferenceManager.getDefaultSharedPreferences(this.f195404d.getApp()).getBoolean("partake__like_ranking_list" + this.f195405e, true);
        if (QLog.isColorLevel()) {
            QLog.d("LikeRankingListManager", 2, "getPartakeRankingEnabled=" + this.E);
        }
        return this.E;
    }

    public List<LikeRankingInfo> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.f195407h == null) {
            return null;
        }
        return new ArrayList(this.f195407h);
    }

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(serverTimeMillis);
        int i3 = calendar.get(11);
        if (i3 >= 22 && i3 < 24) {
            if (this.C < 0) {
                this.C = this.f195404d.getPreferences().getLong("like_ranking_list_animation_time", 0L);
            }
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(this.C);
            if (calendar2.get(1) != calendar.get(1) || calendar2.get(6) != calendar.get(6)) {
                return true;
            }
        }
        return false;
    }

    public void f(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        if (this.D == z16) {
            return;
        }
        this.D = z16;
        PreferenceManager.getDefaultSharedPreferences(this.f195404d.getApp()).edit().putBoolean("notify_on_like_ranking_list" + this.f195405e, this.D).commit();
    }

    public void g(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
            return;
        }
        if (this.E == z16) {
            return;
        }
        this.E = z16;
        PreferenceManager.getDefaultSharedPreferences(this.f195404d.getApp()).edit().putBoolean("partake__like_ranking_list" + this.f195405e, this.E).commit();
        ((IUtil) QRoute.api(IUtil.class)).onLikeRankListConfigChanged(this.f195404d, z16);
    }

    public void h(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, j3);
            return;
        }
        this.C = j3;
        SharedPreferences.Editor edit = this.f195404d.getPreferences().edit();
        edit.putLong("like_ranking_list_animation_time", j3);
        edit.commit();
    }

    public void i(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        LikeRankingInfo likeRankingInfo = this.f195406f;
        if (i3 != likeRankingInfo.likeCountOfToday || i17 != likeRankingInfo.totalLikeCount || i16 != likeRankingInfo.rankingNum) {
            if (QLog.isColorLevel()) {
                QLog.i("LikeRankingListManager", 2, String.format("updateMyRank todayVoteCount:%d rank:%d total:%d", Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17)));
            }
            LikeRankingInfo likeRankingInfo2 = this.f195406f;
            likeRankingInfo2.totalLikeCount = i17;
            likeRankingInfo2.likeCountOfToday = i3;
            likeRankingInfo2.rankingNum = i16;
            SharedPreferences.Editor edit = this.f195404d.getPreferences().edit();
            edit.putInt("like_ranking_list_total_like_count", i17);
            edit.putInt("like_ranking_list_today_like_count", i3);
            edit.putInt("like_ranking_list_ranking_num", i16);
            edit.commit();
        }
    }

    public void j(List<LikeRankingInfo> list, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, list, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        this.f195407h = new ArrayList(list);
        this.f195408i = i3;
        this.f195409m = z16;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        }
    }
}
