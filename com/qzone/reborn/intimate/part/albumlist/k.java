package com.qzone.reborn.intimate.part.albumlist;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.lifecycle.ViewModel;
import com.qzone.reborn.albumx.common.bean.CommonAlbumListBean;
import com.qzone.reborn.intimate.bean.init.QZoneIntimateAlbumSyncInitBean;
import com.qzone.reborn.intimate.event.QZoneIntimateAlbumSyncEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nk.ae;
import nk.z;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 *2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001+B\u0007\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\nH\u0016J$\u0010\u0014\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00120\u0011j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0012`\u0013H\u0016J\u0012\u0010\u0015\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016J \u0010\u0018\u001a\u00020\u00052\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0011j\b\u0012\u0004\u0012\u00020\u0016`\u0013H\u0016J\u0012\u0010\u001b\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006,"}, d2 = {"Lcom/qzone/reborn/intimate/part/albumlist/k;", "Lcom/qzone/reborn/base/k;", "Lqj/g;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "initViewModel", "Lcom/qzone/reborn/intimate/event/QZoneIntimateAlbumSyncEvent;", "event", "D9", "", "F9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "isEmptyPage", "E2", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "onReceiveEvent", "", "albumId", "i2", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "", "d", "I", "mRefreshTimes", "Lnk/z;", "e", "Lnk/z;", "mAlbumViewModel", "Lnk/ae;", "f", "Lnk/ae;", "mSyncViewModel", "<init>", "()V", tl.h.F, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class k extends com.qzone.reborn.base.k implements qj.g, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mRefreshTimes;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private z mAlbumViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ae mSyncViewModel;

    private final void D9(final QZoneIntimateAlbumSyncEvent event) {
        z zVar = this.mAlbumViewModel;
        if (zVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            zVar = null;
        }
        zVar.f2(false);
        RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.qzone.reborn.intimate.part.albumlist.j
            @Override // java.lang.Runnable
            public final void run() {
                k.E9(k.this, event);
            }
        }, com.qzone.reborn.configx.g.f53821a.h().s());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(k this$0, QZoneIntimateAlbumSyncEvent event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(event, "$event");
        int r16 = com.qzone.reborn.configx.g.f53821a.h().r();
        if (!this$0.F9(event) || this$0.mRefreshTimes >= r16) {
            return;
        }
        this$0.D9(event);
        this$0.mRefreshTimes++;
    }

    private final boolean F9(QZoneIntimateAlbumSyncEvent event) {
        z zVar = this.mAlbumViewModel;
        z zVar2 = null;
        if (zVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            zVar = null;
        }
        if (bl.b(zVar.T1())) {
            RFWLog.e("QZoneIntimateAlbumListSyncPart", RFWLog.USR, "[hasInSyncSelectAlbum] mAllAlbumList is null");
            return false;
        }
        String spaceId = event.getSpaceId();
        z zVar3 = this.mAlbumViewModel;
        if (zVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            zVar3 = null;
        }
        if (!Intrinsics.areEqual(spaceId, zVar3.getMSpaceId())) {
            RFWLog.e("QZoneIntimateAlbumListSyncPart", RFWLog.USR, "[hasInSyncSelectAlbum] spaceId " + event.getSpaceId());
            return false;
        }
        z zVar4 = this.mAlbumViewModel;
        if (zVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
        } else {
            zVar2 = zVar4;
        }
        Iterator<CommonAlbumListBean> it = zVar2.T1().iterator();
        while (it.hasNext()) {
            if (2 == it.next().getAlbumInfo().getStatus()) {
                RFWLog.d("QZoneIntimateAlbumListSyncPart", RFWLog.USR, "[hasInSyncSelectAlbum] album in sync");
                return true;
            }
        }
        return false;
    }

    private final void initViewModel() {
        ViewModel viewModel = getViewModel(z.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "getViewModel(QZoneIntima\u2026istViewModel::class.java)");
        this.mAlbumViewModel = (z) viewModel;
        ViewModel viewModel2 = getViewModel(ae.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "getViewModel(QZoneIntima\u2026yncViewModel::class.java)");
        this.mSyncViewModel = (ae) viewModel2;
    }

    @Override // qj.g
    public void E2(boolean isEmptyPage) {
        ck.c o16 = ho.i.o();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        QZoneIntimateAlbumSyncInitBean qZoneIntimateAlbumSyncInitBean = new QZoneIntimateAlbumSyncInitBean();
        z zVar = this.mAlbumViewModel;
        if (zVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAlbumViewModel");
            zVar = null;
        }
        qZoneIntimateAlbumSyncInitBean.setSpaceId(zVar.getMSpaceId());
        String qqStr = HardCodeUtil.qqStr(R.string.v7g);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.qzone_int\u2026te_album_sync_title_text)");
        qZoneIntimateAlbumSyncInitBean.setTitle(qqStr);
        Unit unit = Unit.INSTANCE;
        o16.l(context, qZoneIntimateAlbumSyncInitBean);
    }

    @Override // qj.g
    public void i2(ArrayList<String> albumId) {
        Intrinsics.checkNotNullParameter(albumId, "albumId");
        ae aeVar = this.mSyncViewModel;
        if (aeVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSyncViewModel");
            aeVar = null;
        }
        aeVar.g2(albumId);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        SimpleEventBus.getInstance().registerReceiver(this);
        registerIoc(this, qj.g.class);
        initViewModel();
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof QZoneIntimateAlbumSyncEvent) {
            D9((QZoneIntimateAlbumSyncEvent) event);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QZoneIntimateAlbumSyncEvent.class);
        return arrayListOf;
    }
}
