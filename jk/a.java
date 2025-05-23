package jk;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.reborn.base.l;
import com.qzone.reborn.configx.g;
import com.tencent.biz.richframework.widget.RoundCorneredLinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import ij.i;
import java.util.List;
import kotlin.Metadata;
import qzone.QZIntimateProfileReader$CreateMoreSpaceGuide;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J*\u0010\u0011\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0014J\u0012\u0010\u0012\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\bH\u0016R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Ljk/a;", "Lcom/qzone/reborn/base/l;", "Lij/i;", "Landroid/view/View$OnClickListener;", "", "v", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", "u", NodeProps.ON_CLICK, "Lcom/tencent/biz/richframework/widget/RoundCorneredLinearLayout;", "e", "Lcom/tencent/biz/richframework/widget/RoundCorneredLinearLayout;", "rootContainer", "Landroid/widget/ImageView;", "f", "Landroid/widget/ImageView;", "createImg", "Landroid/widget/TextView;", h.F, "Landroid/widget/TextView;", "createText", "<init>", "()V", "i", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends l<i> implements View.OnClickListener {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RoundCorneredLinearLayout rootContainer;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView createImg;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView createText;

    private final void v() {
        RoundCorneredLinearLayout roundCorneredLinearLayout = this.rootContainer;
        ViewGroup.LayoutParams layoutParams = roundCorneredLinearLayout != null ? roundCorneredLinearLayout.getLayoutParams() : null;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((ViewGroup.LayoutParams) ((FrameLayout.LayoutParams) layoutParams)).height = ImmersiveUtils.dpToPx(182.0f);
            RoundCorneredLinearLayout roundCorneredLinearLayout2 = this.rootContainer;
            if (roundCorneredLinearLayout2 == null) {
                return;
            }
            roundCorneredLinearLayout2.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[]{R.id.n4y};
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        i iVar;
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf == null || valueOf.intValue() != R.id.f20167n || (iVar = (i) this.mData) == null || iVar.getCreateMoreSpaceGuide() == null || com.qzone.reborn.util.e.c("QZIntimateManageCreateSpaceSection", 2000L)) {
            return;
        }
        ho.i.q(p(), g.f53821a.h().D());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void onBindData(i data, int position, List<Object> payload) {
        QZIntimateProfileReader$CreateMoreSpaceGuide createMoreSpaceGuide;
        if (data == null || (createMoreSpaceGuide = data.getCreateMoreSpaceGuide()) == null) {
            return;
        }
        if (TextUtils.isEmpty(createMoreSpaceGuide.guide_text.get())) {
            RoundCorneredLinearLayout roundCorneredLinearLayout = this.rootContainer;
            if (roundCorneredLinearLayout == null) {
                return;
            }
            roundCorneredLinearLayout.setVisibility(8);
            return;
        }
        RoundCorneredLinearLayout roundCorneredLinearLayout2 = this.rootContainer;
        if (roundCorneredLinearLayout2 != null) {
            roundCorneredLinearLayout2.setVisibility(0);
        }
        rn.h.a(this.createImg, createMoreSpaceGuide.icontoken.get(), R.color.qui_common_icon_primary);
        TextView textView = this.createText;
        if (textView != null) {
            textView.setText(createMoreSpaceGuide.guide_text.get());
        }
        QLog.d("QZIntimateManageCreateSpaceSection", 1, "bindData  | actionurl = " + createMoreSpaceGuide.button.actionurl.get() + " | icontoken = " + createMoreSpaceGuide.icontoken.get() + " | guide_text = " + createMoreSpaceGuide.guide_text.get() + " | btnText = " + createMoreSpaceGuide.button.text.get());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        RoundCorneredLinearLayout roundCorneredLinearLayout = containerView != null ? (RoundCorneredLinearLayout) containerView.findViewById(R.id.f20167n) : null;
        this.rootContainer = roundCorneredLinearLayout;
        if (roundCorneredLinearLayout == null) {
            return;
        }
        if (roundCorneredLinearLayout != null) {
            roundCorneredLinearLayout.setRadius(ef.d.b(8));
        }
        RoundCorneredLinearLayout roundCorneredLinearLayout2 = this.rootContainer;
        if (roundCorneredLinearLayout2 != null) {
            roundCorneredLinearLayout2.setOnClickListener(this);
        }
        v();
        fo.c.n(this.rootContainer, "em_qz_boot_create_banner");
    }
}
