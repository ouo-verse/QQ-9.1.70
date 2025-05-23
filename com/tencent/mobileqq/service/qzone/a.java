package com.tencent.mobileqq.service.qzone;

import com.google.gson.JsonSyntaxException;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.app.QMMKVFile;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qzonehub.api.zipanimate.IZipDrawableLoader;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0002J\u001c\u0010\f\u001a\u00020\u00042\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\nJ\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0006\u0010\u0013\u001a\u00020\u0004R$\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0014R\u001e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0017R\u001e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/service/qzone/a;", "", "", "publishConfStr", "", "f", "likeConfStr", "e", "userConfStr", "g", "", "holidayInfo", h.F, "Lcom/tencent/mobileqq/service/qzone/bean/b;", "b", "Lcom/tencent/mobileqq/service/qzone/bean/c;", "c", "Lcom/tencent/mobileqq/service/qzone/bean/d;", "d", "a", "Ljava/util/Map;", "mHolidayInfoMap", "", "Ljava/util/List;", "mPublishConfList", "mLikeConfList", "Lcom/tencent/mobileqq/service/qzone/bean/d;", "mUserConf", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "mMMKVEntity", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f286399a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Map<String, String> mHolidayInfoMap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static List<com.tencent.mobileqq.service.qzone.bean.c> mPublishConfList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static List<com.tencent.mobileqq.service.qzone.bean.b> mLikeConfList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static com.tencent.mobileqq.service.qzone.bean.d mUserConf;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static MMKVOptionEntity mMMKVEntity;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60317);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
            return;
        }
        f286399a = new a();
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, QMMKVFile.FILE_QZONE_COMMON);
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ,\u2026KVFile.FILE_QZONE_COMMON)");
        mMMKVEntity = from;
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void e(String likeConfStr) {
        RFWLog.d("QZoneHolidayInfoManager", RFWLog.USR, "parseLikeConf  parseLikeConfStr=" + likeConfStr);
        if (likeConfStr != null) {
            try {
                mLikeConfList = cooperation.plugin.patch.d.a(likeConfStr, com.tencent.mobileqq.service.qzone.bean.b.class);
            } catch (JsonSyntaxException e16) {
                RFWLog.e("QZoneHolidayInfoManager", RFWLog.USR, "parseLikeConf  e=" + e16);
            }
        }
        com.tencent.mobileqq.service.qzone.bean.b b16 = b();
        if (b16 != null) {
            ((IZipDrawableLoader) QRoute.api(IZipDrawableLoader.class)).getZipDrawableLoader(BaseApplication.getContext()).setDrawableData(e.f286406a.a(b16.b()), -1, false);
        }
    }

    private final void f(String publishConfStr) {
        RFWLog.d("QZoneHolidayInfoManager", RFWLog.USR, "parsePublishConf  publishConfStr=" + publishConfStr);
        if (publishConfStr != null) {
            try {
                mPublishConfList = cooperation.plugin.patch.d.a(publishConfStr, com.tencent.mobileqq.service.qzone.bean.c.class);
            } catch (JsonSyntaxException e16) {
                RFWLog.e("QZoneHolidayInfoManager", RFWLog.USR, "parsePublishConf  e=" + e16);
            }
            mMMKVEntity.encodeString(((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount() + "mmkv_key_publish_conf", publishConfStr);
        }
    }

    private final void g(String userConfStr) {
        RFWLog.d("QZoneHolidayInfoManager", RFWLog.USR, "parseUserConf  userConfStr=" + userConfStr);
        if (userConfStr != null) {
            try {
                mUserConf = (com.tencent.mobileqq.service.qzone.bean.d) cooperation.plugin.patch.d.b(userConfStr, com.tencent.mobileqq.service.qzone.bean.d.class);
            } catch (Throwable th5) {
                RFWLog.e("QZoneHolidayInfoManager", RFWLog.USR, th5);
            }
        }
    }

    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (!e.f286406a.e()) {
            return;
        }
        f(mMMKVEntity.decodeString(((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount() + "mmkv_key_publish_conf", null));
    }

    @Nullable
    public final com.tencent.mobileqq.service.qzone.bean.b b() {
        List<com.tencent.mobileqq.service.qzone.bean.b> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.service.qzone.bean.b) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (e.f286406a.d() && (list = mLikeConfList) != null) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            RFWLog.d("QZoneHolidayInfoManager", RFWLog.USR, "getCurrentDayHolidayLikeConf  time=" + currentTimeMillis);
            for (com.tencent.mobileqq.service.qzone.bean.b bVar : list) {
                if (currentTimeMillis >= bVar.a() && currentTimeMillis <= bVar.c()) {
                    return bVar;
                }
            }
        }
        return null;
    }

    @Nullable
    public final com.tencent.mobileqq.service.qzone.bean.c c() {
        List<com.tencent.mobileqq.service.qzone.bean.c> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.service.qzone.bean.c) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (e.f286406a.e() && (list = mPublishConfList) != null) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            RFWLog.d("QZoneHolidayInfoManager", RFWLog.USR, "getCurrentDayHolidayPublishConf  time=" + currentTimeMillis);
            for (com.tencent.mobileqq.service.qzone.bean.c cVar : list) {
                if (currentTimeMillis >= cVar.a() && currentTimeMillis <= cVar.b()) {
                    return cVar;
                }
            }
        }
        return null;
    }

    @Nullable
    public final com.tencent.mobileqq.service.qzone.bean.d d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.mobileqq.service.qzone.bean.d) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (!e.f286406a.b()) {
            return null;
        }
        return mUserConf;
    }

    public final void h(@Nullable Map<String, String> holidayInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) holidayInfo);
            return;
        }
        try {
            mHolidayInfoMap = holidayInfo;
            if (holidayInfo != null) {
                a aVar = f286399a;
                aVar.f(holidayInfo.get("publish_conf"));
                aVar.e(holidayInfo.get("like_conf"));
                aVar.g(holidayInfo.get("user_conf"));
            }
            Map<String, String> map = mHolidayInfoMap;
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    RFWLog.d("QZoneHolidayInfoManager", RFWLog.USR, "mHolidayInfoMap  key=" + ((Object) entry.getKey()) + ",value:" + ((Object) entry.getValue()));
                }
            }
            e.f286406a.k();
        } catch (Exception e16) {
            RFWLog.e("QZoneHolidayInfoManager", RFWLog.USR, "updateHolidayInfo  e=" + e16);
        }
    }
}
