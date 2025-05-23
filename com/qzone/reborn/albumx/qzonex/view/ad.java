package com.qzone.reborn.albumx.qzonex.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.repair.bean.QZonePhotoRepairMainInitBean;
import com.qzone.util.ar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqnt.kernel.nativeinterface.ToolBox;
import com.tencent.qqnt.kernel.nativeinterface.ToolType;
import com.tencent.qzonehub.api.IQZoneMMKVApi;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 62\u00020\u00012\u00020\u0002:\u00017B+\u0012\u0006\u00103\u001a\u000202\u0012\u001a\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\u001c\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J \u0010\u0011\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\nH\u0002J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0006H\u0002J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u0003H\u0002J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0014J\u0012\u0010\u0019\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006H\u0016R(\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0016\u0010-\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010(R\u0016\u0010/\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010%R\u0016\u00101\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u0010%\u00a8\u00068"}, d2 = {"Lcom/qzone/reborn/albumx/qzonex/view/ad;", "Landroid/app/Dialog;", "Landroid/view/View$OnClickListener;", "", ExifInterface.LATITUDE_SOUTH, "b0", "Landroid/view/View;", "containerView", "Z", "a0", "", "d0", "e0", "view", "", "title", "isShowRedPoint", "U", "Y", "W", "X", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "v", NodeProps.ON_CLICK, "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/ToolBox;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "toolBoxs", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "D", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "halfScreenFloatingView", "E", "Landroid/view/View;", "Landroid/widget/LinearLayout;", UserInfo.SEX_FEMALE, "Landroid/widget/LinearLayout;", "albumRecycleView", "G", "photoRepairView", "H", "aiEliminateView", "I", "repairRedPoint", "J", "eliminateRedPoint", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Ljava/util/ArrayList;)V", "K", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ad extends ReportDialog implements View.OnClickListener {
    private static final int L = ar.e(225.0f);

    /* renamed from: C, reason: from kotlin metadata */
    private final ArrayList<ToolBox> toolBoxs;

    /* renamed from: D, reason: from kotlin metadata */
    private QUSHalfScreenFloatingView halfScreenFloatingView;

    /* renamed from: E, reason: from kotlin metadata */
    private View containerView;

    /* renamed from: F, reason: from kotlin metadata */
    private LinearLayout albumRecycleView;

    /* renamed from: G, reason: from kotlin metadata */
    private LinearLayout photoRepairView;

    /* renamed from: H, reason: from kotlin metadata */
    private LinearLayout aiEliminateView;

    /* renamed from: I, reason: from kotlin metadata */
    private View repairRedPoint;

    /* renamed from: J, reason: from kotlin metadata */
    private View eliminateRedPoint;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/qzone/reborn/albumx/qzonex/view/ad$b", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", NodeProps.MAX_HEIGHT, "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends com.tencent.mobileqq.widget.qus.e {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        /* renamed from: createContentView */
        public View getF57179d() {
            ad adVar = ad.this;
            View inflate = LayoutInflater.from(adVar.getContext()).inflate(R.layout.f129395y, (ViewGroup) null);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.\u2026x_container_layout, null)");
            adVar.containerView = inflate;
            ad adVar2 = ad.this;
            View view = adVar2.containerView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("containerView");
                view = null;
            }
            adVar2.Z(view);
            View view2 = ad.this.containerView;
            if (view2 != null) {
                return view2;
            }
            Intrinsics.throwUninitializedPropertyAccessException("containerView");
            return null;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            return ad.L;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(Context context, ArrayList<ToolBox> arrayList) {
        super(context, R.style.f173448dl);
        Intrinsics.checkNotNullParameter(context, "context");
        this.toolBoxs = arrayList;
    }

    private final void S() {
        Window window = getWindow();
        if (window == null) {
            return;
        }
        window.requestFeature(1);
        window.setSoftInputMode(19);
        try {
            ImmersiveUtils.clearCoverForStatus(window, true);
        } catch (Exception e16) {
            QLog.e("QZAlbumxToolBoxDialog", 1, "clearCoverForStatus fail:" + e16.getMessage());
        }
    }

    private final void U(View view, String title, boolean isShowRedPoint) {
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("tool_name", title);
        if (isShowRedPoint) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("is_red_tips", str);
        fo.c.o(view, "em_qz_tool_box_float_icon", new fo.b().l(hashMap));
    }

    private final void W(View view) {
        ((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).saveBoolean("QZONE_ALBUM_PHOTO_AI_ELIMINATE_ENTRANCE_IS_CLICKED", true);
        d0();
        yo.d.b(view.getContext(), new yo.g("mqzone://arouse/openqqpublish/mood?target=23&source=1"));
    }

    private final void Y(View view) {
        ho.i.v().b(view.getContext(), new QZonePhotoRepairMainInitBean(1));
        com.qzone.reborn.repair.utils.a.f59293a.f();
        e0();
    }

    private final void a0() {
        boolean e06 = e0();
        LinearLayout linearLayout = this.photoRepairView;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoRepairView");
            linearLayout = null;
        }
        String a16 = com.qzone.util.l.a(R.string.jja);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qzone_alb\u2026_album_photo_repair_text)");
        U(linearLayout, a16, e06);
        if (e06) {
            LinearLayout linearLayout3 = this.photoRepairView;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("photoRepairView");
                linearLayout3 = null;
            }
            linearLayout3.setContentDescription(com.qzone.util.l.a(R.string.jja) + "\uff0c\u6709\u65b0\u5185\u5bb9");
        }
        LinearLayout linearLayout4 = this.aiEliminateView;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aiEliminateView");
            linearLayout4 = null;
        }
        linearLayout4.setVisibility(0);
        boolean d06 = d0();
        LinearLayout linearLayout5 = this.aiEliminateView;
        if (linearLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aiEliminateView");
            linearLayout5 = null;
        }
        String a17 = com.qzone.util.l.a(R.string.jj_);
        Intrinsics.checkNotNullExpressionValue(a17, "qqStr(R.string.qzone_alb\u2026box_album_eliminate_text)");
        U(linearLayout5, a17, d06);
        if (d06) {
            LinearLayout linearLayout6 = this.aiEliminateView;
            if (linearLayout6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("aiEliminateView");
            } else {
                linearLayout2 = linearLayout6;
            }
            linearLayout2.setContentDescription(com.qzone.util.l.a(R.string.jj_) + "\uff0c\u6709\u65b0\u5185\u5bb9");
        }
    }

    private final void b0() {
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.halfScreenFloatingView;
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = null;
        if (qUSHalfScreenFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("halfScreenFloatingView");
            qUSHalfScreenFloatingView = null;
        }
        qUSHalfScreenFloatingView.setDraggable(true);
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView3 = this.halfScreenFloatingView;
        if (qUSHalfScreenFloatingView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("halfScreenFloatingView");
            qUSHalfScreenFloatingView3 = null;
        }
        qUSHalfScreenFloatingView3.setOutSideTouchEnable(true);
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView4 = this.halfScreenFloatingView;
        if (qUSHalfScreenFloatingView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("halfScreenFloatingView");
            qUSHalfScreenFloatingView4 = null;
        }
        qUSHalfScreenFloatingView4.setContentViewBackgroundResource(R.color.qui_common_bg_middle_standard);
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView5 = this.halfScreenFloatingView;
        if (qUSHalfScreenFloatingView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("halfScreenFloatingView");
            qUSHalfScreenFloatingView5 = null;
        }
        qUSHalfScreenFloatingView5.setQUSDragFloatController(new b());
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView6 = this.halfScreenFloatingView;
        if (qUSHalfScreenFloatingView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("halfScreenFloatingView");
        } else {
            qUSHalfScreenFloatingView2 = qUSHalfScreenFloatingView6;
        }
        qUSHalfScreenFloatingView2.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.qzone.reborn.albumx.qzonex.view.ac
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                ad.c0(ad.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(ad this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
    }

    private final boolean d0() {
        View view = null;
        if (!((IQZoneMMKVApi) QRoute.api(IQZoneMMKVApi.class)).getBooleanValue("QZONE_ALBUM_PHOTO_AI_ELIMINATE_ENTRANCE_IS_CLICKED", false)) {
            View view2 = this.eliminateRedPoint;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("eliminateRedPoint");
            } else {
                view = view2;
            }
            view.setVisibility(0);
            return true;
        }
        View view3 = this.eliminateRedPoint;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("eliminateRedPoint");
        } else {
            view = view3;
        }
        view.setVisibility(8);
        return false;
    }

    private final boolean e0() {
        View view = null;
        if (com.qzone.reborn.repair.utils.a.f59293a.b()) {
            View view2 = this.repairRedPoint;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("repairRedPoint");
            } else {
                view = view2;
            }
            view.setVisibility(0);
            return true;
        }
        View view3 = this.repairRedPoint;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("repairRedPoint");
        } else {
            view = view3;
        }
        view.setVisibility(8);
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = null;
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.mdd) {
            X();
        } else if (valueOf != null && valueOf.intValue() == R.id.mgd) {
            Y(v3);
        } else if (valueOf != null && valueOf.intValue() == R.id.mg5) {
            W(v3);
        }
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = this.halfScreenFloatingView;
        if (qUSHalfScreenFloatingView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("halfScreenFloatingView");
        } else {
            qUSHalfScreenFloatingView = qUSHalfScreenFloatingView2;
        }
        qUSHalfScreenFloatingView.t();
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        S();
        setContentView(R.layout.f129405z);
        View findViewById = findViewById(R.id.miy);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.qus_floating_half_screen)");
        this.halfScreenFloatingView = (QUSHalfScreenFloatingView) findViewById;
        setCancelable(true);
        b0();
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.halfScreenFloatingView;
        if (qUSHalfScreenFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("halfScreenFloatingView");
            qUSHalfScreenFloatingView = null;
        }
        VideoReport.setPageId(qUSHalfScreenFloatingView, "pg_qz_tool_box_float_new");
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = this.halfScreenFloatingView;
        if (qUSHalfScreenFloatingView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("halfScreenFloatingView");
            qUSHalfScreenFloatingView2 = null;
        }
        VideoReport.setPageParams(qUSHalfScreenFloatingView2, new fo.a().d("QZAlbumxToolBoxDialog", null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z(View containerView) {
        View findViewById = containerView.findViewById(R.id.mdd);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026.ll_album_recycle_layout)");
        this.albumRecycleView = (LinearLayout) findViewById;
        View findViewById2 = containerView.findViewById(R.id.mgd);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026d.ll_photo_repair_layout)");
        this.photoRepairView = (LinearLayout) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.mg5);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026R.id.ll_eliminate_layout)");
        this.aiEliminateView = (LinearLayout) findViewById3;
        View findViewById4 = containerView.findViewById(R.id.lqh);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy\u2026R.id.iv_repair_red_point)");
        this.repairRedPoint = findViewById4;
        View findViewById5 = containerView.findViewById(R.id.l2_);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "containerView.findViewBy\u2026.id.iv_elimate_red_point)");
        this.eliminateRedPoint = findViewById5;
        LinearLayout linearLayout = this.albumRecycleView;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumRecycleView");
            linearLayout = null;
        }
        linearLayout.setOnClickListener(this);
        LinearLayout linearLayout3 = this.photoRepairView;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("photoRepairView");
            linearLayout3 = null;
        }
        linearLayout3.setOnClickListener(this);
        LinearLayout linearLayout4 = this.aiEliminateView;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aiEliminateView");
            linearLayout4 = null;
        }
        linearLayout4.setOnClickListener(this);
        LinearLayout linearLayout5 = this.albumRecycleView;
        if (linearLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("albumRecycleView");
        } else {
            linearLayout2 = linearLayout5;
        }
        String a16 = com.qzone.util.l.a(R.string.jjb);
        Intrinsics.checkNotNullExpressionValue(a16, "qqStr(R.string.qzone_alb\u2026l_box_album_recycle_text)");
        U(linearLayout2, a16, false);
        a0();
    }

    private final void X() {
        LpReportInfo_pf00064.allReport(326, 1, 42);
        ArrayList<ToolBox> arrayList = this.toolBoxs;
        if (arrayList != null) {
            for (ToolBox toolBox : arrayList) {
                if (toolBox.toolType == ToolType.KTOOLTYPERECYCLEBIN.ordinal()) {
                    yo.d.b(getContext(), new yo.g(toolBox.jumpUrl));
                    QLog.i("QZAlbumxToolBoxDialog", 1, "handleOnClickAlbumRecycle  url=" + toolBox.jumpUrl);
                }
            }
        }
    }
}
