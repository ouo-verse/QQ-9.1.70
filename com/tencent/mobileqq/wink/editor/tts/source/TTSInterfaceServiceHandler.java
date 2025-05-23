package com.tencent.mobileqq.wink.editor.tts.source;

import camera.MOBILE_QQ_MATERIAL_INTERFACE.AudioConfig;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.TTSInterfaceReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.TTSInterfaceRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.VoiceConfig;
import com.qq.jce.wup.UniPacket;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\b \u0010!J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\nH\u0014J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J\"\u0010\u0014\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0016J-\u0010\u001c\u001a\u00020\u00022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001d\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/wink/editor/tts/source/TTSInterfaceServiceHandler;", "Lcom/tencent/mobileqq/wink/edit/manager/WinkDataServiceHandler;", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", Const.BUNDLE_KEY_REQUEST, "Lcom/qq/jce/wup/UniPacket;", "client", "", ICustomDataEditor.STRING_PARAM_3, "req", "F2", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "observerClass", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "resp", "", Constants.BASE_IN_PLUGIN_VERSION, "res", "data", "", "onReceive", "", "", "texts", "", "ttsType", "Lcom/tencent/mobileqq/wink/editor/tts/source/TTSExtraConfig;", "extraConfig", "t3", "([Ljava/lang/String;ILcom/tencent/mobileqq/wink/editor/tts/source/TTSExtraConfig;)Lcom/tencent/qphone/base/remote/ToServiceMsg;", "Lcom/tencent/common/app/AppInterface;", "app", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class TTSInterfaceServiceHandler extends WinkDataServiceHandler {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TTSInterfaceServiceHandler(@NotNull AppInterface app) {
        super(app);
        Intrinsics.checkNotNullParameter(app, "app");
    }

    private final boolean s3(ToServiceMsg request, UniPacket client) {
        TTSInterfaceReq tTSInterfaceReq = new TTSInterfaceReq();
        tTSInterfaceReq.Texts = (String[]) request.getAttribute("ttsTexts", null);
        Object attribute = request.getAttribute("ttsTemplateType", 0);
        Intrinsics.checkNotNullExpressionValue(attribute, "request.getAttribute(AEE\u2026ateType._DefaultTemplate)");
        tTSInterfaceReq.TTSTemplateType = ((Number) attribute).intValue();
        Object attribute2 = request.getAttribute("ttsNeedAudioRawData", Boolean.FALSE);
        Intrinsics.checkNotNullExpressionValue(attribute2, "request.getAttribute(AEE\u2026ED_AUDIO_RAW_DATA, false)");
        tTSInterfaceReq.NeedAudioRawData = ((Boolean) attribute2).booleanValue();
        tTSInterfaceReq.AudioConfig = (AudioConfig) request.getAttribute("ttsAudioConfig", null);
        tTSInterfaceReq.VoiceConfig = (VoiceConfig) request.getAttribute("ttsVoiceConfig", null);
        client.setServantName("ShadowBackendSvc");
        client.setFuncName("ShadowBackendSvc.TTSInterface");
        client.put("ShadowBackendSvc.TTSInterface", tTSInterfaceReq);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u3(ToServiceMsg request, TTSInterfaceServiceHandler this$0) {
        Intrinsics.checkNotNullParameter(request, "$request");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        x53.c.a(request, this$0.getClass().getName(), x53.b.class);
    }

    @Override // com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler, com.tencent.mobileqq.wink.edit.manager.WinkDataBaseServiceHandler
    @Nullable
    public Object D2(@NotNull ToServiceMsg req, @NotNull FromServiceMsg resp) {
        boolean equals;
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(resp, "resp");
        equals = StringsKt__StringsJVMKt.equals(req.getServiceCmd(), "ShadowBackendSvc.TTSInterface", true);
        if (equals) {
            return E2(resp.getWupBuffer(), "ShadowBackendSvc.TTSInterface", new TTSInterfaceRsp());
        }
        return super.D2(req, resp);
    }

    @Override // com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler, com.tencent.mobileqq.wink.edit.manager.WinkDataBaseServiceHandler
    public boolean F2(@NotNull ToServiceMsg req, @NotNull UniPacket client) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(client, "client");
        if (Intrinsics.areEqual(req.getServiceCmd(), "ShadowBackendSvc.TTSInterface")) {
            return s3(req, client);
        }
        return super.F2(req, client);
    }

    @Override // com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler, com.tencent.mobileqq.app.BusinessHandler
    @NotNull
    protected Class<? extends BusinessObserver> observerClass() {
        return b.class;
    }

    @Override // com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(@NotNull ToServiceMsg req, @NotNull FromServiceMsg res, @Nullable Object data) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(res, "res");
        super.onReceive(req, res, data);
        if (Intrinsics.areEqual(req.getServiceCmd(), "ShadowBackendSvc.TTSInterface")) {
            if (data != null) {
                notifyUI(req.hashCode(), res.isSuccess(), new Pair(res, (TTSInterfaceRsp) data));
            } else {
                notifyUI(req.hashCode(), false, new Pair(res, null));
            }
        }
    }

    @NotNull
    public final ToServiceMsg t3(@NotNull String[] texts, int ttsType, @Nullable TTSExtraConfig extraConfig) {
        boolean z16;
        Intrinsics.checkNotNullParameter(texts, "texts");
        final ToServiceMsg toServiceMsg = new ToServiceMsg("ShadowBackendSvc", this.appRuntime.getCurrentAccountUin(), "ShadowBackendSvc.TTSInterface");
        toServiceMsg.addAttribute("ttsTemplateType", Integer.valueOf(ttsType));
        toServiceMsg.addAttribute("ttsTexts", texts);
        if (extraConfig != null) {
            z16 = extraConfig.getNeedAudioRawData();
        } else {
            z16 = false;
        }
        toServiceMsg.addAttribute("ttsNeedAudioRawData", Boolean.valueOf(z16));
        if (extraConfig != null) {
            toServiceMsg.addAttribute("ttsVoiceConfig", extraConfig.getVoiceConfig());
            toServiceMsg.addAttribute("ttsAudioConfig", extraConfig.getAudioConfig());
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.tts.source.e
            @Override // java.lang.Runnable
            public final void run() {
                TTSInterfaceServiceHandler.u3(ToServiceMsg.this, this);
            }
        }, 128, null, true);
        return toServiceMsg;
    }
}
