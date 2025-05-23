package com.tencent.mobileqq.activity.aio.intimate.reborn.itemdelegate;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate;
import com.tencent.biz.richframework.part.adapter.section.SectionViewHolder;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import j61.IntimateBaseModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0004J\u0014\u0010\r\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u000b\u001a\u00020\nH\u0014J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0002H&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/intimate/reborn/itemdelegate/h;", "Lcom/tencent/biz/richframework/part/adapter/delegate/AbsItemAdapterDelegate;", "Lj61/a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "c", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/biz/richframework/part/adapter/section/SectionViewHolder;", "onCreateViewHolder", "model", "b", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public abstract class h extends AbsItemAdapterDelegate<IntimateBaseModel, IntimateBaseModel> {
    public abstract boolean b(@NotNull IntimateBaseModel model);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final boolean isForViewType(@NotNull IntimateBaseModel item, @NotNull List<IntimateBaseModel> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegate
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
        ArrayList arrayList = new ArrayList();
        View inflate = LayoutInflater.from(context).inflate(getLayoutId(), parent, false);
        initSection(parent, inflate, arrayList);
        return new SectionViewHolder<>(inflate, arrayList);
    }
}
