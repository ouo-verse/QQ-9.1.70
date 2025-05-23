package com.tencent.mobileqq.kandian.glue.video;

import java.util.HashSet;
import java.util.Set;
import t52.PlayerVideoInfo;

/* loaded from: classes33.dex */
public class VideoPreDownloadMgr implements f62.b, com.tencent.mobileqq.kandian.base.video.plugin.a {

    /* renamed from: a, reason: collision with root package name */
    private static Set<String> f240023a = new HashSet();

    /* renamed from: com.tencent.mobileqq.kandian.glue.video.VideoPreDownloadMgr$1, reason: invalid class name */
    /* loaded from: classes33.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ VideoPreDownloadMgr this$0;

        @Override // java.lang.Runnable
        public void run() {
            throw null;
        }
    }

    /* loaded from: classes33.dex */
    class PreDownloadNotAlreadyVideoTask implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private boolean f240025d;
        final /* synthetic */ VideoPreDownloadMgr this$0;

        @Override // java.lang.Runnable
        public void run() {
            if (this.f240025d) {
                if (VideoPreDownloadMgr.d(null) != null) {
                    VideoPreDownloadMgr.d(null).add(VideoPreDownloadMgr.c(null));
                }
                if (VideoPreDownloadMgr.f240023a != null) {
                    VideoPreDownloadMgr.f240023a.add(VideoPreDownloadMgr.c(null));
                }
            }
            VideoPreDownloadMgr.e(null, null);
            VideoPreDownloadMgr.f(null, null);
            VideoPreDownloadMgr.g(null);
        }
    }

    /* loaded from: classes33.dex */
    class PreDownloadSerialTask implements Runnable {
        final /* synthetic */ VideoPreDownloadMgr this$0;

        @Override // java.lang.Runnable
        public void run() {
            VideoPreDownloadMgr.b(null);
        }
    }

    static /* bridge */ /* synthetic */ t52.b b(VideoPreDownloadMgr videoPreDownloadMgr) {
        throw null;
    }

    static /* bridge */ /* synthetic */ String c(VideoPreDownloadMgr videoPreDownloadMgr) {
        throw null;
    }

    static /* bridge */ /* synthetic */ Set d(VideoPreDownloadMgr videoPreDownloadMgr) {
        throw null;
    }

    static /* bridge */ /* synthetic */ void e(VideoPreDownloadMgr videoPreDownloadMgr, String str) {
        throw null;
    }

    static /* bridge */ /* synthetic */ void f(VideoPreDownloadMgr videoPreDownloadMgr, PlayerVideoInfo playerVideoInfo) {
        throw null;
    }

    static /* bridge */ /* synthetic */ void g(VideoPreDownloadMgr videoPreDownloadMgr) {
        throw null;
    }
}
