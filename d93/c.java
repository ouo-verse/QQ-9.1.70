package d93;

import android.content.Context;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import common.config.service.QzoneConfig;
import e93.i;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u0000 \u00062\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000b\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\t\u00a8\u0006\u000e"}, d2 = {"Ld93/c;", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "info", "", "b", "c", "", "a", UserInfo.SEX_FEMALE, "minRatio", "maxRatio", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    private static final boolean f393237d = QzoneConfig.isWinkPublishLimitVideoResolution();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private float minRatio;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private float maxRatio;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J$\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\bJ*\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\bJ\u0010\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\fR\u0014\u0010\u0013\u001a\u00020\u00128\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00188\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006\u001f"}, d2 = {"Ld93/c$a;", "", "Landroid/content/Context;", "context", "", "infoValidStatus", "", "a", "Lkotlin/Function0;", "applyWhenStatusValidated", "b", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "localMediaInfoList", "c", "info", "", "d", "", "KEY_SHOW_TOAST_INTERVAL", "Ljava/lang/String;", "MAX_VIDEO_RESOLUTION", "I", "MINIMUM_VIDEO_DURATION", "", "SHOW_TOAST_INTERVAL", "J", "isLimitResolution", "Z", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: d93.c$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, int infoValidStatus) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (FastClickUtils.isFastDoubleClick("key_show_toast_interval", 2000L)) {
                return;
            }
            if (infoValidStatus != -7) {
                if (infoValidStatus != -6) {
                    if (infoValidStatus != -5) {
                        if (infoValidStatus != -4) {
                            if (infoValidStatus != -3) {
                                if (infoValidStatus == -1) {
                                    QQToast.makeText(context, HardCodeUtil.qqStr(R.string.f216045x9), 0).show();
                                    return;
                                }
                                return;
                            }
                            long videoMinDurationMs = com.tencent.mobileqq.wink.picker.core.c.f324480a.b().getSelectMediaFilter().getVideoMinDurationMs() / 1000;
                            QQToast.makeText(context, HardCodeUtil.qqStr(R.string.f216035x8) + videoMinDurationMs + " \u79d2", 0).show();
                            return;
                        }
                        long videoMaxDurationMs = com.tencent.mobileqq.wink.picker.core.c.f324480a.b().getSelectMediaFilter().getVideoMaxDurationMs() / 1000;
                        QQToast.makeText(context, HardCodeUtil.qqStr(R.string.f216025x7) + videoMaxDurationMs + " \u79d2", 0).show();
                        return;
                    }
                    QQToast.makeText(context, HardCodeUtil.qqStr(R.string.f216075xb), 0).show();
                    return;
                }
                QQToast.makeText(context, HardCodeUtil.qqStr(R.string.f240327ov), 0).show();
                return;
            }
            QQToast.makeText(context, HardCodeUtil.qqStr(R.string.f216065xa), 0).show();
        }

        public final void b(@NotNull Context context, int infoValidStatus, @NotNull Function0<Unit> applyWhenStatusValidated) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(applyWhenStatusValidated, "applyWhenStatusValidated");
            if (infoValidStatus == 0) {
                applyWhenStatusValidated.invoke();
            } else {
                a(context, infoValidStatus);
            }
        }

        public final void c(@NotNull Context context, @NotNull List<? extends LocalMediaInfo> localMediaInfoList, @NotNull Function0<Unit> applyWhenStatusValidated) {
            boolean z16;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(localMediaInfoList, "localMediaInfoList");
            Intrinsics.checkNotNullParameter(applyWhenStatusValidated, "applyWhenStatusValidated");
            Iterator<? extends LocalMediaInfo> it = localMediaInfoList.iterator();
            while (true) {
                if (it.hasNext()) {
                    LocalMediaInfo next = it.next();
                    if (i.x(next) != 0) {
                        a(context, i.x(next));
                        z16 = false;
                        break;
                    }
                } else {
                    z16 = true;
                    break;
                }
            }
            if (z16) {
                applyWhenStatusValidated.invoke();
            }
        }

        public final boolean d(@Nullable LocalMediaInfo info) {
            boolean z16;
            if (!c.f393237d) {
                return true;
            }
            if (info != null && i.I(info)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return true;
            }
            if (info.mediaWidth < 3000 && info.mediaHeight < 3000) {
                return true;
            }
            return false;
        }

        Companion() {
        }
    }

    public c() {
        this.minRatio = 0.375f;
        this.maxRatio = 2.5f;
        this.minRatio = QzoneConfig.getWinkPickSelectMinRatio();
        this.maxRatio = QzoneConfig.getWinkPickSelectMaxRatio();
    }

    public final boolean b(@Nullable LocalMediaInfo info) {
        if (info == null) {
            return false;
        }
        if (i.I(info)) {
            return true;
        }
        int i3 = info.mediaHeight;
        if (i3 == 0) {
            return false;
        }
        float f16 = info.mediaWidth / i3;
        float f17 = this.minRatio;
        if (f16 > this.maxRatio || f17 > f16) {
            return false;
        }
        return true;
    }

    public final boolean c(@Nullable LocalMediaInfo info) {
        boolean z16;
        if (info != null && i.I(info)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && info.mDuration <= 1000) {
            return false;
        }
        return true;
    }
}
