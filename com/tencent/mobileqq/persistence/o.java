package com.tencent.mobileqq.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;

/* compiled from: P */
/* loaded from: classes16.dex */
public class o extends OGAbstractDao {
    public o() {
        this.columnLen = 23;
    }

    @Override // com.tencent.mobileqq.persistence.OGAbstractDao
    public Entity cursor2Entity(Entity entity, Cursor cursor, boolean z16, NoColumnErrorHandler noColumnErrorHandler) {
        ResourcePluginInfo resourcePluginInfo = (ResourcePluginInfo) entity;
        if (noColumnErrorHandler == null) {
            resourcePluginInfo.strPkgName = cursor.getString(cursor.getColumnIndex("strPkgName"));
            resourcePluginInfo.strResName = cursor.getString(cursor.getColumnIndex("strResName"));
            resourcePluginInfo.strResURL = cursor.getString(cursor.getColumnIndex("strResURL"));
            resourcePluginInfo.uiCurVer = cursor.getLong(cursor.getColumnIndex("uiCurVer"));
            resourcePluginInfo.sLanType = cursor.getShort(cursor.getColumnIndex("sLanType"));
            resourcePluginInfo.strGotoUrl = cursor.getString(cursor.getColumnIndex("strGotoUrl"));
            resourcePluginInfo.sResSubType = cursor.getShort(cursor.getColumnIndex("sResSubType"));
            resourcePluginInfo.sPriority = cursor.getShort(cursor.getColumnIndex("sPriority"));
            resourcePluginInfo.strResDesc = cursor.getString(cursor.getColumnIndex("strResDesc"));
            resourcePluginInfo.uiResId = cursor.getLong(cursor.getColumnIndex("uiResId"));
            resourcePluginInfo.cDefaultState = (byte) cursor.getShort(cursor.getColumnIndex("cDefaultState"));
            resourcePluginInfo.cCanChangeState = (byte) cursor.getShort(cursor.getColumnIndex("cCanChangeState"));
            resourcePluginInfo.isNew = (byte) cursor.getShort(cursor.getColumnIndex("isNew"));
            resourcePluginInfo.cDataType = (byte) cursor.getShort(cursor.getColumnIndex("cDataType"));
            resourcePluginInfo.cLocalState = (byte) cursor.getShort(cursor.getColumnIndex("cLocalState"));
            resourcePluginInfo.iPluginType = cursor.getInt(cursor.getColumnIndex("iPluginType"));
            resourcePluginInfo.timeStamp = cursor.getLong(cursor.getColumnIndex(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY));
            resourcePluginInfo.strNewPluginDesc = cursor.getString(cursor.getColumnIndex("strNewPluginDesc"));
            resourcePluginInfo.strNewPluginURL = cursor.getString(cursor.getColumnIndex("strNewPluginURL"));
            resourcePluginInfo.lebaSearchResultType = cursor.getInt(cursor.getColumnIndex("lebaSearchResultType"));
            resourcePluginInfo.pluginSetTips = cursor.getString(cursor.getColumnIndex("pluginSetTips"));
            resourcePluginInfo.pluginBg = cursor.getString(cursor.getColumnIndex("pluginBg"));
            resourcePluginInfo.flags = cursor.getInt(cursor.getColumnIndex(WadlProxyConsts.FLAGS));
        } else {
            int columnIndex = cursor.getColumnIndex("strPkgName");
            if (columnIndex == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("strPkgName", String.class));
            } else {
                resourcePluginInfo.strPkgName = cursor.getString(columnIndex);
            }
            int columnIndex2 = cursor.getColumnIndex("strResName");
            if (columnIndex2 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("strResName", String.class));
            } else {
                resourcePluginInfo.strResName = cursor.getString(columnIndex2);
            }
            int columnIndex3 = cursor.getColumnIndex("strResURL");
            if (columnIndex3 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("strResURL", String.class));
            } else {
                resourcePluginInfo.strResURL = cursor.getString(columnIndex3);
            }
            int columnIndex4 = cursor.getColumnIndex("uiCurVer");
            if (columnIndex4 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("uiCurVer", Long.TYPE));
            } else {
                resourcePluginInfo.uiCurVer = cursor.getLong(columnIndex4);
            }
            int columnIndex5 = cursor.getColumnIndex("sLanType");
            if (columnIndex5 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("sLanType", Short.TYPE));
            } else {
                resourcePluginInfo.sLanType = cursor.getShort(columnIndex5);
            }
            int columnIndex6 = cursor.getColumnIndex("strGotoUrl");
            if (columnIndex6 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("strGotoUrl", String.class));
            } else {
                resourcePluginInfo.strGotoUrl = cursor.getString(columnIndex6);
            }
            int columnIndex7 = cursor.getColumnIndex("sResSubType");
            if (columnIndex7 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("sResSubType", Short.TYPE));
            } else {
                resourcePluginInfo.sResSubType = cursor.getShort(columnIndex7);
            }
            int columnIndex8 = cursor.getColumnIndex("sPriority");
            if (columnIndex8 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("sPriority", Short.TYPE));
            } else {
                resourcePluginInfo.sPriority = cursor.getShort(columnIndex8);
            }
            int columnIndex9 = cursor.getColumnIndex("strResDesc");
            if (columnIndex9 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("strResDesc", String.class));
            } else {
                resourcePluginInfo.strResDesc = cursor.getString(columnIndex9);
            }
            int columnIndex10 = cursor.getColumnIndex("uiResId");
            if (columnIndex10 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("uiResId", Long.TYPE));
            } else {
                resourcePluginInfo.uiResId = cursor.getLong(columnIndex10);
            }
            int columnIndex11 = cursor.getColumnIndex("cDefaultState");
            if (columnIndex11 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("cDefaultState", Byte.TYPE));
            } else {
                resourcePluginInfo.cDefaultState = (byte) cursor.getShort(columnIndex11);
            }
            int columnIndex12 = cursor.getColumnIndex("cCanChangeState");
            if (columnIndex12 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("cCanChangeState", Byte.TYPE));
            } else {
                resourcePluginInfo.cCanChangeState = (byte) cursor.getShort(columnIndex12);
            }
            int columnIndex13 = cursor.getColumnIndex("isNew");
            if (columnIndex13 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("isNew", Byte.TYPE));
            } else {
                resourcePluginInfo.isNew = (byte) cursor.getShort(columnIndex13);
            }
            int columnIndex14 = cursor.getColumnIndex("cDataType");
            if (columnIndex14 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("cDataType", Byte.TYPE));
            } else {
                resourcePluginInfo.cDataType = (byte) cursor.getShort(columnIndex14);
            }
            int columnIndex15 = cursor.getColumnIndex("cLocalState");
            if (columnIndex15 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("cLocalState", Byte.TYPE));
            } else {
                resourcePluginInfo.cLocalState = (byte) cursor.getShort(columnIndex15);
            }
            int columnIndex16 = cursor.getColumnIndex("iPluginType");
            if (columnIndex16 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("iPluginType", Integer.TYPE));
            } else {
                resourcePluginInfo.iPluginType = cursor.getInt(columnIndex16);
            }
            int columnIndex17 = cursor.getColumnIndex(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY);
            if (columnIndex17 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, Long.TYPE));
            } else {
                resourcePluginInfo.timeStamp = cursor.getLong(columnIndex17);
            }
            int columnIndex18 = cursor.getColumnIndex("strNewPluginDesc");
            if (columnIndex18 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("strNewPluginDesc", String.class));
            } else {
                resourcePluginInfo.strNewPluginDesc = cursor.getString(columnIndex18);
            }
            int columnIndex19 = cursor.getColumnIndex("strNewPluginURL");
            if (columnIndex19 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("strNewPluginURL", String.class));
            } else {
                resourcePluginInfo.strNewPluginURL = cursor.getString(columnIndex19);
            }
            int columnIndex20 = cursor.getColumnIndex("lebaSearchResultType");
            if (columnIndex20 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("lebaSearchResultType", Integer.TYPE));
            } else {
                resourcePluginInfo.lebaSearchResultType = cursor.getInt(columnIndex20);
            }
            int columnIndex21 = cursor.getColumnIndex("pluginSetTips");
            if (columnIndex21 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("pluginSetTips", String.class));
            } else {
                resourcePluginInfo.pluginSetTips = cursor.getString(columnIndex21);
            }
            int columnIndex22 = cursor.getColumnIndex("pluginBg");
            if (columnIndex22 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError("pluginBg", String.class));
            } else {
                resourcePluginInfo.pluginBg = cursor.getString(columnIndex22);
            }
            int columnIndex23 = cursor.getColumnIndex(WadlProxyConsts.FLAGS);
            if (columnIndex23 == -1) {
                noColumnErrorHandler.handleNoColumnError(new NoColumnError(WadlProxyConsts.FLAGS, Integer.TYPE));
            } else {
                resourcePluginInfo.flags = cursor.getInt(columnIndex23);
            }
        }
        return resourcePluginInfo;
    }

    @Override // com.tencent.mobileqq.persistence.OGAbstractDao
    public void entity2ContentValues(Entity entity, ContentValues contentValues) {
        ResourcePluginInfo resourcePluginInfo = (ResourcePluginInfo) entity;
        contentValues.put("strPkgName", resourcePluginInfo.strPkgName);
        contentValues.put("strResName", resourcePluginInfo.strResName);
        contentValues.put("strResURL", resourcePluginInfo.strResURL);
        contentValues.put("uiCurVer", Long.valueOf(resourcePluginInfo.uiCurVer));
        contentValues.put("sLanType", Short.valueOf(resourcePluginInfo.sLanType));
        contentValues.put("strGotoUrl", resourcePluginInfo.strGotoUrl);
        contentValues.put("sResSubType", Short.valueOf(resourcePluginInfo.sResSubType));
        contentValues.put("sPriority", Short.valueOf(resourcePluginInfo.sPriority));
        contentValues.put("strResDesc", resourcePluginInfo.strResDesc);
        contentValues.put("uiResId", Long.valueOf(resourcePluginInfo.uiResId));
        contentValues.put("cDefaultState", Byte.valueOf(resourcePluginInfo.cDefaultState));
        contentValues.put("cCanChangeState", Byte.valueOf(resourcePluginInfo.cCanChangeState));
        contentValues.put("isNew", Byte.valueOf(resourcePluginInfo.isNew));
        contentValues.put("cDataType", Byte.valueOf(resourcePluginInfo.cDataType));
        contentValues.put("cLocalState", Byte.valueOf(resourcePluginInfo.cLocalState));
        contentValues.put("iPluginType", Integer.valueOf(resourcePluginInfo.iPluginType));
        contentValues.put(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY, Long.valueOf(resourcePluginInfo.timeStamp));
        contentValues.put("strNewPluginDesc", resourcePluginInfo.strNewPluginDesc);
        contentValues.put("strNewPluginURL", resourcePluginInfo.strNewPluginURL);
        contentValues.put("lebaSearchResultType", Integer.valueOf(resourcePluginInfo.lebaSearchResultType));
        contentValues.put("pluginSetTips", resourcePluginInfo.pluginSetTips);
        contentValues.put("pluginBg", resourcePluginInfo.pluginBg);
        contentValues.put(WadlProxyConsts.FLAGS, Integer.valueOf(resourcePluginInfo.flags));
    }

    @Override // com.tencent.mobileqq.persistence.OGAbstractDao
    public String getCreateTableSql(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (_id INTEGER PRIMARY KEY AUTOINCREMENT ,strPkgName TEXT UNIQUE ,strResName TEXT ,strResURL TEXT ,uiCurVer INTEGER ,sLanType INTEGER ,strGotoUrl TEXT ,sResSubType INTEGER ,sPriority INTEGER ,strResDesc TEXT ,uiResId INTEGER ,cDefaultState INTEGER ,cCanChangeState INTEGER ,isNew INTEGER ,cDataType INTEGER ,cLocalState INTEGER ,iPluginType INTEGER ,timeStamp INTEGER ,strNewPluginDesc TEXT ,strNewPluginURL TEXT ,lebaSearchResultType INTEGER ,pluginSetTips TEXT ,pluginBg TEXT ,flags INTEGER)";
    }
}
