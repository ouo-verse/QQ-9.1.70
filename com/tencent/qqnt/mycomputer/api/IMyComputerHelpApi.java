package com.tencent.qqnt.mycomputer.api;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.aio.bottombar.sectionbar.adapter.b;
import com.tencent.qqnt.aio.bottombar.sectionbar.processor.BottomSectionBarBaseProcessor;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u001e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000eH\u0016J-\u0010\u0017\u001a\u00020\u0016\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J-\u0010\u0019\u001a\u00020\u0016\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0019\u0010\u0018J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000eH&J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000eH&\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/qqnt/mycomputer/api/IMyComputerHelpApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/aio/api/runtime/a;", "context", "", "devicePeerUid", "deviceNick", "", "myComputerOpenCamera", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "myComputerOpenFileSelector", "filePath", "myComputerSendFileFromPhoto", "", "filePathList", "myComputerSendMultiFileFromPhoto", "T", "target", "Landroid/os/Bundle;", "bundle", "callback", "", "singleForwardToMyComputer", "(Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/Object;)I", "multipleForwardToMyComputer", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/adapter/b;", "getExtSectionBarAdapters", "Lcom/tencent/qqnt/aio/bottombar/sectionbar/processor/BottomSectionBarBaseProcessor;", "getExtSectionBarProcessors", "aio_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface IMyComputerHelpApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public static final class a {
        public static <T> int a(@NotNull IMyComputerHelpApi iMyComputerHelpApi, @NotNull String target, @NotNull Bundle bundle, T t16) {
            Intrinsics.checkNotNullParameter(target, "target");
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            return 0;
        }

        public static void b(@NotNull IMyComputerHelpApi iMyComputerHelpApi, @NotNull String devicePeerUid, @NotNull String filePath) {
            Intrinsics.checkNotNullParameter(devicePeerUid, "devicePeerUid");
            Intrinsics.checkNotNullParameter(filePath, "filePath");
        }

        public static void c(@NotNull IMyComputerHelpApi iMyComputerHelpApi, @NotNull String devicePeerUid, @NotNull List<String> filePathList) {
            Intrinsics.checkNotNullParameter(devicePeerUid, "devicePeerUid");
            Intrinsics.checkNotNullParameter(filePathList, "filePathList");
        }

        public static <T> int d(@NotNull IMyComputerHelpApi iMyComputerHelpApi, @NotNull String target, @NotNull Bundle bundle, T t16) {
            Intrinsics.checkNotNullParameter(target, "target");
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            return 0;
        }
    }

    @NotNull
    List<b> getExtSectionBarAdapters();

    @NotNull
    List<BottomSectionBarBaseProcessor> getExtSectionBarProcessors();

    <T> int multipleForwardToMyComputer(@NotNull String target, @NotNull Bundle bundle, T callback);

    void myComputerOpenCamera(@NotNull com.tencent.aio.api.runtime.a context, @NotNull String devicePeerUid, @NotNull String deviceNick);

    void myComputerOpenFileSelector(@NotNull Activity activity, @NotNull String devicePeerUid);

    void myComputerSendFileFromPhoto(@NotNull String devicePeerUid, @NotNull String filePath);

    void myComputerSendMultiFileFromPhoto(@NotNull String devicePeerUid, @NotNull List<String> filePathList);

    <T> int singleForwardToMyComputer(@NotNull String target, @NotNull Bundle bundle, T callback);
}
