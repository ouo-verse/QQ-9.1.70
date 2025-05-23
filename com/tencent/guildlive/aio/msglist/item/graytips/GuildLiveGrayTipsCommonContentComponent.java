package com.tencent.guildlive.aio.msglist.item.graytips;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.guild.aio.msglist.graytips.common.GuildCommonGrayTipsUIState;
import com.tencent.guild.aio.msglist.graytips.common.b;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent;
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
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 #2\u00020\u0001:\u0001$B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0014\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0016J&\u0010\u0013\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\nH\u0016R\u0017\u0010\u001a\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010 \u001a\u00020\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/guildlive/aio/msglist/item/graytips/GuildLiveGrayTipsCommonContentComponent;", "Lcom/tencent/guildlive/aio/msglist/holder/component/AbsGuildLiveComponent;", "", "text", "", "J1", "Landroid/view/View;", "d1", "Lcom/tencent/aio/base/mvvm/b;", "Lol3/b;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "e1", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "b1", "state", "handleUIState", "D", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "Landroid/widget/TextView;", "E", "Lkotlin/Lazy;", "I1", "()Landroid/widget/TextView;", "mRootView", "<init>", "(Landroid/view/View;)V", UserInfo.SEX_FEMALE, "a", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildLiveGrayTipsCommonContentComponent extends AbsGuildLiveComponent {
    private static final int G = ViewUtils.dip2px(5.0f);
    private static final int H = ViewUtils.dip2px(6.0f);

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

    public GuildLiveGrayTipsCommonContentComponent(@NotNull View root) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.guildlive.aio.msglist.item.graytips.GuildLiveGrayTipsCommonContentComponent$mRootView$2
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
                TextView textView = new TextView(GuildLiveGrayTipsCommonContentComponent.this.getRoot().getContext());
                GuildLiveGrayTipsCommonContentComponent guildLiveGrayTipsCommonContentComponent = GuildLiveGrayTipsCommonContentComponent.this;
                textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                i3 = GuildLiveGrayTipsCommonContentComponent.G;
                i16 = GuildLiveGrayTipsCommonContentComponent.H;
                i17 = GuildLiveGrayTipsCommonContentComponent.G;
                i18 = GuildLiveGrayTipsCommonContentComponent.H;
                textView.setPadding(i3, i16, i17, i18);
                textView.setMovementMethod(LinkMovementMethod.getInstance());
                textView.setIncludeFontPadding(false);
                textView.setTextSize(14.0f);
                textView.setTextColor(guildLiveGrayTipsCommonContentComponent.getRoot().getContext().getResources().getColor(R.color.bpx));
                return textView;
            }
        });
        this.mRootView = lazy;
    }

    private final TextView I1() {
        return (TextView) this.mRootView.getValue();
    }

    private final void J1(CharSequence text) {
        I1().setText(text);
    }

    @Override // com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent, com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.b1(position, msgItem, payloads);
        if (msgItem instanceof GuildMsgItem) {
            sendIntent(new b.a(msgItem, I1(), I));
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

    @Override // com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent, com.tencent.guild.aio.msglist.holder.component.a, com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    /* renamed from: e1 */
    public com.tencent.aio.base.mvvm.b<ol3.b, MviUIState> createVM() {
        return new com.tencent.guild.aio.msglist.graytips.common.d();
    }

    @NotNull
    public final View getRoot() {
        return this.root;
    }

    @Override // com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent, com.tencent.mvi.mvvm.BaseVB
    public void handleUIState(@NotNull MviUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (state instanceof GuildCommonGrayTipsUIState.SetGrayTipsText) {
            J1(((GuildCommonGrayTipsUIState.SetGrayTipsText) state).getText());
        }
    }
}
