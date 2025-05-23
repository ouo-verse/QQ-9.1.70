package com.tencent.mobileqq.aio.msglist.holder.component.nick;

import com.tencent.mobileqq.aio.msglist.holder.AIOMsgItemUIState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.GroupAnonymousInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/nick/AIONickState$UpdateAnonymousTagColor", "Lcom/tencent/mobileqq/aio/msglist/holder/AIOMsgItemUIState;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupAnonymousInfo;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupAnonymousInfo;", "a", "()Lcom/tencent/qqnt/kernel/nativeinterface/GroupAnonymousInfo;", "info", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/GroupAnonymousInfo;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final /* data */ class AIONickState$UpdateAnonymousTagColor extends AIOMsgItemUIState {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final GroupAnonymousInfo info;

    public AIONickState$UpdateAnonymousTagColor(@Nullable GroupAnonymousInfo groupAnonymousInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) groupAnonymousInfo);
        } else {
            this.info = groupAnonymousInfo;
        }
    }

    @Nullable
    public final GroupAnonymousInfo a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (GroupAnonymousInfo) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.info;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if ((other instanceof AIONickState$UpdateAnonymousTagColor) && Intrinsics.areEqual(this.info, ((AIONickState$UpdateAnonymousTagColor) other).info)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        GroupAnonymousInfo groupAnonymousInfo = this.info;
        if (groupAnonymousInfo == null) {
            return 0;
        }
        return groupAnonymousInfo.hashCode();
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "UpdateAnonymousTagColor(info=" + this.info + ")";
    }
}
