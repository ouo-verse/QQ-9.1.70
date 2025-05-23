package UserGrowth;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* compiled from: P */
/* loaded from: classes.dex */
public final class stArkMeta extends JceStruct {
    static stNews cache_news = new stNews();
    public stNews news = null;

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.news = (stNews) jceInputStream.read((JceStruct) cache_news, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        stNews stnews = this.news;
        if (stnews != null) {
            jceOutputStream.write((JceStruct) stnews, 0);
        }
    }
}
