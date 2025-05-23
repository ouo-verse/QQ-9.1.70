package com.tencent.mobileqq.activity.richmedia.p2veffect.main;

import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.richmedia.p2veffect.listener.IControllerFilterProvider;
import com.tencent.mobileqq.activity.richmedia.p2veffect.listener.IFastRenderCallback;
import com.tencent.mobileqq.activity.richmedia.p2veffect.listener.IOnStopCompleteListener;
import com.tencent.mobileqq.activity.richmedia.p2veffect.listener.IP2VEnginePlayerCallback;
import com.tencent.mobileqq.activity.richmedia.p2veffect.model.MediaItem;
import java.util.ArrayList;

/* loaded from: classes10.dex */
public interface IP2VEffectControll {
    public static final int ERR_GET_DIMENS = 2;
    public static final int ERR_INVALID_DURATION = 3;
    public static final int ERR_MATERIAL_PARSE = 1;

    void addPlayerCallback(IP2VEnginePlayerCallback iP2VEnginePlayerCallback);

    void cancelSave(IOnStopCompleteListener iOnStopCompleteListener);

    void onDestroy();

    void pausePlay();

    void prepare();

    void requestDraw();

    void resetVideoIndex();

    void save(String str, IFastRenderCallback iFastRenderCallback);

    void setFilterProvider(IControllerFilterProvider iControllerFilterProvider);

    void setMediaItems(ArrayList<MediaItem> arrayList);

    void setSquareTypeAndColor(int i3, int i16, int i17, int i18);

    void setWaterMarkerBitmap(Bitmap bitmap);

    void setWaterMarkerEnable(boolean z16);

    void startPlay(boolean z16);

    void stopPlay();
}
