package com.tencent.robot.aio.playvideo;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.superplayer.api.ISuperPlayer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/TextView;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class PlayVideoVB$mSkipBtn$2 extends Lambda implements Function0<TextView> {
    final /* synthetic */ PlayVideoVB this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayVideoVB$mSkipBtn$2(PlayVideoVB playVideoVB) {
        super(0);
        this.this$0 = playVideoVB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(PlayVideoVB this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ISuperPlayer iSuperPlayer = this$0.mVideoPlayer;
        if (iSuperPlayer != null) {
            iSuperPlayer.stop();
        }
        this$0.w1("skip");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final TextView invoke() {
        TextView textView = new TextView(this.this$0.getMContext());
        final PlayVideoVB playVideoVB = this.this$0;
        textView.setBackgroundResource(R.drawable.k6o);
        textView.setText(HardCodeUtil.qqStr(R.string.f227856s6));
        textView.setTextColor(playVideoVB.getMContext().getColorStateList(R.color.bvg));
        textView.setTextSize(14.0f);
        textView.setGravity(1);
        ViewUtils viewUtils = ViewUtils.f352270a;
        textView.setPadding(0, viewUtils.a(8.0f), 0, viewUtils.a(7.0f));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(viewUtils.a(62.0f), viewUtils.a(34.0f));
        layoutParams.topMargin = viewUtils.b(70);
        layoutParams.rightMargin = viewUtils.b(24);
        layoutParams.gravity = 8388613;
        textView.setLayoutParams(layoutParams);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.aio.playvideo.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlayVideoVB$mSkipBtn$2.b(PlayVideoVB.this, view);
            }
        });
        return textView;
    }
}
