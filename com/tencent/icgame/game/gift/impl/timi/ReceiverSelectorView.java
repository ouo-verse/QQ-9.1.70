package com.tencent.icgame.game.gift.impl.timi;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.tencent.icgame.game.userinfo.api.view.AvatarTextView;
import com.tencent.icgame.trpc.yes.common.CommonOuterClass$QQUserId;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import cy0.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uu0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/icgame/game/gift/impl/timi/ReceiverSelectorView;", "Landroid/widget/RelativeLayout;", "", NodeProps.VISIBLE, "", "setCertainReceiverNameVisibility", "", "receiverName", "setCertainReceiverName", "Lcom/tencent/icgame/trpc/yes/common/CommonOuterClass$QQUserId;", "userId", "Landroidx/recyclerview/widget/RecyclerView;", "d", "Landroidx/recyclerview/widget/RecyclerView;", "rv", "Lcom/tencent/icgame/game/userinfo/api/view/AvatarTextView;", "e", "Lcom/tencent/icgame/game/userinfo/api/view/AvatarTextView;", "certainReceiverNameTv", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class ReceiverSelectorView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView rv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AvatarTextView certainReceiverNameTv;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReceiverSelectorView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public final void setCertainReceiverName(@NotNull String receiverName) {
        Intrinsics.checkNotNullParameter(receiverName, "receiverName");
        AvatarTextView avatarTextView = this.certainReceiverNameTv;
        if (avatarTextView != null) {
            avatarTextView.h();
        }
        AvatarTextView avatarTextView2 = this.certainReceiverNameTv;
        if (avatarTextView2 == null) {
            return;
        }
        avatarTextView2.setText(receiverName);
    }

    public final void setCertainReceiverNameVisibility(boolean visible) {
        int i3;
        AvatarTextView avatarTextView = this.certainReceiverNameTv;
        if (avatarTextView != null) {
            if (visible) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            avatarTextView.setVisibility(i3);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReceiverSelectorView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ ReceiverSelectorView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    public final void setCertainReceiverName(@NotNull CommonOuterClass$QQUserId userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        AvatarTextView avatarTextView = this.certainReceiverNameTv;
        if (avatarTextView != null) {
            avatarTextView.setUserId(userId);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReceiverSelectorView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        TextView textView = new TextView(getContext());
        textView.setId(R.id.f70813mg);
        textView.setText(b.c(R.string.zm6));
        textView.setTextColor(Color.parseColor("#66FFFFFF"));
        textView.setTextSize(1, 12.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.leftMargin = a.b(16);
        Unit unit = Unit.INSTANCE;
        addView(textView, layoutParams);
        RecyclerView recyclerView = new RecyclerView(getContext());
        recyclerView.setId(R.id.f70823mh);
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        SimpleItemAnimator simpleItemAnimator = itemAnimator instanceof SimpleItemAnimator ? (SimpleItemAnimator) itemAnimator : null;
        if (simpleItemAnimator != null) {
            simpleItemAnimator.setSupportsChangeAnimations(false);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
        this.rv = recyclerView;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, a.b(58));
        layoutParams2.addRule(1, R.id.f70813mg);
        layoutParams2.addRule(15);
        layoutParams2.leftMargin = a.b(10);
        layoutParams2.rightMargin = a.b(10);
        addView(recyclerView, layoutParams2);
        AvatarTextView avatarTextView = new AvatarTextView(getContext());
        avatarTextView.setId(R.id.f70803mf);
        this.certainReceiverNameTv = avatarTextView;
        avatarTextView.setTextColor(Color.parseColor("#FFFFFF"));
        avatarTextView.setTextSize(1, 12.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(5, R.id.f70823mh);
        layoutParams3.addRule(15);
        layoutParams3.leftMargin = a.b(44);
        addView(avatarTextView, layoutParams3);
    }
}
