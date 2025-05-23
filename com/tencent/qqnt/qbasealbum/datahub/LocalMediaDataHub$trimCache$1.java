package com.tencent.qqnt.qbasealbum.datahub;

import com.tencent.cache.api.collection.QQConcurrentHashMap;
import com.tencent.cache.api.collection.QQCopyOnWriteArrayList;
import com.tencent.cache.api.collection.QQHashMap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub$trimCache$1", f = "LocalMediaDataHub.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes25.dex */
public final class LocalMediaDataHub$trimCache$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    int label;
    final /* synthetic */ LocalMediaDataHub this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalMediaDataHub$trimCache$1(LocalMediaDataHub localMediaDataHub, Continuation<? super LocalMediaDataHub$trimCache$1> continuation) {
        super(2, continuation);
        this.this$0 = localMediaDataHub;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) localMediaDataHub, (Object) continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new LocalMediaDataHub$trimCache$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        AtomicBoolean atomicBoolean;
        int i3;
        QQCopyOnWriteArrayList qQCopyOnWriteArrayList;
        int i16;
        int i17;
        QQCopyOnWriteArrayList qQCopyOnWriteArrayList2;
        QQCopyOnWriteArrayList qQCopyOnWriteArrayList3;
        QQHashMap qQHashMap;
        AtomicBoolean atomicBoolean2;
        QQConcurrentHashMap qQConcurrentHashMap;
        QQCopyOnWriteArrayList<LocalMediaInfo> qQCopyOnWriteArrayList4;
        QQConcurrentHashMap qQConcurrentHashMap2;
        Object putIfAbsent;
        QQConcurrentHashMap qQConcurrentHashMap3;
        Object putIfAbsent2;
        AtomicBoolean atomicBoolean3;
        QQCopyOnWriteArrayList qQCopyOnWriteArrayList5;
        QQConcurrentHashMap qQConcurrentHashMap4;
        QQHashMap qQHashMap2;
        AtomicBoolean atomicBoolean4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                atomicBoolean = this.this$0.hasTrim;
                if (!atomicBoolean.get()) {
                    i3 = LocalMediaDataHub.f361107s;
                    if (i3 <= 0) {
                        qQCopyOnWriteArrayList5 = this.this$0.localMedias;
                        qQCopyOnWriteArrayList5.clear();
                        qQConcurrentHashMap4 = this.this$0.albumToLocalMedia;
                        qQConcurrentHashMap4.clear();
                        qQHashMap2 = this.this$0.idToLocalMedia;
                        qQHashMap2.clear();
                        atomicBoolean4 = this.this$0.hasTrim;
                        atomicBoolean4.set(true);
                        this.this$0.o0(false);
                        ox3.a.c("QBaseAlbum.LocalMediaDataHub", new Function0<String>() { // from class: com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub$trimCache$1.2
                            static IPatchRedirector $redirector_;

                            {
                                super(0);
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LocalMediaDataHub.this);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function0
                            @NotNull
                            public final String invoke() {
                                QQConcurrentHashMap qQConcurrentHashMap5;
                                QQCopyOnWriteArrayList qQCopyOnWriteArrayList6;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                                }
                                qQConcurrentHashMap5 = LocalMediaDataHub.this.albumToLocalMedia;
                                ArrayList arrayList = new ArrayList(qQConcurrentHashMap5.size());
                                Iterator it = qQConcurrentHashMap5.entrySet().iterator();
                                while (it.hasNext()) {
                                    Map.Entry entry = (Map.Entry) it.next();
                                    arrayList.add(entry.getKey() + "-" + ((List) entry.getValue()).size());
                                }
                                qQCopyOnWriteArrayList6 = LocalMediaDataHub.this.localMedias;
                                return "trimCache albumToLocalMedia: " + arrayList + ", localMedias: " + qQCopyOnWriteArrayList6.size();
                            }
                        });
                        return Unit.INSTANCE;
                    }
                    qQCopyOnWriteArrayList = this.this$0.localMedias;
                    ArrayList arrayList = new ArrayList(qQCopyOnWriteArrayList);
                    int size = arrayList.size();
                    i16 = LocalMediaDataHub.f361107s;
                    if (size <= i16) {
                        atomicBoolean3 = this.this$0.hasTrim;
                        atomicBoolean3.set(true);
                        ox3.a.c("QBaseAlbum.LocalMediaDataHub", new Function0<String>() { // from class: com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub$trimCache$1.3
                            static IPatchRedirector $redirector_;

                            {
                                super(0);
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LocalMediaDataHub.this);
                                }
                            }

                            @Override // kotlin.jvm.functions.Function0
                            @NotNull
                            public final String invoke() {
                                QQCopyOnWriteArrayList qQCopyOnWriteArrayList6;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                                }
                                qQCopyOnWriteArrayList6 = LocalMediaDataHub.this.localMedias;
                                return "trimCache, localMedias: " + qQCopyOnWriteArrayList6.size();
                            }
                        });
                        return Unit.INSTANCE;
                    }
                    i17 = LocalMediaDataHub.f361107s;
                    List subList = arrayList.subList(0, i17);
                    Intrinsics.checkNotNullExpressionValue(subList, "backupLocalMedia.subList(0, CACHE_SIZE)");
                    qQCopyOnWriteArrayList2 = this.this$0.localMedias;
                    qQCopyOnWriteArrayList2.clear();
                    qQCopyOnWriteArrayList3 = this.this$0.localMedias;
                    qQCopyOnWriteArrayList3.addAll(subList);
                    qQHashMap = this.this$0.idToLocalMedia;
                    qQHashMap.clear();
                    this.this$0.o0(false);
                    atomicBoolean2 = this.this$0.hasTrim;
                    atomicBoolean2.set(true);
                    com.tencent.qqnt.qbasealbum.query.b.f361494a.a();
                    qQConcurrentHashMap = this.this$0.albumToLocalMedia;
                    qQConcurrentHashMap.clear();
                    qQCopyOnWriteArrayList4 = this.this$0.localMedias;
                    LocalMediaDataHub localMediaDataHub = this.this$0;
                    for (LocalMediaInfo it : qQCopyOnWriteArrayList4) {
                        if (com.tencent.qqnt.qbasealbum.ktx.b.o(it)) {
                            qQConcurrentHashMap3 = localMediaDataHub.albumToLocalMedia;
                            String b16 = com.tencent.qqnt.qbasealbum.model.a.f361348a.b();
                            Object obj2 = qQConcurrentHashMap3.get(b16);
                            if (obj2 == null && (putIfAbsent2 = qQConcurrentHashMap3.putIfAbsent(b16, (obj2 = Collections.synchronizedList(new ArrayList())))) != null) {
                                obj2 = putIfAbsent2;
                            }
                            Intrinsics.checkNotNullExpressionValue(it, "it");
                            ((List) obj2).add(it);
                        }
                        qQConcurrentHashMap2 = localMediaDataHub.albumToLocalMedia;
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        String c16 = com.tencent.qqnt.qbasealbum.ktx.b.c(it);
                        Object obj3 = qQConcurrentHashMap2.get(c16);
                        if (obj3 == null && (putIfAbsent = qQConcurrentHashMap2.putIfAbsent(c16, (obj3 = Collections.synchronizedList(new ArrayList())))) != null) {
                            obj3 = putIfAbsent;
                        }
                        ((List) obj3).add(it);
                    }
                    ox3.a.c("QBaseAlbum.LocalMediaDataHub", new Function0<String>() { // from class: com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub$trimCache$1.5
                        static IPatchRedirector $redirector_;

                        {
                            super(0);
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LocalMediaDataHub.this);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final String invoke() {
                            QQConcurrentHashMap qQConcurrentHashMap5;
                            QQCopyOnWriteArrayList qQCopyOnWriteArrayList6;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                            qQConcurrentHashMap5 = LocalMediaDataHub.this.albumToLocalMedia;
                            ArrayList arrayList2 = new ArrayList(qQConcurrentHashMap5.size());
                            Iterator it5 = qQConcurrentHashMap5.entrySet().iterator();
                            while (it5.hasNext()) {
                                Map.Entry entry = (Map.Entry) it5.next();
                                arrayList2.add(entry.getKey() + "-" + ((List) entry.getValue()).size());
                            }
                            qQCopyOnWriteArrayList6 = LocalMediaDataHub.this.localMedias;
                            return "trimCache albumToLocalMedia: " + arrayList2 + ", localMedias: " + qQCopyOnWriteArrayList6.size();
                        }
                    });
                    return Unit.INSTANCE;
                }
                ox3.a.c("QBaseAlbum.LocalMediaDataHub", AnonymousClass1.INSTANCE);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return iPatchRedirector.redirect((short) 2, (Object) this, obj);
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((LocalMediaDataHub$trimCache$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
