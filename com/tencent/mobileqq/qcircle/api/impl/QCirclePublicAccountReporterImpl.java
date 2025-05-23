package com.tencent.mobileqq.qcircle.api.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter;
import com.tencent.mobileqq.qcircle.api.QCirclePublicAccountLauncherSource;
import com.tencent.mobileqq.qcircle.api.QCirclePublicAccountMessageInfo;
import com.tencent.mobileqq.qcircle.api.QCirclePublicAccountRedDotType;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uq3.k;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 12\u00020\u0001:\u00011B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\"\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J*\u0010\u0016\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u001b\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u001d\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010 \u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010!\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J \u0010\"\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u000bH\u0016J*\u0010%\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020(2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\"\u0010)\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\"\u0010*\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020,2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010-\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010.\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010/\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u00100\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/impl/QCirclePublicAccountReporterImpl;", "Lcom/tencent/mobileqq/qcircle/api/IQCirclePublicAccountReporter;", "()V", "reporterList", "", "uinToLastExposureFeedIdMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getDTAppKey", "getPubAccountRecentUserPosInMessageList", "", "reportCancelSetTop", "", "app", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "messageInfo", "Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountMessageInfo;", "reportDelete", "reportMessageCellExposure", "exposureTimeSec", "", "reportMessageCellExposureCost", "costMills", "redDotType", "Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountRedDotType;", "reportProfilePageCancelSetTop", "reportProfilePageCloseReceiveMessage", "reportProfilePageFollowClick", "reportProfilePageOpenReceiveMessage", "reportProfilePageSetTop", "reportProfilePageShareClick", "reportProfilePageTipOffClick", "reportProfilePageUnfollowClick", "reportRedPointBack", "costTime", "type", "reportRedPointClick", "clickTimeMills", "source", "Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountLauncherSource;", "reportRedPointExposureOnce", "reportRedPointReceive", "isNum", "", "reportSetTop", "reportUnFollowInConversation", "reportUnFollowInConversationActionSheet", "reportUnFollowInProfilePageActionSheet", "Companion", "qcircle-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class QCirclePublicAccountReporterImpl implements IQCirclePublicAccountReporter {

    @NotNull
    public static final String LAST_EXPOSURE_FEED_ID = "qcircle_public_account_last_exposure_feed_id";

    @NotNull
    public static final String LAST_EXPOSURE_MESSAGE_ID = "qcircle_public_account_last_exposure_message_id";

    @NotNull
    public static final String TAG = "QCirclePublicAccountReporterImpl";

    @NotNull
    private final List<IQCirclePublicAccountReporter> reporterList;

    @NotNull
    private final HashMap<String, String> uinToLastExposureFeedIdMap;

    public QCirclePublicAccountReporterImpl() {
        ArrayList arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new QCirclePublicAccountDCReporter(), new QCirclePublicAccountDTReporter());
        this.reporterList = arrayListOf;
        this.uinToLastExposureFeedIdMap = new HashMap<>();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    @NotNull
    public String getDTAppKey() {
        return "00000QG6YX3X0LZH";
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public int getPubAccountRecentUserPosInMessageList() {
        List<RecentContactInfo> a16;
        boolean z16;
        aa recentContactService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "")).getRecentContactService();
        if (recentContactService == null || (a16 = recentContactService.a()) == null) {
            return -1;
        }
        Iterator<RecentContactInfo> it = a16.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (it.next().peerUin == AppConstants.Q_CIRCLE_PUBLIC_ACCOUNT_UIN_LONGVALUE) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportCancelSetTop(@NotNull BaseQQAppInterface app, @Nullable QCirclePublicAccountMessageInfo messageInfo) {
        Intrinsics.checkNotNullParameter(app, "app");
        Iterator<T> it = this.reporterList.iterator();
        while (it.hasNext()) {
            ((IQCirclePublicAccountReporter) it.next()).reportCancelSetTop(app, messageInfo);
        }
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportDelete(@NotNull BaseQQAppInterface app, @Nullable QCirclePublicAccountMessageInfo messageInfo) {
        Intrinsics.checkNotNullParameter(app, "app");
        Iterator<T> it = this.reporterList.iterator();
        while (it.hasNext()) {
            ((IQCirclePublicAccountReporter) it.next()).reportDelete(app, messageInfo);
        }
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportMessageCellExposure(@NotNull BaseQQAppInterface baseQQAppInterface, long j3, @Nullable QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo, boolean z16) {
        IQCirclePublicAccountReporter.DefaultImpls.reportMessageCellExposure(this, baseQQAppInterface, j3, qCirclePublicAccountMessageInfo, z16);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportMessageCellExposureCost(@NotNull BaseQQAppInterface app, long costMills, @NotNull QCirclePublicAccountRedDotType redDotType, @Nullable QCirclePublicAccountMessageInfo messageInfo) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(redDotType, "redDotType");
        Iterator<T> it = this.reporterList.iterator();
        while (it.hasNext()) {
            ((IQCirclePublicAccountReporter) it.next()).reportMessageCellExposureCost(app, costMills, redDotType, messageInfo);
        }
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportProfilePageCancelSetTop(@NotNull BaseQQAppInterface app) {
        Intrinsics.checkNotNullParameter(app, "app");
        Iterator<T> it = this.reporterList.iterator();
        while (it.hasNext()) {
            ((IQCirclePublicAccountReporter) it.next()).reportProfilePageCancelSetTop(app);
        }
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportProfilePageCloseReceiveMessage(@NotNull BaseQQAppInterface app, @Nullable QCirclePublicAccountMessageInfo messageInfo) {
        Intrinsics.checkNotNullParameter(app, "app");
        Iterator<T> it = this.reporterList.iterator();
        while (it.hasNext()) {
            ((IQCirclePublicAccountReporter) it.next()).reportProfilePageCloseReceiveMessage(app, messageInfo);
        }
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportProfilePageFollowClick(@NotNull BaseQQAppInterface app) {
        Intrinsics.checkNotNullParameter(app, "app");
        Iterator<T> it = this.reporterList.iterator();
        while (it.hasNext()) {
            ((IQCirclePublicAccountReporter) it.next()).reportProfilePageFollowClick(app);
        }
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportProfilePageOpenReceiveMessage(@NotNull BaseQQAppInterface app, @Nullable QCirclePublicAccountMessageInfo messageInfo) {
        Intrinsics.checkNotNullParameter(app, "app");
        Iterator<T> it = this.reporterList.iterator();
        while (it.hasNext()) {
            ((IQCirclePublicAccountReporter) it.next()).reportProfilePageOpenReceiveMessage(app, messageInfo);
        }
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportProfilePageSetTop(@NotNull BaseQQAppInterface app) {
        Intrinsics.checkNotNullParameter(app, "app");
        Iterator<T> it = this.reporterList.iterator();
        while (it.hasNext()) {
            ((IQCirclePublicAccountReporter) it.next()).reportProfilePageSetTop(app);
        }
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportProfilePageShareClick(@NotNull BaseQQAppInterface app) {
        Intrinsics.checkNotNullParameter(app, "app");
        Iterator<T> it = this.reporterList.iterator();
        while (it.hasNext()) {
            ((IQCirclePublicAccountReporter) it.next()).reportProfilePageShareClick(app);
        }
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportProfilePageTipOffClick(@NotNull BaseQQAppInterface app) {
        Intrinsics.checkNotNullParameter(app, "app");
        Iterator<T> it = this.reporterList.iterator();
        while (it.hasNext()) {
            ((IQCirclePublicAccountReporter) it.next()).reportProfilePageTipOffClick(app);
        }
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportProfilePageUnfollowClick(@NotNull BaseQQAppInterface app, @Nullable QCirclePublicAccountMessageInfo messageInfo) {
        Intrinsics.checkNotNullParameter(app, "app");
        Iterator<T> it = this.reporterList.iterator();
        while (it.hasNext()) {
            ((IQCirclePublicAccountReporter) it.next()).reportProfilePageUnfollowClick(app, messageInfo);
        }
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportRedPointBack(@NotNull BaseQQAppInterface app, long costTime, int type) {
        Intrinsics.checkNotNullParameter(app, "app");
        Iterator<T> it = this.reporterList.iterator();
        while (it.hasNext()) {
            ((IQCirclePublicAccountReporter) it.next()).reportRedPointBack(app, costTime, type);
        }
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportRedPointClick(@NotNull BaseQQAppInterface app, long clickTimeMills, @NotNull QCirclePublicAccountLauncherSource source, @Nullable QCirclePublicAccountMessageInfo messageInfo) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(source, "source");
        QLog.i(TAG, 1, "reportRedPointClick, source=" + source.getValue());
        Iterator<T> it = this.reporterList.iterator();
        while (it.hasNext()) {
            ((IQCirclePublicAccountReporter) it.next()).reportRedPointClick(app, clickTimeMills, source, messageInfo);
        }
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportRedPointExposureOnce(@NotNull BaseQQAppInterface app, long exposureTimeSec, @Nullable QCirclePublicAccountMessageInfo messageInfo) {
        boolean z16;
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(app, "app");
        boolean z17 = false;
        if (messageInfo != null) {
            z16 = Intrinsics.areEqual(messageInfo.isLocal(), Boolean.TRUE);
        } else {
            z16 = false;
        }
        if (z16) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "reportRedPointExposureOnce, localMsg, fast return");
                return;
            }
            return;
        }
        if (messageInfo == null || (str = messageInfo.getId()) == null) {
            str = "";
        }
        String lastExposureMessageId = k.a().h(LAST_EXPOSURE_MESSAGE_ID, "");
        Intrinsics.checkNotNullExpressionValue(lastExposureMessageId, "lastExposureMessageId");
        if (lastExposureMessageId.length() == 0) {
            z17 = true;
        }
        if (z17) {
            lastExposureMessageId = k.b().h(LAST_EXPOSURE_MESSAGE_ID, "");
        }
        if (Intrinsics.areEqual(lastExposureMessageId, str)) {
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("reportRedPointExposureOnce, hasReport, fast return, feedId=");
                if (messageInfo != null) {
                    str2 = messageInfo.getFeedId();
                } else {
                    str2 = null;
                }
                sb5.append(str2);
                sb5.append(", currentId=");
                sb5.append(str);
                QLog.i(TAG, 2, sb5.toString());
                return;
            }
            return;
        }
        k.a().p(LAST_EXPOSURE_MESSAGE_ID, str);
        Iterator<T> it = this.reporterList.iterator();
        while (it.hasNext()) {
            ((IQCirclePublicAccountReporter) it.next()).reportRedPointExposureOnce(app, exposureTimeSec, messageInfo);
        }
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportRedPointReceive(@NotNull BaseQQAppInterface app, boolean isNum, @Nullable QCirclePublicAccountMessageInfo messageInfo) {
        Intrinsics.checkNotNullParameter(app, "app");
        Iterator<T> it = this.reporterList.iterator();
        while (it.hasNext()) {
            ((IQCirclePublicAccountReporter) it.next()).reportRedPointReceive(app, isNum, messageInfo);
        }
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportSetTop(@NotNull BaseQQAppInterface app, @Nullable QCirclePublicAccountMessageInfo messageInfo) {
        Intrinsics.checkNotNullParameter(app, "app");
        Iterator<T> it = this.reporterList.iterator();
        while (it.hasNext()) {
            ((IQCirclePublicAccountReporter) it.next()).reportSetTop(app, messageInfo);
        }
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportUnFollowInConversation(@NotNull BaseQQAppInterface app, @Nullable QCirclePublicAccountMessageInfo messageInfo) {
        Intrinsics.checkNotNullParameter(app, "app");
        Iterator<T> it = this.reporterList.iterator();
        while (it.hasNext()) {
            ((IQCirclePublicAccountReporter) it.next()).reportUnFollowInConversation(app, messageInfo);
        }
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportUnFollowInConversationActionSheet(@NotNull BaseQQAppInterface app, @Nullable QCirclePublicAccountMessageInfo messageInfo) {
        Intrinsics.checkNotNullParameter(app, "app");
        Iterator<T> it = this.reporterList.iterator();
        while (it.hasNext()) {
            ((IQCirclePublicAccountReporter) it.next()).reportUnFollowInConversationActionSheet(app, messageInfo);
        }
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportUnFollowInProfilePageActionSheet(@NotNull BaseQQAppInterface app, @Nullable QCirclePublicAccountMessageInfo messageInfo) {
        Intrinsics.checkNotNullParameter(app, "app");
        Iterator<T> it = this.reporterList.iterator();
        while (it.hasNext()) {
            ((IQCirclePublicAccountReporter) it.next()).reportUnFollowInProfilePageActionSheet(app, messageInfo);
        }
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePublicAccountReporter
    public void reportMessageCellExposure(@NotNull BaseQQAppInterface app, long exposureTimeSec, @Nullable QCirclePublicAccountMessageInfo messageInfo) {
        Intrinsics.checkNotNullParameter(app, "app");
        String feedId = messageInfo != null ? messageInfo.getFeedId() : null;
        String currentUin = app.getCurrentAccountUin();
        if ((feedId == null || feedId.length() == 0) || Intrinsics.areEqual(feedId, this.uinToLastExposureFeedIdMap.get(currentUin))) {
            return;
        }
        Iterator<T> it = this.reporterList.iterator();
        while (it.hasNext()) {
            ((IQCirclePublicAccountReporter) it.next()).reportMessageCellExposure(app, exposureTimeSec, messageInfo);
        }
        String lastExposureFeedId = k.a().h(LAST_EXPOSURE_FEED_ID, "");
        Intrinsics.checkNotNullExpressionValue(lastExposureFeedId, "lastExposureFeedId");
        if (lastExposureFeedId.length() == 0) {
            lastExposureFeedId = k.b().h(LAST_EXPOSURE_FEED_ID, "");
        }
        boolean z16 = !Intrinsics.areEqual(lastExposureFeedId, feedId);
        Iterator<T> it5 = this.reporterList.iterator();
        while (it5.hasNext()) {
            ((IQCirclePublicAccountReporter) it5.next()).reportMessageCellExposure(app, exposureTimeSec, messageInfo, z16);
        }
        k.a().p(LAST_EXPOSURE_FEED_ID, feedId);
        HashMap<String, String> hashMap = this.uinToLastExposureFeedIdMap;
        Intrinsics.checkNotNullExpressionValue(currentUin, "currentUin");
        hashMap.put(currentUin, feedId);
    }
}
