package com.tencent.mobileqq.wink.editor.sticker.sticker.p008new;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.wink.editor.WinkMaterialViewModel;
import com.tencent.mobileqq.wink.editor.model.b;
import com.tencent.mobileqq.wink.editor.sticker.m;
import com.tencent.mobileqq.wink.request.QQWinkStickerSearchRequest;
import java.io.File;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt___StringsKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qshadow.ShadowStickerSearch$CircleEditFirstSearchRsp;
import u53.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0013\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0018\u0010\u0019J \u0010\u0006\u001a\u00020\u00042\u0016\u0010\u0005\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\t\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0012R\u001b\u0010\u0017\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/StickerMenuDataSourceImpl;", "Lcom/tencent/mobileqq/wink/editor/sticker/sticker/new/b;", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/wink/editor/model/b;", "", "callback", "b", "a", "", "keyword", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "c", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/wink/editor/WinkMaterialViewModel;", "Lcom/tencent/mobileqq/wink/editor/WinkMaterialViewModel;", "materialViewModel", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lkotlin/Lazy;", "f", "()Ljava/lang/String;", "qqExpressDownloadDir", "<init>", "(Lcom/tencent/mobileqq/wink/editor/WinkMaterialViewModel;Landroidx/lifecycle/LifecycleOwner;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class StickerMenuDataSourceImpl implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final WinkMaterialViewModel materialViewModel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner lifecycleOwner;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy qqExpressDownloadDir;

    public StickerMenuDataSourceImpl(@NotNull WinkMaterialViewModel materialViewModel, @NotNull LifecycleOwner lifecycleOwner) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(materialViewModel, "materialViewModel");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.materialViewModel = materialViewModel;
        this.lifecycleOwner = lifecycleOwner;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.StickerMenuDataSourceImpl$qqExpressDownloadDir$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                String str = e.f438384a + File.separator + "sticker_qqExpress";
                File file = new File(str);
                if (!file.exists()) {
                    file.mkdirs();
                }
                return str;
            }
        });
        this.qqExpressDownloadDir = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String f() {
        return (String) this.qqExpressDownloadDir.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.mobileqq.wink.editor.sticker.sticker.p008new.b
    public void a() {
        this.materialViewModel.getStickerWithQQEmoticonMaterialVOLiveData().removeObservers(this.lifecycleOwner);
    }

    @Override // com.tencent.mobileqq.wink.editor.sticker.sticker.p008new.b
    public void b(@NotNull final Function1<? super b, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        LiveData<b> stickerWithQQEmoticonMaterialVOLiveData = this.materialViewModel.getStickerWithQQEmoticonMaterialVOLiveData();
        LifecycleOwner lifecycleOwner = this.lifecycleOwner;
        final Function1<b, Unit> function1 = new Function1<b, Unit>() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.StickerMenuDataSourceImpl$observeData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(b bVar) {
                w53.b.f("StickerMenuDataSource", "getData called");
                callback.invoke(bVar);
            }
        };
        stickerWithQQEmoticonMaterialVOLiveData.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                StickerMenuDataSourceImpl.g(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.wink.editor.sticker.sticker.p008new.b
    @Nullable
    public Object c(@NotNull String str, @NotNull Continuation<? super List<MetaCategory>> continuation) {
        Continuation intercepted;
        String take;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        w93.e eVar = w93.e.f445096a;
        take = StringsKt___StringsKt.take(str, 120);
        final int j3 = eVar.j(new QQWinkStickerSearchRequest(take), new Function5<BaseRequest, Boolean, Long, String, ShadowStickerSearch$CircleEditFirstSearchRsp, Unit>() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.StickerMenuDataSourceImpl$search$2$seq$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(5);
            }

            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ Unit invoke(BaseRequest baseRequest, Boolean bool, Long l3, String str2, ShadowStickerSearch$CircleEditFirstSearchRsp shadowStickerSearch$CircleEditFirstSearchRsp) {
                invoke(baseRequest, bool.booleanValue(), l3.longValue(), str2, shadowStickerSearch$CircleEditFirstSearchRsp);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull BaseRequest baseRequest, boolean z16, long j16, @Nullable String str2, @Nullable ShadowStickerSearch$CircleEditFirstSearchRsp shadowStickerSearch$CircleEditFirstSearchRsp) {
                String f16;
                Intrinsics.checkNotNullParameter(baseRequest, "<anonymous parameter 0>");
                if (shadowStickerSearch$CircleEditFirstSearchRsp != null && j16 == 0 && z16) {
                    CancellableContinuation<List<MetaCategory>> cancellableContinuation = cancellableContinuationImpl;
                    Result.Companion companion = Result.INSTANCE;
                    f16 = this.f();
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(m.a(shadowStickerSearch$CircleEditFirstSearchRsp, f16)));
                    return;
                }
                CancellableContinuation<List<MetaCategory>> cancellableContinuation2 = cancellableContinuationImpl;
                Result.Companion companion2 = Result.INSTANCE;
                if (str2 == null) {
                    str2 = "";
                }
                cancellableContinuation2.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception(str2))));
            }
        });
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.wink.editor.sticker.sticker.new.StickerMenuDataSourceImpl$search$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                VSNetworkHelper.getInstance().cancelRequest(RFWApplication.getApplication(), j3);
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
