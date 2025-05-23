package com.qzone.reborn.feedx.itemview.friendlike;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qzone.module.feedcomponent.util.QZoneFrdHotVideoDCReporter;
import com.qzone.module.feedcomponent.util.QZoneFrdHotVideoDTReporter;
import com.qzone.proxy.feedcomponent.model.FrdHotVideoSubFeedInfo;
import com.qzone.proxy.feedcomponent.model.ParsedFeedData;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.reborn.feedx.video.view.QZoneVideoView;
import com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.superplayer.api.ISuperPlayer;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\u00020\u0001:\u0001\u0011B'\b\u0007\u0012\u0006\u0010!\u001a\u00020 \u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"\u0012\b\b\u0002\u0010$\u001a\u00020\u000b\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0006\u0010\b\u001a\u00020\u0007J\u001e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJ\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\u001c\u0010\u0015\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0014J\b\u0010\u0016\u001a\u00020\u0002H\u0014R\u0016\u0010\u0019\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006("}, d2 = {"Lcom/qzone/reborn/feedx/itemview/friendlike/QZoneFrdHotVideoView;", "Lcom/qzone/reborn/feedx/widget/picmixvideo/QZoneVideoItemWidgetView;", "", "p1", "o1", "", "getLogTag", "", "isPlaying", "Lcom/qzone/proxy/feedcomponent/model/i;", "subFeedInfo", "", "position", "positionInQZoneFeed", "q1", "play", "pause", "a", "Lcom/qzone/reborn/feedx/video/c;", "options", "playUrlKey", "E0", "F0", "a0", "Lcom/qzone/proxy/feedcomponent/model/i;", "curSubFeedInfo", "b0", "I", "", "c0", "J", "startPlayTimestamp", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleArr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "d0", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneFrdHotVideoView extends QZoneVideoItemWidgetView {

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private FrdHotVideoSubFeedInfo curSubFeedInfo;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private int position;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private long startPlayTimestamp;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZoneFrdHotVideoView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n1(QZoneFrdHotVideoView this$0, ISuperPlayer iSuperPlayer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.o1();
    }

    private final void o1() {
        if (this.startPlayTimestamp > 0) {
            long D0 = this.E.D0();
            if (D0 > 0) {
                FrdHotVideoSubFeedInfo frdHotVideoSubFeedInfo = this.curSubFeedInfo;
                if (frdHotVideoSubFeedInfo == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("curSubFeedInfo");
                    frdHotVideoSubFeedInfo = null;
                }
                QZoneFrdHotVideoDCReporter qZoneFrdHotVideoDCReporter = QZoneFrdHotVideoDCReporter.INSTANCE;
                ParsedFeedData parsedFeedData = frdHotVideoSubFeedInfo.getParsedFeedData();
                int i3 = this.position + 1;
                int a16 = QZoneFrdHotVideoItemLayout.INSTANCE.a();
                long j3 = this.startPlayTimestamp;
                VideoInfo videoInfo = frdHotVideoSubFeedInfo.getOriginFeedData().getVideoInfo();
                qZoneFrdHotVideoDCReporter.reportStopPlayVideo(parsedFeedData, i3, a16, j3, D0, videoInfo != null ? videoInfo.videoTime : 0L);
                QZoneFrdHotVideoDTReporter qZoneFrdHotVideoDTReporter = QZoneFrdHotVideoDTReporter.INSTANCE;
                QZoneVideoView mVideoView = this.E;
                Intrinsics.checkNotNullExpressionValue(mVideoView, "mVideoView");
                qZoneFrdHotVideoDTReporter.unbindVideoPlayerInfo(mVideoView);
            }
            this.startPlayTimestamp = 0L;
        }
    }

    private final void p1() {
        if (this.startPlayTimestamp == 0) {
            this.startPlayTimestamp = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView
    public void E0(com.qzone.reborn.feedx.video.c options, String playUrlKey) {
        lh.j b16;
        super.E0(options, playUrlKey);
        if (options == null || (b16 = options.b()) == null) {
            return;
        }
        b16.a(new lh.a() { // from class: com.qzone.reborn.feedx.itemview.friendlike.i
            @Override // lh.a
            public final void onCompletion(ISuperPlayer iSuperPlayer) {
                QZoneFrdHotVideoView.n1(QZoneFrdHotVideoView.this, iSuperPlayer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView
    public void F0() {
        Pair pair;
        VideoInfo videoInfo = this.D;
        if (videoInfo == null) {
            return;
        }
        int i3 = videoInfo.height;
        int i16 = videoInfo.width;
        float f16 = i3 / i16;
        if (i16 >= i3) {
            pair = new Pair(Integer.valueOf(getLayoutParams().width), Integer.valueOf((int) (getLayoutParams().width * f16)));
        } else if (f16 >= getLayoutParams().height / getLayoutParams().width) {
            pair = new Pair(Integer.valueOf(getLayoutParams().width), Integer.valueOf((int) (getLayoutParams().width * f16)));
        } else {
            pair = new Pair(Integer.valueOf((int) (getLayoutParams().height * f16)), Integer.valueOf(getLayoutParams().height));
        }
        QZoneVideoView qZoneVideoView = this.E;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(((Number) pair.getFirst()).intValue(), ((Number) pair.getSecond()).intValue());
        layoutParams.gravity = 17;
        qZoneVideoView.setLayoutParams(layoutParams);
        ImageView imageView = this.F;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(((Number) pair.getFirst()).intValue(), ((Number) pair.getSecond()).intValue());
        layoutParams2.gravity = 17;
        imageView.setLayoutParams(layoutParams2);
        ViewGroup.LayoutParams layoutParams3 = this.f56457i.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams3, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
        layoutParams4.gravity = 17;
        layoutParams4.height = getLayoutParams().height;
        requestLayout();
    }

    @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView, gf.r
    public void a() {
        o1();
        super.a();
    }

    @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView, com.qzone.reborn.feedx.widget.picmixvideo.QZoneMixBaseWidgetView
    protected String getLogTag() {
        return "QZoneFrdHotVideoView";
    }

    public final boolean isPlaying() {
        ISuperPlayer superPlayer = this.E.getSuperPlayer();
        if (superPlayer == null) {
            return false;
        }
        return superPlayer.isPlaying();
    }

    @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView, gf.r
    public void pause() {
        o1();
        super.pause();
    }

    @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView, gf.r
    public void play() {
        QZoneFrdHotVideoDTReporter qZoneFrdHotVideoDTReporter = QZoneFrdHotVideoDTReporter.INSTANCE;
        QZoneVideoView mVideoView = this.E;
        Intrinsics.checkNotNullExpressionValue(mVideoView, "mVideoView");
        FrdHotVideoSubFeedInfo frdHotVideoSubFeedInfo = this.curSubFeedInfo;
        if (frdHotVideoSubFeedInfo == null) {
            Intrinsics.throwUninitializedPropertyAccessException("curSubFeedInfo");
            frdHotVideoSubFeedInfo = null;
        }
        qZoneFrdHotVideoDTReporter.bindVideoPlayerInfo(mVideoView, frdHotVideoSubFeedInfo.getParsedFeedData());
        super.play();
        p1();
    }

    public final void q1(FrdHotVideoSubFeedInfo subFeedInfo, int position, int positionInQZoneFeed) {
        Intrinsics.checkNotNullParameter(subFeedInfo, "subFeedInfo");
        this.position = position;
        this.curSubFeedInfo = subFeedInfo;
        setFeedData(subFeedInfo.getOriginFeedData());
        setFeedPosition(positionInQZoneFeed);
        H0(subFeedInfo.getOriginFeedData().getVideoInfo());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZoneFrdHotVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ QZoneFrdHotVideoView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneFrdHotVideoView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f56457i.setRadius(0.0f);
    }
}
