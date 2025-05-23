package com.qzone.reborn.feedx.widget.entrance;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.qzone.app.QZoneFeedAlertService;
import com.qzone.reborn.widget.m;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.service.qzone.QZoneIntimateEntranceManager;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mobileqq.widget.listitem.QUIListItemStyle;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.ArrayUtils;
import common.config.service.QZoneConfigHelper;
import cooperation.qzone.UndealCount.QZoneCountInfo;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 32\u00020\u0001:\u00014B\u0011\b\u0016\u0012\u0006\u0010-\u001a\u00020,\u00a2\u0006\u0004\b.\u0010/B\u001b\b\u0016\u0012\u0006\u0010-\u001a\u00020,\u0012\b\u00101\u001a\u0004\u0018\u000100\u00a2\u0006\u0004\b.\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\nH\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0002J\b\u0010\u0013\u001a\u00020\u0002H\u0002J\b\u0010\u0014\u001a\u00020\u0002H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u001a\u0010\u001a\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\u0015H\u0014J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\b\u0010\u001d\u001a\u00020\u0002H\u0016J\b\u0010\u001e\u001a\u00020\u0002H\u0016J\b\u0010\u001f\u001a\u00020\u0002H\u0014J\u0006\u0010 \u001a\u00020\u0002R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00065"}, d2 = {"Lcom/qzone/reborn/feedx/widget/entrance/QZoneFeedxTopIntimateEntranceView;", "Lcom/qzone/reborn/feedx/widget/entrance/QZoneFeedxBaseEntranceView;", "", "x0", "I0", "v0", "", "rightText", "H0", "avatarUin", "", "showRedPoint", "F0", "Lcom/tencent/mobileqq/widget/listitem/x$b$b;", "A0", "z0", "D0", "E0", "C0", "w0", "s0", "", "getLayoutId", "", "objData", com.tencent.luggage.wxa.c8.c.G, "bindData", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "o0", NodeProps.ON_DETACHED_FROM_WINDOW, "B0", "Landroid/view/View;", "e", "Landroid/view/View;", "mBubbleTipAlignView", "Lcom/tencent/mobileqq/widget/listitem/QUISingleLineListItem;", "f", "Lcom/tencent/mobileqq/widget/listitem/QUISingleLineListItem;", "mSingleListItem", h.F, "Ljava/lang/String;", "guideOpenSpaceUin", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "i", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneFeedxTopIntimateEntranceView extends QZoneFeedxBaseEntranceView {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View mBubbleTipAlignView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QUISingleLineListItem mSingleListItem;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String guideOpenSpaceUin;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneFeedxTopIntimateEntranceView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.guideOpenSpaceUin = "";
        x0();
    }

    private final x.b.C8996b A0() {
        String W = QZoneConfigHelper.W();
        Intrinsics.checkNotNullExpressionValue(W, "getIntimateSpaceName()");
        return new x.b.C8996b(W, R.drawable.qui_intimates_space);
    }

    private final void C0() {
        if (TextUtils.isEmpty(this.guideOpenSpaceUin)) {
            return;
        }
        F0("", this.guideOpenSpaceUin, false);
    }

    private final void D0() {
        String entranceText = QZoneIntimateEntranceManager.j();
        Intrinsics.checkNotNullExpressionValue(entranceText, "entranceText");
        H0(entranceText);
    }

    private final void E0() {
        QZoneCountInfo singleUnReadItem = QZoneFeedAlertService.getInstance().getSingleUnReadItem(72);
        String avatarUrl = QZoneIntimateEntranceManager.i(singleUnReadItem);
        if (TextUtils.isEmpty(avatarUrl)) {
            if (!TextUtils.isEmpty(this.guideOpenSpaceUin)) {
                C0();
                return;
            } else {
                D0();
                return;
            }
        }
        String rightText = QZoneIntimateEntranceManager.l(singleUnReadItem);
        Intrinsics.checkNotNullExpressionValue(rightText, "rightText");
        Intrinsics.checkNotNullExpressionValue(avatarUrl, "avatarUrl");
        F0(rightText, avatarUrl, true);
    }

    private final void F0(String rightText, String avatarUin, boolean showRedPoint) {
        if (TextUtils.isEmpty(avatarUin)) {
            QLog.e("QZoneFeedxIntimateEntranceView", 1, "[avatarConfig] avatarUin is null");
            return;
        }
        QLog.i("QZoneFeedxIntimateEntranceView", 1, "[avatarConfig] rightText is " + rightText + ", avatarUin is " + avatarUin);
        QUISingleLineListItem qUISingleLineListItem = this.mSingleListItem;
        if (qUISingleLineListItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSingleListItem");
            qUISingleLineListItem = null;
        }
        qUISingleLineListItem.setConfig(new m(A0(), new x.c.a(rightText, avatarUin, true, showRedPoint)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(QZoneFeedxTopIntimateEntranceView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.z0()) {
            this$0.E0();
        } else if (!TextUtils.isEmpty(this$0.guideOpenSpaceUin)) {
            this$0.C0();
        } else {
            this$0.D0();
        }
    }

    private final void H0(String rightText) {
        QLog.i("QZoneFeedxIntimateEntranceView", 1, "[updateEntranceTextConfig] rightText is " + rightText);
        QUISingleLineListItem qUISingleLineListItem = this.mSingleListItem;
        if (qUISingleLineListItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSingleListItem");
            qUISingleLineListItem = null;
        }
        qUISingleLineListItem.setConfig(new m(A0(), new x.c.g(rightText, true, false)));
    }

    private final void s0() {
        if (z0() || !TextUtils.isEmpty(this.guideOpenSpaceUin)) {
            this.guideOpenSpaceUin = "";
            RFWThreadManager.getInstance().postMainDelay(new Runnable() { // from class: com.qzone.reborn.feedx.widget.entrance.c
                @Override // java.lang.Runnable
                public final void run() {
                    QZoneFeedxTopIntimateEntranceView.u0(QZoneFeedxTopIntimateEntranceView.this);
                }
            }, 2000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u0(QZoneFeedxTopIntimateEntranceView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.D0();
        QZoneFeedAlertService.getInstance().clearSingleUnreadCount(72);
        QZoneFeedAlertService.getInstance().clearSingleUnreadCount(74);
    }

    private final void v0() {
        HashMap hashMap = new HashMap();
        hashMap.put("entry_state", Integer.valueOf(z0() ? 1 : 0));
        fo.c.o(getRootView(), "em_bas_chum_space_entry", new fo.b().l(hashMap));
    }

    private final void w0() {
        if (com.qzone.util.h.a()) {
            return;
        }
        StringBuilder sb5 = new StringBuilder(QZoneConfigHelper.p0());
        if (getContext() != null && !TextUtils.isEmpty(sb5)) {
            sb5.append("&from=");
            sb5.append(9);
            QLog.d("QZoneFeedxIntimateEntranceView", 1, "[handleEntranceItemClick] jump_url = " + ((Object) sb5));
            yo.d.d(sb5.toString(), getContext(), null);
            s0();
            return;
        }
        QLog.e("QZoneFeedxIntimateEntranceView", 1, "[handleEntranceItemClick] jump_url is empty");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(QZoneFeedxTopIntimateEntranceView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.w0();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean z0() {
        return QZoneFeedAlertService.getInstance().getSingleUnreadCount(72) > 0 && QZoneFeedAlertService.getInstance().getSingleUnReadItem(72) != null;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object objData, int pos) {
        o0();
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.hm8;
    }

    @Override // com.qzone.reborn.feedx.widget.entrance.QZoneFeedxBaseEntranceView
    public void o0() {
        I0();
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.feedx.widget.entrance.a
            @Override // java.lang.Runnable
            public final void run() {
                QZoneFeedxTopIntimateEntranceView.G0(QZoneFeedxTopIntimateEntranceView.this);
            }
        });
    }

    @Override // com.qzone.reborn.feedx.widget.entrance.QZoneFeedxBaseEntranceView
    public void onDestroy() {
        super.onDestroy();
        B0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        B0();
    }

    @Override // com.qzone.reborn.feedx.widget.entrance.QZoneFeedxBaseEntranceView
    public void onPause() {
        B0();
    }

    @Override // com.qzone.reborn.feedx.widget.entrance.QZoneFeedxBaseEntranceView
    public void onResume() {
        o0();
    }

    private final void I0() {
        ArrayList<String> g16 = QZoneIntimateEntranceManager.g(1);
        if (ArrayUtils.isOutOfArrayIndex(0, g16)) {
            return;
        }
        String str = g16.get(0);
        Intrinsics.checkNotNullExpressionValue(str, "entranceAvatarUinList[0]");
        this.guideOpenSpaceUin = str;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneFeedxTopIntimateEntranceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.guideOpenSpaceUin = "";
        x0();
    }

    private final void x0() {
        View findViewById = findViewById(R.id.yjj);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(com.tencent\u2026.R.id.list_item_entrance)");
        this.mSingleListItem = (QUISingleLineListItem) findViewById;
        View findViewById2 = findViewById(R.id.f165100uw0);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(com.tencent\u2026ntrance_bubble_tip_align)");
        this.mBubbleTipAlignView = findViewById2;
        View rootView = getRootView();
        if (rootView != null) {
            rootView.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.widget.entrance.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    QZoneFeedxTopIntimateEntranceView.y0(QZoneFeedxTopIntimateEntranceView.this, view);
                }
            });
        }
        QUISingleLineListItem qUISingleLineListItem = this.mSingleListItem;
        QUISingleLineListItem qUISingleLineListItem2 = null;
        if (qUISingleLineListItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSingleListItem");
            qUISingleLineListItem = null;
        }
        qUISingleLineListItem.setBackgroundType(QUIListItemBackgroundType.FullWidth);
        QUISingleLineListItem qUISingleLineListItem3 = this.mSingleListItem;
        if (qUISingleLineListItem3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSingleListItem");
        } else {
            qUISingleLineListItem2 = qUISingleLineListItem3;
        }
        qUISingleLineListItem2.setStyle(QUIListItemStyle.FullWidth);
        m0();
        n0();
        v0();
    }

    public final void B0() {
    }
}
