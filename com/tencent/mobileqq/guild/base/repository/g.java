package com.tencent.mobileqq.guild.base.repository;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0014\u0010\u0015J-\u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000\u00a2\u0006\u0004\b\b\u0010\tJ&\u0010\f\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/base/repository/g;", "", "T", "Lcom/tencent/mobileqq/guild/base/repository/h;", "", "funcName", "result", "", "e", "(Lcom/tencent/mobileqq/guild/base/repository/h;Ljava/lang/String;Ljava/lang/Object;)V", "Lri1/a;", "error", "c", "a", "Ljava/lang/String;", "tag", "Landroid/os/Handler;", "b", "Landroid/os/Handler;", "dispatchHandler", "<init>", "(Ljava/lang/String;Landroid/os/Handler;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tag;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler dispatchHandler;

    public g(@NotNull String tag, @NotNull Handler dispatchHandler) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(dispatchHandler, "dispatchHandler");
        this.tag = tag;
        this.dispatchHandler = dispatchHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(g this$0, h this_dispatchError, ri1.a error, String funcName) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_dispatchError, "$this_dispatchError");
        Intrinsics.checkNotNullParameter(error, "$error");
        Intrinsics.checkNotNullParameter(funcName, "$funcName");
        Logger logger = Logger.f235387a;
        String str = this$0.tag;
        Logger.b bVar = new Logger.b();
        String str2 = funcName + " onResult " + error;
        if (str2 instanceof String) {
            bVar.a().add(str2);
        }
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e(str, 1, (String) it.next(), null);
        }
        this_dispatchError.a(error, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(g this$0, h this_dispatchResult, Object obj, String funcName) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_dispatchResult, "$this_dispatchResult");
        Intrinsics.checkNotNullParameter(funcName, "$funcName");
        Logger logger = Logger.f235387a;
        String str = this$0.tag;
        if (QLog.isColorLevel()) {
            logger.d().d(str, 2, funcName + " onResult " + obj);
        }
        ri1.a f16 = ri1.a.f();
        Intrinsics.checkNotNullExpressionValue(f16, "ok()");
        this_dispatchResult.a(f16, obj);
    }

    public final <T> void c(@NotNull final h<T> hVar, @NotNull final String funcName, @NotNull final ri1.a error) {
        Intrinsics.checkNotNullParameter(hVar, "<this>");
        Intrinsics.checkNotNullParameter(funcName, "funcName");
        Intrinsics.checkNotNullParameter(error, "error");
        this.dispatchHandler.post(new Runnable() { // from class: com.tencent.mobileqq.guild.base.repository.e
            @Override // java.lang.Runnable
            public final void run() {
                g.d(g.this, hVar, error, funcName);
            }
        });
    }

    public final <T> void e(@NotNull final h<T> hVar, @NotNull final String funcName, final T t16) {
        Intrinsics.checkNotNullParameter(hVar, "<this>");
        Intrinsics.checkNotNullParameter(funcName, "funcName");
        this.dispatchHandler.post(new Runnable() { // from class: com.tencent.mobileqq.guild.base.repository.f
            @Override // java.lang.Runnable
            public final void run() {
                g.f(g.this, hVar, t16, funcName);
            }
        });
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ g(String str, Handler handler, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, handler);
        if ((i3 & 2) != 0) {
            handler = ThreadManagerV2.getUIHandlerV2();
            Intrinsics.checkNotNullExpressionValue(handler, "getUIHandlerV2()");
        }
    }
}
