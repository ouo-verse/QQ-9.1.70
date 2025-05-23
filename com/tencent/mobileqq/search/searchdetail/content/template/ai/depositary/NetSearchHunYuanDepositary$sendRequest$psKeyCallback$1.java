package com.tencent.mobileqq.search.searchdetail.content.template.ai.depositary;

import android.os.Handler;
import com.tencent.mobileqq.flock.base.FlockBaseRequest;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.search.searchdetail.content.template.ai.depositary.NetSearchHunYuanDepositary;
import com.tencent.qqnt.kernel.nativeinterface.SearchListDetail;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.C11736d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\u0007\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/search/searchdetail/content/template/ai/depositary/NetSearchHunYuanDepositary$sendRequest$psKeyCallback$1", "Lsd2/a;", "", "b", "", "", "domainToKeyMap", "onSuccess", "errMsg", "onFail", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class NetSearchHunYuanDepositary$sendRequest$psKeyCallback$1 implements sd2.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NetSearchHunYuanDepositary f284118a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f284119b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f284120c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f284121d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ boolean f284122e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ NetSearchHunYuanDepositary.b f284123f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NetSearchHunYuanDepositary$sendRequest$psKeyCallback$1(NetSearchHunYuanDepositary netSearchHunYuanDepositary, String str, String str2, String str3, boolean z16, NetSearchHunYuanDepositary.b bVar) {
        this.f284118a = netSearchHunYuanDepositary;
        this.f284119b = str;
        this.f284120c = str2;
        this.f284121d = str3;
        this.f284122e = z16;
        this.f284123f = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        Handler handler;
        Runnable runnable;
        Call call;
        handler = this.f284118a.handler;
        runnable = this.f284118a.timeoutCheckTask;
        handler.removeCallbacks(runnable);
        call = this.f284118a.call;
        if (call != null) {
            call.cancel();
        }
    }

    @Override // sd2.a
    public void onFail(@NotNull String errMsg) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Logger.f235387a.d().d("QQSearch.NetDetail.NetSearchHunYuanDepositary", 1, "[onFail] getPskey error " + errMsg);
        final NetSearchHunYuanDepositary netSearchHunYuanDepositary = this.f284118a;
        final NetSearchHunYuanDepositary.b bVar = this.f284123f;
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.depositary.NetSearchHunYuanDepositary$sendRequest$psKeyCallback$1$onFail$2
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
                boolean z16;
                z16 = NetSearchHunYuanDepositary.this.isCanceled;
                if (z16) {
                    return;
                }
                NetSearchHunYuanDepositary.b.a.a(bVar, "pskeyError", null, null, 6, null);
            }
        });
        b();
        this.f284118a.u(-1L, "getPskey error");
    }

    @Override // sd2.a
    public void onSuccess(@NotNull Map<String, String> domainToKeyMap) {
        boolean z16;
        boolean z17;
        boolean z18;
        Intrinsics.checkNotNullParameter(domainToKeyMap, "domainToKeyMap");
        String str = domainToKeyMap.get(FlockBaseRequest.QUN_DOMAIN);
        if (str == null) {
            str = "";
        }
        String str2 = str;
        Logger logger = Logger.f235387a;
        NetSearchHunYuanDepositary netSearchHunYuanDepositary = this.f284118a;
        Logger.a d16 = logger.d();
        boolean z19 = false;
        if (str2.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        z17 = netSearchHunYuanDepositary.isCanceled;
        d16.d("QQSearch.NetDetail.NetSearchHunYuanDepositary", 1, "[onSuccess] pskey " + z16 + " isCanceled=" + z17);
        z18 = this.f284118a.isCanceled;
        if (z18) {
            return;
        }
        if (str2.length() > 0) {
            z19 = true;
        }
        if (z19) {
            final NetSearchHunYuanDepositary netSearchHunYuanDepositary2 = this.f284118a;
            final NetSearchHunYuanDepositary.b bVar = this.f284123f;
            this.f284118a.y(this.f284119b, this.f284120c, this.f284121d, str2, this.f284122e, new NetSearchHunYuanDepositary.b() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.depositary.NetSearchHunYuanDepositary$sendRequest$psKeyCallback$1$onSuccess$innerCallback$1
                @Override // com.tencent.mobileqq.search.searchdetail.content.template.ai.depositary.NetSearchHunYuanDepositary.b
                public void I1(@NotNull final String errorType, @NotNull final String errorCode, @NotNull final String fallbackTips) {
                    Intrinsics.checkNotNullParameter(errorType, "errorType");
                    Intrinsics.checkNotNullParameter(errorCode, "errorCode");
                    Intrinsics.checkNotNullParameter(fallbackTips, "fallbackTips");
                    final NetSearchHunYuanDepositary netSearchHunYuanDepositary3 = NetSearchHunYuanDepositary.this;
                    final NetSearchHunYuanDepositary.b bVar2 = bVar;
                    C11736d.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.depositary.NetSearchHunYuanDepositary$sendRequest$psKeyCallback$1$onSuccess$innerCallback$1$onFailed$1
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
                            boolean z26;
                            z26 = NetSearchHunYuanDepositary.this.isCanceled;
                            if (z26) {
                                return;
                            }
                            bVar2.I1(errorType, errorCode, fallbackTips);
                        }
                    });
                    this.b();
                    NetSearchHunYuanDepositary.this.u(-1L, errorType + ":" + errorCode + ":" + fallbackTips);
                }

                @Override // com.tencent.mobileqq.search.searchdetail.content.template.ai.depositary.NetSearchHunYuanDepositary.b
                public void M0(@NotNull final String content) {
                    Intrinsics.checkNotNullParameter(content, "content");
                    final NetSearchHunYuanDepositary netSearchHunYuanDepositary3 = NetSearchHunYuanDepositary.this;
                    final NetSearchHunYuanDepositary.b bVar2 = bVar;
                    C11736d.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.depositary.NetSearchHunYuanDepositary$sendRequest$psKeyCallback$1$onSuccess$innerCallback$1$onFailedSensitive$1
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
                            boolean z26;
                            z26 = NetSearchHunYuanDepositary.this.isCanceled;
                            if (z26) {
                                return;
                            }
                            bVar2.M0(content);
                        }
                    });
                    this.b();
                    NetSearchHunYuanDepositary.this.u(-1L, "sensitive");
                }

                @Override // com.tencent.mobileqq.search.searchdetail.content.template.ai.depositary.NetSearchHunYuanDepositary.b
                public void S(@NotNull final List<SearchListDetail> searchItems) {
                    Intrinsics.checkNotNullParameter(searchItems, "searchItems");
                    final NetSearchHunYuanDepositary netSearchHunYuanDepositary3 = NetSearchHunYuanDepositary.this;
                    final NetSearchHunYuanDepositary.b bVar2 = bVar;
                    C11736d.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.depositary.NetSearchHunYuanDepositary$sendRequest$psKeyCallback$1$onSuccess$innerCallback$1$onReceiveRef$1
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
                            boolean z26;
                            z26 = NetSearchHunYuanDepositary.this.isCanceled;
                            if (z26) {
                                return;
                            }
                            bVar2.S(searchItems);
                        }
                    });
                }

                @Override // com.tencent.mobileqq.search.searchdetail.content.template.ai.depositary.NetSearchHunYuanDepositary.b
                public void V0(@NotNull final NetSearchHunYuanDepositary.ModelInfo modelInfo) {
                    Intrinsics.checkNotNullParameter(modelInfo, "modelInfo");
                    final NetSearchHunYuanDepositary netSearchHunYuanDepositary3 = NetSearchHunYuanDepositary.this;
                    final NetSearchHunYuanDepositary.b bVar2 = bVar;
                    C11736d.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.depositary.NetSearchHunYuanDepositary$sendRequest$psKeyCallback$1$onSuccess$innerCallback$1$onReceiveModeName$1
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
                            boolean z26;
                            z26 = NetSearchHunYuanDepositary.this.isCanceled;
                            if (z26) {
                                return;
                            }
                            bVar2.V0(modelInfo);
                        }
                    });
                }

                @Override // com.tencent.mobileqq.search.searchdetail.content.template.ai.depositary.NetSearchHunYuanDepositary.b
                public void onComplete() {
                    final NetSearchHunYuanDepositary netSearchHunYuanDepositary3 = NetSearchHunYuanDepositary.this;
                    final NetSearchHunYuanDepositary.b bVar2 = bVar;
                    C11736d.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.depositary.NetSearchHunYuanDepositary$sendRequest$psKeyCallback$1$onSuccess$innerCallback$1$onComplete$1
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
                            boolean z26;
                            z26 = NetSearchHunYuanDepositary.this.isCanceled;
                            if (z26) {
                                return;
                            }
                            bVar2.onComplete();
                        }
                    });
                    this.b();
                    NetSearchHunYuanDepositary.this.u(0L, "");
                }

                /* JADX WARN: Code restructure failed: missing block: B:11:0x0054, code lost:
                
                    r4 = r1.firstContentReportTask;
                 */
                @Override // com.tencent.mobileqq.search.searchdetail.content.template.ai.depositary.NetSearchHunYuanDepositary.b
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void s0(@NotNull final String contentUUID, @NotNull final String str3) {
                    boolean z26;
                    Handler handler;
                    Runnable runnable;
                    Handler handler2;
                    Runnable runnable2;
                    IPerformanceReportTask iPerformanceReportTask;
                    IPerformanceReportTask iPerformanceReportTask2;
                    Intrinsics.checkNotNullParameter(contentUUID, "contentUUID");
                    Intrinsics.checkNotNullParameter(str3, "str");
                    final NetSearchHunYuanDepositary netSearchHunYuanDepositary3 = NetSearchHunYuanDepositary.this;
                    final NetSearchHunYuanDepositary.b bVar2 = bVar;
                    C11736d.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.depositary.NetSearchHunYuanDepositary$sendRequest$psKeyCallback$1$onSuccess$innerCallback$1$onReceiveContent$1
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
                            boolean z27;
                            z27 = NetSearchHunYuanDepositary.this.isCanceled;
                            if (z27) {
                                return;
                            }
                            bVar2.s0(contentUUID, str3);
                        }
                    });
                    z26 = NetSearchHunYuanDepositary.this.isCanceled;
                    if (!z26) {
                        handler = NetSearchHunYuanDepositary.this.handler;
                        runnable = NetSearchHunYuanDepositary.this.timeoutCheckTask;
                        handler.removeCallbacks(runnable);
                        handler2 = NetSearchHunYuanDepositary.this.handler;
                        runnable2 = NetSearchHunYuanDepositary.this.timeoutCheckTask;
                        handler2.postDelayed(runnable2, 120000L);
                        iPerformanceReportTask = NetSearchHunYuanDepositary.this.firstContentReportTask;
                        boolean z27 = false;
                        if (iPerformanceReportTask != null && !iPerformanceReportTask.getIsReported()) {
                            z27 = true;
                        }
                        if (z27 && iPerformanceReportTask2 != null) {
                            iPerformanceReportTask2.report();
                        }
                    }
                }

                @Override // com.tencent.mobileqq.search.searchdetail.content.template.ai.depositary.NetSearchHunYuanDepositary.b
                public void z() {
                    final NetSearchHunYuanDepositary netSearchHunYuanDepositary3 = NetSearchHunYuanDepositary.this;
                    final NetSearchHunYuanDepositary.b bVar2 = bVar;
                    C11736d.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.depositary.NetSearchHunYuanDepositary$sendRequest$psKeyCallback$1$onSuccess$innerCallback$1$onReceiveFirstContent$1
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
                            boolean z26;
                            z26 = NetSearchHunYuanDepositary.this.isCanceled;
                            if (z26) {
                                return;
                            }
                            bVar2.z();
                        }
                    });
                }
            });
            return;
        }
        Logger.b bVar2 = new Logger.b();
        bVar2.a().add("[onSuccess] getPskey error pSKey is empty!");
        Iterator<T> it = bVar2.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("QQSearch.NetDetail.NetSearchHunYuanDepositary", 1, (String) it.next(), null);
        }
        final NetSearchHunYuanDepositary netSearchHunYuanDepositary3 = this.f284118a;
        final NetSearchHunYuanDepositary.b bVar3 = this.f284123f;
        C11736d.c(new Function0<Unit>() { // from class: com.tencent.mobileqq.search.searchdetail.content.template.ai.depositary.NetSearchHunYuanDepositary$sendRequest$psKeyCallback$1$onSuccess$3
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
                boolean z26;
                z26 = NetSearchHunYuanDepositary.this.isCanceled;
                if (z26) {
                    return;
                }
                NetSearchHunYuanDepositary.b.a.a(bVar3, "pskeyError", null, null, 6, null);
            }
        });
        b();
        this.f284118a.u(-1L, "pskey is empty");
    }
}
