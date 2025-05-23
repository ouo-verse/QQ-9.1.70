package com.tencent.biz.qqcircle.immersive.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.Window;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Size;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.part.Cdo;
import com.tencent.biz.qqcircle.immersive.tab.QFSFolderTabFragment;
import com.tencent.biz.qqcircle.immersive.tab.QFSFriendTabFragment;
import com.tencent.biz.qqcircle.immersive.views.banner.bottom.QFSFeedShareQQGroupView;
import com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow.QFSBottomConfigGuideFollowInfo;
import com.tencent.biz.qqcircle.immersive.views.banner.bottom.recommend.QFSBottomRecInfo;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.utils.cq;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.auto.engine.loader.ASEngineUtils;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import com.tencent.mobileqq.qcircle.api.global.QFSTeenModeConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.qui.immersive.NavigatorUpdateTask;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.treasurecard.api.IVasFTManager;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.wink.api.IQQWinkEditorResAPI;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.report.capability.postprocess.TVKDevicePostProcessCapabilityReportConstant;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.text.rich.span.BoldClickableSpan;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.helpers.QCircleFollowManager;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StDebugInfo;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudRead$StChoiceQuestionBanner;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import k30.e;
import org.jetbrains.annotations.Contract;
import tianshu.QQCircleTianShu$AdItem;
import tianshu.QQCircleTianShu$AdPlacementInfo;
import tianshu.QQCircleTianShu$RspEntry;

/* compiled from: P */
/* loaded from: classes4.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f90234a = false;

    /* renamed from: b, reason: collision with root package name */
    public static volatile int f90235b = -1;

    /* renamed from: c, reason: collision with root package name */
    private static int f90236c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f90237d;

    /* renamed from: e, reason: collision with root package name */
    private static final List<String> f90238e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private static int f90239f = -1;

    public static e30.b A(e30.b bVar) {
        List<e30.b> D = D(bVar);
        if (D != null && D.size() > 0) {
            return D.get(0);
        }
        return bVar;
    }

    public static boolean A0(e30.b bVar) {
        if (bVar == null || bVar.g() == bVar.e()) {
            return false;
        }
        return true;
    }

    public static int B() {
        if (f90236c != 0) {
            QLog.i("QFSCommonUtil", 1, "[getPersonalRecommendSwitchPanelShowedTimes] cache showed times:" + f90236c);
            return f90236c;
        }
        f90236c = uq3.k.a().e("sp_key_personal_recommend_switch_panel_showed_times", 0);
        QLog.i("QFSCommonUtil", 1, "[getPersonalRecommendSwitchPanelShowedTimes] showed times:" + f90236c);
        return f90236c;
    }

    public static boolean B0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StFeed feedCloudMeta$StFeed2) {
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed2 != null) {
            return feedCloudMeta$StFeed.f398449id.get().equals(feedCloudMeta$StFeed2.f398449id.get());
        }
        return false;
    }

    public static int C(e30.b bVar) {
        if (V(bVar)) {
            if (s0(bVar)) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    public static boolean C0(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        if (feedCloudMeta$StUser == null) {
            QLog.d("QFSCommonUtil", 1, "[isSamePosterFollowBtnGroupCanShow] user should not be null.");
            return false;
        }
        String str = feedCloudMeta$StUser.f398463id.get();
        int e16 = uq3.k.a().e(str + "sp_key_follow_button_group_display_count_author", 0);
        QLog.i("QFSCommonUtil", 1, "[isSamePosterFollowBtnGroupCanShow] showed times:" + e16);
        long f16 = uq3.k.a().f(str + "sp_key_follow_button_group_display_timestamp", 0L);
        if (f16 != 0 && uq3.n.b(System.currentTimeMillis(), f16, uq3.c.U1())) {
            QLog.d("QFSCommonUtil", 1, "[isSamePosterFollowBtnGroupCanShow] is expired.");
            uq3.k.a().m(str + "sp_key_follow_button_group_display_count_author", 0);
        } else if (e16 >= uq3.c.T1()) {
            QLog.d("QFSCommonUtil", 1, "[isSamePosterFollowBtnGroupCanShow] is arrive max times, return.");
            return false;
        }
        return true;
    }

    public static List<e30.b> D(e30.b bVar) {
        if (bVar != null && bVar.b("FEED_BOTTOM_RECOMMEND_FEED") != null) {
            return (List) bVar.b("FEED_BOTTOM_RECOMMEND_FEED");
        }
        return null;
    }

    public static boolean D0(e30.b bVar, int i3, String str) {
        if (bVar != null && bVar.g() != null) {
            FeedCloudMeta$StFeed g16 = bVar.g();
            if (Q(bVar) || R(bVar)) {
                return true;
            }
            if ((!w() && !QCircleHostGlobalInfo.isWifiState() && i() != -1) || com.tencent.biz.qqcircle.immersive.views.banner.bottom.autoslideguide.a.b(g16, i3, str) || V(bVar) || ak.a().f(bVar)) {
                return true;
            }
            if ((u0(g16.poster) && g16.promoteInfo.usePromoteTicket.get()) || QFSFeedShareQQGroupView.E(g16) || c40.a.f(g16) || c40.d.h(g16) || c40.c.b(g16)) {
                return true;
            }
            PBRepeatField<Integer> pBRepeatField = g16.opMask2;
            if (pBRepeatField != null && pBRepeatField.get().contains(16)) {
                return true;
            }
            if (g16.musicInfo.sameMusicGuideButton.isButtonDisplayed.get() && !TextUtils.isEmpty(g16.musicInfo.musicName.get())) {
                return true;
            }
        }
        return false;
    }

    public static int E(e30.b bVar) {
        if (bVar != null && bVar.g() != null) {
            if (!TextUtils.isEmpty(bVar.g().recomInfo.recomReasonV2.recomReason.get()) || bVar.g().recomInfo.recomReasonV2.recomUserInfo.size() != 0) {
                if (X(bVar)) {
                    return 3;
                }
                if (n0(bVar.g())) {
                    return 4;
                }
                if (bVar.g().recomInfo.recomReasonV2.recomUserInfo.size() == 0) {
                    return 1;
                }
                return 2;
            }
            return 0;
        }
        return 0;
    }

    public static boolean E0() {
        if (!QCirclePanelStateEvent.isAnyPanelShowing() && (QCircleToast.f() || QCircleToast.g())) {
            return true;
        }
        return false;
    }

    public static String F(int i3) {
        if (i3 == 1) {
            return QCircleDaTongConstant.ElementParamValue.FOLLOWED;
        }
        if (i3 == 2) {
            return QCircleDaTongConstant.ElementParamValue.FOLLOWBACK;
        }
        if (i3 == 3) {
            return QCircleDaTongConstant.ElementParamValue.MUTUAL;
        }
        return "follow";
    }

    public static boolean F0() {
        return f90237d;
    }

    public static int G(e30.b bVar) {
        if (bVar != null && bVar.b("FEED_BOTTOM_REC_INFO") != null) {
            return ((QFSBottomRecInfo) bVar.b("FEED_BOTTOM_REC_INFO")).getSelectedPos();
        }
        return 0;
    }

    public static boolean G0(e30.b bVar) {
        if (bVar != null && bVar.b("KEY_TAKE_THE_SAME_STYLE_HAS_STRENGTHENED") != null) {
            Object b16 = bVar.b("KEY_TAKE_THE_SAME_STYLE_HAS_STRENGTHENED");
            if (b16 instanceof Boolean) {
                return ((Boolean) b16).booleanValue();
            }
        }
        return false;
    }

    public static FeedCloudCommon$Entry H() {
        FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
        String session = QCircleNativeSessionManager.g().getSession();
        feedCloudCommon$Entry.key.set("DatongSessionID");
        feedCloudCommon$Entry.value.set(session);
        return feedCloudCommon$Entry;
    }

    public static boolean H0(QFSBaseFragment qFSBaseFragment) {
        if (!Cdo.A9() && (qFSBaseFragment == null || qFSBaseFragment.getPageId() != 504)) {
            if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
                QLog.d("QFSCommonUtil", 1, "[isTeenModeWindowCanShow] study mode switch is true");
                return false;
            }
            QLog.d("QFSCommonUtil", 1, "[isTeenModeWindowCanShow] isTeenModeWindowShownMoreThanOneDay = " + QFSTeenModeConfig.isTeenModeWindowShownMoreThanOneDay() + ", getIsNeedShowTeenModeWindow = " + QFSTeenModeConfig.getIsNeedShowTeenModeWindow());
            if (!QFSTeenModeConfig.isTeenModeWindowShownMoreThanOneDay() || !QFSTeenModeConfig.getIsNeedShowTeenModeWindow()) {
                return false;
            }
            QLog.d("QFSCommonUtil", 1, "[isTeenModeWindowCanShow] Teen Mode Window has showed");
            return true;
        }
        QLog.d("QFSCommonUtil", 1, "[isTeenModeWindowCanShow] Teen Mode Window Should not be showed");
        return false;
    }

    public static String I(e30.b bVar) {
        if (bVar != null && bVar.g() != null) {
            return A(bVar).e().buttomBanner.title.get();
        }
        return "";
    }

    public static boolean I0(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        float f16;
        if (feedCloudMeta$StFeed == null) {
            return false;
        }
        if (feedCloudMeta$StFeed.video.orientation.get() != 2 && com.tencent.biz.qqcircle.immersive.adapter.n.e(feedCloudMeta$StFeed) == 4003) {
            int i3 = feedCloudMeta$StFeed.video.width.get();
            int i16 = feedCloudMeta$StFeed.video.height.get();
            if (i16 == 0) {
                f16 = 0.0f;
            } else {
                f16 = i3 / i16;
            }
            if (f16 < 1.3333334f) {
                return false;
            }
            return true;
        }
        if (feedCloudMeta$StFeed.video.orientation.get() != 2) {
            return false;
        }
        return true;
    }

    public static boolean J(String str) {
        return uq3.k.a().c(str + "sp_key_has_shared_owner_feed", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void J0() {
        IVasFTManager iVasFTManager;
        IVasService service = VasUtil.getService();
        if (service != null) {
            iVasFTManager = service.getVasFtManager();
        } else {
            iVasFTManager = null;
        }
        if (iVasFTManager != null) {
            Integer valueOf = Integer.valueOf(iVasFTManager.obtainCardState("040"));
            QLog.i("QFSCommonUtil", 1, "[getCardState] cardState = " + valueOf);
            if (valueOf instanceof Integer) {
                f90235b = valueOf.intValue();
            }
        }
    }

    public static int K(@NonNull Context context) {
        int topHeight = DisplayUtil.getTopHeight(context);
        if (topHeight == 0) {
            return context.getResources().getDimensionPixelSize(R.dimen.title_bar_height);
        }
        return topHeight;
    }

    public static List<e30.b> K0(List<e30.b> list, List<e30.b> list2) {
        if (list2 == null) {
            return list;
        }
        int size = list.size();
        for (e30.b bVar : list2) {
            boolean z16 = false;
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    break;
                }
                if (B0(list.get(i3).g(), bVar.g())) {
                    list.set(i3, bVar);
                    z16 = true;
                    break;
                }
                i3++;
            }
            if (!z16) {
                list.add(bVar);
                size++;
            }
        }
        return list;
    }

    public static QQCircleTianShu$AdItem L(FeedCloudMeta$StFeed feedCloudMeta$StFeed, int i3) {
        QQCircleTianShu$AdPlacementInfo qQCircleTianShu$AdPlacementInfo;
        if (feedCloudMeta$StFeed == null) {
            return null;
        }
        Iterator<QQCircleTianShu$RspEntry> it = feedCloudMeta$StFeed.tianshuEntry.get().iterator();
        while (true) {
            if (it.hasNext()) {
                QQCircleTianShu$RspEntry next = it.next();
                if (next.key.get() == i3) {
                    qQCircleTianShu$AdPlacementInfo = next.value;
                    break;
                }
            } else {
                qQCircleTianShu$AdPlacementInfo = null;
                break;
            }
        }
        if (qQCircleTianShu$AdPlacementInfo == null) {
            return null;
        }
        List<QQCircleTianShu$AdItem> list = qQCircleTianShu$AdPlacementInfo.lst.get();
        if (list.size() == 0) {
            return null;
        }
        return list.get(0);
    }

    public static void L0() {
        f90238e.clear();
    }

    public static String M(List<FeedCloudMeta$StUser> list) {
        if (RFSafeListUtils.isEmpty(list)) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < list.size(); i3++) {
            FeedCloudMeta$StUser feedCloudMeta$StUser = list.get(i3);
            if (feedCloudMeta$StUser != null) {
                sb5.append(feedCloudMeta$StUser.f398463id.get());
                if (i3 < list.size() - 1) {
                    sb5.append("|");
                }
            }
        }
        return sb5.toString();
    }

    public static void M0(Context context, View view) {
        if (context != null && view != null && !FontSettingManager.isFontSizeNormal()) {
            FontSettingManager.resetViewSize2Normal(context, view);
        }
    }

    public static String N(String str) {
        if (str != null && str.trim().length() != 0) {
            int indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
            if (indexOf == -1) {
                return str;
            }
            return str.substring(0, indexOf);
        }
        return str;
    }

    public static void N0(boolean z16) {
        f90234a = z16;
        uq3.q.c(RFWApplication.getApplication(), "sp_key_has_show_entrance_free_flow_view", String.valueOf(z16));
        QLog.i("QFSCommonUtil", 1, "[setHasShowFreeFlowView] = " + z16);
    }

    @Size(2)
    public static CharSequence[] O(FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str, BoldClickableSpan.OnClickBoldTextListener onClickBoldTextListener, boolean z16) {
        CharSequence[] charSequenceArr = new CharSequence[2];
        if (TextUtils.isEmpty(str)) {
            charSequenceArr[0] = "";
            charSequenceArr[1] = "";
            return charSequenceArr;
        }
        String d16 = com.tencent.biz.qqcircle.utils.bh.d(feedCloudMeta$StFeed.extInfo.get(), "contentHasTitle");
        if (QLog.isDevelopLevel()) {
            QLog.d("QFSCommonUtil", 4, "[setTitleAndDesc] content = " + str + ", hasTitle = " + d16);
        }
        if (!"1".equals(d16)) {
            charSequenceArr[0] = "";
            charSequenceArr[1] = c(feedCloudMeta$StFeed, str, onClickBoldTextListener, z16);
            return charSequenceArr;
        }
        Matcher matcher = Pattern.compile(RedTouch.NEWLINE_CHAR).matcher(str);
        if (matcher.find()) {
            charSequenceArr[0] = str.substring(0, matcher.start());
            charSequenceArr[1] = c(feedCloudMeta$StFeed, str.substring(matcher.end()), onClickBoldTextListener, z16);
        } else {
            charSequenceArr[0] = str;
            charSequenceArr[1] = "";
        }
        return charSequenceArr;
    }

    public static void O0(boolean z16) {
        f90237d = z16;
    }

    public static boolean P(e30.b bVar) {
        if (bVar == null || bVar.g() == null) {
            return false;
        }
        boolean T = T(bVar);
        boolean W = W(bVar);
        if (!T || W) {
            return false;
        }
        return true;
    }

    public static void P0(ArrayList<QFSFolderTabFragment> arrayList) {
        if (uq3.c.E()) {
            Iterator<QFSFolderTabFragment> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next() instanceof QFSFriendTabFragment) {
                    f90239f = 9;
                    return;
                }
            }
        }
        f90239f = 1;
    }

    public static boolean Q(e30.b bVar) {
        FeedCloudMeta$StFeed g16;
        if (bVar == null || (g16 = bVar.g()) == null) {
            return false;
        }
        int i3 = g16.buttomBanner.style_type.get();
        int i16 = g16.post.post_type.get();
        if (i3 != 3 || i16 == 0) {
            return false;
        }
        return true;
    }

    public static UIStateData<List<e30.b>> Q0(UIStateData<List<e30.b>> uIStateData, List<e30.b> list) {
        if (uIStateData == null) {
            return null;
        }
        if (list != null && !list.isEmpty()) {
            uIStateData.setData(uIStateData.getIsLoadMore(), list);
            uIStateData.setState(3);
            return uIStateData;
        }
        return UIStateData.obtainEmpty();
    }

    public static boolean R(e30.b bVar) {
        if (bVar != null && bVar.g() != null) {
            if (T(bVar)) {
                return true;
            }
            return W(bVar);
        }
        return false;
    }

    public static synchronized void R0(e30.b bVar) {
        synchronized (r.class) {
            if (!V(bVar)) {
                return;
            }
            QFSBottomRecInfo qFSBottomRecInfo = (QFSBottomRecInfo) bVar.b("FEED_BOTTOM_REC_INFO");
            if (qFSBottomRecInfo == null) {
                qFSBottomRecInfo = new QFSBottomRecInfo();
            }
            bVar.o("FEED_BOTTOM_REC_INFO", qFSBottomRecInfo);
            List<e30.b> D = D(bVar);
            if (D == null) {
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            for (int i3 = 0; i3 < D.size(); i3++) {
                e30.b bVar2 = D.get(i3);
                if (bVar2.g().f398449id.get().equals(bVar.g().f398449id.get())) {
                    qFSBottomRecInfo.setSelectedPos(i3);
                    QLog.d("QFSCommonUtil", 1, "update current selected:" + i3);
                }
                bVar2.o("FEED_BOTTOM_REC_INFO", qFSBottomRecInfo);
                sb5.append(bVar2.g().f398449id.get());
                sb5.append("%");
            }
            qFSBottomRecInfo.setFeedIdList(sb5.toString());
        }
    }

    public static boolean S(e30.b bVar) {
        if (bVar != null && bVar.g() != null) {
            if (bVar.g().secondaryLoadMask.get().contains(4)) {
                QLog.d("QFSCommonUtil", 1, "[hasContentQualityFeedback] has content quality feedback, feed = " + bVar.g().f398449id.get());
                return true;
            }
            QLog.d("QFSCommonUtil", 1, "[hasContentQualityFeedback] has no content quality feedback, feed = " + bVar.g().f398449id.get());
        }
        return false;
    }

    public static void S0(e30.b bVar, List<e30.b> list) {
        if (bVar != null && list != null) {
            bVar.o("FEED_BOTTOM_RECOMMEND_FEED", list);
            Iterator<e30.b> it = list.iterator();
            while (it.hasNext()) {
                it.next().o("FEED_BOTTOM_RECOMMEND_FEED", list);
            }
        }
    }

    private static boolean T(e30.b bVar) {
        List<com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow.d> r16;
        if (bVar == null || bVar.g() == null || (r16 = r(bVar)) == null || r16.isEmpty()) {
            return false;
        }
        QLog.d("QFSCommonUtil", 1, "[hasDrawerCardList] have items, has config guide follow, feed = " + bVar.g().f398449id.get());
        return true;
    }

    public static void T0(e30.b bVar, boolean z16) {
        if (bVar != null && bVar.b("FEED_BOTTOM_CONFIG_GUIDE_FOLLOW_INFO") != null) {
            ((QFSBottomConfigGuideFollowInfo) bVar.b("FEED_BOTTOM_CONFIG_GUIDE_FOLLOW_INFO")).setRecOpen(z16);
            QLog.d("QFSCommonUtil", 1, "updateConfigGuideFollowCurrentRecStatus:" + z16);
            return;
        }
        QLog.d("QFSCommonUtil", 1, "[updateConfigGuideFollowCurrentRecStatus] feedBlockData is null");
    }

    public static boolean U(e30.b bVar) {
        if (bVar != null && bVar.b("FEED_BOTTOM_REC_INFO") != null) {
            return ((QFSBottomRecInfo) bVar.b("FEED_BOTTOM_REC_INFO")).hasOperation();
        }
        return false;
    }

    public static void U0(e30.b bVar, boolean z16) {
        if (bVar == null) {
            return;
        }
        bVar.o("KEY_CONFIG_GUIDE_FOLLOW_HAS_AUTO_OPENED", Boolean.valueOf(z16));
        QLog.d("QFSCommonUtil", 1, "updateConfigGuideFollowHasAutoOpened:" + z16);
    }

    public static boolean V(e30.b bVar) {
        if (bVar != null && bVar.g() != null) {
            List<e30.b> D = D(bVar);
            if (D != null && D.size() > 0) {
                QLog.d("QFSCommonUtil", 1, "has rec feed" + bVar.g().f398449id.get());
                return true;
            }
            if (bVar.e().buttomBanner.style_type.get() == 1) {
                QLog.d("QFSCommonUtil", 1, "has rec feed" + bVar.g().f398449id.get());
                return true;
            }
        }
        return false;
    }

    public static void V0(e30.b bVar, boolean z16) {
        if (bVar == null) {
            return;
        }
        bVar.o("KEY_QUALITY_FEEDBACK_HAS_SHOWED", Boolean.valueOf(z16));
        QLog.d("QFSCommonUtil", 1, "updateContentQualityFeedbackHasShowed:" + z16);
    }

    public static boolean W(e30.b bVar) {
        if (bVar == null || bVar.g() == null || !bVar.e().secondaryLoadMask.get().contains(2)) {
            return false;
        }
        QLog.d("QFSCommonUtil", 1, "[hasSecondaryLoadMask] have mask, has config guide follow, feed = " + bVar.g().f398449id.get());
        return true;
    }

    public static void W0(e30.b bVar, FeedCloudRead$StChoiceQuestionBanner feedCloudRead$StChoiceQuestionBanner) {
        if (bVar != null && feedCloudRead$StChoiceQuestionBanner != null) {
            bVar.o("FEED_QUALITY_FEEDBACK", feedCloudRead$StChoiceQuestionBanner);
        } else {
            QLog.e("QFSCommonUtil", 1, "[updateContentQualityFeedbackToFeed] data is null.");
        }
    }

    public static boolean X(e30.b bVar) {
        Object b16 = bVar.b("key_has_show_recommend_add_friend_anim");
        if (b16 instanceof Boolean) {
            return ((Boolean) b16).booleanValue();
        }
        return false;
    }

    public static void X0(e30.b bVar, boolean z16, int i3, boolean z17) {
        if (bVar != null && bVar.b("FEED_BOTTOM_REC_INFO") != null) {
            QFSBottomRecInfo qFSBottomRecInfo = (QFSBottomRecInfo) bVar.b("FEED_BOTTOM_REC_INFO");
            qFSBottomRecInfo.setRecOpen(z16);
            qFSBottomRecInfo.setScrollX(i3);
            if (z17) {
                qFSBottomRecInfo.setHasOperation(true);
            }
            QLog.d("QFSFeedBottomRecommendV", 1, "updateCurrentRecStatus:" + z16 + "| x" + i3);
        }
    }

    public static boolean Y(Bundle bundle) {
        if (bundle == null || !QQWinkConstants.WinkTaskRoute.AIGC.equals(bundle.getString(QQWinkConstants.WinkTaskRoute.WINK_TASK_ROUTE))) {
            return false;
        }
        return true;
    }

    public static synchronized void Y0(e30.b bVar) {
        synchronized (r.class) {
            if (!R(bVar)) {
                QLog.d("QFSCommonUtil", 1, "[updateFeedConfigGuideFollowFlag] do not have config guide follow");
                return;
            }
            QFSBottomConfigGuideFollowInfo qFSBottomConfigGuideFollowInfo = (QFSBottomConfigGuideFollowInfo) bVar.b("FEED_BOTTOM_CONFIG_GUIDE_FOLLOW_INFO");
            if (qFSBottomConfigGuideFollowInfo == null) {
                qFSBottomConfigGuideFollowInfo = new QFSBottomConfigGuideFollowInfo();
            }
            bVar.o("FEED_BOTTOM_CONFIG_GUIDE_FOLLOW_INFO", qFSBottomConfigGuideFollowInfo);
            List<com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow.d> r16 = r(bVar);
            if (r16 == null) {
                QLog.d("QFSCommonUtil", 1, "[updateFeedConfigGuideFollowFlag] getDrawerCardList(sourceData) is null");
                return;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int i3 = 0;
            for (int i16 = 0; i16 < r16.size(); i16++) {
                com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow.d dVar = r16.get(i16);
                if (dVar.b() == -103) {
                    arrayList2.add(new e30.b(dVar.a()));
                } else if (dVar.b() == -101) {
                    arrayList.add(dVar.e());
                }
                i3 = dVar.d();
            }
            qFSBottomConfigGuideFollowInfo.setFeedBlockDataList(arrayList2);
            qFSBottomConfigGuideFollowInfo.setUserList(arrayList);
            qFSBottomConfigGuideFollowInfo.setType(i3);
            QLog.d("QFSCommonUtil", 1, "[updateFeedConfigGuideFollowFlag] QFSBottomConfigGuideFollowInfo = " + qFSBottomConfigGuideFollowInfo);
        }
    }

    public static boolean Z(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.opMask2.get().contains(52)) {
            return true;
        }
        return false;
    }

    public static void Z0(Context context) {
        Context hostContext = ASEngineUtils.getHostContext(context);
        if (hostContext instanceof Activity) {
            QUIImmersiveHelper.s((Activity) hostContext, false, true);
        }
    }

    public static boolean a0(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        FeedCloudMeta$StDebugInfo feedCloudMeta$StDebugInfo;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StDebugInfo = feedCloudMeta$StFeed.debugInfo) != null) {
            return TextUtils.equals(fb0.b.c(feedCloudMeta$StDebugInfo.debugMap, "is_client_back_up_feed", ""), "1");
        }
        return false;
    }

    public static void a1(Context context, @ColorInt int i3) {
        Context hostContext = ASEngineUtils.getHostContext(context);
        if (!(hostContext instanceof Activity)) {
            QLog.d("QFSCommonUtil", 1, "is not activity. ");
            return;
        }
        Window window = ((Activity) hostContext).getWindow();
        boolean j3 = com.tencent.mobileqq.qui.b.f276860a.j(window);
        if (!QUIImmersiveHelper.n(window) && !j3) {
            QLog.d("QFSCommonUtil", 1, "isNavigationBarExist: false. ");
        } else if (i3 == window.getNavigationBarColor()) {
            QLog.d("QFSCommonUtil", 1, "color is same. ");
        } else {
            window.setNavigationBarColor(i3);
            NavigatorUpdateTask.p(window, i3);
        }
    }

    public static void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            List<String> list = f90238e;
            if (!list.contains(str)) {
                if (list.size() < uq3.c.H2()) {
                    list.add(str);
                    return;
                }
                return;
            }
        }
        QLog.d("QFSCommonUtil", 1, "[addOnceEnterShareGuideShowTimes] filter. feedId = " + str);
    }

    public static boolean b0() {
        if (System.currentTimeMillis() - uq3.k.a().f("sp_key_push_red_point_show_time", 0L) > 600000) {
            return true;
        }
        return false;
    }

    public static void b1(long j3) {
        uq3.k.a().n("sp_key_push_red_point_show_time", j3);
    }

    private static CharSequence c(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed, String str, BoldClickableSpan.OnClickBoldTextListener onClickBoldTextListener, boolean z16) {
        int i3;
        String d16 = com.tencent.biz.qqcircle.utils.bh.d(feedCloudMeta$StFeed.feedTextInfo.get(), "post_prefix_text");
        String d17 = com.tencent.biz.qqcircle.utils.bh.d(feedCloudMeta$StFeed.feedTextInfo.get(), "post_prefix_link");
        if (QLog.isDevelopLevel()) {
            QLog.d("QFSCommonUtil", 4, "[appendPrefix] text = " + d16 + ", link = " + d17 + TVKDevicePostProcessCapabilityReportConstant.POST_PROCESS_TYPE + feedCloudMeta$StFeed.post.post_type.get());
        }
        if (!TextUtils.isEmpty(d16) && !TextUtils.isEmpty(d17) && feedCloudMeta$StFeed.post.post_type.get() != 0) {
            String j3 = j(feedCloudMeta$StFeed);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(j3);
            String str2 = " " + d16 + " ";
            spannableStringBuilder.append((CharSequence) str2).append((CharSequence) str);
            QCircleSkinHelper qCircleSkinHelper = QCircleSkinHelper.getInstance();
            if (z16) {
                i3 = R.color.qvideo_skin_color_text_primary;
            } else {
                i3 = R.color.cla;
            }
            spannableStringBuilder.setSpan(new BoldClickableSpan(onClickBoldTextListener, qCircleSkinHelper.getColor(i3), true, d17), j3.length(), j3.length() + str2.length(), 33);
            return spannableStringBuilder;
        }
        return str;
    }

    public static boolean c0(List<Integer> list) {
        if (list == null) {
            QLog.e("QFSCommonUtil", 1, "[isContainsZero] is null");
            return false;
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().intValue() == 0) {
                return true;
            }
        }
        return false;
    }

    public static void c1(String str, boolean z16) {
        uq3.k.a().j(str + "sp_key_has_shared_owner_feed", z16);
    }

    public static SpannableString d(long j3, int i3) {
        return e(j3, true, i3);
    }

    public static boolean d0(e30.b bVar, int i3) {
        QFSBottomRecInfo qFSBottomRecInfo;
        if (bVar == null || (qFSBottomRecInfo = (QFSBottomRecInfo) bVar.b("FEED_BOTTOM_REC_INFO")) == null || qFSBottomRecInfo.getSelectedPos() != i3) {
            return false;
        }
        return true;
    }

    public static void d1(e30.b bVar, boolean z16) {
        if (bVar == null) {
            return;
        }
        bVar.o("KEY_TAKE_THE_SAME_STYLE_HAS_STRENGTHENED", Boolean.valueOf(z16));
        QLog.d("QFSCommonUtil", 1, "updateTakeTheSameStyleHasStrengthened:" + z16);
    }

    public static SpannableString e(long j3, boolean z16, int i3) {
        String str;
        String str2;
        boolean z17;
        if (z16) {
            str = com.tencent.biz.qqcircle.utils.h.a(R.string.f181633ea);
        } else {
            str = "w";
        }
        if (j3 < 10000) {
            str2 = String.valueOf(j3);
            z17 = false;
        } else {
            if (j3 < 1000000) {
                long round = Math.round(j3 / 1000.0d);
                if (round % 10 == 0) {
                    str2 = ((int) (((float) round) / 10.0f)) + str;
                } else {
                    str2 = (((float) round) / 10.0f) + str;
                }
            } else if (j3 < SafeBitmapFactory.PX_THRESHOID_DEFAULTS) {
                str2 = (j3 / 10000) + str;
            } else {
                str2 = (j3 / SafeBitmapFactory.PX_THRESHOID_DEFAULTS) + com.tencent.biz.qqcircle.utils.h.a(R.string.f181623e_);
            }
            z17 = true;
        }
        if (z16 && i3 != -1 && z17) {
            SpannableString spannableString = new SpannableString(str2);
            spannableString.setSpan(new AbsoluteSizeSpan(i3, true), str2.length() - 1, str2.length(), 18);
            return spannableString;
        }
        return new SpannableString(str2);
    }

    public static boolean e0(String str) {
        if (!TextUtils.isEmpty(str) && !str.matches("\\d+")) {
            return true;
        }
        return false;
    }

    public static String f(long j3) {
        return e(j3, true, -1).toString();
    }

    public static boolean f0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StFeed feedCloudMeta$StFeed2) {
        boolean z16;
        if (feedCloudMeta$StFeed == null || feedCloudMeta$StFeed2 == null) {
            return false;
        }
        boolean g06 = g0(feedCloudMeta$StFeed, feedCloudMeta$StFeed2);
        String str = feedCloudMeta$StFeed2.video.fileId.get();
        String str2 = feedCloudMeta$StFeed.video.fileId.get();
        if (!TextUtils.isEmpty(str) && str.equals(str2)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!g06 || !z16) {
            return false;
        }
        return true;
    }

    public static String g(long j3, boolean z16) {
        RoundingMode roundingMode;
        String a16 = com.tencent.biz.qqcircle.utils.h.a(R.string.f181633ea);
        if (j3 < 10000) {
            return String.valueOf(j3);
        }
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumFractionDigits(1);
        decimalFormat.setGroupingSize(0);
        if (z16) {
            roundingMode = RoundingMode.UP;
        } else {
            roundingMode = RoundingMode.DOWN;
        }
        decimalFormat.setRoundingMode(roundingMode);
        return decimalFormat.format(j3 / 10000.0d) + a16;
    }

    public static boolean g0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StFeed feedCloudMeta$StFeed2) {
        if (feedCloudMeta$StFeed == null || feedCloudMeta$StFeed2 == null) {
            return false;
        }
        String str = feedCloudMeta$StFeed2.f398449id.get();
        String str2 = feedCloudMeta$StFeed.f398449id.get();
        cq cqVar = cq.f92752a;
        if (cqVar.s(feedCloudMeta$StFeed2)) {
            String n3 = cqVar.n(feedCloudMeta$StFeed);
            if (TextUtils.isEmpty(n3) || !str.startsWith("share_fake_") || !str.contains(n3)) {
                return false;
            }
        } else if (!str.startsWith("share_fake_") || !str.contains(str2)) {
            return false;
        }
        return true;
    }

    public static String h() {
        e.b p16 = k30.e.i().p();
        if (p16 != null) {
            return p16.a();
        }
        return "";
    }

    public static boolean h0(int i3) {
        e.b p16 = k30.e.i().p();
        if (!bz.t() || p16 == null || i3 == p16.c() || i3 != 0 || !uq3.c.u()) {
            return false;
        }
        return true;
    }

    public static int i() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.utils.q
            @Override // java.lang.Runnable
            public final void run() {
                r.J0();
            }
        });
        return f90235b;
    }

    public static boolean i0(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed != null && (QCirclePluginUtil.isFollow(feedCloudMeta$StFeed.poster) || QCirclePluginUtil.isOwner(feedCloudMeta$StFeed.poster) || QCircleFollowManager.getInstance().isUinFollowed(feedCloudMeta$StFeed.poster.f398463id.get()))) {
            return true;
        }
        return false;
    }

    private static String j(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed.post.post_type.get() == 1) {
            return com.tencent.biz.qqcircle.utils.h.a(R.string.f181813es);
        }
        if (feedCloudMeta$StFeed.post.post_type.get() != 2 && feedCloudMeta$StFeed.post.post_type.get() != 3) {
            return "";
        }
        return com.tencent.biz.qqcircle.utils.h.a(R.string.t0u);
    }

    public static boolean j0(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        int i3;
        if (feedCloudMeta$StUser == null) {
            QLog.e("QFSCommonUtil", 1, "[isFollowed] stUser should not be null");
            return false;
        }
        if (QCircleFollowManager.getInstance().hasUin(feedCloudMeta$StUser.f398463id.get())) {
            i3 = QCircleFollowManager.getInstance().getUinFollowed(feedCloudMeta$StUser.f398463id.get()).intValue();
        } else {
            i3 = feedCloudMeta$StUser.followState.get();
        }
        return QCirclePluginUtil.isFollow(i3);
    }

    public static List<e30.b> k(e30.b bVar) {
        if (bVar != null && bVar.b("FEED_BOTTOM_CONFIG_GUIDE_FOLLOW_INFO") != null) {
            return ((QFSBottomConfigGuideFollowInfo) bVar.b("FEED_BOTTOM_CONFIG_GUIDE_FOLLOW_INFO")).getFeedBlockDataList();
        }
        return null;
    }

    public static boolean k0(List<FeedCloudMeta$StUser> list) {
        if (RFSafeListUtils.isEmpty(list)) {
            if (QLog.isDevelopLevel()) {
                QLog.e("QFSCommonUtil", 4, "[isFollowedAllUser] userList should not be null");
            }
            return false;
        }
        Iterator<FeedCloudMeta$StUser> it = list.iterator();
        while (it.hasNext()) {
            if (!j0(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean l(e30.b bVar) {
        if (bVar != null && bVar.b("KEY_CONFIG_GUIDE_FOLLOW_HAS_AUTO_OPENED") != null) {
            Object b16 = bVar.b("KEY_CONFIG_GUIDE_FOLLOW_HAS_AUTO_OPENED");
            if (b16 instanceof Boolean) {
                return ((Boolean) b16).booleanValue();
            }
        }
        return false;
    }

    @Contract(pure = true)
    public static boolean l0(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        if (feedCloudMeta$StUser.guild_state.state.get() != 0) {
            return true;
        }
        return false;
    }

    public static List<FeedCloudMeta$StUser> m(e30.b bVar) {
        if (bVar != null && bVar.b("FEED_BOTTOM_CONFIG_GUIDE_FOLLOW_INFO") != null) {
            return ((QFSBottomConfigGuideFollowInfo) bVar.b("FEED_BOTTOM_CONFIG_GUIDE_FOLLOW_INFO")).getUserList();
        }
        return null;
    }

    public static boolean m0(Bundle bundle) {
        if (Y(bundle) && ((IQQWinkEditorResAPI) QRoute.api(IQQWinkEditorResAPI.class)).isDisableMagicStudioDownload()) {
            return true;
        }
        return false;
    }

    public static FeedCloudRead$StChoiceQuestionBanner n(e30.b bVar) {
        if (bVar != null && bVar.b("FEED_QUALITY_FEEDBACK") != null) {
            return (FeedCloudRead$StChoiceQuestionBanner) bVar.b("FEED_QUALITY_FEEDBACK");
        }
        QLog.e("QFSCommonUtil", 1, "[getContentQualityFeedback] data is null.");
        return null;
    }

    public static boolean n0(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed.recomInfo.recomReasonTypeForClinet.get() == 3 && feedCloudMeta$StFeed.recomInfo.recomReasonV2.recomUserInfo.size() > 0) {
            return true;
        }
        return false;
    }

    public static boolean o(e30.b bVar) {
        if (bVar != null && bVar.b("KEY_QUALITY_FEEDBACK_HAS_SHOWED") != null) {
            Object b16 = bVar.b("KEY_QUALITY_FEEDBACK_HAS_SHOWED");
            if (b16 instanceof Boolean) {
                return ((Boolean) b16).booleanValue();
            }
        }
        return false;
    }

    public static boolean o0(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed != null && !TextUtils.isEmpty(feedCloudMeta$StFeed.musicInfo.musicName.get()) && feedCloudMeta$StFeed.musicInfo.sameMusicGuideButton.isButtonDisplayed.get()) {
            return true;
        }
        return false;
    }

    public static int p(Context context) {
        Context hostContext = ASEngineUtils.getHostContext(context);
        if (!(hostContext instanceof Activity)) {
            return 0;
        }
        Window window = ((Activity) hostContext).getWindow();
        if (!QUIImmersiveHelper.n(window)) {
            return 0;
        }
        return window.getNavigationBarColor();
    }

    public static boolean p0(@NonNull FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.type.get() == 3 && feedCloudMeta$StFeed.live.room.roomState.get() == 1) {
            return true;
        }
        return false;
    }

    public static String q() {
        return ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
    }

    public static boolean q0(int i3) {
        if (f90239f == i3) {
            return true;
        }
        return false;
    }

    public static List<com.tencent.biz.qqcircle.immersive.views.banner.bottom.configguidefollow.d> r(e30.b bVar) {
        if (bVar != null && bVar.b("FEED_BOTTOM_CONFIG_GUIDE_FOLLOW") != null) {
            return (List) bVar.b("FEED_BOTTOM_CONFIG_GUIDE_FOLLOW");
        }
        return null;
    }

    public static boolean r0(e30.b bVar) {
        if (bVar == null || bVar.g() == null || bVar.g().buttomBanner == null || bVar.g().buttomBanner.style_type.get() != 4) {
            return false;
        }
        return true;
    }

    public static String s(e30.b bVar) {
        if (bVar != null && bVar.b("FEED_BOTTOM_CONFIG_GUIDE_FOLLOW_DRAWER_TITLE") != null) {
            return (String) bVar.b("FEED_BOTTOM_CONFIG_GUIDE_FOLLOW_DRAWER_TITLE");
        }
        return "";
    }

    public static boolean s0(e30.b bVar) {
        if (bVar != null && bVar.b("FEED_BOTTOM_REC_INFO") != null) {
            return ((QFSBottomRecInfo) bVar.b("FEED_BOTTOM_REC_INFO")).isRecOpen();
        }
        return false;
    }

    public static int t(e30.b bVar) {
        if (bVar != null && bVar.b("FEED_BOTTOM_CONFIG_GUIDE_FOLLOW_DRAWER_TYPE") != null) {
            return ((Integer) bVar.b("FEED_BOTTOM_CONFIG_GUIDE_FOLLOW_DRAWER_TYPE")).intValue();
        }
        return 0;
    }

    public static boolean t0(e30.b bVar) {
        if (bVar != null && bVar.b("FEED_BOTTOM_CONFIG_GUIDE_FOLLOW_INFO") != null) {
            return ((QFSBottomConfigGuideFollowInfo) bVar.b("FEED_BOTTOM_CONFIG_GUIDE_FOLLOW_INFO")).isRecOpen();
        }
        return false;
    }

    public static String u(e30.b bVar) {
        if (bVar == null) {
            QLog.e("QFSCommonUtil", 1, "[getFeedIdListFromFeedBlockDatList] sourceFeedBlockData should not be null.");
            return "";
        }
        List<e30.b> k3 = k(bVar);
        if (RFSafeListUtils.isEmpty(k3)) {
            QLog.e("QFSCommonUtil", 1, "[getFeedIdListFromFeedBlockDatList] feedBlockDataList should not be null.");
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < k3.size(); i3++) {
            e30.b bVar2 = k3.get(i3);
            if (bVar2 != null && bVar2.g() != null) {
                sb5.append(bVar2.g().f398449id.get());
                if (i3 < k3.size() - 1) {
                    sb5.append("|");
                }
            }
        }
        return sb5.toString();
    }

    public static boolean u0(@NonNull FeedCloudMeta$StUser feedCloudMeta$StUser) {
        if (feedCloudMeta$StUser != null && q().equals(feedCloudMeta$StUser.f398463id.get())) {
            return true;
        }
        return false;
    }

    public static String v(e30.b bVar) {
        if (bVar != null && bVar.b("FEED_BOTTOM_REC_INFO") != null) {
            return ((QFSBottomRecInfo) bVar.b("FEED_BOTTOM_REC_INFO")).getFeedIdList();
        }
        return "";
    }

    public static boolean v0(String str) {
        return q().equals(str);
    }

    public static boolean w() {
        if (f90234a) {
            if (QLog.isDevelopLevel()) {
                QLog.i("QFSCommonUtil", 4, "[getHasShowFreeFlowView] SP cache = true");
            }
            return true;
        }
        boolean z16 = !TextUtils.isEmpty(uq3.q.a(RFWApplication.getApplication(), "sp_key_has_show_entrance_free_flow_view"));
        f90234a = z16;
        return z16;
    }

    public static boolean w0() {
        int e16 = uq3.k.a().e("sp_key_personal_recommend_switch_panel_should_show_times", 0);
        QLog.i("QFSCommonUtil", 1, "[isPersonalRecommendSwitchPanelCanShow] should show times: = " + e16);
        if (B() >= e16) {
            QLog.d("QFSCommonUtil", 1, "[isPersonalRecommendSwitchPanelCanShow] personal recommend switch panel show times has arrived the max show times");
            return false;
        }
        if (!uq3.n.c(System.currentTimeMillis(), uq3.k.a().f("sp_key_personal_recommend_switch_panel_show_timestamp", 0L))) {
            return true;
        }
        QLog.d("QFSCommonUtil", 1, "[isPersonalRecommendSwitchPanelCanShow] is same day, return.");
        return false;
    }

    public static Context x(Context context) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.getBaseContext() instanceof ContextWrapper) {
                return activity.getBaseContext();
            }
            return context;
        }
        return context;
    }

    public static boolean x0(String str, String str2) {
        int i3;
        QLog.i("QFSCommonUtil", 1, "[isPositiveFeedbackGuideFollowArriveMaxTime] max show times: = " + str + ", scene: " + str2);
        try {
            i3 = Integer.parseInt(str);
        } catch (Exception e16) {
            QLog.e("QFSCommonUtil", 1, "[isPositiveFeedbackGuideFollowArriveMaxTime] Exception:" + e16);
            i3 = 0;
        }
        if (!uq3.n.c(System.currentTimeMillis(), uq3.k.a().f("sp_key_feed_positive_feedback_guide_follow_show_timestamp" + str2, 0L))) {
            QLog.d("QFSCommonUtil", 1, "[isPositiveFeedbackGuideFollowArriveMaxTime] is not the same day");
            uq3.k.a().m("sp_key_feed_positive_feedback_guide_follow_showed_times" + str2, 0);
            return false;
        }
        int e17 = uq3.k.a().e("sp_key_feed_positive_feedback_guide_follow_showed_times" + str2, 0);
        QLog.i("QFSCommonUtil", 1, "[isPositiveFeedbackGuideFollowArriveMaxTime] showedTimes = " + e17);
        if (e17 < i3) {
            return false;
        }
        QLog.d("QFSCommonUtil", 1, "[isPositiveFeedbackGuideFollowArriveMaxTime] show times has arrived max show times");
        return true;
    }

    public static String y(@NonNull com.tencent.biz.qqcircle.immersive.personal.data.w wVar, String str, String str2) {
        String t16 = wVar.t(str);
        if (!TextUtils.isEmpty(t16)) {
            return t16;
        }
        return str2;
    }

    public static boolean y0(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StFeed feedCloudMeta$StFeed2) {
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed2 != null) {
            return com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.ktx.d.f(feedCloudMeta$StFeed, feedCloudMeta$StFeed2);
        }
        return false;
    }

    public static List<String> z() {
        return f90238e;
    }

    public static boolean z0(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (str.startsWith("share_fake_")) {
                str = str.substring(11);
            }
            if (str2.startsWith("share_fake_")) {
                str2 = str2.substring(11);
            }
            return TextUtils.equals(str, str2);
        }
        return false;
    }
}
