package com.tencent.biz.pubaccount.weishi.verticalvideo.utils;

import UserGrowth.stSimpleGetFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import android.os.Looper;
import com.tencent.biz.pubaccount.weishi.util.s;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.i;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.j;
import com.tencent.biz.pubaccount.weishi.verticalvideo.f;
import com.tencent.biz.pubaccount.weishi.verticalvideo.h;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSVerticalTrendsCacheUtils {
    static /* bridge */ /* synthetic */ String a() {
        return f();
    }

    private static List<j> e() {
        stSimpleGetFeedListRsp stsimplegetfeedlistrsp = (stSimpleGetFeedListRsp) s.c(new stSimpleGetFeedListRsp(), f());
        if (stsimplegetfeedlistrsp == null) {
            return new ArrayList();
        }
        return i.d(stsimplegetfeedlistrsp.feeds);
    }

    private static String f() {
        File cacheDir;
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        if (application != null && (cacheDir = application.getCacheDir()) != null) {
            return cacheDir.getAbsolutePath() + "/file/weishi/ws_trends_data";
        }
        return "";
    }

    public static void c(h hVar) {
        f adapter;
        if (hVar == null || (adapter = hVar.getAdapter()) == null) {
            return;
        }
        int t16 = adapter.t();
        stSimpleMetaFeed r16 = adapter.r(t16);
        if (r16 != null && r16.video_type == 2) {
            r16 = adapter.r(t16 + 1);
        }
        if (r16 == null) {
            r16 = adapter.r(t16 - 1);
        }
        b(r16);
        com.tencent.biz.pubaccount.weishi.cache.e.b(r16);
    }

    private static void b(final stSimpleMetaFeed stsimplemetafeed) {
        if (stsimplemetafeed == null) {
            return;
        }
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.utils.WSVerticalTrendsCacheUtils.2
            @Override // java.lang.Runnable
            public void run() {
                ArrayList<stSimpleMetaFeed> arrayList = new ArrayList<>();
                arrayList.add(stSimpleMetaFeed.this);
                stSimpleGetFeedListRsp stsimplegetfeedlistrsp = new stSimpleGetFeedListRsp();
                stsimplegetfeedlistrsp.feeds = arrayList;
                x.j("WSVerticalTrendsCacheUtils", "[asyncSaveDataToFile] isSuccess:" + s.d(stsimplegetfeedlistrsp, WSVerticalTrendsCacheUtils.a()) + ", title:" + stSimpleMetaFeed.this.feed_desc);
            }
        });
    }

    public static void d(boolean z16, final jz.c<j> cVar) {
        if (z16) {
            final List<j> e16 = e();
            if (e16.size() == 0) {
                return;
            }
            Runnable runnable = new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.verticalvideo.utils.WSVerticalTrendsCacheUtils.1
                @Override // java.lang.Runnable
                public void run() {
                    jz.c cVar2 = jz.c.this;
                    if (cVar2 != null) {
                        cVar2.d0(e16, false, true, null);
                    }
                }
            };
            if (Looper.myLooper() != Looper.getMainLooper()) {
                ThreadManager.getUIHandler().post(runnable);
            } else {
                runnable.run();
            }
        }
    }
}
