package com.tencent.mobileqq.zplan.meme.frameanim;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.model.ZPlanUserInfo;
import com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.zplan.common.model.AppTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b&\u0018\u0000 \u00022\u00020\u0001:\u0002\u0002\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/frameanim/c;", "", "a", "b", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: b, reason: collision with root package name */
    private static final int f333987b = ImmersiveUtils.getScreenHeight() / 2;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J&\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J&\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002R\u0017\u0010\u000e\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/frameanim/c$a;", "", "", "dayAvatar", "nightAvatar", "Lcom/tencent/zplan/common/model/AppTheme;", "appTheme", "b", "uin", "dayRemoteAvatar", "nightRemoteAvatar", "Lcom/tencent/mobileqq/zplan/meme/frameanim/c$b;", "c", "", "BACKGROUND_HEIGHT", "I", "a", "()I", "EMPTY_RESPONSE", "Ljava/lang/String;", "TAG", "URL_PREFIX", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.meme.frameanim.c$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.mobileqq.zplan.meme.frameanim.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes21.dex */
        public /* synthetic */ class C9183a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f333988a;

            static {
                int[] iArr = new int[AppTheme.values().length];
                try {
                    iArr[AppTheme.NIGHT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                f333988a = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final String b(String dayAvatar, String nightAvatar, AppTheme appTheme) {
            if (C9183a.f333988a[appTheme.ordinal()] == 1) {
                return nightAvatar;
            }
            return dayAvatar;
        }

        public static /* synthetic */ Param d(Companion companion, String str, String str2, String str3, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                str2 = null;
            }
            if ((i3 & 4) != 0) {
                str3 = null;
            }
            return companion.c(str, str2, str3);
        }

        public final int a() {
            return c.f333987b;
        }

        @NotNull
        public final Param c(@NotNull String uin, @Nullable String dayRemoteAvatar, @Nullable String nightRemoteAvatar) {
            AppTheme appTheme;
            boolean z16;
            boolean z17;
            Intrinsics.checkNotNullParameter(uin, "uin");
            if (QQTheme.isNowThemeIsNight()) {
                appTheme = AppTheme.NIGHT;
            } else {
                appTheme = AppTheme.DAY;
            }
            AppTheme appTheme2 = appTheme;
            String b16 = b(dayRemoteAvatar, nightRemoteAvatar, appTheme2);
            QRouteApi api = QRoute.api(IZPlanApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanApi::class.java)");
            IZPlanApi iZPlanApi = (IZPlanApi) api;
            String zPlanAvatarImagePathWithUin = iZPlanApi.getZPlanAvatarImagePathWithUin(appTheme2.toString(), uin);
            String avatarLocalUrlWithUin = iZPlanApi.getAvatarLocalUrlWithUin(appTheme2.toString(), uin);
            float avaterWindowsillLocationWithUin = iZPlanApi.getAvaterWindowsillLocationWithUin(uin);
            int zPlanGenderWithUin = iZPlanApi.getZPlanGenderWithUin(uin);
            String zPlanStaticAvatarKey = iZPlanApi.getZPlanStaticAvatarKey(uin);
            ZPlanUserInfo userZPlanInfo = ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).getUserZPlanInfo(uin);
            if (userZPlanInfo.hasCustomDressUp()) {
                if (zPlanStaticAvatarKey.length() == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17 && !Intrinsics.areEqual(userZPlanInfo.appearanceKey, zPlanStaticAvatarKey)) {
                    z16 = false;
                    return new Param(zPlanAvatarImagePathWithUin, avatarLocalUrlWithUin, b16, appTheme2, avaterWindowsillLocationWithUin, zPlanGenderWithUin, z16);
                }
            }
            z16 = true;
            return new Param(zPlanAvatarImagePathWithUin, avatarLocalUrlWithUin, b16, appTheme2, avaterWindowsillLocationWithUin, zPlanGenderWithUin, z16);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0018\u0012\u0006\u0010&\u001a\u00020\u001f\u0012\u0006\u0010,\u001a\u00020\u0004\u0012\u0006\u00103\u001a\u00020\u0007\u00a2\u0006\u0004\b4\u00105J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\"\u0010\u001e\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\t\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010&\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010,\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b\u0010\u0010)\"\u0004\b*\u0010+R\"\u00103\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/zplan/meme/frameanim/c$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getLocalAvatar", "()Ljava/lang/String;", "setLocalAvatar", "(Ljava/lang/String;)V", "localAvatar", "b", "getLocalUrl", "setLocalUrl", "localUrl", "c", "getRemoteAvatar", "setRemoteAvatar", "remoteAvatar", "Lcom/tencent/zplan/common/model/AppTheme;", "d", "Lcom/tencent/zplan/common/model/AppTheme;", "()Lcom/tencent/zplan/common/model/AppTheme;", "setAppTheme", "(Lcom/tencent/zplan/common/model/AppTheme;)V", "appTheme", "", "e", UserInfo.SEX_FEMALE, "getWindowSillLocation", "()F", "setWindowSillLocation", "(F)V", "windowSillLocation", "f", "I", "()I", "setGender", "(I)V", "gender", "g", "Z", "getUpToDate", "()Z", "setUpToDate", "(Z)V", "upToDate", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/zplan/common/model/AppTheme;FIZ)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.meme.frameanim.c$b, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class Param {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private String localAvatar;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private String localUrl;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private String remoteAvatar;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private AppTheme appTheme;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private float windowSillLocation;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private int gender;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean upToDate;

        public Param(@Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull AppTheme appTheme, float f16, int i3, boolean z16) {
            Intrinsics.checkNotNullParameter(appTheme, "appTheme");
            this.localAvatar = str;
            this.localUrl = str2;
            this.remoteAvatar = str3;
            this.appTheme = appTheme;
            this.windowSillLocation = f16;
            this.gender = i3;
            this.upToDate = z16;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final AppTheme getAppTheme() {
            return this.appTheme;
        }

        /* renamed from: b, reason: from getter */
        public final int getGender() {
            return this.gender;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Param)) {
                return false;
            }
            Param param = (Param) other;
            if (Intrinsics.areEqual(this.localAvatar, param.localAvatar) && Intrinsics.areEqual(this.localUrl, param.localUrl) && Intrinsics.areEqual(this.remoteAvatar, param.remoteAvatar) && this.appTheme == param.appTheme && Float.compare(this.windowSillLocation, param.windowSillLocation) == 0 && this.gender == param.gender && this.upToDate == param.upToDate) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            int hashCode2;
            String str = this.localAvatar;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = hashCode * 31;
            String str2 = this.localUrl;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str3 = this.remoteAvatar;
            if (str3 != null) {
                i3 = str3.hashCode();
            }
            int hashCode3 = (((((((i17 + i3) * 31) + this.appTheme.hashCode()) * 31) + Float.floatToIntBits(this.windowSillLocation)) * 31) + this.gender) * 31;
            boolean z16 = this.upToDate;
            int i18 = z16;
            if (z16 != 0) {
                i18 = 1;
            }
            return hashCode3 + i18;
        }

        @NotNull
        public String toString() {
            return "Param(localAvatar=" + this.localAvatar + ", localUrl=" + this.localUrl + ", remoteAvatar=" + this.remoteAvatar + ", appTheme=" + this.appTheme + ", windowSillLocation=" + this.windowSillLocation + ", gender=" + this.gender + ", upToDate=" + this.upToDate + ')';
        }
    }
}
