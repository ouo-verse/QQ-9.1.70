package com.tencent.mobileqq.zootopia.download.ui;

import android.os.Looper;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManager;
import com.tencent.mobileqq.zootopia.download.data.ZootopiaDownloadData;
import com.tencent.mobileqq.zootopia.download.ui.downloading.DownloadingPayloadData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.sqshow.zootopia.mapstatus.ZootopiaMapStatusManager;
import com.tencent.sqshow.zootopia.mapstatus.b;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import qv4.v;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 ?2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001@B\u0007\u00a2\u0006\u0004\b=\u0010>J\u0016\u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002JC\u0010\u0011\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0016\u0010\u0016\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0016\u0010\u0019\u001a\u00020\u00072\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0017H\u0002J\u0006\u0010\u001a\u001a\u00020\u0007J\u000e\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0005J\u000e\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0005J\u000e\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0005J\u000e\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0005J\u0010\u0010 \u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001f\u001a\u00020\tJ\b\u0010!\u001a\u00020\u0007H\u0014J\u0010\u0010$\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\"H\u0016R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00050%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R#\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040)8\u0006\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R#\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040)8\u0006\u00a2\u0006\f\n\u0004\b/\u0010+\u001a\u0004\b0\u0010-R\u001d\u00104\u001a\b\u0012\u0004\u0012\u00020\u00050)8\u0006\u00a2\u0006\f\n\u0004\b2\u0010+\u001a\u0004\b3\u0010-R\u001d\u00108\u001a\b\u0012\u0004\u0012\u0002050)8\u0006\u00a2\u0006\f\n\u0004\b6\u0010+\u001a\u0004\b7\u0010-R\u001d\u0010<\u001a\b\u0012\u0004\u0012\u0002090)8\u0006\u00a2\u0006\f\n\u0004\b:\u0010+\u001a\u0004\b;\u0010-\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/ui/ZootopiaDownloadViewModel;", "Lcom/tencent/mobileqq/mvvm/c;", "Lcom/tencent/mobileqq/zootopia/download/ui/ZootopiaDownloadRepository;", "Lcom/tencent/sqshow/zootopia/mapstatus/a;", "", "Lcom/tencent/mobileqq/zootopia/download/ui/d;", "list", "", "X1", "", "mapId", "", VirtualAppProxy.KEY_DOWNLOAD_STATUS, "", "progress", "realTimeSpeed", "averageSpeed", ICustomDataEditor.STRING_ARRAY_PARAM_2, "(Ljava/lang/String;ILjava/lang/Float;Ljava/lang/Integer;Ljava/lang/Integer;)V", "Lcom/tencent/mobileqq/zootopia/download/data/ZootopiaDownloadData;", "data", "Q1", "c2", "Lkotlin/Function0;", "runnable", "d2", "queryDownloadData", "b2", "f2", "R1", "S1", "id", "U1", "onCleared", "Lcom/tencent/sqshow/zootopia/mapstatus/b;", "result", "r1", "Ljava/util/concurrent/CopyOnWriteArrayList;", "i", "Ljava/util/concurrent/CopyOnWriteArrayList;", "downloadDatas", "Landroidx/lifecycle/MutableLiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "getDownloadingDatas", "()Landroidx/lifecycle/MutableLiveData;", "downloadingDatas", BdhLogUtil.LogTag.Tag_Conn, "getDownloadedDatas", "downloadedDatas", "D", "T1", "curAddDownloadData", "Lcom/tencent/mobileqq/zootopia/download/ui/downloading/a;", "E", "getCurChangePayloadData", "curChangePayloadData", "Lqv4/v;", UserInfo.SEX_FEMALE, "W1", "versionData", "<init>", "()V", "G", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaDownloadViewModel extends com.tencent.mobileqq.mvvm.c<ZootopiaDownloadRepository> implements com.tencent.sqshow.zootopia.mapstatus.a {

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<List<d>> downloadedDatas;

    /* renamed from: D, reason: from kotlin metadata */
    private final MutableLiveData<d> curAddDownloadData;

    /* renamed from: E, reason: from kotlin metadata */
    private final MutableLiveData<DownloadingPayloadData> curChangePayloadData;

    /* renamed from: F, reason: from kotlin metadata */
    private final MutableLiveData<v> versionData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final CopyOnWriteArrayList<d> downloadDatas;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<List<d>> downloadingDatas;

    public ZootopiaDownloadViewModel() {
        super(new ZootopiaDownloadRepository());
        this.downloadDatas = new CopyOnWriteArrayList<>();
        this.downloadingDatas = new MutableLiveData<>();
        this.downloadedDatas = new MutableLiveData<>();
        this.curAddDownloadData = new MutableLiveData<>();
        this.curChangePayloadData = new MutableLiveData<>();
        this.versionData = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void Q1(ZootopiaDownloadData data) {
        Iterator<d> it = this.downloadDatas.iterator();
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                i3 = -1;
                break;
            } else if (Intrinsics.areEqual(it.next().getData().getSummaryData().getId(), data.getSummaryData().getId())) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 >= 0) {
            QLog.e("Zootopia_DownloadViewModel", 1, "addData but data exits");
            return;
        }
        d dVar = new d(data);
        this.downloadDatas.add(dVar);
        this.curAddDownloadData.postValue(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void X1(List<d> list) {
        this.downloadDatas.clear();
        this.downloadDatas.addAll(list);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (d dVar : list) {
            com.tencent.sqshow.zootopia.mapstatus.b d16 = ZootopiaMapStatusManager.f370743d.d(dVar.getData().getSummaryData().getId());
            if (d16 != null) {
                dVar.o(d16.c().getMapStatus());
            }
            if (dVar.getCom.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy.KEY_DOWNLOAD_STATUS java.lang.String() == 5) {
                arrayList2.add(dVar);
            } else if (!dVar.getData().getExtraData().isSilentDownload()) {
                arrayList.add(dVar);
            }
        }
        this.downloadingDatas.postValue(arrayList);
        CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList2, new Comparator() { // from class: com.tencent.mobileqq.zootopia.download.ui.o
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int Z1;
                Z1 = ZootopiaDownloadViewModel.Z1((d) obj, (d) obj2);
                return Z1;
            }
        });
        this.downloadedDatas.postValue(arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int Z1(d dVar, d dVar2) {
        long completeTime = dVar.getData().getResData().getCompleteTime();
        long completeTime2 = dVar2.getData().getResData().getCompleteTime();
        if (completeTime > completeTime2) {
            return -1;
        }
        return completeTime == completeTime2 ? 0 : 1;
    }

    private final synchronized void a2(final String mapId, int downloadStatus, Float progress, final Integer realTimeSpeed, final Integer averageSpeed) {
        Object obj;
        Object obj2 = null;
        if (downloadStatus == 0) {
            Iterator<T> it = this.downloadDatas.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (Intrinsics.areEqual(((d) next).getData().getSummaryData().getId(), mapId)) {
                    obj2 = next;
                    break;
                }
            }
            d dVar = (d) obj2;
            if (dVar != null) {
                this.downloadDatas.remove(dVar);
            }
            return;
        }
        Iterator<T> it5 = this.downloadDatas.iterator();
        while (true) {
            if (!it5.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it5.next();
                if (Intrinsics.areEqual(((d) obj).getData().getSummaryData().getId(), mapId)) {
                    break;
                }
            }
        }
        d dVar2 = (d) obj;
        if (dVar2 != null) {
            Integer valueOf = dVar2.getCom.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy.KEY_DOWNLOAD_STATUS java.lang.String() == downloadStatus ? null : Integer.valueOf(downloadStatus);
            if (Intrinsics.areEqual(dVar2.getProgress(), progress)) {
                progress = null;
            }
            boolean z16 = false;
            if (valueOf != null) {
                valueOf.intValue();
                if (dVar2.getCom.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy.KEY_DOWNLOAD_STATUS java.lang.String() == 5) {
                    z16 = true;
                }
            }
            if (dVar2.getCom.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy.KEY_DOWNLOAD_STATUS java.lang.String() != 5) {
                final Float f16 = progress;
                final Integer num = valueOf;
                d2(new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ui.ZootopiaDownloadViewModel$onTaskChanged$4$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ZootopiaDownloadViewModel.this.getCurChangePayloadData().setValue(new DownloadingPayloadData(mapId, f16, num, realTimeSpeed, averageSpeed));
                    }
                });
            }
            if (valueOf != null) {
                dVar2.j(valueOf.intValue());
            }
            if (progress != null) {
                dVar2.l(progress.floatValue());
            }
            if (z16) {
                dVar2.l(0.0f);
                this.curAddDownloadData.postValue(dVar2);
            }
            return;
        }
        ZootopiaDownloadManager.f327992a.Y(mapId, new Function1<ZootopiaDownloadData, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ui.ZootopiaDownloadViewModel$onTaskChanged$5
            /* JADX INFO: Access modifiers changed from: package-private */
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
                if (zootopiaDownloadData != null) {
                    ZootopiaDownloadViewModel.this.Q1(zootopiaDownloadData);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c2(List<d> list) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ZootopiaMapStatusManager.f370743d.g(((d) it.next()).getData().getSummaryData().getId(), this);
        }
    }

    private final void d2(final Function0<Unit> runnable) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            runnable.invoke();
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.download.ui.p
                @Override // java.lang.Runnable
                public final void run() {
                    ZootopiaDownloadViewModel.e2(Function0.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e2(Function0 runnable) {
        Intrinsics.checkNotNullParameter(runnable, "$runnable");
        runnable.invoke();
    }

    public final void R1(d data) {
        Intrinsics.checkNotNullParameter(data, "data");
        ZootopiaDownloadManager.f327992a.N(data.getData().getSummaryData().getId());
    }

    public final void S1(d data) {
        Intrinsics.checkNotNullParameter(data, "data");
        ZootopiaDownloadManager.f327992a.N(data.getData().getSummaryData().getId());
    }

    public final MutableLiveData<d> T1() {
        return this.curAddDownloadData;
    }

    public final d U1(String id5) {
        Object obj;
        Intrinsics.checkNotNullParameter(id5, "id");
        Iterator<T> it = this.downloadDatas.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((d) obj).getData().getSummaryData().getId(), id5)) {
                break;
            }
        }
        return (d) obj;
    }

    public final MutableLiveData<v> W1() {
        return this.versionData;
    }

    public final void b2(d data) {
        Intrinsics.checkNotNullParameter(data, "data");
        ZootopiaDownloadManager.y0(ZootopiaDownloadManager.f327992a, data.getData().getSummaryData().getId(), false, 2, null);
    }

    public final void f2(d data) {
        Intrinsics.checkNotNullParameter(data, "data");
        ZootopiaDownloadManager.M0(ZootopiaDownloadManager.f327992a, com.tencent.mobileqq.zootopia.download.c.f328029a.e(data.getData()), false, null, false, 14, null);
    }

    public final MutableLiveData<DownloadingPayloadData> getCurChangePayloadData() {
        return this.curChangePayloadData;
    }

    public final MutableLiveData<List<d>> getDownloadedDatas() {
        return this.downloadedDatas;
    }

    public final MutableLiveData<List<d>> getDownloadingDatas() {
        return this.downloadingDatas;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.mvvm.c, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Iterator<T> it = this.downloadDatas.iterator();
        while (it.hasNext()) {
            ZootopiaMapStatusManager.f370743d.h(((d) it.next()).getData().getSummaryData().getId(), this);
        }
    }

    public final void queryDownloadData() {
        getRepository().j(new Function1<List<? extends d>, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ui.ZootopiaDownloadViewModel$queryDownloadData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends d> list) {
                invoke2((List<d>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<d> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (!it.isEmpty()) {
                    ZootopiaDownloadViewModel.this.c2(it);
                    ZootopiaDownloadViewModel.this.X1(it);
                    ZootopiaDownloadRepository repository = ZootopiaDownloadViewModel.this.getRepository();
                    final ZootopiaDownloadViewModel zootopiaDownloadViewModel = ZootopiaDownloadViewModel.this;
                    repository.k(it, new Function1<v, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ui.ZootopiaDownloadViewModel$queryDownloadData$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(v vVar) {
                            invoke2(vVar);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(v rsp) {
                            Intrinsics.checkNotNullParameter(rsp, "rsp");
                            ZootopiaDownloadViewModel.this.W1().postValue(rsp);
                        }
                    });
                }
            }
        });
    }

    @Override // com.tencent.sqshow.zootopia.mapstatus.a
    public void r1(com.tencent.sqshow.zootopia.mapstatus.b result) {
        Intrinsics.checkNotNullParameter(result, "result");
        b.MapStatusResult c16 = result.c();
        b.MapDownloadStatusResult a16 = result.a();
        a2(result.getMapId(), a16.getDownloadStatus(), Float.valueOf(c16.getProgress()), Integer.valueOf(a16.getRealTimeSpeed()), Integer.valueOf(a16.getAverageSpeed()));
    }
}
