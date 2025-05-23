package com.qzone.publish.business.model.groupalbum;

import com.qzone.album.data.model.PhotoCategorySinglePicInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseMeta$StImage;
import qzone.QZoneBaseMeta$StMedia;
import qzone.QZoneBaseMeta$StPicSpecUrlEntry;
import qzone.QZoneBaseMeta$StPicUrl;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\b\u0018\u0000 /2\u00020\u0001:\u00010BC\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u00a2\u0006\u0004\b-\u0010.J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\t\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\t\u001a\u00020\bH\u00c6\u0003J\t\u0010\n\u001a\u00020\bH\u00c6\u0003J\t\u0010\u000b\u001a\u00020\bH\u00c6\u0003J\t\u0010\f\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0006H\u00c6\u0003JE\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0010\u001a\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u0006H\u00c6\u0001J\t\u0010\u0015\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u00d6\u0003R\"\u0010\u000e\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010\u0010\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010 \u001a\u0004\b%\u0010\"\"\u0004\b&\u0010$R\"\u0010\u0011\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010 \u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R\"\u0010\u0012\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u001b\u001a\u0004\b)\u0010\u001d\"\u0004\b*\u0010\u001fR\"\u0010\u0013\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u001b\u001a\u0004\b+\u0010\u001d\"\u0004\b,\u0010\u001f\u00a8\u00061"}, d2 = {"Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadImageResult;", "Ljava/io/Serializable;", "Lqzone/QZoneBaseMeta$StMedia;", "toStMedia", "Lqzone/QZoneBaseMeta$StImage;", "toStImage", "", "component1", "", "component2", "component3", "component4", "component5", "component6", "url", "width", "height", "spec", "lloc", PhotoCategorySinglePicInfo.SLOC, "copy", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "I", "getWidth", "()I", "setWidth", "(I)V", "getHeight", "setHeight", "getSpec", "setSpec", "getLloc", "setLloc", "getSloc", "setSloc", "<init>", "(Ljava/lang/String;IIILjava/lang/String;Ljava/lang/String;)V", "Companion", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final /* data */ class GroupAlbumUploadImageResult implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long serialVersionUID = -2203078732665558774L;
    private int height;
    private String lloc;
    private String sloc;
    private int spec;
    private String url;
    private int width;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadImageResult$a;", "", "Lqzone/QZoneBaseMeta$StImage;", "image", "Lcom/qzone/publish/business/model/groupalbum/GroupAlbumUploadImageResult;", "a", "", "serialVersionUID", "J", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.publish.business.model.groupalbum.GroupAlbumUploadImageResult$a, reason: from kotlin metadata */
    /* loaded from: classes39.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GroupAlbumUploadImageResult a(QZoneBaseMeta$StImage image) {
            Object firstOrNull;
            Intrinsics.checkNotNullParameter(image, "image");
            String str = image.lloc.get();
            Intrinsics.checkNotNullExpressionValue(str, "image.lloc.get()");
            String str2 = image.sloc.get();
            Intrinsics.checkNotNullExpressionValue(str2, "image.sloc.get()");
            GroupAlbumUploadImageResult groupAlbumUploadImageResult = new GroupAlbumUploadImageResult(null, 0, 0, 0, str, str2, 15, null);
            List<QZoneBaseMeta$StPicSpecUrlEntry> list = image.photo_url.get();
            Intrinsics.checkNotNullExpressionValue(list, "image.photo_url.get()");
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
            QZoneBaseMeta$StPicSpecUrlEntry qZoneBaseMeta$StPicSpecUrlEntry = (QZoneBaseMeta$StPicSpecUrlEntry) firstOrNull;
            if (qZoneBaseMeta$StPicSpecUrlEntry != null) {
                groupAlbumUploadImageResult.setSpec(qZoneBaseMeta$StPicSpecUrlEntry.spec.get());
                String str3 = qZoneBaseMeta$StPicSpecUrlEntry.url.url.get();
                Intrinsics.checkNotNullExpressionValue(str3, "it.url.url.get()");
                groupAlbumUploadImageResult.setUrl(str3);
                groupAlbumUploadImageResult.setWidth(qZoneBaseMeta$StPicSpecUrlEntry.url.width.get());
                groupAlbumUploadImageResult.setHeight(qZoneBaseMeta$StPicSpecUrlEntry.url.height.get());
            }
            return groupAlbumUploadImageResult;
        }

        Companion() {
        }
    }

    public GroupAlbumUploadImageResult() {
        this(null, 0, 0, 0, null, null, 63, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component2, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* renamed from: component3, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: component4, reason: from getter */
    public final int getSpec() {
        return this.spec;
    }

    /* renamed from: component5, reason: from getter */
    public final String getLloc() {
        return this.lloc;
    }

    /* renamed from: component6, reason: from getter */
    public final String getSloc() {
        return this.sloc;
    }

    public final GroupAlbumUploadImageResult copy(String url, int width, int height, int spec, String lloc, String sloc) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(lloc, "lloc");
        Intrinsics.checkNotNullParameter(sloc, "sloc");
        return new GroupAlbumUploadImageResult(url, width, height, spec, lloc, sloc);
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getLloc() {
        return this.lloc;
    }

    public final String getSloc() {
        return this.sloc;
    }

    public final int getSpec() {
        return this.spec;
    }

    public final String getUrl() {
        return this.url;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (((((((((this.url.hashCode() * 31) + this.width) * 31) + this.height) * 31) + this.spec) * 31) + this.lloc.hashCode()) * 31) + this.sloc.hashCode();
    }

    public final void setHeight(int i3) {
        this.height = i3;
    }

    public final void setLloc(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.lloc = str;
    }

    public final void setSloc(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.sloc = str;
    }

    public final void setSpec(int i3) {
        this.spec = i3;
    }

    public final void setUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    public final void setWidth(int i3) {
        this.width = i3;
    }

    public final QZoneBaseMeta$StImage toStImage() {
        List<QZoneBaseMeta$StPicSpecUrlEntry> listOf;
        QZoneBaseMeta$StImage qZoneBaseMeta$StImage = new QZoneBaseMeta$StImage();
        QZoneBaseMeta$StPicUrl qZoneBaseMeta$StPicUrl = new QZoneBaseMeta$StPicUrl();
        qZoneBaseMeta$StPicUrl.url.set(this.url);
        qZoneBaseMeta$StPicUrl.width.set(this.width);
        qZoneBaseMeta$StPicUrl.height.set(this.height);
        QZoneBaseMeta$StPicSpecUrlEntry qZoneBaseMeta$StPicSpecUrlEntry = new QZoneBaseMeta$StPicSpecUrlEntry();
        qZoneBaseMeta$StPicSpecUrlEntry.url.set(qZoneBaseMeta$StPicUrl);
        qZoneBaseMeta$StPicSpecUrlEntry.spec.set(this.spec);
        PBRepeatMessageField<QZoneBaseMeta$StPicSpecUrlEntry> pBRepeatMessageField = qZoneBaseMeta$StImage.photo_url;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(qZoneBaseMeta$StPicSpecUrlEntry);
        pBRepeatMessageField.set(listOf);
        qZoneBaseMeta$StImage.lloc.set(this.lloc);
        qZoneBaseMeta$StImage.sloc.set(this.sloc);
        return qZoneBaseMeta$StImage;
    }

    public final QZoneBaseMeta$StMedia toStMedia() {
        QZoneBaseMeta$StMedia qZoneBaseMeta$StMedia = new QZoneBaseMeta$StMedia();
        qZoneBaseMeta$StMedia.type.set(0);
        qZoneBaseMeta$StMedia.image.set(toStImage());
        return qZoneBaseMeta$StMedia;
    }

    public String toString() {
        return "GroupAlbumUploadImageResult(url=" + this.url + ", width=" + this.width + ", height=" + this.height + ", spec=" + this.spec + ", lloc=" + this.lloc + ", sloc=" + this.sloc + ")";
    }

    public GroupAlbumUploadImageResult(String url, int i3, int i16, int i17, String lloc, String sloc) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(lloc, "lloc");
        Intrinsics.checkNotNullParameter(sloc, "sloc");
        this.url = url;
        this.width = i3;
        this.height = i16;
        this.spec = i17;
        this.lloc = lloc;
        this.sloc = sloc;
    }

    public static /* synthetic */ GroupAlbumUploadImageResult copy$default(GroupAlbumUploadImageResult groupAlbumUploadImageResult, String str, int i3, int i16, int i17, String str2, String str3, int i18, Object obj) {
        if ((i18 & 1) != 0) {
            str = groupAlbumUploadImageResult.url;
        }
        if ((i18 & 2) != 0) {
            i3 = groupAlbumUploadImageResult.width;
        }
        int i19 = i3;
        if ((i18 & 4) != 0) {
            i16 = groupAlbumUploadImageResult.height;
        }
        int i26 = i16;
        if ((i18 & 8) != 0) {
            i17 = groupAlbumUploadImageResult.spec;
        }
        int i27 = i17;
        if ((i18 & 16) != 0) {
            str2 = groupAlbumUploadImageResult.lloc;
        }
        String str4 = str2;
        if ((i18 & 32) != 0) {
            str3 = groupAlbumUploadImageResult.sloc;
        }
        return groupAlbumUploadImageResult.copy(str, i19, i26, i27, str4, str3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GroupAlbumUploadImageResult)) {
            return false;
        }
        GroupAlbumUploadImageResult groupAlbumUploadImageResult = (GroupAlbumUploadImageResult) other;
        return Intrinsics.areEqual(this.url, groupAlbumUploadImageResult.url) && this.width == groupAlbumUploadImageResult.width && this.height == groupAlbumUploadImageResult.height && this.spec == groupAlbumUploadImageResult.spec && Intrinsics.areEqual(this.lloc, groupAlbumUploadImageResult.lloc) && Intrinsics.areEqual(this.sloc, groupAlbumUploadImageResult.sloc);
    }

    public /* synthetic */ GroupAlbumUploadImageResult(String str, int i3, int i16, int i17, String str2, String str3, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? "" : str, (i18 & 2) != 0 ? -1 : i3, (i18 & 4) != 0 ? -1 : i16, (i18 & 8) == 0 ? i17 : -1, (i18 & 16) != 0 ? "" : str2, (i18 & 32) != 0 ? "" : str3);
    }
}
