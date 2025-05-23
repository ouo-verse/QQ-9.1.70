package com.tenpay.sdk.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qwallet.impl.f;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.util.Utils;

/* compiled from: P */
/* loaded from: classes27.dex */
public class NameValueText extends RelativeLayout {
    private static final String TAG = "NameValueText";
    private static final int VALUE_PADDING = 5;
    private int defaultTextColor;
    private int defaultTextSize;
    private String nameText;
    private int nameTextColor;
    private int nameTextLine;
    private int nameTextSize;
    private TextView nameTextView;
    private String valueText;
    private int valueTextColor;
    private int valueTextLine;
    private int valueTextSize;
    private TextView valueTextView;

    public NameValueText(Context context) {
        super(context);
        this.nameTextColor = -1;
        this.valueTextColor = -1;
        this.defaultTextColor = -1;
        initView(context, null, 0);
    }

    private void initAttri(Context context, AttributeSet attributeSet, int i3) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.G3);
        this.nameText = obtainStyledAttributes.getString(f.K3);
        this.valueText = obtainStyledAttributes.getString(f.O3);
        this.nameTextSize = obtainStyledAttributes.getInt(f.M3, -1);
        this.valueTextSize = obtainStyledAttributes.getInt(f.Q3, -1);
        this.nameTextLine = obtainStyledAttributes.getInt(f.J3, -1);
        this.valueTextLine = obtainStyledAttributes.getInt(f.N3, -1);
        this.defaultTextSize = obtainStyledAttributes.getInt(f.I3, -1);
        try {
            String string = obtainStyledAttributes.getString(f.L3);
            if (!Utils.isStringNull(string)) {
                this.nameTextColor = Color.rgb(Integer.parseInt(string.substring(0, 2), 16), Integer.parseInt(string.substring(2, 4), 16), Integer.parseInt(string.substring(4, 6), 16));
            }
            String string2 = obtainStyledAttributes.getString(f.P3);
            if (!Utils.isStringNull(string2)) {
                this.valueTextColor = Color.rgb(Integer.parseInt(string2.substring(0, 2), 16), Integer.parseInt(string2.substring(2, 4), 16), Integer.parseInt(string2.substring(4, 6), 16));
            }
            String string3 = obtainStyledAttributes.getString(f.H3);
            if (!Utils.isStringNull(string3)) {
                this.defaultTextColor = Color.rgb(Integer.parseInt(string3.substring(0, 2), 16), Integer.parseInt(string3.substring(2, 4), 16), Integer.parseInt(string3.substring(4, 6), 16));
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "", e16);
        }
        if (!Utils.isStringNull(this.nameText)) {
            this.nameTextView.setText(this.nameText);
            setValueTextPadding();
        }
        if (!Utils.isStringNull(this.valueText)) {
            this.valueTextView.setText(this.valueText);
        }
        int i16 = this.nameTextSize;
        if (i16 != -1) {
            this.nameTextView.setTextSize(2, i16);
        } else {
            int i17 = this.defaultTextSize;
            if (i17 != -1) {
                this.nameTextView.setTextSize(2, i17);
            }
        }
        int i18 = this.valueTextSize;
        if (i18 != -1) {
            this.valueTextView.setTextSize(2, i18);
        } else {
            int i19 = this.defaultTextSize;
            if (i19 != -1) {
                this.valueTextView.setTextSize(2, i19);
            }
        }
        int i26 = this.nameTextColor;
        if (i26 != -1) {
            this.nameTextView.setTextColor(i26);
        } else {
            int i27 = this.defaultTextColor;
            if (i27 != -1) {
                this.nameTextView.setTextColor(i27);
            }
        }
        int i28 = this.valueTextColor;
        if (i28 != -1) {
            this.valueTextView.setTextColor(i28);
        } else {
            int i29 = this.defaultTextColor;
            if (i29 != -1) {
                this.valueTextView.setTextColor(i29);
            }
        }
        if (this.nameTextLine != -1) {
            this.nameTextView.getPaint().setFlags(this.nameTextLine);
        }
        if (this.valueTextLine != -1) {
            this.valueTextView.getPaint().setFlags(this.valueTextLine);
        }
        obtainStyledAttributes.recycle();
    }

    private void initView(Context context, AttributeSet attributeSet, int i3) {
        View.inflate(context, R.layout.adp, this);
        this.valueTextView = (TextView) findViewById(R.id.gfv);
        this.nameTextView = (TextView) findViewById(R.id.gfu);
        this.valueTextView.setPadding(5, 0, 0, 0);
        initAttri(context, attributeSet, i3);
    }

    public TextView getValueTextView() {
        return this.valueTextView;
    }

    public void setNameText(String str) {
        TextView textView = this.nameTextView;
        this.nameText = str;
        textView.setText(str);
        setValueTextPadding();
    }

    public void setValueText(CharSequence charSequence) {
        this.valueText = charSequence.toString();
        this.valueTextView.setText(charSequence);
    }

    public void setValueTextColor(int i3) {
        this.valueTextView.setTextColor(i3);
    }

    public NameValueText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nameTextColor = -1;
        this.valueTextColor = -1;
        this.defaultTextColor = -1;
        initView(context, attributeSet, 0);
    }

    public NameValueText(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.nameTextColor = -1;
        this.valueTextColor = -1;
        this.defaultTextColor = -1;
        initView(context, attributeSet, i3);
    }

    private void setValueTextPadding() {
    }
}
