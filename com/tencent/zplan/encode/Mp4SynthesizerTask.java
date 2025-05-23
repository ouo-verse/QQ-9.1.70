package com.tencent.zplan.encode;

import android.util.Log;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.raft.codegenmeta.utils.RLog;
import cooperation.qzone.webviewplugin.personalize.QZoneCoverStoreJsPlugin;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b/\u0018\u0000 \u00032\u00020\u0001:\u0002CDBK\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u00104\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010@\u001a\u00020\r\u00a2\u0006\u0004\bA\u0010BJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002JA\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\rH\u0082 J1\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\nH\u0082 J1\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\nH\u0082 J1\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\nH\u0082 JA\u0010 \u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\nH\u0082 JA\u0010!\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\nH\u0082 JA\u0010\"\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\nH\u0082 J\u0011\u0010#\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0013H\u0082 J\u0011\u0010$\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0013H\u0082 J\u0011\u0010%\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0013H\u0082 J\u0011\u0010&\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0082 J&\u0010'\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\nJ6\u0010(\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\nJ6\u0010)\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\nJ6\u0010*\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\nJ\u0006\u0010+\u001a\u00020\u0002J\u0006\u0010,\u001a\u00020\u0013J\b\u0010-\u001a\u00020\u0007H\u0004R\u0017\u0010\u000e\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0014\u00104\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R+\u0010<\u001a\u00020\u00132\u0006\u00105\u001a\u00020\u00138B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>\u00a8\u0006E"}, d2 = {"Lcom/tencent/zplan/encode/Mp4SynthesizerTask;", "", "", "e", "result", "Lcom/tencent/zplan/encode/Mp4SynthesizerTask$State;", "expectState", "", "i", "p", "", "width", "height", "", "filePath", "frameRate", "tempPath", "enableBFrame", "mp4TempFilePath", "", "initialize", "synthesizer", "", "pixel", "dataSize", "pts", "index", "inputFrame", "inputYUVFrame", "inputAlphaAndRGBFrame", "sourceWidth", "sourceHeight", "inputRGBAFrameWithNeon", "inputRGBAFrame", "inputRGBAFrameWithLibYuv", "inputEnd", "releaseSynthesizer", "tearDown", "getConvertTimeCost", "j", DomainData.DOMAIN_NAME, "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "f", "finalize", "a", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "b", "Z", "isDebug", "<set-?>", "c", "Lkotlin/properties/ReadWriteProperty;", tl.h.F, "()J", "o", "(J)V", "synthesizerHandle", "d", "Lcom/tencent/zplan/encode/Mp4SynthesizerTask$State;", "state", "mp4TempPath", "<init>", "(IILjava/lang/String;ILjava/lang/String;ZZLjava/lang/String;)V", "Companion", "State", "mp4_encoder_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes38.dex */
public final class Mp4SynthesizerTask {

    /* renamed from: g, reason: collision with root package name */
    private static String f385304g;

    /* renamed from: h, reason: collision with root package name */
    private static Boolean f385305h;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String filePath;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean isDebug;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ReadWriteProperty synthesizerHandle;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private State state;

    /* renamed from: f, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f385303f = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(Mp4SynthesizerTask.class, "synthesizerHandle", "getSynthesizerHandle()J", 0))};

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\t\u0010\u0006\u001a\u00020\u0005H\u0082 J\t\u0010\b\u001a\u00020\u0007H\u0082 R$\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\n\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/zplan/encode/Mp4SynthesizerTask$Companion;", "", "", "d", "c", "", "getVersionTag", "", "supportNeon", "tag", "Ljava/lang/String;", "f", "()Ljava/lang/String;", tl.h.F, "(Ljava/lang/String;)V", "Ljava/lang/Boolean;", "e", "()Ljava/lang/Boolean;", "g", "(Ljava/lang/Boolean;)V", "TAG", "<init>", "()V", "mp4_encoder_debug"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void c() {
            Boolean bool;
            try {
                bool = Boolean.valueOf(supportNeon());
            } catch (Throwable unused) {
                Log.d("Mp4SynthesizerTask", "supportNeon unFound");
                bool = Boolean.FALSE;
            }
            g(bool);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d() {
            String str;
            try {
                str = getVersionTag();
            } catch (Throwable unused) {
                Log.d("Mp4SynthesizerTask", "checkVersion unFound");
                str = "1.0.1";
            }
            h(str);
        }

        private final native String getVersionTag();

        private final native boolean supportNeon();

        public final Boolean e() {
            return Mp4SynthesizerTask.f385305h;
        }

        public final String f() {
            return Mp4SynthesizerTask.f385304g;
        }

        public final void g(Boolean bool) {
            Mp4SynthesizerTask.f385305h = bool;
        }

        public final void h(String str) {
            Mp4SynthesizerTask.f385304g = str;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/zplan/encode/Mp4SynthesizerTask$State;", "", "(Ljava/lang/String;I)V", "UnKnow", QZoneCoverStoreJsPlugin.INIT_PLUGIN, "Running", RLog.ERROR, "SUCCESS", "Complete", "mp4_encoder_debug"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes38.dex */
    public enum State {
        UnKnow,
        Init,
        Running,
        ERROR,
        SUCCESS,
        Complete
    }

    private final boolean e() {
        State state = this.state;
        return state == State.Init || state == State.Running;
    }

    private final native long getConvertTimeCost(long synthesizer);

    private final long h() {
        return ((Number) this.synthesizerHandle.getValue(this, f385303f[0])).longValue();
    }

    private final native long initialize(int width, int height, String filePath, int frameRate, String tempPath, boolean enableBFrame, String mp4TempFilePath);

    private final native boolean inputAlphaAndRGBFrame(long synthesizer, byte[] pixel, int dataSize, long pts, int index);

    private final native boolean inputEnd(long synthesizer);

    private final native boolean inputFrame(long synthesizer, byte[] pixel, int dataSize, long pts, int index);

    private final native boolean inputRGBAFrame(long synthesizer, byte[] pixel, int dataSize, long pts, int index, int sourceWidth, int sourceHeight);

    private final native boolean inputRGBAFrameWithLibYuv(long synthesizer, byte[] pixel, int dataSize, long pts, int index, int sourceWidth, int sourceHeight);

    private final native boolean inputRGBAFrameWithNeon(long synthesizer, byte[] pixel, int dataSize, long pts, int index, int sourceWidth, int sourceHeight);

    private final native boolean inputYUVFrame(long synthesizer, byte[] pixel, int dataSize, long pts, int index);

    private final void o(long j3) {
        this.synthesizerHandle.setValue(this, f385303f[0], Long.valueOf(j3));
    }

    private final void p() {
        State state = this.state;
        if (!(state == State.ERROR || state == State.SUCCESS) || h() <= 0) {
            return;
        }
        boolean tearDown = tearDown(h());
        Log.d("Mp4SynthesizerTask", "tearDownIfNeed state:" + this.state + " tearDown " + tearDown);
        i(tearDown, State.Complete);
    }

    private final native boolean releaseSynthesizer(long synthesizer);

    private final native boolean tearDown(long synthesizer);

    public final long f() {
        return getConvertTimeCost(h());
    }

    protected final void finalize() {
        Log.d("Mp4SynthesizerTask", "finalize");
    }

    /* renamed from: g, reason: from getter */
    public final String getFilePath() {
        return this.filePath;
    }

    public final void j(byte[] pixel, int dataSize, long pts, int index) {
        boolean inputYUVFrame;
        Intrinsics.checkNotNullParameter(pixel, "pixel");
        if (!e() || h() <= 0) {
            return;
        }
        if (this.isDebug) {
            Log.d("Mp4SynthesizerTask", "inputFrame");
        }
        String str = f385304g;
        if (Intrinsics.areEqual(str, "1.0.1")) {
            inputYUVFrame = inputFrame(h(), pixel, dataSize, pts, index);
        } else {
            inputYUVFrame = Intrinsics.areEqual(str, "1.0.14") ? inputYUVFrame(h(), pixel, dataSize, pts, index) : false;
        }
        i(inputYUVFrame, State.Running);
    }

    public final boolean k() {
        if (!e() || h() <= 0) {
            return false;
        }
        if (this.isDebug) {
            Log.d("Mp4SynthesizerTask", "inputFrameEnd");
        }
        boolean inputEnd = inputEnd(h());
        i(inputEnd, State.SUCCESS);
        return inputEnd;
    }

    public final void l(byte[] pixel, int dataSize, long pts, int index, int sourceWidth, int sourceHeight) {
        Intrinsics.checkNotNullParameter(pixel, "pixel");
        if (!e() || h() <= 0) {
            return;
        }
        if (this.isDebug) {
            Log.d("Mp4SynthesizerTask", "input origin RGBA Frame");
        }
        i(inputRGBAFrame(h(), pixel, dataSize, pts, index, sourceWidth, sourceHeight), State.Running);
    }

    public final void m(byte[] pixel, int dataSize, long pts, int index, int sourceWidth, int sourceHeight) {
        Intrinsics.checkNotNullParameter(pixel, "pixel");
        if (!e() || h() <= 0) {
            return;
        }
        if (this.isDebug) {
            Log.d("Mp4SynthesizerTask", "input origin RGBA Frame with c++ and libyuv");
        }
        i(inputRGBAFrameWithLibYuv(h(), pixel, dataSize, pts, index, sourceWidth, sourceHeight), State.Running);
    }

    public final void n(byte[] pixel, int dataSize, long pts, int index, int sourceWidth, int sourceHeight) {
        Intrinsics.checkNotNullParameter(pixel, "pixel");
        if (!e() || h() <= 0) {
            return;
        }
        if (this.isDebug) {
            Log.d("Mp4SynthesizerTask", "input origin RGBA Frame");
        }
        i(inputRGBAFrameWithNeon(h(), pixel, dataSize, pts, index, sourceWidth, sourceHeight), State.Running);
    }

    public Mp4SynthesizerTask(int i3, int i16, String filePath, int i17, String tempPath, boolean z16, boolean z17, String mp4TempPath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(tempPath, "tempPath");
        Intrinsics.checkNotNullParameter(mp4TempPath, "mp4TempPath");
        this.filePath = filePath;
        this.isDebug = z16;
        this.synthesizerHandle = Delegates.INSTANCE.notNull();
        this.state = State.UnKnow;
        o(initialize(i3, i16, filePath, i17, tempPath, z17, mp4TempPath));
        if (f385304g == null) {
            INSTANCE.d();
        }
        if (f385305h == null) {
            INSTANCE.c();
        }
        i(h() > 0, State.Init);
    }

    private final void i(boolean result, State expectState) {
        if (!result) {
            expectState = State.ERROR;
        }
        this.state = expectState;
        p();
    }
}
