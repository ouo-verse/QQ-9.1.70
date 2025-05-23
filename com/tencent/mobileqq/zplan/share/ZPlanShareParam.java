package com.tencent.mobileqq.zplan.share;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0004\u0012\b\b\u0002\u0010\n\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0010\u00a2\u0006\u0004\b)\u0010*J\u0006\u0010\u0003\u001a\u00020\u0002J\u008b\u0001\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0010H\u00c6\u0001J\t\u0010\u0013\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0007\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0017\u001a\u0004\b\u001e\u0010\u0019R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0017\u001a\u0004\b \u0010\u0019R\u0017\u0010\n\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u0017\u001a\u0004\b\"\u0010\u0019R\u0017\u0010\u000b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u0017\u001a\u0004\b#\u0010\u0019R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b$\u0010\u001dR\u0019\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001b\u001a\u0004\b%\u0010\u001dR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u001b\u001a\u0004\b\u001f\u0010\u001dR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b&\u0010\u001b\u001a\u0004\b!\u0010\u001dR#\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00108\u0006\u00a2\u0006\f\n\u0004\b$\u0010'\u001a\u0004\b&\u0010(\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/zplan/share/e;", "", "", DomainData.DOMAIN_NAME, "", "contentType", "", "path", "width", "height", "duration", "requestCode", "thumbPath", "title", "desc", "directMessage", "", "shareExtraParams", "a", "toString", "hashCode", "other", "equals", "I", "c", "()I", "b", "Ljava/lang/String;", tl.h.F, "()Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "d", "g", "e", "f", "i", "k", "l", "j", "Ljava/util/Map;", "()Ljava/util/Map;", "<init>", "(ILjava/lang/String;IIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.zplan.share.e, reason: from toString */
/* loaded from: classes34.dex */
public final /* data */ class ZPlanShareParam {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int contentType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final String path;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int width;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int height;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int duration;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int requestCode;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final String thumbPath;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final String title;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final String desc;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private final String directMessage;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private final Map<String, Object> shareExtraParams;

    public ZPlanShareParam(int i3, String path, int i16, int i17, int i18, int i19, String str, String str2, String str3, String str4, Map<String, ? extends Object> shareExtraParams) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(shareExtraParams, "shareExtraParams");
        this.contentType = i3;
        this.path = path;
        this.width = i16;
        this.height = i17;
        this.duration = i18;
        this.requestCode = i19;
        this.thumbPath = str;
        this.title = str2;
        this.desc = str3;
        this.directMessage = str4;
        this.shareExtraParams = shareExtraParams;
    }

    public final ZPlanShareParam a(int contentType, String path, int width, int height, int duration, int requestCode, String thumbPath, String title, String desc, String directMessage, Map<String, ? extends Object> shareExtraParams) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(shareExtraParams, "shareExtraParams");
        return new ZPlanShareParam(contentType, path, width, height, duration, requestCode, thumbPath, title, desc, directMessage, shareExtraParams);
    }

    /* renamed from: c, reason: from getter */
    public final int getContentType() {
        return this.contentType;
    }

    /* renamed from: d, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    /* renamed from: e, reason: from getter */
    public final String getDirectMessage() {
        return this.directMessage;
    }

    /* renamed from: f, reason: from getter */
    public final int getDuration() {
        return this.duration;
    }

    /* renamed from: g, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: h, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.contentType * 31) + this.path.hashCode()) * 31) + this.width) * 31) + this.height) * 31) + this.duration) * 31) + this.requestCode) * 31;
        String str = this.thumbPath;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.title;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.desc;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.directMessage;
        return ((hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31) + this.shareExtraParams.hashCode();
    }

    /* renamed from: i, reason: from getter */
    public final int getRequestCode() {
        return this.requestCode;
    }

    public final Map<String, Object> j() {
        return this.shareExtraParams;
    }

    /* renamed from: k, reason: from getter */
    public final String getThumbPath() {
        return this.thumbPath;
    }

    /* renamed from: l, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: m, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    public final boolean n() {
        int i3 = this.contentType;
        return i3 == 2 || i3 == 3;
    }

    public String toString() {
        return "ZPlanShareParam(contentType=" + this.contentType + ", path=" + this.path + ", width=" + this.width + ", height=" + this.height + ", duration=" + this.duration + ", requestCode=" + this.requestCode + ", thumbPath=" + this.thumbPath + ", title=" + this.title + ", desc=" + this.desc + ", directMessage=" + this.directMessage + ", shareExtraParams=" + this.shareExtraParams + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanShareParam)) {
            return false;
        }
        ZPlanShareParam zPlanShareParam = (ZPlanShareParam) other;
        return this.contentType == zPlanShareParam.contentType && Intrinsics.areEqual(this.path, zPlanShareParam.path) && this.width == zPlanShareParam.width && this.height == zPlanShareParam.height && this.duration == zPlanShareParam.duration && this.requestCode == zPlanShareParam.requestCode && Intrinsics.areEqual(this.thumbPath, zPlanShareParam.thumbPath) && Intrinsics.areEqual(this.title, zPlanShareParam.title) && Intrinsics.areEqual(this.desc, zPlanShareParam.desc) && Intrinsics.areEqual(this.directMessage, zPlanShareParam.directMessage) && Intrinsics.areEqual(this.shareExtraParams, zPlanShareParam.shareExtraParams);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ZPlanShareParam(int i3, String str, int i16, int i17, int i18, int i19, String str2, String str3, String str4, String str5, Map map, int i26, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, r6, r7, r8, r9, str2, r11, r12, r13, r14);
        Map map2;
        Map emptyMap;
        int i27 = (i26 & 4) != 0 ? 0 : i16;
        int i28 = (i26 & 8) != 0 ? 0 : i17;
        int i29 = (i26 & 16) != 0 ? 0 : i18;
        int i36 = (i26 & 32) != 0 ? 0 : i19;
        String str6 = (i26 & 128) != 0 ? "" : str3;
        String str7 = (i26 & 256) != 0 ? "" : str4;
        String str8 = (i26 & 512) != 0 ? "" : str5;
        if ((i26 & 1024) != 0) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            map2 = emptyMap;
        } else {
            map2 = map;
        }
    }
}
