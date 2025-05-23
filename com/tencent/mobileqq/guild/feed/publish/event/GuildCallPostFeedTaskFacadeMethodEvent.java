package com.tencent.mobileqq.guild.feed.publish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.guild.feed.nativepublish.utils.a;
import com.tencent.qphone.base.util.QLog;
import in1.d;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J-\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0016\u0010\t\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u0007\"\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\f\u001a\u00020\u0002R\u0017\u0010\u000e\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0012R\"\u0010\t\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/publish/event/GuildCallPostFeedTaskFacadeMethodEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "e", "b", "", "methodId", "", "Ljava/io/Serializable;", "args", "wrapCall", "(I[Ljava/io/Serializable;)V", "handle", "", "mainTaskId", "Ljava/lang/String;", "getMainTaskId", "()Ljava/lang/String;", "I", "[Ljava/io/Serializable;", "<init>", "(Ljava/lang/String;)V", "Companion", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildCallPostFeedTaskFacadeMethodEvent extends SimpleBaseEvent {
    public static final int METHOD_ID_CAS_STAGE = 2;
    public static final int METHOD_ID_SET_STAGE = 1;

    @Nullable
    private Serializable[] args;

    @NotNull
    private final String mainTaskId;
    private int methodId;

    public GuildCallPostFeedTaskFacadeMethodEvent(@NotNull String mainTaskId) {
        Intrinsics.checkNotNullParameter(mainTaskId, "mainTaskId");
        this.mainTaskId = mainTaskId;
    }

    private final void b() {
        Object firstOrNull;
        Object orNull;
        Serializable[] serializableArr = this.args;
        if (serializableArr != null) {
            firstOrNull = ArraysKt___ArraysKt.firstOrNull(serializableArr);
            Serializable serializable = (Serializable) firstOrNull;
            if (serializable != null) {
                Serializable serializable2 = null;
                if (!(serializable instanceof Integer)) {
                    serializable = null;
                }
                Integer num = (Integer) serializable;
                if (num != null) {
                    int intValue = num.intValue();
                    Serializable[] serializableArr2 = this.args;
                    if (serializableArr2 != null) {
                        orNull = ArraysKt___ArraysKt.getOrNull(serializableArr2, 1);
                        Serializable serializable3 = (Serializable) orNull;
                        if (serializable3 != null) {
                            if (serializable3 instanceof Integer) {
                                serializable2 = serializable3;
                            }
                            Integer num2 = (Integer) serializable2;
                            if (num2 != null) {
                                int intValue2 = num2.intValue();
                                d c16 = a.c(this.mainTaskId);
                                if (c16 == null) {
                                    return;
                                }
                                if (c16.getStage() == intValue) {
                                    c16.c(intValue2);
                                    return;
                                }
                                QLog.w("GuildCallPostFeedTaskFacadeMethodEvent", 1, "[handleCasStage]: stage not matchfacade.stage=" + c16 + ".stage, expected=" + intValue + ", update=" + intValue2);
                            }
                        }
                    }
                }
            }
        }
    }

    private final void e() {
        Object firstOrNull;
        Serializable[] serializableArr = this.args;
        Unit unit = null;
        if (serializableArr != null) {
            firstOrNull = ArraysKt___ArraysKt.firstOrNull(serializableArr);
            Serializable serializable = (Serializable) firstOrNull;
            if (serializable != null) {
                if (!(serializable instanceof Integer)) {
                    serializable = null;
                }
                Integer num = (Integer) serializable;
                if (num != null) {
                    int intValue = num.intValue();
                    d c16 = a.c(this.mainTaskId);
                    if (c16 != null) {
                        c16.c(intValue);
                    }
                    unit = Unit.INSTANCE;
                }
            }
        }
        if (unit == null) {
            QLog.w("GuildCallPostFeedTaskFacadeMethodEvent", 1, "[handle]: args is null");
        }
    }

    @NotNull
    public final String getMainTaskId() {
        return this.mainTaskId;
    }

    public final void handle() {
        if (MobileQQ.sProcessId != 1) {
            QLog.w("GuildCallPostFeedTaskFacadeMethodEvent", 1, "[handle]: " + this.mainTaskId + " not in main process");
            return;
        }
        int i3 = this.methodId;
        if (i3 != 1) {
            if (i3 != 2) {
                QLog.w("GuildCallPostFeedTaskFacadeMethodEvent", 1, "[handle]: unknown method id: " + i3);
                return;
            }
            b();
            return;
        }
        e();
    }

    public final void wrapCall(int methodId, @NotNull Serializable... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        this.methodId = methodId;
        this.args = args;
    }
}
