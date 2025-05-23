package com.tencent.state.utils;

import android.graphics.Bitmap;
import com.tencent.state.data.SquareJSConst;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.api.ISquarePagView;
import com.tencent.state.square.data.SquareIntimateData;
import com.tencent.state.square.data.SquareIntimateInfo;
import com.tencent.state.square.data.SquareMutualMark;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.GlobalScope;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J:\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\r2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\rH\u0002J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\b\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/state/utils/SquareIntimateUtil;", "", "()V", "DIGIT3", "", "", "[Ljava/lang/Integer;", "DIGIT4", "MAX_ICON_NUM", "RANDOM_ICON_NUM", "TAG", "", "replaceImageLayerRandomly", "", "pagView", "Lcom/tencent/state/square/api/ISquarePagView;", "bitmaps", "Landroid/graphics/Bitmap;", SquareJSConst.Params.PARAMS_NUMS, "showAnimation", "", "frontPagView", "backPagView", "intimateInfo", "Lcom/tencent/state/square/data/SquareIntimateInfo;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareIntimateUtil {
    private static final int MAX_ICON_NUM = 5;
    private static final int RANDOM_ICON_NUM = 2;
    private static final String TAG = "SquareIntimateUtil";
    public static final SquareIntimateUtil INSTANCE = new SquareIntimateUtil();
    private static final Integer[] DIGIT3 = {0, 1, 2, 3, 5, 6, 7, 9, 10, 11, 13};
    private static final Integer[] DIGIT4 = {14, 15, 16, 17, 19, 20, 21, 23, 24, 25, 27, 28, 29, 31};

    SquareIntimateUtil() {
    }

    public final void showAnimation(ISquarePagView frontPagView, ISquarePagView backPagView, SquareIntimateInfo intimateInfo) {
        List take;
        int collectionSizeOrDefault;
        List take2;
        List take3;
        List shuffled;
        List take4;
        List plus;
        Object random;
        Intrinsics.checkNotNullParameter(frontPagView, "frontPagView");
        Intrinsics.checkNotNullParameter(backPagView, "backPagView");
        Intrinsics.checkNotNullParameter(intimateInfo, "intimateInfo");
        backPagView.stop();
        frontPagView.stop();
        if (!intimateInfo.getIntimateDatas().isEmpty() && !intimateInfo.getMutualMarks().isEmpty() && !intimateInfo.getAnimUrls().isEmpty()) {
            take = CollectionsKt___CollectionsKt.take(intimateInfo.getMutualMarks(), 5);
            List list = take;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((SquareMutualMark) it.next()).getIconUrl());
            }
            take2 = CollectionsKt___CollectionsKt.take(arrayList, 1);
            take3 = CollectionsKt___CollectionsKt.take(arrayList.subList(1, arrayList.size()), 5);
            shuffled = CollectionsKt__CollectionsJVMKt.shuffled(take3);
            take4 = CollectionsKt___CollectionsKt.take(shuffled, 2);
            plus = CollectionsKt___CollectionsKt.plus((Collection) take2, (Iterable) take4);
            random = CollectionsKt___CollectionsKt.random(intimateInfo.getIntimateDatas(), Random.INSTANCE);
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new SquareIntimateUtil$showAnimation$1(plus, intimateInfo, frontPagView, backPagView, (SquareIntimateData) random, null), 3, null);
            return;
        }
        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "showAnimation: error data", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Integer> replaceImageLayerRandomly(ISquarePagView pagView, List<Bitmap> bitmaps, List<Integer> nums) {
        Object firstOrNull;
        List takeLast;
        IntRange until;
        List list;
        if (pagView != null) {
            int numImages = pagView.numImages();
            if (nums == null) {
                until = RangesKt___RangesKt.until(0, numImages - 1);
                list = CollectionsKt___CollectionsKt.toList(until);
                nums = CollectionsKt__CollectionsJVMKt.shuffled(list);
            }
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) bitmaps);
            Bitmap bitmap = (Bitmap) firstOrNull;
            takeLast = CollectionsKt___CollectionsKt.takeLast(bitmaps, bitmaps.size() - 1);
            ArrayList arrayList = new ArrayList(takeLast);
            if (nums != null) {
                Iterator<T> it = nums.iterator();
                while (it.hasNext()) {
                    int intValue = ((Number) it.next()).intValue();
                    if (intValue < numImages - 1) {
                        if (!arrayList.isEmpty()) {
                            Bitmap bitmap2 = (Bitmap) arrayList.remove(0);
                            if (intValue < numImages && bitmap2 != null) {
                                pagView.replaceImageLayer(intValue, bitmap2);
                            } else {
                                pagView.replaceImageLayer(intValue, bitmap);
                            }
                        } else {
                            pagView.replaceImageLayer(intValue, bitmap);
                        }
                    } else {
                        SquareBaseKt.getSquareLog().d(TAG, "replaceImageLayerRandomly: " + numImages + ", " + intValue);
                    }
                }
            }
        }
        return nums;
    }
}
