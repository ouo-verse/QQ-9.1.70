package com.tencent.mobileqq.guild.main.topchannel.adapter;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import vp1.du;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/main/topchannel/adapter/h;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lvp1/du;", "E", "Lvp1/du;", "o", "()Lvp1/du;", "binding", "<init>", "(Lvp1/du;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class h extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final du binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NotNull du binding) {
        super(binding.getRoot());
        Intrinsics.checkNotNullParameter(binding, "binding");
        this.binding = binding;
        binding.f442996c.post(new Runnable() { // from class: com.tencent.mobileqq.guild.main.topchannel.adapter.g
            @Override // java.lang.Runnable
            public final void run() {
                h.m(h.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(h this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.binding.f442996c.setBackgroundResource(R.drawable.guild_top_card_msg_item_bg);
    }

    @NotNull
    /* renamed from: o, reason: from getter */
    public final du getBinding() {
        return this.binding;
    }
}
