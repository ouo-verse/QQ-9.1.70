package com.tencent.aelight.camera.ae.util;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R0\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0002`\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/aelight/camera/ae/util/t;", "Lcom/tencent/aelight/camera/ae/util/l;", "Lcom/tencent/aelight/camera/ae/util/s;", "userOP", "", "c", "d", "b", "a", "Ljava/util/LinkedHashMap;", "Lcom/tencent/aelight/camera/ae/util/Operator;", "Lkotlin/collections/LinkedHashMap;", "Ljava/util/LinkedHashMap;", "map", "<init>", "()V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class t implements l {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final LinkedHashMap<Operator, s> map = new LinkedHashMap<>();

    @Override // com.tencent.aelight.camera.ae.util.l
    public void a() {
        ms.a.f("UserOperatorChain", "destroyScene");
        this.map.clear();
    }

    @Override // com.tencent.aelight.camera.ae.util.l
    public void b() {
        ms.a.f("UserOperatorChain", "recoverScene");
        for (Map.Entry<Operator, s> entry : this.map.entrySet()) {
            ms.a.f("UserOperatorChain", "recoverScene op = " + entry.getKey());
            entry.getValue().getAction().a();
        }
    }

    @Override // com.tencent.aelight.camera.ae.util.l
    public void c(s userOP) {
        Intrinsics.checkNotNullParameter(userOP, "userOP");
        ms.a.f("UserOperatorChain", "addOperation op = " + userOP.getOp());
        d(userOP);
        this.map.put(userOP.getOp(), userOP);
    }

    public void d(s userOP) {
        Intrinsics.checkNotNullParameter(userOP, "userOP");
        ms.a.f("UserOperatorChain", "removeOperation op = " + userOP.getOp());
        this.map.remove(userOP.getOp());
    }
}
