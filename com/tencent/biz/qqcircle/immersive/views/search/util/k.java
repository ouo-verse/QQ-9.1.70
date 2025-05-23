package com.tencent.biz.qqcircle.immersive.views.search.util;

import android.os.Build;
import android.view.View;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity;
import com.tencent.superplayer.api.ISuperPlayer;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Predicate;

/* compiled from: P */
/* loaded from: classes4.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private long f91267a;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(Map.Entry<String, Object> entry) {
        if (entry.getKey() != null && entry.getValue() != null) {
            return false;
        }
        return true;
    }

    private void g(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            map.entrySet().removeIf(new Predicate() { // from class: com.tencent.biz.qqcircle.immersive.views.search.util.j
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean f16;
                    f16 = k.this.f((Map.Entry) obj);
                    return f16;
                }
            });
            return;
        }
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            if (f(it.next())) {
                it.remove();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void b(QFSVideoView qFSVideoView, Map<String, Object> map, FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.putAll(ua0.c.e(feedCloudMeta$StFeed));
        map.put("xsj_custom_pgid", str);
        g(map);
        VideoEntity build = new VideoEntity.Builder().setContentId(feedCloudMeta$StFeed.f398449id.get()).setPage((Object) str).setContentType(2).setVideoDuration(feedCloudMeta$StFeed.video.duration.get()).setVideoView((View) qFSVideoView).addCustomParams((Map<String, ?>) map).ignoreReport(false).bizReady(true).build();
        ISuperPlayer superPlayer = qFSVideoView.getSuperPlayer();
        if (superPlayer != null) {
            VideoReport.bindVideoPlayerInfo(superPlayer, build);
        } else {
            VideoReport.bindVideoPlayerInfo(qFSVideoView, build);
        }
    }

    public void c(QFSVideoView qFSVideoView) {
        VideoReport.unbindVideoPlayerInfo(qFSVideoView);
    }

    public void d(View view, int i3, int i16, boolean z16) {
        int i17;
        if (this.f91267a == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f91267a;
        QLog.d("QFSSearchResultReportWrapper", 1, "[imageEndDtReport] startTime: " + this.f91267a + " duration: " + currentTimeMillis);
        this.f91267a = 0L;
        HashMap hashMap = new HashMap();
        if (!z16 && i3 != 1) {
            i17 = 3;
        } else {
            i17 = 2;
        }
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_END_REASON, Integer.valueOf(i17));
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_PLAY_DURATION, Long.valueOf(currentTimeMillis));
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_END_INDEX, Integer.valueOf(i16 + 1));
        hashMap.put("xsj_custom_pgid", QCircleDaTongConstant.PageId.PG_XSJ_SEARCH_RESULT_PAGE);
        VideoReport.setElementParams(view, hashMap);
        ua0.i.h(view, QCircleDaTongConstant.EventId.EV_XSJ_ALBUM_END, null);
    }

    public void e(View view, int i3, boolean z16, int i16) {
        int i17;
        this.f91267a = System.currentTimeMillis();
        int i18 = 2;
        if (QLog.isColorLevel()) {
            QLog.d("QFSSearchResultReportWrapper", 2, "[imageStartDtReport] startTime: " + this.f91267a);
        }
        HashMap hashMap = new HashMap();
        if (z16) {
            i17 = 2;
        } else {
            i17 = 1;
        }
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_START_TYPE, Integer.valueOf(i17));
        if (z16 || i3 == 0) {
            i18 = 1;
        }
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_START_REASON, Integer.valueOf(i18));
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_REPEAT_CNT, Integer.valueOf(i16));
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_START_INDEX, Integer.valueOf(i3 + 1));
        hashMap.put("xsj_custom_pgid", QCircleDaTongConstant.PageId.PG_XSJ_SEARCH_RESULT_PAGE);
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_ALBUM_DISPLAY_TYPE, 1);
        VideoReport.setElementParams(view, hashMap);
        ua0.i.h(view, QCircleDaTongConstant.EventId.EV_XSJ_ALBUM_START, null);
    }
}
