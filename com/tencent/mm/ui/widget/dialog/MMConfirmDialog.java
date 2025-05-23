package com.tencent.mm.ui.widget.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.tencent.luggage.wxa.lo.n;
import com.tencent.luggage.wxa.lo.o;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public class MMConfirmDialog {
    public static final int CB_CHECKED = 1;
    public static final int CB_DISABLE = 2;
    public static final int CB_UNCHECKED = 0;

    /* compiled from: P */
    /* renamed from: com.tencent.mm.ui.widget.dialog.MMConfirmDialog$1, reason: invalid class name */
    /* loaded from: classes9.dex */
    class AnonymousClass1 implements DialogInterface.OnDismissListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Bitmap f153013a;

        public AnonymousClass1(Bitmap bitmap) {
            this.f153013a = bitmap;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            Bitmap bitmap = this.f153013a;
            if (bitmap != null) {
                bitmap.isRecycled();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface IIOnDialogClick {
        void onDialogClick(boolean z16, String str, boolean z17);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface IOnDialogClick {
        void onDialogClick(boolean z16, String str);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface IOnDialogDismiss {
        void onDismiss(DialogInterface dialogInterface);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface IOnMultiChoiceClickListener {
        void onDialogClick(boolean z16, int[] iArr);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface IOnMultiChoiceListener {
        void onCheckboxClick(int i3, boolean z16, int[] iArr);
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final MMAlertDialog.Builder f153014a;

        /* renamed from: b, reason: collision with root package name */
        public Context f153015b;

        /* renamed from: c, reason: collision with root package name */
        public MMAlertDialog f153016c;

        /* renamed from: d, reason: collision with root package name */
        public String f153017d;

        /* renamed from: e, reason: collision with root package name */
        public String f153018e;

        /* renamed from: f, reason: collision with root package name */
        public RadioGroup f153019f;

        /* renamed from: g, reason: collision with root package name */
        public LinearLayout f153020g;

        /* renamed from: h, reason: collision with root package name */
        public IOnMultiChoiceListener f153021h;

        /* renamed from: i, reason: collision with root package name */
        public int[] f153022i;

        public Builder(Context context) {
            this.f153017d = null;
            this.f153018e = null;
            this.f153015b = context;
            MMAlertDialog.Builder builder = new MMAlertDialog.Builder(context);
            this.f153014a = builder;
            builder.setCancelable(false);
            builder.setCanBack(false);
            builder.setTextSmileySpan(new MMAlertDialog.Builder.ITextSmileySpan() { // from class: com.tencent.mm.ui.widget.dialog.MMConfirmDialog.Builder.1
                @Override // com.tencent.mm.ui.widget.dialog.MMAlertDialog.Builder.ITextSmileySpan
                public CharSequence smileySpan(Context context2, CharSequence charSequence, float f16) {
                    return com.tencent.luggage.wxa.oo.a.a(Builder.this.f153015b, charSequence);
                }
            });
            this.f153018e = this.f153015b.getResources().getString(R.string.f170647xd);
            this.f153017d = this.f153015b.getResources().getString(R.string.f170648xe);
        }

        public Builder cancel(DialogInterface.OnCancelListener onCancelListener) {
            this.f153014a.setOnCancelListener(onCancelListener);
            return this;
        }

        public Builder cancelable(boolean z16) {
            this.f153014a.setCancelable(z16);
            this.f153014a.setCanBack(z16);
            return this;
        }

        public Builder checkBoxText(String str) {
            this.f153014a.setCheckBox(str);
            return this;
        }

        public Builder click(IOnDialogClick iOnDialogClick, IOnDialogClick iOnDialogClick2) {
            RadioGroup radioGroup = this.f153019f;
            if (radioGroup != null) {
                radioGroup.setTag(this.f153016c);
            }
            negativeClick(iOnDialogClick);
            positiveClick(iOnDialogClick2);
            return this;
        }

        public Builder customView(View view) {
            this.f153014a.setView(view);
            return this;
        }

        public Builder dismiss(DialogInterface.OnDismissListener onDismissListener) {
            this.f153014a.setOnDismissListener(onDismissListener);
            return this;
        }

        public final MMAlertDialog getAlert() {
            return this.f153016c;
        }

        public Builder hasEditText(Boolean bool) {
            this.f153014a.hasEditText(bool.booleanValue());
            return this;
        }

        public Builder message(String str) {
            this.f153014a.setMsg(str);
            return this;
        }

        public Builder messageIcon(String str) {
            this.f153014a.setMsgIcon(str);
            return this;
        }

        public Builder msgSubContent(String str) {
            this.f153014a.setMsgSubDesc(str);
            return this;
        }

        public Builder msgSubTitle(CharSequence charSequence) {
            Context context = this.f153015b;
            o.a(context, (int) (o.b(context) * 14.0f));
            if (charSequence != null && charSequence.length() > 0) {
                charSequence = com.tencent.luggage.wxa.oo.a.a(this.f153015b, charSequence.toString());
            }
            this.f153014a.setMsgSubTitle(charSequence);
            return this;
        }

        public Builder multiBtnText(String str, String str2, String str3) {
            this.f153014a.setMultiBtnText(str, str2, str3);
            return this;
        }

        public Builder multiClick(DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnClickListener onClickListener3) {
            this.f153014a.setMultiBtnListener(onClickListener, onClickListener2, onClickListener3);
            return this;
        }

        public Builder multiSelect(LinkedHashMap<String, Integer> linkedHashMap) {
            View inflate = View.inflate(this.f153015b, R.layout.f167904e60, null);
            this.f153020g = (LinearLayout) inflate.findViewById(R.id.tvo);
            if (linkedHashMap != null) {
                this.f153022i = new int[linkedHashMap.size()];
                final int i3 = 0;
                for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
                    int intValue = entry.getValue().intValue();
                    String key = entry.getKey();
                    this.f153022i[i3] = intValue;
                    LinearLayout linearLayout = (LinearLayout) View.inflate(this.f153015b, R.layout.e5z, null);
                    final CheckBox checkBox = (CheckBox) linearLayout.findViewById(R.id.tvq);
                    checkBox.setText(key);
                    checkBox.setTag(Integer.valueOf(i3));
                    checkBox.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mm.ui.widget.dialog.MMConfirmDialog.Builder.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (view != null && (view instanceof CheckBox)) {
                                CheckBox checkBox2 = (CheckBox) view;
                                if (checkBox2.isChecked()) {
                                    Builder.this.f153022i[((Integer) checkBox.getTag()).intValue()] = 1;
                                } else {
                                    Builder.this.f153022i[((Integer) checkBox.getTag()).intValue()] = 0;
                                }
                                if (Builder.this.f153021h != null) {
                                    Builder.this.f153021h.onCheckboxClick(i3, checkBox2.isChecked(), Builder.this.f153022i);
                                }
                            }
                        }
                    });
                    i3++;
                    if (intValue == 2) {
                        checkBox.setChecked(true);
                        checkBox.setEnabled(false);
                    } else if (intValue == 1) {
                        checkBox.setChecked(true);
                    } else {
                        checkBox.setChecked(false);
                    }
                    this.f153020g.addView(linearLayout);
                }
            }
            this.f153014a.setView(inflate);
            return this;
        }

        public Builder multiSelectListener(IOnMultiChoiceListener iOnMultiChoiceListener) {
            this.f153021h = iOnMultiChoiceListener;
            return this;
        }

        public Builder negativeBtnColor(int i3) {
            this.f153014a.setNegativeBtnColor(i3);
            return this;
        }

        public Builder negativeClick(final IOnDialogClick iOnDialogClick) {
            String str = this.f153018e;
            if (str == null || str.length() == 0) {
                this.f153018e = this.f153015b.getResources().getString(R.string.f170647xd);
            }
            RadioGroup radioGroup = this.f153019f;
            if (radioGroup != null) {
                radioGroup.setTag(this.f153016c);
            }
            this.f153014a.setNegativeBtnText(this.f153018e);
            this.f153014a.setNegativeBtnListener(new DialogInterface.OnClickListener() { // from class: com.tencent.mm.ui.widget.dialog.MMConfirmDialog.Builder.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    IOnDialogClick iOnDialogClick2 = iOnDialogClick;
                    if (iOnDialogClick2 != null) {
                        iOnDialogClick2.onDialogClick(false, null);
                    }
                }
            });
            return this;
        }

        public Builder negativeText(String str) {
            this.f153018e = str;
            this.f153014a.setNegativeBtnText(str);
            return this;
        }

        public Builder positiveBtnColor(int i3) {
            this.f153014a.setPositiveBtnColor(i3);
            return this;
        }

        public Builder positiveClick(final IOnDialogClick iOnDialogClick) {
            String str = this.f153017d;
            if (str == null || str.length() == 0) {
                this.f153017d = this.f153015b.getResources().getString(R.string.f170648xe);
            }
            RadioGroup radioGroup = this.f153019f;
            if (radioGroup != null) {
                radioGroup.setTag(this.f153016c);
            }
            this.f153014a.setPositiveBtnText(this.f153017d);
            this.f153014a.setPositiveBtnListener(new DialogInterface.OnClickListener() { // from class: com.tencent.mm.ui.widget.dialog.MMConfirmDialog.Builder.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    String editTextValue;
                    if (iOnDialogClick != null) {
                        if (dialogInterface == null) {
                            editTextValue = null;
                        } else {
                            editTextValue = ((MMAlertDialog) dialogInterface).getEditTextValue();
                        }
                        iOnDialogClick.onDialogClick(true, editTextValue);
                    }
                }
            });
            return this;
        }

        public Builder positiveText(int i3) {
            String string = this.f153015b.getResources().getString(i3);
            this.f153017d = string;
            this.f153014a.setPositiveBtnText(string);
            return this;
        }

        public Builder setBackground(int i3) {
            this.f153014a.setBackground(i3);
            return this;
        }

        public Builder setDismissAfterClicked(boolean z16) {
            this.f153014a.setDismissAfterClicked(z16);
            return this;
        }

        public Builder setEditTextHint(String str) {
            this.f153014a.setEditTextHint(str);
            return this;
        }

        public void show() {
            if (this.f153015b instanceof Activity) {
                if (this.f153016c == null) {
                    this.f153016c = this.f153014a.create();
                }
                this.f153016c.show();
            } else {
                com.tencent.luggage.wxa.lo.a.a(this.f153014a);
                Intent intent = new Intent(this.f153015b, (Class<?>) com.tencent.luggage.wxa.lo.a.class);
                intent.setFlags(335544320);
                Context context = this.f153015b;
                com.tencent.luggage.wxa.fa.b.a(context, intent);
                context.startActivity(intent);
            }
        }

        public Builder showAlwayDark(boolean z16) {
            this.f153014a.showAlwayDark(z16);
            return this;
        }

        public MMAlertDialog showOnWindow() {
            if (this.f153016c == null) {
                this.f153016c = this.f153014a.create();
            }
            Window window = this.f153016c.getWindow();
            if (window != null) {
                if (Build.VERSION.SDK_INT >= 26) {
                    window.setType(2038);
                } else {
                    window.setType(2002);
                }
                window.addFlags(524288);
                n.a("dialog", "show top window not null!!", new Object[0]);
            }
            this.f153016c.show();
            return this.f153016c;
        }

        public void showTop() {
            if (this.f153015b instanceof Activity) {
                if (this.f153016c == null) {
                    this.f153016c = this.f153014a.create();
                }
                Window window = this.f153016c.getWindow();
                if (window != null) {
                    if (Build.VERSION.SDK_INT >= 26) {
                        window.setType(2038);
                    } else {
                        window.setType(2002);
                    }
                    n.a("dialog", "show top window not null!!", new Object[0]);
                }
                this.f153016c.show();
                return;
            }
            com.tencent.luggage.wxa.lo.a.a(this.f153014a);
            Intent intent = new Intent(this.f153015b, (Class<?>) com.tencent.luggage.wxa.lo.a.class);
            intent.setFlags(335544320);
            intent.putExtra("dialog_show_top", true);
            Context context = this.f153015b;
            com.tencent.luggage.wxa.fa.b.a(context, intent);
            context.startActivity(intent);
        }

        public Builder singleSelect(ArrayList<String> arrayList, RadioGroup.OnCheckedChangeListener onCheckedChangeListener, int i3) {
            int i16;
            View inflate = View.inflate(this.f153015b, R.layout.e67, null);
            this.f153019f = (RadioGroup) inflate.findViewById(R.id.f70023kb);
            if (arrayList != null) {
                i16 = arrayList.size();
            } else {
                i16 = 0;
            }
            for (int i17 = 0; i17 < i16; i17++) {
                RadioButton radioButton = (RadioButton) View.inflate(this.f153015b, R.layout.e66, null);
                radioButton.setId(i17);
                if (i17 == i3) {
                    radioButton.setChecked(true);
                }
                radioButton.setText(arrayList.get(i17));
                this.f153019f.addView(radioButton);
            }
            this.f153019f.setOnCheckedChangeListener(onCheckedChangeListener);
            this.f153014a.setView(inflate);
            return this;
        }

        public Builder title(CharSequence charSequence) {
            Context context = this.f153015b;
            o.a(context, (int) (o.b(context) * 20.0f));
            if (charSequence != null && charSequence.length() > 0) {
                charSequence = com.tencent.luggage.wxa.oo.a.a(this.f153015b, charSequence.toString());
            }
            this.f153014a.setTitle(charSequence);
            return this;
        }

        public Builder titleDesc(CharSequence charSequence) {
            Context context = this.f153015b;
            o.a(context, (int) (o.b(context) * 14.0f));
            if (charSequence != null && charSequence.length() > 0) {
                charSequence = com.tencent.luggage.wxa.oo.a.a(this.f153015b, charSequence.toString());
            }
            this.f153014a.setTitleDesc(charSequence);
            return this;
        }

        public Builder titleGravity(int i3) {
            this.f153014a.setTitleGravity(i3);
            return this;
        }

        public Builder upDownBtn(boolean z16) {
            this.f153014a.setBtnUpDown(z16);
            return this;
        }

        public Builder withCheckBoxclick(final IIOnDialogClick iIOnDialogClick) {
            RadioGroup radioGroup = this.f153019f;
            if (radioGroup != null) {
                radioGroup.setTag(this.f153016c);
            }
            String str = this.f153017d;
            if (str == null || str.length() == 0) {
                this.f153017d = this.f153015b.getResources().getString(R.string.f170648xe);
            }
            this.f153014a.setPositiveBtnText(this.f153017d);
            this.f153014a.setPositiveBtnListener(new DialogInterface.OnClickListener() { // from class: com.tencent.mm.ui.widget.dialog.MMConfirmDialog.Builder.7
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    String editTextValue;
                    boolean isChecked;
                    if (iIOnDialogClick != null) {
                        if (dialogInterface == null) {
                            editTextValue = null;
                        } else {
                            editTextValue = ((MMAlertDialog) dialogInterface).getEditTextValue();
                        }
                        if (dialogInterface == null) {
                            isChecked = false;
                        } else {
                            isChecked = ((MMAlertDialog) dialogInterface).getmCheckBox().isChecked();
                        }
                        iIOnDialogClick.onDialogClick(true, editTextValue, isChecked);
                    }
                }
            });
            String str2 = this.f153018e;
            if (str2 == null || str2.length() == 0) {
                this.f153018e = this.f153015b.getResources().getString(R.string.f170647xd);
            }
            this.f153014a.setNegativeBtnText(this.f153018e);
            this.f153014a.setNegativeBtnListener(new DialogInterface.OnClickListener() { // from class: com.tencent.mm.ui.widget.dialog.MMConfirmDialog.Builder.8
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    boolean isChecked;
                    if (iIOnDialogClick != null) {
                        if (dialogInterface == null) {
                            isChecked = false;
                        } else {
                            isChecked = ((MMAlertDialog) dialogInterface).getmCheckBox().isChecked();
                        }
                        iIOnDialogClick.onDialogClick(false, null, isChecked);
                    }
                }
            });
            return this;
        }

        public Builder withMultiSelectClick(final IOnMultiChoiceClickListener iOnMultiChoiceClickListener) {
            String str = this.f153017d;
            if (str == null || str.length() == 0) {
                this.f153017d = this.f153015b.getResources().getString(R.string.f170648xe);
            }
            String str2 = this.f153018e;
            if (str2 == null || str2.length() == 0) {
                this.f153018e = this.f153015b.getResources().getString(R.string.f170647xd);
            }
            this.f153014a.setNegativeBtnText(this.f153018e);
            this.f153014a.setPositiveBtnText(this.f153017d);
            this.f153014a.setPositiveBtnListener(new DialogInterface.OnClickListener() { // from class: com.tencent.mm.ui.widget.dialog.MMConfirmDialog.Builder.5
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    IOnMultiChoiceClickListener iOnMultiChoiceClickListener2 = iOnMultiChoiceClickListener;
                    if (iOnMultiChoiceClickListener2 != null) {
                        iOnMultiChoiceClickListener2.onDialogClick(true, Builder.this.f153022i);
                    }
                }
            });
            this.f153014a.setNegativeBtnListener(new DialogInterface.OnClickListener() { // from class: com.tencent.mm.ui.widget.dialog.MMConfirmDialog.Builder.6
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    IOnMultiChoiceClickListener iOnMultiChoiceClickListener2 = iOnMultiChoiceClickListener;
                    if (iOnMultiChoiceClickListener2 != null) {
                        iOnMultiChoiceClickListener2.onDialogClick(false, null);
                    }
                }
            });
            return this;
        }

        public Builder positiveText(String str) {
            this.f153017d = str;
            this.f153014a.setPositiveBtnText(str);
            return this;
        }

        public Builder click(IOnDialogClick iOnDialogClick) {
            RadioGroup radioGroup = this.f153019f;
            if (radioGroup != null) {
                radioGroup.setTag(this.f153016c);
            }
            positiveClick(iOnDialogClick);
            negativeClick(iOnDialogClick);
            return this;
        }
    }
}
