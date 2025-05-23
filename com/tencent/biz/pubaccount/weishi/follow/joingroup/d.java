package com.tencent.biz.pubaccount.weishi.follow.joingroup;

import UserGrowth.stFeed;
import UserGrowth.stQQGroupInfo;
import UserGrowth.stSimpleMetaFeed;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.holder.WSFollowFeedHolder;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.view.RoundImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class d extends com.tencent.biz.pubaccount.weishi.baseui.b {
    private static final int H = ViewUtils.dpToPx(1.0f);
    private static final int I = ViewUtils.dpToPx(14.0f);
    private RelativeLayout C;
    private RoundImageView D;
    private TextView E;
    private WSFollowFeedHolder F;
    private Activity G;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (bb.E()) {
                return;
            }
            d.this.w();
        }
    }

    public d(Context context, WSFollowFeedHolder wSFollowFeedHolder) {
        super(context);
        this.G = null;
        if (context instanceof Activity) {
            this.G = (Activity) context;
        }
        this.F = wSFollowFeedHolder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        WSFollowFeedHolder wSFollowFeedHolder;
        if (this.G == null || (wSFollowFeedHolder = this.F) == null) {
            return;
        }
        wSFollowFeedHolder.s0();
        BottomDialog bottomDialog = new BottomDialog(this.G);
        GroupDlgView groupDlgView = new GroupDlgView(this.G, this.F);
        bottomDialog.setContentView(groupDlgView);
        groupDlgView.a(v(this.F.L()));
        bottomDialog.show();
        this.F.u0();
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.fx_;
    }

    public List<b> v(stFeed stfeed) {
        stSimpleMetaFeed stsimplemetafeed;
        ArrayList<stQQGroupInfo> arrayList;
        ArrayList arrayList2 = new ArrayList();
        if (stfeed != null && (stsimplemetafeed = stfeed.feed) != null && (arrayList = stsimplemetafeed.qqGroups) != null && arrayList.size() > 0) {
            for (int i3 = 0; i3 < stfeed.feed.qqGroups.size(); i3++) {
                stQQGroupInfo stqqgroupinfo = stfeed.feed.qqGroups.get(i3);
                arrayList2.add(new b(stqqgroupinfo.groupAvatar, stqqgroupinfo.groupName, stqqgroupinfo.groupCode, stqqgroupinfo.groupAuth));
            }
        }
        return arrayList2;
    }

    public void x() {
        stSimpleMetaFeed stsimplemetafeed;
        ArrayList<stQQGroupInfo> arrayList;
        stFeed L = this.F.L();
        Activity activity = this.G;
        if (activity == null || activity.isFinishing() || L == null || (stsimplemetafeed = L.feed) == null || (arrayList = stsimplemetafeed.qqGroups) == null || arrayList.size() <= 0) {
            return;
        }
        WSPicLoader.g().j(this.G, this.D, L.feed.qqGroups.get(0).groupAvatar);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected void s() {
        this.C = (RelativeLayout) p(R.id.xup);
        this.D = (RoundImageView) p(R.id.xun);
        this.E = (TextView) p(R.id.xuo);
        Drawable drawable = e().getDrawable(R.drawable.ol8);
        int i3 = I;
        drawable.setBounds(new Rect(0, 0, i3, i3));
        this.E.setCompoundDrawablePadding(H);
        this.E.setCompoundDrawables(null, null, drawable, null);
        this.C.setOnClickListener(new a());
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void g() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void h() {
    }
}
