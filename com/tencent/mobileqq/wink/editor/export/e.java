package com.tencent.mobileqq.wink.editor.export;

import android.media.MediaMetadataRetriever;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.ResourceModel;
import com.tencent.videocut.model.SizeF;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a$\u0010\u0006\u001a\u00020\u00052\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u001aF\u0010\f\u001a\u00020\u00052\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u001a\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002\u001a\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0012H\u0002\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "wrapper", "", "traceId", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "", "d", "", "outputPathList", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "outputMediaInfoMap", "c", "path", "Landroid/media/MediaMetadataRetriever;", "retriever", "Lcom/tencent/mobileqq/wink/editor/export/f;", "b", "", "index", "a", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class e {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final String a(WinkEditDataWrapper winkEditDataWrapper, int i3) {
        boolean z16;
        boolean z17;
        boolean z18;
        StringBuffer stringBuffer = new StringBuffer();
        String templateFilePath = winkEditDataWrapper.getTemplateFilePath();
        boolean z19 = false;
        if (templateFilePath != null) {
            if (templateFilePath.length() == 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (!z18) {
                z16 = true;
                if (z16) {
                    stringBuffer.append("template");
                    stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
                }
                if (winkEditDataWrapper.getEditDatas().get(i3).getFilterModelMap() == null && (!r1.isEmpty())) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    stringBuffer.append("filter");
                    stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
                }
                if (winkEditDataWrapper.getEditDatas().get(i3).getStickerModelMap() != null && (!r1.isEmpty())) {
                    z19 = true;
                }
                if (z19) {
                    stringBuffer.append("sticker");
                    stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
                }
                if (winkEditDataWrapper.getEditDatas().get(i3).getOpenHDR()) {
                    stringBuffer.append("HDR");
                }
                String stringBuffer2 = stringBuffer.toString();
                Intrinsics.checkNotNullExpressionValue(stringBuffer2, "sb.toString()");
                return stringBuffer2;
            }
        }
        z16 = false;
        if (z16) {
        }
        if (winkEditDataWrapper.getEditDatas().get(i3).getFilterModelMap() == null) {
        }
        z17 = false;
        if (z17) {
        }
        if (winkEditDataWrapper.getEditDatas().get(i3).getStickerModelMap() != null) {
            z19 = true;
        }
        if (z19) {
        }
        if (winkEditDataWrapper.getEditDatas().get(i3).getOpenHDR()) {
        }
        String stringBuffer22 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer22, "sb.toString()");
        return stringBuffer22;
    }

    private static final VideoInfo b(String str, MediaMetadataRetriever mediaMetadataRetriever) {
        mediaMetadataRetriever.setDataSource(str);
        String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
        Intrinsics.checkNotNull(extractMetadata);
        long parseLong = Long.parseLong(extractMetadata);
        int x16 = j.x(str);
        String extractMetadata2 = mediaMetadataRetriever.extractMetadata(18);
        Intrinsics.checkNotNull(extractMetadata2);
        int parseInt = Integer.parseInt(extractMetadata2);
        String extractMetadata3 = mediaMetadataRetriever.extractMetadata(19);
        Intrinsics.checkNotNull(extractMetadata3);
        int parseInt2 = Integer.parseInt(extractMetadata3);
        String extractMetadata4 = mediaMetadataRetriever.extractMetadata(20);
        Intrinsics.checkNotNull(extractMetadata4);
        return new VideoInfo(parseInt, parseInt2, parseLong, Long.parseLong(extractMetadata4), x16);
    }

    public static final void c(@Nullable WinkEditDataWrapper winkEditDataWrapper, @NotNull List<String> list, @NotNull Map<String, ? extends LocalMediaInfo> map, @Nullable String str, @Nullable String str2) {
        ArrayList<LocalMediaInfo> originMediaInfos;
        String str3;
        String str4;
        String str5;
        List<String> outputPathList = list;
        Map<String, ? extends LocalMediaInfo> outputMediaInfoMap = map;
        Intrinsics.checkNotNullParameter(outputPathList, "outputPathList");
        Intrinsics.checkNotNullParameter(outputMediaInfoMap, "outputMediaInfoMap");
        if (winkEditDataWrapper != null) {
            try {
                originMediaInfos = winkEditDataWrapper.getOriginMediaInfos();
            } catch (Exception e16) {
                w53.b.c("MediaQualityReporter", "reportImageQualityParams exception: traceId=" + str + ", exception=" + e16);
            }
        } else {
            originMediaInfos = null;
        }
        if (originMediaInfos != null && !winkEditDataWrapper.getEditDatas().isEmpty()) {
            ArrayList<LocalMediaInfo> originMediaInfos2 = winkEditDataWrapper.getOriginMediaInfos();
            ArrayList<WinkEditData> editDatas = winkEditDataWrapper.getEditDatas();
            if (originMediaInfos2.size() == editDatas.size() && originMediaInfos2.size() == list.size()) {
                int size = originMediaInfos2.size();
                int i3 = 0;
                int i16 = 0;
                while (i16 < size) {
                    ResourceModel resourceModel = editDatas.get(i16).getMediaModel().videos.get(i3).resource;
                    if (resourceModel != null) {
                        str3 = resourceModel.path;
                    } else {
                        str3 = null;
                    }
                    if (str3 != null) {
                        ResourceModel resourceModel2 = editDatas.get(i16).getMediaModel().videos.get(i3).resource;
                        Intrinsics.checkNotNull(resourceModel2);
                        SizeF sizeF = resourceModel2.size;
                        if (sizeF == null) {
                            sizeF = new SizeF(0.0f, 0.0f, null, 4, null);
                        }
                        LocalMediaInfo localMediaInfo = outputMediaInfoMap.get(outputPathList.get(i16));
                        int i17 = originMediaInfos2.get(i16).mediaWidth;
                        int i18 = originMediaInfos2.get(i16).mediaHeight;
                        float f16 = sizeF.width;
                        float f17 = sizeF.height;
                        Intrinsics.checkNotNull(localMediaInfo);
                        String str6 = i17 + HippyTKDListViewAdapter.X + i18 + ContainerUtils.FIELD_DELIMITER + f16 + HippyTKDListViewAdapter.X + f17 + ContainerUtils.FIELD_DELIMITER + localMediaInfo.mediaWidth + HippyTKDListViewAdapter.X + localMediaInfo.mediaHeight;
                        WinkPublishQualityReportData winkPublishQualityReportData = new WinkPublishQualityReportData(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0L, 32767, null);
                        winkPublishQualityReportData.setEventId("T_MEDIA_QUALITY");
                        winkPublishQualityReportData.setDesc("imageMode");
                        winkPublishQualityReportData.setExt1(str6);
                        winkPublishQualityReportData.setExt6(a(winkEditDataWrapper, i16));
                        winkPublishQualityReportData.setIndex(String.valueOf(i16));
                        if (str == null) {
                            str4 = "";
                        } else {
                            str4 = str;
                        }
                        winkPublishQualityReportData.setTraceId(str4);
                        z93.c f18 = Wink.INSTANCE.f();
                        if (f18 != null) {
                            if (str2 == null) {
                                str5 = "QCIRCLE";
                            } else {
                                str5 = str2;
                            }
                            f18.b(winkPublishQualityReportData, str5);
                        }
                    }
                    i16++;
                    outputPathList = list;
                    outputMediaInfoMap = map;
                    i3 = 0;
                }
                w53.b.f("MediaQualityReporter", "reportImageQualityParams finish: traceId=" + str);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0315  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void d(@Nullable WinkEditDataWrapper winkEditDataWrapper, @Nullable String str, @Nullable String str2) {
        ArrayList<LocalMediaInfo> originMediaInfos;
        MediaMetadataRetriever mediaMetadataRetriever;
        String str3;
        String str4;
        MediaMetadataRetriever mediaMetadataRetriever2;
        String str5;
        String str6;
        int i3;
        ArrayList<LocalMediaInfo> arrayList;
        WinkPublishQualityReportData winkPublishQualityReportData;
        String str7 = str;
        String str8 = "0&0&";
        String str9 = "MediaQualityReporter";
        if (winkEditDataWrapper != null) {
            try {
                originMediaInfos = winkEditDataWrapper.getOriginMediaInfos();
            } catch (Exception e16) {
                e = e16;
                str3 = "MediaQualityReporter";
                mediaMetadataRetriever = null;
                try {
                    str4 = str3;
                    w53.b.c(str4, "reportVideoQualityParams exception: traceId=" + str7 + ", exception=" + e);
                    if (mediaMetadataRetriever != null) {
                    }
                    w53.b.f(str4, "reportVideoQualityParams finish: traceId=" + str7);
                } catch (Throwable th5) {
                    th = th5;
                    if (mediaMetadataRetriever != null) {
                        mediaMetadataRetriever.release();
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                mediaMetadataRetriever = null;
                if (mediaMetadataRetriever != null) {
                }
                throw th;
            }
        } else {
            originMediaInfos = null;
        }
        if (originMediaInfos != null && !winkEditDataWrapper.getEditDatas().isEmpty() && winkEditDataWrapper.getOutMediaInfo() != null) {
            ArrayList<LocalMediaInfo> originMediaInfos2 = winkEditDataWrapper.getOriginMediaInfos();
            int i16 = 0;
            List<MediaClip> list = winkEditDataWrapper.getEditDatas().get(0).getMediaModel().videos;
            if (originMediaInfos2.size() != list.size()) {
                return;
            }
            MediaMetadataRetriever mediaMetadataRetriever3 = new MediaMetadataRetriever();
            try {
                try {
                    LocalMediaInfo outMediaInfo = winkEditDataWrapper.getOutMediaInfo();
                    Intrinsics.checkNotNull(outMediaInfo);
                    String str10 = outMediaInfo.path;
                    Intrinsics.checkNotNullExpressionValue(str10, "wrapper.outMediaInfo!!.path");
                    VideoInfo b16 = b(str10, mediaMetadataRetriever3);
                    int size = originMediaInfos2.size();
                    while (i16 < size) {
                        ResourceModel resourceModel = list.get(i16).resource;
                        if (resourceModel != null) {
                            try {
                                str5 = resourceModel.path;
                            } catch (Exception e17) {
                                e = e17;
                                str3 = str9;
                                mediaMetadataRetriever = mediaMetadataRetriever3;
                                str4 = str3;
                                w53.b.c(str4, "reportVideoQualityParams exception: traceId=" + str7 + ", exception=" + e);
                                if (mediaMetadataRetriever != null) {
                                }
                                w53.b.f(str4, "reportVideoQualityParams finish: traceId=" + str7);
                            } catch (Throwable th7) {
                                th = th7;
                                mediaMetadataRetriever = mediaMetadataRetriever3;
                                if (mediaMetadataRetriever != null) {
                                }
                                throw th;
                            }
                        } else {
                            str5 = null;
                        }
                        if (str5 != null) {
                            WinkPublishQualityReportData winkPublishQualityReportData2 = new WinkPublishQualityReportData(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0L, 32767, null);
                            if (QAlbumUtil.getMediaType(originMediaInfos2.get(i16)) == 1) {
                                try {
                                    String str11 = originMediaInfos2.get(i16).path;
                                    Intrinsics.checkNotNullExpressionValue(str11, "videosInPicker[i].path");
                                    VideoInfo b17 = b(str11, mediaMetadataRetriever3);
                                    VideoInfo b18 = b(str5, mediaMetadataRetriever3);
                                    int width = b17.getWidth();
                                    int height = b17.getHeight();
                                    i3 = size;
                                    int width2 = b18.getWidth();
                                    str3 = str9;
                                    try {
                                        int height2 = b18.getHeight();
                                        mediaMetadataRetriever2 = mediaMetadataRetriever3;
                                        try {
                                            try {
                                                String str12 = width + HippyTKDListViewAdapter.X + height + ContainerUtils.FIELD_DELIMITER + width2 + HippyTKDListViewAdapter.X + height2 + ContainerUtils.FIELD_DELIMITER + b16.getWidth() + HippyTKDListViewAdapter.X + b16.getHeight();
                                                String str13 = str8;
                                                String str14 = b17.getDuration() + ContainerUtils.FIELD_DELIMITER + b18.getDuration() + ContainerUtils.FIELD_DELIMITER + b16.getDuration();
                                                arrayList = originMediaInfos2;
                                                String str15 = b17.getBitRate() + ContainerUtils.FIELD_DELIMITER + b18.getBitRate() + ContainerUtils.FIELD_DELIMITER + b16.getBitRate();
                                                String str16 = b17.getFrameRate() + ContainerUtils.FIELD_DELIMITER + b18.getFrameRate() + ContainerUtils.FIELD_DELIMITER + b16.getFrameRate();
                                                winkPublishQualityReportData = winkPublishQualityReportData2;
                                                winkPublishQualityReportData.setDesc("videoMode: video");
                                                winkPublishQualityReportData.setExt1(str12);
                                                winkPublishQualityReportData.setExt2(str14);
                                                winkPublishQualityReportData.setExt3(str15);
                                                winkPublishQualityReportData.setExt4(str16);
                                                str6 = str13;
                                            } catch (Exception e18) {
                                                e = e18;
                                                str7 = str;
                                                mediaMetadataRetriever = mediaMetadataRetriever2;
                                                str4 = str3;
                                                w53.b.c(str4, "reportVideoQualityParams exception: traceId=" + str7 + ", exception=" + e);
                                                if (mediaMetadataRetriever != null) {
                                                    mediaMetadataRetriever.release();
                                                }
                                                w53.b.f(str4, "reportVideoQualityParams finish: traceId=" + str7);
                                            }
                                        } catch (Throwable th8) {
                                            th = th8;
                                            mediaMetadataRetriever = mediaMetadataRetriever2;
                                            if (mediaMetadataRetriever != null) {
                                            }
                                            throw th;
                                        }
                                    } catch (Exception e19) {
                                        e = e19;
                                        mediaMetadataRetriever2 = mediaMetadataRetriever3;
                                        str7 = str;
                                        mediaMetadataRetriever = mediaMetadataRetriever2;
                                        str4 = str3;
                                        w53.b.c(str4, "reportVideoQualityParams exception: traceId=" + str7 + ", exception=" + e);
                                        if (mediaMetadataRetriever != null) {
                                        }
                                        w53.b.f(str4, "reportVideoQualityParams finish: traceId=" + str7);
                                    }
                                } catch (Exception e26) {
                                    e = e26;
                                    str3 = str9;
                                }
                            } else {
                                String str17 = str8;
                                str3 = str9;
                                mediaMetadataRetriever2 = mediaMetadataRetriever3;
                                i3 = size;
                                arrayList = originMediaInfos2;
                                winkPublishQualityReportData = winkPublishQualityReportData2;
                                ResourceModel resourceModel2 = list.get(i16).resource;
                                Intrinsics.checkNotNull(resourceModel2);
                                SizeF sizeF = resourceModel2.size;
                                if (sizeF == null) {
                                    sizeF = new SizeF(0.0f, 0.0f, null, 4, null);
                                }
                                String str18 = arrayList.get(i16).mediaWidth + HippyTKDListViewAdapter.X + arrayList.get(i16).mediaHeight + ContainerUtils.FIELD_DELIMITER + sizeF.width + HippyTKDListViewAdapter.X + sizeF.height + ContainerUtils.FIELD_DELIMITER + b16.getWidth() + HippyTKDListViewAdapter.X + b16.getHeight();
                                long duration = b16.getDuration();
                                StringBuilder sb5 = new StringBuilder();
                                str6 = str17;
                                sb5.append(str6);
                                sb5.append(duration);
                                String sb6 = sb5.toString();
                                String str19 = str6 + b16.getBitRate();
                                String str20 = str6 + b16.getFrameRate();
                                winkPublishQualityReportData.setDesc("videoMode: image");
                                winkPublishQualityReportData.setExt1(str18);
                                winkPublishQualityReportData.setExt2(sb6);
                                winkPublishQualityReportData.setExt3(str19);
                                winkPublishQualityReportData.setExt4(str20);
                            }
                            winkPublishQualityReportData.setEventId("T_MEDIA_QUALITY");
                            winkPublishQualityReportData.setExt6(a(winkEditDataWrapper, i16));
                            winkPublishQualityReportData.setIndex(String.valueOf(i16));
                            str7 = str;
                            try {
                                winkPublishQualityReportData.setTraceId(str7 == null ? "" : str7);
                                z93.c f16 = Wink.INSTANCE.f();
                                if (f16 != null) {
                                    f16.b(winkPublishQualityReportData, str2 == null ? "QCIRCLE" : str2);
                                }
                            } catch (Exception e27) {
                                e = e27;
                                mediaMetadataRetriever = mediaMetadataRetriever2;
                                str4 = str3;
                                w53.b.c(str4, "reportVideoQualityParams exception: traceId=" + str7 + ", exception=" + e);
                                if (mediaMetadataRetriever != null) {
                                }
                                w53.b.f(str4, "reportVideoQualityParams finish: traceId=" + str7);
                            }
                        } else {
                            str6 = str8;
                            str3 = str9;
                            mediaMetadataRetriever2 = mediaMetadataRetriever3;
                            i3 = size;
                            arrayList = originMediaInfos2;
                        }
                        i16++;
                        str8 = str6;
                        originMediaInfos2 = arrayList;
                        size = i3;
                        str9 = str3;
                        mediaMetadataRetriever3 = mediaMetadataRetriever2;
                    }
                    mediaMetadataRetriever3.release();
                    str4 = str9;
                } catch (Throwable th9) {
                    th = th9;
                    mediaMetadataRetriever2 = mediaMetadataRetriever3;
                }
            } catch (Exception e28) {
                e = e28;
                str3 = str9;
                mediaMetadataRetriever2 = mediaMetadataRetriever3;
            }
            w53.b.f(str4, "reportVideoQualityParams finish: traceId=" + str7);
        }
    }
}
