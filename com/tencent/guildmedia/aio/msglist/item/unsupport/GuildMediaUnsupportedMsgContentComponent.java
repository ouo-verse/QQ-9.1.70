package com.tencent.guildmedia.aio.msglist.item.unsupport;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.guild.aio.msglist.holder.component.a;
import com.tencent.guild.api.appsetting.IAppSetting;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J&\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016R\u001b\u0010\u0015\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/guildmedia/aio/msglist/item/unsupport/GuildMediaUnsupportedMsgContentComponent;", "Lcom/tencent/guild/aio/msglist/holder/component/a;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "onCreateView", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "", "b1", "d1", "Landroid/widget/TextView;", "f", "Lkotlin/Lazy;", "k1", "()Landroid/widget/TextView;", "contentView", "root", "<init>", "(Landroid/view/View;)V", h.F, "a", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildMediaUnsupportedMsgContentComponent extends a {

    /* renamed from: i, reason: collision with root package name */
    private static final int f113131i = ViewUtils.dip2px(5.0f);

    /* renamed from: m, reason: collision with root package name */
    private static final int f113132m = ViewUtils.dip2px(7.0f);

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy contentView;

    public GuildMediaUnsupportedMsgContentComponent(@NotNull final View root) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(root, "root");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.guildmedia.aio.msglist.item.unsupport.GuildMediaUnsupportedMsgContentComponent$contentView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                TextView textView = new TextView(root.getContext());
                View view = root;
                textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                i3 = GuildMediaUnsupportedMsgContentComponent.f113131i;
                i16 = GuildMediaUnsupportedMsgContentComponent.f113132m;
                i17 = GuildMediaUnsupportedMsgContentComponent.f113131i;
                i18 = GuildMediaUnsupportedMsgContentComponent.f113132m;
                textView.setPadding(i3, i16, i17, i18);
                textView.setIncludeFontPadding(false);
                textView.setTextSize(13.0f);
                textView.setTextColor(view.getContext().getResources().getColor(R.color.bpx));
                return textView;
            }
        });
        this.contentView = lazy;
    }

    private final TextView k1() {
        return (TextView) this.contentView.getValue();
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        if (!((IAppSetting) QRoute.api(IAppSetting.class)).mo112public()) {
            if (msgItem instanceof GuildMsgItem) {
                k1().setText("\u4e0d\u652f\u6301\u7684\u6d88\u606f\u7c7b\u578b msgType: " + ((GuildMsgItem) msgItem).getMsgRecord().msgType);
                return;
            }
            k1().setText("\u4e0d\u652f\u6301\u7684\u6d88\u606f\u7c7b\u578b");
            return;
        }
        k1().setText("\u5f53\u524d\u7248\u672c\u6682\u4e0d\u652f\u6301\u8be5\u6d88\u606f");
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public View d1() {
        return k1();
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
