package com.tencent.mobileqq.flashchat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.commonsdk.zip.QZipFile;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StartAppCheckHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.mobileqq.config.QStorageSafeDeleteException;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.config.as;
import com.tencent.mobileqq.config.business.p;
import com.tencent.mobileqq.config.n;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FlashChatManager implements Manager {
    static IPatchRedirector $redirector_;
    public static SparseArray<Integer> P;
    public static SparseArray<Long> Q;
    boolean C;
    private boolean D;
    MessageForArkFlashChat E;
    public CopyOnWriteArrayList<MessageForArkFlashChat> F;
    public ConcurrentHashMap<Long, Long> G;
    public ConcurrentHashMap<String, String> H;
    public AtomicBoolean I;
    public ArrayList<FlashChatItem> J;
    public SparseArray<String> K;
    public ConcurrentHashMap<String, String> L;
    boolean M;
    int[] N;

    /* renamed from: d, reason: collision with root package name */
    QQAppInterface f209776d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f209777e;

    /* renamed from: f, reason: collision with root package name */
    public b f209778f;

    /* renamed from: h, reason: collision with root package name */
    String f209779h;

    /* renamed from: i, reason: collision with root package name */
    as f209780i;

    /* renamed from: m, reason: collision with root package name */
    private HashMap<String, String> f209781m;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static final class StopTask implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public CopyOnWriteArrayList<MessageForArkFlashChat> f209783d;

        /* renamed from: e, reason: collision with root package name */
        public Long f209784e;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            CopyOnWriteArrayList<MessageForArkFlashChat> copyOnWriteArrayList = this.f209783d;
            if (copyOnWriteArrayList == null) {
                return;
            }
            Iterator<MessageForArkFlashChat> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                MessageForArkFlashChat next = it.next();
                Long l3 = this.f209784e;
                if (l3 == null || l3.longValue() != next.uniseq) {
                    next.stopAnim();
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f209785a;

        /* renamed from: b, reason: collision with root package name */
        public String f209786b;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public static a a(String str) {
            try {
                a aVar = new a();
                JSONObject jSONObject = new JSONObject(str);
                JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                aVar.f209785a = jSONObject.getString("version");
                JSONArray jSONArray = jSONObject2.getJSONArray("list");
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i3);
                    aVar.f209786b = jSONObject3.getString("scid");
                    JSONObject optJSONObject = jSONObject3.optJSONObject("condition");
                    if (optJSONObject != null && "2".equals(optJSONObject.optString("platform"))) {
                        break;
                    }
                }
                return aVar;
            } catch (Exception unused) {
                return null;
            }
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return "FlashPackCfg{version='" + this.f209785a + "', zipScid='" + this.f209786b + "'}";
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class b implements n<String> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f209787a;

        /* renamed from: b, reason: collision with root package name */
        public String f209788b;

        /* renamed from: c, reason: collision with root package name */
        public String f209789c;

        /* renamed from: d, reason: collision with root package name */
        public String f209790d;

        /* renamed from: e, reason: collision with root package name */
        public String f209791e;

        /* renamed from: f, reason: collision with root package name */
        public String f209792f;

        /* renamed from: g, reason: collision with root package name */
        public String f209793g;

        /* renamed from: h, reason: collision with root package name */
        public String f209794h;

        /* renamed from: i, reason: collision with root package name */
        public int f209795i;

        /* renamed from: j, reason: collision with root package name */
        public int f209796j;

        /* renamed from: k, reason: collision with root package name */
        public int f209797k;

        /* renamed from: l, reason: collision with root package name */
        public int f209798l;

        /* renamed from: m, reason: collision with root package name */
        public int f209799m;

        /* renamed from: n, reason: collision with root package name */
        public int f209800n;

        /* renamed from: o, reason: collision with root package name */
        public int f209801o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f209802p;

        /* renamed from: q, reason: collision with root package name */
        public boolean f209803q;

        /* renamed from: r, reason: collision with root package name */
        public String f209804r;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f209787a = "1";
            this.f209788b = "";
            this.f209789c = "";
            this.f209790d = "";
            this.f209791e = "";
            this.f209792f = "";
            this.f209793g = "";
            this.f209794h = "1";
            this.f209795i = 2;
            this.f209796j = 2;
            this.f209797k = 2;
            this.f209798l = 3;
            this.f209799m = 3;
            this.f209800n = 60;
            this.f209801o = 60;
            this.f209804r = "";
        }

        @Override // com.tencent.mobileqq.config.n
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onParse(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.f209787a = jSONObject.optString("entry", "1");
                this.f209788b = jSONObject.optString("name", null);
                this.f209790d = jSONObject.optString("icon", null);
                this.f209792f = jSONObject.optString("actionI", null);
                this.f209793g = jSONObject.optString("actionA", null);
                this.f209789c = jSONObject.optString("url", null);
                this.f209795i = jSONObject.optInt("scC", 2);
                this.f209796j = jSONObject.optInt("hiC", 2);
                this.f209797k = jSONObject.optInt("flC", 2);
                this.f209798l = jSONObject.optInt("piC", 3);
                this.f209799m = jSONObject.optInt("tvC", 3);
                this.f209794h = jSONObject.optString("recordRule", "1");
                this.f209800n = jSONObject.optInt("pIn", 60);
                this.f209801o = jSONObject.optInt("tvI", 60);
                this.f209802p = "1".equals(jSONObject.optString("qimNotifyEnable", "0"));
                this.f209803q = "1".equals(jSONObject.optString("qimPopUpEnable", "0"));
                this.f209804r = jSONObject.optString("qimNotifySource", "");
                this.f209791e = jSONObject.optString("qimNotifyLogo", "");
            } catch (Exception e16) {
                QLog.e("FlashChat", 1, "handleFlashChatConfig failed" + e16);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(71951);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 37)) {
            redirector.redirect((short) 37);
        } else {
            P = null;
            Q = null;
        }
    }

    public FlashChatManager(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f209777e = true;
        this.f209778f = new b();
        this.f209780i = as.a("flashchat");
        this.f209781m = new HashMap<>();
        this.E = null;
        this.F = new CopyOnWriteArrayList<>();
        this.G = new ConcurrentHashMap<>();
        this.H = new ConcurrentHashMap<>();
        this.I = new AtomicBoolean(false);
        this.K = new SparseArray<>();
        this.L = new ConcurrentHashMap<>();
        this.M = false;
        this.N = new int[]{3, 4, 2, 1, 0};
        this.f209776d = qQAppInterface;
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.flashchat.FlashChatManager.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlashChatManager.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    FlashChatManager.this.w();
                }
            }
        }, 8, null, true);
    }

    protected static final String[] A(String str, String str2) {
        int indexOf;
        String[] strArr = {"", ""};
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        if (TextUtils.isEmpty(str)) {
            indexOf = -1;
        } else {
            indexOf = str.indexOf(QzoneWebViewOfflinePlugin.STR_DEVIDER);
        }
        if (indexOf == -1) {
            strArr[0] = str;
        } else {
            strArr[0] = str.substring(0, indexOf);
            strArr[1] = str.substring(indexOf + 3);
        }
        return strArr;
    }

    private void F(String str, String str2) throws Exception {
        InputStream inputStream;
        if (QLog.isColorLevel()) {
            QLog.d("FlashChat", 2, "uncompressZip: path=" + str + ", destDir=" + str2);
        }
        File file = new File(str2 + File.separator);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileOutputStream fileOutputStream = null;
        try {
            QZipFile qZipFile = new QZipFile(str);
            Enumeration<? extends ZipEntry> entries = qZipFile.entries();
            byte[] bArr = new byte[8192];
            while (entries.hasMoreElements()) {
                ZipEntry nextElement = entries.nextElement();
                String name = nextElement.getName();
                if (name != null && !name.contains("../")) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(str2);
                    String str3 = File.separator;
                    sb5.append(str3);
                    sb5.append(name);
                    String sb6 = sb5.toString();
                    if (nextElement.isDirectory()) {
                        File file2 = new File(sb6);
                        if (!file2.exists()) {
                            file2.mkdir();
                        }
                    } else {
                        int lastIndexOf = sb6.lastIndexOf(str3);
                        String substring = sb6.substring(0, lastIndexOf);
                        if (!sb6.substring(lastIndexOf + 1).startsWith(".")) {
                            File file3 = new File(substring);
                            if (!file3.exists()) {
                                file3.mkdir();
                            }
                            File file4 = new File(sb6 + ".tmp");
                            File file5 = new File(sb6);
                            if (file4.exists()) {
                                file4.delete();
                            }
                            FileOutputStream fileOutputStream2 = new FileOutputStream(file4);
                            try {
                                inputStream = qZipFile.getInputStream(nextElement);
                                while (true) {
                                    try {
                                        int read = inputStream.read(bArr, 0, 8192);
                                        if (read == -1) {
                                            break;
                                        } else {
                                            fileOutputStream2.write(bArr, 0, read);
                                        }
                                    } catch (Throwable th5) {
                                        th = th5;
                                        fileOutputStream = fileOutputStream2;
                                        if (fileOutputStream != null) {
                                            try {
                                                fileOutputStream.close();
                                            } catch (IOException e16) {
                                                e16.printStackTrace();
                                            }
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                                throw th;
                                            } catch (IOException e17) {
                                                e17.printStackTrace();
                                                throw th;
                                            }
                                        }
                                        throw th;
                                    }
                                }
                                fileOutputStream2.flush();
                                fileOutputStream2.close();
                                inputStream.close();
                                if (!FileUtils.renameFile(file4, file5)) {
                                    FileUtils.copyFile(file4, file5);
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                inputStream = null;
                            }
                        }
                    }
                }
            }
        } catch (Throwable th7) {
            th = th7;
            inputStream = null;
        }
    }

    public static boolean c(Context context, String str, String str2, String str3, QQAppInterface qQAppInterface) {
        Intent launchIntentForPackage;
        if (QLog.isColorLevel()) {
            QLog.d("FlashChat", 2, "SourceClickHandler clickAppMsg url = " + str + ", actionData = " + str2 + ", actionDataA = " + str3);
        }
        String[] A = A(str2, str3);
        PackageManager packageManager = context.getPackageManager();
        try {
            if (InstalledAppListMonitor.getPackageInfo(packageManager, A[0], 1) == null || (launchIntentForPackage = InstalledAppListMonitor.getLaunchIntentForPackage(packageManager, A[0])) == null) {
                return false;
            }
            launchIntentForPackage.addFlags(67108864);
            if (!TextUtils.isEmpty(A[1])) {
                launchIntentForPackage.setData(Uri.parse(A[1]));
            }
            try {
                StartAppCheckHandler startAppCheckHandler = (StartAppCheckHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.STARTAPPCHECK_HANDLER);
                launchIntentForPackage.putExtra("report_open_type", "flashChat");
                launchIntentForPackage.putExtra("report_url", "");
                launchIntentForPackage.putExtra("report_from", "1");
                launchIntentForPackage.putExtra("report_click_origin", "AIOTail");
                launchIntentForPackage.putExtra("report_class_name", context.getClass().getName());
                startAppCheckHandler.J2(A[0].trim(), context, launchIntentForPackage);
            } catch (Exception unused) {
                if (QLog.isColorLevel()) {
                    QLog.d("AppStartedHandler", 2, "<-- StartAppCheckHandler AbsShareMSG Failed!");
                }
                context.startActivity(launchIntentForPackage);
            }
            return true;
        } catch (PackageManager.NameNotFoundException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("FlashChat", 2, e16.getMessage());
            }
        } catch (RuntimeException e17) {
            if (QLog.isColorLevel()) {
                QLog.d("FlashChat", 2, e17.getMessage());
            }
        }
    }

    public static boolean e(Context context, String str, String str2, MessageRecord messageRecord) {
        if (QLog.isColorLevel()) {
            QLog.d("FlashChat", 2, "SourceClickHandler clickWebMsg  url = " + str);
        }
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("http://") || str.startsWith("https://")) {
                Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
                intent.putExtra("key_isReadModeEnabled", true);
                intent.putExtra("title", str2);
                intent.putExtra("url", str);
                context.startActivity(intent);
                if (messageRecord != null) {
                    ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(messageRecord, intent, str);
                    ReportController.n(null, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, str, "", "", "");
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public static String k(String str) {
        return str.substring(0, str.lastIndexOf("."));
    }

    public static final int m(MessageRecord messageRecord) {
        if (messageRecord instanceof MessageForArkFlashChat) {
            return 1;
        }
        if (messageRecord instanceof MessageForScribble) {
            return 0;
        }
        if (messageRecord instanceof MessageForPic) {
            return 3;
        }
        if (messageRecord instanceof MessageForShortVideo) {
            return 4;
        }
        return -1;
    }

    public static String r(String str) {
        if (!TextUtils.isEmpty(str)) {
            int length = str.length() - 1;
            int i3 = 0;
            while (i3 <= length && str.charAt(i3) == ' ') {
                i3++;
            }
            int i16 = length;
            while (i16 >= i3 && str.charAt(i16) == ' ') {
                i16--;
            }
            if (i3 != 0 || i16 != length) {
                if (i3 <= i16) {
                    return str.substring(i3, i16 + 1);
                }
            } else {
                return str;
            }
        }
        return "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x001d, code lost:
    
        if (r5 != 3) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0018, code lost:
    
        if (r5 == 3) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String x(QQAppInterface qQAppInterface, FlashChatItem flashChatItem) {
        int currentUserVipType = ((ISVIPHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).getCurrentUserVipType();
        int i3 = flashChatItem.feedType;
        boolean z16 = false;
        boolean z17 = true;
        if (i3 != 4) {
            if (i3 == 5) {
            }
        } else {
            if (currentUserVipType != 1) {
            }
            z16 = true;
            z17 = z16;
        }
        if (!z17) {
            if (i3 == 5) {
                return "CJCLUBT";
            }
            return "LTMCLUB";
        }
        return null;
    }

    public void B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FlashChat", 2, "requestAIOFlashItems");
        }
        NewIntent newIntent = new NewIntent(this.f209776d.getApplication(), c.class);
        newIntent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 1);
        this.f209776d.startServlet(newIntent);
    }

    public void C(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.f209781m.put(this.f209776d.getCurrentAccountUin(), str);
        }
    }

    public void D(Long l3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) l3);
            return;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList) this.F.clone();
        this.F.clear();
        if (copyOnWriteArrayList == null) {
            return;
        }
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            MessageForArkFlashChat messageForArkFlashChat = (MessageForArkFlashChat) it.next();
            if (l3 == null || l3.longValue() != messageForArkFlashChat.uniseq) {
                ((IArkThreadManager) QRoute.api(IArkThreadManager.class)).postToAppThread(messageForArkFlashChat.ark_app_message.appName, new Runnable(messageForArkFlashChat) { // from class: com.tencent.mobileqq.flashchat.FlashChatManager.2
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ MessageForArkFlashChat f209782d;

                    {
                        this.f209782d = messageForArkFlashChat;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlashChatManager.this, (Object) messageForArkFlashChat);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            this.f209782d.stopAnim();
                        }
                    }
                });
            }
        }
    }

    public boolean E(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) qQAppInterface)).booleanValue();
        }
        boolean z16 = false;
        if (!e.d(qQAppInterface).k(qQAppInterface)) {
            return false;
        }
        ArrayList<Integer> b16 = e.d(qQAppInterface).b(qQAppInterface);
        if (b16 != null && b16.size() > 0) {
            Iterator<Integer> it = b16.iterator();
            while (it.hasNext()) {
                if (it.next().intValue() == 1) {
                    z16 = true;
                }
            }
        }
        return z16;
    }

    public void a(MessageForArkFlashChat messageForArkFlashChat) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) messageForArkFlashChat);
            return;
        }
        if (this.G.get(Long.valueOf(messageForArkFlashChat.uniseq)) == null) {
            this.G.put(Long.valueOf(messageForArkFlashChat.uniseq), Long.valueOf(System.currentTimeMillis()));
        }
        this.F.add(messageForArkFlashChat);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b(int i3, MessageRecord messageRecord) {
        int i16;
        Integer num;
        Long l3;
        int i17;
        long j3;
        boolean z16;
        long j16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this, i3, (Object) messageRecord)).booleanValue();
        }
        SparseArray<Integer> sparseArray = P;
        SparseArray<Long> sparseArray2 = Q;
        long j17 = 0;
        if (sparseArray == null || sparseArray2 == null) {
            sparseArray = new SparseArray<>();
            sparseArray2 = new SparseArray<>();
            SharedPreferences sharedPreferences = this.f209776d.getApp().getSharedPreferences("sp_flashchat_source", 0);
            for (int i18 : this.N) {
                int i19 = sharedPreferences.getInt("use_count_" + i18, 0);
                long j18 = sharedPreferences.getLong("use_lasttime_" + i18, 0L);
                sparseArray.put(i18, Integer.valueOf(i19));
                sparseArray2.put(i18, Long.valueOf(j18));
            }
        }
        SparseArray<Integer> sparseArray3 = sparseArray;
        SparseArray<Long> sparseArray4 = sparseArray2;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            i16 = 0;
                            num = sparseArray3.get(i3);
                            l3 = sparseArray4.get(i3);
                            if (num != null) {
                                i17 = num.intValue();
                            } else {
                                i17 = 0;
                            }
                            if (l3 != null) {
                                j3 = l3.longValue();
                            } else {
                                j3 = 0;
                            }
                            if (i17 >= i16 && Math.abs(System.currentTimeMillis() - j3) > j17) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.i("FlashChat", 2, "hasLeftCount type " + i3 + " ," + z16 + ", " + i17 + ", " + i16 + ", " + j3 + ", " + j17);
                            }
                            if (z16) {
                                long currentTimeMillis = System.currentTimeMillis();
                                sparseArray3.put(i3, Integer.valueOf(i17 + 1));
                                sparseArray4.put(i3, Long.valueOf(currentTimeMillis));
                                messageRecord.saveExtInfoToExtStr("qim_source", "1");
                                ReportController.o(this.f209776d, "dc00898", "", "", "0X8008278", "0X8008278", i3, 0, "", "", "", "");
                            }
                            P = sparseArray3;
                            Q = sparseArray4;
                            return z16;
                        }
                        b bVar = this.f209778f;
                        i16 = bVar.f209799m;
                        j16 = bVar.f209801o;
                    } else {
                        b bVar2 = this.f209778f;
                        i16 = bVar2.f209798l;
                        j16 = bVar2.f209800n;
                    }
                    j17 = j16 * 1000;
                    num = sparseArray3.get(i3);
                    l3 = sparseArray4.get(i3);
                    if (num != null) {
                    }
                    if (l3 != null) {
                    }
                    if (i17 >= i16) {
                    }
                    z16 = false;
                    if (QLog.isColorLevel()) {
                    }
                    if (z16) {
                    }
                    P = sparseArray3;
                    Q = sparseArray4;
                    return z16;
                }
                i16 = this.f209778f.f209796j;
            } else {
                i16 = this.f209778f.f209797k;
            }
        } else {
            i16 = this.f209778f.f209795i;
        }
        j17 = 0;
        num = sparseArray3.get(i3);
        l3 = sparseArray4.get(i3);
        if (num != null) {
        }
        if (l3 != null) {
        }
        if (i17 >= i16) {
        }
        z16 = false;
        if (QLog.isColorLevel()) {
        }
        if (z16) {
        }
        P = sparseArray3;
        Q = sparseArray4;
        return z16;
    }

    public void d(Context context, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) context, (Object) messageRecord);
            return;
        }
        b bVar = this.f209778f;
        String str = bVar.f209789c;
        String str2 = bVar.f209792f;
        String str3 = bVar.f209793g;
        if (QLog.isColorLevel()) {
            QLog.d("FlashChat", 2, "clickQIMSource clickAppMsg url = " + str + ", actionData = " + str2 + ", actionDataA = " + str3 + messageRecord);
        }
        if (!c(context, str, str2, str3, this.f209776d)) {
            e(context, str, bVar.f209788b, messageRecord);
        }
    }

    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this)).booleanValue();
        }
        b bVar = this.f209778f;
        if (bVar != null) {
            return bVar.f209802p;
        }
        return false;
    }

    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this)).booleanValue();
        }
        b bVar = this.f209778f;
        if (bVar != null) {
            return bVar.f209803q;
        }
        return false;
    }

    public void h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, i3);
            return;
        }
        this.L.put(VasUpdateConstants.SCID_FLASH_CHAT_PREFIX + i3 + PluginUtils.CONFIG_FILE_EXTEND_NAME, String.valueOf(i3));
    }

    public String i(int i3, String str, String str2) {
        File file;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (String) iPatchRedirector.redirect((short) 28, this, Integer.valueOf(i3), str, str2);
        }
        String str3 = this.K.get(i3);
        if (str3 != null) {
            return str3;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FlashChat", 2, "getAppPathByNameFromLocal " + i3 + " path " + str3 + " version" + str2 + " name" + str);
        }
        a a16 = a.a(FileUtils.readFileContent(new File(j(VasUpdateConstants.SCID_FLASH_CHAT_PREFIX + i3 + PluginUtils.CONFIG_FILE_EXTEND_NAME))));
        if (a16 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("FlashChat", 2, "getAppPathByNameFromLocal cfg not exist ...");
            }
            return null;
        }
        String str4 = o() + k(a16.f209786b) + File.separator + str;
        if (QLog.isColorLevel()) {
            QLog.d("FlashChat", 2, "getAppPathByNameFromLocal installPath: " + str4 + "cfg info : " + a16);
        }
        File file2 = new File(str4);
        if (!file2.exists()) {
            if (QLog.isColorLevel()) {
                QLog.d("FlashChat", 2, "getAppPathByNameFromLocal appDir not exist ...");
            }
            return null;
        }
        File[] listFiles = file2.listFiles();
        if (listFiles != null) {
            int length = listFiles.length;
            for (int i16 = 0; i16 < length; i16++) {
                file = listFiles[i16];
                if (file.isFile() && file.getName().endsWith(".app") && file.getName().contains(str2)) {
                    break;
                }
            }
        }
        file = null;
        if (file == null) {
            if (QLog.isColorLevel()) {
                QLog.d("FlashChat", 2, "getAppPathByNameFromLocal appFile not exist ...");
                return null;
            }
            return null;
        }
        String absolutePath = file.getAbsolutePath();
        if (absolutePath != null) {
            this.K.put(i3, absolutePath);
        }
        if (QLog.isColorLevel()) {
            QLog.d("FlashChat", 2, "getAppPathByNameFromLocal " + i3 + " path " + absolutePath + " version" + str2 + " name" + str);
        }
        return absolutePath;
    }

    public String j(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (String) iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
        return o() + str;
    }

    public ArrayList<FlashChatItem> l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (ArrayList) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        if (QLog.isColorLevel()) {
            QLog.d("FlashChat", 2, "getItemList");
        }
        ArrayList<FlashChatItem> arrayList = this.J;
        if (arrayList == null) {
            ArrayList<FlashChatItem> arrayList2 = new ArrayList<>();
            arrayList2.add(FlashChatItem.sDefaultItem);
            return arrayList2;
        }
        return arrayList;
    }

    public String n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (String) iPatchRedirector.redirect((short) 36, (Object) this);
        }
        b bVar = this.f209778f;
        if (bVar != null) {
            return bVar.f209804r;
        }
        return "";
    }

    public String o() {
        boolean z16;
        String absolutePath;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.f209779h == null) {
            BaseApplication context = BaseApplication.getContext();
            try {
                z16 = "mounted".equals(Environment.getExternalStorageState());
            } catch (Exception e16) {
                e16.printStackTrace();
                z16 = false;
            }
            StringBuilder sb5 = new StringBuilder();
            if (z16) {
                absolutePath = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH);
            } else {
                absolutePath = context.getFilesDir().getAbsolutePath();
            }
            sb5.append(absolutePath);
            String str = File.separator;
            sb5.append(str);
            sb5.append("flashchat");
            sb5.append(str);
            this.f209779h = sb5.toString();
            new File(this.f209779h).mkdirs();
        }
        return this.f209779h;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
            return;
        }
        this.D = false;
        this.C = false;
        SharedPreferences.Editor edit = this.f209776d.getApp().getSharedPreferences("sp_flashchat_source", 0).edit();
        SparseArray<Integer> sparseArray = P;
        SparseArray<Long> sparseArray2 = Q;
        if (sparseArray != null) {
            for (int i3 : this.N) {
                Integer num = sparseArray.get(i3);
                Long l3 = sparseArray2.get(i3);
                if (num != null) {
                    edit.putInt("use_count_" + i3, num.intValue());
                }
                if (l3 != null) {
                    edit.putLong("use_lasttime_" + i3, l3.longValue());
                }
            }
        }
        edit.commit();
    }

    public String p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        String str = this.f209781m.get(this.f209776d.getCurrentAccountUin());
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x005f, code lost:
    
        if (x(r5.f209776d, r2) != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0062, code lost:
    
        C("");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArkFlashChatMessage q(String str, int i3, int i16) {
        FlashChatItem flashChatItem;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ArkFlashChatMessage) iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        if (!E(this.f209776d) || str == null || TextUtils.isEmpty(str.trim())) {
            return null;
        }
        try {
            ArrayList<FlashChatItem> arrayList = this.J;
            if (arrayList != null) {
                Iterator<FlashChatItem> it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    flashChatItem = it.next();
                    if (flashChatItem != null && flashChatItem.f209775id == i16) {
                        break;
                    }
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        flashChatItem = null;
        if (flashChatItem == null) {
            return null;
        }
        ArkFlashChatMessage arkFlashChatMessage = new ArkFlashChatMessage();
        arkFlashChatMessage.appMinVersion = flashChatItem.ver;
        arkFlashChatMessage.appName = flashChatItem.appName;
        arkFlashChatMessage.appView = flashChatItem.mainView;
        arkFlashChatMessage.appDesc = flashChatItem.name;
        arkFlashChatMessage.appResId = flashChatItem.f209775id;
        arkFlashChatMessage.promptText = str;
        arkFlashChatMessage.config = DownloadInfo.spKey_Config;
        if (QLog.isColorLevel()) {
            QLog.i("FlashChat", 1, "sendMessage");
        }
        return arkFlashChatMessage;
    }

    public boolean s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this)).booleanValue();
        }
        if (this.f209778f != null) {
            return !TextUtils.isEmpty(r0.f209793g);
        }
        return false;
    }

    public boolean t(MessageForArkFlashChat messageForArkFlashChat) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, (Object) messageForArkFlashChat)).booleanValue();
        }
        Iterator<MessageForArkFlashChat> it = this.F.iterator();
        while (it.hasNext()) {
            if (it.next().uniseq == messageForArkFlashChat.uniseq) {
                return true;
            }
        }
        return false;
    }

    public boolean u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        w();
        if (QLog.isColorLevel()) {
            QLog.d("FlashChat", 2, "isSwitchUser g " + this.f209778f.f209787a + " u " + this.f209777e);
        }
        return this.f209777e;
    }

    public void v(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("FlashChat", 2, "loadConfig l :" + str);
        }
        try {
            this.f209778f = (b) as.e(str, b.class);
        } catch (QStorageInstantiateException e16) {
            QLog.i("FlashChat", 1, "loadConfig l :" + str, e16);
        }
        this.f209776d.notifyObservers(com.tencent.mobileqq.flashchat.b.class, 969, true, null);
        this.f209776d.notifyObservers(com.tencent.mobileqq.flashchat.b.class, 970, true, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void w() {
        String str;
        ArrayList<FlashChatItem> arrayList;
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (this.D) {
            return;
        }
        this.D = true;
        p pVar = (p) am.s().x(168);
        if (pVar == null) {
            str = "";
        } else {
            str = pVar.f202698a;
        }
        v(str);
        try {
            arrayList = (ArrayList) this.f209780i.f("FlashItems", ArrayList.class, 0);
        } catch (QStorageInstantiateException e16) {
            QLog.i("FlashChat", 1, "loadFromCacheOnce", e16);
            arrayList = null;
            z(arrayList, false, null);
            if (QLog.isColorLevel()) {
            }
        } catch (QStorageSafeDeleteException e17) {
            QLog.i("FlashChat", 1, "loadFromCacheOnce", e17);
            arrayList = null;
            z(arrayList, false, null);
            if (QLog.isColorLevel()) {
            }
        }
        z(arrayList, false, null);
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("loadFromCacheOnce ");
            if (arrayList != null) {
                obj = Integer.valueOf(arrayList.size());
            } else {
                obj = "null";
            }
            sb5.append(obj);
            QLog.i("FlashChat", 2, sb5.toString());
        }
    }

    public void y(String str, int i3) {
        AtomicBoolean atomicBoolean;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) str, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FlashChat", 2, "parseJson isMainThread scid " + str + " errCode " + i3);
        }
        if (str != null) {
            int i16 = -1;
            if (str.endsWith(PluginUtils.CONFIG_FILE_EXTEND_NAME)) {
                String str3 = this.L.get(str);
                if (i3 != 0) {
                    try {
                        i16 = Integer.valueOf(str3).intValue();
                    } catch (Exception e16) {
                        QLog.e("FlashChat", 2, "onCompleteDownload" + i3, e16);
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("resourceId", i16);
                    this.f209776d.notifyObservers(com.tencent.mobileqq.flashchat.b.class, 968, false, bundle);
                    return;
                }
                a a16 = a.a(FileUtils.readFileContent(new File(j(str))));
                if (a16 != null && (str2 = a16.f209786b) != null && str3 != null) {
                    this.H.put(str2, str3);
                    return;
                }
                return;
            }
            if (str.endsWith(".zip")) {
                String str4 = this.H.get(str);
                if (i3 != 0) {
                    try {
                        i16 = Integer.valueOf(str4).intValue();
                    } catch (Exception e17) {
                        QLog.e("FlashChat", 2, "onCompleteDownload" + i3, e17);
                    }
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt("resourceId", i16);
                    this.f209776d.notifyObservers(com.tencent.mobileqq.flashchat.b.class, 968, false, bundle2);
                    return;
                }
                String j3 = j(str);
                String str5 = o() + k(str) + File.separator;
                this.I.set(true);
                synchronized (str5.intern()) {
                    File file = new File(str5);
                    try {
                        try {
                            F(j3, str5);
                            int intValue = Integer.valueOf(str4).intValue();
                            Bundle bundle3 = new Bundle();
                            bundle3.putInt("resourceId", intValue);
                            this.f209776d.notifyObservers(com.tencent.mobileqq.flashchat.b.class, 968, true, bundle3);
                            new File(j3).delete();
                            atomicBoolean = this.I;
                        } catch (Throwable th5) {
                            this.I.set(false);
                            throw th5;
                        }
                    } catch (Exception e18) {
                        e18.printStackTrace();
                        file.delete();
                        atomicBoolean = this.I;
                    }
                    atomicBoolean.set(false);
                }
            }
        }
    }

    public void z(ArrayList<FlashChatItem> arrayList, boolean z16, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, arrayList, Boolean.valueOf(z16), bArr);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("FlashChat", 2, "onGetFlashItems begin " + z16);
        }
        if (arrayList != null) {
            if (z16) {
                this.f209780i.h("FlashItems", arrayList);
            }
            arrayList.add(0, FlashChatItem.sDefaultItem);
            this.J = arrayList;
            Iterator<FlashChatItem> it = arrayList.iterator();
            while (it.hasNext()) {
                FlashChatItem next = it.next();
                if (QLog.isColorLevel()) {
                    QLog.i("FlashChat", 2, "onGetFlashItems item = " + next);
                }
                int i3 = next.f209775id;
                if (i3 != -100001 && i3 != -100000) {
                    i(i3, next.appName, next.ver);
                }
            }
        }
    }
}
