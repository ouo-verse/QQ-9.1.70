package com.tencent.mobileqq.zplan.room.impl.entry;

import android.text.TextUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.z1.base.openId.ZootopiaOpenIdResult;
import com.tencent.mobileqq.zootopia.openid.ZootopiaOpenIdSilentHelper;
import com.tencent.mobileqq.zplan.room.impl.constant.ZPlanJoinRoomType;
import com.tencent.mobileqq.zplan.room.impl.constant.ZPlanRoomInitData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.w;
import com.tencent.util.QQToastUtil;
import iv4.b;
import iv4.e;
import jk3.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import lv4.d;
import lv4.g;
import lv4.k;
import lv4.l;
import tl.h;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J$\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002J$\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0004H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0002H\u0002J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0002H\u0002J2\u0010\u001c\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0019\u001a\u00020\u00112\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aJ>\u0010 \u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u00022\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001aJ \u0010\"\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010\u001aJ \u0010$\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u001a\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/zplan/room/impl/entry/ZPlanRoomEntryUtil;", "", "", "roomId", "Lkotlin/Function1;", "", "", "callback", "l", "openId", "k", "selfOpenId", "Lkv4/a;", "g", "Liv4/e;", "f", "defaultErrMsg", "", "error", "message", h.F, "msg", "p", "o", "componentId", "roomType", "Lcom/tencent/mobileqq/zootopia/api/e;", "Llv4/b;", "i", "zplanRoomId", "extraUniqueRoomId", "Llv4/h;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Llv4/l;", DomainData.DOMAIN_NAME, "Llv4/d;", "j", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanRoomEntryUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final ZPlanRoomEntryUtil f335187a = new ZPlanRoomEntryUtil();

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/room/impl/entry/ZPlanRoomEntryUtil$a", "Lcom/tencent/mobileqq/zootopia/openid/a;", "Lcom/tencent/mobileqq/z1/base/openId/ZootopiaOpenIdResult;", "result", "", "a", "", "errCode", "", "errMsg", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements com.tencent.mobileqq.zootopia.openid.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<String, Unit> f335188a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f335189b;

        /* JADX WARN: Multi-variable type inference failed */
        a(Function1<? super String, Unit> function1, String str) {
            this.f335188a = function1;
            this.f335189b = str;
        }

        @Override // com.tencent.mobileqq.zootopia.openid.a
        public void a(ZootopiaOpenIdResult result) {
            String str;
            ZPlanRoomEntryUtil.f335187a.o("ensureOpenId onOpenIdResult - " + (result != null ? result.getOpenId() : null));
            Function1<String, Unit> function1 = this.f335188a;
            if (result == null || (str = result.getOpenId()) == null) {
                str = this.f335189b;
            }
            function1.invoke(str);
        }

        @Override // com.tencent.mobileqq.zootopia.openid.a
        public void b(int errCode, String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            ZPlanRoomEntryUtil.f335187a.o("ensureOpenId onOpenIdError - errCode= " + errCode + ", " + errMsg);
            this.f335188a.invoke(this.f335189b);
        }
    }

    ZPlanRoomEntryUtil() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e f(String roomId) {
        e eVar = new e();
        b bVar = new b();
        bVar.f408810a = roomId;
        eVar.f408820a = bVar;
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kv4.a g(String selfOpenId) {
        Long longOrNull;
        kv4.a aVar = new kv4.a();
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(w.f373306a.b());
        aVar.f413322a = longOrNull != null ? longOrNull.longValue() : 0L;
        aVar.f413323b = selfOpenId;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(String defaultErrMsg, int error, String message) {
        if (!TextUtils.isEmpty(message)) {
            QQToastUtil.showQQToast(1, message);
        } else {
            QQToastUtil.showQQToast(1, defaultErrMsg);
        }
    }

    private final void k(String openId, Function1<? super String, Unit> callback) {
        if (!TextUtils.isEmpty(openId)) {
            callback.invoke(openId);
            return;
        }
        o("ensureOpenId empty! - " + openId);
        ZootopiaOpenIdSilentHelper.i(ZootopiaOpenIdSilentHelper.INSTANCE.a(), new a(callback, openId), false, 2, null);
    }

    private final void l(String roomId, Function1<? super Boolean, Unit> callback) {
        c d16 = jk3.a.f410333a.d(roomId);
        if (d16 == null) {
            callback.invoke(Boolean.TRUE);
        } else {
            d16.l(callback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(String msg2) {
        QLog.e("ZPlanRoom_EntryUtil", 1, msg2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(String msg2) {
        QLog.i("ZPlanRoom_EntryUtil", 1, msg2);
    }

    public final void i(String openId, final String componentId, final int roomType, final com.tencent.mobileqq.zootopia.api.e<lv4.b> callback) {
        Intrinsics.checkNotNullParameter(openId, "openId");
        k(openId, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.zplan.room.impl.entry.ZPlanRoomEntryUtil$createRoom$1

            @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/room/impl/entry/ZPlanRoomEntryUtil$createRoom$1$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Llv4/b;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes34.dex */
            public static final class a implements com.tencent.mobileqq.zootopia.api.e<lv4.b> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ kv4.a f335190d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<lv4.b> f335191e;

                a(kv4.a aVar, com.tencent.mobileqq.zootopia.api.e<lv4.b> eVar) {
                    this.f335190d = aVar;
                    this.f335191e = eVar;
                }

                @Override // com.tencent.mobileqq.zootopia.api.e
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onResultSuccess(lv4.b result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    ZPlanRoomInitData a16 = ZPlanRoomInitData.INSTANCE.a(result);
                    ZPlanRoomEntryUtil.f335187a.p("createRoom success - " + (a16 != null ? a16.getRoomId() : null));
                    if (a16 != null) {
                        jk3.a.f410333a.h(ZPlanJoinRoomType.CREATE, this.f335190d, a16);
                        com.tencent.mobileqq.zootopia.api.e<lv4.b> eVar = this.f335191e;
                        if (eVar != null) {
                            eVar.onResultSuccess(result);
                            return;
                        }
                        return;
                    }
                    onResultFailure(-88801, null);
                }

                @Override // com.tencent.mobileqq.zootopia.api.e
                public void onResultFailure(int error, String message) {
                    ZPlanRoomEntryUtil zPlanRoomEntryUtil = ZPlanRoomEntryUtil.f335187a;
                    zPlanRoomEntryUtil.o("createRoom error - " + error + " - " + message);
                    zPlanRoomEntryUtil.h("\u521b\u5efa\u5931\u8d25, \u8bf7\u7a0d\u540e\u91cd\u8bd5", error, message);
                    com.tencent.mobileqq.zootopia.api.e<lv4.b> eVar = this.f335191e;
                    if (eVar != null) {
                        eVar.onResultFailure(error, message);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String finalOpenId) {
                kv4.a g16;
                Intrinsics.checkNotNullParameter(finalOpenId, "finalOpenId");
                ZPlanRoomEntryUtil zPlanRoomEntryUtil = ZPlanRoomEntryUtil.f335187a;
                g16 = zPlanRoomEntryUtil.g(finalOpenId);
                lv4.a aVar = new lv4.a();
                int i3 = roomType;
                String str = componentId;
                aVar.f415636b = g16;
                e eVar = new e();
                b bVar = new b();
                bVar.f408812c = g16;
                bVar.f408811b = i3;
                bVar.f408814e = str;
                eVar.f408820a = bVar;
                aVar.f415635a = eVar;
                zPlanRoomEntryUtil.p("createRoom BEGIN, openId= " + finalOpenId + ", componentId= " + componentId + ", roomType= " + roomType);
                lk3.a.b(lk3.a.f414963a, aVar, new a(g16, callback), 0, 4, null);
            }
        });
    }

    public final void j(final String roomId, final com.tencent.mobileqq.zootopia.api.e<d> callback) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        if (TextUtils.isEmpty(roomId)) {
            o("destroyRoom_" + roomId + " direct return!");
            if (callback != null) {
                callback.onResultSuccess(new d());
                return;
            }
            return;
        }
        p("destroyRoom_" + roomId + " BEGIN");
        l(roomId, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.room.impl.entry.ZPlanRoomEntryUtil$destroyRoom$1

            @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/room/impl/entry/ZPlanRoomEntryUtil$destroyRoom$1$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Llv4/d;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes34.dex */
            public static final class a implements com.tencent.mobileqq.zootopia.api.e<d> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f335192d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<d> f335193e;

                a(String str, com.tencent.mobileqq.zootopia.api.e<d> eVar) {
                    this.f335192d = str;
                    this.f335193e = eVar;
                }

                @Override // com.tencent.mobileqq.zootopia.api.e
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onResultSuccess(d result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    ZPlanRoomEntryUtil.f335187a.p("destroyRoom_" + this.f335192d + " success");
                    com.tencent.mobileqq.zootopia.api.e<d> eVar = this.f335193e;
                    if (eVar != null) {
                        eVar.onResultSuccess(result);
                    }
                    jk3.a.f410333a.g(this.f335192d);
                }

                @Override // com.tencent.mobileqq.zootopia.api.e
                public void onResultFailure(int error, String message) {
                    ZPlanRoomEntryUtil zPlanRoomEntryUtil = ZPlanRoomEntryUtil.f335187a;
                    zPlanRoomEntryUtil.o("destroyRoom_" + this.f335192d + " error - " + error + " - " + message);
                    zPlanRoomEntryUtil.h("\u5173\u95ed\u5931\u8d25, \u8bf7\u7a0d\u540e\u91cd\u8bd5", error, message);
                    com.tencent.mobileqq.zootopia.api.e<d> eVar = this.f335193e;
                    if (eVar != null) {
                        eVar.onResultFailure(error, message);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                e f16;
                ZPlanRoomEntryUtil zPlanRoomEntryUtil = ZPlanRoomEntryUtil.f335187a;
                zPlanRoomEntryUtil.p("destroyRoom_" + roomId + " checkResult - " + z16);
                if (z16) {
                    lv4.c cVar = new lv4.c();
                    f16 = zPlanRoomEntryUtil.f(roomId);
                    cVar.f415639a = f16;
                    lk3.a.d(lk3.a.f414963a, cVar, new a(roomId, callback), 0, 4, null);
                }
            }
        });
    }

    public final void m(final String zplanRoomId, final String extraUniqueRoomId, final String componentId, String openId, final com.tencent.mobileqq.zootopia.api.e<lv4.h> callback) {
        Intrinsics.checkNotNullParameter(openId, "openId");
        k(openId, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.zplan.room.impl.entry.ZPlanRoomEntryUtil$joinRoom$1

            @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/room/impl/entry/ZPlanRoomEntryUtil$joinRoom$1$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Llv4/h;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes34.dex */
            public static final class a implements com.tencent.mobileqq.zootopia.api.e<lv4.h> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ kv4.a f335194d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<lv4.h> f335195e;

                a(kv4.a aVar, com.tencent.mobileqq.zootopia.api.e<lv4.h> eVar) {
                    this.f335194d = aVar;
                    this.f335195e = eVar;
                }

                @Override // com.tencent.mobileqq.zootopia.api.e
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onResultSuccess(lv4.h result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    ZPlanRoomInitData b16 = ZPlanRoomInitData.INSTANCE.b(result);
                    ZPlanRoomEntryUtil.f335187a.p("joinRoom success - " + (b16 != null ? b16.getRoomId() : null));
                    if (b16 != null) {
                        jk3.a.f410333a.h(ZPlanJoinRoomType.JOIN, this.f335194d, b16);
                        com.tencent.mobileqq.zootopia.api.e<lv4.h> eVar = this.f335195e;
                        if (eVar != null) {
                            eVar.onResultSuccess(result);
                            return;
                        }
                        return;
                    }
                    onResultFailure(-88801, null);
                }

                @Override // com.tencent.mobileqq.zootopia.api.e
                public void onResultFailure(int error, String message) {
                    ZPlanRoomEntryUtil zPlanRoomEntryUtil = ZPlanRoomEntryUtil.f335187a;
                    zPlanRoomEntryUtil.o("joinRoom error - " + error + " - " + message);
                    zPlanRoomEntryUtil.h("\u52a0\u5165\u5931\u8d25, \u8bf7\u7a0d\u540e\u91cd\u8bd5", error, message);
                    com.tencent.mobileqq.zootopia.api.e<lv4.h> eVar = this.f335195e;
                    if (eVar != null) {
                        eVar.onResultFailure(error, message);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String finalOpenId) {
                kv4.a g16;
                Intrinsics.checkNotNullParameter(finalOpenId, "finalOpenId");
                ZPlanRoomEntryUtil zPlanRoomEntryUtil = ZPlanRoomEntryUtil.f335187a;
                g16 = zPlanRoomEntryUtil.g(finalOpenId);
                g gVar = new g();
                String str = zplanRoomId;
                String str2 = extraUniqueRoomId;
                String str3 = componentId;
                gVar.f415648b = g16;
                e eVar = new e();
                b bVar = new b();
                if (!TextUtils.isEmpty(str)) {
                    bVar.f408810a = str;
                }
                if (!TextUtils.isEmpty(str2)) {
                    bVar.f408815f = str2;
                }
                if (!TextUtils.isEmpty(str3)) {
                    bVar.f408814e = str3;
                }
                eVar.f408820a = bVar;
                gVar.f415647a = eVar;
                zPlanRoomEntryUtil.p("joinRoom, zplanRoomId=" + zplanRoomId + ", extraUniqueRoomId= " + extraUniqueRoomId + ", componentId= " + componentId + ", BEGIN, openId= " + finalOpenId);
                lk3.a.h(lk3.a.f414963a, gVar, new a(g16, callback), 0, 4, null);
            }
        });
    }

    public final void n(final String roomId, final com.tencent.mobileqq.zootopia.api.e<l> callback) {
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        if (TextUtils.isEmpty(roomId)) {
            o("leaveRoom_" + roomId + " direct return!");
            if (callback != null) {
                callback.onResultSuccess(new l());
                return;
            }
            return;
        }
        p("leaveRoom_" + roomId + " BEGIN");
        l(roomId, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zplan.room.impl.entry.ZPlanRoomEntryUtil$leaveRoom$1

            @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/zplan/room/impl/entry/ZPlanRoomEntryUtil$leaveRoom$1$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Llv4/l;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes34.dex */
            public static final class a implements com.tencent.mobileqq.zootopia.api.e<l> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f335196d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<l> f335197e;

                a(String str, com.tencent.mobileqq.zootopia.api.e<l> eVar) {
                    this.f335196d = str;
                    this.f335197e = eVar;
                }

                @Override // com.tencent.mobileqq.zootopia.api.e
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onResultSuccess(l result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    ZPlanRoomEntryUtil.f335187a.p("leaveRoom_" + this.f335196d + " success");
                    com.tencent.mobileqq.zootopia.api.e<l> eVar = this.f335197e;
                    if (eVar != null) {
                        eVar.onResultSuccess(result);
                    }
                    jk3.a.f410333a.g(this.f335196d);
                }

                @Override // com.tencent.mobileqq.zootopia.api.e
                public void onResultFailure(int error, String message) {
                    ZPlanRoomEntryUtil zPlanRoomEntryUtil = ZPlanRoomEntryUtil.f335187a;
                    zPlanRoomEntryUtil.o("leaveRoom_" + this.f335196d + " error - " + error + " - " + message);
                    zPlanRoomEntryUtil.h("\u9000\u51fa\u5931\u8d25, \u8bf7\u7a0d\u540e\u91cd\u8bd5", error, message);
                    com.tencent.mobileqq.zootopia.api.e<l> eVar = this.f335197e;
                    if (eVar != null) {
                        eVar.onResultFailure(error, message);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                e f16;
                ZPlanRoomEntryUtil zPlanRoomEntryUtil = ZPlanRoomEntryUtil.f335187a;
                zPlanRoomEntryUtil.p("leaveRoom_" + roomId + " checkResult - " + z16);
                if (z16) {
                    k kVar = new k();
                    f16 = zPlanRoomEntryUtil.f(roomId);
                    kVar.f415660a = f16;
                    lk3.a.l(lk3.a.f414963a, kVar, new a(roomId, callback), 0, 4, null);
                }
            }
        });
    }
}
