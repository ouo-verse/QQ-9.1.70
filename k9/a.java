package k9;

import aa.e;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStImage;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.common.convert.bean.CommonStPicSpecUrlEntry;
import com.qzone.reborn.albumx.common.convert.bean.CommonStPicUrl;
import com.qzone.reborn.albumx.common.convert.enumtype.CommonEnumMediaType;
import com.qzone.reborn.albumx.common.convert.enumtype.CommonEnumPhotoSpec;
import com.tencent.mobileqq.profilecard.bussiness.qzone.BaseProfileQZoneComponent;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u001a\u0014\u0010\u0006\u001a\u00020\u0003*\u00020\u00052\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u001a\u0014\u0010\b\u001a\u00020\u0003*\u00020\u00072\b\b\u0002\u0010\u0002\u001a\u00020\u0001\u001a\f\u0010\u000b\u001a\u00020\n*\u0004\u0018\u00010\t\u001a\u000e\u0010\f\u001a\u0004\u0018\u00010\t*\u0004\u0018\u00010\u0000\u001a\n\u0010\r\u001a\u00020\u0003*\u00020\u0005\u001a\u000e\u0010\u000e\u001a\u0004\u0018\u00010\t*\u0004\u0018\u00010\u0007\"\u0015\u0010\u0011\u001a\u00020\n*\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0015\u0010\u0013\u001a\u00020\n*\u00020\u00058F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "", "photoSpec", "", "a", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "c", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStImage;", "b", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStPicUrl;", "", "i", "f", "g", "k", h.F, "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;)Z", "isImage", "j", BaseProfileQZoneComponent.KEY_IS_VIDEO, "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {
    public static final String a(CommonAlbumInfo commonAlbumInfo, int i3) {
        Intrinsics.checkNotNullParameter(commonAlbumInfo, "<this>");
        return c(commonAlbumInfo.getCover(), i3);
    }

    public static final String b(CommonStImage commonStImage, int i3) {
        boolean z16;
        String str;
        Object obj;
        Object orNull;
        CommonStPicUrl url;
        String url2;
        CommonStPicUrl url3;
        Intrinsics.checkNotNullParameter(commonStImage, "<this>");
        Iterator<T> it = commonStImage.e().iterator();
        while (true) {
            z16 = true;
            str = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((CommonStPicSpecUrlEntry) obj).getSpec() == i3) {
                break;
            }
        }
        CommonStPicSpecUrlEntry commonStPicSpecUrlEntry = (CommonStPicSpecUrlEntry) obj;
        if (commonStPicSpecUrlEntry != null && (url3 = commonStPicSpecUrlEntry.getUrl()) != null) {
            str = url3.getUrl();
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        }
        if (!z16) {
            return str;
        }
        orNull = CollectionsKt___CollectionsKt.getOrNull(commonStImage.e(), 0);
        CommonStPicSpecUrlEntry commonStPicSpecUrlEntry2 = (CommonStPicSpecUrlEntry) orNull;
        return (commonStPicSpecUrlEntry2 == null || (url = commonStPicSpecUrlEntry2.getUrl()) == null || (url2 = url.getUrl()) == null) ? "" : url2;
    }

    public static final String c(CommonStMedia commonStMedia, int i3) {
        Intrinsics.checkNotNullParameter(commonStMedia, "<this>");
        if (h(commonStMedia)) {
            return b(commonStMedia.getImage(), i3);
        }
        if (j(commonStMedia)) {
            return b(commonStMedia.getVideo().getCover(), i3);
        }
        return "";
    }

    public static final String g(CommonStMedia commonStMedia) {
        CommonStPicUrl k3;
        String url;
        Intrinsics.checkNotNullParameter(commonStMedia, "<this>");
        if (h(commonStMedia)) {
            CommonStPicUrl k16 = k(commonStMedia.getImage());
            if (k16 == null || (url = k16.getUrl()) == null) {
                return "";
            }
        } else if (!j(commonStMedia) || (k3 = k(commonStMedia.getVideo().getCover())) == null || (url = k3.getUrl()) == null) {
            return "";
        }
        return url;
    }

    public static final boolean h(CommonStMedia commonStMedia) {
        Intrinsics.checkNotNullParameter(commonStMedia, "<this>");
        return commonStMedia.getType() == CommonEnumMediaType.IMAGE.ordinal();
    }

    public static final boolean j(CommonStMedia commonStMedia) {
        Intrinsics.checkNotNullParameter(commonStMedia, "<this>");
        return commonStMedia.getType() == CommonEnumMediaType.VIDEO.ordinal();
    }

    public static final boolean i(CommonStPicUrl commonStPicUrl) {
        if (commonStPicUrl == null) {
            return false;
        }
        String url = commonStPicUrl.getUrl();
        return !(url == null || url.length() == 0);
    }

    public static /* synthetic */ String d(CommonAlbumInfo commonAlbumInfo, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = CommonEnumPhotoSpec.PHOTO_SPEC_ORIGIN.ordinal();
        }
        return a(commonAlbumInfo, i3);
    }

    public static /* synthetic */ String e(CommonStMedia commonStMedia, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = CommonEnumPhotoSpec.PHOTO_SPEC_ORIGIN.ordinal();
        }
        return c(commonStMedia, i3);
    }

    public static final CommonStPicUrl f(CommonAlbumInfo commonAlbumInfo) {
        CommonStImage image;
        if (commonAlbumInfo == null) {
            return null;
        }
        if (j(commonAlbumInfo.getCover())) {
            image = commonAlbumInfo.getCover().getVideo().getCover();
        } else {
            image = commonAlbumInfo.getCover().getImage();
        }
        return k(image);
    }

    public static final CommonStPicUrl k(CommonStImage commonStImage) {
        if (commonStImage == null) {
            return null;
        }
        if (i(commonStImage.getDefaultUrl())) {
            return commonStImage.getDefaultUrl();
        }
        return e.a(commonStImage.e());
    }
}
