package com.tencent.mobileqq.guild.media.thirdapp.container;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.base.api.data.BaseParam;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.guild.media.thirdapp.container.miniapp.GuildStandAloneMiniAppFragment;
import com.tencent.mobileqq.guild.media.thirdapp.container.plugin.GuildOpenStandAloneMiniAppPlugin;
import com.tencent.mobileqq.guild.media.thirdapp.container.webview.GuildMainProcessWebViewFragment;
import com.tencent.mobileqq.guild.media.widget.theme.PlayTogetherMiniAppPlugin;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.api.IMiniContainer;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0003\u0015\u0004\u0016B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u001a\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\fH\u0002J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/GuildOpenContainerLauncher;", "", "", "originalUrl", "a", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/GuildOpenContainerLauncher$StartParams;", "startParams", "Lcom/tencent/mobileqq/app/QBaseFragment;", "d", "Landroidx/fragment/app/Fragment;", "e", "url", "Landroid/os/Bundle;", "extra", "Landroid/content/Intent;", "f", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/GuildOpenContainerLauncher$ContainerType;", "type", "b", "<init>", "()V", "ContainerType", "StartParams", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildOpenContainerLauncher {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildOpenContainerLauncher f229226a = new GuildOpenContainerLauncher();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/GuildOpenContainerLauncher$ContainerType;", "", "(Ljava/lang/String;I)V", "H5", "MINI_APP", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public enum ContainerType {
        H5,
        MINI_APP
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\t\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0013\u0010\f\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/GuildOpenContainerLauncher$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "d", "()Z", "useDefaultLoadingView", "", "b", UserInfo.SEX_FEMALE, "()F", "heightRatio", "c", "heightByDp", "openNewPageInSameContainer", "<init>", "(ZFFZ)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.thirdapp.container.GuildOpenContainerLauncher$a, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class MiniAppConfig {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean useDefaultLoadingView;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final float heightRatio;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final float heightByDp;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean openNewPageInSameContainer;

        public MiniAppConfig() {
            this(false, 0.0f, 0.0f, false, 15, null);
        }

        /* renamed from: a, reason: from getter */
        public final float getHeightByDp() {
            return this.heightByDp;
        }

        /* renamed from: b, reason: from getter */
        public final float getHeightRatio() {
            return this.heightRatio;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getOpenNewPageInSameContainer() {
            return this.openNewPageInSameContainer;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getUseDefaultLoadingView() {
            return this.useDefaultLoadingView;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MiniAppConfig)) {
                return false;
            }
            MiniAppConfig miniAppConfig = (MiniAppConfig) other;
            if (this.useDefaultLoadingView == miniAppConfig.useDefaultLoadingView && Float.compare(this.heightRatio, miniAppConfig.heightRatio) == 0 && Float.compare(this.heightByDp, miniAppConfig.heightByDp) == 0 && this.openNewPageInSameContainer == miniAppConfig.openNewPageInSameContainer) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r0v9 */
        public int hashCode() {
            boolean z16 = this.useDefaultLoadingView;
            int i3 = 1;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int floatToIntBits = ((((r06 * 31) + Float.floatToIntBits(this.heightRatio)) * 31) + Float.floatToIntBits(this.heightByDp)) * 31;
            boolean z17 = this.openNewPageInSameContainer;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            return floatToIntBits + i3;
        }

        @NotNull
        public String toString() {
            return "MiniAppConfig(useDefaultLoadingView=" + this.useDefaultLoadingView + ", heightRatio=" + this.heightRatio + ", heightByDp=" + this.heightByDp + ", openNewPageInSameContainer=" + this.openNewPageInSameContainer + ")";
        }

        public MiniAppConfig(boolean z16, float f16, float f17, boolean z17) {
            this.useDefaultLoadingView = z16;
            this.heightRatio = f16;
            this.heightByDp = f17;
            this.openNewPageInSameContainer = z17;
        }

        public /* synthetic */ MiniAppConfig(boolean z16, float f16, float f17, boolean z17, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? true : z16, (i3 & 2) != 0 ? 0.85714287f : f16, (i3 & 4) != 0 ? 0.0f : f17, (i3 & 8) != 0 ? true : z17);
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f229237a;

        static {
            int[] iArr = new int[ContainerType.values().length];
            try {
                iArr[ContainerType.H5.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ContainerType.MINI_APP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f229237a = iArr;
        }
    }

    GuildOpenContainerLauncher() {
    }

    private final String a(String originalUrl) {
        String url = URLUtil.addParameter(URLUtil.addParameter(originalUrl, "_wv", String.valueOf(4097L)), "_wwv", String.valueOf(8969L));
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildOpenMediaLauncher", 1, "final open url: " + ((Object) url));
        Intrinsics.checkNotNullExpressionValue(url, "url");
        return url;
    }

    public static /* synthetic */ Fragment c(GuildOpenContainerLauncher guildOpenContainerLauncher, StartParams startParams, ContainerType containerType, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            containerType = ContainerType.H5;
        }
        return guildOpenContainerLauncher.b(startParams, containerType);
    }

    private final QBaseFragment d(StartParams startParams) {
        startParams.getExtra().putString("guildId", startParams.getGuildId());
        startParams.getExtra().putString("channelId", startParams.getChannelId());
        Bundle bundle = new Bundle();
        bundle.putAll(startParams.getExtra());
        GuildOpenContainerLauncher guildOpenContainerLauncher = f229226a;
        bundle.putParcelable("intent", guildOpenContainerLauncher.f(guildOpenContainerLauncher.a(startParams.getUrl()), startParams.getExtra()));
        GuildMainProcessWebViewFragment guildMainProcessWebViewFragment = new GuildMainProcessWebViewFragment();
        guildMainProcessWebViewFragment.setArguments(bundle);
        guildMainProcessWebViewFragment.th(startParams);
        return guildMainProcessWebViewFragment;
    }

    private final Fragment e(StartParams startParams) {
        ((IMiniContainer) QRoute.api(IMiniContainer.class)).addExternalPlugin(GuildOpenStandAloneMiniAppPlugin.class);
        ((IMiniContainer) QRoute.api(IMiniContainer.class)).addExternalPlugin(PlayTogetherMiniAppPlugin.class);
        GuildStandAloneMiniAppFragment guildStandAloneMiniAppFragment = new GuildStandAloneMiniAppFragment();
        guildStandAloneMiniAppFragment.zh(startParams);
        return guildStandAloneMiniAppFragment;
    }

    private final Intent f(String url, Bundle extra) {
        Intent intent = new Intent();
        intent.putExtras(extra);
        intent.putExtra("url", url);
        intent.putExtra("key_remote_web_url", url);
        intent.putExtra("titleBarStyle", 12);
        intent.putExtra("hide_title_left_arrow", true);
        QLog.d("QGMC.MediaThirdApp.GuildOpenMediaLauncher", 2, "getOpenWebViewIntent url:" + url);
        return intent;
    }

    @NotNull
    public final Fragment b(@NotNull StartParams startParams, @NotNull ContainerType type) {
        Intrinsics.checkNotNullParameter(startParams, "startParams");
        Intrinsics.checkNotNullParameter(type, "type");
        Logger.f235387a.d().d("QGMC.MediaThirdApp.GuildOpenMediaLauncher", 1, "[createFragment] type " + type + ", startParams: " + startParams);
        int i3 = b.f229237a[type.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                return e(startParams);
            }
            throw new NoWhenBranchMatchedException();
        }
        return d(startParams);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 +2\u00020\u0001:\u0001\fBS\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\u0006\u0010\u0016\u001a\u00020\t\u0012\b\b\u0002\u0010\u0018\u001a\u00020\t\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0019\u0012\b\b\u0002\u0010!\u001a\u00020\t\u0012\b\b\u0002\u0010'\u001a\u00020\"\u00a2\u0006\u0004\b(\u0010)B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b(\u0010*J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0013\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0016\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\rR\u0017\u0010\u0018\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0012\u0010\rR\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010!\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u000b\u001a\u0004\b \u0010\rR\u0017\u0010'\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/GuildOpenContainerLauncher$StartParams;", "Lcom/tencent/base/api/data/BaseParam;", "Landroid/os/Parcel;", "parcel", "", WadlProxyConsts.FLAGS, "", "writeToParcel", "describeContents", "", "d", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "appId", "e", "g", "url", "f", "guildId", h.F, "b", "channelId", "i", "openId", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "J", "getLobbyId", "()J", "lobbyId", BdhLogUtil.LogTag.Tag_Conn, "j", "webPageId", "Landroid/os/Bundle;", "D", "Landroid/os/Bundle;", "c", "()Landroid/os/Bundle;", "extra", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Landroid/os/Bundle;)V", "(Landroid/os/Parcel;)V", "CREATOR", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class StartParams extends BaseParam {

        /* renamed from: CREATOR, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        /* renamed from: C, reason: from kotlin metadata */
        @NotNull
        private final String webPageId;

        /* renamed from: D, reason: from kotlin metadata */
        @NotNull
        private final Bundle extra;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String appId;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String url;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String guildId;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String channelId;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String openId;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private final long lobbyId;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001f\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/GuildOpenContainerLauncher$StartParams$a;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/GuildOpenContainerLauncher$StartParams;", "Landroid/os/Parcel;", "parcel", "a", "", "size", "", "b", "(I)[Lcom/tencent/mobileqq/guild/media/thirdapp/container/GuildOpenContainerLauncher$StartParams;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.media.thirdapp.container.GuildOpenContainerLauncher$StartParams$a, reason: from kotlin metadata */
        /* loaded from: classes14.dex */
        public static final class Companion implements Parcelable.Creator<StartParams> {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public StartParams createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new StartParams(parcel);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public StartParams[] newArray(int size) {
                return new StartParams[size];
            }

            Companion() {
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public /* synthetic */ StartParams(String str, String str2, String str3, String str4, String str5, long j3, String str6, Bundle bundle, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(r4, r5, str3, str4, (i3 & 16) != 0 ? "" : str5, (i3 & 32) != 0 ? 0L : j3, (i3 & 64) != 0 ? r5 : str6, (i3 & 128) != 0 ? new Bundle() : bundle);
            String str7 = (i3 & 1) != 0 ? "" : str;
            String str8 = (i3 & 2) != 0 ? "" : str2;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getAppId() {
            return this.appId;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getChannelId() {
            return this.channelId;
        }

        @NotNull
        /* renamed from: c, reason: from getter */
        public final Bundle getExtra() {
            return this.extra;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final String getGuildId() {
            return this.guildId;
        }

        @NotNull
        /* renamed from: f, reason: from getter */
        public final String getOpenId() {
            return this.openId;
        }

        @NotNull
        /* renamed from: g, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        @NotNull
        /* renamed from: j, reason: from getter */
        public final String getWebPageId() {
            return this.webPageId;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.appId);
            parcel.writeString(this.url);
            parcel.writeString(this.guildId);
            parcel.writeString(this.channelId);
            parcel.writeString(this.openId);
            parcel.writeLong(this.lobbyId);
            parcel.writeString(this.webPageId);
            parcel.writeBundle(this.extra);
        }

        public StartParams(@NotNull String appId, @NotNull String url, @NotNull String guildId, @NotNull String channelId, @NotNull String openId, long j3, @NotNull String webPageId, @NotNull Bundle extra) {
            Intrinsics.checkNotNullParameter(appId, "appId");
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(openId, "openId");
            Intrinsics.checkNotNullParameter(webPageId, "webPageId");
            Intrinsics.checkNotNullParameter(extra, "extra");
            this.appId = appId;
            this.url = url;
            this.guildId = guildId;
            this.channelId = channelId;
            this.openId = openId;
            this.lobbyId = j3;
            this.webPageId = webPageId;
            this.extra = extra;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public StartParams(@NotNull Parcel parcel) {
            this(r3, r4, r5, r6, r7, r8, r10, r13 == null ? new Bundle() : r13);
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String readString = parcel.readString();
            String str = readString == null ? "" : readString;
            String readString2 = parcel.readString();
            String str2 = readString2 == null ? "" : readString2;
            String readString3 = parcel.readString();
            String str3 = readString3 == null ? "" : readString3;
            String readString4 = parcel.readString();
            String str4 = readString4 == null ? "" : readString4;
            String readString5 = parcel.readString();
            String str5 = readString5 == null ? "" : readString5;
            long readLong = parcel.readLong();
            String readString6 = parcel.readString();
            String str6 = readString6 == null ? "" : readString6;
            Bundle readBundle = parcel.readBundle(Bundle.class.getClassLoader());
        }
    }
}
