package jb0;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.immersive.manager.h;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.ioc.IRFWPlayerReportCallback;
import com.tencent.biz.richframework.video.rfw.player.ioc.RFWPlayerIOC;
import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWPlayerReportInfo;
import feedcloud.FeedCloudCommon$Entry;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d implements IRFWPlayerReportCallback {
    @Override // com.tencent.biz.richframework.video.rfw.player.ioc.IRFWPlayerReportCallback
    public void onReportFront(RFWPlayerOptions rFWPlayerOptions, long j3, String str, List<FeedCloudCommon$Entry> list) {
        RFWPlayerIOC ioc;
        if (rFWPlayerOptions == null) {
            ioc = null;
        } else {
            ioc = rFWPlayerOptions.getIOC();
        }
        if (ioc == null) {
            RFWLog.d("QFSPlayerReportCallback", RFWLog.USR, "[onReportFront] ioc == null.");
            return;
        }
        RFWPlayerReportInfo businessReportInfo = ioc.getBusinessReportInfo();
        if (TextUtils.equals("video_current_player", str)) {
            h.i().q(rFWPlayerOptions, j3, businessReportInfo, list);
            return;
        }
        if (TextUtils.equals("video_buffer_time_consuming", str)) {
            h.i().r(rFWPlayerOptions, j3, businessReportInfo, list);
        } else if (TextUtils.equals("video_play_error", str)) {
            h.i().t(rFWPlayerOptions, j3, businessReportInfo, list);
        } else if (TextUtils.equals("video_drop_frame_event", str)) {
            h.i().s(rFWPlayerOptions, j3, businessReportInfo, list);
        }
    }
}
