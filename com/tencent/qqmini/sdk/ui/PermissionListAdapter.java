package com.tencent.qqmini.sdk.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.auth.AuthStateItem;
import com.tencent.qqmini.sdk.auth.PermissionInfo;
import com.tencent.qqmini.sdk.auth.PermissionManager;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.widget.FormSwitchItem;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes23.dex */
public class PermissionListAdapter extends BaseAdapter {
    CompoundButton.OnCheckedChangeListener checkedChangeListener;
    Context context;
    protected LayoutInflater mInflater;
    List<AuthStateItem> scopeList = new ArrayList();

    public PermissionListAdapter(Context context, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.context = context;
        this.checkedChangeListener = onCheckedChangeListener;
        this.mInflater = LayoutInflater.from(context);
    }

    public void changeChecked(String str, boolean z16) {
        int i3;
        for (AuthStateItem authStateItem : this.scopeList) {
            if (str.equals(authStateItem.scopeName)) {
                if (z16) {
                    i3 = 2;
                } else {
                    i3 = 4;
                }
                authStateItem.authFlag = i3;
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.scopeList.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        FormSwitchItem formSwitchItem;
        String str;
        if (view != null) {
            formSwitchItem = (FormSwitchItem) view;
        } else {
            formSwitchItem = new FormSwitchItem(this.context);
            formSwitchItem.setOnCheckedChangeListener(this.checkedChangeListener);
        }
        AuthStateItem item = getItem(i3);
        if (item != null) {
            boolean z16 = false;
            if (!QUAUtil.isQQApp() && !QUAUtil.isDemoApp() && "scope.appMsgSubscribed".equals(item.scopeName)) {
                formSwitchItem.setEnabled(false);
                formSwitchItem.setChecked(false);
            }
            if (item.authFlag == 2) {
                z16 = true;
            }
            formSwitchItem.setChecked(z16);
            formSwitchItem.getSwitch().setTag(item.scopeName);
            PermissionInfo scopePermission = PermissionManager.g().getScopePermission(item.scopeName);
            if (scopePermission != null) {
                str = scopePermission.name;
            } else {
                str = item.scopeName;
            }
            formSwitchItem.setText(str);
        }
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return formSwitchItem;
    }

    public void setScopeList(List<AuthStateItem> list) {
        this.scopeList.clear();
        if (list != null) {
            this.scopeList.addAll(list);
        }
    }

    @Override // android.widget.Adapter
    public AuthStateItem getItem(int i3) {
        if (i3 <= -1 || i3 >= this.scopeList.size()) {
            return null;
        }
        return this.scopeList.get(i3);
    }
}
