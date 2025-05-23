package com.tencent.mobileqq.guild.media.thirdapp.container.intent;

import androidx.annotation.Nullable;
import com.tencent.mvi.base.route.MsgIntent;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0016\u0018\u0000 \f2\u00020\u00012\u00020\u0002:\u0001\rB\u001b\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u00a2\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ContainerMsgIntent;", "Ljava/io/Serializable;", "Lcom/tencent/mvi/base/route/MsgIntent;", "", "needIPC", "Z", "getNeedIPC", "()Z", "needResult", "getNeedResult", "<init>", "(ZZ)V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public class ContainerMsgIntent implements Serializable, MsgIntent {
    private static final long serialVersionUID = 1891866368734007885L;
    private final boolean needIPC;
    private final boolean needResult;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ContainerMsgIntent() {
        this(r2, r2, 3, null);
        boolean z16 = false;
    }

    @Override // com.tencent.mvi.base.route.i
    @Nullable
    public /* bridge */ /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    public final boolean getNeedIPC() {
        return this.needIPC;
    }

    public final boolean getNeedResult() {
        return this.needResult;
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }

    public ContainerMsgIntent(boolean z16, boolean z17) {
        this.needIPC = z16;
        this.needResult = z17;
    }

    public /* synthetic */ ContainerMsgIntent(boolean z16, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z16, (i3 & 2) != 0 ? false : z17);
    }
}
