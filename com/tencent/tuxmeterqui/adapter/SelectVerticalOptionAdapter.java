package com.tencent.tuxmeterqui.adapter;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qui.profileskin.widget.QUIEditText;
import com.tencent.biz.qui.profileskin.widget.QUIFrameLayout;
import com.tencent.biz.qui.profileskin.widget.QUITextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tuxmeterqui.model.SelectOptionModel;
import com.tencent.tuxmetersdk.model.BlankConfig;
import com.tencent.tuxmetersdk.model.Option;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class SelectVerticalOptionAdapter extends RecyclerView.Adapter<ViewHolder> {
    static IPatchRedirector $redirector_;
    private final Context context;
    private final boolean isSingle;
    private OnItemClickListener listener;
    private final List<SelectOptionModel> selectOptions;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnItemClickListener {
        void onItemClick(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;
        CheckBox checkBox;
        QUIEditText editText;
        QUITextView optionID;
        QUITextView optionName;
        QUIFrameLayout selectCheckboxView;
        TextWatcher textWatcher;

        public ViewHolder(@NonNull View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
                return;
            }
            this.optionName = (QUITextView) view.findViewById(R.id.f10478649);
            this.optionID = (QUITextView) view.findViewById(R.id.f1048464e);
            this.selectCheckboxView = (QUIFrameLayout) view.findViewById(R.id.f1048064a);
            this.checkBox = (CheckBox) view.findViewById(R.id.f1047964_);
            this.editText = (QUIEditText) view.findViewById(R.id.f1048264c);
        }

        public void addTextWatcher(Option option) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) option);
                return;
            }
            TextWatcher textWatcher = new TextWatcher(option) { // from class: com.tencent.tuxmeterqui.adapter.SelectVerticalOptionAdapter.ViewHolder.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ Option val$option;

                {
                    this.val$option = option;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ViewHolder.this, (Object) option);
                    }
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                        iPatchRedirector2.redirect((short) 4, (Object) this, (Object) editable);
                    } else {
                        this.val$option.setOtherText(editable.toString());
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                    }
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                    }
                }
            };
            this.textWatcher = textWatcher;
            this.editText.addTextChangedListener(textWatcher);
        }

        public void removeTextWatcher() {
            TextWatcher textWatcher;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            QUIEditText qUIEditText = this.editText;
            if (qUIEditText != null && (textWatcher = this.textWatcher) != null) {
                qUIEditText.removeTextChangedListener(textWatcher);
            }
        }
    }

    public SelectVerticalOptionAdapter(Context context, List<SelectOptionModel> list, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, list, Boolean.valueOf(z16));
            return;
        }
        this.context = context;
        this.selectOptions = list;
        this.isSingle = z16;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.selectOptions.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) onItemClickListener);
        } else {
            this.listener = onItemClickListener;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) viewHolder, i3);
            return;
        }
        SelectOptionModel selectOptionModel = this.selectOptions.get(i3);
        if (this.isSingle) {
            viewHolder.checkBox.setButtonDrawable(R.drawable.ly_);
        } else {
            viewHolder.checkBox.setButtonDrawable(R.drawable.lxp);
        }
        Option option = selectOptionModel.getOption();
        viewHolder.optionID.setText(option.getId());
        viewHolder.optionName.setText(option.getText());
        viewHolder.checkBox.setChecked(selectOptionModel.isSelect());
        if (option.isAddBlank() && option.getBlankConfig() != null) {
            viewHolder.editText.setVisibility(0);
            BlankConfig blankConfig = option.getBlankConfig();
            viewHolder.editText.setHint(blankConfig.getTip());
            viewHolder.editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(blankConfig.getMaxLen())});
            viewHolder.addTextWatcher(option);
        } else {
            viewHolder.editText.setVisibility(8);
        }
        viewHolder.editText.setEnabled(selectOptionModel.isSelect());
        if (selectOptionModel.isSelect() && option.isAddBlank() && option.getBlankConfig() != null) {
            viewHolder.editText.requestFocus();
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener(viewHolder) { // from class: com.tencent.tuxmeterqui.adapter.SelectVerticalOptionAdapter.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ ViewHolder val$holder;

            {
                this.val$holder = viewHolder;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SelectVerticalOptionAdapter.this, (Object) viewHolder);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                } else if (SelectVerticalOptionAdapter.this.listener != null) {
                    SelectVerticalOptionAdapter.this.listener.onItemClick(this.val$holder.getAdapterPosition());
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new ViewHolder(LayoutInflater.from(this.context).inflate(R.layout.i29, viewGroup, false)) : (ViewHolder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewGroup, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NonNull ViewHolder viewHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) viewHolder);
        } else {
            super.onViewDetachedFromWindow((SelectVerticalOptionAdapter) viewHolder);
            viewHolder.removeTextWatcher();
        }
    }
}
