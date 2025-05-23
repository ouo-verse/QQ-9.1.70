package cooperation.qqcircle.beans;

import com.tencent.mobileqq.persistence.Entity;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes28.dex */
public class Friend extends Entity implements Cloneable, Serializable {
    public String mName;
    public long mUin;

    public Friend(long j3, String str) {
        this.mUin = j3;
        this.mName = str;
    }

    public Friend() {
        this.mUin = -1L;
        this.mName = "";
    }
}
