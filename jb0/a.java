package jb0;

import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.biz.qqcircle.immersive.feed.ad.u;
import com.tencent.biz.richframework.video.rfw.player.ioc.IRFWPlayerFeedConverter;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWPlayerReportInfo;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWStVideo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StDebugInfo;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a implements IRFWPlayerFeedConverter<e30.b> {
    private int b(e30.b bVar) {
        Object b16 = bVar.b("KEY_RFW_VIDEO_FEED_POI");
        if (b16 instanceof Integer) {
            return ((Integer) b16).intValue();
        }
        return 0;
    }

    private static String c(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StDebugInfo feedCloudMeta$StDebugInfo;
        PBRepeatMessageField<FeedCloudCommon$Entry> pBRepeatMessageField;
        List<FeedCloudCommon$Entry> list;
        if (feedCloudMeta$StFeed == null || (feedCloudMeta$StDebugInfo = feedCloudMeta$StFeed.debugInfo) == null || (pBRepeatMessageField = feedCloudMeta$StDebugInfo.debugMap) == null || (list = pBRepeatMessageField.get()) == null) {
            return "";
        }
        for (FeedCloudCommon$Entry feedCloudCommon$Entry : list) {
            if (feedCloudCommon$Entry != null && "traceid".contains(feedCloudCommon$Entry.key.get())) {
                return feedCloudCommon$Entry.value.get();
            }
        }
        return "";
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.ioc.IRFWPlayerFeedConverter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public RFWPlayerReportInfo<e30.b> convertToReportInfo(e30.b bVar) {
        if (bVar != null && bVar.g() != null) {
            Object b16 = bVar.b("KEY_RFW_VIDEO_REPORT_OBJ");
            if (b16 instanceof RFWPlayerReportInfo) {
                return (RFWPlayerReportInfo) b16;
            }
            int b17 = b(bVar);
            FeedCloudMeta$StFeed g16 = bVar.g();
            RFWPlayerReportInfo<e30.b> rFWPlayerReportInfo = new RFWPlayerReportInfo<>(bVar);
            try {
                rFWPlayerReportInfo.addReportElement("total_time", String.valueOf(g16.video.duration.get() / 1000.0f)).addReportElement("orig_uin", String.valueOf(g16.poster.f398463id.get())).addReportElement("feed_id", String.valueOf(g16.f398449id.get())).addReportElement(QCircleFolderFunnelCollect.EXTRA_FEED_TYPE, String.valueOf(g16.type.get())).addReportElement(AEEditorConstants.VIDEO_RESOLUTION, g16.video.width.get() + HippyTKDListViewAdapter.X + g16.video.height.get()).addReportElement("link_redirect_count", String.valueOf(b17)).setFeedId(g16.f398449id.get()).setFileSize(g16.video.fileSize.get()).setVideoId(g16.video.fileId.get()).setDuration(g16.video.duration.get()).setTraceId(c(g16));
                bVar.o("KEY_RFW_VIDEO_REPORT_OBJ", rFWPlayerReportInfo);
            } catch (Exception e16) {
                QLog.e("RFWVideoReporter", 1, e16, new Object[0]);
            }
            return rFWPlayerReportInfo;
        }
        return new RFWPlayerReportInfo<>(bVar);
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.ioc.IRFWPlayerFeedConverter
    public RFWStVideo convertFeedToStVideo(Object obj) {
        if (obj instanceof FeedCloudMeta$StFeed) {
            return gb0.b.k(((FeedCloudMeta$StFeed) obj).video);
        }
        if (obj instanceof e30.b) {
            e30.b bVar = (e30.b) obj;
            if (u.c(bVar) == null) {
                return gb0.b.k(bVar.g().video);
            }
            return gb0.b.k(u.c(bVar).video);
        }
        return null;
    }
}
