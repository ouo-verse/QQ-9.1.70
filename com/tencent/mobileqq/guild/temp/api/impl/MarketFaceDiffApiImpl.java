package com.tencent.mobileqq.guild.temp.api.impl;

import android.app.Activity;
import android.content.Context;
import android.util.Pair;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emosm.o;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.anisticker.AniStickerLottie;
import com.tencent.mobileqq.emoticonview.api.IEmoAddedAuthCallbackService;
import com.tencent.mobileqq.guild.temp.api.IMarketFaceDiffApi;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.EmotionConstants;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MarketFaceDiffApiImpl implements IMarketFaceDiffApi {
    private static final String TAG = "MarketFaceDiffApiImpl";
    EmoticonPackageDownloadListener magicFaceDownloadListener = new b();

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements PngFrameManager.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IPicEmoticonInfo f235249a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ImageView f235250b;

        a(IPicEmoticonInfo iPicEmoticonInfo, ImageView imageView) {
            this.f235249a = iPicEmoticonInfo;
            this.f235250b = imageView;
        }

        @Override // com.tencent.mobileqq.magicface.drawable.PngFrameManager.a
        public void a(boolean z16) {
            QLog.i(MarketFaceDiffApiImpl.TAG, 1, "showInOldWay isShow=" + z16);
            if (z16) {
                MarketFaceDiffApiImpl.this.updateBubbleView(this.f235249a, this.f235250b);
            }
        }

        @Override // com.tencent.mobileqq.magicface.drawable.PngFrameManager.a
        public void b(MarketFaceItemBuilder.c cVar) {
            QLog.i(MarketFaceDiffApiImpl.TAG, 1, "downloadVideoDetails");
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class b extends EmoticonPackageDownloadListener {
        b() {
        }

        @Override // com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener
        public void onPackageEnd(EmoticonPackage emoticonPackage, int i3) {
            QLog.i(MarketFaceDiffApiImpl.TAG, 4, "onPackageEnd resultCode=" + i3);
        }
    }

    public MarketFaceDiffApiImpl() {
        AniStickerLottie.init();
    }

    private QQAppInterface getAppRuntime() {
        return (QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
    }

    private void handleMagicFacePlay(IPicEmoticonInfo iPicEmoticonInfo) {
        if (2 == iPicEmoticonInfo.getEmoticon().jobType && MagicfaceViewController.c()) {
            IEmojiManagerService iEmojiManagerService = (IEmojiManagerService) getAppRuntime().getRuntimeService(IEmojiManagerService.class);
            if (iEmojiManagerService.verifyMagicFacePackageIntact(iPicEmoticonInfo.getEmoticon().epId) || com.tencent.mobileqq.core.util.a.l() || iEmojiManagerService.isMagicFacePackageIntact(iPicEmoticonInfo.getEmoticon().epId, Boolean.FALSE) || -1.0f != iEmojiManagerService.getEmoticonPackageLoadingProgress(iPicEmoticonInfo.getEmoticon().epId)) {
                return;
            }
            iEmojiManagerService.getEmojiListenerManager().addEmoticonPackageDownloadListener(this.magicFaceDownloadListener);
            EmoticonPackage emoticonPackage = new EmoticonPackage();
            emoticonPackage.name = iPicEmoticonInfo.getEmoticon().name;
            emoticonPackage.epId = iPicEmoticonInfo.getEmoticon().epId;
            emoticonPackage.jobType = 3;
            emoticonPackage.rscType = com.tencent.mobileqq.magicface.drawable.d.g(iPicEmoticonInfo.getEmoticon().magicValue);
            emoticonPackage.type = 1;
            emoticonPackage.isMagicFaceDownloading = true;
            ((IEmoticonManagerService) getAppRuntime().getRuntimeService(IEmoticonManagerService.class)).saveEmoticon(iPicEmoticonInfo.getEmoticon());
            iEmojiManagerService.pullEmoticonPackage(emoticonPackage, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBubbleView(IPicEmoticonInfo iPicEmoticonInfo, ImageView imageView) {
        URLDrawable loadingDrawable = iPicEmoticonInfo.getLoadingDrawable(EmotionConstants.FROM_AIO, !iPicEmoticonInfo.isSound());
        Pair<Integer, Integer> a16 = v02.a.f440715a.a(imageView.getContext(), iPicEmoticonInfo);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(((Integer) a16.first).intValue(), ((Integer) a16.second).intValue()));
        imageView.setImageDrawable(loadingDrawable);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IMarketFaceDiffApi
    public void authDownloadEmoticonByFav(String str, String str2) {
        QLog.i(TAG, 1, "authDownloadEmoticonByFav epId=" + str + " eId=" + str2);
        ((o) getAppRuntime().getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM)).t2(6, Integer.valueOf(str).intValue(), str2);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IMarketFaceDiffApi
    public boolean isSupportMagicFace() {
        return MagicfaceViewController.c();
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IMarketFaceDiffApi
    public void openEmoMarket(Context context, String str, int i3, String str2, boolean z16) {
        if (context instanceof Activity) {
            EmojiHomeUiPlugin.openEmojiDetailPage((Activity) context, str, i3, str2, false, z16);
        }
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IMarketFaceDiffApi
    public void syncUpload(Context context, CustomEmotionData customEmotionData) {
        ((IFavroamingManagerService) getAppRuntime().getRuntimeService(IFavroamingManagerService.class)).syncUpload(customEmotionData, ((IEmoAddedAuthCallbackService) QRoute.api(IEmoAddedAuthCallbackService.class)).createEmoAddedAuthCallback(getAppRuntime(), context, customEmotionData, null, 0));
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IMarketFaceDiffApi
    public boolean verifyMagicFacePackageIntact(String str) {
        return ((IEmojiManagerService) getAppRuntime().getRuntimeService(IEmojiManagerService.class)).verifyMagicFacePackageIntact(str);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IMarketFaceDiffApi
    public void bindView(long j3, ImageView imageView, String str, IPicEmoticonInfo iPicEmoticonInfo, boolean z16) {
        QLog.i(TAG, 1, "bindView msgId=" + j3 + " isLastMsg=" + z16);
        MarketFaceItemBuilder.c cVar = new MarketFaceItemBuilder.c();
        cVar.f179380h = imageView;
        cVar.f179378f = iPicEmoticonInfo;
        cVar.f179383k = j3;
        imageView.setContentDescription(HardCodeUtil.qqStr(R.string.nyd) + cVar.f179378f.getEmoticon().name);
        PngFrameManager pngFrameManager = (PngFrameManager) getAppRuntime().getManager(QQManagerFactory.PNG_FRAME_DRAWABLE_MANAGER);
        pngFrameManager.j(str, cVar, j3, z16 ? pngFrameManager.d(j3) : false, true, new a(iPicEmoticonInfo, imageView));
    }
}
