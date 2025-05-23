package com.tencent.mobileqq.newfriend.ui.builder;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.QIMFollwerAdd;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.api.impl.NewFriendServiceImpl;
import com.tencent.mobileqq.newfriend.msg.q;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.newfriend.ui.builder.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes15.dex */
public class QIMFollowerAddBuilder extends d implements View.OnClickListener {
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

    public QIMFollowerAddBuilder(Context context, AppInterface appInterface, SystemMsgListAdapter systemMsgListAdapter, com.tencent.mobileqq.newfriend.msg.i iVar) {
        super(context, appInterface, systemMsgListAdapter, iVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, appInterface, systemMsgListAdapter, iVar);
        } else {
            this.f254110h = b(context);
            this.f254112m = this.f254107d.getResources().getDimensionPixelSize(R.dimen.f159221xr);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.ui.builder.d
    protected void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.newfriend.ui.builder.QIMFollowerAddBuilder.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QIMFollowerAddBuilder.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ((NewFriendServiceImpl) QIMFollowerAddBuilder.this.f254108e.getRuntimeService(INewFriendService.class, "")).deleteQIMFollowerAdd(((q) QIMFollowerAddBuilder.this.f254111i).f254043d);
                        QIMFollowerAddBuilder.this.f254108e.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.newfriend.ui.builder.QIMFollowerAddBuilder.1.1
                            static IPatchRedirector $redirector_;

                            {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                    iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                IPatchRedirector iPatchRedirector3 = $redirector_;
                                if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                    iPatchRedirector3.redirect((short) 2, (Object) this);
                                } else {
                                    QIMFollowerAddBuilder.this.f254109f.g();
                                }
                            }
                        });
                    }
                }
            }, null, true);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.ui.builder.d
    protected int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.mobileqq.newfriend.ui.builder.d
    public View h(int i3, View view) {
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) view);
        }
        if (view != null && (view.getTag() instanceof a)) {
            aVar = (a) view.getTag();
        } else {
            aVar = new a();
            view = d(this.f254107d, R.layout.b3_, aVar);
            k(view, this.f254112m);
            aVar.f254114d = (ImageView) view.findViewById(R.id.f163821d);
            aVar.f254115e = (TextView) view.findViewById(R.id.nickname);
            aVar.f254116f = (TextView) view.findViewById(R.id.i95);
            aVar.C = (TextView) view.findViewById(R.id.f164064iz);
            aVar.f254117h = (TextView) view.findViewById(R.id.iz7);
            aVar.f254119m = (TextView) view.findViewById(R.id.f166787i92);
            aVar.f254118i = (Button) view.findViewById(R.id.i8s);
            a(aVar.f254114d);
            view.setTag(aVar);
        }
        aVar.leftView.setTag(aVar);
        aVar.leftView.setOnClickListener(this);
        l(this.f254107d, view, i3, this.f254111i, aVar, this);
        aVar.leftView.setBackgroundResource(R.drawable.common_list_item_background);
        QIMFollwerAdd qIMFollwerAdd = ((q) this.f254111i).f254043d;
        if (!TextUtils.isEmpty(qIMFollwerAdd.smartRemark)) {
            aVar.f254115e.setVisibility(0);
            aVar.f254115e.setText(qIMFollwerAdd.smartRemark);
        } else {
            aVar.f254115e.setVisibility(8);
        }
        com.tencent.mobileqq.newfriend.utils.a.h(aVar.leftView, !this.f254111i.b());
        StringBuilder sb5 = new StringBuilder(256);
        ((INewFriendApi) QRoute.api(INewFriendApi.class)).showGenderAge(aVar.C, qIMFollwerAdd.gender, 0, sb5);
        if (TextUtils.isEmpty(qIMFollwerAdd.longNick)) {
            aVar.f254116f.setVisibility(8);
        } else {
            aVar.f254116f.setVisibility(0);
            aVar.f254116f.setText(qIMFollwerAdd.longNick);
            if (AppSetting.f99565y) {
                sb5.append(",");
                sb5.append(qIMFollwerAdd.longNick);
            }
        }
        if (!TextUtils.isEmpty(qIMFollwerAdd.source)) {
            aVar.f254117h.setText(String.format(Locale.getDefault(), HardCodeUtil.qqStr(R.string.op6), qIMFollwerAdd.source));
            aVar.f254117h.setVisibility(0);
        } else {
            aVar.f254117h.setVisibility(8);
        }
        aVar.f254119m.setVisibility(8);
        aVar.f254118i.setText(HardCodeUtil.qqStr(R.string.f172236op0));
        aVar.f254118i.setVisibility(0);
        aVar.f254118i.setOnClickListener(this);
        aVar.D = String.valueOf(qIMFollwerAdd.uin);
        aVar.f254114d.setImageBitmap(this.f254109f.c(1, String.valueOf(qIMFollwerAdd.uin)));
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 != R.id.ibi) {
                if (id5 == R.id.i8s) {
                    ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).clickQIMSource(this.f254107d, null, this.f254108e);
                } else {
                    i(view);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
