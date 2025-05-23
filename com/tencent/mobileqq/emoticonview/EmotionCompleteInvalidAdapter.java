package com.tencent.mobileqq.emoticonview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.BaseEmotionAdapter;
import com.tencent.mobileqq.emoticonview.api.IBigEmotionService;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.emoticonview.ipc.proxy.MqqHandlerProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.XPanelContainer;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EmotionCompleteInvalidAdapter extends EmotionNeedDownloadAdapter implements View.OnClickListener, Handler.Callback {
    static IPatchRedirector $redirector_ = null;
    private static final int MSG_PAYBACK = 100;
    public static final String TAG = "EmotionCompleteInvalidAdapter";
    public static final int TYPE_SVIP = 2;
    public static final int TYPE_VIP = 1;
    protected int contentHight;
    protected int emotionFeeType;
    protected EmoticonPackage emotionPkg;
    protected IPanelInteractionListener interactionListener;
    private boolean isSmallEmotion;
    private MqqHandler mUiHandler;
    protected LinearLayout maskLayout;
    protected Button openBtn;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class EmotionCompletedInvalidViewHolder extends BaseEmotionAdapter.ViewHolder {
        static IPatchRedirector $redirector_;
        public Button downloadBtn;
        public LinearLayout maskLayout;
        public EmotionInvalidPanelLinearLayout panelLiearlayout;
        public TextView tips;

        public EmotionCompletedInvalidViewHolder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public EmotionCompleteInvalidAdapter(IEmoticonMainPanelApp iEmoticonMainPanelApp, IPanelInteractionListener iPanelInteractionListener, Context context, int i3, int i16, int i17, EmoticonPackage emoticonPackage, EmoticonCallback emoticonCallback) {
        super(iEmoticonMainPanelApp, context, i3, i16, i17, emoticonCallback);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, iEmoticonMainPanelApp, iPanelInteractionListener, context, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), emoticonPackage, emoticonCallback);
            return;
        }
        this.mUiHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
        this.emotionPkg = emoticonPackage;
        this.interactionListener = iPanelInteractionListener;
        this.isSmallEmotion = emoticonPackage.jobType == 4;
        if (emoticonPackage.mobileFeetype == 4) {
            this.emotionFeeType = 1;
        } else {
            this.emotionFeeType = 2;
        }
    }

    private LinearLayout getMaskLayout(EmotionCompletedInvalidViewHolder emotionCompletedInvalidViewHolder) {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-16777216);
        linearLayout.getBackground().setAlpha(178);
        linearLayout.setGravity(16);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, this.contentHight));
        TextView textView = new TextView(this.mContext);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        textView.setGravity(1);
        linearLayout.addView(textView, layoutParams);
        Button button = new Button(this.mContext);
        button.setId(R.id.f164944bd3);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, (int) (this.density * 25.0f));
        button.setGravity(17);
        layoutParams2.topMargin = (int) (this.density * 10.0f);
        layoutParams2.gravity = 1;
        button.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.f160506il));
        button.setTextColor(-14894864);
        float f16 = this.density;
        button.setPadding((int) (f16 * 30.0f), 0, (int) (f16 * 30.0f), 0);
        linearLayout.addView(button, layoutParams2);
        emotionCompletedInvalidViewHolder.maskLayout = linearLayout;
        emotionCompletedInvalidViewHolder.tips = textView;
        emotionCompletedInvalidViewHolder.downloadBtn = button;
        return linearLayout;
    }

    private void initContentHeight() {
        if (this.contentHight == 0 && this.interactionListener != null) {
            if (getCurrentListView() != null) {
                int height = getCurrentListView().getHeight();
                this.contentHight = height;
                if (height == 0) {
                    this.contentHight = XPanelContainer.f384714h0 - ((int) this.mContext.getResources().getDimension(R.dimen.f158749nw));
                    return;
                }
                return;
            }
            this.contentHight = XPanelContainer.f384714h0 - ((int) this.mContext.getResources().getDimension(R.dimen.f158749nw));
        }
    }

    private void updateUI(View view, EmotionPanelData emotionPanelData) {
        EmoticonInfo emoticonInfo;
        if (view != null && emotionPanelData != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "updateUI");
            }
            if (this.isSmallEmotion) {
                view.setVisibility(0);
                if (emotionPanelData instanceof EmoticonInfo) {
                    emoticonInfo = (EmoticonInfo) emotionPanelData;
                } else {
                    emoticonInfo = null;
                }
                if (emoticonInfo == null) {
                    QLog.e(TAG, 1, "updateUI emotionInfo = null");
                    return;
                }
                URLImageView uRLImageView = (URLImageView) view.findViewById(R.id.f915355f);
                uRLImageView.setImageDrawable(emoticonInfo.getDrawable(this.mContext, this.density));
                uRLImageView.setVisibility(0);
                return;
            }
            super.updateBigEmotionContentViewData(view, emotionPanelData);
            return;
        }
        QLog.e(TAG, 1, "updateUI contentView or info = null");
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter, android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public EmoticonPackage getEmoticonPackage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (EmoticonPackage) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.emotionPkg;
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public View getEmotionView(BaseEmotionAdapter.ViewHolder viewHolder, int i3, View view, ViewGroup viewGroup) {
        View view2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, this, viewHolder, Integer.valueOf(i3), view, viewGroup);
        }
        EmotionCompletedInvalidViewHolder emotionCompletedInvalidViewHolder = (EmotionCompletedInvalidViewHolder) viewHolder;
        View view3 = view;
        if (view == null) {
            initContentHeight();
            FrameLayout frameLayout = new FrameLayout(this.mContext);
            LinearLayout maskLayout = getMaskLayout(emotionCompletedInvalidViewHolder);
            if (this.isSmallEmotion) {
                view2 = EmotionPanelViewPool.getInstance().getView(11);
                if (view2 == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "getEmotionView smallemotion view from inflater");
                    }
                    view2 = new EmotionInvalidPanelLinearLayout(this.mContext, this.emotionPkg, 7, this.columnNum);
                } else if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getEmotionView smallemotion view from cache");
                }
            } else {
                View view4 = EmotionPanelViewPool.getInstance().getView(10);
                if (view4 == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "getEmotionView positon = " + i3 + ";bigemotion view from inflater");
                    }
                    view2 = new EmotionInvalidPanelLinearLayout(this.mContext, this.emotionPkg, 4, this.columnNum);
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "getEmotionView positon = " + i3 + ";bigemotion view from cache");
                    }
                    view2 = view4;
                }
            }
            if (this.isSmallEmotion) {
                recycleView(11, view2);
            } else {
                recycleView(10, view2);
            }
            frameLayout.addView(view2, new FrameLayout.LayoutParams(-1, this.contentHight));
            frameLayout.addView(maskLayout);
            emotionCompletedInvalidViewHolder.panelLiearlayout = (EmotionInvalidPanelLinearLayout) view2;
            frameLayout.setTag(emotionCompletedInvalidViewHolder);
            view3 = frameLayout;
        }
        this.openBtn = emotionCompletedInvalidViewHolder.downloadBtn;
        this.maskLayout = emotionCompletedInvalidViewHolder.maskLayout;
        String string = this.mContext.getString(R.string.f209275ez);
        String string2 = this.mContext.getString(R.string.f209555fq);
        if (this.emotionFeeType == 2) {
            string2 = this.mContext.getString(R.string.f209435fe);
        }
        String str = this.mContext.getString(R.string.f209455fg) + string2 + "\u4e13\u4eab,\n\u5f00\u901a" + string2 + this.mContext.getString(R.string.f209565fr);
        int i16 = this.emotionPkg.mobileFeetype;
        if (i16 == 6) {
            str = this.mContext.getString(R.string.f209025ea);
            string = this.mContext.getString(R.string.f209525fn);
        } else if (i16 == 2) {
            str = this.mContext.getString(R.string.f208875dw);
            string = this.mContext.getString(R.string.f209525fn);
        } else if (i16 == 3) {
            str = this.mContext.getString(R.string.f209205es);
            string = this.mContext.getString(R.string.f209525fn);
        }
        emotionCompletedInvalidViewHolder.tips.setText(str);
        emotionCompletedInvalidViewHolder.downloadBtn.setText(string);
        emotionCompletedInvalidViewHolder.downloadBtn.setOnClickListener(this);
        EmotionInvalidPanelLinearLayout emotionInvalidPanelLinearLayout = emotionCompletedInvalidViewHolder.panelLiearlayout;
        int childCount = emotionInvalidPanelLinearLayout.getChildCount();
        boolean z16 = false;
        int i17 = 0;
        for (int i18 = 0; i18 < childCount; i18++) {
            LinearLayout linearLayout = (LinearLayout) emotionInvalidPanelLinearLayout.getChildAt(i18);
            if (z16) {
                linearLayout.setVisibility(8);
            } else {
                int childCount2 = linearLayout.getChildCount();
                for (int i19 = 0; i19 < childCount2; i19++) {
                    View childAt = linearLayout.getChildAt(i19);
                    if (i17 > this.data.size() - 1) {
                        childAt.setVisibility(8);
                        z16 = true;
                    } else {
                        childAt.setVisibility(0);
                        updateUI(childAt, this.data.get(i17));
                        i17++;
                    }
                }
            }
        }
        return view3;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what == 100) {
            LinearLayout linearLayout = this.maskLayout;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            MqqHandlerProxy mqqHandlerProxy = (MqqHandlerProxy) this.app.getHandler(((IEmosmService) QRoute.api(IEmosmService.class)).getChatActivityClass());
            if (mqqHandlerProxy != null) {
                mqqHandlerProxy.sendToTarget(43);
                return true;
            }
            return true;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public BaseEmotionAdapter.ViewHolder newHolder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (BaseEmotionAdapter.ViewHolder) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return new EmotionCompletedInvalidViewHolder();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) view);
        } else if (view.getId() == R.id.f164944bd3) {
            EmoticonPackage emoticonPackage = this.emotionPkg;
            boolean z16 = true;
            if (emoticonPackage == null) {
                QLog.e(TAG, 1, "onClick EP = NULL");
            } else {
                int i3 = emoticonPackage.mobileFeetype;
                if (i3 != 4 && i3 != 5) {
                    if (!emoticonPackage.valid) {
                        if (emoticonPackage.jobType != 4) {
                            z16 = false;
                        }
                        IBigEmotionService iBigEmotionService = (IBigEmotionService) QRoute.api(IBigEmotionService.class);
                        Context context = this.mContext;
                        IEmoticonMainPanelApp iEmoticonMainPanelApp = this.app;
                        iBigEmotionService.openEmojiDetailPage(context, iEmoticonMainPanelApp, iEmoticonMainPanelApp.getAccount(), 0, String.valueOf(this.emotionPkg.epId), false, null, z16);
                    }
                } else {
                    String str2 = "mvip.gexinghua.android.sbp_" + this.emotionPkg.epId;
                    if (this.emotionPkg.mobileFeetype == 5) {
                        str = "!svip";
                    } else {
                        str = "!vip";
                    }
                    String str3 = "https://mc.vip.qq.com/qqwallet/index?aid=" + str2 + "&type=" + str + "&send=0&return_url=jsbridge://qw_charge/emojiPayResultOk";
                    if (this.mContext instanceof Activity) {
                        Intent intent = new Intent();
                        intent.putExtra("url", str3);
                        RouteUtils.startActivityForResult((Activity) this.mContext, intent, RouterConstants.UI_ROUTE_BROWSER, 4813);
                    }
                    if (!this.isSmallEmotion) {
                        ReportController.o(this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X80057B3", 0, 0, this.emotionPkg.epId, "", "", "");
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.emoticonview.EmotionNeedDownloadAdapter
    public void payBack(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "payBack");
        }
        if (18 == i3) {
            this.mUiHandler.sendEmptyMessage(100);
        }
    }
}
