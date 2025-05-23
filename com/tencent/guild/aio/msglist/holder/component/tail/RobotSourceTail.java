package com.tencent.guild.aio.msglist.holder.component.tail;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.robot.api.IRobotDaTongApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0016R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0016\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001a\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0013\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/tail/RobotSourceTail;", "Lcom/tencent/guild/aio/msglist/holder/component/tail/a;", "Lcom/tencent/aio/data/msglist/a;", "", "k", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msg", "", "l", "", "d", "b", "Landroid/widget/LinearLayout;", "j", "c", "Landroid/content/Context;", "a", "Landroid/content/Context;", "mContext", "Lkotlin/Lazy;", h.F, "()Landroid/widget/LinearLayout;", "mTailLayout", "Landroid/widget/TextView;", "i", "()Landroid/widget/TextView;", "mTextView", "<init>", "(Landroid/content/Context;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class RobotSourceTail implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context mContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mTailLayout;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mTextView;

    public RobotSourceTail(@NotNull Context mContext) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.guild.aio.msglist.holder.component.tail.RobotSourceTail$mTailLayout$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LinearLayout invoke() {
                Context context;
                context = RobotSourceTail.this.mContext;
                View inflate = LayoutInflater.from(context).inflate(R.layout.ee8, (ViewGroup) null);
                Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.LinearLayout");
                return (LinearLayout) inflate;
            }
        });
        this.mTailLayout = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<TextView>() { // from class: com.tencent.guild.aio.msglist.holder.component.tail.RobotSourceTail$mTextView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final TextView invoke() {
                LinearLayout h16;
                h16 = RobotSourceTail.this.h();
                View findViewById = h16.findViewById(R.id.f774844h);
                Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
                return (TextView) findViewById;
            }
        });
        this.mTextView = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinearLayout h() {
        return (LinearLayout) this.mTailLayout.getValue();
    }

    private final TextView i() {
        return (TextView) this.mTextView.getValue();
    }

    private final boolean k(com.tencent.aio.data.msglist.a aVar) {
        GuildMsgItem guildMsgItem;
        if (aVar instanceof GuildMsgItem) {
            guildMsgItem = (GuildMsgItem) aVar;
        } else {
            guildMsgItem = null;
        }
        if (guildMsgItem == null || !com.tencent.guild.api.data.msglist.a.c(guildMsgItem)) {
            return false;
        }
        String extInfoFromExtStr$default = GuildMsgItem.getExtInfoFromExtStr$default(guildMsgItem, IGuildMessageUtilsApi.ROBOT_MSG_TYPE, null, 2, null);
        String extInfoFromExtStr$default2 = GuildMsgItem.getExtInfoFromExtStr$default(guildMsgItem, IGuildMessageUtilsApi.ROBOT_MSG_SRC_GUILD_ID, null, 2, null);
        String extInfoFromExtStr$default3 = GuildMsgItem.getExtInfoFromExtStr$default(guildMsgItem, IGuildMessageUtilsApi.ROBOT_MSG_SRC_GUILD_NAME, null, 2, null);
        if (TextUtils.isEmpty(extInfoFromExtStr$default) || TextUtils.isEmpty(extInfoFromExtStr$default3) || TextUtils.isEmpty(extInfoFromExtStr$default2)) {
            return false;
        }
        Intrinsics.checkNotNull(extInfoFromExtStr$default2);
        if (Long.parseLong(extInfoFromExtStr$default2) == 0) {
            return false;
        }
        return true;
    }

    private final void l(GuildMsgItem msg2) {
        String extInfoFromExtStr$default = GuildMsgItem.getExtInfoFromExtStr$default(msg2, IGuildMessageUtilsApi.ROBOT_MSG_SRC_GUILD_ID, null, 2, null);
        if (((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).isGuest(extInfoFromExtStr$default)) {
            QQToast.makeText(this.mContext, 1, "\u4f60\u5df2\u4e0d\u5728\u8be5\u9891\u9053\u5185", 0).show();
        } else {
            ((IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class)).jumpGuildOnFullStandalone(this.mContext, new JumpGuildParam(extInfoFromExtStr$default, ""));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(RobotSourceTail this$0, com.tencent.aio.data.msglist.a msg2, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        this$0.l((GuildMsgItem) msg2);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.tail.a
    public boolean b(@NotNull com.tencent.aio.data.msglist.a msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        return k(msg2);
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.tail.a
    public void c(@NotNull final com.tencent.aio.data.msglist.a msg2) {
        GuildMsgItem guildMsgItem;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2 instanceof GuildMsgItem) {
            guildMsgItem = (GuildMsgItem) msg2;
        } else {
            guildMsgItem = null;
        }
        if (guildMsgItem != null) {
            GuildMsgItem guildMsgItem2 = (GuildMsgItem) msg2;
            String extInfoFromExtStr$default = GuildMsgItem.getExtInfoFromExtStr$default(guildMsgItem2, IGuildMessageUtilsApi.ROBOT_MSG_SRC_GUILD_NAME, null, 2, null);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = this.mContext.getString(R.string.f153641cn);
            Intrinsics.checkNotNullExpressionValue(string, "mContext.getString(R.str\u2026ect_message_robot_source)");
            String format = String.format(string, Arrays.copyOf(new Object[]{extInfoFromExtStr$default}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            if (h().getLayoutParams() == null) {
                h().setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
                ViewGroup.LayoutParams layoutParams = h().getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                ((FrameLayout.LayoutParams) layoutParams).topMargin = ViewUtils.dpToPx(7.0f);
            } else {
                ViewGroup.LayoutParams layoutParams2 = h().getLayoutParams();
                Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                ((FrameLayout.LayoutParams) layoutParams2).topMargin = ViewUtils.dpToPx(7.0f);
            }
            i().setText(format);
            h().setVisibility(0);
            h().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.guild.aio.msglist.holder.component.tail.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RobotSourceTail.m(RobotSourceTail.this, msg2, view);
                }
            });
            ((IRobotDaTongApi) QRoute.api(IRobotDaTongApi.class)).setAndReportBotSourceTail(h(), GuildMsgItem.getExtInfoFromExtStr$default(guildMsgItem, IGuildMessageUtilsApi.ROBOT_MSG_SRC_GUILD_ID, null, 2, null), GuildMsgItem.getExtInfoFromExtStr$default(guildMsgItem, IGuildMessageUtilsApi.ROBOT_MSG_SRC_GUILD_NAME, null, 2, null), guildMsgItem2.getMsgRecord().senderUid, guildMsgItem2.getMsgRecord().channelId);
        }
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.tail.a
    public int d() {
        return 2;
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.tail.a
    @NotNull
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public LinearLayout a() {
        return h();
    }
}
