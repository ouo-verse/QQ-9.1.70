package com.qzone.reborn.feedpro.part;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.qzone.reborn.feedpro.banner.hotbanner.constant.FeedProHotBannerType;
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
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 !2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u0011\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\u001a\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00180\u0017j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0018`\u0019H\u0016R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/qzone/reborn/feedpro/part/p;", "Lcom/qzone/reborn/feedpro/part/b;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "E9", "", "passiveRedCountNum", "G9", "F9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "onPartResume", "c9", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lnd/a;", "d", "Lnd/a;", "bannerManagerIoc", "<init>", "()V", "e", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class p extends b implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private nd.a bannerManagerIoc;

    private final void E9() {
        int D = dh.d.f393812a.D();
        if (D > 0) {
            G9(D);
        } else {
            F9();
        }
    }

    private final void G9(int passiveRedCountNum) {
        QLog.i("QzoneFeedProPassiveMsgPart", 1, "showPassiveMsgBanner, num is " + passiveRedCountNum);
        final ld.b bVar = new ld.b();
        bVar.e(FeedProHotBannerType.TYPE_PASSIVE_MSG_BANNER);
        bVar.g(2);
        if (passiveRedCountNum < 100) {
            bVar.d(passiveRedCountNum + com.qzone.util.l.a(R.string.rwl));
        } else {
            String a16 = com.qzone.util.l.a(R.string.rwz);
            Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qqstr_qzonefri_e496628d)");
            bVar.d(a16);
        }
        bVar.f(dh.b.c(dh.d.f393812a.s()));
        runOnActivityUiThread(new Runnable() { // from class: com.qzone.reborn.feedpro.part.o
            @Override // java.lang.Runnable
            public final void run() {
                p.H9(p.this, bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(p this$0, ld.b bannerData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bannerData, "$bannerData");
        nd.a aVar = this$0.bannerManagerIoc;
        if (aVar != null) {
            aVar.b(bannerData, this$0.getActivity());
        }
    }

    @Override // com.qzone.reborn.feedpro.part.b, com.qzone.reborn.feedpro.part.a
    public void c9() {
        super.c9();
        E9();
    }

    @Override // com.qzone.reborn.feedpro.part.b, com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        this.bannerManagerIoc = (nd.a) getIocInterface(nd.a.class);
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

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        E9();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof TianshuRedDataChangeEvent) {
            E9();
        }
    }

    private final void F9() {
        QLog.i("QzoneFeedProPassiveMsgPart", 1, "hidePassiveMsgBanner");
        nd.a aVar = this.bannerManagerIoc;
        if (aVar != null) {
            aVar.a(FeedProHotBannerType.TYPE_PASSIVE_MSG_BANNER);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(TianshuRedDataChangeEvent.class);
        return arrayListOf;
    }
}
