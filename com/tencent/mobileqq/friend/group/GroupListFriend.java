package com.tencent.mobileqq.friend.group;

import QQService.EVIPSPEC;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contacts.base.c;
import com.tencent.mobileqq.activity.contacts.friend.BuddyListFriends;
import com.tencent.mobileqq.activity.contacts.friend.FriendItemLayout;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.friend.group.d;
import com.tencent.mobileqq.mutualmark.view.MutualMarkIconsView;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
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
import com.tencent.mobileqq.vas.api.IVasRecentData;
import com.tencent.mobileqq.vas.vipicon.NamePlateVipType;
import com.tencent.mobileqq.vip.IGameCardManager;
import com.tencent.mobileqq.vip.api.IVipColorName;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.api.IVasInfoService;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.qqnt.ntrelation.zoneinfo.api.IZoneInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.relation.common.api.nameservice.IQQRelationNameService;
import com.tencent.theme.SkinEngine;
import com.tencent.util.QUITokenResUtil;
import com.tencent.widget.ThemeImageWrapper;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GroupListFriend extends com.tencent.mobileqq.activity.contacts.base.c {

    /* renamed from: o, reason: collision with root package name */
    private static String f211639o = "GroupListFriend";

    /* renamed from: p, reason: collision with root package name */
    public static final int[] f211640p = {R.string.a9d, R.string.a9e};

    /* renamed from: q, reason: collision with root package name */
    static final int[] f211641q = {R.drawable.cjb, R.drawable.cjb};

    /* renamed from: r, reason: collision with root package name */
    static final int[] f211642r = {R.id.eqg, R.id.eqg};

    /* renamed from: s, reason: collision with root package name */
    private static final HashMap<NamePlateVipType, String> f211643s = new HashMap<NamePlateVipType, String>() { // from class: com.tencent.mobileqq.friend.group.GroupListFriend.1
        {
            put(NamePlateVipType.QQVIP, "\u4f1a\u5458");
            put(NamePlateVipType.QQVIP_YEAR, "\u5e74\u8d39\u4f1a\u5458");
            put(NamePlateVipType.SUPERVIP, "\u8d85\u7ea7\u4f1a\u5458");
            put(NamePlateVipType.SUPERVIP_YEAR, "\u5e74\u8d39\u8d85\u7ea7\u4f1a\u5458");
            put(NamePlateVipType.BIGCLUB, "\u5927\u4f1a\u5458");
            put(NamePlateVipType.BIGCLUB_YEAR, "\u5e74\u8d39\u5927\u4f1a\u5458");
        }
    };

    /* renamed from: k, reason: collision with root package name */
    FriendsManager f211644k;

    /* renamed from: l, reason: collision with root package name */
    StatusManager f211645l;

    /* renamed from: m, reason: collision with root package name */
    private String f211646m;

    /* renamed from: n, reason: collision with root package name */
    private String f211647n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class a implements ff.f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BuddyListFriends.a f211648a;

        a(BuddyListFriends.a aVar) {
            this.f211648a = aVar;
        }

        @Override // com.tencent.mobileqq.utils.ff.f
        public void a(boolean z16) {
            MutualMarkIconsView mutualMarkIconsView;
            BuddyListFriends.a aVar = this.f211648a;
            if (aVar.J != null && (mutualMarkIconsView = aVar.K) != null) {
                this.f211648a.J.setVisibility((!z16 || mutualMarkIconsView.d() <= 0) ? 8 : 0);
            } else {
                QLog.d(GroupListFriend.f211639o, 1, "tag.splitView == null");
            }
        }
    }

    public GroupListFriend(QQAppInterface qQAppInterface, Context context, String str) {
        this(qQAppInterface, context, null, str);
    }

    private void A() {
        this.f181501a = b(this.f181504d);
        if (!((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getSpecialCareGlobalSwitch(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getFriendUidFromUin(this.f211647n), f211639o)) {
            this.f181502b &= -2;
        } else {
            this.f181502b |= 1;
        }
    }

    private boolean C(int i3) {
        if (i3 != 0 && i3 != 6) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void D(BuddyListFriends.a aVar, boolean z16) {
        MutualMarkIconsView mutualMarkIconsView;
        if (aVar.J != null && (mutualMarkIconsView = aVar.K) != null) {
            aVar.J.setVisibility((!z16 || mutualMarkIconsView.d() <= 0) ? 8 : 0);
        } else {
            QLog.i(f211639o, 1, "tag.splitView == null || tag.mutualMarkIconsView == null");
        }
    }

    private String E() {
        com.tencent.relation.common.bean.nameservice.a aVar = new com.tencent.relation.common.bean.nameservice.a();
        aVar.d(this.f211646m);
        return ((IQQRelationNameService) QRoute.api(IQQRelationNameService.class)).nameWithConfig(aVar);
    }

    private void F(final BuddyListFriends.a aVar) {
        ff.i iVar = new ff.i();
        NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(this.f211646m, f211639o);
        if (vasSimpleInfoWithUid == null) {
            aVar.I.setVisibility(8);
            aVar.J.setVisibility(8);
        } else {
            iVar.f307794a = vasSimpleInfoWithUid.getUin();
            IGameCardManager.a aVar2 = new IGameCardManager.a(vasSimpleInfoWithUid.getUin(), vasSimpleInfoWithUid.namePlateOfKingGameId, vasSimpleInfoWithUid.namePlateOfKingDan, vasSimpleInfoWithUid.namePlateOfKingDanDisplatSwitch.booleanValue(), vasSimpleInfoWithUid.gameCardId);
            aVar2.f312733a = "list";
            VipGrayConfigHelper.getsInstance().updateNamePlateOfKingIconView(aVar.I, d.INSTANCE.a(EVIPSPEC.E_SP_SUPERVIP, this.f211646m), vasSimpleInfoWithUid.namePlateOfKingLoginTime, aVar2, new VipGrayConfigHelper.c() { // from class: com.tencent.mobileqq.friend.group.a
                @Override // com.tencent.mobileqq.vas.VipGrayConfigHelper.c
                public final void a(boolean z16) {
                    GroupListFriend.D(BuddyListFriends.a.this, z16);
                }
            });
        }
    }

    private void G(BuddyListFriends.a aVar, String str) {
        aVar.C.setVisibility(0);
        if (Utils.G(this.f211647n)) {
            aVar.N = false;
            aVar.C.setVisibility(8);
        }
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c onlineStatusSimpleInfoWithUid = ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).getOnlineStatusSimpleInfoWithUid(this.f211646m, f211639o);
        if (onlineStatusSimpleInfoWithUid == null) {
            QLog.e(f211639o, 1, "null == NTOnlineStatusSimpleInfo");
            return;
        }
        if (((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).bindOnlineStatusView(this.f181503c, onlineStatusSimpleInfoWithUid, aVar.P)) {
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

    private void I(BuddyListFriends.a aVar, RichStatus richStatus) {
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(this.f211646m, f211639o);
        if (friendsSimpleInfoWithUid == null) {
            richStatus.enableSummaryCached = false;
        } else {
            richStatus.enableSummaryCached = friendsSimpleInfoWithUid.f() > 0;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f181504d.getResources(), this.f211645l.K(richStatus.actionId, 200));
        int a16 = (int) al.a(this.f181504d, 12.0f);
        bitmapDrawable.setBounds(0, 0, Math.round(((bitmapDrawable.getIntrinsicWidth() * 1.0f) / bitmapDrawable.getIntrinsicHeight()) * a16), a16);
        aVar.f181512i.setCompoundDrawables(bitmapDrawable, null);
    }

    private void J(BuddyListFriends.a aVar) {
        ff.i iVar = new ff.i();
        NTVasSimpleInfo vasSimpleInfoWithUid = ((IVasInfoService) QRoute.api(IVasInfoService.class)).getVasSimpleInfoWithUid(this.f211646m, f211639o);
        if (vasSimpleInfoWithUid == null) {
            aVar.f181511h.setCompoundDrawablesWithIntrinsicBounds(0, 0);
            return;
        }
        iVar.f307794a = this.f211647n;
        iVar.f307795b = vasSimpleInfoWithUid.nameplateVipType;
        iVar.f307796c = vasSimpleInfoWithUid.grayNameplateFlag;
        iVar.f307797d = vasSimpleInfoWithUid.qqVipInfo;
        iVar.f307799f = vasSimpleInfoWithUid.superVipInfo;
        iVar.f307800g = vasSimpleInfoWithUid.bigClubInfo;
        ff.X(aVar.f181511h, iVar, this.f181503c, this.f181504d, new a(aVar));
    }

    private void q(BuddyListFriends.a aVar, String str, String str2, String str3, View view) {
        String charSequence;
        String plainText;
        if (AppSetting.f99565y) {
            StringBuilder sb5 = aVar.L;
            boolean z16 = false;
            if (sb5 == null) {
                sb5 = new StringBuilder(24);
            } else {
                sb5.delete(0, sb5.length());
            }
            sb5.append(str2);
            sb5.append(".");
            IVasRecentData.FriendsVipData friendsVipData = ((IVasRecentData) QRoute.api(IVasRecentData.class)).getFriendsVipData(this.f211647n);
            NamePlateVipType convert = NamePlateVipType.convert(friendsVipData.getVipType());
            HashMap<NamePlateVipType, String> hashMap = f211643s;
            if (hashMap.containsKey(convert)) {
                sb5.append(hashMap.get(convert));
                sb5.append(friendsVipData.getVipLevel());
                sb5.append("\u7ea7.");
            }
            if (aVar.C.getVisibility() == 0) {
                charSequence = aVar.C.a().toString();
            } else {
                charSequence = aVar.P.getVisibility() == 0 ? aVar.P.a().toString() : "";
            }
            if (!TextUtils.isEmpty(charSequence)) {
                str = charSequence.replace("[", "").replace("]", "");
            }
            sb5.append(str);
            sb5.append(".");
            if (!TextUtils.isEmpty(str3)) {
                sb5.append(str3);
                sb5.append(".");
            }
            if (!TextUtils.isEmpty(aVar.K.D)) {
                sb5.append(aVar.K.D.toString());
            }
            ExtensionInfo I = this.f211644k.I(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(this.f211646m), false);
            boolean z17 = (I == null || TextUtils.isEmpty(I.feedContent)) ? false : true;
            RichStatus e16 = I != null ? com.tencent.mobileqq.richstatus.c.e(I) : null;
            if (e16 != null && e16 != RichStatus.getEmptyStatus() && !e16.isEmpty()) {
                z16 = true;
            }
            if (z17 && (I.feedTime > I.richTime || !z16)) {
                plainText = new String(I.feedContent);
            } else {
                plainText = e16 != null ? e16.getPlainText() : "";
            }
            if (!TextUtils.isEmpty(plainText)) {
                sb5.append(".");
                sb5.append(plainText);
            }
            view.setContentDescription(sb5);
            aVar.I.setContentDescription(HardCodeUtil.qqStr(R.string.f161831ys));
        }
    }

    private int y() {
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c onlineStatusSimpleInfoWithUid = ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).getOnlineStatusSimpleInfoWithUid(this.f211646m, f211639o);
        if (onlineStatusSimpleInfoWithUid == null) {
            return 0;
        }
        return com.tencent.mobileqq.friend.status.b.a(onlineStatusSimpleInfoWithUid.u(), onlineStatusSimpleInfoWithUid.z());
    }

    private String z(int i3, IPhoneContactService iPhoneContactService) {
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
                com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c onlineStatusSimpleInfoWithUid = ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).getOnlineStatusSimpleInfoWithUid(this.f211646m, f211639o);
                if (onlineStatusSimpleInfoWithUid != null) {
                    return ac.P(onlineStatusSimpleInfoWithUid.C());
                }
                return null;
            case 5:
            default:
                com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c onlineStatusSimpleInfoWithUid2 = ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).getOnlineStatusSimpleInfoWithUid(this.f211646m, f211639o);
                if (onlineStatusSimpleInfoWithUid2 != null) {
                    long B = onlineStatusSimpleInfoWithUid2.B();
                    if ((iPhoneContactService.getUIBits() & 2) == 2 && B == 1) {
                        offlineTipsConfig = HardCodeUtil.qqStr(R.string.f171674k44);
                    } else {
                        offlineTipsConfig = friendListHandler.getOfflineTipsConfig(B);
                    }
                    return offlineTipsConfig == null ? this.f181504d.getString(R.string.hps) : offlineTipsConfig;
                }
                return null;
            case 6:
                return "";
            case 7:
                return this.f181504d.getString(R.string.hpm);
        }
    }

    public void H(URLImageView uRLImageView, String str) {
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

    @Override // com.tencent.mobileqq.activity.contacts.base.c
    public View a(int i3, int i16, View view, ViewGroup viewGroup, View.OnClickListener onClickListener) {
        if (this.f211646m == null) {
            QLog.d(f211639o, 2, "uid is null");
            return null;
        }
        IPhoneContactService iPhoneContactService = (IPhoneContactService) this.f181503c.getRuntimeService(IPhoneContactService.class, "");
        View r16 = r(view);
        BuddyListFriends.a B = B(r16);
        boolean simpleUISwitch = SimpleUIUtil.getSimpleUISwitch();
        A();
        if (B == null) {
            QLog.d(f211639o, 2, "tag is null");
            return null;
        }
        B.J.setVisibility(8);
        B.K.k(this.f181503c, this.f211647n, 3, true);
        int y16 = y();
        boolean C = C(y16);
        String z16 = z(y16, iPhoneContactService);
        u(B, z16, C, iPhoneContactService);
        w(B);
        B.G.setVisibility(8);
        String E = E();
        t(B, C, simpleUISwitch, E);
        v(B, simpleUISwitch);
        in2.a.a(B.f181511h.getContext(), B.f181511h, this.f211647n);
        B.f181512i.setVisibility(0);
        n(r16, (i3 << 16) | i16, B, onClickListener);
        q(B, z16, E, null, r16);
        l(r16, 1, this.f211646m != null ? this.f211647n : "");
        return r16;
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.c
    protected int[] e() {
        return f211641q;
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.c
    protected int[] f() {
        return f211642r;
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.c
    protected int[] h() {
        return f211640p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(View view) {
        if (view instanceof DynamicAvatarView) {
            DynamicAvatarView dynamicAvatarView = (DynamicAvatarView) view;
            if (dynamicAvatarView.K == null) {
                dynamicAvatarView.K = new ThemeImageWrapper();
            }
            dynamicAvatarView.K.setSupportMaskView(true);
        }
    }

    public String w(c.C7154c c7154c) {
        RichStatus richStatus;
        String str;
        BuddyListFriends.a aVar = (BuddyListFriends.a) c7154c;
        com.tencent.qqnt.ntrelation.zoneinfo.bean.c zoneSimpleInfoWithUid = ((IZoneInfoService) QRoute.api(IZoneInfoService.class)).getZoneSimpleInfoWithUid(this.f211646m, f211639o);
        com.tencent.qqnt.ntrelation.friendsinfo.bean.d friendsSimpleInfoWithUid = ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(this.f211646m, f211639o);
        boolean z16 = (zoneSimpleInfoWithUid == null || TextUtils.isEmpty(zoneSimpleInfoWithUid.b())) ? false : true;
        String str2 = null;
        if (friendsSimpleInfoWithUid != null) {
            c.b bVar = this.f181507g;
            richStatus = com.tencent.mobileqq.richstatus.c.g(Long.valueOf(friendsSimpleInfoWithUid.t()), friendsSimpleInfoWithUid.s(), Boolean.valueOf((bVar != null ? bVar.a() : 0) != 0));
        } else {
            richStatus = null;
        }
        boolean z17 = (richStatus == null || richStatus == RichStatus.getEmptyStatus() || richStatus.isEmpty()) ? false : true;
        boolean z18 = z17 && !TextUtils.isEmpty(richStatus.actionText);
        if (z16 && friendsSimpleInfoWithUid != null && (zoneSimpleInfoWithUid.f() > friendsSimpleInfoWithUid.t() || !z17)) {
            str = zoneSimpleInfoWithUid.b();
            aVar.f181512i.setCompoundDrawables(null, null);
            if (zoneSimpleInfoWithUid.j() == 2) {
                aVar.D.setVisibility(0);
                if (!TextUtils.isEmpty(zoneSimpleInfoWithUid.e())) {
                    bp.a(aVar.D, zoneSimpleInfoWithUid.e(), this.f181504d.getResources().getDrawable(R.drawable.skin_my_story_video_take_video_no_bg));
                } else {
                    aVar.D.setImageDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(R.drawable.skin_my_story_video_take_video_no_bg));
                }
                aVar.E.setVisibility(8);
                aVar.F.setVisibility(8);
            } else {
                aVar.E.setVisibility(0);
                aVar.E.setBackgroundResource(zoneSimpleInfoWithUid.j() == 1 ? R.drawable.f162391gm3 : R.drawable.f162389gm1);
                aVar.F.setVisibility(zoneSimpleInfoWithUid.c() ? 0 : 8);
                if (zoneSimpleInfoWithUid.c() && !TextUtils.isEmpty(zoneSimpleInfoWithUid.e())) {
                    H(aVar.F, zoneSimpleInfoWithUid.e());
                }
                aVar.D.setVisibility(8);
                aVar.D.setImageDrawable(null);
            }
        } else {
            if (z18) {
                I(aVar, richStatus);
            } else if (!z17) {
                richStatus = RichStatus.getEmptyStatus();
                aVar.f181512i.setCompoundDrawables(null, null);
            }
            String actionAndData = richStatus.getActionAndData();
            String plainText = richStatus.getPlainText();
            aVar.F.setVisibility(8);
            aVar.E.setVisibility(8);
            aVar.D.setVisibility(8);
            aVar.D.setImageDrawable(null);
            str2 = actionAndData;
            str = plainText;
        }
        if (zoneSimpleInfoWithUid == null) {
            aVar.F.setVisibility(8);
            aVar.E.setVisibility(8);
        }
        aVar.f181512i.setExtendText(str2, 1);
        aVar.f181512i.setText(str);
        return str;
    }

    public com.tencent.qqnt.ntrelation.friendsinfo.bean.d x() {
        return ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getFriendsSimpleInfoWithUid(this.f211646m, f211639o);
    }

    @Deprecated
    public GroupListFriend(QQAppInterface qQAppInterface, Context context, Entity entity, String str) {
        super(qQAppInterface, context, entity);
        this.f211646m = str;
        String uinFromUid = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(str);
        this.f211647n = uinFromUid;
        if (TextUtils.isEmpty(uinFromUid)) {
            QLog.i(f211639o, 1, "uin is empty");
        }
        this.f211644k = (FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        this.f211645l = (StatusManager) qQAppInterface.getManager(QQManagerFactory.STATUS_MANAGER);
        A();
    }

    private void v(BuddyListFriends.a aVar, boolean z16) {
        if (aVar == null) {
            QLog.i(f211639o, 1, "dealWangZhe null return");
            return;
        }
        if (!z16) {
            F(aVar);
        } else if (aVar.I.getVisibility() != 8) {
            aVar.I.setVisibility(8);
            aVar.J.setVisibility(8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void t(BuddyListFriends.a aVar, boolean z16, boolean z17, String str) {
        if (aVar == null) {
            QLog.i(f211639o, 1, "dealNick null return");
            return;
        }
        aVar.f181511h.setText(str);
        if (!z16 && !z17) {
            d.Companion companion = d.INSTANCE;
            if (companion.a(EVIPSPEC.E_SP_SUPERQQ, this.f211646m) || companion.a(EVIPSPEC.E_SP_BIGCLUB, this.f211646m) || companion.a(EVIPSPEC.E_SP_SUPERVIP, this.f211646m) || companion.a(EVIPSPEC.E_SP_QQVIP, this.f211646m)) {
                ((IVipColorName) QRoute.api(IVipColorName.class)).updateColorNameByUin(aVar.f181511h, this.f211647n, true);
                if (z17) {
                    J(aVar);
                    return;
                } else {
                    aVar.f181511h.setCompoundDrawablesWithIntrinsicBounds(0, 0);
                    aVar.J.setVisibility(8);
                    return;
                }
            }
        }
        aVar.f181511h.setTextColor(com.tencent.mobileqq.activity.contacts.base.c.c(this.f181504d, QUITokenResUtil.getResId(R.color.skin_black_theme_version2, R.color.qui_common_text_primary)));
        ((IVipColorName) QRoute.api(IVipColorName.class)).clearTextColorGradient(aVar.f181511h);
        if (z17) {
        }
    }

    private BuddyListFriends.a B(View view) {
        if (view == null || !(view.getTag() instanceof BuddyListFriends.a)) {
            return null;
        }
        BuddyListFriends.a aVar = (BuddyListFriends.a) view.getTag();
        ((IVipColorName) QRoute.api(IVipColorName.class)).clearTextColorGradient(aVar.f181511h);
        aVar.f181512i.setCompoundDrawables(null, null);
        aVar.f181513m = this.f211646m;
        aVar.f187114d = this.f211647n;
        return aVar;
    }

    private View r(View view) {
        if (view != null && (view.getTag() instanceof BuddyListFriends.a) && ((BuddyListFriends.a) view.getTag()).M) {
            view.findViewById(R.id.v4v).setBackground(this.f181504d.getResources().getDrawable(R.drawable.jiv));
            return view;
        }
        View inflate = LayoutInflater.from(this.f181504d).inflate(QUITokenResUtil.getResId(R.layout.f167805i2, R.layout.f167806e42), (ViewGroup) null);
        BuddyListFriends.a a16 = ((FriendItemLayout) inflate).a();
        try {
            a16.E.setBackgroundResource(R.drawable.f162389gm1);
            a16.F.setImageDrawable(this.f181504d.getResources().getDrawable(R.drawable.f162390gm2));
        } catch (Exception e16) {
            QLog.e("BuddyListFriends", 1, e16.toString());
        } catch (OutOfMemoryError e17) {
            QLog.e("BuddyListFriends oom", 1, e17.toString());
        }
        View createView = this.f181501a.createView(this.f181504d, inflate, a16, -1);
        createView.setBackground(this.f181504d.getResources().getDrawable(R.drawable.jiv));
        a16.M = true;
        createView.setTag(a16);
        s(inflate.findViewById(R.id.icon));
        return createView;
    }

    private void u(BuddyListFriends.a aVar, String str, boolean z16, IPhoneContactService iPhoneContactService) {
        if (aVar != null && iPhoneContactService != null) {
            aVar.N = false;
            if ((iPhoneContactService.getUIBits() & 1) != 1) {
                aVar.f187116f.setEnableMask(z16);
                aVar.N = z16;
            }
            G(aVar, str);
            return;
        }
        QLog.i(f211639o, 1, "dealStatus null return");
    }
}
