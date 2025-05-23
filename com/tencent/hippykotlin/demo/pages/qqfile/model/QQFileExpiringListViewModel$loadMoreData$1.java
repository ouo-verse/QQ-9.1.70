package com.tencent.hippykotlin.demo.pages.qqfile.model;

import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest;
import com.tencent.hippykotlin.demo.pages.foundation.module.OIDBResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.kuikly.core.coroutines.b;
import com.tencent.kuikly.core.log.KLog;
import java.util.Iterator;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.text.StringsKt__StringsJVMKt;
import m35.a;
import m35.c;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.qqfile.model.QQFileExpiringListViewModel$loadMoreData$1", f = "QQFileExpiringListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes37.dex */
public final class QQFileExpiringListViewModel$loadMoreData$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public final /* synthetic */ QQFileExpiringListViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQFileExpiringListViewModel$loadMoreData$1(QQFileExpiringListViewModel qQFileExpiringListViewModel, Continuation<? super QQFileExpiringListViewModel$loadMoreData$1> continuation) {
        super(2, continuation);
        this.this$0 = qQFileExpiringListViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QQFileExpiringListViewModel$loadMoreData$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((QQFileExpiringListViewModel$loadMoreData$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        final QQFileExpiringListViewModel qQFileExpiringListViewModel = this.this$0;
        final QQFileFetchCallback<c> qQFileFetchCallback = new QQFileFetchCallback<c>() { // from class: com.tencent.hippykotlin.demo.pages.qqfile.model.QQFileExpiringListViewModel$loadMoreData$1.1
            @Override // com.tencent.hippykotlin.demo.pages.qqfile.model.QQFileFetchCallback
            public final void onSucceed(c cVar) {
                Iterator it;
                c cVar2;
                String str;
                int roundToInt;
                String str2;
                int roundToInt2;
                int roundToInt3;
                byte[] bArr;
                byte[] bArr2;
                byte[] bArr3;
                byte[] bArr4;
                byte[] bArr5;
                c cVar3 = cVar;
                QQFileExpiringListViewModel qQFileExpiringListViewModel2 = QQFileExpiringListViewModel.this;
                if (qQFileExpiringListViewModel2.fetchOffset == 0) {
                    qQFileExpiringListViewModel2.fileInfoList.clear();
                    qQFileExpiringListViewModel2.fileDownloadStatusList.clear();
                }
                qQFileExpiringListViewModel2.fetchOffset = cVar3.f416090f;
                qQFileExpiringListViewModel2.isFetchEnd = cVar3.f416092i;
                Iterator it5 = cVar3.f416093m.iterator();
                while (it5.hasNext()) {
                    a aVar = (a) it5.next();
                    long j3 = aVar.f416079d;
                    long j16 = aVar.f416080e;
                    int i3 = aVar.f416081f;
                    String str3 = aVar.f416082h;
                    c45.a aVar2 = aVar.f416083i;
                    String valueOf = String.valueOf((aVar2 == null || (bArr5 = aVar2.f30291a) == null) ? null : StringsKt__StringsJVMKt.decodeToString(bArr5));
                    c45.a aVar3 = aVar.f416084m;
                    String valueOf2 = String.valueOf((aVar3 == null || (bArr4 = aVar3.f30291a) == null) ? null : StringsKt__StringsJVMKt.decodeToString(bArr4));
                    c45.a aVar4 = aVar.C;
                    String valueOf3 = String.valueOf((aVar4 == null || (bArr3 = aVar4.f30291a) == null) ? null : StringsKt__StringsJVMKt.decodeToString(bArr3));
                    c45.a aVar5 = aVar.D;
                    String valueOf4 = String.valueOf((aVar5 == null || (bArr2 = aVar5.f30291a) == null) ? null : StringsKt__StringsJVMKt.decodeToString(bArr2));
                    long j17 = aVar.E;
                    if (j17 < 1024) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(j17);
                        it = it5;
                        sb5.append(" B");
                        cVar2 = cVar3;
                        str2 = sb5.toString();
                        str = valueOf;
                    } else {
                        it = it5;
                        if (j17 < 1048576) {
                            str = valueOf;
                            cVar2 = cVar3;
                            roundToInt3 = MathKt__MathJVMKt.roundToInt((j17 / 1024.0d) * 100);
                            str2 = (roundToInt3 / 100.0d) + " KB";
                        } else {
                            cVar2 = cVar3;
                            str = valueOf;
                            if (j17 < 1073741824) {
                                roundToInt2 = MathKt__MathJVMKt.roundToInt((j17 / 1048576.0d) * 100);
                                str2 = (roundToInt2 / 100.0d) + " MB";
                            } else {
                                roundToInt = MathKt__MathJVMKt.roundToInt((j17 / 1.073741824E9d) * 100);
                                str2 = (roundToInt / 100.0d) + " GB";
                            }
                        }
                    }
                    int i16 = aVar.F;
                    int i17 = aVar.G;
                    c45.a aVar6 = aVar.H;
                    qQFileExpiringListViewModel2.fileInfoList.add(new KTFileInfo(j3, j16, i3, str3, str, valueOf2, valueOf3, valueOf4, j17, str2, i16, i17, String.valueOf((aVar6 == null || (bArr = aVar6.f30291a) == null) ? null : StringsKt__StringsJVMKt.decodeToString(bArr)), aVar.I, aVar.J, aVar.K));
                    qQFileExpiringListViewModel2.fileDownloadStatusList.add(new KTFileDownloadStatus(0.0f, 1));
                    it5 = it;
                    cVar3 = cVar2;
                }
                c cVar4 = cVar3;
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetch files, fetchOffset:");
                m3.append(cVar4.f416090f);
                m3.append(", filecount:");
                m3.append(cVar4.f416091h);
                m3.append(" ,hasFetched: ");
                m3.append(qQFileExpiringListViewModel2.fileInfoList.size());
                m3.append(", isFetchEnd:");
                m3.append(cVar4.f416092i);
                kLog.e("QQFileExpiringListViewModel", m3.toString());
                QQFileExpiringListViewModel qQFileExpiringListViewModel3 = QQFileExpiringListViewModel.this;
                qQFileExpiringListViewModel3.isFilelistEmpty.setValue(Boolean.valueOf(qQFileExpiringListViewModel3.fileInfoList.size() == 0));
                QQFileExpiringListViewModel.this.hasFetchMore = false;
            }
        };
        int i3 = QQFileExpiringListViewModel.$r8$clinit;
        qQFileExpiringListViewModel.getClass();
        KLog.INSTANCE.i("QQFileExpiringListViewModel", "fetchExpiringFiles request ");
        QQKuiklyPlatformApi.Companion.sendOIDBRequest(new BaseOIDBRequest<m35.b, c>() { // from class: com.tencent.hippykotlin.demo.pages.qqfile.model.QQFileExpiringListViewModel$fetchExpiringFiles$req$1
            @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
            public final c decodeResponse(byte[] bArr) {
                return (c) i.b(new c(0, null, 0, 0, false, null, 63, null), bArr);
            }

            @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
            public final int getOidbCmd() {
                return 37727;
            }

            @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
            public final int getOidbServiceType() {
                return 1;
            }

            @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BaseOIDBRequest
            public final m35.b getRequest() {
                return new m35.b(Long.parseLong(QQKuiklyPlatformApi.Companion.getUin()), QQFileExpiringListViewModel.this.fetchOffset, 13);
            }
        }, false, new Function1<OIDBResponse<c>, Unit>(qQFileExpiringListViewModel, qQFileFetchCallback) { // from class: com.tencent.hippykotlin.demo.pages.qqfile.model.QQFileExpiringListViewModel$fetchExpiringFiles$1
            public final /* synthetic */ QQFileFetchCallback<c> $callback;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$callback = qQFileFetchCallback;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(OIDBResponse<c> oIDBResponse) {
                Unit unit;
                OIDBResponse<c> oIDBResponse2 = oIDBResponse;
                if (oIDBResponse2.success) {
                    KLog kLog = KLog.INSTANCE;
                    kLog.i("QQFileExpiringListViewModel", "pb request success");
                    c cVar = oIDBResponse2.rsp;
                    if (cVar != null) {
                        this.$callback.onSucceed(cVar);
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        kLog.e("QQFileExpiringListViewModel", "pb request success, but result is null");
                    }
                } else {
                    KLog kLog2 = KLog.INSTANCE;
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("pb request failed, error code: ");
                    m3.append(oIDBResponse2.code);
                    m3.append(", msg: ");
                    m3.append(oIDBResponse2.f114186msg);
                    kLog2.e("QQFileExpiringListViewModel", m3.toString());
                }
                return Unit.INSTANCE;
            }
        });
        return Unit.INSTANCE;
    }
}
