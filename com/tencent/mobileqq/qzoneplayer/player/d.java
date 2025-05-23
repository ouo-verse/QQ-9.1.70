package com.tencent.mobileqq.qzoneplayer.player;

import android.net.Uri;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.model.SegmentVideoInfo;
import com.tencent.oskplayer.util.PlayerUtils;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import com.tencent.superplayer.api.SuperPlayerDownOption;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes35.dex */
public class d implements ISPlayerPreDownloader.Listener {

    /* renamed from: c, reason: collision with root package name */
    private static final wl2.a<d, Void> f279467c = new a();

    /* renamed from: a, reason: collision with root package name */
    private ISPlayerPreDownloader f279468a;

    /* renamed from: b, reason: collision with root package name */
    private Map<Integer, String> f279469b;

    /* compiled from: P */
    /* loaded from: classes35.dex */
    class a extends wl2.a<d, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // wl2.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public d a(Void r26) {
            return new d(null);
        }
    }

    /* synthetic */ d(a aVar) {
        this();
    }

    public static d b() {
        return f279467c.b(null);
    }

    @Override // com.tencent.superplayer.api.ISPlayerPreDownloader.Listener
    public void onInfo(int i3, long j3, long j16, Object obj) {
        PlayerUtils.log(3, "SuperMediaPlayerPreloader", "[onInfo] what=" + i3 + ", arg1=" + j3 + ", arg2=" + j16 + ", extInfo=" + obj);
    }

    @Override // com.tencent.superplayer.api.ISPlayerPreDownloader.Listener
    public void onPrepareDownloadProgressUpdate(int i3, int i16, int i17, long j3, long j16, String str) {
        PlayerUtils.log(3, "SuperMediaPlayerPreloader", "[onPrepareDownloadProgressUpdate] taskId=" + i3 + ", playableDurationMS=" + i16 + ", downloadSpeedKBs=" + i17 + ", currentDownloadSizeByte=" + j3 + ", totalFileSizeByte=" + j16 + ", extraInfo=" + str);
    }

    @Override // com.tencent.superplayer.api.ISPlayerPreDownloader.Listener
    public void onPrepareError(int i3, int i16, int i17, String str) {
        PlayerUtils.log(3, "SuperMediaPlayerPreloader", "[onPrepareError] taskId=" + i3 + ",moduleId=" + i16 + ",errorCode=" + i17);
        this.f279469b.remove(Integer.valueOf(i3));
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("status", "error");
        hashMap.put("error_code", String.valueOf(i17));
        FeedVideoEnv.externalFunc.reportMTA(FeedVideoEnv.MtaReportConfig.MTA_REPORT_KEY_PRELOAD, hashMap);
    }

    @Override // com.tencent.superplayer.api.ISPlayerPreDownloader.Listener
    public void onPrepareSuccess(int i3) {
        PlayerUtils.log(3, "SuperMediaPlayerPreloader", "[onPrepareSuccess] taskId=" + i3);
        this.f279469b.remove(Integer.valueOf(i3));
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("status", "end");
        hashMap.put("error_code", "0");
        FeedVideoEnv.externalFunc.reportMTA(FeedVideoEnv.MtaReportConfig.MTA_REPORT_KEY_PRELOAD, hashMap);
    }

    d() {
        this.f279469b = new ConcurrentHashMap();
        ISPlayerPreDownloader createPreDownloader = SuperPlayerFactory.createPreDownloader(PlayerConfig.g().getAppContext(), 102);
        this.f279468a = createPreDownloader;
        createPreDownloader.setOnPreDownloadListener(this);
    }

    public void c(SegmentVideoInfo.StreamInfo streamInfo, long j3) {
        if (streamInfo != null && streamInfo.getSegment(0) != null) {
            String str = streamInfo.getSegment(0).url;
            long j16 = streamInfo.getSegment(0).duration;
            if (PlayerUtils.isHLSStream(str)) {
                PlayerUtils.log(6, "SuperMediaPlayerPreloader", "[preload] hls not support preload, url=" + str);
                return;
            }
            String g16 = com.tencent.mobileqq.qzoneplayer.videosource.a.d().g(str);
            int a16 = a(streamInfo);
            PlayerUtils.log(3, "SuperMediaPlayerPreloader", "[preload]2 url=" + str + ", format=" + a16 + ", preloadSize=" + j3 + ", spliceUrl=" + g16);
            SuperPlayerVideoInfo createVideoInfoForUrl = SuperPlayerFactory.createVideoInfoForUrl(new String[]{g16}, a16, j16, (String) null);
            AtomicLong atomicLong = new AtomicLong(0L);
            AtomicLong atomicLong2 = new AtomicLong(0L);
            SuperPlayerDownOption obtain = SuperPlayerDownOption.obtain();
            FeedVideoEnv.FeedVideoExternalFunc feedVideoExternalFunc = FeedVideoEnv.externalFunc;
            if (feedVideoExternalFunc != null) {
                feedVideoExternalFunc.injectPreloadParam(createVideoInfoForUrl, atomicLong, atomicLong2, obtain);
            }
            ISPlayerPreDownloader iSPlayerPreDownloader = this.f279468a;
            if (atomicLong2.get() != 0) {
                j3 = atomicLong2.get();
            }
            this.f279469b.put(Integer.valueOf(iSPlayerPreDownloader.startPreDownload(createVideoInfoForUrl, j3, obtain)), str);
            return;
        }
        PlayerUtils.log(6, "SuperMediaPlayerPreloader", "[preload]2 invalid parameter");
    }

    private int a(SegmentVideoInfo.StreamInfo streamInfo) {
        if (streamInfo != null && streamInfo.getSegment(0) != null) {
            String str = streamInfo.getSegment(0).url;
            if (streamInfo.isHLSLive) {
                return 201;
            }
            return PlayerUtils.isHLSStream(str) ? 102 : 101;
        }
        PlayerUtils.log(3, "SuperMediaPlayerPreloader", "[getFormat] invalid streamInfo");
        return 104;
    }

    public void d(SegmentVideoInfo.StreamInfo streamInfo, long j3, long j16) {
        FeedVideoEnv.FeedVideoExternalFunc feedVideoExternalFunc;
        if (streamInfo != null && streamInfo.getSegment(0) != null) {
            String str = streamInfo.getSegment(0).url;
            long j17 = streamInfo.getSegment(0).duration;
            if (PlayerUtils.isHLSStream(str)) {
                PlayerUtils.log(6, "SuperMediaPlayerPreloader", "[preload] hls not support preload, url=" + str);
                return;
            }
            String g16 = com.tencent.mobileqq.qzoneplayer.videosource.a.d().g(str);
            int a16 = a(streamInfo);
            PlayerUtils.log(3, "SuperMediaPlayerPreloader", "[preload]1 url=" + str + ", format=" + a16 + ", videoDurationMs=" + j3 + ", preload duration=" + j16 + ", spliceUrl=" + g16);
            SuperPlayerVideoInfo createVideoInfoForUrl = SuperPlayerFactory.createVideoInfoForUrl(new String[]{g16}, a16, j17, (String) null);
            if (!str.equals(g16) && (feedVideoExternalFunc = FeedVideoEnv.externalFunc) != null && feedVideoExternalFunc.isUgcOnCloudUrl(str) && com.tencent.mobileqq.qzoneplayer.videosource.a.d().a()) {
                Uri parse = Uri.parse(str);
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(parse.getHost());
                createVideoInfoForUrl.setUrlHostList(arrayList);
            }
            AtomicLong atomicLong = new AtomicLong(0L);
            AtomicLong atomicLong2 = new AtomicLong(0L);
            SuperPlayerDownOption obtain = SuperPlayerDownOption.obtain();
            FeedVideoEnv.FeedVideoExternalFunc feedVideoExternalFunc2 = FeedVideoEnv.externalFunc;
            if (feedVideoExternalFunc2 != null) {
                feedVideoExternalFunc2.injectPreloadParam(createVideoInfoForUrl, atomicLong, atomicLong2, obtain);
            }
            this.f279469b.put(Integer.valueOf(this.f279468a.startPreDownload(createVideoInfoForUrl, streamInfo.getTotalDuration(), atomicLong.get() != 0 ? atomicLong.get() : j16, obtain)), str);
            return;
        }
        PlayerUtils.log(6, "SuperMediaPlayerPreloader", "[preload]1 invalid parameter");
    }
}
