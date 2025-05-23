package com.tencent.sqshow.zootopia.nativeui.ue;

import android.os.Handler;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.nativeui.ue.n;
import com.tencent.zplan.luabridge.a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import m94.DressCallbackData;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\"\u0010#J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\fJ\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\fJ\u0014\u0010\u0012\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0019R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/ue/n;", "", "", "from", "", "success", "Lcom/tencent/sqshow/zootopia/nativeui/ue/k;", "task", "result", "", tl.h.F, "g", "Landroidx/lifecycle/LiveData;", "f", "Lm94/c;", "e", "", "selfDressId", "i", "c", "Ljava/util/LinkedList;", "b", "Ljava/util/LinkedList;", "mPendingTask", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mCallingLock", "Landroidx/lifecycle/MutableLiveData;", "d", "Landroidx/lifecycle/MutableLiveData;", "mHasTaskRunning", "mRenderingDressIdList", "Lcom/tencent/sqshow/zootopia/nativeui/ue/k;", "mRunningTask", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public static final n f371383a = new n();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final LinkedList<ChangeDressTask> mPendingTask = new LinkedList<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final AtomicBoolean mCallingLock = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final MutableLiveData<Boolean> mHasTaskRunning = new MutableLiveData<>();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final MutableLiveData<DressCallbackData> mRenderingDressIdList = new MutableLiveData<>();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static ChangeDressTask mRunningTask;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/ue/n$a", "Lcom/tencent/zplan/luabridge/a$b;", "", "success", "", "result", "", "onLuaResult", "onExecuteLua", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements a.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f371389d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Ref.LongRef f371390e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ChangeDressTask f371391f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f371392h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ WeakReference<ChangeDressTask> f371393i;

        a(long j3, Ref.LongRef longRef, ChangeDressTask changeDressTask, AtomicBoolean atomicBoolean, WeakReference<ChangeDressTask> weakReference) {
            this.f371389d = j3;
            this.f371390e = longRef;
            this.f371391f = changeDressTask;
            this.f371392h = atomicBoolean;
            this.f371393i = weakReference;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static final void b(WeakReference taskRef, boolean z16, String str) {
            Intrinsics.checkNotNullParameter(taskRef, "$taskRef");
            ChangeDressTask changeDressTask = (ChangeDressTask) taskRef.get();
            if (changeDressTask == null) {
                QLog.e("ChangeDressTaskManager", 1, "changeAvatarDress END. task already release!");
                return;
            }
            n.f371383a.h("normal exit, success:" + z16, z16, changeDressTask, str);
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onExecuteLua() {
            this.f371390e.element = System.currentTimeMillis();
            a.b.C10064a.a(this);
        }

        @Override // com.tencent.zplan.luabridge.a.b
        public void onLuaResult(final boolean success, final String result) {
            long currentTimeMillis = System.currentTimeMillis();
            long j3 = this.f371389d;
            QLog.i("ChangeDressTaskManager", 1, "changeAvatarDress total:" + (currentTimeMillis - j3) + "ms, onExecute:" + (this.f371390e.element - j3) + "ms");
            QLog.i("ChangeDressTaskManager", 1, "changeAvatarDress END. success:" + success + ", result:" + result + ", dressIdList:" + this.f371391f.d());
            if (this.f371392h.get()) {
                return;
            }
            this.f371392h.set(true);
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final WeakReference<ChangeDressTask> weakReference = this.f371393i;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.ue.m
                @Override // java.lang.Runnable
                public final void run() {
                    n.a.b(WeakReference.this, success, result);
                }
            });
        }
    }

    n() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(AtomicBoolean runningLock, ChangeDressTask task) {
        Intrinsics.checkNotNullParameter(runningLock, "$runningLock");
        Intrinsics.checkNotNullParameter(task, "$task");
        if (runningLock.get()) {
            return;
        }
        runningLock.set(true);
        f371383a.h("time out", false, task, null);
    }

    private final void g(ChangeDressTask task) {
        while (true) {
            LinkedList<ChangeDressTask> linkedList = mPendingTask;
            if (linkedList.size() > 0) {
                ChangeDressTask pollLast = linkedList.pollLast();
                QLog.w("ChangeDressTaskManager", 1, "task:" + (pollLast != null ? pollLast.getFrom() : null) + " give up!");
            } else {
                linkedList.addFirst(task);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(String from, boolean success, ChangeDressTask task, String result) {
        QLog.i("ChangeDressTaskManager", 1, "onSingleTaskEnd from:" + from + ", task:" + task.getFrom());
        if (success) {
            MutableLiveData<DressCallbackData> mutableLiveData = mRenderingDressIdList;
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(task.d());
            mutableLiveData.setValue(new DressCallbackData(arrayList, result, task.getClickedItemParam()));
        }
        a.b cb5 = task.getCb();
        if (cb5 != null) {
            cb5.onLuaResult(true, "");
        }
        mCallingLock.set(false);
        mRunningTask = null;
        ChangeDressTask pollLast = mPendingTask.pollLast();
        if (pollLast == null) {
            mHasTaskRunning.setValue(Boolean.FALSE);
        } else {
            c(pollLast);
        }
    }

    public final LiveData<DressCallbackData> e() {
        return mRenderingDressIdList;
    }

    public final LiveData<Boolean> f() {
        return mHasTaskRunning;
    }

    public final void i(List<String> selfDressId) {
        Intrinsics.checkNotNullParameter(selfDressId, "selfDressId");
        mRenderingDressIdList.postValue(new DressCallbackData(selfDressId, "", null, 4, null));
    }

    public final void c(final ChangeDressTask task) {
        Intrinsics.checkNotNullParameter(task, "task");
        AtomicBoolean atomicBoolean = mCallingLock;
        if (atomicBoolean.get()) {
            g(task);
            return;
        }
        atomicBoolean.set(true);
        mHasTaskRunning.setValue(Boolean.TRUE);
        long currentTimeMillis = System.currentTimeMillis();
        Ref.LongRef longRef = new Ref.LongRef();
        final AtomicBoolean atomicBoolean2 = new AtomicBoolean(false);
        mRunningTask = task;
        a aVar = new a(currentTimeMillis, longRef, task, atomicBoolean2, new WeakReference(task));
        b94.a engineApi = task.getEngineApi();
        if (engineApi != null) {
            engineApi.d(task.getFrom(), task.getAvatarCharacter(), task.getClickedItemParam(), null, aVar, task.getReportSpan());
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.sqshow.zootopia.nativeui.ue.l
            @Override // java.lang.Runnable
            public final void run() {
                n.d(atomicBoolean2, task);
            }
        }, 5000L);
    }
}
