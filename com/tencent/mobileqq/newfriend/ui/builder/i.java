package com.tencent.mobileqq.newfriend.ui.builder;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class i extends d implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public TextView f254125a;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public i(Context context, AppInterface appInterface, SystemMsgListAdapter systemMsgListAdapter, com.tencent.mobileqq.newfriend.msg.i iVar) {
        super(context, appInterface, systemMsgListAdapter, iVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, appInterface, systemMsgListAdapter, iVar);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.ui.builder.d
    public View h(int i3, View view) {
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) view);
        }
        if (view != null && (view.getTag() instanceof a)) {
            aVar = (a) view.getTag();
        } else {
            aVar = new a();
            view = LayoutInflater.from(this.f254107d).inflate(R.layout.ayl, (ViewGroup) null);
            aVar.f254125a = (TextView) view.findViewById(R.id.f08);
            ((RelativeLayout) view.findViewById(R.id.zeq)).setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg_selector);
            view.setTag(aVar);
        }
        com.tencent.mobileqq.newfriend.data.a aVar2 = ((com.tencent.mobileqq.newfriend.msg.j) this.f254111i).f254038d;
        aVar.f254125a.setText(aVar2.f254014a);
        AccessibilityUtil.c(aVar.f254125a, aVar2.f254014a, Button.class.getName());
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
        } else {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof a)) {
                int i3 = ((com.tencent.mobileqq.newfriend.msg.j) this.f254111i).f254038d.f254015b;
                if (i3 != 1000) {
                    if (i3 == 1001) {
                        ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).startAddContactsPageForResult((Activity) this.f254107d, 4, 6, 226);
                        ((INewFriendService) this.f254108e.getRuntimeService(INewFriendService.class, "")).markAllDataReaded();
                    }
                } else {
                    ((INewFriendApi) QRoute.api(INewFriendApi.class)).startNewFriendMoreSysMsgActivityForResult((Activity) this.f254107d, 225, this.f254109f.e());
                    ReportController.o(this.f254108e, "dc00898", "", "", "0X8007704", "0X8007704", 0, 0, "", "", "", "");
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
