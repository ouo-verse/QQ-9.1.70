package com.tencent.richframework.delegate;

import com.tencent.biz.richframework.delegate.ILogDelegate;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J3\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\"\u00020\u000bH\u0016\u00a2\u0006\u0002\u0010\fJ$\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J3\u0010\r\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\"\u00020\u000bH\u0016\u00a2\u0006\u0002\u0010\fJ$\u0010\r\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016J$\u0010\u0011\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J$\u0010\u0015\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/richframework/delegate/RFWLogImpl;", "Lcom/tencent/biz/richframework/delegate/ILogDelegate;", "()V", "d", "", "tag", "", "reportLevel", "", "msg", "", "", "(Ljava/lang/String;I[Ljava/lang/Object;)V", "e", "getCLRValue", "getDEVValue", "getUSRValue", "i", "isColorLevel", "", "isDevelopLevel", "w", "qq-rfw-kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class RFWLogImpl implements ILogDelegate {
    @Override // com.tencent.biz.richframework.delegate.ILogDelegate
    public void d(@Nullable String tag, int reportLevel, @Nullable String msg2) {
        QLog.d(tag, reportLevel, msg2);
    }

    @Override // com.tencent.biz.richframework.delegate.ILogDelegate
    public void e(@Nullable String tag, int reportLevel, @Nullable String msg2) {
        QLog.e(tag, reportLevel, msg2);
    }

    @Override // com.tencent.biz.richframework.delegate.ILogDelegate
    public int getCLRValue() {
        return 2;
    }

    @Override // com.tencent.biz.richframework.delegate.ILogDelegate
    public int getDEVValue() {
        return 4;
    }

    @Override // com.tencent.biz.richframework.delegate.ILogDelegate
    public int getUSRValue() {
        return 1;
    }

    @Override // com.tencent.biz.richframework.delegate.ILogDelegate
    public void i(@Nullable String tag, int reportLevel, @Nullable String msg2) {
        QLog.i(tag, reportLevel, msg2);
    }

    @Override // com.tencent.biz.richframework.delegate.ILogDelegate
    public boolean isColorLevel() {
        return QLog.isColorLevel();
    }

    @Override // com.tencent.biz.richframework.delegate.ILogDelegate
    public boolean isDevelopLevel() {
        return QLog.isDevelopLevel();
    }

    @Override // com.tencent.biz.richframework.delegate.ILogDelegate
    public void w(@Nullable String tag, int reportLevel, @Nullable String msg2) {
        QLog.w(tag, reportLevel, msg2);
    }

    @Override // com.tencent.biz.richframework.delegate.ILogDelegate
    public void d(@Nullable String tag, int reportLevel, @NotNull Object... msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        QLog.d(tag, reportLevel, Arrays.copyOf(msg2, msg2.length));
    }

    @Override // com.tencent.biz.richframework.delegate.ILogDelegate
    public void e(@Nullable String tag, int reportLevel, @NotNull Object... msg2) {
        Throwable th5;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        int length = msg2.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                th5 = null;
                break;
            }
            Object obj = msg2[i3];
            if (obj instanceof Throwable) {
                th5 = (Throwable) obj;
                break;
            }
            i3++;
        }
        QLog.e(tag, reportLevel, th5, Arrays.copyOf(msg2, msg2.length));
    }
}
