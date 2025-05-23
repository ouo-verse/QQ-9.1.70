package com.tencent.robot.subscribe.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import r64.SubscribeMessageDialogParam;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bg\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011JC\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\bH&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/robot/subscribe/api/IRobotMessageSubscribeApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "srcTag", "Landroid/content/Context;", "context", "Lr64/a;", "dialogParam", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "state", "", "callback", "showTicketRequestDialog", "Companion", "a", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes25.dex */
public interface IRobotMessageSubscribeApi extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f368579a;
    public static final int DIALOG_STATE_DISMISSED = 0;
    public static final int DIALOG_STATE_REQUESTING_DATA = 1;
    public static final int DIALOG_STATE_SHOWING = 2;
    public static final int SUBSCRIBE_ALLOW = 1;
    public static final int SUBSCRIBE_REFUSE = 2;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/robot/subscribe/api/IRobotMessageSubscribeApi$a;", "", "<init>", "()V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.robot.subscribe.api.IRobotMessageSubscribeApi$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f368579a = new Companion();

        Companion() {
        }
    }

    void showTicketRequestDialog(@NotNull String srcTag, @NotNull Context context, @NotNull SubscribeMessageDialogParam dialogParam, @NotNull Function1<? super Integer, Unit> callback);
}
