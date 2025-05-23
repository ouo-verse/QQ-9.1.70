package com.tencent.mobileqq.kandian.biz.video.playfeeds.entity;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import j62.b;
import kotlin.Metadata;
import l62.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/playfeeds/entity/AbsVideoFeedsGestureLayout;", "", "Landroid/widget/RelativeLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "kandian-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public abstract class AbsVideoFeedsGestureLayout extends RelativeLayout {
    public AbsVideoFeedsGestureLayout(@Nullable Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    public abstract /* synthetic */ void setChannelID(long j3);

    public abstract /* synthetic */ void setContext(@Nullable Activity activity);

    public abstract /* synthetic */ void setIsInFullScreen(boolean z16);

    public abstract /* synthetic */ void setOnCustomClickListener(@NotNull l62.a aVar);

    public abstract /* synthetic */ void setSeekBar(@NotNull SeekBar seekBar);

    public abstract /* synthetic */ void setVideoBrightnessController(@Nullable a aVar);

    public abstract /* synthetic */ void setVideoPlayManager(@Nullable b bVar);

    public abstract /* synthetic */ void setVideoPlayManager(@Nullable e eVar);
}
