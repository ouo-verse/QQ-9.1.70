package com.tencent.mobileqq.guild.media.core.logic.trtc;

import android.os.Bundle;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.mobileqq.guild.media.core.data.TRTCQuality;
import com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a implements ITRTCAudioRoom.b {
    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
    public void a(String str, int i3, String str2) {
        QLog.i("QGMC.IPCTRTCAudioRoomListener", 1, "pushOnTRTCAnchorEnter: " + str2);
        Bundle bundle = new Bundle();
        bundle.putString(CommonConstant.RETKEY.USERID, str2);
        QIPCClientHelper.getInstance().callServer("TRTCAudioRoomServerQIPCModule", "ON_TRTC_ANCHOR_ENTER", bundle);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
    public void b(String str, int i3, String str2, boolean z16) {
        QLog.i("QGMC.IPCTRTCAudioRoomListener", 1, "pushOnTRTCAudioAvailable: " + str2 + ", available:" + z16);
        Bundle bundle = new Bundle();
        bundle.putString(CommonConstant.RETKEY.USERID, str2);
        bundle.putBoolean("USER_AUDIO_AVAILABLE", z16);
        QIPCClientHelper.getInstance().callServer("TRTCAudioRoomServerQIPCModule", "ON_TRTC_AUDIO_AVAILABLE", bundle);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
    public void c(String str, int i3, ArrayList<ITRTCAudioRoom.TRTCVolumeInfo> arrayList, int i16) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("USER_VOLUME_INFO_LIST", arrayList);
        bundle.putInt("ROOM_TOTAL_VOLUME", i16);
        QIPCClientHelper.getInstance().callServer("TRTCAudioRoomServerQIPCModule", "ON_TRTC_USER_VOICE_VOLUME", bundle);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
    public void d(String str, int i3, int i16, String str2) {
        QLog.i("QGMC.IPCTRTCAudioRoomListener", 1, "pushOnTRTCExitRoom reason:" + i16 + ", msg:" + str2);
        Bundle bundle = new Bundle();
        bundle.putInt("EXIT_ROOM_REASON", i16);
        bundle.putString("EXIT_ROOM_MSG", str2);
        QIPCClientHelper.getInstance().callServer("TRTCAudioRoomServerQIPCModule", "PUSH_ON_TRTC_EXIT_ROOM", bundle);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
    public void f(String str, int i3, String str2, boolean z16) {
        QLog.i("QGMC.IPCTRTCAudioRoomListener", 1, "pushOnTRTCVideoAvailable: " + str2 + ", available:" + z16);
        Bundle bundle = new Bundle();
        bundle.putString(CommonConstant.RETKEY.USERID, str2);
        bundle.putBoolean("USER_VIDEO_AVAILABLE", z16);
        QIPCClientHelper.getInstance().callServer("TRTCAudioRoomServerQIPCModule", "ON_TRTC_VIDEO_AVAILABLE", bundle);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
    public void g(String str, int i3, String str2) {
        QLog.i("QGMC.IPCTRTCAudioRoomListener", 1, "pushOnTRTCAnchorExit: " + str2);
        Bundle bundle = new Bundle();
        bundle.putString(CommonConstant.RETKEY.USERID, str2);
        QIPCClientHelper.getInstance().callServer("TRTCAudioRoomServerQIPCModule", "ON_TRTC_ANCHOR_EXIT", bundle);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
    public void h(String str, int i3, String str2, int i16, int i17) {
        QLog.i("QGMC.IPCTRTCAudioRoomListener", 1, "pushOnTRTCVideoSizeChange: " + str2 + ", width:" + i16 + ", height=" + i17);
        Bundle bundle = new Bundle();
        bundle.putString(CommonConstant.RETKEY.USERID, str2);
        bundle.putInt("USER_VIDEO_WIDTH", i16);
        bundle.putInt("USER_VIDEO_HEIGHT", i17);
        QIPCClientHelper.getInstance().callServer("TRTCAudioRoomServerQIPCModule", "PUSH_ON_TRTC_VIDEO_SIZE_CHANGE", bundle);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
    public void i(String str, int i3, TRTCQuality tRTCQuality, ArrayList<TRTCQuality> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("LOCAL_QUALITY", tRTCQuality);
        bundle.putParcelableArrayList("REMOTE_QUALITY", arrayList);
        QIPCClientHelper.getInstance().callServer("TRTCAudioRoomServerQIPCModule", "ON_TRTC_NETWORK_QUALITY", bundle);
    }

    @Override // com.tencent.mobileqq.guild.media.core.logic.trtc.ITRTCAudioRoom.b
    public void e(String str, int i3, int i16, String str2) {
    }
}
