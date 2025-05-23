package com.tencent.biz.pubaccount.weishi.util;

import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.util.QQToastUtil;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u001c\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u0002H\u0007J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0003J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/util/an;", "", "", "icon", "msg", "", "d", "Ljava/lang/Runnable;", "runnable", "c", "", "f", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class an {

    /* renamed from: a, reason: collision with root package name */
    public static final an f81707a = new an();

    an() {
    }

    @JvmStatic
    private static final void c(Runnable runnable) {
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            ThreadManager.getUIHandler().post(runnable);
        } else {
            runnable.run();
        }
    }

    @JvmStatic
    public static final void d(final int icon, final int msg2) {
        c(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.util.al
            @Override // java.lang.Runnable
            public final void run() {
                an.e(icon, msg2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(int i3, int i16) {
        QQToastUtil.showQQToast(i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        QQToastUtil.showQQToast(-1, msg2);
    }

    public final void f(final String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        c(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.util.am
            @Override // java.lang.Runnable
            public final void run() {
                an.g(msg2);
            }
        });
    }
}
