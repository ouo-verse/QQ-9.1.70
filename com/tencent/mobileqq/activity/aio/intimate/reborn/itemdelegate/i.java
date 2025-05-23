package com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemNewDnaView;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipConfProcessor;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import j61.IntimateBaseModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J4\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u001a\u0010\r\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00020\f0\u000b0\nH\u0016J\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0011\u001a\u00020\u0010H\u0014J\b\u0010\u0016\u001a\u00020\u0015H\u0014\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/reborn/itemdelegate/i;", "Lcom/tencent/mobileqq/activity/aio/intimate/reborn/itemdelegate/IntimateCompatBaseItemDelegate;", "Lj61/a;", "model", "", "b", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "itemView", "", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "sections", "", "initSection", "Landroid/content/Context;", "context", "d", "Landroid/graphics/drawable/Drawable;", tl.h.F, "Landroid/view/ViewGroup$MarginLayoutParams;", "i", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class i extends IntimateCompatBaseItemDelegate {
    @Override // com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.h
    public boolean b(@NotNull IntimateBaseModel model) {
        boolean z16;
        Intrinsics.checkNotNullParameter(model, "model");
        boolean z17 = FriendIntimateRelationshipConfProcessor.a().f202727w0;
        if (model.getIntimateInfo().newDnaInfos != null && model.getIntimateInfo().newDnaInfos.size() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z17 && z16) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.IntimateCompatBaseItemDelegate
    @NotNull
    public View d(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new IntimateContentItemNewDnaView(context);
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.IntimateCompatBaseItemDelegate
    @Nullable
    protected Drawable h(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return null;
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.IntimateCompatBaseItemDelegate
    @NotNull
    protected ViewGroup.MarginLayoutParams i() {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
        marginLayoutParams.bottomMargin = g();
        return marginLayoutParams;
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.IntimateCompatBaseItemDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public void initSection(@NotNull ViewGroup parent, @NotNull View itemView, @NotNull List<Class<? extends Section<IntimateBaseModel>>> sections) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(sections, "sections");
        sections.add(k61.g.class);
    }
}
