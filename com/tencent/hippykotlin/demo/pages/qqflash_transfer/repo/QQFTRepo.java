package com.tencent.hippykotlin.demo.pages.qqflash_transfer.repo;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheDiskLru$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qqflash_transfer.model.QQFlashTransferViewModel$fetchCompressedFileFolder$2$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.ntcompose.foundation.scheduler.SchedulerKt;
import com.tencent.qq.ntkernel.flash_transfer.IKernelFlashTransferService;
import java.util.ArrayList;
import java.util.List;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ws3.ab;
import ws3.db;
import ws3.ds;
import ws3.dv;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class QQFTRepo {
    public final void fetchAllClusteringDetailFiles(final ArrayList<ab> arrayList, final String str, final String str2, final int i3, final byte[] bArr, final Function1<? super List<ab>, Unit> function1) {
        final ds dsVar = new ds();
        dsVar.f446291d = str2;
        int i16 = 1;
        int i17 = i3 < 0 ? 1 : i3;
        if (i17 != 1) {
            i16 = 2;
            if (i17 != 2) {
                i16 = 0;
            }
        }
        dsVar.f446290c = i16;
        dsVar.f446289b = str;
        dsVar.f446294g = 200;
        if (bArr != null) {
            dsVar.f446293f = bArr;
        } else {
            dsVar.f446293f = new byte[0];
        }
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = CacheDiskLru$$ExternalSyntheticOutline0.m("fetchAllClusteringDetailFiles clusteringId=", str2, " type=");
        m3.append(dsVar.f446290c);
        m3.append(" filterType=");
        m3.append(dsVar.f446292e);
        m3.append(" paginationInfo=");
        m3.append(dsVar.f446293f.length);
        m3.append(" reqCnt=");
        m3.append((Object) UInt.m615toStringimpl(dsVar.f446294g));
        kLog.d("QQFlashTransferFileListViewModel", m3.toString());
        IKernelFlashTransferService.f344757i.a().d(dsVar, new db() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.repo.QQFTRepo$fetchAllClusteringDetailFiles$1
            @Override // ws3.db
            public final void onGetClusteringDetail(final dv dvVar) {
                final byte[] bArr2 = bArr;
                final ArrayList<ab> arrayList2 = arrayList;
                final ds dsVar2 = dsVar;
                final QQFTRepo qQFTRepo = this;
                final String str3 = str;
                final String str4 = str2;
                final int i18 = i3;
                final Function1<List<ab>, Unit> function12 = function1;
                SchedulerKt.c(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqflash_transfer.repo.QQFTRepo$fetchAllClusteringDetailFiles$1$onGetClusteringDetail$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Unit invoke() {
                        Boolean bool;
                        KLog kLog2 = KLog.INSTANCE;
                        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchAllClusteringDetailFiles onGetClusteringDetail fileSetId=");
                        m16.append(dv.this.f446297b);
                        m16.append(" clusteringId=");
                        m16.append(dv.this.f446298c);
                        m16.append(" paginationInfo=");
                        byte[] bArr3 = bArr2;
                        if (bArr3 != null) {
                            bool = Boolean.valueOf(bArr3.length == 0);
                        } else {
                            bool = null;
                        }
                        m16.append(bool);
                        m16.append(" end=");
                        m16.append(dv.this.f446300e);
                        m16.append(" result=");
                        m16.append(dv.this.f446296a);
                        m16.append(" totalInfo{count=");
                        m16.append((Object) UInt.m615toStringimpl(dv.this.f446302g.f446303a));
                        m16.append(" size=");
                        StringBuilder m17 = QQFlashTransferViewModel$fetchCompressedFileFolder$2$$ExternalSyntheticOutline0.m(dv.this.f446302g.f446304b, m16, "} curSize=");
                        m17.append(arrayList2.size());
                        kLog2.d("QQFlashTransferFileListViewModel", m17.toString());
                        dv dvVar2 = dv.this;
                        if (dvVar2.f446296a == 0 && Intrinsics.areEqual(dsVar2.f446289b, dvVar2.f446297b) && Intrinsics.areEqual(dsVar2.f446291d, dv.this.f446298c)) {
                            arrayList2.addAll(dv.this.f446301f);
                            dv dvVar3 = dv.this;
                            if (!dvVar3.f446300e) {
                                qQFTRepo.fetchAllClusteringDetailFiles(arrayList2, str3, str4, i18, dvVar3.f446299d, function12);
                            } else {
                                Function1<List<ab>, Unit> function13 = function12;
                                if (function13 != null) {
                                    function13.invoke(arrayList2);
                                }
                            }
                        }
                        return Unit.INSTANCE;
                    }
                });
            }
        });
    }
}
