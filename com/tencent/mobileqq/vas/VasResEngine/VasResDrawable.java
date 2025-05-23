package com.tencent.mobileqq.vas.VasResEngine;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.ui.VipPngPlayAnimationDrawable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.app.AppRuntime;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasResDrawable extends VipPngPlayAnimationDrawable implements Handler.Callback, AbsVasRes {
    public static final int ANIMATION_TYPE = 1;
    private static final String TAG = "VasResDrawable";
    public static final int URLDRAWABLE_TYPE = 2;
    protected Drawable mCurrentDrawable;
    protected int mId;
    protected Options mOptions;
    protected Path mPath;
    protected float mRadius;
    protected RectF mRectF;
    protected RefreshListener mRefreshListener;
    protected Handler mUIHandler;
    private URLDrawable.URLDrawableListener mURLDrawableListener;
    protected VasResDrawableAdapter mVasResAdapter;
    protected VasResController mVasResController;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class Options {
        public int animatinType;
        public int defaultDrawableId;
        public Header[] headers;
        public int loadDrawableId;
        public String urlProtocalType = "";
        public int realWidth = 0;
        public int realHeight = 0;

        public Options() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface RefreshListener {
        void downloadDone();

        void refresh();

        void reload();
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface VasResDrawableAdapter extends VasResAdapter {
        String getDrawableUrl();

        boolean isDynamic();
    }

    public VasResDrawable(AppRuntime appRuntime, int i3) {
        super(BaseApplication.getContext().getResources());
        this.mURLDrawableListener = new a();
        initial(appRuntime.getApplication().getApplicationContext(), i3, new Options());
        this.mPath = new Path();
        this.mRectF = new RectF();
    }

    @Nullable
    private URL getUrl(String str, String str2) {
        URL url;
        try {
            if (!TextUtils.isEmpty(getOptions().urlProtocalType)) {
                url = new URL(getOptions().urlProtocalType, str2, str);
            } else {
                url = new URL("http", str2, str);
            }
            return url;
        } catch (MalformedURLException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, e16.getMessage());
            }
            return null;
        }
    }

    private void initial(Context context, int i3, Options options) {
        this.mId = i3;
        this.mOptions = options;
        Handler handler = new Handler(Looper.getMainLooper(), this);
        this.mUIHandler = handler;
        this.mVasResController = new VasResController(i3, handler);
    }

    public void addHeader(String str, String str2) {
        Options options = this.mOptions;
        Header[] headerArr = options.headers;
        if (headerArr != null && headerArr.length != 0) {
            Header[] headerArr2 = new Header[headerArr.length + 1];
            System.arraycopy(headerArr, 0, headerArr2, 0, headerArr.length);
            headerArr2[this.mOptions.headers.length] = new BasicHeader(str, str2);
            this.mOptions.headers = headerArr2;
            return;
        }
        options.headers = new Header[]{new BasicHeader(str, str2)};
    }

    @Override // com.tencent.mobileqq.vas.ui.VipPngPlayAnimationDrawable, android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        drawBg(canvas);
        if (this.mVasResAdapter.isDynamic()) {
            super.draw(canvas);
        }
    }

    protected void drawBg(@NonNull Canvas canvas) {
        this.mPath.reset();
        this.mRectF.set(getBounds());
        Path path = this.mPath;
        RectF rectF = this.mRectF;
        float f16 = this.mRadius;
        path.addRoundRect(rectF, f16, f16, Path.Direction.CW);
        canvas.clipPath(this.mPath);
        Drawable drawable = this.mCurrentDrawable;
        if (drawable != null) {
            drawable.setBounds(getBounds());
            this.mCurrentDrawable.draw(canvas);
        }
    }

    public Drawable getCurrentDrawable() {
        Drawable drawable;
        if (!this.mVasResAdapter.isDynamic() && (drawable = this.mCurrentDrawable) != null) {
            return drawable;
        }
        return this;
    }

    protected Drawable getDrawable(String str, String str2) {
        BaseApplication context = BaseApplication.getContext();
        if (TextUtils.isEmpty(str2)) {
            if (getOptions().defaultDrawableId > 0) {
                return context.getResources().getDrawable(getOptions().defaultDrawableId);
            }
            return null;
        }
        URL url = getUrl(str, str2);
        if (url == null) {
            return context.getResources().getDrawable(R.drawable.hv8);
        }
        if (QLog.isDebugVersion()) {
            QLog.d(TAG, 2, "getBGDrawable url = " + url.toString());
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = getOptions().realWidth;
        obtain.mRequestHeight = getOptions().realHeight;
        if (getOptions().loadDrawableId > 0) {
            Drawable drawable = context.getResources().getDrawable(getOptions().loadDrawableId);
            obtain.mLoadingDrawable = drawable;
            obtain.mFailedDrawable = drawable;
        }
        URLDrawable drawable2 = URLDrawable.getDrawable(url, obtain);
        if (getOptions().headers != null && getOptions().headers.length > 0) {
            drawable2.setHeaders(getOptions().headers);
        }
        if (drawable2.getStatus() == 2) {
            drawable2.restartDownload();
        }
        drawable2.setURLDrawableListener(this.mURLDrawableListener);
        return drawable2;
    }

    @Override // com.tencent.mobileqq.vas.ui.VipPngPlayAnimationDrawable, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public Options getOptions() {
        return this.mOptions;
    }

    @Override // com.tencent.mobileqq.vas.VasResEngine.AbsVasRes
    public VasResAdapter getVasResAdapter() {
        return this.mVasResAdapter;
    }

    @Override // com.tencent.mobileqq.vas.VasResEngine.AbsVasRes
    public VasResController getVasResController() {
        return this.mVasResController;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        VasResDrawableAdapter vasResDrawableAdapter = this.mVasResAdapter;
        if (vasResDrawableAdapter == null) {
            return false;
        }
        switch (message.what) {
            case 10001:
                if (!TextUtils.isEmpty(vasResDrawableAdapter.getDrawableUrl())) {
                    this.mCurrentDrawable = getDrawable(String.valueOf(this.mId), this.mVasResAdapter.getDrawableUrl());
                }
                Bundle data = message.getData();
                if (data.getInt("type") == 1) {
                    String[] stringArray = data.getStringArray("pngs");
                    int i3 = data.getInt(WidgetCacheConstellationData.INTERVAL);
                    int i16 = data.getInt("repeatTimes");
                    setPngPaths(stringArray, i3);
                    setCurrentType(getOptions().animatinType);
                    this.mRepeatCount = i16;
                }
                invalidateSelf();
                RefreshListener refreshListener = this.mRefreshListener;
                if (refreshListener != null) {
                    refreshListener.refresh();
                }
                return true;
            case 10002:
                vasResDrawableAdapter.downloadDone(message.arg1, (Bundle) message.obj);
                RefreshListener refreshListener2 = this.mRefreshListener;
                if (refreshListener2 != null) {
                    refreshListener2.downloadDone();
                }
                return true;
            case 10003:
                vasResDrawableAdapter.load();
                RefreshListener refreshListener3 = this.mRefreshListener;
                if (refreshListener3 != null) {
                    refreshListener3.reload();
                }
                return true;
            default:
                return true;
        }
    }

    @Override // com.tencent.mobileqq.vas.ui.VipPngPlayAnimationDrawable, com.tencent.mobileqq.vas.VasResEngine.AbsVasRes
    public void recycle() {
        super.recycle();
        VasResDrawableAdapter vasResDrawableAdapter = this.mVasResAdapter;
        if (vasResDrawableAdapter != null) {
            vasResDrawableAdapter.destroy();
        }
    }

    public void setAdapter(VasResDrawableAdapter vasResDrawableAdapter) {
        this.mVasResAdapter = vasResDrawableAdapter;
        if (vasResDrawableAdapter != null) {
            vasResDrawableAdapter.load();
        }
        invalidateSelf();
    }

    @Override // com.tencent.mobileqq.vas.ui.VipPngPlayAnimationDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        super.setAlpha(i3);
    }

    @Override // com.tencent.mobileqq.vas.ui.VipPngPlayAnimationDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(@android.support.annotation.Nullable ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    public void setRadius(float f16) {
        this.mRadius = f16;
    }

    public void setRefreshListener(RefreshListener refreshListener) {
        this.mRefreshListener = refreshListener;
    }

    @Override // com.tencent.mobileqq.vas.VasResEngine.AbsVasRes
    public void update(int i3) {
        if (getOptions().defaultDrawableId > 0) {
            this.mCurrentDrawable = BaseApplication.getContext().getResources().getDrawable(this.mOptions.defaultDrawableId);
        }
        super.recycle();
        this.mVasResController.update(i3);
        VasResDrawableAdapter vasResDrawableAdapter = this.mVasResAdapter;
        if (vasResDrawableAdapter != null) {
            vasResDrawableAdapter.load();
        }
    }

    public VasResDrawable(Context context, int i3) {
        super(context.getResources());
        this.mURLDrawableListener = new a();
        initial(context, i3, new Options());
        this.mPath = new Path();
        this.mRectF = new RectF();
    }

    public VasResDrawable(AppInterface appInterface, int i3, Options options) {
        super(appInterface.getApp().getApplicationContext().getResources());
        this.mURLDrawableListener = new a();
        initial(appInterface.getApp().getApplicationContext(), i3, options);
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements URLDrawable.URLDrawableListener {
        a() {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            if (uRLDrawable != null) {
                VasResDrawable.this.mCurrentDrawable = uRLDrawable;
            }
            VasResDrawable.this.invalidateSelf();
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
}
