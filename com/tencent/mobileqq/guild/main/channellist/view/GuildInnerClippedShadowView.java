package com.tencent.mobileqq.guild.main.channellist.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import com.qq.e.comm.managers.plugin.PM;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 %2\u00020\u0001:\u0001\u0014B\u0011\b\u0002\u0012\u0006\u0010\"\u001a\u00020!\u00a2\u0006\u0004\b#\u0010$J6\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0014J0\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002H\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u001f\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/main/channellist/view/GuildInnerClippedShadowView;", "Landroid/view/ViewGroup;", "", "left", "top", "right", "bottom", "", "radiusLeftTop", "elevation", "", "f", "Landroid/graphics/Canvas;", PM.CANVAS, "dispatchDraw", "", "changed", "l", "t", "r", "b", "onLayout", "Landroid/graphics/Outline;", "d", "Landroid/graphics/Outline;", "outline", "Landroid/graphics/Path;", "e", "Landroid/graphics/Path;", "clipPath", "Landroid/view/View;", "Landroid/view/View;", "shadowView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", h.F, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildInnerClippedShadowView extends ViewGroup {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private static WeakReference<GuildInnerClippedShadowView> f227128i;

    /* renamed from: m, reason: collision with root package name */
    private static int f227129m;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Outline outline;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Path clipPath;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View shadowView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/main/channellist/view/GuildInnerClippedShadowView$a", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@NotNull View view, @NotNull Outline outline) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            outline.set(GuildInnerClippedShadowView.this.outline);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/main/channellist/view/GuildInnerClippedShadowView$b;", "", "Landroid/graphics/Canvas;", PM.CANVAS, "Landroid/graphics/Path;", "path", "", "b", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/main/channellist/view/GuildInnerClippedShadowView;", "c", "", "lastContextId", "I", "Lmqq/util/WeakReference;", "lastShadowView", "Lmqq/util/WeakReference;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.main.channellist.view.GuildInnerClippedShadowView$b, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(Canvas canvas, Path path) {
            if (Build.VERSION.SDK_INT >= 26) {
                canvas.clipOutPath(path);
            } else {
                canvas.clipPath(path, Region.Op.DIFFERENCE);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @NotNull
        public final GuildInnerClippedShadowView c(@NotNull Context context) {
            GuildInnerClippedShadowView guildInnerClippedShadowView;
            Intrinsics.checkNotNullParameter(context, "context");
            int identityHashCode = System.identityHashCode(context);
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (identityHashCode != GuildInnerClippedShadowView.f227129m) {
                GuildInnerClippedShadowView.f227129m = identityHashCode;
                GuildInnerClippedShadowView.f227128i = new WeakReference(new GuildInnerClippedShadowView(context, defaultConstructorMarker));
            }
            WeakReference weakReference = GuildInnerClippedShadowView.f227128i;
            if (weakReference != null) {
                guildInnerClippedShadowView = (GuildInnerClippedShadowView) weakReference.get();
            } else {
                guildInnerClippedShadowView = null;
            }
            if (guildInnerClippedShadowView == null) {
                GuildInnerClippedShadowView guildInnerClippedShadowView2 = new GuildInnerClippedShadowView(context, defaultConstructorMarker);
                GuildInnerClippedShadowView.f227128i = new WeakReference(guildInnerClippedShadowView2);
                return guildInnerClippedShadowView2;
            }
            return guildInnerClippedShadowView;
        }

        Companion() {
        }
    }

    public /* synthetic */ GuildInnerClippedShadowView(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (!canvas.isHardwareAccelerated()) {
            return;
        }
        canvas.save();
        INSTANCE.b(canvas, this.clipPath);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public final void f(int left, int top, int right, int bottom, float radiusLeftTop, float elevation) {
        List listOf;
        float[] floatArray;
        this.clipPath.rewind();
        Path path = this.clipPath;
        RectF rectF = new RectF(left, top, right, bottom);
        Float valueOf = Float.valueOf(0.0f);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(radiusLeftTop), Float.valueOf(radiusLeftTop), valueOf, valueOf, valueOf, valueOf, valueOf, valueOf});
        floatArray = CollectionsKt___CollectionsKt.toFloatArray(listOf);
        path.addRoundRect(rectF, floatArray, Path.Direction.CW);
        this.outline.setRoundRect(0, 0, right - left, bottom - top, radiusLeftTop);
        this.shadowView.layout(left, top, right, bottom);
        this.shadowView.setElevation(elevation);
        if (Build.VERSION.SDK_INT >= 28) {
            this.shadowView.setOutlineAmbientShadowColor(Color.parseColor("#90000000"));
            this.shadowView.setOutlineSpotShadowColor(Color.parseColor("#90000000"));
        }
        this.shadowView.invalidate();
    }

    GuildInnerClippedShadowView(Context context) {
        super(context);
        Outline outline = new Outline();
        outline.setAlpha(0.8f);
        this.outline = outline;
        this.clipPath = new Path();
        View view = new View(context);
        this.shadowView = view;
        addView(view);
        view.setOutlineProvider(new a());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l3, int t16, int r16, int b16) {
    }
}
