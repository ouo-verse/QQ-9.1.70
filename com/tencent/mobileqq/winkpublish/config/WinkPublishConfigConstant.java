package com.tencent.mobileqq.winkpublish.config;

import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.winkpublish.report.WinkPublishReportQueue;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/config/WinkPublishConfigConstant;", "", "()V", "Companion", "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class WinkPublishConfigConstant {
    public static final int ATTAID_NONE = 0;
    public static final int ATTAID_QCIRCLE = 10008;
    public static final int ATTAID_QZONE = 11007;

    @NotNull
    public static final String BUSINESS_NAME_AI_AVATAR = "AI_AVATAR";

    @NotNull
    public static final String BUSINESS_NAME_ECOMMERCE = "ECOMMERCE";

    @NotNull
    public static final String BUSINESS_NAME_EMOTION = "emoticon";

    @NotNull
    public static final String BUSINESS_NAME_FILE_TBSTOOL = "filetbstool";

    @NotNull
    public static final String BUSINESS_NAME_FLOCK = "Flock";

    @NotNull
    public static final String BUSINESS_NAME_GUILD = "\u6765\u81ea\u9891\u9053";

    @NotNull
    public static final String BUSINESS_NAME_NEARBY = "qqnearby";

    @NotNull
    public static final String BUSINESS_NAME_QCIRCLE = "QCIRCLE";

    @NotNull
    public static final String BUSINESS_NAME_QCIRCLE_AVATAR = "QCIRCLE_AVATAR";

    @NotNull
    public static final String BUSINESS_NAME_QCIRCLE_REDPACKET = "QCIRCLE_REDPACKET";

    @NotNull
    public static final String BUSINESS_NAME_QQLIVE_COVER = "QQLIVE_COVER";

    @NotNull
    public static final String BUSINESS_NAME_QQLIVE_SKIN = "QQLIVE_SKIN";

    @NotNull
    public static final String BUSINESS_NAME_QQSTRANGER = "qqstranger";

    @NotNull
    public static final String BUSINESS_NAME_QZONE = "QZONE";

    @NotNull
    public static final String BUSINESS_NAME_QZONE_MOMENT = "QZONE_MOMENT";

    @NotNull
    public static final String BUSINESS_NAME_SHARE_AVATAR = "SHARE_AVATAR";
    public static final int BUSINESS_TYPE_AI_AVATAR = 18;
    public static final int BUSINESS_TYPE_ECOMMERCE = 6;
    public static final int BUSINESS_TYPE_EMOTION = 17;
    public static final int BUSINESS_TYPE_FILE_TBSTOOL = 16;
    public static final int BUSINESS_TYPE_FLOCK = 13;
    public static final int BUSINESS_TYPE_GUILD = 2;
    public static final int BUSINESS_TYPE_NEARBY = 14;
    public static final int BUSINESS_TYPE_QCIRCLE = 1;
    public static final int BUSINESS_TYPE_QCIRCLE_AVATAR = 3;
    public static final int BUSINESS_TYPE_QCIRCLE_REDPACKET = 11;
    public static final int BUSINESS_TYPE_QQLIVE_COVER = 10;
    public static final int BUSINESS_TYPE_QQLIVE_SKIN = 12;
    public static final int BUSINESS_TYPE_QQSTRANGER = 15;
    public static final int BUSINESS_TYPE_QZONE = 4;
    public static final int BUSINESS_TYPE_QZONE_MOMENT = 9;
    public static final int BUSINESS_TYPE_SHARE_AVATAR = 8;

    @NotNull
    public static final String EVENTID_PREFIX_ECOMMERCE = "EC_";

    @NotNull
    public static final String EVENTID_PREFIX_FLOCK = "Flock_";

    @NotNull
    public static final String EVENTID_PREFIX_GUILD = "CH_";

    @NotNull
    public static final String EVENTID_PREFIX_NEARBY = "NEARBY_";

    @NotNull
    public static final String EVENTID_PREFIX_QCIRCLE = "QFS_";

    @NotNull
    public static final String EVENTID_PREFIX_QCIRCLE_AVATAR = "Avatar_";

    @NotNull
    public static final String EVENTID_PREFIX_QCIRCLE_REDPACKET = "RedPacket_";

    @NotNull
    public static final String EVENTID_PREFIX_QQLIVE_COVER = "QQLive_";

    @NotNull
    public static final String EVENTID_PREFIX_QQSTRANGER = "QQStranger_";

    @NotNull
    public static final String EVENTID_PREFIX_QZONE = "QZ_";

    @NotNull
    public static final String EVENTID_PREFIX_QZONE_MOMENT = "QZM_";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final int REPORT_QZONE_SAMPLING_RATE = com.tencent.qzonehub.reborn.a.a();

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b0\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u00106\u001a\u00020\u00042\u0006\u00107\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u0011\u00103\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u00105\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/winkpublish/config/WinkPublishConfigConstant$Companion;", "", "()V", "ATTAID_NONE", "", "ATTAID_QCIRCLE", "ATTAID_QZONE", "BUSINESS_NAME_AI_AVATAR", "", "BUSINESS_NAME_ECOMMERCE", "BUSINESS_NAME_EMOTION", "BUSINESS_NAME_FILE_TBSTOOL", "BUSINESS_NAME_FLOCK", "BUSINESS_NAME_GUILD", "BUSINESS_NAME_NEARBY", "BUSINESS_NAME_QCIRCLE", "BUSINESS_NAME_QCIRCLE_AVATAR", "BUSINESS_NAME_QCIRCLE_REDPACKET", "BUSINESS_NAME_QQLIVE_COVER", "BUSINESS_NAME_QQLIVE_SKIN", "BUSINESS_NAME_QQSTRANGER", "BUSINESS_NAME_QZONE", "BUSINESS_NAME_QZONE_MOMENT", "BUSINESS_NAME_SHARE_AVATAR", "BUSINESS_TYPE_AI_AVATAR", "BUSINESS_TYPE_ECOMMERCE", "BUSINESS_TYPE_EMOTION", "BUSINESS_TYPE_FILE_TBSTOOL", "BUSINESS_TYPE_FLOCK", "BUSINESS_TYPE_GUILD", "BUSINESS_TYPE_NEARBY", "BUSINESS_TYPE_QCIRCLE", "BUSINESS_TYPE_QCIRCLE_AVATAR", "BUSINESS_TYPE_QCIRCLE_REDPACKET", "BUSINESS_TYPE_QQLIVE_COVER", "BUSINESS_TYPE_QQLIVE_SKIN", "BUSINESS_TYPE_QQSTRANGER", "BUSINESS_TYPE_QZONE", "BUSINESS_TYPE_QZONE_MOMENT", "BUSINESS_TYPE_SHARE_AVATAR", "EVENTID_PREFIX_ECOMMERCE", "EVENTID_PREFIX_FLOCK", "EVENTID_PREFIX_GUILD", "EVENTID_PREFIX_NEARBY", "EVENTID_PREFIX_QCIRCLE", "EVENTID_PREFIX_QCIRCLE_AVATAR", "EVENTID_PREFIX_QCIRCLE_REDPACKET", "EVENTID_PREFIX_QQLIVE_COVER", "EVENTID_PREFIX_QQSTRANGER", "EVENTID_PREFIX_QZONE", "EVENTID_PREFIX_QZONE_MOMENT", "REPORT_QZONE_SAMPLING_RATE", "getREPORT_QZONE_SAMPLING_RATE", "()I", "name2Type", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "qq-winkpublish-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int getREPORT_QZONE_SAMPLING_RATE() {
            return WinkPublishConfigConstant.REPORT_QZONE_SAMPLING_RATE;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000b. Please report as an issue. */
        public final int name2Type(@NotNull String businessName) {
            Intrinsics.checkNotNullParameter(businessName, "businessName");
            switch (businessName.hashCode()) {
                case -2145160958:
                    if (businessName.equals("QZONE_MOMENT")) {
                        return 9;
                    }
                    QLog.w(WinkPublishReportQueue.TAG, 1, "[name2type] invalid businessName: " + businessName);
                    return 1;
                case -1322459498:
                    if (businessName.equals("qqstranger")) {
                        return 15;
                    }
                    QLog.w(WinkPublishReportQueue.TAG, 1, "[name2type] invalid businessName: " + businessName);
                    return 1;
                case -1274223135:
                    if (businessName.equals("filetbstool")) {
                        return 16;
                    }
                    QLog.w(WinkPublishReportQueue.TAG, 1, "[name2type] invalid businessName: " + businessName);
                    return 1;
                case -825146633:
                    if (businessName.equals("QCIRCLE_AVATAR")) {
                        return 3;
                    }
                    QLog.w(WinkPublishReportQueue.TAG, 1, "[name2type] invalid businessName: " + businessName);
                    return 1;
                case -176742241:
                    if (businessName.equals("qqnearby")) {
                        return 14;
                    }
                    QLog.w(WinkPublishReportQueue.TAG, 1, "[name2type] invalid businessName: " + businessName);
                    return 1;
                case -127732263:
                    if (businessName.equals("SHARE_AVATAR")) {
                        return 8;
                    }
                    QLog.w(WinkPublishReportQueue.TAG, 1, "[name2type] invalid businessName: " + businessName);
                    return 1;
                case 19908128:
                    if (businessName.equals("ECOMMERCE")) {
                        return 6;
                    }
                    QLog.w(WinkPublishReportQueue.TAG, 1, "[name2type] invalid businessName: " + businessName);
                    return 1;
                case 67973745:
                    if (businessName.equals("Flock")) {
                        return 13;
                    }
                    QLog.w(WinkPublishReportQueue.TAG, 1, "[name2type] invalid businessName: " + businessName);
                    return 1;
                case 77564797:
                    if (businessName.equals("QZONE")) {
                        return 4;
                    }
                    QLog.w(WinkPublishReportQueue.TAG, 1, "[name2type] invalid businessName: " + businessName);
                    return 1;
                case 477153755:
                    if (businessName.equals("QCIRCLE_REDPACKET")) {
                        return 11;
                    }
                    QLog.w(WinkPublishReportQueue.TAG, 1, "[name2type] invalid businessName: " + businessName);
                    return 1;
                case 646441124:
                    if (businessName.equals("QQLIVE_COVER")) {
                        return 10;
                    }
                    QLog.w(WinkPublishReportQueue.TAG, 1, "[name2type] invalid businessName: " + businessName);
                    return 1;
                case 821746631:
                    if (businessName.equals("\u6765\u81ea\u9891\u9053")) {
                        return 2;
                    }
                    QLog.w(WinkPublishReportQueue.TAG, 1, "[name2type] invalid businessName: " + businessName);
                    return 1;
                case 861433953:
                    if (businessName.equals("QCIRCLE")) {
                        return 1;
                    }
                    QLog.w(WinkPublishReportQueue.TAG, 1, "[name2type] invalid businessName: " + businessName);
                    return 1;
                case 1172029062:
                    if (businessName.equals("emoticon")) {
                        return 17;
                    }
                    QLog.w(WinkPublishReportQueue.TAG, 1, "[name2type] invalid businessName: " + businessName);
                    return 1;
                case 1268251344:
                    if (businessName.equals("QQLIVE_SKIN")) {
                        return 12;
                    }
                    QLog.w(WinkPublishReportQueue.TAG, 1, "[name2type] invalid businessName: " + businessName);
                    return 1;
                case 1506520400:
                    if (businessName.equals("AI_AVATAR")) {
                        return 18;
                    }
                    QLog.w(WinkPublishReportQueue.TAG, 1, "[name2type] invalid businessName: " + businessName);
                    return 1;
                default:
                    QLog.w(WinkPublishReportQueue.TAG, 1, "[name2type] invalid businessName: " + businessName);
                    return 1;
            }
        }

        Companion() {
        }
    }
}
