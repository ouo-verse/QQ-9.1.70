package com.tencent.mobileqq.guild.feed.video;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedVideoView extends GuildBaseVideoView {
    private SeekBar M;
    private int N;

    public GuildFeedVideoView(@NonNull Context context) {
        this(context, null);
    }

    @Override // com.tencent.mobileqq.guild.feed.widget.GuildBaseWidgetView, com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
        this.N = i3;
    }

    @Override // com.tencent.mobileqq.guild.feed.widget.GuildBaseWidgetView, com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return 0;
    }

    @Override // com.tencent.mobileqq.guild.feed.video.GuildBaseVideoView
    public SeekBar p0() {
        return this.M;
    }

    public void setProgressBar(SeekBar seekBar) {
        this.M = seekBar;
    }

    public GuildFeedVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GuildFeedVideoView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    @Override // com.tencent.mobileqq.guild.feed.video.GuildBaseVideoView, com.tencent.richframework.video.IPlayerStateCallback
    public void onVideoLoopEnd() {
    }

    @Override // com.tencent.mobileqq.guild.feed.video.GuildBaseVideoView, com.tencent.richframework.video.IPlayerStateCallback
    public void onVideoLoopStart() {
    }

    @Override // com.tencent.mobileqq.guild.feed.video.GuildBaseVideoView
    protected void reportVideoStartPlay() {
    }

    @Override // com.tencent.mobileqq.guild.feed.video.GuildBaseVideoView
    protected void w0(long j3, long j16) {
    }

    @Override // com.tencent.mobileqq.guild.feed.video.GuildBaseVideoView, com.tencent.richframework.video.IPlayerStateCallback
    public void onVideoPlayError(int i3, int i16, int i17, String str) {
    }

    @Override // com.tencent.mobileqq.guild.feed.video.GuildBaseVideoView
    protected void v0(int i3, int i16, long j3, long j16) {
    }

    @Override // com.tencent.mobileqq.guild.feed.video.GuildBaseVideoView
    protected void x0(long j3, long j16, long j17, long j18) {
    }
}
