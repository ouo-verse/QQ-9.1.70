package com.tencent.mobileqq.friend.device;

import QQService.EVIPSPEC;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.contacts.base.c;
import com.tencent.mobileqq.activity.contacts.friend.BuddyListFriends;
import com.tencent.mobileqq.activity.contacts.friend.FriendItemLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.fileassistant.util.h;
import com.tencent.mobileqq.friend.group.GroupListFriend;
import com.tencent.mobileqq.friend.group.d;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.utils.al;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.d;
import com.tencent.util.QUITokenResUtil;

/* compiled from: P */
/* loaded from: classes33.dex */
public class a extends GroupListFriend {

    /* renamed from: t, reason: collision with root package name */
    private d f211613t;

    public a(QQAppInterface qQAppInterface, Context context, d dVar) {
        super(qQAppInterface, context, dVar.getUid());
        this.f181502b = 0;
        this.f211613t = dVar;
    }

    private void K(ImageView imageView) {
        BusinessInfoCheckUpdate.AppInfo appInfoByPath = ((IRedTouchManager) this.f181503c.getRuntimeService(IRedTouchManager.class, "")).getAppInfoByPath("100701.100702");
        if (appInfoByPath == null || appInfoByPath.iNewFlag.get() == 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = (int) al.a(this.f181504d, 9.0f);
        layoutParams.height = (int) al.a(this.f181504d, 9.0f);
        layoutParams.topMargin = (int) al.a(this.f181504d, 11.0f);
        imageView.setLayoutParams(layoutParams);
        imageView.setVisibility(0);
        imageView.setBackgroundResource(R.drawable.skin_tips_dot);
        BaseApplicationImpl.getApplication().getSharedPreferences("smartdevice_entry", 4).edit().putBoolean("enable_public_device_" + this.f181503c.getCurrentAccountUin(), true).commit();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0437  */
    @Override // com.tencent.mobileqq.friend.group.GroupListFriend, com.tencent.mobileqq.activity.contacts.base.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View a(int i3, int i16, View view, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        BuddyListFriends.a a16;
        String str;
        String string;
        String string2;
        String str2 = null;
        if (view != null && (view.getTag() instanceof BuddyListFriends.a) && (!(view.getTag() instanceof BuddyListFriends.a) || !((BuddyListFriends.a) view.getTag()).M)) {
            a16 = (BuddyListFriends.a) view.getTag();
            a16.f181511h.setCompoundDrawablesWithIntrinsicBounds(0, 0);
            a16.f181512i.setCompoundDrawables(null, null);
        } else {
            view = LayoutInflater.from(this.f181504d).inflate(QUITokenResUtil.getResId(R.layout.f167805i2, R.layout.f167806e42), viewGroup, false);
            a16 = ((FriendItemLayout) view).a();
            view.setTag(a16);
            s(view.findViewById(R.id.icon));
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) a16.H.getLayoutParams();
        layoutParams.leftMargin = BaseAIOUtils.f(68.0f, this.f181504d.getResources());
        a16.H.setLayoutParams(layoutParams);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) a16.C.getLayoutParams();
        layoutParams2.leftMargin = BaseAIOUtils.f(68.0f, this.f181504d.getResources());
        a16.C.setLayoutParams(layoutParams2);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) a16.f187116f.getLayoutParams();
        layoutParams3.leftMargin = BaseAIOUtils.f(16.0f, this.f181504d.getResources());
        a16.f187116f.setLayoutParams(layoutParams3);
        d dVar = this.f211613t;
        a16.f181513m = dVar;
        a16.f187114d = dVar.x();
        a16.C.setVisibility(0);
        String str3 = AppConstants.SMARTDEVICE_SEARCH_UIN;
        if (!str3.equals(this.f211613t.x())) {
            FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) a16.G.getLayoutParams();
            layoutParams4.width = (int) al.a(this.f181504d, 16.0f);
            layoutParams4.height = (int) al.a(this.f181504d, 16.0f);
            layoutParams4.topMargin = (int) al.a(this.f181504d, 8.5f);
            a16.G.setLayoutParams(layoutParams4);
        }
        boolean equals = AppConstants.DATALINE_PC_UIN.equals(this.f211613t.x());
        int i17 = R.string.hps;
        if (equals) {
            a16.C.setVisibility(0);
            boolean z16 = this.f211613t.w() == 0;
            Context context = this.f181504d;
            if (!z16) {
                i17 = R.string.hpt;
            }
            string = context.getString(i17);
            a16.C.setText("[" + string + "]");
            a16.f187116f.setEnableMask(z16);
            string2 = this.f181504d.getString(R.string.agq);
            a16.f181512i.setText(string2);
            a16.f181512i.setExtendText("", 1);
            a16.G.setVisibility(8);
            a16.E.setVisibility(8);
            a16.F.setVisibility(8);
        } else if (AppConstants.DATALINE_IPAD_UIN.equals(this.f211613t.x())) {
            a16.C.setVisibility(0);
            boolean z17 = this.f211613t.w() == 0;
            Context context2 = this.f181504d;
            if (!z17) {
                i17 = R.string.hpt;
            }
            string = context2.getString(i17);
            a16.C.setText("[" + string + "]");
            a16.f187116f.setEnableMask(z17);
            string2 = this.f181504d.getString(R.string.agr);
            a16.f181512i.setText(string2);
            a16.f181512i.setExtendText("", 1);
            a16.G.setVisibility(8);
            a16.E.setVisibility(8);
            a16.F.setVisibility(8);
        } else if (AppConstants.DATALINE_PHONE_UIN.equals(this.f211613t.x())) {
            a16.C.setVisibility(0);
            boolean z18 = this.f211613t.w() == 0;
            Context context3 = this.f181504d;
            if (!z18) {
                i17 = R.string.hpt;
            }
            string = context3.getString(i17);
            a16.C.setText("[" + string + "]");
            a16.f187116f.setEnableMask(z18);
            string2 = this.f181504d.getString(R.string.zqh);
            a16.f181512i.setText(string2);
            a16.f181512i.setExtendText("", 1);
            a16.G.setVisibility(8);
            a16.E.setVisibility(8);
            a16.F.setVisibility(8);
        } else {
            if (this.f211613t.x().equals(h.g(this.f181503c))) {
                str = this.f181504d.getString(R.string.f187523u8);
                a16.f181512i.setText(str);
                a16.f181512i.setExtendText("", 1);
                a16.G.setVisibility(8);
                a16.E.setVisibility(8);
                a16.F.setVisibility(8);
            } else if (AppConstants.SMARTDEVICE_UIN.equals(this.f211613t.x())) {
                boolean z19 = this.f211613t.w() == 0;
                if (this.f211613t.w() == 11) {
                    a16.C.setVisibility(8);
                    a16.C.setText("");
                    z19 = false;
                } else if (this.f211613t.w() == 12) {
                    a16.C.setVisibility(0);
                    str2 = this.f181504d.getString(R.string.f0j);
                    a16.C.setText("[" + str2 + "]");
                } else {
                    a16.C.setVisibility(0);
                    Context context4 = this.f181504d;
                    if (!z19) {
                        i17 = R.string.hpt;
                    }
                    str2 = context4.getString(i17);
                    a16.C.setText("[" + str2 + "]");
                }
                a16.f187116f.setEnableMask(z19);
                str = this.f181504d.getString(R.string.hne);
                a16.f181512i.setText(str);
                a16.f181512i.setExtendText("", 1);
                a16.G.setVisibility(8);
                a16.E.setVisibility(8);
                a16.F.setVisibility(8);
            } else if (AppConstants.DATALINE_PRINTER_UIN.equals(this.f211613t.x())) {
                a16.C.setText("");
                a16.C.setVisibility(8);
                a16.f187116f.setImageDrawable(null);
                str = this.f181504d.getString(R.string.agp);
                a16.f181512i.setText(str);
                a16.f181512i.setExtendText("", 1);
                a16.G.setVisibility(8);
                a16.E.setVisibility(8);
                a16.F.setVisibility(8);
            } else if (str3.equals(this.f211613t.x())) {
                a16.C.setText("");
                a16.C.setVisibility(8);
                a16.f187116f.setImageDrawable(null);
                str = this.f181504d.getString(R.string.agn);
                a16.f181512i.setText(str);
                a16.f181512i.setExtendText("", 1);
                a16.E.setVisibility(8);
                a16.F.setVisibility(8);
                a16.G.setVisibility(8);
                K(a16.G);
            } else {
                str = null;
            }
            a16.f181511h.setTextColor(c.c(this.f181504d, QUITokenResUtil.getResId(R.color.skin_black_theme_version2, R.color.qui_common_text_primary)));
            String p16 = this.f211613t.p();
            a16.f181511h.setText(p16);
            a16.f181512i.setVisibility(0);
            if (AppSetting.f99565y) {
                StringBuilder sb5 = a16.L;
                if (sb5 == null) {
                    sb5 = new StringBuilder(24);
                } else {
                    sb5.delete(0, sb5.length());
                }
                sb5.append(p16);
                sb5.append(".");
                if (!TextUtils.isEmpty(str2)) {
                    sb5.append(str2);
                    sb5.append(".");
                }
                d.Companion companion = com.tencent.mobileqq.friend.group.d.INSTANCE;
                if (companion.a(EVIPSPEC.E_SP_SUPERVIP, this.f211613t.getUid()) || companion.a(EVIPSPEC.E_SP_QQVIP, this.f211613t.getUid())) {
                    sb5.append("QQ\u4f1a\u5458");
                    sb5.append(".");
                }
                if (!TextUtils.isEmpty(str)) {
                    sb5.append(str);
                    sb5.append(".");
                }
                if (!TextUtils.isEmpty("")) {
                    sb5.append("");
                }
                view.setContentDescription(sb5);
            }
            com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar2 = this.f211613t;
            l(view, 4, dVar2 != null ? dVar2.x() : "");
            return view;
        }
        String str4 = string;
        str = string2;
        str2 = str4;
        a16.f181511h.setTextColor(c.c(this.f181504d, QUITokenResUtil.getResId(R.color.skin_black_theme_version2, R.color.qui_common_text_primary)));
        String p162 = this.f211613t.p();
        a16.f181511h.setText(p162);
        a16.f181512i.setVisibility(0);
        if (AppSetting.f99565y) {
        }
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d dVar22 = this.f211613t;
        l(view, 4, dVar22 != null ? dVar22.x() : "");
        return view;
    }
}
