package com.tencent.now.linkpkanchorplay.invite.model;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback;
import com.tencent.mobileqq.qqlive.sail.room.f;
import com.tencent.mobileqq.qqlive.sail.room.g;
import com.tencent.qqlive.common.api.AegisLogger;
import g55.ag;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b*\u0001\u0015\u0018\u0000 \u001f2\u00020\u0001:\u0002 \u0005B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0014\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0006\u0010\n\u001a\u00020\u0004J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000fR\"\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006!"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/invite/model/d;", "Lcom/tencent/mobileqq/qqlive/sail/room/g;", "", "data", "", "b", "Lcom/tencent/now/linkpkanchorplay/invite/model/d$b;", "Lg55/ag;", "pushCallback", "c", "d", "Lfp4/c;", "msgInfo", "onPush", "", "J", "roomId", "", "e", "Ljava/util/List;", "inviteMsgCallbackList", "com/tencent/now/linkpkanchorplay/invite/model/d$c", "f", "Lcom/tencent/now/linkpkanchorplay/invite/model/d$c;", "qqCmdPushCallback", "", h.F, "Z", "isInitPush", "<init>", "(J)V", "i", "a", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class d implements g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long roomId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<b<ag>> inviteMsgCallbackList = new ArrayList();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c qqCmdPushCallback = new c();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isInitPush;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/invite/model/d$b;", "T", "", "data", "", "a", "(Ljava/lang/Object;)V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public interface b<T> {
        void a(T data);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/now/linkpkanchorplay/invite/model/d$c", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQCmdPushCallback;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "onFail", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class c implements IQQCmdPushCallback {
        c() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
        public void onFail(int errCode, @Nullable String errMsg) {
            AegisLogger.INSTANCE.e("PK_Biz|InviteMsgPushMode", "Receive pkAndInvitePush", "errCode:" + errCode + ", errMsg:" + errMsg);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
        public void onReceive(@Nullable byte[] data) {
            gp4.a c16 = gp4.a.c(data);
            AegisLogger.INSTANCE.i("PK_Biz|InviteMsgPushMode", "Receive pkAndInvitePush Push cmd: " + c16.f403047a);
            if (c16.f403047a == 106) {
                d.this.b(c16.f403049c);
            }
        }
    }

    public d(long j3) {
        this.roomId = j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(byte[] data) {
        ag agVar = new ag();
        MessageNano.mergeFrom(agVar, data);
        Iterator<T> it = this.inviteMsgCallbackList.iterator();
        while (it.hasNext()) {
            ((b) it.next()).a(agVar);
        }
    }

    public final void c(@NotNull b<ag> pushCallback) {
        Unit unit;
        Intrinsics.checkNotNullParameter(pushCallback, "pushCallback");
        synchronized (this) {
            if (!this.isInitPush) {
                f z16 = com.tencent.mobileqq.qqlive.sail.c.z(com.tencent.mobileqq.qqlive.sail.c.f272176a, this.roomId, 0, 2, null);
                if (z16 != null) {
                    z16.p(285, this);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    com.tencent.mobileqq.qqlive.pushadapter.a.a(this.roomId, 285, this.qqCmdPushCallback);
                }
                this.isInitPush = true;
            }
            Unit unit2 = Unit.INSTANCE;
        }
        this.inviteMsgCallbackList.add(pushCallback);
    }

    public final void d() {
        this.inviteMsgCallbackList.clear();
        f z16 = com.tencent.mobileqq.qqlive.sail.c.z(com.tencent.mobileqq.qqlive.sail.c.f272176a, this.roomId, 0, 2, null);
        if (z16 != null) {
            z16.e(this);
        }
        com.tencent.mobileqq.qqlive.pushadapter.a.b(this.roomId, this.qqCmdPushCallback);
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.g
    public void onPush(@NotNull fp4.c msgInfo) {
        Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
        ag o16 = com.tencent.mobileqq.qqlive.sail.push.a.o(msgInfo);
        if (o16 != null) {
            AegisLogger.INSTANCE.i("PK_Biz|InviteMsgPushMode", "onPush", "InviteMsg");
            Iterator<T> it = this.inviteMsgCallbackList.iterator();
            while (it.hasNext()) {
                ((b) it.next()).a(o16);
            }
        }
    }
}
