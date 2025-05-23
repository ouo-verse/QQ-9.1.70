package com.tencent.mobileqq.tianshu.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tianshu.TianshuConstants$RedDataChangeState;
import com.tencent.mobileqq.tianshu.bean.a;
import com.tencent.mobileqq.vas.VasPerfReportUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u0012\u0010\u0013B!\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u0012\u0010\u0015B\u0019\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\u0012\u0010\u0016R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\t\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/tianshu/event/TianshuRedDataChangeEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "Lcom/tencent/mobileqq/tianshu/bean/a;", "list", "Ljava/util/List;", VasPerfReportUtils.WHILE_GET_LIST, "()Ljava/util/List;", "Lcom/tencent/mobileqq/tianshu/TianshuConstants$RedDataChangeState;", "state", "Lcom/tencent/mobileqq/tianshu/TianshuConstants$RedDataChangeState;", "getState", "()Lcom/tencent/mobileqq/tianshu/TianshuConstants$RedDataChangeState;", "", "requestType", "I", "getRequestType", "()I", "<init>", "(Ljava/util/List;Lcom/tencent/mobileqq/tianshu/TianshuConstants$RedDataChangeState;I)V", "bean", "(Lcom/tencent/mobileqq/tianshu/bean/a;Lcom/tencent/mobileqq/tianshu/TianshuConstants$RedDataChangeState;I)V", "(Lcom/tencent/mobileqq/tianshu/bean/a;Lcom/tencent/mobileqq/tianshu/TianshuConstants$RedDataChangeState;)V", "tianshu-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class TianshuRedDataChangeEvent extends SimpleBaseEvent {
    static IPatchRedirector $redirector_;

    @NotNull
    private final List<a> list;
    private final int requestType;

    @NotNull
    private final TianshuConstants$RedDataChangeState state;

    public TianshuRedDataChangeEvent(@NotNull List<a> list, @NotNull TianshuConstants$RedDataChangeState state, int i3) {
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(state, "state");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, list, state, Integer.valueOf(i3));
            return;
        }
        this.list = list;
        this.state = state;
        this.requestType = i3;
    }

    @NotNull
    public final List<a> getList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.list;
    }

    public final int getRequestType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.requestType;
    }

    @NotNull
    public final TianshuConstants$RedDataChangeState getState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TianshuConstants$RedDataChangeState) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.state;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TianshuRedDataChangeEvent(@NotNull a bean, @NotNull TianshuConstants$RedDataChangeState state, int i3) {
        this(r1, state, i3);
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(bean, "bean");
        Intrinsics.checkNotNullParameter(state, "state");
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(bean);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, this, bean, state, Integer.valueOf(i3));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TianshuRedDataChangeEvent(@NotNull a bean, @NotNull TianshuConstants$RedDataChangeState state) {
        this(bean, state, 0);
        Intrinsics.checkNotNullParameter(bean, "bean");
        Intrinsics.checkNotNullParameter(state, "state");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, (Object) this, (Object) bean, (Object) state);
    }
}
