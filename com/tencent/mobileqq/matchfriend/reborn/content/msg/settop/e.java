package com.tencent.mobileqq.matchfriend.reborn.content.msg.settop;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qqstranger.relation.relation.Relation$GetStickyReq;
import com.tencent.trpcprotocol.qqstranger.relation.relation.Relation$GetStickyRsp;
import com.tencent.trpcprotocol.qqstranger.relation.relation.Relation$StickReq;
import com.tencent.trpcprotocol.qqstranger.relation.relation.Relation$StickRsp;
import com.tencent.trpcprotocol.qqstranger.relation.relation.Relation$StickyItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJT\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\b2\u001e\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u000bH\u0002J$\u0010\u0014\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00022\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002JJ\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\b2\u001e\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u000bJJ\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\b2\u001e\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u000bJc\u0010\u001b\u001a\u00020\t2\u0012\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0017\"\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\b2$\u0010\r\u001a \u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/settop/e;", "", "", "tinyId", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/settop/SetTopBizType;", "bizType", "", "setTop", "Lkotlin/Function1;", "", "onFailed", "Lkotlin/Function3;", "", "onSuccess", "f", "cmd", "Lcom/tencent/mobileqq/pb/MessageMicro;", "req", "Lcom/tencent/relation/common/servlet/b;", "observer", "d", "e", "c", "", "tinyIds", "", "Lcom/tencent/trpcprotocol/qqstranger/relation/relation/Relation$StickyItem;", h.F, "([Ljava/lang/String;Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/settop/SetTopBizType;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)V", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f244810a = new e();

    e() {
    }

    private final void d(String cmd, MessageMicro<?> req, com.tencent.relation.common.servlet.b observer) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface != null) {
            Object businessHandler = appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4);
            Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.relation.common.servlet.IRelationRequestHandler");
            ((com.tencent.relation.common.servlet.a) businessHandler).Z0(cmd, req.toByteArray(), observer);
        } else {
            QLog.i("SetTopNetRequests", 1, "[doRequest], app is null, request fail");
            observer.onUpdate(0, false, new Object());
        }
    }

    private final void f(String tinyId, SetTopBizType bizType, boolean setTop, final Function1<? super String, Unit> onFailed, final Function3<? super Integer, ? super String, ? super Boolean, Unit> onSuccess) {
        Relation$StickReq relation$StickReq = new Relation$StickReq();
        relation$StickReq.appid.set(b.a(bizType));
        relation$StickReq.user_id.set(tinyId);
        relation$StickReq.f381615op.set(setTop ? 1 : 2);
        d("QQStranger.Relation.SsoStick", relation$StickReq, new com.tencent.relation.common.servlet.b() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.settop.d
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z16, Object obj) {
                e.g(Function1.this, onSuccess, i3, z16, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Function1 onFailed, Function3 onSuccess, int i3, boolean z16, Object obj) {
        Intrinsics.checkNotNullParameter(onFailed, "$onFailed");
        Intrinsics.checkNotNullParameter(onSuccess, "$onSuccess");
        if (QLog.isColorLevel()) {
            QLog.d("SetTopNetRequests", 2, "[SsoStick] isSuccess=" + z16);
        }
        if (z16 && (obj instanceof byte[])) {
            Relation$StickRsp relation$StickRsp = new Relation$StickRsp();
            try {
                relation$StickRsp.mergeFrom((byte[]) obj);
                QLog.i("SetTopNetRequests", 1, "[SsoStick], ret_code=" + relation$StickRsp.ret_code.get() + ", ret_msg=" + relation$StickRsp.ret_msg.get() + ", sticky=" + relation$StickRsp.sticky.get());
                Integer valueOf = Integer.valueOf(relation$StickRsp.ret_code.get());
                String str = relation$StickRsp.ret_msg.get();
                Intrinsics.checkNotNullExpressionValue(str, "rsp.ret_msg.get()");
                onSuccess.invoke(valueOf, str, Boolean.valueOf(relation$StickRsp.sticky.get()));
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("SetTopNetRequests", 1, "[SsoStick] error: ", e16);
                onFailed.invoke("[SsoStick] error: " + e16.getMessage());
                return;
            }
        }
        onFailed.invoke("request failed, response failed or error format data");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Function1 onFailed, Function3 onSuccess, int i3, boolean z16, Object obj) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(onFailed, "$onFailed");
        Intrinsics.checkNotNullParameter(onSuccess, "$onSuccess");
        if (QLog.isColorLevel()) {
            QLog.d("SetTopNetRequests", 2, "[SsoGetSticky] isSuccess=" + z16);
        }
        if (z16 && (obj instanceof byte[])) {
            Relation$GetStickyRsp relation$GetStickyRsp = new Relation$GetStickyRsp();
            try {
                relation$GetStickyRsp.mergeFrom((byte[]) obj);
                int i16 = relation$GetStickyRsp.ret_code.get();
                String str = relation$GetStickyRsp.ret_msg.get();
                List<Relation$StickyItem> list = relation$GetStickyRsp.items.get();
                Intrinsics.checkNotNullExpressionValue(list, "rsp.items.get()");
                List<Relation$StickyItem> list2 = list;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(((Relation$StickyItem) it.next()).user_id.get());
                }
                QLog.i("SetTopNetRequests", 1, "[SsoGetSticky], ret_code=" + i16 + ", ret_msg=" + str + ", items=" + arrayList);
                Integer valueOf = Integer.valueOf(relation$GetStickyRsp.ret_code.get());
                String str2 = relation$GetStickyRsp.ret_msg.get();
                Intrinsics.checkNotNullExpressionValue(str2, "rsp.ret_msg.get()");
                List<Relation$StickyItem> list3 = relation$GetStickyRsp.items.get();
                Intrinsics.checkNotNullExpressionValue(list3, "rsp.items.get()");
                onSuccess.invoke(valueOf, str2, list3);
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("SetTopNetRequests", 1, "[SsoGetSticky] error: ", e16);
                onFailed.invoke("[SsoGetSticky] error: " + e16.getMessage());
                return;
            }
        }
        onFailed.invoke("request failed, response failed or error format data");
    }

    public final void c(String tinyId, SetTopBizType bizType, Function1<? super String, Unit> onFailed, Function3<? super Integer, ? super String, ? super Boolean, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(bizType, "bizType");
        Intrinsics.checkNotNullParameter(onFailed, "onFailed");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        if (QLog.isColorLevel()) {
            QLog.i("SetTopNetRequests", 1, "doCancelTop tinyId: " + tinyId + ", bizType: " + bizType);
        }
        f(tinyId, bizType, false, onFailed, onSuccess);
    }

    public final void e(String tinyId, SetTopBizType bizType, Function1<? super String, Unit> onFailed, Function3<? super Integer, ? super String, ? super Boolean, Unit> onSuccess) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(bizType, "bizType");
        Intrinsics.checkNotNullParameter(onFailed, "onFailed");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        if (QLog.isColorLevel()) {
            QLog.i("SetTopNetRequests", 1, "doSetTop tinyId: " + tinyId + ", bizType: " + bizType);
        }
        f(tinyId, bizType, true, onFailed, onSuccess);
    }

    public final void h(String[] tinyIds, SetTopBizType bizType, final Function1<? super String, Unit> onFailed, final Function3<? super Integer, ? super String, ? super List<Relation$StickyItem>, Unit> onSuccess) {
        List<String> list;
        Intrinsics.checkNotNullParameter(tinyIds, "tinyIds");
        Intrinsics.checkNotNullParameter(bizType, "bizType");
        Intrinsics.checkNotNullParameter(onFailed, "onFailed");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Relation$GetStickyReq relation$GetStickyReq = new Relation$GetStickyReq();
        relation$GetStickyReq.appid.set(b.a(bizType));
        if (!(tinyIds.length == 0)) {
            PBRepeatField<String> pBRepeatField = relation$GetStickyReq.user_id;
            list = ArraysKt___ArraysKt.toList(tinyIds);
            pBRepeatField.set(list);
        }
        d("QQStranger.Relation.SsoGetSticky", relation$GetStickyReq, new com.tencent.relation.common.servlet.b() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.settop.c
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z16, Object obj) {
                e.i(Function1.this, onSuccess, i3, z16, obj);
            }
        });
    }
}
