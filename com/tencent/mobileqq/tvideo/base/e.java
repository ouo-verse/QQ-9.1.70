package com.tencent.mobileqq.tvideo.base;

import android.util.SparseIntArray;
import android.util.SparseLongArray;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.tencent.mobileqq.tvideo.base.TVideoLayerTabFragmentFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import org.light.utils.CollectionUtils;
import tvideo.TVideoChannelList$ReportMap;
import tvideo.TVideoChannelList$VideoChannelData;

/* compiled from: P */
/* loaded from: classes19.dex */
public class e extends FragmentStateAdapter {
    private final SparseIntArray C;
    private final Map<String, String> D;
    private final SparseLongArray E;
    private final Fragment F;

    /* renamed from: m, reason: collision with root package name */
    private List<TVideoChannelList$VideoChannelData> f304359m;

    public e(@NonNull Fragment fragment, List<TVideoChannelList$VideoChannelData> list, Map<String, String> map) {
        super(fragment);
        this.f304359m = list;
        this.D = map;
        this.C = new SparseIntArray();
        this.E = new SparseLongArray();
        this.F = fragment;
    }

    @NonNull
    private Fragment j0(int i3) {
        if (ab0.a.a(i3, this.f304359m)) {
            return TVideoLayerTabFragmentFactory.a();
        }
        TVideoChannelList$VideoChannelData tVideoChannelList$VideoChannelData = this.f304359m.get(i3);
        if (tVideoChannelList$VideoChannelData == null) {
            return TVideoLayerTabFragmentFactory.a();
        }
        int i16 = tVideoChannelList$VideoChannelData.channel_id.get();
        int i17 = tVideoChannelList$VideoChannelData.channel_page_type.get();
        if (this.C.indexOfKey(i3) >= 0) {
            i17 = this.C.get(i3);
            QLog.d("TVideoMultiTabFragmentAdapter", 1, "use tempType:" + i17);
        }
        String str = tVideoChannelList$VideoChannelData.page_url.get();
        String str2 = tVideoChannelList$VideoChannelData.page_module_name.get();
        Map<String, String> k06 = k0(tVideoChannelList$VideoChannelData.page_report_map.get());
        HashMap hashMap = new HashMap(this.D);
        if (ox2.b.e().g() != i16) {
            hashMap.put("cid", "");
            hashMap.put("vid", "");
            hashMap.put("material_vid", "");
        }
        hashMap.put("reportMap", new JSONObject(k06).toString());
        hashMap.put("channelId", i16 + "");
        hashMap.put("url", str);
        hashMap.put("moduleName", str2);
        return TVideoLayerTabFragmentFactory.b(i17, i16, hashMap);
    }

    private Map<String, String> k0(List<TVideoChannelList$ReportMap> list) {
        HashMap hashMap = new HashMap();
        if (list != null && list.size() != 0) {
            for (TVideoChannelList$ReportMap tVideoChannelList$ReportMap : list) {
                if (tVideoChannelList$ReportMap != null) {
                    hashMap.put(tVideoChannelList$ReportMap.key.get(), tVideoChannelList$ReportMap.value.get());
                }
            }
        }
        return hashMap;
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    @NonNull
    public Fragment createFragment(int i3) {
        QLog.d("TVideoMultiTabFragmentAdapter", 1, "createFragment:" + i3);
        Fragment j06 = j0(i3);
        Fragment fragment = this.F;
        if (fragment != null && fragment.getArguments() != null && j06 != null && j06.getArguments() != null) {
            j06.getArguments().putSerializable("key_bundle_common_init_bean", this.F.getArguments().getSerializable("key_bundle_common_init_bean"));
        }
        SparseLongArray sparseLongArray = this.E;
        if (sparseLongArray != null && j06 != null) {
            sparseLongArray.put(i3, j06.hashCode());
        }
        return j06;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.f304359m.size();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        if (ab0.a.a(i3, this.f304359m)) {
            return 0L;
        }
        if (this.E.get(i3) == -1) {
            return -1L;
        }
        if (this.f304359m.get(i3).channel_page_type.get() != 0) {
            return r0.hashCode();
        }
        return i3;
    }

    public void i0(int i3) {
        int indexOfKey;
        QLog.d("TVideoMultiTabFragmentAdapter", 1, "checkReset:" + i3);
        if (!ab0.a.a(i3, this.f304359m) && (indexOfKey = this.C.indexOfKey(i3)) >= 0) {
            this.C.removeAt(indexOfKey);
            this.E.put(i3, -1L);
        }
    }

    public void l0(int i3) {
        QLog.d("TVideoMultiTabFragmentAdapter", 1, "resetAll:" + i3);
        if (this.E.size() == 0) {
            return;
        }
        for (int i16 = 0; i16 < this.E.size(); i16++) {
            int keyAt = this.E.keyAt(i16);
            if (keyAt != i3) {
                if (this.E.get(keyAt) != -1) {
                    this.E.put(keyAt, -1L);
                }
                int indexOfKey = this.C.indexOfKey(keyAt);
                if (indexOfKey >= 0) {
                    this.C.removeAt(indexOfKey);
                }
                notifyItemChanged(keyAt);
            }
        }
    }

    public void m0(List<TVideoChannelList$VideoChannelData> list) {
        if (!CollectionUtils.isEmpty(list)) {
            QLog.d("TVideoMultiTabFragmentAdapter", 1, "updateChannelList");
            this.f304359m = list;
            notifyDataSetChanged();
        }
    }

    public void n0(String str, String str2) {
        Map<String, String> map = this.D;
        if (map != null) {
            map.put(str, str2);
        }
    }

    public void o0(int i3, @TVideoLayerTabFragmentFactory.TVideoLayerTabFragmentType int i16) {
        TVideoChannelList$VideoChannelData tVideoChannelList$VideoChannelData;
        QLog.d("TVideoMultiTabFragmentAdapter", 1, "updateItem:" + i3);
        if (ab0.a.a(i3, this.f304359m) || (tVideoChannelList$VideoChannelData = this.f304359m.get(i3)) == null || tVideoChannelList$VideoChannelData.channel_page_type.get() == i16) {
            return;
        }
        this.C.put(i3, i16);
        if (this.E.indexOfKey(i3) >= 0) {
            this.E.put(i3, -1L);
        }
        notifyItemChanged(i3);
    }
}
