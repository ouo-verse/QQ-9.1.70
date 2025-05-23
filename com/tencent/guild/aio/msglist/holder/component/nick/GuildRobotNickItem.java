package com.tencent.guild.aio.msglist.holder.component.nick;

import android.content.Context;
import android.widget.ImageView;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001a2\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0014\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/nick/GuildRobotNickItem;", "Lcom/tencent/guild/aio/msglist/holder/component/nick/r;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "", "", "payloads", "", "a", "Landroid/content/Context;", "c", "Landroid/content/Context;", "p", "()Landroid/content/Context;", "context", "Landroid/widget/ImageView;", "d", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Landroid/widget/ImageView;", "tvRobot", "e", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "curMsgItem", "<init>", "(Landroid/content/Context;)V", "f", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildRobotNickItem extends r {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: g, reason: collision with root package name */
    private static final int f111596g;

    /* renamed from: h, reason: collision with root package name */
    private static final int f111597h;

    /* renamed from: i, reason: collision with root package name */
    private static final int f111598i;

    /* renamed from: j, reason: collision with root package name */
    private static final int f111599j;

    /* renamed from: k, reason: collision with root package name */
    private static final int f111600k;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy tvRobot;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildMsgItem curMsgItem;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0017\u0010\u000b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u0010\u001a\u00020\u000f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/nick/GuildRobotNickItem$a;", "", "", "ROBOT_IDENTITY_LEFT_MARGIN_PX", "I", "b", "()I", "ROBOT_IDENTITY_HEIGHT_PX", "a", "ROBOT_IDENTITY_WIDTH_PX", "c", "ROBOT_PADDING_LEFT_PX", "d", "ROBOT_PADDING_RIGHT_PX", "e", "", "APPID_MSG_FROM_ROBOT", "J", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guild.aio.msglist.holder.component.nick.GuildRobotNickItem$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return GuildRobotNickItem.f111597h;
        }

        public final int b() {
            return GuildRobotNickItem.f111596g;
        }

        public final int c() {
            return GuildRobotNickItem.f111598i;
        }

        public final int d() {
            return GuildRobotNickItem.f111599j;
        }

        public final int e() {
            return GuildRobotNickItem.f111600k;
        }

        Companion() {
        }
    }

    static {
        wn0.a aVar = wn0.a.f445842a;
        f111596g = aVar.b(6);
        f111597h = aVar.b(13);
        f111598i = aVar.b(13);
        f111599j = aVar.a(4.0f);
        f111600k = aVar.a(4.0f);
    }

    public GuildRobotNickItem(@NotNull Context context) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        lazy = LazyKt__LazyJVMKt.lazy(new GuildRobotNickItem$tvRobot$2(this));
        this.tvRobot = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImageView q() {
        return (ImageView) this.tvRobot.getValue();
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.nick.a
    public void a(@NotNull GuildMsgItem msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        this.curMsgItem = msgItem;
        if (msgItem.getMsgRecord().fromAppid == GuildMsgItem.ROBOT_MSG_FLAG) {
            q().setVisibility(0);
        } else {
            h(new Function0<Unit>() { // from class: com.tencent.guild.aio.msglist.holder.component.nick.GuildRobotNickItem$bindView$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ImageView q16;
                    q16 = GuildRobotNickItem.this.q();
                    q16.setVisibility(8);
                }
            });
        }
    }

    @NotNull
    /* renamed from: p, reason: from getter */
    public final Context getContext() {
        return this.context;
    }
}
