package com.tencent.qqnt.troopmemberlist.merge;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troopmemberlist.TroopMemberListRepo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006*\u0001#\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0006\u0010\n\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0095\u0001\u0010\u001e\u001a\u0082\u0001\u0012\u0004\u0012\u00020\u0004\u00126\u00124\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00190\u0018j\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e0\u0019j\b\u0012\u0004\u0012\u00020\u000e`\u001b`\u001a0\u0018j@\u0012\u0004\u0012\u00020\u0004\u00126\u00124\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00190\u0018j\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000e0\u0019j\b\u0012\u0004\u0012\u00020\u000e`\u001b`\u001a`\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR$\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\b0\u001fj\b\u0012\u0004\u0012\u00020\b` 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010!R\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/qqnt/troopmemberlist/merge/c;", "", "", "i", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "troopUin", "", "f", "g", "from", "", h.F, "Lcom/tencent/qqnt/troopmemberlist/merge/b;", "task", "e", "Lcom/tencent/qqnt/troopmemberlist/merge/a;", "b", "Lcom/tencent/qqnt/troopmemberlist/merge/a;", "requestConfig", "c", "Ljava/lang/Object;", "mergeRequestLock", "Ljava/util/HashMap;", "Ljava/util/ArrayList;", "Lkotlin/collections/HashMap;", "Lkotlin/collections/ArrayList;", "d", "Ljava/util/HashMap;", "waitingTaskMap", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "delayedTaskKeySet", "com/tencent/qqnt/troopmemberlist/merge/c$a", "Lcom/tencent/qqnt/troopmemberlist/merge/c$a;", "handler", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f362920a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static com.tencent.qqnt.troopmemberlist.merge.a requestConfig;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Object mergeRequestLock;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<Integer, HashMap<Long, ArrayList<b>>> waitingTaskMap;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashSet<String> delayedTaskKeySet;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final a handler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/troopmemberlist/merge/c$a", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a extends Handler {
        static IPatchRedirector $redirector_;

        a(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg2) {
            ArrayList<b> arrayList;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) msg2);
                return;
            }
            Intrinsics.checkNotNullParameter(msg2, "msg");
            int i3 = msg2.what;
            Object obj = msg2.obj;
            int i16 = msg2.arg1;
            if (QLog.isDebugVersion()) {
                QLog.d("TroopMemberRequestMerge", 4, "[handleMessage] taskId:" + i3 + ", troopUin:" + obj + ", mergeMills:" + i16);
            }
            if (obj instanceof Long) {
                synchronized (c.mergeRequestLock) {
                    HashMap hashMap = (HashMap) c.waitingTaskMap.get(Integer.valueOf(i3));
                    if (hashMap != null) {
                        arrayList = (ArrayList) hashMap.remove(obj);
                    } else {
                        arrayList = null;
                    }
                    c.delayedTaskKeySet.remove(c.f362920a.f(i3, ((Number) obj).longValue()));
                }
                if (QLog.isDebugVersion()) {
                    QLog.d("TroopMemberRequestMerge", 4, "[handleMessage] taskId:" + i3 + ", mergeMills:" + i16 + ", taskList:" + arrayList);
                }
                TroopMemberListRepo.INSTANCE.mergeFetchTroopMemberInfo$qqtroop_impl_release(((Number) obj).longValue(), arrayList, i16);
                return;
            }
            QLog.e("TroopMemberRequestMerge", 1, "[handleMessage] troopUin error, troopUin:" + obj + ", mergeMills:" + i16);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63603);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        f362920a = new c();
        mergeRequestLock = new Object();
        waitingTaskMap = new HashMap<>();
        delayedTaskKeySet = new HashSet<>();
        handler = new a(Looper.getMainLooper());
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String f(int taskId, long troopUin) {
        return taskId + "#" + troopUin;
    }

    private final void i() {
        requestConfig = null;
        delayedTaskKeySet.clear();
        waitingTaskMap.clear();
        handler.removeCallbacksAndMessages(null);
    }

    public final boolean e(@NotNull b task) {
        Integer b16;
        Long a16;
        ArrayList<b> arrayList;
        HashMap<Long, ArrayList<b>> hashMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) task)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(task, "task");
        com.tencent.qqnt.troopmemberlist.merge.a aVar = requestConfig;
        boolean z16 = false;
        if (aVar != null && (b16 = aVar.b(task.b())) != null) {
            int intValue = b16.intValue();
            com.tencent.qqnt.troopmemberlist.merge.a aVar2 = requestConfig;
            if (aVar2 != null && (a16 = aVar2.a(intValue)) != null) {
                long longValue = a16.longValue();
                synchronized (mergeRequestLock) {
                    HashMap<Integer, HashMap<Long, ArrayList<b>>> hashMap2 = waitingTaskMap;
                    if (!hashMap2.containsKey(Integer.valueOf(intValue))) {
                        hashMap2.put(Integer.valueOf(intValue), new HashMap<>());
                    }
                    HashMap<Long, ArrayList<b>> hashMap3 = hashMap2.get(Integer.valueOf(intValue));
                    if (hashMap3 != null && !hashMap3.containsKey(Long.valueOf(task.e()))) {
                        z16 = true;
                    }
                    if (z16 && (hashMap = hashMap2.get(Integer.valueOf(intValue))) != null) {
                        hashMap.put(Long.valueOf(task.e()), new ArrayList<>());
                    }
                    HashMap<Long, ArrayList<b>> hashMap4 = hashMap2.get(Integer.valueOf(intValue));
                    if (hashMap4 != null && (arrayList = hashMap4.get(Long.valueOf(task.e()))) != null) {
                        arrayList.add(task);
                    }
                    String f16 = f362920a.f(intValue, task.e());
                    HashSet<String> hashSet = delayedTaskKeySet;
                    if (!hashSet.contains(f16)) {
                        hashSet.add(f16);
                        if (QLog.isDebugVersion()) {
                            QLog.d("TroopMemberRequestMerge", 4, "[doMergeRequest] taskId:" + intValue + ", taskKey:" + f16 + ", delayMills:" + longValue + ", start delay task");
                        }
                        a aVar3 = handler;
                        Message obtain = Message.obtain();
                        obtain.what = intValue;
                        obtain.obj = Long.valueOf(task.e());
                        obtain.arg1 = (int) longValue;
                        aVar3.sendMessageDelayed(obtain, longValue);
                    } else {
                        if (QLog.isDebugVersion()) {
                            QLog.d("TroopMemberRequestMerge", 4, "[doMergeRequest] taskId:" + intValue + ", taskKey:" + f16 + ", delayMills:" + longValue + ", delay task in queue");
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        QLog.i("TroopMemberRequestMerge", 1, "[initMergeConfig]");
        i();
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("103029", false)) {
            return;
        }
        String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("103029", "");
        com.tencent.qqnt.troopmemberlist.merge.a aVar = new com.tencent.qqnt.troopmemberlist.merge.a();
        aVar.c(loadAsString);
        requestConfig = aVar;
    }

    public final boolean h(@NotNull String from) {
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) from)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(from, "from");
        if (!((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("103029", false)) {
            return false;
        }
        com.tencent.qqnt.troopmemberlist.merge.a aVar = requestConfig;
        if (aVar != null) {
            num = aVar.b(from);
        } else {
            num = null;
        }
        if (num == null) {
            return false;
        }
        return true;
    }
}
