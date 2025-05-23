package com.tencent.mobileqq.app.face;

import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;

/* compiled from: P */
/* loaded from: classes11.dex */
public interface IFaceDecoder {
    public static final int FROM_AIO = 6;
    public static final int FROM_DIS_MEMBER = 5;
    public static final int FROM_DIS_MEMBER_LIST = 1;
    public static final int FROM_TROOP_CHAT_SETTING = 3;
    public static final int FROM_TROOP_CHAT_SETTING_UPDATE = 4;
    public static final int FROM_TROOP_MEMBER = 2;

    void cancelPendingRequests();

    void destory();

    Bitmap getBitmapFromCache(int i3, String str);

    Bitmap getBitmapFromCache(int i3, String str, int i16);

    Bitmap getBitmapFromCache(int i3, String str, int i16, byte b16);

    Bitmap getBitmapFromCacheFrom(int i3, String str, int i16);

    boolean isPausing();

    void pause();

    void refreshFaceWithTimeStamp(int i3, String str, int i16, long j3, int i17);

    boolean requestDecodeFace(String str, int i3, boolean z16);

    boolean requestDecodeFace(String str, int i3, boolean z16, byte b16);

    boolean requestDecodeFace(String str, int i3, boolean z16, int i16, boolean z17, byte b16, int i17);

    boolean requestDecodeQCallFace(String str, int i3, boolean z16, boolean z17);

    boolean requestDecodeStrangeFace(String str, int i3, boolean z16, boolean z17);

    boolean requestDecodeStrangeSquareFace(String str, int i3, boolean z16, boolean z17);

    void resume();

    void setAppRuntime(AppInterface appInterface);

    void setDecodeTaskCompletionListener(DecodeTaskCompletionListener decodeTaskCompletionListener);
}
