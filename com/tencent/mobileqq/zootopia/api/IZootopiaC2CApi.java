package com.tencent.mobileqq.zootopia.api;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.zootopia.FragmentSource;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@QRouteFactory(singleton = true)
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH&J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J4\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J@\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H&J=\u0010\u0019\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u001a2!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00030\u001cH&\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/zootopia/api/IZootopiaC2CApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "showAvatarPanel", "", "fm", "Landroidx/fragment/app/FragmentManager;", "panelHeight", "", "fragment", "Landroidx/fragment/app/Fragment;", "needMaskBackground", "", "initPanelHeight", "maxPanelHeight", "showSmallHomeDetailPanel", "homeownerUin", "", FavEmoConstant.ROAMING_TYPE_PANEL, "source", "Lcom/tencent/mobileqq/zootopia/FragmentSource;", "showZootopiaDetailPanel", "mapId", QQBrowserActivity.APP_PARAM, "", "", "startCloudMod", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "checkPass", "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZootopiaC2CApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class a {
        public static /* synthetic */ void a(IZootopiaC2CApi iZootopiaC2CApi, FragmentManager fragmentManager, int i3, Fragment fragment, boolean z16, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 8) != 0) {
                    z16 = false;
                }
                iZootopiaC2CApi.showAvatarPanel(fragmentManager, i3, fragment, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showAvatarPanel");
        }

        public static /* synthetic */ void b(IZootopiaC2CApi iZootopiaC2CApi, FragmentManager fragmentManager, String str, boolean z16, FragmentSource fragmentSource, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 16) != 0) {
                    i3 = ViewUtils.dpToPx(737.0f);
                }
                iZootopiaC2CApi.showSmallHomeDetailPanel(fragmentManager, str, z16, fragmentSource, i3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showSmallHomeDetailPanel");
        }

        public static /* synthetic */ void c(IZootopiaC2CApi iZootopiaC2CApi, FragmentManager fragmentManager, int i3, int i16, FragmentSource fragmentSource, Map map, int i17, Object obj) {
            if (obj == null) {
                if ((i17 & 2) != 0) {
                    i3 = ViewUtils.dpToPx(737.0f);
                }
                iZootopiaC2CApi.showZootopiaDetailPanel(fragmentManager, i3, i16, fragmentSource, map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showZootopiaDetailPanel");
        }
    }

    void showAvatarPanel(@NotNull FragmentManager fm5, int initPanelHeight, int maxPanelHeight, @NotNull Fragment fragment);

    void showAvatarPanel(@NotNull FragmentManager fm5, int panelHeight, @NotNull Fragment fragment, boolean needMaskBackground);

    void showSmallHomeDetailPanel(@NotNull FragmentManager fm5, @Nullable String homeownerUin, boolean needDownload, @NotNull FragmentSource source, int panelHeight);

    void showZootopiaDetailPanel(@NotNull FragmentManager fm5, int panelHeight, int mapId, @NotNull FragmentSource source, @Nullable Map<String, ? extends Object> extraParams);

    void startCloudMod(@Nullable String homeownerUin, @NotNull ZootopiaSource source, @NotNull Function1<? super Boolean, Unit> callback);
}
