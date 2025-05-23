package com.tencent.mobileqq.wink.api;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.wink.QQWinkConfig;
import com.tencent.mobileqq.wink.model.ModifyAvatarConfig;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H&J\b\u0010\t\u001a\u00020\nH&JE\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&\u00a2\u0006\u0002\u0010\u0013J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H&J \u0010\u0017\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u000eH&J\u0018\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0003H&J\"\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u000e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003H&JF\u0010\u001e\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\b2\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0 j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`!2\b\u0010\"\u001a\u0004\u0018\u00010\u0003H'J\u0018\u0010#\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0003H'J \u0010$\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001b\u001a\u00020\u0003H&J \u0010'\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)2\u0006\u0010\u0019\u001a\u00020\u000eH&J \u0010*\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)2\u0006\u0010\u0019\u001a\u00020\u000eH&J \u0010+\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)2\u0006\u0010\u0019\u001a\u00020\u000eH&J(\u0010,\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00032\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010.H&J\u0018\u00100\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0003H&J\u0018\u00101\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0003H&JT\u00102\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00103\u001a\u00020\b2\b\u00104\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u00105\u001a\u00020\b2\b\u00106\u001a\u0004\u0018\u00010\b2\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020:H&J\\\u00102\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00103\u001a\u00020\b2\b\u00104\u001a\u0004\u0018\u00010\b2\u001a\u0010;\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010<j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`=2\b\u0010>\u001a\u0004\u0018\u00010\b2\b\u0010?\u001a\u0004\u0018\u00010\u00032\b\u00106\u001a\u0004\u0018\u00010\bH&JD\u0010@\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00103\u001a\u00020\b2\b\u00104\u001a\u0004\u0018\u00010\b2\u0006\u0010A\u001a\u00020\b2\b\u00106\u001a\u0004\u0018\u00010\b2\u0006\u00107\u001a\u00020\b2\u0006\u00109\u001a\u00020:H&J(\u0010B\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00032\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010.H&J\u0018\u0010C\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)H&J\"\u0010D\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010(\u001a\u00020)2\b\u0010E\u001a\u0004\u0018\u00010\bH&J\u0010\u0010F\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010G\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H&J\"\u0010H\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010I\u001a\u00020J2\b\b\u0002\u0010\u0019\u001a\u00020\u000eH&J\u0010\u0010K\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010L\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u0003H&\u00a8\u0006M"}, d2 = {"Lcom/tencent/mobileqq/wink/api/IQQWinkLauncher;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "fillInnerJumpBundle", "Landroid/os/Bundle;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "", "", "initialize", "", "innerBizShareToQCircle", "mediaPath", "businessType", "", "businessTransId", "businessDisplayName", "msgSeq", "", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "jumpSingleMediaPicker", "hostFragment", "Landroidx/fragment/app/Fragment;", "jumpToAvatarPickerFragment", "oldPath", "requestCode", "jumpToAvatarShareWindow", "bundle", "jumpToMagicAvatarPickerFragment", "extra", "jumpToQQWinkBySchema", "action", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "extraBundle", "jumpToQQWinkHome", "jumpToQQWinkIndex", "winkConfig", "Lcom/tencent/mobileqq/wink/QQWinkConfig;", "jumpToQZonePickerFragment", "intent", "Landroid/content/Intent;", "jumpToQZonePickerFragmentBySchema", "jumpToQZoneTemplatePreviewFragment", "jumpToRecommendPreview", "mediaInfoList", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "jumpToSignShareWindow", "jumpToTemplateLibMainPage", "jumpToWinkEditorAfterProcessContent", "entryBusinessName", "missionId", "newPath", "traceId", MiniAppGetGameTaskTicketServlet.KEY_TASKID, IProfileCardConst.KEY_FROM_TYPE, "publish", "", "mediaPaths", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "textContent", "payload", "jumpToWinkEditorAfterProcessContentForQQSign", "description", "jumpToWinkNewAlbumPreview", "jumpToWinkPublishPage", "jumpToWinkTemplateIntermediate", QZoneDTLoginReporter.SCHEMA, "launchDebugNeonLightActivity", "launchWinkDebugNewAlbumActivity", "modifyMagicAvatar", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/wink/model/ModifyAvatarConfig;", "preloadQQWink", "shareToWink", "qq-wink-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IQQWinkLauncher extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Bundle fillInnerJumpBundle$default(IQQWinkLauncher iQQWinkLauncher, Context context, Map map, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    map = null;
                }
                return iQQWinkLauncher.fillInnerJumpBundle(context, map);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fillInnerJumpBundle");
        }

        public static /* synthetic */ void modifyMagicAvatar$default(IQQWinkLauncher iQQWinkLauncher, Context context, ModifyAvatarConfig modifyAvatarConfig, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 4) != 0) {
                    i3 = 0;
                }
                iQQWinkLauncher.modifyMagicAvatar(context, modifyAvatarConfig, i3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: modifyMagicAvatar");
        }
    }

    @NotNull
    Bundle fillInnerJumpBundle(@NotNull Context context, @Nullable Map<String, String> attrs);

    void initialize();

    void innerBizShareToQCircle(@NotNull Context context, @Nullable String mediaPath, int businessType, @Nullable String businessTransId, @Nullable String businessDisplayName, @Nullable Long msgSeq);

    void jumpSingleMediaPicker(@NotNull Context context, @NotNull Fragment hostFragment);

    void jumpToAvatarPickerFragment(@NotNull Context context, @NotNull String oldPath, int requestCode);

    void jumpToAvatarShareWindow(@NotNull Context context, @NotNull Bundle bundle);

    void jumpToMagicAvatarPickerFragment(@NotNull Context context, int requestCode, @Nullable Bundle extra);

    @Deprecated(message = "\u7edf\u4e00\u4f7f\u7528\u624bQ\u7684schema\u65b9\u6cd5\u8df3\u8f6c")
    void jumpToQQWinkBySchema(@NotNull Context context, @NotNull String action, @NotNull HashMap<String, String> attrs, @Nullable Bundle extraBundle);

    @Deprecated(message = "\u4e0d\u518d\u4f7f\u7528\u53d1\u5e03\u5668\u65e7\u9996\u9875", replaceWith = @ReplaceWith(expression = "jumpToQQWinkIndex", imports = {}))
    void jumpToQQWinkHome(@NotNull Context context, @NotNull Bundle bundle);

    void jumpToQQWinkIndex(@NotNull Context context, @NotNull QQWinkConfig winkConfig, @NotNull Bundle bundle);

    void jumpToQZonePickerFragment(@NotNull Context context, @NotNull Intent intent, int requestCode);

    void jumpToQZonePickerFragmentBySchema(@NotNull Context context, @NotNull Intent intent, int requestCode);

    void jumpToQZoneTemplatePreviewFragment(@NotNull Context context, @NotNull Intent intent, int requestCode);

    void jumpToRecommendPreview(@NotNull Context context, @NotNull Bundle bundle, @Nullable List<? extends LocalMediaInfo> mediaInfoList);

    void jumpToSignShareWindow(@NotNull Context context, @NotNull Bundle bundle);

    void jumpToTemplateLibMainPage(@NotNull Context context, @NotNull Bundle bundle);

    void jumpToWinkEditorAfterProcessContent(@NotNull Context context, @NotNull String entryBusinessName, @Nullable String missionId, @NotNull String oldPath, @NotNull String newPath, @Nullable String traceId, @NotNull String taskId, @NotNull String fromType, boolean publish);

    void jumpToWinkEditorAfterProcessContent(@NotNull Context context, @NotNull String entryBusinessName, @Nullable String missionId, @Nullable ArrayList<String> mediaPaths, @Nullable String textContent, @Nullable Bundle payload, @Nullable String traceId);

    void jumpToWinkEditorAfterProcessContentForQQSign(@NotNull Context context, @NotNull String entryBusinessName, @Nullable String missionId, @NotNull String description, @Nullable String traceId, @NotNull String taskId, boolean publish);

    void jumpToWinkNewAlbumPreview(@NotNull Context context, @NotNull Bundle bundle, @Nullable List<? extends LocalMediaInfo> mediaInfoList);

    void jumpToWinkPublishPage(@NotNull Context context, @NotNull Intent intent);

    void jumpToWinkTemplateIntermediate(@NotNull Context context, @NotNull Intent intent, @Nullable String schema);

    void launchDebugNeonLightActivity(@NotNull Context context);

    void launchWinkDebugNewAlbumActivity(@NotNull Context context);

    void modifyMagicAvatar(@NotNull Context context, @NotNull ModifyAvatarConfig config, int requestCode);

    void preloadQQWink(@NotNull Context context);

    void shareToWink(@NotNull Context context, @NotNull Bundle bundle);
}
