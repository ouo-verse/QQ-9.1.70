package com.tencent.mobileqq.zplan.meme.api.impl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.transfile.BaseURLDrawableHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.zplan.emoticon.panel.util.ZPlanEmoticonUtil;
import com.tencent.mobileqq.zplan.emoticon.recommend.RecommendUtil;
import com.tencent.mobileqq.zplan.meme.api.IApolloBrickPlayer;
import com.tencent.mobileqq.zplan.model.ZPlanActionInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import com.tencent.zplan.meme.Meme;
import com.tencent.zplan.meme.action.MODE;
import com.tencent.zplan.meme.action.MemeAction;
import com.tencent.zplan.meme.model.MemeFrame;
import com.tencent.zplan.meme.model.MemeResult;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes34.dex */
public class ApolloBrickPlayerImpl implements IApolloBrickPlayer {
    private static final String TAG = "[zplan]ApolloBrickPlayer";
    private Context mContext;
    public int mHeight;
    private String mLastActionKey;
    public MemeAction mMemeAction;
    private ImageView mPreview;
    private JSONObject mRecommendParam;
    private int mRoundCorner;
    public int mWidth;
    private static final int DEFAULT_PREVIEW_SIZE = ViewUtils.dpToPx(70.0f);
    private static ConcurrentHashMap<String, String> mActionKey2FilePathMap = new ConcurrentHashMap<>();
    private static ConcurrentHashMap<String, FrameData> mActionKey2FrameData = new ConcurrentHashMap<>();
    private int mActionId = -1;
    private RelativeLayout mLayout = null;
    private ImageView mImageView = null;
    private Handler mMainHandler = null;
    private IApolloBrickPlayer.a mCallback = null;
    private CustomMemePlayerListener mCustomMemePlayerListener = null;
    private Map<String, URLDrawable.URLDrawableOptions> mCacheDrawwable = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    public static URLDrawable decodeApngDrawable(String str, Map<String, URLDrawable.URLDrawableOptions> map) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "decodeApngDrawable " + str);
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mUseApngImage = true;
        obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        URLDrawable fileDrawable = URLDrawable.getFileDrawable(str, obtain);
        if (map != null) {
            map.put(str, obtain);
        }
        return fileDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static URLDrawable decodeGifDrawable(String str, Map<String, URLDrawable.URLDrawableOptions> map, float f16) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "decodeGifDrawable " + str);
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mPlayGifImage = true;
        obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mGifRoundCorner = f16;
        obtain.mUseMemoryCache = true;
        URLDrawable fileDrawable = URLDrawable.getFileDrawable(str, obtain);
        if (map != null) {
            map.put(str, obtain);
        }
        return fileDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static URLDrawable decodeSharpPDrawable(String str, Map<String, URLDrawable.URLDrawableOptions> map) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "decodeSharpPDrawable " + str);
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mUseSharpPAnimImage = true;
        obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        URLDrawable fileDrawable = URLDrawable.getFileDrawable(str, obtain);
        if (map != null) {
            map.put(str, obtain);
        }
        return fileDrawable;
    }

    private CustomMemePlayerListener genCustomPlayerListener() {
        CustomMemePlayerListener customMemePlayerListener = new CustomMemePlayerListener(this.mActionId, this.mWidth, this.mHeight);
        customMemePlayerListener.r(this.mImageView);
        customMemePlayerListener.u(this.mPreview);
        customMemePlayerListener.s(this.mLayout);
        customMemePlayerListener.v(this.mRoundCorner);
        customMemePlayerListener.t(this.mMainHandler);
        customMemePlayerListener.w(this.mCacheDrawwable);
        customMemePlayerListener.q(this.mCallback);
        return customMemePlayerListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getEmoticonFilePath(String str) {
        ZPlanActionInfo c16 = RecommendUtil.f333314a.c(this.mActionId, this.mRecommendParam);
        String currentUin = BaseApplicationImpl.getApplication().getRuntime().getCurrentUin();
        if (isEmoticon2DType(c16)) {
            String e16 = c16 != null ? com.tencent.mobileqq.zplan.emoticon.panel.util.a.f333231a.e(c16, currentUin) : null;
            if (!TextUtils.isEmpty(e16)) {
                return e16;
            }
            QLog.w(TAG, 1, "emoticon 2D filePath is null " + c16);
            this.mMainHandler.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.meme.api.impl.ApolloBrickPlayerImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    if (ApolloBrickPlayerImpl.this.mLayout != null) {
                        ApolloBrickPlayerImpl.this.mLayout.setVisibility(8);
                    }
                }
            });
            return e16;
        }
        String str2 = mActionKey2FilePathMap.get(str);
        return (!TextUtils.isEmpty(str2) || c16 == null) ? str2 : ZPlanEmoticonUtil.f333176e.A(c16, currentUin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadNormalEmoticonDrawable(final String str, final boolean z16) {
        CustomMemePlayerListener customMemePlayerListener = this.mCustomMemePlayerListener;
        if (customMemePlayerListener != null) {
            customMemePlayerListener.j();
        }
        CustomMemePlayerListener genCustomPlayerListener = genCustomPlayerListener();
        this.mCustomMemePlayerListener = genCustomPlayerListener;
        Meme.f385754h.x(this.mMemeAction, false, genCustomPlayerListener);
        if (mActionKey2FrameData.containsKey(str)) {
            final CustomMemePlayerListener customMemePlayerListener2 = this.mCustomMemePlayerListener;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.meme.api.impl.ApolloBrickPlayerImpl.4
                @Override // java.lang.Runnable
                public void run() {
                    FrameData frameData = (FrameData) ApolloBrickPlayerImpl.mActionKey2FrameData.get(str);
                    if (frameData == null) {
                        return;
                    }
                    QLog.w(ApolloBrickPlayerImpl.TAG, 1, "manual callback onRecordFrame for action:" + str + ", index:" + frameData.getIndex());
                    customMemePlayerListener2.Z1(new MemeFrame(ApolloBrickPlayerImpl.this.mMemeAction, str, frameData.getIndex(), frameData.getDataWidth(), frameData.getDataHeight(), frameData.getPixels(), frameData.getFrameTime()));
                }
            }, 16, null, true);
        }
        this.mMainHandler.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.meme.api.impl.ApolloBrickPlayerImpl.5
            @Override // java.lang.Runnable
            public void run() {
                ApolloBrickPlayerImpl.this.mImageView.setImageDrawable(null);
                ApolloBrickPlayerImpl.this.onActionLoading(z16);
            }
        });
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, this + " start recordAction " + this.mActionId + ", listener:" + this.mCustomMemePlayerListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onActionLoaded() {
        ImageView imageView = this.mPreview;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onActionLoading(boolean z16) {
        ImageView imageView = this.mPreview;
        if (imageView != null) {
            imageView.setVisibility(0);
            if (z16) {
                int i3 = DEFAULT_PREVIEW_SIZE;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i3);
                layoutParams.addRule(13, -1);
                this.mPreview.setLayoutParams(layoutParams);
                this.mPreview.setImageResource(R.drawable.c0i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showEmoticonDrawable(String str) {
        final URLDrawable decodeSharpPDrawable;
        if (this.mMemeAction.getMode() == MODE.GIF) {
            decodeSharpPDrawable = decodeGifDrawable(str, this.mCacheDrawwable, this.mRoundCorner);
        } else if (this.mMemeAction.getMode() == MODE.APNG) {
            decodeSharpPDrawable = decodeApngDrawable(str, this.mCacheDrawwable);
        } else {
            decodeSharpPDrawable = decodeSharpPDrawable(str, this.mCacheDrawwable);
        }
        IApolloBrickPlayer.a aVar = this.mCallback;
        if (aVar != null) {
            aVar.a(true, str, this.mMemeAction, null);
        }
        this.mMainHandler.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.meme.api.impl.ApolloBrickPlayerImpl.3
            @Override // java.lang.Runnable
            public void run() {
                ApolloBrickPlayerImpl.this.mImageView.setImageDrawable(decodeSharpPDrawable);
                ApolloBrickPlayerImpl.this.onActionLoaded();
                if (QLog.isColorLevel()) {
                    QLog.d(ApolloBrickPlayerImpl.TAG, 2, "start getFileDrawable " + ApolloBrickPlayerImpl.this.mActionId);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.zplan.meme.api.IApolloBrickPlayer
    public void destroy() {
        for (Map.Entry<String, URLDrawable.URLDrawableOptions> entry : this.mCacheDrawwable.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                URLDrawable.removeMemoryCacheByUrl(entry.getKey(), entry.getValue());
            }
        }
        RelativeLayout relativeLayout = this.mLayout;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.zplan.meme.api.IApolloBrickPlayer
    public View getView() {
        return this.mLayout;
    }

    @Override // com.tencent.mobileqq.zplan.meme.api.IApolloBrickPlayer
    public void setAction(MemeAction memeAction, JSONObject jSONObject) {
        this.mMemeAction = memeAction;
        this.mActionId = memeAction.getActionId();
        this.mRecommendParam = jSONObject;
    }

    @Override // com.tencent.mobileqq.zplan.meme.api.IApolloBrickPlayer
    public void setGetFrameCallback(IApolloBrickPlayer.a aVar) {
        this.mCallback = aVar;
    }

    @Override // com.tencent.mobileqq.zplan.meme.api.IApolloBrickPlayer
    public void setLoadingView(Drawable drawable) {
        this.mPreview.setImageDrawable(drawable);
    }

    @Override // com.tencent.mobileqq.zplan.meme.api.IApolloBrickPlayer
    public void start() {
        RelativeLayout relativeLayout = this.mLayout;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.meme.api.impl.ApolloBrickPlayerImpl.1
            @Override // java.lang.Runnable
            public void run() {
                String key = ApolloBrickPlayerImpl.this.mMemeAction.getKey();
                boolean z16 = (ApolloBrickPlayerImpl.this.mLastActionKey == null || ApolloBrickPlayerImpl.this.mLastActionKey.equals(key)) ? false : true;
                ApolloBrickPlayerImpl.this.mLastActionKey = key;
                String emoticonFilePath = ApolloBrickPlayerImpl.this.getEmoticonFilePath(key);
                if (emoticonFilePath != null) {
                    ApolloBrickPlayerImpl.this.showEmoticonDrawable(emoticonFilePath);
                } else {
                    if (ApolloBrickPlayerImpl.this.isEmoticon2DType(null)) {
                        return;
                    }
                    ApolloBrickPlayerImpl.this.loadNormalEmoticonDrawable(key, z16);
                }
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes34.dex */
    public static class CustomMemePlayerListener implements com.tencent.zplan.meme.b {
        private WeakReference<RelativeLayout> C;
        private WeakReference<Handler> D;
        private WeakReference<Map<String, URLDrawable.URLDrawableOptions>> E;
        private WeakReference<IApolloBrickPlayer.a> F;
        private volatile boolean G = false;
        private volatile boolean H = true;

        /* renamed from: d, reason: collision with root package name */
        private int f333940d;

        /* renamed from: e, reason: collision with root package name */
        private int f333941e;

        /* renamed from: f, reason: collision with root package name */
        private int f333942f;

        /* renamed from: h, reason: collision with root package name */
        private int f333943h;

        /* renamed from: i, reason: collision with root package name */
        private WeakReference<ImageView> f333944i;

        /* renamed from: m, reason: collision with root package name */
        private WeakReference<ImageView> f333945m;

        public CustomMemePlayerListener(int i3, int i16, int i17) {
            this.f333940d = i3;
            this.f333941e = i16;
            this.f333942f = i17;
        }

        private Drawable k(boolean z16, MemeResult memeResult) {
            URLDrawable decodeApngDrawable;
            MemeAction action = memeResult.getAction();
            String recordPath = memeResult.getRecordPath();
            String recordKey = memeResult.getRecordKey();
            try {
                if (z16) {
                    ApolloBrickPlayerImpl.mActionKey2FilePathMap.put(recordKey, recordPath);
                    if (action.getMode() == MODE.GIF) {
                        decodeApngDrawable = ApolloBrickPlayerImpl.decodeGifDrawable(recordPath, (Map) l(this.E), this.f333943h);
                    } else {
                        decodeApngDrawable = action.getMode() == MODE.APNG ? ApolloBrickPlayerImpl.decodeApngDrawable(recordPath, (Map) l(this.E)) : ApolloBrickPlayerImpl.decodeSharpPDrawable(recordPath, (Map) l(this.E));
                    }
                    URLDrawable uRLDrawable = decodeApngDrawable;
                    if (this.F.get() == null) {
                        return uRLDrawable;
                    }
                    this.F.get().a(z16, recordPath, action, memeResult);
                    return uRLDrawable;
                }
                return BaseURLDrawableHelper.getFailedDrawable();
            } catch (Exception e16) {
                QLog.e(ApolloBrickPlayerImpl.TAG, 1, "getDrawableByAction exception, :", e16);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public URLDrawable.URLDrawableListener m(final String str) {
            return new URLDrawable.URLDrawableListener() { // from class: com.tencent.mobileqq.zplan.meme.api.impl.ApolloBrickPlayerImpl.CustomMemePlayerListener.3
                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadSuccessed(URLDrawable uRLDrawable) {
                    QLog.e(ApolloBrickPlayerImpl.TAG, 1, "refreshViewOnRecordDone drawable loading success, actionKey:" + str);
                    CustomMemePlayerListener customMemePlayerListener = CustomMemePlayerListener.this;
                    Handler handler = (Handler) customMemePlayerListener.l(customMemePlayerListener.D);
                    if (handler != null) {
                        handler.post(new Runnable() { // from class: com.tencent.mobileqq.zplan.meme.api.impl.ApolloBrickPlayerImpl.CustomMemePlayerListener.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                CustomMemePlayerListener.this.n();
                            }
                        });
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
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n() {
            ImageView imageView = (ImageView) l(this.f333945m);
            if (imageView != null) {
                imageView.setVisibility(8);
                ApolloRepeatPngDrawable apolloRepeatPngDrawable = (ApolloRepeatPngDrawable) imageView.getTag();
                if (apolloRepeatPngDrawable != null) {
                    apolloRepeatPngDrawable.o();
                    imageView.setTag(null);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p(Runnable runnable) {
            Handler handler = (Handler) l(this.D);
            if (handler != null) {
                handler.post(runnable);
            }
        }

        @Override // com.tencent.zplan.meme.b
        public void Z1(final MemeFrame memeFrame) {
            if (!this.G && ZPlanFeatureSwitch.f369852a.j3()) {
                final MemeAction action = memeFrame.getAction();
                final String recordKey = memeFrame.getRecordKey();
                if (action.getMode() == MODE.GIF) {
                    return;
                }
                if (this.f333940d != action.getActionId()) {
                    QLog.w(ApolloBrickPlayerImpl.TAG, 2, this + " onRecordFrame return, mActionId " + this.f333940d + ", recordKey:" + recordKey);
                    return;
                }
                if (((Handler) l(this.D)) == null) {
                    return;
                }
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.meme.api.impl.ApolloBrickPlayerImpl.CustomMemePlayerListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        byte[] bArr;
                        try {
                            bArr = (byte[]) memeFrame.getPixels().clone();
                        } catch (OutOfMemoryError e16) {
                            QLog.e(ApolloBrickPlayerImpl.TAG, 1, "onRecordFrame error:", e16);
                            bArr = null;
                        }
                        if (bArr == null) {
                            return;
                        }
                        final int index = memeFrame.getIndex();
                        final int width = memeFrame.getWidth();
                        final int height = memeFrame.getHeight();
                        final int frameTime = memeFrame.getFrameTime();
                        FrameData frameData = (FrameData) ApolloBrickPlayerImpl.mActionKey2FrameData.get(recordKey);
                        if (frameData == null || frameData.getIndex() < index) {
                            ApolloBrickPlayerImpl.mActionKey2FrameData.put(recordKey, new FrameData(index, bArr, width, height, frameTime));
                        }
                        final byte[] bArr2 = bArr;
                        CustomMemePlayerListener.this.p(new Runnable() { // from class: com.tencent.mobileqq.zplan.meme.api.impl.ApolloBrickPlayerImpl.CustomMemePlayerListener.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                CustomMemePlayerListener.this.x(action, recordKey, frameTime, index, bArr2, width, height);
                            }
                        });
                    }
                }, 128, null, false);
            }
        }

        public void j() {
            QLog.e(ApolloBrickPlayerImpl.TAG, 1, this + " destroy. mActionId:" + this.f333940d);
            this.G = true;
            this.f333944i = null;
            this.f333945m = null;
            this.C = null;
            this.D = null;
            this.E = null;
            this.F = null;
        }

        @Override // com.tencent.zplan.meme.a
        public void l9(boolean z16, MemeResult memeResult) {
            if (this.G) {
                return;
            }
            MemeAction action = memeResult.getAction();
            String recordPath = memeResult.getRecordPath();
            String recordKey = memeResult.getRecordKey();
            if (QLog.isColorLevel()) {
                QLog.w(ApolloBrickPlayerImpl.TAG, 2, "onRecordDone, success:" + z16 + ", actionId:" + this.f333940d + ", productPath:" + recordPath);
            }
            o(action, recordKey, k(z16, memeResult));
            if (ApolloBrickPlayerImpl.mActionKey2FrameData.containsKey(recordKey)) {
                ApolloBrickPlayerImpl.mActionKey2FrameData.remove(recordKey);
            }
        }

        public void q(IApolloBrickPlayer.a aVar) {
            this.F = new WeakReference<>(aVar);
        }

        public void r(ImageView imageView) {
            this.f333944i = new WeakReference<>(imageView);
        }

        public void s(RelativeLayout relativeLayout) {
            this.C = new WeakReference<>(relativeLayout);
        }

        public void t(Handler handler) {
            this.D = new WeakReference<>(handler);
        }

        public void u(ImageView imageView) {
            this.f333945m = new WeakReference<>(imageView);
        }

        public void v(int i3) {
            this.f333943h = i3;
        }

        public void w(Map<String, URLDrawable.URLDrawableOptions> map) {
            this.E = new WeakReference<>(map);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public <T> T l(WeakReference<T> weakReference) {
            if (weakReference == null || weakReference.get() == null) {
                return null;
            }
            return weakReference.get();
        }

        private void o(MemeAction memeAction, final String str, final Drawable drawable) {
            if (drawable == null) {
                QLog.w(ApolloBrickPlayerImpl.TAG, 1, "refreshViewOnRecordDone, but drawable is null");
            } else {
                final int actionId = memeAction.getActionId();
                p(new Runnable() { // from class: com.tencent.mobileqq.zplan.meme.api.impl.ApolloBrickPlayerImpl.CustomMemePlayerListener.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (actionId != CustomMemePlayerListener.this.f333940d) {
                            if (QLog.isColorLevel()) {
                                QLog.w(ApolloBrickPlayerImpl.TAG, 2, "onRecordDone mActionId not same! current " + CustomMemePlayerListener.this.f333940d + " onRecordDone id " + actionId);
                                return;
                            }
                            return;
                        }
                        CustomMemePlayerListener customMemePlayerListener = CustomMemePlayerListener.this;
                        ImageView imageView = (ImageView) customMemePlayerListener.l(customMemePlayerListener.f333944i);
                        if (imageView != null) {
                            imageView.setImageDrawable(drawable);
                        }
                        Drawable drawable2 = drawable;
                        if (drawable2 instanceof URLDrawable) {
                            URLDrawable uRLDrawable = (URLDrawable) drawable2;
                            if (uRLDrawable.getStatus() == 1) {
                                CustomMemePlayerListener.this.n();
                            } else {
                                uRLDrawable.setURLDrawableListener(CustomMemePlayerListener.this.m(str));
                            }
                        }
                        CustomMemePlayerListener customMemePlayerListener2 = CustomMemePlayerListener.this;
                        RelativeLayout relativeLayout = (RelativeLayout) customMemePlayerListener2.l(customMemePlayerListener2.C);
                        if (relativeLayout != null) {
                            relativeLayout.invalidate();
                        }
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void x(MemeAction memeAction, String str, int i3, int i16, byte[] bArr, int i17, int i18) {
            int i19 = i16;
            ImageView imageView = (ImageView) l(this.f333945m);
            if (imageView == null || imageView.getVisibility() != 0) {
                return;
            }
            ApolloRepeatPngDrawable apolloRepeatPngDrawable = (ApolloRepeatPngDrawable) imageView.getTag();
            if (apolloRepeatPngDrawable == null) {
                apolloRepeatPngDrawable = new ApolloRepeatPngDrawable(str, i3);
                imageView.setTag(apolloRepeatPngDrawable);
            }
            if (!str.equals(apolloRepeatPngDrawable.getKey())) {
                apolloRepeatPngDrawable.o();
                apolloRepeatPngDrawable = new ApolloRepeatPngDrawable(str, i3);
                imageView.setTag(apolloRepeatPngDrawable);
                QLog.w(ApolloBrickPlayerImpl.TAG, 1, "showFrameOnPreImageView create new pngDrawable:" + apolloRepeatPngDrawable + " for preview:" + l(this.f333945m) + ", actionKey:" + str);
            }
            ApolloRepeatPngDrawable apolloRepeatPngDrawable2 = apolloRepeatPngDrawable;
            if (apolloRepeatPngDrawable2.p() >= ZPlanFeatureSwitch.f369852a.P1()) {
                QLog.w(ApolloBrickPlayerImpl.TAG, 1, "showFrameOnPreImageView " + apolloRepeatPngDrawable2 + " totalFrameCount exceed maxFrameCount, return");
                return;
            }
            if (apolloRepeatPngDrawable2.g() == -1 && apolloRepeatPngDrawable2.p() == 0 && i19 > 0) {
                QLog.w(ApolloBrickPlayerImpl.TAG, 1, "showFrameOnPreImageView " + apolloRepeatPngDrawable2 + " correct index from " + i19 + " to 0");
                i19 = 0;
            }
            if (apolloRepeatPngDrawable2.n(i19)) {
                QLog.e(ApolloBrickPlayerImpl.TAG, 1, "showFrameOnPreImageView " + apolloRepeatPngDrawable2 + " already contain " + i19);
                return;
            }
            apolloRepeatPngDrawable2.f(i19, bArr, i17, i18, this.f333941e, this.f333942f, i3);
            if (this.H) {
                this.H = false;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f333941e, this.f333942f);
                layoutParams.addRule(13);
                imageView.setLayoutParams(layoutParams);
                imageView.setImageDrawable(apolloRepeatPngDrawable2);
            }
        }

        @Override // com.tencent.zplan.meme.b
        public void ad(boolean z16, MemeResult memeResult) {
        }

        @Override // com.tencent.zplan.meme.a
        public void d3(MemeAction memeAction, float f16) {
        }
    }

    @Override // com.tencent.mobileqq.zplan.meme.api.IApolloBrickPlayer
    public void setParams(com.tencent.mobileqq.zplan.meme.a aVar) {
        if (aVar != null) {
            this.mWidth = aVar.f333885b;
            this.mHeight = aVar.f333886c;
            this.mContext = aVar.f333884a.getApplicationContext();
            this.mRoundCorner = aVar.f333887d;
        }
        if (this.mContext == null) {
            return;
        }
        this.mMainHandler = new Handler(Looper.getMainLooper());
        this.mLayout = new RelativeLayout(this.mContext);
        ImageView imageView = new ImageView(this.mContext);
        this.mImageView = imageView;
        imageView.setId(R.id.f58812r1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.mWidth, this.mHeight);
        layoutParams.addRule(13);
        this.mImageView.setBackgroundColor(0);
        this.mLayout.addView(this.mImageView, layoutParams);
        ImageView imageView2 = new ImageView(this.mContext);
        this.mPreview = imageView2;
        imageView2.setImageResource(R.drawable.c0i);
        this.mPreview.setVisibility(8);
        int i3 = DEFAULT_PREVIEW_SIZE;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i3, i3);
        layoutParams2.addRule(13, -1);
        this.mLayout.addView(this.mPreview, layoutParams2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isEmoticon2DType(ZPlanActionInfo zPlanActionInfo) {
        if (zPlanActionInfo == null) {
            zPlanActionInfo = RecommendUtil.f333314a.c(this.mActionId, this.mRecommendParam);
        }
        return zPlanActionInfo != null && zPlanActionInfo.getOriginType() == 100;
    }

    @Override // com.tencent.mobileqq.zplan.meme.api.IApolloBrickPlayer
    public void pause() {
    }

    @Override // com.tencent.mobileqq.zplan.meme.api.IApolloBrickPlayer
    public void resume() {
    }
}
