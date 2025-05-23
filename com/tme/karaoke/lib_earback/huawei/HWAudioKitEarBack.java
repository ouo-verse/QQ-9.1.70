package com.tme.karaoke.lib_earback.huawei;

import android.os.Build;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.multimedia.audiokit.interfaces.HwAudioKaraokeFeatureKit;
import com.huawei.multimedia.audiokit.interfaces.HwAudioKit;
import com.huawei.multimedia.audiokit.interfaces.IAudioKitCallback;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tme.karaoke.lib_earback.EarBackScene;
import com.tme.karaoke.lib_earback.EarBackType;
import com.tme.karaoke.lib_earback.base.a;
import cooperation.qzone.QzoneIPCModule;
import cooperation.qzone.webviewplugin.personalize.QZoneCoverStoreJsPlugin;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsKt;
import my4.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0011EB\u0007\u00a2\u0006\u0004\bC\u0010DJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\u0006\u0010\b\u001a\u00020\u0003J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0006\u0010\u0015\u001a\u00020\u0014R\u001a\u0010\u0019\u001a\u00020\t8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\r\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001b\u001a\u00020\t8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\u001a\u0010\u001e\u001a\u00020\t8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018R\u0016\u0010 \u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\"\u0010-\u001a\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b\u001c\u0010*\"\u0004\b+\u0010,R2\u00104\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000/0.j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000/`18\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010;\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u001a\u0010B\u001a\u00020\u00148\u0006X\u0086D\u00a2\u0006\f\n\u0004\b?\u0010=\u001a\u0004\b@\u0010A\u00a8\u0006F"}, d2 = {"Lcom/tme/karaoke/lib_earback/huawei/HWAudioKitEarBack;", "Lcom/tme/karaoke/lib_earback/d;", "Lcom/huawei/multimedia/audiokit/interfaces/IAudioKitCallback;", "", "g", "", "i", h.F, "b", "", QzoneIPCModule.RESULT_CODE, "onResult", "Lcom/tme/karaoke/lib_earback/EarBackType;", "d", "on", "Lcom/tme/karaoke/lib_earback/EarBackScene;", "scene", "a", "Lcom/huawei/multimedia/audiokit/interfaces/HwAudioKit;", "c", "", "e", "I", "getREVERB_TYPE_KTV", "()I", "REVERB_TYPE_KTV", "getREVERB_TYPE_THEATRE", "REVERB_TYPE_THEATRE", "f", "getREVERB_TYPE_CONCERT", "REVERB_TYPE_CONCERT", "Lcom/tme/karaoke/lib_earback/EarBackType;", "mCurEarBackType", "Lcom/huawei/multimedia/audiokit/interfaces/HwAudioKit;", "mHwAudioKit", "Lcom/huawei/multimedia/audiokit/interfaces/HwAudioKaraokeFeatureKit;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/huawei/multimedia/audiokit/interfaces/HwAudioKaraokeFeatureKit;", "mHwKaraokeFeatureKit", "Lcom/tme/karaoke/lib_earback/huawei/HWAudioKitEarBack$ModeState;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tme/karaoke/lib_earback/huawei/HWAudioKitEarBack$ModeState;", "()Lcom/tme/karaoke/lib_earback/huawei/HWAudioKitEarBack$ModeState;", "setMMode", "(Lcom/tme/karaoke/lib_earback/huawei/HWAudioKitEarBack$ModeState;)V", "mMode", "Ljava/util/ArrayList;", "Ljava/lang/ref/WeakReference;", "Lcom/tme/karaoke/lib_earback/huawei/d;", "Lkotlin/collections/ArrayList;", "D", "Ljava/util/ArrayList;", "hwAudioKitCallBackRefList", "Lcom/tme/karaoke/lib_earback/huawei/HWAudioKitEarBack$a;", "E", "Lcom/tme/karaoke/lib_earback/huawei/HWAudioKitEarBack$a;", "effectParam", UserInfo.SEX_FEMALE, "Z", "isAudioKitDegrade", "G", "Ljava/lang/String;", "lastAudioKitResultCode", "H", "getTAG", "()Ljava/lang/String;", "TAG", "<init>", "()V", "ModeState", "lib_earback_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes27.dex */
public final class HWAudioKitEarBack implements com.tme.karaoke.lib_earback.d, IAudioKitCallback {

    /* renamed from: F, reason: from kotlin metadata */
    private boolean isAudioKitDegrade;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private HwAudioKit mHwAudioKit;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private HwAudioKaraokeFeatureKit mHwKaraokeFeatureKit;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int REVERB_TYPE_KTV = 1;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final int REVERB_TYPE_THEATRE = 2;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int REVERB_TYPE_CONCERT = 3;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private EarBackType mCurEarBackType = EarBackType.None;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private ModeState mMode = ModeState.None;

    /* renamed from: D, reason: from kotlin metadata */
    private ArrayList<WeakReference<d>> hwAudioKitCallBackRefList = new ArrayList<>();

    /* renamed from: E, reason: from kotlin metadata */
    private EffectParam effectParam = new EffectParam(0.0f, 0, 0, 7, null);

    /* renamed from: G, reason: from kotlin metadata */
    private String lastAudioKitResultCode = "";

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final String TAG = "HWAudioKitEarBack";

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tme/karaoke/lib_earback/huawei/HWAudioKitEarBack$ModeState;", "", "(Ljava/lang/String;I)V", "None", "PreInit", QZoneCoverStoreJsPlugin.INIT_PLUGIN, "KARAOKE_SUCCESS", "lib_earback_release"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes27.dex */
    public enum ModeState {
        None,
        PreInit,
        Init,
        KARAOKE_SUCCESS
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0011\u001a\u0004\b\n\u0010\u0013\"\u0004\b\u0017\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tme/karaoke/lib_earback/huawei/HWAudioKitEarBack$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", UserInfo.SEX_FEMALE, "b", "()F", "setMicVol", "(F)V", "micVol", "I", "c", "()I", "setReverbId", "(I)V", "reverbId", "setEq", "eq", "<init>", "(FII)V", "lib_earback_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tme.karaoke.lib_earback.huawei.HWAudioKitEarBack$a, reason: from toString */
    /* loaded from: classes27.dex */
    public static final /* data */ class EffectParam {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private float micVol;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private int reverbId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private int eq;

        public EffectParam() {
            this(0.0f, 0, 0, 7, null);
        }

        /* renamed from: a, reason: from getter */
        public final int getEq() {
            return this.eq;
        }

        /* renamed from: b, reason: from getter */
        public final float getMicVol() {
            return this.micVol;
        }

        /* renamed from: c, reason: from getter */
        public final int getReverbId() {
            return this.reverbId;
        }

        public boolean equals(@Nullable Object other) {
            boolean z16;
            boolean z17;
            if (this != other) {
                if (other instanceof EffectParam) {
                    EffectParam effectParam = (EffectParam) other;
                    if (Float.compare(this.micVol, effectParam.micVol) == 0) {
                        if (this.reverbId == effectParam.reverbId) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            if (this.eq == effectParam.eq) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (z17) {
                            }
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((Float.floatToIntBits(this.micVol) * 31) + this.reverbId) * 31) + this.eq;
        }

        @NotNull
        public String toString() {
            return "EffectParam(micVol=" + this.micVol + ", reverbId=" + this.reverbId + ", eq=" + this.eq + ')';
        }

        public EffectParam(float f16, int i3, int i16) {
            this.micVol = f16;
            this.reverbId = i3;
            this.eq = i16;
        }

        public /* synthetic */ EffectParam(float f16, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this((i17 & 1) != 0 ? 0.5f : f16, (i17 & 2) != 0 ? 1 : i3, (i17 & 4) != 0 ? 1 : i16);
        }
    }

    private final void g() {
        HwAudioKaraokeFeatureKit hwAudioKaraokeFeatureKit;
        if (i()) {
            com.tme.karaoke.lib_earback.base.c.m("huawei audiokit preInvalid return");
            return;
        }
        if (d() != EarBackType.HuaweiAudioKitEarBackType) {
            com.tme.karaoke.lib_earback.base.c.m("when init,but don't support huawei audiokit");
            return;
        }
        ModeState modeState = this.mMode;
        ModeState modeState2 = ModeState.Init;
        if (modeState != modeState2 && modeState != ModeState.KARAOKE_SUCCESS) {
            if (com.tme.karaoke.lib_earback.base.b.a() != null) {
                b();
                this.mMode = modeState2;
                HwAudioKit hwAudioKit = new HwAudioKit(com.tme.karaoke.lib_earback.base.b.a(), this);
                this.mHwAudioKit = hwAudioKit;
                hwAudioKit.initialize();
                this.lastAudioKitResultCode = "";
                com.tme.karaoke.lib_earback.base.c.m("initialize mHwKaraokeFeatureKit");
                HwAudioKit hwAudioKit2 = this.mHwAudioKit;
                if (hwAudioKit2 != null) {
                    hwAudioKaraokeFeatureKit = (HwAudioKaraokeFeatureKit) hwAudioKit2.createFeature(HwAudioKit.FeatureType.HWAUDIO_FEATURE_KARAOKE);
                } else {
                    hwAudioKaraokeFeatureKit = null;
                }
                this.mHwKaraokeFeatureKit = hwAudioKaraokeFeatureKit;
                return;
            }
            com.tme.karaoke.lib_earback.base.c.m("earbackSdkContext is null");
            return;
        }
        com.tme.karaoke.lib_earback.base.c.m("has init before,don't init again\uff0cmMode = " + this.mMode);
    }

    private final void h() {
        my4.b.f417812b.a(b.TimeSlotScene.C10809a.f417815c);
        if (com.tme.karaoke.lib_earback.base.b.a() != null) {
            this.mMode = ModeState.PreInit;
            HwAudioKit hwAudioKit = new HwAudioKit(com.tme.karaoke.lib_earback.base.b.a(), this);
            this.mHwAudioKit = hwAudioKit;
            hwAudioKit.initialize();
            this.lastAudioKitResultCode = "";
            this.isAudioKitDegrade = false;
            return;
        }
        com.tme.karaoke.lib_earback.base.c.m("preInit interrupt");
    }

    private final boolean i() {
        boolean contains$default;
        boolean contains;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("sdkInt = ");
        int i3 = Build.VERSION.SDK_INT;
        sb5.append(i3);
        sb5.append(",MANUFACTURER = ");
        String str = Build.MANUFACTURER;
        sb5.append(str);
        com.tme.karaoke.lib_earback.base.c.m(sb5.toString());
        if (i3 <= 28) {
            return true;
        }
        Intrinsics.checkExpressionValueIsNotNull(str, "Build.MANUFACTURER");
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "HUAWEI", false, 2, (Object) null);
        if (!contains$default) {
            Intrinsics.checkExpressionValueIsNotNull(str, "Build.MANUFACTURER");
            contains = StringsKt__StringsKt.contains((CharSequence) str, (CharSequence) CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HONOR, true);
            if (!contains) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tme.karaoke.lib_earback.d
    public boolean a(boolean on5, @NotNull EarBackScene scene) {
        Intrinsics.checkParameterIsNotNull(scene, "scene");
        com.tme.karaoke.lib_earback.base.c.m("turnEarbackSwitch(on=" + on5 + ",scene=" + scene + "),mMode = " + this.mMode);
        ModeState modeState = this.mMode;
        if (modeState == ModeState.KARAOKE_SUCCESS) {
            int i3 = -1;
            try {
                HwAudioKaraokeFeatureKit hwAudioKaraokeFeatureKit = this.mHwKaraokeFeatureKit;
                if (hwAudioKaraokeFeatureKit == null) {
                    Intrinsics.throwNpe();
                }
                i3 = hwAudioKaraokeFeatureKit.enableKaraokeFeature(on5);
                com.tme.karaoke.lib_earback.base.c.m("enableKaraokeFeature on:" + on5 + " enableResult:" + i3);
            } catch (Throwable th5) {
                if (Reflection.getOrCreateKotlinClass(Unit.class).isInstance(a.C10084a.f386971a)) {
                    com.tme.karaoke.lib_earback.base.c.m("need report");
                } else if (Reflection.getOrCreateKotlinClass(Unit.class).isInstance(a.b.f386972a)) {
                    com.tme.karaoke.lib_earback.base.c.m("EarBackErrorType report for otherearbacktype");
                }
                com.tme.karaoke.lib_earback.base.c.m("exception occur in try," + th5.getMessage());
                th5.printStackTrace();
                Unit unit = Unit.INSTANCE;
            }
            if (i3 >= 0) {
                Unit unit2 = Unit.INSTANCE;
                if (i3 != 0 || !on5) {
                    return false;
                }
                return true;
            }
            throw new Exception("enableKaraokeFeature error>>>enableResult = " + i3);
        }
        if (modeState == ModeState.PreInit && on5) {
            com.tme.karaoke.lib_earback.base.c.m("try call Init in turnEarbackSwitch");
            g();
        }
        return false;
    }

    public final void b() {
        com.tme.karaoke.lib_earback.base.c.m("ondestory\uff0cmMode=" + this.mMode);
        if (this.mMode == ModeState.None) {
            com.tme.karaoke.lib_earback.base.c.m("ondestory\uff0cmMode==none, do not destory mHwAudioKit");
            return;
        }
        this.mMode = ModeState.PreInit;
        HwAudioKit hwAudioKit = this.mHwAudioKit;
        if (hwAudioKit != null) {
            hwAudioKit.destroy();
        }
        this.mHwAudioKit = null;
        my4.b.f417812b.b();
        HwAudioKaraokeFeatureKit hwAudioKaraokeFeatureKit = this.mHwKaraokeFeatureKit;
        if (hwAudioKaraokeFeatureKit != null) {
            hwAudioKaraokeFeatureKit.destroy();
        }
        this.mHwKaraokeFeatureKit = null;
        this.isAudioKitDegrade = false;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final HwAudioKit getMHwAudioKit() {
        return this.mHwAudioKit;
    }

    @NotNull
    public EarBackType d() {
        EarBackType earBackType = this.mCurEarBackType;
        EarBackType earBackType2 = EarBackType.None;
        if (earBackType == earBackType2 && this.mMode == ModeState.None) {
            if (i()) {
                return earBackType2;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("call threadName = ");
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
            sb5.append(currentThread.getName());
            com.tme.karaoke.lib_earback.base.c.m(sb5.toString());
            h();
            return this.mCurEarBackType;
        }
        return earBackType;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getLastAudioKitResultCode() {
        return this.lastAudioKitResultCode;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final ModeState getMMode() {
        return this.mMode;
    }

    @Override // com.huawei.multimedia.audiokit.interfaces.IAudioKitCallback
    public void onResult(int resultCode) {
        boolean z16;
        boolean z17;
        this.lastAudioKitResultCode = String.valueOf(resultCode);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("receiver audioKitCallback result = ");
        sb5.append(resultCode);
        sb5.append(",and the callback thread name = ");
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(currentThread, "Thread.currentThread()");
        sb5.append(currentThread.getName());
        com.tme.karaoke.lib_earback.base.c.m(sb5.toString());
        com.tme.karaoke.lib_earback.base.c.m("init mode = " + this.mMode);
        if (this.mHwAudioKit != null) {
            Iterator<T> it = this.hwAudioKitCallBackRefList.iterator();
            while (it.hasNext()) {
                d dVar = (d) ((WeakReference) it.next()).get();
                if (dVar != null) {
                    dVar.c(resultCode);
                }
            }
            if (resultCode != -2) {
                if (resultCode != 0) {
                    if (resultCode != 2) {
                        switch (resultCode) {
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                                break;
                            default:
                                switch (resultCode) {
                                    case 1000:
                                        try {
                                            HwAudioKaraokeFeatureKit hwAudioKaraokeFeatureKit = this.mHwKaraokeFeatureKit;
                                            if (hwAudioKaraokeFeatureKit != null) {
                                                if (this.mMode == ModeState.Init) {
                                                    if (hwAudioKaraokeFeatureKit == null) {
                                                        Intrinsics.throwNpe();
                                                    }
                                                    com.tme.karaoke.lib_earback.base.c.m("enableKaraokeFtRet = " + hwAudioKaraokeFeatureKit.enableKaraokeFeature(true) + ",effectParam info=" + this.effectParam);
                                                    HwAudioKaraokeFeatureKit hwAudioKaraokeFeatureKit2 = this.mHwKaraokeFeatureKit;
                                                    if (hwAudioKaraokeFeatureKit2 == null) {
                                                        Intrinsics.throwNpe();
                                                    }
                                                    com.tme.karaoke.lib_earback.base.c.m("onResult: setCMD_SET_VOCAL_VOLUME_BASE success=" + hwAudioKaraokeFeatureKit2.setParameter(HwAudioKaraokeFeatureKit.ParameName.CMD_SET_VOCAL_VOLUME_BASE, (int) (this.effectParam.getMicVol() * 100)));
                                                    HwAudioKaraokeFeatureKit hwAudioKaraokeFeatureKit3 = this.mHwKaraokeFeatureKit;
                                                    if (hwAudioKaraokeFeatureKit3 == null) {
                                                        Intrinsics.throwNpe();
                                                    }
                                                    HwAudioKaraokeFeatureKit.ParameName parameName = HwAudioKaraokeFeatureKit.ParameName.CMD_SET_AUDIO_EFFECT_MODE_BASE;
                                                    com.tme.karaoke.lib_earback.base.c.m("onResult: setCMD_SET_AUDIO_EFFECT_MODE_BASE success=" + hwAudioKaraokeFeatureKit3.setParameter(parameName, this.effectParam.getReverbId()));
                                                    HwAudioKaraokeFeatureKit hwAudioKaraokeFeatureKit4 = this.mHwKaraokeFeatureKit;
                                                    if (hwAudioKaraokeFeatureKit4 == null) {
                                                        Intrinsics.throwNpe();
                                                    }
                                                    com.tme.karaoke.lib_earback.base.c.m("onResult: setCMD_SET_AUDIO_EFFECT_MODE_BASE success=" + hwAudioKaraokeFeatureKit4.setParameter(parameName, this.effectParam.getEq()));
                                                    HwAudioKaraokeFeatureKit hwAudioKaraokeFeatureKit5 = this.mHwKaraokeFeatureKit;
                                                    if (hwAudioKaraokeFeatureKit5 == null) {
                                                        Intrinsics.throwNpe();
                                                    }
                                                    com.tme.karaoke.lib_earback.base.c.m("onResult: getLatency=" + hwAudioKaraokeFeatureKit5.getKaraokeLatency());
                                                    this.mMode = ModeState.KARAOKE_SUCCESS;
                                                }
                                                Iterator<T> it5 = this.hwAudioKitCallBackRefList.iterator();
                                                while (it5.hasNext()) {
                                                    d dVar2 = (d) ((WeakReference) it5.next()).get();
                                                    if (dVar2 != null) {
                                                        if (this.mCurEarBackType == EarBackType.HuaweiAudioKitEarBackType) {
                                                            z17 = true;
                                                        } else {
                                                            z17 = false;
                                                        }
                                                        dVar2.a(z17);
                                                    }
                                                }
                                                Unit unit = Unit.INSTANCE;
                                                return;
                                            }
                                            throw new IllegalStateException("mHwKaraokeFeatureKit is null in karaoke_success callback");
                                        } catch (Throwable th5) {
                                            if (Reflection.getOrCreateKotlinClass(Unit.class).isInstance(a.C10084a.f386971a)) {
                                                com.tme.karaoke.lib_earback.base.c.m("need report");
                                            } else if (Reflection.getOrCreateKotlinClass(Unit.class).isInstance(a.b.f386972a)) {
                                                com.tme.karaoke.lib_earback.base.c.m("EarBackErrorType report for otherearbacktype");
                                            }
                                            com.tme.karaoke.lib_earback.base.c.m("exception occur in try," + th5.getMessage());
                                            th5.printStackTrace();
                                            Unit unit2 = Unit.INSTANCE;
                                            return;
                                        }
                                    case 1001:
                                    case 1002:
                                    case 1003:
                                        break;
                                    default:
                                        return;
                                }
                        }
                    } else {
                        this.mCurEarBackType = EarBackType.None;
                        return;
                    }
                } else {
                    if (this.mMode == ModeState.Init) {
                        com.tme.karaoke.lib_earback.base.c.m("it use for init,don't do it again");
                        return;
                    }
                    try {
                        HwAudioKit hwAudioKit = this.mHwAudioKit;
                        if (hwAudioKit != null) {
                            if (hwAudioKit.isFeatureSupported(HwAudioKit.FeatureType.HWAUDIO_FEATURE_KARAOKE)) {
                                com.tme.karaoke.lib_earback.base.c.m("support feature HWAUDIO_FEATURE_KARAOKE");
                                this.mCurEarBackType = EarBackType.HuaweiAudioKitEarBackType;
                            } else {
                                com.tme.karaoke.lib_earback.base.c.m("not support feature HWAUDIO_FEATURE_KARAOKE");
                            }
                            my4.b.f417812b.a(b.TimeSlotScene.C10809a.f417815c);
                            Iterator<T> it6 = this.hwAudioKitCallBackRefList.iterator();
                            while (it6.hasNext()) {
                                d dVar3 = (d) ((WeakReference) it6.next()).get();
                                if (dVar3 != null) {
                                    if (this.mCurEarBackType == EarBackType.HuaweiAudioKitEarBackType) {
                                        z16 = true;
                                    } else {
                                        z16 = false;
                                    }
                                    dVar3.a(z16);
                                }
                            }
                            a.C10084a c10084a = a.C10084a.f386971a;
                            return;
                        }
                        throw new IllegalStateException("init hwaudiokit success,but mHwAudioKit is null");
                    } catch (Throwable th6) {
                        if (Reflection.getOrCreateKotlinClass(a.C10084a.class).isInstance(a.C10084a.f386971a)) {
                            com.tme.karaoke.lib_earback.base.c.m("need report");
                        } else if (Reflection.getOrCreateKotlinClass(a.C10084a.class).isInstance(a.b.f386972a)) {
                            com.tme.karaoke.lib_earback.base.c.m("EarBackErrorType report for otherearbacktype");
                        }
                        com.tme.karaoke.lib_earback.base.c.m("exception occur in try," + th6.getMessage());
                        th6.printStackTrace();
                        Unit unit3 = Unit.INSTANCE;
                        return;
                    }
                }
            }
            if (!b.f386994c.b()) {
                com.tme.karaoke.lib_earback.base.c.m("is not switch on degrade");
                return;
            }
            if (!this.isAudioKitDegrade) {
                Iterator<T> it7 = this.hwAudioKitCallBackRefList.iterator();
                while (it7.hasNext()) {
                    d dVar4 = (d) ((WeakReference) it7.next()).get();
                    if (dVar4 != null) {
                        dVar4.b(resultCode);
                    }
                }
                this.isAudioKitDegrade = true;
                return;
            }
            return;
        }
        com.tme.karaoke.lib_earback.base.c.m("receiver audioKitCallback result, but mHwAudioKit == null");
    }
}
