package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stRedDotRsp extends JceStruct {
    static ArrayList<stRedDotMenu> cache_menu;
    static stNewsRedDot cache_newsReddot;
    static ArrayList<stNotificationRedDot> cache_notificationReddot = new ArrayList<>();
    static int cache_reddotAction;
    static stSimpleMetaPerson cache_user;
    public ArrayList<stRedDotMenu> menu;
    public stNewsRedDot newsReddot;
    public ArrayList<stNotificationRedDot> notificationReddot;
    public int reddotAction;
    public stSimpleMetaPerson user;

    static {
        cache_notificationReddot.add(new stNotificationRedDot());
        cache_newsReddot = new stNewsRedDot();
        cache_user = new stSimpleMetaPerson();
        cache_menu = new ArrayList<>();
        cache_menu.add(new stRedDotMenu());
    }

    public stRedDotRsp() {
        this.reddotAction = 0;
        this.notificationReddot = null;
        this.newsReddot = null;
        this.user = null;
        this.menu = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.reddotAction = jceInputStream.read(this.reddotAction, 0, false);
        this.notificationReddot = (ArrayList) jceInputStream.read((JceInputStream) cache_notificationReddot, 1, false);
        this.newsReddot = (stNewsRedDot) jceInputStream.read((JceStruct) cache_newsReddot, 2, false);
        this.user = (stSimpleMetaPerson) jceInputStream.read((JceStruct) cache_user, 3, false);
        this.menu = (ArrayList) jceInputStream.read((JceInputStream) cache_menu, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.reddotAction, 0);
        ArrayList<stNotificationRedDot> arrayList = this.notificationReddot;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        stNewsRedDot stnewsreddot = this.newsReddot;
        if (stnewsreddot != null) {
            jceOutputStream.write((JceStruct) stnewsreddot, 2);
        }
        stSimpleMetaPerson stsimplemetaperson = this.user;
        if (stsimplemetaperson != null) {
            jceOutputStream.write((JceStruct) stsimplemetaperson, 3);
        }
        ArrayList<stRedDotMenu> arrayList2 = this.menu;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 4);
        }
    }

    public stRedDotRsp(int i3, ArrayList<stNotificationRedDot> arrayList, stNewsRedDot stnewsreddot, stSimpleMetaPerson stsimplemetaperson, ArrayList<stRedDotMenu> arrayList2) {
        this.reddotAction = i3;
        this.notificationReddot = arrayList;
        this.newsReddot = stnewsreddot;
        this.user = stsimplemetaperson;
        this.menu = arrayList2;
    }
}
