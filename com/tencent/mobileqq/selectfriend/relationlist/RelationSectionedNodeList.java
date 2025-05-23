package com.tencent.mobileqq.selectfriend.relationlist;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.selectfriend.relationlist.group.GroupedListAdapter;
import com.tencent.mobileqq.selectfriend.relationlist.normal.NormalListAdapter;
import com.tencent.mobileqq.selectfriend.relationlist.vm.ListType;
import com.tencent.widget.PinnedHeaderExpandableListView;
import com.tencent.widget.XListView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 22\u00020\u0001:\u0001\rB/\b\u0007\u0012\u0006\u0010*\u001a\u00020)\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+\u0012\b\b\u0002\u0010-\u001a\u00020\u000b\u0012\u0006\u0010/\u001a\u00020.\u00a2\u0006\u0004\b0\u00101J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/relationlist/RelationSectionedNodeList;", "Lcom/tencent/mobileqq/selectfriend/relationlist/BaseRelationSectionedNodeList;", "", "fromNet", "", "e", "c", "d", "targetMode", "needAnim", "setMultiSelectMode", "", "groupPos", "a", "Lcom/tencent/widget/XListView;", "f", "Lcom/tencent/widget/XListView;", "normalListView", "Lcom/tencent/mobileqq/selectfriend/relationlist/normal/NormalListAdapter;", h.F, "Lcom/tencent/mobileqq/selectfriend/relationlist/normal/NormalListAdapter;", "normalAdapter", "Lcom/tencent/widget/PinnedHeaderExpandableListView;", "i", "Lcom/tencent/widget/PinnedHeaderExpandableListView;", "groupListView", "Lcom/tencent/mobileqq/selectfriend/relationlist/group/GroupedListAdapter;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/selectfriend/relationlist/group/GroupedListAdapter;", "groupAdapter", "Lcom/tencent/mobileqq/selectfriend/relationlist/vm/b;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/selectfriend/relationlist/vm/b;", "viewModel", "Lcom/tencent/mobileqq/selectfriend/relationlist/b;", "D", "Lcom/tencent/mobileqq/selectfriend/relationlist/b;", "listChangeListener", "E", "Z", "isMultiSelectMode", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "Lcom/tencent/mobileqq/selectfriend/relationlist/model/a;", "model", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/tencent/mobileqq/selectfriend/relationlist/model/a;)V", UserInfo.SEX_FEMALE, "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class RelationSectionedNodeList extends BaseRelationSectionedNodeList {

    /* renamed from: C, reason: from kotlin metadata */
    private com.tencent.mobileqq.selectfriend.relationlist.vm.b viewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private com.tencent.mobileqq.selectfriend.relationlist.b listChangeListener;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean isMultiSelectMode;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private XListView normalListView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private NormalListAdapter normalAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private PinnedHeaderExpandableListView groupListView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private GroupedListAdapter groupAdapter;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f285553a;

        static {
            int[] iArr = new int[ListType.values().length];
            try {
                iArr[ListType.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ListType.GROUPED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f285553a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/selectfriend/relationlist/RelationSectionedNodeList$c", "Lcom/tencent/mobileqq/selectfriend/relationlist/b;", "", "Lcom/tencent/mobileqq/selectfriend/relationlist/SharedNode;", "changedList", "", "b", "sharedNode", "a", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements com.tencent.mobileqq.selectfriend.relationlist.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.selectfriend.relationlist.model.a f285554a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ RelationSectionedNodeList f285555b;

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes35.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f285556a;

            static {
                int[] iArr = new int[ListType.values().length];
                try {
                    iArr[ListType.NORMAL.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ListType.GROUPED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f285556a = iArr;
            }
        }

        c(com.tencent.mobileqq.selectfriend.relationlist.model.a aVar, RelationSectionedNodeList relationSectionedNodeList) {
            this.f285554a = aVar;
            this.f285555b = relationSectionedNodeList;
        }

        @Override // com.tencent.mobileqq.selectfriend.relationlist.b
        public void a(SharedNode sharedNode) {
            Intrinsics.checkNotNullParameter(sharedNode, "sharedNode");
        }

        @Override // com.tencent.mobileqq.selectfriend.relationlist.b
        public void b(List<SharedNode> changedList) {
            GroupedListAdapter groupedListAdapter;
            int i3 = a.f285556a[this.f285554a.b().ordinal()];
            if (i3 != 1) {
                if (i3 == 2 && (groupedListAdapter = this.f285555b.groupAdapter) != null) {
                    groupedListAdapter.notifyDataSetChanged();
                    return;
                }
                return;
            }
            NormalListAdapter normalListAdapter = this.f285555b.normalAdapter;
            if (normalListAdapter != null) {
                normalListAdapter.notifyDataSetChanged();
            }
        }
    }

    public /* synthetic */ RelationSectionedNodeList(Context context, AttributeSet attributeSet, int i3, com.tencent.mobileqq.selectfriend.relationlist.model.a aVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3, aVar);
    }

    @Override // com.tencent.mobileqq.selectfriend.relationlist.BaseRelationSectionedNodeList
    public boolean a(int groupPos) {
        PinnedHeaderExpandableListView pinnedHeaderExpandableListView;
        if (b.f285553a[b().b().ordinal()] != 2 || (pinnedHeaderExpandableListView = this.groupListView) == null) {
            return false;
        }
        return pinnedHeaderExpandableListView.expandGroup(groupPos);
    }

    @Override // com.tencent.mobileqq.selectfriend.relationlist.BaseRelationSectionedNodeList
    public void c() {
        if (((QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime()) != null) {
            int i3 = b.f285553a[b().b().ordinal()];
            if (i3 != 1) {
                if (i3 == 2 && this.groupAdapter == null) {
                    GroupedListAdapter groupedListAdapter = new GroupedListAdapter(getContext(), this.groupListView, this.isMultiSelectMode, this.viewModel);
                    this.groupAdapter = groupedListAdapter;
                    PinnedHeaderExpandableListView pinnedHeaderExpandableListView = this.groupListView;
                    if (pinnedHeaderExpandableListView != null) {
                        pinnedHeaderExpandableListView.setAdapter(groupedListAdapter);
                    }
                    GroupedListAdapter groupedListAdapter2 = this.groupAdapter;
                    if (groupedListAdapter2 != null) {
                        groupedListAdapter2.f(this.isMultiSelectMode, false);
                        return;
                    }
                    return;
                }
                return;
            }
            if (this.normalAdapter != null) {
                return;
            }
            NormalListAdapter normalListAdapter = new NormalListAdapter(getContext(), this.viewModel);
            this.normalAdapter = normalListAdapter;
            XListView xListView = this.normalListView;
            if (xListView != null) {
                xListView.setAdapter((ListAdapter) normalListAdapter);
            }
            NormalListAdapter normalListAdapter2 = this.normalAdapter;
            if (normalListAdapter2 != null) {
                normalListAdapter2.e(this.isMultiSelectMode, false);
            }
        }
    }

    @Override // com.tencent.mobileqq.selectfriend.relationlist.BaseRelationSectionedNodeList
    public void d() {
        e.f285562a.l(this.listChangeListener);
        XListView xListView = this.normalListView;
        if (xListView == null) {
            return;
        }
        xListView.setAdapter((ListAdapter) null);
    }

    @Override // com.tencent.mobileqq.selectfriend.relationlist.BaseRelationSectionedNodeList
    public void e(boolean fromNet) {
        GroupedListAdapter groupedListAdapter;
        int i3 = b.f285553a[b().b().ordinal()];
        if (i3 != 1) {
            if (i3 == 2 && (groupedListAdapter = this.groupAdapter) != null) {
                groupedListAdapter.e(fromNet);
                return;
            }
            return;
        }
        NormalListAdapter normalListAdapter = this.normalAdapter;
        if (normalListAdapter != null) {
            normalListAdapter.d(fromNet);
        }
    }

    @Override // com.tencent.mobileqq.selectfriend.relationlist.BaseRelationSectionedNodeList
    public void setMultiSelectMode(boolean targetMode, boolean needAnim) {
        int childCount;
        int childCount2;
        if (this.isMultiSelectMode == targetMode) {
            return;
        }
        this.isMultiSelectMode = targetMode;
        int i3 = b.f285553a[b().b().ordinal()];
        int i16 = 0;
        if (i3 == 1) {
            NormalListAdapter normalListAdapter = this.normalAdapter;
            if (normalListAdapter != null) {
                normalListAdapter.e(targetMode, needAnim);
            }
            XListView xListView = this.normalListView;
            if (xListView == null || !needAnim || xListView.getChildCount() <= 0 || (childCount = xListView.getChildCount()) < 0) {
                return;
            }
            while (true) {
                View childAt = xListView.getChildAt(i16);
                if (childAt instanceof ForwardItemView) {
                    if (this.isMultiSelectMode) {
                        ((ForwardItemView) childAt).e(150L);
                    } else {
                        ((ForwardItemView) childAt).d(150L);
                    }
                }
                if (i16 == childCount) {
                    return;
                } else {
                    i16++;
                }
            }
        } else {
            if (i3 != 2) {
                return;
            }
            GroupedListAdapter groupedListAdapter = this.groupAdapter;
            if (groupedListAdapter != null) {
                groupedListAdapter.f(targetMode, needAnim);
            }
            PinnedHeaderExpandableListView pinnedHeaderExpandableListView = this.groupListView;
            if (pinnedHeaderExpandableListView == null || !needAnim || pinnedHeaderExpandableListView.getChildCount() <= 0 || (childCount2 = pinnedHeaderExpandableListView.getChildCount()) < 0) {
                return;
            }
            while (true) {
                View childAt2 = pinnedHeaderExpandableListView.getChildAt(i16);
                if (childAt2 instanceof ForwardItemView) {
                    if (this.isMultiSelectMode) {
                        ((ForwardItemView) childAt2).e(150L);
                    } else {
                        ((ForwardItemView) childAt2).d(150L);
                    }
                }
                if (i16 == childCount2) {
                    return;
                } else {
                    i16++;
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RelationSectionedNodeList(Context context, AttributeSet attributeSet, int i3, com.tencent.mobileqq.selectfriend.relationlist.model.a model) {
        super(context, attributeSet, i3, model);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(model, "model");
        this.viewModel = new com.tencent.mobileqq.selectfriend.relationlist.vm.a(model);
        this.listChangeListener = new c(model, this);
        if (((QQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime()) != null) {
            int i16 = b.f285553a[model.b().ordinal()];
            if (i16 == 1) {
                XListView xListView = new XListView(context);
                xListView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                this.normalListView = xListView;
                xListView.setDivider(new ColorDrawable(0));
                addView(this.normalListView);
                e.f285562a.a(this.listChangeListener);
                return;
            }
            if (i16 != 2) {
                return;
            }
            PinnedHeaderExpandableListView pinnedHeaderExpandableListView = new PinnedHeaderExpandableListView(context);
            pinnedHeaderExpandableListView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.groupListView = pinnedHeaderExpandableListView;
            pinnedHeaderExpandableListView.setGroupIndicator(new ColorDrawable(0));
            PinnedHeaderExpandableListView pinnedHeaderExpandableListView2 = this.groupListView;
            if (pinnedHeaderExpandableListView2 != null) {
                pinnedHeaderExpandableListView2.setDivider(new ColorDrawable(0));
            }
            addView(this.groupListView);
            e.f285562a.a(this.listChangeListener);
        }
    }
}
