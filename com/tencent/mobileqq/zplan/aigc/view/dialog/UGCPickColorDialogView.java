package com.tencent.mobileqq.zplan.aigc.view.dialog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.zplan.aigc.view.UGCColorPickerPanelView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.view.dialog.views.BaseSubPanelDialogView;
import fi3.cd;
import java.util.LinkedHashMap;
import k94.ColorPanelData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import qu4.p;
import uv4.as;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 B2\u00020\u0001:\u0002CDBQ\b\u0007\u0012\u0006\u0010<\u001a\u00020;\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010=\u0012\b\b\u0002\u0010?\u001a\u00020\r\u0012\u0006\u0010 \u001a\u00020\u0019\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010'\u001a\u00020%\u0012\u0010\b\u0002\u0010+\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u000f\u00a2\u0006\u0004\b@\u0010AJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J\b\u0010\n\u001a\u00020\tH\u0014J\n\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fJ\u0006\u0010\u0013\u001a\u00020\u0002J\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\tR\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010&R\u001c\u0010+\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u001e\u00104\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010*R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00100\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/view/dialog/UGCPickColorDialogView;", "Lcom/tencent/sqshow/zootopia/nativeui/view/dialog/views/BaseSubPanelDialogView;", "", "U", "Lfi3/cd;", "binding", "V", "Landroid/view/View;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", UserInfo.SEX_FEMALE, "", "w", "", "P", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/zplan/aigc/view/dialog/UGCPickColorDialogView$b;", "listener", "setUgcPickColorListener", "Y", "Luv4/as;", "targetColorCfg", "X", "isEnabled", "T", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "D", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "getChannel", "()Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "setChannel", "(Lcom/tencent/sqshow/zootopia/nativeui/data/j;)V", WadlProxyConsts.CHANNEL, "Lk94/b;", "E", "Lk94/b;", "mColorPanelData", "Lzd3/a;", "Lzd3/a;", "dtReporter", "Lcom/tencent/mobileqq/zplan/aigc/view/UGCColorPickerPanelView$a;", "G", "Lmqq/util/WeakReference;", "callBack", "Lqu4/d;", "H", "Lqu4/d;", "mColorSlotInfo", "I", "Lfi3/cd;", "mBinding", "J", "mListener", "Lcom/tencent/mobileqq/zplan/aigc/view/UGCColorPickerPanelView;", "K", "Lcom/tencent/mobileqq/zplan/aigc/view/UGCColorPickerPanelView;", "panelView", "L", "currentColorPosition", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/tencent/sqshow/zootopia/nativeui/data/j;Lk94/b;Lzd3/a;Lmqq/util/WeakReference;)V", "M", "a", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class UGCPickColorDialogView extends BaseSubPanelDialogView {

    /* renamed from: D, reason: from kotlin metadata */
    private com.tencent.sqshow.zootopia.nativeui.data.j channel;

    /* renamed from: E, reason: from kotlin metadata */
    private ColorPanelData mColorPanelData;

    /* renamed from: F, reason: from kotlin metadata */
    private zd3.a dtReporter;

    /* renamed from: G, reason: from kotlin metadata */
    private final WeakReference<UGCColorPickerPanelView.a> callBack;

    /* renamed from: H, reason: from kotlin metadata */
    private qu4.d mColorSlotInfo;

    /* renamed from: I, reason: from kotlin metadata */
    private cd mBinding;

    /* renamed from: J, reason: from kotlin metadata */
    private WeakReference<b> mListener;

    /* renamed from: K, reason: from kotlin metadata */
    private UGCColorPickerPanelView panelView;

    /* renamed from: L, reason: from kotlin metadata */
    private int currentColorPosition;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/view/dialog/UGCPickColorDialogView$b;", "", "", "b", "", "position", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface b {
        void a(int position);

        void b();
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/aigc/view/dialog/UGCPickColorDialogView$c", "Lcom/tencent/mobileqq/zplan/aigc/view/UGCColorPickerPanelView$a;", "", "position", "", "onItemClick", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements UGCColorPickerPanelView.a {
        c() {
        }

        @Override // com.tencent.mobileqq.zplan.aigc.view.UGCColorPickerPanelView.a
        public void onItemClick(int position) {
            b bVar;
            UGCPickColorDialogView.this.currentColorPosition = position;
            WeakReference weakReference = UGCPickColorDialogView.this.mListener;
            if (weakReference == null || (bVar = (b) weakReference.get()) == null) {
                return;
            }
            bVar.a(position);
        }
    }

    public /* synthetic */ UGCPickColorDialogView(Context context, AttributeSet attributeSet, int i3, com.tencent.sqshow.zootopia.nativeui.data.j jVar, ColorPanelData colorPanelData, zd3.a aVar, WeakReference weakReference, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3, jVar, colorPanelData, aVar, (i16 & 64) != 0 ? null : weakReference);
    }

    private final void U() {
        this.channel.getAvatarColorController().a(this.mColorPanelData.getColorInfo());
        this.mColorSlotInfo = da4.b.f393480a.e(this.mColorPanelData.getColorInfo(), this.mColorPanelData.getSlotId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(UGCPickColorDialogView this$0, cd binding, View view) {
        b bVar;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(binding, "$binding");
        if (!com.tencent.biz.common.util.g.b(BaseApplication.getContext())) {
            QQToast.makeText(BaseApplication.getContext(), 1, "\u7f51\u7edc\u8fde\u63a5\u5931\u8d25", 0).show();
            return;
        }
        cd cdVar = this$0.mBinding;
        cd cdVar2 = null;
        if (cdVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            cdVar = null;
        }
        cdVar.f399242e.setEnabled(false);
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) view).setText("");
        binding.f399243f.setVisibility(0);
        binding.f399243f.setForeground(com.tencent.mobileqq.guild.util.qqui.d.d(this$0.getContext(), 1));
        cd cdVar3 = this$0.mBinding;
        if (cdVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            cdVar2 = cdVar3;
        }
        cdVar2.f399244g.setVisibility(0);
        WeakReference<b> weakReference = this$0.mListener;
        if (weakReference != null && (bVar = weakReference.get()) != null) {
            bVar.b();
        }
        zd3.a.v(this$0.dtReporter, view, "em_zplan_confirm", null, 4, null);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView
    protected boolean F() {
        return false;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.views.BaseSubPanelDialogView
    public int P() {
        return 2;
    }

    public final void T(boolean isEnabled) {
        Drawable drawable;
        cd cdVar = this.mBinding;
        cd cdVar2 = null;
        if (cdVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            cdVar = null;
        }
        if (cdVar.f399242e.isEnabled() == isEnabled) {
            return;
        }
        cd cdVar3 = this.mBinding;
        if (cdVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            cdVar3 = null;
        }
        cdVar3.f399242e.setEnabled(isEnabled);
        if (isEnabled) {
            drawable = ContextCompat.getDrawable(getContext(), R.drawable.i5j);
        } else {
            drawable = ContextCompat.getDrawable(getContext(), R.drawable.i5k);
        }
        cd cdVar4 = this.mBinding;
        if (cdVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            cdVar2 = cdVar4;
        }
        cdVar2.f399242e.setBackground(drawable);
    }

    public final void X(as targetColorCfg) {
        Intrinsics.checkNotNullParameter(targetColorCfg, "targetColorCfg");
        p[] pVarArr = this.mColorPanelData.getColorConfig().f440220c;
        Intrinsics.checkNotNullExpressionValue(pVarArr, "mColorPanelData.colorConfig.singleColors");
        String str = "updateClusterColor targetColorCfg ";
        for (p pVar : pVarArr) {
            int i3 = pVar.f429637b;
            StringBuilder sb5 = new StringBuilder();
            sb5.append((Object) str);
            sb5.append(i3);
            str = sb5.toString();
        }
        QLog.i("UGCPickColorDialogView", 1, String.valueOf(str));
        ColorPanelData b16 = ColorPanelData.b(this.mColorPanelData, 0, null, targetColorCfg, 0, 11, null);
        this.mColorPanelData = b16;
        qu4.d dVar = this.mColorSlotInfo;
        if (dVar != null) {
            dVar.f429585c = b16.getColorConfig().f440220c[this.currentColorPosition];
        }
        UGCColorPickerPanelView uGCColorPickerPanelView = this.panelView;
        if (uGCColorPickerPanelView != null) {
            uGCColorPickerPanelView.w(this.mColorSlotInfo, this.mColorPanelData, true);
        }
    }

    public final void Y() {
        cd cdVar = this.mBinding;
        cd cdVar2 = null;
        if (cdVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            cdVar = null;
        }
        cdVar.f399242e.setEnabled(true);
        cd cdVar3 = this.mBinding;
        if (cdVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            cdVar3 = null;
        }
        cdVar3.f399242e.setText("\u4fdd\u5b58\u670d\u88c5");
        cd cdVar4 = this.mBinding;
        if (cdVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            cdVar4 = null;
        }
        cdVar4.f399243f.setVisibility(8);
        cd cdVar5 = this.mBinding;
        if (cdVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        } else {
            cdVar2 = cdVar5;
        }
        cdVar2.f399244g.setVisibility(8);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView
    protected View m() {
        cd g16 = cd.g(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context))");
        this.mBinding = g16;
        U();
        V(g16);
        LinearLayout root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public final void setChannel(com.tencent.sqshow.zootopia.nativeui.data.j jVar) {
        Intrinsics.checkNotNullParameter(jVar, "<set-?>");
        this.channel = jVar;
    }

    public final void setUgcPickColorListener(WeakReference<b> listener) {
        this.mListener = listener;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.dialog.BasePanelDialogView
    public Object w() {
        cd cdVar = this.mBinding;
        if (cdVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            cdVar = null;
        }
        return cdVar.getRoot();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UGCPickColorDialogView(Context context, AttributeSet attributeSet, int i3, com.tencent.sqshow.zootopia.nativeui.data.j channel, ColorPanelData mColorPanelData, zd3.a dtReporter, WeakReference<UGCColorPickerPanelView.a> weakReference) {
        super(context, attributeSet, i3, channel);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(channel, "channel");
        Intrinsics.checkNotNullParameter(mColorPanelData, "mColorPanelData");
        Intrinsics.checkNotNullParameter(dtReporter, "dtReporter");
        this.channel = channel;
        this.mColorPanelData = mColorPanelData;
        this.dtReporter = dtReporter;
        this.callBack = weakReference;
    }

    private final void V(final cd binding) {
        QLog.i("UGCPickColorDialogView", 4, "initPanel");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        UGCColorPickerPanelView uGCColorPickerPanelView = new UGCColorPickerPanelView(getContext(), 0, this.mColorPanelData, this.channel, new c());
        this.panelView = uGCColorPickerPanelView;
        binding.f399240c.addView(uGCColorPickerPanelView, layoutParams);
        binding.f399242e.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.aigc.view.dialog.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UGCPickColorDialogView.W(UGCPickColorDialogView.this, binding, view);
            }
        });
        zd3.a aVar = this.dtReporter;
        TextView textView = binding.f399242e;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.ugcPickColorSaveBtn");
        zd3.a.y(aVar, textView, "em_zplan_confirm", null, null, 12, null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("color_block_id", "0");
        zd3.a aVar2 = this.dtReporter;
        FrameLayout frameLayout = binding.f399240c;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.panelContainer");
        zd3.a.y(aVar2, frameLayout, "em_zplan_dyeing_operation_panel", linkedHashMap, null, 8, null);
        cd cdVar = this.mBinding;
        if (cdVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
            cdVar = null;
        }
        cdVar.f399242e.setEnabled(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setUgcPickColorListener$default(UGCPickColorDialogView uGCPickColorDialogView, WeakReference weakReference, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            weakReference = null;
        }
        uGCPickColorDialogView.setUgcPickColorListener(weakReference);
    }
}
