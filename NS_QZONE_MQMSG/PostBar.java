package NS_QZONE_MQMSG;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class PostBar extends JceStruct {
    static PostBarBottom cache_bottom;
    static ArrayList<String> cache_userAvatar;
    static ArrayList<PhotoCell> cache_vecImage = new ArrayList<>();
    public PostBarBottom bottom;
    public String icon;
    public int leadType;
    public String summary;
    public String title;
    public ArrayList<String> userAvatar;
    public ArrayList<PhotoCell> vecImage;

    static {
        cache_vecImage.add(new PhotoCell());
        ArrayList<String> arrayList = new ArrayList<>();
        cache_userAvatar = arrayList;
        arrayList.add("");
        cache_bottom = new PostBarBottom();
    }

    public PostBar() {
        this.leadType = 0;
        this.vecImage = null;
        this.userAvatar = null;
        this.icon = "";
        this.title = "";
        this.summary = "";
        this.bottom = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.leadType = jceInputStream.read(this.leadType, 0, false);
        this.vecImage = (ArrayList) jceInputStream.read((JceInputStream) cache_vecImage, 1, false);
        this.userAvatar = (ArrayList) jceInputStream.read((JceInputStream) cache_userAvatar, 2, false);
        this.icon = jceInputStream.readString(3, false);
        this.title = jceInputStream.readString(4, false);
        this.summary = jceInputStream.readString(5, false);
        this.bottom = (PostBarBottom) jceInputStream.read((JceStruct) cache_bottom, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.leadType, 0);
        ArrayList<PhotoCell> arrayList = this.vecImage;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        ArrayList<String> arrayList2 = this.userAvatar;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 2);
        }
        String str = this.icon;
        if (str != null) {
            jceOutputStream.write(str, 3);
        }
        String str2 = this.title;
        if (str2 != null) {
            jceOutputStream.write(str2, 4);
        }
        String str3 = this.summary;
        if (str3 != null) {
            jceOutputStream.write(str3, 5);
        }
        PostBarBottom postBarBottom = this.bottom;
        if (postBarBottom != null) {
            jceOutputStream.write((JceStruct) postBarBottom, 6);
        }
    }

    public PostBar(int i3, ArrayList<PhotoCell> arrayList, ArrayList<String> arrayList2, String str, String str2, String str3, PostBarBottom postBarBottom) {
        this.leadType = i3;
        this.vecImage = arrayList;
        this.userAvatar = arrayList2;
        this.icon = str;
        this.title = str2;
        this.summary = str3;
        this.bottom = postBarBottom;
    }
}
