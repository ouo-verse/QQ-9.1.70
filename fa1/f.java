package fa1;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.troop.data.t;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class f implements b {
    private QQAppInterface a() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (runtime != null && (runtime instanceof QQAppInterface)) {
            return (QQAppInterface) runtime;
        }
        return null;
    }

    private void b(Context context, ColorNote colorNote) {
        QQAppInterface a16 = a();
        if (a16 == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(colorNote.getReserve()));
            FileManagerEntity D = a16.getFileManagerDataCenter().D(jSONObject.getLong("file_color_note_sessionId"));
            WeiYunFileInfo weiYunFileInfo = new WeiYunFileInfo();
            weiYunFileInfo.f209607i = jSONObject.getLong("file_color_note_cloud_lastTime");
            weiYunFileInfo.f209606h = jSONObject.getLong("file_color_note_fileSize");
            weiYunFileInfo.f209608m = jSONObject.getInt("file_color_note_cloud_srcType");
            weiYunFileInfo.f209603d = jSONObject.getString("file_color_note_cloud_fileId");
            weiYunFileInfo.f209604e = jSONObject.getString("file_color_note_cloud_dirKey");
            weiYunFileInfo.f209605f = jSONObject.getString("file_color_note_fileName");
            if (jSONObject.has("file_color_note_cloud_encodeUrl")) {
                weiYunFileInfo.E = jSONObject.getString("file_color_note_cloud_encodeUrl");
            }
            if (jSONObject.has("file_color_note_cloud_")) {
                weiYunFileInfo.I = jSONObject.getString("file_color_note_cloud_");
            }
            if (jSONObject.has("file_color_note_cloud_")) {
                weiYunFileInfo.J = jSONObject.getString("file_color_note_cloud_");
            }
            dc1.h hVar = new dc1.h(a16, context, weiYunFileInfo);
            hVar.m(D);
            dc1.d dVar = new dc1.d(context, hVar);
            dVar.m(14);
            dVar.s(268435456);
            dVar.d();
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void c(Context context, ColorNote colorNote) {
        QQAppInterface a16 = a();
        if (a16 == null) {
            return;
        }
        try {
            long j3 = new JSONObject(new String(colorNote.getReserve())).getLong("file_color_note_uniSeq");
            DataLineMsgRecord d16 = a16.getMessageFacade().t1(DataLineMsgRecord.getDevTypeBySeId(j3)).d(j3);
            if (d16 != null) {
                dc1.d dVar = new dc1.d(context, new dc1.c(a16, context, FileManagerUtil.newEntityByDataLineFileInfo(d16)));
                dVar.m(14);
                dVar.s(268435456);
                dVar.d();
                return;
            }
            g(context, 1);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void d(Context context, ColorNote colorNote) {
        QQAppInterface a16 = a();
        if (a16 == null) {
            return;
        }
        try {
            String string = new JSONObject(new String(colorNote.getReserve())).getString("file_color_note_local_path");
            if (!FileUtils.fileExistsAndNotEmpty(string)) {
                g(context, 1);
                return;
            }
            int W = QFileUtils.W(colorNote.getSubType());
            FileInfo b16 = FileInfo.b(string);
            if (b16 == null) {
                g(context, 1);
                return;
            }
            dc1.b bVar = new dc1.b(a16, context, FileManagerUtil.newEntityByLocalFileInfo(b16), 10000);
            Bundle bundle = new Bundle();
            bundle.putInt("file_color_note_subType", W);
            bVar.x(bundle);
            dc1.d dVar = new dc1.d(context, bVar);
            dVar.m(14);
            dVar.s(268435456);
            dVar.d();
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void e(Context context, ColorNote colorNote) {
        QQAppInterface a16 = a();
        if (a16 == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(colorNote.getReserve()));
            long j3 = jSONObject.getLong("file_color_note_uniSeq");
            long j16 = jSONObject.getLong("file_color_note_sessionId");
            int i3 = jSONObject.getInt("file_color_note_peerType");
            FileManagerEntity C = a16.getFileManagerDataCenter().C(j3, jSONObject.getString("file_color_note_peerUin"), i3, j16);
            if (C == null) {
                g(context, 1);
                return;
            }
            dc1.b bVar = new dc1.b(a16, context, C, 10001);
            Bundle bundle = new Bundle();
            bundle.putBoolean("from_qlink_enter_recent", false);
            bVar.x(bundle);
            dc1.d dVar = new dc1.d(context, bVar);
            dVar.m(14);
            dVar.s(268435456);
            dVar.d();
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void f(Context context, ColorNote colorNote) {
        QQAppInterface a16 = a();
        if (a16 == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(colorNote.getReserve()));
            jSONObject.getInt("file_color_note_peerType");
            long j3 = jSONObject.getLong("file_color_note_peerUin");
            t k3 = TroopFileUtils.k(a16, j3, jSONObject.getString("file_color_note_file_uuid"), jSONObject.getString("file_color_note_file_url"), jSONObject.getString("file_color_note_fileName"), jSONObject.getLong("file_color_note_fileSize"), jSONObject.getInt("file_color_note_busId"));
            if (k3 == null) {
                g(context, 1);
                return;
            }
            if (k3.f294972f == 12) {
                g(context, 1);
                return;
            }
            dc1.d dVar = new dc1.d(context, new dc1.g(a16, context, j3, k3, -1));
            dVar.m(14);
            dVar.n(TroopFileDetailBrowserActivity.class);
            dVar.l(true);
            dVar.s(268435456);
            dVar.d();
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    private void g(Context context, int i3) {
        String str;
        if (i3 == 1) {
            str = context.getString(R.string.ip8);
        } else {
            str = "";
        }
        QQToast.makeText(context, 0, str, 0).show();
    }

    @Override // fa1.b
    public int getType() {
        return 17039360;
    }

    @Override // fa1.b
    public void launch(Context context, ColorNote colorNote) {
        if (colorNote.getServiceType() != 17039360) {
            return;
        }
        if (TextUtils.isEmpty(colorNote.getSubType())) {
            QLog.i("QFileColorNoteLauncher", 1, "launch: subType is null.");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("QFileColorNoteLauncher", 2, "launch: subKey[" + colorNote.getSubType() + "]");
        }
        int W = QFileUtils.W(colorNote.getSubType());
        if (W == -1) {
            QLog.i("QFileColorNoteLauncher", 1, "launch: subType is unknown.");
            return;
        }
        if (colorNote.getReserve() == null) {
            return;
        }
        switch (W) {
            case 1:
                e(context, colorNote);
                return;
            case 2:
                f(context, colorNote);
                return;
            case 3:
                b(context, colorNote);
                return;
            case 4:
                d(context, colorNote);
                return;
            case 5:
                d(context, colorNote);
                return;
            case 6:
                c(context, colorNote);
                return;
            default:
                return;
        }
    }

    @Override // fa1.b
    public void onCreate(Context context, ColorNote colorNote, Bundle bundle) {
    }
}
