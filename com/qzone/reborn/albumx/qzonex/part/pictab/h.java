package com.qzone.reborn.albumx.qzonex.part.pictab;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.albumx.qzonex.event.QZAlbumxTopAndRefreshEvent;
import com.qzone.reborn.widget.QZoneBlankStateView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nc.bn;
import nc.bp;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0016\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0014J\u0016\u0010\f\u001a\u00020\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0014J\u0016\u0010\r\u001a\u00020\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0014J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/part/pictab/h;", "Lcom/qzone/reborn/albumx/qzonex/part/pictab/QZAlbumTabListPart;", "Lnc/bn;", "A7", "", "getLogTag", "Lcom/tencent/richframework/data/base/UIStateData;", "Lcb/a;", "listUIStateData", "", "U9", "uiStateData", "R9", "da", "Lcom/qzone/reborn/albumx/qzonex/event/QZAlbumxTopAndRefreshEvent;", "event", "T9", "Lnc/bp;", "mediaViewModel", "<init>", "(Lnc/bp;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class h extends QZAlbumTabListPart {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(bp mediaViewModel) {
        super(mediaViewModel);
        Intrinsics.checkNotNullParameter(mediaViewModel, "mediaViewModel");
    }

    private final bn A7() {
        hb.i iVar = (hb.i) getIocInterface(hb.i.class);
        if (iVar != null) {
            return iVar.A7();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ia(h this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Z9(5);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.qzonex.part.pictab.QZAlbumTabListPart
    public void R9(UIStateData<cb.a> uiStateData) {
        MutableLiveData<Boolean> j26;
        MutableLiveData<Boolean> j27;
        Intrinsics.checkNotNullParameter(uiStateData, "uiStateData");
        super.R9(uiStateData);
        if (uiStateData.getData().g().isEmpty()) {
            bn A7 = A7();
            if (A7 == null || (j27 = A7.j2()) == null) {
                return;
            }
            j27.postValue(Boolean.FALSE);
            return;
        }
        bn A72 = A7();
        if (A72 == null || (j26 = A72.j2()) == null) {
            return;
        }
        j26.postValue(Boolean.TRUE);
    }

    @Override // com.qzone.reborn.albumx.qzonex.part.pictab.QZAlbumTabListPart
    protected void T9(QZAlbumxTopAndRefreshEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        QLog.d(getTAG(), 1, "[handleTopAndRefreshEvent] albumId = " + event.getAlbumId());
        if (event.getFrom() == 1) {
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
        uc.a p16;
        Intrinsics.checkNotNullParameter(listUIStateData, "listUIStateData");
        boolean areEqual = Intrinsics.areEqual(getMediaViewModel().getUin(), String.valueOf(LoginData.getInstance().getUin()));
        QZoneBlankStateView K9 = K9();
        if (areEqual) {
            p16 = com.qzone.reborn.feedx.util.k.q(getContext(), new View.OnClickListener() { // from class: com.qzone.reborn.albumx.qzonex.part.pictab.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    h.ia(h.this, view);
                }
            });
        } else if (listUIStateData.getData() != null && listUIStateData.getData().getPageEndMsg().getCode() == 10087) {
            p16 = com.qzone.reborn.feedx.util.k.o(getContext(), listUIStateData.getData().getPageEndMsg().getContent(), listUIStateData.getData().getPageEndMsg().getDesc());
        } else {
            p16 = com.qzone.reborn.feedx.util.k.p(getContext());
        }
        K9.setData(p16);
        QLog.d(getTAG(), 1, "[initBlankViewData] isOwner:" + areEqual);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.albumx.qzonex.part.pictab.QZAlbumTabListPart
    public void da(UIStateData<cb.a> uiStateData) {
        MutableLiveData<Boolean> j26;
        Intrinsics.checkNotNullParameter(uiStateData, "uiStateData");
        super.da(uiStateData);
        bn A7 = A7();
        if (A7 == null || (j26 = A7.j2()) == null) {
            return;
        }
        j26.postValue(Boolean.FALSE);
    }

    @Override // com.qzone.reborn.albumx.qzonex.part.pictab.QZAlbumTabListPart, com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumTabPicListPart";
    }
}
