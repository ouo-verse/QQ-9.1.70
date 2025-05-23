package com.qzone.proxy.feedcomponent.model;

import com.qzone.module.feedcomponent.util.StringExtKt;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0000H\u0002\u001a\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0000\u001a\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0000\u001a\"\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\f\u001a \u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00112\u0010\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0018\u00010\u0011\u001a\u0010\u0010\u0014\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "Lcom/qzone/proxy/feedcomponent/model/i;", "f", "Lcom/qzone/proxy/feedcomponent/model/o;", "g", "feedData", "", "b", "subFeedData", "c", "Lcom/qzone/proxy/feedcomponent/model/VideoInfo;", QCircleScheme.AttrDetail.VIDEO_INFO, "", "", "extendinfo", "", "a", "", "feedDatas", "e", "d", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class c {
    public static final void a(VideoInfo videoInfo, Map<String, String> extendinfo) {
        Intrinsics.checkNotNullParameter(videoInfo, "videoInfo");
        Intrinsics.checkNotNullParameter(extendinfo, "extendinfo");
        String str = extendinfo.get("video_width");
        Integer intOrNull = str != null ? StringsKt__StringNumberConversionsKt.toIntOrNull(str) : null;
        String str2 = extendinfo.get("video_height");
        Integer intOrNull2 = str2 != null ? StringsKt__StringNumberConversionsKt.toIntOrNull(str2) : null;
        if (intOrNull == null || intOrNull2 == null) {
            return;
        }
        videoInfo.width = intOrNull.intValue();
        videoInfo.height = intOrNull2.intValue();
    }

    public static final boolean b(BusinessFeedData feedData) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        return feedData.containerSubType == 10;
    }

    public static final boolean c(BusinessFeedData subFeedData) {
        Intrinsics.checkNotNullParameter(subFeedData, "subFeedData");
        return subFeedData.parentContainerSubType == 10;
    }

    public static final FrdHotVideoSubFeedInfo f(BusinessFeedData businessFeedData) {
        Intrinsics.checkNotNullParameter(businessFeedData, "<this>");
        return new FrdHotVideoSubFeedInfo(businessFeedData, g(businessFeedData));
    }

    public static final List<BusinessFeedData> e(List<? extends BusinessFeedData> list) {
        List emptyList;
        int size = list != null ? list.size() : 0;
        if (list == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            emptyList = new ArrayList();
            for (Object obj : list) {
                if (!d((BusinessFeedData) obj)) {
                    emptyList.add(obj);
                }
            }
        }
        int size2 = emptyList.size();
        if (size2 != size) {
            QLog.e("CircleHotVideoUtil", 1, "removed empty circle hot video " + (size2 - size));
        }
        return emptyList;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0038 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final ParsedFeedData g(BusinessFeedData businessFeedData) {
        boolean z16;
        JSONObject jSONObject;
        String str;
        String str2;
        VideoInfo videoInfo;
        VideoInfo videoInfo2;
        PictureUrl pictureUrl;
        PictureUrl pictureUrl2;
        PictureUrl pictureUrl3;
        User user;
        User user2;
        String str3;
        String clipStr;
        User user3;
        User user4;
        boolean isBlank;
        Map<Integer, String> map;
        CellOperationInfo cellOperationInfo = businessFeedData.cellOperationInfo;
        String str4 = null;
        String str5 = (cellOperationInfo == null || (map = cellOperationInfo.busiParam) == null) ? null : map.get(218);
        int i3 = 0;
        if (str5 != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str5);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    QLog.i("CircleHotVideo", 1, "busiParam empty");
                    jSONObject = new JSONObject();
                } else {
                    try {
                        jSONObject = new JSONObject(str5);
                    } catch (JSONException e16) {
                        QLog.i("CircleHotVideo", 1, "busiParam error", e16);
                        jSONObject = new JSONObject();
                    }
                }
                CircleReportData a16 = CircleReportData.INSTANCE.a(jSONObject);
                CellUserInfo cellUserInfo = businessFeedData.cellUserInfo;
                long j3 = (cellUserInfo != null || (user4 = cellUserInfo.user) == null) ? 0L : user4.uin;
                String str6 = (cellUserInfo != null || (user3 = cellUserInfo.user) == null) ? null : user3.nickName;
                String str7 = str6 != null ? "" : str6;
                CellSummary cellSummaryV2 = businessFeedData.getCellSummaryV2();
                str = cellSummaryV2 == null ? cellSummaryV2.summary : null;
                if (str == null) {
                    str = "";
                }
                CellLikeInfo cellLikeInfo = businessFeedData.cellLikeInfo;
                int i16 = cellLikeInfo == null ? cellLikeInfo.likeNum : 0;
                CellInterest cellInterest = businessFeedData.cellInterest;
                str2 = cellInterest == null ? cellInterest.desc : null;
                if (str2 == null) {
                    str2 = "";
                }
                String str8 = (cellInterest != null || (str3 = cellInterest.desc) == null || (clipStr = StringExtKt.clipStr(str3, 12)) == null) ? "" : clipStr;
                CellUserInfo cellUserInfo2 = businessFeedData.cellUserInfo;
                String str9 = (cellUserInfo2 != null || (user2 = cellUserInfo2.user) == null) ? null : user2.logo;
                String str10 = str9 != null ? "" : str9;
                VideoInfo videoInfo3 = businessFeedData.getVideoInfo();
                String str11 = videoInfo3 == null ? videoInfo3.actionUrl : null;
                String str12 = str11 != null ? "" : str11;
                CellUserInfo cellUserInfo3 = businessFeedData.cellUserInfo;
                String str13 = (cellUserInfo3 != null || (user = cellUserInfo3.user) == null) ? null : user.actionurl;
                String str14 = str13 != null ? "" : str13;
                CellLikeInfo cellLikeInfo2 = businessFeedData.cellLikeInfo;
                boolean z17 = cellLikeInfo2 == null ? cellLikeInfo2.isLiked : false;
                CellIdInfo cellIdInfo = businessFeedData.cellIdInfo;
                String str15 = cellIdInfo == null ? cellIdInfo.cellId : null;
                String str16 = str15 != null ? "" : str15;
                VideoInfo videoInfo4 = businessFeedData.getVideoInfo();
                int i17 = (videoInfo4 != null || (pictureUrl3 = videoInfo4.coverUrl) == null) ? 0 : pictureUrl3.width;
                videoInfo = businessFeedData.getVideoInfo();
                if (videoInfo != null && (pictureUrl2 = videoInfo.coverUrl) != null) {
                    i3 = pictureUrl2.height;
                }
                videoInfo2 = businessFeedData.getVideoInfo();
                if (videoInfo2 != null && (pictureUrl = videoInfo2.coverUrl) != null) {
                    str4 = pictureUrl.url;
                }
                String str17 = str4 != null ? "" : str4;
                VideoInfo videoInfo5 = businessFeedData.getVideoInfo();
                return new ParsedFeedData(str, j3, str7, i16, str2, str8, str10, str12, str14, z17, str16, a16, i17, i3, str17, videoInfo5 == null ? videoInfo5.videoTime : 0L);
            }
        }
        z16 = true;
        if (!z16) {
        }
        CircleReportData a162 = CircleReportData.INSTANCE.a(jSONObject);
        CellUserInfo cellUserInfo4 = businessFeedData.cellUserInfo;
        if (cellUserInfo4 != null) {
        }
        if (cellUserInfo4 != null) {
        }
        if (str6 != null) {
        }
        CellSummary cellSummaryV22 = businessFeedData.getCellSummaryV2();
        if (cellSummaryV22 == null) {
        }
        if (str == null) {
        }
        CellLikeInfo cellLikeInfo3 = businessFeedData.cellLikeInfo;
        if (cellLikeInfo3 == null) {
        }
        CellInterest cellInterest2 = businessFeedData.cellInterest;
        if (cellInterest2 == null) {
        }
        if (str2 == null) {
        }
        if (cellInterest2 != null) {
        }
        CellUserInfo cellUserInfo22 = businessFeedData.cellUserInfo;
        if (cellUserInfo22 != null) {
        }
        if (str9 != null) {
        }
        VideoInfo videoInfo32 = businessFeedData.getVideoInfo();
        if (videoInfo32 == null) {
        }
        if (str11 != null) {
        }
        CellUserInfo cellUserInfo32 = businessFeedData.cellUserInfo;
        if (cellUserInfo32 != null) {
        }
        if (str13 != null) {
        }
        CellLikeInfo cellLikeInfo22 = businessFeedData.cellLikeInfo;
        if (cellLikeInfo22 == null) {
        }
        CellIdInfo cellIdInfo2 = businessFeedData.cellIdInfo;
        if (cellIdInfo2 == null) {
        }
        if (str15 != null) {
        }
        VideoInfo videoInfo42 = businessFeedData.getVideoInfo();
        if (videoInfo42 != null) {
        }
        videoInfo = businessFeedData.getVideoInfo();
        if (videoInfo != null) {
            i3 = pictureUrl2.height;
        }
        videoInfo2 = businessFeedData.getVideoInfo();
        if (videoInfo2 != null) {
            str4 = pictureUrl.url;
        }
        if (str4 != null) {
        }
        VideoInfo videoInfo52 = businessFeedData.getVideoInfo();
        return new ParsedFeedData(str, j3, str7, i16, str2, str8, str10, str12, str14, z17, str16, a162, i17, i3, str17, videoInfo52 == null ? videoInfo52.videoTime : 0L);
    }

    public static final boolean d(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || !b(businessFeedData)) {
            return false;
        }
        ArrayList<BusinessFeedData> arrayList = businessFeedData.recBusinessFeedDatas;
        return arrayList == null || arrayList.isEmpty();
    }
}
