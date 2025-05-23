package com.tencent.state.utils;

import android.graphics.Bitmap;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.api.ISquarePagView;
import com.tencent.state.square.data.SquareIntimateData;
import com.tencent.state.square.data.SquareIntimateInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.random.Random;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.state.utils.SquareIntimateUtil$showAnimation$1", f = "SquareIntimateUtil.kt", i = {0, 1, 1}, l = {48, 51}, m = "invokeSuspend", n = {"destination$iv$iv", "bitmaps", "destination$iv$iv"}, s = {"L$0", "L$0", "L$1"})
/* loaded from: classes38.dex */
public final class SquareIntimateUtil$showAnimation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ISquarePagView $backPagView;
    final /* synthetic */ ISquarePagView $frontPagView;
    final /* synthetic */ List $icons;
    final /* synthetic */ SquareIntimateInfo $intimateInfo;
    final /* synthetic */ SquareIntimateData $targetIntimateData;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareIntimateUtil$showAnimation$1(List list, SquareIntimateInfo squareIntimateInfo, ISquarePagView iSquarePagView, ISquarePagView iSquarePagView2, SquareIntimateData squareIntimateData, Continuation continuation) {
        super(2, continuation);
        this.$icons = list;
        this.$intimateInfo = squareIntimateInfo;
        this.$frontPagView = iSquarePagView;
        this.$backPagView = iSquarePagView2;
        this.$targetIntimateData = squareIntimateData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new SquareIntimateUtil$showAnimation$1(this.$icons, this.$intimateInfo, this.$frontPagView, this.$backPagView, this.$targetIntimateData, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SquareIntimateUtil$showAnimation$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00aa  */
    /* JADX WARN: Type inference failed for: r1v18, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r1v21, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r5v24, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r6v13, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r6v15, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x00c3 -> B:6:0x00ca). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x007a -> B:24:0x0080). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        ArrayList arrayList;
        int collectionSizeOrDefault;
        Iterator it;
        SquareIntimateUtil$showAnimation$1 squareIntimateUtil$showAnimation$1;
        int collectionSizeOrDefault2;
        Iterator it5;
        final ArrayList arrayList2;
        ArrayList arrayList3;
        List filterNotNull;
        List filterNotNull2;
        Object randomOrNull;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            List list = this.$icons;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            arrayList = new ArrayList(collectionSizeOrDefault);
            it = list.iterator();
            squareIntimateUtil$showAnimation$1 = this;
            if (it.hasNext()) {
            }
        } else if (i3 == 1) {
            ?? r16 = (Collection) this.L$2;
            Iterator it6 = (Iterator) this.L$1;
            ?? r65 = (Collection) this.L$0;
            ResultKt.throwOnFailure(obj);
            Iterator it7 = it6;
            ArrayList arrayList4 = r16;
            Object obj2 = coroutine_suspended;
            SquareIntimateUtil$showAnimation$1 squareIntimateUtil$showAnimation$12 = this;
            ArrayList arrayList5 = r65;
            arrayList4.add((Bitmap) obj);
            squareIntimateUtil$showAnimation$1 = squareIntimateUtil$showAnimation$12;
            coroutine_suspended = obj2;
            arrayList = arrayList5;
            it = it7;
            if (it.hasNext()) {
                String str = (String) it.next();
                SquarePagViewUtils squarePagViewUtils = SquarePagViewUtils.INSTANCE;
                squareIntimateUtil$showAnimation$1.L$0 = arrayList;
                squareIntimateUtil$showAnimation$1.L$1 = it;
                squareIntimateUtil$showAnimation$1.L$2 = arrayList;
                squareIntimateUtil$showAnimation$1.label = 1;
                Object downloadImage = squarePagViewUtils.downloadImage(str, squareIntimateUtil$showAnimation$1);
                if (downloadImage == coroutine_suspended) {
                    return coroutine_suspended;
                }
                it7 = it;
                arrayList4 = arrayList;
                obj2 = coroutine_suspended;
                squareIntimateUtil$showAnimation$12 = squareIntimateUtil$showAnimation$1;
                obj = downloadImage;
                arrayList5 = arrayList4;
                arrayList4.add((Bitmap) obj);
                squareIntimateUtil$showAnimation$1 = squareIntimateUtil$showAnimation$12;
                coroutine_suspended = obj2;
                arrayList = arrayList5;
                it = it7;
                if (it.hasNext()) {
                    List<String> animUrls = squareIntimateUtil$showAnimation$1.$intimateInfo.getAnimUrls();
                    collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(animUrls, 10);
                    ArrayList arrayList6 = new ArrayList(collectionSizeOrDefault2);
                    it5 = animUrls.iterator();
                    arrayList2 = arrayList;
                    arrayList3 = arrayList6;
                    if (it5.hasNext()) {
                    }
                }
            }
        } else if (i3 == 2) {
            ?? r17 = (Collection) this.L$3;
            Iterator it8 = (Iterator) this.L$2;
            ?? r56 = (Collection) this.L$1;
            ?? r66 = (List) this.L$0;
            ResultKt.throwOnFailure(obj);
            ArrayList arrayList7 = r66;
            Iterator it9 = it8;
            ArrayList arrayList8 = r17;
            Object obj3 = coroutine_suspended;
            SquareIntimateUtil$showAnimation$1 squareIntimateUtil$showAnimation$13 = this;
            ArrayList arrayList9 = r56;
            arrayList8.add((String) obj);
            squareIntimateUtil$showAnimation$1 = squareIntimateUtil$showAnimation$13;
            coroutine_suspended = obj3;
            arrayList3 = arrayList9;
            it5 = it9;
            arrayList2 = arrayList7;
            if (it5.hasNext()) {
                String str2 = (String) it5.next();
                SquarePagViewUtils squarePagViewUtils2 = SquarePagViewUtils.INSTANCE;
                squareIntimateUtil$showAnimation$1.L$0 = arrayList2;
                squareIntimateUtil$showAnimation$1.L$1 = arrayList3;
                squareIntimateUtil$showAnimation$1.L$2 = it5;
                squareIntimateUtil$showAnimation$1.L$3 = arrayList3;
                squareIntimateUtil$showAnimation$1.label = 2;
                Object downloadPag = squarePagViewUtils2.downloadPag(str2, squareIntimateUtil$showAnimation$1);
                if (downloadPag == coroutine_suspended) {
                    return coroutine_suspended;
                }
                arrayList7 = arrayList2;
                it9 = it5;
                arrayList8 = arrayList3;
                obj3 = coroutine_suspended;
                squareIntimateUtil$showAnimation$13 = squareIntimateUtil$showAnimation$1;
                obj = downloadPag;
                arrayList9 = arrayList8;
                arrayList8.add((String) obj);
                squareIntimateUtil$showAnimation$1 = squareIntimateUtil$showAnimation$13;
                coroutine_suspended = obj3;
                arrayList3 = arrayList9;
                it5 = it9;
                arrayList2 = arrayList7;
                if (it5.hasNext()) {
                    filterNotNull = CollectionsKt___CollectionsKt.filterNotNull(arrayList2);
                    filterNotNull2 = CollectionsKt___CollectionsKt.filterNotNull(arrayList3);
                    SquareBaseKt.getSquareLog().d("SquareIntimateUtil", "showAnimation: " + filterNotNull.size() + ", " + filterNotNull2.size());
                    if (!filterNotNull.isEmpty()) {
                        List list2 = filterNotNull2;
                        if (!list2.isEmpty()) {
                            randomOrNull = CollectionsKt___CollectionsKt.randomOrNull(list2, Random.INSTANCE);
                            Intrinsics.checkNotNull(randomOrNull);
                            final String str3 = (String) randomOrNull;
                            SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.utils.SquareIntimateUtil$showAnimation$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                                    objectRef.element = null;
                                    SquarePagViewUtils squarePagViewUtils3 = SquarePagViewUtils.INSTANCE;
                                    squarePagViewUtils3.playFile(SquareIntimateUtil$showAnimation$1.this.$frontPagView, str3, 1, new Function1<ISquarePagView, Unit>() { // from class: com.tencent.state.utils.SquareIntimateUtil.showAnimation.1.1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(ISquarePagView iSquarePagView) {
                                            invoke2(iSquarePagView);
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List, T] */
                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(ISquarePagView iSquarePagView) {
                                            ?? replaceImageLayerRandomly;
                                            Ref.ObjectRef objectRef2 = objectRef;
                                            replaceImageLayerRandomly = SquareIntimateUtil.INSTANCE.replaceImageLayerRandomly(iSquarePagView, arrayList2, (List) objectRef2.element);
                                            objectRef2.element = replaceImageLayerRandomly;
                                            if (iSquarePagView != null) {
                                                iSquarePagView.setLayerVisible(new Integer[]{0, 0}, false);
                                            }
                                            if (iSquarePagView != null) {
                                                iSquarePagView.setLayerVisible(new Integer[]{0, 1}, false);
                                            }
                                            if (iSquarePagView != null) {
                                                iSquarePagView.setLayerVisible(new Integer[]{0, 2, 0}, false);
                                            }
                                        }
                                    });
                                    squarePagViewUtils3.playFile(SquareIntimateUtil$showAnimation$1.this.$backPagView, str3, 1, new Function1<ISquarePagView, Unit>() { // from class: com.tencent.state.utils.SquareIntimateUtil.showAnimation.1.1.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(ISquarePagView iSquarePagView) {
                                            invoke2(iSquarePagView);
                                            return Unit.INSTANCE;
                                        }

                                        /* JADX WARN: Type inference failed for: r2v2, types: [java.util.List, T] */
                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(ISquarePagView iSquarePagView) {
                                            ?? replaceImageLayerRandomly;
                                            Integer[] numArr;
                                            int i16;
                                            Object last;
                                            Ref.ObjectRef objectRef2 = objectRef;
                                            replaceImageLayerRandomly = SquareIntimateUtil.INSTANCE.replaceImageLayerRandomly(iSquarePagView, arrayList2, (List) objectRef2.element);
                                            objectRef2.element = replaceImageLayerRandomly;
                                            long value = SquareIntimateUtil$showAnimation$1.this.$targetIntimateData.getValue();
                                            SquareBaseKt.getSquareLog().i("SquareIntimateUtil", "onPagFileLoaded: " + value);
                                            numArr = SquareIntimateUtil.DIGIT3;
                                            if (String.valueOf(value).length() > 3) {
                                                numArr = SquareIntimateUtil.DIGIT4;
                                                i16 = 1;
                                            } else {
                                                i16 = 0;
                                            }
                                            if (iSquarePagView != null) {
                                                iSquarePagView.replaceTextLayer(numArr[0].intValue(), SquareIntimateUtil$showAnimation$1.this.$targetIntimateData.getSuffixText(), null, Boolean.TRUE);
                                            }
                                            if (iSquarePagView != null) {
                                                last = ArraysKt___ArraysKt.last(numArr);
                                                iSquarePagView.replaceTextLayer(((Number) last).intValue(), SquareIntimateUtil$showAnimation$1.this.$targetIntimateData.getPrefixText(), null, Boolean.TRUE);
                                            }
                                            if (iSquarePagView != null) {
                                                iSquarePagView.setLayerVisible(new Integer[]{0, Integer.valueOf(i16)}, false);
                                            }
                                            if (iSquarePagView != null) {
                                                iSquarePagView.setLayerVisible(new Integer[]{0, 2, 1}, false);
                                            }
                                            int i17 = 1;
                                            int i18 = 1;
                                            while (i17 < numArr.length - 1) {
                                                if (iSquarePagView != null) {
                                                    iSquarePagView.replaceTextLayer(numArr[i17].intValue(), String.valueOf((value / i18) % 10), null, Boolean.TRUE);
                                                }
                                                i17++;
                                                if ((i17 - 1) % 3 == 0) {
                                                    i18 *= 10;
                                                }
                                            }
                                        }
                                    });
                                }
                            });
                        }
                    }
                    return Unit.INSTANCE;
                }
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
