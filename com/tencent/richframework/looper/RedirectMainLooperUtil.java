package com.tencent.richframework.looper;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.os.MessageQueue;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c7\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0004\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/richframework/looper/RedirectMainLooperUtil;", "", "", "setLooperMessageQueueSameAsMain", "initField", "Z", "Ljava/lang/reflect/Field;", "MESSAGE_QUEUE_FIELD", "Ljava/lang/reflect/Field;", "<init>", "()V", "threadmanager_debug"}, k = 1, mv = {1, 4, 1})
@SuppressLint({"DiscouragedPrivateApi"})
/* loaded from: classes25.dex */
public final class RedirectMainLooperUtil {

    @NotNull
    public static final RedirectMainLooperUtil INSTANCE = new RedirectMainLooperUtil();
    private static Field MESSAGE_QUEUE_FIELD;
    private static boolean initField;

    static {
        Object m476constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            Field declaredField = Looper.class.getDeclaredField("mQueue");
            Intrinsics.checkNotNullExpressionValue(declaredField, "Looper::class.java.getDeclaredField(\"mQueue\")");
            MESSAGE_QUEUE_FIELD = declaredField;
            if (declaredField == null) {
                Intrinsics.throwUninitializedPropertyAccessException("MESSAGE_QUEUE_FIELD");
            }
            declaredField.setAccessible(true);
            Field modifiersField = Field.class.getDeclaredField("accessFlags");
            Intrinsics.checkNotNullExpressionValue(modifiersField, "modifiersField");
            modifiersField.setAccessible(true);
            Field field = MESSAGE_QUEUE_FIELD;
            if (field == null) {
                Intrinsics.throwUninitializedPropertyAccessException("MESSAGE_QUEUE_FIELD");
            }
            Field field2 = MESSAGE_QUEUE_FIELD;
            if (field2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("MESSAGE_QUEUE_FIELD");
            }
            modifiersField.setInt(field, field2.getModifiers() & (-17));
            initField = true;
            m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            RFWLog.e("RedirectMainLooperUtil", RFWLog.USR, m479exceptionOrNullimpl);
        }
    }

    RedirectMainLooperUtil() {
    }

    public final boolean setLooperMessageQueueSameAsMain() {
        MessageQueue messageQueue;
        try {
            if (!initField || Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                return false;
            }
            if (Looper.myLooper() == null) {
                Looper.prepare();
            }
            Field field = MESSAGE_QUEUE_FIELD;
            if (field == null) {
                Intrinsics.throwUninitializedPropertyAccessException("MESSAGE_QUEUE_FIELD");
            }
            Looper myLooper = Looper.myLooper();
            Looper mainLooper = Looper.getMainLooper();
            Intrinsics.checkNotNullExpressionValue(mainLooper, "Looper.getMainLooper()");
            field.set(myLooper, mainLooper.getQueue());
            Looper myLooper2 = Looper.myLooper();
            if (myLooper2 != null) {
                messageQueue = myLooper2.getQueue();
            } else {
                messageQueue = null;
            }
            Looper mainLooper2 = Looper.getMainLooper();
            Intrinsics.checkNotNullExpressionValue(mainLooper2, "Looper.getMainLooper()");
            return Intrinsics.areEqual(messageQueue, mainLooper2.getQueue());
        } catch (Exception e16) {
            RFWLog.e("RedirectMainLooperUtil", RFWLog.USR, e16);
            return false;
        }
    }
}
