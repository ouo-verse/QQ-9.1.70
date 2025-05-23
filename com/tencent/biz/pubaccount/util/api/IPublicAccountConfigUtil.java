package com.tencent.biz.pubaccount.util.api;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;

@QAPI(process = {"all"})
/* loaded from: classes4.dex */
public interface IPublicAccountConfigUtil extends QRouteApi {
    public static final int MERGE_KANDIAN_FOLDER_ID = 3;
    public static final int PUBLIC_ACCOUNT_SUBSCRIPT_FOLDER_ID = 1;
    public static final int PUBLIC_ACCOUNT_XIN_KANDIAN_FOLDER_ID = 2;
    public static final String READINJOY_SEARCH_JUMP_URL_DEFAULT = "https://sou.qq.com/kandian.html?_bid=2958&_wv=3&keyword=$KEYWORD$";
    public static final String SSO_COMMOND_NET_CONNECT_INFO = "PubAccountSvc.net_connect_info";
    public static final String TAG = "PublicAccountConfigUtil";

    boolean checkNeedLongMessageChannel(String str);

    boolean checkPublicAccountCenterUrlConfigData(String str);

    ArrayList<String> getBigDataChannelWhiteList();

    Drawable getDefaultDrawable(Context context, int i3);

    boolean getDisableBigDataChannel();

    a getFolder(AppInterface appInterface, Context context, int i3);

    int getImageCollectionPreload();

    int getImageCollectionPreloadCover();

    int getImageCollectionPreloadImage();

    String getMergerKandianName(AppInterface appInterface, Context context);

    String getName(AppInterface appInterface, Context context, int i3);

    String getPublicAccountCategoryUrl();

    String getPublicAccountCenterUrlConfigData(AppInterface appInterface);

    int getPublicAccountCenterUrlConfigVersionCode(AppInterface appInterface);

    int getPublicAccountQQMailConfigVersionCode(AppInterface appInterface);

    String getPublicAccountTitle();

    long getReadInJoyADBackgroundShowTime();

    int getReadInJoyIpConnectReportSwitch();

    String getReadInJoyIpConnectReportTail();

    String getReadInJoyPreloadToolConfig();

    String getReadInJoyReleaseWebServiceConfig();

    String getReadInJoyflingLToRHost();

    String getReadinjoySearchUrl();

    void getServiceAccountFolderConfigData(AppInterface appInterface, boolean z16);

    int getServiceAccountFolderConfigVersionCode(AppInterface appInterface);

    String getServiceAccountFolderIcon();

    String getServiceAccountFolderName();

    String getServiceAccountTitle();

    boolean getServiceFolderRedDelete();

    String getSubscriptName(AppInterface appInterface, Context context);

    String getXinKandianName(AppInterface appInterface, Context context);

    void initPublicAccountConfigFolder(a aVar, AppInterface appInterface, Context context, int i3, String str, String str2);

    boolean isClearAllPublicAccountFolderRedNumber();

    boolean isDisableBigDataChannel();

    boolean isNeedPABottomBar();

    boolean isPreloadTooProcess();

    boolean isPreloadToolProcess();

    boolean isReadInJoyFeedsImagePreload();

    boolean isReadInJoyFeedsPreload();

    boolean isReadInJoyFeedsPreload2G();

    boolean isReadInJoyFeedsPreload3G();

    boolean isReadInJoyFeedsPreload4G();

    boolean isReadInJoyFeedsPreloadWifi();

    boolean isReadInJoyIpConnect();

    boolean isReadInJoyLoadImg();

    boolean isServiceAccountFolderDelete();

    boolean isServiceFolderRedSpots();

    boolean isServiceFolderRedspots();

    boolean isSwitchToCertifiedAccount();

    void loadPublicAccountCenterUrlConfig(AppInterface appInterface, String str);

    int readInJoyADGuideCardShowTime();

    boolean readInJoyIpConnect();

    int readInJoyIpConnectReportSwitch();

    String readInJoyIpConnectReportTail();

    String readInJoyPreloadToolConfig();

    String readInJoyReleaseWebServiceConfig();

    void resetPublicAccountConfig(String str);

    void setBigDataChannelWhiteList(ArrayList<String> arrayList);

    void setDisableBigDataChannel(boolean z16);

    void setImageCollectionPreload(int i3);

    void setImageCollectionPreloadCover(int i3);

    void setImageCollectionPreloadImage(int i3);

    void setNeedPABottomBar(boolean z16);

    void setPreloadToolProcess(boolean z16);

    void setReadInJoyADBackgroundShowTime(long j3);

    void setReadInJoyFeedsImagePreload(boolean z16);

    void setReadInJoyFeedsPreload(boolean z16);

    void setReadInJoyFeedsPreload2G(boolean z16);

    void setReadInJoyFeedsPreload3G(boolean z16);

    void setReadInJoyFeedsPreload4G(boolean z16);

    void setReadInJoyFeedsPreloadWifi(boolean z16);

    void setReadInJoyIpConnect(boolean z16);

    void setReadInJoyIpConnectReportSwitch(int i3);

    void setReadInJoyIpConnectReportTail(String str);

    void setReadInJoyLoadImg(boolean z16);

    void setReadInJoyPreloadToolConfig(String str);

    void setReadInJoyReleaseWebServiceConfig(String str);

    void setReadInJoyflingLToRHost(String str);

    void setServiceAccountFolderIcon(String str);

    void setServiceAccountFolderName(String str);

    void setServiceFolderDelete(boolean z16);

    void setServiceFolderRedCleanAfterEnter(boolean z16);

    void setServiceFolderRedDelete(boolean z16);

    void setServiceFolderRedSpots(boolean z16);

    void updatePublicAccountCenterUrlConfigData(AppInterface appInterface);

    void updatePublicAccountCenterUrlConfigVersionCode(AppInterface appInterface, int i3);

    void updatePublicAccountQQMailConfigData(AppInterface appInterface, String str, int i3);

    void updateServiceAccountFolderConfigData(AppInterface appInterface);

    boolean updateSubscriptRecommendConfig(AppInterface appInterface, String str);

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f80193a;

        /* renamed from: b, reason: collision with root package name */
        public String f80194b;

        /* renamed from: c, reason: collision with root package name */
        public String f80195c;

        /* renamed from: d, reason: collision with root package name */
        public Drawable f80196d;

        /* renamed from: e, reason: collision with root package name */
        public String f80197e;

        public a() {
            this.f80193a = 0;
            this.f80194b = "";
            this.f80195c = "";
            this.f80196d = null;
            this.f80197e = "";
        }

        public Drawable a() {
            return this.f80196d;
        }

        public int b() {
            return this.f80193a;
        }

        public String c() {
            return this.f80194b;
        }

        public String d(int i3) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        return "";
                    }
                    return String.valueOf(AppConstants.KANDIAN_MERGE_UIN);
                }
                return String.valueOf(AppConstants.NEW_KANDIAN_UIN);
            }
            return String.valueOf(AppConstants.VALUE.UIN_TYPE_TROOP_BAR_ASSIST);
        }

        public void e(Drawable drawable) {
            this.f80196d = drawable;
        }

        public a(AppInterface appInterface, Context context, int i3, int i16, int i17) {
            this.f80194b = "";
            this.f80195c = "";
            this.f80196d = null;
            this.f80197e = "";
            this.f80193a = i3;
            this.f80194b = context.getString(i16);
            this.f80195c = "";
            try {
                this.f80196d = context.getResources().getDrawable(i17);
            } catch (Exception unused) {
            }
            this.f80197e = d(i3);
        }
    }
}
