package com.qzone.reborn.feedx.video.process;

import android.text.TextUtils;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoUrl;
import com.qzone.reborn.feedx.video.c;
import com.qzone.reborn.feedx.video.process.QZonePlayerOptionsProcessManager;
import com.qzone.reborn.qqvideo.layer.d;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.mobileqq.qzoneplayer.video.TencentVideoHttpRetryLogic;
import com.tencent.mobileqq.qzoneplayer.video.s;
import com.tencent.oskplayer.proxy.HttpRetryLogic;
import com.tencent.qphone.base.util.QLog;
import kh.b;

/* compiled from: P */
/* loaded from: classes37.dex */
public class b extends com.qzone.reborn.feedx.video.process.a {

    /* renamed from: a, reason: collision with root package name */
    private final BusinessFeedData f55842a;

    /* renamed from: b, reason: collision with root package name */
    private VideoInfo f55843b;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QZonePlayerOptionsProcessManager.b f55844a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f55845b;

        a(QZonePlayerOptionsProcessManager.b bVar, c cVar) {
            this.f55844a = bVar;
            this.f55845b = cVar;
        }

        @Override // kh.b.a
        public void onComplete() {
            QZonePlayerOptionsProcessManager.b bVar = this.f55844a;
            if (bVar != null) {
                bVar.a(this.f55845b, true);
            }
        }
    }

    public b(BusinessFeedData businessFeedData, VideoInfo videoInfo) {
        this.f55842a = businessFeedData;
        this.f55843b = videoInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.qzone.reborn.feedx.video.process.a
    public void a(c cVar, QZonePlayerOptionsProcessManager.b bVar) {
        VideoInfo videoInfo;
        VideoInfo.VideoRemark videoRemark;
        HttpRetryLogic httpRetryLogic = FeedVideoEnv.externalFunc.getHttpRetryLogic();
        if (this.f55842a != null && (videoInfo = this.f55843b) != null && (videoRemark = videoInfo.videoRemark) != null && videoRemark.orgwebsite == 1) {
            VideoUrl videoUrl = videoInfo.h265NormalUrl;
            String str = videoUrl != null ? videoUrl.url : null;
            if (TextUtils.isEmpty(str)) {
                str = this.f55843b.videoUrl.url;
            }
            String str2 = str;
            String b16 = b(this.f55842a.feedType);
            httpRetryLogic = new TencentVideoHttpRetryLogic(str2, this.f55843b.videoId, b16);
            QLog.i(cVar.s() + "QZonePlayerOptionsExchangeUrlProcess", 1, "onProcess  use TencentVideoHttpRetryLogic  | request safe vid = " + this.f55843b.videoId + " | url = " + str2);
            if (s.g().j(str2)) {
                QLog.i(cVar.s() + "QZonePlayerOptionsExchangeUrlProcess", 1, "onProcess  getSafeurl  | request safe vid = " + this.f55843b.videoId + " | url = " + str2);
                FeedVideoEnv.externalFunc.getSafeurl(str2, this.f55843b.videoId, null, b16, s.g());
            }
        }
        BusinessFeedData businessFeedData = this.f55842a;
        if (businessFeedData != null && (businessFeedData.isQCircleShareCardFeed() || d.d(this.f55842a))) {
            kh.b bVar2 = new kh.b(cVar.c());
            com.tencent.mobileqq.qzoneplayer.videosource.a.d().f(cVar.c(), bVar2);
            bVar2.c(this.f55842a, this.f55843b, cVar, new a(bVar, cVar));
        } else {
            com.tencent.mobileqq.qzoneplayer.videosource.a.d().f(cVar.c(), httpRetryLogic);
            bVar.a(cVar, true);
        }
    }

    private static String b(int i3) {
        if (i3 == 2) {
            return "3";
        }
        if (i3 == 3) {
            return "2";
        }
        if (i3 != 4097) {
            return "";
        }
        return "1";
    }
}
