package com.tencent.richframework.gallery.anim;

import android.util.SparseArray;
import android.view.View;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import java.lang.ref.WeakReference;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0004R \u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR \u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/richframework/gallery/anim/RFWTransitionHelper;", "", "Lcom/tencent/richframework/gallery/anim/RFWTransitionHelper$TransAnimCreator;", "generator", "", "registerTransitionBeanCreator", "key", "getTransitionBeanCreator", "Landroid/util/SparseArray;", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "mPrePageViews", "Landroid/util/SparseArray;", "mTransitionBeanGenerators", "<init>", "()V", "TransAnimCreator", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class RFWTransitionHelper {

    @NotNull
    public static final RFWTransitionHelper INSTANCE = new RFWTransitionHelper();
    private static final SparseArray<WeakReference<View>> mPrePageViews = new SparseArray<>();
    private static final SparseArray<WeakReference<TransAnimCreator>> mTransitionBeanGenerators = new SparseArray<>();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/richframework/gallery/anim/RFWTransitionHelper$TransAnimCreator;", "", "generateTransAnimBean", "Lcom/tencent/richframework/gallery/anim/RFWTransAnimBean;", "uuid", "Ljava/util/UUID;", "id", "", "updateOriginContainer", "", ViewStickEventHelper.IS_SHOW, "", "function-gallery_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes25.dex */
    public interface TransAnimCreator {
        @Nullable
        RFWTransAnimBean generateTransAnimBean(@NotNull UUID uuid, @NotNull String id5);

        void updateOriginContainer(@NotNull UUID uuid, @NotNull String id5, boolean isShow);
    }

    RFWTransitionHelper() {
    }

    @Nullable
    public final TransAnimCreator getTransitionBeanCreator(int key) {
        WeakReference<TransAnimCreator> weakReference = mTransitionBeanGenerators.get(key);
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final int registerTransitionBeanCreator(@NotNull TransAnimCreator generator) {
        Intrinsics.checkNotNullParameter(generator, "generator");
        mTransitionBeanGenerators.put(generator.hashCode(), new WeakReference<>(generator));
        return generator.hashCode();
    }
}
