package com.tencent.mobileqq.pic.api.impl;

import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.pic.compress.c;
import com.tencent.mobileqq.pic.compress.g;
import com.tencent.mobileqq.pic.operator.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class CompressOperatorImpl implements ICompressOperator {
    static IPatchRedirector $redirector_;

    public CompressOperatorImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.pic.api.ICompressOperator
    public Bitmap clip(Bitmap bitmap, ThumbWidthHeightDP thumbWidthHeightDP) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Bitmap) iPatchRedirector.redirect((short) 6, (Object) this, (Object) bitmap, (Object) thumbWidthHeightDP);
        }
        return g.d(bitmap, thumbWidthHeightDP);
    }

    @Override // com.tencent.mobileqq.pic.api.ICompressOperator
    public boolean compressAIOThumbnail(String str, String str2, boolean z16, String str3, int i3) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, this, str, str2, Boolean.valueOf(z16), str3, Integer.valueOf(i3))).booleanValue();
        }
        return g.g(str, str2, z16, str3, i3, null);
    }

    @Override // com.tencent.mobileqq.pic.api.ICompressOperator
    public boolean compressAIOThumbnailWithTrubo(String str, String str2, boolean z16, String str3, int i3) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, this, str, str2, Boolean.valueOf(z16), str3, Integer.valueOf(i3))).booleanValue();
        }
        return g.h(str, str2, z16, str3, i3);
    }

    @Override // com.tencent.mobileqq.pic.api.ICompressOperator
    public boolean decodeJpegByTrubo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return g.n();
    }

    @Override // com.tencent.mobileqq.pic.api.ICompressOperator
    public int[] getCompressConfigFromServer(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (int[]) iPatchRedirector.redirect((short) 11, (Object) this, (Object) appInterface);
        }
        return e.k(appInterface);
    }

    @Override // com.tencent.mobileqq.pic.api.ICompressOperator
    public Bitmap getGifTagBitmap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Bitmap) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return g.s();
    }

    @Override // com.tencent.mobileqq.pic.api.ICompressOperator
    public String getSendPhotoPath(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, i3);
        }
        return g.t(str, i3);
    }

    @Override // com.tencent.mobileqq.pic.api.ICompressOperator
    public boolean start(CompressInfo compressInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) compressInfo)).booleanValue();
        }
        return c.d(compressInfo);
    }

    @Override // com.tencent.mobileqq.pic.api.ICompressOperator
    public boolean startThumbnail(CompressInfo compressInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) compressInfo)).booleanValue();
        }
        return c.f(compressInfo);
    }

    @Override // com.tencent.mobileqq.pic.api.ICompressOperator
    public int transformQuality(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, i3)).intValue();
        }
        return c.g(i3);
    }
}
