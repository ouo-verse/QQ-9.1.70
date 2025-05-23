package com.tencent.mobileqq.aio.lateinit.aioreserve1;

import com.tencent.mobileqq.aio.lateinit.LatinitCreateModeIntent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.route.MsgIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/aio/lateinit/aioreserve1/AIOReserve1CreateModelIntent;", "Lcom/tencent/mobileqq/aio/lateinit/LatinitCreateModeIntent;", "", "f", "Ljava/lang/String;", "getModelName", "()Ljava/lang/String;", "modelName", "Lcom/tencent/mvi/base/route/MsgIntent;", h.F, "Lcom/tencent/mvi/base/route/MsgIntent;", "getInitMsgIntent", "()Lcom/tencent/mvi/base/route/MsgIntent;", "initMsgIntent", "<init>", "(Ljava/lang/String;Lcom/tencent/mvi/base/route/MsgIntent;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AIOReserve1CreateModelIntent extends LatinitCreateModeIntent {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String modelName;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MsgIntent initMsgIntent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIOReserve1CreateModelIntent(@NotNull String modelName, @NotNull MsgIntent initMsgIntent) {
        super(modelName, initMsgIntent);
        Intrinsics.checkNotNullParameter(modelName, "modelName");
        Intrinsics.checkNotNullParameter(initMsgIntent, "initMsgIntent");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) modelName, (Object) initMsgIntent);
        } else {
            this.modelName = modelName;
            this.initMsgIntent = initMsgIntent;
        }
    }
}
