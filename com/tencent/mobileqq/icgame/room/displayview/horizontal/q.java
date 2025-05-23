package com.tencent.mobileqq.icgame.room.displayview.horizontal;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.icgame.liveroom.impl.room.live.widget.BottomControllerView;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\b\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u001c\u0010\u0013\u001a\n \u0010*\u0004\u0018\u00010\u000f0\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/displayview/horizontal/q;", "", "", "text", "", "a", "Lcom/tencent/icgame/liveroom/impl/room/live/widget/BottomControllerView;", "Lcom/tencent/icgame/liveroom/impl/room/live/widget/BottomControllerView;", "bottomView", "Landroid/view/View$OnClickListener;", "b", "Landroid/view/View$OnClickListener;", "fullScreenClick", "c", "definitionClick", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "d", "Landroid/widget/TextView;", "definitionTv", "<init>", "(Lcom/tencent/icgame/liveroom/impl/room/live/widget/BottomControllerView;Landroid/view/View$OnClickListener;Landroid/view/View$OnClickListener;)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BottomControllerView bottomView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View.OnClickListener fullScreenClick;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View.OnClickListener definitionClick;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final TextView definitionTv;

    public q(@NotNull BottomControllerView bottomView, @NotNull View.OnClickListener fullScreenClick, @NotNull View.OnClickListener definitionClick) {
        Intrinsics.checkNotNullParameter(bottomView, "bottomView");
        Intrinsics.checkNotNullParameter(fullScreenClick, "fullScreenClick");
        Intrinsics.checkNotNullParameter(definitionClick, "definitionClick");
        this.bottomView = bottomView;
        this.fullScreenClick = fullScreenClick;
        this.definitionClick = definitionClick;
        TextView textView = (TextView) bottomView.findViewById(R.id.ufs);
        this.definitionTv = textView;
        textView.setOnClickListener(definitionClick);
        ((ImageView) bottomView.findViewById(R.id.cpt)).setOnClickListener(fullScreenClick);
    }

    public final void a(@Nullable String text) {
        if (text == null) {
            this.definitionTv.setVisibility(8);
            this.definitionTv.setText((CharSequence) null);
        } else {
            this.definitionTv.setVisibility(0);
            this.definitionTv.setText(text);
        }
    }
}
