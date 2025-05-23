package com.tencent.mobileqq.matchfriend.reborn.content.msg.tab;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.sub.fragment.QQStrangerMsgListFragment;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.sub.fragment.QQStrangerOftenChatListFragment;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0007H\u0016R\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/tab/a;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/tab/b;", "infoList", "", "i0", "", "getItemCount", "position", "Landroidx/fragment/app/Fragment;", "createFragment", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "tabInfoList", "hostFragment", "<init>", "(Landroidx/fragment/app/Fragment;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class a extends FragmentStateAdapter {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private List<QQStrangerMsgSubFragmentInfo> tabInfoList;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f244813a;

        static {
            int[] iArr = new int[QQStrangerMsgSubFragmentType.values().length];
            try {
                iArr[QQStrangerMsgSubFragmentType.MSG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[QQStrangerMsgSubFragmentType.OFTEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f244813a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Fragment hostFragment) {
        super(hostFragment);
        Intrinsics.checkNotNullParameter(hostFragment, "hostFragment");
        this.tabInfoList = new ArrayList();
    }

    @Override // androidx.viewpager2.adapter.FragmentStateAdapter
    public Fragment createFragment(int position) {
        QQStrangerMsgSubFragmentType type = this.tabInfoList.get(position).getType();
        QLog.i("QQStrangerMsgSubFragmentAdapter", 1, "createFragment position:" + position + ", currentTab:" + type);
        int i3 = b.f244813a[type.ordinal()];
        if (i3 == 1) {
            return new QQStrangerMsgListFragment();
        }
        if (i3 == 2) {
            return new QQStrangerOftenChatListFragment();
        }
        throw new IllegalArgumentException("invalid stranger msg sub fragment! position:" + position + " -> " + type);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.tabInfoList.size();
    }

    public final void i0(List<QQStrangerMsgSubFragmentInfo> infoList) {
        Intrinsics.checkNotNullParameter(infoList, "infoList");
        this.tabInfoList = infoList;
        notifyDataSetChanged();
    }
}
