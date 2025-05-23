package com.qzone.proxy.feedcomponent.text;

import android.content.Intent;
import com.huawei.hms.support.api.entity.common.CommonConstant;

/* compiled from: P */
/* loaded from: classes39.dex */
public class UrlCell extends ColorTextCell {
    public static final int ACTION_GOTODETAIL = 2;
    public static final int ACTION_NORMAL = 1;
    private static final long serialVersionUID = -7091133393080460624L;
    private int action;
    private Boolean innerCanBreak = null;

    public UrlCell(String str, String str2, String str3) {
        this.type = (this.type & (-256)) | 4;
        setUrl(str2);
        this.text = str;
        this.post = str3;
        if (str2 != null && str2.contains("enterdetail")) {
            this.action = 2;
        } else {
            this.action = 1;
        }
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextCell
    public boolean canBreak() {
        Boolean bool = this.innerCanBreak;
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    public int getAction() {
        return this.action;
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextCell
    public Intent getIntent() {
        return new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
    }

    public void setInnerCanBreak(boolean z16) {
        this.innerCanBreak = Boolean.valueOf(z16);
    }
}
