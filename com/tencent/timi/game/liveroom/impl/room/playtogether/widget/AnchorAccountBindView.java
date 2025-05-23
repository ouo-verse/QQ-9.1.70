package com.tencent.timi.game.liveroom.impl.room.playtogether.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.timi.game.liveroom.impl.room.playtogether.presenter.AnchorPlayTogetherPresenter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J$\u0010\u000e\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\fR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/playtogether/widget/AnchorAccountBindView;", "Landroid/widget/FrameLayout;", "", "hasBind", "", "a", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/presenter/AnchorPlayTogetherPresenter;", "presenter", "setPresenter", "", "partition", "roleName", "Lkotlin/Function0;", "cb", "setRoleAccountInfo", "Lnr2/c;", "d", "Lnr2/c;", "binding", "e", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/presenter/AnchorPlayTogetherPresenter;", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class AnchorAccountBindView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final nr2.c binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AnchorPlayTogetherPresenter presenter;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorAccountBindView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    private final void a(boolean hasBind) {
        String str;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        String str2;
        String str3;
        int i3;
        int i16;
        int i17;
        if (hasBind) {
            str = "#0F9C9CFF";
        } else {
            str = "#26FF6767";
        }
        setBackgroundColor(Color.parseColor(str));
        ViewGroup.LayoutParams layoutParams = this.binding.f421039e.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams != null) {
            if (hasBind) {
                i17 = 16;
            } else {
                i17 = 42;
            }
            marginLayoutParams.leftMargin = fh4.b.b(i17);
        }
        TextView textView = this.binding.f421039e;
        if (hasBind) {
            str2 = "#878B99";
        } else {
            str2 = "#FF7191";
        }
        textView.setTextColor(Color.parseColor(str2));
        TextView textView2 = this.binding.f421039e;
        if (hasBind) {
            str3 = "\u76f4\u64ad\u738b\u8005\u5e10\u53f7";
        } else {
            str3 = "\u9700\u6388\u6743\u5e76\u7ed1\u5b9a\u738b\u8005\u5e10\u53f7";
        }
        textView2.setText(str3);
        ImageView imageView = this.binding.f421038d;
        int i18 = 8;
        if (hasBind) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        imageView.setVisibility(i3);
        ImageView imageView2 = this.binding.f421037c;
        if (hasBind) {
            i16 = R.drawable.f162521ov0;
        } else {
            i16 = R.drawable.f162523ov2;
        }
        imageView2.setImageResource(i16);
        LinearLayout linearLayout = this.binding.f421036b;
        if (hasBind) {
            i18 = 0;
        }
        linearLayout.setVisibility(i18);
    }

    public final void setPresenter(@NotNull AnchorPlayTogetherPresenter presenter) {
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        this.presenter = presenter;
    }

    public final void setRoleAccountInfo(@NotNull String partition, @NotNull String roleName, @NotNull Function0<Unit> cb5) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(partition, "partition");
        Intrinsics.checkNotNullParameter(roleName, "roleName");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        if (partition.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (roleName.length() == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                a(false);
                cb5.invoke();
            }
        }
        a(true);
        this.binding.f421040f.setText(partition);
        this.binding.f421041g.setText(roleName);
        cb5.invoke();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorAccountBindView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ AnchorAccountBindView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorAccountBindView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        nr2.c f16 = nr2.c.f(LayoutInflater.from(getContext()), this);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.from(context), this)");
        this.binding = f16;
    }
}
