package bc1;

import android.text.TextUtils;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b implements com.tencent.mobileqq.colornote.f {

    /* renamed from: d, reason: collision with root package name */
    private DataLineMsgRecord f28245d;

    public b(DataLineMsgRecord dataLineMsgRecord) {
        this.f28245d = dataLineMsgRecord;
    }

    private String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            DataLineMsgRecord dataLineMsgRecord = this.f28245d;
            if (dataLineMsgRecord == null) {
                return "";
            }
            jSONObject.put("file_color_note_uniSeq", dataLineMsgRecord.sessionid);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    @Override // com.tencent.mobileqq.colornote.f
    public ColorNote getColorNote() {
        if (this.f28245d == null) {
            QLog.i("DatalineFileColorNoteServiceInfo", 1, "getColorNote: offline file info is null.");
            return null;
        }
        ColorNote.a aVar = new ColorNote.a();
        aVar.g(17039360);
        String v3 = QFileUtils.v(6, this.f28245d.sessionid + "");
        if (QLog.isColorLevel()) {
            QLog.i("DatalineFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + v3 + "]");
        }
        aVar.i(v3);
        aVar.d(this.f28245d.filename);
        aVar.h(q.g(this.f28245d.filesize));
        aVar.e("resdrawable://" + FileManagerUtil.getFileIconResId(FileManagerUtil.getFileType(this.f28245d.filename)));
        String a16 = a();
        if (!TextUtils.isEmpty(a16)) {
            aVar.f(a16.getBytes());
        }
        return aVar.a();
    }
}
