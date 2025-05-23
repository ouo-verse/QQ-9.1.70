package com.tencent.imcore.message.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.imcore.message.api.INTMsgProxyUtilsApi;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emotionintegrate.t;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IMessageRecordFactoryApi;
import com.tencent.qqnt.aio.adapter.marketface.a;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.api.NTOperateUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J,\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/imcore/message/api/impl/NTMsgProxyUtilsApiImpl;", "Lcom/tencent/imcore/message/api/INTMsgProxyUtilsApi;", "", "Lcom/tencent/mobileqq/data/MessageRecord;", "data", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msg", "", "handlePicMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;", "fetchMarketFaceEle", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "getAppRuntime", "", TabPreloadItem.TAB_NAME_MESSAGE, "", "peerUin", "", "uinType", "transToCompatMsgType", "<init>", "()V", "Companion", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class NTMsgProxyUtilsApiImpl implements INTMsgProxyUtilsApi {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "NTMsgProxyUtilsApiImpl";

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/imcore/message/api/impl/NTMsgProxyUtilsApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.imcore.message.api.impl.NTMsgProxyUtilsApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22303);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public NTMsgProxyUtilsApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final MarketFaceElement fetchMarketFaceEle(MsgRecord msg2) {
        MarketFaceElement marketFaceElement;
        Iterator<MsgElement> it = msg2.elements.iterator();
        while (it.hasNext()) {
            MsgElement next = it.next();
            if (next.elementType == 11 && (marketFaceElement = next.marketFaceElement) != null) {
                Intrinsics.checkNotNullExpressionValue(marketFaceElement, "element.marketFaceElement");
                return marketFaceElement;
            }
        }
        return new MarketFaceElement();
    }

    private final BaseQQAppInterface getAppRuntime() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.business.BaseQQAppInterface");
        return (BaseQQAppInterface) peekAppRuntime;
    }

    private final void handlePicMsg(List<MessageRecord> data, MsgRecord msg2) {
        int size = msg2.elements.size();
        for (int i3 = 0; i3 < size; i3++) {
            MsgElement msgElement = msg2.elements.get(i3);
            if (msgElement.picElement != null) {
                IMessageRecordFactoryApi iMessageRecordFactoryApi = (IMessageRecordFactoryApi) QRoute.api(IMessageRecordFactoryApi.class);
                BaseQQAppInterface appRuntime = getAppRuntime();
                Intrinsics.checkNotNullExpressionValue(msgElement, "msgElement");
                ChatMessage createPicMessage = iMessageRecordFactoryApi.createPicMessage(appRuntime, msg2, msgElement);
                createPicMessage.uniseq = msg2.msgId;
                if (t.f205295a.b()) {
                    createPicMessage.shmsgseq = msg2.msgSeq;
                }
                data.add(createPicMessage);
            }
        }
    }

    @Override // com.tencent.imcore.message.api.INTMsgProxyUtilsApi
    @NotNull
    public List<MessageRecord> transToCompatMsgType(@NotNull List<MsgRecord> msgList, @NotNull String peerUin, int uinType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, this, msgList, peerUin, Integer.valueOf(uinType));
        }
        Intrinsics.checkNotNullParameter(msgList, "msgList");
        Intrinsics.checkNotNullParameter(peerUin, "peerUin");
        ArrayList arrayList = new ArrayList();
        for (MsgRecord msgRecord : msgList) {
            NTOperateUtils nTOperateUtils = NTOperateUtils.f359554a;
            if (nTOperateUtils.f(msgRecord)) {
                MarketFaceElement fetchMarketFaceEle = fetchMarketFaceEle(msgRecord);
                QLog.i(TAG, 1, "faceDsc=" + fetchMarketFaceEle.faceName);
                MessageForMarketFace createSendMsgMarketFace = ((IMessageRecordFactoryApi) QRoute.api(IMessageRecordFactoryApi.class)).createSendMsgMarketFace(getAppRuntime(), peerUin, peerUin, uinType, a.f348768a.d(fetchMarketFaceEle));
                createSendMsgMarketFace.uniseq = msgRecord.msgId;
                if (t.f205295a.b()) {
                    createSendMsgMarketFace.shmsgseq = msgRecord.msgSeq;
                }
                arrayList.add(createSendMsgMarketFace);
            } else if (nTOperateUtils.e(msgRecord)) {
                handlePicMsg(arrayList, msgRecord);
            }
        }
        return arrayList;
    }
}
