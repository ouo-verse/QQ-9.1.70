package com.tencent.mobileqq.icgame.room.report;

import com.tencent.mobileqq.icgame.api.room.IReportEnterRoom;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bE\u0010FJ\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002H\u0002J\u001a\u0010\f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0002H\u0002J \u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u0005H\u0016J(\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000fH\u0016J \u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0002H\u0016J\u0018\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002H\u0016J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010!\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J(\u0010\"\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010#\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010$\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J(\u0010%\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J \u0010(\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u0014H\u0016J\u0011\u0010)\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b)\u0010*J\u0011\u0010+\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b+\u0010*J\b\u0010,\u001a\u00020\rH\u0016J\b\u0010-\u001a\u00020\u0002H\u0016J \u0010.\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u000e\u0010/\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u00100\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u00103\u001a\u0004\u0018\u0001022\u0006\u00101\u001a\u00020\u0002R\u0014\u00104\u001a\u00020\u000f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0014\u00106\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u00108\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b8\u00107R\u0014\u00109\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b9\u00107R\u0018\u0010:\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010<\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010;R\u0016\u0010=\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u00107R\u0016\u0010>\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010@\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010?R0\u0010C\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002020Aj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u000202`B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010D\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/report/ReportHelper;", "Lcom/tencent/mobileqq/icgame/api/room/IReportEnterRoom;", "", "roomId", "endTime", "", "saveFirstFrameComEndTime", "startTime", "innerSaveStartBufferInfo", "innerSaveStopBufferInfo", "saveEnterRoomEndTime", "pageOutTime", "savePageOutTime", "", "errorCode", "", "errorMsg", "reportFirstFrameComTime", "reportUserAwareFirstFrameComTime", "reportEnterRoomTime", "", "isForceReport", "tryReportVideoError", QCircleLpReportDc05507.KEY_CLEAR, "roomType", "jumpSource", "uid", "saveRecordInfo", "preloadTime", "saveClickStartAndPreloadTime", "pageInTime", "savePageInTime", "reportStartClickEnterRoom", "saveSwitchRoomTime", "saveFirstFrameEndTimeAndReport", "savePlayerStartBufferInfo", "savePlayerStopBufferInfo", "saveEnterRoomEndTimeAndReport", "url", "isPreload", "reportQQLiveVideoFormat", "getEnterRoomEndTime", "()Ljava/lang/Long;", "getFirstFrameTime", "getPlayerBufferTimes", "getPlayerBufferDurationMs", "savePageOutTimeAndTryReportVideoError", "clearPageOut", "remove", "roomid", "Lcom/tencent/mobileqq/icgame/room/report/c;", "getReportRecord", "TAG", "Ljava/lang/String;", "MAX_SIZE", "I", "FORCE_REPORT_VIDEO_ERROR_TIME", "REPORT_VIDEO_ERROR_TIME", "mEnterRoomTime", "Ljava/lang/Long;", "mFirstFrameTime", "mPlayerBufferTimes", "mPlayerBufferTimeDurationMs", "J", "lastStartClickTime", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "recordMap", "Ljava/util/HashMap;", "<init>", "()V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class ReportHelper implements IReportEnterRoom {
    private static final int FORCE_REPORT_VIDEO_ERROR_TIME = 1000;
    private static final int MAX_SIZE = 20;
    private static final int REPORT_VIDEO_ERROR_TIME = 5000;

    @NotNull
    private static final String TAG = "ICGameReportHelper";
    private static long mPlayerBufferTimeDurationMs;
    private static int mPlayerBufferTimes;

    @NotNull
    public static final ReportHelper INSTANCE = new ReportHelper();

    @Nullable
    private static Long mEnterRoomTime = 0L;

    @Nullable
    private static Long mFirstFrameTime = 0L;
    private static long lastStartClickTime = -1;

    @NotNull
    private static final HashMap<Long, ReportRecord> recordMap = new LruMap(20);

    ReportHelper() {
    }

    private final void innerSaveStartBufferInfo(long roomId, long startTime) {
        ReportRecord reportRecord = recordMap.get(Long.valueOf(roomId));
        if (reportRecord != null) {
            reportRecord.H(reportRecord.getPlayerBufferTimes() + 1);
            reportRecord.I(startTime);
            mPlayerBufferTimes = reportRecord.getPlayerBufferTimes();
            QLog.i(TAG, 1, "innerSaveStartBufferInfo roomId: " + roomId + " playerBufferTimes:" + reportRecord.getPlayerBufferTimes());
        }
    }

    private final void innerSaveStopBufferInfo(long roomId, long endTime) {
        boolean z16;
        ReportRecord reportRecord = recordMap.get(Long.valueOf(roomId));
        if (reportRecord != null) {
            if (reportRecord.getPlayerStartBufferTimeMs() == -1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                QLog.i(TAG, 1, "innerSaveStopBufferInfo \u6570\u636e\u9519\u8bef,\u8fd8\u6ca1\u8bbe\u7f6e\u5f00\u59cb\u65f6\u95f4 start roomId:" + roomId);
                return;
            }
            if (!z16) {
                reportRecord = null;
            }
            if (reportRecord != null) {
                reportRecord.G((reportRecord.getPlayerBufferDurationMs() + endTime) - reportRecord.getPlayerStartBufferTimeMs());
                mPlayerBufferTimeDurationMs = reportRecord.getPlayerBufferDurationMs();
                QLog.i(TAG, 1, "innerSaveStopBufferInfo roomId: " + roomId + " playerBufferTimes:" + reportRecord.getPlayerBufferTimes());
            }
        }
    }

    private final void reportEnterRoomTime(long roomId, int errorCode, String errorMsg) {
        HashMap<Long, ReportRecord> hashMap = recordMap;
        ReportRecord reportRecord = hashMap.get(Long.valueOf(roomId));
        if (reportRecord == null) {
            QLog.i(TAG, 1, "reportEnterRoomTime roomId:" + roomId + " no exit");
            return;
        }
        mEnterRoomTime = Long.valueOf(reportRecord.e());
        mFirstFrameTime = Long.valueOf(reportRecord.f());
        if (reportRecord.getIsEnterRoomSucReported()) {
            QLog.i(TAG, 1, "reportEnterRoomTime roomId:" + roomId + " enterRoom \u5df2\u7ecf\u4e0a\u62a5\u8fc7\u4e86");
            return;
        }
        b.e(reportRecord, errorCode, errorMsg);
        reportRecord.B(true);
        if (reportRecord.w()) {
            hashMap.remove(Long.valueOf(roomId));
        }
    }

    private final void reportFirstFrameComTime(long roomId, int errorCode, String errorMsg) {
        HashMap<Long, ReportRecord> hashMap = recordMap;
        ReportRecord reportRecord = hashMap.get(Long.valueOf(roomId));
        if (reportRecord == null) {
            QLog.i(TAG, 1, "reportFirstFrameComTime roomId:" + roomId + " no exit");
            return;
        }
        if (reportRecord.getIsVideoFirstFrameComReported()) {
            QLog.i(TAG, 1, "reportFirstFrameComTime roomId:" + roomId + " firstFrame \u5df2\u7ecf\u4e0a\u62a5\u8fc7\u4e86");
            return;
        }
        b.f(reportRecord, errorCode, errorMsg);
        reportRecord.Q(true);
        if (reportRecord.w()) {
            hashMap.remove(Long.valueOf(roomId));
        }
    }

    private final void reportUserAwareFirstFrameComTime(long roomId) {
        HashMap<Long, ReportRecord> hashMap = recordMap;
        ReportRecord reportRecord = hashMap.get(Long.valueOf(roomId));
        if (reportRecord == null) {
            QLog.i(TAG, 1, "reportUserAwareFirstFrameComTime roomId:" + roomId + " no exit");
            return;
        }
        if (!reportRecord.getIsUserFirstFrameComeReported() && reportRecord.b()) {
            b.c(reportRecord);
            reportRecord.P(true);
            if (reportRecord.w()) {
                hashMap.remove(Long.valueOf(roomId));
            }
        }
    }

    private final void saveEnterRoomEndTime(long roomId, long endTime) {
        boolean z16;
        ReportRecord reportRecord = recordMap.get(Long.valueOf(roomId));
        if (reportRecord != null) {
            if (reportRecord.getEnterRoomEnd() == -1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                QLog.i(TAG, 1, "saveEnterRoomEndTime \u6570\u636e\u9519\u8bef,\u5df2\u7ecf\u8bbe\u7f6e\u7ed3\u675f\u65f6\u95f4 start roomId:" + roomId);
                return;
            }
            if (!z16) {
                reportRecord = null;
            }
            if (reportRecord != null) {
                reportRecord.A(endTime);
                QLog.i(TAG, 1, "saveEnterRoomEndTime roomId: " + roomId + " enterRoomEnd:" + endTime);
            }
        }
    }

    static /* synthetic */ void saveEnterRoomEndTime$default(ReportHelper reportHelper, long j3, long j16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j16 = -1;
        }
        reportHelper.saveEnterRoomEndTime(j3, j16);
    }

    private final void saveFirstFrameComEndTime(long roomId, long endTime) {
        boolean z16;
        ReportRecord reportRecord = recordMap.get(Long.valueOf(roomId));
        if (reportRecord != null) {
            if (reportRecord.getFirstFrameEnd() == -1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                QLog.i(TAG, 1, "saveFirstFrameComEndTime \u6570\u636e\u9519\u8bef,\u5df2\u7ecf\u8bbe\u7f6e\u7ed3\u675f\u65f6\u95f4 start roomId:" + roomId);
                return;
            }
            if (!z16) {
                reportRecord = null;
            }
            if (reportRecord != null) {
                reportRecord.C(endTime);
                QLog.i(TAG, 1, "saveFirstFrameComEndTime roomId: " + roomId + " end time:" + endTime);
            }
        }
    }

    static /* synthetic */ void saveFirstFrameComEndTime$default(ReportHelper reportHelper, long j3, long j16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j16 = -1;
        }
        reportHelper.saveFirstFrameComEndTime(j3, j16);
    }

    private final void savePageOutTime(long roomId, long pageOutTime) {
        boolean z16;
        ReportRecord reportRecord = recordMap.get(Long.valueOf(roomId));
        if (reportRecord != null) {
            if (reportRecord.getPageOutTime() == -1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                QLog.i(TAG, 1, "savePageOutTime \u6570\u636e\u9519\u8bef,\u5df2\u7ecf\u8bbe\u7f6e\u7ed3\u675f\u65f6\u95f4 start roomId:" + roomId);
                return;
            }
            if (!z16) {
                reportRecord = null;
            }
            if (reportRecord != null) {
                reportRecord.F(pageOutTime);
                QLog.i(TAG, 1, "savePageOutTime roomId: " + roomId + " pageOutTime:" + pageOutTime);
            }
        }
    }

    static /* synthetic */ void savePageOutTime$default(ReportHelper reportHelper, long j3, long j16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j16 = -1;
        }
        reportHelper.savePageOutTime(j3, j16);
    }

    private final void tryReportVideoError(long roomId, boolean isForceReport) {
        ReportRecord reportRecord = recordMap.get(Long.valueOf(roomId));
        if (reportRecord == null) {
            QLog.i(TAG, 1, "tryReportVideoError roomId:" + roomId + " no exit");
            return;
        }
        if (reportRecord.getIsVideoFirstFrameComReported()) {
            return;
        }
        if ((isForceReport && reportRecord.g() > 1000) || reportRecord.g() > 5000) {
            b.g(reportRecord, isForceReport ? 1 : 0);
        }
        reportRecord.B(true);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IReportEnterRoom
    public void clear() {
        recordMap.clear();
    }

    public final void clearPageOut(long roomId) {
        ReportRecord reportRecord = recordMap.get(Long.valueOf(roomId));
        if (reportRecord != null) {
            reportRecord.F(-1L);
            QLog.i(TAG, 1, "clearPageOut roomId: " + roomId);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IReportEnterRoom
    @Nullable
    public Long getEnterRoomEndTime() {
        QLog.i(TAG, 1, "mEnterRoomTime =" + mEnterRoomTime + "}");
        return mEnterRoomTime;
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IReportEnterRoom
    @Nullable
    public Long getFirstFrameTime() {
        QLog.i(TAG, 1, "getFirstFrameTime =" + mFirstFrameTime + "}");
        return mFirstFrameTime;
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IReportEnterRoom
    public long getPlayerBufferDurationMs() {
        QLog.i(TAG, 1, "getPlayerBufferDurationMs =" + mPlayerBufferTimeDurationMs + "}");
        return mPlayerBufferTimeDurationMs;
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IReportEnterRoom
    public int getPlayerBufferTimes() {
        QLog.i(TAG, 1, "getPlayerBufferTimes =" + mPlayerBufferTimes + "}");
        return mPlayerBufferTimes;
    }

    @Nullable
    public final ReportRecord getReportRecord(long roomid) {
        return recordMap.get(Long.valueOf(roomid));
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IReportEnterRoom
    public void remove(long roomId) {
        recordMap.remove(Long.valueOf(roomId));
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IReportEnterRoom
    public void reportQQLiveVideoFormat(long roomId, @NotNull String url, boolean isPreload) {
        Intrinsics.checkNotNullParameter(url, "url");
        ReportRecord reportRecord = recordMap.get(Long.valueOf(roomId));
        if (reportRecord == null) {
            return;
        }
        b.d(reportRecord, url);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IReportEnterRoom
    public void reportStartClickEnterRoom(long roomId) {
        HashMap<Long, ReportRecord> hashMap = recordMap;
        ReportRecord reportRecord = hashMap.get(Long.valueOf(roomId));
        if (reportRecord == null) {
            return;
        }
        b.b(reportRecord);
        QLog.i(TAG, 1, "reportStartClickEnterRoom >>> " + reportRecord);
        if (reportRecord.w()) {
            hashMap.remove(Long.valueOf(roomId));
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IReportEnterRoom
    public void saveClickStartAndPreloadTime(long roomId, long startTime, long preloadTime) {
        long j3;
        HashMap<Long, ReportRecord> hashMap = recordMap;
        ReportRecord reportRecord = hashMap.get(Long.valueOf(roomId));
        if (reportRecord == null) {
            reportRecord = new ReportRecord(roomId);
        }
        if (lastStartClickTime == startTime) {
            j3 = -1;
        } else {
            j3 = startTime;
        }
        reportRecord.K(j3);
        reportRecord.L(preloadTime);
        reportRecord.C(-1L);
        reportRecord.Q(false);
        if (startTime != -1) {
            lastStartClickTime = startTime;
        }
        QLog.i(TAG, 1, "saveClickStartTime key" + roomId + ", time:" + startTime);
        hashMap.put(Long.valueOf(roomId), reportRecord);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IReportEnterRoom
    public void saveEnterRoomEndTimeAndReport(long roomId, long endTime, int errorCode, @NotNull String errorMsg) {
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        saveEnterRoomEndTime(roomId, endTime);
        reportEnterRoomTime(roomId, errorCode, errorMsg);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IReportEnterRoom
    public void saveFirstFrameEndTimeAndReport(long roomId, long endTime, int errorCode, @NotNull String errorMsg) {
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        saveFirstFrameComEndTime(roomId, endTime);
        reportFirstFrameComTime(roomId, errorCode, errorMsg);
        reportUserAwareFirstFrameComTime(roomId);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IReportEnterRoom
    public void savePageInTime(long roomId, long pageInTime) {
        HashMap<Long, ReportRecord> hashMap = recordMap;
        ReportRecord reportRecord = hashMap.get(Long.valueOf(roomId));
        if (reportRecord == null) {
            reportRecord = new ReportRecord(roomId);
        }
        reportRecord.E(pageInTime);
        QLog.i(TAG, 1, "savePageInTime key" + roomId + ", time:" + pageInTime);
        hashMap.put(Long.valueOf(roomId), reportRecord);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IReportEnterRoom
    public void savePageOutTimeAndTryReportVideoError(long roomId, long pageOutTime, boolean isForceReport) {
        savePageOutTime(roomId, pageOutTime);
        tryReportVideoError(roomId, isForceReport);
        mPlayerBufferTimes = 0;
        mPlayerBufferTimeDurationMs = 0L;
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IReportEnterRoom
    public void savePlayerStartBufferInfo(long roomId, long startTime) {
        innerSaveStartBufferInfo(roomId, startTime);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IReportEnterRoom
    public void savePlayerStopBufferInfo(long roomId, long endTime) {
        innerSaveStopBufferInfo(roomId, endTime);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IReportEnterRoom
    public void saveRecordInfo(long roomId, @NotNull String roomType, @NotNull String jumpSource, @NotNull String uid) {
        Intrinsics.checkNotNullParameter(roomType, "roomType");
        Intrinsics.checkNotNullParameter(jumpSource, "jumpSource");
        Intrinsics.checkNotNullParameter(uid, "uid");
        HashMap<Long, ReportRecord> hashMap = recordMap;
        Long valueOf = Long.valueOf(roomId);
        ReportRecord reportRecord = new ReportRecord(roomId);
        reportRecord.J(roomType);
        reportRecord.D(jumpSource);
        reportRecord.N(uid);
        reportRecord.O(false);
        QLog.i(TAG, 1, "saveRecordInfo key: " + roomId + " start roomType:" + roomType + " jumpSource:" + jumpSource + " uid:" + uid + " useLivesdk:false");
        hashMap.put(valueOf, reportRecord);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IReportEnterRoom
    public void saveSwitchRoomTime(long roomId, long startTime) {
        HashMap<Long, ReportRecord> hashMap = recordMap;
        ReportRecord reportRecord = hashMap.get(Long.valueOf(roomId));
        if (reportRecord == null) {
            reportRecord = new ReportRecord(roomId);
        }
        reportRecord.M(startTime);
        reportRecord.A(-1L);
        reportRecord.B(false);
        QLog.i(TAG, 1, "saveSwitchRoomTime roomId: " + roomId + ", time:" + startTime);
        hashMap.put(Long.valueOf(roomId), reportRecord);
    }
}
