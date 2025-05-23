package com.tencent.biz.qqcircle.immersive.floatingwindow.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindow;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p40.u;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 G2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002HIB\u0011\b\u0016\u0012\u0006\u0010>\u001a\u00020=\u00a2\u0006\u0004\b?\u0010@B\u001b\b\u0016\u0012\u0006\u0010>\u001a\u00020=\u0012\b\u0010B\u001a\u0004\u0018\u00010A\u00a2\u0006\u0004\b?\u0010CB#\b\u0016\u0012\u0006\u0010>\u001a\u00020=\u0012\b\u0010B\u001a\u0004\u0018\u00010A\u0012\u0006\u0010E\u001a\u00020D\u00a2\u0006\u0004\b?\u0010FJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\bH\u0002J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0015\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\bJ\u000e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\bJ\u0006\u0010\u001a\u001a\u00020\u0004J\u0006\u0010\u001b\u001a\u00020\u0004R\"\u0010\"\u001a\u00020\u00018\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u0010#R\u0016\u0010'\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0005\u0010&R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010&R\u0016\u0010)\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010&R\u0016\u0010*\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000f\u0010&R\u0016\u0010,\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010&R\u0016\u0010.\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010&R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u0010\u0016\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00104R\u0016\u00108\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00104R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;\u00a8\u0006J"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/floatingwindow/view/QFSVideoFloatWindowView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "Lp40/a;", "", "f", "g", "e", "", "isVisible", "k", "Landroid/view/View;", "view", "j", "canClickable", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "v", NodeProps.ON_CLICK, "Le30/b;", "targetFeed", "isFirstFeed", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "isMute", DomainData.DOMAIN_NAME, "isPlay", "l", "i", h.F, "d", "Landroid/widget/FrameLayout;", "getVideoContainer", "()Landroid/widget/FrameLayout;", "setVideoContainer", "(Landroid/widget/FrameLayout;)V", "videoContainer", "Landroid/view/View;", "btnVisibleControlView", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "volumeBtn", "playBtn", "closeBtn", "largerBtn", BdhLogUtil.LogTag.Tag_Conn, "previousBtn", "D", "nextBtn", "Lfeedcloud/FeedCloudMeta$StFeed;", "E", "Lfeedcloud/FeedCloudMeta$StFeed;", "currFeed", UserInfo.SEX_FEMALE, "Z", "isBtnVisible", "G", "H", "isPlaying", "Ljava/lang/Runnable;", "I", "Ljava/lang/Runnable;", "hideBtnRunnable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "J", "a", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSVideoFloatWindowView extends FrameLayout implements View.OnClickListener, p40.a {

    /* renamed from: C, reason: from kotlin metadata */
    private ImageView previousBtn;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView nextBtn;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private FeedCloudMeta$StFeed currFeed;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isBtnVisible;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isMute;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isPlaying;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private Runnable hideBtnRunnable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public FrameLayout videoContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View btnVisibleControlView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView volumeBtn;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ImageView playBtn;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ImageView closeBtn;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ImageView largerBtn;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\r\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/floatingwindow/view/QFSVideoFloatWindowView$b;", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "", "a", "event", "", "", "getDynamicParams", "Ljava/lang/String;", "getBtnType", "()Ljava/lang/String;", "btnType", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/biz/qqcircle/immersive/floatingwindow/view/QFSVideoFloatWindowView;", "b", "Ljava/lang/ref/WeakReference;", "viewRef", "view", "<init>", "(Ljava/lang/String;Lcom/tencent/biz/qqcircle/immersive/floatingwindow/view/QFSVideoFloatWindowView;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b implements IDynamicParams {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String btnType;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<QFSVideoFloatWindowView> viewRef;

        public b(@NotNull String btnType, @NotNull QFSVideoFloatWindowView view) {
            Intrinsics.checkNotNullParameter(btnType, "btnType");
            Intrinsics.checkNotNullParameter(view, "view");
            this.btnType = btnType;
            this.viewRef = new WeakReference<>(view);
        }

        private final String a() {
            if (!Intrinsics.areEqual(this.btnType, "play")) {
                return this.btnType;
            }
            QFSVideoFloatWindowView qFSVideoFloatWindowView = this.viewRef.get();
            boolean z16 = false;
            if (qFSVideoFloatWindowView != null && qFSVideoFloatWindowView.isPlaying) {
                z16 = true;
            }
            if (!z16) {
                return "play";
            }
            return QCircleDaTongConstant.ElementParamValue.SUSPEND;
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        @NotNull
        public Map<String, Object> getDynamicParams(@NotNull String event) {
            FeedCloudMeta$StFeed feedCloudMeta$StFeed;
            Intrinsics.checkNotNullParameter(event, "event");
            Map<String, Object> map = new QCircleDTParamBuilder().buildElementParams();
            Intrinsics.checkNotNullExpressionValue(map, "map");
            map.put(QCircleDaTongConstant.ElementParamKey.XSJ_TYPE, a());
            QFSVideoFloatWindowView qFSVideoFloatWindowView = this.viewRef.get();
            if (qFSVideoFloatWindowView != null && (feedCloudMeta$StFeed = qFSVideoFloatWindowView.currFeed) != null) {
                map.put("xsj_feed_id", feedCloudMeta$StFeed.f398449id.get());
                map.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, feedCloudMeta$StFeed.poster.f398463id.get());
                map.put("xsj_custom_pgid", QCircleDaTongConstant.PageId.PG_XSJ_SMALL_WINDOW_PLAY_PAGE);
            }
            return map;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QFSVideoFloatWindowView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(QFSVideoFloatWindowView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.k(false);
    }

    private final void e() {
        VideoReport.setPageId(this, QCircleDaTongConstant.PageId.PG_XSJ_SMALL_WINDOW_PLAY_PAGE);
        ImageView imageView = this.playBtn;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playBtn");
            imageView = null;
        }
        VideoReport.setElementId(imageView, QCircleDaTongConstant.ElementId.EM_XSJ_SMALL_WINDOW_OPERATE);
        ImageView imageView3 = this.playBtn;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playBtn");
            imageView3 = null;
        }
        VideoReport.setEventDynamicParams(imageView3, new b("play", this));
        ImageView imageView4 = this.playBtn;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playBtn");
            imageView4 = null;
        }
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        VideoReport.setElementClickPolicy(imageView4, clickPolicy);
        ImageView imageView5 = this.closeBtn;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeBtn");
            imageView5 = null;
        }
        VideoReport.setElementId(imageView5, QCircleDaTongConstant.ElementId.EM_XSJ_SMALL_WINDOW_OPERATE);
        ImageView imageView6 = this.closeBtn;
        if (imageView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeBtn");
            imageView6 = null;
        }
        VideoReport.setEventDynamicParams(imageView6, new b("close", this));
        ImageView imageView7 = this.closeBtn;
        if (imageView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeBtn");
            imageView7 = null;
        }
        VideoReport.setElementClickPolicy(imageView7, clickPolicy);
        ImageView imageView8 = this.largerBtn;
        if (imageView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("largerBtn");
            imageView8 = null;
        }
        VideoReport.setElementId(imageView8, QCircleDaTongConstant.ElementId.EM_XSJ_SMALL_WINDOW_OPERATE);
        ImageView imageView9 = this.largerBtn;
        if (imageView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("largerBtn");
            imageView9 = null;
        }
        VideoReport.setEventDynamicParams(imageView9, new b(CanvasView.ACTION_RESTORE, this));
        ImageView imageView10 = this.largerBtn;
        if (imageView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("largerBtn");
            imageView10 = null;
        }
        VideoReport.setElementClickPolicy(imageView10, clickPolicy);
        ImageView imageView11 = this.previousBtn;
        if (imageView11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previousBtn");
            imageView11 = null;
        }
        VideoReport.setElementId(imageView11, QCircleDaTongConstant.ElementId.EM_XSJ_SMALL_WINDOW_OPERATE);
        ImageView imageView12 = this.previousBtn;
        if (imageView12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previousBtn");
            imageView12 = null;
        }
        VideoReport.setEventDynamicParams(imageView12, new b("previous", this));
        ImageView imageView13 = this.previousBtn;
        if (imageView13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previousBtn");
            imageView13 = null;
        }
        VideoReport.setElementClickPolicy(imageView13, clickPolicy);
        ImageView imageView14 = this.nextBtn;
        if (imageView14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nextBtn");
            imageView14 = null;
        }
        VideoReport.setElementId(imageView14, QCircleDaTongConstant.ElementId.EM_XSJ_SMALL_WINDOW_OPERATE);
        ImageView imageView15 = this.nextBtn;
        if (imageView15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nextBtn");
            imageView15 = null;
        }
        VideoReport.setEventDynamicParams(imageView15, new b("next", this));
        ImageView imageView16 = this.nextBtn;
        if (imageView16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nextBtn");
            imageView16 = null;
        }
        VideoReport.setElementClickPolicy(imageView16, clickPolicy);
        ImageView imageView17 = this.volumeBtn;
        if (imageView17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("volumeBtn");
            imageView17 = null;
        }
        VideoReport.setElementId(imageView17, QCircleDaTongConstant.ElementId.EM_XSJ_SMALL_WINDOW_OPERATE);
        ImageView imageView18 = this.volumeBtn;
        if (imageView18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("volumeBtn");
            imageView18 = null;
        }
        VideoReport.setEventDynamicParams(imageView18, new b("mute", this));
        ImageView imageView19 = this.volumeBtn;
        if (imageView19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("volumeBtn");
        } else {
            imageView2 = imageView19;
        }
        VideoReport.setElementClickPolicy(imageView2, clickPolicy);
    }

    private final void f() {
        View.inflate(getContext(), R.layout.gtk, this);
        View findViewById = findViewById(R.id.f57092md);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qfs_vi\u2026_window_btn_visible_view)");
        this.btnVisibleControlView = findViewById;
        View findViewById2 = findViewById(R.id.f57152mj);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.qfs_vi\u2026t_window_video_container)");
        setVideoContainer((FrameLayout) findViewById2);
        View findViewById3 = findViewById(R.id.f57162mk);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qfs_vi\u2026_float_window_volume_btn)");
        this.volumeBtn = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.f57132mh);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.qfs_video_float_window_play_btn)");
        this.playBtn = (ImageView) findViewById4;
        View findViewById5 = findViewById(R.id.f57102me);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.qfs_vi\u2026o_float_window_close_btn)");
        this.closeBtn = (ImageView) findViewById5;
        View findViewById6 = findViewById(R.id.f57112mf);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.qfs_vi\u2026_float_window_larger_btn)");
        this.largerBtn = (ImageView) findViewById6;
        View findViewById7 = findViewById(R.id.f57142mi);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.qfs_vi\u2026loat_window_previous_btn)");
        this.previousBtn = (ImageView) findViewById7;
        View findViewById8 = findViewById(R.id.f57122mg);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.qfs_video_float_window_next_btn)");
        this.nextBtn = (ImageView) findViewById8;
        View view = this.btnVisibleControlView;
        ImageView imageView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnVisibleControlView");
            view = null;
        }
        view.setOnClickListener(this);
        ImageView imageView2 = this.volumeBtn;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("volumeBtn");
            imageView2 = null;
        }
        imageView2.setOnClickListener(this);
        ImageView imageView3 = this.playBtn;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playBtn");
            imageView3 = null;
        }
        imageView3.setOnClickListener(this);
        ImageView imageView4 = this.closeBtn;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeBtn");
            imageView4 = null;
        }
        imageView4.setOnClickListener(this);
        ImageView imageView5 = this.largerBtn;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("largerBtn");
            imageView5 = null;
        }
        imageView5.setOnClickListener(this);
        ImageView imageView6 = this.previousBtn;
        if (imageView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previousBtn");
            imageView6 = null;
        }
        imageView6.setOnClickListener(this);
        ImageView imageView7 = this.nextBtn;
        if (imageView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nextBtn");
        } else {
            imageView = imageView7;
        }
        imageView.setOnClickListener(this);
        g();
        e();
    }

    private final void g() {
        boolean i06 = u.H().i0();
        this.isMute = i06;
        n(i06);
    }

    private final void j(View view, boolean isVisible) {
        int i3;
        if (isVisible) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
    }

    private final void k(boolean isVisible) {
        this.isBtnVisible = isVisible;
        ImageView imageView = this.volumeBtn;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("volumeBtn");
            imageView = null;
        }
        j(imageView, isVisible);
        ImageView imageView3 = this.playBtn;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playBtn");
            imageView3 = null;
        }
        j(imageView3, isVisible);
        ImageView imageView4 = this.closeBtn;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeBtn");
            imageView4 = null;
        }
        j(imageView4, isVisible);
        ImageView imageView5 = this.largerBtn;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("largerBtn");
            imageView5 = null;
        }
        j(imageView5, isVisible);
        ImageView imageView6 = this.previousBtn;
        if (imageView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("previousBtn");
            imageView6 = null;
        }
        j(imageView6, isVisible);
        ImageView imageView7 = this.nextBtn;
        if (imageView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("nextBtn");
        } else {
            imageView2 = imageView7;
        }
        j(imageView2, isVisible);
        if (isVisible) {
            postDelayed(this.hideBtnRunnable, 3000L);
        } else {
            removeCallbacks(this.hideBtnRunnable);
        }
        QLog.d("QFSVideoFloatWindowView", 1, "updateAllBtnVisible visible:" + this.isBtnVisible);
    }

    private final void m(boolean canClickable) {
        ImageView imageView = null;
        if (canClickable) {
            ImageView imageView2 = this.previousBtn;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("previousBtn");
                imageView2 = null;
            }
            if (!imageView2.isClickable()) {
                ImageView imageView3 = this.previousBtn;
                if (imageView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("previousBtn");
                    imageView3 = null;
                }
                imageView3.setAlpha(1.0f);
                ImageView imageView4 = this.previousBtn;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("previousBtn");
                } else {
                    imageView = imageView4;
                }
                imageView.setClickable(true);
                return;
            }
        }
        if (!canClickable) {
            ImageView imageView5 = this.previousBtn;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("previousBtn");
                imageView5 = null;
            }
            if (imageView5.isClickable()) {
                ImageView imageView6 = this.previousBtn;
                if (imageView6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("previousBtn");
                    imageView6 = null;
                }
                imageView6.setAlpha(0.5f);
                ImageView imageView7 = this.previousBtn;
                if (imageView7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("previousBtn");
                } else {
                    imageView = imageView7;
                }
                imageView.setClickable(false);
            }
        }
    }

    public final void h() {
        removeCallbacks(this.hideBtnRunnable);
    }

    public final void i() {
        k(true);
    }

    public final void l(boolean isPlay) {
        int i3;
        this.isPlaying = isPlay;
        if (isPlay) {
            i3 = R.drawable.qui_pause_filled_white;
        } else {
            i3 = R.drawable.qui_play_filled_icon_white;
        }
        Drawable drawable = getContext().getResources().getDrawable(i3);
        ImageView imageView = this.playBtn;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("playBtn");
            imageView = null;
        }
        imageView.setImageDrawable(drawable);
    }

    public final void n(boolean isMute) {
        int i3;
        if (isMute) {
            i3 = R.drawable.qui_voice_mute_icon_white;
        } else {
            i3 = R.drawable.qui_voice_high_icon_white;
        }
        Drawable drawable = getContext().getResources().getDrawable(i3);
        ImageView imageView = this.volumeBtn;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("volumeBtn");
            imageView = null;
        }
        imageView.setImageDrawable(drawable);
        this.isMute = isMute;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            num = Integer.valueOf(v3.getId());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == R.id.f57092md) {
            k(!this.isBtnVisible);
        } else if (num != null && num.intValue() == R.id.f57162mk) {
            boolean z16 = !this.isMute;
            this.isMute = z16;
            n(z16);
            if (this.isMute) {
                u.H().h();
            } else {
                u.H().l();
            }
        } else if (num != null && num.intValue() == R.id.f57132mh) {
            boolean z17 = !this.isPlaying;
            this.isPlaying = z17;
            l(z17);
            if (this.isPlaying) {
                u.H().onPlay();
            } else {
                u.H().onPlay();
            }
        } else if (num != null && num.intValue() == R.id.f57102me) {
            u.H().o();
            ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).quitFloatingScreen(c.class.getName());
        } else if (num != null && num.intValue() == R.id.f57112mf) {
            u.H().d();
            ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).quitFloatingScreen(c.class.getName());
        } else if (num != null && num.intValue() == R.id.f57142mi) {
            this.isPlaying = true;
            l(true);
        } else if (num != null && num.intValue() == R.id.f57122mg) {
            this.isPlaying = true;
            l(true);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // p40.a
    public void q(@Nullable e30.b targetFeed, boolean isFirstFeed) {
        if (isFirstFeed) {
            m(false);
        } else {
            m(true);
        }
        this.isPlaying = true;
        l(true);
        if (targetFeed != null) {
            if (gb0.b.z(targetFeed.g())) {
                ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).updateFloatingWindowSize(cx.a(268.0f), cx.a(150.0f), c.class.getName());
            } else {
                ((IQQFloatingWindow) QRoute.api(IQQFloatingWindow.class)).updateFloatingWindowSize(cx.a(150.0f), cx.a(268.0f), c.class.getName());
            }
            this.currFeed = targetFeed.g();
        }
    }

    public final void setVideoContainer(@NotNull FrameLayout frameLayout) {
        Intrinsics.checkNotNullParameter(frameLayout, "<set-?>");
        this.videoContainer = frameLayout;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QFSVideoFloatWindowView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QFSVideoFloatWindowView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isBtnVisible = true;
        this.isPlaying = true;
        this.hideBtnRunnable = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.floatingwindow.view.b
            @Override // java.lang.Runnable
            public final void run() {
                QFSVideoFloatWindowView.d(QFSVideoFloatWindowView.this);
            }
        };
        f();
    }
}
