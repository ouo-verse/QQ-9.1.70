package com.tencent.aegiskmm.bean;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\bA\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0086\b\u0018\u00002\u00020\u0001B\u00c3\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0005\u0012\b\b\u0002\u0010 \u001a\u00020\u0005\u0012\b\b\u0002\u0010#\u001a\u00020\u0005\u0012\b\b\u0002\u0010'\u001a\u00020\u0005\u0012\b\b\u0002\u0010+\u001a\u00020\u0005\u0012\b\b\u0002\u0010/\u001a\u00020\u0005\u0012\b\b\u0002\u00102\u001a\u00020\u0005\u0012\b\b\u0002\u00105\u001a\u00020\u0005\u0012\b\b\u0002\u00108\u001a\u00020\u0005\u0012\b\b\u0002\u0010<\u001a\u00020\u0005\u0012\b\b\u0002\u0010?\u001a\u00020\u0005\u0012\b\b\u0002\u0010B\u001a\u00020\u0005\u0012\b\b\u0002\u0010H\u001a\u00020\u0007\u0012\b\b\u0002\u0010L\u001a\u00020\u0007\u0012\b\b\u0002\u0010S\u001a\u00020M\u0012\b\b\u0002\u0010W\u001a\u00020\u0007\u0012\b\b\u0002\u0010^\u001a\u00020\u000b\u0012\u0018\b\u0002\u0010f\u001a\u0012\u0012\u0004\u0012\u00020`0_j\b\u0012\u0004\u0012\u00020``a\u0012\b\b\u0002\u0010i\u001a\u00020\u000b\u0012\b\b\u0002\u0010k\u001a\u00020\u0005\u0012\b\b\u0002\u0010m\u001a\u00020\u0005\u0012\b\b\u0002\u0010o\u001a\u00020\u0005\u0012\b\b\u0002\u0010q\u001a\u00020\u0005\u0012\b\b\u0002\u0010s\u001a\u00020\u0005\u0012\b\b\u0002\u0010u\u001a\u00020\u0005\u0012\b\b\u0002\u0010x\u001a\u00020\u0005\u0012\b\b\u0002\u0010{\u001a\u00020\u0005\u00a2\u0006\u0004\b|\u0010}J\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u00d6\u0003R\"\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0016\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\"\u0010\u001a\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R\"\u0010\u001d\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\r\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001c\u0010\u0011R\"\u0010 \u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\r\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011R\"\u0010#\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\"\u0010\u0011R\"\u0010'\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\r\u001a\u0004\b%\u0010\u000f\"\u0004\b&\u0010\u0011R\"\u0010+\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\r\u001a\u0004\b)\u0010\u000f\"\u0004\b*\u0010\u0011R\"\u0010/\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010\r\u001a\u0004\b-\u0010\u000f\"\u0004\b.\u0010\u0011R\"\u00102\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010\r\u001a\u0004\b0\u0010\u000f\"\u0004\b1\u0010\u0011R\"\u00105\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\r\u001a\u0004\b3\u0010\u000f\"\u0004\b4\u0010\u0011R\"\u00108\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\r\u001a\u0004\b6\u0010\u000f\"\u0004\b7\u0010\u0011R\"\u0010<\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010\r\u001a\u0004\b:\u0010\u000f\"\u0004\b;\u0010\u0011R\"\u0010?\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010\r\u001a\u0004\b9\u0010\u000f\"\u0004\b>\u0010\u0011R\"\u0010B\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u0010\r\u001a\u0004\b@\u0010\u000f\"\u0004\bA\u0010\u0011R\"\u0010H\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\b,\u0010E\"\u0004\bF\u0010GR\"\u0010L\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bI\u0010D\u001a\u0004\bJ\u0010E\"\u0004\bK\u0010GR\"\u0010S\u001a\u00020M8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\"\u0010W\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bT\u0010D\u001a\u0004\bU\u0010E\"\u0004\bV\u0010GR\"\u0010^\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R2\u0010f\u001a\u0012\u0012\u0004\u0012\u00020`0_j\b\u0012\u0004\u0012\u00020``a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010b\u001a\u0004\bT\u0010c\"\u0004\bd\u0010eR\"\u0010i\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bg\u0010Y\u001a\u0004\bg\u0010[\"\u0004\bh\u0010]R\"\u0010k\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bZ\u0010\r\u001a\u0004\b!\u0010\u000f\"\u0004\bj\u0010\u0011R\"\u0010m\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010\r\u001a\u0004\bC\u0010\u000f\"\u0004\bl\u0010\u0011R\"\u0010o\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010\r\u001a\u0004\bX\u0010\u000f\"\u0004\bn\u0010\u0011R\"\u0010q\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\r\u001a\u0004\b\u0017\u0010\u000f\"\u0004\bp\u0010\u0011R\"\u0010s\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\r\u001a\u0004\bI\u0010\u000f\"\u0004\br\u0010\u0011R\"\u0010u\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010\r\u001a\u0004\b$\u0010\u000f\"\u0004\bt\u0010\u0011R\"\u0010x\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bv\u0010\r\u001a\u0004\b=\u0010\u000f\"\u0004\bw\u0010\u0011R\"\u0010{\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\by\u0010\r\u001a\u0004\b(\u0010\u000f\"\u0004\bz\u0010\u0011\u00a8\u0006~"}, d2 = {"Lcom/tencent/aegiskmm/bean/b;", "Lcom/tencent/aegiskmm/bean/e;", DownloadInfo.spKey_Config, "", "b", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", "appId", "c", "f", "setAppKey", com.heytap.mcssdk.a.a.f36102l, "d", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "setUid", "uid", "B", "setVersion", "version", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setFrameworkVersion", "frameworkVersion", "g", "setAId", "aId", tl.h.F, "l", "setFId", "fId", "i", "k", "setEnv", MosaicConstants$JsProperty.PROP_ENV, "j", ReportConstant.COSTREPORT_PREFIX, "setPlatform", "platform", "p", "setNetType", "netType", BdhLogUtil.LogTag.Tag_Conn, "setVp", "vp", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "setSr", "sr", DomainData.DOMAIN_NAME, "y", "setSessionId", "sessionId", "o", "setFrom", "from", "v", "setReferer", ISchemeApi.KEY_REFERER, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "I", "()I", "setDelay", "(I)V", "delay", "r", "getRepeat", "setRepeat", "repeat", "", UserInfo.SEX_FEMALE, "getSample", "()F", "setSample", "(F)V", "sample", "t", "getMaxLength", "setMaxLength", "maxLength", "u", "Z", HippyTKDListViewAdapter.X, "()Z", "setReportToTestServer", "(Z)V", "reportToTestServer", "Ljava/util/ArrayList;", "Lcom/tencent/aegiskmm/bean/g;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "setPlugin", "(Ljava/util/ArrayList;)V", "plugin", "w", "setReportImmediately", "reportImmediately", "setAppVersion", "appVersion", "setOsVersion", "osVersion", "setProductVersion", "productVersion", "setAbTags", "abTags", "setPageLoadStrategy", "pageLoadStrategy", "setBrand", "brand", "D", "setModel", "model", "E", "setDId", "dId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIFIZLjava/util/ArrayList;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "ShiplyCS-KuiklyAegis_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.aegiskmm.bean.b, reason: from toString */
/* loaded from: classes37.dex */
public final /* data */ class AegisConfig extends e {

    /* renamed from: A, reason: from kotlin metadata and from toString */
    private String abTags;

    /* renamed from: B, reason: from kotlin metadata and from toString */
    private String pageLoadStrategy;

    /* renamed from: C, reason: from kotlin metadata and from toString */
    private String brand;

    /* renamed from: D, reason: from kotlin metadata and from toString */
    private String model;

    /* renamed from: E, reason: from kotlin metadata and from toString */
    private String dId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private String appId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private String appKey;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private String uid;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private String version;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private String frameworkVersion;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private String aId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private String fId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private String env;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private String platform;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private String netType;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private String vp;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private String sr;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    private String sessionId;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata and from toString */
    private String from;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata and from toString */
    private String referer;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata and from toString */
    private int delay;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata and from toString */
    private int repeat;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata and from toString */
    private float sample;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata and from toString */
    private int maxLength;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean reportToTestServer;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata and from toString */
    private ArrayList<g> plugin;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean reportImmediately;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata and from toString */
    private String appVersion;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata and from toString */
    private String osVersion;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata and from toString */
    private String productVersion;

    public AegisConfig() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, 0, 0.0f, 0, false, null, false, null, null, null, null, null, null, null, null, LockFreeTaskQueueCore.MAX_CAPACITY_MASK, null);
    }

    /* renamed from: A, reason: from getter */
    public final String getUid() {
        return this.uid;
    }

    /* renamed from: B, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* renamed from: C, reason: from getter */
    public final String getVp() {
        return this.vp;
    }

    public final void b(AegisConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (!Intrinsics.areEqual(config.appId, "")) {
            this.appId = config.appId;
        }
        if (!Intrinsics.areEqual(config.appKey, "")) {
            this.appKey = config.appKey;
        }
        if (!Intrinsics.areEqual(config.uid, "")) {
            this.uid = config.uid;
        }
        if (!Intrinsics.areEqual(config.aId, "")) {
            this.aId = config.aId;
        }
        if (!Intrinsics.areEqual(config.fId, "")) {
            this.fId = config.fId;
        }
        if (!Intrinsics.areEqual(config.dId, "")) {
            this.dId = config.dId;
        }
        if (!Intrinsics.areEqual(config.env, "")) {
            this.env = config.env;
        }
        if (!Intrinsics.areEqual(config.platform, "")) {
            this.platform = config.platform;
        }
        if (!Intrinsics.areEqual(config.netType, "")) {
            this.netType = config.netType;
        }
        if (!Intrinsics.areEqual(config.version, "")) {
            this.version = config.version;
        }
        if (!Intrinsics.areEqual(config.frameworkVersion, "")) {
            this.frameworkVersion = config.frameworkVersion;
        }
        if (!Intrinsics.areEqual(config.vp, "")) {
            this.vp = config.vp;
        }
        if (!Intrinsics.areEqual(config.sr, "")) {
            this.sr = config.sr;
        }
        if (!Intrinsics.areEqual(config.sessionId, "")) {
            this.sessionId = config.sessionId;
        }
        if (!Intrinsics.areEqual(config.from, "")) {
            this.from = config.from;
        }
        if (!Intrinsics.areEqual(config.referer, "")) {
            this.referer = config.referer;
        }
        if (!Intrinsics.areEqual(config.appVersion, "")) {
            this.appVersion = config.appVersion;
        }
        if (!Intrinsics.areEqual(config.osVersion, "")) {
            this.osVersion = config.osVersion;
        }
        if (!Intrinsics.areEqual(config.productVersion, "")) {
            this.productVersion = config.productVersion;
        }
        if (!Intrinsics.areEqual(config.abTags, "")) {
            this.abTags = config.abTags;
        }
        if (!Intrinsics.areEqual(config.pageLoadStrategy, "")) {
            this.pageLoadStrategy = config.pageLoadStrategy;
        }
        if (!Intrinsics.areEqual(config.brand, "")) {
            this.brand = config.brand;
        }
        if (!Intrinsics.areEqual(config.model, "")) {
            this.model = config.model;
        }
        this.delay = config.delay;
        this.repeat = config.repeat;
        this.sample = config.sample;
        this.maxLength = config.maxLength;
        this.reportToTestServer = config.reportToTestServer;
        this.reportImmediately = config.reportImmediately;
        this.plugin = config.plugin;
    }

    /* renamed from: c, reason: from getter */
    public final String getAId() {
        return this.aId;
    }

    /* renamed from: d, reason: from getter */
    public final String getAbTags() {
        return this.abTags;
    }

    /* renamed from: e, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    /* renamed from: f, reason: from getter */
    public final String getAppKey() {
        return this.appKey;
    }

    /* renamed from: g, reason: from getter */
    public final String getAppVersion() {
        return this.appVersion;
    }

    /* renamed from: h, reason: from getter */
    public final String getBrand() {
        return this.brand;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.appId;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.appKey;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.uid;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.version;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.frameworkVersion;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.aId;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.fId;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.env;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.platform;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.netType;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.vp;
        int hashCode11 = (hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.sr;
        int hashCode12 = (hashCode11 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.sessionId;
        int hashCode13 = (hashCode12 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.from;
        int hashCode14 = (hashCode13 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.referer;
        int hashCode15 = (((((((((hashCode14 + (str15 != null ? str15.hashCode() : 0)) * 31) + this.delay) * 31) + this.repeat) * 31) + Float.floatToIntBits(this.sample)) * 31) + this.maxLength) * 31;
        boolean z16 = this.reportToTestServer;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode15 + i3) * 31;
        ArrayList<g> arrayList = this.plugin;
        int hashCode16 = (i16 + (arrayList != null ? arrayList.hashCode() : 0)) * 31;
        boolean z17 = this.reportImmediately;
        int i17 = (hashCode16 + (z17 ? 1 : z17 ? 1 : 0)) * 31;
        String str16 = this.appVersion;
        int hashCode17 = (i17 + (str16 != null ? str16.hashCode() : 0)) * 31;
        String str17 = this.osVersion;
        int hashCode18 = (hashCode17 + (str17 != null ? str17.hashCode() : 0)) * 31;
        String str18 = this.productVersion;
        int hashCode19 = (hashCode18 + (str18 != null ? str18.hashCode() : 0)) * 31;
        String str19 = this.abTags;
        int hashCode20 = (hashCode19 + (str19 != null ? str19.hashCode() : 0)) * 31;
        String str20 = this.pageLoadStrategy;
        int hashCode21 = (hashCode20 + (str20 != null ? str20.hashCode() : 0)) * 31;
        String str21 = this.brand;
        int hashCode22 = (hashCode21 + (str21 != null ? str21.hashCode() : 0)) * 31;
        String str22 = this.model;
        int hashCode23 = (hashCode22 + (str22 != null ? str22.hashCode() : 0)) * 31;
        String str23 = this.dId;
        return hashCode23 + (str23 != null ? str23.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final String getDId() {
        return this.dId;
    }

    /* renamed from: j, reason: from getter */
    public final int getDelay() {
        return this.delay;
    }

    /* renamed from: k, reason: from getter */
    public final String getEnv() {
        return this.env;
    }

    /* renamed from: l, reason: from getter */
    public final String getFId() {
        return this.fId;
    }

    /* renamed from: m, reason: from getter */
    public final String getFrameworkVersion() {
        return this.frameworkVersion;
    }

    /* renamed from: n, reason: from getter */
    public final String getFrom() {
        return this.from;
    }

    /* renamed from: o, reason: from getter */
    public final String getModel() {
        return this.model;
    }

    /* renamed from: p, reason: from getter */
    public final String getNetType() {
        return this.netType;
    }

    /* renamed from: q, reason: from getter */
    public final String getOsVersion() {
        return this.osVersion;
    }

    /* renamed from: r, reason: from getter */
    public final String getPageLoadStrategy() {
        return this.pageLoadStrategy;
    }

    /* renamed from: s, reason: from getter */
    public final String getPlatform() {
        return this.platform;
    }

    public final ArrayList<g> t() {
        return this.plugin;
    }

    public String toString() {
        return "AegisConfig(appId=" + this.appId + ", appKey=" + this.appKey + ", uid=" + this.uid + ", version=" + this.version + ", frameworkVersion=" + this.frameworkVersion + ", aId=" + this.aId + ", fId=" + this.fId + ", env=" + this.env + ", platform=" + this.platform + ", netType=" + this.netType + ", vp=" + this.vp + ", sr=" + this.sr + ", sessionId=" + this.sessionId + ", from=" + this.from + ", referer=" + this.referer + ", delay=" + this.delay + ", repeat=" + this.repeat + ", sample=" + this.sample + ", maxLength=" + this.maxLength + ", reportToTestServer=" + this.reportToTestServer + ", plugin=" + this.plugin + ", reportImmediately=" + this.reportImmediately + ", appVersion=" + this.appVersion + ", osVersion=" + this.osVersion + ", productVersion=" + this.productVersion + ", abTags=" + this.abTags + ", pageLoadStrategy=" + this.pageLoadStrategy + ", brand=" + this.brand + ", model=" + this.model + ", dId=" + this.dId + ")";
    }

    /* renamed from: u, reason: from getter */
    public final String getProductVersion() {
        return this.productVersion;
    }

    /* renamed from: v, reason: from getter */
    public final String getReferer() {
        return this.referer;
    }

    /* renamed from: w, reason: from getter */
    public final boolean getReportImmediately() {
        return this.reportImmediately;
    }

    /* renamed from: x, reason: from getter */
    public final boolean getReportToTestServer() {
        return this.reportToTestServer;
    }

    /* renamed from: y, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: z, reason: from getter */
    public final String getSr() {
        return this.sr;
    }

    public /* synthetic */ AegisConfig(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, int i3, int i16, float f16, int i17, boolean z16, ArrayList arrayList, boolean z17, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? "" : str, (i18 & 2) != 0 ? "" : str2, (i18 & 4) != 0 ? "" : str3, (i18 & 8) != 0 ? "" : str4, (i18 & 16) != 0 ? "" : str5, (i18 & 32) != 0 ? "" : str6, (i18 & 64) != 0 ? "" : str7, (i18 & 128) != 0 ? "" : str8, (i18 & 256) != 0 ? "" : str9, (i18 & 512) != 0 ? "" : str10, (i18 & 1024) != 0 ? "" : str11, (i18 & 2048) != 0 ? "" : str12, (i18 & 4096) != 0 ? "" : str13, (i18 & 8192) != 0 ? "" : str14, (i18 & 16384) != 0 ? "" : str15, (i18 & 32768) != 0 ? 1000 : i3, (i18 & 65536) != 0 ? 60 : i16, (i18 & 131072) != 0 ? 1.0f : f16, (i18 & 262144) != 0 ? RFixConstants.MD5_FILE_BUF_LENGTH : i17, (i18 & 524288) != 0 ? false : z16, (i18 & 1048576) != 0 ? new ArrayList() : arrayList, (i18 & 2097152) != 0 ? true : z17, (i18 & 4194304) != 0 ? "" : str16, (i18 & 8388608) != 0 ? "" : str17, (i18 & 16777216) != 0 ? "" : str18, (i18 & 33554432) != 0 ? "" : str19, (i18 & 67108864) != 0 ? "" : str20, (i18 & 134217728) != 0 ? "" : str21, (i18 & 268435456) != 0 ? "" : str22, (i18 & 536870912) != 0 ? "" : str23);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AegisConfig)) {
            return false;
        }
        AegisConfig aegisConfig = (AegisConfig) other;
        return Intrinsics.areEqual(this.appId, aegisConfig.appId) && Intrinsics.areEqual(this.appKey, aegisConfig.appKey) && Intrinsics.areEqual(this.uid, aegisConfig.uid) && Intrinsics.areEqual(this.version, aegisConfig.version) && Intrinsics.areEqual(this.frameworkVersion, aegisConfig.frameworkVersion) && Intrinsics.areEqual(this.aId, aegisConfig.aId) && Intrinsics.areEqual(this.fId, aegisConfig.fId) && Intrinsics.areEqual(this.env, aegisConfig.env) && Intrinsics.areEqual(this.platform, aegisConfig.platform) && Intrinsics.areEqual(this.netType, aegisConfig.netType) && Intrinsics.areEqual(this.vp, aegisConfig.vp) && Intrinsics.areEqual(this.sr, aegisConfig.sr) && Intrinsics.areEqual(this.sessionId, aegisConfig.sessionId) && Intrinsics.areEqual(this.from, aegisConfig.from) && Intrinsics.areEqual(this.referer, aegisConfig.referer) && this.delay == aegisConfig.delay && this.repeat == aegisConfig.repeat && Float.compare(this.sample, aegisConfig.sample) == 0 && this.maxLength == aegisConfig.maxLength && this.reportToTestServer == aegisConfig.reportToTestServer && Intrinsics.areEqual(this.plugin, aegisConfig.plugin) && this.reportImmediately == aegisConfig.reportImmediately && Intrinsics.areEqual(this.appVersion, aegisConfig.appVersion) && Intrinsics.areEqual(this.osVersion, aegisConfig.osVersion) && Intrinsics.areEqual(this.productVersion, aegisConfig.productVersion) && Intrinsics.areEqual(this.abTags, aegisConfig.abTags) && Intrinsics.areEqual(this.pageLoadStrategy, aegisConfig.pageLoadStrategy) && Intrinsics.areEqual(this.brand, aegisConfig.brand) && Intrinsics.areEqual(this.model, aegisConfig.model) && Intrinsics.areEqual(this.dId, aegisConfig.dId);
    }

    public AegisConfig(String appId, String appKey, String uid, String version, String frameworkVersion, String aId, String fId, String env, String platform, String netType, String vp5, String sr5, String sessionId, String from, String referer, int i3, int i16, float f16, int i17, boolean z16, ArrayList<g> plugin, boolean z17, String appVersion, String osVersion, String productVersion, String abTags, String pageLoadStrategy, String brand, String model, String dId) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(frameworkVersion, "frameworkVersion");
        Intrinsics.checkNotNullParameter(aId, "aId");
        Intrinsics.checkNotNullParameter(fId, "fId");
        Intrinsics.checkNotNullParameter(env, "env");
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(netType, "netType");
        Intrinsics.checkNotNullParameter(vp5, "vp");
        Intrinsics.checkNotNullParameter(sr5, "sr");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(referer, "referer");
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(osVersion, "osVersion");
        Intrinsics.checkNotNullParameter(productVersion, "productVersion");
        Intrinsics.checkNotNullParameter(abTags, "abTags");
        Intrinsics.checkNotNullParameter(pageLoadStrategy, "pageLoadStrategy");
        Intrinsics.checkNotNullParameter(brand, "brand");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(dId, "dId");
        this.appId = appId;
        this.appKey = appKey;
        this.uid = uid;
        this.version = version;
        this.frameworkVersion = frameworkVersion;
        this.aId = aId;
        this.fId = fId;
        this.env = env;
        this.platform = platform;
        this.netType = netType;
        this.vp = vp5;
        this.sr = sr5;
        this.sessionId = sessionId;
        this.from = from;
        this.referer = referer;
        this.delay = i3;
        this.repeat = i16;
        this.sample = f16;
        this.maxLength = i17;
        this.reportToTestServer = z16;
        this.plugin = plugin;
        this.reportImmediately = z17;
        this.appVersion = appVersion;
        this.osVersion = osVersion;
        this.productVersion = productVersion;
        this.abTags = abTags;
        this.pageLoadStrategy = pageLoadStrategy;
        this.brand = brand;
        this.model = model;
        this.dId = dId;
    }
}
