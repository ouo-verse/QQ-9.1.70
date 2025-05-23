package com.tencent.qqnt.aio.adapter.api.impl;

import android.app.Activity;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.aio.adapter.api.IAIOFileManagerApi;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaElementGetReq;
import cooperation.qzone.panorama.util.PanoramaConfig;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J(\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\fH\u0016J.\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u001e\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0014\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\"\u0010\u0018\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0016H\u0016J\u0014\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0006H\u0002J\"\u0010!\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u0016H\u0016J(\u0010#\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\fH\u0016\u00a8\u0006$"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOFileManagerApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOFileManagerApi;", "()V", "cancelDownloadFile", "", "aioMsgItem", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "cancelSendFile", "downloadFile", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "updateUI", "Lkotlin/Function0;", "fixFileThumbSize", "Lkotlin/Pair;", "", "fileElement", "Lcom/tencent/qqnt/kernel/nativeinterface/FileElement;", "fileElemId", "", "fixFileThumbSizeFromFile", "path", "", "getPicFileDefaultSize", "getTroopFilePathFromTransMgrByFileId", "app", "Lmqq/app/AppRuntime;", "troopUin", "fileUuid", "getVideoFileDefaultSize", "makeRichMediaElementGetReq", "Lcom/tencent/qqnt/kernel/nativeinterface/RichMediaElementGetReq;", "msgRecord", "openTroopFileBrowser", PanoramaConfig.KEY_CURRENT_UIN, "reSendFile", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes23.dex */
public final class AIOFileManagerApiNtImpl implements IAIOFileManagerApi {
    static IPatchRedirector $redirector_;

    public AIOFileManagerApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final RichMediaElementGetReq makeRichMediaElementGetReq(AIOMsgItem msgRecord) {
        MsgElement firstTypeElement = msgRecord.getFirstTypeElement(3);
        Intrinsics.checkNotNull(firstTypeElement);
        RichMediaElementGetReq richMediaElementGetReq = new RichMediaElementGetReq();
        richMediaElementGetReq.msgId = msgRecord.q0();
        richMediaElementGetReq.peerUid = msgRecord.r0();
        richMediaElementGetReq.chatType = msgRecord.p0();
        richMediaElementGetReq.elementId = firstTypeElement.elementId;
        richMediaElementGetReq.downloadType = 1;
        return richMediaElementGetReq;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOFileManagerApi
    public void cancelDownloadFile(@NotNull AIOMsgItem aioMsgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aioMsgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(aioMsgItem, "aioMsgItem");
        com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.cancelGetRichMediaElement(makeRichMediaElementGetReq(aioMsgItem));
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOFileManagerApi
    public void cancelSendFile(@NotNull AIOMsgItem aioMsgItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aioMsgItem);
            return;
        }
        Intrinsics.checkNotNullParameter(aioMsgItem, "aioMsgItem");
        com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            long msgId = aioMsgItem.getMsgId();
            String str = aioMsgItem.v().peerUid;
            Intrinsics.checkNotNullExpressionValue(str, "aioMsgItem.contact.peerUid");
            e16.cancelSendMsg(msgId, str, aioMsgItem.v().chatType);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOFileManagerApi
    public void downloadFile(@Nullable Activity activity, @NotNull AIOMsgItem aioMsgItem, @NotNull Function0<Unit> updateUI) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, aioMsgItem, updateUI);
            return;
        }
        Intrinsics.checkNotNullParameter(aioMsgItem, "aioMsgItem");
        Intrinsics.checkNotNullParameter(updateUI, "updateUI");
        com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.getRichMediaElement(makeRichMediaElementGetReq(aioMsgItem));
        }
        updateUI.invoke();
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOFileManagerApi
    @Nullable
    public Pair<Integer, Integer> fixFileThumbSize(@NotNull AIOMsgItem aioMsgItem, @NotNull FileElement fileElement, long fileElemId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Pair) iPatchRedirector.redirect((short) 7, this, aioMsgItem, fileElement, Long.valueOf(fileElemId));
        }
        Intrinsics.checkNotNullParameter(aioMsgItem, "aioMsgItem");
        Intrinsics.checkNotNullParameter(fileElement, "fileElement");
        return null;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOFileManagerApi
    @Nullable
    public Pair<Integer, Integer> fixFileThumbSizeFromFile(@NotNull String path) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Pair) iPatchRedirector.redirect((short) 8, (Object) this, (Object) path);
        }
        Intrinsics.checkNotNullParameter(path, "path");
        com.tencent.qqnt.base.utils.c cVar = com.tencent.qqnt.base.utils.c.f353052a;
        return new Pair<>(Integer.valueOf(cVar.b(100)), Integer.valueOf(cVar.b(100)));
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOFileManagerApi
    @NotNull
    public Pair<Integer, Integer> getPicFileDefaultSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Pair) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        com.tencent.qqnt.base.utils.c cVar = com.tencent.qqnt.base.utils.c.f353052a;
        return new Pair<>(Integer.valueOf(cVar.b(100)), Integer.valueOf(cVar.b(100)));
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOFileManagerApi
    @Nullable
    public String getTroopFilePathFromTransMgrByFileId(@NotNull AppRuntime app, @NotNull String troopUin, @NotNull String fileUuid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, this, app, troopUin, fileUuid);
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(fileUuid, "fileUuid");
        return null;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOFileManagerApi
    @NotNull
    public Pair<Integer, Integer> getVideoFileDefaultSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Pair) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        com.tencent.qqnt.base.utils.c cVar = com.tencent.qqnt.base.utils.c.f353052a;
        return new Pair<>(Integer.valueOf(cVar.b(100)), Integer.valueOf(cVar.b(100)));
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOFileManagerApi
    public void openTroopFileBrowser(@Nullable Activity activity, @NotNull String troopUin, @NotNull String currentUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, activity, troopUin, currentUin);
        } else {
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            Intrinsics.checkNotNullParameter(currentUin, "currentUin");
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOFileManagerApi
    public void reSendFile(@Nullable Activity activity, @NotNull AIOMsgItem aioMsgItem, @NotNull Function0<Unit> updateUI) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, activity, aioMsgItem, updateUI);
            return;
        }
        Intrinsics.checkNotNullParameter(aioMsgItem, "aioMsgItem");
        Intrinsics.checkNotNullParameter(updateUI, "updateUI");
        com.tencent.qqnt.kernel.api.w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.resendMsg(aioMsgItem.v(), aioMsgItem.getMsgId(), null);
        }
        updateUI.invoke();
    }
}
