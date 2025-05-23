package com.tencent.mobileqq.search.searchdetail.multimedia;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper;
import com.tencent.biz.qqcircle.immersive.views.search.util.v;
import com.tencent.biz.qqcircle.immersive.views.search.widget.QFSSearchVideoView;
import com.tencent.biz.richframework.video.rfw.player.exp.RFWVideoFluencyExp9095;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.search.searchdetail.content.template.model.NetSearchTemplateNineBoxGridItem;
import com.tencent.mobileqq.widget.listitem.ab;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernel.nativeinterface.SearchIcon;
import com.tencent.qqnt.kernel.nativeinterface.SearchNineBoxContent;
import com.tencent.qqnt.kernel.nativeinterface.SearchStFeed;
import com.tencent.qqnt.kernel.nativeinterface.SearchStVideo;
import com.tencent.qqnt.kernel.nativeinterface.SearchText;
import com.tencent.qqnt.kernel.nativeinterface.SearchVideo;
import com.tencent.superplayer.api.ISuperPlayer;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StImage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 T2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001UB'\b\u0007\u0012\u0006\u0010N\u001a\u00020M\u0012\n\b\u0002\u0010P\u001a\u0004\u0018\u00010O\u0012\b\b\u0002\u0010Q\u001a\u00020\u0007\u00a2\u0006\u0004\bR\u0010SJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0019\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0010\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u001b\u001a\u00020\u0005H\u0016J\b\u0010\u001c\u001a\u00020\u0005H\u0016J\b\u0010\u001d\u001a\u00020\u0007H\u0016J\b\u0010\u001e\u001a\u00020\u0005H\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016J\b\u0010 \u001a\u00020\u0005H\u0014J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0007H\u0016J\u0018\u0010$\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u0007H\u0016J\u0016\u0010'\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010&\u001a\u00020%J\u0010\u0010)\u001a\u00020\u00052\b\b\u0002\u0010(\u001a\u00020\u0014J\u0006\u0010*\u001a\u00020\u0014J\u0006\u0010+\u001a\u00020\u0005J\u0006\u0010,\u001a\u00020\u0005J\b\u0010-\u001a\u00020\u0005H\u0016J\b\u0010.\u001a\u00020\u0005H\u0016J\b\u0010/\u001a\u00020\u0005H\u0016J\b\u00100\u001a\u00020\u0005H\u0016J\b\u00101\u001a\u00020\u0005H\u0016J\b\u00102\u001a\u00020\u0014H\u0016R\u0014\u00106\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0014\u0010:\u001a\u0002078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010\u0010\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010?\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR*\u0010K\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010D8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u0016\u0010\b\u001a\u00020@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010B\u00a8\u0006V"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/multimedia/NetSearchMultiMediaVideoView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/tencent/biz/qqcircle/immersive/views/search/util/QFSSearchVideoPlayHelper$b;", "Lcom/tencent/biz/qqcircle/immersive/views/search/util/QFSSearchVideoPlayHelper$a;", "Lcom/tencent/biz/qqcircle/immersive/views/search/util/QFSSearchVideoPlayHelper$d;", "", "L0", "", "position", "R0", "duration", "O0", "(Ljava/lang/Integer;)V", "Lfeedcloud/FeedCloudMeta$StFeed;", "stFeed", "N0", "status", "F0", "Q0", "K0", "", "isMute", "P0", "", "content", "I0", "J0", "onVideoLoopStart", "onVideoLoopEnd", "b0", "o0", "d0", NodeProps.ON_DETACHED_FROM_WINDOW, "errorCode", "onPlayError", "progress", "c0", "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/n;", "model", "setDataSource", "isResume", "S0", "H0", "U0", "M0", BdhLogUtil.LogTag.Tag_Req, "onCompletion", "setStatusLoading", "setStatusPlay", "onPlay", "H", "Lhp2/p;", "d", "Lhp2/p;", "binding", "Lcom/tencent/biz/qqcircle/immersive/views/search/util/QFSSearchVideoPlayHelper;", "e", "Lcom/tencent/biz/qqcircle/immersive/views/search/util/QFSSearchVideoPlayHelper;", "videoPlayHelper", "f", "I", tl.h.F, "Lcom/tencent/mobileqq/search/searchdetail/content/template/model/n;", "currentData", "", "i", "J", "operationTime", "Lkotlin/Function0;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/jvm/functions/Function0;", "getClickPlayIconListener", "()Lkotlin/jvm/functions/Function0;", "setClickPlayIconListener", "(Lkotlin/jvm/functions/Function0;)V", "clickPlayIconListener", BdhLogUtil.LogTag.Tag_Conn, "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "D", "a", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class NetSearchMultiMediaVideoView extends ConstraintLayout implements QFSSearchVideoPlayHelper.b, QFSSearchVideoPlayHelper.a, QFSSearchVideoPlayHelper.d {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static boolean E = true;

    /* renamed from: C, reason: from kotlin metadata */
    private long position;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final hp2.p binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QFSSearchVideoPlayHelper videoPlayHelper;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int status;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private NetSearchTemplateNineBoxGridItem currentData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long operationTime;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function0<Unit> clickPlayIconListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\nR\u0014\u0010\r\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\nR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/multimedia/NetSearchMultiMediaVideoView$a;", "", "", "isMute", "Z", "()Z", "a", "(Z)V", "", "STATUS_INITIALIZING", "I", "STATUS_PAUSE", "STATUS_PLAYING", "STATUS_STOP", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.search.searchdetail.multimedia.NetSearchMultiMediaVideoView$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(boolean z16) {
            NetSearchMultiMediaVideoView.E = z16;
        }

        Companion() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NetSearchMultiMediaVideoView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(NetSearchMultiMediaVideoView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.L0();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(NetSearchMultiMediaVideoView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.K0();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void F0(final int status) {
        post(new Runnable() { // from class: com.tencent.mobileqq.search.searchdetail.multimedia.t
            @Override // java.lang.Runnable
            public final void run() {
                NetSearchMultiMediaVideoView.G0(status, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(int i3, NetSearchMultiMediaVideoView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == this$0.status) {
            return;
        }
        this$0.J0("changeStatus:" + i3);
        this$0.status = i3;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    this$0.binding.f405709b.setVisibility(0);
                    this$0.binding.f405710c.setVisibility(8);
                    this$0.binding.f405712e.setImageResource(R.drawable.qui_play_filled_icon_white);
                    NetSearchTemplateNineBoxGridItem netSearchTemplateNineBoxGridItem = this$0.currentData;
                    if (netSearchTemplateNineBoxGridItem != null) {
                        netSearchTemplateNineBoxGridItem.f(0);
                        return;
                    }
                    return;
                }
                return;
            }
            this$0.binding.f405710c.setVisibility(8);
            this$0.binding.f405712e.setImageResource(R.drawable.qui_play_filled_icon_white);
            NetSearchTemplateNineBoxGridItem netSearchTemplateNineBoxGridItem2 = this$0.currentData;
            if (netSearchTemplateNineBoxGridItem2 != null) {
                netSearchTemplateNineBoxGridItem2.f(0);
                return;
            }
            return;
        }
        this$0.binding.f405710c.setVisibility(0);
        this$0.binding.f405712e.setImageResource(R.drawable.qui_pause_filled_white);
        this$0.binding.f405709b.setVisibility(8);
        this$0.Q0();
        NetSearchTemplateNineBoxGridItem netSearchTemplateNineBoxGridItem3 = this$0.currentData;
        if (netSearchTemplateNineBoxGridItem3 != null) {
            netSearchTemplateNineBoxGridItem3.f(1);
        }
    }

    private final void I0(String content) {
        String str;
        SearchIcon contentIcon;
        SearchText searchText;
        NetSearchTemplateNineBoxGridItem netSearchTemplateNineBoxGridItem = this.currentData;
        if (netSearchTemplateNineBoxGridItem != null && (contentIcon = netSearchTemplateNineBoxGridItem.getContentIcon()) != null && (searchText = contentIcon.title) != null) {
            str = searchText.text;
        } else {
            str = null;
        }
        if (str == null) {
            str = String.valueOf(hashCode());
        } else {
            Intrinsics.checkNotNullExpressionValue(str, "currentData?.contentIcon\u2026 ?: hashCode().toString()");
        }
        QLog.d("QQSearch.NetDetail.NetSearchMultiMediaVideoView", 1, str + "," + content);
    }

    private final void J0(String content) {
        String str;
        SearchIcon contentIcon;
        SearchText searchText;
        NetSearchTemplateNineBoxGridItem netSearchTemplateNineBoxGridItem = this.currentData;
        if (netSearchTemplateNineBoxGridItem != null && (contentIcon = netSearchTemplateNineBoxGridItem.getContentIcon()) != null && (searchText = contentIcon.title) != null) {
            str = searchText.text;
        } else {
            str = null;
        }
        if (str == null) {
            str = String.valueOf(hashCode());
        } else {
            Intrinsics.checkNotNullExpressionValue(str, "currentData?.contentIcon\u2026 ?: hashCode().toString()");
        }
        QLog.d("QQSearch.NetDetail.NetSearchMultiMediaVideoView", 4, str + "," + content);
    }

    private final void K0() {
        QLog.d("QQSearch.NetDetail.NetSearchMultiMediaVideoView", 1, "onClickMuteButton");
        P0(!E);
    }

    private final void L0() {
        QLog.d("QQSearch.NetDetail.NetSearchMultiMediaVideoView", 1, "onClickMuteButton");
        if (this.status == 1) {
            this.position = this.binding.f405714g.H0();
            M0();
        } else {
            Function0<Unit> function0 = this.clickPlayIconListener;
            if (function0 != null) {
                function0.invoke();
            }
            S0(true);
        }
    }

    private final void N0(FeedCloudMeta$StFeed stFeed) {
        String str;
        boolean z16;
        PBStringField pBStringField;
        FeedCloudMeta$StImage feedCloudMeta$StImage = stFeed.cover;
        if (feedCloudMeta$StImage == null) {
            QLog.i("QQSearch.NetDetail.NetSearchMultiMediaVideoView", 1, "cover is null");
            return;
        }
        PBStringField pBStringField2 = feedCloudMeta$StImage.picUrl;
        String str2 = null;
        if (pBStringField2 != null) {
            str = pBStringField2.get();
        } else {
            str = null;
        }
        boolean z17 = false;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 ? (pBStringField = feedCloudMeta$StImage.picUrl) != null : (pBStringField = feedCloudMeta$StImage.layerPicUrl) != null) {
            str2 = pBStringField.get();
        }
        String str3 = str2;
        if (str3 == null || str3.length() == 0) {
            z17 = true;
        }
        if (z17) {
            QLog.i("QQSearch.NetDetail.NetSearchMultiMediaVideoView", 1, "coverUrl is isNullOrEmpty");
            return;
        }
        o oVar = o.f284545a;
        ImageFilterView imageFilterView = this.binding.f405709b;
        Intrinsics.checkNotNullExpressionValue(imageFilterView, "binding.cover");
        o.g(oVar, "QQSearch.NetDetail.NetSearchMultiMediaVideoView", imageFilterView, str3, null, 8, null);
    }

    private final void O0(Integer duration) {
        if (duration == null) {
            this.binding.f405713f.setText(QzoneConfig.ALBUM_RECOM_EVENT_ALGO_USER_SAMPLE_DEFAULT);
        } else {
            R0(duration.intValue());
        }
    }

    private final void P0(boolean isMute) {
        E = isMute;
        this.binding.f405714g.setOutPutMute(isMute);
        Q0();
    }

    private final void Q0() {
        if (E) {
            this.binding.f405710c.setImageResource(R.drawable.qui_voice_mute_icon_white);
        } else {
            this.binding.f405710c.setImageResource(R.drawable.qui_voice_high_icon_white);
        }
    }

    private final void R0(int position) {
        int coerceAtLeast;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(position, 0);
        this.binding.f405713f.setText(new SimpleDateFormat("mm:ss", Locale.getDefault()).format(new Date(coerceAtLeast)));
    }

    public static /* synthetic */ void T0(NetSearchMultiMediaVideoView netSearchMultiMediaVideoView, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        netSearchMultiMediaVideoView.S0(z16);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.a
    public boolean H() {
        return E;
    }

    public final boolean H0() {
        if (this.status == 1) {
            return true;
        }
        return false;
    }

    public final void M0() {
        J0(QZoneJsConstants.METHOD_RECORDER_PAUSE_PLAY);
        this.binding.f405714g.pause();
        F0(2);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.d
    public void R() {
        Log.e("QQSearch.NetDetail.NetSearchMultiMediaVideoView", "onReplay");
    }

    public final void S0(boolean isResume) {
        if (H0()) {
            I0("startPlay but is playing now");
            return;
        }
        I0("startPlay");
        if (isResume) {
            this.videoPlayHelper.Q((int) this.position);
        } else {
            this.videoPlayHelper.Q(0);
        }
        this.videoPlayHelper.I();
    }

    public final void U0() {
        J0("stopPlayer");
        if (this.status == 3) {
            J0("stopPlayer but is not playing");
        }
        this.position = 0L;
        this.videoPlayHelper.K();
        F0(3);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.d
    public int b0() {
        return (int) this.position;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.d
    public void c0(int duration, int progress) {
        R0(duration - progress);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.d
    public void d0() {
        J0("onCancelPlay");
        F0(3);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.d
    public void o0() {
        F0(1);
        J0("onPostPlay");
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.d
    public void onCompletion() {
        Log.e("QQSearch.NetDetail.NetSearchMultiMediaVideoView", "onCompletion");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        U0();
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.a
    public void onPlay() {
        Log.d("QQSearch.NetDetail.NetSearchMultiMediaVideoView", "onPlay");
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.d
    public boolean onPlayError(int errorCode) {
        Log.e("QQSearch.NetDetail.NetSearchMultiMediaVideoView", "onPlayError: " + errorCode);
        return false;
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLooperListener
    public void onVideoLoopEnd() {
        J0("onVideoLoopEnd");
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.listener.IRFWPlayerLooperListener
    public void onVideoLoopStart() {
        J0("onVideoLoopStart");
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.d
    public /* synthetic */ void p0(ISuperPlayer iSuperPlayer) {
        v.a(this, iSuperPlayer);
    }

    public final void setClickPlayIconListener(@Nullable Function0<Unit> function0) {
        this.clickPlayIconListener = function0;
    }

    public final void setDataSource(@NotNull FeedCloudMeta$StFeed stFeed, @NotNull NetSearchTemplateNineBoxGridItem model) {
        Integer num;
        SearchVideo searchVideo;
        SearchStFeed searchStFeed;
        SearchStVideo searchStVideo;
        Intrinsics.checkNotNullParameter(stFeed, "stFeed");
        Intrinsics.checkNotNullParameter(model, "model");
        this.operationTime = System.currentTimeMillis();
        this.videoPlayHelper.S(stFeed);
        N0(stFeed);
        this.currentData = model;
        SearchNineBoxContent videoItem = model.getVideoItem();
        if (videoItem != null && (searchVideo = videoItem.video) != null && (searchStFeed = searchVideo.feed) != null && (searchStVideo = searchStFeed.video) != null) {
            num = Integer.valueOf(searchStVideo.duration);
        } else {
            num = null;
        }
        O0(num);
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.b
    public void setStatusLoading() {
        Log.e("QQSearch.NetDetail.NetSearchMultiMediaVideoView", "setStatusLoading");
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.search.util.QFSSearchVideoPlayHelper.b
    public void setStatusPlay() {
        Log.e("QQSearch.NetDetail.NetSearchMultiMediaVideoView", "setStatusPlay");
        F0(1);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NetSearchMultiMediaVideoView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ NetSearchMultiMediaVideoView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NetSearchMultiMediaVideoView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        hp2.p f16 = hp2.p.f(LayoutInflater.from(context), this);
        f16.f405712e.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.multimedia.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NetSearchMultiMediaVideoView.D0(NetSearchMultiMediaVideoView.this, view);
            }
        });
        f16.f405710c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.search.searchdetail.multimedia.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NetSearchMultiMediaVideoView.E0(NetSearchMultiMediaVideoView.this, view);
            }
        });
        QFSSearchVideoView qFSSearchVideoView = f16.f405714g;
        Intrinsics.checkNotNullExpressionValue(qFSSearchVideoView, "it.videoView");
        ab.d(qFSSearchVideoView, context.getResources().getDimension(R.dimen.dia));
        f16.f405714g.setProgressEnabled(true);
        Intrinsics.checkNotNullExpressionValue(f16, "inflate(LayoutInflater.f\u2026abled(true)\n            }");
        this.binding = f16;
        QFSSearchVideoPlayHelper qFSSearchVideoPlayHelper = new QFSSearchVideoPlayHelper(this, this, "qArt", QCircleDaTongConstant.PageId.PG_XSJ_SEARCH_RESULT_PAGE);
        qFSSearchVideoPlayHelper.T(f16.f405714g);
        qFSSearchVideoPlayHelper.R(this);
        qFSSearchVideoPlayHelper.P(true);
        qFSSearchVideoPlayHelper.O(RFWVideoFluencyExp9095.hitExpB());
        this.videoPlayHelper = qFSSearchVideoPlayHelper;
        this.operationTime = System.currentTimeMillis();
    }
}
