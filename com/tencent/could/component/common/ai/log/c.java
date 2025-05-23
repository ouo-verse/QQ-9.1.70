package com.tencent.could.component.common.ai.log;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.tencent.could.component.common.ai.log.e;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.raft.codegenmeta.utils.RLog;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c extends Handler {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public SimpleDateFormat f99958a;

    /* renamed from: b, reason: collision with root package name */
    public Date f99959b;

    /* renamed from: c, reason: collision with root package name */
    public AiLogConfig f99960c;

    /* renamed from: d, reason: collision with root package name */
    public f f99961d;

    /* renamed from: e, reason: collision with root package name */
    public WeakReference<Context> f99962e;

    public c(Looper looper, AiLogConfig aiLogConfig, Context context) {
        super(looper);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, looper, aiLogConfig, context);
        } else {
            this.f99960c = aiLogConfig;
            this.f99962e = new WeakReference<>(context);
        }
    }

    public final String a(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) dVar);
        }
        long j3 = dVar.f99964b;
        if (this.f99958a == null) {
            this.f99958a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        }
        if (this.f99959b == null) {
            this.f99959b = new Date();
        }
        this.f99959b.setTime(j3);
        StringBuilder sb5 = new StringBuilder(this.f99958a.format(this.f99959b));
        sb5.append(" ");
        sb5.append(dVar.f99967e);
        sb5.append("/");
        sb5.append(dVar.f99968f);
        int i3 = dVar.f99963a;
        StringBuilder sb6 = new StringBuilder(" ");
        switch (i3) {
            case 2:
                sb6.append("VERBOSE");
                break;
            case 3:
                sb6.append("DEBUG");
                break;
            case 4:
                sb6.append("INFO");
                break;
            case 5:
                sb6.append("WARN");
                break;
            case 6:
                sb6.append(RLog.ERROR);
                break;
            case 7:
                sb6.append("ASSERT");
                break;
            default:
                sb6.append("null");
                break;
        }
        sb5.append(sb6.toString());
        sb5.append("/");
        sb5.append(dVar.f99965c);
        sb5.append(MsgSummary.STR_COLON);
        sb5.append(dVar.f99966d);
        return sb5.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005f  */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.tencent.could.component.common.ai.log.e] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v7, types: [com.tencent.could.component.common.ai.log.d] */
    /* JADX WARN: Type inference failed for: r6v9 */
    @Override // android.os.Handler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleMessage(Message message) {
        Exception e16;
        d dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
            return;
        }
        if (message == null) {
            Log.e("FileWriteHandler", "msg is null!");
            return;
        }
        if (message.what == 1) {
            ?? r65 = message.obj;
            if (r65 instanceof d) {
                d dVar2 = null;
                try {
                    try {
                        dVar = (d) r65;
                    } catch (Exception e17) {
                        e16 = e17;
                        dVar = null;
                    } catch (Throwable th5) {
                        th = th5;
                        if (dVar2 != null) {
                        }
                        throw th;
                    }
                    try {
                        a(a(dVar));
                        r65 = dVar;
                    } catch (Exception e18) {
                        e16 = e18;
                        Log.e("FileWriteHandler", "deal with logInfo string error! e: " + e16.getMessage());
                        r65 = dVar;
                        if (dVar == null) {
                            return;
                        }
                        e.a.f99970a.a(r65);
                    }
                    e.a.f99970a.a(r65);
                } catch (Throwable th6) {
                    th = th6;
                    dVar2 = r65;
                    if (dVar2 != null) {
                        e.a.f99970a.a(dVar2);
                    }
                    throw th;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0144  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(String str) {
        File file;
        boolean z16;
        File file2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        WeakReference<Context> weakReference = this.f99962e;
        Context context = weakReference == null ? null : weakReference.get();
        if (context == null) {
            Log.e("FileWriteHandler", "current context is null!");
            return;
        }
        if (this.f99961d == null) {
            this.f99961d = new f(context);
        }
        f fVar = this.f99961d;
        if (fVar == null) {
            Log.e("FileWriteHandler", "writer is null!");
            return;
        }
        if (!((fVar.f99972b == null || (file2 = fVar.f99971a) == null || !file2.exists()) ? false : true)) {
            f fVar2 = this.f99961d;
            boolean isUseExternalFile = this.f99960c.isUseExternalFile();
            String dirLog = this.f99960c.getDirLog();
            String logName = this.f99960c.getLogName();
            WeakReference<Context> weakReference2 = fVar2.f99973c;
            if (weakReference2 == null) {
                Log.e("LogWriter", "contextReference is null");
            } else if (isUseExternalFile && !com.tencent.could.component.common.ai.utils.a.a(weakReference2.get())) {
                Log.e("LogWriter", "no write file permission! ");
            } else {
                File file3 = new File(dirLog, logName + "-" + new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT).format(new Date(System.currentTimeMillis())) + ".ailog");
                fVar2.f99971a = file3;
                if (!file3.exists()) {
                    try {
                        File file4 = new File(dirLog);
                        if (!file4.exists() && !file4.mkdirs()) {
                            Log.e("LogWriter", "create log dir error! dir: " + dirLog);
                        }
                        fVar2.f99971a.createNewFile();
                    } catch (Exception e16) {
                        Log.e("LogWriter", "create log file error! e: " + e16.getMessage());
                        fVar2.a();
                    }
                }
                try {
                    fVar2.f99972b = new BufferedWriter(new FileWriter(fVar2.f99971a, true));
                    z16 = true;
                } catch (Exception e17) {
                    Log.e("LogWriter", "create writer error! e: " + e17.getMessage());
                    fVar2.a();
                }
                if (!z16) {
                    Log.e("FileWriteHandler", "writer open is fail! can not write : " + str);
                    return;
                }
            }
            z16 = false;
            if (!z16) {
            }
        }
        f fVar3 = this.f99961d;
        if (fVar3 != null) {
            if ((fVar3.f99972b == null || (file = fVar3.f99971a) == null || !file.exists()) ? false : true) {
                f fVar4 = this.f99961d;
                if (fVar4.f99972b == null) {
                    Log.e("LogWriter", "writer is null!");
                    return;
                }
                try {
                    fVar4.f99972b.write(str);
                    fVar4.f99972b.newLine();
                    fVar4.f99972b.flush();
                } catch (Exception e18) {
                    Log.e("LogWriter", "writer not work e: " + e18.getMessage());
                }
            }
        }
    }
}
