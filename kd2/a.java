package kd2;

import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.common.logger.LogState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005H\u0016\u00a2\u0006\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lkd2/a;", "Lcom/tencent/rmonitor/common/logger/a;", "Lcom/tencent/rmonitor/common/logger/LogState;", "state", "", "", "args", "", "a", "(Lcom/tencent/rmonitor/common/logger/LogState;[Ljava/lang/String;)V", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a implements com.tencent.rmonitor.common.logger.a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: kd2.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public /* synthetic */ class C10649a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f412060a;

        static {
            int[] iArr = new int[LogState.values().length];
            try {
                iArr[LogState.VERBOS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LogState.DEBUG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LogState.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LogState.WARN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[LogState.ERROR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[LogState.OFF.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f412060a = iArr;
        }
    }

    @Override // com.tencent.rmonitor.common.logger.a
    public void a(@NotNull LogState state, @NotNull String... args) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(args, "args");
        if (args.length > 1) {
            String str = args[0];
            StringBuilder sb5 = new StringBuilder(256);
            int length = args.length;
            for (int i3 = 1; i3 < length; i3++) {
                sb5.append(args[i3]);
            }
            int i16 = C10649a.f412060a[state.ordinal()];
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 != 3) {
                        if (i16 != 4) {
                            if (i16 == 5) {
                                QLog.e(str, 1, sb5.toString());
                                return;
                            }
                            return;
                        }
                        QLog.w(str, 1, sb5.toString());
                        return;
                    }
                    QLog.i(str, 1, sb5.toString());
                    return;
                }
                QLog.d(str, 1, sb5.toString());
                return;
            }
            QLog.d(str, 1, sb5.toString());
        }
    }
}
