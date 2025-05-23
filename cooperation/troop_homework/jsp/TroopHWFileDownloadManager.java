package cooperation.troop_homework.jsp;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.open.base.f;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantbase.common.TMAssistantDownloadContentType;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import com.tencent.tmdownloader.TMAssistantDownloadSettingClient;
import java.io.File;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes28.dex */
public class TroopHWFileDownloadManager {

    /* renamed from: g, reason: collision with root package name */
    public static final String f390933g = "cooperation.troop_homework.jsp.TroopHWFileDownloadManager";

    /* renamed from: a, reason: collision with root package name */
    private TMAssistantDownloadClient f390934a;

    /* renamed from: b, reason: collision with root package name */
    private TMAssistantDownloadSettingClient f390935b;

    /* renamed from: e, reason: collision with root package name */
    private String f390938e;

    /* renamed from: c, reason: collision with root package name */
    private HashMap<String, String> f390936c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private HashMap<String, b> f390937d = new HashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private ITMAssistantDownloadClientListener f390939f = new a();

    /* compiled from: P */
    /* renamed from: cooperation.troop_homework.jsp.TroopHWFileDownloadManager$3, reason: invalid class name */
    /* loaded from: classes28.dex */
    class AnonymousClass3 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f390943d;
        final /* synthetic */ TroopHWFileDownloadManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.f390934a.cancelDownloadTask(this.f390943d);
        }
    }

    /* compiled from: P */
    /* renamed from: cooperation.troop_homework.jsp.TroopHWFileDownloadManager$4, reason: invalid class name */
    /* loaded from: classes28.dex */
    class AnonymousClass4 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f390944d;
        final /* synthetic */ TroopHWFileDownloadManager this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.f390935b.setDownloadSDKWifiOnly(this.f390944d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface b {
        void c(String str, int i3, int i16, String str2, String str3);

        void onProgress(String str, long j3, long j16);
    }

    public TroopHWFileDownloadManager(Context context) {
        TMAssistantDownloadManager tMAssistantDownloadManager = TMAssistantDownloadManager.getInstance(context.getApplicationContext());
        String str = f390933g + Process.myPid() + "_" + System.currentTimeMillis();
        this.f390938e = str;
        this.f390934a = tMAssistantDownloadManager.getDownloadSDKClient(str);
        this.f390935b = TMAssistantDownloadManager.getInstance(context).getDownloadSDKSettingClient();
        this.f390934a.registerDownloadTaskListener(this.f390939f);
    }

    public void e(Context context) {
        this.f390934a.unRegisterDownloadTaskListener(this.f390939f);
        TMAssistantDownloadManager.getInstance(context.getApplicationContext()).releaseDownloadSDKClient(this.f390938e);
    }

    public void f(final String str) {
        ThreadManagerV2.post(new Runnable() { // from class: cooperation.troop_homework.jsp.TroopHWFileDownloadManager.2
            @Override // java.lang.Runnable
            public void run() {
                TroopHWFileDownloadManager.this.f390934a.pauseDownloadTask(str);
            }
        }, 5, null, true);
    }

    public void g(final String str, String str2, b bVar) {
        final String substring = str2.substring(str2.lastIndexOf("/") + 1);
        File file = new File(str2);
        if (file.exists()) {
            if (bVar != null) {
                bVar.onProgress(str, file.length(), file.length());
                bVar.c(str, 3, 0, null, str2);
                return;
            }
            return;
        }
        if (!this.f390937d.containsKey(str)) {
            this.f390937d.put(str, bVar);
            this.f390936c.put(str, str2);
        }
        ThreadManagerV2.post(new Runnable() { // from class: cooperation.troop_homework.jsp.TroopHWFileDownloadManager.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    TroopHWFileDownloadManager.this.f390934a.startDownloadTask(str, TMAssistantDownloadContentType.CONTENT_TYPE_OTHERS, substring);
                } catch (Exception e16) {
                    f.d(TroopHWFileDownloadManager.f390933g, "exception when startDownloadTask: ", e16);
                }
            }
        }, 5, null, true);
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class a implements ITMAssistantDownloadClientListener {
        a() {
        }

        @Override // com.tencent.tmdownloader.ITMAssistantDownloadClientListener
        public void onDownloadSDKTaskProgressChanged(TMAssistantDownloadClient tMAssistantDownloadClient, String str, long j3, long j16) {
            b bVar = (b) TroopHWFileDownloadManager.this.f390937d.get(str);
            if (bVar != null) {
                bVar.onProgress(str, j3, j16);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:17:0x008d  */
        @Override // com.tencent.tmdownloader.ITMAssistantDownloadClientListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onDownloadSDKTaskStateChanged(TMAssistantDownloadClient tMAssistantDownloadClient, String str, int i3, int i16, String str2) {
            String str3;
            boolean z16;
            String str4;
            int i17 = 1;
            int i18 = 2;
            String str5 = "";
            if (i3 != 4) {
                str3 = "";
            } else {
                str3 = (String) TroopHWFileDownloadManager.this.f390936c.get(str);
                try {
                    TMAssistantDownloadTaskInfo downloadTaskState = tMAssistantDownloadClient.getDownloadTaskState(str);
                    if (downloadTaskState == null) {
                        str4 = null;
                    } else {
                        str4 = downloadTaskState.mSavePath;
                    }
                    str5 = str4;
                } catch (Exception e16) {
                    QLog.e(TroopHWFileDownloadManager.f390933g, 2, e16.toString());
                }
                if (!TextUtils.isEmpty(str5)) {
                    File file = new File(str5);
                    if (file.exists()) {
                        if (file.renameTo(new File(str3))) {
                            z16 = true;
                            if (!z16) {
                                b bVar = (b) TroopHWFileDownloadManager.this.f390937d.get(str);
                                if (bVar != null) {
                                    bVar.c(str, 6, 0, "", "");
                                }
                                TroopHWFileDownloadManager.this.f390937d.remove(str);
                                TroopHWFileDownloadManager.this.f390936c.remove(str);
                                return;
                            }
                        } else {
                            QLog.e(TroopHWFileDownloadManager.f390933g, 2, "file renameTo faild frompath:" + str5 + " topath:" + str3);
                        }
                    } else {
                        QLog.e(TroopHWFileDownloadManager.f390933g, 2, "file not exist path:" + str5);
                    }
                } else {
                    QLog.e(TroopHWFileDownloadManager.f390933g, 2, "currentPath is null");
                }
                z16 = false;
                if (!z16) {
                }
            }
            b bVar2 = (b) TroopHWFileDownloadManager.this.f390937d.get(str);
            if (bVar2 != null) {
                switch (i3) {
                    case 1:
                        i18 = i17;
                        break;
                    case 2:
                        break;
                    case 3:
                        i18 = 4;
                        break;
                    case 4:
                        TroopHWFileDownloadManager.this.f390937d.remove(str);
                        TroopHWFileDownloadManager.this.f390936c.remove(str);
                        i17 = 3;
                        i18 = i17;
                        break;
                    case 5:
                        TroopHWFileDownloadManager.this.f390937d.remove(str);
                        TroopHWFileDownloadManager.this.f390936c.remove(str);
                        i17 = 6;
                        i18 = i17;
                        break;
                    case 6:
                        TroopHWFileDownloadManager.this.f390937d.remove(str);
                        TroopHWFileDownloadManager.this.f390936c.remove(str);
                        i17 = 5;
                        i18 = i17;
                        break;
                    default:
                        i18 = 0;
                        break;
                }
                bVar2.c(str, i18, i16, str2, str3);
            }
        }

        @Override // com.tencent.tmdownloader.ITMAssistantDownloadClientListener
        public void onDwonloadSDKServiceInvalid(TMAssistantDownloadClient tMAssistantDownloadClient) {
        }
    }
}
