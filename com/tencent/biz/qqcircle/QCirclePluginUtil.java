package com.tencent.biz.qqcircle;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Message;
import android.text.TextUtils;
import android.text.format.Time;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneHelper;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.beans.QCircleFolderBean;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.beans.QFSTransitionAnimBean;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.helpers.QFSFetchFeedCountsHelper;
import com.tencent.biz.qqcircle.immersive.adapter.m;
import com.tencent.biz.qqcircle.manager.QCircleFolderTabInfoManager;
import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.biz.qqcircle.richframework.outbox.QCircleOutboxTaskQueue;
import com.tencent.biz.qqcircle.utils.QCircleDeviceUsageUtils;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.qqcircle.utils.cq;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.auto.engine.lib.ASInject;
import com.tencent.mobileqq.auto.engine.lib.IASEngineDelegate;
import com.tencent.mobileqq.auto.engine.loader.ASEngineUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.vipicon.NamePlateVipType;
import com.tencent.mobileqq.vip.api.VipInfoForBusiness;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkpublish.model.params.MediaParams;
import com.tencent.mobileqq.winkpublish.model.params.VideoParams;
import com.tencent.mobileqq.winkpublish.model.params.WinkPublishParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.relation.QCircleRelationGroupManager;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StBarrage;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StLike;
import feedcloud.FeedCloudMeta$StPushList;
import feedcloud.FeedCloudMeta$StReply;
import feedcloud.FeedCloudMeta$StTagInfo;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudMeta$StVideo;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import k30.n;
import qqcircle.QQCircleBase$StUserBusiData;
import qqcircle.QQCircleDitto$StItemContainer;
import qqcircle.QQCircleFeedBase$StFeedBusiReqData;
import qqcircle.QQCircleFeedBase$StLikeBusiData;
import qqcircle.QQCircleFeedBase$StPolyLike;
import qqcircle.QQCircleFeedBase$StSubTabInfo;
import qqcircle.QQCircleFeedBase$StTabInfo;
import uq3.o;

/* loaded from: classes4.dex */
public class QCirclePluginUtil {
    private static final String NAVIGATION = "navigationBarBackground";
    private static final String TAG = "QCirclePluginUtil";
    public static final boolean TOUCH_DEBUG_OPEN = false;
    private static volatile boolean sGetQuicOpenResult = false;
    private static boolean sIsECFloatWebViewOnShow = false;
    private static boolean sIsGalleryPageOnShow = false;
    private static boolean sIsSharePanelOnShow = false;
    private static boolean sIsSplitModeInnerBackClk = false;
    private static boolean sIsTabModeForPad = false;
    private static boolean sIsTabModeJudgeByQCircleFrame = false;
    private static boolean sQuicOpenResult = false;
    private static String sTopActivityInQCirclePrintStr = "";
    private static String sTopSandboxActivityPrintStr = "";

    public static boolean canJumpToQQProfile(List<Integer> list) {
        if (list != null && list.contains(3)) {
            return true;
        }
        return false;
    }

    public static boolean canSyncTroopARK(List<Integer> list) {
        if (list != null && list.contains(4)) {
            return true;
        }
        return false;
    }

    public static SuperPlayerVideoInfo createVideoInfo(String str, String str2, String str3, String str4, int i3) {
        int i16 = 101;
        if (TextUtils.isEmpty(str)) {
            QLog.e(TAG, 1, "createVideoInfo url empty");
            return SuperPlayerFactory.createVideoInfoForUrl("", 101, "");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
        }
        if (str.contains("flv")) {
            i16 = 202;
        } else if (str.contains("rtmp")) {
            i16 = 103;
        }
        SuperPlayerVideoInfo createVideoInfoForUrl = SuperPlayerFactory.createVideoInfoForUrl((String[]) arrayList.toArray(new String[arrayList.size()]), i16, str4, "");
        createVideoInfoForUrl.setUrlHostList(new ArrayList<>(Arrays.asList(str3)));
        QLog.d(TAG, 1, "createVideoInfo videoUrl: " + createVideoInfoForUrl.getPlayUrl() + "videoDuration:" + i3);
        createVideoInfoForUrl.setVideoDurationMs((long) i3);
        return createVideoInfoForUrl;
    }

    public static FeedCloudMeta$StBarrage deepCopyBarrage(FeedCloudMeta$StBarrage feedCloudMeta$StBarrage) {
        FeedCloudMeta$StBarrage feedCloudMeta$StBarrage2 = new FeedCloudMeta$StBarrage();
        if (feedCloudMeta$StBarrage == null) {
            return feedCloudMeta$StBarrage2;
        }
        try {
            feedCloudMeta$StBarrage2.mergeFrom(feedCloudMeta$StBarrage.toByteArray());
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudMeta$StBarrage2;
    }

    public static QQCircleDitto$StItemContainer deepCopyContainer(QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer) {
        QQCircleDitto$StItemContainer qQCircleDitto$StItemContainer2 = new QQCircleDitto$StItemContainer();
        if (qQCircleDitto$StItemContainer == null) {
            return qQCircleDitto$StItemContainer2;
        }
        try {
            qQCircleDitto$StItemContainer2.mergeFrom(qQCircleDitto$StItemContainer.toByteArray());
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("deepCopyContainer", 4, " failed", e16);
        }
        return qQCircleDitto$StItemContainer2;
    }

    public static FeedCloudMeta$StLike deepCopyLike(FeedCloudMeta$StLike feedCloudMeta$StLike) {
        FeedCloudMeta$StLike feedCloudMeta$StLike2 = new FeedCloudMeta$StLike();
        if (feedCloudMeta$StLike == null) {
            return feedCloudMeta$StLike2;
        }
        try {
            feedCloudMeta$StLike2.mergeFrom(feedCloudMeta$StLike.toByteArray());
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudMeta$StLike2;
    }

    public static QQCircleFeedBase$StPolyLike deepCopyPolyLike(QQCircleFeedBase$StPolyLike qQCircleFeedBase$StPolyLike) {
        QQCircleFeedBase$StPolyLike qQCircleFeedBase$StPolyLike2 = new QQCircleFeedBase$StPolyLike();
        if (qQCircleFeedBase$StPolyLike == null) {
            return qQCircleFeedBase$StPolyLike2;
        }
        try {
            qQCircleFeedBase$StPolyLike2.mergeFrom(qQCircleFeedBase$StPolyLike.toByteArray());
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return qQCircleFeedBase$StPolyLike2;
    }

    public static FeedCloudMeta$StReply deepCopyReply(FeedCloudMeta$StReply feedCloudMeta$StReply) {
        FeedCloudMeta$StReply feedCloudMeta$StReply2 = new FeedCloudMeta$StReply();
        if (feedCloudMeta$StReply == null) {
            return feedCloudMeta$StReply2;
        }
        try {
            feedCloudMeta$StReply2.mergeFrom(feedCloudMeta$StReply.toByteArray());
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudMeta$StReply2;
    }

    public static FeedCloudMeta$StComment deepCopycomment(FeedCloudMeta$StComment feedCloudMeta$StComment) {
        FeedCloudMeta$StComment feedCloudMeta$StComment2 = new FeedCloudMeta$StComment();
        if (feedCloudMeta$StComment == null) {
            return feedCloudMeta$StComment2;
        }
        try {
            feedCloudMeta$StComment2.mergeFrom(feedCloudMeta$StComment.toByteArray());
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return feedCloudMeta$StComment2;
    }

    public static void expandViewTouchDelegate(final View view, final int i3, final int i16, final int i17, final int i18) {
        if (view != null && (view.getParent() instanceof View)) {
            ((View) view.getParent()).post(new Runnable() { // from class: com.tencent.biz.qqcircle.QCirclePluginUtil.2
                @Override // java.lang.Runnable
                public void run() {
                    Rect rect = new Rect();
                    view.setEnabled(true);
                    view.getHitRect(rect);
                    rect.top -= i3;
                    rect.bottom += i16;
                    rect.left -= i17;
                    rect.right += i18;
                    if (QLog.isColorLevel()) {
                        QLog.d("TouchDelegate", 2, " bounds.top=" + rect.top + "bounds.bottom=" + rect.bottom + " bounds.top=" + rect.top + "bounds.bottom=" + rect.bottom);
                    }
                    TouchDelegate touchDelegate = new TouchDelegate(rect, view);
                    if (view.getParent() instanceof View) {
                        ((View) view.getParent()).setTouchDelegate(touchDelegate);
                    }
                }
            });
        }
    }

    public static void fixMesssageLeak(Dialog dialog) {
        if (dialog == null) {
            return;
        }
        String[] strArr = {"mDismissMessage", "mCancelMessage", "mShowMessage"};
        for (int i3 = 0; i3 < 3; i3++) {
            try {
                Field declaredField = Dialog.class.getDeclaredField(strArr[i3]);
                if (declaredField != null) {
                    if (!declaredField.isAccessible()) {
                        declaredField.setAccessible(true);
                    }
                    Object obj = declaredField.get(dialog);
                    if (obj instanceof Message) {
                        Message message = (Message) obj;
                        if (message.obj != null) {
                            message.obj = null;
                            message.what = 0;
                        }
                    }
                }
            } catch (IllegalAccessException e16) {
                e16.printStackTrace();
            } catch (IllegalArgumentException e17) {
                e17.printStackTrace();
            } catch (NoSuchFieldException e18) {
                e18.printStackTrace();
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    public static String formatData(long j3) {
        Date date;
        Object valueOf;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
        if (j3 == 0) {
            date = new Date();
        } else {
            date = new Date(j3);
        }
        String format = simpleDateFormat.format(date);
        Time time = new Time();
        time.set(j3);
        long currentTimeMillis = System.currentTimeMillis();
        Time time2 = new Time();
        time2.set(currentTimeMillis);
        int i3 = time2.yearDay - 1;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(" ");
        sb5.append(time.hour);
        sb5.append(":");
        int i16 = time.minute;
        if (i16 < 10) {
            valueOf = "0" + time.minute;
        } else {
            valueOf = Integer.valueOf(i16);
        }
        sb5.append(valueOf);
        String sb6 = sb5.toString();
        if (time.year == time2.year) {
            int i17 = time2.yearDay;
            int i18 = time.yearDay;
            if (i17 < i18) {
                return format;
            }
            if (i17 == i18) {
                return com.tencent.biz.qqcircle.utils.h.a(R.string.i3f) + sb6;
            }
            if (i18 == i3) {
                return com.tencent.biz.qqcircle.utils.h.a(R.string.ihd) + sb6;
            }
            if (i18 + 1 == i3) {
                return com.tencent.biz.qqcircle.utils.h.a(R.string.f170578ul) + sb6;
            }
            return (time.month + 1) + "-" + time.monthDay + sb6;
        }
        return format;
    }

    public static int getAuthType(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        QQCircleBase$StUserBusiData userExtraData = getUserExtraData(feedCloudMeta$StUser);
        if (userExtraData != null) {
            return userExtraData.certification.get();
        }
        return 0;
    }

    private static HashMap<String, String> getBeanAttrs(Context context) {
        QCircleFolderBean qCircleFolderBean;
        boolean z16 = context instanceof Activity;
        if (z16) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[getBeanAttrs] context\uff1a");
            sb5.append(context.hashCode());
            sb5.append(" intentHashCode:");
            Activity activity = (Activity) context;
            sb5.append(activity.getIntent().hashCode());
            sb5.append("| has initBean:");
            sb5.append(activity.getIntent().getSerializableExtra("key_bundle_common_init_bean"));
            QLog.d(TAG, 1, sb5.toString());
        }
        if (!z16) {
            return null;
        }
        Activity activity2 = (Activity) context;
        if (activity2.getIntent() == null || !(activity2.getIntent().getSerializableExtra("key_bundle_common_init_bean") instanceof QCircleFolderBean) || (qCircleFolderBean = (QCircleFolderBean) activity2.getIntent().getSerializableExtra("key_bundle_common_init_bean")) == null) {
            return null;
        }
        return qCircleFolderBean.getSchemeAttrs();
    }

    public static int getBottomMarginHeight(Context context) {
        int i3;
        if (isNewFolderPage(context)) {
            return m.C;
        }
        if (isTabMode()) {
            i3 = HostUIHelper.getInstance().getHostTabHeight();
        } else {
            i3 = m.C;
        }
        if (i3 == 0) {
            i3 = m.C;
        }
        QLog.d(TAG, 1, "[getBottomMarginHeight] bottomMarginHeight: " + i3);
        return i3;
    }

    public static int getBottonFollowStatus(int i3) {
        if (i3 == 1) {
            return 1;
        }
        if (i3 != 2) {
            if (i3 == 4) {
                return 2;
            }
            return 0;
        }
        return 3;
    }

    @NonNull
    public static QQCircleFeedBase$StFeedBusiReqData getBusiData(@Nullable e30.b bVar) {
        if (bVar == null) {
            return new QQCircleFeedBase$StFeedBusiReqData();
        }
        Object b16 = bVar.b("DITTO_FEED_BUSI_REQ_DATA");
        if (!(b16 instanceof QQCircleFeedBase$StFeedBusiReqData)) {
            return new QQCircleFeedBase$StFeedBusiReqData();
        }
        return (QQCircleFeedBase$StFeedBusiReqData) b16;
    }

    public static long getCurrentAccountLongUin() {
        return QCircleCommonUtil.getCurrentAccountLongUin();
    }

    public static String getCustomPageId(Context context) {
        if (!(context instanceof Activity)) {
            return "0";
        }
        Activity activity = (Activity) context;
        if (activity.getIntent() == null || !activity.getIntent().hasExtra("key_bundle_common_init_bean")) {
            return "0";
        }
        String b16 = n50.a.b((QCircleInitBean) activity.getIntent().getSerializableExtra("key_bundle_common_init_bean"));
        if (TextUtils.isEmpty(b16)) {
            return "0";
        }
        return b16;
    }

    public static int getDefaultThemeColor(boolean z16) {
        int color = QCircleSkinHelper.getInstance().getColor(R.color.qvideo_skin_color_bg_default);
        return z16 ? getNightModeColor(color) : color;
    }

    public static FeedCloudMeta$StFeed getFeedFromQCircleInitBean(Context context) {
        QCircleInitBean qCircleInitBean = getQCircleInitBean(context);
        if (qCircleInitBean != null && qCircleInitBean.getFeed() != null) {
            return qCircleInitBean.getFeed();
        }
        return null;
    }

    public static String getFeedTagName(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        List<FeedCloudMeta$StTagInfo> list = feedCloudMeta$StFeed.tagInfos.get();
        StringBuilder sb5 = new StringBuilder();
        for (FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo : list) {
            if (!TextUtils.isEmpty(sb5)) {
                sb5.append("|");
            }
            sb5.append(feedCloudMeta$StTagInfo.tagName.get());
        }
        return sb5.toString();
    }

    public static QCircleFolderBean getFolderBeanFromIntent(Intent intent) {
        if (intent != null && (intent.getSerializableExtra("key_bundle_common_init_bean") instanceof QCircleFolderBean)) {
            return (QCircleFolderBean) intent.getSerializableExtra("key_bundle_common_init_bean");
        }
        return new QCircleFolderBean();
    }

    public static String getFormatTimePrefix(long j3) {
        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
        if (j3 == 0) {
            date = new Date();
        } else {
            date = new Date(j3);
        }
        String format = simpleDateFormat.format(date);
        Time time = new Time();
        time.set(j3);
        long currentTimeMillis = System.currentTimeMillis();
        Time time2 = new Time();
        time2.set(currentTimeMillis);
        int i3 = time2.yearDay;
        int i16 = i3 - 1;
        if (time.year == time2.year) {
            int i17 = time.yearDay;
            if (i3 < i17) {
                return format;
            }
            if (i3 == i17) {
                return com.tencent.biz.qqcircle.utils.h.a(R.string.i3f);
            }
            if (i17 == i16) {
                return com.tencent.biz.qqcircle.utils.h.a(R.string.ihd);
            }
            if (i17 + 1 == i16) {
                return com.tencent.biz.qqcircle.utils.h.a(R.string.f170578ul);
            }
            return (time.month + 1) + "-" + time.monthDay;
        }
        return format;
    }

    public static String getFormatTimeSuffix(long j3) {
        Object valueOf;
        Time time = new Time();
        time.set(j3);
        new Time().set(System.currentTimeMillis());
        StringBuilder sb5 = new StringBuilder();
        sb5.append(" ");
        sb5.append(time.hour);
        sb5.append(":");
        int i3 = time.minute;
        if (i3 < 10) {
            valueOf = "0" + time.minute;
        } else {
            valueOf = Integer.valueOf(i3);
        }
        sb5.append(valueOf);
        return sb5.toString();
    }

    public static String getGalleryTabViewModelKey(String str, int i3) {
        return str + "_" + i3;
    }

    public static int getNightModeColor(int i3) {
        return ((int) ((i3 & 16777215) * 0.6d)) | (-16777216);
    }

    public static QCircleBaseFragment getQCircleBaseFragment(Context context) {
        Fragment findFragmentByTag;
        if (context instanceof CompatPublicActivity) {
            CompatPublicActivity compatPublicActivity = (CompatPublicActivity) context;
            if (compatPublicActivity.getFragment() instanceof QCircleBaseFragment) {
                return (QCircleBaseFragment) compatPublicActivity.getFragment();
            }
        }
        if (isQFSTabNativeFragmentMode(context) && (context instanceof FragmentActivity) && (findFragmentByTag = ((FragmentActivity) context).getSupportFragmentManager().findFragmentByTag("com.tencent.mobileqq.activity.home.MainFragment")) != null) {
            for (Fragment fragment : findFragmentByTag.getChildFragmentManager().getFragments()) {
                if ("QFSTabFakeNativeFragment".equals(fragment.getTag())) {
                    return (QCircleBaseFragment) fragment;
                }
            }
            return null;
        }
        return null;
    }

    public static QCircleInitBean getQCircleInitBean(Context context) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (activity.getIntent() != null && (activity.getIntent().getSerializableExtra("key_bundle_common_init_bean") instanceof QCircleInitBean)) {
                return (QCircleInitBean) activity.getIntent().getSerializableExtra("key_bundle_common_init_bean");
            }
            return null;
        }
        return null;
    }

    public static int[] getReportFeedType(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        int[] iArr = new int[2];
        if (feedCloudMeta$StFeed != null) {
            if (feedCloudMeta$StFeed.dittoFeed.dittoId.get() != 0) {
                iArr[0] = 3;
                iArr[1] = 1;
            } else if (feedCloudMeta$StFeed.type.get() == 2) {
                iArr[0] = 1;
                iArr[1] = 1;
            } else if (feedCloudMeta$StFeed.type.get() == 3) {
                iArr[0] = 1;
                iArr[1] = 2;
            }
        }
        return iArr;
    }

    public static FeedCloudMeta$StComment getSimpleComment(FeedCloudMeta$StComment feedCloudMeta$StComment) {
        if (feedCloudMeta$StComment == null) {
            QLog.e(TAG, 1, "getSimpleComment param comment is null");
            return null;
        }
        FeedCloudMeta$StComment feedCloudMeta$StComment2 = new FeedCloudMeta$StComment();
        feedCloudMeta$StComment2.f398447id.set(feedCloudMeta$StComment.f398447id.get());
        if (feedCloudMeta$StComment.postUser != null) {
            FeedCloudMeta$StUser feedCloudMeta$StUser = new FeedCloudMeta$StUser();
            feedCloudMeta$StUser.f398463id.set(feedCloudMeta$StComment2.postUser.f398463id.get());
            feedCloudMeta$StComment2.postUser.set(feedCloudMeta$StUser);
        } else {
            QLog.e(TAG, 1, "getSimpleComment poster is null");
        }
        return feedCloudMeta$StComment2;
    }

    public static FeedCloudMeta$StFeed getSimpleFeed(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            QLog.e(TAG, 1, "getSimpleFeed param feed is null");
            return null;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = new FeedCloudMeta$StFeed();
        feedCloudMeta$StFeed2.f398449id.set(feedCloudMeta$StFeed.f398449id.get());
        feedCloudMeta$StFeed2.createTime.set(feedCloudMeta$StFeed.createTime.get());
        feedCloudMeta$StFeed2.busiTranparent.set(feedCloudMeta$StFeed.busiTranparent.get());
        if (feedCloudMeta$StFeed.poster != null) {
            FeedCloudMeta$StUser feedCloudMeta$StUser = new FeedCloudMeta$StUser();
            feedCloudMeta$StUser.f398463id.set(feedCloudMeta$StFeed.poster.f398463id.get());
            feedCloudMeta$StFeed2.poster.set(feedCloudMeta$StUser);
        } else {
            QLog.e(TAG, 1, "getSimpleFeed poster is null");
        }
        return feedCloudMeta$StFeed2;
    }

    public static String getSubTabViewModelKey(QCircleTabInfo qCircleTabInfo, int i3) {
        PBRepeatMessageField<QQCircleFeedBase$StSubTabInfo> pBRepeatMessageField;
        if (qCircleTabInfo != null && (pBRepeatMessageField = qCircleTabInfo.mTab.subTabInfo) != null && pBRepeatMessageField.size() > i3) {
            return qCircleTabInfo.mTab.subTabInfo.get(i3).tabName + "_" + i3;
        }
        return "";
    }

    public static String getUrlFromTransitionAnimBean(Context context, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            QLog.e(TAG, 1, "[getUrlFromTransitionAnimBean] feed is null");
            return "";
        }
        QCircleInitBean qCircleInitBean = getQCircleInitBean(context);
        if (!(qCircleInitBean instanceof QCircleLayerBean)) {
            QLog.e(TAG, 1, "[getUrlFromTransitionAnimBean] is not QCircleLayerBean");
            return "";
        }
        if (qCircleInitBean.getFeed() != null && qCircleInitBean.getFeed().f398449id.get().equals(feedCloudMeta$StFeed.f398449id.get().replace("share_fake_", ""))) {
            QFSTransitionAnimBean transitionAnimBean = ((QCircleLayerBean) qCircleInitBean).getTransitionAnimBean();
            if (transitionAnimBean == null) {
                QLog.e(TAG, 1, "[getUrlFromTransitionAnimBean] animBean is null");
                return "";
            }
            return transitionAnimBean.getImageUrl();
        }
        QLog.e(TAG, 2, "[getUrlFromTransitionAnimBean] is not same feed, feed.id =" + feedCloudMeta$StFeed.f398449id.get());
        if (qCircleInitBean.getFeed() != null) {
            QLog.e(TAG, 2, "[getUrlFromTransitionAnimBean] initBean.getFeed.id =" + qCircleInitBean.getFeed().f398449id.get());
        }
        return "";
    }

    public static String getUrlHost(String str) {
        try {
            return Uri.parse(str).getHost();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "get host failed: " + str + ", error = " + e16.getMessage());
            return null;
        }
    }

    public static int getUrlType(String str) {
        if (str != null) {
            if (str.startsWith("https://")) {
                return 0;
            }
            if (str.startsWith("mqqapi://")) {
                return 1;
            }
            return -1;
        }
        return -1;
    }

    @NonNull
    public static QQCircleBase$StUserBusiData getUserBusiData(e30.b bVar) {
        if (bVar == null) {
            return new QQCircleBase$StUserBusiData();
        }
        Object b16 = bVar.b("DITTO_PERSONAL_PAGE_MANTLE");
        if (!(b16 instanceof QQCircleBase$StUserBusiData)) {
            return new QQCircleBase$StUserBusiData();
        }
        return (QQCircleBase$StUserBusiData) b16;
    }

    private static QQCircleBase$StUserBusiData getUserExtraData(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        if (feedCloudMeta$StUser != null && feedCloudMeta$StUser.busiData.get() != null) {
            try {
                QQCircleBase$StUserBusiData qQCircleBase$StUserBusiData = new QQCircleBase$StUserBusiData();
                qQCircleBase$StUserBusiData.mergeFrom(feedCloudMeta$StUser.busiData.get().toByteArray());
                return qQCircleBase$StUserBusiData;
            } catch (Exception e16) {
                e16.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static String getValueFromListEntry(List<FeedCloudCommon$Entry> list, String str) {
        return getValueFromListEntry(list, str, "");
    }

    public static long getVideoStartOffsetFromScheme(QCircleInitBean qCircleInitBean, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        HashMap<String, String> schemeAttrs;
        if (qCircleInitBean == null || qCircleInitBean.getSchemeAttrs() == null || feedCloudMeta$StFeed == null || (schemeAttrs = qCircleInitBean.getSchemeAttrs()) == null || !isExistVideoStartOffsetFromScheme(qCircleInitBean, feedCloudMeta$StFeed)) {
            return 0L;
        }
        try {
            return Long.parseLong(schemeAttrs.get(QCircleSchemeAttr.Detail.CURRENT_TIME));
        } catch (Exception e16) {
            QLog.w(TAG, 1, "getVideoStartOffsetFromScheme number format exception" + e16.toString());
            return 0L;
        }
    }

    public static boolean isAppOnForeground() {
        return kc0.a.b();
    }

    public static boolean isAuth(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        QQCircleBase$StUserBusiData userExtraData = getUserExtraData(feedCloudMeta$StUser);
        if (userExtraData != null && userExtraData.certification.get() >= 1) {
            return true;
        }
        return false;
    }

    public static boolean isExistVideoStartOffsetFromScheme(QCircleInitBean qCircleInitBean, FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        boolean z16;
        if (qCircleInitBean == null || qCircleInitBean.getSchemeAttrs() == null || feedCloudMeta$StFeed == null) {
            return false;
        }
        HashMap<String, String> schemeAttrs = qCircleInitBean.getSchemeAttrs();
        if (!TextUtils.isEmpty(qCircleInitBean.getQQVideoBusinessFeedID())) {
            z16 = TextUtils.equals(qCircleInitBean.getQQVideoBusinessFeedID(), cq.f92752a.n(feedCloudMeta$StFeed));
        } else if (schemeAttrs.containsKey("feedid") && feedCloudMeta$StFeed.f398449id.get().replace("share_fake_", "").equals(schemeAttrs.get("feedid"))) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (schemeAttrs == null || !z16 || !schemeAttrs.containsKey(QCircleSchemeAttr.Detail.CURRENT_TIME) || schemeAttrs.get(QCircleSchemeAttr.Detail.CURRENT_TIME) == null) {
            return false;
        }
        return true;
    }

    public static boolean isFeedOwner(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null) {
            return false;
        }
        if (feedCloudMeta$StFeed.isRecomFd.get()) {
            return isOwner(feedCloudMeta$StFeed.recomForward.poster.get());
        }
        return isOwner(feedCloudMeta$StFeed.poster.get());
    }

    public static boolean isFollow(int i3) {
        return i3 == 1 || i3 == 3;
    }

    public static boolean isFriend(String str) {
        return QCircleCommonUtil.isFriend(str);
    }

    public static boolean isFromMainProduct(Context context) {
        QCircleInitBean qCircleInitBean = getQCircleInitBean(context);
        if (qCircleInitBean != null && qCircleInitBean.getFromPage() == 1) {
            return true;
        }
        return false;
    }

    public static boolean isFromMainProductOrMessage(Context context) {
        QCircleInitBean qCircleInitBean = getQCircleInitBean(context);
        if (qCircleInitBean != null && (qCircleInitBean.getFromPage() == 1 || qCircleInitBean.getFromPage() == 2)) {
            return true;
        }
        return false;
    }

    public static boolean isFromPadNavigation(Context context) {
        HashMap<String, String> beanAttrs = getBeanAttrs(context);
        if (beanAttrs != null && String.valueOf(1004).equals(beanAttrs.get("key_jump_from"))) {
            return true;
        }
        return false;
    }

    public static boolean isGalleryPageOnShow() {
        return sIsGalleryPageOnShow;
    }

    public static boolean isHDRVideo(Object obj) {
        FeedCloudMeta$StVideo feedCloudMeta$StVideo;
        if (obj instanceof FeedCloudMeta$StFeed) {
            feedCloudMeta$StVideo = ((FeedCloudMeta$StFeed) obj).video.get();
        } else if (obj instanceof e30.b) {
            feedCloudMeta$StVideo = ((e30.b) obj).g().video.get();
        } else {
            feedCloudMeta$StVideo = null;
        }
        if (obj instanceof FeedCloudMeta$StVideo) {
            feedCloudMeta$StVideo = (FeedCloudMeta$StVideo) obj;
        }
        if (feedCloudMeta$StVideo == null) {
            QLog.w(TAG, 1, "isHDRVideo() false, invalid reportData");
            return false;
        }
        boolean z16 = feedCloudMeta$StVideo.attachOption.isHdrVideo.get();
        QLog.w(TAG, 1, "isHDRVideo()\uff1a" + z16 + "|" + feedCloudMeta$StVideo.fileId.get());
        return z16;
    }

    public static boolean isHasLike(QQCircleFeedBase$StPolyLike qQCircleFeedBase$StPolyLike, QQCircleFeedBase$StLikeBusiData qQCircleFeedBase$StLikeBusiData) {
        Iterator<String> it = qQCircleFeedBase$StLikeBusiData.likeIDs.get().iterator();
        while (it.hasNext()) {
            if (qQCircleFeedBase$StPolyLike.polyLikeID.get().equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isInLocalActivity(Activity activity) {
        if (activity != null && activity.getWindow() != null) {
            if (isQFSTabNativeFragmentMode(activity)) {
                return true;
            }
            return activity.getWindow().getDecorView().getParent() instanceof View;
        }
        QLog.e(TAG, 1, "invoke isInLocalActivity error with null activity");
        return false;
    }

    public static boolean isInMainTab(int i3) {
        if (i3 != 503 && i3 != 501 && i3 != 591 && i3 != 504) {
            return false;
        }
        return true;
    }

    @Deprecated
    public static boolean isInQCircle() {
        IASEngineDelegate asEngineDelegate = ASInject.g().getAsEngineDelegate();
        if (asEngineDelegate == null) {
            return false;
        }
        if (!asEngineDelegate.isOnThirdTab(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE) && ((isTabMode() || !QCircleReportHelper.isQQCircleActive()) && (!isTabMode() || !QCircleReportHelper.isQCircleNotFolderPageActive()))) {
            return false;
        }
        return true;
    }

    public static boolean isInQCircleNew() {
        return kc0.a.d();
    }

    public static boolean isIsECFloatWebViewOnShow() {
        return sIsECFloatWebViewOnShow;
    }

    public static boolean isJumpToQQProfileBeated(List<Integer> list) {
        if (list != null && list.contains(26)) {
            return true;
        }
        return false;
    }

    public static boolean isLocalHdr(TaskInfo taskInfo) {
        try {
            if (taskInfo.getTransParams() == null) {
                return false;
            }
            Object obj = taskInfo.getTransParams().get("qcircle_wink_task_launch_params");
            if (!(obj instanceof WinkPublishParams)) {
                return false;
            }
            WinkPublishParams winkPublishParams = (WinkPublishParams) obj;
            if (winkPublishParams.getMediaParamsList() != null && winkPublishParams.getMediaParamsList().size() != 0) {
                MediaParams mediaParams = winkPublishParams.getMediaParamsList().get(0);
                if (!(mediaParams instanceof VideoParams)) {
                    return false;
                }
                VideoParams videoParams = (VideoParams) mediaParams;
                if (videoParams.getOriginVideoParams() != null && videoParams.getOriginVideoParams().size() != 0) {
                    return videoParams.getOriginVideoParams().get(0).isHDR();
                }
            }
            return false;
        } catch (Exception e16) {
            QLog.d(TAG, 1, "isLocalHdr:", e16);
            return false;
        }
    }

    public static boolean isNavigationBarExist(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        if (viewGroup != null) {
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                viewGroup.getChildAt(i3).getContext().getPackageName();
                if (viewGroup.getChildAt(i3).getId() != -1 && NAVIGATION.equals(activity.getResources().getResourceEntryName(viewGroup.getChildAt(i3).getId())) && viewGroup.getChildAt(i3).getHeight() != 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isNearBy(QCircleTabInfo qCircleTabInfo, int i3) {
        QQCircleFeedBase$StTabInfo qQCircleFeedBase$StTabInfo;
        if (qCircleTabInfo == null || (qQCircleFeedBase$StTabInfo = qCircleTabInfo.mTab) == null || qQCircleFeedBase$StTabInfo.subTabInfo.size() <= i3 || qCircleTabInfo.mTab.subTabInfo.get(i3).sourceType.get() != 1) {
            return false;
        }
        return true;
    }

    public static boolean isNewFolderPage(Context context) {
        boolean z16;
        HashMap<String, String> beanAttrs = getBeanAttrs(context);
        if (beanAttrs != null && String.valueOf(11).equals(beanAttrs.get("key_jump_from"))) {
            z16 = true;
        } else {
            z16 = false;
        }
        return !z16;
    }

    public static boolean isOwner(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        return feedCloudMeta$StUser != null && HostDataTransUtils.getAccount().equals(feedCloudMeta$StUser.f398463id.get());
    }

    public static boolean isPrivateFeed(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed == null || !isFeedOwner(feedCloudMeta$StFeed) || feedCloudMeta$StFeed.right.ugcRight.rightFlag.get() != 2) {
            return false;
        }
        return true;
    }

    public static boolean isQFSTabNativeFragmentMode(Context context) {
        if (context == null) {
            return false;
        }
        return kc0.a.c(context.getClass().getName());
    }

    public static boolean isQQSVipUser(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        int i3;
        if (feedCloudMeta$StUser != null) {
            VipInfoForBusiness vipInfoForBusiness = new VipInfoForBusiness(feedCloudMeta$StUser.f398463id.get());
            vipInfoForBusiness.fromBuffer(feedCloudMeta$StUser.qq_vip.get().toByteArray());
            i3 = vipInfoForBusiness.getNameplateType();
        } else {
            i3 = 0;
        }
        if (i3 != NamePlateVipType.SUPERVIP.value && i3 != NamePlateVipType.SUPERVIP_YEAR.value && i3 != NamePlateVipType.BIGCLUB.value && i3 != NamePlateVipType.BIGCLUB_YEAR.value) {
            return false;
        }
        return true;
    }

    public static boolean isQUIC(Object obj) {
        FeedCloudMeta$StVideo feedCloudMeta$StVideo;
        boolean z16 = false;
        if (!isQuicOpen()) {
            QLog.w(TAG, 1, "isQUIC() false, WNS close");
            return false;
        }
        if (obj instanceof FeedCloudMeta$StFeed) {
            feedCloudMeta$StVideo = ((FeedCloudMeta$StFeed) obj).video.get();
        } else if (obj instanceof e30.b) {
            feedCloudMeta$StVideo = ((e30.b) obj).g().video.get();
        } else {
            feedCloudMeta$StVideo = null;
        }
        if (obj instanceof FeedCloudMeta$StVideo) {
            feedCloudMeta$StVideo = (FeedCloudMeta$StVideo) obj;
        }
        if (feedCloudMeta$StVideo == null) {
            QLog.w(TAG, 1, "isQUIC() false, invalid reportData");
            return false;
        }
        if (feedCloudMeta$StVideo.isQuic.get() != 0) {
            z16 = true;
        }
        QLog.w(TAG, 1, "isQUIC()\uff1a" + z16 + "|" + feedCloudMeta$StVideo.fileId.get());
        return z16;
    }

    private static boolean isQuicOpen() {
        if (!sGetQuicOpenResult) {
            sQuicOpenResult = uq3.c.D6();
            sGetQuicOpenResult = true;
        }
        return sQuicOpenResult;
    }

    public static boolean isRequestSecurityHit(long j3) {
        if (j3 == 10009) {
            return true;
        }
        return false;
    }

    public static boolean isSharePanelOnShow() {
        return sIsSharePanelOnShow;
    }

    public static boolean isSplitModeInnerBackClk() {
        boolean z16 = sIsSplitModeInnerBackClk;
        sIsSplitModeInnerBackClk = false;
        return z16;
    }

    public static boolean isTabMode() {
        if (sIsTabModeJudgeByQCircleFrame) {
            if (QCircleApplication.isRDMVersion() || QLog.isColorLevel()) {
                QLog.d(TAG, 1, "isTabMode judge by qcircle frame");
            }
            return true;
        }
        return uq3.c.M6();
    }

    public static boolean isTabModeForPad() {
        boolean z16 = true;
        if (QzoneConfig.getInstance().getConfig("qqcircle", "secondary_key_enable_pad_tab_mode_flag_split", 1) != 1) {
            z16 = false;
        }
        if (!z16 || !bz.t()) {
            return false;
        }
        return sIsTabModeForPad;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008d A[Catch: Exception -> 0x00ef, TryCatch #0 {Exception -> 0x00ef, blocks: (B:4:0x0007, B:7:0x000e, B:9:0x0019, B:11:0x0020, B:13:0x0026, B:16:0x002e, B:20:0x003e, B:22:0x0045, B:24:0x004f, B:26:0x005d, B:30:0x0067, B:32:0x008d, B:35:0x00a5, B:37:0x00b5, B:38:0x00bf, B:40:0x00c5, B:42:0x00cc, B:44:0x00da, B:46:0x00e0, B:51:0x0038, B:52:0x00e8), top: B:2:0x0005 }] */
    /* JADX WARN: Type inference failed for: r6v14, types: [android.content.Context] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isTopActivityInQCircle(Activity activity) {
        ComponentName componentName;
        boolean z16;
        String str;
        try {
            if (activity == null) {
                QLog.d(TAG, 1, "[isTopActivityInQCircle] activity should not be null.");
                return false;
            }
            ActivityManager activityManager = (ActivityManager) activity.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            if (activityManager == null) {
                QLog.d(TAG, 1, "[isTopActivityInQCircle] am should not be null.");
                return false;
            }
            List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
            if (runningTasks != null && runningTasks.size() != 0) {
                ActivityManager.RunningTaskInfo runningTaskInfo = runningTasks.get(0);
                if (runningTaskInfo != null) {
                    componentName = runningTaskInfo.topActivity;
                } else {
                    componentName = null;
                }
                if (componentName == null) {
                    QLog.d(TAG, 1, "[isTopActivityInQCircle] top actvitiy component name should not be null.");
                    return false;
                }
                String className = componentName.getClassName();
                if (!uq3.c.n7()) {
                    String name = activity.getClass().getName();
                    if (!kc0.a.f(className) && !isTopSandboxActivity(className)) {
                        z16 = false;
                        str = name + "|" + className + "result:" + z16;
                        if (!TextUtils.equals(str, sTopActivityInQCirclePrintStr)) {
                            sTopActivityInQCirclePrintStr = str;
                            QLog.d(TAG, 1, "[isTopActivityInQCircle] currentClassName:" + str);
                        }
                        return z16;
                    }
                    z16 = true;
                    str = name + "|" + className + "result:" + z16;
                    if (!TextUtils.equals(str, sTopActivityInQCirclePrintStr)) {
                    }
                    return z16;
                }
                View decorView = activity.getWindow().getDecorView();
                Activity activity2 = activity;
                if (decorView.getParent() instanceof View) {
                    activity2 = ((View) decorView.getParent()).getContext();
                }
                Context hostContext = ASEngineUtils.getHostContext(activity2);
                if (hostContext == null) {
                    QLog.d(TAG, 1, "[isTopActivityInQCircle] context should not be null.");
                    return false;
                }
                if (!className.equals(hostContext.getClass().getName()) && !kc0.a.f(className) && !isTopSandboxActivity(className)) {
                    return false;
                }
                return true;
            }
            QLog.d(TAG, 1, "[isTopActivityInQCircle] runningTaskInfos == null || runningTaskInfos.size() == 0.");
            return false;
        } catch (Exception e16) {
            QLog.d(TAG, 1, "[isTopActivityInQCircle] error:" + e16);
            return false;
        }
    }

    private static boolean isTopSandboxActivity(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String D0 = o.D0();
        if (TextUtils.isEmpty(D0)) {
            return false;
        }
        try {
            String str2 = D0 + " | topClassName: " + str;
            if (!TextUtils.equals(str2, sTopSandboxActivityPrintStr)) {
                sTopSandboxActivityPrintStr = str2;
                QLog.d(TAG, 1, "[isTopSandboxActivity] sandboxActivityWhiteList: " + str2);
            }
            for (String str3 : D0.split("\\|")) {
                if (str.startsWith(str3)) {
                    return true;
                }
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
        return false;
    }

    public static boolean isUserPushThisFeed(String str) {
        FeedCloudMeta$StPushList f16;
        if (TextUtils.isEmpty(str) || (f16 = QCirclePushInfoManager.e().f(str)) == null || f16.hasClickCount.get() <= 0) {
            return false;
        }
        return true;
    }

    public static boolean isVideoFeed(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        if (feedCloudMeta$StFeed != null && !TextUtils.isEmpty(feedCloudMeta$StFeed.video.fileId.get())) {
            return true;
        }
        return false;
    }

    public static void release() {
        k30.e.r();
        n.s();
        QCircleFolderTabInfoManager.A();
        QFSFetchFeedCountsHelper.v();
        QCircleOutboxTaskQueue.k().c();
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_close_db_cache", false)) {
            RFWThreadManager.getInstance().execOnFileThread(new Runnable() { // from class: com.tencent.biz.qqcircle.QCirclePluginUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    QCircleHostQzoneHelper.closeDbCacheService();
                }
            });
        }
        QCircleRelationGroupManager.instance().releaseCache();
        u30.d.d().r();
        wa0.c.l();
        i30.a.g();
        QCircleDeviceUsageUtils.e().g();
    }

    public static void setIsECFloatWebViewOnShow(boolean z16) {
        sIsECFloatWebViewOnShow = z16;
    }

    public static void setIsGalleryPageOnShow(boolean z16) {
        sIsGalleryPageOnShow = z16;
    }

    public static void setIsSharePanelOnShow(boolean z16) {
        sIsSharePanelOnShow = z16;
        if (!z16) {
            w20.a.j().a();
        }
    }

    public static void setIsSplitModeInnerBackClk(boolean z16) {
        sIsSplitModeInnerBackClk = z16;
    }

    public static void setIsTabModeJudgeByQCircleFrame(boolean z16) {
        sIsTabModeJudgeByQCircleFrame = z16;
    }

    public static void setsIsTabModeForPad(boolean z16) {
        sIsTabModeForPad = z16;
    }

    public static String getValueFromListEntry(List<FeedCloudCommon$Entry> list, String str, String str2) {
        if (list != null && list.size() > 0) {
            for (FeedCloudCommon$Entry feedCloudCommon$Entry : list) {
                if (feedCloudCommon$Entry.key.get().equals(str)) {
                    return feedCloudCommon$Entry.value.get();
                }
            }
        }
        return str2;
    }

    public static boolean isFollow(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        return (feedCloudMeta$StUser == null || isOwner(feedCloudMeta$StUser) || (feedCloudMeta$StUser.followState.get() != 1 && feedCloudMeta$StUser.followState.get() != 3)) ? false : true;
    }

    public static boolean isOwner(String str) {
        return QCircleCommonUtil.isOwner(str);
    }

    public static int getDefaultThemeColor() {
        return getDefaultThemeColor(QCircleCommonUtil.isInNightMode());
    }

    public static void printTouchEventLog(String str, MotionEvent motionEvent) {
    }
}
