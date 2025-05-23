package ps3;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.freesia.IConfigData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.permission.PermissionItem;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a implements IConfigData {

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<PermissionItem> f427083d = new ArrayList<>();

    public static a a(String str) {
        a aVar = new a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("permissionItems")) {
                b(aVar, jSONObject.getJSONArray("permissionItems"));
            }
        } catch (Exception e16) {
            QLog.e("game.permission.PermissionBean", 1, e16, new Object[0]);
        }
        return aVar;
    }

    private static void b(a aVar, JSONArray jSONArray) {
        try {
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                PermissionItem permissionItem = new PermissionItem();
                permissionItem.mName = jSONObject.optString("name");
                permissionItem.mPermission = jSONObject.optString(QCircleDaTongConstant.ElementParamValue.PERMISSION);
                permissionItem.mReqTitle = jSONObject.optString("title");
                permissionItem.mReqDetail = jSONObject.optString("detail");
                aVar.f427083d.add(permissionItem);
            }
        } catch (Exception e16) {
            QLog.e("game.permission.PermissionBean", 1, e16, new Object[0]);
        }
    }

    private static String c(Context context, String str) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        String str2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(str)));
        } catch (Exception e16) {
            e = e16;
            bufferedReader = null;
        } catch (Throwable th5) {
            th = th5;
            p51.a.a(bufferedReader2);
            throw th;
        }
        try {
            try {
                StringBuilder sb5 = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb5.append(readLine);
                }
                str2 = sb5.toString();
            } catch (Throwable th6) {
                th = th6;
                bufferedReader2 = bufferedReader;
                p51.a.a(bufferedReader2);
                throw th;
            }
        } catch (Exception e17) {
            e = e17;
            QLog.e("game.permission.PermissionBean", 1, "readContentFromAsset exception.", e);
            p51.a.a(bufferedReader);
            return str2;
        }
        p51.a.a(bufferedReader);
        return str2;
    }

    public static a d(Context context) {
        String c16 = c(context, "mini_box_permissions_config.json");
        if (TextUtils.isEmpty(c16)) {
            QLog.w("game.permission.PermissionBean", 1, "readFromAsset: empty content");
            return null;
        }
        a aVar = new a();
        try {
            JSONArray optJSONArray = new JSONObject(c16).optJSONArray("permissionItems");
            if (optJSONArray != null) {
                b(aVar, optJSONArray);
            }
        } catch (JSONException e16) {
            QLog.e("game.permission.PermissionBean", 1, "readFromAsset: parse error", e16);
        }
        return aVar;
    }
}
