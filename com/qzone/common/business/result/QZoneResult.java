package com.qzone.common.business.result;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.qzone.adapter.feedcomponent.IResult;
import com.qzone.proxy.feedcomponent.model.MedalBannerInfo;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneResult implements SmartParcelable, Cloneable, IResult {
    public static final String KEY_AUTOLOAD = "key_autoLoad";
    public static final String KEY_HASMORE = "hasMore";
    public static final String KEY_ID = "key_id";
    public static final String KEY_IS_DEL_COMMENT = "is_del_comment";
    public static final String KEY_JUMPTYPE = "key_jumptype";
    public static final String KEY_MEDALBANNER = "key_medalbanner";
    public static final String KEY_NEWCNT = "key_newcnt";
    public static final String KEY_SHOW_BANNER = "key_isShowBanner";
    protected static final int RESULT_FAIL = 2;
    protected static final int RESULT_SUCCESS = 1;
    public static final String UGC_KEY = "ugc_key";

    @NeedParcel
    private final Bundle extraData = new Bundle();

    @NeedParcel
    private Object mData;

    @NeedParcel
    private String mMsg;

    @NeedParcel
    private int mResult;

    @NeedParcel
    private int mReturnCode;

    @NeedParcel
    public int what;

    public QZoneResult() {
    }

    @Override // com.qzone.adapter.feedcomponent.IResult
    public Bundle getBundle() {
        return this.extraData;
    }

    @Override // com.qzone.adapter.feedcomponent.IResult
    public Object getData() {
        return this.mData;
    }

    public String getFeedId() {
        return this.extraData.getString("key_id");
    }

    @Override // com.qzone.adapter.feedcomponent.IResult
    public boolean getHasMore() {
        return this.extraData.getBoolean("hasMore");
    }

    public int getJumpType() {
        return this.extraData.getInt(KEY_JUMPTYPE);
    }

    public MedalBannerInfo getMedalBannerData() {
        return (MedalBannerInfo) ParcelableWrapper.getDataFromBudle(this.extraData, KEY_MEDALBANNER);
    }

    @Override // com.qzone.adapter.feedcomponent.IResult
    public String getMessage() {
        return this.mMsg;
    }

    @Override // com.qzone.adapter.feedcomponent.IResult
    public long getNewCnt() {
        return this.extraData.getLong(KEY_NEWCNT);
    }

    @Override // com.qzone.adapter.feedcomponent.IResult
    public Object getObjectData() {
        return this.mData;
    }

    protected int getResult() {
        return this.mResult;
    }

    @Override // com.qzone.adapter.feedcomponent.IResult
    public int getReturnCode() {
        return this.mReturnCode;
    }

    @Override // com.qzone.adapter.feedcomponent.IResult
    public boolean getSucceed() {
        return getResult() == 1;
    }

    public String getUgcKey() {
        return this.extraData.getString(UGC_KEY);
    }

    @Override // com.qzone.adapter.feedcomponent.IResult
    public int getWhat() {
        return this.what;
    }

    public boolean isAutoLoad() {
        return this.extraData.getBoolean(KEY_AUTOLOAD);
    }

    public void setAutoLoad(boolean z16) {
        this.extraData.putBoolean(KEY_AUTOLOAD, z16);
    }

    @Override // com.qzone.adapter.feedcomponent.IResult
    public void setData(Object obj) {
        this.mData = obj;
    }

    @Override // com.qzone.adapter.feedcomponent.IResult
    public void setFailReason(String str) {
        this.mMsg = str;
    }

    public void setFeedId(String str) {
        this.extraData.putString("key_id", str);
    }

    @Override // com.qzone.adapter.feedcomponent.IResult
    public void setHasMore(boolean z16) {
        this.extraData.putBoolean("hasMore", z16);
    }

    public void setKeyJumptype(int i3) {
        this.extraData.putInt(KEY_JUMPTYPE, i3);
    }

    public void setMedalBannerData(MedalBannerInfo medalBannerInfo) {
        ParcelableWrapper.putDataToBundle(this.extraData, KEY_MEDALBANNER, medalBannerInfo);
    }

    public void setMessage(String str) {
        this.mMsg = str;
    }

    @Override // com.qzone.adapter.feedcomponent.IResult
    public void setNewCnt(long j3) {
        this.extraData.putLong(KEY_NEWCNT, j3);
    }

    @Override // com.qzone.adapter.feedcomponent.IResult
    public void setObjectData(Object obj) {
        this.mData = obj;
    }

    protected void setResult(int i3) {
        this.mResult = i3;
    }

    @Override // com.qzone.adapter.feedcomponent.IResult
    public void setReturnCode(int i3) {
        this.mReturnCode = i3;
    }

    public void setUgcKey(String str) {
        this.extraData.putString(UGC_KEY, str);
    }

    @Override // com.qzone.adapter.feedcomponent.IResult
    public void setWhat(int i3) {
        this.what = i3;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public QZoneResult m76clone() {
        return new QZoneResult(this);
    }

    public QZoneResult(int i3) {
        this.what = i3;
    }

    public void pack(Message message) {
        if (message == null) {
            return;
        }
        if (message.obj == null) {
            message.obj = this;
            return;
        }
        throw new IllegalStateException("pack error: this message already have a data!");
    }

    @Override // com.qzone.adapter.feedcomponent.IResult
    public void sendToHandler(Handler handler) {
        if (handler == null) {
            return;
        }
        Message obtainMessage = handler.obtainMessage(this.what);
        pack(obtainMessage);
        handler.sendMessage(obtainMessage);
    }

    public QZoneResult(QZoneResult qZoneResult) {
        this.what = qZoneResult.what;
        this.mResult = qZoneResult.mResult;
        this.mReturnCode = qZoneResult.mReturnCode;
        this.mMsg = qZoneResult.mMsg;
        this.mData = qZoneResult.mData;
    }

    public static QZoneResult unpack(Message message) {
        Object obj = message == null ? null : message.obj;
        if (obj == null) {
            return null;
        }
        if (obj instanceof ParcelableWrapper) {
            obj = ((ParcelableWrapper) obj).getData();
        }
        if (obj instanceof QZoneResult) {
            return (QZoneResult) obj;
        }
        return null;
    }

    @Override // com.qzone.adapter.feedcomponent.IResult
    public void setSucceed(boolean z16) {
        setResult(z16 ? 1 : 2);
    }
}
