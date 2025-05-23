package com.qzone.module.feedcomponent.ui.video;

import android.view.View;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoElement;
import com.tencent.mobileqq.qzoneplayer.video.g;

/* compiled from: P */
/* loaded from: classes39.dex */
public class OnFeedVideoElementClickListenerImpl implements g {
    com.qzone.proxy.feedcomponent.ui.g onFeedElementClickListener;

    /* compiled from: P */
    /* renamed from: com.qzone.module.feedcomponent.ui.video.OnFeedVideoElementClickListenerImpl$1, reason: invalid class name */
    /* loaded from: classes39.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$mobileqq$qzoneplayer$video$FeedVideoElement;

        static {
            int[] iArr = new int[FeedVideoElement.values().length];
            $SwitchMap$com$tencent$mobileqq$qzoneplayer$video$FeedVideoElement = iArr;
            try {
                iArr[FeedVideoElement.AUTO_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$mobileqq$qzoneplayer$video$FeedVideoElement[FeedVideoElement.VIDEO_REPLAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$mobileqq$qzoneplayer$video$FeedVideoElement[FeedVideoElement.VIDEO_COVER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$mobileqq$qzoneplayer$video$FeedVideoElement[FeedVideoElement.AUTO_VIDEO_CLICK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$tencent$mobileqq$qzoneplayer$video$FeedVideoElement[FeedVideoElement.ADV_MICRO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$tencent$mobileqq$qzoneplayer$video$FeedVideoElement[FeedVideoElement.VIDEO_REMARK.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$tencent$mobileqq$qzoneplayer$video$FeedVideoElement[FeedVideoElement.AUTO_VIDEO_ADV_GET_MORE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$tencent$mobileqq$qzoneplayer$video$FeedVideoElement[FeedVideoElement.FEEDVIDEO_GET_MORE_RECOMMEND_REQ.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$tencent$mobileqq$qzoneplayer$video$FeedVideoElement[FeedVideoElement.FEEDVIDEO_PLAY_RECOMMEND.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$tencent$mobileqq$qzoneplayer$video$FeedVideoElement[FeedVideoElement.FEEDVIDEO_GOTO_VIDEO_TAB.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$tencent$mobileqq$qzoneplayer$video$FeedVideoElement[FeedVideoElement.FEEDVIDEO_REPORT_RECOMMEND_EXPOSED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$tencent$mobileqq$qzoneplayer$video$FeedVideoElement[FeedVideoElement.FEEDVIDEO_RAPID_FORWARD_BUTTON.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public OnFeedVideoElementClickListenerImpl(com.qzone.proxy.feedcomponent.ui.g gVar) {
        this.onFeedElementClickListener = gVar;
    }

    @Override // com.tencent.mobileqq.qzoneplayer.video.g
    public void onClick(View view, FeedVideoElement feedVideoElement, int i3, Object obj) {
        FeedElement feedElement;
        switch (AnonymousClass1.$SwitchMap$com$tencent$mobileqq$qzoneplayer$video$FeedVideoElement[feedVideoElement.ordinal()]) {
            case 1:
            case 2:
            case 3:
                feedElement = FeedElement.AUTO_VIDEO;
                break;
            case 4:
                feedElement = FeedElement.AUTO_VIDEO_CLICK;
                break;
            case 5:
                feedElement = FeedElement.ADV_MICRO_VIDEO;
                break;
            case 6:
                feedElement = FeedElement.VIDEO_REMARK;
                break;
            case 7:
                feedElement = FeedElement.AUTO_VIDEO_ADV_GET_MORE;
                break;
            case 8:
                feedElement = FeedElement.FEEDVIDEO_GET_MORE_RECOMMEND_REQ;
                break;
            case 9:
                feedElement = FeedElement.FEEDVIDEO_PLAY_RECOMMEND;
                break;
            case 10:
                feedElement = FeedElement.FEEDVIDEO_GOTO_VIDEO_TAB;
                break;
            case 11:
                feedElement = FeedElement.FEEDVIDEO_REPORT_RECOMMEND_EXPOSED;
                break;
            case 12:
                feedElement = FeedElement.RAPID_FORWARD_BUTTON;
                break;
            default:
                feedElement = null;
                break;
        }
        com.qzone.proxy.feedcomponent.ui.g gVar = this.onFeedElementClickListener;
        if (gVar != null) {
            gVar.onClick(view, feedElement, i3, obj);
            if (FeedVideoElement.VIDEO_REPLAY == feedVideoElement) {
                this.onFeedElementClickListener.onClick(view, FeedElement.AUTO_VIDEO_REPLAY, i3, obj);
            } else if (FeedVideoElement.VIDEO_COVER == feedVideoElement) {
                this.onFeedElementClickListener.onClick(view, FeedElement.AUTO_VIDEO_CLICK, i3, obj);
            }
        }
    }
}
