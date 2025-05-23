package com.tencent.qqnt.pluspanel.processor;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.aio.data.AIOSession;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.pluspanel.data.msg.PlusPanelEvent;
import com.tencent.relation.common.api.IRelationNTRecentListApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/pluspanel/processor/BusinessCardOnClickProcessor;", "Lcom/tencent/qqnt/pluspanel/logic/b;", "", "uin", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/aio/api/runtime/a;", "context", "", "c", "Lcom/tencent/qqnt/pluspanel/data/a;", "data", "a", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class BusinessCardOnClickProcessor implements com.tencent.qqnt.pluspanel.logic.b {

    /* renamed from: a, reason: collision with root package name */
    private static final a f360462a = new a(null);

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/pluspanel/processor/BusinessCardOnClickProcessor$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(long uin, AppRuntime app, com.tencent.aio.api.runtime.a context) {
        AIOSession r16 = context.g().r();
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 23);
        bundle.putInt("curent_aio_uin_type", ((IRelationNTRecentListApi) QRoute.api(IRelationNTRecentListApi.class)).getChatTypeForRecentList(r16.c().e()));
        bundle.putString("curent_aio_uinname", r16.c().g());
        bundle.putString("curent_aio_uin", String.valueOf(uin));
        bundle.putString("curent_aio_troop_uin", String.valueOf(uin));
        bundle.putBoolean("only_single_selection", true);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        ForwardBaseOption.startForwardActivityForResult(context.c().requireActivity(), intent, 21);
        l61.a.c(app, "0X80056B3", r16.c().e());
        l61.a.c(app, "0X8007010", r16.c().e());
    }

    @Override // com.tencent.qqnt.pluspanel.logic.b
    public void a(com.tencent.qqnt.pluspanel.data.a data, final com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(context, "context");
        context.e().h(PlusPanelEvent.UpdatePlusPanel.f360444d);
        com.tencent.qqnt.pluspanel.processor.util.a.f360544a.a(context, new Function2<Long, QQAppInterface, Unit>() { // from class: com.tencent.qqnt.pluspanel.processor.BusinessCardOnClickProcessor$onClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Long l3, QQAppInterface qQAppInterface) {
                invoke(l3.longValue(), qQAppInterface);
                return Unit.INSTANCE;
            }

            public final void invoke(long j3, QQAppInterface app) {
                Intrinsics.checkNotNullParameter(app, "app");
                BusinessCardOnClickProcessor.this.c(j3, app, context);
            }
        });
    }
}
