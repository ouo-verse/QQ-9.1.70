package com.tencent.mobileqq.proavatar.api.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.avatar.api.impl.b;
import com.tencent.mobileqq.avatar.utils.e;
import com.tencent.mobileqq.avatar.utils.f;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.proavatar.ProAvatarComponentInit;
import com.tencent.mobileqq.proavatar.api.IProAvatarUtilsApi;
import com.tencent.mobileqq.proavatar.info.db.AvatarInfoEntity;
import com.tencent.mobileqq.proavatar.merge.exception.AvatarException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.vas.api.IVasDataHelperApi;
import com.tencent.mobileqq.vas.pendant.api.ISpecialShapeAvatarMaskLayer;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vip.api.IVipDataUtils;
import com.tencent.mobileqq.vip.api.VipData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.avatar.bean.a;
import com.tencent.qqnt.avatar.core.ResourceOrganizer;
import com.tencent.qqnt.avatar.fetch.c;
import com.tencent.qqnt.avatar.meta.b;
import com.tencent.qqnt.ntrelation.vasinfo.bean.NTVasSimpleInfo;
import com.tencent.tavcut.core.render.exporter.ExportOutput;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0010\u0018\u0000 :2\u00020\u0001:\u0001;B\u0007\u00a2\u0006\u0004\b8\u00109Jf\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\"\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016J*\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J$\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020!0 2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001c\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010\u001b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0014\u0010&\u001a\u0004\u0018\u00010%2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J,\u0010+\u001a\u0004\u0018\u00010%2\u0006\u0010'\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u0007H\u0016J'\u0010.\u001a\u0004\u0018\u00010%2\u0006\u0010\b\u001a\u00020\u00072\f\u0010-\u001a\b\u0012\u0004\u0012\u00020%0,H\u0016\u00a2\u0006\u0004\b.\u0010/R\u001b\u00104\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001b\u00107\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u00101\u001a\u0004\b6\u00103\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/proavatar/api/impl/ProAvatarUtilsApiImpl;", "Lcom/tencent/mobileqq/proavatar/api/IProAvatarUtilsApi;", "", "uin", "", "enableVasAvatar", "enableVasPendant", "", "size", "vasPendantTarget", "vasAvatarShopSource", "vasAvatarUseSource", "peerUin", "peerUid", "", "Lcom/tencent/qqnt/avatar/bean/a;", "list", "isRefresh", "", "addVasBeansToList", "getComponentSwitch", "initProAvatarComponent", "isProAvatarDebug", "isQZoneAvatarBugfixSwitchOn", "isEnableMp4Avatar", "Ljava/io/File;", "getDownloadCacheDir", "headType", "Lcom/tencent/mobileqq/proavatar/e;", DownloadInfo.spKey_Config, "Lcom/tencent/qqnt/avatar/fetch/c;", "buildResourceFetchRequest", "", "", "getAvatarInfo", "Lcom/tencent/mobileqq/data/Setting;", "getAvatarInfoSetting", "Landroid/graphics/Bitmap;", "getTroopFaceBitmap", "faceType", "", "shape", "sizeType", "getFaceBitmap", "", "bitmapArr", "getGroupAvatar", "(I[Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;", "getTroopBitmapSwitch$delegate", "Lkotlin/Lazy;", "getGetTroopBitmapSwitch", "()Z", "getTroopBitmapSwitch", "oldAvatarSupportNineSizeSwitch$delegate", "getOldAvatarSupportNineSizeSwitch", "oldAvatarSupportNineSizeSwitch", "<init>", "()V", "Companion", "a", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class ProAvatarUtilsApiImpl implements IProAvatarUtilsApi {
    static IPatchRedirector $redirector_ = null;
    public static final int APERTURE_ENABLE = 1;

    @NotNull
    public static final String CONFIG_PROAVATAR_COMPONENT_ENABLE_SWITCH = "proavatar_component_enable_switch";

    @NotNull
    public static final String CONFIG_PROAVATAR_DEBUG_SWITCH = "proavatar_debug_switch";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "ProAvatarUtilsApiImpl";

    /* renamed from: getTroopBitmapSwitch$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy getTroopBitmapSwitch;

    /* renamed from: oldAvatarSupportNineSizeSwitch$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy oldAvatarSupportNineSizeSwitch;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/proavatar/api/impl/ProAvatarUtilsApiImpl$a;", "", "", "APERTURE_ENABLE", "I", "", "CONFIG_PROAVATAR_COMPONENT_ENABLE_SWITCH", "Ljava/lang/String;", "CONFIG_PROAVATAR_DEBUG_SWITCH", "TAG", "<init>", "()V", "qqavatar-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.proavatar.api.impl.ProAvatarUtilsApiImpl$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17815);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ProAvatarUtilsApiImpl() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(ProAvatarUtilsApiImpl$getTroopBitmapSwitch$2.INSTANCE);
            this.getTroopBitmapSwitch = lazy;
            lazy2 = LazyKt__LazyJVMKt.lazy(ProAvatarUtilsApiImpl$oldAvatarSupportNineSizeSwitch$2.INSTANCE);
            this.oldAvatarSupportNineSizeSwitch = lazy2;
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final void addVasBeansToList(final String uin, boolean enableVasAvatar, boolean enableVasPendant, int size, int vasPendantTarget, int vasAvatarShopSource, int vasAvatarUseSource, String peerUin, String peerUid, List<a> list, boolean isRefresh) {
        int i3;
        List<a> list2;
        NTVasSimpleInfo nTVasSimpleInfo;
        long j3;
        boolean z16 = false;
        if (vasPendantTarget == 9 && VasNormalToggle.VAS_BUG_115294496.isEnable(true)) {
            if (isRefresh) {
                ((IVipDataUtils) QRoute.api(IVipDataUtils.class)).requestAndUpdateData(uin, new Function0<Unit>(uin) { // from class: com.tencent.mobileqq.proavatar.api.impl.ProAvatarUtilsApiImpl$addVasBeansToList$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ String $uin;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                        this.$uin = uin;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) uin);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        QLog.i(ProAvatarUtilsApiImpl.TAG, 1, "uin:" + this.$uin + " update VipData success!");
                    }
                });
            }
            VipData vipDataForFriends = ((IVipDataUtils) QRoute.api(IVipDataUtils.class)).getVipDataForFriends(uin);
            if (vipDataForFriends.getPendantIsVip() && vipDataForFriends.getPendantItemId() > 0) {
                z16 = true;
            }
            if ((z16 ? vipDataForFriends : null) != null) {
                list.add(new f(1, uin, size, r16.getPendantItemId(), 0, null, vasPendantTarget, peerUin, peerUid, false, 0, 1536, null));
                return;
            }
            return;
        }
        NTVasSimpleInfo queryExtensionInfo = ((IVasDataHelperApi) QRoute.api(IVasDataHelperApi.class)).queryExtensionInfo(uin, false);
        if (queryExtensionInfo == null) {
            QLog.e(TAG, 1, "addVasBeansToList ");
            return;
        }
        boolean isEnable = VasNormalToggle.VAS_BUG_113735379.isEnable(true);
        int i16 = queryExtensionInfo.faceId;
        if (enableVasAvatar) {
            i3 = i16;
            list2 = list;
            list2.add(new e(1, uin, size, i16, isEnable ? ((IVipDataUtils) QRoute.api(IVipDataUtils.class)).getVipDataForFriends(uin).getVipNumberInfo(VipData.VipNumberInfo.APPID.Avatar, queryExtensionInfo.faceId) : null, vasAvatarShopSource, vasAvatarUseSource, peerUin, peerUid, false, ((IVipDataUtils) QRoute.api(IVipDataUtils.class)).getVipDataForFriends(uin).getSpecialAvatarId(), false, ExportOutput.VALUE_LEVEL_1440P_MAX_LENGTH, null));
            nTVasSimpleInfo = queryExtensionInfo;
        } else {
            i3 = i16;
            list2 = list;
            nTVasSimpleInfo = queryExtensionInfo;
        }
        long j16 = nTVasSimpleInfo.pendantId;
        int i17 = nTVasSimpleInfo.pendantDiyId;
        if (!enableVasPendant || j16 == 0) {
            j3 = j16;
        } else {
            j3 = j16;
            list2.add(new f(1, uin, size, j16, i17, isEnable ? ((IVipDataUtils) QRoute.api(IVipDataUtils.class)).getVipDataForFriends(uin).getVipNumberInfo(VipData.VipNumberInfo.APPID.Pendant, (int) nTVasSimpleInfo.pendantId) : null, vasPendantTarget, peerUin, peerUid, false, 0, 1536, null));
        }
        QLog.i("ProAvatar.AvatarLayoutApiImpl", 4, "setAvatar faceId: " + i3 + ", pendantId: " + j3);
    }

    private final boolean getGetTroopBitmapSwitch() {
        return ((Boolean) this.getTroopBitmapSwitch.getValue()).booleanValue();
    }

    private final boolean getOldAvatarSupportNineSizeSwitch() {
        return ((Boolean) this.oldAvatarSupportNineSizeSwitch.getValue()).booleanValue();
    }

    @Override // com.tencent.mobileqq.proavatar.api.IProAvatarUtilsApi
    @NotNull
    public c buildResourceFetchRequest(int headType, @NotNull String uin, @Nullable com.tencent.mobileqq.proavatar.e config) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (c) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(headType), uin, config);
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        return buildResourceFetchRequest(headType, uin, config, false);
    }

    @Override // com.tencent.mobileqq.proavatar.api.IProAvatarUtilsApi
    @NotNull
    public Map<String, Object> getAvatarInfo(int headType, @NotNull String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Map) iPatchRedirector.redirect((short) 10, (Object) this, headType, (Object) uin);
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        String faceKey = com.tencent.mobileqq.avatar.utils.c.j(headType, uin, 200);
        com.tencent.mobileqq.proavatar.info.a aVar = com.tencent.mobileqq.proavatar.info.a.f259616a;
        Intrinsics.checkNotNullExpressionValue(faceKey, "faceKey");
        return aVar.l(faceKey);
    }

    @Override // com.tencent.mobileqq.proavatar.api.IProAvatarUtilsApi
    @Nullable
    public Setting getAvatarInfoSetting(int headType, @Nullable String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Setting) iPatchRedirector.redirect((short) 11, (Object) this, headType, (Object) uin);
        }
        if (uin == null) {
            return null;
        }
        String faceKey = com.tencent.mobileqq.avatar.utils.c.j(headType, uin, 200);
        if (ProAvatarComponentInit.c()) {
            Intrinsics.checkNotNullExpressionValue(faceKey, "faceKey");
            AvatarInfoEntity a16 = ProAvatarComponentInit.a(faceKey, true);
            if (a16 != null) {
                return com.tencent.mobileqq.proavatar.info.db.a.a(a16);
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.proavatar.api.IProAvatarUtilsApi
    public boolean getComponentSwitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        Intrinsics.checkNotNullExpressionValue(QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations"), "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(CONFIG_PROAVATAR_COMPONENT_ENABLE_SWITCH, true);
        QLog.i(TAG, 1, "initComponentSwitch (server) " + isSwitchOn);
        return isSwitchOn;
    }

    @Override // com.tencent.mobileqq.proavatar.api.IProAvatarUtilsApi
    @NotNull
    public File getDownloadCacheDir() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (File) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return new File(MobileQQ.sMobileQQ.getCacheDir(), "proavatar_download_cache");
    }

    @Override // com.tencent.mobileqq.proavatar.api.IProAvatarUtilsApi
    @Nullable
    public Bitmap getFaceBitmap(int faceType, @Nullable String uin, byte shape, int sizeType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Bitmap) iPatchRedirector.redirect((short) 13, this, Integer.valueOf(faceType), uin, Byte.valueOf(shape), Integer.valueOf(sizeType));
        }
        return b.b(faceType, uin, shape, sizeType);
    }

    @Override // com.tencent.mobileqq.proavatar.api.IProAvatarUtilsApi
    @Nullable
    public Bitmap getGroupAvatar(int size, @NotNull Bitmap[] bitmapArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Bitmap) iPatchRedirector.redirect((short) 14, (Object) this, size, (Object) bitmapArr);
        }
        Intrinsics.checkNotNullParameter(bitmapArr, "bitmapArr");
        if (!getOldAvatarSupportNineSizeSwitch()) {
            return null;
        }
        try {
            Context applicationContext = MobileQQ.sMobileQQ.peekAppRuntime().getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "app.applicationContext");
            com.tencent.mobileqq.proavatar.merge.a aVar = new com.tencent.mobileqq.proavatar.merge.a(applicationContext);
            aVar.j(bitmapArr);
            aVar.n(new com.tencent.mobileqq.proavatar.merge.layout.a());
            aVar.p(size);
            aVar.l(1);
            aVar.m(false);
            return aVar.a();
        } catch (AvatarException e16) {
            QLog.e(TAG, 1, "AvatarException :" + e16);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.proavatar.api.IProAvatarUtilsApi
    @Nullable
    public Bitmap getTroopFaceBitmap(@Nullable String uin) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Bitmap) iPatchRedirector.redirect((short) 12, (Object) this, (Object) uin);
        }
        if (!getGetTroopBitmapSwitch()) {
            return null;
        }
        if (uin != null && uin.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        com.tencent.qqnt.avatar.meta.b b16 = new b.a(4, uin, 140, false).b();
        ResourceOrganizer.Companion companion = ResourceOrganizer.INSTANCE;
        MobileQQ sMobileQQ = MobileQQ.sMobileQQ;
        Intrinsics.checkNotNullExpressionValue(sMobileQQ, "sMobileQQ");
        Bitmap e16 = companion.e(sMobileQQ, b16);
        QLog.d(TAG, 4, "getTroopFaceBitmap memory cache [" + uin + "] " + e16);
        return e16;
    }

    @Override // com.tencent.mobileqq.proavatar.api.IProAvatarUtilsApi
    public void initProAvatarComponent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            ProAvatarComponentInit.d();
        }
    }

    @Override // com.tencent.mobileqq.proavatar.api.IProAvatarUtilsApi
    public boolean isEnableMp4Avatar() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return ProAvatarComponentInit.f259495a.e();
    }

    @Override // com.tencent.mobileqq.proavatar.api.IProAvatarUtilsApi
    public boolean isProAvatarDebug() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(CONFIG_PROAVATAR_DEBUG_SWITCH, false);
        QLog.i(TAG, 1, "isProAvatarDebug: " + isSwitchOn);
        return isSwitchOn;
    }

    @Override // com.tencent.mobileqq.proavatar.api.IProAvatarUtilsApi
    public boolean isQZoneAvatarBugfixSwitchOn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("101529", true);
        QLog.i(TAG, 1, "isQZoneAvatarBugfixSwitchOn: " + isSwitchOn);
        return isSwitchOn;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x012c  */
    @Override // com.tencent.mobileqq.proavatar.api.IProAvatarUtilsApi
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c buildResourceFetchRequest(int headType, @NotNull String uin, @Nullable com.tencent.mobileqq.proavatar.e config, boolean isRefresh) {
        ArrayList arrayList;
        b.a aVar;
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (c) iPatchRedirector.redirect((short) 9, this, Integer.valueOf(headType), uin, config, Boolean.valueOf(isRefresh));
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        int i3 = headType == 113 ? 4 : headType;
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "handleContactsLoadAvatar [" + i3 + "_" + uin + "]");
        }
        int l3 = config != null ? config.l() : 140;
        b.a aVar2 = new b.a(i3, uin, l3, false, 8, null);
        ArrayList arrayList2 = new ArrayList();
        if (i3 == 1 && config != null) {
            if (config.c() != 0) {
                arrayList2.add(new com.tencent.mobileqq.proavatar.bean.a(config.c() == 1, i3, uin, l3));
            }
            if (config.d()) {
                arrayList2.add(new com.tencent.qqnt.avatar.dynamic.a(1, i3, uin, l3));
            }
            if (isEnableMp4Avatar() && config.g()) {
                com.tencent.mobileqq.proavatar.a aVar3 = new com.tencent.mobileqq.proavatar.a(i3, uin, Integer.MIN_VALUE <= l3 && l3 < 101 ? 100 : 640);
                aVar3.g(config.p());
                arrayList2.add(aVar3);
            }
            if (config.o() == 9 || config.e() || config.f()) {
                arrayList = arrayList2;
                aVar = aVar2;
                addVasBeansToList(uin, config.e(), config.f(), l3, config.o(), config.m(), config.n(), config.k(), config.j(), arrayList2, isRefresh);
                if (config == null && config.h()) {
                    Iterator it = arrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        if (((a) obj).b() == 3) {
                            break;
                        }
                    }
                    if (obj == null && !((ISpecialShapeAvatarMaskLayer) QRoute.api(ISpecialShapeAvatarMaskLayer.class)).isSpecialShapeAvatar(uin)) {
                        aVar.a(FaceConstant.ZPLAN_OUT_BOUND_AVATAR_FLAG, Boolean.TRUE);
                        aVar.a("KEY_BEAN_KEY_SUFFIX", "sz");
                    }
                }
                aVar.a(FaceConstant.VAS_SPECIAL_SHAPE_MASK, Integer.valueOf(((IVipDataUtils) QRoute.api(IVipDataUtils.class)).getVipDataForFriends(uin).getSpecialAvatarId()));
                com.tencent.qqnt.avatar.meta.b b16 = aVar.b();
                if (config != null || (r0 = config.i()) == null) {
                    Drawable defaultFaceDrawable = BaseImageUtil.getDefaultFaceDrawable();
                }
                return new c(b16, arrayList, defaultFaceDrawable, null, false, null, 56, null);
            }
        }
        arrayList = arrayList2;
        aVar = aVar2;
        if (config == null && config.h()) {
        }
        aVar.a(FaceConstant.VAS_SPECIAL_SHAPE_MASK, Integer.valueOf(((IVipDataUtils) QRoute.api(IVipDataUtils.class)).getVipDataForFriends(uin).getSpecialAvatarId()));
        com.tencent.qqnt.avatar.meta.b b162 = aVar.b();
        if (config != null) {
        }
        Drawable defaultFaceDrawable2 = BaseImageUtil.getDefaultFaceDrawable();
        return new c(b162, arrayList, defaultFaceDrawable2, null, false, null, 56, null);
    }
}
