package com.tencent.mobileqq.mini.mainpage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.mainpage.PhoneNumberManageAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* loaded from: classes33.dex */
public class PhoneNumberManageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int ADD_PHONE_NUMBER_TYPE = 1;
    public static final int PHONE_NUMBER_ITEM_TYPE = 0;
    public static final String TAG = "PhoneNumberManageAdapter";
    private View.OnClickListener mAddPhoneOnClickListener;
    private DeletePhoneNumberCallBack mDeletePhoneNumberCallBack;
    private List<PhoneNumberManageItem> mPhoneNumberItems;

    /* loaded from: classes33.dex */
    private static class AddPhoneNumberItemViewHolder extends RecyclerView.ViewHolder {
        public TextView phoneNumberManageTv;

        public AddPhoneNumberItemViewHolder(View view) {
            super(view);
            this.phoneNumberManageTv = (TextView) view.findViewById(R.id.z8r);
        }

        public void bindViewHolder(View.OnClickListener onClickListener) {
            this.phoneNumberManageTv.setOnClickListener(onClickListener);
        }
    }

    /* loaded from: classes33.dex */
    public interface DeletePhoneNumberCallBack {
        void deletePhoneNumber(String str);
    }

    /* loaded from: classes33.dex */
    private static class PhoneNumberItemViewHolder extends RecyclerView.ViewHolder {
        public TextView defaultPhoneNumberTv;
        public ImageView deletePhoneNumberIv;
        public View dividerLine;
        public TextView phoneNumberTv;

        public PhoneNumberItemViewHolder(View view) {
            super(view);
            this.deletePhoneNumberIv = (ImageView) view.findViewById(R.id.z8h);
            this.phoneNumberTv = (TextView) view.findViewById(R.id.z8m);
            this.defaultPhoneNumberTv = (TextView) view.findViewById(R.id.z8l);
            this.dividerLine = view.findViewById(R.id.z89);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$bindViewHolder$0(DeletePhoneNumberCallBack deletePhoneNumberCallBack, PhoneNumberManageItem phoneNumberManageItem, View view) {
            deletePhoneNumberCallBack.deletePhoneNumber(phoneNumberManageItem.getPhoneNumberID());
        }

        public void bindViewHolder(final PhoneNumberManageItem phoneNumberManageItem, final DeletePhoneNumberCallBack deletePhoneNumberCallBack, boolean z16) {
            boolean z17 = phoneNumberManageItem.getPhoneType() == 0;
            if (phoneNumberManageItem.isEditState() && !z17) {
                this.deletePhoneNumberIv.setVisibility(0);
                this.deletePhoneNumberIv.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.mini.mainpage.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PhoneNumberManageAdapter.PhoneNumberItemViewHolder.lambda$bindViewHolder$0(PhoneNumberManageAdapter.DeletePhoneNumberCallBack.this, phoneNumberManageItem, view);
                    }
                });
            } else {
                this.deletePhoneNumberIv.setVisibility(8);
                this.deletePhoneNumberIv.setOnClickListener(null);
            }
            if (z17) {
                this.defaultPhoneNumberTv.setVisibility(0);
            } else {
                this.defaultPhoneNumberTv.setVisibility(8);
            }
            if (z16) {
                this.dividerLine.setVisibility(8);
            } else {
                this.dividerLine.setVisibility(0);
            }
            this.phoneNumberTv.setText(phoneNumberManageItem.getPurePhoneNumber());
        }
    }

    public void addPhoneNumberClickListener(View.OnClickListener onClickListener) {
        this.mAddPhoneOnClickListener = onClickListener;
    }

    public void deletePhoneNumberCallBack(DeletePhoneNumberCallBack deletePhoneNumberCallBack) {
        this.mDeletePhoneNumberCallBack = deletePhoneNumberCallBack;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mPhoneNumberItems.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        return this.mPhoneNumberItems.get(i3).getItemType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        int itemViewType = getItemViewType(i3);
        QLog.d(TAG, 1, "onBindViewHolder itemViewType:" + itemViewType);
        if (1 == itemViewType) {
            ((AddPhoneNumberItemViewHolder) viewHolder).bindViewHolder(this.mAddPhoneOnClickListener);
        } else if (itemViewType == 0) {
            ((PhoneNumberItemViewHolder) viewHolder).bindViewHolder(this.mPhoneNumberItems.get(i3), this.mDeletePhoneNumberCallBack, this.mPhoneNumberItems.size() - 1 == i3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        QLog.d(TAG, 1, "onCreateViewHolder viewType:" + i3);
        if (1 == i3) {
            return new AddPhoneNumberItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fhh, viewGroup, false));
        }
        return new PhoneNumberItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fhq, viewGroup, false));
    }

    public void updateData(List<PhoneNumberManageItem> list) {
        this.mPhoneNumberItems = list;
        notifyDataSetChanged();
    }
}
