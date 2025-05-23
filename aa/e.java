package aa;

import android.text.TextUtils;
import com.qzone.reborn.albumx.common.convert.bean.CommonStImage;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.common.convert.bean.CommonStPicSpecUrlEntry;
import com.qzone.reborn.albumx.common.convert.bean.CommonStPicUrl;
import com.qzone.reborn.albumx.common.convert.bean.CommonStVideo;
import com.qzone.reborn.albumx.common.convert.enumtype.CommonEnumMediaType;
import com.qzone.reborn.albumx.common.convert.enumtype.CommonEnumPhotoSpec;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0007J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J \u0010\u000e\u001a\u0004\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\fJ \u0010\u000f\u001a\u0004\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\fJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\u0014"}, d2 = {"Laa/e;", "", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", QAdVrReportParams.ParamKey.MEDIA, "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStPicUrl;", "c", "", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStPicSpecUrlEntry;", "urlEntryList", "a", "", "f", "Lcom/qzone/reborn/albumx/common/convert/enumtype/CommonEnumPhotoSpec;", "photoSpec", "e", "d", "", "b", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f25753a = new e();

    e() {
    }

    @JvmStatic
    public static final CommonStPicUrl a(List<CommonStPicSpecUrlEntry> urlEntryList) {
        e eVar = f25753a;
        CommonStPicUrl d16 = eVar.d(urlEntryList, CommonEnumPhotoSpec.PHOTO_SPEC_CURRENT);
        if (!k9.a.i(d16)) {
            d16 = eVar.d(urlEntryList, CommonEnumPhotoSpec.PHOTO_SPEC_BIG);
        }
        if (!k9.a.i(d16)) {
            d16 = eVar.d(urlEntryList, CommonEnumPhotoSpec.PHOTO_SPEC_DOWNLOAD);
        }
        return !k9.a.i(d16) ? eVar.d(urlEntryList, CommonEnumPhotoSpec.PHOTO_SPEC_ORIGIN) : d16;
    }

    public final CommonStPicUrl d(List<CommonStPicSpecUrlEntry> urlEntryList, CommonEnumPhotoSpec photoSpec) {
        Intrinsics.checkNotNullParameter(photoSpec, "photoSpec");
        if (urlEntryList == null) {
            return null;
        }
        CommonStPicUrl commonStPicUrl = null;
        for (CommonStPicSpecUrlEntry commonStPicSpecUrlEntry : urlEntryList) {
            if (commonStPicSpecUrlEntry.getSpec() == photoSpec.ordinal()) {
                CommonStPicUrl url = commonStPicSpecUrlEntry.getUrl();
                if (!TextUtils.isEmpty(url != null ? url.getUrl() : null)) {
                    return commonStPicSpecUrlEntry.getUrl();
                }
            }
            if (commonStPicUrl == null) {
                CommonStPicUrl url2 = commonStPicSpecUrlEntry.getUrl();
                if (!TextUtils.isEmpty(url2 != null ? url2.getUrl() : null)) {
                    commonStPicUrl = commonStPicSpecUrlEntry.getUrl();
                }
            }
        }
        return commonStPicUrl;
    }

    public final CommonStPicUrl e(List<CommonStPicSpecUrlEntry> urlEntryList, CommonEnumPhotoSpec photoSpec) {
        Intrinsics.checkNotNullParameter(photoSpec, "photoSpec");
        if (urlEntryList == null) {
            return null;
        }
        CommonStPicUrl commonStPicUrl = null;
        for (CommonStPicSpecUrlEntry commonStPicSpecUrlEntry : urlEntryList) {
            if (commonStPicSpecUrlEntry.getSpec() == photoSpec.ordinal()) {
                CommonStPicUrl url = commonStPicSpecUrlEntry.getUrl();
                if (!TextUtils.isEmpty(url != null ? url.getUrl() : null)) {
                    return commonStPicSpecUrlEntry.getUrl();
                }
            }
            if (commonStPicSpecUrlEntry.getSpec() == CommonEnumPhotoSpec.PHOTO_SPEC_BIG.ordinal()) {
                CommonStPicUrl url2 = commonStPicSpecUrlEntry.getUrl();
                if (!TextUtils.isEmpty(url2 != null ? url2.getUrl() : null)) {
                    commonStPicUrl = commonStPicSpecUrlEntry.getUrl();
                }
            }
            if (commonStPicUrl == null) {
                CommonStPicUrl url3 = commonStPicSpecUrlEntry.getUrl();
                if (!TextUtils.isEmpty(url3 != null ? url3.getUrl() : null)) {
                    commonStPicUrl = commonStPicSpecUrlEntry.getUrl();
                }
            }
        }
        return commonStPicUrl;
    }

    @JvmStatic
    public static final boolean f(CommonStMedia media) {
        return media != null && media.getType() == CommonEnumMediaType.VIDEO.ordinal();
    }

    public final String b(CommonStMedia media) {
        CommonStVideo video;
        CommonStImage cover;
        if (media == null) {
            return null;
        }
        if (media.getType() == CommonEnumMediaType.IMAGE.ordinal()) {
            CommonStImage image = media.getImage();
            if (image != null) {
                return image.getLloc();
            }
            return null;
        }
        if (media.getType() != CommonEnumMediaType.VIDEO.ordinal() || (video = media.getVideo()) == null || (cover = video.getCover()) == null) {
            return null;
        }
        return cover.getLloc();
    }

    @JvmStatic
    public static final CommonStPicUrl c(CommonStMedia media) {
        if (media == null) {
            return null;
        }
        if (f(media)) {
            return a(media.getVideo().getCover().e());
        }
        return a(media.getImage().e());
    }
}
