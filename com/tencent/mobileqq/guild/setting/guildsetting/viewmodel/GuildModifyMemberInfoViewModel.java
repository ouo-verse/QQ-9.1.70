package com.tencent.mobileqq.guild.setting.guildsetting.viewmodel;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.common.app.AppInterface;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.common.upload.GuildCgiUploader;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi;
import com.tencent.mobileqq.guild.nt.album.api.IPhotoPickAndEditApi;
import com.tencent.mobileqq.guild.nt.misc.api.ISnapshotApi;
import com.tencent.mobileqq.guild.nt.misc.api.IUploadApi;
import com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.GuildModifyMemberInfoViewModel;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.br;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proavatar.api.IProAvatarUtilsApi;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.util.URLUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QzoneIPCModule;
import ef1.c;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 Z2\u00020\u0001:\u0002[\\B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u00a2\u0006\u0004\bX\u0010YJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0014J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u001e\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002J&\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eJ(\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\u001a\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001e\u001a\u00020\u0014H\u0002J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J>\u0010'\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u00022$\b\u0002\u0010&\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020$0#j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020$`%H\u0002J0\u0010)\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u00022\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eH\u0002J\u0018\u0010*\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u0002H\u0002J \u0010,\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u0002H\u0002J\u0010\u0010-\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010.\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u00101\u001a\u0002002\b\u0010/\u001a\u0004\u0018\u00010\u0002H\u0002J\n\u00102\u001a\u0004\u0018\u00010\u0002H\u0002J \u00107\u001a\u0002062\u0006\u00103\u001a\u00020\u00142\u0006\u00104\u001a\u00020\u00142\u0006\u00105\u001a\u00020\u0014H\u0002R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010;\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00109R\u001b\u0010@\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u001a\u0010I\u001a\b\u0012\u0004\u0012\u00020F0E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010HR\u0014\u0010M\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bL\u0010LR\u0014\u0010O\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010LR\u0014\u0010Q\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010LR\u0017\u0010U\u001a\b\u0012\u0004\u0012\u00020F0R8F\u00a2\u0006\u0006\u001a\u0004\bS\u0010TR\u0017\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00020R8F\u00a2\u0006\u0006\u001a\u0004\bV\u0010T\u00a8\u0006]"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildsetting/viewmodel/GuildModifyMemberInfoViewModel;", "Lef1/b;", "", "account", "", "onAccountChanged", "onCleared", "y2", "x2", "Landroid/content/Context;", "context", "guildId", "guildNickname", "r2", "Lkotlin/Function1;", "", "callback", "w2", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", ICustomDataEditor.NUMBER_PARAM_2, "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "viewId", "d2", "X1", "view", "event", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "extraParam", "b2", "pSKey", "q2", "Z1", "baseUrl", "f2", "p2", "o2", "url", "Landroid/graphics/drawable/Drawable;", "j2", "l2", "width", "height", "roundPx", "Lcom/tencent/image/DownloadParams$DecodeHandler;", "g2", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "D", "nickName", "E", "Lkotlin/Lazy;", "i2", "()Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "gProObserver", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gProService", "Le12/a;", "Lcom/tencent/mobileqq/guild/setting/guildsetting/viewmodel/GuildModifyMemberInfoViewModel$b;", "G", "Le12/a;", "_modifyPath", "H", "_userName", "I", "ACTIONSHEET_ALBUM_VIEW_ID", "J", "ACTIONSHEET_CAMERA_VIEW_ID", "K", "ACTIONSHEET_GLOBAL_AVATAR_VIEW_ID", "Landroidx/lifecycle/LiveData;", "k2", "()Landroidx/lifecycle/LiveData;", "modifyPath", "m2", "userName", "<init>", "(Ljava/lang/String;)V", "L", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildModifyMemberInfoViewModel extends ef1.b {

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static Uri M;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String nickName;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Lazy gProObserver;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private IGPSService gProService;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final e12.a<ModifyAvatarState> _modifyPath;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final e12.a<String> _userName;

    /* renamed from: I, reason: from kotlin metadata */
    private final int ACTIONSHEET_ALBUM_VIEW_ID;

    /* renamed from: J, reason: from kotlin metadata */
    private final int ACTIONSHEET_CAMERA_VIEW_ID;

    /* renamed from: K, reason: from kotlin metadata */
    private final int ACTIONSHEET_GLOBAL_AVATAR_VIEW_ID;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildsetting/viewmodel/GuildModifyMemberInfoViewModel$a;", "", "Landroidx/lifecycle/ViewModelStoreOwner;", "owner", "", "guildId", "Lcom/tencent/mobileqq/guild/setting/guildsetting/viewmodel/GuildModifyMemberInfoViewModel;", "a", "", "REQUEST_CODE_SNAPSHOT", "I", "TAG", "Ljava/lang/String;", "Landroid/net/Uri;", "mSnapshotFileUri", "Landroid/net/Uri;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.GuildModifyMemberInfoViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.GuildModifyMemberInfoViewModel$a$a, reason: collision with other inner class name */
        /* loaded from: classes14.dex */
        public static final class C7900a implements ViewModelProvider.Factory {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ViewModelStoreOwner f234509a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f234510b;

            public C7900a(ViewModelStoreOwner viewModelStoreOwner, String str) {
                this.f234509a = viewModelStoreOwner;
                this.f234510b = str;
            }

            @Override // androidx.lifecycle.ViewModelProvider.Factory
            @NotNull
            public <T extends ViewModel> T create(@NotNull Class<T> p06) {
                Intrinsics.checkNotNullParameter(p06, "p0");
                TimedValue timedValue = new TimedValue(new GuildModifyMemberInfoViewModel(this.f234510b), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("GuildViewModelProvider", 2, "create " + com.tencent.mobileqq.guild.base.extension.m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
                }
                return (T) timedValue.getValue();
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final GuildModifyMemberInfoViewModel a(@NotNull ViewModelStoreOwner owner, @NotNull String guildId) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            c.Companion companion = ef1.c.INSTANCE;
            ViewModel viewModel = new ViewModelProvider(owner, new C7900a(owner, guildId)).get(GuildModifyMemberInfoViewModel.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
            return (GuildModifyMemberInfoViewModel) viewModel;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildsetting/viewmodel/GuildModifyMemberInfoViewModel$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "()Z", "clearAvatar", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "localPath", "<init>", "(ZLjava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.GuildModifyMemberInfoViewModel$b, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class ModifyAvatarState {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean clearAvatar;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String localPath;

        public ModifyAvatarState() {
            this(false, null, 3, 0 == true ? 1 : 0);
        }

        /* renamed from: a, reason: from getter */
        public final boolean getClearAvatar() {
            return this.clearAvatar;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getLocalPath() {
            return this.localPath;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ModifyAvatarState)) {
                return false;
            }
            ModifyAvatarState modifyAvatarState = (ModifyAvatarState) other;
            if (this.clearAvatar == modifyAvatarState.clearAvatar && Intrinsics.areEqual(this.localPath, modifyAvatarState.localPath)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z16 = this.clearAvatar;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            return (r06 * 31) + this.localPath.hashCode();
        }

        @NotNull
        public String toString() {
            return "ModifyAvatarState(clearAvatar=" + this.clearAvatar + ", localPath=" + this.localPath + ")";
        }

        public ModifyAvatarState(boolean z16, @NotNull String localPath) {
            Intrinsics.checkNotNullParameter(localPath, "localPath");
            this.clearAvatar = z16;
            this.localPath = localPath;
        }

        public /* synthetic */ ModifyAvatarState(boolean z16, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? false : z16, (i3 & 2) != 0 ? "" : str);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/setting/guildsetting/viewmodel/GuildModifyMemberInfoViewModel$c", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "tinyId", "", "onUserDisplayNameUpdate", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends GPServiceObserver {
        c() {
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onUserDisplayNameUpdate(@Nullable String tinyId) {
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("GuildModifyMemberInfoViewModel", "onUserDisplayNameUpdate: tinyId " + tinyId);
            }
            if (Intrinsics.areEqual(GuildModifyMemberInfoViewModel.this.gProService.getSelfTinyId(), tinyId)) {
                GuildModifyMemberInfoViewModel.this.y2();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/setting/guildsetting/viewmodel/GuildModifyMemberInfoViewModel$d", "Lokhttp3/Callback;", "Lokhttp3/Call;", "call", "Ljava/io/IOException;", "e", "", "onFailure", "Lokhttp3/Response;", "response", "onResponse", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f234514a;

        /* JADX WARN: Multi-variable type inference failed */
        d(Function1<? super Boolean, Unit> function1) {
            this.f234514a = function1;
        }

        @Override // okhttp3.Callback
        public void onFailure(@NotNull Call call, @NotNull IOException e16) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(e16, "e");
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "[onFailure] e " + e16;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildModifyMemberInfoViewModel", 1, (String) it.next(), null);
            }
            Function1<Boolean, Unit> function1 = this.f234514a;
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(@NotNull Call call, @NotNull Response response) {
            Intrinsics.checkNotNullParameter(call, "call");
            Intrinsics.checkNotNullParameter(response, "response");
            Logger.f235387a.d().d("GuildModifyMemberInfoViewModel", 1, "[onResponse] response code " + response.code() + " msg: " + response.message());
            if (response.isSuccessful()) {
                Function1<Boolean, Unit> function1 = this.f234514a;
                if (function1 != null) {
                    function1.invoke(Boolean.TRUE);
                    return;
                }
                return;
            }
            Function1<Boolean, Unit> function12 = this.f234514a;
            if (function12 != null) {
                function12.invoke(Boolean.FALSE);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/setting/guildsetting/viewmodel/GuildModifyMemberInfoViewModel$e", "Lsd2/a;", "", "", "domainToKeyMap", "", "onSuccess", "errMsg", "onFail", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e implements sd2.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f234516b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f234517c;

        /* JADX WARN: Multi-variable type inference failed */
        e(String str, Function1<? super Boolean, Unit> function1) {
            this.f234516b = str;
            this.f234517c = function1;
        }

        @Override // sd2.a
        public void onFail(@NotNull String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            Logger.f235387a.d().d("GuildModifyMemberInfoViewModel", 1, "[onFail] getPskey error " + errMsg);
            Function1<Boolean, Unit> function1 = this.f234517c;
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
            }
        }

        @Override // sd2.a
        public void onSuccess(@NotNull Map<String, String> domainToKeyMap) {
            boolean z16;
            Intrinsics.checkNotNullParameter(domainToKeyMap, "domainToKeyMap");
            String str = domainToKeyMap.get(com.tencent.mobileqq.guild.common.upload.c.clearGuildUserAvatar.getHost());
            if (str == null) {
                str = "";
            }
            Logger.a d16 = Logger.f235387a.d();
            boolean z17 = false;
            if (str.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            d16.d("GuildModifyMemberInfoViewModel", 1, "[onSuccess] pskey " + z16);
            if (str.length() > 0) {
                z17 = true;
            }
            if (z17) {
                GuildModifyMemberInfoViewModel.this.q2(this.f234516b, str, this.f234517c);
                return;
            }
            Logger.b bVar = new Logger.b();
            bVar.a().add("[onSuccess] getPskey error pSKey is empty!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildModifyMemberInfoViewModel", 1, (String) it.next(), null);
            }
            Function1<Boolean, Unit> function1 = this.f234517c;
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
            }
        }
    }

    public GuildModifyMemberInfoViewModel(@NotNull String guildId) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.guildId = guildId;
        this.nickName = "";
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GPServiceObserver>() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.GuildModifyMemberInfoViewModel$gProObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GPServiceObserver invoke() {
                GPServiceObserver a26;
                a26 = GuildModifyMemberInfoViewModel.this.a2();
                return a26;
            }
        });
        this.gProObserver = lazy;
        IRuntimeService R0 = ch.R0(IGPSService.class);
        Intrinsics.checkNotNullExpressionValue(R0, "runtimeService(IGPSService::class.java)");
        this.gProService = (IGPSService) R0;
        this._modifyPath = new e12.a<>();
        this._userName = new e12.a<>();
        this.ACTIONSHEET_ALBUM_VIEW_ID = ViewCompat.generateViewId();
        this.ACTIONSHEET_CAMERA_VIEW_ID = ViewCompat.generateViewId();
        this.ACTIONSHEET_GLOBAL_AVATAR_VIEW_ID = ViewCompat.generateViewId();
        this.gProService.addObserver(i2());
    }

    private final void X1(View rootView) {
        Map mapOf;
        VideoReport.setPageId(rootView, "pg_sgrp_channel_nick_profile");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("sgrp_channel_id", this.guildId), TuplesKt.to("sgrp_user_type", ((IGuildFeedMiscApi) QRoute.api(IGuildFeedMiscApi.class)).getCurrentUserType(this.guildId)));
        VideoReport.setPageParams(rootView, new PageParams((Map<String, ?>) mapOf));
    }

    private final String Z1(String guildId, String pSKey) {
        String str;
        if (pSKey.length() >= 10) {
            str = pSKey.substring(0, 10);
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        } else {
            str = pSKey;
        }
        List<IUploadApi.a> c16 = new GuildCgiUploader(ch.g(), guildId).c(str, pSKey);
        StringBuilder sb5 = new StringBuilder();
        for (IUploadApi.a aVar : c16) {
            String encodeUrl = URLUtil.encodeUrl(aVar.f230929a);
            String encodeUrl2 = URLUtil.encodeUrl(aVar.f230930b);
            sb5.append(" " + encodeUrl + ContainerUtils.KEY_VALUE_DELIMITER);
            StringBuilder sb6 = new StringBuilder();
            sb6.append(encodeUrl2);
            sb6.append(";");
            sb5.append(sb6.toString());
        }
        String sb7 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb7, "sb.toString()");
        return sb7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GPServiceObserver a2() {
        return new c();
    }

    private final void b2(View view, String event, HashMap<String, Object> extraParam) {
        HashMap hashMapOf;
        Pair[] pairArr = new Pair[2];
        pairArr[0] = TuplesKt.to("sgrp_channel_id", this.guildId);
        String currentUserType = ((IGuildFeedMiscApi) QRoute.api(IGuildFeedMiscApi.class)).getCurrentUserType(this.guildId);
        if (currentUserType == null) {
            currentUserType = "3";
        }
        pairArr[1] = TuplesKt.to("sgrp_user_type", currentUserType);
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        hashMapOf.putAll(extraParam);
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).reportDtEventManual(view, "em_sgrp_change_float", event, hashMapOf);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void c2(GuildModifyMemberInfoViewModel guildModifyMemberInfoViewModel, View view, String str, HashMap hashMap, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            hashMap = new HashMap();
        }
        guildModifyMemberInfoViewModel.b2(view, str, hashMap);
    }

    private final void d2(View rootView, int viewId) {
        int i3;
        HashMap<String, Object> hashMapOf;
        if (viewId == this.ACTIONSHEET_ALBUM_VIEW_ID) {
            i3 = 1;
        } else if (viewId == this.ACTIONSHEET_CAMERA_VIEW_ID) {
            i3 = 2;
        } else if (viewId == this.ACTIONSHEET_GLOBAL_AVATAR_VIEW_ID) {
            i3 = 3;
        } else {
            i3 = 4;
        }
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("sgrp_btn_type", String.valueOf(i3)));
        b2(rootView, "clck", hashMapOf);
    }

    static /* synthetic */ void e2(GuildModifyMemberInfoViewModel guildModifyMemberInfoViewModel, View view, int i3, int i16, Object obj) {
        if ((i16 & 2) != 0) {
            i3 = -1;
        }
        guildModifyMemberInfoViewModel.d2(view, i3);
    }

    private final String f2(String baseUrl, String guildId, String pSKey) {
        HashMap<String, String> a16 = com.tencent.mobileqq.guild.common.upload.b.a();
        if (pSKey.length() >= 10) {
            pSKey = pSKey.substring(0, 10);
            Intrinsics.checkNotNullExpressionValue(pSKey, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        }
        Map<String, String> queryParam = new GuildCgiUploader(ch.g(), guildId).d(guildId, pSKey);
        Intrinsics.checkNotNullExpressionValue(queryParam, "queryParam");
        queryParam.put("clearMemberProfile", "1");
        queryParam.put("useBasicAvatar", "1");
        HashMap hashMap = new HashMap();
        hashMap.putAll(a16);
        hashMap.putAll(queryParam);
        for (Map.Entry entry : hashMap.entrySet()) {
            baseUrl = URLUtil.addParameter(baseUrl, (String) entry.getKey(), (String) entry.getValue());
            Intrinsics.checkNotNullExpressionValue(baseUrl, "addParameter(url, it.key, it.value)");
        }
        return baseUrl;
    }

    private final DownloadParams.DecodeHandler g2(final int width, final int height, final int roundPx) {
        return new DownloadParams.DecodeHandler() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.e
            @Override // com.tencent.image.DownloadParams.DecodeHandler
            public final Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
                Bitmap h26;
                h26 = GuildModifyMemberInfoViewModel.h2(roundPx, width, height, downloadParams, bitmap);
                return h26;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap h2(int i3, int i16, int i17, DownloadParams downloadParams, Bitmap bitmap) {
        if (bitmap != null) {
            return BaseImageUtil.getRoundedCornerBitmap(bitmap, i3, i16, i17);
        }
        return bitmap;
    }

    private final GPServiceObserver i2() {
        return (GPServiceObserver) this.gProObserver.getValue();
    }

    private final Drawable j2(String url) {
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mFailedDrawable = BaseImageUtil.getDefaultFaceDrawable();
        obtain.mLoadingDrawable = BaseImageUtil.getDefaultFaceDrawable();
        obtain.mUseAutoScaleParams = false;
        int dpToPx = ViewUtils.dpToPx(20.0f);
        int dpToPx2 = ViewUtils.dpToPx(2.0f);
        URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
        drawable.setBounds(0, 0, dpToPx, dpToPx);
        drawable.setDecodeHandler(g2(dpToPx, dpToPx, dpToPx2));
        Intrinsics.checkNotNullExpressionValue(drawable, "getDrawable(url, options\u2026e, cornerSize))\n        }");
        return drawable;
    }

    private final String l2() {
        String str;
        String str2;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("GuildModifyMemberInfoViewModel", 2, "loadAvatar params error  appInterface == null");
        }
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentUin();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        boolean z16 = true;
        String a16 = com.tencent.mobileqq.proavatar.utils.d.f259720a.a(((IProAvatarUtilsApi) QRoute.api(IProAvatarUtilsApi.class)).getAvatarInfo(1, str), 100);
        if (a16 != null && a16.length() != 0) {
            z16 = false;
        }
        if (z16) {
            if (a16 == null) {
                str2 = "null";
            } else {
                str2 = GlobalUtil.DEF_STRING;
            }
            QLog.e("GuildModifyMemberInfoViewModel", 2, "ProAvatarInfoUtils.getDownloadUrl returns " + str2);
        }
        return a16;
    }

    private final void o2(Context context) {
        if (!(context instanceof QBaseActivity)) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("[openAlbum] context is not QBaseActivity");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildModifyMemberInfoViewModel", 1, (String) it.next(), null);
            }
            return;
        }
        ((IPhotoPickAndEditApi) QRoute.api(IPhotoPickAndEditApi.class)).startPhotoPickForResult((Activity) context, new Intent(), 107, 272);
    }

    private final void p2(final Context context) {
        List<String> listOf;
        QRouteApi api = QRoute.api(ISnapshotApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ISnapshotApi::class.java)");
        final ISnapshotApi iSnapshotApi = (ISnapshotApi) api;
        if (iSnapshotApi.isOnVideoCalling()) {
            QQToast.makeText(context, 0, R.string.f142640jx, 0).show();
            return;
        }
        if (context instanceof QBaseActivity) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(QQPermissionConstants.Permission.CAMERA);
            br.a(br.PermissionParam.INSTANCE.a((Activity) context, QQPermissionConstants.Business.ID.QQ_CHANNEL_MAINFRAME, QQPermissionConstants.Business.SCENE.QQCHANEL_AVATAR_EDIT_CAMERA, listOf), new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.GuildModifyMemberInfoViewModel$openCamera$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    GuildModifyMemberInfoViewModel.Companion companion = GuildModifyMemberInfoViewModel.INSTANCE;
                    GuildModifyMemberInfoViewModel.M = ISnapshotApi.this.enterSnapshot((Activity) context, 273);
                }
            }, null);
            return;
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        bVar.a().add("[openCamera] context is not QBaseActivity");
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("GuildModifyMemberInfoViewModel", 1, (String) it.next(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q2(String guildId, String pSKey, Function1<? super Boolean, Unit> callback) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        OkHttpClient build = builder.connectTimeout(15000L, timeUnit).readTimeout(15000L, timeUnit).writeTimeout(15000L, timeUnit).build();
        String f26 = f2(com.tencent.mobileqq.guild.common.upload.c.clearGuildUserAvatar.getUrl(), guildId, pSKey);
        Logger.f235387a.d().d("GuildModifyMemberInfoViewModel", 1, "[sendClearGuildAvatarRequest] finalUrl " + f26);
        build.newCall(new Request.Builder().url(f26).addHeader("Cookie", Z1(guildId, pSKey)).get().build()).enqueue(new d(callback));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s2(GuildModifyMemberInfoViewModel this$0, ActionSheet sheet, Context context, String str, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(sheet, "$sheet");
        Intrinsics.checkNotNullParameter(context, "$context");
        LinearLayout linearLayout = sheet.mContentContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "sheet.mContentContainer");
        this$0.d2(linearLayout, i3);
        if (i3 == this$0.ACTIONSHEET_ALBUM_VIEW_ID) {
            this$0.o2(context);
        } else if (i3 == this$0.ACTIONSHEET_CAMERA_VIEW_ID) {
            this$0.p2(context);
        } else if (i3 == this$0.ACTIONSHEET_GLOBAL_AVATAR_VIEW_ID) {
            e12.a<ModifyAvatarState> aVar = this$0._modifyPath;
            if (str == null) {
                str = "";
            }
            aVar.setValue(new ModifyAvatarState(true, str));
        }
        sheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t2(GuildModifyMemberInfoViewModel this$0, ActionSheet sheet, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(sheet, "$sheet");
        LinearLayout linearLayout = sheet.mContentContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "sheet.mContentContainer");
        e2(this$0, linearLayout, 0, 2, null);
        sheet.dismiss();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u2(GuildModifyMemberInfoViewModel this$0, ActionSheet sheet) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(sheet, "$sheet");
        LinearLayout linearLayout = sheet.mContentContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "sheet.mContentContainer");
        c2(this$0, linearLayout, "imp_end", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v2(ActionSheet sheet, GuildModifyMemberInfoViewModel this$0) {
        ImageView imageView;
        Intrinsics.checkNotNullParameter(sheet, "$sheet");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewGroup viewGroup = (ViewGroup) sheet.mContentContainer.findViewById(this$0.ACTIONSHEET_GLOBAL_AVATAR_VIEW_ID);
        if (viewGroup != null) {
            imageView = (ImageView) viewGroup.findViewById(R.id.f163939d2);
        } else {
            imageView = null;
        }
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.rightMargin = ViewUtils.dpToPx(1.0f);
            imageView.setLayoutParams(marginLayoutParams);
            ViewParent parent = imageView.getParent();
            if (parent != null) {
                parent.requestLayout();
            }
        }
    }

    @NotNull
    public final LiveData<ModifyAvatarState> k2() {
        return this._modifyPath;
    }

    @NotNull
    public final LiveData<String> m2() {
        return this._userName;
    }

    public final void n2(@NotNull Activity activity, int requestCode, int resultCode, @Nullable Intent data) {
        Uri uri;
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (resultCode == -1) {
            if (requestCode == 273 && (uri = M) != null) {
                M = null;
                ((IPhotoPickAndEditApi) QRoute.api(IPhotoPickAndEditApi.class)).startPhotoEditForResult(activity, new Intent(), BaseImageUtil.getRealPathFromContentURI(activity, uri), 107, 257);
                return;
            }
            if (requestCode == 257 && data != null) {
                if (data.getBooleanExtra(PeakConstants.PHOTO_CROP_CANCEL, false)) {
                    data.removeExtra(PeakConstants.PHOTO_CROP_CANCEL);
                    activity.startActivityForResult(data, 272);
                    return;
                }
                e12.a<ModifyAvatarState> aVar = this._modifyPath;
                String stringExtra = data.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
                if (stringExtra == null) {
                    stringExtra = "";
                }
                aVar.setValue(new ModifyAvatarState(false, stringExtra));
                return;
            }
            if (requestCode == 272 && data != null) {
                activity.startActivityForResult(data, 257);
            }
        }
    }

    @Override // ef1.b, com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        super.onAccountChanged(account);
        Logger.f235387a.d().d("GuildModifyMemberInfoViewModel", 1, "[onAccountChanged] ");
        this.gProService.deleteObserver(i2());
        IRuntimeService R0 = ch.R0(IGPSService.class);
        Intrinsics.checkNotNullExpressionValue(R0, "runtimeService(IGPSService::class.java)");
        IGPSService iGPSService = (IGPSService) R0;
        this.gProService = iGPSService;
        iGPSService.addObserver(i2());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ef1.b, androidx.lifecycle.ViewModel
    public void onCleared() {
        Logger.f235387a.d().d("GuildModifyMemberInfoViewModel", 1, "[onCleared] ");
        super.onCleared();
        this.gProService.deleteObserver(i2());
    }

    public final void r2(@NotNull final Context context, @NotNull String guildId, @NotNull String guildNickname) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(guildNickname, "guildNickname");
        this.nickName = guildNickname;
        final String l26 = l2();
        Dialog createDialog = ActionSheetHelper.createDialog(context, null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        actionSheet.addButton("\u4ece\u76f8\u518c\u4e2d\u9009\u62e9", 0, this.ACTIONSHEET_ALBUM_VIEW_ID);
        actionSheet.addButton("\u62cd\u7167", 0, this.ACTIONSHEET_CAMERA_VIEW_ID);
        actionSheet.addButtonWithLeftIcon("\u4f7f\u7528QQ\u5934\u50cf", j2(l26), 0, "", this.ACTIONSHEET_GLOBAL_AVATAR_VIEW_ID);
        actionSheet.addCancelButton("\u53d6\u6d88");
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.a
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                GuildModifyMemberInfoViewModel.s2(GuildModifyMemberInfoViewModel.this, actionSheet, context, l26, view, i3);
            }
        });
        actionSheet.setOnBottomCancelListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildModifyMemberInfoViewModel.t2(GuildModifyMemberInfoViewModel.this, actionSheet, view);
            }
        });
        actionSheet.setOnDismissListener(new ActionSheet.OnDismissListener() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.c
            @Override // com.tencent.widget.ActionSheet.OnDismissListener
            public final void onDismiss() {
                GuildModifyMemberInfoViewModel.u2(GuildModifyMemberInfoViewModel.this, actionSheet);
            }
        });
        actionSheet.setOnPreShowListener(new ActionSheet.onPreShowListener() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.d
            @Override // com.tencent.widget.ActionSheet.onPreShowListener
            public final void onPreShow() {
                GuildModifyMemberInfoViewModel.v2(ActionSheet.this, this);
            }
        });
        actionSheet.show();
        ViewGroup rootView = actionSheet.getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "sheet.rootView");
        X1(rootView);
        LinearLayout linearLayout = actionSheet.mContentContainer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "sheet.mContentContainer");
        c2(this, linearLayout, "imp", null, 4, null);
    }

    public final void w2(@NotNull String guildId, @Nullable Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        IRuntimeService runtimeService = ((AppInterface) peekAppRuntime).getRuntimeService(IPskeyManager.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IP\u2026va, ProcessConstant.MAIN)");
        ((IPskeyManager) runtimeService).getPskey(new String[]{com.tencent.mobileqq.guild.common.upload.c.clearGuildUserAvatar.getHost()}, new e(guildId, callback));
    }

    public final void x2() {
        IGPSService iGPSService = (IGPSService) ch.S0(IGPSService.class, "");
        iGPSService.refreshPollingData(this.guildId, 7);
        iGPSService.refreshGuildUserProfileInfo(this.guildId, ch.f());
        QLog.w("GuildModifyMemberInfoViewModel", 1, "updateAvatarData: result=" + ch.f());
    }

    public final void y2() {
        boolean z16;
        String value = this._userName.getValue();
        boolean z17 = false;
        if (value != null && value.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            return;
        }
        String guildUserDisplayNameInternal = this.gProService.getGuildUserDisplayNameInternal(this.guildId, this.gProService.getSelfTinyId());
        Intrinsics.checkNotNullExpressionValue(guildUserDisplayNameInternal, "gProService.getGuildUser\u2026rnal(guildId, selfTinyId)");
        Logger.f235387a.d().d("GuildModifyMemberInfoViewModel", 1, "[updateGuildUserDisplayName] displayName " + guildUserDisplayNameInternal);
        if (guildUserDisplayNameInternal.length() > 0) {
            z17 = true;
        }
        if (z17) {
            this._userName.setValue(guildUserDisplayNameInternal);
        }
    }
}
