package com.tencent.mobileqq.gamecenter.api.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.view.ViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.api.IGameMsgCardApi;
import com.tencent.mobileqq.gamecenter.api.IGameQQPlayerUtilApi;
import com.tencent.mobileqq.gamecenter.protocols.GameCenterUnissoHandler;
import com.tencent.mobileqq.gamecenter.trpcprotocol.SgamePartnerSvr$GetGameMsgPartnersRsp;
import com.tencent.mobileqq.gamecenter.trpcprotocol.SgamePartnerSvr$OpenAIORsp;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 /2\u00020\u0001:\u00010B\u0007\u00a2\u0006\u0004\b-\u0010.J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001b\u001a\u00020\bH\u0016J\u0012\u0010\u001e\u001a\u00020\b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J\u0018\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u001c\u0010%\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\u00022\b\u0010$\u001a\u0004\u0018\u00010\u0002H\u0016R\u0018\u0010&\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010(\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/api/impl/GameMsgCardApiImpl;", "Lcom/tencent/mobileqq/gamecenter/api/IGameMsgCardApi;", "", "cmd", "", "ret", "Lcom/tencent/gamecenter/wadl/biz/entity/TrpcProxy$TrpcInovkeRsp;", "rsp", "", "onGetOpenAioData", "Lcom/tencent/mobileqq/gamecenter/trpcprotocol/SgamePartnerSvr$OpenAIORsp;", "params", "openQQPlayerAio", "", "resId", "showQQToast", "", "isMainProcess", "Lcom/tencent/mobileqq/gamecenter/api/f;", "listener", "onGameBoxCreate", "onGameBoxDestroy", "onGameCardRemoved", "Lcom/tencent/qqnt/chats/core/data/a;", "builder", "Lke1/a;", "createGameBoxChatsListAdapter", "reqGameCardInfo", "Lcom/tencent/mobileqq/gamecenter/trpcprotocol/SgamePartnerSvr$GetGameMsgPartnersRsp;", "cardInfo", "onGetGameCardInfo", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", "createGameCardView", "fromOpenId", "toOpenId", "openGameMsgAioInMainProcess", "gameMsgCardListener", "Lcom/tencent/mobileqq/gamecenter/api/f;", "isGameBoxDestroyed", "Z", "Lke1/i;", "gameCardCreator", "Lke1/i;", "<init>", "()V", "Companion", "a", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GameMsgCardApiImpl implements IGameMsgCardApi {

    @NotNull
    private static final String TAG = "GameMsgCardApiImpl";

    @NotNull
    private ke1.i gameCardCreator = new ke1.i();

    @Nullable
    private com.tencent.mobileqq.gamecenter.api.f gameMsgCardListener;
    private boolean isGameBoxDestroyed;

    /* compiled from: P */
    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016J.\u0010\u000e\u001a\u00020\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/gamecenter/api/impl/GameMsgCardApiImpl$b", "Lcom/tencent/gamecenter/wadl/biz/listener/WadlTrpcListener;", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getFilterCmds", "Landroid/content/Intent;", Const.BUNDLE_KEY_REQUEST, "cmd", "", "ret", "Lcom/tencent/gamecenter/wadl/biz/entity/TrpcProxy$TrpcInovkeRsp;", "rsp", "", "onTrpcRsp", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements WadlTrpcListener {
        b() {
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        @NotNull
        public HashSet<String> getFilterCmds() {
            HashSet<String> hashSetOf;
            hashSetOf = SetsKt__SetsKt.hashSetOf("/v1/1694");
            return hashSetOf;
        }

        @Override // com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener
        public void onTrpcRsp(@Nullable Intent request, @Nullable String cmd, long ret, @Nullable TrpcProxy.TrpcInovkeRsp rsp) {
            if (!GameMsgCardApiImpl.this.isGameBoxDestroyed) {
                GameMsgCardApiImpl.this.onGetOpenAioData(cmd, ret, rsp);
            }
        }
    }

    private final boolean isMainProcess() {
        if (MobileQQ.sProcessId == 1) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onGetOpenAioData(String cmd, long ret, TrpcProxy.TrpcInovkeRsp rsp) {
        try {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "cmd:" + cmd + " ret:" + ret);
            }
            if (ret == 0 && rsp != null && rsp.data.has()) {
                SgamePartnerSvr$OpenAIORsp sgamePartnerSvr$OpenAIORsp = new SgamePartnerSvr$OpenAIORsp();
                sgamePartnerSvr$OpenAIORsp.mergeFrom(rsp.data.get().toByteArray());
                openQQPlayerAio(sgamePartnerSvr$OpenAIORsp);
                return;
            }
            QLog.e(TAG, 1, "request is null.");
            showQQToast(R.string.f1373906q);
        } catch (Throwable th5) {
            QLog.d("QQGameCenterKuiklyModule", 1, "onGetOpenAioData e: " + th5);
            showQQToast(R.string.f1373906q);
        }
    }

    private final void openQQPlayerAio(SgamePartnerSvr$OpenAIORsp params) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        long j3;
        String str6;
        String str7;
        String str8;
        BaseApplication context = BaseApplication.getContext();
        AppInterface appInterface = HippyUtils.getAppInterface();
        IGameQQPlayerUtilApi iGameQQPlayerUtilApi = (IGameQQPlayerUtilApi) QRoute.api(IGameQQPlayerUtilApi.class);
        PBStringField pBStringField = params.from_role_id;
        if (pBStringField != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        PBStringField pBStringField2 = params.from_openid;
        if (pBStringField2 != null) {
            str2 = pBStringField2.get();
        } else {
            str2 = null;
        }
        PBStringField pBStringField3 = params.to_role_id;
        if (pBStringField3 != null) {
            str3 = pBStringField3.get();
        } else {
            str3 = null;
        }
        PBStringField pBStringField4 = params.to_openid;
        if (pBStringField4 != null) {
            str4 = pBStringField4.get();
        } else {
            str4 = null;
        }
        PBStringField pBStringField5 = params.sig;
        if (pBStringField5 != null) {
            str5 = pBStringField5.get();
        } else {
            str5 = null;
        }
        PBStringField pBStringField6 = params.appid;
        if (pBStringField6 != null && (str8 = pBStringField6.get()) != null) {
            j3 = Long.parseLong(str8);
        } else {
            j3 = 0;
        }
        PBStringField pBStringField7 = params.from_tinyid;
        if (pBStringField7 != null) {
            str6 = pBStringField7.get();
        } else {
            str6 = null;
        }
        PBStringField pBStringField8 = params.to_tinyid;
        if (pBStringField8 != null) {
            str7 = pBStringField8.get();
        } else {
            str7 = null;
        }
        iGameQQPlayerUtilApi.openGameMsgAIO(appInterface, context, str, str2, str3, str4, "", str5, j3, str6, str7, 0, 0, "{\"is_show_partner_ui\":true}");
    }

    private final void showQQToast(final int resId) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            QQToast.makeText(BaseApplication.getContext(), resId, 0).show();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.gamecenter.api.impl.aa
                @Override // java.lang.Runnable
                public final void run() {
                    GameMsgCardApiImpl.showQQToast$lambda$0(resId);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showQQToast$lambda$0(int i3) {
        QQToast.makeText(BaseApplication.getContext(), i3, 0).show();
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgCardApi
    @NotNull
    public ViewGroup createGameCardView(@NotNull Context context, @NotNull SgamePartnerSvr$GetGameMsgPartnersRsp cardInfo) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cardInfo, "cardInfo");
        return this.gameCardCreator.k(context, cardInfo);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgCardApi
    public void onGameBoxCreate(@NotNull com.tencent.mobileqq.gamecenter.api.f listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.gameMsgCardListener = listener;
        this.isGameBoxDestroyed = false;
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgCardApi
    public void onGameBoxDestroy() {
        this.gameMsgCardListener = null;
        this.isGameBoxDestroyed = true;
        this.gameCardCreator.p();
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgCardApi
    public void onGameCardRemoved() {
        com.tencent.mobileqq.gamecenter.api.f fVar = this.gameMsgCardListener;
        if (fVar != null) {
            fVar.onGameCardRemoved();
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgCardApi
    public void onGetGameCardInfo(@Nullable SgamePartnerSvr$GetGameMsgPartnersRsp cardInfo) {
        com.tencent.mobileqq.gamecenter.api.f fVar;
        if (!this.isGameBoxDestroyed && (fVar = this.gameMsgCardListener) != null) {
            fVar.onGetGameCardInfo(cardInfo);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgCardApi
    public void openGameMsgAioInMainProcess(@Nullable String fromOpenId, @Nullable String toOpenId) {
        boolean z16;
        boolean z17 = false;
        QLog.d(TAG, 1, "click JumpButton fromId:", fromOpenId, " toId:", toOpenId);
        if (!isMainProcess()) {
            QLog.e(TAG, 1, "openGameMsgAioInMainProcess not in main process");
            return;
        }
        if (fromOpenId != null && fromOpenId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            if (toOpenId == null || toOpenId.length() == 0) {
                z17 = true;
            }
            if (!z17) {
                GameCenterUnissoHandler.N2().t3(fromOpenId, toOpenId, new b());
                return;
            }
        }
        showQQToast(R.string.f1374006r);
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgCardApi
    public void reqGameCardInfo() {
        GameCenterUnissoHandler.N2().reqGameCardInfo();
    }

    @Override // com.tencent.mobileqq.gamecenter.api.IGameMsgCardApi
    @NotNull
    public ke1.a createGameBoxChatsListAdapter(@NotNull com.tencent.qqnt.chats.core.data.a builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        return new ke1.a(builder);
    }
}
