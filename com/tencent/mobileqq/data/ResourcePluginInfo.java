package com.tencent.mobileqq.data;

import com.tencent.mobileqq.perf.block.DBMethodProxy;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import java.util.List;

/* loaded from: classes10.dex */
public class ResourcePluginInfo extends Entity {

    @notColumn
    public static final int MASK_FULL_CONFIG = 1;
    public static final int PLUGIN_TYPE_ABOUT = 32;
    public static final int PLUGIN_TYPE_LEBA = 64;
    public static final int PLUGIN_TYPE_NETWORK_PLUGIN = 128;
    public byte cCanChangeState;
    public byte cDataType;
    public byte cDefaultState;
    public byte cLocalState;
    public int flags;
    public int iPluginType = 64;
    public byte isNew;
    public int lebaSearchResultType;
    public String pluginBg;
    public String pluginSetTips;
    public short sLanType;
    public short sPriority;
    public short sResSubType;
    public String strGotoUrl;
    public String strNewPluginDesc;
    public String strNewPluginURL;

    @unique
    public String strPkgName;
    public String strResDesc;
    public String strResName;
    public String strResURL;
    public long timeStamp;
    public long uiCurVer;
    public long uiResId;

    public static ResourcePluginInfo find(EntityManager entityManager, String str) {
        if (entityManager != null && str != null) {
            return (ResourcePluginInfo) DBMethodProxy.find(entityManager, ResourcePluginInfo.class, "strPkgName=?", new String[]{str});
        }
        return null;
    }

    public static List<ResourcePluginInfo> getAll(EntityManager entityManager, int i3, boolean z16) {
        if (entityManager != null) {
            if (z16) {
                return entityManager.query(ResourcePluginInfo.class, false, "iPluginType=?", new String[]{String.valueOf(i3)}, null, null, "cLocalState desc", null);
            }
            return entityManager.query(ResourcePluginInfo.class, false, "iPluginType=?", new String[]{String.valueOf(i3)}, null, null, null, null);
        }
        return null;
    }

    public static void persistOrReplace(EntityManager entityManager, ResourcePluginInfo resourcePluginInfo) {
        String str;
        if (entityManager != null && resourcePluginInfo != null && (str = resourcePluginInfo.strPkgName) != null && !str.equals("")) {
            ResourcePluginInfo resourcePluginInfo2 = (ResourcePluginInfo) DBMethodProxy.find(entityManager, ResourcePluginInfo.class, "strPkgName=?", new String[]{resourcePluginInfo.strPkgName});
            if (resourcePluginInfo2 != null) {
                resourcePluginInfo2.strResName = resourcePluginInfo.strResName;
                resourcePluginInfo2.strResURL = resourcePluginInfo.strResURL;
                resourcePluginInfo2.uiCurVer = resourcePluginInfo.uiCurVer;
                resourcePluginInfo2.sLanType = resourcePluginInfo.sLanType;
                resourcePluginInfo2.sResSubType = resourcePluginInfo.sResSubType;
                resourcePluginInfo2.strGotoUrl = resourcePluginInfo.strGotoUrl;
                resourcePluginInfo2.sPriority = resourcePluginInfo.sPriority;
                resourcePluginInfo2.strResDesc = resourcePluginInfo.strResDesc;
                resourcePluginInfo2.cCanChangeState = resourcePluginInfo.cCanChangeState;
                byte b16 = resourcePluginInfo.cDefaultState;
                resourcePluginInfo2.cDefaultState = b16;
                if (resourcePluginInfo.cDefaultState != b16) {
                    resourcePluginInfo2.cLocalState = resourcePluginInfo.cLocalState;
                }
                resourcePluginInfo2.isNew = resourcePluginInfo.isNew;
                resourcePluginInfo2.uiResId = resourcePluginInfo.uiResId;
                resourcePluginInfo2.iPluginType = resourcePluginInfo.iPluginType;
                resourcePluginInfo2.strNewPluginDesc = resourcePluginInfo.strNewPluginDesc;
                resourcePluginInfo2.strNewPluginURL = resourcePluginInfo.strNewPluginURL;
                resourcePluginInfo2.pluginSetTips = resourcePluginInfo.pluginSetTips;
                resourcePluginInfo2.lebaSearchResultType = resourcePluginInfo.lebaSearchResultType;
                resourcePluginInfo2.flags = resourcePluginInfo.flags;
                entityManager.update(resourcePluginInfo2);
                return;
            }
            entityManager.persist(resourcePluginInfo);
        }
    }

    public static void remove(EntityManager entityManager, String str) {
        ResourcePluginInfo find;
        if (entityManager != null && str != null && (find = find(entityManager, str)) != null) {
            entityManager.remove(find);
        }
    }

    public void disableFlag(int i3) {
        this.flags = (~i3) & this.flags;
    }

    public void enableFlag(int i3) {
        this.flags = i3 | this.flags;
    }

    public boolean isAllowFlag(int i3) {
        if ((this.flags & i3) == i3) {
            return true;
        }
        return false;
    }

    public String toString() {
        return this.strPkgName + "|" + this.strResName + "|" + this.strResURL + "|" + this.uiCurVer + "|" + ((int) this.sLanType) + "|" + this.strGotoUrl + "|" + ((int) this.sResSubType) + "|" + ((int) this.sPriority) + "|" + this.strResDesc + "|" + ((int) this.cDefaultState) + "|" + ((int) this.cCanChangeState) + "|" + this.uiResId + "|" + ((int) this.cLocalState) + "|" + this.flags + "|" + ((int) this.isNew);
    }
}
