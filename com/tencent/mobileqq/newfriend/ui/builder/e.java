package com.tencent.mobileqq.newfriend.ui.builder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.newfriend.ui.builder.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class e extends d implements View.OnClickListener {
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

    public e(Context context, AppInterface appInterface, SystemMsgListAdapter systemMsgListAdapter, com.tencent.mobileqq.newfriend.msg.i iVar) {
        super(context, appInterface, systemMsgListAdapter, iVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, appInterface, systemMsgListAdapter, iVar);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.ui.builder.d
    public View h(int i3, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) view);
        }
        if (view == null || !(view.getTag() instanceof a)) {
            view = LayoutInflater.from(this.f254107d).inflate(R.layout.b3c, (ViewGroup) null);
        }
        view.setOnClickListener(this);
        view.setTag(new a());
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
                QLog.d("NewFriendBindContactGuideBuilder", 2, "start PhoneLaunchActivity");
            }
            Intent bindNumberIntent = ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).getBindNumberIntent(view.getContext());
            bindNumberIntent.putExtra("kSrouce", 15);
            ((Activity) view.getContext()).startActivityForResult(bindNumberIntent, 230);
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
