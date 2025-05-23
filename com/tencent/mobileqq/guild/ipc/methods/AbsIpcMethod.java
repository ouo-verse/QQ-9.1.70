package com.tencent.mobileqq.guild.ipc.methods;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.ipc.IpcArguments;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes13.dex */
public abstract class AbsIpcMethod {

    /* compiled from: P */
    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes13.dex */
    public @interface IpcMethod {
        boolean singleton();
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final QIPCModule f226302a;

        /* renamed from: b, reason: collision with root package name */
        public final int f226303b;

        /* renamed from: c, reason: collision with root package name */
        public final Bundle f226304c;

        public a(QIPCModule qIPCModule, int i3, Bundle bundle) {
            this.f226302a = qIPCModule;
            this.f226303b = i3;
            this.f226304c = bundle;
        }

        public void a(int i3, Bundle bundle) {
            this.f226302a.callbackResult(this.f226303b, EIPCResult.createResult(i3, bundle));
        }

        public void b(Bundle bundle) {
            this.f226302a.callbackResult(this.f226303b, EIPCResult.createSuccessResult(bundle));
        }
    }

    public abstract EIPCResult a(a aVar, String str, Object... objArr);

    public final EIPCResult b(QIPCModule qIPCModule, String str, @NonNull Bundle bundle, int i3) {
        bundle.setClassLoader(MobileQQ.sMobileQQ.getClassLoader());
        a aVar = new a(qIPCModule, i3, bundle);
        Parcelable parcelable = bundle.getParcelable("args");
        if (parcelable instanceof IpcArguments) {
            return a(aVar, str, ((IpcArguments) parcelable).a());
        }
        return a(aVar, str, new Object[0]);
    }

    public final Bundle c(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("msg", str);
        return bundle;
    }
}
