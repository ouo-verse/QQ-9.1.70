package b12;

import android.view.View;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \t2\u00020\u0001:\u0002\f\tB\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J/\u0010\t\u001a\u00060\u0005R\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u001b\u0010\b\u001a\u0017\u0012\b\u0012\u00060\u0005R\u00020\u0000\u0012\u0004\u0012\u00020\u00060\u0004\u00a2\u0006\u0002\b\u0007J\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0000\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\u0014\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lb12/a;", "", "Landroid/view/View;", "view", "Lkotlin/Function1;", "Lb12/a$b;", "", "Lkotlin/ExtensionFunctionType;", "block", "b", "", "msg", "a", "(Ljava/lang/String;)V", "", "Z", "getDebug", "()Z", "setDebug", "(Z)V", "debug", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean debug;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0015\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bE\u0010FJ\"\u0010\b\u001a\u00020\u0007*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0012\u0010\r\u001a\u00060\u0000R\u00020\f2\u0006\u0010\u000b\u001a\u00020\nJ\b\u0010\u000e\u001a\u00020\u0004H\u0016R$\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u001b\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010#\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010*\u001a\u00020$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u00101\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u00103R$\u00108\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u0010\u000f\u001a\u0004\b6\u0010\u0011\"\u0004\b7\u0010\u0013R$\u0010<\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010\u001e\u001a\u0004\b:\u0010 \"\u0004\b;\u0010\"R$\u0010@\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010%\u001a\u0004\b>\u0010'\"\u0004\b?\u0010)R<\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001028F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001d\u0010A\"\u0004\bB\u0010C\u00a8\u0006G"}, d2 = {"Lb12/a$b;", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "", "name", "value", "", "a", "b", "Landroid/view/View;", "view", "Lb12/a;", "f", "toString", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "e", "(Ljava/lang/String;)V", "id", "Lcom/tencent/qqlive/module/videoreport/constants/ClickPolicy;", "Lcom/tencent/qqlive/module/videoreport/constants/ClickPolicy;", "getClick", "()Lcom/tencent/qqlive/module/videoreport/constants/ClickPolicy;", "setClick", "(Lcom/tencent/qqlive/module/videoreport/constants/ClickPolicy;)V", "click", "Lcom/tencent/qqlive/module/videoreport/constants/ExposurePolicy;", "c", "Lcom/tencent/qqlive/module/videoreport/constants/ExposurePolicy;", "getExpose", "()Lcom/tencent/qqlive/module/videoreport/constants/ExposurePolicy;", "d", "(Lcom/tencent/qqlive/module/videoreport/constants/ExposurePolicy;)V", "expose", "Lcom/tencent/qqlive/module/videoreport/constants/EndExposurePolicy;", "Lcom/tencent/qqlive/module/videoreport/constants/EndExposurePolicy;", "getEndExpose", "()Lcom/tencent/qqlive/module/videoreport/constants/EndExposurePolicy;", "setEndExpose", "(Lcom/tencent/qqlive/module/videoreport/constants/EndExposurePolicy;)V", "endExpose", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "getDynamicParams", "()Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "setDynamicParams", "(Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;)V", "dynamicParams", "", "Ljava/util/Map;", "_params", "g", "getReuseId", "setReuseId", "reuseId", h.F, "getScrollExposePolicy", "setScrollExposePolicy", "scrollExposePolicy", "i", "getScrollEndExposePolicy", "setScrollEndExposePolicy", "scrollEndExposePolicy", "()Ljava/util/Map;", "setParams", "(Ljava/util/Map;)V", "params", "<init>", "(Lb12/a;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: b12.a$b, reason: from toString */
    /* loaded from: classes14.dex */
    public final class SetupBuilder {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String id;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private ClickPolicy click = ClickPolicy.REPORT_NONE;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private ExposurePolicy expose = ExposurePolicy.REPORT_NONE;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private EndExposurePolicy endExpose = EndExposurePolicy.REPORT_NONE;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private IDynamicParams dynamicParams;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private Map<String, Object> _params;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private String reuseId;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private ExposurePolicy scrollExposePolicy;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private EndExposurePolicy scrollEndExposePolicy;

        public SetupBuilder() {
        }

        private final void a(StringBuilder sb5, String str, Object obj) {
            if (obj != null) {
                sb5.append(", ");
                sb5.append(str);
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(obj);
            }
        }

        private final String b() {
            StringBuilder sb5 = new StringBuilder("elemId=" + this.id + ", click=" + this.click + ", expose=" + this.expose + ", endExpose=" + this.endExpose + ", params=" + c() + ", dynamicParams=" + this.dynamicParams);
            a(sb5, "reuseId", this.reuseId);
            a(sb5, "scrollExposePolicy", this.scrollExposePolicy);
            a(sb5, "scrollEndExposePolicy", this.scrollEndExposePolicy);
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
            return sb6;
        }

        @NotNull
        public final Map<String, Object> c() {
            if (this._params == null) {
                synchronized (this) {
                    if (this._params == null) {
                        this._params = new LinkedHashMap();
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
            Map<String, Object> map = this._params;
            Intrinsics.checkNotNull(map);
            return map;
        }

        public final void d(@NotNull ExposurePolicy exposurePolicy) {
            Intrinsics.checkNotNullParameter(exposurePolicy, "<set-?>");
            this.expose = exposurePolicy;
        }

        public final void e(@Nullable String str) {
            this.id = str;
        }

        @NotNull
        public final SetupBuilder f(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            String str = this.id;
            if (str != null) {
                VideoReport.setElementId(view, str);
            } else {
                Logger.f235387a.d().w("DTReportBuilder", 1, b.b(view) + " \u5728\u6b64setup\u5757\u4e2d\u672a\u8bbe\u7f6eid\uff0c\u8bf7\u68c0\u67e5\u662f\u5426\u9057\u5fd8\u4e86\uff01");
            }
            VideoReport.setElementClickPolicy(view, this.click);
            VideoReport.setElementExposePolicy(view, this.expose);
            VideoReport.setElementEndExposePolicy(view, this.endExpose);
            VideoReport.setElementParams(view, c());
            VideoReport.setEventDynamicParams(view, this.dynamicParams);
            String str2 = this.reuseId;
            if (str2 != null) {
                VideoReport.setElementReuseIdentifier(view, str2);
            }
            ExposurePolicy exposurePolicy = this.scrollExposePolicy;
            if (exposurePolicy != null) {
                VideoReport.setElementScrollExposePolicy(view, exposurePolicy);
            }
            EndExposurePolicy endExposurePolicy = this.scrollEndExposePolicy;
            if (endExposurePolicy != null) {
                VideoReport.setElementScrollEndExposePolicy(view, endExposurePolicy);
            }
            a.this.a("setup " + b.b(view) + ", " + b());
            return this;
        }

        @NotNull
        public String toString() {
            return "SetupBuilder(" + b() + ")";
        }
    }

    public final void a(@NotNull String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (this.debug) {
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("DTReportBuilder", 1, msg2);
            }
        }
    }

    @NotNull
    public final SetupBuilder b(@NotNull View view, @NotNull Function1<? super SetupBuilder, Unit> block) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(block, "block");
        SetupBuilder setupBuilder = new SetupBuilder();
        block.invoke(setupBuilder);
        return setupBuilder.f(view);
    }
}
