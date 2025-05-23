package com.qzone.reborn.albumx.qzonex.part.videotab;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.albumx.qzonex.event.QZAlbumxTopAndRefreshEvent;
import com.qzone.reborn.albumx.qzonex.part.pictab.QZAlbumTabListPart;
import com.qzone.reborn.feedx.util.k;
import com.qzone.reborn.widget.QZoneBlankStateView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nc.bp;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0014J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0014\u00a8\u0006\u0010"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/videotab/b;", "Lcom/qzone/reborn/albumx/qzonex/part/pictab/QZAlbumTabListPart;", "", "getLogTag", "Lcom/tencent/richframework/data/base/UIStateData;", "Lcb/a;", "listUIStateData", "", "U9", "Lcom/qzone/reborn/albumx/qzonex/event/QZAlbumxTopAndRefreshEvent;", "event", "T9", "Lnc/bp;", "mediaViewModel", "<init>", "(Lnc/bp;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class b extends QZAlbumTabListPart {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(bp mediaViewModel) {
        super(mediaViewModel);
        Intrinsics.checkNotNullParameter(mediaViewModel, "mediaViewModel");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ia(b this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Z9(4);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.qzone.reborn.albumx.qzonex.part.pictab.QZAlbumTabListPart
    protected void T9(QZAlbumxTopAndRefreshEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        QLog.d(getTAG(), 1, "[handleTopAndRefreshEvent] albumId = " + event.getAlbumId());
        if (event.getFrom() == 2) {
            RecyclerView N9 = N9();
            if (N9 != null) {
                N9.scrollToPosition(0);
            }
            SmartRefreshLayout O9 = O9();
            if (O9 != null) {
                O9.autoRefresh();
            }
        }
    }

    @Override // com.qzone.reborn.albumx.qzonex.part.pictab.QZAlbumTabListPart
    protected void U9(UIStateData<cb.a> listUIStateData) {
        uc.a r16;
        Intrinsics.checkNotNullParameter(listUIStateData, "listUIStateData");
        boolean areEqual = Intrinsics.areEqual(getMediaViewModel().getUin(), String.valueOf(LoginData.getInstance().getUin()));
        QZoneBlankStateView K9 = K9();
        if (areEqual) {
            r16 = k.s(getContext(), new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.videotab.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    b.ia(b.this, view);
                }
            });
        } else if (listUIStateData.getData() != null && listUIStateData.getData().getPageEndMsg().getCode() == 10087) {
            r16 = k.o(getContext(), listUIStateData.getData().getPageEndMsg().getContent(), listUIStateData.getData().getPageEndMsg().getDesc());
        } else {
            r16 = k.r(getContext());
        }
        K9.setData(r16);
        QLog.d(getTAG(), 1, "[initBlankViewData] isOwner:" + areEqual);
    }

    @Override // com.qzone.reborn.albumx.qzonex.part.pictab.QZAlbumTabListPart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumTabVideoListPart";
    }
}
