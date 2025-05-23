package com.tencent.guildmedia.aio.msglist.item.graytips;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.guild.aio.msglist.graytips.common.GuildCommonGrayTipsUIState;
import com.tencent.guild.aio.msglist.graytips.common.b;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mvi.base.mvi.MviUIState;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \"2\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0006\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J&\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u0017\u0010\u0019\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001f\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/guildmedia/aio/msglist/item/graytips/GuildMediaGrayTipsCommonContentComponent;", "Lcom/tencent/guildmedia/aio/msglist/holder/component/a;", "", "text", "", "L1", "Landroid/view/View;", "d1", "Lcom/tencent/guild/aio/msglist/graytips/common/d;", "J1", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "b1", "Lcom/tencent/mvi/base/mvi/MviUIState;", "state", "handleUIState", "D", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "Landroid/widget/TextView;", "E", "Lkotlin/Lazy;", "K1", "()Landroid/widget/TextView;", "mRootView", "<init>", "(Landroid/view/View;)V", UserInfo.SEX_FEMALE, "a", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildMediaGrayTipsCommonContentComponent extends com.tencent.guildmedia.aio.msglist.holder.component.a {
    private static final int G = ViewUtils.dip2px(5.0f);
    private static final int H = ViewUtils.dip2px(7.0f);

    @NotNull
    private static final Bundle I;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy mRootView;

    static {
        Bundle bundle = new Bundle();
        bundle.putInt("extra_key_gray_tip_icon_right_padding", ViewUtils.dip2px(5.0f));
        bundle.putInt("extra_key_gray_tip_icon_size", ViewUtils.dip2px(18.0f));
        bundle.putInt("extra_key_gray_tip_other_line_indentation", ViewUtils.dip2px(28.0f));
        I = bundle;
    }

    public GuildMediaGrayTipsCommonContentComponent(@NotNull View root) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.guildmedia.aio.msglist.item.graytips.GuildMediaGrayTipsCommonContentComponent$mRootView$2
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
                TextView textView = new TextView(GuildMediaGrayTipsCommonContentComponent.this.getRoot().getContext());
                GuildMediaGrayTipsCommonContentComponent guildMediaGrayTipsCommonContentComponent = GuildMediaGrayTipsCommonContentComponent.this;
                textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                i3 = GuildMediaGrayTipsCommonContentComponent.G;
                i16 = GuildMediaGrayTipsCommonContentComponent.H;
                i17 = GuildMediaGrayTipsCommonContentComponent.G;
                i18 = GuildMediaGrayTipsCommonContentComponent.H;
                textView.setPadding(i3, i16, i17, i18);
                textView.setMovementMethod(LinkMovementMethod.getInstance());
                textView.setIncludeFontPadding(false);
                textView.setTextSize(13.0f);
                textView.setTextColor(guildMediaGrayTipsCommonContentComponent.getRoot().getContext().getResources().getColor(R.color.bpx));
                return textView;
            }
        });
        this.mRootView = lazy;
    }

    private final TextView K1() {
        return (TextView) this.mRootView.getValue();
    }

    private final void L1(CharSequence text) {
        K1().setText(text);
    }

    @Override // com.tencent.guild.aio.component.combinestyle.AbsGuildMediaStyleComponent, com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    /* renamed from: J1, reason: merged with bridge method [inline-methods] */
    public com.tencent.guild.aio.msglist.graytips.common.d createVM() {
        return new com.tencent.guild.aio.msglist.graytips.common.d();
    }

    @Override // com.tencent.guild.aio.component.combinestyle.AbsGuildMediaStyleComponent, com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.b1(position, msgItem, payloads);
        if (msgItem instanceof GuildMsgItem) {
            sendIntent(new b.a(msgItem, K1(), I));
            vs0.a.p(K1(), true);
        } else {
            vs0.a.p(K1(), false);
        }
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    public View d1() {
        return K1();
    }

    @NotNull
    public final View getRoot() {
        return this.root;
    }

    @Override // com.tencent.guild.aio.component.combinestyle.AbsGuildMediaStyleComponent, com.tencent.mvi.mvvm.BaseVB
    public void handleUIState(@NotNull MviUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildCommonGrayTipsUIState.SetGrayTipsText) {
            L1(((GuildCommonGrayTipsUIState.SetGrayTipsText) state).getText());
        }
    }
}
