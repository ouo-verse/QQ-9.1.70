package com.tencent.biz.qqcircle.comment.recpic;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.http.Headers;
import android.os.IBinder;
import com.tencent.aelight.camera.api.IAEClassManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IClipService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0006*\u0001\u0014\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002R\u0014\u0010\u0007\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR$\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/biz/qqcircle/comment/recpic/e;", "", "", "e", "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/wink/api/IClipService;", "b", "Lcom/tencent/mobileqq/wink/api/IClipService;", "clipService", "Landroid/content/ServiceConnection;", "c", "Landroid/content/ServiceConnection;", "serviceConnection", "Lkotlin/Function1;", "d", "Lkotlin/jvm/functions/Function1;", "bindCallback", "com/tencent/biz/qqcircle/comment/recpic/e$a", "Lcom/tencent/biz/qqcircle/comment/recpic/e$a;", Headers.CONN_DIRECTIVE, "<init>", "(Landroid/content/Context;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IClipService clipService;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ServiceConnection serviceConnection;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super IClipService, Unit> bindCallback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a connection;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/biz/qqcircle/comment/recpic/e$a", "Landroid/content/ServiceConnection;", "Landroid/content/ComponentName;", "name", "Landroid/os/IBinder;", "service", "", "onServiceConnected", "onServiceDisconnected", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(@Nullable ComponentName name, @Nullable IBinder service) {
            e.this.clipService = IClipService.a.j(service);
            Function1 function1 = e.this.bindCallback;
            if (function1 != null) {
                IClipService iClipService = e.this.clipService;
                Intrinsics.checkNotNull(iClipService);
                function1.invoke(iClipService);
            }
            e.this.bindCallback = null;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(@Nullable ComponentName name) {
            e.this.clipService = null;
        }
    }

    public e(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        a aVar = new a();
        this.connection = aVar;
        this.serviceConnection = aVar;
        e();
    }

    private final void e() {
        this.context.bindService(new Intent(this.context, (Class<?>) ((IAEClassManager) QRoute.api(IAEClassManager.class)).getPeakServiceClass()), this.connection, 1);
    }
}
