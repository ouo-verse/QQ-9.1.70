package com.tencent.rdelivery.dependencyimpl;

import com.tencent.raft.standard.task.IRTask;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
/* loaded from: classes25.dex */
public final /* synthetic */ class b {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f364233a;

    static {
        int[] iArr = new int[IRTask.TaskType.values().length];
        f364233a = iArr;
        iArr[IRTask.TaskType.SIMPLE_TASK.ordinal()] = 1;
        iArr[IRTask.TaskType.NETWORK_TASK.ordinal()] = 2;
        iArr[IRTask.TaskType.IO_TASK.ordinal()] = 3;
    }
}
