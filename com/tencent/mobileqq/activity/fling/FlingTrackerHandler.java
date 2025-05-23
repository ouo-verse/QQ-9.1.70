package com.tencent.mobileqq.activity.fling;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.fling.TopLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.bb;

/* compiled from: P */
/* loaded from: classes10.dex */
public class FlingTrackerHandler extends FlingHandler implements TopLayout.OnDraggingListener {
    static IPatchRedirector $redirector_;
    private ImageView mBackImageView;
    private ContentWrapView mContentWrapView;
    private int mCount;
    private Handler mHandler;
    private View mInnerView;
    private TopLayout mTopView;
    private Runnable mWrapContentTaskRunnable;

    public FlingTrackerHandler(Activity activity) {
        super(activity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
        } else {
            this.mHandler = new Handler();
            this.mWrapContentTaskRunnable = new Runnable() { // from class: com.tencent.mobileqq.activity.fling.FlingTrackerHandler.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlingTrackerHandler.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    Activity activity2 = FlingTrackerHandler.this.mWrappedActivity.get();
                    if (activity2 == null) {
                        return;
                    }
                    if (!ScreenCapture.hasSnapFile(activity2)) {
                        if (FlingTrackerHandler.this.mCount > 5) {
                            FlingTrackerHandler.this.mCount = 0;
                        } else {
                            FlingTrackerHandler.this.mCount++;
                            FlingTrackerHandler.this.mHandler.postDelayed(this, 100L);
                            return;
                        }
                    }
                    ViewGroup viewGroup = (ViewGroup) activity2.getWindow().getDecorView();
                    if (FlingTrackerHandler.this.mTopView == null) {
                        FlingTrackerHandler.this.mInnerView = viewGroup.getChildAt(0);
                        View view = FlingTrackerHandler.this.mInnerView;
                        FlingTrackerHandler.this.mTopView = new TopLayout(activity2);
                        FlingTrackerHandler.this.mTopView.setBackgroundColor(-16777216);
                        TopLayout topLayout = FlingTrackerHandler.this.mTopView;
                        topLayout.setOnDraggingListener(FlingTrackerHandler.this);
                        viewGroup.addView(topLayout);
                        viewGroup.removeView(view);
                        FlingTrackerHandler.this.mContentWrapView = new ContentWrapView(activity2);
                        ContentWrapView contentWrapView = FlingTrackerHandler.this.mContentWrapView;
                        contentWrapView.addView(view);
                        topLayout.setContent(contentWrapView);
                        FlingTrackerHandler.this.mBackImageView = new ImageView(activity2);
                        FlingTrackerHandler.this.mBackImageView.setScaleType(ImageView.ScaleType.FIT_START);
                        ImageView imageView = FlingTrackerHandler.this.mBackImageView;
                        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                        topLayout.setBehind(imageView);
                    } else if (!FlingTrackerHandler.this.isWrapped()) {
                        viewGroup.addView(FlingTrackerHandler.this.mTopView);
                        viewGroup.removeView(FlingTrackerHandler.this.mInnerView);
                        FlingTrackerHandler.this.mContentWrapView.addView(FlingTrackerHandler.this.mInnerView);
                    }
                    if (FlingTrackerHandler.this.isWrapped() && FlingTrackerHandler.this.mBackImageView != null && FlingTrackerHandler.this.mBackImageView.getDrawable() == null) {
                        FlingTrackerHandler.this.loadBackViewSnap();
                    }
                }
            };
        }
    }

    private int calculateInSamplePowerSize(BitmapFactory.Options options, int i3, int i16) {
        int i17 = 1;
        if ((i3 & i16) != 0 && (i3 | i16) != -1) {
            int i18 = options.outHeight;
            int i19 = options.outWidth;
            while (true) {
                if (i18 <= i16 && i19 <= i3) {
                    break;
                }
                int round = Math.round(i18 / i16);
                int round2 = Math.round(i19 / i3);
                if (round <= round2) {
                    round = round2;
                }
                if (round < 2) {
                    break;
                }
                i19 /= 2;
                i18 /= 2;
                i17 *= 2;
            }
        }
        return i17;
    }

    private String getSnapFilePath() {
        Activity activity = this.mWrappedActivity.get();
        if (activity != null) {
            return ScreenCapture.getSnapPath(activity, getFlingCode());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadBackViewSnap() {
        String snapFilePath = getSnapFilePath();
        if (snapFilePath == null) {
            return;
        }
        try {
            Bitmap decodeSampledBitmapFromFile = decodeSampledBitmapFromFile(snapFilePath, this.mBackImageView.getMeasuredWidth(), this.mBackImageView.getMeasuredHeight());
            if (decodeSampledBitmapFromFile != null) {
                this.mBackImageView.setImageBitmap(decodeSampledBitmapFromFile);
            }
        } catch (OutOfMemoryError unused) {
        }
    }

    @Override // com.tencent.mobileqq.activity.fling.TopLayout.OnDraggingListener
    public void cancelDrag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            bb.b(this.mWrappedActivity.get());
        }
    }

    public Bitmap decodeSampledBitmapFromFile(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Bitmap) iPatchRedirector.redirect((short) 9, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = calculateInSamplePowerSize(options, i3, i16);
        options.inJustDecodeBounds = false;
        try {
            return BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }

    @Override // com.tencent.mobileqq.activity.fling.TopLayout.OnDraggingListener
    public void endDrag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        Activity activity = this.mWrappedActivity.get();
        if (activity != null) {
            bb.b(activity);
            activity.onBackPressed();
            activity.overridePendingTransition(R.anim.f154560b8, R.anim.f154560b8);
        }
    }

    @Override // com.tencent.mobileqq.activity.fling.FlingHandler
    protected boolean isWrapped() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        TopLayout topLayout = this.mTopView;
        if (topLayout != null && topLayout.getParent() != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.fling.FlingHandler
    public void onConfigurationChanged(Configuration configuration) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) configuration);
            return;
        }
        super.onConfigurationChanged(configuration);
        if (isWrapped()) {
            this.mTopView.onConfigChanged(configuration);
        }
    }

    @Override // com.tencent.mobileqq.activity.fling.TopLayout.OnDraggingListener
    public void startDrag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            bb.a(this.mWrappedActivity.get());
        }
    }

    @Override // com.tencent.mobileqq.activity.fling.FlingHandler
    protected void unwrap() {
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        Activity activity = this.mWrappedActivity.get();
        if (activity == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        if (isWrapped() && this.mTopView.getParent().equals(viewGroup)) {
            viewGroup.removeView(this.mTopView);
            if (this.mContentWrapView != null && this.mInnerView.getParent().equals(this.mContentWrapView)) {
                this.mContentWrapView.removeView(this.mInnerView);
                viewGroup.addView(this.mInnerView);
            }
            ImageView imageView = this.mBackImageView;
            if (imageView != null && imageView.getDrawable() != null) {
                Drawable drawable = this.mBackImageView.getDrawable();
                if ((drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                this.mBackImageView.setImageDrawable(null);
            }
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(this.mWrapContentTaskRunnable);
        }
    }

    @Override // com.tencent.mobileqq.activity.fling.FlingHandler
    protected void wrap() {
        Handler handler;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else if (canWrapContent() && (handler = this.mHandler) != null) {
            handler.postDelayed(this.mWrapContentTaskRunnable, 100L);
        }
    }
}
