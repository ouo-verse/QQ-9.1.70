package com.tencent.mobileqq.newfriend.ui.builder;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.msg.o;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.newfriend.ui.builder.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class m extends d implements View.OnClickListener {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class a extends d.b {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public m(Context context, AppInterface appInterface, SystemMsgListAdapter systemMsgListAdapter, com.tencent.mobileqq.newfriend.msg.i iVar) {
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) view);
        }
        if (view != null && (view.getTag() instanceof a)) {
            aVar = (a) view.getTag();
        } else {
            view = LayoutInflater.from(this.f254107d).inflate(R.layout.f168888cc3, (ViewGroup) null);
            aVar = new a();
            aVar.f254114d = (ImageView) view.findViewById(R.id.head);
            view.setOnClickListener(this);
            view.setTag(aVar);
        }
        String str = ((o) this.f254111i).f254041d;
        aVar.D = str;
        aVar.f254114d.setImageBitmap(this.f254109f.c(1, str));
        ((INewFriendApi) QRoute.api(INewFriendApi.class)).setUiBuilderExposeCnt(((INewFriendApi) QRoute.api(INewFriendApi.class)).getUiBuilderExposeCnt() + 1);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("NewFriendVerifyBlockedBuilder", 2, "start PhoneLaunchActivity");
            }
            ((INewFriendApi) QRoute.api(INewFriendApi.class)).jumpToNewFriendVerifyListAct((Activity) this.f254107d);
            ReportController.o(null, "dc00898", "", "", "0X800A3A4", "0X800A3A4", 0, 0, "", "", "", "");
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
