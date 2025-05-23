package com.tencent.mobileqq.activity.contacts.friend;

import QQService.EVIPSPEC;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contacts.base.c;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.mutualmark.view.MutualMarkIconsView;
import com.tencent.mobileqq.onlinestatus.OnlineStatusView;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.bp;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.al;
import com.tencent.mobileqq.utils.ff;
import com.tencent.mobileqq.vas.VipGrayConfigHelper;
import com.tencent.mobileqq.vip.IGameCardManager;
import com.tencent.mobileqq.vip.api.IVipColorName;
import com.tencent.mobileqq.vip.r;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.theme.SkinEngine;
import com.tencent.util.QUITokenResUtil;
import com.tencent.widget.SwipRightMenuBuilder;
import com.tencent.widget.ThemeImageWrapper;

/* compiled from: P */
/* loaded from: classes10.dex */
public class BuddyListFriends extends c {
    static IPatchRedirector $redirector_;

    /* renamed from: o, reason: collision with root package name */
    public static final int[] f181573o;

    /* renamed from: p, reason: collision with root package name */
    static final int[] f181574p;

    /* renamed from: q, reason: collision with root package name */
    static final int[] f181575q;

    /* renamed from: k, reason: collision with root package name */
    FriendsManager f181576k;

    /* renamed from: l, reason: collision with root package name */
    StatusManager f181577l;

    /* renamed from: m, reason: collision with root package name */
    public Friends f181578m;

    /* renamed from: n, reason: collision with root package name */
    private int f181579n;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a extends c.C7154c {
        static IPatchRedirector $redirector_;
        public SimpleTextView C;
        public ImageView D;
        public ImageView E;
        public URLImageView F;
        public ImageView G;
        public LinearLayout H;
        public URLImageView I;
        public View J;
        public MutualMarkIconsView K;
        public StringBuilder L;
        public boolean M;
        public boolean N;
        public OnlineStatusView P;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68068);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
            return;
        }
        f181573o = new int[]{R.string.a9d, R.string.a9e};
        f181574p = new int[]{R.drawable.cjb, R.drawable.cjb};
        f181575q = new int[]{R.id.eqg, R.id.eqg};
    }

    public BuddyListFriends(QQAppInterface qQAppInterface, Context context, Entity entity) {
        super(qQAppInterface, context, entity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, qQAppInterface, context, entity);
            return;
        }
        this.f181579n = 0;
        this.f181576k = (FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        this.f181577l = (StatusManager) qQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER);
        this.f181578m = (Friends) entity;
        t();
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.contacts.friend.BuddyListFriends.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BuddyListFriends.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        BuddyListFriends buddyListFriends = BuddyListFriends.this;
                        buddyListFriends.f181576k.H(buddyListFriends.f181578m.uin);
                    }
                }
            }, 16, null, true);
        } else {
            this.f181576k.H(this.f181578m.uin);
        }
    }

    private void o(a aVar, String str, String str2, String str3, View view) {
        boolean z16;
        RichStatus richStatus;
        String str4;
        String str5;
        if (AppSetting.f99565y) {
            StringBuilder sb5 = aVar.L;
            boolean z17 = false;
            if (sb5 == null) {
                sb5 = new StringBuilder(24);
            } else {
                sb5.delete(0, sb5.length());
            }
            if (TextUtils.isEmpty(str)) {
                str = aVar.P.a().toString();
            }
            sb5.append(str2);
            sb5.append(".");
            sb5.append(str);
            sb5.append(".");
            if (this.f181578m.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP) || this.f181578m.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) {
                sb5.append("QQ\u4f1a\u5458");
                sb5.append(".");
            }
            if (!TextUtils.isEmpty(str3)) {
                sb5.append(str3);
                sb5.append(".");
            }
            if (!TextUtils.isEmpty(aVar.K.D)) {
                sb5.append(aVar.K.D.toString());
            }
            ExtensionInfo I = this.f181576k.I(this.f181578m.uin, false);
            if (I != null && !TextUtils.isEmpty(I.feedContent)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (I != null) {
                richStatus = com.tencent.mobileqq.richstatus.c.e(I);
            } else {
                richStatus = null;
            }
            if (richStatus != null && richStatus != RichStatus.getEmptyStatus() && !richStatus.isEmpty()) {
                z17 = true;
            }
            if (z16 && (I.feedTime > I.richTime || !z17)) {
                str5 = new String(I.feedContent);
            } else {
                if (richStatus != null) {
                    str4 = richStatus.getPlainText();
                } else {
                    str4 = "";
                }
                str5 = str4;
            }
            if (!TextUtils.isEmpty(str5)) {
                sb5.append(".");
                sb5.append(str5);
            }
            view.setContentDescription(sb5);
        }
    }

    private void r(Friends friends, NTVasSimpleInfo nTVasSimpleInfo) {
        nTVasSimpleInfo.qqVipInfo = friends.qqVipInfo;
        nTVasSimpleInfo.superQqInfo = friends.superQqInfo;
        nTVasSimpleInfo.superVipInfo = friends.superVipInfo;
        nTVasSimpleInfo.bigClubInfo = friends.bigClubInfo;
        nTVasSimpleInfo.nameplateVipType = friends.nameplateVipType;
        nTVasSimpleInfo.grayNameplateFlag = friends.grayNameplateFlag;
        nTVasSimpleInfo.namePlateOfKingGameId = friends.namePlateOfKingGameId;
        nTVasSimpleInfo.namePlateOfKingDan = friends.namePlateOfKingDan;
        nTVasSimpleInfo.namePlateOfKingDanDisplatSwitch = Boolean.valueOf(friends.namePlateOfKingDanDisplatSwitch);
        nTVasSimpleInfo.gameCardId = friends.gameCardId;
        nTVasSimpleInfo.namePlateOfKingLoginTime = friends.namePlateOfKingLoginTime;
    }

    private String s(int i3, IPhoneContactService iPhoneContactService) {
        String offlineTipsConfig;
        FriendListHandler friendListHandler = (FriendListHandler) this.f181503c.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        switch (i3) {
            case 1:
                return this.f181504d.getString(R.string.hpd);
            case 2:
                return this.f181504d.getString(R.string.hpg);
            case 3:
                return this.f181504d.getString(R.string.hpu);
            case 4:
            case 8:
                return ac.P(this.f181578m.netTypeIconId);
            case 5:
            default:
                long lastLoginType = this.f181578m.getLastLoginType();
                if ((iPhoneContactService.getUIBits() & 2) == 2 && lastLoginType == 1) {
                    offlineTipsConfig = HardCodeUtil.qqStr(R.string.f171674k44);
                } else {
                    offlineTipsConfig = friendListHandler.getOfflineTipsConfig(lastLoginType);
                }
                if (offlineTipsConfig == null) {
                    return this.f181504d.getString(R.string.hps);
                }
                return offlineTipsConfig;
            case 6:
                return "";
            case 7:
                return this.f181504d.getString(R.string.hpm);
        }
    }

    private void t() {
        this.f181501a = b(this.f181504d);
        SpecialCareInfo O = this.f181576k.O(this.f181578m.uin);
        if (O != null && O.globalSwitch != 0) {
            this.f181502b |= 1;
        } else {
            this.f181502b &= -2;
        }
    }

    private void v(a aVar, String str) {
        aVar.C.setVisibility(0);
        if (Utils.G(this.f181578m.uin)) {
            aVar.N = false;
            aVar.C.setVisibility(8);
        }
        if (((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).bindOnlineStatusView(this.f181503c, this.f181578m, aVar.P)) {
            aVar.P.setVisibility(0);
            str = "";
        } else {
            aVar.P.setVisibility(8);
        }
        if (!TextUtils.isEmpty(str)) {
            aVar.C.setText("[" + str + "]");
            aVar.C.setVisibility(0);
            return;
        }
        aVar.C.setText("");
        aVar.C.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.c
    public View a(int i3, int i16, View view, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        View createView;
        a aVar;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), view, viewGroup, onClickListener);
        }
        String str = "";
        IPhoneContactService iPhoneContactService = (IPhoneContactService) this.f181503c.getRuntimeService(IPhoneContactService.class, "");
        if (view != null && (view.getTag() instanceof a) && (!(view.getTag() instanceof a) || ((a) view.getTag()).M)) {
            aVar = (a) view.getTag();
            ((IVipColorName) QRoute.api(IVipColorName.class)).clearTextColorGradient(aVar.f181511h);
            aVar.f181512i.setCompoundDrawables(null, null);
            createView = view;
        } else {
            View inflate = LayoutInflater.from(this.f181504d).inflate(QUITokenResUtil.getResId(R.layout.f167805i2, R.layout.f167806e42), (ViewGroup) null);
            a a16 = ((FriendItemLayout) inflate).a();
            try {
                a16.E.setBackgroundResource(R.drawable.f162389gm1);
                a16.F.setImageDrawable(this.f181504d.getResources().getDrawable(R.drawable.f162390gm2));
            } catch (Exception e16) {
                QLog.e("BuddyListFriends", 1, e16.toString());
            } catch (OutOfMemoryError e17) {
                QLog.e("BuddyListFriends oom", 1, e17.toString());
            }
            createView = this.f181501a.createView(this.f181504d, inflate, a16, -1);
            a16.M = true;
            createView.setTag(a16);
            p(inflate.findViewById(R.id.icon));
            aVar = a16;
        }
        t();
        Friends friends = this.f181578m;
        aVar.f181513m = friends;
        String str2 = friends.uin;
        aVar.f187114d = str2;
        aVar.K.j(this.f181503c, str2, 3);
        Friends friends2 = this.f181578m;
        int a17 = com.tencent.mobileqq.friend.status.b.a(friends2.detalStatusFlag, friends2.iTermType);
        aVar.N = false;
        if (a17 != 0 && a17 != 6) {
            z16 = false;
        } else {
            z16 = true;
        }
        if ((iPhoneContactService.getUIBits() & 1) != 1) {
            j();
            aVar.f187116f.setEnableMask(z16);
            aVar.N = z16;
        }
        String s16 = s(a17, iPhoneContactService);
        v(aVar, s16);
        q(aVar);
        aVar.G.setVisibility(8);
        String friendNickWithAlias = this.f181578m.getFriendNickWithAlias();
        aVar.f181511h.setText(friendNickWithAlias);
        String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(this.f181578m.uin);
        NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(uidFromUin, "BuddyListFriends");
        if (vasSimpleInfoWithUid == null) {
            vasSimpleInfoWithUid = new NTVasSimpleInfo(uidFromUin, this.f181578m.uin);
            r(this.f181578m, vasSimpleInfoWithUid);
        }
        boolean simpleUISwitch = SimpleUIUtil.getSimpleUISwitch();
        if (!z16 && !simpleUISwitch && (r.c(vasSimpleInfoWithUid, EVIPSPEC.E_SP_SUPERQQ) || r.c(vasSimpleInfoWithUid, EVIPSPEC.E_SP_BIGCLUB) || r.c(vasSimpleInfoWithUid, EVIPSPEC.E_SP_SUPERVIP) || r.c(vasSimpleInfoWithUid, EVIPSPEC.E_SP_QQVIP))) {
            ((IVipColorName) QRoute.api(IVipColorName.class)).updateColorNameByUin(aVar.f181511h, this.f181578m.uin, true);
        } else {
            aVar.f181511h.setTextColor(c.c(this.f181504d, QUITokenResUtil.getResId(R.color.skin_black_theme_version2, R.color.qui_common_text_primary)));
            ((IVipColorName) QRoute.api(IVipColorName.class)).clearTextColorGradient(aVar.f181511h);
        }
        if (!simpleUISwitch) {
            ff.Y(aVar.f181511h, vasSimpleInfoWithUid, this.f181503c, this.f181504d);
        } else {
            aVar.f181511h.setCompoundDrawablesWithIntrinsicBounds(0, 0);
        }
        if (!simpleUISwitch) {
            IGameCardManager.a aVar2 = new IGameCardManager.a(this.f181578m.uin, vasSimpleInfoWithUid.namePlateOfKingGameId, vasSimpleInfoWithUid.namePlateOfKingDan, vasSimpleInfoWithUid.namePlateOfKingDanDisplatSwitch.booleanValue(), vasSimpleInfoWithUid.gameCardId);
            aVar2.f312733a = "list";
            VipGrayConfigHelper.getsInstance().updateNamePlateOfKingIconView(aVar.I, r.c(vasSimpleInfoWithUid, EVIPSPEC.E_SP_SUPERVIP), vasSimpleInfoWithUid.namePlateOfKingLoginTime, aVar2);
        } else if (aVar.I.getVisibility() != 8) {
            aVar.I.setVisibility(8);
        }
        in2.a.a(aVar.f181511h.getContext(), aVar.f181511h, this.f181578m.uin);
        aVar.f181512i.setVisibility(0);
        n(createView, (i3 << 16) | i16, aVar, onClickListener);
        o(aVar, s16, friendNickWithAlias, null, createView);
        Friends friends3 = this.f181578m;
        if (friends3 != null) {
            str = friends3.uin;
        }
        l(createView, 1, str);
        return createView;
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.c
    protected int[] e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (int[]) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return f181574p;
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.c
    protected int[] f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (int[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return f181575q;
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.c
    protected void g(int i3, SwipRightMenuBuilder.SwipRightMenuItem[] swipRightMenuItemArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) swipRightMenuItemArr);
            return;
        }
        if (swipRightMenuItemArr != null && swipRightMenuItemArr.length > 0) {
            int i16 = 0;
            if (swipRightMenuItemArr.length > 0 && this.f181578m.isFriend()) {
                if ((this.f181502b & 1) == 1) {
                    swipRightMenuItemArr[0].menuId = 0;
                } else {
                    swipRightMenuItemArr[0].menuId = 1;
                }
                swipRightMenuItemArr[0].menuType = 0;
                i16 = 1;
            }
            while (i16 < swipRightMenuItemArr.length) {
                SwipRightMenuBuilder.SwipRightMenuItem swipRightMenuItem = swipRightMenuItemArr[i16];
                swipRightMenuItem.menuId = -1;
                swipRightMenuItem.menuType = -1;
                i16++;
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.c
    protected int[] h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (int[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return f181573o;
    }

    protected void p(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
        } else if (view instanceof DynamicAvatarView) {
            DynamicAvatarView dynamicAvatarView = (DynamicAvatarView) view;
            if (dynamicAvatarView.K == null) {
                dynamicAvatarView.K = new ThemeImageWrapper();
            }
            dynamicAvatarView.K.setSupportMaskView(true);
        }
    }

    public String q(c.C7154c c7154c) {
        boolean z16;
        RichStatus richStatus;
        boolean z17;
        boolean z18;
        String plainText;
        int i3;
        int i16;
        boolean z19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) c7154c);
        }
        a aVar = (a) c7154c;
        int i17 = 0;
        ExtensionInfo I = this.f181576k.I(this.f181578m.uin, false);
        if (I != null && !TextUtils.isEmpty(I.feedContent)) {
            z16 = true;
        } else {
            z16 = false;
        }
        String str = null;
        if (I != null) {
            c.b bVar = this.f181507g;
            if (bVar != null) {
                i16 = bVar.a();
            } else {
                i16 = 0;
            }
            if (i16 != 0) {
                z19 = true;
            } else {
                z19 = false;
            }
            richStatus = com.tencent.mobileqq.richstatus.c.f(I, z19);
        } else {
            richStatus = null;
        }
        if (richStatus != null && richStatus != RichStatus.getEmptyStatus() && !richStatus.isEmpty()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 && !TextUtils.isEmpty(richStatus.actionText)) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z16 && (I.feedTime > I.richTime || !z17)) {
            plainText = new String(I.feedContent);
            aVar.f181512i.setCompoundDrawables(null, null);
            if (I.feedType == 2) {
                aVar.D.setVisibility(0);
                if (!TextUtils.isEmpty(I.feedPhotoUrl)) {
                    bp.a(aVar.D, I.feedPhotoUrl, this.f181504d.getResources().getDrawable(R.drawable.skin_my_story_video_take_video_no_bg));
                } else {
                    aVar.D.setImageDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(R.drawable.skin_my_story_video_take_video_no_bg));
                }
                aVar.E.setVisibility(8);
                aVar.F.setVisibility(8);
            } else {
                aVar.E.setVisibility(0);
                ImageView imageView = aVar.E;
                if (I.feedType == 1) {
                    i3 = R.drawable.f162391gm3;
                } else {
                    i3 = R.drawable.f162389gm1;
                }
                imageView.setBackgroundResource(i3);
                URLImageView uRLImageView = aVar.F;
                if (!I.feedHasPhoto) {
                    i17 = 8;
                }
                uRLImageView.setVisibility(i17);
                if (I.feedHasPhoto && !TextUtils.isEmpty(I.feedPhotoUrl)) {
                    w(aVar.F, I.feedPhotoUrl);
                }
                aVar.D.setVisibility(8);
                aVar.D.setImageDrawable(null);
            }
        } else {
            if (z18) {
                richStatus.enableSummaryCached = this.f181578m.isFriend();
                BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f181504d.getResources(), this.f181577l.K(richStatus.actionId, 200));
                int a16 = (int) al.a(this.f181504d, 12.0f);
                bitmapDrawable.setBounds(0, 0, Math.round(((bitmapDrawable.getIntrinsicWidth() * 1.0f) / bitmapDrawable.getIntrinsicHeight()) * a16), a16);
                aVar.f181512i.setCompoundDrawables(bitmapDrawable, null);
            } else if (!z17) {
                richStatus = RichStatus.getEmptyStatus();
                aVar.f181512i.setCompoundDrawables(null, null);
            }
            String actionAndData = richStatus.getActionAndData();
            plainText = richStatus.getPlainText();
            aVar.F.setVisibility(8);
            aVar.E.setVisibility(8);
            aVar.D.setVisibility(8);
            aVar.D.setImageDrawable(null);
            str = actionAndData;
        }
        if (I == null) {
            aVar.F.setVisibility(8);
            aVar.E.setVisibility(8);
        }
        aVar.f181512i.setExtendText(str, 1);
        aVar.f181512i.setText(plainText);
        return plainText;
    }

    public void u(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.f181579n = i3;
        }
    }

    public void w(URLImageView uRLImageView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) uRLImageView, (Object) str);
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = uRLImageView.getWidth();
        obtain.mRequestHeight = uRLImageView.getHeight();
        Drawable drawable = this.f181504d.getResources().getDrawable(R.drawable.f162390gm2);
        obtain.mFailedDrawable = drawable;
        obtain.mLoadingDrawable = drawable;
        URLDrawable drawable2 = URLDrawable.getDrawable(str, obtain);
        drawable2.setTag(com.tencent.mobileqq.urldrawable.a.c(uRLImageView.getWidth(), uRLImageView.getHeight(), ViewUtils.dip2px(2.0f)));
        drawable2.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306330j);
        uRLImageView.setImageDrawable(drawable2);
    }
}
