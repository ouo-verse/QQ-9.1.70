package com.tencent.mobileqq.zplan.aigc.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import ba4.ColorData;
import ba4.b;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.sqshow.zootopia.nativeui.data.j;
import com.tencent.sqshow.zootopia.nativeui.view.color.ColorPickerPanelView;
import com.tencent.sqshow.zootopia.nativeui.view.color.picker.RectColorPickerView;
import k94.ColorPanelData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qu4.d;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001bB5\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0014J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0016R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/view/UGCColorPickerPanelView;", "Lcom/tencent/sqshow/zootopia/nativeui/view/color/ColorPickerPanelView;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lqu4/d;", "colorSlotInfo", ReportConstant.COSTREPORT_PREFIX, "Lba4/c;", "colorData", "", "position", "k", "slotColorInfo", "l", "Lcom/tencent/mobileqq/zplan/aigc/view/UGCColorPickerPanelView$a;", "J", "Lcom/tencent/mobileqq/zplan/aigc/view/UGCColorPickerPanelView$a;", "callBack", "Landroid/content/Context;", "context", "colorIndex", "Lk94/b;", "mColorPanelData", "Lcom/tencent/sqshow/zootopia/nativeui/data/j;", WadlProxyConsts.CHANNEL, "<init>", "(Landroid/content/Context;ILk94/b;Lcom/tencent/sqshow/zootopia/nativeui/data/j;Lcom/tencent/mobileqq/zplan/aigc/view/UGCColorPickerPanelView$a;)V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class UGCColorPickerPanelView extends ColorPickerPanelView {

    /* renamed from: J, reason: from kotlin metadata */
    private final a callBack;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/view/UGCColorPickerPanelView$a;", "", "", "position", "", "onItemClick", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface a {
        void onItemClick(int position);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UGCColorPickerPanelView(Context context, int i3, ColorPanelData mColorPanelData, j channel, a aVar) {
        super(context, i3, mColorPanelData, channel);
        Intrinsics.checkNotNullParameter(mColorPanelData, "mColorPanelData");
        Intrinsics.checkNotNullParameter(channel, "channel");
        this.callBack = aVar;
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.color.ColorPickerPanelView
    protected void k(ColorData colorData, int position) {
        Intrinsics.checkNotNullParameter(colorData, "colorData");
        a aVar = this.callBack;
        if (aVar != null) {
            aVar.onItemClick(position);
        }
        super.k(colorData, position);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.color.ColorPickerPanelView
    public void l(d slotColorInfo) {
        b colorPickerAdapter = getColorPickerAdapter();
        if (colorPickerAdapter != null) {
            for (ColorData colorData : colorPickerAdapter.getData()) {
                if (colorData.getIsSelected()) {
                    colorPickerAdapter.q0(new ColorData(true, colorData.getColorIndex(), slotColorInfo != null ? slotColorInfo.f429585c : null, colorData.getGradientColor()));
                    return;
                }
            }
        }
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.color.ColorPickerPanelView
    public void m() {
        super.m();
        View colorPickerLine = getColorPickerLine();
        if (colorPickerLine == null) {
            return;
        }
        colorPickerLine.setVisibility(0);
    }

    @Override // com.tencent.sqshow.zootopia.nativeui.view.color.ColorPickerPanelView
    public void s(d colorSlotInfo) {
        super.s(colorSlotInfo);
        RectColorPickerView rectPickerView = getRectPickerView();
        ViewGroup.LayoutParams layoutParams = rectPickerView != null ? rectPickerView.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.height = ViewUtils.dip2px(232);
        }
        RectColorPickerView rectPickerView2 = getRectPickerView();
        if (rectPickerView2 == null) {
            return;
        }
        rectPickerView2.setLayoutParams(layoutParams);
    }
}
