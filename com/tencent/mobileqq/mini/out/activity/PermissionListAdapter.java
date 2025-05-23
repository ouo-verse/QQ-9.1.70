package com.tencent.mobileqq.mini.out.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes33.dex */
public class PermissionListAdapter extends BaseAdapter {
    public static final int VIEW_TYPE_COUNT = 2;
    public static final int VIEW_TYPE_FORM_SIMPLE_ITEM = 1;
    public static final int VIEW_TYPE_FORM_SWITCH_ITEM = 0;
    CompoundButton.OnCheckedChangeListener checkedChangeListener;
    Context context;
    protected LayoutInflater mInflater;
    List<AuthorizeCenter.AuthorizeInfo> scopeList = new ArrayList();
    View.OnClickListener subMsgPermissionClickListener;

    public PermissionListAdapter(Context context, CompoundButton.OnCheckedChangeListener onCheckedChangeListener, View.OnClickListener onClickListener) {
        this.context = context;
        this.checkedChangeListener = onCheckedChangeListener;
        this.subMsgPermissionClickListener = onClickListener;
        this.mInflater = LayoutInflater.from(context);
    }

    public void changeChecked(String str, boolean z16) {
        for (AuthorizeCenter.AuthorizeInfo authorizeInfo : this.scopeList) {
            if (str.equals(authorizeInfo.scopeName)) {
                authorizeInfo.authFlag = z16 ? 2 : 4;
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

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        AuthorizeCenter.AuthorizeInfo item = getItem(i3);
        return (item == null || !"setting.appMsgSubscribed".equals(item.scopeName)) ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        FormSwitchItem formSwitchItem;
        AuthorizeCenter.AuthorizeInfo item = getItem(i3);
        if (item == null) {
            return null;
        }
        if ("setting.appMsgSubscribed".equals(item.scopeName)) {
            FormSimpleItem formSimpleItem = new FormSimpleItem(this.context);
            formSimpleItem.h(true);
            formSimpleItem.setLeftText(HardCodeUtil.qqStr(R.string.f167292cj));
            formSimpleItem.setOnClickListener(this.subMsgPermissionClickListener);
            if (QQTheme.isNowThemeIsNight()) {
                formSimpleItem.setBackgroundColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.ci9));
                formSimpleItem.setLeftTextColor(2);
                formSimpleItem.setRightTextColor(2);
                return formSimpleItem;
            }
            formSimpleItem.setBackgroundColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.ciw));
            formSimpleItem.setLeftTextColor(0);
            formSimpleItem.setRightTextColor(0);
            return formSimpleItem;
        }
        if (view instanceof FormSwitchItem) {
            formSwitchItem = (FormSwitchItem) view;
        } else {
            formSwitchItem = new FormSwitchItem(this.context);
        }
        formSwitchItem.getSwitch().setTag(item.scopeName);
        formSwitchItem.setOnCheckedChangeListener(null);
        formSwitchItem.setChecked(item.authFlag == 2);
        formSwitchItem.setOnCheckedChangeListener(this.checkedChangeListener);
        String str = AuthorizeCenter.settingScopeTitleMap.get(item.scopeName);
        if (str == null) {
            str = item.scopeName;
        }
        formSwitchItem.setText(str);
        if (QQTheme.isNowThemeIsNight()) {
            formSwitchItem.setBackgroundColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.ci9));
            formSwitchItem.setTextColor(BaseApplicationImpl.getApplication().getResources().getColorStateList(R.color.skin_white));
            formSwitchItem.getSwitch().setTrackResource(R.drawable.f161079k01);
            formSwitchItem.getSwitch().setThumbResource(R.drawable.f161078k00);
        } else {
            formSwitchItem.setBackgroundColor(BaseApplicationImpl.getApplication().getResources().getColor(R.color.ciw));
            formSwitchItem.setTextColor(BaseApplicationImpl.getApplication().getResources().getColorStateList(R.color.skin_black));
            formSwitchItem.getSwitch().setTrackResource(R.drawable.b58);
            formSwitchItem.getSwitch().setThumbResource(R.drawable.b57);
        }
        return formSwitchItem;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void setScopeList(List<AuthorizeCenter.AuthorizeInfo> list) {
        this.scopeList.clear();
        if (list != null) {
            this.scopeList.addAll(list);
        }
    }

    @Override // android.widget.Adapter
    public AuthorizeCenter.AuthorizeInfo getItem(int i3) {
        if (i3 <= -1 || i3 >= this.scopeList.size()) {
            return null;
        }
        return this.scopeList.get(i3);
    }
}
