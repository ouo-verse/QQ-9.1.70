package fl1;

import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.ShowInputComponentArgs;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionType;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.utils.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"Lfl1/e;", "Lfl1/a;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionType;", "b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;", "inputArgs", "", "c", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/handler/a;", "inputContext", "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/handler/a;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class e extends a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.handler.a inputContext) {
        super(inputContext);
        Intrinsics.checkNotNullParameter(inputContext, "inputContext");
    }

    @Override // fl1.a
    @NotNull
    public SpeakPermissionType b() {
        return SpeakPermissionType.PERMISSION_TYPE_NORMAL;
    }

    @Override // fl1.a
    public void c(@NotNull ShowInputComponentArgs inputArgs) {
        Intrinsics.checkNotNullParameter(inputArgs, "inputArgs");
        getInputContext().getDelegate().lh("message_check_input_speak_permission_succ", new a.ShowInputComponentMessage(inputArgs));
    }
}
