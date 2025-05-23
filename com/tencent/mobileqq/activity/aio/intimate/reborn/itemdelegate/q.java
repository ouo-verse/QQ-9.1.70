package com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.biz.richframework.part.adapter.section.SectionViewHolder;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import j61.IntimateBaseModel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import k61.z;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016J4\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u001a\u0010\f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t0\bH\u0016J\u0014\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u000bH\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/reborn/itemdelegate/q;", "Lcom/tencent/mobileqq/activity/aio/intimate/reborn/itemdelegate/h;", "", "getLayoutId", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "itemView", "", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lj61/a;", "sections", "", "initSection", "Lcom/tencent/biz/richframework/part/adapter/section/SectionViewHolder;", "onCreateViewHolder", "model", "", "b", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class q extends h {
    @Override // com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.h
    public boolean b(@NotNull IntimateBaseModel model) {
        boolean z16;
        Intrinsics.checkNotNullParameter(model, "model");
        List<IntimateInfo.MemoryDayInfo> list = model.getIntimateInfo().memoryDayInfoList;
        List<IntimateInfo.MemoryDayInfo> list2 = list;
        if (list2 != null && !list2.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Date date = new Date(NetConnInfoCenter.getServerTimeMillis());
        for (IntimateInfo.MemoryDayInfo memoryDayInfo : list) {
            if (memoryDayInfo != null && memoryDayInfo.date != 0) {
                Date date2 = new Date(memoryDayInfo.date);
                if (date.getDay() == date2.getDay() && date.getMonth() == date2.getMonth() && date.getYear() == date2.getYear()) {
                    arrayList.add(memoryDayInfo);
                }
            }
        }
        return !arrayList.isEmpty();
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public int getLayoutId() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public void initSection(@NotNull ViewGroup parent, @NotNull View itemView, @NotNull List<Class<? extends Section<IntimateBaseModel>>> sections) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(sections, "sections");
        sections.add(z.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate.h, com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
    @NotNull
    public SectionViewHolder<?> onCreateViewHolder(@NotNull ViewGroup parent) {
        Context context;
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (!(parent.getContext() instanceof Activity) && (parent.getContext() instanceof ContextWrapper)) {
            Context context2 = parent.getContext();
            Intrinsics.checkNotNull(context2, "null cannot be cast to non-null type android.content.ContextWrapper");
            context = ((ContextWrapper) context2).getBaseContext();
        } else {
            context = parent.getContext();
        }
        com.tencent.mobileqq.activity.aio.intimate.k kVar = new com.tencent.mobileqq.activity.aio.intimate.k(context, "");
        View itemView = kVar.g();
        itemView.setTag(kVar);
        itemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        List<Class<? extends Section<IntimateBaseModel>>> arrayList = new ArrayList<>();
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        initSection(parent, itemView, arrayList);
        return new SectionViewHolder<>(itemView, arrayList);
    }
}
