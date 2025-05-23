package com.tencent.now.pkgame.linkandpkobserver.repository;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback;
import com.tencent.mobileqq.qqlive.sail.room.f;
import com.tencent.mobileqq.qqlive.sail.room.g;
import com.tencent.qqlive.common.api.AegisLogger;
import g55.au;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\b\t*\u0001\u0019\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001 B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0002J\u0016\u0010\u000b\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0016\u0010\r\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\bH\u0016J\u0006\u0010\u000e\u001a\u00020\u0005J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0013R\"\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\b0\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0016R\"\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0016R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/now/pkgame/linkandpkobserver/repository/c;", "", "Lcom/tencent/mobileqq/qqlive/sail/room/g;", "", "data", "", "c", "d", "Lcom/tencent/now/pkgame/linkandpkobserver/repository/b;", "Lg55/au;", "pushCallback", "f", "Lh55/b;", "e", "g", "Lfp4/c;", "msgInfo", "onPush", "", "J", "roomId", "", "Ljava/util/List;", "endLinkCallbacks", "pkMsgCallbacks", "com/tencent/now/pkgame/linkandpkobserver/repository/c$b", h.F, "Lcom/tencent/now/pkgame/linkandpkobserver/repository/c$b;", "linkAndPKPushRev", "<init>", "(J)V", "i", "a", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class c implements g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long roomId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<com.tencent.now.pkgame.linkandpkobserver.repository.b<h55.b>> endLinkCallbacks = new ArrayList();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<com.tencent.now.pkgame.linkandpkobserver.repository.b<au>> pkMsgCallbacks = new ArrayList();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b linkAndPKPushRev;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/now/pkgame/linkandpkobserver/repository/c$b", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQCmdPushCallback;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "onFail", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements IQQCmdPushCallback {
        b() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
        public void onFail(int errCode, @Nullable String errMsg) {
            AegisLogger.INSTANCE.e("PK_Biz|LinkScreenAndPkPushImpl", "linkAndPKPushRev", "errCode: " + errCode + ", errMsg: " + errMsg);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
        public void onReceive(@Nullable byte[] data) {
            bl4.a c16 = bl4.a.c(data);
            AegisLogger.INSTANCE.i("PK_Biz|LinkScreenAndPkPushImpl", "linkAndPKPushRev", "\u6536\u5230cmd: " + c16.f28641a);
            int i3 = c16.f28641a;
            if (i3 == 104) {
                c.this.c(c16.f28643c);
            } else if (i3 == 107) {
                c.this.d(c16.f28643c);
            }
        }
    }

    public c(long j3) {
        ILiveRoom z16;
        this.roomId = j3;
        b bVar = new b();
        this.linkAndPKPushRev = bVar;
        f z17 = com.tencent.mobileqq.qqlive.sail.c.z(com.tencent.mobileqq.qqlive.sail.c.f272176a, j3, 0, 2, null);
        if (z17 != null) {
            z17.p(285, this);
            return;
        }
        jg4.b bVar2 = (jg4.b) mm4.b.b(jg4.b.class);
        if (bVar2 != null && (z16 = bVar2.z(j3)) != null) {
            z16.registerLivePushChannel(285, bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(byte[] data) {
        h55.b bVar = new h55.b();
        MessageNano.mergeFrom(bVar, data);
        Iterator<T> it = this.endLinkCallbacks.iterator();
        while (it.hasNext()) {
            ((com.tencent.now.pkgame.linkandpkobserver.repository.b) it.next()).a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(byte[] data) {
        au auVar = new au();
        MessageNano.mergeFrom(auVar, data);
        Iterator<T> it = this.pkMsgCallbacks.iterator();
        while (it.hasNext()) {
            ((com.tencent.now.pkgame.linkandpkobserver.repository.b) it.next()).a(auVar);
        }
    }

    public void e(@NotNull com.tencent.now.pkgame.linkandpkobserver.repository.b<h55.b> pushCallback) {
        Intrinsics.checkNotNullParameter(pushCallback, "pushCallback");
        this.endLinkCallbacks.add(pushCallback);
    }

    public void f(@NotNull com.tencent.now.pkgame.linkandpkobserver.repository.b<au> pushCallback) {
        Intrinsics.checkNotNullParameter(pushCallback, "pushCallback");
        this.pkMsgCallbacks.add(pushCallback);
    }

    public final void g() {
        ILiveRoom z16;
        f z17 = com.tencent.mobileqq.qqlive.sail.c.z(com.tencent.mobileqq.qqlive.sail.c.f272176a, this.roomId, 0, 2, null);
        if (z17 != null) {
            z17.e(this);
        }
        jg4.b bVar = (jg4.b) mm4.b.b(jg4.b.class);
        if (bVar != null && (z16 = bVar.z(this.roomId)) != null) {
            z16.unRegisterLivePushChannel(this.linkAndPKPushRev);
        }
        this.endLinkCallbacks.clear();
        this.pkMsgCallbacks.clear();
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.g
    public void onPush(@NotNull fp4.c msgInfo) {
        Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
        h55.b b16 = com.tencent.mobileqq.qqlive.sail.push.a.b(msgInfo);
        if (b16 != null) {
            AegisLogger.INSTANCE.i("PK_Biz|LinkScreenAndPkPushImpl", "onPush", "AnchorSwitchMic, end link");
            Iterator<T> it = this.endLinkCallbacks.iterator();
            while (it.hasNext()) {
                ((com.tencent.now.pkgame.linkandpkobserver.repository.b) it.next()).a(b16);
            }
        }
        au s16 = com.tencent.mobileqq.qqlive.sail.push.a.s(msgInfo);
        if (s16 != null) {
            AegisLogger.INSTANCE.i("PK_Biz|LinkScreenAndPkPushImpl", "onPush", "PKMsg, " + s16.f401337b);
            Iterator<T> it5 = this.pkMsgCallbacks.iterator();
            while (it5.hasNext()) {
                ((com.tencent.now.pkgame.linkandpkobserver.repository.b) it5.next()).a(s16);
            }
        }
    }
}
