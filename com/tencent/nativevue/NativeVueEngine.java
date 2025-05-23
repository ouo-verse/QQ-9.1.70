package com.tencent.nativevue;

import android.util.Log;
import androidx.collection.ArrayMap;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.nativevue.NativeVuePreconditionAdapter;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes21.dex */
public class NativeVueEngine implements NativeVuePreconditionAdapter.LoadSoResult {
    static IPatchRedirector $redirector_ = null;
    public static final int DEFAULT_CONVERTER_TYPE = 0;
    public static final int HIPPY_CONVERTER_TYPE = 1;
    private static volatile NativeVueEngine INSTANCE = null;
    private static final String TAG = "NativeVueEngine";
    private Builder builder;
    private List<VDomHolder> lazyDomList;
    private volatile boolean loadSoSuccess;
    private volatile boolean loadingSo;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class Builder {
        static IPatchRedirector $redirector_;
        Map<String, String> envMap;
        NativeVueLogAdapter logAdapter;
        NativeVuePreconditionAdapter preconditionAdapter;

        public Builder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.envMap = new ArrayMap();
            }
        }

        public Builder env(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Builder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
            }
            this.envMap.put(str, str2);
            return this;
        }

        public Builder logAdapter(NativeVueLogAdapter nativeVueLogAdapter) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (Builder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) nativeVueLogAdapter);
            }
            this.logAdapter = nativeVueLogAdapter;
            return this;
        }

        public Builder preconditionAdapter(NativeVuePreconditionAdapter nativeVuePreconditionAdapter) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Builder) iPatchRedirector.redirect((short) 2, (Object) this, (Object) nativeVuePreconditionAdapter);
            }
            this.preconditionAdapter = nativeVuePreconditionAdapter;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface DomResult {
        void onResult(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class VDomHolder {
        static IPatchRedirector $redirector_;
        int converterType;
        String data;
        WeakReference<DomResult> domResultRef;
        String vueDom;

        public VDomHolder(String str, String str2, int i3, DomResult domResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, Integer.valueOf(i3), domResult);
                return;
            }
            this.data = str;
            this.vueDom = str2;
            this.converterType = i3;
            this.domResultRef = new WeakReference<>(domResult);
        }
    }

    public NativeVueEngine() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.lazyDomList = new CopyOnWriteArrayList();
        }
    }

    private native String createDom(String str, String str2);

    private native String createDom(String str, String str2, int i3);

    public static NativeVueEngine getInstance() {
        if (INSTANCE == null) {
            synchronized (NativeVueEngine.class) {
                if (INSTANCE == null) {
                    INSTANCE = new NativeVueEngine();
                }
            }
        }
        return INSTANCE;
    }

    private native boolean initNaive(String str, String str2);

    private void internalCreateDom(String str, String str2, int i3, DomResult domResult) {
        try {
            domResult.onResult(createDom(str, str2, i3));
        } catch (Throwable th5) {
            domResult.onResult("");
            onLogError("[internalCreateDom]: " + th5.getMessage());
        }
    }

    private void internalInit() {
        try {
            for (Map.Entry<String, String> entry : this.builder.envMap.entrySet()) {
                initNaive(entry.getKey(), entry.getValue());
            }
        } catch (Throwable th5) {
            onLogError("initNativeVueError: " + th5.getMessage());
        }
    }

    private static void logD(String str) {
        NativeVueLogAdapter nativeVueLogAdapter = getInstance().builder.logAdapter;
        if (nativeVueLogAdapter != null) {
            nativeVueLogAdapter.logD(str);
        } else {
            Log.d(TAG, str);
        }
    }

    private static void logE(String str) {
        NativeVueLogAdapter nativeVueLogAdapter = getInstance().builder.logAdapter;
        if (nativeVueLogAdapter != null) {
            nativeVueLogAdapter.logE(str);
            nativeVueLogAdapter.onNativeVueError(str);
        } else {
            Log.e(TAG, str);
        }
    }

    private void onLogError(String str) {
        NativeVueLogAdapter nativeVueLogAdapter = getInstance().builder.logAdapter;
        if (nativeVueLogAdapter != null) {
            nativeVueLogAdapter.logE(str);
        }
    }

    private void tryRunLazyDomTask() {
        for (VDomHolder vDomHolder : this.lazyDomList) {
            DomResult domResult = vDomHolder.domResultRef.get();
            if (domResult != null) {
                internalCreateDom(vDomHolder.data, vDomHolder.vueDom, vDomHolder.converterType, domResult);
                onLogError("[tryRunLazyDomTask]: ");
            }
        }
        this.lazyDomList.clear();
    }

    public void createVDom(String str, String str2, DomResult domResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            createVDom(str, str2, 0, domResult);
        } else {
            iPatchRedirector.redirect((short) 3, this, str, str2, domResult);
        }
    }

    public void init(Builder builder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) builder);
            return;
        }
        this.builder = builder;
        this.loadingSo = true;
        builder.preconditionAdapter.loadNativeVueSo(this);
    }

    @Override // com.tencent.nativevue.NativeVuePreconditionAdapter.LoadSoResult
    public void onLoadError() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.loadSoSuccess = false;
        this.loadingSo = false;
        onLogError("loadNativeVueSo error");
    }

    @Override // com.tencent.nativevue.NativeVuePreconditionAdapter.LoadSoResult
    public void onLoadSuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.loadSoSuccess = true;
        this.loadingSo = false;
        internalInit();
        tryRunLazyDomTask();
        logD("onNativeVueSoLoadSuccess");
    }

    public void createVDom(String str, String str2, int i3, DomResult domResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, str2, Integer.valueOf(i3), domResult);
            return;
        }
        if (this.loadingSo) {
            this.lazyDomList.add(new VDomHolder(str, str2, i3, domResult));
            onLogError("loading native vue so");
        } else if (this.loadSoSuccess) {
            internalCreateDom(str, str2, i3, domResult);
        } else {
            domResult.onResult("");
            onLogError("init native vue error");
        }
    }
}
