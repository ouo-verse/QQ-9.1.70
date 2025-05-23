package com.tencent.qqmini.minigame.manager;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.minigame.widget.CustomButton;
import com.tencent.qqmini.sdk.core.utils.ImageUtil;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class CustomButtonManager {
    private static final String TAG = "CustomButtonManager";
    private String mAppId;
    private Activity mContext;
    private Map<Long, CustomButton> mCustomButtonList = new HashMap();
    private ViewGroup mGameContainer;
    private float mScale;

    public CustomButtonManager(Activity activity, ViewGroup viewGroup, String str, float f16) {
        this.mGameContainer = viewGroup;
        this.mScale = f16;
        this.mAppId = str;
        this.mContext = activity;
    }

    private CustomButton.ButtonParam parseButtonParam(JSONObject jSONObject) {
        CustomButton.ButtonParam buttonParam = new CustomButton.ButtonParam();
        buttonParam.style = new CustomButton.ButtonStyle();
        buttonParam.componentId = jSONObject.optLong("compId");
        buttonParam.type = jSONObject.optString("type", "text");
        buttonParam.text = jSONObject.optString("text", "\u83b7\u53d6\u7528\u6237\u4fe1\u606f");
        buttonParam.image = jSONObject.optString("image");
        buttonParam.withCredentials = jSONObject.optBoolean("withCredentials");
        buttonParam.lang = jSONObject.optString("lang", "en");
        buttonParam.openId = jSONObject.optString("openid");
        JSONObject optJSONObject = jSONObject.optJSONObject("style");
        if (optJSONObject != null) {
            buttonParam.style.left = (int) (optJSONObject.optInt("left") * this.mScale);
            buttonParam.style.top = (int) (optJSONObject.optInt("top") * this.mScale);
            buttonParam.style.width = (int) (optJSONObject.optInt("width") * this.mScale);
            buttonParam.style.height = (int) (optJSONObject.optInt("height") * this.mScale);
            buttonParam.style.backgroundColor = optJSONObject.optString("backgroundColor");
            buttonParam.style.borderColor = optJSONObject.optString(NodeProps.BORDER_COLOR);
            buttonParam.style.borderWidth = (int) (optJSONObject.optInt(NodeProps.BORDER_WIDTH) * this.mScale);
            buttonParam.style.borderRadius = (int) (optJSONObject.optInt(NodeProps.BORDER_RADIUS) * this.mScale);
            buttonParam.style.textAlign = optJSONObject.optString("textAlign");
            buttonParam.style.fontSize = optJSONObject.optInt("fontSize");
            buttonParam.style.color = optJSONObject.optString("color", TipsElementData.DEFAULT_COLOR);
            buttonParam.style.lineHeight = (int) (optJSONObject.optInt(NodeProps.LINE_HEIGHT) * this.mScale);
        }
        return buttonParam;
    }

    private void setButtonParam(final CustomButton.ButtonParam buttonParam, final View.OnClickListener onClickListener, final boolean z16) {
        if (buttonParam == null) {
            return;
        }
        this.mGameContainer.post(new Runnable() { // from class: com.tencent.qqmini.minigame.manager.CustomButtonManager.3
            @Override // java.lang.Runnable
            public void run() {
                CustomButton customButton = (CustomButton) CustomButtonManager.this.mCustomButtonList.get(Long.valueOf(buttonParam.componentId));
                if (z16 && customButton == null) {
                    return;
                }
                if (customButton == null) {
                    customButton = new CustomButton(CustomButtonManager.this.mContext);
                    customButton.setParam(buttonParam, onClickListener);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    CustomButton.ButtonStyle buttonStyle = buttonParam.style;
                    layoutParams.height = buttonStyle.height;
                    layoutParams.width = buttonStyle.width;
                    layoutParams.leftMargin = buttonStyle.left;
                    layoutParams.topMargin = buttonStyle.top;
                    if (customButton.getButton() != null) {
                        CustomButtonManager.this.mGameContainer.addView(customButton.getButton(), layoutParams);
                        CustomButtonManager.this.mCustomButtonList.put(Long.valueOf(buttonParam.componentId), customButton);
                    } else {
                        QMLog.e(CustomButtonManager.TAG, "createCustomButton getButton() == null");
                        return;
                    }
                } else {
                    customButton.setParam(buttonParam, onClickListener);
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) customButton.getButton().getLayoutParams();
                    CustomButton.ButtonStyle buttonStyle2 = buttonParam.style;
                    layoutParams2.height = buttonStyle2.height;
                    layoutParams2.width = buttonStyle2.width;
                    layoutParams2.leftMargin = buttonStyle2.left;
                    layoutParams2.topMargin = buttonStyle2.top;
                    customButton.getButton().setLayoutParams(layoutParams2);
                }
                if ("image".equals(buttonParam.type) && !TextUtils.isEmpty(buttonParam.image)) {
                    Drawable drawable = ImageUtil.getDrawable(CustomButtonManager.this.mContext, CustomButtonManager.this.mAppId, buttonParam.image);
                    if (drawable == null) {
                        QMLog.e(CustomButtonManager.TAG, "imageDrawable == null");
                    } else {
                        customButton.setImageDrawable(drawable);
                    }
                }
            }
        });
    }

    public boolean createCustomButton(JSONObject jSONObject, View.OnClickListener onClickListener) {
        setButtonParam(parseButtonParam(jSONObject), onClickListener, false);
        return true;
    }

    public boolean destroyCustomButton(final long j3) {
        boolean z16;
        if (this.mCustomButtonList.get(Long.valueOf(j3)) != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.mGameContainer.post(new Runnable() { // from class: com.tencent.qqmini.minigame.manager.CustomButtonManager.2
            @Override // java.lang.Runnable
            public void run() {
                CustomButton customButton = (CustomButton) CustomButtonManager.this.mCustomButtonList.get(Long.valueOf(j3));
                CustomButtonManager.this.mCustomButtonList.remove(Long.valueOf(j3));
                if (customButton != null) {
                    CustomButtonManager.this.mGameContainer.removeView(customButton.getButton());
                    customButton.destroy();
                }
            }
        });
        return z16;
    }

    public boolean setCustomButtonVisible(final long j3, final boolean z16) {
        boolean z17;
        if (this.mCustomButtonList.get(Long.valueOf(j3)) != null) {
            z17 = true;
        } else {
            z17 = false;
        }
        this.mGameContainer.post(new Runnable() { // from class: com.tencent.qqmini.minigame.manager.CustomButtonManager.1
            @Override // java.lang.Runnable
            public void run() {
                CustomButton customButton = (CustomButton) CustomButtonManager.this.mCustomButtonList.get(Long.valueOf(j3));
                if (customButton != null) {
                    customButton.setVisible(z16);
                }
            }
        });
        return z17;
    }

    public boolean updateCustomButton(JSONObject jSONObject, View.OnClickListener onClickListener) {
        CustomButton.ButtonParam parseButtonParam = parseButtonParam(jSONObject);
        if (this.mCustomButtonList.get(Long.valueOf(parseButtonParam.componentId)) == null) {
            return false;
        }
        setButtonParam(parseButtonParam, onClickListener, true);
        return true;
    }
}
