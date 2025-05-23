package in1;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.guild.data.o;
import com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.j;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\u000b\u001a\u00020\n2\u0010\b\u0002\u0010\t\u001a\n\u0018\u00010\u0007j\u0004\u0018\u0001`\bH&J\u001a\u0010\u0010\u001a\u00020\n2\u0010\u0010\u000f\u001a\f\u0012\b\u0012\u00060\rj\u0002`\u000e0\fH&J,\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u001a\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0011\u0012\b\u0012\u00060\u0014j\u0002`\u00150\u0013j\u0002`\u0016H&J\u001c\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u00112\n\u0010\u001a\u001a\u00060\u0014j\u0002`\u0015H&J#\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\b\u0012\u00060\u001cj\u0002`\u001d0\u0013H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\"\u001a\u00020\n2\u0006\u0010!\u001a\u00020 H&J\b\u0010#\u001a\u00020\nH&R\u001c\u0010(\u001a\u00020\u00028&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010)\u001a\u00020\u00028&@&X\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R\u0014\u0010,\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b+\u0010%R$\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\b\u0012\u00060\u001cj\u0002`\u001d0\u00138&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b-\u0010.\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00060"}, d2 = {"Lin1/c;", "", "", "retryIfFailNow", "Lcom/tencent/mobileqq/guild/feed/publish/publishV2/taskx/h;", "k", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/util/concurrent/CancellationException;", "Lkotlin/coroutines/cancellation/CancellationException;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE, "", "cancel", "", "Lcom/tencent/mobileqq/guild/feed/publish/publishV2/taskx/j;", "Lcom/tencent/mobileqq/guild/feed/publish/api/MediumUploadRestoreInfo;", "restoreInfoList", "e", "", "source", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lcom/tencent/mobileqq/guild/feed/publish/api/QQAlbumMediumModel;", "Lcom/tencent/mobileqq/guild/feed/publish/api/MediaSelected;", "mediaSelected", h.F, "fileId", "medium", "f", "Lcom/tencent/mobileqq/guild/data/o;", "Lcom/tencent/mobileqq/guild/feed/publish/api/MediumUploadTaskInfo;", "d", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/guild/feed/api/h;", "listener", "b", "release", "i", "()Z", "g", "(Z)V", "isEnablePreUpload", "isPreUploadGuardByNetworkCondition", "a", "j", "isAwaiting", "c", "()Ljava/util/Map;", "taskInfoMap", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface c {
    void a(boolean z16);

    void b(@NotNull com.tencent.mobileqq.guild.feed.api.h listener);

    @NotNull
    Map<String, o> c();

    void cancel(@Nullable CancellationException cause);

    @Nullable
    Object d(@NotNull Continuation<? super Map<String, ? extends o>> continuation);

    void e(@NotNull List<j> restoreInfoList);

    void f(@NotNull String fileId, @NotNull LocalMediaInfo medium);

    void g(boolean z16);

    void h(@NotNull String source, @NotNull Map<String, ? extends LocalMediaInfo> mediaSelected);

    boolean i();

    boolean j();

    @Nullable
    Object k(boolean z16, @NotNull Continuation<? super com.tencent.mobileqq.guild.feed.publish.publishV2.taskx.h> continuation);

    void release();
}
