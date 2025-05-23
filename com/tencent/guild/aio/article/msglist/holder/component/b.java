package com.tencent.guild.aio.article.msglist.holder.component;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0018\u0010\u0019J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0017\u0010\u0014\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0017\u001a\n \u0015*\u0004\u0018\u00010\u000b0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0011\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/guild/aio/article/msglist/holder/component/b;", "Lcom/tencent/guild/aio/msglist/holder/component/a;", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "", "b1", "Landroid/view/View;", "d1", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "onCreateView", "f", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "kotlin.jvm.PlatformType", h.F, "replyCountLayout", "<init>", "(Landroid/view/View;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b extends com.tencent.guild.aio.msglist.holder.component.a {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final View replyCountLayout;

    public b(@NotNull View root) {
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        this.replyCountLayout = LayoutInflater.from(root.getContext()).inflate(R.layout.f168036eg3, (ViewGroup) null, false);
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        int i3;
        boolean z16;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        String extInfoFromExtStr$default = GuildMsgItem.getExtInfoFromExtStr$default((GuildMsgItem) msgItem, "guild_article_main_reply_count", null, 2, null);
        if (extInfoFromExtStr$default != null) {
            if (extInfoFromExtStr$default.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                i3 = Integer.parseInt(extInfoFromExtStr$default);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = this.root.getContext().getString(R.string.f139750c4);
                Intrinsics.checkNotNullExpressionValue(string, "root.context.getString(R\u2026.guild_article_reply_num)");
                String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(i3)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                ((TextView) this.root.findViewById(R.id.f73323t9)).setText(format);
                this.root.findViewById(R.id.ywe).setBackgroundColor(this.root.getContext().getColor(R.color.qui_common_fill_standard_primary));
            }
        }
        i3 = 0;
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String string2 = this.root.getContext().getString(R.string.f139750c4);
        Intrinsics.checkNotNullExpressionValue(string2, "root.context.getString(R\u2026.guild_article_reply_num)");
        String format2 = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(i3)}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        ((TextView) this.root.findViewById(R.id.f73323t9)).setText(format2);
        this.root.findViewById(R.id.ywe).setBackgroundColor(this.root.getContext().getColor(R.color.qui_common_fill_standard_primary));
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public View d1() {
        View replyCountLayout = this.replyCountLayout;
        Intrinsics.checkNotNullExpressionValue(replyCountLayout, "replyCountLayout");
        return replyCountLayout;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View containerView = getContainerView();
        Intrinsics.checkNotNull(containerView);
        return containerView;
    }
}
