package com.tencent.biz.subscribe.widget;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.d;
import com.tencent.biz.subscribe.widget.textview.FollowTextView;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SubscribeFollowInfoView extends BaseWidgetView<CertifiedAccountMeta$StFeed> {
    private SquareImageView E;
    private TextView F;
    private FollowTextView G;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CertifiedAccountMeta$StFeed f96411d;

        a(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
            this.f96411d = certifiedAccountMeta$StFeed;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (SubscribeFollowInfoView.this.f() != null || !SubscribeFollowInfoView.this.t()) {
                VSReporter.n(this.f96411d.poster.f24929id.get(), "auth_" + SubscribeShareHelper.s(SubscribeFollowInfoView.this.g()), "clk_name", 0, 0, new String[0]);
                d.t(SubscribeFollowInfoView.this.h(), SubscribeFollowInfoView.this.f().poster);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public SubscribeFollowInfoView(@NonNull Context context) {
        super(context);
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected int i() {
        return R.layout.c6x;
    }

    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    protected void p(Context context, View view) {
        this.E = (SquareImageView) view.findViewById(R.id.ln7);
        this.F = (TextView) view.findViewById(R.id.mbu);
        this.G = (FollowTextView) view.findViewById(R.id.mcp);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.subscribe.baseUI.BaseWidgetView
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void c(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        a aVar = new a(certifiedAccountMeta$StFeed);
        SquareImageView squareImageView = this.E;
        if (squareImageView != null) {
            squareImageView.getLayoutParams().width = ScreenUtil.dip2px(27.0f);
            this.E.getLayoutParams().height = ScreenUtil.dip2px(27.0f);
            com.tencent.biz.subscribe.a.e(certifiedAccountMeta$StFeed.poster.icon.get(), this.E);
            this.E.setOnClickListener(aVar);
        }
        TextView textView = this.F;
        if (textView != null) {
            textView.setText(certifiedAccountMeta$StFeed.poster.nick.get());
            this.F.setOnClickListener(aVar);
        }
        if (this.G != null) {
            if (SubscribeUtils.o(certifiedAccountMeta$StFeed.poster.attr.get())) {
                this.G.setVisibility(8);
                return;
            }
            this.G.setVisibility(0);
            this.G.setFeedData(certifiedAccountMeta$StFeed);
            this.G.setExtraTypeInfo(g());
        }
    }

    protected boolean t() {
        if (f() != null && StringUtil.isEmpty(f().poster.nick.get())) {
            return true;
        }
        return false;
    }

    public void u(CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed) {
        if (certifiedAccountMeta$StFeed != null) {
            SquareImageView squareImageView = this.E;
            if (squareImageView != null) {
                squareImageView.getLayoutParams().width = ScreenUtil.dip2px(27.0f);
                this.E.getLayoutParams().height = ScreenUtil.dip2px(27.0f);
                com.tencent.biz.subscribe.a.e(certifiedAccountMeta$StFeed.poster.icon.get(), this.E);
            }
            TextView textView = this.F;
            if (textView != null) {
                textView.setText(certifiedAccountMeta$StFeed.poster.nick.get());
            }
        }
    }

    public SubscribeFollowInfoView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
