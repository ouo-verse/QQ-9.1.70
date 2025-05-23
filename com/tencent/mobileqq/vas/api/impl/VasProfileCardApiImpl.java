package com.tencent.mobileqq.vas.api.impl;

import SummaryCardTaf.SSummaryCardRsp;
import android.os.Bundle;
import android.util.Pair;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.profilecard.servlet.ProfileCardServlet;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.dr;
import com.tencent.mobileqq.utils.ea;
import com.tencent.mobileqq.vas.api.IVasProfileCardApi;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCCallback;
import eipc.EIPCResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v23.Node;
import v23.Status;
import v23.StatusNode;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b2\u00103J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J(\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J:\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\u001b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0016R$\u0010\u001c\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010\"\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u0017\u0010)\u001a\u00020(8\u0006\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0017\u0010.\u001a\u00020-8\u0006\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/VasProfileCardApiImpl;", "Lcom/tencent/mobileqq/vas/api/IVasProfileCardApi;", "Lcom/tencent/mobileqq/app/QQAppInterface;", "qqApp", "Leipc/EIPCCallback;", "callback", "", "getSummaryCard", "", "currentId", "styleId", "", "backgroundUrl", "", "result", "Leipc/EIPCResult;", "buildCardInfoResult", "Lx23/c;", "createReportChain", "layoutId", "backgroundId", "cardId", "extInfo", "diyTemplate", "setProfileCard", "", "forceRequest", "getCardInfo", "chain", "Lx23/c;", "getChain", "()Lx23/c;", "setChain", "(Lx23/c;)V", "mCallback", "Leipc/EIPCCallback;", "getMCallback", "()Leipc/EIPCCallback;", "setMCallback", "(Leipc/EIPCCallback;)V", "Lcom/tencent/mobileqq/app/CardObserver;", "cardObserver", "Lcom/tencent/mobileqq/app/CardObserver;", "getCardObserver", "()Lcom/tencent/mobileqq/app/CardObserver;", "Lcom/tencent/mobileqq/profilecard/observer/ProfileCardObserver;", "profileCardObserver", "Lcom/tencent/mobileqq/profilecard/observer/ProfileCardObserver;", "getProfileCardObserver", "()Lcom/tencent/mobileqq/profilecard/observer/ProfileCardObserver;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasProfileCardApiImpl implements IVasProfileCardApi {

    @Nullable
    private x23.c chain;

    @Nullable
    private EIPCCallback mCallback;

    @NotNull
    private final CardObserver cardObserver = new a();

    @NotNull
    private final ProfileCardObserver profileCardObserver = new b();

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/vas/api/impl/VasProfileCardApiImpl$a", "Lcom/tencent/mobileqq/app/CardObserver;", "", "isSuccess", "", "obj", "", "onSetCardTemplateReturn", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a extends CardObserver {
        a() {
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        public void onSetCardTemplateReturn(boolean isSuccess, @Nullable Object obj) {
            Integer num;
            SSummaryCardRsp sSummaryCardRsp;
            int i3 = -1;
            String str = "MCardSvc.ReqSetCard\u540e\u53f0\u56de\u5305\u51fa\u9519\uff0c\u9700\u8981\u540e\u53f0\u5e2e\u5fd9\u534f\u52a9\u6392\u67e5";
            if (isSuccess && obj != null) {
                if (obj instanceof Card) {
                    i3 = 0;
                } else if (obj instanceof Pair) {
                    Pair pair = (Pair) obj;
                    Object obj2 = pair.first;
                    String str2 = null;
                    if (obj2 instanceof Integer) {
                        num = (Integer) obj2;
                    } else {
                        num = null;
                    }
                    if (num != null) {
                        i3 = num.intValue();
                    }
                    Object obj3 = pair.second;
                    if (obj3 instanceof SSummaryCardRsp) {
                        sSummaryCardRsp = (SSummaryCardRsp) obj3;
                    } else {
                        sSummaryCardRsp = null;
                    }
                    if (sSummaryCardRsp != null) {
                        str2 = sSummaryCardRsp.emsg;
                    }
                    str = str2 == null ? "data type is invaild" : str2;
                }
            }
            Bundle bundle = new Bundle();
            bundle.putInt("result", i3);
            bundle.putString("message", str);
            EIPCResult createSuccessResult = EIPCResult.createSuccessResult(bundle);
            EIPCCallback mCallback = VasProfileCardApiImpl.this.getMCallback();
            if (mCallback != null) {
                mCallback.callback(createSuccessResult);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/vas/api/impl/VasProfileCardApiImpl$b", "Lcom/tencent/mobileqq/profilecard/observer/ProfileCardObserver;", "", "isSuccess", "", "data", "", "onGetProfileCard", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class b extends ProfileCardObserver {
        b() {
        }

        @Override // com.tencent.mobileqq.profilecard.observer.ProfileCardObserver
        protected void onGetProfileCard(boolean isSuccess, @Nullable Object data) {
            x23.c c16;
            QQAppInterface qQAppInterface;
            int i3;
            if (isSuccess && (data instanceof Card)) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime instanceof QQAppInterface) {
                    qQAppInterface = (QQAppInterface) peekAppRuntime;
                } else {
                    qQAppInterface = null;
                }
                if (qQAppInterface != null) {
                    Card card = (Card) data;
                    if (Utils.p(qQAppInterface.getCurrentAccountUin(), card.uin) && ((i3 = card.templateRet) == 0 || i3 == 101107 || i3 == 101108)) {
                        long j3 = card.lCurrentBgId;
                        if (ProfileTemplateApi.isDiyTemplateStyleID(card.lCurrentStyleId)) {
                            j3 = card.cardId;
                        }
                        long j16 = j3;
                        EIPCCallback mCallback = VasProfileCardApiImpl.this.getMCallback();
                        if (mCallback != null) {
                            VasProfileCardApiImpl vasProfileCardApiImpl = VasProfileCardApiImpl.this;
                            long j17 = card.lCurrentStyleId;
                            String str = card.backgroundUrl;
                            Intrinsics.checkNotNullExpressionValue(str, "data.backgroundUrl");
                            mCallback.callback(vasProfileCardApiImpl.buildCardInfoResult(j16, j17, str, 0));
                            return;
                        }
                        return;
                    }
                }
            }
            QLog.e("Q.emoji.web.MessengerService", 1, "onCardDownload fail isSuccess = " + isSuccess + "data = " + data);
            x23.c chain = VasProfileCardApiImpl.this.getChain();
            if (chain != null && (c16 = chain.c(new StatusNode(1, new Status(!isSuccess ? 1 : 0, "", 0, 4, null)))) != null) {
                c16.end();
            }
            EIPCCallback mCallback2 = VasProfileCardApiImpl.this.getMCallback();
            if (mCallback2 != null) {
                mCallback2.callback(VasProfileCardApiImpl.this.buildCardInfoResult(0L, 0L, "", -1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EIPCResult buildCardInfoResult(long currentId, long styleId, String backgroundUrl, int result) {
        Bundle bundle = new Bundle();
        bundle.putLong("currentId", currentId);
        bundle.putLong("styleId", styleId);
        bundle.putString("diy_url", backgroundUrl);
        bundle.putInt("result", result);
        EIPCResult createSuccessResult = EIPCResult.createSuccessResult(bundle);
        Intrinsics.checkNotNullExpressionValue(createSuccessResult, "createSuccessResult(Bund\u2026ESULT, result)\n        })");
        return createSuccessResult;
    }

    private final x23.c createReportChain() {
        return com.tencent.mobileqq.vas.report.a.f310626a.a(new w23.c(ProfileCardServlet.CMD_REQ_SUMMARY_CARD, y23.a.INSTANCE.a(), 0, false, 20000L));
    }

    private final void getSummaryCard(QQAppInterface qqApp, EIPCCallback callback) {
        CardHandler cardHandler;
        this.chain = createReportChain().c(new Node(0));
        this.mCallback = callback;
        qqApp.addObserver(this.profileCardObserver);
        long control = ProfileUtils.getControl(new AllInOne(qqApp.getCurrentAccountUin(), 0), false);
        byte x06 = (byte) ea.x0(qqApp.getApplication(), qqApp.getCurrentAccountUin());
        BusinessHandler businessHandler = qqApp.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
        if (businessHandler instanceof CardHandler) {
            cardHandler = (CardHandler) businessHandler;
        } else {
            cardHandler = null;
        }
        CardHandler cardHandler2 = cardHandler;
        if (cardHandler2 != null) {
            cardHandler2.m3(qqApp.getCurrentAccountUin(), qqApp.getCurrentAccountUin(), 0, 0L, (byte) 1, 0L, 0L, null, "", control, 10004, null, x06);
        }
    }

    @Override // com.tencent.mobileqq.vas.api.IVasProfileCardApi
    public void getCardInfo(@Nullable EIPCCallback callback, boolean forceRequest) {
        QQAppInterface qQAppInterface;
        FriendsManager friendsManager;
        long j3;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Card card = null;
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            return;
        }
        Manager manager = qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (manager instanceof FriendsManager) {
            friendsManager = (FriendsManager) manager;
        } else {
            friendsManager = null;
        }
        if (friendsManager != null) {
            card = friendsManager.r(qQAppInterface.getCurrentAccountUin());
        }
        if (forceRequest) {
            getSummaryCard(qQAppInterface, callback);
            return;
        }
        if (card != null && card.lCurrentBgId != -1) {
            long j16 = card.lCurrentStyleId;
            if (j16 != -1) {
                if (ProfileTemplateApi.isDiyTemplateStyleID(j16)) {
                    j3 = card.cardId;
                } else {
                    j3 = card.lCurrentBgId;
                }
                long j17 = j3;
                if (callback != null) {
                    long j18 = card.lCurrentStyleId;
                    String str = card.backgroundUrl;
                    Intrinsics.checkNotNullExpressionValue(str, "card.backgroundUrl");
                    callback.callback(buildCardInfoResult(j17, j18, str, 0));
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("MessengerService.onCardDownload", 2, "start onCardDownload");
        }
        getSummaryCard(qQAppInterface, callback);
    }

    @NotNull
    public final CardObserver getCardObserver() {
        return this.cardObserver;
    }

    @Nullable
    public final x23.c getChain() {
        return this.chain;
    }

    @Nullable
    public final EIPCCallback getMCallback() {
        return this.mCallback;
    }

    @NotNull
    public final ProfileCardObserver getProfileCardObserver() {
        return this.profileCardObserver;
    }

    public final void setChain(@Nullable x23.c cVar) {
        this.chain = cVar;
    }

    public final void setMCallback(@Nullable EIPCCallback eIPCCallback) {
        this.mCallback = eIPCCallback;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasProfileCardApi
    public void setProfileCard(long layoutId, long backgroundId, long cardId, @NotNull String extInfo, @NotNull String diyTemplate, @Nullable EIPCCallback callback) {
        QQAppInterface qQAppInterface;
        String str;
        Intrinsics.checkNotNullParameter(extInfo, "extInfo");
        Intrinsics.checkNotNullParameter(diyTemplate, "diyTemplate");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            qQAppInterface = (QQAppInterface) peekAppRuntime;
        } else {
            qQAppInterface = null;
        }
        if (qQAppInterface == null) {
            return;
        }
        qQAppInterface.addObserver(this.cardObserver);
        this.mCallback = callback;
        if (backgroundId == 0) {
            str = dr.a(diyTemplate);
        } else {
            str = null;
        }
        ProfileCardUtil.x0(qQAppInterface, layoutId, backgroundId, str, 0L, extInfo, diyTemplate, cardId);
    }
}
