package com.tencent.kuikly.core.base;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 \u00072\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b$\u0010%J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005J\b\u0010\t\u001a\u00020\bH\u0016R\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u000fR\u0016\u0010\u001a\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u000fR\u0016\u0010\u001d\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\"\u0010#\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/kuikly/core/base/b;", "", "", "time", tl.h.F, "", "forever", "i", "", "toString", "Lcom/tencent/kuikly/core/base/TimingFuncType;", "a", "Lcom/tencent/kuikly/core/base/TimingFuncType;", "timingFuncType", "b", UserInfo.SEX_FEMALE, "duration", "Lcom/tencent/kuikly/core/base/AnimationType;", "c", "Lcom/tencent/kuikly/core/base/AnimationType;", "animationType", "d", "damping", "e", "velocity", "f", "delay", "g", "Z", "repeatForever", "Ljava/lang/String;", "getKey", "()Ljava/lang/String;", "j", "(Ljava/lang/String;)V", "key", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class b {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private TimingFuncType timingFuncType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private float duration;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float damping;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float velocity;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float delay;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean repeatForever;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private AnimationType animationType = AnimationType.PLAIN;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String key = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J(\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J(\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J(\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J(\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J<\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0005\u001a\u00020\u0004JD\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/kuikly/core/base/b$a;", "", "", "durationS", "", "key", "Lcom/tencent/kuikly/core/base/b;", "k", "e", "i", "g", "damping", "velocity", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "Lcom/tencent/kuikly/core/base/AnimationType;", "animationType", "Lcom/tencent/kuikly/core/base/TimingFuncType;", "timingFuncType", "delay", "", "repeatForever", "a", "c", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.kuikly.core.base.b$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final b a(AnimationType animationType, TimingFuncType timingFuncType, float durationS, float delay, boolean repeatForever, String key) {
            Intrinsics.checkNotNullParameter(animationType, "animationType");
            Intrinsics.checkNotNullParameter(timingFuncType, "timingFuncType");
            Intrinsics.checkNotNullParameter(key, "key");
            b bVar = new b();
            bVar.animationType = animationType;
            bVar.timingFuncType = timingFuncType;
            bVar.duration = durationS;
            bVar.delay = delay;
            bVar.repeatForever = repeatForever;
            bVar.j(key);
            return bVar;
        }

        public final b c(TimingFuncType timingFuncType, float durationS, float damping, float velocity, float delay, boolean repeatForever, String key) {
            Intrinsics.checkNotNullParameter(timingFuncType, "timingFuncType");
            Intrinsics.checkNotNullParameter(key, "key");
            b bVar = new b();
            bVar.animationType = AnimationType.SRPING;
            bVar.timingFuncType = timingFuncType;
            bVar.duration = durationS;
            bVar.damping = damping;
            bVar.velocity = velocity;
            bVar.delay = delay;
            bVar.repeatForever = repeatForever;
            bVar.j(key);
            return bVar;
        }

        public final b e(float durationS, String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return b(this, AnimationType.PLAIN, TimingFuncType.EASEIN, durationS, 0.0f, false, key, 24, null);
        }

        public final b g(float durationS, String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return b(this, AnimationType.PLAIN, TimingFuncType.EASEINOUT, durationS, 0.0f, false, key, 24, null);
        }

        public final b i(float durationS, String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return b(this, AnimationType.PLAIN, TimingFuncType.EASEOUT, durationS, 0.0f, false, key, 24, null);
        }

        public final b k(float durationS, String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return b(this, AnimationType.PLAIN, TimingFuncType.LINEAR, durationS, 0.0f, false, key, 24, null);
        }

        public final b m(float durationS, float damping, float velocity, String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return d(this, TimingFuncType.EASEIN, durationS, damping, velocity, 0.0f, false, key, 48, null);
        }

        public final b o(float durationS, float damping, float velocity, String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return d(this, TimingFuncType.EASEINOUT, durationS, damping, velocity, 0.0f, false, key, 48, null);
        }

        public final b q(float durationS, float damping, float velocity, String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return d(this, TimingFuncType.EASEOUT, durationS, damping, velocity, 0.0f, false, key, 48, null);
        }

        public final b s(float durationS, float damping, float velocity, String key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return d(this, TimingFuncType.LINEAR, durationS, damping, velocity, 0.0f, false, key, 48, null);
        }

        Companion() {
        }

        public static /* synthetic */ b f(Companion companion, float f16, String str, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                str = "";
            }
            return companion.e(f16, str);
        }

        public static /* synthetic */ b h(Companion companion, float f16, String str, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                str = "";
            }
            return companion.g(f16, str);
        }

        public static /* synthetic */ b j(Companion companion, float f16, String str, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                str = "";
            }
            return companion.i(f16, str);
        }

        public static /* synthetic */ b l(Companion companion, float f16, String str, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                str = "";
            }
            return companion.k(f16, str);
        }

        public static /* synthetic */ b n(Companion companion, float f16, float f17, float f18, String str, int i3, Object obj) {
            if ((i3 & 8) != 0) {
                str = "";
            }
            return companion.m(f16, f17, f18, str);
        }

        public static /* synthetic */ b p(Companion companion, float f16, float f17, float f18, String str, int i3, Object obj) {
            if ((i3 & 8) != 0) {
                str = "";
            }
            return companion.o(f16, f17, f18, str);
        }

        public static /* synthetic */ b r(Companion companion, float f16, float f17, float f18, String str, int i3, Object obj) {
            if ((i3 & 8) != 0) {
                str = "";
            }
            return companion.q(f16, f17, f18, str);
        }

        public static /* synthetic */ b t(Companion companion, float f16, float f17, float f18, String str, int i3, Object obj) {
            if ((i3 & 8) != 0) {
                str = "";
            }
            return companion.s(f16, f17, f18, str);
        }

        public static /* synthetic */ b b(Companion companion, AnimationType animationType, TimingFuncType timingFuncType, float f16, float f17, boolean z16, String str, int i3, Object obj) {
            if ((i3 & 8) != 0) {
                f17 = 0.0f;
            }
            float f18 = f17;
            if ((i3 & 16) != 0) {
                z16 = false;
            }
            boolean z17 = z16;
            if ((i3 & 32) != 0) {
                str = "";
            }
            return companion.a(animationType, timingFuncType, f16, f18, z17, str);
        }

        public static /* synthetic */ b d(Companion companion, TimingFuncType timingFuncType, float f16, float f17, float f18, float f19, boolean z16, String str, int i3, Object obj) {
            return companion.c(timingFuncType, f16, f17, f18, (i3 & 16) != 0 ? 0.0f : f19, (i3 & 32) != 0 ? false : z16, (i3 & 64) != 0 ? "" : str);
        }
    }

    public final b h(float time) {
        this.delay = time;
        return this;
    }

    public final b i(boolean forever) {
        this.repeatForever = forever;
        return this;
    }

    public final void j(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.key = str;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.animationType.ordinal());
        sb5.append(TokenParser.SP);
        TimingFuncType timingFuncType = this.timingFuncType;
        if (timingFuncType == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timingFuncType");
            timingFuncType = null;
        }
        sb5.append(timingFuncType.ordinal());
        sb5.append(TokenParser.SP);
        sb5.append(this.duration);
        sb5.append(TokenParser.SP);
        sb5.append(this.damping);
        sb5.append(TokenParser.SP);
        sb5.append(this.velocity);
        sb5.append(TokenParser.SP);
        sb5.append(this.delay);
        sb5.append(TokenParser.SP);
        sb5.append(d.b(this.repeatForever));
        sb5.append(TokenParser.SP);
        sb5.append(this.key);
        return sb5.toString();
    }
}
