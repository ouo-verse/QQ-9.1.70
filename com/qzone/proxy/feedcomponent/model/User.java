package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_COMM.combine_diamond_info;
import NS_MOBILE_COMM.star_info;
import NS_MOBILE_FEEDS.s_user;
import android.os.Parcel;
import android.text.TextUtils;
import com.qzone.publish.ui.model.QzoneVipCommentIconInfo;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.component.media.image.ImageUrl;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes39.dex */
public class User implements SmartParcelable {
    public static final String USER_TAB = "user_des";

    @NeedParcel
    public int actiontype;

    @NeedParcel
    public int age;

    @NeedParcel
    public int avatarDecorationId;

    @NeedParcel
    public int avatarDecorationType;

    @NeedParcel
    public String avatarPath;

    @NeedParcel
    public String avatarRecomBar;

    @NeedParcel
    public ImageUrl avatarRedPocketIconImageUrl;

    @NeedParcel
    public int cmPraiseActionid;

    @NeedParcel
    public int comDiamondLevel;

    @NeedParcel
    public int comDiamondType;

    @NeedParcel
    public int curUserType;

    @NeedParcel
    public CustomPraiseData customPraiseData;

    @NeedParcel
    public int customType;

    @NeedParcel
    public String descToken;

    @NeedParcel
    public String descicon;

    @NeedParcel
    public ImageUrl desciconImageUrl;
    public String desuniKey;

    @NeedParcel
    public int displayflag;

    @NeedParcel
    public long eUserTypeReport;

    @NeedParcel
    public UserMedal famousSpaceMedal;

    @NeedParcel
    public long fansCount;

    @NeedParcel
    public ImageUrl feedAvatarDecorationImageUrl;

    @NeedParcel
    public String feedAvatarDecorationJumpUrl;

    @NeedParcel
    public String feedAvatarDecorationUrl;

    @NeedParcel
    public int from;

    @NeedParcel
    public String guestCustomIconUrl;

    @NeedParcel
    public String hostCustomIconUrl;
    public Integer integerDesuniKey;

    @NeedParcel
    public byte isAnnualVip;

    @NeedParcel
    public byte isAnnualVipEver;

    @NeedParcel
    public int isCmtVerifyOpen;

    @NeedParcel
    public byte isComDiamondAnnualVip;

    @NeedParcel
    public int isFamousWhite;

    @NeedParcel
    public byte isHighStarVip;

    @NeedParcel
    public byte isNickNameFlash;

    @NeedParcel
    public int isOwner;

    @NeedParcel
    public int isPrivateMode;
    public int isQzoneUser;

    @NeedParcel
    public byte isSafeModeUser;

    @NeedParcel
    public byte isStarAnnualVip;

    @NeedParcel
    public int isSweetVip;

    @NeedParcel
    public int isVideoCircleVUser;

    @NeedParcel
    public int is_own;

    @NeedParcel
    public String logo;

    @NeedParcel
    public ImageUrl logoImageUrl;
    public String nameSeperate;

    @NeedParcel
    public String nickName;
    public Integer nickNameAreaCacheKey;

    @NeedParcel
    public int opMask;

    @NeedParcel
    public int personalizedPassivePraiseId;

    @NeedParcel
    public int personalizedPassivePraiseType;

    @NeedParcel
    public String personalizedPassivePraiseUrl;

    @NeedParcel
    public String personalizedYellowVipUrl;

    @NeedParcel
    public int portrait_id;

    @NeedParcel
    public String qzoneDesc;

    @NeedParcel
    public int qzoneUserType;

    @NeedParcel
    public int starLevel;

    @NeedParcel
    public int starStatus;

    @NeedParcel
    public String strPortraitId;

    @NeedParcel
    public int superLike;

    @NeedParcel
    public String talkId;

    @NeedParcel
    public int timestamp;

    @NeedParcel
    public long uFeedsCount;

    @NeedParcel
    public String uid;

    @NeedParcel
    public long uin;

    @NeedParcel
    public String uinKey;

    @NeedParcel
    public String underNicknameDesc;

    @NeedParcel
    public int vip;

    @NeedParcel
    public QzoneVipCommentIconInfo vipCommentInfo;

    @NeedParcel
    public int vipLevel;

    @NeedParcel
    public byte vipShowType;

    @NeedParcel
    public long visitorCount;
    public String yellowDiamondUrl;

    @NeedParcel
    public String actionurl = "";

    @NeedParcel
    public boolean isCustomDiamond = false;

    @NeedParcel
    public String customDiamondUrl = "";

    @NeedParcel
    public byte sex = 0;

    public User() {
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<User> arrayFromCacheString(String str) {
        Parcel parcel;
        byte[] b16;
        ArrayList<User> arrayList = new ArrayList<>();
        Parcel parcel2 = null;
        r1 = null;
        ArrayList arrayList2 = null;
        try {
            b16 = com.qzone.proxy.feedcomponent.util.b.b(str.getBytes(), 0);
            parcel = Parcel.obtain();
        } catch (Exception unused) {
            parcel = null;
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            parcel.unmarshall(b16, 0, b16.length);
            parcel.setDataPosition(0);
            ArrayList arrayList3 = (ArrayList) parcel.readValue(ArrayList.class.getClassLoader());
            OaidMonitor.parcelRecycle(parcel);
            arrayList2 = arrayList3;
        } catch (Exception unused2) {
            if (parcel != null) {
                OaidMonitor.parcelRecycle(parcel);
            }
            if (arrayList2 != null) {
            }
            return arrayList;
        } catch (Throwable th6) {
            th = th6;
            parcel2 = parcel;
            if (parcel2 != null) {
                OaidMonitor.parcelRecycle(parcel2);
            }
            throw th;
        }
        if (arrayList2 != null) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add(fromString((String) it.next()));
            }
        }
        return arrayList;
    }

    public static ArrayList<User> fromSUserList(ArrayList<s_user> arrayList) {
        ArrayList<User> arrayList2 = new ArrayList<>();
        if (arrayList != null) {
            Iterator<s_user> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(fromSUser(it.next()));
            }
        }
        return arrayList2;
    }

    public static int getLikeType(int i3, boolean z16) {
        if (z16 && i3 == 1) {
            return 2;
        }
        if (z16) {
            return 1;
        }
        return 0;
    }

    public static boolean isLiked(int i3) {
        if (i3 == 0) {
            return false;
        }
        return true;
    }

    public static int likeTypeToSuperLike(int i3) {
        if (i3 == 1) {
            return 0;
        }
        if (i3 == 2) {
            return 1;
        }
        return -1;
    }

    public boolean isCircleVip() {
        return this.isVideoCircleVUser == 1;
    }

    public boolean isEmpty() {
        return (((this.uin + ((long) this.timestamp)) + ((long) this.from)) + ((long) this.vip)) + ((long) this.vipLevel) <= 0 && TextUtils.isEmpty(this.nickName) && TextUtils.isEmpty(this.uinKey) && TextUtils.isEmpty(this.logo);
    }

    public boolean isEnableShowIcon(long j3) {
        return (j3 & ((long) this.vipShowType)) != 0;
    }

    public void readFrom(Parcel parcel) {
        this.uin = parcel.readLong();
        this.nickName = parcel.readString();
        this.timestamp = parcel.readInt();
        this.from = parcel.readInt();
        this.uinKey = parcel.readString();
        this.logo = parcel.readString();
        this.vip = parcel.readInt();
        this.vipLevel = parcel.readInt();
        this.qzoneDesc = parcel.readString();
        this.isOwner = parcel.readInt();
        this.opMask = parcel.readInt();
        this.uid = parcel.readString();
        this.talkId = parcel.readString();
        this.portrait_id = parcel.readInt();
        this.is_own = parcel.readInt();
        this.isFamousWhite = parcel.readInt();
        this.qzoneUserType = parcel.readInt();
        this.isAnnualVip = parcel.readByte();
        this.isNickNameFlash = parcel.readByte();
        this.superLike = parcel.readInt();
        this.starStatus = parcel.readInt();
        this.starLevel = parcel.readInt();
        this.isStarAnnualVip = parcel.readByte();
        this.isHighStarVip = parcel.readByte();
        this.comDiamondType = parcel.readInt();
        this.comDiamondLevel = parcel.readInt();
        this.isComDiamondAnnualVip = parcel.readByte();
        this.isAnnualVipEver = parcel.readByte();
        this.isSweetVip = parcel.readInt();
        this.isSafeModeUser = parcel.readByte();
        this.vipShowType = parcel.readByte();
        this.actiontype = parcel.readInt();
        this.actionurl = parcel.readString();
        this.personalizedYellowVipUrl = parcel.readString();
        this.avatarDecorationId = parcel.readInt();
        this.avatarDecorationType = parcel.readInt();
        this.feedAvatarDecorationUrl = parcel.readString();
        this.feedAvatarDecorationJumpUrl = parcel.readString();
        this.strPortraitId = parcel.readString();
        this.underNicknameDesc = parcel.readString();
        this.displayflag = parcel.readInt();
        this.customType = parcel.readInt();
        this.hostCustomIconUrl = parcel.readString();
        this.guestCustomIconUrl = parcel.readString();
        this.eUserTypeReport = parcel.readLong();
        this.descicon = parcel.readString();
        this.isCustomDiamond = parcel.readInt() != 0;
        this.customDiamondUrl = parcel.readString();
        this.avatarRecomBar = parcel.readString();
        this.sex = parcel.readByte();
        this.age = parcel.readInt();
        this.isVideoCircleVUser = parcel.readInt();
        this.uFeedsCount = parcel.readLong();
        this.descToken = parcel.readString();
    }

    public void set(long j3, String str) {
        this.uin = j3;
        this.nickName = str;
    }

    public String toCacheString() {
        Parcel obtain = Parcel.obtain();
        ParcelableWrapper.writeDataToParcel(obtain, 0, this);
        byte[] d16 = com.qzone.proxy.feedcomponent.util.b.d(obtain.marshall(), 0);
        OaidMonitor.parcelRecycle(obtain);
        return new String(d16);
    }

    public s_user toSUser() {
        s_user s_userVar = new s_user();
        s_userVar.from = this.from;
        s_userVar.logo = this.logo;
        s_userVar.nickname = this.nickName;
        s_userVar.timestamp = this.timestamp;
        s_userVar.uin = this.uin;
        s_userVar.uinkey = this.uinKey;
        s_userVar.vip = this.vip;
        s_userVar.viplevel = this.vipLevel;
        s_userVar.qzonedesc = this.qzoneDesc;
        s_userVar.is_owner = this.isOwner;
        s_userVar.isFamousWhite = this.isFamousWhite;
        s_userVar.isQzoneUser = this.qzoneUserType;
        s_userVar.eUserTypeReport = this.eUserTypeReport;
        s_userVar.isAnnualVip = this.isAnnualVip;
        s_userVar.isSetNickGlint = this.isNickNameFlash;
        star_info star_infoVar = s_userVar.stuStarInfo;
        star_infoVar.iStarStatus = this.starStatus;
        star_infoVar.iStarLevel = this.starLevel;
        star_infoVar.isAnnualVip = this.isStarAnnualVip;
        star_infoVar.isHighStarVip = this.isHighStarVip;
        combine_diamond_info combine_diamond_infoVar = s_userVar.stuCombineDiamondInfo;
        combine_diamond_infoVar.iShowType = this.comDiamondType;
        combine_diamond_infoVar.iVipLevel = this.comDiamondLevel;
        combine_diamond_infoVar.isAnnualVip = this.isComDiamondAnnualVip;
        combine_diamond_infoVar.isAnnualVipEver = this.isAnnualVipEver;
        s_userVar.isSweetVip = this.isSweetVip;
        s_userVar.isSafeModeUser = this.isSafeModeUser;
        s_userVar.vipShowType = this.vipShowType;
        s_userVar.actiontype = this.actiontype;
        s_userVar.actionurl = this.actionurl;
        s_userVar.strPortraitId = this.strPortraitId;
        s_userVar.under_nickname_desc = this.underNicknameDesc;
        s_userVar.uVisitorCount = this.visitorCount;
        s_userVar.isCmtVerifyOpen = this.isCmtVerifyOpen;
        s_userVar.uFansCount = this.fansCount;
        s_userVar.displayflag = this.displayflag;
        s_userVar.descicon = this.descicon;
        s_userVar.sex = this.sex;
        s_userVar.isVideoCircleVUser = this.isVideoCircleVUser;
        s_userVar.uFeedsCount = this.uFeedsCount;
        s_userVar.qzonedesc_token = this.descToken;
        return s_userVar;
    }

    public String toString() {
        return "User [uin=" + this.uin + ", nickName=" + this.nickName + "]";
    }

    public void writeTo(Parcel parcel) {
        parcel.writeLong(this.uin);
        parcel.writeString(this.nickName);
        parcel.writeInt(this.timestamp);
        parcel.writeInt(this.from);
        parcel.writeString(this.uinKey);
        parcel.writeString(this.logo);
        parcel.writeInt(this.vip);
        parcel.writeInt(this.vipLevel);
        parcel.writeString(this.qzoneDesc);
        parcel.writeInt(this.isOwner);
        parcel.writeInt(this.opMask);
        parcel.writeString(this.uid);
        parcel.writeString(this.talkId);
        parcel.writeInt(this.portrait_id);
        parcel.writeInt(this.is_own);
        parcel.writeInt(this.isFamousWhite);
        parcel.writeInt(this.qzoneUserType);
        parcel.writeByte(this.isAnnualVip);
        parcel.writeByte(this.isNickNameFlash);
        parcel.writeInt(this.superLike);
        parcel.writeInt(this.starStatus);
        parcel.writeInt(this.starLevel);
        parcel.writeByte(this.isStarAnnualVip);
        parcel.writeByte(this.isHighStarVip);
        parcel.writeInt(this.comDiamondType);
        parcel.writeInt(this.comDiamondLevel);
        parcel.writeByte(this.isComDiamondAnnualVip);
        parcel.writeByte(this.isAnnualVipEver);
        parcel.writeInt(this.isSweetVip);
        parcel.writeByte(this.isSafeModeUser);
        parcel.writeByte(this.vipShowType);
        parcel.writeInt(this.actiontype);
        parcel.writeString(this.actionurl);
        parcel.writeString(this.personalizedYellowVipUrl);
        parcel.writeInt(this.avatarDecorationId);
        parcel.writeInt(this.avatarDecorationType);
        parcel.writeString(this.feedAvatarDecorationUrl);
        parcel.writeString(this.feedAvatarDecorationJumpUrl);
        parcel.writeString(this.strPortraitId);
        parcel.writeString(this.underNicknameDesc);
        parcel.writeInt(this.displayflag);
        parcel.writeInt(this.customType);
        parcel.writeString(this.hostCustomIconUrl);
        parcel.writeString(this.guestCustomIconUrl);
        parcel.writeLong(this.eUserTypeReport);
        parcel.writeString(this.descicon);
        parcel.writeInt(this.isCustomDiamond ? 1 : 0);
        parcel.writeString(this.customDiamondUrl);
        parcel.writeString(this.avatarRecomBar);
        parcel.writeByte(this.sex);
        parcel.writeInt(this.age);
        parcel.writeInt(this.isVideoCircleVUser);
        parcel.writeLong(this.uFeedsCount);
        parcel.writeString(this.descToken);
    }

    public static User fromString(String str) {
        Parcel parcel;
        byte[] b16;
        Parcel parcel2 = null;
        try {
            b16 = com.qzone.proxy.feedcomponent.util.b.b(str.getBytes(), 0);
            parcel = Parcel.obtain();
        } catch (Exception unused) {
            parcel = null;
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            parcel.unmarshall(b16, 0, b16.length);
            parcel.setDataPosition(0);
            User user = (User) ParcelableWrapper.createDataFromParcel(parcel);
            OaidMonitor.parcelRecycle(parcel);
            return user;
        } catch (Exception unused2) {
            if (parcel == null) {
                return null;
            }
            OaidMonitor.parcelRecycle(parcel);
            return null;
        } catch (Throwable th6) {
            th = th6;
            parcel2 = parcel;
            if (parcel2 != null) {
                OaidMonitor.parcelRecycle(parcel2);
            }
            throw th;
        }
    }

    public static String arrayToCacheString(ArrayList<User> arrayList) {
        if (arrayList == null) {
            return "";
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<User> it = arrayList.iterator();
        while (it.hasNext()) {
            User next = it.next();
            if (next != null) {
                arrayList2.add(next.toCacheString());
            }
        }
        Parcel obtain = Parcel.obtain();
        obtain.writeValue(arrayList2);
        byte[] d16 = com.qzone.proxy.feedcomponent.util.b.d(obtain.marshall(), 0);
        OaidMonitor.parcelRecycle(obtain);
        return new String(d16);
    }

    public static User fromSUser(s_user s_userVar) {
        if (s_userVar == null) {
            return null;
        }
        User user = new User();
        user.from = s_userVar.from;
        String str = s_userVar.logo;
        user.logo = str;
        user.logoImageUrl = PictureUrl.calculateImageUrl(str);
        try {
            user.avatarRedPocketIconImageUrl = PictureUrl.calculateImageUrl(com.qzone.adapter.feedcomponent.i.H().N());
        } catch (Exception e16) {
            com.qzone.proxy.feedcomponent.b.c("User", e16.toString());
        }
        user.nickName = s_userVar.nickname;
        user.timestamp = s_userVar.timestamp;
        user.uin = s_userVar.uin;
        user.uinKey = s_userVar.uinkey;
        user.vip = s_userVar.vip;
        user.vipLevel = s_userVar.viplevel;
        String str2 = s_userVar.qzonedesc;
        if (str2 != null) {
            try {
                user.qzoneDesc = URLDecoder.decode(str2, "UTF-8");
            } catch (Exception e17) {
                e17.printStackTrace();
                user.qzoneDesc = s_userVar.qzonedesc;
            }
        }
        user.isOwner = s_userVar.is_owner;
        user.isFamousWhite = s_userVar.isFamousWhite;
        user.qzoneUserType = s_userVar.isQzoneUser;
        user.eUserTypeReport = s_userVar.eUserTypeReport;
        user.isAnnualVip = s_userVar.isAnnualVip;
        user.isNickNameFlash = s_userVar.isSetNickGlint;
        user.isSweetVip = s_userVar.isSweetVip;
        star_info star_infoVar = s_userVar.stuStarInfo;
        if (star_infoVar != null) {
            user.starStatus = star_infoVar.iStarStatus;
            user.starLevel = star_infoVar.iStarLevel;
            user.isStarAnnualVip = star_infoVar.isAnnualVip;
            user.isHighStarVip = star_infoVar.isHighStarVip;
        }
        combine_diamond_info combine_diamond_infoVar = s_userVar.stuCombineDiamondInfo;
        if (combine_diamond_infoVar != null) {
            user.comDiamondType = combine_diamond_infoVar.iShowType;
            user.comDiamondLevel = combine_diamond_infoVar.iVipLevel;
            user.isComDiamondAnnualVip = combine_diamond_infoVar.isAnnualVip;
            user.isAnnualVipEver = combine_diamond_infoVar.isAnnualVipEver;
        }
        user.isSafeModeUser = s_userVar.isSafeModeUser;
        user.vipShowType = s_userVar.vipShowType;
        user.actiontype = s_userVar.actiontype;
        user.actionurl = s_userVar.actionurl;
        user.strPortraitId = s_userVar.strPortraitId;
        user.underNicknameDesc = s_userVar.under_nickname_desc;
        user.fansCount = s_userVar.uFansCount;
        user.visitorCount = s_userVar.uVisitorCount;
        user.isCmtVerifyOpen = s_userVar.isCmtVerifyOpen;
        user.displayflag = s_userVar.displayflag;
        String str3 = s_userVar.descicon;
        user.descicon = str3;
        user.desciconImageUrl = PictureUrl.calculateImageUrl(str3);
        user.sex = s_userVar.sex;
        user.isPrivateMode = s_userVar.isPrivateMode;
        String str4 = s_userVar.avatarRecomBar;
        if (str4 != null) {
            try {
                user.avatarRecomBar = URLDecoder.decode(str4, "UTF-8");
            } catch (Exception e18) {
                e18.printStackTrace();
                user.avatarRecomBar = s_userVar.avatarRecomBar;
            }
        }
        user.age = s_userVar.age;
        user.isVideoCircleVUser = s_userVar.isVideoCircleVUser;
        user.uFeedsCount = s_userVar.uFeedsCount;
        user.descToken = s_userVar.qzonedesc_token;
        user.vipCommentInfo = QzoneVipCommentIconInfo.a(s_userVar.tmall_deco);
        return user;
    }

    public boolean isCanShowFamousIcon() {
        return isEnableShowIcon(4L);
    }

    public boolean isCanShowStarVip() {
        return isEnableShowIcon(2L);
    }

    public boolean isCanShowYellowVip() {
        return isEnableShowIcon(1L);
    }

    public User(long j3, String str) {
        this.uin = j3;
        this.nickName = str;
    }
}
