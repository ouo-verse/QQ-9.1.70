package com.tencent.icgame.liveroom.impl.room.live.widget;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001-B'\b\u0007\u0012\u0006\u0010'\u001a\u00020&\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010*\u001a\u00020\u0012\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\b\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\u0006J\u0006\u0010\u000e\u001a\u00020\u0006J\u0012\u0010\u0010\u001a\u00020\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\tJ\u0006\u0010\u0011\u001a\u00020\u0006J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001bR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\"\u00a8\u0006."}, d2 = {"Lcom/tencent/icgame/liveroom/impl/room/live/widget/LiveTipsView;", "Landroid/widget/FrameLayout;", "", "f", "Lcom/tencent/icgame/liveroom/impl/room/live/widget/LiveTipsView$a;", "listener", "", "setListener", "i", "", "speed", "j", "e", h.F, "d", "msg", "g", "c", "", "visibility", "setVisibility", "Lcom/tencent/icgame/liveroom/impl/room/live/widget/LiveTipsView$a;", "Landroid/view/View;", "Landroid/view/View;", "mask", "loadingIcon", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "retryBtn", "commonTips", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "loadingTips", "Landroid/widget/LinearLayout;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/LinearLayout;", "loadFailed", "D", "loadingLayout", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class LiveTipsView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final LinearLayout loadFailed;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LinearLayout loadingLayout;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a listener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mask;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View loadingIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView retryBtn;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView commonTips;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView loadingTips;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/icgame/liveroom/impl/room/live/widget/LiveTipsView$a;", "", "", "onRetry", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public interface a {
        void onRetry();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LiveTipsView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(LiveTipsView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a aVar = this$0.listener;
        if (aVar != null) {
            aVar.onRetry();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean f() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            if (getChildAt(i3).getVisibility() == 0) {
                return false;
            }
        }
        return true;
    }

    public final void c() {
        this.commonTips.setVisibility(8);
        this.mask.setVisibility(8);
        if (f()) {
            setVisibility(8);
        }
    }

    public final void d() {
        this.loadFailed.setVisibility(8);
        this.mask.setVisibility(8);
        if (f()) {
            setVisibility(8);
        }
    }

    public final void e() {
        Animatable animatable;
        this.loadingLayout.setVisibility(8);
        this.loadingTips.setText("");
        this.mask.setVisibility(8);
        Object background = this.loadingIcon.getBackground();
        if (background instanceof Animatable) {
            animatable = (Animatable) background;
        } else {
            animatable = null;
        }
        if (animatable != null) {
            animatable.stop();
        }
        if (f()) {
            setVisibility(8);
        }
    }

    public final void g(@Nullable String msg2) {
        setVisibility(0);
        this.mask.setVisibility(0);
        setBackgroundResource(R.color.black);
        this.commonTips.setVisibility(0);
        TextView textView = this.commonTips;
        if (msg2 == null) {
            msg2 = "";
        }
        textView.setText(msg2);
        d();
        e();
    }

    public final void h() {
        setVisibility(0);
        this.mask.setVisibility(0);
        setBackgroundResource(R.color.black);
        this.loadFailed.setVisibility(0);
    }

    public final void i() {
        Animatable animatable;
        setVisibility(0);
        setBackgroundResource(R.color.ajr);
        this.mask.setVisibility(8);
        this.loadingLayout.setVisibility(0);
        Object background = this.loadingIcon.getBackground();
        if (background instanceof Animatable) {
            animatable = (Animatable) background;
        } else {
            animatable = null;
        }
        if (animatable != null) {
            animatable.start();
        }
    }

    public final void j(@NotNull String speed) {
        Intrinsics.checkNotNullParameter(speed, "speed");
        if (this.loadingTips.getVisibility() != 0) {
            return;
        }
        this.loadingTips.setText(speed);
    }

    public final void setListener(@Nullable a listener) {
        this.listener = listener;
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        Animatable animatable;
        super.setVisibility(visibility);
        if (visibility == 8) {
            Object background = this.loadingIcon.getBackground();
            if (background instanceof Animatable) {
                animatable = (Animatable) background;
            } else {
                animatable = null;
            }
            if (animatable != null) {
                animatable.stop();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LiveTipsView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ LiveTipsView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LiveTipsView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.fb7, this);
        View findViewById = findViewById(R.id.i9b);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.retry_btn)");
        TextView textView = (TextView) findViewById;
        this.retryBtn = textView;
        View findViewById2 = findViewById(R.id.enc);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.mask)");
        this.mask = findViewById2;
        View findViewById3 = findViewById(R.id.u2l);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.common_tips)");
        this.commonTips = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.yrp);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.load_failed)");
        this.loadFailed = (LinearLayout) findViewById4;
        View findViewById5 = findViewById(R.id.yt_);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.loading_tips)");
        this.loadingTips = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.ysu);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.loading_icon)");
        this.loadingIcon = findViewById6;
        View findViewById7 = findViewById(R.id.loading_layout);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.loading_layout)");
        this.loadingLayout = (LinearLayout) findViewById7;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.icgame.liveroom.impl.room.live.widget.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveTipsView.b(LiveTipsView.this, view);
            }
        });
    }
}
