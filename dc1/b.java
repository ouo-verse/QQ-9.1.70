package dc1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b extends a {

    /* renamed from: i, reason: collision with root package name */
    private QQAppInterface f393535i;

    /* renamed from: j, reason: collision with root package name */
    private Context f393536j;

    /* renamed from: k, reason: collision with root package name */
    private FileManagerEntity f393537k;

    /* renamed from: l, reason: collision with root package name */
    private int f393538l;

    /* renamed from: m, reason: collision with root package name */
    private Bundle f393539m;

    public b(QQAppInterface qQAppInterface, Context context, FileManagerEntity fileManagerEntity, int i3) {
        super(qQAppInterface, context);
        this.f393536j = context;
        FileManagerUtil.associateLocalWithCloud(fileManagerEntity);
        this.f393537k = fileManagerEntity;
        this.f393535i = qQAppInterface;
        this.f393538l = i3;
    }

    private ForwardFileInfo v() {
        String str;
        ForwardFileInfo forwardFileInfo = new ForwardFileInfo();
        forwardFileInfo.E(this.f393537k.nSessionId);
        forwardFileInfo.y(this.f393537k.fileName);
        forwardFileInfo.z(this.f393537k.fileSize);
        forwardFileInfo.C(this.f393537k.getFilePath());
        forwardFileInfo.N(this.f393538l);
        int i3 = this.f393538l;
        if (i3 != 10000) {
            if (i3 != 10001) {
                if (i3 == 10004) {
                    FileManagerEntity fileManagerEntity = this.f393537k;
                    if (fileManagerEntity.bSend) {
                        str = this.f393535i.getAccount();
                    } else {
                        str = fileManagerEntity.peerUin;
                    }
                    forwardFileInfo.w(this.f393537k.getCloudType());
                    if (str != null) {
                        forwardFileInfo.B(Long.valueOf(str.replace(Marker.ANY_NON_NULL_MARKER, "")).longValue());
                    }
                    forwardFileInfo.V(this.f393537k.uniseq);
                    forwardFileInfo.Z(this.f393537k.Uuid);
                }
            } else {
                forwardFileInfo.w(this.f393537k.getCloudType());
                forwardFileInfo.V(this.f393537k.uniseq);
                forwardFileInfo.Z(this.f393537k.Uuid);
            }
        } else {
            forwardFileInfo.w(3);
            forwardFileInfo.N(10000);
        }
        return forwardFileInfo;
    }

    private Intent w() {
        Intent intent = new Intent();
        Bundle bundle = this.f393539m;
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        return intent;
    }

    @Override // dc1.e
    public boolean a() {
        int fileType = FileManagerUtil.getFileType(m());
        if (fileType != 2) {
            if (QLog.isColorLevel()) {
                QLog.i("FileVideo", 1, "id:" + this.f393537k.nSessionId + " type is:" + fileType + " use old filebrowser:");
            }
            return false;
        }
        boolean fileExist = FileManagerUtil.fileExist(n());
        if (QLog.isColorLevel()) {
            QLog.i("FileVideo", 1, "id:" + this.f393537k.nSessionId + " status:" + this.f393537k.status + " isLocal:" + fileExist);
        }
        if (!fileExist && com.tencent.mobileqq.filemanager.fileassistant.util.h.k(this.f393537k.peerUin)) {
            return false;
        }
        if (fileExist) {
            FileManagerEntity fileManagerEntity = this.f393537k;
            if (fileManagerEntity.status != 1 && fileManagerEntity.isSend()) {
                return false;
            }
        }
        return true;
    }

    @Override // dc1.e
    public Intent d() {
        ForwardFileInfo v3 = v();
        Intent w3 = w();
        w3.putExtra("fileinfo", v3);
        w3.putExtra(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, HardCodeUtil.qqStr(R.string.f171898lr0));
        return w3;
    }

    @Override // dc1.e
    public boolean j() {
        int i3 = this.f393537k.status;
        if (i3 != 0 && i3 != 3) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("FileVideo", 1, "id:" + this.f393537k.nSessionId + " status:" + this.f393537k.status + " resume");
        }
        this.f393535i.getFileManagerEngine().o0(this.f393537k.nSessionId);
        return true;
    }

    @Override // dc1.e
    public void k(Bundle bundle) {
        Bundle bundle2 = this.f393539m;
        if (bundle2 != null && bundle != null) {
            if (bundle2.containsKey("file_color_note_subType")) {
                bundle.putInt("file_color_note_subType", this.f393539m.getInt("file_color_note_subType", -1));
            }
            if (this.f393539m.containsKey("file_location_pos_entrance_multiseq")) {
                bundle.putBoolean("file_location_pos_entrance_multiseq", this.f393539m.getBoolean("file_location_pos_entrance_multiseq", false));
            }
        }
    }

    @Override // dc1.a
    protected String m() {
        FileManagerEntity fileManagerEntity = this.f393537k;
        if (fileManagerEntity != null) {
            return fileManagerEntity.fileName;
        }
        return "";
    }

    @Override // dc1.a
    protected String n() {
        FileManagerEntity fileManagerEntity = this.f393537k;
        if (fileManagerEntity != null) {
            return fileManagerEntity.getFilePath();
        }
        return "";
    }

    @Override // dc1.a
    protected long o() {
        FileManagerEntity fileManagerEntity = this.f393537k;
        if (fileManagerEntity != null) {
            return fileManagerEntity.fileSize;
        }
        return 0L;
    }

    @Override // dc1.a
    protected int p() {
        FileManagerEntity fileManagerEntity = this.f393537k;
        if (fileManagerEntity != null) {
            return fileManagerEntity.status;
        }
        return 0;
    }

    public void x(Bundle bundle) {
        this.f393539m = bundle;
    }
}
