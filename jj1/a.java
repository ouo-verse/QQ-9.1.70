package jj1;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.richframework.data.idata.IDataConverter;
import com.tencent.richframework.data.idata.IDataWeakSupport;

/* compiled from: P */
/* loaded from: classes13.dex */
public class a implements IDataConverter<GProStFeed>, IDataWeakSupport {
    private void d(GProStFeed gProStFeed, GProStFeed gProStFeed2) {
        if (gProStFeed != null && gProStFeed2 != null) {
            gProStFeed.totalLike = gProStFeed2.totalLike;
            gProStFeed.commentCount = gProStFeed2.commentCount;
            gProStFeed.share = gProStFeed2.share;
            gProStFeed.totalPrefer = gProStFeed2.totalPrefer;
            gProStFeed.vecCommentList = gProStFeed2.vecCommentList;
        }
    }

    @Override // com.tencent.richframework.data.idata.IDataConverter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public GProStFeed cloneConvertData(GProStFeed gProStFeed) {
        if (isSupportWeakData()) {
            return gProStFeed;
        }
        GProStFeed gProStFeed2 = new GProStFeed();
        gProStFeed2.idd = gProStFeed.idd;
        update(gProStFeed2, gProStFeed);
        return gProStFeed2;
    }

    @Override // com.tencent.richframework.data.idata.IDataConverter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String getObserverKey(GProStFeed gProStFeed) {
        return gProStFeed.idd;
    }

    @Override // com.tencent.richframework.data.idata.IDataConverter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(GProStFeed gProStFeed, GProStFeed gProStFeed2) {
        d(gProStFeed, gProStFeed2);
    }

    @Override // com.tencent.richframework.data.idata.IDataWeakSupport
    public boolean isSupportWeakData() {
        return true;
    }
}
