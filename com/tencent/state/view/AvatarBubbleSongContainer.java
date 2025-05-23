package com.tencent.state.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.state.square.Square;
import com.tencent.state.square.api.SongInfo;
import com.tencent.state.square.data.OnlineStatus;
import com.tencent.state.square.data.SpecialStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0014H&J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&J\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0011\u001a\u00020\u0012R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/state/view/AvatarBubbleSongContainer;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "listener", "Lcom/tencent/state/view/BubbleElementEventListener;", "bindSongView", "", "status", "Lcom/tencent/state/square/data/OnlineStatus;", "isMe", "", "getSongPlayIconView", "Landroid/widget/ImageView;", "getSongTextView", "Lcom/tencent/state/view/MarqueeTextView;", "setElementEventListener", "updatePlayIcon", "songMid", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public abstract class AvatarBubbleSongContainer extends LinearLayout {
    private BubbleElementEventListener listener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarBubbleSongContainer(Context context) {
        super(context, null, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void bindSongView(OnlineStatus status, boolean isMe) {
        SongInfo songInfo;
        Intrinsics.checkNotNullParameter(status, "status");
        MarqueeTextView songTextView = getSongTextView();
        if (songTextView != null) {
            songTextView.setVisibility(0);
        }
        MarqueeTextView songTextView2 = getSongTextView();
        if (songTextView2 != null) {
            OnlineStatusBubbleViewHelper onlineStatusBubbleViewHelper = OnlineStatusBubbleViewHelper.INSTANCE;
            SpecialStatus extraData = status.getExtraData();
            Intrinsics.checkNotNull(extraData);
            SongInfo songInfo2 = extraData.getSongInfo();
            Intrinsics.checkNotNull(songInfo2);
            songTextView2.setText(onlineStatusBubbleViewHelper.getSongName(songInfo2));
        }
        SpecialStatus extraData2 = status.getExtraData();
        updatePlayIcon((extraData2 == null || (songInfo = extraData2.getSongInfo()) == null) ? null : songInfo.getSongId(), isMe);
        ImageView songPlayIconView = getSongPlayIconView();
        if (songPlayIconView != null) {
            songPlayIconView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.state.view.AvatarBubbleSongContainer$bindSongView$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View it) {
                    BubbleElementEventListener bubbleElementEventListener;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    Object tag = it.getTag();
                    if (!(tag instanceof String)) {
                        tag = null;
                    }
                    String str = (String) tag;
                    if (str != null) {
                        boolean isSongPlaying = Square.INSTANCE.getConfig().getCommonUtils().isSongPlaying(str);
                        bubbleElementEventListener = AvatarBubbleSongContainer.this.listener;
                        if (bubbleElementEventListener != null) {
                            bubbleElementEventListener.onSongIconClick(it, isSongPlaying, str);
                        }
                    }
                }
            });
        }
    }

    public abstract ImageView getSongPlayIconView();

    public abstract MarqueeTextView getSongTextView();

    public final void setElementEventListener(BubbleElementEventListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    public final void updatePlayIcon(String songMid, boolean isMe) {
        ImageView songPlayIconView = getSongPlayIconView();
        if (songPlayIconView != null) {
            boolean isSongPlaying = Square.INSTANCE.getConfig().getCommonUtils().isSongPlaying(songMid);
            if (isMe) {
                songPlayIconView.setVisibility(8);
            } else {
                songPlayIconView.setVisibility(0);
                songPlayIconView.setTag(songMid);
                songPlayIconView.setImageResource(isSongPlaying ? R.drawable.ia_ : R.drawable.iaa);
            }
            BubbleElementEventListener bubbleElementEventListener = this.listener;
            if (bubbleElementEventListener != null) {
                bubbleElementEventListener.onSongIconExpose(songPlayIconView, !isMe, isSongPlaying);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarBubbleSongContainer(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AvatarBubbleSongContainer(Context context, AttributeSet attrs, int i3) {
        super(context, attrs, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
    }
}
