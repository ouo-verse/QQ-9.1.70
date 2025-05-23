package com.tencent.mobileqq.guild.feed.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.richframework.part.IStatusViewProvider;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedStatusView extends GuildBaseWidgetView implements IStatusViewProvider, View.OnClickListener {

    /* renamed from: d, reason: collision with root package name */
    private TextView f224209d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f224210e;

    /* renamed from: f, reason: collision with root package name */
    private a f224211f;

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public interface a {
        void refresh();
    }

    public GuildFeedStatusView(Context context) {
        super(context);
        m0(this);
    }

    private String k0(String str) {
        if (TextUtils.isEmpty(str)) {
            return HardCodeUtil.qqStr(R.string.f144060nr);
        }
        return str;
    }

    private void m0(View view) {
        this.f224209d = (TextView) view.findViewById(R.id.f165487w92);
        this.f224210e = (ImageView) view.findViewById(R.id.f165486w91);
        this.f224209d.setOnClickListener(this);
        this.f224209d.setOnClickListener(this);
    }

    private void n0() {
        this.f224209d.setVisibility(0);
        this.f224210e.setVisibility(0);
        ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).loadImageWithLoading("https://downv6.qq.com/innovate/guild/loading/guild_feed_error_icon.png", this.f224210e, com.tencent.mobileqq.urldrawable.b.f306350a);
    }

    @Override // com.tencent.mobileqq.guild.feed.widget.GuildBaseWidgetView, com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.enp;
    }

    public void l0() {
        this.f224209d.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        a aVar = this.f224211f;
        if (aVar != null) {
            aVar.refresh();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setRefreshListener(a aVar) {
        this.f224211f = aVar;
    }

    @Override // com.tencent.biz.richframework.part.IStatusViewProvider
    public void showEmptyView(String str) {
        this.f224209d.setText(k0(str));
        n0();
    }

    @Override // com.tencent.biz.richframework.part.IStatusViewProvider
    public void showErrorView(int i3, String str) {
        this.f224209d.setText(k0(str));
        n0();
    }

    @Override // com.tencent.biz.richframework.part.IStatusViewProvider
    public void showHintView(String str) {
        this.f224209d.setText(k0(str));
        n0();
    }

    @Override // com.tencent.biz.richframework.part.IStatusViewProvider
    public View getStatusView() {
        return this;
    }

    @Override // com.tencent.mobileqq.guild.feed.widget.GuildBaseWidgetView, com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
    }
}
