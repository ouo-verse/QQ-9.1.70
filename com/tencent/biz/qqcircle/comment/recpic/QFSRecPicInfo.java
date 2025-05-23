package com.tencent.biz.qqcircle.comment.recpic;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@TypeConverters({v20.d.class, v20.a.class})
@Entity(tableName = "rec_pic_info_table")
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010!\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u0014\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001BY\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010'\u001a\b\u0012\u0004\u0012\u00020!0 \u0012\u000e\b\u0002\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00070 \u00a2\u0006\u0004\b3\u00104J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001R\"\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u001a\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001d\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\"\u0010\u001f\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u0014\u0010\u0017\"\u0004\b\u001e\u0010\u0019R(\u0010'\u001a\b\u0012\u0004\u0012\u00020!0 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R(\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00070 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\"\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\"\u0010,\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\n\u001a\u0004\b\t\u0010\f\"\u0004\b+\u0010\u000eR$\u00102\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010.\u001a\u0004\b\u0010\u0010/\"\u0004\b0\u00101\u00a8\u00065"}, d2 = {"Lcom/tencent/biz/qqcircle/comment/recpic/aj;", "", "other", "", "equals", "", "hashCode", "", "toString", "a", "Ljava/lang/String;", "e", "()Ljava/lang/String;", DomainData.DOMAIN_NAME, "(Ljava/lang/String;)V", "path", "b", "f", "o", "photoId", "c", "I", tl.h.F, "()I", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(I)V", AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, "d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mediaWidth", "l", "mediaHeight", "", "", "Ljava/util/List;", "g", "()Ljava/util/List;", "p", "(Ljava/util/List;)V", "similarityList", "i", "r", "typeList", "j", "cmtId", "", "[F", "()[F", "k", "([F)V", "imageFeature", "<init>", "(Ljava/lang/String;Ljava/lang/String;IIILjava/util/List;Ljava/util/List;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.biz.qqcircle.comment.recpic.aj, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class QFSRecPicInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String path;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @PrimaryKey
    @NotNull
    private String photoId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private int strategy;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int mediaWidth;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private int mediaHeight;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private List<Float> similarityList;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private List<String> typeList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Ignore
    @NotNull
    private String cmtId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Ignore
    @Nullable
    private float[] imageFeature;

    public QFSRecPicInfo() {
        this(null, null, 0, 0, 0, null, null, 127, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getCmtId() {
        return this.cmtId;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final float[] getImageFeature() {
        return this.imageFeature;
    }

    /* renamed from: c, reason: from getter */
    public final int getMediaHeight() {
        return this.mediaHeight;
    }

    /* renamed from: d, reason: from getter */
    public final int getMediaWidth() {
        return this.mediaWidth;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getPath() {
        return this.path;
    }

    public boolean equals(@Nullable Object other) {
        Class<?> cls;
        if (this == other) {
            return true;
        }
        if (other != null) {
            cls = other.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual(QFSRecPicInfo.class, cls)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.tencent.biz.qqcircle.comment.recpic.QFSRecPicInfo");
        QFSRecPicInfo qFSRecPicInfo = (QFSRecPicInfo) other;
        if (Intrinsics.areEqual(this.path, qFSRecPicInfo.path) && this.mediaWidth == qFSRecPicInfo.mediaWidth && this.mediaHeight == qFSRecPicInfo.mediaHeight && Intrinsics.areEqual(this.similarityList, qFSRecPicInfo.similarityList) && Intrinsics.areEqual(this.typeList, qFSRecPicInfo.typeList) && Arrays.equals(this.imageFeature, qFSRecPicInfo.imageFeature)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getPhotoId() {
        return this.photoId;
    }

    @NotNull
    public final List<Float> g() {
        return this.similarityList;
    }

    /* renamed from: h, reason: from getter */
    public final int getStrategy() {
        return this.strategy;
    }

    public int hashCode() {
        return (((((((((this.path.hashCode() * 31) + this.mediaWidth) * 31) + this.mediaHeight) * 31) + this.similarityList.hashCode()) * 31) + this.typeList.hashCode()) * 31) + Arrays.hashCode(this.imageFeature);
    }

    @NotNull
    public final List<String> i() {
        return this.typeList;
    }

    public final void j(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cmtId = str;
    }

    public final void k(@Nullable float[] fArr) {
        this.imageFeature = fArr;
    }

    public final void l(int i3) {
        this.mediaHeight = i3;
    }

    public final void m(int i3) {
        this.mediaWidth = i3;
    }

    public final void n(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.path = str;
    }

    public final void o(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.photoId = str;
    }

    public final void p(@NotNull List<Float> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.similarityList = list;
    }

    public final void q(int i3) {
        this.strategy = i3;
    }

    public final void r(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.typeList = list;
    }

    @NotNull
    public String toString() {
        return "QFSRecPicInfo(path=" + this.path + ", photoId=" + this.photoId + ", strategy=" + this.strategy + ", mediaWidth=" + this.mediaWidth + ", mediaHeight=" + this.mediaHeight + ", similarityList=" + this.similarityList + ", typeList=" + this.typeList + ")";
    }

    public QFSRecPicInfo(@NotNull String path, @NotNull String photoId, int i3, int i16, int i17, @NotNull List<Float> similarityList, @NotNull List<String> typeList) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(photoId, "photoId");
        Intrinsics.checkNotNullParameter(similarityList, "similarityList");
        Intrinsics.checkNotNullParameter(typeList, "typeList");
        this.path = path;
        this.photoId = photoId;
        this.strategy = i3;
        this.mediaWidth = i16;
        this.mediaHeight = i17;
        this.similarityList = similarityList;
        this.typeList = typeList;
        this.cmtId = "";
    }

    public /* synthetic */ QFSRecPicInfo(String str, String str2, int i3, int i16, int i17, List list, List list2, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? "" : str, (i18 & 2) == 0 ? str2 : "", (i18 & 4) != 0 ? 0 : i3, (i18 & 8) != 0 ? 0 : i16, (i18 & 16) != 0 ? 0 : i17, (i18 & 32) != 0 ? new ArrayList() : list, (i18 & 64) != 0 ? new ArrayList() : list2);
    }
}
