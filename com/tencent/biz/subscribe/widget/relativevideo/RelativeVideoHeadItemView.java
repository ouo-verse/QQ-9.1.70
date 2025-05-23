package com.tencent.biz.subscribe.widget.relativevideo;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.en;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RelativeVideoHeadItemView extends RelativeFeedBaseHeaderView {
    private TextView E;
    private TextView F;
    private TextView G;
    private AsyncRichTextView H;
    private TextView I;
    private View J;

    public RelativeVideoHeadItemView(Context context) {
        super(context);
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    public void c(Object obj) {
        int i3;
        int i16;
        if (obj == null) {
            return;
        }
        CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = (CertifiedAccountMeta$StFeed) obj;
        this.E.setText(certifiedAccountMeta$StFeed.title.get());
        TextView textView = this.E;
        if (certifiedAccountMeta$StFeed.title.get().trim().length() > 0) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        textView.setVisibility(i3);
        this.F.setText(en.t(getContext(), certifiedAccountMeta$StFeed.createTime.get() * 1000));
        int i17 = certifiedAccountMeta$StFeed.visitorInfo.get().view_count.get();
        if (i17 > 0) {
            this.G.setVisibility(0);
            this.G.setText(UIUtils.d(i17) + HardCodeUtil.qqStr(R.string.vso));
        } else {
            this.G.setVisibility(8);
        }
        AsyncRichTextView asyncRichTextView = this.H;
        if (certifiedAccountMeta$StFeed.content.get().trim().length() > 0) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        asyncRichTextView.setVisibility(i16);
        this.H.setText(certifiedAccountMeta$StFeed.content.get());
        if (!StringUtil.isEmpty(certifiedAccountMeta$StFeed.poiInfo.get().defaultName.get())) {
            this.J.setVisibility(0);
            this.I.setText(certifiedAccountMeta$StFeed.poiInfo.get().defaultName.get());
        } else {
            this.J.setVisibility(8);
        }
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    public int i() {
        return R.layout.c7c;
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    public void p(Context context, View view) {
        this.E = (TextView) findViewById(R.id.mck);
        this.F = (TextView) findViewById(R.id.mci);
        this.G = (TextView) findViewById(R.id.mcl);
        this.H = (AsyncRichTextView) findViewById(R.id.mcd);
        this.J = findViewById(R.id.lqu);
        this.I = (TextView) findViewById(R.id.mdl);
    }
}
