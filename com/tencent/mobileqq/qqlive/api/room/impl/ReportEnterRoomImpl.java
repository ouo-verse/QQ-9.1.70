package com.tencent.mobileqq.qqlive.api.room.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.room.IReportEnterRoom;
import com.tencent.mobileqq.qqlive.room.report.ReportHelper;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016\u00a2\u0006\u0002\u0010\u0007J\u000f\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016\u00a2\u0006\u0002\u0010\u0007J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006H\u0016J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0006H\u0016J \u0010\u0014\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0016J(\u0010\u0017\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0010H\u0016J(\u0010\u001b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u0010H\u0016J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0006H\u0016J \u0010\u001e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0012H\u0016J\u0018\u0010!\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0016J\u0018\u0010\"\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0016J(\u0010#\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0010H\u0016J\u0018\u0010'\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0016\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/room/impl/ReportEnterRoomImpl;", "Lcom/tencent/mobileqq/qqlive/api/room/IReportEnterRoom;", "()V", QCircleLpReportDc05507.KEY_CLEAR, "", "getEnterRoomEndTime", "", "()Ljava/lang/Long;", "getFirstFrameTime", "getPlayerBufferDurationMs", "getPlayerBufferTimes", "", "remove", "roomId", "reportQQLiveVideoFormat", "url", "", "isPreload", "", "reportStartClickEnterRoom", "saveClickStartAndPreloadTime", "startTime", "preloadTime", "saveEnterRoomEndTimeAndReport", "endTime", "errorCode", "errorMsg", "saveFirstFrameEndTimeAndReport", "savePageInTime", "pageInTime", "savePageOutTimeAndTryReportVideoError", "pageOutTime", "isForceReport", "savePlayerStartBufferInfo", "savePlayerStopBufferInfo", "saveRecordInfo", "roomType", "jumpSource", "uid", "saveSwitchRoomTime", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class ReportEnterRoomImpl implements IReportEnterRoom {
    static IPatchRedirector $redirector_;

    public ReportEnterRoomImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.IReportEnterRoom
    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            ReportHelper.INSTANCE.clear();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.IReportEnterRoom
    @Nullable
    public Long getEnterRoomEndTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Long) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return ReportHelper.INSTANCE.getEnterRoomEndTime();
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.IReportEnterRoom
    @Nullable
    public Long getFirstFrameTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Long) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return ReportHelper.INSTANCE.getFirstFrameTime();
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.IReportEnterRoom
    public long getPlayerBufferDurationMs() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Long) iPatchRedirector.redirect((short) 16, (Object) this)).longValue();
        }
        return ReportHelper.INSTANCE.getPlayerBufferDurationMs();
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.IReportEnterRoom
    public int getPlayerBufferTimes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return ReportHelper.INSTANCE.getPlayerBufferTimes();
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.IReportEnterRoom
    public void remove(long roomId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, roomId);
        } else {
            ReportHelper.INSTANCE.remove(roomId);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.IReportEnterRoom
    public void reportQQLiveVideoFormat(long roomId, @NotNull String url, boolean isPreload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Long.valueOf(roomId), url, Boolean.valueOf(isPreload));
        } else {
            Intrinsics.checkNotNullParameter(url, "url");
            ReportHelper.INSTANCE.reportQQLiveVideoFormat(roomId, url, isPreload);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.IReportEnterRoom
    public void reportStartClickEnterRoom(long roomId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, roomId);
        } else {
            ReportHelper.INSTANCE.reportStartClickEnterRoom(roomId);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.IReportEnterRoom
    public void saveClickStartAndPreloadTime(long roomId, long startTime, long preloadTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(roomId), Long.valueOf(startTime), Long.valueOf(preloadTime));
        } else {
            ReportHelper.INSTANCE.saveClickStartAndPreloadTime(roomId, startTime, preloadTime);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.IReportEnterRoom
    public void saveEnterRoomEndTimeAndReport(long roomId, long endTime, int errorCode, @NotNull String errorMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Long.valueOf(roomId), Long.valueOf(endTime), Integer.valueOf(errorCode), errorMsg);
        } else {
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            ReportHelper.INSTANCE.saveEnterRoomEndTimeAndReport(roomId, endTime, errorCode, errorMsg);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.IReportEnterRoom
    public void saveFirstFrameEndTimeAndReport(long roomId, long endTime, int errorCode, @NotNull String errorMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Long.valueOf(roomId), Long.valueOf(endTime), Integer.valueOf(errorCode), errorMsg);
        } else {
            Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
            ReportHelper.INSTANCE.saveFirstFrameEndTimeAndReport(roomId, endTime, errorCode, errorMsg);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.IReportEnterRoom
    public void savePageInTime(long roomId, long pageInTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Long.valueOf(roomId), Long.valueOf(pageInTime));
        } else {
            ReportHelper.INSTANCE.savePageInTime(roomId, pageInTime);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.IReportEnterRoom
    public void savePageOutTimeAndTryReportVideoError(long roomId, long pageOutTime, boolean isForceReport) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Long.valueOf(roomId), Long.valueOf(pageOutTime), Boolean.valueOf(isForceReport));
        } else {
            ReportHelper.INSTANCE.savePageOutTimeAndTryReportVideoError(roomId, pageOutTime, isForceReport);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.IReportEnterRoom
    public void savePlayerStartBufferInfo(long roomId, long startTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Long.valueOf(roomId), Long.valueOf(startTime));
        } else {
            ReportHelper.INSTANCE.savePlayerStartBufferInfo(roomId, startTime);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.IReportEnterRoom
    public void savePlayerStopBufferInfo(long roomId, long endTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Long.valueOf(roomId), Long.valueOf(endTime));
        } else {
            ReportHelper.INSTANCE.savePlayerStopBufferInfo(roomId, endTime);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.IReportEnterRoom
    public void saveRecordInfo(long roomId, @NotNull String roomType, @NotNull String jumpSource, @NotNull String uid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(roomId), roomType, jumpSource, uid);
            return;
        }
        Intrinsics.checkNotNullParameter(roomType, "roomType");
        Intrinsics.checkNotNullParameter(jumpSource, "jumpSource");
        Intrinsics.checkNotNullParameter(uid, "uid");
        ReportHelper.INSTANCE.saveRecordInfo(roomId, roomType, jumpSource, uid);
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.IReportEnterRoom
    public void saveSwitchRoomTime(long roomId, long startTime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Long.valueOf(roomId), Long.valueOf(startTime));
        } else {
            ReportHelper.INSTANCE.saveSwitchRoomTime(roomId, startTime);
        }
    }
}
