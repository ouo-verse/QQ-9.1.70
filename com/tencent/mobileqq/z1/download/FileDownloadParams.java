package com.tencent.mobileqq.z1.download;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u001d\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\tB\u0081\u0001\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0016\b\u0002\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010,\u001a\u00020\u0007\u00a2\u0006\u0004\b-\u0010.J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R%\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\r\u0010\u0010R\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001c\u0010\u0010R$\u0010!\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u000e\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001f\u0010 R$\u0010'\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b\u001e\u0010$\"\u0004\b%\u0010&R$\u0010)\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\"\u0010\u0010\"\u0004\b(\u0010 R\u0017\u0010,\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010*\u001a\u0004\b\u0019\u0010+\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/z1/download/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "category", "b", "Ljava/lang/String;", "j", "()Ljava/lang/String;", "url", "", "c", "Ljava/util/Map;", "d", "()Ljava/util/Map;", "header", "filePath", "e", WadlProxyConsts.PARAM_FILENAME, "f", "i", "subCategoryName", "g", "k", "(Ljava/lang/String;)V", "srcBizScene", h.F, "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "l", "(Ljava/lang/Integer;)V", "srcModId", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "srcModName", "Z", "()Z", "needSaveToAlbum", "<init>", "(ILjava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Z)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.z1.download.a, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class FileDownloadParams {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int category;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String url;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Map<String, String> header;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String filePath;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String fileName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String subCategoryName;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String srcBizScene;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private Integer srcModId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String srcModName;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean needSaveToAlbum;

    public FileDownloadParams(int i3, @NotNull String url, @Nullable Map<String, String> map, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Integer num, @Nullable String str5, boolean z16) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.category = i3;
        this.url = url;
        this.header = map;
        this.filePath = str;
        this.fileName = str2;
        this.subCategoryName = str3;
        this.srcBizScene = str4;
        this.srcModId = num;
        this.srcModName = str5;
        this.needSaveToAlbum = z16;
    }

    /* renamed from: a, reason: from getter */
    public final int getCategory() {
        return this.category;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getFileName() {
        return this.fileName;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getFilePath() {
        return this.filePath;
    }

    @Nullable
    public final Map<String, String> d() {
        return this.header;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getNeedSaveToAlbum() {
        return this.needSaveToAlbum;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FileDownloadParams)) {
            return false;
        }
        FileDownloadParams fileDownloadParams = (FileDownloadParams) other;
        if (this.category == fileDownloadParams.category && Intrinsics.areEqual(this.url, fileDownloadParams.url) && Intrinsics.areEqual(this.header, fileDownloadParams.header) && Intrinsics.areEqual(this.filePath, fileDownloadParams.filePath) && Intrinsics.areEqual(this.fileName, fileDownloadParams.fileName) && Intrinsics.areEqual(this.subCategoryName, fileDownloadParams.subCategoryName) && Intrinsics.areEqual(this.srcBizScene, fileDownloadParams.srcBizScene) && Intrinsics.areEqual(this.srcModId, fileDownloadParams.srcModId) && Intrinsics.areEqual(this.srcModName, fileDownloadParams.srcModName) && this.needSaveToAlbum == fileDownloadParams.needSaveToAlbum) {
            return true;
        }
        return false;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final String getSrcBizScene() {
        return this.srcBizScene;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final Integer getSrcModId() {
        return this.srcModId;
    }

    @Nullable
    /* renamed from: h, reason: from getter */
    public final String getSrcModName() {
        return this.srcModName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7 = ((this.category * 31) + this.url.hashCode()) * 31;
        Map<String, String> map = this.header;
        int i3 = 0;
        if (map == null) {
            hashCode = 0;
        } else {
            hashCode = map.hashCode();
        }
        int i16 = (hashCode7 + hashCode) * 31;
        String str = this.filePath;
        if (str == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        String str2 = this.fileName;
        if (str2 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str2.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        String str3 = this.subCategoryName;
        if (str3 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str3.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        String str4 = this.srcBizScene;
        if (str4 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = str4.hashCode();
        }
        int i26 = (i19 + hashCode5) * 31;
        Integer num = this.srcModId;
        if (num == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = num.hashCode();
        }
        int i27 = (i26 + hashCode6) * 31;
        String str5 = this.srcModName;
        if (str5 != null) {
            i3 = str5.hashCode();
        }
        int i28 = (i27 + i3) * 31;
        boolean z16 = this.needSaveToAlbum;
        int i29 = z16;
        if (z16 != 0) {
            i29 = 1;
        }
        return i28 + i29;
    }

    @Nullable
    /* renamed from: i, reason: from getter */
    public final String getSubCategoryName() {
        return this.subCategoryName;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final void k(@Nullable String str) {
        this.srcBizScene = str;
    }

    public final void l(@Nullable Integer num) {
        this.srcModId = num;
    }

    public final void m(@Nullable String str) {
        this.srcModName = str;
    }

    @NotNull
    public String toString() {
        return "FileDownloadParams(category=" + this.category + ", url=" + this.url + ", header=" + this.header + ", filePath=" + this.filePath + ", fileName=" + this.fileName + ", subCategoryName=" + this.subCategoryName + ", srcBizScene=" + this.srcBizScene + ", srcModId=" + this.srcModId + ", srcModName=" + this.srcModName + ", needSaveToAlbum=" + this.needSaveToAlbum + ')';
    }

    public /* synthetic */ FileDownloadParams(int i3, String str, Map map, String str2, String str3, String str4, String str5, Integer num, String str6, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, str, (i16 & 4) != 0 ? null : map, (i16 & 8) != 0 ? "" : str2, (i16 & 16) != 0 ? "" : str3, (i16 & 32) != 0 ? "" : str4, (i16 & 64) != 0 ? "" : str5, (i16 & 128) != 0 ? 0 : num, (i16 & 256) != 0 ? "" : str6, (i16 & 512) != 0 ? false : z16);
    }
}
