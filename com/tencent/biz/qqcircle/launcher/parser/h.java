package com.tencent.biz.qqcircle.launcher.parser;

import android.app.Activity;
import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.part.ea;
import com.tencent.biz.qqcircle.launcher.QCircleLauncherUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.IQCircleCommonUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.beans.QCircleSchemeBean;
import cooperation.qqcircle.report.QCircleReportBean;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StImage;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudMeta$StVideo;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J$\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u001a\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0014\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/biz/qqcircle/launcher/parser/h;", "Lcom/tencent/biz/qqcircle/launcher/parser/a;", "Lcom/tencent/biz/qqcircle/beans/QCircleInitBean;", "initBean", "", "", Node.ATTRS_ATTR, "", "o", "Landroid/content/Context;", "ctx", "Lcooperation/qqcircle/beans/QCircleSchemeBean;", "schemeBean", "f", "b", "<init>", "()V", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class h extends a {
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0060, code lost:
    
        r5 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00e8, code lost:
    
        r9 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x000c, code lost:
    
        r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0104, code lost:
    
        r9 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0143, code lost:
    
        r5 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x018d, code lost:
    
        r6 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0036, code lost:
    
        r5 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void o(QCircleInitBean initBean, Map<String, String> attrs) {
        int i3;
        QCircleReportBean qCircleReportBean;
        int i16;
        int i17;
        Integer intOrNull;
        Integer intOrNull2;
        int i18;
        int i19;
        Integer intOrNull3;
        Integer intOrNull4;
        Long longOrNull;
        Integer intOrNull5;
        Integer intOrNull6;
        String str = attrs.get("sourcetype");
        boolean z16 = false;
        if (str != null && intOrNull6 != null) {
            i3 = intOrNull6.intValue();
        } else {
            i3 = 0;
        }
        boolean areEqual = Intrinsics.areEqual(attrs.get(QCircleSchemeAttr.Detail.IS_SINGLE_FEED), "1");
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
        String str2 = attrs.get("type");
        if (str2 != null && intOrNull5 != null) {
            feedCloudMeta$StFeed.type.set(intOrNull5.intValue());
        }
        String str3 = attrs.get("feedid");
        if (str3 != null) {
            feedCloudMeta$StFeed.f398449id.set(str3);
        }
        String str4 = attrs.get("createtime");
        if (str4 != null && longOrNull != null) {
            feedCloudMeta$StFeed.createTime.set(longOrNull.longValue());
        }
        String str5 = attrs.get("uin");
        String str6 = "";
        if (str5 != null) {
            FeedCloudMeta$StUser feedCloudMeta$StUser = new FeedCloudMeta$StUser();
            feedCloudMeta$StUser.f398463id.set(str5);
            PBStringField pBStringField = feedCloudMeta$StUser.nick;
            String str7 = attrs.get("nick");
            if (str7 == null) {
                str7 = "";
            }
            pBStringField.set(str7);
            feedCloudMeta$StUser.icon.setHasFlag(true);
            PBStringField pBStringField2 = feedCloudMeta$StUser.icon.iconUrl;
            String str8 = attrs.get(QCircleSchemeAttr.Detail.AVATAR_URL);
            if (str8 == null) {
                str8 = "";
            }
            pBStringField2.set(str8);
            feedCloudMeta$StFeed.poster.set(feedCloudMeta$StUser);
        }
        String str9 = attrs.get("content");
        if (str9 != null) {
            feedCloudMeta$StFeed.content.set(str9);
        }
        String str10 = attrs.get(QCircleSchemeAttr.Detail.COVER_PIC_URL);
        if (str10 != null) {
            FeedCloudMeta$StImage feedCloudMeta$StImage = new FeedCloudMeta$StImage();
            feedCloudMeta$StImage.picUrl.set(str10);
            PBUInt32Field pBUInt32Field = feedCloudMeta$StImage.width;
            String str11 = attrs.get(QCircleSchemeAttr.Detail.COVER_WIDTH);
            if (str11 != null && intOrNull4 != null) {
                i18 = intOrNull4.intValue();
            } else {
                i18 = 0;
            }
            pBUInt32Field.set(i18);
            PBUInt32Field pBUInt32Field2 = feedCloudMeta$StImage.height;
            String str12 = attrs.get(QCircleSchemeAttr.Detail.COVER_HEIGHT);
            if (str12 != null && intOrNull3 != null) {
                i19 = intOrNull3.intValue();
            } else {
                i19 = 0;
            }
            pBUInt32Field2.set(i19);
            feedCloudMeta$StFeed.cover.set(feedCloudMeta$StImage);
        }
        String str13 = attrs.get(QCircleSchemeAttr.Detail.RECOM_REASON);
        if (str13 != null) {
            feedCloudMeta$StFeed.recomInfo.setHasFlag(true);
            feedCloudMeta$StFeed.recomInfo.recomReasonV2.setHasFlag(true);
            feedCloudMeta$StFeed.recomInfo.recomReasonV2.recomReason.set(str13);
        }
        String str14 = attrs.get(QCircleSchemeAttr.Detail.VIEW_NUM);
        if (str14 != null && intOrNull2 != null) {
            int intValue = intOrNull2.intValue();
            feedCloudMeta$StFeed.visitorInfo.setHasFlag(true);
            feedCloudMeta$StFeed.visitorInfo.viewCount.set(intValue);
        }
        String str15 = attrs.get("file_id");
        if (str15 != null) {
            FeedCloudMeta$StVideo feedCloudMeta$StVideo = new FeedCloudMeta$StVideo();
            feedCloudMeta$StVideo.fileId.set(str15);
            PBStringField pBStringField3 = feedCloudMeta$StVideo.playUrl;
            String str16 = attrs.get("play_url");
            if (str16 != null) {
                str6 = str16;
            }
            pBStringField3.set(str6);
            PBUInt32Field pBUInt32Field3 = feedCloudMeta$StVideo.duration;
            String str17 = attrs.get("duration");
            if (str17 != null && intOrNull != null) {
                i16 = intOrNull.intValue();
            } else {
                i16 = 0;
            }
            pBUInt32Field3.set(i16);
            PBUInt32Field pBUInt32Field4 = feedCloudMeta$StVideo.isQuic;
            String str18 = attrs.get(QCircleSchemeAttr.Detail.IS_QUIC);
            if (str18 != null && Boolean.parseBoolean(str18)) {
                i17 = 1;
            } else {
                i17 = 0;
            }
            pBUInt32Field4.set(i17);
            feedCloudMeta$StFeed.video.set(feedCloudMeta$StVideo);
        }
        QCircleExtraTypeInfo qCircleExtraTypeInfo = new QCircleExtraTypeInfo();
        qCircleExtraTypeInfo.sourceType = i3;
        String str19 = attrs.get(QCircleSchemeAttr.Detail.FROM_ELEMENT);
        if (str19 != null) {
            qCircleReportBean = new QCircleReportBean();
            qCircleReportBean.setFromElement(str19);
        } else {
            qCircleReportBean = null;
        }
        initBean.setExtraTypeInfo(qCircleExtraTypeInfo);
        if (feedCloudMeta$StFeed.f398449id.has() && feedCloudMeta$StFeed.createTime.has() && feedCloudMeta$StFeed.poster.has()) {
            z16 = true;
        }
        if (z16) {
            initBean.setFeed(feedCloudMeta$StFeed);
        }
        initBean.setDisableFoot(Intrinsics.areEqual(attrs.get(QCircleSchemeAttr.Detail.DISABLE_FOOT), "1"));
        initBean.setSingleFeed(areEqual);
        initBean.setFromReportBean(qCircleReportBean);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.launcher.parser.a
    public void b(@NotNull QCircleSchemeBean schemeBean, @NotNull QCircleInitBean initBean) {
        Intrinsics.checkNotNullParameter(schemeBean, "schemeBean");
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        super.b(schemeBean, initBean);
        if (initBean.getEnterTime() <= 0) {
            initBean.setEnterTime(System.currentTimeMillis());
        }
    }

    @Override // com.tencent.biz.qqcircle.launcher.parser.a
    public void f(@NotNull Context ctx, @Nullable QCircleSchemeBean schemeBean) {
        HashMap<String, String> hashMap;
        Activity topActivity;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        if (!(ctx instanceof Activity) && (topActivity = ((IQCircleCommonUtil) QRoute.api(IQCircleCommonUtil.class)).getTopActivity()) != null && !topActivity.isFinishing()) {
            ctx = topActivity;
        }
        if (schemeBean != null) {
            hashMap = schemeBean.getAttrs();
        } else {
            hashMap = null;
        }
        if (hashMap == null) {
            QLog.e("QCirclePublicAccountStaggerParser", 1, "schema attrs is null");
            return;
        }
        QCircleInitBean qCircleInitBean = new QCircleInitBean();
        b(schemeBean, qCircleInitBean);
        i(qCircleInitBean, hashMap);
        o(qCircleInitBean, hashMap);
        com.tencent.biz.qqcircle.launcher.c.n0(ctx, qCircleInitBean);
        ea.INSTANCE.a();
        QCircleLauncherUtil.c();
    }
}
