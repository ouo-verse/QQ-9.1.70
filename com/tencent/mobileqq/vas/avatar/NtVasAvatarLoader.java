package com.tencent.mobileqq.vas.avatar;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.AppInterface;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vas.avatar.m;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.URL;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class NtVasAvatarLoader implements m.a<String> {

    /* renamed from: i, reason: collision with root package name */
    private static final Drawable f308734i = new ColorDrawable(16777215);

    /* renamed from: a, reason: collision with root package name */
    public int f308735a;

    /* renamed from: b, reason: collision with root package name */
    public String f308736b;

    /* renamed from: c, reason: collision with root package name */
    public long f308737c;

    /* renamed from: d, reason: collision with root package name */
    public String f308738d;

    /* renamed from: e, reason: collision with root package name */
    public int f308739e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f308740f;

    /* renamed from: g, reason: collision with root package name */
    public Drawable f308741g = f308734i;

    /* renamed from: h, reason: collision with root package name */
    public WeakReference<NtVasAvatar> f308742h;

    public NtVasAvatarLoader(String str, int i3, int i16, String str2, boolean z16) {
        this.f308736b = str;
        this.f308735a = i3;
        this.f308740f = z16;
        this.f308738d = str2;
        this.f308739e = i16;
    }

    public void a() {
        NtVasAvatar ntVasAvatar = this.f308742h.get();
        if (ntVasAvatar != null && ntVasAvatar.f308730f == this && (MobileQQ.sMobileQQ.peekAppRuntime() instanceof AppInterface) && this.f308735a > 0) {
            NtVasFaceManager.j().f(this.f308735a, this.f308738d, this, null);
        }
    }

    @Override // com.tencent.mobileqq.vas.avatar.m.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onComplete(String str, Object obj) {
        c(str, obj, this.f308737c);
    }

    public void c(String str, Object obj, long j3) {
        NtVasAvatar ntVasAvatar;
        if (obj == f308734i) {
            a();
            return;
        }
        if (str == null) {
            QLog.e("VasAvatarLoader", 1, "VasAvatar get null path");
            return;
        }
        if ((this.f308739e != -1 || !a03.a.a()) && (ntVasAvatar = this.f308742h.get()) != null && ntVasAvatar.f308730f == this) {
            try {
                URL url = new URL("file", str, "");
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mUseApngImage = true;
                obtain.mUseMemoryCache = true;
                obtain.mMemoryCacheKeySuffix = Long.toString(j3);
                Drawable drawable = ntVasAvatar.f308729e;
                obtain.mFailedDrawable = drawable;
                obtain.mLoadingDrawable = drawable;
                obtain.mExtraInfo = NtVasFaceManager.h(this.f308740f);
                NtVasFaceManager.j().e(url, obtain);
                final URLDrawable drawable2 = URLDrawable.getDrawable(url, obtain);
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.vas.avatar.NtVasAvatarLoader.1
                    @Override // java.lang.Runnable
                    public void run() {
                        NtVasAvatar ntVasAvatar2 = NtVasAvatarLoader.this.f308742h.get();
                        if (ntVasAvatar2 != null && ntVasAvatar2.f308730f == NtVasAvatarLoader.this) {
                            ntVasAvatar2.setImageDrawable(drawable2);
                            ntVasAvatar2.h(NtVasAvatarLoader.this.f308736b, r1.f308735a);
                            if (!NtVasAvatarLoader.this.f308740f) {
                                Drawable currDrawable = drawable2.getCurrDrawable();
                                if (currDrawable instanceof ApngDrawable) {
                                    if (NtVasAvatarLoader.this.f308739e != -1) {
                                        NtVasFaceManager.o((ApngDrawable) currDrawable);
                                    }
                                    NtVasFaceManager.n(NtVasAvatarLoader.this.f308736b, (ApngDrawable) currDrawable);
                                    ntVasAvatar2.i();
                                }
                            }
                        }
                    }
                });
            } catch (Exception e16) {
                QLog.e("VasAvatarLoader", 1, "getApngDrawable ApngImage err, path:" + str, e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(NtVasAvatar ntVasAvatar) {
        this.f308742h = new WeakReference<>(ntVasAvatar);
        a();
    }
}
