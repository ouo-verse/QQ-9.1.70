package com.tencent.qqnt.http.api.impl;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.http.api.k;
import com.tencent.qqnt.http.api.l;
import com.tencent.qqnt.http.api.m;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 &2\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0013H\u0016R \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR&\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001f0\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u001eR\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006("}, d2 = {"Lcom/tencent/qqnt/http/api/impl/h;", "Lcom/tencent/qqnt/http/api/impl/e;", "", "taskKey", "Lcom/tencent/qqnt/http/api/b;", "task", "", "addToSameTasks", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "removeSameTasks", "Lokhttp3/Request;", "generateRequest", "Lokhttp3/Call;", "call", "addCall", "removeCall", "generateTaskKey", "submitAsyncTask", "Lcom/tencent/qqnt/http/api/m;", "submitSyncTask", "cancelTask", "onCallFinish", "generateCall", "", "hasSameTask", "taskResult", "notifySameTask", "", "reqs", "Ljava/util/Map;", "", "sameTasks", "Lokhttp3/OkHttpClient;", "client", "Lokhttp3/OkHttpClient;", "<init>", "()V", "Companion", "a", "http_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public class h implements e {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "NTHttp.TaskManager";

    @NotNull
    private final OkHttpClient client;

    @NotNull
    private final Map<String, Call> reqs;

    @NotNull
    private final Map<String, List<com.tencent.qqnt.http.api.b>> sameTasks;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/http/api/impl/h$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "http_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.http.api.impl.h$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32688);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public h() {
        List<? extends Protocol> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.reqs = new LinkedHashMap();
        this.sameTasks = new LinkedHashMap();
        OkHttpClient.Builder connectionPool = new OkHttpClient.Builder().connectionPool(new ConnectionPool(5, 1L, TimeUnit.MINUTES));
        Executor netExcutor = ThreadManagerV2.getNetExcutor();
        Intrinsics.checkNotNull(netExcutor, "null cannot be cast to non-null type java.util.concurrent.ExecutorService");
        Dispatcher dispatcher = new Dispatcher((ExecutorService) netExcutor);
        dispatcher.setMaxRequests(128);
        Unit unit = Unit.INSTANCE;
        OkHttpClient.Builder eventListener = connectionPool.dispatcher(dispatcher).addInterceptor(new com.tencent.qqnt.http.download.f()).eventListener(new d());
        listOf = CollectionsKt__CollectionsJVMKt.listOf(Protocol.HTTP_1_1);
        this.client = eventListener.protocols(listOf).dns(new com.tencent.qqnt.http.okhttp3.a(null, i3, 0 == true ? 1 : 0)).build();
    }

    private final void addCall(com.tencent.qqnt.http.api.b task, Call call) throws DuplicateTaskException {
        synchronized (this) {
            String generateTaskKey = generateTaskKey(task);
            if (!this.reqs.containsKey(generateTaskKey)) {
                this.reqs.put(generateTaskKey, call);
                Unit unit = Unit.INSTANCE;
            } else {
                throw new DuplicateTaskException("duplicate task:" + task + " key:" + generateTaskKey);
            }
        }
    }

    private final void addToSameTasks(String taskKey, com.tencent.qqnt.http.api.b task) {
        List<com.tencent.qqnt.http.api.b> mutableListOf;
        QLog.i(TAG, 1, "task:" + task.u() + " addToSameTasks");
        if (!this.sameTasks.containsKey(taskKey)) {
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(task);
            this.sameTasks.put(taskKey, mutableListOf);
        } else {
            List<com.tencent.qqnt.http.api.b> list = this.sameTasks.get(taskKey);
            Intrinsics.checkNotNull(list);
            list.add(task);
        }
    }

    private final Request generateRequest(com.tencent.qqnt.http.api.b task) {
        MediaType mediaType;
        RequestBody create$default;
        k n3 = task.n();
        RequestBody requestBody = null;
        if (n3 != null) {
            String a16 = n3.a();
            if (a16 != null) {
                mediaType = MediaType.INSTANCE.parse(a16);
            } else {
                mediaType = null;
            }
            Object b16 = n3.b();
            if (b16 instanceof File) {
                create$default = RequestBody.INSTANCE.create((File) b16, mediaType);
            } else if (b16 instanceof byte[]) {
                create$default = RequestBody.Companion.create$default(RequestBody.INSTANCE, (byte[]) b16, mediaType, 0, 0, 6, (Object) null);
            }
            requestBody = create$default;
        }
        Request.Builder tag = new Request.Builder().url(task.x()).method(task.j().name(), requestBody).tag(com.tencent.qqnt.http.api.b.class, task).tag(c.class, new c()).tag(SocketFactory.class, task.q()).tag(SSLSocketFactory.class, task.r()).tag(HostnameVerifier.class, task.i());
        Map<String, String> h16 = task.h();
        if (h16 != null) {
            for (Map.Entry<String, String> entry : h16.entrySet()) {
                tag.addHeader(entry.getKey(), entry.getValue());
            }
        }
        return tag.build();
    }

    private final String generateTaskKey(com.tencent.qqnt.http.api.b task) {
        File c16 = b.c(task);
        if (c16 != null) {
            String absolutePath = c16.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath, "it.absolutePath");
            return absolutePath;
        }
        return String.valueOf(task.u());
    }

    private final Call removeCall(com.tencent.qqnt.http.api.b task) {
        Call remove;
        synchronized (this) {
            remove = this.reqs.remove(generateTaskKey(task));
        }
        return remove;
    }

    private final void removeSameTasks(String taskKey, int taskId) {
        QLog.i(TAG, 1, "task:" + taskId + " removeSameTasks");
        synchronized (this.sameTasks) {
            this.sameTasks.remove(taskKey);
        }
    }

    public final void cancelTask(@NotNull com.tencent.qqnt.http.api.b task) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) task);
            return;
        }
        Intrinsics.checkNotNullParameter(task, "task");
        QLog.i(TAG, 1, "task:" + task.u() + " cancelTask");
        b.b(task);
        Call removeCall = removeCall(task);
        if (removeCall != null) {
            removeCall.cancel();
        }
        removeSameTasks(generateTaskKey(task), task.u());
    }

    @Override // com.tencent.qqnt.http.api.impl.e
    @NotNull
    public Call generateCall(@NotNull com.tencent.qqnt.http.api.b task) throws DuplicateTaskException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Call) iPatchRedirector.redirect((short) 6, (Object) this, (Object) task);
        }
        Intrinsics.checkNotNullParameter(task, "task");
        com.tencent.qqnt.http.okhttp3.b bVar = new com.tencent.qqnt.http.okhttp3.b(this.client, generateRequest(task));
        bVar.timeout().timeout(task.w(), TimeUnit.MILLISECONDS);
        addCall(task, bVar);
        return bVar;
    }

    @Override // com.tencent.qqnt.http.api.impl.e
    public boolean hasSameTask(@NotNull com.tencent.qqnt.http.api.b task) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) task)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(task, "task");
        String generateTaskKey = generateTaskKey(task);
        if (this.reqs.containsKey(generateTaskKey)) {
            synchronized (this.sameTasks) {
                addToSameTasks(generateTaskKey, task);
                Unit unit = Unit.INSTANCE;
            }
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.http.api.impl.e
    public void notifySameTask(@NotNull com.tencent.qqnt.http.api.b task, @NotNull m taskResult) {
        List<com.tencent.qqnt.http.api.b> remove;
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) task, (Object) taskResult);
            return;
        }
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(taskResult, "taskResult");
        String generateTaskKey = generateTaskKey(task);
        if (QLog.isDevelopLevel()) {
            QLog.i(TAG, 1, "task:" + task.u() + " notifySameTask ");
        }
        synchronized (this.sameTasks) {
            remove = this.sameTasks.remove(generateTaskKey);
            Unit unit = Unit.INSTANCE;
        }
        List<com.tencent.qqnt.http.api.b> list = remove;
        if (list != null) {
            int u16 = task.u();
            if (list != null) {
                num = Integer.valueOf(list.size());
            } else {
                num = null;
            }
            QLog.i(TAG, 1, "task:" + u16 + " notify  " + num);
            for (com.tencent.qqnt.http.api.b bVar : list) {
                if (taskResult.e()) {
                    l v3 = bVar.v();
                    if (v3 != null) {
                        v3.onSuccess(bVar, taskResult);
                    }
                } else {
                    l v16 = bVar.v();
                    if (v16 != null) {
                        v16.onFailed(bVar, taskResult);
                    }
                }
            }
        }
    }

    @Override // com.tencent.qqnt.http.api.impl.e
    public void onCallFinish(@NotNull Call call, @NotNull com.tencent.qqnt.http.api.b task) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) call, (Object) task);
            return;
        }
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(task, "task");
        int u16 = task.u();
        c a16 = com.tencent.qqnt.http.okhttp3.c.a(call);
        if (a16 != null) {
            str = a16.l();
        } else {
            str = null;
        }
        QLog.i(TAG, 1, "task:" + u16 + " onCallFinish callInfo:" + str);
        removeCall(task);
    }

    public final void submitAsyncTask(@NotNull com.tencent.qqnt.http.api.b task) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) task);
            return;
        }
        Intrinsics.checkNotNullParameter(task, "task");
        QLog.i(TAG, 1, "submitAsyncTask:" + task);
        new g(task, this).m();
    }

    @NotNull
    public final m submitSyncTask(@NotNull com.tencent.qqnt.http.api.b task) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (m) iPatchRedirector.redirect((short) 3, (Object) this, (Object) task);
        }
        Intrinsics.checkNotNullParameter(task, "task");
        QLog.i(TAG, 1, "submitSyncTask:" + task);
        return new i(task, this).k();
    }
}
