package com.tencent.mobileqq.kandian.biz.video;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.qqstory.network.pb.qqstory_bhd_upload_pic$RspStoryVideo;
import com.tencent.biz.troop.TroopMemberApiService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import java.util.HashMap;
import mqq.manager.Manager;
import tencent.im.msg.im_msg_body$RichText;

/* compiled from: P */
/* loaded from: classes33.dex */
public class e implements Manager, n62.a {

    /* renamed from: m, reason: collision with root package name */
    public static int f239644m;

    /* renamed from: d, reason: collision with root package name */
    TroopMemberApiService f239645d;

    /* renamed from: e, reason: collision with root package name */
    private QQAppInterface f239646e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f239647f = true;

    /* renamed from: h, reason: collision with root package name */
    HashMap<Long, Bundle> f239648h = new HashMap<>();

    /* renamed from: i, reason: collision with root package name */
    HashMap<Long, Bundle> f239649i = new HashMap<>();

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a extends TransProcessorHandler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            FileMsg fileMsg = (FileMsg) message.obj;
            if (fileMsg != null) {
                int i3 = fileMsg.fileType;
                if (i3 == 24 || i3 == 32) {
                    if ((i3 != 24 || fileMsg.commandId == 54) && message.what == 1003) {
                        Bundle remove = e.this.f239649i.remove(Long.valueOf(fileMsg.uniseq));
                        remove.putLong("uniseq", fileMsg.uniseq);
                        remove.putString(IPublicAccountH5AbilityPlugin.PICSERVERID, fileMsg.fileUrl);
                        qqstory_bhd_upload_pic$RspStoryVideo qqstory_bhd_upload_pic_rspstoryvideo = new qqstory_bhd_upload_pic$RspStoryVideo();
                        try {
                            qqstory_bhd_upload_pic_rspstoryvideo.mergeFrom(fileMsg.bdhExtendInfo);
                            if (qqstory_bhd_upload_pic_rspstoryvideo.retcode.get() == 0) {
                                String stringUtf8 = qqstory_bhd_upload_pic_rspstoryvideo.cdn_url.get().toStringUtf8();
                                if (TextUtils.isEmpty(stringUtf8)) {
                                    remove.putString("cdn_url", stringUtf8);
                                }
                            }
                        } catch (InvalidProtocolBufferMicroException unused) {
                        }
                        e.this.f239645d.X(81, remove);
                    }
                }
            }
        }
    }

    public e(QQAppInterface qQAppInterface) {
        this.f239646e = qQAppInterface;
    }

    @Override // n62.a
    public void b(Object obj) {
        if (this.f239645d == null && (obj instanceof TroopMemberApiService)) {
            this.f239645d = (TroopMemberApiService) obj;
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        if (this.f239645d != null) {
            this.f239645d = null;
        }
    }

    @Override // n62.a
    public void a(String str, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (!TextUtils.isEmpty(str) && com.tencent.biz.qqstory.utils.d.d(str)) {
            c(f239644m);
        }
        a aVar = new a();
        TransferRequest transferRequest = new TransferRequest();
        transferRequest.mUpCallBack = new b();
        ITransFileController iTransFileController = (ITransFileController) this.f239646e.getRuntimeService(ITransFileController.class);
        aVar.addFilter(BDHCommonUploadProcessor.class);
        iTransFileController.addHandle(aVar);
        transferRequest.mLocalPath = str;
        transferRequest.mIsUp = true;
        transferRequest.mFileType = 24;
        transferRequest.mCommandId = 54;
        transferRequest.mSelfUin = this.f239646e.getCurrentUin();
        transferRequest.mPeerUin = "0";
        transferRequest.mUniseq = System.currentTimeMillis() + ((long) (Math.random() * 10000.0d));
        iTransFileController.transferAsync(transferRequest);
        this.f239648h.put(Long.valueOf(transferRequest.mUniseq), bundle);
        this.f239649i.put(Long.valueOf(transferRequest.mUniseq), bundle);
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class b implements ad {
        b() {
        }

        @Override // com.tencent.mobileqq.pic.ad
        public MessageRecord g(im_msg_body$RichText im_msg_body_richtext) {
            return null;
        }

        @Override // com.tencent.mobileqq.pic.ad
        public void q(ad.a aVar) {
        }

        @Override // com.tencent.mobileqq.pic.ad
        public void r(ad.a aVar) {
        }
    }

    private void c(int i3) {
    }
}
