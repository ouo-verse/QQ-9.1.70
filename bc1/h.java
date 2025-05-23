package bc1;

import android.text.TextUtils;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.troop.data.t;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class h implements com.tencent.mobileqq.colornote.f {

    /* renamed from: d, reason: collision with root package name */
    private String f28249d;

    /* renamed from: e, reason: collision with root package name */
    private t f28250e;

    public h(long j3, t tVar) {
        this.f28249d = j3 + "";
        this.f28250e = tVar;
    }

    private String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("file_color_note_peerType", 1);
            jSONObject.put("file_color_note_peerUin", this.f28249d);
            jSONObject.put("file_color_note_fileName", this.f28250e.f294987u);
            jSONObject.put("file_color_note_fileSize", this.f28250e.f294976j);
            UUID uuid = this.f28250e.f294967a;
            if (uuid != null) {
                jSONObject.put("file_color_note_file_uuid", uuid.toString());
            } else {
                jSONObject.put("file_color_note_file_uuid", "");
            }
            jSONObject.put("file_color_note_file_url", this.f28250e.f294985s);
            jSONObject.put("file_color_note_busId", this.f28250e.f294988v);
            return jSONObject.toString();
        } catch (JSONException e16) {
            e16.printStackTrace();
            return "";
        }
    }

    @Override // com.tencent.mobileqq.colornote.f
    public ColorNote getColorNote() {
        ColorNote.a aVar = new ColorNote.a();
        aVar.g(17039360);
        String v3 = QFileUtils.v(2, this.f28250e.f294985s);
        if (QLog.isColorLevel()) {
            QLog.i("TroopFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + v3 + "]");
        }
        aVar.i(v3);
        aVar.d(this.f28250e.f294987u);
        aVar.h(q.g(this.f28250e.f294976j));
        aVar.e("resdrawable://" + FileManagerUtil.getFileIconResId(FileManagerUtil.getFileType(this.f28250e.f294987u)));
        String a16 = a();
        if (!TextUtils.isEmpty(a16)) {
            aVar.f(a16.getBytes());
        }
        return aVar.a();
    }
}
