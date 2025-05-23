package cooperation.photoplus.sticker;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import cooperation.photoplus.PhotoPlusManager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.REPLACE, columnNames = "id")
/* loaded from: classes28.dex */
public class Sticker extends Entity {
    public static final String JSON_SUFFIX = ".json";
    public static final String PNG_SUFFIX = ".png";
    public static final String TAG = "Sticker";
    public static final String THUMB_SUFFIX = "_thumb";
    public static final int TYPE_BASIC = 0;
    public static final int TYPE_NORMAL = 1;

    /* renamed from: id, reason: collision with root package name */
    @unique
    public String f390165id;
    public String md5;
    public int priority;
    public int type;
    public String url;
    public int version;

    public Sticker() {
    }

    public static List<Sticker> parse(String str) throws JSONException {
        JSONArray jSONArray = ((JSONObject) new JSONTokener(str).nextValue()).getJSONArray("sticker_templates");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                arrayList.add(new Sticker(jSONObject.getString("id"), jSONObject.getInt("version"), jSONObject.getInt("priority"), jSONObject.getString("url"), jSONObject.getInt("type"), jSONObject.optString("md5")));
            } catch (JSONException unused) {
            }
        }
        return arrayList;
    }

    public String getImageFileName() {
        return this.f390165id + ".png";
    }

    public String getJsonFileName() {
        return this.f390165id + JSON_SUFFIX;
    }

    public String getThumbImageFileName() {
        return this.f390165id + THUMB_SUFFIX + ".png";
    }

    public String getUnzippedDir() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.f390165id);
        String str = File.separator;
        sb5.append(str);
        sb5.append(this.version);
        sb5.append(str);
        return sb5.toString();
    }

    public String getZipFilePath() {
        return this.f390165id + File.separator + this.version + ".zip";
    }

    public JSONObject toJsonObject() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.f390165id);
            StringBuilder sb5 = new StringBuilder();
            String str = PhotoPlusManager.C;
            sb5.append(str);
            sb5.append(getUnzippedDir());
            sb5.append(getThumbImageFileName());
            jSONObject.put("thumbPath", sb5.toString());
            jSONObject.put("path", str + getUnzippedDir() + getImageFileName());
            jSONObject.put("version", this.version);
            jSONObject.put("priority", this.priority);
            jSONObject.put("type", this.type);
            jSONObject.put("jsonPath", str + getUnzippedDir() + getJsonFileName());
            return jSONObject;
        } catch (JSONException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public String toString() {
        return String.format(Locale.CHINA, "sticker: id=%s, version=%d, priority=%d, url=%s, type=%d, md5=%s", this.f390165id, Integer.valueOf(this.version), Integer.valueOf(this.priority), this.url, Integer.valueOf(this.type), this.md5);
    }

    public Sticker(String str, int i3, int i16, String str2, int i17, String str3) {
        this.f390165id = str;
        this.version = i3;
        this.priority = i16;
        this.url = str2;
        this.type = i17;
        this.md5 = str3;
    }
}
