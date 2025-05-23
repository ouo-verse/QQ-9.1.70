package com.tencent.mobileqq.troop.association.data;

import NearbyGroup.Color;
import NearbyGroup.GroupLabel;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x9fb.oidb_0x9fb$Color;
import tencent.im.oidb.cmd0x9fb.oidb_0x9fb$Label;
import tencent.im.oidb.cmd0xede.oidb_0xede$Color;
import tencent.im.oidb.cmd0xede.oidb_0xede$Label;

/* compiled from: P */
/* loaded from: classes19.dex */
public class AssociatedTroopItem implements Serializable {
    static IPatchRedirector $redirector_;
    public int groupFace;
    public String intro;
    public int isConfGroup;
    public String joinAuth;
    public ArrayList<GroupLabel> labelList;
    public int maxMemberNum;
    public int memberNum;
    public String name;
    public int privilege;
    public int relateStatus;
    public int relateType;
    public String richIntro;
    public int seq;

    @unique
    public String uin;

    public AssociatedTroopItem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.maxMemberNum = -1;
        this.memberNum = -1;
        this.relateStatus = 0;
        this.relateType = 0;
        this.privilege = -1;
        this.seq = -1;
    }

    private static oidb_0x9fb$Color a(oidb_0xede$Color oidb_0xede_color) {
        if (oidb_0xede_color == null) {
            return new oidb_0x9fb$Color();
        }
        oidb_0x9fb$Color oidb_0x9fb_color = new oidb_0x9fb$Color();
        oidb_0x9fb_color.uint32_b.set(oidb_0xede_color.uint32_b.get());
        oidb_0x9fb_color.uint32_g.set(oidb_0xede_color.uint32_g.get());
        oidb_0x9fb_color.uint32_r.set(oidb_0xede_color.uint32_r.get());
        return oidb_0x9fb_color;
    }

    private static List<oidb_0x9fb$Label> b(List<oidb_0xede$Label> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (oidb_0xede$Label oidb_0xede_label : list) {
            oidb_0x9fb$Label oidb_0x9fb_label = new oidb_0x9fb$Label();
            oidb_0x9fb_label.bytes_name.set(oidb_0xede_label.bytes_name.get());
            oidb_0x9fb_label.edging_color.set(a(oidb_0xede_label.edging_color.get()));
            oidb_0x9fb_label.text_color.set(a(oidb_0xede_label.text_color.get()));
            oidb_0x9fb_label.enum_type.set(oidb_0xede_label.enum_type.get());
            oidb_0x9fb_label.uint32_label_attr.set(oidb_0xede_label.uint32_label_attr.get());
            oidb_0x9fb_label.uint32_label_type.set(oidb_0xede_label.uint32_label_type.get());
            arrayList.add(oidb_0x9fb_label);
        }
        return arrayList;
    }

    public static ArrayList<GroupLabel> transLabel(List<oidb_0xede$Label> list) {
        List<oidb_0x9fb$Label> b16;
        if (list != null && (b16 = b(list)) != null && b16.size() > 0) {
            ArrayList<GroupLabel> arrayList = new ArrayList<>();
            for (oidb_0x9fb$Label oidb_0x9fb_label : b16) {
                GroupLabel groupLabel = new GroupLabel();
                Color color = new Color();
                color.R = oidb_0x9fb_label.edging_color.uint32_r.get();
                color.G = oidb_0x9fb_label.edging_color.uint32_g.get();
                color.B = oidb_0x9fb_label.edging_color.uint32_b.get();
                groupLabel.edging_color = color;
                Color color2 = new Color();
                color2.R = oidb_0x9fb_label.text_color.uint32_r.get();
                color2.G = oidb_0x9fb_label.text_color.uint32_g.get();
                color2.B = oidb_0x9fb_label.text_color.uint32_b.get();
                groupLabel.text_color = color2;
                groupLabel.strWording = oidb_0x9fb_label.bytes_name.get().toStringUtf8();
                groupLabel.type = oidb_0x9fb_label.uint32_label_attr.get();
                arrayList.add(groupLabel);
            }
            return arrayList;
        }
        return null;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("AllianceItem{uin='" + this.uin + "', maxMemberNum='" + this.maxMemberNum + "', memberNum='" + this.memberNum + "', relateStatus='" + this.relateStatus + "', relateType='" + this.relateType + "', privilege='" + this.privilege + "', seq='" + this.seq + "', intro='" + this.intro + "', groupFace='" + this.groupFace + "', isConfGroup='" + this.isConfGroup + '\'');
        if (this.labelList != null) {
            sb5.append(", associatedTroopList='");
            int size = this.labelList.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (i3 == size - 1) {
                    sb5.append(this.labelList.get(i3).strWording + "'");
                } else {
                    sb5.append(this.labelList.get(i3).strWording + "\u3001");
                }
            }
        }
        sb5.append("}");
        return sb5.toString();
    }
}
