package com.tencent.biz.qqcircle.immersive.utils;

import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.utils.QFSAsyncUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.Map;
import qqcircle.QQCircleBase$StUserBusiData;
import qqcircle.QQCircleDitto$StItemInfo;
import qqcircle.QQCircleDitto$StPymkItemInfoBizData;

/* compiled from: P */
/* loaded from: classes4.dex */
public class p {

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends QFSAsyncUtils.Callback<Void, Integer> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ QQCircleDitto$StItemInfo f90232a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Consumer f90233b;

        a(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo, Consumer consumer) {
            this.f90232a = qQCircleDitto$StItemInfo;
            this.f90233b = consumer;
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSAsyncUtils.Callback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer doBackgroundAction(Void... voidArr) {
            QQCircleDitto$StPymkItemInfoBizData qQCircleDitto$StPymkItemInfoBizData = new QQCircleDitto$StPymkItemInfoBizData();
            try {
                qQCircleDitto$StPymkItemInfoBizData.mergeFrom(this.f90232a.bizData.get().toByteArray());
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("QFSCertificationUtils", 1, "[getAuthType] error: ", e16);
            }
            return Integer.valueOf(QCirclePluginUtil.getAuthType(qQCircleDitto$StPymkItemInfoBizData.recomUser));
        }

        @Override // com.tencent.biz.qqcircle.utils.QFSAsyncUtils.Callback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void doMainAction(Integer num) {
            this.f90233b.accept(num);
        }
    }

    public static Map<String, Object> a(FeedCloudMeta$StFeed feedCloudMeta$StFeed, QQCircleBase$StUserBusiData qQCircleBase$StUserBusiData) {
        Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.poster != null && qQCircleBase$StUserBusiData != null) {
            buildElementParams.put("xsj_feed_id", feedCloudMeta$StFeed.f398449id.get());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTHOR_UIN, feedCloudMeta$StFeed.poster.f398463id.get());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_VERIFY_MARK_LEVEL1_TYPE, Integer.valueOf(qQCircleBase$StUserBusiData.certification.get()));
        }
        return buildElementParams;
    }

    public static void b(@NonNull QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo, @NonNull Consumer<Integer> consumer) {
        QFSAsyncUtils.executeSub(new a(qQCircleDitto$StItemInfo, consumer), new Void[0]);
    }

    public static String c(int i3) {
        int f16 = f(i3);
        if (f16 == 2) {
            return QCircleSkinHelper.getInstance().getUrl("qvideo_feed_icon_kol_blue");
        }
        if (f16 == 1) {
            return QCircleSkinHelper.getInstance().getUrl("qvideo_feed_icon_kol_youzhi");
        }
        if (f16 == 3) {
            return QCircleSkinHelper.getInstance().getUrl("qvideo_feed_icon_kol_jinjie");
        }
        if (f16 == 4) {
            return QCircleSkinHelper.getInstance().getUrl("qvideo_feed_icon_kol_lingyu");
        }
        return "";
    }

    public static String d(@NonNull QQCircleBase$StUserBusiData qQCircleBase$StUserBusiData) {
        return c(qQCircleBase$StUserBusiData.certification.get());
    }

    public static String e(@NonNull QQCircleBase$StUserBusiData qQCircleBase$StUserBusiData) {
        int f16 = f(qQCircleBase$StUserBusiData.certification.get());
        if (f16 != 1 && f16 != 3 && f16 != 4) {
            if (f16 == 2) {
                return qQCircleBase$StUserBusiData.blueCertifiDesc.get();
            }
            return "";
        }
        return qQCircleBase$StUserBusiData.certificationDesc.get();
    }

    public static int f(int i3) {
        if ((i3 & 2) > 0) {
            return 2;
        }
        if ((i3 & 1) > 0) {
            return 1;
        }
        if ((i3 & 8) > 0) {
            return 3;
        }
        if ((i3 & 4) > 0) {
            return 4;
        }
        return 0;
    }

    public static String g(int i3) {
        int f16 = f(i3);
        if (f16 == 2) {
            return "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/8983/tips/qvideo_tips_icon_kol_qiye.png";
        }
        if (f16 == 1) {
            return "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/8983/tips/qvideo_tips_icon_kol_youzhi.png";
        }
        if (f16 == 3) {
            return "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/8983/tips/qvideo_tips_icon_kol_jinjie.png";
        }
        if (f16 == 4) {
            return "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/8983/tips/qvideo_tips_icon_kol_lingyu.png";
        }
        return "";
    }
}
