package com.tencent.mobileqq.partner.signin.drawer;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.h;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import j61.IntimateBaseModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J4\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u001a\u0010\u000f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00020\u000e0\r0\fH\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/partner/signin/drawer/a;", "Lcom/tencent/mobileqq/activity/aio/intimate/reborn/itemdelegate/h;", "Lj61/a;", "model", "", "b", "", "getLayoutId", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "itemView", "", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "sections", "", "initSection", "<init>", "()V", "mutualmark_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class a extends h {
    @Override // com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.h
    public boolean b(IntimateBaseModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        f61.h hVar = model.getIntimateInfo().mutualMarkList;
        List<f> list = hVar != null ? hVar.f397928i : null;
        return !(list == null || list.isEmpty());
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public int getLayoutId() {
        return R.layout.cvw;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public void initSection(ViewGroup parent, View itemView, List<Class<? extends Section<IntimateBaseModel>>> sections) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(sections, "sections");
        sections.add(e.class);
    }
}
