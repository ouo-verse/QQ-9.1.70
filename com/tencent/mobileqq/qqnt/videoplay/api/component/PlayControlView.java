package com.tencent.mobileqq.qqnt.videoplay.api.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\b\u0002\u0010!\u001a\u00020\t\u00a2\u0006\u0004\b\"\u0010#J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\u0016\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tJ\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0005H\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0013\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u000b\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001a\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/qqnt/videoplay/api/component/PlayControlView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/qqnt/videoplay/api/component/BaseVideoView;", "videoView", "", "isInCenter", "", "l", "", "playImgId", "pauseImgId", "setPlayImageSource", "isPlay", "setPlayState$videoplay_kit_release", "(Z)V", "setPlayState", "Landroid/view/View;", "p0", NodeProps.ON_CLICK, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", BdhLogUtil.LogTag.Tag_Conn, "D", "Lcom/tencent/mobileqq/qqnt/videoplay/api/component/BaseVideoView;", "E", "Z", "isPlaying", UserInfo.SEX_FEMALE, "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "defStyleAttrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "videoplay_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class PlayControlView extends AppCompatImageView implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    private int pauseImgId;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private BaseVideoView videoView;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isPlaying;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isInCenter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int playImgId;

    public /* synthetic */ PlayControlView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    public final void l(@NotNull BaseVideoView videoView, boolean isInCenter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, videoView, Boolean.valueOf(isInCenter));
            return;
        }
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        this.isInCenter = isInCenter;
        this.videoView = videoView;
        videoView.l(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View p06) {
        com.tencent.mobileqq.qqnt.videoplay.player.a r16;
        com.tencent.mobileqq.qqnt.videoplay.player.a r17;
        EventCollector.getInstance().onViewClickedBefore(p06);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) p06);
        } else if (this.isPlaying) {
            this.isPlaying = false;
            setImageResource(this.playImgId);
            BaseVideoView baseVideoView = this.videoView;
            if (baseVideoView != null && (r17 = baseVideoView.r()) != null) {
                r17.pausePlay();
            }
        } else {
            this.isPlaying = true;
            setImageResource(this.pauseImgId);
            BaseVideoView baseVideoView2 = this.videoView;
            if (baseVideoView2 != null && (r16 = baseVideoView2.r()) != null) {
                r16.resumePlay();
            }
        }
        EventCollector.getInstance().onViewClicked(p06);
    }

    public final void setPlayImageSource(int playImgId, int pauseImgId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(playImgId), Integer.valueOf(pauseImgId));
            return;
        }
        this.playImgId = playImgId;
        this.pauseImgId = pauseImgId;
        if (this.isPlaying) {
            playImgId = pauseImgId;
        }
        setImageResource(playImgId);
    }

    public final void setPlayState$videoplay_kit_release(boolean isPlay) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, isPlay);
            return;
        }
        int i3 = 4;
        if (!this.isInCenter ? isPlay : !isPlay) {
            i3 = 0;
        }
        setVisibility(i3);
        if (isPlay && !this.isPlaying) {
            this.isPlaying = true;
            setImageResource(this.pauseImgId);
        } else if (!isPlay && this.isPlaying) {
            this.isPlaying = false;
            setImageResource(this.playImgId);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlayControlView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.playImgId = R.drawable.oc5;
        this.pauseImgId = R.drawable.oc7;
        setImageResource(R.drawable.oc5);
        setOnClickListener(this);
    }
}
