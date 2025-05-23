package jg3;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.zplan.web.impl.CommonNative2JsEvent;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Ljg3/b;", "", "", "msg", "", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f409904a = new b();

    b() {
    }

    public final void a(String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.d("CgSdkSendMsgHelper", 1, "sendMsg, msg: " + msg2);
        SimpleEventBus.getInstance().dispatchEvent(new CommonNative2JsEvent("receiveMsgFromNative", msg2));
    }
}
