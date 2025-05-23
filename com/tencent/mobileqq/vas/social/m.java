package com.tencent.mobileqq.vas.social;

import com.tencent.qphone.base.util.QLog;
import com.tencent.state.square.SquareLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J$\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u001a\u0010\r\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/vas/social/m;", "Lcom/tencent/state/square/SquareLogger;", "", "tag", "message", "", "d", "", "throwable", "e", "i", "", "isColorLevel", "w", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class m implements SquareLogger {
    @Override // com.tencent.state.square.SquareLogger
    public void d(String tag, String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        QLog.d(tag, 1, message);
    }

    @Override // com.tencent.state.square.SquareLogger
    public void e(String tag, String message, Throwable throwable) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        QLog.e(tag, 1, message, throwable);
    }

    @Override // com.tencent.state.square.SquareLogger
    public void i(String tag, String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        QLog.i(tag, 1, message);
    }

    @Override // com.tencent.state.square.SquareLogger
    public boolean isColorLevel() {
        return QLog.isColorLevel();
    }

    @Override // com.tencent.state.square.SquareLogger
    public void w(String tag, String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        QLog.w(tag, 1, message);
    }
}
