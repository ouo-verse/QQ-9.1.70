package ac1;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.troop.data.t;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c extends a {

    /* renamed from: l, reason: collision with root package name */
    public t f25797l;

    public c(QQAppInterface qQAppInterface, FileManagerEntity fileManagerEntity) {
        super(qQAppInterface, fileManagerEntity);
        this.f25793i = FileManagerUtil.canPreview(qQAppInterface.getApplication().getBaseContext(), fileManagerEntity.fileName, fileManagerEntity.fileSize);
        boolean z16 = false;
        if (fileManagerEntity.isZipInnerFile && FileManagerUtil.isZipFile(qQAppInterface, this, true)) {
            this.f25793i = false;
        }
        t n3 = TroopFileUtils.n(qQAppInterface, fileManagerEntity);
        this.f25797l = n3;
        int i3 = n3.f294972f;
        if (i3 == 2 || i3 == 3) {
            boolean isLocalPreviewOffline = FileManagerUtil.isLocalPreviewOffline(this);
            if (v() == 3) {
                if (this.f25793i && isLocalPreviewOffline) {
                    z16 = true;
                }
                this.f25793i = z16;
            }
        }
    }

    @Override // ac1.a, com.tencent.mobileqq.filemanager.fileviewer.j
    public int c() {
        if (v() == 6 && a() == 31) {
            return super.c();
        }
        t tVar = this.f25797l;
        if (tVar != null) {
            return tVar.f294972f;
        }
        return 0;
    }

    @Override // ac1.a, com.tencent.mobileqq.filemanager.fileviewer.j
    public int v() {
        if (q.f(super.getFilePath())) {
            return 3;
        }
        return super.v();
    }

    @Override // com.tencent.mobileqq.filemanager.fileviewer.d, com.tencent.mobileqq.filemanager.fileviewer.j
    public String x() {
        String g16 = q.g(super.getFileSize());
        if (104 == super.getEntity().busId && super.getEntity().lastTime > 0) {
            return (g16 + BaseApplication.getContext().getString(R.string.b78)) + TroopFileUtils.e(BaseApplication.getContext(), super.getEntity().lastTime);
        }
        return g16;
    }
}
