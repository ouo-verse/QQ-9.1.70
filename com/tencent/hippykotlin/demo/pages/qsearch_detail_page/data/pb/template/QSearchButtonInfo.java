package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchButton;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchGuildJump;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchJump;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.QSearchReportInfo;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.nvi.serialization.json.JSONException;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchButtonInfo extends QSearchBaseReportTemplateModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchButtonInfo.class, "joinGroupStatus", "getJoinGroupStatus()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchButtonInfo.class, "joinGuildStatus", "getJoinGuildStatus()I", 0)};
    public int buttonType;
    public QSearchJump jumpInfo;
    public int status;
    public String text = "";
    public Map<String, String> extensionMap = new LinkedHashMap();
    public final ReadWriteProperty joinGroupStatus$delegate = c.a(1);
    public final ReadWriteProperty joinGuildStatus$delegate = c.a(0);
    public String troopUin = "";

    public final int getJoinGroupStatus() {
        return ((Number) this.joinGroupStatus$delegate.getValue(this, $$delegatedProperties[0])).intValue();
    }

    public final int getJoinGuildStatus() {
        return ((Number) this.joinGuildStatus$delegate.getValue(this, $$delegatedProperties[1])).intValue();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r7v13, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, java.lang.String>] */
    public final void parseContent(QSearchButton qSearchButton) {
        QSearchGuildJump qSearchGuildJump;
        String str;
        QSearchReportInfo qSearchReportInfo = qSearchButton.reportInfo;
        if (qSearchReportInfo != null) {
            QSearchTemplateReportInfo qSearchTemplateReportInfo = new QSearchTemplateReportInfo();
            qSearchTemplateReportInfo.eid = qSearchReportInfo.eid;
            qSearchTemplateReportInfo.transferInfo = qSearchReportInfo.reportInfo;
            this.reportInfo = qSearchTemplateReportInfo;
        }
        QSearchJump qSearchJump = qSearchButton.jumpLink;
        this.jumpInfo = qSearchJump;
        if (qSearchJump != null && (str = qSearchJump.extension) != null) {
            try {
                e eVar = new e(str);
                for (String str2 : eVar.b()) {
                    this.extensionMap.put(str2, eVar.q(str2, ""));
                }
            } catch (JSONException unused) {
            }
        }
        int i3 = qSearchButton.buttonType;
        this.buttonType = i3;
        if (i3 == 1) {
            String str3 = (String) this.extensionMap.get("uin");
            if (str3 == null) {
                str3 = qSearchButton.title;
            }
            int friendStatus = Utils.INSTANCE.currentBridgeModule().getFriendStatus(str3);
            if (friendStatus == 0) {
                this.text = "\u6dfb\u52a0";
                this.status = 0;
                return;
            } else if (friendStatus != 2) {
                this.text = "\u7b49\u5f85\u786e\u8ba4";
                this.status = 2;
                return;
            } else {
                this.text = "\u5df2\u6dfb\u52a0";
                this.status = 1;
                return;
            }
        }
        if (i3 != 2) {
            if (i3 != 3) {
                this.text = qSearchButton.title;
                this.status = 0;
                return;
            }
            QSearchJump qSearchJump2 = qSearchButton.jumpLink;
            if (qSearchJump2 != null && (qSearchGuildJump = qSearchJump2.guildJump) != null) {
                int i16 = qSearchGuildJump.joinStatus;
                if (i16 != 1) {
                    if (i16 == 2) {
                        r2 = 1;
                    }
                }
                editJoinGuildStatus(r2);
                return;
            }
            r2 = -1;
            editJoinGuildStatus(r2);
            return;
        }
        String str4 = (String) this.extensionMap.get("join_group_flag");
        r2 = (str4 != null ? Integer.parseInt(str4) : 0) <= -1 ? 1 : 0;
        String str5 = this.troopUin;
        if (r2 == 1) {
            Object valueForKey = com.tencent.kuikly.core.manager.c.f117352a.k(BridgeManager.f117344a.u()).getValueForKey("QSearchTroopStatus_" + str5);
            Integer num = valueForKey instanceof Integer ? (Integer) valueForKey : null;
            if (num != null && num.intValue() == 2) {
                r2 = num.intValue();
            }
        }
        editJoinGroupStatus(r2);
        String str6 = (String) this.extensionMap.get("group_code");
        this.troopUin = str6 != null ? str6 : "";
    }

    public final void editJoinGuildStatus(int i3) {
        if (i3 == 0) {
            this.text = "\u52a0\u5165";
            this.status = 0;
        } else if (i3 != 1) {
            this.text = "";
            this.status = 1;
        } else {
            this.text = "\u5df2\u52a0\u5165";
            this.status = 2;
        }
        this.joinGuildStatus$delegate.setValue(this, $$delegatedProperties[1], Integer.valueOf(i3));
    }

    public final void editJoinGroupStatus(int i3) {
        if (i3 == 0) {
            this.text = "\u5df2\u52a0\u5165";
            this.status = 2;
        } else if (i3 != 1) {
            this.text = "\u7b49\u5f85\u9a8c\u8bc1";
            this.status = 2;
        } else {
            this.text = "\u52a0\u5165";
            this.status = 0;
        }
        this.joinGroupStatus$delegate.setValue(this, $$delegatedProperties[0], Integer.valueOf(i3));
    }
}
