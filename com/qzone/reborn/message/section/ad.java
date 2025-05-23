package com.qzone.reborn.message.section;

import android.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import bl.CommonNoticeBean;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.message.event.QZoneNoticeReplySuccessEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import java.util.List;
import kotlin.C11736d;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 +2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001,B\u0007\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0014J\b\u0010\f\u001a\u00020\u0005H\u0016J*\u0010\u0014\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0014J$\u0010\u0018\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00160\u0015j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0016`\u0017H\u0016J\u0012\u0010\u001a\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0019H\u0016R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010(\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lcom/qzone/reborn/message/section/ad;", "Lcom/qzone/reborn/message/section/y;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/qzone/reborn/message/event/QZoneNoticeReplySuccessEvent;", "event", "", UserInfo.SEX_FEMALE, "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lbl/a;", "data", "", "position", "", "", "payload", "H", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "onReceiveEvent", "Landroid/widget/FrameLayout;", "i", "Landroid/widget/FrameLayout;", "rootContainer", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "summaryText", "Landroid/view/ViewGroup;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/ViewGroup;", "toastView", "D", "Lbl/a;", "curNoticeBean", "<init>", "()V", "E", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ad extends y implements SimpleEventReceiver<QZoneNoticeReplySuccessEvent> {

    /* renamed from: C, reason: from kotlin metadata */
    private ViewGroup toastView;

    /* renamed from: D, reason: from kotlin metadata */
    private CommonNoticeBean curNoticeBean;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private FrameLayout rootContainer;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View summaryText;

    private final void F(QZoneNoticeReplySuccessEvent event) {
        if (event.getNoticeIndex() == this.mPosition) {
            ViewGroup viewGroup = this.toastView;
            FrameLayout frameLayout = null;
            ViewGroup.LayoutParams layoutParams = viewGroup != null ? viewGroup.getLayoutParams() : null;
            FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            }
            layoutParams2.gravity = 17;
            FrameLayout frameLayout2 = this.rootContainer;
            if (frameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
            } else {
                frameLayout = frameLayout2;
            }
            frameLayout.addView(this.toastView, layoutParams2);
            C11736d.b(2000, new Runnable() { // from class: com.qzone.reborn.message.section.ac
                @Override // java.lang.Runnable
                public final void run() {
                    ad.G(ad.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(ad this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FrameLayout frameLayout = this$0.rootContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
            frameLayout = null;
        }
        frameLayout.removeView(this$0.toastView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public void onBindData(CommonNoticeBean data, int position, List<Object> payload) {
        this.curNoticeBean = data;
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onDestroy() {
        super.onDestroy();
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        FrameLayout frameLayout = this.rootContainer;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
            frameLayout = null;
        }
        frameLayout.removeView(this.toastView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = p().findViewById(R.id.content);
        Intrinsics.checkNotNullExpressionValue(findViewById, "activity.findViewById(android.R.id.content)");
        this.rootContainer = (FrameLayout) findViewById;
        View findViewById2 = getRootView().findViewById(com.tencent.mobileqq.R.id.n7r);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.qzone_message_text)");
        this.summaryText = findViewById2;
        View inflate = LayoutInflater.from(p()).inflate(com.tencent.mobileqq.R.layout.cmd, (ViewGroup) null);
        this.toastView = inflate instanceof ViewGroup ? (ViewGroup) inflate : null;
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        if (event instanceof QZoneNoticeReplySuccessEvent) {
            F((QZoneNoticeReplySuccessEvent) event);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<QZoneNoticeReplySuccessEvent>> getEventClass() {
        ArrayList<Class<QZoneNoticeReplySuccessEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(QZoneNoticeReplySuccessEvent.class);
        return arrayListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[0];
    }
}
