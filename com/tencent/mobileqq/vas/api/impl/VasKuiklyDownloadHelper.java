package com.tencent.mobileqq.vas.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyDexResApi;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.ResError;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vas.ReportInfo;
import com.tencent.mobileqq.vas.VasMMKV;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.toggle.UnitedProxy;
import com.tencent.mobileqq.vas.updatesystem.data.VasUpdateData;
import com.tencent.mobileqq.vas.updatesystem.handler.VasUpdateHandler;
import com.tencent.mobileqq.vas.updatesystem.service.IVasUpdateHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.entity.Constants;
import com.tencent.xweb.FileReaderHelper;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 J2\u00020\u0001:\u000225B\u0007\u00a2\u0006\u0004\bH\u0010IJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001e\u0010\t\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002J\u001e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002J$\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u0012\u001a\u00020\u00072\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002J\u0016\u0010\u0015\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002J\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\rH\u0002JP\u0010#\u001a\u00020\u00052\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\f28\u0010\"\u001a4\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00050\u001dH\u0002JJ\u0010,\u001a\u00020\u00052\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\n2\b\b\u0002\u0010+\u001a\u00020\u001aH\u0002JR\u0010/\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\u001a28\u0010\"\u001a4\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0015\u0012\u0013\u0018\u00010\r\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00050\u001dH\u0002J\u0006\u00100\u001a\u00020\u001aR\u0014\u00104\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0014\u00107\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010:\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010<\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u00106R\u0014\u0010>\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u00106R \u0010B\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010?8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010AR2\u0010G\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030Cj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0003`D8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010F\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/VasKuiklyDownloadHelper;", "", "", "Lcom/tencent/mobileqq/vas/api/impl/VasKuiklyDownloadHelper$b;", "centerList", "", "k", "", "delayS", "l", "", "bid", "", "", "list", HippyTKDListViewAdapter.X, "center", "y", "maxCnt", "originList", DomainData.DOMAIN_NAME, "p", "j", "Lcom/tencent/mobileqq/vas/updatesystem/service/IVasUpdateHandler;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "resId", "", "r", "resList", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "code", "msg", "callback", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/vas/VasCommonReportProxy;", "report", "flag", "version", "errMsg", "errCode", "cacheTime", "isSimple", "v", "bundleName", FileReaderHelper.OPEN_FILE_FROM_FORCE, "o", "t", "Lcom/tencent/mobileqq/vas/toggle/UnitedProxy;", "a", "Lcom/tencent/mobileqq/vas/toggle/UnitedProxy;", "preloadCenterToggle", "b", "Z", "isPreloadCenterEnable", "c", "Lcom/tencent/mobileqq/vas/VasCommonReportProxy;", "preloadCenterReport", "d", "mergeRequestToggle", "e", "noForceDownloadToggle", "Ljava/util/concurrent/ConcurrentHashMap;", "f", "Ljava/util/concurrent/ConcurrentHashMap;", "careBid", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "g", "Ljava/util/HashMap;", "updateCenterMap", "<init>", "()V", tl.h.F, "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasKuiklyDownloadHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final UnitedProxy preloadCenterToggle;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean isPreloadCenterEnable;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ReportInfo preloadCenterReport;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final boolean mergeRequestToggle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean noForceDownloadToggle;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Long, Object> careBid;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashMap<Long, UpdateCenter> updateCenterMap;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0010!\n\u0002\b\u0005\b\u0082\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010\u0012\u0006\u0010\u0018\u001a\u00020\n\u0012\"\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0019j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\u001a\u0012\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070\u001f\u0012\b\b\u0002\u0010'\u001a\u00020\u0007\u0012\b\b\u0002\u0010+\u001a\u00020\n\u0012\b\b\u0002\u0010-\u001a\u00020\n\u0012\b\b\u0002\u0010.\u001a\u00020\n\u0012\b\b\u0002\u0010/\u001a\u00020\n\u0012\b\b\u0002\u00101\u001a\u00020\u0007\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0007J\t\u0010\t\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\u0013\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R'\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R3\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0019j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070\u001f8\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010'\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b!\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010+\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b(\u0010\u0017\u001a\u0004\b)\u0010*R\u0017\u0010-\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b,\u0010*R\u0017\u0010.\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b(\u0010*R\u0017\u0010/\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0011\u0010*R\u0017\u00101\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b0\u0010$\u001a\u0004\b\u0016\u0010&R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00020\u0007028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u0010 \u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/VasKuiklyDownloadHelper$b;", "", "", "d", "", "i", "c", "", "g", "toString", "", "hashCode", "other", "equals", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "a", "Ljava/util/ArrayList;", "getUpdateTime", "()Ljava/util/ArrayList;", "updateTime", "b", "I", "bid", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", tl.h.F, "()Ljava/util/HashMap;", "scidMap", "", "Ljava/util/List;", "e", "()Ljava/util/List;", "level0", "Ljava/lang/String;", "getScidPrefix", "()Ljava/lang/String;", "scidPrefix", "f", "getScidRangeStart", "()I", "scidRangeStart", "getScidRangeEnd", "scidRangeEnd", "maxCnt", "autoUpdate", "j", "autoUpdateRecord", "", "k", "scidList", "<init>", "(Ljava/util/ArrayList;ILjava/util/HashMap;Ljava/util/List;Ljava/lang/String;IIIILjava/lang/String;)V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vas.api.impl.VasKuiklyDownloadHelper$b, reason: from toString */
    /* loaded from: classes20.dex */
    public static final /* data */ class UpdateCenter {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final ArrayList<int[]> updateTime;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int bid;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final HashMap<String, String> scidMap;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<String> level0;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String scidPrefix;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final int scidRangeStart;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        private final int scidRangeEnd;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        private final int maxCnt;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        private final int autoUpdate;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String autoUpdateRecord;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<String> scidList;

        public UpdateCenter(@NotNull ArrayList<int[]> updateTime, int i3, @NotNull HashMap<String, String> scidMap, @NotNull List<String> level0, @NotNull String scidPrefix, int i16, int i17, int i18, int i19, @NotNull String autoUpdateRecord) {
            Intrinsics.checkNotNullParameter(updateTime, "updateTime");
            Intrinsics.checkNotNullParameter(scidMap, "scidMap");
            Intrinsics.checkNotNullParameter(level0, "level0");
            Intrinsics.checkNotNullParameter(scidPrefix, "scidPrefix");
            Intrinsics.checkNotNullParameter(autoUpdateRecord, "autoUpdateRecord");
            this.updateTime = updateTime;
            this.bid = i3;
            this.scidMap = scidMap;
            this.level0 = level0;
            this.scidPrefix = scidPrefix;
            this.scidRangeStart = i16;
            this.scidRangeEnd = i17;
            this.maxCnt = i18;
            this.autoUpdate = i19;
            this.autoUpdateRecord = autoUpdateRecord;
            this.scidList = new ArrayList();
            if (i17 <= i16 || i16 > i17) {
                return;
            }
            while (true) {
                this.scidList.add(this.scidPrefix + i16);
                if (i16 != i17) {
                    i16++;
                } else {
                    return;
                }
            }
        }

        private final long d() {
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, 0);
            calendar.set(12, 0);
            calendar.set(13, 0);
            return (System.currentTimeMillis() - calendar.getTime().getTime()) / 60000;
        }

        /* renamed from: a, reason: from getter */
        public final int getAutoUpdate() {
            return this.autoUpdate;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getAutoUpdateRecord() {
            return this.autoUpdateRecord;
        }

        public final long c() {
            try {
                return this.bid;
            } catch (Exception e16) {
                QLog.i("VasKuiklyDownloadHelper", 1, "getBid exception happend", e16);
                return -1L;
            }
        }

        @NotNull
        public final List<String> e() {
            return this.level0;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateCenter)) {
                return false;
            }
            UpdateCenter updateCenter = (UpdateCenter) other;
            if (Intrinsics.areEqual(this.updateTime, updateCenter.updateTime) && this.bid == updateCenter.bid && Intrinsics.areEqual(this.scidMap, updateCenter.scidMap) && Intrinsics.areEqual(this.level0, updateCenter.level0) && Intrinsics.areEqual(this.scidPrefix, updateCenter.scidPrefix) && this.scidRangeStart == updateCenter.scidRangeStart && this.scidRangeEnd == updateCenter.scidRangeEnd && this.maxCnt == updateCenter.maxCnt && this.autoUpdate == updateCenter.autoUpdate && Intrinsics.areEqual(this.autoUpdateRecord, updateCenter.autoUpdateRecord)) {
                return true;
            }
            return false;
        }

        /* renamed from: f, reason: from getter */
        public final int getMaxCnt() {
            return this.maxCnt;
        }

        @NotNull
        public final String g() {
            if (this.scidList.isEmpty()) {
                return "";
            }
            int nextInt = Random.INSTANCE.nextInt(0, Integer.MAX_VALUE);
            List<String> list = this.scidList;
            return list.remove(nextInt % list.size());
        }

        @NotNull
        public final HashMap<String, String> h() {
            return this.scidMap;
        }

        public int hashCode() {
            return (((((((((((((((((this.updateTime.hashCode() * 31) + this.bid) * 31) + this.scidMap.hashCode()) * 31) + this.level0.hashCode()) * 31) + this.scidPrefix.hashCode()) * 31) + this.scidRangeStart) * 31) + this.scidRangeEnd) * 31) + this.maxCnt) * 31) + this.autoUpdate) * 31) + this.autoUpdateRecord.hashCode();
        }

        public final boolean i() {
            Object obj;
            boolean z16;
            long d16 = d();
            QLog.i("VasKuiklyDownloadHelper", 1, "cur minute : " + d16);
            Iterator<T> it = this.updateTime.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    int[] iArr = (int[]) obj;
                    if (iArr[0] < d16 && iArr[1] > d16) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            if (obj != null) {
                return true;
            }
            return false;
        }

        @NotNull
        public String toString() {
            return "UpdateCenter(updateTime=" + this.updateTime + ", bid=" + this.bid + ", scidMap=" + this.scidMap + ", level0=" + this.level0 + ", scidPrefix=" + this.scidPrefix + ", scidRangeStart=" + this.scidRangeStart + ", scidRangeEnd=" + this.scidRangeEnd + ", maxCnt=" + this.maxCnt + ", autoUpdate=" + this.autoUpdate + ", autoUpdateRecord=" + this.autoUpdateRecord + ")";
        }
    }

    public VasKuiklyDownloadHelper() {
        ar.Companion companion = com.tencent.mobileqq.vas.ar.INSTANCE;
        UnitedProxy a16 = companion.a("shouyouye", "2024-03-28", "vas_kuikly_preload_center");
        this.preloadCenterToggle = a16;
        this.isPreloadCenterEnable = a16.isEnable(true);
        this.preloadCenterReport = VasCommonReporter.newReport("kuikly_preload_center");
        this.mergeRequestToggle = companion.b("shouyouye", "2024-04-24", "vas_kuikly_update_merge").isEnable(true);
        this.noForceDownloadToggle = companion.b("shouyouye", "2024-12-26", "vas_kuikly_preload_no_force_download").isEnable(true);
        this.careBid = new ConcurrentHashMap<>();
        this.updateCenterMap = new HashMap<>();
        IVasUpdateHandler q16 = q();
        if (q16 != null) {
            q16.addHandleQuickUpdateInterceptor(new IVasUpdateHandler.a() { // from class: com.tencent.mobileqq.vas.api.impl.VasKuiklyDownloadHelper.1
                @Override // com.tencent.mobileqq.vas.updatesystem.service.IVasUpdateHandler.a
                public boolean a(int type, boolean isSuccess, @Nullable VasUpdateData.QuickUpdateRsp rsp) {
                    boolean z16;
                    HashMap<String, String> h16;
                    Set<Map.Entry<String, String>> entrySet;
                    Object obj;
                    long j3;
                    if (rsp == null) {
                        return false;
                    }
                    QLog.i("VasKuiklyDownloadHelper", 1, "handleQuickUpdate by interceptor");
                    if (!(rsp instanceof VasUpdateData.GetUrlRsp)) {
                        return false;
                    }
                    VasUpdateData.GetUrlRsp getUrlRsp = (VasUpdateData.GetUrlRsp) rsp;
                    List<VasUpdateData.UpdateInfo> list = getUrlRsp.updateList;
                    Intrinsics.checkNotNullExpressionValue(list, "rsp.updateList");
                    List<VasUpdateData.UpdateInfo> list2 = list;
                    VasKuiklyDownloadHelper vasKuiklyDownloadHelper = VasKuiklyDownloadHelper.this;
                    if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                        Iterator<T> it = list2.iterator();
                        while (it.hasNext()) {
                            if (!vasKuiklyDownloadHelper.careBid.containsKey(Long.valueOf(((VasUpdateData.UpdateInfo) it.next()).bid))) {
                                z16 = false;
                                break;
                            }
                        }
                    }
                    z16 = true;
                    if (!z16) {
                        return false;
                    }
                    RequestWrapper b16 = i.f308607a.b(getUrlRsp.cookie);
                    long j16 = 0;
                    if (isSuccess && getUrlRsp.ret == 0) {
                        ArrayList<String> arrayList = new ArrayList();
                        List<VasUpdateData.UpdateInfo> list3 = getUrlRsp.updateList;
                        Intrinsics.checkNotNullExpressionValue(list3, "rsp.updateList");
                        VasKuiklyDownloadHelper vasKuiklyDownloadHelper2 = VasKuiklyDownloadHelper.this;
                        for (VasUpdateData.UpdateInfo updateInfo : list3) {
                            UpdateCenter updateCenter = (UpdateCenter) vasKuiklyDownloadHelper2.updateCenterMap.get(Long.valueOf(updateInfo.bid));
                            if (updateCenter != null && (h16 = updateCenter.h()) != null && (entrySet = h16.entrySet()) != null) {
                                Iterator<T> it5 = entrySet.iterator();
                                while (true) {
                                    if (it5.hasNext()) {
                                        obj = it5.next();
                                        if (Intrinsics.areEqual(((Map.Entry) obj).getValue(), updateInfo.scid)) {
                                            break;
                                        }
                                    } else {
                                        obj = null;
                                        break;
                                    }
                                }
                                Map.Entry entry = (Map.Entry) obj;
                                if (entry != null) {
                                    ReportInfo num2 = vasKuiklyDownloadHelper2.preloadCenterReport.setValue1((String) entry.getKey()).setNum1(updateInfo.bid).setNum2(updateInfo.code);
                                    long currentTimeMillis = System.currentTimeMillis();
                                    if (b16 != null) {
                                        j3 = b16.getCreateTime();
                                    } else {
                                        j3 = 0;
                                    }
                                    num2.setNum3(currentTimeMillis - j3).report(true);
                                    if (updateInfo.code == 0) {
                                        Object key = entry.getKey();
                                        Intrinsics.checkNotNullExpressionValue(key, "it.key");
                                        arrayList.add(key);
                                    } else {
                                        QLog.i("VasKuiklyDownloadHelper", 1, "");
                                    }
                                }
                            }
                        }
                        if (!VasKuiklyDownloadHelper.this.mergeRequestToggle) {
                            VasKuiklyDownloadHelper vasKuiklyDownloadHelper3 = VasKuiklyDownloadHelper.this;
                            for (final String str : arrayList) {
                                vasKuiklyDownloadHelper3.o(str, true, new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.vas.api.impl.VasKuiklyDownloadHelper$1$handle$3$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str2) {
                                        invoke(num.intValue(), str2);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(int i3, @Nullable String str2) {
                                        QLog.i("VasKuiklyDownloadHelper", 1, "download kuikly res(" + str + ") by cdn controller, code:" + i3 + " msg:" + str2);
                                    }
                                });
                            }
                        } else if (VasKuiklyDownloadHelper.this.noForceDownloadToggle) {
                            VasKuiklyDownloadHelper vasKuiklyDownloadHelper4 = VasKuiklyDownloadHelper.this;
                            for (final String str2 : arrayList) {
                                vasKuiklyDownloadHelper4.o(str2, false, new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.vas.api.impl.VasKuiklyDownloadHelper$1$handle$4$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str3) {
                                        invoke(num.intValue(), str3);
                                        return Unit.INSTANCE;
                                    }

                                    public final void invoke(int i3, @Nullable String str3) {
                                        QLog.i("VasKuiklyDownloadHelper", 1, "download kuikly res(" + str2 + ") by cdn controller, code:" + i3 + " msg:" + str3);
                                    }
                                });
                            }
                        } else {
                            StringBuilder sb5 = new StringBuilder();
                            Iterator it6 = arrayList.iterator();
                            while (it6.hasNext()) {
                                sb5.append((String) it6.next());
                                sb5.append(",");
                            }
                            QLog.i("VasKuiklyDownloadHelper", 1, "mergePreloadKuiklyRes list-> " + ((Object) sb5));
                            VasKuiklyDownloadHelper.this.s(arrayList, new Function2<Integer, String, Unit>() { // from class: com.tencent.mobileqq.vas.api.impl.VasKuiklyDownloadHelper$1$handle$6
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str3) {
                                    invoke(num.intValue(), str3);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(int i3, @Nullable String str3) {
                                    QLog.i("VasKuiklyDownloadHelper", 1, "mergePreloadKuiklyRes download kuikly res by cdn controller, code:" + i3 + " msg:" + str3);
                                }
                            });
                        }
                    } else {
                        VasKuiklyDownloadHelper vasKuiklyDownloadHelper5 = VasKuiklyDownloadHelper.this;
                        ReportInfo reportInfo = vasKuiklyDownloadHelper5.preloadCenterReport;
                        int i3 = (int) getUrlRsp.ret;
                        long currentTimeMillis2 = System.currentTimeMillis();
                        if (b16 != null) {
                            j16 = b16.getCreateTime();
                        }
                        VasKuiklyDownloadHelper.w(vasKuiklyDownloadHelper5, reportInfo, "getUrlReq", "", "", -1, i3, currentTimeMillis2 - j16, false, 128, null);
                    }
                    return true;
                }
            });
        }
    }

    private final List<UpdateCenter> j() {
        int i3;
        int i16;
        ArrayList arrayList = new ArrayList();
        JSONObject json = this.preloadCenterToggle.getJson();
        Iterator keys = json.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "keys");
        while (keys.hasNext()) {
            JSONObject optJSONObject = json.optJSONObject((String) keys.next());
            if (optJSONObject != null) {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("scid");
                int optInt = optJSONObject.optInt("bid", 0);
                if (optJSONObject2 != null && optJSONObject2.length() > 0 && optInt > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    JSONArray optJSONArray = optJSONObject.optJSONArray("update_time");
                    if (optJSONArray != null) {
                        Intrinsics.checkNotNullExpressionValue(optJSONArray, "optJSONArray(\"update_time\")");
                        int length = optJSONArray.length();
                        for (int i17 = 0; i17 < length; i17++) {
                            JSONArray optJSONArray2 = optJSONArray.optJSONArray(i17);
                            if (optJSONArray2.length() == 2) {
                                arrayList2.add(new int[]{optJSONArray2.optInt(0), optJSONArray2.optInt(1)});
                            }
                        }
                    }
                    HashMap hashMap = new HashMap();
                    Iterator keys2 = optJSONObject2.keys();
                    Intrinsics.checkNotNullExpressionValue(keys2, "scidMap.keys()");
                    while (keys2.hasNext()) {
                        String scidKey = (String) keys2.next();
                        Intrinsics.checkNotNullExpressionValue(scidKey, "scidKey");
                        hashMap.put(scidKey, "");
                    }
                    int optInt2 = optJSONObject.optInt("max_cnt", 0);
                    JSONArray optJSONArray3 = optJSONObject.optJSONArray("scid_range");
                    if (optJSONArray3 == null || optJSONArray3.length() < 2) {
                        QLog.i("VasKuiklyDownloadHelper", 1, "scidRangArr is null");
                    }
                    if (optJSONArray3 != null) {
                        i3 = optJSONArray3.optInt(0);
                    } else {
                        i3 = 0;
                    }
                    if (optJSONArray3 != null) {
                        i16 = optJSONArray3.optInt(1);
                    } else {
                        i16 = 1;
                    }
                    String prefix = optJSONObject.optString("scid_prefix");
                    JSONArray optJSONArray4 = optJSONObject.optJSONArray("level_0");
                    ArrayList arrayList3 = new ArrayList();
                    if (optJSONArray4 != null) {
                        int length2 = optJSONArray4.length();
                        for (int i18 = 0; i18 < length2; i18++) {
                            arrayList3.add(optJSONArray4.optString(i18));
                        }
                    }
                    int optInt3 = optJSONObject.optInt(WadlProxyConsts.VIA_AUTO_UPDATE, 0);
                    String vasKuiklyRecord = optJSONObject.optString("auto_update_record", "");
                    Intrinsics.checkNotNullExpressionValue(prefix, "prefix");
                    Intrinsics.checkNotNullExpressionValue(vasKuiklyRecord, "vasKuiklyRecord");
                    arrayList.add(new UpdateCenter(arrayList2, optInt, hashMap, arrayList3, prefix, i3, i16, optInt2, optInt3, vasKuiklyRecord));
                }
            }
        }
        return arrayList;
    }

    private final void k(List<UpdateCenter> centerList) {
        int collectionSizeOrDefault;
        for (UpdateCenter updateCenter : centerList) {
            try {
                this.updateCenterMap.put(Long.valueOf(updateCenter.c()), updateCenter);
                if (updateCenter.i()) {
                    List<String> e16 = updateCenter.e();
                    y(updateCenter, e16);
                    List<String> list = e16;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        String str = updateCenter.h().get((String) it.next());
                        if (str == null) {
                            str = "";
                        }
                        arrayList.add(str);
                    }
                    x(updateCenter.c(), arrayList);
                }
            } catch (Exception e17) {
                QLog.e("VasKuiklyDownloadHelper", 1, "executeLevel0Task fetch exception", e17);
            }
        }
    }

    private final void l(final List<UpdateCenter> centerList, int delayS) {
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.vas.api.impl.al
            @Override // java.lang.Runnable
            public final void run() {
                VasKuiklyDownloadHelper.m(centerList, this);
            }
        }, 16, null, false, 1000 * delayS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void m(List centerList, VasKuiklyDownloadHelper this$0) {
        int collectionSizeOrDefault;
        String str;
        List<String> split$default;
        Intrinsics.checkNotNullParameter(centerList, "$centerList");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (centerList.size() == 0) {
            return;
        }
        Iterator it = centerList.iterator();
        while (it.hasNext()) {
            UpdateCenter updateCenter = (UpdateCenter) it.next();
            try {
                if (updateCenter.i()) {
                    this$0.updateCenterMap.put(Long.valueOf(updateCenter.c()), updateCenter);
                    if (updateCenter.getMaxCnt() == 0) {
                        QLog.i("VasKuiklyDownloadHelper", 1, "maxCnt is 0");
                    } else {
                        Set<String> keySet = updateCenter.h().keySet();
                        HashSet hashSet = new HashSet();
                        hashSet.addAll(keySet);
                        if (updateCenter.getAutoUpdate() == 1 && !TextUtils.isEmpty(updateCenter.getAutoUpdateRecord())) {
                            String decodeString = VasMMKV.INSTANCE.getCommon().decodeString(updateCenter.getAutoUpdateRecord(), "");
                            if (decodeString == null) {
                                str = "";
                            } else {
                                str = decodeString;
                            }
                            if (!TextUtils.isEmpty(str)) {
                                QLog.i("VasKuiklyDownloadHelper", 1, "\u63d2\u5165\u6253\u5f00\u8fc7\u7684\u9875\u9762: " + str);
                                split$default = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{","}, false, 0, 6, (Object) null);
                                for (String str2 : split$default) {
                                    if (!TextUtils.isEmpty(str2)) {
                                        hashSet.add(str2);
                                    }
                                }
                            }
                        }
                        ArrayList arrayList = new ArrayList();
                        for (Object obj : hashSet) {
                            if (this$0.r((String) obj)) {
                                arrayList.add(obj);
                            }
                        }
                        List arrayList2 = new ArrayList();
                        for (Object obj2 : arrayList) {
                            if (!updateCenter.e().contains((String) obj2)) {
                                arrayList2.add(obj2);
                            }
                        }
                        if (arrayList2.isEmpty()) {
                            QLog.i("VasKuiklyDownloadHelper", 1, "list is empty");
                            arrayList2 = null;
                        }
                        if (arrayList2 != null) {
                            QLog.i("VasKuiklyDownloadHelper", 1, "old requestList: " + this$0.p(arrayList2));
                            if (arrayList2.size() > updateCenter.getMaxCnt()) {
                                arrayList2 = this$0.n(updateCenter.getMaxCnt(), arrayList2);
                            }
                            QLog.i("VasKuiklyDownloadHelper", 1, "filter requestList: " + this$0.p(arrayList2));
                            if (arrayList2 != null) {
                                this$0.y(updateCenter, arrayList2);
                                List list = arrayList2;
                                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                                ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
                                Iterator it5 = list.iterator();
                                while (it5.hasNext()) {
                                    String str3 = updateCenter.h().get((String) it5.next());
                                    if (str3 == null) {
                                        str3 = "";
                                    }
                                    arrayList3.add(str3);
                                }
                                this$0.x(updateCenter.c(), arrayList3);
                            }
                        }
                    }
                }
            } catch (Exception e16) {
                QLog.e("VasKuiklyDownloadHelper", 1, "executeNormalTask fetch exception", e16);
            }
        }
    }

    private final List<String> n(int maxCnt, List<String> originList) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : originList) {
            if (!TextUtils.isEmpty((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        while (arrayList2.size() > maxCnt) {
            arrayList2.remove(Random.INSTANCE.nextInt(0, Integer.MAX_VALUE) % arrayList2.size());
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(String bundleName, boolean force, final Function2<? super Integer, ? super String, Unit> callback) {
        ((IQQKuiklyDexResApi) QRoute.api(IQQKuiklyDexResApi.class)).updateDexRes(bundleName, force, new Function1<ResError, Unit>() { // from class: com.tencent.mobileqq.vas.api.impl.VasKuiklyDownloadHelper$forcePreloadKuiklyRes$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ResError resError) {
                invoke2(resError);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ResError resError) {
                Intrinsics.checkNotNullParameter(resError, "resError");
                QLog.i("VasKuiklyDownloadHelper", 1, "error: " + resError.getCode() + " " + resError.getMessage());
                callback.invoke(Integer.valueOf(resError.getCode()), resError.getMessage());
            }
        });
    }

    private final String p(List<String> list) {
        Iterator<T> it = list.iterator();
        String str = "";
        while (it.hasNext()) {
            str = ((Object) str) + ((String) it.next()) + ",";
        }
        return str;
    }

    private final IVasUpdateHandler q() {
        AppInterface appInterface;
        BusinessHandler businessHandler;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            businessHandler = appInterface.getBusinessHandler(VasUpdateHandler.f311201h);
        } else {
            businessHandler = null;
        }
        if (!(businessHandler instanceof IVasUpdateHandler)) {
            return null;
        }
        return (IVasUpdateHandler) businessHandler;
    }

    private final boolean r(String resId) {
        long fetchedResVersion = ((IQQKuiklyDexResApi) QRoute.api(IQQKuiklyDexResApi.class)).getFetchedResVersion(resId);
        long resVersion = ((IQQKuiklyDexResApi) QRoute.api(IQQKuiklyDexResApi.class)).getDexResInfo(resId).getResVersion();
        QLog.i("VasKuiklyDownloadHelper", 1, "isNeedUpdate resId: " + resId + " remoteV: " + fetchedResVersion + " local: " + resVersion);
        if (resVersion < fetchedResVersion) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(List<String> resList, final Function2<? super Integer, ? super String, Unit> callback) {
        ((IQQKuiklyDexResApi) QRoute.api(IQQKuiklyDexResApi.class)).updateMultiDexRes(resList, new Function1<ResError, Unit>() { // from class: com.tencent.mobileqq.vas.api.impl.VasKuiklyDownloadHelper$mergePreloadKuiklyRes$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ResError resError) {
                invoke2(resError);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ResError resError) {
                Intrinsics.checkNotNullParameter(resError, "resError");
                QLog.i("VasKuiklyDownloadHelper", 1, "mergePreloadKuiklyRes error: " + resError.getCode() + " " + resError.getMessage());
                callback.invoke(Integer.valueOf(resError.getCode()), resError.getMessage());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(VasKuiklyDownloadHelper this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<UpdateCenter> j3 = this$0.j();
        this$0.k(j3);
        this$0.l(j3, i3);
    }

    private final void v(ReportInfo report, String flag, String version, String errMsg, int bid, int errCode, long cacheTime, boolean isSimple) {
        report.setValue1(flag).setValue2(version).setValue3(errMsg).setNum1(bid).setNum2(errCode).setNum3(System.currentTimeMillis() - cacheTime).report(isSimple);
    }

    static /* synthetic */ void w(VasKuiklyDownloadHelper vasKuiklyDownloadHelper, ReportInfo reportInfo, String str, String str2, String str3, int i3, int i16, long j3, boolean z16, int i17, Object obj) {
        boolean z17;
        if ((i17 & 128) != 0) {
            z17 = true;
        } else {
            z17 = z16;
        }
        vasKuiklyDownloadHelper.v(reportInfo, str, str2, str3, i3, i16, j3, z17);
    }

    private final void x(long bid, List<String> list) {
        this.careBid.put(Long.valueOf(bid), 1);
        RequestWrapper a16 = i.f308607a.a(bid, list, Constants.UpdateFrom.SILENT_UPDATE);
        QLog.i("VasKuiklyDownloadHelper", 1, "try load kuikly new res: " + a16);
        IVasUpdateHandler q16 = q();
        if (q16 != null) {
            q16.requestQuickUpdate("GetUrlReq", a16.getContent());
        }
    }

    private final void y(UpdateCenter center, List<String> list) {
        for (String str : list) {
            String g16 = center.g();
            if (!TextUtils.isEmpty(g16)) {
                center.h().put(str, g16);
            }
        }
    }

    public final boolean t() {
        boolean z16 = this.isPreloadCenterEnable;
        QLog.i("VasKuiklyDownloadHelper", 1, "isPreloadEnable:" + z16);
        if (!z16) {
            return false;
        }
        final int optInt = this.preloadCenterToggle.getJson().optInt("auto_delay", 3);
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.vas.api.impl.ak
            @Override // java.lang.Runnable
            public final void run() {
                VasKuiklyDownloadHelper.u(VasKuiklyDownloadHelper.this, optInt);
            }
        }, 16, null, false, 3000L);
        return true;
    }
}
