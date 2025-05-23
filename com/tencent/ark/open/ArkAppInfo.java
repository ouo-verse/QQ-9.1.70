package com.tencent.ark.open;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ArkViewModelBase;
import com.tencent.ark.Constants;
import com.tencent.ark.Logger;
import com.tencent.ark.StringUtil;
import com.tencent.ark.open.internal.ArkAppReport;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ArkAppInfo {
    private static final ArkEnvironmentManager ENV = ArkEnvironmentManager.getInstance();
    private static final String TAG = "ArkApp.ArkAppInfo";

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class AppConfig {
        public int collect;
        public long entry;
        public int flag;
        public ArrayList<String> forwardViews;
        public String iconUrl;
        public String name;
        public int replay;
        public int type;
        public AppUrlWhiteList urlWhitelist;
        public long ver;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class AppDesc {
        public String bizSrc;
        public String desc;
        public String iconPath;
        public String name;
        public String version;
        public String view;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class AppDownloadInfo {
        public AppConfig config;
        public AppDesc desc;
        public String downloadUrl;
        public String iconPath;
        public byte[] sign;
        public int updatePeriodByMinutes;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class AppUrlWhiteList {
        public final ArrayList<ArkWhiteUrlItem> resourceList = new ArrayList<>();
        public final ArrayList<ArkWhiteUrlItem> navigationList = new ArrayList<>();
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class ArkWhiteUrlItem implements Parcelable {
        public static final Parcelable.Creator<ArkWhiteUrlItem> CREATOR = new Parcelable.Creator<ArkWhiteUrlItem>() { // from class: com.tencent.ark.open.ArkAppInfo.ArkWhiteUrlItem.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ArkWhiteUrlItem createFromParcel(Parcel parcel) {
                return new ArkWhiteUrlItem(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ArkWhiteUrlItem[] newArray(int i3) {
                return new ArkWhiteUrlItem[i3];
            }
        };
        public String ruleDomain;
        public String rulePath;

        public ArkWhiteUrlItem() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return this.ruleDomain + this.rulePath;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.ruleDomain);
            parcel.writeString(this.rulePath);
        }

        protected ArkWhiteUrlItem(Parcel parcel) {
            this.ruleDomain = parcel.readString();
            this.rulePath = parcel.readString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class Meta {
        public final ArrayList<String> metaList = new ArrayList<>();
        public final ArrayList<String> metaListEx = new ArrayList<>();
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class MetaValue {
        public final HashMap<String, String> metaList = new HashMap<>();
        public final HashMap<String, String> metaListEx = new HashMap<>();
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class Size {
        public int height;
        public int width;

        public Size(int i3, int i16) {
            this.width = i3;
            this.height = i16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class TimeRecord {
        public ArkViewModelBase.TimeRecord mRecord;
        public boolean getAppFromLocal = false;
        public long beginOfGetApp = 0;
        public long endOfGetApp = 0;

        public TimeRecord(ArkViewModelBase.TimeRecord timeRecord) {
            this.mRecord = timeRecord;
        }

        private boolean isValid() {
            if (this.endOfGetApp != 0 && this.beginOfGetApp != 0) {
                ArkViewModelBase.TimeRecord timeRecord = this.mRecord;
                if (timeRecord.endOfCreateView != 0 && timeRecord.beginOfCreateView != 0 && timeRecord.endOfDisplyView != 0 && timeRecord.beginOfDisplyView != 0) {
                    return true;
                }
                return false;
            }
            return false;
        }

        public void doExtraTimeReport() {
            ArkViewModelBase.TimeRecord timeRecord = this.mRecord;
            long j3 = timeRecord.beginOfCreateContext;
            int i3 = (int) (j3 - timeRecord.endOfDisplyView);
            int i16 = (int) (timeRecord.endOfCreateDrawTarget - j3);
            long j16 = timeRecord.endOfFirstDraw;
            int i17 = (int) (j16 - timeRecord.beginOfFirstDraw);
            int i18 = (int) (j16 - timeRecord.beginOfDisplyView);
            String str = timeRecord.appName;
            String str2 = timeRecord.view;
            Logger.logI(ArkAppInfo.TAG, StringUtil.format("TimeRecord.appName.%s.view.%s.surfaceprepare.%d.createcontext.%d.firstdraw.%d.totalcost.%d.", str, str2, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18)));
            if (str != null && str2 != null) {
                ArkAppReport.legacyReport(str, Constants.Event.Action_PerfSurfacePrepare, 0, 0, i3, 0L, 0L, str2, "");
                ArkAppReport.legacyReport(str, Constants.Event.Action_PerfCreateContext, 0, 0, i16, 0L, 0L, str2, "");
                ArkAppReport.legacyReport(str, Constants.Event.Action_PerfFirstDraw, 0, 0, i17, 0L, 0L, str2, "");
                ArkAppReport.legacyReport(str, Constants.Event.Action_PerfDisplayTotalCost, 0, 0, i18, 0L, 0L, str2, "");
            }
        }

        public void doReport() {
            int i3;
            if (!isValid()) {
                return;
            }
            int i16 = (int) (this.endOfGetApp - this.beginOfGetApp);
            ArkViewModelBase.TimeRecord timeRecord = this.mRecord;
            int i17 = (int) (timeRecord.endOfCreateView - timeRecord.beginOfCreateView);
            int i18 = (int) (timeRecord.endOfDisplyView - timeRecord.beginOfDisplyView);
            int i19 = (int) (timeRecord.endOfFirstDraw - timeRecord.beginOfFirstDraw);
            String str = timeRecord.appName;
            String str2 = timeRecord.view;
            String str3 = timeRecord.bizSrc;
            Logger.logI(ArkAppInfo.TAG, StringUtil.format("TimeRecord.appName.%s.view:%s.bizSrc:%s.getapp.%d.createview.%d.dispview.%d.", str, str2, str3, Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18)));
            if (str != null && str2 != null) {
                if (this.getAppFromLocal) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                ArkAppReport.legacyReport(str, Constants.Event.Action_PerfGetApp, 0, i3, i16, 0L, 0L, str2, "");
                ArkAppReport.legacyReport(str, Constants.Event.Action_PerfCreateView, 0, 0, i17, 0L, 0L, str2, "");
                ArkAppReport.legacyReport(str, Constants.Event.Action_PerfDisplayView, 0, 0, i18, 0L, 0L, str2, "");
                ArkAppReport.reportDisplayView(str, str2, str3, true, 100, i18, i19);
            }
        }
    }
}
