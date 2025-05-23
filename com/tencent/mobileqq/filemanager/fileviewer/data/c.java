package com.tencent.mobileqq.filemanager.fileviewer.data;

import android.text.TextUtils;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.j;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c implements FileBrowserModelBase.b {

    /* renamed from: a, reason: collision with root package name */
    protected j f208234a;

    /* renamed from: d, reason: collision with root package name */
    protected String f208237d;

    /* renamed from: e, reason: collision with root package name */
    protected String f208238e;

    /* renamed from: b, reason: collision with root package name */
    protected int f208235b = 0;

    /* renamed from: c, reason: collision with root package name */
    protected int f208236c = 0;

    /* renamed from: f, reason: collision with root package name */
    protected int f208239f = -1;

    public c(j jVar) {
        this.f208234a = jVar;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.b
    public void a(String str) {
        if (q.f(str)) {
            this.f208238e = str;
        } else if (QLog.isColorLevel()) {
            QLog.i("DefaultImageInfo", 2, "setImageOriginPath error  : can not find origin file [path] =  " + str);
        }
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.b
    public boolean b() {
        if (this.f208234a.getFileSize() < ((IFMConfig) QRoute.api(IFMConfig.class)).getMaxCreateThumbFileSize()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.b
    public boolean c(String str) {
        if (this.f208234a.getEntity() != null && this.f208234a.getEntity().isZipInnerFile) {
            return str.equalsIgnoreCase(String.valueOf(this.f208234a.getSessionId()));
        }
        if (!str.equalsIgnoreCase(this.f208234a.getUuid()) && !str.equalsIgnoreCase(this.f208234a.getFileId())) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.b
    public String d() {
        return this.f208238e;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.b
    public String e() {
        String q16 = this.f208234a.q();
        if (q16 == null || q16.equals("")) {
            String u16 = this.f208234a.u();
            if (u16 == null) {
                return "";
            }
            this.f208235b = 2;
            return u16;
        }
        return q16;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.b
    public void f(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f208237d = str;
            this.f208234a.t(str);
        }
    }

    public j g() {
        return this.f208234a;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.b
    public int getImageType() {
        return this.f208235b;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.b
    public URL getImageUrl() {
        String q16 = this.f208234a.q();
        if (TextUtils.isEmpty(q16)) {
            q16 = this.f208234a.u();
            if (q16 == null) {
                setState(1);
                return null;
            }
            this.f208235b = 2;
        } else {
            this.f208235b = 1;
        }
        String str = q16;
        if (q.f(str)) {
            if (this.f208235b == 1) {
                return AsyncImageView.f(str);
            }
            return AsyncImageView.d(str, -1, -1, new File(str), false, false, false);
        }
        setState(1);
        return null;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.b
    public int getOrientation() {
        if (this.f208239f == -1) {
            try {
                String q16 = this.f208234a.q();
                if (q.f(q16)) {
                    this.f208239f = JpegExifReader.readOrientation(q16);
                } else {
                    return 1;
                }
            } catch (Exception unused) {
                this.f208239f = 0;
            }
        }
        return this.f208239f;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.b
    public boolean isLoading() {
        FileManagerEntity entity;
        j jVar = this.f208234a;
        if (jVar == null || (entity = jVar.getEntity()) == null) {
            return false;
        }
        if (entity.isZipInnerFile) {
            if (entity.status != 2) {
                return false;
            }
            return true;
        }
        if (this.f208236c != 1) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase.b
    public void setState(int i3) {
        this.f208236c = i3;
    }
}
