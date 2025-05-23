package com.tencent.mobileqq.zootopia.ipc;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\b\u0010\tR\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ipc/an;", "", "", "modId", "", "a", "onModExit", "", "isModRunning", "(I)Ljava/lang/Boolean;", "b", "I", "mRunningModId", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class an implements d {

    /* renamed from: a, reason: collision with root package name */
    public static final an f328351a = new an();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int mRunningModId;

    an() {
    }

    public void a(int modId) {
        QLog.i("ModRunningManager_", 1, "modLoadFinish modId:" + modId);
        mRunningModId = modId;
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.d
    public Boolean isModRunning(int modId) {
        QLog.i("ModRunningManager_", 1, "isModRunning modId:" + modId + ", mRunningModId:" + mRunningModId);
        return Boolean.valueOf(mRunningModId == modId);
    }

    @Override // com.tencent.mobileqq.zootopia.ipc.d
    public void onModExit(int modId) {
        QLog.i("ModRunningManager_", 1, "onModExit modId:" + modId + ", mRunningModId:" + mRunningModId);
        if (modId != mRunningModId) {
            return;
        }
        mRunningModId = 0;
    }
}
