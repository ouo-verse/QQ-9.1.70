package com.tencent.imsdk.relationship;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes7.dex */
public class UserInfo implements Serializable {
    public static final int USERINFO_ALLOWTYPE_ALLOWANY = 0;
    public static final int USERINFO_ALLOWTYPE_DENYANY = 2;
    public static final int USERINFO_ALLOWTYPE_NEEDCONFIRM = 1;
    public static final String USERINFO_ALLOWTYPE_TYPE_ALLOWANY = "AllowType_Type_AllowAny";
    public static final String USERINFO_ALLOWTYPE_TYPE_DENYANY = "AllowType_Type_DenyAny";
    public static final String USERINFO_ALLOWTYPE_TYPE_NEEDCONFIRM = "AllowType_Type_NeedConfirm";
    public static final int USERINFO_GENDER_FEMALE = 2;
    public static final int USERINFO_GENDER_MALE = 1;
    public static final String USERINFO_GENDER_TYPE_FEMALE = "Gender_Type_Female";
    public static final String USERINFO_GENDER_TYPE_MALE = "Gender_Type_Male";
    public static final String USERINFO_GENDER_TYPE_UNKNOWN = "Gender_Type_Unknown";
    public static final int USERINFO_GENDER_UNKNOWN = 0;
    public static final String USERINFO_KEY_ALLOWTYPE = "Tag_Profile_IM_AllowType";
    public static final String USERINFO_KEY_BIRTHDAY = "Tag_Profile_IM_BirthDay";
    public static final String USERINFO_KEY_CUSTOM_PREFIX = "Tag_Profile_Custom_";
    public static final String USERINFO_KEY_FACEURL = "Tag_Profile_IM_Image";
    public static final String USERINFO_KEY_GENDER = "Tag_Profile_IM_Gender";
    public static final String USERINFO_KEY_LEVEL = "Tag_Profile_IM_Level";
    public static final String USERINFO_KEY_NICK = "Tag_Profile_IM_Nick";
    public static final String USERINFO_KEY_ROLE = "Tag_Profile_IM_Role";
    public static final String USERINFO_KEY_SELF_SIGNATURE = "Tag_Profile_IM_SelfSignature";
    public static final int USER_NOT_RECEIVE_MESSAGE_NATIVE = 2;
    public static final int USER_RECEIVE_MESSAGE_NATIVE = 1;
    public static final int USER_RECEIVE_NOT_NOTIFY_MESSAGE_NATIVE = 3;
    private int allowType;
    private long birthday;
    private String faceUrl;
    private int gender;
    private long language;
    private int level;
    private String location;
    private String nickname;
    private int role;
    private String signature;
    private String userID;
    private HashMap<String, byte[]> customUserInfoString = new HashMap<>();
    private HashMap<String, Long> customUserInfoNumber = new HashMap<>();

    protected void addCustomUserInfoBytes(String str, byte[] bArr) {
        this.customUserInfoString.put(str, bArr);
    }

    protected void addCustomUserInfoNumber(String str, long j3) {
        this.customUserInfoNumber.put(str, Long.valueOf(j3));
    }

    public int getAllowType() {
        return this.allowType;
    }

    public long getBirthday() {
        return this.birthday;
    }

    public Map<String, Long> getCustomUserInfoNumber() {
        return this.customUserInfoNumber;
    }

    public HashMap<String, byte[]> getCustomUserInfoString() {
        return this.customUserInfoString;
    }

    public String getFaceUrl() {
        return this.faceUrl;
    }

    public int getGender() {
        return this.gender;
    }

    public long getLanguage() {
        return this.language;
    }

    public int getLevel() {
        return this.level;
    }

    public String getLocation() {
        return this.location;
    }

    public String getNickname() {
        return this.nickname;
    }

    public int getRole() {
        return this.role;
    }

    public String getSignature() {
        return this.signature;
    }

    public String getUserID() {
        return this.userID;
    }

    public void setAllowType(int i3) {
        this.allowType = i3;
    }

    public void setBirthday(long j3) {
        this.birthday = j3;
    }

    public void setFaceUrl(String str) {
        this.faceUrl = str;
    }

    public void setGender(int i3) {
        this.gender = i3;
    }

    public void setLanguage(long j3) {
        this.language = j3;
    }

    public void setLevel(int i3) {
        this.level = i3;
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setRole(int i3) {
        this.role = i3;
    }

    public void setSignature(String str) {
        this.signature = str;
    }

    public void setUserID(String str) {
        this.userID = str;
    }
}
