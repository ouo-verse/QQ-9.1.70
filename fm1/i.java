package fm1;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0004H&J\b\u0010\t\u001a\u00020\u0004H&J\b\u0010\u000b\u001a\u00020\nH&J\b\u0010\f\u001a\u00020\nH&J\b\u0010\r\u001a\u00020\nH&J\b\u0010\u000e\u001a\u00020\u0002H&J\b\u0010\u000f\u001a\u00020\nH'J\b\u0010\u0010\u001a\u00020\nH&J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\nH\u0016J\b\u0010\u0015\u001a\u00020\u0014H&R\u0014\u0010\u0018\u001a\u00020\u00048&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00048&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u001b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010!\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 \u00a8\u0006\""}, d2 = {"Lfm1/i;", "", "", "f", "", "getType", "", "getVideoDuration", "getWidth", "getHeight", "", "getTaskId", "getPath", "a", "b", "c", "getExtra", "extra", "", tl.h.F, "Lorg/json/JSONObject;", "g", "i", "()I", QCircleLpReportDc010001.KEY_MAINTYPE, "getSubType", QCircleLpReportDc010001.KEY_SUBTYPE, "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "e", "()Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "rawLocalMedia", "getThumbUrl", "()Ljava/lang/String;", "thumbUrl", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface i {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a {
        @Nullable
        public static LocalMediaInfo a(@NotNull i iVar) {
            return null;
        }

        public static void b(@NotNull i iVar, @NotNull String extra) {
            Intrinsics.checkNotNullParameter(extra, "extra");
        }
    }

    @NotNull
    String a();

    boolean b();

    @Deprecated(message = "\u542b\u4e49\u4e0d\u660e\u786e\uff0c\u6709\u7684\u6709\u6b64\u5b57\u6bb5\uff0c\u6709\u7684\u6ca1\u6709")
    @NotNull
    String c();

    @Nullable
    LocalMediaInfo e();

    boolean f();

    @NotNull
    JSONObject g();

    @NotNull
    String getExtra();

    int getHeight();

    @NotNull
    String getPath();

    int getSubType();

    @NotNull
    String getTaskId();

    @NotNull
    String getThumbUrl();

    int getType();

    long getVideoDuration();

    int getWidth();

    void h(@NotNull String extra);

    int i();
}
