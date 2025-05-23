package QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class RespGetDiscuss extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static ArrayList<DiscussInfo> cache_DiscussList;
    static ArrayList<DiscussInfo> cache_FavoriteDiscussList;
    public ArrayList<DiscussInfo> DiscussList;
    public ArrayList<DiscussInfo> FavoriteDiscussList;

    public RespGetDiscuss() {
        this.DiscussList = null;
        this.FavoriteDiscussList = null;
    }

    public String className() {
        return "QQService.RespGetDiscuss";
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void display(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.display((Collection) this.DiscussList, "DiscussList");
        jceDisplayer.display((Collection) this.FavoriteDiscussList, "FavoriteDiscussList");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder sb5, int i3) {
        JceDisplayer jceDisplayer = new JceDisplayer(sb5, i3);
        jceDisplayer.displaySimple((Collection) this.DiscussList, true);
        jceDisplayer.displaySimple((Collection) this.FavoriteDiscussList, false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        RespGetDiscuss respGetDiscuss = (RespGetDiscuss) obj;
        if (!JceUtil.equals(this.DiscussList, respGetDiscuss.DiscussList) || !JceUtil.equals(this.FavoriteDiscussList, respGetDiscuss.FavoriteDiscussList)) {
            return false;
        }
        return true;
    }

    public String fullClassName() {
        return "QQService.RespGetDiscuss";
    }

    public ArrayList<DiscussInfo> getDiscussList() {
        return this.DiscussList;
    }

    public int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (cache_DiscussList == null) {
            cache_DiscussList = new ArrayList<>();
            cache_DiscussList.add(new DiscussInfo());
        }
        this.DiscussList = (ArrayList) jceInputStream.read((JceInputStream) cache_DiscussList, 0, true);
        if (cache_FavoriteDiscussList == null) {
            cache_FavoriteDiscussList = new ArrayList<>();
            cache_FavoriteDiscussList.add(new DiscussInfo());
        }
        this.FavoriteDiscussList = (ArrayList) jceInputStream.read((JceInputStream) cache_FavoriteDiscussList, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.DiscussList, 0);
        ArrayList<DiscussInfo> arrayList = this.FavoriteDiscussList;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
    }

    public RespGetDiscuss(ArrayList<DiscussInfo> arrayList, ArrayList<DiscussInfo> arrayList2) {
        this.DiscussList = arrayList;
        this.FavoriteDiscussList = arrayList2;
    }
}
