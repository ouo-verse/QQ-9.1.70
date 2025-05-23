package com.tencent.ams.dynamicwidget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.SystemClock;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.core.mosaic.DKMosaicEngine;
import com.tencent.ams.dsdk.core.mosaic.OnCreateMosaicEngineListener;
import com.tencent.ams.dynamicwidget.EngineStatue;
import com.tencent.ams.mosaic.f;
import com.tencent.ams.mosaic.utils.DebugUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\b'\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b \u0010\u0016J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0016\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0017\u001a\u00020\u00128\u0002@\u0002X\u0083\u000e\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u0012\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0014R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028B@\u0002X\u0082\u000e\u00a2\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u00078&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006!"}, d2 = {"Lcom/tencent/ams/dynamicwidget/b;", "Lcom/tencent/ams/dynamicwidget/f;", "Landroid/content/Context;", "context", "", "g", "", "", "e", "Lcom/tencent/ams/dynamicwidget/utils/a;", "Lcom/tencent/ams/dsdk/core/mosaic/DKMosaicEngine;", "a", "Lcom/tencent/ams/dynamicwidget/utils/a;", "mEngineBlockingItem", "", "b", "Z", "mHasPreWarmed", "", "c", "I", "mStatue$annotations", "()V", "mStatue", "d", "mInitError", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "f", "()Ljava/lang/String;", "tag", "<init>", "lib_release"}, k = 1, mv = {1, 4, 0})
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes3.dex */
public abstract class b implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.ams.dynamicwidget.utils.a<DKMosaicEngine> mEngineBlockingItem;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean mHasPreWarmed;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private volatile int mStatue;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mInitError;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016R\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0015"}, d2 = {"com/tencent/ams/dynamicwidget/b$a", "Lcom/tencent/ams/dsdk/core/mosaic/OnCreateMosaicEngineListener;", "", "onSoLoadStart", "", "state", "onSoLoadSuccess", "failReason", "onSoLoadFailed", "onWillCreateEngine", "errorCode", "onEngineInitializeError", "onEngineInitialized", "", "a", "J", "getStartTime", "()J", "setStartTime", "(J)V", "startTime", "lib_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class a implements OnCreateMosaicEngineListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private long startTime;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ DKMosaicEngine f70166c;

        a(DKMosaicEngine dKMosaicEngine) {
            this.f70166c = dKMosaicEngine;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) b.this, (Object) dKMosaicEngine);
            }
        }

        @Override // com.tencent.ams.dsdk.core.DKEngine.OnCreateEngineListener
        public void onEngineInitializeError(int errorCode) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, errorCode);
                return;
            }
            com.tencent.ams.dynamicwidget.utils.b.f70218a.d(b.this.f(), "preWarmMosaicEngine - onEngineInitializeError: " + errorCode);
            int i3 = b.this.mStatue;
            EngineStatue.Companion companion = EngineStatue.INSTANCE;
            if (i3 != companion.d()) {
                b.this.mStatue = companion.b();
                b.this.mInitError = errorCode;
            }
            d.f70187b.a(b.this.getModuleId(), errorCode);
        }

        @Override // com.tencent.ams.dsdk.core.DKEngine.OnCreateEngineListener
        public void onEngineInitialized() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this);
                return;
            }
            com.tencent.ams.dynamicwidget.utils.b.f70218a.c(b.this.f(), "preWarmMosaicEngine - onEngineInitialized cost: " + (SystemClock.elapsedRealtime() - this.startTime) + "ms");
            b.this.mEngineBlockingItem.b(this.f70166c);
            b.this.mStatue = EngineStatue.INSTANCE.c();
            d.f70187b.c(b.this.getModuleId());
        }

        @Override // com.tencent.ams.dsdk.core.mosaic.OnCreateMosaicEngineListener
        public void onSoLoadFailed(int failReason) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, failReason);
                return;
            }
            com.tencent.ams.dynamicwidget.utils.b.f70218a.d(b.this.f(), "preWarmMosaicEngine - onSoLoadFailed: " + failReason);
            b.this.mStatue = EngineStatue.INSTANCE.d();
            d.f70187b.d(b.this.getModuleId(), failReason);
        }

        @Override // com.tencent.ams.dsdk.core.mosaic.OnCreateMosaicEngineListener
        public void onSoLoadStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.ams.dsdk.core.mosaic.OnCreateMosaicEngineListener
        public void onSoLoadSuccess(int state) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, state);
                return;
            }
            com.tencent.ams.dynamicwidget.utils.b.f70218a.c(b.this.f(), "preWarmMosaicEngine - onSoLoadSuccess");
            b.this.mStatue = EngineStatue.INSTANCE.e();
            d.f70187b.e(b.this.getModuleId(), state);
        }

        @Override // com.tencent.ams.dsdk.core.DKEngine.OnCreateEngineListener
        public void onWillCreateEngine() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
                return;
            }
            com.tencent.ams.dynamicwidget.utils.b.f70218a.c(b.this.f(), "preWarmMosaicEngine - onWillCreateEngine");
            this.startTime = SystemClock.elapsedRealtime();
            b.this.mStatue = EngineStatue.INSTANCE.a();
            b.this.mInitError = 0;
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        DebugUtils.d().k("9.165.170.200");
        this.mEngineBlockingItem = new com.tencent.ams.dynamicwidget.utils.a<>();
        this.mStatue = EngineStatue.INSTANCE.f();
    }

    @Nullable
    public Map<String, String> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Map) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return null;
    }

    @NotNull
    public abstract String f();

    public synchronized void g(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        if (context == null) {
            com.tencent.ams.dynamicwidget.utils.b.f70218a.d(f(), "preWarmMosaicEngine cancel: context must be not null");
            return;
        }
        if (this.mEngineBlockingItem.a() != null) {
            com.tencent.ams.dynamicwidget.utils.b.f70218a.a(f(), "preWarmMosaicEngine cancel: exist a warmed engine");
            return;
        }
        com.tencent.ams.dynamicwidget.utils.b.f70218a.c(f(), "preWarmMosaicEngine start, moduleId:" + getModuleId() + ", adType:" + getAdType());
        this.context = context.getApplicationContext();
        d.f70187b.b(getModuleId());
        DKMosaicEngine dKMosaicEngine = new DKMosaicEngine();
        HashMap hashMap = new HashMap();
        hashMap.put(DKEngine.PARAM_KEY_APP_NAME, getModuleId());
        hashMap.put(DKEngine.PARAM_KEY_AD_TYPE, getAdType());
        c cVar = c.f70185s;
        if (cVar.i()) {
            String c16 = cVar.c();
            if (c16 != null) {
                hashMap.put(DKEngine.PARAM_KEY_IS_DEBUG_MODE, "1");
                hashMap.put(DKEngine.PARAM_KEY_JS_DEBUG_FILE_PATH, c16);
            }
            String b16 = cVar.b();
            if (b16 != null) {
                hashMap.put(DKEngine.PARAM_KEY_IS_DEBUG_MODE, "1");
                hashMap.put(DKEngine.PARAM_KEY_JS_ASSETS_PATH, b16);
            }
        }
        Map<String, String> e16 = e();
        if (e16 != null) {
            hashMap.putAll(e16);
        }
        dKMosaicEngine.setRequiredTemplate(cVar.l());
        f.c d16 = cVar.d();
        if (d16 == null) {
            d16 = new com.tencent.ams.mosaic.utils.e();
        }
        dKMosaicEngine.setImageLoader(d16);
        dKMosaicEngine.setVideoLoader(cVar.g());
        dKMosaicEngine.createEngine2(context, (Map<String, String>) hashMap, (OnCreateMosaicEngineListener) new a(dKMosaicEngine));
        this.mHasPreWarmed = true;
    }
}
