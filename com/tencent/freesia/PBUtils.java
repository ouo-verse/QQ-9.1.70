package com.tencent.freesia;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHelperApi;
import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.trpcprotocol.group_pro.configdistribution.config_distribution_svr.configDistributionSvr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/freesia/PBUtils;", "", "<init>", "()V", "Companion", "unitedconfig-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class PBUtils {
    static IPatchRedirector $redirector_;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u00ce\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bJ\u0010KJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J7\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\u0007j\b\u0012\u0004\u0012\u00020\u000b`\t2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J7\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0007j\b\u0012\u0004\u0012\u00020\u0018`\t2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0007j\b\u0012\u0004\u0012\u00020\u0016`\tH\u0002\u00a2\u0006\u0004\b\u0019\u0010\rJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u001fH\u0002\u00a2\u0006\u0004\b\"\u0010#J\u0017\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020$H\u0002\u00a2\u0006\u0004\b'\u0010(J-\u0010-\u001a\u0012\u0012\u0004\u0012\u00020,0\u0007j\b\u0012\u0004\u0012\u00020,`\t2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020*0)H\u0002\u00a2\u0006\u0004\b-\u0010.J-\u00102\u001a\u0012\u0012\u0004\u0012\u0002010\u0007j\b\u0012\u0004\u0012\u000201`\t2\f\u00100\u001a\b\u0012\u0004\u0012\u00020/0)H\u0002\u00a2\u0006\u0004\b2\u0010.J\u0017\u00106\u001a\u0002052\u0006\u00104\u001a\u000203H\u0002\u00a2\u0006\u0004\b6\u00107J-\u0010;\u001a\u0012\u0012\u0004\u0012\u00020:0\u0007j\b\u0012\u0004\u0012\u00020:`\t2\f\u00109\u001a\b\u0012\u0004\u0012\u0002080)H\u0002\u00a2\u0006\u0004\b;\u0010.J-\u0010=\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u000b0)H\u0002\u00a2\u0006\u0004\b=\u0010.J\u0015\u0010?\u001a\u00020>2\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b?\u0010@J\u0015\u0010C\u001a\u00020B2\u0006\u0010\u0003\u001a\u00020A\u00a2\u0006\u0004\bC\u0010DJ\u0015\u0010F\u001a\u00020E2\u0006\u0010%\u001a\u00020$\u00a2\u0006\u0004\bF\u0010GJ\r\u0010H\u001a\u00020E\u00a2\u0006\u0004\bH\u0010I\u00a8\u0006L"}, d2 = {"Lcom/tencent/freesia/PBUtils$Companion;", "", "Lcom/tencent/freesia/GetConfigReq;", "nativeReq", "Lcom/tencent/trpcprotocol/group_pro/configdistribution/config_distribution_svr/configDistributionSvr$ControlInfo;", "createControlInfo", "(Lcom/tencent/freesia/GetConfigReq;)Lcom/tencent/trpcprotocol/group_pro/configdistribution/config_distribution_svr/configDistributionSvr$ControlInfo;", "Ljava/util/ArrayList;", "Lcom/tencent/freesia/GroupInfo;", "Lkotlin/collections/ArrayList;", "groupInfos", "Lcom/tencent/trpcprotocol/group_pro/configdistribution/config_distribution_svr/configDistributionSvr$GroupInfo;", "createGroupInfos", "(Ljava/util/ArrayList;)Ljava/util/ArrayList;", "Lcom/tencent/trpcprotocol/group_pro/configdistribution/config_distribution_svr/configDistributionSvr$CommonInfo;", "createCommonInfo", "(Lcom/tencent/freesia/GetConfigReq;)Lcom/tencent/trpcprotocol/group_pro/configdistribution/config_distribution_svr/configDistributionSvr$CommonInfo;", "Lcom/tencent/freesia/DeviceInfo;", "deviceInfo", "Lcom/tencent/trpcprotocol/group_pro/configdistribution/config_distribution_svr/configDistributionSvr$DeviceInfo;", "createDeviceInfo", "(Lcom/tencent/freesia/DeviceInfo;)Lcom/tencent/trpcprotocol/group_pro/configdistribution/config_distribution_svr/configDistributionSvr$DeviceInfo;", "Lcom/tencent/freesia/ProjectInfo;", "projectInfos", "Lcom/tencent/trpcprotocol/group_pro/configdistribution/config_distribution_svr/configDistributionSvr$ProjectInfo;", "createProjectInfos", "Lcom/tencent/freesia/ReqPageInfo;", "pageInfo", "Lcom/tencent/trpcprotocol/group_pro/configdistribution/config_distribution_svr/configDistributionSvr$ReqPageInfo;", "createReqPageInfo", "(Lcom/tencent/freesia/ReqPageInfo;)Lcom/tencent/trpcprotocol/group_pro/configdistribution/config_distribution_svr/configDistributionSvr$ReqPageInfo;", "Lcom/tencent/freesia/Extend;", "nativeExtend", "Lcom/tencent/trpcprotocol/group_pro/configdistribution/config_distribution_svr/configDistributionSvr$Extend;", "createExtend", "(Lcom/tencent/freesia/Extend;)Lcom/tencent/trpcprotocol/group_pro/configdistribution/config_distribution_svr/configDistributionSvr$Extend;", "Lcom/tencent/trpcprotocol/group_pro/configdistribution/config_distribution_svr/configDistributionSvr$GetConfigRsp;", "rsp", "Lcom/tencent/freesia/RespPageInfo;", "toNativeRespPageInfo", "(Lcom/tencent/trpcprotocol/group_pro/configdistribution/config_distribution_svr/configDistributionSvr$GetConfigRsp;)Lcom/tencent/freesia/RespPageInfo;", "", "Lcom/tencent/trpcprotocol/group_pro/configdistribution/config_distribution_svr/configDistributionSvr$RespConfig;", Constants.Configs.CONFIGS, "Lcom/tencent/freesia/Config;", "toNativeConfigs", "(Ljava/util/List;)Ljava/util/ArrayList;", "Lcom/tencent/trpcprotocol/group_pro/configdistribution/config_distribution_svr/configDistributionSvr$Content;", "contents", "Lcom/tencent/freesia/Content;", "toNativeContents", "Lcom/tencent/trpcprotocol/group_pro/configdistribution/config_distribution_svr/configDistributionSvr$RespControlInfo;", ITroopAnnouncementHelperApi.CONTROL_INFO, "Lcom/tencent/freesia/RespControlInfo;", "toNativeRespControlInfo", "(Lcom/tencent/trpcprotocol/group_pro/configdistribution/config_distribution_svr/configDistributionSvr$RespControlInfo;)Lcom/tencent/freesia/RespControlInfo;", "Lcom/tencent/trpcprotocol/group_pro/configdistribution/config_distribution_svr/configDistributionSvr$MuteDuration;", "muteDurations", "Lcom/tencent/freesia/MuteDuration;", "toNativeMuteDurations", "groups", "toNativeGroups", "Lcom/tencent/trpcprotocol/group_pro/configdistribution/config_distribution_svr/configDistributionSvr$GetConfigReq;", "createReqFromNativeObj", "(Lcom/tencent/freesia/GetConfigReq;)Lcom/tencent/trpcprotocol/group_pro/configdistribution/config_distribution_svr/configDistributionSvr$GetConfigReq;", "Lcom/tencent/freesia/SsoReportReq;", "Lcom/tencent/trpcprotocol/group_pro/configdistribution/config_distribution_svr/configDistributionSvr$SsoReportReq;", "createReportReq", "(Lcom/tencent/freesia/SsoReportReq;)Lcom/tencent/trpcprotocol/group_pro/configdistribution/config_distribution_svr/configDistributionSvr$SsoReportReq;", "Lcom/tencent/freesia/GetConfigRsp;", "toNativeRsp", "(Lcom/tencent/trpcprotocol/group_pro/configdistribution/config_distribution_svr/configDistributionSvr$GetConfigRsp;)Lcom/tencent/freesia/GetConfigRsp;", "toEmptyNativeRsp", "()Lcom/tencent/freesia/GetConfigRsp;", "<init>", "()V", "unitedconfig-android_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes6.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        private final configDistributionSvr.CommonInfo createCommonInfo(GetConfigReq nativeReq) {
            CommonInfo it = nativeReq.getCommonInfo();
            if (it != null) {
                configDistributionSvr.CommonInfo commonInfo = new configDistributionSvr.CommonInfo();
                PBUInt32Field pBUInt32Field = commonInfo.scene_id;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                pBUInt32Field.set(it.getSceneID());
                commonInfo.model_type.set(it.getModelType().ordinal());
                commonInfo.trigger_type.set(it.getTriggerType());
                commonInfo.trigger_interval.set(it.getTriggerInterval());
                return commonInfo;
            }
            return null;
        }

        private final configDistributionSvr.ControlInfo createControlInfo(GetConfigReq nativeReq) {
            boolean z16;
            configDistributionSvr.ControlInfo controlInfo = new configDistributionSvr.ControlInfo();
            ControlInfo controlInfo2 = nativeReq.getControlInfo();
            Intrinsics.checkNotNullExpressionValue(controlInfo2, "nativeReq.controlInfo");
            if (controlInfo2.getCookies() != null) {
                PBBytesField pBBytesField = controlInfo.cookies;
                ControlInfo controlInfo3 = nativeReq.getControlInfo();
                Intrinsics.checkNotNullExpressionValue(controlInfo3, "nativeReq.controlInfo");
                pBBytesField.set(ByteStringMicro.copyFrom(controlInfo3.getCookies()));
            }
            PBStringField pBStringField = controlInfo.env;
            ControlInfo controlInfo4 = nativeReq.getControlInfo();
            Intrinsics.checkNotNullExpressionValue(controlInfo4, "nativeReq.controlInfo");
            pBStringField.set(controlInfo4.getEnv());
            PBUInt64Field pBUInt64Field = controlInfo.config_seq;
            ControlInfo controlInfo5 = nativeReq.getControlInfo();
            Intrinsics.checkNotNullExpressionValue(controlInfo5, "nativeReq.controlInfo");
            pBUInt64Field.set(controlInfo5.getConfigSeq());
            PBStringField pBStringField2 = controlInfo.config_nologin_snapshot;
            ControlInfo controlInfo6 = nativeReq.getControlInfo();
            Intrinsics.checkNotNullExpressionValue(controlInfo6, "nativeReq.controlInfo");
            pBStringField2.set(controlInfo6.getConfigNologinSnapshot());
            ControlInfo controlInfo7 = nativeReq.getControlInfo();
            Intrinsics.checkNotNullExpressionValue(controlInfo7, "nativeReq.controlInfo");
            byte[] incCookies = controlInfo7.getIncCookies();
            boolean z17 = false;
            if (incCookies != null) {
                if (incCookies.length == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    controlInfo.inc_cookies.set(ByteStringMicro.copyFrom(incCookies));
                }
            }
            ControlInfo controlInfo8 = nativeReq.getControlInfo();
            Intrinsics.checkNotNullExpressionValue(controlInfo8, "nativeReq.controlInfo");
            byte[] incNologinCookies = controlInfo8.getIncNologinCookies();
            if (incNologinCookies != null) {
                if (incNologinCookies.length == 0) {
                    z17 = true;
                }
                if (!z17) {
                    controlInfo.inc_nologin_cookies.set(ByteStringMicro.copyFrom(incNologinCookies));
                }
            }
            return controlInfo;
        }

        private final configDistributionSvr.DeviceInfo createDeviceInfo(DeviceInfo deviceInfo) {
            configDistributionSvr.DeviceInfo deviceInfo2 = new configDistributionSvr.DeviceInfo();
            deviceInfo2.brand.set(deviceInfo.getBrand());
            deviceInfo2.model.set(deviceInfo.getModel());
            configDistributionSvr.OS os5 = new configDistributionSvr.OS();
            PBEnumField pBEnumField = os5.type;
            OS os6 = deviceInfo.getOs();
            Intrinsics.checkNotNullExpressionValue(os6, "deviceInfo.os");
            pBEnumField.set(os6.getType().ordinal());
            PBStringField pBStringField = os5.version;
            OS os7 = deviceInfo.getOs();
            Intrinsics.checkNotNullExpressionValue(os7, "deviceInfo.os");
            pBStringField.set(os7.getVersion());
            deviceInfo2.f381454os.set(os5);
            return deviceInfo2;
        }

        private final configDistributionSvr.Extend createExtend(Extend nativeExtend) {
            configDistributionSvr.Extend extend = new configDistributionSvr.Extend();
            extend.custom_field.set(new configDistributionSvr.CustomField());
            ArrayList arrayList = new ArrayList();
            CustomField customField = nativeExtend.getCustomField();
            Intrinsics.checkNotNullExpressionValue(customField, "nativeExtend.customField");
            Iterator<KV> it = customField.getKv().iterator();
            while (it.hasNext()) {
                KV kv5 = it.next();
                configDistributionSvr.KV kv6 = new configDistributionSvr.KV();
                PBStringField pBStringField = kv6.key;
                Intrinsics.checkNotNullExpressionValue(kv5, "kv");
                pBStringField.set(kv5.getKey());
                kv6.val.set(kv5.getVal());
                arrayList.add(kv6);
            }
            extend.custom_field.f381453kv.addAll(arrayList);
            extend.four_digit_version.set(nativeExtend.getFourDigitVersion());
            return extend;
        }

        private final ArrayList<configDistributionSvr.GroupInfo> createGroupInfos(ArrayList<GroupInfo> groupInfos) {
            boolean z16;
            ArrayList<configDistributionSvr.GroupInfo> arrayList = new ArrayList<>();
            Iterator<GroupInfo> it = groupInfos.iterator();
            while (it.hasNext()) {
                GroupInfo it5 = it.next();
                configDistributionSvr.GroupInfo groupInfo = new configDistributionSvr.GroupInfo();
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                String group = it5.getGroup();
                Intrinsics.checkNotNullExpressionValue(group, "it.group");
                boolean z17 = true;
                if (group.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    groupInfo.group.set(it5.getGroup());
                }
                if (it5.getGroupId() != 0) {
                    groupInfo.group_id.set(it5.getGroupId());
                }
                String oldVersion = it5.getOldVersion();
                Intrinsics.checkNotNullExpressionValue(oldVersion, "it.oldVersion");
                if (oldVersion.length() <= 0) {
                    z17 = false;
                }
                if (z17) {
                    groupInfo.version.set(it5.getOldVersion());
                }
                groupInfo.new_version.set(it5.getNewVersion());
                arrayList.add(groupInfo);
            }
            return arrayList;
        }

        private final ArrayList<configDistributionSvr.ProjectInfo> createProjectInfos(ArrayList<ProjectInfo> projectInfos) {
            ArrayList<configDistributionSvr.ProjectInfo> arrayList = new ArrayList<>();
            Iterator<ProjectInfo> it = projectInfos.iterator();
            while (it.hasNext()) {
                ProjectInfo it5 = it.next();
                configDistributionSvr.ProjectInfo projectInfo = new configDistributionSvr.ProjectInfo();
                PBStringField pBStringField = projectInfo.f381455id;
                Intrinsics.checkNotNullExpressionValue(it5, "it");
                pBStringField.set(it5.getId());
                arrayList.add(projectInfo);
            }
            return arrayList;
        }

        private final configDistributionSvr.ReqPageInfo createReqPageInfo(ReqPageInfo pageInfo) {
            configDistributionSvr.ReqPageInfo reqPageInfo = new configDistributionSvr.ReqPageInfo();
            reqPageInfo.last_idx.set(pageInfo.getLastIdx());
            return reqPageInfo;
        }

        private final ArrayList<Config> toNativeConfigs(List<configDistributionSvr.RespConfig> configs) {
            String str;
            String str2;
            boolean z16;
            ArrayList<Config> arrayList = new ArrayList<>(configs.size());
            for (configDistributionSvr.RespConfig respConfig : configs) {
                if (!respConfig.group.has()) {
                    str = "";
                } else {
                    str = respConfig.group.get();
                }
                List<configDistributionSvr.Content> list = respConfig.contents.get();
                Intrinsics.checkNotNullExpressionValue(list, "item.contents.get()");
                ArrayList<Content> nativeContents = toNativeContents(list);
                if (!respConfig.bussiness_id.has()) {
                    str2 = "";
                } else {
                    str2 = respConfig.bussiness_id.get();
                }
                int i3 = respConfig.group_id.get();
                int i16 = respConfig.new_version.get();
                if (respConfig.is_no_login_config.has()) {
                    z16 = respConfig.is_no_login_config.get();
                } else {
                    z16 = false;
                }
                arrayList.add(new Config(str, nativeContents, str2, i3, i16, z16));
            }
            return arrayList;
        }

        private final ArrayList<Content> toNativeContents(List<configDistributionSvr.Content> contents) {
            boolean z16;
            boolean z17;
            ArrayList<Content> arrayList = new ArrayList<>(contents.size());
            for (configDistributionSvr.Content content : contents) {
                int i3 = 0;
                if (content.switch_status.has()) {
                    z16 = content.switch_status.get();
                } else {
                    z16 = false;
                }
                byte[] byteArray = content.content.get().toByteArray();
                int i16 = content.compress.get();
                long j3 = content.size.get();
                if (content.is_cdn_config.has()) {
                    z17 = content.is_cdn_config.get();
                } else {
                    z17 = false;
                }
                if (content.check_sum.has()) {
                    i3 = content.check_sum.get();
                }
                arrayList.add(new Content(byteArray, i16, j3, z16, z17, i3));
            }
            return arrayList;
        }

        private final ArrayList<GroupInfo> toNativeGroups(List<configDistributionSvr.GroupInfo> groups) {
            String str;
            ArrayList<GroupInfo> arrayList = new ArrayList<>();
            for (configDistributionSvr.GroupInfo groupInfo : groups) {
                if (!groupInfo.group.has()) {
                    str = "";
                } else {
                    str = groupInfo.group.get();
                }
                arrayList.add(new GroupInfo(str, "", groupInfo.group_id.get(), 0));
            }
            return arrayList;
        }

        private final ArrayList<MuteDuration> toNativeMuteDurations(List<configDistributionSvr.MuteDuration> muteDurations) {
            ArrayList<MuteDuration> arrayList = new ArrayList<>(muteDurations.size());
            try {
                for (configDistributionSvr.MuteDuration muteDuration : muteDurations) {
                    arrayList.add(new MuteDuration(muteDuration.start_time.get(), muteDuration.end_time.get()));
                }
            } catch (Throwable th5) {
                ILogger logger = UnitedConfig.INSTANCE.getLOGGER();
                if (logger != null) {
                    logger.e("FreesiaPB", th5.getClass().getSimpleName() + MsgSummary.STR_COLON + th5.getMessage());
                }
            }
            return arrayList;
        }

        private final RespControlInfo toNativeRespControlInfo(configDistributionSvr.RespControlInfo controlInfo) {
            RespControlInfo respControlInfo;
            byte[] bArr;
            int i3;
            ArrayList arrayList;
            ArrayList arrayList2;
            int i16;
            ArrayList<MuteDuration> arrayList3;
            long j3;
            ArrayList<GroupInfo> arrayList4;
            NextFetchType nextFetchType;
            byte[] bArr2;
            byte[] bArr3;
            if (controlInfo.has()) {
                byte[] byteArray = controlInfo.cookies.get().toByteArray();
                int i17 = controlInfo.interval_reconnect.get();
                if (controlInfo.groups.has()) {
                    arrayList = new ArrayList(controlInfo.groups.get());
                } else {
                    arrayList = new ArrayList(0);
                }
                ArrayList arrayList5 = arrayList;
                if (controlInfo.next_int_req_groups.has()) {
                    arrayList2 = new ArrayList(controlInfo.next_int_req_groups.get());
                } else {
                    arrayList2 = new ArrayList(0);
                }
                ArrayList arrayList6 = arrayList2;
                if (controlInfo.update_interval.has()) {
                    i16 = controlInfo.update_interval.get();
                } else {
                    i16 = 360;
                }
                int i18 = i16;
                if (controlInfo.mute_durations.has()) {
                    List<configDistributionSvr.MuteDuration> list = controlInfo.mute_durations.get();
                    Intrinsics.checkNotNullExpressionValue(list, "controlInfo.mute_durations.get()");
                    arrayList3 = toNativeMuteDurations(list);
                } else {
                    arrayList3 = new ArrayList<>(0);
                }
                ArrayList<MuteDuration> arrayList7 = arrayList3;
                if (controlInfo.config_seq.has()) {
                    j3 = controlInfo.config_seq.get();
                } else {
                    j3 = 0;
                }
                if (controlInfo.qps_limited_groups.has()) {
                    List<configDistributionSvr.GroupInfo> list2 = controlInfo.qps_limited_groups.get();
                    Intrinsics.checkNotNullExpressionValue(list2, "controlInfo.qps_limited_groups.get()");
                    arrayList4 = toNativeGroups(list2);
                } else {
                    arrayList4 = new ArrayList<>();
                }
                ArrayList<GroupInfo> arrayList8 = arrayList4;
                if (controlInfo.next_fetch_type.has()) {
                    nextFetchType = NextFetchType.values()[controlInfo.next_fetch_type.get()];
                } else {
                    nextFetchType = NextFetchType.NO_CHANGE;
                }
                NextFetchType nextFetchType2 = nextFetchType;
                if (controlInfo.inc_cookies.has()) {
                    bArr2 = controlInfo.inc_cookies.get().toByteArray();
                } else {
                    bArr2 = new byte[0];
                }
                byte[] bArr4 = bArr2;
                if (controlInfo.inc_nologin_cookies.has()) {
                    bArr3 = controlInfo.inc_nologin_cookies.get().toByteArray();
                } else {
                    bArr3 = new byte[0];
                }
                respControlInfo = new RespControlInfo(byteArray, i17, arrayList5, arrayList6, i18, arrayList7, j3, arrayList8, nextFetchType2, bArr4, bArr3);
            } else {
                if (controlInfo.cookies.has()) {
                    bArr = controlInfo.cookies.get().toByteArray();
                } else {
                    bArr = new byte[0];
                }
                byte[] bArr5 = bArr;
                if (controlInfo.interval_reconnect.has()) {
                    i3 = controlInfo.interval_reconnect.get();
                } else {
                    i3 = 0;
                }
                respControlInfo = new RespControlInfo(bArr5, i3, new ArrayList(0), new ArrayList(0), 0, new ArrayList(0), 0L, new ArrayList(), NextFetchType.NO_CHANGE, new byte[0], new byte[0]);
            }
            return respControlInfo;
        }

        private final RespPageInfo toNativeRespPageInfo(configDistributionSvr.GetConfigRsp rsp) {
            boolean z16 = true;
            int i3 = -1;
            if (rsp.page_info.has()) {
                if (rsp.page_info.last_idx.has()) {
                    i3 = rsp.page_info.last_idx.get();
                }
                if (rsp.page_info.is_finish.has()) {
                    z16 = rsp.page_info.is_finish.get();
                }
                return new RespPageInfo(i3, z16);
            }
            return new RespPageInfo(-1, true);
        }

        @NotNull
        public final configDistributionSvr.SsoReportReq createReportReq(@NotNull SsoReportReq nativeReq) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (configDistributionSvr.SsoReportReq) iPatchRedirector.redirect((short) 4, (Object) this, (Object) nativeReq);
            }
            Intrinsics.checkNotNullParameter(nativeReq, "nativeReq");
            configDistributionSvr.SsoReportReq ssoReportReq = new configDistributionSvr.SsoReportReq();
            ssoReportReq.report_type.set(nativeReq.getReportType().ordinal());
            PBRepeatMessageField<configDistributionSvr.GroupInfo> pBRepeatMessageField = ssoReportReq.group_infos;
            ArrayList<GroupInfo> groupInfos = nativeReq.getGroupInfos();
            Intrinsics.checkNotNullExpressionValue(groupInfos, "nativeReq.groupInfos");
            pBRepeatMessageField.addAll(createGroupInfos(groupInfos));
            configDistributionSvr.DeviceInfo deviceInfo = ssoReportReq.device_info;
            DeviceInfo deviceInfo2 = nativeReq.getDeviceInfo();
            Intrinsics.checkNotNullExpressionValue(deviceInfo2, "nativeReq.deviceInfo");
            deviceInfo.set(createDeviceInfo(deviceInfo2));
            ssoReportReq.ext_info.set(ByteStringMicro.copyFrom(nativeReq.getExtInfo()));
            return ssoReportReq;
        }

        @NotNull
        public final configDistributionSvr.GetConfigReq createReqFromNativeObj(@NotNull GetConfigReq nativeReq) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (configDistributionSvr.GetConfigReq) iPatchRedirector.redirect((short) 3, (Object) this, (Object) nativeReq);
            }
            Intrinsics.checkNotNullParameter(nativeReq, "nativeReq");
            configDistributionSvr.GetConfigReq getConfigReq = new configDistributionSvr.GetConfigReq();
            configDistributionSvr.CommonInfo createCommonInfo = createCommonInfo(nativeReq);
            if (createCommonInfo != null) {
                getConfigReq.common_info.set(createCommonInfo);
            }
            PBRepeatMessageField<configDistributionSvr.GroupInfo> pBRepeatMessageField = getConfigReq.group_infos;
            ArrayList<GroupInfo> groupInfos = nativeReq.getGroupInfos();
            Intrinsics.checkNotNullExpressionValue(groupInfos, "nativeReq.groupInfos");
            pBRepeatMessageField.addAll(createGroupInfos(groupInfos));
            configDistributionSvr.DeviceInfo deviceInfo = getConfigReq.device_info;
            DeviceInfo deviceInfo2 = nativeReq.getDeviceInfo();
            Intrinsics.checkNotNullExpressionValue(deviceInfo2, "nativeReq.deviceInfo");
            deviceInfo.set(createDeviceInfo(deviceInfo2));
            getConfigReq.control_info.set(createControlInfo(nativeReq));
            PBRepeatMessageField<configDistributionSvr.ProjectInfo> pBRepeatMessageField2 = getConfigReq.project_infos;
            ArrayList<ProjectInfo> projectInfos = nativeReq.getProjectInfos();
            Intrinsics.checkNotNullExpressionValue(projectInfos, "nativeReq.projectInfos");
            pBRepeatMessageField2.addAll(createProjectInfos(projectInfos));
            getConfigReq.fetch_type.set(nativeReq.getFetchType().ordinal());
            ReqPageInfo it = nativeReq.getPageInfo();
            if (it != null) {
                configDistributionSvr.ReqPageInfo reqPageInfo = getConfigReq.page_info;
                Companion companion = PBUtils.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                reqPageInfo.set(companion.createReqPageInfo(it));
            }
            configDistributionSvr.Extend extend = getConfigReq.extend;
            Extend extend2 = nativeReq.getExtend();
            Intrinsics.checkNotNullExpressionValue(extend2, "nativeReq.extend");
            extend.set(createExtend(extend2));
            String configSnapshot = nativeReq.getConfigSnapshot();
            Intrinsics.checkNotNullExpressionValue(configSnapshot, "nativeReq.configSnapshot");
            if (configSnapshot.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                getConfigReq.config_snapshot.set(nativeReq.getConfigSnapshot());
            }
            return getConfigReq;
        }

        @NotNull
        public final GetConfigRsp toEmptyNativeRsp() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (GetConfigRsp) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return new GetConfigRsp(new byte[0], new ArrayList(0), new ArrayList(0), new RespControlInfo(new byte[0], 0, new ArrayList(0), new ArrayList(0), 360, new ArrayList(0), 0L, new ArrayList(), NextFetchType.NO_CHANGE, new byte[0], new byte[0]), new RespPageInfo(-1, true), false, "", 1000, SnapshotResult.PAGING_FETCH);
        }

        @NotNull
        public final GetConfigRsp toNativeRsp(@NotNull configDistributionSvr.GetConfigRsp rsp) {
            byte[] bArr;
            List<configDistributionSvr.RespConfig> arrayList;
            ArrayList arrayList2;
            boolean z16;
            String str;
            int i3;
            SnapshotResult snapshotResult;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (GetConfigRsp) iPatchRedirector.redirect((short) 5, (Object) this, (Object) rsp);
            }
            Intrinsics.checkNotNullParameter(rsp, "rsp");
            if (rsp.ext_info.has()) {
                bArr = rsp.ext_info.get().toByteArray();
            } else {
                bArr = new byte[0];
            }
            byte[] bArr2 = bArr;
            if (rsp.configs.has()) {
                arrayList = rsp.configs.get();
            } else {
                arrayList = new ArrayList<>(0);
            }
            Intrinsics.checkNotNullExpressionValue(arrayList, "if (rsp.configs.has()) r\u2026s.get() else ArrayList(0)");
            ArrayList<Config> nativeConfigs = toNativeConfigs(arrayList);
            if (rsp.debug_msgs.has()) {
                arrayList2 = new ArrayList(rsp.debug_msgs.get());
            } else {
                arrayList2 = new ArrayList(0);
            }
            ArrayList arrayList3 = arrayList2;
            configDistributionSvr.RespControlInfo respControlInfo = rsp.resp_control_info;
            Intrinsics.checkNotNullExpressionValue(respControlInfo, "rsp.resp_control_info");
            RespControlInfo nativeRespControlInfo = toNativeRespControlInfo(respControlInfo);
            RespPageInfo nativeRespPageInfo = toNativeRespPageInfo(rsp);
            if (rsp.enable_config_snapshot.has()) {
                z16 = rsp.enable_config_snapshot.get();
            } else {
                z16 = false;
            }
            if (rsp.config_verify.has()) {
                str = rsp.config_verify.get();
            } else {
                str = "";
            }
            String str2 = str;
            if (rsp.resource_report_denominator.has()) {
                i3 = rsp.resource_report_denominator.get();
            } else {
                i3 = 1000;
            }
            int i16 = i3;
            if (rsp.snapshot_result.has()) {
                snapshotResult = SnapshotResult.values()[rsp.snapshot_result.get()];
            } else {
                snapshotResult = SnapshotResult.PAGING_FETCH;
            }
            return new GetConfigRsp(bArr2, nativeConfigs, arrayList3, nativeRespControlInfo, nativeRespPageInfo, z16, str2, i16, snapshotResult);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12974);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PBUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
