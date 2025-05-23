package com.tencent.qqnt.chats.core.report;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqnt.chats.core.report.DTChatsConst;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
final class DTChatsReportManager$onPgIn$1 extends Lambda implements Function0<Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Object $page;
    final /* synthetic */ Integer $pageStp;
    final /* synthetic */ String $refPageId;
    final /* synthetic */ DTChatsReportManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DTChatsReportManager$onPgIn$1(String str, Integer num, DTChatsReportManager dTChatsReportManager, Object obj) {
        super(0);
        this.$refPageId = str;
        this.$pageStp = num;
        this.this$0 = dTChatsReportManager;
        this.$page = obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, num, dTChatsReportManager, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Object page, DTChatsReportManager this$0) {
        b bVar;
        Intrinsics.checkNotNullParameter(page, "$page");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VideoReport.setPageId(page, DTChatsConst.m.f354839a.a());
        bVar = this$0.pageParamsBuilder;
        VideoReport.setPageParams(page, new PageParams((Map<String, ?>) bVar.a()));
        VideoReport.setPageReportPolicy(page, PageReportPolicy.REPORT_NONE);
        VideoReport.reportPgIn(page);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        com.tencent.qqnt.chats.core.report.data.b bVar;
        com.tencent.qqnt.chats.core.report.data.b bVar2;
        com.tencent.qqnt.chats.core.report.data.b bVar3;
        com.tencent.qqnt.chats.core.report.data.b bVar4;
        b bVar5;
        com.tencent.qqnt.chats.core.report.data.b bVar6;
        com.tencent.qqnt.chats.core.report.data.b bVar7;
        b bVar8;
        b bVar9;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        String str = this.$refPageId;
        if (str != null) {
            bVar9 = this.this$0.pageParamsBuilder;
            bVar9.i(str);
        }
        Integer num = this.$pageStp;
        if (num != null) {
            DTChatsReportManager dTChatsReportManager = this.this$0;
            num.intValue();
            bVar8 = dTChatsReportManager.pageParamsBuilder;
            bVar8.h(num.intValue());
        }
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final Object obj = this.$page;
        final DTChatsReportManager dTChatsReportManager2 = this.this$0;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.qqnt.chats.core.report.d
            @Override // java.lang.Runnable
            public final void run() {
                DTChatsReportManager$onPgIn$1.b(obj, dTChatsReportManager2);
            }
        });
        this.this$0.a0();
        bVar = this.this$0.pageBizExtra;
        int b16 = bVar.b();
        bVar2 = this.this$0.pageBizExtra;
        long a16 = bVar2.a();
        if (b16 > -1 && a16 == 0) {
            bVar7 = this.this$0.pageBizExtra;
            bVar7.f(System.currentTimeMillis());
            this.this$0.z0("qq_imp", b16);
        }
        bVar3 = this.this$0.pageBizExtra;
        int d16 = bVar3.d();
        bVar4 = this.this$0.pageBizExtra;
        long c16 = bVar4.c();
        if (d16 > -1 && c16 == 0) {
            bVar6 = this.this$0.pageBizExtra;
            bVar6.h(System.currentTimeMillis());
            DTChatsReportManager.t0(this.this$0, "qq_imp", d16, 0L, 4, null);
        }
        com.tencent.qqnt.chats.core.utils.a aVar = com.tencent.qqnt.chats.core.utils.a.f355091a;
        bVar5 = this.this$0.pageParamsBuilder;
        aVar.d(bVar5.d());
    }
}
