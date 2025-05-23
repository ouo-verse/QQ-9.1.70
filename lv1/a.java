package lv1;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.profilecard.widget.CountrySelect.CountrySelectView;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityByteInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProIdentityInfoWithClientId;
import com.tencent.mobileqq.qqguildsdk.data.ev;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0007J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0007J\u0010\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eR(\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Llv1/a;", "", "Lcom/tencent/mobileqq/qqguildsdk/data/ev;", "info", "Ljava/lang/StringBuilder;", "a", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProIdentityInfo;", "c", "b", "", "uin", "", "f", "g", "Landroid/net/Uri;", LayoutAttrDefine.CLICK_URI, "", "e", "<set-?>", "Landroid/net/Uri;", "d", "()Landroid/net/Uri;", "snapshotFileUri", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f415618a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Uri snapshotFileUri;

    a() {
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a4  */
    @JvmStatic
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final StringBuilder a(@NotNull ev info) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean isBlank;
        boolean z19;
        boolean isBlank2;
        boolean z26;
        boolean isBlank3;
        Intrinsics.checkNotNullParameter(info, "info");
        String i3 = info.i();
        boolean z27 = true;
        if (49 == info.p()) {
            z16 = true;
        } else {
            z16 = false;
        }
        String province = info.getProvince();
        String city = info.getCity();
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.profile.GuildProfileUtils", 2, i3 + ", " + z16 + ", " + province + ", " + city);
        }
        StringBuilder sb5 = new StringBuilder();
        if (!z16) {
            if (i3 != null) {
                isBlank3 = StringsKt__StringsJVMKt.isBlank(i3);
                if (!isBlank3) {
                    z26 = false;
                    if (!z26) {
                        sb5.append(i3);
                    }
                }
            }
            z26 = true;
            if (!z26) {
            }
        }
        if (province != null) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(province);
            if (!isBlank2) {
                z17 = false;
                if (!z17 && !Intrinsics.areEqual(CountrySelectView.NAME_CHINA, province)) {
                    if (sb5.length() <= 0) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    if (z19) {
                        sb5.append("-");
                    }
                    sb5.append(province);
                }
                if (city != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(city);
                    if (!isBlank) {
                        z18 = false;
                        if (!z18) {
                            if (sb5.length() <= 0) {
                                z27 = false;
                            }
                            if (z27) {
                                sb5.append("-");
                            }
                            sb5.append(city);
                        }
                        return sb5;
                    }
                }
                z18 = true;
                if (!z18) {
                }
                return sb5;
            }
        }
        z17 = true;
        if (!z17) {
            if (sb5.length() <= 0) {
            }
            if (z19) {
            }
            sb5.append(province);
        }
        if (city != null) {
        }
        z18 = true;
        if (!z18) {
        }
        return sb5;
    }

    @JvmStatic
    @Nullable
    public static final IGProIdentityInfo b(@NotNull ev info) {
        IGProClientIdentityByteInfo identityBytes;
        Intrinsics.checkNotNullParameter(info, "info");
        IGProClientIdentityInfo clientIdentity = info.getClientIdentity();
        if (clientIdentity == null || (identityBytes = clientIdentity.getIdentityBytes()) == null) {
            return null;
        }
        for (IGProIdentityInfo iGProIdentityInfo : identityBytes.getIdentityList()) {
            if (iGProIdentityInfo.getType() == 0 || iGProIdentityInfo.getType() == 1 || iGProIdentityInfo.getIdentityType() == 2) {
                return iGProIdentityInfo;
            }
        }
        return null;
    }

    @JvmStatic
    @Nullable
    public static final IGProIdentityInfo c(@NotNull ev info) {
        IGProClientIdentityByteInfo identityBytes;
        Intrinsics.checkNotNullParameter(info, "info");
        IGProClientIdentityInfo clientIdentity = info.getClientIdentity();
        if (clientIdentity == null || (identityBytes = clientIdentity.getIdentityBytes()) == null) {
            return null;
        }
        for (IGProIdentityInfoWithClientId iGProIdentityInfoWithClientId : identityBytes.getDefaultIdentityList()) {
            iGProIdentityInfoWithClientId.getIdentity().getType();
            if (iGProIdentityInfoWithClientId.getIdentity().getType() == 0 || iGProIdentityInfoWithClientId.getIdentity().getType() == 1 || iGProIdentityInfoWithClientId.getIdentity().getIdentityType() == 2) {
                return iGProIdentityInfoWithClientId.getIdentity();
            }
        }
        return null;
    }

    @JvmStatic
    public static final boolean f(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (TextUtils.isEmpty(uin)) {
            return false;
        }
        try {
            if (Long.parseLong(uin) <= 4294967295L) {
                return false;
            }
            return true;
        } catch (NumberFormatException e16) {
            QLog.e("Guild.profile.GuildProfileUtils", 1, "is42eUin exception:" + e16);
            return false;
        }
    }

    @JvmStatic
    public static final boolean g(@NotNull String uin) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        if (!TextUtils.isEmpty(uin) && !Intrinsics.areEqual("0", uin)) {
            return false;
        }
        return true;
    }

    @Nullable
    public final Uri d() {
        return snapshotFileUri;
    }

    public final void e(@Nullable Uri uri) {
        snapshotFileUri = uri;
    }
}
