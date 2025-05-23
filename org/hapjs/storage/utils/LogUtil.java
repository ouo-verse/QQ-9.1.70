package org.hapjs.storage.utils;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lorg/hapjs/storage/utils/LogUtil;", "", "()V", "Companion", "storage-sdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes29.dex */
public final class LogUtil {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static boolean LOGGABLE;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0006\u0010\n\u001a\u00020\u0006J\"\u0010\u000b\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u001a\u0010\u000b\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u001a\u0010\u000b\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0006\u0010\u000e\u001a\u00020\u0006J\u001a\u0010\u000f\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u001a\u0010\u0010\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lorg/hapjs/storage/utils/LogUtil$Companion;", "", "()V", "LOGGABLE", "", "d", "", "tag", "", "msg", "disableLog", "e", "throwable", "", "enableLog", "i", "w", "storage-sdk_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes29.dex */
    public static final class Companion {
        Companion() {
        }

        public final void d(@Nullable String tag, @Nullable String msg2) {
            if (LogUtil.LOGGABLE) {
                Intrinsics.checkNotNull(msg2);
                Log.d(tag, msg2);
            }
        }

        public final void disableLog() {
            LogUtil.LOGGABLE = false;
        }

        public final void e(@Nullable String tag, @Nullable Throwable throwable) {
            e(tag, "", throwable);
        }

        public final void enableLog() {
            LogUtil.LOGGABLE = true;
        }

        public final void i(@Nullable String tag, @Nullable String msg2) {
            if (LogUtil.LOGGABLE) {
                Intrinsics.checkNotNull(msg2);
                Log.i(tag, msg2);
            }
        }

        public final void w(@Nullable String tag, @Nullable String msg2) {
            Intrinsics.checkNotNull(msg2);
            Log.w(tag, msg2);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void e(@Nullable String tag, @NotNull String msg2, @Nullable Throwable throwable) {
            String str;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (throwable != null) {
                if (LogUtil.LOGGABLE) {
                    Log.d(tag, msg2 + "##Throwable##" + Log.getStackTraceString(throwable));
                } else {
                    Log.d(tag, msg2 + throwable.getMessage());
                }
                str = null;
            } else {
                str = "throwable is null";
            }
            e(tag, msg2 + str);
        }

        public final void e(@Nullable String tag, @Nullable String msg2) {
            Intrinsics.checkNotNull(msg2);
            Log.e(tag, msg2);
        }
    }
}
