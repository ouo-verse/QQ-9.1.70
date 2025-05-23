package com.tencent.mobileqq.zplan.bubble;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.qid.QidPagView;
import com.tencent.mobileqq.zplan.bubble.c;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import fi3.bs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yi3.ZPlanInformationBubbleInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u0016\u0010\u0014\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0016\u0010\u001b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001f\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001eR\u0018\u0010#\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001a\u0010%\u001a\u00020\t8\u0016X\u0096D\u00a2\u0006\f\n\u0004\b\u0006\u0010$\u001a\u0004\b%\u0010&R\u0011\u0010(\u001a\u00020 8F\u00a2\u0006\u0006\u001a\u0004\b!\u0010'R\u0014\u0010+\u001a\u00020)8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010*\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/zplan/bubble/m;", "Lcom/tencent/mobileqq/zplan/bubble/c;", "Lyi3/a;", "", "designerPx", "e", "g", "Lyi3/e;", "newBubbleInfo", "", "b", "", "onCreate", "onShow", "onHide", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/widget/FrameLayout;", "newParent", "a", "Landroid/widget/FrameLayout;", HippyNestedScrollComponent.PRIORITY_PARENT, "I", "parentWidthPx", "c", "parentHeightPx", "d", "Lyi3/a;", "bubbleInfo", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "Landroid/content/Context;", "context", "Lfi3/bs;", "f", "Lfi3/bs;", "_binding", "Z", "isClickable", "()Z", "()Lfi3/bs;", "binding", "Landroid/graphics/Rect;", "()Landroid/graphics/Rect;", "globalVisibleRect", "<init>", "(Landroid/widget/FrameLayout;IILyi3/a;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class m implements c<ZPlanInformationBubbleInfo> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private FrameLayout parent;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int parentWidthPx;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int parentHeightPx;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ZPlanInformationBubbleInfo bubbleInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private bs _binding;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final boolean isClickable;

    public m(FrameLayout parent, int i3, int i16, ZPlanInformationBubbleInfo bubbleInfo) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(bubbleInfo, "bubbleInfo");
        this.parent = parent;
        this.parentWidthPx = i3;
        this.parentHeightPx = i16;
        this.bubbleInfo = bubbleInfo;
        this.context = parent.getContext();
    }

    private final int e(int designerPx) {
        bb bbVar = bb.f335811a;
        Context context = this.parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        return bbVar.a(context, designerPx, QidPagView.DESIGN_PAG_WIDTH);
    }

    @Override // com.tencent.mobileqq.zplan.bubble.c
    public void a(FrameLayout newParent) {
        bs bsVar;
        LinearLayout root;
        Intrinsics.checkNotNullParameter(newParent, "newParent");
        FrameLayout frameLayout = this.parent;
        if (Intrinsics.areEqual(frameLayout, newParent) || (bsVar = this._binding) == null || (root = bsVar.getRoot()) == null) {
            return;
        }
        frameLayout.removeView(root);
        newParent.addView(root);
        this.parent = newParent;
    }

    @Override // com.tencent.mobileqq.zplan.bubble.c
    public boolean b(yi3.e newBubbleInfo) {
        Intrinsics.checkNotNullParameter(newBubbleInfo, "newBubbleInfo");
        if (!(newBubbleInfo instanceof ZPlanInformationBubbleInfo)) {
            return false;
        }
        this.bubbleInfo = (ZPlanInformationBubbleInfo) newBubbleInfo;
        return true;
    }

    @Override // com.tencent.mobileqq.zplan.bubble.c
    public Rect d() {
        Rect rect = new Rect();
        f().getRoot().getGlobalVisibleRect(rect);
        return rect;
    }

    public final bs f() {
        bs bsVar = this._binding;
        Intrinsics.checkNotNull(bsVar);
        return bsVar;
    }

    @Override // com.tencent.mobileqq.zplan.bubble.c
    /* renamed from: g, reason: from getter and merged with bridge method [inline-methods] */
    public ZPlanInformationBubbleInfo c() {
        return this.bubbleInfo;
    }

    @Override // com.tencent.mobileqq.zplan.bubble.c
    /* renamed from: isClickable, reason: from getter */
    public boolean getIsClickable() {
        return this.isClickable;
    }

    @Override // com.tencent.mobileqq.zplan.bubble.c
    public void onCreate() {
        this._binding = bs.g(LayoutInflater.from(this.context), this.parent, true);
    }

    @Override // com.tencent.mobileqq.zplan.bubble.c
    public void onDestroy() {
        this.parent.removeView(f().getRoot());
        this._binding = null;
    }

    @Override // com.tencent.mobileqq.zplan.bubble.c
    public void onHide() {
        LinearLayout root = f().getRoot();
        if (root == null) {
            return;
        }
        root.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.zplan.bubble.c
    public void onShow() {
        int i3 = QQTheme.isNowThemeIsNight() ? R.drawable.iha : R.drawable.ihb;
        int paddingBottom = f().f399147b.getPaddingBottom();
        int paddingTop = f().f399147b.getPaddingTop();
        int paddingLeft = f().f399147b.getPaddingLeft();
        int paddingRight = f().f399147b.getPaddingRight();
        f().f399147b.setBackgroundResource(i3);
        f().f399147b.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
        f().f399148c.setText(this.bubbleInfo.getText());
        f().getRoot().setVisibility(0);
        LinearLayout root = f().getRoot();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 51;
        layoutParams.leftMargin = (int) (this.parentWidthPx * 0.636f);
        layoutParams.topMargin = (int) (this.parentHeightPx * 0.567f);
        layoutParams.rightMargin = e(16);
        root.setLayoutParams(layoutParams);
    }

    @Override // com.tencent.mobileqq.zplan.bubble.c
    public void setOnClickListener(View.OnClickListener onClickListener) {
        c.a.a(this, onClickListener);
    }
}
