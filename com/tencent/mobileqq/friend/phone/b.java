package com.tencent.mobileqq.friend.phone;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.config.AppSetting;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contacts.base.c;
import com.tencent.mobileqq.activity.contacts.friend.SimpleTextView;
import com.tencent.mobileqq.adapter.j;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.friend.phone.a;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileCardConst;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QUITokenResUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import com.tencent.widget.SingleLineTextView;
import cooperation.qzone.report.lp.LpReportInfo_dc04586;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class b extends j implements View.OnClickListener {
    private IPhoneContactService F;
    private QQAppInterface G;
    private Context H;
    private List<c> I;
    private View J;
    private PhoneContactFragment K;
    private boolean L;
    private long M;

    public b(Context context, QQAppInterface qQAppInterface, ListView listView, int i3, boolean z16, PhoneContactFragment phoneContactFragment) {
        super(context, qQAppInterface, listView, i3, z16);
        this.L = false;
        this.M = 0L;
        this.G = qQAppInterface;
        this.H = context;
        this.F = (IPhoneContactService) qQAppInterface.getRuntimeService(IPhoneContactService.class);
        this.K = phoneContactFragment;
    }

    private boolean j() {
        List<c> list = this.I;
        if (list == null) {
            return true;
        }
        return list.isEmpty();
    }

    private void k() {
        List<c> list = this.I;
        if (list == null) {
            this.I = new ArrayList();
        } else {
            list.clear();
        }
        int selfBindState = this.F.getSelfBindState();
        if (selfBindState == 9 || selfBindState == 8 || selfBindState == 4 || selfBindState == 2) {
            if (!PermissionChecker.h().f()) {
                if (QLog.isColorLevel()) {
                    QLog.d("contacts.PhoneContactAdapter", 2, "load data: no permission");
                    return;
                }
                return;
            }
            List<PhoneContact> bindNonfriendList = this.F.getBindNonfriendList(new int[]{7, 2, 3, 4});
            if (bindNonfriendList != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("contacts.PhoneContactAdapter", 2, "load data:" + bindNonfriendList.size());
                }
                ArrayList arrayList = new ArrayList(bindNonfriendList.size());
                for (PhoneContact phoneContact : bindNonfriendList) {
                    if (!phoneContact.isHiden) {
                        arrayList.add(new a(this.G, this.H, phoneContact));
                    }
                }
                this.I = arrayList;
                long uptimeMillis = SystemClock.uptimeMillis();
                if (this.L && this.I.size() == 0) {
                    long j3 = this.M;
                    if (uptimeMillis - j3 > 180000) {
                        QLog.d("contacts.PhoneContactAdapter", 1, String.format("needDoubleCheck onAppRunForeground interval=%d", Long.valueOf(uptimeMillis - j3)));
                        IPhoneContactService iPhoneContactService = (IPhoneContactService) this.G.getRuntimeService(IPhoneContactService.class, "");
                        if (iPhoneContactService != null) {
                            iPhoneContactService.checkUpdateLocalContact(true, 1);
                        }
                        this.L = false;
                        this.M = uptimeMillis;
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.adapter.j
    public void destroy() {
        super.destroy();
        this.F = null;
        this.G = null;
        this.H = null;
        this.K = null;
    }

    @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
    public int getCount() {
        if (this.I != null && j() && !this.K.Qh()) {
            return 1;
        }
        List<c> list = this.I;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
    public Object getItem(int i3) {
        return Integer.valueOf(i3);
    }

    @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        if (j()) {
            if (this.J == null) {
                View inflate = View.inflate(this.H, QUITokenResUtil.getResId(R.layout.f167798hv, R.layout.e3z), null);
                this.J = inflate;
                inflate.setBackgroundResource(QUITokenResUtil.getResId(R.drawable.f160540jm, R.drawable.jiv));
                this.J.findViewById(R.id.dv_).setVisibility(8);
                this.J.findViewById(R.id.f165958dx0).setVisibility(8);
                SingleLineTextView singleLineTextView = (SingleLineTextView) this.J.findViewById(R.id.group_name);
                singleLineTextView.setText(HardCodeUtil.qqStr(R.string.p2h));
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) singleLineTextView.getLayoutParams();
                marginLayoutParams.leftMargin /= 2;
                singleLineTextView.setLayoutParams(marginLayoutParams);
                ((SimpleTextView) this.J.findViewById(R.id.contact_count)).setText("0");
                if (AppSetting.f99565y) {
                    this.J.setFocusable(true);
                    this.J.setContentDescription(HardCodeUtil.qqStr(R.string.f213645qr));
                }
            }
            return this.J;
        }
        View a16 = this.I.get(i3).a(0, i3, view, viewGroup, this);
        if (a16 != null) {
            c.C7154c c7154c = (c.C7154c) a16.getTag();
            QQProAvatarView qQProAvatarView = c7154c.f187116f;
            if (qQProAvatarView != null) {
                qQProAvatarView.w(c7154c.f187115e, c7154c.f187114d);
            }
            a16.setOnClickListener(this);
            if (c7154c instanceof a.C7636a) {
                ((a.C7636a) c7154c).F.setOnClickListener(this);
            }
        }
        return a16;
    }

    public void h(QQAppInterface qQAppInterface) {
        if (qQAppInterface != this.G) {
            if (QLog.isColorLevel()) {
                QLog.i("contacts.PhoneContactAdapter", 2, "checkResetApp, need change app!");
            }
            this.G = qQAppInterface;
            this.F = (IPhoneContactService) qQAppInterface.getRuntimeService(IPhoneContactService.class, "");
            a(this.G);
        }
    }

    public void i() {
        List<c> list = this.I;
        if (list != null) {
            list.clear();
        }
    }

    @Override // com.tencent.mobileqq.adapter.j, com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        super.onScrollStateChanged(absListView, i3);
        if (i3 != 0) {
            ApngImage.pauseByTag(3);
        }
        if (i3 == 0) {
            ApngImage.playByTag(3);
        }
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        this.L = true;
        k();
        super.notifyDataSetChanged();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AllInOne allInOne;
        if (view != null && view.getId() == R.id.i8s && (view.getTag() instanceof PhoneContact)) {
            PhoneContact phoneContact = (PhoneContact) view.getTag();
            int i3 = this.F.isBindedIgnoreUpload() ? 15 : 17;
            phoneContact.isNewRecommend = false;
            ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriend(this.H, ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(this.H, 2, phoneContact.unifiedCode, null, 3006, i3, phoneContact.name, null, null, HardCodeUtil.qqStr(R.string.j6l), null));
            ReportController.o(this.G, "dc00899", "contact", "", "addbook", LpReportInfo_dc04586.ITEM_ID_BTN_ADD_FRIEND, 0, 0, "", "", "", "");
            return;
        }
        if (view == null || !(view.getTag() instanceof c.C7154c)) {
            return;
        }
        Object obj = ((c.C7154c) view.getTag()).f181513m;
        if (obj instanceof PhoneContact) {
            PhoneContact phoneContact2 = (PhoneContact) obj;
            if (QLog.isColorLevel()) {
                QLog.d("contacts.PhoneContactAdapter", 2, "onItemClick:" + phoneContact2.name + phoneContact2.mobileCode + "--[" + ((int) phoneContact2.detalStatusFlag) + "] [" + phoneContact2.iTermType + "]");
            }
            if (this.F.isBindedIgnoreUpload()) {
                allInOne = new AllInOne(phoneContact2.unifiedCode, 34);
            } else {
                AllInOne allInOne2 = new AllInOne(phoneContact2.unifiedCode, 29);
                allInOne2.subSourceId = 17;
                allInOne = allInOne2;
            }
            allInOne.profileEntryType = 59;
            allInOne.nickname = phoneContact2.name;
            allInOne.chatEntrance = 2;
            allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SOURCE_ID, 5);
            allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, 53);
            ProfileUtils.openProfileCard(this.H, allInOne);
            ReportController.o(this.G, "CliOper", "", "", "0X80053DF", "0X80053DF", 0, 0, "1", "", "", "");
        }
    }
}
