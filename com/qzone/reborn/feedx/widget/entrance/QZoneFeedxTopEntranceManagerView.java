package com.qzone.reborn.feedx.widget.entrance;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qzone.reborn.qzmoment.comment.event.QZoneFeedUnreadUpdateEvent;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001/B\u0011\b\u0016\u0012\u0006\u0010(\u001a\u00020'\u00a2\u0006\u0004\b)\u0010*B\u001b\b\u0016\u0012\u0006\u0010(\u001a\u00020'\u0012\b\u0010,\u001a\u0004\u0018\u00010+\u00a2\u0006\u0004\b)\u0010-J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u0018\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0014J$\u0010\u0011\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000f0\u000ej\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000f`\u0010H\u0016J\u0012\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u00060"}, d2 = {"Lcom/qzone/reborn/feedx/widget/entrance/QZoneFeedxTopEntranceManagerView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "n0", "o0", "", "getLayoutId", "m0", "obj", com.tencent.luggage.wxa.c8.c.G, "bindData", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "event", "onReceiveEvent", "p0", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "mContainerView", "Lcom/qzone/reborn/feedx/widget/entrance/QZoneFeedxBaseEntranceView;", "f", "Lcom/qzone/reborn/feedx/widget/entrance/QZoneFeedxBaseEntranceView;", "mCurEntranceView", h.F, "Ljava/lang/Integer;", "mCurEntranceType", "", "i", "Z", "mIsRegisterEvent", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneFeedxTopEntranceManagerView extends QZoneBaseWidgetView<Object> implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ViewGroup mContainerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QZoneFeedxBaseEntranceView mCurEntranceView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Integer mCurEntranceType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mIsRegisterEvent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneFeedxTopEntranceManagerView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        n0();
    }

    private final void o0() {
        ViewGroup viewGroup;
        Integer num = this.mCurEntranceType;
        QZoneFeedxTopEntranceViewFactory qZoneFeedxTopEntranceViewFactory = QZoneFeedxTopEntranceViewFactory.f56058a;
        int type = qZoneFeedxTopEntranceViewFactory.b().getType();
        if (num != null && num.intValue() == type) {
            p0();
            return;
        }
        Integer valueOf = Integer.valueOf(qZoneFeedxTopEntranceViewFactory.b().getType());
        this.mCurEntranceType = valueOf;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.mCurEntranceView = qZoneFeedxTopEntranceViewFactory.a(valueOf, context);
        if (this.mContainerView == null) {
            this.mContainerView = (ViewGroup) findViewById(R.id.n1s);
            m0();
        }
        ViewGroup viewGroup2 = this.mContainerView;
        if (viewGroup2 != null) {
            Intrinsics.checkNotNull(viewGroup2);
            if (viewGroup2.getChildCount() > 0) {
                ViewGroup viewGroup3 = this.mContainerView;
                Intrinsics.checkNotNull(viewGroup3);
                viewGroup3.removeAllViews();
            }
        }
        QZoneFeedxBaseEntranceView qZoneFeedxBaseEntranceView = this.mCurEntranceView;
        if (qZoneFeedxBaseEntranceView != null && (viewGroup = this.mContainerView) != null) {
            Intrinsics.checkNotNull(qZoneFeedxBaseEntranceView);
            viewGroup.addView(qZoneFeedxBaseEntranceView);
        }
        p0();
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int pos) {
        Intrinsics.checkNotNullParameter(obj, "obj");
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.ch5;
    }

    public final void m0() {
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
    }

    public void onDestroy() {
        QZoneFeedxBaseEntranceView qZoneFeedxBaseEntranceView = this.mCurEntranceView;
        if (qZoneFeedxBaseEntranceView != null) {
            qZoneFeedxBaseEntranceView.onDestroy();
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
    }

    public void onPause() {
        QZoneFeedxBaseEntranceView qZoneFeedxBaseEntranceView = this.mCurEntranceView;
        if (qZoneFeedxBaseEntranceView != null) {
            qZoneFeedxBaseEntranceView.onPause();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof QZoneFeedUnreadUpdateEvent) {
            o0();
            QZLog.d("QZoneFeedxTopEntranceManagerView", 1, "receive unread change event,containerView:" + this.mContainerView);
        }
    }

    public void onResume() {
        QZoneFeedxBaseEntranceView qZoneFeedxBaseEntranceView = this.mCurEntranceView;
        if (qZoneFeedxBaseEntranceView != null) {
            qZoneFeedxBaseEntranceView.onResume();
        }
        if (this.mIsRegisterEvent) {
            return;
        }
        this.mIsRegisterEvent = true;
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    public void p0() {
        QZoneFeedxBaseEntranceView qZoneFeedxBaseEntranceView = this.mCurEntranceView;
        if (qZoneFeedxBaseEntranceView != null) {
            qZoneFeedxBaseEntranceView.o0();
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QZoneFeedUnreadUpdateEvent.class);
        return arrayListOf;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneFeedxTopEntranceManagerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        n0();
    }

    private final void n0() {
        this.mContainerView = (ViewGroup) findViewById(R.id.n1s);
        m0();
        o0();
    }
}
