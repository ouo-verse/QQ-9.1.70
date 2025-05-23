package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_lucky_money;
import NS_MOBILE_FEEDS.s_user;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellLuckyMoney implements SmartParcelable {
    public static final String LUCKYMONEY_LIST_TAB = "luckymoney_list";

    @NeedParcel
    public Map<String, String> extendInfo;

    @NeedParcel
    public boolean isGeted;

    @NeedParcel
    public boolean isGrabEnd;

    @NeedParcel
    public int luckyMoneyAllocType;

    @NeedParcel
    public ArrayList<User> luckyMoneyMen;

    @NeedParcel
    public int luckyMoneyType;

    @NeedParcel
    public int num;
    public String unikey;

    @NeedParcel
    public String actionUrl = "";

    @NeedParcel
    public String luckyMoneyId = "";

    @NeedParcel
    public String luckyMoneyPayId = "";
    public String displayStr = "";
    public Integer integerUnikey = -1;

    public String calculateSummaryDisplayStr(String str) {
        String c16;
        int i3 = this.luckyMoneyType;
        if (i3 == 1) {
            c16 = com.qzone.adapter.feedcomponent.h.c("QZoneSetting", "RedPocketSummaryPrefixCmd", "[em]e10048[/em][em]e10049[/em][em]e10050[/em]");
        } else if (i3 == 2) {
            c16 = com.qzone.adapter.feedcomponent.h.c("QZoneSetting", "RedPocketQuestionPrefixCmd", "[em]e10051[/em][em]e10052[/em][em]e10053[/em]");
        } else if (i3 != 3) {
            c16 = "";
        } else {
            c16 = com.qzone.adapter.feedcomponent.h.c("QZoneSetting", "RedPocketPasswordPrefixCmd", "[em]e10058[/em][em]e10059[/em][em]e10060[/em]");
        }
        if (str == null) {
            return c16;
        }
        return c16 + str;
    }

    public static CellLuckyMoney create(l lVar) {
        if (lVar == null || lVar.f50349e0 == null) {
            return null;
        }
        CellLuckyMoney cellLuckyMoney = new CellLuckyMoney();
        cell_lucky_money cell_lucky_moneyVar = lVar.f50349e0;
        cellLuckyMoney.num = cell_lucky_moneyVar.num;
        if (cell_lucky_moneyVar.isGeted == 1) {
            cellLuckyMoney.isGeted = true;
        } else {
            cellLuckyMoney.isGeted = false;
        }
        cellLuckyMoney.actionUrl = cell_lucky_moneyVar.actionUrl;
        ArrayList<s_user> arrayList = cell_lucky_moneyVar.getLuckyMoneyMen;
        if (arrayList != null) {
            cellLuckyMoney.luckyMoneyMen = User.fromSUserList(arrayList);
        }
        cell_lucky_money cell_lucky_moneyVar2 = lVar.f50349e0;
        cellLuckyMoney.extendInfo = cell_lucky_moneyVar2.extendinfo;
        cellLuckyMoney.luckyMoneyId = cell_lucky_moneyVar2.luckyMoneyId;
        cellLuckyMoney.luckyMoneyPayId = cell_lucky_moneyVar2.luckyMoneyPayId;
        cellLuckyMoney.isGrabEnd = cell_lucky_moneyVar2.isGrabEnd != 0;
        cellLuckyMoney.luckyMoneyType = cell_lucky_moneyVar2.luckyMoneyType;
        cellLuckyMoney.luckyMoneyAllocType = cell_lucky_moneyVar2.luckyMoneyAllocType;
        return cellLuckyMoney;
    }
}
