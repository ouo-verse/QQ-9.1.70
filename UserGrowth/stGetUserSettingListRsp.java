package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stGetUserSettingListRsp extends JceStruct {
    static ArrayList<stNewUserSettingItem> cache_data = new ArrayList<>();
    public int code;
    public ArrayList<stNewUserSettingItem> data;

    /* renamed from: msg, reason: collision with root package name */
    public String f25119msg;

    static {
        cache_data.add(new stNewUserSettingItem());
    }

    public stGetUserSettingListRsp() {
        this.code = 0;
        this.f25119msg = "";
        this.data = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.code = jceInputStream.read(this.code, 0, false);
        this.f25119msg = jceInputStream.readString(1, false);
        this.data = (ArrayList) jceInputStream.read((JceInputStream) cache_data, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.code, 0);
        String str = this.f25119msg;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        ArrayList<stNewUserSettingItem> arrayList = this.data;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
    }

    public stGetUserSettingListRsp(int i3, String str, ArrayList<stNewUserSettingItem> arrayList) {
        this.code = i3;
        this.f25119msg = str;
        this.data = arrayList;
    }
}
