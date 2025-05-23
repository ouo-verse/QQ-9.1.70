package com.qzone.reborn.feedpro.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.qzone.reborn.feedpro.banner.topbanner.constant.FeedProTopBannerType;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tianshu.event.TianshuRedDataChangeEvent;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001 B\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\r\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\u0014\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00120\u0011j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0012`\u0013H\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/qzone/reborn/feedpro/part/y;", "Lcom/qzone/reborn/feedpro/part/b;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "F9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lsd/a;", "d", "Lsd/a;", "bannerManagerIoc", "Lcom/qzone/reborn/feedpro/viewmodel/n;", "e", "Lcom/qzone/reborn/feedpro/viewmodel/n;", "scrollViewModel", "<init>", "()V", "f", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class y extends b implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private sd.a bannerManagerIoc;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.qzone.reborn.feedpro.viewmodel.n scrollViewModel;

    private final void F9() {
        dh.d dVar = dh.d.f393812a;
        dh.c x16 = dVar.x();
        dh.c u16 = dVar.u();
        final qd.a aVar = new qd.a();
        aVar.g(FeedProTopBannerType.TYPE_TOP_MSG_BANNER);
        aVar.i(2);
        com.qzone.reborn.feedpro.viewmodel.n nVar = this.scrollViewModel;
        boolean z16 = false;
        if (nVar != null && !nVar.getIsPublishBarCeilingEnd()) {
            z16 = true;
        }
        if (z16) {
            QLog.i("QzoneFeedProTopMsgPart", 1, "has shown hot banner, no need to show top banner");
            return;
        }
        if (dVar.m(x16)) {
            aVar.e(FeedProTopBannerType.TYPE_SECOND_NEW_MSG);
            String a16 = com.qzone.util.l.a(R.string.f17674323);
            Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.push_message_bubble_new_message)");
            aVar.f(a16);
            aVar.h(dh.b.c(dVar.y()));
            runOnActivityUiThread(new Runnable() { // from class: com.qzone.reborn.feedpro.part.w
                @Override // java.lang.Runnable
                public final void run() {
                    y.G9(y.this, aVar);
                }
            });
            return;
        }
        if (dVar.l(u16)) {
            aVar.e(FeedProTopBannerType.TYPE_SECOND_FRIEND_UPDATE);
            String a17 = com.qzone.util.l.a(R.string.f17673322);
            Intrinsics.checkNotNullExpressionValue(a17, "qqStr(R.string.push_message_bubble_feed_update)");
            aVar.f(a17);
            aVar.h(dh.b.c(dVar.v()));
            runOnActivityUiThread(new Runnable() { // from class: com.qzone.reborn.feedpro.part.x
                @Override // java.lang.Runnable
                public final void run() {
                    y.H9(y.this, aVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G9(y this$0, qd.a bannerData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bannerData, "$bannerData");
        sd.a aVar = this$0.bannerManagerIoc;
        if (aVar != null) {
            aVar.b(bannerData, this$0.getActivity());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(y this$0, qd.a bannerData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bannerData, "$bannerData");
        sd.a aVar = this$0.bannerManagerIoc;
        if (aVar != null) {
            aVar.b(bannerData, this$0.getActivity());
        }
    }

    @Override // com.qzone.reborn.feedpro.part.b, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        this.bannerManagerIoc = (sd.a) getIocInterface(sd.a.class);
        this.scrollViewModel = (com.qzone.reborn.feedpro.viewmodel.n) getViewModel(com.qzone.reborn.feedpro.viewmodel.n.class);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof TianshuRedDataChangeEvent) {
            F9();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(TianshuRedDataChangeEvent.class);
        return arrayListOf;
    }
}
