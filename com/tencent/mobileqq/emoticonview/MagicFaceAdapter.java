package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.IEmotionPanelDataCallback;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.BaseEmotionAdapter;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerServiceProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.EmotionConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.util.MqqWeakReferenceHandler;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes12.dex */
public class MagicFaceAdapter extends EmotionNeedDownloadAdapter implements Handler.Callback, IEmotionPanelDataCallback<EmotionPanelData> {
    static IPatchRedirector $redirector_ = null;
    public static final int CONTENT_HIGHT = 72;
    public static final int IMG_HEIGHT = 56;
    public static final String MAGIC_GRAY_PIC = "_panel_magic_gray";
    private static final int MSG_DOWNLOAD_END = 101;
    private static final int MSG_DOWNLOAD_START = 100;
    private static final int SIZE_BIG_EMOTICON = 63;
    public static final String TAG = "MagicFaceAdapter";
    private MqqHandler mUiHandler;
    List<ProgressBar> proBars;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class MagicFaceViewHolder extends BaseEmotionAdapter.ViewHolder {
        static IPatchRedirector $redirector_;
        RelativeLayout[] contentViews;

        public MagicFaceViewHolder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public MagicFaceAdapter(IEmoticonMainPanelApp iEmoticonMainPanelApp, Context context, int i3, int i16, int i17, EmoticonCallback emoticonCallback) {
        super(iEmoticonMainPanelApp, context, i3, i16, i17, emoticonCallback);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, iEmoticonMainPanelApp, context, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), emoticonCallback);
        } else {
            this.mUiHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
            this.proBars = new ArrayList();
        }
    }

    private RelativeLayout getMagicView() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getMagicView");
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(this.widthPixels / this.columnNum, (int) (this.density * 72.0f)));
        URLImageView uRLImageView = new URLImageView(this.mContext);
        uRLImageView.setId(R.id.f915355f);
        float f16 = this.density;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (f16 * 56.0f), (int) (f16 * 56.0f));
        layoutParams.addRule(10, -1);
        layoutParams.addRule(14, -1);
        uRLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        uRLImageView.setAdjustViewBounds(false);
        uRLImageView.setLayoutParams(layoutParams);
        relativeLayout.addView(uRLImageView);
        TextView textView = new TextView(this.mContext);
        textView.setVisibility(8);
        textView.setId(R.id.f6296329);
        textView.setTextSize(11.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(3, R.id.f915355f);
        layoutParams2.topMargin = (int) (this.density * 5.0f);
        layoutParams2.addRule(14, -1);
        relativeLayout.addView(textView, layoutParams2);
        ImageView imageView = new ImageView(this.mContext);
        imageView.setVisibility(8);
        imageView.setId(R.id.f629732_);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(8, R.id.f915355f);
        layoutParams3.addRule(7, R.id.f915355f);
        relativeLayout.addView(imageView, layoutParams3);
        View imageView2 = new ImageView(this.mContext);
        imageView2.setId(R.id.bv7);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(5, R.id.f915355f);
        layoutParams4.addRule(6, R.id.f915355f);
        ProgressBar progressBar = new ProgressBar(this.mContext);
        progressBar.setVisibility(8);
        progressBar.setId(R.id.f165077bv4);
        progressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(R.drawable.f160545jt));
        float f17 = this.density;
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) (f17 * 16.0f), (int) (f17 * 16.0f));
        layoutParams5.addRule(14, -1);
        layoutParams5.topMargin = (int) (this.density * 20.0f);
        relativeLayout.addView(progressBar, layoutParams5);
        relativeLayout.addView(imageView2, layoutParams4);
        if (AppSetting.f99565y) {
            relativeLayout.setFocusable(true);
        }
        return relativeLayout;
    }

    private ProgressBar getProgressBarByEp(EmoticonPackage emoticonPackage) {
        List<ProgressBar> list;
        String str;
        if (emoticonPackage != null && !TextUtils.isEmpty(emoticonPackage.epId) && (list = this.proBars) != null && list.size() > 0) {
            for (ProgressBar progressBar : this.proBars) {
                Object tag = progressBar.getTag();
                if (tag instanceof String) {
                    str = (String) tag;
                } else {
                    str = null;
                }
                if (!TextUtils.isEmpty(str) && emoticonPackage.epId.equals(str)) {
                    return progressBar;
                }
            }
        }
        return null;
    }

    private void updateImageView(URLImageView uRLImageView, PicEmoticonInfo picEmoticonInfo) {
        URL url;
        URLDrawable uRLDrawable;
        String string;
        if (uRLImageView != null && picEmoticonInfo != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) uRLImageView.getLayoutParams();
            if ("push".equals(picEmoticonInfo.action)) {
                float f16 = this.density;
                layoutParams.width = (int) (f16 * 63.0f);
                layoutParams.height = (int) (f16 * 63.0f);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "show push_btn drawable.");
                }
                SharedPreferences sharedPreferences = this.mContext.getSharedPreferences("mobileQQ", 0);
                boolean z16 = sharedPreferences.getBoolean("magic_promotion_is_new_content_" + this.app.getCurrentAccountUin(), false);
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mLoadingDrawable = this.mContext.getResources().getDrawable(R.drawable.fnm);
                if (z16) {
                    string = sharedPreferences.getString("magic_promotion_gifUrl", "");
                    obtain.mPlayGifImage = true;
                } else {
                    string = sharedPreferences.getString("magic_promotion_imgUrl", "");
                }
                if (!TextUtils.isEmpty(string)) {
                    try {
                        uRLImageView.setImageDrawable(URLDrawable.getDrawable(string, obtain));
                    } catch (IllegalArgumentException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.w(TAG, 2, e16.getMessage());
                        }
                        uRLImageView.setImageDrawable(null);
                    }
                } else {
                    uRLImageView.setImageDrawable(null);
                }
                if (AppSetting.f99565y) {
                    uRLImageView.setContentDescription(this.mContext.getString(R.string.f209245ew));
                    return;
                }
                return;
            }
            Emoticon emoticon = picEmoticonInfo.emoticon;
            if (emoticon != null && !TextUtils.isEmpty(emoticon.epId)) {
                EmoticonPackage syncFindEmoticonPackageById = ((EmoticonManagerServiceProxy) this.app.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonPackageById(emoticon.epId);
                String str = emoticon.epId + "_" + emoticon.eId;
                if (syncFindEmoticonPackageById != null && ((!syncFindEmoticonPackageById.valid || 2 != syncFindEmoticonPackageById.status) && !picEmoticonInfo.isDownLoad)) {
                    str = str + MAGIC_GRAY_PIC;
                }
                try {
                    url = new URL(EmotionConstants.PROTOCOL_EMOTION_PIC, EmotionConstants.FROM_PANEL, str);
                } catch (MalformedURLException e17) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "updateImageView ,", e17);
                    }
                    url = null;
                }
                if (url != null) {
                    URLDrawable.URLDrawableOptions obtain2 = URLDrawable.URLDrawableOptions.obtain();
                    obtain2.mLoadingDrawable = this.mContext.getResources().getDrawable(R.drawable.c0i);
                    obtain2.mFailedDrawable = this.mContext.getResources().getDrawable(R.drawable.o4e);
                    uRLDrawable = URLDrawable.getDrawable(url, obtain2);
                    uRLDrawable.setTag(emoticon);
                    uRLDrawable.addHeader("my_uin", this.app.getCurrentAccountUin());
                } else {
                    uRLDrawable = null;
                }
                if (uRLDrawable != null) {
                    uRLImageView.setImageDrawable(uRLDrawable);
                } else {
                    uRLImageView.setVisibility(4);
                }
                uRLImageView.setBackgroundDrawable(null);
                return;
            }
            QLog.e(TAG, 1, "updateImageView emotion is null or epid is null");
            return;
        }
        QLog.e(TAG, 1, "updateImageView view or info = null");
    }

    private void updateUI(View view, EmotionPanelData emotionPanelData) {
        PicEmoticonInfo picEmoticonInfo;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateUI");
        }
        if (view != null && emotionPanelData != null) {
            if (emotionPanelData instanceof EmoticonInfo) {
                picEmoticonInfo = (PicEmoticonInfo) emotionPanelData;
            } else {
                picEmoticonInfo = null;
            }
            boolean z16 = true;
            if (picEmoticonInfo == null) {
                QLog.e(TAG, 1, "updateUI emotionInfo = null");
                return;
            }
            view.setVisibility(0);
            view.setTag(picEmoticonInfo);
            URLImageView uRLImageView = (URLImageView) view.findViewById(R.id.f915355f);
            uRLImageView.setVisibility(0);
            updateImageView(uRLImageView, picEmoticonInfo);
            TextView textView = (TextView) view.findViewById(R.id.f6296329);
            ImageView imageView = (ImageView) view.findViewById(R.id.bv7);
            ImageView imageView2 = (ImageView) view.findViewById(R.id.f629732_);
            ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.f165077bv4);
            if ("push".equals(picEmoticonInfo.action)) {
                textView.setVisibility(8);
                imageView.setVisibility(8);
                imageView2.setVisibility(8);
                progressBar.setVisibility(8);
                return;
            }
            Emoticon emoticon = picEmoticonInfo.emoticon;
            if (emoticon != null && !TextUtils.isEmpty(emoticon.epId)) {
                String str = emoticon.name;
                if (!TextUtils.isEmpty(str)) {
                    textView.setVisibility(0);
                    if (str.length() > 5) {
                        textView.setText(str.substring(0, 4) + MiniBoxNoticeInfo.APPNAME_SUFFIX);
                    } else {
                        textView.setText(str);
                    }
                    if (AppSetting.f99565y) {
                        textView.setContentDescription(str);
                    }
                } else {
                    textView.setVisibility(8);
                }
                imageView.setVisibility(8);
                imageView2.setVisibility(8);
                EmoticonPackage syncFindEmoticonPackageById = ((EmoticonManagerServiceProxy) this.app.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonPackageById(emoticon.epId);
                if (syncFindEmoticonPackageById != null && !syncFindEmoticonPackageById.valid) {
                    imageView2.setImageResource(R.drawable.njn);
                    imageView2.setVisibility(0);
                }
                progressBar.setVisibility(8);
                progressBar.setTag(emoticon.epId);
                if (!this.proBars.contains(progressBar)) {
                    this.proBars.add(progressBar);
                }
                if (((EmojiManagerServiceProxy) this.app.getRuntimeService(IEmojiManagerService.class)).getEmoticonPackageLoadingProgress(emoticon.epId) < 0.0f) {
                    z16 = false;
                }
                if (z16) {
                    progressBar.setVisibility(0);
                    return;
                } else {
                    progressBar.setVisibility(8);
                    return;
                }
            }
            QLog.e(TAG, 1, "updateUI emotion is null or epid is null");
        }
    }

    @Override // com.tencent.mobileqq.emoticon.IEmotionPanelDataCallback
    public void callbackInMainThread(List<EmotionPanelData> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) list);
        } else if (list != null) {
            setData(list);
            notifyDataSetChanged();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v3, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r13v4, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r13v6, types: [android.widget.LinearLayout, android.view.View, android.view.ViewGroup, com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout] */
    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public View getEmotionView(BaseEmotionAdapter.ViewHolder viewHolder, int i3, View view, ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, viewHolder, Integer.valueOf(i3), view, viewGroup);
        }
        MagicFaceViewHolder magicFaceViewHolder = (MagicFaceViewHolder) viewHolder;
        View view2 = view;
        if (view == null) {
            EmoticonPanelLinearLayout view3 = EmotionPanelViewPool.getInstance().getView(this.panelType);
            if (view3 == 0) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getEmotionView position = " + i3 + ";view from infalter");
                }
                view3 = new EmoticonPanelLinearLayout(this.mContext, new QQEmoticonPanelLinearLayoutHelper(this.mContext, null));
                view3.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                view3.setOrientation(0);
                if (i3 == 0) {
                    view3.setPadding(0, (int) (this.density * 16.0f), 0, 0);
                } else {
                    view3.setPadding(0, (int) (this.density * 14.0f), 0, 0);
                }
                for (int i17 = 0; i17 < this.columnNum; i17++) {
                    RelativeLayout magicView = getMagicView();
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.widthPixels / this.columnNum, -1);
                    magicView.setGravity(17);
                    magicView.setVisibility(8);
                    magicView.setLayoutParams(layoutParams);
                    magicView.setFocusable(true);
                    magicView.setFocusableInTouchMode(true);
                    view3.addView(magicView);
                }
            } else if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getEmotionView position = " + i3 + ";view from cache");
            }
            view3.setCallBack(this.callback);
            recycleView(this.panelType, view3);
            ViewGroup viewGroup2 = view3;
            magicFaceViewHolder.contentViews = new RelativeLayout[this.columnNum];
            for (int i18 = 0; i18 < this.columnNum; i18++) {
                magicFaceViewHolder.contentViews[i18] = (RelativeLayout) viewGroup2.getChildAt(i18);
            }
            view3.setTag(magicFaceViewHolder);
            view2 = view3;
        }
        while (true) {
            try {
                int i19 = this.columnNum;
                if (i16 >= i19) {
                    break;
                }
                int i26 = (i19 * i3) + i16;
                if (i26 > this.data.size() - 1) {
                    magicFaceViewHolder.contentViews[i16].setTag(null);
                    magicFaceViewHolder.contentViews[i16].setVisibility(8);
                } else {
                    updateUI(magicFaceViewHolder.contentViews[i16], this.data.get(i26));
                }
                i16++;
            } catch (OutOfMemoryError unused) {
                QLog.e(TAG, 1, "updateUI oom");
            }
        }
        return view2;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 100) {
            if (i3 == 101) {
                ProgressBar progressBarByEp = getProgressBarByEp((EmoticonPackage) message.obj);
                int i16 = message.arg1;
                if (progressBarByEp != null) {
                    progressBarByEp.setVisibility(8);
                    if (i16 == 0) {
                        refreshPanelData();
                        return true;
                    }
                    return true;
                }
                return true;
            }
            return true;
        }
        ProgressBar progressBarByEp2 = getProgressBarByEp((EmoticonPackage) message.obj);
        if (progressBarByEp2 != null) {
            progressBarByEp2.setVisibility(0);
            return true;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public BaseEmotionAdapter.ViewHolder newHolder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BaseEmotionAdapter.ViewHolder) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new MagicFaceViewHolder();
    }

    @Override // com.tencent.mobileqq.emoticonview.EmotionNeedDownloadAdapter
    public void packageDownloadEnd(EmoticonPackage emoticonPackage, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) emoticonPackage, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "packageDownloadEnd");
        }
        if (emoticonPackage == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 101;
        obtain.arg1 = i3;
        obtain.obj = emoticonPackage;
        this.mUiHandler.sendMessage(obtain);
    }

    @Override // com.tencent.mobileqq.emoticonview.EmotionNeedDownloadAdapter
    public void packageDownloadStart(EmoticonPackage emoticonPackage) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) emoticonPackage);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "packageDownloadStart");
        }
        if (emoticonPackage == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 100;
        obtain.obj = emoticonPackage;
        this.mUiHandler.sendMessage(obtain);
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public void refreshPanelData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "refreshPanelData");
        }
        EmotionPanelDataBuilder.getInstance().asyncGetEmotionPanelData(this.app, this.panelType, null, -1, 0, false, this, true, true);
    }
}
