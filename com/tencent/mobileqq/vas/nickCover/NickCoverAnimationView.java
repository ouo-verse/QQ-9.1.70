package com.tencent.mobileqq.vas.nickCover;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.cachedrawable.dynamicdrawable.api.a;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k;
import com.tencent.cachedrawable.dynamicdrawable.d;
import com.tencent.mobileqq.vas.VasDynamicDrawableCache;
import com.tencent.mobileqq.vas.api.b;
import com.tencent.mobileqq.vas.nickCover.NickCoverAnimationView;
import cooperation.qzone.QZoneClickReport;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\fB\u0017\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u00a2\u0006\u0004\b \u0010!J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u000e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rR\u0014\u0010\u0011\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/vas/nickCover/NickCoverAnimationView;", "Landroid/widget/ImageView;", "Lcom/tencent/mobileqq/vas/api/b;", "", "loop", "", "scene", "Landroid/graphics/drawable/Drawable;", "d", "", "isClipView", "", "a", "Lcom/tencent/mobileqq/vas/nickCover/NickCoverAnimationView$a;", "listener", "setAnimEndListener", "Ljava/lang/String;", "url", "Ljava/util/concurrent/atomic/AtomicBoolean;", "e", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setPlaying", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "isPlaying", "f", "Z", h.F, "Lcom/tencent/mobileqq/vas/nickCover/NickCoverAnimationView$a;", "animEndListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ViewConstructor"})
/* loaded from: classes20.dex */
public final class NickCoverAnimationView extends ImageView implements b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String url;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AtomicBoolean isPlaying;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isClipView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a animEndListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/vas/nickCover/NickCoverAnimationView$a;", "", "", "onAnimEnd", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public interface a {
        void onAnimEnd();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NickCoverAnimationView(@NotNull Context context, @NotNull String url) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
        this.isPlaying = new AtomicBoolean(false);
        setVisibility(8);
    }

    private final Drawable d(final int loop, String scene) {
        a.C1005a h16 = com.tencent.cachedrawable.dynamicdrawable.api.a.a().k(this.url).l(VasDynamicDrawableCache.INSTANCE).h(new Function1<k, Unit>() { // from class: com.tencent.mobileqq.vas.nickCover.NickCoverAnimationView$getAnimationDrawable$drawable$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(k kVar) {
                invoke2(kVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull k it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.y(loop);
                it.I(false);
            }
        });
        if (TextUtils.isEmpty(scene)) {
            scene = QZoneClickReport.ClickReportConfig.SOURCE_FROM_AIO;
        }
        FastDynamicDrawable a16 = h16.i(scene).a();
        a16.c0(new Function1<d, Unit>() { // from class: com.tencent.mobileqq.vas.nickCover.NickCoverAnimationView$getAnimationDrawable$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/vas/nickCover/NickCoverAnimationView$getAnimationDrawable$1$a", "Lcom/tencent/cachedrawable/dynamicdrawable/d$a;", "", "onEnd", "onStart", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes20.dex */
            public static final class a implements d.a {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ NickCoverAnimationView f310074a;

                a(NickCoverAnimationView nickCoverAnimationView) {
                    this.f310074a = nickCoverAnimationView;
                }

                @Override // com.tencent.cachedrawable.dynamicdrawable.d.a
                public void onEnd() {
                    NickCoverAnimationView.a aVar;
                    this.f310074a.getIsPlaying().set(false);
                    this.f310074a.setVisibility(8);
                    aVar = this.f310074a.animEndListener;
                    if (aVar != null) {
                        aVar.onAnimEnd();
                    }
                }

                @Override // com.tencent.cachedrawable.dynamicdrawable.d.a
                public void onStart() {
                    this.f310074a.getIsPlaying().set(true);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(d dVar) {
                invoke2(dVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull d it) {
                boolean z16;
                Intrinsics.checkNotNullParameter(it, "it");
                z16 = NickCoverAnimationView.this.isClipView;
                if (z16) {
                    NickCoverAnimationView.this.setScaleType(ImageView.ScaleType.MATRIX);
                    Matrix matrix = new Matrix();
                    float height = (NickCoverAnimationView.this.getHeight() * 1.0f) / it.getHeight();
                    matrix.setScale(height, height);
                    matrix.postTranslate(0.0f, 0.0f);
                    NickCoverAnimationView.this.setImageMatrix(matrix);
                } else {
                    NickCoverAnimationView.this.setScaleType(ImageView.ScaleType.FIT_CENTER);
                }
                it.getHeight();
                it.d(new a(NickCoverAnimationView.this));
            }
        });
        return a16;
    }

    @Override // com.tencent.mobileqq.vas.api.b
    public void a(int loop, boolean isClipView, @NotNull String scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        if (getVisibility() != 0) {
            setVisibility(0);
        }
        if (!this.isPlaying.compareAndSet(false, true)) {
            return;
        }
        if (getDrawable() != null) {
            Drawable drawable = getDrawable();
            Intrinsics.checkNotNull(drawable, "null cannot be cast to non-null type com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable");
            ((FastDynamicDrawable) drawable).stop();
        }
        setVisibility(0);
        this.isClipView = isClipView;
        setImageDrawable(d(loop, scene));
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final AtomicBoolean getIsPlaying() {
        return this.isPlaying;
    }

    public final void setAnimEndListener(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.animEndListener = listener;
    }

    public final void setPlaying(@NotNull AtomicBoolean atomicBoolean) {
        Intrinsics.checkNotNullParameter(atomicBoolean, "<set-?>");
        this.isPlaying = atomicBoolean;
    }
}
