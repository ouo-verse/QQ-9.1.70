package com.tencent.mobileqq.newfriend.ui.builder;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.addfriend.api.IAddFriendServiceApi;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.api.impl.NewFriendServiceImpl;
import com.tencent.mobileqq.newfriend.ui.builder.d;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.data.ContactMatch;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ContactMatchBuilder extends d implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private NewFriendServiceImpl C;

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

    @Override // com.tencent.mobileqq.newfriend.ui.builder.d
    protected void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.newfriend.ui.builder.ContactMatchBuilder.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ContactMatchBuilder.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ((IPhoneContactService) ContactMatchBuilder.this.f254108e.getRuntimeService(IPhoneContactService.class, "")).deleteContactMatch(((com.tencent.mobileqq.newfriend.msg.b) ContactMatchBuilder.this.f254111i).f254021d);
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.newfriend.ui.builder.ContactMatchBuilder.1.1
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
                                    ContactMatchBuilder.this.f254109f.g();
                                }
                            }
                        });
                    }
                }
            });
            ReportController.o(this.f254108e, "CliOper", "", "", "0X8006A72", "0X8006A72", 0, 0, "", "", "", "");
        }
    }

    @Override // com.tencent.mobileqq.newfriend.ui.builder.d
    protected int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
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
        com.tencent.mobileqq.newfriend.utils.a.h(aVar.leftView, !this.f254111i.b());
        ContactMatch contactMatch = ((com.tencent.mobileqq.newfriend.msg.b) this.f254111i).f254021d;
        StringBuilder sb5 = new StringBuilder(256);
        if (!TextUtils.isEmpty(contactMatch.name)) {
            aVar.f254115e.setVisibility(0);
            aVar.f254115e.setText(contactMatch.name);
            if (AppSetting.f99565y) {
                sb5.append(contactMatch.name);
            }
        } else {
            aVar.f254115e.setVisibility(8);
        }
        ((INewFriendApi) QRoute.api(INewFriendApi.class)).showGenderAge(aVar.C, contactMatch.gender, contactMatch.age, sb5);
        aVar.f254116f.setVisibility(8);
        aVar.f254117h.setText(HardCodeUtil.qqStr(R.string.l2a));
        aVar.f254117h.setVisibility(0);
        if (AppSetting.f99565y) {
            sb5.append(",\u6765\u81ea\u624b\u673a\u901a\u8baf\u5f55");
        }
        if (((IAddFriendServiceApi) this.f254108e.getRuntimeService(IAddFriendServiceApi.class, "")).hasSendAddFriendReq(contactMatch.unifiedCode, true)) {
            aVar.f254118i.setVisibility(8);
            aVar.f254119m.setVisibility(0);
            aVar.f254119m.setText(HardCodeUtil.qqStr(R.string.l2b));
            if (AppSetting.f99565y) {
                sb5.append(",\u7b49\u5f85\u9a8c\u8bc1");
                aVar.f254119m.setContentDescription(HardCodeUtil.qqStr(R.string.l2b));
            }
        } else {
            aVar.f254118i.setVisibility(0);
            aVar.f254118i.setText(HardCodeUtil.qqStr(R.string.f170028dd));
            aVar.f254118i.setTag(contactMatch);
            aVar.f254118i.setOnClickListener(this);
            aVar.f254119m.setVisibility(8);
            if (AppSetting.f99565y) {
                sb5.append(",\u6dfb\u52a0");
                aVar.f254118i.setContentDescription(HardCodeUtil.qqStr(R.string.l29));
            }
        }
        if (AppSetting.f99565y) {
            view.setContentDescription(sb5.toString());
        }
        String str = contactMatch.unifiedCode;
        aVar.D = str;
        aVar.f254114d.setImageBitmap(this.f254109f.c(11, str));
        if (QQTheme.isNowThemeIsNight()) {
            com.tencent.mobileqq.newfriend.utils.a.e(aVar.f254119m, aVar.f254116f, aVar.f254117h);
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i3;
        int i16;
        ContactMatch contactMatch;
        AllInOne allInOne;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.ibi) {
                Object tag = view.getTag();
                if (tag != null && (tag instanceof a) && (contactMatch = ((com.tencent.mobileqq.newfriend.msg.b) this.f254111i).f254021d) != null) {
                    if (((IPhoneContactService) this.f254108e.getRuntimeService(IPhoneContactService.class, "")).isBindedIgnoreUpload()) {
                        allInOne = new AllInOne(contactMatch.unifiedCode, 34);
                    } else {
                        allInOne = new AllInOne(contactMatch.unifiedCode, 29);
                    }
                    allInOne.nickname = contactMatch.name;
                    ProfileUtils.openProfileCardForResult((Activity) this.f254107d, allInOne, 229);
                    this.C.markRecommendReaded();
                }
            } else if (id5 == R.id.i8s) {
                Object tag2 = view.getTag();
                if (tag2 != null && (tag2 instanceof ContactMatch)) {
                    if (!NetworkUtil.isNetworkAvailable(this.f254107d)) {
                        Context context = this.f254107d;
                        QQToast.makeText(context, context.getResources().getString(R.string.b3j), 0).show(g());
                    } else {
                        ContactMatch contactMatch2 = (ContactMatch) tag2;
                        if (!((IPhoneContactService) this.f254108e.getRuntimeService(IPhoneContactService.class, "")).isBindedIgnoreUpload()) {
                            i3 = 3075;
                            i16 = 1;
                        } else {
                            i3 = 3006;
                            i16 = 3;
                        }
                        ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriendForResult((Activity) this.f254107d, ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(this.f254107d, 2, contactMatch2.unifiedCode, "ContactMatchBuilder", i3, i16, contactMatch2.name, null, null, HardCodeUtil.qqStr(R.string.l2_), null), 229);
                        this.C.markRecommendReaded();
                        ReportController.o(this.f254108e, "CliOper", "", "", "0X8006A71", "0X8006A71", 0, 0, "", "", "", "");
                    }
                }
            } else {
                i(view);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
