package com.tencent.mobileqq.scribble.impl;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.scribble.IScribbleMsgUtils;
import com.tencent.mobileqq.scribble.ScribbleBaseOperator;
import com.tencent.mobileqq.scribble.e;
import com.tencent.mobileqq.scribble.f;
import com.tencent.mobileqq.transfile.BaseTransFileController;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ScribbleMsgUtilsImpl implements IScribbleMsgUtils {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "ScribbleMsgUtilsImpl";

    /* compiled from: P */
    /* loaded from: classes18.dex */
    static class a extends AsyncTask<Void, Void, Integer> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private AppRuntime f282581a;

        /* renamed from: b, reason: collision with root package name */
        private IScribbleMsgUtils.a f282582b;

        /* renamed from: c, reason: collision with root package name */
        private String f282583c;

        /* renamed from: d, reason: collision with root package name */
        private int f282584d;

        /* renamed from: e, reason: collision with root package name */
        private Bitmap f282585e;

        /* renamed from: f, reason: collision with root package name */
        private String f282586f;

        /* renamed from: g, reason: collision with root package name */
        private String f282587g;

        /* renamed from: h, reason: collision with root package name */
        private String f282588h;

        /* renamed from: i, reason: collision with root package name */
        private int f282589i;

        /* renamed from: j, reason: collision with root package name */
        private int f282590j;

        /* renamed from: k, reason: collision with root package name */
        private String f282591k;

        public a(AppRuntime appRuntime, String str, int i3, Bitmap bitmap, int i16, IScribbleMsgUtils.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, appRuntime, str, Integer.valueOf(i3), bitmap, Integer.valueOf(i16), aVar);
                return;
            }
            this.f282586f = "";
            this.f282587g = "";
            this.f282588h = "";
            this.f282590j = 0;
            this.f282591k = "SendAfterCombinePicAndDataTask";
            this.f282581a = appRuntime;
            this.f282582b = aVar;
            this.f282583c = str;
            this.f282584d = i3;
            this.f282585e = bitmap;
            this.f282589i = i16;
        }

        public byte[] a(Bitmap bitmap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (byte[]) iPatchRedirector.redirect((short) 5, (Object) this, (Object) bitmap);
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        }

        int b() {
            boolean z16;
            String str = e.a() + "temp/" + System.currentTimeMillis();
            String str2 = e.a() + "temp/" + System.currentTimeMillis() + "_data";
            IScribbleMsgUtils.a aVar = this.f282582b;
            if (aVar != null) {
                z16 = aVar.b(str2);
            } else {
                z16 = false;
            }
            if (!z16) {
                return e.f282564g;
            }
            if (!FileUtils.fileExists(str2)) {
                return e.f282565h;
            }
            byte[] a16 = a(this.f282585e);
            this.f282590j = a16.length;
            if (!f.a(a16, str2, str)) {
                return e.f282562e;
            }
            String b16 = f.b(str);
            if (TextUtils.isEmpty(b16)) {
                return e.f282563f;
            }
            this.f282586f = b16;
            this.f282587g = ScribbleMsgUtilsImpl.getScribbleCombineFile(b16);
            this.f282588h = ScribbleMsgUtilsImpl.getScribbleDataFilePath(this.f282586f);
            if (!f.c(str, this.f282587g).booleanValue()) {
                return e.f282562e;
            }
            if (!f.c(str2, this.f282588h).booleanValue()) {
                return e.f282562e;
            }
            FileUtils.deleteFile(str);
            FileUtils.deleteFile(str2);
            return e.f282561d;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Integer doInBackground(Void... voidArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) voidArr);
            }
            return Integer.valueOf(b());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Integer num) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) num);
                return;
            }
            super.onPostExecute(num);
            QLog.i(this.f282591k, 2, "doBeforeSendScribble result = " + num);
            if (num.intValue() == e.f282561d) {
                ScribbleBaseOperator scribbleBaseOperator = new ScribbleBaseOperator(this.f282581a);
                MessageForScribble b16 = scribbleBaseOperator.b(this.f282587g, this.f282586f, this.f282590j, this.f282583c, this.f282584d, this.f282589i);
                MessageForScribble.FileExistInfo fileExistInfo = b16.mExistInfo;
                fileExistInfo.mCombineFileExist = true;
                fileExistInfo.mDataFileExist = true;
                fileExistInfo.mLocalPathExist = true;
                fileExistInfo.mInit = true;
                scribbleBaseOperator.c(b16);
            }
            IScribbleMsgUtils.a aVar = this.f282582b;
            if (aVar != null) {
                aVar.a(num.intValue());
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                super.onPreExecute();
            }
        }
    }

    public ScribbleMsgUtilsImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static boolean checkFilePathLegal(String str) {
        File parentFile = new File(str).getParentFile();
        if (parentFile == null) {
            return false;
        }
        return parentFile.getAbsolutePath().equals(new File(e.a()).getAbsolutePath());
    }

    @Override // com.tencent.mobileqq.scribble.IScribbleMsgUtils
    public boolean ReSendScribbleMsgRecord(AppRuntime appRuntime, MessageForScribble messageForScribble) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime, (Object) messageForScribble)).booleanValue();
        }
        if (messageForScribble == null) {
            return false;
        }
        if (messageForScribble.isSendFromLocal()) {
            ((ITransFileController) appRuntime.getRuntimeService(ITransFileController.class, "")).removeProcessor(BaseTransFileController.makeKey(messageForScribble.frienduin, messageForScribble.uniseq));
        }
        ScribbleBaseOperator scribbleBaseOperator = new ScribbleBaseOperator(appRuntime);
        MessageForScribble a16 = scribbleBaseOperator.a(messageForScribble);
        if (a16 == null) {
            return false;
        }
        ThreadManagerV2.post(new Runnable(appRuntime, messageForScribble) { // from class: com.tencent.mobileqq.scribble.impl.ScribbleMsgUtilsImpl.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ AppRuntime f282579d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ MessageForScribble f282580e;

            {
                this.f282579d = appRuntime;
                this.f282580e = messageForScribble;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, ScribbleMsgUtilsImpl.this, appRuntime, messageForScribble);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                IMessageFacade iMessageFacade = (IMessageFacade) this.f282579d.getRuntimeService(IMessageFacade.class, "");
                MessageForScribble messageForScribble2 = this.f282580e;
                iMessageFacade.removeMsgByUniseq(messageForScribble2.frienduin, messageForScribble2.istroop, messageForScribble2.uniseq);
            }
        }, 5, null, false);
        scribbleBaseOperator.c(a16);
        return true;
    }

    protected void ScribbleFileDirUtilsCheck() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        File file = new File(e.a());
        if ((file.exists() && !file.isDirectory()) || !file.exists()) {
            file.mkdirs();
        }
    }

    @Override // com.tencent.mobileqq.scribble.IScribbleMsgUtils
    public void SendScribbleMsg(AppRuntime appRuntime, String str, int i3, Bitmap bitmap, int i16, IScribbleMsgUtils.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appRuntime, str, Integer.valueOf(i3), bitmap, Integer.valueOf(i16), aVar);
        } else {
            ScribbleFileDirUtilsCheck();
            new a(appRuntime, str, i3, bitmap, i16, aVar).execute(new Void[0]);
        }
    }

    @Override // com.tencent.mobileqq.scribble.IScribbleMsgUtils
    public boolean downloadScribble(MessageForScribble messageForScribble) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) messageForScribble)).booleanValue();
        }
        return new ScribbleBaseOperator(MobileQQ.sMobileQQ.waitAppRuntime(null)).d(messageForScribble, null);
    }

    @Override // com.tencent.mobileqq.scribble.IScribbleMsgUtils
    public String getScribbleCombineFile(MessageForScribble messageForScribble) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? (messageForScribble == null || TextUtils.isEmpty(messageForScribble.combineFileMd5)) ? "" : getScribbleCombineFile(messageForScribble.combineFileMd5) : (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) messageForScribble);
    }

    @Override // com.tencent.mobileqq.scribble.IScribbleMsgUtils
    public byte[] getScribbleDataByte(MessageForScribble messageForScribble) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (byte[]) iPatchRedirector.redirect((short) 7, (Object) this, (Object) messageForScribble);
        }
        return f.d(getScribbleDataFilePath(messageForScribble));
    }

    @Override // com.tencent.mobileqq.scribble.IScribbleMsgUtils
    public String getScribbleDataFilePath(MessageForScribble messageForScribble) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? (messageForScribble == null || TextUtils.isEmpty(messageForScribble.combineFileMd5)) ? "" : getScribbleDataFilePath(messageForScribble.combineFileMd5) : (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) messageForScribble);
    }

    @Override // com.tencent.mobileqq.scribble.IScribbleMsgUtils
    public int getScribbleDataReadyState(MessageForScribble messageForScribble) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) messageForScribble)).intValue();
        }
        MessageForScribble.FileExistInfo fileExistInfo = messageForScribble.mExistInfo;
        boolean z16 = fileExistInfo.mDataFileExist;
        if (!fileExistInfo.mInit) {
            z16 = FileUtils.fileExists(getScribbleDataFilePath(messageForScribble));
        }
        MessageForScribble.FileExistInfo fileExistInfo2 = messageForScribble.mExistInfo;
        boolean z17 = fileExistInfo2.mCombineFileExist;
        if (!fileExistInfo2.mInit) {
            z17 = FileUtils.fileExists(getScribbleCombineFile(messageForScribble));
        }
        if (z16 && z17) {
            return e.f282560c;
        }
        if (!z16 && z17) {
            return e.f282559b;
        }
        return e.f282558a;
    }

    @Override // com.tencent.mobileqq.scribble.IScribbleMsgUtils
    public int splitPureDataFromCombineFile(MessageForScribble messageForScribble) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) messageForScribble)).intValue();
        }
        if (messageForScribble != null && messageForScribble.combineFileMd5 != null) {
            String scribbleCombineFile = getScribbleCombineFile(messageForScribble);
            if (!FileUtils.fileExists(scribbleCombineFile)) {
                return e.f282566i;
            }
            long fileSizes = FileUtils.getFileSizes(scribbleCombineFile);
            int i3 = messageForScribble.offSet;
            if (i3 > 0 && i3 < ((int) fileSizes)) {
                String scribbleDataFilePath = getScribbleDataFilePath(messageForScribble);
                if (FileUtils.fileExists(scribbleDataFilePath)) {
                    FileUtils.deleteFile(scribbleDataFilePath);
                }
                if (f.e(scribbleCombineFile, messageForScribble.offSet, scribbleDataFilePath)) {
                    return e.f282561d;
                }
                return e.f282562e;
            }
            QLog.e(TAG, 2, " offSet = " + messageForScribble.offSet + " FileSize : " + fileSizes);
            return e.f282567j;
        }
        return e.f282567j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getScribbleCombineFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str2 = e.a() + str;
        return !checkFilePathLegal(str2) ? "" : str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getScribbleDataFilePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str2 = e.a() + str + "_data";
        return !checkFilePathLegal(str2) ? "" : str2;
    }
}
