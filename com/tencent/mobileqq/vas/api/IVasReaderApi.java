package com.tencent.mobileqq.vas.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.xweb.xwalk.plugin.XWalkReaderBasePlugin;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001:\u0001#J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H&J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H&J8\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0003H&J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0015\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0016\u001a\u00020\bH&JA\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\t\u001a\u0004\u0018\u00010\n2%\b\u0002\u0010\u001b\u001a\u001f\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001cH&J \u0010 \u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u0005H&\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVasReaderApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "deleteFile", "", "absolutePath", "", "getAvailableSpace", "getDeviceBrightness", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "getFileList", "getFileSize", "measureText", "textSize", "fontFamily", "textContent", NodeProps.MAX_WIDTH, "textSpacing", "fontWeight", XWalkReaderBasePlugin.READ_METHOD_NAME, "setDeviceBrightness", "brightness", "setVolumeKeyListener", "", "isOn", "", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "key", "writeFile", "isAppend", "data", "VolumeKey", "vas-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasReaderApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/vas/api/IVasReaderApi$VolumeKey;", "", "(Ljava/lang/String;I)V", "VOLUME_UP", "VOLUME_DOWN", "vas-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public enum VolumeKey {
        VOLUME_UP,
        VOLUME_DOWN
    }

    int deleteFile(@NotNull String absolutePath);

    @NotNull
    String getAvailableSpace();

    float getDeviceBrightness(@Nullable Activity activity);

    @NotNull
    String getFileList(@NotNull String absolutePath);

    @NotNull
    String getFileSize(@NotNull String absolutePath);

    @NotNull
    String measureText(float textSize, @NotNull String fontFamily, @NotNull String textContent, int maxWidth, float textSpacing, int fontWeight);

    @NotNull
    String readFile(@NotNull String absolutePath);

    int setDeviceBrightness(@Nullable Activity activity, float brightness);

    void setVolumeKeyListener(boolean isOn, @Nullable Activity activity, @Nullable Function1<? super Integer, Unit> callback);

    int writeFile(@NotNull String absolutePath, boolean isAppend, @NotNull String data);
}
