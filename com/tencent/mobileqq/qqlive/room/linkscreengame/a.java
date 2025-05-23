package com.tencent.mobileqq.qqlive.room.linkscreengame;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.framework.interfaceService.InjectService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002R\u0016\u0010\b\u001a\u00020\u00078\u0002@\u0002X\u0083.\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/linkscreengame/a;", "Lcom/tencent/mobileqq/qqlive/framework/component/b;", "", "k", "i", "o", "p", "Lcom/tencent/mobileqq/qqlive/base/room/service/a;", "qqLiveRoomService", "Lcom/tencent/mobileqq/qqlive/base/room/service/a;", "Lgn3/a;", "e", "Lgn3/a;", "linkScreenComponent", "Lfi2/a;", "cc", "<init>", "(Lfi2/a;)V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a extends com.tencent.mobileqq.qqlive.framework.component.b {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private gn3.a linkScreenComponent;

    @InjectService(key = com.tencent.mobileqq.qqlive.base.room.service.a.class)
    private com.tencent.mobileqq.qqlive.base.room.service.a qqLiveRoomService;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull fi2.a cc5) {
        super(cc5);
        Intrinsics.checkNotNullParameter(cc5, "cc");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cc5);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.framework.component.e
    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        gn3.a aVar = this.linkScreenComponent;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.framework.component.e
    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    public final void o() {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        com.tencent.mobileqq.qqlive.base.room.service.a aVar = this.qqLiveRoomService;
        com.tencent.mobileqq.qqlive.base.room.service.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
            aVar = null;
        }
        long roomId = aVar.getRoomId();
        com.tencent.mobileqq.qqlive.base.room.service.a aVar3 = this.qqLiveRoomService;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qqLiveRoomService");
        } else {
            aVar2 = aVar3;
        }
        QQLiveAnchorRoomInfo anchorRoomInfo = aVar2.getAnchorRoomInfo();
        if (anchorRoomInfo != null) {
            j3 = anchorRoomInfo.uid;
        } else {
            j3 = 0;
        }
        this.linkScreenComponent = new gn3.a(roomId, j3);
    }

    public final void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        gn3.a aVar = this.linkScreenComponent;
        if (aVar != null) {
            aVar.a();
        }
    }
}
