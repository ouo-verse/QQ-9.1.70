package com.tencent.mobileqq.avatar.api.impl;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.luggage.wxa.gf.j0;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.app.face.ProAvatarFaceDecoderImpl;
import com.tencent.mobileqq.app.face.util.AvatarOptimiseConfigUtil;
import com.tencent.mobileqq.avatar.api.IQQAvatarBroadcastService;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.IDiscussionHandlerService;
import com.tencent.mobileqq.troop.api.ITroopHandlerService;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.data.SquareJSConst;
import com.tenpay.sdk.util.QQFaceFileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes11.dex */
public class QQAvatarBroadcastServiceImpl implements IQQAvatarBroadcastService {
    static IPatchRedirector $redirector_ = null;
    private static final String QQ_HEAD_BROADCAST = "Q.qqhead.broadcast";
    private final Hashtable<String, Long> headQQHeadBroadcastTable;
    protected AppRuntime mApp;
    private final ProAvatarFaceDecoderImpl mFaceDecoder;
    private final int msgSendDisQQheadBroadcast;
    private final int msgSendNewgroupQQheadBroadcast;
    private final int msgSendQQheadBroadcast;
    private final int msgSendTroopQQheadBroadcast;
    private Handler qqHeadBroadcastHandler;
    private ArrayList<String> sendDisUinList;
    private ArrayList<String> sendNewTroopUinList;
    private ArrayList<String> sendTroopUinList;
    private ArrayList<String> sendUinList;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements DecodeTaskCompletionListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQAvatarBroadcastServiceImpl.this);
            }
        }

        @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
        public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onDecodeTaskCompleted: [");
            sb5.append(i16);
            sb5.append("_");
            sb5.append(StringUtil.getSimpleUinForPrint(str));
            sb5.append("] bitmap null? ");
            if (bitmap == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.i(QQAvatarBroadcastServiceImpl.QQ_HEAD_BROADCAST, 1, sb5.toString());
            if (bitmap != null) {
                String a16 = com.tencent.mobileqq.avatar.api.impl.a.a(i16, str);
                if (!TextUtils.isEmpty(a16)) {
                    QQAvatarBroadcastServiceImpl.this.sendQQHeadBroadcast(i16, str, 0, a16);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class b extends Handler {
        static IPatchRedirector $redirector_;

        b(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQAvatarBroadcastServiceImpl.this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i3 = message.what;
            int i16 = 0;
            if (i3 == 990) {
                ArrayList arrayList = new ArrayList();
                synchronized (QQAvatarBroadcastServiceImpl.this.sendUinList) {
                    arrayList.addAll(QQAvatarBroadcastServiceImpl.this.sendUinList);
                    QQAvatarBroadcastServiceImpl.this.sendUinList.clear();
                }
                ArrayList arrayList2 = new ArrayList();
                if (arrayList.size() > 0) {
                    while (i16 < arrayList.size()) {
                        arrayList2.add(QQAvatarBroadcastServiceImpl.this.getAvatarFilePath(1, (String) arrayList.get(i16)));
                        i16++;
                    }
                    QQAvatarBroadcastServiceImpl.this.sendHeadPathBroadcast(1, arrayList, arrayList2);
                }
                if (QLog.isDevelopLevel()) {
                    QQAvatarBroadcastServiceImpl.logD(QQAvatarBroadcastServiceImpl.QQ_HEAD_BROADCAST, 2, "headQQHeadBroadcast, user getQQHead resp uinList: ", arrayList);
                    return;
                }
                return;
            }
            if (i3 == 991) {
                ArrayList arrayList3 = new ArrayList();
                synchronized (QQAvatarBroadcastServiceImpl.this.sendTroopUinList) {
                    arrayList3.addAll(QQAvatarBroadcastServiceImpl.this.sendTroopUinList);
                    QQAvatarBroadcastServiceImpl.this.sendTroopUinList.clear();
                }
                ArrayList arrayList4 = new ArrayList();
                if (arrayList3.size() > 0) {
                    while (i16 < arrayList3.size()) {
                        arrayList4.add(QQAvatarBroadcastServiceImpl.this.getAvatarFilePath(4, (String) arrayList3.get(i16)));
                        i16++;
                    }
                    QQAvatarBroadcastServiceImpl.this.sendHeadPathBroadcast(4, arrayList3, arrayList4);
                }
                if (QLog.isDevelopLevel()) {
                    QQAvatarBroadcastServiceImpl.logD(QQAvatarBroadcastServiceImpl.QQ_HEAD_BROADCAST, 2, "headQQHeadBroadcast, group getQQHead resp uinList: ", arrayList3);
                    return;
                }
                return;
            }
            if (i3 == 993) {
                ArrayList arrayList5 = new ArrayList();
                synchronized (QQAvatarBroadcastServiceImpl.this.sendDisUinList) {
                    arrayList5.addAll(QQAvatarBroadcastServiceImpl.this.sendDisUinList);
                    QQAvatarBroadcastServiceImpl.this.sendDisUinList.clear();
                }
                ArrayList arrayList6 = new ArrayList();
                if (arrayList5.size() > 0) {
                    while (i16 < arrayList5.size()) {
                        arrayList6.add(QQAvatarBroadcastServiceImpl.this.getAvatarFilePath(101, (String) arrayList5.get(i16)));
                        i16++;
                    }
                    QQAvatarBroadcastServiceImpl.this.sendHeadPathBroadcast(101, arrayList5, arrayList6);
                }
                if (QLog.isDevelopLevel()) {
                    QQAvatarBroadcastServiceImpl.logD(QQAvatarBroadcastServiceImpl.QQ_HEAD_BROADCAST, 2, "headQQHeadBroadcast, dis getQQHead resp uinList: ", arrayList5);
                    return;
                }
                return;
            }
            if (i3 == 992) {
                ArrayList arrayList7 = new ArrayList();
                synchronized (QQAvatarBroadcastServiceImpl.this.sendNewTroopUinList) {
                    arrayList7.addAll(QQAvatarBroadcastServiceImpl.this.sendNewTroopUinList);
                    QQAvatarBroadcastServiceImpl.this.sendNewTroopUinList.clear();
                }
                ArrayList arrayList8 = new ArrayList();
                if (arrayList7.size() > 0) {
                    while (i16 < arrayList7.size()) {
                        arrayList8.add(QQAvatarBroadcastServiceImpl.this.getAvatarFilePath(113, (String) arrayList7.get(i16)));
                        i16++;
                    }
                    QQAvatarBroadcastServiceImpl.this.sendHeadPathBroadcast(113, arrayList7, arrayList8);
                }
                if (QLog.isDevelopLevel()) {
                    QQAvatarBroadcastServiceImpl.logD(QQAvatarBroadcastServiceImpl.QQ_HEAD_BROADCAST, 2, "headQQHeadBroadcast, newGroup getQQHead resp uinList: ", arrayList7);
                }
            }
        }
    }

    public QQAvatarBroadcastServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mFaceDecoder = new ProAvatarFaceDecoderImpl();
        this.sendUinList = new ArrayList<>();
        this.sendTroopUinList = new ArrayList<>();
        this.sendNewTroopUinList = new ArrayList<>();
        this.sendDisUinList = new ArrayList<>();
        this.headQQHeadBroadcastTable = new Hashtable<>();
        this.msgSendQQheadBroadcast = 990;
        this.msgSendTroopQQheadBroadcast = 991;
        this.msgSendNewgroupQQheadBroadcast = 992;
        this.msgSendDisQQheadBroadcast = j0.CTRL_INDEX;
        this.qqHeadBroadcastHandler = new b(ThreadManagerV2.getSubThreadLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getAvatarFilePath(int i3, String str) {
        if (AvatarOptimiseConfigUtil.b()) {
            return com.tencent.mobileqq.avatar.api.impl.a.a(i3, str);
        }
        return ((IQQAvatarDataService) this.mApp.getRuntimeService(IQQAvatarDataService.class, "")).getCustomFaceFilePath(i3, str, 0);
    }

    public static void logD(String str, int i3, String str2, ArrayList arrayList) {
        StringBuilder sb5 = new StringBuilder();
        if (arrayList != null && arrayList.size() > 0) {
            for (int i16 = 0; i16 < arrayList.size(); i16++) {
                sb5.append(arrayList.get(i16));
                sb5.append(", ");
            }
        }
        QLog.d(str, i3, str2 + sb5.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendHeadPathBroadcast(int i3, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        try {
            Intent intent = new Intent("com.tencent.qqhead.getheadresp");
            intent.setPackage(BaseApplication.getContext().getPackageName());
            intent.putExtra("faceType", i3);
            intent.putStringArrayListExtra(SquareJSConst.Params.PARAMS_UIN_LIST, arrayList);
            intent.putStringArrayListExtra("headPathList", arrayList2);
            if (QLog.isDevelopLevel()) {
                QLog.d(QQ_HEAD_BROADCAST, 4, "sendHeadPathBroadcast [" + i3 + "] uinList: ", arrayList);
            }
            this.mApp.getApp().sendBroadcast(intent, QQFaceFileUtil.QQFaceImageGetter.ReceiverQQFacePermission);
        } catch (Exception e16) {
            QLog.e(QQ_HEAD_BROADCAST, 2, "headQQHeadBroadcast error", e16);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ad  */
    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarBroadcastService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void headQQHeadBroadcast(Intent intent) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
            return;
        }
        if (intent != null && intent.getExtras() != null) {
            long currentTimeMillis = System.currentTimeMillis();
            int i3 = intent.getExtras().getInt("faceType", 1);
            ArrayList<String> stringArrayList = intent.getExtras().getStringArrayList(SquareJSConst.Params.PARAMS_UIN_LIST);
            ArrayList<String> arrayList = new ArrayList<>();
            ArrayList<String> arrayList2 = new ArrayList<>();
            ArrayList arrayList3 = new ArrayList();
            if (QLog.isDevelopLevel()) {
                logD(QQ_HEAD_BROADCAST, 2, "headQQHeadBroadcast, [" + i3 + "]receive uinList: ", stringArrayList);
            }
            byte b16 = 0;
            if (stringArrayList != null && stringArrayList.size() > 0) {
                for (int i16 = 0; i16 < stringArrayList.size(); i16++) {
                    String str = stringArrayList.get(i16);
                    if (str != null && str.length() > 0) {
                        String avatarFilePath = getAvatarFilePath(i3, str);
                        if (avatarFilePath != null) {
                            File file = new File(avatarFilePath);
                            if (file.exists() && file.isFile()) {
                                z16 = true;
                                if (!z16) {
                                    arrayList.add(str);
                                    arrayList2.add(avatarFilePath);
                                } else {
                                    arrayList3.add(str);
                                }
                            }
                        }
                        z16 = false;
                        if (!z16) {
                        }
                    }
                }
            }
            try {
                if (arrayList.size() > 0) {
                    Intent intent2 = new Intent("com.tencent.qqhead.getheadresp");
                    intent2.putExtra("faceType", i3);
                    intent2.putStringArrayListExtra(SquareJSConst.Params.PARAMS_UIN_LIST, arrayList);
                    intent2.putStringArrayListExtra("headPathList", arrayList2);
                    this.mApp.getApp().sendBroadcast(intent2, QQFaceFileUtil.QQFaceImageGetter.ReceiverQQFacePermission);
                }
            } catch (Exception e16) {
                QLog.e(QQ_HEAD_BROADCAST, 2, "headQQHeadBroadcast error", e16);
            }
            boolean b17 = AvatarOptimiseConfigUtil.b();
            long currentTimeMillis2 = System.currentTimeMillis();
            if (b17) {
                int i17 = 0;
                while (i17 < arrayList3.size()) {
                    String str2 = (String) arrayList3.get(i17);
                    synchronized (this.headQQHeadBroadcastTable) {
                        this.headQQHeadBroadcastTable.put(str2, Long.valueOf(currentTimeMillis2));
                    }
                    this.mFaceDecoder.requestDecodeFace(str2, 200, false, i3, false, (byte) 0, 3);
                    i17++;
                    arrayList3 = arrayList3;
                    b16 = b16;
                }
            }
            byte b18 = b16;
            ArrayList arrayList4 = arrayList3;
            if (!b17 && arrayList4.size() > 0) {
                IQQAvatarHandlerService iQQAvatarHandlerService = (IQQAvatarHandlerService) this.mApp.getRuntimeService(IQQAvatarHandlerService.class, "");
                int i18 = b18;
                while (i18 < arrayList4.size()) {
                    ArrayList arrayList5 = arrayList4;
                    String str3 = (String) arrayList5.get(i18);
                    if (i3 == 1) {
                        iQQAvatarHandlerService.getCustomHead(str3, b18, (byte) 2);
                    } else if (i3 == 4) {
                        iQQAvatarHandlerService.getTroopHead(str3);
                    } else if (i3 == 113) {
                        ((ITroopHandlerService) this.mApp.getRuntimeService(ITroopHandlerService.class, "")).updateGroupIcon(str3, true);
                    } else if (i3 == 101) {
                        ((IDiscussionHandlerService) this.mApp.getRuntimeService(IDiscussionHandlerService.class, "")).updateDiscussionIcon(str3, true);
                    }
                    synchronized (this.headQQHeadBroadcastTable) {
                        this.headQQHeadBroadcastTable.put(str3, Long.valueOf(currentTimeMillis2));
                    }
                    i18++;
                    arrayList4 = arrayList5;
                }
            }
            ArrayList arrayList6 = arrayList4;
            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
            if (QLog.isDevelopLevel()) {
                logD(QQ_HEAD_BROADCAST, 2, "headQQHeadBroadcast, response uinList: ", arrayList);
                logD(QQ_HEAD_BROADCAST, 2, "headQQHeadBroadcast, getQQHead uinList: ", arrayList6);
                QLog.i(QQ_HEAD_BROADCAST, 2, "headQQHeadBroadcast, cost=" + currentTimeMillis3);
            }
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        this.mApp = appRuntime;
        if (AvatarOptimiseConfigUtil.b()) {
            this.mFaceDecoder.setDecodeTaskCompletionListener(new a());
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.qqHeadBroadcastHandler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarBroadcastService
    public void sendQQHeadBroadcast(int i3, String str, int i16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), str, Integer.valueOf(i16), str2);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i(QQ_HEAD_BROADCAST, 2, "sendQQHeadBroadcast.type=" + i3 + ",uin=" + str + ",idType=" + i16 + ",path=" + str2);
        }
        if (!this.headQQHeadBroadcastTable.containsKey(str)) {
            QLog.e(QQ_HEAD_BROADCAST, 1, "sendQQHeadBroadcast not contain uin=" + StringUtil.getSimpleUinForPrint(str));
            return;
        }
        synchronized (this.headQQHeadBroadcastTable) {
            this.headQQHeadBroadcastTable.remove(str);
        }
        if (i3 == 1) {
            synchronized (this.sendUinList) {
                this.sendUinList.add(str);
            }
            Message obtainMessage = this.qqHeadBroadcastHandler.obtainMessage();
            obtainMessage.what = 990;
            this.qqHeadBroadcastHandler.removeMessages(990);
            this.qqHeadBroadcastHandler.sendMessageDelayed(obtainMessage, 500L);
        } else if (i3 == 4) {
            synchronized (this.sendTroopUinList) {
                this.sendTroopUinList.add(str);
            }
            Message obtainMessage2 = this.qqHeadBroadcastHandler.obtainMessage();
            obtainMessage2.what = 991;
            this.qqHeadBroadcastHandler.removeMessages(991);
            this.qqHeadBroadcastHandler.sendMessageDelayed(obtainMessage2, 500L);
        } else if (i3 == 101) {
            synchronized (this.sendDisUinList) {
                this.sendDisUinList.add(str);
            }
            Message obtainMessage3 = this.qqHeadBroadcastHandler.obtainMessage();
            obtainMessage3.what = j0.CTRL_INDEX;
            this.qqHeadBroadcastHandler.removeMessages(j0.CTRL_INDEX);
            this.qqHeadBroadcastHandler.sendMessageDelayed(obtainMessage3, 500L);
        } else if (i3 == 113) {
            synchronized (this.sendNewTroopUinList) {
                this.sendNewTroopUinList.add(str);
            }
            Message obtainMessage4 = this.qqHeadBroadcastHandler.obtainMessage();
            obtainMessage4.what = 992;
            this.qqHeadBroadcastHandler.removeMessages(992);
            this.qqHeadBroadcastHandler.sendMessageDelayed(obtainMessage4, 500L);
        }
        if (this.headQQHeadBroadcastTable.size() > 50) {
            synchronized (this.headQQHeadBroadcastTable) {
                long currentTimeMillis = System.currentTimeMillis();
                ArrayList arrayList = new ArrayList();
                Enumeration<String> keys = this.headQQHeadBroadcastTable.keys();
                while (keys.hasMoreElements()) {
                    String nextElement = keys.nextElement();
                    if (Math.abs(currentTimeMillis - this.headQQHeadBroadcastTable.get(nextElement).longValue()) > 180000) {
                        arrayList.add(nextElement);
                        QLog.i(QQ_HEAD_BROADCAST, 1, "sendQQHeadBroadcast timeout remove requestUin: " + StringUtil.getSimpleUinForPrint(nextElement));
                    }
                }
                for (int i17 = 0; i17 < arrayList.size(); i17++) {
                    this.headQQHeadBroadcastTable.remove((String) arrayList.get(i17));
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.avatar.api.IQQAvatarBroadcastService
    public void sendSelfQQHeadBroadcast(int i3, String str, int i16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), str, Integer.valueOf(i16), str2);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i(QQ_HEAD_BROADCAST, 2, "sendSelfQQHeadBroadcast.type=" + i3 + ",uin=" + str + ",idType=" + i16 + ",path=" + str2);
        }
        if (i3 == 1) {
            try {
                Intent intent = new Intent(FaceConstant.HeadBroadcast.BROADCAST_QQHEAD_SELF_UPDATE);
                intent.putExtra("faceType", 1);
                intent.putExtra("uin", str);
                intent.putExtra("headPath", str2);
                this.mApp.getApp().sendBroadcast(intent, QQFaceFileUtil.QQFaceImageGetter.ReceiverQQFacePermission);
            } catch (Exception e16) {
                QLog.e(QQ_HEAD_BROADCAST, 2, "sendSelfQQHeadBroadcast error", e16);
            }
        }
    }
}
