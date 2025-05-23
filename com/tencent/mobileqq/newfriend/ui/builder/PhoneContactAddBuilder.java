package com.tencent.mobileqq.newfriend.ui.builder;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.msg.p;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.newfriend.ui.builder.d;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.data.PhoneContactAdd;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes15.dex */
public class PhoneContactAddBuilder extends d implements View.OnClickListener {
    static IPatchRedirector $redirector_;

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

    public PhoneContactAddBuilder(Context context, AppInterface appInterface, SystemMsgListAdapter systemMsgListAdapter, com.tencent.mobileqq.newfriend.msg.i iVar) {
        super(context, appInterface, systemMsgListAdapter, iVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, appInterface, systemMsgListAdapter, iVar);
        } else {
            this.f254110h = b(context);
        }
    }

    @Override // com.tencent.mobileqq.newfriend.ui.builder.d
    protected void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.newfriend.ui.builder.PhoneContactAddBuilder.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PhoneContactAddBuilder.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ((IPhoneContactService) PhoneContactAddBuilder.this.f254108e.getRuntimeService(IPhoneContactService.class, "")).deletePhoneContactAddInfo(((p) PhoneContactAddBuilder.this.f254111i).f254042d);
                        PhoneContactAddBuilder.this.f254108e.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.newfriend.ui.builder.PhoneContactAddBuilder.1.1
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
                                    PhoneContactAddBuilder.this.f254109f.g();
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
        com.tencent.mobileqq.newfriend.utils.a.h(aVar.leftView, false);
        PhoneContactAdd phoneContactAdd = ((p) this.f254111i).f254042d;
        if (!TextUtils.isEmpty(phoneContactAdd.name)) {
            aVar.f254115e.setVisibility(0);
            aVar.f254115e.setText(phoneContactAdd.name);
        } else {
            aVar.f254115e.setVisibility(8);
        }
        aVar.C.setVisibility(8);
        aVar.f254117h.setVisibility(8);
        if (!TextUtils.isEmpty(phoneContactAdd.remindInfo)) {
            aVar.f254116f.setVisibility(0);
            aVar.f254116f.setText(phoneContactAdd.remindInfo);
        } else {
            aVar.f254116f.setVisibility(8);
        }
        aVar.f254119m.setVisibility(0);
        aVar.f254118i.setVisibility(8);
        aVar.f254119m.setText(this.f254107d.getString(R.string.f173067h24));
        String str = phoneContactAdd.unifiedCode;
        aVar.D = str;
        aVar.f254114d.setImageBitmap(this.f254109f.c(11, str));
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        PhoneContactAdd phoneContactAdd;
        AllInOne allInOne;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
        } else if (view.getId() == R.id.ibi) {
            if ((view.getTag() instanceof a) && (phoneContactAdd = ((p) this.f254111i).f254042d) != null) {
                IPhoneContactService iPhoneContactService = (IPhoneContactService) this.f254108e.getRuntimeService(IPhoneContactService.class, "");
                if (iPhoneContactService.queryContactByCodeNumber(phoneContactAdd.unifiedCode) == null) {
                    allInOne = new AllInOne(phoneContactAdd.unifiedCode, 29);
                } else if (iPhoneContactService.isBindedIgnoreUpload()) {
                    allInOne = new AllInOne(phoneContactAdd.unifiedCode, 34);
                } else {
                    allInOne = new AllInOne(phoneContactAdd.unifiedCode, 29);
                }
                allInOne.nickname = phoneContactAdd.name;
                ProfileUtils.openProfileCardForResult((Activity) this.f254107d, allInOne, 227);
                ((INewFriendService) this.f254108e.getRuntimeService(INewFriendService.class, "")).markSystemMsgReaded();
            }
        } else {
            i(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
