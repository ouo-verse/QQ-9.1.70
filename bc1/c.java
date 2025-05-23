package bc1;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class c implements com.tencent.mobileqq.colornote.f {
    @Override // com.tencent.mobileqq.colornote.f
    public ColorNote getColorNote() {
        ColorNote.a aVar = new ColorNote.a();
        aVar.g(17039360);
        String v3 = QFileUtils.v(-1, "");
        if (QLog.isColorLevel()) {
            QLog.i("DefaultFileColorNoteServiceInfo", 2, "getColorNote: file colorNote key [" + v3 + "]");
        }
        aVar.i(v3);
        aVar.d("default_file");
        aVar.h("0MB");
        aVar.e("resdrawable://" + R.drawable.f161608ea0);
        return aVar.a();
    }
}
