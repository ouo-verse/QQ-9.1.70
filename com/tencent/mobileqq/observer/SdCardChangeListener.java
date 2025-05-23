package com.tencent.mobileqq.observer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes9.dex */
public class SdCardChangeListener extends BroadcastReceiver {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private int f254474a;

    /* renamed from: b, reason: collision with root package name */
    private Handler f254475b;

    /* renamed from: c, reason: collision with root package name */
    private String f254476c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v7, types: [android.os.Handler] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v4 */
    public synchronized int a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, i3)).intValue();
        }
        ?? r16 = -1;
        ?? r17 = -1;
        if (TextUtils.isEmpty(this.f254476c)) {
            return -1;
        }
        ?? r06 = -2;
        int i16 = -2;
        try {
            try {
                File file = new File(this.f254476c + "/" + System.currentTimeMillis() + ".tst");
                file.createNewFile();
                file.delete();
                this.f254474a = 0;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            Message obtain = Message.obtain();
            obtain.what = 28929;
            Bundle bundle = new Bundle();
            bundle.putInt("result", this.f254474a);
            r16 = "sdcard_path";
            bundle.putString("sdcard_path", this.f254476c);
            obtain.setData(bundle);
            r06 = this.f254475b;
            r06.sendMessage(obtain);
            i3 = this.f254474a;
            return i3;
        } finally {
            if (i3 == r06) {
                this.f254474a = i3;
            } else {
                this.f254474a = r16;
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) intent);
            return;
        }
        String action = intent.getAction();
        if (action.equals("android.intent.action.MEDIA_UNMOUNTED")) {
            if (QLog.isColorLevel()) {
                QLog.d("SdCardListener", 2, "SDCARD ACTION_MEDIA_UNMOUNTED");
            }
            this.f254474a = -2;
        } else if (action.equals("android.intent.action.MEDIA_MOUNTED")) {
            this.f254474a = 0;
            if (QLog.isColorLevel()) {
                QLog.d("SdCardListener", 2, "SDCARD ACTION_MEDIA_MOUNTED");
            }
        } else if (action.equals("android.intent.action.MEDIA_REMOVED")) {
            this.f254474a = -2;
            if (QLog.isColorLevel()) {
                QLog.d("SdCardListener", 2, "SDCARD ACTION_MEDIA_REMOVED");
            }
        } else if (action.equals("android.intent.action.MEDIA_EJECT")) {
            this.f254474a = -2;
            if (QLog.isColorLevel()) {
                QLog.d("SdCardListener", 2, "SDCARD ACTION_MEDIA_EJECT");
            }
        }
        this.f254474a = a(this.f254474a);
    }
}
