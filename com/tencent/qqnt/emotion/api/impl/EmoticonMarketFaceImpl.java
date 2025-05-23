package com.tencent.qqnt.emotion.api.impl;

import com.google.gson.Gson;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerServiceProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.api.IEmoticonMarketFace;
import com.tencent.qqnt.emotion.info.MarketFacePackageInfo;
import com.tencent.qqnt.emotion.stickerrecommended.event.StickerRecommendEvent;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IGetMarketEmoticonEncryptKeysCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceSupportSize;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J0\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\nH\u0002J\"\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0002J \u0010\u0013\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/emotion/api/impl/EmoticonMarketFaceImpl;", "Lcom/tencent/qqnt/emotion/api/IEmoticonMarketFace;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/qqnt/kernel/api/w;", "msgService", "", EmojiManagerServiceProxy.EPID, "", "eId", "", "convertJsonFileToMarkFaceMessage", "Lcom/tencent/mobileqq/data/MarkFaceMessage;", "markFaceMessage", "fillEncryptKeys", "realSendMarketFace", "toast", "filePath", "covertToMarkFaceMessage", "sendMarketFace", "<init>", "()V", "Companion", "a", "emotion_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class EmoticonMarketFaceImpl implements IEmoticonMarketFace {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "EmoticonMarketFaceImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/emotion/api/impl/EmoticonMarketFaceImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "emotion_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.emotion.api.impl.EmoticonMarketFaceImpl$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30237);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public EmoticonMarketFaceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void convertJsonFileToMarkFaceMessage(final com.tencent.aio.api.runtime.a aioContext, final w msgService, final int epId, final String eId) {
        msgService.fetchMarketEmotionJsonFile(epId, new IOperateCallback() { // from class: com.tencent.qqnt.emotion.api.impl.c
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                EmoticonMarketFaceImpl.convertJsonFileToMarkFaceMessage$lambda$5(EmoticonMarketFaceImpl.this, epId, eId, aioContext, msgService, i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convertJsonFileToMarkFaceMessage$lambda$5(final EmoticonMarketFaceImpl this$0, final int i3, final String eId, final com.tencent.aio.api.runtime.a aioContext, final w msgService, int i16, final String str) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(eId, "$eId");
        Intrinsics.checkNotNullParameter(aioContext, "$aioContext");
        Intrinsics.checkNotNullParameter(msgService, "$msgService");
        QLog.e(TAG, 1, "fetchMarketEmotionJsonFile  result:" + i16 + "  errMsg:" + str);
        if (i16 == 0) {
            boolean z16 = false;
            if (str != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(str);
                if (!isBlank) {
                    z16 = true;
                }
            }
            if (z16) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.emotion.api.impl.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        EmoticonMarketFaceImpl.convertJsonFileToMarkFaceMessage$lambda$5$lambda$4(EmoticonMarketFaceImpl.this, i3, eId, str, aioContext, msgService);
                    }
                }, 64, null, true);
                return;
            }
        }
        this$0.toast();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convertJsonFileToMarkFaceMessage$lambda$5$lambda$4(EmoticonMarketFaceImpl this$0, int i3, String eId, String errMsg, com.tencent.aio.api.runtime.a aioContext, w msgService) {
        Unit unit;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(eId, "$eId");
        Intrinsics.checkNotNullParameter(aioContext, "$aioContext");
        Intrinsics.checkNotNullParameter(msgService, "$msgService");
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        MarkFaceMessage covertToMarkFaceMessage = this$0.covertToMarkFaceMessage(i3, eId, errMsg);
        if (covertToMarkFaceMessage != null) {
            this$0.fillEncryptKeys(aioContext, msgService, i3, eId, covertToMarkFaceMessage);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this$0.toast();
        }
    }

    private final MarkFaceMessage covertToMarkFaceMessage(int epId, String eId, String filePath) {
        int i3;
        String name;
        MarketFacePackageInfo.Img img = null;
        try {
            MarketFacePackageInfo marketFacePackageInfo = (MarketFacePackageInfo) new Gson().fromJson((Reader) new FileReader(new File(filePath)), MarketFacePackageInfo.class);
            MarkFaceMessage markFaceMessage = new MarkFaceMessage();
            markFaceMessage.cSubType = marketFacePackageInfo.getType();
            boolean z16 = false;
            markFaceMessage.sbufID = com.tencent.qqnt.emotion.emosm.b.k(eId, 0);
            markFaceMessage.dwTabID = epId;
            for (MarketFacePackageInfo.Img img2 : marketFacePackageInfo.getImgs()) {
                if (Intrinsics.areEqual(eId, img2.getId())) {
                    img = img2;
                }
            }
            int i16 = 200;
            if (img != null) {
                i3 = img.getWWidthInPhone();
            } else {
                i3 = 200;
            }
            markFaceMessage.imageWidth = i3;
            if (img != null) {
                i16 = img.getWHeightInPhone();
            }
            markFaceMessage.imageHeight = i16;
            if (img == null || (name = img.getName()) == null) {
                name = marketFacePackageInfo.getName();
            }
            markFaceMessage.faceName = name;
            if (marketFacePackageInfo.isApng() == 2) {
                z16 = true;
            }
            markFaceMessage.isAPNG = z16;
            markFaceMessage.mediaType = Intrinsics.areEqual(marketFacePackageInfo.getRingtype(), "1") ? 1 : 0;
            if (1 == marketFacePackageInfo.getType() || 4 == marketFacePackageInfo.getType()) {
                markFaceMessage.cSubType = 3;
            }
            ArrayList<MarketFaceSupportSize> arrayList = new ArrayList<>();
            for (MarketFacePackageInfo.SupportSize supportSize : marketFacePackageInfo.getSupportSize()) {
                arrayList.add(new MarketFaceSupportSize(supportSize.getWidth(), supportSize.getHeight()));
            }
            markFaceMessage.supportSize = arrayList;
            markFaceMessage.apngSupportSize = arrayList;
            return markFaceMessage;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "covertToMarkFaceMessage  e:" + e16);
            return null;
        }
    }

    private final void fillEncryptKeys(final com.tencent.aio.api.runtime.a aioContext, w msgService, int epId, String eId, final MarkFaceMessage markFaceMessage) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(eId);
        msgService.getMarketEmoticonEncryptKeys(epId, arrayList, new IGetMarketEmoticonEncryptKeysCallback() { // from class: com.tencent.qqnt.emotion.api.impl.d
            @Override // com.tencent.qqnt.kernel.nativeinterface.IGetMarketEmoticonEncryptKeysCallback
            public final void onGetMarketEmoticonEncryptKeysCallback(int i3, String str, HashMap hashMap) {
                EmoticonMarketFaceImpl.fillEncryptKeys$lambda$7(EmoticonMarketFaceImpl.this, markFaceMessage, aioContext, i3, str, hashMap);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fillEncryptKeys$lambda$7(EmoticonMarketFaceImpl this$0, MarkFaceMessage markFaceMessage, com.tencent.aio.api.runtime.a aioContext, int i3, String str, HashMap hashMap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(markFaceMessage, "$markFaceMessage");
        Intrinsics.checkNotNullParameter(aioContext, "$aioContext");
        QLog.e(TAG, 1, "fillEncryptKeys  result:" + i3 + ", errMsg:" + str + ", encryptKeyMap:" + hashMap);
        if (i3 == 0) {
            if (hashMap != null) {
                for (Map.Entry entry : hashMap.entrySet()) {
                    String value = (String) entry.getValue();
                    Intrinsics.checkNotNullExpressionValue(value, "value");
                    byte[] bytes = value.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                    markFaceMessage.sbfKey = bytes;
                    this$0.realSendMarketFace(aioContext, markFaceMessage);
                }
                return;
            }
            return;
        }
        this$0.toast();
    }

    private final void realSendMarketFace(com.tencent.aio.api.runtime.a aioContext, MarkFaceMessage markFaceMessage) {
        aioContext.e().h(new StickerRecommendEvent.SendMarketFace(markFaceMessage));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendMarketFace$lambda$1(EmoticonMarketFaceImpl this$0, com.tencent.aio.api.runtime.a aioContext, int i3, String eId) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(aioContext, "$aioContext");
        Intrinsics.checkNotNullParameter(eId, "$eId");
        w msgService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "")).getMsgService();
        if (msgService != null) {
            this$0.convertJsonFileToMarkFaceMessage(aioContext, msgService, i3, eId);
        }
    }

    private final void toast() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.emotion.api.impl.b
            @Override // java.lang.Runnable
            public final void run() {
                EmoticonMarketFaceImpl.toast$lambda$8();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void toast$lambda$8() {
        QQToast.makeText(MobileQQ.sMobileQQ, R.string.zuj, 0).show();
    }

    @Override // com.tencent.qqnt.emotion.api.IEmoticonMarketFace
    public void sendMarketFace(@NotNull final com.tencent.aio.api.runtime.a aioContext, final int epId, @NotNull final String eId) {
        boolean isBlank;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, aioContext, Integer.valueOf(epId), eId);
            return;
        }
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(eId, "eId");
        QLog.e(TAG, 1, "sendMarketFace  epId:" + epId + "  eId:" + eId);
        if (epId != 0) {
            isBlank = StringsKt__StringsJVMKt.isBlank(eId);
            if (!isBlank) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.emotion.api.impl.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        EmoticonMarketFaceImpl.sendMarketFace$lambda$1(EmoticonMarketFaceImpl.this, aioContext, epId, eId);
                    }
                }, 16, null, true);
            }
        }
    }
}
