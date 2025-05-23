package com.tencent.mobileqq.zootopia.download.proxy;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.z1.download.ZPlanResDownloadReq;
import com.tencent.mobileqq.z1.download.ZPlanResDownloadUrlRsp;
import com.tencent.mobileqq.zootopia.download.file.ZPlanFileDownloadUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nx4.a;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zootopia/download/proxy/ZPlanResProxyDownloader$downloadResByPath$2", "Lqb3/a;", "Lcom/tencent/mobileqq/z1/download/ZPlanResDownloadUrlRsp;", "urlInfoRsp", "", "b", "", "errorCode", "", "errorMessage", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanResProxyDownloader$downloadResByPath$2 implements qb3.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f328193a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ZPlanResDownloadReq f328194b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ qb3.b f328195c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZPlanResProxyDownloader$downloadResByPath$2(boolean z16, ZPlanResDownloadReq zPlanResDownloadReq, qb3.b bVar) {
        this.f328193a = z16;
        this.f328194b = zPlanResDownloadReq;
        this.f328195c = bVar;
    }

    @Override // qb3.a
    public void a(final int errorCode, final String errorMessage) {
        ZPlanResProxyDownloader zPlanResProxyDownloader = ZPlanResProxyDownloader.f328186a;
        zPlanResProxyDownloader.n("downloadResByPath - " + this.f328194b + ", onGetDownloadUrlError - " + errorCode + " - " + errorMessage);
        final qb3.b bVar = this.f328195c;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zootopia.download.proxy.c
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanResProxyDownloader$downloadResByPath$2.d(qb3.b.this, errorCode, errorMessage);
            }
        }, 16, null, false);
        zPlanResProxyDownloader.p(this.f328194b, new Function1<qb3.b, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.proxy.ZPlanResProxyDownloader$downloadResByPath$2$onGetDownloadUrlError$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(qb3.b bVar2) {
                invoke2(bVar2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(qb3.b it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.a(errorCode, errorMessage);
            }
        });
    }

    @Override // qb3.a
    public void b(final ZPlanResDownloadUrlRsp urlInfoRsp) {
        final String m3;
        Intrinsics.checkNotNullParameter(urlInfoRsp, "urlInfoRsp");
        if (!this.f328193a) {
            ZPlanResProxyDownloader.f328186a.o("downloadResByPath - ZPlanResDownloadReq@" + this.f328194b.hashCode() + ", onGetDownloadUrl - " + urlInfoRsp);
        }
        m3 = ZPlanResProxyDownloader.f328186a.m(this.f328194b, urlInfoRsp.getFullUrl());
        ZPlanFileDownloadUtil zPlanFileDownloadUtil = ZPlanFileDownloadUtil.f328039a;
        String fullUrl = urlInfoRsp.getFullUrl();
        String proxyDownloadType = this.f328194b.getProxyDownloadType();
        final qb3.b bVar = this.f328195c;
        final ZPlanResDownloadReq zPlanResDownloadReq = this.f328194b;
        zPlanFileDownloadUtil.i(fullUrl, (r13 & 2) != 0 ? "" : m3, (r13 & 4) == 0 ? proxyDownloadType : "", (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? Boolean.FALSE : null, (r13 & 32) == 0 ? new nx4.a() { // from class: com.tencent.mobileqq.zootopia.download.proxy.ZPlanResProxyDownloader$downloadResByPath$2$onGetDownloadUrl$1
            @Override // nx4.a
            public void a(final int statusCode, final String filePath, final a.b result) {
                if (TextUtils.isEmpty(filePath)) {
                    filePath = m3;
                }
                qb3.b bVar2 = qb3.b.this;
                if (bVar2 != null) {
                    bVar2.b(statusCode, filePath, result, urlInfoRsp);
                }
                ZPlanResProxyDownloader zPlanResProxyDownloader = ZPlanResProxyDownloader.f328186a;
                ZPlanResDownloadReq zPlanResDownloadReq2 = zPlanResDownloadReq;
                final ZPlanResDownloadUrlRsp zPlanResDownloadUrlRsp = urlInfoRsp;
                zPlanResProxyDownloader.p(zPlanResDownloadReq2, new Function1<qb3.b, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.proxy.ZPlanResProxyDownloader$downloadResByPath$2$onGetDownloadUrl$1$onDownloadSucceed$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(qb3.b bVar3) {
                        invoke2(bVar3);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(qb3.b it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        it.b(statusCode, filePath, result, zPlanResDownloadUrlRsp);
                    }
                });
            }

            @Override // nx4.a
            public void onDownloadFailed(final int statusCode, final String errorMsg) {
                qb3.b bVar2 = qb3.b.this;
                if (bVar2 != null) {
                    bVar2.onDownloadFailed(statusCode, errorMsg);
                }
                ZPlanResProxyDownloader.f328186a.p(zPlanResDownloadReq, new Function1<qb3.b, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.proxy.ZPlanResProxyDownloader$downloadResByPath$2$onGetDownloadUrl$1$onDownloadFailed$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(qb3.b bVar3) {
                        invoke2(bVar3);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(qb3.b it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        it.onDownloadFailed(statusCode, errorMsg);
                    }
                });
            }

            @Override // nx4.a
            public void onDownloadProgress(final float progress, final long totalBytesWritten, final long totalBytesExpectedToWrite) {
                qb3.b bVar2 = qb3.b.this;
                if (bVar2 != null) {
                    bVar2.onDownloadProgress(progress, totalBytesWritten, totalBytesExpectedToWrite);
                }
                ZPlanResProxyDownloader.f328186a.p(zPlanResDownloadReq, new Function1<qb3.b, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.proxy.ZPlanResProxyDownloader$downloadResByPath$2$onGetDownloadUrl$1$onDownloadProgress$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(qb3.b bVar3) {
                        invoke2(bVar3);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(qb3.b it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        it.onDownloadProgress(progress, totalBytesWritten, totalBytesExpectedToWrite);
                    }
                });
            }
        } : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(qb3.b bVar, int i3, String str) {
        if (bVar != null) {
            bVar.a(i3, str);
        }
    }
}
