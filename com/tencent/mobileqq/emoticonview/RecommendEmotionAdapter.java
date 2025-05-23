package com.tencent.mobileqq.emoticonview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.PromotionEmoticonPkg;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.BaseEmotionAdapter;
import com.tencent.mobileqq.emoticonview.QueryTask;
import com.tencent.mobileqq.emoticonview.api.IRecommendEmotionService;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmojiManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonHandlerProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.EmoticonManagerServiceProxy;
import com.tencent.mobileqq.emoticonview.ipc.proxy.SVIPHandlerProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandlerProxy;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateConstants;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.ProgressButton;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes12.dex */
public class RecommendEmotionAdapter extends EmotionNeedDownloadAdapter implements View.OnClickListener, Handler.Callback {
    static IPatchRedirector $redirector_ = null;
    public static final int CONTENT_HEIGHT = 148;
    public static final int IMG_HEIGHT = 85;
    public static final int MSG_DOWNLOAD_END = 101;
    public static final int MSG_REFRESH_PROGRESS = 100;
    public static final int MSG_SHOW_RECOMMEND_EFFECT = 102;
    public static final String TAG = "RecommendEmotionAdapter";
    protected List<ProgressButton> btns;
    private int businessType;
    protected ProgressButton clickPayBtn;
    protected int contentWidth;
    private List<PromotionEmoticonPkg> invisiableExposeList;
    boolean isRedWhenClickRecommend;
    boolean kandianBiu;
    public AtomicBoolean mDownloadEffect;
    public Object mEffectLock;
    private Drawable mLoadingDrawable;
    private boolean mNeedShowRedEffect;
    public ArrayList<Integer> mShowedEffectList;
    private final int mTotalEffectNum;
    public MqqHandler mUiHandler;
    public ArrayList<RecommendEffectHolder> mWaitToShowList;
    protected List<ImageView> reds;
    private List<PromotionEmoticonPkg> visiableExposeList;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class RecommendEffectHolder {
        static IPatchRedirector $redirector_;
        View contentView;
        File effectFile;
        int index;
        boolean isShow;
        PromotionEmoticonPkg recommendPkg;

        RecommendEffectHolder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) RecommendEmotionAdapter.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class RecommendEmotionViewHolder extends BaseEmotionAdapter.ViewHolder {
        static IPatchRedirector $redirector_;
        public LinearLayout[] contentViews;

        public RecommendEmotionViewHolder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public RecommendEmotionAdapter(IEmoticonMainPanelApp iEmoticonMainPanelApp, Context context, int i3, int i16, int i17, EmoticonCallback emoticonCallback, int i18, boolean z16) {
        super(iEmoticonMainPanelApp, context, i3, i16, i17, emoticonCallback);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, iEmoticonMainPanelApp, context, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), emoticonCallback, Integer.valueOf(i18), Boolean.valueOf(z16));
            return;
        }
        this.mTotalEffectNum = 2;
        this.mEffectLock = new Object();
        this.mDownloadEffect = new AtomicBoolean(false);
        this.kandianBiu = false;
        this.mUiHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
        this.businessType = i18;
        this.btns = new ArrayList();
        this.reds = new ArrayList();
        this.invisiableExposeList = new ArrayList();
        this.visiableExposeList = new ArrayList();
        SharedPreferences sharedPreferences = iEmoticonMainPanelApp.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0);
        this.mNeedShowRedEffect = sharedPreferences.getBoolean("recommemd_red_effect", false);
        this.isRedWhenClickRecommend = sharedPreferences.getBoolean("is_red_when_click_recommend", false);
        this.kandianBiu = z16;
    }

    private LinearLayout getEmotionLayout() {
        LinearLayout linearLayout = new LinearLayout(this.mContext);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.contentWidth, (int) (this.density * 148.0f));
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        RelativeLayout relativeLayout = new RelativeLayout(this.mContext);
        float f16 = this.density;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams((int) (f16 * 85.0f), (int) (f16 * 85.0f));
        layoutParams2.gravity = 1;
        relativeLayout.setId(R.id.f166663h30);
        URLImageView uRLImageView = new URLImageView(this.mContext);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
        uRLImageView.setId(R.id.f630032c);
        uRLImageView.setAdjustViewBounds(true);
        relativeLayout.addView(uRLImageView, layoutParams3);
        URLImageView uRLImageView2 = new URLImageView(this.mContext);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
        uRLImageView2.setId(R.id.f629932b);
        uRLImageView2.setAdjustViewBounds(true);
        relativeLayout.addView(uRLImageView2, layoutParams4);
        uRLImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        ImageView imageView = new ImageView(this.mContext);
        int i3 = -2;
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        imageView.setId(R.id.f166664h31);
        layoutParams5.addRule(10, -1);
        layoutParams5.addRule(11, -1);
        imageView.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.skin_tips_dot));
        relativeLayout.addView(imageView, layoutParams5);
        linearLayout.addView(relativeLayout, layoutParams2);
        TextView textView = new TextView(this.mContext);
        textView.setId(R.id.f630132d);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, (int) (this.density * 18.0f));
        layoutParams6.gravity = 1;
        layoutParams6.topMargin = (int) (this.density * 10.0f);
        textView.setTextSize(15.0f);
        textView.setTextColor(-16777216);
        textView.setGravity(17);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        linearLayout.addView(textView, layoutParams6);
        ProgressButton progressButton = new ProgressButton(this.mContext);
        progressButton.setId(R.id.f629832a);
        if (this.app.getQQAppInterface() == null) {
            i3 = (int) (this.density * 60.0f);
        }
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(i3, (int) (this.density * 25.0f));
        layoutParams7.topMargin = (int) (this.density * 10.0f);
        layoutParams7.gravity = 1;
        progressButton.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.f160506il));
        progressButton.setTextColor(-14894864);
        float f17 = this.density;
        progressButton.setPadding((int) (f17 * 15.0f), 0, (int) (f17 * 15.0f), 0);
        progressButton.setEllipsize(TextUtils.TruncateAt.END);
        progressButton.setTextSize(13.0f);
        progressButton.setGravity(17);
        linearLayout.addView(progressButton, layoutParams7);
        return linearLayout;
    }

    private ProgressButton getProgressButton(EmoticonPackage emoticonPackage) {
        List<ProgressButton> list = this.btns;
        if (list != null && list.size() >= 1 && emoticonPackage != null && !TextUtils.isEmpty(emoticonPackage.epId)) {
            for (ProgressButton progressButton : this.btns) {
                PromotionEmoticonPkg recommendPkgByView = getRecommendPkgByView(progressButton);
                if (recommendPkgByView != null && emoticonPackage.epId.equals(recommendPkgByView.f203111id)) {
                    return progressButton;
                }
            }
            return null;
        }
        QLog.e(TAG, 1, "getProgressButton view or ep error");
        return null;
    }

    private PromotionEmoticonPkg getRecommendPkgByView(View view) {
        Object tag;
        if (view == null || (tag = view.getTag()) == null || !(tag instanceof PromotionEmoticonPkg)) {
            return null;
        }
        return (PromotionEmoticonPkg) tag;
    }

    private ImageView getRedPointViewByEp(PromotionEmoticonPkg promotionEmoticonPkg) {
        List<ImageView> list = this.reds;
        if (list != null && list.size() >= 1 && promotionEmoticonPkg != null && !TextUtils.isEmpty(promotionEmoticonPkg.f203111id)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getRedPointViewByEp");
            }
            for (ImageView imageView : this.reds) {
                PromotionEmoticonPkg recommendPkgByView = getRecommendPkgByView(imageView);
                if (recommendPkgByView != null && promotionEmoticonPkg.f203111id.equals(recommendPkgByView.f203111id)) {
                    return imageView;
                }
            }
            return null;
        }
        QLog.e(TAG, 1, "getRedPointViewByEp view or ep error");
        return null;
    }

    private boolean isCurrentPanel() {
        if (EmotionPanelConstans.getPanelType(this.app, this.curPanelInfo) == this.panelType) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPkgDownloading(PromotionEmoticonPkg promotionEmoticonPkg) {
        if (((EmojiManagerServiceProxy) this.app.getRuntimeService(IEmojiManagerService.class)).getEmoticonPackageLoadingProgress(promotionEmoticonPkg.f203111id) >= 0.0f) {
            return true;
        }
        return false;
    }

    private void openEmoticonDetailPage(PromotionEmoticonPkg promotionEmoticonPkg, int i3) {
        ((IRecommendEmotionService) QRoute.api(IRecommendEmotionService.class)).openEmoticonDetailPage(this.mContext, this.app, promotionEmoticonPkg, i3);
    }

    private void sendSSORequest() {
        String str;
        SharedPreferences sharedPreferences = this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0);
        sharedPreferences.edit().putBoolean("isClickRecommendRedpoint", true).commit();
        int i3 = sharedPreferences.getInt("recommendRuleId", -1);
        String currentUin = this.app.getCurrentUin();
        if (!this.isRedWhenClickRecommend) {
            str = "";
        } else {
            str = "1";
        }
        VasWebviewUtil.reportCommercialDrainage(currentUin, "ep_mall", "PageView", "", 0, 0, 0, "", "", "", str, "", i3 + "", "", 0, 0, 0, 0);
        com.tencent.mobileqq.EmotionUtils.d(this.app, this.businessType);
    }

    private void updateUI(View view, PromotionEmoticonPkg promotionEmoticonPkg) {
        ArrayList<Integer> arrayList;
        String str;
        if (view != null && promotionEmoticonPkg != null) {
            if (isCurrentPanel()) {
                if (!this.visiableExposeList.contains(promotionEmoticonPkg)) {
                    ((EmoticonManagerServiceProxy) this.app.getRuntimeService(IEmoticonManagerService.class)).recordRecommendEpExpose(promotionEmoticonPkg);
                    int i3 = this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).getInt("recommendRuleId", -1);
                    int indexOf = this.data.indexOf(promotionEmoticonPkg) + 1;
                    String currentUin = this.app.getCurrentUin();
                    String str2 = promotionEmoticonPkg.f203111id;
                    String str3 = indexOf + "";
                    if (!this.isRedWhenClickRecommend) {
                        str = "";
                    } else {
                        str = "1";
                    }
                    VasWebviewUtil.reportCommercialDrainage(currentUin, "ep_mall", "aioshow", "", 0, 0, 0, "", str2, str3, str, "", i3 + "", "", 0, 0, 0, 0);
                    this.visiableExposeList.add(promotionEmoticonPkg);
                }
            } else if (!this.invisiableExposeList.contains(promotionEmoticonPkg)) {
                this.invisiableExposeList.add(promotionEmoticonPkg);
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "updateUI epid = " + promotionEmoticonPkg.f203111id + "expose num = " + promotionEmoticonPkg.exposureNum);
            }
            view.setVisibility(0);
            if (promotionEmoticonPkg == view.getTag(R.id.kxb)) {
                return;
            }
            view.setTag(R.id.kxb, promotionEmoticonPkg);
            try {
                URLImageView uRLImageView = (URLImageView) view.findViewById(R.id.f630032c);
                uRLImageView.setImageDrawable(URLDrawable.getDrawable(promotionEmoticonPkg.imgUrl, this.mContext.getResources().getDrawable(R.drawable.fnm), this.mContext.getResources().getDrawable(R.drawable.fnn)));
                uRLImageView.setTag(promotionEmoticonPkg);
                uRLImageView.setOnClickListener(this);
                TextView textView = (TextView) view.findViewById(R.id.f630132d);
                textView.setText(promotionEmoticonPkg.pkgDesc);
                textView.setTextColor(this.mContext.getResources().getColor(R.color.skin_gray2_theme_version2));
                uRLImageView.setContentDescription(promotionEmoticonPkg.pkgDesc);
                ProgressButton progressButton = (ProgressButton) view.findViewById(R.id.f629832a);
                progressButton.setText(promotionEmoticonPkg.btnDesc);
                progressButton.setTag(promotionEmoticonPkg);
                progressButton.setContentDescription(promotionEmoticonPkg.btnDesc);
                progressButton.setOnClickListener(this);
                setProgressDrawable(progressButton);
                List<ProgressButton> list = this.btns;
                if (list != null && !list.contains(progressButton)) {
                    this.btns.add(progressButton);
                }
                URLImageView uRLImageView2 = (URLImageView) view.findViewById(R.id.f629932b);
                uRLImageView2.setImageDrawable(null);
                uRLImageView2.setVisibility(8);
                ImageView imageView = (ImageView) view.findViewById(R.id.f166664h31);
                imageView.setVisibility(8);
                imageView.setTag(promotionEmoticonPkg);
                if (promotionEmoticonPkg.redpointFlag == 1) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "emoticon Effect mNeedShowRedEffect:" + this.mNeedShowRedEffect + ", id:" + promotionEmoticonPkg.f203111id);
                    }
                    int indexOf2 = this.data.indexOf(promotionEmoticonPkg);
                    if (this.mNeedShowRedEffect && indexOf2 < 2 && ((arrayList = this.mShowedEffectList) == null || (arrayList.size() < 2 && this.mShowedEffectList.indexOf(Integer.valueOf(indexOf2)) < 0))) {
                        RecommendEffectHolder recommendEffectHolder = new RecommendEffectHolder();
                        recommendEffectHolder.contentView = view;
                        recommendEffectHolder.recommendPkg = promotionEmoticonPkg;
                        recommendEffectHolder.index = indexOf2;
                        ThreadManagerV2.post(new Runnable(recommendEffectHolder) { // from class: com.tencent.mobileqq.emoticonview.RecommendEmotionAdapter.1
                            static IPatchRedirector $redirector_;
                            final /* synthetic */ RecommendEffectHolder val$rHolder;

                            {
                                this.val$rHolder = recommendEffectHolder;
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) RecommendEmotionAdapter.this, (Object) recommendEffectHolder);
                                }
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                int i16;
                                IPatchRedirector iPatchRedirector = $redirector_;
                                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                    iPatchRedirector.redirect((short) 2, (Object) this);
                                    return;
                                }
                                synchronized (RecommendEmotionAdapter.this.mEffectLock) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d(RecommendEmotionAdapter.TAG, 2, "emoticon Effect effectFile = null, id:" + this.val$rHolder.recommendPkg.f203111id + ", index:" + this.val$rHolder.index);
                                    }
                                    RecommendEmotionAdapter recommendEmotionAdapter = RecommendEmotionAdapter.this;
                                    if (recommendEmotionAdapter.mWaitToShowList == null) {
                                        recommendEmotionAdapter.mWaitToShowList = new ArrayList<>();
                                    }
                                    if (RecommendEmotionAdapter.this.mWaitToShowList.size() > 0) {
                                        i16 = RecommendEmotionAdapter.this.mWaitToShowList.get(0).index;
                                    } else {
                                        i16 = -1;
                                    }
                                    RecommendEffectHolder recommendEffectHolder2 = this.val$rHolder;
                                    if (recommendEffectHolder2.index < i16) {
                                        RecommendEmotionAdapter.this.mWaitToShowList.add(0, recommendEffectHolder2);
                                    } else {
                                        RecommendEmotionAdapter.this.mWaitToShowList.add(recommendEffectHolder2);
                                    }
                                }
                            }
                        }, 8, null, true);
                    }
                }
                List<ImageView> list2 = this.reds;
                if (list2 != null && !list2.contains(imageView)) {
                    this.reds.add(imageView);
                }
                float emoticonPackageLoadingProgress = ((EmojiManagerServiceProxy) this.app.getRuntimeService(IEmojiManagerService.class)).getEmoticonPackageLoadingProgress(promotionEmoticonPkg.f203111id);
                if (emoticonPackageLoadingProgress >= 0.0f) {
                    progressButton.setProgress((int) emoticonPackageLoadingProgress);
                    progressButton.setText(this.mContext.getString(R.string.f208915e0));
                } else {
                    progressButton.setText(promotionEmoticonPkg.btnDesc);
                    progressButton.setProgress(0);
                }
            } catch (OutOfMemoryError e16) {
                QLog.e(TAG, 1, "updateUI oom e = " + e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmotionNeedDownloadAdapter, com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public void destory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        super.destory();
        List<ProgressButton> list = this.btns;
        if (list != null) {
            list.clear();
            this.btns = null;
        }
        List<ImageView> list2 = this.reds;
        if (list2 != null) {
            list2.clear();
            this.reds = null;
        }
        ArrayList<Integer> arrayList = this.mShowedEffectList;
        if (arrayList != null) {
            arrayList.clear();
            this.mShowedEffectList = null;
        }
        if (this.mLoadingDrawable != null) {
            this.mLoadingDrawable = null;
        }
    }

    public void downloadOrPay(ProgressButton progressButton, PromotionEmoticonPkg promotionEmoticonPkg, boolean z16, int i3) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, progressButton, promotionEmoticonPkg, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        if (progressButton != null && promotionEmoticonPkg != null && this.app != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "downloadOrPay epid = " + promotionEmoticonPkg.f203111id);
            }
            int i16 = promotionEmoticonPkg.feeType;
            if (i16 != 2 && i16 != 6) {
                String str2 = promotionEmoticonPkg.f203111id;
                ((EmoticonManagerServiceProxy) this.app.getRuntimeService(IEmoticonManagerService.class)).asyncFindEmoticonPackage(str2, -1, new QueryCallback<EmoticonPackage>(promotionEmoticonPkg.type, str2, i16, promotionEmoticonPkg, z16, progressButton, i3) { // from class: com.tencent.mobileqq.emoticonview.RecommendEmotionAdapter.2
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ int val$businessType;
                    final /* synthetic */ ProgressButton val$clickBtn;
                    final /* synthetic */ String val$epId;
                    final /* synthetic */ int val$feeType;
                    final /* synthetic */ boolean val$isPayBack;
                    final /* synthetic */ PromotionEmoticonPkg val$pkg;
                    final /* synthetic */ int val$promotionType;

                    {
                        this.val$promotionType = r6;
                        this.val$epId = str2;
                        this.val$feeType = i16;
                        this.val$pkg = promotionEmoticonPkg;
                        this.val$isPayBack = z16;
                        this.val$clickBtn = progressButton;
                        this.val$businessType = i3;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, RecommendEmotionAdapter.this, Integer.valueOf(r6), str2, Integer.valueOf(i16), promotionEmoticonPkg, Boolean.valueOf(z16), progressButton, Integer.valueOf(i3));
                        }
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:15:0x0086, code lost:
                    
                        if (r1 != 3) goto L28;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:16:0x0091, code lost:
                    
                        r5 = false;
                     */
                    /* JADX WARN: Code restructure failed: missing block: B:62:0x008e, code lost:
                    
                        if (r1 == 3) goto L30;
                     */
                    @Override // com.tencent.mobileqq.emoticonview.QueryCallback
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void postQuery(EmoticonPackage emoticonPackage) {
                        String str3;
                        String str4;
                        boolean z17;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) emoticonPackage);
                            return;
                        }
                        int currentUserVipType = ((SVIPHandlerProxy) RecommendEmotionAdapter.this.app.getBusinessHandler(((ISVIPHandlerProxy) QRoute.api(ISVIPHandlerProxy.class)).getImplClassName())).getCurrentUserVipType();
                        int i17 = this.val$promotionType;
                        if (i17 == 4) {
                            str3 = "mvip.g.a.bq_" + this.val$epId;
                        } else if (i17 == 0) {
                            str3 = "mvip.g.a.bq_" + this.val$epId;
                        } else if (i17 == 3 || i17 == 5) {
                            str3 = "mvip.g.a.bq_mg_" + this.val$epId;
                        } else {
                            str3 = "";
                        }
                        int i18 = this.val$feeType;
                        if (i18 == 4) {
                            str4 = "!vip";
                            if (currentUserVipType != 1) {
                            }
                            z17 = true;
                        } else {
                            if (i18 == 5) {
                                str4 = "!svip";
                            } else {
                                str4 = "vip";
                            }
                            z17 = true;
                        }
                        EmoticonPackage emoticonPackage2 = new EmoticonPackage();
                        PromotionEmoticonPkg promotionEmoticonPkg2 = this.val$pkg;
                        emoticonPackage2.jobType = promotionEmoticonPkg2.type;
                        emoticonPackage2.epId = promotionEmoticonPkg2.f203111id;
                        if (QLog.isColorLevel()) {
                            QLog.d(RecommendEmotionAdapter.TAG, 2, "canDownload:" + z17 + ",vipType:" + currentUserVipType + ",isPayBack:" + this.val$isPayBack);
                        }
                        if (RecommendEmotionAdapter.this.isPkgDownloading(this.val$pkg)) {
                            ((EmojiManagerServiceProxy) RecommendEmotionAdapter.this.app.getRuntimeService(IEmojiManagerService.class)).stopEmoticonPackageDownload(emoticonPackage2.epId);
                            this.val$clickBtn.setText(this.val$pkg.btnDesc);
                            this.val$clickBtn.setProgress(0);
                            if (this.val$isPayBack) {
                                ReportController.o(RecommendEmotionAdapter.this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X800581D", 0, 0, this.val$pkg.f203111id, "", "", "");
                                return;
                            } else {
                                ReportController.o(RecommendEmotionAdapter.this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X8005817", 0, 0, this.val$pkg.f203111id, "", "", "");
                                return;
                            }
                        }
                        if (z17) {
                            if (this.val$businessType == 1) {
                                ((EmoticonHandlerProxy) RecommendEmotionAdapter.this.app.getBusinessHandler(EmoticonHandler.F)).reportAddEmoticonPkg(emoticonPackage2.epId, this.val$businessType);
                            } else if (emoticonPackage2.type != 4) {
                                ((EmoticonHandlerProxy) RecommendEmotionAdapter.this.app.getBusinessHandler(EmoticonHandler.F)).reportAddEmoticonPkg(emoticonPackage2.epId, this.val$businessType);
                            }
                            ((EmojiManagerServiceProxy) RecommendEmotionAdapter.this.app.getRuntimeService(IEmojiManagerService.class)).pullEmoticonPackage(emoticonPackage2, true, this.val$businessType);
                            this.val$clickBtn.setText(RecommendEmotionAdapter.this.mContext.getString(R.string.f208915e0));
                            RecommendEmotionAdapter.this.setProgressDrawable(this.val$clickBtn);
                            if (!this.val$isPayBack) {
                                ReportController.o(RecommendEmotionAdapter.this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X8005814", 0, 0, this.val$pkg.f203111id, "", "", "");
                            }
                            ReportController.o(RecommendEmotionAdapter.this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X8006139", 0, 0, this.val$pkg.f203111id, RecommendEmotionAdapter.this.isRedWhenClickRecommend ? "1" : "", "", "");
                            int i19 = RecommendEmotionAdapter.this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).getInt("recommendRuleId", -1);
                            int indexOf = RecommendEmotionAdapter.this.data.indexOf(this.val$pkg) + 1;
                            VasWebviewUtil.reportCommercialDrainage(RecommendEmotionAdapter.this.app.getCurrentUin(), "ep_mall", "0X8005814", "", 0, 0, 0, "", this.val$pkg.f203111id, indexOf + "", RecommendEmotionAdapter.this.isRedWhenClickRecommend ? "1" : "", "", i19 + "", "", 0, 0, 0, 0);
                            return;
                        }
                        if (this.val$isPayBack) {
                            return;
                        }
                        RecommendEmotionAdapter.this.clickPayBtn = this.val$clickBtn;
                        String str5 = "https://mc.vip.qq.com/qqwallet/index?aid=" + str3 + "&type=" + str4 + "&send=0&return_url=jsbridge://qw_charge/emojiPayResultOk&debug=1";
                        if (RecommendEmotionAdapter.this.mContext instanceof Activity) {
                            Intent intent = new Intent();
                            intent.putExtra("url", str5);
                            RouteUtils.startActivityForResult((Activity) RecommendEmotionAdapter.this.mContext, intent, RouterConstants.UI_ROUTE_BROWSER, 4779);
                            if (QLog.isColorLevel()) {
                                QLog.d(RecommendEmotionAdapter.TAG, 2, "func downloadOrPay. mCurPageIndex: epid = " + this.val$pkg.f203111id);
                            }
                            ReportController.o(RecommendEmotionAdapter.this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X8005815", 0, 0, this.val$pkg.f203111id, "", "", "");
                        }
                    }
                });
                return;
            }
            openEmoticonDetailPage(promotionEmoticonPkg, i3);
            ReportController.o(this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X800613D", 0, 0, promotionEmoticonPkg.f203111id, "", "", promotionEmoticonPkg.redpointFlag + "");
            int i17 = this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).getInt("recommendRuleId", -1);
            int indexOf = this.data.indexOf(promotionEmoticonPkg) + 1;
            String currentUin = this.app.getCurrentUin();
            String str3 = promotionEmoticonPkg.f203111id;
            String str4 = indexOf + "";
            if (!this.isRedWhenClickRecommend) {
                str = "";
            } else {
                str = "1";
            }
            VasWebviewUtil.reportCommercialDrainage(currentUin, "ep_mall", "0X800613D", "", 0, 0, 0, "", str3, str4, str, "", i17 + "", "", 0, 0, 0, 0);
        }
    }

    public URLDrawable getApngDrawable(Drawable drawable, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (URLDrawable) iPatchRedirector.redirect((short) 12, this, drawable, str, Integer.valueOf(i3));
        }
        try {
            URL url = new URL("vasapngdownloader", str, "local_recommendEffect");
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mUseApngImage = true;
            obtain.mRequestHeight = i3;
            obtain.mRequestWidth = i3;
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable;
            Bundle bundle = new Bundle();
            bundle.putInt("key_loop", 1);
            bundle.putBoolean("key_once_clear", true);
            bundle.putString("bundle_key_scid", VasUpdateConstants.SCID_EMOTICON_RECOMMEND_EFFECT);
            obtain.mExtraInfo = bundle;
            return URLDrawable.getDrawable(url, obtain);
        } catch (Exception e16) {
            QLog.d("RecommendEmotionServiceImpl", 2, "getApngDrawable exception = " + e16.getMessage());
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r4v5, types: [android.widget.LinearLayout, android.view.View, android.view.ViewGroup] */
    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public View getEmotionView(BaseEmotionAdapter.ViewHolder viewHolder, int i3, View view, ViewGroup viewGroup) {
        View view2;
        PromotionEmoticonPkg promotionEmoticonPkg;
        ViewGroup viewGroup2;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        int i17 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, this, viewHolder, Integer.valueOf(i3), view, viewGroup);
        }
        this.contentWidth = this.widthPixels / this.columnNum;
        System.currentTimeMillis();
        RecommendEmotionViewHolder recommendEmotionViewHolder = (RecommendEmotionViewHolder) viewHolder;
        int i18 = 8;
        if (view == null) {
            View view3 = EmotionPanelViewPool.getInstance().getView(this.panelType);
            if (view3 == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getEmotionView position = " + i3 + ";view from inflater");
                }
                viewGroup2 = new LinearLayout(this.mContext);
                viewGroup2.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                viewGroup2.setOrientation(0);
                for (int i19 = 0; i19 < this.columnNum; i19++) {
                    try {
                        LinearLayout emotionLayout = getEmotionLayout();
                        emotionLayout.setVisibility(8);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.contentWidth, -1);
                        if (i3 == 0) {
                            layoutParams.topMargin = (int) (this.density * 22.0f);
                        } else {
                            layoutParams.topMargin = (int) (this.density * 20.0f);
                        }
                        viewGroup2.addView(emotionLayout, layoutParams);
                    } catch (Exception e16) {
                        QLog.e(TAG, 1, "getEmotionView ; position = " + i3 + "; has exception ,e = " + e16.getMessage());
                        return null;
                    } catch (OutOfMemoryError unused) {
                        QLog.e(TAG, 1, "getEmotionView oom");
                    }
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getEmotionView position = " + i3 + ";view from cache");
                }
                viewGroup2 = view3;
            }
            recycleView(this.panelType, viewGroup2);
            ViewGroup viewGroup3 = viewGroup2;
            recommendEmotionViewHolder.contentViews = new LinearLayout[this.columnNum];
            for (int i26 = 0; i26 < this.columnNum; i26++) {
                recommendEmotionViewHolder.contentViews[i26] = (LinearLayout) viewGroup3.getChildAt(i26);
            }
            viewGroup2.setTag(recommendEmotionViewHolder);
            view2 = viewGroup2;
        } else {
            view2 = view;
        }
        while (true) {
            int i27 = this.columnNum;
            if (i16 < i27) {
                int i28 = (i27 * i3) + i16;
                if (i28 > this.data.size() - i17) {
                    recommendEmotionViewHolder.contentViews[i16].setTag(null);
                    recommendEmotionViewHolder.contentViews[i16].setVisibility(i18);
                } else {
                    LinearLayout linearLayout = recommendEmotionViewHolder.contentViews[i16];
                    EmotionPanelData emotionPanelData = this.data.get(i28);
                    if (emotionPanelData instanceof PromotionEmoticonPkg) {
                        promotionEmoticonPkg = (PromotionEmoticonPkg) emotionPanelData;
                    } else {
                        promotionEmoticonPkg = null;
                    }
                    updateUI(linearLayout, promotionEmoticonPkg);
                    if (promotionEmoticonPkg != null) {
                        ReportController.o(this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X8005813", 0, 0, promotionEmoticonPkg.f203111id, i3 + "", "", promotionEmoticonPkg.redpointFlag + "");
                    }
                }
                i16++;
                i17 = 1;
                i18 = 8;
            } else {
                return view2;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        ProgressButton progressButton;
        int statusPercent;
        ProgressButton progressButton2;
        PromotionEmoticonPkg recommendPkgByView;
        RecommendEffectHolder recommendEffectHolder;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) message)).booleanValue();
        }
        switch (message.what) {
            case 100:
                EmoticonPackage emoticonPackage = (EmoticonPackage) message.obj;
                if (emoticonPackage == null || (progressButton = getProgressButton(emoticonPackage)) == null || (statusPercent = (int) ((EmojiManagerServiceProxy) this.app.getRuntimeService(IEmojiManagerService.class)).getStatusPercent(emoticonPackage.epId)) < 0) {
                    return true;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "handleMessage refreashProgress epid = " + emoticonPackage.epId + ";progress = " + statusPercent);
                }
                if (statusPercent == 100) {
                    ReportController.o(this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X800581C", 0, 0, emoticonPackage.epId, "", "", "");
                }
                progressButton.setProgress(statusPercent);
                setProgressDrawable(progressButton);
                return true;
            case 101:
                EmoticonPackage emoticonPackage2 = (EmoticonPackage) message.obj;
                if (emoticonPackage2 == null || (progressButton2 = getProgressButton(emoticonPackage2)) == null || (recommendPkgByView = getRecommendPkgByView(progressButton2)) == null) {
                    return true;
                }
                progressButton2.setProgress(0);
                progressButton2.setText(recommendPkgByView.btnDesc);
                refreshPanelData();
                ReportController.o(this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X8005816", 0, 1, recommendPkgByView.f203111id, "", "", "");
                return true;
            case 102:
                Object obj = message.obj;
                if ((obj instanceof RecommendEffectHolder) && (recommendEffectHolder = (RecommendEffectHolder) obj) != null && !recommendEffectHolder.isShow) {
                    recommendEffectHolder.isShow = true;
                    View view = recommendEffectHolder.contentView;
                    if (view == null || recommendEffectHolder.recommendPkg == null || recommendEffectHolder.effectFile == null || view.getVisibility() != 0 || ((URLImageView) recommendEffectHolder.contentView.findViewById(R.id.f630032c)).getTag() != recommendEffectHolder.recommendPkg) {
                        return true;
                    }
                    ArrayList<Integer> arrayList = this.mShowedEffectList;
                    if (arrayList != null && (arrayList.size() >= 2 || this.mShowedEffectList.indexOf(Integer.valueOf(recommendEffectHolder.index)) >= 0)) {
                        return true;
                    }
                    String absolutePath = recommendEffectHolder.effectFile.getAbsolutePath();
                    try {
                        if (this.mLoadingDrawable == null) {
                            this.mLoadingDrawable = new BitmapDrawable(this.mContext.getResources(), Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888));
                        }
                        URLImageView uRLImageView = (URLImageView) recommendEffectHolder.contentView.findViewById(R.id.f629932b);
                        URLDrawable apngDrawable = getApngDrawable(this.mLoadingDrawable, absolutePath, (int) (this.density * 85.0f));
                        uRLImageView.setVisibility(0);
                        uRLImageView.setImageDrawable(apngDrawable);
                        if (this.mShowedEffectList == null) {
                            this.mShowedEffectList = new ArrayList<>();
                        }
                        this.mShowedEffectList.add(Integer.valueOf(recommendEffectHolder.index));
                        if (this.mNeedShowRedEffect) {
                            this.mNeedShowRedEffect = false;
                            this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).edit().putBoolean("recommemd_red_effect", false).commit();
                        }
                    } catch (Exception e16) {
                        QLog.e(TAG, 1, "MSG_SHOW_RECOMMEND_EFFECT err:" + e16.toString());
                    }
                    return true;
                }
                return true;
            default:
                return true;
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public BaseEmotionAdapter.ViewHolder newHolder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (BaseEmotionAdapter.ViewHolder) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return new RecommendEmotionViewHolder();
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public void onAdapterSelected() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.businessType == 0) {
            sendSSORequest();
            if (this.invisiableExposeList.size() > 0) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onAdapterSelected invisiableExposeList size > 0");
                }
                for (PromotionEmoticonPkg promotionEmoticonPkg : this.invisiableExposeList) {
                    if (!this.visiableExposeList.contains(promotionEmoticonPkg)) {
                        this.visiableExposeList.add(promotionEmoticonPkg);
                        ((EmoticonManagerServiceProxy) this.app.getRuntimeService(IEmoticonManagerService.class)).recordRecommendEpExpose(promotionEmoticonPkg);
                    }
                }
                this.invisiableExposeList.clear();
                return;
            }
            EmotionPanelListView currentListView = getCurrentListView();
            if (currentListView != null) {
                int firstVisiblePosition = currentListView.getFirstVisiblePosition();
                int lastVisiblePosition = currentListView.getLastVisiblePosition();
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onAdapterSelected firstShowPosition = " + firstVisiblePosition + ";lastShowPosition = " + lastVisiblePosition);
                }
                if (this.data != null) {
                    this.visiableExposeList.clear();
                    int i3 = this.columnNum;
                    int i16 = firstVisiblePosition * i3;
                    int i17 = (i3 * (lastVisiblePosition + 1)) - 1;
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "onAdapterSelected firstDataPosition = " + i16 + ";lastDataPosition = " + i17);
                    }
                    while (true) {
                        boolean z17 = false;
                        if (i16 <= i17) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (i16 < this.data.size()) {
                            z17 = true;
                        }
                        if (z17 & z16) {
                            EmotionPanelData emotionPanelData = this.data.get(i16);
                            if (emotionPanelData != null && (emotionPanelData instanceof PromotionEmoticonPkg)) {
                                PromotionEmoticonPkg promotionEmoticonPkg2 = (PromotionEmoticonPkg) emotionPanelData;
                                ((EmoticonManagerServiceProxy) this.app.getRuntimeService(IEmoticonManagerService.class)).recordRecommendEpExpose(promotionEmoticonPkg2);
                                if (!this.visiableExposeList.contains(promotionEmoticonPkg2)) {
                                    this.visiableExposeList.add(promotionEmoticonPkg2);
                                }
                            }
                            i16++;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else {
            PromotionEmoticonPkg recommendPkgByView = getRecommendPkgByView(view);
            if (recommendPkgByView != null) {
                ImageView redPointViewByEp = getRedPointViewByEp(recommendPkgByView);
                if (view instanceof URLImageView) {
                    int i3 = this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).getInt("recommendRuleId", -1);
                    int indexOf = this.data.indexOf(recommendPkgByView) + 1;
                    String currentUin = this.app.getCurrentUin();
                    String str2 = recommendPkgByView.f203111id;
                    String str3 = indexOf + "";
                    if (!this.isRedWhenClickRecommend) {
                        str = "";
                    } else {
                        str = "1";
                    }
                    VasWebviewUtil.reportCommercialDrainage(currentUin, "ep_mall", "0X80065DD", "", 0, 0, 0, "", str2, str3, str, "", i3 + "", "", 0, 0, 0, 0);
                    ReportController.o(this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X80065DD", 0, 0, recommendPkgByView.f203111id, "", "", recommendPkgByView.redpointFlag + "");
                    openEmoticonDetailPage(recommendPkgByView, this.businessType);
                    if (redPointViewByEp != null && redPointViewByEp.getVisibility() == 0) {
                        redPointViewByEp.setVisibility(8);
                        recommendPkgByView.redpointFlag = 0;
                        ((EmoticonManagerServiceProxy) this.app.getRuntimeService(IEmoticonManagerService.class)).setRecommendEpRedFlag(recommendPkgByView.f203111id, this.businessType);
                    }
                } else if (view instanceof ProgressButton) {
                    ReportController.o(this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X8005814", 0, 0, recommendPkgByView.f203111id, "", "", recommendPkgByView.redpointFlag + "");
                    downloadOrPay((ProgressButton) view, recommendPkgByView, false, this.businessType);
                    if (redPointViewByEp != null && redPointViewByEp.getVisibility() == 0) {
                        redPointViewByEp.setVisibility(8);
                        recommendPkgByView.redpointFlag = 0;
                        ((EmoticonManagerServiceProxy) this.app.getRuntimeService(IEmoticonManagerService.class)).setRecommendEpRedFlag(recommendPkgByView.f203111id, this.businessType);
                    }
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.emoticonview.EmotionNeedDownloadAdapter
    public void packageDownloadEnd(EmoticonPackage emoticonPackage, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) emoticonPackage, i3);
            return;
        }
        if (i3 != 0 || emoticonPackage == null) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 101;
        obtain.obj = emoticonPackage;
        this.mUiHandler.sendMessage(obtain);
    }

    @Override // com.tencent.mobileqq.emoticonview.EmotionNeedDownloadAdapter
    public void payBack(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        if (i3 == 17) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "paback");
            }
            ProgressButton progressButton = this.clickPayBtn;
            if (progressButton == null) {
                QLog.e(TAG, 1, "payBack view is null");
                return;
            }
            PromotionEmoticonPkg recommendPkgByView = getRecommendPkgByView(progressButton);
            if (recommendPkgByView == null) {
                QLog.e(TAG, 1, "payBack pkg is null");
            } else {
                ReportController.o(this.app.getQQAppInterface(), "CliOper", "", "", "ep_mall", "0X800613B", 0, 0, recommendPkgByView.f203111id, "", "", "0");
                downloadOrPay(this.clickPayBtn, recommendPkgByView, true, this.businessType);
            }
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.EmotionNeedDownloadAdapter
    public void refreashProgress(EmoticonPackage emoticonPackage, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, emoticonPackage, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            if (emoticonPackage == null) {
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 100;
            obtain.obj = emoticonPackage;
            this.mUiHandler.sendMessage(obtain);
        }
    }

    @Override // com.tencent.mobileqq.emoticonview.BaseEmotionAdapter
    public void refreshPanelData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "refreshPanelData");
        }
        new QueryTask(new QueryTask.Query<Void, List<EmotionPanelData>>() { // from class: com.tencent.mobileqq.emoticonview.RecommendEmotionAdapter.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RecommendEmotionAdapter.this);
                }
            }

            @Override // com.tencent.mobileqq.emoticonview.QueryTask.Query
            public List<EmotionPanelData> query(Void r46) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (List) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) r46);
                }
                List<PromotionEmoticonPkg> proEmoticonPkgs = ((EmoticonManagerServiceProxy) RecommendEmotionAdapter.this.app.getRuntimeService(IEmoticonManagerService.class)).getProEmoticonPkgs(false, RecommendEmotionAdapter.this.businessType, false);
                ArrayList arrayList = new ArrayList();
                if (proEmoticonPkgs != null) {
                    arrayList.addAll(proEmoticonPkgs);
                }
                return arrayList;
            }
        }, new QueryCallback<List<EmotionPanelData>>() { // from class: com.tencent.mobileqq.emoticonview.RecommendEmotionAdapter.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RecommendEmotionAdapter.this);
                }
            }

            @Override // com.tencent.mobileqq.emoticonview.QueryCallback
            public void postQuery(List<EmotionPanelData> list) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    RecommendEmotionAdapter.this.setData(list);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) list);
                }
            }
        }).execute(null);
    }
}
