package com.qzone.module.feedcomponent.manage;

import android.graphics.Color;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class SecretTemplateManager {
    public static final int COLOR_TEMPLATE_TYPE = 0;
    public static final int OP_BLACK = 0;
    public static final int OP_WHITE = 1;
    public static final int PICTURE_TEMPLATE_TYPE = 2;
    public static final int TEXTURE_TEMPLATE_TYPE = 1;
    private static SecretTemplateManager instance;
    public List<SecretTemplateItemData> listData = new ArrayList();
    private HashMap<String, SecretTemplateItemData> dataMap = new HashMap<>();
    private SecretTemplateItemData defaultTemplateData = new SecretTemplateItemData("1", Color.parseColor("#333333"), Color.parseColor(TipsElementData.DEFAULT_COLOR), Color.parseColor("#b2b2b2"), 0, 0, "\u4eae\u767d\u8272");

    public static SecretTemplateManager getInstance() {
        if (instance == null) {
            SecretTemplateManager secretTemplateManager = new SecretTemplateManager();
            instance = secretTemplateManager;
            secretTemplateManager.initData();
        }
        return instance;
    }

    public SecretTemplateItemData getSecretTemplateById(String str) {
        SecretTemplateItemData secretTemplateItemData = this.dataMap.get(str);
        return secretTemplateItemData == null ? this.defaultTemplateData : secretTemplateItemData;
    }

    public List<SecretTemplateItemData> getSecretTemplates() {
        List<SecretTemplateItemData> list = this.listData;
        if (list == null || list.size() == 0) {
            initData();
        }
        return this.listData;
    }

    private void initData() {
        this.defaultTemplateData.feedTitleColor = Color.parseColor("#4c4c4c");
        this.listData = new ArrayList();
        SecretTemplateItemData secretTemplateItemData = new SecretTemplateItemData("1", Color.parseColor(TipsElementData.DEFAULT_COLOR), Color.parseColor("#3c3c3c"), Color.parseColor(TipsElementData.DEFAULT_COLOR), 1, 0, "\u6df1\u7070\u8272");
        this.listData.add(secretTemplateItemData);
        this.dataMap.put("1", secretTemplateItemData);
        SecretTemplateItemData secretTemplateItemData2 = new SecretTemplateItemData("2", Color.parseColor(TipsElementData.DEFAULT_COLOR), Color.parseColor("#f5d575"), Color.parseColor(TipsElementData.DEFAULT_COLOR), 1, 0, "\u6854\u9ec4\u8272");
        this.listData.add(secretTemplateItemData2);
        this.dataMap.put("2", secretTemplateItemData2);
        SecretTemplateItemData secretTemplateItemData3 = new SecretTemplateItemData("3", Color.parseColor(TipsElementData.DEFAULT_COLOR), Color.parseColor("#f69595"), Color.parseColor(TipsElementData.DEFAULT_COLOR), 1, 0, "\u7c89\u7ea2\u8272");
        this.listData.add(secretTemplateItemData3);
        this.dataMap.put("3", secretTemplateItemData3);
        SecretTemplateItemData secretTemplateItemData4 = new SecretTemplateItemData("4", Color.parseColor(TipsElementData.DEFAULT_COLOR), Color.parseColor("#c6a6c1"), Color.parseColor(TipsElementData.DEFAULT_COLOR), 1, 0, "\u6de1\u7d2b\u8272");
        this.listData.add(secretTemplateItemData4);
        this.dataMap.put("4", secretTemplateItemData4);
        SecretTemplateItemData secretTemplateItemData5 = new SecretTemplateItemData("5", Color.parseColor(TipsElementData.DEFAULT_COLOR), Color.parseColor("#89cccb"), Color.parseColor(TipsElementData.DEFAULT_COLOR), 1, 0, "\u6c34\u7eff\u8272");
        this.listData.add(secretTemplateItemData5);
        this.dataMap.put("5", secretTemplateItemData5);
        SecretTemplateItemData secretTemplateItemData6 = new SecretTemplateItemData("6", Color.parseColor(TipsElementData.DEFAULT_COLOR), Color.parseColor("#90cbe3"), Color.parseColor(TipsElementData.DEFAULT_COLOR), 1, 0, "\u5929\u84dd\u8272");
        this.listData.add(secretTemplateItemData6);
        this.dataMap.put("6", secretTemplateItemData6);
        SecretTemplateItemData secretTemplateItemData7 = new SecretTemplateItemData("7", Color.parseColor(TipsElementData.DEFAULT_COLOR), Color.parseColor("#6e7d8f"), Color.parseColor(TipsElementData.DEFAULT_COLOR), 1, 0, "\u58a8\u7070\u8272");
        this.listData.add(secretTemplateItemData7);
        this.dataMap.put("7", secretTemplateItemData7);
        SecretTemplateItemData secretTemplateItemData8 = new SecretTemplateItemData("8", Color.parseColor(TipsElementData.DEFAULT_COLOR), Color.parseColor("#62ad98"), Color.parseColor(TipsElementData.DEFAULT_COLOR), 1, 0, "\u7070\u7eff\u8272");
        this.listData.add(secretTemplateItemData8);
        this.dataMap.put("8", secretTemplateItemData8);
        SecretTemplateItemData secretTemplateItemData9 = new SecretTemplateItemData("9", Color.parseColor(TipsElementData.DEFAULT_COLOR), Color.parseColor("#d3cc72"), Color.parseColor(TipsElementData.DEFAULT_COLOR), 1, 0, "\u67e0\u6aac\u9ec4");
        this.listData.add(secretTemplateItemData9);
        this.dataMap.put("9", secretTemplateItemData9);
        SecretTemplateItemData secretTemplateItemData10 = new SecretTemplateItemData("10", Color.parseColor("#333333"), Color.parseColor("#e9d4a9"), Color.parseColor(TipsElementData.DEFAULT_COLOR), 0, 0, "\u9999\u69df\u8272");
        secretTemplateItemData10.feedTitleColor = Color.parseColor("#4c4c4c");
        this.listData.add(secretTemplateItemData10);
        this.dataMap.put("10", secretTemplateItemData10);
        SecretTemplateItemData secretTemplateItemData11 = new SecretTemplateItemData("11", Color.parseColor(TipsElementData.DEFAULT_COLOR), Color.parseColor("#dba6a1"), Color.parseColor(TipsElementData.DEFAULT_COLOR), 1, 0, "\u6d45\u7c89\u8272");
        this.listData.add(secretTemplateItemData11);
        this.dataMap.put("11", secretTemplateItemData11);
    }
}
