package com.tencent.mobileqq.guild.robot.api.impl;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.collection.LruCache;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.robot.api.IGuildRobotApi;
import com.tencent.mobileqq.guild.robot.api.IGuildRobotConfigApi;
import com.tencent.mobileqq.guild.robot.api.IGuildRobotUtilApi;
import com.tencent.mobileqq.guild.robot.scheme.impl.GuildEnterCmdSchemeAction;
import com.tencent.mobileqq.guild.robot.scheme.impl.GuildParameterCmdSchemeAction;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.cl;
import com.tencent.qphone.base.util.QLog;
import hx1.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildRobotApiImpl implements IGuildRobotApi {
    private static final String TAG = "GuildRobotApi";

    @Override // com.tencent.mobileqq.guild.robot.api.IGuildRobotApi
    @NonNull
    public Object createEnterCmdSchemeAction() {
        return new GuildEnterCmdSchemeAction();
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IGuildRobotApi
    @NonNull
    public Object createParameterCmdSchemeAction() {
        return new GuildParameterCmdSchemeAction();
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IGuildRobotApi
    public String getGuildDirectMsgTypeKey() {
        return AppConstants.Key.GUILD_DIRECT_MESSAGE_TYPE;
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IGuildRobotApi
    public String getLastAtUin(EditText editText) {
        return b.b(editText);
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IGuildRobotApi
    public void openRobotSlashPanelFromBtn(EditText editText) {
        b.g(editText);
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IGuildRobotApi
    public void startH5Service(Context context, String str) {
        b.j(context, str);
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IGuildRobotApi
    public void startMiniAppService(Context context, String str) {
        b.k(context, str);
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IGuildRobotApi
    public void updateFuncSort(Context context, String str, String str2) {
        LruCache lruCache = new LruCache(1);
        String d16 = cl.d(context, nx1.a.a(str2));
        LruCache lruCache2 = new LruCache(3);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "guildLruData = " + d16);
        }
        if (!TextUtils.isEmpty(d16)) {
            LinkedHashMap linkedHashMap = (LinkedHashMap) ((IGuildRobotUtilApi) QRoute.api(IGuildRobotUtilApi.class)).toObject(d16, LinkedHashMap.class);
            ArrayList arrayList = new ArrayList(linkedHashMap.keySet().size());
            for (String str3 : linkedHashMap.keySet()) {
                if (TextUtils.isEmpty(str3)) {
                    return;
                } else {
                    arrayList.add(str3);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str4 = (String) it.next();
                lruCache.put(str4, (String) linkedHashMap.get(str4));
            }
            String str5 = (String) linkedHashMap.get(str2);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "funcLruStr = " + str5);
            }
            if (!TextUtils.isEmpty(str5)) {
                Iterator it5 = ((ArrayList) ((IGuildRobotUtilApi) QRoute.api(IGuildRobotUtilApi.class)).toObject(str5, ArrayList.class)).iterator();
                while (it5.hasNext()) {
                    lruCache2.put((String) it5.next(), "");
                }
            }
        }
        if (lruCache2.get(str) == null) {
            lruCache2.put(str, "");
        }
        lruCache.put(str2, ((IGuildRobotUtilApi) QRoute.api(IGuildRobotUtilApi.class)).toJson(lruCache2.snapshot().keySet()));
        cl.j(context, nx1.a.a(str2), ((IGuildRobotUtilApi) QRoute.api(IGuildRobotUtilApi.class)).toJson(lruCache.snapshot()));
    }

    @Override // com.tencent.mobileqq.guild.robot.api.IGuildRobotApi
    public void updateRobotSort(Context context, String str, String str2) {
        LruCache lruCache = new LruCache(Math.min(50, ((IGuildRobotConfigApi) QRoute.api(IGuildRobotConfigApi.class)).getRobotCmdSortGuildLimit(3)));
        String d16 = cl.d(context, "ROBOT_SORT_KEY");
        LruCache lruCache2 = new LruCache(Math.min(((IGuildRobotConfigApi) QRoute.api(IGuildRobotConfigApi.class)).getRobotCmdSortRobotLimit(3), 50));
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "guildLruData = " + d16);
        }
        if (!TextUtils.isEmpty(d16)) {
            LinkedHashMap linkedHashMap = (LinkedHashMap) ((IGuildRobotUtilApi) QRoute.api(IGuildRobotUtilApi.class)).toObject(d16, LinkedHashMap.class);
            ArrayList arrayList = new ArrayList(linkedHashMap.keySet().size());
            for (String str3 : linkedHashMap.keySet()) {
                if (TextUtils.isEmpty(str3)) {
                    return;
                } else {
                    arrayList.add(str3);
                }
            }
            Collections.reverse(arrayList);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str4 = (String) it.next();
                lruCache.put(str4, (String) linkedHashMap.get(str4));
            }
            String str5 = (String) linkedHashMap.get(str2);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "robotLruData = " + str5);
            }
            if (!TextUtils.isEmpty(str5)) {
                Iterator it5 = ((HashSet) ((IGuildRobotUtilApi) QRoute.api(IGuildRobotUtilApi.class)).toObject(str5, HashSet.class)).iterator();
                while (it5.hasNext()) {
                    lruCache2.put((String) it5.next(), "");
                }
            }
        }
        if (lruCache2.get(str) == null) {
            lruCache2.put(str, "");
        }
        lruCache.put(str2, ((IGuildRobotUtilApi) QRoute.api(IGuildRobotUtilApi.class)).toJson(lruCache2.snapshot().keySet()));
        cl.j(context, "ROBOT_SORT_KEY", ((IGuildRobotUtilApi) QRoute.api(IGuildRobotUtilApi.class)).toJson(lruCache.snapshot()));
    }
}
