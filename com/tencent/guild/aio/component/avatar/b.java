package com.tencent.guild.aio.component.avatar;

import com.tencent.aio.data.AIOContact;
import com.tencent.guild.aio.component.avatar.GuildAioUserAvatarUIState;
import com.tencent.guild.aio.component.avatar.a;
import com.tencent.mobileqq.guild.message.api.IDirectMessageNode;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/guild/aio/component/avatar/b;", "Lcom/tencent/aio/base/mvvm/b;", "Lcom/tencent/guild/aio/component/avatar/a;", "Lcom/tencent/guild/aio/component/avatar/GuildAioUserAvatarUIState;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "l", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", "intent", "j", "Lcom/tencent/aio/data/AIOContact;", "d", "Lcom/tencent/aio/data/AIOContact;", "mContact", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b extends com.tencent.aio.base.mvvm.b<a, GuildAioUserAvatarUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private AIOContact mContact;

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean l() {
        return com.tencent.guild.aio.util.ex.a.h((com.tencent.aio.api.runtime.a) getMContext());
    }

    private final void m() {
        AIOContact aIOContact = this.mContact;
        AIOContact aIOContact2 = null;
        if (aIOContact == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContact");
            aIOContact = null;
        }
        String f16 = aIOContact.f();
        if (l()) {
            IDirectMessageNode iDirectMessageNode = (IDirectMessageNode) QRoute.api(IDirectMessageNode.class);
            AIOContact aIOContact3 = this.mContact;
            if (aIOContact3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContact");
            } else {
                aIOContact2 = aIOContact3;
            }
            f16 = iDirectMessageNode.getSrcGuildId(aIOContact2.j());
            if (f16 == null) {
                f16 = "0";
            }
        }
        updateUI(new GuildAioUserAvatarUIState.UpdateAvatarState(f16));
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.C1180a) {
            m();
        }
    }

    @Override // com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        this.mContact = context.g().r().c();
    }
}
