package mj;

import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumCommData;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonBatchInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonBytesEntry;
import com.qzone.reborn.albumx.common.convert.bean.CommonEntry;
import com.qzone.reborn.albumx.common.convert.bean.CommonStCommonExt;
import com.qzone.reborn.albumx.common.convert.bean.CommonStGPS;
import com.qzone.reborn.albumx.common.convert.bean.CommonStImage;
import com.qzone.reborn.albumx.common.convert.bean.CommonStLBS;
import com.qzone.reborn.albumx.common.convert.bean.CommonStUserAccountBaseMate;
import com.qzone.reborn.albumx.common.convert.bean.CommonStUserAccountEntry;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.richframework.gallery.bean.RFWLayerPicInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZIntimateSpaceAlbum$AlbumCommData;
import qzone.QZoneBaseAlbumMeta$AlbumInfo;
import qzone.QZoneBaseAlbumMeta$BatchInfo;
import qzone.QZoneBaseCommon$BytesEntry;
import qzone.QZoneBaseCommon$Entry;
import qzone.QZoneBaseCommon$StCommonExt;
import qzone.QZoneBaseCommon$StUserAccountEntry;
import qzone.QZoneBaseMeta$StGPS;
import qzone.QZoneBaseMeta$StLBS;
import qzone.QZoneBaseMeta$StMedia;
import qzone.QZoneBaseMeta$StUser;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0004*\u00020\u0003\u001a\n\u0010\u0006\u001a\u00020\u0003*\u00020\u0004\u001a\n\u0010\t\u001a\u00020\b*\u00020\u0007\u001a\n\u0010\f\u001a\u00020\u000b*\u00020\n\u001a\n\u0010\u000f\u001a\u00020\u000e*\u00020\r\u001a\n\u0010\u0012\u001a\u00020\u0011*\u00020\u0010\u001a\f\u0010\u0015\u001a\u00020\u0014*\u0004\u0018\u00010\u0013\u00a8\u0006\u0016"}, d2 = {"Lqzone/QZoneBaseAlbumMeta$AlbumInfo;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "b", "Lqzone/QZoneBaseCommon$StCommonExt;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStCommonExt;", "d", h.F, "Lqzone/QZIntimateSpaceAlbum$AlbumCommData;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumCommData;", "a", "Lqzone/QZoneBaseAlbumMeta$BatchInfo;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonBatchInfo;", "c", "Lqzone/QZoneBaseMeta$StLBS;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStLBS;", "f", "Lqzone/QZoneBaseMeta$StGPS;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStGPS;", "e", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStImage;", "Lcom/tencent/richframework/gallery/bean/RFWLayerPicInfo;", "g", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {
    public static final CommonAlbumCommData a(QZIntimateSpaceAlbum$AlbumCommData qZIntimateSpaceAlbum$AlbumCommData) {
        Intrinsics.checkNotNullParameter(qZIntimateSpaceAlbum$AlbumCommData, "<this>");
        CommonAlbumCommData commonAlbumCommData = new CommonAlbumCommData();
        commonAlbumCommData.j(qZIntimateSpaceAlbum$AlbumCommData.is_member.get());
        String str = qZIntimateSpaceAlbum$AlbumCommData.empty_message.get();
        Intrinsics.checkNotNullExpressionValue(str, "this.empty_message.get()");
        commonAlbumCommData.g(str);
        return commonAlbumCommData;
    }

    public static final CommonAlbumInfo b(QZoneBaseAlbumMeta$AlbumInfo qZoneBaseAlbumMeta$AlbumInfo) {
        Intrinsics.checkNotNullParameter(qZoneBaseAlbumMeta$AlbumInfo, "<this>");
        CommonAlbumInfo commonAlbumInfo = new CommonAlbumInfo();
        String str = qZoneBaseAlbumMeta$AlbumInfo.album_id.get();
        Intrinsics.checkNotNullExpressionValue(str, "this.album_id.get()");
        commonAlbumInfo.V(str);
        String str2 = qZoneBaseAlbumMeta$AlbumInfo.owner.get();
        Intrinsics.checkNotNullExpressionValue(str2, "this.owner.get()");
        commonAlbumInfo.o0(str2);
        String str3 = qZoneBaseAlbumMeta$AlbumInfo.name.get();
        Intrinsics.checkNotNullExpressionValue(str3, "this.name.get()");
        commonAlbumInfo.m0(str3);
        String str4 = qZoneBaseAlbumMeta$AlbumInfo.desc.get();
        Intrinsics.checkNotNullExpressionValue(str4, "this.desc.get()");
        commonAlbumInfo.g0(str4);
        commonAlbumInfo.d0(qZoneBaseAlbumMeta$AlbumInfo.create_time.get());
        commonAlbumInfo.y0(qZoneBaseAlbumMeta$AlbumInfo.upload_number.get());
        QZoneBaseMeta$StMedia qZoneBaseMeta$StMedia = qZoneBaseAlbumMeta$AlbumInfo.cover;
        Intrinsics.checkNotNullExpressionValue(qZoneBaseMeta$StMedia, "this.cover");
        commonAlbumInfo.b0(b.b(qZoneBaseMeta$StMedia));
        QZoneBaseMeta$StUser qZoneBaseMeta$StUser = qZoneBaseAlbumMeta$AlbumInfo.creator;
        Intrinsics.checkNotNullExpressionValue(qZoneBaseMeta$StUser, "this.creator");
        commonAlbumInfo.e0(c.a(qZoneBaseMeta$StUser));
        commonAlbumInfo.w0(qZoneBaseAlbumMeta$AlbumInfo.top_flag.get());
        commonAlbumInfo.u0(qZoneBaseAlbumMeta$AlbumInfo.status.get());
        return commonAlbumInfo;
    }

    public static final CommonBatchInfo c(QZoneBaseAlbumMeta$BatchInfo qZoneBaseAlbumMeta$BatchInfo) {
        Intrinsics.checkNotNullParameter(qZoneBaseAlbumMeta$BatchInfo, "<this>");
        CommonBatchInfo commonBatchInfo = new CommonBatchInfo();
        commonBatchInfo.s(qZoneBaseAlbumMeta$BatchInfo.batch_id.get());
        String str = qZoneBaseAlbumMeta$BatchInfo.desc.get();
        Intrinsics.checkNotNullExpressionValue(str, "this.desc.get()");
        commonBatchInfo.q(str);
        String str2 = qZoneBaseAlbumMeta$BatchInfo.show_time.get();
        Intrinsics.checkNotNullExpressionValue(str2, "this.show_time.get()");
        commonBatchInfo.w(str2);
        QZoneBaseMeta$StUser qZoneBaseMeta$StUser = qZoneBaseAlbumMeta$BatchInfo.user;
        Intrinsics.checkNotNullExpressionValue(qZoneBaseMeta$StUser, "this.user");
        commonBatchInfo.A(c.a(qZoneBaseMeta$StUser));
        QZoneBaseMeta$StLBS qZoneBaseMeta$StLBS = qZoneBaseAlbumMeta$BatchInfo.lbs;
        Intrinsics.checkNotNullExpressionValue(qZoneBaseMeta$StLBS, "this.lbs");
        commonBatchInfo.r(f(qZoneBaseMeta$StLBS));
        PBRepeatMessageField<QZoneBaseMeta$StMedia> pBRepeatMessageField = qZoneBaseAlbumMeta$BatchInfo.medias;
        if (pBRepeatMessageField != null && !pBRepeatMessageField.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            List<QZoneBaseMeta$StMedia> list = qZoneBaseAlbumMeta$BatchInfo.medias.get();
            Intrinsics.checkNotNullExpressionValue(list, "this.medias.get()");
            for (QZoneBaseMeta$StMedia it : list) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList.add(b.b(it));
            }
            commonBatchInfo.u(arrayList);
        }
        commonBatchInfo.z(qZoneBaseAlbumMeta$BatchInfo.upload_number.get());
        return commonBatchInfo;
    }

    public static final CommonStCommonExt d(QZoneBaseCommon$StCommonExt qZoneBaseCommon$StCommonExt) {
        Intrinsics.checkNotNullParameter(qZoneBaseCommon$StCommonExt, "<this>");
        CommonStCommonExt commonStCommonExt = new CommonStCommonExt();
        List<QZoneBaseCommon$Entry> list = qZoneBaseCommon$StCommonExt.map_info.get();
        Intrinsics.checkNotNullExpressionValue(list, "this.map_info.get()");
        for (QZoneBaseCommon$Entry qZoneBaseCommon$Entry : list) {
            CommonEntry commonEntry = new CommonEntry();
            String str = qZoneBaseCommon$Entry.key.get();
            Intrinsics.checkNotNullExpressionValue(str, "it.key.get()");
            commonEntry.c(str);
            String str2 = qZoneBaseCommon$Entry.value.get();
            Intrinsics.checkNotNullExpressionValue(str2, "it.value.get()");
            commonEntry.f(str2);
            commonStCommonExt.c().add(commonEntry);
        }
        String str3 = qZoneBaseCommon$StCommonExt.attach_info.get();
        Intrinsics.checkNotNullExpressionValue(str3, "this.attach_info.get()");
        commonStCommonExt.f(str3);
        List<QZoneBaseCommon$BytesEntry> list2 = qZoneBaseCommon$StCommonExt.map_bytes_info.get();
        Intrinsics.checkNotNullExpressionValue(list2, "this.map_bytes_info.get()");
        for (QZoneBaseCommon$BytesEntry qZoneBaseCommon$BytesEntry : list2) {
            CommonBytesEntry commonBytesEntry = new CommonBytesEntry();
            String str4 = qZoneBaseCommon$BytesEntry.key.get();
            Intrinsics.checkNotNullExpressionValue(str4, "it.key.get()");
            commonBytesEntry.c(str4);
            commonBytesEntry.e(qZoneBaseCommon$BytesEntry.value.get().toByteArray());
            commonStCommonExt.b().add(commonBytesEntry);
        }
        List<QZoneBaseCommon$StUserAccountEntry> list3 = qZoneBaseCommon$StCommonExt.map_user_account.get();
        Intrinsics.checkNotNullExpressionValue(list3, "this.map_user_account.get()");
        for (QZoneBaseCommon$StUserAccountEntry qZoneBaseCommon$StUserAccountEntry : list3) {
            CommonStUserAccountEntry commonStUserAccountEntry = new CommonStUserAccountEntry();
            String str5 = qZoneBaseCommon$StUserAccountEntry.uid.get();
            Intrinsics.checkNotNullExpressionValue(str5, "it.uid.get()");
            commonStUserAccountEntry.c(str5);
            CommonStUserAccountBaseMate account = commonStUserAccountEntry.getAccount();
            String str6 = qZoneBaseCommon$StUserAccountEntry.account.uid.get();
            Intrinsics.checkNotNullExpressionValue(str6, "it.account.uid.get()");
            account.c(str6);
            commonStUserAccountEntry.getAccount().e(qZoneBaseCommon$StUserAccountEntry.account.uin.get());
            commonStCommonExt.e().add(commonStUserAccountEntry);
        }
        return commonStCommonExt;
    }

    public static final CommonStGPS e(QZoneBaseMeta$StGPS qZoneBaseMeta$StGPS) {
        Intrinsics.checkNotNullParameter(qZoneBaseMeta$StGPS, "<this>");
        CommonStGPS commonStGPS = new CommonStGPS();
        commonStGPS.j(qZoneBaseMeta$StGPS.lat.get());
        commonStGPS.k(qZoneBaseMeta$StGPS.lon.get());
        commonStGPS.g(qZoneBaseMeta$StGPS.e_type.get());
        commonStGPS.f(qZoneBaseMeta$StGPS.alt.get());
        return commonStGPS;
    }

    public static final CommonStLBS f(QZoneBaseMeta$StLBS qZoneBaseMeta$StLBS) {
        Intrinsics.checkNotNullParameter(qZoneBaseMeta$StLBS, "<this>");
        CommonStLBS commonStLBS = new CommonStLBS();
        QZoneBaseMeta$StGPS qZoneBaseMeta$StGPS = qZoneBaseMeta$StLBS.gps;
        Intrinsics.checkNotNullExpressionValue(qZoneBaseMeta$StGPS, "this.gps");
        commonStLBS.g(e(qZoneBaseMeta$StGPS));
        String str = qZoneBaseMeta$StLBS.location.get();
        Intrinsics.checkNotNullExpressionValue(str, "this.location.get()");
        commonStLBS.k(str);
        return commonStLBS;
    }

    public static final RFWLayerPicInfo g(CommonStImage commonStImage) {
        RFWLayerPicInfo rFWLayerPicInfo = new RFWLayerPicInfo();
        rFWLayerPicInfo.setCurrentPicInfo(new RFWLayerPicInfo.RFWPicInfo());
        if (commonStImage == null) {
            return rFWLayerPicInfo;
        }
        rFWLayerPicInfo.setPicId(commonStImage.getLloc());
        String url = commonStImage.getDefaultUrl().getUrl();
        rFWLayerPicInfo.getCurrentPicInfo().setUrl(url);
        rFWLayerPicInfo.getCurrentPicInfo().setLocalPath(com.tencent.mobileqq.qzone.picload.c.a().d(Option.obtain().setUrl(url)));
        return rFWLayerPicInfo;
    }

    public static final QZoneBaseCommon$StCommonExt h(CommonStCommonExt commonStCommonExt) {
        Intrinsics.checkNotNullParameter(commonStCommonExt, "<this>");
        QZoneBaseCommon$StCommonExt qZoneBaseCommon$StCommonExt = new QZoneBaseCommon$StCommonExt();
        for (CommonEntry commonEntry : commonStCommonExt.c()) {
            QZoneBaseCommon$Entry qZoneBaseCommon$Entry = new QZoneBaseCommon$Entry();
            qZoneBaseCommon$Entry.key.set(commonEntry.getKey());
            qZoneBaseCommon$Entry.value.set(commonEntry.getValue());
            qZoneBaseCommon$StCommonExt.map_info.add(qZoneBaseCommon$Entry);
        }
        qZoneBaseCommon$StCommonExt.attach_info.set(commonStCommonExt.getAttachInfo());
        for (CommonBytesEntry commonBytesEntry : commonStCommonExt.b()) {
            QZoneBaseCommon$BytesEntry qZoneBaseCommon$BytesEntry = new QZoneBaseCommon$BytesEntry();
            qZoneBaseCommon$BytesEntry.key.set(commonBytesEntry.getKey());
            qZoneBaseCommon$BytesEntry.value.set(ByteStringMicro.copyFrom(commonBytesEntry.getValue()));
            qZoneBaseCommon$StCommonExt.map_bytes_info.add(qZoneBaseCommon$BytesEntry);
        }
        for (CommonStUserAccountEntry commonStUserAccountEntry : commonStCommonExt.e()) {
            QZoneBaseCommon$StUserAccountEntry qZoneBaseCommon$StUserAccountEntry = new QZoneBaseCommon$StUserAccountEntry();
            qZoneBaseCommon$StUserAccountEntry.uid.set(commonStUserAccountEntry.getUid());
            qZoneBaseCommon$StUserAccountEntry.account.uid.set(commonStUserAccountEntry.getAccount().getUid());
            qZoneBaseCommon$StUserAccountEntry.account.uin.set(commonStUserAccountEntry.getAccount().getUin());
            qZoneBaseCommon$StCommonExt.map_user_account.add(qZoneBaseCommon$StUserAccountEntry);
        }
        return qZoneBaseCommon$StCommonExt;
    }
}
