package com.tencent.mobileqq.guild.api;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0011\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0016\u001a\u00020\rH&J\b\u0010\u0017\u001a\u00020\u0018H&J\b\u0010\u0019\u001a\u00020\rH&J_\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\r2M\u0010\u001d\u001aI\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u001c\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u001b0\u001eH&J>\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&2$\b\u0002\u0010'\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030(j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`)H&J(\u0010*\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020\u0003H&J\u0018\u0010/\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u00032\u0006\u00100\u001a\u000201H&J\u0018\u00102\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u0003H&J\b\u00103\u001a\u00020\u0018H&J\\\u00104\u001a\u00020\u001b2\u0006\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u00032\b\b\u0002\u00105\u001a\u00020\u00032\b\b\u0002\u00106\u001a\u00020\u00032\b\b\u0002\u00107\u001a\u00020\u00032$\b\u0002\u00108\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030(j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`)H&JR\u00109\u001a\u00020\u001b2\b\b\u0002\u00105\u001a\u00020\u00032\u0006\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u00032\b\b\u0002\u0010:\u001a\u00020\r2$\b\u0002\u00108\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030(j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`)H&J\u001a\u0010;\u001a\u00020\u001b2\b\u0010<\u001a\u0004\u0018\u00010\u00032\u0006\u0010$\u001a\u00020\u0003H&JU\u0010=\u001a\u00020\u001b2K\u0010\u001d\u001aG\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(>\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(?\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(@\u0012\u0004\u0012\u00020\u001b0\u001eH&J\u001f\u0010A\u001a\u00020\u001b2\b\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010D\u001a\u00020EH&\u00a2\u0006\u0002\u0010FR\u0014\u0010\u0002\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u000f\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/guild/api/IGuildMediaChannelApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "CLICK_DETAIL_FOR_MORE_FREE_GIFT", "", "getCLICK_DETAIL_FOR_MORE_FREE_GIFT", "()Ljava/lang/String;", "CLICK_GOTO_PROFILE_PAGE_FREE_GIFT", "getCLICK_GOTO_PROFILE_PAGE_FREE_GIFT", "CLICK_GOTO_PROFILE_PAGE_PAY_GIFT", "getCLICK_GOTO_PROFILE_PAGE_PAY_GIFT", "CLICK_IMMEDIATELY_SEND_FREE_GIFT", "getCLICK_IMMEDIATELY_SEND_FREE_GIFT", "HAS_IN_MIC_QUEUE", "", "getHAS_IN_MIC_QUEUE", "()I", "HAS_OPEN_MIC", "getHAS_OPEN_MIC", "HAS_RAISE_HAND", "getHAS_RAISE_HAND", "NONE", "getNONE", "checkHasAlreadyDoRequest", "curChannelHasInputPermission", "", "getDefaultGiftDrawableResId", "getGiftResFilePathByMaterialId", "", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "callback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "suc", "filePath", "handleCommonAioTipsClick", "tag", "view", "Landroid/view/View;", "paramMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "handleCommonNickNameClick", "guildId", "channelId", "channelType", "tinyId", "handleGiftItemTipsClick", "extra", "", "handleGiftNickNameClick", "isLowDisplayMode", "openGiftRankingH5", "url", "rankType", "durationType", QQBrowserActivity.APP_PARAM, "openGiftTaskH5", "panelHeight", "openMediaThemeChooseDialog", "openIndex", "openMicByClickInviteMsg", "retCode", "retMsg", "needToast", "showPanel", "receiverTinyId", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroidx/fragment/app/FragmentActivity;", "(Ljava/lang/Long;Landroidx/fragment/app/FragmentActivity;)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {""})
/* loaded from: classes12.dex */
public interface IGuildMediaChannelApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class a {
        @NotNull
        public static String a(@NotNull IGuildMediaChannelApi iGuildMediaChannelApi) {
            return "click_detail_for_more_free_gift";
        }

        @NotNull
        public static String b(@NotNull IGuildMediaChannelApi iGuildMediaChannelApi) {
            return "click_goto_profile_page_free_gift";
        }

        @NotNull
        public static String c(@NotNull IGuildMediaChannelApi iGuildMediaChannelApi) {
            return "click_goto_profile_page_pay_gift";
        }

        @NotNull
        public static String d(@NotNull IGuildMediaChannelApi iGuildMediaChannelApi) {
            return "click_immediately_send_free_gift";
        }

        public static int e(@NotNull IGuildMediaChannelApi iGuildMediaChannelApi) {
            return 2;
        }

        public static int f(@NotNull IGuildMediaChannelApi iGuildMediaChannelApi) {
            return 1;
        }

        public static int g(@NotNull IGuildMediaChannelApi iGuildMediaChannelApi) {
            return 3;
        }

        public static int h(@NotNull IGuildMediaChannelApi iGuildMediaChannelApi) {
            return 0;
        }

        public static /* synthetic */ void i(IGuildMediaChannelApi iGuildMediaChannelApi, String str, String str2, String str3, String str4, String str5, HashMap hashMap, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    str3 = "";
                }
                String str6 = str3;
                if ((i3 & 8) != 0) {
                    str4 = "contribution";
                }
                String str7 = str4;
                if ((i3 & 16) != 0) {
                    str5 = "day";
                }
                String str8 = str5;
                if ((i3 & 32) != 0) {
                    hashMap = new HashMap();
                }
                iGuildMediaChannelApi.openGiftRankingH5(str, str2, str6, str7, str8, hashMap);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openGiftRankingH5");
        }

        public static /* synthetic */ void j(IGuildMediaChannelApi iGuildMediaChannelApi, String str, String str2, String str3, int i3, HashMap hashMap, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 1) != 0) {
                    str = "";
                }
                String str4 = str;
                if ((i16 & 8) != 0) {
                    i3 = 0;
                }
                int i17 = i3;
                if ((i16 & 16) != 0) {
                    hashMap = new HashMap();
                }
                iGuildMediaChannelApi.openGiftTaskH5(str4, str2, str3, i17, hashMap);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openGiftTaskH5");
        }
    }

    int checkHasAlreadyDoRequest();

    boolean curChannelHasInputPermission();

    @NotNull
    String getCLICK_DETAIL_FOR_MORE_FREE_GIFT();

    @NotNull
    String getCLICK_GOTO_PROFILE_PAGE_FREE_GIFT();

    @NotNull
    String getCLICK_GOTO_PROFILE_PAGE_PAY_GIFT();

    @NotNull
    String getCLICK_IMMEDIATELY_SEND_FREE_GIFT();

    int getDefaultGiftDrawableResId();

    void getGiftResFilePathByMaterialId(int materialId, @NotNull Function3<? super Boolean, ? super Integer, ? super String, Unit> callback);

    int getHAS_IN_MIC_QUEUE();

    int getHAS_OPEN_MIC();

    int getHAS_RAISE_HAND();

    int getNONE();

    void handleCommonAioTipsClick(@NotNull String tag, @NotNull View view, @NotNull HashMap<String, String> paramMap);

    void handleCommonNickNameClick(@NotNull String guildId, @NotNull String channelId, int channelType, @NotNull String tinyId);

    void handleGiftItemTipsClick(@NotNull String tag, @NotNull Object extra);

    void handleGiftNickNameClick(@NotNull String guildId, @NotNull String tinyId);

    boolean isLowDisplayMode();

    void openGiftRankingH5(@NotNull String guildId, @NotNull String channelId, @NotNull String url, @NotNull String rankType, @NotNull String durationType, @NotNull HashMap<String, String> extraParams);

    void openGiftTaskH5(@NotNull String url, @NotNull String guildId, @NotNull String channelId, int panelHeight, @NotNull HashMap<String, String> extraParams);

    void openMediaThemeChooseDialog(@Nullable String openIndex, @NotNull String tag);

    void openMicByClickInviteMsg(@NotNull Function3<? super Integer, ? super String, ? super Boolean, Unit> callback);

    void showPanel(@Nullable Long receiverTinyId, @NotNull FragmentActivity activity);
}
