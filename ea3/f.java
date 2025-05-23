package ea3;

import androidx.room.TypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes21.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final Gson f396037a = new Gson();

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a extends TypeToken<HashMap<String, String>> {
        a() {
        }
    }

    @TypeConverter
    public String a(HashMap<String, String> hashMap) {
        try {
            return this.f396037a.toJson(hashMap);
        } catch (Exception e16) {
            QLog.e("StringMapTypeConverter", 1, "convert, error map: " + hashMap, e16);
            return null;
        }
    }

    @TypeConverter
    public HashMap<String, String> b(String str) {
        try {
            return (HashMap) this.f396037a.fromJson(str, new a().getType());
        } catch (Exception e16) {
            QLog.e("StringMapTypeConverter", 1, "revert, error str: " + str, e16);
            return null;
        }
    }
}
