package fl1;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.base.GuildTransBottomSheetDialogFragment;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.ShowInputComponentArgs;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionType;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.helper.jump.JoinGuildChannelFrag;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import yl1.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Lfl1/i;", "Lfl1/a;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionType;", "b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;", "inputArgs", "", "c", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/handler/a;", "inputContext", "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/handler/a;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class i extends a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@NotNull com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.handler.a inputContext) {
        super(inputContext);
        Intrinsics.checkNotNullParameter(inputContext, "inputContext");
    }

    @Override // fl1.a
    @NotNull
    public SpeakPermissionType b() {
        return SpeakPermissionType.PERMISSION_TYPE_VISITOR_NEED_JOIN;
    }

    @Override // fl1.a
    public void c(@NotNull ShowInputComponentArgs inputArgs) {
        Intrinsics.checkNotNullParameter(inputArgs, "inputArgs");
        JumpGuildParam.JoinInfoParam joinInfoParam = null;
        Object I2 = getInputContext().getDelegate().I2("message_get_join_guild_sign", null);
        if (I2 instanceof JumpGuildParam.JoinInfoParam) {
            joinInfoParam = (JumpGuildParam.JoinInfoParam) I2;
        }
        n.z(0, R.string.f144500oy);
        if (joinInfoParam != null) {
            JumpGuildParam jumpGuildParam = new JumpGuildParam(getInputContext().getGuildId(), getInputContext().getChannelId(), joinInfoParam);
            GuildTransBottomSheetDialogFragment.Companion companion = GuildTransBottomSheetDialogFragment.INSTANCE;
            Context context = getInputContext().getContext();
            JoinGuildChannelFrag.Companion companion2 = JoinGuildChannelFrag.INSTANCE;
            String qqStr = HardCodeUtil.qqStr(R.string.f147280wg);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(com.tencent.mobile\u2026_unlock_interactive_tips)");
            companion.a(context, companion2.a(jumpGuildParam, qqStr, false, false), JoinGuildChannelFrag.class, "Guild.jump.JoinGuildChannelFrag");
        }
    }
}
