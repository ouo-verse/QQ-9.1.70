package com.tencent.mobileqq.wink.magicstudio;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel;
import com.tencent.mobileqq.wink.magicstudio.model.JumpInfo;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioPrompt;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioTip;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioUploadImgAndStyle;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioUploadImgInfo;
import com.tencent.mobileqq.wink.magicstudio.model.Scene;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.aigc.bean.AIGCContentOutput;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b;\u0010<Js\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00020\t2\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00162\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u001a\u001a\u00020\u0019H&J\u001c\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u001dH\u0016J\u0010\u0010!\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u001fH\u0016J\b\u0010#\u001a\u00020\"H\u0016J\b\u0010%\u001a\u00020$H&J;\u0010,\u001a\u00020\u000f2\u001e\u0010)\u001a\u001a\u0012\u0004\u0012\u00020'\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0(0&2\u0006\u0010+\u001a\u00020*H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b,\u0010-J\u001a\u00100\u001a\u0004\u0018\u00010\u001c2\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u001cH&J\u0010\u00103\u001a\u00020\u00122\u0006\u00102\u001a\u000201H&R*\u0010:\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioDataManager;", "", "", "Lcom/tencent/mobileqq/wink/magicstudio/model/g;", "magicStudioTips", "Lcom/tencent/mobileqq/wink/magicstudio/model/f;", "magicStudioStyles", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPrompt;", "magicStudioPrompts", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_styleData", "_tagData", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel$c;", "_selectEvent", "", "k", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlinx/coroutines/flow/MutableStateFlow;Lkotlinx/coroutines/flow/MutableStateFlow;Lkotlinx/coroutines/flow/MutableSharedFlow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "count", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "template", "Lkotlinx/coroutines/flow/Flow;", "d", "(ILcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "l", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "g", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioUploadImgAndStyle;", "info", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioUploadImgInfo;", "b", "Lcom/tencent/mobileqq/wink/magicstudio/model/Scene;", tl.h.F, "Lkotlin/Pair;", "Lorg/light/aigc/bean/AIGCContentOutput;", "", "it", "Lkotlinx/coroutines/CoroutineScope;", "scope", "i", "(Lkotlin/Pair;Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "nnCurStyle", "curDesc", "c", "Lcom/tencent/mobileqq/wink/magicstudio/model/d;", "jumpInfo", "a", "Lcom/tencent/mobileqq/wink/magicstudio/ac;", "Lcom/tencent/mobileqq/wink/magicstudio/ac;", "f", "()Lcom/tencent/mobileqq/wink/magicstudio/ac;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/mobileqq/wink/magicstudio/ac;)V", "prompts", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class MagicStudioDataManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ac<MagicStudioPrompt> prompts;

    static /* synthetic */ Object e(MagicStudioDataManager magicStudioDataManager, int i3, MetaMaterial metaMaterial, Continuation<? super Flow<MetaMaterial>> continuation) {
        return FlowKt.flowOn(FlowKt.flow(new MagicStudioDataManager$getMaterialFlow$2(metaMaterial, null)), WinkCoroutineScopes.f317652a.d());
    }

    static /* synthetic */ Object j(MagicStudioDataManager magicStudioDataManager, Pair<? extends AIGCContentOutput, ? extends Map<String, String>> pair, CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    public abstract int a(@NotNull JumpInfo jumpInfo);

    @NotNull
    public MagicStudioUploadImgInfo b() {
        return new MagicStudioUploadImgInfo(null, null, null, null, null, null, null, false, null, null, false, 2047, null);
    }

    @Nullable
    public abstract String c(@NotNull com.tencent.mobileqq.wink.magicstudio.model.f nnCurStyle, @NotNull String curDesc);

    @Nullable
    public Object d(int i3, @Nullable MetaMaterial metaMaterial, @NotNull Continuation<? super Flow<MetaMaterial>> continuation) {
        return e(this, i3, metaMaterial, continuation);
    }

    @Nullable
    public final ac<MagicStudioPrompt> f() {
        return this.prompts;
    }

    @Nullable
    public ArrayList<String> g() {
        return null;
    }

    @NotNull
    public abstract Scene h();

    @Nullable
    public Object i(@NotNull Pair<? extends AIGCContentOutput, ? extends Map<String, String>> pair, @NotNull CoroutineScope coroutineScope, @NotNull Continuation<? super Unit> continuation) {
        return j(this, pair, coroutineScope, continuation);
    }

    @Nullable
    public abstract Object k(@NotNull List<MagicStudioTip> list, @NotNull List<com.tencent.mobileqq.wink.magicstudio.model.f> list2, @NotNull List<MagicStudioPrompt> list3, @NotNull MutableStateFlow<List<com.tencent.mobileqq.wink.magicstudio.model.f>> mutableStateFlow, @NotNull MutableStateFlow<List<MagicStudioPrompt>> mutableStateFlow2, @NotNull MutableSharedFlow<MagicStudioCreationViewModel.c> mutableSharedFlow, @NotNull Continuation<? super Unit> continuation);

    public abstract boolean l();

    public final void m(@Nullable ac<MagicStudioPrompt> acVar) {
        this.prompts = acVar;
    }

    public void n(@NotNull MagicStudioUploadImgAndStyle info) {
        Intrinsics.checkNotNullParameter(info, "info");
    }
}
