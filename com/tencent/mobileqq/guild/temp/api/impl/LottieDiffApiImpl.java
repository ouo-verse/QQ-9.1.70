package com.tencent.mobileqq.guild.temp.api.impl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.l;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AniStickerInfo;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.anisticker.AniStickerHelper;
import com.tencent.mobileqq.emoticonview.anisticker.AniStickerLottie;
import com.tencent.mobileqq.emoticonview.anisticker.AniStickerLottieView;
import com.tencent.mobileqq.guild.temp.api.ILottieDiffApi;
import com.tencent.qqnt.kernel.nativeinterface.FaceElement;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes33.dex */
public class LottieDiffApiImpl implements ILottieDiffApi {
    private static final int LOTTIE_GROUP_VIEW_ID = 2131363049;
    private static final int LOTTIE_VIEW_ID = 2131363048;
    private static final long MEDIA_PLAY_LOTTIE_LEAST_TIME_MILLS = 1500;
    private static final String TAG = "LottieDiffApiImpl";

    public LottieDiffApiImpl() {
        AniStickerLottie.init();
    }

    private View buildLottieView(Context context, ViewGroup.LayoutParams layoutParams) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setId(R.id.spw);
        AniStickerLottieView aniStickerLottieView = new AniStickerLottieView(context);
        aniStickerLottieView.setId(R.id.spv);
        if (layoutParams == null) {
            int i3 = AniStickerHelper.LOTTIE_ANIM_SIZE;
            layoutParams = new ViewGroup.LayoutParams(i3, i3);
        }
        frameLayout.addView(aniStickerLottieView, layoutParams);
        return frameLayout;
    }

    private ILottieDiffApi.a createLottieEmoInfo(int i3) {
        AniStickerInfo aniStickerInfo = QQSysFaceUtil.getAniStickerInfo(i3);
        ILottieDiffApi.a aVar = new ILottieDiffApi.a();
        aVar.f235232c = aniStickerInfo.aniStickerId;
        aVar.f235231b = aniStickerInfo.aniStickerPackId;
        aVar.f235230a = aniStickerInfo.aniStickerType;
        aVar.f235236g = aniStickerInfo.randomKey;
        int i16 = aniStickerInfo.localId;
        aVar.f235234e = i16;
        aVar.f235233d = i16;
        aVar.f235235f = aniStickerInfo.text;
        return aVar;
    }

    private QQAppInterface getAppRuntime() {
        return (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
    }

    private boolean isLottieEmo(int i3) {
        return QQSysFaceUtil.isBigStickerById(QQSysFaceUtil.convertToLocal(i3));
    }

    @Override // com.tencent.mobileqq.guild.temp.api.ILottieDiffApi
    public void addToCustomEmotion(Context context, String str) {
        com.tencent.mobileqq.activity.aio.photo.c.b(context, str, getAppRuntime(), context.getResources().getDimensionPixelSize(R.dimen.title_bar_height), null);
    }

    protected View buildLottieViewAndBind(Context context, int i3, ViewGroup.LayoutParams layoutParams) {
        View buildLottieView = buildLottieView(context, layoutParams);
        AniStickerHelper.setAniStickerResource(new AniStickerHelper.Builder((AniStickerLottieView) buildLottieView.findViewById(R.id.spv)).localId(i3).placeholderDrawable(R.drawable.f162503o43).build());
        return buildLottieView;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.ILottieDiffApi
    public View createLottieAnimView(Context context, FaceElement faceElement, int i3, ViewGroup.LayoutParams layoutParams) {
        return buildLottieViewAndBind(context, QQSysFaceUtil.convertToLocal(i3), layoutParams);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.ILottieDiffApi
    public View createLottieAnimViewForMedia(Context context, ViewGroup viewGroup, int i3, FrameLayout.LayoutParams layoutParams, Runnable runnable) {
        int convertToLocal = QQSysFaceUtil.convertToLocal(i3);
        View tryToFindExistLottieView = tryToFindExistLottieView(viewGroup, layoutParams);
        if (tryToFindExistLottieView == null) {
            tryToFindExistLottieView = buildLottieView(context, layoutParams);
        }
        AniStickerHelper.setAniStickerResource(new AniStickerHelper.Builder((AniStickerLottieView) tryToFindExistLottieView.findViewById(R.id.spv)).localId(convertToLocal).playLeastTime(1500L).configFinishRunnable(runnable).placeholderDrawable(R.drawable.f162503o43).build());
        return tryToFindExistLottieView;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.ILottieDiffApi
    public ILottieDiffApi.a getLottieEmoInfo(int i3) {
        if (isLottieEmo(i3)) {
            return createLottieEmoInfo(QQSysFaceUtil.convertToLocal(i3));
        }
        return null;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.ILottieDiffApi
    public boolean isSupportLottie(int i3) {
        return hg1.a.a() && isLottieEmo(i3);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.ILottieDiffApi
    public void recyclerLottieViewDrawable(View view) {
        if (view instanceof AniStickerLottieView) {
            AniStickerLottieView aniStickerLottieView = (AniStickerLottieView) view;
            aniStickerLottieView.clearLottieDrawable();
            aniStickerLottieView.clearSecondLottieDrawable();
            aniStickerLottieView.clearLoadingDrawable();
            aniStickerLottieView.clearAnimation();
        }
    }

    @Override // com.tencent.mobileqq.guild.temp.api.ILottieDiffApi
    public boolean checkSaveToEmoMenuItemEnable() {
        return l.x(1) == 1;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.ILottieDiffApi
    public void addToCustomEmotion(Context context, Drawable drawable) {
        if (drawable instanceof URLDrawable) {
            com.tencent.mobileqq.activity.aio.photo.c.e(context, getAppRuntime(), (URLDrawable) drawable, "", context.getResources().getDimensionPixelSize(R.dimen.title_bar_height), null, null);
        }
    }

    private View tryToFindExistLottieView(ViewGroup viewGroup, FrameLayout.LayoutParams layoutParams) {
        View findViewById;
        AniStickerLottieView aniStickerLottieView;
        if (viewGroup == null || (findViewById = viewGroup.findViewById(R.id.spw)) == null || (aniStickerLottieView = (AniStickerLottieView) findViewById.findViewById(R.id.spv)) == null) {
            return null;
        }
        aniStickerLottieView.reset();
        if (layoutParams != null) {
            aniStickerLottieView.setLayoutParams(layoutParams);
        }
        findViewById.setVisibility(0);
        return findViewById;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.ILottieDiffApi
    public void pauseLottie(ViewGroup viewGroup) {
        if (viewGroup != null) {
            View findViewById = viewGroup.findViewById(R.id.spv);
            if (findViewById instanceof AniStickerLottieView) {
                ((AniStickerLottieView) findViewById).stopAnimation();
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.temp.api.ILottieDiffApi
    public void resumeLottie(ViewGroup viewGroup) {
        if (viewGroup != null) {
            View findViewById = viewGroup.findViewById(R.id.spv);
            if (findViewById instanceof AniStickerLottieView) {
                ((AniStickerLottieView) findViewById).playAnimation();
            }
        }
    }
}
