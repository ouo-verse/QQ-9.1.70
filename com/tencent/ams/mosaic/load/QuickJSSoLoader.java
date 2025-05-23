package com.tencent.ams.mosaic.load;

import android.content.Context;
import com.tencent.ams.mosaic.MosaicManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QuickJSSoLoader implements b {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "QuickJSSoLoader";
    private static final QuickJSSoLoader instance;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface SoLoadFailReason {
        public static final int ABI_TYPE_NOT_GET = 2;
        public static final int CACHE_PATH_NOT_GET = 4;
        public static final int DOWNLOAD_SO_FAILED = 5;
        public static final int INVALID_SO_INFO = 1;
        public static final int LOAD_SO_LIB_FAILED = 6;
        public static final int LOAD_SO_NOT_EXIST = 7;
        public static final int LOAD_SO_VERSION_LOW = 8;
        public static final int SO_URL_NOT_FOUND = 3;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    public @interface SoLoadSuccessState {
        public static final int LOAD_SO_DOWNLOAD = 3;
        public static final int LOAD_SO_EXISTS = 2;
        public static final int LOAD_SO_LOADED = 1;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        void onSoLoadFailed(int i3);

        void onSoLoadStart();

        void onSoLoadSuccess(int i3);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59122);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            instance = new QuickJSSoLoader();
        }
    }

    QuickJSSoLoader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static QuickJSSoLoader getInstance() {
        return instance;
    }

    private b getQuickJSSOLoader() {
        if (com.tencent.ams.mosaic.f.k().C()) {
            return MosaicNewJSSoLoader.o();
        }
        return c.o();
    }

    @Override // com.tencent.ams.mosaic.load.b
    public boolean isSupportQuickJS() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return getQuickJSSOLoader().isSupportQuickJS();
    }

    public void loadSo(Context context, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            loadSo(context, false, aVar);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) aVar);
        }
    }

    public boolean setQuickJSSoConfig(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) dVar)).booleanValue();
        }
        com.tencent.ams.mosaic.utils.f.e(TAG, "setQuickJSSoConfig, config: " + dVar);
        ArrayList arrayList = new ArrayList();
        arrayList.add(dVar);
        return getQuickJSSOLoader().setSoConfigs(MosaicManager.j().i(), arrayList);
    }

    @Override // com.tencent.ams.mosaic.load.b
    public boolean setSoConfigs(Context context, List<d> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context, (Object) list)).booleanValue();
        }
        com.tencent.ams.mosaic.utils.f.e(TAG, "setConfigs, configs: " + list);
        return getQuickJSSOLoader().setSoConfigs(context, list);
    }

    @Override // com.tencent.ams.mosaic.load.b
    public void loadSo(Context context, boolean z16, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, Boolean.valueOf(z16), aVar);
            return;
        }
        com.tencent.ams.mosaic.utils.f.e(TAG, "loadSo, onlyLocal: " + z16);
        getQuickJSSOLoader().loadSo(context, z16, aVar);
    }
}
