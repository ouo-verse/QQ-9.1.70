package com.tencent.mobileqq.icgame.api.room;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u000f\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&\u00a2\u0006\u0002\u0010\u0006J\u000f\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&\u00a2\u0006\u0002\u0010\u0006J\b\u0010\b\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0005H&J \u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0005H&J\"\u0010\u0013\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H&J*\u0010\u0016\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u000fH&J*\u0010\u001a\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u000fH&J\u001a\u0010\u001b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\u001c\u001a\u00020\u0005H&J \u0010\u001d\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0011H&J\u0018\u0010 \u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0005H&J\u0018\u0010!\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0005H&J(\u0010\"\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000fH&J\u001a\u0010&\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u0005H&\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/icgame/api/room/IReportEnterRoom;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", QCircleLpReportDc05507.KEY_CLEAR, "", "getEnterRoomEndTime", "", "()Ljava/lang/Long;", "getFirstFrameTime", "getPlayerBufferDurationMs", "getPlayerBufferTimes", "", "remove", "roomId", "reportQQLiveVideoFormat", "url", "", "isPreload", "", "reportStartClickEnterRoom", "saveClickStartAndPreloadTime", "startTime", "preloadTime", "saveEnterRoomEndTimeAndReport", "endTime", "errorCode", "errorMsg", "saveFirstFrameEndTimeAndReport", "savePageInTime", "pageInTime", "savePageOutTimeAndTryReportVideoError", "pageOutTime", "isForceReport", "savePlayerStartBufferInfo", "savePlayerStopBufferInfo", "saveRecordInfo", "roomType", "jumpSource", "uid", "saveSwitchRoomTime", "ic-game-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IReportEnterRoom extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes15.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void saveClickStartAndPreloadTime$default(IReportEnterRoom iReportEnterRoom, long j3, long j16, long j17, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    j16 = -1;
                }
                iReportEnterRoom.saveClickStartAndPreloadTime(j3, j16, j17);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: saveClickStartAndPreloadTime");
        }

        public static /* synthetic */ void saveEnterRoomEndTimeAndReport$default(IReportEnterRoom iReportEnterRoom, long j3, long j16, int i3, String str, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    j16 = -1;
                }
                iReportEnterRoom.saveEnterRoomEndTimeAndReport(j3, j16, i3, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: saveEnterRoomEndTimeAndReport");
        }

        public static /* synthetic */ void saveFirstFrameEndTimeAndReport$default(IReportEnterRoom iReportEnterRoom, long j3, long j16, int i3, String str, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    j16 = -1;
                }
                iReportEnterRoom.saveFirstFrameEndTimeAndReport(j3, j16, i3, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: saveFirstFrameEndTimeAndReport");
        }

        public static /* synthetic */ void savePageInTime$default(IReportEnterRoom iReportEnterRoom, long j3, long j16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    j16 = -1;
                }
                iReportEnterRoom.savePageInTime(j3, j16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: savePageInTime");
        }

        public static /* synthetic */ void saveSwitchRoomTime$default(IReportEnterRoom iReportEnterRoom, long j3, long j16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    j16 = -1;
                }
                iReportEnterRoom.saveSwitchRoomTime(j3, j16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: saveSwitchRoomTime");
        }
    }

    void clear();

    @Nullable
    Long getEnterRoomEndTime();

    @Nullable
    Long getFirstFrameTime();

    long getPlayerBufferDurationMs();

    int getPlayerBufferTimes();

    void remove(long roomId);

    void reportQQLiveVideoFormat(long roomId, @NotNull String url, boolean isPreload);

    void reportStartClickEnterRoom(long roomId);

    void saveClickStartAndPreloadTime(long roomId, long startTime, long preloadTime);

    void saveEnterRoomEndTimeAndReport(long roomId, long endTime, int errorCode, @NotNull String errorMsg);

    void saveFirstFrameEndTimeAndReport(long roomId, long endTime, int errorCode, @NotNull String errorMsg);

    void savePageInTime(long roomId, long pageInTime);

    void savePageOutTimeAndTryReportVideoError(long roomId, long pageOutTime, boolean isForceReport);

    void savePlayerStartBufferInfo(long roomId, long startTime);

    void savePlayerStopBufferInfo(long roomId, long endTime);

    void saveRecordInfo(long roomId, @NotNull String roomType, @NotNull String jumpSource, @NotNull String uid);

    void saveSwitchRoomTime(long roomId, long startTime);
}
