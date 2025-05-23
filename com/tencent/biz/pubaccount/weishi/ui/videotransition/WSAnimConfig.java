package com.tencent.biz.pubaccount.weishi.ui.videotransition;

import android.view.View;
import android.widget.ImageView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00052\u00020\u0001:\u0002\u0006\u0018BU\u0012:\u0010\u000b\u001a6\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\b0\u0007j\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\b`\t\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002RH\u0010\u000b\u001a6\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\b0\u0007j\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\b`\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\nR\u0017\u0010\u0011\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0013\u001a\u0004\b\r\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/ui/videotransition/WSAnimConfig;", "", "", "valueType", "", "d", "a", "Ljava/util/HashMap;", "Lkotlin/Pair;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "valuePairMap", "Landroid/view/View;", "b", "Landroid/view/View;", "c", "()Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "ivCoverForAnim", "<init>", "(Ljava/util/HashMap;Landroid/view/View;Landroid/widget/ImageView;)V", "Companion", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class WSAnimConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final HashMap<Integer, Pair<Float, Float>> valuePairMap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final View rootView;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ImageView ivCoverForAnim;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u001e\u0010\r\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nJ\u0006\u0010\u000f\u001a\u00020\u000eR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0011RH\u0010\u0016\u001a6\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u00130\u0012j\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0013`\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/ui/videotransition/WSAnimConfig$a;", "", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "c", "Landroid/widget/ImageView;", "ivCoverForAnim", "b", "", "valueType", "", "start", "end", "d", "Lcom/tencent/biz/pubaccount/weishi/ui/videotransition/WSAnimConfig;", "a", "Landroid/view/View;", "Landroid/widget/ImageView;", "Ljava/util/HashMap;", "Lkotlin/Pair;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "valuePairMap", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private View rootView;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private ImageView ivCoverForAnim;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final HashMap<Integer, Pair<Float, Float>> valuePairMap = new HashMap<>();

        public final WSAnimConfig a() {
            HashMap<Integer, Pair<Float, Float>> hashMap = this.valuePairMap;
            View view = this.rootView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
                view = null;
            }
            return new WSAnimConfig(hashMap, view, this.ivCoverForAnim);
        }

        public final a b(ImageView ivCoverForAnim) {
            this.ivCoverForAnim = ivCoverForAnim;
            return this;
        }

        public final a c(View rootView) {
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            this.rootView = rootView;
            return this;
        }

        public final a d(int valueType, float start, float end) {
            this.valuePairMap.put(Integer.valueOf(valueType), TuplesKt.to(Float.valueOf(start), Float.valueOf(end)));
            return this;
        }
    }

    public WSAnimConfig(HashMap<Integer, Pair<Float, Float>> valuePairMap, View rootView, ImageView imageView) {
        Intrinsics.checkNotNullParameter(valuePairMap, "valuePairMap");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.valuePairMap = valuePairMap;
        this.rootView = rootView;
        this.ivCoverForAnim = imageView;
    }

    public final float a(int valueType) {
        Pair<Float, Float> pair = this.valuePairMap.get(Integer.valueOf(valueType));
        Intrinsics.checkNotNull(pair);
        return pair.getSecond().floatValue();
    }

    /* renamed from: b, reason: from getter */
    public final ImageView getIvCoverForAnim() {
        return this.ivCoverForAnim;
    }

    /* renamed from: c, reason: from getter */
    public final View getRootView() {
        return this.rootView;
    }

    public final float d(int valueType) {
        Pair<Float, Float> pair = this.valuePairMap.get(Integer.valueOf(valueType));
        Intrinsics.checkNotNull(pair);
        return pair.getFirst().floatValue();
    }
}
