package eu;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class a<T extends BusinessHandler> {

    /* renamed from: a, reason: collision with root package name */
    protected AppInterface f397130a;

    /* renamed from: b, reason: collision with root package name */
    protected T f397131b;

    public a(AppInterface appInterface, T t16) {
        this.f397130a = appInterface;
        this.f397131b = t16;
    }

    public boolean a(String str) {
        return TextUtils.equals(str, b());
    }

    public abstract String b();

    public abstract void c(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj);
}
