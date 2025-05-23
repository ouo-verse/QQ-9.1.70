package NS_USER_ACTION_REPORT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: P */
/* loaded from: classes.dex */
public final class ItemInfo extends JceStruct {
    static ArrayList<ActionInfo> cache_action_infos;
    static RuleInfo cache_rule_info;
    static ArrayList<String> cache_sub_item_id;
    public ArrayList<ActionInfo> action_infos;
    public String busi_info;
    public String item_id;
    public String item_type;
    public String module_id;
    public String position_id;
    public RuleInfo rule_info;
    public ArrayList<String> sub_item_id;
    public String sub_module_id;
    public String trigger_info;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        cache_sub_item_id = arrayList;
        arrayList.add("");
        cache_rule_info = new RuleInfo();
        cache_action_infos = new ArrayList<>();
        cache_action_infos.add(new ActionInfo());
    }

    public ItemInfo() {
        this.item_id = "";
        this.sub_item_id = null;
        this.module_id = "";
        this.sub_module_id = "";
        this.position_id = "";
        this.rule_info = null;
        this.action_infos = null;
        this.trigger_info = "";
        this.busi_info = "";
        this.item_type = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.item_id = jceInputStream.readString(0, true);
        this.sub_item_id = (ArrayList) jceInputStream.read((JceInputStream) cache_sub_item_id, 1, false);
        this.module_id = jceInputStream.readString(2, false);
        this.sub_module_id = jceInputStream.readString(3, false);
        this.position_id = jceInputStream.readString(4, false);
        this.rule_info = (RuleInfo) jceInputStream.read((JceStruct) cache_rule_info, 5, false);
        this.action_infos = (ArrayList) jceInputStream.read((JceInputStream) cache_action_infos, 6, true);
        this.trigger_info = jceInputStream.readString(7, false);
        this.busi_info = jceInputStream.readString(8, false);
        this.item_type = jceInputStream.readString(9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.item_id, 0);
        ArrayList<String> arrayList = this.sub_item_id;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 1);
        }
        String str = this.module_id;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.sub_module_id;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        String str3 = this.position_id;
        if (str3 != null) {
            jceOutputStream.write(str3, 4);
        }
        RuleInfo ruleInfo = this.rule_info;
        if (ruleInfo != null) {
            jceOutputStream.write((JceStruct) ruleInfo, 5);
        }
        jceOutputStream.write((Collection) this.action_infos, 6);
        String str4 = this.trigger_info;
        if (str4 != null) {
            jceOutputStream.write(str4, 7);
        }
        String str5 = this.busi_info;
        if (str5 != null) {
            jceOutputStream.write(str5, 8);
        }
        String str6 = this.item_type;
        if (str6 != null) {
            jceOutputStream.write(str6, 9);
        }
    }

    public ItemInfo(String str, ArrayList<String> arrayList, String str2, String str3, String str4, RuleInfo ruleInfo, ArrayList<ActionInfo> arrayList2, String str5, String str6, String str7) {
        this.item_id = str;
        this.sub_item_id = arrayList;
        this.module_id = str2;
        this.sub_module_id = str3;
        this.position_id = str4;
        this.rule_info = ruleInfo;
        this.action_infos = arrayList2;
        this.trigger_info = str5;
        this.busi_info = str6;
        this.item_type = str7;
    }
}
