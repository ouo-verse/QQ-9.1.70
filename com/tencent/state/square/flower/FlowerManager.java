package com.tencent.state.square.flower;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.state.square.DefaultDownloadListener;
import com.tencent.state.square.IHttpDownloader;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.flower.data.MedalData;
import com.tencent.state.square.flower.service.VasFlowerService;
import com.tencent.zplan.common.utils.d;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\u0006\u0010\u0012\u001a\u00020\bJ\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J\u000e\u0010\u0015\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/state/square/flower/FlowerManager;", "", "()V", "FLOWER_BACKGROUND_IMAGE_URL", "", "TAG", "backgroundImageFileName", "addFlower", "", "uin", "reason", "Lcom/tencent/state/square/flower/AddFlowerReason;", "count", "", "getBackgroundImageFile", "Ljava/io/File;", "getResFile", "name", "preload", "file", "url", "syncFlowerInfo", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class FlowerManager {
    private static final String TAG = "FlowerManager";
    public static final FlowerManager INSTANCE = new FlowerManager();
    public static final String FLOWER_BACKGROUND_IMAGE_URL = "https://cdn.meta.qq.com/flower/background.webp";
    private static final String backgroundImageFileName = d.c(FLOWER_BACKGROUND_IMAGE_URL) + ".png";

    FlowerManager() {
    }

    private final File getResFile(String name) {
        File parentFile;
        File file = new File(Square.INSTANCE.getConfig().getRootCacheDir(), "flower/" + name);
        File parentFile2 = file.getParentFile();
        if ((parentFile2 == null || !parentFile2.exists()) && (parentFile = file.getParentFile()) != null) {
            parentFile.mkdirs();
        }
        return file;
    }

    public final void addFlower(String uin, AddFlowerReason reason, int count) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(reason, "reason");
        SimpleEventBus.getInstance().dispatchEvent(new FlowerGotEvent(uin, count));
    }

    public final File getBackgroundImageFile() {
        return getResFile(backgroundImageFileName);
    }

    public final void preload() {
        SquareBaseKt.getSquareThread().postOnSubThread(new Function0<Unit>() { // from class: com.tencent.state.square.flower.FlowerManager$preload$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FlowerManager flowerManager = FlowerManager.INSTANCE;
                flowerManager.preload(flowerManager.getBackgroundImageFile(), FlowerManager.FLOWER_BACKGROUND_IMAGE_URL);
            }
        });
    }

    public final void syncFlowerInfo(final String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        VasFlowerService.INSTANCE.getFlowerToday(uin, new Function2<Integer, MedalData, Unit>() { // from class: com.tencent.state.square.flower.FlowerManager$syncFlowerInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, MedalData medalData) {
                invoke(num.intValue(), medalData);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, MedalData medalData) {
                SimpleEventBus.getInstance().dispatchEvent(new FlowerSyncEvent(uin, i3, medalData));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void preload(File file, final String url) {
        if (file.exists()) {
            return;
        }
        SquareBaseKt.getSquareLog().i(TAG, "preload url: " + url + ", path=" + file.getAbsolutePath());
        IHttpDownloader downloader = Square.INSTANCE.getConfig().getDownloader();
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
        downloader.download(new IHttpDownloader.Task(url, absolutePath), new DefaultDownloadListener() { // from class: com.tencent.state.square.flower.FlowerManager$preload$2
            @Override // com.tencent.state.square.DefaultDownloadListener, com.tencent.state.square.IDownloadListener
            public void onTaskFailed(int errorCode, String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                SquareBaseKt.getSquareLog().i("FlowerManager", "preload failed: error=" + errorCode + ", message=" + errorMessage + ", url=" + url);
            }

            @Override // com.tencent.state.square.DefaultDownloadListener, com.tencent.state.square.IDownloadListener
            public void onTaskSuccess(File resultFile) {
                Intrinsics.checkNotNullParameter(resultFile, "resultFile");
                SquareBaseKt.getSquareLog().i("FlowerManager", "preload success: url=" + url);
            }
        });
    }

    public static /* synthetic */ void addFlower$default(FlowerManager flowerManager, String str, AddFlowerReason addFlowerReason, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 1;
        }
        flowerManager.addFlower(str, addFlowerReason, i3);
    }
}
