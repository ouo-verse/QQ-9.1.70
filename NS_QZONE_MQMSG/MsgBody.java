package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class MsgBody extends JceStruct {
    static ArrayList<PhotoCell> cache_vecPhotos = new ArrayList<>();
    static ArrayList<String> cache_vecUserAvatar;
    public String content;
    public String contentIcon;
    public String coverPicUrl;
    public int mediaType;
    public String title;
    public ArrayList<PhotoCell> vecPhotos;
    public ArrayList<String> vecUserAvatar;

    static {
        cache_vecPhotos.add(new PhotoCell());
        ArrayList<String> arrayList = new ArrayList<>();
        cache_vecUserAvatar = arrayList;
        arrayList.add("");
    }

    public MsgBody() {
        this.mediaType = 0;
        this.title = "";
        this.content = "";
        this.vecPhotos = null;
        this.vecUserAvatar = null;
        this.coverPicUrl = "";
        this.contentIcon = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.mediaType = jceInputStream.read(this.mediaType, 0, false);
        this.title = jceInputStream.readString(1, false);
        this.content = jceInputStream.readString(2, false);
        this.vecPhotos = (ArrayList) jceInputStream.read((JceInputStream) cache_vecPhotos, 3, false);
        this.vecUserAvatar = (ArrayList) jceInputStream.read((JceInputStream) cache_vecUserAvatar, 4, false);
        this.coverPicUrl = jceInputStream.readString(5, false);
        this.contentIcon = jceInputStream.readString(6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.mediaType, 0);
        String str = this.title;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.content;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        ArrayList<PhotoCell> arrayList = this.vecPhotos;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        ArrayList<String> arrayList2 = this.vecUserAvatar;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 4);
        }
        String str3 = this.coverPicUrl;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
        String str4 = this.contentIcon;
        if (str4 != null) {
            jceOutputStream.write(str4, 6);
        }
    }

    public MsgBody(int i3, String str, String str2, ArrayList<PhotoCell> arrayList, ArrayList<String> arrayList2, String str3, String str4) {
        this.mediaType = i3;
        this.title = str;
        this.content = str2;
        this.vecPhotos = arrayList;
        this.vecUserAvatar = arrayList2;
        this.coverPicUrl = str3;
        this.contentIcon = str4;
    }
}
