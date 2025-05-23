package com.tencent.mobileqq.wink.aiavatar.picker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.gyailib.library.FaceDetectorFeature;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.aiavatar.base.WinkAIAvatarUtils;
import com.tencent.mobileqq.wink.utils.j;
import com.tencent.mobileqq.wink.view.ai;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qzone.QZoneNavigateToQQTransparentFragment;
import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.comparisons.ComparisonsKt___ComparisonsJvmKt;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 ?2\u00020\u0001:\u0001@B\u0007\u00a2\u0006\u0004\b=\u0010>J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\u000b\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\f2\u0014\u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f0\fH\u0002Jp\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00112\u001a\u0010\u0013\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000fj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0006`\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\f2\u001c\b\u0002\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0011H\u0002J\u001a\u0010\u0019\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0018\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\f2\u0006\u0010\u001a\u001a\u00020\u0010H\u0002JO\u0010!\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00112%\b\u0002\u0010 \u001a\u001f\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001cH\u0002J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"H\u0002J-\u0010(\u001a\u0004\u0018\u00010\u00102\u0006\u0010%\u001a\u00020\u00102\b\u0010&\u001a\u0004\u0018\u00010\u00062\b\u0010'\u001a\u0004\u0018\u00010\tH\u0002\u00a2\u0006\u0004\b(\u0010)J\b\u0010+\u001a\u00020*H\u0002JO\u0010,\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00112%\b\u0002\u0010 \u001a\u001f\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001cJ\b\u0010-\u001a\u00020*H\u0016J\b\u0010.\u001a\u00020\u0004H\u0014J\u000e\u0010/\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00109\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/picker/WinkAIAvatarMediaPickerViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Landroid/content/Context;", "context", "", "f2", "Landroid/graphics/RectF;", "firstFaceRect", "secondFaceRect", "", "minRatio", "X1", "", "detectFaces", "W1", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lkotlin/collections/ArrayList;", "images", "faceDetectResults", "cropRatios", "imagePickerMedias", "Z1", "", "show", "j2", "image", "S1", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "isSuccess", "callback", "T1", "Lcom/gyailib/library/FaceDetectorFeature;", "faceDetectResult", "g2", "localMediaInfo", "faceRect", "ratio", "R1", "(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;Landroid/graphics/RectF;Ljava/lang/Float;)Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "", "U1", ICustomDataEditor.STRING_ARRAY_PARAM_2, "getLogTag", "onCleared", SemanticAttributes.DbSystemValues.H2, "Lcom/tencent/mobileqq/wink/view/ai;", "i", "Lcom/tencent/mobileqq/wink/view/ai;", "loadingDialog", "Lkotlinx/coroutines/Job;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlinx/coroutines/Job;", "faceDetectJob", BdhLogUtil.LogTag.Tag_Conn, "Z", "isCoupleStyle", "D", "isReplaceScene", "<init>", "()V", "E", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkAIAvatarMediaPickerViewModel extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isCoupleStyle;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isReplaceScene;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ai loadingDialog;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Job faceDetectJob;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class b<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            RectF rectF = (RectF) t17;
            RectF rectF2 = (RectF) t16;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Float.valueOf(rectF.width() * rectF.height()), Float.valueOf(rectF2.width() * rectF2.height()));
            return compareValues;
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WinkAIAvatarMediaPickerViewModel f317751d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Context f317752e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(CoroutineExceptionHandler.Companion companion, WinkAIAvatarMediaPickerViewModel winkAIAvatarMediaPickerViewModel, Context context) {
            super(companion);
            this.f317751d = winkAIAvatarMediaPickerViewModel;
            this.f317752e = context;
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull CoroutineContext context, @NotNull Throwable exception) {
            String stackTraceToString;
            stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(exception);
            w53.b.c("WinkAIAvatarMediaPickerViewModel", "detectFace exception: " + stackTraceToString);
            this.f317751d.h2(this.f317752e);
        }
    }

    private final LocalMediaInfo R1(LocalMediaInfo localMediaInfo, RectF faceRect, Float ratio) {
        float f16;
        float coerceAtMost;
        float coerceIn;
        float coerceAtMost2;
        float coerceIn2;
        try {
            Bitmap c16 = com.tencent.mobileqq.wink.utils.f.c(localMediaInfo.path);
            if (c16 == null) {
                w53.b.c("WinkAIAvatarMediaPickerViewModel", "cropBitmap: decodeFile failed: " + localMediaInfo.path);
                return null;
            }
            int width = c16.getWidth();
            float f17 = width;
            float height = c16.getHeight();
            RectF rectF = new RectF(0.0f, 0.0f, f17, height);
            if (ratio != null) {
                f16 = ratio.floatValue();
            } else {
                f16 = 0.15f;
            }
            float f18 = 1024;
            RectF rectF2 = new RectF(0.0f, 0.0f, f18, f18);
            Matrix matrix = new Matrix();
            float min = (f18 * 1.0f) / Math.min(width, r5);
            matrix.postTranslate(rectF2.centerX() - rectF.centerX(), rectF2.centerY() - rectF.centerY());
            matrix.postScale(min, min, rectF2.centerX(), rectF2.centerY());
            if (faceRect != null) {
                RectF rectF3 = new RectF(0.0f, 0.0f, f17, height);
                RectF rectF4 = new RectF();
                RectF rectF5 = new RectF(faceRect.left * f17, faceRect.top * height, faceRect.right * f17, faceRect.bottom * height);
                RectF rectF6 = new RectF();
                matrix.mapRect(rectF4, rectF3);
                matrix.mapRect(rectF6, rectF5);
                float max = Math.max(1.0f, f16 / Math.max(faceRect.width(), faceRect.height()));
                matrix.postScale(max, max, rectF2.centerX(), rectF2.centerY());
                matrix.mapRect(rectF4, rectF3);
                matrix.mapRect(rectF6, rectF5);
                float f19 = rectF4.right - rectF2.right;
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(rectF4.left - rectF2.left, f19);
                coerceIn = RangesKt___RangesKt.coerceIn(rectF4.centerX() - rectF6.centerX(), coerceAtMost, f19);
                float f26 = rectF4.bottom - rectF2.bottom;
                coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(rectF4.top - rectF2.top, f26);
                coerceIn2 = RangesKt___RangesKt.coerceIn(rectF4.centerY() - rectF6.centerY(), coerceAtMost2, f26);
                matrix.postTranslate(coerceIn, coerceIn2);
            }
            Bitmap createBitmap = Bitmap.createBitmap(1024, 1024, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Matrix matrix2 = new Matrix();
            matrix2.set(matrix);
            matrix2.postTranslate(-rectF2.left, -rectF2.top);
            canvas.drawBitmap(c16, matrix2, new Paint(6));
            String U1 = U1();
            FileOutputStream fileOutputStream = new FileOutputStream(new File(U1));
            try {
                createBitmap.compress(Bitmap.CompressFormat.JPEG, 95, fileOutputStream);
                CloseableKt.closeFinally(fileOutputStream, null);
                c16.recycle();
                createBitmap.recycle();
                LocalMediaInfo localMediaInfo2 = new LocalMediaInfo();
                localMediaInfo2.path = U1;
                return localMediaInfo2;
            } finally {
            }
        } catch (Throwable th5) {
            w53.b.c("WinkAIAvatarMediaPickerViewModel", "cropBitmap: " + th5);
            return null;
        }
    }

    private final List<RectF> S1(LocalMediaInfo image) {
        int collectionSizeOrDefault;
        List<RectF> sortedWith;
        Bitmap bitmap = com.tencent.mobileqq.wink.utils.f.c(image.path);
        j jVar = j.f326712a;
        Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
        List<FaceDetectorFeature> a16 = jVar.a(bitmap);
        if (a16 != null) {
            List<FaceDetectorFeature> list = a16;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(g2((FaceDetectorFeature) it.next()));
            }
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, new b());
            return sortedWith;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0075, code lost:
    
        if (r0 == null) goto L23;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void T1(Context context, ArrayList<LocalMediaInfo> images, Function1<? super Boolean, Unit> callback) {
        Object first;
        Object last;
        RectF rectF;
        List listOf;
        ArrayList arrayListOf;
        Object firstOrNull;
        Object firstOrNull2;
        RectF rectF2;
        Object first2;
        List listOf2;
        ArrayList arrayListOf2;
        Object orNull;
        Object firstOrNull3;
        boolean z16;
        List listOf3;
        Object first3;
        ArrayList arrayListOf3;
        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) images);
        List<RectF> S1 = S1((LocalMediaInfo) first);
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) images);
        List<RectF> S12 = S1((LocalMediaInfo) last);
        if (!this.isCoupleStyle) {
            List<RectF> list = S1;
            if (list != null && !list.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                listOf3 = CollectionsKt__CollectionsJVMKt.listOf(S1);
                List<Float> W1 = W1(listOf3);
                first3 = CollectionsKt___CollectionsKt.first((List<? extends Object>) S1);
                arrayListOf3 = CollectionsKt__CollectionsKt.arrayListOf((RectF) first3);
                b2(this, context, images, arrayListOf3, W1, null, 16, null);
                return;
            }
            h2(context);
            if (callback != null) {
                callback.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        RectF rectF3 = null;
        if (images.size() == 1) {
            if (S1 != null) {
                firstOrNull3 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) S1);
                rectF3 = (RectF) firstOrNull3;
            }
            if (S1 != null) {
                orNull = CollectionsKt___CollectionsKt.getOrNull(S1, 1);
                rectF2 = (RectF) orNull;
            }
            rectF2 = rectF3;
            if (rectF3 != null && rectF2 != null) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(images);
                first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) images);
                arrayList.add(first2);
                listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new List[]{S1, S1});
                List<Float> W12 = W1(listOf2);
                arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(rectF3, rectF2);
                Z1(context, arrayList, arrayListOf2, W12, images);
                return;
            }
            h2(context);
            return;
        }
        if (images.size() == 2) {
            if (S1 != null) {
                firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) S1);
                rectF = (RectF) firstOrNull2;
            } else {
                rectF = null;
            }
            if (S12 != null) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) S12);
                rectF3 = (RectF) firstOrNull;
            }
            if (rectF != null && rectF3 != null) {
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new List[]{S1, S12});
                List<Float> W13 = W1(listOf);
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(rectF, rectF3);
                b2(this, context, images, arrayListOf, W13, null, 16, null);
                return;
            }
            h2(context);
            return;
        }
        w53.b.c("WinkAIAvatarMediaPickerViewModel", "detectFaces error, images size is " + images.size());
    }

    private final String U1() {
        String str = u53.e.f438384a + "/ai_avatar";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str + "/" + System.currentTimeMillis() + ".jpg";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Float> W1(List<? extends List<? extends RectF>> detectFaces) {
        Object firstOrNull;
        Object lastOrNull;
        boolean z16;
        RectF rectF;
        List<Float> listOf;
        Object first;
        Object first2;
        boolean z17;
        Object first3;
        Object first4;
        List<Float> listOf2;
        List<Float> listOf3;
        if (!this.isCoupleStyle) {
            listOf3 = CollectionsKt__CollectionsJVMKt.listOf(Float.valueOf(0.15f));
            return listOf3;
        }
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) detectFaces);
        List list = (List) firstOrNull;
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) detectFaces);
        List list2 = (List) lastOrNull;
        if (list != null && list.size() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (list2 != null && list2.size() == 1) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                first3 = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
                first4 = CollectionsKt___CollectionsKt.first((List<? extends Object>) list2);
                float X1 = X1((RectF) first3, (RectF) first4, 0.15f);
                listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(X1), Float.valueOf(X1)});
                return listOf2;
            }
        }
        RectF rectF2 = null;
        if (list != null) {
            first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) list);
            rectF = (RectF) first2;
        } else {
            rectF = null;
        }
        if (list2 != null) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) list2);
            rectF2 = (RectF) first;
        }
        float X12 = X1(rectF, rectF2, 0.65f);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(X12), Float.valueOf(X12)});
        return listOf;
    }

    private final float X1(RectF firstFaceRect, RectF secondFaceRect, float minRatio) {
        float f16;
        float f17;
        float f18;
        float f19;
        float maxOf;
        if (firstFaceRect != null) {
            f16 = firstFaceRect.width();
        } else {
            f16 = minRatio;
        }
        float[] fArr = new float[4];
        if (firstFaceRect != null) {
            f17 = firstFaceRect.height();
        } else {
            f17 = minRatio;
        }
        fArr[0] = f17;
        if (secondFaceRect != null) {
            f18 = secondFaceRect.width();
        } else {
            f18 = minRatio;
        }
        fArr[1] = f18;
        if (secondFaceRect != null) {
            f19 = secondFaceRect.height();
        } else {
            f19 = minRatio;
        }
        fArr[2] = f19;
        fArr[3] = minRatio;
        maxOf = ComparisonsKt___ComparisonsJvmKt.maxOf(f16, fArr);
        return maxOf;
    }

    private final void Z1(final Context context, final ArrayList<LocalMediaInfo> images, ArrayList<RectF> faceDetectResults, List<Float> cropRatios, final ArrayList<LocalMediaInfo> imagePickerMedias) {
        int collectionSizeOrDefault;
        Object orNull;
        Object orNull2;
        bg bgVar = bg.f302144a;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(images, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        int i3 = 0;
        for (Object obj : images) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            orNull = CollectionsKt___CollectionsKt.getOrNull(faceDetectResults, i3);
            orNull2 = CollectionsKt___CollectionsKt.getOrNull(cropRatios, i3);
            arrayList.add(R1((LocalMediaInfo) obj, (RectF) orNull, (Float) orNull2));
            i3 = i16;
        }
        final ArrayList n3 = bgVar.n(arrayList);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.aiavatar.picker.d
            @Override // java.lang.Runnable
            public final void run() {
                WinkAIAvatarMediaPickerViewModel.e2(WinkAIAvatarMediaPickerViewModel.this, context, n3, imagePickerMedias, images);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b2(WinkAIAvatarMediaPickerViewModel winkAIAvatarMediaPickerViewModel, Context context, ArrayList arrayList, ArrayList arrayList2, List list, ArrayList arrayList3, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            arrayList3 = null;
        }
        winkAIAvatarMediaPickerViewModel.Z1(context, arrayList, arrayList2, list, arrayList3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void c2(WinkAIAvatarMediaPickerViewModel winkAIAvatarMediaPickerViewModel, Context context, ArrayList arrayList, Function1 function1, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            function1 = null;
        }
        winkAIAvatarMediaPickerViewModel.a2(context, arrayList, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d2(WinkAIAvatarMediaPickerViewModel this$0, Context context) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.j2(context, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e2(WinkAIAvatarMediaPickerViewModel this$0, Context context, ArrayList croppedImages, ArrayList arrayList, ArrayList images) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(croppedImages, "$croppedImages");
        Intrinsics.checkNotNullParameter(images, "$images");
        this$0.j2(context, false);
        if (context instanceof Activity) {
            if (this$0.isReplaceScene) {
                Intent intent = new Intent();
                intent.putExtra("selected_local_media_info_list", croppedImages);
                if (arrayList == null) {
                    arrayList = images;
                }
                intent.putExtra("selected_origin_local_media_info_list", arrayList);
                Activity activity = (Activity) context;
                intent.putExtra(QZoneNavigateToQQTransparentFragment.EXTRA_KEY_REQUEST_CODE, activity.getIntent().getIntExtra(QZoneNavigateToQQTransparentFragment.EXTRA_KEY_REQUEST_CODE, -1));
                activity.setResult(-1, intent);
            } else {
                Activity activity2 = (Activity) context;
                Intent intent2 = activity2.getIntent();
                if (arrayList == null) {
                    arrayList = images;
                }
                com.tencent.mobileqq.wink.f.t(context, intent2, croppedImages, arrayList);
                activity2.setResult(-1, new Intent());
            }
            ((Activity) context).finish();
        }
    }

    private final void f2(Context context) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            Serializable serializableExtra = activity.getIntent().getSerializableExtra("selected_style_material");
            if (serializableExtra instanceof MetaMaterial) {
                this.isCoupleStyle = com.tencent.mobileqq.wink.editor.c.Z0((MetaMaterial) serializableExtra);
            }
            if (activity.getIntent().getIntExtra(QZoneNavigateToQQTransparentFragment.EXTRA_KEY_REQUEST_CODE, -1) == 101) {
                this.isReplaceScene = true;
            }
        }
    }

    private final RectF g2(FaceDetectorFeature faceDetectResult) {
        int i3 = faceDetectResult.boundsX;
        float f16 = faceDetectResult.imageWidth;
        int i16 = faceDetectResult.boundsY;
        float f17 = faceDetectResult.imageHeight;
        return new RectF((i3 * 1.0f) / f16, (i16 * 1.0f) / f17, ((i3 + faceDetectResult.boundsW) * 1.0f) / f16, ((faceDetectResult.boundsH + i16) * 1.0f) / f17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i2(WinkAIAvatarMediaPickerViewModel this$0, Context context) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(context, "$context");
        this$0.j2(context, false);
        WinkAIAvatarUtils.f317678a.F(context, "\u8bf7\u4e0a\u4f20\u6b63\u9762\u6e05\u6670\u7684\u4eba\u50cf\u7167\u7247");
    }

    private final void j2(final Context context, boolean show) {
        LifecycleOwner a16;
        Lifecycle lifecycle;
        try {
            if (show) {
                ai aiVar = this.loadingDialog;
                if (aiVar != null) {
                    aiVar.dismiss();
                }
                ai a17 = new ai.b(context).i("\u7167\u7247\u5904\u7406\u4e2d").b(true).h(false).a();
                if (context != null && (a16 = nf2.b.a(context)) != null && (lifecycle = a16.getLifecycle()) != null) {
                    lifecycle.addObserver(new LifecycleObserver() { // from class: com.tencent.mobileqq.wink.aiavatar.picker.WinkAIAvatarMediaPickerViewModel$showLoadingDialog$1$1
                        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                        public final void onDestroy() {
                            ai aiVar2;
                            Activity activity;
                            LifecycleOwner a18;
                            Lifecycle lifecycle2;
                            w53.b.f("WinkAIAvatarMediaPickerViewModel", "loadingDialog dismiss");
                            aiVar2 = WinkAIAvatarMediaPickerViewModel.this.loadingDialog;
                            if (aiVar2 != null) {
                                aiVar2.dismiss();
                            }
                            Context context2 = context;
                            if (context2 instanceof Activity) {
                                activity = (Activity) context2;
                            } else {
                                activity = null;
                            }
                            if (activity != null && (a18 = nf2.b.a(activity)) != null && (lifecycle2 = a18.getLifecycle()) != null) {
                                lifecycle2.removeObserver(this);
                            }
                        }
                    });
                }
                this.loadingDialog = a17;
                if (a17 != null) {
                    a17.setCancelable(false);
                }
                ai aiVar2 = this.loadingDialog;
                if (aiVar2 != null) {
                    aiVar2.show();
                    return;
                }
                return;
            }
            ai aiVar3 = this.loadingDialog;
            if (aiVar3 != null) {
                aiVar3.dismiss();
            }
            this.loadingDialog = null;
        } catch (Throwable th5) {
            w53.b.d("WinkAIAvatarMediaPickerViewModel", "showLoadingDialog error", th5);
        }
    }

    public final void a2(@Nullable final Context context, @NotNull ArrayList<LocalMediaInfo> images, @Nullable Function1<? super Boolean, Unit> callback) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(images, "images");
        if (context == null) {
            w53.b.c("WinkAIAvatarMediaPickerViewModel", "jumpToResultFragment context is null");
            if (callback != null) {
                callback.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        if (!NetworkUtil.isNetworkAvailable()) {
            w53.b.c("WinkAIAvatarMediaPickerViewModel", "jumpToResultFragment network is not available");
            WinkAIAvatarUtils.f317678a.F(context, "\u7f51\u7edc\u4e0d\u53ef\u7528\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
            if (callback != null) {
                callback.invoke(Boolean.FALSE);
                return;
            }
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.aiavatar.picker.c
            @Override // java.lang.Runnable
            public final void run() {
                WinkAIAvatarMediaPickerViewModel.d2(WinkAIAvatarMediaPickerViewModel.this, context);
            }
        });
        f2(context);
        Job job = this.faceDetectJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.b()), new c(CoroutineExceptionHandler.INSTANCE, this, context), null, new WinkAIAvatarMediaPickerViewModel$jumpToResultFragment$2(this, context, images, callback, null), 2, null);
        this.faceDetectJob = launch$default;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkAIAvatarMediaPickerViewModel";
    }

    public final void h2(@NotNull final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.aiavatar.picker.e
            @Override // java.lang.Runnable
            public final void run() {
                WinkAIAvatarMediaPickerViewModel.i2(WinkAIAvatarMediaPickerViewModel.this, context);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Job job = this.faceDetectJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }
}
