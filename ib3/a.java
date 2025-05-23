package ib3;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wxmini.impl.launcher.WxaInfo;
import com.tencent.mobileqq.wxmini.impl.launcher.q;
import com.tencent.mobileqq.wxmini.impl.report.WxaStartupReportData;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\rB\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0014\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\fH\u0007J\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e0\fH\u0007J\u0014\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e0\fH\u0007J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J4\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000e2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007H\u0002R \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0018R \u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0018R \u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0018R \u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0018\u00a8\u0006\u001f"}, d2 = {"Lib3/a;", "", "Lcom/tencent/mobileqq/wxmini/impl/launcher/WxaInfo;", "wxaInfo", "", "d", "g", "", "wxAppId", "Lib3/a$a;", h.F, "f", "", "a", "", "c", "b", "e", "subActionType", "", "timestamp", "needFlush", "reserves2", "i", "Ljava/util/Map;", "launchedWxaMap", "mWxaInitMap", "mWxaClosedMap", "launchWxaInfoForAdjust", "<init>", "()V", "wxmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f407371a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, WxaRecord> launchedWxaMap = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, Boolean> mWxaInitMap = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, Boolean> mWxaClosedMap = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, WxaRecord> launchWxaInfoForAdjust = new LinkedHashMap();

    a() {
    }

    @JvmStatic
    public static final Map<String, WxaRecord> a() {
        return launchedWxaMap;
    }

    @JvmStatic
    public static final Map<String, Boolean> b() {
        return mWxaClosedMap;
    }

    @JvmStatic
    public static final Map<String, Boolean> c() {
        return mWxaInitMap;
    }

    @JvmStatic
    public static final void d(WxaInfo wxaInfo) {
        Intrinsics.checkNotNullParameter(wxaInfo, "wxaInfo");
        String wxAppId = wxaInfo.getWxAppId();
        if (wxAppId == null) {
            wxAppId = wxaInfo.getCom.tencent.util.QQCustomArkDialogUtil.META_DATA java.lang.String();
        }
        if (!TextUtils.isEmpty(wxAppId)) {
            launchWxaInfoForAdjust.put(wxAppId, new WxaRecord(wxaInfo, System.currentTimeMillis()));
        }
        if (QLog.isColorLevel()) {
            QLog.d("WxaLifecycleReportMgr", 2, "onLaunchInMainProcess wxaInfo:" + wxaInfo);
        }
    }

    @JvmStatic
    public static final void e(WxaInfo wxaInfo) {
        Intrinsics.checkNotNullParameter(wxaInfo, "wxaInfo");
        Map<String, WxaRecord> map = launchedWxaMap;
        TypeIntrinsics.asMutableMap(map).remove(wxaInfo.getWxAppId());
        Map<String, Boolean> map2 = mWxaInitMap;
        TypeIntrinsics.asMutableMap(map2).remove(wxaInfo.getWxAppId());
        Map<String, Boolean> map3 = mWxaClosedMap;
        TypeIntrinsics.asMutableMap(map3).remove(wxaInfo.getWxAppId());
        Map<String, WxaRecord> map4 = launchWxaInfoForAdjust;
        TypeIntrinsics.asMutableMap(map4).remove(wxaInfo.getWxAppId());
    }

    @JvmStatic
    public static final void f(WxaInfo wxaInfo) {
        Intrinsics.checkNotNullParameter(wxaInfo, "wxaInfo");
        WxaRecord wxaRecord = launchedWxaMap.get(wxaInfo.getWxAppId());
        long currentTimeMillis = System.currentTimeMillis();
        if (wxaRecord == null) {
            QLog.e("WxaLifecycleReportMgr", 1, "on wxa close but not find launched record, appId:" + wxaInfo.getWxAppId());
            return;
        }
        WxaStartupReportData startupReportData = wxaInfo.getStartupReportData();
        String startupId = startupReportData != null ? startupReportData.getStartupId() : null;
        WxaStartupReportData startupReportData2 = wxaRecord.getWxaInfo().getStartupReportData();
        if (!Intrinsics.areEqual(startupId, startupReportData2 != null ? startupReportData2.getStartupId() : null)) {
            QLog.d("WxaLifecycleReportMgr", 1, "on wxa close same appId[" + wxaInfo + ".wxAppId] but not same startupId");
            return;
        }
        f407371a.i("wx_hide", wxaRecord.getWxaInfo(), currentTimeMillis, true, String.valueOf(currentTimeMillis - wxaRecord.getTimestamp()));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void g(WxaInfo wxaInfo) {
        boolean z16;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(wxaInfo, "wxaInfo");
        long currentTimeMillis = System.currentTimeMillis();
        WxaRecord wxaRecord = new WxaRecord(wxaInfo, currentTimeMillis);
        String wxAppId = wxaInfo.getWxAppId();
        if (wxAppId != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(wxAppId);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    QLog.e("WxaLifecycleReportMgr", 1, "onWxaLaunch wxaInfo:" + wxaInfo + " wxAppId invaild!");
                    return;
                }
                WxaRecord wxaRecord2 = launchWxaInfoForAdjust.get(wxAppId);
                if (wxaRecord2 != null && System.currentTimeMillis() - wxaRecord2.getTimestamp() < 10000) {
                    QLog.i("WxaLifecycleReportMgr", 1, "onWxaShow find launchForAdjust.wxaInfo:" + wxaRecord2.getWxaInfo());
                    wxaInfo.t(wxaRecord2.getWxaInfo().getScene());
                }
                launchedWxaMap.put(wxAppId, wxaRecord);
                j(f407371a, "wx_show", wxaInfo, currentTimeMillis, false, null, 16, null);
                return;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    @JvmStatic
    public static final WxaRecord h(String wxAppId) {
        Intrinsics.checkNotNullParameter(wxAppId, "wxAppId");
        return launchedWxaMap.get(wxAppId);
    }

    private final void i(String subActionType, WxaInfo wxaInfo, long timestamp, boolean needFlush, String reserves2) {
        QLog.d("WxaLifecycleReportMgr", 4, "reportTo4239 subActionType:" + subActionType + " wxaInfo:" + wxaInfo);
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).reportWxa4239(wxaInfo.getWxAppId(), "page_view", subActionType, String.valueOf(wxaInfo.getScene()), String.valueOf(timestamp), reserves2, needFlush);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lib3/a$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/wxmini/impl/launcher/WxaInfo;", "a", "Lcom/tencent/mobileqq/wxmini/impl/launcher/WxaInfo;", "b", "()Lcom/tencent/mobileqq/wxmini/impl/launcher/WxaInfo;", "wxaInfo", "", "J", "()J", "timestamp", "<init>", "(Lcom/tencent/mobileqq/wxmini/impl/launcher/WxaInfo;J)V", "wxmini_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ib3.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes38.dex */
    public static final /* data */ class WxaRecord {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final WxaInfo wxaInfo;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final long timestamp;

        public WxaRecord(WxaInfo wxaInfo, long j3) {
            Intrinsics.checkNotNullParameter(wxaInfo, "wxaInfo");
            this.wxaInfo = wxaInfo;
            this.timestamp = j3;
        }

        /* renamed from: a, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        /* renamed from: b, reason: from getter */
        public final WxaInfo getWxaInfo() {
            return this.wxaInfo;
        }

        public int hashCode() {
            return (this.wxaInfo.hashCode() * 31) + q.a(this.timestamp);
        }

        public String toString() {
            return "WxaRecord(wxaInfo=" + this.wxaInfo + ", timestamp=" + this.timestamp + ')';
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof WxaRecord)) {
                return false;
            }
            WxaRecord wxaRecord = (WxaRecord) other;
            return Intrinsics.areEqual(this.wxaInfo, wxaRecord.wxaInfo) && this.timestamp == wxaRecord.timestamp;
        }
    }

    static /* synthetic */ void j(a aVar, String str, WxaInfo wxaInfo, long j3, boolean z16, String str2, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            str2 = null;
        }
        aVar.i(str, wxaInfo, j3, z16, str2);
    }
}
