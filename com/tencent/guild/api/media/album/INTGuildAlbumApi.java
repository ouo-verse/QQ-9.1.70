package com.tencent.guild.api.media.album;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u0004H&J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0006H&J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH&J9\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022'\u0010\u0015\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u00070\u0004H&J2\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001d\u001a\u00020\u0002H&J\b\u0010\u001f\u001a\u00020\u0007H&J\u00a7\u0001\u0010*\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010!\u001a\u00020 2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u001b2&\u0010%\u001a\"\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010#j\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u0001`$2\b\b\u0002\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010&\u001a\u00020\u00022%\u0010\b\u001a!\u0012\u0013\u0012\u00110'\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00070\u0004j\u0002`)H&J\u009b\u0001\u0010.\u001a\u00020\u00072\u0006\u0010!\u001a\u00020 2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00100\u00052\b\u0010-\u001a\u0004\u0018\u00010\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u001b2\u001e\u0010%\u001a\u001a\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010#j\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u0001`$2%\u0010\b\u001a!\u0012\u0013\u0012\u00110'\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00070\u0004j\u0002`)H&J[\u00103\u001a\u00020\u00072\u0006\u0010!\u001a\u00020 2\u0006\u00100\u001a\u00020/2\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u0002012\n\u00102\u001a\u0006\u0012\u0002\b\u00030\u00052%\u0010\b\u001a!\u0012\u0013\u0012\u00110'\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b((\u0012\u0004\u0012\u00020\u00070\u0004j\u0002`)H&J\u001c\u00106\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u00105\u001a\b\u0012\u0004\u0012\u0002040\u0005H&J\u001c\u00109\u001a\b\u0012\u0004\u0012\u0002040\u00052\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u000607H&J\u001e\u0010<\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00192\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00070:H&\u00a8\u0006="}, d2 = {"Lcom/tencent/guild/api/media/album/INTGuildAlbumApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "showVideo", "Lkotlin/Function1;", "", "Lcom/tencent/guild/api/media/album/e;", "", "cb", "Ljava/lang/Runnable;", "queryMediaTask", "info", "Ljava/net/URL;", "generateAlbumThumbURL", "", "time", "", "formatTimeToString", "Lkotlin/ParameterName;", "name", "data", "callback", "queryMediaTaskNew", "channelId", "guildId", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/content/Intent;", "openAioIntent", "directMessage", "openCameraSendMsg", "peakPreload", "Lts/a;", "launch", "selectedList", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "replaceMediaInfo", "showFinishBtn", "Lcom/tencent/guild/api/media/album/a;", "albumResult", "Lcom/tencent/guild/api/media/album/StartAlbumCB;", "openNewAlbumFromPhotoPanel", "paths", "selectPaths", "currentPath", "photoPanelItemClick", "Landroid/content/Context;", "context", "", "mDatas", "postMediaItemClick", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgs", "msgElement2MediaInfo", "", "photos", "guildMediaInfo2MsgElement", "Lkotlin/Function0;", "allGranted", "checkAIOAlbumPermission", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface INTGuildAlbumApi extends QRouteApi {
    void checkAIOAlbumPermission(@NotNull Activity activity, @NotNull Function0<Unit> allGranted);

    @NotNull
    String formatTimeToString(long time);

    @NotNull
    URL generateAlbumThumbURL(@NotNull e info);

    @NotNull
    List<MsgElement> guildMediaInfo2MsgElement(@NotNull List<e> photos);

    @NotNull
    List<e> msgElement2MediaInfo(@NotNull List<MsgElement> msgs);

    void openCameraSendMsg(@NotNull String channelId, @NotNull String guildId, @NotNull Activity activity, @Nullable Intent openAioIntent, boolean directMessage);

    void openNewAlbumFromPhotoPanel(@NotNull Activity activity, @NotNull ts.a launch, @NotNull List<? extends e> selectedList, @Nullable String channelId, @Nullable String guildId, @Nullable Intent data, @Nullable HashMap<String, String> replaceMediaInfo, boolean directMessage, boolean showFinishBtn, @NotNull Function1<? super AlbumResult, Unit> cb5);

    void peakPreload();

    void photoPanelItemClick(@NotNull ts.a launch, @NotNull List<? extends e> paths, @NotNull List<String> selectPaths, @Nullable String currentPath, @Nullable String channelId, @Nullable String guildId, @Nullable Intent data, @Nullable HashMap<?, ?> replaceMediaInfo, @NotNull Function1<? super AlbumResult, Unit> cb5);

    void postMediaItemClick(@NotNull ts.a launch, @NotNull Context context, @NotNull String channelId, @NotNull Object data, @NotNull List<?> mDatas, @NotNull Function1<? super AlbumResult, Unit> cb5);

    @NotNull
    Runnable queryMediaTask(boolean showVideo, @NotNull Function1<? super List<? extends e>, Unit> cb5);

    void queryMediaTaskNew(boolean showVideo, @NotNull Function1<? super List<? extends e>, Unit> callback);
}
