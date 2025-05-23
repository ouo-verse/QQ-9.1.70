package com.tencent.mobileqq.wink.lowthresholdltemplate;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.editor.export.WinkExportUtils;
import com.tencent.mobileqq.wink.listener.ResDownLoadListener;
import com.tencent.mobileqq.wink.lowthresholdltemplate.WinkTemplateShareRepo;
import com.tencent.mobileqq.wink.lowthresholdltemplate.p;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.components.Size;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b)\u0010*J#\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J#\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\u0006J\u001b\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ\"\u0010\u0012\u001a\u0004\u0018\u00010\f2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0013\u0010\u0014\u001a\u00020\u0013H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\nH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u000eJ/\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00170\u00192\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0017H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001bJ-\u0010\"\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\"\u0010#R\u001b\u0010(\u001a\u00020$8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010%\u001a\u0004\b&\u0010'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/wink/lowthresholdltemplate/WinkTemplateShareRepo;", "Lcom/tencent/mobileqq/wink/lowthresholdltemplate/r;", "", "url", "savePath", tl.h.F, "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "oldPath", "newPath", "g", "Lcom/tencent/mobileqq/wink/lowthresholdltemplate/p$c;", "templateConfig", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "j", "(Lcom/tencent/mobileqq/wink/lowthresholdltemplate/p$c;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "data", "i", "", "d", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "b", "", "qzoneFrom", "Lkotlin/Pair;", "a", "(Lcom/tencent/mobileqq/wink/lowthresholdltemplate/p$c;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/tavcut/core/session/ICutSession;", SessionDbHelper.SESSION_ID, "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "editDataWrapper", "", "coverTimeUs", "c", "(Lcom/tencent/tavcut/core/session/ICutSession;Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/transfile/api/IHttpEngineService;", "Lkotlin/Lazy;", "k", "()Lcom/tencent/mobileqq/transfile/api/IHttpEngineService;", "netEngine", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkTemplateShareRepo implements r {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WinkTemplateShareRepo f323423a = new WinkTemplateShareRepo();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy netEngine;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/wink/lowthresholdltemplate/WinkTemplateShareRepo$a", "Lcom/tencent/mobileqq/transfile/INetEngineListener;", "Lcom/tencent/mobileqq/transfile/NetResp;", "resp", "", "onResp", "Lcom/tencent/mobileqq/transfile/NetReq;", "req", "", "curOffset", "totalLen", "onUpdateProgeress", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements INetEngineListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<String> f323425d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f323426e;

        /* JADX WARN: Multi-variable type inference failed */
        a(CancellableContinuation<? super String> cancellableContinuation, String str) {
            this.f323425d = cancellableContinuation;
            this.f323426e = str;
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(@Nullable NetResp resp) {
            boolean z16;
            if (resp == null) {
                CancellableContinuation<String> cancellableContinuation = this.f323425d;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new IllegalStateException("download image null resp"))));
                return;
            }
            if (resp.mResult == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            w53.b.a("WinkTemplateShareDataSource", "download onResp: " + z16);
            if (z16) {
                CancellableContinuation<String> cancellableContinuation2 = this.f323425d;
                Result.Companion companion2 = Result.INSTANCE;
                cancellableContinuation2.resumeWith(Result.m476constructorimpl(this.f323426e));
                return;
            }
            CancellableContinuation<String> cancellableContinuation3 = this.f323425d;
            Result.Companion companion3 = Result.INSTANCE;
            cancellableContinuation3.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new IllegalStateException("download image fail " + resp.mErrCode + " " + resp.mHttpCode))));
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(@NotNull NetReq req, long curOffset, long totalLen) {
            Intrinsics.checkNotNullParameter(req, "req");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/lowthresholdltemplate/WinkTemplateShareRepo$b", "Lcom/tencent/mobileqq/wink/listener/ResDownLoadListener;", "", "isSuccess", "", "onDownloadFinish", "", "progress", "onProgressUpdate", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements ResDownLoadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MetaMaterial f323427a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Continuation<Pair<MetaMaterial, Boolean>> f323428b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Ref.BooleanRef f323429c;

        /* JADX WARN: Multi-variable type inference failed */
        b(MetaMaterial metaMaterial, Continuation<? super Pair<MetaMaterial, Boolean>> continuation, Ref.BooleanRef booleanRef) {
            this.f323427a = metaMaterial;
            this.f323428b = continuation;
            this.f323429c = booleanRef;
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onDownloadFinish(boolean isSuccess) {
            w53.b.f("WinkTemplateShareDataSource", "downloadMaterial " + this.f323427a.f30533id + " finish: " + isSuccess);
            if (isSuccess) {
                Continuation<Pair<MetaMaterial, Boolean>> continuation = this.f323428b;
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m476constructorimpl(new Pair(this.f323427a, Boolean.valueOf(this.f323429c.element))));
            } else {
                Continuation<Pair<MetaMaterial, Boolean>> continuation2 = this.f323428b;
                Result.Companion companion2 = Result.INSTANCE;
                continuation2.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new IllegalStateException("download mate fail"))));
            }
        }

        @Override // com.tencent.mobileqq.wink.listener.ResDownLoadListener
        public void onProgressUpdate(int progress) {
            w53.b.a("WinkTemplateShareDataSource", "downloadMaterial: " + progress);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/lowthresholdltemplate/WinkTemplateShareRepo$c", "Landroidx/lifecycle/Observer;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "t", "", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements Observer<List<? extends MetaCategory>> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ p.TemplateConfig f323430d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<MetaMaterial> f323431e;

        /* JADX WARN: Multi-variable type inference failed */
        c(p.TemplateConfig templateConfig, CancellableContinuation<? super MetaMaterial> cancellableContinuation) {
            this.f323430d = templateConfig;
            this.f323431e = cancellableContinuation;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(@Nullable List<MetaCategory> t16) {
            MetaMaterial i3 = WinkTemplateShareRepo.f323423a.i(t16, this.f323430d);
            if (i3 == null) {
                w53.b.g("WinkTemplateShareDataSource", "empty metaCategory");
            } else {
                this.f323431e.resumeWith(Result.m476constructorimpl(i3));
                WinkEditorResourceManager.a1().e1().removeObserver(this);
            }
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IHttpEngineService>() { // from class: com.tencent.mobileqq.wink.lowthresholdltemplate.WinkTemplateShareRepo$netEngine$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IHttpEngineService invoke() {
                IRuntimeService runtimeService = com.tencent.mobileqq.wink.b.a().getRuntimeService(IHttpEngineService.class, "all");
                Intrinsics.checkNotNullExpressionValue(runtimeService, "getAppInterface()\n      \u2026ava, ProcessConstant.ALL)");
                return (IHttpEngineService) runtimeService;
            }
        });
        netEngine = lazy;
    }

    WinkTemplateShareRepo() {
    }

    private final Object g(String str, String str2, Continuation<? super String> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        try {
            if (Intrinsics.areEqual(new File(str).getParent(), new File(str2).getParent())) {
                safeContinuation.resumeWith(Result.m476constructorimpl(str));
            } else {
                FileUtils.copyFile(str, str2);
                safeContinuation.resumeWith(Result.m476constructorimpl(str2));
            }
        } catch (Exception e16) {
            Result.Companion companion = Result.INSTANCE;
            safeContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(e16)));
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    private final Object h(String str, String str2, Continuation<? super String> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        try {
            Uri.parse(str);
            final HttpNetReq httpNetReq = new HttpNetReq();
            httpNetReq.mReqUrl = str;
            httpNetReq.mHttpMethod = 0;
            httpNetReq.mExcuteTimeLimit = 20000L;
            httpNetReq.mOutPath = str2;
            httpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
            httpNetReq.mCallback = new a(cancellableContinuationImpl, str2);
            cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.wink.lowthresholdltemplate.WinkTemplateShareRepo$downloadImage$2$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                    invoke2(th5);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Throwable th5) {
                    WinkTemplateShareRepo.f323423a.k().cancelReq(HttpNetReq.this);
                }
            });
            f323423a.k().sendReq(httpNetReq);
        } catch (Throwable th5) {
            w53.b.d("WinkTemplateShareDataSource", "download result: " + th5, th5);
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(th5)));
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0054, code lost:
    
        if (r4 == null) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final MetaMaterial i(List<MetaCategory> data, p.TemplateConfig templateConfig) {
        boolean z16;
        boolean equals$default;
        Object orNull;
        MetaCategory metaCategory;
        ArrayList<MetaMaterial> materials;
        Object obj;
        List<MetaCategory> list = data;
        boolean z17 = true;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        Object obj2 = null;
        if (!z16) {
            equals$default = StringsKt__StringsJVMKt.equals$default(templateConfig.getCategoryId(), data.get(0).f30532id, false, 2, null);
            if (equals$default) {
                ArrayList<MetaCategory> arrayList = data.get(0).subCategories;
                if (arrayList != null) {
                    Iterator<T> it = arrayList.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj = it.next();
                            if (Intrinsics.areEqual(((MetaCategory) obj).f30532id, templateConfig.getSubCategoryId())) {
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    metaCategory = (MetaCategory) obj;
                }
                ArrayList<MetaCategory> arrayList2 = data.get(0).subCategories;
                Intrinsics.checkNotNullExpressionValue(arrayList2, "data[0].subCategories");
                orNull = CollectionsKt___CollectionsKt.getOrNull(arrayList2, 0);
                metaCategory = (MetaCategory) orNull;
                if (metaCategory == null || (materials = metaCategory.materials) == null) {
                    materials = data.get(0).materials;
                }
                if (materials != null && !materials.isEmpty()) {
                    z17 = false;
                }
                if (z17) {
                    return null;
                }
                Intrinsics.checkNotNullExpressionValue(materials, "materials");
                Iterator<T> it5 = materials.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    }
                    Object next = it5.next();
                    if (Intrinsics.areEqual(((MetaMaterial) next).f30533id, templateConfig.getTemplateId())) {
                        obj2 = next;
                        break;
                    }
                }
                MetaMaterial metaMaterial = (MetaMaterial) obj2;
                if (metaMaterial == null) {
                    return (MetaMaterial) (templateConfig.getIsRandomTemplate() ? CollectionsKt___CollectionsKt.getOrNull(materials, com.tencent.av.doodle.e.f73628c.nextInt(materials.size())) : CollectionsKt___CollectionsKt.getOrNull(materials, 0));
                }
                return metaMaterial;
            }
        }
        w53.b.a("WinkTemplateShareDataSource", "no match or null");
        return null;
    }

    private final Object j(p.TemplateConfig templateConfig, Continuation<? super MetaMaterial> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        QRouteApi api = QRoute.api(IWinkEditorResourceAPI.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IWinkEditorResourceAPI::class.java)");
        ((IWinkEditorResourceAPI) api).fetchEditorResource();
        final c cVar = new c(templateConfig, cancellableContinuationImpl);
        WinkEditorResourceManager.a1().X2(templateConfig.getCategoryId());
        WinkEditorResourceManager.a1().e1().observeForever(cVar);
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.wink.lowthresholdltemplate.WinkTemplateShareRepo$getMaterial$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                WinkEditorResourceManager.a1().e1().removeObserver(WinkTemplateShareRepo.c.this);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IHttpEngineService k() {
        return (IHttpEngineService) netEngine.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00a8 A[PHI: r9
  0x00a8: PHI (r9v6 java.lang.Object) = (r9v5 java.lang.Object), (r9v1 java.lang.Object) binds: [B:19:0x00a5, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.tencent.mobileqq.wink.lowthresholdltemplate.r
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(@NotNull p.TemplateConfig templateConfig, boolean z16, @NotNull Continuation<? super Pair<MetaMaterial, Boolean>> continuation) {
        WinkTemplateShareRepo$downloadMaterial$1 winkTemplateShareRepo$downloadMaterial$1;
        Object obj;
        Object coroutine_suspended;
        int i3;
        Continuation intercepted;
        Object coroutine_suspended2;
        if (continuation instanceof WinkTemplateShareRepo$downloadMaterial$1) {
            winkTemplateShareRepo$downloadMaterial$1 = (WinkTemplateShareRepo$downloadMaterial$1) continuation;
            int i16 = winkTemplateShareRepo$downloadMaterial$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                winkTemplateShareRepo$downloadMaterial$1.label = i16 - Integer.MIN_VALUE;
                obj = winkTemplateShareRepo$downloadMaterial$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = winkTemplateShareRepo$downloadMaterial$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    winkTemplateShareRepo$downloadMaterial$1.label = 1;
                    obj = j(templateConfig, winkTemplateShareRepo$downloadMaterial$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                MetaMaterial metaMaterial = (MetaMaterial) obj;
                winkTemplateShareRepo$downloadMaterial$1.L$0 = metaMaterial;
                winkTemplateShareRepo$downloadMaterial$1.label = 2;
                intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(winkTemplateShareRepo$downloadMaterial$1);
                SafeContinuation safeContinuation = new SafeContinuation(intercepted);
                Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                boolean z17 = !WinkEditorResourceManager.a1().s(metaMaterial);
                booleanRef.element = z17;
                String str = metaMaterial.f30533id;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("downloadMaterial ");
                sb5.append(str);
                sb5.append(" exist: ");
                sb5.append(!z17);
                w53.b.f("WinkTemplateShareDataSource", sb5.toString());
                WinkEditorResourceManager.a1().f0(metaMaterial, new b(metaMaterial, safeContinuation, booleanRef));
                obj = safeContinuation.getOrThrow();
                coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (obj == coroutine_suspended2) {
                    DebugProbes.probeCoroutineSuspended(winkTemplateShareRepo$downloadMaterial$1);
                }
                if (obj != coroutine_suspended) {
                    return coroutine_suspended;
                }
                return obj;
            }
        }
        winkTemplateShareRepo$downloadMaterial$1 = new WinkTemplateShareRepo$downloadMaterial$1(this, continuation);
        obj = winkTemplateShareRepo$downloadMaterial$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = winkTemplateShareRepo$downloadMaterial$1.label;
        if (i3 == 0) {
        }
        MetaMaterial metaMaterial2 = (MetaMaterial) obj;
        winkTemplateShareRepo$downloadMaterial$1.L$0 = metaMaterial2;
        winkTemplateShareRepo$downloadMaterial$1.label = 2;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(winkTemplateShareRepo$downloadMaterial$1);
        SafeContinuation safeContinuation2 = new SafeContinuation(intercepted);
        Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        boolean z172 = !WinkEditorResourceManager.a1().s(metaMaterial2);
        booleanRef2.element = z172;
        String str2 = metaMaterial2.f30533id;
        StringBuilder sb52 = new StringBuilder();
        sb52.append("downloadMaterial ");
        sb52.append(str2);
        sb52.append(" exist: ");
        sb52.append(!z172);
        w53.b.f("WinkTemplateShareDataSource", sb52.toString());
        WinkEditorResourceManager.a1().f0(metaMaterial2, new b(metaMaterial2, safeContinuation2, booleanRef2));
        obj = safeContinuation2.getOrThrow();
        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (obj == coroutine_suspended2) {
        }
        if (obj != coroutine_suspended) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x00c2 -> B:12:0x011b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0118 -> B:11:0x0119). Please report as a decompilation issue!!! */
    @Override // com.tencent.mobileqq.wink.lowthresholdltemplate.r
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object b(@NotNull p.TemplateConfig templateConfig, @NotNull Continuation<? super List<String>> continuation) {
        WinkTemplateShareRepo$downloadAndCopyMedias$1 winkTemplateShareRepo$downloadAndCopyMedias$1;
        Object coroutine_suspended;
        int i3;
        int collectionSizeOrDefault;
        Iterator it;
        Collection collection;
        boolean isBlank;
        boolean startsWith$default;
        Collection collection2;
        String str;
        if (continuation instanceof WinkTemplateShareRepo$downloadAndCopyMedias$1) {
            winkTemplateShareRepo$downloadAndCopyMedias$1 = (WinkTemplateShareRepo$downloadAndCopyMedias$1) continuation;
            int i16 = winkTemplateShareRepo$downloadAndCopyMedias$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                winkTemplateShareRepo$downloadAndCopyMedias$1.label = i16 - Integer.MIN_VALUE;
                Object obj = winkTemplateShareRepo$downloadAndCopyMedias$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = winkTemplateShareRepo$downloadAndCopyMedias$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            collection = (Collection) winkTemplateShareRepo$downloadAndCopyMedias$1.L$2;
                            it = (Iterator) winkTemplateShareRepo$downloadAndCopyMedias$1.L$1;
                            collection2 = (Collection) winkTemplateShareRepo$downloadAndCopyMedias$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            str = (String) obj;
                            collection.add(str);
                            collection = collection2;
                            if (!it.hasNext()) {
                                Pair pair = (Pair) it.next();
                                isBlank = StringsKt__StringsJVMKt.isBlank((CharSequence) pair.getFirst());
                                if (!isBlank) {
                                    w53.b.f("WinkTemplateShareDataSource", "download image: " + pair.getFirst() + ", " + pair.getSecond());
                                    if (!new File((String) pair.getSecond()).exists()) {
                                        startsWith$default = StringsKt__StringsJVMKt.startsWith$default((String) pair.getFirst(), "http", false, 2, null);
                                        if (startsWith$default) {
                                            WinkTemplateShareRepo winkTemplateShareRepo = f323423a;
                                            String str2 = (String) pair.getFirst();
                                            String str3 = (String) pair.getSecond();
                                            winkTemplateShareRepo$downloadAndCopyMedias$1.L$0 = collection;
                                            winkTemplateShareRepo$downloadAndCopyMedias$1.L$1 = it;
                                            winkTemplateShareRepo$downloadAndCopyMedias$1.L$2 = collection;
                                            winkTemplateShareRepo$downloadAndCopyMedias$1.label = 1;
                                            Object h16 = winkTemplateShareRepo.h(str2, str3, winkTemplateShareRepo$downloadAndCopyMedias$1);
                                            if (h16 == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            collection2 = collection;
                                            str = (String) h16;
                                        } else {
                                            WinkTemplateShareRepo winkTemplateShareRepo2 = f323423a;
                                            String str4 = (String) pair.getFirst();
                                            String str5 = (String) pair.getSecond();
                                            winkTemplateShareRepo$downloadAndCopyMedias$1.L$0 = collection;
                                            winkTemplateShareRepo$downloadAndCopyMedias$1.L$1 = it;
                                            winkTemplateShareRepo$downloadAndCopyMedias$1.L$2 = collection;
                                            winkTemplateShareRepo$downloadAndCopyMedias$1.label = 2;
                                            obj = winkTemplateShareRepo2.g(str4, str5, winkTemplateShareRepo$downloadAndCopyMedias$1);
                                            if (obj == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            collection2 = collection;
                                            str = (String) obj;
                                        }
                                    } else {
                                        str = (String) pair.getSecond();
                                        collection2 = collection;
                                    }
                                    collection.add(str);
                                    collection = collection2;
                                    if (!it.hasNext()) {
                                        return (List) collection;
                                    }
                                } else {
                                    throw new IllegalArgumentException("invalid media path");
                                }
                            }
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        collection = (Collection) winkTemplateShareRepo$downloadAndCopyMedias$1.L$2;
                        it = (Iterator) winkTemplateShareRepo$downloadAndCopyMedias$1.L$1;
                        collection2 = (Collection) winkTemplateShareRepo$downloadAndCopyMedias$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        str = (String) obj;
                        collection.add(str);
                        collection = collection2;
                        if (!it.hasNext()) {
                        }
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    List<Pair<String, String>> c16 = templateConfig.c();
                    if (c16 == null) {
                        return null;
                    }
                    List<Pair<String, String>> list = c16;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    it = list.iterator();
                    collection = arrayList;
                    if (!it.hasNext()) {
                    }
                }
            }
        }
        winkTemplateShareRepo$downloadAndCopyMedias$1 = new WinkTemplateShareRepo$downloadAndCopyMedias$1(this, continuation);
        Object obj2 = winkTemplateShareRepo$downloadAndCopyMedias$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = winkTemplateShareRepo$downloadAndCopyMedias$1.label;
        if (i3 == 0) {
        }
    }

    @Override // com.tencent.mobileqq.wink.lowthresholdltemplate.r
    @Nullable
    public Object c(@NotNull ICutSession iCutSession, @NotNull WinkEditDataWrapper winkEditDataWrapper, long j3, @NotNull Continuation<? super String> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        Bitmap c16 = com.tencent.mobileqq.wink.editor.cover.b.c(com.tencent.mobileqq.wink.editor.cover.b.f319709a, iCutSession, j3 / 1000, new Size(1080, 1920), com.tencent.mobileqq.wink.editor.draft.c.r(winkEditDataWrapper), null, null, 32, null);
        String str = null;
        if (c16 == null) {
            safeContinuation.resumeWith(Result.m476constructorimpl(null));
        } else {
            String str2 = u53.b.f438374e;
            String str3 = str2 + "/video_cover_" + System.currentTimeMillis() + ".jpg";
            File file = new File(str2);
            if (!file.exists()) {
                file.mkdirs();
            }
            boolean saveBitmapToFile = FileUtils.saveBitmapToFile(c16, str3);
            Result.Companion companion = Result.INSTANCE;
            if (saveBitmapToFile) {
                str = str3;
            }
            safeContinuation.resumeWith(Result.m476constructorimpl(str));
        }
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @Override // com.tencent.mobileqq.wink.lowthresholdltemplate.r
    @Nullable
    public Object d(@NotNull Continuation<? super Unit> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        Object coroutine_suspended2;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        SafeContinuation safeContinuation = new SafeContinuation(intercepted);
        w53.b.a("WinkTemplateShareDataSource", "loadLightAssets");
        WinkExportUtils.R();
        Result.Companion companion = Result.INSTANCE;
        Unit unit = Unit.INSTANCE;
        safeContinuation.resumeWith(Result.m476constructorimpl(unit));
        Object orThrow = safeContinuation.getOrThrow();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (orThrow == coroutine_suspended2) {
            return orThrow;
        }
        return unit;
    }
}
