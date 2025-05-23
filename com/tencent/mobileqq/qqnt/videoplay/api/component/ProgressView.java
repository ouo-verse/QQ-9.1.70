package com.tencent.mobileqq.qqnt.videoplay.api.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001/B%\u0012\u0006\u0010(\u001a\u00020'\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)\u0012\b\b\u0002\u0010+\u001a\u00020\u0014\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0000\u00a2\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0005H\u0000\u00a2\u0006\u0004\b\u0010\u0010\u000fJ\"\u0010\u0018\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0012\u0010\u001a\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u001b\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0012H\u0016R\u0016\u0010\u001d\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001cR\u0016\u0010 \u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010!R\u0016\u0010$\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u001fR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/qqnt/videoplay/api/component/ProgressView;", "Landroid/widget/LinearLayout;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "", "positionMs", "", "e", "Lcom/tencent/mobileqq/qqnt/videoplay/api/component/BaseVideoView;", "videoView", "d", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "f", "(Lkotlinx/coroutines/CoroutineScope;)V", "g", "()V", "setDuration$videoplay_kit_release", "setDuration", "Landroid/widget/SeekBar;", "SeekBar", "", "progress", "", "fromUser", "onProgressChanged", "p0", "onStartTrackingTouch", "onStopTrackingTouch", "Z", "isProgressCancelled", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "progressTime", "Landroid/widget/SeekBar;", "progressSeekBar", h.F, "totalTime", "i", "Lcom/tencent/mobileqq/qqnt/videoplay/api/component/BaseVideoView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "defStyleAttrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "videoplay_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class ProgressView extends LinearLayout implements SeekBar.OnSeekBarChangeListener {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isProgressCancelled;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView progressTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private SeekBar progressSeekBar;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TextView totalTime;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BaseVideoView videoView;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqnt/videoplay/api/component/ProgressView$a;", "", "", "MAX_PROGRESS", UserInfo.SEX_FEMALE, "", "TAG", "Ljava/lang/String;", "<init>", "()V", "videoplay_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqnt.videoplay.api.component.ProgressView$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39422);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public /* synthetic */ ProgressView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(long positionMs) {
        BaseVideoView baseVideoView = this.videoView;
        if (baseVideoView != null) {
            Intrinsics.checkNotNull(baseVideoView);
            long videoDurationMs = baseVideoView.r().getVideoDurationMs();
            if (videoDurationMs > 0) {
                this.progressTime.setText(com.tencent.qqnt.util.string.c.f362990a.b(positionMs));
                this.progressSeekBar.setProgress((int) ((positionMs / videoDurationMs) * 10000.0f));
            }
        }
    }

    public final void d(@NotNull BaseVideoView videoView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) videoView);
            return;
        }
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        this.videoView = videoView;
        videoView.setProgressView$videoplay_kit_release(this);
    }

    public final void f(@NotNull CoroutineScope coroutineScope) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) coroutineScope);
            return;
        }
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        if (QLog.isColorLevel()) {
            QLog.i("VideoPlay_ProgressView", 2, "setPlayProgress");
        }
        this.isProgressCancelled = false;
        setVisibility(0);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getMain(), null, new ProgressView$startPlayProgress$1(this, null), 2, null);
    }

    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("VideoPlay_ProgressView", 2, "stopPlayProgress");
        }
        this.isProgressCancelled = true;
        setVisibility(4);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(@Nullable SeekBar SeekBar, int progress, boolean fromUser) {
        BaseVideoView baseVideoView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, SeekBar, Integer.valueOf(progress), Boolean.valueOf(fromUser));
            return;
        }
        if (fromUser && (baseVideoView = this.videoView) != null) {
            Intrinsics.checkNotNull(baseVideoView);
            int videoDurationMs = (int) ((progress / 10000.0f) * ((float) baseVideoView.r().getVideoDurationMs()));
            BaseVideoView baseVideoView2 = this.videoView;
            Intrinsics.checkNotNull(baseVideoView2);
            baseVideoView2.r().seekTo(videoDurationMs);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(@Nullable SeekBar p06) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) p06);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(@Nullable SeekBar p06) {
        EventCollector.getInstance().onStopTrackingTouchBefore(p06);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) p06);
        }
        EventCollector.getInstance().onStopTrackingTouch(p06);
    }

    public final void setDuration$videoplay_kit_release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        BaseVideoView baseVideoView = this.videoView;
        if (baseVideoView != null) {
            TextView textView = this.totalTime;
            com.tencent.qqnt.util.string.c cVar = com.tencent.qqnt.util.string.c.f362990a;
            Intrinsics.checkNotNull(baseVideoView);
            textView.setText(cVar.b(baseVideoView.r().getVideoDurationMs()));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProgressView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        View.inflate(context, R.layout.i3y, this);
        View findViewById = findViewById(R.id.g1m);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.progressTime)");
        this.progressTime = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.jut);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.totalTime)");
        this.totalTime = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.ilh);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.seekBar)");
        SeekBar seekBar = (SeekBar) findViewById3;
        this.progressSeekBar = seekBar;
        seekBar.setMax(10000);
        this.progressSeekBar.setOnSeekBarChangeListener(this);
    }
}
