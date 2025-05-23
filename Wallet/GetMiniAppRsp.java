package Wallet;

import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes.dex */
public final class GetMiniAppRsp extends JceStruct {
    public static final int RES_FAIL = -1;
    public static final int RES_SUCC = 0;
    static ArrayList<ApkgConfig> cache_apkg_config_list = new ArrayList<>();
    public int err_code = 0;
    public int action = 0;
    public ArrayList<ApkgConfig> apkg_config_list = null;
    public String extra = "";

    static {
        cache_apkg_config_list.add(new ApkgConfig());
    }

    public String getErrTips() {
        if (!TextUtils.isEmpty(this.extra)) {
            try {
                return new JSONObject(this.extra).getString("err_tips");
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    public boolean isRemoveLocalConfig() {
        if (!TextUtils.isEmpty(this.extra)) {
            try {
                return new JSONObject(this.extra).optBoolean("is_remove_local_config");
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.err_code = jceInputStream.read(this.err_code, 0, false);
        this.action = jceInputStream.read(this.action, 1, false);
        this.apkg_config_list = (ArrayList) jceInputStream.read((JceInputStream) cache_apkg_config_list, 2, false);
        this.extra = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public String toString() {
        return "GetMiniAppRsp{err_code=" + this.err_code + ", action=" + this.action + ", apkg_config_list=" + this.apkg_config_list + ", extra='" + this.extra + "'}";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.err_code, 0);
        jceOutputStream.write(this.action, 1);
        ArrayList<ApkgConfig> arrayList = this.apkg_config_list;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        String str = this.extra;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
    }
}
