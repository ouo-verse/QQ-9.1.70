package com.tencent.mobileqq.teamworkforgroup;

import com.tencent.mobileqq.persistence.Entity;

/* loaded from: classes18.dex */
public class GroupPadTemplateInfo extends Entity {
    public static final int TEMPLATE_TYPE_COLLECT = 3;
    public static final int TEMPLATE_TYPE_DOC = 1;
    public static final int TEMPLATE_TYPE_SHEET = 2;
    public int docOrSheetType = 2;
    public long groupCode;
    public String mobPrevUrl;
    public String mobThumbUrl;
    public int templateID;
    public String templateName;
    public int templateType;
    public String templateUrl;
    public String webPrevUrl;
    public String webThumUrl;
}
