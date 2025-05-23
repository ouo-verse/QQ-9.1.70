package com.tencent.mobileqq.qqlive.sail.ui.room;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.av.LiveMediaConfigManager;
import com.tencent.mobileqq.qqlive.api.av.ResolutionLevelType;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/room/l;", "", "it", "", "invoke", "(Lcom/tencent/mobileqq/qqlive/sail/room/l;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveTrtcRoomPart$startRoom$1 extends Lambda implements Function1<com.tencent.mobileqq.qqlive.sail.room.l<Boolean>, Unit> {
    static IPatchRedirector $redirector_;
    final /* synthetic */ QQLiveTrtcRoomPart this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQLiveTrtcRoomPart$startRoom$1(QQLiveTrtcRoomPart qQLiveTrtcRoomPart) {
        super(1);
        this.this$0 = qQLiveTrtcRoomPart;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQLiveTrtcRoomPart);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QQLiveTrtcRoomPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.broadcastMessage("onStartRoom", null);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.qqlive.sail.room.l<Boolean> lVar) {
        invoke2(lVar);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull com.tencent.mobileqq.qqlive.sail.room.l<Boolean> it) {
        RoomViewModel Va;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
            return;
        }
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.b() == 0) {
            Va = this.this$0.Va();
            Va.m2(LiveMediaConfigManager.INSTANCE.getResolutionLevelTypeCache(ResolutionLevelType.UHD));
            final QQLiveTrtcRoomPart qQLiveTrtcRoomPart = this.this$0;
            qQLiveTrtcRoomPart.runOnActivityUiThread(new Runnable() { // from class: com.tencent.mobileqq.qqlive.sail.ui.room.q
                @Override // java.lang.Runnable
                public final void run() {
                    QQLiveTrtcRoomPart$startRoom$1.b(QQLiveTrtcRoomPart.this);
                }
            });
            return;
        }
        AegisLogger.INSTANCE.w("Open_Live|QQLiveTrtcRoomPart", "onRoomStart", "retCode=" + it.b() + ", errMsg=" + it.c());
    }
}
