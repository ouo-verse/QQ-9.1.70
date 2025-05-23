package com.tencent.hippykotlin.demo.pages.qqfile.model;

import com.tencent.aegiskmm.d;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class KTFileInfo {
    public final int absFileType;
    public final int expireTime;
    public final String fileIdCrc;
    public final String fileName;
    public final int fileSceneType;
    public final long fileSize;
    public final String fileSizeDes;
    public final int lifeTime;
    public final String md5;
    public final long ownerUin;
    public final long peerUin;
    public final String sha;
    public final String sha3;
    public final String tenMBMd5;
    public final int uploadTime;
    public final String uuid;

    public final int hashCode() {
        return this.fileSceneType + QQAudioParams$$ExternalSyntheticOutline0.m(this.absFileType, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.fileName, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.uuid, QQAudioParams$$ExternalSyntheticOutline0.m(this.uploadTime, QQAudioParams$$ExternalSyntheticOutline0.m(this.lifeTime, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.fileSizeDes, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.fileSize, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.sha, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.tenMBMd5, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.sha3, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.md5, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.fileIdCrc, QQAudioParams$$ExternalSyntheticOutline0.m(this.expireTime, AdelieRedDotModule$Companion$RedDotInfo$$ExternalSyntheticOutline0.m(this.peerUin, d.a(this.ownerUin) * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31);
    }

    public final String toString() {
        return "KTFileInfo(ownerUin=" + this.ownerUin + ", peerUin=" + this.peerUin + ", expireTime=" + this.expireTime + ", fileIdCrc='" + this.fileIdCrc + "', md5='" + this.md5 + "', sha3='" + this.sha3 + "', tenMBMd5='" + this.tenMBMd5 + "', sha='" + this.sha + "', fileSize=" + this.fileSize + ", fileSizeDes='" + this.fileSizeDes + "', lifeTime=" + this.lifeTime + ", uploadTime=" + this.uploadTime + ", uuid='" + this.uuid + "', fileName='" + this.fileName + "', absFileType=" + this.absFileType + ", fileSceneType=" + this.fileSceneType + ", )";
    }

    public KTFileInfo(long j3, long j16, int i3, String str, String str2, String str3, String str4, String str5, long j17, String str6, int i16, int i17, String str7, String str8, int i18, int i19) {
        this.ownerUin = j3;
        this.peerUin = j16;
        this.expireTime = i3;
        this.fileIdCrc = str;
        this.md5 = str2;
        this.sha3 = str3;
        this.tenMBMd5 = str4;
        this.sha = str5;
        this.fileSize = j17;
        this.fileSizeDes = str6;
        this.lifeTime = i16;
        this.uploadTime = i17;
        this.uuid = str7;
        this.fileName = str8;
        this.absFileType = i18;
        this.fileSceneType = i19;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KTFileInfo)) {
            return false;
        }
        KTFileInfo kTFileInfo = (KTFileInfo) obj;
        return this.ownerUin == kTFileInfo.ownerUin && this.peerUin == kTFileInfo.peerUin && this.expireTime == kTFileInfo.expireTime && Intrinsics.areEqual(this.fileIdCrc, kTFileInfo.fileIdCrc) && Intrinsics.areEqual(this.md5, kTFileInfo.md5) && Intrinsics.areEqual(this.sha3, kTFileInfo.sha3) && Intrinsics.areEqual(this.tenMBMd5, kTFileInfo.tenMBMd5) && Intrinsics.areEqual(this.sha, kTFileInfo.sha) && this.fileSize == kTFileInfo.fileSize && Intrinsics.areEqual(this.fileSizeDes, kTFileInfo.fileSizeDes) && this.lifeTime == kTFileInfo.lifeTime && this.uploadTime == kTFileInfo.uploadTime && Intrinsics.areEqual(this.uuid, kTFileInfo.uuid) && Intrinsics.areEqual(this.fileName, kTFileInfo.fileName) && this.absFileType == kTFileInfo.absFileType && this.fileSceneType == kTFileInfo.fileSceneType;
    }
}
