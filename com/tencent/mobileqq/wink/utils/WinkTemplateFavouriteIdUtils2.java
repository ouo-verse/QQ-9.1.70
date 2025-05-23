package com.tencent.mobileqq.wink.utils;

import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.wink.edit.util.AECameraPrefsUtil;
import feedcloud.TagCollection$ReadListRsp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u0019\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\u0004J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0007R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/wink/utils/WinkTemplateFavouriteIdUtils2;", "", "", "j", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "g", "", "", tl.h.F, "id", "i", "", "e", "f", "", "b", "Ljava/util/List;", "ids", "c", "Z", "isRead", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkTemplateFavouriteIdUtils2 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WinkTemplateFavouriteIdUtils2 f326648a = new WinkTemplateFavouriteIdUtils2();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<String> ids = new LinkedList();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean isRead;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u000b\u001a\u00020\n2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\n\u00a2\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/tencent/biz/richframework/network/request/BaseRequest;", Const.BUNDLE_KEY_REQUEST, "", "isSuccess", "", "retCode", "", "errMsg", "Lfeedcloud/TagCollection$ReadListRsp;", "rsp", "", "a", "(Lcom/tencent/biz/richframework/network/request/BaseRequest;ZJLjava/lang/String;Lfeedcloud/TagCollection$ReadListRsp;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a<T> implements VSDispatchObserver.OnVSRspCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<Boolean> f326651a;

        /* JADX WARN: Multi-variable type inference failed */
        a(Continuation<? super Boolean> continuation) {
            this.f326651a = continuation;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onReceive(@Nullable BaseRequest baseRequest, boolean z16, long j3, @Nullable String str, @Nullable TagCollection$ReadListRsp tagCollection$ReadListRsp) {
            w53.b.f("WinkTemplateFavouriteIdUtils2", "[getFavoriteListFromServer] isSuccess:" + z16 + " retCode:" + j3);
            if (z16 && j3 == 0) {
                if (tagCollection$ReadListRsp != null) {
                    Intrinsics.checkNotNullExpressionValue(tagCollection$ReadListRsp.unified_id.get(), "rsp.unified_id.get()");
                    if (!r6.isEmpty()) {
                        w53.b.f("WinkTemplateFavouriteIdUtils2", "[getFavoriteListFromServer] size:" + WinkTemplateFavouriteIdUtils2.ids.size() + " ids:" + WinkTemplateFavouriteIdUtils2.ids + "  size:" + tagCollection$ReadListRsp.unified_id.get().size() + " rsp.unified_id:" + tagCollection$ReadListRsp.unified_id.get());
                        List<String> list = tagCollection$ReadListRsp.unified_id.get();
                        Intrinsics.checkNotNullExpressionValue(list, "rsp.unified_id.get()");
                        for (String it : list) {
                            if (!WinkTemplateFavouriteIdUtils2.ids.contains(it)) {
                                List list2 = WinkTemplateFavouriteIdUtils2.ids;
                                Intrinsics.checkNotNullExpressionValue(it, "it");
                                list2.add(it);
                            }
                        }
                    }
                }
                WinkTemplateFavouriteIdUtils2.isRead = true;
                Continuation<Boolean> continuation = this.f326651a;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(Boolean.TRUE));
                return;
            }
            Continuation<Boolean> continuation2 = this.f326651a;
            Result.Companion companion2 = Result.INSTANCE;
            continuation2.resumeWith(Result.m476constructorimpl(Boolean.FALSE));
        }
    }

    WinkTemplateFavouriteIdUtils2() {
    }

    private final Object g(Continuation<? super Boolean> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        o83.a.f422212a.b("libTemplate", new a(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object j(Continuation<? super Boolean> continuation) {
        WinkTemplateFavouriteIdUtils2$retrieveIds$1 winkTemplateFavouriteIdUtils2$retrieveIds$1;
        Object coroutine_suspended;
        int i3;
        List emptyList;
        boolean z16;
        if (continuation instanceof WinkTemplateFavouriteIdUtils2$retrieveIds$1) {
            winkTemplateFavouriteIdUtils2$retrieveIds$1 = (WinkTemplateFavouriteIdUtils2$retrieveIds$1) continuation;
            int i16 = winkTemplateFavouriteIdUtils2$retrieveIds$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                winkTemplateFavouriteIdUtils2$retrieveIds$1.label = i16 - Integer.MIN_VALUE;
                Object obj = winkTemplateFavouriteIdUtils2$retrieveIds$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = winkTemplateFavouriteIdUtils2$retrieveIds$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                            isRead = true;
                            return Boxing.boxBoolean(true);
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                ResultKt.throwOnFailure(obj);
                String g16 = AECameraPrefsUtil.c().g("wink_template_favourite_id", "", 0);
                List<String> list = ids;
                list.clear();
                if (g16 == null) {
                    winkTemplateFavouriteIdUtils2$retrieveIds$1.label = 1;
                    obj = g(winkTemplateFavouriteIdUtils2$retrieveIds$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return obj;
                }
                List<String> split = new Regex(";").split(g16, 0);
                if (!split.isEmpty()) {
                    ListIterator<String> listIterator = split.listIterator(split.size());
                    while (listIterator.hasPrevious()) {
                        if (listIterator.previous().length() == 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (!z16) {
                            emptyList = CollectionsKt___CollectionsKt.take(split, listIterator.nextIndex() + 1);
                            break;
                        }
                    }
                }
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                Object[] array = emptyList.toArray(new String[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                String[] strArr = (String[]) array;
                List asList = Arrays.asList(Arrays.copyOf(strArr, strArr.length));
                Intrinsics.checkNotNullExpressionValue(asList, "asList(*s.split(\";\".toRe\u2026         .toTypedArray())");
                list.addAll(asList);
                o83.a.f422212a.e("libTemplate", ids, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.mobileqq.wink.utils.av
                    @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                    public final void onReceive(BaseRequest baseRequest, boolean z17, long j3, String str, Object obj2) {
                        WinkTemplateFavouriteIdUtils2.k(baseRequest, z17, j3, str, obj2);
                    }
                });
                winkTemplateFavouriteIdUtils2$retrieveIds$1.L$0 = this;
                winkTemplateFavouriteIdUtils2$retrieveIds$1.label = 2;
                if (g(winkTemplateFavouriteIdUtils2$retrieveIds$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                isRead = true;
                return Boxing.boxBoolean(true);
            }
        }
        winkTemplateFavouriteIdUtils2$retrieveIds$1 = new WinkTemplateFavouriteIdUtils2$retrieveIds$1(this, continuation);
        Object obj2 = winkTemplateFavouriteIdUtils2$retrieveIds$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = winkTemplateFavouriteIdUtils2$retrieveIds$1.label;
        if (i3 == 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
        List<String> list = ids;
        w53.b.f("WinkTemplateFavouriteIdUtils2", "[sendFavoriteListToServer] size:" + list.size() + " ids:" + list + " isSuccess:" + z16 + " retCode:" + j3);
        if (z16 && j3 == 0) {
            AECameraPrefsUtil.c().l("wink_template_favourite_id", 0);
        }
    }

    public final void e(@NotNull String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        ids.add(0, id5);
    }

    public final void f(@NotNull String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        ids.remove(id5);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object h(@NotNull Continuation<? super List<String>> continuation) {
        WinkTemplateFavouriteIdUtils2$getIds$1 winkTemplateFavouriteIdUtils2$getIds$1;
        Object coroutine_suspended;
        int i3;
        if (continuation instanceof WinkTemplateFavouriteIdUtils2$getIds$1) {
            winkTemplateFavouriteIdUtils2$getIds$1 = (WinkTemplateFavouriteIdUtils2$getIds$1) continuation;
            int i16 = winkTemplateFavouriteIdUtils2$getIds$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                winkTemplateFavouriteIdUtils2$getIds$1.label = i16 - Integer.MIN_VALUE;
                Object obj = winkTemplateFavouriteIdUtils2$getIds$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = winkTemplateFavouriteIdUtils2$getIds$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    winkTemplateFavouriteIdUtils2$getIds$1.label = 1;
                    if (j(winkTemplateFavouriteIdUtils2$getIds$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return new ArrayList(ids);
            }
        }
        winkTemplateFavouriteIdUtils2$getIds$1 = new WinkTemplateFavouriteIdUtils2$getIds$1(this, continuation);
        Object obj2 = winkTemplateFavouriteIdUtils2$getIds$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = winkTemplateFavouriteIdUtils2$getIds$1.label;
        if (i3 == 0) {
        }
        return new ArrayList(ids);
    }

    public final boolean i(@NotNull String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        return ids.contains(id5);
    }
}
