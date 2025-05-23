package com.tencent.comic.hippy.api;

import android.app.Activity;
import com.tencent.comic.api.hippy.IComicHippyBackEventInterceptor;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.comic.data.a;
import com.tencent.comic.data.e;
import java.util.List;

/* loaded from: classes32.dex */
public class ComicHippyBackEventInterceptorProxy implements IComicHippyBackEventInterceptor {
    public static final ComicHippyBackEventInterceptorProxy INSTANCE = new ComicHippyBackEventInterceptorProxy();
    public IComicHippyBackEventInterceptor mProxy = null;

    ComicHippyBackEventInterceptorProxy() {
    }

    @Override // com.tencent.comic.api.hippy.IComicHippyBackEventInterceptor
    public boolean canShowCancelRedPoinDialog(a aVar) {
        IComicHippyBackEventInterceptor iComicHippyBackEventInterceptor = this.mProxy;
        if (iComicHippyBackEventInterceptor != null) {
            return iComicHippyBackEventInterceptor.canShowCancelRedPoinDialog(aVar);
        }
        return false;
    }

    @Override // com.tencent.comic.api.hippy.IComicHippyBackEventInterceptor
    public void doClear() {
        IComicHippyBackEventInterceptor iComicHippyBackEventInterceptor = this.mProxy;
        if (iComicHippyBackEventInterceptor != null) {
            iComicHippyBackEventInterceptor.doClear();
        }
    }

    @Override // com.tencent.comic.api.hippy.IComicHippyBackEventInterceptor
    public List<ComicCancelRedPointPopItemData> getValidCancelRedPointDialogData() {
        IComicHippyBackEventInterceptor iComicHippyBackEventInterceptor = this.mProxy;
        if (iComicHippyBackEventInterceptor != null) {
            return iComicHippyBackEventInterceptor.getValidCancelRedPointDialogData();
        }
        return null;
    }

    @Override // com.tencent.comic.api.hippy.IComicHippyBackEventInterceptor
    public void openReader(Activity activity, String str) {
        IComicHippyBackEventInterceptor iComicHippyBackEventInterceptor = this.mProxy;
        if (iComicHippyBackEventInterceptor != null) {
            iComicHippyBackEventInterceptor.openReader(activity, str);
        }
    }

    @Override // com.tencent.comic.api.hippy.IComicHippyBackEventInterceptor
    public void prepareData() {
        IComicHippyBackEventInterceptor iComicHippyBackEventInterceptor = this.mProxy;
        if (iComicHippyBackEventInterceptor != null) {
            iComicHippyBackEventInterceptor.prepareData();
        }
    }

    @Override // com.tencent.comic.api.hippy.IComicHippyBackEventInterceptor
    public void recordDialogShowTime() {
        IComicHippyBackEventInterceptor iComicHippyBackEventInterceptor = this.mProxy;
        if (iComicHippyBackEventInterceptor != null) {
            iComicHippyBackEventInterceptor.recordDialogShowTime();
        }
    }

    @Override // com.tencent.comic.api.hippy.IComicHippyBackEventInterceptor
    public void reportData(e eVar) {
        IComicHippyBackEventInterceptor iComicHippyBackEventInterceptor = this.mProxy;
        if (iComicHippyBackEventInterceptor != null) {
            iComicHippyBackEventInterceptor.reportData(eVar);
        }
    }
}
