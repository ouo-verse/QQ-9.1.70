package com.tencent.ams.dsdk.core.mosaic;

import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.dsdk.fodder.ResourceManager;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.dsdk.utils.FileUtils;
import com.tencent.ams.dsdk.utils.WorkThreadManager;
import com.tencent.ams.mosaic.f;
import com.tencent.ams.mosaic.utils.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;

/* loaded from: classes3.dex */
public class DKImagePreloader extends e {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "DKImagePreloader";
    private final f.c mImageLoader;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DKImagePreloader(f.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar);
        } else {
            this.mImageLoader = cVar == null ? new e() : cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadImageByDefaultLoader(String str, f.c.a aVar) {
        f.c cVar = this.mImageLoader;
        if (cVar != null) {
            String format = String.format("use imageLoader: %s for src: %s", cVar, str);
            if (DKConfiguration.isIgnoreImageLoaderLog()) {
                DLog.d(TAG, format);
            } else {
                DLog.i(TAG, format);
            }
            this.mImageLoader.loadImage(str, new f.c.a(aVar) { // from class: com.tencent.ams.dsdk.core.mosaic.DKImagePreloader.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ f.c.a val$imageLoadListener;

                {
                    this.val$imageLoadListener = aVar;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) DKImagePreloader.this, (Object) aVar);
                    }
                }

                @Override // com.tencent.ams.mosaic.f.c.a
                public void onLoadFinish(Object obj) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, obj);
                        return;
                    }
                    String str2 = "use imageLoader onLoadFinish, object: " + obj;
                    if (DKConfiguration.isIgnoreImageLoaderLog()) {
                        DLog.d(DKImagePreloader.TAG, str2);
                    } else {
                        DLog.i(DKImagePreloader.TAG, str2);
                    }
                    f.c.a aVar2 = this.val$imageLoadListener;
                    if (aVar2 != null) {
                        aVar2.onLoadFinish(obj);
                    }
                }

                @Override // com.tencent.ams.mosaic.f.c.a
                public void onLoadStart() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else if (DKConfiguration.isIgnoreImageLoaderLog()) {
                        DLog.d(DKImagePreloader.TAG, "use imageLoader start");
                    } else {
                        DLog.i(DKImagePreloader.TAG, "use imageLoader start");
                    }
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.utils.e, com.tencent.ams.mosaic.f.c
    public void loadImage(String str, f.c.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) aVar);
            return;
        }
        if (loadImageFromPreload(str, aVar)) {
            DLog.i(TAG, "loadImageFromPreload for src: " + str);
            return;
        }
        loadImageByDefaultLoader(str, aVar);
    }

    protected boolean loadImageFromPreload(String str, f.c.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) aVar)).booleanValue();
        }
        if (aVar != null) {
            aVar.onLoadStart();
        }
        File preloadFile = ResourceManager.getInstance().getPreloadFile(str);
        if (preloadFile != null && preloadFile.exists() && preloadFile.isFile()) {
            WorkThreadManager.getInstance().getCachedThreadPool().execute(new Runnable(preloadFile, str, aVar) { // from class: com.tencent.ams.dsdk.core.mosaic.DKImagePreloader.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ File val$file;
                final /* synthetic */ f.c.a val$listener;
                final /* synthetic */ String val$src;

                {
                    this.val$file = preloadFile;
                    this.val$src = str;
                    this.val$listener = aVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, DKImagePreloader.this, preloadFile, str, aVar);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    FileUtils.updateLastModified(this.val$file);
                    Object imageFromByteArray = DKImagePreloader.this.getImageFromByteArray(FileUtils.readBytesFromFile(this.val$file.getAbsolutePath()), this.val$src);
                    if (imageFromByteArray == null) {
                        DLog.i(DKImagePreloader.TAG, "loadImageFromPreload decode bitmap fail");
                        DKImagePreloader.this.loadImageByDefaultLoader(this.val$src, this.val$listener);
                    } else {
                        f.c.a aVar2 = this.val$listener;
                        if (aVar2 != null) {
                            aVar2.onLoadFinish(imageFromByteArray);
                        }
                    }
                }
            });
            return true;
        }
        if (DKConfiguration.isIgnoreImageLoaderLog()) {
            DLog.d(TAG, "loadImageFromPreload file not exists");
            return false;
        }
        DLog.i(TAG, "loadImageFromPreload file not exists");
        return false;
    }
}
