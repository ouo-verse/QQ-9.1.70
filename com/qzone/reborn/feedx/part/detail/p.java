package com.qzone.reborn.feedx.part.detail;

import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import androidx.lifecycle.Observer;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.feedx.activity.QZoneFriendFeedXActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

/* compiled from: P */
/* loaded from: classes37.dex */
public class p extends com.qzone.reborn.base.k {

    /* renamed from: d, reason: collision with root package name */
    private com.qzone.reborn.feedx.viewmodel.h f55185d;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements Observer<UIStateData<BusinessFeedData>> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f55186d;

        a(View view) {
            this.f55186d = view;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(UIStateData<BusinessFeedData> uIStateData) {
            if (!p.this.H9() || p.this.f55185d.C2()) {
                return;
            }
            p.this.I9(this.f55186d);
        }
    }

    private int F9() {
        if (this.f55185d.l2() == null) {
            return 5;
        }
        if (this.f55185d.i2() == 0) {
            return 4;
        }
        if (this.f55185d.i2() == 1) {
            return 3;
        }
        if (this.f55185d.i2() == 2) {
            return 7;
        }
        if (TextUtils.equals(this.f55185d.l2(), QQBrowserActivity.class.getSimpleName())) {
            return 10;
        }
        return (this.f55185d.z2() || TextUtils.equals(this.f55185d.l2(), ChatActivity.class.getSimpleName())) ? 1 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G9(int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        LpReportInfo_pf00064.allReport(82, i3, 2);
        Intent intent = new Intent();
        intent.putExtra("force_refresh", true);
        if (getActivity() != null) {
            QzonePluginProxyActivity.setActivityNameToIntent(intent, QZoneFriendFeedXActivity.class.getName());
            QZoneHelper.forwardToFriendFeed(getActivity(), LoginData.getInstance().getUinString(), intent, 0);
            getActivity().finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public boolean H9() {
        return this.f55185d.x2();
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFeedxDetailHomeBtnPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public Handler getMainHandler() {
        if (this.f55185d == null) {
            this.f55185d = (com.qzone.reborn.feedx.viewmodel.h) getViewModel(com.qzone.reborn.feedx.viewmodel.h.class);
        }
        return this.f55185d.g2();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        com.qzone.reborn.feedx.viewmodel.h hVar = (com.qzone.reborn.feedx.viewmodel.h) getViewModel(com.qzone.reborn.feedx.viewmodel.h.class);
        this.f55185d = hVar;
        hVar.f55901m.observe(getPartHost().getLifecycleOwner(), new a(view));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I9(View view) {
        ViewStub viewStub = (ViewStub) view.findViewById(R.id.f162853mz4);
        final int F9 = F9();
        if (viewStub != null) {
            View inflate = viewStub.inflate();
            inflate.setVisibility(0);
            inflate.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.part.detail.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    p.this.G9(F9, view2);
                }
            });
            LpReportInfo_pf00064.allReport(82, F9, 1);
        }
    }
}
