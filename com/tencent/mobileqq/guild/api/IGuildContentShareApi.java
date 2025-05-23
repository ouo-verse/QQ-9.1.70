package com.tencent.mobileqq.guild.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.guild.contentshare.AbsGuildContentShareTemplate;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.winkreport.dengta.WinkDengtaReportConstant;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.File;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J2\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H&J\b\u0010\u0014\u001a\u00020\u0011H&J\b\u0010\u0015\u001a\u00020\u0011H&J\u0014\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t0\u0017H&J \u0010\u0018\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0011H&J!\u0010\u001a\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0011H&\u00a2\u0006\u0002\u0010\u001eJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\u0011H&J\b\u0010\"\u001a\u00020\u0011H&J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00110$H&J\u0010\u0010%\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&Jo\u0010&\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020*2\u0006\u0010\u0004\u001a\u00020\u00052K\u0010+\u001aG\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0013\u0012\u00110\u0013\u00a2\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(0\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\u00070,H&J \u00102\u001a\u00020\u00072\u0006\u0010'\u001a\u00020(2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u000206H&J(\u00107\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u00103\u001a\u0002042\u0006\u00108\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u0011H&J\u0018\u0010:\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u00108\u001a\u00020\u000bH&J\"\u0010;\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010\b\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0011H&\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/guild/api/IGuildContentShareApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createCacheFile", "Ljava/io/File;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Landroid/graphics/Bitmap;", "doPreload", "", "data", "", "guildId", "", "doShare", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "cacheFile", "shareType", "", "forceOldPanel", "", "getContentShareMaxHeight", "getContentShareMaxWidth", "getDataStore", "", "getFirstPicUrl", "width", "getShareBitmap", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/View;", "bgColor", "(Landroid/view/View;Ljava/lang/Integer;)Landroid/graphics/Bitmap;", "getTemplate", "Lcom/tencent/mobileqq/guild/contentshare/AbsGuildContentShareTemplate;", WinkDengtaReportConstant.Params.REPORT_TEMPLATE_TYPE, "getTemplateSize", "getTemplates", "", "putBgBitmapToCache", "saveToAlbum", "context", "Landroid/content/Context;", QCircleDaTongConstant.ElementParamValue.PERMISSION, "Lcom/tencent/mobileqq/qqpermission/QQPermission;", "callback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "filePath", "isSuccess", "errMsg", "setShareArkMsgToGuildIntent", "param", "Lorg/json/JSONObject;", "intent", "Landroid/content/Intent;", "shareQzonePicToGuild", "filePathTmp", "requestCode", "shareSpringPicToGuild", "startContentShareFragment", "Landroid/os/Bundle;", "scene", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGuildContentShareApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class a {
        public static /* synthetic */ void a(IGuildContentShareApi iGuildContentShareApi, Activity activity, Bitmap bitmap, File file, int i3, boolean z16, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 16) != 0) {
                    z16 = false;
                }
                iGuildContentShareApi.doShare(activity, bitmap, file, i3, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: doShare");
        }
    }

    @NotNull
    File createCacheFile(@NotNull Bitmap bitmap);

    void doPreload(@NotNull Object data, @NotNull String guildId);

    void doShare(@NotNull Activity activity, @NotNull Bitmap bitmap, @NotNull File cacheFile, int shareType, boolean forceOldPanel);

    int getContentShareMaxHeight();

    int getContentShareMaxWidth();

    @NotNull
    Map<Integer, Object> getDataStore();

    @NotNull
    String getFirstPicUrl(@NotNull Object data, @NotNull String guildId, int width);

    @Nullable
    Bitmap getShareBitmap(@NotNull View rootView, @Nullable Integer bgColor);

    @Nullable
    AbsGuildContentShareTemplate getTemplate(int templateType);

    int getTemplateSize();

    @NotNull
    Set<Integer> getTemplates();

    void putBgBitmapToCache(@NotNull Bitmap bitmap);

    void saveToAlbum(@Nullable Context context, @NotNull QQPermission permission, @NotNull Bitmap bitmap, @NotNull Function3<? super String, ? super Boolean, ? super String, Unit> callback);

    void setShareArkMsgToGuildIntent(@NotNull Context context, @NotNull JSONObject param, @NotNull Intent intent);

    void shareQzonePicToGuild(@NotNull Activity activity, @NotNull JSONObject param, @NotNull String filePathTmp, int requestCode);

    void shareSpringPicToGuild(@NotNull Activity activity, @NotNull String filePathTmp);

    void startContentShareFragment(@Nullable Context context, @NotNull Bundle data, int scene);
}
