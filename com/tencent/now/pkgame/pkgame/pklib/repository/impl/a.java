package com.tencent.now.pkgame.pkgame.pklib.repository.impl;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qqlive.api.room.ILiveRoom;
import com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback;
import com.tencent.mobileqq.qqlive.sail.room.f;
import com.tencent.mobileqq.qqlive.sail.room.g;
import com.tencent.now.pkgame.pkgame.pklib.model.c;
import com.tencent.qqlive.common.api.AegisLogger;
import g55.au;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016R\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000fR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/now/pkgame/pkgame/pklib/repository/impl/a;", "Lko3/a;", "Lcom/tencent/mobileqq/qqlive/sail/room/g;", "", "roomId", "", "a", "Lcom/tencent/now/pkgame/pkgame/pklib/model/c;", "pushDataListener", "b", "d", "c", "Lfp4/c;", "msgInfo", "onPush", "J", "", "e", "Ljava/util/List;", "pushList", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQCmdPushCallback;", "f", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQCmdPushCallback;", "pkGamePushCallback", "<init>", "()V", h.F, "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class a implements ko3.a, g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<c> pushList = new ArrayList();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IQQCmdPushCallback pkGamePushCallback = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/now/pkgame/pkgame/pklib/repository/impl/a$b", "Lcom/tencent/mobileqq/qqlive/callback/message/IQQCmdPushCallback;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "onFail", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes22.dex */
    public static final class b implements IQQCmdPushCallback {
        b() {
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
        public void onFail(int errCode, @NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            AegisLogger.INSTANCE.e("PK_Biz|PushDataSourceImpl", "pkGamePushCallback", "errCode: " + errCode + ", errMsg: " + errMsg);
        }

        @Override // com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback
        public void onReceive(@NotNull byte[] data) {
            Intrinsics.checkNotNullParameter(data, "data");
            gp4.a c16 = gp4.a.c(data);
            int i3 = c16.f403047a;
            if (i3 != 107) {
                return;
            }
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            companion.i("PK_Biz|PushDataSourceImpl", "Receive pkGamePushPush cmd: " + i3);
            try {
                au auVar = new au();
                MessageNano.mergeFrom(auVar, c16.f403049c);
                companion.i("PK_Biz|PushDataSourceImpl", "pkGamePushCallback, msgType: " + auVar.f401337b);
                int size = a.this.pushList.size();
                for (int i16 = 0; i16 < size; i16++) {
                    ((c) a.this.pushList.get(i16)).a(auVar);
                }
            } catch (InvalidProtocolBufferNanoException e16) {
                AegisLogger.INSTANCE.e("PK_Biz|PushDataSourceImpl", "pkGamePushCallback", "error: " + e16);
            }
        }
    }

    @Override // ko3.a
    public void a(long roomId) {
        this.roomId = roomId;
    }

    @Override // ko3.a
    public void b(@NotNull c pushDataListener) {
        Intrinsics.checkNotNullParameter(pushDataListener, "pushDataListener");
        this.pushList.add(pushDataListener);
    }

    @Override // ko3.a
    public void c() {
        ILiveRoom z16;
        this.pushList.clear();
        f z17 = com.tencent.mobileqq.qqlive.sail.c.z(com.tencent.mobileqq.qqlive.sail.c.f272176a, this.roomId, 0, 2, null);
        if (z17 != null) {
            z17.e(this);
        }
        jg4.b bVar = (jg4.b) mm4.b.b(jg4.b.class);
        if (bVar != null && (z16 = bVar.z(this.roomId)) != null) {
            z16.unRegisterLivePushChannel(this.pkGamePushCallback);
        }
    }

    @Override // ko3.a
    public void d() {
        ILiveRoom z16;
        f z17 = com.tencent.mobileqq.qqlive.sail.c.z(com.tencent.mobileqq.qqlive.sail.c.f272176a, this.roomId, 0, 2, null);
        if (z17 != null) {
            z17.p(285, this);
            return;
        }
        jg4.b bVar = (jg4.b) mm4.b.b(jg4.b.class);
        if (bVar != null && (z16 = bVar.z(this.roomId)) != null) {
            z16.registerLivePushChannel(285, this.pkGamePushCallback);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.room.g
    public void onPush(@NotNull fp4.c msgInfo) {
        Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
        au s16 = com.tencent.mobileqq.qqlive.sail.push.a.s(msgInfo);
        if (s16 != null) {
            AegisLogger.INSTANCE.i("PK_Biz|PushDataSourceImpl", "onPush", "PKMsg, msgType: " + s16.f401337b);
            Iterator<T> it = this.pushList.iterator();
            while (it.hasNext()) {
                ((c) it.next()).a(s16);
            }
        }
    }
}
