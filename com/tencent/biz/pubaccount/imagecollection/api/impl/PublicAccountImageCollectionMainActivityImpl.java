package com.tencent.biz.pubaccount.imagecollection.api.impl;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.av.utils.au;
import com.tencent.biz.pubaccount.api.IPublicAccountArticleHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountArticleObserver;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.imagecollection.PublicAccountImageCollectionCommentActivity;
import com.tencent.biz.pubaccount.imagecollection.PublicAccountImageCollectionListView;
import com.tencent.biz.pubaccount.imagecollection.PublicAccountImageView;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionMainActivity;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionPreloadManager;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils;
import com.tencent.biz.pubaccount.imagecollection.b;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.activitymodule.SystemBarActivityModule;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeType;
import com.tencent.mobileqq.kandian.base.image.api.IImageManager;
import com.tencent.mobileqq.kandian.base.view.widget.ZImageView;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqfav.QfavBuilder;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

/* loaded from: classes32.dex */
public class PublicAccountImageCollectionMainActivityImpl extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener, IPublicAccountImageCollectionMainActivity {
    public static int C2C_SOURCE = 2;
    public static int DISCUSSION_SOURCE = 4;
    public static final int REQUEST_CODE_FAVORITE = 101;
    public static final int RESET_CENTER_VIEW = 1;
    public static final String SCHEMATITLE = "mqqapi://readinjoy/apenalbum?src_type=app&version=1&articleid=";
    public static int TROOP_SOURCE = 3;
    public static boolean doubleTapFlag = false;
    ActionSheet actionSheet;
    ViewGroup centerView;
    private int click_source;
    private int commentCount;
    TextView commentCountText;
    ImageView commentImage;
    TextView commentTextView;
    private Drawable drawable;
    private boolean hasReport;
    Matrix initMatrix;
    private boolean isFollowed;
    private boolean isLiked;
    private int likeCount;
    private AnimatorSet mAlphaset;
    private AppInterface mApp;
    Context mContext;
    float mDensity;
    int mGridView1Length;
    int mGridView2Length;
    protected QQStoryLoadingView mProgressBar;
    private IPublicAccountArticleHandler mPublicAccountArticleHandler;
    private IPublicAccountArticleObserver mPublicAccountArticleObserver;
    ScaleGestureDetector mScaleGestureDetector;
    ElasticHorScrView mScrollView1;
    ElasticHorScrView mScrollView2;
    private TranslateAnimation mTranslateAnimationDown;
    private TranslateAnimation mTranslateAnimationUp;
    LinearLayout mUserGuide;
    private IPublicAccountImageCollectionUtils.a photoCollectionInfo;
    private PublicAccountImageView publicAccountMainImageView;
    private int readCount;
    private ArrayList<IPublicAccountImageCollectionUtils.d> recommendItemInfos;
    private int recommend_position;
    private RelativeLayout relativeLayout;
    private int report_source;
    float scale;
    Share share;
    ImageView shareImage;
    private long startTime;
    Bitmap thumbBitmap;
    ImageView titleLeft;
    ImageView titleRight;
    ViewGroup viewGroup;
    int whereShow;
    ImageView writeCommentImage;
    TextView zanCountText;
    ImageView zanImage;
    private PublicAccountImageCollectionListView mListView = null;
    private com.tencent.biz.pubaccount.imagecollection.b mAdapter = null;
    private Handler mUIHandler = null;
    private String uin = "";
    public String puin = "";
    public String articleID = "";
    private String recommend_source = "";
    private String mCommentDraft = null;
    private boolean mIsAnonymous = false;
    private boolean needFetchPhotoCollectionInfoFromServer = false;
    private boolean flag = false;
    Matrix matrix = new Matrix();
    Matrix mCurrentMatrix = new Matrix();
    float[] initValues = new float[9];
    float[] currentValues = new float[9];
    int zoomEvent = 1;
    public String webUrl = "";
    private String webName = "";
    private String webDes = "";
    private String webImg = "";
    protected Handler mHandler = new c();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PublicAccountImageCollectionMainActivityImpl.this.actionSheet.isShowing()) {
                PublicAccountImageCollectionMainActivityImpl.this.actionSheet.dismiss();
            }
        }
    }

    /* loaded from: classes32.dex */
    class c extends Handler {
        c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            PublicAccountImageCollectionMainActivityImpl.this.reSetCenterView();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class d implements View.OnTouchListener {
        d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (PublicAccountImageCollectionMainActivityImpl.this.flag) {
                PublicAccountImageCollectionMainActivityImpl.this.mScaleGestureDetector.onTouchEvent(motionEvent);
                if (QLog.isColorLevel()) {
                    QLog.d("qqBaseActivity", 2, "current operation is" + motionEvent.getAction());
                }
                if (motionEvent.getAction() == 1) {
                    PublicAccountImageCollectionMainActivityImpl publicAccountImageCollectionMainActivityImpl = PublicAccountImageCollectionMainActivityImpl.this;
                    if (publicAccountImageCollectionMainActivityImpl.currentValues[0] < publicAccountImageCollectionMainActivityImpl.initValues[0]) {
                        publicAccountImageCollectionMainActivityImpl.publicAccountMainImageView.setImageMatrix(PublicAccountImageCollectionMainActivityImpl.this.initMatrix);
                        PublicAccountImageCollectionMainActivityImpl.this.publicAccountMainImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    }
                }
                return true;
            }
            PublicAccountImageCollectionMainActivityImpl.this.mScaleGestureDetector.onTouchEvent(motionEvent);
            return false;
        }
    }

    /* loaded from: classes32.dex */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        TextView f79786a;

        /* renamed from: b, reason: collision with root package name */
        ImageView f79787b;

        /* renamed from: c, reason: collision with root package name */
        public IPublicAccountBrowser.a f79788c;
    }

    private View createViewFlipper(int i3) {
        List<IPublicAccountBrowser.a> arrayList;
        List<IPublicAccountBrowser.a> arrayList2;
        View inflate = super.getLayoutInflater().inflate(R.layout.f167943nn, (ViewGroup) null);
        this.mScrollView1 = (ElasticHorScrView) inflate.findViewById(R.id.iih);
        ElasticHorScrView elasticHorScrView = (ElasticHorScrView) inflate.findViewById(R.id.iii);
        this.mScrollView2 = elasticHorScrView;
        if (i3 == 1) {
            elasticHorScrView.setVisibility(8);
        }
        GridView gridView = (GridView) inflate.findViewById(R.id.f165392cx3);
        GridView gridView2 = (GridView) inflate.findViewById(R.id.cx4);
        TextView textView = (TextView) inflate.findViewById(R.id.action_sheet_title);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
        layoutParams.topMargin = (int) (this.mDensity * 13.0f);
        textView.setLayoutParams(layoutParams);
        textView.setText(R.string.cancel);
        textView.setOnClickListener(new a());
        this.mScrollView1.setOverScrollMode(2);
        this.mScrollView2.setOverScrollMode(2);
        gridView2.setSmoothScrollbarEnabled(false);
        List<IPublicAccountBrowser.a>[] actionSheetItems = getActionSheetItems();
        if (actionSheetItems.length > 0) {
            arrayList = actionSheetItems[0];
        } else {
            arrayList = new ArrayList<>(0);
        }
        if (actionSheetItems.length > 1) {
            arrayList2 = actionSheetItems[1];
        } else {
            arrayList2 = new ArrayList<>(0);
        }
        gridView.setNumColumns(arrayList.size());
        ViewGroup.LayoutParams layoutParams2 = gridView.getLayoutParams();
        layoutParams2.width = (int) (((r6 * 75) + ((r6 - 1) * 10) + 3) * this.mDensity);
        gridView.setLayoutParams(layoutParams2);
        gridView.setAdapter((ListAdapter) new h(this, 0, arrayList));
        gridView.setSelector(new ColorDrawable(0));
        gridView.setOnItemClickListener(this);
        final int i16 = layoutParams2.width;
        this.mGridView1Length = i16;
        int size = arrayList2.size();
        ViewGroup.LayoutParams layoutParams3 = gridView2.getLayoutParams();
        layoutParams3.width = (int) (((size * 75) + ((size - 1) * 10) + 3) * this.mDensity);
        gridView2.setLayoutParams(layoutParams3);
        gridView2.setNumColumns(size);
        gridView2.setAdapter((ListAdapter) new h(this, 0, arrayList2));
        gridView2.setSelector(new ColorDrawable(0));
        gridView2.setOnItemClickListener(this);
        final int i17 = layoutParams3.width;
        this.mGridView2Length = i17;
        inflate.post(new Runnable() { // from class: com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl.12
            @Override // java.lang.Runnable
            public void run() {
                if (PublicAccountImageCollectionMainActivityImpl.this.mScrollView1.getWidth() < i16) {
                    PublicAccountImageCollectionMainActivityImpl.this.mScrollView1.setMove(true);
                } else {
                    PublicAccountImageCollectionMainActivityImpl.this.mScrollView1.setMove(false);
                }
                if (PublicAccountImageCollectionMainActivityImpl.this.mScrollView2.getWidth() < i17) {
                    PublicAccountImageCollectionMainActivityImpl.this.mScrollView2.setMove(true);
                } else {
                    PublicAccountImageCollectionMainActivityImpl.this.mScrollView2.setMove(false);
                }
            }
        });
        return inflate;
    }

    private void dismissGuideAnim() {
        if (this.mUserGuide.getAnimation() != null) {
            this.mUserGuide.getAnimation().setAnimationListener(null);
            this.mUserGuide.getAnimation().cancel();
            this.mUserGuide.clearAnimation();
        }
        TranslateAnimation translateAnimation = this.mTranslateAnimationUp;
        if (translateAnimation != null) {
            translateAnimation.setAnimationListener(null);
            this.mTranslateAnimationUp.cancel();
            this.mTranslateAnimationUp = null;
        }
        TranslateAnimation translateAnimation2 = this.mTranslateAnimationDown;
        if (translateAnimation2 != null) {
            translateAnimation2.setAnimationListener(null);
            this.mTranslateAnimationDown.cancel();
            this.mTranslateAnimationDown = null;
        }
        AnimatorSet animatorSet = this.mAlphaset;
        if (animatorSet != null) {
            Iterator<Animator> it = animatorSet.getChildAnimations().iterator();
            while (it.hasNext()) {
                Animator next = it.next();
                next.end();
                next.cancel();
            }
            this.mAlphaset.end();
            this.mAlphaset.cancel();
        }
        this.mAlphaset = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doAfterGetPhotoCollectionInfo() {
        IPublicAccountImageCollectionUtils.a aVar = this.photoCollectionInfo;
        if (aVar == null) {
            return;
        }
        this.webUrl = aVar.f79734b;
        this.webName = aVar.f79737e;
        this.webImg = aVar.f79736d;
        this.puin = aVar.f79735c;
        if (TextUtils.isEmpty(this.webDes)) {
            this.webDes = "\u6765\u81eaQQ\u770b\u70b9\u7684\u5206\u4eab";
        }
        this.mUIHandler.postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl.5
            @Override // java.lang.Runnable
            public void run() {
                if (PublicAccountImageCollectionMainActivityImpl.this.mAdapter != null) {
                    PublicAccountImageCollectionMainActivityImpl.this.mAdapter.G(PublicAccountImageCollectionMainActivityImpl.this.photoCollectionInfo);
                    PublicAccountImageCollectionMainActivityImpl.this.mAdapter.notifyDataSetChanged();
                }
            }
        }, 0L);
        updateFollowState();
        initData(this.webImg);
        this.mPublicAccountArticleHandler.getArticleCommentCount(this.webUrl);
    }

    private void fetchAllArticleInfo() {
        if (TextUtils.isEmpty(this.articleID)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("qqBaseActivity", 2, "fetchAllArticleInfo");
        }
        getPhotoCollectionInfo();
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl.4
            @Override // java.lang.Runnable
            public void run() {
                PublicAccountImageCollectionMainActivityImpl.this.mPublicAccountArticleHandler.queryArticleLikeCount(PublicAccountImageCollectionMainActivityImpl.this.articleID);
                PublicAccountImageCollectionMainActivityImpl.this.mPublicAccountArticleHandler.checkIsArticleLiked(PublicAccountImageCollectionMainActivityImpl.this.articleID);
                PublicAccountImageCollectionMainActivityImpl.this.mPublicAccountArticleHandler.getRecommendInfo(PublicAccountImageCollectionMainActivityImpl.this.articleID);
                PublicAccountImageCollectionMainActivityImpl.this.mPublicAccountArticleHandler.queryArticleReadCount(PublicAccountImageCollectionMainActivityImpl.this.articleID);
                if (PublicAccountImageCollectionMainActivityImpl.this.needFetchPhotoCollectionInfoFromServer) {
                    IPublicAccountArticleHandler iPublicAccountArticleHandler = PublicAccountImageCollectionMainActivityImpl.this.mPublicAccountArticleHandler;
                    PublicAccountImageCollectionMainActivityImpl publicAccountImageCollectionMainActivityImpl = PublicAccountImageCollectionMainActivityImpl.this;
                    iPublicAccountArticleHandler.getPhotoCollectionInfo(publicAccountImageCollectionMainActivityImpl.articleID, publicAccountImageCollectionMainActivityImpl.recommend_source, PublicAccountImageCollectionMainActivityImpl.this.recommend_position, PublicAccountImageCollectionMainActivityImpl.this.click_source);
                    return;
                }
                int size = (PublicAccountImageCollectionMainActivityImpl.this.photoCollectionInfo == null || PublicAccountImageCollectionMainActivityImpl.this.photoCollectionInfo.f79741i == null) ? 0 : PublicAccountImageCollectionMainActivityImpl.this.photoCollectionInfo.f79741i.size();
                IPublicAccountReportUtils iPublicAccountReportUtils = (IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class);
                PublicAccountImageCollectionMainActivityImpl publicAccountImageCollectionMainActivityImpl2 = PublicAccountImageCollectionMainActivityImpl.this;
                String str = publicAccountImageCollectionMainActivityImpl2.puin;
                String str2 = publicAccountImageCollectionMainActivityImpl2.articleID;
                String str3 = publicAccountImageCollectionMainActivityImpl2.webUrl;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("");
                PublicAccountImageCollectionMainActivityImpl publicAccountImageCollectionMainActivityImpl3 = PublicAccountImageCollectionMainActivityImpl.this;
                sb5.append(publicAccountImageCollectionMainActivityImpl3.getSourceType(publicAccountImageCollectionMainActivityImpl3.report_source));
                iPublicAccountReportUtils.publicAccountReportClickEvent(null, str, "0X8007B8A", "0X8007B8A", 0, 0, str2, str3, sb5.toString(), "" + size, false);
            }
        });
    }

    private List<IPublicAccountBrowser.a>[] getActionSheetItems() {
        ArrayList arrayList = new ArrayList();
        IPublicAccountBrowser.a aVar = new IPublicAccountBrowser.a();
        aVar.f79324c = super.getString(R.string.dxy);
        aVar.f79322a = R.drawable.cck;
        aVar.f79323b = true;
        aVar.f79325d = 2;
        aVar.f79326e = "";
        arrayList.add(aVar);
        IPublicAccountBrowser.a aVar2 = new IPublicAccountBrowser.a();
        aVar2.f79324c = super.getString(R.string.dya);
        aVar2.f79322a = R.drawable.ccl;
        aVar2.f79323b = true;
        aVar2.f79325d = 3;
        aVar2.f79326e = "";
        arrayList.add(aVar2);
        IPublicAccountBrowser.a aVar3 = new IPublicAccountBrowser.a();
        aVar3.f79324c = super.getString(R.string.dyh);
        aVar3.f79322a = R.drawable.cco;
        aVar3.f79325d = 9;
        aVar3.f79326e = "";
        arrayList.add(aVar3);
        IPublicAccountBrowser.a aVar4 = new IPublicAccountBrowser.a();
        aVar4.f79324c = super.getString(R.string.f171309dy1);
        aVar4.f79322a = R.drawable.cci;
        aVar4.f79325d = 10;
        aVar4.f79326e = "";
        arrayList.add(aVar4);
        IPublicAccountBrowser.a aVar5 = new IPublicAccountBrowser.a();
        aVar5.f79324c = super.getString(R.string.dxv);
        aVar5.f79323b = true;
        aVar5.f79322a = R.drawable.dlu;
        aVar5.f79325d = 4;
        aVar5.f79326e = "";
        arrayList.add(aVar5);
        ArrayList arrayList2 = new ArrayList();
        IPublicAccountBrowser.a aVar6 = new IPublicAccountBrowser.a();
        aVar6.f79324c = super.getString(R.string.dxl);
        aVar6.f79323b = true;
        aVar6.f79322a = R.drawable.qfav_misc_web_menu_favorite_nor;
        aVar6.f79325d = 6;
        aVar6.f79326e = "";
        arrayList2.add(aVar6);
        IPublicAccountBrowser.a aVar7 = new IPublicAccountBrowser.a();
        aVar7.f79324c = super.getString(R.string.dxr);
        aVar7.f79322a = R.drawable.ccg;
        aVar7.f79323b = true;
        aVar7.f79325d = 1;
        aVar7.f79326e = "";
        arrayList2.add(aVar7);
        IPublicAccountBrowser.a aVar8 = new IPublicAccountBrowser.a();
        aVar8.f79324c = super.getString(R.string.dxw);
        aVar8.f79322a = R.drawable.dln;
        aVar8.f79323b = true;
        aVar8.f79325d = 11;
        aVar8.f79326e = "";
        arrayList2.add(aVar8);
        return new ArrayList[]{arrayList, arrayList2};
    }

    private void getPhotoCollectionInfo() {
        IPublicAccountImageCollectionUtils.a photoCollectionInfoFromCache = ((IPublicAccountImageCollectionPreloadManager) QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).getPhotoCollectionInfoFromCache(this.articleID);
        this.photoCollectionInfo = photoCollectionInfoFromCache;
        if (photoCollectionInfoFromCache != null) {
            ((IPublicAccountImageCollectionPreloadManager) QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).doStatisticReportForProtoHit(true);
            doAfterGetPhotoCollectionInfo();
            ((IPublicAccountImageCollectionPreloadManager) QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).setObserver(this.mPublicAccountArticleObserver);
            return;
        }
        if (FileUtils.fileExistsAndNotEmpty(AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_IMAGE_COLLECTION_PRELOAD + this.articleID)) {
            ((IPublicAccountImageCollectionPreloadManager) QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).getPhotoCollectionInfoFromFile(this.articleID, this.mPublicAccountArticleObserver);
            ((IPublicAccountImageCollectionPreloadManager) QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).doStatisticReportForProtoHit(true);
        } else {
            ((IPublicAccountImageCollectionPreloadManager) QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).doStatisticReportForProtoHit(false);
            this.needFetchPhotoCollectionInfoFromServer = true;
        }
    }

    private void initData() {
        this.articleID = getIntent().getStringExtra(IPublicAccountImageCollectionMainActivity.ARTICLE_ID);
        String stringExtra = getIntent().getStringExtra(IPublicAccountImageCollectionMainActivity.RECOMMEND_SOURCE);
        this.recommend_source = stringExtra;
        if (stringExtra == null) {
            this.recommend_source = "";
        }
        this.recommend_position = getIntent().getIntExtra(IPublicAccountImageCollectionMainActivity.RECOMMEND_POSITION, 0);
        this.click_source = getIntent().getIntExtra(IPublicAccountImageCollectionMainActivity.CLICK_SOURCE, 1);
        this.report_source = getIntent().getIntExtra(IPublicAccountImageCollectionMainActivity.SOURCE_FOR_REPORT, 16);
        AppInterface appInterface = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
        this.mApp = appInterface;
        this.uin = appInterface.getCurrentAccountUin();
        this.mAdapter.G(this.photoCollectionInfo);
        this.mAdapter.I(this.recommendItemInfos);
        this.mAdapter.A(this.articleID);
        this.mListView.setAdapter((ListAdapter) this.mAdapter);
    }

    private void initHandlerAndObserver() {
        this.mPublicAccountArticleHandler = (IPublicAccountArticleHandler) this.mApp.getBusinessHandler(BusinessHandlerFactory.PUBLIC_ACCOUNT_VIDEO_HANDLER);
        IPublicAccountArticleObserver iPublicAccountArticleObserver = (IPublicAccountArticleObserver) QRoute.api(IPublicAccountArticleObserver.class);
        this.mPublicAccountArticleObserver = iPublicAccountArticleObserver;
        iPublicAccountArticleObserver.setOnCallback(new IPublicAccountArticleObserver.a() { // from class: com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl.3
            @Override // com.tencent.biz.pubaccount.api.IPublicAccountArticleObserver.a
            public void a(boolean z16, String str, boolean z17) {
                if (QLog.isColorLevel()) {
                    QLog.d("qqBaseActivity", 2, "onCheckIsArticleLiked,articleID=" + str + "isLiked" + z17);
                }
                if (z16 && !TextUtils.isEmpty(str) && str.equalsIgnoreCase(PublicAccountImageCollectionMainActivityImpl.this.articleID)) {
                    PublicAccountImageCollectionMainActivityImpl.this.isLiked = z17;
                    PublicAccountImageCollectionMainActivityImpl.this.mUIHandler.postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl.3.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PublicAccountImageCollectionMainActivityImpl.this.isLiked) {
                                PublicAccountImageCollectionMainActivityImpl.this.zanImage.setImageResource(R.drawable.d6r);
                            } else {
                                PublicAccountImageCollectionMainActivityImpl.this.zanImage.setImageResource(R.drawable.d6q);
                            }
                        }
                    }, 0L);
                }
            }

            @Override // com.tencent.biz.pubaccount.api.IPublicAccountArticleObserver.a
            public void c(boolean z16, int i3) {
                if (QLog.isColorLevel()) {
                    QLog.d("qqBaseActivity", 2, "onGetArticleCommentCountRespond count=" + i3);
                }
                if (z16) {
                    PublicAccountImageCollectionMainActivityImpl.this.commentCount = i3;
                    PublicAccountImageCollectionMainActivityImpl.this.mUIHandler.postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl.3.7
                        @Override // java.lang.Runnable
                        public void run() {
                            PublicAccountImageCollectionMainActivityImpl.this.commentCountText.setText("" + PublicAccountImageCollectionMainActivityImpl.this.commentCount);
                        }
                    }, 0L);
                }
            }

            @Override // com.tencent.biz.pubaccount.api.IPublicAccountArticleObserver.a
            public void d(boolean z16, int i3) {
                if (QLog.isColorLevel()) {
                    QLog.d("qqBaseActivity", 2, "onGetArticleReadCount isSuccess =" + z16);
                }
                if (z16) {
                    PublicAccountImageCollectionMainActivityImpl.this.readCount = i3;
                    PublicAccountImageCollectionMainActivityImpl.this.mUIHandler.postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl.3.11
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PublicAccountImageCollectionMainActivityImpl.this.mAdapter != null) {
                                PublicAccountImageCollectionMainActivityImpl.this.mAdapter.H(PublicAccountImageCollectionMainActivityImpl.this.readCount);
                            }
                        }
                    }, 0L);
                }
            }

            @Override // com.tencent.biz.pubaccount.api.IPublicAccountArticleObserver.a
            public void e(IPublicAccountImageCollectionUtils.a aVar) {
                if (QLog.isColorLevel()) {
                    QLog.d("qqBaseActivity", 2, "onGetPhotoCollectionInfoRespond");
                }
                PublicAccountImageCollectionMainActivityImpl.this.photoCollectionInfo = aVar;
                if (aVar != null) {
                    PublicAccountImageCollectionMainActivityImpl.this.photoCollectionInfo = aVar;
                    PublicAccountImageCollectionMainActivityImpl.this.doAfterGetPhotoCollectionInfo();
                } else {
                    PublicAccountImageCollectionMainActivityImpl.this.mUIHandler.postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl.3.5
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PublicAccountImageCollectionMainActivityImpl.this.mAdapter == null || PublicAccountImageCollectionMainActivityImpl.this.mAdapter == null) {
                                return;
                            }
                            PublicAccountImageCollectionMainActivityImpl.this.mAdapter.D(true);
                            PublicAccountImageCollectionMainActivityImpl.this.mAdapter.notifyDataSetChanged();
                        }
                    }, 0L);
                }
            }

            @Override // com.tencent.biz.pubaccount.api.IPublicAccountArticleObserver.a
            public void g(boolean z16, final ArrayList<IPublicAccountImageCollectionUtils.d> arrayList) {
                if (QLog.isColorLevel()) {
                    QLog.d("qqBaseActivity", 2, "onGetRecommendInfoRespond isSuccess =" + z16);
                }
                if (z16) {
                    if (arrayList != null && arrayList.size() != 0) {
                        PublicAccountImageCollectionMainActivityImpl.this.recommendItemInfos = arrayList;
                        PublicAccountImageCollectionMainActivityImpl.this.mUIHandler.postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl.3.9
                            @Override // java.lang.Runnable
                            public void run() {
                                if (PublicAccountImageCollectionMainActivityImpl.this.mAdapter != null) {
                                    PublicAccountImageCollectionMainActivityImpl.this.mAdapter.I(arrayList);
                                }
                            }
                        }, 0L);
                        return;
                    } else {
                        PublicAccountImageCollectionMainActivityImpl.this.mUIHandler.postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl.3.8
                            @Override // java.lang.Runnable
                            public void run() {
                                if (PublicAccountImageCollectionMainActivityImpl.this.mAdapter == null || PublicAccountImageCollectionMainActivityImpl.this.mAdapter == null) {
                                    return;
                                }
                                PublicAccountImageCollectionMainActivityImpl.this.mAdapter.E(true);
                            }
                        }, 0L);
                        return;
                    }
                }
                PublicAccountImageCollectionMainActivityImpl.this.mUIHandler.postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl.3.10
                    @Override // java.lang.Runnable
                    public void run() {
                        if (PublicAccountImageCollectionMainActivityImpl.this.mAdapter == null || PublicAccountImageCollectionMainActivityImpl.this.mAdapter == null) {
                            return;
                        }
                        PublicAccountImageCollectionMainActivityImpl.this.mAdapter.E(true);
                    }
                }, 0L);
            }

            @Override // com.tencent.biz.pubaccount.api.IPublicAccountArticleObserver.a
            public void h(boolean z16, String str, final int i3) {
                if (QLog.isColorLevel()) {
                    QLog.d("qqBaseActivity", 2, "onQueryArticleLikeCount,articleID=" + str + MessageForQCircleFeed.MSG_QCIRCLE_FEED_KEY_LIKE_COUNT + i3);
                }
                if (z16 && !TextUtils.isEmpty(str) && str.equalsIgnoreCase(PublicAccountImageCollectionMainActivityImpl.this.articleID)) {
                    PublicAccountImageCollectionMainActivityImpl.this.likeCount = i3;
                    PublicAccountImageCollectionMainActivityImpl.this.mUIHandler.postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            PublicAccountImageCollectionMainActivityImpl.this.zanCountText.setText("" + i3);
                        }
                    }, 0L);
                }
            }

            @Override // com.tencent.biz.pubaccount.api.IPublicAccountArticleObserver.a
            public void i(boolean z16) {
                if (QLog.isColorLevel()) {
                    QLog.d("qqBaseActivity", 2, "onReportReadPhotoCollectionRespond isSuccess =" + z16);
                }
            }

            @Override // com.tencent.biz.pubaccount.api.IPublicAccountArticleObserver.a
            public void j(boolean z16, String str) {
                if (QLog.isColorLevel()) {
                    QLog.d("qqBaseActivity", 2, "onSendArticleLikeReq,articleID=" + str);
                }
            }

            @Override // com.tencent.biz.pubaccount.api.IPublicAccountArticleObserver.a
            public void b(final boolean z16, final int i3) {
                int i16;
                if (QLog.isColorLevel()) {
                    QLog.d("qqBaseActivity", 2, "onCreateArticleCommentRespond isSuccess=" + z16);
                }
                if (z16 && i3 == 0) {
                    i16 = 1;
                    PublicAccountImageCollectionMainActivityImpl.this.commentCount++;
                } else {
                    i16 = 0;
                }
                PublicAccountImageCollectionMainActivityImpl.this.mUIHandler.postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl.3.6
                    @Override // java.lang.Runnable
                    public void run() {
                        PublicAccountImageCollectionMainActivityImpl.this.commentCountText.setText("" + PublicAccountImageCollectionMainActivityImpl.this.commentCount);
                        PublicAccountImageCollectionMainActivityImpl.this.showCommentResult(z16, i3);
                    }
                }, 0L);
                IPublicAccountReportUtils iPublicAccountReportUtils = (IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class);
                PublicAccountImageCollectionMainActivityImpl publicAccountImageCollectionMainActivityImpl = PublicAccountImageCollectionMainActivityImpl.this;
                iPublicAccountReportUtils.publicAccountReportClickEvent(null, publicAccountImageCollectionMainActivityImpl.puin, "0X8007B97", "0X8007B97", 0, 0, publicAccountImageCollectionMainActivityImpl.articleID, publicAccountImageCollectionMainActivityImpl.webUrl, "" + i16, "", false);
            }

            @Override // com.tencent.biz.pubaccount.api.IPublicAccountArticleObserver.a
            public void f(boolean z16, IPublicAccountImageCollectionUtils.a aVar, byte[] bArr, String str) {
                ArrayList<IPublicAccountImageCollectionUtils.c> arrayList;
                if (QLog.isColorLevel()) {
                    QLog.d("qqBaseActivity", 2, "onGetPhotoCollectionInfoRespond isSuccess=" + z16);
                }
                if (z16) {
                    if (str == null || str.equals(PublicAccountImageCollectionMainActivityImpl.this.articleID)) {
                        PublicAccountImageCollectionMainActivityImpl.this.photoCollectionInfo = aVar;
                        if (aVar != null) {
                            PublicAccountImageCollectionMainActivityImpl.this.photoCollectionInfo = aVar;
                            ((IPublicAccountImageCollectionPreloadManager) QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).saveImageCollectionInfo(aVar, bArr);
                            PublicAccountImageCollectionMainActivityImpl.this.doAfterGetPhotoCollectionInfo();
                        } else {
                            PublicAccountImageCollectionMainActivityImpl.this.mUIHandler.postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl.3.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (PublicAccountImageCollectionMainActivityImpl.this.mAdapter == null || PublicAccountImageCollectionMainActivityImpl.this.mAdapter == null) {
                                        return;
                                    }
                                    PublicAccountImageCollectionMainActivityImpl.this.mAdapter.D(true);
                                    PublicAccountImageCollectionMainActivityImpl.this.mAdapter.notifyDataSetChanged();
                                }
                            }, 0L);
                        }
                    } else if (aVar != null) {
                        if (QLog.isColorLevel()) {
                            QLog.d("qqBaseActivity", 2, "onGetPhotoCollectionInfoRespond isSuccess=" + z16 + " ;articleID = " + aVar.f79733a);
                        }
                        ((IPublicAccountImageCollectionPreloadManager) QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).saveImageCollectionInfo(aVar, bArr);
                        ((IPublicAccountImageCollectionPreloadManager) QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).preloadImage(aVar);
                    }
                } else {
                    PublicAccountImageCollectionMainActivityImpl.this.mUIHandler.postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl.3.4
                        @Override // java.lang.Runnable
                        public void run() {
                            if (PublicAccountImageCollectionMainActivityImpl.this.mAdapter == null || PublicAccountImageCollectionMainActivityImpl.this.mAdapter == null) {
                                return;
                            }
                            PublicAccountImageCollectionMainActivityImpl.this.mAdapter.D(true);
                            PublicAccountImageCollectionMainActivityImpl.this.mAdapter.notifyDataSetChanged();
                        }
                    }, 0L);
                }
                int size = (aVar == null || (arrayList = aVar.f79741i) == null) ? 0 : arrayList.size();
                IPublicAccountReportUtils iPublicAccountReportUtils = (IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class);
                PublicAccountImageCollectionMainActivityImpl publicAccountImageCollectionMainActivityImpl = PublicAccountImageCollectionMainActivityImpl.this;
                String str2 = publicAccountImageCollectionMainActivityImpl.puin;
                String str3 = publicAccountImageCollectionMainActivityImpl.articleID;
                String str4 = publicAccountImageCollectionMainActivityImpl.webUrl;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("");
                PublicAccountImageCollectionMainActivityImpl publicAccountImageCollectionMainActivityImpl2 = PublicAccountImageCollectionMainActivityImpl.this;
                sb5.append(publicAccountImageCollectionMainActivityImpl2.getSourceType(publicAccountImageCollectionMainActivityImpl2.report_source));
                iPublicAccountReportUtils.publicAccountReportClickEvent(null, str2, "0X8007B8A", "0X8007B8A", 0, 0, str3, str4, sb5.toString(), "" + size, false);
            }
        });
        this.mPublicAccountArticleHandler.setPublicAccountArticleObserver(this.mPublicAccountArticleObserver);
    }

    private void initUI() {
        this.mDensity = getResources().getDisplayMetrics().density;
        setFullScreen();
        this.mUIHandler = new Handler();
        ImageView imageView = (ImageView) super.findViewById(R.id.ddh);
        this.titleLeft = imageView;
        imageView.setOnClickListener(this);
        ImageView imageView2 = (ImageView) super.findViewById(R.id.ddi);
        this.titleRight = imageView2;
        imageView2.setOnClickListener(this);
        this.relativeLayout = (RelativeLayout) super.findViewById(R.id.iez);
        PublicAccountImageCollectionListView publicAccountImageCollectionListView = (PublicAccountImageCollectionListView) super.findViewById(R.id.dda);
        this.mListView = publicAccountImageCollectionListView;
        publicAccountImageCollectionListView.setVerticalScrollBarEnabled(false);
        this.mListView.setDividerHeight(0);
        this.viewGroup = (ViewGroup) getWindow().getDecorView();
        this.mAdapter = new com.tencent.biz.pubaccount.imagecollection.b(this, this.mListView, (QQAppInterface) super.getAppInterface());
        this.mListView.setSmoothScrollbarEnabled(false);
        this.mListView.setOnTouchListener(new d());
        this.mUserGuide = (LinearLayout) super.findViewById(R.id.kl7);
        this.writeCommentImage = (ImageView) super.findViewById(R.id.ddj);
        this.commentImage = (ImageView) super.findViewById(R.id.f165761dd3);
        this.commentCountText = (TextView) super.findViewById(R.id.f165760dd2);
        this.zanImage = (ImageView) super.findViewById(R.id.ddl);
        this.zanCountText = (TextView) super.findViewById(R.id.ddk);
        this.shareImage = (ImageView) super.findViewById(R.id.ddf);
        this.commentTextView = (TextView) super.findViewById(R.id.f165762dd4);
        this.writeCommentImage.setOnClickListener(this);
        this.commentImage.setOnClickListener(this);
        this.zanImage.setOnClickListener(this);
        this.shareImage.setOnClickListener(this);
        this.commentTextView.setOnClickListener(this);
        this.zanCountText.setOnClickListener(this);
        this.commentCountText.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reSetCenterView() {
        this.viewGroup.removeView(this.publicAccountMainImageView);
        this.flag = false;
    }

    private void reportItemEvent(int i3) {
        ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.puin, "0X8007A7A", "0X8007A7A", 0, 0, this.articleID, this.webUrl, "" + getSourceType(this.report_source), "" + i3, false);
    }

    private void reportItemEventRightTitle(int i3) {
        ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.puin, "0X8007C18", "0X8007C18", 0, 0, this.articleID, this.webUrl, "" + i3, "", false);
    }

    private void setCommentText(String str) {
        if (this.commentTextView == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.commentTextView.setText(str);
    }

    private void shareToMobileQQ() {
        AbsShareMsg a16 = new AbsShareMsg.a(StructMsgForGeneralShare.class).g(79).b("web", this.webUrl, SCHEMATITLE + this.articleID, "", "").d(HardCodeUtil.qqStr(R.string.pn6) + this.webName).a();
        String str = this.webImg;
        com.tencent.mobileqq.structmsg.a c16 = com.tencent.mobileqq.structmsg.h.c(2);
        c16.o(str, this.webName, this.webDes);
        a16.addItem(c16);
        Intent intent = new Intent();
        intent.putExtra(AppConstants.Key.FORWARD_THUMB, this.webImg);
        intent.putExtra("forward_type", -3);
        intent.putExtra(AppConstants.Key.STRUCT_MSG_BYTES, a16.getBytes());
        ForwardBaseOption.startForwardActivityForResult(this, intent, 21);
    }

    private void showCommentPanel() {
        Intent intent = new Intent(this, (Class<?>) PublicAccountImageCollectionCommentActivity.class);
        if (!TextUtils.isEmpty(this.mCommentDraft)) {
            intent.putExtra("comment", this.mCommentDraft);
        }
        intent.putExtra("anonymous", this.mIsAnonymous);
        startActivityForResult(intent, 100);
        ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.puin, "0X8007B9A", "0X8007B9A", 0, 0, this.articleID, this.webUrl, "", "", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showCommentResult(boolean z16, int i3) {
        final Dialog dialog = new Dialog(this, R.style.f173947nn);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setContentView(R.layout.f168412vf);
        if (z16) {
            this.mIsAnonymous = false;
        } else if (i3 == 6) {
            ((TextView) dialog.findViewById(R.id.l4s)).setText(R.string.d5v);
        } else if (i3 == 10) {
            ((TextView) dialog.findViewById(R.id.l4s)).setText(R.string.d5u);
        } else {
            ((TextView) dialog.findViewById(R.id.l4s)).setText(R.string.d5t);
        }
        dialog.show();
        this.mUIHandler.postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl.10
            @Override // java.lang.Runnable
            public void run() {
                dialog.dismiss();
            }
        }, 1000L);
    }

    protected void addToFavorite(String str, boolean z16) {
        AppInterface appInterface = this.mApp;
        if (appInterface == null) {
            return;
        }
        String currentAccountUin = appInterface.getCurrentAccountUin();
        QfavBuilder.a0(str).F(currentAccountUin).e(this, currentAccountUin, 101, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        this.startTime = System.currentTimeMillis();
        this.mNeedStatusTrans = false;
        this.mActNeedImmersive = false;
        super.doOnCreate(bundle);
        super.setContentView(R.layout.f168415vi);
        initUI();
        initData();
        initHandlerAndObserver();
        fetchAllArticleInfo();
        this.mScaleGestureDetector = new ScaleGestureDetector(this, new j());
        this.mContext = getBaseContext();
        if (VersionUtils.isIceScreamSandwich()) {
            getWindow().setFlags(16777216, 16777216);
        }
        com.tencent.biz.pubaccount.imagecollection.a.b().e(this);
        com.tencent.biz.pubaccount.imagecollection.a.b().f();
        return true;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        Handler handler = this.mUIHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.mUIHandler = null;
        }
        PublicAccountImageCollectionListView publicAccountImageCollectionListView = this.mListView;
        if (publicAccountImageCollectionListView != null) {
            publicAccountImageCollectionListView.e0();
        }
        com.tencent.biz.pubaccount.imagecollection.b bVar = this.mAdapter;
        if (bVar != null) {
            bVar.n();
        }
        if (this.mContext != null) {
            this.mContext = null;
        }
        Handler handler2 = this.mHandler;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
        if (this.mPublicAccountArticleHandler != null) {
            if (com.tencent.biz.pubaccount.imagecollection.a.b().a() == 1) {
                this.mPublicAccountArticleHandler.removePublicAccountArticleObserver();
            }
            this.mPublicAccountArticleHandler = null;
        }
        dismissGuideAnim();
        ((IImageManager) QRoute.api(IImageManager.class)).clean();
        com.tencent.biz.pubaccount.imagecollection.a.b().c(this);
        ((IPublicAccountImageCollectionPreloadManager) QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).removeObserver();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        super.doOnPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        updateFollowState();
        com.tencent.biz.pubaccount.imagecollection.b bVar = this.mAdapter;
        if (bVar != null) {
            bVar.o();
        }
    }

    public void hideUserGuide() {
        if (this.mUserGuide.getVisibility() == 8) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("qqBaseActivity", 2, "hide user guide");
        }
        dismissGuideAnim();
        this.mUIHandler.post(new Runnable() { // from class: com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl.6
            @Override // java.lang.Runnable
            public void run() {
                PublicAccountImageCollectionMainActivityImpl.this.mUserGuide.setVisibility(8);
                PublicAccountImageCollectionMainActivityImpl.this.mUserGuide.findViewById(R.id.kld).setVisibility(8);
                PublicAccountImageCollectionMainActivityImpl.this.mUserGuide.findViewById(R.id.kl8).setVisibility(8);
                PublicAccountImageCollectionMainActivityImpl.this.mUserGuide.findViewById(R.id.kl9).setVisibility(8);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id5 = view.getId();
        if (id5 != R.id.ddf) {
            switch (id5) {
                case R.id.f165760dd2 /* 2131372841 */:
                    showComment();
                    return;
                case R.id.f165761dd3 /* 2131372842 */:
                    showComment();
                    return;
                case R.id.f165762dd4 /* 2131372843 */:
                    writeComment();
                    return;
                default:
                    switch (id5) {
                        case R.id.ddh /* 2131372857 */:
                            doOnBackPressed();
                            break;
                        case R.id.ddi /* 2131372858 */:
                            break;
                        case R.id.ddj /* 2131372859 */:
                            writeComment();
                            return;
                        case R.id.ddk /* 2131372860 */:
                            zan();
                            return;
                        case R.id.ddl /* 2131372861 */:
                            zan();
                            return;
                        default:
                            return;
                    }
                    showMoreView();
                    return;
            }
        }
        share();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        String str;
        Object tag = view.getTag();
        if (tag == null) {
            return;
        }
        if (this.actionSheet.isShowing()) {
            this.actionSheet.dismiss();
        }
        int i16 = ((i) tag).f79788c.f79325d;
        String str2 = this.webUrl;
        if (i16 == 1) {
            ((ClipboardManager) getSystemService("clipboard")).setText(str2);
            com.tencent.biz.qrcode.util.h.T(2, R.string.aev);
            reportItemEventRightTitle(1011);
            return;
        }
        if (i16 == 11) {
            try {
                str = URLEncoder.encode(str2, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                if (QLog.isColorLevel()) {
                    QLog.d("qqBaseActivity", 2, "encode url failed, because UTF-8 is unknown");
                }
                str = null;
            }
            String valueOf = String.valueOf(NetConnInfoCenter.getServerTime());
            String str3 = "https://jubao.mp.qq.com/mobile/report?qq=" + this.uin + "&mp_uin=" + this.puin + "&scene=200&sub_appname=article_webview&timestamp=" + valueOf + "&sign=" + MD5Utils.encodeHexStr(str + 200 + valueOf + "jubao@article@123").toLowerCase() + "&article_url=" + str;
            Intent intent = new Intent(this, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", str3);
            intent.putExtra("hide_more_button", true);
            startActivity(intent);
            reportItemEventRightTitle(1008);
            return;
        }
        if (i16 == 2) {
            shareToMobileQQ();
            reportItemEvent(1001);
            if (this.whereShow == 2) {
                reportItemEventRightTitle(1001);
                return;
            }
            return;
        }
        if (i16 == 4) {
            Intent intent2 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(str2));
            intent2.putExtra("normal", true);
            try {
                startActivity(intent2);
                reportItemEventRightTitle(1006);
                return;
            } catch (ActivityNotFoundException unused2) {
                com.tencent.biz.qrcode.util.h.T(1, R.string.d6f);
                return;
            }
        }
        if (i16 == 3) {
            au.b(this.mApp, this, this.webImg, this.webName, this.webDes, str2);
            reportItemEvent(1002);
            if (this.whereShow == 2) {
                reportItemEventRightTitle(1002);
                return;
            }
            return;
        }
        if (i16 == 6) {
            addToFavorite(str2, true);
            reportItemEventRightTitle(1007);
            return;
        }
        if (i16 == 9 || i16 == 10) {
            if (i16 == 9) {
                reportItemEvent(1003);
                if (this.whereShow == 2) {
                    reportItemEventRightTitle(1003);
                }
            } else {
                reportItemEvent(1004);
                if (this.whereShow == 2) {
                    reportItemEventRightTitle(1004);
                }
            }
            PublicAccountImageCollectionUtilsImpl.shareToWechatWithThumb(this, this.webName, this.webDes, str2, this.thumbBitmap, i16);
        }
    }

    void setFullScreen() {
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            super.getWindow().addFlags(67108864);
        }
        if (SystemBarActivityModule.getSystemBarComp(this) != null) {
            int color = getResources().getColor(R.color.ajr);
            SystemBarActivityModule.getSystemBarComp(this).setStatusColor(color);
            SystemBarActivityModule.getSystemBarComp(this).setStatusBarColor(color);
        }
        if (VersionUtils.isJellyBean() && VersionUtils.isHoneycomb()) {
            getWindow().getDecorView().setSystemUiVisibility(4102);
        }
        if (VersionUtils.isHoneycomb()) {
            getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new e());
        }
    }

    public void showActionSheet(int i3) {
        if (isFinishing() || this.mAdapter == null) {
            return;
        }
        if (this.actionSheet == null) {
            this.actionSheet = (ActionSheet) ActionSheetHelper.createDialog(this, null);
            this.actionSheet.setActionContentView(createViewFlipper(i3), null);
        } else {
            this.actionSheet.setActionContentView(createViewFlipper(i3), null);
        }
        try {
            if (!this.actionSheet.isShowing()) {
                this.actionSheet.show();
                if (i3 == 2) {
                    this.whereShow = 2;
                    ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.puin, "0X8007A79", "0X8007A79", 0, 0, this.articleID, this.webUrl, "", "", false);
                } else {
                    this.whereShow = 1;
                    ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.puin, "0X8007A80", "0X8007A80", 0, 0, this.articleID, this.webUrl, "", "", false);
                }
            }
        } catch (Exception unused) {
        }
    }

    void showComment() {
        IPublicAccountImageCollectionUtils.a aVar = this.photoCollectionInfo;
        if (aVar == null || TextUtils.isEmpty(aVar.f79734b)) {
            return;
        }
        Intent intent = new Intent(this, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", this.photoCollectionInfo.f79739g);
        intent.putExtra("hide_more_button", true);
        startActivity(intent);
    }

    public void showUserGuide() {
        if (this.mUserGuide.getVisibility() == 0) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("qqBaseActivity", 2, "show user guide");
        }
        TranslateAnimation translateAnimation = this.mTranslateAnimationUp;
        if (translateAnimation != null) {
            translateAnimation.cancel();
        }
        TranslateAnimation translateAnimation2 = this.mTranslateAnimationDown;
        if (translateAnimation2 != null) {
            translateAnimation2.cancel();
        }
        TranslateAnimation translateAnimation3 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, -0.2f);
        this.mTranslateAnimationUp = translateAnimation3;
        translateAnimation3.setDuration(200L);
        this.mTranslateAnimationUp.setFillAfter(true);
        TranslateAnimation translateAnimation4 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -0.2f, 1, 0.0f);
        this.mTranslateAnimationDown = translateAnimation4;
        translateAnimation4.setDuration(300L);
        this.mTranslateAnimationDown.setFillAfter(true);
        this.mTranslateAnimationUp.setAnimationListener(new f());
        this.mTranslateAnimationDown.setAnimationListener(new g());
        this.mUIHandler.postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl.9
            @Override // java.lang.Runnable
            public void run() {
                TranslateAnimation translateAnimation5 = PublicAccountImageCollectionMainActivityImpl.this.mTranslateAnimationUp;
                if (translateAnimation5 != null) {
                    PublicAccountImageCollectionMainActivityImpl.this.mUserGuide.setVisibility(0);
                    PublicAccountImageCollectionMainActivityImpl.this.mUserGuide.findViewById(R.id.kld).setVisibility(0);
                    PublicAccountImageCollectionMainActivityImpl.this.mUserGuide.findViewById(R.id.kl8).setVisibility(0);
                    PublicAccountImageCollectionMainActivityImpl.this.mUserGuide.findViewById(R.id.kl9).setVisibility(0);
                    PublicAccountImageCollectionMainActivityImpl.this.mUserGuide.bringToFront();
                    PublicAccountImageCollectionMainActivityImpl.this.mUserGuide.startAnimation(translateAnimation5);
                }
            }
        }, 300L);
    }

    void updateFollowState() {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl.16
            @Override // java.lang.Runnable
            public void run() {
                IPublicAccountDataManager iPublicAccountDataManager;
                if (TextUtils.isEmpty(PublicAccountImageCollectionMainActivityImpl.this.puin) || (iPublicAccountDataManager = (IPublicAccountDataManager) PublicAccountImageCollectionMainActivityImpl.this.mApp.getRuntimeService(IPublicAccountDataManager.class, "all")) == null) {
                    return;
                }
                PublicAccountImageCollectionMainActivityImpl publicAccountImageCollectionMainActivityImpl = PublicAccountImageCollectionMainActivityImpl.this;
                publicAccountImageCollectionMainActivityImpl.isFollowed = iPublicAccountDataManager.isFollowedUin(Long.valueOf(publicAccountImageCollectionMainActivityImpl.puin));
                PublicAccountImageCollectionMainActivityImpl.this.mUIHandler.postDelayed(new Runnable() { // from class: com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl.16.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (PublicAccountImageCollectionMainActivityImpl.this.mAdapter != null) {
                            PublicAccountImageCollectionMainActivityImpl.this.mAdapter.F(PublicAccountImageCollectionMainActivityImpl.this.isFollowed);
                        }
                    }
                }, 0L);
            }
        }, 5, null, true);
    }

    void writeComment() {
        showCommentPanel();
    }

    void zan() {
        boolean z16 = !this.isLiked;
        this.isLiked = z16;
        if (z16) {
            this.likeCount++;
            this.zanImage.setImageResource(R.drawable.d6r);
            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.puin, "0X8007B95", "0X8007B95", 0, 0, this.articleID, this.webUrl, "", "", false);
        } else {
            this.likeCount--;
            this.zanImage.setImageResource(R.drawable.d6q);
            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.puin, "0X8007B96", "0X8007B96", 0, 0, this.articleID, this.webUrl, "", "", false);
        }
        this.zanCountText.setText("" + this.likeCount);
        this.mPublicAccountArticleHandler.sendArticleLikeReq(this.articleID, this.isLiked, false);
    }

    /* loaded from: classes32.dex */
    public static class h extends ArrayAdapter<IPublicAccountBrowser.a> {

        /* renamed from: d, reason: collision with root package name */
        private List<IPublicAccountBrowser.a> f79784d;

        /* renamed from: e, reason: collision with root package name */
        private LayoutInflater f79785e;

        public h(Context context, int i3, List<IPublicAccountBrowser.a> list) {
            super(context, i3, list);
            this.f79784d = list;
            this.f79785e = LayoutInflater.from(context);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public IPublicAccountBrowser.a getItem(int i3) {
            return this.f79784d.get(i3);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public int getCount() {
            return this.f79784d.size();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            i iVar;
            if (view == null) {
                view = this.f79785e.inflate(R.layout.f167941nl, (ViewGroup) null);
                iVar = new i();
                iVar.f79787b = (ImageView) view.findViewById(R.id.g3p);
                iVar.f79786a = (TextView) view.findViewById(R.id.g3q);
                view.setTag(iVar);
            } else {
                iVar = (i) view.getTag();
            }
            IPublicAccountBrowser.a item = getItem(i3);
            iVar.f79788c = item;
            iVar.f79786a.setText(item.f79324c);
            iVar.f79787b.setBackgroundResource(item.f79322a);
            return view;
        }
    }

    /* loaded from: classes32.dex */
    private class j implements ScaleGestureDetector.OnScaleGestureListener {
        j() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            ZImageView zImageView;
            PublicAccountImageCollectionMainActivityImpl.this.scale = scaleGestureDetector.getScaleFactor();
            if (QLog.isColorLevel()) {
                QLog.d("qqBaseActivity", 2, "\u7f29\u653e\u6bd4\u4f8b\u662f" + PublicAccountImageCollectionMainActivityImpl.this.scale);
            }
            QLog.d("qqBaseActivity", 2, "catch zoom");
            if (PublicAccountImageCollectionMainActivityImpl.this.flag) {
                if (PublicAccountImageCollectionMainActivityImpl.this.publicAccountMainImageView.getScaleType() != ImageView.ScaleType.MATRIX) {
                    PublicAccountImageCollectionMainActivityImpl.this.publicAccountMainImageView.setScaleType(ImageView.ScaleType.MATRIX);
                }
                PublicAccountImageCollectionMainActivityImpl publicAccountImageCollectionMainActivityImpl = PublicAccountImageCollectionMainActivityImpl.this;
                publicAccountImageCollectionMainActivityImpl.mCurrentMatrix.set(publicAccountImageCollectionMainActivityImpl.publicAccountMainImageView.getImageMatrix());
                PublicAccountImageCollectionMainActivityImpl publicAccountImageCollectionMainActivityImpl2 = PublicAccountImageCollectionMainActivityImpl.this;
                publicAccountImageCollectionMainActivityImpl2.mCurrentMatrix.getValues(publicAccountImageCollectionMainActivityImpl2.currentValues);
                PublicAccountImageCollectionMainActivityImpl publicAccountImageCollectionMainActivityImpl3 = PublicAccountImageCollectionMainActivityImpl.this;
                float f16 = publicAccountImageCollectionMainActivityImpl3.currentValues[0];
                float f17 = publicAccountImageCollectionMainActivityImpl3.initValues[0];
                if (f16 > f17 * 3.0f) {
                    publicAccountImageCollectionMainActivityImpl3.scale = (f17 * 3.0f) / f16;
                    if (QLog.isColorLevel()) {
                        QLog.d("qqBaseActivity", 2, "the last scale is" + PublicAccountImageCollectionMainActivityImpl.this.scale);
                    }
                }
                PublicAccountImageCollectionMainActivityImpl publicAccountImageCollectionMainActivityImpl4 = PublicAccountImageCollectionMainActivityImpl.this;
                publicAccountImageCollectionMainActivityImpl4.matrix.set(publicAccountImageCollectionMainActivityImpl4.mCurrentMatrix);
                PublicAccountImageCollectionMainActivityImpl publicAccountImageCollectionMainActivityImpl5 = PublicAccountImageCollectionMainActivityImpl.this;
                Matrix matrix = publicAccountImageCollectionMainActivityImpl5.matrix;
                float f18 = publicAccountImageCollectionMainActivityImpl5.scale;
                matrix.postScale(f18, f18, publicAccountImageCollectionMainActivityImpl5.publicAccountMainImageView.getWidth() / 2, PublicAccountImageCollectionMainActivityImpl.this.publicAccountMainImageView.getHeight() / 2);
                PublicAccountImageCollectionMainActivityImpl.this.publicAccountMainImageView.setImageMatrix(PublicAccountImageCollectionMainActivityImpl.this.matrix);
            } else {
                PublicAccountImageCollectionMainActivityImpl publicAccountImageCollectionMainActivityImpl6 = PublicAccountImageCollectionMainActivityImpl.this;
                publicAccountImageCollectionMainActivityImpl6.centerView = publicAccountImageCollectionMainActivityImpl6.mListView.g0();
                ViewGroup viewGroup = PublicAccountImageCollectionMainActivityImpl.this.centerView;
                if (viewGroup != null && (viewGroup.getTag() instanceof b.h) && (zImageView = (ZImageView) PublicAccountImageCollectionMainActivityImpl.this.centerView.getChildAt(0)) != null) {
                    PublicAccountImageCollectionMainActivityImpl.this.drawable = zImageView.getDrawable();
                    int width = zImageView.getWidth();
                    int height = zImageView.getHeight();
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    layoutParams.addRule(15);
                    PublicAccountImageCollectionMainActivityImpl.this.initMatrix = zImageView.getImageMatrix();
                    PublicAccountImageCollectionMainActivityImpl publicAccountImageCollectionMainActivityImpl7 = PublicAccountImageCollectionMainActivityImpl.this;
                    publicAccountImageCollectionMainActivityImpl7.initMatrix.getValues(publicAccountImageCollectionMainActivityImpl7.initValues);
                    PublicAccountImageCollectionMainActivityImpl publicAccountImageCollectionMainActivityImpl8 = PublicAccountImageCollectionMainActivityImpl.this;
                    publicAccountImageCollectionMainActivityImpl8.matrix.set(publicAccountImageCollectionMainActivityImpl8.initMatrix);
                    PublicAccountImageCollectionMainActivityImpl publicAccountImageCollectionMainActivityImpl9 = PublicAccountImageCollectionMainActivityImpl.this;
                    PublicAccountImageCollectionMainActivityImpl publicAccountImageCollectionMainActivityImpl10 = PublicAccountImageCollectionMainActivityImpl.this;
                    publicAccountImageCollectionMainActivityImpl9.publicAccountMainImageView = new PublicAccountImageView(publicAccountImageCollectionMainActivityImpl10.mContext, publicAccountImageCollectionMainActivityImpl10.mHandler, publicAccountImageCollectionMainActivityImpl10.initMatrix, publicAccountImageCollectionMainActivityImpl10.zoomEvent, width, height);
                    PublicAccountImageCollectionMainActivityImpl.this.publicAccountMainImageView.setImageDrawable(PublicAccountImageCollectionMainActivityImpl.this.drawable);
                    PublicAccountImageCollectionMainActivityImpl.this.publicAccountMainImageView.setImageMatrix(PublicAccountImageCollectionMainActivityImpl.this.matrix);
                    PublicAccountImageCollectionMainActivityImpl publicAccountImageCollectionMainActivityImpl11 = PublicAccountImageCollectionMainActivityImpl.this;
                    publicAccountImageCollectionMainActivityImpl11.viewGroup.addView(publicAccountImageCollectionMainActivityImpl11.publicAccountMainImageView, layoutParams);
                    PublicAccountImageCollectionMainActivityImpl.this.flag = true;
                    int i3 = ((b.h) PublicAccountImageCollectionMainActivityImpl.this.centerView.getTag()).f79840f;
                    if (PublicAccountImageCollectionMainActivityImpl.this.mAdapter.F != null) {
                        String str = PublicAccountImageCollectionMainActivityImpl.this.mAdapter.F.get(i3 - 1).f79746a;
                        IPublicAccountReportUtils iPublicAccountReportUtils = (IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class);
                        PublicAccountImageCollectionMainActivityImpl publicAccountImageCollectionMainActivityImpl12 = PublicAccountImageCollectionMainActivityImpl.this;
                        iPublicAccountReportUtils.publicAccountReportClickEvent(null, publicAccountImageCollectionMainActivityImpl12.puin, "0X8007B91", "0X8007B91", 0, 0, publicAccountImageCollectionMainActivityImpl12.articleID, publicAccountImageCollectionMainActivityImpl12.webUrl, str, "1", false);
                    }
                }
                PublicAccountImageCollectionMainActivityImpl.this.mListView.m0();
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runShowAnimation(View view, View view2, long j3, long j16) {
        view.setAlpha(0.0f);
        view.setVisibility(0);
        view2.setAlpha(0.0f);
        view2.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view2, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
        ofFloat.setDuration(JoinTimeType.THIRTY_MINUTES);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setStartDelay(j3);
        ofFloat2.setDuration(JoinTimeType.THIRTY_MINUTES);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(1);
        ofFloat2.setStartDelay(j16);
        if (this.mAlphaset == null) {
            this.mAlphaset = new AnimatorSet();
        }
        this.mAlphaset.playTogether(ofFloat, ofFloat2);
        this.mAlphaset.start();
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        reportOntime(1, 0, "");
        super.doOnBackPressed();
        ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.puin, "0X8007B8F", "0X8007B8F", 0, 0, this.articleID, this.webUrl, "", "", false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        requestWindowFeature(1);
        getWindow().setFormat(-3);
    }

    void share() {
        showActionSheet(1);
    }

    void showMoreView() {
        showActionSheet(2);
    }

    public void reportOntime(int i3, int i16, String str) {
        if (this.hasReport) {
            return;
        }
        this.hasReport = true;
        if (this.photoCollectionInfo != null) {
            int currentTimeMillis = (int) (System.currentTimeMillis() - this.startTime);
            this.mPublicAccountArticleHandler.reportReadPhotoCollection(this.articleID, this.puin, this.photoCollectionInfo.f79734b, i3, i16, str, currentTimeMillis, this.recommendItemInfos);
            ArrayList<IPublicAccountImageCollectionUtils.c> arrayList = this.photoCollectionInfo.f79741i;
            int i17 = 0;
            if (arrayList != null) {
                Iterator<IPublicAccountImageCollectionUtils.c> it = arrayList.iterator();
                while (it.hasNext()) {
                    if (it.next().f79751f) {
                        i17++;
                    }
                }
            }
            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.puin, "0X8007B8B", "0X8007B8B", 0, 0, this.articleID, this.webUrl, "" + currentTimeMillis, "" + i17, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class e implements View.OnSystemUiVisibilityChangeListener {
        e() {
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i3) {
            if (i3 != 4102 && VersionUtils.isHoneycomb()) {
                PublicAccountImageCollectionMainActivityImpl.this.getWindow().getDecorView().setSystemUiVisibility(4102);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getSourceType(int i3) {
        if (i3 == 0) {
            return C2C_SOURCE;
        }
        if (i3 == 1) {
            return TROOP_SOURCE;
        }
        if (i3 != 3000) {
            return 16;
        }
        return DISCUSSION_SOURCE;
    }

    private void initData(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            URLDrawable drawable = URLDrawable.getDrawable(str, (Drawable) null, (Drawable) null);
            if (drawable.getStatus() == 1 && (drawable.getCurrDrawable() instanceof RegionDrawable)) {
                this.thumbBitmap = ((RegionDrawable) drawable.getCurrDrawable()).getBitmap();
            } else {
                drawable.setURLDrawableListener(new b(drawable));
                drawable.startDownload();
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("qqBaseActivity", 2, "initData", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        if (i3 == 21) {
            if (i16 != -1) {
                return;
            }
            ForwardUtils.w((QQAppInterface) this.mApp, this, getApplicationContext(), intent, null);
            return;
        }
        if (i3 != 100) {
            if (i3 != 101) {
                return;
            }
            QfavBuilder.l0(this, intent);
        } else if (intent != null) {
            this.mCommentDraft = intent.getStringExtra("comment");
            this.mIsAnonymous = intent.getBooleanExtra("anonymous", false);
            if (i16 == 0) {
                setCommentText(this.mCommentDraft);
            } else if (i16 == -1) {
                setCommentText(getString(R.string.d5r));
                ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl.13
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean z16 = PublicAccountImageCollectionMainActivityImpl.this.mIsAnonymous;
                        IPublicAccountArticleHandler iPublicAccountArticleHandler = PublicAccountImageCollectionMainActivityImpl.this.mPublicAccountArticleHandler;
                        PublicAccountImageCollectionMainActivityImpl publicAccountImageCollectionMainActivityImpl = PublicAccountImageCollectionMainActivityImpl.this;
                        iPublicAccountArticleHandler.createArticleComment(publicAccountImageCollectionMainActivityImpl.webUrl, publicAccountImageCollectionMainActivityImpl.mCommentDraft, z16 ? 1 : 0);
                        PublicAccountImageCollectionMainActivityImpl.this.mCommentDraft = "";
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ URLDrawable f79777d;

        b(URLDrawable uRLDrawable) {
            this.f79777d = uRLDrawable;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            if (this.f79777d.getStatus() == 1 && (this.f79777d.getCurrDrawable() instanceof RegionDrawable)) {
                RegionDrawable regionDrawable = (RegionDrawable) this.f79777d.getCurrDrawable();
                PublicAccountImageCollectionMainActivityImpl.this.thumbBitmap = regionDrawable.getBitmap();
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class f implements Animation.AnimationListener {
        f() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            PublicAccountImageCollectionMainActivityImpl publicAccountImageCollectionMainActivityImpl = PublicAccountImageCollectionMainActivityImpl.this;
            publicAccountImageCollectionMainActivityImpl.mUserGuide.startAnimation(publicAccountImageCollectionMainActivityImpl.mTranslateAnimationDown);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class g implements Animation.AnimationListener {
        g() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            ImageView imageView = (ImageView) PublicAccountImageCollectionMainActivityImpl.this.findViewById(R.id.kl8);
            PublicAccountImageCollectionMainActivityImpl.this.runShowAnimation((ImageView) PublicAccountImageCollectionMainActivityImpl.this.findViewById(R.id.kl9), imageView, 100L, 240L);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
