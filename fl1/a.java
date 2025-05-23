package fl1;

import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.ShowInputComponentArgs;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\b\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lfl1/a;", "", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionType;", "b", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/input/i;", "inputArgs", "", "c", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/handler/a;", "a", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/handler/a;", "()Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/handler/a;", "inputContext", "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/handler/a;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.handler.a inputContext;

    public a(@NotNull com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.handler.a inputContext) {
        Intrinsics.checkNotNullParameter(inputContext, "inputContext");
        this.inputContext = inputContext;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.handler.a getInputContext() {
        return this.inputContext;
    }

    @NotNull
    public abstract SpeakPermissionType b();

    public abstract void c(@NotNull ShowInputComponentArgs inputArgs);
}
