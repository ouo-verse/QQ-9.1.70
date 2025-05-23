package com.tencent.mobileqq.wink.magicstudio;

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
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.aigc.bean.AIGCContentOutput;
import org.light.aigc.bean.ContentInfo;
import org.light.aigc.bean.MediaScene;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b0\u00101Js\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00020\t2\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002H\u0016J\u001c\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bj\n\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u001dH\u0016J\u0010\u0010!\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u001fH\u0016J\b\u0010#\u001a\u00020\"H\u0016J;\u0010*\u001a\u00020\u000f2\u001e\u0010'\u001a\u001a\u0012\u0004\u0012\u00020%\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0&0$2\u0006\u0010)\u001a\u00020(H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b*\u0010+J\u001a\u0010.\u001a\u0004\u0018\u00010\u001c2\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u001cH\u0016R\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010/\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioImageDataManager;", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioDataManager;", "", "Lcom/tencent/mobileqq/wink/magicstudio/model/g;", "magicStudioTips", "Lcom/tencent/mobileqq/wink/magicstudio/model/f;", "magicStudioStyles", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPrompt;", "magicStudioPrompts", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_styleData", "_tagData", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/tencent/mobileqq/wink/magicstudio/MagicStudioCreationViewModel$c;", "_selectEvent", "", "k", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Lkotlinx/coroutines/flow/MutableStateFlow;Lkotlinx/coroutines/flow/MutableStateFlow;Lkotlinx/coroutines/flow/MutableSharedFlow;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "l", "Lcom/tencent/mobileqq/wink/magicstudio/model/d;", "jumpInfo", "", "a", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioUploadImgInfo;", "b", "o", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "g", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioUploadImgAndStyle;", "info", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/wink/magicstudio/model/Scene;", tl.h.F, "Lkotlin/Pair;", "Lorg/light/aigc/bean/AIGCContentOutput;", "", "it", "Lkotlinx/coroutines/CoroutineScope;", "scope", "i", "(Lkotlin/Pair;Lkotlinx/coroutines/CoroutineScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "nnCurStyle", "curDesc", "c", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioUploadImgAndStyle;", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MagicStudioImageDataManager extends MagicStudioDataManager {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MagicStudioUploadImgAndStyle info;

    @Override // com.tencent.mobileqq.wink.magicstudio.MagicStudioDataManager
    public int a(@NotNull JumpInfo jumpInfo) {
        Intrinsics.checkNotNullParameter(jumpInfo, "jumpInfo");
        return 1;
    }

    @Override // com.tencent.mobileqq.wink.magicstudio.MagicStudioDataManager
    @NotNull
    public MagicStudioUploadImgInfo b() {
        MagicStudioUploadImgInfo currentImg;
        MagicStudioUploadImgAndStyle magicStudioUploadImgAndStyle = this.info;
        if (magicStudioUploadImgAndStyle == null || (currentImg = magicStudioUploadImgAndStyle.getCurrentImg()) == null) {
            return new MagicStudioUploadImgInfo(null, null, null, null, null, null, null, false, null, null, false, 2047, null);
        }
        return currentImg;
    }

    @Override // com.tencent.mobileqq.wink.magicstudio.MagicStudioDataManager
    @Nullable
    public String c(@NotNull com.tencent.mobileqq.wink.magicstudio.model.f nnCurStyle, @NotNull String curDesc) {
        Intrinsics.checkNotNullParameter(nnCurStyle, "nnCurStyle");
        Intrinsics.checkNotNullParameter(curDesc, "curDesc");
        return curDesc;
    }

    @Override // com.tencent.mobileqq.wink.magicstudio.MagicStudioDataManager
    @Nullable
    public ArrayList<String> g() {
        MagicStudioUploadImgAndStyle magicStudioUploadImgAndStyle = this.info;
        if (magicStudioUploadImgAndStyle != null) {
            return magicStudioUploadImgAndStyle.getRecommendStyleList();
        }
        return null;
    }

    @Override // com.tencent.mobileqq.wink.magicstudio.MagicStudioDataManager
    @NotNull
    public Scene h() {
        MagicStudioUploadImgInfo currentImg;
        MagicStudioUploadImgAndStyle magicStudioUploadImgAndStyle = this.info;
        if (magicStudioUploadImgAndStyle != null && (currentImg = magicStudioUploadImgAndStyle.getCurrentImg()) != null) {
            if (currentImg.getIsVertical()) {
                return Scene.VERTICAL;
            }
            return Scene.HORIZONTAL;
        }
        return Scene.VERTICAL;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:3|(7:5|6|7|(1:(2:10|11)(2:17|18))(11:19|20|(3:22|(5:25|(1:27)(1:34)|(3:29|30|31)(1:33)|32|23)|35)(1:57)|(2:37|(7:39|(1:41)|42|(1:44)|(3:46|(1:48)(1:55)|(1:50)(2:51|(1:53)(1:54)))|13|14))|56|(0)|42|(0)|(0)|13|14)|12|13|14))|60|6|7|(0)(0)|12|13|14) */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00bf, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00c0, code lost:
    
        w53.b.h("MagicStudioCreationViewModel", "cutImgResult error", r11);
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008a A[Catch: all -> 0x00bf, TryCatch #0 {all -> 0x00bf, blocks: (B:11:0x0029, B:12:0x00b9, B:20:0x003a, B:22:0x0046, B:23:0x0051, B:25:0x0057, B:30:0x0069, B:37:0x0070, B:39:0x0078, B:42:0x0081, B:46:0x008a, B:48:0x00a4, B:51:0x00ad), top: B:7:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    @Override // com.tencent.mobileqq.wink.magicstudio.MagicStudioDataManager
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object i(@NotNull Pair<? extends AIGCContentOutput, ? extends Map<String, String>> pair, @NotNull CoroutineScope coroutineScope, @NotNull Continuation<? super Unit> continuation) {
        MagicStudioImageDataManager$handleCutPic$1 magicStudioImageDataManager$handleCutPic$1;
        Object coroutine_suspended;
        int i3;
        ArrayList arrayList;
        String str;
        Deferred async$default;
        MagicStudioUploadImgInfo magicStudioUploadImgInfo;
        MagicStudioUploadImgInfo magicStudioUploadImgInfo2;
        Object orNull;
        boolean z16;
        if (continuation instanceof MagicStudioImageDataManager$handleCutPic$1) {
            magicStudioImageDataManager$handleCutPic$1 = (MagicStudioImageDataManager$handleCutPic$1) continuation;
            int i16 = magicStudioImageDataManager$handleCutPic$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                magicStudioImageDataManager$handleCutPic$1.label = i16 - Integer.MIN_VALUE;
                Object obj = magicStudioImageDataManager$handleCutPic$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = magicStudioImageDataManager$handleCutPic$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        magicStudioUploadImgInfo2 = (MagicStudioUploadImgInfo) magicStudioImageDataManager$handleCutPic$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    List<ContentInfo> list = pair.getFirst().contentInfos;
                    boolean z17 = false;
                    if (list != null) {
                        arrayList = new ArrayList();
                        for (Object obj2 : list) {
                            if (((ContentInfo) obj2).scene == MediaScene.SceneCropped) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (z16) {
                                arrayList.add(obj2);
                            }
                        }
                    } else {
                        arrayList = null;
                    }
                    if (arrayList != null) {
                        orNull = CollectionsKt___CollectionsKt.getOrNull(arrayList, 0);
                        ContentInfo contentInfo = (ContentInfo) orNull;
                        if (contentInfo != null) {
                            str = contentInfo.stringData;
                            if (str == null) {
                                str = "";
                            }
                            if (str.length() > 0) {
                                z17 = true;
                            }
                            if (z17) {
                                async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, WinkCoroutineScopes.f317652a.d(), null, new MagicStudioImageDataManager$handleCutPic$cutImgResult$1(str, null), 2, null);
                                async$default.start();
                                MagicStudioUploadImgAndStyle magicStudioUploadImgAndStyle = this.info;
                                if (magicStudioUploadImgAndStyle != null) {
                                    magicStudioUploadImgInfo = magicStudioUploadImgAndStyle.getCurrentImg();
                                } else {
                                    magicStudioUploadImgInfo = null;
                                }
                                if (magicStudioUploadImgInfo != null) {
                                    magicStudioImageDataManager$handleCutPic$1.L$0 = magicStudioUploadImgInfo;
                                    magicStudioImageDataManager$handleCutPic$1.label = 1;
                                    obj = async$default.await(magicStudioImageDataManager$handleCutPic$1);
                                    if (obj == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    magicStudioUploadImgInfo2 = magicStudioUploadImgInfo;
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    str = null;
                    if (str == null) {
                    }
                    if (str.length() > 0) {
                    }
                    if (z17) {
                    }
                    return Unit.INSTANCE;
                }
                magicStudioUploadImgInfo2.q((String) obj);
                return Unit.INSTANCE;
            }
        }
        magicStudioImageDataManager$handleCutPic$1 = new MagicStudioImageDataManager$handleCutPic$1(this, continuation);
        Object obj3 = magicStudioImageDataManager$handleCutPic$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = magicStudioImageDataManager$handleCutPic$1.label;
        if (i3 == 0) {
        }
        magicStudioUploadImgInfo2.q((String) obj3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // com.tencent.mobileqq.wink.magicstudio.MagicStudioDataManager
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object k(@NotNull List<MagicStudioTip> list, @NotNull List<com.tencent.mobileqq.wink.magicstudio.model.f> list2, @NotNull List<MagicStudioPrompt> list3, @NotNull MutableStateFlow<List<com.tencent.mobileqq.wink.magicstudio.model.f>> mutableStateFlow, @NotNull MutableStateFlow<List<MagicStudioPrompt>> mutableStateFlow2, @NotNull MutableSharedFlow<MagicStudioCreationViewModel.c> mutableSharedFlow, @NotNull Continuation<? super Unit> continuation) {
        MagicStudioImageDataManager$onPageInit$1 magicStudioImageDataManager$onPageInit$1;
        Object coroutine_suspended;
        int i3;
        List shuffled;
        MagicStudioImageDataManager magicStudioImageDataManager;
        List<MagicStudioPrompt> o16;
        MutableSharedFlow mutableSharedFlow2;
        ArrayList<String> g16;
        if (continuation instanceof MagicStudioImageDataManager$onPageInit$1) {
            magicStudioImageDataManager$onPageInit$1 = (MagicStudioImageDataManager$onPageInit$1) continuation;
            int i16 = magicStudioImageDataManager$onPageInit$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                magicStudioImageDataManager$onPageInit$1.label = i16 - Integer.MIN_VALUE;
                Object obj = magicStudioImageDataManager$onPageInit$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = magicStudioImageDataManager$onPageInit$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                ResultKt.throwOnFailure(obj);
                                return Unit.INSTANCE;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        mutableSharedFlow2 = (MutableSharedFlow) magicStudioImageDataManager$onPageInit$1.L$1;
                        magicStudioImageDataManager = (MagicStudioImageDataManager) magicStudioImageDataManager$onPageInit$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        g16 = magicStudioImageDataManager.g();
                        if (g16 != null) {
                            MagicStudioCreationViewModel.c.StyleSuccess styleSuccess = new MagicStudioCreationViewModel.c.StyleSuccess(g16);
                            magicStudioImageDataManager$onPageInit$1.L$0 = null;
                            magicStudioImageDataManager$onPageInit$1.L$1 = null;
                            magicStudioImageDataManager$onPageInit$1.label = 3;
                            if (mutableSharedFlow2.emit(styleSuccess, magicStudioImageDataManager$onPageInit$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                    mutableSharedFlow = (MutableSharedFlow) magicStudioImageDataManager$onPageInit$1.L$2;
                    mutableStateFlow2 = (MutableStateFlow) magicStudioImageDataManager$onPageInit$1.L$1;
                    MagicStudioImageDataManager magicStudioImageDataManager2 = (MagicStudioImageDataManager) magicStudioImageDataManager$onPageInit$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    magicStudioImageDataManager = magicStudioImageDataManager2;
                } else {
                    ResultKt.throwOnFailure(obj);
                    shuffled = CollectionsKt__CollectionsJVMKt.shuffled(list3);
                    m(new ac<>(shuffled));
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : list2) {
                        if (!Intrinsics.areEqual(((com.tencent.mobileqq.wink.magicstudio.model.f) obj2).getSupportMode(), "2")) {
                            arrayList.add(obj2);
                        }
                    }
                    magicStudioImageDataManager$onPageInit$1.L$0 = this;
                    magicStudioImageDataManager$onPageInit$1.L$1 = mutableStateFlow2;
                    magicStudioImageDataManager$onPageInit$1.L$2 = mutableSharedFlow;
                    magicStudioImageDataManager$onPageInit$1.label = 1;
                    if (mutableStateFlow.emit(arrayList, magicStudioImageDataManager$onPageInit$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    magicStudioImageDataManager = this;
                }
                o16 = magicStudioImageDataManager.o();
                if (o16 != null) {
                    magicStudioImageDataManager$onPageInit$1.L$0 = magicStudioImageDataManager;
                    magicStudioImageDataManager$onPageInit$1.L$1 = mutableSharedFlow;
                    magicStudioImageDataManager$onPageInit$1.L$2 = null;
                    magicStudioImageDataManager$onPageInit$1.label = 2;
                    if (mutableStateFlow2.emit(o16, magicStudioImageDataManager$onPageInit$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mutableSharedFlow2 = mutableSharedFlow;
                    g16 = magicStudioImageDataManager.g();
                    if (g16 != null) {
                    }
                }
                return Unit.INSTANCE;
            }
        }
        magicStudioImageDataManager$onPageInit$1 = new MagicStudioImageDataManager$onPageInit$1(this, continuation);
        Object obj3 = magicStudioImageDataManager$onPageInit$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = magicStudioImageDataManager$onPageInit$1.label;
        if (i3 == 0) {
        }
        o16 = magicStudioImageDataManager.o();
        if (o16 != null) {
        }
        return Unit.INSTANCE;
    }

    @Override // com.tencent.mobileqq.wink.magicstudio.MagicStudioDataManager
    public boolean l() {
        return true;
    }

    @Override // com.tencent.mobileqq.wink.magicstudio.MagicStudioDataManager
    public void n(@NotNull MagicStudioUploadImgAndStyle info) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.info = info;
    }

    @Nullable
    public List<MagicStudioPrompt> o() {
        MagicStudioUploadImgAndStyle magicStudioUploadImgAndStyle = this.info;
        if (magicStudioUploadImgAndStyle != null) {
            return magicStudioUploadImgAndStyle.getRecommendTopicList();
        }
        return null;
    }
}
