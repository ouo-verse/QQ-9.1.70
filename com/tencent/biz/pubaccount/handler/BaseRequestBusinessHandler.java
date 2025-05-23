package com.tencent.biz.pubaccount.handler;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.handler.BaseRequestBusinessHandler;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.loginregister.impl.FaceIdentificationEnablePrePageApiImpl;
import com.tencent.qphone.base.remote.ToServiceMsg;
import ey.a;
import ey.b;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001eB\u0011\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001e\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0006J4\u0010\u0013\u001a\u00020\u00122\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0004R&\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00150\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/biz/pubaccount/handler/BaseRequestBusinessHandler;", "Lcom/tencent/mobileqq/app/BusinessHandler;", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "req", "Ley/a;", "callback", "", Constants.MMCCID, "I2", "key", "H2", "", "isSuccess", "", "code", "msg", "", "data", "", "E2", "Ljava/util/concurrent/ConcurrentHashMap;", "Lmqq/util/WeakReference;", "d", "Ljava/util/concurrent/ConcurrentHashMap;", "mCallbacks", "Lcom/tencent/common/app/AppInterface;", "app", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "e", "a", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public abstract class BaseRequestBusinessHandler extends BusinessHandler {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<String, WeakReference<a>> mCallbacks;

    public BaseRequestBusinessHandler(AppInterface appInterface) {
        super(appInterface);
        this.mCallbacks = new ConcurrentHashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F2(a aVar, boolean z16, int i3, String msg2, Object obj) {
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        ((b) aVar).i(z16, i3, msg2, obj);
    }

    private final String G2(ToServiceMsg req, a callback) {
        return req.getServiceCmd() + callback.hashCode() + req.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void E2(ToServiceMsg req, final boolean isSuccess, final int code, final String msg2, final Object data) {
        final a H2;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (req == null) {
            return;
        }
        String str = (String) req.getAttribute(FaceIdentificationEnablePrePageApiImpl.CALLBACK_KEY, "");
        if (TextUtils.isEmpty(str) || (H2 = H2(str)) == null) {
            return;
        }
        if ((H2 instanceof b) && !Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: hy.a
                @Override // java.lang.Runnable
                public final void run() {
                    BaseRequestBusinessHandler.F2(ey.a.this, isSuccess, code, msg2, data);
                }
            });
        } else {
            H2.i(isSuccess, code, msg2, data);
        }
    }

    public final a H2(String key) {
        WeakReference weakReference;
        if (TextUtils.isEmpty(key) || (weakReference = (WeakReference) TypeIntrinsics.asMutableMap(this.mCallbacks).remove(key)) == null) {
            return null;
        }
        return (a) weakReference.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String I2(ToServiceMsg req, a callback) {
        if (req == null || callback == null) {
            return null;
        }
        String G2 = G2(req, callback);
        this.mCallbacks.put(G2, new WeakReference<>(callback));
        req.addAttribute(FaceIdentificationEnablePrePageApiImpl.CALLBACK_KEY, G2);
        return G2;
    }
}
