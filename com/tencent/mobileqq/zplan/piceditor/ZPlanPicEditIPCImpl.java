package com.tencent.mobileqq.zplan.piceditor;

import android.content.Intent;
import com.tencent.mobileqq.activity.aio.photo.c;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.zplan.cc.util.h;
import com.tencent.qphone.base.util.QLog;
import jj3.a;
import jj3.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\f\u001a\u0004\u0018\u00010\t8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zplan/piceditor/ZPlanPicEditIPCImpl;", "Ljj3/b;", "", "path", "Ljj3/a;", "callback", "", "setAvatarByPicPath", "addPicToCustomEmoticon", "Lcom/tencent/mobileqq/app/QQAppInterface;", "getQqAppInterface", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "qqAppInterface", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanPicEditIPCImpl implements b {
    private static final String TAG = "ZPlanPicEditIPCImpl";

    private final QQAppInterface getQqAppInterface() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface == null) {
            QLog.e(TAG, 1, "get AppRuntime failed: can't be cast to QQAppInterface.");
        }
        return qQAppInterface;
    }

    @Override // jj3.b
    public void addPicToCustomEmoticon(String path, a callback) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QQAppInterface qqAppInterface = getQqAppInterface();
        if (qqAppInterface == null) {
            callback.onResult(false);
        } else if (!h.f332563a.a(path)) {
            QLog.e(TAG, 1, "invalid avatar file path: file doesn't exist!");
            callback.onResult(false);
        } else {
            callback.onResult(c.d(qqAppInterface, path) == 0);
        }
    }

    @Override // jj3.b
    public void setAvatarByPicPath(String path, a callback) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(callback, "callback");
        QQAppInterface qqAppInterface = getQqAppInterface();
        if (qqAppInterface == null) {
            callback.onResult(false);
        } else if (!h.f332563a.a(path)) {
            QLog.e(TAG, 1, "invalid avatar file path: file doesn't exist!");
            callback.onResult(false);
        } else {
            callback.onResult(ProfileCardUtil.h0(qqAppInterface, path, new Intent()));
        }
    }
}
