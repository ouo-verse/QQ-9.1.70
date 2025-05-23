package com.qzone.module.feedcomponent.actionreport;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import com.qzone.module.feedcomponent.actionreport.control.FeedActionRecorder;
import com.qzone.module.feedcomponent.ui.FeedAdvContainer;
import com.qzone.module.feedcomponent.ui.FeedContainer;
import com.qzone.module.feedcomponent.ui.FeedGalleryContainer;
import com.qzone.module.feedcomponent.ui.FeedView;
import com.qzone.module.feedcomponent.ui.FriendAnniversaryFeedView;
import com.qzone.module.feedcomponent.ui.FunctionGuideFeedView;
import com.qzone.module.feedcomponent.ui.RegisterAnniversaryFeedView;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.ui.AbsFeedView;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class FeedScrollActionReport {
    public static final int BOTTOMLINE = 3;
    static int[] LineY = new int[4];
    public static final int MAINCOMMENTLINE = 2;
    public static final int MIDDLELINE = 1;
    public static final int TOPLINE = 0;
    static FeedScrollActionReport mInstance;
    VisibleFeedInfo mVisibleFeedInfo = new VisibleFeedInfo();
    long mStartFastScrollTime = -1;
    final int BorderHeight = 10;
    public int ReportHZ = 100;
    final int InitValue = -10000;
    int currentVisibleFirstFeedBottomLineY = -10000;
    final int MOVED_RANAGE = 10;
    Map<String, FeedStayInfo> mFeedStayInfoMap = new ConcurrentHashMap();
    Object feedStayLock = new Object();
    int[] location = new int[2];

    public static FeedScrollActionReport getInstance() {
        if (mInstance == null) {
            synchronized (FeedScrollActionReport.class) {
                if (mInstance == null) {
                    mInstance = new FeedScrollActionReport();
                }
            }
        }
        return mInstance;
    }

    void CauclateFeedLinesY(int[] iArr, AbsFeedView absFeedView, int i3) {
        if (absFeedView instanceof FeedView) {
            CauclateNormalFeedLinesY(iArr, (FeedView) absFeedView, i3);
            return;
        }
        if ((absFeedView instanceof FeedContainer) || (absFeedView instanceof FeedAdvContainer) || (absFeedView instanceof FunctionGuideFeedView) || (absFeedView instanceof FriendAnniversaryFeedView) || (absFeedView instanceof FeedGalleryContainer) || (absFeedView instanceof RegisterAnniversaryFeedView)) {
            CalculateFeedContainerLinesY(iArr, absFeedView, i3);
        }
    }

    void CauclateNormalFeedLinesY(int[] iArr, FeedView feedView, int i3) {
        try {
            feedView.getLocationOnScreen(this.location);
            int i16 = this.location[1];
            iArr[0] = i16;
            iArr[3] = i16 + feedView.getHeight();
            if (feedView.getFeedOperation() != null) {
                iArr[2] = feedView.getFeedOperation().getOperationBottom() + iArr[0];
            } else if (feedView.getFeedContent() != null) {
                iArr[2] = feedView.getFeedContent().getFeedContentBottom() + iArr[0];
            } else {
                iArr[2] = iArr[0] + (feedView.getHeight() / 2);
            }
            iArr[1] = (iArr[2] + iArr[0]) / 2;
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void feedFriendActivitySwitchReport(FeedView feedView, int i3, boolean z16, int i16) {
        CauclateNormalFeedLinesY(LineY, feedView, i16);
        long currentTimeMillis = System.currentTimeMillis();
        int i17 = LineY[0];
        if (i17 > 0 && i17 < i16) {
            if (z16) {
                if (FeedGlobalEnv.g().isDebug()) {
                    Log.i("FeedReport", feedView.mFeedData.getCellUserInfo().getUser().nickName + ",topline resume report,feedIndex = " + i3);
                }
                doActionReport(feedView.mFeedData, i3, 0, currentTimeMillis, 10);
            } else {
                if (FeedGlobalEnv.g().isDebug()) {
                    Log.i("FeedReport", feedView.mFeedData.getCellUserInfo().getUser().nickName + ",topline stop report,feedIndex = " + i3);
                }
                doActionReport(feedView.mFeedData, i3, 0, currentTimeMillis, 11);
            }
        }
        int i18 = LineY[2];
        if (i18 > 0 && i18 < i16) {
            if (z16) {
                if (FeedGlobalEnv.g().isDebug()) {
                    Log.i("FeedReport", feedView.mFeedData.getCellUserInfo().getUser().nickName + ",bodyLine resume report,feedIndex = " + i3);
                }
                doActionReport(feedView.mFeedData, i3, 2, currentTimeMillis, 10);
            } else {
                if (FeedGlobalEnv.g().isDebug()) {
                    Log.i("FeedReport", feedView.mFeedData.getCellUserInfo().getUser().nickName + ",bodyLine stop report,feedIndex = " + i3);
                }
                doActionReport(feedView.mFeedData, i3, 2, currentTimeMillis, 11);
            }
        }
        int i19 = LineY[3];
        if (i19 <= 0 || i19 >= i16) {
            return;
        }
        if (z16) {
            if (FeedGlobalEnv.g().isDebug()) {
                Log.i("FeedReport", feedView.mFeedData.getCellUserInfo().getUser().nickName + ",bottomLine resume report,feedIndex = " + i3);
            }
            doActionReport(feedView.mFeedData, i3, 3, currentTimeMillis, 10);
            return;
        }
        if (FeedGlobalEnv.g().isDebug()) {
            Log.i("FeedReport", feedView.mFeedData.getCellUserInfo().getUser().nickName + ",bottomLine stop report,feedIndex = " + i3);
        }
        doActionReport(feedView.mFeedData, i3, 3, currentTimeMillis, 11);
    }

    public long finshFastScroll(ViewGroup viewGroup, Adapter adapter, long j3) {
        return j3 - this.mStartFastScrollTime;
    }

    public long getLastReportTime() {
        return this.mVisibleFeedInfo.lastReportTime;
    }

    boolean isAdapterIndexValid(Adapter adapter, int i3) {
        return i3 < adapter.getCount() && i3 >= 0;
    }

    public boolean isMovingDown() {
        VisibleFeedInfo visibleFeedInfo = this.mVisibleFeedInfo;
        int i3 = visibleFeedInfo.currentVisibleFirstFeedPosition;
        int i16 = visibleFeedInfo.lastVisibleFristFeedPosition;
        if (i3 < i16) {
            visibleFeedInfo.lastVisibleFirstFeedBottomLineY = -10000;
            return true;
        }
        if (visibleFeedInfo.currentVisibleLastFeedPosition < visibleFeedInfo.lastVisibleLastFeedPosition) {
            visibleFeedInfo.lastVisibleFirstFeedBottomLineY = -10000;
            return true;
        }
        int i17 = visibleFeedInfo.lastVisibleFirstFeedBottomLineY;
        return i17 != -10000 && i3 == i16 && i17 + 10 < this.currentVisibleFirstFeedBottomLineY;
    }

    public boolean isMovingUp() {
        VisibleFeedInfo visibleFeedInfo = this.mVisibleFeedInfo;
        int i3 = visibleFeedInfo.currentVisibleFirstFeedPosition;
        int i16 = visibleFeedInfo.lastVisibleFristFeedPosition;
        if (i3 > i16) {
            visibleFeedInfo.lastVisibleFirstFeedBottomLineY = -10000;
            return true;
        }
        if (visibleFeedInfo.currentVisibleLastFeedPosition > visibleFeedInfo.lastVisibleLastFeedPosition) {
            visibleFeedInfo.lastVisibleFirstFeedBottomLineY = -10000;
            return true;
        }
        int i17 = visibleFeedInfo.lastVisibleFirstFeedBottomLineY;
        return i17 != -10000 && i3 == i16 && i17 > this.currentVisibleFirstFeedBottomLineY + 10;
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0457  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0217  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void movingDownAcrossScreenBottomReport(Adapter adapter, long j3, long j16, ViewGroup viewGroup, int i3) {
        VisibleFeedInfo visibleFeedInfo;
        BusinessFeedData businessFeedData;
        long j17;
        int i16;
        int i17;
        int i18;
        View childAt;
        BusinessFeedData businessFeedData2;
        BusinessFeedData businessFeedData3;
        int i19;
        int i26;
        String str;
        int i27;
        long j18;
        long j19;
        View childAt2;
        BusinessFeedData businessFeedData4;
        BusinessFeedData businessFeedData5;
        int i28;
        String str2;
        int i29;
        int i36;
        BusinessFeedData businessFeedData6;
        int i37;
        String str3;
        int i38;
        long j26;
        long j27;
        if (adapter == null || viewGroup == null || (visibleFeedInfo = this.mVisibleFeedInfo) == null) {
            return;
        }
        int i39 = visibleFeedInfo.lastVisibleLastFeedPosition;
        int i46 = i39 - visibleFeedInfo.currentVisibleLastFeedPosition;
        long j28 = 2;
        String str4 = "FeedReport";
        int i47 = 1;
        if (i46 == 0) {
            if (visibleFeedInfo.lastDirectionMoveUp) {
                visibleFeedInfo.lastReportLastFeedLastLine++;
            }
            View childAt3 = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
            if ((childAt3 instanceof AbsFeedView) && isAdapterIndexValid(adapter, this.mVisibleFeedInfo.currentVisibleLastFeedPosition)) {
                CauclateFeedLinesY(LineY, (AbsFeedView) childAt3, i3);
                try {
                    businessFeedData6 = (BusinessFeedData) adapter.getItem(this.mVisibleFeedInfo.currentVisibleLastFeedPosition);
                } catch (Exception unused) {
                    businessFeedData6 = null;
                }
                if (businessFeedData6 != null) {
                    long j29 = j3 / 2;
                    int i48 = this.mVisibleFeedInfo.lastReportLastFeedLastLine - 1;
                    long j36 = (j16 - j3) + j29;
                    while (i48 >= 0) {
                        if (!isArrayIndexIsValued(LineY, i48) || LineY[i48] <= i3 - 10) {
                            i37 = i47;
                            str3 = str4;
                        } else {
                            if (i48 == i47) {
                                long j37 = j36 - (j29 / j28);
                                i38 = i48;
                                j26 = j36;
                                i37 = i47;
                                str3 = str4;
                                doMiddlePictureLineReport(businessFeedData6, this.mVisibleFeedInfo.currentVisibleLastFeedPosition, j37, false, false);
                            } else {
                                i38 = i48;
                                j26 = j36;
                                i37 = i47;
                                str3 = str4;
                                doActionReport(businessFeedData6, this.mVisibleFeedInfo.currentVisibleLastFeedPosition, i38, j26, 9);
                                if (FeedGlobalEnv.g().isDebug()) {
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append(businessFeedData6.getCellUserInfo().getUser().nickName);
                                    sb5.append(",number0,lineType = ");
                                    i48 = i38;
                                    sb5.append(i48);
                                    sb5.append(",From Bottom to leave screen ");
                                    j27 = j26;
                                    sb5.append(j27);
                                    sb5.append(",feedIndex = ");
                                    sb5.append(this.mVisibleFeedInfo.currentVisibleLastFeedPosition);
                                    Log.i(str3, sb5.toString());
                                    j36 = j27 + j29;
                                    this.mVisibleFeedInfo.lastReportLastFeedLastLine = i48;
                                }
                            }
                            i48 = i38;
                            j27 = j26;
                            j36 = j27 + j29;
                            this.mVisibleFeedInfo.lastReportLastFeedLastLine = i48;
                        }
                        i48--;
                        i47 = i37;
                        str4 = str3;
                        j28 = 2;
                    }
                }
            }
        } else {
            int i49 = 1;
            int i56 = 4;
            String str5 = ",lineType = ";
            char c16 = 3;
            if (i46 == 1) {
                if (visibleFeedInfo.lastDirectionMoveUp) {
                    visibleFeedInfo.lastReportLastFeedLastLine++;
                }
                int i57 = visibleFeedInfo.lastReportLastFeedLastLine + 0;
                long j38 = j16 - j3;
                if (i57 == 0 || !isAdapterIndexValid(adapter, i39)) {
                    str = ",lineType = ";
                    i27 = 4;
                    j18 = 0;
                } else {
                    j18 = j3 / i57;
                    try {
                        businessFeedData5 = (BusinessFeedData) adapter.getItem(this.mVisibleFeedInfo.lastVisibleLastFeedPosition);
                    } catch (Exception unused2) {
                        businessFeedData5 = null;
                    }
                    if (businessFeedData5 != null) {
                        int i58 = this.mVisibleFeedInfo.lastReportLastFeedLastLine - 1;
                        long j39 = j18;
                        while (i58 >= 0) {
                            long j46 = j38 + j39;
                            if (i58 == i49) {
                                i28 = i58;
                                str2 = str5;
                                i29 = i56;
                                doMiddlePictureLineReport(businessFeedData5, this.mVisibleFeedInfo.lastVisibleLastFeedPosition, j46 - (j18 / 2), false, false);
                            } else {
                                i28 = i58;
                                str2 = str5;
                                i29 = i56;
                                doActionReport(businessFeedData5, this.mVisibleFeedInfo.lastVisibleLastFeedPosition, i28, j46, 9);
                                if (FeedGlobalEnv.g().isDebug()) {
                                    StringBuilder sb6 = new StringBuilder();
                                    sb6.append(businessFeedData5.getCellUserInfo().getUser().nickName);
                                    sb6.append(str2);
                                    i36 = i28;
                                    sb6.append(i36);
                                    sb6.append(",From Bottom to leave screen ");
                                    sb6.append(j46);
                                    sb6.append(",feedIndex = ");
                                    sb6.append(this.mVisibleFeedInfo.lastVisibleLastFeedPosition);
                                    Log.i("FeedReport", sb6.toString());
                                    j39 += j18;
                                    i58 = i36 - 1;
                                    str5 = str2;
                                    i56 = i29;
                                    c16 = 3;
                                    i49 = 1;
                                }
                            }
                            i36 = i28;
                            j39 += j18;
                            i58 = i36 - 1;
                            str5 = str2;
                            i56 = i29;
                            c16 = 3;
                            i49 = 1;
                        }
                        str = str5;
                        i27 = i56;
                        j18 = j39;
                        j19 = j18;
                        this.mVisibleFeedInfo.lastReportLastFeedLastLine = i27;
                        childAt2 = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
                        if ((childAt2 instanceof AbsFeedView) && isAdapterIndexValid(adapter, this.mVisibleFeedInfo.currentVisibleLastFeedPosition)) {
                            CauclateFeedLinesY(LineY, (AbsFeedView) childAt2, i3);
                            try {
                                businessFeedData4 = (BusinessFeedData) adapter.getItem(this.mVisibleFeedInfo.currentVisibleLastFeedPosition);
                            } catch (Exception unused3) {
                                businessFeedData4 = null;
                            }
                            if (businessFeedData4 != null) {
                                VisibleFeedInfo visibleFeedInfo2 = this.mVisibleFeedInfo;
                                visibleFeedInfo2.lastReportLastFeedLastLine = 3;
                                long j47 = j38 + j18;
                                doActionReport(businessFeedData4, visibleFeedInfo2.currentVisibleLastFeedPosition, 3, j47, 9);
                                if (FeedGlobalEnv.g().isDebug()) {
                                    Log.i("FeedReport", businessFeedData4.getCellUserInfo().getUser().nickName + str + "3,From Bottom to leave screen " + j47 + ",feedIndex = " + this.mVisibleFeedInfo.currentVisibleLastFeedPosition);
                                }
                                long j48 = j18 + j19;
                                for (int i59 = 2; i59 >= 0; i59--) {
                                    if (isArrayIndexIsValued(LineY, i59) && LineY[i59] > i3 - 10) {
                                        long j49 = j38 + j48;
                                        if (i59 == 1) {
                                            doMiddlePictureLineReport(businessFeedData4, this.mVisibleFeedInfo.currentVisibleLastFeedPosition, j49 - (j19 / 2), false, false);
                                        } else {
                                            doActionReport(businessFeedData4, this.mVisibleFeedInfo.currentVisibleLastFeedPosition, i59, j49, 9);
                                            if (FeedGlobalEnv.g().isDebug()) {
                                                Log.i("FeedReport", businessFeedData4.getCellUserInfo().getUser().nickName + str + i59 + ",From Bottom to leave screen " + j49 + ",feedIndex=" + this.mVisibleFeedInfo.currentVisibleLastFeedPosition);
                                            }
                                        }
                                        j48 += j19;
                                        this.mVisibleFeedInfo.lastReportLastFeedLastLine = i59;
                                    }
                                }
                            }
                        }
                    } else {
                        str = ",lineType = ";
                        i27 = 4;
                    }
                }
                j19 = j18;
                this.mVisibleFeedInfo.lastReportLastFeedLastLine = i27;
                childAt2 = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
                if (childAt2 instanceof AbsFeedView) {
                    CauclateFeedLinesY(LineY, (AbsFeedView) childAt2, i3);
                    businessFeedData4 = (BusinessFeedData) adapter.getItem(this.mVisibleFeedInfo.currentVisibleLastFeedPosition);
                    if (businessFeedData4 != null) {
                    }
                }
            } else {
                long j56 = j3 / ((((i46 - 1) * 3) + visibleFeedInfo.lastReportLastFeedLastLine) + 0);
                long j57 = j16 - j3;
                if (isAdapterIndexValid(adapter, i39)) {
                    try {
                        businessFeedData = (BusinessFeedData) adapter.getItem(this.mVisibleFeedInfo.lastVisibleLastFeedPosition);
                    } catch (Exception unused4) {
                        businessFeedData = null;
                    }
                    if (businessFeedData != null) {
                        int i65 = 1;
                        int i66 = this.mVisibleFeedInfo.lastReportLastFeedLastLine - 1;
                        j17 = j56;
                        while (i66 >= 0) {
                            long j58 = j57 + j17;
                            if (i66 == i65) {
                                i16 = i66;
                                doMiddlePictureLineReport(businessFeedData, this.mVisibleFeedInfo.lastVisibleLastFeedPosition, j58 - (j56 / 2), false, false);
                            } else {
                                i16 = i66;
                                doActionReport(businessFeedData, this.mVisibleFeedInfo.lastVisibleLastFeedPosition, i16, j58, 9);
                                if (FeedGlobalEnv.g().isDebug()) {
                                    StringBuilder sb7 = new StringBuilder();
                                    sb7.append(businessFeedData.getCellUserInfo().getUser().nickName);
                                    sb7.append(",lineType = ");
                                    i17 = i16;
                                    sb7.append(i17);
                                    sb7.append(",From Bottom to leave screen ");
                                    sb7.append(j58);
                                    sb7.append(",feedIndex = ");
                                    sb7.append(this.mVisibleFeedInfo.lastVisibleLastFeedPosition);
                                    Log.i("FeedReport", sb7.toString());
                                    j17 += j56;
                                    i66 = i17 - 1;
                                    i65 = 1;
                                }
                            }
                            i17 = i16;
                            j17 += j56;
                            i66 = i17 - 1;
                            i65 = 1;
                        }
                        VisibleFeedInfo visibleFeedInfo3 = this.mVisibleFeedInfo;
                        visibleFeedInfo3.lastReportLastFeedLastLine = 4;
                        for (i18 = visibleFeedInfo3.lastVisibleLastFeedPosition - 1; i18 > this.mVisibleFeedInfo.currentVisibleLastFeedPosition; i18--) {
                            if (isAdapterIndexValid(adapter, i18)) {
                                try {
                                    businessFeedData3 = (BusinessFeedData) adapter.getItem(i18);
                                } catch (Exception unused5) {
                                    businessFeedData3 = null;
                                }
                                if (businessFeedData3 != null) {
                                    int i67 = 3;
                                    while (i67 >= 0) {
                                        long j59 = j57 + j17;
                                        if (i18 == 1) {
                                            i19 = i67;
                                            doMiddlePictureLineReport(businessFeedData3, i18, j59 - (j56 / 2), false, false);
                                        } else {
                                            i19 = i67;
                                            doActionReport(businessFeedData3, i18, i19, j59, 9);
                                            if (FeedGlobalEnv.g().isDebug()) {
                                                StringBuilder sb8 = new StringBuilder();
                                                sb8.append(businessFeedData3.getCellUserInfo().getUser().nickName);
                                                sb8.append(",lineType = ");
                                                i26 = i19;
                                                sb8.append(i26);
                                                sb8.append(",From Bottom to leave screen ");
                                                sb8.append(j59);
                                                sb8.append(",feedIndex = ");
                                                sb8.append(i18);
                                                Log.i("FeedReport", sb8.toString());
                                                j17 += j56;
                                                i67 = i26 - 1;
                                            }
                                        }
                                        i26 = i19;
                                        j17 += j56;
                                        i67 = i26 - 1;
                                    }
                                }
                            }
                        }
                        childAt = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
                        if ((childAt instanceof AbsFeedView) && isAdapterIndexValid(adapter, this.mVisibleFeedInfo.currentVisibleLastFeedPosition)) {
                            CauclateFeedLinesY(LineY, (AbsFeedView) childAt, i3);
                            try {
                                businessFeedData2 = (BusinessFeedData) adapter.getItem(this.mVisibleFeedInfo.currentVisibleLastFeedPosition);
                            } catch (Exception unused6) {
                                businessFeedData2 = null;
                            }
                            if (businessFeedData2 != null) {
                                VisibleFeedInfo visibleFeedInfo4 = this.mVisibleFeedInfo;
                                visibleFeedInfo4.lastReportLastFeedLastLine = 3;
                                long j65 = j57 + j17;
                                doActionReport(businessFeedData2, visibleFeedInfo4.currentVisibleLastFeedPosition, 3, j65, 9);
                                if (FeedGlobalEnv.g().isDebug()) {
                                    Log.i("FeedReport", businessFeedData2.getCellUserInfo().getUser().nickName + ",fast scroll,lineType = 3,From Bottom to leave screen " + j65 + ",feedIndex = " + this.mVisibleFeedInfo.currentVisibleLastFeedPosition);
                                }
                                long j66 = j17 + j56;
                                for (int i68 = 2; i68 >= 0; i68--) {
                                    if (isArrayIndexIsValued(LineY, i68) && LineY[i68] > i3 - 10) {
                                        long j67 = j57 + j66;
                                        if (i68 == 1) {
                                            doMiddlePictureLineReport(businessFeedData2, this.mVisibleFeedInfo.currentVisibleLastFeedPosition, j67 - (j56 / 2), false, false);
                                        } else {
                                            doActionReport(businessFeedData2, this.mVisibleFeedInfo.currentVisibleLastFeedPosition, i68, j67, 9);
                                            if (FeedGlobalEnv.g().isDebug()) {
                                                Log.i("FeedReport", businessFeedData2.getCellUserInfo().getUser().nickName + ",lineType = " + i68 + ",From Bottom to leave screen " + j67 + ",feedIndex = " + this.mVisibleFeedInfo.currentVisibleLastFeedPosition);
                                            }
                                        }
                                        j66 += j56;
                                        this.mVisibleFeedInfo.lastReportLastFeedLastLine = i68;
                                    }
                                }
                            }
                        }
                    }
                }
                j17 = j56;
                VisibleFeedInfo visibleFeedInfo32 = this.mVisibleFeedInfo;
                visibleFeedInfo32.lastReportLastFeedLastLine = 4;
                while (i18 > this.mVisibleFeedInfo.currentVisibleLastFeedPosition) {
                }
                childAt = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
                if (childAt instanceof AbsFeedView) {
                    CauclateFeedLinesY(LineY, (AbsFeedView) childAt, i3);
                    businessFeedData2 = (BusinessFeedData) adapter.getItem(this.mVisibleFeedInfo.currentVisibleLastFeedPosition);
                    if (businessFeedData2 != null) {
                    }
                }
            }
        }
        VisibleFeedInfo visibleFeedInfo5 = this.mVisibleFeedInfo;
        visibleFeedInfo5.lastVisibleLastFeedPosition = visibleFeedInfo5.currentVisibleLastFeedPosition;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0486  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void movingDownAcrossScreenTopReport(Adapter adapter, long j3, long j16, ViewGroup viewGroup, int i3) {
        BusinessFeedData businessFeedData;
        long j17;
        String str;
        String str2;
        int i16;
        String str3;
        String str4;
        int i17;
        String str5;
        String str6;
        int i18;
        String str7;
        String str8;
        int i19;
        int i26;
        View childAt;
        BusinessFeedData businessFeedData2;
        String str9;
        BusinessFeedData businessFeedData3;
        int i27;
        int i28;
        int i29;
        int i36;
        String str10;
        String str11;
        long j18;
        long j19;
        View childAt2;
        BusinessFeedData businessFeedData4;
        BusinessFeedData businessFeedData5;
        int i37;
        String str12;
        String str13;
        int i38;
        BusinessFeedData businessFeedData6;
        if (adapter == null || viewGroup == null) {
            return;
        }
        VisibleFeedInfo visibleFeedInfo = this.mVisibleFeedInfo;
        int i39 = visibleFeedInfo.lastVisibleFristFeedPosition;
        int i46 = i39 - visibleFeedInfo.currentVisibleFirstFeedPosition;
        int i47 = 1;
        if (i46 == 0) {
            if (visibleFeedInfo.lastDirectionMoveUp) {
                visibleFeedInfo.lastReportFirstFeedLastLine++;
            }
            View childAt3 = viewGroup.getChildAt(0);
            if ((childAt3 instanceof AbsFeedView) && isAdapterIndexValid(adapter, this.mVisibleFeedInfo.currentVisibleFirstFeedPosition)) {
                CauclateFeedLinesY(LineY, (AbsFeedView) childAt3, i3);
                try {
                    businessFeedData6 = (BusinessFeedData) adapter.getItem(this.mVisibleFeedInfo.currentVisibleFirstFeedPosition);
                } catch (Exception unused) {
                    businessFeedData6 = null;
                }
                if (businessFeedData6 != null) {
                    long j26 = j3 / 2;
                    long j27 = (j16 - j3) + j26;
                    for (int i48 = this.mVisibleFeedInfo.lastReportFirstFeedLastLine - 1; i48 >= 0; i48--) {
                        if (isArrayIndexIsValued(LineY, i48) && LineY[i48] > 10) {
                            if (i48 == 1) {
                                doMiddlePictureLineReport(businessFeedData6, this.mVisibleFeedInfo.currentVisibleFirstFeedPosition, j27 - (j26 / 2), true, false);
                            } else {
                                doActionReport(businessFeedData6, this.mVisibleFeedInfo.currentVisibleFirstFeedPosition, i48, j27, 6);
                                if (FeedGlobalEnv.g().isDebug()) {
                                    Log.i("FeedReport", businessFeedData6.getCellUserInfo().getUser().nickName + ",number0,lineType = " + i48 + ",From Top to enter screen" + j27 + ",feedIndex = " + this.mVisibleFeedInfo.currentVisibleFirstFeedPosition);
                                }
                            }
                            j27 += j26;
                            this.mVisibleFeedInfo.lastReportFirstFeedLastLine = i48;
                        }
                    }
                }
            }
        } else {
            String str14 = ",fast scroll,lineType = ";
            String str15 = ",From Top to Enter screen ";
            String str16 = "FeedReport";
            if (i46 == 1) {
                if (visibleFeedInfo.lastDirectionMoveUp) {
                    visibleFeedInfo.lastReportFirstFeedLastLine++;
                }
                int i49 = visibleFeedInfo.lastReportFirstFeedLastLine - 0;
                long j28 = j16 - j3;
                if (i49 == 0 || !isAdapterIndexValid(adapter, i39)) {
                    str10 = ",fast scroll,lineType = ";
                    str11 = str16;
                    j18 = 0;
                } else {
                    j18 = j3 / i49;
                    try {
                        businessFeedData5 = (BusinessFeedData) adapter.getItem(this.mVisibleFeedInfo.lastVisibleFristFeedPosition);
                    } catch (Exception unused2) {
                        businessFeedData5 = null;
                    }
                    if (businessFeedData5 != null) {
                        int i56 = this.mVisibleFeedInfo.lastReportFirstFeedLastLine - 1;
                        long j29 = j18;
                        while (i56 >= 0) {
                            long j36 = j28 + j29;
                            if (i56 == i47) {
                                i37 = i56;
                                str12 = str14;
                                str13 = str16;
                                doMiddlePictureLineReport(businessFeedData5, this.mVisibleFeedInfo.lastVisibleFristFeedPosition, j36 - (j18 / 2), true, false);
                            } else {
                                i37 = i56;
                                str12 = str14;
                                str13 = str16;
                                doActionReport(businessFeedData5, this.mVisibleFeedInfo.lastVisibleFristFeedPosition, i37, j36, 6);
                                if (FeedGlobalEnv.g().isDebug()) {
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append(businessFeedData5.getCellUserInfo().getUser().nickName);
                                    sb5.append(",lineType = ");
                                    i38 = i37;
                                    sb5.append(i38);
                                    sb5.append(",From Top to enter screen");
                                    sb5.append(j36);
                                    sb5.append(",feedIndex = ");
                                    sb5.append(this.mVisibleFeedInfo.lastVisibleFristFeedPosition);
                                    Log.i(str13, sb5.toString());
                                    j29 += j18;
                                    i56 = i38 - 1;
                                    str16 = str13;
                                    str14 = str12;
                                    i47 = 1;
                                }
                            }
                            i38 = i37;
                            j29 += j18;
                            i56 = i38 - 1;
                            str16 = str13;
                            str14 = str12;
                            i47 = 1;
                        }
                        str10 = str14;
                        str11 = str16;
                        j19 = j18;
                        j18 = j29;
                        this.mVisibleFeedInfo.lastReportFirstFeedLastLine = 4;
                        childAt2 = viewGroup.getChildAt(0);
                        if ((childAt2 instanceof AbsFeedView) && isAdapterIndexValid(adapter, this.mVisibleFeedInfo.currentVisibleFirstFeedPosition)) {
                            CauclateFeedLinesY(LineY, (AbsFeedView) childAt2, i3);
                            try {
                                businessFeedData4 = (BusinessFeedData) adapter.getItem(this.mVisibleFeedInfo.currentVisibleFirstFeedPosition);
                            } catch (Exception unused3) {
                                businessFeedData4 = null;
                            }
                            if (businessFeedData4 != null) {
                                VisibleFeedInfo visibleFeedInfo2 = this.mVisibleFeedInfo;
                                visibleFeedInfo2.lastReportFirstFeedLastLine = 3;
                                long j37 = j28 + j18;
                                doActionReport(businessFeedData4, visibleFeedInfo2.currentVisibleFirstFeedPosition, 3, j37, 6);
                                if (FeedGlobalEnv.g().isDebug()) {
                                    Log.i(str11, businessFeedData4.getCellUserInfo().getUser().nickName + str10 + "3,From Top to Enter screen " + j37 + ",feedIndex = " + this.mVisibleFeedInfo.currentVisibleFirstFeedPosition);
                                }
                                long j38 = j18 + j19;
                                for (int i57 = 2; i57 >= 0; i57--) {
                                    if (isArrayIndexIsValued(LineY, i57) && LineY[i57] > 10) {
                                        long j39 = j28 + j38;
                                        if (i57 == 1) {
                                            doMiddlePictureLineReport(businessFeedData4, this.mVisibleFeedInfo.currentVisibleFirstFeedPosition, j39 - (j19 / 2), true, false);
                                        } else {
                                            doActionReport(businessFeedData4, this.mVisibleFeedInfo.currentVisibleFirstFeedPosition, i57, j39, 6);
                                            if (FeedGlobalEnv.g().isDebug()) {
                                                Log.i(str11, businessFeedData4.getCellUserInfo().getUser().nickName + ",lineType = " + i57 + ",From Top to Enter screen " + j39 + ",feedIndex = " + this.mVisibleFeedInfo.currentVisibleFirstFeedPosition);
                                            }
                                        }
                                        j38 += j19;
                                        this.mVisibleFeedInfo.lastReportFirstFeedLastLine = i57;
                                    }
                                }
                            }
                        }
                    } else {
                        str10 = ",fast scroll,lineType = ";
                        str11 = str16;
                    }
                }
                j19 = j18;
                this.mVisibleFeedInfo.lastReportFirstFeedLastLine = 4;
                childAt2 = viewGroup.getChildAt(0);
                if (childAt2 instanceof AbsFeedView) {
                    CauclateFeedLinesY(LineY, (AbsFeedView) childAt2, i3);
                    businessFeedData4 = (BusinessFeedData) adapter.getItem(this.mVisibleFeedInfo.currentVisibleFirstFeedPosition);
                    if (businessFeedData4 != null) {
                    }
                }
            } else {
                String str17 = ",fast scroll,lineType = ";
                int i58 = 1;
                long j46 = j3 / ((((i46 - 1) * 3) + visibleFeedInfo.lastReportFirstFeedLastLine) - 0);
                long j47 = j16 - j3;
                String str18 = ",feedIndex=";
                String str19 = ",From Top to enter screen ";
                if (isAdapterIndexValid(adapter, i39)) {
                    try {
                        businessFeedData = (BusinessFeedData) adapter.getItem(this.mVisibleFeedInfo.lastVisibleFristFeedPosition);
                    } catch (Exception unused4) {
                        businessFeedData = null;
                    }
                    if (businessFeedData != null) {
                        int i59 = this.mVisibleFeedInfo.lastReportFirstFeedLastLine - 1;
                        j17 = j46;
                        while (i59 >= 0) {
                            long j48 = j47 + j17;
                            if (i59 == i58) {
                                i17 = i59;
                                str5 = str19;
                                str7 = str15;
                                str8 = str18;
                                str6 = str17;
                                i18 = 1;
                                doMiddlePictureLineReport(businessFeedData, this.mVisibleFeedInfo.lastVisibleFristFeedPosition, j48 - (j46 / 2), true, false);
                            } else {
                                i17 = i59;
                                str5 = str19;
                                str6 = str17;
                                i18 = i58;
                                str7 = str15;
                                str8 = str18;
                                doActionReport(businessFeedData, this.mVisibleFeedInfo.lastVisibleFristFeedPosition, i17, j48, 6);
                                if (FeedGlobalEnv.g().isDebug()) {
                                    StringBuilder sb6 = new StringBuilder();
                                    sb6.append(businessFeedData.getCellUserInfo().getUser().nickName);
                                    sb6.append(",lineType = ");
                                    i19 = i17;
                                    sb6.append(i19);
                                    sb6.append(str5);
                                    sb6.append(j48);
                                    sb6.append(str8);
                                    sb6.append(this.mVisibleFeedInfo.lastVisibleFristFeedPosition);
                                    Log.i(str16, sb6.toString());
                                    j17 += j46;
                                    i59 = i19 - 1;
                                    i58 = i18;
                                    str19 = str5;
                                    str18 = str8;
                                    str15 = str7;
                                    str17 = str6;
                                }
                            }
                            i19 = i17;
                            j17 += j46;
                            i59 = i19 - 1;
                            i58 = i18;
                            str19 = str5;
                            str18 = str8;
                            str15 = str7;
                            str17 = str6;
                        }
                        str = str19;
                        str2 = str17;
                        i16 = i58;
                        str3 = str15;
                        str4 = str18;
                        VisibleFeedInfo visibleFeedInfo3 = this.mVisibleFeedInfo;
                        visibleFeedInfo3.lastReportFirstFeedLastLine = 4;
                        i26 = visibleFeedInfo3.lastVisibleFristFeedPosition - i16;
                        while (i26 > this.mVisibleFeedInfo.currentVisibleFirstFeedPosition) {
                            if (isAdapterIndexValid(adapter, i26)) {
                                try {
                                    businessFeedData3 = (BusinessFeedData) adapter.getItem(i26);
                                } catch (Exception unused5) {
                                    businessFeedData3 = null;
                                }
                                if (businessFeedData3 != null) {
                                    int i65 = 3;
                                    while (i65 >= 0) {
                                        long j49 = j47 + j17;
                                        if (i26 == i16) {
                                            i27 = i65;
                                            i28 = i26;
                                            doMiddlePictureLineReport(businessFeedData3, i26, j49 - (j46 / 2), true, false);
                                        } else {
                                            i27 = i65;
                                            i28 = i26;
                                            doActionReport(businessFeedData3, i28, i27, j49, 6);
                                            if (FeedGlobalEnv.g().isDebug()) {
                                                StringBuilder sb7 = new StringBuilder();
                                                sb7.append(businessFeedData3.getCellUserInfo().getUser().nickName);
                                                sb7.append(",lineType = ");
                                                i29 = i27;
                                                sb7.append(i29);
                                                sb7.append(str);
                                                sb7.append(j49);
                                                sb7.append(",feedIndex = ");
                                                i36 = i28;
                                                sb7.append(i36);
                                                Log.i(str16, sb7.toString());
                                                j17 += j46;
                                                i65 = i29 - 1;
                                                i26 = i36;
                                            }
                                        }
                                        i29 = i27;
                                        i36 = i28;
                                        j17 += j46;
                                        i65 = i29 - 1;
                                        i26 = i36;
                                    }
                                }
                            }
                            i26--;
                        }
                        childAt = viewGroup.getChildAt(0);
                        if ((childAt instanceof AbsFeedView) && isAdapterIndexValid(adapter, this.mVisibleFeedInfo.currentVisibleFirstFeedPosition)) {
                            int i66 = i16;
                            CauclateFeedLinesY(LineY, (AbsFeedView) childAt, i3);
                            try {
                                businessFeedData2 = (BusinessFeedData) adapter.getItem(this.mVisibleFeedInfo.currentVisibleFirstFeedPosition);
                            } catch (Exception unused6) {
                                businessFeedData2 = null;
                            }
                            if (businessFeedData2 != null) {
                                VisibleFeedInfo visibleFeedInfo4 = this.mVisibleFeedInfo;
                                visibleFeedInfo4.lastReportFirstFeedLastLine = 3;
                                long j56 = j47 + j17;
                                doActionReport(businessFeedData2, visibleFeedInfo4.currentVisibleFirstFeedPosition, 3, j56, 6);
                                if (FeedGlobalEnv.g().isDebug()) {
                                    StringBuilder sb8 = new StringBuilder();
                                    sb8.append(businessFeedData2.getCellUserInfo().getUser().nickName);
                                    sb8.append(str2);
                                    sb8.append(3);
                                    str9 = str3;
                                    sb8.append(str9);
                                    sb8.append(j56);
                                    sb8.append(str4);
                                    sb8.append(this.mVisibleFeedInfo.currentVisibleFirstFeedPosition);
                                    Log.i(str16, sb8.toString());
                                } else {
                                    str9 = str3;
                                }
                                long j57 = j17 + j46;
                                for (int i67 = 2; i67 >= 0; i67--) {
                                    if (isArrayIndexIsValued(LineY, i67) && LineY[i67] > 10) {
                                        long j58 = j47 + j57;
                                        if (i67 == i66) {
                                            doMiddlePictureLineReport(businessFeedData2, this.mVisibleFeedInfo.currentVisibleFirstFeedPosition, j58 - (j46 / 2), true, false);
                                        } else {
                                            doActionReport(businessFeedData2, this.mVisibleFeedInfo.currentVisibleFirstFeedPosition, i67, j58, 6);
                                            if (FeedGlobalEnv.g().isDebug()) {
                                                Log.i(str16, businessFeedData2.getCellUserInfo().getUser().nickName + ",lineType = " + i67 + str9 + j58 + ",feedIndex = " + this.mVisibleFeedInfo.currentVisibleFirstFeedPosition);
                                            }
                                        }
                                        j57 += j46;
                                        this.mVisibleFeedInfo.lastReportFirstFeedLastLine = i67;
                                    }
                                }
                            }
                        }
                    }
                }
                str = ",From Top to enter screen ";
                str2 = str17;
                i16 = 1;
                str3 = ",From Top to Enter screen ";
                str4 = ",feedIndex=";
                j17 = j46;
                VisibleFeedInfo visibleFeedInfo32 = this.mVisibleFeedInfo;
                visibleFeedInfo32.lastReportFirstFeedLastLine = 4;
                i26 = visibleFeedInfo32.lastVisibleFristFeedPosition - i16;
                while (i26 > this.mVisibleFeedInfo.currentVisibleFirstFeedPosition) {
                }
                childAt = viewGroup.getChildAt(0);
                if (childAt instanceof AbsFeedView) {
                    int i662 = i16;
                    CauclateFeedLinesY(LineY, (AbsFeedView) childAt, i3);
                    businessFeedData2 = (BusinessFeedData) adapter.getItem(this.mVisibleFeedInfo.currentVisibleFirstFeedPosition);
                    if (businessFeedData2 != null) {
                    }
                }
            }
        }
        VisibleFeedInfo visibleFeedInfo5 = this.mVisibleFeedInfo;
        visibleFeedInfo5.lastVisibleFristFeedPosition = visibleFeedInfo5.currentVisibleFirstFeedPosition;
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0485  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x022b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void movingUpAcrossScreenBottomReport(Adapter adapter, long j3, long j16, ViewGroup viewGroup, int i3) {
        BusinessFeedData businessFeedData;
        long j17;
        int i16;
        String str;
        int i17;
        int i18;
        View childAt;
        BusinessFeedData businessFeedData2;
        BusinessFeedData businessFeedData3;
        int i19;
        int i26;
        String str2;
        int i27;
        String str3;
        long j18;
        long j19;
        View childAt2;
        BusinessFeedData businessFeedData4;
        String str4;
        BusinessFeedData businessFeedData5;
        int i28;
        String str5;
        int i29;
        String str6;
        int i36;
        BusinessFeedData businessFeedData6;
        int i37;
        String str7;
        int i38;
        long j26;
        long j27;
        int i39;
        long j28;
        if (adapter == null || viewGroup == null) {
            return;
        }
        VisibleFeedInfo visibleFeedInfo = this.mVisibleFeedInfo;
        int i46 = visibleFeedInfo.currentVisibleLastFeedPosition;
        int i47 = visibleFeedInfo.lastVisibleLastFeedPosition;
        int i48 = i46 - i47;
        long j29 = 2;
        String str8 = "FeedReport";
        int i49 = 3;
        int i56 = 1;
        if (i48 == 0) {
            if (!visibleFeedInfo.lastDirectionMoveUp) {
                visibleFeedInfo.lastReportLastFeedLastLine--;
            }
            View childAt3 = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
            if ((childAt3 instanceof AbsFeedView) && isAdapterIndexValid(adapter, this.mVisibleFeedInfo.currentVisibleLastFeedPosition)) {
                CauclateFeedLinesY(LineY, (AbsFeedView) childAt3, i3);
                try {
                    businessFeedData6 = (BusinessFeedData) adapter.getItem(this.mVisibleFeedInfo.currentVisibleLastFeedPosition);
                } catch (Exception unused) {
                    businessFeedData6 = null;
                }
                if (businessFeedData6 != null) {
                    long j36 = j3 / 2;
                    int i57 = this.mVisibleFeedInfo.lastReportLastFeedLastLine + 1;
                    long j37 = (j16 - j3) + j36;
                    while (i57 <= i49) {
                        if (!isArrayIndexIsValued(LineY, i57) || LineY[i57] >= i3 - 10) {
                            i37 = i56;
                            str7 = str8;
                            i38 = i57;
                            j26 = j37;
                        } else {
                            if (i57 == i56) {
                                long j38 = j37 - (j36 / j29);
                                j27 = j37;
                                i39 = i57;
                                i37 = i56;
                                str7 = str8;
                                doMiddlePictureLineReport(businessFeedData6, this.mVisibleFeedInfo.currentVisibleLastFeedPosition, j38, false, true);
                            } else {
                                j27 = j37;
                                i37 = i56;
                                i39 = i57;
                                str7 = str8;
                                doActionReport(businessFeedData6, this.mVisibleFeedInfo.currentVisibleLastFeedPosition, i39, j27, 8);
                                if (FeedGlobalEnv.g().isDebug()) {
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append(businessFeedData6.getCellUserInfo().getUser().nickName);
                                    sb5.append(",number0,lineType = ");
                                    i38 = i39;
                                    sb5.append(i38);
                                    sb5.append(",From Bottom to enter screen ");
                                    j28 = j27;
                                    sb5.append(j28);
                                    sb5.append(",feedIndex = ");
                                    sb5.append(this.mVisibleFeedInfo.currentVisibleLastFeedPosition);
                                    Log.i(str7, sb5.toString());
                                    this.mVisibleFeedInfo.lastReportLastFeedLastLine = i38;
                                    j26 = j28 + j36;
                                }
                            }
                            j28 = j27;
                            i38 = i39;
                            this.mVisibleFeedInfo.lastReportLastFeedLastLine = i38;
                            j26 = j28 + j36;
                        }
                        i57 = i38 + 1;
                        j37 = j26;
                        str8 = str7;
                        i56 = i37;
                        i49 = 3;
                        j29 = 2;
                    }
                }
            }
        } else {
            int i58 = 1;
            String str9 = ",From Bottom to enter screen";
            int i59 = -1;
            String str10 = ",lineType = ";
            if (i48 == 1) {
                if (!visibleFeedInfo.lastDirectionMoveUp) {
                    visibleFeedInfo.lastReportLastFeedLastLine--;
                }
                int i65 = 3 - visibleFeedInfo.lastReportLastFeedLastLine;
                long j39 = j16 - j3;
                if (i65 == 0 || !isAdapterIndexValid(adapter, i47)) {
                    str2 = ",lineType = ";
                    i27 = -1;
                    str3 = ",From Bottom to enter screen";
                    j18 = 0;
                } else {
                    j18 = j3 / i65;
                    try {
                        businessFeedData5 = (BusinessFeedData) adapter.getItem(this.mVisibleFeedInfo.lastVisibleLastFeedPosition);
                    } catch (Exception unused2) {
                        businessFeedData5 = null;
                    }
                    if (businessFeedData5 != null) {
                        int i66 = this.mVisibleFeedInfo.lastReportLastFeedLastLine + 1;
                        long j46 = j18;
                        int i67 = 3;
                        while (i66 <= i67) {
                            long j47 = j39 + j46;
                            if (i66 == i58) {
                                i28 = i66;
                                str5 = str10;
                                i29 = i59;
                                str6 = str9;
                                doMiddlePictureLineReport(businessFeedData5, this.mVisibleFeedInfo.lastVisibleLastFeedPosition, j47 - (j18 / 2), false, true);
                            } else {
                                i28 = i66;
                                str5 = str10;
                                i29 = i59;
                                str6 = str9;
                                doActionReport(businessFeedData5, this.mVisibleFeedInfo.lastVisibleLastFeedPosition, i28, j47, 8);
                                if (FeedGlobalEnv.g().isDebug()) {
                                    StringBuilder sb6 = new StringBuilder();
                                    sb6.append(businessFeedData5.getCellUserInfo().getUser().nickName);
                                    sb6.append(str5);
                                    i36 = i28;
                                    sb6.append(i36);
                                    sb6.append(",From Bottom to enter screen ");
                                    sb6.append(j47);
                                    sb6.append(",feedIndex = ");
                                    sb6.append(this.mVisibleFeedInfo.lastVisibleLastFeedPosition);
                                    Log.i("FeedReport", sb6.toString());
                                    j46 += j18;
                                    i66 = i36 + 1;
                                    str10 = str5;
                                    i59 = i29;
                                    str9 = str6;
                                    i67 = 3;
                                    i58 = 1;
                                }
                            }
                            i36 = i28;
                            j46 += j18;
                            i66 = i36 + 1;
                            str10 = str5;
                            i59 = i29;
                            str9 = str6;
                            i67 = 3;
                            i58 = 1;
                        }
                        str2 = str10;
                        i27 = i59;
                        str3 = str9;
                        j18 = j46;
                        j19 = j18;
                        this.mVisibleFeedInfo.lastReportLastFeedLastLine = i27;
                        childAt2 = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
                        if ((childAt2 instanceof AbsFeedView) && isAdapterIndexValid(adapter, this.mVisibleFeedInfo.currentVisibleLastFeedPosition)) {
                            CauclateFeedLinesY(LineY, (AbsFeedView) childAt2, i3);
                            try {
                                businessFeedData4 = (BusinessFeedData) adapter.getItem(this.mVisibleFeedInfo.currentVisibleLastFeedPosition);
                            } catch (Exception unused3) {
                                businessFeedData4 = null;
                            }
                            if (businessFeedData4 != null) {
                                VisibleFeedInfo visibleFeedInfo2 = this.mVisibleFeedInfo;
                                visibleFeedInfo2.lastReportLastFeedLastLine = 0;
                                long j48 = j39 + j18;
                                doActionReport(businessFeedData4, visibleFeedInfo2.currentVisibleLastFeedPosition, 0, j48, 8);
                                if (FeedGlobalEnv.g().isDebug()) {
                                    Log.i("FeedReport", businessFeedData4.getCellUserInfo().getUser().nickName + str2 + "0,From Bottom to enter screen " + j48 + ",feedIndex = " + this.mVisibleFeedInfo.currentVisibleLastFeedPosition);
                                }
                                long j49 = j18 + j19;
                                int i68 = 1;
                                for (int i69 = 3; i68 <= i69; i69 = 3) {
                                    if (!isArrayIndexIsValued(LineY, i68) || LineY[i68] >= i3 - 10) {
                                        str4 = str3;
                                    } else {
                                        long j56 = j39 + j49;
                                        if (i68 == 1) {
                                            doMiddlePictureLineReport(businessFeedData4, this.mVisibleFeedInfo.currentVisibleLastFeedPosition, j56 - (j19 / 2), false, true);
                                        } else {
                                            doActionReport(businessFeedData4, this.mVisibleFeedInfo.currentVisibleLastFeedPosition, i68, j56, 8);
                                            if (FeedGlobalEnv.g().isDebug()) {
                                                StringBuilder sb7 = new StringBuilder();
                                                sb7.append(businessFeedData4.getCellUserInfo().getUser().nickName);
                                                sb7.append(str2);
                                                sb7.append(i68);
                                                str4 = str3;
                                                sb7.append(str4);
                                                sb7.append(j56);
                                                sb7.append(",feedIndex = ");
                                                sb7.append(this.mVisibleFeedInfo.currentVisibleLastFeedPosition);
                                                Log.i("FeedReport", sb7.toString());
                                                j49 += j19;
                                                this.mVisibleFeedInfo.lastReportLastFeedLastLine = i68;
                                            }
                                        }
                                        str4 = str3;
                                        j49 += j19;
                                        this.mVisibleFeedInfo.lastReportLastFeedLastLine = i68;
                                    }
                                    i68++;
                                    str3 = str4;
                                }
                            }
                        }
                    } else {
                        str2 = ",lineType = ";
                        i27 = -1;
                        str3 = ",From Bottom to enter screen";
                    }
                }
                j19 = j18;
                this.mVisibleFeedInfo.lastReportLastFeedLastLine = i27;
                childAt2 = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
                if (childAt2 instanceof AbsFeedView) {
                    CauclateFeedLinesY(LineY, (AbsFeedView) childAt2, i3);
                    businessFeedData4 = (BusinessFeedData) adapter.getItem(this.mVisibleFeedInfo.currentVisibleLastFeedPosition);
                    if (businessFeedData4 != null) {
                    }
                }
            } else {
                long j57 = j3 / ((((i48 - 1) * 3) + 3) - visibleFeedInfo.lastReportLastFeedLastLine);
                long j58 = j16 - j3;
                if (isAdapterIndexValid(adapter, i47)) {
                    try {
                        businessFeedData = (BusinessFeedData) adapter.getItem(this.mVisibleFeedInfo.lastVisibleLastFeedPosition);
                    } catch (Exception unused4) {
                        businessFeedData = null;
                    }
                    if (businessFeedData != null) {
                        int i75 = 1;
                        int i76 = this.mVisibleFeedInfo.lastReportLastFeedLastLine + 1;
                        j17 = j57;
                        int i77 = 3;
                        while (i76 <= i77) {
                            long j59 = j58 + j17;
                            if (i76 == i75) {
                                i16 = i76;
                                str = str9;
                                doMiddlePictureLineReport(businessFeedData, this.mVisibleFeedInfo.lastVisibleLastFeedPosition, j59 - (j57 / 2), false, true);
                            } else {
                                i16 = i76;
                                str = str9;
                                doActionReport(businessFeedData, this.mVisibleFeedInfo.lastVisibleLastFeedPosition, i16, j59, 8);
                                if (FeedGlobalEnv.g().isDebug()) {
                                    StringBuilder sb8 = new StringBuilder();
                                    sb8.append(businessFeedData.getCellUserInfo().getUser().nickName);
                                    sb8.append(",lineType = ");
                                    i17 = i16;
                                    sb8.append(i17);
                                    sb8.append(str);
                                    sb8.append(j59);
                                    sb8.append(",feedIndex = ");
                                    sb8.append(this.mVisibleFeedInfo.lastVisibleLastFeedPosition);
                                    Log.i("FeedReport", sb8.toString());
                                    j17 += j57;
                                    i76 = i17 + 1;
                                    str9 = str;
                                    i77 = 3;
                                    i75 = 1;
                                }
                            }
                            i17 = i16;
                            j17 += j57;
                            i76 = i17 + 1;
                            str9 = str;
                            i77 = 3;
                            i75 = 1;
                        }
                        VisibleFeedInfo visibleFeedInfo3 = this.mVisibleFeedInfo;
                        visibleFeedInfo3.lastReportLastFeedLastLine = -1;
                        for (i18 = visibleFeedInfo3.lastVisibleLastFeedPosition + 1; i18 < this.mVisibleFeedInfo.currentVisibleLastFeedPosition; i18++) {
                            if (isAdapterIndexValid(adapter, i18)) {
                                try {
                                    businessFeedData3 = (BusinessFeedData) adapter.getItem(i18);
                                } catch (Exception unused5) {
                                    businessFeedData3 = null;
                                }
                                if (businessFeedData3 != null) {
                                    int i78 = 0;
                                    for (int i79 = 3; i78 <= i79; i79 = 3) {
                                        long j65 = j58 + j17;
                                        if (i18 == 1) {
                                            i19 = i78;
                                            doMiddlePictureLineReport(businessFeedData3, i18, j65 - (j57 / 2), false, true);
                                        } else {
                                            i19 = i78;
                                            doActionReport(businessFeedData3, i18, i19, j65, 8);
                                            if (FeedGlobalEnv.g().isDebug()) {
                                                StringBuilder sb9 = new StringBuilder();
                                                sb9.append(businessFeedData3.getCellUserInfo().getUser().nickName);
                                                sb9.append(",lineType = ");
                                                i26 = i19;
                                                sb9.append(i26);
                                                sb9.append(",From Bottom to enter screen ");
                                                sb9.append(j65);
                                                sb9.append(",feedIndex = ");
                                                sb9.append(i18);
                                                Log.i("FeedReport", sb9.toString());
                                                j17 += j57;
                                                i78 = i26 + 1;
                                            }
                                        }
                                        i26 = i19;
                                        j17 += j57;
                                        i78 = i26 + 1;
                                    }
                                }
                            }
                        }
                        childAt = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
                        if ((childAt instanceof AbsFeedView) && isAdapterIndexValid(adapter, this.mVisibleFeedInfo.currentVisibleLastFeedPosition)) {
                            CauclateFeedLinesY(LineY, (AbsFeedView) childAt, i3);
                            try {
                                businessFeedData2 = (BusinessFeedData) adapter.getItem(this.mVisibleFeedInfo.currentVisibleLastFeedPosition);
                            } catch (Exception unused6) {
                                businessFeedData2 = null;
                            }
                            if (businessFeedData2 != null) {
                                VisibleFeedInfo visibleFeedInfo4 = this.mVisibleFeedInfo;
                                visibleFeedInfo4.lastReportLastFeedLastLine = 0;
                                long j66 = j58 + j17;
                                doActionReport(businessFeedData2, visibleFeedInfo4.currentVisibleLastFeedPosition, 0, j66, 8);
                                if (FeedGlobalEnv.g().isDebug()) {
                                    Log.i("FeedReport", businessFeedData2.getCellUserInfo().getUser().nickName + ",lineType = 0,From Bottom to enter screen " + j66 + ",feedIndex = " + this.mVisibleFeedInfo.currentVisibleLastFeedPosition);
                                }
                                long j67 = j17 + j57;
                                for (int i85 = 1; i85 <= 3; i85++) {
                                    if (isArrayIndexIsValued(LineY, i85) && LineY[i85] < i3 - 10) {
                                        long j68 = j58 + j67;
                                        if (i85 == 1) {
                                            doMiddlePictureLineReport(businessFeedData2, this.mVisibleFeedInfo.currentVisibleLastFeedPosition, j68 - (j57 / 2), false, true);
                                        } else {
                                            doActionReport(businessFeedData2, this.mVisibleFeedInfo.currentVisibleLastFeedPosition, i85, j68, 8);
                                            if (FeedGlobalEnv.g().isDebug()) {
                                                Log.i("FeedReport", businessFeedData2.getCellUserInfo().getUser().nickName + ",lineType = " + i85 + ",From Bottom to enter screen " + j68 + ",feedIndex = " + this.mVisibleFeedInfo.currentVisibleLastFeedPosition);
                                            }
                                        }
                                        j67 += j57;
                                        this.mVisibleFeedInfo.lastReportLastFeedLastLine = i85;
                                    }
                                }
                            }
                        }
                    }
                }
                j17 = j57;
                VisibleFeedInfo visibleFeedInfo32 = this.mVisibleFeedInfo;
                visibleFeedInfo32.lastReportLastFeedLastLine = -1;
                while (i18 < this.mVisibleFeedInfo.currentVisibleLastFeedPosition) {
                }
                childAt = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
                if (childAt instanceof AbsFeedView) {
                    CauclateFeedLinesY(LineY, (AbsFeedView) childAt, i3);
                    businessFeedData2 = (BusinessFeedData) adapter.getItem(this.mVisibleFeedInfo.currentVisibleLastFeedPosition);
                    if (businessFeedData2 != null) {
                    }
                }
            }
        }
        VisibleFeedInfo visibleFeedInfo5 = this.mVisibleFeedInfo;
        visibleFeedInfo5.lastVisibleLastFeedPosition = visibleFeedInfo5.currentVisibleLastFeedPosition;
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void movingUpAcrossScreenTopReport(Adapter adapter, long j3, long j16, ViewGroup viewGroup, int i3) {
        BusinessFeedData businessFeedData;
        long j17;
        int i16;
        int i17;
        int i18;
        View childAt;
        BusinessFeedData businessFeedData2;
        BusinessFeedData businessFeedData3;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        String str;
        String str2;
        long j18;
        long j19;
        View childAt2;
        BusinessFeedData businessFeedData4;
        BusinessFeedData businessFeedData5;
        int i36;
        int i37;
        String str3;
        String str4;
        int i38;
        BusinessFeedData businessFeedData6;
        if (adapter == null || viewGroup == null) {
            return;
        }
        VisibleFeedInfo visibleFeedInfo = this.mVisibleFeedInfo;
        int i39 = visibleFeedInfo.currentVisibleFirstFeedPosition;
        int i46 = visibleFeedInfo.lastVisibleFristFeedPosition;
        int i47 = i39 - i46;
        long j26 = 2;
        String str5 = ",feedIndex = ";
        String str6 = "FeedReport";
        int i48 = 0;
        int i49 = 3;
        int i56 = 1;
        if (i47 == 0) {
            if (!visibleFeedInfo.lastDirectionMoveUp) {
                visibleFeedInfo.lastReportFirstFeedLastLine--;
            }
            View childAt3 = viewGroup.getChildAt(0);
            if ((childAt3 instanceof AbsFeedView) && isAdapterIndexValid(adapter, this.mVisibleFeedInfo.currentVisibleFirstFeedPosition)) {
                CauclateFeedLinesY(LineY, (AbsFeedView) childAt3, i3);
                try {
                    businessFeedData6 = (BusinessFeedData) adapter.getItem(this.mVisibleFeedInfo.currentVisibleFirstFeedPosition);
                } catch (Exception unused) {
                    businessFeedData6 = null;
                }
                if (businessFeedData6 != null) {
                    long j27 = j3 / 2;
                    long j28 = (j16 - j3) + j27;
                    for (int i57 = this.mVisibleFeedInfo.lastReportFirstFeedLastLine + 1; i57 <= 3; i57++) {
                        if (isArrayIndexIsValued(LineY, i57) && LineY[i57] < 10) {
                            if (i57 == 1) {
                                doMiddlePictureLineReport(businessFeedData6, this.mVisibleFeedInfo.currentVisibleFirstFeedPosition, j28 - (j27 / 2), true, true);
                            } else {
                                doActionReport(businessFeedData6, this.mVisibleFeedInfo.currentVisibleFirstFeedPosition, i57, j28, 7);
                                if (FeedGlobalEnv.g().isDebug()) {
                                    Log.i("FeedReport", businessFeedData6.getCellUserInfo().getUser().nickName + ",number0,lineType = " + i57 + ",From top to leave screen " + j28 + ",feedIndex = " + this.mVisibleFeedInfo.currentVisibleFirstFeedPosition);
                                }
                            }
                            this.mVisibleFeedInfo.lastReportFirstFeedLastLine = i57;
                            j28 += j27;
                        }
                    }
                }
            }
        } else if (i47 == 1) {
            if (!visibleFeedInfo.lastDirectionMoveUp) {
                visibleFeedInfo.lastReportFirstFeedLastLine--;
            }
            int i58 = 3 - visibleFeedInfo.lastReportFirstFeedLastLine;
            long j29 = j16 - j3;
            if (i58 == 0 || !isAdapterIndexValid(adapter, i46)) {
                i29 = 0;
                str = "FeedReport";
                str2 = ",feedIndex = ";
                j18 = 0;
            } else {
                j18 = j3 / i58;
                try {
                    businessFeedData5 = (BusinessFeedData) adapter.getItem(this.mVisibleFeedInfo.lastVisibleFristFeedPosition);
                } catch (Exception unused2) {
                    businessFeedData5 = null;
                }
                if (businessFeedData5 != null) {
                    int i59 = this.mVisibleFeedInfo.lastReportFirstFeedLastLine + 1;
                    long j36 = j18;
                    while (i59 <= i49) {
                        long j37 = j29 + j36;
                        if (i59 == i56) {
                            long j38 = j37 - (j18 / j26);
                            i36 = i59;
                            i37 = 0;
                            str3 = str6;
                            str4 = str5;
                            doMiddlePictureLineReport(businessFeedData5, this.mVisibleFeedInfo.lastVisibleFristFeedPosition, j38, true, true);
                        } else {
                            i36 = i59;
                            i37 = i48;
                            str3 = str6;
                            str4 = str5;
                            doActionReport(businessFeedData5, this.mVisibleFeedInfo.lastVisibleFristFeedPosition, i36, j37, 7);
                            if (FeedGlobalEnv.g().isDebug()) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append(businessFeedData5.getCellUserInfo().getUser().nickName);
                                sb5.append(",lineType = ");
                                i38 = i36;
                                sb5.append(i38);
                                sb5.append(",From top to leave screen ");
                                sb5.append(j37);
                                sb5.append(str4);
                                sb5.append(this.mVisibleFeedInfo.lastVisibleFristFeedPosition);
                                Log.i(str3, sb5.toString());
                                j36 += j18;
                                i59 = i38 + 1;
                                str6 = str3;
                                i48 = i37;
                                str5 = str4;
                                i49 = 3;
                                i56 = 1;
                                j26 = 2;
                            }
                        }
                        i38 = i36;
                        j36 += j18;
                        i59 = i38 + 1;
                        str6 = str3;
                        i48 = i37;
                        str5 = str4;
                        i49 = 3;
                        i56 = 1;
                        j26 = 2;
                    }
                    i29 = i48;
                    str = str6;
                    str2 = str5;
                    j19 = j18;
                    j18 = j36;
                    this.mVisibleFeedInfo.lastReportFirstFeedLastLine = -1;
                    childAt2 = viewGroup.getChildAt(i29);
                    if ((childAt2 instanceof AbsFeedView) && isAdapterIndexValid(adapter, this.mVisibleFeedInfo.currentVisibleFirstFeedPosition)) {
                        CauclateFeedLinesY(LineY, (AbsFeedView) childAt2, i3);
                        try {
                            businessFeedData4 = (BusinessFeedData) adapter.getItem(this.mVisibleFeedInfo.currentVisibleFirstFeedPosition);
                        } catch (Exception unused3) {
                            businessFeedData4 = null;
                        }
                        if (businessFeedData4 != null) {
                            VisibleFeedInfo visibleFeedInfo2 = this.mVisibleFeedInfo;
                            visibleFeedInfo2.lastReportFirstFeedLastLine = i29;
                            long j39 = j29 + j18;
                            doActionReport(businessFeedData4, visibleFeedInfo2.currentVisibleFirstFeedPosition, 0, j39, 7);
                            if (FeedGlobalEnv.g().isDebug()) {
                                Log.i(str, businessFeedData4.getCellUserInfo().getUser().nickName + ",lineType = " + i29 + ",From top to leave screen " + j39 + str2 + this.mVisibleFeedInfo.currentVisibleFirstFeedPosition);
                            }
                            long j46 = j18 + j19;
                            for (int i65 = 1; i65 <= 3; i65++) {
                                if (isArrayIndexIsValued(LineY, i65) && LineY[i65] < 10) {
                                    long j47 = j29 + j46;
                                    if (i65 == 1) {
                                        doMiddlePictureLineReport(businessFeedData4, this.mVisibleFeedInfo.currentVisibleFirstFeedPosition, j47 - (j19 / 2), true, true);
                                    } else {
                                        doActionReport(businessFeedData4, this.mVisibleFeedInfo.currentVisibleFirstFeedPosition, i65, j47, 7);
                                        if (FeedGlobalEnv.g().isDebug()) {
                                            Log.i(str, businessFeedData4.getCellUserInfo().getUser().nickName + ",lineType = " + i65 + ",From top to leave screen " + j47 + str2 + this.mVisibleFeedInfo.currentVisibleFirstFeedPosition);
                                        }
                                    }
                                    j46 += j19;
                                    this.mVisibleFeedInfo.lastReportFirstFeedLastLine = i65;
                                }
                            }
                        }
                    }
                } else {
                    i29 = 0;
                    str = "FeedReport";
                    str2 = ",feedIndex = ";
                }
            }
            j19 = j18;
            this.mVisibleFeedInfo.lastReportFirstFeedLastLine = -1;
            childAt2 = viewGroup.getChildAt(i29);
            if (childAt2 instanceof AbsFeedView) {
                CauclateFeedLinesY(LineY, (AbsFeedView) childAt2, i3);
                businessFeedData4 = (BusinessFeedData) adapter.getItem(this.mVisibleFeedInfo.currentVisibleFirstFeedPosition);
                if (businessFeedData4 != null) {
                }
            }
        } else {
            int i66 = (((i47 - 1) * 3) + 3) - visibleFeedInfo.lastReportFirstFeedLastLine;
            if (i66 == 0) {
                i66 = 1;
            }
            long j48 = j3 / i66;
            long j49 = j16 - j3;
            if (isAdapterIndexValid(adapter, i46)) {
                try {
                    businessFeedData = (BusinessFeedData) adapter.getItem(this.mVisibleFeedInfo.lastVisibleFristFeedPosition);
                } catch (Exception unused4) {
                    businessFeedData = null;
                }
                if (businessFeedData != null) {
                    int i67 = 1;
                    int i68 = this.mVisibleFeedInfo.lastReportFirstFeedLastLine + 1;
                    j17 = j48;
                    int i69 = 3;
                    while (i68 <= i69) {
                        long j56 = j49 + j17;
                        if (i68 == i67) {
                            i16 = i68;
                            doMiddlePictureLineReport(businessFeedData, this.mVisibleFeedInfo.lastVisibleFristFeedPosition, j56 - (j48 / 2), true, true);
                        } else {
                            i16 = i68;
                            doActionReport(businessFeedData, this.mVisibleFeedInfo.lastVisibleFristFeedPosition, i16, j56, 7);
                            if (FeedGlobalEnv.g().isDebug()) {
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append(businessFeedData.getCellUserInfo().getUser().nickName);
                                sb6.append(",lineType = ");
                                i17 = i16;
                                sb6.append(i17);
                                sb6.append(",From top to leave screen ");
                                sb6.append(j56);
                                sb6.append(",feedIndex = ");
                                sb6.append(this.mVisibleFeedInfo.lastVisibleFristFeedPosition);
                                Log.i("FeedReport", sb6.toString());
                                j17 += j48;
                                i68 = i17 + 1;
                                i69 = 3;
                                i67 = 1;
                            }
                        }
                        i17 = i16;
                        j17 += j48;
                        i68 = i17 + 1;
                        i69 = 3;
                        i67 = 1;
                    }
                    VisibleFeedInfo visibleFeedInfo3 = this.mVisibleFeedInfo;
                    visibleFeedInfo3.lastReportFirstFeedLastLine = -1;
                    i18 = visibleFeedInfo3.lastVisibleFristFeedPosition + 1;
                    while (i18 < this.mVisibleFeedInfo.currentVisibleFirstFeedPosition) {
                        if (isAdapterIndexValid(adapter, i18)) {
                            try {
                                businessFeedData3 = (BusinessFeedData) adapter.getItem(i18);
                            } catch (Exception unused5) {
                                businessFeedData3 = null;
                            }
                            if (businessFeedData3 != null) {
                                int i75 = 0;
                                while (i75 <= 3) {
                                    long j57 = j49 + j17;
                                    if (i18 == 1) {
                                        i19 = i75;
                                        i26 = i18;
                                        doMiddlePictureLineReport(businessFeedData3, i18, j57 - (j48 / 2), true, true);
                                    } else {
                                        i19 = i75;
                                        i26 = i18;
                                        doActionReport(businessFeedData3, i26, i19, j57, 7);
                                        if (FeedGlobalEnv.g().isDebug()) {
                                            StringBuilder sb7 = new StringBuilder();
                                            sb7.append(businessFeedData3.getCellUserInfo().getUser().nickName);
                                            sb7.append(",lineType = ");
                                            i27 = i19;
                                            sb7.append(i27);
                                            sb7.append(",From top to leave screen");
                                            sb7.append(j57);
                                            sb7.append(",feedIndex = ");
                                            i28 = i26;
                                            sb7.append(i28);
                                            Log.i("FeedReport", sb7.toString());
                                            j17 += j48;
                                            i75 = i27 + 1;
                                            i18 = i28;
                                        }
                                    }
                                    i27 = i19;
                                    i28 = i26;
                                    j17 += j48;
                                    i75 = i27 + 1;
                                    i18 = i28;
                                }
                            }
                        }
                        i18++;
                    }
                    childAt = viewGroup.getChildAt(0);
                    if ((childAt instanceof AbsFeedView) && isAdapterIndexValid(adapter, this.mVisibleFeedInfo.currentVisibleFirstFeedPosition)) {
                        CauclateFeedLinesY(LineY, (AbsFeedView) childAt, i3);
                        try {
                            businessFeedData2 = (BusinessFeedData) adapter.getItem(this.mVisibleFeedInfo.currentVisibleFirstFeedPosition);
                        } catch (Exception unused6) {
                            businessFeedData2 = null;
                        }
                        if (businessFeedData2 != null) {
                            VisibleFeedInfo visibleFeedInfo4 = this.mVisibleFeedInfo;
                            visibleFeedInfo4.lastReportFirstFeedLastLine = 0;
                            long j58 = j49 + j17;
                            doActionReport(businessFeedData2, visibleFeedInfo4.currentVisibleFirstFeedPosition, 0, j58, 7);
                            if (FeedGlobalEnv.g().isDebug()) {
                                Log.i("FeedReport", businessFeedData2.getCellUserInfo().getUser().nickName + ",lineType = 0,From top to leave screen " + j58 + ",feedIndex = " + this.mVisibleFeedInfo.currentVisibleFirstFeedPosition);
                            }
                            long j59 = j17 + j48;
                            for (int i76 = 1; i76 <= 3; i76++) {
                                if (isArrayIndexIsValued(LineY, i76) && LineY[i76] < 10) {
                                    long j65 = j49 + j59;
                                    if (i76 == 1) {
                                        doMiddlePictureLineReport(businessFeedData2, this.mVisibleFeedInfo.currentVisibleFirstFeedPosition, j65 - (j48 / 2), true, true);
                                    } else {
                                        doActionReport(businessFeedData2, this.mVisibleFeedInfo.currentVisibleFirstFeedPosition, i76, j65, 7);
                                        if (FeedGlobalEnv.g().isDebug()) {
                                            Log.i("FeedReport", businessFeedData2.getCellUserInfo().getUser().nickName + ",lineType = " + i76 + ",From top to leave screen " + j65 + ",feedIndex = " + this.mVisibleFeedInfo.currentVisibleFirstFeedPosition);
                                        }
                                    }
                                    j59 += j48;
                                    this.mVisibleFeedInfo.lastReportFirstFeedLastLine = i76;
                                }
                            }
                        }
                    }
                }
            }
            j17 = j48;
            VisibleFeedInfo visibleFeedInfo32 = this.mVisibleFeedInfo;
            visibleFeedInfo32.lastReportFirstFeedLastLine = -1;
            i18 = visibleFeedInfo32.lastVisibleFristFeedPosition + 1;
            while (i18 < this.mVisibleFeedInfo.currentVisibleFirstFeedPosition) {
            }
            childAt = viewGroup.getChildAt(0);
            if (childAt instanceof AbsFeedView) {
                CauclateFeedLinesY(LineY, (AbsFeedView) childAt, i3);
                businessFeedData2 = (BusinessFeedData) adapter.getItem(this.mVisibleFeedInfo.currentVisibleFirstFeedPosition);
                if (businessFeedData2 != null) {
                }
            }
        }
        VisibleFeedInfo visibleFeedInfo5 = this.mVisibleFeedInfo;
        visibleFeedInfo5.lastVisibleFristFeedPosition = visibleFeedInfo5.currentVisibleFirstFeedPosition;
    }

    void onFeedIn(BusinessFeedData businessFeedData, int i3, long j3) {
        if (businessFeedData.isRecommendFeed()) {
            synchronized (this.feedStayLock) {
                this.mFeedStayInfoMap.put(businessFeedData.getFeedCommInfoV2().feedskey, new FeedStayInfo(j3, i3, businessFeedData));
            }
        }
    }

    public boolean reportHzEnough() {
        return this.mVisibleFeedInfo.lastReportTime == -1 || System.currentTimeMillis() - this.mVisibleFeedInfo.lastReportTime > ((long) this.ReportHZ);
    }

    public void resetLastReportTime() {
        this.mVisibleFeedInfo.lastReportTime = -1L;
    }

    public void setCurrentVisibleFirstFeedBottomLineY(View view, int i3) {
        this.mVisibleFeedInfo.lastVisibleFirstFeedBottomLineY = this.currentVisibleFirstFeedBottomLineY;
        if (view instanceof AbsFeedView) {
            CauclateFeedLinesY(LineY, (AbsFeedView) view, i3);
            this.currentVisibleFirstFeedBottomLineY = LineY[3];
        }
    }

    public void setFastScrollStartTimeAndFeedIndex(long j3, int i3, int i16) {
        VisibleFeedInfo visibleFeedInfo = this.mVisibleFeedInfo;
        visibleFeedInfo.lastVisibleFristFeedPosition = i3;
        visibleFeedInfo.lastVisibleLastFeedPosition = i16;
        this.mStartFastScrollTime = j3;
    }

    public void setReportTime() {
        this.mVisibleFeedInfo.lastReportTime = System.currentTimeMillis();
    }

    public void setVisibleFirstFeedPosition(int i3) {
        this.mVisibleFeedInfo.currentVisibleFirstFeedPosition = i3;
    }

    public void setVisibleLastFeedPosition(int i3) {
        this.mVisibleFeedInfo.currentVisibleLastFeedPosition = i3;
    }

    public void addLostLineReport(Adapter adapter, boolean z16, long j3, ViewGroup viewGroup, int i3) {
        VisibleFeedInfo visibleFeedInfo = this.mVisibleFeedInfo;
        if (visibleFeedInfo.lastVisibleFristFeedPosition != -1 && visibleFeedInfo.lastVisibleLastFeedPosition != -1) {
            if (visibleFeedInfo.currentVisibleFirstFeedPosition == -1 || visibleFeedInfo.currentVisibleLastFeedPosition == -1) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (z16) {
                movingUpAcrossScreenTopReport(adapter, j3, currentTimeMillis, viewGroup, i3);
                movingUpAcrossScreenBottomReport(adapter, j3, currentTimeMillis, viewGroup, i3);
                this.mVisibleFeedInfo.lastDirectionMoveUp = true;
                return;
            } else {
                movingDownAcrossScreenBottomReport(adapter, j3, currentTimeMillis, viewGroup, i3);
                movingDownAcrossScreenTopReport(adapter, j3, currentTimeMillis, viewGroup, i3);
                this.mVisibleFeedInfo.lastDirectionMoveUp = false;
                return;
            }
        }
        visibleFeedInfo.lastVisibleFristFeedPosition = visibleFeedInfo.currentVisibleFirstFeedPosition;
        visibleFeedInfo.lastVisibleLastFeedPosition = visibleFeedInfo.currentVisibleLastFeedPosition;
    }

    void CalculateFeedContainerLinesY(int[] iArr, AbsFeedView absFeedView, int i3) {
        if (absFeedView != null) {
            absFeedView.getLocationOnScreen(this.location);
            int i16 = this.location[1];
            iArr[0] = i16;
            int height = i16 + absFeedView.getHeight();
            iArr[3] = height;
            int i17 = iArr[0];
            int i18 = (height + i17) / 2;
            iArr[2] = i18;
            iArr[1] = (i18 + i17) / 2;
        }
    }

    boolean isArrayIndexIsValued(int[] iArr, int i3) {
        return i3 >= 0 && i3 < iArr.length;
    }

    void onFeedOut(BusinessFeedData businessFeedData, int i3, long j3) {
        if (businessFeedData.isRecommendFeed()) {
            synchronized (this.feedStayLock) {
                FeedStayInfo feedStayInfo = this.mFeedStayInfoMap.get(businessFeedData.getFeedCommInfoV2().feedskey);
                if (feedStayInfo != null) {
                    FeedActionRecorder.getInstance().addAction(businessFeedData, i3, j3, 0, 14, 30, 0, true, null, false, j3 - feedStayInfo.mFeedEnterTime);
                    this.mFeedStayInfoMap.remove(businessFeedData.getFeedCommInfoV2().feedskey);
                }
            }
        }
    }

    void doMiddlePictureLineReport(BusinessFeedData businessFeedData, int i3, long j3, boolean z16, boolean z17) {
        if (businessFeedData == null || (businessFeedData.getFeedCommInfoV2().reportfeedsattr & 2) == 0) {
            return;
        }
        if (z16) {
            if (z17) {
                if (FeedGlobalEnv.g().isDebug()) {
                    Log.i("FeedReport", businessFeedData.getUser().nickName + ",middle picture line lineType = 1, from top to leave screen,feedIndex = " + i3);
                }
                doActionReport(businessFeedData, i3, 1, j3, 7);
                return;
            }
            if (FeedGlobalEnv.g().isDebug()) {
                Log.i("FeedReport", businessFeedData.getUser().nickName + ",middle picture line lineType = 1, from top to enter screen,feedIndex = " + i3);
            }
            doActionReport(businessFeedData, i3, 1, j3, 6);
            return;
        }
        if (z17) {
            if (FeedGlobalEnv.g().isDebug()) {
                Log.i("FeedReport", businessFeedData.getUser().nickName + ",middle picture line lineType = 1, from Bottom to enter screen,feedIndex = " + i3);
            }
            doActionReport(businessFeedData, i3, 1, j3, 8);
            return;
        }
        if (FeedGlobalEnv.g().isDebug()) {
            Log.i("FeedReport", businessFeedData.getUser().nickName + ",middle picture line lineType = 1,from Bottom to leave screen,feedIndex = " + i3);
        }
        doActionReport(businessFeedData, i3, 1, j3, 9);
    }

    public void feedContainerActivitySwitchReported(AbsFeedView absFeedView, int i3, boolean z16, int i16) {
        if (absFeedView == null) {
            return;
        }
        CalculateFeedContainerLinesY(LineY, absFeedView, i16);
        long currentTimeMillis = System.currentTimeMillis();
        int i17 = LineY[0];
        if (i17 > 0 && i17 < i16) {
            if (z16) {
                if (absFeedView instanceof FeedContainer) {
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedReport", "feedContainer,topline resume report,feedIndex = " + i3);
                    }
                    doActionReport(((FeedContainer) absFeedView).getFeedData(), i3, 0, currentTimeMillis, 10);
                } else if (absFeedView instanceof FeedAdvContainer) {
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedReport", "feedAdvContainer,topline resume report,feedIndex = " + i3);
                    }
                    doActionReport(((FeedAdvContainer) absFeedView).getFeedData(), i3, 0, currentTimeMillis, 10);
                } else if (absFeedView.mFeedData != null) {
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedReport", "other ,topline resume report,feedIndex = " + i3);
                    }
                    doActionReport(absFeedView.mFeedData, i3, 0, currentTimeMillis, 10);
                }
            } else if (absFeedView instanceof FeedContainer) {
                if (FeedGlobalEnv.g().isDebug()) {
                    Log.i("FeedReport", "feedContainer,topline stop report,feedIndex = " + i3);
                }
                doActionReport(((FeedContainer) absFeedView).getFeedData(), i3, 0, currentTimeMillis, 11);
            } else if (absFeedView instanceof FeedAdvContainer) {
                if (FeedGlobalEnv.g().isDebug()) {
                    Log.i("FeedReport", "feedAdvContainer,topline stop report,feedIndex = " + i3);
                }
                doActionReport(((FeedAdvContainer) absFeedView).getFeedData(), i3, 0, currentTimeMillis, 11);
            } else if (absFeedView.mFeedData != null) {
                if (FeedGlobalEnv.g().isDebug()) {
                    Log.i("FeedReport", "other ,topline stop report,feedIndex = " + i3);
                }
                doActionReport(absFeedView.mFeedData, i3, 0, currentTimeMillis, 11);
            }
        }
        int i18 = LineY[2];
        if (i18 > 0 && i18 < i16) {
            if (z16) {
                if (absFeedView instanceof FeedContainer) {
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedReport", "feedContainer,mainline resume report,feedIndex = " + i3);
                    }
                    doActionReport(((FeedContainer) absFeedView).getFeedData(), i3, 2, currentTimeMillis, 10);
                } else if (absFeedView instanceof FeedAdvContainer) {
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedReport", "feedAdvContainer,mainline resume report,feedIndex = " + i3);
                    }
                    doActionReport(((FeedAdvContainer) absFeedView).getFeedData(), i3, 2, currentTimeMillis, 10);
                } else if (absFeedView.mFeedData != null) {
                    if (FeedGlobalEnv.g().isDebug()) {
                        Log.i("FeedReport", "other ,mainline resume report,feedIndex = " + i3);
                    }
                    doActionReport(absFeedView.mFeedData, i3, 2, currentTimeMillis, 10);
                }
            } else if (absFeedView instanceof FeedContainer) {
                if (FeedGlobalEnv.g().isDebug()) {
                    Log.i("FeedReport", "feedContainer,mainline stop report,feedIndex = " + i3);
                }
                doActionReport(((FeedContainer) absFeedView).getFeedData(), i3, 2, currentTimeMillis, 11);
            } else if (absFeedView instanceof FeedAdvContainer) {
                if (FeedGlobalEnv.g().isDebug()) {
                    Log.i("FeedReport", "feedAdvContainer,mainline stop report,feedIndex = " + i3);
                }
                doActionReport(((FeedAdvContainer) absFeedView).getFeedData(), i3, 2, currentTimeMillis, 11);
            } else if (absFeedView.mFeedData != null) {
                if (FeedGlobalEnv.g().isDebug()) {
                    Log.i("FeedReport", "other ,mainline stop report,feedIndex = " + i3);
                }
                doActionReport(absFeedView.mFeedData, i3, 2, currentTimeMillis, 11);
            }
        }
        int i19 = LineY[3];
        if (i19 <= 0 || i19 >= i16) {
            return;
        }
        if (z16) {
            if (absFeedView instanceof FeedContainer) {
                if (FeedGlobalEnv.g().isDebug()) {
                    Log.i("FeedReport", "feedContainer,Bottomline resume report,feedIndex = " + i3);
                }
                doActionReport(((FeedContainer) absFeedView).getFeedData(), i3, 3, currentTimeMillis, 10);
                return;
            }
            if (absFeedView instanceof FeedAdvContainer) {
                if (FeedGlobalEnv.g().isDebug()) {
                    Log.i("FeedReport", "feedAdvContainer,Bottomline resume report,feedIndex = " + i3);
                }
                doActionReport(((FeedAdvContainer) absFeedView).getFeedData(), i3, 3, currentTimeMillis, 10);
                return;
            }
            if (absFeedView.mFeedData != null) {
                if (FeedGlobalEnv.g().isDebug()) {
                    Log.i("FeedReport", "other ,Bottomline resume report,feedIndex = " + i3);
                }
                doActionReport(absFeedView.mFeedData, i3, 3, currentTimeMillis, 10);
                return;
            }
            return;
        }
        if (absFeedView instanceof FeedContainer) {
            if (FeedGlobalEnv.g().isDebug()) {
                Log.i("FeedReport", "feedContainer,Bottomline stop report,feedIndex = " + i3);
            }
            doActionReport(((FeedContainer) absFeedView).getFeedData(), i3, 3, currentTimeMillis, 11);
            return;
        }
        if (absFeedView instanceof FeedAdvContainer) {
            if (FeedGlobalEnv.g().isDebug()) {
                Log.i("FeedReport", "feedAdvContainer,Bottomline stop report,feedIndex = " + i3);
            }
            doActionReport(((FeedAdvContainer) absFeedView).getFeedData(), i3, 3, currentTimeMillis, 11);
            return;
        }
        if (absFeedView.mFeedData != null) {
            if (FeedGlobalEnv.g().isDebug()) {
                Log.i("FeedReport", "other ,Bottomline stop report,feedIndex = " + i3);
            }
            doActionReport(absFeedView.mFeedData, i3, 3, currentTimeMillis, 11);
        }
    }

    void doActionReport(BusinessFeedData businessFeedData, int i3, int i16, long j3, int i17) {
        int i18;
        if (businessFeedData == null) {
            return;
        }
        if (i16 == 0) {
            i18 = 13;
        } else if (i16 == 1) {
            if (i17 == 6 || i17 == 8) {
                onFeedIn(businessFeedData, i3, j3);
            } else if (i17 == 7 || i17 == 9) {
                onFeedOut(businessFeedData, i3, j3);
            }
            i18 = 14;
        } else if (i16 != 3) {
            return;
        } else {
            i18 = 16;
        }
        FeedActionRecorder.getInstance().addAction(businessFeedData, i3, j3, i18, i17, true);
    }
}
