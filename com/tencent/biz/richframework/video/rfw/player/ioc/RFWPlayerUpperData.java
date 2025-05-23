package com.tencent.biz.richframework.video.rfw.player.ioc;

import android.content.Context;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: classes5.dex */
public class RFWPlayerUpperData {
    private WeakReference<Context> mContext;
    private String mDtCustomPgId;
    private HashMap<String, Object> mMapValue = new HashMap<>();
    private boolean mMayNeedSpr;

    public RFWPlayerUpperData addValue(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            this.mMapValue.put(str, obj);
        }
        return this;
    }

    public Context getContext() {
        WeakReference<Context> weakReference = this.mContext;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public String getDtCustomPgId() {
        if (TextUtils.isEmpty(this.mDtCustomPgId)) {
            return "";
        }
        return this.mDtCustomPgId;
    }

    public Object getValue(String str) {
        return this.mMapValue.get(str);
    }

    public RFWPlayerUpperData setContext(Context context) {
        if (context == null) {
            return this;
        }
        this.mContext = new WeakReference<>(context);
        return this;
    }

    public RFWPlayerUpperData setDtCustomPgId(String str) {
        this.mDtCustomPgId = str;
        return this;
    }

    public RFWPlayerUpperData setMayNeedSpr(boolean z16) {
        this.mMayNeedSpr = z16;
        return this;
    }
}
