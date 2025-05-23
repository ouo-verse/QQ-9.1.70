package com.tencent.guild.aio.util;

import android.text.TextUtils;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.kernel.nativeinterface.VideoElement;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/guild/aio/util/x;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "", "elementType", "", "progress", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "fileInfo", "c", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItem", "", "d", "", "videoPath", "a", "<init>", "()V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final x f112474a = new x();

    x() {
    }

    public final long a(@Nullable String videoPath) {
        long j3 = -1;
        if (TextUtils.isEmpty(videoPath)) {
            return -1L;
        }
        if (!new File(videoPath).exists()) {
            if (QLog.isColorLevel()) {
                QLog.e("RichMediaUtil", 2, "Path:" + videoPath + ", not exits!");
            }
            return -1L;
        }
        ReportMediaPlayer reportMediaPlayer = new ReportMediaPlayer();
        try {
            try {
                reportMediaPlayer.setDataSource(videoPath);
                reportMediaPlayer.prepare();
                j3 = reportMediaPlayer.getDuration();
            } catch (Exception e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.d("RichMediaUtil", 2, "getDuration", e16);
                }
            }
            return j3;
        } finally {
            reportMediaPlayer.release();
        }
    }

    public final int b(@NotNull MsgElement msgElement, int elementType, long progress) {
        long j3;
        VideoElement videoElement;
        Intrinsics.checkNotNullParameter(msgElement, "msgElement");
        if (elementType != 2) {
            if (elementType != 3) {
                if (elementType == 5 && (videoElement = msgElement.videoElement) != null) {
                    long j16 = videoElement.fileSize;
                    if (j16 == 0) {
                        return 0;
                    }
                    j3 = (progress * 100) / j16;
                    return (int) j3;
                }
                return 0;
            }
            FileElement fileElement = msgElement.fileElement;
            if (fileElement != null) {
                long j17 = fileElement.fileSize;
                if (j17 == 0) {
                    return 0;
                }
                j3 = (progress * 100) / j17;
                return (int) j3;
            }
            return 0;
        }
        PicElement picElement = msgElement.picElement;
        if (picElement != null) {
            long j18 = picElement.fileSize;
            if (j18 == 0) {
                return 0;
            }
            j3 = (progress * 100) / j18;
            return (int) j3;
        }
        return 0;
    }

    public final int c(@NotNull MsgElement msgElement, int elementType, @NotNull FileTransNotifyInfo fileInfo) {
        VideoElement videoElement;
        Intrinsics.checkNotNullParameter(msgElement, "msgElement");
        Intrinsics.checkNotNullParameter(fileInfo, "fileInfo");
        long j3 = 100;
        if (elementType != 2) {
            if (elementType != 3) {
                if (elementType == 5 && (videoElement = msgElement.videoElement) != null) {
                    long j16 = videoElement.fileSize;
                    if (j16 == 0) {
                        return 0;
                    }
                    long j17 = (fileInfo.fileProgress * 100) / j16;
                    if (j17 <= 100) {
                        j3 = j17;
                    }
                    return (int) j3;
                }
            } else {
                FileElement fileElement = msgElement.fileElement;
                if (fileElement != null) {
                    long j18 = fileElement.fileSize;
                    if (j18 == 0) {
                        return 0;
                    }
                    long j19 = (fileInfo.fileProgress * 100) / j18;
                    if (j19 <= 100) {
                        j3 = j19;
                    }
                    return (int) j3;
                }
            }
        } else {
            PicElement picElement = msgElement.picElement;
            if (picElement != null) {
                long j26 = picElement.fileSize;
                if (j26 == 0) {
                    return 0;
                }
                long j27 = (fileInfo.fileProgress * 100) / j26;
                if (j27 <= 100) {
                    j3 = j27;
                }
                return (int) j3;
            }
        }
        return 0;
    }

    public final boolean d(@NotNull GuildMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (msgItem.getMsgRecord().msgType != 7 && msgItem.getMsgRecord().msgType != 3 && !qr0.d.p(msgItem)) {
            return false;
        }
        return true;
    }
}
