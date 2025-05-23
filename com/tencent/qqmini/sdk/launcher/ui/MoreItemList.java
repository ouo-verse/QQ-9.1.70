package com.tencent.qqmini.sdk.launcher.ui;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.R;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MoreItemList extends ArrayList<MoreItem> {
    private static final String TAG = "MoreItemList";

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class Builder {
        private boolean isAboutPresent;
        private boolean isComplaintPresent;
        private boolean isShareQQPresent;
        private boolean isShareQZonePresent;
        private boolean isShareWxFriendsPresent;
        private boolean isShareWxMomentsPresent;
        private DisplaySettings mDisplaySettings = new DisplaySettings();
        MoreItemList mMoreItemList = new MoreItemList();

        public Builder addAbout(String str, int i3) {
            MoreItem moreItem = new MoreItem();
            moreItem.f348090id = 5;
            moreItem.visible = this.mDisplaySettings.isShowAbout;
            moreItem.drawable = i3;
            if (TextUtils.isEmpty(str)) {
                str = "\u5173\u4e8e";
            }
            moreItem.text = str;
            this.mMoreItemList.add(moreItem);
            this.isAboutPresent = true;
            return this;
        }

        public Builder addComplaint(String str, int i3) {
            MoreItem moreItem = new MoreItem();
            moreItem.f348090id = 6;
            moreItem.visible = this.mDisplaySettings.isShowComplaint;
            moreItem.drawable = i3;
            if (TextUtils.isEmpty(str)) {
                str = "\u4e3e\u62a5";
            }
            moreItem.text = str;
            this.mMoreItemList.add(moreItem);
            this.isComplaintPresent = true;
            return this;
        }

        public Builder addDebug(String str, int i3) {
            MoreItem moreItem = new MoreItem();
            moreItem.f348090id = 7;
            moreItem.visible = this.mDisplaySettings.isShowDebug;
            moreItem.drawable = i3;
            if (TextUtils.isEmpty(str)) {
                str = "\u8c03\u8bd5";
            }
            moreItem.text = str;
            this.mMoreItemList.add(moreItem);
            return this;
        }

        public Builder addExportLog(String str, int i3) {
            MoreItem moreItem = new MoreItem();
            moreItem.f348090id = 13;
            moreItem.visible = this.mDisplaySettings.isShowExportLog;
            moreItem.drawable = i3;
            if (TextUtils.isEmpty(str)) {
                str = "\u5bfc\u51fa\u65e5\u5fd7";
            }
            moreItem.text = str;
            this.mMoreItemList.add(moreItem);
            return this;
        }

        public Builder addFavorite(String str, int i3) {
            MoreItem moreItem = new MoreItem();
            moreItem.f348090id = 10;
            moreItem.visible = this.mDisplaySettings.isShowFavorite;
            moreItem.drawable = i3;
            if (TextUtils.isEmpty(str)) {
                str = "\u6dfb\u52a0\u5230\u6211\u7684";
            }
            moreItem.text = str;
            this.mMoreItemList.add(moreItem);
            return this;
        }

        public Builder addMonitor(String str, int i3) {
            MoreItem moreItem = new MoreItem();
            moreItem.f348090id = 8;
            moreItem.visible = this.mDisplaySettings.isShowMonitor;
            moreItem.drawable = i3;
            if (TextUtils.isEmpty(str)) {
                str = "\u6027\u80fd";
            }
            moreItem.text = str;
            this.mMoreItemList.add(moreItem);
            return this;
        }

        public Builder addMoreItem(MoreItem moreItem) {
            if (moreItem == null) {
                QMLog.w(MoreItemList.TAG, "Failed to add moreItem, moreItem is null");
            } else {
                int i3 = moreItem.f348090id;
                if (i3 >= 100 && i3 <= 200) {
                    moreItem.visible = this.mDisplaySettings.isShowShareOthers;
                    this.mMoreItemList.add(moreItem);
                } else {
                    QMLog.w(MoreItemList.TAG, "Failed to add more item, id must in range of [100, 200], but the actual id is " + moreItem.f348090id);
                }
            }
            return this;
        }

        public Builder addQQFavorite(String str, int i3) {
            MoreItem moreItem = new MoreItem();
            moreItem.f348090id = 12;
            moreItem.visible = this.mDisplaySettings.isShowQQFavorite;
            moreItem.drawable = i3;
            if (TextUtils.isEmpty(str)) {
                str = "\u6536\u85cf";
            }
            moreItem.text = str;
            this.mMoreItemList.add(moreItem);
            return this;
        }

        public Builder addRestart(String str, int i3) {
            MoreItem moreItem = new MoreItem();
            moreItem.f348090id = 9;
            moreItem.visible = this.mDisplaySettings.isShowRestart;
            moreItem.drawable = i3;
            if (TextUtils.isEmpty(str)) {
                str = "\u91cd\u542f";
            }
            moreItem.text = str;
            this.mMoreItemList.add(moreItem);
            return this;
        }

        public Builder addShareQQ(String str, int i3) {
            return addShareQQ(str, i3, false);
        }

        public Builder addShareQzone(String str, int i3) {
            return addShareQzone(str, i3, false);
        }

        public Builder addShareWxFriends(String str, int i3) {
            return addShareWxFriends(str, i3, false);
        }

        public Builder addShareWxMoments(String str, int i3) {
            return addShareWxMoments(str, i3, false);
        }

        public Builder addShortcut(String str, int i3) {
            MoreItem moreItem = new MoreItem();
            moreItem.f348090id = 11;
            moreItem.visible = this.mDisplaySettings.isShowShortcut;
            moreItem.drawable = i3;
            if (TextUtils.isEmpty(str)) {
                str = "\u6dfb\u52a0\u5230\u684c\u9762";
            }
            moreItem.text = str;
            this.mMoreItemList.add(moreItem);
            return this;
        }

        public final MoreItemList build() {
            if (!this.isAboutPresent) {
                addAbout("\u5173\u4e8e", R.drawable.mini_sdk_about);
            }
            if (!this.isComplaintPresent) {
                addComplaint("\u4e3e\u62a5", R.drawable.mini_sdk_browser_report);
            }
            return this.mMoreItemList;
        }

        public boolean isMyFavorite() {
            return this.mDisplaySettings.isMyFavorite;
        }

        public Builder setDisplaySettings(DisplaySettings displaySettings) {
            this.mDisplaySettings = displaySettings;
            return this;
        }

        public Builder addShareQQ(String str, int i3, boolean z16) {
            MoreItem moreItem = new MoreItem();
            moreItem.f348090id = 1;
            moreItem.visible = this.mDisplaySettings.isShowShareQQ;
            moreItem.drawable = i3;
            if (TextUtils.isEmpty(str)) {
                str = "QQ";
            }
            moreItem.text = str;
            moreItem.shareInMiniProcess = z16;
            this.mMoreItemList.add(moreItem);
            this.isShareQQPresent = true;
            return this;
        }

        public Builder addShareQzone(String str, int i3, boolean z16) {
            MoreItem moreItem = new MoreItem();
            moreItem.f348090id = 2;
            moreItem.visible = this.mDisplaySettings.isShowShareQzone;
            moreItem.drawable = i3;
            if (TextUtils.isEmpty(str)) {
                str = "QQ\u7a7a\u95f4";
            }
            moreItem.text = str;
            moreItem.shareInMiniProcess = z16;
            this.mMoreItemList.add(moreItem);
            this.isShareQZonePresent = true;
            return this;
        }

        public Builder addShareWxFriends(String str, int i3, boolean z16) {
            MoreItem moreItem = new MoreItem();
            moreItem.f348090id = 3;
            moreItem.visible = this.mDisplaySettings.isShowShareWxFriends;
            moreItem.drawable = i3;
            if (TextUtils.isEmpty(str)) {
                str = "\u5fae\u4fe1\u597d\u53cb";
            }
            moreItem.text = str;
            moreItem.shareInMiniProcess = z16;
            this.mMoreItemList.add(moreItem);
            this.isShareWxFriendsPresent = true;
            return this;
        }

        public Builder addShareWxMoments(String str, int i3, boolean z16) {
            MoreItem moreItem = new MoreItem();
            moreItem.f348090id = 4;
            moreItem.visible = this.mDisplaySettings.isShowShareWxMoments;
            moreItem.drawable = i3;
            if (TextUtils.isEmpty(str)) {
                str = "\u5fae\u4fe1\u670b\u53cb\u5708";
            }
            moreItem.text = str;
            moreItem.shareInMiniProcess = z16;
            this.mMoreItemList.add(moreItem);
            this.isShareWxMomentsPresent = true;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class DisplaySettings {
        public boolean isMyFavorite;
        public boolean isShowAbout;
        public boolean isShowComplaint;
        public boolean isShowDebug;
        public boolean isShowExportLog;
        public boolean isShowFavorite;
        public boolean isShowMonitor;
        public boolean isShowQQFavorite;
        public boolean isShowRestart;
        public boolean isShowShareOthers;
        public boolean isShowShareQQ;
        public boolean isShowShareQzone;
        public boolean isShowShareWxFriends;
        public boolean isShowShareWxMoments;
        public boolean isShowShortcut;
    }

    MoreItemList() {
    }
}
