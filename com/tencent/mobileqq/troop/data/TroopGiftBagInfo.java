package com.tencent.mobileqq.troop.data;

import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import tencent.im.oidb.cmd0x6c2.oidb_0x6c2$GiftBagInfo;
import tencent.im.oidb.cmd0x6c2.oidb_0x6c2$Player;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopGiftBagInfo extends Entity {
    static IPatchRedirector $redirector_;
    public int amount;
    public int count;
    public long doneTime;
    public int endFlag;
    public long endTime;
    public String ext;

    @unique
    public String giftBagId;
    public String giftName;
    public long giftOwner;
    public String giftUnit;

    @notColumn
    public u myGrabResult;
    public String myGrabResultData;

    @notColumn
    public List<u> players;
    public String playersData;
    public int remainAmount;
    public int remainCount;
    public long startTime;
    public long troopUin;
    public int winner;

    public TroopGiftBagInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private List<u> decodeBagPlayerList(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                Object obj = jSONArray.get(i3);
                u uVar = new u();
                uVar.a(obj.toString());
                arrayList.add(uVar);
            }
        } catch (JSONException e16) {
            QLog.e(LogTag.TAG_TROOP_SEND_GIFT, 2, getClass().getSimpleName() + " toJson error. e=" + e16);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public boolean entityByCursor(Cursor cursor) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) cursor)).booleanValue();
        }
        int columnIndex = cursor.getColumnIndex("giftBagId");
        if (columnIndex >= 0) {
            this.giftBagId = cursor.getString(columnIndex);
        }
        int columnIndex2 = cursor.getColumnIndex("count");
        if (columnIndex2 >= 0) {
            this.count = cursor.getInt(columnIndex2);
        }
        int columnIndex3 = cursor.getColumnIndex("amount");
        if (columnIndex3 >= 0) {
            this.amount = cursor.getInt(columnIndex3);
        }
        int columnIndex4 = cursor.getColumnIndex("startTime");
        if (columnIndex4 >= 0) {
            this.startTime = cursor.getLong(columnIndex4);
        }
        int columnIndex5 = cursor.getColumnIndex("endTime");
        if (columnIndex5 >= 0) {
            this.endTime = cursor.getLong(columnIndex5);
        }
        int columnIndex6 = cursor.getColumnIndex("playersData");
        if (columnIndex6 >= 0) {
            this.players = decodeBagPlayerList(cursor.getString(columnIndex6));
        }
        int columnIndex7 = cursor.getColumnIndex("endFlag");
        if (columnIndex7 >= 0) {
            this.endFlag = cursor.getInt(columnIndex7);
        }
        int columnIndex8 = cursor.getColumnIndex("remainCount");
        if (columnIndex8 >= 0) {
            this.remainCount = cursor.getInt(columnIndex8);
        }
        int columnIndex9 = cursor.getColumnIndex("remainAmount");
        if (columnIndex9 >= 0) {
            this.remainAmount = cursor.getInt(columnIndex9);
        }
        int columnIndex10 = cursor.getColumnIndex("winner");
        if (columnIndex10 >= 0) {
            this.winner = cursor.getInt(columnIndex10);
        }
        int columnIndex11 = cursor.getColumnIndex("giftOwner");
        if (columnIndex11 >= 0) {
            this.giftOwner = cursor.getLong(columnIndex11);
        }
        int columnIndex12 = cursor.getColumnIndex("troopUin");
        if (columnIndex12 >= 0) {
            this.troopUin = cursor.getLong(columnIndex12);
        }
        int columnIndex13 = cursor.getColumnIndex("doneTime");
        if (columnIndex13 >= 0) {
            this.doneTime = cursor.getLong(columnIndex13);
        }
        int columnIndex14 = cursor.getColumnIndex("giftName");
        if (columnIndex14 >= 0) {
            this.giftName = cursor.getString(columnIndex14);
        }
        int columnIndex15 = cursor.getColumnIndex("giftUnit");
        if (columnIndex15 >= 0) {
            this.giftUnit = cursor.getString(columnIndex15);
        }
        int columnIndex16 = cursor.getColumnIndex("ext");
        if (columnIndex16 >= 0) {
            this.ext = cursor.getString(columnIndex16);
        }
        this.myGrabResult = new u();
        int columnIndex17 = cursor.getColumnIndex("myGrabResultData");
        if (columnIndex17 >= 0) {
            String string = cursor.getString(columnIndex17);
            if (!TextUtils.isEmpty(string)) {
                this.myGrabResult.a(string);
            }
        }
        return super.entityByCursor(cursor);
    }

    public boolean hasGrab() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        u uVar = this.myGrabResult;
        if (uVar != null && uVar.f294995c > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.prewrite();
        JSONArray jSONArray = new JSONArray();
        for (int i3 = 0; i3 < this.players.size(); i3++) {
            jSONArray.mo162put(this.players.get(i3).b());
        }
        this.playersData = jSONArray.toString();
        u uVar = this.myGrabResult;
        if (uVar != null) {
            this.myGrabResultData = uVar.b();
        }
    }

    public TroopGiftBagInfo(oidb_0x6c2$GiftBagInfo oidb_0x6c2_giftbaginfo, oidb_0x6c2$Player oidb_0x6c2_player) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) oidb_0x6c2_giftbaginfo, (Object) oidb_0x6c2_player);
            return;
        }
        this.giftBagId = oidb_0x6c2_giftbaginfo.bytes_gift_bagid.get().toStringUtf8();
        this.count = oidb_0x6c2_giftbaginfo.int32_count.get();
        this.amount = oidb_0x6c2_giftbaginfo.int32_amount.get();
        this.startTime = oidb_0x6c2_giftbaginfo.uint64_start_time.get();
        this.endTime = oidb_0x6c2_giftbaginfo.uint64_end_time.get();
        List<oidb_0x6c2$Player> list = oidb_0x6c2_giftbaginfo.msg_paly.get();
        this.players = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.players.add(new u(list.get(i3)));
        }
        this.endFlag = oidb_0x6c2_giftbaginfo.int32_end.get();
        this.remainCount = oidb_0x6c2_giftbaginfo.int32_remain_count.get();
        this.remainAmount = oidb_0x6c2_giftbaginfo.int32_remain_amount.get();
        this.winner = oidb_0x6c2_giftbaginfo.int32_winner.get();
        this.giftOwner = oidb_0x6c2_giftbaginfo.uint64_gift_owner.get();
        this.troopUin = oidb_0x6c2_giftbaginfo.uint64_group_id.get();
        this.doneTime = oidb_0x6c2_giftbaginfo.uint64_done_time.get();
        this.giftName = oidb_0x6c2_giftbaginfo.bytes_gift_name.get().toStringUtf8();
        this.giftUnit = oidb_0x6c2_giftbaginfo.bytes_gift_unit.get().toStringUtf8();
        this.ext = oidb_0x6c2_giftbaginfo.bytes_ext.get().toStringUtf8();
        if (oidb_0x6c2_player != null) {
            this.myGrabResult = new u(oidb_0x6c2_player);
        }
    }
}
