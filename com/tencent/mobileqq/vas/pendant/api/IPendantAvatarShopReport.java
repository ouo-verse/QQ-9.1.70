package com.tencent.mobileqq.vas.pendant.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IPendantAvatarShopReport extends QRouteApi {
    public static final int ACT_CLICK = 102;
    public static final int ACT_EXPOSE = 101;
    public static final int ACT_SET = 113;
    public static final int ACT_TYR_PAY = 109;
    public static final int MODULE_EXPOSE = 111;
    public static final int PAGE_EXPOSE = 100;
    public static final int TAB_MODULE_EXPOSE = 112;

    String getTraceDetail(int i3, int i16, int i17, int i18, String str, String str2);

    void goSplendidShop();

    void onAdItem(int i3, int i16, int i17, String str, String str2);

    void onAvatarButtonAction(int i3);

    void onCancelButton(int i3);

    void onDynamicButton(int i3);

    void onHeadAvatarItemClick();

    void onHeadQQShowItem(int i3);

    void onHeadSplendidItem(int i3, String str);

    void onMineChooseListExpose();

    void onMineIconClick();

    void onMyAvatarButton(int i3);

    void onMyPendantButton(int i3);

    void onPay(int i3, int i16);

    void onPayBanner(int i3);

    void onPendantButtonAction(int i3);

    void onPendantItem(int i3, int i16, int i17, String str);

    void onPendantSet(int i3, int i16, String str);

    void onPendantShopExpose();

    void onPendantTab(int i3, int i16);

    void onPendantTabItemExpose(int i3);

    void onPendantTryPay(int i3, int i16, int i17, String str);

    void onPersonalItem(int i3, int i16, int i17, String str);

    void onPersonalSet(int i3, int i16, String str);

    void onPersonalShopExpose();

    void onPersonalTab(int i3, int i16);

    void onPersonalTabItemExpose(int i3);

    void onPersonalTryPay(int i3, int i16, int i17, String str);

    void onPhotoButton(int i3);

    void onPictureButton(int i3);

    void onPreviewClick();

    void onPreviewListExpose();

    void onQQShowItem(int i3, int i16);

    void onQQShowSet(int i3);

    void onQQShowShopExpose();

    void onSeeHistoryButton(int i3);

    void onShopFirstViewExpose();

    void onShopFirstViewExposeNew();

    void onShopHeadViewExpose();

    void onSplendidShopExpose(boolean z16);

    void onSplendidShopItem(int i3, int i16);

    void onSplendidShopSet(int i3);

    void setPositionId(String str);
}
