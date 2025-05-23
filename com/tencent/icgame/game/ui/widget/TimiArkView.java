package com.tencent.icgame.game.ui.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.open.ArkView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 .2\u00020\u0001:\u0001/B1\b\u0007\u0012\u0006\u0010*\u001a\u00020)\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010+\u001a\u00020\f\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u00060"}, d2 = {"Lcom/tencent/icgame/game/ui/widget/TimiArkView;", "Landroid/widget/FrameLayout;", "", "e", "g", "c", "Landroidx/lifecycle/Lifecycle$Event;", "event", "d", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "b", "", "borderType", "setBorderType", "Landroid/util/AttributeSet;", "Landroid/util/AttributeSet;", "getAttrs", "()Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "Ljava/lang/String;", "mUniqueId", "f", "Landroidx/lifecycle/LifecycleOwner;", "mLifecycleOwner", "Lcom/tencent/ark/open/ArkView;", tl.h.F, "Lcom/tencent/ark/open/ArkView;", "mArkView", "i", "Landroid/widget/FrameLayout;", "mLoadingView", "Landroidx/lifecycle/LifecycleEventObserver;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LifecycleEventObserver;", "mLifecycleObserver", "Lcom/tencent/ark/ArkViewImplement$LoadCallback;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/ark/ArkViewImplement$LoadCallback;", "mCurrentCallback", "Landroid/content/Context;", "context", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILandroidx/lifecycle/LifecycleOwner;)V", "D", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public class TimiArkView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private ArkViewImplement.LoadCallback mCurrentCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final AttributeSet attrs;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String mUniqueId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LifecycleOwner mLifecycleOwner;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArkView mArkView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FrameLayout mLoadingView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleEventObserver mLifecycleObserver;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes7.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f115947a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f115947a = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TimiArkView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, null, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void c() {
        removeView(this.mArkView);
        this.mArkView = new ArkView(getContext(), this.attrs);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        this.mArkView.setLayoutParams(layoutParams);
        addView(this.mArkView, layoutParams);
    }

    private final void d(Lifecycle.Event event) {
        Lifecycle lifecycle;
        int i3 = b.f115947a[event.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    this.mArkView.onDestroy();
                    LifecycleOwner lifecycleOwner = this.mLifecycleOwner;
                    if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
                        lifecycle.removeObserver(this.mLifecycleObserver);
                    }
                    this.mCurrentCallback = null;
                    return;
                }
                return;
            }
            this.mArkView.onPause();
            return;
        }
        this.mArkView.onResume();
    }

    private final void e() {
        c();
        addView(this.mLoadingView, new FrameLayout.LayoutParams(com.tencent.icgame.game.utils.a.a(270), com.tencent.icgame.game.utils.a.a(158)));
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R.drawable.common_loading6);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.tencent.icgame.game.utils.a.a(34), com.tencent.icgame.game.utils.a.a(34));
        layoutParams.gravity = 17;
        this.mLoadingView.addView(imageView, layoutParams);
        uu0.b.c(uu0.b.a(this.mLoadingView, Color.parseColor("#D8DAE0")), com.tencent.icgame.game.utils.a.b(6), com.tencent.icgame.game.utils.a.b(6), com.tencent.icgame.game.utils.a.b(6), com.tencent.icgame.game.utils.a.b(6));
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(TimiArkView this$0, LifecycleOwner owner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(event, "event");
        this$0.d(event);
    }

    private final void g() {
        this.mLoadingView.setVisibility(8);
        this.mArkView.setVisibility(4);
    }

    public final void b(@NotNull LifecycleOwner lifecycleOwner) {
        Lifecycle lifecycle;
        Lifecycle lifecycle2;
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        LifecycleOwner lifecycleOwner2 = this.mLifecycleOwner;
        if (lifecycleOwner2 != null && (lifecycle2 = lifecycleOwner2.getLifecycle()) != null) {
            lifecycle2.removeObserver(this.mLifecycleObserver);
        }
        this.mLifecycleOwner = lifecycleOwner;
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.addObserver(this.mLifecycleObserver);
        }
    }

    public final void setBorderType(int borderType) {
        this.mArkView.setBorderType(borderType);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TimiArkView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, null, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ TimiArkView(Context context, AttributeSet attributeSet, int i3, LifecycleOwner lifecycleOwner, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, attributeSet, (i16 & 4) != 0 ? 0 : i3, (i16 & 8) != 0 ? null : lifecycleOwner);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TimiArkView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, @Nullable LifecycleOwner lifecycleOwner) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.attrs = attributeSet;
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        this.mUniqueId = uuid;
        this.mArkView = new ArkView(context, attributeSet);
        this.mLoadingView = new FrameLayout(context, attributeSet, i3);
        this.mLifecycleObserver = new LifecycleEventObserver() { // from class: com.tencent.icgame.game.ui.widget.p
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner2, Lifecycle.Event event) {
                TimiArkView.f(TimiArkView.this, lifecycleOwner2, event);
            }
        };
        com.tencent.icgame.game.utils.g.h("ICGameArkView_", "this:" + this + ", mUniqueId:" + uuid);
        if (lifecycleOwner != null) {
            b(lifecycleOwner);
        }
        e();
    }
}
