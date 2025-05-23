package com.tencent.mobileqq.qqlive.base.room.service.roominfo;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 \n2\u00020\u00012\u00020\u0002:\u0001\u000bB\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0096\u0001J\t\u0010\u0006\u001a\u00020\u0005H\u0096\u0001\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qqlive/base/room/service/roominfo/a;", "", "Lcom/tencent/mobileqq/qqlive/base/room/service/roominfo/b;", "Lcom/tencent/mobileqq/qqlive/data/anchor/room/QQLiveAnchorRoomInfo;", "getAnchorRoomInfo", "", "getRoomId", "roomInfoServiceProxy", "<init>", "(Lcom/tencent/mobileqq/qqlive/base/room/service/roominfo/b;)V", "b", "a", "qq-live-room-base_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ b f271151a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/base/room/service/roominfo/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-room-base_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.base.room.service.roominfo.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33207);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 21)) {
            redirector.redirect((short) 21);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a(@NotNull b roomInfoServiceProxy) {
        Intrinsics.checkNotNullParameter(roomInfoServiceProxy, "roomInfoServiceProxy");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) roomInfoServiceProxy);
        } else {
            this.f271151a = roomInfoServiceProxy;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.base.room.service.roominfo.b
    @Nullable
    public QQLiveAnchorRoomInfo getAnchorRoomInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QQLiveAnchorRoomInfo) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f271151a.getAnchorRoomInfo();
    }

    @Override // com.tencent.mobileqq.qqlive.base.room.service.roominfo.b
    public long getRoomId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.f271151a.getRoomId();
    }
}
