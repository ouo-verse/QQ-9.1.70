package com.tencent.mobileqq.zplan.avatar.image;

import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.avatar.image.ZPlanAvatarImageManager;
import com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper;
import com.tencent.mobileqq.zplan.servlet.api.IZPlanRequest;
import com.tencent.mobileqq.zplan.utils.bb;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import com.tencent.sqshow.servlet.ZPlanRequestHandler;
import com.tencent.ttpic.openapi.filter.LightConstants;
import com.tencent.zplan.common.model.AppTheme;
import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import nk3.p;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 K2\u00020\u0001:\u0004KLMNB\t\b\u0002\u00a2\u0006\u0004\bI\u0010JJ\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001c\u0010\u000b\u001a\u00020\n2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\bH\u0002J \u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u0015\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J(\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J \u0010\u0017\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0012\u0010\u001d\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0002J(\u0010!\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u001fH\u0002J \u0010\"\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\u0004H\u0002J \u0010$\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0004H\u0002J \u0010'\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%H\u0002J\u001c\u0010)\u001a\u00020\n*\u00020(2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0002J \u0010,\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0004H\u0002J\b\u0010-\u001a\u00020\u0011H\u0002J\u0010\u0010.\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u0004H\u0002J\u0012\u00100\u001a\u00020/2\b\u0010#\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u00102\u001a\u0002012\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u001c\u00104\u001a\u00020\n2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000403H\u0002J\u0018\u00105\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u00106\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u0018\u00107\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J\u000e\u00108\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010:\u001a\u00020\n2\u0006\u00109\u001a\u00020\u0004J\u0018\u0010;\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010<\u001a\u00020\u001f2\u0006\u0010\f\u001a\u00020\u0004J\u0016\u0010>\u001a\u00020=2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010?\u001a\u00020\nJ\u0006\u0010@\u001a\u00020\nJ\u000e\u0010A\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004J&\u0010C\u001a\u00020\n2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\b2\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u0004J\"\u0010E\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010\u00042\b\u0010D\u001a\u0004\u0018\u00010\u00042\u0006\u0010 \u001a\u00020\u001fJ\u0010\u0010F\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u0004J\u0010\u0010G\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u0004J\u0010\u0010H\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u0004\u00a8\u0006O"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/image/ZPlanAvatarImageManager;", "", "", "gender", "", "theme", "P", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "", "infoList", "", "y", "uin", "url", "v", "a0", UserInfo.SEX_FEMALE, "Ljava/io/File;", "downloadFile", "Lcom/tencent/mobileqq/zplan/avatar/image/ZPlanAvatarImageManager$b;", "cb", "G", "r", "t", "D", "Lcom/tencent/zplan/common/model/AppTheme;", "appTheme", "V", "filePath", "E", "imgCacheFile", "", "windowsillLocation", "l0", "b0", "path", "w", "Lcom/tencent/mobileqq/zplan/avatar/image/ZPlanAvatarImageManager$c;", "callback", "o0", "Lcom/tencent/mobileqq/transfile/TransferRequest;", "p0", "dayImgUrl", "nightImgUrl", "i0", "N", HippyTKDListViewAdapter.X, "", "Z", "Landroid/content/SharedPreferences;", "W", "", BdhLogUtil.LogTag.Tag_Conn, BdhLogUtil.LogTag.Tag_Req, "K", "X", "Y", "key", "k0", "L", "M", "Ljava/net/URL;", "O", "H", "c0", "f0", "othersUin", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "nightThemePath", "m0", "T", "U", ExifInterface.LATITUDE_SOUTH, "<init>", "()V", "a", "b", "c", "d", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanAvatarImageManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy<ZPlanAvatarImageManager> f331782b;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010\bR!\u0010\t\u001a\u00020\u00028FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0014\u0010\u0011\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\fR\u0014\u0010\u0012\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\fR\u0014\u0010\u0015\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\fR\u0014\u0010\u0016\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\fR\u0014\u0010\u0017\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\fR\u0014\u0010\u0018\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\fR\u0014\u0010\u0019\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\fR\u0014\u0010\u001a\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\fR\u0014\u0010\u001b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\fR\u0014\u0010\u001c\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\fR\u0014\u0010\u001d\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\fR\u0014\u0010\u001e\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\f\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/image/ZPlanAvatarImageManager$a;", "", "Lcom/tencent/mobileqq/zplan/avatar/image/ZPlanAvatarImageManager;", "INSTANCE$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/mobileqq/zplan/avatar/image/ZPlanAvatarImageManager;", "getINSTANCE$annotations", "()V", "INSTANCE", "", "AVATAR_IMAGE_DIR", "Ljava/lang/String;", "", "DAY_THEME_STATIC_AVATAR_IMG", "I", "EMPTY_RESPONSE", "NO_MEDIA", "RETRY_DOWNLOAD_TIME", "RETRY_UPLOAD_TIME", "SP_KEY_AVATAR_IMAGE_PATH", "SP_KEY_AVATAR_IMAGE_URL", "SP_KEY_AVATAR_WINDOW_SILL_LOCATION", "SP_KEY_DEFAULT_FEMALE_PATH", "SP_KEY_DEFAULT_MALE_PATH", "SP_STATIC_AVATAR_APPEARANCE_KEY", "SP_SUPER_QQSHOW_DYNAMIC_AVATAR_APPEARANCE_KEY", "SP_SUPER_QQSHOW_DYNAMIC_AVATAR_EXTEND_PORTRAIT_ID_CONFIG", "SP_SUPER_QQSHOW_DYNAMIC_AVATAR_PROPERTY", "SP_SUPER_QQSHOW_DYNAMIC_AVATAR_URL", "TAG", "<init>", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.avatar.image.ZPlanAvatarImageManager$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZPlanAvatarImageManager a() {
            return (ZPlanAvatarImageManager) ZPlanAvatarImageManager.f331782b.getValue();
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/image/ZPlanAvatarImageManager$b;", "", "", "isSuccess", "", "onResult", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface b {
        void onResult(boolean isSuccess);
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/image/ZPlanAvatarImageManager$c;", "", "", "isSuccess", "", "url", "", "onResult", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public interface c {
        void onResult(boolean isSuccess, String url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u001e\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0006\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R,\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/image/ZPlanAvatarImageManager$d;", "Lcom/tencent/mobileqq/transfile/TransProcessorHandler;", "Landroid/os/Message;", "msg", "", "handleMessage", "Lkotlin/Function3;", "", "Lcom/tencent/mobileqq/transfile/FileMsg;", "a", "Lkotlin/jvm/functions/Function3;", "cb", "<init>", "(Lkotlin/jvm/functions/Function3;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d extends TransProcessorHandler {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final Function3<d, Integer, FileMsg, Unit> cb;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(Function3<? super d, ? super Integer, ? super FileMsg, Unit> cb5) {
            super(Looper.getMainLooper());
            Intrinsics.checkNotNullParameter(cb5, "cb");
            this.cb = cb5;
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            if (msg2.obj instanceof FileMsg) {
                Function3<d, Integer, FileMsg, Unit> function3 = this.cb;
                Integer valueOf = Integer.valueOf(msg2.what);
                Object obj = msg2.obj;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.mobileqq.transfile.FileMsg");
                function3.invoke(this, valueOf, (FileMsg) obj);
                return;
            }
            super.handleMessage(msg2);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/avatar/image/ZPlanAvatarImageManager$h", "Lcom/tencent/mobileqq/zplan/avatar/image/ZPlanAvatarImageManager$c;", "", "isSuccess", "", "url", "", "onResult", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class h implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<String> f331798a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ZPlanAvatarImageManager f331799b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f331800c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ File f331801d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ i f331802e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f331803f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ File f331804g;

        h(Ref.ObjectRef<String> objectRef, ZPlanAvatarImageManager zPlanAvatarImageManager, String str, File file, i iVar, Ref.IntRef intRef, File file2) {
            this.f331798a = objectRef;
            this.f331799b = zPlanAvatarImageManager;
            this.f331800c = str;
            this.f331801d = file;
            this.f331802e = iVar;
            this.f331803f = intRef;
            this.f331804g = file2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.zplan.avatar.image.ZPlanAvatarImageManager.c
        public void onResult(boolean isSuccess, String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            if (isSuccess) {
                this.f331798a.element = url;
                ZPlanAvatarImageManager zPlanAvatarImageManager = this.f331799b;
                String uin = this.f331800c;
                Intrinsics.checkNotNullExpressionValue(uin, "uin");
                String absolutePath = this.f331801d.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "nightImgCacheFile.absolutePath");
                zPlanAvatarImageManager.o0(uin, absolutePath, this.f331802e);
                return;
            }
            QLog.e("ZPlanAvatarImageManager", 1, "upload dayTheme image fail, " + this.f331803f.element);
            Ref.IntRef intRef = this.f331803f;
            int i3 = intRef.element;
            intRef.element = i3 + (-1);
            if (i3 > 0) {
                ZPlanAvatarImageManager zPlanAvatarImageManager2 = this.f331799b;
                String uin2 = this.f331800c;
                Intrinsics.checkNotNullExpressionValue(uin2, "uin");
                String absolutePath2 = this.f331804g.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath2, "dayImgCacheFile.absolutePath");
                zPlanAvatarImageManager2.o0(uin2, absolutePath2, this);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/avatar/image/ZPlanAvatarImageManager$i", "Lcom/tencent/mobileqq/zplan/avatar/image/ZPlanAvatarImageManager$c;", "", "isSuccess", "", "url", "", "onResult", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class i implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<String> f331805a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ZPlanAvatarImageManager f331806b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f331807c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Ref.ObjectRef<String> f331808d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f331809e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ File f331810f;

        i(Ref.ObjectRef<String> objectRef, ZPlanAvatarImageManager zPlanAvatarImageManager, String str, Ref.ObjectRef<String> objectRef2, Ref.IntRef intRef, File file) {
            this.f331805a = objectRef;
            this.f331806b = zPlanAvatarImageManager;
            this.f331807c = str;
            this.f331808d = objectRef2;
            this.f331809e = intRef;
            this.f331810f = file;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.zplan.avatar.image.ZPlanAvatarImageManager.c
        public void onResult(boolean isSuccess, String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            if (isSuccess) {
                this.f331805a.element = url;
                ZPlanAvatarImageManager zPlanAvatarImageManager = this.f331806b;
                String uin = this.f331807c;
                Intrinsics.checkNotNullExpressionValue(uin, "uin");
                zPlanAvatarImageManager.i0(uin, this.f331808d.element, this.f331805a.element);
                return;
            }
            QLog.e("ZPlanAvatarImageManager", 1, "upload nightTheme image fail, " + this.f331809e.element);
            Ref.IntRef intRef = this.f331809e;
            int i3 = intRef.element;
            intRef.element = i3 + (-1);
            if (i3 > 0) {
                ZPlanAvatarImageManager zPlanAvatarImageManager2 = this.f331806b;
                String uin2 = this.f331807c;
                Intrinsics.checkNotNullExpressionValue(uin2, "uin");
                String absolutePath = this.f331810f.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "nightImgCacheFile.absolutePath");
                zPlanAvatarImageManager2.o0(uin2, absolutePath, this);
            }
        }
    }

    static {
        Lazy<ZPlanAvatarImageManager> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<ZPlanAvatarImageManager>() { // from class: com.tencent.mobileqq.zplan.avatar.image.ZPlanAvatarImageManager$Companion$INSTANCE$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZPlanAvatarImageManager invoke() {
                return new ZPlanAvatarImageManager(null);
            }
        });
        f331782b = lazy;
    }

    public /* synthetic */ ZPlanAvatarImageManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(String uin, ZPlanAvatarImageManager this$0, Map infoList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(infoList, "$infoList");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (uin == null || uin.length() == 0) {
            uin = peekAppRuntime.getCurrentAccountUin();
        }
        Intrinsics.checkNotNullExpressionValue(uin, "uin");
        SharedPreferences.Editor edit = this$0.W(uin).edit();
        String str = (String) infoList.get(Integer.valueOf(ProfileContants.FIELD_ZPLAN_COVER_IMG));
        if (str == null || str.length() == 0) {
            AppTheme appTheme = AppTheme.DAY;
            edit.putString("zplan_avatar_image_path" + appTheme, "EMPTY_RESPONSE");
            edit.remove("zplan_avatar_image_url" + appTheme);
        } else {
            this$0.v(uin, String.valueOf(AppTheme.DAY), str);
        }
        String str2 = (String) infoList.get(3);
        if (str2 == null || str2.length() == 0) {
            AppTheme appTheme2 = AppTheme.NIGHT;
            edit.putString("zplan_avatar_image_path" + appTheme2, "EMPTY_RESPONSE");
            edit.remove("zplan_avatar_image_url" + appTheme2);
        } else {
            this$0.v(uin, String.valueOf(AppTheme.NIGHT), str2);
        }
        edit.apply();
        QLog.i("ZPlanAvatarImageManager", 1, "dealWithStaticImg dayUrl:" + str + ", nightUrl:" + str2);
        this$0.a0(String.valueOf(AppTheme.NIGHT));
        this$0.a0(String.valueOf(AppTheme.DAY));
    }

    private final void D(String uin) {
        String V = V(uin, AppTheme.DAY);
        String V2 = V(uin, AppTheme.NIGHT);
        E(V);
        E(V2);
    }

    private final void E(String filePath) {
        if (TextUtils.isEmpty(filePath) || !new File(filePath).exists()) {
            return;
        }
        new File(filePath).delete();
    }

    private final void F(int gender, String theme) {
        String R = R(gender, theme);
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 3;
        File file = new File(N(), "download_default_" + gender + "_" + System.currentTimeMillis() + ".png");
        G(R, file, new f(file, gender, theme, R, intRef));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(String url, File downloadFile, b cb5) {
        QLog.i("ZPlanAvatarImageManager", 2, "downloadImage url = " + url);
        g gVar = new g(downloadFile, cb5);
        HttpNetReq httpNetReq = new HttpNetReq();
        httpNetReq.mCallback = gVar;
        httpNetReq.mHttpMethod = 0;
        httpNetReq.mReqUrl = url;
        httpNetReq.mOutPath = downloadFile.getAbsolutePath();
        httpNetReq.mPrioty = 1;
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IHttpEngineService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026ava, ProcessConstant.ALL)");
        ((IHttpEngineService) runtimeService).sendReq(httpNetReq);
        QLog.i("ZPlanAvatarImageManager", 1, "start download image " + url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(final ZPlanAvatarImageManager this$0) {
        List<com.tencent.mobileqq.zplan.model.c> mutableListOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("ZPlanAvatarImageManager", 1, "fetchStaticImgUrl requestOidb1127 begin");
        String uin = MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentAccountUin();
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new com.tencent.mobileqq.zplan.model.c(ProfileContants.FIELD_ZPLAN_COVER_IMG, 1), new com.tencent.mobileqq.zplan.model.c(4, 1), new com.tencent.mobileqq.zplan.model.c(9, 1), new com.tencent.mobileqq.zplan.model.c(5, 1), new com.tencent.mobileqq.zplan.model.c(3, 1), new com.tencent.mobileqq.zplan.model.c(16, 1));
        IZPlanRequest iZPlanRequest = (IZPlanRequest) QRoute.api(IZPlanRequest.class);
        Intrinsics.checkNotNullExpressionValue(uin, "uin");
        iZPlanRequest.requestOidb1127(mutableListOf, Long.parseLong(uin), 5, new p() { // from class: com.tencent.mobileqq.zplan.avatar.image.h
            @Override // nk3.p
            public final void a(Map map) {
                ZPlanAvatarImageManager.J(ZPlanAvatarImageManager.this, map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(ZPlanAvatarImageManager this$0, Map map) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (map != null) {
            A(this$0, map, null, 2, null);
            this$0.y(map);
            this$0.C(map);
        }
    }

    private final File N() {
        File file;
        try {
            file = MobileQQ.sMobileQQ.getApplicationContext().getExternalCacheDir();
        } catch (Throwable th5) {
            QLog.w("ZPlanAvatarImageManager", 1, "get external cache dir exception", th5);
            file = null;
        }
        File file2 = new File(file, "zplan/avatarimage/");
        if (file2.exists() && file2.isFile()) {
            file2.delete();
        }
        if (!file2.exists()) {
            file2.mkdirs();
        }
        String absolutePath = file2.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "dir.absolutePath");
        x(absolutePath);
        return file2;
    }

    private final String Q(String gender, String theme) {
        String string = W("").getString(gender + theme, null);
        return string == null ? W("").getString(String.valueOf(gender), null) : string;
    }

    private final String V(String uin, AppTheme appTheme) {
        String string = W(uin).getString("zplan_avatar_image_path" + appTheme, null);
        W(uin).edit().remove("zplan_avatar_image_path" + appTheme).commit();
        return string;
    }

    private final SharedPreferences W(String uin) {
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("zplan_sp" + uin, 4);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getApplication()\n       \u2026ntext.MODE_MULTI_PROCESS)");
        return sharedPreferences;
    }

    private final void a0(String theme) {
        QLog.i("ZPlanAvatarImageManager", 2, "pre download default avatar image");
        if (!Z(P(1, theme))) {
            F(1, theme);
        }
        if (Z(P(2, theme))) {
            return;
        }
        F(2, theme);
    }

    private final void b0(String uin, AppTheme theme, String url) {
        W(uin).edit().putString("zplan_avatar_image_url" + theme, url).apply();
        QLog.i("ZPlanAvatarImageManager", 1, "recordStaticAvatarAfterUpload url: " + url + "  current theme: " + theme);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d0() {
        List<com.tencent.mobileqq.zplan.model.c> mutableListOf;
        QLog.i("ZPlanAvatarImageManager", 1, "requestStaticImageUrl");
        String uin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin();
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new com.tencent.mobileqq.zplan.model.c(ProfileContants.FIELD_ZPLAN_COVER_IMG, 1), new com.tencent.mobileqq.zplan.model.c(3, 1));
        IZPlanRequest iZPlanRequest = (IZPlanRequest) QRoute.api(IZPlanRequest.class);
        Intrinsics.checkNotNullExpressionValue(uin, "uin");
        iZPlanRequest.requestOidb1127(mutableListOf, Long.parseLong(uin), 5, new p() { // from class: com.tencent.mobileqq.zplan.avatar.image.e
            @Override // nk3.p
            public final void a(Map map) {
                ZPlanAvatarImageManager.e0(map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(final String uin, final ZPlanAvatarImageManager this$0) {
        List<com.tencent.mobileqq.zplan.model.c> mutableListOf;
        Intrinsics.checkNotNullParameter(uin, "$uin");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("ZPlanAvatarImageManager", 1, "requestStaticImageUrl");
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new com.tencent.mobileqq.zplan.model.c(ProfileContants.FIELD_ZPLAN_COVER_IMG, 1), new com.tencent.mobileqq.zplan.model.c(3, 1));
        ((IZPlanRequest) QRoute.api(IZPlanRequest.class)).requestOidb1127(mutableListOf, Long.parseLong(uin), 5, new p() { // from class: com.tencent.mobileqq.zplan.avatar.image.d
            @Override // nk3.p
            public final void a(Map map) {
                ZPlanAvatarImageManager.h0(ZPlanAvatarImageManager.this, uin, map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(ZPlanAvatarImageManager this$0, String uin, Map it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.z(it, uin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(ZPlanAvatarImageManager this$0, String uin, String dayImgUrl, String nightImgUrl, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        Intrinsics.checkNotNullParameter(dayImgUrl, "$dayImgUrl");
        Intrinsics.checkNotNullParameter(nightImgUrl, "$nightImgUrl");
        this$0.b0(uin, AppTheme.DAY, dayImgUrl);
        this$0.b0(uin, AppTheme.NIGHT, nightImgUrl);
    }

    private final void l0(AppTheme theme, String uin, File imgCacheFile, float windowsillLocation) {
        W(uin).edit().putString("zplan_avatar_image_path" + theme, imgCacheFile.getAbsolutePath()).putString("zplan_avatar_image_url" + theme, "").putFloat("zplan_avatar_image_windowsillLocation", windowsillLocation).apply();
        QLog.i("ZPlanAvatarImageManager", 1, "recordStaticAvatarBeforeUpload file: " + imgCacheFile + "  current theme: " + theme);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(String str, ZPlanAvatarImageManager this$0, String str2, float f16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (str != null && this$0.Z(str)) {
            if (str2 != null && this$0.Z(str2)) {
                String uin = MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentAccountUin();
                Intrinsics.checkNotNullExpressionValue(uin, "uin");
                this$0.D(uin);
                AppTheme appTheme = AppTheme.DAY;
                File w3 = this$0.w(appTheme, uin, str);
                AppTheme appTheme2 = AppTheme.NIGHT;
                File w16 = this$0.w(appTheme2, uin, str2);
                this$0.k0(((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).getUserZPlanInfo(uin).appearanceKey);
                this$0.l0(appTheme, uin, w3, f16);
                this$0.l0(appTheme2, uin, w16, f16);
                ZPlanRequestHandler a16 = ZPlanRequestHandler.INSTANCE.a();
                if (a16 != null) {
                    a16.notifyUI(6, true, "");
                }
                QLog.i("ZPlanAvatarImageManager", 1, "start upload image dayFile== " + w3.getAbsolutePath() + " nightFile == " + w16.getAbsolutePath());
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = "";
                Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                Ref.IntRef intRef = new Ref.IntRef();
                intRef.element = 3;
                Ref.IntRef intRef2 = new Ref.IntRef();
                intRef2.element = 3;
                h hVar = new h(objectRef, this$0, uin, w16, new i(objectRef2, this$0, uin, objectRef, intRef2, w16), intRef, w3);
                String absolutePath = w3.getAbsolutePath();
                Intrinsics.checkNotNullExpressionValue(absolutePath, "dayImgCacheFile.absolutePath");
                this$0.o0(uin, absolutePath, hVar);
                return;
            }
            QLog.e("ZPlanAvatarImageManager", 1, "nightPath is empty or file is not exists " + str2);
            return;
        }
        QLog.e("ZPlanAvatarImageManager", 1, "path is empty or file is not exists " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o0(String uin, final String path, final c callback) {
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(ITransFileController.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026ava, ProcessConstant.ALL)");
        final ITransFileController iTransFileController = (ITransFileController) runtimeService;
        d dVar = new d(new Function3<d, Integer, FileMsg, Unit>() { // from class: com.tencent.mobileqq.zplan.avatar.image.ZPlanAvatarImageManager$uploadImage$uploadHandler$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(ZPlanAvatarImageManager.d dVar2, Integer num, FileMsg fileMsg) {
                invoke(dVar2, num.intValue(), fileMsg);
                return Unit.INSTANCE;
            }

            public final void invoke(ZPlanAvatarImageManager.d self, int i3, FileMsg fileMsg) {
                TransferRequest transferRequest;
                Intrinsics.checkNotNullParameter(self, "self");
                Intrinsics.checkNotNullParameter(fileMsg, "fileMsg");
                BaseTransProcessor baseTransProcessor = fileMsg.processor;
                if (!Intrinsics.areEqual(path, (baseTransProcessor == null || (transferRequest = baseTransProcessor.mUiRequest) == null) ? null : transferRequest.mLocalPath)) {
                    QLog.i("ZPlanAvatarImageManager", 2, "upload handler path is not equals");
                    return;
                }
                switch (i3) {
                    case 1003:
                        iTransFileController.removeHandle(self);
                        BaseTransProcessor baseTransProcessor2 = fileMsg.processor;
                        NearbyPeoplePhotoUploadProcessor nearbyPeoplePhotoUploadProcessor = baseTransProcessor2 instanceof NearbyPeoplePhotoUploadProcessor ? (NearbyPeoplePhotoUploadProcessor) baseTransProcessor2 : null;
                        String str = nearbyPeoplePhotoUploadProcessor != null ? nearbyPeoplePhotoUploadProcessor.mUrl : null;
                        QLog.i("ZPlanAvatarImageManager", 1, "upload image " + path + " finished, url = " + str);
                        if (str == null || str.length() == 0) {
                            callback.onResult(false, "");
                            return;
                        } else {
                            callback.onResult(true, str);
                            return;
                        }
                    case 1004:
                        QLog.i("ZPlanAvatarImageManager", 1, "upload image " + path + " cancel");
                        callback.onResult(false, "");
                        iTransFileController.removeHandle(self);
                        return;
                    case 1005:
                        QLog.e("ZPlanAvatarImageManager", 1, "upload image " + path + " error");
                        callback.onResult(false, "");
                        iTransFileController.removeHandle(self);
                        return;
                    default:
                        return;
                }
            }
        });
        dVar.addFilter(NearbyPeoplePhotoUploadProcessor.class);
        iTransFileController.addHandle(dVar);
        TransferRequest transferRequest = new TransferRequest();
        p0(transferRequest, path, uin);
        iTransFileController.transferAsync(transferRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(final String theme, final String uin, final String url, final File downloadFile) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.avatar.image.b
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanAvatarImageManager.s(ZPlanAvatarImageManager.this, theme, uin, downloadFile, url);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(ZPlanAvatarImageManager this$0, String theme, String uin, File downloadFile, String url) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(theme, "$theme");
        Intrinsics.checkNotNullParameter(uin, "$uin");
        Intrinsics.checkNotNullParameter(downloadFile, "$downloadFile");
        Intrinsics.checkNotNullParameter(url, "$url");
        File file = new File(this$0.N(), theme + "_" + uin + "_" + System.currentTimeMillis() + ".png");
        boolean renameTo = downloadFile.renameTo(file);
        if (renameTo) {
            downloadFile = file;
        } else {
            QLog.w("ZPlanAvatarImageManager", 1, "rename avatar file : " + file + " after download ret=" + renameTo + " theme:" + theme);
        }
        this$0.W(uin).edit().putString("zplan_avatar_image_path" + theme, downloadFile.getAbsolutePath()).putString("zplan_avatar_image_url" + theme, url).apply();
        QLog.i("ZPlanAvatarImageManager", 1, "rename and cache avatar success file=" + downloadFile.getAbsolutePath() + " current theme:" + theme);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(final File downloadFile, final int gender, final String theme) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.avatar.image.k
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanAvatarImageManager.u(gender, this, theme, downloadFile);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(int i3, ZPlanAvatarImageManager this$0, String theme, File downloadFile) {
        File file;
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(theme, "$theme");
        Intrinsics.checkNotNullParameter(downloadFile, "$downloadFile");
        if (i3 == 2) {
            file = new File(this$0.N(), theme + "_default_female.png");
        } else {
            file = new File(this$0.N(), theme + "_default_male.png");
        }
        if (i3 == 2) {
            str = "zplan_avatar_default_female_path";
        } else {
            str = "zplan_avatar_default_male_path";
        }
        boolean renameTo = downloadFile.renameTo(file);
        if (renameTo) {
            downloadFile = file;
        } else {
            QLog.w("ZPlanAvatarImageManager", 1, "rename default path ret=" + renameTo);
        }
        this$0.W("").edit().putString(str + theme, downloadFile.getAbsolutePath()).apply();
        QLog.i("ZPlanAvatarImageManager", 1, "rename and cache default success theme= " + theme + " gender=" + i3 + " file=" + downloadFile.getAbsolutePath());
    }

    private final void v(String uin, String theme, String url) {
        String string = W(uin).getString("zplan_avatar_image_path" + theme, null);
        if (TextUtils.equals(url, W(uin).getString("zplan_avatar_image_url" + theme, null)) && Z(string)) {
            QLog.i("ZPlanAvatarImageManager", 1, "avatar image url is not changed and cache file exists theme " + theme);
            return;
        }
        if (TextUtils.isEmpty(url)) {
            QLog.i("ZPlanAvatarImageManager", 1, "avatar image url is empty " + theme);
            return;
        }
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 3;
        File file = new File(N(), "download_" + System.currentTimeMillis() + ".png");
        G(url, file, new e(theme, uin, url, file, intRef));
    }

    private final File w(AppTheme theme, String uin, String path) {
        File file = new File(N(), theme + uin + "_" + System.nanoTime() + ".png");
        com.tencent.mobileqq.zplan.utils.l lVar = com.tencent.mobileqq.zplan.utils.l.f335829a;
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "destFile.absolutePath");
        boolean b16 = lVar.b(path, absolutePath);
        QLog.i("ZPlanAvatarImageManager", 1, "compressPNG ret=" + b16);
        return (b16 || FileUtils.copyFile(new File(path), file)) ? file : new File(path);
    }

    private final void x(String path) {
        FileUtils.createFileIfNotExits(path + "/.nomedia");
    }

    public final void H() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.avatar.image.f
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanAvatarImageManager.I(ZPlanAvatarImageManager.this);
            }
        }, 128, null, true);
    }

    public final String K(String theme) {
        Intrinsics.checkNotNullParameter(theme, "theme");
        String uin = MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentAccountUin();
        Intrinsics.checkNotNullExpressionValue(uin, "uin");
        return X(theme, uin);
    }

    public final String L(String theme, String uin) {
        Intrinsics.checkNotNullParameter(theme, "theme");
        Intrinsics.checkNotNullParameter(uin, "uin");
        return W(uin).getString("zplan_avatar_image_url" + theme, null);
    }

    public final float M(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return W(uin).getFloat("zplan_avatar_image_windowsillLocation", 0.0f);
    }

    public final URL O(int gender, String theme) {
        Intrinsics.checkNotNullParameter(theme, "theme");
        String P = P(gender, theme);
        if (P != null && Z(P)) {
            return new URL("file", (String) null, P);
        }
        try {
            return new URL(R(gender, theme));
        } catch (Exception e16) {
            QLog.e("ZPlanAvatarImageManager", 1, "getDefaultAvatar failed, getDefaultAvatarUrl invalid!", e16);
            return new URL("https://zplan.gtimg.cn/avatar/static/day-mode-female2.png");
        }
    }

    public final String S(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return W(uin).getString("zplan_super_qqshow_dynamic_avatar_appearance_key", null);
    }

    public final String T(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        String uin2 = MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentAccountUin();
        Intrinsics.checkNotNullExpressionValue(uin2, "uin");
        return W(uin2).getString("zplan_sp_super_qqshow_dynamic_avatar_property", null);
    }

    public final String U(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return W(uin).getString("zplan_sp_super_qqshow_dynamic_avatar_url", null);
    }

    public final String X(String theme, String uin) {
        Intrinsics.checkNotNullParameter(theme, "theme");
        Intrinsics.checkNotNullParameter(uin, "uin");
        String string = W(uin).getString("zplan_avatar_image_path" + theme, null);
        QLog.i("ZPlanAvatarImageManager", 1, "getAvatarImagePath == " + theme + " cachePath == " + string);
        if (Intrinsics.areEqual(string, "EMPTY_RESPONSE") || Z(string)) {
            return string;
        }
        return null;
    }

    public final String Y(String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        return ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getString(uin + "_zplan_sp_static_avatar_appearance_key", "");
    }

    public final void c0() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.avatar.image.c
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanAvatarImageManager.d0();
            }
        }, 128, null, true);
    }

    public final void f0(final String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.avatar.image.a
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanAvatarImageManager.g0(uin, this);
            }
        }, 128, null, true);
    }

    public final void k0(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        String currentAccountUin = peekAppRuntime.getCurrentAccountUin();
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setString(currentAccountUin + "_zplan_sp_static_avatar_appearance_key", key);
    }

    public final void m0(final String path, final String nightThemePath, final float windowsillLocation) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.avatar.image.g
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanAvatarImageManager.n0(path, this, nightThemePath, windowsillLocation);
            }
        }, 128, null, true);
    }

    public final void z(final Map<Integer, String> infoList, final String othersUin) {
        Intrinsics.checkNotNullParameter(infoList, "infoList");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zplan.avatar.image.i
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanAvatarImageManager.B(othersUin, this, infoList);
            }
        }, 128, null, true);
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/avatar/image/ZPlanAvatarImageManager$e", "Lcom/tencent/mobileqq/zplan/avatar/image/ZPlanAvatarImageManager$b;", "", "isSuccess", "", "onResult", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e implements b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f331785b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f331786c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f331787d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ File f331788e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f331789f;

        e(String str, String str2, String str3, File file, Ref.IntRef intRef) {
            this.f331785b = str;
            this.f331786c = str2;
            this.f331787d = str3;
            this.f331788e = file;
            this.f331789f = intRef;
        }

        @Override // com.tencent.mobileqq.zplan.avatar.image.ZPlanAvatarImageManager.b
        public void onResult(boolean isSuccess) {
            if (isSuccess) {
                ZPlanAvatarImageManager.this.r(this.f331785b, this.f331786c, this.f331787d, this.f331788e);
                return;
            }
            QLog.e("ZPlanAvatarImageManager", 1, "download image fail, " + this.f331787d);
            Ref.IntRef intRef = this.f331789f;
            int i3 = intRef.element;
            intRef.element = i3 + (-1);
            if (i3 > 0) {
                ZPlanAvatarImageManager.this.G(this.f331787d, this.f331788e, this);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zplan/avatar/image/ZPlanAvatarImageManager$f", "Lcom/tencent/mobileqq/zplan/avatar/image/ZPlanAvatarImageManager$b;", "", "isSuccess", "", "onResult", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class f implements b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ File f331791b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f331792c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f331793d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f331794e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f331795f;

        f(File file, int i3, String str, String str2, Ref.IntRef intRef) {
            this.f331791b = file;
            this.f331792c = i3;
            this.f331793d = str;
            this.f331794e = str2;
            this.f331795f = intRef;
        }

        @Override // com.tencent.mobileqq.zplan.avatar.image.ZPlanAvatarImageManager.b
        public void onResult(boolean isSuccess) {
            if (isSuccess) {
                ZPlanAvatarImageManager.this.t(this.f331791b, this.f331792c, this.f331793d);
                return;
            }
            QLog.e("ZPlanAvatarImageManager", 1, "download default image fail, " + this.f331794e);
            Ref.IntRef intRef = this.f331795f;
            int i3 = intRef.element;
            intRef.element = i3 + (-1);
            if (i3 > 0) {
                ZPlanAvatarImageManager.this.G(this.f331794e, this.f331791b, this);
            }
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\u000b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/zplan/avatar/image/ZPlanAvatarImageManager$g", "Lcom/tencent/mobileqq/transfile/INetEngineListener;", "Lcom/tencent/mobileqq/transfile/NetResp;", "resp", "", "onResp", "Lcom/tencent/mobileqq/transfile/NetReq;", "req", "", "curOffset", "totalLen", "onUpdateProgeress", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class g implements INetEngineListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ File f331796d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f331797e;

        g(File file, b bVar) {
            this.f331796d = file;
            this.f331797e = bVar;
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onResp(NetResp resp) {
            Integer valueOf = resp != null ? Integer.valueOf(resp.mResult) : null;
            QLog.i("ZPlanAvatarImageManager", 1, "downloadImage onResp " + valueOf + " path=" + this.f331796d.getAbsolutePath());
            if (resp != null && resp.mResult == 3) {
                return;
            }
            if ((resp != null && resp.mResult == 0) && this.f331796d.exists()) {
                this.f331797e.onResult(true);
            } else {
                this.f331796d.delete();
                this.f331797e.onResult(false);
            }
        }

        @Override // com.tencent.mobileqq.transfile.INetEngineListener
        public void onUpdateProgeress(NetReq req, long curOffset, long totalLen) {
        }
    }

    ZPlanAvatarImageManager() {
    }

    private final void p0(TransferRequest transferRequest, String str, String str2) {
        transferRequest.mIsUp = true;
        transferRequest.mLocalPath = str;
        transferRequest.mUniseq = System.currentTimeMillis();
        transferRequest.mFileType = 69;
        Bdh_extinfo.CommFileExtReq commFileExtReq = new Bdh_extinfo.CommFileExtReq();
        commFileExtReq.uint32_action_type.set(0);
        commFileExtReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(str2 + System.currentTimeMillis() + ".png"));
        transferRequest.mExtentionInfo = commFileExtReq.toByteArray();
    }

    private final void y(Map<Integer, String> infoList) {
        String str = infoList.get(4);
        if (str == null) {
            str = "";
        }
        String str2 = infoList.get(9);
        if (str2 == null) {
            str2 = "";
        }
        String str3 = infoList.get(5);
        String str4 = str3 != null ? str3 : "";
        String uin = MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentAccountUin();
        Intrinsics.checkNotNullExpressionValue(uin, "uin");
        W(uin).edit().putString("zplan_sp_super_qqshow_dynamic_avatar_url", str).putString("zplan_sp_super_qqshow_dynamic_avatar_property", str2).putString("zplan_super_qqshow_dynamic_avatar_appearance_key", str4).apply();
    }

    private final void C(Map<Integer, String> infoList) {
        if (infoList.containsKey(16)) {
            String str = infoList.get(16);
            if (str == null) {
                str = "";
            }
            k0(str);
            QLog.i("ZPlanAvatarImageManager", 1, "updated keyInSp: " + str);
            return;
        }
        QLog.e("ZPlanAvatarImageManager", 1, "requestBannerStaticImgInfo failed, callback invalid!");
    }

    private final String P(int gender, String theme) {
        String str;
        String d16;
        if (gender == 1) {
            str = LightConstants.MALE;
        } else {
            str = LightConstants.FEMALE;
        }
        String n3 = bb.f335811a.n(str, theme);
        if (n3 == null || n3.length() == 0) {
            d16 = "";
        } else {
            d16 = com.tencent.open.base.g.d(n3);
        }
        QLog.i("ZPlanAvatarImageManager", 1, "getDefaultAvatarPath2, gender: " + gender + ", theme: " + theme + ", defaultURL: " + n3 + ", md5:" + d16);
        if (gender == 1) {
            return Q("zplan_avatar_default_male_path" + d16, theme);
        }
        return Q("zplan_avatar_default_female_path" + d16, theme);
    }

    private final String R(int gender, String theme) {
        String str;
        String str2;
        if (gender == 1) {
            str = LightConstants.MALE;
        } else {
            str = LightConstants.FEMALE;
        }
        if (Intrinsics.areEqual(theme, String.valueOf(AppTheme.DAY))) {
            str2 = MiniAppConst.MENU_STYLE_LIGHT;
        } else {
            str2 = MiniAppConst.MENU_STYLE_DARK;
        }
        return bb.f335811a.m(str, str2);
    }

    private final boolean Z(String path) {
        return !(path == null || path.length() == 0) && new File(path).exists();
    }

    public static /* synthetic */ void A(ZPlanAvatarImageManager zPlanAvatarImageManager, Map map, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = null;
        }
        zPlanAvatarImageManager.z(map, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0(final String uin, final String dayImgUrl, final String nightImgUrl) {
        List mutableListOf;
        com.tencent.mobileqq.zplan.model.b bVar = new com.tencent.mobileqq.zplan.model.b(ProfileContants.FIELD_ZPLAN_COVER_IMG, 1, dayImgUrl);
        com.tencent.mobileqq.zplan.model.b bVar2 = new com.tencent.mobileqq.zplan.model.b(3, 1, nightImgUrl);
        com.tencent.mobileqq.zplan.model.b bVar3 = new com.tencent.mobileqq.zplan.model.b(16, 1, ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).getUserZPlanInfo(uin).appearanceKey);
        QRouteApi api = QRoute.api(IZPlanRequest.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanRequest::class.java)");
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(bVar, bVar2, bVar3);
        IZPlanRequest.a.a((IZPlanRequest) api, mutableListOf, 3, new nk3.a() { // from class: com.tencent.mobileqq.zplan.avatar.image.j
            @Override // nk3.a
            public final void onResult(boolean z16) {
                ZPlanAvatarImageManager.j0(ZPlanAvatarImageManager.this, uin, dayImgUrl, nightImgUrl, z16);
            }
        }, 0L, 8, null);
        QLog.i("ZPlanAvatarImageManager", 1, "setUrlToZplanServer upload img url dayImgUrl == " + dayImgUrl + "  nightImgUrl == " + nightImgUrl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(Map map) {
    }
}
