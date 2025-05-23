package ea3;

import androidx.room.TypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import cooperation.qzone.LbsDataV2;

/* compiled from: P */
/* loaded from: classes21.dex */
public class c {

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a extends TypeToken<LbsDataV2.PoiInfo> {
        a() {
        }
    }

    @TypeConverter
    public String a(LbsDataV2.PoiInfo poiInfo) {
        return new Gson().toJson(poiInfo);
    }

    @TypeConverter
    public LbsDataV2.PoiInfo b(String str) {
        return (LbsDataV2.PoiInfo) new Gson().fromJson(str, new a().getType());
    }
}
