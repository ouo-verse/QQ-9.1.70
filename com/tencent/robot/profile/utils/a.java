package com.tencent.robot.profile.utils;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.android.androidbypass.richui.viewdata.j;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.CreatorIdentity;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotQzoneData;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotQzoneInfo;
import com.tencent.qqnt.kernel.nativeinterface.HalfViewCardNode;
import com.tencent.qqnt.kernel.nativeinterface.RobotBackGround;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotFeatureInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotLabel;
import com.tencent.qqnt.kernel.nativeinterface.RobotMetricsInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotUsingLabel;
import com.tencent.qqnt.kernel.nativeinterface.RobtoCreateInfo;
import com.tencent.robot.aio.background.api.IRobotBackgroundApi;
import com.tencent.robot.profile.data.RobotProfileStoryInfoData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a \u0010\u0006\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00050\u00042\u000e\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u001a\u0014\u0010\u0007\u001a\u00020\u0002*\u00020\u00052\b\u0010\u0001\u001a\u0004\u0018\u00010\u0005\u001a\u0014\u0010\t\u001a\u00020\u0002*\u00020\b2\b\u0010\u0001\u001a\u0004\u0018\u00010\b\u001a\u0014\u0010\u000b\u001a\u00020\u0002*\u00020\n2\b\u0010\u0001\u001a\u0004\u0018\u00010\n\u001a\u0014\u0010\r\u001a\u00020\u0002*\u00020\f2\b\u0010\u0001\u001a\u0004\u0018\u00010\f\u001a\u0014\u0010\u000f\u001a\u00020\u0002*\u00020\u000e2\b\u0010\u0001\u001a\u0004\u0018\u00010\u000e\u001a \u0010\u0010\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\n0\u00042\u000e\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0004\u001a \u0010\u0011\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\f0\u00042\u000e\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0004\u001a \u0010\u0012\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u000e0\u00042\u000e\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0004\u001a\u0014\u0010\u0014\u001a\u00020\u0002*\u00020\u00132\b\u0010\u0001\u001a\u0004\u0018\u00010\u0013\u001a \u0010\u0015\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00130\u00042\u000e\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0004\u001a\u0014\u0010\u0017\u001a\u00020\u0002*\u00020\u00162\b\u0010\u0001\u001a\u0004\u0018\u00010\u0016\u001a\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0004*\u00020\u00182\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u001a \u0010\u001d\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u001b0\u00042\u000e\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0004\u001a\u0012\u0010!\u001a\u00020 *\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0002\u001a\u0012\u0010\"\u001a\u00020 *\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0002\u001a\u0012\u0010#\u001a\u00020 *\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0002\u001a\u0012\u0010$\u001a\u00020 *\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0002\u001a\u0012\u0010%\u001a\u00020 *\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0002\u001a\u0012\u0010&\u001a\u00020 *\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0002\u001a\u0012\u0010'\u001a\u00020 *\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0002\u001a\u0012\u0010(\u001a\u00020 *\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0002\u001a\u0012\u0010)\u001a\u00020 *\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0002\u001a\u0012\u0010*\u001a\u00020 *\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0002\u001a\u0012\u0010+\u001a\u00020 *\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0002\u001a\u0012\u0010,\u001a\u00020 *\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0002\u001a\n\u0010.\u001a\u00020-*\u00020\u001e\u00a8\u0006/"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/RobtoCreateInfo;", "other", "", h.F, "", "Lcom/tencent/qqnt/kernel/nativeinterface/CreatorIdentity;", "w", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotMetricsInfo;", "f", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotUsingLabel;", "g", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotLabel;", "e", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotFeatureInfo;", "d", "B", "y", HippyTKDListViewAdapter.X, "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotQzoneData;", "b", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotQzoneInfo;", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "Landroid/os/Bundle;", "aioBundle", "Lcom/tencent/robot/profile/data/n$b;", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", "isProfile", "", "u", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "j", "l", ReportConstant.COSTREPORT_PREFIX, "t", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "p", "i", "k", "r", "", "v", "robot-business-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a {
    public static final boolean A(@NotNull List<GroupRobotQzoneData> list, @Nullable List<GroupRobotQzoneData> list2) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list2 == null || list.size() != list2.size()) {
            return false;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!b(list.get(i3), list2.get(i3))) {
                return false;
            }
        }
        return true;
    }

    public static final boolean B(@NotNull List<RobotUsingLabel> list, @Nullable List<RobotUsingLabel> list2) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list2 == null || list.size() != list2.size()) {
            return false;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!g(list.get(i3), list2.get(i3))) {
                return false;
            }
        }
        return true;
    }

    public static final boolean a(@NotNull CreatorIdentity creatorIdentity, @Nullable CreatorIdentity creatorIdentity2) {
        Intrinsics.checkNotNullParameter(creatorIdentity, "<this>");
        if (creatorIdentity2 == null || creatorIdentity.creatorIdentityType != creatorIdentity2.creatorIdentityType || !Intrinsics.areEqual(creatorIdentity.smallIcon, creatorIdentity2.smallIcon) || !Intrinsics.areEqual(creatorIdentity.jumpUrl, creatorIdentity2.jumpUrl)) {
            return false;
        }
        return true;
    }

    public static final boolean b(@NotNull GroupRobotQzoneData groupRobotQzoneData, @Nullable GroupRobotQzoneData groupRobotQzoneData2) {
        Intrinsics.checkNotNullParameter(groupRobotQzoneData, "<this>");
        if (groupRobotQzoneData2 == null || !Intrinsics.areEqual(groupRobotQzoneData.imageUrl, groupRobotQzoneData2.imageUrl) || !Intrinsics.areEqual(groupRobotQzoneData.thumbImageUrl, groupRobotQzoneData2.thumbImageUrl) || groupRobotQzoneData.uploadTime != groupRobotQzoneData2.uploadTime || groupRobotQzoneData.isOnlySelf != groupRobotQzoneData2.isOnlySelf || !Intrinsics.areEqual(groupRobotQzoneData.text, groupRobotQzoneData2.text) || groupRobotQzoneData.dataType != groupRobotQzoneData2.dataType) {
            return false;
        }
        return true;
    }

    public static final boolean c(@NotNull GroupRobotQzoneInfo groupRobotQzoneInfo, @Nullable GroupRobotQzoneInfo groupRobotQzoneInfo2) {
        Intrinsics.checkNotNullParameter(groupRobotQzoneInfo, "<this>");
        if (groupRobotQzoneInfo2 == null || !Intrinsics.areEqual(groupRobotQzoneInfo.updateTipsString, groupRobotQzoneInfo2.updateTipsString) || !Intrinsics.areEqual(groupRobotQzoneInfo.jumpUrl, groupRobotQzoneInfo2.jumpUrl) || groupRobotQzoneInfo.hasOpenQQZone != groupRobotQzoneInfo2.hasOpenQQZone) {
            return false;
        }
        ArrayList<GroupRobotQzoneData> imageList = groupRobotQzoneInfo.imageList;
        Intrinsics.checkNotNullExpressionValue(imageList, "imageList");
        if (!A(imageList, groupRobotQzoneInfo2.imageList)) {
            return false;
        }
        return true;
    }

    public static final boolean d(@NotNull RobotFeatureInfo robotFeatureInfo, @Nullable RobotFeatureInfo robotFeatureInfo2) {
        Intrinsics.checkNotNullParameter(robotFeatureInfo, "<this>");
        if (robotFeatureInfo2 == null || robotFeatureInfo.cid != robotFeatureInfo2.cid || !Intrinsics.areEqual(robotFeatureInfo.name, robotFeatureInfo2.name) || !Intrinsics.areEqual(robotFeatureInfo.desc, robotFeatureInfo2.desc) || robotFeatureInfo.status != robotFeatureInfo2.status || !Intrinsics.areEqual(robotFeatureInfo.availableRangeDesc, robotFeatureInfo2.availableRangeDesc)) {
            return false;
        }
        return true;
    }

    public static final boolean e(@NotNull RobotLabel robotLabel, @Nullable RobotLabel robotLabel2) {
        Intrinsics.checkNotNullParameter(robotLabel, "<this>");
        if (robotLabel2 == null || robotLabel.f359209id != robotLabel2.f359209id || !Intrinsics.areEqual(robotLabel.name, robotLabel2.name)) {
            return false;
        }
        return true;
    }

    public static final boolean f(@NotNull RobotMetricsInfo robotMetricsInfo, @Nullable RobotMetricsInfo robotMetricsInfo2) {
        Intrinsics.checkNotNullParameter(robotMetricsInfo, "<this>");
        if (robotMetricsInfo2 == null || robotMetricsInfo.hot != robotMetricsInfo2.hot || robotMetricsInfo.friendCount != robotMetricsInfo2.friendCount || robotMetricsInfo.joinedGroupCount != robotMetricsInfo2.joinedGroupCount || robotMetricsInfo.chatCount != robotMetricsInfo2.chatCount) {
            return false;
        }
        return true;
    }

    public static final boolean g(@NotNull RobotUsingLabel robotUsingLabel, @Nullable RobotUsingLabel robotUsingLabel2) {
        Intrinsics.checkNotNullParameter(robotUsingLabel, "<this>");
        if (robotUsingLabel2 == null || !Intrinsics.areEqual(robotUsingLabel.labelMsg, robotUsingLabel2.labelMsg) || robotUsingLabel.labelTheme != robotUsingLabel2.labelTheme) {
            return false;
        }
        return true;
    }

    public static final boolean h(@NotNull RobtoCreateInfo robtoCreateInfo, @Nullable RobtoCreateInfo robtoCreateInfo2) {
        Intrinsics.checkNotNullParameter(robtoCreateInfo, "<this>");
        if (robtoCreateInfo2 == null || robtoCreateInfo.createUin != robtoCreateInfo2.createUin || !Intrinsics.areEqual(robtoCreateInfo.createName, robtoCreateInfo2.createName) || !Intrinsics.areEqual(robtoCreateInfo.createUid, robtoCreateInfo2.createUid) || robtoCreateInfo.allowJumpProfile != robtoCreateInfo2.allowJumpProfile) {
            return false;
        }
        ArrayList<CreatorIdentity> creatorIdentity = robtoCreateInfo.creatorIdentity;
        Intrinsics.checkNotNullExpressionValue(creatorIdentity, "creatorIdentity");
        if (!w(creatorIdentity, robtoCreateInfo2.creatorIdentity)) {
            return false;
        }
        return true;
    }

    @NotNull
    public static final String i(@NotNull GroupRobotProfile groupRobotProfile, boolean z16) {
        String url;
        boolean z17;
        Intrinsics.checkNotNullParameter(groupRobotProfile, "<this>");
        if (z16) {
            url = groupRobotProfile.infoBg.dayPic;
        } else {
            url = groupRobotProfile.c2cDayBackground;
        }
        if (z16) {
            if (url != null && url.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (z17) {
                url = groupRobotProfile.c2cDayBackground;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("RobotProfileExt", 2, "[GroupRobotProfile.dayBgUrl] isProfile: " + z16 + ", c2cDayBackground: " + groupRobotProfile.c2cDayBackground + ", infoBg.dayPic: " + groupRobotProfile.infoBg.dayPic + ", url: " + url);
        }
        Intrinsics.checkNotNullExpressionValue(url, "url");
        return url;
    }

    @NotNull
    public static final String j(@NotNull RobotCoreInfo robotCoreInfo, boolean z16) {
        String url;
        boolean z17;
        Intrinsics.checkNotNullParameter(robotCoreInfo, "<this>");
        if (z16) {
            url = robotCoreInfo.infoBg.dayPic;
        } else {
            url = robotCoreInfo.bgDay;
        }
        if (z16) {
            if (url != null && url.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (z17) {
                url = robotCoreInfo.bgDay;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("RobotProfileExt", 2, "[RobotCoreInfo.dayBgUrl] isProfile: " + z16 + ", bgDay: " + robotCoreInfo.bgDay + ", infoBg.dayPic: " + robotCoreInfo.infoBg.dayPic + ", url: " + url);
        }
        Intrinsics.checkNotNullExpressionValue(url, "url");
        return url;
    }

    @NotNull
    public static final String k(@NotNull GroupRobotProfile groupRobotProfile, boolean z16) {
        String color;
        boolean z17;
        Intrinsics.checkNotNullParameter(groupRobotProfile, "<this>");
        if (z16) {
            color = groupRobotProfile.infoBg.dayColor;
        } else {
            color = groupRobotProfile.dayColor;
        }
        if (color != null && color.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17 && z16) {
            color = groupRobotProfile.dayColor;
        }
        if (QLog.isColorLevel()) {
            QLog.i("RobotProfileExt", 2, "[GroupRobotProfile.dayColor] isProfile: " + z16 + ", dayColor: " + groupRobotProfile.dayColor + ", infoBg.dayColor: " + groupRobotProfile.infoBg.dayColor + ", color: " + color);
        }
        Intrinsics.checkNotNullExpressionValue(color, "color");
        return color;
    }

    @NotNull
    public static final String l(@NotNull RobotCoreInfo robotCoreInfo, boolean z16) {
        String color;
        boolean z17;
        Intrinsics.checkNotNullParameter(robotCoreInfo, "<this>");
        if (z16) {
            color = robotCoreInfo.infoBg.dayColor;
        } else {
            color = robotCoreInfo.dayColor;
        }
        if (color != null && color.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17 && z16) {
            color = robotCoreInfo.dayColor;
        }
        if (QLog.isColorLevel()) {
            QLog.i("RobotProfileExt", 2, "[RobotCoreInfo.dayColor] isProfile: " + z16 + ", dayColor: " + robotCoreInfo.dayColor + ", infoBg.dayColor: " + robotCoreInfo.infoBg.dayColor + ", color: " + color);
        }
        Intrinsics.checkNotNullExpressionValue(color, "color");
        return color;
    }

    @NotNull
    public static final String m(@NotNull GroupRobotProfile groupRobotProfile, boolean z16) {
        String url;
        boolean z17;
        Intrinsics.checkNotNullParameter(groupRobotProfile, "<this>");
        if (z16) {
            url = groupRobotProfile.infoBg.dayDynamicPic;
        } else {
            url = groupRobotProfile.dayDynamicPic;
        }
        if (z16) {
            if (url != null && url.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (z17) {
                url = groupRobotProfile.dayDynamicPic;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("RobotProfileExt", 2, "[GroupRobotProfile.dayDynamicBgUrl] isProfile: " + z16 + ", dayDynamicPic: " + groupRobotProfile.dayDynamicPic + ", infoBg.dayDynamicPic: " + groupRobotProfile.infoBg.dayDynamicPic + ", url: " + url);
        }
        Intrinsics.checkNotNullExpressionValue(url, "url");
        return url;
    }

    @NotNull
    public static final String n(@NotNull RobotCoreInfo robotCoreInfo, boolean z16) {
        String url;
        boolean z17;
        Intrinsics.checkNotNullParameter(robotCoreInfo, "<this>");
        if (z16) {
            url = robotCoreInfo.infoBg.dayDynamicPic;
        } else {
            url = robotCoreInfo.dayDynamicPic;
        }
        if (z16) {
            if (url != null && url.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (z17) {
                url = robotCoreInfo.dayDynamicPic;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("RobotProfileExt", 2, "[RobotCoreInfo.dayDynamicBgUrl] isProfile: " + z16 + ", dayDynamicPic: " + robotCoreInfo.dayDynamicPic + ", infoBg.dayDynamicPic: " + robotCoreInfo.infoBg.dayDynamicPic + ", url: " + url);
        }
        Intrinsics.checkNotNullExpressionValue(url, "url");
        return url;
    }

    @NotNull
    public static final List<RobotProfileStoryInfoData.RobotProfileStoryItemCardData> o(@NotNull GroupRobotProfile groupRobotProfile, @Nullable Bundle bundle) {
        j jVar;
        Intrinsics.checkNotNullParameter(groupRobotProfile, "<this>");
        ArrayList<HalfViewCardNode> arrayList = groupRobotProfile.allStorySet.cardNodes;
        Intrinsics.checkNotNullExpressionValue(arrayList, "allStorySet.cardNodes");
        ArrayList arrayList2 = new ArrayList();
        for (HalfViewCardNode card : arrayList) {
            String str = groupRobotProfile.allStorySet.layoutMap.get(card.layoutId);
            String str2 = groupRobotProfile.allStorySet.attrMap.get(card.attrId);
            RobotProfileStoryInfoData.RobotProfileStoryItemCardData robotProfileStoryItemCardData = null;
            try {
                JSONObject jSONObject = new JSONObject(str);
                com.tencent.android.androidbypass.richui.utils.c.b(jSONObject, new JSONObject(str2));
                jSONObject.put("version", 0);
                jSONObject.put("templateId", "aio.robot.story");
                jVar = com.tencent.android.androidbypass.richui.e.c(com.tencent.android.androidbypass.richui.e.f72322a, jSONObject, null, null, 6, null);
            } catch (Exception e16) {
                QLog.i("RobotProfileExt", 1, "[getStoryList]", e16);
                jVar = null;
            }
            if (jVar != null) {
                String str3 = groupRobotProfile.robotData.name;
                Intrinsics.checkNotNullExpressionValue(str3, "robotData.name");
                String valueOf = String.valueOf(groupRobotProfile.robotData.robotUin);
                String str4 = groupRobotProfile.robotData.robotUid;
                Intrinsics.checkNotNullExpressionValue(str4, "robotData.robotUid");
                Intrinsics.checkNotNullExpressionValue(card, "card");
                robotProfileStoryItemCardData = new RobotProfileStoryInfoData.RobotProfileStoryItemCardData(str3, valueOf, str4, card, jVar, bundle);
            }
            if (robotProfileStoryItemCardData != null) {
                arrayList2.add(robotProfileStoryItemCardData);
            }
        }
        return arrayList2;
    }

    @NotNull
    public static final String p(@NotNull GroupRobotProfile groupRobotProfile, boolean z16) {
        String url;
        boolean z17;
        Intrinsics.checkNotNullParameter(groupRobotProfile, "<this>");
        if (z16) {
            url = groupRobotProfile.infoBg.nightPic;
        } else {
            url = groupRobotProfile.c2cNightBackground;
        }
        if (z16) {
            if (url != null && url.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (z17) {
                url = groupRobotProfile.c2cNightBackground;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("RobotProfileExt", 2, "[GroupRobotProfile.nightBgUrl] isProfile: " + z16 + ", c2cNightBackground: " + groupRobotProfile.c2cNightBackground + ", infoBg.nightPic: " + groupRobotProfile.infoBg.nightPic + ", url: " + url);
        }
        Intrinsics.checkNotNullExpressionValue(url, "url");
        return url;
    }

    @NotNull
    public static final String q(@NotNull RobotCoreInfo robotCoreInfo, boolean z16) {
        String url;
        boolean z17;
        Intrinsics.checkNotNullParameter(robotCoreInfo, "<this>");
        if (z16) {
            url = robotCoreInfo.infoBg.nightPic;
        } else {
            url = robotCoreInfo.bgNight;
        }
        if (z16) {
            if (url != null && url.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (z17) {
                url = robotCoreInfo.bgNight;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("RobotProfileExt", 2, "[RobotCoreInfo.nightBgUrl] isProfile: " + z16 + ", bgNight: " + robotCoreInfo.bgNight + ", infoBg.nightPic: " + robotCoreInfo.infoBg.nightPic + ", url: " + url);
        }
        Intrinsics.checkNotNullExpressionValue(url, "url");
        return url;
    }

    @NotNull
    public static final String r(@NotNull GroupRobotProfile groupRobotProfile, boolean z16) {
        String color;
        boolean z17;
        Intrinsics.checkNotNullParameter(groupRobotProfile, "<this>");
        if (z16) {
            color = groupRobotProfile.infoBg.nightColor;
        } else {
            color = groupRobotProfile.nightColor;
        }
        if (color != null && color.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17 && z16) {
            color = groupRobotProfile.nightColor;
        }
        if (QLog.isColorLevel()) {
            QLog.i("RobotProfileExt", 2, "[GroupRobotProfile.nightColor] isProfile: " + z16 + ", nightColor: " + groupRobotProfile.nightColor + ", infoBg.nightColor: " + groupRobotProfile.infoBg.nightColor + ", color: " + color);
        }
        Intrinsics.checkNotNullExpressionValue(color, "color");
        return color;
    }

    @NotNull
    public static final String s(@NotNull RobotCoreInfo robotCoreInfo, boolean z16) {
        String color;
        boolean z17;
        Intrinsics.checkNotNullParameter(robotCoreInfo, "<this>");
        if (z16) {
            color = robotCoreInfo.infoBg.nightColor;
        } else {
            color = robotCoreInfo.nightColor;
        }
        if (color != null && color.length() != 0) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17 && z16) {
            color = robotCoreInfo.nightColor;
        }
        if (QLog.isColorLevel()) {
            QLog.i("RobotProfileExt", 2, "[RobotCoreInfo.nightColor] isProfile: " + z16 + ", nightColor: " + robotCoreInfo.nightColor + ", infoBg.nightColor: " + robotCoreInfo.infoBg.nightColor + ", color: " + color);
        }
        Intrinsics.checkNotNullExpressionValue(color, "color");
        return color;
    }

    @NotNull
    public static final String t(@NotNull GroupRobotProfile groupRobotProfile, boolean z16) {
        String url;
        boolean z17;
        Intrinsics.checkNotNullParameter(groupRobotProfile, "<this>");
        if (z16) {
            url = groupRobotProfile.infoBg.nightDynamicPic;
        } else {
            url = groupRobotProfile.nightDynamicPic;
        }
        if (z16) {
            if (url != null && url.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (z17) {
                url = groupRobotProfile.nightDynamicPic;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("RobotProfileExt", 2, "[GroupRobotProfile.nightDynamicBgUrl] isProfile: " + z16 + ", nightDynamicPic: " + groupRobotProfile.nightDynamicPic + ", infoBg.nightDynamicPic: " + groupRobotProfile.infoBg.nightDynamicPic + ", url: " + url);
        }
        Intrinsics.checkNotNullExpressionValue(url, "url");
        return url;
    }

    @NotNull
    public static final String u(@NotNull RobotCoreInfo robotCoreInfo, boolean z16) {
        String url;
        boolean z17;
        Intrinsics.checkNotNullParameter(robotCoreInfo, "<this>");
        if (z16) {
            url = robotCoreInfo.infoBg.nightDynamicPic;
        } else {
            url = robotCoreInfo.nightDynamicPic;
        }
        if (z16) {
            if (url != null && url.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (z17) {
                url = robotCoreInfo.nightDynamicPic;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("RobotProfileExt", 2, "[RobotCoreInfo.nightDynamicBgUrl] isProfile: " + z16 + ", nightDynamicPic: " + robotCoreInfo.nightDynamicPic + ", infoBg.nightDynamicPic: " + robotCoreInfo.infoBg.nightDynamicPic + ", url: " + url);
        }
        Intrinsics.checkNotNullExpressionValue(url, "url");
        return url;
    }

    public static final void v(@NotNull RobotCoreInfo robotCoreInfo) {
        String str;
        Intrinsics.checkNotNullParameter(robotCoreInfo, "<this>");
        boolean a16 = je0.a.a(BaseApplication.getContext());
        RobotBackGround robotBackGround = robotCoreInfo.infoBg;
        if (a16) {
            str = robotBackGround.nightPic;
        } else {
            str = robotBackGround.dayPic;
        }
        ((IRobotBackgroundApi) QRoute.api(IRobotBackgroundApi.class)).preloadRobotBackgroundUrl(str, true);
    }

    public static final boolean w(@NotNull List<CreatorIdentity> list, @Nullable List<CreatorIdentity> list2) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list2 == null || list.size() != list2.size()) {
            return false;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!a(list.get(i3), list2.get(i3))) {
                return false;
            }
        }
        return true;
    }

    public static final boolean x(@NotNull List<RobotFeatureInfo> list, @Nullable List<RobotFeatureInfo> list2) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list2 == null || list.size() != list2.size()) {
            return false;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!d(list.get(i3), list2.get(i3))) {
                return false;
            }
        }
        return true;
    }

    public static final boolean y(@NotNull List<RobotLabel> list, @Nullable List<RobotLabel> list2) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list2 == null || list.size() != list2.size()) {
            return false;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!e(list.get(i3), list2.get(i3))) {
                return false;
            }
        }
        return true;
    }

    public static final boolean z(@NotNull List<RobotProfileStoryInfoData.RobotProfileStoryItemCardData> list, @Nullable List<RobotProfileStoryInfoData.RobotProfileStoryItemCardData> list2) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list2 == null || list.size() != list2.size()) {
            return false;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!Intrinsics.areEqual(list.get(i3), list2.get(i3))) {
                return false;
            }
        }
        return true;
    }
}
