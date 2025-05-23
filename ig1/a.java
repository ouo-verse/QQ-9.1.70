package ig1;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.guild.client.GuildClientConfigParser;
import com.tencent.mobileqq.guild.client.IGuildClientCommonApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.vip.api.IVipIconUtils;
import com.tencent.mobileqq.vip.api.VipInfoForBusiness;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProIdentityWithClientId;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStUser;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001c\u0010\u0005\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0007J$\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0007\u00a8\u0006\u0014"}, d2 = {"Lig1/a;", "", "", "guildId", "channelId", "b", "iconId", "a", "uin", "", "byteArray", "Landroid/content/res/Resources;", "res", "Landroid/graphics/drawable/Drawable;", "c", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStUser;", QCircleAlphaUserReporter.KEY_USER, "d", "<init>", "()V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f407602a = new a();

    a() {
    }

    @JvmStatic
    @NotNull
    public static final String a(@NotNull String iconId) {
        Intrinsics.checkNotNullParameter(iconId, "iconId");
        QRouteApi api = QRoute.api(IGuildClientCommonApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildClientCommonApi::class.java)");
        return ((IGuildClientCommonApi) api).getClientIdentityIconPrefix() + iconId + "-m.png";
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0054, code lost:
    
        if (r3 != false) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004e  */
    @JvmStatic
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String b(@Nullable String guildId, @Nullable String channelId) {
        boolean isBlank;
        boolean z16;
        boolean isBlank2;
        boolean isBlank3;
        GuildClientConfigParser.Companion companion = GuildClientConfigParser.INSTANCE;
        isBlank = StringsKt__StringsJVMKt.isBlank(companion.a().getWebUrl());
        if (isBlank) {
            return "";
        }
        boolean z17 = false;
        if (guildId != null) {
            isBlank3 = StringsKt__StringsJVMKt.isBlank(guildId);
            if (!isBlank3) {
                z16 = false;
                if (!z16) {
                    QLog.e("GuildClientUtil", 1, "getSVipNamePlateJumpLink error, guildId:" + guildId + ", channelId" + channelId);
                    return companion.a().getWebUrl();
                }
                if (channelId != null) {
                    isBlank2 = StringsKt__StringsJVMKt.isBlank(channelId);
                }
                z17 = true;
                if (z17) {
                    channelId = "0";
                }
                return companion.a().getWebUrl() + "&enteranceId=qqchannel-" + guildId + '-' + channelId;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    @JvmStatic
    @Nullable
    public static final Drawable c(@Nullable String uin, @NotNull byte[] byteArray, @NotNull Resources res) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        Intrinsics.checkNotNullParameter(res, "res");
        VipInfoForBusiness vipInfoForBusiness = new VipInfoForBusiness(uin);
        vipInfoForBusiness.fromBuffer(byteArray);
        return ((IVipIconUtils) QRoute.api(IVipIconUtils.class)).getVipIconDrawableWithoutUin(res, vipInfoForBusiness);
    }

    @JvmStatic
    @Nullable
    public static final byte[] d(@Nullable GProStUser user) {
        boolean z16;
        Object obj;
        byte[] thirdPartyData;
        boolean z17;
        if (user == null) {
            return null;
        }
        ArrayList<GProIdentityWithClientId> defaultIdentitys = user.channelUserInfo.getClientIdentityBytes().defaultIdentitys;
        if (defaultIdentitys.isEmpty()) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(defaultIdentitys, "defaultIdentitys");
        Iterator<T> it = defaultIdentitys.iterator();
        while (true) {
            z16 = false;
            if (it.hasNext()) {
                obj = it.next();
                if (((GProIdentityWithClientId) obj).identitys.identityType == 2) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        GProIdentityWithClientId gProIdentityWithClientId = (GProIdentityWithClientId) obj;
        if (gProIdentityWithClientId != null && (thirdPartyData = gProIdentityWithClientId.identitys.getThirdPartyData()) != null) {
            if (thirdPartyData.length == 0) {
                z16 = true;
            }
            if (!z16) {
                if (QLog.isColorLevel()) {
                    QLog.i("GuildClientUtil", 1, "getVipTransformData " + new String(thirdPartyData, Charsets.UTF_8));
                }
                return thirdPartyData;
            }
        }
        return null;
    }
}
