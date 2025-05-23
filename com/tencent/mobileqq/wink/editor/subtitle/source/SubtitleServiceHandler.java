package com.tencent.mobileqq.wink.editor.subtitle.source;

import camera.MOBILE_QQ_MATERIAL_INTERFACE.SubtitleQueryReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.SubtitleQueryRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.SubtitleSubmitReq;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.SubtitleSubmitRsp;
import com.qq.jce.wup.UniPacket;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
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
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010$\u001a\u00020#\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\"\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\"\u0010\u0013\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\rH\u0016J\u0010\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180\u0017H\u0014J\"\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0018\u0010\u001d\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\f\u001a\u00020\u0004J\u0018\u0010\u001f\u001a\u00020\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\f\u001a\u00020\u0004R\u0014\u0010\"\u001a\u00020\u001b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/subtitle/source/SubtitleServiceHandler;", "Lcom/tencent/mobileqq/wink/edit/manager/WinkDataServiceHandler;", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "req", "", "r3", Const.BUNDLE_KEY_REQUEST, "Lcom/qq/jce/wup/UniPacket;", "client", "", "v3", "t3", "awareType", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "res", "", "data", "", "u3", ICustomDataEditor.STRING_PARAM_3, "F2", "resp", Constants.BASE_IN_PLUGIN_VERSION, "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "observerClass", "onReceive", "", "url", "x3", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "w3", "e", "Ljava/lang/String;", "SUBTITLE_REQUEST_AWARE_ID", "Lcom/tencent/common/app/AppInterface;", "app", "<init>", "(Lcom/tencent/common/app/AppInterface;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class SubtitleServiceHandler extends WinkDataServiceHandler {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String SUBTITLE_REQUEST_AWARE_ID;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubtitleServiceHandler(@NotNull AppInterface app) {
        super(app);
        Intrinsics.checkNotNullParameter(app, "app");
        this.SUBTITLE_REQUEST_AWARE_ID = "subtitle_request_aware_id";
    }

    private final int r3(ToServiceMsg req) {
        Integer num;
        Object attribute = req.getAttribute(this.SUBTITLE_REQUEST_AWARE_ID);
        if (attribute instanceof Integer) {
            num = (Integer) attribute;
        } else {
            num = null;
        }
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    private final void s3(int awareType, FromServiceMsg res, Object data) {
        if (data == null) {
            notifyUI(awareType, false, new Pair(res, null));
        } else {
            notifyUI(awareType, res.isSuccess(), new Pair(res, (SubtitleQueryRsp) data));
        }
    }

    private final boolean t3(ToServiceMsg request, UniPacket client) {
        SubtitleQueryReq subtitleQueryReq = new SubtitleQueryReq();
        subtitleQueryReq.TaskID = (String) request.getAttribute("taskid", "");
        client.setServantName("ShadowBackendSvc");
        client.setFuncName(AEEditorConstants.CMD_SUBTITLE_QUERY);
        client.put(AEEditorConstants.CMD_SUBTITLE_QUERY, subtitleQueryReq);
        return true;
    }

    private final void u3(int awareType, FromServiceMsg res, Object data) {
        if (data == null) {
            notifyUI(awareType, false, new Pair(res, null));
        } else {
            notifyUI(awareType, res.isSuccess(), new Pair(res, (SubtitleSubmitRsp) data));
        }
    }

    private final boolean v3(ToServiceMsg request, UniPacket client) {
        SubtitleSubmitReq subtitleSubmitReq = new SubtitleSubmitReq();
        subtitleSubmitReq.AudioURL = (String) request.getAttribute("audiourl", "");
        client.setServantName("ShadowBackendSvc");
        client.setFuncName(AEEditorConstants.CMD_SUBTITLE_SUBMIT);
        client.put(AEEditorConstants.CMD_SUBTITLE_SUBMIT, subtitleSubmitReq);
        return true;
    }

    @Override // com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler, com.tencent.mobileqq.wink.edit.manager.WinkDataBaseServiceHandler
    @NotNull
    public Object D2(@NotNull ToServiceMsg req, @NotNull FromServiceMsg resp) {
        boolean equals;
        boolean equals2;
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(resp, "resp");
        equals = StringsKt__StringsJVMKt.equals(req.getServiceCmd(), AEEditorConstants.CMD_SUBTITLE_SUBMIT, true);
        if (!equals) {
            equals2 = StringsKt__StringsJVMKt.equals(req.getServiceCmd(), AEEditorConstants.CMD_SUBTITLE_QUERY, true);
            if (equals2) {
                Object E2 = E2(resp.getWupBuffer(), AEEditorConstants.CMD_SUBTITLE_QUERY, new SubtitleQueryRsp());
                Intrinsics.checkNotNullExpressionValue(E2, "decodeCompressPacked(\n  \u2026eQueryRsp()\n            )");
                return E2;
            }
            Object D2 = super.D2(req, resp);
            Intrinsics.checkNotNullExpressionValue(D2, "super.decode(req, resp)");
            return D2;
        }
        Object E22 = E2(resp.getWupBuffer(), AEEditorConstants.CMD_SUBTITLE_SUBMIT, new SubtitleSubmitRsp());
        Intrinsics.checkNotNullExpressionValue(E22, "decodeCompressPacked(\n  \u2026SubmitRsp()\n            )");
        return E22;
    }

    @Override // com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler, com.tencent.mobileqq.wink.edit.manager.WinkDataBaseServiceHandler
    public boolean F2(@NotNull ToServiceMsg req, @NotNull UniPacket client) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(client, "client");
        if (Intrinsics.areEqual(req.getServiceCmd(), AEEditorConstants.CMD_SUBTITLE_SUBMIT)) {
            return v3(req, client);
        }
        if (Intrinsics.areEqual(req.getServiceCmd(), AEEditorConstants.CMD_SUBTITLE_QUERY)) {
            return t3(req, client);
        }
        return super.F2(req, client);
    }

    @Override // com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler, com.tencent.mobileqq.app.BusinessHandler
    @NotNull
    protected Class<? extends BusinessObserver> observerClass() {
        return e.class;
    }

    @Override // com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(@NotNull ToServiceMsg req, @NotNull FromServiceMsg res, @Nullable Object data) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(res, "res");
        super.onReceive(req, res, data);
        if (Intrinsics.areEqual(req.getServiceCmd(), AEEditorConstants.CMD_SUBTITLE_SUBMIT)) {
            u3(r3(req), res, data);
        }
        if (Intrinsics.areEqual(req.getServiceCmd(), AEEditorConstants.CMD_SUBTITLE_QUERY)) {
            s3(r3(req), res, data);
        }
    }

    public final void w3(@Nullable String taskId, int awareType) {
        ToServiceMsg toServiceMsg = new ToServiceMsg("ShadowBackendSvc", this.appRuntime.getCurrentAccountUin(), AEEditorConstants.CMD_SUBTITLE_QUERY);
        toServiceMsg.addAttribute("taskid", taskId);
        toServiceMsg.addAttribute(this.SUBTITLE_REQUEST_AWARE_ID, Integer.valueOf(awareType));
        x53.c.a(toServiceMsg, SubtitleServiceHandler.class.getName(), x53.b.class);
    }

    public final void x3(@Nullable String url, int awareType) {
        ToServiceMsg toServiceMsg = new ToServiceMsg("ShadowBackendSvc", this.appRuntime.getCurrentAccountUin(), AEEditorConstants.CMD_SUBTITLE_SUBMIT);
        toServiceMsg.addAttribute("audiourl", url);
        toServiceMsg.addAttribute(this.SUBTITLE_REQUEST_AWARE_ID, Integer.valueOf(awareType));
        x53.c.a(toServiceMsg, SubtitleServiceHandler.class.getName(), x53.b.class);
    }
}
