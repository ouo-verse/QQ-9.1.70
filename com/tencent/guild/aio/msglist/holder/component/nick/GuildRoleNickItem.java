package com.tencent.guild.aio.msglist.holder.component.nick;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00112\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u00a2\u0006\u0004\b!\u0010\"J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\bH\u0016R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001d\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/guild/aio/msglist/holder/component/nick/GuildRoleNickItem;", "Lcom/tencent/guild/aio/msglist/holder/component/nick/r;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "", "isRefresh", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "k", "", "o", "", "", "payloads", "a", "type", "f", "Landroid/content/Context;", "c", "Landroid/content/Context;", "l", "()Landroid/content/Context;", "context", "Landroid/widget/TextView;", "d", "Lkotlin/Lazy;", DomainData.DOMAIN_NAME, "()Landroid/widget/TextView;", "mIdentityItem", "e", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "curMsgItem", "<init>", "(Landroid/content/Context;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildRoleNickItem extends r {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mIdentityItem;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildMsgItem curMsgItem;

    public GuildRoleNickItem(@NotNull Context context) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        lazy = LazyKt__LazyJVMKt.lazy(new GuildRoleNickItem$mIdentityItem$2(this));
        this.mIdentityItem = lazy;
    }

    private final int k(GuildMsgItem msgItem, boolean isRefresh) {
        if (isRefresh) {
            int e16 = e(msgItem);
            msgItem.getPreParseInfo().l(Integer.valueOf(e16));
            return e16;
        }
        Integer nickColor = msgItem.getPreParseInfo().getNickColor();
        if (nickColor == null) {
            nickColor = Integer.valueOf(e(msgItem));
            msgItem.getPreParseInfo().l(nickColor);
        }
        return nickColor.intValue();
    }

    private final String m(GuildMsgItem msgItem, boolean isRefresh) {
        if (isRefresh) {
            String f16 = com.tencent.guild.aio.util.h.f112401a.f(msgItem, this.context);
            msgItem.getPreParseInfo().o(f16);
            return f16;
        }
        String role = msgItem.getPreParseInfo().getRole();
        if (role == null) {
            String f17 = com.tencent.guild.aio.util.h.f112401a.f(msgItem, this.context);
            msgItem.getPreParseInfo().o(f17);
            return f17;
        }
        return role;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView n() {
        return (TextView) this.mIdentityItem.getValue();
    }

    private final void o(GuildMsgItem msgItem, boolean isRefresh) {
        String m3 = m(msgItem, isRefresh);
        if (!StringUtil.isEmpty(m3)) {
            int k3 = k(msgItem, isRefresh);
            if (k3 != -1) {
                n().setText(m3);
                n().setVisibility(0);
                int i3 = k3 | ((int) 4278190080L);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColor(i3);
                gradientDrawable.setCornerRadius(ViewUtils.dpToPx(2.0f));
                n().setBackgroundDrawable(gradientDrawable);
                QLog.i("GuildRoleNickItem", 1, "[updateIdentityItem] thisId:" + System.identityHashCode(this) + " iconText: " + m3 + ", color: " + i3 + ", msgSeq: " + msgItem.getMsgSeq() + ", isRefresh\uff1a " + isRefresh + ", hashCode: " + n().hashCode());
                return;
            }
            h(new Function0<Unit>() { // from class: com.tencent.guild.aio.msglist.holder.component.nick.GuildRoleNickItem$updateIdentityItem$1
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
                    TextView n3;
                    n3 = GuildRoleNickItem.this.n();
                    n3.setVisibility(8);
                }
            });
            return;
        }
        h(new Function0<Unit>() { // from class: com.tencent.guild.aio.msglist.holder.component.nick.GuildRoleNickItem$updateIdentityItem$2
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
                TextView n3;
                n3 = GuildRoleNickItem.this.n();
                n3.setVisibility(8);
            }
        });
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.nick.a
    public void a(@NotNull GuildMsgItem msgItem, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        this.curMsgItem = msgItem;
        o(msgItem, false);
    }

    @Override // com.tencent.guild.aio.msglist.holder.component.nick.r
    public void f(@NotNull GuildMsgItem msgItem, int type) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (type == 2) {
            o(msgItem, true);
        }
    }

    @NotNull
    /* renamed from: l, reason: from getter */
    public final Context getContext() {
        return this.context;
    }
}
