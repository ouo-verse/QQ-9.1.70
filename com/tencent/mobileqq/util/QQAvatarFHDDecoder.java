package com.tencent.mobileqq.util;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.util.AvatarDownloadUtil;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.emoticon.DownloadInfo;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QQAvatarFHDDecoder implements Handler.Callback, HttpDownloadUtil.b {
    private volatile WeakReference<a> C;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<QQAppInterface> f306433d;

    /* renamed from: e, reason: collision with root package name */
    private MqqHandler f306434e;

    /* renamed from: f, reason: collision with root package name */
    private volatile String f306435f;

    /* renamed from: m, reason: collision with root package name */
    private FriendListHandler f306438m;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f306436h = false;

    /* renamed from: i, reason: collision with root package name */
    private volatile boolean f306437i = false;
    private com.tencent.mobileqq.avatar.observer.a D = new com.tencent.mobileqq.avatar.observer.a() { // from class: com.tencent.mobileqq.util.QQAvatarFHDDecoder.1
        @Override // com.tencent.mobileqq.avatar.observer.a
        protected void onGetHeadInfo(boolean z16, final Setting setting) {
            String str;
            String str2;
            if (QLog.isDevelopLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onGetHeadInfo ");
                sb5.append(z16);
                sb5.append(" ");
                if (setting != null) {
                    str2 = setting.uin;
                } else {
                    str2 = "";
                }
                sb5.append(str2);
                QLog.i("QQAvatarFHDDecoder", 2, sb5.toString());
            }
            if (setting != null && (str = setting.uin) != null && str.equals(QQAvatarFHDDecoder.this.f306435f)) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.util.QQAvatarFHDDecoder.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (QQAvatarFHDDecoder.this.f306437i) {
                            return;
                        }
                        QQAvatarFHDDecoder.this.h(setting);
                    }
                }, 128, null, true);
            }
        }

        @Override // com.tencent.mobileqq.avatar.observer.a
        public void onGetHeadInfoEmpty(boolean z16, int i3, List<String> list) {
            String str;
            if (QLog.isDevelopLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onGetHeadInfoEmpty ");
                sb5.append(z16);
                sb5.append(" ");
                sb5.append(i3);
                sb5.append(" ");
                if (list != null) {
                    str = list.toString();
                } else {
                    str = "";
                }
                sb5.append(str);
                QLog.i("QQAvatarFHDDecoder", 2, sb5.toString());
            }
            if (list != null) {
                for (final String str2 : list) {
                    if (str2 != null && str2.equals(QQAvatarFHDDecoder.this.f306435f)) {
                        if (z16) {
                            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.util.QQAvatarFHDDecoder.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (QQAvatarFHDDecoder.this.f306437i) {
                                        return;
                                    }
                                    QQAvatarFHDDecoder.this.h(QQAvatarFHDDecoder.this.i().getQQHeadSettingFromDB(str2));
                                }
                            }, 128, null, true);
                            return;
                        } else {
                            QQAvatarFHDDecoder.this.f306434e.obtainMessage(1).sendToTarget();
                            return;
                        }
                    }
                }
            }
        }
    };

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
        void a(String str, boolean z16, Drawable drawable);
    }

    public QQAvatarFHDDecoder(QQAppInterface qQAppInterface) {
        this.f306433d = new WeakReference<>(qQAppInterface);
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public QQAppInterface i() {
        if (this.f306433d.get() != null) {
            return this.f306433d.get();
        }
        return (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
    }

    private void k(String str) {
        BitmapDrawable bitmapDrawable;
        try {
            bitmapDrawable = new BitmapDrawable(i().getApp().getResources(), BitmapFactory.decodeFile(str));
        } catch (Throwable th5) {
            if (QLog.isDevelopLevel()) {
                QLog.i("QQAvatarFHDDecoder", 2, "downloadFHDAvatar getDrawable " + th5.toString());
            }
            bitmapDrawable = null;
        }
        Message obtainMessage = this.f306434e.obtainMessage(1);
        obtainMessage.obj = bitmapDrawable;
        obtainMessage.sendToTarget();
    }

    private void l(String str) {
        if (QLog.isDevelopLevel()) {
            QLog.i("QQAvatarFHDDecoder", 2, "getLocalThumbFile ");
        }
        String customFaceFilePath = i().getCustomFaceFilePath(1, str, 0);
        if (new File(customFaceFilePath).exists()) {
            if (QLog.isDevelopLevel()) {
                QLog.i("QQAvatarFHDDecoder", 2, "getLocalThumbFile exist");
            }
            k(customFaceFilePath);
        }
    }

    private void m() {
        i().addObserver(this.D);
        this.f306438m = (FriendListHandler) i().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        this.f306434e = new com.tencent.mobileqq.utils.ad(Looper.getMainLooper(), this);
    }

    @Override // com.tencent.mobileqq.utils.HttpDownloadUtil.b
    public void a(String str, int i3) {
        if (QLog.isDevelopLevel()) {
            QLog.i("QQAvatarFHDDecoder", 2, "onHttpStart " + str + " " + i3);
        }
    }

    @Override // com.tencent.mobileqq.utils.HttpDownloadUtil.b
    public void c(String str, int i3) {
        if (QLog.isDevelopLevel()) {
            QLog.i("QQAvatarFHDDecoder", 2, "onHttpEnd " + str + " " + i3);
        }
    }

    protected void h(Setting setting) {
        String str;
        if (setting != null && !TextUtils.isEmpty(setting.uin) && !TextUtils.isEmpty(setting.url)) {
            String fHDAvatarPath = FaceUtil.getFHDAvatarPath(setting.uin);
            if (com.tencent.mobileqq.filemanager.util.q.p(fHDAvatarPath)) {
                if (QLog.isDevelopLevel()) {
                    QLog.i("QQAvatarFHDDecoder", 2, "downloadFHDAvatar already exist " + fHDAvatarPath);
                }
                k(fHDAvatarPath);
                return;
            }
            String str2 = AvatarDownloadUtil.get1080QQHeadDownLoadUrl(setting.url, setting.bFaceFlags);
            File file = new File(fHDAvatarPath);
            File file2 = new File(file.getPath() + System.currentTimeMillis());
            boolean z16 = false;
            if (HttpDownloadUtil.downloadData(i(), new DownloadInfo(MsfSdkUtils.insertMtype("friendlist", str2), file2, 0), this) == 0) {
                z16 = true;
            }
            if (z16) {
                if (file2.exists()) {
                    z16 = file2.renameTo(file);
                }
                if (QLog.isDevelopLevel()) {
                    QLog.i("QQAvatarFHDDecoder", 2, "downloadFHDAvatar suc " + z16 + " " + fHDAvatarPath);
                }
                if (z16) {
                    k(fHDAvatarPath);
                }
            } else if (file2.exists()) {
                file2.delete();
            }
            if (!z16) {
                l(this.f306435f);
                return;
            }
            return;
        }
        if (QLog.isDevelopLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("downloadFHDAvatar return ");
            if (setting != null) {
                str = setting.toString();
            } else {
                str = "";
            }
            sb5.append(str);
            QLog.i("QQAvatarFHDDecoder", 2, sb5.toString());
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Drawable drawable;
        boolean z16;
        if (message.what == 1) {
            Object obj = message.obj;
            if (obj instanceof Drawable) {
                drawable = (Drawable) obj;
            } else {
                drawable = null;
            }
            if (this.C != null) {
                a aVar = this.C.get();
                if (aVar != null) {
                    String str = this.f306435f;
                    if (drawable != null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    aVar.a(str, z16, drawable);
                }
                this.C = null;
            }
            this.f306436h = false;
            this.f306435f = null;
        }
        return true;
    }

    public boolean j(final String str, final boolean z16, a aVar) {
        if (QLog.isDevelopLevel()) {
            QLog.i("QQAvatarFHDDecoder", 2, "getFHDAvatar " + str + " mIsGettingHead\uff1a" + this.f306436h + " mCurrentUin\uff1a" + this.f306435f + " forceUpdate\uff1a" + z16);
        }
        if (this.f306437i || TextUtils.isEmpty(str) || !Friends.isValidUin(str)) {
            return false;
        }
        if (!NetworkUtil.isNetSupport(i().getApp())) {
            if (QLog.isDevelopLevel()) {
                QLog.i("QQAvatarFHDDecoder", 2, "getFHDAvatar no network");
            }
            return false;
        }
        if (this.f306436h) {
            return false;
        }
        this.f306435f = str;
        this.C = new WeakReference<>(aVar);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.util.QQAvatarFHDDecoder.2
            @Override // java.lang.Runnable
            public void run() {
                if (QQAvatarFHDDecoder.this.f306437i) {
                    return;
                }
                Setting qQHeadSettingFromDB = QQAvatarFHDDecoder.this.i().getQQHeadSettingFromDB(str);
                if (!z16 && qQHeadSettingFromDB != null && !TextUtils.isEmpty(qQHeadSettingFromDB.url) && System.currentTimeMillis() - qQHeadSettingFromDB.updateTimestamp <= 86400000) {
                    QQAvatarFHDDecoder.this.h(qQHeadSettingFromDB);
                } else {
                    ((IQQAvatarHandlerService) QQAvatarFHDDecoder.this.i().getRuntimeService(IQQAvatarHandlerService.class, "")).getCustomHead(str);
                }
            }
        }, 128, null, true);
        return true;
    }

    @Override // com.tencent.mobileqq.utils.HttpDownloadUtil.b
    public void b(String str, long j3, long j16) {
    }
}
