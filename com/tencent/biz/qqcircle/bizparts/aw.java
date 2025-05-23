package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QFSCommentInfo;
import com.tencent.biz.qqcircle.beans.QFSCommentInputWindowConfig;
import com.tencent.biz.qqcircle.comment.recpic.CmtClusterBean;
import com.tencent.biz.qqcircle.comment.recpic.FeedClusterBean;
import com.tencent.biz.qqcircle.comment.recpic.QFSCommentRecPicClusterHelper;
import com.tencent.biz.qqcircle.comment.recpic.QFSFeedCategoryConfig;
import com.tencent.biz.qqcircle.comment.recpic.QFSRecPicInfo;
import com.tencent.biz.qqcircle.comment.recpic.al;
import com.tencent.biz.qqcircle.comment.recpic.sorter.StrategyImage;
import com.tencent.biz.qqcircle.events.QCircleCommentUpdateEvent;
import com.tencent.biz.qqcircle.events.QCirclePanelStateEvent;
import com.tencent.biz.qqcircle.events.QCircleResetCommentBlockEvent;
import com.tencent.biz.qqcircle.events.QFSKMeansResultEvent;
import com.tencent.biz.qqcircle.events.QFSRecPicStateEvent;
import com.tencent.biz.qqcircle.events.QFSReplyListEvent;
import com.tencent.biz.qqcircle.immersive.model.bottombarrage.QFSVideoPauseEvent;
import com.tencent.biz.qqcircle.immersive.utils.bi;
import com.tencent.biz.qqcircle.immersive.views.QFSVideoView;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.mobileqq.auto.engine.event.ASEngineTabStatusEvent;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.auto.engine.lib.ASInject;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.wink.model.MediaScanForwardResult;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StReply;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 l2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u0005:\u0001mB\u0007\u00a2\u0006\u0004\bj\u0010kJ\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J \u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002J\u0012\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010\u0011\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010\u0012\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010\u0013\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\tH\u0002J\u0012\u0010\u0016\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0012\u0010\u001b\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u001c\u001a\u00020\tH\u0002J\u0012\u0010\u001d\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\u0012\u0010 \u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0002J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!H\u0002J\b\u0010$\u001a\u00020\u0006H\u0002J\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020\"0'2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0!H\u0002J\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\"0!2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020)0!H\u0002J\u0012\u0010,\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010-\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010.\u001a\u00020\u0006H\u0002J\b\u0010/\u001a\u00020\u0006H\u0002J\u0010\u00101\u001a\u00020\u00062\u0006\u0010\n\u001a\u000200H\u0002J\u0016\u00104\u001a\u00020\u00062\f\u00103\u001a\b\u0012\u0004\u0012\u0002020!H\u0002J\u0012\u00107\u001a\u00020\u00062\b\u00106\u001a\u0004\u0018\u000105H\u0016J\u001c\u0010<\u001a\u00020\u00062\b\u00109\u001a\u0004\u0018\u0001082\b\u0010;\u001a\u0004\u0018\u00010:H\u0016J\u001c\u0010@\u001a\u00020\u00062\b\u0010=\u001a\u0004\u0018\u00010\t2\b\u0010?\u001a\u0004\u0018\u00010>H\u0016J\u0012\u0010A\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010B\u001a\u00020\u00062\b\u00109\u001a\u0004\u0018\u000108H\u0016J$\u0010F\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030D0Cj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030D`EH\u0016J\u0012\u0010G\u001a\u00020\u00062\b\u00109\u001a\u0004\u0018\u000108H\u0016J\b\u0010H\u001a\u00020\tH\u0016J\b\u0010I\u001a\u00020\u0006H\u0016J\u0016\u0010K\u001a\u00020\u00062\f\u0010J\u001a\b\u0012\u0004\u0012\u0002020!H\u0016J\b\u0010L\u001a\u00020\u001eH\u0016R\u0018\u0010P\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010T\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010X\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010\\\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u001a\u0010_\u001a\b\u0012\u0004\u0012\u00020\"0'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010b\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010d\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010aR\u0016\u0010f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010aR\u001c\u0010i\u001a\b\u0012\u0004\u0012\u00020g0'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010^\u00a8\u0006n"}, d2 = {"Lcom/tencent/biz/qqcircle/bizparts/aw;", "Lcom/tencent/biz/qqcircle/immersive/part/u;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lcom/tencent/biz/qqcircle/comment/recpic/al$b;", "Lt20/a;", "", "ha", "ga", "", "type", "mainCate", "subCate", "G9", "L9", "simpleEvent", "V9", "W9", "R9", "S9", "text", "ia", "T9", "Lcom/tencent/biz/qqcircle/beans/QFSCommentInputWindowConfig;", DownloadInfo.spKey_Config, "Lcom/tencent/biz/qqcircle/beans/QFSCommentInfo;", "E9", "P9", "getFeedId", "U9", "", "F9", "O9", "", "Lcom/tencent/biz/qqcircle/comment/recpic/aj;", "da", "ca", "Lfeedcloud/FeedCloudMeta$StComment;", "comments", "", "J9", "Lfeedcloud/FeedCloudMeta$StReply;", "replies", "K9", "M9", "N9", "ea", LocaleUtils.L_JAPANESE, "", "X9", "Lcom/tencent/mobileqq/wink/model/MediaScanForwardResult;", ForwardMiniChooseFriendOption.RESULT_LIST, "ba", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "action", "", "args", "handleBroadcastMessage", "onReceiveEvent", "onPartResume", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "onPartDestroy", "getLogTag", "F3", "scanResultList", BdhLogUtil.LogTag.Tag_Req, "isPartEnable", "Lcom/tencent/biz/qqcircle/comment/recpic/al;", "d", "Lcom/tencent/biz/qqcircle/comment/recpic/al;", "mScreenshotObserver", "Lt40/b;", "e", "Lt40/b;", "mIFSTabIoc", "Le30/b;", "f", "Le30/b;", "feedBlockData", "Lfeedcloud/FeedCloudMeta$StFeed;", tl.h.F, "Lfeedcloud/FeedCloudMeta$StFeed;", "feed", "i", "Ljava/util/List;", "cmtPic", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "hasMatchFeed", BdhLogUtil.LogTag.Tag_Conn, "hasMatchFeedDesc", "D", "hasNotifyPanelGuide", "Lcom/tencent/biz/qqcircle/comment/recpic/QFSCommentRecPicClusterHelper$a;", "E", "strategyConfigList", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class aw extends com.tencent.biz.qqcircle.immersive.part.u implements SimpleEventReceiver<SimpleBaseEvent>, al.b, t20.a {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean hasMatchFeedDesc;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean hasNotifyPanelGuide;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.biz.qqcircle.comment.recpic.al mScreenshotObserver;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private t40.b mIFSTabIoc;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private e30.b feedBlockData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FeedCloudMeta$StFeed feed;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean hasMatchFeed;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<QFSRecPicInfo> cmtPic = new ArrayList();

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private List<QFSCommentRecPicClusterHelper.StrategyConfig> strategyConfigList = new ArrayList();

    private final QFSCommentInfo E9(QFSCommentInputWindowConfig config) {
        QFSCommentInfo qFSCommentInfo = new QFSCommentInfo();
        qFSCommentInfo.mFeedBlockData = this.feedBlockData;
        qFSCommentInfo.mFeed = this.feed;
        qFSCommentInfo.mReportBean = getReportBean();
        qFSCommentInfo.mRelocationScrollType = 100;
        qFSCommentInfo.mExtraTypeInfo = new QCircleExtraTypeInfo();
        qFSCommentInfo.mCmtPanelSource = 3;
        qFSCommentInfo.mInputWinConfig = config;
        return qFSCommentInfo;
    }

    private final boolean F9() {
        com.tencent.biz.qqcircle.comment.recpic.aa aaVar = com.tencent.biz.qqcircle.comment.recpic.aa.f83750a;
        if (!aaVar.k() && aaVar.E(getActivity()) && aaVar.z(this.feed)) {
            return true;
        }
        return false;
    }

    private final void G9(final String type, final String mainCate, final String subCate) {
        final long currentTimeMillis = System.currentTimeMillis();
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.ar
            @Override // java.lang.Runnable
            public final void run() {
                aw.H9(type, currentTimeMillis, this, mainCate, subCate);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(String type, long j3, final aw this$0, String mainCate, String subCate) {
        Intrinsics.checkNotNullParameter(type, "$type");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mainCate, "$mainCate");
        Intrinsics.checkNotNullParameter(subCate, "$subCate");
        ArrayList arrayList = new ArrayList();
        List<QFSRecPicInfo> I = QFSCommentRecPicClusterHelper.f83716a.I();
        int i3 = 0;
        for (QFSRecPicInfo qFSRecPicInfo : I) {
            if (qFSRecPicInfo.i().contains(type)) {
                StrategyImage strategyImage = new StrategyImage(qFSRecPicInfo.getPhotoId(), 2, qFSRecPicInfo.g().get(qFSRecPicInfo.i().indexOf(type)).floatValue(), qFSRecPicInfo.getPath(), null, 16, null);
                strategyImage.b().put("w", Integer.valueOf(qFSRecPicInfo.getMediaWidth()));
                strategyImage.b().put(tl.h.F, Integer.valueOf(qFSRecPicInfo.getMediaHeight()));
                arrayList.add(strategyImage);
                i3++;
            }
        }
        long currentTimeMillis = System.currentTimeMillis() - j3;
        QLog.d(QFSCommentPanelPart.TAG_REC_PIC_SCENE, 1, "feed match " + i3 + " pic, cost: " + currentTimeMillis + " ms, avg cost: " + (I.isEmpty() ? 0 : Float.valueOf((((float) currentTimeMillis) / I.size()) * 1000)));
        if (i3 == 0) {
            return;
        }
        this$0.ia("feed \u5339\u914d\u5230" + i3 + "\u5f20");
        com.tencent.biz.qqcircle.comment.recpic.ak.f83788a.j(new FeedClusterBean(mainCate, subCate, this$0.getFeedId(), i3, currentTimeMillis));
        final ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (com.tencent.biz.qqcircle.comment.recpic.ac.f83765a.a(this$0.L9(), ((StrategyImage) obj).getId())) {
                arrayList2.add(obj);
            }
        }
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.at
            @Override // java.lang.Runnable
            public final void run() {
                aw.I9(aw.this, arrayList2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(aw this$0, List candidate) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(candidate, "$candidate");
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this$0.feed;
        if (feedCloudMeta$StFeed != null) {
            QFSCommentRecPicClusterHelper qFSCommentRecPicClusterHelper = QFSCommentRecPicClusterHelper.f83716a;
            String str = feedCloudMeta$StFeed.f398449id.get();
            Intrinsics.checkNotNullExpressionValue(str, "stFeed.id.get()");
            qFSCommentRecPicClusterHelper.x(str, candidate);
        }
    }

    private final List<QFSRecPicInfo> J9(List<FeedCloudMeta$StComment> comments) {
        int collectionSizeOrDefault;
        List mutableList;
        boolean z16;
        Iterator<FeedCloudMeta$StComment> it;
        String str;
        ArrayList arrayList = new ArrayList();
        List<QFSRecPicInfo> list = this.cmtPic;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it5 = list.iterator();
        while (it5.hasNext()) {
            arrayList2.add(((QFSRecPicInfo) it5.next()).getPath());
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
        Iterator<FeedCloudMeta$StComment> it6 = comments.iterator();
        while (it6.hasNext()) {
            FeedCloudMeta$StComment next = it6.next();
            String commentPicUrl = next.commentPic.picUrl.get();
            String commentEmoPicUrl = next.expressionInfo.expressionURL.get();
            Intrinsics.checkNotNullExpressionValue(commentPicUrl, "commentPicUrl");
            boolean z17 = true;
            if (commentPicUrl.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && !mutableList.contains(commentPicUrl)) {
                mutableList.add(commentPicUrl);
                it = it6;
                str = "comment.id.get()";
                QFSRecPicInfo qFSRecPicInfo = new QFSRecPicInfo(commentPicUrl, null, 0, 0, 0, null, null, 126, null);
                String str2 = next.f398447id.get();
                Intrinsics.checkNotNullExpressionValue(str2, str);
                qFSRecPicInfo.j(str2);
                arrayList.add(qFSRecPicInfo);
            } else {
                it = it6;
                str = "comment.id.get()";
            }
            Intrinsics.checkNotNullExpressionValue(commentEmoPicUrl, "commentEmoPicUrl");
            if (commentEmoPicUrl.length() <= 0) {
                z17 = false;
            }
            if (z17 && !mutableList.contains(commentEmoPicUrl)) {
                mutableList.add(commentEmoPicUrl);
                QFSRecPicInfo qFSRecPicInfo2 = new QFSRecPicInfo(commentEmoPicUrl, null, 0, 0, 0, null, null, 126, null);
                String str3 = next.f398447id.get();
                Intrinsics.checkNotNullExpressionValue(str3, str);
                qFSRecPicInfo2.j(str3);
                arrayList.add(qFSRecPicInfo2);
            }
            List<FeedCloudMeta$StReply> list2 = next.vecReply.get();
            Intrinsics.checkNotNullExpressionValue(list2, "comment.vecReply.get()");
            arrayList.addAll(K9(list2));
            it6 = it;
        }
        return arrayList;
    }

    private final List<QFSRecPicInfo> K9(List<FeedCloudMeta$StReply> replies) {
        int collectionSizeOrDefault;
        List mutableList;
        boolean z16;
        String str;
        ArrayList arrayList = new ArrayList();
        List<QFSRecPicInfo> list = this.cmtPic;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList2.add(((QFSRecPicInfo) it.next()).getPath());
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList2);
        for (FeedCloudMeta$StReply feedCloudMeta$StReply : replies) {
            String replyPicUrl = feedCloudMeta$StReply.replyPic.picUrl.get();
            String replyEmoPicUrl = feedCloudMeta$StReply.expressionInfo.expressionURL.get();
            Intrinsics.checkNotNullExpressionValue(replyPicUrl, "replyPicUrl");
            boolean z17 = true;
            if (replyPicUrl.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 || mutableList.contains(replyPicUrl)) {
                str = "stReply.id.get()";
            } else {
                mutableList.add(replyPicUrl);
                str = "stReply.id.get()";
                QFSRecPicInfo qFSRecPicInfo = new QFSRecPicInfo(replyPicUrl, null, 0, 0, 0, null, null, 126, null);
                String str2 = feedCloudMeta$StReply.f398460id.get();
                Intrinsics.checkNotNullExpressionValue(str2, str);
                qFSRecPicInfo.j(str2);
                arrayList.add(qFSRecPicInfo);
            }
            Intrinsics.checkNotNullExpressionValue(replyEmoPicUrl, "replyEmoPicUrl");
            if (replyEmoPicUrl.length() <= 0) {
                z17 = false;
            }
            if (z17 && !mutableList.contains(replyEmoPicUrl)) {
                mutableList.add(replyEmoPicUrl);
                QFSRecPicInfo qFSRecPicInfo2 = new QFSRecPicInfo(replyEmoPicUrl, null, 0, 0, 0, null, null, 126, null);
                String str3 = feedCloudMeta$StReply.f398460id.get();
                Intrinsics.checkNotNullExpressionValue(str3, str);
                qFSRecPicInfo2.j(str3);
                arrayList.add(qFSRecPicInfo2);
            }
        }
        return arrayList;
    }

    private final String L9() {
        String str;
        PBStringField pBStringField;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.feed;
        if (feedCloudMeta$StFeed != null && (pBStringField = feedCloudMeta$StFeed.subCate) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    private final void M9(SimpleBaseEvent simpleEvent) {
        String str;
        PBStringField pBStringField;
        if (simpleEvent instanceof QCirclePanelStateEvent) {
            QCirclePanelStateEvent qCirclePanelStateEvent = (QCirclePanelStateEvent) simpleEvent;
            String feedId = qCirclePanelStateEvent.getFeedId();
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.feed;
            if (feedCloudMeta$StFeed != null && (pBStringField = feedCloudMeta$StFeed.f398449id) != null) {
                str = pBStringField.get();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(feedId, str) && qCirclePanelStateEvent.isShowing()) {
                com.tencent.biz.qqcircle.comment.recpic.z zVar = com.tencent.biz.qqcircle.comment.recpic.z.f83900a;
                Activity activity = getActivity();
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                if (zVar.d(activity)) {
                    QFSCommentRecPicClusterHelper.f83716a.O(this);
                }
            }
        }
    }

    private final void N9(SimpleBaseEvent simpleEvent) {
        if (simpleEvent instanceof QCircleResetCommentBlockEvent) {
            this.hasMatchFeed = false;
            this.hasMatchFeedDesc = false;
            this.cmtPic.clear();
            this.hasNotifyPanelGuide = false;
            QFSCommentRecPicClusterHelper qFSCommentRecPicClusterHelper = QFSCommentRecPicClusterHelper.f83716a;
            String str = ((QCircleResetCommentBlockEvent) simpleEvent).feedId;
            Intrinsics.checkNotNullExpressionValue(str, "simpleEvent.feedId");
            qFSCommentRecPicClusterHelper.C(str);
        }
    }

    private final void O9(SimpleBaseEvent simpleEvent) {
        int collectionSizeOrDefault;
        if (F9() && (simpleEvent instanceof QCircleCommentUpdateEvent)) {
            QCircleCommentUpdateEvent qCircleCommentUpdateEvent = (QCircleCommentUpdateEvent) simpleEvent;
            if (qCircleCommentUpdateEvent.contextHashCode != getContext().hashCode()) {
                QLog.d("QFSCommentRecPicHandlePart", 1, "[handleCommentUpdateEvent] context hashcode not same.");
                return;
            }
            int i3 = qCircleCommentUpdateEvent.eventStatus;
            if (i3 == 1 || i3 == 2) {
                List<FeedCloudMeta$StComment> list = qCircleCommentUpdateEvent.commentList;
                Intrinsics.checkNotNullExpressionValue(list, "simpleEvent.commentList");
                List<QFSRecPicInfo> J9 = J9(list);
                if (J9.isEmpty()) {
                    QLog.d("QFSCommentRecPicHandlePart", 1, "[handleCommentUpdateEvent] has no new cmt pic.");
                    return;
                }
                this.cmtPic.addAll(J9);
                List<QFSRecPicInfo> da5 = da();
                QLog.d("QFSCommentRecPicHandlePart", 1, "[handleCommentUpdateEvent] fetch " + da5.size() + " comment pic.");
                if (da5.isEmpty()) {
                    return;
                }
                ca();
                QFSCommentRecPicClusterHelper qFSCommentRecPicClusterHelper = QFSCommentRecPicClusterHelper.f83716a;
                String feedId = getFeedId();
                long currentTimeMillis = System.currentTimeMillis();
                List<QFSRecPicInfo> list2 = da5;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(((QFSRecPicInfo) it.next()).getCmtId());
                }
                qFSCommentRecPicClusterHelper.f0(da5, feedId, new CmtClusterBean(currentTimeMillis, 0, 0, 0.0d, arrayList));
            }
        }
    }

    private final void P9(SimpleBaseEvent simpleEvent) {
        List<QFSCommentRecPicClusterHelper.StrategyConfig> listOf;
        if (simpleEvent instanceof QFSKMeansResultEvent) {
            QFSKMeansResultEvent qFSKMeansResultEvent = (QFSKMeansResultEvent) simpleEvent;
            if (!Intrinsics.areEqual(qFSKMeansResultEvent.getFeedId(), getFeedId())) {
                QLog.d("QFSCommentRecPicHandlePart", 1, "[handleKMeansEvent] feed id not same.");
                return;
            }
            QFSCommentRecPicClusterHelper.StrategyConfig strategyConfig = new QFSCommentRecPicClusterHelper.StrategyConfig(getFeedId(), 3, qFSKMeansResultEvent.getFeatures(), qFSKMeansResultEvent.getThreshold(), null, 16, null);
            QFSCommentRecPicClusterHelper qFSCommentRecPicClusterHelper = QFSCommentRecPicClusterHelper.f83716a;
            if (!qFSCommentRecPicClusterHelper.K()) {
                QLog.d("QFSCommentRecPicHandlePart", 1, "add kmeans config to strategyConfigList. ");
                this.strategyConfigList.add(strategyConfig);
            }
            if (!com.tencent.biz.qqcircle.comment.recpic.aa.f83750a.E(getActivity())) {
                QLog.d("QFSCommentRecPicHandlePart", 1, "[handleKMeansEvent] has no permission. ");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            List<QFSRecPicInfo> I = qFSCommentRecPicClusterHelper.I();
            listOf = CollectionsKt__CollectionsJVMKt.listOf(strategyConfig);
            final List<StrategyImage> N = qFSCommentRecPicClusterHelper.N(I, listOf);
            int size = N.size();
            QLog.d(QFSCommentPanelPart.TAG_REC_PIC_SCENE, 1, "[handleKMeansEvent] k cluster result size: " + size + ", cost: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            if (size == 0) {
                return;
            }
            ia("\u56fe\u7247\u805a\u7c7b\u5230" + size + "\u5f20");
            com.tencent.biz.qqcircle.comment.recpic.ak akVar = com.tencent.biz.qqcircle.comment.recpic.ak.f83788a;
            CmtClusterBean reportBean = qFSKMeansResultEvent.getReportBean();
            reportBean.b(System.currentTimeMillis() - reportBean.getCost());
            reportBean.d(size);
            akVar.i(reportBean);
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.aq
                @Override // java.lang.Runnable
                public final void run() {
                    aw.Q9(aw.this, N);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q9(aw this$0, List kMeansMatchPic) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(kMeansMatchPic, "$kMeansMatchPic");
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this$0.feed;
        if (feedCloudMeta$StFeed != null) {
            QFSCommentRecPicClusterHelper qFSCommentRecPicClusterHelper = QFSCommentRecPicClusterHelper.f83716a;
            String str = feedCloudMeta$StFeed.f398449id.get();
            Intrinsics.checkNotNullExpressionValue(str, "stFeed.id.get()");
            qFSCommentRecPicClusterHelper.x(str, kMeansMatchPic);
        }
    }

    private final void R9(SimpleBaseEvent simpleEvent) {
        Unit unit;
        if (simpleEvent instanceof QFSRecPicStateEvent) {
            QFSRecPicStateEvent qFSRecPicStateEvent = (QFSRecPicStateEvent) simpleEvent;
            if (qFSRecPicStateEvent.getState() == 6 && TextUtils.equals(qFSRecPicStateEvent.getFeedId(), getFeedId()) && this.feedBlockData != null) {
                QLog.d("QFSCommentRecPicHandlePart", 1, "handleOpenInputWindowEvent");
                QFSCommentInputWindowConfig qFSCommentInputWindowConfig = new QFSCommentInputWindowConfig();
                qFSCommentInputWindowConfig.isShowRecPicBar = true;
                QFSCommentInfo E9 = E9(qFSCommentInputWindowConfig);
                t40.b bVar = this.mIFSTabIoc;
                if (bVar != null) {
                    bVar.onHandlerMessage("event_open_comment_input", E9);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    getPartManager().broadcastMessage("comment_input_window_show", E9);
                }
            }
        }
    }

    private final void S9(SimpleBaseEvent simpleEvent) {
        String str;
        PBStringField pBStringField;
        PBStringField pBStringField2;
        if (simpleEvent instanceof QFSVideoPauseEvent) {
            if (com.tencent.biz.qqcircle.comment.recpic.aa.f83750a.u()) {
                QLog.d("QFSCommentRecPicHandlePart", 1, "[handlePauseEvent] disableVideoFrameCut");
                return;
            }
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.feed;
            String str2 = null;
            if (feedCloudMeta$StFeed != null && (pBStringField2 = feedCloudMeta$StFeed.f398449id) != null) {
                str = pBStringField2.get();
            } else {
                str = null;
            }
            QFSVideoPauseEvent qFSVideoPauseEvent = (QFSVideoPauseEvent) simpleEvent;
            if (!TextUtils.equals(str, qFSVideoPauseEvent.mFeedId)) {
                FeedCloudMeta$StFeed feedCloudMeta$StFeed2 = this.feed;
                if (feedCloudMeta$StFeed2 != null && (pBStringField = feedCloudMeta$StFeed2.f398449id) != null) {
                    str2 = pBStringField.get();
                }
                QLog.d("QFSCommentRecPicHandlePart", 1, "[handlePauseEvent] feed not match, " + str2 + ", " + qFSVideoPauseEvent.mFeedId);
                return;
            }
            QLog.d("QFSCommentRecPicHandlePart", 1, "[handlePauseEvent] isPause: " + qFSVideoPauseEvent.mIsPause);
            boolean z16 = qFSVideoPauseEvent.mIsPause;
            if (z16 && qFSVideoPauseEvent.mIsClick) {
                X9(1);
            } else if (!z16) {
                QFSCommentRecPicClusterHelper.f83716a.Z(getFeedId());
            }
        }
    }

    private final void T9(SimpleBaseEvent simpleEvent) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        String str;
        PBStringField pBStringField;
        if (simpleEvent instanceof QFSRecPicStateEvent) {
            QFSRecPicStateEvent qFSRecPicStateEvent = (QFSRecPicStateEvent) simpleEvent;
            if (qFSRecPicStateEvent.getState() == 1 && (feedCloudMeta$StFeed = this.feed) != null) {
                Unit unit = null;
                if (feedCloudMeta$StFeed != null && (pBStringField = feedCloudMeta$StFeed.f398449id) != null) {
                    str = pBStringField.get();
                } else {
                    str = null;
                }
                if (TextUtils.equals(str, qFSRecPicStateEvent.getFeedId())) {
                    QFSCommentRecPicClusterHelper.f83716a.O(this);
                    if (!QCirclePanelStateEvent.isSpecifiedPanelShowing(18)) {
                        QLog.d("QFSCommentRecPicHandlePart", 1, "open input panel after allow permission.");
                        QFSCommentInputWindowConfig qFSCommentInputWindowConfig = new QFSCommentInputWindowConfig();
                        qFSCommentInputWindowConfig.needShowRecPicLoading = true;
                        qFSCommentInputWindowConfig.canAutoOpenRecPicBar = true;
                        QFSCommentInfo E9 = E9(qFSCommentInputWindowConfig);
                        t40.b bVar = this.mIFSTabIoc;
                        if (bVar != null) {
                            bVar.onHandlerMessage("event_open_comment_input", E9);
                            unit = Unit.INSTANCE;
                        }
                        if (unit == null) {
                            getPartManager().broadcastMessage("comment_input_window_show", E9);
                        }
                    }
                }
            }
        }
    }

    private final void U9(SimpleBaseEvent simpleEvent) {
        if (simpleEvent instanceof QFSReplyListEvent) {
            QFSReplyListEvent qFSReplyListEvent = (QFSReplyListEvent) simpleEvent;
            if (qFSReplyListEvent.getRsp() != null) {
                List<QFSRecPicInfo> list = this.cmtPic;
                List<FeedCloudMeta$StReply> list2 = qFSReplyListEvent.getRsp().vecReply.get();
                Intrinsics.checkNotNullExpressionValue(list2, "simpleEvent.rsp.vecReply.get()");
                list.addAll(K9(list2));
                QLog.d("QFSCommentRecPicHandlePart", 1, "[handleReplyUpdateEvent] fetch " + this.cmtPic.size() + " comment pic.");
            }
        }
    }

    private final void V9(SimpleBaseEvent simpleEvent) {
        Integer num;
        Integer num2 = null;
        if (simpleEvent != null) {
            num = Integer.valueOf(simpleEvent.mHashCode);
        } else {
            num = null;
        }
        Context context = getContext();
        if (context != null) {
            num2 = Integer.valueOf(context.hashCode());
        }
        if (Intrinsics.areEqual(num, num2) && (simpleEvent instanceof QFSRecPicStateEvent)) {
            QFSRecPicStateEvent qFSRecPicStateEvent = (QFSRecPicStateEvent) simpleEvent;
            if (qFSRecPicStateEvent.getState() == 8 && Intrinsics.areEqual(qFSRecPicStateEvent.getFeedId(), getFeedId())) {
                ha();
            }
        }
    }

    private final void W9(SimpleBaseEvent simpleEvent) {
        if (simpleEvent instanceof ASEngineTabStatusEvent) {
            if (!((ASEngineTabStatusEvent) simpleEvent).isSelected()) {
                QLog.d(QFSCommentPanelPart.TAG_REC_PIC_SCENE, 1, "clear scan and config cache");
                com.tencent.biz.qqcircle.comment.recpic.z.f83900a.i();
                QFSCommentRecPicClusterHelper.f83716a.B();
                return;
            }
            com.tencent.biz.qqcircle.comment.recpic.z.f83900a.A(this);
        }
    }

    private final void X9(final int type) {
        QFSVideoView qFSVideoView;
        PBStringField pBStringField;
        com.tencent.biz.qqcircle.comment.recpic.aa aaVar = com.tencent.biz.qqcircle.comment.recpic.aa.f83750a;
        if (!aaVar.z(this.feed)) {
            return;
        }
        if (!aaVar.H()) {
            QLog.d("QFSCommentRecPicHandlePart", 1, "[handleVideoFrameCut] private setting close.");
            return;
        }
        WeakReference<QFSVideoView> weakReference = QFSVideoView.D;
        String str = null;
        if (weakReference == null) {
            qFSVideoView = null;
        } else {
            qFSVideoView = weakReference.get();
        }
        if (qFSVideoView != null && qFSVideoView.getData() != null) {
            String str2 = qFSVideoView.getData().f398449id.get();
            FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.feed;
            if (feedCloudMeta$StFeed != null && (pBStringField = feedCloudMeta$StFeed.f398449id) != null) {
                str = pBStringField.get();
            }
            if (!TextUtils.equals(str2, str)) {
                QLog.d("QFSCommentRecPicHandlePart", 1, "[handleVideoFrameCut] not same feed.");
            } else {
                com.tencent.biz.qqcircle.immersive.utils.bi.p(new bi.a() { // from class: com.tencent.biz.qqcircle.bizparts.as
                    @Override // com.tencent.biz.qqcircle.immersive.utils.bi.a
                    public final void a(Pair pair) {
                        aw.Y9(type, pair);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y9(final int i3, final Pair pair) {
        final Bitmap bitmap;
        if (pair == null || (bitmap = (Bitmap) pair.second) == null) {
            return;
        }
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.au
            @Override // java.lang.Runnable
            public final void run() {
                aw.Z9(bitmap, i3, pair);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(Bitmap bitmap, int i3, final Pair pair) {
        Intrinsics.checkNotNullParameter(bitmap, "$bitmap");
        String e16 = com.tencent.mobileqq.vfs.b.i().e();
        if (e16 == null) {
            e16 = "/sdcard/Android/data/com.tencent.mobileqq";
        }
        String str = e16 + "/files/qcircle/download/pic/" + System.currentTimeMillis() + ".jpg";
        File createNewFile = RFWFileUtils.createNewFile(str);
        if (createNewFile == null) {
            QLog.d("QFSCommentRecPicHandlePart", 1, "[handleVideoFrameCut] create file error.");
            return;
        }
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(createNewFile));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            final StrategyImage strategyImage = new StrategyImage(str, 1, 100.0f, str, null, 16, null);
            strategyImage.b().put("w", Integer.valueOf(bitmap.getWidth()));
            strategyImage.b().put(tl.h.F, Integer.valueOf(bitmap.getHeight()));
            strategyImage.b().put("type", Integer.valueOf(i3));
            QLog.d("QFSCommentRecPicHandlePart", 1, "[handleVideoFrameCut] path: " + str + ", w: " + bitmap.getWidth() + ", h: " + bitmap.getHeight());
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.bizparts.av
                @Override // java.lang.Runnable
                public final void run() {
                    aw.aa(pair, strategyImage);
                }
            });
        } catch (Exception e17) {
            QLog.e("QFSCommentRecPicHandlePart", 1, "cut video frame error, " + e17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(Pair pair, StrategyImage image) {
        List<StrategyImage> listOf;
        Intrinsics.checkNotNullParameter(image, "$image");
        QFSCommentRecPicClusterHelper qFSCommentRecPicClusterHelper = QFSCommentRecPicClusterHelper.f83716a;
        Object obj = pair.first;
        Intrinsics.checkNotNullExpressionValue(obj, "it.first");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(image);
        qFSCommentRecPicClusterHelper.x((String) obj, listOf);
    }

    private final void ba(List<MediaScanForwardResult> results) {
        ArrayList arrayList = new ArrayList();
        for (QFSCommentRecPicClusterHelper.StrategyConfig strategyConfig : this.strategyConfigList) {
            for (MediaScanForwardResult mediaScanForwardResult : results) {
                float A = QFSCommentRecPicClusterHelper.f83716a.A(mediaScanForwardResult.getImageFeature(), strategyConfig.getFeature());
                if (A > strategyConfig.getThreshold()) {
                    StrategyImage strategyImage = new StrategyImage(mediaScanForwardResult.getPath(), strategyConfig.getSource(), A, mediaScanForwardResult.getPath(), null, 16, null);
                    strategyImage.b().put("from_scan", Boolean.TRUE);
                    arrayList.add(strategyImage);
                    QLog.d("QFSCommentRecPicHandlePart", 4, "[matchWhenScan] addCandidatePicList");
                }
            }
            if (!arrayList.isEmpty()) {
                QFSCommentRecPicClusterHelper.f83716a.x(strategyConfig.getFeedId(), arrayList);
                arrayList.clear();
            }
        }
    }

    private final void ca() {
        if (com.tencent.biz.qqcircle.comment.recpic.aa.f83750a.h(getActivity()) && !this.hasNotifyPanelGuide) {
            SimpleEventBus.getInstance().dispatchEvent(new QFSRecPicStateEvent(5, getFeedId()));
            this.hasNotifyPanelGuide = true;
        }
    }

    private final List<QFSRecPicInfo> da() {
        List<QFSRecPicInfo> emptyList;
        List<QFSRecPicInfo> list = this.cmtPic;
        int size = list.size();
        com.tencent.biz.qqcircle.comment.recpic.z zVar = com.tencent.biz.qqcircle.comment.recpic.z.f83900a;
        if (size < zVar.m().getMinSize()) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        if (size > zVar.m().getMaxSize()) {
            return list.subList((size - zVar.m().getMaxSize()) - 1, size - 1);
        }
        return list;
    }

    private final void ea() {
        if (com.tencent.biz.qqcircle.comment.recpic.aa.f83750a.u()) {
            QLog.d("QFSCommentRecPicHandlePart", 1, "[registerScreenShotListener] disableVideoFrameCut");
            return;
        }
        Handler mainHandler = getMainHandler();
        Intrinsics.checkNotNullExpressionValue(mainHandler, "mainHandler");
        com.tencent.biz.qqcircle.comment.recpic.al alVar = new com.tencent.biz.qqcircle.comment.recpic.al(mainHandler);
        this.mScreenshotObserver = alVar;
        alVar.a(this);
        com.tencent.biz.qqcircle.comment.recpic.al alVar2 = this.mScreenshotObserver;
        if (alVar2 != null) {
            alVar2.a(this);
            getContext().getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, alVar2);
        }
    }

    private final void ga() {
        boolean z16;
        QFSFeedCategoryConfig qFSFeedCategoryConfig;
        com.tencent.biz.qqcircle.comment.recpic.aa aaVar = com.tencent.biz.qqcircle.comment.recpic.aa.f83750a;
        if (aaVar.l()) {
            QLog.d("QFSCommentRecPicHandlePart", 1, "[startFeedCategoryMatch] not allow feed cluster. ");
            return;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.feed;
        if (feedCloudMeta$StFeed == null || !aaVar.z(feedCloudMeta$StFeed)) {
            return;
        }
        com.tencent.biz.qqcircle.comment.recpic.z zVar = com.tencent.biz.qqcircle.comment.recpic.z.f83900a;
        if (zVar.j().isEmpty()) {
            QLog.d(getTAG(), 1, "feedConfig is empty.");
            return;
        }
        String mainCate = feedCloudMeta$StFeed.mainCate.get();
        String subCate = feedCloudMeta$StFeed.subCate.get();
        Iterator<QFSFeedCategoryConfig> it = zVar.j().iterator();
        while (true) {
            if (it.hasNext()) {
                qFSFeedCategoryConfig = it.next();
                if (Intrinsics.areEqual(subCate, qFSFeedCategoryConfig.getSubCategory())) {
                    z16 = true;
                    break;
                }
            } else {
                z16 = false;
                qFSFeedCategoryConfig = null;
                break;
            }
        }
        if (!z16) {
            return;
        }
        Random.Companion companion = Random.INSTANCE;
        Intrinsics.checkNotNull(qFSFeedCategoryConfig);
        int nextInt = companion.nextInt(qFSFeedCategoryConfig.b().size());
        if (!QFSCommentRecPicClusterHelper.f83716a.K()) {
            this.strategyConfigList.add(new QFSCommentRecPicClusterHelper.StrategyConfig(getFeedId(), 2, qFSFeedCategoryConfig.b().get(nextInt), qFSFeedCategoryConfig.getThresholds()[nextInt], null, 16, null));
        }
        if (com.tencent.biz.qqcircle.comment.recpic.aa.f83750a.E(getActivity()) && !this.hasMatchFeed) {
            this.hasMatchFeed = true;
            QLog.d(getTAG(), 1, "feed mainCate: " + mainCate + ", subCate: " + subCate + ", idx: " + nextInt);
            String subCategory = qFSFeedCategoryConfig.getSubCategory();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(subCategory);
            sb5.append(nextInt);
            String sb6 = sb5.toString();
            Intrinsics.checkNotNullExpressionValue(mainCate, "mainCate");
            Intrinsics.checkNotNullExpressionValue(subCate, "subCate");
            G9(sb6, mainCate, subCate);
        }
    }

    private final String getFeedId() {
        String str;
        PBStringField pBStringField;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = this.feed;
        if (feedCloudMeta$StFeed != null && (pBStringField = feedCloudMeta$StFeed.f398449id) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    private final void ha() {
        if (this.hasMatchFeedDesc) {
            QLog.d("QFSCommentRecPicHandlePart", 1, "[startFeedDescMatch] has match feed desc.");
        } else {
            this.hasMatchFeedDesc = true;
            QFSCommentRecPicClusterHelper.f83716a.i0(this.feed);
        }
    }

    private final void ia(String text) {
        if (!com.tencent.biz.qqcircle.comment.recpic.aa.f83750a.G()) {
            return;
        }
        QCircleToast.l(QCircleToast.f91644d, text, 0, true, false);
    }

    private final void ja() {
        com.tencent.biz.qqcircle.comment.recpic.al alVar = this.mScreenshotObserver;
        if (alVar != null) {
            getContext().getContentResolver().unregisterContentObserver(alVar);
            this.mScreenshotObserver = null;
        }
    }

    @Override // com.tencent.biz.qqcircle.comment.recpic.al.b
    public void F3() {
        if (com.tencent.biz.qqcircle.comment.recpic.aa.f83750a.u()) {
            QLog.d("QFSCommentRecPicHandlePart", 1, "[onScreenShot] disableVideoFrameCut");
        } else {
            X9(2);
        }
    }

    @Override // t20.a
    public void R(@NotNull List<MediaScanForwardResult> scanResultList) {
        Intrinsics.checkNotNullParameter(scanResultList, "scanResultList");
        ba(scanResultList);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(QCircleCommentUpdateEvent.class);
        arrayList.add(QCircleResetCommentBlockEvent.class);
        arrayList.add(QFSVideoPauseEvent.class);
        arrayList.add(QCirclePanelStateEvent.class);
        arrayList.add(QFSReplyListEvent.class);
        arrayList.add(QFSKMeansResultEvent.class);
        arrayList.add(QFSRecPicStateEvent.class);
        arrayList.add(ASEngineTabStatusEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSCommentRecPicHandlePart";
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        super.handleBroadcastMessage(action, args);
        if (Intrinsics.areEqual(action, "layer_notify_part_update_feed") && (args instanceof e30.b)) {
            e30.b bVar = (e30.b) args;
            this.feedBlockData = bVar;
            this.feed = bVar.g();
            this.strategyConfigList.clear();
            ga();
            com.tencent.biz.qqcircle.comment.recpic.z zVar = com.tencent.biz.qqcircle.comment.recpic.z.f83900a;
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            if (zVar.e(activity)) {
                QFSCommentRecPicClusterHelper.f83716a.O(this);
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean isPartEnable() {
        if (super.isPartEnable()) {
            com.tencent.biz.qqcircle.comment.recpic.aa aaVar = com.tencent.biz.qqcircle.comment.recpic.aa.f83750a;
            if (!aaVar.t() && aaVar.H() && aaVar.F()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        SimpleEventBus.getInstance().registerReceiver(this);
        ea();
        com.tencent.biz.qqcircle.comment.recpic.z.f83900a.A(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        this.mIFSTabIoc = (t40.b) getIocInterface(t40.b.class);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        ja();
        if (!ASInject.g().getAsEngineDelegate().isOnThirdTab(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE)) {
            QLog.d("QFSCommentRecPicHandlePart", 1, "[onPartDestroy] clear cache");
            QFSCommentRecPicClusterHelper.f83716a.B();
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.part.u, com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        QFSCommentRecPicClusterHelper.f83716a.Z(getFeedId());
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent simpleEvent) {
        N9(simpleEvent);
        M9(simpleEvent);
        O9(simpleEvent);
        U9(simpleEvent);
        P9(simpleEvent);
        T9(simpleEvent);
        R9(simpleEvent);
        S9(simpleEvent);
        W9(simpleEvent);
        V9(simpleEvent);
    }
}
