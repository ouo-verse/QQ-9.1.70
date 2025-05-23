package com.tencent.biz.qqcircle.immersive.feed;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.events.QFSUnShowFreeFlowViewEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StLiteBanner;

/* compiled from: P */
/* loaded from: classes4.dex */
public class t extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed> implements View.OnClickListener {
    private LinearLayout I;
    private ImageView J;
    private TextView K;
    private TextView L;
    private g70.a M;

    private void g1() {
        if (this.I == null) {
            LinearLayout linearLayout = (LinearLayout) ((ViewStub) this.C.findViewById(R.id.f40751f8)).inflate();
            this.I = linearLayout;
            this.J = (ImageView) linearLayout.findViewById(R.id.f40731f6);
            this.K = (TextView) this.I.findViewById(R.id.f40741f7);
            this.L = (TextView) this.I.findViewById(R.id.f40721f5);
        }
        if (this.M == null) {
            this.M = (g70.a) A0(g70.a.class);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void h1(View view) {
        String str;
        MutableLiveData<QCircleInitBean> L1;
        QCircleInitBean value;
        g70.a aVar = this.M;
        if (aVar != null && (L1 = aVar.L1()) != null && (value = L1.getValue()) != null && value.getSchemeAttrs() != null && value.getSchemeAttrs().containsKey("key_scheme")) {
            str = value.getSchemeAttrs().get("key_scheme");
        } else {
            str = "";
        }
        String str2 = ((FeedCloudMeta$StFeed) this.f85017h).liteBanner.jumpUrl.get();
        if (com.tencent.biz.qqcircle.utils.cy.n(str2)) {
            com.tencent.biz.qqcircle.launcher.c.h(view.getContext(), com.tencent.biz.qqcircle.utils.cy.g(str2, 3), str);
        } else {
            com.tencent.biz.qqcircle.launcher.c.h(view.getContext(), str2, str);
        }
    }

    private void j1(FeedCloudMeta$StLiteBanner feedCloudMeta$StLiteBanner) {
        if (feedCloudMeta$StLiteBanner == null) {
            return;
        }
        String str = feedCloudMeta$StLiteBanner.icon.picUrl.get();
        if (!TextUtils.isEmpty(str)) {
            Option obtain = Option.obtain();
            obtain.setUrl(str);
            obtain.setTargetView(this.J);
            int width = this.J.getWidth();
            int height = this.J.getHeight();
            obtain.setRequestWidth(width);
            obtain.setRequestHeight(height);
            Option targetView = Option.obtain().setUrl(str).setTargetView(this.J);
            targetView.setSupportRecycler(true);
            QCircleFeedPicLoader.g().loadImage(targetView);
        }
        k1(feedCloudMeta$StLiteBanner.title.get());
    }

    private void k1(String str) {
        if (str != null && str.contains("\u00b7")) {
            int indexOf = str.indexOf("\u00b7");
            this.K.setText(str.substring(0, indexOf));
            this.L.setText(str.substring(indexOf + 1));
        } else if (str != null && str.contains("|")) {
            int indexOf2 = str.indexOf("|");
            this.K.setText(str.substring(0, indexOf2 - 1));
            this.L.setText(str.substring(indexOf2 + 2));
        } else if (str != null) {
            this.K.setText(str);
        } else {
            this.I.setVisibility(8);
        }
    }

    private void l1(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        j1(feedCloudMeta$StFeed.liteBanner);
        if (!TextUtils.isEmpty(feedCloudMeta$StFeed.liteBanner.jumpUrl.get())) {
            this.I.setOnClickListener(this);
        }
        this.I.setVisibility(0);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: i1, reason: merged with bridge method [inline-methods] */
    public void L0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        super.L0(feedCloudMeta$StFeed, i3);
        this.f85017h = feedCloudMeta$StFeed;
        if (feedCloudMeta$StFeed == 0) {
            QLog.d("", 1, "[onBindData] data should not be null.");
            return;
        }
        LinearLayout linearLayout = this.I;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        FeedCloudMeta$StLiteBanner feedCloudMeta$StLiteBanner = feedCloudMeta$StFeed.liteBanner;
        if (feedCloudMeta$StLiteBanner != null && !TextUtils.isEmpty(feedCloudMeta$StLiteBanner.icon.picUrl.get()) && !TextUtils.isEmpty(feedCloudMeta$StFeed.liteBanner.title.get())) {
            g1();
            l1(feedCloudMeta$StFeed);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.f40751f8) {
            h1(view);
            SimpleEventBus.getInstance().dispatchEvent(new QFSUnShowFreeFlowViewEvent());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "";
    }
}
