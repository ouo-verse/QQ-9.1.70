package com.tencent.mobileqq.filemanager.fileviewer;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class d implements j {

    /* renamed from: a, reason: collision with root package name */
    private int f208214a = 0;

    /* renamed from: b, reason: collision with root package name */
    private boolean f208215b = false;

    /* renamed from: c, reason: collision with root package name */
    private boolean f208216c = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f208217d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f208218e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f208219f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f208220g = false;

    public static j f(QQAppInterface qQAppInterface, FileManagerEntity fileManagerEntity) {
        return new ac1.a(qQAppInterface, fileManagerEntity);
    }

    public static j g(QQAppInterface qQAppInterface, WeiYunFileInfo weiYunFileInfo) {
        return new ac1.d(qQAppInterface, weiYunFileInfo);
    }

    public static j h(FileInfo fileInfo) {
        return new ac1.b(fileInfo);
    }

    public static j i(QQAppInterface qQAppInterface, FileManagerEntity fileManagerEntity) {
        return new ac1.c(qQAppInterface, fileManagerEntity);
    }

    private boolean j() {
        int v3 = v();
        if (v3 != 15 && v3 != 16 && v3 != 5) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public void p(boolean z16) {
        this.f208215b = z16;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public String q() {
        return "";
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public void r(boolean z16) {
        this.f208216c = z16;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public void setState(int i3) {
        this.f208214a = i3;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public String x() {
        boolean z16;
        if (j()) {
            return q.g(getFileSize());
        }
        if (a() == 58 || w() <= 0 || v() == 3) {
            return "";
        }
        if (getFileId() != null && getFileId().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return "";
        }
        return "" + BaseApplication.getContext().getString(R.string.b78) + FileManagerUtil.millsTimeToString(w(), b());
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.j
    public boolean y() {
        return this.f208218e;
    }
}
