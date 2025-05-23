package com.tencent.guildlive.aio.msglist.holder.component;

import android.view.View;
import android.widget.TextView;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\r\u00a2\u0006\u0004\b\u0016\u0010\u0017J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/guildlive/aio/msglist/holder/component/u;", "Lcom/tencent/guildlive/aio/msglist/holder/component/AbsGuildLiveComponent;", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "", "b1", "Landroid/widget/TextView;", Constants.APK_CERTIFICATE, "Landroid/view/View;", "D", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "E", "Landroid/widget/TextView;", "tailView", "<init>", "(Landroid/view/View;)V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class u extends AbsGuildLiveComponent {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final TextView tailView;

    public u(@NotNull View root) {
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        this.tailView = new TextView(root.getContext());
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    /* renamed from: G1, reason: from getter and merged with bridge method [inline-methods] */
    public TextView d1() {
        return this.tailView;
    }

    @Override // com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent, com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.b1(position, msgItem, payloads);
        this.tailView.setClickable(false);
        this.tailView.setFocusable(false);
        this.tailView.setBackgroundResource(R.drawable.d5u);
        this.tailView.setGravity(17);
        int dimensionPixelSize = this.root.getResources().getDimensionPixelSize(R.dimen.c0u);
        this.tailView.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        this.tailView.setTextSize(0, this.root.getResources().getDimensionPixelSize(R.dimen.f158239c03));
        this.tailView.setVisibility(8);
        vr0.a.f443189a.a();
    }
}
