package com.tencent.robot.aio.playvideo;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.superplayer.api.ISuperPlayer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/ImageView;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class PlayVideoVB$mVoiceBtn$2 extends Lambda implements Function0<ImageView> {
    final /* synthetic */ PlayVideoVB this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayVideoVB$mVoiceBtn$2(PlayVideoVB playVideoVB) {
        super(0);
        this.this$0 = playVideoVB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(PlayVideoVB this$0, ImageView this_apply, View view) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        ISuperPlayer iSuperPlayer = this$0.mVideoPlayer;
        if (iSuperPlayer != null && iSuperPlayer.isOutputMute()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ISuperPlayer iSuperPlayer2 = this$0.mVideoPlayer;
            if (iSuperPlayer2 != null) {
                iSuperPlayer2.setOutputMute(false);
            }
            this_apply.setImageResource(R.drawable.k6q);
            ViewUtils viewUtils = ViewUtils.f352270a;
            this_apply.setPadding(viewUtils.a(8.75f), viewUtils.b(6), viewUtils.a(3.25f), viewUtils.b(6));
        } else {
            ISuperPlayer iSuperPlayer3 = this$0.mVideoPlayer;
            if (iSuperPlayer3 != null) {
                iSuperPlayer3.setOutputMute(true);
            }
            this_apply.setImageResource(R.drawable.k6p);
            ViewUtils viewUtils2 = ViewUtils.f352270a;
            this_apply.setPadding(viewUtils2.b(6), viewUtils2.b(6), viewUtils2.b(6), viewUtils2.b(6));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final ImageView invoke() {
        final ImageView imageView = new ImageView(this.this$0.getMContext());
        final PlayVideoVB playVideoVB = this.this$0;
        imageView.setBackgroundResource(R.drawable.k6n);
        imageView.setImageResource(R.drawable.k6q);
        ViewUtils viewUtils = ViewUtils.f352270a;
        imageView.setPadding(viewUtils.a(8.75f), viewUtils.b(6), viewUtils.a(3.25f), viewUtils.b(6));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(viewUtils.a(34.0f), viewUtils.a(34.0f));
        layoutParams.topMargin = viewUtils.b(70);
        layoutParams.rightMargin = viewUtils.b(100);
        layoutParams.gravity = 8388613;
        imageView.setLayoutParams(layoutParams);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.robot.aio.playvideo.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlayVideoVB$mVoiceBtn$2.b(PlayVideoVB.this, imageView, view);
            }
        });
        return imageView;
    }
}
