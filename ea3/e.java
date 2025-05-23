package ea3;

import androidx.room.TypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;

/* compiled from: P */
/* loaded from: classes21.dex */
public class e {

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a extends TypeToken<List<String>> {
        a() {
        }
    }

    @TypeConverter
    public String a(List<String> list) {
        return new Gson().toJson(list);
    }

    @TypeConverter
    public List<String> b(String str) {
        return (List) new Gson().fromJson(str, new a().getType());
    }
}
