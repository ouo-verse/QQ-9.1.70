package com.tencent.mobileqq.activity.photo;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AppVideoDecoder implements BitmapDecoder {
    static IPatchRedirector $redirector_;
    Context mContext;
    LocalMediaInfo mLocalMediaInfo;

    public AppVideoDecoder(Context context, LocalMediaInfo localMediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) localMediaInfo);
        } else {
            this.mContext = context;
            this.mLocalMediaInfo = localMediaInfo;
        }
    }

    @Override // com.tencent.mobileqq.transfile.bitmapcreator.BitmapDecoder
    public Bitmap getBitmap(URL url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bitmap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) url);
        }
        Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(this.mLocalMediaInfo.path, 3);
        LocalMediaInfo localMediaInfo = this.mLocalMediaInfo;
        return ThumbnailUtils.extractThumbnail(createVideoThumbnail, localMediaInfo.thumbWidth, localMediaInfo.thumbHeight);
    }
}
