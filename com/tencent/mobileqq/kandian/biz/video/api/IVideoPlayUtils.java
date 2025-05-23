package com.tencent.mobileqq.kandian.biz.video.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.net.URL;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&J \u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H&J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoPlayUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "model", "what", "", "makeErrorText", "timeSec", "duration", "fileSize", "", "calculateVideoPartSize", "thumbPath", "Ljava/net/URL;", "getThumbUrl", "Companion", "a", "kandian-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IVideoPlayUtils extends QRouteApi {
    public static final int AIO_PREVIEW_TIME_SECS = 8;
    public static final int AUTO_SCROLL_OFFSET_DP = 175;
    public static final long BUSI_LOADING_DELAY = 5000;

    @NotNull
    public static final String BUSI_TYPE_KANDIAN_PLATFORM = "bus_type_kandian_feeds";

    @NotNull
    public static final String BUS_TYPE_FULL_SCREEN = "bus_type_full_screen";

    @NotNull
    public static final String BUS_TYPE_KANDIAN_FEEDS = "bus_type_kandian_feeds";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f239555a;

    @NotNull
    public static final String KEY_BUS_TYPE = "shouq_bus_type";

    @NotNull
    public static final String SERVER_TYPE_AIO_SHORT_VIDEO = "20160518";

    @NotNull
    public static final String SERVER_TYPE_KANDIAN_VIDEO = "20160519";
    public static final int SERVER_TYPE_KANDIAN_VIDEO_INT = 20160519;
    public static final long UI_LOADING_DELAY = 1200;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoPlayUtils$a;", "", "<init>", "()V", "kandian-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.kandian.biz.video.api.IVideoPlayUtils$a, reason: from kotlin metadata */
    /* loaded from: classes15.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f239555a = new Companion();

        Companion() {
        }
    }

    long calculateVideoPartSize(int timeSec, int duration, int fileSize);

    @Nullable
    URL getThumbUrl(@Nullable String thumbPath);

    @Nullable
    String makeErrorText(int model, int what);
}
