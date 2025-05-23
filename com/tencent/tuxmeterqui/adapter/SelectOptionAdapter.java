package com.tencent.tuxmeterqui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qui.profileskin.widget.QUITextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tuxmeterqui.model.SelectOptionModel;
import ie0.a;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class SelectOptionAdapter extends RecyclerView.Adapter<ViewHolder> {
    static IPatchRedirector $redirector_;
    private Context context;
    private OnItemClickListener listener;
    private final int primaryColor;
    private final String selectOptionItemCopy;
    private final List<SelectOptionModel> selectOptions;
    private final int textColor;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnItemClickListener {
        void onItemClick(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;
        QUITextView optionID;
        QUITextView optionName;
        QUITextView optionNameCopy;

        public ViewHolder(@NonNull View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
                return;
            }
            this.optionName = (QUITextView) view.findViewById(R.id.f10478649);
            this.optionID = (QUITextView) view.findViewById(R.id.f1048464e);
            this.optionNameCopy = (QUITextView) view.findViewById(R.id.f1048164b);
        }
    }

    public SelectOptionAdapter(Context context, List<SelectOptionModel> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) list);
            return;
        }
        this.context = context;
        this.selectOptions = list;
        this.selectOptionItemCopy = pickLongestEvery(list);
        this.primaryColor = a.f().g(context, R.color.qui_common_brand_standard, 1000);
        this.textColor = a.f().g(context, R.color.qui_common_text_primary, 1000);
    }

    private static String pickLongestEvery(List<SelectOptionModel> list) {
        int size = list.size();
        String str = "";
        for (int i3 = 0; i3 < size; i3++) {
            String text = list.get(i3).getOption().getText();
            if (text.getBytes().length > str.getBytes().length) {
                str = text;
            }
        }
        return str;
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
        viewHolder.optionID.setText(selectOptionModel.getOption().getId());
        viewHolder.optionName.setText(selectOptionModel.getOption().getText());
        viewHolder.optionNameCopy.setText(this.selectOptionItemCopy);
        if (selectOptionModel.isSelect()) {
            viewHolder.optionName.setBackgroundResource(R.drawable.lxv);
            viewHolder.optionName.setTextColor(this.primaryColor);
        } else {
            viewHolder.optionName.setBackgroundResource(R.drawable.lxy);
            viewHolder.optionName.setTextColor(this.textColor);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener(viewHolder) { // from class: com.tencent.tuxmeterqui.adapter.SelectOptionAdapter.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ ViewHolder val$holder;

            {
                this.val$holder = viewHolder;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SelectOptionAdapter.this, (Object) viewHolder);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) view);
                } else if (SelectOptionAdapter.this.listener != null) {
                    SelectOptionAdapter.this.listener.onItemClick(this.val$holder.getAdapterPosition());
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new ViewHolder(LayoutInflater.from(this.context).inflate(R.layout.i26, viewGroup, false)) : (ViewHolder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewGroup, i3);
    }
}
