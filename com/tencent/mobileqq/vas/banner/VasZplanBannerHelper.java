package com.tencent.mobileqq.vas.banner;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.z1.download.data.ZootopiaResData;
import com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManager;
import com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManagerInitEvent;
import com.tencent.mobileqq.zootopia.download.ah;
import com.tencent.mobileqq.zootopia.download.data.ZootopiaDownloadData;
import com.tencent.mobileqq.zootopia.download.x;
import com.tencent.mobileqq.zplan.smallhome.event.ZPlanCloseLoadingViewEvent;
import com.tencent.mobileqq.zplan.smallhome.event.ZplanHideLoadingEvent;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import pb3.a;
import q03.i;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0006*\u0002\u001b\u001e\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0019\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\u00032\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00030\nJ\u0006\u0010\u000e\u001a\u00020\u0003J\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0006J\u0006\u0010\u0011\u001a\u00020\u0003J\u0006\u0010\u0012\u001a\u00020\u000bJ\u0012\u0010\u0014\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J$\u0010\u0018\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00160\u0015j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0016`\u0017H\u0016R\u0016\u0010\u001a\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001cR\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/vas/banner/VasZplanBannerHelper;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "i", "c", "", "mapId", h.F, "(Ljava/lang/Integer;)V", "Lkotlin/Function1;", "", "callback", "f", "e", "exposureTime", "b", "g", "d", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "I", "delayTime", "com/tencent/mobileqq/vas/banner/VasZplanBannerHelper$b", "Lcom/tencent/mobileqq/vas/banner/VasZplanBannerHelper$b;", "managerListener", "com/tencent/mobileqq/vas/banner/VasZplanBannerHelper$a", "Lcom/tencent/mobileqq/vas/banner/VasZplanBannerHelper$a;", "downLoadListener", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class VasZplanBannerHelper implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name */
    public static final VasZplanBannerHelper f308822d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static int delayTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static final b managerListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static final a downLoadListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/vas/banner/VasZplanBannerHelper$a", "Lcom/tencent/mobileqq/zootopia/download/ah;", "Lcom/tencent/mobileqq/zootopia/download/x;", "task", "", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a extends ah {
        a() {
            super("200001");
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void c(x task) {
            Integer intOrNull;
            Intrinsics.checkNotNullParameter(task, "task");
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(task.getId());
            int intValue = intOrNull != null ? intOrNull.intValue() : 0;
            if (intValue == 200001) {
                QLog.i("VasZplanBannerHelper", 1, "download onComplete - " + intValue + ", isSilent = " + task.getIsSilentDownload());
                MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
                Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_VAS)");
                from.encodeLong("smallHomeDownLoadTime", System.currentTimeMillis()).commitAsync();
                from.encodeBool("isSilentDownloadTask", task.getIsSilentDownload());
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/vas/banner/VasZplanBannerHelper$b", "Lpb3/a;", "", "id", "", "onTaskDelete", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements pb3.a {
        b() {
        }

        @Override // pb3.a
        public void onDownloadCountChanged(int i3) {
            a.C10996a.a(this, i3);
        }

        @Override // pb3.a
        public void onDownloadingCountChanged(int i3) {
            a.C10996a.b(this, i3);
        }

        @Override // pb3.a
        public void onTaskDelete(String id5) {
            Integer intOrNull;
            Intrinsics.checkNotNullParameter(id5, "id");
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(id5);
            if (intOrNull == null || intOrNull.intValue() != 200001) {
                return;
            }
            VasZplanBannerHelper.f308822d.c();
        }
    }

    static {
        VasZplanBannerHelper vasZplanBannerHelper = new VasZplanBannerHelper();
        f308822d = vasZplanBannerHelper;
        delayTime = 300000;
        managerListener = new b();
        downLoadListener = new a();
        QLog.i("VasZplanBannerHelper", 1, "init---");
        SimpleEventBus.getInstance().registerReceiver(vasZplanBannerHelper);
        int a16 = i.f428160a.g().a();
        if (a16 > 0) {
            delayTime = a16 * 60 * 1000;
        }
    }

    VasZplanBannerHelper() {
    }

    public final boolean b(int exposureTime) {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_VAS)");
        AppRuntime d16 = bb.f335811a.d();
        String currentAccountUin = d16 != null ? d16.getCurrentAccountUin() : null;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("bannerExposureTime_");
        sb5.append(currentAccountUin);
        return System.currentTimeMillis() - from.decodeLong(sb5.toString(), 0L) <= ((long) (((exposureTime * 60) * 60) * 1000));
    }

    public final boolean d() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_VAS)");
        return from.decodeBool("isSilentDownloadTask", false);
    }

    public final void e() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_VAS)");
        AppRuntime d16 = bb.f335811a.d();
        from.encodeBool("hideSmallHomeBanner_" + (d16 != null ? d16.getCurrentAccountUin() : null), true).commitAsync();
    }

    public final void f(final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_VAS)");
        AppRuntime d16 = bb.f335811a.d();
        String currentAccountUin = d16 != null ? d16.getCurrentAccountUin() : null;
        long decodeLong = from.decodeLong("smallHomeDownLoadTime", 0L);
        if (decodeLong != 0) {
            boolean z16 = false;
            boolean decodeBool = from.decodeBool("enterSmallHomeTime_" + currentAccountUin, false);
            boolean z17 = System.currentTimeMillis() - decodeLong <= ((long) delayTime);
            boolean decodeBool2 = from.decodeBool("hideSmallHomeBanner_" + currentAccountUin, false);
            if (!decodeBool && !z17 && !decodeBool2) {
                z16 = true;
            }
            booleanRef.element = z16;
            QLog.i("VasZplanBannerHelper", 1, "needShowBanner=" + z16 + ", isEnter=" + decodeBool + ", isOverTime=" + z17 + ", isHide=" + decodeBool2);
        }
        if (booleanRef.element) {
            ZootopiaDownloadManager.f327992a.Z("200001", true, new Function1<ZootopiaDownloadData, Unit>() { // from class: com.tencent.mobileqq.vas.banner.VasZplanBannerHelper$needShowBanner$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ZootopiaDownloadData zootopiaDownloadData) {
                    invoke2(zootopiaDownloadData);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ZootopiaDownloadData zootopiaDownloadData) {
                    ZootopiaResData resData;
                    ZootopiaResData resData2;
                    QLog.i("VasZplanBannerHelper", 1, "needShowBanner finalCheck, status= " + ((zootopiaDownloadData == null || (resData2 = zootopiaDownloadData.getResData()) == null) ? null : Integer.valueOf(resData2.getDownloadStatus())));
                    if (!((zootopiaDownloadData == null || (resData = zootopiaDownloadData.getResData()) == null || resData.getDownloadStatus() != 5) ? false : true)) {
                        VasZplanBannerHelper.f308822d.c();
                        callback.invoke(Boolean.FALSE);
                    } else {
                        callback.invoke(Boolean.valueOf(booleanRef.element));
                    }
                }
            });
        } else {
            callback.invoke(Boolean.FALSE);
        }
    }

    public final void g() {
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_VAS)");
        AppRuntime d16 = bb.f335811a.d();
        from.encodeLong("bannerExposureTime_" + (d16 != null ? d16.getCurrentAccountUin() : null), System.currentTimeMillis()).commitAsync();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(ZPlanCloseLoadingViewEvent.class);
        arrayList.add(ZplanHideLoadingEvent.class);
        arrayList.add(ZootopiaDownloadManagerInitEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof ZPlanCloseLoadingViewEvent) {
            h(Integer.valueOf(((ZPlanCloseLoadingViewEvent) event).getMapId()));
        } else if (event instanceof ZplanHideLoadingEvent) {
            h(((ZplanHideLoadingEvent) event).getMapId());
        } else if (event instanceof ZootopiaDownloadManagerInitEvent) {
            i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        QLog.i("VasZplanBannerHelper", 1, "clearSmallHomeDownloadTime");
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_VAS)");
        from.encodeLong("smallHomeDownLoadTime", 0L).commitAsync();
    }

    private final void i() {
        QLog.i("VasZplanBannerHelper", 1, "registerDownloadListeners");
        ZootopiaDownloadManager zootopiaDownloadManager = ZootopiaDownloadManager.f327992a;
        zootopiaDownloadManager.H(managerListener);
        zootopiaDownloadManager.G(downLoadListener);
    }

    private final void h(Integer mapId) {
        if (mapId != null && mapId.intValue() == 200001) {
            AppRuntime d16 = bb.f335811a.d();
            String str = "enterSmallHomeTime_" + (d16 != null ? d16.getCurrentAccountUin() : null);
            MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_VAS)");
            from.encodeBool(str, true).commitAsync();
        }
        QLog.i("VasZplanBannerHelper", 1, "recordEnter mapID " + mapId + " ");
    }
}
