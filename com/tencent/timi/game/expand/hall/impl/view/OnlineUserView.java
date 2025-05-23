package com.tencent.timi.game.expand.hall.impl.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.timi.game.widget.MediumBoldTextView;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.YesUserRankingOuterClass$UserRanking;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u001a\u0010\n\u001a\u00020\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR$\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/timi/game/expand/hall/impl/view/OnlineUserView;", "Landroid/widget/FrameLayout;", "", "Ltrpc/yes/common/YesUserRankingOuterClass$UserRanking;", "onlineUserList", "", "a", "Lkotlin/Function1;", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "cb", "setUserClickListener", "Lcom/tencent/timi/game/expand/hall/impl/view/OnlineUserAdapter;", "d", "Lcom/tencent/timi/game/expand/hall/impl/view/OnlineUserAdapter;", "onlineUserAdapter", "Landroid/view/View;", "e", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "contentView", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class OnlineUserView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final OnlineUserAdapter onlineUserAdapter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View contentView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OnlineUserView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public final void a(@NotNull List<YesUserRankingOuterClass$UserRanking> onlineUserList) {
        Intrinsics.checkNotNullParameter(onlineUserList, "onlineUserList");
        this.onlineUserAdapter.submitList(onlineUserList);
    }

    public final void setContentView(@Nullable View view) {
        this.contentView = view;
    }

    public final void setUserClickListener(@NotNull final Function1<? super CommonOuterClass$QQUserId, Unit> cb5) {
        Intrinsics.checkNotNullParameter(cb5, "cb");
        this.onlineUserAdapter.l0(new Function1<CommonOuterClass$QQUserId, Unit>() { // from class: com.tencent.timi.game.expand.hall.impl.view.OnlineUserView$setUserClickListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CommonOuterClass$QQUserId commonOuterClass$QQUserId) {
                invoke2(commonOuterClass$QQUserId);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull CommonOuterClass$QQUserId it) {
                Intrinsics.checkNotNullParameter(it, "it");
                cb5.invoke(it);
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OnlineUserView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ OnlineUserView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OnlineUserView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        OnlineUserAdapter onlineUserAdapter = new OnlineUserAdapter();
        this.onlineUserAdapter = onlineUserAdapter;
        View view = new View(getContext());
        view.setBackgroundResource(R.drawable.lsp);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, fh4.b.b(110));
        layoutParams.gravity = 80;
        layoutParams.bottomMargin = fh4.b.b(477);
        Unit unit = Unit.INSTANCE;
        addView(view, layoutParams);
        View view2 = new View(getContext());
        view2.setBackgroundColor(yn4.c.a(R.color.f158017al3));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, fh4.b.b(477));
        layoutParams2.gravity = 80;
        addView(view2, layoutParams2);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setClickable(true);
        this.contentView = linearLayout;
        linearLayout.setOrientation(1);
        MediumBoldTextView mediumBoldTextView = new MediumBoldTextView(linearLayout.getContext());
        mediumBoldTextView.setText("\u5728\u7ebf\u7528\u6237");
        mediumBoldTextView.setTextSize(1, 16.0f);
        mediumBoldTextView.setTextColor(Color.parseColor("#000000"));
        mediumBoldTextView.setIncludeFontPadding(false);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 1;
        layoutParams3.topMargin = fh4.b.b(24);
        linearLayout.addView(mediumBoldTextView, layoutParams3);
        FrameLayout frameLayout = new FrameLayout(linearLayout.getContext());
        TextView textView = new TextView(frameLayout.getContext());
        textView.setText("\u5b9e\u65f6\u6392\u884c");
        textView.setTextSize(1, 12.0f);
        textView.setTextColor(Color.parseColor("#7D7D7D"));
        textView.setIncludeFontPadding(false);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 19;
        layoutParams4.leftMargin = fh4.b.b(16);
        frameLayout.addView(textView, layoutParams4);
        TextView textView2 = new TextView(frameLayout.getContext());
        textView2.setText("\u8d21\u732e\u503c");
        textView2.setTextSize(1, 12.0f);
        textView2.setTextColor(Color.parseColor("#7D7D7D"));
        textView2.setIncludeFontPadding(false);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 21;
        layoutParams5.rightMargin = fh4.b.b(16);
        frameLayout.addView(textView2, layoutParams5);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, fh4.b.b(36));
        layoutParams6.topMargin = fh4.b.b(6);
        linearLayout.addView(frameLayout, layoutParams6);
        RecyclerView recyclerView = new RecyclerView(linearLayout.getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(onlineUserAdapter);
        recyclerView.setItemAnimator(null);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams7.topMargin = fh4.b.b(6);
        linearLayout.addView(recyclerView, layoutParams7);
        FrameLayout.LayoutParams layoutParams8 = new FrameLayout.LayoutParams(-1, fh4.b.b(LpReportInfoConfig.ACTION_HOMEPAGE_GUEST));
        layoutParams8.gravity = 80;
        addView(linearLayout, layoutParams8);
    }
}
