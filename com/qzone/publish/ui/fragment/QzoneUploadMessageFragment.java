package com.qzone.publish.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.qzone.common.protocol.INetworkCallback;
import com.qzone.publish.business.task.QZoneQueueTask;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneUploadMessageFragment extends Fragment {
    private ListView C;
    private a D;

    private void ph(Bundle bundle) {
        this.D = new a(bundle);
    }

    public static Bundle rh(QZoneQueueTask qZoneQueueTask) {
        Bundle bundle = new Bundle();
        if (qZoneQueueTask != null) {
            int i3 = qZoneQueueTask.mResultCode;
            String str = qZoneQueueTask.f45835msg;
            long batchId = qZoneQueueTask.getBatchId();
            String photoSource = qZoneQueueTask.getPhotoSource();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("batch id : ");
            stringBuffer.append(batchId);
            stringBuffer.append("\n");
            stringBuffer.append("pic path : ");
            stringBuffer.append(qh(photoSource));
            stringBuffer.append("\n");
            stringBuffer.append("res code : ");
            stringBuffer.append(i3);
            stringBuffer.append("\n");
            stringBuffer.append("res message : ");
            stringBuffer.append(qh(str));
            stringBuffer.append("\n");
            bundle.putString("res_msg", stringBuffer.toString());
            INetworkCallback iNetworkCallback = qZoneQueueTask.mRequest;
            if (iNetworkCallback instanceof y8.a) {
                bundle.putString("flow_msg", qh(((y8.a) iNetworkCallback).getFlowMessage()));
            }
        }
        return bundle;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ph(getArguments());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a extends BaseAdapter {

        /* renamed from: d, reason: collision with root package name */
        private String[] f51893d = {"", ""};

        public a(Bundle bundle) {
            if (bundle == null) {
                return;
            }
            String string = bundle.getString("res_msg", "");
            String string2 = bundle.getString("flow_msg", "");
            String[] strArr = this.f51893d;
            strArr[0] = string;
            strArr[1] = string2;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f51893d.length;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            return this.f51893d[i3];
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            TextView textView;
            if (view == null) {
                textView = new TextView(QzoneUploadMessageFragment.this.getActivity());
                textView.setText(this.f51893d[i3]);
            } else {
                textView = (TextView) view;
            }
            EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
            return textView;
        }
    }

    private static String qh(String str) {
        return str == null ? "" : str;
    }

    private void initView(View view) {
        ListView listView = (ListView) view.findViewById(R.id.ei6);
        this.C = listView;
        listView.setAdapter((ListAdapter) this.D);
        this.D.notifyDataSetChanged();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.bqb, viewGroup, false);
        initView(inflate);
        return inflate;
    }
}
