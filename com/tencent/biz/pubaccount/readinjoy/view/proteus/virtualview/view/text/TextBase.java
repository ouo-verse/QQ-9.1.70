package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text;

import android.graphics.Typeface;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.TextBaseCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.JsonUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class TextBase extends ViewBase {
    private static final String TAG = "TextBase";
    private static final String TEXT_ALIGNMENT_CENTER = "1";
    private static final String TEXT_ALIGNMENT_LEFT = "0";
    private static final String TEXT_ALIGNMENT_RIGHT = "2";
    protected String drawableLeftPath;
    protected int mEllipsize;
    protected Boolean mEnableClickSpan;
    protected Boolean mEnableMarquee;
    protected float mFontSizeRatio;
    protected float mLineSpaceExtra;
    protected float mLineSpaceMultipiler;
    protected int mLines;
    protected int mMaxLines;
    protected int mMaxWidth;
    protected CharSequence mText;
    protected int mTextColor;
    protected int mTextSize;
    protected int mTextStyle;
    protected Typeface mTypeface;
    protected String mTypefacePath;

    public TextBase(VafContext vafContext) {
        super(vafContext);
        this.mLineSpaceMultipiler = 1.0f;
        this.mLineSpaceExtra = 0.0f;
        this.mFontSizeRatio = 1.0f;
        this.mLines = -1;
        this.mEllipsize = TextUtils.TruncateAt.END.ordinal();
        this.mMaxLines = -1;
        this.mText = "";
        this.mTextColor = -16777216;
        this.mTextSize = Utils.dp2px(20.0d);
        this.mTextStyle = 0;
        this.mGravity = 32;
    }

    private void parseFonSize(int i3, String str) {
        Double d16 = Utils.toDouble(str);
        if (d16 != null) {
            this.mTextSize = Utils.dp2px(d16.doubleValue());
            return;
        }
        LogUtil.QLog.d(TAG, 2, "setAttribute: fail to parse - " + i3 + MsgSummary.STR_COLON + str);
    }

    private void parseTextSizeRatio(int i3, String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str)) {
                parseFonSize(i3, str);
            }
            if (!TextUtils.isEmpty(str2)) {
                this.mFontSizeRatio = Float.parseFloat(str2);
            }
        } catch (Exception e16) {
            LogUtil.QLog.d(TAG, 1, "parseTextSizeRatio error!msg=" + e16);
        }
    }

    private void resetAligment() {
        this.mGravity = this.mGravity & (-2) & (-5) & (-3);
    }

    private void resetGravity() {
        this.mGravity = this.mGravity & (-5) & (-33);
    }

    public String getText() {
        CharSequence charSequence = this.mText;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return "";
    }

    public int getTextColor() {
        return this.mTextColor;
    }

    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    public void onParseValueFinished() {
        super.onParseValueFinished();
        this.mTextSize = (int) (this.mTextSize * this.mFontSizeRatio);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    public boolean setAttribute(int i3, Object obj) {
        if (!super.setAttribute(i3, obj)) {
            if (i3 == 18) {
                if (obj instanceof JSONArray) {
                    String stringValue = JsonUtils.getStringValue((JSONArray) obj, 1);
                    if (stringValue != null) {
                        try {
                            this.mLineSpaceExtra = Float.valueOf(stringValue).floatValue();
                            this.mLineSpaceExtra = Utils.dp2px(r9);
                        } catch (Exception e16) {
                            LogUtil.QLog.e(TAG, 1, "setAttribute: invalid value for STR_ID_TEXT, type: ", e16);
                        }
                    }
                    this.mText = JsonUtils.getStringValue(obj, 0);
                } else if (obj instanceof CharSequence) {
                    this.mText = (CharSequence) obj;
                }
                if (this.mText == null) {
                    LogUtil.QLog.d(TAG, 2, "setAttribute: invalid value for STR_ID_TEXT, type: " + obj.getClass().getSimpleName() + "  value : " + obj);
                    return false;
                }
            } else if (i3 != 64) {
                switch (i3) {
                    case 69:
                        if (obj instanceof JSONArray) {
                            JSONArray jSONArray = (JSONArray) obj;
                            if (jSONArray.length() >= 2) {
                                try {
                                    String optString = jSONArray.optString(1, ParseCommon.LAYOUT_PARAMS_RELATIVE);
                                    double doubleValue = Double.valueOf(jSONArray.getString(0)).doubleValue();
                                    if (ParseCommon.LAYOUT_PARAMS_ABSOLUTELY.equals(optString)) {
                                        this.mMaxWidth = Utils.dp2px(doubleValue);
                                    } else {
                                        this.mMaxWidth = Utils.rp2px(doubleValue);
                                    }
                                    break;
                                } catch (Exception e17) {
                                    LogUtil.QLog.d(TAG, 1, "", e17);
                                    break;
                                }
                            }
                        }
                        break;
                    case 70:
                        if (obj instanceof JSONArray) {
                            parseTextSizeRatio(i3, JsonUtils.getStringValue(obj, 0), JsonUtils.getStringValue(obj, 1));
                            break;
                        }
                        break;
                    case 71:
                        if (obj instanceof JSONArray) {
                            parseTextSizeRatio(i3, JsonUtils.getStringValue(obj, 0), JsonUtils.getStringValue(obj, 1));
                            this.mTextStyle = 1;
                            break;
                        }
                        break;
                    default:
                        return false;
                }
            } else if (obj instanceof JSONArray) {
                JSONArray jSONArray2 = (JSONArray) obj;
                if (jSONArray2.length() >= 3) {
                    try {
                        Double d16 = Utils.toDouble(jSONArray2.getString(2));
                        if (d16 != null) {
                            this.mTextSize = Utils.dp2px(d16.doubleValue());
                        }
                        this.mTypefacePath = jSONArray2.getString(0);
                        this.mTypeface = Typeface.createFromAsset(this.mContext.getContext().getAssets(), this.mTypefacePath);
                    } catch (Exception e18) {
                        LogUtil.QLog.d(TAG, 1, "", e18);
                    }
                }
            }
        }
        return true;
    }

    public void setText(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.mText)) {
            this.mText = charSequence;
            refresh();
        }
    }

    public void setTextColor(int i3) {
        if (this.mTextColor != i3) {
            this.mTextColor = i3;
            this.mPaint.setColor(i3);
            refresh();
        }
    }

    protected void setDrawableLeft(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase
    public boolean setAttribute(int i3, String str) {
        boolean attribute = super.setAttribute(i3, str);
        if (attribute) {
            return attribute;
        }
        if (i3 == 41) {
            resetGravity();
            if (TextBaseCommon.CENTER_VERTICEL.equals(str)) {
                this.mGravity |= 32;
                return attribute;
            }
            this.mGravity = this.mGravity | 4 | 32;
            return attribute;
        }
        if (i3 == 46) {
            this.drawableLeftPath = str;
            setDrawableLeft(str);
            return attribute;
        }
        if (i3 == 50) {
            resetAligment();
            if ("0".equals(str)) {
                this.mGravity |= 1;
                return attribute;
            }
            if ("1".equals(str)) {
                this.mGravity |= 4;
                return attribute;
            }
            if (!"2".equals(str)) {
                return attribute;
            }
            this.mGravity |= 2;
            return attribute;
        }
        if (i3 == 67) {
            if (TextUtils.isEmpty(str)) {
                return attribute;
            }
            this.mEnableMarquee = Boolean.valueOf(TextUtils.equals("1", str));
            return attribute;
        }
        if (i3 != 68) {
            switch (i3) {
                case 18:
                    this.mText = str;
                    return attribute;
                case 19:
                    parseFonSize(i3, str);
                    return attribute;
                case 20:
                    this.mTextColor = Utils.parseColor(str);
                    return attribute;
                case 21:
                    Double d16 = Utils.toDouble(str);
                    if (d16 != null) {
                        this.mTextSize = Utils.dp2px(d16.doubleValue());
                        this.mTextStyle = 1;
                        return attribute;
                    }
                    LogUtil.QLog.d(TAG, 2, "setAttribute: fail to parse - " + i3 + MsgSummary.STR_COLON + str);
                    return attribute;
                case 22:
                    Integer integer = Utils.toInteger(str);
                    if (integer != null) {
                        this.mMaxLines = integer.intValue();
                        return attribute;
                    }
                    LogUtil.QLog.d(TAG, 2, "setAttribute: fail to parse - " + i3 + MsgSummary.STR_COLON + str);
                    return attribute;
                default:
                    return false;
            }
        }
        if (TextUtils.isEmpty(str)) {
            return attribute;
        }
        this.mEnableClickSpan = Boolean.valueOf(TextUtils.equals("1", str));
        return attribute;
    }
}
