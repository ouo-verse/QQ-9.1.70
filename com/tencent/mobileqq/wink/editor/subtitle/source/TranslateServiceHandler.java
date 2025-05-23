package com.tencent.mobileqq.wink.editor.subtitle.source;

import camera.MOBILE_QQ_MATERIAL_INTERFACE.Text;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.TranslateTextReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.TranslateTextRsp;
import com.qq.jce.wup.UniPacket;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u001e\u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000eH\u0014J\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J&\u0010\u0018\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0014H\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/subtitle/source/TranslateServiceHandler;", "Lcom/tencent/mobileqq/wink/edit/manager/WinkDataServiceHandler;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/editor/subtitle/source/Subtitle;", "Lkotlin/collections/ArrayList;", "lines", "", "r3", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", Const.BUNDLE_KEY_REQUEST, "Lcom/qq/jce/wup/UniPacket;", "client", "", "F2", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "observerClass", "req", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "resp", "", Constants.BASE_IN_PLUGIN_VERSION, "res", "data", "onReceive", "Lcom/tencent/common/app/AppInterface;", "app", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class TranslateServiceHandler extends WinkDataServiceHandler {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TranslateServiceHandler(@NotNull AppInterface app) {
        super(app);
        Intrinsics.checkNotNullParameter(app, "app");
    }

    @Override // com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler, com.tencent.mobileqq.wink.edit.manager.WinkDataBaseServiceHandler
    @Nullable
    public Object D2(@Nullable ToServiceMsg req, @Nullable FromServiceMsg resp) {
        String str;
        boolean equals;
        byte[] bArr = null;
        if (req != null) {
            str = req.getServiceCmd();
        } else {
            str = null;
        }
        equals = StringsKt__StringsJVMKt.equals(str, "ShadowBackendSvc.TranslateText", true);
        if (equals) {
            if (resp != null) {
                bArr = resp.getWupBuffer();
            }
            return E2(bArr, "ShadowBackendSvc.TranslateText", new TranslateTextRsp());
        }
        return super.D2(req, resp);
    }

    @Override // com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler, com.tencent.mobileqq.wink.edit.manager.WinkDataBaseServiceHandler
    public boolean F2(@NotNull ToServiceMsg request, @NotNull UniPacket client) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(client, "client");
        TranslateTextReq translateTextReq = new TranslateTextReq();
        translateTextReq.SouceLanguageText = (Text[]) request.getAttribute("subtitlesTranslateTexts", null);
        translateTextReq.TargetLanguages = new String[]{"en"};
        client.setServantName("ShadowBackendSvc");
        client.setFuncName("ShadowBackendSvc.TranslateText");
        client.put("ShadowBackendSvc.TranslateText", translateTextReq);
        return true;
    }

    @Override // com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler, com.tencent.mobileqq.app.BusinessHandler
    @NotNull
    protected Class<? extends BusinessObserver> observerClass() {
        return h.class;
    }

    @Override // com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(@Nullable ToServiceMsg req, @Nullable FromServiceMsg res, @Nullable Object data) {
        String str;
        super.onReceive(req, res, data);
        if (req != null) {
            str = req.getServiceCmd();
        } else {
            str = null;
        }
        if (!Intrinsics.areEqual(str, "ShadowBackendSvc.TranslateText")) {
            return;
        }
        if (data != null && res != null) {
            notifyUI(req.hashCode(), res.isSuccess(), new Pair(res, (TranslateTextRsp) data));
        } else {
            notifyUI(req.hashCode(), false, new Pair(res, null));
        }
    }

    public final void r3(@NotNull ArrayList<Subtitle> lines) {
        Intrinsics.checkNotNullParameter(lines, "lines");
        ToServiceMsg toServiceMsg = new ToServiceMsg("ShadowBackendSvc", this.appRuntime.getCurrentAccountUin(), "ShadowBackendSvc.TranslateText");
        Text[] textArr = new Text[lines.size()];
        int i3 = 0;
        for (Object obj : lines) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            Subtitle subtitle = (Subtitle) obj;
            Text text = new Text();
            text.Content = subtitle.getLine();
            text.Id = subtitle.getId();
            textArr[i3] = text;
            i3 = i16;
        }
        toServiceMsg.addAttribute("subtitlesTranslateTexts", textArr);
        x53.c.a(toServiceMsg, TranslateServiceHandler.class.getName(), x53.b.class);
    }
}
