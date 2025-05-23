package com.tencent.mobileqq.guild.media.widget.user.delegates;

import android.view.View;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.guild.base.recyclerview.viewholder.BaseViewHolder;
import com.tencent.mobileqq.guild.media.widget.user.delegates.BaseMediaItemDelegate.BaseMediaViewHolder;
import com.tencent.mobileqq.guild.widget.adapterdelegates.AbsListItemAdapterDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import rt1.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b&\u0018\u0000 \u0010*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00010\u0005:\u0002\u0011\u0012B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0014\u00a2\u0006\u0004\b\f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/user/delegates/BaseMediaItemDelegate;", "Lrt1/a;", "T", "Lcom/tencent/mobileqq/guild/media/widget/user/delegates/BaseMediaItemDelegate$BaseMediaViewHolder;", "VH", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/AbsListItemAdapterDelegate;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "holder", "", "", "payloads", "", "o", "(Lrt1/a;Lcom/tencent/mobileqq/guild/media/widget/user/delegates/BaseMediaItemDelegate$BaseMediaViewHolder;Ljava/util/List;)V", "<init>", "()V", "d", "BaseMediaViewHolder", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public abstract class BaseMediaItemDelegate<T extends rt1.a, VH extends BaseMediaViewHolder> extends AbsListItemAdapterDelegate<T, rt1.a, VH> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/user/delegates/BaseMediaItemDelegate$BaseMediaViewHolder;", "Lcom/tencent/mobileqq/guild/base/recyclerview/viewholder/BaseViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static abstract class BaseMediaViewHolder extends BaseViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BaseMediaViewHolder(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void o(@NotNull T item, @NotNull VH holder, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
    }
}
