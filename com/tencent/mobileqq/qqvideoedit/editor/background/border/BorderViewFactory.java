package com.tencent.mobileqq.qqvideoedit.editor.background.border;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qqvideoedit.editor.background.border.EditViewContext;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00072\u00020\u0001:\u0001\u000bB\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R0\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006`\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/BorderViewFactory;", "", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/EditViewContext$EditScene;", "scene", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/EditViewContext;", "context", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/c;", "b", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "a", "Ljava/util/HashMap;", "borderViewCacheMap", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class BorderViewFactory {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Lazy<BorderViewFactory> f275215c;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<String, c> borderViewCacheMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/BorderViewFactory$a;", "", "Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/BorderViewFactory;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/qqvideoedit/editor/background/border/BorderViewFactory;", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqvideoedit.editor.background.border.BorderViewFactory$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final BorderViewFactory a() {
            return (BorderViewFactory) BorderViewFactory.f275215c.getValue();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f275217a;

        static {
            int[] iArr = new int[EditViewContext.EditScene.values().length];
            try {
                iArr[EditViewContext.EditScene.MULTIMEDIA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f275217a = iArr;
        }
    }

    static {
        Lazy<BorderViewFactory> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<BorderViewFactory>() { // from class: com.tencent.mobileqq.qqvideoedit.editor.background.border.BorderViewFactory$Companion$instance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final BorderViewFactory invoke() {
                return new BorderViewFactory(null);
            }
        });
        f275215c = lazy;
    }

    public /* synthetic */ BorderViewFactory(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Nullable
    public final c b(@NotNull EditViewContext.EditScene scene, @NotNull EditViewContext context) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(context, "context");
        if (b.f275217a[scene.ordinal()] == 1) {
            return new MultiMediaBorderView(context.getContext(), null, 0, 6, null);
        }
        return null;
    }

    BorderViewFactory() {
        this.borderViewCacheMap = new HashMap<>();
    }
}
