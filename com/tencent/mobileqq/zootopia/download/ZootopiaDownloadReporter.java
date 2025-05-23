package com.tencent.mobileqq.zootopia.download;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.zootopia.download.data.ZootopiaDownloadData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/ZootopiaDownloadReporter;", "", "", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaDownloadReporter {

    /* renamed from: a, reason: collision with root package name */
    public static final ZootopiaDownloadReporter f328017a = new ZootopiaDownloadReporter();

    ZootopiaDownloadReporter() {
    }

    public final void a() {
        ZootopiaDownloadManager.f327992a.V(new Function1<List<? extends ZootopiaDownloadData>, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ZootopiaDownloadReporter$reportDownloadList$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zootopia/download/ZootopiaDownloadReporter$reportDownloadList$1$a", "Lrh3/b;", "", "onSuccess", "", "errorCode", "", "msg", "onFailed", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes35.dex */
            public static final class a implements rh3.b {
                a() {
                }

                @Override // rh3.b
                public void onFailed(int errorCode, String msg2) {
                    Intrinsics.checkNotNullParameter(msg2, "msg");
                    QLog.i("ZootopiaDownloadReporter", 1, "reportDownloadList failed errorCode:" + errorCode + " msg:" + msg2);
                }

                @Override // rh3.b
                public void onSuccess() {
                    QLog.i("ZootopiaDownloadReporter", 1, "reportDownloadList success");
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ZootopiaDownloadData> list) {
                invoke2((List<ZootopiaDownloadData>) list);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<ZootopiaDownloadData> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                QLog.i("ZootopiaDownloadReporter", 1, "reportDownloadList");
                av4.e eVar = new av4.e();
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                String currentUin = peekAppRuntime != null ? peekAppRuntime.getCurrentUin() : null;
                if (currentUin == null) {
                    currentUin = "0";
                }
                int i3 = 0;
                eVar.f27017a = (currentUin.length() > 0) != false ? Long.parseLong(currentUin) : 0L;
                int size = it.size();
                av4.a[] aVarArr = new av4.a[size];
                for (int i16 = 0; i16 < size; i16++) {
                    aVarArr[i16] = new av4.a();
                }
                eVar.f27018b = aVarArr;
                for (ZootopiaDownloadData zootopiaDownloadData : it) {
                    int i17 = i3 + 1;
                    eVar.f27018b[i3].f27005c = zootopiaDownloadData.getResData().isSilentDownload() ? 1 : 0;
                    eVar.f27018b[i3].f27003a = zootopiaDownloadData.getSummaryData().getId();
                    eVar.f27018b[i3].f27004b = zootopiaDownloadData.getResData().getDownloadStatus() == 5 ? 2 : 1;
                    eVar.f27018b[i3].f27006d = zootopiaDownloadData.getResData().getVersion();
                    i3 = i17;
                }
                av4.d dVar = new av4.d();
                dVar.f27014a = System.currentTimeMillis();
                dVar.f27015b = 9001;
                dVar.f27016c = MessageNano.toByteArray(eVar);
                ((rh3.a) k74.i.INSTANCE.a(rh3.a.class)).reportMsg(dVar, new a());
            }
        });
    }
}
