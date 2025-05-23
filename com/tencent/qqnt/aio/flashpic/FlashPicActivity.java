package com.tencent.qqnt.aio.flashpic;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.common.galleryactivity.AnimationView;
import com.tencent.common.galleryactivity.h;
import com.tencent.common.galleryactivity.j;
import com.tencent.common.galleryactivity.k;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.af;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.qqnt.aio.api.IFlashPicApi;
import com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi;
import com.tencent.qqnt.bus.api.IBusManager;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.CustomWithdrawConfig;
import com.tencent.qqnt.kernel.nativeinterface.DownloadRelateEmojiResultInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiResourceInfo;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupFileListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupItem;
import com.tencent.qqnt.kernel.nativeinterface.HitRelatedEmojiWordsResult;
import com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.ImportOldDbMsgNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.InputStatusInfo;
import com.tencent.qqnt.kernel.nativeinterface.KickedInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.MsgSetting;
import com.tencent.qqnt.kernel.nativeinterface.QQNTWrapperUtil;
import com.tencent.qqnt.kernel.nativeinterface.QueryUserSecQualityRsp;
import com.tencent.qqnt.kernel.nativeinterface.RecvdOrder;
import com.tencent.qqnt.kernel.nativeinterface.RelatedWordEmojiInfo;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaElementGetReq;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupFileResult;
import com.tencent.qqnt.kernel.nativeinterface.TempChatInfo;
import com.tencent.qqnt.kernel.nativeinterface.UnreadCntInfo;
import com.tencent.qqnt.kernel.nativeinterface.ax;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.CountDownProgressBar;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.Constants;
import mqq.os.MqqHandler;

@Metadata(d1 = {"\u0000\u00a8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 j2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001kB\u0007\u00a2\u0006\u0004\bh\u0010iJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J \u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0002J\u0018\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\nH\u0002J\b\u0010\u0017\u001a\u00020\u0005H\u0002J\b\u0010\u0018\u001a\u00020\u0005H\u0002J\b\u0010\u0019\u001a\u00020\u0005H\u0002J\b\u0010\u001a\u001a\u00020\u0005H\u0002J\b\u0010\u001b\u001a\u00020\u0005H\u0002J\n\u0010\u001c\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0012\u0010\"\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002J\u0010\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0010H\u0002J\b\u0010&\u001a\u00020%H\u0002J\u0012\u0010)\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010'H\u0014J\u0012\u0010,\u001a\u00020%2\b\u0010+\u001a\u0004\u0018\u00010*H\u0014J\b\u0010-\u001a\u00020\u0005H\u0014J\b\u0010.\u001a\u00020\u0005H\u0016J\b\u0010/\u001a\u00020\u0005H\u0016J\u001c\u00104\u001a\u00020%2\b\u00101\u001a\u0004\u0018\u0001002\b\u00103\u001a\u0004\u0018\u000102H\u0016J\b\u00105\u001a\u00020\u0005H\u0016J\b\u00106\u001a\u00020\u0005H\u0016J\b\u00107\u001a\u00020\u0005H\u0016J\b\u00108\u001a\u00020\u0005H\u0016J\b\u00109\u001a\u00020\u0005H\u0016J\b\u0010:\u001a\u00020\u0005H\u0014R\u0016\u0010;\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010>\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010@\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010<R\u0016\u0010A\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010?R\u0016\u0010C\u001a\u00020B8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010F\u001a\u00020E8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010I\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010K\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bK\u0010?R\u0016\u0010L\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010N\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010MR\u0016\u0010O\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010MR\u0016\u0010P\u001a\u00020%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010MR\u0016\u0010R\u001a\u00020Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010T\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010V\u001a\u00020Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010SR\u0016\u0010W\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010UR\u0016\u0010X\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010UR\u0016\u0010Y\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010UR\u0016\u0010Z\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010UR\u0018\u0010\\\u001a\u0004\u0018\u00010[8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010_\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010`R\u0018\u0010a\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010c\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010UR\u0014\u0010e\u001a\u00020d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010g\u001a\u00020Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010S\u00a8\u0006l"}, d2 = {"Lcom/tencent/qqnt/aio/flashpic/FlashPicActivity;", "Lcom/tencent/mobileqq/app/QBaseActivity;", "Landroid/view/View$OnTouchListener;", "Lcom/tencent/common/galleryactivity/h;", "Lcom/tencent/widget/CountDownProgressBar$OnCountDownLinstener;", "", "initWindow", "initView", "initMsgData", "initHandler", "", "filePath", "Landroid/graphics/Bitmap;", "getMosaicBitmap", "Landroid/graphics/BitmapFactory$Options;", "options", "", "reqWidth", "reqHeight", "calculateInSampleSize", "downloadFlashPic", "key", "dealFlashPic", "showMosaicPic", "showFail", "decrypt", "showOriginPic", "setHasRead", "getLoadingBitmap", "Landroid/graphics/drawable/Drawable;", "drawable", "Landroid/graphics/Rect;", "getEndRect", "showEnterAnimation", "showExitAnimation", "status", "setAnimParams", "", "isFastDoubleClick", "Landroid/content/Intent;", "intent", "requestWindowFeature", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreate", "doOnStart", "doOnBackPressed", "onCountDownStop", "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", "event", "onTouch", "onEnterAnimationStart", "onEnterAnimationEnd", "onExitAnimationStart", "onExitAnimationEnd", "finish", "doOnDestroy", "mRoot", "Landroid/view/View;", "Landroid/widget/ImageView;", "mFlashPic", "Landroid/widget/ImageView;", "mTipLayout", "mTipIcon", "Landroid/widget/TextView;", "mTipText", "Landroid/widget/TextView;", "Lcom/tencent/common/galleryactivity/AnimationView;", "mAnimation", "Lcom/tencent/common/galleryactivity/AnimationView;", "Lcom/tencent/widget/CountDownProgressBar;", "mCountDown", "Lcom/tencent/widget/CountDownProgressBar;", "mProgress", "mShowFlashPic", "Z", "mFromCreate", "mExitAnimating", "mPicIsReady", "", "mMsgId", "J", "mPeerUid", "Ljava/lang/String;", "mElementId", "mThumbPath", "mEncryptPath", "mDecryptPath", "mKey", "Landroid/graphics/drawable/BitmapDrawable;", "mEnterDrawable", "Landroid/graphics/drawable/BitmapDrawable;", "Lmqq/os/MqqHandler;", "mHandler", "Lmqq/os/MqqHandler;", "mStartRect", "Landroid/graphics/Rect;", "mOriginPath", "Lcom/tencent/qqnt/bus/api/IBusManager;", "mBusManager", "Lcom/tencent/qqnt/bus/api/IBusManager;", "mLastClickTime", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class FlashPicActivity extends QBaseActivity implements View.OnTouchListener, h, CountDownProgressBar.OnCountDownLinstener {
    private static final String BG_COLOR = "#ff262629";
    private static final int BLOCK_SIZE = 16;
    private static final int CLICK_INTERVAL_LIMIT = 500;
    private static final int COUNT_DOWN_NUM = 5;
    private static final long COUNT_DOWN_TIME = 4500;
    private static final long DELAY_TIME = 500;
    private static final int ENTER = 0;
    private static final int EXIST = 1;
    private static final int MSG_SHOW_FLASH_PIC = 0;
    private static final long SUCCESS_CODE = 0;
    private static final String TAG = "NTFlashPic FlashPicActivity";
    private static final String TEMP_DECRYPT_FLASH_PIC_TEMP_FILE_NAME = "temp_decrypt_flash_pic";
    private AnimationView mAnimation;
    private final IBusManager mBusManager;
    private CountDownProgressBar mCountDown;
    private long mElementId;
    private BitmapDrawable mEnterDrawable;
    private boolean mExitAnimating;
    private ImageView mFlashPic;
    private boolean mFromCreate;
    private MqqHandler mHandler;
    private long mLastClickTime;
    private long mMsgId;
    private boolean mPicIsReady;
    private ImageView mProgress;
    private View mRoot;
    private boolean mShowFlashPic;
    private Rect mStartRect;
    private ImageView mTipIcon;
    private View mTipLayout;
    private TextView mTipText;
    private String mPeerUid = "";
    private String mThumbPath = "";
    private String mEncryptPath = "";
    private String mDecryptPath = "";
    private String mKey = "";
    private String mOriginPath = "";

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/aio/flashpic/FlashPicActivity$c", "Lmqq/os/MqqHandler;", "Landroid/os/Message;", "msg", "", "handleMessage", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c extends MqqHandler {
        c() {
        }

        @Override // mqq.os.MqqHandler
        public void handleMessage(Message msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (QLog.isColorLevel()) {
                QLog.d(FlashPicActivity.TAG, 2, "msg: " + msg2.what);
            }
            if (msg2.what == 0) {
                FlashPicActivity.this.showOriginPic();
            }
        }
    }

    public FlashPicActivity() {
        QRouteApi api = QRoute.api(IBusManager.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IBusManager::class.java)");
        this.mBusManager = (IBusManager) api;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dealFlashPic(final String filePath, final String key) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqnt.aio.flashpic.c
            @Override // java.lang.Runnable
            public final void run() {
                FlashPicActivity.dealFlashPic$lambda$5(FlashPicActivity.this, filePath, key);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dealFlashPic$lambda$5(FlashPicActivity this$0, String filePath, String key) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(filePath, "$filePath");
        Intrinsics.checkNotNullParameter(key, "$key");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "mEnterDrawable\uff1a" + this$0.mEnterDrawable);
        }
        if (this$0.mEnterDrawable == null) {
            this$0.mEnterDrawable = new BitmapDrawable(this$0.getMosaicBitmap(filePath));
        }
        String str = filePath + "_fp";
        this$0.mEncryptPath = str;
        af.f(filePath, str, key);
        f.f349947a.c(this$0.mElementId, this$0.mEncryptPath, this$0.mKey);
        this$0.mPicIsReady = true;
        this$0.showMosaicPic();
    }

    private final void decrypt() {
        String absolutePath = new File(getCacheDir(), TEMP_DECRYPT_FLASH_PIC_TEMP_FILE_NAME).getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "File(cacheDir, TEMP_DECR\u2026P_FILE_NAME).absolutePath");
        this.mDecryptPath = absolutePath;
        af.d(this.mEncryptPath, absolutePath, this.mKey);
    }

    private final void downloadFlashPic() {
        if (this.mOriginPath.length() > 0) {
            this.mPicIsReady = true;
            return;
        }
        Pair<String, String> a16 = f.f349947a.a(this.mElementId);
        if (a16 != null) {
            this.mEncryptPath = a16.getFirst();
            if (new File(this.mEncryptPath).exists()) {
                this.mKey = a16.getSecond();
                this.mPicIsReady = true;
                return;
            }
        }
        ImageView imageView = this.mProgress;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mProgress");
            imageView = null;
        }
        imageView.setVisibility(0);
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.addMsgListener(new b());
        }
        RichMediaElementGetReq richMediaElementGetReq = new RichMediaElementGetReq();
        richMediaElementGetReq.msgId = this.mMsgId;
        richMediaElementGetReq.peerUid = this.mPeerUid;
        richMediaElementGetReq.chatType = 1;
        richMediaElementGetReq.elementId = this.mElementId;
        richMediaElementGetReq.downloadType = 1;
        w e17 = com.tencent.qqnt.msg.f.e();
        if (e17 != null) {
            e17.getRichMediaElement(richMediaElementGetReq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void finish$lambda$10(FlashPicActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FileUtils.deleteFile(this$0.mThumbPath);
        FileUtils.deleteFile(this$0.mDecryptPath);
        FileUtils.deleteFile(this$0.mEncryptPath);
        FileUtils.deleteFile(this$0.mThumbPath + "_hd");
        QLog.i(TAG, 1, "delete decrypt: " + this$0.mDecryptPath + "\uff0cthumb: " + this$0.mThumbPath + "\uff0cencrypt\uff1a" + this$0.mEncryptPath);
        f.f349947a.b(this$0.mElementId);
    }

    private final Rect getEndRect(Drawable drawable) {
        int coerceAtMost;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        int i3 = getResources().getDisplayMetrics().widthPixels;
        int i16 = getResources().getDisplayMetrics().heightPixels;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(i3 / intrinsicWidth, i16 / intrinsicHeight);
        Rect b16 = j.b(intrinsicWidth * coerceAtMost, intrinsicHeight * coerceAtMost, i3, i16, false, null);
        Intrinsics.checkNotNullExpressionValue(b16, "getAnimationEndDstRect(\n\u2026           null\n        )");
        return b16;
    }

    private final Bitmap getLoadingBitmap() {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels, Bitmap.Config.ARGB_8888);
            createBitmap.eraseColor(Color.parseColor(BG_COLOR));
            return createBitmap;
        } catch (OutOfMemoryError e16) {
            QLog.e(TAG, 1, "FlashPicActivity getLoadingBitmap OOM: " + e16);
            return null;
        }
    }

    private final Bitmap getMosaicBitmap(String filePath) {
        int i3 = getResources().getDisplayMetrics().widthPixels;
        int i16 = getResources().getDisplayMetrics().heightPixels;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            SafeBitmapFactory.decodeFile(filePath, options);
            options.inSampleSize = calculateInSampleSize(options, i3, i16);
            options.inJustDecodeBounds = false;
            Bitmap decodeFile = SafeBitmapFactory.decodeFile(filePath, options);
            Intrinsics.checkNotNullExpressionValue(decodeFile, "decodeFile(filePath, options)");
            int width = decodeFile.getWidth() / 16;
            if (width == 0) {
                width = 1;
            }
            Bitmap mosaicBitmap = ((IFlashPicApi) QRoute.api(IFlashPicApi.class)).getMosaicBitmap(decodeFile, width);
            decodeFile.recycle();
            return mosaicBitmap;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "FlashPicActivity getMosaicBitmap Exception\uff1a" + e16);
            }
            return null;
        } catch (OutOfMemoryError e17) {
            QLog.e(TAG, 1, "FlashPicActivity getMosaicBitmap OOM\uff1a" + e17);
            return null;
        }
    }

    private final void initHandler() {
        if (this.mHandler == null) {
            this.mHandler = new c();
        }
    }

    private final void initMsgData() {
        Intent intent = getIntent();
        this.mMsgId = intent.getLongExtra("msgId", 0L);
        this.mPeerUid = String.valueOf(intent.getStringExtra("peerUid"));
        this.mElementId = intent.getLongExtra("elementId", 0L);
        this.mOriginPath = String.valueOf(intent.getStringExtra("originPath"));
        this.mThumbPath = String.valueOf(intent.getStringExtra("thumbPath"));
        this.mStartRect = (Rect) intent.getParcelableExtra(CanvasView.ACTION_RECT);
        Bitmap mosaicBitmap = getMosaicBitmap(this.mThumbPath);
        this.mEnterDrawable = mosaicBitmap != null ? new BitmapDrawable(mosaicBitmap) : null;
        downloadFlashPic();
    }

    private final boolean isFastDoubleClick() {
        long currentTimeMillis = System.currentTimeMillis() - this.mLastClickTime;
        return 1 <= currentTimeMillis && currentTimeMillis < 500;
    }

    private final void setHasRead() {
        byte[] generateFlashPicExtBuf = ((IAIOMsgItemApi) QRoute.api(IAIOMsgItemApi.class)).generateFlashPicExtBuf(true);
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.updateElementExtBufForUI(new Contact(1, this.mPeerUid, ""), this.mMsgId, this.mElementId, generateFlashPicExtBuf, new IOperateCallback() { // from class: com.tencent.qqnt.aio.flashpic.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    FlashPicActivity.setHasRead$lambda$9(FlashPicActivity.this, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setHasRead$lambda$9(FlashPicActivity this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i(TAG, 1, "result: " + i3 + " msg: " + str);
        if (i3 == 0) {
            this$0.mBusManager.sendEvent(new a(this$0.mMsgId, true));
        }
    }

    private final void showEnterAnimation(Drawable drawable) {
        AnimationView animationView;
        AnimationView animationView2 = this.mAnimation;
        if (animationView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAnimation");
            animationView2 = null;
        }
        animationView2.setVisibility(0);
        AnimationView animationView3 = this.mAnimation;
        if (animationView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAnimation");
            animationView = null;
        } else {
            animationView = animationView3;
        }
        animationView.g(drawable, this.mStartRect, getEndRect(drawable), k.getCutValue(this.mStartRect, drawable), 350L);
        setAnimParams(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showFail() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqnt.aio.flashpic.d
            @Override // java.lang.Runnable
            public final void run() {
                FlashPicActivity.showFail$lambda$7(FlashPicActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showFail$lambda$7(FlashPicActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = this$0.mTipLayout;
        ImageView imageView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipLayout");
            view = null;
        }
        view.setVisibility(0);
        ImageView imageView2 = this$0.mTipIcon;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipIcon");
            imageView2 = null;
        }
        imageView2.setImageResource(R.drawable.f161434dk0);
        TextView textView = this$0.mTipText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipText");
            textView = null;
        }
        textView.setText(R.string.a6w);
        ImageView imageView3 = this$0.mProgress;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mProgress");
        } else {
            imageView = imageView3;
        }
        imageView.setVisibility(8);
    }

    private final void showMosaicPic() {
        ImageView imageView = this.mProgress;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mProgress");
            imageView = null;
        }
        imageView.setVisibility(8);
        View view = this.mTipLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipLayout");
            view = null;
        }
        view.setVisibility(0);
        ImageView imageView3 = this.mTipIcon;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipIcon");
            imageView3 = null;
        }
        imageView3.setImageResource(R.drawable.f161435dk2);
        ImageView imageView4 = this.mFlashPic;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFlashPic");
            imageView4 = null;
        }
        imageView4.setVisibility(0);
        BitmapDrawable bitmapDrawable = this.mEnterDrawable;
        if (bitmapDrawable != null) {
            ImageView imageView5 = this.mFlashPic;
            if (imageView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFlashPic");
            } else {
                imageView2 = imageView5;
            }
            imageView2.setImageDrawable(bitmapDrawable);
            return;
        }
        ImageView imageView6 = this.mFlashPic;
        if (imageView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFlashPic");
        } else {
            imageView2 = imageView6;
        }
        imageView2.setImageDrawable(new BitmapDrawable());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showOriginPic() {
        URLDrawable fileDrawable;
        if (this.mOriginPath.length() == 0) {
            QLog.i(TAG, 1, "need to decrypt");
            decrypt();
        }
        View view = this.mTipLayout;
        CountDownProgressBar countDownProgressBar = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipLayout");
            view = null;
        }
        view.setVisibility(8);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = getResources().getDisplayMetrics().widthPixels;
        obtain.mRequestHeight = getResources().getDisplayMetrics().heightPixels;
        obtain.mLoadingDrawable = this.mEnterDrawable;
        obtain.mUseExifOrientation = true;
        obtain.mUseMemoryCache = false;
        if (this.mOriginPath.length() > 0) {
            fileDrawable = URLDrawable.getFileDrawable(this.mOriginPath, obtain);
        } else {
            fileDrawable = URLDrawable.getFileDrawable(this.mDecryptPath, obtain);
        }
        if (fileDrawable != null) {
            ImageView imageView = this.mFlashPic;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFlashPic");
                imageView = null;
            }
            imageView.setImageDrawable(fileDrawable);
            this.mShowFlashPic = true;
            CountDownProgressBar countDownProgressBar2 = this.mCountDown;
            if (countDownProgressBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCountDown");
                countDownProgressBar2 = null;
            }
            countDownProgressBar2.setVisibility(0);
            CountDownProgressBar countDownProgressBar3 = this.mCountDown;
            if (countDownProgressBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCountDown");
            } else {
                countDownProgressBar = countDownProgressBar3;
            }
            countDownProgressBar.start();
            setHasRead();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        ImageView imageView = this.mFlashPic;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFlashPic");
            imageView = null;
        }
        showExitAnimation(imageView.getDrawable());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        MqqHandler mqqHandler = this.mHandler;
        if (mqqHandler != null) {
            if (mqqHandler != null) {
                mqqHandler.removeCallbacksAndMessages(null);
            }
            this.mHandler = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        super.doOnStart();
        if (this.mFromCreate) {
            this.mFromCreate = false;
            if (this.mPicIsReady && this.mEnterDrawable != null) {
                QLog.i(TAG, 1, "doOnStart original pic and mosaic are ready");
                BitmapDrawable bitmapDrawable = this.mEnterDrawable;
                Intrinsics.checkNotNull(bitmapDrawable);
                showEnterAnimation(bitmapDrawable);
                return;
            }
            QLog.i(TAG, 1, "doOnStart original pic or mosaic not ready");
            showEnterAnimation(new BitmapDrawable(getLoadingBitmap()));
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        if (this.mShowFlashPic) {
            if (this.mOriginPath.length() == 0) {
                ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.qqnt.aio.flashpic.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        FlashPicActivity.finish$lambda$10(FlashPicActivity.this);
                    }
                });
                this.mShowFlashPic = false;
            }
        }
    }

    @Override // com.tencent.widget.CountDownProgressBar.OnCountDownLinstener
    public void onCountDownStop() {
        if (this.mShowFlashPic) {
            ImageView imageView = this.mFlashPic;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFlashPic");
                imageView = null;
            }
            showExitAnimation(imageView.getDrawable());
        }
    }

    @Override // com.tencent.common.galleryactivity.h
    public void onEnterAnimationEnd() {
        if (this.mPicIsReady) {
            showMosaicPic();
        }
    }

    @Override // com.tencent.common.galleryactivity.h
    public void onExitAnimationEnd() {
        finish();
        this.mExitAnimating = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        initWindow();
    }

    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\u000b\u001a\u00020\u00042 \u0010\n\u001a\u001c\u0012\u0004\u0012\u00020\u0007\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0006\u0018\u00010\u0006H\u0016J\u0018\u0010\u000f\u001a\u00020\u00042\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/qqnt/aio/flashpic/FlashPicActivity$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/FileTransNotifyInfo;", "notifyInfo", "", "onRichMediaDownloadComplete", "Ljava/util/HashMap;", "", "", "Lcom/tencent/qqnt/kernel/nativeinterface/UnreadCntInfo;", "newUnreadCntInfos", "onContactUnreadCntUpdate", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", TabPreloadItem.TAB_NAME_MESSAGE, "onMsgInfoListUpdate", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements IKernelMsgListener {
        b() {
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onAddSendMsg(MsgRecord msgRecord) {
            ax.a(this, msgRecord);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onCustomWithdrawConfigUpdate(CustomWithdrawConfig customWithdrawConfig) {
            ax.c(this, customWithdrawConfig);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onDraftUpdate(Contact contact, ArrayList arrayList, long j3) {
            ax.d(this, contact, arrayList, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onEmojiDownloadComplete(EmojiNotifyInfo emojiNotifyInfo) {
            ax.e(this, emojiNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onEmojiResourceUpdate(EmojiResourceInfo emojiResourceInfo) {
            ax.f(this, emojiResourceInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onFileMsgCome(ArrayList arrayList) {
            ax.g(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGrabPasswordRedBag(int i3, String str, int i16, RecvdOrder recvdOrder, MsgRecord msgRecord) {
            ax.h(this, i3, str, i16, recvdOrder, msgRecord);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupFileInfoAdd(GroupItem groupItem) {
            ax.i(this, groupItem);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupFileInfoUpdate(GroupFileListResult groupFileListResult) {
            ax.j(this, groupFileListResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupTransferInfoAdd(GroupItem groupItem) {
            ax.k(this, groupItem);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onGroupTransferInfoUpdate(GroupFileListResult groupFileListResult) {
            ax.l(this, groupFileListResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onHitCsRelatedEmojiResult(DownloadRelateEmojiResultInfo downloadRelateEmojiResultInfo) {
            ax.m(this, downloadRelateEmojiResultInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onHitEmojiKeywordResult(HitRelatedEmojiWordsResult hitRelatedEmojiWordsResult) {
            ax.n(this, hitRelatedEmojiWordsResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onHitRelatedEmojiResult(RelatedWordEmojiInfo relatedWordEmojiInfo) {
            ax.o(this, relatedWordEmojiInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onImportOldDbProgressUpdate(ImportOldDbMsgNotifyInfo importOldDbMsgNotifyInfo) {
            ax.p(this, importOldDbMsgNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onInputStatusPush(InputStatusInfo inputStatusInfo) {
            ax.q(this, inputStatusInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onKickedOffLine(KickedInfo kickedInfo) {
            ax.r(this, kickedInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onLineDev(ArrayList arrayList) {
            ax.s(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onLogLevelChanged(long j3) {
            ax.t(this, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMiscDataChanged(ArrayList arrayList) {
            ax.u(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgBoxChanged(ArrayList arrayList) {
            ax.v(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgDelete(Contact contact, ArrayList arrayList) {
            ax.w(this, contact, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgInfoListAdd(ArrayList arrayList) {
            ax.x(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgQRCodeStatusChanged(int i3) {
            ax.z(this, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgRecall(int i3, String str, long j3) {
            ax.A(this, i3, str, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgSecurityNotify(MsgRecord msgRecord) {
            ax.B(this, msgRecord);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgSettingUpdate(MsgSetting msgSetting) {
            ax.C(this, msgSetting);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onMsgWithRichLinkInfoUpdate(ArrayList arrayList) {
            ax.D(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtFirstViewMsgSyncEnd() {
            ax.E(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtMsgSyncContactUnread() {
            ax.F(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtMsgSyncEnd() {
            ax.G(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onNtMsgSyncStart() {
            ax.H(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvMsg(ArrayList arrayList) {
            ax.I(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvMsgSvrRspTransInfo(long j3, Contact contact, int i3, int i16, String str, byte[] bArr) {
            ax.J(this, j3, contact, i3, i16, str, bArr);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvOnlineFileMsg(ArrayList arrayList) {
            ax.K(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRecvSysMsg(ArrayList arrayList) {
            ax.L(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRedTouchChanged() {
            ax.M(this);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRichMediaProgerssUpdate(FileTransNotifyInfo fileTransNotifyInfo) {
            ax.O(this, fileTransNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onRichMediaUploadComplete(FileTransNotifyInfo fileTransNotifyInfo) {
            ax.P(this, fileTransNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onSearchGroupFileInfoUpdate(SearchGroupFileResult searchGroupFileResult) {
            ax.Q(this, searchGroupFileResult);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onSendMsgError(long j3, Contact contact, int i3, String str) {
            ax.R(this, j3, contact, i3, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onSysMsgNotification(int i3, long j3, long j16, boolean z16, ArrayList arrayList) {
            ax.S(this, i3, j3, j16, z16, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onTempChatInfoUpdate(TempChatInfo tempChatInfo) {
            ax.T(this, tempChatInfo);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserChannelTabStatusChanged(boolean z16) {
            ax.U(this, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserOnlineStatusChanged(boolean z16) {
            ax.V(this, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserSecQualityChanged(QueryUserSecQualityRsp queryUserSecQualityRsp) {
            ax.W(this, queryUserSecQualityRsp);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onUserTabStatusChanged(ArrayList arrayList) {
            ax.X(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onlineStatusBigIconDownloadPush(int i3, long j3, String str) {
            ax.Y(this, i3, j3, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public /* synthetic */ void onlineStatusSmallIconDownloadPush(int i3, long j3, String str) {
            ax.Z(this, i3, j3, str);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onRichMediaDownloadComplete(FileTransNotifyInfo notifyInfo) {
            if (notifyInfo != null && notifyInfo.fileDownType == 1 && FlashPicActivity.this.mMsgId == notifyInfo.msgId && FlashPicActivity.this.mElementId == notifyInfo.msgElementId) {
                if (QLog.isColorLevel()) {
                    QLog.d(FlashPicActivity.TAG, 2, "downPic Finish downType: " + notifyInfo.fileDownType + ", info:" + notifyInfo);
                }
                if (notifyInfo.fileErrCode != 0) {
                    FlashPicActivity.this.showFail();
                } else {
                    FlashPicActivity flashPicActivity = FlashPicActivity.this;
                    String genFileMd5Hex = QQNTWrapperUtil.CppProxy.genFileMd5Hex(notifyInfo.filePath);
                    Intrinsics.checkNotNullExpressionValue(genFileMd5Hex, "genFileMd5Hex(notifyInfo.filePath)");
                    flashPicActivity.mKey = genFileMd5Hex;
                    FlashPicActivity flashPicActivity2 = FlashPicActivity.this;
                    String str = notifyInfo.filePath;
                    Intrinsics.checkNotNullExpressionValue(str, "notifyInfo.filePath");
                    flashPicActivity2.dealFlashPic(str, FlashPicActivity.this.mKey);
                }
                w e16 = com.tencent.qqnt.msg.f.e();
                if (e16 != null) {
                    e16.removeMsgListener(this);
                }
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onContactUnreadCntUpdate(HashMap<Integer, HashMap<String, UnreadCntInfo>> newUnreadCntInfos) {
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onMsgInfoListUpdate(ArrayList<MsgRecord> msgList) {
        }
    }

    private final void initWindow() {
        requestWindowFeature(1);
        Window window = getWindow();
        window.setFlags(1024, 1024);
        window.addFlags(8192);
        if (LiuHaiUtils.enableNotch(this)) {
            this.mNeedStatusTrans = true;
            this.mActNeedImmersive = false;
        } else {
            this.mNeedStatusTrans = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle savedInstanceState) {
        this.mFromCreate = true;
        this.mLastClickTime = System.currentTimeMillis();
        super.doOnCreate(savedInstanceState);
        setContentView(R.layout.f167597dv3);
        initView();
        initMsgData();
        initHandler();
        return true;
    }

    @Override // com.tencent.common.galleryactivity.h
    public void onExitAnimationStart() {
        this.mExitAnimating = true;
    }

    private final void showExitAnimation(Drawable drawable) {
        AnimationView animationView;
        if (drawable == null) {
            finish();
            return;
        }
        if (this.mExitAnimating) {
            return;
        }
        AnimationView animationView2 = this.mAnimation;
        if (animationView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAnimation");
            animationView2 = null;
        }
        animationView2.setVisibility(0);
        ImageView imageView = this.mFlashPic;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFlashPic");
            imageView = null;
        }
        imageView.setVisibility(8);
        View view = this.mTipLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTipLayout");
            view = null;
        }
        view.setVisibility(8);
        RFWImmersiveUtils.setNavigationBarColor(getWindow(), ie0.a.f().g(this, R.color.qui_common_bg_nav_bottom, 1000));
        AnimationView animationView3 = this.mAnimation;
        if (animationView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAnimation");
            animationView = null;
        } else {
            animationView = animationView3;
        }
        animationView.e(drawable, this.mStartRect, getEndRect(drawable), k.getCutValue(this.mStartRect, drawable), 0, 0, 350L);
        setAnimParams(1);
    }

    private final void initView() {
        View findViewById = findViewById(R.id.v9_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.flash_pic_root)");
        this.mRoot = findViewById;
        View findViewById2 = findViewById(R.id.v9d);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.flash_pic_view)");
        this.mFlashPic = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.v9b);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.flash_pic_tip_layout)");
        this.mTipLayout = findViewById3;
        View findViewById4 = findViewById(R.id.v9a);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.flash_pic_tip_icon)");
        this.mTipIcon = (ImageView) findViewById4;
        View findViewById5 = findViewById(R.id.v9c);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.flash_pic_tip_text)");
        this.mTipText = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.v97);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.flash_pic_anim)");
        this.mAnimation = (AnimationView) findViewById6;
        View findViewById7 = findViewById(R.id.v98);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.flash_pic_countdown)");
        this.mCountDown = (CountDownProgressBar) findViewById7;
        View findViewById8 = findViewById(R.id.v99);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.flash_pic_progress)");
        ImageView imageView = (ImageView) findViewById8;
        this.mProgress = imageView;
        View view = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mProgress");
            imageView = null;
        }
        imageView.setImageResource(R.drawable.f162244au2);
        View view2 = this.mRoot;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRoot");
            view2 = null;
        }
        view2.setOnTouchListener(this);
        CountDownProgressBar countDownProgressBar = this.mCountDown;
        if (countDownProgressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCountDown");
            countDownProgressBar = null;
        }
        countDownProgressBar.setOnCountDownLinstener(this);
        AnimationView animationView = this.mAnimation;
        if (animationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAnimation");
            animationView = null;
        }
        animationView.setAnimationListener(this);
        CountDownProgressBar countDownProgressBar2 = this.mCountDown;
        if (countDownProgressBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCountDown");
            countDownProgressBar2 = null;
        }
        countDownProgressBar2.setTotalMills(COUNT_DOWN_TIME, 5);
        View view3 = this.mRoot;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRoot");
        } else {
            view = view3;
        }
        view.setBackgroundResource(R.color.a0j);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v3, MotionEvent event) {
        MqqHandler mqqHandler;
        ImageView imageView = null;
        Integer valueOf = event != null ? Integer.valueOf(event.getAction()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            if (this.mPicIsReady && (mqqHandler = this.mHandler) != null) {
                mqqHandler.sendEmptyMessageDelayed(0, 500L);
            }
        } else if (valueOf != null && valueOf.intValue() == 1) {
            MqqHandler mqqHandler2 = this.mHandler;
            if (mqqHandler2 != null) {
                mqqHandler2.removeMessages(0);
            }
            if (!isFastDoubleClick()) {
                ImageView imageView2 = this.mFlashPic;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFlashPic");
                } else {
                    imageView = imageView2;
                }
                showExitAnimation(imageView.getDrawable());
            }
        }
        return true;
    }

    private final int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        int roundToInt;
        int roundToInt2;
        int i3 = 1;
        if (reqWidth != 0 && reqHeight != 0 && reqWidth != -1 && reqHeight != -1) {
            int i16 = options.outHeight;
            int i17 = options.outWidth;
            while (i16 > reqHeight && i17 > reqWidth) {
                roundToInt = MathKt__MathJVMKt.roundToInt(i16 / reqHeight);
                roundToInt2 = MathKt__MathJVMKt.roundToInt(i17 / reqWidth);
                if (roundToInt <= roundToInt2) {
                    roundToInt = roundToInt2;
                }
                if (roundToInt < 2) {
                    break;
                }
                i17 >>= 1;
                i16 >>= 1;
                i3 <<= 1;
            }
        }
        return i3;
    }

    private final void setAnimParams(int status) {
        AlphaAnimation alphaAnimation;
        View view = null;
        if (status != 0) {
            alphaAnimation = status != 1 ? null : new AlphaAnimation(1.0f, 0.0f);
        } else {
            alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setInterpolator(new AccelerateInterpolator());
        }
        if (alphaAnimation != null) {
            alphaAnimation.setDuration(350L);
        }
        if (alphaAnimation != null) {
            alphaAnimation.setFillAfter(true);
        }
        View view2 = this.mRoot;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRoot");
        } else {
            view = view2;
        }
        view.startAnimation(alphaAnimation);
    }

    @Override // com.tencent.common.galleryactivity.h
    public void onEnterAnimationStart() {
    }
}
