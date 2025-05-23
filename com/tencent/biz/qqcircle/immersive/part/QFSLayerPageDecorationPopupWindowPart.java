package com.tencent.biz.qqcircle.immersive.part;

import android.app.Activity;
import android.os.Bundle;
import android.util.Size;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.events.QFSLayerPageDecorationPopupEvent;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarDecorateView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$DecorateJumpInfo;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 <2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0001=B\u0007\u00a2\u0006\u0004\b:\u0010;J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0012\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u000eH\u0002J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\u001a\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0012\u0010\u001b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u001aH\u0016J$\u0010\u001f\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001d0\u001cj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001d`\u001eH\u0016J\b\u0010 \u001a\u00020\tH\u0016J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\fH\u0016R\u001b\u0010(\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u00109\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00106\u00a8\u0006>"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/QFSLayerPageDecorationPopupWindowPart;", "Lcom/tencent/biz/qqcircle/bizparts/b;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/qqcircle/events/QFSLayerPageDecorationPopupEvent;", "Landroid/view/View$OnClickListener;", "event", "", "C9", "initView", "", "show", "E9", "Landroid/view/View;", "view", "", "elementId", "A9", "eId", "z9", "getLogTag", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "onBackEvent", "v", NodeProps.ON_CLICK, "Landroid/util/Size;", "d", "Lkotlin/Lazy;", "B9", "()Landroid/util/Size;", "defIconSize", "e", "Landroid/view/View;", "popupWindow", "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "f", "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarView;", "ivIcon", "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarDecorateView;", tl.h.F, "Lcom/tencent/biz/qqcircle/widgets/QCircleAvatarDecorateView;", "ivIconDecorate", "Landroid/widget/TextView;", "i", "Landroid/widget/TextView;", "ivDecorateName", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "ivDecorateDesc", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSLayerPageDecorationPopupWindowPart extends com.tencent.biz.qqcircle.bizparts.b implements SimpleEventReceiver<QFSLayerPageDecorationPopupEvent>, View.OnClickListener {

    @NotNull
    private static final a C = new a(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy defIconSize;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View popupWindow;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QCircleAvatarView ivIcon;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QCircleAvatarDecorateView ivIconDecorate;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView ivDecorateName;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView ivDecorateDesc;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/part/QFSLayerPageDecorationPopupWindowPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    public QFSLayerPageDecorationPopupWindowPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Size>() { // from class: com.tencent.biz.qqcircle.immersive.part.QFSLayerPageDecorationPopupWindowPart$defIconSize$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Size invoke() {
                return com.tencent.biz.qqcircle.immersive.utils.n.a(QFSLayerPageDecorationPopupWindowPart.this.getContext(), R.dimen.d3o);
            }
        });
        this.defIconSize = lazy;
    }

    private final void A9(View view, String elementId) {
        VideoReport.setElementId(view, elementId);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.reportEvent("ev_xsj_abnormal_imp", view, new QCircleDTParamBuilder().buildElementParams());
    }

    private final Size B9() {
        Object value = this.defIconSize.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-defIconSize>(...)");
        return (Size) value;
    }

    private final void C9(final QFSLayerPageDecorationPopupEvent event) {
        initView();
        QCircleAvatarView qCircleAvatarView = this.ivIcon;
        if (qCircleAvatarView != null) {
            qCircleAvatarView.h();
            qCircleAvatarView.setAvatarByUin(HostDataTransUtils.getAccount(), B9());
        }
        final QCircleAvatarDecorateView qCircleAvatarDecorateView = this.ivIconDecorate;
        if (qCircleAvatarDecorateView != null) {
            qCircleAvatarDecorateView.post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.part.ck
                @Override // java.lang.Runnable
                public final void run() {
                    QFSLayerPageDecorationPopupWindowPart.D9(QCircleAvatarDecorateView.this, event);
                }
            });
        }
        FeedCloudMeta$DecorateJumpInfo feedCloudMeta$DecorateJumpInfo = event.getDecoration().jump_info;
        TextView textView = this.ivDecorateName;
        if (textView != null) {
            textView.setText(feedCloudMeta$DecorateJumpInfo.name.get());
        }
        TextView textView2 = this.ivDecorateDesc;
        if (textView2 != null) {
            textView2.setText(feedCloudMeta$DecorateJumpInfo.description.get());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D9(QCircleAvatarDecorateView this_apply, QFSLayerPageDecorationPopupEvent event) {
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        Intrinsics.checkNotNullParameter(event, "$event");
        this_apply.c(event.getDecoration().icon.get());
    }

    private final void E9(boolean show) {
        int i3;
        View view = this.popupWindow;
        if (view != null) {
            if (show) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            view.setVisibility(i3);
        }
    }

    private final void initView() {
        if (getPartRootView() == null) {
            return;
        }
        if (this.popupWindow == null) {
            View inflate = ((ViewStub) getPartRootView().findViewById(R.id.f365714x)).inflate();
            if (inflate != null) {
                this.ivIcon = (QCircleAvatarView) inflate.findViewById(R.id.dvu);
                this.ivIconDecorate = (QCircleAvatarDecorateView) inflate.findViewById(R.id.y4q);
                this.ivDecorateName = (TextView) inflate.findViewById(R.id.f107276_z);
                this.ivDecorateDesc = (TextView) inflate.findViewById(R.id.f107266_y);
                inflate.findViewById(R.id.f167033k60).setOnClickListener(this);
                inflate.findViewById(R.id.f109376fn).setOnClickListener(this);
            } else {
                inflate = null;
            }
            this.popupWindow = inflate;
        }
        View view = this.popupWindow;
        Intrinsics.checkNotNull(view);
        A9(view, QCircleDaTongConstant.ElementId.EM_XSJ_ACTIVITY_INVALID_WINDOW);
        E9(true);
    }

    private final void z9(View view, String eId) {
        VideoReport.setElementId(view, eId);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.reportEvent("ev_xsj_abnormal_clck", view, new QCircleDTParamBuilder().buildElementParams());
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<QFSLayerPageDecorationPopupEvent>> getEventClass() {
        ArrayList<Class<QFSLayerPageDecorationPopupEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QFSLayerPageDecorationPopupEvent.class);
        return arrayListOf;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSLayerPageDecorationPopupWindowPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        boolean z16;
        View view = this.popupWindow;
        if (view != null && view.getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            E9(false);
            return true;
        }
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (v3.getId() == R.id.f167033k60) {
            onBackEvent();
        } else if (v3.getId() == R.id.f109376fn) {
            z9(v3, QCircleDaTongConstant.ElementId.EM_XSJ_ACTIVITY_INVALID_WINDOW_MORE_BUTTON);
            com.tencent.biz.qqcircle.launcher.c.g(getContext(), com.tencent.biz.qqcircle.f.x());
            onBackEvent();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartCreate(activity, savedInstanceState);
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        QFSLayerPageDecorationPopupEvent qFSLayerPageDecorationPopupEvent;
        if (event instanceof QFSLayerPageDecorationPopupEvent) {
            qFSLayerPageDecorationPopupEvent = (QFSLayerPageDecorationPopupEvent) event;
        } else {
            qFSLayerPageDecorationPopupEvent = null;
        }
        if (qFSLayerPageDecorationPopupEvent != null) {
            C9((QFSLayerPageDecorationPopupEvent) event);
        }
    }
}
