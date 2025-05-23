package com.tencent.biz.qqcircle.comment.emoji;

import android.app.Activity;
import android.content.Context;
import com.tencent.biz.qcircleshadow.lib.variation.HostHttpUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.biz.qqcircle.download.QCircleRichMediaDownLoadManager;
import com.tencent.biz.qqcircle.events.QFSCommentEmojiAddedEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.z;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.QQToastUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCommentEmojiOperationManager {

    /* renamed from: c, reason: collision with root package name */
    public static String f83581c = "QFSCommentEmojiOperationManager";

    /* renamed from: a, reason: collision with root package name */
    private String f83582a;

    /* renamed from: b, reason: collision with root package name */
    private com.tencent.qqnt.avatar.meta.refresh.c<Context> f83583b;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class b extends QQPermission.BasePermissionsListener {
        b() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
        }
    }

    public QFSCommentEmojiOperationManager(String str, Context context) {
        this.f83582a = str;
        this.f83583b = new com.tencent.qqnt.avatar.meta.refresh.c<>(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str) {
        try {
            QLog.d(f83581c, 1, "[onUploadEmoji] localPath=" + str);
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            ((IFavroamingManagerService) QCircleServiceImpl.getAppInterface().getRuntimeService(IFavroamingManagerService.class, "")).addCustomEmotions(arrayList, new AnonymousClass2());
        } catch (Exception e16) {
            QLog.e(f83581c, 1, "upload emoji error " + e16);
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.emoji.f
                @Override // java.lang.Runnable
                public final void run() {
                    QQToastUtil.showQQToast(1, R.string.f188913xz);
                }
            });
        }
    }

    public void e() {
        if (!NetworkUtil.isNetworkAvailable()) {
            QLog.d(f83581c, 1, "net work unavailable");
            QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f181603e8), 0);
            return;
        }
        QLog.d(f83581c, 1, "[handleEmojiAdd] emojiUrl=" + this.f83582a);
        if (FileUtils.isLocalPath(this.f83582a)) {
            h(this.f83582a);
            return;
        }
        String str = this.f83582a;
        String str2 = com.tencent.mobileqq.qcircle.api.constant.a.f261586k;
        String str3 = str2 + MD5Utils.toMD5(str) + ".jpg";
        File file = new File(str2);
        if (!file.exists() && !file.mkdir()) {
            QLog.d(f83581c, 1, "mkdir failed!");
            return;
        }
        if (new File(str3).exists()) {
            QLog.d(f83581c, 1, "emoji already downloaded " + str3 + "_" + str);
            h(str3);
            return;
        }
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mReqUrl = str;
        httpNetReq.mHttpMethod = 0;
        httpNetReq.mOutPath = str3;
        httpNetReq.mContinuErrorLimit = 2;
        httpNetReq.mCallback = new a(str3);
        HostHttpUtils.httpEngineServiceSendRequest(httpNetReq);
    }

    public void f(Activity activity) {
        int i3 = 1;
        boolean z16 = false;
        if (!HostNetworkUtils.isNetworkAvailable()) {
            QCircleToast.o(com.tencent.biz.qqcircle.utils.h.a(R.string.f181603e8), 0);
            QLog.d(f83581c, 1, "network not available");
            return;
        }
        z.b(activity, 2, new b(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QCIRCLE, QQPermissionConstants.Business.SCENE.QCIRCLE_SHARE_SAVE), QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE);
        QCircleRichMediaDownLoadManager.d dVar = new QCircleRichMediaDownLoadManager.d();
        if (URLDrawable.getDrawable(this.f83582a, URLDrawable.URLDrawableOptions.obtain()) != null) {
            z16 = GifDrawable.isGifFile(URLDrawable.getDrawable(this.f83582a, URLDrawable.URLDrawableOptions.obtain()).getFileInLocal());
        }
        String str = this.f83582a;
        if (z16) {
            i3 = 2;
        }
        dVar.h(str, i3, "");
        dVar.g(new QCircleRichMediaDownLoadManager.e() { // from class: com.tencent.biz.qqcircle.comment.emoji.QFSCommentEmojiOperationManager.4
            @Override // com.tencent.biz.qqcircle.download.QCircleRichMediaDownLoadManager.e
            public void onStatusChange(boolean z17) {
                if (z17) {
                    QLog.d(QFSCommentEmojiOperationManager.f83581c, 1, "on download successed");
                    RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.emoji.QFSCommentEmojiOperationManager.4.1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // java.lang.Runnable
                        public void run() {
                            Context context = (Context) QFSCommentEmojiOperationManager.this.f83583b.get();
                            if (context != null) {
                                QCircleToast.o(context.getString(R.string.f188953y3), 0);
                            }
                        }
                    });
                }
            }

            @Override // com.tencent.biz.qqcircle.download.QCircleRichMediaDownLoadManager.e
            public void onProgress(int i16) {
            }
        });
        QCircleRichMediaDownLoadManager.g().f(dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.qqcircle.comment.emoji.QFSCommentEmojiOperationManager$2, reason: invalid class name */
    /* loaded from: classes4.dex */
    public class AnonymousClass2 implements IFavroamingManagerService.AddCustomEmotionsCallback {
        AnonymousClass2() {
        }

        @Override // com.tencent.mobileqq.emosm.api.IFavroamingManagerService.AddCustomEmotionsCallback
        public void onUploadFinish(List<Integer> list) {
            int i3;
            if (list != null && list.size() > 0) {
                i3 = list.get(0).intValue();
            } else {
                i3 = -1;
            }
            if (i3 == 0) {
                QLog.d(QFSCommentEmojiOperationManager.f83581c, 1, "upload success");
                SimpleEventBus.getInstance().dispatchEvent(new QFSCommentEmojiAddedEvent(QFSCommentEmojiOperationManager.this.f83582a));
                if (MobileQQ.sProcessId == 1) {
                    e.f83623a.d(null, true);
                }
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.emoji.QFSCommentEmojiOperationManager.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QQToastUtil.showQQToast(2, R.string.f188923y0);
                    }
                });
                return;
            }
            if (i3 == 1) {
                SimpleEventBus.getInstance().dispatchEvent(new QFSCommentEmojiAddedEvent(QFSCommentEmojiOperationManager.this.f83582a));
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.emoji.QFSCommentEmojiOperationManager.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        QQToastUtil.showQQToast(R.string.f188933y1);
                    }
                });
            } else if (i3 != 2 && i3 != 3) {
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.emoji.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQToastUtil.showQQToast(1, R.string.f188913xz);
                    }
                });
            } else {
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.emoji.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQToastUtil.showQQToast(R.string.f188943y2);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.emosm.api.IFavroamingManagerService.AddCustomEmotionsCallback
        public void onProgressChanged(float f16, List<Integer> list) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements INetEngineListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f83589d;

        a(String str) {
            this.f83589d = str;
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp netResp) {
            int i3 = netResp.mResult;
            if (i3 == 0) {
                QLog.d(QFSCommentEmojiOperationManager.f83581c, 1, "on emoji download successed: " + this.f83589d + ", url=" + QFSCommentEmojiOperationManager.this.f83582a);
                QFSCommentEmojiOperationManager.this.h(this.f83589d);
                return;
            }
            if (i3 == 1) {
                QLog.d(QFSCommentEmojiOperationManager.f83581c, 1, "on emoji download failed: " + this.f83589d + ", url=" + QFSCommentEmojiOperationManager.this.f83582a);
                RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.qqcircle.comment.emoji.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        QQToastUtil.showQQToast(R.string.f188913xz);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
        }
    }
}
