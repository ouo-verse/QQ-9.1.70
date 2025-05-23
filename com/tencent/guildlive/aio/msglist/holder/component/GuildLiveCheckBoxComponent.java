package com.tencent.guildlive.aio.msglist.holder.component;

import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.guild.aio.msglist.checkbox.GuildMultiMsgManager;
import com.tencent.guild.aio.msglist.holder.component.s;
import com.tencent.guild.aio.util.ex.FromScene;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guildlive.aio.msglist.holder.component.i;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u00a2\u0006\u0004\b\u001d\u0010\u001eJ&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001c\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/guildlive/aio/msglist/holder/component/GuildLiveCheckBoxComponent;", "Lcom/tencent/guildlive/aio/msglist/holder/component/AbsGuildLiveComponent;", "", "position", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "", "payloads", "", "b1", "Landroid/widget/CheckBox;", "I1", "Lcom/tencent/guildlive/aio/msglist/holder/component/j;", "J1", "Lcom/tencent/mvi/base/mvi/MviUIState;", "state", "handleUIState", "Landroid/view/View;", "D", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "root", "E", "Lkotlin/Lazy;", "K1", "()Landroid/widget/CheckBox;", "contentView", "<init>", "(Landroid/view/View;)V", UserInfo.SEX_FEMALE, "a", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildLiveCheckBoxComponent extends AbsGuildLiveComponent {

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final View root;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy contentView;

    public GuildLiveCheckBoxComponent(@NotNull View root) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(root, "root");
        this.root = root;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<CheckBox>() { // from class: com.tencent.guildlive.aio.msglist.holder.component.GuildLiveCheckBoxComponent$contentView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CheckBox invoke() {
                CheckBox checkBox = new CheckBox(GuildLiveCheckBoxComponent.this.getRoot().getContext());
                int dip2px = ViewUtils.dip2px(24.0f);
                checkBox.setLayoutParams(new LinearLayout.LayoutParams(dip2px, dip2px));
                checkBox.setVisibility(8);
                checkBox.setId(R.id.vxo);
                return checkBox;
            }
        });
        this.contentView = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H1(GuildLiveCheckBoxComponent this$0, GuildMultiMsgManager selectManager, GuildMultiMsgManager.d session, com.tencent.aio.data.msglist.a msgItem, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(selectManager, "$selectManager");
        Intrinsics.checkNotNullParameter(session, "$session");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        if (this$0.K1().isChecked()) {
            selectManager.b(session, (GuildMsgItem) msgItem);
        } else {
            selectManager.k(session, (GuildMsgItem) msgItem);
        }
        this$0.sendIntent(i.a.f112843d);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final CheckBox K1() {
        return (CheckBox) this.contentView.getValue();
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    /* renamed from: I1, reason: merged with bridge method [inline-methods] */
    public CheckBox d1() {
        return K1();
    }

    @Override // com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent, com.tencent.guild.aio.msglist.holder.component.a
    @NotNull
    /* renamed from: J1, reason: merged with bridge method [inline-methods] */
    public j createVM() {
        return new j();
    }

    @Override // com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent, com.tencent.guild.aio.msglist.holder.component.a
    public void b1(int position, @NotNull final com.tencent.aio.data.msglist.a msgItem, @NotNull List<Object> payloads) {
        int ordinal;
        boolean z16;
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.b1(position, msgItem, payloads);
        if (msgItem instanceof GuildMsgItem) {
            final GuildMultiMsgManager a16 = GuildMultiMsgManager.INSTANCE.a();
            s.AioContextWrapper aioContextWrapper = new s.AioContextWrapper(null, 1, null);
            sendIntent(new s.GetAioContext(aioContextWrapper));
            GuildMsgItem guildMsgItem = (GuildMsgItem) msgItem;
            String str = guildMsgItem.getMsgRecord().channelId;
            Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.channelId");
            com.tencent.aio.api.runtime.a context = aioContextWrapper.getContext();
            if (context != null) {
                ordinal = com.tencent.guild.aio.util.ex.a.d(context);
            } else {
                ordinal = FromScene.DEFAULT.ordinal();
            }
            final GuildMultiMsgManager.d dVar = new GuildMultiMsgManager.d(str, ordinal);
            boolean i3 = a16.i(dVar);
            yr0.a.s(K1(), i3);
            CheckBox K1 = K1();
            if (i3) {
                z16 = a16.h(dVar, guildMsgItem);
            } else {
                z16 = false;
            }
            K1.setChecked(z16);
            K1().setButtonDrawable(R.drawable.guild_live_chat_checkbox_selector);
            K1().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guildlive.aio.msglist.holder.component.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GuildLiveCheckBoxComponent.H1(GuildLiveCheckBoxComponent.this, a16, dVar, msgItem, view);
                }
            });
            return;
        }
        K1().setVisibility(8);
    }

    @NotNull
    public final View getRoot() {
        return this.root;
    }

    @Override // com.tencent.guildlive.aio.msglist.holder.component.AbsGuildLiveComponent, com.tencent.mvi.mvvm.BaseVB
    public void handleUIState(@NotNull MviUIState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        super.handleUIState(state);
        if (state instanceof GuildMultiSelectModeChange) {
            yr0.a.s(K1(), ((GuildMultiSelectModeChange) state).getSelectMode());
        }
    }
}
