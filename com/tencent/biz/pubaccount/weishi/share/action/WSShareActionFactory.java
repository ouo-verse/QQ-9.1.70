package com.tencent.biz.pubaccount.weishi.share.action;

import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002R(\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00070\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/share/action/WSShareActionFactory;", "", "", "actionId", "Lcom/tencent/biz/pubaccount/weishi/share/action/a;", "a", "", "Lkotlin/Function0;", "b", "Ljava/util/Map;", "actionMap", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSShareActionFactory {

    /* renamed from: a, reason: collision with root package name */
    public static final WSShareActionFactory f81580a = new WSShareActionFactory();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Map<Integer, Function0<a>> actionMap;

    static {
        Map<Integer, Function0<a>> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(2, new Function0<a>() { // from class: com.tencent.biz.pubaccount.weishi.share.action.WSShareActionFactory$actionMap$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return new b();
            }
        }), TuplesKt.to(72, new Function0<a>() { // from class: com.tencent.biz.pubaccount.weishi.share.action.WSShareActionFactory$actionMap$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return new d();
            }
        }), TuplesKt.to(73, new Function0<a>() { // from class: com.tencent.biz.pubaccount.weishi.share.action.WSShareActionFactory$actionMap$3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return new c();
            }
        }), TuplesKt.to(3, new Function0<a>() { // from class: com.tencent.biz.pubaccount.weishi.share.action.WSShareActionFactory$actionMap$4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return new e();
            }
        }), TuplesKt.to(9, new Function0<a>() { // from class: com.tencent.biz.pubaccount.weishi.share.action.WSShareActionFactory$actionMap$5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return new g();
            }
        }), TuplesKt.to(10, new Function0<a>() { // from class: com.tencent.biz.pubaccount.weishi.share.action.WSShareActionFactory$actionMap$6
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return new h();
            }
        }), TuplesKt.to(11, new Function0<a>() { // from class: com.tencent.biz.pubaccount.weishi.share.action.WSShareActionFactory$actionMap$7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return new k();
            }
        }), TuplesKt.to(44, new Function0<a>() { // from class: com.tencent.biz.pubaccount.weishi.share.action.WSShareActionFactory$actionMap$8
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return new i();
            }
        }), TuplesKt.to(89, new Function0<a>() { // from class: com.tencent.biz.pubaccount.weishi.share.action.WSShareActionFactory$actionMap$9
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return new j();
            }
        }));
        actionMap = mutableMapOf;
    }

    WSShareActionFactory() {
    }

    public final a a(int actionId) {
        Function0<a> function0 = actionMap.get(Integer.valueOf(actionId));
        if (function0 != null) {
            return function0.invoke();
        }
        return null;
    }
}
