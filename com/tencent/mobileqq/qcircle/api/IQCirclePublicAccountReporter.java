package com.tencent.mobileqq.qcircle.api;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J$\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J,\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J,\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\u0017\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\u0019\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\u001d\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J \u0010\u001e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u0005H\u0016J*\u0010!\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020$2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J$\u0010%\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\"\u0010&\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010'\u001a\u00020\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010(\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010)\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010*\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010+\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006,"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/IQCirclePublicAccountReporter;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getDTAppKey", "", "getPubAccountRecentUserPosInMessageList", "", "reportCancelSetTop", "", "app", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "messageInfo", "Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountMessageInfo;", "reportDelete", "reportMessageCellExposure", "exposureTimeSec", "", "isFirstReport", "", "reportMessageCellExposureCost", "costMills", "redDotType", "Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountRedDotType;", "reportProfilePageCancelSetTop", "reportProfilePageCloseReceiveMessage", "reportProfilePageFollowClick", "reportProfilePageOpenReceiveMessage", "reportProfilePageSetTop", "reportProfilePageShareClick", "reportProfilePageTipOffClick", "reportProfilePageUnfollowClick", "reportRedPointBack", "costTime", "type", "reportRedPointClick", "clickTimeMills", "source", "Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountLauncherSource;", "reportRedPointExposureOnce", "reportRedPointReceive", "isNum", "reportSetTop", "reportUnFollowInConversation", "reportUnFollowInConversationActionSheet", "reportUnFollowInProfilePageActionSheet", "qcircle-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {""})
/* loaded from: classes16.dex */
public interface IQCirclePublicAccountReporter extends QRouteApi {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class DefaultImpls {
        @NotNull
        public static String getDTAppKey(@NotNull IQCirclePublicAccountReporter iQCirclePublicAccountReporter) {
            return "";
        }

        public static int getPubAccountRecentUserPosInMessageList(@NotNull IQCirclePublicAccountReporter iQCirclePublicAccountReporter) {
            return -1;
        }

        public static void reportCancelSetTop(@NotNull IQCirclePublicAccountReporter iQCirclePublicAccountReporter, @NotNull BaseQQAppInterface app, @Nullable QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
            Intrinsics.checkNotNullParameter(app, "app");
        }

        public static void reportDelete(@NotNull IQCirclePublicAccountReporter iQCirclePublicAccountReporter, @NotNull BaseQQAppInterface app, @Nullable QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
            Intrinsics.checkNotNullParameter(app, "app");
        }

        public static void reportMessageCellExposure(@NotNull IQCirclePublicAccountReporter iQCirclePublicAccountReporter, @NotNull BaseQQAppInterface app, long j3, @Nullable QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
            Intrinsics.checkNotNullParameter(app, "app");
        }

        public static /* synthetic */ void reportMessageCellExposure$default(IQCirclePublicAccountReporter iQCirclePublicAccountReporter, BaseQQAppInterface baseQQAppInterface, long j3, QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportMessageCellExposure");
            }
            if ((i3 & 2) != 0) {
                j3 = 0;
            }
            iQCirclePublicAccountReporter.reportMessageCellExposure(baseQQAppInterface, j3, qCirclePublicAccountMessageInfo);
        }

        public static void reportMessageCellExposureCost(@NotNull IQCirclePublicAccountReporter iQCirclePublicAccountReporter, @NotNull BaseQQAppInterface app, long j3, @NotNull QCirclePublicAccountRedDotType redDotType, @Nullable QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
            Intrinsics.checkNotNullParameter(app, "app");
            Intrinsics.checkNotNullParameter(redDotType, "redDotType");
        }

        public static /* synthetic */ void reportMessageCellExposureCost$default(IQCirclePublicAccountReporter iQCirclePublicAccountReporter, BaseQQAppInterface baseQQAppInterface, long j3, QCirclePublicAccountRedDotType qCirclePublicAccountRedDotType, QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    j3 = 0;
                }
                iQCirclePublicAccountReporter.reportMessageCellExposureCost(baseQQAppInterface, j3, qCirclePublicAccountRedDotType, qCirclePublicAccountMessageInfo);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportMessageCellExposureCost");
        }

        public static void reportProfilePageCancelSetTop(@NotNull IQCirclePublicAccountReporter iQCirclePublicAccountReporter, @NotNull BaseQQAppInterface app) {
            Intrinsics.checkNotNullParameter(app, "app");
        }

        public static void reportProfilePageCloseReceiveMessage(@NotNull IQCirclePublicAccountReporter iQCirclePublicAccountReporter, @NotNull BaseQQAppInterface app, @Nullable QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
            Intrinsics.checkNotNullParameter(app, "app");
        }

        public static void reportProfilePageFollowClick(@NotNull IQCirclePublicAccountReporter iQCirclePublicAccountReporter, @NotNull BaseQQAppInterface app) {
            Intrinsics.checkNotNullParameter(app, "app");
        }

        public static void reportProfilePageOpenReceiveMessage(@NotNull IQCirclePublicAccountReporter iQCirclePublicAccountReporter, @NotNull BaseQQAppInterface app, @Nullable QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
            Intrinsics.checkNotNullParameter(app, "app");
        }

        public static void reportProfilePageSetTop(@NotNull IQCirclePublicAccountReporter iQCirclePublicAccountReporter, @NotNull BaseQQAppInterface app) {
            Intrinsics.checkNotNullParameter(app, "app");
        }

        public static void reportProfilePageShareClick(@NotNull IQCirclePublicAccountReporter iQCirclePublicAccountReporter, @NotNull BaseQQAppInterface app) {
            Intrinsics.checkNotNullParameter(app, "app");
        }

        public static void reportProfilePageTipOffClick(@NotNull IQCirclePublicAccountReporter iQCirclePublicAccountReporter, @NotNull BaseQQAppInterface app) {
            Intrinsics.checkNotNullParameter(app, "app");
        }

        public static void reportProfilePageUnfollowClick(@NotNull IQCirclePublicAccountReporter iQCirclePublicAccountReporter, @NotNull BaseQQAppInterface app, @Nullable QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
            Intrinsics.checkNotNullParameter(app, "app");
        }

        public static void reportRedPointBack(@NotNull IQCirclePublicAccountReporter iQCirclePublicAccountReporter, @NotNull BaseQQAppInterface app, long j3, int i3) {
            Intrinsics.checkNotNullParameter(app, "app");
        }

        public static void reportRedPointExposureOnce(@NotNull IQCirclePublicAccountReporter iQCirclePublicAccountReporter, @NotNull BaseQQAppInterface app, long j3, @Nullable QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
            Intrinsics.checkNotNullParameter(app, "app");
        }

        public static /* synthetic */ void reportRedPointExposureOnce$default(IQCirclePublicAccountReporter iQCirclePublicAccountReporter, BaseQQAppInterface baseQQAppInterface, long j3, QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    j3 = 0;
                }
                iQCirclePublicAccountReporter.reportRedPointExposureOnce(baseQQAppInterface, j3, qCirclePublicAccountMessageInfo);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportRedPointExposureOnce");
        }

        public static void reportRedPointReceive(@NotNull IQCirclePublicAccountReporter iQCirclePublicAccountReporter, @NotNull BaseQQAppInterface app, boolean z16, @Nullable QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
            Intrinsics.checkNotNullParameter(app, "app");
        }

        public static void reportSetTop(@NotNull IQCirclePublicAccountReporter iQCirclePublicAccountReporter, @NotNull BaseQQAppInterface app, @Nullable QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
            Intrinsics.checkNotNullParameter(app, "app");
        }

        public static void reportUnFollowInConversation(@NotNull IQCirclePublicAccountReporter iQCirclePublicAccountReporter, @NotNull BaseQQAppInterface app, @Nullable QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
            Intrinsics.checkNotNullParameter(app, "app");
        }

        public static void reportUnFollowInConversationActionSheet(@NotNull IQCirclePublicAccountReporter iQCirclePublicAccountReporter, @NotNull BaseQQAppInterface app, @Nullable QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
            Intrinsics.checkNotNullParameter(app, "app");
        }

        public static void reportUnFollowInProfilePageActionSheet(@NotNull IQCirclePublicAccountReporter iQCirclePublicAccountReporter, @NotNull BaseQQAppInterface app, @Nullable QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo) {
            Intrinsics.checkNotNullParameter(app, "app");
        }

        public static void reportMessageCellExposure(@NotNull IQCirclePublicAccountReporter iQCirclePublicAccountReporter, @NotNull BaseQQAppInterface app, long j3, @Nullable QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo, boolean z16) {
            Intrinsics.checkNotNullParameter(app, "app");
        }

        public static /* synthetic */ void reportMessageCellExposure$default(IQCirclePublicAccountReporter iQCirclePublicAccountReporter, BaseQQAppInterface baseQQAppInterface, long j3, QCirclePublicAccountMessageInfo qCirclePublicAccountMessageInfo, boolean z16, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportMessageCellExposure");
            }
            if ((i3 & 2) != 0) {
                j3 = 0;
            }
            iQCirclePublicAccountReporter.reportMessageCellExposure(baseQQAppInterface, j3, qCirclePublicAccountMessageInfo, z16);
        }
    }

    @NotNull
    String getDTAppKey();

    int getPubAccountRecentUserPosInMessageList();

    void reportCancelSetTop(@NotNull BaseQQAppInterface app, @Nullable QCirclePublicAccountMessageInfo messageInfo);

    void reportDelete(@NotNull BaseQQAppInterface app, @Nullable QCirclePublicAccountMessageInfo messageInfo);

    void reportMessageCellExposure(@NotNull BaseQQAppInterface app, long exposureTimeSec, @Nullable QCirclePublicAccountMessageInfo messageInfo);

    void reportMessageCellExposure(@NotNull BaseQQAppInterface app, long exposureTimeSec, @Nullable QCirclePublicAccountMessageInfo messageInfo, boolean isFirstReport);

    void reportMessageCellExposureCost(@NotNull BaseQQAppInterface app, long costMills, @NotNull QCirclePublicAccountRedDotType redDotType, @Nullable QCirclePublicAccountMessageInfo messageInfo);

    void reportProfilePageCancelSetTop(@NotNull BaseQQAppInterface app);

    void reportProfilePageCloseReceiveMessage(@NotNull BaseQQAppInterface app, @Nullable QCirclePublicAccountMessageInfo messageInfo);

    void reportProfilePageFollowClick(@NotNull BaseQQAppInterface app);

    void reportProfilePageOpenReceiveMessage(@NotNull BaseQQAppInterface app, @Nullable QCirclePublicAccountMessageInfo messageInfo);

    void reportProfilePageSetTop(@NotNull BaseQQAppInterface app);

    void reportProfilePageShareClick(@NotNull BaseQQAppInterface app);

    void reportProfilePageTipOffClick(@NotNull BaseQQAppInterface app);

    void reportProfilePageUnfollowClick(@NotNull BaseQQAppInterface app, @Nullable QCirclePublicAccountMessageInfo messageInfo);

    void reportRedPointBack(@NotNull BaseQQAppInterface app, long costTime, int type);

    void reportRedPointClick(@NotNull BaseQQAppInterface app, long clickTimeMills, @NotNull QCirclePublicAccountLauncherSource source, @Nullable QCirclePublicAccountMessageInfo messageInfo);

    void reportRedPointExposureOnce(@NotNull BaseQQAppInterface app, long exposureTimeSec, @Nullable QCirclePublicAccountMessageInfo messageInfo);

    void reportRedPointReceive(@NotNull BaseQQAppInterface app, boolean isNum, @Nullable QCirclePublicAccountMessageInfo messageInfo);

    void reportSetTop(@NotNull BaseQQAppInterface app, @Nullable QCirclePublicAccountMessageInfo messageInfo);

    void reportUnFollowInConversation(@NotNull BaseQQAppInterface app, @Nullable QCirclePublicAccountMessageInfo messageInfo);

    void reportUnFollowInConversationActionSheet(@NotNull BaseQQAppInterface app, @Nullable QCirclePublicAccountMessageInfo messageInfo);

    void reportUnFollowInProfilePageActionSheet(@NotNull BaseQQAppInterface app, @Nullable QCirclePublicAccountMessageInfo messageInfo);
}
