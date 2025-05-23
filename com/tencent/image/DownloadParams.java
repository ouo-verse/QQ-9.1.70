package com.tencent.image;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.net.URL;
import org.apache.http.Header;
import org.apache.http.client.CookieStore;

/* loaded from: classes7.dex */
public class DownloadParams {
    static IPatchRedirector $redirector_;
    public CookieStore cookies;
    public long downloaded;
    public String dynamicDrawableType;
    public Header[] headers;
    public String hostForHttpsVerify;
    public boolean mAutoScaleByDensity;
    public DecodeHandler mDecodeHandler;
    public Object mExtraInfo;
    public float mGifRoundCorner;
    public Object mHttpDownloaderParams;
    public int mImgType;
    public boolean needCheckNetType;
    public int outHeight;
    public int outOrientation;
    public int outWidth;
    public int reqHeight;
    public int reqWidth;
    public int retryCount;
    public Object tag;
    public URL url;
    public String urlStr;
    public boolean useApngImage;
    public boolean useDynamicDrawable;
    public boolean useExifOrientation;
    public boolean useGifAnimation;
    public boolean useSharpPAnimImage;

    @Deprecated
    public boolean useSharpPImage;

    /* loaded from: classes7.dex */
    public interface DecodeHandler {
        Bitmap run(DownloadParams downloadParams, Bitmap bitmap);
    }

    public DownloadParams() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.outOrientation = 0;
        this.needCheckNetType = false;
        this.retryCount = 0;
    }

    public Header getHeader(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Header) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        Header[] headerArr = this.headers;
        if (headerArr != null) {
            for (Header header : headerArr) {
                if (str != null && str.equals(header.getName())) {
                    return header;
                }
            }
            return null;
        }
        return null;
    }
}
