package cooperation.qqcircle.beans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleSchemeBean implements Serializable {
    private static final long serialVersionUID = 322069543369932762L;
    private String mAction;
    private HashMap<String, String> mAttrs;
    private HashMap<String, byte[]> mByteAttrs;
    private long mEnterTime;
    private List<String> mSourceIds;

    public HashMap<String, String> getAttrs() {
        return this.mAttrs;
    }

    public HashMap<String, byte[]> getByteAttrs() {
        return this.mByteAttrs;
    }

    public long getEnterTime() {
        return this.mEnterTime;
    }

    public String getSchemeAction() {
        return this.mAction;
    }

    public List<String> getSourceIds() {
        return this.mSourceIds;
    }

    public QCircleSchemeBean setAttrs(HashMap<String, String> hashMap) {
        this.mAttrs = hashMap;
        return this;
    }

    public QCircleSchemeBean setByteAttrs(HashMap<String, byte[]> hashMap) {
        this.mByteAttrs = hashMap;
        return this;
    }

    public void setEnterTime(long j3) {
        this.mEnterTime = j3;
    }

    public QCircleSchemeBean setSchemeAction(String str) {
        this.mAction = str;
        return this;
    }

    public QCircleSchemeBean setSourceIds(List<String> list) {
        this.mSourceIds = list;
        return this;
    }
}
