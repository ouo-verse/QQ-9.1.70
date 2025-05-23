package com.qzone.proxy.feedcomponent.model;

import NS_MOBILE_FEEDS.cell_red_bonus;
import NS_MOBILE_FEEDS.s_redbonus_man;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes39.dex */
public class CellRedBonus implements SmartParcelable {
    public static final String REDBONUS_LIST_TAB = "redbonus_list";

    @NeedParcel
    User curUser;

    @NeedParcel
    public boolean isPayed;

    @NeedParcel
    public ArrayList<RedBonusMan> payMans;

    @NeedParcel
    public long payMenNum;

    @NeedParcel
    public long payMoney;

    @NeedParcel
    public long payNum;

    @NeedParcel
    public long payTotalAccount;
    public String unikey;

    @NeedParcel
    public String actionUrl = "";
    public String displayStr = "";
    public Integer integerUnikey = -1;

    public static CellRedBonus create(l lVar, User user) {
        if (lVar == null || lVar.Z == null) {
            return null;
        }
        CellRedBonus cellRedBonus = new CellRedBonus();
        cellRedBonus.curUser = user;
        cell_red_bonus cell_red_bonusVar = lVar.Z;
        cellRedBonus.payNum = cell_red_bonusVar.payNum;
        cellRedBonus.payTotalAccount = cell_red_bonusVar.payTotalAccount;
        if (cell_red_bonusVar.isPayed == 0) {
            cellRedBonus.isPayed = false;
        } else {
            cellRedBonus.isPayed = true;
        }
        cellRedBonus.payMoney = cell_red_bonusVar.payMoney;
        cellRedBonus.actionUrl = cell_red_bonusVar.actionUrl;
        cellRedBonus.payMenNum = cell_red_bonusVar.payMenNum;
        if (cell_red_bonusVar.payMans == null) {
            return cellRedBonus;
        }
        cellRedBonus.payMans = new ArrayList<>();
        Iterator<s_redbonus_man> it = lVar.Z.payMans.iterator();
        while (it.hasNext()) {
            s_redbonus_man next = it.next();
            RedBonusMan redBonusMan = new RedBonusMan();
            redBonusMan.user = User.fromSUser(next.user);
            redBonusMan.payTime = next.payTime;
            redBonusMan.payMoney = next.payMoney;
            cellRedBonus.payMans.add(redBonusMan);
        }
        return cellRedBonus;
    }
}
