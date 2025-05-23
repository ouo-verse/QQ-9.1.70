package com.tencent.mobileqq.nearbypro.aio.processor;

import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.api.IAIOApi;
import com.tencent.mobileqq.friend.api.IFriendNameService;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.nearbypro.aio.event.NearbyProAioMsgEvent;
import com.tencent.mobileqq.nearbypro.aio.request.AIONetworkHelper;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IGetTempChatInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.TempChatInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.xweb.FileReaderHelper;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\t\b\u0002\u00a2\u0006\u0004\b(\u0010)J2\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0002J$\u0010\u0011\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000f0\u000ej\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000f`\u0010H\u0016J\u0012\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0016J*\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016JE\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0018\u001a\u00020\f2!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00130\u0019JH\u0010\"\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u000628\u0010\u001c\u001a4\u0012\u0013\u0012\u00110 \u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(!\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00130\u001fR\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010#R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010#R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/aio/processor/NearByProTempProcessor;", "", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Landroid/content/Context;", "ctx", "", "tinyID", "uid", "Landroid/os/Bundle;", "bundle", "nickname", "", "e", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "event", "", "onReceiveEvent", "d", "peerUin", "peerNickname", FileReaderHelper.OPEN_FILE_FROM_FORCE, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "cb", "f", "peerUid", "Lkotlin/Function2;", "", PreloadTRTCPlayerParams.KEY_SIG, "c", "Ljava/lang/String;", "Lz92/a;", h.F, "Lz92/a;", "converter", "<init>", "()V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NearByProTempProcessor implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final NearByProTempProcessor f253128d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static String tinyID;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static String nickname;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final z92.a converter;

    static {
        NearByProTempProcessor nearByProTempProcessor = new NearByProTempProcessor();
        f253128d = nearByProTempProcessor;
        tinyID = "";
        converter = new z92.a();
        SimpleEventBus.getInstance().registerReceiver(nearByProTempProcessor);
    }

    NearByProTempProcessor() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e(Context ctx, String tinyID2, String uid, Bundle bundle, String nickname2) {
        AppInterface appInterface;
        String str;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface == null) {
            return false;
        }
        IRuntimeService runtimeService = appInterface.getRuntimeService(IFriendNameService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IF\u2026va, ProcessConstant.MAIN)");
        IFriendNameService iFriendNameService = (IFriendNameService) runtimeService;
        if (nickname2 == null) {
            nickname2 = iFriendNameService.getFriendName(tinyID2);
        }
        if (nickname2 == null) {
            str = tinyID2;
        } else {
            str = nickname2;
        }
        bundle.putString("key_peerId", uid);
        bundle.putInt("key_chat_type", 119);
        bundle.putString("key_chat_name", str);
        bundle.putBoolean("key_is_scale_chat", false);
        ((IAIOApi) QRoute.api(IAIOApi.class)).startChatAndRecordTask(ctx, tinyID2, 119, str, bundle, 2);
        j.c().e("NearByProTempProcessor", "openMsgAio-openTempAio " + tinyID2);
        return true;
    }

    public static /* synthetic */ void g(NearByProTempProcessor nearByProTempProcessor, String str, String str2, boolean z16, Function1 function1, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        nearByProTempProcessor.f(str, str2, z16, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(boolean z16, Function1 cb5, String peerUin, String str, AppInterface appInterface, w msgService, int i3, String str2, TempChatInfo tempChatInfo) {
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        Intrinsics.checkNotNullParameter(peerUin, "$peerUin");
        Intrinsics.checkNotNullParameter(appInterface, "$appInterface");
        Intrinsics.checkNotNullParameter(msgService, "$msgService");
        if (!z16 && i3 == 0) {
            j.c().e("NearByProTempProcessor", "prepareTempChat local sign is valid!");
            cb5.invoke(peerUin);
        } else {
            f253128d.c(peerUin, new NearByProTempProcessor$prepareTempChat$1$1(str, appInterface, msgService, cb5));
        }
    }

    public final void c(@NotNull final String peerUid, @NotNull final Function2<? super byte[], ? super String, Unit> cb5) {
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        AIONetworkHelper.f253140a.j(peerUid, new Function1<byte[], Unit>() { // from class: com.tencent.mobileqq.nearbypro.aio.processor.NearByProTempProcessor$getAioSign$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(byte[] bArr) {
                invoke2(bArr);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull byte[] token) {
                Intrinsics.checkNotNullParameter(token, "token");
                cb5.invoke(token, peerUid);
            }
        });
    }

    public void d(@NotNull final Context ctx, @NotNull final String tinyID2, @NotNull final Bundle bundle, @Nullable final String nickname2) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(tinyID2, "tinyID");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        tinyID = tinyID2;
        nickname = nickname2;
        g(this, tinyID2, nickname2, false, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.nearbypro.aio.processor.NearByProTempProcessor$openMsgAio$1
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
            public final void invoke2(@NotNull String uid) {
                Intrinsics.checkNotNullParameter(uid, "uid");
                NearByProTempProcessor.f253128d.e(ctx, tinyID2, uid, bundle, nickname2);
            }
        }, 4, null);
    }

    public final void f(@NotNull final String peerUin, @Nullable final String peerNickname, final boolean force, @NotNull final Function1<? super String, Unit> cb5) {
        final w msgService;
        Intrinsics.checkNotNullParameter(peerUin, "peerUin");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (msgService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")).getMsgService()) == null) {
            return;
        }
        AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime2, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        final AppInterface appInterface = (AppInterface) peekAppRuntime2;
        msgService.getTempChatInfo(119, peerUin, new IGetTempChatInfoCallback() { // from class: com.tencent.mobileqq.nearbypro.aio.processor.a
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetTempChatInfoCallback
            public final void onResult(int i3, String str, TempChatInfo tempChatInfo) {
                NearByProTempProcessor.h(force, cb5, peerUin, peerNickname, appInterface, msgService, i3, str, tempChatInfo);
            }
        });
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(NearbyProAioMsgEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        String str;
        if (event instanceof NearbyProAioMsgEvent) {
            NearbyProAioMsgEvent nearbyProAioMsgEvent = (NearbyProAioMsgEvent) event;
            Contact peer = nearbyProAioMsgEvent.getPeer();
            if (peer != null) {
                str = peer.peerUid;
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str, tinyID) && nearbyProAioMsgEvent.getErrorCode() != 0 && nearbyProAioMsgEvent.getErrorCode() == 48) {
                f(tinyID, nickname, true, new Function1<String, Unit>() { // from class: com.tencent.mobileqq.nearbypro.aio.processor.NearByProTempProcessor$onReceiveEvent$1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull String it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                        invoke2(str2);
                        return Unit.INSTANCE;
                    }
                });
            }
        }
    }
}
