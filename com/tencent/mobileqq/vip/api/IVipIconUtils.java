package com.tencent.mobileqq.vip.api;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vas.ui.IVipFrameDrawable;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.widget.SingleLineTextView;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0007\bg\u0018\u0000 ?2\u00020\u0001:\u0001?J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u001a\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fH&J\"\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000eH&J$\u0010\u0014\u001a\u00020\u00132\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0010\u001a\u00020\u000eH&J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0011H&J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0011H&J\u0010\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0019H&J/\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u001f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u000eH&\u00a2\u0006\u0004\b \u0010!J(\u0010'\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u00112\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u000eH&J\u001c\u0010+\u001a\u00020\u00132\b\u0010)\u001a\u0004\u0018\u00010(2\b\u0010\u001d\u001a\u0004\u0018\u00010*H&J\u001c\u0010+\u001a\u00020\u00132\b\u0010)\u001a\u0004\u0018\u00010(2\b\u0010\r\u001a\u0004\u0018\u00010\fH&J&\u00100\u001a\u00020\u00132\u0006\u0010,\u001a\u00020\f2\u0014\u0010/\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010.\u0012\u0004\u0012\u00020\u00130-H&J(\u00107\u001a\u0002062\u0006\u00101\u001a\u00020\f2\u0006\u00102\u001a\u00020\f2\u0006\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\u0011H&J>\u0010>\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\n2\u0006\u00108\u001a\u00020\f2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\f092\u0006\u0010;\u001a\u00020\f2\u0006\u0010<\u001a\u00020\f2\u0006\u0010=\u001a\u00020\u0011H&\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/vip/api/IVipIconUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/res/Resources;", "res", "Lcom/tencent/mobileqq/vip/api/VipInfoForBusiness;", "info", "Landroid/graphics/drawable/Drawable;", "getVipIconDrawable", "Lcom/tencent/mobileqq/vas/image/c;", "getVipIconDrawableWithoutUin", "Landroid/widget/ImageView;", "imageView", "", "uin", "", "setVipCardDrawable", "loop", "", "id", "", "setVipExtIcon", "nameplateVipType", "isDiyVipIcon", "grayNameplateFlag", "isGrayVipIcon", "Lcom/tencent/mobileqq/vip/api/f;", "spec", "getDefaultVipIcon", "Lcom/tencent/qqnt/ntrelation/vasinfo/bean/NTVasSimpleInfo;", "friends", "showGray", "", "getVIPIconUrl", "(Lcom/tencent/qqnt/ntrelation/vasinfo/bean/NTVasSimpleInfo;Lcom/tencent/mobileqq/vip/api/f;Z)[Ljava/lang/String;", "vipType", "iQQVipLevel", "", "lSuperVipTemplateId", "isGray", "getVipIconUrl", "Lcom/tencent/widget/SingleLineTextView;", "textView", "Lcom/tencent/mobileqq/data/Friends;", "setVipIconForFriendList", CoverDBCacheData.URLS, "Lkotlin/Function1;", "Lcom/tencent/mobileqq/vas/ui/IVipFrameDrawable;", "callback", "getQzoneNamePlateDrawable", "frameUrl", "business", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/k;", "options", "type", "Lcom/tencent/mobileqq/vas/ui/c;", "getQzoneFrameDrawable", "resZipUrl", "", "idLetterList", "bgFileName", "fgFileName", "iconHeight", "setQzoneLetterSwitchIcon", "Companion", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVipIconUtils extends QRouteApi {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/vip/api/IVipIconUtils$Companion;", "", "()V", DTConstants.TAG.API, "Lcom/tencent/mobileqq/vip/api/IVipIconUtils;", "vas-temp-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE;
        static IPatchRedirector $redirector_;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39902);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                $$INSTANCE = new Companion();
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @JvmStatic
        @NotNull
        public final IVipIconUtils api() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (IVipIconUtils) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            QRouteApi api = QRoute.api(IVipIconUtils.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IVipIconUtils::class.java)");
            return (IVipIconUtils) api;
        }
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(39918), (Class<?>) IVipIconUtils.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2);
        } else {
            INSTANCE = Companion.$$INSTANCE;
        }
    }

    int getDefaultVipIcon(@NotNull f spec);

    @NotNull
    com.tencent.mobileqq.vas.ui.c getQzoneFrameDrawable(@NotNull String frameUrl, @NotNull String business, @NotNull com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k options, int type);

    void getQzoneNamePlateDrawable(@NotNull String urls, @NotNull Function1<? super IVipFrameDrawable, Unit> callback);

    @NotNull
    String[] getVIPIconUrl(@Nullable NTVasSimpleInfo friends, @NotNull f spec, boolean showGray);

    @Nullable
    Drawable getVipIconDrawable(@NotNull Resources res, @NotNull VipInfoForBusiness info);

    @Nullable
    com.tencent.mobileqq.vas.image.c getVipIconDrawableWithoutUin(@NotNull Resources res, @NotNull VipInfoForBusiness info);

    @NotNull
    String getVipIconUrl(int vipType, int iQQVipLevel, long lSuperVipTemplateId, boolean isGray);

    boolean isDiyVipIcon(int nameplateVipType);

    boolean isGrayVipIcon(int grayNameplateFlag);

    void setQzoneLetterSwitchIcon(@NotNull ImageView imageView, @NotNull String resZipUrl, @NotNull List<String> idLetterList, @NotNull String bgFileName, @NotNull String fgFileName, int iconHeight);

    boolean setVipCardDrawable(@Nullable ImageView imageView, @NotNull String uin);

    boolean setVipCardDrawable(@Nullable ImageView imageView, @NotNull String uin, boolean loop);

    void setVipExtIcon(@Nullable ImageView imageView, int id5, boolean loop);

    void setVipIconForFriendList(@Nullable SingleLineTextView textView, @Nullable Friends friends);

    void setVipIconForFriendList(@Nullable SingleLineTextView textView, @Nullable String uin);
}
