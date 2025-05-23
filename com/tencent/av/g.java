package com.tencent.av;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes3.dex */
public class g implements f {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f73754a = {"QQRTCSvc.chatroom_send_msg", "QQRTCSvc.chatroom_get_msg", "QQRTCSvc.RoomManager-StartAvTogether", "QQRTCSvc.RoomManager-CloseAvTogether", "QQRTCSvc.RoomManager-GetRoomInfo", "QQRTCSvc.RoomManager-ChangeVideoStatus", "QQRTCSvc.RoomManager-ChangeVideoFile", "QQRTCSvc.RoomManager-SyncPlayTime", "QQRTCSvc.RoomManager-UserEnterRoom", "QQRTCSvc.RoomManager-UserQuitRoom"};

    @Override // com.tencent.av.f
    public boolean a(String str) {
        for (String str2 : f73754a) {
            if (TextUtils.equals(str2, str)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.av.f
    public String b() {
        return "MultiVideoMsg";
    }

    @Override // com.tencent.av.f
    public String c() {
        return "MultiVideo";
    }
}
