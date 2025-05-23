package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data;

import android.os.Bundle;
import com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.data.IMsgListRepository;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B5\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u0019\u0010\u001aR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0010\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\n\u0010\u0011R\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0016\u001a\u0004\b\u0004\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/l;", "", "", "Lcom/tencent/aio/data/msglist/a;", "a", "Ljava/util/List;", "c", "()Ljava/util/List;", "list", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/IMsgListRepository$MsgListRepoOpType;", "b", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/IMsgListRepository$MsgListRepoOpType;", "d", "()Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/IMsgListRepository$MsgListRepoOpType;", "opType", "", "Ljava/lang/Long;", "()Ljava/lang/Long;", "getFocusIndex$annotations", "()V", "focusIndex", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "()Landroid/os/Bundle;", "extra", "<init>", "(Ljava/util/List;Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/data/IMsgListRepository$MsgListRepoOpType;Ljava/lang/Long;Landroid/os/Bundle;)V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class l {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<com.tencent.aio.data.msglist.a> list;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IMsgListRepository.MsgListRepoOpType opType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Long focusIndex;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Bundle extra;

    public l(@NotNull List<? extends com.tencent.aio.data.msglist.a> list, @NotNull IMsgListRepository.MsgListRepoOpType opType, @Nullable Long l3, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(opType, "opType");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, list, opType, l3, bundle);
            return;
        }
        this.list = list;
        this.opType = opType;
        this.focusIndex = l3;
        this.extra = bundle;
    }

    @Nullable
    public final Bundle a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bundle) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.extra;
    }

    @Nullable
    public final Long b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Long) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.focusIndex;
    }

    @NotNull
    public final List<com.tencent.aio.data.msglist.a> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (List) iPatchRedirector.redirect((short) 1, (Object) this);
        }
        return this.list;
    }

    @NotNull
    public final IMsgListRepository.MsgListRepoOpType d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IMsgListRepository.MsgListRepoOpType) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.opType;
    }

    public /* synthetic */ l(List list, IMsgListRepository.MsgListRepoOpType msgListRepoOpType, Long l3, Bundle bundle, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, msgListRepoOpType, (i3 & 4) != 0 ? null : l3, (i3 & 8) == 0 ? bundle : null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, this, list, msgListRepoOpType, l3, bundle, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
