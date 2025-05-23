package com.tencent.ams.fusion.widget.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Locale;

/* compiled from: P */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes3.dex */
public class NetworkImageView extends ImageView {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "NetworkImageView";
    private ImageLoadListener mLoadListener;
    private String mSrc;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    interface ImageLoadListener {
        void onLoadFinish(String str);

        void onLoadStart(String str);
    }

    public NetworkImageView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private void loadImage(@NonNull String str) {
        Logger.d(TAG, "loadImage with src: " + str);
        Utils.runOnAsyncThread(new Runnable(str) { // from class: com.tencent.ams.fusion.widget.base.NetworkImageView.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String val$src;

            {
                this.val$src = str;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) NetworkImageView.this, (Object) str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmapFromFile;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                if (NetworkImageView.this.mLoadListener != null) {
                    NetworkImageView.this.mLoadListener.onLoadStart(this.val$src);
                }
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (this.val$src.startsWith("http")) {
                    bitmapFromFile = Utils.bitmapFromNet(this.val$src);
                } else {
                    bitmapFromFile = Utils.bitmapFromFile(NetworkImageView.this.getContext(), this.val$src);
                }
                NetworkImageView.this.setBitmap(bitmapFromFile);
                if (NetworkImageView.this.mLoadListener != null) {
                    NetworkImageView.this.mLoadListener.onLoadFinish(this.val$src);
                }
                Logger.d(NetworkImageView.TAG, String.format(Locale.CHINA, "loadImage finish cost: %dms, src: %s", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime), this.val$src));
            }
        }, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        Utils.runOnUiThread(new Runnable(bitmap) { // from class: com.tencent.ams.fusion.widget.base.NetworkImageView.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ Bitmap val$bitmap;

            {
                this.val$bitmap = bitmap;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) NetworkImageView.this, (Object) bitmap);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    NetworkImageView.this.setImageBitmap(this.val$bitmap);
                }
            }
        });
    }

    public void setLoadListener(ImageLoadListener imageLoadListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) imageLoadListener);
        } else {
            this.mLoadListener = imageLoadListener;
        }
    }

    public void setSrc(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else if (!TextUtils.isEmpty(str) && !str.equals(this.mSrc)) {
            this.mSrc = str;
            loadImage(str);
        }
    }
}
