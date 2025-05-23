package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.util.Size;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import feedcloud.FeedCloudMeta$StUser;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleBlackListItemView extends QCircleBaseWidgetView<FeedCloudMeta$StUser> {

    /* renamed from: d, reason: collision with root package name */
    private QCircleAvatarView f92936d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f92937e;

    /* renamed from: f, reason: collision with root package name */
    private QCircleAddBlackListView f92938f;

    /* renamed from: h, reason: collision with root package name */
    private FeedCloudMeta$StUser f92939h;

    /* renamed from: i, reason: collision with root package name */
    private FormItemRelativeLayout f92940i;

    /* renamed from: m, reason: collision with root package name */
    private Size f92941m;

    public QCircleBlackListItemView(Context context) {
        super(context);
        l0(this);
    }

    private void l0(View view) {
        this.f92936d = (QCircleAvatarView) view.findViewById(R.id.f30730p5);
        this.f92937e = (TextView) view.findViewById(R.id.f30740p6);
        this.f92938f = (QCircleAddBlackListView) view.findViewById(R.id.f30720p4);
        this.f92940i = (FormItemRelativeLayout) view.findViewById(R.id.f75693zn);
        this.f92941m = com.tencent.biz.qqcircle.immersive.utils.n.a(view.getContext(), R.dimen.f159392d03);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g2c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "QCircleBlackListItemView";
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void bindData(FeedCloudMeta$StUser feedCloudMeta$StUser, int i3) {
        if (feedCloudMeta$StUser == null) {
            return;
        }
        this.f92939h = feedCloudMeta$StUser;
        this.f92936d.setUser(feedCloudMeta$StUser, this.f92941m);
        this.f92937e.setText(feedCloudMeta$StUser.nick.get());
        this.f92938f.setUserData(feedCloudMeta$StUser);
    }

    public void setItemBGType(int i3) {
        this.f92940i.setBGType(i3);
    }
}
