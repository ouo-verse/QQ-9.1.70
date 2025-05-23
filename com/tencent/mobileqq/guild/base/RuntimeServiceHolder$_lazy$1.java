package com.tencent.mobileqq.guild.base;

import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import mqq.app.api.IRuntimeService;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX WARN: Incorrect field signature: TT; */
/* compiled from: P */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\r\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00028\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0014"}, d2 = {"com/tencent/mobileqq/guild/base/RuntimeServiceHolder$_lazy$1", "Lkotlin/Lazy;", "Lcom/tencent/mobileqq/guild/base/e;", "", "isInitialized", "", "reset", "Lkotlin/Function0;", "d", "Lkotlin/jvm/functions/Function0;", "initializer", "e", "Lmqq/app/api/IRuntimeService;", "_value", "f", "Lcom/tencent/mobileqq/guild/base/RuntimeServiceHolder$_lazy$1;", JoinPoint.SYNCHRONIZATION_LOCK, "a", "()Lmqq/app/api/IRuntimeService;", "value", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class RuntimeServiceHolder$_lazy$1<T> implements Lazy<T>, e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Function0<? extends T> initializer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile IRuntimeService _value;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RuntimeServiceHolder$_lazy$1 lock = this;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ RuntimeServiceHolder f214704h;

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ String f214705i;

    /* renamed from: m, reason: collision with root package name */
    final /* synthetic */ Class<T> f214706m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RuntimeServiceHolder$_lazy$1(final RuntimeServiceHolder runtimeServiceHolder, final String str, final Class<T> cls) {
        this.f214704h = runtimeServiceHolder;
        this.f214705i = str;
        this.f214706m = cls;
        this.initializer = new Function0<T>() { // from class: com.tencent.mobileqq.guild.base.RuntimeServiceHolder$_lazy$1$initializer$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IRuntimeService invoke() {
                Logger logger = Logger.f235387a;
                String str2 = str;
                Class<T> cls2 = cls;
                if (QLog.isColorLevel()) {
                    logger.d().d("RuntimeServiceHolder.lazy", 1, "_obtain(" + str2 + ", " + cls2.getSimpleName() + ") calling...");
                }
                return RuntimeServiceHolder.this.b(str, cls);
            }
        };
    }

    /* JADX WARN: Incorrect return type in method signature: ()TT; */
    @Override // kotlin.Lazy
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public IRuntimeService getValue() {
        IRuntimeService iRuntimeService;
        ConcurrentHashMap concurrentHashMap;
        IRuntimeService iRuntimeService2 = this._value;
        if (iRuntimeService2 != null) {
            return iRuntimeService2;
        }
        RuntimeServiceHolder$_lazy$1 runtimeServiceHolder$_lazy$1 = this.lock;
        RuntimeServiceHolder runtimeServiceHolder = this.f214704h;
        Class<T> cls = this.f214706m;
        synchronized (runtimeServiceHolder$_lazy$1) {
            iRuntimeService = this._value;
            if (iRuntimeService == null) {
                iRuntimeService = (IRuntimeService) this.initializer.invoke();
                concurrentHashMap = runtimeServiceHolder.resettableHolders;
                concurrentHashMap.put(cls, this);
                this._value = iRuntimeService;
            }
        }
        return iRuntimeService;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        if (this._value != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.base.e
    public void reset() {
        Logger logger = Logger.f235387a;
        String str = this.f214705i;
        Class<T> cls = this.f214706m;
        if (QLog.isColorLevel()) {
            logger.d().d("RuntimeServiceHolder.lazy", 1, "reset(" + str + ", " + cls.getSimpleName() + ") calling...");
        }
        this._value = null;
    }
}
