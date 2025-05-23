package com.tencent.ark.open.security;

import com.tencent.ark.open.ArkAppInfo;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ArkAppUrlChecker extends ArkBaseUrlChecker {
    private ArrayList<ArkAppInfo.ArkWhiteUrlItem> mAppNavigationList;
    private ArrayList<ArkAppInfo.ArkWhiteUrlItem> mAppResouceList;

    public ArkAppUrlChecker(ArkAppInfo.AppUrlWhiteList appUrlWhiteList, ArrayList<ArkAppInfo.ArkWhiteUrlItem> arrayList, ArrayList<ArkAppInfo.ArkWhiteUrlItem> arrayList2) {
        super(null, arrayList, arrayList2);
        this.mAppResouceList = null;
        this.mAppNavigationList = null;
        synchronized (this.mLock) {
            if (appUrlWhiteList != null) {
                try {
                    if (appUrlWhiteList.resourceList != null) {
                        ArrayList<ArkAppInfo.ArkWhiteUrlItem> arrayList3 = new ArrayList<>();
                        this.mAppResouceList = arrayList3;
                        arrayList3.addAll(appUrlWhiteList.resourceList);
                    }
                } catch (Throwable th5) {
                    throw th5;
                }
            }
            if (appUrlWhiteList != null && appUrlWhiteList.navigationList != null) {
                ArrayList<ArkAppInfo.ArkWhiteUrlItem> arrayList4 = new ArrayList<>();
                this.mAppNavigationList = arrayList4;
                arrayList4.addAll(appUrlWhiteList.navigationList);
            }
        }
    }

    public int checkUrlIsValidByAppNavigationList(String str) {
        int checkURLStrict;
        synchronized (this.mLock) {
            this.mWhiteList = this.mAppNavigationList;
            checkURLStrict = super.checkURLStrict(str);
        }
        return checkURLStrict;
    }

    public int checkUrlIsValidByAppResouceList(String str) {
        int checkURLStrict;
        synchronized (this.mLock) {
            this.mWhiteList = this.mAppResouceList;
            checkURLStrict = super.checkURLStrict(str);
        }
        return checkURLStrict;
    }

    public ArkBaseUrlChecker getAppNavigationChecker() {
        synchronized (this.mLock) {
            this.mWhiteList = this.mAppNavigationList;
        }
        return this;
    }
}
