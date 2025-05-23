package com.tencent.mobileqq.matchfriend.reborn.liteinteraction.action;

import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002R<\u0010\f\u001a*\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b0\u0006j\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b`\t8\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR0\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0006j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004`\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u001b\u0010\u0013\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\n\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/liteinteraction/action/QQStrangerLIAClickHandlerProvider;", "", "", "actionType", "Lcom/tencent/mobileqq/matchfriend/reborn/liteinteraction/action/a;", "a", "Ljava/util/HashMap;", "", "Ljava/lang/Class;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "mLoaderClzMap", "c", "mLoaderInstantMap", "Lcom/tencent/mobileqq/matchfriend/reborn/liteinteraction/action/c;", "d", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/matchfriend/reborn/liteinteraction/action/c;", "mDefaultLIAClickHandler", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerLIAClickHandlerProvider {

    /* renamed from: a, reason: collision with root package name */
    public static final QQStrangerLIAClickHandlerProvider f245123a = new QQStrangerLIAClickHandlerProvider();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/Chats/Inject_QQStrangerLIAClickActionHandlerProvider.yml", version = 1)
    private static final HashMap<String, Class<a>> mLoaderClzMap = new HashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final HashMap<Integer, a> mLoaderInstantMap = new HashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final Lazy mDefaultLIAClickHandler;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.mobileqq.matchfriend.reborn.liteinteraction.action.QQStrangerLIAClickHandlerProvider$mDefaultLIAClickHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final c invoke() {
                return new c();
            }
        });
        mDefaultLIAClickHandler = lazy;
    }

    QQStrangerLIAClickHandlerProvider() {
    }

    private final c b() {
        return (c) mDefaultLIAClickHandler.getValue();
    }

    public final a a(int actionType) {
        HashMap<Integer, a> hashMap = mLoaderInstantMap;
        a aVar = hashMap.get(Integer.valueOf(actionType));
        if (aVar != null) {
            return aVar;
        }
        Class<a> cls = mLoaderClzMap.get(String.valueOf(actionType));
        if (cls != null) {
            a newInstance = cls.newInstance();
            if (newInstance != null) {
                hashMap.put(Integer.valueOf(actionType), newInstance);
            }
            return newInstance;
        }
        return b();
    }
}
