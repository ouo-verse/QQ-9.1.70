package cooperation.qqcircle.beans;

import com.tencent.mobileqq.persistence.Entity;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes28.dex */
public class SingleUndealMsg extends Entity implements Serializable {
    public byte[] mBizBufferData;
    public int mType;

    public SingleUndealMsg() {
    }

    public SingleUndealMsg(int i3, byte[] bArr) {
        this.mType = i3;
        this.mBizBufferData = bArr;
    }
}
