package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.personal_album;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonBatchInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonBatchInfoBanner;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonEntry;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonStLBS;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonStUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.BatchInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.BatchInfoBanner;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.Entry;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StLBS;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StUser;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u00a8\u0006\u0003"}, d2 = {"toCommonBatchInfo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonBatchInfo;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/BatchInfo;", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class AlbumBatchInfoConverterKt {
    public static final CommonBatchInfo toCommonBatchInfo(BatchInfo batchInfo) {
        CommonStUser commonStUser;
        CommonStLBS commonStLBS;
        CommonBatchInfoBanner commonBatchInfoBanner;
        CommonBatchInfo commonBatchInfo = new CommonBatchInfo();
        Long l3 = batchInfo.linkId;
        commonBatchInfo.setLinkId(l3 != null ? l3.longValue() : 0L);
        String str = batchInfo.desc;
        if (str == null) {
            str = "";
        }
        commonBatchInfo.setDesc(str);
        String str2 = batchInfo.showTime;
        if (str2 == null) {
            str2 = "";
        }
        commonBatchInfo.setShowTime(str2);
        StUser stUser = batchInfo.user;
        if (stUser == null || (commonStUser = AlbumStUserConverterKt.toCommonStUser(stUser)) == null) {
            commonStUser = new CommonStUser();
        }
        commonBatchInfo.setUser(commonStUser);
        Long l16 = batchInfo.uploadNumber;
        commonBatchInfo.setUploadNumber(l16 != null ? l16.longValue() : 0L);
        StLBS stLBS = batchInfo.lbs;
        if (stLBS == null || (commonStLBS = AlbumStLBSConverterKt.toCommonStLBS(stLBS)) == null) {
            commonStLBS = new CommonStLBS();
        }
        commonBatchInfo.setLbs(commonStLBS);
        Integer num = batchInfo.linkType;
        commonBatchInfo.setLinkType(num != null ? num.intValue() : 0);
        String str3 = batchInfo.subTitle;
        if (str3 == null) {
            str3 = "";
        }
        commonBatchInfo.setSubTitle(str3);
        Iterator<T> it = batchInfo.medias.iterator();
        while (it.hasNext()) {
            commonBatchInfo.getMedias().add(AlbumStMediaConverterKt.toCommonStMedia((StMedia) it.next()));
        }
        Long l17 = batchInfo.originUploadNumber;
        commonBatchInfo.setOriginUploadNumber(l17 != null ? l17.longValue() : 0L);
        for (Entry entry : batchInfo.ext) {
            List<CommonEntry> ext = commonBatchInfo.getExt();
            CommonEntry commonEntry = new CommonEntry();
            String str4 = entry.key;
            if (str4 == null) {
                str4 = "";
            }
            commonEntry.setKey(str4);
            String str5 = entry.value;
            if (str5 == null) {
                str5 = "";
            }
            commonEntry.setValue(str5);
            Integer num2 = entry.numberKey;
            commonEntry.setNumberKey(num2 != null ? num2.intValue() : 0);
            ext.add(commonEntry);
        }
        BatchInfoBanner batchInfoBanner = batchInfo.banner;
        if (batchInfoBanner == null || (commonBatchInfoBanner = QZAlbumxConverterKt.toCommonBatchInfoBanner(batchInfoBanner)) == null) {
            commonBatchInfoBanner = new CommonBatchInfoBanner();
        }
        commonBatchInfo.setBanner(commonBatchInfoBanner);
        return commonBatchInfo;
    }
}
