package com.tencent.qqnt.shortvideo.api;

import androidx.annotation.MainThread;
import com.tencent.hippy.qq.adapter.image.CustomImageProps;
import com.tencent.luggage.wxa.p004if.u;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cy3.a;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\bg\u0018\u0000 \u00112\u00020\u0001:\u0002\u0012\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H'J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH'J2\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\bH&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/shortvideo/api/IVideoCompress;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "", "findCompressTask", "", "removeCompressTask", "Lcom/tencent/qqnt/shortvideo/api/IVideoCompress$b;", "listener", "setCompressListener", "", "inVideoPath", CustomImageProps.QUALITY, "", "userData", u.NAME, "Companion", "a", "b", "shortvideo_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IVideoCompress extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f362204a;
    public static final int RESULT_CANCELED = 3;
    public static final int RESULT_FAILURE = 2;
    public static final int RESULT_SUCCESS = 1;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/shortvideo/api/IVideoCompress$a;", "", "<init>", "()V", "shortvideo_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.shortvideo.api.IVideoCompress$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f362204a = new Companion();

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0003H&J\u001a\u0010\t\u001a\u00020\u00052\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\b\u001a\u00020\u0007H&J\u001c\u0010\f\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&J$\u0010\u000f\u001a\u00020\u00052\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH'\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/shortvideo/api/IVideoCompress$b;", "", "userData", "", "isNeedCompress", "", "c", "", "percent", "d", "Lcy3/a;", QCircleScheme.AttrDetail.VIDEO_INFO, "a", "", "finishCode", "b", "shortvideo_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public interface b {
        boolean a(@Nullable Object userData, @Nullable a videoInfo);

        @MainThread
        void b(@Nullable Object userData, int finishCode, @Nullable a videoInfo);

        void c(@Nullable Object userData, boolean isNeedCompress);

        void d(@Nullable Object userData, float percent);
    }

    void compressVideo(long taskId, @NotNull String inVideoPath, boolean quality, @Nullable Object userData, @NotNull b listener);

    @MainThread
    boolean findCompressTask(long taskId);

    @MainThread
    void removeCompressTask(long taskId);

    @MainThread
    void setCompressListener(long taskId, @NotNull b listener);
}
