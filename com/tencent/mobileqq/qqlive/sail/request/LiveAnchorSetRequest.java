package com.tencent.mobileqq.qqlive.sail.request;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest;
import com.tencent.mobileqq.qqlive.sail.model.AnchorRoomInfo;
import com.tencent.mobileqq.qqlive.sail.model.common.LocationInfo;
import com.tencent.mobileqq.qqlive.utils.e;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qqlive.common.api.AegisLogger;
import gr4.u;
import gr4.v;
import gr4.y;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rq4.a;
import rq4.b;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u0016*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u0005B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J!\u0010\u000e\u001a\u0004\u0018\u00018\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/request/LiveAnchorSetRequest;", "T", "Lcom/tencent/mobileqq/qqlive/api/sso/LiveBaseRequest;", "", "Lgr4/y;", "a", "()[Lgr4/y;", "", "getMainCmd", "getSubCmd", "Lcom/google/protobuf/nano/MessageNano;", "getMessageNano", "", "convertInputStreamtoByteArray", "decode", "([B)Ljava/lang/Object;", "Lcom/tencent/mobileqq/qqlive/sail/model/AnchorRoomInfo;", "roomInfo", "Lcom/tencent/mobileqq/qqlive/sail/model/AnchorRoomInfo;", "wantAppId", "<init>", "(Ljava/lang/String;Lcom/tencent/mobileqq/qqlive/sail/model/AnchorRoomInfo;)V", "Companion", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class LiveAnchorSetRequest<T> extends LiveBaseRequest<T> {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "Open_Live|LiveAnchorSetRequest";

    @NotNull
    private final AnchorRoomInfo roomInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/request/LiveAnchorSetRequest$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.request.LiveAnchorSetRequest$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44312);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LiveAnchorSetRequest(@NotNull String wantAppId, @NotNull AnchorRoomInfo roomInfo) {
        super(wantAppId);
        Intrinsics.checkNotNullParameter(wantAppId, "wantAppId");
        Intrinsics.checkNotNullParameter(roomInfo, "roomInfo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) wantAppId, (Object) roomInfo);
        } else {
            this.roomInfo = roomInfo;
        }
    }

    private final y[] a() {
        String str;
        String str2;
        long j3;
        String a16;
        ArrayList arrayList = new ArrayList();
        y yVar = new y();
        yVar.f403243a = 1;
        yVar.f403245c = this.roomInfo.r().j();
        arrayList.add(yVar);
        y yVar2 = new y();
        yVar2.f403243a = 2;
        LocationInfo f16 = this.roomInfo.r().f();
        String str3 = "";
        if (f16 == null || (str = f16.c()) == null) {
            str = "";
        }
        yVar2.f403245c = str;
        arrayList.add(yVar2);
        y yVar3 = new y();
        yVar3.f403243a = 3;
        LocationInfo f17 = this.roomInfo.r().f();
        if (f17 == null || (str2 = f17.b()) == null) {
            str2 = "";
        }
        yVar3.f403245c = str2;
        arrayList.add(yVar3);
        y yVar4 = new y();
        yVar4.f403243a = 4;
        LocationInfo f18 = this.roomInfo.r().f();
        if (f18 != null && (a16 = f18.a()) != null) {
            str3 = a16;
        }
        yVar4.f403245c = str3;
        arrayList.add(yVar4);
        y yVar5 = new y();
        yVar5.f403243a = 5;
        yVar5.f403245c = DeviceInfoMonitor.getModel();
        arrayList.add(yVar5);
        y yVar6 = new y();
        yVar6.f403243a = 6;
        if (this.roomInfo.r().e()) {
            j3 = 0;
        } else {
            j3 = 1;
        }
        yVar6.f403244b = j3;
        arrayList.add(yVar6);
        y yVar7 = new y();
        yVar7.f403243a = 7;
        yVar7.f403245c = this.roomInfo.r().c().c();
        arrayList.add(yVar7);
        y yVar8 = new y();
        yVar8.f403243a = 8;
        yVar8.f403244b = this.roomInfo.r().c().g();
        arrayList.add(yVar8);
        y yVar9 = new y();
        yVar9.f403243a = 11;
        yVar9.f403245c = this.roomInfo.r().c().f();
        arrayList.add(yVar9);
        y yVar10 = new y();
        yVar10.f403243a = 12;
        yVar10.f403244b = this.roomInfo.r().c().k();
        arrayList.add(yVar10);
        y yVar11 = new y();
        yVar11.f403243a = 9;
        yVar11.f403245c = this.roomInfo.r().c().e();
        arrayList.add(yVar11);
        y yVar12 = new y();
        yVar12.f403243a = 10;
        yVar12.f403244b = this.roomInfo.r().c().j();
        arrayList.add(yVar12);
        Object[] array = arrayList.toArray(new y[0]);
        Intrinsics.checkNotNullExpressionValue(array, "tlvs.toArray(tlvArray)");
        return (y[]) array;
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    @Nullable
    public <T> T decode(@Nullable byte[] convertInputStreamtoByteArray) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (T) iPatchRedirector.redirect((short) 5, (Object) this, (Object) convertInputStreamtoByteArray);
        }
        try {
            return (T) v.c(convertInputStreamtoByteArray);
        } catch (Exception e16) {
            AegisLogger.INSTANCE.e(TAG, "decode", "error, ", e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    /* renamed from: getMainCmd */
    public String getService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "trpc.qlive.ilive_room_play.RoomPlay";
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    public MessageNano getMessageNano() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MessageNano) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        u uVar = new u();
        uVar.f403214a = this.roomInfo.p().g();
        uVar.f403218e = this.roomInfo.p().f();
        uVar.f403217d = this.roomInfo.r().l();
        uVar.f403219f = e.a();
        uVar.f403225l = this.roomInfo.r().k();
        b bVar = new b();
        bVar.f431968a = this.roomInfo.r().o();
        bVar.f431970c = this.roomInfo.r().g();
        uVar.f403227n = bVar;
        a aVar = new a();
        aVar.f431964a = this.roomInfo.r().n().b();
        aVar.f431965b = this.roomInfo.r().n().c();
        aVar.f431966c = this.roomInfo.r().n().a();
        aVar.f431967d = this.roomInfo.r().n().e();
        uVar.f403226m = aVar;
        uVar.f403215b = a();
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        if (companion.isDevelopLevel()) {
            companion.d(TAG, "getMessageNano", "roomId=" + uVar.f403214a + ", roomName=" + this.roomInfo.r().j() + ", programId=" + uVar.f403218e + ", source=" + uVar.f403217d + ", hasGoods=" + uVar.f403227n.f431968a);
        }
        return uVar;
    }

    @Override // com.tencent.mobileqq.qqlive.api.sso.LiveBaseRequest
    @NotNull
    /* renamed from: getSubCmd */
    public String getMethod() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "Set";
    }
}
