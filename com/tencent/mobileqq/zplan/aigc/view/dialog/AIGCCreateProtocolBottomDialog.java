package com.tencent.mobileqq.zplan.aigc.view.dialog;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.theme.ThemeConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.utils.aa;
import fi3.ak;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import lj3.AIGCCreationProtocolPopUpWindowModel;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 -2\u00020\u0001:\u0002;<B\u000f\u0012\u0006\u0010'\u001a\u00020$\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u000e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014J&\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u000e\u0010!\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u001fJ\b\u0010\"\u001a\u00020\u0002H\u0016J\b\u0010#\u001a\u00020\u0002H\u0016R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00101\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00104\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/view/dialog/AIGCCreateProtocolBottomDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "", "Ch", "sh", "", "", "", "wh", "xh", "Landroid/widget/Button;", "yh", "Bh", "Landroid/widget/LinearLayout;", "Ah", "Landroid/widget/ImageView;", OcrConfig.CHINESE, "", "from", "Eh", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Fh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "Lcom/tencent/mobileqq/zplan/aigc/view/dialog/AIGCCreateProtocolBottomDialog$b;", "listener", "Dh", "dismiss", "onResume", "Llj3/a;", BdhLogUtil.LogTag.Tag_Conn, "Llj3/a;", "model", "Lfi3/ak;", "D", "Lfi3/ak;", "contractBinding", "E", "I", ThemeConstants.THEME_DIY_BG_FROM_SUFFIX, UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/zplan/aigc/view/dialog/AIGCCreateProtocolBottomDialog$b;", "agreeListener", "G", "Landroid/graphics/Bitmap;", "headPicBitmap", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "H", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "reporter", "<init>", "(Llj3/a;)V", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class AIGCCreateProtocolBottomDialog extends BottomSheetDialogFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private final AIGCCreationProtocolPopUpWindowModel model;

    /* renamed from: D, reason: from kotlin metadata */
    private ak contractBinding;

    /* renamed from: E, reason: from kotlin metadata */
    private int _from;

    /* renamed from: F, reason: from kotlin metadata */
    private b agreeListener;

    /* renamed from: G, reason: from kotlin metadata */
    private Bitmap headPicBitmap;

    /* renamed from: H, reason: from kotlin metadata */
    private final ZplanViewReportHelper reporter;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/view/dialog/AIGCCreateProtocolBottomDialog$b;", "", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface b {
        void a();
    }

    public AIGCCreateProtocolBottomDialog(AIGCCreationProtocolPopUpWindowModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        this.model = model;
        this.reporter = new ZplanViewReportHelper();
    }

    private final LinearLayout Ah() {
        ak akVar = this.contractBinding;
        if (akVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contractBinding");
            akVar = null;
        }
        LinearLayout linearLayout = akVar.f398834h;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "contractBinding.lookContract");
        return linearLayout;
    }

    private final Button Bh() {
        ak akVar = this.contractBinding;
        if (akVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contractBinding");
            akVar = null;
        }
        Button button = akVar.f398829c;
        Intrinsics.checkNotNullExpressionValue(button, "contractBinding.btnContractRefuse");
        return button;
    }

    private final void Ch() {
        if (this.headPicBitmap != null) {
            zh().setImageBitmap(this.headPicBitmap);
        }
        sh();
    }

    private final void sh() {
        aa.d(yh(), new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aigc.view.dialog.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIGCCreateProtocolBottomDialog.th(AIGCCreateProtocolBottomDialog.this, view);
            }
        });
        aa.d(Bh(), new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aigc.view.dialog.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIGCCreateProtocolBottomDialog.uh(AIGCCreateProtocolBottomDialog.this, view);
            }
        });
        aa.d(Ah(), new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aigc.view.dialog.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AIGCCreateProtocolBottomDialog.vh(AIGCCreateProtocolBottomDialog.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void th(AIGCCreateProtocolBottomDialog this$0, View it) {
        Map mapOf;
        Map<String, ? extends Object> plus;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("AIGCCreateProtocolBottomDialog", 1, "agree button clicked");
        b bVar = this$0.agreeListener;
        if (bVar != null) {
            bVar.a();
        }
        ZplanViewReportHelper zplanViewReportHelper = this$0.reporter;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("zplan_is_selected_when_clck", 1));
        plus = MapsKt__MapsKt.plus(mapOf, this$0.wh());
        zplanViewReportHelper.e(it, "em_zplan_convention_toast", plus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uh(AIGCCreateProtocolBottomDialog this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismiss();
        QLog.i("AIGCCreateProtocolBottomDialog", 1, "refuse button clicked");
        ZplanViewReportHelper zplanViewReportHelper = this$0.reporter;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        zplanViewReportHelper.e(it, "em_zplan_convention_toast_close", this$0.wh());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vh(AIGCCreateProtocolBottomDialog this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZplanViewReportHelper zplanViewReportHelper = this$0.reporter;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        zplanViewReportHelper.e(it, "em_zplan_word_chain", this$0.wh());
        Intent intent = new Intent();
        intent.putExtra("url", this$0.model.getProtocolUrl());
        RouteUtils.startActivity(this$0.getContext(), intent, RouterConstants.UI_ROUTE_BROWSER);
    }

    private final void xh() {
        ak akVar = this.contractBinding;
        if (akVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contractBinding");
            akVar = null;
        }
        Object parent = akVar.getRoot().getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getBackground() != null) {
                view.setBackground(null);
            }
            parent = view.getParent();
        }
    }

    private final Button yh() {
        ak akVar = this.contractBinding;
        if (akVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contractBinding");
            akVar = null;
        }
        Button button = akVar.f398828b;
        Intrinsics.checkNotNullExpressionValue(button, "contractBinding.btnContractAgree");
        return button;
    }

    private final ImageView zh() {
        ak akVar = this.contractBinding;
        if (akVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contractBinding");
            akVar = null;
        }
        ImageView imageView = akVar.f398833g;
        Intrinsics.checkNotNullExpressionValue(imageView, "contractBinding.followIgv");
        return imageView;
    }

    public final void Dh(b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.agreeListener = listener;
    }

    public final void Eh(int from) {
        this._from = from;
    }

    public final void Fh(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.headPicBitmap = bitmap;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public void dismiss() {
        super.dismiss();
        View view = getView();
        if (view != null) {
            ZplanViewReportHelper.j(this.reporter, view, "em_zplan_teach_pop", wh(), false, null, 16, null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Map mapOf;
        Map plus;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        ak akVar = null;
        ak g16 = ak.g(inflater, null, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, null, false)");
        this.contractBinding = g16;
        Ch();
        ak akVar2 = this.contractBinding;
        if (akVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contractBinding");
        } else {
            akVar = akVar2;
        }
        ConstraintLayout root = akVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "contractBinding.root");
        ZplanViewReportHelper zplanViewReportHelper = this.reporter;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("zplan_is_selected_when_clck", 0));
        plus = MapsKt__MapsKt.plus(mapOf, wh());
        zplanViewReportHelper.g(root, "em_zplan_convention_toast", (r16 & 4) != 0 ? null : plus, (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        this.reporter.g(root, "em_zplan_convention_toast_close", (r16 & 4) != 0 ? null : wh(), (r16 & 8) != 0, (r16 & 16) != 0 ? null : null, (r16 & 32) != 0 ? false : false);
        return root;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        xh();
    }

    private final Map<String, Object> wh() {
        Map mapOf;
        Map<String, Object> mapOf2;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("zplan_create_home_source", Integer.valueOf(this._from)));
        mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to("dt_pgid", "pg_zplan_create_home"), TuplesKt.to("cur_pg", mapOf));
        return mapOf2;
    }
}
