package com.qq.e.tg.download.configure;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.qq.e.tg.download.interfaces.ITGDC;
import com.qq.e.tg.download.interfaces.ITangramDownloader;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TangramDownloaderConfigure {
    public static final String TAG = "TangramDownloaderConfigure_stub  ";

    /* renamed from: a, reason: collision with root package name */
    private volatile ITGDC f40500a;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f40501b;

    /* renamed from: c, reason: collision with root package name */
    private RegisterDownloaderAfterInitSdkSucCb f40502c;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static final class Holder {

        /* renamed from: a, reason: collision with root package name */
        private static TangramDownloaderConfigure f40506a = new TangramDownloaderConfigure(0);

        Holder() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    interface RegisterDownloaderAfterInitSdkSucCb {
        void registerDownloader(ITGDC itgdc);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class RegisterRunnable implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private RegisterDownloaderAfterInitSdkSucCb f40507a;

        /* renamed from: b, reason: collision with root package name */
        private Context f40508b;

        /* renamed from: c, reason: collision with root package name */
        private String f40509c;

        public RegisterRunnable(Context context, String str, RegisterDownloaderAfterInitSdkSucCb registerDownloaderAfterInitSdkSucCb) {
            this.f40507a = registerDownloaderAfterInitSdkSucCb;
            this.f40508b = context;
            this.f40509c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f40508b != null && !TextUtils.isEmpty(this.f40509c)) {
                if (GDTADManager.getInstance().initWith(this.f40508b.getApplicationContext(), this.f40509c)) {
                    try {
                        POFactory pOFactory = GDTADManager.getInstance().getPM().getPOFactory();
                        if (pOFactory != null) {
                            TangramDownloaderConfigure.this.f40500a = pOFactory.getTangramDownloaderConfigure();
                        }
                        RegisterDownloaderAfterInitSdkSucCb registerDownloaderAfterInitSdkSucCb = this.f40507a;
                        if (registerDownloaderAfterInitSdkSucCb != null) {
                            registerDownloaderAfterInitSdkSucCb.registerDownloader(TangramDownloaderConfigure.this.f40500a);
                            return;
                        }
                        return;
                    } catch (Exception e16) {
                        GDTLogger.e("TangramDownloaderConfigure_stub  Fail to init TangramDownloaderConfigure plugin", e16);
                        e16.printStackTrace();
                        return;
                    }
                }
                return;
            }
            GDTLogger.e("TangramDownloaderConfigure_stub  register downloader invalid params");
        }
    }

    TangramDownloaderConfigure() {
        this.f40501b = false;
    }

    public static TangramDownloaderConfigure getInstance() {
        return Holder.f40506a;
    }

    public void configure(JSONObject jSONObject) {
        if (this.f40500a != null) {
            this.f40500a.configure(jSONObject);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0045 A[Catch: all -> 0x0048, TRY_LEAVE, TryCatch #0 {all -> 0x0048, blocks: (B:2:0x0000, B:6:0x0011, B:7:0x0035, B:9:0x0039, B:12:0x0045, B:14:0x0023), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0039 A[Catch: all -> 0x0048, TryCatch #0 {all -> 0x0048, blocks: (B:2:0x0000, B:6:0x0011, B:7:0x0035, B:9:0x0039, B:12:0x0045, B:14:0x0023), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void registerMediaCustomDownloader(Context context, final String str, final ITangramDownloader iTangramDownloader) {
        try {
            this.f40502c = new RegisterDownloaderAfterInitSdkSucCb() { // from class: com.qq.e.tg.download.configure.TangramDownloaderConfigure.1
                @Override // com.qq.e.tg.download.configure.TangramDownloaderConfigure.RegisterDownloaderAfterInitSdkSucCb
                public void registerDownloader(ITGDC itgdc) {
                    if (itgdc != null && TangramDownloaderConfigure.this.f40501b) {
                        TangramDownloaderConfigure.a(TangramDownloaderConfigure.this, false);
                        itgdc.registerCustomDownloader(str, iTangramDownloader);
                    }
                }
            };
            if (!StringUtil.isEmpty(str) && context != null) {
                context.getApplicationContext();
                GdtSDKThreadManager.getSubThreadHandler().post(new RegisterRunnable(context, str, this.f40502c));
                if (this.f40500a == null) {
                    GDTLogger.d("TangramDownloaderConfigure_stub   registerMediaCustomDownloader success");
                    this.f40500a.registerCustomDownloader(str, iTangramDownloader);
                    return;
                } else {
                    this.f40501b = true;
                    return;
                }
            }
            GDTLogger.e(String.format("TangramDownloaderConfigure_stub  TangramDownloaderConfigure initWith params error, appid=%s,posId=%s,context=%s", str, context));
            if (this.f40500a == null) {
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    public void unRegisterMediaCustomDownloader(String str) {
        if (this.f40500a != null) {
            this.f40500a.unRegisterCustomDownloader(str);
            GDTLogger.d("TangramDownloaderConfigure_stub   unRegisterMediaCustomDownloader success");
        }
        this.f40501b = false;
    }

    /* synthetic */ TangramDownloaderConfigure(byte b16) {
        this();
    }

    static /* synthetic */ boolean a(TangramDownloaderConfigure tangramDownloaderConfigure, boolean z16) {
        tangramDownloaderConfigure.f40501b = false;
        return false;
    }
}
