package com.tencent.qqnt.qbasealbum.datahub;

import com.tencent.cache.api.collection.QQConcurrentHashMap;
import com.tencent.cache.api.collection.QQCopyOnWriteArrayList;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.qbasealbum.query.MediaQueryHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
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
@DebugMetadata(c = "com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub$loadMediaData$2", f = "LocalMediaDataHub.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes25.dex */
public final class LocalMediaDataHub$loadMediaData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ boolean $isPreload;
    int label;
    final /* synthetic */ LocalMediaDataHub this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalMediaDataHub$loadMediaData$2(boolean z16, LocalMediaDataHub localMediaDataHub, Continuation<? super LocalMediaDataHub$loadMediaData$2> continuation) {
        super(2, continuation);
        this.$isPreload = z16;
        this.this$0 = localMediaDataHub;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), localMediaDataHub, continuation);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Continuation) iPatchRedirector.redirect((short) 3, (Object) this, obj, (Object) continuation);
        }
        return new LocalMediaDataHub$loadMediaData$2(this.$isPreload, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Integer num;
        MediaQueryHelper mediaQueryHelper;
        MediaQueryHelper mediaQueryHelper2;
        MediaQueryHelper mediaQueryHelper3;
        boolean z16;
        MediaQueryHelper mediaQueryHelper4;
        AtomicBoolean atomicBoolean;
        AtomicBoolean atomicBoolean2;
        AtomicBoolean atomicBoolean3;
        AtomicBoolean atomicBoolean4;
        AtomicBoolean atomicBoolean5;
        MediaQueryHelper mediaQueryHelper5;
        boolean z17;
        MediaQueryHelper mediaQueryHelper6;
        Object obj2;
        Object obj3;
        AtomicBoolean atomicBoolean6;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                long currentTimeMillis = System.currentTimeMillis();
                if (this.$isPreload) {
                    i3 = this.this$0.preloadLimit;
                    num = Boxing.boxInt(i3);
                } else {
                    num = null;
                }
                this.this$0.X(num);
                mediaQueryHelper = this.this$0.mainQueryHelper;
                if (mediaQueryHelper == null) {
                    atomicBoolean6 = this.this$0.com.tencent.qqmini.sdk.widget.ToastView.ICON_LOADING java.lang.String;
                    atomicBoolean6.set(false);
                    ox3.a.c("QBaseAlbum.LocalMediaDataHub", AnonymousClass1.INSTANCE);
                    return Unit.INSTANCE;
                }
                while (true) {
                    mediaQueryHelper2 = this.this$0.mainQueryHelper;
                    Intrinsics.checkNotNull(mediaQueryHelper2);
                    if (!mediaQueryHelper2.e()) {
                        atomicBoolean5 = this.this$0.interrupted;
                        if (!atomicBoolean5.get()) {
                            mediaQueryHelper5 = this.this$0.mainQueryHelper;
                            if (mediaQueryHelper5 != null && !mediaQueryHelper5.d()) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (!z17) {
                                break;
                            }
                            mediaQueryHelper6 = this.this$0.mainQueryHelper;
                            Intrinsics.checkNotNull(mediaQueryHelper6);
                            MediaQueryHelper.h(mediaQueryHelper6, 0, 1, null);
                            obj2 = this.this$0.mediaLock;
                            LocalMediaDataHub localMediaDataHub = this.this$0;
                            synchronized (obj2) {
                                obj3 = localMediaDataHub.mediaLock;
                                obj3.notifyAll();
                                Unit unit = Unit.INSTANCE;
                            }
                            Thread.yield();
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                mediaQueryHelper3 = this.this$0.mainQueryHelper;
                if (mediaQueryHelper3 != null && mediaQueryHelper3.d()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    atomicBoolean4 = this.this$0.interrupted;
                    atomicBoolean4.set(true);
                    ox3.a.c("QBaseAlbum.LocalMediaDataHub", new Function0<String>() { // from class: com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub$loadMediaData$2.3
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
                            int i16;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                            i16 = LocalMediaDataHub.this.updateMediaIndex;
                            return "handle interrupt! " + i16;
                        }
                    });
                }
                mediaQueryHelper4 = this.this$0.mainQueryHelper;
                if (mediaQueryHelper4 != null) {
                    mediaQueryHelper4.c();
                }
                this.this$0.mainQueryHelper = null;
                atomicBoolean = this.this$0.interrupted;
                if (!atomicBoolean.get()) {
                    this.this$0.o0(true);
                    ox3.a.c("QBaseAlbum.LocalMediaDataHub", new Function0<String>() { // from class: com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub$loadMediaData$2.4
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
                            int i16;
                            QQConcurrentHashMap qQConcurrentHashMap;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                            i16 = LocalMediaDataHub.this.updateMediaIndex;
                            qQConcurrentHashMap = LocalMediaDataHub.this.albumToLocalMedia;
                            ArrayList arrayList = new ArrayList(qQConcurrentHashMap.size());
                            Iterator it = qQConcurrentHashMap.entrySet().iterator();
                            while (it.hasNext()) {
                                Map.Entry entry = (Map.Entry) it.next();
                                arrayList.add(TuplesKt.to(entry.getKey(), Integer.valueOf(((List) entry.getValue()).size())));
                            }
                            return "handle end! " + i16 + ", " + arrayList;
                        }
                    });
                } else {
                    ox3.a.c("QBaseAlbum.LocalMediaDataHub", new Function0<String>() { // from class: com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub$loadMediaData$2.5
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
                            int i16;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                            i16 = LocalMediaDataHub.this.updateMediaIndex;
                            return "handle interrupt! " + i16;
                        }
                    });
                }
                this.this$0.updateMediaIndex = 0;
                atomicBoolean2 = this.this$0.interrupted;
                atomicBoolean2.set(false);
                atomicBoolean3 = this.this$0.com.tencent.qqmini.sdk.widget.ToastView.ICON_LOADING java.lang.String;
                atomicBoolean3.set(false);
                ox3.a.c("QBaseAlbum.LocalMediaDataHub", new Function0<String>() { // from class: com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub$loadMediaData$2.6
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
                        int i16;
                        QQConcurrentHashMap qQConcurrentHashMap;
                        QQCopyOnWriteArrayList qQCopyOnWriteArrayList;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                        i16 = LocalMediaDataHub.this.updateMediaIndex;
                        qQConcurrentHashMap = LocalMediaDataHub.this.albumToLocalMedia;
                        ArrayList arrayList = new ArrayList(qQConcurrentHashMap.size());
                        Iterator it = qQConcurrentHashMap.entrySet().iterator();
                        while (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            arrayList.add(TuplesKt.to(entry.getKey(), Integer.valueOf(((List) entry.getValue()).size())));
                        }
                        qQCopyOnWriteArrayList = LocalMediaDataHub.this.localMedias;
                        return "handle end! " + i16 + ", " + arrayList + ", localMediaSize: " + qQCopyOnWriteArrayList.size();
                    }
                });
                ox3.a.h(new Function0<String>(currentTimeMillis) { // from class: com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub$loadMediaData$2.7
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ long $start;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$start = currentTimeMillis;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, currentTimeMillis);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final String invoke() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                        }
                        return "loadMediaData finish, cost:" + (System.currentTimeMillis() - this.$start);
                    }
                });
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? ((LocalMediaDataHub$loadMediaData$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE) : iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope, (Object) continuation);
    }
}
