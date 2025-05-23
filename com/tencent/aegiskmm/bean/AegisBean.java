package com.tencent.aegiskmm.bean;

import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.lebasearch.Utils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\bY\b\u0086\b\u0018\u00002\u00020\u0001B\u00ed\u0001\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0004\u0012\b\b\u0002\u0010!\u001a\u00020\u0004\u0012\b\b\u0002\u0010%\u001a\u00020\u0004\u0012\b\b\u0002\u0010)\u001a\u00020\u0004\u0012\b\b\u0002\u0010,\u001a\u00020\u0004\u0012\b\b\u0002\u0010/\u001a\u00020\u0004\u0012\b\b\u0002\u00102\u001a\u00020\u0004\u0012\b\b\u0002\u00104\u001a\u00020\u0004\u0012\b\b\u0002\u00107\u001a\u00020\u0004\u0012\b\b\u0002\u0010:\u001a\u00020\u0004\u0012\b\b\u0002\u0010>\u001a\u00020\u0004\u0012\b\b\u0002\u0010B\u001a\u00020\u0004\u0012\b\b\u0002\u0010E\u001a\u00020\u0004\u0012\b\b\u0002\u0010I\u001a\u00020\u0004\u0012\b\b\u0002\u0010M\u001a\u00020\u0004\u0012\b\b\u0002\u0010Q\u001a\u00020\u0004\u0012\b\b\u0002\u0010U\u001a\u00020\u0004\u0012\b\b\u0002\u0010Y\u001a\u00020\u0004\u0012\b\b\u0002\u0010]\u001a\u00020\u0004\u0012\b\b\u0002\u0010a\u001a\u00020\u0004\u0012\b\b\u0002\u0010e\u001a\u00020\u0004\u00a2\u0006\u0004\bf\u0010gJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\t\u0010\n\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u00d6\u0003R\"\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\"\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0013\"\u0004\b\u001c\u0010\u0015R\"\u0010!\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0011\u001a\u0004\b\u001f\u0010\u0013\"\u0004\b \u0010\u0015R\"\u0010%\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0011\u001a\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0015R\"\u0010)\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u0011\u001a\u0004\b'\u0010\u0013\"\u0004\b(\u0010\u0015R\"\u0010,\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010\u0011\u001a\u0004\b+\u0010\u0013\"\u0004\b\u001a\u0010\u0015R\"\u0010/\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\u0011\u001a\u0004\b.\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\"\u00102\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b0\u0010\u0013\"\u0004\b1\u0010\u0015R\"\u00104\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b3\u0010\u0013\"\u0004\b-\u0010\u0015R\"\u00107\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010\u0011\u001a\u0004\b6\u0010\u0013\"\u0004\b&\u0010\u0015R\"\u0010:\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u0010\u0011\u001a\u0004\b9\u0010\u0013\"\u0004\b\"\u0010\u0015R\"\u0010>\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010\u0011\u001a\u0004\b<\u0010\u0013\"\u0004\b=\u0010\u0015R\"\u0010B\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010\u0011\u001a\u0004\b@\u0010\u0013\"\u0004\bA\u0010\u0015R\"\u0010E\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010\u0011\u001a\u0004\bD\u0010\u0013\"\u0004\b*\u0010\u0015R\"\u0010I\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010\u0011\u001a\u0004\bG\u0010\u0013\"\u0004\bH\u0010\u0015R\"\u0010M\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010\u0011\u001a\u0004\bK\u0010\u0013\"\u0004\bL\u0010\u0015R\"\u0010Q\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010\u0011\u001a\u0004\bO\u0010\u0013\"\u0004\bP\u0010\u0015R\"\u0010U\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010\u0011\u001a\u0004\bS\u0010\u0013\"\u0004\bT\u0010\u0015R\"\u0010Y\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010\u0011\u001a\u0004\bW\u0010\u0013\"\u0004\bX\u0010\u0015R\"\u0010]\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bZ\u0010\u0011\u001a\u0004\b[\u0010\u0013\"\u0004\b\\\u0010\u0015R\"\u0010a\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b^\u0010\u0011\u001a\u0004\b_\u0010\u0013\"\u0004\b`\u0010\u0015R\"\u0010e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bb\u0010\u0011\u001a\u0004\bc\u0010\u0013\"\u0004\bd\u0010\u0015\u00a8\u0006h"}, d2 = {"Lcom/tencent/aegiskmm/bean/a;", "Lcom/tencent/aegiskmm/bean/e;", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "j", "", "k", "Lcom/tencent/aegiskmm/bean/b;", DownloadInfo.spKey_Config, "", "b", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "id", "getUid", "setUid", "uid", "d", "getVersion", "setVersion", "version", "e", "getFrameworkVersion", "setFrameworkVersion", "frameworkVersion", "f", "getAId", "setAId", "aId", "g", "getFId", "setFId", "fId", tl.h.F, "getEnv", MosaicConstants$JsProperty.PROP_ENV, "i", "getPlatform", "platform", "getNetType", "setNetType", "netType", "getVp", "vp", "l", "getSr", "sr", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getSessionId", "sessionId", DomainData.DOMAIN_NAME, "getFrom", "setFrom", "from", "o", "getReferer", "setReferer", ISchemeApi.KEY_REFERER, "p", "getType", "type", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "getAppVersion", "setAppVersion", "appVersion", "r", "getOsVersion", "setOsVersion", "osVersion", ReportConstant.COSTREPORT_PREFIX, "getProductVersion", "setProductVersion", "productVersion", "t", "getAbTags", "setAbTags", "abTags", "u", "getPageLoadStrategy", "setPageLoadStrategy", "pageLoadStrategy", "v", "getBrand", "setBrand", "brand", "w", "getModel", "setModel", "model", HippyTKDListViewAdapter.X, "getDId", "setDId", "dId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "ShiplyCS-KuiklyAegis_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.aegiskmm.bean.a, reason: from toString */
/* loaded from: classes37.dex */
public final /* data */ class AegisBean extends e {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private String id;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private String uid;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private String version;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private String frameworkVersion;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private String aId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private String fId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private String env;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private String platform;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private String netType;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private String vp;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private String sr;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private String sessionId;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    private String from;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata and from toString */
    private String referer;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata and from toString */
    private String type;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata and from toString */
    private String appVersion;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata and from toString */
    private String osVersion;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata and from toString */
    private String productVersion;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata and from toString */
    private String abTags;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata and from toString */
    private String pageLoadStrategy;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata and from toString */
    private String brand;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata and from toString */
    private String model;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata and from toString */
    private String dId;

    public AegisBean() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388607, null);
    }

    public final void b(AegisConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (!Intrinsics.areEqual(config.getAppId(), "")) {
            this.id = config.getAppId();
        }
        if (!Intrinsics.areEqual(config.getUid(), "")) {
            this.uid = config.getUid();
        }
        if (!Intrinsics.areEqual(config.getAId(), "")) {
            this.aId = config.getAId();
        }
        if (!Intrinsics.areEqual(config.getFId(), "")) {
            this.fId = config.getFId();
        }
        if (!Intrinsics.areEqual(config.getDId(), "")) {
            this.dId = config.getDId();
        }
        if (!Intrinsics.areEqual(config.getEnv(), "")) {
            this.env = config.getEnv();
        }
        if (!Intrinsics.areEqual(config.getPlatform(), "")) {
            this.platform = config.getPlatform();
        }
        if (!Intrinsics.areEqual(config.getNetType(), "")) {
            this.netType = config.getNetType();
        }
        if (!Intrinsics.areEqual(config.getVersion(), "")) {
            this.version = config.getVersion();
        }
        if (!Intrinsics.areEqual(config.getFrameworkVersion(), "")) {
            this.frameworkVersion = config.getFrameworkVersion();
        }
        if (!Intrinsics.areEqual(config.getVp(), "")) {
            this.vp = config.getVp();
        }
        if (!Intrinsics.areEqual(config.getSr(), "")) {
            this.sr = config.getSr();
        }
        if (!Intrinsics.areEqual(config.getSessionId(), "")) {
            this.sessionId = config.getSessionId();
        }
        if (!Intrinsics.areEqual(config.getFrom(), "")) {
            this.from = config.getFrom();
        }
        if (!Intrinsics.areEqual(config.getReferer(), "")) {
            this.referer = config.getReferer();
        }
        if (!Intrinsics.areEqual(config.getAppVersion(), "")) {
            this.appVersion = config.getAppVersion();
        }
        if (!Intrinsics.areEqual(config.getOsVersion(), "")) {
            this.osVersion = config.getOsVersion();
        }
        if (!Intrinsics.areEqual(config.getProductVersion(), "")) {
            this.productVersion = config.getProductVersion();
        }
        if (!Intrinsics.areEqual(config.getAbTags(), "")) {
            this.abTags = config.getAbTags();
        }
        if (!Intrinsics.areEqual(config.getPageLoadStrategy(), "")) {
            this.pageLoadStrategy = config.getPageLoadStrategy();
        }
        if (!Intrinsics.areEqual(config.getBrand(), "")) {
            this.brand = config.getBrand();
        }
        if (!Intrinsics.areEqual(config.getModel(), "")) {
            this.model = config.getModel();
        }
    }

    /* renamed from: c, reason: from getter */
    public final String getId() {
        return this.id;
    }

    public final void d(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.env = str;
    }

    public final void e(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.platform = str;
    }

    public final void f(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sessionId = str;
    }

    public final void g(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sr = str;
    }

    public final void h(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }

    public int hashCode() {
        String str = this.id;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.uid;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.version;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.frameworkVersion;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.aId;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.fId;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.env;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.platform;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.netType;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.vp;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.sr;
        int hashCode11 = (hashCode10 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.sessionId;
        int hashCode12 = (hashCode11 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.from;
        int hashCode13 = (hashCode12 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.referer;
        int hashCode14 = (hashCode13 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.type;
        int hashCode15 = (hashCode14 + (str15 != null ? str15.hashCode() : 0)) * 31;
        String str16 = this.appVersion;
        int hashCode16 = (hashCode15 + (str16 != null ? str16.hashCode() : 0)) * 31;
        String str17 = this.osVersion;
        int hashCode17 = (hashCode16 + (str17 != null ? str17.hashCode() : 0)) * 31;
        String str18 = this.productVersion;
        int hashCode18 = (hashCode17 + (str18 != null ? str18.hashCode() : 0)) * 31;
        String str19 = this.abTags;
        int hashCode19 = (hashCode18 + (str19 != null ? str19.hashCode() : 0)) * 31;
        String str20 = this.pageLoadStrategy;
        int hashCode20 = (hashCode19 + (str20 != null ? str20.hashCode() : 0)) * 31;
        String str21 = this.brand;
        int hashCode21 = (hashCode20 + (str21 != null ? str21.hashCode() : 0)) * 31;
        String str22 = this.model;
        int hashCode22 = (hashCode21 + (str22 != null ? str22.hashCode() : 0)) * 31;
        String str23 = this.dId;
        return hashCode22 + (str23 != null ? str23.hashCode() : 0);
    }

    public final void i(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.vp = str;
    }

    public com.tencent.kuikly.core.nvi.serialization.json.e j() {
        Integer intOrNull;
        getCom.tencent.ark.ark.ARKMETADATA_JSON java.lang.String().v("id", this.id);
        getCom.tencent.ark.ark.ARKMETADATA_JSON java.lang.String().v("uid", this.uid);
        getCom.tencent.ark.ark.ARKMETADATA_JSON java.lang.String().v("aid", this.aId);
        getCom.tencent.ark.ark.ARKMETADATA_JSON java.lang.String().v(Utils.KEY_BUSINESS_ID, this.fId);
        getCom.tencent.ark.ark.ARKMETADATA_JSON java.lang.String().v("dId", this.dId);
        getCom.tencent.ark.ark.ARKMETADATA_JSON java.lang.String().v(MosaicConstants$JsProperty.PROP_ENV, this.env);
        getCom.tencent.ark.ark.ARKMETADATA_JSON java.lang.String().v("platform", this.platform);
        getCom.tencent.ark.ark.ARKMETADATA_JSON java.lang.String().v("netType", this.netType);
        getCom.tencent.ark.ark.ARKMETADATA_JSON java.lang.String().v("version", this.version);
        getCom.tencent.ark.ark.ARKMETADATA_JSON java.lang.String().v("frameworkVersion", this.frameworkVersion);
        getCom.tencent.ark.ark.ARKMETADATA_JSON java.lang.String().v("vp", this.vp);
        getCom.tencent.ark.ark.ARKMETADATA_JSON java.lang.String().v("sr", this.sr);
        getCom.tencent.ark.ark.ARKMETADATA_JSON java.lang.String().v("sessionId", this.sessionId);
        getCom.tencent.ark.ark.ARKMETADATA_JSON java.lang.String().v("from", this.from);
        getCom.tencent.ark.ark.ARKMETADATA_JSON java.lang.String().v(ISchemeApi.KEY_REFERER, this.referer);
        getCom.tencent.ark.ark.ARKMETADATA_JSON java.lang.String().v("type", this.type);
        getCom.tencent.ark.ark.ARKMETADATA_JSON java.lang.String().v("appVersion", this.appVersion);
        getCom.tencent.ark.ark.ARKMETADATA_JSON java.lang.String().v("osVersion", this.osVersion);
        getCom.tencent.ark.ark.ARKMETADATA_JSON java.lang.String().v("productVersion", this.productVersion);
        getCom.tencent.ark.ark.ARKMETADATA_JSON java.lang.String().v("abTags", this.abTags);
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = getCom.tencent.ark.ark.ARKMETADATA_JSON java.lang.String();
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(this.pageLoadStrategy);
        eVar.v("pageLoadStrategy", intOrNull);
        getCom.tencent.ark.ark.ARKMETADATA_JSON java.lang.String().v("brand", this.brand);
        getCom.tencent.ark.ark.ARKMETADATA_JSON java.lang.String().v("model", this.model);
        return getCom.tencent.ark.ark.ARKMETADATA_JSON java.lang.String();
    }

    public String k() {
        return j().toString();
    }

    public String toString() {
        return "AegisBean(id=" + this.id + ", uid=" + this.uid + ", version=" + this.version + ", frameworkVersion=" + this.frameworkVersion + ", aId=" + this.aId + ", fId=" + this.fId + ", env=" + this.env + ", platform=" + this.platform + ", netType=" + this.netType + ", vp=" + this.vp + ", sr=" + this.sr + ", sessionId=" + this.sessionId + ", from=" + this.from + ", referer=" + this.referer + ", type=" + this.type + ", appVersion=" + this.appVersion + ", osVersion=" + this.osVersion + ", productVersion=" + this.productVersion + ", abTags=" + this.abTags + ", pageLoadStrategy=" + this.pageLoadStrategy + ", brand=" + this.brand + ", model=" + this.model + ", dId=" + this.dId + ")";
    }

    public /* synthetic */ AegisBean(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) != 0 ? "" : str5, (i3 & 32) != 0 ? "" : str6, (i3 & 64) != 0 ? "production" : str7, (i3 & 128) != 0 ? "" : str8, (i3 & 256) != 0 ? "" : str9, (i3 & 512) != 0 ? "" : str10, (i3 & 1024) != 0 ? "" : str11, (i3 & 2048) != 0 ? "" : str12, (i3 & 4096) != 0 ? "" : str13, (i3 & 8192) != 0 ? "" : str14, (i3 & 16384) != 0 ? "" : str15, (i3 & 32768) != 0 ? "" : str16, (i3 & 65536) != 0 ? "" : str17, (i3 & 131072) != 0 ? "" : str18, (i3 & 262144) != 0 ? "" : str19, (i3 & 524288) != 0 ? PageLoadStrategy.CacheFetchLatest.getValue() : str20, (i3 & 1048576) != 0 ? "" : str21, (i3 & 2097152) != 0 ? "" : str22, (i3 & 4194304) != 0 ? "" : str23);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AegisBean)) {
            return false;
        }
        AegisBean aegisBean = (AegisBean) other;
        return Intrinsics.areEqual(this.id, aegisBean.id) && Intrinsics.areEqual(this.uid, aegisBean.uid) && Intrinsics.areEqual(this.version, aegisBean.version) && Intrinsics.areEqual(this.frameworkVersion, aegisBean.frameworkVersion) && Intrinsics.areEqual(this.aId, aegisBean.aId) && Intrinsics.areEqual(this.fId, aegisBean.fId) && Intrinsics.areEqual(this.env, aegisBean.env) && Intrinsics.areEqual(this.platform, aegisBean.platform) && Intrinsics.areEqual(this.netType, aegisBean.netType) && Intrinsics.areEqual(this.vp, aegisBean.vp) && Intrinsics.areEqual(this.sr, aegisBean.sr) && Intrinsics.areEqual(this.sessionId, aegisBean.sessionId) && Intrinsics.areEqual(this.from, aegisBean.from) && Intrinsics.areEqual(this.referer, aegisBean.referer) && Intrinsics.areEqual(this.type, aegisBean.type) && Intrinsics.areEqual(this.appVersion, aegisBean.appVersion) && Intrinsics.areEqual(this.osVersion, aegisBean.osVersion) && Intrinsics.areEqual(this.productVersion, aegisBean.productVersion) && Intrinsics.areEqual(this.abTags, aegisBean.abTags) && Intrinsics.areEqual(this.pageLoadStrategy, aegisBean.pageLoadStrategy) && Intrinsics.areEqual(this.brand, aegisBean.brand) && Intrinsics.areEqual(this.model, aegisBean.model) && Intrinsics.areEqual(this.dId, aegisBean.dId);
    }

    public AegisBean(String id5, String uid, String version, String frameworkVersion, String aId, String fId, String env, String platform, String netType, String vp5, String sr5, String sessionId, String from, String referer, String type, String appVersion, String osVersion, String productVersion, String abTags, String pageLoadStrategy, String brand, String model, String dId) {
        Intrinsics.checkNotNullParameter(id5, "id");
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
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(appVersion, "appVersion");
        Intrinsics.checkNotNullParameter(osVersion, "osVersion");
        Intrinsics.checkNotNullParameter(productVersion, "productVersion");
        Intrinsics.checkNotNullParameter(abTags, "abTags");
        Intrinsics.checkNotNullParameter(pageLoadStrategy, "pageLoadStrategy");
        Intrinsics.checkNotNullParameter(brand, "brand");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(dId, "dId");
        this.id = id5;
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
        this.type = type;
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
