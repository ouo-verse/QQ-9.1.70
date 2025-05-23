package com.tencent.mobileqq.guild.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.view.View;
import android.widget.ScrollView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.guild.aio.util.ui.GuildChatPicDownloader;
import com.tencent.guild.aio.util.ui.PicSize;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IFeedDetailDataParser;
import com.tencent.mobileqq.guild.api.IGuildContentShareApi;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.contentshare.AbsGuildContentShareTemplate;
import com.tencent.mobileqq.guild.contentshare.fragment.GuildContentShareFragment;
import com.tencent.mobileqq.guild.util.ar;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.api.IFileDepend;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.winkreport.dengta.WinkDengtaReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import vg1.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\n\u0018\u0000 M2\u00020\u0001:\u0001NB\u0007\u00a2\u0006\u0004\bK\u0010LJ\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002Jg\u0010\u0014\u001a\u00020\u00122\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2K\u0010\u0013\u001aG\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000bH\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u000fH\u0002J\u0018\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0012\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001e\u001a\u00020\u0004H\u0016J\b\u0010!\u001a\u00020\u0004H\u0016J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\"H\u0016J \u0010$\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016Jo\u0010'\u001a\u00020\u00122\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010&\u001a\u00020%2\u0006\u0010\n\u001a\u00020\t2K\u0010\u0013\u001aG\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000bH\u0016J\u0010\u0010(\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\tH\u0016J#\u0010,\u001a\u0004\u0018\u00010\t2\u0006\u0010*\u001a\u00020)2\b\u0010+\u001a\u0004\u0018\u00010\u0004H\u0016\u00a2\u0006\u0004\b,\u0010-J0\u00103\u001a\u00020\u00122\u0006\u0010/\u001a\u00020.2\u0006\u0010\n\u001a\u00020\t2\u0006\u00100\u001a\u00020\u00162\u0006\u00101\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u000fH\u0016J\"\u00106\u001a\u00020\u00122\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0019\u001a\u0002042\u0006\u00105\u001a\u00020\u0004H\u0016J\b\u00107\u001a\u00020\u0004H\u0016J\b\u00108\u001a\u00020\u0004H\u0016J\u0018\u00109\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010:\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\tH\u0016J \u0010=\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010<\u001a\u00020;2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J(\u0010@\u001a\u00020\u00122\u0006\u0010/\u001a\u00020.2\u0006\u0010<\u001a\u00020;2\u0006\u0010>\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u0004H\u0016J\u0014\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00180AH\u0016J\u0018\u0010C\u001a\u00020\u00122\u0006\u0010/\u001a\u00020.2\u0006\u0010>\u001a\u00020\u0002H\u0016R[\u0010J\u001aB\u0012\f\u0012\n D*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n D*\u0004\u0018\u00010\u00180\u0018 D* \u0012\f\u0012\n D*\u0004\u0018\u00010\u00040\u0004\u0012\f\u0012\n D*\u0004\u0018\u00010\u00180\u0018\u0018\u00010E0A8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\u00a8\u0006O"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/GuildContentShareApiImpl;", "Lcom/tencent/mobileqq/guild/api/IGuildContentShareApi;", "", "guildId", "", "width", "getGuildCoverUrl", "Landroid/content/Context;", "context", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "filePath", "", "isSuccess", "errMsg", "", "callback", "doSaveToAlbum", QAdRewardDefine$VideoParams.ISCACHE, "Ljava/io/File;", "getFleToWrite", "", "data", "preloadBlurBg", "Landroid/content/Intent;", "intent", "setAnimator", WinkDengtaReportConstant.Params.REPORT_TEMPLATE_TYPE, "Lcom/tencent/mobileqq/guild/contentshare/AbsGuildContentShareTemplate;", "getTemplate", "getTemplateSize", "", "getTemplates", "getFirstPicUrl", "Lcom/tencent/mobileqq/qqpermission/QQPermission;", QCircleDaTongConstant.ElementParamValue.PERMISSION, "saveToAlbum", "createCacheFile", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "bgColor", "getShareBitmap", "(Landroid/view/View;Ljava/lang/Integer;)Landroid/graphics/Bitmap;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "cacheFile", "shareType", "forceOldPanel", "doShare", "Landroid/os/Bundle;", "scene", "startContentShareFragment", "getContentShareMaxWidth", "getContentShareMaxHeight", "doPreload", "putBgBitmapToCache", "Lorg/json/JSONObject;", "param", "setShareArkMsgToGuildIntent", "filePathTmp", "requestCode", "shareQzonePicToGuild", "", "getDataStore", "shareSpringPicToGuild", "kotlin.jvm.PlatformType", "", "mDataStore$delegate", "Lkotlin/Lazy;", "getMDataStore", "()Ljava/util/Map;", "mDataStore", "<init>", "()V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildContentShareApiImpl implements IGuildContentShareApi {

    @NotNull
    public static final String SHARE_PIC_FILE_NAME_PREFIX = "qq_share_pic_";

    @NotNull
    public static final String SHARE_PIC_FILE_TYPE = ".jpg";

    @NotNull
    public static final String TAG = "GuildContentShareApiImpl";

    @NotNull
    private static final HashMap<Integer, Class<? extends AbsGuildContentShareTemplate>> TEMPLATE_MAP;

    /* renamed from: mDataStore$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mDataStore;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/api/impl/GuildContentShareApiImpl$c", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c extends QQPermission.BasePermissionsListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f214378b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Bitmap f214379c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function3<String, Boolean, String, Unit> f214380d;

        /* JADX WARN: Multi-variable type inference failed */
        c(Context context, Bitmap bitmap, Function3<? super String, ? super Boolean, ? super String, Unit> function3) {
            this.f214378b = context;
            this.f214379c = bitmap;
            this.f214380d = function3;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            GuildContentShareApiImpl.this.doSaveToAlbum(this.f214378b, this.f214379c, this.f214380d);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(@Nullable List<String> permissions, @Nullable List<Integer> results) {
            this.f214380d.invoke("", Boolean.FALSE, "\u65e0\u6743\u9650");
        }
    }

    static {
        HashMap<Integer, Class<? extends AbsGuildContentShareTemplate>> hashMapOf;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(0, com.tencent.mobileqq.guild.contentshare.template.c.class), TuplesKt.to(1, com.tencent.mobileqq.guild.contentshare.template.a.class));
        TEMPLATE_MAP = hashMapOf;
    }

    public GuildContentShareApiImpl() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Map<Integer, Object>>() { // from class: com.tencent.mobileqq.guild.api.impl.GuildContentShareApiImpl$mDataStore$2
            @Override // kotlin.jvm.functions.Function0
            public final Map<Integer, Object> invoke() {
                return Collections.synchronizedMap(new ArrayMap());
            }
        });
        this.mDataStore = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doSaveToAlbum(final Context context, final Bitmap bitmap, final Function3<? super String, ? super Boolean, ? super String, Unit> callback) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.api.impl.d
            @Override // java.lang.Runnable
            public final void run() {
                GuildContentShareApiImpl.doSaveToAlbum$lambda$2(GuildContentShareApiImpl.this, bitmap, context, callback);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doSaveToAlbum$lambda$2(GuildContentShareApiImpl this$0, Bitmap bitmap, Context context, Function3 callback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bitmap, "$bitmap");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        File fleToWrite = this$0.getFleToWrite(false);
        boolean d16 = com.tencent.mobileqq.guild.util.p.d(fleToWrite, bitmap);
        QLog.i(TAG, 1, "doSaveToAlbum result: " + d16 + ", file: " + fleToWrite.getAbsolutePath());
        if (d16) {
            ((IFileDepend) QRoute.api(IFileDepend.class)).saveToAlbum(context, fleToWrite.getAbsolutePath());
        }
        String absolutePath = fleToWrite.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
        callback.invoke(absolutePath, Boolean.valueOf(d16), "");
    }

    private final File getFleToWrite(boolean isCache) {
        String sDKPrivatePath;
        long currentTimeMillis = System.currentTimeMillis();
        if (isCache) {
            sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath("cache/");
            Intrinsics.checkNotNullExpressionValue(sDKPrivatePath, "{\n            VFSAssista\u2026ePath(\"cache/\")\n        }");
        } else {
            sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_IMG_SAVE);
            Intrinsics.checkNotNullExpressionValue(sDKPrivatePath, "{\n            VFSAssista\u2026DCARD_IMG_SAVE)\n        }");
        }
        File file = new File(sDKPrivatePath);
        if (!file.exists()) {
            QLog.i(TAG, 1, "getFleToWrite dir not exist: " + sDKPrivatePath + ", mkdir.");
            file.mkdirs();
        }
        File file2 = new File(sDKPrivatePath + SHARE_PIC_FILE_NAME_PREFIX + currentTimeMillis + ".jpg");
        int i3 = 2;
        while (file2.exists() && i3 < Integer.MAX_VALUE) {
            i3++;
            file2 = new File(sDKPrivatePath + SHARE_PIC_FILE_NAME_PREFIX + currentTimeMillis + "_" + i3 + ".jpg");
        }
        return file2;
    }

    private final String getGuildCoverUrl(String guildId, int width) {
        IGProGuildInfo guildInfo;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (guildInfo = ((IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "")).getGuildInfo(guildId)) == null) {
            return null;
        }
        return guildInfo.getCoverUrl(width, width);
    }

    private final Map<Integer, Object> getMDataStore() {
        return (Map) this.mDataStore.getValue();
    }

    private final void preloadBlurBg(Object data, String guildId) {
        int contentShareMaxWidth = getContentShareMaxWidth();
        String firstPicUrl = getFirstPicUrl(data, guildId, contentShareMaxWidth);
        if (!TextUtils.isEmpty(firstPicUrl)) {
            vg1.d.INSTANCE.k(firstPicUrl, contentShareMaxWidth, new b());
        }
    }

    private final void setAnimator(Intent intent) {
        intent.putExtra(QBaseActivity.KEY_SET_ACTIVITY_ANIMATION, true);
        intent.putExtra(QBaseActivity.KEY_ACTIVITY_OPEN_ENTER_ANIMATION, R.anim.f154445lb);
        intent.putExtra(QBaseActivity.KEY_ACTIVITY_OPEN_EXIT_ANIMATION, R.anim.f154449lf);
        intent.putExtra(QBaseActivity.KEY_ACTIVITY_CLOSE_ENTER_ANIMATION, R.anim.f154435l2);
        intent.putExtra(QBaseActivity.KEY_ACTIVITY_CLOSE_EXIT_ANIMATION, R.anim.f154436l4);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildContentShareApi
    @NotNull
    public File createCacheFile(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        File fleToWrite = getFleToWrite(true);
        QLog.i(TAG, 1, "createCacheFile result: " + com.tencent.mobileqq.guild.util.p.d(fleToWrite, bitmap) + ", file: " + fleToWrite.getAbsolutePath());
        return fleToWrite;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildContentShareApi
    public void doPreload(@NotNull Object data, @NotNull String guildId) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        preloadBlurBg(data, guildId);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildContentShareApi
    public void doShare(@NotNull Activity activity, @NotNull Bitmap bitmap, @NotNull File cacheFile, int shareType, boolean forceOldPanel) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(cacheFile, "cacheFile");
        QLog.i(TAG, 1, "doShare shareType: " + shareType);
        if (shareType != 0) {
            if (shareType != 1) {
                if (shareType != 2) {
                    if (shareType != 3) {
                        if (shareType != 4) {
                            if (shareType == 5) {
                                String absolutePath = cacheFile.getAbsolutePath();
                                Intrinsics.checkNotNullExpressionValue(absolutePath, "cacheFile.absolutePath");
                                m02.d.k(activity, absolutePath);
                                return;
                            }
                            return;
                        }
                        String absolutePath2 = cacheFile.getAbsolutePath();
                        Intrinsics.checkNotNullExpressionValue(absolutePath2, "cacheFile.absolutePath");
                        m02.d.u(activity, absolutePath2);
                        return;
                    }
                    String absolutePath3 = cacheFile.getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath3, "cacheFile.absolutePath");
                    m02.d.r(absolutePath3, bitmap);
                    return;
                }
                String absolutePath4 = cacheFile.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath4, "cacheFile.absolutePath");
                m02.d.q(absolutePath4, bitmap);
                return;
            }
            String absolutePath5 = cacheFile.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath5, "cacheFile.absolutePath");
            String string = activity.getString(R.string.f142790kb);
            Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str\u2026ld_content_share_success)");
            m02.d.p(activity, absolutePath5, string);
            return;
        }
        String absolutePath6 = cacheFile.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath6, "cacheFile.absolutePath");
        m02.d.m(activity, absolutePath6, forceOldPanel);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildContentShareApi
    public int getContentShareMaxHeight() {
        int i3 = BaseApplication.context.getResources().getDisplayMetrics().heightPixels;
        return (i3 - ((int) (i3 * 0.2d))) - ViewUtils.dip2px(126.0f);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildContentShareApi
    public int getContentShareMaxWidth() {
        return (int) (BaseApplication.context.getResources().getDisplayMetrics().heightPixels * 0.33d);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildContentShareApi
    @NotNull
    public Map<Integer, Object> getDataStore() {
        Map<Integer, Object> mDataStore = getMDataStore();
        Intrinsics.checkNotNullExpressionValue(mDataStore, "mDataStore");
        return mDataStore;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildContentShareApi
    @NotNull
    public String getFirstPicUrl(@NotNull Object data, @NotNull String guildId, int width) {
        Object first;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        if (data instanceof GuildMsgItem) {
            ArrayList<MsgElement> arrayList = ((GuildMsgItem) data).getMsgRecord().elements;
            Intrinsics.checkNotNullExpressionValue(arrayList, "data.msgRecord.elements");
            for (MsgElement element : arrayList) {
                if (element.elementType == 2 && element.picElement != null) {
                    GuildChatPicDownloader guildChatPicDownloader = GuildChatPicDownloader.f112420a;
                    Intrinsics.checkNotNullExpressionValue(element, "element");
                    String q16 = guildChatPicDownloader.q(element, PicSize.PIC_DOWNLOAD_AIO);
                    if (new File(q16).exists()) {
                        return q16;
                    }
                }
            }
        } else if (data instanceof IFeedDetailDataParser) {
            IFeedDetailDataParser iFeedDetailDataParser = (IFeedDetailDataParser) data;
            if (!iFeedDetailDataParser.getMediaInfoList().isEmpty()) {
                first = CollectionsKt___CollectionsKt.first((List<? extends Object>) iFeedDetailDataParser.getMediaInfoList());
                String thumbUrl = ((IFeedDetailDataParser.MediaInfo) first).getThumbUrl();
                QLog.i(TAG, 1, "getFirstPicUrl firstImageUrl=" + thumbUrl);
                return thumbUrl;
            }
        }
        String guildCoverUrl = getGuildCoverUrl(guildId, width);
        if (guildCoverUrl == null) {
            return "";
        }
        return guildCoverUrl;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004f A[Catch: Exception -> 0x0067, TryCatch #0 {Exception -> 0x0067, blocks: (B:11:0x0038, B:13:0x004f, B:14:0x005a, B:16:0x0060, B:17:0x0063), top: B:10:0x0038 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0060 A[Catch: Exception -> 0x0067, TryCatch #0 {Exception -> 0x0067, blocks: (B:11:0x0038, B:13:0x004f, B:14:0x005a, B:16:0x0060, B:17:0x0063), top: B:10:0x0038 }] */
    @Override // com.tencent.mobileqq.guild.api.IGuildContentShareApi
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Bitmap getShareBitmap(@NotNull View rootView, @Nullable Integer bgColor) {
        int height;
        View view;
        Drawable background;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        try {
            if (rootView instanceof ScrollView) {
                ScrollView scrollView = (ScrollView) rootView;
                int childCount = scrollView.getChildCount();
                height = 0;
                for (int i3 = 0; i3 < childCount; i3++) {
                    height += scrollView.getChildAt(i3).getHeight();
                }
                if (scrollView.getChildCount() > 0) {
                    view = scrollView.getChildAt(0);
                    Intrinsics.checkNotNullExpressionValue(view, "rootView.getChildAt(0)");
                    Bitmap createBitmap = Bitmap.createBitmap(rootView.getWidth(), height, Bitmap.Config.ARGB_8888);
                    Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(\n          \u2026g.ARGB_8888\n            )");
                    Canvas canvas = new Canvas(createBitmap);
                    if (bgColor != null) {
                        ar.b(bgColor.intValue(), canvas, rootView.getWidth(), height);
                    }
                    background = rootView.getBackground();
                    if (background != null) {
                        background.draw(canvas);
                    }
                    view.draw(canvas);
                    return createBitmap;
                }
            } else {
                height = rootView.getHeight();
            }
            Bitmap createBitmap2 = Bitmap.createBitmap(rootView.getWidth(), height, Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(createBitmap2, "createBitmap(\n          \u2026g.ARGB_8888\n            )");
            Canvas canvas2 = new Canvas(createBitmap2);
            if (bgColor != null) {
            }
            background = rootView.getBackground();
            if (background != null) {
            }
            view.draw(canvas2);
            return createBitmap2;
        } catch (Exception e16) {
            QLog.i(TAG, 1, "getShareBitmap width: " + rootView.getWidth() + ", height: " + height + ", exception: " + e16.getMessage());
            return null;
        }
        view = rootView;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildContentShareApi
    @Nullable
    public AbsGuildContentShareTemplate getTemplate(int templateType) {
        HashMap<Integer, Class<? extends AbsGuildContentShareTemplate>> hashMap = TEMPLATE_MAP;
        if (hashMap.containsKey(Integer.valueOf(templateType))) {
            try {
                Class<? extends AbsGuildContentShareTemplate> cls = hashMap.get(Integer.valueOf(templateType));
                if (cls == null) {
                    return null;
                }
                return cls.newInstance();
            } catch (Exception e16) {
                QLog.i(TAG, 1, "getTemplate templateType: " + templateType + ", exception: " + e16.getMessage());
            }
        } else {
            QLog.i(TAG, 1, "getTemplate templateType: " + templateType + " NOT FOUND!");
        }
        return null;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildContentShareApi
    public int getTemplateSize() {
        return TEMPLATE_MAP.size();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildContentShareApi
    @NotNull
    public Set<Integer> getTemplates() {
        Set<Integer> keySet = TEMPLATE_MAP.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "TEMPLATE_MAP.keys");
        return keySet;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildContentShareApi
    public void putBgBitmapToCache(@NotNull Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        ImageCacheHelper.f98636a.i("GuildContentShareFragment_BG_BITMAP", bitmap, Business.Guild);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildContentShareApi
    public void saveToAlbum(@Nullable Context context, @NotNull QQPermission permission, @NotNull Bitmap bitmap, @NotNull Function3<? super String, ? super Boolean, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(permission, "permission");
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (context == null) {
            callback.invoke("", Boolean.FALSE, "invalid context");
            QLog.i(TAG, 1, "saveToAlbum context is null!");
        } else if (permission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) != 0) {
            QLog.i(TAG, 1, "saveToAlbum requestPermissions");
            permission.requestPermissions(new String[]{QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, new c(context, bitmap, callback));
        } else {
            doSaveToAlbum(context, bitmap, callback);
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildContentShareApi
    public void setShareArkMsgToGuildIntent(@NotNull Context context, @NotNull JSONObject param, @NotNull Intent intent) {
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(intent, "intent");
        try {
            String extJson = param.optString(WadlProxyConsts.EXT_JSON, "");
            Intrinsics.checkNotNullExpressionValue(extJson, "extJson");
            if (extJson.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                intent.putExtra("only_single_selection", new JSONObject(extJson).optBoolean("only_single_selection", false));
                intent.putExtra("share_ark_msg_ext_json", extJson);
            }
            intent.putExtra("call_by_forward", true);
            intent.setClass(context, QPublicFragmentActivity.class);
            intent.putExtra("public_fragment_class", ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).getGuildForwardListFragmentClass().getName());
        } catch (Exception e16) {
            QLog.e(TAG, 1, "shareArkMsgToGuild e: " + e16);
        }
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildContentShareApi
    public void shareQzonePicToGuild(@NotNull Activity activity, @NotNull JSONObject param, @NotNull String filePathTmp, int requestCode) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(filePathTmp, "filePathTmp");
        m02.d.f415923a.l(activity, param, filePathTmp, requestCode);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildContentShareApi
    public void shareSpringPicToGuild(@NotNull Activity activity, @NotNull String filePathTmp) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(filePathTmp, "filePathTmp");
        m02.d.o(activity, filePathTmp);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildContentShareApi
    public void startContentShareFragment(@Nullable Context context, @NotNull Bundle data, int scene) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intent intent = new Intent();
        intent.putExtra("guild_content_share_bundle_key", data);
        intent.putExtra("guild_content_share_from_key", scene);
        intent.addFlags(268435456);
        setAnimator(intent);
        if (context == null) {
            context = BaseApplication.context;
        }
        QPublicFragmentActivity.b.b(context, intent, QPublicFragmentActivity.class, GuildContentShareFragment.class);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/api/impl/GuildContentShareApiImpl$b", "Lvg1/d$c;", "", "mainColor", "", "c", "", "url", "Landroid/graphics/Bitmap;", "blurBitmap", "a", NodeProps.SHADOW_COLOR, "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements d.c {
        b() {
        }

        @Override // vg1.d.c
        public void a(@NotNull String url, @Nullable Bitmap blurBitmap) {
            Intrinsics.checkNotNullParameter(url, "url");
            if (blurBitmap != null) {
                QLog.i(GuildContentShareApiImpl.TAG, 1, "preloadBg done. url: " + url);
                vg1.d.INSTANCE.l(url, blurBitmap);
            }
        }

        @Override // vg1.d.c
        public void b(int shadowColor) {
        }

        @Override // vg1.d.c
        public void c(int mainColor) {
        }
    }
}
