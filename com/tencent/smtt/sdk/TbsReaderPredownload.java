package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.tencent.smtt.sdk.TbsReaderView;
import com.tencent.xweb.FileReaderHelper;
import java.util.LinkedList;

/* loaded from: classes23.dex */
public class TbsReaderPredownload {
    public static final int READER_SO_SUCCESS = 2;
    public static final int READER_WAIT_IN_QUEUE = 3;

    /* renamed from: b, reason: collision with root package name */
    static final String[] f369156b = {FileReaderHelper.DOCX_EXT, FileReaderHelper.PPTX_EXT, FileReaderHelper.XLSX_EXT, FileReaderHelper.PDF_EXT, "epub", FileReaderHelper.TXT_EXT};

    /* renamed from: i, reason: collision with root package name */
    ReaderPreDownloadCallback f369164i;

    /* renamed from: a, reason: collision with root package name */
    Handler f369157a = null;

    /* renamed from: c, reason: collision with root package name */
    LinkedList<String> f369158c = new LinkedList<>();

    /* renamed from: d, reason: collision with root package name */
    boolean f369159d = false;

    /* renamed from: e, reason: collision with root package name */
    f f369160e = null;

    /* renamed from: f, reason: collision with root package name */
    TbsReaderView.ReaderCallback f369161f = null;

    /* renamed from: g, reason: collision with root package name */
    Object f369162g = null;

    /* renamed from: h, reason: collision with root package name */
    Context f369163h = null;

    /* renamed from: j, reason: collision with root package name */
    String f369165j = "";

    /* loaded from: classes23.dex */
    public interface ReaderPreDownloadCallback {
        public static final int NOTIFY_PLUGIN_FAILED = -1;
        public static final int NOTIFY_PLUGIN_SUCCESS = 0;

        void onEvent(String str, int i3, boolean z16);
    }

    public TbsReaderPredownload(ReaderPreDownloadCallback readerPreDownloadCallback) {
        this.f369164i = readerPreDownloadCallback;
        for (String str : f369156b) {
            this.f369158c.add(str);
        }
        a();
    }

    private void b() {
        b(3);
    }

    boolean a(String str) {
        if (this.f369162g == null || this.f369160e == null || !f.a(str)) {
            return false;
        }
        return this.f369160e.a(this.f369162g, this.f369163h, str, true);
    }

    boolean c(int i3) {
        return this.f369157a.hasMessages(i3);
    }

    public boolean init(Context context) {
        if (context == null) {
            return false;
        }
        this.f369163h = context.getApplicationContext();
        boolean a16 = TbsReaderView.a(context.getApplicationContext());
        TbsReaderView.ReaderCallback readerCallback = new TbsReaderView.ReaderCallback() { // from class: com.tencent.smtt.sdk.TbsReaderPredownload.1
            @Override // com.tencent.smtt.sdk.TbsReaderView.ReaderCallback
            public void onCallBackAction(Integer num, Object obj, Object obj2) {
                int intValue;
                if (num.intValue() != 5012 || 5014 == (intValue = ((Integer) obj).intValue())) {
                    return;
                }
                if (5013 == intValue) {
                    TbsReaderPredownload.this.a(0);
                } else if (intValue == 0) {
                    TbsReaderPredownload.this.a(0);
                } else {
                    TbsReaderPredownload.this.a(-1);
                }
                TbsReaderPredownload tbsReaderPredownload = TbsReaderPredownload.this;
                tbsReaderPredownload.f369165j = "";
                tbsReaderPredownload.a(3, 100);
            }
        };
        this.f369161f = readerCallback;
        try {
            if (this.f369160e == null) {
                this.f369160e = new f(readerCallback);
            }
            if (this.f369162g == null) {
                this.f369162g = this.f369160e.a();
            }
            Object obj = this.f369162g;
            if (obj != null) {
                return this.f369160e.a(obj, context.getApplicationContext());
            }
            return a16;
        } catch (NullPointerException unused) {
            Log.e("TbsReaderPredownload", "Unexpect null object!");
            return false;
        }
    }

    public void pause() {
        this.f369159d = true;
    }

    public void shutdown() {
        this.f369164i = null;
        this.f369159d = false;
        this.f369158c.clear();
        b();
        f fVar = this.f369160e;
        if (fVar != null) {
            fVar.a(this.f369162g);
            this.f369162g = null;
        }
        this.f369163h = null;
    }

    public void start(String str) {
        this.f369159d = false;
        b(3);
        this.f369158c.add(str);
        a(3, 100);
    }

    public void startAll() {
        this.f369159d = false;
        if (!(false | c(3))) {
            a(3, 100);
        }
    }

    void b(int i3) {
        this.f369157a.removeMessages(i3);
    }

    void a(int i3) {
        if (this.f369164i != null) {
            this.f369164i.onEvent(this.f369165j, i3, this.f369158c.isEmpty());
        }
    }

    void a() {
        this.f369157a = new Handler(Looper.getMainLooper()) { // from class: com.tencent.smtt.sdk.TbsReaderPredownload.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 3 && !TbsReaderPredownload.this.f369158c.isEmpty()) {
                    TbsReaderPredownload tbsReaderPredownload = TbsReaderPredownload.this;
                    if (!tbsReaderPredownload.f369159d) {
                        String removeFirst = tbsReaderPredownload.f369158c.removeFirst();
                        TbsReaderPredownload tbsReaderPredownload2 = TbsReaderPredownload.this;
                        tbsReaderPredownload2.f369165j = removeFirst;
                        if (!tbsReaderPredownload2.a(removeFirst)) {
                            TbsReaderPredownload.this.a(-1);
                        }
                    }
                }
            }
        };
    }

    void a(int i3, int i16) {
        this.f369157a.sendMessageDelayed(this.f369157a.obtainMessage(i3), i16);
    }
}
