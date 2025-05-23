package bc1;

import android.text.TextUtils;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class f implements com.tencent.mobileqq.colornote.f {

    /* renamed from: d, reason: collision with root package name */
    private FileManagerEntity f28248d;

    public f(FileManagerEntity fileManagerEntity) {
        this.f28248d = fileManagerEntity;
    }

    private String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            FileManagerEntity fileManagerEntity = this.f28248d;
            if (fileManagerEntity == null) {
                return "";
            }
            jSONObject.put("file_color_note_peerType", fileManagerEntity.peerType);
            jSONObject.put("file_color_note_peerUin", this.f28248d.peerUin);
            jSONObject.put("file_color_note_uniSeq", this.f28248d.uniseq);
            jSONObject.put("file_color_note_sessionId", this.f28248d.nSessionId);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    @Override // com.tencent.mobileqq.colornote.f
    public ColorNote getColorNote() {
        if (this.f28248d == null) {
            QLog.i("OfflineFileColorNoteServiceInfo", 1, "getColorNote: offline file info is null.");
            return null;
        }
        ColorNote.a aVar = new ColorNote.a();
        aVar.g(17039360);
        String v3 = QFileUtils.v(1, this.f28248d.nSessionId + "");
        if (QLog.isColorLevel()) {
            QLog.i("OfflineFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + v3 + "] fileId[" + this.f28248d.Uuid + "]");
        }
        aVar.i(v3);
        aVar.d(this.f28248d.fileName);
        aVar.h(q.g(this.f28248d.fileSize));
        aVar.e("resdrawable://" + FileManagerUtil.getFileIconResId(FileManagerUtil.getFileType(this.f28248d.fileName)));
        String a16 = a();
        if (!TextUtils.isEmpty(a16)) {
            aVar.f(a16.getBytes());
        }
        return aVar.a();
    }
}
