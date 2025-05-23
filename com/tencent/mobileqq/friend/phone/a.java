package com.tencent.mobileqq.friend.phone;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contacts.base.c;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.utils.ac;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.util.QUITokenResUtil;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.ThemeImageView;

/* compiled from: P */
/* loaded from: classes33.dex */
public class a extends c {

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.friend.phone.a$a, reason: collision with other inner class name */
    /* loaded from: classes33.dex */
    public static class C7636a extends c.C7154c {
        public SingleLineTextView C;
        public ImageView D;
        public StringBuilder E;
        public QUIButton F;
        public TextView G;

        C7636a() {
            this.f187115e = 11;
        }
    }

    public a(QQAppInterface qQAppInterface, Context context, Entity entity) {
        super(qQAppInterface, context, entity);
    }

    private void p(View view, String str) {
        VideoReport.setElementId(view, "em_kl_contact_people_add");
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementParam(view, "user_id", str);
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.c
    public View a(int i3, int i16, View view, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        C7636a c7636a;
        int i17;
        String str = "";
        IPhoneContactService iPhoneContactService = (IPhoneContactService) this.f181503c.getRuntimeService(IPhoneContactService.class, "");
        if (view != null && (view.getTag() instanceof C7636a)) {
            c7636a = (C7636a) view.getTag();
        } else {
            view = LayoutInflater.from(this.f181504d).inflate(QUITokenResUtil.getResId(R.layout.f167808i6, R.layout.f167809e44), viewGroup, false);
            c7636a = new C7636a();
            c7636a.f187116f = (QQProAvatarView) view.findViewById(R.id.icon);
            c7636a.f181511h = (SingleLineTextView) view.findViewById(R.id.text1);
            c7636a.C = (SingleLineTextView) view.findViewById(R.id.k_1);
            c7636a.D = (ImageView) view.findViewById(R.id.dyk);
            c7636a.F = (QUIButton) view.findViewById(R.id.i8s);
            c7636a.G = (TextView) view.findViewById(R.id.f166787i92);
            view.setTag(c7636a);
            o(view.findViewById(R.id.icon));
        }
        PhoneContact phoneContact = (PhoneContact) this.f181505e;
        c7636a.f181513m = phoneContact;
        c7636a.f187114d = phoneContact.mobileCode;
        int a16 = com.tencent.mobileqq.friend.status.b.a(phoneContact.detalStatusFlag, phoneContact.iTermType);
        FriendListHandler friendListHandler = (FriendListHandler) this.f181503c.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        int i18 = phoneContact.netTypeIconId;
        switch (a16) {
            case 1:
                str = this.f181504d.getString(R.string.hpd);
                break;
            case 2:
                str = this.f181504d.getString(R.string.hpg);
                break;
            case 3:
                str = this.f181504d.getString(R.string.hpu);
                break;
            case 4:
            case 8:
                if (a16 == 8 && (phoneContact.abilityBits & 1) == 0 && (i17 = phoneContact.netTypeIconIdIphoneOrWphoneNoWifi) != 0) {
                    i18 = i17;
                }
                str = ac.P(i18);
                break;
            case 5:
            default:
                str = friendListHandler.getOfflineTipsConfig(iPhoneContactService.getLastLoginType(phoneContact.unifiedCode));
                if (str == null) {
                    str = this.f181504d.getString(R.string.hps);
                    break;
                }
                break;
            case 6:
                break;
            case 7:
                str = this.f181504d.getString(R.string.hpm);
                break;
        }
        boolean z16 = a16 == 0 || a16 == 6;
        if ((iPhoneContactService.getUIBits() & 8) != 8) {
            c7636a.f187116f.setEnableMask(z16);
        }
        if ((iPhoneContactService.getUIBits() & 4) == 4) {
            c7636a.C.setVisibility(8);
        } else if (!TextUtils.isEmpty(str)) {
            c7636a.C.setText("[" + str + "]");
            c7636a.C.setVisibility(0);
        } else {
            c7636a.C.setVisibility(8);
        }
        c7636a.D.setVisibility(8);
        c7636a.f181511h.setTextColor(c.c(this.f181504d, QUITokenResUtil.getResId(R.color.skin_black_theme_version2, R.color.qui_common_text_primary)));
        c7636a.f181511h.setText(phoneContact.name);
        FriendsManager friendsManager = (FriendsManager) this.f181503c.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (!TextUtils.isEmpty(phoneContact.uin) && !phoneContact.uin.equals("0")) {
            c7636a.F.setVisibility(8);
            c7636a.G.setVisibility(0);
            c7636a.G.setText(HardCodeUtil.qqStr(R.string.f171673k43));
            c7636a.G.setContentDescription(HardCodeUtil.qqStr(R.string.k46));
        } else if (friendsManager.Q(phoneContact.unifiedCode, true)) {
            c7636a.F.setVisibility(8);
            c7636a.G.setVisibility(0);
            c7636a.G.setText(HardCodeUtil.qqStr(R.string.f171675k45));
            c7636a.G.setContentDescription(HardCodeUtil.qqStr(R.string.k47));
        } else {
            c7636a.F.setVisibility(0);
            c7636a.F.setText(HardCodeUtil.qqStr(R.string.f170028dd));
            c7636a.F.setTag(phoneContact);
            c7636a.F.setContentDescription(HardCodeUtil.qqStr(R.string.f170028dd));
            c7636a.G.setVisibility(8);
        }
        if (AppSetting.f99565y) {
            StringBuilder sb5 = c7636a.E;
            if (sb5 == null) {
                sb5 = new StringBuilder(24);
            } else {
                sb5.delete(0, sb5.length());
            }
            sb5.append(phoneContact.name);
            sb5.append(".");
            sb5.append(str);
            sb5.append(".");
            sb5.append(ac.O(i18));
            view.setContentDescription(sb5);
        }
        l(view, 2, phoneContact.mobileNo);
        p(c7636a.F, phoneContact.mobileNo);
        return view;
    }

    protected void o(View view) {
        if (view instanceof ThemeImageView) {
            ((ThemeImageView) view).setSupportMaskView(false);
        }
    }
}
