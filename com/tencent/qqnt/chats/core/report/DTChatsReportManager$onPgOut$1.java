package com.tencent.qqnt.chats.core.report;

import android.os.Handler;
import android.util.ArrayMap;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
final class DTChatsReportManager$onPgOut$1 extends Lambda implements Function0<Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ Object $page;
    final /* synthetic */ DTChatsReportManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DTChatsReportManager$onPgOut$1(DTChatsReportManager dTChatsReportManager, Object obj) {
        super(0);
        this.this$0 = dTChatsReportManager;
        this.$page = obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) dTChatsReportManager, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Object page) {
        Intrinsics.checkNotNullParameter(page, "$page");
        VideoReport.reportPgOut(page);
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
        Map map;
        b bVar3;
        Map map2;
        Map map3;
        ArrayMap arrayMap;
        com.tencent.qqnt.chats.core.report.data.b bVar4;
        com.tencent.qqnt.chats.core.report.data.b bVar5;
        com.tencent.qqnt.chats.core.report.data.b bVar6;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        DTChatsReportManager dTChatsReportManager = this.this$0;
        bVar = dTChatsReportManager.pageBizExtra;
        dTChatsReportManager.h(bVar.d());
        bVar2 = this.this$0.pageBizExtra;
        if (bVar2.b() > -1) {
            DTChatsReportManager dTChatsReportManager2 = this.this$0;
            bVar4 = dTChatsReportManager2.pageBizExtra;
            dTChatsReportManager2.z0("qq_imp_end", bVar4.b());
            bVar5 = this.this$0.pageBizExtra;
            bVar5.f(0L);
            bVar6 = this.this$0.pageBizExtra;
            bVar6.g(-1);
        }
        Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
        final Object obj = this.$page;
        uIHandlerV2.post(new Runnable() { // from class: com.tencent.qqnt.chats.core.report.e
            @Override // java.lang.Runnable
            public final void run() {
                DTChatsReportManager$onPgOut$1.c(obj);
            }
        });
        map = this.this$0.itemExpoMap;
        DTChatsReportManager dTChatsReportManager3 = this.this$0;
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            DTChatsReportManager.n0(dTChatsReportManager3, "qq_imp_end", (com.tencent.qqnt.chats.core.adapter.itemdata.b) ((Map.Entry) it.next()).getValue(), false, 4, null);
        }
        com.tencent.qqnt.chats.core.utils.a aVar = com.tencent.qqnt.chats.core.utils.a.f355091a;
        bVar3 = this.this$0.pageParamsBuilder;
        aVar.e(bVar3.d());
        map2 = this.this$0.itemExpoMap;
        map2.clear();
        map3 = this.this$0.itemExpoTimeMap;
        map3.clear();
        arrayMap = this.this$0.itemBizMap;
        arrayMap.clear();
    }
}
