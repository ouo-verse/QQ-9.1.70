package com.tencent.mobileqq.newfriend.ui.builder;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.api.INewFriendVerificationService;
import com.tencent.mobileqq.newfriend.api.impl.NewFriendServiceImpl;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class k extends d implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    a C;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public TextView f254127a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f254128b;

        /* renamed from: c, reason: collision with root package name */
        public RelativeLayout f254129c;

        /* renamed from: d, reason: collision with root package name */
        public View f254130d;

        /* renamed from: e, reason: collision with root package name */
        public View f254131e;

        /* renamed from: f, reason: collision with root package name */
        public ImageView f254132f;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public k(Context context, AppInterface appInterface, SystemMsgListAdapter systemMsgListAdapter, com.tencent.mobileqq.newfriend.msg.i iVar) {
        super(context, appInterface, systemMsgListAdapter, iVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, appInterface, systemMsgListAdapter, iVar);
        }
    }

    private void n(a aVar, int i3) {
        boolean z16;
        int i16;
        int i17 = 0;
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        View view = aVar.f254130d;
        if (z16) {
            i16 = 0;
        } else {
            i16 = 8;
        }
        view.setVisibility(i16);
        View view2 = aVar.f254131e;
        if (z16) {
            i17 = 8;
        }
        view2.setVisibility(i17);
    }

    private void o(a aVar) {
        int i3;
        AppInterface appInterface = this.f254108e;
        if (appInterface == null) {
            return;
        }
        int sysSuspiciousUnreadNum = ((NewFriendServiceImpl) appInterface.getRuntimeService(INewFriendService.class, "")).getSysSuspiciousUnreadNum();
        boolean isShowRedPointAtNewFriendBanner = ((INewFriendVerificationService) this.f254108e.getRuntimeService(INewFriendVerificationService.class, "")).isShowRedPointAtNewFriendBanner();
        ImageView imageView = aVar.f254132f;
        if (sysSuspiciousUnreadNum <= 0 && !isShowRedPointAtNewFriendBanner) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        imageView.setVisibility(i3);
    }

    @Override // com.tencent.mobileqq.newfriend.ui.builder.d
    public View h(int i3, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) view);
        }
        if (view != null && (view.getTag() instanceof a)) {
            this.C = (a) view.getTag();
        } else {
            this.C = new a();
            view = LayoutInflater.from(this.f254107d).inflate(R.layout.gze, (ViewGroup) null);
            this.C.f254129c = (RelativeLayout) view.findViewById(R.id.e2a);
            this.C.f254130d = view.findViewById(R.id.ujv);
            this.C.f254131e = view.findViewById(R.id.uju);
            this.C.f254127a = (TextView) view.findViewById(R.id.title);
            this.C.f254128b = (TextView) view.findViewById(R.id.v5w);
            this.C.f254132f = (ImageView) view.findViewById(R.id.y7w);
            this.C.f254128b.setOnClickListener(this);
            view.setTag(this.C);
        }
        this.C.f254127a.setText(((com.tencent.mobileqq.newfriend.msg.l) this.f254111i).f254040d.f254016a);
        o(this.C);
        n(this.C, i3);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else if (view.getId() == R.id.v5w) {
            ((INewFriendService) this.f254108e.getRuntimeService(INewFriendService.class, "")).setSysSuspiciousUnreadNum(0);
            Intent intent = new Intent();
            intent.putExtra("isFromNewFriendPage", true);
            ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).jumpToNewFriendMoreSysMsgSuspiciousFragment(this.f254107d, intent, 232);
            ReportController.o(null, "dc00898", "", "", "0X800C080", "0X800C080", 0, 0, "", "", "", "");
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
