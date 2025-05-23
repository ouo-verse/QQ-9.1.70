package com.tencent.mobileqq.wink.magicstudio;

import com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel;
import com.tencent.mobileqq.wink.magicstudio.model.JumpInfo;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioPrompt;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioTip;
import com.tencent.mobileqq.wink.magicstudio.model.Scene;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJs\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00020\t2\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioTextDataManager;", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioDataManager;", "", "Lcom/tencent/mobileqq/wink/magicstudio/model/g;", "magicStudioTips", "Lcom/tencent/mobileqq/wink/magicstudio/model/f;", "magicStudioStyles", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPrompt;", "magicStudioPrompts", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_styleData", "_tagData", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel$c;", "_selectEvent", "", "k", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlinx/coroutines/flow/MutableStateFlow;Lkotlinx/coroutines/flow/MutableStateFlow;Lkotlinx/coroutines/flow/MutableSharedFlow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "l", "Lcom/tencent/mobileqq/wink/magicstudio/model/Scene;", tl.h.F, "nnCurStyle", "", "curDesc", "c", "Lcom/tencent/mobileqq/wink/magicstudio/model/d;", "jumpInfo", "", "a", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MagicStudioTextDataManager extends MagicStudioDataManager {
    @Override // com.tencent.mobileqq.wink.magicstudio.MagicStudioDataManager
    public int a(@NotNull JumpInfo jumpInfo) {
        int lastIndex;
        Intrinsics.checkNotNullParameter(jumpInfo, "jumpInfo");
        lastIndex = CollectionsKt__CollectionsKt.getLastIndex(jumpInfo.c());
        return lastIndex;
    }

    @Override // com.tencent.mobileqq.wink.magicstudio.MagicStudioDataManager
    @Nullable
    public String c(@NotNull com.tencent.mobileqq.wink.magicstudio.model.f nnCurStyle, @NotNull String curDesc) {
        boolean isBlank;
        LinkedList<MagicStudioPrompt> a16;
        Object obj;
        boolean z16;
        Intrinsics.checkNotNullParameter(nnCurStyle, "nnCurStyle");
        Intrinsics.checkNotNullParameter(curDesc, "curDesc");
        isBlank = StringsKt__StringsJVMKt.isBlank(curDesc);
        if (isBlank) {
            ac<MagicStudioPrompt> f16 = f();
            String str = null;
            if (f16 == null || (a16 = f16.a()) == null) {
                return null;
            }
            Iterator<T> it = a16.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((MagicStudioPrompt) obj).getDefaultStyleId(), nnCurStyle.getStyleID())) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            MagicStudioPrompt magicStudioPrompt = (MagicStudioPrompt) obj;
            if (magicStudioPrompt != null) {
                str = magicStudioPrompt.getDefaultPromptInput();
            }
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return nnCurStyle.getDefaultPrompt();
            }
            return str;
        }
        return curDesc;
    }

    @Override // com.tencent.mobileqq.wink.magicstudio.MagicStudioDataManager
    @NotNull
    public Scene h() {
        return Scene.TEXT;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00aa A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.tencent.mobileqq.wink.magicstudio.MagicStudioDataManager
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object k(@NotNull List<MagicStudioTip> list, @NotNull List<com.tencent.mobileqq.wink.magicstudio.model.f> list2, @NotNull List<MagicStudioPrompt> list3, @NotNull MutableStateFlow<List<com.tencent.mobileqq.wink.magicstudio.model.f>> mutableStateFlow, @NotNull MutableStateFlow<List<MagicStudioPrompt>> mutableStateFlow2, @NotNull MutableSharedFlow<MagicStudioCreationViewModel.c> mutableSharedFlow, @NotNull Continuation<? super Unit> continuation) {
        MagicStudioTextDataManager$onPageInit$1 magicStudioTextDataManager$onPageInit$1;
        Object coroutine_suspended;
        int i3;
        List shuffled;
        MagicStudioTextDataManager magicStudioTextDataManager;
        ac<MagicStudioPrompt> f16;
        List<MagicStudioPrompt> emptyList;
        if (continuation instanceof MagicStudioTextDataManager$onPageInit$1) {
            magicStudioTextDataManager$onPageInit$1 = (MagicStudioTextDataManager$onPageInit$1) continuation;
            int i16 = magicStudioTextDataManager$onPageInit$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                magicStudioTextDataManager$onPageInit$1.label = i16 - Integer.MIN_VALUE;
                Object obj = magicStudioTextDataManager$onPageInit$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = magicStudioTextDataManager$onPageInit$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mutableStateFlow2 = (MutableStateFlow) magicStudioTextDataManager$onPageInit$1.L$1;
                    magicStudioTextDataManager = (MagicStudioTextDataManager) magicStudioTextDataManager$onPageInit$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    shuffled = CollectionsKt__CollectionsJVMKt.shuffled(list3);
                    m(new ac<>(shuffled));
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : list2) {
                        if (!Intrinsics.areEqual(((com.tencent.mobileqq.wink.magicstudio.model.f) obj2).getSupportMode(), "1")) {
                            arrayList.add(obj2);
                        }
                    }
                    magicStudioTextDataManager$onPageInit$1.L$0 = this;
                    magicStudioTextDataManager$onPageInit$1.L$1 = mutableStateFlow2;
                    magicStudioTextDataManager$onPageInit$1.label = 1;
                    if (mutableStateFlow.emit(arrayList, magicStudioTextDataManager$onPageInit$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    magicStudioTextDataManager = this;
                }
                f16 = magicStudioTextDataManager.f();
                if (f16 != null || (emptyList = f16.a()) == null) {
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                }
                magicStudioTextDataManager$onPageInit$1.L$0 = null;
                magicStudioTextDataManager$onPageInit$1.L$1 = null;
                magicStudioTextDataManager$onPageInit$1.label = 2;
                if (mutableStateFlow2.emit(emptyList, magicStudioTextDataManager$onPageInit$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        magicStudioTextDataManager$onPageInit$1 = new MagicStudioTextDataManager$onPageInit$1(this, continuation);
        Object obj3 = magicStudioTextDataManager$onPageInit$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = magicStudioTextDataManager$onPageInit$1.label;
        if (i3 == 0) {
        }
        f16 = magicStudioTextDataManager.f();
        if (f16 != null) {
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        magicStudioTextDataManager$onPageInit$1.L$0 = null;
        magicStudioTextDataManager$onPageInit$1.L$1 = null;
        magicStudioTextDataManager$onPageInit$1.label = 2;
        if (mutableStateFlow2.emit(emptyList, magicStudioTextDataManager$onPageInit$1) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    @Override // com.tencent.mobileqq.wink.magicstudio.MagicStudioDataManager
    public boolean l() {
        return false;
    }
}
