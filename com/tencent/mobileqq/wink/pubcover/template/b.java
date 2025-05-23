package com.tencent.mobileqq.wink.pubcover.template;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.view.ab;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.videocut.utils.o;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B-\b\u0016\u0012\u0006\u0010!\u001a\u00020\u0012\u0012\b\u0010#\u001a\u0004\u0018\u00010\"\u0012\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001d\u00a2\u0006\u0004\b$\u0010%J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\bH\u0014J\"\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0014R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0017R\u001e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/wink/pubcover/template/b;", "Lcom/tencent/mobileqq/wink/view/ab;", "Landroid/view/View;", "v", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", "r0", "", "position", UserInfo.SEX_FEMALE, "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "Lcom/tencent/mobileqq/wink/view/ab$a;", "o0", "vh", "n0", "Landroid/content/Context;", "T", "Landroid/content/Context;", "mContext", "U", "I", "screenWidth", "V", "itemWidth", "W", "space", "Lkotlin/Function0;", "X", "Lkotlin/jvm/functions/Function0;", "handleItemClick", "context", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "editMode", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;Lkotlin/jvm/functions/Function0;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b extends ab {

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final Context mContext;

    /* renamed from: U, reason: from kotlin metadata */
    private final int screenWidth;

    /* renamed from: V, reason: from kotlin metadata */
    private final int itemWidth;

    /* renamed from: W, reason: from kotlin metadata */
    private final int space;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private Function0<Unit> handleItemClick;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull Context context, @Nullable WinkEditorViewModel.EditMode editMode, @Nullable Function0<Unit> function0) {
        super(context, editMode, 2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mContext = context;
        int g16 = o.g();
        this.screenWidth = g16;
        int a16 = com.tencent.videocut.utils.e.f384236a.a(18.0f);
        this.space = a16;
        this.handleItemClick = function0;
        this.itemWidth = (g16 - (a16 * 5)) / 4;
    }

    private final void r0(View v3, MetaMaterial material) {
        VideoReport.setElementId(v3, WinkDaTongReportConstant.ElementId.EM_XSJ_LYRICS_ITEM);
        VideoReport.setElementReuseIdentifier(v3, String.valueOf(material.hashCode()));
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.put(WinkDaTongReportConstant.ElementParamValue.XSJ_COVER_TEMPLATE_ID, material.f30533id);
        VideoReport.setElementParams(v3, buildElementParams);
        VideoReport.setElementEndExposePolicy(v3, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(v3, ClickPolicy.REPORT_ALL);
        VideoReport.setElementId(v3, "em_xsj_cover_template");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.view.AbsWinkMaterialPanelContentAdapter
    public void F(int position, @Nullable MetaMaterial material) {
        if (D() == position) {
            Function0<Unit> function0 = this.handleItemClick;
            if (function0 != null) {
                function0.invoke();
                return;
            }
            return;
        }
        super.F(position, material);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.view.ab
    public void n0(@Nullable ab.a vh5, int position, @NotNull MetaMaterial material) {
        Intrinsics.checkNotNullParameter(material, "material");
        super.n0(vh5, position, material);
        if (vh5 == null) {
            return;
        }
        r0(vh5.itemView, material);
        if (QQTheme.isNowThemeIsNight()) {
            vh5.f326924f.setImageResource(R.drawable.qvideo_skin_qqwink_material_cover_selected_bg_item_dark);
        } else {
            vh5.f326924f.setImageResource(R.drawable.qvideo_skin_qqwink_material_cover_selected_bg_item);
        }
    }

    @Override // com.tencent.mobileqq.wink.view.ab
    @NotNull
    protected ab.a o0(@Nullable ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.hfo, parent, false);
        inflate.getLayoutParams().height = (((this.screenWidth - (this.space * 5)) / 4) * 93) / 70;
        return new ab.a(inflate);
    }
}
