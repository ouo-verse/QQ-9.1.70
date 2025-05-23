package com.tencent.mobileqq.zplan.message;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.photo.SendPhotoTask;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.emoticon.panel.util.ZPlanEmoticonUtil;
import com.tencent.mobileqq.zplan.message.a;
import com.tencent.mobileqq.zplan.model.ZPlanActionInfo;
import com.tencent.mobileqq.zplan.model.ZPlanUserInfo;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.meme.Priority;
import com.tencent.zplan.meme.action.MODE;
import com.tencent.zplan.meme.action.MemeAction;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import mqq.os.MqqHandler;
import nh3.ZPlanEmoticonReportData;
import org.aspectj.lang.JoinPoint;
import org.json.JSONObject;
import tencent.im.msg.im_msg_body$RichText;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u00015B\t\b\u0002\u00a2\u0006\u0004\b3\u00104J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\bH\u0002J \u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0018\u0010\u0018\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J*\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J*\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J \u0010\u001f\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\bH\u0002J\u001c\u0010\"\u001a\u00020\u00142\b\u0010 \u001a\u0004\u0018\u00010\b2\b\u0010!\u001a\u0004\u0018\u00010\bH\u0002J6\u0010%\u001a\u00020\u00142\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bJ \u0010&\u001a\u00020\u00142\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J,\u0010'\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bR \u0010-\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*0(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R \u00102\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010,\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/zplan/message/a;", "", "Lcom/tencent/mobileqq/zplan/model/e;", "actionInfo", "Lcom/tencent/mobileqq/zplan/message/c;", "sessionInfo", "Lcom/tencent/mobileqq/zplan/model/ZPlanUserInfo;", "peerInfo", "", QQWinkConstants.COVER_PATH, "Lcom/tencent/mobileqq/zplan/message/MessageForZPlan;", "e", "message", "picLocalPath", "Lcom/tencent/mobileqq/transfile/TransferRequest;", "f", "Lcom/tencent/common/app/AppInterface;", "app", "", "originSeq", "", "d", "", "refreshType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "o", AppConstants.Key.COLUMN_MSG_SENDER_UIN, "receiverUin", "Lcom/tencent/mobileqq/zplan/message/a$a;", "afterGetPic", h.F, "g", "md5", "filePath", DomainData.DOMAIN_NAME, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "j", "i", "l", "", "Lcom/tencent/zplan/meme/action/MemeAction;", "Lcom/tencent/zplan/meme/a;", "b", "Ljava/util/Map;", "recordListenerMap", "Ljava/util/concurrent/locks/ReentrantLock;", "c", "Ljava/util/concurrent/locks/ReentrantLock;", JoinPoint.SYNCHRONIZATION_LOCK, "picFilePathCache", "<init>", "()V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f334220a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Map<MemeAction, com.tencent.zplan.meme.a> recordListenerMap = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final ReentrantLock lock = new ReentrantLock();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, String> picFilePathCache = new LinkedHashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zplan/message/a$a;", "", "", "success", "", "path", "", "onResult", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.message.a$a, reason: collision with other inner class name */
    /* loaded from: classes34.dex */
    public interface InterfaceC9185a {
        void onResult(boolean success, String path);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/message/a$c", "Ljh3/b;", "", "success", "", "path", "Lnh3/b;", "data", "Lcom/tencent/zplan/meme/action/MODE;", "mode", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements jh3.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC9185a f334228a;

        c(InterfaceC9185a interfaceC9185a) {
            this.f334228a = interfaceC9185a;
        }

        @Override // jh3.b
        public void a(boolean success, String path, ZPlanEmoticonReportData data, MODE mode) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(mode, "mode");
            this.f334228a.onResult(success, path);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/message/a$d", "Lcom/tencent/mobileqq/zplan/message/a$a;", "", "success", "", "filePath", "", "onResult", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements InterfaceC9185a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ZPlanActionInfo f334229a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MessageForZPlan f334230b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f334231c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ZPlanSessionInfo f334232d;

        d(ZPlanActionInfo zPlanActionInfo, MessageForZPlan messageForZPlan, QQAppInterface qQAppInterface, ZPlanSessionInfo zPlanSessionInfo) {
            this.f334229a = zPlanActionInfo;
            this.f334230b = messageForZPlan;
            this.f334231c = qQAppInterface;
            this.f334232d = zPlanSessionInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(MessageForZPlan message) {
            Intrinsics.checkNotNullParameter(message, "$message");
            a.f334220a.m(message, 4);
        }

        @Override // com.tencent.mobileqq.zplan.message.a.InterfaceC9185a
        public void onResult(boolean success, String filePath) {
            if (filePath == null) {
                QLog.e("[zplan][ZPlanMessageUtil]", 1, "uploadPicWhenGetPic, filePath is " + filePath + ", cancel send, info=" + this.f334229a);
                return;
            }
            long fileSizes = FileUtils.getFileSizes(filePath);
            if (this.f334230b.extraflag != 32772) {
                QLog.w("[zplan][ZPlanMessageUtil]", 1, "uploadPicWhenGetPic, get filePath, but message is cancel send, info=" + this.f334229a);
                return;
            }
            if (success && fileSizes >= 0) {
                QLog.i("[zplan][ZPlanMessageUtil]", 1, "uploadPicWhenGetPic, get filePath success, info=" + this.f334229a);
                this.f334230b.setLocalSharpP(filePath);
                a aVar = a.f334220a;
                aVar.m(this.f334230b, 1);
                this.f334231c.getMsgCache().L(this.f334230b, 2000);
                final MessageForZPlan messageForZPlan = this.f334230b;
                ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.zplan.message.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.d.b(MessageForZPlan.this);
                    }
                }, 2000L);
                ((ITransFileController) this.f334231c.getRuntimeService(ITransFileController.class, "")).transferAsync(aVar.f(this.f334230b, this.f334232d, filePath));
                return;
            }
            QLog.e("[zplan][ZPlanMessageUtil]", 1, "uploadPicWhenGetPic, get filePath, file is null or empty!!, info=" + this.f334229a);
            a.f334220a.m(this.f334230b, 2);
        }
    }

    a() {
    }

    private final void d(AppInterface app, MessageForZPlan message, long originSeq) {
        IRuntimeService runtimeService = app.getRuntimeService(IOrderMediaMsgService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IO\u2026va, ProcessConstant.MAIN)");
        IOrderMediaMsgService iOrderMediaMsgService = (IOrderMediaMsgService) runtimeService;
        iOrderMediaMsgService.updateMediaMsgByUniseq(message.frienduin, originSeq, message.uniseq);
        iOrderMediaMsgService.addOrderMsg(message, message.getLocalCover());
    }

    private final MessageForZPlan e(ZPlanActionInfo actionInfo, ZPlanSessionInfo sessionInfo, ZPlanUserInfo peerInfo, String coverPath) {
        String str;
        MessageForZPlan b16 = MessageForZPlan.INSTANCE.b(actionInfo, sessionInfo);
        b16.setPeerUin((peerInfo == null || (str = peerInfo.uin) == null) ? 0L : Long.parseLong(str));
        b16.setLocalCover(coverPath);
        b16.extraflag = 32772;
        return b16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TransferRequest f(MessageForZPlan message, ZPlanSessionInfo sessionInfo, String picLocalPath) {
        String friendUin;
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mRec = message;
        transferRequest.mSelfUin = message.selfuin;
        if (sessionInfo.getIsTroop()) {
            friendUin = sessionInfo.getTroopUin();
        } else {
            friendUin = sessionInfo.getFriendUin();
        }
        transferRequest.mPeerUin = friendUin;
        if (TextUtils.isEmpty(friendUin)) {
            transferRequest.mPeerUin = message.frienduin;
        }
        transferRequest.mSecondId = message.selfuin;
        transferRequest.mUinType = message.istroop;
        transferRequest.mFileType = 1;
        transferRequest.mUniseq = message.uniseq;
        transferRequest.mIsUp = true;
        transferRequest.mBusiType = 1059;
        transferRequest.mLocalPath = picLocalPath;
        transferRequest.mUpCallBack = new b(sessionInfo, message, transferRequest, picLocalPath);
        return transferRequest;
    }

    private final void g(InterfaceC9185a afterGetPic, ZPlanActionInfo actionInfo, String senderUin) {
        com.tencent.mobileqq.zplan.emoticon.panel.util.a.f333231a.n(actionInfo, senderUin, Priority.HIGH, new c(afterGetPic));
    }

    private final void h(ZPlanActionInfo actionInfo, String senderUin, String receiverUin, InterfaceC9185a afterGetPic) {
        if (actionInfo.getOriginType() == 100) {
            g(afterGetPic, actionInfo, senderUin);
            return;
        }
        QLog.w("[zplan][ZPlanMessageUtil]", 1, "getMessagePicPath, unSupport type: " + actionInfo.getOriginType() + ", actionInfo:" + actionInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(String md5, String filePath) {
        if (TextUtils.isEmpty(md5) || TextUtils.isEmpty(filePath)) {
            return;
        }
        ReentrantLock reentrantLock = lock;
        reentrantLock.lock();
        try {
            Map<String, String> map = picFilePathCache;
            Intrinsics.checkNotNull(md5);
            Intrinsics.checkNotNull(filePath);
            map.put(md5, filePath);
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    private final void o(ZPlanActionInfo actionInfo, ZPlanSessionInfo sessionInfo, MessageForZPlan message, ZPlanUserInfo peerInfo) {
        String selfUin = sessionInfo.getSelfUin();
        String str = peerInfo != null ? peerInfo.uin : null;
        QQAppInterface j3 = bb.f335811a.j();
        if (j3 == null) {
            return;
        }
        d dVar = new d(actionInfo, message, j3, sessionInfo);
        QLog.i("[zplan][ZPlanMessageUtil]", 1, "uploadPicWhenGetPic, info=" + actionInfo);
        h(actionInfo, selfUin, str, dVar);
    }

    public final void i(Activity activity, ZPlanActionInfo actionInfo, ZPlanSessionInfo sessionInfo) {
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        QLog.i("[zplan][ZPlanMessageUtil]", 1, "sendZPlanGifMessage start");
        if (!(activity instanceof BaseActivity)) {
            QLog.w("[zplan][ZPlanMessageUtil]", 1, "sendZPlanGifMessage, activity is not BaseActivity, " + activity);
            return;
        }
        String A = ZPlanEmoticonUtil.f333176e.A(actionInfo, sessionInfo.getSelfUin());
        if (TextUtils.isEmpty(A)) {
            QLog.w("[zplan][ZPlanMessageUtil]", 1, "sendZPlanGifMessage, picPath is null, actionKey=" + com.tencent.mobileqq.zplan.emoticon.panel.util.a.f333231a.b(actionInfo, actionInfo.getPic2DMode(), sessionInfo.getSelfUin()));
            return;
        }
        Intent intent = new Intent();
        ArrayList<String> arrayList = new ArrayList<>();
        Intrinsics.checkNotNull(A);
        arrayList.add(A);
        intent.putExtra(PeakConstants.SEND_BUSINESS_TYPE, 1060);
        intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", arrayList);
        intent.putExtra("uin", sessionInfo.getFriendUin());
        intent.putExtra("uintype", sessionInfo.getSessionType());
        intent.putExtra("troop_uin", sessionInfo.getTroopUin());
        intent.putExtra("PicContants.NEED_COMPRESS", false);
        intent.putExtra(PeakConstants.SEND_SIZE_SPEC, 0);
        intent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", arrayList);
        HashMap hashMap = new HashMap();
        hashMap.put("id", String.valueOf(actionInfo.getId()));
        hashMap.put("name", String.valueOf(actionInfo.getName()));
        hashMap.put("player_number", String.valueOf(actionInfo.getPlayerNumber()));
        hashMap.put("action_type", String.valueOf(actionInfo.getOriginType()));
        hashMap.put("width", String.valueOf(actionInfo.getWidth()));
        hashMap.put("height", String.valueOf(actionInfo.getHeight()));
        intent.putExtra(IPicBus.ZPLAN_PIC_EXTRA_MAP, hashMap);
        ThreadManagerV2.excute(new SendPhotoTask((BaseActivity) activity, intent, null), 16, null, true);
    }

    public final void j(Activity activity, ZPlanActionInfo actionInfo, ZPlanSessionInfo sessionInfo, ZPlanUserInfo peerInfo, String coverPath) {
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        if (actionInfo.getOriginType() == 100 && actionInfo.getPic2DMode() == MODE.GIF) {
            i(activity, actionInfo, sessionInfo);
        } else {
            l(actionInfo, sessionInfo, peerInfo, coverPath);
        }
    }

    public final void l(ZPlanActionInfo actionInfo, ZPlanSessionInfo sessionInfo, ZPlanUserInfo peerInfo, String coverPath) {
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        Intrinsics.checkNotNullParameter(sessionInfo, "sessionInfo");
        AppInterface c16 = bb.f335811a.c();
        if (c16 == null) {
            QLog.e("[zplan][ZPlanMessageUtil]", 1, "sendZPlanMessage error, app null");
            return;
        }
        MessageForZPlan e16 = e(actionInfo, sessionInfo, peerInfo, coverPath);
        d(c16, e16, 0L);
        o(actionInfo, sessionInfo, e16, peerInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(MessageForZPlan message, int refreshType) {
        QQAppInterface l3 = bb.f335811a.l();
        if (l3 == null) {
            return;
        }
        message.serial();
        if (refreshType == 2) {
            message.extraflag = 32768;
            QQMessageFacade messageFacade = l3.getMessageFacade();
            if (messageFacade != null) {
                messageFacade.Z0(message.frienduin, message.istroop, message.uniseq, 32768, 0);
            }
        } else {
            QQMessageFacade messageFacade2 = l3.getMessageFacade();
            if (messageFacade2 != null) {
                messageFacade2.Y0(message.frienduin, message.istroop, message.uniseq, message.msgData);
            }
        }
        MqqHandler handler = l3.getHandler(ChatActivity.class);
        if (handler == null) {
            return;
        }
        Message message2 = new Message();
        message2.what = 80;
        message2.arg1 = refreshType;
        Bundle bundle = new Bundle();
        bundle.putLong("messageUniseq", message.uniseq);
        message2.setData(bundle);
        handler.sendMessage(message2);
    }

    public static /* synthetic */ void k(a aVar, Activity activity, ZPlanActionInfo zPlanActionInfo, ZPlanSessionInfo zPlanSessionInfo, ZPlanUserInfo zPlanUserInfo, String str, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            str = null;
        }
        aVar.j(activity, zPlanActionInfo, zPlanSessionInfo, zPlanUserInfo, str);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/message/a$b", "Lcom/tencent/mobileqq/pic/ad;", "Ltencent/im/msg/im_msg_body$RichText;", "richText", "Lcom/tencent/mobileqq/data/MessageRecord;", "g", "Lcom/tencent/mobileqq/pic/ad$a;", "info", "", "r", "result", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements ad {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ZPlanSessionInfo f334224d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ MessageForZPlan f334225e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ TransferRequest f334226f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f334227h;

        b(ZPlanSessionInfo zPlanSessionInfo, MessageForZPlan messageForZPlan, TransferRequest transferRequest, String str) {
            this.f334224d = zPlanSessionInfo;
            this.f334225e = messageForZPlan;
            this.f334226f = transferRequest;
            this.f334227h = str;
        }

        @Override // com.tencent.mobileqq.pic.ad
        public MessageRecord g(im_msg_body$RichText richText) {
            if (this.f334224d.getIsTroop()) {
                this.f334225e.setSharpPUrl(this.f334226f.mMd5);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("groupFileId", this.f334226f.mGroupFileID);
                this.f334225e.setReverseInfo(jSONObject.toString());
            } else {
                this.f334225e.setSharpPUrl(this.f334226f.mServerPath);
            }
            a aVar = a.f334220a;
            aVar.n(this.f334225e.getPicUrl(), this.f334227h);
            aVar.m(this.f334225e, 3);
            return this.f334225e;
        }

        @Override // com.tencent.mobileqq.pic.ad
        public void q(ad.a result) {
        }

        @Override // com.tencent.mobileqq.pic.ad
        public void r(ad.a info) {
        }
    }
}
