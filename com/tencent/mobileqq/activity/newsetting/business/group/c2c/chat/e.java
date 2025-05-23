package com.tencent.mobileqq.activity.newsetting.business.group.c2c.chat;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.x;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\bR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/activity/newsetting/business/group/c2c/chat/e;", "Lcom/tencent/mobileqq/activity/newsetting/custom/group/a;", "Lcom/tencent/mobileqq/widget/listitem/Group;", "c", "Lcom/tencent/mobileqq/activity/newsetting/business/group/c2c/chat/j;", "j", "Lcom/tencent/mobileqq/activity/newsetting/business/group/c2c/chat/k;", "switchLayoutChgListener", "", "l", "k", "e", "Lcom/tencent/mobileqq/activity/newsetting/business/group/c2c/chat/j;", "friendTimeGroupConfig", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class e extends com.tencent.mobileqq.activity.newsetting.custom.group.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private j friendTimeGroupConfig;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    @Override // com.tencent.mobileqq.activity.newsetting.custom.group.a
    @NotNull
    protected Group c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Group) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        String g16 = g(R.string.f207065_0);
        Intrinsics.checkNotNullExpressionValue(g16, "getString(R.string.qq_zplan_friend_time_switch)");
        this.friendTimeGroupConfig = new j(new x.b.d(g16), new x.c.f(false, null), f());
        j jVar = this.friendTimeGroupConfig;
        Intrinsics.checkNotNull(jVar);
        return new Group(jVar);
    }

    @Nullable
    public final j j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (j) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.friendTimeGroupConfig;
    }

    public final void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        j jVar = this.friendTimeGroupConfig;
        if (jVar != null) {
            jVar.o0();
        }
    }

    public final void l(@NotNull k switchLayoutChgListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) switchLayoutChgListener);
            return;
        }
        Intrinsics.checkNotNullParameter(switchLayoutChgListener, "switchLayoutChgListener");
        j jVar = this.friendTimeGroupConfig;
        if (jVar != null) {
            jVar.p0(switchLayoutChgListener);
        }
    }
}
