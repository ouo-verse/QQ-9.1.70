package com.tencent.mobileqq.activity.photo;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.y;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.receipt.ReceiptMsgManager;
import com.tencent.mobileqq.transfile.BaseUploadProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.FolderUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.qqnt.aio.longshot.LongShotNTManager;
import com.tencent.util.AutoSaveUtils;
import com.tencent.util.BinderWarpper;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.peak.PeakConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes10.dex */
public class SendPhotoActivity extends BaseActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: k0, reason: collision with root package name */
    public static final String f184111k0;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f184112a0;

    /* renamed from: b0, reason: collision with root package name */
    Messenger f184113b0;

    /* renamed from: c0, reason: collision with root package name */
    SendPhotoTask f184114c0;

    /* renamed from: d0, reason: collision with root package name */
    long f184115d0;

    /* renamed from: e0, reason: collision with root package name */
    long f184116e0;

    /* renamed from: f0, reason: collision with root package name */
    boolean f184117f0;

    /* renamed from: g0, reason: collision with root package name */
    MessageQueue.IdleHandler f184118g0;

    /* renamed from: h0, reason: collision with root package name */
    Handler f184119h0;

    /* renamed from: i0, reason: collision with root package name */
    TextView f184120i0;

    /* renamed from: j0, reason: collision with root package name */
    ProgressDialog f184121j0;

    /* loaded from: classes10.dex */
    private static class MyHandler extends Handler {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<SendPhotoActivity> f184123a;

        public MyHandler(SendPhotoActivity sendPhotoActivity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) sendPhotoActivity);
            } else {
                this.f184123a = new WeakReference<>(sendPhotoActivity);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean z16;
            ArrayList arrayList;
            boolean z17;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            SendPhotoActivity sendPhotoActivity = this.f184123a.get();
            if (sendPhotoActivity != null) {
                int i3 = message.what;
                if (i3 != 1) {
                    ArrayList arrayList2 = null;
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 4) {
                                super.handleMessage(message);
                                return;
                            } else {
                                sendPhotoActivity.finish();
                                return;
                            }
                        }
                        if (QLog.isColorLevel()) {
                            QLog.e(SendPhotoActivity.f184111k0, 2, "idleHandler time out");
                        }
                        if (sendPhotoActivity.f184114c0 == null) {
                            Looper.myQueue().removeIdleHandler(sendPhotoActivity.f184118g0);
                            SendPhotoTask sendPhotoTask = new SendPhotoTask(sendPhotoActivity, null, sendPhotoActivity.f184119h0);
                            sendPhotoActivity.f184114c0 = sendPhotoTask;
                            if (sendPhotoActivity.f184115d0 != 0) {
                                sendPhotoTask.K = SystemClock.uptimeMillis() - sendPhotoActivity.f184115d0;
                            }
                            ThreadManagerV2.post(sendPhotoActivity.f184114c0, 8, null, false);
                            return;
                        }
                        return;
                    }
                    if (sendPhotoActivity.f184119h0.hasMessages(2)) {
                        com.tencent.mobileqq.pic.f.d(SendPhotoActivity.f184111k0, "handleMessage", "remove delayed Message:MSG_CANCLE_PROGRESS");
                        sendPhotoActivity.f184119h0.removeMessages(2);
                    }
                    ProgressDialog progressDialog = sendPhotoActivity.f184121j0;
                    if (progressDialog != null && progressDialog.isShowing()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    sendPhotoActivity.G2();
                    ArrayList<String> stringArrayListExtra = sendPhotoActivity.getIntent().getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
                    if (stringArrayListExtra != null && stringArrayListExtra.size() > 0) {
                        String[] strArr = new String[stringArrayListExtra.size()];
                        stringArrayListExtra.toArray(strArr);
                        int intExtra = sendPhotoActivity.getIntent().getIntExtra("uintype", 1003);
                        QQAppInterface qQAppInterface = sendPhotoActivity.app;
                        Object obj = message.obj;
                        if (obj != null && "TimeOut".equals(obj.toString())) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        ThreadManagerV2.post(new Runnable(z17, strArr, intExtra, qQAppInterface) { // from class: com.tencent.mobileqq.activity.photo.SendPhotoActivity.MyHandler.1
                            static IPatchRedirector $redirector_;

                            /* renamed from: d, reason: collision with root package name */
                            final /* synthetic */ boolean f184124d;

                            /* renamed from: e, reason: collision with root package name */
                            final /* synthetic */ String[] f184125e;

                            /* renamed from: f, reason: collision with root package name */
                            final /* synthetic */ int f184126f;

                            /* renamed from: h, reason: collision with root package name */
                            final /* synthetic */ QQAppInterface f184127h;

                            {
                                this.f184124d = z17;
                                this.f184125e = strArr;
                                this.f184126f = intExtra;
                                this.f184127h = qQAppInterface;
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                    iPatchRedirector2.redirect((short) 1, this, MyHandler.this, Boolean.valueOf(z17), strArr, Integer.valueOf(intExtra), qQAppInterface);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector2 = $redirector_;
                                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                    iPatchRedirector2.redirect((short) 2, (Object) this);
                                    return;
                                }
                                SendPhotoActivity.I2();
                                if (this.f184124d) {
                                    m.j();
                                }
                                try {
                                    m.k(this.f184125e, this.f184126f, false, false, -1, this.f184127h);
                                } catch (Exception unused) {
                                }
                            }
                        }, 5, null, true);
                    }
                    Intent intent = sendPhotoActivity.getIntent();
                    intent.putExtra(com.tencent.mobileqq.utils.d.f307603i, 2);
                    if (!intent.hasExtra("extra_image_sender_tag")) {
                        intent.putExtra("extra_image_sender_tag", "SendPhotoActivity.handlePhoto");
                    }
                    Bundle data = message.getData();
                    ArrayList arrayList3 = new ArrayList();
                    if (data != null) {
                        data.setClassLoader(CompressInfo.class.getClassLoader());
                        ArrayList parcelableArrayList = data.getParcelableArrayList(PeakConstants.FLAG_COMPRESSINFOLIST);
                        if (parcelableArrayList != null) {
                            Iterator it = parcelableArrayList.iterator();
                            while (it.hasNext()) {
                                CompressInfo compressInfo = (CompressInfo) it.next();
                                com.tencent.mobileqq.pic.f.b(SendPhotoActivity.f184111k0, "handleMessage print CompressInfo", "info:" + compressInfo);
                                arrayList3.add(compressInfo.H);
                            }
                            int size = parcelableArrayList.size();
                            long nanoTime = System.nanoTime();
                            long j3 = (nanoTime - sendPhotoActivity.f184116e0) / 1000000;
                            String str = SendPhotoActivity.f184111k0;
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("compress startTime = ");
                            arrayList = parcelableArrayList;
                            sb5.append(sendPhotoActivity.f184116e0);
                            sb5.append("ns,finishTime = ");
                            sb5.append(nanoTime);
                            sb5.append("ns,duration = ");
                            sb5.append(j3);
                            sb5.append("ms,count = ");
                            sb5.append(size);
                            sb5.append(",isShowing = ");
                            sb5.append(z16);
                            com.tencent.mobileqq.pic.f.b(str, "CompressLog", sb5.toString());
                            m.h(j3, size, z16);
                            sendPhotoActivity.J2(sendPhotoActivity.app, nanoTime);
                            com.tencent.mobileqq.pic.f.b(str, "TimeCompare", "CompressFinish Time = " + nanoTime + "ns");
                        } else {
                            arrayList = parcelableArrayList;
                        }
                        arrayList2 = arrayList;
                    }
                    intent.putExtra("open_chatfragment_fromphoto", true);
                    SendPhotoActivity.M2(sendPhotoActivity, arrayList3);
                    intent.removeExtra(PeakConstants.SEND_BUSINESS_TYPE);
                    sendPhotoActivity.setResult(-1, sendPhotoActivity.getIntent());
                    sendPhotoActivity.finish();
                    boolean booleanExtra = sendPhotoActivity.getIntent().getBooleanExtra(PeakConstants.IS_WAIT_DEST_RESULT, false);
                    if (QLog.isColorLevel()) {
                        QLog.d("forward", 2, "sendPhotoActivity isWaitForResult=" + booleanExtra);
                    }
                    if (!booleanExtra) {
                        Intent intent2 = sendPhotoActivity.getIntent();
                        String stringExtra = intent2.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
                        String stringExtra2 = intent2.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
                        if (QLog.isColorLevel()) {
                            QLog.d(SendPhotoActivity.f184111k0, 2, "init className:" + stringExtra);
                        }
                        if (SplashActivity.class.getName().equals(stringExtra)) {
                            intent2.setClassName(stringExtra2, SplashActivity.getAliasName());
                        } else {
                            intent2.setClassName(stringExtra2, stringExtra);
                        }
                        intent2.putExtra("open_chatfragment", true);
                        intent2.addFlags(603979776);
                        sendPhotoActivity.startActivity(intent2);
                    }
                    SendPhotoActivity.P2(BaseApplication.getContext(), arrayList2);
                    return;
                }
                sendPhotoActivity.showProgressDialog(R.string.cuv);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68873);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f184111k0 = SendPhotoActivity.class.getName();
        }
    }

    public SendPhotoActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f184112a0 = true;
        this.f184115d0 = 0L;
        this.f184117f0 = false;
        this.f184118g0 = new MessageQueue.IdleHandler() { // from class: com.tencent.mobileqq.activity.photo.SendPhotoActivity.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SendPhotoActivity.this);
                }
            }

            @Override // android.os.MessageQueue.IdleHandler
            public boolean queueIdle() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 2, (Object) this)).booleanValue();
                }
                com.tencent.mobileqq.pic.f.b(SendPhotoActivity.f184111k0, "queueIdle", "start");
                SendPhotoActivity.this.f184119h0.removeMessages(3);
                SendPhotoActivity sendPhotoActivity = SendPhotoActivity.this;
                sendPhotoActivity.f184114c0 = new SendPhotoTask(sendPhotoActivity, null, sendPhotoActivity.f184119h0);
                ThreadManagerV2.post(SendPhotoActivity.this.f184114c0, 8, null, false);
                return false;
            }
        };
        this.f184119h0 = new MyHandler(this);
    }

    private void H2(Window window) {
        if (this.f184112a0 && window != null) {
            window.setWindowAnimations(R.style.azy);
        }
    }

    static void I2() {
        StringBuilder sb5 = new StringBuilder();
        String str = AppConstants.SDCARD_PATH;
        sb5.append(str);
        sb5.append("photo/");
        sb5.append(".nomedia");
        String str2 = str + "thumb/.nomedia";
        FileUtils.createFileIfNotExits(sb5.toString());
        FileUtils.createFileIfNotExits(str2);
        FileUtils.createFileIfNotExits(str + "thumb2/.nomedia");
    }

    private boolean K2() {
        Intent intent = getIntent();
        if (intent == null) {
            return false;
        }
        return PeakConstants.SEND_PHOTO_ACTIVITY_FROM_AIO_PHOTO_LIST.equals(intent.getStringExtra(PeakConstants.SEND_PHOTO_ACTIVITY_FROM));
    }

    private boolean L2() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("historicalFunctionalityBug_8_9_25")) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void M2(BaseActivity baseActivity, ArrayList<String> arrayList) {
        int intExtra;
        if (baseActivity == null) {
            return;
        }
        Intent intent = baseActivity.getIntent();
        int intExtra2 = intent.getIntExtra("uintype", 0);
        if (intExtra2 == 1008) {
            ArrayList<String> arrayList2 = new ArrayList<>();
            String simpleName = baseActivity.getClass().getSimpleName();
            QLog.d(simpleName, 2, "[report]Send Picture count=" + arrayList.size());
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                arrayList2.add(com.tencent.qqprotect.singleupdate.a.e(arrayList.get(i3)));
                QLog.d(simpleName, 2, "[report] picture " + i3 + "md5=" + com.tencent.qqprotect.singleupdate.a.e(arrayList.get(i3)) + ": path=" + arrayList.get(i3));
            }
            Intent intent2 = new Intent(IPublicAccountManager.PA_ACTION_PIC_RESULT);
            intent2.putExtra(IPublicAccountManager.PA_DATA_PIC_RESULT, arrayList.size());
            intent2.putStringArrayListExtra(IPublicAccountManager.PA_DATA_PIC_RESULT_FILEMD5S, arrayList2);
            baseActivity.sendBroadcast(intent2, "com.tencent.msg.permission.pushnotify");
        }
        if (baseActivity.app != null && (intExtra = intent.getIntExtra(PeakConstants.SEND_SIZE_SPEC, -1)) != -1) {
            ArrayList arrayList3 = new ArrayList(Arrays.asList(new String[arrayList.size()]));
            Collections.copy(arrayList3, arrayList);
            PhotoUtils.reportSendSize(baseActivity.app, intExtra, arrayList3);
        }
        String stringExtra = intent.getStringExtra("uin");
        if (stringExtra != null && intExtra2 == 1008 && ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).isMediaAndOtherSubscript(baseActivity.app, stringExtra)) {
            for (int i16 = 0; i16 < arrayList.size(); i16++) {
                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(baseActivity.app, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, stringExtra, "0X8005C9D", "0X8005C9D", 0, 0, "", "", "", "", false);
            }
        }
    }

    private static void N2(ProgressDialog progressDialog) {
        Window window = progressDialog.getWindow();
        if (window == null) {
            return;
        }
        window.clearFlags(2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00d4, code lost:
    
        if (r11.Q == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d8, code lost:
    
        if (r11.f258517h == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00da, code lost:
    
        if (r0 == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00dc, code lost:
    
        r7 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00dd, code lost:
    
        r9 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0092, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void P2(Context context, List<CompressInfo> list) {
        boolean z16;
        boolean z17;
        if (list != null && !list.isEmpty()) {
            boolean z18 = true;
            if (list.size() > 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            String string = BaseApplication.getContext().getString(R.string.a7s);
            String string2 = BaseApplication.getContext().getString(R.string.a7t);
            String string3 = BaseApplication.getContext().getString(R.string.a7o);
            String string4 = BaseApplication.getContext().getString(R.string.a7p);
            String string5 = BaseApplication.getContext().getString(R.string.a7q);
            String string6 = BaseApplication.getContext().getString(R.string.a7r);
            String string7 = BaseApplication.getContext().getString(R.string.a7v);
            String string8 = BaseApplication.getContext().getString(R.string.a7w);
            Iterator<CompressInfo> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    CompressInfo next = it.next();
                    if (next != null && next.f258518i) {
                        if (z16) {
                            string7 = string8;
                        }
                        z17 = true;
                    }
                } else {
                    string7 = "";
                    z17 = false;
                    break;
                }
            }
            if (!z17) {
                Iterator<CompressInfo> it5 = list.iterator();
                while (it5.hasNext()) {
                    CompressInfo next2 = it5.next();
                    if (next2 != null && !next2.Q && next2.f258517h) {
                        if (string3.equals(next2.f258519m)) {
                            if (!string3.equals(string7)) {
                                if (z16) {
                                    string3 = string4;
                                }
                                string7 = string3;
                            }
                        } else if (string.equals(next2.f258519m)) {
                            if (!string.equals(string7)) {
                                if (z16) {
                                    string = string2;
                                }
                                string7 = string;
                            }
                        } else {
                            z17 = true;
                        }
                        if (!z18) {
                            QQToast.makeText(context, string7, 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
                            return;
                        }
                        return;
                    }
                }
            }
            z18 = z17;
            if (!z18) {
            }
        }
    }

    void G2() {
        if (QLog.isColorLevel()) {
            QLog.d(f184111k0, 2, "TestPicSend finish compress,currentTime = " + System.currentTimeMillis());
        }
        ProgressDialog progressDialog = this.f184121j0;
        if (progressDialog != null && progressDialog.isShowing()) {
            this.f184121j0.cancel();
        }
    }

    public boolean J2(QQAppInterface qQAppInterface, long j3) {
        BaseUploadProcessor baseUploadProcessor;
        TransferRequest transferRequest;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, this, qQAppInterface, Long.valueOf(j3))).booleanValue();
        }
        Iterator<Map.Entry<String, IHttpCommunicatorListener>> it = ((ITransFileController) qQAppInterface.getRuntimeService(ITransFileController.class)).getProcessMap().entrySet().iterator();
        while (it.hasNext()) {
            IHttpCommunicatorListener value = it.next().getValue();
            if (value != null && (value instanceof BaseUploadProcessor) && (transferRequest = (baseUploadProcessor = (BaseUploadProcessor) value).mUiRequest) != null && transferRequest.mIsPresend) {
                baseUploadProcessor.mEnterAioTime = j3;
                if (QLog.isColorLevel()) {
                    QLog.d("PresendPicReport", 2, "initAllPSProcessorEnterAioTime ,Processor:" + baseUploadProcessor + ",time = " + j3);
                }
                z16 = true;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("PresendPicReport", 2, "initAllPSProcessorEnterAioTime result:" + z16);
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
        } else if (i16 == -1 && i3 == 102) {
            super.setResult(i16, intent);
            super.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        y z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).booleanValue();
        }
        this.mNeedStatusTrans = getIntent().getBooleanExtra("need_status_bar", true);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            this.f184112a0 = ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("enable_send_photo_dialog_change");
        }
        if (this.f184112a0) {
            this.mActNeedImmersive = false;
        } else {
            this.mActNeedImmersive = true;
        }
        if (L2() && K2()) {
            this.mActNeedImmersive = true;
            this.mNeedStatusTrans = true;
        }
        super.doOnCreate(bundle);
        ThreadManagerV2.executeOnFileThread(FolderUtils.f306952b);
        Intent intent = getIntent();
        if (intent.getBooleanExtra(AppConstants.Key.FORWARD_NT_LONG_SHOT_PIC, false)) {
            LongShotNTManager.INSTANCE.a().l(intent);
            setResult(-1);
            finish();
            return true;
        }
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        if (stringArrayListExtra == null) {
            com.tencent.mobileqq.pic.f.d(f184111k0, "initPicUploadInfos", "paths is null");
            finish();
            return true;
        }
        AutoSaveUtils.e(true, stringArrayListExtra);
        if (intent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false)) {
            SessionInfo sessionInfo = (SessionInfo) intent.getParcelableExtra(AppConstants.Key.SESSION_INFO);
            int intExtra = intent.getIntExtra(PeakConstants.SEND_SIZE_SPEC, 0);
            if (sessionInfo != null) {
                ReceiptMsgManager.n().u(this.app, sessionInfo, stringArrayListExtra, intExtra);
            }
            setResult(-1, getIntent());
            finish();
        }
        if (QLog.isColorLevel()) {
            QLog.d(f184111k0, 2, "TestPicSend start compress,currentTime = " + System.currentTimeMillis());
        }
        BinderWarpper binderWarpper = (BinderWarpper) intent.getParcelableExtra("presend_handler");
        if (binderWarpper != null) {
            this.f184113b0 = new Messenger(binderWarpper.binder);
            Message obtain = Message.obtain((Handler) null, 1);
            obtain.replyTo = new Messenger(this.f184119h0);
            int intExtra2 = intent.getIntExtra(PeakConstants.KEY_IS_SYNC_QZONE, 0);
            if (intExtra2 == 1 && (z16 = y.z1()) != null) {
                z16.j2(intExtra2, intent.getLongExtra(PeakConstants.KEY_QZONE_BATCH_ID, 0L), intent.getStringExtra(PeakConstants.KEY_QZONE_ALBUM_ID));
            }
            try {
                this.f184113b0.send(obtain);
                int size = stringArrayListExtra.size();
                if (size > 0) {
                    this.f184119h0.sendMessageDelayed(this.f184119h0.obtainMessage(2, "TimeOut"), size * 10000);
                    com.tencent.mobileqq.pic.f.d(f184111k0, "doOnCreate", "send delayed Message:MSG_CANCLE_PROGRESS, delayTime = " + (size * 5000));
                }
            } catch (RemoteException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(f184111k0, 2, e16.getMessage());
                }
                e16.printStackTrace();
            }
            this.f184116e0 = System.nanoTime();
        }
        com.tencent.mobileqq.pic.f.b(f184111k0, "initPicUploadInfos", "  totalCount:" + stringArrayListExtra.size());
        setCanLock(false);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.doOnDestroy();
        Looper.myQueue().removeIdleHandler(this.f184118g0);
        getIntent().removeExtra(PeakConstants.SEND_BUSINESS_TYPE);
        if (QLog.isColorLevel()) {
            QLog.d(f184111k0, 2, "doOnDestroy ," + this);
        }
        G2();
        QBaseActivity.isUnLockSuccess = true;
        this.f184119h0.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        SystemBarCompact systemBarComp;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.doOnResume();
        if (QLog.isColorLevel()) {
            QLog.d(f184111k0, 2, "doOnResume 1,mSend = " + this.f184117f0 + "," + this);
        }
        if (!this.f184117f0) {
            this.f184115d0 = SystemClock.uptimeMillis();
            Looper.myQueue().addIdleHandler(this.f184118g0);
            this.f184117f0 = true;
            this.f184119h0.sendEmptyMessageDelayed(3, 500L);
        }
        if (QLog.isColorLevel()) {
            QLog.d(f184111k0, 2, "doOnResume 2,mSend = " + this.f184117f0 + "," + this);
        }
        if (L2() && K2() && QQTheme.isDefaultTheme() && (systemBarComp = SystemBarActivityModule.getSystemBarComp(this)) != null && ImmersiveUtils.isSupporImmersive() == 1) {
            systemBarComp.setStatusBarColor(-1);
            ImmersiveUtils.setStatusTextColor(true, getWindow());
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.finish();
        if (this.f184112a0) {
            overridePendingTransition(0, R.anim.f154550b4);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    void showProgressDialog(int i3) {
        try {
            if (this.f184121j0 != null) {
                G2();
            } else {
                ReportProgressDialog reportProgressDialog = new ReportProgressDialog(this, R.style.qZoneInputDialog);
                this.f184121j0 = reportProgressDialog;
                H2(reportProgressDialog.getWindow());
                this.f184121j0.setCancelable(true);
                this.f184121j0.show();
                this.f184121j0.setContentView(R.layout.f168383uh);
                N2(this.f184121j0);
                TextView textView = (TextView) this.f184121j0.findViewById(R.id.photo_prievew_progress_dialog_text);
                this.f184120i0 = textView;
                textView.setText(i3);
            }
            if (!this.f184121j0.isShowing()) {
                this.f184121j0.show();
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
            com.tencent.mobileqq.pic.f.d("PIC_TAG_ERROR", "SendPhotoActivity.showProgressDialog", th5.toString());
        }
    }
}
