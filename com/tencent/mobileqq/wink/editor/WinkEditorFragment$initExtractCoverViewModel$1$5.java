package com.tencent.mobileqq.wink.editor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.editor.cover.WinkExtractCoverViewModel;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.editor.nextbtn.NextBtnPart;
import com.tencent.mobileqq.wink.event.WinkFinishActivityEvent;
import com.tencent.mobileqq.wink.publish.util.WinkDraftGenerator;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.editor.WinkEditorFragment$initExtractCoverViewModel$1$5", f = "WinkEditorFragment.kt", i = {}, l = {2358}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkEditorFragment$initExtractCoverViewModel$1$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WinkExtractCoverViewModel.c $it;
    int label;
    final /* synthetic */ WinkEditorFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.wink.editor.WinkEditorFragment$initExtractCoverViewModel$1$5$2", f = "WinkEditorFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.mobileqq.wink.editor.WinkEditorFragment$initExtractCoverViewModel$1$5$2, reason: invalid class name */
    /* loaded from: classes21.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ WinkExtractCoverViewModel.c $it;
        int label;
        final /* synthetic */ WinkEditorFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(WinkEditorFragment winkEditorFragment, WinkExtractCoverViewModel.c cVar, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = winkEditorFragment;
            this.$it = cVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, this.$it, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Intent intent;
            String kk5;
            Window window;
            Intent intent2;
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                w53.b.f("WinkEditorFragment", "run directQCirclePublish...");
                WinkEditorFragment winkEditorFragment = this.this$0;
                ArrayList<LocalMediaInfo> a16 = this.$it.a();
                WinkEditorFragment winkEditorFragment2 = this.this$0;
                FragmentActivity activity = winkEditorFragment2.getActivity();
                Bundle bundle = null;
                if (activity != null) {
                    intent = activity.getIntent();
                } else {
                    intent = null;
                }
                kk5 = winkEditorFragment2.kk(intent);
                FragmentActivity activity2 = this.this$0.getActivity();
                if (activity2 != null && (intent2 = activity2.getIntent()) != null) {
                    bundle = intent2.getExtras();
                }
                winkEditorFragment.Tj(a16, kk5, bundle);
                if (this.this$0.isAdded()) {
                    WinkEditorFragment winkEditorFragment3 = this.this$0;
                    winkEditorFragment3.startActivity(winkEditorFragment3.Tk().S2());
                    Activity hostActivity = this.this$0.getHostActivity();
                    if (hostActivity != null && (window = hostActivity.getWindow()) != null) {
                        window.setWindowAnimations(R.style.f2436019);
                    }
                    SimpleEventBus.getInstance().dispatchEvent(new WinkFinishActivityEvent(false, false, 0, null, 13, null), true);
                } else {
                    w53.b.c("WinkEditorFragment", "Fragment not attached to Activity");
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkEditorFragment$initExtractCoverViewModel$1$5(WinkEditorFragment winkEditorFragment, WinkExtractCoverViewModel.c cVar, Continuation<? super WinkEditorFragment$initExtractCoverViewModel$1$5> continuation) {
        super(2, continuation);
        this.this$0 = winkEditorFragment;
        this.$it = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkEditorFragment$initExtractCoverViewModel$1$5(this.this$0, this.$it, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        ArrayList<LocalMediaInfo> originMediaInfos;
        int collectionSizeOrDefault;
        Intent intent;
        String kk5;
        com.tencent.mobileqq.wink.editor.filter.af Ok;
        com.tencent.mobileqq.wink.editor.filter.af Ok2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            WinkEditDataWrapper c16 = com.tencent.mobileqq.wink.editor.draft.a.c(this.this$0.Tk().getMissionId());
            if (c16 != null && (originMediaInfos = c16.getOriginMediaInfos()) != null) {
                WinkEditorFragment winkEditorFragment = this.this$0;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(originMediaInfos, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = originMediaInfos.iterator();
                while (it.hasNext()) {
                    arrayList.add(((LocalMediaInfo) it.next()).path);
                }
                WinkDraftGenerator.r(WinkDraftGenerator.f325956a, winkEditorFragment.Tk().getMissionId(), "", com.tencent.mobileqq.wink.utils.o.f326724a.i(arrayList), false, true, 8, null);
                FragmentActivity activity = winkEditorFragment.getActivity();
                if (activity != null) {
                    intent = activity.getIntent();
                } else {
                    intent = null;
                }
                kk5 = winkEditorFragment.kk(intent);
                Activity hostActivity = winkEditorFragment.getHostActivity();
                if (hostActivity != null) {
                    Intrinsics.checkNotNullExpressionValue(hostActivity, "hostActivity");
                    cx cxVar = winkEditorFragment.partManager;
                    if (cxVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("partManager");
                        cxVar = null;
                    }
                    NextBtnPart t16 = cxVar.t();
                    dr drVar = winkEditorFragment.curTavCut;
                    WinkEditorViewModel Tk = winkEditorFragment.Tk();
                    MetaMaterial curTemplateMaterial = winkEditorFragment.Sk().getCurTemplateMaterial();
                    Ok = winkEditorFragment.Ok();
                    MetaMaterial curFilterMaterial = Ok.getCurFilterMaterial();
                    Ok2 = winkEditorFragment.Ok();
                    cu.E(t16, drVar, Tk, curTemplateMaterial, curFilterMaterial, Ok2.getFilterRangeMode(), hostActivity, winkEditorFragment.Tk().getIsFromTemplateLib(), winkEditorFragment.Tk().getIsAutoTemplate(), winkEditorFragment.Tk().getIsFromZShow(), false, kk5, false);
                }
                w53.b.f("WinkEditorFragment", "daily save draft finish...");
            }
            MainCoroutineDispatcher main = Dispatchers.getMain();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, this.$it, null);
            this.label = 1;
            if (BuildersKt.withContext(main, anonymousClass2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkEditorFragment$initExtractCoverViewModel$1$5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
