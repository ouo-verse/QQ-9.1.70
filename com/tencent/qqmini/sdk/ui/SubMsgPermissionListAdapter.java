package com.tencent.qqmini.sdk.ui;

import NS_MINI_INTERFACE.INTERFACE$StSubscribeMessage;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.launcher.widget.Switch;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes23.dex */
public class SubMsgPermissionListAdapter extends BaseAdapter implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private CompoundButton.OnCheckedChangeListener checkedChangeListener;
    private Context context;
    private CompoundButton.OnCheckedChangeListener innerCheckedChangeListener;
    private View.OnClickListener innerOnClickListener;
    private LayoutInflater mInflater;
    private List<INTERFACE$StSubscribeMessage> subMsgMaintainAuth = new ArrayList();

    /* loaded from: classes23.dex */
    private static final class ViewHolder {
        Switch authSwitcher;
        ImageView ivAuthDetail;
        TextView tvAuthTitle;

        ViewHolder() {
        }
    }

    public SubMsgPermissionListAdapter(Context context, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.context = context;
        this.checkedChangeListener = onCheckedChangeListener;
        this.mInflater = LayoutInflater.from(context);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.subMsgMaintainAuth.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        INTERFACE$StSubscribeMessage item = getItem(i3);
        if (item != null) {
            if (view != null) {
                viewHolder = (ViewHolder) view.getTag();
            } else {
                viewHolder = new ViewHolder();
                view = this.mInflater.inflate(R.layout.mini_sdk_once_sub_item_switcher, (ViewGroup) null);
                viewHolder.tvAuthTitle = (TextView) view.findViewById(R.id.tv_auth_title);
                viewHolder.ivAuthDetail = (ImageView) view.findViewById(R.id.iv_auth_detail);
                viewHolder.authSwitcher = (Switch) view.findViewById(R.id.sw_auth);
                view.setTag(viewHolder);
            }
            viewHolder.tvAuthTitle.setText(item.example.title.get());
            viewHolder.ivAuthDetail.setTag(item);
            viewHolder.ivAuthDetail.setOnClickListener(this);
            viewHolder.authSwitcher.setTag(item);
            Switch r26 = viewHolder.authSwitcher;
            boolean z16 = true;
            if (item.authState.get() != 1) {
                z16 = false;
            }
            r26.setChecked(z16);
            viewHolder.authSwitcher.setOnCheckedChangeListener(this);
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return view;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.innerCheckedChangeListener;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(compoundButton, z16);
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        View.OnClickListener onClickListener = this.innerOnClickListener;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setInnerCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.innerCheckedChangeListener = onCheckedChangeListener;
    }

    public void setInnerOnClickListener(View.OnClickListener onClickListener) {
        this.innerOnClickListener = onClickListener;
    }

    public void setSubMsgMaintainAuth(List<INTERFACE$StSubscribeMessage> list) {
        this.subMsgMaintainAuth.clear();
        if (list != null) {
            this.subMsgMaintainAuth.addAll(list);
        }
    }

    public void updateSubMsgItem(INTERFACE$StSubscribeMessage iNTERFACE$StSubscribeMessage, boolean z16) {
        int i3;
        for (INTERFACE$StSubscribeMessage iNTERFACE$StSubscribeMessage2 : this.subMsgMaintainAuth) {
            if (iNTERFACE$StSubscribeMessage2.templateId.get().equals(iNTERFACE$StSubscribeMessage.templateId.get())) {
                if (z16) {
                    i3 = 1;
                } else {
                    i3 = 2;
                }
                iNTERFACE$StSubscribeMessage2.authState.set(i3);
            }
        }
    }

    @Override // android.widget.Adapter
    public INTERFACE$StSubscribeMessage getItem(int i3) {
        if (i3 <= -1 || i3 >= this.subMsgMaintainAuth.size()) {
            return null;
        }
        return this.subMsgMaintainAuth.get(i3);
    }
}
