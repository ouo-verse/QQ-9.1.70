package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.CameraEmoRoamingHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoAllSend;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoSingleSend;
import com.tencent.mobileqq.emoticon.IEmotionPanelDataCallback;
import com.tencent.mobileqq.emoticonview.BaseEmotionAdapter;
import com.tencent.mobileqq.emoticonview.IEmoticonPanelLinearLayoutHelper;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CameraEmoRoamingHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.CameraEmotionRoamingDBManagerServiceProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public class CameraEmotionAdapter extends BaseEmotionAdapter implements IEmotionPanelDataCallback<EmotionPanelData> {
    static IPatchRedirector $redirector_ = null;
    public static final int CONTENT_HEIGHT = 61;
    public static final int ERROR_ICON_HEIGHT_OFFSET = 5;
    public static final int GUIDE_HEIGHT = 199;
    public static final int GUIDE_IMG_HEIGHT = 127;
    public static final int GUIDE_IMG_WIDTH = 161;
    public static final int IMG_HEIGHT = 56;
    public static final String TAG = "CameraEmotionAdapter";
    private Drawable mCameraPanelFailedDrawable;
    private IPanelInteractionListener mInteractionListener;
    public IEmoticonPanelLinearLayoutHelper.OnClickListener mInterceptListener;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class CameraEmotionViewHolder extends BaseEmotionAdapter.ViewHolder {
        static IPatchRedirector $redirector_;
        RelativeLayout[] contentViews;

        public CameraEmotionViewHolder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public CameraEmotionAdapter(IEmoticonMainPanelApp iEmoticonMainPanelApp, IPanelInteractionListener iPanelInteractionListener, Context context, int i3, int i16, int i17, EmoticonCallback emoticonCallback) {
        super(iEmoticonMainPanelApp, context, i3, i16, i17, emoticonCallback);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, iEmoticonMainPanelApp, iPanelInteractionListener, context, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), emoticonCallback);
            return;
        }
        this.mCameraPanelFailedDrawable = null;
        this.mInterceptListener = new IEmoticonPanelLinearLayoutHelper.OnClickListener() { // from class: com.tencent.mobileqq.emoticonview.CameraEmotionAdapter.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) CameraEmotionAdapter.this);
                }
            }

            @Override // com.tencent.mobileqq.emoticonview.IEmoticonPanelLinearLayoutHelper.OnClickListener
            public boolean shouldInterceptClickEvent(View view, EmoticonInfo emoticonInfo) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view, (Object) emoticonInfo)).booleanValue();
                }
                if (emoticonInfo != null && view != null && TextUtils.isEmpty(emoticonInfo.action)) {
                    CameraEmoticonInfo cameraEmoticonInfo = (CameraEmoticonInfo) emoticonInfo;
                    if (!cameraEmoticonInfo.roamingType.equals("needUpload") && !cameraEmoticonInfo.roamingType.equals("needDel")) {
                        if (cameraEmoticonInfo.roamingType.equals("failed")) {
                            List<CameraEmotionData> emoticonDataList = ((CameraEmotionRoamingDBManagerServiceProxy) CameraEmotionAdapter.this.app.getRuntimeService(ICameraEmotionRoamingDBManagerService.class)).getEmoticonDataList();
                            if (emoticonDataList != null) {
                                for (CameraEmotionData cameraEmotionData : emoticonDataList) {
                                    int i18 = cameraEmotionData.emoId;
                                    if (i18 == cameraEmoticonInfo.emoId) {
                                        QLog.d(CameraEmotionAdapter.TAG, 1, "resend, emoId:", Integer.valueOf(i18));
                                        cameraEmotionData.RomaingType = "needUpload";
                                        cameraEmoticonInfo.roamingType = "needUpload";
                                        ((CameraEmoRoamingHandlerProxy) CameraEmotionAdapter.this.app.getBusinessHandler(CameraEmoRoamingHandler.f194459e)).notifyUI(4, true, null);
                                        CameraEmoAllSend.R = false;
                                        ThreadManagerV2.excute(new CameraEmoSingleSend(cameraEmotionData, true), 64, null, false);
                                    }
                                }
                            }
                            return true;
                        }
                        URLImageView uRLImageView = (URLImageView) view.findViewById(R.id.f915355f);
                        ImageView imageView = (ImageView) view.findViewById(R.id.f6295328);
                        if (!(uRLImageView.getBackground() instanceof URLDrawable)) {
                            return false;
                        }
                        URLDrawable uRLDrawable = (URLDrawable) uRLImageView.getBackground();
                        if (uRLDrawable.getStatus() != 3 && uRLDrawable.getStatus() != 2) {
                            if (uRLDrawable.getStatus() == 0) {
                                if (QLog.isColorLevel()) {
                                    QLog.i(CameraEmotionAdapter.TAG, 2, "now  cameraemo EmoticonInfo loading " + emoticonInfo.toString());
                                }
                                return true;
                            }
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.i(CameraEmotionAdapter.TAG, 2, "now  cameraemo EmoticonInfo loading failed, restart download " + emoticonInfo.toString());
                            }
                            uRLImageView.setVisibility(8);
                            imageView.setVisibility(0);
                            uRLDrawable.restartDownload();
                            if (!(imageView.getDrawable() instanceof Animatable)) {
                                imageView.setImageDrawable((Drawable) ((Animatable) view.getContext().getResources().getDrawable(R.drawable.f160545jt)));
                            }
                            ((Animatable) imageView.getDrawable()).start();
                        }
                    }
                    return true;
                }
                return false;
            }
        };
        this.mInteractionListener = iPanelInteractionListener;
        this.mCameraPanelFailedDrawable = context.getResources().getDrawable(R.drawable.njj);
    }

    private RelativeLayout getCameraEmoView() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getCameraEmoView");
        }
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(this.widthPixels / this.columnNum, (int) (this.density * 61.0f)));
        URLImageView uRLImageView = new URLImageView(this.mContext);
        uRLImageView.setId(R.id.f915355f);
        float f16 = this.density;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (f16 * 56.0f), (int) (f16 * 56.0f));
        layoutParams.addRule(13, -1);
        layoutParams.addRule(12, -1);
        layoutParams.setMargins(0, 0, 0, (int) (this.density * 5.0f));
        uRLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        uRLImageView.setAdjustViewBounds(false);
        relativeLayout.addView(uRLImageView, layoutParams);
        ImageView imageView = new ImageView(this.mContext);
        imageView.setId(R.id.f6295328);
        float f17 = this.density;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) (f17 * 56.0f), (int) (f17 * 56.0f));
        layoutParams2.addRule(13, -1);
        layoutParams2.addRule(12, -1);
        layoutParams2.setMargins(0, 0, 0, (int) (this.density * 5.0f));
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        imageView.setAdjustViewBounds(false);
        imageView.setVisibility(8);
        relativeLayout.addView(imageView, layoutParams2);
        ImageView imageView2 = new ImageView(this.mContext);
        imageView2.setId(R.id.f629732_);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        imageView2.setBackgroundResource(R.drawable.njg);
        layoutParams3.addRule(7, R.id.f915355f);
        layoutParams3.addRule(8, R.id.f915355f);
        float f18 = this.density;
        layoutParams3.setMargins(0, 0, (int) (f18 * (-5.0f)), (int) (f18 * (-5.0f)));
        relativeLayout.addView(imageView2, layoutParams3);
        imageView2.setVisibility(8);
        if (AppSetting.f99565y) {
            relativeLayout.setFocusable(true);
        }
        return relativeLayout;
    }

    private RelativeLayout getGuideView() {
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        int i3 = this.widthPixels;
        int i16 = this.columnNum;
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams((i3 / i16) * (i16 - 2), (int) (this.density * 199.0f)));
        URLImageView uRLImageView = new URLImageView(this.mContext);
        uRLImageView.setId(R.id.f915355f);
        float f16 = this.density;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (161.0f * f16), (int) (f16 * 127.0f));
        layoutParams.addRule(13, -1);
        uRLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        uRLImageView.setAdjustViewBounds(false);
        relativeLayout.addView(uRLImageView, layoutParams);
        TextView textView = new TextView(this.mContext);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        textView.setText(HardCodeUtil.qqStr(R.string.f208885dx));
        textView.setTextSize(ViewUtils.dpToPx(12.0f));
        textView.setTextColor(RichStatus.ACTION_COLOR_NORMAL);
        layoutParams2.addRule(14, -1);
        layoutParams2.addRule(3, R.id.f915355f);
        return relativeLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateEmoticonDrawable(URLImageView uRLImageView, ImageView imageView) {
        URLDrawable uRLDrawable = (URLDrawable) uRLImageView.getBackground();
        if (uRLDrawable.getStatus() == 0) {
            uRLImageView.setVisibility(8);
            imageView.setVisibility(0);
            if (!uRLDrawable.isDownloadStarted()) {
                uRLDrawable.startDownload();
            }
            if (!(imageView.getDrawable() instanceof Animatable)) {
                imageView.setImageDrawable((Drawable) ((Animatable) uRLImageView.getContext().getResources().getDrawable(R.drawable.f160545jt)));
            }
            Animatable animatable = (Animatable) imageView.getDrawable();
            if (!animatable.isRunning()) {
                animatable.start();
                return;
            }
            return;
        }
        if (uRLDrawable.getStatus() != 2 && uRLDrawable.getStatus() != 3) {
            uRLImageView.setVisibility(0);
            imageView.setVisibility(8);
            return;
        }
        uRLImageView.setVisibility(8);
        imageView.setVisibility(0);
        if (imageView.getDrawable() instanceof Animatable) {
            ((Animatable) imageView.getDrawable()).stop();
        }
        imageView.setImageDrawable(this.mCameraPanelFailedDrawable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void updateUI(View view, EmotionPanelData emotionPanelData) {
        if (view != null && (emotionPanelData instanceof CameraEmoticonInfo)) {
            URLImageView uRLImageView = (URLImageView) view.findViewById(R.id.f915355f);
            CameraEmoticonInfo cameraEmoticonInfo = (CameraEmoticonInfo) emotionPanelData;
            view.setTag(cameraEmoticonInfo);
            view.setVisibility(0);
            if (QLog.isColorLevel() && !StringUtil.isEmpty(cameraEmoticonInfo.action)) {
                QLog.d(TAG, 2, "updateUI info = " + cameraEmoticonInfo.action);
            }
            if (uRLImageView.getTag(R.id.f630332f) == emotionPanelData) {
                return;
            }
            uRLImageView.setTag(R.id.f630332f, emotionPanelData);
            ImageView imageView = (ImageView) view.findViewById(R.id.f6295328);
            ImageView imageView2 = (ImageView) view.findViewById(R.id.f629732_);
            uRLImageView.setVisibility(0);
            uRLImageView.setURLDrawableDownListener(null);
            if (EmoticonInfo.CAMERA_EDIT_ACTION.equals(cameraEmoticonInfo.action)) {
                uRLImageView.setImageDrawable(null);
                uRLImageView.setBackgroundResource(R.drawable.njl);
                imageView.setVisibility(4);
                imageView2.setVisibility(4);
                if (AppSetting.f99565y) {
                    uRLImageView.setContentDescription(HardCodeUtil.qqStr(R.string.f208895dy));
                    return;
                }
                return;
            }
            if (EmoticonInfo.CAMERA_JUMP_ACTION.equals(cameraEmoticonInfo.action)) {
                uRLImageView.setImageDrawable(null);
                uRLImageView.setBackgroundResource(R.drawable.hkx);
                imageView.setVisibility(4);
                imageView2.setVisibility(4);
                if (AppSetting.f99565y) {
                    uRLImageView.setContentDescription(HardCodeUtil.qqStr(R.string.f208905dz));
                    return;
                }
                return;
            }
            Drawable drawable = cameraEmoticonInfo.getDrawable(this.mContext, this.density);
            uRLImageView.setBackgroundDrawable(drawable);
            if (cameraEmoticonInfo.roamingType.equals("needUpload")) {
                uRLImageView.setImageDrawable(new ColorDrawable(-419430401));
                Animatable animatable = (Animatable) this.mContext.getResources().getDrawable(R.drawable.f160545jt);
                imageView.setImageDrawable((Drawable) animatable);
                animatable.start();
                imageView.setVisibility(0);
                imageView2.setVisibility(4);
            } else if (cameraEmoticonInfo.roamingType.equals("failed")) {
                uRLImageView.setImageDrawable(new ColorDrawable(-419430401));
                imageView.setVisibility(4);
                imageView2.setVisibility(0);
            } else {
                uRLImageView.setImageDrawable(null);
                imageView.setVisibility(4);
                imageView2.setVisibility(4);
                if (drawable instanceof URLDrawable) {
                    uRLImageView.setURLDrawableDownListener(new URLDrawableDownListener(cameraEmoticonInfo, uRLImageView, imageView) { // from class: com.tencent.mobileqq.emoticonview.CameraEmotionAdapter.2
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ URLImageView val$emoticonImg;
                        final /* synthetic */ CameraEmoticonInfo val$emotionInfo;
                        final /* synthetic */ ImageView val$progressView;

                        {
                            this.val$emotionInfo = cameraEmoticonInfo;
                            this.val$emoticonImg = uRLImageView;
                            this.val$progressView = imageView;
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, this, CameraEmotionAdapter.this, cameraEmoticonInfo, uRLImageView, imageView);
                            }
                        }

                        @Override // com.tencent.image.URLDrawableDownListener
                        public void onLoadCancelled(View view2, URLDrawable uRLDrawable) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                                iPatchRedirector.redirect((short) 4, (Object) this, (Object) view2, (Object) uRLDrawable);
                                return;
                            }
                            QLog.e(CameraEmotionAdapter.TAG, 1, "onLoadFailed: " + this.val$emotionInfo.toString());
                            CameraEmotionAdapter.this.updateEmoticonDrawable(this.val$emoticonImg, this.val$progressView);
                        }

                        @Override // com.tencent.image.URLDrawableDownListener
                        public void onLoadFailed(View view2, URLDrawable uRLDrawable, Throwable th5) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                                iPatchRedirector.redirect((short) 3, this, view2, uRLDrawable, th5);
                                return;
                            }
                            QLog.e(CameraEmotionAdapter.TAG, 1, "onLoadFailed: " + this.val$emotionInfo.toString());
                            CameraEmotionAdapter.this.updateEmoticonDrawable(this.val$emoticonImg, this.val$progressView);
                        }

                        @Override // com.tencent.image.URLDrawableDownListener
                        public void onLoadInterrupted(View view2, URLDrawable uRLDrawable, InterruptedException interruptedException) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                                iPatchRedirector.redirect((short) 5, this, view2, uRLDrawable, interruptedException);
                                return;
                            }
                            QLog.e(CameraEmotionAdapter.TAG, 1, "onLoadInterrupted: " + this.val$emotionInfo.toString());
                            CameraEmotionAdapter.this.updateEmoticonDrawable(this.val$emoticonImg, this.val$progressView);
                        }

                        @Override // com.tencent.image.URLDrawableDownListener
                        public void onLoadProgressed(View view2, URLDrawable uRLDrawable, int i3) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                                CameraEmotionAdapter.this.updateEmoticonDrawable(this.val$emoticonImg, this.val$progressView);
                            } else {
                                iPatchRedirector.redirect((short) 6, this, view2, uRLDrawable, Integer.valueOf(i3));
                            }
                        }

                        @Override // com.tencent.image.URLDrawableDownListener
                        public void onLoadSuccessed(View view2, URLDrawable uRLDrawable) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view2, (Object) uRLDrawable);
                                return;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.i(CameraEmotionAdapter.TAG, 2, "onLoadSuccessed: " + this.val$emotionInfo.toString());
                            }
                            CameraEmotionAdapter.this.updateEmoticonDrawable(this.val$emoticonImg, this.val$progressView);
                        }
                    });
                    updateEmoticonDrawable(uRLImageView, imageView);
                }
            }
            if (!TextUtils.isEmpty(cameraEmoticonInfo.eId)) {
                ReportController.o(this.app.getQQAppInterface(), "dc00898", "", "", "0X800A370", "0X800A370", 0, 0, "", "", cameraEmoticonInfo.eId, "");
                return;
            }
            return;
        }
        QLog.e(TAG, 1, "emotionInfo or contentView = null");
    }

    @Override // com.tencent.mobileqq.emoticon.IEmotionPanelDataCallback
    public void callbackInMainThread(List<EmotionPanelData> list) {
        Object valueOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
            return;
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("refreshPanelData call back dataList = ");
            if (list == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(list.size());
            }
            sb5.append(valueOf);
            QLog.d(TAG, 2, sb5.toString());
        }
        if (list != null) {
            setData(list);
            notifyDataSetChanged();
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public View getEmotionView(BaseEmotionAdapter.ViewHolder viewHolder, int i3, View view, ViewGroup viewGroup) {
        int i16;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, viewHolder, Integer.valueOf(i3), view, viewGroup);
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getEmotionView position = ");
            sb5.append(i3);
            sb5.append(" convertView NULL is ");
            if (view == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d(TAG, 2, sb5.toString());
        }
        CameraEmotionViewHolder cameraEmotionViewHolder = (CameraEmotionViewHolder) viewHolder;
        View view2 = view;
        if (view == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getEmotionView position = " + i3 + "; view from inflater");
            }
            EmoticonPanelLinearLayout emoticonPanelLinearLayout = new EmoticonPanelLinearLayout(this.mContext, new QQEmoticonPanelLinearLayoutHelper(this.mContext, this.mInteractionListener), -1);
            emoticonPanelLinearLayout.setPanelType(5);
            emoticonPanelLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
            emoticonPanelLinearLayout.setOrientation(0);
            if (i3 == 0) {
                i16 = 16;
            } else {
                i16 = 14;
            }
            emoticonPanelLinearLayout.setPadding(0, (int) (i16 * this.density), 0, 0);
            for (int i18 = 0; i18 < this.columnNum; i18++) {
                RelativeLayout cameraEmoView = getCameraEmoView();
                cameraEmoView.setVisibility(8);
                cameraEmoView.setFocusable(true);
                cameraEmoView.setFocusableInTouchMode(true);
                emoticonPanelLinearLayout.addView(cameraEmoView);
            }
            emoticonPanelLinearLayout.setInterceptListener(this.mInterceptListener);
            emoticonPanelLinearLayout.setCallBack(this.callback);
            cameraEmotionViewHolder.contentViews = new RelativeLayout[this.columnNum];
            for (int i19 = 0; i19 < this.columnNum; i19++) {
                cameraEmotionViewHolder.contentViews[i19] = (RelativeLayout) emoticonPanelLinearLayout.getChildAt(i19);
            }
            emoticonPanelLinearLayout.setTag(cameraEmotionViewHolder);
            view2 = emoticonPanelLinearLayout;
        }
        while (true) {
            int i26 = this.columnNum;
            if (i17 < i26) {
                int i27 = (i26 * i3) + i17;
                if (i27 > this.data.size() - 1) {
                    cameraEmotionViewHolder.contentViews[i17].setTag(null);
                    cameraEmotionViewHolder.contentViews[i17].setVisibility(8);
                } else {
                    updateUI(cameraEmotionViewHolder.contentViews[i17], this.data.get(i27));
                }
                i17++;
            } else {
                return view2;
            }
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public BaseEmotionAdapter.ViewHolder newHolder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (BaseEmotionAdapter.ViewHolder) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new CameraEmotionViewHolder();
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public void refreshPanelData() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "refreshPanelData");
        }
        IPanelInteractionListener iPanelInteractionListener = this.mInteractionListener;
        if (iPanelInteractionListener != null) {
            i3 = iPanelInteractionListener.getCurType();
        } else {
            i3 = -1;
        }
        EmotionPanelDataBuilder.getInstance().asyncGetEmotionPanelData(this.app, this.panelType, null, -1, i3, false, this, true, true);
    }
}
