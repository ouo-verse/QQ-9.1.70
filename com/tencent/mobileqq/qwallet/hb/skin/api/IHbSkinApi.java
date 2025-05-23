package com.tencent.mobileqq.qwallet.hb.skin.api;

import android.app.Activity;
import android.os.ResultReceiver;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRemote;
import com.tencent.mobileqq.qwallet.hb.skin.HbSkinData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001JG\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00052#\u0010\t\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00030\nH&J$\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0005H'J.\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0011H'J*\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0011H'J\"\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u001a\u0010\u0016\u001a\u00020\u00142\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J\"\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u001a\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0004\u001a\u00020\u0005H&J8\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00052\u0014\u0010\u001e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u00030\nH&\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/skin/api/IHbSkinApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getSkinData", "", "skinId", "", "outerSkinId", "", "skinFrom", "receiver", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/qwallet/hb/skin/HbSkinData;", "Lkotlin/ParameterName;", "name", "hbSkinData", "getSkinDataFromLocal", "ipcGetSkinPopUrl", "Landroid/os/ResultReceiver;", "ipcGetSkinType", "isDefaultRedPocketSkin", "", "isLocalRedPocketSkin", "isQCircleRedPocketSkin", "isSupportSkinStory", "skinType", "isValidRedPocketSkin", "shareSkinArkToMsg", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "updateSkinData", "result", "qqpay-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IHbSkinApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class a {
        public static boolean a(@NotNull IHbSkinApi iHbSkinApi, int i3, @Nullable String str, int i16) {
            boolean z16;
            if (i16 != 0 || i3 != 0) {
                return false;
            }
            if (str != null && str.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                return false;
            }
            return true;
        }

        public static boolean b(@NotNull IHbSkinApi iHbSkinApi, int i3) {
            if (i3 == 0) {
                return true;
            }
            return false;
        }

        public static boolean c(@NotNull IHbSkinApi iHbSkinApi, @Nullable String str, int i3) {
            boolean z16;
            boolean z17;
            if (str != null) {
                if (str.length() > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    z16 = true;
                    if (!z16 && i3 == 1) {
                        return true;
                    }
                }
            }
            z16 = false;
            return !z16 ? false : false;
        }

        public static boolean d(@NotNull IHbSkinApi iHbSkinApi, int i3) {
            if ((i3 & 13) != 0) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0019  */
        /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static boolean e(@NotNull IHbSkinApi iHbSkinApi, int i3, @Nullable String str, int i16) {
            boolean z16;
            boolean z17;
            if (i16 == 0 && i3 > 0) {
                return true;
            }
            if (str != null) {
                if (str.length() > 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    z16 = true;
                    if (!z16) {
                        return true;
                    }
                    return false;
                }
            }
            z16 = false;
            if (!z16) {
            }
        }
    }

    void getSkinData(int skinId, @Nullable String outerSkinId, int skinFrom, @NotNull Function1<? super HbSkinData, Unit> receiver);

    @QRemote
    @Nullable
    HbSkinData getSkinDataFromLocal(int skinId, @Nullable String outerSkinId, int skinFrom);

    @QRemote
    void ipcGetSkinPopUrl(int skinId, @Nullable String outerSkinId, int skinFrom, @NotNull ResultReceiver receiver);

    @QRemote
    void ipcGetSkinType(int skinId, @Nullable String outerSkinId, int skinFrom, @NotNull ResultReceiver receiver);

    boolean isDefaultRedPocketSkin(int skinId, @Nullable String outerSkinId, int skinFrom);

    boolean isLocalRedPocketSkin(int skinFrom);

    boolean isQCircleRedPocketSkin(@Nullable String outerSkinId, int skinFrom);

    boolean isSupportSkinStory(int skinType);

    boolean isValidRedPocketSkin(int skinId, @Nullable String outerSkinId, int skinFrom);

    void shareSkinArkToMsg(@Nullable Activity activity, int skinId);

    void updateSkinData(int skinId, @Nullable String outerSkinId, int skinFrom, @NotNull Function1<? super HbSkinData, Unit> result);
}
