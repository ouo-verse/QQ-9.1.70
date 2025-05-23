package com.tencent.mobileqq.qzonestatus;

import NS_MOBILE_NEWEST_FEEDS.feed_info;
import NS_MOBILE_NEWEST_FEEDS.newest_feeds_req;
import NS_MOBILE_NEWEST_FEEDS.newest_feeds_rsp;
import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import androidx.collection.LruCache;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.IQZonePadApi;
import common.config.service.QzoneConfig;
import cooperation.qzone.QUA;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    private static volatile a f280132h;

    /* renamed from: a, reason: collision with root package name */
    private VideoAppInterface f280133a;

    /* renamed from: b, reason: collision with root package name */
    private SessionInfo f280134b;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<Activity> f280135c;

    /* renamed from: d, reason: collision with root package name */
    private InterfaceC8492a f280136d;

    /* renamed from: e, reason: collision with root package name */
    private long f280137e;

    /* renamed from: f, reason: collision with root package name */
    private LruCache<String, Boolean> f280138f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f280139g;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qzonestatus.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public interface InterfaceC8492a {
        void a(boolean z16);
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private newest_feeds_req a(long j3, ArrayList<Long> arrayList) {
        return new newest_feeds_req(6, j3, arrayList, 0L, null, QUA.getQUA3(), null);
    }

    private void c(ArrayList<feed_info> arrayList) {
        feed_info feed_infoVar;
        boolean z16 = false;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<feed_info> it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    feed_infoVar = it.next();
                    if (feed_infoVar == null) {
                        RFWLog.i("QZoneVideoContactsFeedManager", RFWLog.USR, "feed info is null");
                    } else if (TextUtils.equals(String.valueOf(feed_infoVar.opuin), String.valueOf(this.f280137e))) {
                        break;
                    }
                } else {
                    feed_infoVar = null;
                    break;
                }
            }
            if (feed_infoVar == null) {
                RFWLog.i("QZoneVideoContactsFeedManager", RFWLog.USR, "no valid feed info in feed list");
                q(false);
                return;
            }
            long j3 = feed_infoVar.time * 1000;
            long currentTimeMillis = System.currentTimeMillis() - j3;
            TimeUnit timeUnit = TimeUnit.DAYS;
            if (currentTimeMillis < timeUnit.toMillis(j())) {
                z16 = true;
            }
            RFWLog.i("QZoneVideoContactsFeedManager", RFWLog.USR, "feed time is " + j3 + " now time is " + System.currentTimeMillis() + " default time gap is " + timeUnit.toMillis(j()));
            q(z16);
            return;
        }
        RFWLog.i("QZoneVideoContactsFeedManager", RFWLog.USR, "feed info list is null or empty");
        q(false);
    }

    public static a h() {
        if (f280132h == null) {
            synchronized (a.class) {
                if (f280132h == null) {
                    f280132h = new a();
                }
            }
        }
        return f280132h;
    }

    private long j() {
        return 30L;
    }

    private boolean m(String str) {
        LruCache<String, Boolean> lruCache = this.f280138f;
        if (lruCache == null || lruCache.get(str) == null) {
            return false;
        }
        return true;
    }

    private boolean o() {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_QAV_SHOW_QZONE_ENTRANCE, 1) == 1) {
            return true;
        }
        return false;
    }

    private boolean p(String str) {
        if (!m(str)) {
            return false;
        }
        return Boolean.TRUE.equals(this.f280138f.get(str));
    }

    private void q(boolean z16) {
        w(z16);
        InterfaceC8492a interfaceC8492a = this.f280136d;
        if (interfaceC8492a == null) {
            return;
        }
        interfaceC8492a.a(z16);
    }

    private void w(boolean z16) {
        if (this.f280138f != null && !TextUtils.isEmpty(String.valueOf(this.f280137e)) && this.f280133a != null) {
            this.f280138f.put(this.f280133a.getCurrentUin() + this.f280137e, Boolean.valueOf(z16));
        }
    }

    public Intent b(Intent intent, newest_feeds_req newest_feeds_reqVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Intent) iPatchRedirector.redirect((short) 8, (Object) this, (Object) intent, (Object) newest_feeds_reqVar);
        }
        if (intent == null) {
            intent = new Intent();
        }
        intent.putExtra("req", newest_feeds_reqVar);
        return intent;
    }

    public void d(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, j3);
            return;
        }
        if (this.f280133a == null) {
            RFWLog.e("QZoneVideoContactsFeedManager", RFWLog.USR, "app runtime is null");
            return;
        }
        this.f280137e = j3;
        String str = this.f280133a.getCurrentUin() + j3;
        if (m(str)) {
            RFWLog.i("QZoneVideoContactsFeedManager", RFWLog.USR, "get result from Lru cache, no need to send request again");
            q(p(str));
        } else if (!o()) {
            RFWLog.i("QZoneVideoContactsFeedManager", RFWLog.USR, "not show entrance according to wns switch");
        } else {
            r(j3);
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        LruCache<String, Boolean> lruCache = this.f280138f;
        if (lruCache == null) {
            return;
        }
        lruCache.evictAll();
    }

    public VideoAppInterface f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (VideoAppInterface) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.f280133a;
    }

    public Activity g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Activity) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        WeakReference<Activity> weakReference = this.f280135c;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public SessionInfo i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (SessionInfo) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.f280134b;
    }

    public void k(newest_feeds_rsp newest_feeds_rspVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) newest_feeds_rspVar);
        } else {
            if (newest_feeds_rspVar == null) {
                return;
            }
            c(newest_feeds_rspVar.vec_feed_info);
        }
    }

    public void l(VideoAppInterface videoAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) videoAppInterface);
            return;
        }
        this.f280133a = videoAppInterface;
        if (this.f280138f == null) {
            this.f280138f = new LruCache<>(5);
        }
    }

    public boolean n(SessionInfo sessionInfo) {
        WeakReference<Activity> weakReference;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) sessionInfo)).booleanValue();
        }
        if (this.f280133a != null && sessionInfo != null && (weakReference = this.f280135c) != null && weakReference.get() != null && (((sessionInfo.E() && sessionInfo.f73035i == 1) || sessionInfo.C()) && !sessionInfo.f73098x2 && !sessionInfo.f73102y2 && !sessionInfo.f73060o0 && !this.f280139g && !((IQZonePadApi) QRoute.api(IQZonePadApi.class)).isPadOrFold())) {
            return true;
        }
        return false;
    }

    public void r(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, j3);
            return;
        }
        NewIntent newIntent = new NewIntent(this.f280133a.getApplication(), b.class);
        ArrayList<Long> arrayList = new ArrayList<>();
        arrayList.add(Long.valueOf(j3));
        b(newIntent, a(this.f280133a.getLongAccountUin(), arrayList));
        this.f280133a.startServlet(newIntent);
    }

    public void s(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
        } else {
            this.f280135c = new WeakReference<>(activity);
        }
    }

    public void t(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
        } else {
            this.f280139g = z16;
        }
    }

    public void u(InterfaceC8492a interfaceC8492a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) interfaceC8492a);
        } else {
            this.f280136d = interfaceC8492a;
        }
    }

    public void v(SessionInfo sessionInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) sessionInfo);
        } else {
            this.f280134b = sessionInfo;
        }
    }
}
