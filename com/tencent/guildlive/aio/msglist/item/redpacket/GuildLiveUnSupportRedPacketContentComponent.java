package com.tencent.guildlive.aio.msglist.item.redpacket;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016J&\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016R\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0017\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/guildlive/aio/msglist/item/redpacket/GuildLiveUnSupportRedPacketContentComponent;", "Lcom/tencent/guildlive/aio/msglist/holder/component/AbsGuildLiveComponent;", "Landroid/view/View;", "d1", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "", "b1", "D", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "Landroid/widget/TextView;", "E", "Lkotlin/Lazy;", "I1", "()Landroid/widget/TextView;", "mRootView", "<init>", "(Landroid/view/View;)V", UserInfo.SEX_FEMALE, "a", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildLiveUnSupportRedPacketContentComponent extends AbsGuildLiveComponent {
    private static final int G = ViewUtils.dip2px(5.0f);
    private static final int H = ViewUtils.dip2px(7.0f);

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy mRootView;

    public GuildLiveUnSupportRedPacketContentComponent(@NotNull View root) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.guildlive.aio.msglist.item.redpacket.GuildLiveUnSupportRedPacketContentComponent$mRootView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                int i3;
                int i16;
                int i17;
                int i18;
                TextView textView = new TextView(GuildLiveUnSupportRedPacketContentComponent.this.getRoot().getContext());
                GuildLiveUnSupportRedPacketContentComponent guildLiveUnSupportRedPacketContentComponent = GuildLiveUnSupportRedPacketContentComponent.this;
                textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                i3 = GuildLiveUnSupportRedPacketContentComponent.G;
                i16 = GuildLiveUnSupportRedPacketContentComponent.H;
                i17 = GuildLiveUnSupportRedPacketContentComponent.G;
                i18 = GuildLiveUnSupportRedPacketContentComponent.H;
                textView.setPadding(i3, i16, i17, i18);
                textView.setIncludeFontPadding(false);
                textView.setTextSize(13.0f);
                textView.setText("[QQ\u7ea2\u5305]\u5f53\u524d\u5e73\u53f0\u7248\u672c\u6682\u4e0d\u652f\u6301\u8be5\u7c7b\u578b\u7ea2\u5305");
                textView.setTextColor(guildLiveUnSupportRedPacketContentComponent.getRoot().getContext().getResources().getColor(R.color.bpx));
                return textView;
            }
        });
        this.mRootView = lazy;
    }

    private final TextView I1() {
        return (TextView) this.mRootView.getValue();
    }

    @Override // com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent, com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.b1(position, msgItem, payloads);
        if (msgItem instanceof GuildMsgItem) {
            yr0.a.s(I1(), true);
        } else {
            yr0.a.s(I1(), false);
        }
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public View d1() {
        return I1();
    }

    @NotNull
    public final View getRoot() {
        return this.root;
    }
}
