package bc1;

import android.text.TextUtils;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class d implements com.tencent.mobileqq.colornote.f {

    /* renamed from: d, reason: collision with root package name */
    private String f28246d;

    public d(String str) {
        this.f28246d = str;
        if (FileUtils.fileExistsAndNotEmpty(str)) {
            this.f28246d = new File(this.f28246d).getAbsolutePath();
        }
    }

    private String a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("file_color_note_local_path", this.f28246d);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    @Override // com.tencent.mobileqq.colornote.f
    public ColorNote getColorNote() {
        if (!FileUtils.fileExistsAndNotEmpty(this.f28246d)) {
            QLog.i("FavFileColorNoteServiceInfo", 1, "getColorNote: loacl file path is null");
            return null;
        }
        ColorNote.a aVar = new ColorNote.a();
        aVar.g(17039360);
        String v3 = QFileUtils.v(4, this.f28246d);
        if (QLog.isColorLevel()) {
            QLog.i("FavFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + v3 + "]");
        }
        aVar.i(v3);
        String fileName = FileManagerUtil.getFileName(this.f28246d);
        aVar.d(fileName);
        aVar.h(q.g(FileManagerUtil.getFileSizes(this.f28246d)));
        aVar.e("resdrawable://" + FileManagerUtil.getFileIconResId(FileManagerUtil.getFileType(fileName)));
        String a16 = a();
        if (!TextUtils.isEmpty(a16)) {
            aVar.f(a16.getBytes());
        }
        return aVar.a();
    }
}
