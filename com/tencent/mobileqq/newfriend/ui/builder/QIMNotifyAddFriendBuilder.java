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
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.msg.r;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.newfriend.ui.builder.d;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes15.dex */
public class QIMNotifyAddFriendBuilder extends d implements View.OnClickListener {
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

    public QIMNotifyAddFriendBuilder(Context context, AppInterface appInterface, SystemMsgListAdapter systemMsgListAdapter, com.tencent.mobileqq.newfriend.msg.i iVar) {
        super(context, appInterface, systemMsgListAdapter, iVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, appInterface, systemMsgListAdapter, iVar);
        } else {
            this.f254110h = b(context);
            this.f254112m = context.getResources().getDimensionPixelSize(R.dimen.f159219xp);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.ui.builder.d
    protected void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            ReportController.o(null, "dc00898", "", "", "0X8008AA6", "0X8008AA6", 0, 0, "", "", "", "");
            ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.newfriend.ui.builder.QIMNotifyAddFriendBuilder.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QIMNotifyAddFriendBuilder.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    IAddFriendTempApi iAddFriendTempApi = (IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class);
                    QIMNotifyAddFriendBuilder qIMNotifyAddFriendBuilder = QIMNotifyAddFriendBuilder.this;
                    iAddFriendTempApi.deleteQIMNotifyAddFriendData(((r) qIMNotifyAddFriendBuilder.f254111i).f254044d, qIMNotifyAddFriendBuilder.f254108e);
                    QIMNotifyAddFriendBuilder.this.f254108e.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.newfriend.ui.builder.QIMNotifyAddFriendBuilder.1.1
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
                                QIMNotifyAddFriendBuilder.this.f254109f.g();
                            }
                        }
                    });
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
        View view2 = view;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) view2);
        }
        if (view2 != null && (view.getTag() instanceof a)) {
            aVar = (a) view.getTag();
        } else {
            aVar = new a();
            view2 = d(this.f254107d, R.layout.b3_, aVar);
            k(view2, this.f254112m);
            aVar.f254114d = (ImageView) view2.findViewById(R.id.f163821d);
            aVar.f254115e = (TextView) view2.findViewById(R.id.nickname);
            aVar.f254116f = (TextView) view2.findViewById(R.id.i95);
            aVar.C = (TextView) view2.findViewById(R.id.f164064iz);
            aVar.f254117h = (TextView) view2.findViewById(R.id.iz7);
            aVar.f254119m = (TextView) view2.findViewById(R.id.f166787i92);
            aVar.f254118i = (Button) view2.findViewById(R.id.i8s);
            a(aVar.f254114d);
            view2.setTag(aVar);
        }
        View view3 = view2;
        a aVar2 = aVar;
        aVar2.leftView.setTag(aVar2);
        aVar2.leftView.setClickable(false);
        l(this.f254107d, view3, i3, this.f254111i, aVar2, this);
        StringBuilder sb5 = new StringBuilder(256);
        QIMNotifyAddFriend qIMNotifyAddFriend = ((r) this.f254111i).f254044d;
        aVar2.f254115e.setText(qIMNotifyAddFriend.nickName);
        if (AppSetting.f99565y) {
            sb5.append(qIMNotifyAddFriend.nickName);
        }
        com.tencent.mobileqq.newfriend.utils.a.h(aVar2.leftView, !this.f254111i.b());
        ((INewFriendApi) QRoute.api(INewFriendApi.class)).showGenderAge(aVar2.C, qIMNotifyAddFriend.gender, qIMNotifyAddFriend.age, sb5);
        String qQInfoFromQQUin = ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).getQQInfoFromQQUin(qIMNotifyAddFriend.uin, qIMNotifyAddFriend.qqUin, this.f254108e);
        if (TextUtils.isEmpty(qQInfoFromQQUin)) {
            aVar2.f254116f.setVisibility(8);
        } else {
            aVar2.f254116f.setVisibility(0);
            aVar2.f254116f.setText(qQInfoFromQQUin);
            if (AppSetting.f99565y) {
                sb5.append(",");
                sb5.append(qQInfoFromQQUin);
            }
        }
        String qIMNewFriendSource = ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).getQIMNewFriendSource(this.f254108e);
        if (TextUtils.isEmpty(qIMNewFriendSource)) {
            qIMNewFriendSource = "\u6765\u81eaQIM\u7684\u597d\u53cb\u7533\u8bf7";
        }
        String format = String.format(Locale.getDefault(), HardCodeUtil.qqStr(R.string.op6), qIMNewFriendSource);
        aVar2.f254117h.setText(format);
        aVar2.f254117h.setVisibility(0);
        if (AppSetting.f99565y) {
            sb5.append(",");
            sb5.append(format);
        }
        aVar2.f254119m.setVisibility(8);
        aVar2.f254118i.setText(HardCodeUtil.qqStr(R.string.f172236op0));
        aVar2.f254118i.setVisibility(0);
        aVar2.f254118i.setOnClickListener(this);
        aVar2.D = String.valueOf(qIMNotifyAddFriend.uin);
        aVar2.f254114d.setImageBitmap(this.f254109f.c(1, String.valueOf(qIMNotifyAddFriend.uin)));
        if (AppSetting.f99565y) {
            view3.setContentDescription(sb5.toString());
        }
        ReportController.o(null, "dc00898", "", "", "0X8008AA4", "0X8008AA4", 0, 0, "", "", "", "");
        return view3;
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
                    ((INewFriendService) this.f254108e.getRuntimeService(INewFriendService.class, "")).markSystemMsgReaded();
                    QIMNotifyAddFriend qIMNotifyAddFriend = ((r) this.f254111i).f254044d;
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(qIMNotifyAddFriend);
                    ((IAddFriendTempApi) QRoute.api(IAddFriendTempApi.class)).addBatchQIMFriends(arrayList, this.f254108e);
                    ReportController.o(null, "dc00898", "", "", "0X8008AA5", "0X8008AA5", 0, 0, "", "", "", "");
                } else {
                    i(view);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
