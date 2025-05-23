package com.tencent.mobileqq.guild.message.pbdecoder;

import android.text.TextUtils;
import com.tencent.mobileqq.app.identity.Proto2JsonUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityByteInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProIdentityInfoWithClientId;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.group_pro_proto.common.common$Msg;
import tencent.im.group_pro_proto.user.msgTransData$ClientIdentity;
import tencent.im.group_pro_proto.user.msgTransData$Identity;
import tencent.im.group_pro_proto.user.msgTransData$IdentityV3;
import tencent.im.group_pro_proto.user.msgTransData$TransData;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildMsgHeadClientIdentityDecoder {

    /* renamed from: a, reason: collision with root package name */
    private AppRuntime f230725a;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public static class MyGProClientIdentityInfo implements IGProClientIdentityInfo {
        private msgTransData$ClientIdentity pbLabel;

        public MyGProClientIdentityInfo(msgTransData$ClientIdentity msgtransdata_clientidentity) {
            this.pbLabel = msgtransdata_clientidentity;
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityInfo
        public String getClientId() {
            return Integer.toString(this.pbLabel.client_id.get());
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityInfo
        public String getDesc() {
            return this.pbLabel.desc.get();
        }

        @Override // com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityInfo
        public IGProClientIdentityByteInfo getIdentityBytes() {
            return new IGProClientIdentityByteInfo() { // from class: com.tencent.mobileqq.guild.message.pbdecoder.GuildMsgHeadClientIdentityDecoder.MyGProClientIdentityInfo.1
                @Override // com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityByteInfo
                public int getClientId() {
                    return MyGProClientIdentityInfo.this.pbLabel.client_identity_bytes.client_id.get();
                }

                @Override // com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityByteInfo
                public List<IGProIdentityInfoWithClientId> getDefaultIdentityList() {
                    List<msgTransData$IdentityV3> list = MyGProClientIdentityInfo.this.pbLabel.client_identity_bytes.default_identitys.get();
                    ArrayList arrayList = new ArrayList();
                    for (final msgTransData$IdentityV3 msgtransdata_identityv3 : list) {
                        arrayList.add(new IGProIdentityInfoWithClientId() { // from class: com.tencent.mobileqq.guild.message.pbdecoder.GuildMsgHeadClientIdentityDecoder.MyGProClientIdentityInfo.1.2
                            @Override // com.tencent.mobileqq.qqguildsdk.data.IGProIdentityInfoWithClientId
                            public String getClientId() {
                                return "" + msgtransdata_identityv3.client_id.get();
                            }

                            @Override // com.tencent.mobileqq.qqguildsdk.data.IGProIdentityInfoWithClientId
                            public IGProIdentityInfo getIdentity() {
                                return new IGProIdentityInfo() { // from class: com.tencent.mobileqq.guild.message.pbdecoder.GuildMsgHeadClientIdentityDecoder.MyGProClientIdentityInfo.1.2.1
                                    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProIdentityInfo
                                    public int getIdentityType() {
                                        return msgtransdata_identityv3.identitys.identity_type.get();
                                    }

                                    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProIdentityInfo
                                    public byte[] getPlateData() {
                                        return msgtransdata_identityv3.identitys.third_party_data.get().toByteArray();
                                    }

                                    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProIdentityInfo
                                    public int getType() {
                                        return msgtransdata_identityv3.identitys.type.get();
                                    }

                                    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProIdentityInfo
                                    public String getValue() {
                                        return msgtransdata_identityv3.identitys.value.get();
                                    }
                                };
                            }
                        });
                    }
                    return arrayList;
                }

                @Override // com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityByteInfo
                public List<IGProIdentityInfo> getIdentityList() {
                    final List<msgTransData$Identity> list = MyGProClientIdentityInfo.this.pbLabel.client_identity_bytes.identitys.get();
                    ArrayList arrayList = new ArrayList();
                    for (final int i3 = 0; i3 < list.size(); i3++) {
                        arrayList.add(new IGProIdentityInfo() { // from class: com.tencent.mobileqq.guild.message.pbdecoder.GuildMsgHeadClientIdentityDecoder.MyGProClientIdentityInfo.1.1
                            @Override // com.tencent.mobileqq.qqguildsdk.data.IGProIdentityInfo
                            public int getIdentityType() {
                                return ((msgTransData$Identity) list.get(i3)).identityType.get();
                            }

                            @Override // com.tencent.mobileqq.qqguildsdk.data.IGProIdentityInfo
                            public byte[] getPlateData() {
                                return ((msgTransData$Identity) list.get(i3)).plateData.get().toByteArray();
                            }

                            @Override // com.tencent.mobileqq.qqguildsdk.data.IGProIdentityInfo
                            public int getType() {
                                return ((msgTransData$Identity) list.get(i3)).type.get();
                            }

                            @Override // com.tencent.mobileqq.qqguildsdk.data.IGProIdentityInfo
                            public String getValue() {
                                return ((msgTransData$Identity) list.get(i3)).value.get();
                            }
                        });
                    }
                    return arrayList;
                }
            };
        }
    }

    public GuildMsgHeadClientIdentityDecoder(AppRuntime appRuntime) {
        this.f230725a = appRuntime;
    }

    public IGProClientIdentityInfo a(MessageRecord messageRecord, common$Msg common_msg) {
        if (TextUtils.isEmpty(messageRecord.getExtInfoFromExtStr(IGuildMessageUtilsApi.GUILD_ID_EXT_STR))) {
            return null;
        }
        msgTransData$TransData msgtransdata_transdata = new msgTransData$TransData();
        if (!Proto2JsonUtil.json2Pb(messageRecord.getExtInfoFromExtStr(IGuildMessageUtilsApi.MSG_GUILD_TRANS_DATA), msgtransdata_transdata)) {
            return null;
        }
        messageRecord.removeExtInfoToExtStr(IGuildMessageUtilsApi.MSG_GUILD_TRANS_DATA);
        MyGProClientIdentityInfo myGProClientIdentityInfo = new MyGProClientIdentityInfo(msgtransdata_transdata.rpt_client_identity);
        common_msg.ext_info.uint32_timestamp.get();
        return myGProClientIdentityInfo;
    }
}
