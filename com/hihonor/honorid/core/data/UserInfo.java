package com.hihonor.honorid.core.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import j2.c;
import j2.d;
import java.io.Serializable;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlSerializer;

/* compiled from: P */
/* loaded from: classes2.dex */
public class UserInfo implements Parcelable, Serializable {
    public static final String ADDRESS = "address";
    public static final String AGE = "age";
    public static final String AGEGROUPFLAG = "ageGroupFlag";
    public static final String BIRTHDATE = "birthDate";
    public static final String CITY = "city";
    public static final String CLOUDACCOUNT = "cloudAccount";
    public static final Parcelable.Creator<UserInfo> CREATOR = new a();
    public static final String CTFCODE = "ctfCode";
    public static final String CTFTYPE = "ctfType";
    public static final String CTFVERIFYFLAG = "ctfVerifyFlag";
    public static final String FIRSTNAME = "firstName";
    public static final String GENDER = "gender";
    public static final String GUARDIAN_ACCOUNT = "guardianAccount";
    public static final String GUARDIAN_USER_ID = "guardianUserID";
    public static final String HEADPICTUREURL = "headPictureURL";
    public static final String INVITER = "Inviter";
    public static final String INVITER_USERID = "InviterUserID";
    public static final String LANGUAGECODE = "languageCode";
    public static final String LASTNAME = "lastName";
    public static final String LOGIN_NOTICE = "loginnotice";
    public static final String LOGIN_USER_NAME = "loginUserName";
    public static final String LOGIN_USER_NAME_FLAG = "loginUserNameFlag";
    public static final String NATIONALCODE = "nationalCode";
    public static final String NICKNAME = "nickName";
    public static final String OCCUPATION = "occupation";
    public static final String PASSWORDANWSER = "passwordAnswer";
    public static final String PASSWORDPROMPT = "passwordPrompt";
    public static final String PROVINCE = "province";
    public static final String RESET_PASSWD_MODE = "resetPasswdMode";
    public static final String SERVICEFLAG = "ServiceFlag";
    public static final String TWO_STEP_TIME = "twoStepTime";
    public static final String TWO_STEP_VERIFY = "twoStepVerify";
    public static final String UNIQUE_NICKNAME = "uniquelyNickname";
    public static final String UPDATE_TIME = "updateTime";
    public static final String USERSIGN = "userSignature";
    public static final String USERSTATE = "userState";
    public static final String USERVALID_STATUS = "userValidStatus";
    public static final String USER_STATUS_FLAGS = "userStatusFlags";
    private String A;
    private String B;
    private String C;
    private String D;
    private String E;
    private String F;
    private String G;
    private String H;
    private String I;
    private String J;
    private String K;
    private String L;

    /* renamed from: a, reason: collision with root package name */
    private String f36292a;

    /* renamed from: b, reason: collision with root package name */
    private String f36293b;

    /* renamed from: c, reason: collision with root package name */
    private String f36294c;

    /* renamed from: d, reason: collision with root package name */
    private String f36295d;

    /* renamed from: e, reason: collision with root package name */
    private String f36296e;

    /* renamed from: f, reason: collision with root package name */
    private String f36297f;

    /* renamed from: g, reason: collision with root package name */
    private String f36298g;

    /* renamed from: h, reason: collision with root package name */
    private String f36299h;

    /* renamed from: i, reason: collision with root package name */
    private String f36300i;

    /* renamed from: j, reason: collision with root package name */
    private String f36301j;

    /* renamed from: k, reason: collision with root package name */
    private String f36302k;

    /* renamed from: l, reason: collision with root package name */
    private String f36303l;

    /* renamed from: m, reason: collision with root package name */
    private String f36304m;

    /* renamed from: n, reason: collision with root package name */
    private String f36305n;

    /* renamed from: o, reason: collision with root package name */
    private String f36306o;

    /* renamed from: p, reason: collision with root package name */
    private String f36307p;

    /* renamed from: q, reason: collision with root package name */
    private String f36308q;

    /* renamed from: r, reason: collision with root package name */
    private String f36309r;

    /* renamed from: s, reason: collision with root package name */
    private String f36310s;

    /* renamed from: t, reason: collision with root package name */
    private String f36311t;

    /* renamed from: u, reason: collision with root package name */
    private String f36312u;

    /* renamed from: v, reason: collision with root package name */
    private String f36313v;

    /* renamed from: w, reason: collision with root package name */
    private String f36314w;

    /* renamed from: x, reason: collision with root package name */
    private String f36315x;

    /* renamed from: y, reason: collision with root package name */
    private String f36316y;

    /* renamed from: z, reason: collision with root package name */
    private String f36317z;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<UserInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public UserInfo createFromParcel(Parcel parcel) {
            UserInfo userInfo = new UserInfo();
            userInfo.f36300i = parcel.readString();
            userInfo.f36299h = parcel.readString();
            userInfo.f36305n = parcel.readString();
            userInfo.f36308q = parcel.readString();
            userInfo.f36295d = parcel.readString();
            userInfo.f36298g = parcel.readString();
            userInfo.f36302k = parcel.readString();
            userInfo.f36294c = parcel.readString();
            userInfo.f36296e = parcel.readString();
            userInfo.f36303l = parcel.readString();
            userInfo.f36292a = parcel.readString();
            userInfo.f36293b = parcel.readString();
            userInfo.f36301j = parcel.readString();
            userInfo.f36307p = parcel.readString();
            userInfo.f36306o = parcel.readString();
            userInfo.f36304m = parcel.readString();
            userInfo.f36309r = parcel.readString();
            userInfo.f36297f = parcel.readString();
            userInfo.f36310s = parcel.readString();
            userInfo.f36311t = parcel.readString();
            userInfo.f36312u = parcel.readString();
            userInfo.f36313v = parcel.readString();
            userInfo.f36314w = parcel.readString();
            userInfo.f36315x = parcel.readString();
            userInfo.f36316y = parcel.readString();
            userInfo.f36317z = parcel.readString();
            userInfo.A = parcel.readString();
            userInfo.B = parcel.readString();
            userInfo.D = parcel.readString();
            userInfo.C = parcel.readString();
            userInfo.E = parcel.readString();
            userInfo.F = parcel.readString();
            userInfo.I = parcel.readString();
            userInfo.G = parcel.readString();
            userInfo.H = parcel.readString();
            userInfo.J = parcel.readString();
            userInfo.K = parcel.readString();
            userInfo.L = parcel.readString();
            return userInfo;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public UserInfo[] newArray(int i3) {
            return new UserInfo[i3];
        }
    }

    public static void getUserInfoIntag(XmlPullParser xmlPullParser, UserInfo userInfo, String str) {
        if (xmlPullParser != null && userInfo != null && str != null) {
            b(xmlPullParser, userInfo, str);
            c(xmlPullParser, userInfo, str);
            e(xmlPullParser, userInfo, str);
        }
    }

    public static void setUserInfoIntag(XmlSerializer xmlSerializer, UserInfo userInfo) {
        if (xmlSerializer != null && userInfo != null) {
            d.a(xmlSerializer, UNIQUE_NICKNAME, userInfo.getUniqueNickName());
            d.a(xmlSerializer, "nickName", userInfo.getNickName());
            d.a(xmlSerializer, LANGUAGECODE, userInfo.getLanguageCode());
            d.a(xmlSerializer, FIRSTNAME, userInfo.getFirstName());
            d.a(xmlSerializer, LASTNAME, userInfo.getLastName());
            d.a(xmlSerializer, USERSTATE, userInfo.getUserState());
            d.a(xmlSerializer, "gender", userInfo.getGender());
            d.a(xmlSerializer, BIRTHDATE, userInfo.getBirthDate());
            d.a(xmlSerializer, "address", userInfo.getAddress());
            d.a(xmlSerializer, OCCUPATION, userInfo.getOccupation());
            d.a(xmlSerializer, HEADPICTUREURL, userInfo.getHeadPictureUrl());
            d.a(xmlSerializer, NATIONALCODE, userInfo.getNationalCode());
            d.a(xmlSerializer, "province", userInfo.getProvince());
            d.a(xmlSerializer, "city", userInfo.getCity());
            d.a(xmlSerializer, PASSWORDPROMPT, userInfo.getPasswordPrompt());
            d.a(xmlSerializer, PASSWORDANWSER, userInfo.getPasswordAnwser());
            d.a(xmlSerializer, CLOUDACCOUNT, userInfo.getCloudAccount());
            d.a(xmlSerializer, SERVICEFLAG, userInfo.getServiceFlag());
            d.a(xmlSerializer, USERVALID_STATUS, userInfo.getUserValidStatus());
            d.a(xmlSerializer, INVITER, userInfo.getInviter());
            d.a(xmlSerializer, INVITER_USERID, userInfo.getInviterUserId());
            d.a(xmlSerializer, "updateTime", userInfo.getUpdateTime());
            d.a(xmlSerializer, LOGIN_USER_NAME, userInfo.getLoginUserName());
            d.a(xmlSerializer, LOGIN_USER_NAME_FLAG, userInfo.getLoginUserNameFlag());
            d.a(xmlSerializer, USERSIGN, userInfo.getUserSign());
            d.a(xmlSerializer, CTFCODE, userInfo.getCtfCode());
            d.a(xmlSerializer, CTFTYPE, userInfo.getCtfType());
            d.a(xmlSerializer, CTFVERIFYFLAG, userInfo.getCtfVerifyFlag());
            d.a(xmlSerializer, "srvNationalCode", userInfo.getServiceCountryCode());
            d.a(xmlSerializer, "age", userInfo.getAge());
            d.a(xmlSerializer, AGEGROUPFLAG, userInfo.getAgegroupflag());
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.f36300i;
    }

    public String getAge() {
        return this.K;
    }

    public String getAgegroupflag() {
        return this.L;
    }

    public String getBirthDate() {
        return this.f36299h;
    }

    public String getCity() {
        return this.f36305n;
    }

    public String getCloudAccount() {
        return this.f36308q;
    }

    public String getCtfCode() {
        return this.I;
    }

    public String getCtfType() {
        return this.G;
    }

    public String getCtfVerifyFlag() {
        return this.H;
    }

    public String getFirstName() {
        return this.f36295d;
    }

    public String getGender() {
        return this.f36298g;
    }

    public String getGuardianAccount() {
        return this.F;
    }

    public String getGuardianUserId() {
        return this.E;
    }

    public String getHeadPictureUrl() {
        return this.f36302k;
    }

    public String getInviter() {
        return this.f36312u;
    }

    public String getInviterUserId() {
        return this.f36311t;
    }

    public String getLanguageCode() {
        return this.f36294c;
    }

    public String getLastName() {
        return this.f36296e;
    }

    public String getLoginNotice() {
        return this.D;
    }

    public String getLoginUserName() {
        return this.f36314w;
    }

    public String getLoginUserNameFlag() {
        return this.f36315x;
    }

    public String getNationalCode() {
        return this.f36303l;
    }

    public String getNickName() {
        return this.f36292a;
    }

    public String getOccupation() {
        return this.f36301j;
    }

    public String getPasswordAnwser() {
        return this.f36307p;
    }

    public String getPasswordPrompt() {
        return this.f36306o;
    }

    public String getProvince() {
        return this.f36304m;
    }

    public String getResetPasswdMode() {
        return this.B;
    }

    public String getServiceCountryCode() {
        return this.J;
    }

    public String getServiceFlag() {
        return this.f36309r;
    }

    public String getUniqueNickName() {
        return this.f36293b;
    }

    public String getUpdateTime() {
        return this.f36313v;
    }

    public String getUserSign() {
        return this.C;
    }

    public String getUserState() {
        return this.f36297f;
    }

    public int getUserType() {
        if (!TextUtils.isEmpty(this.E) && !TextUtils.isEmpty(this.F)) {
            return 1;
        }
        return 0;
    }

    public String getUserValidStatus() {
        return this.f36310s;
    }

    public String gettwoStepTime() {
        return this.A;
    }

    public String gettwoStepVerify() {
        return this.f36317z;
    }

    public String getuserStatusFlags() {
        return this.f36316y;
    }

    public boolean isObjectEquals(Object obj) {
        if (obj == null || !(obj instanceof UserInfo)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        UserInfo userInfo = (UserInfo) obj;
        if (!c.a(getNickName(), userInfo.getNickName()) || !c.a(getLoginUserName(), userInfo.getLoginUserName()) || !c.a(getLoginUserNameFlag(), userInfo.getLoginUserNameFlag()) || !c.a(getGender(), userInfo.getGender()) || !c.a(getBirthDate(), userInfo.getBirthDate()) || !c.a(getNationalCode(), userInfo.getNationalCode())) {
            return false;
        }
        return true;
    }

    public void setAddress(String str) {
        this.f36300i = str;
    }

    public void setAge(String str) {
        this.K = str;
    }

    public void setAgegroupflag(String str) {
        this.L = str;
    }

    public void setBirthDate(String str) {
        this.f36299h = str;
    }

    public void setCity(String str) {
        this.f36305n = str;
    }

    public void setCloudAccount(String str) {
        this.f36308q = str;
    }

    public void setCtfCode(String str) {
        this.I = str;
    }

    public void setCtfType(String str) {
        this.G = str;
    }

    public void setCtfVerifyFlag(String str) {
        this.H = str;
    }

    public void setFirstName(String str) {
        this.f36295d = str;
    }

    public void setGender(String str) {
        this.f36298g = str;
    }

    public void setGuardianAccount(String str) {
        this.F = str;
    }

    public void setGuardianUserId(String str) {
        this.E = str;
    }

    public void setHeadPictureUrl(String str) {
        this.f36302k = str;
    }

    public void setInviter(String str) {
        this.f36312u = str;
    }

    public void setInviterUserId(String str) {
        this.f36311t = str;
    }

    public void setLanguageCode(String str) {
        this.f36294c = str;
    }

    public void setLastName(String str) {
        this.f36296e = str;
    }

    public void setLoginNotice(String str) {
        this.D = str;
    }

    public void setLoginUserName(String str) {
        this.f36314w = str;
    }

    public void setLoginUserNameFlag(String str) {
        this.f36315x = str;
    }

    public void setNationalCode(String str) {
        this.f36303l = str;
    }

    public void setNickName(String str) {
        this.f36292a = str;
    }

    public void setOccupation(String str) {
        this.f36301j = str;
    }

    public void setPasswordAnwser(String str) {
        this.f36307p = str;
    }

    public void setPasswordPrompt(String str) {
        this.f36306o = str;
    }

    public void setProvince(String str) {
        this.f36304m = str;
    }

    public void setResetPasswdMode(String str) {
        this.B = str;
    }

    public void setServiceCountryCode(String str) {
        this.J = str;
    }

    public void setServiceFlag(String str) {
        this.f36309r = str;
    }

    public void setUniqueNickName(String str) {
        this.f36293b = str;
    }

    public void setUpdateTime(String str) {
        this.f36313v = str;
    }

    public void setUserSign(String str) {
        this.C = str;
    }

    public void setUserState(String str) {
        this.f36297f = str;
    }

    public void setUserValidStatus(String str) {
        this.f36310s = str;
    }

    public void settwoStepTime(String str) {
        this.A = str;
    }

    public void settwoStepVerify(String str) {
        this.f36317z = str;
    }

    public void setuserStatusFlags(String str) {
        this.f36316y = str;
    }

    public String toString() {
        return "UserInfo [mNickName=" + i2.d.b(this.f36292a) + ", mUniqueNickName=" + i2.d.b(this.f36293b) + ", mLanguageCode=" + this.f36294c + ", mFirstName=" + i2.d.b(this.f36295d) + ", mLastName=" + i2.d.b(this.f36296e) + ", mUserState=" + this.f36297f + ", mGender=" + this.f36298g + ", mBirthDate=" + this.f36299h + ", mAddress=" + i2.d.b(this.f36300i) + ", mOccupation=" + this.f36301j + ", mHeadPictureUrl=" + this.f36302k + ", mNationalCode=" + this.f36303l + ", mProvince=" + this.f36304m + ", mCity=" + this.f36305n + ", mPasswordPrompt=" + i2.d.b(this.f36306o) + ", mscrtdanws=" + this.f36307p + ", mCloudAccount=" + this.f36308q + ", mServiceFlag=" + this.f36309r + ", mUserValidStatus=" + this.f36310s + ", mInviterUserId=" + i2.d.b(this.f36311t) + ", mInviter=" + i2.d.b(this.f36312u) + ", mUpdateTime=" + this.f36313v + ", mLoginUserName=" + i2.d.b(this.f36314w) + ", mLoginUserNameFlag=" + this.f36315x + ", muserStatusFlags=" + this.f36316y + ", mtwoStepVerify=" + this.f36317z + ", mtwoStepTime=" + this.A + ", mResetPasswdMode=" + this.B + ", mUserSign=" + this.C + ", mLoginNotice=" + this.D + ", mGuardianUserId=" + i2.d.b(this.E) + ", mGuardianAccount=" + i2.d.b(this.F) + ", mCtfType=" + this.G + ", mCtfVerifyFlag=" + this.H + ", mCtfCode=" + this.I + ", mAgegroupflag=" + this.L + ", mServiceCountryCode=" + this.J + ", userType=" + getUserType() + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f36300i);
        parcel.writeString(this.f36299h);
        parcel.writeString(this.f36305n);
        parcel.writeString(this.f36308q);
        parcel.writeString(this.f36295d);
        parcel.writeString(this.f36298g);
        parcel.writeString(this.f36302k);
        parcel.writeString(this.f36294c);
        parcel.writeString(this.f36296e);
        parcel.writeString(this.f36303l);
        parcel.writeString(this.f36292a);
        parcel.writeString(this.f36293b);
        parcel.writeString(this.f36301j);
        parcel.writeString(this.f36307p);
        parcel.writeString(this.f36306o);
        parcel.writeString(this.f36304m);
        parcel.writeString(this.f36309r);
        parcel.writeString(this.f36297f);
        parcel.writeString(this.f36310s);
        parcel.writeString(this.f36311t);
        parcel.writeString(this.f36312u);
        parcel.writeString(this.f36313v);
        parcel.writeString(this.f36314w);
        parcel.writeString(this.f36315x);
        parcel.writeString(this.f36316y);
        parcel.writeString(this.f36317z);
        parcel.writeString(this.A);
        parcel.writeString(this.B);
        parcel.writeString(this.D);
        parcel.writeString(this.C);
        parcel.writeString(this.E);
        parcel.writeString(this.F);
        parcel.writeString(this.I);
        parcel.writeString(this.H);
        parcel.writeString(this.G);
        parcel.writeString(this.J);
        parcel.writeString(this.K);
        parcel.writeString(this.L);
    }

    private static void b(XmlPullParser xmlPullParser, UserInfo userInfo, String str) {
        if ("nickName".equals(str)) {
            userInfo.setNickName(xmlPullParser.nextText());
            return;
        }
        if (UNIQUE_NICKNAME.equals(str)) {
            userInfo.setUniqueNickName(xmlPullParser.nextText());
            return;
        }
        if (LANGUAGECODE.equals(str)) {
            userInfo.setLanguageCode(xmlPullParser.nextText());
            return;
        }
        if (FIRSTNAME.equals(str)) {
            userInfo.setFirstName(xmlPullParser.nextText());
            return;
        }
        if (LASTNAME.equals(str)) {
            userInfo.setLastName(xmlPullParser.nextText());
            return;
        }
        if (USERSTATE.equals(str)) {
            userInfo.setUserState(xmlPullParser.nextText());
            return;
        }
        if (GUARDIAN_ACCOUNT.equals(str)) {
            userInfo.setGuardianAccount(xmlPullParser.nextText());
            return;
        }
        if (GUARDIAN_USER_ID.equals(str)) {
            userInfo.setGuardianUserId(xmlPullParser.nextText());
            return;
        }
        if (CTFCODE.equals(str)) {
            userInfo.setCtfCode(xmlPullParser.nextText());
            return;
        }
        if (CTFTYPE.equals(str)) {
            userInfo.setCtfType(xmlPullParser.nextText());
            return;
        }
        if (CTFVERIFYFLAG.equals(str)) {
            userInfo.setCtfVerifyFlag(xmlPullParser.nextText());
            return;
        }
        if (USERVALID_STATUS.equals(str)) {
            userInfo.setUserValidStatus(xmlPullParser.nextText());
            return;
        }
        if (INVITER_USERID.equals(str)) {
            userInfo.setInviterUserId(xmlPullParser.nextText());
        } else if ("age".equals(str)) {
            userInfo.setAge(xmlPullParser.nextText());
        } else if (AGEGROUPFLAG.equals(str)) {
            userInfo.setAgegroupflag(xmlPullParser.nextText());
        }
    }

    private static void c(XmlPullParser xmlPullParser, UserInfo userInfo, String str) {
        if ("gender".equals(str)) {
            userInfo.setGender(xmlPullParser.nextText());
            return;
        }
        if (BIRTHDATE.equals(str)) {
            userInfo.setBirthDate(xmlPullParser.nextText());
            return;
        }
        if ("address".equals(str)) {
            userInfo.setAddress(xmlPullParser.nextText());
            return;
        }
        if (OCCUPATION.equals(str)) {
            userInfo.setOccupation(xmlPullParser.nextText());
            return;
        }
        if (HEADPICTUREURL.equals(str)) {
            userInfo.setHeadPictureUrl(xmlPullParser.nextText());
            return;
        }
        if (NATIONALCODE.equals(str)) {
            userInfo.setNationalCode(xmlPullParser.nextText());
            return;
        }
        if ("province".equals(str)) {
            userInfo.setProvince(xmlPullParser.nextText());
            return;
        }
        if ("city".equals(str)) {
            userInfo.setCity(xmlPullParser.nextText());
            return;
        }
        if (PASSWORDPROMPT.equals(str)) {
            userInfo.setPasswordPrompt(xmlPullParser.nextText());
            return;
        }
        if (PASSWORDANWSER.equals(str)) {
            userInfo.setPasswordAnwser(xmlPullParser.nextText());
        } else if (CLOUDACCOUNT.equals(str)) {
            userInfo.setCloudAccount(xmlPullParser.nextText());
        } else if (SERVICEFLAG.equals(str)) {
            userInfo.setServiceFlag(xmlPullParser.nextText());
        }
    }

    private static void e(XmlPullParser xmlPullParser, UserInfo userInfo, String str) {
        if (INVITER.equals(str)) {
            userInfo.setInviter(xmlPullParser.nextText());
            return;
        }
        if ("updateTime".equals(str)) {
            userInfo.setUpdateTime(xmlPullParser.nextText());
            return;
        }
        if (LOGIN_USER_NAME.equals(str)) {
            userInfo.setLoginUserName(xmlPullParser.nextText());
            return;
        }
        if (LOGIN_USER_NAME_FLAG.equals(str)) {
            userInfo.setLoginUserNameFlag(xmlPullParser.nextText());
            return;
        }
        if (USER_STATUS_FLAGS.equals(str)) {
            userInfo.setuserStatusFlags(xmlPullParser.nextText());
            return;
        }
        if (TWO_STEP_VERIFY.equals(str)) {
            userInfo.settwoStepVerify(xmlPullParser.nextText());
            return;
        }
        if (TWO_STEP_TIME.equals(str)) {
            userInfo.settwoStepTime(xmlPullParser.nextText());
            return;
        }
        if (RESET_PASSWD_MODE.equals(str)) {
            userInfo.setResetPasswdMode(xmlPullParser.nextText());
            return;
        }
        if (USERSIGN.equals(str)) {
            userInfo.setUserSign(xmlPullParser.nextText());
        } else if (LOGIN_NOTICE.equals(str)) {
            userInfo.setLoginNotice(xmlPullParser.nextText());
        } else if ("srvNationalCode".equals(str)) {
            userInfo.setServiceCountryCode(xmlPullParser.nextText());
        }
    }
}
