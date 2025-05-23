package com.qzone.reborn.albumx.qzone.vas;

import aa.e;
import com.qzone.reborn.albumx.common.convert.bean.CommonStImage;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.common.convert.bean.CommonStPicSpecUrlEntry;
import com.qzone.reborn.albumx.common.convert.bean.CommonStPicUrl;
import com.qzone.reborn.albumx.common.convert.enumtype.CommonEnumPhotoSpec;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZonePhotoDegrade$PhotoInfo;
import qzone.QZonePhotoDegrade$PicInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\u0010\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u0003\u001a\f\u0010\b\u001a\u00020\u0007*\u0004\u0018\u00010\u0001\u00a8\u0006\t"}, d2 = {"Lqzone/QZonePhotoDegrade$PhotoInfo;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStImage;", "a", "Lcom/qzone/reborn/albumx/common/bean/a;", "", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "c", "Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo;", "b", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class c {
    public static final CommonStImage a(QZonePhotoDegrade$PhotoInfo qZonePhotoDegrade$PhotoInfo) {
        Intrinsics.checkNotNullParameter(qZonePhotoDegrade$PhotoInfo, "<this>");
        CommonStImage commonStImage = new CommonStImage();
        String stringUtf8 = qZonePhotoDegrade$PhotoInfo.photo_id.get().toStringUtf8();
        Intrinsics.checkNotNullExpressionValue(stringUtf8, "this.photo_id.get().toStringUtf8()");
        commonStImage.l(stringUtf8);
        List<QZonePhotoDegrade$PicInfo> list = qZonePhotoDegrade$PhotoInfo.pics.get();
        Intrinsics.checkNotNullExpressionValue(list, "this.pics.get()");
        for (QZonePhotoDegrade$PicInfo qZonePhotoDegrade$PicInfo : list) {
            List<CommonStPicSpecUrlEntry> e16 = commonStImage.e();
            CommonStPicSpecUrlEntry commonStPicSpecUrlEntry = new CommonStPicSpecUrlEntry();
            CommonStPicUrl url = commonStPicSpecUrlEntry.getUrl();
            String stringUtf82 = qZonePhotoDegrade$PicInfo.url.get().toStringUtf8();
            Intrinsics.checkNotNullExpressionValue(stringUtf82, "pic.url.get().toStringUtf8()");
            url.c(stringUtf82);
            commonStPicSpecUrlEntry.getUrl().e(qZonePhotoDegrade$PicInfo.width.get());
            commonStPicSpecUrlEntry.getUrl().b(qZonePhotoDegrade$PicInfo.height.get());
            commonStPicSpecUrlEntry.c(qZonePhotoDegrade$PicInfo.type.get());
            e16.add(commonStPicSpecUrlEntry);
        }
        return commonStImage;
    }

    public static final RFWLayerPicInfo b(CommonStImage commonStImage) {
        String str;
        RFWLayerPicInfo rFWLayerPicInfo = new RFWLayerPicInfo();
        if (commonStImage == null) {
            return rFWLayerPicInfo;
        }
        rFWLayerPicInfo.setOriginPicInfo(new RFWLayerPicInfo.RFWPicInfo());
        rFWLayerPicInfo.setPicId(commonStImage.getLloc());
        RFWLayerPicInfo.RFWPicInfo originPicInfo = rFWLayerPicInfo.getOriginPicInfo();
        Intrinsics.checkNotNull(originPicInfo);
        CommonStPicUrl d16 = e.f25753a.d(commonStImage.e(), CommonEnumPhotoSpec.PHOTO_SPEC_ORIGIN);
        if (d16 == null || (str = d16.getUrl()) == null) {
            str = "";
        }
        originPicInfo.setUrl(str);
        return rFWLayerPicInfo;
    }

    public static final List<RFWLayerItemMediaInfo> c(com.qzone.reborn.albumx.common.bean.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        ArrayList arrayList = new ArrayList();
        for (CommonStMedia commonStMedia : aVar.getBatchInfo().j()) {
            RFWLayerItemMediaInfo rFWLayerItemMediaInfo = new RFWLayerItemMediaInfo();
            rFWLayerItemMediaInfo.setMediaId(commonStMedia.getImage().getLloc());
            rFWLayerItemMediaInfo.setLayerPicInfo(b(commonStMedia.getImage()));
            arrayList.add(rFWLayerItemMediaInfo);
        }
        return arrayList;
    }
}
