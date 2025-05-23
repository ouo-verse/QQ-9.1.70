package com.tencent.aelight.camera.ae.play;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.ttpic.baseutils.string.StringUtils;

/* compiled from: P */
/* loaded from: classes32.dex */
public class EditTextDialog extends ReportDialog {
    private float autoTextSize;
    private TextView mCancelView;
    private ImageView mCleanTextView;
    private Button mConfirmView;
    private EditText mEditText;
    private TextView mEditTip;
    private int mMaxLength;
    private OnConfirmClickLister mOnConfirmClickLister;
    private int mTextColor;
    private transient TextPaint mTextPaint;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface OnConfirmClickLister {
        void onConfirmClick(String str);
    }

    private void initTextPaint() {
        TextPaint textPaint = new TextPaint(1);
        this.mTextPaint = textPaint;
        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
        this.mTextPaint.setAntiAlias(true);
    }

    private void initView(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.f167491dm0, (ViewGroup) null);
        this.mEditText = (EditText) inflate.findViewById(R.id.rs6);
        this.mEditTip = (TextView) inflate.findViewById(R.id.rs7);
        this.mCancelView = (TextView) inflate.findViewById(R.id.rqg);
        this.mConfirmView = (Button) inflate.findViewById(R.id.f163742rr4);
        this.mCleanTextView = (ImageView) inflate.findViewById(R.id.rpu);
        this.mEditText.addTextChangedListener(new TextWatcher() { // from class: com.tencent.aelight.camera.ae.play.EditTextDialog.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                int length = editable.length();
                String format = String.format("%d/%d", Integer.valueOf(length), Integer.valueOf(EditTextDialog.this.mMaxLength));
                if (length > EditTextDialog.this.mMaxLength) {
                    SpannableString spannableString = new SpannableString(format);
                    spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#12b7f5")), 0, String.valueOf(length).length(), 33);
                    EditTextDialog.this.mEditTip.setText(spannableString);
                } else {
                    EditTextDialog.this.mEditTip.setText(format);
                }
                EditTextDialog.this.mCleanTextView.setVisibility(length <= 0 ? 8 : 0);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            }
        });
        this.mConfirmView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.play.EditTextDialog.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String str;
                EventCollector.getInstance().onViewClickedBefore(view);
                if (EditTextDialog.this.mEditText.getText().length() <= EditTextDialog.this.mMaxLength) {
                    if (EditTextDialog.this.mOnConfirmClickLister != null) {
                        try {
                            str = EditTextDialog.this.mEditText.getText().toString();
                        } catch (IndexOutOfBoundsException unused) {
                            str = null;
                        }
                        if (!TextUtils.isEmpty(str)) {
                            str = StringUtils.removeUTF8Emoji(str);
                        }
                        if (!TextUtils.isEmpty(str)) {
                            str = str.replaceAll("\\r|\\n", "");
                        }
                        if (str != null) {
                            str = str.trim();
                        }
                        EditTextDialog.this.mOnConfirmClickLister.onConfirmClick(str);
                    }
                    EditTextDialog.this.dismiss();
                } else {
                    QQToast.makeText(EditTextDialog.this.getContext(), EditTextDialog.this.getContext().getString(R.string.y67, Integer.valueOf(EditTextDialog.this.mMaxLength)), 1).show();
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        this.mCancelView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.play.EditTextDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                EditTextDialog.this.mEditText.setText((CharSequence) null);
                EditTextDialog.this.dismiss();
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        this.mCleanTextView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.play.EditTextDialog.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                EditTextDialog.this.mEditText.setText("");
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        setContentView(inflate);
    }

    public void setEditMaxLength(int i3) {
        this.mMaxLength = i3;
    }

    public void setOnConfirmClickListener(OnConfirmClickLister onConfirmClickLister) {
        this.mOnConfirmClickLister = onConfirmClickLister;
    }

    public EditTextDialog(Context context) {
        super(context, R.style.f243470w);
        this.mMaxLength = 12;
        initView(context);
        Window window = getWindow();
        if (window != null) {
            window.setSoftInputMode(21);
        }
        setCanceledOnTouchOutside(true);
    }
}
