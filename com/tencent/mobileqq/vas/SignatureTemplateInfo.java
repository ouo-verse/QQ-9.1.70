package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.persistence.unique;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SignatureTemplateInfo {
    public String actUrl;
    public String actionOff;
    public String actionOn;
    public String aio2;
    public String aio3;
    public String aio4;
    public String backgroundColor;
    public String cover;
    public String defText;
    public String defTextColor;
    public String dot9png;
    public DynamicItem[] dynamicItem;
    public String endTime;
    public int feeType;
    public String fontColor;
    public String icon;

    /* renamed from: id, reason: collision with root package name */
    @unique
    public String f307842id;
    public ImageItem imageItem;
    public int isLimited;
    public AtomicBoolean isParsing = new AtomicBoolean(false);
    public int materialVersion;
    public String name;
    public int newOrHot;
    public int platId;
    public String qqVer;
    public String shadowColor;
    public int signType;
    public String startTime;
    public String timeAndLocationColor;
    public int type;
    public String view;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class DynamicItem {
        public int aioRows;
        public float height;
        public int interval;
        public String pngZip;
        public float posX;
        public float posY;
        public int repeatTimes;
        public float width;

        public DynamicItem() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class ImageItem {
        public String content;
        public String coverUrl;
        public int height;
        public String imgUrl;
        public int width;

        public ImageItem() {
        }
    }

    public SignatureTemplateInfo() {
    }

    public void setDefaultInfo() {
        this.f307842id = "0";
        this.name = HardCodeUtil.qqStr(R.string.tiq);
        this.feeType = 1;
        this.type = -1;
        this.fontColor = "#FF03081A";
        this.timeAndLocationColor = "#FF878B99";
    }

    public SignatureTemplateInfo(String str) {
        this.f307842id = str;
        if (str.equals("0")) {
            setDefaultInfo();
        }
        this.dynamicItem = new DynamicItem[5];
        for (int i3 = 0; i3 < 5; i3++) {
            this.dynamicItem[i3] = new DynamicItem();
        }
    }
}
