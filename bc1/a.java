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
public class a implements com.tencent.mobileqq.colornote.f {

    /* renamed from: d, reason: collision with root package name */
    private FileManagerEntity f28244d;

    public a(FileManagerEntity fileManagerEntity) {
        this.f28244d = fileManagerEntity;
    }

    private String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            FileManagerEntity fileManagerEntity = this.f28244d;
            if (fileManagerEntity == null) {
                return "";
            }
            jSONObject.put("file_color_note_sessionId", fileManagerEntity.nSessionId);
            jSONObject.put("file_color_note_cloud_lastTime", this.f28244d.lastTime);
            jSONObject.put("file_color_note_cloud_fileId", this.f28244d.WeiYunFileId);
            jSONObject.put("file_color_note_fileName", this.f28244d.fileName);
            jSONObject.put("file_color_note_fileSize", this.f28244d.fileSize);
            jSONObject.put("file_color_note_cloud_srcType", this.f28244d.nWeiYunSrcType);
            jSONObject.put("file_color_note_cloud_encodeUrl", this.f28244d.strLargeThumPath);
            jSONObject.put("file_color_note_cloud_dirKey", this.f28244d.WeiYunDirKey);
            jSONObject.put("file_color_note_cloud_", this.f28244d.strFileMd5);
            jSONObject.put("file_color_note_cloud_", this.f28244d.strFileSHA);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    @Override // com.tencent.mobileqq.colornote.f
    public ColorNote getColorNote() {
        if (this.f28244d == null) {
            QLog.i("CloudFileColorNoteServiceInfo", 1, "getColorNote: offline file info is null.");
            return null;
        }
        ColorNote.a aVar = new ColorNote.a();
        aVar.g(17039360);
        String v3 = QFileUtils.v(3, this.f28244d.nSessionId + this.f28244d.WeiYunFileId);
        if (QLog.isColorLevel()) {
            QLog.i("CloudFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + v3 + "]");
        }
        aVar.i(v3);
        aVar.d(this.f28244d.fileName);
        aVar.h(q.g(this.f28244d.fileSize));
        aVar.e("resdrawable://" + FileManagerUtil.getFileIconResId(FileManagerUtil.getFileType(this.f28244d.fileName)));
        String a16 = a();
        if (!TextUtils.isEmpty(a16)) {
            aVar.f(a16.getBytes());
        }
        return aVar.a();
    }
}
