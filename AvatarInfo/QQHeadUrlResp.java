package AvatarInfo;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QQHeadUrlResp extends JceStruct {
    static ArrayList<QQHeadInfo> cache_UserHeadInfoList;
    public ArrayList<QQHeadInfo> UserHeadInfoList;
    public long myUin;
    public int result;

    public QQHeadUrlResp() {
        this.myUin = 0L;
        this.result = 0;
        this.UserHeadInfoList = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.myUin = jceInputStream.read(this.myUin, 0, true);
        this.result = jceInputStream.read(this.result, 1, true);
        if (cache_UserHeadInfoList == null) {
            cache_UserHeadInfoList = new ArrayList<>();
            cache_UserHeadInfoList.add(new QQHeadInfo());
        }
        this.UserHeadInfoList = (ArrayList) jceInputStream.read((JceInputStream) cache_UserHeadInfoList, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.myUin, 0);
        jceOutputStream.write(this.result, 1);
        jceOutputStream.write((Collection) this.UserHeadInfoList, 2);
    }

    public QQHeadUrlResp(long j3, int i3, ArrayList<QQHeadInfo> arrayList) {
        this.myUin = j3;
        this.result = i3;
        this.UserHeadInfoList = arrayList;
    }
}
