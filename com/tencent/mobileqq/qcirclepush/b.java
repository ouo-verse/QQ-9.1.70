package com.tencent.mobileqq.qcirclepush;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tencent.im.s2c.msgtype0x210.submsgtype0x15e.submsgtype0x15e$MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x15e.submsgtype0x15e$SystemNotify;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qcirclepush/b;", "", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "", "data", "", "isOnlineMsg", "", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f261756a = new b();

    b() {
    }

    @JvmStatic
    public static final void a(@NotNull QQAppInterface app, @NotNull byte[] data, boolean isOnlineMsg) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(data, "data");
        submsgtype0x15e$MsgBody submsgtype0x15e_msgbody = new submsgtype0x15e$MsgBody();
        try {
            submsgtype0x15e_msgbody.mergeFrom(data);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("QCirclePush.Receiver", 1, e16, new Object[0]);
        }
        int i3 = submsgtype0x15e_msgbody.uint32_msg_type.get();
        QLog.i("QCirclePush.Receiver", 1, "receive push msg, msgType=" + i3 + ", isOnline=" + isOnlineMsg);
        if (i3 == 0) {
            QCircleNotificationHandler qCircleNotificationHandler = QCircleNotificationHandler.f261745d;
            submsgtype0x15e$SystemNotify submsgtype0x15e_systemnotify = submsgtype0x15e_msgbody.msg_system_notify.get();
            Intrinsics.checkNotNullExpressionValue(submsgtype0x15e_systemnotify, "msgBody.msg_system_notify.get()");
            qCircleNotificationHandler.d(app, submsgtype0x15e_systemnotify, isOnlineMsg);
        }
    }
}
