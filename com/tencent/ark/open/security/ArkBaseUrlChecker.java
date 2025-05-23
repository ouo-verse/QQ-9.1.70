package com.tencent.ark.open.security;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.Logger;
import com.tencent.ark.open.ArkAppInfo;
import com.tencent.ark.open.ArkUtil;
import com.tencent.mobileqq.haoliyou.JefsClass;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ArkBaseUrlChecker implements Parcelable {
    private static final String TAG = "ArkApp.ArkBaseUrlChecker";
    public static final int TYPE_INVALID_BLACK = 1;
    public static final int TYPE_INVALID_WHITE = 2;
    public static final int TYPE_VALID = 0;
    private ArrayList<ArkAppInfo.ArkWhiteUrlItem> mGlobalBlackList;
    private ArrayList<ArkAppInfo.ArkWhiteUrlItem> mGlobalWhiteList;
    protected Object mLock;
    protected ArrayList<ArkAppInfo.ArkWhiteUrlItem> mWhiteList;
    private static final ArkEnvironmentManager ENV = ArkEnvironmentManager.getInstance();
    public static final Parcelable.Creator<ArkBaseUrlChecker> CREATOR = new Parcelable.Creator<ArkBaseUrlChecker>() { // from class: com.tencent.ark.open.security.ArkBaseUrlChecker.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ArkBaseUrlChecker createFromParcel(Parcel parcel) {
            return new ArkBaseUrlChecker(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ArkBaseUrlChecker[] newArray(int i3) {
            return new ArkBaseUrlChecker[i3];
        }
    };

    public ArkBaseUrlChecker(ArrayList<ArkAppInfo.ArkWhiteUrlItem> arrayList, ArrayList<ArkAppInfo.ArkWhiteUrlItem> arrayList2, ArrayList<ArkAppInfo.ArkWhiteUrlItem> arrayList3) {
        this.mWhiteList = null;
        this.mGlobalWhiteList = null;
        this.mGlobalBlackList = null;
        Object obj = new Object();
        this.mLock = obj;
        synchronized (obj) {
            if (arrayList != null) {
                try {
                    if (arrayList.size() > 0) {
                        ArrayList<ArkAppInfo.ArkWhiteUrlItem> arrayList4 = new ArrayList<>();
                        this.mWhiteList = arrayList4;
                        arrayList4.addAll(arrayList);
                    }
                } catch (Throwable th5) {
                    throw th5;
                }
            }
            if (arrayList2 != null && arrayList2.size() > 0) {
                ArrayList<ArkAppInfo.ArkWhiteUrlItem> arrayList5 = new ArrayList<>();
                this.mGlobalWhiteList = arrayList5;
                arrayList5.addAll(arrayList2);
            }
            if (arrayList3 != null && arrayList3.size() > 0) {
                ArrayList<ArkAppInfo.ArkWhiteUrlItem> arrayList6 = new ArrayList<>();
                this.mGlobalBlackList = arrayList6;
                arrayList6.addAll(arrayList3);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x010e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean isUrlValidInList(String str, ArrayList<ArkAppInfo.ArkWhiteUrlItem> arrayList) {
        boolean z16;
        boolean z17;
        boolean z18;
        String str2;
        ArkAppInfo.ArkWhiteUrlItem arkWhiteUrlItem;
        boolean equalsIgnoreCase;
        int i3;
        boolean equals;
        if (!TextUtils.isEmpty(str) && arrayList != null) {
            URL parseURL = parseURL(str);
            int i16 = 0;
            if (parseURL == null) {
                Logger.logI(TAG, "ArkSafe.isUrlValidInList invalid url, url = ", ArkUtil.filterKeyForLog(str, new String[0]));
                return false;
            }
            String authority = parseURL.getAuthority();
            String path = parseURL.getPath();
            StringBuilder sb5 = new StringBuilder();
            try {
                Iterator<ArkAppInfo.ArkWhiteUrlItem> it = arrayList.iterator();
                z16 = true;
                z17 = false;
                z18 = false;
                while (true) {
                    try {
                        if (!it.hasNext()) {
                            break;
                        }
                        ArkAppInfo.ArkWhiteUrlItem next = it.next();
                        if (next != null) {
                            sb5.append("ArkSafe.isUrlValidInList.handle ruleDomain=");
                            sb5.append(next.ruleDomain);
                            sb5.append(", rulePath=");
                            sb5.append(next.rulePath);
                            sb5.append("\n");
                            if (TextUtils.isEmpty(next.ruleDomain)) {
                                z17 = true;
                                str2 = "*";
                                arkWhiteUrlItem = next;
                            } else {
                                if (!next.ruleDomain.startsWith("*") || authority == null) {
                                    str2 = "*";
                                    arkWhiteUrlItem = next;
                                    equalsIgnoreCase = arkWhiteUrlItem.ruleDomain.equalsIgnoreCase(authority);
                                } else {
                                    int length = next.ruleDomain.length() - 1;
                                    int length2 = authority.length() - length;
                                    if (length2 < 0) {
                                        i3 = i16;
                                    } else {
                                        i3 = length2;
                                    }
                                    str2 = "*";
                                    arkWhiteUrlItem = next;
                                    equalsIgnoreCase = authority.regionMatches(true, i3, next.ruleDomain, 1, length);
                                }
                                z17 = equalsIgnoreCase;
                            }
                            if (TextUtils.isEmpty(arkWhiteUrlItem.rulePath)) {
                                z18 = true;
                            } else {
                                if (arkWhiteUrlItem.rulePath.endsWith(str2) && path != null) {
                                    equals = path.regionMatches(0, arkWhiteUrlItem.rulePath, 0, arkWhiteUrlItem.rulePath.length() - 1);
                                } else {
                                    equals = arkWhiteUrlItem.rulePath.equals(path);
                                }
                                z18 = equals;
                            }
                            if (z17 && z18) {
                                z16 = true;
                                break;
                            }
                            z16 = false;
                        }
                        i16 = 0;
                    } catch (Exception e16) {
                        e = e16;
                        Logger.logE(TAG, "ArkSafe.isUrlValidInList.exception2=" + e.toString());
                        if (!z16) {
                        }
                        return z16;
                    }
                }
            } catch (Exception e17) {
                e = e17;
                z16 = true;
                z17 = false;
                z18 = false;
            }
            if (!z16) {
                Logger.logE(TAG, "ArkSafe.isUrlValidInList url=", ArkUtil.filterKeyForLog(str, new String[0]), ", return isValid=", Boolean.valueOf(z16), ", isDomainValid=", Boolean.valueOf(z17), ", isPathValid=", Boolean.valueOf(z18), ", detailLog=", sb5.toString());
            }
            return z16;
        }
        Logger.logE(TAG, "ArkSafe.isUrlValidInList return true");
        return true;
    }

    private static URL parseURL(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new URL(str);
        } catch (MalformedURLException e16) {
            Logger.logE(TAG, "ArkSafe.isUrlValidInList Exception:" + e16.toString());
            int indexOf = str.indexOf(63);
            if (indexOf < 0) {
                return null;
            }
            try {
                return new URL(str.substring(0, indexOf));
            } catch (MalformedURLException e17) {
                Logger.logE(TAG, "ArkSafe.isUrlValidInList Exception:" + e17.toString());
                return null;
            }
        }
    }

    public int checkURLLoose(String str) {
        int i3;
        if (TextUtils.isEmpty(str)) {
            Logger.logE(TAG, "ArkSafe.checkURLLoose return TYPE_VALID for null url");
            return 0;
        }
        synchronized (this.mLock) {
            ArrayList<ArkAppInfo.ArkWhiteUrlItem> arrayList = this.mGlobalBlackList;
            if (arrayList != null && arrayList.size() > 0) {
                if (!isUrlValidInList(str, this.mGlobalBlackList)) {
                    Logger.logD(TAG, "ArkSafe.checkURLLoose.not in black list.type=", 0, ", url=", ArkUtil.filterKeyForLog(str, new String[0]));
                    return 0;
                }
                if (!isUrlValidInList(str, this.mWhiteList)) {
                    i3 = 1;
                    Logger.logI(TAG, "ArkSafe.checkURLLoose.type=", Integer.valueOf(i3), ", url=", ArkUtil.filterKeyForLog(str, new String[0]));
                    return i3;
                }
            }
            i3 = 0;
            Logger.logI(TAG, "ArkSafe.checkURLLoose.type=", Integer.valueOf(i3), ", url=", ArkUtil.filterKeyForLog(str, new String[0]));
            return i3;
        }
    }

    public int checkURLStrict(String str) {
        boolean z16;
        int i3 = 0;
        if (TextUtils.isEmpty(str)) {
            Logger.logE(TAG, "ArkSafe.checkURLStrict return TYPE_VALID for null url");
            return 0;
        }
        synchronized (this.mLock) {
            ArrayList<ArkAppInfo.ArkWhiteUrlItem> arrayList = this.mGlobalBlackList;
            if (arrayList != null && arrayList.size() > 0 && !(!isUrlValidInList(str, this.mGlobalBlackList))) {
                Logger.logW(TAG, "ArkSafe.checkURLStrict.type=", 1, JefsClass.INDEX_URL, ArkUtil.filterKeyForLog(str, new String[0]));
                return 1;
            }
            ArrayList<ArkAppInfo.ArkWhiteUrlItem> arrayList2 = this.mGlobalWhiteList;
            if ((arrayList2 != null && arrayList2.size() > 0 && isUrlValidInList(str, this.mGlobalWhiteList)) || isUrlValidInList(str, this.mWhiteList)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                Logger.logW(TAG, "ArkSafe.checkURLStrict.type=", 2, JefsClass.INDEX_URL, ArkUtil.filterKeyForLog(str, new String[0]));
                i3 = 2;
            }
            return i3;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder("{");
        if (this.mWhiteList != null) {
            sb5.append("list:");
            sb5.append(this.mWhiteList.toString());
        }
        if (this.mGlobalWhiteList != null) {
            sb5.append("gloablwhite:");
            sb5.append(this.mGlobalWhiteList.toString());
        }
        if (this.mGlobalBlackList != null) {
            sb5.append("gloablblack:");
            sb5.append(this.mGlobalBlackList.toString());
        }
        sb5.append("}");
        return sb5.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeTypedList(this.mWhiteList);
        parcel.writeTypedList(this.mGlobalWhiteList);
        parcel.writeTypedList(this.mGlobalBlackList);
    }

    protected ArkBaseUrlChecker(Parcel parcel) {
        this.mWhiteList = null;
        this.mGlobalWhiteList = null;
        this.mGlobalBlackList = null;
        this.mLock = new Object();
        Parcelable.Creator<ArkAppInfo.ArkWhiteUrlItem> creator = ArkAppInfo.ArkWhiteUrlItem.CREATOR;
        this.mWhiteList = parcel.createTypedArrayList(creator);
        this.mGlobalWhiteList = parcel.createTypedArrayList(creator);
        this.mGlobalBlackList = parcel.createTypedArrayList(creator);
    }
}
