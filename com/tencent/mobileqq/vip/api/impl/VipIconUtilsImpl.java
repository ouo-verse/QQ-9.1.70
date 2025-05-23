package com.tencent.mobileqq.vip.api.impl;

import QQService.EVIPSPEC;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.al;
import com.tencent.mobileqq.vas.ToggleProxy;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.api.IVasRecentData;
import com.tencent.mobileqq.vas.ui.IVipFrameDrawable;
import com.tencent.mobileqq.vas.util.QQVasUpdateBusinessUtil;
import com.tencent.mobileqq.vas.vipicon.AbsLetterSwitchDrawable;
import com.tencent.mobileqq.vas.vipicon.api.IVipIconExFactory;
import com.tencent.mobileqq.vas.vipicon.api.IVipIconFactory;
import com.tencent.mobileqq.vip.api.IVipDataUtils;
import com.tencent.mobileqq.vip.api.IVipIconUtils;
import com.tencent.mobileqq.vip.api.IVipInfoUtils;
import com.tencent.mobileqq.vip.api.VipData;
import com.tencent.mobileqq.vip.api.VipInfoForBusiness;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.widget.SingleLineTextView;
import cooperation.qzone.zipanimate.ZipDrawableLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 L2\u00020\u0001:\u0001MB\u0007\u00a2\u0006\u0004\bJ\u0010KJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001c\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J/\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u000fH\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cJ(\u0010\"\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u000fH\u0016J\u001c\u0010&\u001a\u00020\b2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\u0017\u001a\u0004\u0018\u00010%H\u0016J\u001c\u0010&\u001a\u00020\b2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010'\u001a\u0004\u0018\u00010\u001aH\u0016J>\u0010.\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u001a2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001a0)2\u0006\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u0006H\u0016J\"\u00101\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010/\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u000fH\u0016J\u001a\u00105\u001a\u0004\u0018\u0001042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u00103\u001a\u000202H\u0016J\u001a\u00106\u001a\u0004\u0018\u0001042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u00103\u001a\u000202H\u0016J\u001a\u00107\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010'\u001a\u00020\u001aH\u0016J\"\u00107\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010'\u001a\u00020\u001a2\u0006\u00100\u001a\u00020\u000fH\u0016J&\u0010<\u001a\u00020\b2\u0006\u00108\u001a\u00020\u001a2\u0014\u0010;\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010:\u0012\u0004\u0012\u00020\b09H\u0016J(\u0010C\u001a\u00020B2\u0006\u0010=\u001a\u00020\u001a2\u0006\u0010>\u001a\u00020\u001a2\u0006\u0010@\u001a\u00020?2\u0006\u0010A\u001a\u00020\u0006H\u0016R\u0017\u0010D\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u0017\u0010H\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\bH\u0010E\u001a\u0004\bI\u0010G\u00a8\u0006N"}, d2 = {"Lcom/tencent/mobileqq/vip/api/impl/VipIconUtilsImpl;", "Lcom/tencent/mobileqq/vip/api/IVipIconUtils;", "Landroid/widget/ImageView;", "imageView", "Landroid/graphics/drawable/Drawable;", "drawable", "", "requestHeight", "", "relayoutImageView", "Landroid/content/res/Resources;", "res", "resizeVipIconToFixedHeight", "getVipIconHeight", "nameplateVipType", "", "isDiyVipIcon", "grayNameplateFlag", "isGrayVipIcon", "Lcom/tencent/mobileqq/vip/api/f;", "spec", "getDefaultVipIcon", "Lcom/tencent/qqnt/ntrelation/vasinfo/bean/NTVasSimpleInfo;", "friends", "showGray", "", "", "getVIPIconUrl", "(Lcom/tencent/qqnt/ntrelation/vasinfo/bean/NTVasSimpleInfo;Lcom/tencent/mobileqq/vip/api/f;Z)[Ljava/lang/String;", "vipType", "iQQVipLevel", "", "lSuperVipTemplateId", "isGray", "getVipIconUrl", "Lcom/tencent/widget/SingleLineTextView;", "textView", "Lcom/tencent/mobileqq/data/Friends;", "setVipIconForFriendList", "uin", "resZipUrl", "", "idLetterList", "bgFileName", "fgFileName", "iconHeight", "setQzoneLetterSwitchIcon", "id", "loop", "setVipExtIcon", "Lcom/tencent/mobileqq/vip/api/VipInfoForBusiness;", "info", "Lcom/tencent/mobileqq/vas/image/c;", "getVipIconDrawableWithoutUin", "getVipIconDrawable", "setVipCardDrawable", CoverDBCacheData.URLS, "Lkotlin/Function1;", "Lcom/tencent/mobileqq/vas/ui/IVipFrameDrawable;", "callback", "getQzoneNamePlateDrawable", "frameUrl", "business", "Lcom/tencent/cachedrawable/dynamicdrawable/cachedrawable/k;", "options", "type", "Lcom/tencent/mobileqq/vas/ui/c;", "getQzoneFrameDrawable", "nameplateUrl", "Ljava/lang/String;", "getNameplateUrl", "()Ljava/lang/String;", "greyNameplateUrl", "getGreyNameplateUrl", "<init>", "()V", "Companion", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VipIconUtilsImpl implements IVipIconUtils {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "VipIconUtilsImpl";
    public static final int VIP_CARD_FIX_HEIGHT_BY_DP = 15;

    @NotNull
    private final String greyNameplateUrl;

    @NotNull
    private final String nameplateUrl;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/vip/api/impl/VipIconUtilsImpl$a;", "", "", "TAG", "Ljava/lang/String;", "", "VIP_CARD_FIX_HEIGHT_BY_DP", "I", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.vip.api.impl.VipIconUtilsImpl$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50216);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public VipIconUtilsImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        ToggleProxy toggleProxy = VasToggle.NAMEPLATE_URL;
        String stringDataSet = toggleProxy.getStringDataSet("", "https://tianquan.gtimg.cn/namePlate/item/%d/%d/%d.png");
        Intrinsics.checkNotNull(stringDataSet);
        this.nameplateUrl = stringDataSet;
        String stringDataSet2 = toggleProxy.getStringDataSet("", "https://tianquan.gtimg.cn/namePlate/item/%d/%d/%d_grey.png");
        Intrinsics.checkNotNull(stringDataSet2);
        this.greyNameplateUrl = stringDataSet2;
    }

    private final int getVipIconHeight(Resources res) {
        return (int) ((15 * res.getDisplayMetrics().density) + 0.5f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void relayoutImageView(ImageView imageView, Drawable drawable, int requestHeight) {
        if (drawable.getIntrinsicHeight() <= 0) {
            return;
        }
        int intrinsicWidth = (drawable.getIntrinsicWidth() * requestHeight) / drawable.getIntrinsicHeight();
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.height = requestHeight;
        layoutParams.width = intrinsicWidth;
        imageView.setImageDrawable(null);
        imageView.setImageDrawable(drawable);
        imageView.setLayoutParams(layoutParams);
    }

    private final Drawable resizeVipIconToFixedHeight(Resources res, Drawable drawable) {
        if (drawable == null) {
            return drawable;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth != 0 && intrinsicHeight != 0) {
            int vipIconHeight = getVipIconHeight(res);
            drawable.setBounds(0, 0, (intrinsicWidth * vipIconHeight) / intrinsicHeight, vipIconHeight);
        }
        return drawable;
    }

    @Override // com.tencent.mobileqq.vip.api.IVipIconUtils
    public int getDefaultVipIcon(@NotNull com.tencent.mobileqq.vip.api.f spec) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) spec)).intValue();
        }
        Intrinsics.checkNotNullParameter(spec, "spec");
        QLog.e(TAG, 1, " getDefaultVipIcon spec = " + spec.f312805a);
        if (spec != com.tencent.mobileqq.vip.api.f.f312799c && spec != com.tencent.mobileqq.vip.api.f.f312800d) {
            if (spec == com.tencent.mobileqq.vip.api.f.f312801e) {
                return R.drawable.bhl;
            }
            if (spec == com.tencent.mobileqq.vip.api.f.f312802f) {
                return R.drawable.bhn;
            }
            if (spec != com.tencent.mobileqq.vip.api.f.f312803g && spec != com.tencent.mobileqq.vip.api.f.f312804h) {
                return 0;
            }
            return R.drawable.bhk;
        }
        return R.drawable.bhm;
    }

    @NotNull
    public final String getGreyNameplateUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.greyNameplateUrl;
    }

    @NotNull
    public final String getNameplateUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.nameplateUrl;
    }

    @Override // com.tencent.mobileqq.vip.api.IVipIconUtils
    @NotNull
    public com.tencent.mobileqq.vas.ui.c getQzoneFrameDrawable(@NotNull String frameUrl, @NotNull String business, @NotNull com.tencent.cachedrawable.dynamicdrawable.cachedrawable.k options, int type) {
        com.tencent.cachedrawable.dynamicdrawable.e eVar;
        boolean startsWith$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (com.tencent.mobileqq.vas.ui.c) iPatchRedirector.redirect((short) 18, this, frameUrl, business, options, Integer.valueOf(type));
        }
        Intrinsics.checkNotNullParameter(frameUrl, "frameUrl");
        Intrinsics.checkNotNullParameter(business, "business");
        Intrinsics.checkNotNullParameter(options, "options");
        if (type != 1) {
            if (type != 2) {
                eVar = f.f312873a;
            } else {
                eVar = h.f312875a;
            }
        } else {
            eVar = g.f312874a;
        }
        com.tencent.cachedrawable.dynamicdrawable.e eVar2 = eVar;
        if (business.length() != 0) {
            z16 = false;
        }
        if (z16) {
            business = ZipDrawableLoader.DEFAULT_BUSINESS;
        }
        String str = business;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(frameUrl, "http", false, 2, null);
        if (startsWith$default) {
            return new VasFrameDrawable(frameUrl, "", options, eVar2, str);
        }
        return new VasFrameDrawable("", frameUrl, options, eVar2, str);
    }

    @Override // com.tencent.mobileqq.vip.api.IVipIconUtils
    public void getQzoneNamePlateDrawable(@NotNull String urls, @NotNull final Function1<? super IVipFrameDrawable, Unit> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) urls, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(urls, "urls");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            JSONArray jSONArray = new JSONArray(urls);
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                arrayList.add(jSONArray.getString(i3));
            }
            VipFrameIconDrawable vipFrameIconDrawable = new VipFrameIconDrawable(arrayList);
            vipFrameIconDrawable.setLoadedListener(new Function1<IVipFrameDrawable, Unit>(callback) { // from class: com.tencent.mobileqq.vip.api.impl.VipIconUtilsImpl$getQzoneNamePlateDrawable$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Function1<IVipFrameDrawable, Unit> $callback;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                    this.$callback = callback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) callback);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(IVipFrameDrawable iVipFrameDrawable) {
                    invoke2(iVipFrameDrawable);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull IVipFrameDrawable d16) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) d16);
                    } else {
                        Intrinsics.checkNotNullParameter(d16, "d");
                        this.$callback.invoke(d16);
                    }
                }
            });
            vipFrameIconDrawable.D();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "parse json error: " + e16.getMessage());
        }
    }

    @Override // com.tencent.mobileqq.vip.api.IVipIconUtils
    @NotNull
    public String[] getVIPIconUrl(@Nullable NTVasSimpleInfo friends, @NotNull com.tencent.mobileqq.vip.api.f spec, boolean showGray) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String[]) iPatchRedirector.redirect((short) 7, this, friends, spec, Boolean.valueOf(showGray));
        }
        Intrinsics.checkNotNullParameter(spec, "spec");
        if (friends != null) {
            if (spec != com.tencent.mobileqq.vip.api.f.f312803g && spec != com.tencent.mobileqq.vip.api.f.f312804h) {
                if (spec != com.tencent.mobileqq.vip.api.f.f312801e && spec != com.tencent.mobileqq.vip.api.f.f312802f) {
                    if (spec == com.tencent.mobileqq.vip.api.f.f312799c || spec == com.tencent.mobileqq.vip.api.f.f312800d) {
                        return new String[]{getVipIconUrl(spec.f312805a, com.tencent.mobileqq.vip.r.a(friends, EVIPSPEC.E_SP_QQVIP), 0L, showGray)};
                    }
                } else {
                    int[] vipIconsArray = IVipInfoUtils.INSTANCE.a().getVipIconsArray(friends.vipIcons);
                    int a16 = com.tencent.mobileqq.vip.r.a(friends, EVIPSPEC.E_SP_SUPERVIP);
                    if (vipIconsArray.length == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        ArrayList arrayList = new ArrayList(vipIconsArray.length);
                        for (int i3 : vipIconsArray) {
                            arrayList.add(getVipIconUrl(spec.f312805a, a16, i3, showGray));
                        }
                        Object[] array = arrayList.toArray(new String[0]);
                        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                        return (String[]) array;
                    }
                    return new String[]{getVipIconUrl(spec.f312805a, a16, friends.superVipTemplateId, showGray)};
                }
            } else {
                return new String[]{getVipIconUrl(spec.f312805a, com.tencent.mobileqq.vip.r.a(friends, EVIPSPEC.E_SP_BIGCLUB), friends.bigClubTemplateId, showGray)};
            }
        }
        return new String[]{getVipIconUrl(0, 0, 0L, false)};
    }

    @Override // com.tencent.mobileqq.vip.api.IVipIconUtils
    @Nullable
    public com.tencent.mobileqq.vas.image.c getVipIconDrawableWithoutUin(@NotNull Resources res, @NotNull VipInfoForBusiness info) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (com.tencent.mobileqq.vas.image.c) iPatchRedirector.redirect((short) 13, (Object) this, (Object) res, (Object) info);
        }
        Intrinsics.checkNotNullParameter(res, "res");
        Intrinsics.checkNotNullParameter(info, "info");
        VipData vipData = null;
        if (SimpleUIUtil.getSimpleUISwitch()) {
            return null;
        }
        com.tencent.mobileqq.vip.api.g numberIcon = info.getNumberIcon();
        if (numberIcon != null && numberIcon.b() > 0) {
            vipData = new VipData(false, 0L, false, true, numberIcon.b(), numberIcon.c(), numberIcon.a(), 0, 0, 0, 0, 0, null, 0, false, 0L, false, 0, false, 524167, null);
        }
        IVasRecentData.FriendsVipData friendsVipData = new IVasRecentData.FriendsVipData();
        friendsVipData.setVipType(info.getNameplateType());
        friendsVipData.setVipLevel(info.getLevel());
        friendsVipData.setNamePlateId(info.getNameplateId());
        for (int i3 : info.getDiyNameplateIds()) {
            friendsVipData.getCarouselNamePlateIds().add(Integer.valueOf(i3));
        }
        if (vipData != null && vipData.isLetterSwitchAvailable()) {
            friendsVipData.setDiyNamePlateItemId(vipData.getNameplateItemId());
            friendsVipData.getDiyNamePlateContentIds().add(Integer.valueOf(vipData.getNameplateFgId()));
            for (int i16 : vipData.getNameplateLetters()) {
                friendsVipData.getDiyNamePlateContentIds().add(Integer.valueOf(i16));
            }
        }
        IVipIconFactory iVipIconFactory = (IVipIconFactory) QRoute.api(IVipIconFactory.class);
        String uin = info.getUin();
        if (uin == null) {
            uin = "";
        }
        return iVipIconFactory.getIcon(res, uin, friendsVipData);
    }

    @Override // com.tencent.mobileqq.vip.api.IVipIconUtils
    @NotNull
    public String getVipIconUrl(int vipType, int iQQVipLevel, long lSuperVipTemplateId, boolean isGray) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(vipType), Integer.valueOf(iQQVipLevel), Long.valueOf(lSuperVipTemplateId), Boolean.valueOf(isGray));
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getVipIconUrl vipType = ");
        sb5.append(vipType);
        sb5.append(" iQQVipLevel = ");
        int i3 = iQQVipLevel;
        sb5.append(i3);
        sb5.append(" lSuperVipTemplateId = ");
        sb5.append(lSuperVipTemplateId);
        sb5.append(" isGray = ");
        sb5.append(isGray);
        QLog.e(TAG, 1, sb5.toString());
        com.tencent.mobileqq.vas.vipicon.g gVar = (com.tencent.mobileqq.vas.vipicon.g) QQVasUpdateBusinessUtil.getBusinessInstance(com.tencent.mobileqq.vas.vipicon.g.class);
        int i16 = (int) lSuperVipTemplateId;
        if (gVar.isFileExists(i16)) {
            String h16 = gVar.h(lSuperVipTemplateId, vipType, iQQVipLevel, isGray);
            Intrinsics.checkNotNullExpressionValue(h16, "business.getNamePlatePat\u2026ype, iQQVipLevel, isGray)");
            QLog.i(TAG, 1, "getVipIconUrl, filePath = " + h16);
            return h16;
        }
        gVar.startDownload(i16);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        if (!isGray) {
            str = this.nameplateUrl;
        } else {
            str = this.greyNameplateUrl;
        }
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(lSuperVipTemplateId);
        objArr[1] = Integer.valueOf(vipType);
        if (isGray) {
            i3 = 0;
        }
        objArr[2] = Integer.valueOf(i3);
        String format = String.format(str, Arrays.copyOf(objArr, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        QLog.w(TAG, 1, "getVipIconUrl, use new networkUrl");
        return format;
    }

    @Override // com.tencent.mobileqq.vip.api.IVipIconUtils
    public boolean isDiyVipIcon(int nameplateVipType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, nameplateVipType)).booleanValue();
        }
        if (nameplateVipType > 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.vip.api.IVipIconUtils
    public boolean isGrayVipIcon(int grayNameplateFlag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, grayNameplateFlag)).booleanValue();
        }
        if (grayNameplateFlag == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.vip.api.IVipIconUtils
    public void setQzoneLetterSwitchIcon(@NotNull final ImageView imageView, @NotNull String resZipUrl, @NotNull List<String> idLetterList, @NotNull String bgFileName, @NotNull String fgFileName, final int iconHeight) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, imageView, resZipUrl, idLetterList, bgFileName, fgFileName, Integer.valueOf(iconHeight));
            return;
        }
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(resZipUrl, "resZipUrl");
        Intrinsics.checkNotNullParameter(idLetterList, "idLetterList");
        Intrinsics.checkNotNullParameter(bgFileName, "bgFileName");
        Intrinsics.checkNotNullParameter(fgFileName, "fgFileName");
        final j jVar = new j(resZipUrl, idLetterList, bgFileName, fgFileName);
        AbsLetterSwitchDrawable.G(jVar, false, 1, null);
        jVar.setLoadedListener(new Function1<com.tencent.mobileqq.vas.image.c, Unit>(imageView, jVar, iconHeight) { // from class: com.tencent.mobileqq.vip.api.impl.VipIconUtilsImpl$setQzoneLetterSwitchIcon$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ j $drawable;
            final /* synthetic */ int $iconHeight;
            final /* synthetic */ ImageView $imageView;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$imageView = imageView;
                this.$drawable = jVar;
                this.$iconHeight = iconHeight;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, VipIconUtilsImpl.this, imageView, jVar, Integer.valueOf(iconHeight));
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.mobileqq.vas.image.c cVar) {
                invoke2(cVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull com.tencent.mobileqq.vas.image.c it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                } else {
                    Intrinsics.checkNotNullParameter(it, "it");
                    VipIconUtilsImpl.this.relayoutImageView(this.$imageView, this.$drawable, this.$iconHeight);
                }
            }
        });
        relayoutImageView(imageView, jVar, iconHeight);
    }

    @Override // com.tencent.mobileqq.vip.api.IVipIconUtils
    public boolean setVipCardDrawable(@Nullable ImageView imageView, @NotNull String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) imageView, (Object) uin)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        return setVipCardDrawable(imageView, uin, true);
    }

    @Override // com.tencent.mobileqq.vip.api.IVipIconUtils
    public void setVipExtIcon(@Nullable ImageView imageView, int id5, boolean loop) {
        Resources resources;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, imageView, Integer.valueOf(id5), Boolean.valueOf(loop));
            return;
        }
        if (imageView != null) {
            resources = imageView.getResources();
        } else {
            resources = null;
        }
        if (resources == null) {
            return;
        }
        IVasRecentData.FriendsVipData friendsVipData = new IVasRecentData.FriendsVipData();
        friendsVipData.setVipIconEx(id5);
        com.tencent.mobileqq.vas.image.c icon = ((IVipIconExFactory) QRoute.api(IVipIconExFactory.class)).getIcon(resources, friendsVipData);
        if (icon != null) {
            icon.setLoop(loop);
        }
        imageView.setImageDrawable(icon);
    }

    @Override // com.tencent.mobileqq.vip.api.IVipIconUtils
    public void setVipIconForFriendList(@Nullable SingleLineTextView textView, @Nullable Friends friends) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            setVipIconForFriendList(textView, friends != null ? friends.uin : null);
        } else {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) textView, (Object) friends);
        }
    }

    @Override // com.tencent.mobileqq.vip.api.IVipIconUtils
    @Nullable
    public com.tencent.mobileqq.vas.image.c getVipIconDrawable(@NotNull Resources res, @NotNull VipInfoForBusiness info) {
        VipData vipData;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (com.tencent.mobileqq.vas.image.c) iPatchRedirector.redirect((short) 14, (Object) this, (Object) res, (Object) info);
        }
        Intrinsics.checkNotNullParameter(res, "res");
        Intrinsics.checkNotNullParameter(info, "info");
        com.tencent.mobileqq.vip.api.g numberIcon = info.getNumberIcon();
        if (!TextUtils.isEmpty(info.getUin()) && info.getVipDataFlag() > 0) {
            IVipDataUtils.Companion companion = IVipDataUtils.INSTANCE;
            companion.a().updateFlagData(info.getUin(), info.getVipDataFlag());
            vipData = companion.a().getVipDataForFriends(info.getUin());
        } else {
            vipData = (numberIcon == null || numberIcon.b() <= 0) ? null : new VipData(false, 0L, false, true, numberIcon.b(), numberIcon.c(), numberIcon.a(), 0, 0, 0, 0, 0, null, 0, false, 0L, false, 0, false, 524167, null);
        }
        IVasRecentData.FriendsVipData friendsVipData = new IVasRecentData.FriendsVipData();
        friendsVipData.setVipType(info.getNameplateType());
        friendsVipData.setVipLevel(info.getLevel());
        friendsVipData.setNamePlateId(info.getNameplateId());
        for (int i3 : info.getDiyNameplateIds()) {
            friendsVipData.getCarouselNamePlateIds().add(Integer.valueOf(i3));
        }
        if (vipData != null && vipData.isLetterSwitchAvailable()) {
            friendsVipData.setDiyNamePlateItemId(vipData.getNameplateItemId());
            friendsVipData.getDiyNamePlateContentIds().add(Integer.valueOf(vipData.getNameplateFgId()));
            for (int i16 : vipData.getNameplateLetters()) {
                friendsVipData.getDiyNamePlateContentIds().add(Integer.valueOf(i16));
            }
        }
        IVipIconFactory iVipIconFactory = (IVipIconFactory) QRoute.api(IVipIconFactory.class);
        String uin = info.getUin();
        if (uin == null) {
            uin = "";
        }
        return iVipIconFactory.getIcon(res, uin, friendsVipData);
    }

    @Override // com.tencent.mobileqq.vip.api.IVipIconUtils
    public boolean setVipCardDrawable(@Nullable ImageView imageView, @NotNull String uin, boolean loop) {
        com.tencent.mobileqq.vas.image.c icon;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, this, imageView, uin, Boolean.valueOf(loop))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        Resources resources = imageView != null ? imageView.getResources() : null;
        if (resources == null || (icon = ((IVipIconFactory) QRoute.api(IVipIconFactory.class)).getIcon(resources, uin)) == null) {
            return false;
        }
        icon.setLoop(loop);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.height = ((IVipIconFactory) QRoute.api(IVipIconFactory.class)).getIconHeight(resources, uin);
        layoutParams.width = ((IVipIconFactory) QRoute.api(IVipIconFactory.class)).getIconWidth(resources, uin);
        imageView.setImageDrawable(icon);
        return true;
    }

    @Override // com.tencent.mobileqq.vip.api.IVipIconUtils
    public void setVipIconForFriendList(@Nullable SingleLineTextView textView, @Nullable String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) textView, (Object) uin);
            return;
        }
        if (textView == null) {
            return;
        }
        Resources res = textView.getResources();
        if (uin == null) {
            textView.setCompoundDrawables(null, null, null);
            return;
        }
        IVasRecentData.FriendsVipData friendsVipData = ((IVasRecentData) QRoute.api(IVasRecentData.class)).getFriendsVipData(uin);
        IVipIconFactory iVipIconFactory = (IVipIconFactory) QRoute.api(IVipIconFactory.class);
        Intrinsics.checkNotNullExpressionValue(res, "res");
        com.tencent.mobileqq.vas.image.c icon = iVipIconFactory.getIcon(res, uin, friendsVipData);
        if (icon != null) {
            resizeVipIconToFixedHeight(res, icon);
        } else {
            icon = null;
        }
        com.tencent.mobileqq.vas.image.c icon2 = ((IVipIconExFactory) QRoute.api(IVipIconExFactory.class)).getIcon(res, friendsVipData);
        if (icon2 != null) {
            resizeVipIconToFixedHeight(res, icon2);
        } else {
            icon2 = null;
        }
        if (icon != null && icon2 != null) {
            textView.setCompoundDrawablePadding((int) al.a(textView.getContext(), 2.0f));
            textView.setCompoundDrawables(null, icon, icon2);
            textView.setNoCompoundPaddingRight(true);
        } else {
            if (icon != null) {
                textView.setCompoundDrawablePadding((int) al.a(textView.getContext(), 5.0f));
                textView.setCompoundDrawables(null, icon, null);
                textView.setNoCompoundPaddingRight(true);
                return;
            }
            textView.setCompoundDrawables(null, null, null);
        }
    }
}
