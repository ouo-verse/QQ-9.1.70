package com.qzone.reborn.intimate.widget;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.intimate.block.QZoneIntimateFeedListHeaderBlock;
import com.qzone.reborn.intimate.event.QZIntimateShowCheckInRemindDialogEvent;
import com.qzone.reborn.intimate.event.QZIntimateShowSettingDialogEvent;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseAlbumMeta$AlbumInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 :2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001;B\u001f\u0012\u0006\u00106\u001a\u000205\u0012\u0006\u00107\u001a\u00020\u001c\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b8\u00109J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u0003H\u0002J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0007H\u0002J\b\u0010\u0013\u001a\u00020\u0003H\u0002J\u000e\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014J\u0006\u0010\u0017\u001a\u00020\u0003J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\u0018\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0007H\u0014R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\"\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010(\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010%R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00104\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010-\u00a8\u0006<"}, d2 = {"Lcom/qzone/reborn/intimate/widget/QZIntimateFeedListHeaderView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "Lqzone/QZoneBaseAlbumMeta$AlbumInfo;", "", "C0", "y0", "F0", "", "type", "z0", "G0", "L0", "O0", "", "state", "I0", "S0", "lastShowType", "B0", "E0", "Lij/c;", "bean", "V0", "A0", "getLayoutId", "objData", com.tencent.luggage.wxa.c8.c.G, "x0", "Lcom/qzone/reborn/intimate/block/QZoneIntimateFeedListHeaderBlock;", "e", "Lcom/qzone/reborn/intimate/block/QZoneIntimateFeedListHeaderBlock;", "parentBlock", "f", "I", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TYPE, "Landroid/view/View;", tl.h.F, "Landroid/view/View;", "bannerRoot", "i", "closeBtn", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "functionBtn", "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/TextView;", "functionText", "Landroid/widget/ImageView;", "D", "Landroid/widget/ImageView;", "leftIcon", "E", "guideText", "Landroid/content/Context;", "context", "block", "<init>", "(Landroid/content/Context;Lcom/qzone/reborn/intimate/block/QZoneIntimateFeedListHeaderBlock;I)V", UserInfo.SEX_FEMALE, "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZIntimateFeedListHeaderView extends QZoneBaseWidgetView<QZoneBaseAlbumMeta$AlbumInfo> {

    /* renamed from: C, reason: from kotlin metadata */
    private TextView functionText;

    /* renamed from: D, reason: from kotlin metadata */
    private ImageView leftIcon;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView guideText;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QZoneIntimateFeedListHeaderBlock parentBlock;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int showType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private View bannerRoot;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View closeBtn;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private View functionBtn;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZIntimateFeedListHeaderView(Context context, QZoneIntimateFeedListHeaderBlock block, int i3) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(block, "block");
        this.showType = i3;
        this.parentBlock = block;
        this.bannerRoot = findViewById(R.id.kmz);
        this.leftIcon = (ImageView) findViewById(R.id.f191951);
        this.functionBtn = findViewById(R.id.f19154x);
        this.functionText = (TextView) findViewById(R.id.f19164y);
        this.guideText = (TextView) findViewById(R.id.f19174z);
        this.closeBtn = findViewById(R.id.f191850);
        if (com.qzone.reborn.util.k.f59549a.f()) {
            View view = this.bannerRoot;
            if (view != null) {
                view.setBackgroundResource(R.drawable.f14297g);
            }
        } else {
            View view2 = this.bannerRoot;
            if (view2 != null) {
                view2.setBackgroundResource(R.drawable.f14287f);
            }
        }
        setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
        z0(i3);
    }

    private final void C0() {
        fo.b bVar = new fo.b();
        bVar.h(new IDynamicParams() { // from class: com.qzone.reborn.intimate.widget.j
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map D0;
                D0 = QZIntimateFeedListHeaderView.D0(QZIntimateFeedListHeaderView.this, str);
                return D0;
            }
        });
        fo.c.o(this, "em_qz_sync_old_couple_space_entry", bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map D0(QZIntimateFeedListHeaderView this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("synchronous_state", Integer.valueOf(this$0.showType));
        return linkedHashMap;
    }

    private final void E0() {
        if (this.showType == 0) {
            this.parentBlock.y0();
        }
    }

    private final void F0() {
        fo.c.q(this.functionText, "em_qz_open_remind_btn", null);
    }

    private final void G0() {
        if (!this.parentBlock.o0()) {
            this.parentBlock.setBlockVisible(false);
            return;
        }
        QLog.i("QZIntimateFeedListHeaderView", 1, "showAtSyncGuide");
        this.showType = 2;
        ImageView imageView = this.leftIcon;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.qui_shuoshuo);
        }
        ImageView imageView2 = this.leftIcon;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
        TextView textView = this.guideText;
        if (textView != null) {
            textView.setText(HardCodeUtil.qqStr(R.string.wb5));
        }
        View view = this.closeBtn;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.intimate.widget.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    QZIntimateFeedListHeaderView.H0(QZIntimateFeedListHeaderView.this, view2);
                }
            });
        }
        View view2 = this.functionBtn;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        TextView textView2 = this.functionText;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        View view3 = this.bannerRoot;
        if (view3 == null) {
            return;
        }
        view3.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(QZIntimateFeedListHeaderView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.B0(2);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void I0(boolean state) {
        if (!this.parentBlock.p0()) {
            QLog.i("QZIntimateFeedListHeaderView", 1, "can not show check in remind any more");
            return;
        }
        QLog.i("QZIntimateFeedListHeaderView", 1, "showOpenCheckInRemindGuide");
        this.showType = 3;
        ImageView imageView = this.leftIcon;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        View view = this.functionBtn;
        if (view != null) {
            view.setVisibility(8);
        }
        setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.intimate.widget.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QZIntimateFeedListHeaderView.J0(view2);
            }
        });
        TextView textView = this.guideText;
        if (textView != null) {
            textView.setText(HardCodeUtil.qqStr(R.string.v8v));
        }
        S0(state);
        View view2 = this.closeBtn;
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.intimate.widget.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    QZIntimateFeedListHeaderView.K0(QZIntimateFeedListHeaderView.this, view3);
                }
            });
        }
        y0();
        F0();
        View view3 = this.bannerRoot;
        if (view3 == null) {
            return;
        }
        view3.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        SimpleEventBus.getInstance().dispatchEvent(new QZIntimateShowSettingDialogEvent());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K0(QZIntimateFeedListHeaderView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.B0(3);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void L0() {
        if (this.parentBlock.s0()) {
            QLog.i("QZIntimateFeedListHeaderView", 1, "showTransferDataGuide");
            this.showType = 0;
            ImageView imageView = this.leftIcon;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.qui_transfer);
            }
            ImageView imageView2 = this.leftIcon;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            TextView textView = this.guideText;
            if (textView != null) {
                textView.setText(HardCodeUtil.qqStr(R.string.w9y));
            }
            View view = this.functionBtn;
            if (view != null) {
                view.setVisibility(0);
            }
            TextView textView2 = this.functionText;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.intimate.widget.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    QZIntimateFeedListHeaderView.M0(QZIntimateFeedListHeaderView.this, view2);
                }
            });
            View view2 = this.closeBtn;
            if (view2 != null) {
                view2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.intimate.widget.g
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        QZIntimateFeedListHeaderView.N0(QZIntimateFeedListHeaderView.this, view3);
                    }
                });
            }
            View view3 = this.bannerRoot;
            if (view3 != null) {
                view3.setVisibility(0);
            }
            C0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(QZIntimateFeedListHeaderView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.E0();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(QZIntimateFeedListHeaderView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.B0(0);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void O0() {
        if (this.parentBlock.t0()) {
            QLog.i("QZIntimateFeedListHeaderView", 1, "showTransferDataUnderway");
            this.showType = 1;
            ImageView imageView = this.leftIcon;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            View view = this.functionBtn;
            if (view != null) {
                view.setVisibility(8);
            }
            TextView textView = this.functionText;
            if (textView != null) {
                textView.setVisibility(8);
            }
            TextView textView2 = this.guideText;
            if (textView2 != null) {
                textView2.setText(HardCodeUtil.qqStr(R.string.w9z));
            }
            setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.intimate.widget.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    QZIntimateFeedListHeaderView.P0(view2);
                }
            });
            View view2 = this.closeBtn;
            if (view2 != null) {
                view2.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.intimate.widget.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        QZIntimateFeedListHeaderView.Q0(QZIntimateFeedListHeaderView.this, view3);
                    }
                });
            }
            View view3 = this.bannerRoot;
            if (view3 != null) {
                view3.setVisibility(0);
            }
            C0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q0(QZIntimateFeedListHeaderView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.B0(1);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T0(QZIntimateFeedListHeaderView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.parentBlock.z0();
        SimpleEventBus.getInstance().dispatchEvent(new QZIntimateShowCheckInRemindDialogEvent());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        SimpleEventBus.getInstance().dispatchEvent(new QZIntimateShowSettingDialogEvent());
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void y0() {
        fo.c.o(this, "em_qz_couple_space_punch_remind_switch", null);
    }

    public final void A0() {
        int i3 = this.showType;
        if (i3 >= 0 && i3 < 2) {
            QLog.i("QZIntimateFeedListHeaderView", 1, "need to show high priority guide");
            return;
        }
        if (this.parentBlock.o0()) {
            G0();
        } else if (this.parentBlock.p0()) {
            I0(this.parentBlock.A0());
        } else {
            this.parentBlock.setBlockVisible(false);
        }
    }

    public final void V0(ij.c bean) {
        Intrinsics.checkNotNullParameter(bean, "bean");
        if (bean.b()) {
            QLog.i("QZIntimateFeedListHeaderView", 1, "try to showTransferDataGuide");
            L0();
        } else if (bean.a()) {
            QLog.i("QZIntimateFeedListHeaderView", 1, "try to showTransferDataUnderway");
            O0();
        } else {
            QLog.i("QZIntimateFeedListHeaderView", 1, "checkToShowGuide");
            A0();
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.clf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public void bindData(QZoneBaseAlbumMeta$AlbumInfo objData, int pos) {
        Intrinsics.checkNotNullParameter(objData, "objData");
    }

    private final void S0(boolean state) {
        if (state) {
            TextView textView = this.functionText;
            if (textView != null) {
                textView.setText(com.qzone.util.l.a(R.string.v8j));
            }
            TextView textView2 = this.functionText;
            if (textView2 != null) {
                textView2.setTextColor(getResources().getColor(R.color.qui_common_text_secondary));
            }
            TextView textView3 = this.functionText;
            if (textView3 != null) {
                textView3.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.intimate.widget.h
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        QZIntimateFeedListHeaderView.U0(view);
                    }
                });
            }
        } else {
            TextView textView4 = this.functionText;
            if (textView4 != null) {
                textView4.setText(com.qzone.util.l.a(R.string.w9d));
            }
            TextView textView5 = this.functionText;
            if (textView5 != null) {
                textView5.setTextColor(getResources().getColor(R.color.qui_common_text_link));
            }
            TextView textView6 = this.functionText;
            if (textView6 != null) {
                textView6.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.intimate.widget.i
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        QZIntimateFeedListHeaderView.T0(QZIntimateFeedListHeaderView.this, view);
                    }
                });
            }
        }
        TextView textView7 = this.functionText;
        if (textView7 == null) {
            return;
        }
        textView7.setVisibility(0);
    }

    private final void z0(int type) {
        if (type == -1) {
            View view = this.bannerRoot;
            if (view != null) {
                view.setVisibility(8);
            }
        } else if (type == 2) {
            G0();
        }
        this.parentBlock.F0();
        this.parentBlock.I0();
    }

    private final void B0(int lastShowType) {
        if (lastShowType == 0) {
            this.parentBlock.D0();
            A0();
            return;
        }
        if (lastShowType == 1) {
            this.parentBlock.E0();
            A0();
            return;
        }
        if (lastShowType != 2) {
            if (lastShowType != 3) {
                return;
            }
            this.parentBlock.C0();
            this.parentBlock.setBlockVisible(false);
            return;
        }
        this.parentBlock.B0();
        if (this.parentBlock.p0()) {
            I0(this.parentBlock.A0());
        } else {
            this.parentBlock.setBlockVisible(false);
        }
    }
}
