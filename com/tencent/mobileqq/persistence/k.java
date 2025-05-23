package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.mobileqq.data.PublicAccountInfo;

/* compiled from: P */
/* loaded from: classes16.dex */
public class k extends OGAbstractDao {
    public k() {
        this.columnLen = 25;
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
        PublicAccountInfo publicAccountInfo = (PublicAccountInfo) entity;
        if (noColumnErrorHandler == null) {
            publicAccountInfo.uin = cursor.getLong(cursor.getColumnIndex("uin"));
            publicAccountInfo.uid = cursor.getString(cursor.getColumnIndex("uid"));
            publicAccountInfo.name = cursor.getString(cursor.getColumnIndex("name"));
            publicAccountInfo.displayNumber = cursor.getString(cursor.getColumnIndex("displayNumber"));
            publicAccountInfo.summary = cursor.getString(cursor.getColumnIndex("summary"));
            if (1 == cursor.getShort(cursor.getColumnIndex("isRecvMsg"))) {
                z28 = true;
            } else {
                z28 = false;
            }
            publicAccountInfo.isRecvMsg = z28;
            if (1 == cursor.getShort(cursor.getColumnIndex("isRecvPush"))) {
                z29 = true;
            } else {
                z29 = false;
            }
            publicAccountInfo.isRecvPush = z29;
            publicAccountInfo.clickCount = cursor.getInt(cursor.getColumnIndex("clickCount"));
            publicAccountInfo.certifiedGrade = cursor.getLong(cursor.getColumnIndex("certifiedGrade"));
            if (1 == cursor.getShort(cursor.getColumnIndex("isSyncLbs"))) {
                z36 = true;
            } else {
                z36 = false;
            }
            publicAccountInfo.isSyncLbs = z36;
            publicAccountInfo.showFlag = cursor.getInt(cursor.getColumnIndex("showFlag"));
            publicAccountInfo.mShowMsgFlag = cursor.getInt(cursor.getColumnIndex("mShowMsgFlag"));
            if (1 == cursor.getShort(cursor.getColumnIndex("mIsAgreeSyncLbs"))) {
                z37 = true;
            } else {
                z37 = false;
            }
            publicAccountInfo.mIsAgreeSyncLbs = z37;
            if (1 == cursor.getShort(cursor.getColumnIndex("mIsSyncLbsSelected"))) {
                z38 = true;
            } else {
                z38 = false;
            }
            publicAccountInfo.mIsSyncLbsSelected = z38;
            publicAccountInfo.dateTime = cursor.getLong(cursor.getColumnIndex("dateTime"));
            publicAccountInfo.accountFlag = cursor.getInt(cursor.getColumnIndex(CommonConstant.KEY_ACCOUNT_FLAG));
            publicAccountInfo.accountFlag2 = cursor.getLong(cursor.getColumnIndex("accountFlag2"));
            publicAccountInfo.eqqAccountFlag = cursor.getLong(cursor.getColumnIndex("eqqAccountFlag"));
            if (1 == cursor.getShort(cursor.getColumnIndex("isShieldMsg"))) {
                z39 = true;
            } else {
                z39 = false;
            }
            publicAccountInfo.isShieldMsg = z39;
            publicAccountInfo.messageSettingFlag = cursor.getInt(cursor.getColumnIndex("messageSettingFlag"));
            publicAccountInfo.extendType = cursor.getInt(cursor.getColumnIndex("extendType"));
            publicAccountInfo.mComparePartInt = cursor.getInt(cursor.getColumnIndex("mComparePartInt"));
            publicAccountInfo.mCompareSpell = cursor.getString(cursor.getColumnIndex("mCompareSpell"));
            publicAccountInfo.logo = cursor.getString(cursor.getColumnIndex("logo"));
            publicAccountInfo.lastAIOReadTime = cursor.getLong(cursor.getColumnIndex("lastAIOReadTime"));
        } else {
            int columnIndex = cursor.getColumnIndex("uin");
            if (columnIndex == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("uin", Long.TYPE));
            } else {
                publicAccountInfo.uin = cursor.getLong(columnIndex);
            }
            int columnIndex2 = cursor.getColumnIndex("uid");
            if (columnIndex2 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("uid", String.class));
            } else {
                publicAccountInfo.uid = cursor.getString(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex("name");
            if (columnIndex3 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("name", String.class));
            } else {
                publicAccountInfo.name = cursor.getString(columnIndex3);
            }
            int columnIndex4 = cursor.getColumnIndex("displayNumber");
            if (columnIndex4 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("displayNumber", String.class));
            } else {
                publicAccountInfo.displayNumber = cursor.getString(columnIndex4);
            }
            int columnIndex5 = cursor.getColumnIndex("summary");
            if (columnIndex5 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("summary", String.class));
            } else {
                publicAccountInfo.summary = cursor.getString(columnIndex5);
            }
            int columnIndex6 = cursor.getColumnIndex("isRecvMsg");
            if (columnIndex6 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("isRecvMsg", Boolean.TYPE));
            } else {
                if (1 == cursor.getShort(columnIndex6)) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                publicAccountInfo.isRecvMsg = z17;
            }
            int columnIndex7 = cursor.getColumnIndex("isRecvPush");
            if (columnIndex7 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("isRecvPush", Boolean.TYPE));
            } else {
                if (1 == cursor.getShort(columnIndex7)) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                publicAccountInfo.isRecvPush = z18;
            }
            int columnIndex8 = cursor.getColumnIndex("clickCount");
            if (columnIndex8 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("clickCount", Integer.TYPE));
            } else {
                publicAccountInfo.clickCount = cursor.getInt(columnIndex8);
            }
            int columnIndex9 = cursor.getColumnIndex("certifiedGrade");
            if (columnIndex9 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("certifiedGrade", Long.TYPE));
            } else {
                publicAccountInfo.certifiedGrade = cursor.getLong(columnIndex9);
            }
            int columnIndex10 = cursor.getColumnIndex("isSyncLbs");
            if (columnIndex10 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("isSyncLbs", Boolean.TYPE));
            } else {
                if (1 == cursor.getShort(columnIndex10)) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                publicAccountInfo.isSyncLbs = z19;
            }
            int columnIndex11 = cursor.getColumnIndex("showFlag");
            if (columnIndex11 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("showFlag", Integer.TYPE));
            } else {
                publicAccountInfo.showFlag = cursor.getInt(columnIndex11);
            }
            int columnIndex12 = cursor.getColumnIndex("mShowMsgFlag");
            if (columnIndex12 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("mShowMsgFlag", Integer.TYPE));
            } else {
                publicAccountInfo.mShowMsgFlag = cursor.getInt(columnIndex12);
            }
            int columnIndex13 = cursor.getColumnIndex("mIsAgreeSyncLbs");
            if (columnIndex13 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("mIsAgreeSyncLbs", Boolean.TYPE));
            } else {
                if (1 == cursor.getShort(columnIndex13)) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                publicAccountInfo.mIsAgreeSyncLbs = z26;
            }
            int columnIndex14 = cursor.getColumnIndex("mIsSyncLbsSelected");
            if (columnIndex14 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("mIsSyncLbsSelected", Boolean.TYPE));
            } else {
                if (1 == cursor.getShort(columnIndex14)) {
                    z27 = true;
                } else {
                    z27 = false;
                }
                publicAccountInfo.mIsSyncLbsSelected = z27;
            }
            int columnIndex15 = cursor.getColumnIndex("dateTime");
            if (columnIndex15 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("dateTime", Long.TYPE));
            } else {
                publicAccountInfo.dateTime = cursor.getLong(columnIndex15);
            }
            int columnIndex16 = cursor.getColumnIndex(CommonConstant.KEY_ACCOUNT_FLAG);
            if (columnIndex16 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError(CommonConstant.KEY_ACCOUNT_FLAG, Integer.TYPE));
            } else {
                publicAccountInfo.accountFlag = cursor.getInt(columnIndex16);
            }
            int columnIndex17 = cursor.getColumnIndex("accountFlag2");
            if (columnIndex17 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("accountFlag2", Long.TYPE));
            } else {
                publicAccountInfo.accountFlag2 = cursor.getLong(columnIndex17);
            }
            int columnIndex18 = cursor.getColumnIndex("eqqAccountFlag");
            if (columnIndex18 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("eqqAccountFlag", Long.TYPE));
            } else {
                publicAccountInfo.eqqAccountFlag = cursor.getLong(columnIndex18);
            }
            int columnIndex19 = cursor.getColumnIndex("isShieldMsg");
            if (columnIndex19 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("isShieldMsg", Boolean.TYPE));
            } else {
                boolean z46 = true;
                if (1 != cursor.getShort(columnIndex19)) {
                    z46 = false;
                }
                publicAccountInfo.isShieldMsg = z46;
            }
            int columnIndex20 = cursor.getColumnIndex("messageSettingFlag");
            if (columnIndex20 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("messageSettingFlag", Integer.TYPE));
            } else {
                publicAccountInfo.messageSettingFlag = cursor.getInt(columnIndex20);
            }
            int columnIndex21 = cursor.getColumnIndex("extendType");
            if (columnIndex21 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("extendType", Integer.TYPE));
            } else {
                publicAccountInfo.extendType = cursor.getInt(columnIndex21);
            }
            int columnIndex22 = cursor.getColumnIndex("mComparePartInt");
            if (columnIndex22 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("mComparePartInt", Integer.TYPE));
            } else {
                publicAccountInfo.mComparePartInt = cursor.getInt(columnIndex22);
            }
            int columnIndex23 = cursor.getColumnIndex("mCompareSpell");
            if (columnIndex23 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("mCompareSpell", String.class));
            } else {
                publicAccountInfo.mCompareSpell = cursor.getString(columnIndex23);
            }
            int columnIndex24 = cursor.getColumnIndex("logo");
            if (columnIndex24 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("logo", String.class));
            } else {
                publicAccountInfo.logo = cursor.getString(columnIndex24);
            }
            int columnIndex25 = cursor.getColumnIndex("lastAIOReadTime");
            if (columnIndex25 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("lastAIOReadTime", Long.TYPE));
            } else {
                publicAccountInfo.lastAIOReadTime = cursor.getLong(columnIndex25);
            }
        }
        return publicAccountInfo;
    }

    @Override // com.tencent.mobileqq.persistence.OGAbstractDao
    public void entity2ContentValues(Entity entity, ContentValues contentValues) {
        PublicAccountInfo publicAccountInfo = (PublicAccountInfo) entity;
        contentValues.put("uin", Long.valueOf(publicAccountInfo.uin));
        contentValues.put("uid", publicAccountInfo.uid);
        contentValues.put("name", publicAccountInfo.name);
        contentValues.put("displayNumber", publicAccountInfo.displayNumber);
        contentValues.put("summary", publicAccountInfo.summary);
        contentValues.put("isRecvMsg", Boolean.valueOf(publicAccountInfo.isRecvMsg));
        contentValues.put("isRecvPush", Boolean.valueOf(publicAccountInfo.isRecvPush));
        contentValues.put("clickCount", Integer.valueOf(publicAccountInfo.clickCount));
        contentValues.put("certifiedGrade", Long.valueOf(publicAccountInfo.certifiedGrade));
        contentValues.put("isSyncLbs", Boolean.valueOf(publicAccountInfo.isSyncLbs));
        contentValues.put("showFlag", Integer.valueOf(publicAccountInfo.showFlag));
        contentValues.put("mShowMsgFlag", Integer.valueOf(publicAccountInfo.mShowMsgFlag));
        contentValues.put("mIsAgreeSyncLbs", Boolean.valueOf(publicAccountInfo.mIsAgreeSyncLbs));
        contentValues.put("mIsSyncLbsSelected", Boolean.valueOf(publicAccountInfo.mIsSyncLbsSelected));
        contentValues.put("dateTime", Long.valueOf(publicAccountInfo.dateTime));
        contentValues.put(CommonConstant.KEY_ACCOUNT_FLAG, Integer.valueOf(publicAccountInfo.accountFlag));
        contentValues.put("accountFlag2", Long.valueOf(publicAccountInfo.accountFlag2));
        contentValues.put("eqqAccountFlag", Long.valueOf(publicAccountInfo.eqqAccountFlag));
        contentValues.put("isShieldMsg", Boolean.valueOf(publicAccountInfo.isShieldMsg));
        contentValues.put("messageSettingFlag", Integer.valueOf(publicAccountInfo.messageSettingFlag));
        contentValues.put("extendType", Integer.valueOf(publicAccountInfo.extendType));
        contentValues.put("mComparePartInt", Integer.valueOf(publicAccountInfo.mComparePartInt));
        contentValues.put("mCompareSpell", publicAccountInfo.mCompareSpell);
        contentValues.put("logo", publicAccountInfo.logo);
        contentValues.put("lastAIOReadTime", Long.valueOf(publicAccountInfo.lastAIOReadTime));
    }

    @Override // com.tencent.mobileqq.persistence.OGAbstractDao
    public String getCreateTableSql(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT ,uin INTEGER UNIQUE ,uid TEXT ,name TEXT ,displayNumber TEXT ,summary TEXT ,isRecvMsg INTEGER ,isRecvPush INTEGER ,clickCount INTEGER ,certifiedGrade INTEGER ,isSyncLbs INTEGER ,showFlag INTEGER ,mShowMsgFlag INTEGER ,mIsAgreeSyncLbs INTEGER ,mIsSyncLbsSelected INTEGER ,dateTime INTEGER ,accountFlag INTEGER ,accountFlag2 INTEGER ,eqqAccountFlag INTEGER ,isShieldMsg INTEGER ,messageSettingFlag INTEGER ,extendType INTEGER ,mComparePartInt INTEGER ,mCompareSpell TEXT ,logo TEXT ,lastAIOReadTime INTEGER)";
    }
}
