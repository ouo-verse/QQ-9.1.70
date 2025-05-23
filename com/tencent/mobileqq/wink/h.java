package com.tencent.mobileqq.wink;

import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/wink/h;", "Ljava/util/concurrent/Executor;", "Ljava/lang/Runnable;", "command", "", "execute", "", "d", "I", "getType", "()I", "type", "<init>", "(I)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class h implements Executor {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int type;

    public h(int i3) {
        this.type = i3;
    }

    @Override // java.util.concurrent.Executor
    public void execute(@Nullable Runnable command) {
        ThreadManagerV2.excute(command, this.type, null, false);
    }
}
