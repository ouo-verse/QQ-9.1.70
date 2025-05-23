package com.tencent.guild.api.emoji.impl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.api.emoji.ILottieEmoProxyApi;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emosm.e;
import com.tencent.mobileqq.guild.temp.api.ILottieDiffApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.AbsQQText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import dr0.LottieFaceInfo;
import dr0.MarketSmallFaceInfo;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes6.dex */
public class LottieEmoProxyApiImpl implements ILottieEmoProxyApi {
    private static final String TAG = "LottieEmoProxyApiImpl";

    private AppRuntime getAppRuntime() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    private ILottieDiffApi lottieDiffApi() {
        return (ILottieDiffApi) QRoute.api(ILottieDiffApi.class);
    }

    @Override // com.tencent.guild.api.emoji.ILottieEmoProxyApi
    public void addToCustomEmotion(Context context, String str) {
        if (context == null) {
            QLog.e(TAG, 1, "addToCustomEmotion fail, context == null");
        } else {
            ((ILottieDiffApi) QRoute.api(ILottieDiffApi.class)).addToCustomEmotion(context, str);
        }
    }

    @Override // com.tencent.guild.api.emoji.ILottieEmoProxyApi
    public boolean checkSaveToEmoMenuItemEnable() {
        return ((ILottieDiffApi) QRoute.api(ILottieDiffApi.class)).checkSaveToEmoMenuItemEnable();
    }

    @Override // com.tencent.guild.api.emoji.ILottieEmoProxyApi
    public View createLottieAnimView(Context context, FaceElement faceElement, int i3, ViewGroup.LayoutParams layoutParams) {
        if (context == null) {
            QLog.e(TAG, 1, "createLottieAnimView fail, context == null");
            return null;
        }
        return ((ILottieDiffApi) QRoute.api(ILottieDiffApi.class)).createLottieAnimView(context, faceElement, i3, layoutParams);
    }

    @Override // com.tencent.guild.api.emoji.ILottieEmoProxyApi
    public View createLottieAnimViewForMedia(Context context, ViewGroup viewGroup, int i3, FrameLayout.LayoutParams layoutParams, Runnable runnable) {
        if (context == null) {
            QLog.e(TAG, 1, "createLottieAnimViewForMedia fail, context == null");
            return null;
        }
        return ((ILottieDiffApi) QRoute.api(ILottieDiffApi.class)).createLottieAnimViewForMedia(context, viewGroup, i3, layoutParams, runnable);
    }

    @Override // com.tencent.guild.api.emoji.ILottieEmoProxyApi
    public LottieFaceInfo getLottieEmoInfo(int i3) {
        ILottieDiffApi.a lottieEmoInfo = ((ILottieDiffApi) QRoute.api(ILottieDiffApi.class)).getLottieEmoInfo(i3);
        LottieFaceInfo lottieFaceInfo = new LottieFaceInfo();
        lottieFaceInfo.e(lottieEmoInfo.f235232c);
        lottieFaceInfo.f(lottieEmoInfo.f235231b);
        lottieFaceInfo.g(lottieEmoInfo.f235230a);
        try {
            lottieFaceInfo.i(Integer.valueOf(lottieEmoInfo.f235236g).intValue());
        } catch (Exception e16) {
            QLog.e("getLottieEmoInfo", 4, e16, new Object[0]);
        }
        lottieFaceInfo.k(lottieEmoInfo.f235235f);
        lottieFaceInfo.h(lottieEmoInfo.f235234e);
        lottieFaceInfo.j(lottieEmoInfo.f235233d);
        return lottieFaceInfo;
    }

    @Override // com.tencent.guild.api.emoji.ILottieEmoProxyApi
    public boolean isSupportLottie(int i3) {
        return ((ILottieDiffApi) QRoute.api(ILottieDiffApi.class)).isSupportLottie(i3);
    }

    @Override // com.tencent.guild.api.emoji.ILottieEmoProxyApi
    public MarketSmallFaceInfo parseMarketSmallFace(String str, int i3) {
        Emoticon emoticon;
        char[] cArr = new char[4];
        cArr[3] = str.charAt(i3 + 1);
        int i16 = 2;
        cArr[2] = str.charAt(i3 + 2);
        cArr[1] = str.charAt(i3 + 3);
        cArr[0] = str.charAt(i3 + 4);
        for (int i17 = 0; i17 < 4; i17++) {
            char c16 = cArr[i17];
            if (c16 == '\u00fa') {
                cArr[i17] = '\n';
            } else if (c16 == '\u00fe') {
                cArr[i17] = '\r';
            }
        }
        int[] r16 = e.r(cArr);
        char c17 = cArr[3];
        if (c17 != '\u01ff') {
            if (c17 == '\u00ff') {
                i16 = 1;
            } else {
                i16 = 0;
            }
        }
        AppInterface appInterface = (AppInterface) getAppRuntime();
        String str2 = AbsQQText.SMALL_EMOJI_SYMBOL;
        if (appInterface != null) {
            IEmoticonManagerService iEmoticonManagerService = (IEmoticonManagerService) appInterface.getRuntimeService(IEmoticonManagerService.class, "");
            if (iEmoticonManagerService != null) {
                emoticon = iEmoticonManagerService.syncFindEmoticonById(Integer.toString(r16[0]), Integer.toString(r16[1]));
            } else {
                emoticon = null;
            }
            if (emoticon != null) {
                str2 = emoticon.character;
            }
        }
        return new MarketSmallFaceInfo(r16[0], r16[1], i16, str2);
    }

    @Override // com.tencent.guild.api.emoji.ILottieEmoProxyApi
    public void pauseLottie(ViewGroup viewGroup) {
        lottieDiffApi().pauseLottie(viewGroup);
    }

    @Override // com.tencent.guild.api.emoji.ILottieEmoProxyApi
    public void recyclerLottieViewDrawable(View view) {
        ((ILottieDiffApi) QRoute.api(ILottieDiffApi.class)).recyclerLottieViewDrawable(view);
    }

    @Override // com.tencent.guild.api.emoji.ILottieEmoProxyApi
    public void resumeLottie(ViewGroup viewGroup) {
        lottieDiffApi().resumeLottie(viewGroup);
    }

    @Override // com.tencent.guild.api.emoji.ILottieEmoProxyApi
    public void addToCustomEmotion(Context context, Drawable drawable) {
        if (context == null) {
            QLog.e(TAG, 1, "addToCustomEmotion fail, context == null");
        } else {
            ((ILottieDiffApi) QRoute.api(ILottieDiffApi.class)).addToCustomEmotion(context, drawable);
        }
    }
}
