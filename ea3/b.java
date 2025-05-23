package ea3;

import androidx.room.TypeConverter;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes21.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final Gson f396033a = new GsonBuilder().setExclusionStrategies(new C10226b()).create();

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a extends TypeToken<Map<String, LocalMediaInfo>> {
        a() {
        }
    }

    /* compiled from: P */
    /* renamed from: ea3.b$b, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    private static class C10226b implements ExclusionStrategy {
        C10226b() {
        }

        @Override // com.google.gson.ExclusionStrategy
        public boolean shouldSkipClass(Class<?> cls) {
            return Serializable.class.equals(cls);
        }

        @Override // com.google.gson.ExclusionStrategy
        public boolean shouldSkipField(FieldAttributes fieldAttributes) {
            return false;
        }
    }

    @TypeConverter
    public String a(Map<String, LocalMediaInfo> map) {
        try {
            return this.f396033a.toJson(map);
        } catch (Exception e16) {
            QLog.e("LocalMediaInfoMapTypeConverter", 1, "convert, error data: " + map, e16);
            return null;
        }
    }

    @TypeConverter
    public Map<String, LocalMediaInfo> b(String str) {
        try {
            return (Map) this.f396033a.fromJson(str, new a().getType());
        } catch (Exception e16) {
            QLog.e("LocalMediaInfoMapTypeConverter", 1, "revert, error str: " + str, e16);
            return new HashMap();
        }
    }
}
