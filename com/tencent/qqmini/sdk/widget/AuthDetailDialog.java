package com.tencent.qqmini.sdk.widget;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StExampleDetail;
import NS_MINI_INTERFACE.INTERFACE$StSubscribeMessage;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.sdk.R;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes23.dex */
public class AuthDetailDialog extends ReportDialog implements View.OnClickListener {
    private static final String TAG = "AuthDialog";
    public static final int TYPE_BOTTOM = 1;
    public static final int TYPE_CENTER = 2;
    private DetailAdapter detailAdapter;
    private int dialogType;
    private ImageView ivBack;
    private ListView lvDetail;
    private Activity mContext;
    private INTERFACE$StSubscribeMessage mCurSubMsg;
    private TextView tvCenterConfirm;
    private TextView tvTitle;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class DetailAdapter extends BaseAdapter {
        ArrayList<COMM.Entry> detailList = new ArrayList<>();

        /* compiled from: P */
        /* loaded from: classes23.dex */
        class DetailViewHolder {
            TextView tvDesc;
            TextView tvTitle;

            public DetailViewHolder(View view) {
                this.tvTitle = (TextView) view.findViewById(R.id.detail_item_title);
                this.tvDesc = (TextView) view.findViewById(R.id.detail_item_desc);
            }
        }

        DetailAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            ArrayList<COMM.Entry> arrayList = this.detailList;
            if (arrayList != null) {
                return arrayList.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            if (i3 > -1 && i3 < this.detailList.size()) {
                return this.detailList.get(i3);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            DetailViewHolder detailViewHolder;
            COMM.Entry entry = (COMM.Entry) getItem(i3);
            if (entry != null) {
                if (view != null) {
                    detailViewHolder = (DetailViewHolder) view.getTag();
                } else {
                    view = LayoutInflater.from(AuthDetailDialog.this.mContext).inflate(R.layout.mini_sdk_auth_detail_dialog_item_layout, (ViewGroup) null);
                    detailViewHolder = new DetailViewHolder(view);
                    view.setTag(detailViewHolder);
                }
                detailViewHolder.tvTitle.setText(entry.key.get());
                detailViewHolder.tvDesc.setText(entry.value.get());
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view;
        }

        public void setData(ArrayList<COMM.Entry> arrayList) {
            this.detailList = arrayList;
        }
    }

    public AuthDetailDialog(@NonNull Activity activity, INTERFACE$StSubscribeMessage iNTERFACE$StSubscribeMessage, int i3, int i16, int i17) {
        super(activity, R.style.mini_sdk_MiniAppAuthDetailDialog);
        this.dialogType = 1;
        this.mContext = activity;
        this.mCurSubMsg = iNTERFACE$StSubscribeMessage;
        setCanceledOnTouchOutside(true);
        this.dialogType = i17;
        if (1 == i17) {
            initBottomDialog(activity);
            Window window = getWindow();
            if (window != null) {
                window.setGravity(80);
                if (i3 > 0) {
                    WindowManager.LayoutParams attributes = getWindow().getAttributes();
                    attributes.height = i3;
                    attributes.width = i16;
                    window.setAttributes(attributes);
                    return;
                }
                return;
            }
            return;
        }
        if (2 == i17) {
            initCenterDialog(activity);
        }
    }

    private void initBottomDialog(@NonNull Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.mini_sdk_auth_detail_dialog, (ViewGroup) null);
        setContentView(inflate);
        this.ivBack = (ImageView) inflate.findViewById(R.id.iv_auth_detail_back);
        this.tvTitle = (TextView) inflate.findViewById(R.id.tv_auth_detail_title);
        this.lvDetail = (ListView) inflate.findViewById(R.id.lv_detail_items);
    }

    private void initCenterDialog(@NonNull Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.mini_sdk_auth_detail_dialog_center, (ViewGroup) null);
        setContentView(inflate);
        this.tvTitle = (TextView) inflate.findViewById(R.id.tv_auth_detail_title);
        this.tvCenterConfirm = (TextView) inflate.findViewById(R.id.tv_confirm);
        this.lvDetail = (ListView) inflate.findViewById(R.id.lv_detail_items);
    }

    private void initDetailList() {
        if (this.lvDetail == null) {
            return;
        }
        ArrayList<COMM.Entry> arrayList = new ArrayList<>(this.mCurSubMsg.example.contents.get());
        DetailAdapter detailAdapter = new DetailAdapter();
        this.detailAdapter = detailAdapter;
        detailAdapter.setData(arrayList);
        this.lvDetail.setAdapter((ListAdapter) this.detailAdapter);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.iv_auth_detail_back || id5 == R.id.tv_confirm) {
            dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        INTERFACE$StExampleDetail iNTERFACE$StExampleDetail;
        INTERFACE$StSubscribeMessage iNTERFACE$StSubscribeMessage = this.mCurSubMsg;
        if (iNTERFACE$StSubscribeMessage != null && (iNTERFACE$StExampleDetail = iNTERFACE$StSubscribeMessage.example) != null) {
            this.tvTitle.setText(iNTERFACE$StExampleDetail.title.get());
            initDetailList();
            int i3 = this.dialogType;
            if (2 == i3) {
                this.tvCenterConfirm.setOnClickListener(this);
            } else if (1 == i3) {
                this.ivBack.setOnClickListener(this);
            }
        }
        super.show();
    }
}
