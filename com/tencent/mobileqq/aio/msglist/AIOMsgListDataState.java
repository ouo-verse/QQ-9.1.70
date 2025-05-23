package com.tencent.mobileqq.aio.msglist;

import android.os.Bundle;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.state.MsgListState;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0018\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0017\u0010\n\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/AIOMsgListDataState;", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/state/MsgListState;", "", "index", "J", "getIndex", "()J", "setIndex", "(J)V", "", "forceUpdate", "Z", "getForceUpdate", "()Z", "Lcom/tencent/aio/data/msglist/a;", "latestAIOMsg", "Lcom/tencent/aio/data/msglist/a;", "getLatestAIOMsg", "()Lcom/tencent/aio/data/msglist/a;", "", "curUpdateType", "I", "getCurUpdateType", "()I", "", "list", "Landroid/os/Bundle;", "extra", "<init>", "(JLjava/util/Collection;ZLcom/tencent/aio/data/msglist/a;ILandroid/os/Bundle;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class AIOMsgListDataState extends MsgListState {
    static IPatchRedirector $redirector_;
    private final int curUpdateType;
    private final boolean forceUpdate;
    private long index;

    @Nullable
    private final com.tencent.aio.data.msglist.a latestAIOMsg;

    public AIOMsgListDataState() {
        this(0L, null, false, null, 0, null, 63, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return;
        }
        iPatchRedirector.redirect((short) 8, (Object) this);
    }

    @Override // com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.state.MsgListState, com.tencent.mvi.base.route.i
    @androidx.annotation.Nullable
    public /* bridge */ /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    public final int getCurUpdateType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.curUpdateType;
    }

    public final boolean getForceUpdate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.forceUpdate;
    }

    public final long getIndex() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return this.index;
    }

    @Nullable
    public final com.tencent.aio.data.msglist.a getLatestAIOMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.aio.data.msglist.a) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.latestAIOMsg;
    }

    public final void setIndex(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
        } else {
            this.index = j3;
        }
    }

    public /* synthetic */ AIOMsgListDataState(long j3, Collection collection, boolean z16, com.tencent.aio.data.msglist.a aVar, int i3, Bundle bundle, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? -1L : j3, (i16 & 2) != 0 ? new ArrayList() : collection, (i16 & 4) != 0 ? false : z16, (i16 & 8) != 0 ? null : aVar, (i16 & 16) != 0 ? 3 : i3, (i16 & 32) != 0 ? null : bundle);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), collection, Boolean.valueOf(z16), aVar, Integer.valueOf(i3), bundle, Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOMsgListDataState(long j3, @NotNull Collection<? extends com.tencent.aio.data.msglist.a> list, boolean z16, @Nullable com.tencent.aio.data.msglist.a aVar, int i3, @Nullable Bundle bundle) {
        super(j3, list, i3, bundle);
        Intrinsics.checkNotNullParameter(list, "list");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), list, Boolean.valueOf(z16), aVar, Integer.valueOf(i3), bundle);
            return;
        }
        this.index = j3;
        this.forceUpdate = z16;
        this.latestAIOMsg = aVar;
        this.curUpdateType = i3;
    }
}
