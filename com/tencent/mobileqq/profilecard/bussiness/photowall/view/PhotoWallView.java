package com.tencent.mobileqq.profilecard.bussiness.photowall.view;

import NS_MOBILE_MAIN_PAGE.PhotoWall;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.profilecard.base.view.RoundCorneredFrameLayout;
import com.tencent.mobileqq.profilecard.bussiness.photowall.bean.NowShowVideoInfo;
import com.tencent.mobileqq.profilecard.bussiness.photowall.bean.ProfilePhotoWall;
import com.tencent.mobileqq.profilecard.bussiness.photowall.bean.QZonePhotoInfo;
import com.tencent.mobileqq.profilecard.bussiness.photowall.bean.QZonePhotoWall;
import com.tencent.mobileqq.profilecard.bussiness.photowall.handler.NowOnliveGallayCallback;
import com.tencent.mobileqq.profilecard.bussiness.photowall.handler.OnGetPhotoWallListener;
import com.tencent.mobileqq.profilecard.bussiness.photowall.handler.PhotoWallHandler;
import com.tencent.mobileqq.profilecard.preload.IProfileViewLoader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tencent.im.ilive.photo.NowLiveGallary$RspBody;

/* loaded from: classes16.dex */
public class PhotoWallView extends RoundCorneredFrameLayout implements Handler.Callback, OnGetPhotoWallListener, View.OnClickListener {
    static IPatchRedirector $redirector_ = null;
    private static final int MAX_PHOTO_WALL_COUNT = 9;
    private static final int MSG_ADD_NOW_VIDEO_GALLERY = 4;
    private static final int MSG_LOAD_FROM_DATABASE = 1;
    private static final int MSG_LOAD_FROM_SERVER = 2;
    private static final int MSG_LOAD_PHOTO_WALL = 3;
    private static final int MSG_LOAD_PHOTO_WALL_FAILED = 5;
    private static final String TAG = "PhotoWallView";
    private boolean isBlock;
    protected Activity mActivity;
    protected AppInterface mApp;
    protected View mContentView;
    protected ImageView mEmptyBgCell0;
    protected ImageView mEmptyBgCell1;
    protected ImageView mEmptyBgCell2;
    protected View mEmptyBgView;
    public TextView mEmptyInfo;
    public TextView mEmptyTitle;
    public Button mEmptyUploadBtn;
    protected View mEmptyView;
    protected int mFetchFlag;
    protected Handler mHandler;
    protected LayoutInflater mInflater;
    protected PhotoWallUpdaterListener mListener;
    protected View mLoadTipsLayout;
    protected View mMoreLayout;
    protected TextView mMoreText;
    private NowOnliveGallayCallback mNowOnliveGallayCallback;
    protected ArrayList<ProfilePhotoWall> mNowVideoList;
    protected LinkedList<ProfilePhotoWall> mPhotoList;
    protected PhotoWallHandler mPhotoWallHandler;
    protected ProfileCardPhotoWallView mPhotoWallView;
    protected QZonePhotoCache mQZonePhotoCache;
    protected String mUin;
    protected IProfileViewLoader mViewLoader;

    /* loaded from: classes16.dex */
    private static class CustomNowOnliveGallayCallback extends NowOnliveGallayCallback {
        static IPatchRedirector $redirector_;
        private WeakReference<PhotoWallView> mRef;

        public CustomNowOnliveGallayCallback(PhotoWallView photoWallView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) photoWallView);
            } else {
                this.mRef = new WeakReference<>(photoWallView);
            }
        }

        @Override // com.tencent.mobileqq.profilecard.bussiness.photowall.handler.NowOnliveGallayCallback
        public void onGetNowOnliveGallay(int i3, List<NowLiveGallary$RspBody.PhotoInfo> list) {
            PhotoWallView photoWallView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) list);
                return;
            }
            WeakReference<PhotoWallView> weakReference = this.mRef;
            if (weakReference != null) {
                photoWallView = weakReference.get();
            } else {
                photoWallView = null;
            }
            if (photoWallView == null) {
                return;
            }
            if (i3 != 0) {
                if (QLog.isColorLevel()) {
                    QLog.d(NowOnliveGallayCallback.TAG, 2, "onGetNowOnliveGallay errorCode:" + i3);
                }
                photoWallView.mHandler.sendEmptyMessage(4);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(NowOnliveGallayCallback.TAG, 2, "onGetNowOnliveGallay size:" + list.size());
            }
            photoWallView.mNowVideoList.clear();
            for (int i16 = 0; i16 < list.size(); i16++) {
                NowLiveGallary$RspBody.PhotoInfo photoInfo = list.get(i16);
                photoWallView.mNowVideoList.add(new NowShowVideoInfo(photoInfo.cover.get().toStringUtf8(), photoInfo.video.get().toStringUtf8(), photoInfo.timestamp.get()));
            }
            if (photoWallView.mNowVideoList.size() > 0) {
                ReportController.o(this.mApp.get(), "dc00899", "NOW", "", "qq_zlk", "replay_exp", 0, 0, photoWallView.mUin, "", "", "");
            }
            photoWallView.mHandler.sendEmptyMessage(4);
        }
    }

    /* loaded from: classes16.dex */
    public interface PhotoWallUpdaterListener {
        void onUpdatePhotoWall(int i3);
    }

    /* loaded from: classes16.dex */
    public static class QZonePhotoCache {
        static IPatchRedirector $redirector_;
        public String attachInfo;
        public int curPicSize;
        public int hasMore;
        public int totalPic;

        public QZonePhotoCache() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public PhotoWallView(Context context, AppInterface appInterface, String str) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, appInterface, str);
            return;
        }
        this.mPhotoList = new LinkedList<>();
        this.mNowVideoList = new ArrayList<>();
        this.mNowOnliveGallayCallback = new CustomNowOnliveGallayCallback(this);
        this.isBlock = false;
        this.mActivity = (Activity) context;
        this.mApp = appInterface;
        this.mUin = str;
        onInit();
    }

    private void handlePhotoWallData(Message message) {
        ArrayList arrayList = (ArrayList) message.obj;
        if (arrayList != null) {
            this.mPhotoList.clear();
            this.mPhotoList.addAll(arrayList);
            if (this.mNowVideoList.size() != 0) {
                mergeListByTime(this.mPhotoList, this.mNowVideoList);
            }
            if (this.mPhotoList.size() > 9) {
                for (int size = this.mPhotoList.size() - 1; size >= 9; size--) {
                    this.mPhotoList.remove(size);
                }
            }
            ProfileCardPhotoWallView profileCardPhotoWallView = this.mPhotoWallView;
            LinkedList<ProfilePhotoWall> linkedList = this.mPhotoList;
            profileCardPhotoWallView.genImg(linkedList, linkedList.size(), this.mQZonePhotoCache.totalPic);
        }
    }

    public static void jumpToPhotoWall(Activity activity, String str, boolean z16) {
        String str2 = IProfileCardConst.URL_PHOTO_WALL;
        if (!z16) {
            str2 = str2 + "&uin=" + str;
        }
        Intent intent = new Intent();
        intent.putExtra("hide_more_button", true);
        intent.putExtra("hide_operation_bar", true);
        intent.putExtra("url", str2);
        if (!z16) {
            RouteUtils.startActivity(activity, intent, RouterConstants.UI_ROUTE_BROWSER);
        } else {
            RouteUtils.startActivityForResult(activity, intent, RouterConstants.UI_ROUTE_BROWSER, 100);
        }
    }

    public static List<ProfilePhotoWall> mergeListByTime(List<ProfilePhotoWall> list, List<ProfilePhotoWall> list2) {
        if (list2.size() == 0) {
            return list;
        }
        if (list.size() == 0) {
            list.addAll(list2);
            return list;
        }
        int i3 = 0;
        for (int i16 = 0; i16 < list2.size(); i16++) {
            ProfilePhotoWall profilePhotoWall = list2.get(i16);
            while (true) {
                if (i3 < list.size()) {
                    if (profilePhotoWall.time < list.get(i3).time) {
                        list.add(i3, profilePhotoWall);
                        i3++;
                        break;
                    }
                    i3++;
                }
            }
        }
        return list;
    }

    private void onInit() {
        onInitInner(true);
    }

    private void onInitInner(boolean z16) {
        View view;
        this.radius = getRoundCornerRadius();
        this.mInflater = LayoutInflater.from(getContext());
        this.mHandler = new Handler(Looper.getMainLooper(), this);
        this.mPhotoWallHandler = (PhotoWallHandler) this.mApp.getBusinessHandler(PhotoWallHandler.class.getName());
        IProfileViewLoader iProfileViewLoader = this.mViewLoader;
        if (iProfileViewLoader != null) {
            view = iProfileViewLoader.getViewById(getLayout());
            if (view != null && view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
                ((ViewGroup) view.getParent()).removeView(view);
                QLog.i(TAG, 1, "onInitInner,remove_view_first!");
            }
            if (view != null) {
                addView(view);
            }
        } else {
            view = null;
        }
        if (view == null) {
            view = this.mInflater.inflate(getLayout(), (ViewGroup) this, true);
        }
        View findViewById = view.findViewById(R.id.fqj);
        this.mContentView = findViewById;
        ProfileCardPhotoWallView profileCardPhotoWallView = (ProfileCardPhotoWallView) findViewById.findViewById(R.id.fqs);
        this.mPhotoWallView = profileCardPhotoWallView;
        profileCardPhotoWallView.setNewStyle(z16);
        this.mLoadTipsLayout = this.mContentView.findViewById(R.id.fqv);
        this.mMoreLayout = this.mContentView.findViewById(R.id.fqw);
        this.mMoreText = (TextView) this.mContentView.findViewById(R.id.fqx);
        this.mEmptyView = view.findViewById(R.id.fqk);
        this.mEmptyBgView = view.findViewById(R.id.fql);
        this.mEmptyBgCell0 = (ImageView) view.findViewById(R.id.fqm);
        this.mEmptyBgCell1 = (ImageView) view.findViewById(R.id.fqn);
        this.mEmptyBgCell2 = (ImageView) view.findViewById(R.id.fqo);
        this.mEmptyTitle = (TextView) view.findViewById(R.id.fqq);
        this.mEmptyInfo = (TextView) view.findViewById(R.id.fqp);
        this.mEmptyUploadBtn = (Button) this.mEmptyView.findViewById(R.id.fqr);
        this.mPhotoWallView.preparePhotoWall(this.mUin, this.mActivity, this.mApp);
        this.mMoreText.setOnClickListener(this);
        this.mEmptyBgView.setAlpha(0.15f);
        this.mEmptyUploadBtn.setOnClickListener(this);
        if (this.mApp.getCurrentAccountUin().equals(this.mUin)) {
            this.mMoreText.setText(R.string.d2v);
        } else {
            this.mMoreText.setText(R.string.d2u);
        }
        this.mMoreLayout.setVisibility(8);
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.profilecard.bussiness.photowall.view.PhotoWallView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhotoWallView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                QZonePhotoWall qZonePhotoWall = (QZonePhotoWall) DBMethodProxy.find(PhotoWallView.this.mApp.getEntityManagerFactory().createEntityManager(), (Class<? extends Entity>) QZonePhotoWall.class, PhotoWallView.this.mUin);
                if (qZonePhotoWall == null) {
                    PhotoWallView.this.mHandler.sendEmptyMessage(3);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                PhotoWallView.this.update(qZonePhotoWall.totalPic, qZonePhotoWall.hasMore, qZonePhotoWall.attachInfo, qZonePhotoWall.unpackPhotoWallData(), arrayList);
                Message obtainMessage = PhotoWallView.this.mHandler.obtainMessage(1);
                obtainMessage.obj = arrayList;
                PhotoWallView.this.mHandler.sendMessage(obtainMessage);
            }
        }, 5, null, true);
    }

    protected boolean enableEmptyView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return true;
    }

    protected int getLayout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return R.layout.b0i;
    }

    protected int getRoundCornerRadius() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return 0;
    }

    public int getTotalCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this, i3)).intValue();
        }
        QZonePhotoCache qZonePhotoCache = this.mQZonePhotoCache;
        if (qZonePhotoCache != null && i3 != 0) {
            return qZonePhotoCache.totalPic;
        }
        return i3;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, "handleMessage MSG_LOAD_PHOTO_WALL_FAILED");
                            }
                            this.mLoadTipsLayout.setVisibility(8);
                        }
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "handleMessage MSG_ADD_NOW_VIDEO_GALLERY");
                        }
                        this.mFetchFlag |= 16;
                        mergeListByTime(this.mPhotoList, this.mNowVideoList);
                        ProfileCardPhotoWallView profileCardPhotoWallView = this.mPhotoWallView;
                        LinkedList<ProfilePhotoWall> linkedList = this.mPhotoList;
                        profileCardPhotoWallView.genImg(linkedList, linkedList.size(), getTotalCount(this.mPhotoList.size()));
                        PhotoWallUpdaterListener photoWallUpdaterListener = this.mListener;
                        if (photoWallUpdaterListener != null && this.mFetchFlag == 17) {
                            photoWallUpdaterListener.onUpdatePhotoWall(this.mPhotoList.size());
                            updateViewStatus();
                        }
                    }
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "handleMessage MSG_LOAD_PHOTO_WALL");
                    }
                    this.mFetchFlag = 0;
                    this.mPhotoWallHandler.getQzonePhotoWall(this.mUin, "");
                    try {
                        this.mPhotoWallHandler.getNowOnliveGallary(Long.parseLong(this.mUin), this.mNowOnliveGallayCallback);
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e(TAG, 2, "handleMessage MSG_LOAD_PHOTO_WALL fail!", e16);
                        }
                        this.mHandler.sendEmptyMessage(5);
                    }
                    this.mHandler.removeMessages(3);
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "handleMessage MSG_LOAD_FROM_SERVER");
                }
                this.mFetchFlag |= 1;
                handlePhotoWallData(message);
                PhotoWallUpdaterListener photoWallUpdaterListener2 = this.mListener;
                if (photoWallUpdaterListener2 != null && this.mFetchFlag == 17) {
                    photoWallUpdaterListener2.onUpdatePhotoWall(this.mPhotoList.size());
                    updateViewStatus();
                }
                if (this.mQZonePhotoCache.hasMore != 1) {
                    this.mLoadTipsLayout.setVisibility(8);
                }
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "handleMessage MSG_LOAD_FROM_DATABASE");
            }
            handlePhotoWallData(message);
            if (this.mListener != null && this.mPhotoList.size() > 0) {
                this.mListener.onUpdatePhotoWall(this.mPhotoList.size());
            }
            updateViewStatus();
            Message obtain = Message.obtain();
            obtain.what = 3;
            handleMessage(obtain);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.photowall.handler.OnGetPhotoWallListener
    public boolean hasMore() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        QZonePhotoCache qZonePhotoCache = this.mQZonePhotoCache;
        if (qZonePhotoCache == null || qZonePhotoCache.hasMore != 1) {
            return false;
        }
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) view);
        } else {
            boolean equals = this.mApp.getCurrentAccountUin().equals(this.mUin);
            int id5 = view.getId();
            if (id5 == R.id.fqx) {
                peformClickMoreText();
                if (equals) {
                    ReportController.o(this.mApp, "dc00898", "", "", "0X8007EBE", "0X8007EBE", 0, 0, "", "", "", "");
                } else {
                    ReportController.o(this.mApp, "dc00898", "", "", "0X8007EBF", "0X8007EBF", 0, 0, "", "", "", "");
                }
            } else if (id5 == R.id.fqr) {
                ReportController.o(this.mApp, "dc00898", "", "", "0X8007EC0", "0X8007EC0", 0, 0, "", "", "", "");
                jumpToPhotoWall(this.mActivity, this.mUin, equals);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.photowall.handler.OnGetPhotoWallListener
    public void onGetQZonePhotoWall(boolean z16, String str, mobile_sub_get_photo_wall_rsp mobile_sub_get_photo_wall_rspVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Boolean.valueOf(z16), str, mobile_sub_get_photo_wall_rspVar);
            return;
        }
        if (!z16) {
            this.mHandler.sendEmptyMessage(5);
            return;
        }
        if (mobile_sub_get_photo_wall_rspVar == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            arrayList.addAll(this.mPhotoList);
        }
        update(mobile_sub_get_photo_wall_rspVar.total_pic, mobile_sub_get_photo_wall_rspVar.iHasMore, mobile_sub_get_photo_wall_rspVar.attachInfo, mobile_sub_get_photo_wall_rspVar.vecUrls, arrayList);
        Message obtainMessage = this.mHandler.obtainMessage(2);
        obtainMessage.obj = arrayList;
        this.mHandler.sendMessage(obtainMessage);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float f16 = displayMetrics.density;
        int min = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) - (getResources().getDimensionPixelSize(R.dimen.f159311a03) * 2);
        int i19 = (int) ((f16 * 2.0f) + 0.5f);
        int i26 = min - i19;
        int i27 = ((i26 * 2) / 3) + 0;
        this.mEmptyBgCell0.layout(0, 0, i27, i27 + i19);
        int i28 = i26 / 3;
        int i29 = min - i28;
        int i36 = i29 + i28;
        this.mEmptyBgCell1.layout(i29, 0, i36, i28 + 0);
        int i37 = i19 + i28;
        this.mEmptyBgCell2.layout(i29, i37, i36, i28 + i37);
    }

    public void peformClickMoreText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            jumpToPhotoWall(this.mActivity, this.mUin, this.mApp.getCurrentAccountUin().equals(this.mUin));
        }
    }

    public void setBlockState(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.isBlock = z16;
            updateViewStatus();
        }
    }

    public void setNightModel() {
        LinkedList<ProfilePhotoWall> linkedList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        ProfileCardPhotoWallView profileCardPhotoWallView = this.mPhotoWallView;
        if (profileCardPhotoWallView != null && (linkedList = this.mPhotoList) != null) {
            profileCardPhotoWallView.genImg(linkedList, linkedList.size(), getTotalCount(this.mPhotoList.size()));
        }
    }

    public void setPhotoWallUpdaterListener(PhotoWallUpdaterListener photoWallUpdaterListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) photoWallUpdaterListener);
        } else {
            this.mListener = photoWallUpdaterListener;
        }
    }

    @Override // com.tencent.mobileqq.profilecard.bussiness.photowall.handler.OnGetPhotoWallListener
    public void startFetchMore() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        QZonePhotoCache qZonePhotoCache = this.mQZonePhotoCache;
        if (qZonePhotoCache.hasMore == 1 && qZonePhotoCache.curPicSize < 9) {
            this.mLoadTipsLayout.setVisibility(0);
            this.mPhotoWallHandler.getQzonePhotoWall(this.mUin, this.mQZonePhotoCache.attachInfo);
        }
    }

    protected void update(int i3, int i16, String str, ArrayList<PhotoWall> arrayList, List<ProfilePhotoWall> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16), str, arrayList, list);
            return;
        }
        if (this.mQZonePhotoCache == null) {
            this.mQZonePhotoCache = new QZonePhotoCache();
        }
        QZonePhotoCache qZonePhotoCache = this.mQZonePhotoCache;
        qZonePhotoCache.totalPic = i3;
        qZonePhotoCache.hasMore = i16;
        qZonePhotoCache.attachInfo = str;
        if (arrayList != null) {
            Iterator<PhotoWall> it = arrayList.iterator();
            while (it.hasNext()) {
                PhotoWall next = it.next();
                QZonePhotoInfo qZonePhotoInfo = new QZonePhotoInfo();
                qZonePhotoInfo.uin = this.mUin;
                qZonePhotoInfo.time = next.ctime;
                qZonePhotoInfo.photoId = next.photoId;
                qZonePhotoInfo.photoUrls = next.photoUrls;
                list.add(qZonePhotoInfo);
            }
            this.mQZonePhotoCache.curPicSize = list.size();
        }
    }

    protected void updateViewStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        boolean equals = this.mApp.getCurrentAccountUin().equals(this.mUin);
        boolean isEmpty = this.mPhotoList.isEmpty();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isHost=" + equals + " isEmpty=" + isEmpty + " enableEmptyView=" + enableEmptyView() + " isBlock= " + this.isBlock);
        }
        int i3 = 0;
        if (equals) {
            if (isEmpty) {
                this.mContentView.setVisibility(8);
                View view = this.mEmptyView;
                if (!enableEmptyView()) {
                    i3 = 8;
                }
                view.setVisibility(i3);
                return;
            }
            this.mContentView.setVisibility(0);
            this.mEmptyView.setVisibility(8);
            return;
        }
        this.mEmptyView.setVisibility(8);
        if (!isEmpty && !this.isBlock) {
            this.mContentView.setVisibility(0);
        } else {
            this.mContentView.setVisibility(8);
        }
    }

    public PhotoWallView(Context context, AppInterface appInterface, String str, boolean z16) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, appInterface, str, Boolean.valueOf(z16));
            return;
        }
        this.mPhotoList = new LinkedList<>();
        this.mNowVideoList = new ArrayList<>();
        this.mNowOnliveGallayCallback = new CustomNowOnliveGallayCallback(this);
        this.isBlock = false;
        this.mActivity = (Activity) context;
        this.mApp = appInterface;
        this.mUin = str;
        onInitInner(z16);
    }

    public PhotoWallView(Context context, AppInterface appInterface, String str, IProfileViewLoader iProfileViewLoader, boolean z16) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, appInterface, str, iProfileViewLoader, Boolean.valueOf(z16));
            return;
        }
        this.mPhotoList = new LinkedList<>();
        this.mNowVideoList = new ArrayList<>();
        this.mNowOnliveGallayCallback = new CustomNowOnliveGallayCallback(this);
        this.isBlock = false;
        this.mActivity = (Activity) context;
        this.mApp = appInterface;
        this.mUin = str;
        this.mViewLoader = iProfileViewLoader;
        onInitInner(z16);
    }
}
