package com.tencent.mobileqq.emoticonview.api.impl;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticon.data.MarketFaceConstants;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmotionUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IPanelDependListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayer;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.immersive.ImmersiveUtils;

/* loaded from: classes12.dex */
public class EmotionPanelDependListener implements IPanelDependListener {
    static IPatchRedirector $redirector_;
    private EmoticonInfo mPointInfo;
    private FrameLayout mPopupEmo;
    private ImageView mPopupEmoImage;
    private FrameLayout mWindowContent;
    private AudioPlayer player;
    private boolean showing;

    public EmotionPanelDependListener() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.showing = false;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IPanelDependListener
    public void hidePopupWindow(Context context, EmoticonCallback emoticonCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) emoticonCallback);
            return;
        }
        if (this.mPopupEmo != null && this.showing) {
            ((WindowManager) context.getSystemService("window")).removeViewImmediate(this.mWindowContent);
            AudioPlayer audioPlayer = this.player;
            if (audioPlayer != null) {
                audioPlayer.stop();
            }
            if (emoticonCallback != null) {
                emoticonCallback.onHidePopup(this.mPointInfo);
            }
            this.showing = false;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.api.IPanelDependListener
    public void showPopupEmo(View view, EmoticonInfo emoticonInfo, Rect rect, Context context, EmoticonCallback emoticonCallback) {
        int i3;
        int i16;
        int i17;
        AudioPlayer audioPlayer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, view, emoticonInfo, rect, context, emoticonCallback);
            return;
        }
        Drawable bigDrawable = emoticonInfo.getBigDrawable(context, context.getResources().getDisplayMetrics().density);
        if (bigDrawable == null) {
            return;
        }
        view.getGlobalVisibleRect(rect);
        int i18 = emoticonInfo.type;
        if (this.mWindowContent == null) {
            this.mWindowContent = new FrameLayout(context);
            this.mPopupEmo = new FrameLayout(context);
            ImageView imageView = new ImageView(context);
            this.mPopupEmoImage = imageView;
            imageView.setAdjustViewBounds(false);
            this.mPopupEmoImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.mWindowContent.addView(this.mPopupEmo);
            this.mPopupEmo.addView(this.mPopupEmoImage);
        }
        this.mPopupEmoImage.setImageDrawable(bigDrawable);
        float f16 = context.getResources().getDisplayMetrics().density;
        int i19 = (int) (5.0f * f16);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mPopupEmoImage.getLayoutParams();
        if (i18 != 1 && i18 != 2 && i18 != 7 && i18 != 10) {
            i3 = (int) (110.0f * f16);
            this.mPopupEmo.setBackgroundResource(com.tencent.mobileqq.R.drawable.o4c);
            this.mPopupEmo.setPadding(i19, i19, i19, i19);
            layoutParams.bottomMargin = 0;
            int i26 = (int) (100.0f * f16);
            layoutParams.width = i26;
            layoutParams.height = i26;
            ReportController.o(null, "CliOper", "", "", "ep_mall", "ep_preview", 0, 0, "", "", "", "");
            i16 = i3;
        } else {
            i3 = (int) (64.0f * f16);
            i16 = (int) (71.0f * f16);
            this.mPopupEmo.setBackgroundResource(com.tencent.mobileqq.R.drawable.o4d);
            this.mPopupEmo.setPadding(i19, i19, i19, i19);
            int i27 = (int) (28.0f * f16);
            layoutParams.width = i27;
            layoutParams.height = i27;
            layoutParams.bottomMargin = (int) (6.0f * f16);
            layoutParams.gravity = 17;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mPopupEmo.getLayoutParams();
        layoutParams2.gravity = 51;
        layoutParams2.leftMargin = rect.left - ((i3 - rect.width()) / 2);
        layoutParams2.topMargin = (rect.top - i16) - ((int) (f16 * 15.0f));
        layoutParams2.width = i3;
        layoutParams2.height = i16;
        if (this.showing) {
            this.mPopupEmo.requestLayout();
        } else {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (ImmersiveUtils.isSupporImmersive() == 1) {
                i17 = 67108888;
            } else {
                i17 = 24;
            }
            windowManager.addView(this.mWindowContent, new WindowManager.LayoutParams(-1, -1, 2, i17, -3));
            this.showing = true;
        }
        EmoticonInfo emoticonInfo2 = this.mPointInfo;
        this.mPointInfo = emoticonInfo;
        if (emoticonInfo2 != null && emoticonInfo2.type == 6 && (emoticonInfo2 instanceof PicEmoticonInfo) && (audioPlayer = this.player) != null) {
            audioPlayer.stop();
        }
        if (emoticonInfo.type == 6 && (emoticonInfo instanceof PicEmoticonInfo) && (bigDrawable instanceof URLDrawable)) {
            PicEmoticonInfo picEmoticonInfo = (PicEmoticonInfo) emoticonInfo;
            if (picEmoticonInfo.isSound()) {
                String replace = MarketFaceConstants.emoticonSoundPath.replace("[epId]", picEmoticonInfo.emoticon.epId).replace("[eId]", picEmoticonInfo.emoticon.eId);
                if (this.player == null) {
                    this.player = new AudioPlayer(context, null);
                }
                this.player.C(17);
                this.player.u(replace);
                EmotionUtils.startSoundDrawablePlay((URLDrawable) bigDrawable);
            }
            Emoticon emoticon = picEmoticonInfo.emoticon;
            if (2 == emoticon.jobType) {
                ReportController.o(null, "CliOper", "", "", "MbYulan", "MbChangan", 0, 0, emoticon.epId, "", "", "");
            }
        }
        if (emoticonCallback != null) {
            emoticonCallback.onShowPopup(emoticonInfo2, emoticonInfo, bigDrawable);
        }
    }
}
