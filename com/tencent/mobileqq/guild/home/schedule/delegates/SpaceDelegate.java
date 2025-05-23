package com.tencent.mobileqq.guild.home.schedule.delegates;

import android.annotation.SuppressLint;
import android.view.ViewGroup;
import android.widget.Space;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.guild.home.schedule.delegates.LoadDelegate;
import com.tencent.mobileqq.guild.home.schedule.models.d;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0015J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0014J4\u0010\u0012\u001a\u00020\u00112\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/home/schedule/delegates/SpaceDelegate;", "Lcom/tencent/mobileqq/guild/widget/adapterdelegates/b;", "", "Lcom/tencent/mobileqq/guild/home/schedule/models/d;", "items", "", "position", "", "j", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "d", "holder", "", "", "payloads", "", "k", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class SpaceDelegate extends com.tencent.mobileqq.guild.widget.adapterdelegates.b<List<? extends d>> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @NotNull
    public RecyclerView.ViewHolder d(@NotNull ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Space space = new Space(parent.getContext());
        space.setLayoutParams(new RecyclerView.LayoutParams(-1, ViewUtils.dpToPx(150.0f)));
        return new LoadDelegate.a(space);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    @SuppressLint({"WrongConstant"})
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public boolean a(@NotNull List<? extends d> items, int position) {
        Intrinsics.checkNotNullParameter(items, "items");
        if (items.get(position).getType() == 7) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.b
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public void c(@NotNull List<? extends d> items, int position, @NotNull RecyclerView.ViewHolder holder, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
    }
}
