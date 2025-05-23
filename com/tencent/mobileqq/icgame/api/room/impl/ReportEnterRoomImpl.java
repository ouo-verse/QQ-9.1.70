package com.tencent.mobileqq.icgame.api.room.impl;

import com.tencent.mobileqq.icgame.api.room.IReportEnterRoom;
import com.tencent.mobileqq.icgame.room.report.ReportHelper;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016\u00a2\u0006\u0002\u0010\u0007J\u000f\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016\u00a2\u0006\u0002\u0010\u0007J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006H\u0016J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006H\u0016J \u0010\u0014\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0016J(\u0010\u0017\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0010H\u0016J(\u0010\u001b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0010H\u0016J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0006H\u0016J \u0010\u001e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0012H\u0016J\u0018\u0010!\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0016J(\u0010#\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0010H\u0016J\u0018\u0010'\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0016\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/icgame/api/room/impl/ReportEnterRoomImpl;", "Lcom/tencent/mobileqq/icgame/api/room/IReportEnterRoom;", "()V", QCircleLpReportDc05507.KEY_CLEAR, "", "getEnterRoomEndTime", "", "()Ljava/lang/Long;", "getFirstFrameTime", "getPlayerBufferDurationMs", "getPlayerBufferTimes", "", "remove", "roomId", "reportQQLiveVideoFormat", "url", "", "isPreload", "", "reportStartClickEnterRoom", "saveClickStartAndPreloadTime", "startTime", "preloadTime", "saveEnterRoomEndTimeAndReport", "endTime", "errorCode", "errorMsg", "saveFirstFrameEndTimeAndReport", "savePageInTime", "pageInTime", "savePageOutTimeAndTryReportVideoError", "pageOutTime", "isForceReport", "savePlayerStartBufferInfo", "savePlayerStopBufferInfo", "saveRecordInfo", "roomType", "jumpSource", "uid", "saveSwitchRoomTime", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes15.dex */
public final class ReportEnterRoomImpl implements IReportEnterRoom {
    @Override // com.tencent.mobileqq.icgame.api.room.IReportEnterRoom
    public void clear() {
        ReportHelper.INSTANCE.clear();
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IReportEnterRoom
    @Nullable
    public Long getEnterRoomEndTime() {
        return ReportHelper.INSTANCE.getEnterRoomEndTime();
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IReportEnterRoom
    @Nullable
    public Long getFirstFrameTime() {
        return ReportHelper.INSTANCE.getFirstFrameTime();
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IReportEnterRoom
    public long getPlayerBufferDurationMs() {
        return ReportHelper.INSTANCE.getPlayerBufferDurationMs();
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IReportEnterRoom
    public int getPlayerBufferTimes() {
        return ReportHelper.INSTANCE.getPlayerBufferTimes();
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IReportEnterRoom
    public void remove(long roomId) {
        ReportHelper.INSTANCE.remove(roomId);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IReportEnterRoom
    public void reportQQLiveVideoFormat(long roomId, @NotNull String url, boolean isPreload) {
        Intrinsics.checkNotNullParameter(url, "url");
        ReportHelper.INSTANCE.reportQQLiveVideoFormat(roomId, url, isPreload);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IReportEnterRoom
    public void reportStartClickEnterRoom(long roomId) {
        ReportHelper.INSTANCE.reportStartClickEnterRoom(roomId);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IReportEnterRoom
    public void saveClickStartAndPreloadTime(long roomId, long startTime, long preloadTime) {
        ReportHelper.INSTANCE.saveClickStartAndPreloadTime(roomId, startTime, preloadTime);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IReportEnterRoom
    public void saveEnterRoomEndTimeAndReport(long roomId, long endTime, int errorCode, @NotNull String errorMsg) {
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        ReportHelper.INSTANCE.saveEnterRoomEndTimeAndReport(roomId, endTime, errorCode, errorMsg);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IReportEnterRoom
    public void saveFirstFrameEndTimeAndReport(long roomId, long endTime, int errorCode, @NotNull String errorMsg) {
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        ReportHelper.INSTANCE.saveFirstFrameEndTimeAndReport(roomId, endTime, errorCode, errorMsg);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IReportEnterRoom
    public void savePageInTime(long roomId, long pageInTime) {
        ReportHelper.INSTANCE.savePageInTime(roomId, pageInTime);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IReportEnterRoom
    public void savePageOutTimeAndTryReportVideoError(long roomId, long pageOutTime, boolean isForceReport) {
        ReportHelper.INSTANCE.savePageOutTimeAndTryReportVideoError(roomId, pageOutTime, isForceReport);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IReportEnterRoom
    public void savePlayerStartBufferInfo(long roomId, long startTime) {
        ReportHelper.INSTANCE.savePlayerStartBufferInfo(roomId, startTime);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IReportEnterRoom
    public void savePlayerStopBufferInfo(long roomId, long endTime) {
        ReportHelper.INSTANCE.savePlayerStopBufferInfo(roomId, endTime);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IReportEnterRoom
    public void saveRecordInfo(long roomId, @NotNull String roomType, @NotNull String jumpSource, @NotNull String uid) {
        Intrinsics.checkNotNullParameter(roomType, "roomType");
        Intrinsics.checkNotNullParameter(jumpSource, "jumpSource");
        Intrinsics.checkNotNullParameter(uid, "uid");
        ReportHelper.INSTANCE.saveRecordInfo(roomId, roomType, jumpSource, uid);
    }

    @Override // com.tencent.mobileqq.icgame.api.room.IReportEnterRoom
    public void saveSwitchRoomTime(long roomId, long startTime) {
        ReportHelper.INSTANCE.saveSwitchRoomTime(roomId, startTime);
    }
}
