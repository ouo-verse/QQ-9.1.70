package com.tencent.biz.pubaccount.weishi.verticalvideo.utils;

import UserGrowth.stFloatingLayerCardStyle;
import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.data.j;
import com.tencent.biz.pubaccount.weishi.verticalvideo.f;
import com.tencent.biz.pubaccount.weishi.verticalvideo.holder.au;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u0015\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J$\u0010\n\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015J0\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u001a\u0010\u001b\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rR\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00150\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001d\u00a8\u0006\""}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/utils/c;", "", "", "g", "", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", VideoTemplateParser.ITEM_LIST, "", "feedId", "f", "a", "itemData", "i", "LUserGrowth/stSimpleMetaFeed;", "newFeedInfo", "j", "", "position", "c", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/f;", "b", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/h;", "d", "", "isFilterFirstData", "isRefresh", "e", h.F, "Lmqq/util/WeakReference;", "Lmqq/util/WeakReference;", "viewRef", "view", "<init>", "(Lcom/tencent/biz/pubaccount/weishi/verticalvideo/h;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private WeakReference<com.tencent.biz.pubaccount.weishi.verticalvideo.h> viewRef;

    public c(com.tencent.biz.pubaccount.weishi.verticalvideo.h view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.viewRef = new WeakReference<>(view);
    }

    private final j a(String feedId, List<j> itemList) {
        x.f("WSVerticalDataFilter", "[filterDataAndRemoveByFeedId] feedId:" + feedId);
        if (!(feedId == null || feedId.length() == 0) && itemList != null && !itemList.isEmpty()) {
            Iterator it = new ArrayList(itemList).iterator();
            while (it.hasNext()) {
                j jVar = (j) it.next();
                stSimpleMetaFeed e16 = jVar != null ? jVar.e() : null;
                if (e16 != null && TextUtils.equals(feedId, e16.f25129id)) {
                    itemList.remove(jVar);
                    return jVar;
                }
            }
            return null;
        }
        x.f("WSVerticalDataFilter", "[filterDataAndRemoveByFeedId] feedId or itemList is empty!");
        return null;
    }

    private final f b() {
        com.tencent.biz.pubaccount.weishi.verticalvideo.h d16 = d();
        if (d16 != null) {
            return d16.getAdapter();
        }
        return null;
    }

    private final j c(int position) {
        f b16 = b();
        if (b16 == null || position < 0) {
            return null;
        }
        return b16.getItem(position);
    }

    private final void f(List<j> itemList, String feedId) {
        j a16 = a(feedId, itemList);
        if (a16 != null) {
            h(c(0), a16.e());
            j(a16.e());
            i(a16);
        }
    }

    private final void g() {
        f b16 = b();
        if (b16 == null) {
            return;
        }
        int t16 = b16.t();
        List<j> dataList = b16.getDataList();
        if (t16 > dataList.size()) {
            return;
        }
        dataList.removeAll(new ArrayList(dataList.subList(t16, dataList.size())));
        b16.notifyItemMoved(t16, dataList.size());
        e.q("[WSVerticalForHomePresenter.java][preFilterDataForRefresh] firstVideo", dataList);
    }

    private final void i(j itemData) {
        com.tencent.biz.pubaccount.weishi.verticalvideo.h d16 = d();
        if (d16 != null) {
            d16.qa(itemData);
        }
    }

    public final com.tencent.biz.pubaccount.weishi.verticalvideo.h d() {
        return this.viewRef.get();
    }

    public final void e(boolean isFilterFirstData, boolean isRefresh, List<j> itemList, String feedId) {
        x.f("WSVerticalDataFilter", "[preFilterData] isFilterFirstData:" + isFilterFirstData + ", isRefresh:" + isRefresh);
        if (isFilterFirstData) {
            f(itemList, feedId);
        } else if (isRefresh) {
            g();
        }
    }

    private final void j(stSimpleMetaFeed newFeedInfo) {
        if (newFeedInfo == null) {
            return;
        }
        f b16 = b();
        au z16 = b16 != null ? b16.z() : null;
        com.tencent.biz.pubaccount.weishi.player.e eVar = z16 != null ? z16.f82114h : null;
        if (eVar == null) {
            return;
        }
        eVar.f81127c = x10.a.a(newFeedInfo);
    }

    public final void h(j itemData, stSimpleMetaFeed newFeedInfo) {
        stFloatingLayerCardStyle stfloatinglayercardstyle;
        if (itemData == null || newFeedInfo == null) {
            return;
        }
        stSimpleMetaFeed e16 = itemData.e();
        stFloatingLayerCardStyle stfloatinglayercardstyle2 = newFeedInfo.floatingLayerCardStyle;
        if (stfloatinglayercardstyle2 != null && e16 != null && (stfloatinglayercardstyle = e16.floatingLayerCardStyle) != null) {
            stfloatinglayercardstyle2.cardType = stfloatinglayercardstyle.cardType;
        }
        newFeedInfo.opInfo = e16.opInfo;
        itemData.p(newFeedInfo);
    }
}
