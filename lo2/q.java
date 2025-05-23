package lo2;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.UfsResultItem;
import feedcloud.FeedCloudMeta$StUser;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleBase$StUserBusiData;

/* compiled from: P */
/* loaded from: classes18.dex */
public class q extends p {

    /* renamed from: b0, reason: collision with root package name */
    private FeedCloudMeta$StUser f415250b0;

    /* renamed from: c0, reason: collision with root package name */
    private QQCircleBase$StUserBusiData f415251c0;

    public q(String str, long j3, List<String> list, UfsResultItem ufsResultItem, int i3) {
        super(str, j3, list, ufsResultItem, i3);
        b0(ufsResultItem);
    }

    @Override // lo2.m
    public boolean N() {
        FeedCloudMeta$StUser feedCloudMeta$StUser = this.f415250b0;
        if (feedCloudMeta$StUser != null && !TextUtils.isEmpty(feedCloudMeta$StUser.nick.get())) {
            return true;
        }
        return false;
    }

    @Override // lo2.p
    /* renamed from: X */
    public String getCover() {
        FeedCloudMeta$StUser feedCloudMeta$StUser = this.f415250b0;
        if (feedCloudMeta$StUser == null) {
            return null;
        }
        return feedCloudMeta$StUser.icon.iconUrl.get();
    }

    @Override // lo2.p
    public List<String> Y() {
        int i3;
        QQCircleBase$StUserBusiData qQCircleBase$StUserBusiData = this.f415251c0;
        if (qQCircleBase$StUserBusiData == null || (i3 = qQCircleBase$StUserBusiData.certification.get()) == 0) {
            return null;
        }
        String c16 = com.tencent.biz.qqcircle.immersive.utils.p.c(i3);
        if (TextUtils.isEmpty(c16)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(c16);
        return arrayList;
    }

    protected void b0(UfsResultItem ufsResultItem) {
        byte[] bArr = ufsResultItem.layoutContent;
        if (bArr != null && bArr.length > 0) {
            FeedCloudMeta$StUser feedCloudMeta$StUser = new FeedCloudMeta$StUser();
            this.f415250b0 = feedCloudMeta$StUser;
            try {
                feedCloudMeta$StUser.mergeFrom(bArr);
                QQCircleBase$StUserBusiData qQCircleBase$StUserBusiData = new QQCircleBase$StUserBusiData();
                this.f415251c0 = qQCircleBase$StUserBusiData;
                try {
                    qQCircleBase$StUserBusiData.mergeFrom(this.f415250b0.busiData.get().toByteArray());
                } catch (InvalidProtocolBufferMicroException e16) {
                    QLog.w(m.f415228a0, 1, "#parseData", e16);
                }
            } catch (InvalidProtocolBufferMicroException e17) {
                QLog.w(m.f415228a0, 1, "#parseData", e17);
            }
        }
    }

    @Override // lo2.m, com.tencent.mobileqq.search.model.y
    /* renamed from: t */
    public CharSequence getSubTitleSpans() {
        QQCircleBase$StUserBusiData qQCircleBase$StUserBusiData = this.f415251c0;
        if (qQCircleBase$StUserBusiData == null) {
            return "";
        }
        return "\u7c89\u4e1d " + com.tencent.biz.qqcircle.immersive.utils.r.f(qQCircleBase$StUserBusiData.fansNum.get()) + " \u4f5c\u54c1 " + com.tencent.biz.qqcircle.immersive.utils.r.f(this.f415251c0.feedNum.get());
    }

    public String toString() {
        return "NetSearchTemplateFollowedCircleUserItem{id='" + this.f415250b0.f398463id + "', nick='" + this.f415250b0.nick + "', groupMask=" + this.J + ", keyword='" + this.N + "', source=" + this.C + "} " + super.toString();
    }

    @Override // lo2.m, com.tencent.mobileqq.search.model.y
    /* renamed from: u */
    public CharSequence getTitleSpans() {
        FeedCloudMeta$StUser feedCloudMeta$StUser = this.f415250b0;
        if (feedCloudMeta$StUser == null) {
            return "";
        }
        return feedCloudMeta$StUser.nick.get();
    }

    @Override // lo2.m, com.tencent.mobileqq.search.model.y
    public void v(View view) {
        if (this.f415250b0 == null) {
            return;
        }
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        qCircleInitBean.setUser(this.f415250b0);
        com.tencent.biz.qqcircle.launcher.c.d0(view.getContext(), qCircleInitBean);
    }
}
