package com.tencent.comic.quickupdate;

import com.tencent.comic.f;
import com.tencent.mobileqq.vas.quickupdate.BaseUpdateCallback;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.updatesystem.callback.TagItemInfo;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes32.dex */
public class QQComicUpdateBusiness extends BaseUpdateCallback {
    public static final String TAG = "QQComicUpdateBusiness";
    public static QQComicUpdateBusiness sInstance = new QQComicUpdateBusiness();

    private boolean isComicExist(String str) {
        if (str.equals(VasUpdateConstants.SCID_COMIC_NAV_CONFIG)) {
            return f.l();
        }
        if (str.equals(VasUpdateConstants.SCID_COMIC_NAV_ICON)) {
            return f.b();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.vas.quickupdate.BaseUpdateCallback
    public void doOnCompleted(long j3, String str, String str2, String str3, int i3, int i16) {
        super.doOnCompleted(j3, str, str2, str3, i3, i16);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "doOnCompleted: bid=" + j3 + ", scid=" + str + ", errorCode=" + i3);
        }
        if (j3 == 100) {
            onComicCompleted(str, i3);
        }
    }

    @Override // com.tencent.mobileqq.vas.quickupdate.BaseUpdateCallback
    public long getBID() {
        return 100L;
    }

    @Override // com.tencent.mobileqq.vas.quickupdate.BaseUpdateCallback, com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateBusinessCallback
    public TagItemInfo getItemInfo(long j3, String str) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "getItemInfo: bid=" + j3 + ", scid=" + str);
        }
        if (j3 == 100) {
            return getBidComicInfo(str, new TagItemInfo());
        }
        return null;
    }

    @Override // com.tencent.mobileqq.vas.quickupdate.BaseUpdateCallback, com.tencent.mobileqq.vas.updatesystem.callback.QuickUpdateBusinessCallback
    public boolean isFileExists(long j3, String str) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "isFileExists");
        }
        if (j3 == 100) {
            return isComicExist(str);
        }
        return false;
    }

    private TagItemInfo getBidComicInfo(String str, TagItemInfo tagItemInfo) {
        tagItemInfo.bPreConfig = false;
        if (str.equals(VasUpdateConstants.SCID_COMIC_NAV_CONFIG)) {
            tagItemInfo.bSaveInDir = false;
            tagItemInfo.strSavePath = f.e().getAbsolutePath();
        } else if (str.equals(VasUpdateConstants.SCID_COMIC_NAV_ICON)) {
            tagItemInfo.bSaveInDir = true;
            tagItemInfo.strSavePath = f.g().getAbsolutePath();
        }
        return tagItemInfo;
    }

    private void onComicCompleted(String str, int i3) {
        if (i3 == 0) {
            if (str.equals(VasUpdateConstants.SCID_COMIC_NAV_CONFIG)) {
                f.m();
            } else if (str.equals(VasUpdateConstants.SCID_COMIC_NAV_ICON)) {
                f.b();
            }
        }
    }
}
