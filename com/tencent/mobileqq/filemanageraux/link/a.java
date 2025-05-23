package com.tencent.mobileqq.filemanageraux.link;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes12.dex */
interface a {

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filemanageraux.link.a$a, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static final class C7594a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        int f209625a;

        /* renamed from: b, reason: collision with root package name */
        boolean f209626b;

        /* renamed from: c, reason: collision with root package name */
        String f209627c;

        /* renamed from: d, reason: collision with root package name */
        boolean f209628d;

        public C7594a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f209625a = 1;
            }
        }
    }

    C7594a A7();

    String Ce();

    boolean J4(Bitmap bitmap, int i3, String str);

    void O9();

    FileManagerEntity W();

    void f4();

    BaseActivity getBaseActivity();

    String getFileName();

    String getFilePath();

    long getFileSize();

    int getFileType();

    void s9(Bitmap bitmap);
}
