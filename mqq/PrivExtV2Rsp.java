package MQQ;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class PrivExtV2Rsp extends JceStruct {
    static QidInfoItem cache_qid_info;
    static QQValueInfoItem cache_qq_value;
    public DataReturnFlag data_flag;
    public int iSyncFreq;
    public int isAuditVersion;
    public int isQQLivePgc;
    public ItemCfgList itemCfgList;
    public Map<Integer, MenumItem> map_menum;
    public VipMedalList medalInfoList;
    public PayRuleCfg payRule;
    public QidInfoItem qid_info;
    public QqLiveMsg qqLiveMsg;
    public QQValueInfoItem qq_value;
    public TrafficResultInfo trafficResult;
    public VipUserInfo vipInfo;
    static VipUserInfo cache_vipInfo = new VipUserInfo();
    static TrafficResultInfo cache_trafficResult = new TrafficResultInfo();
    static VipMedalList cache_medalInfoList = new VipMedalList();
    static ItemCfgList cache_itemCfgList = new ItemCfgList();
    static PayRuleCfg cache_payRule = new PayRuleCfg();
    static QqLiveMsg cache_qqLiveMsg = new QqLiveMsg();
    static DataReturnFlag cache_data_flag = new DataReturnFlag();
    static Map<Integer, MenumItem> cache_map_menum = new HashMap();

    static {
        cache_map_menum.put(0, new MenumItem());
        cache_qid_info = new QidInfoItem();
        cache_qq_value = new QQValueInfoItem();
    }

    public PrivExtV2Rsp() {
        this.vipInfo = null;
        this.trafficResult = null;
        this.iSyncFreq = -1;
        this.medalInfoList = null;
        this.itemCfgList = null;
        this.payRule = null;
        this.isQQLivePgc = 0;
        this.qqLiveMsg = null;
        this.isAuditVersion = 0;
        this.data_flag = null;
        this.map_menum = null;
        this.qid_info = null;
        this.qq_value = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.vipInfo = (VipUserInfo) jceInputStream.read((JceStruct) cache_vipInfo, 0, true);
        this.trafficResult = (TrafficResultInfo) jceInputStream.read((JceStruct) cache_trafficResult, 1, false);
        this.iSyncFreq = jceInputStream.read(this.iSyncFreq, 2, false);
        this.medalInfoList = (VipMedalList) jceInputStream.read((JceStruct) cache_medalInfoList, 3, false);
        this.itemCfgList = (ItemCfgList) jceInputStream.read((JceStruct) cache_itemCfgList, 4, false);
        this.payRule = (PayRuleCfg) jceInputStream.read((JceStruct) cache_payRule, 5, false);
        this.isQQLivePgc = jceInputStream.read(this.isQQLivePgc, 6, false);
        this.qqLiveMsg = (QqLiveMsg) jceInputStream.read((JceStruct) cache_qqLiveMsg, 7, false);
        this.isAuditVersion = jceInputStream.read(this.isAuditVersion, 8, false);
        this.data_flag = (DataReturnFlag) jceInputStream.read((JceStruct) cache_data_flag, 9, false);
        this.map_menum = (Map) jceInputStream.read((JceInputStream) cache_map_menum, 10, false);
        this.qid_info = (QidInfoItem) jceInputStream.read((JceStruct) cache_qid_info, 11, false);
        this.qq_value = (QQValueInfoItem) jceInputStream.read((JceStruct) cache_qq_value, 12, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write((JceStruct) this.vipInfo, 0);
        TrafficResultInfo trafficResultInfo = this.trafficResult;
        if (trafficResultInfo != null) {
            jceOutputStream.write((JceStruct) trafficResultInfo, 1);
        }
        jceOutputStream.write(this.iSyncFreq, 2);
        VipMedalList vipMedalList = this.medalInfoList;
        if (vipMedalList != null) {
            jceOutputStream.write((JceStruct) vipMedalList, 3);
        }
        ItemCfgList itemCfgList = this.itemCfgList;
        if (itemCfgList != null) {
            jceOutputStream.write((JceStruct) itemCfgList, 4);
        }
        PayRuleCfg payRuleCfg = this.payRule;
        if (payRuleCfg != null) {
            jceOutputStream.write((JceStruct) payRuleCfg, 5);
        }
        jceOutputStream.write(this.isQQLivePgc, 6);
        QqLiveMsg qqLiveMsg = this.qqLiveMsg;
        if (qqLiveMsg != null) {
            jceOutputStream.write((JceStruct) qqLiveMsg, 7);
        }
        jceOutputStream.write(this.isAuditVersion, 8);
        DataReturnFlag dataReturnFlag = this.data_flag;
        if (dataReturnFlag != null) {
            jceOutputStream.write((JceStruct) dataReturnFlag, 9);
        }
        Map<Integer, MenumItem> map = this.map_menum;
        if (map != null) {
            jceOutputStream.write((Map) map, 10);
        }
        QidInfoItem qidInfoItem = this.qid_info;
        if (qidInfoItem != null) {
            jceOutputStream.write((JceStruct) qidInfoItem, 11);
        }
        QQValueInfoItem qQValueInfoItem = this.qq_value;
        if (qQValueInfoItem != null) {
            jceOutputStream.write((JceStruct) qQValueInfoItem, 12);
        }
    }

    public PrivExtV2Rsp(VipUserInfo vipUserInfo, TrafficResultInfo trafficResultInfo, int i3, VipMedalList vipMedalList, ItemCfgList itemCfgList, PayRuleCfg payRuleCfg, int i16, QqLiveMsg qqLiveMsg, int i17, DataReturnFlag dataReturnFlag, Map<Integer, MenumItem> map, QidInfoItem qidInfoItem, QQValueInfoItem qQValueInfoItem) {
        this.vipInfo = vipUserInfo;
        this.trafficResult = trafficResultInfo;
        this.iSyncFreq = i3;
        this.medalInfoList = vipMedalList;
        this.itemCfgList = itemCfgList;
        this.payRule = payRuleCfg;
        this.isQQLivePgc = i16;
        this.qqLiveMsg = qqLiveMsg;
        this.isAuditVersion = i17;
        this.data_flag = dataReturnFlag;
        this.map_menum = map;
        this.qid_info = qidInfoItem;
        this.qq_value = qQValueInfoItem;
    }
}
