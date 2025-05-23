package NS_MOBILE_AD_BANNER;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QueryADBannerRsp extends JceStruct {
    private static volatile boolean cacheInited = false;
    static volatile ArrayList<QueryADBannerUnit> cache_vecAdBanner;
    public ArrayList<QueryADBannerUnit> vecAdBanner;

    public QueryADBannerRsp() {
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (!cacheInited) {
            synchronized (QueryADBannerRsp.class) {
                if (!cacheInited) {
                    cache_vecAdBanner = new ArrayList<>();
                    cache_vecAdBanner.add(new QueryADBannerUnit());
                    cacheInited = true;
                }
            }
        }
        this.vecAdBanner = (ArrayList) jceInputStream.read((JceInputStream) cache_vecAdBanner, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((Collection) this.vecAdBanner, 0);
    }

    public QueryADBannerRsp(ArrayList<QueryADBannerUnit> arrayList) {
        this.vecAdBanner = arrayList;
    }
}
