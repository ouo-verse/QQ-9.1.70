package com.tencent.guild.api.emoji;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import dr0.LottieFaceInfo;
import dr0.MarketSmallFaceInfo;

@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface ILottieEmoProxyApi extends QRouteApi {
    void addToCustomEmotion(Context context, Drawable drawable);

    void addToCustomEmotion(Context context, String str);

    boolean checkSaveToEmoMenuItemEnable();

    View createLottieAnimView(Context context, FaceElement faceElement, int i3, ViewGroup.LayoutParams layoutParams);

    View createLottieAnimViewForMedia(Context context, ViewGroup viewGroup, int i3, FrameLayout.LayoutParams layoutParams, Runnable runnable);

    LottieFaceInfo getLottieEmoInfo(int i3);

    boolean isSupportLottie(int i3);

    MarketSmallFaceInfo parseMarketSmallFace(String str, int i3);

    void pauseLottie(ViewGroup viewGroup);

    void recyclerLottieViewDrawable(View view);

    void resumeLottie(ViewGroup viewGroup);
}
