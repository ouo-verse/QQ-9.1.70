package com.tencent.mobileqq.receipt;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.SparseArray;
import com.qq.taf.jce.HexUtil;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.f;
import com.tencent.mobileqq.graytip.g;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.pttlogic.api.IPttBuffer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.view.au;
import com.tencent.mobileqq.structmsg.view.t;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
import tencent.im.msg.im_msg_body$RichText;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ReceiptMsgManager {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static ReceiptMsgManager f280201e;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, Boolean> f280202a;

    /* renamed from: b, reason: collision with root package name */
    private SparseArray<Bitmap> f280203b;

    /* renamed from: c, reason: collision with root package name */
    public MessageForPtt f280204c;

    /* renamed from: d, reason: collision with root package name */
    private HashMap<String, String> f280205d;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.receipt.ReceiptMsgManager$1, reason: invalid class name */
    /* loaded from: classes16.dex */
    class AnonymousClass1 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ QQAppInterface C;
        final /* synthetic */ SessionInfo D;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f280206d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f280207e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ RecordParams.RecorderParam f280208f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f280209h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f280210i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ boolean f280211m;
        final /* synthetic */ ReceiptMsgManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            this.this$0.f280204c.voiceLength = ((IQQRecorderUtils) QRoute.api(IQQRecorderUtils.class)).msToSec(this.f280206d);
            MessageForPtt messageForPtt = this.this$0.f280204c;
            messageForPtt.voiceChangeFlag = this.f280207e;
            messageForPtt.voiceType = this.f280208f.f307257f;
            messageForPtt.fullLocalPath = this.f280209h;
            if (this.f280210i == 4) {
                z16 = true;
            } else {
                z16 = false;
            }
            messageForPtt.sendFromvoiceChangePanelFlag = z16;
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(this.this$0.f280204c);
            ((IPttBuffer) QRoute.api(IPttBuffer.class)).flush(this.f280209h);
            Bundle bundle = new Bundle();
            bundle.putString("ReceiptMsgManager.EXTRA_KEY_PTT_PATH", this.f280209h);
            bundle.putInt("ReceiptMsgManager.EXTRA_KEY_PTT_SEND_SOURCE", this.f280210i);
            bundle.putBoolean("ReceiptMsgManager.EXTRA_KEY_PTT_COMPRESS_FINISHED", this.f280211m);
            ReceiptMsgManager receiptMsgManager = this.this$0;
            QQAppInterface qQAppInterface = this.C;
            SessionInfo sessionInfo = this.D;
            receiptMsgManager.v(qQAppInterface, sessionInfo.f179557e, sessionInfo.f179555d, sessionInfo.f179559f, receiptMsgManager.j(3), false, arrayList, bundle);
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class a implements ad {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        WeakReference<QQAppInterface> f280218d;

        /* renamed from: e, reason: collision with root package name */
        MessageRecord f280219e;

        /* renamed from: f, reason: collision with root package name */
        String f280220f;

        /* renamed from: h, reason: collision with root package name */
        int f280221h;

        public a(QQAppInterface qQAppInterface, MessageRecord messageRecord, String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, qQAppInterface, messageRecord, str, Integer.valueOf(i3));
                return;
            }
            this.f280218d = new WeakReference<>(qQAppInterface);
            this.f280219e = messageRecord;
            this.f280220f = str;
            this.f280221h = i3;
        }

        @Override // com.tencent.mobileqq.pic.ad
        public MessageRecord g(im_msg_body$RichText im_msg_body_richtext) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (MessageRecord) iPatchRedirector.redirect((short) 4, (Object) this, (Object) im_msg_body_richtext);
            }
            return null;
        }

        @Override // com.tencent.mobileqq.pic.ad
        public void q(ad.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
                return;
            }
            if (aVar.f258597a == 0) {
                MessageForStructing messageForStructing = (MessageForStructing) this.f280219e;
                AbsStructMsg absStructMsg = messageForStructing.structingMsg;
                absStructMsg.mResid = aVar.f258602f;
                absStructMsg.mFileName = String.valueOf(messageForStructing.uniseq);
                this.f280218d.get().getMessageFacade().Y0(this.f280220f, this.f280221h, messageForStructing.uniseq, messageForStructing.structingMsg.getBytes());
                this.f280218d.get().getMessageFacade().D0(this.f280219e, null);
                if (QLog.isColorLevel()) {
                    QLog.d("ReceiptMsgManager", 2, "send real struct msg done, uniseq: " + this.f280219e.uniseq);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("ReceiptMsgManager", 2, "upload receipt msg pack failed, result.errStr=" + aVar.f258598b + ",result.errStr=" + aVar.f258599c + " uniseq=" + this.f280219e.uniseq);
            }
            this.f280219e.extraflag = 32768;
            this.f280218d.get().getMsgCache().G1(this.f280220f, this.f280221h, this.f280219e.uniseq);
            Message lastMessage = this.f280218d.get().getMessageFacade().getLastMessage(this.f280220f, this.f280221h);
            if (lastMessage != null && lastMessage.uniseq == this.f280219e.uniseq) {
                lastMessage.extraflag = 32768;
            }
            ((MessageHandler) this.f280218d.get().getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).notifyUI(MessageHandler.k3(this.f280221h), false, new Object[]{this.f280220f, Integer.valueOf(this.f280221h), -1, null, 0L, Long.valueOf(this.f280219e.uniseq)});
        }

        @Override // com.tencent.mobileqq.pic.ad
        public void r(ad.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
            }
        }
    }

    ReceiptMsgManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f280205d = new HashMap<>();
            this.f280203b = new SparseArray<>(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String h(String str) {
        String str2 = "";
        long currentTimeMillis = System.currentTimeMillis();
        try {
            str2 = HexUtil.bytes2HexStr(MD5.getFileMd5(str));
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
        } catch (UnsatisfiedLinkError unused) {
            File file = new File(str);
            if (file.exists()) {
                try {
                    String d16 = com.tencent.qqprotect.singleupdate.a.d(file);
                    if (d16 != null) {
                        str2 = d16;
                    }
                } catch (IOException unused2) {
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("ReceiptMsgManager", 2, "calcMD5", "md5:" + str2 + ",cost:" + (System.currentTimeMillis() - currentTimeMillis));
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(MessageForPic messageForPic, int i3) {
        CompressInfo compressInfo = new CompressInfo(messageForPic.path, ((ICompressOperator) QRoute.api(ICompressOperator.class)).transformQuality(i3), 1009);
        ((ICompressOperator) QRoute.api(ICompressOperator.class)).start(compressInfo);
        String str = compressInfo.H;
        messageForPic.path = str;
        messageForPic.size = q.m(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AbsShareMsg j(int i3) {
        AbsShareMsg a16 = new AbsShareMsg.a(StructMsgForGeneralShare.class).g(107).d(BaseApplication.getContext().getString(R.string.f7u)).f(3).b("viewReceiptMessage", "", null, null, null).a();
        t tVar = new t();
        au auVar = new au();
        auVar.R0 = i3;
        tVar.m(auVar);
        a16.addItem(tVar);
        return a16;
    }

    private Bitmap k(Resources resources, int i3) {
        int f16 = BaseAIOUtils.f(10.0f, resources);
        int f17 = BaseAIOUtils.f(8.0f, resources);
        int f18 = BaseAIOUtils.f(245.0f, resources);
        int f19 = BaseAIOUtils.f(108.0f, resources);
        Bitmap o16 = o(resources, i3);
        Bitmap decodeResource = BitmapFactory.decodeResource(resources, R.drawable.c37);
        Canvas canvas = new Canvas();
        Bitmap createBitmap = Bitmap.createBitmap(f18, f19, Bitmap.Config.ARGB_8888);
        createBitmap.setDensity(resources.getDisplayMetrics().densityDpi);
        canvas.setBitmap(createBitmap);
        Paint paint = new Paint();
        canvas.drawBitmap(decodeResource, 0.0f, 0.0f, paint);
        canvas.drawBitmap(o16, f16, f17, paint);
        o16.recycle();
        decodeResource.recycle();
        return createBitmap;
    }

    private Bitmap l(Resources resources, int i3) {
        int f16 = BaseAIOUtils.f(10.0f, resources);
        int f17 = BaseAIOUtils.f(8.0f, resources);
        int f18 = BaseAIOUtils.f(175.0f, resources);
        int f19 = BaseAIOUtils.f(240.0f, resources);
        int f26 = BaseAIOUtils.f(108.0f, resources);
        Bitmap o16 = o(resources, i3);
        Bitmap decodeResource = BitmapFactory.decodeResource(resources, R.drawable.c38);
        Canvas canvas = new Canvas();
        Bitmap createBitmap = Bitmap.createBitmap(f19, f26, Bitmap.Config.ARGB_8888);
        createBitmap.setDensity(resources.getDisplayMetrics().densityDpi);
        canvas.setBitmap(createBitmap);
        Paint paint = new Paint();
        canvas.drawBitmap(decodeResource, f18, 0.0f, paint);
        canvas.drawBitmap(o16, f16, f17, paint);
        o16.recycle();
        decodeResource.recycle();
        return createBitmap;
    }

    public static ReceiptMsgManager n() {
        if (f280201e == null) {
            synchronized (ReceiptMsgManager.class) {
                if (f280201e == null) {
                    f280201e = new ReceiptMsgManager();
                }
            }
        }
        return f280201e;
    }

    private Bitmap o(Resources resources, int i3) {
        if (i3 != 2) {
            if (i3 != 3) {
                return BitmapFactory.decodeResource(resources, R.drawable.c3a);
            }
            return BitmapFactory.decodeResource(resources, R.drawable.c3_);
        }
        return BitmapFactory.decodeResource(resources, R.drawable.c39);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(QQAppInterface qQAppInterface, MessageRecord messageRecord) {
        String str = messageRecord.senderuin;
        int i3 = messageRecord.istroop;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 3000) {
                    str = ac.l(qQAppInterface, messageRecord.frienduin, str);
                }
            } else {
                TroopMemberInfo troopMemberInfoSync = ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).getTroopMemberInfoSync(messageRecord.frienduin, messageRecord.senderuin, null, "ReceiptMsgManager");
                if (troopMemberInfoSync != null) {
                    str = troopMemberInfoSync.nickInfo.getShowName();
                }
            }
        } else {
            str = ac.g(qQAppInterface, str, false);
        }
        x(qQAppInterface, messageRecord, str);
    }

    public static String q(MessageRecord messageRecord) {
        return messageRecord.getExtInfoFromExtStr("receipt_pic_size_spec");
    }

    public static String r(MessageRecord messageRecord) {
        return messageRecord.getExtInfoFromExtStr("receipt_msg_is_read");
    }

    private void s(QQAppInterface qQAppInterface, SessionInfo sessionInfo, ArrayList<ChatMessage> arrayList, @Nonnull Bundle bundle) {
        ThreadManagerV2.post(new Runnable(arrayList, bundle, qQAppInterface, sessionInfo) { // from class: com.tencent.mobileqq.receipt.ReceiptMsgManager.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ ArrayList f280212d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Bundle f280213e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ QQAppInterface f280214f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ SessionInfo f280215h;

            {
                this.f280212d = arrayList;
                this.f280213e = bundle;
                this.f280214f = qQAppInterface;
                this.f280215h = sessionInfo;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, ReceiptMsgManager.this, arrayList, bundle, qQAppInterface, sessionInfo);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                Iterator it = this.f280212d.iterator();
                while (it.hasNext()) {
                    ChatMessage chatMessage = (ChatMessage) it.next();
                    if (chatMessage instanceof MessageForPic) {
                        MessageForPic messageForPic = (MessageForPic) chatMessage;
                        if (new File(messageForPic.path).exists()) {
                            int i3 = this.f280213e.getInt("ReceiptMsgManager.EXTRA_KEY_PHOTO_SIZE_SPEC", 0);
                            ReceiptMsgManager.this.i(messageForPic, i3);
                            messageForPic.md5 = ReceiptMsgManager.this.h(messageForPic.path);
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inJustDecodeBounds = true;
                            options.inSampleSize = 1;
                            SafeBitmapFactory.decodeFile(messageForPic.path, options);
                            messageForPic.width = options.outWidth;
                            messageForPic.height = options.outHeight;
                            ReceiptMsgManager.w(this.f280214f, chatMessage, Integer.toString(i3));
                            if (RichMediaUtil.isPicLandscape(messageForPic.path)) {
                                messageForPic.width = options.outHeight;
                                messageForPic.height = options.outWidth;
                                if (QLog.isColorLevel()) {
                                    QLog.d("ReceiptMsgManager", 2, "packMsg", " pic is Landscape,swap w,h; options.outWidth = " + options.outWidth + ",options.outHeight = " + options.outHeight + ",mr.width = " + messageForPic.width + ",mr.height = " + messageForPic.height);
                                }
                            }
                        }
                    }
                }
                ReceiptMsgManager receiptMsgManager = ReceiptMsgManager.this;
                QQAppInterface qQAppInterface2 = this.f280214f;
                SessionInfo sessionInfo2 = this.f280215h;
                receiptMsgManager.v(qQAppInterface2, sessionInfo2.f179557e, sessionInfo2.f179555d, sessionInfo2.f179559f, receiptMsgManager.j(2), false, this.f280212d, this.f280213e);
            }
        }, 8, null, false);
    }

    private void t(QQAppInterface qQAppInterface, SessionInfo sessionInfo, String str, int i3) {
        ChatMessage I = ChatActivityFacade.I(qQAppInterface, sessionInfo, str);
        ArrayList<ChatMessage> arrayList = new ArrayList<>(1);
        if (I != null) {
            arrayList.add(I);
            Bundle bundle = new Bundle();
            bundle.putInt("ReceiptMsgManager.EXTRA_KEY_PHOTO_SIZE_SPEC", i3);
            s(qQAppInterface, sessionInfo, arrayList, bundle);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.w("ReceiptMsgManager", 2, "create pic msg error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(QQAppInterface qQAppInterface, String str, int i3, String str2, AbsStructMsg absStructMsg, boolean z16, ArrayList<ChatMessage> arrayList, @Nullable Bundle bundle) {
        if (QLog.isColorLevel()) {
            QLog.d("ReceiptMsgManager", 4, " sendReceiptMsg start");
        }
        HashMap<String, String> hashMap = this.f280205d;
        MessageRecord a16 = ShareMsgHelper.a(qQAppInterface, str, i3, absStructMsg);
        if (a16 != null) {
            a16.isReMultiMsg = true;
            if (z16) {
                qQAppInterface.getMessageFacade().T1(str, i3, 0L);
            }
            MultiMsgManager.w().P(qQAppInterface, str, i3, arrayList, hashMap, a16, 5, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(QQAppInterface qQAppInterface, MessageRecord messageRecord, String str) {
        messageRecord.saveExtInfoToExtStr("receipt_pic_size_spec", str);
        qQAppInterface.getMessageFacade().a1(messageRecord.frienduin, messageRecord.istroop, messageRecord.uniseq, AppConstants.Key.COLUMN_EXT_STR, messageRecord.extStr);
        qQAppInterface.getMessageFacade().a1(messageRecord.frienduin, messageRecord.istroop, messageRecord.uniseq, AppConstants.Key.COLUMN_EXT_LONG, Integer.valueOf(messageRecord.extLong));
    }

    private void x(QQAppInterface qQAppInterface, MessageRecord messageRecord, String str) {
        String format = String.format(BaseApplication.getContext().getString(R.string.f8c), str);
        MessageForUniteGrayTip messageForUniteGrayTip = new MessageForUniteGrayTip();
        g gVar = new g(messageRecord.frienduin, messageRecord.senderuin, format, messageRecord.istroop, MessageRecord.MSG_TYPE_UNITE_TAB_DB_INVI, 3211265, messageRecord.time);
        gVar.f213695r = false;
        messageForUniteGrayTip.initGrayTipMsg(qQAppInterface, gVar);
        messageForUniteGrayTip.msgUid = messageRecord.msgUid;
        messageForUniteGrayTip.shmsgseq = messageRecord.shmsgseq;
        f.a(qQAppInterface, messageForUniteGrayTip);
        ReportController.o(qQAppInterface, "CliOper", "", "", "0X800859B", "0X800859B", 0, 0, "", "", "", "");
    }

    public void g(QQAppInterface qQAppInterface, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) qQAppInterface, (Object) messageRecord);
            return;
        }
        String str = "receipt_gray_tip_showed-" + messageRecord.istroop;
        if (this.f280202a == null) {
            this.f280202a = new HashMap(3);
        }
        if (this.f280202a.get(qQAppInterface.getCurrentAccountUin() + str) != null) {
            if (QLog.isColorLevel()) {
                QLog.d("ReceiptMsgManager", 2, "mGrayTipsShowedMap has key: " + qQAppInterface.getCurrentAccountUin() + str);
                return;
            }
            return;
        }
        SharedPreferences preferences = qQAppInterface.getPreferences();
        boolean z16 = preferences.getBoolean(str, false);
        if (QLog.isColorLevel()) {
            QLog.d("ReceiptMsgManager", 2, "addGrayTipIfNeeded hasShowed: " + z16 + " with key: " + str);
        }
        if (!z16) {
            ThreadManagerV2.postImmediately(new Runnable(qQAppInterface, messageRecord) { // from class: com.tencent.mobileqq.receipt.ReceiptMsgManager.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ QQAppInterface f280216d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ MessageRecord f280217e;

                {
                    this.f280216d = qQAppInterface;
                    this.f280217e = messageRecord;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ReceiptMsgManager.this, qQAppInterface, messageRecord);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        ReceiptMsgManager.this.p(this.f280216d, this.f280217e);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            }, null, false);
            this.f280202a.put(qQAppInterface.getCurrentAccountUin() + str, Boolean.TRUE);
            preferences.edit().putBoolean(str, true).apply();
        }
    }

    public synchronized Bitmap m(Resources resources, boolean z16, int i3) {
        int i16;
        Bitmap k3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Bitmap) iPatchRedirector.redirect((short) 5, this, resources, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
        if (z16) {
            i16 = 1000;
        } else {
            i16 = 2000;
        }
        int i17 = i16 + i3;
        Bitmap bitmap = this.f280203b.get(i17);
        if (bitmap != null) {
            return bitmap;
        }
        if (z16) {
            k3 = l(resources, i3);
        } else {
            k3 = k(resources, i3);
        }
        this.f280203b.put(i17, k3);
        return k3;
    }

    public void u(QQAppInterface qQAppInterface, SessionInfo sessionInfo, List<String> list, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, qQAppInterface, sessionInfo, list, Integer.valueOf(i3));
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            t(qQAppInterface, sessionInfo, it.next(), i3);
        }
    }
}
