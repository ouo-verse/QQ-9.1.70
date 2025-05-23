package com.tencent.mobileqq.nearbypro.base.config;

import com.tencent.mobileqq.nearbypro.base.ILog;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/base/config/c;", "Lcom/tencent/mobileqq/nearbypro/base/ILog;", "", "isColorLevel", "", "e", "", "a", "tag", "Lcom/tencent/mobileqq/nearbypro/base/ILog$Level;", "level", "message", "", "b", "<init>", "()V", "qq_nearby_pro_base_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class c implements ILog {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f253222a;

        static {
            int[] iArr = new int[ILog.Level.values().length];
            try {
                iArr[ILog.Level.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ILog.Level.INFO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ILog.Level.WARN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ILog.Level.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f253222a = iArr;
        }
    }

    @Override // com.tencent.mobileqq.nearbypro.base.ILog
    @Nullable
    public String a(@NotNull Throwable e16) {
        Intrinsics.checkNotNullParameter(e16, "e");
        return QLog.getStackTraceString(e16);
    }

    @Override // com.tencent.mobileqq.nearbypro.base.ILog
    public void b(@NotNull String tag, @NotNull ILog.Level level, @Nullable String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(level, "level");
        int i3 = a.f253222a[level.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        QLog.e(tag, 1, message);
                        return;
                    }
                    return;
                }
                QLog.w(tag, 1, message);
                return;
            }
            QLog.i(tag, 1, message);
            return;
        }
        if (j.a().debug()) {
            QLog.d(tag, 1, message);
        }
    }

    @Override // com.tencent.mobileqq.nearbypro.base.ILog
    public boolean isColorLevel() {
        if (QLog.isColorLevel() && !j.a().mo208public()) {
            return true;
        }
        return false;
    }
}
