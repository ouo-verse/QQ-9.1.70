package com.tencent.mobileqq.springhb.entry.model;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes18.dex */
public class UserData implements Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "SpringHb_UserData";
    public static final String USER_DATA_FILE_PREFIX = "spring_hb_2022_userdata_";
    public long closePendantTime;
    public long closeRedDotPendantTime;
    public long closeTabBannerTime;
    public int configVersion;

    /* renamed from: d, reason: collision with root package name */
    private transient String f289096d;
    public boolean hasShowBreathLight;
    public boolean hasShowGestureTs;
    public boolean hasShowedPreVideo;
    public boolean isMuteSys;
    public String lastReportTabBannerId;
    public String lastReportTabBannerTitleId;
    private int shareForbidden;
    ConcurrentHashMap<String, UserDataItem> userDataItems;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public static class UserDataItem implements Serializable {
        static IPatchRedirector $redirector_ = null;
        public static final long LEFT_COUNT_DOWN_DURATION_DEFAULT = -1;
        public String activityId;
        public long brushStartTsForReport;
        public boolean hasClickCloseBtn;
        public boolean hasDisplayBreathLight;
        public boolean hasReportedAbnormalQuit;
        public boolean hasShowedSpecialVideo;
        public boolean isAbnormalQuit;
        public boolean isHit;
        public boolean isReportBreath;
        public boolean isReportPendant;
        public long leftCountDownDuration;
        public long startGrabTs;
        public int totalGrabCountForShare;
        public int totalHitCountForShare;

        public UserDataItem(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
                return;
            }
            this.startGrabTs = 0L;
            this.leftCountDownDuration = -1L;
            this.isHit = false;
            this.hasClickCloseBtn = false;
            this.hasDisplayBreathLight = false;
            this.isAbnormalQuit = false;
            this.hasReportedAbnormalQuit = false;
            this.totalGrabCountForShare = 0;
            this.totalHitCountForShare = 0;
            this.brushStartTsForReport = -1L;
            this.hasShowedSpecialVideo = false;
            this.isReportBreath = false;
            this.isReportPendant = false;
            this.activityId = str;
        }

        public boolean equals(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj)).booleanValue();
            }
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                return this.activityId.equals(((UserDataItem) obj).activityId);
            }
            return false;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return "UserDataItem{activityId='" + this.activityId + "', startGrabTs=" + this.startGrabTs + ", leftCountDownDuration=" + this.leftCountDownDuration + ", isHit=" + this.isHit + ", hasClickCloseBtn=" + this.hasClickCloseBtn + ", hasDisplayBreathLight=" + this.hasDisplayBreathLight + ", isAbnormalQuit=" + this.isAbnormalQuit + ", hasReportedAbnormalQuit=" + this.hasReportedAbnormalQuit + ", totalGrabCountForShare=" + this.totalGrabCountForShare + ", brushStartTsForReport=" + this.brushStartTsForReport + '}';
        }
    }

    public UserData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.configVersion = 0;
        this.hasShowGestureTs = false;
        this.hasShowBreathLight = false;
        this.hasShowedPreVideo = false;
        this.closePendantTime = 0L;
        this.closeRedDotPendantTime = 0L;
        this.closeTabBannerTime = 0L;
        this.isMuteSys = false;
        this.lastReportTabBannerId = null;
        this.lastReportTabBannerTitleId = null;
        this.userDataItems = new ConcurrentHashMap<>();
        this.f289096d = null;
    }

    private String a() {
        QQAppInterface b16 = b();
        if (b16 != null) {
            return b16.getCurrentAccountUin();
        }
        return "";
    }

    private QQAppInterface b() {
        if (MobileQQ.sMobileQQ.peekAppRuntime() instanceof QQAppInterface) {
            return (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        }
        return null;
    }

    public static String getUserDataFileName(String str) {
        return USER_DATA_FILE_PREFIX + str;
    }

    @NotNull
    public static UserData read(String str) {
        UserData userData = null;
        try {
            Object readObject = FileUtils.readObject(getUserDataFileName(str));
            if (readObject instanceof UserData) {
                userData = (UserData) readObject;
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
        if (userData == null) {
            userData = new UserData();
        }
        userData.f289096d = str;
        return userData;
    }

    public static void write(String str, UserData userData) {
        FileUtils.writeObject(getUserDataFileName(str), userData);
    }

    public UserDataItem getAndGenUserDataItem(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (UserDataItem) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        UserDataItem userDataItem = this.userDataItems.get(str);
        if (userDataItem == null) {
            UserDataItem userDataItem2 = new UserDataItem(str);
            this.userDataItems.put(str, userDataItem2);
            return userDataItem2;
        }
        return userDataItem;
    }

    public String getOwnerUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        if (TextUtils.isEmpty(this.f289096d)) {
            return a();
        }
        return this.f289096d;
    }

    public int getShareForbidden() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.shareForbidden;
    }

    public boolean onGetEntryConfig(EntryConfigBean entryConfigBean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) entryConfigBean)).booleanValue();
        }
        int i3 = entryConfigBean.version;
        int i16 = this.configVersion;
        if (i3 == i16) {
            return false;
        }
        QLog.d(TAG, 1, String.format("onGetEntryConfig changed oldV=%d newV=%d", Integer.valueOf(i16), Integer.valueOf(entryConfigBean.version)));
        reset();
        this.configVersion = entryConfigBean.version;
        return true;
    }

    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.configVersion = 0;
        resetDevice();
        resetItems();
    }

    public void resetDevice() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.hasShowGestureTs = false;
        this.hasShowBreathLight = false;
        this.hasShowedPreVideo = false;
        this.closePendantTime = 0L;
        this.closeRedDotPendantTime = 0L;
        this.closeTabBannerTime = 0L;
        this.isMuteSys = false;
    }

    public void resetItems() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.userDataItems.clear();
        }
    }

    public void setShareForbidden(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.shareForbidden = i3;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return "UserData{configVersion=" + this.configVersion + ", showGestureTs=" + this.hasShowGestureTs + ", userDataItems=" + this.userDataItems + '}';
    }
}
