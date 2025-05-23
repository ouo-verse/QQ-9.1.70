package com.tencent.biz.addContactTroopView;

import NearbyGroup.Color;
import NearbyGroup.GroupInfo;
import NearbyGroup.GroupLabel;
import addcontacts.AccountSearchPb$Label;
import addcontacts.AccountSearchPb$record;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.troop.data.f;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x935.oidb_0x935$RgroupInfo;
import tencent.im.oidb.cmd0x9fb.oidb_0x9fb$Label;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static String f78353a = "b";

    public static View a(Context context, ViewGroup viewGroup, int i3, boolean z16, int i16) {
        View a16 = f.a(context, viewGroup, i16, R.layout.b1z);
        f.b bVar = (f.b) a16.getTag();
        bVar.C.setMaxLabelCount(i3);
        bVar.C.setmIsNeedPriority(z16);
        bVar.I = 1;
        return a16;
    }

    public static void b(View view, Context context, AccountSearchPb$record accountSearchPb$record) {
        if (accountSearchPb$record == null) {
            return;
        }
        GroupInfo groupInfo = new GroupInfo();
        try {
            groupInfo.lCode = accountSearchPb$record.code.get();
        } catch (NumberFormatException unused) {
            if (QLog.isColorLevel()) {
                QLog.e(f78353a, 2, "fillCustomView NumberFormatException");
            }
        }
        groupInfo.strName = accountSearchPb$record.name.get();
        if (accountSearchPb$record.brief.has() && !TextUtils.isEmpty(accountSearchPb$record.brief.get())) {
            groupInfo.strIntro = accountSearchPb$record.brief.get();
        }
        if (accountSearchPb$record.msg_group_labels.has() && !accountSearchPb$record.msg_group_labels.isEmpty()) {
            ArrayList<GroupLabel> arrayList = new ArrayList<>();
            for (AccountSearchPb$Label accountSearchPb$Label : accountSearchPb$record.msg_group_labels.get()) {
                GroupLabel groupLabel = new GroupLabel();
                Color color = new Color();
                color.R = accountSearchPb$Label.edging_color.uint32_r.get();
                color.G = accountSearchPb$Label.edging_color.uint32_g.get();
                color.B = accountSearchPb$Label.edging_color.uint32_b.get();
                groupLabel.edging_color = color;
                Color color2 = new Color();
                color2.R = accountSearchPb$Label.text_color.uint32_r.get();
                color2.G = accountSearchPb$Label.text_color.uint32_g.get();
                color2.B = accountSearchPb$Label.text_color.uint32_b.get();
                groupLabel.text_color = color2;
                groupLabel.strWording = accountSearchPb$Label.bytes_name.get().toStringUtf8();
                groupLabel.type = accountSearchPb$Label.uint32_label_attr.get();
                arrayList.add(groupLabel);
            }
            groupInfo.labels = arrayList;
        }
        f.b(view, groupInfo, context, false);
    }

    public static ArrayList<GroupLabel> c(RecommendTroopItem recommendTroopItem) {
        ArrayList<GroupLabel> arrayList = null;
        if (recommendTroopItem == null) {
            return null;
        }
        if (recommendTroopItem.labelList == null && recommendTroopItem.x935RgroupInfo != null) {
            oidb_0x935$RgroupInfo oidb_0x935_rgroupinfo = new oidb_0x935$RgroupInfo();
            try {
                oidb_0x935_rgroupinfo.mergeFrom(recommendTroopItem.x935RgroupInfo);
                if (oidb_0x935_rgroupinfo.rpt_group_label.has()) {
                    recommendTroopItem.labelList = com.tencent.mobileqq.troop.recommend.utils.a.a(oidb_0x935_rgroupinfo.rpt_group_label.get());
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
        }
        List<oidb_0x9fb$Label> list = recommendTroopItem.labelList;
        if (list == null) {
            return null;
        }
        if (list.size() > 0) {
            arrayList = new ArrayList<>();
            for (oidb_0x9fb$Label oidb_0x9fb_label : recommendTroopItem.labelList) {
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
        }
        return arrayList;
    }
}
