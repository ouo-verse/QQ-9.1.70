package com.tenpay.proxy.dlg;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ScrollSelectDlg {
    public static final String SPLITER = "|";
    private static final String TAG = "ScrollSelectDlg";
    ActionSheet actionSheet;
    private Context mContext;
    private IPickerListener mIPickerListener;
    IphonePickerView pickerView;
    private Map<Integer, Colum> data = new LinkedHashMap();
    IphonePickerView.IphonePickListener mListener = new IphonePickerView.IphonePickListener() { // from class: com.tenpay.proxy.dlg.ScrollSelectDlg.2
        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener
        public void onConfirmBtClicked() {
            String str;
            ScrollSelectDlg.this.actionSheet.dismiss();
            if (ScrollSelectDlg.this.mIPickerListener != null) {
                StringBuffer stringBuffer = new StringBuffer();
                for (Integer num : ScrollSelectDlg.this.data.keySet()) {
                    if (stringBuffer.length() > 0) {
                        str = "|" + ((Colum) ScrollSelectDlg.this.data.get(num)).choice;
                    } else {
                        str = ((Colum) ScrollSelectDlg.this.data.get(num)).choice;
                    }
                    stringBuffer.append(str);
                }
                ScrollSelectDlg.this.mIPickerListener.onChoice(stringBuffer.toString());
            }
        }

        @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener
        public void onItemSelected(int i3, int i16) {
            if (ScrollSelectDlg.this.data.containsKey(Integer.valueOf(i3))) {
                ((Colum) ScrollSelectDlg.this.data.get(Integer.valueOf(i3))).choiceIndex(i16);
            }
        }
    };

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class Colum {
        String choice;
        List<String> list;

        public Colum(List<String> list, String str) {
            this.list = list;
            this.choice = str;
        }

        public void choiceIndex(int i3) {
            String str;
            if (this.list.size() > i3) {
                str = this.list.get(i3);
            } else {
                str = this.choice;
            }
            this.choice = str;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface IPickerListener {
        void onChoice(String str);
    }

    ScrollSelectDlg(Context context) {
        this.mContext = context;
    }

    public static ScrollSelectDlg with(Context context) {
        return new ScrollSelectDlg(context);
    }

    public ScrollSelectDlg appendColumn(List<String> list, String str) {
        if (list != null && list.size() > 0 && !TextUtils.isEmpty(str)) {
            Map<Integer, Colum> map = this.data;
            map.put(Integer.valueOf(map.size()), new Colum(list, str));
            return this;
        }
        QQToast.makeText(this.mContext, "\u53c2\u6570\u4e0d\u5408\u6cd5", 0).show();
        return this;
    }

    public ScrollSelectDlg setPickerListener(IPickerListener iPickerListener) {
        this.mIPickerListener = iPickerListener;
        return this;
    }

    @SuppressLint({"NewApi"})
    public void show() {
        int i3;
        ActionSheet createMenuSheet = ActionSheet.createMenuSheet(this.mContext);
        this.actionSheet = createMenuSheet;
        DispatchActionMoveScrollView dispatchActionMoveScrollView = (DispatchActionMoveScrollView) createMenuSheet.findViewById(R.id.f163936cz);
        dispatchActionMoveScrollView.dispatchActionMove = true;
        dispatchActionMoveScrollView.setBackgroundResource(17170445);
        this.actionSheet.setCloseAutoRead(false);
        IphonePickerView iphonePickerView = (IphonePickerView) LayoutInflater.from(this.mContext).inflate(R.layout.avo, (ViewGroup) null);
        this.pickerView = iphonePickerView;
        iphonePickerView.initialize(new IphonePickerView.PickerViewAdapter() { // from class: com.tenpay.proxy.dlg.ScrollSelectDlg.1
            @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter
            public int getColumnCount() {
                return ScrollSelectDlg.this.data.size();
            }

            @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter
            public int getRowCount(int i16) {
                return ((Colum) ScrollSelectDlg.this.data.get(Integer.valueOf(i16))).list.size();
            }

            @Override // com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter
            public String getText(int i16, int i17) {
                return ((Colum) ScrollSelectDlg.this.data.get(Integer.valueOf(i16))).list.get(i17);
            }
        });
        this.pickerView.setPickListener(this.mListener);
        this.actionSheet.getWindow().setFlags(16777216, 16777216);
        this.actionSheet.setActionContentView(this.pickerView, null);
        for (int i16 = 0; i16 < this.data.size(); i16++) {
            Colum colum = this.data.get(Integer.valueOf(i16));
            IphonePickerView iphonePickerView2 = this.pickerView;
            if (colum.list.contains(colum.choice)) {
                i3 = colum.list.indexOf(colum.choice);
            } else {
                i3 = 0;
            }
            iphonePickerView2.setSelection(i16, i3);
        }
        try {
            this.actionSheet.show();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "", th5);
        }
    }

    public ScrollSelectDlg appendColumn(List<String> list) {
        if (list != null && list.size() > 0) {
            return appendColumn(list, list.get(0));
        }
        QQToast.makeText(this.mContext, "\u53c2\u6570\u4e0d\u5408\u6cd5", 0).show();
        return this;
    }
}
