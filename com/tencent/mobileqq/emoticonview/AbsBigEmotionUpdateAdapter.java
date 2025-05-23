package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;

/* compiled from: P */
/* loaded from: classes12.dex */
public abstract class AbsBigEmotionUpdateAdapter extends BaseEmotionAdapter {
    static IPatchRedirector $redirector_;

    public AbsBigEmotionUpdateAdapter(IEmoticonMainPanelApp iEmoticonMainPanelApp, Context context, int i3, int i16, int i17, EmoticonCallback emoticonCallback) {
        super(iEmoticonMainPanelApp, context, i3, i16, i17, emoticonCallback);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, iEmoticonMainPanelApp, context, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), emoticonCallback);
        }
    }

    public RelativeLayout getBigEmotionContentViewLayout() {
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RelativeLayout) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        System.currentTimeMillis();
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(this.widthPixels / this.columnNum, (int) (this.density * 72.0f)));
        try {
            textView = new TextView(this.mContext);
        } catch (Exception unused) {
            textView = null;
        }
        if (textView != null) {
            textView.setVisibility(8);
            textView.setId(R.id.f6296329);
            textView.setTextColor(this.emoticonTextColor);
            textView.setTextSize(11.0f);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(12);
            layoutParams.topMargin = (int) (this.density * 5.0f);
            textView.setGravity(17);
            relativeLayout.addView(textView, layoutParams);
        }
        URLImageView uRLImageView = new URLImageView(this.mContext);
        uRLImageView.setId(R.id.f915355f);
        float f16 = this.density;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) (f16 * 56.0f), (int) (f16 * 56.0f));
        layoutParams2.addRule(13, -1);
        layoutParams2.addRule(2, R.id.f6296329);
        layoutParams2.addRule(14);
        uRLImageView.setVisibility(8);
        uRLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        uRLImageView.setAdjustViewBounds(false);
        relativeLayout.addView(uRLImageView, layoutParams2);
        ImageView imageView = new ImageView(this.mContext);
        imageView.setVisibility(8);
        imageView.setId(R.id.f629732_);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(7, R.id.f915355f);
        layoutParams3.addRule(8, R.id.f915355f);
        relativeLayout.addView(imageView, layoutParams3);
        if (AppSetting.f99565y) {
            relativeLayout.setFocusable(true);
        }
        return relativeLayout;
    }

    public void updateBigEmotionContentViewData(View view, EmotionPanelData emotionPanelData) {
        EmoticonInfo emoticonInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) emotionPanelData);
            return;
        }
        if (view != null && emotionPanelData != null) {
            view.setVisibility(0);
            if (emotionPanelData instanceof EmoticonInfo) {
                emoticonInfo = (EmoticonInfo) emotionPanelData;
            } else {
                emoticonInfo = null;
            }
            if (emoticonInfo == null) {
                QLog.e(BaseEmotionAdapter.TAG, 1, "emotionInfo = null");
                return;
            }
            view.setTag(emoticonInfo);
            URLImageView uRLImageView = (URLImageView) view.findViewById(R.id.f915355f);
            System.currentTimeMillis();
            uRLImageView.setImageDrawable(emoticonInfo.getDrawable(this.mContext, this.density));
            uRLImageView.setVisibility(0);
            if (emoticonInfo instanceof PicEmoticonInfo) {
                PicEmoticonInfo picEmoticonInfo = (PicEmoticonInfo) emoticonInfo;
                TextView textView = (TextView) view.findViewById(R.id.f6296329);
                Emoticon emoticon = picEmoticonInfo.emoticon;
                if (emoticon != null) {
                    String str = emoticon.name;
                    if (!TextUtils.isEmpty(str)) {
                        textView.setVisibility(0);
                        if (str.length() > 5) {
                            textView.setText(str.substring(0, 4) + MiniBoxNoticeInfo.APPNAME_SUFFIX);
                        } else {
                            textView.setText(str);
                        }
                    } else {
                        textView.setVisibility(8);
                    }
                }
                ImageView imageView = (ImageView) view.findViewById(R.id.f629732_);
                if (picEmoticonInfo.isSound()) {
                    if (picEmoticonInfo.isNewSoundType()) {
                        imageView.setImageResource(R.drawable.bft);
                    } else {
                        imageView.setImageResource(R.drawable.h29);
                    }
                    imageView.setVisibility(0);
                    return;
                }
                imageView.setVisibility(4);
            }
        }
    }
}
