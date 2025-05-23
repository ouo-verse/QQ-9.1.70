package fi0;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.tencent.ecommerce.biz.live.ui.ECLiveWindowSubFragment;
import com.tencent.ecommerce.repo.live.TabInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\n\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0007H\u0016R&\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00030\fj\b\u0012\u0004\u0012\u00020\u0003`\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lfi0/b;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "", "Lcom/tencent/ecommerce/repo/live/TabInfo;", "tabInfoList", "", "setData", "", "getItemCount", "position", "Landroidx/fragment/app/Fragment;", "createFragment", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "tabList", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/fragment/app/Fragment;", "fragment", "<init>", "(Landroidx/fragment/app/Fragment;)V", "D", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class b extends FragmentStateAdapter {

    /* renamed from: C, reason: from kotlin metadata */
    private final Fragment fragment;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ArrayList<TabInfo> tabList;

    public b(Fragment fragment) {
        super(fragment);
        this.fragment = fragment;
        this.tabList = new ArrayList<>();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment createFragment(int position) {
        cg0.a.b("ECLiveWindowViewPagerAdapter", "createFragment position:" + position);
        this.tabList.get(position).b(position);
        ECLiveWindowSubFragment c16 = ECLiveWindowSubFragment.INSTANCE.c();
        Bundle bundle = new Bundle();
        bundle.putParcelable("KEY_TAB_INFO", this.tabList.get(position));
        bundle.putAll(this.fragment.getArguments());
        c16.setArguments(bundle);
        return c16;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.tabList.size();
    }

    public final void setData(List<TabInfo> tabInfoList) {
        this.tabList.clear();
        if (tabInfoList != null) {
            List<TabInfo> list = tabInfoList;
            if (!list.isEmpty()) {
                this.tabList.addAll(list);
            }
        }
        notifyDataSetChanged();
    }
}
