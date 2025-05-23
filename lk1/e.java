package lk1;

import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.mobileqq.guild.feed.gallery.event.GuildFeedGalleryImmersiveEvent;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedGalleryInitBean;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J0\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\bH\u0016JH\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\bH\u0016R\u0016\u0010\u0017\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R0\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0018j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b`\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR0\u0010\u001e\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0018j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b`\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001b\u00a8\u0006#"}, d2 = {"Llk1/e;", "Llk1/a;", "", "firstVisiblePos", "lastVisiblePos", "", "l", "k", "", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "firstCompletelyVisible", "lastCompletelyVisible", "isScrollUp", "j", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "newState", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "manager", "f", "D", "I", "immersivePreloadInterval", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "E", "Ljava/util/HashMap;", "mImmersivePreloadBit", UserInfo.SEX_FEMALE, "mPicPreloadBit", "<init>", "()V", "G", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e extends a {

    /* renamed from: D, reason: from kotlin metadata */
    private int immersivePreloadInterval = -1;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final HashMap<Integer, Boolean> mImmersivePreloadBit;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final HashMap<Integer, Boolean> mPicPreloadBit;

    public e() {
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        Boolean bool = Boolean.TRUE;
        hashMap.put(0, bool);
        this.mImmersivePreloadBit = hashMap;
        HashMap<Integer, Boolean> hashMap2 = new HashMap<>();
        hashMap2.put(0, bool);
        this.mPicPreloadBit = hashMap2;
    }

    private final void k(int firstVisiblePos, int lastVisiblePos) {
        if (firstVisiblePos >= 0 && lastVisiblePos >= firstVisiblePos) {
            BaseListViewAdapter<jk1.a> baseListViewAdapter = this.f414957i;
            if (baseListViewAdapter == null) {
                QLog.d("Guild_Feed_GAL_ImmersiveFeedPreloadScroller", 1, "mAdapter == null");
                return;
            }
            List<jk1.a> dataList = baseListViewAdapter.getDataList();
            if (dataList != null && dataList.size() > lastVisiblePos && n(lastVisiblePos)) {
                int size = dataList.size();
                if (lastVisiblePos <= size) {
                    int i3 = lastVisiblePos;
                    while (true) {
                        this.mImmersivePreloadBit.put(Integer.valueOf(i3), Boolean.TRUE);
                        if (i3 == size) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
                Logger.f235387a.d().d("Guild_Feed_GAL_ImmersiveFeedPreloadScroller", 1, "[checkPreload] PreloadImmersiveFeedList lastVisiblePos[" + lastVisiblePos + "]");
                SimpleEventBus.getInstance().dispatchEvent(new GuildFeedGalleryImmersiveEvent.PreloadFeedList());
            }
        }
    }

    private final void l(int firstVisiblePos, int lastVisiblePos) {
        int i3;
        Object orNull;
        ArrayList<GProStImage> arrayList;
        if (firstVisiblePos >= 0 && lastVisiblePos >= firstVisiblePos) {
            BaseListViewAdapter<jk1.a> baseListViewAdapter = this.f414957i;
            if (baseListViewAdapter == null) {
                QLog.d("Guild_Feed_GAL_ImmersiveFeedPreloadScroller", 1, "mAdapter == null");
                return;
            }
            List<jk1.a> dataList = baseListViewAdapter.getDataList();
            if (dataList == null || dataList.size() <= lastVisiblePos || lastVisiblePos > (i3 = lastVisiblePos + 2)) {
                return;
            }
            while (true) {
                Boolean bool = this.mPicPreloadBit.get(Integer.valueOf(lastVisiblePos));
                Boolean bool2 = Boolean.TRUE;
                if (!Intrinsics.areEqual(bool, bool2)) {
                    orNull = CollectionsKt___CollectionsKt.getOrNull(dataList, lastVisiblePos);
                    jk1.a aVar = (jk1.a) orNull;
                    if (aVar != null) {
                        Logger.f235387a.d().d("Guild_Feed_GAL_ImmersiveFeedPreloadScroller", 1, "[checkPreload] preloadPic pos: " + lastVisiblePos);
                        com.tencent.mobileqq.guild.feed.gallery.d dVar = com.tencent.mobileqq.guild.feed.gallery.d.f219630a;
                        GProStFeed b16 = aVar.b();
                        if (b16 != null) {
                            arrayList = b16.images;
                        } else {
                            arrayList = null;
                        }
                        dVar.c(arrayList);
                        this.mPicPreloadBit.put(Integer.valueOf(lastVisiblePos), bool2);
                    }
                }
                if (lastVisiblePos != i3) {
                    lastVisiblePos++;
                } else {
                    return;
                }
            }
        }
    }

    private final boolean m() {
        Object orNull;
        int i3;
        GuildFeedGalleryInitBean initBean;
        List<jk1.a> dataList = this.f414957i.getDataList();
        Intrinsics.checkNotNullExpressionValue(dataList, "mAdapter.dataList");
        orNull = CollectionsKt___CollectionsKt.getOrNull(dataList, 0);
        jk1.a aVar = (jk1.a) orNull;
        if (aVar != null && (initBean = aVar.getInitBean()) != null) {
            i3 = initBean.getImmersiveSource();
        } else {
            i3 = 6;
        }
        if (i3 != 2 && i3 != 3 && i3 != 5 && i3 != 6 && i3 != 12 && i3 != 13) {
            return false;
        }
        return true;
    }

    private final boolean n(int lastVisiblePos) {
        int i3;
        if (Intrinsics.areEqual(this.mImmersivePreloadBit.get(Integer.valueOf(lastVisiblePos)), Boolean.TRUE)) {
            return false;
        }
        int size = this.f414957i.getDataList().size() - lastVisiblePos;
        if (this.immersivePreloadInterval == -1) {
            if (m()) {
                i3 = 3;
            } else {
                i3 = 1;
            }
            this.immersivePreloadInterval = i3;
        }
        if (size > this.immersivePreloadInterval) {
            return false;
        }
        return true;
    }

    @Override // lk1.a
    public void f(@NotNull RecyclerView recyclerView, int newState, @NotNull RecyclerView.LayoutManager manager, int firstVisiblePos, int lastVisiblePos, int firstCompletelyVisible, int lastCompletelyVisible, boolean isScrollUp) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(manager, "manager");
        if (newState == 0) {
            k(firstVisiblePos, lastVisiblePos);
            l(firstVisiblePos, lastVisiblePos);
        }
    }

    @Override // lk1.a
    public void j(int firstVisiblePos, int lastVisiblePos, int firstCompletelyVisible, int lastCompletelyVisible, boolean isScrollUp) {
        if (isScrollUp) {
            k(firstVisiblePos, lastVisiblePos);
            l(firstVisiblePos, lastVisiblePos);
        }
    }
}
