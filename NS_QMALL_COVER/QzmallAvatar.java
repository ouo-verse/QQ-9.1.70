package NS_QMALL_COVER;

import NS_MOBILE_CUSTOM.AvatarItem;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QzmallAvatar extends JceStruct {
    static AvatarItem cache_stAvatarItem = new AvatarItem();
    public AvatarItem stAvatarItem;

    public QzmallAvatar() {
        this.stAvatarItem = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.stAvatarItem = (AvatarItem) jceInputStream.read((JceStruct) cache_stAvatarItem, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        AvatarItem avatarItem = this.stAvatarItem;
        if (avatarItem != null) {
            jceOutputStream.write((JceStruct) avatarItem, 0);
        }
    }

    public QzmallAvatar(AvatarItem avatarItem) {
        this.stAvatarItem = avatarItem;
    }
}
