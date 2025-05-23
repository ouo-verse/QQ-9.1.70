package ey2;

import android.view.View;
import android.widget.ImageView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.video.rfw.drive.RFWFeedSelectInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.event.QFSTVideoEpisodeClickEvent;
import com.tencent.mobileqq.tvideo.event.QFSTVideoEpisodeDataEvent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tvideo.Video;
import tvideo.VideoBaseInfo;
import tvideo.VideoPlot;
import tvideo.VideoPlotDetails;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 92\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001:B\u0007\u00a2\u0006\u0004\b7\u00108J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J(\u0010\u0013\u001a\"\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u00100\u000fj\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u0010`\u0012H\u0016J\u0012\u0010\u0015\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0016J\u0012\u0010\u0018\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u001b\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001c\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016R\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001e\u0010%\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010\u001eR\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R$\u00106\u001a\u0002002\u0006\u00101\u001a\u0002008\u0002@BX\u0082\u000e\u00a2\u0006\f\n\u0004\b2\u00103\"\u0004\b4\u00105\u00a8\u0006;"}, d2 = {"Ley2/m;", "Lcom/tencent/biz/qqcircle/immersive/feed/QFSBaseFeedChildPresenter;", "Lfeedcloud/FeedCloudMeta$StFeed;", "", "h1", "l1", "", "w0", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "N0", "data", "", "position", "i1", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lkotlin/collections/ArrayList;", "getEventClass", "simpleBaseEvent", "onReceiveEvent", "Lcom/tencent/biz/qqcircle/immersive/feed/event/h;", "event", "C0", "Lcom/tencent/biz/richframework/video/rfw/drive/RFWFeedSelectInfo;", "selectInfo", "onFeedSelected", "onFeedUnSelected", "Ltvideo/VideoPlotDetails;", "I", "Ltvideo/VideoPlotDetails;", "videoPlotDetails", "", "Ltvideo/VideoPlot;", "J", "Ljava/util/List;", "videoPlotList", "Landroid/widget/ImageView;", "K", "Landroid/widget/ImageView;", "nextView", "L", "nextIndex", "Ltvideo/Video;", "M", "Ltvideo/Video;", "videoFeed", "", "hasNext", "N", "Z", "k1", "(Z)V", "hasNextEpisode", "<init>", "()V", "P", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class m extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> {

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private VideoPlotDetails videoPlotDetails;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private List<VideoPlot> videoPlotList;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private ImageView nextView;

    /* renamed from: L, reason: from kotlin metadata */
    private int nextIndex = -1;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private Video videoFeed;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean hasNextEpisode;

    private final void h1() {
        VideoPlot videoPlot;
        List<VideoPlot> list = this.videoPlotList;
        if (list != null && (videoPlot = list.get(this.nextIndex)) != null) {
            QFSTVideoEpisodeClickEvent qFSTVideoEpisodeClickEvent = new QFSTVideoEpisodeClickEvent();
            qFSTVideoEpisodeClickEvent.setPos(this.f85018i);
            qFSTVideoEpisodeClickEvent.setVideoPlot(videoPlot);
            qFSTVideoEpisodeClickEvent.setVideoFeed(this.videoFeed);
            qFSTVideoEpisodeClickEvent.setVideoPlotDetails(this.videoPlotDetails);
            SimpleEventBus.getInstance().dispatchEvent(qFSTVideoEpisodeClickEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(m this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.h1();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void k1(boolean z16) {
        int i3;
        ImageView imageView = this.nextView;
        if (imageView != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            imageView.setVisibility(i3);
        }
        this.hasNextEpisode = z16;
    }

    private final void l1() {
        List<VideoPlot> list;
        String str;
        int i3;
        int i16;
        String str2;
        VideoPlot videoPlot;
        VideoBaseInfo videoBaseInfo;
        VideoBaseInfo videoBaseInfo2;
        VideoPlotDetails videoPlotDetails = (VideoPlotDetails) this.E.b("tvideo_episode_blockdara_transform");
        this.videoPlotDetails = videoPlotDetails;
        Integer num = null;
        if (videoPlotDetails != null) {
            list = videoPlotDetails.video_plot_list;
        } else {
            list = null;
        }
        this.videoPlotList = list;
        this.nextIndex = -1;
        Video video = this.videoFeed;
        if (video != null && (videoBaseInfo2 = video.video_base_info) != null) {
            str = videoBaseInfo2.vid;
        } else {
            str = null;
        }
        boolean z16 = false;
        if (list != null) {
            i3 = list.size();
        } else {
            i3 = 0;
        }
        int i17 = 0;
        while (true) {
            if (i17 >= i3) {
                break;
            }
            List<VideoPlot> list2 = this.videoPlotList;
            if (list2 != null && (videoPlot = list2.get(i17)) != null && (videoBaseInfo = videoPlot.video_base_info) != null) {
                str2 = videoBaseInfo.vid;
            } else {
                str2 = null;
            }
            if (Intrinsics.areEqual(str2, str)) {
                this.nextIndex = i17 + 1;
                break;
            }
            i17++;
        }
        int i18 = this.nextIndex;
        if (i18 > 0) {
            List<VideoPlot> list3 = this.videoPlotList;
            if (list3 != null) {
                i16 = list3.size();
            } else {
                i16 = 0;
            }
            if (i18 < i16) {
                z16 = true;
            }
        }
        k1(z16);
        int i19 = this.nextIndex;
        List<VideoPlot> list4 = this.videoPlotList;
        if (list4 != null) {
            num = Integer.valueOf(list4.size());
        }
        QLog.d("QFSTVideoNextEpisodePresenter", 1, "updateHasNextEpisode nextIndex:" + i19 + " currentVid:" + str + " listSize:" + num);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void C0(@Nullable com.tencent.biz.qqcircle.immersive.feed.event.h event) {
        String str;
        super.C0(event);
        if (event instanceof wx2.i) {
            if (this.hasNextEpisode) {
                h1();
                return;
            } else {
                T0(new wx2.a());
                return;
            }
        }
        if (event instanceof wx2.c) {
            if (this.hasNextEpisode) {
                str = "\u5373\u5c06\u81ea\u52a8\u64ad\u653e\u4e0b\u4e00\u96c6";
            } else {
                str = "\u5373\u5c06\u81ea\u52a8\u64ad\u653e\u4e0b\u4e00\u89c6\u9891";
            }
            T0(new wx2.f(str));
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.N0(rootView);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.f56802ll);
        this.nextView = imageView;
        jy2.f.f411169a.j(imageView, "https://ugd.gtimg.com//vg/1678696104486_tvideo_next.png");
        ImageView imageView2 = this.nextView;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: ey2.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    m.j1(m.this, view);
                }
            });
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<? extends SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<? extends SimpleBaseEvent>> eventClass = super.getEventClass();
        eventClass.add(QFSTVideoEpisodeDataEvent.class);
        Intrinsics.checkNotNullExpressionValue(eventClass, "eventClass");
        return eventClass;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public void L0(@Nullable FeedCloudMeta$StFeed data, int position) {
        super.L0(data, position);
        this.videoFeed = jy2.g.q(data);
        l1();
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onFeedSelected(selectInfo);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(@Nullable RFWFeedSelectInfo selectInfo) {
        super.onFeedUnSelected(selectInfo);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter, com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof QFSTVideoEpisodeDataEvent) {
            l1();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    @NotNull
    /* renamed from: w0 */
    public String getTAG() {
        return "QFSTVideoNextEpisodePresenter";
    }
}
