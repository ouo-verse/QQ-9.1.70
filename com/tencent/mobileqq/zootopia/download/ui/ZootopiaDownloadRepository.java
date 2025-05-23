package com.tencent.mobileqq.zootopia.download.ui;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.vaswebviewplugin.LocalDataJsPlugin;
import com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManager;
import com.tencent.mobileqq.zootopia.download.data.ZootopiaDownloadData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import pv4.y;
import qv4.v;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0007\u001a\u00020\u00052\u0018\u0010\u0006\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00050\u0002J(\u0010\n\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u0002R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/ui/ZootopiaDownloadRepository;", "Lcom/tencent/mobileqq/mvvm/a;", "Lkotlin/Function1;", "", "Lcom/tencent/mobileqq/zootopia/download/ui/d;", "", "callback", "j", LocalDataJsPlugin.NAME_SPACE, "Lqv4/v;", "k", "Lyb4/m;", "a", "Lyb4/m;", "service", "<init>", "()V", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaDownloadRepository extends com.tencent.mobileqq.mvvm.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final yb4.m service = new yb4.m();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zootopia/download/ui/ZootopiaDownloadRepository$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lqv4/v;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.api.e<v> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<v, Unit> f328216d;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super v, Unit> function1) {
            this.f328216d = function1;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(v result) {
            Intrinsics.checkNotNullParameter(result, "result");
            y[] yVarArr = result.f430204a;
            if (yVarArr == null) {
                QLog.e("ZootopiaDownloadRepository", 1, "GetMapVerStatus error rsp is null");
                return;
            }
            QLog.i("ZootopiaDownloadRepository", 1, "verStatus size is " + yVarArr.length);
            this.f328216d.invoke(result);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("ZootopiaDownloadRepository", 1, "GetMapVerStatus error " + error + " " + message);
        }
    }

    public final void j(final Function1<? super List<d>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ZootopiaDownloadManager.f327992a.V(new Function1<List<? extends ZootopiaDownloadData>, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ui.ZootopiaDownloadRepository$queryDownloadData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ZootopiaDownloadData> list) {
                invoke2((List<ZootopiaDownloadData>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<ZootopiaDownloadData> localDatas) {
                int collectionSizeOrDefault;
                Intrinsics.checkNotNullParameter(localDatas, "localDatas");
                Function1<List<d>, Unit> function1 = callback;
                List<ZootopiaDownloadData> list = localDatas;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(new d((ZootopiaDownloadData) it.next()));
                }
                function1.invoke(arrayList);
            }
        });
    }

    public final void k(List<d> localData, Function1<? super v, Unit> callback) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(localData, "localData");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i("ZootopiaDownloadRepository", 1, "start queryUpdateInfo size " + localData.size());
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        AppInterface appInterface = waitAppRuntime instanceof AppInterface ? (AppInterface) waitAppRuntime : null;
        if (appInterface == null) {
            QLog.e("ZootopiaDownloadRepository", 1, "queryUpdateInfo but appRunTime is null");
            return;
        }
        yb4.m mVar = this.service;
        List<d> list = localData;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(com.tencent.mobileqq.zootopia.download.c.f328029a.m(((d) it.next()).getData()));
        }
        yb4.m.d(mVar, appInterface, arrayList, 0, new b(callback), 4, null);
    }
}
