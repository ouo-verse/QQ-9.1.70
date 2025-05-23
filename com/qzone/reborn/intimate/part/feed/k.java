package com.qzone.reborn.intimate.part.feed;

import android.app.Activity;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.intimate.event.QZoneIntimateDeleteFeedEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nk.aq;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/qzone/reborn/intimate/part/feed/k;", "Lcom/qzone/reborn/intimate/part/feed/QZoneIntimateBaseFeedOperateDialogPart;", "", "action", "", "args", "", "handleBroadcastMessage", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "N9", "getDtPageId", "Lnk/aq;", "f", "Lnk/aq;", "mDetailViewModel", "<init>", "()V", tl.h.F, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class k extends QZoneIntimateBaseFeedOperateDialogPart {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private aq mDetailViewModel;

    @Override // com.qzone.reborn.intimate.part.feed.QZoneIntimateBaseFeedOperateDialogPart
    public void N9(BusinessFeedData feedData) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        SimpleEventBus.getInstance().dispatchEvent(new QZoneIntimateDeleteFeedEvent(feedData));
        Activity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.qzone.reborn.intimate.part.feed.QZoneIntimateBaseFeedOperateDialogPart
    public String getDtPageId() {
        return "pg_qz_dynamic_detail_page";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(String action, Object args) {
        if (Intrinsics.areEqual(action, "toggle_share_panel")) {
            if (this.mDetailViewModel == null) {
                this.mDetailViewModel = (aq) getViewModel(aq.class);
            }
            aq aqVar = this.mDetailViewModel;
            h2(aqVar != null ? aqVar.P1() : null, 0, null);
        }
    }
}
