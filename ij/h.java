package ij;

import com.tencent.mobileqq.pb.PBStringField;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseAlbumMeta$AlbumInfo;
import qzone.QZoneBaseMeta$StImage;
import qzone.QZoneBaseMeta$StMedia;
import qzone.QZoneBaseMeta$StPicSpecUrlEntry;
import qzone.QZoneBaseMeta$StPicUrl;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u001a\u0014\u0010\u0006\u001a\u00020\u0003*\u00020\u00052\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u001a\u0014\u0010\b\u001a\u00020\u0003*\u00020\u00072\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u001a\u000e\u0010\n\u001a\u0004\u0018\u00010\t*\u0004\u0018\u00010\u0007\u001a\u000e\u0010\u000b\u001a\u0004\u0018\u00010\t*\u0004\u0018\u00010\u0000\u001a\f\u0010\r\u001a\u00020\f*\u0004\u0018\u00010\t\u00a8\u0006\u000e"}, d2 = {"Lqzone/QZoneBaseAlbumMeta$AlbumInfo;", "", "photoSpec", "", "a", "Lqzone/QZoneBaseMeta$StMedia;", "c", "Lqzone/QZoneBaseMeta$StImage;", "b", "Lqzone/QZoneBaseMeta$StPicUrl;", "g", "e", "", "f", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class h {
    public static final String a(QZoneBaseAlbumMeta$AlbumInfo qZoneBaseAlbumMeta$AlbumInfo, int i3) {
        Intrinsics.checkNotNullParameter(qZoneBaseAlbumMeta$AlbumInfo, "<this>");
        QZoneBaseMeta$StMedia cover = qZoneBaseAlbumMeta$AlbumInfo.cover;
        Intrinsics.checkNotNullExpressionValue(cover, "cover");
        return c(cover, i3);
    }

    public static final String b(QZoneBaseMeta$StImage qZoneBaseMeta$StImage, int i3) {
        String str;
        Object obj;
        Object orNull;
        QZoneBaseMeta$StPicUrl qZoneBaseMeta$StPicUrl;
        PBStringField pBStringField;
        QZoneBaseMeta$StPicUrl qZoneBaseMeta$StPicUrl2;
        PBStringField pBStringField2;
        String str2;
        Intrinsics.checkNotNullParameter(qZoneBaseMeta$StImage, "<this>");
        List<QZoneBaseMeta$StPicSpecUrlEntry> list = qZoneBaseMeta$StImage.photo_url.get();
        Intrinsics.checkNotNullExpressionValue(list, "photo_url.get()");
        Iterator<T> it = list.iterator();
        while (true) {
            str = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((QZoneBaseMeta$StPicSpecUrlEntry) obj).spec.get() == i3) {
                break;
            }
        }
        QZoneBaseMeta$StPicSpecUrlEntry qZoneBaseMeta$StPicSpecUrlEntry = (QZoneBaseMeta$StPicSpecUrlEntry) obj;
        if (qZoneBaseMeta$StPicSpecUrlEntry != null && (qZoneBaseMeta$StPicUrl2 = qZoneBaseMeta$StPicSpecUrlEntry.url) != null && (pBStringField2 = qZoneBaseMeta$StPicUrl2.url) != null && (str2 = pBStringField2.get()) != null) {
            return str2;
        }
        List<QZoneBaseMeta$StPicSpecUrlEntry> list2 = qZoneBaseMeta$StImage.photo_url.get();
        Intrinsics.checkNotNullExpressionValue(list2, "photo_url.get()");
        orNull = CollectionsKt___CollectionsKt.getOrNull(list2, 0);
        QZoneBaseMeta$StPicSpecUrlEntry qZoneBaseMeta$StPicSpecUrlEntry2 = (QZoneBaseMeta$StPicSpecUrlEntry) orNull;
        if (qZoneBaseMeta$StPicSpecUrlEntry2 != null && (qZoneBaseMeta$StPicUrl = qZoneBaseMeta$StPicSpecUrlEntry2.url) != null && (pBStringField = qZoneBaseMeta$StPicUrl.url) != null) {
            str = pBStringField.get();
        }
        return str == null ? "" : str;
    }

    public static final String c(QZoneBaseMeta$StMedia qZoneBaseMeta$StMedia, int i3) {
        Intrinsics.checkNotNullParameter(qZoneBaseMeta$StMedia, "<this>");
        if (com.qzone.publish.business.publishqueue.intimate.b.c(qZoneBaseMeta$StMedia)) {
            QZoneBaseMeta$StImage image = qZoneBaseMeta$StMedia.image;
            Intrinsics.checkNotNullExpressionValue(image, "image");
            return b(image, i3);
        }
        if (com.qzone.publish.business.publishqueue.intimate.b.d(qZoneBaseMeta$StMedia)) {
            QZoneBaseMeta$StImage qZoneBaseMeta$StImage = qZoneBaseMeta$StMedia.video.cover;
            Intrinsics.checkNotNullExpressionValue(qZoneBaseMeta$StImage, "video.cover");
            return b(qZoneBaseMeta$StImage, i3);
        }
        return "";
    }

    public static final boolean f(QZoneBaseMeta$StPicUrl qZoneBaseMeta$StPicUrl) {
        if (qZoneBaseMeta$StPicUrl == null) {
            return false;
        }
        String str = qZoneBaseMeta$StPicUrl.url.get();
        return !(str == null || str.length() == 0);
    }

    public static final QZoneBaseMeta$StPicUrl e(QZoneBaseAlbumMeta$AlbumInfo qZoneBaseAlbumMeta$AlbumInfo) {
        QZoneBaseMeta$StImage qZoneBaseMeta$StImage;
        if (qZoneBaseAlbumMeta$AlbumInfo == null) {
            return null;
        }
        QZoneBaseMeta$StMedia qZoneBaseMeta$StMedia = qZoneBaseAlbumMeta$AlbumInfo.cover;
        Intrinsics.checkNotNullExpressionValue(qZoneBaseMeta$StMedia, "this.cover");
        if (com.qzone.publish.business.publishqueue.intimate.b.d(qZoneBaseMeta$StMedia)) {
            qZoneBaseMeta$StImage = qZoneBaseAlbumMeta$AlbumInfo.cover.video.cover;
            Intrinsics.checkNotNullExpressionValue(qZoneBaseMeta$StImage, "this.cover.video.cover");
        } else {
            qZoneBaseMeta$StImage = qZoneBaseAlbumMeta$AlbumInfo.cover.image;
            Intrinsics.checkNotNullExpressionValue(qZoneBaseMeta$StImage, "this.cover.image");
        }
        return g(qZoneBaseMeta$StImage);
    }

    public static final QZoneBaseMeta$StPicUrl g(QZoneBaseMeta$StImage qZoneBaseMeta$StImage) {
        if (qZoneBaseMeta$StImage == null) {
            return null;
        }
        if (f(qZoneBaseMeta$StImage.default_url.get())) {
            return qZoneBaseMeta$StImage.default_url.get();
        }
        return mk.c.f416874a.a(qZoneBaseMeta$StImage.photo_url.get());
    }

    public static /* synthetic */ String d(QZoneBaseAlbumMeta$AlbumInfo qZoneBaseAlbumMeta$AlbumInfo, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 0;
        }
        return a(qZoneBaseAlbumMeta$AlbumInfo, i3);
    }
}
