package com.tencent.mobileqq.guild.feed.preload.scroller;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedNativeDetailApi;
import com.tencent.mobileqq.guild.feed.manager.GuildFeedDetailDataCacheManager;
import com.tencent.mobileqq.guild.feed.manager.b;
import com.tencent.mobileqq.guild.feed.manager.e;
import com.tencent.mobileqq.guild.feed.preload.detail.data.GuildFeedDetailPreloadParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelSign;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.richframework.thread.RFWThreadManager;
import ij1.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes13.dex */
public class GuildFeedPreloadDetailScroller extends b {
    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        e eVar = this.f220163d;
        if (eVar == null) {
            QLog.d("GuildFeedPreloadDetailScroller", 4, "mHelper == null");
            return;
        }
        int[] e16 = eVar.e();
        if (e16 != null && e16.length >= 2) {
            s(e16[0], e16[1]);
        }
    }

    private void s(int i3, int i16) {
        if (i3 >= 0 && i16 >= i3) {
            BaseListViewAdapter<g> baseListViewAdapter = this.f220168m;
            if (baseListViewAdapter == null) {
                QLog.d("GuildFeedPreloadDetailScroller", 4, "mAdapter == null");
                return;
            }
            List<g> dataList = baseListViewAdapter.getDataList();
            if (dataList != null && dataList.size() > i16) {
                QLog.d("GuildFeedPreloadDetailScroller", 4, "feeds size" + dataList.size());
                t(i3, i16, dataList);
            }
        }
    }

    private void t(int i3, int i16, List<g> list) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
        } catch (Exception unused) {
        }
        try {
            Iterator<g> it = list.subList(i3, i16 + 1).iterator();
            while (it.hasNext()) {
                GProStFeed b16 = it.next().b();
                if (b16 != null) {
                    GProStChannelSign gProStChannelSign = b16.channelInfo.sign;
                    GuildFeedDetailPreloadParams guildFeedDetailPreloadParams = new GuildFeedDetailPreloadParams(gProStChannelSign.guildId, gProStChannelSign.channelId, b16.idd, b16.poster.idd, b16.createTime, b16.meta.lastModifiedTime);
                    if (((IGuildFeedNativeDetailApi) QRoute.api(IGuildFeedNativeDetailApi.class)).checkCanPreload(b16)) {
                        arrayList.add(guildFeedDetailPreloadParams);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            GuildFeedDetailDataCacheManager.y().s(arrayList);
        } catch (Exception unused2) {
            QLog.e("GuildFeedPreloadDetailScroller", 4, "feeds size" + list.size());
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.manager.b
    public void h() {
        super.h();
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.preload.scroller.GuildFeedPreloadDetailScroller.1
            @Override // java.lang.Runnable
            public void run() {
                GuildFeedPreloadDetailScroller.this.r();
            }
        }, 100L);
    }

    @Override // com.tencent.mobileqq.guild.feed.manager.b
    public void j(RecyclerView recyclerView, int i3, RecyclerView.LayoutManager layoutManager, int i16, int i17, int i18, int i19, boolean z16) {
        if (i3 == 0) {
            s(i16, i17);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.manager.b
    public void p(int i3, int i16, int i17, int i18, boolean z16) {
        if (z16) {
            s(i3, i16);
        }
    }
}
