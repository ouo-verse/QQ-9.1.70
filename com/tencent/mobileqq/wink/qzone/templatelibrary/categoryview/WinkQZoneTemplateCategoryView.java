package com.tencent.mobileqq.wink.qzone.templatelibrary.categoryview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/wink/qzone/templatelibrary/categoryview/WinkQZoneTemplateCategoryView;", "Lcom/tencent/mobileqq/wink/qzone/templatelibrary/categoryview/WinkQZoneTemplateCategoryBaseView;", "", "C0", "F0", "G0", "E0", "B0", "D0", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkQZoneTemplateCategoryView extends WinkQZoneTemplateCategoryBaseView {

    @NotNull
    public Map<Integer, View> I;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WinkQZoneTemplateCategoryView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.mobileqq.wink.qzone.templatelibrary.categoryview.WinkQZoneTemplateCategoryBaseView
    public int B0() {
        return ImmersiveUtils.dpToPx(8.0f);
    }

    @Override // com.tencent.mobileqq.wink.qzone.templatelibrary.categoryview.WinkQZoneTemplateCategoryBaseView
    public int C0() {
        return R.layout.i7j;
    }

    @Override // com.tencent.mobileqq.wink.qzone.templatelibrary.categoryview.WinkQZoneTemplateCategoryBaseView
    public int D0() {
        return ImmersiveUtils.dpToPx(22.0f);
    }

    @Override // com.tencent.mobileqq.wink.qzone.templatelibrary.categoryview.WinkQZoneTemplateCategoryBaseView
    public int E0() {
        return com.tencent.mobileqq.wink.qzone.templatelibrary.utils.c.f326233a.g();
    }

    @Override // com.tencent.mobileqq.wink.qzone.templatelibrary.categoryview.WinkQZoneTemplateCategoryBaseView
    public int F0() {
        return R.layout.i7i;
    }

    @Override // com.tencent.mobileqq.wink.qzone.templatelibrary.categoryview.WinkQZoneTemplateCategoryBaseView
    public int G0() {
        return com.tencent.mobileqq.wink.qzone.templatelibrary.utils.c.f326233a.h();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WinkQZoneTemplateCategoryView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.I = new LinkedHashMap();
    }

    public /* synthetic */ WinkQZoneTemplateCategoryView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }
}
