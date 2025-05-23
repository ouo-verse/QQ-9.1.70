package NS_MOBILE_FEEDS;

import android.util.Log;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class cell_like extends JceStruct {
    static ArrayList<s_likeman> cache_likemans = new ArrayList<>();
    public int isliked;
    public ArrayList<s_likeman> likemans;
    public int num;
    public String txt;

    static {
        cache_likemans.add(new s_likeman());
    }

    public cell_like() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.num = jceInputStream.read(this.num, 0, false);
        this.isliked = jceInputStream.read(this.isliked, 1, false);
        this.likemans = (ArrayList) jceInputStream.read((JceInputStream) cache_likemans, 2, false);
        this.txt = jceInputStream.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.num, 0);
        jceOutputStream.write(this.isliked, 1);
        ArrayList<s_likeman> arrayList = this.likemans;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 2);
        }
        jceOutputStream.write(this.txt, 3);
    }

    public cell_like(int i3, int i16, ArrayList<s_likeman> arrayList, String str) {
        this.num = i3;
        this.isliked = i16;
        this.likemans = arrayList;
        this.txt = str;
        Log.d("dunphyji", "txt =" + str);
    }
}
