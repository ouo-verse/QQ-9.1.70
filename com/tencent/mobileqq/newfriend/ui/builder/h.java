package com.tencent.mobileqq.newfriend.ui.builder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class h extends d {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
                if (baseQQAppInterface != null) {
                    ax c16 = bi.c(baseQQAppInterface, h.this.f254107d, "mqqapi://mayknown/homepage?from=7");
                    if (c16 != null) {
                        c16.b();
                    } else {
                        QLog.w("NewFriendMayKnowTitleBuilder", 1, "#jumpToXSJSearchPage: no jumpAction, jumpUrl=mqqapi://mayknown/homepage?from=7");
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public TextView f254124a;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public h(Context context, AppInterface appInterface, SystemMsgListAdapter systemMsgListAdapter, com.tencent.mobileqq.newfriend.msg.i iVar) {
        super(context, appInterface, systemMsgListAdapter, iVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, appInterface, systemMsgListAdapter, iVar);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.ui.builder.d
    public View h(int i3, View view) {
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) view);
        }
        if (view != null && (view.getTag() instanceof b)) {
            bVar = (b) view.getTag();
        } else {
            bVar = new b();
            view = LayoutInflater.from(this.f254107d).inflate(R.layout.gz9, (ViewGroup) null);
            bVar.f254124a = (TextView) view.findViewById(R.id.m_d);
            view.setTag(bVar);
        }
        n(bVar.f254124a);
        view.setOnClickListener(new a());
        VideoReport.setElementId(view, "em_kl_more_button");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        return view;
    }

    public void n(TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) textView);
            return;
        }
        String string = this.f254107d.getString(R.string.iyj);
        textView.setVisibility(0);
        textView.setText(string);
        textView.setPadding(ViewUtils.dip2px(16.0f), ViewUtils.dip2px(23.0f), 0, ViewUtils.dip2px(19.0f));
    }
}
