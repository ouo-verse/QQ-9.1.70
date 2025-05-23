package com.tencent.mobileqq.wink.dailysign;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.util.Supplier;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.view.AbsWinkMaterialPanelContentAdapter;
import com.tencent.mobileqq.wink.view.ab;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001$B+\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u0012\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\u0006H\u0014R\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R$\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/wink/dailysign/au;", "Lcom/tencent/mobileqq/wink/view/ab;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "mate", "", "e0", "", "position", WadlProxyConsts.KEY_MATERIAL, UserInfo.SEX_FEMALE, "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "Lcom/tencent/mobileqq/wink/view/ab$a;", "o0", "Landroid/content/Context;", "T", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "Lkotlin/Function0;", "U", "Lkotlin/jvm/functions/Function0;", "handleItemClick", "V", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "r0", "()Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "setSelectedMetaMaterial", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)V", "selectedMetaMaterial", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "editMode", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;Lkotlin/jvm/functions/Function0;)V", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class au extends com.tencent.mobileqq.wink.view.ab {

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private Function0<Unit> handleItemClick;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private MetaMaterial selectedMetaMaterial;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014JN\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/wink/dailysign/au$a;", "Lcom/tencent/mobileqq/wink/view/ab$a;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", "position", "selectIndex", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "editMode", "", "resReady", "Landroidx/core/util/Supplier;", "clickable", "Lcom/tencent/mobileqq/wink/view/AbsWinkMaterialPanelContentAdapter$c;", "itemClickListener", "", "f", "Landroid/view/View;", "view", "<init>", "(Lcom/tencent/mobileqq/wink/dailysign/au;Landroid/view/View;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public final class a extends ab.a {
        final /* synthetic */ au H;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull au auVar, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.H = auVar;
        }

        @Override // com.tencent.mobileqq.wink.view.ab.a
        public void f(@Nullable MetaMaterial material, int position, int selectIndex, @Nullable WinkEditorViewModel.EditMode editMode, boolean resReady, @Nullable Supplier<Boolean> clickable, @Nullable AbsWinkMaterialPanelContentAdapter.c itemClickListener) {
            String str;
            int i3;
            super.f(material, position, selectIndex, editMode, resReady, clickable, itemClickListener);
            MetaMaterial selectedMetaMaterial = this.H.getSelectedMetaMaterial();
            String str2 = null;
            if (selectedMetaMaterial != null) {
                str = selectedMetaMaterial.f30533id;
            } else {
                str = null;
            }
            if (material != null) {
                str2 = material.f30533id;
            }
            boolean areEqual = Intrinsics.areEqual(str, str2);
            if (material != null) {
                this.f326922d = (CardView) this.itemView.findViewById(R.id.xib);
                this.f326924f.setVisibility(8);
                CardView cardView = this.f326922d;
                Resources resources = this.itemView.getContext().getResources();
                if (areEqual) {
                    i3 = R.color.cjp;
                } else {
                    i3 = R.color.f157020hq;
                }
                cardView.setCardBackgroundColor(resources.getColor(i3));
                TextView textView = this.C;
                if (textView != null) {
                    textView.setText(com.tencent.mobileqq.wink.editor.c.a0(material));
                    this.C.setTextColor(this.itemView.getContext().getResources().getColor(R.color.bfp));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public au(@NotNull Context context, @Nullable WinkEditorViewModel.EditMode editMode, @Nullable Function0<Unit> function0) {
        super(context, editMode, 2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.handleItemClick = function0;
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

    @Override // com.tencent.mobileqq.wink.view.AbsWinkMaterialPanelContentAdapter
    public void e0(@NotNull MetaMaterial mate) {
        Intrinsics.checkNotNullParameter(mate, "mate");
        this.selectedMetaMaterial = mate;
        super.e0(mate);
    }

    @Override // com.tencent.mobileqq.wink.view.ab
    @NotNull
    protected ab.a o0(@Nullable ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.i4z, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new a(this, view);
    }

    @Nullable
    /* renamed from: r0, reason: from getter */
    public final MetaMaterial getSelectedMetaMaterial() {
        return this.selectedMetaMaterial;
    }
}
