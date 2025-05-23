package com.tencent.mobileqq.guild.feed.preload.scroller;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.api.FeedPreloadInfo;
import com.tencent.mobileqq.guild.api.a;
import com.tencent.mobileqq.guild.api.d;
import com.tencent.mobileqq.guild.feed.manager.GuildFeedDetailDataCacheManager;
import com.tencent.mobileqq.guild.feed.preload.detail.data.GuildFeedDetailPreloadParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes13.dex */
public class GuildFeedPreloadDetailInfoScroller extends a {
    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        d dVar = this.f214360d;
        if (dVar == null) {
            QLog.d("GuildFeedPreloadDetailInfoScroller", 4, "mHelper == null");
            return;
        }
        int[] d16 = dVar.d();
        if (d16.length < 2) {
            return;
        }
        k(d16[0], d16[1]);
    }

    private void k(int i3, int i16) {
        if (i3 >= 0 && i16 >= i3) {
            l(i3, i16 + 1);
        }
    }

    private void l(int i3, int i16) {
        try {
            ArrayList arrayList = new ArrayList();
            try {
                List<FeedPreloadInfo> a16 = this.f214363h.a(i3, i16);
                QLog.i("GuildFeedPreloadDetailInfoScroller", 4, "\n\n=======================doPreload size=" + a16.size() + ", firstVisiblePos=" + i3 + ", lastVisiblePos=" + i16);
                for (FeedPreloadInfo feedPreloadInfo : a16) {
                    if (feedPreloadInfo != null) {
                        GuildFeedDetailPreloadParams guildFeedDetailPreloadParams = new GuildFeedDetailPreloadParams(feedPreloadInfo.getGuildId(), feedPreloadInfo.getChannelId(), feedPreloadInfo.getFeedId(), feedPreloadInfo.getUserId(), feedPreloadInfo.getCreateTime(), feedPreloadInfo.getLastModified());
                        QLog.i("GuildFeedPreloadDetailInfoScroller", 4, "doPreload title=" + feedPreloadInfo.getTitle().trim().replace("\n", "") + " feedId=" + guildFeedDetailPreloadParams.getFeedId());
                        arrayList.add(guildFeedDetailPreloadParams);
                    }
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                GuildFeedDetailDataCacheManager.y().s(arrayList);
            } catch (Exception e16) {
                e = e16;
                QLog.e("GuildFeedPreloadDetailInfoScroller", 1, "doPreload err " + QLog.getStackTraceString(e));
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    @Override // com.tencent.mobileqq.guild.api.a
    public void c() {
        super.c();
        RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.preload.scroller.GuildFeedPreloadDetailInfoScroller.1
            @Override // java.lang.Runnable
            public void run() {
                GuildFeedPreloadDetailInfoScroller.this.j();
            }
        }, 100L);
    }

    @Override // com.tencent.mobileqq.guild.api.a
    public void e(RecyclerView recyclerView, int i3, RecyclerView.LayoutManager layoutManager, int i16, int i17, int i18, int i19, boolean z16) {
        if (i3 == 0) {
            k(i16, i17);
        }
    }

    @Override // com.tencent.mobileqq.guild.api.a
    public void h(int i3, int i16, int i17, int i18, boolean z16) {
        if (z16) {
            k(i3, i16);
        }
    }
}
