package com.tenpay.sdk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class JobSelectionActivity extends NetBaseActivity implements AdapterView.OnItemClickListener, View.OnClickListener {
    public static final int NOT_SELECT_PROFESSION = -1;
    public static final String PARAM_SELECTED_JOB = "param_selected_job";
    private static final String[] sJobList = {"\u515a\u653f\u673a\u5173\u4eba\u5458", "\u4f01\u4e8b\u4e1a\u5355\u4f4d\u5de5\u4f5c\u4eba\u5458", "\u5546\u4e1a\u53ca\u670d\u52a1\u4e1a\u5de5\u4f5c\u4eba\u5458", "\u519c\u6797\u7267\u6e14\u52b3\u52a8\u8005", "\u751f\u4ea7\u3001\u8fd0\u8f93\u8bbe\u5907\u64cd\u4f5c\u4eba\u5458\u53ca\u6709\u5173\u4eba\u5458", "\u5404\u7c7b\u4e13\u4e1a\u6280\u672f\u4eba\u5458", "\u5b66\u751f", "\u519b\u4eba", "\u65e0\u4e1a", "\u5176\u4ed6"};
    private Adapter mAdapter;
    private String mSelectedJob;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private class Adapter extends BaseAdapter {
        Adapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return JobSelectionActivity.sJobList.length;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            return JobSelectionActivity.sJobList[i3];
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = JobSelectionActivity.this.getLayoutInflater().inflate(R.layout.hry, viewGroup, false);
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.name = (TextView) view.findViewById(R.id.f5e);
                viewHolder.checkImg = (ImageView) view.findViewById(R.id.ax4);
                view.setTag(viewHolder);
            }
            ViewHolder viewHolder2 = (ViewHolder) view.getTag();
            String str = (String) getItem(i3);
            viewHolder2.name.setText(str);
            if (TextUtils.equals(JobSelectionActivity.this.mSelectedJob, str)) {
                viewHolder2.checkImg.setVisibility(0);
            } else {
                viewHolder2.checkImg.setVisibility(4);
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return view;
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static class ViewHolder {
        public ImageView checkImg;
        public TextView name;

        ViewHolder() {
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view.getId() == R.id.ivTitleBtnLeft) {
            finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.f168583af4, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.f166816if4);
        findViewById.setBackgroundColor(-1);
        ((TextView) inflate.findViewById(R.id.ivTitleBtnLeft)).setOnClickListener(this);
        ((TextView) findViewById.findViewById(R.id.ivTitleName)).setText("\u804c\u4e1a");
        this.mSelectedJob = getIntent().getStringExtra(PARAM_SELECTED_JOB);
        ListView listView = (ListView) inflate.findViewById(R.id.ebs);
        listView.setOnItemClickListener(this);
        Adapter adapter = new Adapter();
        this.mAdapter = adapter;
        listView.setAdapter((ListAdapter) adapter);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
        EventCollector.getInstance().onItemClickBefore(adapterView, view, i3, j3);
        this.mSelectedJob = sJobList[i3];
        this.mAdapter.notifyDataSetChanged();
        Intent intent = new Intent();
        intent.putExtra(PARAM_SELECTED_JOB, this.mSelectedJob);
        setResult(-1, intent);
        finish();
        EventCollector.getInstance().onItemClick(adapterView, view, i3, j3);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
