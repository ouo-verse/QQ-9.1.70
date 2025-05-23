package com.tencent.mobileqq.filemanager.fileviewer;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserManager;
import com.tencent.mobileqq.filemanager.fileviewer.model.FileBrowserModelBase;
import com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    protected QQAppInterface f208434a;

    /* renamed from: b, reason: collision with root package name */
    protected FileManagerEntity f208435b;

    /* renamed from: c, reason: collision with root package name */
    protected List<j> f208436c;

    /* renamed from: d, reason: collision with root package name */
    protected int f208437d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f208438e = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements FileBrowserManager.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseActivity f208439a;

        a(BaseActivity baseActivity) {
            this.f208439a = baseActivity;
        }

        @Override // com.tencent.mobileqq.filemanager.fileviewer.FileBrowserManager.e
        public FileBrowserModelBase a() {
            List<j> b16 = o.this.b();
            if (b16 != null && b16.size() > 0) {
                o oVar = o.this;
                return new TroopFileModel(oVar.f208434a, this.f208439a, b16, oVar.f208438e);
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(QQAppInterface qQAppInterface) {
        this.f208434a = qQAppInterface;
    }

    public List<j> b() {
        return this.f208436c;
    }

    public FileBrowserManager.e c(BaseActivity baseActivity) {
        return new a(baseActivity);
    }

    public int d() {
        return this.f208437d;
    }

    public boolean e(Intent intent, Activity activity) {
        ForwardFileInfo forwardFileInfo = (ForwardFileInfo) intent.getParcelableExtra("fileinfo");
        if (forwardFileInfo == null) {
            return false;
        }
        if (intent.getBooleanExtra("from_webview", false)) {
            QFileUtils.n(this.f208434a, activity, null, null, forwardFileInfo.k(), TroopFileUtils.k(this.f208434a, forwardFileInfo.k(), forwardFileInfo.s(), forwardFileInfo.q(), forwardFileInfo.f(), forwardFileInfo.g(), intent.getIntExtra("bisId", 0)), intent.getStringExtra("sender_uin"), intent.getLongExtra("last_time", 0L), -1, 0, null, false, false);
            activity.finish();
            return false;
        }
        long n3 = forwardFileInfo.n();
        FileManagerEntity D = this.f208434a.getFileManagerDataCenter().D(n3);
        this.f208435b = D;
        if (D == null) {
            return false;
        }
        if (7 == D.status && !TextUtils.isEmpty(D.getFilePath())) {
            QLog.i("TroopFileViewerParamParser", 1, "status is not download, local path:" + this.f208435b.getFilePath() + ", sessionId:" + n3 + ", fileId:" + this.f208435b.strTroopFileID);
        }
        this.f208436c = new ArrayList();
        this.f208435b.lastTime = intent.getLongExtra("last_time", 0L);
        this.f208436c.add(d.i(this.f208434a, this.f208435b));
        if (this.f208435b.nFileType == 0) {
            this.f208437d = 1;
        } else {
            this.f208437d = 3;
        }
        return true;
    }
}
