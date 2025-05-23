package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import cooperation.qqcircle.report.QCircleLpReportDc010001;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c extends OGAbstractDao {
    public c() {
        this.columnLen = 38;
    }

    @Override // com.tencent.mobileqq.persistence.OGAbstractDao
    public Entity cursor2Entity(Entity entity, Cursor cursor, boolean z16, NoColumnErrorHandler noColumnErrorHandler) {
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        boolean z36;
        boolean z37;
        boolean z38;
        boolean z39;
        boolean z46;
        boolean z47;
        boolean z48;
        HotChatInfo hotChatInfo = (HotChatInfo) entity;
        boolean z49 = true;
        if (noColumnErrorHandler == null) {
            hotChatInfo.name = cursor.getString(cursor.getColumnIndex("name"));
            hotChatInfo.troopCode = cursor.getString(cursor.getColumnIndex(IProfileProtocolConst.PARAM_TROOP_CODE));
            hotChatInfo.signature = cursor.getString(cursor.getColumnIndex("signature"));
            hotChatInfo.troopUin = cursor.getString(cursor.getColumnIndex("troopUin"));
            hotChatInfo.faceId = cursor.getInt(cursor.getColumnIndex("faceId"));
            hotChatInfo.memberCount = cursor.getInt(cursor.getColumnIndex("memberCount"));
            if (1 == cursor.getShort(cursor.getColumnIndex("hasJoined"))) {
                z36 = true;
            } else {
                z36 = false;
            }
            hotChatInfo.hasJoined = z36;
            if (1 == cursor.getShort(cursor.getColumnIndex("isWifiHotChat"))) {
                z37 = true;
            } else {
                z37 = false;
            }
            hotChatInfo.isWifiHotChat = z37;
            hotChatInfo.uuid = cursor.getString(cursor.getColumnIndex("uuid"));
            hotChatInfo.iconUrl = cursor.getString(cursor.getColumnIndex("iconUrl"));
            hotChatInfo.hotThemeGroupFlag = cursor.getInt(cursor.getColumnIndex("hotThemeGroupFlag"));
            hotChatInfo.detail = cursor.getString(cursor.getColumnIndex("detail"));
            hotChatInfo.state = cursor.getInt(cursor.getColumnIndex("state"));
            hotChatInfo.leftTime = cursor.getLong(cursor.getColumnIndex("leftTime"));
            hotChatInfo.ruState = cursor.getInt(cursor.getColumnIndex("ruState"));
            if (1 == cursor.getShort(cursor.getColumnIndex("supportFlashPic"))) {
                z38 = true;
            } else {
                z38 = false;
            }
            hotChatInfo.supportFlashPic = z38;
            if (1 == cursor.getShort(cursor.getColumnIndex("supportDemo"))) {
                z39 = true;
            } else {
                z39 = false;
            }
            hotChatInfo.supportDemo = z39;
            hotChatInfo.adminLevel = cursor.getInt(cursor.getColumnIndex("adminLevel"));
            hotChatInfo.joinUrl = cursor.getString(cursor.getColumnIndex("joinUrl"));
            hotChatInfo.hotChatType = cursor.getInt(cursor.getColumnIndex("hotChatType"));
            hotChatInfo.memo = cursor.getString(cursor.getColumnIndex("memo"));
            hotChatInfo.memoUrl = cursor.getString(cursor.getColumnIndex("memoUrl"));
            if (1 == cursor.getShort(cursor.getColumnIndex("memoShowed"))) {
                z46 = true;
            } else {
                z46 = false;
            }
            hotChatInfo.memoShowed = z46;
            hotChatInfo.userCreate = cursor.getInt(cursor.getColumnIndex("userCreate"));
            hotChatInfo.strAdminUins = cursor.getString(cursor.getColumnIndex("strAdminUins"));
            hotChatInfo.ownerUin = cursor.getString(cursor.getColumnIndex("ownerUin"));
            hotChatInfo.pkFlag = cursor.getInt(cursor.getColumnIndex("pkFlag"));
            hotChatInfo.subType = cursor.getInt(cursor.getColumnIndex(QCircleLpReportDc010001.KEY_SUBTYPE));
            hotChatInfo.lLastMsgSeq = cursor.getLong(cursor.getColumnIndex("lLastMsgSeq"));
            hotChatInfo.extra1 = cursor.getString(cursor.getColumnIndex("extra1"));
            if (1 == cursor.getShort(cursor.getColumnIndex("isFavorite"))) {
                z47 = true;
            } else {
                z47 = false;
            }
            hotChatInfo.isFavorite = z47;
            hotChatInfo.mFissionRoomNum = cursor.getInt(cursor.getColumnIndex("mFissionRoomNum"));
            hotChatInfo.praiseCount = cursor.getLong(cursor.getColumnIndex("praiseCount"));
            hotChatInfo.uint32_group_flag_ext2 = cursor.getInt(cursor.getColumnIndex("uint32_group_flag_ext2"));
            if (1 == cursor.getShort(cursor.getColumnIndex("isGameRoom"))) {
                z48 = true;
            } else {
                z48 = false;
            }
            hotChatInfo.isGameRoom = z48;
            if (1 != cursor.getShort(cursor.getColumnIndex("isRobotHotChat"))) {
                z49 = false;
            }
            hotChatInfo.isRobotHotChat = z49;
            hotChatInfo.robotUin = cursor.getLong(cursor.getColumnIndex("robotUin"));
            hotChatInfo.apolloGameId = cursor.getInt(cursor.getColumnIndex("apolloGameId"));
        } else {
            int columnIndex = cursor.getColumnIndex("name");
            if (columnIndex == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("name", String.class));
            } else {
                hotChatInfo.name = cursor.getString(columnIndex);
            }
            int columnIndex2 = cursor.getColumnIndex(IProfileProtocolConst.PARAM_TROOP_CODE);
            if (columnIndex2 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError(IProfileProtocolConst.PARAM_TROOP_CODE, String.class));
            } else {
                hotChatInfo.troopCode = cursor.getString(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex("signature");
            if (columnIndex3 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("signature", String.class));
            } else {
                hotChatInfo.signature = cursor.getString(columnIndex3);
            }
            int columnIndex4 = cursor.getColumnIndex("troopUin");
            if (columnIndex4 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("troopUin", String.class));
            } else {
                hotChatInfo.troopUin = cursor.getString(columnIndex4);
            }
            int columnIndex5 = cursor.getColumnIndex("faceId");
            if (columnIndex5 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("faceId", Integer.TYPE));
            } else {
                hotChatInfo.faceId = cursor.getInt(columnIndex5);
            }
            int columnIndex6 = cursor.getColumnIndex("memberCount");
            if (columnIndex6 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("memberCount", Integer.TYPE));
            } else {
                hotChatInfo.memberCount = cursor.getInt(columnIndex6);
            }
            int columnIndex7 = cursor.getColumnIndex("hasJoined");
            if (columnIndex7 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("hasJoined", Boolean.TYPE));
            } else {
                if (1 == cursor.getShort(columnIndex7)) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                hotChatInfo.hasJoined = z17;
            }
            int columnIndex8 = cursor.getColumnIndex("isWifiHotChat");
            if (columnIndex8 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("isWifiHotChat", Boolean.TYPE));
            } else {
                if (1 == cursor.getShort(columnIndex8)) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                hotChatInfo.isWifiHotChat = z18;
            }
            int columnIndex9 = cursor.getColumnIndex("uuid");
            if (columnIndex9 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("uuid", String.class));
            } else {
                hotChatInfo.uuid = cursor.getString(columnIndex9);
            }
            int columnIndex10 = cursor.getColumnIndex("iconUrl");
            if (columnIndex10 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("iconUrl", String.class));
            } else {
                hotChatInfo.iconUrl = cursor.getString(columnIndex10);
            }
            int columnIndex11 = cursor.getColumnIndex("hotThemeGroupFlag");
            if (columnIndex11 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("hotThemeGroupFlag", Integer.TYPE));
            } else {
                hotChatInfo.hotThemeGroupFlag = cursor.getInt(columnIndex11);
            }
            int columnIndex12 = cursor.getColumnIndex("detail");
            if (columnIndex12 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("detail", String.class));
            } else {
                hotChatInfo.detail = cursor.getString(columnIndex12);
            }
            int columnIndex13 = cursor.getColumnIndex("state");
            if (columnIndex13 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("state", Integer.TYPE));
            } else {
                hotChatInfo.state = cursor.getInt(columnIndex13);
            }
            int columnIndex14 = cursor.getColumnIndex("leftTime");
            if (columnIndex14 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("leftTime", Long.TYPE));
            } else {
                hotChatInfo.leftTime = cursor.getLong(columnIndex14);
            }
            int columnIndex15 = cursor.getColumnIndex("ruState");
            if (columnIndex15 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("ruState", Integer.TYPE));
            } else {
                hotChatInfo.ruState = cursor.getInt(columnIndex15);
            }
            int columnIndex16 = cursor.getColumnIndex("supportFlashPic");
            if (columnIndex16 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("supportFlashPic", Boolean.TYPE));
            } else {
                if (1 == cursor.getShort(columnIndex16)) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                hotChatInfo.supportFlashPic = z19;
            }
            int columnIndex17 = cursor.getColumnIndex("supportDemo");
            if (columnIndex17 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("supportDemo", Boolean.TYPE));
            } else {
                if (1 == cursor.getShort(columnIndex17)) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                hotChatInfo.supportDemo = z26;
            }
            int columnIndex18 = cursor.getColumnIndex("adminLevel");
            if (columnIndex18 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("adminLevel", Integer.TYPE));
            } else {
                hotChatInfo.adminLevel = cursor.getInt(columnIndex18);
            }
            int columnIndex19 = cursor.getColumnIndex("joinUrl");
            if (columnIndex19 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("joinUrl", String.class));
            } else {
                hotChatInfo.joinUrl = cursor.getString(columnIndex19);
            }
            int columnIndex20 = cursor.getColumnIndex("hotChatType");
            if (columnIndex20 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("hotChatType", Integer.TYPE));
            } else {
                hotChatInfo.hotChatType = cursor.getInt(columnIndex20);
            }
            int columnIndex21 = cursor.getColumnIndex("memo");
            if (columnIndex21 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("memo", String.class));
            } else {
                hotChatInfo.memo = cursor.getString(columnIndex21);
            }
            int columnIndex22 = cursor.getColumnIndex("memoUrl");
            if (columnIndex22 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("memoUrl", String.class));
            } else {
                hotChatInfo.memoUrl = cursor.getString(columnIndex22);
            }
            int columnIndex23 = cursor.getColumnIndex("memoShowed");
            if (columnIndex23 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("memoShowed", Boolean.TYPE));
            } else {
                if (1 == cursor.getShort(columnIndex23)) {
                    z27 = true;
                } else {
                    z27 = false;
                }
                hotChatInfo.memoShowed = z27;
            }
            int columnIndex24 = cursor.getColumnIndex("userCreate");
            if (columnIndex24 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("userCreate", Integer.TYPE));
            } else {
                hotChatInfo.userCreate = cursor.getInt(columnIndex24);
            }
            int columnIndex25 = cursor.getColumnIndex("strAdminUins");
            if (columnIndex25 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("strAdminUins", String.class));
            } else {
                hotChatInfo.strAdminUins = cursor.getString(columnIndex25);
            }
            int columnIndex26 = cursor.getColumnIndex("ownerUin");
            if (columnIndex26 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("ownerUin", String.class));
            } else {
                hotChatInfo.ownerUin = cursor.getString(columnIndex26);
            }
            int columnIndex27 = cursor.getColumnIndex("pkFlag");
            if (columnIndex27 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("pkFlag", Integer.TYPE));
            } else {
                hotChatInfo.pkFlag = cursor.getInt(columnIndex27);
            }
            int columnIndex28 = cursor.getColumnIndex(QCircleLpReportDc010001.KEY_SUBTYPE);
            if (columnIndex28 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError(QCircleLpReportDc010001.KEY_SUBTYPE, Integer.TYPE));
            } else {
                hotChatInfo.subType = cursor.getInt(columnIndex28);
            }
            int columnIndex29 = cursor.getColumnIndex("lLastMsgSeq");
            if (columnIndex29 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("lLastMsgSeq", Long.TYPE));
            } else {
                hotChatInfo.lLastMsgSeq = cursor.getLong(columnIndex29);
            }
            int columnIndex30 = cursor.getColumnIndex("extra1");
            if (columnIndex30 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("extra1", String.class));
            } else {
                hotChatInfo.extra1 = cursor.getString(columnIndex30);
            }
            int columnIndex31 = cursor.getColumnIndex("isFavorite");
            if (columnIndex31 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("isFavorite", Boolean.TYPE));
            } else {
                if (1 == cursor.getShort(columnIndex31)) {
                    z28 = true;
                } else {
                    z28 = false;
                }
                hotChatInfo.isFavorite = z28;
            }
            int columnIndex32 = cursor.getColumnIndex("mFissionRoomNum");
            if (columnIndex32 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("mFissionRoomNum", Integer.TYPE));
            } else {
                hotChatInfo.mFissionRoomNum = cursor.getInt(columnIndex32);
            }
            int columnIndex33 = cursor.getColumnIndex("praiseCount");
            if (columnIndex33 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("praiseCount", Long.TYPE));
            } else {
                hotChatInfo.praiseCount = cursor.getLong(columnIndex33);
            }
            int columnIndex34 = cursor.getColumnIndex("uint32_group_flag_ext2");
            if (columnIndex34 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("uint32_group_flag_ext2", Integer.TYPE));
            } else {
                hotChatInfo.uint32_group_flag_ext2 = cursor.getInt(columnIndex34);
            }
            int columnIndex35 = cursor.getColumnIndex("isGameRoom");
            if (columnIndex35 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("isGameRoom", Boolean.TYPE));
            } else {
                if (1 == cursor.getShort(columnIndex35)) {
                    z29 = true;
                } else {
                    z29 = false;
                }
                hotChatInfo.isGameRoom = z29;
            }
            int columnIndex36 = cursor.getColumnIndex("isRobotHotChat");
            if (columnIndex36 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("isRobotHotChat", Boolean.TYPE));
            } else {
                boolean z55 = true;
                if (1 != cursor.getShort(columnIndex36)) {
                    z55 = false;
                }
                hotChatInfo.isRobotHotChat = z55;
            }
            int columnIndex37 = cursor.getColumnIndex("robotUin");
            if (columnIndex37 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("robotUin", Long.TYPE));
            } else {
                hotChatInfo.robotUin = cursor.getLong(columnIndex37);
            }
            int columnIndex38 = cursor.getColumnIndex("apolloGameId");
            if (columnIndex38 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("apolloGameId", Integer.TYPE));
            } else {
                hotChatInfo.apolloGameId = cursor.getInt(columnIndex38);
            }
        }
        return hotChatInfo;
    }

    @Override // com.tencent.mobileqq.persistence.OGAbstractDao
    public void entity2ContentValues(Entity entity, ContentValues contentValues) {
        HotChatInfo hotChatInfo = (HotChatInfo) entity;
        contentValues.put("name", hotChatInfo.name);
        contentValues.put(IProfileProtocolConst.PARAM_TROOP_CODE, hotChatInfo.troopCode);
        contentValues.put("signature", hotChatInfo.signature);
        contentValues.put("troopUin", hotChatInfo.troopUin);
        contentValues.put("faceId", Integer.valueOf(hotChatInfo.faceId));
        contentValues.put("memberCount", Integer.valueOf(hotChatInfo.memberCount));
        contentValues.put("hasJoined", Boolean.valueOf(hotChatInfo.hasJoined));
        contentValues.put("isWifiHotChat", Boolean.valueOf(hotChatInfo.isWifiHotChat));
        contentValues.put("uuid", hotChatInfo.uuid);
        contentValues.put("iconUrl", hotChatInfo.iconUrl);
        contentValues.put("hotThemeGroupFlag", Integer.valueOf(hotChatInfo.hotThemeGroupFlag));
        contentValues.put("detail", hotChatInfo.detail);
        contentValues.put("state", Integer.valueOf(hotChatInfo.state));
        contentValues.put("leftTime", Long.valueOf(hotChatInfo.leftTime));
        contentValues.put("ruState", Integer.valueOf(hotChatInfo.ruState));
        contentValues.put("supportFlashPic", Boolean.valueOf(hotChatInfo.supportFlashPic));
        contentValues.put("supportDemo", Boolean.valueOf(hotChatInfo.supportDemo));
        contentValues.put("adminLevel", Integer.valueOf(hotChatInfo.adminLevel));
        contentValues.put("joinUrl", hotChatInfo.joinUrl);
        contentValues.put("hotChatType", Integer.valueOf(hotChatInfo.hotChatType));
        contentValues.put("memo", hotChatInfo.memo);
        contentValues.put("memoUrl", hotChatInfo.memoUrl);
        contentValues.put("memoShowed", Boolean.valueOf(hotChatInfo.memoShowed));
        contentValues.put("userCreate", Integer.valueOf(hotChatInfo.userCreate));
        contentValues.put("strAdminUins", hotChatInfo.strAdminUins);
        contentValues.put("ownerUin", hotChatInfo.ownerUin);
        contentValues.put("pkFlag", Integer.valueOf(hotChatInfo.pkFlag));
        contentValues.put(QCircleLpReportDc010001.KEY_SUBTYPE, Integer.valueOf(hotChatInfo.subType));
        contentValues.put("lLastMsgSeq", Long.valueOf(hotChatInfo.lLastMsgSeq));
        contentValues.put("extra1", hotChatInfo.extra1);
        contentValues.put("isFavorite", Boolean.valueOf(hotChatInfo.isFavorite));
        contentValues.put("mFissionRoomNum", Integer.valueOf(hotChatInfo.mFissionRoomNum));
        contentValues.put("praiseCount", Long.valueOf(hotChatInfo.praiseCount));
        contentValues.put("uint32_group_flag_ext2", Integer.valueOf(hotChatInfo.uint32_group_flag_ext2));
        contentValues.put("isGameRoom", Boolean.valueOf(hotChatInfo.isGameRoom));
        contentValues.put("isRobotHotChat", Boolean.valueOf(hotChatInfo.isRobotHotChat));
        contentValues.put("robotUin", Long.valueOf(hotChatInfo.robotUin));
        contentValues.put("apolloGameId", Integer.valueOf(hotChatInfo.apolloGameId));
    }

    @Override // com.tencent.mobileqq.persistence.OGAbstractDao
    public String getCreateTableSql(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT ,name TEXT ,troopCode TEXT ,signature TEXT ,troopUin TEXT UNIQUE ,faceId INTEGER ,memberCount INTEGER ,hasJoined INTEGER ,isWifiHotChat INTEGER ,uuid TEXT ,iconUrl TEXT ,hotThemeGroupFlag INTEGER ,detail TEXT ,state INTEGER ,leftTime INTEGER ,ruState INTEGER ,supportFlashPic INTEGER ,supportDemo INTEGER ,adminLevel INTEGER ,joinUrl TEXT ,hotChatType INTEGER ,memo TEXT ,memoUrl TEXT ,memoShowed INTEGER ,userCreate INTEGER ,strAdminUins TEXT ,ownerUin TEXT ,pkFlag INTEGER ,subType INTEGER ,lLastMsgSeq INTEGER ,extra1 TEXT ,isFavorite INTEGER ,mFissionRoomNum INTEGER ,praiseCount INTEGER ,uint32_group_flag_ext2 INTEGER ,isGameRoom INTEGER ,isRobotHotChat INTEGER ,robotUin INTEGER ,apolloGameId INTEGER)";
    }
}
