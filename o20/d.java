package o20;

import com.tencent.biz.qcircleshadow.lib.variation.HostSelectMemberUtils;
import com.tencent.biz.qqcircle.comment.QFSCommentReportHelper;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.biz.richframework.util.RFWStringBuilderUtils;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StReply;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public boolean f421793a;

    /* renamed from: b, reason: collision with root package name */
    public List<HostSelectMemberUtils.QCircleResultData> f421794b;

    /* renamed from: c, reason: collision with root package name */
    public final Set<Boolean> f421795c = new HashSet();

    /* renamed from: d, reason: collision with root package name */
    public QCircleReportBean f421796d;

    /* renamed from: e, reason: collision with root package name */
    public FeedCloudMeta$StFeed f421797e;

    /* renamed from: f, reason: collision with root package name */
    public FeedCloudMeta$StComment f421798f;

    /* renamed from: g, reason: collision with root package name */
    public FeedCloudMeta$StReply f421799g;

    /* renamed from: h, reason: collision with root package name */
    public String f421800h;

    /* renamed from: i, reason: collision with root package name */
    public String f421801i;

    /* renamed from: j, reason: collision with root package name */
    public int f421802j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f421803k;

    public d(List<HostSelectMemberUtils.QCircleResultData> list, QCircleReportBean qCircleReportBean) {
        this.f421794b = list;
        this.f421796d = qCircleReportBean;
    }

    public String a() {
        QCircleReportBean qCircleReportBean = this.f421796d;
        if (qCircleReportBean == null) {
            return "";
        }
        return qCircleReportBean.getDtPageId();
    }

    public String b() {
        String str;
        if (RFSafeListUtils.isEmpty(this.f421794b)) {
            return "";
        }
        StringBuilder obtain = RFWStringBuilderUtils.obtain();
        if (this.f421795c.isEmpty()) {
            obtain.append("1");
        } else {
            Iterator<Boolean> it = this.f421795c.iterator();
            while (it.hasNext()) {
                if (!it.next().booleanValue()) {
                    str = "1";
                } else {
                    str = "2";
                }
                obtain.append(str);
            }
        }
        return obtain.toString();
    }

    public String c() {
        return QFSCommentReportHelper.r(this.f421794b);
    }

    public String d() {
        return QFSCommentReportHelper.q(this.f421793a);
    }
}
