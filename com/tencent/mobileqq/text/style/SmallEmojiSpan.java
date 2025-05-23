package com.tencent.mobileqq.text.style;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.SmallEmoticonInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.AbsQQText;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.api.IEmojiManagerService;
import com.tencent.qqnt.emotion.api.IEmoticonManagerService;
import com.tencent.qqnt.emotion.constant.c;
import com.tencent.qqnt.emotion.constant.d;
import com.tencent.qqnt.emotion.emosm.b;
import com.tencent.qqnt.emotion.utils.f;
import com.tencent.qqnt.http.api.IHttpService;
import com.tencent.qqnt.http.api.b;
import com.tencent.qqnt.http.api.m;
import java.io.File;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SmallEmojiSpan extends EmoticonSpan implements ISmallEmojiSpan {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    int f292734d;

    /* renamed from: e, reason: collision with root package name */
    public int f292735e;

    /* renamed from: f, reason: collision with root package name */
    public int f292736f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f292737h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f292738i;

    /* renamed from: m, reason: collision with root package name */
    private String f292739m;

    public SmallEmojiSpan(char[] cArr, int i3, boolean z16, boolean z17) {
        super(-1, i3, 2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, cArr, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        this.f292737h = z17;
        this.f292734d = i3;
        this.f292738i = z16;
        int[] m3 = b.m(cArr);
        if (m3 != null && m3.length == 2) {
            this.f292735e = m3[0];
            this.f292736f = m3[1];
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime != null) {
            this.f292739m = waitAppRuntime.getAccount();
        }
        String str = this.f292739m;
        this.f292739m = str == null ? "" : str;
    }

    private void a() {
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.text.style.SmallEmojiSpan.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SmallEmojiSpan.this);
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
            /* JADX WARN: Removed duplicated region for block: B:18:0x004a  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                AppInterface appInterface;
                Emoticon emoticon;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                String replace = d.f356214l.replace("[epId]", Integer.toString(SmallEmojiSpan.this.f292735e));
                boolean fileExists = FileUtils.fileExists(replace);
                byte[] bArr = null;
                try {
                    appInterface = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
                } catch (ClassCastException e16) {
                    e16.printStackTrace();
                    appInterface = null;
                    if (appInterface == null) {
                    }
                } catch (Exception e17) {
                    e17.printStackTrace();
                    appInterface = null;
                    if (appInterface == null) {
                    }
                }
                if (appInterface == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(QQText.TAG, 2, "appInterface is null. return");
                        return;
                    }
                    return;
                }
                if (fileExists) {
                    IEmoticonManagerService n3 = b.n();
                    if (n3 != null) {
                        emoticon = n3.syncFindEmoticonById(Integer.toString(SmallEmojiSpan.this.f292735e), Integer.toString(SmallEmojiSpan.this.f292736f));
                    } else {
                        emoticon = null;
                    }
                    if (emoticon != null) {
                        EmoticonPackage syncFindEmoticonPackageById = n3.syncFindEmoticonPackageById(Integer.toString(SmallEmojiSpan.this.f292735e));
                        if (syncFindEmoticonPackageById != null && syncFindEmoticonPackageById.isAPNG == 0) {
                            f.n(appInterface, syncFindEmoticonPackageById, c.f356199a, FileUtils.fileToBytes(new File(replace)), new ArrayList());
                        }
                        SmallEmojiSpan.this.b(syncFindEmoticonPackageById);
                        return;
                    }
                }
                String replace2 = "https://i.gtimg.cn/qqshow/admindata/comdata/vipSmallEmoji_item_[epId]/xydata.json".replace("[epId]", Integer.toString(SmallEmojiSpan.this.f292735e));
                File file = new File(replace);
                if (QLog.isColorLevel()) {
                    QLog.d(QQText.TAG, 2, "small emoji json not exist. epId:" + SmallEmojiSpan.this.f292735e + ",downloadUrl:" + replace2);
                }
                m syncExecute = ((IHttpService) QRoute.api(IHttpService.class)).syncExecute(new b.a("SmallEmoji", replace2, file).R(true).c());
                EmoticonPackage emoticonPackage = new EmoticonPackage();
                emoticonPackage.epId = Integer.toString(SmallEmojiSpan.this.f292735e);
                emoticonPackage.jobType = 4;
                if (syncExecute.e()) {
                    if (file.exists()) {
                        bArr = FileUtils.fileToBytes(file);
                    }
                    f.n(appInterface, emoticonPackage, c.f356199a, bArr, new ArrayList());
                    SmallEmojiSpan.this.b(emoticonPackage);
                }
            }
        };
        IEmojiManagerService iEmojiManagerService = null;
        try {
            iEmojiManagerService = (IEmojiManagerService) ((AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null)).getRuntimeService(IEmojiManagerService.class, "");
        } catch (Exception unused) {
        }
        if (iEmojiManagerService != null) {
            iEmojiManagerService.getEmoQueue().excuteOnNetThread(runnable, true);
        }
    }

    public void b(EmoticonPackage emoticonPackage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) emoticonPackage);
        } else if (!this.f292737h && emoticonPackage != null && emoticonPackage.isAPNG == 2) {
            this.f292737h = true;
        }
    }

    @Override // com.tencent.mobileqq.text.style.EmoticonSpan
    protected Drawable doGetDrwable() {
        Drawable bigDrawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Drawable) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        SmallEmoticonInfo smallEmoticonInfo = new SmallEmoticonInfo(this.f292739m);
        Emoticon emoticon = new Emoticon();
        emoticon.eId = String.valueOf(this.f292736f);
        emoticon.epId = String.valueOf(this.f292735e);
        if (!this.f292738i) {
            emoticon.jobType = 3;
            smallEmoticonInfo.emoticon = emoticon;
            bigDrawable = smallEmoticonInfo.getDrawable(BaseApplication.getContext(), BaseApplication.getContext().getResources().getDisplayMetrics().density);
        } else {
            emoticon.jobType = 3;
            smallEmoticonInfo.emoticon = emoticon;
            smallEmoticonInfo.isAPNG = this.f292737h;
            bigDrawable = smallEmoticonInfo.getBigDrawable(BaseApplication.getContext(), BaseApplication.getContext().getResources().getDisplayMetrics().density);
            a();
        }
        if (bigDrawable != null) {
            int i3 = this.f292734d;
            bigDrawable.setBounds(0, 0, i3, i3);
        }
        return bigDrawable;
    }

    @Override // com.tencent.mobileqq.text.style.ISmallEmojiSpan
    public float getBottom() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Float) iPatchRedirector.redirect((short) 9, (Object) this)).floatValue();
        }
        return this.eBottom;
    }

    @Override // com.tencent.mobileqq.text.style.EmoticonSpan
    public String getDescription() {
        Emoticon emoticon;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        String str = AbsQQText.SMALL_EMOJI_SYMBOL;
        IEmoticonManagerService n3 = com.tencent.qqnt.emotion.emosm.b.n();
        if (n3 != null) {
            emoticon = n3.syncFindEmoticonById(Integer.toString(this.f292735e), Integer.toString(this.f292736f));
        } else {
            emoticon = null;
        }
        if (emoticon != null) {
            str = emoticon.character;
        }
        if (QLog.isColorLevel()) {
            QLog.d(QQText.TAG, 2, "descp:" + str);
        }
        return str;
    }

    @Override // com.tencent.mobileqq.text.style.ISmallEmojiSpan
    public int getEId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.f292736f;
    }

    @Override // com.tencent.mobileqq.text.style.ISmallEmojiSpan
    public int getEpId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return this.f292735e;
    }

    @Override // com.tencent.mobileqq.text.style.EmoticonSpan
    public int getIndex() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.f292735e;
    }

    @Override // com.tencent.mobileqq.text.style.ISmallEmojiSpan
    public float getLeft() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Float) iPatchRedirector.redirect((short) 8, (Object) this)).floatValue();
        }
        return this.eLeft;
    }

    @Override // com.tencent.mobileqq.text.style.ISmallEmojiSpan
    public float getRight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Float) iPatchRedirector.redirect((short) 11, (Object) this)).floatValue();
        }
        return this.eRight;
    }

    @Override // com.tencent.mobileqq.text.style.EmoticonSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i3, int i16, Paint.FontMetricsInt fontMetricsInt) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, this, paint, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), fontMetricsInt)).intValue();
        }
        if (fontMetricsInt != null) {
            int i17 = -this.f292734d;
            fontMetricsInt.ascent = i17;
            fontMetricsInt.descent = 0;
            fontMetricsInt.top = i17;
            fontMetricsInt.bottom = 0;
        }
        return this.f292734d;
    }

    @Override // com.tencent.mobileqq.text.style.ISmallEmojiSpan
    public float getTop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Float) iPatchRedirector.redirect((short) 10, (Object) this)).floatValue();
        }
        return this.eTop;
    }

    @Override // com.tencent.mobileqq.text.style.ISmallEmojiSpan
    public void setIsAnim(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        } else {
            this.f292738i = z16;
        }
    }

    @Override // com.tencent.mobileqq.text.style.EmoticonSpan
    public void setSize(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("tag.vasFont.enlarge", 2, "SmallEmojiSpan setSize size: " + i3);
        }
        this.f292734d = i3;
        this.size = i3;
    }
}
