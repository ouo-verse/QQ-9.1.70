package com.tencent.mobileqq.zplan.video.impl.plugin;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zplan.video.api.bean.TXVideoInfo;
import com.tencent.mobileqq.zplan.video.api.bean.VideoMediaInfo;
import com.tencent.mobileqq.zplan.video.api.bean.VideoPlayInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016R \u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/zplan/video/impl/plugin/a;", "Lzk3/b;", "", "Lcom/tencent/mobileqq/zplan/video/api/bean/b;", "a", "Lcom/tencent/mobileqq/zplan/video/api/bean/e;", "playInfo", "e", "", "componentId", "Lcom/tencent/mobileqq/zplan/video/api/bean/c;", "mediaInfo", "b", "", "c", QCircleScheme.AttrDetail.VIDEO_INFO, "d", "f", "", "Ljava/util/Map;", "videoInfoCacheList", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a implements zk3.b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Map<String, TXVideoInfo> videoInfoCacheList = new LinkedHashMap();

    @Override // zk3.b
    public List<TXVideoInfo> a() {
        List<TXVideoInfo> list;
        list = CollectionsKt___CollectionsKt.toList(this.videoInfoCacheList.values());
        return list;
    }

    @Override // zk3.b
    public TXVideoInfo b(String componentId, VideoMediaInfo mediaInfo) {
        Intrinsics.checkNotNullParameter(componentId, "componentId");
        Intrinsics.checkNotNullParameter(mediaInfo, "mediaInfo");
        TXVideoInfo tXVideoInfo = this.videoInfoCacheList.get(componentId);
        if (tXVideoInfo == null) {
            return null;
        }
        tXVideoInfo.f(mediaInfo);
        this.videoInfoCacheList.put(componentId, tXVideoInfo);
        QLog.i("VideoInfoCache", 1, "updateMediaInfoByPlayInfo :: componentId == " + componentId + " , update videoInfo == " + tXVideoInfo);
        return this.videoInfoCacheList.get(componentId);
    }

    @Override // zk3.b
    public void c(String componentId) {
        Intrinsics.checkNotNullParameter(componentId, "componentId");
        this.videoInfoCacheList.remove(componentId);
        QLog.i("VideoInfoCache", 1, "removeVideoInfoByPlayInfo :: componentId == " + componentId);
    }

    @Override // zk3.b
    public void d(TXVideoInfo videoInfo) {
        Intrinsics.checkNotNullParameter(videoInfo, "videoInfo");
        this.videoInfoCacheList.put(videoInfo.getPlayInfo().getComponentId(), videoInfo);
        QLog.i("VideoInfoCache", 1, "addVideoInfo :: componentId == " + videoInfo.getPlayInfo().getComponentId());
    }

    @Override // zk3.b
    public TXVideoInfo e(VideoPlayInfo playInfo) {
        Intrinsics.checkNotNullParameter(playInfo, "playInfo");
        TXVideoInfo tXVideoInfo = this.videoInfoCacheList.get(playInfo.getComponentId());
        QLog.i("VideoInfoCache", 1, "getVideoInfoByPlayInfo :: playInfo == " + playInfo + " , videoInfo == " + tXVideoInfo);
        return tXVideoInfo;
    }

    @Override // zk3.b
    public void f() {
        this.videoInfoCacheList.clear();
        QLog.i("VideoInfoCache", 1, "clearAllVideoInfo");
    }
}
