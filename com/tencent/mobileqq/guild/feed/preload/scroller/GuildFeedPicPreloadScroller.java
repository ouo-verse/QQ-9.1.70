package com.tencent.mobileqq.guild.feed.preload.scroller;

import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.guild.feed.manager.b;
import com.tencent.mobileqq.guild.feed.util.bm;
import com.tencent.mobileqq.guild.picload.e;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import com.tencent.richframework.thread.RFWThreadManager;
import ij1.g;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes13.dex */
public class GuildFeedPicPreloadScroller extends b {
    private final ConcurrentHashMap<String, Boolean> E = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public class a extends GuildPicStateListener {
        a(boolean z16) {
            super(z16);
        }

        @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
        public void c(LoadState loadState, Option option) {
            GuildFeedPicPreloadScroller.this.x(loadState, option);
        }
    }

    private void A(final GProStFeed gProStFeed) {
        RFWThreadManager.getInstance().execOnAsyncDisplayThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.preload.scroller.GuildFeedPicPreloadScroller.1
            @Override // java.lang.Runnable
            public void run() {
                GuildFeedPicPreloadScroller.this.z(gProStFeed);
                GuildFeedPicPreloadScroller.this.B(gProStFeed);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(GProStFeed gProStFeed) {
        if (gProStFeed.videos.size() > 0) {
            Iterator<GProStVideo> it = gProStFeed.videos.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                GProStVideo next = it.next();
                if (i3 < 3) {
                    if (!TextUtils.isEmpty(next.cover.picUrl)) {
                        i3++;
                        y(true, next.cover.picUrl);
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void u() {
        RFWThreadManager.getInstance().execOnAsyncDisplayThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.preload.scroller.GuildFeedPicPreloadScroller.3
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = GuildFeedPicPreloadScroller.this.E.keySet().iterator();
                while (it.hasNext()) {
                    Boolean bool = (Boolean) GuildFeedPicPreloadScroller.this.E.get((String) it.next());
                    if (bool != null && !bool.booleanValue()) {
                        it.remove();
                    }
                }
            }
        });
    }

    private void v(int i3, int i16) {
        List<g> dataList;
        if (d() && i3 >= 0 && i16 >= i3 && (dataList = this.f220168m.getDataList()) != null && dataList.size() > i16) {
            QLog.d("QCircleFeedPicPreloadScroller", 4, "feeds size" + dataList.size());
            w(i3, dataList);
        }
    }

    private void w(int i3, List<g> list) {
        try {
            Iterator<g> it = list.subList(i3, list.size()).iterator();
            while (it.hasNext()) {
                GProStFeed b16 = it.next().b();
                if (b16 != null) {
                    A(b16);
                }
            }
        } catch (Exception unused) {
            QLog.e("QCircleFeedPicPreloadScroller", 4, "feeds size" + list.size());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(LoadState loadState, Option option) {
        if (loadState == LoadState.STATE_SUCCESS || loadState == LoadState.STATE_DOWNLOAD_SUCCESS) {
            this.E.put(option.getCacheKey().toString(), Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(GProStFeed gProStFeed) {
        if (gProStFeed.images.size() > 0) {
            Iterator<GProStImage> it = gProStFeed.images.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                GProStImage next = it.next();
                if (i3 < 3) {
                    String h16 = bm.h(next);
                    if (!TextUtils.isEmpty(h16)) {
                        y(true, h16);
                    }
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.manager.b
    public void f(RecyclerView recyclerView) {
        super.f(recyclerView);
    }

    @Override // com.tencent.mobileqq.guild.feed.manager.b
    public void g() {
        u();
    }

    @Override // com.tencent.mobileqq.guild.feed.manager.b
    public void j(RecyclerView recyclerView, int i3, RecyclerView.LayoutManager layoutManager, int i16, int i17, int i18, int i19, boolean z16) {
        if (i3 == 0 && z16) {
            v(i16, i17);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.manager.b
    public void onDestroy() {
        QLog.d("QCircleFeedPicPreloadScroller", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        u();
        this.E.clear();
    }

    @Override // com.tencent.mobileqq.guild.feed.manager.b
    public void p(int i3, int i16, int i17, int i18, boolean z16) {
        if (z16) {
            v(i3, i16);
        }
    }

    public void y(boolean z16, String str) {
        Option url = new Option().setFromPreLoad(true).setPredecode(z16).setUrl(str);
        String libraRequestKey = e.a().b(url).toString();
        if (!this.E.containsKey(libraRequestKey)) {
            e.a().f(url, new a(true));
            this.E.put(libraRequestKey, Boolean.FALSE);
        }
    }
}
