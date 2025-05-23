package cooperation.qqcircle.relation.entitys;

import com.tencent.mobileqq.persistence.Entity;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleFriendEntity extends Entity implements Cloneable, Serializable {
    public int mAuthType;
    public int mGroupFlag;
    public String mGroupId;
    public String mGroupName;
    public String mName;
    public long mUin;

    public QCircleFriendEntity() {
        this.mUin = -1L;
        this.mName = "";
        this.mGroupName = "";
        this.mGroupFlag = 0;
        this.mAuthType = 0;
        this.mGroupId = "";
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int getAuthType() {
        return this.mAuthType;
    }

    public int getGroupFlag() {
        return this.mGroupFlag;
    }

    public String getGroupId() {
        return this.mGroupId;
    }

    public String getGroupName() {
        return this.mGroupName;
    }

    public String getName() {
        return this.mName;
    }

    public long getUin() {
        return this.mUin;
    }

    public void setAuthType(int i3) {
        this.mAuthType = i3;
    }

    public void setGroupFlag(int i3) {
        this.mGroupFlag = i3;
    }

    public void setGroupId(String str) {
        this.mGroupId = str;
    }

    public void setGroupName(String str) {
        this.mGroupName = str;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setUin(long j3) {
        this.mUin = j3;
    }

    public QCircleFriendEntity(long j3, String str, String str2) {
        this.mGroupFlag = 0;
        this.mAuthType = 0;
        this.mGroupId = "";
        this.mUin = j3;
        this.mName = str;
        this.mGroupName = str2;
    }
}
