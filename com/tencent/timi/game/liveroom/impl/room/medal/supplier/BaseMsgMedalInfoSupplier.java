package com.tencent.timi.game.liveroom.impl.room.medal.supplier;

import com.tencent.mobileqq.qqlive.api.IQQLiveSDKManager;
import com.tencent.mobileqq.qqlive.widget.chat.message.f;
import com.tencent.mobileqq.qqlive.widget.chat.message.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.liveroom.impl.room.medal.d;
import com.tencent.timi.game.liveroom.impl.room.medal.data.QQLiveMedalServiceImpl;
import com.tencent.timi.game.liveroom.impl.room.medal.e;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u001c\u001a\u00020\u0018\u00a2\u0006\u0004\b$\u0010%J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001c\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010 \u001a\u00020\u00188DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u001bR\u0016\u0010#\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/medal/supplier/BaseMsgMedalInfoSupplier;", "Lcom/tencent/timi/game/liveroom/impl/room/medal/e;", "", "uid", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/f;", "msg", "Lcom/tencent/timi/game/liveroom/impl/room/medal/e$a;", "callback", "", "c", "Lcom/tencent/mobileqq/qqlive/widget/chat/data/b;", "medalInfo", "g", "a", "J", "getRoomId", "()J", "roomId", "", "b", "I", "f", "()I", "roomType", "", "Ljava/lang/String;", "getAppId", "()Ljava/lang/String;", "appId", "d", "Lkotlin/Lazy;", "e", "logTag", "Lcom/tencent/timi/game/liveroom/impl/room/medal/d;", "Lcom/tencent/timi/game/liveroom/impl/room/medal/d;", "liveMedalService", "<init>", "(JILjava/lang/String;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public abstract class BaseMsgMedalInfoSupplier implements e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long roomId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int roomType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String appId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy logTag;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.timi.game.liveroom.impl.room.medal.d liveMedalService;

    public BaseMsgMedalInfoSupplier(long j3, int i3, @NotNull String appId) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(appId, "appId");
        this.roomId = j3;
        this.roomType = i3;
        this.appId = appId;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.timi.game.liveroom.impl.room.medal.supplier.BaseMsgMedalInfoSupplier$logTag$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return "Medal_Info|" + BaseMsgMedalInfoSupplier.this.getClass().getSimpleName();
            }
        });
        this.logTag = lazy;
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i(e(), "init", "appId=" + appId);
        if (((IQQLiveSDKManager) QRoute.api(IQQLiveSDKManager.class)).getSDKImpl(appId) == null) {
            companion.i(e(), "init", "sdk is null");
        }
        this.liveMedalService = new QQLiveMedalServiceImpl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(e.a callback, f msg2, long j3, BaseMsgMedalInfoSupplier this$0, com.tencent.mobileqq.qqlive.widget.chat.data.b bVar) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (bVar == null) {
            callback.a(msg2, null);
            return;
        }
        if (j3 != bVar.f273756a) {
            AegisLogger.INSTANCE.i(this$0.e(), "fetchMedalInfoManually", "uid illegal, uid=" + j3 + ",medalUserId=" + bVar.f273756a);
            callback.a(msg2, null);
            return;
        }
        AegisLogger.INSTANCE.i(this$0.e(), "fetchMedalInfoManually", "getUserMedalAsync=" + bVar);
        this$0.g(msg2, bVar);
        callback.a(msg2, bVar);
    }

    public final void c(final long uid, @NotNull final f msg2, @NotNull final e.a callback) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (uid == -1) {
            callback.a(msg2, null);
            AegisLogger.INSTANCE.i(e(), "fetchMedalInfoManually", "uid is illegal uid=" + uid);
            return;
        }
        com.tencent.mobileqq.qqlive.widget.chat.data.b b16 = this.liveMedalService.b(uid, this.roomId, this.roomType);
        if (b16 != null) {
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            if (companion.isColorLevel()) {
                companion.i(e(), "fetchMedalInfoManually", "localUserMedalInfo=" + b16);
            }
            g(msg2, b16);
            callback.a(msg2, b16);
            return;
        }
        this.liveMedalService.a(uid, this.roomId, this.roomType, new d.a() { // from class: com.tencent.timi.game.liveroom.impl.room.medal.supplier.a
            @Override // com.tencent.timi.game.liveroom.impl.room.medal.d.a
            public final void a(com.tencent.mobileqq.qqlive.widget.chat.data.b bVar) {
                BaseMsgMedalInfoSupplier.d(e.a.this, msg2, uid, this, bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final String e() {
        return (String) this.logTag.getValue();
    }

    /* renamed from: f, reason: from getter */
    public final int getRoomType() {
        return this.roomType;
    }

    public final void g(@NotNull f msg2, @NotNull com.tencent.mobileqq.qqlive.widget.chat.data.b medalInfo) {
        com.tencent.mobileqq.qqlive.widget.chat.data.a aVar;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(medalInfo, "medalInfo");
        i header = msg2.getHeader();
        if (header != null) {
            aVar = header.a();
        } else {
            aVar = null;
        }
        if (aVar != null) {
            aVar.f273754a = medalInfo;
        }
    }
}
