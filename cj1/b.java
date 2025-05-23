package cj1;

import android.os.Bundle;
import com.tencent.biz.richframework.part.TagData;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.utils.RFWViewUtils;
import com.tencent.mobileqq.guild.feed.report.GuildReportBean;

/* compiled from: P */
/* loaded from: classes13.dex */
public abstract class b<E> extends MultiViewBlock<E> {

    /* renamed from: m, reason: collision with root package name */
    protected GuildReportBean f30995m;

    public b(Bundle bundle) {
        super(bundle);
    }

    private Object getViewTagData() {
        if (getParentRecyclerView() == null) {
            return null;
        }
        return RFWViewUtils.getClosestViewTagData(TagData.TAG_DATA_ID, this.mRecyclerView);
    }

    private GuildReportBean i0() {
        Object viewTagData = getViewTagData();
        if (!(viewTagData instanceof GuildReportBean)) {
            return null;
        }
        return (GuildReportBean) viewTagData;
    }

    protected abstract String getLogTag();

    /* JADX INFO: Access modifiers changed from: protected */
    public int getPageId() {
        return GuildReportBean.getPageId("GuildBaseMultiViewBlock", this.f30995m);
    }

    public GuildReportBean j0() {
        GuildReportBean i06 = i0();
        if (i06 != null) {
            this.f30995m = i06;
            return i06;
        }
        if (this.f30995m == null) {
            this.f30995m = new GuildReportBean();
        }
        return GuildReportBean.getReportBean(getLogTag(), this.f30995m);
    }
}
