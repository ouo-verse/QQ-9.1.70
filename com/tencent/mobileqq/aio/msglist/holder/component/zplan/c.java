package com.tencent.mobileqq.aio.msglist.holder.component.zplan;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.helper.LateInitHelper.CreateHelperIntent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.msglist.holder.d;
import com.tencent.qqnt.aio.adapter.api.IAIOZPlanShowMsgApi;
import com.tencent.qqnt.aio.menu.p;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/zplan/c;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/b;", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/qqnt/aio/holder/a;", "intent", "o", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class c extends com.tencent.mobileqq.aio.msglist.holder.component.b {
    private final void A(AIOMsgItem msgItem) {
        ((IAIOZPlanShowMsgApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOZPlanShowMsgApi.class)).onMsgClick(msgItem);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.aio.msglist.holder.component.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: o */
    public void handleIntent(@NotNull com.tencent.qqnt.aio.holder.a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof ZPlanItemClickIntent) {
            A(((ZPlanItemClickIntent) intent).getMsgItem());
            return;
        }
        if (intent instanceof d.ao) {
            d.ao aoVar = (d.ao) intent;
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new CreateHelperIntent.CreateHelperRealIntent(2, new AIOMsgListEvent.SelectEvent(aoVar.a(), aoVar.b(), aoVar.c()), null, 4, null));
        } else {
            if (intent instanceof d.g) {
                ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new AIOMsgListEvent.DismissSelectMenu(((d.g) intent).a()));
                return;
            }
            if (intent instanceof d.ag) {
                ((com.tencent.aio.api.runtime.a) getMContext()).e().h(AIOMsgListEvent.ReappearSelectMenu.f188367d);
            } else if (intent instanceof p.o) {
                ((com.tencent.aio.api.runtime.a) getMContext()).e().h(AIOMsgListEvent.SelectAll.f188375d);
            } else {
                super.handleIntent(intent);
            }
        }
    }
}
