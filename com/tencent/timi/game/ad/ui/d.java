package com.tencent.timi.game.ad.ui;

import af4.OperationItem;
import android.os.Bundle;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.ad.ui.event.ToTargetTabEvent;
import com.tencent.timi.game.liveroom.impl.ipc.TGLiveServerQIPCModule;
import com.tencent.timi.game.utils.l;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/timi/game/ad/ui/d;", "", "Laf4/d;", "data", "", "b", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f376246a = new d();

    d() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(EIPCResult eIPCResult) {
        Integer num;
        Bundle bundle = null;
        if (eIPCResult != null) {
            num = Integer.valueOf(eIPCResult.code);
        } else {
            num = null;
        }
        if (eIPCResult != null) {
            bundle = eIPCResult.data;
        }
        l.i("BaseOperationalOpt", "ipc jump, code:" + num + ", data:" + bundle);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0039, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r5.getJumpUrl());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(@NotNull OperationItem data) {
        BaseQQAppInterface baseQQAppInterface;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(data, "data");
        l.b("BaseOperationalOpt", "doJumpTask " + data);
        String jumpType = data.getJumpType();
        switch (jumpType.hashCode()) {
            case 48:
                jumpType.equals("0");
                return;
            case 49:
                if (jumpType.equals("1")) {
                    BaseApplication context = BaseApplication.context;
                    if ("0".equals(data.getView())) {
                        lo4.a aVar = (lo4.a) mm4.b.b(lo4.a.class);
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        aVar.Y(context, data.getJumpUrl());
                        return;
                    } else {
                        lo4.a aVar2 = (lo4.a) mm4.b.b(lo4.a.class);
                        Intrinsics.checkNotNullExpressionValue(context, "context");
                        aVar2.y1(context, data.getJumpUrl());
                        return;
                    }
                }
                return;
            case 50:
                if (jumpType.equals("2")) {
                    AppRuntime a16 = vf4.a.a();
                    if (a16 instanceof BaseQQAppInterface) {
                        baseQQAppInterface = (BaseQQAppInterface) a16;
                    } else {
                        baseQQAppInterface = null;
                    }
                    if (baseQQAppInterface == null) {
                        TGLiveServerQIPCModule.Companion companion = TGLiveServerQIPCModule.INSTANCE;
                        Bundle bundle = new Bundle();
                        bundle.putString("param_jump_url", data.getJumpUrl());
                        Unit unit = Unit.INSTANCE;
                        companion.a("action_jump_url", bundle, new EIPCResultCallback() { // from class: com.tencent.timi.game.ad.ui.c
                            @Override // eipc.EIPCResultCallback
                            public final void onCallback(EIPCResult eIPCResult) {
                                d.c(eIPCResult);
                            }
                        });
                        return;
                    }
                    ax c16 = bi.c(baseQQAppInterface, vf4.a.b(), data.getJumpUrl());
                    l.h("BaseOperationalOpt", 1, "doJumpTask action:" + c16);
                    if (c16 != null) {
                        c16.b();
                        return;
                    }
                    return;
                }
                return;
            case 51:
                if (jumpType.equals("3") && intOrNull != null) {
                    SimpleEventBus.getInstance().dispatchEvent(new ToTargetTabEvent(data.getRoomId(), intOrNull.intValue()));
                    return;
                }
                return;
            default:
                return;
        }
    }
}
