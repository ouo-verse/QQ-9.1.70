package com.tencent.mobileqq.vip.diy.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.PluginInterface;
import com.tencent.mobileqq.vas.widget.lottie.LottieLoader;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;

/* compiled from: P */
@PluginInterface
@Deprecated
/* loaded from: classes20.dex */
public class DIYLottieLoader extends LottieLoader {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DIYLottieLoader";
    private MQLruCache<String, Object> mMemoryCache;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a extends MQLruCache<String, Object> {
        static IPatchRedirector $redirector_;

        a(int i3) {
            super(i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DIYLottieLoader.this, i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.v4.util.MQLruCache
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int sizeOfObj(String str, Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, obj)).intValue();
            }
            if (obj != null && (obj instanceof Bitmap)) {
                Bitmap bitmap = (Bitmap) obj;
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
            return super.sizeOfObj(str, obj);
        }
    }

    public DIYLottieLoader(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    @Override // com.tencent.mobileqq.vas.widget.lottie.LottieLoader
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.destroy();
        MQLruCache<String, Object> mQLruCache = this.mMemoryCache;
        if (mQLruCache != null) {
            Iterator<String> it = mQLruCache.getLargeCache().iterator();
            while (it.hasNext()) {
                String next = it.next();
                Object obj = this.mMemoryCache.get(next);
                if (obj != null && (obj instanceof Bitmap)) {
                    ((Bitmap) obj).recycle();
                    QLog.i(TAG, 4, "recycle bitmap key = " + next);
                }
            }
            this.mMemoryCache.releaseLargeCache();
        }
    }

    public void setMemoryCacheSize(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
            return;
        }
        a aVar = new a(i3);
        this.mMemoryCache = aVar;
        aVar.setLargeSize(1);
    }
}
