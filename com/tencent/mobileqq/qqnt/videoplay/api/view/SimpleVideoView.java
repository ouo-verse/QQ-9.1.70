package com.tencent.mobileqq.qqnt.videoplay.api.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqnt.videoplay.api.component.BaseVideoView;
import com.tencent.mobileqq.qqnt.videoplay.api.component.PlayControlView;
import com.tencent.mobileqq.qqnt.videoplay.api.component.ProgressView;
import com.tencent.mobileqq.qqnt.videoplay.api.param.c;
import com.tencent.qqnt.util.view.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u00a2\u0006\u0004\b\u0012\u0010\u0016B#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0012\u0010\u0019J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/qqnt/videoplay/api/view/SimpleVideoView;", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/qqnt/videoplay/api/param/c;", "params", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "", "a", "b", "", "needRecordPosition", "c", "Lcom/tencent/mobileqq/qqnt/videoplay/api/component/BaseVideoView;", "d", "Lcom/tencent/mobileqq/qqnt/videoplay/api/component/BaseVideoView;", "videoView", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "videoplay_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class SimpleVideoView extends RelativeLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BaseVideoView videoView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleVideoView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    public final void a(@NotNull Context context, @NotNull c params, @NotNull CoroutineScope coroutineScope) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, context, params, coroutineScope);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        BaseVideoView baseVideoView = new BaseVideoView(context, params, coroutineScope);
        this.videoView = baseVideoView;
        addView(baseVideoView);
        PlayControlView playControlView = new PlayControlView(context, null, 0, 6, null);
        playControlView.setId(R.id.f1183073s);
        BaseVideoView baseVideoView2 = this.videoView;
        Intrinsics.checkNotNull(baseVideoView2);
        playControlView.l(baseVideoView2, false);
        b bVar = b.f362999a;
        playControlView.setPadding(bVar.b(12), 0, bVar.b(6), bVar.b(50));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        addView(playControlView, layoutParams);
        ProgressView progressView = new ProgressView(context, null, 0, 6, null);
        BaseVideoView baseVideoView3 = this.videoView;
        Intrinsics.checkNotNull(baseVideoView3);
        progressView.d(baseVideoView3);
        progressView.setPadding(bVar.b(6), 0, bVar.b(12), bVar.b(50));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(6, playControlView.getId());
        layoutParams2.addRule(8, playControlView.getId());
        layoutParams2.addRule(1, playControlView.getId());
        addView(progressView, layoutParams2);
        PlayControlView playControlView2 = new PlayControlView(context, null, 0, 6, null);
        BaseVideoView baseVideoView4 = this.videoView;
        Intrinsics.checkNotNull(baseVideoView4);
        playControlView2.l(baseVideoView4, true);
        playControlView2.setPlayImageSource(R.drawable.oc6, R.drawable.oc7);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(13);
        addView(playControlView2, layoutParams3);
        playControlView2.setVisibility(4);
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        BaseVideoView baseVideoView = this.videoView;
        if (baseVideoView != null) {
            baseVideoView.u();
        }
    }

    public final void c(boolean needRecordPosition) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, needRecordPosition);
            return;
        }
        BaseVideoView baseVideoView = this.videoView;
        if (baseVideoView != null) {
            baseVideoView.A(needRecordPosition);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleVideoView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleVideoView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}
