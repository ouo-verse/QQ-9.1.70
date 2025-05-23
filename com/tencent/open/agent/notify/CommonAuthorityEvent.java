package com.tencent.open.agent.notify;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.open.model.AppInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/open/agent/notify/CommonAuthorityEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "infos", "", "Lcom/tencent/open/model/AppInfo;", "(Ljava/util/List;)V", "getInfos", "()Ljava/util/List;", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes22.dex */
public final class CommonAuthorityEvent extends SimpleBaseEvent {

    @NotNull
    private final List<AppInfo> infos;

    /* JADX WARN: Multi-variable type inference failed */
    public CommonAuthorityEvent(@NotNull List<? extends AppInfo> infos) {
        Intrinsics.checkNotNullParameter(infos, "infos");
        this.infos = infos;
    }

    @NotNull
    public final List<AppInfo> getInfos() {
        return this.infos;
    }
}
