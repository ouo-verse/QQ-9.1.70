package lk1;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.mobileqq.guild.feed.manager.GuildFeedDetailDataCacheManager;
import com.tencent.mobileqq.guild.feed.preload.detail.data.GuildFeedDetailPreloadParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelSign;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J&\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J0\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016JH\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016R0\u0010\u001a\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u0016j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r`\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Llk1/c;", "Llk1/a;", "", "firstVisiblePos", "lastVisiblePos", "", "k", "", "Ljk1/a;", "feeds", "l", "firstCompletelyVisible", "lastCompletelyVisible", "", "isScrollUp", "j", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "newState", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "manager", "f", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "D", "Ljava/util/HashMap;", "mPreloadBit", "<init>", "()V", "E", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c extends a {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final HashMap<Integer, Boolean> mPreloadBit = new HashMap<>();

    private final void k(int firstVisiblePos, int lastVisiblePos) {
        if (firstVisiblePos >= 0 && lastVisiblePos >= firstVisiblePos) {
            BaseListViewAdapter<jk1.a> baseListViewAdapter = this.f414957i;
            if (baseListViewAdapter == null) {
                QLog.d("Guild_Feed_GAL_GuildFeedGalleryPreloadDetailScroller", 4, "mAdapter == null");
                return;
            }
            List<jk1.a> dataList = baseListViewAdapter.getDataList();
            if (dataList == null) {
                dataList = CollectionsKt__CollectionsKt.emptyList();
            }
            l(firstVisiblePos, lastVisiblePos, dataList);
        }
    }

    private final void l(int firstVisiblePos, int lastVisiblePos, List<jk1.a> feeds) {
        Object orNull;
        GProStFeed b16;
        if (!feeds.isEmpty() && feeds.size() > lastVisiblePos) {
            int i3 = lastVisiblePos + 2;
            ArrayList arrayList = new ArrayList();
            int i16 = firstVisiblePos;
            if (i16 <= i3) {
                while (true) {
                    Boolean bool = this.mPreloadBit.get(Integer.valueOf(i16));
                    Boolean bool2 = Boolean.TRUE;
                    if (!Intrinsics.areEqual(bool, bool2)) {
                        orNull = CollectionsKt___CollectionsKt.getOrNull(feeds, i16);
                        jk1.a aVar = (jk1.a) orNull;
                        if (aVar != null && com.tencent.mobileqq.guild.feed.gallery.b.l(aVar.b()) && (b16 = aVar.b()) != null) {
                            GProStChannelSign gProStChannelSign = b16.channelInfo.sign;
                            long j3 = gProStChannelSign.guildId;
                            long j16 = gProStChannelSign.channelId;
                            String feedId = b16.idd;
                            String userId = b16.poster.idd;
                            long j17 = b16.createTime;
                            long j18 = b16.meta.lastModifiedTime;
                            if (j18 != 0) {
                                Intrinsics.checkNotNullExpressionValue(feedId, "feedId");
                                Intrinsics.checkNotNullExpressionValue(userId, "userId");
                                arrayList.add(new GuildFeedDetailPreloadParams(j3, j16, feedId, userId, j17, j18));
                                QLog.d("Guild_Feed_GAL_GuildFeedGalleryPreloadDetailScroller", 4, "doPreload feeds detail json pos " + i16);
                                this.mPreloadBit.put(Integer.valueOf(i16), bool2);
                            }
                        }
                    }
                    if (i16 == i3) {
                        break;
                    } else {
                        i16++;
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            try {
                GuildFeedDetailDataCacheManager.y().s(arrayList);
            } catch (Exception e16) {
                QLog.e("Guild_Feed_GAL_GuildFeedGalleryPreloadDetailScroller", 1, "getFeedDetailFromNet error! feeds size" + feeds.size(), e16);
            }
        }
    }

    @Override // lk1.a
    public void f(@NotNull RecyclerView recyclerView, int newState, @NotNull RecyclerView.LayoutManager manager, int firstVisiblePos, int lastVisiblePos, int firstCompletelyVisible, int lastCompletelyVisible, boolean isScrollUp) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(manager, "manager");
        if (newState == 0) {
            k(firstVisiblePos, lastVisiblePos);
        }
    }

    @Override // lk1.a
    public void j(int firstVisiblePos, int lastVisiblePos, int firstCompletelyVisible, int lastCompletelyVisible, boolean isScrollUp) {
        if (isScrollUp) {
            k(firstVisiblePos, lastVisiblePos);
        }
    }
}
