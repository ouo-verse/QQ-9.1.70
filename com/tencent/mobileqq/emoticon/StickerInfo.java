package com.tencent.mobileqq.emoticon;

import android.text.TextUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import java.io.Serializable;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class StickerInfo implements Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "StickerInfo";
    public static final long serialVersionUID = 1;
    public float height;
    public long hostMsgSeq;
    public long hostMsgTime;
    public long hostMsgUid;
    public boolean isDisplayed;
    public boolean isShown;

    /* renamed from: msg, reason: collision with root package name */
    public String f204678msg;
    public int originMsgType;
    public int rotate;
    public float width;

    /* renamed from: x, reason: collision with root package name */
    public float f204679x;

    /* renamed from: y, reason: collision with root package name */
    public float f204680y;

    public StickerInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.originMsgType = 0;
        this.f204679x = 0.0f;
        this.f204680y = 0.0f;
        this.width = 0.0f;
        this.height = 0.0f;
        this.rotate = 0;
        this.hostMsgSeq = 0L;
        this.hostMsgUid = 0L;
        this.hostMsgTime = 0L;
        this.isDisplayed = false;
        this.isShown = false;
        this.f204678msg = "";
    }

    public static StickerInfo transformFromJson(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                StickerInfo stickerInfo = new StickerInfo();
                JSONObject jSONObject = new JSONObject(str);
                stickerInfo.originMsgType = jSONObject.optInt("originMsgType");
                stickerInfo.f204679x = (float) jSONObject.optDouble(HippyTKDListViewAdapter.X);
                stickerInfo.f204680y = (float) jSONObject.optDouble("y");
                stickerInfo.width = (float) jSONObject.optDouble("width");
                stickerInfo.height = (float) jSONObject.optDouble("height");
                stickerInfo.rotate = jSONObject.optInt(CanvasView.ACTION_ROTATE);
                stickerInfo.hostMsgSeq = jSONObject.optLong("hostMsgSeq");
                stickerInfo.hostMsgUid = jSONObject.optLong("hostMsgUid");
                stickerInfo.hostMsgTime = jSONObject.optLong("hostMsgTime");
                stickerInfo.isDisplayed = jSONObject.optBoolean("isDisplayed");
                stickerInfo.isShown = jSONObject.optBoolean("isShown");
                stickerInfo.f204678msg = jSONObject.optString("msg");
                return stickerInfo;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "StickerInfo.transformFromJson error + e = " + e16);
                return null;
            }
        }
        return null;
    }

    public String toJsonString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("originMsgType", this.originMsgType);
            jSONObject.put(HippyTKDListViewAdapter.X, this.f204679x);
            jSONObject.put("y", this.f204680y);
            jSONObject.put("width", this.width);
            jSONObject.put("height", this.height);
            jSONObject.put(CanvasView.ACTION_ROTATE, this.rotate);
            jSONObject.put("hostMsgSeq", this.hostMsgSeq);
            jSONObject.put("hostMsgUid", this.hostMsgUid);
            jSONObject.put("hostMsgTime", this.hostMsgTime);
            jSONObject.put("isDisplayed", this.isDisplayed);
            jSONObject.put("isShown", this.isShown);
            jSONObject.put("msg", this.f204678msg);
            return jSONObject.toString();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "StickerInfo.toJsonString error + e = " + e16);
            return "";
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return String.format("EmojiStickerInfo, originMsgType: %d,  x: %f, y: %f, width: %f, height: %f, rotate: %d, msgseq: %d, msgUid: %d", Integer.valueOf(this.originMsgType), Float.valueOf(this.f204679x), Float.valueOf(this.f204680y), Float.valueOf(this.width), Float.valueOf(this.height), Integer.valueOf(this.rotate), Long.valueOf(this.hostMsgSeq), Long.valueOf(this.hostMsgUid));
    }
}
