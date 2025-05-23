package com.tencent.mobileqq.zootopia.download;

import android.app.Activity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.z1.download.data.ZootopiaDownloadParams;
import com.tencent.mobileqq.z1.download.data.ZootopiaResData;
import com.tencent.mobileqq.zootopia.download.data.ZootopiaDownloadData;
import com.tencent.mobileqq.zootopia.download.w;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J$\u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0014\u0010\f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00060\nJ8\u0010\u0012\u001a\u00020\u00062\u0016\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\b0\u000ej\b\u0012\u0004\u0012\u00020\b`\u000f2\u0018\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0011\u0012\u0004\u0012\u00020\u00060\nJ$\u0010\u0014\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0014\u0010\f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u00060\nJ\"\u0010\u0018\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016JC\u0010 \u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162!\u0010\u001f\u001a\u001d\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00060\n\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/ZootopiaDownloadManagerIpc;", "", "", "e", "f", "needCheck", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "mapId", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/z1/download/data/ZootopiaResData;", "callback", "i", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mapIds", "", "j", "Lcom/tencent/mobileqq/zootopia/download/data/ZootopiaDownloadData;", "g", "Lcom/tencent/mobileqq/zootopia/ipc/ah;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "o", "Lcom/tencent/mobileqq/z1/download/data/ZootopiaDownloadParams;", "downloadParams", "withoutCheck", "Lkotlin/ParameterName;", "name", "sure", "mobileNetCheckCallback", DomainData.DOMAIN_NAME, "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaDownloadManagerIpc {

    /* renamed from: a, reason: collision with root package name */
    public static final ZootopiaDownloadManagerIpc f328013a = new ZootopiaDownloadManagerIpc();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J*\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/zootopia/download/ZootopiaDownloadManagerIpc$a", "Lcom/tencent/mobileqq/zootopia/download/w;", "", "modId", "", "b", "", "code", "errMsg", "d", "Lcom/tencent/mobileqq/zootopia/download/x;", "task", "g", "f", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements w {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.ipc.ah f328014a;

        a(com.tencent.mobileqq.zootopia.ipc.ah ahVar) {
            this.f328014a = ahVar;
        }

        @Override // com.tencent.mobileqq.zootopia.download.w
        public void a(String str, x xVar) {
            w.a.c(this, str, xVar);
        }

        @Override // com.tencent.mobileqq.zootopia.download.w
        public void b(String modId) {
            Intrinsics.checkNotNullParameter(modId, "modId");
            QLog.i("ZootopiaDownloadManagerIpc", 1, ", onTaskStartSuccess - " + modId);
            this.f328014a.onSuccess("");
        }

        @Override // com.tencent.mobileqq.zootopia.download.w
        public void c(String str, float f16, x xVar) {
            w.a.b(this, str, f16, xVar);
        }

        @Override // com.tencent.mobileqq.zootopia.download.w
        public void d(String modId, int code, String errMsg) {
            Intrinsics.checkNotNullParameter(modId, "modId");
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.e("ZootopiaDownloadManagerIpc", 1, ", onTaskStartError - " + modId + ", code= " + code + ", errMsg= " + errMsg);
            this.f328014a.onFailed(code, errMsg);
        }

        @Override // com.tencent.mobileqq.zootopia.download.w
        public void e(String str, x xVar) {
            w.a.a(this, str, xVar);
        }

        @Override // com.tencent.mobileqq.zootopia.download.w
        public void f(String modId, int code, String errMsg, x task) {
            Intrinsics.checkNotNullParameter(modId, "modId");
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.e("ZootopiaDownloadManagerIpc", 1, ", onFailed - " + modId + ", code= " + code + ", errMsg= " + errMsg);
        }

        @Override // com.tencent.mobileqq.zootopia.download.w
        public void g(String modId, x task) {
            Intrinsics.checkNotNullParameter(modId, "modId");
            QLog.i("ZootopiaDownloadManagerIpc", 1, ", onComplete - " + modId);
        }

        @Override // com.tencent.mobileqq.zootopia.download.w
        public void h(String str, x xVar) {
            w.a.d(this, str, xVar);
        }
    }

    ZootopiaDownloadManagerIpc() {
    }

    private final boolean e() {
        return MobileQQ.sProcessId == 1;
    }

    private final boolean f() {
        if (e()) {
            return ZootopiaDownloadManager.f327992a.b0();
        }
        return ((com.tencent.mobileqq.zootopia.ipc.n) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.n.class)).needCheckNet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Function1 callback, ZootopiaDownloadData zootopiaDownloadData) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.invoke(zootopiaDownloadData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Function1 callback, ZootopiaResData zootopiaResData) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.invoke(zootopiaResData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(Function1 callback, ArrayList it) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        callback.invoke(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(boolean needCheck) {
        if (e()) {
            ZootopiaDownloadManager.f327992a.K0(needCheck);
        } else {
            ((com.tencent.mobileqq.zootopia.ipc.n) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.n.class)).setNeedCheckNet(needCheck);
        }
    }

    public final void g(int mapId, final Function1<? super ZootopiaDownloadData, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (e()) {
            ZootopiaDownloadManager.f327992a.Y(String.valueOf(mapId), new Function1<ZootopiaDownloadData, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManagerIpc$queryDownloadData$1
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
                    callback.invoke(zootopiaDownloadData);
                }
            });
        } else {
            ((com.tencent.mobileqq.zootopia.ipc.n) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.n.class)).queryDownloadData(mapId, new com.tencent.mobileqq.zootopia.ipc.m() { // from class: com.tencent.mobileqq.zootopia.download.ad
                @Override // com.tencent.mobileqq.zootopia.ipc.m
                public final void a(ZootopiaDownloadData zootopiaDownloadData) {
                    ZootopiaDownloadManagerIpc.h(Function1.this, zootopiaDownloadData);
                }
            });
        }
    }

    public final void i(int mapId, final Function1<? super ZootopiaResData, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (e()) {
            ZootopiaDownloadManager.f327992a.c0(String.valueOf(mapId), new Function1<ZootopiaResData, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManagerIpc$queryResData$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ZootopiaResData zootopiaResData) {
                    invoke2(zootopiaResData);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ZootopiaResData zootopiaResData) {
                    callback.invoke(zootopiaResData);
                }
            });
        } else {
            ((com.tencent.mobileqq.zootopia.ipc.n) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.n.class)).queryDownloadResInfo(mapId, new com.tencent.mobileqq.zootopia.ipc.p() { // from class: com.tencent.mobileqq.zootopia.download.ae
                @Override // com.tencent.mobileqq.zootopia.ipc.p
                public final void a(ZootopiaResData zootopiaResData) {
                    ZootopiaDownloadManagerIpc.k(Function1.this, zootopiaResData);
                }
            });
        }
    }

    public final void j(final ArrayList<Integer> mapIds, final Function1<? super List<ZootopiaResData>, Unit> callback) {
        Intrinsics.checkNotNullParameter(mapIds, "mapIds");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (e()) {
            ZootopiaDownloadManager.f327992a.W(new Function1<List<? extends ZootopiaResData>, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManagerIpc$queryResData$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends ZootopiaResData> list) {
                    invoke2((List<ZootopiaResData>) list);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<ZootopiaResData> datas) {
                    Intrinsics.checkNotNullParameter(datas, "datas");
                    Function1<List<ZootopiaResData>, Unit> function1 = callback;
                    ArrayList<Integer> arrayList = mapIds;
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : datas) {
                        if (arrayList.contains(Integer.valueOf(((ZootopiaResData) obj).getId()))) {
                            arrayList2.add(obj);
                        }
                    }
                    function1.invoke(arrayList2);
                }
            });
        } else {
            ((com.tencent.mobileqq.zootopia.ipc.n) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.n.class)).queryDownloadResInfo(mapIds, new com.tencent.mobileqq.zootopia.ipc.o() { // from class: com.tencent.mobileqq.zootopia.download.af
                @Override // com.tencent.mobileqq.zootopia.ipc.o
                public final void a(ArrayList arrayList) {
                    ZootopiaDownloadManagerIpc.l(Function1.this, arrayList);
                }
            });
        }
    }

    public final void n(final ZootopiaDownloadParams downloadParams, final boolean withoutCheck, Activity activity, final Function1<? super Boolean, Unit> mobileNetCheckCallback) {
        Intrinsics.checkNotNullParameter(downloadParams, "downloadParams");
        Intrinsics.checkNotNullParameter(mobileNetCheckCallback, "mobileNetCheckCallback");
        if (e()) {
            ZootopiaDownloadManager.f327992a.L0(downloadParams, withoutCheck, null, false);
            return;
        }
        if (com.tencent.mobileqq.zootopia.utils.m.f329564a.c() && f()) {
            if (activity == null) {
                activity = QBaseActivity.sTopActivity;
            }
            if (activity == null || activity.isFinishing()) {
                return;
            }
            DownloadDialogUtils.f327978a.f(activity, "", new Function2<Boolean, Boolean, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManagerIpc$startDownload$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Boolean bool2) {
                    invoke(bool.booleanValue(), bool2.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, boolean z17) {
                    QLog.i("ZootopiaDownloadManagerIpc", 1, "ask4gDownload result: " + z16 + " " + z17);
                    mobileNetCheckCallback.invoke(Boolean.valueOf(z16));
                    if (z16) {
                        ZootopiaDownloadManagerIpc.f328013a.m(!z17);
                        ((com.tencent.mobileqq.zootopia.ipc.n) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.n.class)).startDownload(downloadParams, withoutCheck);
                    }
                }
            });
            return;
        }
        ((com.tencent.mobileqq.zootopia.ipc.n) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.n.class)).startDownload(downloadParams, withoutCheck);
    }

    public final void o(final int mapId, final com.tencent.mobileqq.zootopia.ipc.ah callback, Activity activity) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (e()) {
            ZootopiaDownloadManager.f327992a.N0(String.valueOf(mapId), false, new a(callback), false);
            return;
        }
        if (com.tencent.mobileqq.zootopia.utils.m.f329564a.c() && f()) {
            if (activity == null) {
                activity = QBaseActivity.sTopActivity;
            }
            if (activity == null || activity.isFinishing()) {
                return;
            }
            DownloadDialogUtils.f327978a.f(activity, "", new Function2<Boolean, Boolean, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManagerIpc$startDownloadByMapId$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Boolean bool2) {
                    invoke(bool.booleanValue(), bool2.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, boolean z17) {
                    QLog.i("ZootopiaDownloadManagerIpc", 1, "ask4gDownload result: " + z16 + " " + z17);
                    if (z16) {
                        ZootopiaDownloadManagerIpc.f328013a.m(!z17);
                        ((com.tencent.mobileqq.zootopia.ipc.n) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.n.class)).startMapDownload(String.valueOf(mapId), com.tencent.mobileqq.zootopia.ipc.ah.this);
                    } else {
                        com.tencent.mobileqq.zootopia.ipc.ah.this.onFailed(-87604, "network mobile");
                    }
                }
            });
            return;
        }
        ((com.tencent.mobileqq.zootopia.ipc.n) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.n.class)).startMapDownload(String.valueOf(mapId), callback);
    }
}
