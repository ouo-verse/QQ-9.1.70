package com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.delegate;

import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/mini/entry/expDesktop/part/adapter/delegate/LimitedTimeRecommendMiniAppInnerRvDelegatesManager;", "Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;", "", "Lcom/tencent/mobileqq/mini/entry/desktop/item/DesktopItemInfo;", "()V", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class LimitedTimeRecommendMiniAppInnerRvDelegatesManager extends AdapterDelegatesManager<List<? extends DesktopItemInfo>> {
    public LimitedTimeRecommendMiniAppInnerRvDelegatesManager() {
        addDelegate(new LimitedTimeRecommendMiniAppInnerRvDelegate());
    }
}
