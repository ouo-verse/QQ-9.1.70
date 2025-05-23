package NS_QMALL_COVER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QzmallFeedAvatar extends JceStruct {
    static int cache_eAvatarType;
    public int eAvatarType;
    public int iItemId;
    public String strAvatarJumpUrl;
    public String strAvatarUrl;

    public QzmallFeedAvatar() {
        this.iItemId = -1;
        this.strAvatarUrl = "";
        this.strAvatarJumpUrl = "";
        this.eAvatarType = 1;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.iItemId = jceInputStream.read(this.iItemId, 0, true);
        this.strAvatarUrl = jceInputStream.readString(1, false);
        this.strAvatarJumpUrl = jceInputStream.readString(2, false);
        this.eAvatarType = jceInputStream.read(this.eAvatarType, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.iItemId, 0);
        String str = this.strAvatarUrl;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
        String str2 = this.strAvatarJumpUrl;
        if (str2 != null) {
            jceOutputStream.write(str2, 2);
        }
        jceOutputStream.write(this.eAvatarType, 3);
    }

    public QzmallFeedAvatar(int i3, String str, String str2, int i16) {
        this.iItemId = i3;
        this.strAvatarUrl = str;
        this.strAvatarJumpUrl = str2;
        this.eAvatarType = i16;
    }
}
