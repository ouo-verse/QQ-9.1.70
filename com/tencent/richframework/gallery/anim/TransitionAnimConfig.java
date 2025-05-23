package com.tencent.richframework.gallery.anim;

import android.util.SparseArray;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.util.Pair;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0007\u001a\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u001e\u0010\r\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bR&\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u00110\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R(\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R(\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/richframework/gallery/anim/TransitionAnimConfig;", "", "Landroid/view/ViewGroup;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "setRootView", "Landroid/widget/ImageView;", "imageView", "setImageView", "", "type", "", "start", "end", HippyTextInputController.COMMAND_setValue, "getStartValue", "getEndValue", "Landroid/util/SparseArray;", "Landroidx/core/util/Pair;", "mValuePairMap", "Landroid/util/SparseArray;", "<set-?>", "Landroid/view/ViewGroup;", "getRootView", "()Landroid/view/ViewGroup;", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "scaleFactor", UserInfo.SEX_FEMALE, "getScaleFactor", "()F", "setScaleFactor", "(F)V", "<init>", "()V", "Companion", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class TransitionAnimConfig {

    @Nullable
    private ImageView imageView;

    @Nullable
    private ViewGroup rootView;
    private final SparseArray<Pair<Float, Float>> mValuePairMap = new SparseArray<>();
    private float scaleFactor = 1.0f;

    public final float getEndValue(int type) {
        Float f16;
        Pair<Float, Float> pair = this.mValuePairMap.get(type);
        if (pair != null && (f16 = pair.second) != null) {
            Intrinsics.checkNotNullExpressionValue(f16, "pair.second");
            return f16.floatValue();
        }
        return -1;
    }

    @Nullable
    public final ImageView getImageView() {
        return this.imageView;
    }

    @Nullable
    public final ViewGroup getRootView() {
        return this.rootView;
    }

    public final float getStartValue(int type) {
        Float f16;
        Pair<Float, Float> pair = this.mValuePairMap.get(type);
        if (pair != null && (f16 = pair.first) != null) {
            Intrinsics.checkNotNullExpressionValue(f16, "pair.first");
            return f16.floatValue();
        }
        return -1;
    }

    @NotNull
    public final TransitionAnimConfig setImageView(@Nullable ImageView imageView) {
        this.imageView = imageView;
        return this;
    }

    @NotNull
    public final TransitionAnimConfig setRootView(@Nullable ViewGroup rootView) {
        this.rootView = rootView;
        return this;
    }

    @NotNull
    public final TransitionAnimConfig setValue(int type, float start, float end) {
        this.mValuePairMap.put(type, new Pair<>(Float.valueOf(start), Float.valueOf(end)));
        return this;
    }
}
