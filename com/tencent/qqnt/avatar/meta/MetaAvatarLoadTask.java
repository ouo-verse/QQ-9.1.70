package com.tencent.qqnt.avatar.meta;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.avatar.cache.d;
import com.tencent.qqnt.avatar.cache.e;
import com.tencent.qqnt.avatar.meta.info.AvatarInfoCheck;
import com.tencent.qqnt.avatar.meta.info.AvatarInfoRequestManager;
import com.tencent.qqnt.avatar.meta.resource.AvatarResourceManager;
import com.tencent.qqnt.avatar.util.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wv3.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \n2\u00020\u0001:\u0001'B%\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0010\u0019\u001a\u00020\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u00a2\u0006\u0004\b%\u0010&J;\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ%\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\rJ\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000eH\u0016R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010#\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006("}, d2 = {"Lcom/tencent/qqnt/avatar/meta/MetaAvatarLoadTask;", "Lcom/tencent/qqnt/avatar/meta/task/a;", "Lwv3/a;", "listener", "Landroid/content/Context;", "context", "", "Lcom/tencent/qqnt/avatar/meta/info/a;", "avatarInfoArr", "Landroid/graphics/Bitmap;", "g", "(Lwv3/a;Landroid/content/Context;[Lcom/tencent/qqnt/avatar/meta/info/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "f", "(Lwv3/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/qqnt/avatar/meta/task/b;", "c", "result", "", "b", "Lcom/tencent/qqnt/avatar/meta/request/c;", "Lcom/tencent/qqnt/avatar/layer/a;", "Lcom/tencent/qqnt/avatar/meta/request/c;", "loadRequest", "Lcom/tencent/qqnt/avatar/cache/e;", "Lcom/tencent/qqnt/avatar/cache/e;", "memoryCache", "Lcom/tencent/qqnt/avatar/cache/a;", "d", "Lcom/tencent/qqnt/avatar/cache/a;", "diskCache", "Lcom/tencent/qqnt/avatar/meta/b;", "e", "Lcom/tencent/qqnt/avatar/meta/b;", "avatarBean", "Lcom/tencent/qqnt/avatar/meta/TaskTracker;", "Lcom/tencent/qqnt/avatar/meta/TaskTracker;", "taskTracker", "<init>", "(Lcom/tencent/qqnt/avatar/meta/request/c;Lcom/tencent/qqnt/avatar/cache/e;Lcom/tencent/qqnt/avatar/cache/a;)V", "a", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class MetaAvatarLoadTask extends com.tencent.qqnt.avatar.meta.task.a {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.avatar.meta.request.c<com.tencent.qqnt.avatar.layer.a> loadRequest;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e memoryCache;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.avatar.cache.a diskCache;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b avatarBean;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TaskTracker taskTracker;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/avatar/meta/MetaAvatarLoadTask$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.avatar.meta.MetaAvatarLoadTask$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39823);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MetaAvatarLoadTask(@NotNull com.tencent.qqnt.avatar.meta.request.c<com.tencent.qqnt.avatar.layer.a> loadRequest, @NotNull e memoryCache, @NotNull com.tencent.qqnt.avatar.cache.a diskCache) {
        super(loadRequest.a().d());
        Intrinsics.checkNotNullParameter(loadRequest, "loadRequest");
        Intrinsics.checkNotNullParameter(memoryCache, "memoryCache");
        Intrinsics.checkNotNullParameter(diskCache, "diskCache");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, loadRequest, memoryCache, diskCache);
            return;
        }
        this.loadRequest = loadRequest;
        this.memoryCache = memoryCache;
        this.diskCache = diskCache;
        a a16 = loadRequest.a();
        Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.qqnt.avatar.meta.MetaAvatarBean");
        b bVar = (b) a16;
        this.avatarBean = bVar;
        this.taskTracker = new TaskTracker("MetaAvatarLoadTask", bVar.d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object f(wv3.a aVar, Continuation<? super com.tencent.qqnt.avatar.meta.info.a[]> continuation) {
        MetaAvatarLoadTask$getInfoArr$1 metaAvatarLoadTask$getInfoArr$1;
        Object coroutine_suspended;
        int i3;
        MetaAvatarLoadTask metaAvatarLoadTask;
        boolean z16;
        com.tencent.qqnt.avatar.meta.info.a[] aVarArr;
        if (continuation instanceof MetaAvatarLoadTask$getInfoArr$1) {
            metaAvatarLoadTask$getInfoArr$1 = (MetaAvatarLoadTask$getInfoArr$1) continuation;
            int i16 = metaAvatarLoadTask$getInfoArr$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                metaAvatarLoadTask$getInfoArr$1.label = i16 - Integer.MIN_VALUE;
                MetaAvatarLoadTask$getInfoArr$1 metaAvatarLoadTask$getInfoArr$12 = metaAvatarLoadTask$getInfoArr$1;
                Object obj = metaAvatarLoadTask$getInfoArr$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = metaAvatarLoadTask$getInfoArr$12.label;
                Integer num = null;
                if (i3 == 0) {
                    if (i3 == 1) {
                        aVar = (wv3.a) metaAvatarLoadTask$getInfoArr$12.L$1;
                        metaAvatarLoadTask = (MetaAvatarLoadTask) metaAvatarLoadTask$getInfoArr$12.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    AvatarInfoRequestManager avatarInfoRequestManager = AvatarInfoRequestManager.f352916a;
                    com.tencent.qqnt.avatar.meta.info.a[] h16 = avatarInfoRequestManager.h(this.avatarBean);
                    if (h16 != null) {
                        if (h16.length == 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (!z16) {
                            this.taskTracker.b("getAvatarInfoFromCache end size:" + h16.length);
                            AvatarInfoCheck.f352915a.a(h16[0], this.avatarBean);
                            return h16;
                        }
                    }
                    if (aVar != null) {
                        a.C11512a.a(aVar, null, 1, null);
                    }
                    b bVar = this.avatarBean;
                    metaAvatarLoadTask$getInfoArr$12.L$0 = this;
                    metaAvatarLoadTask$getInfoArr$12.L$1 = aVar;
                    metaAvatarLoadTask$getInfoArr$12.label = 1;
                    obj = AvatarInfoRequestManager.g(avatarInfoRequestManager, bVar, false, metaAvatarLoadTask$getInfoArr$12, 2, null);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    metaAvatarLoadTask = this;
                }
                aVarArr = (com.tencent.qqnt.avatar.meta.info.a[]) obj;
                TaskTracker taskTracker = metaAvatarLoadTask.taskTracker;
                if (aVarArr != null) {
                    num = Boxing.boxInt(aVarArr.length);
                }
                taskTracker.b("asyncGetAvatarInfo end size:" + num);
                if (aVar != null) {
                    aVar.a(metaAvatarLoadTask.a());
                }
                return aVarArr;
            }
        }
        metaAvatarLoadTask$getInfoArr$1 = new MetaAvatarLoadTask$getInfoArr$1(this, continuation);
        MetaAvatarLoadTask$getInfoArr$1 metaAvatarLoadTask$getInfoArr$122 = metaAvatarLoadTask$getInfoArr$1;
        Object obj2 = metaAvatarLoadTask$getInfoArr$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = metaAvatarLoadTask$getInfoArr$122.label;
        Integer num2 = null;
        if (i3 == 0) {
        }
        aVarArr = (com.tencent.qqnt.avatar.meta.info.a[]) obj2;
        TaskTracker taskTracker2 = metaAvatarLoadTask.taskTracker;
        if (aVarArr != null) {
        }
        taskTracker2.b("asyncGetAvatarInfo end size:" + num2);
        if (aVar != null) {
        }
        return aVarArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object g(wv3.a aVar, Context context, com.tencent.qqnt.avatar.meta.info.a[] aVarArr, Continuation<? super Bitmap[]> continuation) {
        MetaAvatarLoadTask$getSourceBitmapArr$1 metaAvatarLoadTask$getSourceBitmapArr$1;
        Object coroutine_suspended;
        int i3;
        int coerceAtLeast;
        int i16;
        Bitmap[] bitmapArr;
        MetaAvatarLoadTask metaAvatarLoadTask;
        com.tencent.qqnt.avatar.meta.info.a[] aVarArr2;
        List filterNotNull;
        List filterNotNull2;
        Bitmap[] bitmapArr2;
        wv3.a aVar2 = aVar;
        if (continuation instanceof MetaAvatarLoadTask$getSourceBitmapArr$1) {
            metaAvatarLoadTask$getSourceBitmapArr$1 = (MetaAvatarLoadTask$getSourceBitmapArr$1) continuation;
            int i17 = metaAvatarLoadTask$getSourceBitmapArr$1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                metaAvatarLoadTask$getSourceBitmapArr$1.label = i17 - Integer.MIN_VALUE;
                MetaAvatarLoadTask$getSourceBitmapArr$1 metaAvatarLoadTask$getSourceBitmapArr$12 = metaAvatarLoadTask$getSourceBitmapArr$1;
                Object obj = metaAvatarLoadTask$getSourceBitmapArr$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = metaAvatarLoadTask$getSourceBitmapArr$12.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        Bitmap[] bitmapArr3 = (Bitmap[]) metaAvatarLoadTask$getSourceBitmapArr$12.L$3;
                        aVarArr2 = (com.tencent.qqnt.avatar.meta.info.a[]) metaAvatarLoadTask$getSourceBitmapArr$12.L$2;
                        wv3.a aVar3 = (wv3.a) metaAvatarLoadTask$getSourceBitmapArr$12.L$1;
                        metaAvatarLoadTask = (MetaAvatarLoadTask) metaAvatarLoadTask$getSourceBitmapArr$12.L$0;
                        ResultKt.throwOnFailure(obj);
                        bitmapArr = bitmapArr3;
                        aVar2 = aVar3;
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(this.avatarBean.e(), 0);
                    int length = aVarArr.length;
                    Bitmap[] bitmapArr4 = new Bitmap[length];
                    ArrayList arrayList = new ArrayList();
                    int length2 = aVarArr.length;
                    for (int i18 = 0; i18 < length2; i18++) {
                        com.tencent.qqnt.avatar.meta.info.a aVar4 = aVarArr[i18];
                        Bitmap f16 = AvatarResourceManager.f352954a.f(aVar4, context, coerceAtLeast);
                        if (f16 != null) {
                            bitmapArr4[i18] = f16;
                        } else {
                            arrayList.add(new IndexedValue(i18, aVar4));
                        }
                    }
                    if (arrayList.isEmpty()) {
                        this.taskTracker.b("getSourceBitmapFromDisk end. size[" + length + "]");
                        filterNotNull = ArraysKt___ArraysKt.filterNotNull(bitmapArr4);
                        Object[] array = filterNotNull.toArray(new Bitmap[0]);
                        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                        return array;
                    }
                    if (aVar2 != null) {
                        i16 = 1;
                        a.C11512a.a(aVar2, null, 1, null);
                    } else {
                        i16 = 1;
                    }
                    MetaAvatarLoadTask$getSourceBitmapArr$2 metaAvatarLoadTask$getSourceBitmapArr$2 = new MetaAvatarLoadTask$getSourceBitmapArr$2(arrayList, aVarArr, bitmapArr4, context, coerceAtLeast, null);
                    metaAvatarLoadTask$getSourceBitmapArr$12.L$0 = this;
                    metaAvatarLoadTask$getSourceBitmapArr$12.L$1 = aVar2;
                    metaAvatarLoadTask$getSourceBitmapArr$12.L$2 = aVarArr;
                    bitmapArr = bitmapArr4;
                    metaAvatarLoadTask$getSourceBitmapArr$12.L$3 = bitmapArr;
                    metaAvatarLoadTask$getSourceBitmapArr$12.label = i16;
                    if (CoroutineScopeKt.coroutineScope(metaAvatarLoadTask$getSourceBitmapArr$2, metaAvatarLoadTask$getSourceBitmapArr$12) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    metaAvatarLoadTask = this;
                    aVarArr2 = aVarArr;
                }
                if (aVar2 != null) {
                    aVar2.a(metaAvatarLoadTask.a());
                }
                filterNotNull2 = ArraysKt___ArraysKt.filterNotNull(bitmapArr);
                Object[] array2 = filterNotNull2.toArray(new Bitmap[0]);
                Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                bitmapArr2 = (Bitmap[]) array2;
                metaAvatarLoadTask.taskTracker.b("getSourceBitmapFromNet end. size[" + bitmapArr2.length + "]");
                if (bitmapArr2.length == aVarArr2.length) {
                    d.d(d.f352991a, "MetaAvatarLoadTask", "getBitmapArr fail", null, 4, null);
                    return null;
                }
                return bitmapArr2;
            }
        }
        metaAvatarLoadTask$getSourceBitmapArr$1 = new MetaAvatarLoadTask$getSourceBitmapArr$1(this, continuation);
        MetaAvatarLoadTask$getSourceBitmapArr$1 metaAvatarLoadTask$getSourceBitmapArr$122 = metaAvatarLoadTask$getSourceBitmapArr$1;
        Object obj2 = metaAvatarLoadTask$getSourceBitmapArr$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = metaAvatarLoadTask$getSourceBitmapArr$122.label;
        if (i3 == 0) {
        }
        if (aVar2 != null) {
        }
        filterNotNull2 = ArraysKt___ArraysKt.filterNotNull(bitmapArr);
        Object[] array22 = filterNotNull2.toArray(new Bitmap[0]);
        Intrinsics.checkNotNull(array22, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        bitmapArr2 = (Bitmap[]) array22;
        metaAvatarLoadTask.taskTracker.b("getSourceBitmapFromNet end. size[" + bitmapArr2.length + "]");
        if (bitmapArr2.length == aVarArr2.length) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.avatar.meta.task.a
    public void b(@Nullable com.tencent.qqnt.avatar.meta.task.b result) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) result);
            return;
        }
        if (result != null && result.b() && (result.a() instanceof com.tencent.qqnt.avatar.layer.a)) {
            this.loadRequest.c().onLoadFinish(result.a());
            return;
        }
        com.tencent.qqnt.avatar.meta.request.a<com.tencent.qqnt.avatar.layer.a> c16 = this.loadRequest.c();
        String str = null;
        if (result != null) {
            obj = result.a();
        } else {
            obj = null;
        }
        if (obj instanceof String) {
            str = (String) obj;
        }
        c16.onFail(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0068  */
    @Override // com.tencent.qqnt.avatar.meta.task.a
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object c(@Nullable wv3.a aVar, @NotNull Continuation<? super com.tencent.qqnt.avatar.meta.task.b> continuation) {
        MetaAvatarLoadTask$start$1 metaAvatarLoadTask$start$1;
        Object coroutine_suspended;
        int i3;
        MetaAvatarLoadTask metaAvatarLoadTask;
        com.tencent.qqnt.avatar.meta.info.a[] aVarArr;
        boolean z16;
        Context context;
        com.tencent.qqnt.avatar.meta.info.a[] aVarArr2;
        MetaAvatarLoadTask metaAvatarLoadTask2;
        String str;
        Bitmap[] bitmapArr;
        boolean z17;
        com.tencent.qqnt.avatar.layer.c cVar;
        wv3.a aVar2 = aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar2, (Object) continuation);
        }
        if (continuation instanceof MetaAvatarLoadTask$start$1) {
            metaAvatarLoadTask$start$1 = (MetaAvatarLoadTask$start$1) continuation;
            int i16 = metaAvatarLoadTask$start$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                metaAvatarLoadTask$start$1.label = i16 - Integer.MIN_VALUE;
                Object obj = metaAvatarLoadTask$start$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = metaAvatarLoadTask$start$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            str = (String) metaAvatarLoadTask$start$1.L$2;
                            aVarArr2 = (com.tencent.qqnt.avatar.meta.info.a[]) metaAvatarLoadTask$start$1.L$1;
                            metaAvatarLoadTask2 = (MetaAvatarLoadTask) metaAvatarLoadTask$start$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            bitmapArr = (Bitmap[]) obj;
                            if (bitmapArr != null) {
                                if (bitmapArr.length == 0) {
                                    z17 = true;
                                } else {
                                    z17 = false;
                                }
                                if (!z17) {
                                    com.tencent.qqnt.avatar.meta.transform.a aVar3 = com.tencent.qqnt.avatar.meta.transform.a.f352982a;
                                    Bitmap b16 = aVar3.b(metaAvatarLoadTask2.avatarBean, aVarArr2, bitmapArr);
                                    if (b16 != null) {
                                        cVar = aVar3.c(metaAvatarLoadTask2.avatarBean, aVarArr2, b16);
                                    } else {
                                        cVar = null;
                                    }
                                    metaAvatarLoadTask2.taskTracker.b("transform end finalBitmap: " + b16 + " drawConfig:" + cVar);
                                    if (b16 != null) {
                                        d.a.a(metaAvatarLoadTask2.diskCache, str, b16, false, 4, null);
                                    }
                                    metaAvatarLoadTask2.taskTracker.b("putToDiskCache end");
                                    if (b16 == null) {
                                        b16 = bitmapArr[0];
                                    }
                                    com.tencent.qqnt.avatar.layer.a aVar4 = new com.tencent.qqnt.avatar.layer.a(metaAvatarLoadTask2.avatarBean, b16, cVar, aVarArr2);
                                    metaAvatarLoadTask2.memoryCache.a(str, aVar4, metaAvatarLoadTask2.avatarBean.m());
                                    TaskTracker.d(metaAvatarLoadTask2.taskTracker, true, null, 2, null);
                                    return new com.tencent.qqnt.avatar.meta.task.b(true, aVar4);
                                }
                            }
                            TaskTracker.d(metaAvatarLoadTask2.taskTracker, false, null, 2, null);
                            return new com.tencent.qqnt.avatar.meta.task.b(false, "[" + metaAvatarLoadTask2.avatarBean.d() + "] downloadResource return null");
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    aVar2 = (wv3.a) metaAvatarLoadTask$start$1.L$1;
                    metaAvatarLoadTask = (MetaAvatarLoadTask) metaAvatarLoadTask$start$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    this.taskTracker.b("start");
                    metaAvatarLoadTask$start$1.L$0 = this;
                    metaAvatarLoadTask$start$1.L$1 = aVar2;
                    metaAvatarLoadTask$start$1.label = 1;
                    obj = f(aVar2, metaAvatarLoadTask$start$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    metaAvatarLoadTask = this;
                }
                aVarArr = (com.tencent.qqnt.avatar.meta.info.a[]) obj;
                if (aVarArr != null) {
                    if (aVarArr.length == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        String a16 = MetaCacheKeyGenerator.f352879a.a(metaAvatarLoadTask.avatarBean, aVarArr);
                        com.tencent.qqnt.avatar.layer.a c16 = metaAvatarLoadTask.memoryCache.c(a16);
                        metaAvatarLoadTask.taskTracker.b("getFromMemoryCache end: " + c16);
                        if (c16 != null) {
                            TaskTracker.d(metaAvatarLoadTask.taskTracker, true, null, 2, null);
                            return new com.tencent.qqnt.avatar.meta.task.b(true, c16);
                        }
                        Bitmap e16 = metaAvatarLoadTask.diskCache.e(a16);
                        metaAvatarLoadTask.taskTracker.b("getFromDiskCache end: " + e16);
                        if (e16 != null) {
                            com.tencent.qqnt.avatar.layer.a aVar5 = new com.tencent.qqnt.avatar.layer.a(metaAvatarLoadTask.avatarBean, e16, com.tencent.qqnt.avatar.meta.transform.a.f352982a.c(metaAvatarLoadTask.avatarBean, aVarArr, e16), aVarArr);
                            metaAvatarLoadTask.memoryCache.a(a16, aVar5, metaAvatarLoadTask.avatarBean.m());
                            TaskTracker.d(metaAvatarLoadTask.taskTracker, true, null, 2, null);
                            return new com.tencent.qqnt.avatar.meta.task.b(true, aVar5);
                        }
                        Context b17 = metaAvatarLoadTask.loadRequest.b();
                        if (b17 != null) {
                            context = b17.getApplicationContext();
                        } else {
                            context = null;
                        }
                        if (context == null) {
                            metaAvatarLoadTask.taskTracker.b("getContext return null");
                            TaskTracker.d(metaAvatarLoadTask.taskTracker, false, null, 2, null);
                            return new com.tencent.qqnt.avatar.meta.task.b(false, "[" + metaAvatarLoadTask.avatarBean.d() + "] getContext return null");
                        }
                        metaAvatarLoadTask$start$1.L$0 = metaAvatarLoadTask;
                        metaAvatarLoadTask$start$1.L$1 = aVarArr;
                        metaAvatarLoadTask$start$1.L$2 = a16;
                        metaAvatarLoadTask$start$1.label = 2;
                        Object g16 = metaAvatarLoadTask.g(aVar2, context, aVarArr, metaAvatarLoadTask$start$1);
                        if (g16 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        aVarArr2 = aVarArr;
                        metaAvatarLoadTask2 = metaAvatarLoadTask;
                        obj = g16;
                        str = a16;
                        bitmapArr = (Bitmap[]) obj;
                        if (bitmapArr != null) {
                        }
                        TaskTracker.d(metaAvatarLoadTask2.taskTracker, false, null, 2, null);
                        return new com.tencent.qqnt.avatar.meta.task.b(false, "[" + metaAvatarLoadTask2.avatarBean.d() + "] downloadResource return null");
                    }
                }
                String str2 = "[" + metaAvatarLoadTask.avatarBean.d() + "] getAvatarInfo return null";
                metaAvatarLoadTask.taskTracker.b(str2);
                TaskTracker.d(metaAvatarLoadTask.taskTracker, false, null, 2, null);
                return new com.tencent.qqnt.avatar.meta.task.b(false, str2);
            }
        }
        metaAvatarLoadTask$start$1 = new MetaAvatarLoadTask$start$1(this, continuation);
        Object obj2 = metaAvatarLoadTask$start$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = metaAvatarLoadTask$start$1.label;
        if (i3 == 0) {
        }
        aVarArr = (com.tencent.qqnt.avatar.meta.info.a[]) obj2;
        if (aVarArr != null) {
        }
        String str22 = "[" + metaAvatarLoadTask.avatarBean.d() + "] getAvatarInfo return null";
        metaAvatarLoadTask.taskTracker.b(str22);
        TaskTracker.d(metaAvatarLoadTask.taskTracker, false, null, 2, null);
        return new com.tencent.qqnt.avatar.meta.task.b(false, str22);
    }
}
