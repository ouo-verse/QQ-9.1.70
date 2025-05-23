package com.tencent.mobileqq.zplan.aigc.view.dialog;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.view.dialog.views.BaseSubPanelDialogView;
import com.tencent.sqshow.zootopia.utils.aa;
import fi3.aw;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001.B7\u0012\u0006\u0010'\u001a\u00020&\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010*\u001a\u00020\f\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u000e\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tJ\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\b\u0010\u0011\u001a\u00020\u0010H\u0014J\b\u0010\u0012\u001a\u00020\u0002H\u0016R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/view/dialog/DyeingColorConfirmDialogView;", "Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/views/BaseSubPanelDialogView;", "", "V", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/ImageView;", "U", "Landroid/widget/Button;", "T", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "setHeadPicBitmap", "", "P", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "L", "o", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "D", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "getChannel", "()Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "Lzd3/a;", "E", "Lzd3/a;", "getDtReporter", "()Lzd3/a;", "dtReporter", "Lfi3/aw;", UserInfo.SEX_FEMALE, "Lfi3/aw;", "mBinding", "G", "Landroid/graphics/Bitmap;", "headPicBitmap", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/tencent/sqshow/zootopia/nativeui/data/j;Lzd3/a;)V", "H", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class DyeingColorConfirmDialogView extends BaseSubPanelDialogView {

    /* renamed from: D, reason: from kotlin metadata */
    private final com.tencent.sqshow.zootopia.nativeui.data.j channel;

    /* renamed from: E, reason: from kotlin metadata */
    private final zd3.a dtReporter;

    /* renamed from: F, reason: from kotlin metadata */
    private aw mBinding;

    /* renamed from: G, reason: from kotlin metadata */
    private Bitmap headPicBitmap;

    public /* synthetic */ DyeingColorConfirmDialogView(Context context, AttributeSet attributeSet, int i3, com.tencent.sqshow.zootopia.nativeui.data.j jVar, zd3.a aVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3, jVar, aVar);
    }

    private final void R() {
        aa.d(T(), new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aigc.view.dialog.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DyeingColorConfirmDialogView.S(DyeingColorConfirmDialogView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(DyeingColorConfirmDialogView this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("DyeingColorConfirmDialogView", 1, "custom color confirm dialog is confirmed");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("dt_pgid", "pg_zplan_clothing_dyeing");
        zd3.a aVar = this$0.dtReporter;
        if (aVar != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            aVar.t(it, "em_zplan_alert_pop_confirm_btn", linkedHashMap);
        }
        this$0.o();
    }

    private final Button T() {
        aw awVar = this.mBinding;
        if (awVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            awVar = null;
        }
        Button button = awVar.f398961b;
        Intrinsics.checkNotNullExpressionValue(button, "mBinding.btnConfirm");
        return button;
    }

    private final ImageView U() {
        aw awVar = this.mBinding;
        if (awVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            awVar = null;
        }
        ImageView imageView = awVar.f398965f;
        Intrinsics.checkNotNullExpressionValue(imageView, "mBinding.followIgv");
        return imageView;
    }

    private final void V() {
        if (this.headPicBitmap != null) {
            U().setImageBitmap(this.headPicBitmap);
        }
        R();
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView
    protected boolean L() {
        return true;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.BaseSubPanelDialogView
    public int P() {
        return 2;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView
    protected View m() {
        aw g16 = aw.g(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
        this.mBinding = g16;
        V();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("dt_pgid", "pg_zplan_clothing_dyeing");
        zd3.a aVar = this.dtReporter;
        if (aVar != null) {
            zd3.a.y(aVar, T(), "em_zplan_alert_pop_confirm_btn", linkedHashMap, null, 8, null);
        }
        ConstraintLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView
    public void o() {
        super.o();
        QLog.i("DyeingColorConfirmDialogView", 1, "custom color confirm tip is saved");
        String currentUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        com.tencent.mobileqq.zplan.aigc.helper.h.f330325a.o("custom_color_confirm_" + currentUin, true);
    }

    public final void setHeadPicBitmap(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        this.headPicBitmap = bitmap;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DyeingColorConfirmDialogView(Context context, AttributeSet attributeSet, int i3, com.tencent.sqshow.zootopia.nativeui.data.j channel, zd3.a aVar) {
        super(context, attributeSet, i3, channel);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.channel = channel;
        this.dtReporter = aVar;
    }
}
