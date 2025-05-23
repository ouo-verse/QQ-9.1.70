package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.TextBase;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class ButtonBase extends TextBase {
    protected static final int DRAWABLE_BOTTOM = 3;
    protected static final int DRAWABLE_LEFT = 0;
    protected static final int DRAWABLE_RIGHT = 2;
    protected static final int DRAWABLE_TOP = 1;
    protected static final int NORMAL = 0;
    protected static final int PRESS = 1;
    protected static final int SELECTED = 4;
    private static final String TAG = "ButtonBase";
    protected final Drawable GRAY_PLACEHOLDER;
    protected final Drawable TRANSPARENT_PLACE_HOLDER;
    protected float mAlpha;
    private SparseArray<ClickStatus> mClickStatusArr;
    protected int mCompoundDrawablePadding;
    protected boolean mEnable;
    private List<Runnable> mRunnableList;
    protected int mState;
    protected boolean mSupportHtmlStyle;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class ClickStatus {
        public String background;
        public String backgroundColor;
        public int direction;
        public String img;
        public String textColor = null;
    }

    public ButtonBase(VafContext vafContext) {
        super(vafContext);
        this.mSupportHtmlStyle = false;
        this.GRAY_PLACEHOLDER = new ColorDrawable(Color.parseColor("#E9E9E9"));
        this.TRANSPARENT_PLACE_HOLDER = new ColorDrawable(0);
        this.mEnable = true;
        this.mAlpha = Float.NaN;
        this.mClickStatusArr = new SparseArray<>(4);
    }

    private void doOnFinish(Runnable runnable) {
        if (this.mRunnableList == null) {
            this.mRunnableList = new ArrayList();
        }
        this.mRunnableList.add(runnable);
    }

    private void setClickStatus(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        try {
            if (jSONArray.length() >= 4) {
                JSONArray jSONArray2 = jSONArray.getJSONArray(0);
                JSONArray jSONArray3 = jSONArray.getJSONArray(1);
                JSONArray jSONArray4 = jSONArray.getJSONArray(2);
                JSONArray jSONArray5 = jSONArray.getJSONArray(3);
                for (int i3 = 0; i3 < jSONArray5.length(); i3++) {
                    ClickStatus status = getStatus(Integer.valueOf(jSONArray5.getString(i3)).intValue());
                    if (i3 < jSONArray2.length()) {
                        status.img = jSONArray2.getString(i3);
                    }
                    if (i3 < jSONArray3.length()) {
                        status.textColor = jSONArray3.getString(i3);
                    }
                    if (i3 < jSONArray4.length()) {
                        status.direction = Integer.valueOf(jSONArray4.getString(i3)).intValue();
                    }
                }
            }
        } catch (Exception e16) {
            Log.e(TAG, "setClickStatus :", e16);
        }
        doOnFinish(new Runnable() { // from class: com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.ButtonBase.4
            @Override // java.lang.Runnable
            public void run() {
                ButtonBase.this.setCompoundDrawableForStates();
            }
        });
        setTextColorForStates();
    }

    private void setStatusBackGroundColor(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        try {
            if (jSONArray.length() >= 2) {
                JSONArray jSONArray2 = jSONArray.getJSONArray(0);
                JSONArray jSONArray3 = jSONArray.getJSONArray(1);
                for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                    int intValue = Integer.valueOf(jSONArray3.getString(i3)).intValue();
                    if (i3 < jSONArray2.length()) {
                        getStatus(intValue).backgroundColor = jSONArray2.getString(i3);
                    }
                }
            }
        } catch (Exception unused) {
            Log.e(TAG, "setStatusBackgroud: setStatusBackgroud :" + jSONArray);
        }
        doOnFinish(new Runnable() { // from class: com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.ButtonBase.2
            @Override // java.lang.Runnable
            public void run() {
                ButtonBase.this.setBackgroundColorForStates();
            }
        });
    }

    private void setStatusBackground(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        try {
            if (jSONArray.length() >= 2) {
                JSONArray jSONArray2 = jSONArray.getJSONArray(0);
                JSONArray jSONArray3 = jSONArray.getJSONArray(1);
                for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                    int intValue = Integer.valueOf(jSONArray3.getString(i3)).intValue();
                    if (i3 < jSONArray2.length()) {
                        getStatus(intValue).background = jSONArray2.getString(i3);
                    }
                }
            }
        } catch (Exception unused) {
            Log.e(TAG, "setStatusBackground: setStatusBackground :" + jSONArray);
        }
        doOnFinish(new Runnable() { // from class: com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.ButtonBase.1
            @Override // java.lang.Runnable
            public void run() {
                ButtonBase.this.setBackgroundForStates();
            }
        });
    }

    private void setStatusImage(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        try {
            if (jSONArray.length() >= 2) {
                JSONArray jSONArray2 = jSONArray.getJSONArray(0);
                JSONArray jSONArray3 = jSONArray.getJSONArray(1);
                for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                    int intValue = Integer.valueOf(jSONArray3.getString(i3)).intValue();
                    if (i3 < jSONArray2.length()) {
                        getStatus(intValue).img = jSONArray2.getString(i3);
                    }
                }
            }
        } catch (Exception unused) {
            Log.e(TAG, "setStatusBackgroud: setStatusBackgroud :" + jSONArray);
        }
        doOnFinish(new Runnable() { // from class: com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.ButtonBase.3
            @Override // java.lang.Runnable
            public void run() {
                ButtonBase.this.setCompoundDrawableForStates();
            }
        });
    }

    private void setStatusTextColor(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        try {
            if (jSONArray.length() >= 2) {
                JSONArray jSONArray2 = jSONArray.getJSONArray(0);
                JSONArray jSONArray3 = jSONArray.getJSONArray(1);
                for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                    int intValue = Integer.valueOf(jSONArray3.getString(i3)).intValue();
                    if (i3 < jSONArray2.length()) {
                        getStatus(intValue).textColor = jSONArray2.getString(i3);
                    }
                }
            }
        } catch (Exception unused) {
            Log.e(TAG, "setStatusBackgroud: setStatusBackgroud :" + jSONArray);
        }
        setTextColorForStates();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ClickStatus getStatus(int i3) {
        ClickStatus clickStatus = this.mClickStatusArr.get(i3);
        if (clickStatus == null) {
            ClickStatus clickStatus2 = new ClickStatus();
            this.mClickStatusArr.put(i3, clickStatus2);
            return clickStatus2;
        }
        return clickStatus;
    }

    public boolean isSelected() {
        if (this.mState == 4) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.TextBase, com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    public void onParseValueFinished() {
        boolean z16;
        super.onParseValueFinished();
        if (this.mState == 4) {
            z16 = true;
        } else {
            z16 = false;
        }
        setSelected(z16);
        float f16 = this.mAlpha;
        if (f16 >= 0.0d && f16 <= 1.001d) {
            getNativeView().setAlpha(this.mAlpha);
        }
        getNativeView().setEnabled(this.mEnable);
        List<Runnable> list = this.mRunnableList;
        if (list != null) {
            Iterator<Runnable> it = list.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.TextBase, com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    public boolean setAttribute(int i3, Object obj) {
        boolean attribute = super.setAttribute(i3, obj);
        if (attribute) {
            return attribute;
        }
        if (i3 != 39) {
            if (i3 != 47) {
                switch (i3) {
                    case 42:
                        if (obj instanceof JSONArray) {
                            setClickStatus((JSONArray) obj);
                            break;
                        }
                        break;
                    case 43:
                        if (obj instanceof JSONArray) {
                            setStatusImage((JSONArray) obj);
                            break;
                        }
                        break;
                    case 44:
                        if (obj instanceof JSONArray) {
                            setStatusTextColor((JSONArray) obj);
                            break;
                        }
                        break;
                    default:
                        return false;
                }
            } else if (obj instanceof JSONArray) {
                setStatusBackGroundColor((JSONArray) obj);
            }
        } else if (obj instanceof JSONArray) {
            setStatusBackground((JSONArray) obj);
        }
        return true;
    }

    protected abstract void setBackgroundColorForStates();

    protected abstract void setBackgroundForStates();

    protected abstract void setCompoundDrawableForStates();

    public void setSelected(boolean z16) {
        if (z16) {
            this.mState = 4;
        } else {
            this.mState = 0;
        }
    }

    protected abstract void setTextColorForStates();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.TextBase, com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    public boolean setAttribute(int i3, String str) {
        boolean attribute = super.setAttribute(i3, str);
        if (attribute) {
            return attribute;
        }
        if (i3 != 13) {
            if (i3 == 45) {
                Integer integer = Utils.toInteger(str);
                this.mState = (integer != null ? integer.intValue() : 0) == 1 ? 4 : 0;
            } else if (i3 == 48) {
                Float f16 = Utils.toFloat(str);
                if (f16 != null) {
                    this.mAlpha = f16.floatValue();
                } else {
                    LogUtil.QLog.d(TAG, 2, "setAttribute: fail to parse - " + i3 + MsgSummary.STR_COLON + str);
                }
            } else {
                if (i3 != 49) {
                    return false;
                }
                Integer integer2 = Utils.toInteger(str);
                if (integer2 != null) {
                    this.mEnable = integer2.intValue() == 1;
                } else {
                    LogUtil.QLog.d(TAG, 2, "setAttribute: fail to parse - " + i3 + MsgSummary.STR_COLON + str);
                }
            }
        } else {
            Double d16 = Utils.toDouble(str);
            if (d16 != null) {
                this.mCompoundDrawablePadding = Utils.rp2px(d16.doubleValue());
            } else {
                LogUtil.QLog.d(TAG, 2, "setAttribute: fail to parse - " + i3 + MsgSummary.STR_COLON + str);
            }
        }
        return true;
    }
}
