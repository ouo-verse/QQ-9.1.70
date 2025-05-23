package com.tencent.localedit.fakenative.resource;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\b\u0010\tR \u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/localedit/fakenative/resource/d;", "Task", "", "Ljava/util/Queue;", "a", "Ljava/util/Queue;", "()Ljava/util/Queue;", "taskQueue", "<init>", "()V", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public abstract class d<Task> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Queue<Task> taskQueue = new ConcurrentLinkedQueue();

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Queue<Task> a() {
        return this.taskQueue;
    }
}
