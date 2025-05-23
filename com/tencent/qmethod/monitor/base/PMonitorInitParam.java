package com.tencent.qmethod.monitor.base;

import android.app.Application;
import androidx.annotation.IntRange;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qmethod.monitor.base.defaultImpl.e;
import com.tencent.qmethod.pandoraex.api.f;
import com.tencent.qmethod.pandoraex.api.g;
import com.tencent.qmethod.pandoraex.api.i;
import com.tencent.qmethod.pandoraex.api.j;
import com.tencent.qmethod.pandoraex.api.l;
import com.tencent.qmethod.pandoraex.api.n;
import com.tencent.qmethod.pandoraex.api.o;
import com.tencent.qmethod.pandoraex.monitor.AutoStartMonitor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u0000 K2\u00020\u0001:\u0003\t\u0013qB\u00f9\u0001\u0012\u0006\u0010\u001d\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010$\u001a\u00020\u001f\u0012\b\b\u0002\u0010,\u001a\u00020%\u0012\b\b\u0002\u00103\u001a\u00020-\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u000104\u0012\b\b\u0002\u0010;\u001a\u00020\u0007\u0012\b\b\u0002\u0010@\u001a\u00020\u0004\u0012\b\b\u0002\u0010A\u001a\u00020\u0007\u0012\b\b\u0002\u0010D\u001a\u00020\u0007\u0012\n\b\u0002\u0010I\u001a\u0004\u0018\u00010E\u0012\b\b\u0002\u0010L\u001a\u00020\u0007\u0012\b\b\u0002\u0010O\u001a\u00020\u0007\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010P\u0012\b\b\u0002\u0010U\u001a\u00020\u0007\u0012\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010V\u0012\n\b\u0002\u0010`\u001a\u0004\u0018\u00010_\u0012\b\b\u0002\u0010\\\u001a\u00020\u0007\u0012\n\b\u0002\u0010]\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010d\u001a\u0004\u0018\u00010c\u0012\n\b\u0002\u0010h\u001a\u0004\u0018\u00010g\u0012\n\b\u0002\u0010l\u001a\u0004\u0018\u00010k\u0012\b\b\u0002\u0010^\u001a\u00020\u0007\u00a2\u0006\u0004\bo\u0010pJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR>\u0010\u0019\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00020\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0002`\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001d\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0013\u0010\u001cR\u0017\u0010\u001e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u001b\u001a\u0004\b\u001a\u0010\u001cR\u0017\u0010$\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\"\u0010,\u001a\u00020%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u00103\u001a\u00020-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b&\u00100\"\u0004\b1\u00102R\u0019\u00108\u001a\u0004\u0018\u0001048\u0006\u00a2\u0006\f\n\u0004\b\"\u00105\u001a\u0004\b6\u00107R\u0017\u0010;\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b9\u0010\n\u001a\u0004\b:\u0010\fR\u0017\u0010@\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u0017\u0010A\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b(\u0010\n\u001a\u0004\b9\u0010\fR\u0017\u0010D\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\bB\u0010\n\u001a\u0004\bC\u0010\fR\u0019\u0010I\u001a\u0004\u0018\u00010E8\u0006\u00a2\u0006\f\n\u0004\bF\u0010G\u001a\u0004\b \u0010HR\u0017\u0010L\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\bJ\u0010\n\u001a\u0004\bK\u0010\fR\u0017\u0010O\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\bM\u0010\n\u001a\u0004\bN\u0010\fR\u0019\u0010T\u001a\u0004\u0018\u00010P8\u0006\u00a2\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\b.\u0010SR\u0017\u0010U\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b6\u0010\n\u001a\u0004\bJ\u0010\fR\u0019\u0010Z\u001a\u0004\u0018\u00010V8\u0006\u00a2\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bQ\u0010YR\u0017\u0010\\\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b:\u0010\n\u001a\u0004\b[\u0010\fR\u0019\u0010]\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b>\u0010\u001b\u001a\u0004\bB\u0010\u001cR\u0017\u0010^\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\bM\u0010\fR\u0019\u0010`\u001a\u0004\u0018\u00010_8\u0006\u00a2\u0006\f\n\u0004\b`\u0010a\u001a\u0004\bW\u0010bR\u0019\u0010d\u001a\u0004\u0018\u00010c8\u0006\u00a2\u0006\f\n\u0004\bd\u0010e\u001a\u0004\b<\u0010fR\u0019\u0010h\u001a\u0004\u0018\u00010g8\u0006\u00a2\u0006\f\n\u0004\bh\u0010i\u001a\u0004\bF\u0010jR\u0019\u0010l\u001a\u0004\u0018\u00010k8\u0006\u00a2\u0006\f\n\u0004\bl\u0010m\u001a\u0004\b\t\u0010n\u00a8\u0006r"}, d2 = {"Lcom/tencent/qmethod/monitor/base/PMonitorInitParam;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "u", "()Z", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Z)V", "isDelay", "Ljava/util/HashMap;", "Lcom/tencent/qmethod/monitor/base/PMonitorInitParam$Property;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "d", "()Ljava/util/HashMap;", "setAppProperty", "(Ljava/util/HashMap;)V", "appProperty", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "appId", com.heytap.mcssdk.a.a.f36102l, "Landroid/app/Application;", "e", "Landroid/app/Application;", h.F, "()Landroid/app/Application;", "context", "Lcom/tencent/qmethod/pandoraex/api/j;", "f", "Lcom/tencent/qmethod/pandoraex/api/j;", "k", "()Lcom/tencent/qmethod/pandoraex/api/j;", "setLogger", "(Lcom/tencent/qmethod/pandoraex/api/j;)V", "logger", "Lcom/tencent/qmethod/pandoraex/api/f;", "g", "Lcom/tencent/qmethod/pandoraex/api/f;", "()Lcom/tencent/qmethod/pandoraex/api/f;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Lcom/tencent/qmethod/pandoraex/api/f;)V", "appStateManager", "Lcom/tencent/qmethod/pandoraex/api/o;", "Lcom/tencent/qmethod/pandoraex/api/o;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/qmethod/pandoraex/api/o;", "threadExecutor", "i", ReportConstant.COSTREPORT_PREFIX, "useMMKVStrategy", "j", "I", "t", "()I", "uvReportSamplingRate", "debug", "l", "w", "isOpenCheckPermission", "Lcom/tencent/qmethod/pandoraex/api/n;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qmethod/pandoraex/api/n;", "()Lcom/tencent/qmethod/pandoraex/api/n;", "appReporter", DomainData.DOMAIN_NAME, "v", "isOpenApiInvokeAnalyse", "o", "y", "isOpenSilenceHook", "Lcom/tencent/qmethod/pandoraex/monitor/AutoStartMonitor$ComponentStartListener;", "p", "Lcom/tencent/qmethod/pandoraex/monitor/AutoStartMonitor$ComponentStartListener;", "()Lcom/tencent/qmethod/pandoraex/monitor/AutoStartMonitor$ComponentStartListener;", "autoStartListener", "resourceMonitor", "Lcom/tencent/qmethod/pandoraex/api/g;", "r", "Lcom/tencent/qmethod/pandoraex/api/g;", "()Lcom/tencent/qmethod/pandoraex/api/g;", QQPermissionConstants.Permission.STORAGE_GROUP, HippyTKDListViewAdapter.X, "isOpenNetworkCapture", "mmkvRootDir", "shouldClearCacheOnDeviceClone", "Lcom/tencent/qmethod/monitor/base/b;", BuglyMonitorName.TRAFFIC, "Lcom/tencent/qmethod/monitor/base/b;", "()Lcom/tencent/qmethod/monitor/base/b;", "Lcom/tencent/qmethod/pandoraex/api/i;", "libLoader", "Lcom/tencent/qmethod/pandoraex/api/i;", "()Lcom/tencent/qmethod/pandoraex/api/i;", "Lcom/tencent/qmethod/pandoraex/api/l;", "rJniHook", "Lcom/tencent/qmethod/pandoraex/api/l;", "()Lcom/tencent/qmethod/pandoraex/api/l;", "Lcom/tencent/qmethod/monitor/ext/auto/b;", "activityJumpInterrupt", "Lcom/tencent/qmethod/monitor/ext/auto/b;", "()Lcom/tencent/qmethod/monitor/ext/auto/b;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/app/Application;Lcom/tencent/qmethod/pandoraex/api/j;Lcom/tencent/qmethod/pandoraex/api/f;Lcom/tencent/qmethod/pandoraex/api/o;ZIZZLcom/tencent/qmethod/pandoraex/api/n;ZZLcom/tencent/qmethod/pandoraex/monitor/AutoStartMonitor$ComponentStartListener;ZLcom/tencent/qmethod/pandoraex/api/g;Lcom/tencent/qmethod/monitor/base/b;ZLjava/lang/String;Lcom/tencent/qmethod/pandoraex/api/i;Lcom/tencent/qmethod/pandoraex/api/l;Lcom/tencent/qmethod/monitor/ext/auto/b;Z)V", "Property", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final /* data */ class PMonitorInitParam {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isDelay;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private HashMap<Property, String> appProperty;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String appId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String appKey;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Application context;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private j logger;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private f appStateManager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final o threadExecutor;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean useMMKVStrategy;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private final int uvReportSamplingRate;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean debug;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isOpenCheckPermission;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final n appReporter;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isOpenApiInvokeAnalyse;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isOpenSilenceHook;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final AutoStartMonitor.ComponentStartListener autoStartListener;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean resourceMonitor;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final g storage;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isOpenNetworkCapture;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String mmkvRootDir;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean shouldClearCacheOnDeviceClone;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qmethod/monitor/base/PMonitorInitParam$Property;", "", "(Ljava/lang/String;I)V", "APP_USER_ID", "APP_UNIQUE_ID", IGuildMainFrameApi.APP_VERSION, "APP_RDM_UUID", "SYS_MODEL", "SYS_BRAND", "SYS_VERSION_INT", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes22.dex */
    public enum Property {
        APP_USER_ID,
        APP_UNIQUE_ID,
        APP_VERSION,
        APP_RDM_UUID,
        SYS_MODEL,
        SYS_BRAND,
        SYS_VERSION_INT
    }

    @Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010C\u001a\u00020\"\u0012\u0006\u0010E\u001a\u00020\"\u0012\u0006\u0010I\u001a\u00020F\u00a2\u0006\u0004\bJ\u0010KJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0007J\u0010\u0010\n\u001a\u00020\u00002\b\b\u0001\u0010\u0005\u001a\u00020\tJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u0011\u001a\u00020\u0010R\u0016\u0010\u0013\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0012R\u0016\u0010\u001d\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001cR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001eR2\u0010&\u001a\u001e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"0 j\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\"`#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R$\u0010+\u001a\u0012\u0012\u0004\u0012\u00020!0'j\b\u0012\u0004\u0012\u00020!`(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010-\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010\u0012R\u0016\u0010/\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010\u0012R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010\u0012R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010\u0012R\u0016\u0010<\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010\u0012R\u0018\u0010?\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010A\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010\u0012R\u0014\u0010C\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010>R\u0014\u0010E\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010>R\u0014\u0010I\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010H\u00a8\u0006L"}, d2 = {"Lcom/tencent/qmethod/monitor/base/PMonitorInitParam$a;", "", "", "b", "Lcom/tencent/qmethod/pandoraex/api/j;", "value", "e", "Lcom/tencent/qmethod/pandoraex/api/f;", "c", "", "g", "Lcom/tencent/qmethod/pandoraex/api/o;", "f", "", "isOpenApiInvokeAnalyse", "d", "Lcom/tencent/qmethod/monitor/base/PMonitorInitParam;", "a", "Z", "isOpenNetworkCapture", "Lcom/tencent/qmethod/pandoraex/api/j;", "logger", "Lcom/tencent/qmethod/pandoraex/api/f;", "appStateManager", "Lcom/tencent/qmethod/pandoraex/api/g;", "Lcom/tencent/qmethod/pandoraex/api/g;", QQPermissionConstants.Permission.STORAGE_GROUP, "useMMKVStrategy", "I", "uvReportSamplingRate", "Lcom/tencent/qmethod/pandoraex/api/o;", MosaicConstants$JsProperty.PROP_THREAD, "Ljava/util/HashMap;", "Lcom/tencent/qmethod/monitor/base/PMonitorInitParam$Property;", "", "Lkotlin/collections/HashMap;", h.F, "Ljava/util/HashMap;", "propertyMap", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "i", "Ljava/util/ArrayList;", "necessaryProperty", "j", "debug", "k", "isOpenCheckPermission", "Lcom/tencent/qmethod/pandoraex/api/n;", "l", "Lcom/tencent/qmethod/pandoraex/api/n;", "appReporter", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qmethod/pandoraex/monitor/AutoStartMonitor$ComponentStartListener;", DomainData.DOMAIN_NAME, "Lcom/tencent/qmethod/pandoraex/monitor/AutoStartMonitor$ComponentStartListener;", "autoStartListener", "o", "resourceMonitor", "p", "isOpenSilenceHook", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ljava/lang/String;", "mmkvRootDir", "r", "shouldClearCacheOnDeviceClone", ReportConstant.COSTREPORT_PREFIX, "appId", "t", com.heytap.mcssdk.a.a.f36102l, "Landroid/app/Application;", "u", "Landroid/app/Application;", "application", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/app/Application;)V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes22.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private boolean isOpenNetworkCapture;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private j logger;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private f appStateManager;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private g storage;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private boolean useMMKVStrategy;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private int uvReportSamplingRate;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        private o thread;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        private HashMap<Property, String> propertyMap;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private final ArrayList<Property> necessaryProperty;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        private boolean debug;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        private boolean isOpenCheckPermission;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        private n appReporter;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private boolean isOpenApiInvokeAnalyse;

        /* renamed from: n, reason: collision with root package name and from kotlin metadata */
        private AutoStartMonitor.ComponentStartListener autoStartListener;

        /* renamed from: o, reason: collision with root package name and from kotlin metadata */
        private boolean resourceMonitor;

        /* renamed from: p, reason: collision with root package name and from kotlin metadata */
        private boolean isOpenSilenceHook;

        /* renamed from: q, reason: collision with root package name and from kotlin metadata */
        private String mmkvRootDir;

        /* renamed from: r, reason: collision with root package name and from kotlin metadata */
        private boolean shouldClearCacheOnDeviceClone;

        /* renamed from: s, reason: collision with root package name and from kotlin metadata */
        private final String appId;

        /* renamed from: t, reason: collision with root package name and from kotlin metadata */
        private final String appKey;

        /* renamed from: u, reason: collision with root package name and from kotlin metadata */
        private final Application application;

        public a(@NotNull String appId, @NotNull String appKey, @NotNull Application application) {
            Intrinsics.checkParameterIsNotNull(appId, "appId");
            Intrinsics.checkParameterIsNotNull(appKey, "appKey");
            Intrinsics.checkParameterIsNotNull(application, "application");
            this.appId = appId;
            this.appKey = appKey;
            this.application = application;
            this.logger = new e();
            this.appStateManager = com.tencent.qmethod.monitor.base.defaultImpl.a.f343502e;
            this.useMMKVStrategy = true;
            this.uvReportSamplingRate = 1;
            this.propertyMap = new HashMap<>();
            this.necessaryProperty = new ArrayList<>();
        }

        private final void b() {
            for (Property property : this.necessaryProperty) {
                if (!this.propertyMap.containsKey(property)) {
                    throw new IllegalStateException("you must set app property {" + property.name() + '}');
                }
            }
        }

        @NotNull
        public final PMonitorInitParam a() {
            b();
            PMonitorInitParam pMonitorInitParam = new PMonitorInitParam(this.appId, this.appKey, this.application, this.logger, this.appStateManager, this.thread, this.useMMKVStrategy, this.uvReportSamplingRate, this.debug, this.isOpenCheckPermission, this.appReporter, this.isOpenApiInvokeAnalyse, this.isOpenSilenceHook, this.autoStartListener, this.resourceMonitor, this.storage, null, this.isOpenNetworkCapture, this.mmkvRootDir, null, null, null, this.shouldClearCacheOnDeviceClone);
            for (Map.Entry<Property, String> entry : this.propertyMap.entrySet()) {
                pMonitorInitParam.d().put(entry.getKey(), entry.getValue());
            }
            return pMonitorInitParam;
        }

        @NotNull
        public final a c(@NotNull f value) {
            Intrinsics.checkParameterIsNotNull(value, "value");
            this.appStateManager = value;
            return this;
        }

        @NotNull
        public final a d(boolean isOpenApiInvokeAnalyse) {
            this.isOpenApiInvokeAnalyse = isOpenApiInvokeAnalyse;
            return this;
        }

        @NotNull
        public final a e(@NotNull j value) {
            Intrinsics.checkParameterIsNotNull(value, "value");
            this.logger = value;
            return this;
        }

        @NotNull
        public final a f(@NotNull o value) {
            Intrinsics.checkParameterIsNotNull(value, "value");
            this.thread = value;
            return this;
        }

        @NotNull
        public final a g(@IntRange(from = 1) int value) {
            this.uvReportSamplingRate = value;
            return this;
        }
    }

    public PMonitorInitParam(@NotNull String appId, @NotNull String appKey, @NotNull Application context, @NotNull j logger, @NotNull f appStateManager, @Nullable o oVar, boolean z16, int i3, boolean z17, boolean z18, @Nullable n nVar, boolean z19, boolean z26, @Nullable AutoStartMonitor.ComponentStartListener componentStartListener, boolean z27, @Nullable g gVar, @Nullable b bVar, boolean z28, @Nullable String str, @Nullable i iVar, @Nullable l lVar, @Nullable com.tencent.qmethod.monitor.ext.auto.b bVar2, boolean z29) {
        Intrinsics.checkParameterIsNotNull(appId, "appId");
        Intrinsics.checkParameterIsNotNull(appKey, "appKey");
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(logger, "logger");
        Intrinsics.checkParameterIsNotNull(appStateManager, "appStateManager");
        this.appId = appId;
        this.appKey = appKey;
        this.context = context;
        this.logger = logger;
        this.appStateManager = appStateManager;
        this.threadExecutor = oVar;
        this.useMMKVStrategy = z16;
        this.uvReportSamplingRate = i3;
        this.debug = z17;
        this.isOpenCheckPermission = z18;
        this.appReporter = nVar;
        this.isOpenApiInvokeAnalyse = z19;
        this.isOpenSilenceHook = z26;
        this.autoStartListener = componentStartListener;
        this.resourceMonitor = z27;
        this.storage = gVar;
        this.isOpenNetworkCapture = z28;
        this.mmkvRootDir = str;
        this.shouldClearCacheOnDeviceClone = z29;
        this.appProperty = new HashMap<>();
    }

    public final void A(boolean z16) {
        this.isDelay = z16;
    }

    @Nullable
    public final com.tencent.qmethod.monitor.ext.auto.b a() {
        return null;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getAppKey() {
        return this.appKey;
    }

    @NotNull
    public final HashMap<Property, String> d() {
        return this.appProperty;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final n getAppReporter() {
        return this.appReporter;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof PMonitorInitParam) {
                PMonitorInitParam pMonitorInitParam = (PMonitorInitParam) other;
                if (!Intrinsics.areEqual(this.appId, pMonitorInitParam.appId) || !Intrinsics.areEqual(this.appKey, pMonitorInitParam.appKey) || !Intrinsics.areEqual(this.context, pMonitorInitParam.context) || !Intrinsics.areEqual(this.logger, pMonitorInitParam.logger) || !Intrinsics.areEqual(this.appStateManager, pMonitorInitParam.appStateManager) || !Intrinsics.areEqual(this.threadExecutor, pMonitorInitParam.threadExecutor) || this.useMMKVStrategy != pMonitorInitParam.useMMKVStrategy || this.uvReportSamplingRate != pMonitorInitParam.uvReportSamplingRate || this.debug != pMonitorInitParam.debug || this.isOpenCheckPermission != pMonitorInitParam.isOpenCheckPermission || !Intrinsics.areEqual(this.appReporter, pMonitorInitParam.appReporter) || this.isOpenApiInvokeAnalyse != pMonitorInitParam.isOpenApiInvokeAnalyse || this.isOpenSilenceHook != pMonitorInitParam.isOpenSilenceHook || !Intrinsics.areEqual(this.autoStartListener, pMonitorInitParam.autoStartListener) || this.resourceMonitor != pMonitorInitParam.resourceMonitor || !Intrinsics.areEqual(this.storage, pMonitorInitParam.storage) || !Intrinsics.areEqual((Object) null, (Object) null) || this.isOpenNetworkCapture != pMonitorInitParam.isOpenNetworkCapture || !Intrinsics.areEqual(this.mmkvRootDir, pMonitorInitParam.mmkvRootDir) || !Intrinsics.areEqual((Object) null, (Object) null) || !Intrinsics.areEqual((Object) null, (Object) null) || !Intrinsics.areEqual((Object) null, (Object) null) || this.shouldClearCacheOnDeviceClone != pMonitorInitParam.shouldClearCacheOnDeviceClone) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final f getAppStateManager() {
        return this.appStateManager;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final AutoStartMonitor.ComponentStartListener getAutoStartListener() {
        return this.autoStartListener;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final Application getContext() {
        return this.context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        int i36;
        String str = this.appId;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i37 = i3 * 31;
        String str2 = this.appKey;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i38 = (i37 + i16) * 31;
        Application application = this.context;
        if (application != null) {
            i17 = application.hashCode();
        } else {
            i17 = 0;
        }
        int i39 = (i38 + i17) * 31;
        j jVar = this.logger;
        if (jVar != null) {
            i18 = jVar.hashCode();
        } else {
            i18 = 0;
        }
        int i46 = (i39 + i18) * 31;
        f fVar = this.appStateManager;
        if (fVar != null) {
            i19 = fVar.hashCode();
        } else {
            i19 = 0;
        }
        int i47 = (i46 + i19) * 31;
        o oVar = this.threadExecutor;
        if (oVar != null) {
            i26 = oVar.hashCode();
        } else {
            i26 = 0;
        }
        int i48 = (i47 + i26) * 31;
        boolean z16 = this.useMMKVStrategy;
        int i49 = 1;
        int i56 = z16;
        if (z16 != 0) {
            i56 = 1;
        }
        int i57 = (((i48 + i56) * 31) + this.uvReportSamplingRate) * 31;
        boolean z17 = this.debug;
        int i58 = z17;
        if (z17 != 0) {
            i58 = 1;
        }
        int i59 = (i57 + i58) * 31;
        boolean z18 = this.isOpenCheckPermission;
        int i65 = z18;
        if (z18 != 0) {
            i65 = 1;
        }
        int i66 = (i59 + i65) * 31;
        n nVar = this.appReporter;
        if (nVar != null) {
            i27 = nVar.hashCode();
        } else {
            i27 = 0;
        }
        int i67 = (i66 + i27) * 31;
        boolean z19 = this.isOpenApiInvokeAnalyse;
        int i68 = z19;
        if (z19 != 0) {
            i68 = 1;
        }
        int i69 = (i67 + i68) * 31;
        boolean z26 = this.isOpenSilenceHook;
        int i75 = z26;
        if (z26 != 0) {
            i75 = 1;
        }
        int i76 = (i69 + i75) * 31;
        AutoStartMonitor.ComponentStartListener componentStartListener = this.autoStartListener;
        if (componentStartListener != null) {
            i28 = componentStartListener.hashCode();
        } else {
            i28 = 0;
        }
        int i77 = (i76 + i28) * 31;
        boolean z27 = this.resourceMonitor;
        int i78 = z27;
        if (z27 != 0) {
            i78 = 1;
        }
        int i79 = (i77 + i78) * 31;
        g gVar = this.storage;
        if (gVar != null) {
            i29 = gVar.hashCode();
        } else {
            i29 = 0;
        }
        int i85 = (((i79 + i29) * 31) + 0) * 31;
        boolean z28 = this.isOpenNetworkCapture;
        int i86 = z28;
        if (z28 != 0) {
            i86 = 1;
        }
        int i87 = (i85 + i86) * 31;
        String str3 = this.mmkvRootDir;
        if (str3 != null) {
            i36 = str3.hashCode();
        } else {
            i36 = 0;
        }
        int i88 = (((((((i87 + i36) * 31) + 0) * 31) + 0) * 31) + 0) * 31;
        boolean z29 = this.shouldClearCacheOnDeviceClone;
        if (!z29) {
            i49 = z29 ? 1 : 0;
        }
        return i88 + i49;
    }

    /* renamed from: i, reason: from getter */
    public final boolean getDebug() {
        return this.debug;
    }

    @Nullable
    public final i j() {
        return null;
    }

    @NotNull
    /* renamed from: k, reason: from getter */
    public final j getLogger() {
        return this.logger;
    }

    @Nullable
    /* renamed from: l, reason: from getter */
    public final String getMmkvRootDir() {
        return this.mmkvRootDir;
    }

    @Nullable
    public final l m() {
        return null;
    }

    /* renamed from: n, reason: from getter */
    public final boolean getResourceMonitor() {
        return this.resourceMonitor;
    }

    /* renamed from: o, reason: from getter */
    public final boolean getShouldClearCacheOnDeviceClone() {
        return this.shouldClearCacheOnDeviceClone;
    }

    @Nullable
    /* renamed from: p, reason: from getter */
    public final g getStorage() {
        return this.storage;
    }

    @Nullable
    /* renamed from: q, reason: from getter */
    public final o getThreadExecutor() {
        return this.threadExecutor;
    }

    @Nullable
    public final b r() {
        return null;
    }

    /* renamed from: s, reason: from getter */
    public final boolean getUseMMKVStrategy() {
        return this.useMMKVStrategy;
    }

    /* renamed from: t, reason: from getter */
    public final int getUvReportSamplingRate() {
        return this.uvReportSamplingRate;
    }

    @NotNull
    public String toString() {
        return "PMonitorInitParam(appId=" + this.appId + ", appKey=" + this.appKey + ", context=" + this.context + ", logger=" + this.logger + ", appStateManager=" + this.appStateManager + ", threadExecutor=" + this.threadExecutor + ", useMMKVStrategy=" + this.useMMKVStrategy + ", uvReportSamplingRate=" + this.uvReportSamplingRate + ", debug=" + this.debug + ", isOpenCheckPermission=" + this.isOpenCheckPermission + ", appReporter=" + this.appReporter + ", isOpenApiInvokeAnalyse=" + this.isOpenApiInvokeAnalyse + ", isOpenSilenceHook=" + this.isOpenSilenceHook + ", autoStartListener=" + this.autoStartListener + ", resourceMonitor=" + this.resourceMonitor + ", storage=" + this.storage + ", traffic=" + ((Object) null) + ", isOpenNetworkCapture=" + this.isOpenNetworkCapture + ", mmkvRootDir=" + this.mmkvRootDir + ", libLoader=" + ((Object) null) + ", rJniHook=" + ((Object) null) + ", activityJumpInterrupt=" + ((Object) null) + ", shouldClearCacheOnDeviceClone=" + this.shouldClearCacheOnDeviceClone + ")";
    }

    /* renamed from: u, reason: from getter */
    public final boolean getIsDelay() {
        return this.isDelay;
    }

    /* renamed from: v, reason: from getter */
    public final boolean getIsOpenApiInvokeAnalyse() {
        return this.isOpenApiInvokeAnalyse;
    }

    /* renamed from: w, reason: from getter */
    public final boolean getIsOpenCheckPermission() {
        return this.isOpenCheckPermission;
    }

    /* renamed from: x, reason: from getter */
    public final boolean getIsOpenNetworkCapture() {
        return this.isOpenNetworkCapture;
    }

    /* renamed from: y, reason: from getter */
    public final boolean getIsOpenSilenceHook() {
        return this.isOpenSilenceHook;
    }

    public final void z(@NotNull f fVar) {
        Intrinsics.checkParameterIsNotNull(fVar, "<set-?>");
        this.appStateManager = fVar;
    }
}
