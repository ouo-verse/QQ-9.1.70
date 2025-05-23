package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmotionInjectionInfo;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes12.dex */
public class EmotionPanelListViewAdapterBuilder {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "EmotionPanelListViewAdapterBuilder";
    private static EmotionPanelListViewAdapterBuilder sInstance;

    EmotionPanelListViewAdapterBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static EmotionPanelListViewAdapterBuilder getInstance() {
        if (sInstance == null) {
            synchronized (EmotionPanelListViewAdapterBuilder.class) {
                if (sInstance == null) {
                    sInstance = new EmotionPanelListViewAdapterBuilder();
                }
            }
        }
        return sInstance;
    }

    public BaseEmotionAdapter getAdapter(QQEmoticonMainPanelApp qQEmoticonMainPanelApp, Context context, com.tencent.mobileqq.i iVar, IPanelInteractionListener iPanelInteractionListener, int i3, int i16, int i17, EmoticonPackage emoticonPackage, EmoticonCallback emoticonCallback, int i18, boolean z16, boolean z17) {
        EmotionInjectionInfo b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BaseEmotionAdapter) iPatchRedirector.redirect((short) 2, this, qQEmoticonMainPanelApp, context, iVar, iPanelInteractionListener, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), emoticonPackage, emoticonCallback, Integer.valueOf(i18), Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getAdapter panelType = " + i16);
        }
        switch (i16) {
            case 1:
            case 16:
            case 17:
            case 18:
                return new SystemAndEmojiAdapter(qQEmoticonMainPanelApp, iPanelInteractionListener, context, i3, i16, i17, emoticonCallback, i18);
            case 2:
                return new SmallEmotionDownloadedAdapter(qQEmoticonMainPanelApp, iPanelInteractionListener, context, i3, i16, i17, emoticonPackage, emoticonCallback, i18);
            case 3:
                return new RecommendEmotionAdapter(qQEmoticonMainPanelApp, context, i3, i16, i17, emoticonCallback, i18, z16);
            case 4:
                return new FavoriteEmotionAdapter(qQEmoticonMainPanelApp, iPanelInteractionListener, context, i3, i16, i17, emoticonCallback);
            case 5:
                return new MagicFaceAdapter(qQEmoticonMainPanelApp, context, i3, i16, i17, emoticonCallback);
            case 6:
                return new BigEmotionDownloadedAdapter(qQEmoticonMainPanelApp, iPanelInteractionListener, context, i3, i16, i17, emoticonPackage, emoticonCallback, i18);
            case 7:
                return new EmotionDownloadOrInvalidAdapter(qQEmoticonMainPanelApp, iPanelInteractionListener, context, i3, i16, i17, emoticonPackage, emoticonCallback, i18);
            case 8:
                return new BigEmotionUpdateAdapter(qQEmoticonMainPanelApp, context, i3, i16, i17, emoticonPackage, emoticonCallback, i18);
            case 9:
                return new SmallEmotionUpdateAdapter(qQEmoticonMainPanelApp, context, i3, i16, i17, emoticonPackage, emoticonCallback, i18);
            case 10:
            case 11:
            case 15:
            case 19:
            case 20:
            default:
                if (iVar != null && (b16 = iVar.b(i17)) != null && b16.emotionPanelBuilder != null) {
                    return new com.tencent.mobileqq.core.a().a(b16.emotionPanelBuilder);
                }
                return null;
            case 12:
                return new EmotionCompleteInvalidAdapter(qQEmoticonMainPanelApp, iPanelInteractionListener, context, i3, i16, i17, emoticonPackage, emoticonCallback);
            case 13:
                return new CameraEmotionAdapter(qQEmoticonMainPanelApp, iPanelInteractionListener, context, i3, i16, i17, emoticonCallback);
            case 14:
                return new EmotionHotPicSearchAdapter(qQEmoticonMainPanelApp, iPanelInteractionListener, context, i3, i16, i17, emoticonCallback);
            case 21:
                return new AniStickerAdapter(qQEmoticonMainPanelApp, iPanelInteractionListener, context, i3, i16, i17, emoticonCallback, i18, z17);
            case 22:
                if (qQEmoticonMainPanelApp == null || iPanelInteractionListener == null || emoticonCallback == null) {
                    QLog.i(TAG, 1, "EmotionAIAdapter  app:" + qQEmoticonMainPanelApp + ", interactionListener:" + iPanelInteractionListener + ", callback:" + emoticonCallback);
                }
                return new EmotionAIAdapter(qQEmoticonMainPanelApp, iPanelInteractionListener, context, i3, i16, i17, emoticonCallback);
        }
    }
}
