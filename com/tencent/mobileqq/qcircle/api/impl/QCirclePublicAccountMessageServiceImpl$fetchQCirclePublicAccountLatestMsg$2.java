package com.tencent.mobileqq.qcircle.api.impl;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "recentContactInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class QCirclePublicAccountMessageServiceImpl$fetchQCirclePublicAccountLatestMsg$2 extends Lambda implements Function1<RecentContactInfo, Unit> {
    final /* synthetic */ Function1<MsgRecord, Unit> $callback;
    final /* synthetic */ w $msgService;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public QCirclePublicAccountMessageServiceImpl$fetchQCirclePublicAccountLatestMsg$2(w wVar, Function1<? super MsgRecord, Unit> function1) {
        super(1);
        this.$msgService = wVar;
        this.$callback = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function1 callback, int i3, String str, ArrayList msgList) {
        Object firstOrNull;
        String briefString;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) msgList);
        MsgRecord msgRecord = (MsgRecord) firstOrNull;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("fetchQCirclePublicAccountLatestMsg=");
        briefString = QCirclePublicAccountMessageServiceImplKt.toBriefString(msgRecord);
        sb5.append(briefString);
        QLog.i(QCirclePublicAccountMessageServiceImpl.TAG, 1, sb5.toString());
        callback.invoke(msgRecord);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RecentContactInfo recentContactInfo) {
        invoke2(recentContactInfo);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@Nullable RecentContactInfo recentContactInfo) {
        Contact contact;
        ArrayList<Long> arrayListOf;
        w wVar = this.$msgService;
        contact = QCirclePublicAccountMessageServiceImpl.qCirclePublicAccountContact;
        Long[] lArr = new Long[1];
        lArr[0] = Long.valueOf(recentContactInfo != null ? recentContactInfo.msgId : -1L);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(lArr);
        final Function1<MsgRecord, Unit> function1 = this.$callback;
        wVar.getMsgsByMsgId(contact, arrayListOf, new IMsgOperateCallback() { // from class: com.tencent.mobileqq.qcircle.api.impl.f
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList) {
                QCirclePublicAccountMessageServiceImpl$fetchQCirclePublicAccountLatestMsg$2.b(Function1.this, i3, str, arrayList);
            }
        });
    }
}
